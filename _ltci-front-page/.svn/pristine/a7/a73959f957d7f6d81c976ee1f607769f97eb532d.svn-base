var tableColumns = [{
        field: 'evaluateTaskCode',
        title: '评估任务ID',
        checkbox: true
    }, {
        field: 'insuredPersonName',
        align: 'center',
        title: '申请人'
    }, {
        field: 'idCard',
        align: 'center',
        title: '身份证号码'
    }, {
        field: 'address',
        align: 'center',
        title: '现住址'
    }, {
        field: 'evaluateName',
        align: 'center',
        title: '评估员'
    }, {
        field: 'evaluateAgencyName',
        align: 'center',
        title: '评估机构'
    }, {
        field: 'score',
        align: 'center',
        title: '初评分数'
    }, {
        field: 'fraction',
        align: 'center',
        title: '专家评定得分'
    }, {
        field: 'detailJson',
        align: 'center',
        formatter: function(value, rowData, index) {
            var str = '<a href="#" name="opera" onclick="doLoadEvaluateDetail(\'' + index + '\',false);stopBubble();">《日常生活活动能力评定量表》</a>';
            return str;
        },
        title: '评估量表附件'
    }, {
        field: 'accessoryAddress',
        title: '专家意见附件',
        align: 'center',
        formatter: function(value, rowData, index) {
            var str = "";
            if (!value) { //评估任务状态 评估任务状态为已接收的才能录入，其他的只能查看
                str = '<span></span>';
            } else {
                str = '<a href="#" name="opera"  onclick="loadexpertAssess(\'' + index + '\');stopBubble();">查看</a>';
            }
            //str += '<a href="#" name="opera"  onclick="doexpertAssess(\'' + index + '\',true,false)">录入</a>&nbsp&nbsp&nbsp';
            //str += '<a href="#" name="opera"  onclick="loadexpertAssess(\'' + index + '\')">查看</a>';
            return str;
        }
    },

    {
        field: 'evaluateContent',
        hidden: true,
        title: '专家评定意见'
    }, {
        field: 'taskState',
        align: 'center',
        title: '送达状态',
        formatter: function(value) {
            return getTableDictionary(this.field, value); }
    }, {
        field: 'isReevaluate',
        title: '是否申请重评',
        align: 'center',
        formatter: function(value, rowData, index) {
            if (value == "0" && rowData.taskState == "03") { //可重评并且未送达的才显示重评录入
                var html = '<a href="javascript:;" name="" style = "color:red" onclick="rewrite(' + index + ');stopBubble();">重评录入</a>';
                return html;
            } else {
                return getTableDictionary(this.field, value);
            }

        }
    }, {
        field: 'reevalueateResult',
        align: 'center',
        title: '重评结果'
    },

    {
        field: 'operatedBy',
        align: 'center',
        title: '经办人'
    }, {
        field: 'operatedTime',
        align: 'center',
        formatter: function(value) {
            return formatDate(value); },
        title: '经办时间'
    },

    {
        field: 'opinion',
        title: '意见',
        hidden: true
    }, {
        field: 'act',
        title: '操作',
        align: 'center',
        formatter: function(value, rowData, index) {
            var html = "";
            if (rowData.taskState == "03") { //评估任务状态 只有未送达的才可以送达
                html = '<a href="javascript:;" name="" class="easyui-linkbutton" onclick="doSinglePost(' + index + ');stopBubble();">送达</a>';
            } else {
                html = '<span onclick="stopBubble()"><a href="javascript:;" name="" class="easyui-linkbutton" disabled="true">送达</a></span>';
            }
            return html;
        }
    }

];
var dg = $('#userList');
var tableData = [];
$(function() {
    dg.datagrid({
        idField: 'evaluateTaskCode',
        title: '评定结果送达',
        data: tableData,
        pageSize: 10,
        pagination: true,
        pageList: [10, 20, 30],
        rownumbers: true,
        fit: true,
        striped: true,
        loadMsg: '',
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
