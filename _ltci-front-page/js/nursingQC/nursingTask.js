var tableColumns = [{
        field: 'createdBy',
        title: 'createdBy',
        checkbox: true
    }, {
        field: 'taskCode',
        title: '任务ID',
    }, {
        field: 'serviceItems',
        title: '护理服务项目'
    }, {
        field: 'preevaluateDate',
        title: '护理时间'
    }, {
        field: 'nursingManName',
        title: '护理人员姓名'
    }, {
        field: 'nursingManPhone',
        title: '护理人员联系电话'
    }, {
        field: 'estimateManCode',
        title: 'estimateManCode',
        hidden: true
    }, {
        field: 'nursingOrgCode',
        title: '护理机构'
    }, {
        field: 'recognizeeMan',
        title: '参保人姓名'
    }, {
        field: 'recognizeeManPhone',
        title: '参保人联系电话'
    }, {
        field: 'recognizeeManAddr',
        title: '参保人地址'
    }, {
        field: 'serviceType',
        title: '护理类型',
        formatter: function(value, row, index) {
            //return getTableDictionary("bidType", value);
            if (value == "10" || value == "33") {
                row.serviceType = "33";
                return "养老机构护理";
            } else if (value == "11" || value == "31") {
                row.serviceType = "31";
                return "全日居家护理";
            } else if (value == "12" || value == "32") {
                row.serviceType = "32";
                return "非全日居家护理";
            } else if (value == "13" || value == "34") {
                row.serviceType = "34";
                return "医疗机构护理";
            } else {
                return value;
            }
        }
    }, {
        field: 'isKinshipCare',
        title: '是否亲属照护',
        formatter: function(value) {
            return getTableDictionary(this.field, value); }
    }, {
        field: 'isPrivilege',
        title: '是否特权通过',
        formatter: function(value) {
            return getTableDictionary(this.field, value); }
    }, {
        field: 'agencyName',
        title: 'agencyName',
        hidden: true
    }, {
        field: 'agencyPhone',
        title: 'agencyPhone',
        hidden: true
    }, {
        field: 'recognizeeManCode',
        title: 'recognizeeManCode',
        hidden: true
    }, {
        field: 'recognizeeManIdNo',
        title: 'recognizeeManIdNo',
        hidden: true
    }, {
        field: 'recognizeeManIdType',
        title: 'recognizeeManIdType',
        hidden: true
    }, {
        field: 'agencyAddressDetail',
        title: 'agencyAddressDetail',
        hidden: true
    },

    {
        field: 'provinceCode',
        title: 'provinceCode',
        hidden: true
    }, {
        field: 'cityCode',
        title: 'cityCode',
        hidden: true
    }, {
        field: 'areaCode',
        title: 'areaCode',
        hidden: true
    },

    {
        field: 'createdOrg',
        title: 'createdOrg',
        hidden: true
    }, {
        field: 'latitude',
        title: 'latitude',
        hidden: true
    }, {
        field: 'longitude',
        title: 'longitude',
        hidden: true
    }, {
        field: 'remark',
        title: 'remark',
        hidden: true
    }

];

var dg = $('#searchList');
var tableData = [];
$(function() {
    $('#searchList').datagrid({
        idField: 'taskCode',
        title: '待选择列表',
        data: tableData,
        pageSize: 10,
        pagination: true,
        loadMsg: '',
        pageList: [10, 20, 30],
        rownumbers: true,
        singleSelect: false,
        fit: true,
        striped: true,
        showFooter: true,
        columns: [tableColumns],
        onLoadSuccess: function(data) {
            dg.datagrid("clearSelections");
            //			$(".easyui-linkbutton").linkbutton();
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

    $('#sendList').datagrid({
        idField: 'taskCode',
        title: '已选择列表',
        data: [],
        loadMsg: '',
        rownumbers: true,
        singleSelect: false,
        fitColumns: true,
        striped: true,
        columns: [tableColumns]
    });

    getGridPager('searchList', doLoading); //设置表格分页数据
    //doSearch();


});
