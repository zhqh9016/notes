var tableColumns = [{
    field: 'id',
    title: 'id',
    hidden: true
}, {
    field: 'tradeNum',
    title: '护理明细流水号',
    sortable: false
}, {
    field: 'careOrgServiceCode',
    title: '护理机构项目编码',
    sortable: false
}, {
    field: 'careOrgServiceName',
    title: '护理机构项目名称',
    sortable: false
}, {
    field: 'medicareCode',
    title: '医保护理项目编码',
    sortable: false
}, {
    field: 'medicareName',
    title: '医保护理项目名称',
    sortable: false
}, {
    field: 'chargeType',
    title: '费用类别',
    sortable: false,
    formatter: function(value) {
            return getTableDictionary(this.field, value); }
        //formatter: function(value) { return getTableDictionary('chargeType', value) },	
}, {
    field: 'feeDate',
    title: '费用明细日期',
    sortable: false
}, {
    field: 'price',
    title: '单价',
    sortable: false,
    formatter: function(value) {
        var str = value.toFixed(2);
        return str;
    }

}, {
    field: 'count',
    title: '数量',
    sortable: false
}, {
    field: 'amount',
    title: '金额',
    sortable: false,
    formatter: function(value) {
        var str = value.toFixed(2);
        return str;
    }

}, {
    field: 'nurseCode',
    title: '护理人员ID',
    sortable: false
}, {
    field: 'nurseName',
    title: '护理人员姓名',
    sortable: false
}];
$(function() {
    TableObj.page = 1; //设置页码 必须
    TableObj.pageSize = 10; //设置每页数据 必须
    initGridSet({
        id: 'feeDetailList', //表格id
        //title:'费用审核',//表格头
        idField: 'id', //	表格主键
        columns: tableColumns, //	表格列
        url: portalServiceUrl + "/api/v1/personal/nurse/detail/list", //	配置表格默认查询参数
        type: 'post', //	表格默认查询参数
        query: { //查询条件
            orgCode: getUrlParam("orgCode"),
            beCarePersonCard: getUrlParam("beCarePersonCard"),
            feeBeginDate: getUrlParam("feeBeginDate"),
            feeEndDate: getUrlParam("feeEndDate"),
            inRecorduuid: getUrlParam("inRecorduuid"),
            page: TableObj.page,
            pageSize: TableObj.pageSize
        }
        //loadGridData();
    }); //初始化表格配置，多表格可重复调用，穿入不同的obj即可
    TableObj = getGridObjById('feeDetailList'); //TableObj切换当前表格为激活状态
    initDataGrid(); //初始化表格
    loadGridData(); //加载表格数据
});
