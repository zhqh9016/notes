var tableColumns = [{
        field: 'nursingTaskCode',
        title: 'nursingTaskCode',
        hidden: true
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
        field: 'evaluateAgencyName',
        align: 'center',
        title: '评估机构'
    }, {
        field: 'evaluateName',
        align: 'center',
        title: '评估员'
    }, {
        field: 'finalAgencyCode',
        hidden: true,
        title: '最终选择机构code'
    }, {
        field: 'applyType',
        title: '申办类型',
        hidden: true
    }, {
        field: 'isRelativeCared',
        title: '是否亲属照顾',
        hidden: true
    }, {
        field: 'score',
        align: 'center',
        title: '初评得分'
    }, {
        field: 'fraction',
        align: 'center',
        title: '专家评定得分'
    }, {
        field: 'detailJson',
        align: 'center',
        formatter: function(value, rowData, index) {
            var str = '<a href="#" name="opera"  onclick="doLoadEvaluateDetail(\'' + index + '\',false);stopBubble();">《日常生活活动能力评定量表》</a>';
            return str;
        },
        title: '附件'
    }, {
        field: 'accessoryAddress',
        align: 'center',
        formatter: function(value, rowData, index) {
            var str = '<a href="#" name="opera"  onclick="doLoadPicture(\'' + value + '\');stopBubble();">查看</a>';
            return str;
        },
        title: '专家评定意见'
    }, {
        field: 'evaluateContent',
        hidden: true,
        title: '专家评估意见'
    }, {
        field: 'isReevaluate',
        title: '是否申请重评',
        align: 'center',
        formatter: function(value) {
            return getTableDictionary(this.field, value); }
    }, {
        field: 'reevalueateResult',
        align: 'center',
        title: '重评结果'
    },


    {
        field: 'intentAgency',
        title: '所选意向机构',
        hidden: true
    }, {
        field: 'state',
        title: '确认状态',
        align: 'center',
        formatter: function(value) {
            return getTableDictionary("nursingState", value); }
    }, {
        field: 'finalAgencyName',
        title: '所选最终机构'
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
            //护理机构确认状态 nursingState 未选择意向机构00,已选择意向机构01,已确认最终机构02

            //1、专家分数（40分以上不能操作）
            //2、已重评不通过，不能选择
            //如果已确认最终机构不可选择确认
            if (rowData.fraction > 40 || (rowData.isReevaluate == '1' && rowData.reevalueateResult.indexOf('不通过') != -1) || rowData.state == "02") {
                html = '<span onclick="stopBubble()"><a href="javascript:;" name="" class="easyui-linkbutton" disabled="true">确认护理机构</a></span>';
                return html;
            } else {
                html = '<a href="javascript:;" name="" class="easyui-linkbutton" onclick="chooseOrganization(' + index + ');stopBubble();">确认护理机构</a>';
                return html;
            }

        }
    }

];
var dg = $('#userList');
var tableData = [];
$(function() {
    dg.datagrid({
        idField: 'nursingTaskCode',
        title: '护理机构确认',
        data: tableData,
        pageSize: 10,
        pagination: true,
        pageList: [10, 20, 30],
        loadMsg: '',
        rownumbers: true,
        singleSelect: true,
        fit: true,
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

    getGridPager("userList", doLoading);
    doLoading();
    //doSearchOrganization();
});
