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
    align: 'center',
    formatter: function(value) {
        return getTableDictionary('patrolObjectType', value); }
}, {
    field: 'agencyName',
    title: '隶属机构',
    align: 'center'
}, {
    field: 'patrolObjectAddr',
    title: '巡查地址',
    align: 'center'
}, {
    field: 'patrolObjectId',
    title: '身份证/编号',
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
    align: 'center'
}, {
    field: 'taskLevel',
    title: '任务级别',
    align: 'center',
    formatter: function(value) {
        if (value == "0") {
            return '<span style="color:red">专项</span>';
        } else {
            return '<span>普通</span>';
        }
    }
}, {
    field: 'taskCategory',
    title: '任务来源',
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
    align: 'center',
    formatter: function(value) {
        return getTableDictionary('resultFirstInstance', value); }
}, {
    field: 'patrolStaffName',
    title: '巡查员',
    align: 'center'
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
    field: 'jieguo',
    title: '巡查结果',
    formatter: function(value, row, index) {
        console.log(row.taskState);
        var str;
        if (row.taskState == "2" || row.taskState == "1") {
            str = '<a href="#" name="opera"  onclick="resources(\'' + index + '\')">录入</a>';
        }
        if (row.taskState == "3") {
            str = '<a href="#" name="opera"  onclick="chakan(\'' + index + '\')">查看</a>';
        }
        return str;
    },

}, {
    field: '#',
    title: '操作',
    formatter: function(value, row, index) {
        var str;
        if (row.taskLevel == '0') { //专项
            str = '<a href=\"#\" name=\"opera\" class=\"easyui-linkbutton\" onclick=\"zx(\'' + index + '\')\">详情</a>';
        }
        if (row.taskLevel == '1') { //普通
            str = '<a href=\"#\" name=\"opera\" class=\"easyui-linkbutton\" onclick=\"pt(\'' + index + '\')\">详情</a>';
        }
        return str;
    }
}];
$(function() {
    initGridSet({
        id: 'userList', //表格id
        title: '任务执行', //表格头
        idField: 'patrolTaskId', //	表格主键     
        columns: tableColumns, //	表格列
        showFooter: false,
        url: portalServiceUrl + "/api/v1/patrolTasks", //	配置表格默认查询参数
        type: 'post', //	表格默认查询参数
        query: { //	表格默认查询参数
            patrolObjectName: '', //被巡查对象
            patrolObjectType: '0,1,2,3', //类别
            patrolObjectId: '', //身份证/编号
            patrolObjectPhone: '', //联系电话
            operatedTime: '', //经办时间
            taskState: '1,2,3', //任务状态
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
