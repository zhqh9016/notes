$(function() {
    var tableColumns = [{
        field: 'id',
        title: 'id',
        hidden: true
    }, {
        field: 'serviceCode',
        title: '服务项目编码',
        align: 'center'
    }, {
        field: 'serviceName',
        title: '服务项目名称',
        align: 'center'
    }, {
        field: 'serviceType',
        title: '服务项目类型',
        align: 'center'
    }, {
        field: 'frequency',
        title: '服务次数',
        align: 'center'
    }, {
        field: 'taskTime',
        title: '持续时间',
        align: 'center'
    }, {
        field: 'description',
        title: '服务描述'
    }, {
        field: 'startTime',
        title: '服务开始时间',
        align: 'center'
    }, {
        field: 'endTime',
        title: '服务结束时间',
        align: 'center'
    }, {
        field: 'chargeType',
        title: '费用类别',
        align: 'center'
    }, {
        field: 'chargeLevel',
        title: '收费项目等级',
        align: 'center'
    }, {
        field: 'limitPrice',
        title: '最高限价',
        align: 'center'
    }, {
        field: 'price',
        title: '项目单价',
        align: 'center'
    }, {
        field: 'isValid',
        title: '有效标识',
        align: 'center'
    }, {
        field: 'operatedBy',
        title: '经办人',
        align: 'center'
    }, {
        field: 'operatedTime',
        title: '经办时间',
        align: 'center'
    }];

    var dg = $('#userList');
    var tableData = doLoading();
    dg.datagrid({
        idField: 'id',
        title: '综合查询',
        data: tableData,
        fit: true,
        queryParams: {},
        pageSize: 10,
        pageList: [10, 20, 30],
        sortName: 'createDate',
        sortOrder: 'desc',
        nowrap: true,
        rownumbers: true,
        loadMsg: '',
        singleSelect: true,
        fitColumns: false,
        showFooter: false,
        pagination: true,
        frozenColumns: [
            []
        ],
        columns: [tableColumns],
        onLoadSuccess: function(data) {
            // $(".easyui-linkbutton").linkbutton();
            $("#userList").treegrid("clearSelections");
        },
        onClickRow: function(rowIndex, rowData) {
            rowid = rowData.id;
            rowIndexs = rowIndex;
            isValid = rowData.isValid;
            gridname = 'userList';
        },
        onCheck: function(rowIndex, rowData) {

        },
        onUncheck: function(rowIndex, rowData) {
            //alert(rowIndex)
        },
        onCheckAll: function(rows) {
            //alert(rows)
        },
        onUncheckAll: function(rows) {
            //alert(rows)
        }
    });
    getGridPager('userList', doSearch); //设置表格分页数据
});
