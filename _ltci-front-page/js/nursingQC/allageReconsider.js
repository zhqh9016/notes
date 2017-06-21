	var tableColumns = [{
	        field: 'patrolTaskId',
	        title: 'patrolTaskId',
	        hidden: true
	    }, {
	        field: 'patrolObjectName',
	        title: '被巡查对象',
	        align: 'center'
	    }, {
	        field: 'patrolObjectType',
	        title: '类别',
	        formatter: function(value) {
	            return getTableDictionary(this.field, value); },
	        align: 'center'
	    }, {
	        field: 'agencyName',
	        title: '隶属机构',
	        align: 'center'
	    }, {
	        field: 'patrolObjectAddr',
	        title: '地址',
	        align: 'center'
	    }, {
	        field: 'patrolObjectId',
	        title: '身份证/编号',
	        sortable: true,
	        align: 'center',
	        formatter: function(value, row, index) {
	            if (row.patrolObjectType === 0 || row.patrolObjectType == 1) {
	                return row.patrolObjectId;
	            } else if (row.patrolObjectType == 2 || row.patrolObjectType == 3) {
	                return row.idCard;
	            } else {
	                return "";
	            }
	        }
	    }, {
	        field: 'patrolObjectPhone',
	        title: '联系电话'
	    }, {
	        field: 'taskLevel',
	        title: '任务级别',
	        formatter: function(value) {
	            return getTableDictionary(this.field, value); },
	        align: 'center'
	    }, {
	        field: 'taskCategory',
	        title: '任务来源',
	        formatter: function(value) {
	            return getTableDictionary(this.field, value); },
	        align: 'center'
	    }, {
	        field: 'taskState',
	        title: '任务状态',
	        align: 'center',
	        formatter: function(value) {
	            return getTableDictionary("resultFirstInstance", value); }
	    }, {
	        field: 'patrolStaffName',
	        title: '巡查员',
	        align: 'center'
	    }, {
	        field: 'jieGuo',
	        title: '巡查结果',
	        align: 'center',
	        formatter: function(value, rowData, index) {
	            var str = '<a href="#" name="opera"  onclick="chakan(\'' + index + '\')">查看</a>';
	            return str;
	        }

	    }, {
	        field: 'yiJian',
	        title: '复议意见',
	        align: 'center',
	        formatter: function(value, rowData, index) {
	            var str = "";
	            if (rowData.taskState == '6') {
	                str = '<a href="#" name="opera"  onclick="doexpertAssess(\'' + index + '\')">录入</a>';
	            } else {
	                str = '<a href="#" name="opera"  onclick="suggestion(\'' + index + '\')">查看</a>';
	            }
	            return str;
	        }
	    }, {
	        field: 'operatedBy',
	        title: '经办人',
	        align: 'center'
	    }, {
	        field: 'operatedTime1',
	        title: '经办时间',
	        align: 'center',
	        formatter: function(value) {
	            return formatDate(value); }
	    }, {
	        field: 'cz',
	        title: '操作',
	        align: 'center',
	        formatter: function(value, row, index) {
	            var str = '';
	            if (row.taskLevel == '0') { //专项
	                str = '<a href=\"#\" name=\"opera\" class=\"easyui-linkbutton\" onclick=\"zx(\'' + index + '\')\">详情</a>';
	            }
	            if (row.taskLevel == '1') { //普通
	                str = '<a href=\"#\" name=\"opera\" class=\"easyui-linkbutton\" onclick=\"pt(\'' + index + '\')\">详情</a>';
	            }
	            return str;
	        }
	    }

	];

	/*	var dg = $('#userList');
		var tableData = doLoading();
	$(function() {
		dg.datagrid({
			idField: 'patrolTaskId',
			title: '申诉复议',
			data: tableData,
			fit: true,
			queryParams: {},
			pageSize: 10,
			pagination: true,
			loadMsg:'',
			pageList: [10, 20, 30],
			rownumbers: true,
			singleSelect: true,
			fitColumns: true,
			striped: true,
			showFooter: true,
			columns: [tableColumns],
			onLoadSuccess: function(data) {
				 $(".easyui-linkbutton").linkbutton();
				$("#userList").treegrid("clearSelections");
			},
			onClickRow: function(rowIndex, rowData) {
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
		getGridPager('userList', doLoading); //设置表格分页数据

	});*/
	$(function() {
	    initGridSet({
	        id: 'userList', //表格id
	        title: '申诉复议', //表格头
	        idField: 'patrolTaskId', //	表格主键
	        columns: tableColumns, //	表格列
	        url: portalServiceUrl + "/api/v1/patrolTasks", //	配置表格默认查询参数
	        type: 'post', //	表格默认查询参数
	        query: { //	表格默认查询参数
	            taskState: "6,7",
	            patrolObjectType: "0,1,2,3",
	            taskLevel: "0,1",
	            page: TableObj.page,
	            pageSize: TableObj.pageSize
	        }
	    }); //初始化表格配置，多表格可重复调用，穿入不同的obj即可

	    TableObj = getGridObjById('userList'); //TableObj切换当前表格为激活状态
	    initDataGrid(); //初始化表格
	    loadGridData(); //加载表格数据
	});
