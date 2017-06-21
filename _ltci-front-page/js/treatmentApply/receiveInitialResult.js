var tableColumns = [{
        field: 'firstEvaluateCode',
        title: '初评结果ID',
        hidden: true
    }, {
        field: 'insuredPersonName',
        title: '申请人',
        align: 'center'
    }, {
        field: 'idCard',
        align: 'center',
        title: '身份证号码'
            //formatter: function(value){return getTableDictionary(this.field,value)},
    }, {
        field: 'address',
        title: '现住址',
        align: 'center'
            //formatter: function(value){return getTableDictionary(this.field,value)},
    }, {
        field: 'evaluateName',
        align: 'center',
        title: '评估员'
    }, {
        field: 'evaluatorOrg',
        align: 'center',
        title: '评估机构'
            //formatter: function(value){return getTableDictionary(this.field,value)},
    }, {
        field: 'score',
        title: '初评得分',
        align: 'center'
    }, {
        field: 'evaluateTaskCode',
        title: '评估任务编号',
        hidden: true
    },

    {
        field: 'detailJson',
        align: 'center',
        formatter: function(value, row, index) {
            var str = '<a href="#" name="opera"  onclick="doLoadEvaluateDetail(\'' + index + '\',false);stopBubble();">《日常生活活动能力评定量表》</a>';
            //				var str = '<a href="#" name="opera"  onclick="loadexpertAssess(\'' + index + '\',false)">《日常生活活动能力评定量表》</a>';
            //var str = '<a href="#" name="opera"  onclick="doexpertAssess(\'' + index + '\',false)">《日常生活活动能力评定量表》</a>';
            return str;
        },
        title: '评估量表附件'
    }, {

        field: 'operatedBy',
        align: 'center',
        title: '经办人'
    }, {
        field: 'operatedTime',
        align: 'center',
        formatter: function(value) {
            return formatDate(value);
        },
        title: '经办时间'
    }


];
var dg = $('#userList');
var tableData = [];

$(function() {
    dg.datagrid({
        idField: 'firstEvaluateCode',
        title: '初评结果接收',
        data: tableData,
        pageSize: 10,
        pagination: true,
        pageList: [10, 20, 30],
        rownumbers: true,
        fit: true,
        singleSelect: true,
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
