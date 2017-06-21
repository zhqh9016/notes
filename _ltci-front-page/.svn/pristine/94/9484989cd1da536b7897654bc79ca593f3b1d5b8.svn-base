var tableColumns = [{
        field: 'id',
        title: 'id',
        hidden: true
    }, {
        field: 'beCarePersonName',
        align: 'center',
        title: '参保人'
    }, {
        field: 'beCarePersonCard',
        align: 'center',
        title: '身份证号码'
    }, {
        field: 'orgName',
        align: 'center',
        title: '护理机构'
    }, {
        field: 'exitReason',
        title: '退出原因',
        align: 'center',
        formatter: function(value, rowData, index) {
            if (value) { //如果有值显示数据字典，否则显示下拉框选择
                return getTableDictionary(this.field, value);
            } else {
                var html = '<input id="exitReason" data-dictionary="exitReason" name="exitReason" type="text" class="easyui-combobox dictionary exitReason" editable="false" />';
                return html;
            }

        }
    }, {
        field: 'inHospState',
        title: '人员状态',
        align: 'center',
        formatter: function(value, rowData, index) {
            return getTableDictionary(this.field, value);
        }
    }, {
        field: 'operatedBy',
        align: 'center',
        title: '经办人'
    }, {
        field: 'operatedTime',
        align: 'center',
        title: '经办时间'
    }, {
        field: 'realOutDate',
        align: 'center',
        title: '退出时间'
    }, {
        field: 'agreOutDate',
        title: 'agreOutDate',
        hidden: true
    }, {
        field: 'cardType',
        title: 'cardType',
        hidden: true
    },

    {
        field: 'invoicenum',
        title: 'invoicenum',
        hidden: true
    }, {
        field: 'inRecordUuid',
        title: 'inRecordUuid',
        hidden: true
    }, {
        field: 'agreInDate',
        title: 'agreInDate',
        hidden: true
    }, {
        field: 'socSecNum',
        title: 'socSecNum',
        hidden: true
    },

    {
        field: 'orgCode',
        title: 'orgCode',
        hidden: true
    }, {
        field: 'realInDate',
        title: 'realInDate',
        hidden: true
    }, {
        field: 'act',
        title: '操作',
        align: 'center',
        formatter: function(value, rowData, index) {
            var html = "";
            if (rowData.inHospState == "0") { //在院状态 0为在院，如果在院可以退出，否则不能退出
                html = '<a href="javascript:;" name="" class="easyui-linkbutton" onclick="doQuit(' + index + ');stopBubble();">确认退出</a>';
            } else {
                html = '<span onclick="stopBubble()"><a href="javascript:;" name="" class="easyui-linkbutton" disabled="true">确认退出</a></span>';
            }
            return html;
        }
    }

];


var dg = $('#userList');
var tableData = [];
$(function() {
    dg.datagrid({
        idField: 'applicationid',
        title: '协议管理',
        data: tableData,
        pageSize: 10,
        pagination: true,
        pageList: [10, 20, 30],
        rownumbers: true,
        singleSelect: false,
        fit: true,
        loadMsg: '',
        striped: true,
        showFooter: true,
        columns: [tableColumns],
        onLoadSuccess: function(data) {
            dg.datagrid("clearSelections");
            $(".easyui-linkbutton").linkbutton();
            $(".exitReason").combobox();
            loadDictionaryForAll('.datagrid-btable .dictionary');
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
