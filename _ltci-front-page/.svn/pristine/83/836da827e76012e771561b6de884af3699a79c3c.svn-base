var dg = $('#userList');
var tableColumns = [{
        field: 'id',
        title: 'id',
        hidden: true
    }, {
        field: 'roleCode',
        title: '角色编码'
            //width:180
    }, {
        field: 'roleName',
        title: '角色名称'
            //width:180
    }, {
        field: 'roleDescribe',
        title: '角色描述'
            //width:174
    }, {
        field: 'cz',
        title: '操作',
        align: 'center',
        formatter: function(value, row, index) {
            var str = '<a href=\"#\" name=\"opera\" class=\"easyui-linkbutton\" onclick=\"zx(\'' + index + '\')\">用户信息</a>';
            return str;
        }
    }

];
/*var dg=$('#userList')
			var tableData = [];
		$(function() {
			dg.datagrid({
				idField: 'id',
				title: '角色管理',
				data: doLoading(),	
				queryParams: {},				
				pageSize: 10,
				pagination: true,
				pageList: [10, 20, 30],
				sortName: 'createDate',
				sortOrder: 'desc',
				rownumbers: true,
				loadMsg:'',
				fit:true,
				singleSelect: true,
				striped: true,
				showFooter: true,
				frozenColumns: [[]],
				columns: [tableColumns],
				onLoadSuccess: function(data) {
					$("#userList").datagrid("clearSelections");
					$(".easyui-linkbutton").linkbutton();
				},
				onClickRow: function(rowIndex, rowData) {
					gridname = 'userList';
				},
				onCheck:function(rowIndex,rowData){
					vue_id=rowData.id
				}
			});	
			getGridPager('userList', doLoading)
		});*/

$(function() {
    initGridSet({
        id: 'userList', //表格id
        title: '角色管理', //表格头
        idField: 'id', //	表格主键
        columns: tableColumns, //	表格列
        url: portalServiceUrl + "/api/v1/roles/list", //	配置表格默认查询参数
        type: 'post', //	表格默认查询参数
        query: { //	表格默认查询参数
            page: TableObj.page,
            pageSize: TableObj.pageSize
        }
    }); //初始化表格配置，多表格可重复调用，穿入不同的obj即可

    TableObj = getGridObjById('userList'); //TableObj切换当前表格为激活状态
    initDataGrid(); //初始化表格
    loadGridData(); //加载表格数据
});
