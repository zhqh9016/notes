var tableColumns = [{
        field: 'staffName',
        title: '人员姓名'
    }, {
        field: 'staffCode',
        title: '人员编号',
        hidden: true
    }, {
        field: 'credentialNumber',
        title: '身份证号码'
    }, {
        field: 'staffFiles',
        title: 'staffFiles',
        hidden: true
    }, {
        field: 'staffLevel',
        title: '职称',
        formatter: function(value) {
            return getTableDictionary(this.field, value); }
    }, {
        field: 'agencyName',
        title: '定点医疗机构名称'
    }, {
        field: 'createdBy',
        title: '申请人'
    }, {
        field: 'createdTime',
        formatter: function(value) {
            return formatDate(value); },
        title: '申请日期'
    }, {
        field: 'auditState',
        title: '受理状态',
        formatter: function(value, rowData, index) {
            if (value == 5) { //审核不通过状态，点击需弹出审核不通过原因
                var html = '<a style="color:red" href="javascript:;" onclick="showRefuseReason(' + index + ')">审核不通过</a>';
                return html;
            } else {
                return getTableDictionary("acceptState", value);
            }
        }
    }, {
        field: 'serialNo',
        title: 'serialNo',
        hidden: true
    }, {
        field: 'actionType',
        title: 'actionType',
        hidden: true
    },

    {
        field: 'act',
        title: '操作',
        formatter: function(value, rowData, index) {
            //受理\审核状态 1待受理 2待审核（已受理）3暂不受理 4审核通过 5审核不通过
            var html = "";
            if (rowData.actionType == 3) {
                html = '<a href="javascript:;"  class="easyui-linkbutton" disabled="true">操作</a>';
            } else {
                html = '<a href="javascript:;"  class="easyui-linkbutton" onclick="act(' + index + ')">操作</a>';
            }
            return html;
        }
    }

];

var dg = $('#searchList');
var tableData = [];
$(function() {
    $('#searchList').datagrid({
        idField: 'staffCode',
        title: '人员信息变更',
        data: tableData,
        loadMsg: '',
        pageSize: 10,
        pagination: true,
        pageList: [10, 20, 30],
        fit: true,
        rownumbers: true,
        singleSelect: true,
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
    $("#acceptState").combobox('setValue', '2'); //受理状态，默认查询未处理（值为1）的数据
    getGridPager('searchList', doLoading); //设置表格分页数据

    doSearch();

});
