$(function() {
	var tableColumns = [{
		field: 'id',
		title: '编号',
		hidden: true
	}, {
		field: 'resName',
		title: '菜单名称'
		//width: 200
	}, {
		field: 'url',
		title: '访问链接',
		//width: 400
	}, {
		field: 'sequence',
		title: '菜单顺序'
		//width: 160
	}, {
		field: 'description',
		title: '菜单描述'
		//width: 300,
	},{
		field: 'isMenu',
		title: '是否是菜单',
		formatter: function(value) { return getTableDictionary(this.field, value) }
	}
	];
	// storage = $.localSt orage;
	// if (!storage) storage = $.cooki eStorage;
	$('#resList').treegrid({
		idField: 'id',
		treeField: 'resName',
		title: '菜单管理',
		//url : reqUrl,
		method: 'get',
		data: doLoading(),
		queryParams: {},
		pageNumber: 1,
		pageSize: 10,
		fit:true,
		loadMsg:'',
		pagination: false,
		pageList: [10, 20, 30],
		sortName: 'createDate',
		sortOrder: 'desc',
		nowrap: true,
		rownumbers: true,
		singleSelect: true,
		striped: true,
		showFooter: true,
		columns: [tableColumns],
		loadFilter: function(data) {
			//'{"status":200,"rows":[{"id":"410ec79138ec4a1e8e2ed1c84d2238fd","parentId":"0","resName":"菜单管理","description":"菜单管理","url":"www.baidu.com","sequence":null,"isMenu":null,"isValid":1,"createBy":"dingding","updateBy":"zhangsan"}],"message":null,"page":1,"pageSize":10,"total":1,"totalPageNum":1}';
			console.log(data.datas);
			if(data.datas === undefined){
				return data;
			}
			var parseData = [];
			var parseDatas = [];
			for(var i = 0; i < data.datas.length; i++) {
				var obj = data.datas[i];
				obj.children = obj.childMenu;
				for(var j = 0; j < obj.childMenu.length; j++){
					var objs = obj.childMenu[j];
					objs.children = objs.childMenu;
					parseDatas[j] = objs;
					parseData[i] =parseDatas[j];
				}
				obj.state = 'closed'; //open
				parseData[i] = obj;
			}
			var retData = {
				total: data.totalDataNum,
				rows: parseData
			};
			//console.log("loadFilter2="+JSON.stringify(retData));
			return retData;
		},
		onLoadSuccess: function(data) {
			//$("#resList").datagrid("clearSelections");
			return false;
		},
		onCheck: function(row) {
			//app.vue_rowIndex = rowData.id
			//console.log("onCheck="+JSON.stringify(row));
		}
	});
});
//________________________________________
$('#addWindow').window({
	title: '新增菜单',
	width: 600,
	height: 400,
	closed: true,
	modal: true,
	collapsible:false,
	minimizable:false,
	maximizable:false
});
$('#editWindow').window({
	title: '编辑菜单',
	width: 600,
	height: 400,
	closed: true,
	modal: true,
	collapsible:false,
	minimizable:false,
	maximizable:false
});

function doLoading() {
	var data0;
	var url = portalServiceUrl + '/api/v1/menu/list';
	sendAjax(url,'get','',function(data){
		data0=data;
	},false);
	return data0;
}

function doSearch() {
	console.log("doSearch");
	tableData = doLoading();
	$('#resList').treegrid('loadData', tableData);
}
	
	
var mothed = {
	doOpenAdd: function() {
		//获取选中行的id
		var rows = $('#resList').treegrid('getSelections');
		if(rows.length == 0) {
			$("#add_parentId").val("0"); //菜单根节点为零
		} else {
		/*	if(rows[0].parentId != 0) {
				$.messager.alert('提示', "不能添加三级菜单！");
				return false;
			} else {}*/
				if(rows.length > 1) {
					showMsg("只能选中一行操作！");
				} else if(rows.length == 1) {
					$("#add_parentId").val(rows[0].id);
				}
		}

		$('#addForm')[0].reset();
		$('#addWindow').window('open');

	},

	doOpenEdit: function() {
		//获取选中行的id					
		if(isCheck()) {
			var row = getSelectionRow();
			if(row == false) {
				$('#editWindow').window('close');
			} else {
				$("#edit_parentId").val(row.id);
				//赋值
				$("#edit_id").val(row.id);
				$("#edit_parentId").val(row.parentId);
				$("#edit_resName").val(row.resName);
				$("#edit_description").val(row.description);
				$("#edit_url").val(row.url);
				$("#edit_sequence").val(row.sequence);
				//$("#edit_isMenu").val(row.isMenu);
				$('#edit_isMenu').combobox("select", row.isMenu);
				$('#editWindow').window('open');
			}
		}
	},
	doAdd: function() {
		if($("#addForm").form("validate")) {
			var httpData = $("#addForm").serialize();
			$.ajax({
				type: 'post',
				url: portalServiceUrl + "/api/v1/ress",
				async: false,
				data: httpData,
				success: function(msg) {
					console.log("success:", msg);
					if(msg.status == "200") {
						$('#addWindow').window('close');
						showMsg("信息添加成功！");
						doSearch();
					} else {
						$.messager.alert('提示', msg.message);
					}
				}
			});
			/*var url =portalServiceUrl + "/api/v1/ress";
			sendAjax(url,"post",httpData,function(tableData){
				if(tableData.status != "200") {
					$.messager.alert('添加状态', tableData.message);
						return false;
				}
				showMsg("目录添加成功！");
					$('#addWindow').window('close');
					loadGridData();
			});*/
		}
	},
	doEdit: function() {
		//获取选中行的id
		//if(!row) return false;
		if($("#editForm").form("validate")) {
			var row = getSelectionRow();
			var httpData = $("#editForm").serialize();
			console.log(httpData);
			$.ajax({
				type: 'put',
				url: portalServiceUrl + "/api/v1/ress/" + row.id,
				async: false,
				data: httpData,
				success: function(msg) {
					console.log("_doEdit_success:", msg);
					if(msg.status == "200") {
						$('#editWindow').window('close');
						showMsg("信息编辑成功！");
						doSearch();
					} else {
						$.messager.alert('提示', msg.message);
					}
				}
			});
		}
	},
	doDelete: function(event) {
		//获取选中行的id
		var row = getSelectionRow();
		if(!row) return false;
		$.messager.confirm('确认', '您确认想要删除记录吗？', function(r) {
			if(r) {
				var url = portalServiceUrl + "/api/v1/ress/" + row.id + "?operatedBy=test";
				sendAjax(url, "delete", "",function(tableData){
					if(tableData.status != "200") {
					$.messager.alert('提示', tableData.message);
					} else {
						showMsg("信息删除成功！");
						$('#resList').treegrid('remove', row.id);
						doSearch();
					}
				});
			}
		});
	},
	doClose: function(objId) {
		$('#' + objId).window('close');
	}
};

function isCheck() {
	var arr = $('#resList').datagrid('getChecked');
	if(arr.length < 1) {
		//showMsg('请选择一行数据再进行操作');
		$.messager.alert('警告', '请选择一行数据再进行操作');
		return false;
	}
	return true;
}

function getSelectionRow() {
	var rows = $('#resList').treegrid('getSelections');
	if(rows.length == 0) {
		$.messager.alert('提示', "请先选中一行");
		return false;
	}
	if(rows.length > 1) {
		showMsg("只能选中一行操作");
		return false;
	}
	return rows[0];
}