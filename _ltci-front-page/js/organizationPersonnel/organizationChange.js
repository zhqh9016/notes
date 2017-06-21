	var tableColumns = [{
	        field: 'serialNum',
	        title: 'serialNum',
	        hidden: true
	    }, {
	        field: 'agencyCode',
	        title: '机构编码',
	        formatter: function(value) {
	            if (value === undefined) {
	                return "";
	            }
	            if (value.length > 6) {
	                return value.substr(6);
	            }
	        },
	        align: 'center'
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
	        field: 'agencyState',
	        title: '受理状态',
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
	            var str = '';
	            if (row.agencyState == 4) {
	                str = '<a href="#" name="opera" class="easyui-linkbutton" disabled="true">操作</a>';
	            } else {
	                str = '<a href="javascript:;"  class="easyui-linkbutton" onclick="accepteance(' + index + ')">操作</a>';
	            }
	            return str;
	        }
	    }

	];

	/*var dg = $('#searchList');
	var tableData = [];*/
	/*$(function() {
		$('#searchList').datagrid({
			idField: 'staffCode',
			title: '定点机构变更',
			data: tableData,
			fit: true,
			loadMsg: '',
			pageSize: 10,
			pagination: true,
			pageList: [10, 20, 30],
			fit:true,
			rownumbers: true,
			singleSelect: true,
			striped: true,
			showFooter: true,
			columns: [tableColumns],
			onLoadSuccess: function(data) {
				dg.datagrid("clearSelections");
				$(".easyui-linkbutton").linkbutton();
			},
			onClickRow: function(rowIndex, rowData) {
				rowSerialNum = rowData.serialNum;
				rowOrgCode = rowData.orgCode;
				rowAgencyCode = rowData.agencyCode;
				TableObj.rowIndex = rowIndex;
				TableObj.rowData = rowData;
			},
			onCheck: function(rowIndex, rowData) {
				TableObj.rowIndex = rowIndex;
				TableObj.rowData = rowData;
			}
		});
		$("#agencyState").combobox('setValue','2');//受理状态，默认查询未处理（值为1）的数据
		getGridPager('searchList', doLoading); //设置表格分页数据
		doLoading();
	});*/
	$(function() {
	    initGridSet({
	        id: 'searchList', //表格id
	        title: '定点机构变更', //表格头
	        idField: 'staffCode', //	表格主键
	        columns: tableColumns, //	表格列
	        url: portalServiceUrl + "/api/v1/agency/audit/list", //	配置表格默认查询参数
	        type: 'get', //	表格默认查询参数
	        query: { //	表格默认查询参数
	            //			applicationStatus: '2,4,5',//默认查询参数
	            //			actionType:2,
	            //			page: TableObj.page,
	            //			pageSize: TableObj.pageSize


	            agencyName: '', //机构名称
	            agencyLevel: '', //定点机构类别
	            agencyServiceType: '', //定点服务机构类型
	            agencyType: '', //机构类型（多个逗号分隔）
	            agencyState: '2,4,5', //确认状态
	            applyBeginDates: '', //经办开始日期
	            applyEndDates: '', //经办结束日期
	            actionType: 2,
	            page: TableObj.page,
	            pageSize: TableObj.pageSize,

	        }
	    }); //初始化表格配置，多表格可重复调用，穿入不同的obj即可
	    TableObj = getGridObjById('searchList'); //TableObj切换当前表格为激活状态
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
