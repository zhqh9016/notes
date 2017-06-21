		var tableColumns = [{
		    field: 'id',
		    title: 'id',
		    hidden: true
		}, {
		    field: 'serviceCode',
		    title: '服务项目编码',
		    align: 'center'
		}, {
		    field: 'serviceName',
		    title: '服务项目名称',
		    align: 'center'
		}, {
		    field: 'serviceType',
		    title: '服务项目类型',
		    formatter: function(value) {
		        return getTableDictionary(this.field, value); },
		    align: 'center'
		}, {
		    field: 'frequency',
		    title: '服务次数',
		    align: 'center'
		}, {
		    field: 'taskTime',
		    title: '持续时间',
		    align: 'center'
		}, {
		    field: 'description',
		    title: '服务描述'
		}, {
		    field: 'startTime',
		    title: '服务开始时间',
		    align: 'center'
		}, {
		    field: 'endTime',
		    title: '服务结束时间',
		    align: 'center'
		}, {
		    field: 'chargeType',
		    title: '费用类别',
		    align: 'center',
		    formatter: function(value) {
		        return getTableDictionary(this.field, value); }
		}, {
		    field: 'chargeLevel',
		    title: '收费项目等级',
		    align: 'center',
		    formatter: function(value) {
		        return getTableDictionary(this.field, value); }
		}, {
		    field: 'limitPrice',
		    title: '最高限价',
		    align: 'center',
		    formatter: function(value) {
		        var str = value.toFixed(2);
		        return str;
		    }
		}, {
		    field: 'price',
		    title: '项目单价',
		    align: 'center',
		    formatter: function(value) {
		        var str = value.toFixed(2);
		        return str;
		    }
		}, {
		    field: 'isValid',
		    title: '有效标识',
		    align: 'center',
		    formatter: function(value) {
		        return getTableDictionary(this.field, value); }
		}, {
		    field: 'operatedBy',
		    title: '经办人',
		    align: 'center'
		}, {
		    field: 'operatedTime',
		    title: '经办时间',
		    align: 'center'
		}];
		/*var dg = $('#userList');
		var tableData = [];
$(function() {
		dg.datagrid({
			idField: 'id',
			title: '护理目录管理',
			data: tableData,
			fit: true,
			pageSize: 10,
			loadMsg:'',
			pageList: [10, 20, 30],
			rownumbers : true,
			singleSelect : true,
			showFooter : false,	
			pagination:true,
			frozenColumns : [ [] ],
			columns: [tableColumns],
	        onLoadSuccess: function(data) {
	          // $(".easyui-linkbutton").linkbutton();
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
		getGridPager('userList',doLoading); //设置表格分页数据
		doLoading();
	});*/
		$(function() {
		    initGridSet({
		        id: 'userList', //表格id
		        title: '护理目录管理', //表格头
		        idField: 'id', //	表格主键
		        columns: tableColumns, //	表格列
		        showFooter: false,
		        url: portalServiceUrl + "/api/v1/serviceItem/list", //	配置表格默认查询参数
		        type: 'post', //	表格默认查询参数
		        query: { //	表格默认查询参数
		            isValid: "1",
		            page: TableObj.page,
		            pageSize: TableObj.pageSize
		        }
		    }); //初始化表格配置，多表格可重复调用，穿入不同的obj即可

		    TableObj = getGridObjById('userList'); //TableObj切换当前表格为激活状态
		    initDataGrid(); //初始化表格
		    loadGridData(); //加载表格数据
		});
