var tableColumns = [{
    field: 'patrolTaskId',
    title: 'patrolTaskId',
    checkbox: true
}, {
    field: 'patrolObjectName',
    title: '被巡查对象',
    sortable: true
}, {
    field: 'patrolObjectType',
    title: '类别',
    sortable: true,
    align: 'center',
    formatter: function(value) {
        return getTableDictionary('patrolObjectType', value); }
}, {
    field: 'agencyName',
    title: '隶属机构',
    sortable: true,
    align: 'center'
}, {
    field: 'patrolObjectAddr',
    title: '巡查地址',
    sortable: true,
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
    title: '联系电话',
    sortable: true,
    align: 'center'
}, {
    field: 'taskLevel',
    title: '任务级别',
    sortable: true,
    align: 'center',
    formatter: function(value) {
        if (value == '0') {
            return '<span style="color:red">' + getTableDictionary('taskLevel', value) + '</span>';
        } else {
            return getTableDictionary('taskLevel', value);
        }
    }
}, {
    field: 'taskCategory',
    title: '任务来源',
    sortable: true,
    align: 'center',
    formatter: function(value, row, index) {
        if (value == '0') {

            return '投诉';
        } else {
            return '经办发起';
        }
    }
}, {
    field: 'taskState',
    title: '任务状态',
    sortable: true,
    align: 'center',
    formatter: function(value) {
        return getTableDictionary('resultFirstInstance', value); }
}, {
    field: 'createdTime',
    title: '日期',
    sortable: true,
    align: 'center',
    hidden: true,
    formatter: function(value) {
        //console.log(value);
        if (value !== null) {
            var date = value.substring(0, 10);
            return date;
        }
    }
}, {
    field: 'patrolStaffName',
    title: '巡查员',
    sortable: true,
    align: 'center'
}, {
    field: 'operatedBy',
    title: '经办人',
    sortable: true,
    align: 'center'
}, {
    field: 'operatedTime1',
    title: '经办时间',
    sortable: true,
    align: 'center',
    formatter: function(value) {
        //console.log(value);
        if (value !== null) {
            var date = value.substring(0, 10);
            return date;
        }
    }
}, {
    field: '#',
    title: '操作',
    formatter: function(value, row, index) {
        //已分配
        var str;
        if (row.taskState == '1') {
            if (row.taskLevel == '0') { //专项
                str = "<a href=\"#\" name=\"opera\" class=\"easyui-linkbutton\" onclick=\"zx(\'" + index + "\');stopBubble();\">详情</a>" + "&nbsp;" +
                    "<a href=\"#\" name=\"opera\" class=\"easyui-linkbutton\" disabled=\"true\" onclick=\"doLoadPicture(\'' + index + '\')\"><span style=\"color:black\">分配</span></a>";
            }
            if (row.taskLevel == '1') { //普通
                str = "<a href=\"#\" name=\"opera\" class=\"easyui-linkbutton\" onclick=\"pt(\'" + index + "\');stopBubble();\">详情</a>" + "&nbsp;" +
                    "<a href=\"#\" name=\"opera\" class=\"easyui-linkbutton\" disabled=\"true\" onclick=\"doLoadPicture(\'' + index + '\')\"><span style=\"color:black\">分配</span></a>";
            }
            return str;
        } //未分配
        if (row.taskState == '0') {
            if (row.taskLevel == '0') { //专项
                str = "<a href=\"#\" name=\"opera\" class=\"easyui-linkbutton\" onclick=\"zx(\'" + index + "\');stopBubble();\">详情</a>" + "&nbsp;" +
                    "<a href=\"#\" name=\"opera\" class=\"easyui-linkbutton\" onclick=\"doLoadPicture(\'" + index + "\');stopBubble();\">分配</a>";
            }
            if (row.taskLevel == '1') { //普通
                str = "<a href=\"#\" name=\"opera\" class=\"easyui-linkbutton\" onclick=\"pt(\'" + index + "\')\">详情</a>" + "&nbsp;" +
                    "<a href=\"#\" name=\"opera\" class=\"easyui-linkbutton\" onclick=\"doLoadPicture(\'" + index + "\');stopBubble();\">分配</a>";
            }
            return str;
        }
    }
}];
$(function() {
    initGridSet({
        id: 'userList', //表格id
        title: '任务分配', //表格头
        idField: 'patrolTaskId', //	表格主键     
        columns: tableColumns, //	表格列
        singleSelect: false,
        url: portalServiceUrl + "/api/v1/patrolTasks", //	配置表格默认查询参数
        type: 'post', //	表格默认查询参数
        query: { //	表格默认查询参数
            patrolObjectName: '', //被巡查对象
            patrolObjectType: '0,1,2,3', //类别
            patrolObjectId: '', //身份证/编号
            patrolObjectPhone: '', //联系电话
            operatedTime: '', //经办时间
            taskState: '0,1', //任务状态
            patrolStaffName: '', //巡查员姓名
            taskLevel: '0,1',
            page: TableObj.page,
            pageSize: TableObj.pageSize
        }
    }); //初始化表格配置，多表格可重复调用，传入不同的参数

    TableObj = getGridObjById('userList'); //TableObj切换当前表格为激活状态
    initDataGrid(); //初始化表格
    loadGridData(); //加载表格数据
});

function loadTable1() {
    var tableColumn = [{
        field: 'id',
        title: 'id',
        checkbox: true
    }, {
        field: 'trueName',
        title: '分配人姓名',
        sortable: false,
        align: 'center',
        width: 250
    }];

    var tableDataa = [];
    $('#List').datagrid({
        idField: 'id',
        title: '',
        //url : reqUrl,		
        data: tableDataa,
        fit: true,
        queryParams: {},
        loadMsg: '',
        pageSize: 10,
        pagination: false,
        pageList: [10, 20, 30],
        //sortName : 'createDate',
        //sortOrder : 'desc',
        nowrap: true,
        rownumbers: false,
        singleSelect: true,
        //fitColumns : false,
        showFooter: true,
        frozenColumns: [
            []
        ],
        columns: [tableColumn],
        onLoadSuccess: function(data) {
            $("#List").datagrid("clearSelections");
        },
        onClickRow: function(rowIndex, rowData) {
            TableObj.rowIndex = rowIndex;
            TableObj.rowData = rowData;
            rowid = rowData.id;
            gridname = 'List';
        },
        onCheck: function(rowIndex, rowData) {
            TableObj.rowIndex = rowIndex;
            TableObj.rowData = rowData;
        },
        onBeforeEdit: function(index, row) {
            row.editing = true;
            updateActions(index);
        },
        onAfterEdit: function(index, row) {
            row.editing = false;
            updateActions(index);
        },
        onCancelEdit: function(index, row) {
            row.editing = false;
            updateActions(index);
        }
    });

}

function loadTable2() {

    var tableColumn = [{
        field: 'id',
        title: 'id',
        checkbox: true
    }, {
        field: 'trueName',
        title: '分配人姓名',
        sortable: false,
        align: 'center',
        width: 250
    }];

    var tableDataa = [];
    $('#List2').datagrid({
        idField: 'id',
        title: '',
        //url : reqUrl,		
        data: tableDataa,
        fit: true,
        queryParams: {},
        loadMsg: '',
        pageSize: 10,
        pagination: false,
        pageList: [10, 20, 30],
        //sortName : 'createDate',
        //sortOrder : 'desc',
        //nowrap : true, 
        //rownumbers : false,
        singleSelect: true,
        //fitColumns : false,
        //showFooter : true,
        frozenColumns: [
            []
        ],
        columns: [tableColumn],
        onLoadSuccess: function(data) {
            $("#List2").datagrid("clearSelections");
        },
        onClickRow: function(rowIndex, rowData) {
            TableObj.rowIndex = rowIndex;
            TableObj.rowData = rowData;
            rowid = rowData.id;
            gridname = 'List2';
        },
        onCheck: function(rowIndex, rowData) {
            TableObj.rowIndex = rowIndex;
            TableObj.rowData = rowData;
        },
        onBeforeEdit: function(index, row) {
            row.editing = true;
            updateActions(index);
        },
        onAfterEdit: function(index, row) {
            row.editing = false;
            updateActions(index);
        },
        onCancelEdit: function(index, row) {
            row.editing = false;
            updateActions(index);
        }
    });

}
