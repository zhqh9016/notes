var tableColumns = [{
        field: 'expertEvaluateCode',
        title: '专家评定编号',
        checkbox: true
    }, {
        field: 'firstEvaluateCode',
        title: 'firstEvaluateCode',
        hidden: true
    }, {
        field: 'insuredPersonCode',
        title: 'insuredPersonCode',
        hidden: true
    }, {
        field: 'insuredPersonName',
        title: '申请人姓名',
        align: 'center'
    }, {
        field: 'idCard',
        title: '身份证号码',
        align: 'center'
    }, {
        field: 'address',
        align: 'center',
        title: '地址'
    }, {
        field: 'evaluateAgencyName',
        title: '评估机构',
        align: 'center'
    }, {
        field: 'evaluateName',
        align: 'center',
        title: '评估员'
    }, {
        field: 'score',
        align: 'center',
        title: '初评得分'
    }, {
        field: 'fraction',
        title: '专家评分',
        align: 'center'
    }, {
        field: 'evaluateContent',
        hidden: true,
        title: '专家评分内容'
    },

    {
        field: 'detailJson',
        align: 'center',
        formatter: function(value, rowData, index) {
            var str = '<a href="#" name="opera"  onclick="doLoadEvaluateDetail(\'' + index + '\',false);stopBubble();">《日常生活活动能力评定量表》</a>';
            return str;
        },
        title: '评估量表'
    }, {
        field: 'accessoryAddress',
        title: '专家意见附件',
        align: 'center',
        formatter: function(value, rowData, index) {
            var str = "";
            if (rowData.taskState == '02') { //评估任务状态 评估任务状态为已接收的才能录入，其他的只能查看
                str = '<a href="#" name="opera"  onclick="doexpertAssess(\'' + index + '\',true,false);stopBubble();">录入</a>';
            } else {
                str = '<a href="#" name="opera"  onclick="loadexpertAssess(\'' + index + '\');stopBubble();">查看</a>';
            }
            //str += '<a href="#" name="opera"  onclick="doexpertAssess(\'' + index + '\',true,false)">录入</a>&nbsp&nbsp&nbsp';
            //str += '<a href="#" name="opera"  onclick="loadexpertAssess(\'' + index + '\')">查看</a>';
            return str;
        }
    }, {
        field: 'evaluateTaskCode',
        title: '评估任务编号',
        hidden: true
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
        field: 'act',
        title: '操作',
        align: 'center',
        formatter: function(value, rowData, index) {
            var html = '';
            if (rowData.taskState == '03' || rowData.taskState == '04') {
                html = '<a href="javascript:;" class="easyui-linkbutton" name="" onclick="printSingle(\'' + index + '\');stopBubble();">打印</a>';
            } else {
                html = '<span onclick="stopBubble()"><a href="javascript:;" class="easyui-linkbutton" name="" disabled="true">打印</a></span>';
            }
            return html;
        }
    }
];
var dg = $('#userList');
var tableData = [];
$(function() {
    dg.datagrid({
        idField: 'expertEvaluateCode',
        title: '专家评定',
        data: tableData,
        pageSize: 10,
        pagination: true,
        pageList: [10, 20, 30],
        rownumbers: true,
        fit: true,
        loadMsg: '',
        striped: true,
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
