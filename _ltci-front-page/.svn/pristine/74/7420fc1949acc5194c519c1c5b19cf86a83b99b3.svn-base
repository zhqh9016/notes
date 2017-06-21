$(function() {
    $('#showInfo').window({
        title: '查看详情',
        width: 800,
        minimizable: false,
        collapsible: false,
        height: 450,
        closed: true,
        //inline:
        // onClose:function(){
        // 	doSearch();
        // },
        modal: true
    });
    // winObj.prompt()

    var tableColumns = [{
        field: 'todoListid',
        title: '111',
        align: 'center',
        hidden: true
    }, {
        field: 'businessCode',
        align: 'center',
        hidden: true,
        title: '待办事项1'
    }, {
        field: 'title',
        width: 500,
        align: 'left',
        title: '待办事项'
    }, {
        field: 'type',
        width: 100,
        align: 'center',
        formatter: function(value) {
            return getTableDictionary('todoListType', value); },
        title: '类型'
    }, {
        field: 'createdTime',
        width: 200,
        formatter: function(value) {
            return formatDate(value); },
        align: 'center',
        title: '时间'
    }, {
        field: 'url',
        title: '操作',
        align: 'center',
        formatter: function(value, row, index) {
            var str = "<a href=\"#\" name=\"opera\" class=\"easyui-linkbutton\" onclick=\"openTask('" + index + "');stopBubble();\">查看</a>";
            return str;
        }
    }];
    var dg = $('#userList');
    var tableData = [];
    dg.datagrid({
        idField: 'todoListid',
        data: tableData,
        loadMsg: '',
        pageSize: 10,
        pagination: false,
        pageList: [10, 20, 30],
        rownumbers: true,
        singleSelect: true,
        // striped: true,
        showFooter: true,
        columns: [tableColumns],
        onLoadSuccess: function(data) {
            dg.datagrid("clearSelections");
            $(".easyui-linkbutton").linkbutton();
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

function openTask(inxex) {
    //app.vue_ url
    //app.vue_busin essCode
    //if(isCheck){
    //../treatmentApply/bindMsgDetails.html
    var row = $('#userList').datagrid('getRows')[inxex];
    var url = '../treatmentApply/' + getDictionaryValue('toDoList', row.businessType);
    console.log('url:', url);
    if (row.jumpWay == '_blank') {
        $('#showInfo_iframe').attr('src', url + "?applicationCode=" + row.businessCode);
        $('#showInfo').window('open');
    } else if (row.type == '02') {
        $('#iframe0', parent.document).attr('src', url + "?applicationCode=" + row.businessCode);
    }
    //}
}

function isCheck() {
    var arr = $('#userList').datagrid('getChecked');
    if (arr.length < 1) {
        $.messager.alert('警告', '请选择一行数据再进行操作');
        return false;
    }
    return true;
}

function doSearch() {
    TableObj.page = 1;
    TableObj.pageSize = 10;
    doLoading();
}

function doLoading() {
    sendAjax(portalServiceUrl + "/api/v1/todoList", "get", "", function(data) {
        gridLoadData('userList', data);
    });
}
