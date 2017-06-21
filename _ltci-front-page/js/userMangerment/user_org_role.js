/*function doLoading(){
		var s = window.location.href.split("?")[1] + "&page=" + 1 + "&pageSize=" + 10;
		console.log(s)
		var url = portalServiceUrl + "/api/v1/users/list";
		sendAjax(url, "post", s, function(data) {
			gridLoadData('feeDetailList', data)
		})
}*/

var tableColumns = [{
    field: 'id',
    title: 'id',
    hidden: true
}, {
    field: 'userName',
    title: '用户名'
}, {
    field: 'trueName',
    title: '真实姓名'
}, {
    field: 'department',
    //formatter:'formatDepartment',
    formatter: function(value, row, index) {
        if (row.department) {
            return value.name;
        } else {
            return value;
        }
    },
    title: '所属部门'
        //width: 50
}, {
    field: 'mobile',
    title: '手机号码'
        //width: 50
}, {
    field: 'telephone',
    title: '电话号码'
        //width: 60
}, {
    field: 'email',
    title: '邮箱地址'
        //width: 70
}, {
    field: 'sex',
    title: '性别',
    formatter: function(value) {
        return getTableDictionary('userSex', value); }
}];

/*  $(function() {
   var dg = $('#feeDetailList')
	$('#feeDetailList').datagrid({
		idField : 'id',
		data : [],
		pageSize : 10,
		pagination : true,
		loadMsg:'',
		pageList : [ 10, 20, 30 ],
		rownumbers : true,
		singleSelect : true,
		showFooter : true,
		fit:true,
		columns : [ tableColumns ],
		onLoadSuccess : function(data) {
			$("#feeDetailList").datagrid("clearSelections");
		},
		onCheck : function(row) {
		}
	});
	getGridPager('feeDetailList',doLoading) //设置表格分页数据
	doLoading();
});*/
$(function() {
    initGridSet({
        id: 'feeDetailList', //表格id
        //title:'用户',表格头
        idField: 'id', //	表格主键
        columns: tableColumns, //	表格列
        url: portalServiceUrl + "/api/v1/users/list", //	配置表格默认查询参数
        type: 'post', //	表格默认查询参数
        query: { //	表格默认查询参数
            //applicationStatus: '2,4,5',//默认查询参数
            //actionType:1,
            //userName : "",
            departmentid: getUrlParam("departmentid"),
            roleCode: getUrlParam("roleCode"),
            page: 1,
            pageSize: 10
        }
    }); //初始化表格配置，多表格可重复调用，穿入不同的obj即可

    TableObj = getGridObjById('feeDetailList'); //TableObj切换当前表格为激活状态
    initDataGrid(); //初始化表格
    loadGridData(); //加载表格数据
});
