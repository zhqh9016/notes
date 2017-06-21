var tableColumns = [{
        field: 'evaluateTaskid',
        title: 'evaluateTaskid',
        checkbox: true
    }, {
        field: 'insuredPersonName',
        align: 'center',
        title: '申请人'
    }, {
        field: 'mobile',
        align: 'center',
        title: '电话'
    }, {
        field: 'address',
        align: 'center',
        title: '现住址'
    }, {
        field: 'operatedOrg',
        align: 'center',
        title: '经办机构'
    }, {
        field: 'operatedBy',
        align: 'center',
        title: '经办人'
    }, {
        field: 'operatedTime',
        align: 'center',
        formatter: function(value) {
            return formatDate(value); },
        title: '经办时间'
    }, {
        field: 'taskState',
        align: 'center',
        title: '任务状态',
        formatter: function(value) {
            return getTableDictionary(this.field, value); }
    }, {
        field: 'taskDeadline',
        title: 'taskDeadline',
        hidden: true
    }, {
        field: 'taskDeadlineDay',
        title: '任务期限',
        align: 'center',
        formatter: function(value, rowData, index) {
            if (rowData.taskDeadline == '1') { //任务期限isTaskDeading 是1 否0
                return '<span style="color:red">' + value + '</span>';
            } else {
                return value;
            }
        }
    }, {
        field: 'evaluateAgencyName',
        align: 'center',
        title: '评估机构'
    }, {
        field: 'reevalueateResult',
        title: 'reevalueateResult',
        hidden: true
    }, {
        field: 'insuredPersonCode',
        title: '申请人编码',
        hidden: true
    }, {
        field: 'reevaluateParentCode',
        title: 'reevaluateParentCode',
        hidden: true
    }, {
        field: 'sendTime',
        title: '发送时间',
        hidden: true
    }, {
        field: 'evaluateAgencyCode',
        title: 'evaluateAgencyCode',
        hidden: true
    },

    {
        field: 'evaluateTaskCode',
        title: 'evaluateTaskCode',
        hidden: true
    }, {
        field: 'createdBy',
        title: '创建人',
        hidden: true
    },

    {
        field: 'isReevaluate',
        title: 'isReevaluate',
        hidden: true
    }, {
        field: 'applicationCode',
        title: 'applicationCode',
        hidden: true
    }, {
        field: 'act',
        title: '操作',
        align: 'center',
        formatter: function(value, rowData, index) {
            var html = '';
            if (rowData.taskState == "00") { //评估任务状态 00未发送 
                html = '<a href="javascript:;" class="easyui-linkbutton" name="" onclick="chooseOneOrganization(' + index + ');stopBubble();">选择机构</a>';
                return html;
            } else {
                html = '<span onclick="stopBubble()"><a href="javascript:;" class="easyui-linkbutton" name="" disabled="true">选择机构</a></span>';
                return html;
            }

        }
    }

];
var dg = $('#userList');
var tableData = [];
$(function() {
    $('#userList').datagrid({
        idField: 'evaluateTaskid',
        title: '评估任务发送',
        data: tableData,
        pageSize: 10,
        loadMsg: '',
        pagination: true,
        pageList: [10, 20, 30],
        rownumbers: true,
        singleSelect: false,
        striped: true,
        fit: true,
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

    getGridPager("userList", doLoading);
    doLoading();
});
