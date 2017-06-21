$(function() {
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
            return getTableDictionary('userSex', value);
        }
    }, {
        field: 'isAuthority',
        title: '是否大屏幕访问',
        formatter: function(value) {
            return getTableDictionary('isAuthority', value);
        }
    }];
    var dg = $('#userList');
    var tableData = [];
    dg.datagrid({
        idField: 'id',
        title: '用户管理',
        data: tableData,
        queryParams: {},
        pageSize: 10,
        pagination: true,
        pageList: [10, 20, 30],
        sortName: 'createDate',
        selectOnCheck: true,
        loadMsg: '',
        fit: true,
        rownumbers: true,
        singleSelect: true,
        striped: true,
        showFooter: true,
        frozenColumns: [
            []
        ],
        columns: [tableColumns],
        onLoadSuccess: function(data) {
            $(".easyui-linkbutton").linkbutton();
            $("#userList").treegrid("clearSelections");
        },
        onClickRow: function(rowIndex, rowData) {
            TableObj.rowIndex = rowIndex;
            TableObj.rowData = rowData;
        },
        onCheck: function(rowIndex, rowData) {
            TableObj.rowIndex = rowIndex;
            TableObj.rowData = rowData;
        }
    });
    getGridPager('userList', doLoading); //设置表格分页数据 
    doLoading();
});
