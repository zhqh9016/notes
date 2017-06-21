var tableColumns = [{
        field: 'createdBy',
        title: 'createdBy',
        checkbox: true
    }, {
        field: 'taskCode',
        title: '任务ID'
    }, {
        field: 'estimateMan',
        title: '评估人姓名',
        align: 'center'
    }, {
        field: 'agencyPhone',
        title: '评估人联系电话',
        align: 'center'
    }, {
        field: 'estimateOrg',
        title: 'estimateOrg',
        hidden: true
    }, {
        field: 'agencyName',
        title: '评估机构',
        align: 'center'
    }, {
        field: 'estimateManCode',
        title: 'estimateManCode',
        hidden: true
    }, {
        field: 'recognizeeMan',
        title: '被评估人姓名',
        align: 'center'
    }, {
        field: 'recognizeeManPhone',
        title: '被评估人联系电话',
        align: 'center'
    }, {
        field: 'recognizeeManAddr',
        title: '被评估人地址',
        align: 'center'
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
    }, {
        field: 'preevaluateDate',
        title: '评估时间',
        formatter: function(value) {
            return formatDate(value); },
        align: 'center'
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
    },

    {
        field: 'latitude',
        title: 'latitude',
        hidden: true
    }, {
        field: 'longitude',
        title: 'longitude',
        hidden: true
    },

    {
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
        loadMsg: '',
        pagination: true,
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
