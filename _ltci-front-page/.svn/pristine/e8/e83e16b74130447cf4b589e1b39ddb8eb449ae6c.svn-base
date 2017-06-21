var tableColumns = [{
    field: 'id',
    title: 'id',
    hidden: true
}, {
    field: 'orgName',
    title: '护理机构名称',
    sortable: false,
    align: 'center'
        //width : 100
}, {
    field: 'orgCode',
    title: '护理机构编码',
    sortable: false,
    align: 'center'
        //width : 80
}, {
    field: 'createdOrg',
    title: '经办机构编码',
    sortable: false,
    align: 'center',
    hidden: true
}, {
    field: 'createdOrgName',
    title: '经办机构',
    sortable: false,
    align: 'center'
        //width:100
}, {
    field: 'feeStarttime',
    title: '开始日期',
    sortable: false,
    align: 'center',
    //width : 110,
    formatter: function(value) {
        var date = value.split(' ');
        //console.log(date[0]);
        return date[0];
    }
}, {
    field: 'feeEndtime',
    title: '终止日期',
    sortable: false,
    align: 'center',
    //width : 110,
    formatter: function(value) {
        var date = value.split(' ');
        //console.log(date[0]);
        return date[0];
    }
}, {
    field: 'nurseTotalAmount',
    title: '总费用合计',
    sortable: false,
    align: 'center',
    formatter: function(value) {
        var str = value.toFixed(2);
        return str;
    }
}, {
    field: 'siPay',
    title: '统筹支出合计',
    sortable: false,
    align: 'center',
    formatter: function(value) {
        var str = value.toFixed(2);
        return str;
    }
}, {
    field: 'paySelf',
    title: '自付合计',
    sortable: false,
    align: 'center',
    formatter: function(value) {
        var str = value.toFixed(2);
        return str;
    }
}, {
    field: 'expenseSelf',
    title: '自费合计',
    sortable: false,
    align: 'center',
    formatter: function(value) {
        var str = value.toFixed(2);
        return str;
    }
}, {
    field: 'unrFee',
    title: '不合理费用合计',
    sortable: false,
    align: 'center',
    formatter: function(value) {
        var str = value.toFixed(2);
        return str;
    }
}, {
    field: 'accountPay',
    title: '账户支付',
    sortable: false,
    align: 'center',
    formatter: function(value) {
        if (value === null) {
            return '0.00';
        }
        var str = value.toFixed(2);
        return str;
    }
}, {
    field: 'bankCardPay',
    title: '银行卡支付',
    sortable: false,
    align: 'center',
    formatter: function(value) {
        if (value === null) {
            return '0.00';
        } else {
            var str = value.toFixed(2);
            return str;
        }
    }
}, {
    field: 'auditState',
    title: '状态',
    sortable: false,
    align: 'center',
    //width : 100,
    formatter: function(value, row, index) {
        var str = '';
        if (value === '' || value === undefined || value === null || value == '3') {
            str = "复核通过";
        } else if (value == '5') {
            str = "已结算";
        } else if (value == '6') {
            str = "已支付";
        }
        return str;
    }
}, {
    field: 'caozuo',
    title: '操作',
    sortable: false,
    align: 'center',
    //width : 200,
    formatter: function(value, row, index) { //disabled="true"
        var str = '';
        if (row.auditState == '6') {
            str = '<a href="#" name="opera" class="easyui-linkbutton" onclick="account(\'' + index + '\')" disabled="true"><span style="color:black">结算</span></a>';
            str += '&nbsp &nbsp<a href="#" name="opera" class="easyui-linkbutton" onclick="payment(\'' + index + '\')" disabled="true"><span style="color:black">支付</span></a>';
        } else if (row.auditState == '5') {
            str = '<a href="#" name="opera" class="easyui-linkbutton" onclick="account(\'' + index + '\')" disabled="true"><span style="color:black">结算</span></a>';
            str += '&nbsp &nbsp<a href="#" name="opera" class="easyui-linkbutton" onclick="payment(\'' + index + '\')">支付</a>';
        } else if (row.auditState == '3') {
            str = '<a href="#" name="opera" class="easyui-linkbutton" onclick="account(\'' + index + '\')">结算</a>';
            str += '&nbsp &nbsp<a href="#" name="opera" class="easyui-linkbutton" onclick="payment(\'' + index + '\')">支付</a>';
        }
        return str;
    }
}];

//&nbsp &nbsp<a href="#" name="opera" class="easyui-linkbutton" onclick="print(\''+ index+ '\')">打印</a>
$(function() {
    initGridSet({
        id: 'feePaymentList', //表格id
        title: '费用支付', //表格头
        idField: 'id', //	表格主键
        columns: tableColumns, //	表格列
        url: portalServiceUrl + "/api/v1/orgSettlement/pay/list", //	配置表格默认查询参数
        type: 'post', //	表格默认查询参数
        query: { //	表格默认查询参数
            orgCode: '',
            orgName: '',
            auditState: '3,5,6',
            startDate: '',
            endDate: '',
            page: TableObj.page,
            pageSize: TableObj.pageSize
        }
    }); //初始化表格配置，多表格可重复调用，穿入不同的obj即可
    TableObj = getGridObjById('feePaymentList'); //TableObj切换当前表格为激活状态
    initDataGrid(); //初始化表格
    loadGridData(); //加载表格数据


    function getMonthLastDays() {
        var i, arr = [],
            days = 0;
        var date = new Date();
        //获取当年年份
        var yy = 0,
            year = date.getFullYear();
        for (k = -10; k < 20; k++) {
            yy = year + k;
            for (i = 1; i <= 12; i++) {
                days = new Date(yy, i, 0).getDate();
                s = i + '';
                if (s.length < 2) s = '0' + s;
                arr.push(yy + '-' + s + '-' + days);
            }
        }
        return arr;
    }


    var date = new Date();
    minDate = '%y-{%M-1}-01';
    //maxDate = date.getFullYear() + "-" + (date.getMonth() * 1 + 1) + "-"
    //+ date.getDate();
    $("#search_startDate").bind("focus", function() {
        WdatePicker({
            drrDealMode: 1,
            maxDate: minDate,
            opposite: true,
            disabledDates: ['....-..-01'], //['5$','2$','3$','4$','6$','7$','8$','9$','0$','11','21','31'],
            dateFmt: 'yyyy-MM-dd',
            readOnly: true
                //alwaysUseStartDate : true
        });
    });
    $("#search_endDate").bind("focus", function() {
        WdatePicker({
            drrDealMode: 1,
            opposite: true,
            maxDate: '%y-{%M-1}-%ld',
            minDate: $("#search_feeStarttime").val(),
            disabledDates: getMonthLastDays(),
            //disabledDates: getMonthDays('%y','{%M-1}'),		
            dateFmt: 'yyyy-MM-dd',
            readOnly: true
                //alwaysUseStartDate : true
        });
    });
});
