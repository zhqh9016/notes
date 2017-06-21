var tableColumns = [{
    field: 'id',
    title: 'id',
    hidden: true
}, {
    field: 'typeName',
    title: '类型名称',
    //width:150,
}, {
    field: 'type',
    title: '类型值',
    //width:150,
}, {
    field: 'valueName',
    title: '属性名称',
    //width:150,
}, {
    field: 'value',
    //width:100,
    title: '属性值'
}, {
    field: 'isValid',
    //width:100,
    formatter: function(value) {
        return getTableDictionary(this.field, value); },
    title: '是否有效'
}];

//  $('#userList').datagrid({
//      idField: 'id',
//      title: '查询',
//      data: tableData,
//      loadMsg:'',
//      pagination: true,
//      pageList: [10, 20, 30],
//      rownumbers: true,
//      fit:true,
//      singleSelect: true,
//      showFooter: true,
//      columns: [tableColumns],
//      onLoadSuccess: function(data) {
// // dg.datagrid("clearSelections");
// $(".easyui-linkbutton").linkbutton();
//      },
//      onClickRow: function(rowIndex, rowData) {
//          rowid = rowData.id;
//          gridname = 'userList';
// TableObj.rowIndex = rowIndex;
// TableObj.rowData = rowData;
//      }
//  });


/*var dg = $('#userList');
var tableData = [];
$(function() {

	dg.datagrid({
		idField: 'id',
		title: '查询',
		data: tableData,
		pageSize: 10,
		pagination: true,
		pageList: [10, 20, 30],
		rownumbers: true,
		loadMsg: '',
		singleSelect: false,
		fit: true,
		showFooter: true,
		columns: [tableColumns],
		onLoadSuccess: function(data) {
			dg.datagrid("clearSelections");
			$(".easyui-linkbutton").linkbutton();
		},
		onClickRow: function(rowIndex, rowData) {
			//TableObj.rowIndex = rowIndex;
			//TableObj.rowData = rowData;
            //rowid = rowData.id;
            gridname = 'userList';
		},
		onCheck: function(rowIndex, rowData) {
			//TableObj.rowIndex = rowIndex;
			//TableObj.rowData = rowData;
			//app.vue_rowIndex=rowIndex;
			//app.vue_id=rowData.id;
			//app.vue_type=rowData.type;
			//app.vue_typeName=rowData.typeName;
			//app.vue_value=rowData.value;
			//app.vue_valueName=rowData.valueName;
		}
	});
	getGridPager('userList', doLoading); //设置表格分页数据
	doLoading();
});*/

$(function() {
    initGridSet({
        id: 'userList', //表格id
        title: '数据字典', //表格头
        idField: 'id', //	表格主键
        columns: tableColumns, //	表格列
        url: systemServiceUrl + "/api/v1/dictionary", //	配置表格默认查询参数
        type: 'post', //	表格默认查询参数
        query: { //	表格默认查询参数
            queryFlag: "all",
            page: TableObj.page,
            pageSize: TableObj.pageSize
        }
    }); //初始化表格配置，多表格可重复调用，穿入不同的obj即可

    TableObj = getGridObjById('userList'); //TableObj切换当前表格为激活状态
    initDataGrid(); //初始化表格
    loadGridData(); //加载表格数据
});
