	var tableColumns = [{
	        field: 'serialNum',
	        title: 'serialNum',
	        hidden: true
	    }, {
	        field: 'agencyName',
	        title: '申请机构名称',
	        align: 'center'
	    }, {
	        field: 'agencyLevel',
	        title: '定点机构类别',
	        formatter: function(value) {
	            return getTableDictionary(this.field, value); },
	        align: 'center'
	    }, {
	        field: 'agencyServiceType',
	        title: '定点服务机构类型',
	        formatter: function(value) {
	            return transDictionary(value); },
	        align: 'center'
	    }, {
	        field: 'agencyType',
	        title: '机构类型',
	        formatter: function(value) {
	            return transDictionarys(value); },
	        align: 'center'
	    }, {
	        field: 'practiceLicense',
	        title: '机构许可证编号',
	        align: 'center'
	    }, {
	        field: 'agencyApplicat',
	        title: '申请人'
	    }, {
	        field: 'agencyApplyDate',
	        title: '申请日期',
	        align: 'center'
	    }, {
	        field: 'operatedBy',
	        title: '经办人',
	        align: 'center'
	    }, {
	        field: 'operatedTime',
	        title: '经办时间',
	        align: 'center',
	        formatter: function(value) {
	            return getTableDictionary("resultFirstInstance", value); }
	    }, {
	        field: 'agencyState',
	        title: '确认状态',
	        //formatter: function(value) { return getTableDictionary(this.field, value) },
	        formatter: function(value, row, index) {
	            var str = '';
	            if (value == '4') {
	                str = "审核通过";
	            } else if (value == '5') {
	                str = '<a href="#" name="opera" onclick="cause(\'' + index + '\',0)" style="color:#FF0000">审核不通过</a> ';
	            } else if (value == '2') {
	                str = "已受理";
	            }
	            return str;
	        },
	        align: 'center'
	    }, {
	        field: 'cz',
	        title: '操作',
	        align: 'center',
	        formatter: function(value, row, index) {
	            var str = '<a href="#" name="opera" class="easyui-linkbutton" onclick="accepteance(\'' + index + '\')">操作</a>';
	            return str;
	        }
	    }

	];
	/*$(function() {	
		var dg = $('#userList')
		var tableData = doLoading()
		//var tableData = [];
		dg.datagrid({
			idField: 'serialNum',
			title: '定点机构确认',
			data: tableData,
			fit: true,
			loadMsg: '',
			pageSize: 10,
			pagination: true,
			pageList: [10, 20, 30],
			rownumbers: true,
			singleSelect: true,		
			striped: true,
			showFooter: true,
			columns: [tableColumns],
			onLoadSuccess: function(data) {
				 $(".easyui-linkbutton").linkbutton();
				$("#userList").treegrid("clearSelections");
			},
			onClickRow: function(rowIndex, rowData) {
				rowSerialNum = rowData.serialNum;
				rowOrgCode = rowData.orgCode;
				rowAgencyCode = rowData.agencyCode;
				gridname = 'userList';
			},
			onCheck: function(rowIndex, rowData) {

			},
			onUncheck: function(rowIndex, rowData) {
				//alert(rowIndex)
			},
			onCheckAll: function(rows) {
				//alert(rows)
			},
			onUncheckAll: function(rows) {
				//alert(rows)
			}
		});
		getGridPager('userList', doLoading) //设置表格分页数据
	});*/

	$(function() {
	    initGridSet({
	        id: 'userList', //表格id
	        title: '定点机构确认', //表格头
	        idField: 'serialNum', //	表格主键
	        columns: tableColumns, //	表格列
	        url: portalServiceUrl + "/api/v1/agency/audit/list", //	配置表格默认查询参数
	        type: 'get', //	表格默认查询参数
	        query: { //	表格默认查询参数
	            //			agencyState: '2,4,5',//默认查询参数
	            //			actionType:1,
	            //			page: TableObj.page,
	            //			pageSize: TableObj.pageSize
	            agencyName: '', //机构名称
	            agencyLevel: '', //定点机构类别
	            agencyServiceType: '', //定点服务机构类型
	            agencyType: '', //机构类型（多个逗号分隔）
	            agencyState: '2,4,5', //确认状态
	            operatedBeginDate: '', //经办开始日期
	            operatedEndDate: '', //经办结束日期
	            actionType: 1,
	            page: TableObj.page,
	            pageSize: TableObj.pageSize,

	        }
	    }); //初始化表格配置，多表格可重复调用，穿入不同的obj即可

	    TableObj = getGridObjById('userList'); //TableObj切换当前表格为激活状态
	    initDataGrid(); //初始化表格
	    loadGridData(); //加载表格数据
	});

	function transDictionary(s) { //定义方法，传入字符串值，返回对应数据字典
	    if (!s) return '';
	    var arr = s.split(','); //[1,2]
	    var str = "";
	    for (var i = 0; i < arr.length; i++) {
	        if (i !== 0) str += ",";
	        str += getTableDictionary('agencyServiceType', arr[i]);
	    }
	    return str;
	}

	function transDictionarys(s) { //定义方法，传入字符串值，返回对应数据字典
	    if (!s) return '';
	    var arr = s.split(','); //[1,2]
	    var str = "";
	    for (var i = 0; i < arr.length; i++) {
	        if (i !== 0) str += ",";
	        str += getTableDictionary('agencyType', arr[i]);
	    }
	    return str;
	}
