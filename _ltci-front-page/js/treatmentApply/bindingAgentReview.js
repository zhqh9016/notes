var tableColumns = [{
        field: 'deputyBindingid',
        title: 'id',
        hidden: true
    }, {
        field: 'idCard',
        align: 'center',
        title: '身份证号码'
    }, {
        field: 'insuredPersonName',
        align: 'center',
        title: '参保人名称'
    }, {
        field: 'securityNumber',
        align: 'center',
        title: '社保卡'
    }, {
        field: 'deputyBindingCode',
        hidden: true,
        title: '绑定审核表编号'
    }, {
        field: 'deputyName',
        align: 'center',
        title: '代理人名称'
    },

    {
        field: 'deputyIdCard',
        align: 'center',
        title: '代理人身份证'
    }, {
        field: 'checkState',
        align: 'center',
        formatter: function(value, rowData, index) {
            if (value == 01) { //代理人绑定审核状态 checkState  审核不通过 01
                var checkReason = rowData.checkReason;
                return '<a href="javascript:;" style="color:red" onclick = "showReason(\'' + checkReason + '\')">' + getTableDictionary(this.field, value) + '</a>'
            }
            return getTableDictionary(this.field, value);
        },
        title: '审核状态'
    }, {
        field: 'checkReason',
        align: 'center',
        title: '原因',
        hidden: true
    }, {
        field: 'act',
        title: '操作',
        align: 'center',
        formatter: function(value, rowData, index) {
            var html = '';
            if (rowData.checkState == '02') { //代理人绑定审核状态 02待审核
                html = "<a href=\"#\" class=\"easyui-linkbutton\" plain=\"true\" onclick=\"doSearchAll(\'" + index + "');stopBubble();\">查看详情</a>" +
                    "<a href=\"#\" class=\"easyui-linkbutton\" plain=\"true\" onclick=\"doAccept(true,\'" + index + "');stopBubble();\">审核通过</a>" +
                    "<a href=\"#\" class=\"easyui-linkbutton\" plain=\"true\" onclick=\"doAccept(false,\'" + index + "');stopBubble();\">审核不通过</a>";
                return html;
            } else if (rowData.checkState == '01' || rowData.checkState == '03') { //审核不通过01，审核通过03
                html = "<a href=\"#\" class=\"easyui-linkbutton\" plain=\"true\" onclick=\"doSearchAll(\'" + index + "');stopBubble();\">查看详情</a>" +
                    "<span onclick=\"stopBubble()\"><a href=\"#\" class=\"easyui-linkbutton\" plain=\"true\" disabled=\"true\">审核通过</a></span>" +
                    "<span onclick=\"stopBubble()\"><a href=\"#\" class=\"easyui-linkbutton\" plain=\"true\" disabled=\"true\">审核不通过</a></span>";
                return html;
            }

        }
    }

];
var dg = $('#userList');
var tableData = [];
$(function() {
    dg.datagrid({
        idField: 'deputyBindingid',
        title: '代理人绑定人工审核',
        data: tableData,
        queryParams: {},
        pageSize: 10,
        pagination: true,
        loadMsg: '',
        pageList: [10, 20, 30],
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
    getGridPager('userList', doLoading); //设置表格分页数据
    doLoading();
});
