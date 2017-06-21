var tableColumns = [{

    field: 'id',
    title: 'id',
    hidden: true
}, {
    field: 'orgName',
    title: '护理机构名称',
    sortable: false,
    align: 'center'
        //width:150
}, {
    field: 'orgCode',
    title: '护理机构编码',
    sortable: false,
    align: 'center'
        //width:100
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
    //width:110,
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
    //width:110,
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
    formatter: function(value, row, index) {
        var str = '<a href="#" name="opera" style="color:#FF0000" onclick="doAccept(\'' + index + '\',\'' + value + '\')">' + (row.unrFee).toFixed(2) + '</a>';
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
    title: '审核状态',
    sortable: false,
    align: 'center',
    formatter: function(value, row, index) {
        var str = '';
        if (value == '2') {
            str = "审核通过";
        } else if (value == '3') {
            str = "复核通过";
        } else if (value == '4') {
            str = '<a href="#" name="opera" onclick="cause(\'' + index + '\',0)" style="color:#FF0000">复核未通过</a> ';
        }
        return str;
    }
}, {
    field: 'caozuo',
    title: '操作',
    sortable: false,
    align: 'center',
    width: 200,
    formatter: function(value, row, index) {
        var str = '';
        if (row.auditState == '2') {
            str = '<a href="#" name="opera" class="easyui-linkbutton" onclick="doAccept(\'' + index + '\',0)">明细</a>&nbsp;&nbsp;';
            str += '<a href="#" name="opera" class="easyui-linkbutton" onclick="tg(\'' + index + '\',0)">通过</a>';
            str += '&nbsp;&nbsp;<a href="#" name="opera" class="easyui-linkbutton" onclick="ntg(\'' + index + '\',0)">不通过</a>';
        } else if (row.auditState == '3') {
            str = '<a href="#" name="opera" class="easyui-linkbutton" onclick="doAccept(\'' + index + '\',0)">明细</a>&nbsp;&nbsp;';
            str += '<a href="#" name="opera" class="easyui-linkbutton" onclick="tg(\'' + index + '\')" disabled="true"><span style="color:black">通过</span></a>';
            str += '&nbsp;&nbsp;<a href="#" name="opera" class="easyui-linkbutton" onclick="ntg(\'' + index + '\')" disabled="true"><span style="color:black">不通过</span></a>';
        } else if (row.auditState == '4') {
            str = '<a href="#" name="opera" class="easyui-linkbutton" onclick="doAccept(\'' + index + '\',0)">明细</a>&nbsp;&nbsp;';
            str += '<a href="#" name="opera" class="easyui-linkbutton" onclick="tg(\'' + index + '\')" disabled="true"><span style="color:black">通过</span></a>';
            str += '&nbsp;&nbsp;<a href="#" name="opera" class="easyui-linkbutton" onclick="ntg(\'' + index + '\')" disabled="true"><span style="color:black">不通过</span></a>';
        }
        return str;
    }
}];

var tableColumn = [{
        field: 'id',
        title: 'id',
        hidden: true
    }, {
        field: 'nurseObjName',
        title: '姓名',
        sortable: false,
        align: 'center'
            //width:90
    }, {
        field: 'beCarePersonCardNum',
        title: '身份证号码',
        sortable: false,
        align: 'center'
            //width:130
    }, {
        field: 'socSecNum',
        title: '社会保障卡号码',
        sortable: false,
        align: 'center'
            //width:130
    }, {
        field: 'nurseStarttime',
        title: '费用开始日期',
        sortable: false,
        align: 'center'
            //width:120
    }, {
        field: 'nurseEndtime',
        title: '费用结束日期',
        sortable: false,
        align: 'center'
            //width:120
    }, {
        field: 'setDate',
        title: '结算日期',
        sortable: false,
        align: 'center'
            //width:120
    },
    //		{
    //          field: 'feeDate',
    //          title: '费用日期',
    //          sortable: false,
    //			align:'center',
    //			//width:120
    //      },
    {
        field: 'nurseTotalAmount',
        title: '总费用',
        sortable: false,
        align: 'center',
        //width:80,
        formatter: function(value) {
            var str = value.toFixed(2);
            return str;
        }
    }, {
        field: 'siPay',
        title: '统筹支出',
        sortable: false,
        align: 'center',
        //width:80,
        formatter: function(value) {
            var str = value.toFixed(2);
            return str;
        }
    }, {
        field: 'paySelf',
        title: '自付费用',
        sortable: false,
        align: 'center',
        //width:80,
        formatter: function(value) {
            var str = value.toFixed(2);
            return str;
        }
    }, {
        field: 'expenseSelf',
        title: '自费费用',
        sortable: false,
        align: 'center',
        //width:80,
        formatter: function(value) {
            var str = value.toFixed(2);
            return str;
        }
    }, {
        field: 'unrFee',
        title: '不合理费用',
        sortable: false,
        align: 'center',
        //width:80,
        formatter: function(value) {
            var str = value.toFixed(2);
            return str;
        }
    }, {
        field: 'accountPay',
        title: '账户支付',
        sortable: false,
        align: 'center',
        //width:120
        formatter: function(value) {
            var str = value.toFixed(2);
            return str;
        }
    }, {
        field: 'bankCardPay',
        title: '银行卡支付',
        sortable: false,
        align: 'center',
        //width:120
        formatter: function(value) {
            var str = value.toFixed(2);
            return str;
        }
    }, {
        field: 'xiangqing',
        title: '详情',
        sortable: false,
        //width:120,
        align: 'center',
        formatter: function(value, row, index) {
            var str = '<a href="#" onclick="feeDetail(this)"  name="opera" class="easyui-linkbutton l-btn l-btn-plain">详情</a>';
            return str;
        }
    }
];
$(function() {
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
    //var maxDate =date.getFullYear()+"-"+ (date.getMonth()*1);
    //console.log(maxDate)
    $("#search_feeStarttime").bind("focus", function() {
        WdatePicker({
            drrDealMode: 1,
            maxDate: minDate,
            opposite: true,
            disabledDates: ['....-..-01'], //['5$','2$','3$','4$','6$','7$','8$','9$','0$','11','21','31'],
            dateFmt: 'yyyy-MM-dd',
            readOnly: true,
            //alwaysUseStartDate : true
        });
    });
    $("#search_feeEndtime").bind("focus", function() {
        WdatePicker({ //minDate:$("#search_feeStarttime").val(),
            drrDealMode: 1,
            opposite: true,
            maxDate: '%y-{%M-1}-%ld',
            minDate: $("#search_feeStarttime").val(),
            disabledDates: getMonthLastDays(),
            //disabledDates: getMonthDays('%y','{%M-1}'),		
            dateFmt: 'yyyy-MM-dd',
            readOnly: true,
            //alwaysUseStartDate : true
        });
    });
    maxDate = date.getFullYear() + "-" + (date.getMonth() * 1 + 1) + "-" + date.getDate();
    $("#search_startDate").bind("focus", function() {
        WdatePicker({ //minDate:$("#search_feeStarttime").val()+"-01",
            //maxDate: $("#search_feeEndtime").val() ,
            drrDealMode: 1,
            dateFmt: 'yyyy-MM-dd',
            readOnly: false
        });
    });
    $("#search_endDate").bind("focus", function() {
        WdatePicker({
            minDate: $("#search_startDate").val(),
            maxDate: $("#search_feeEndtime").val(),
            drrDealMode: 1,
            dateFmt: 'yyyy-MM-dd',
            readOnly: false
        });
    });


    initGridSet({
        id: 'feeCheckList', //表格id
        title: '费用复核', //表格头
        idField: 'id', //	表格主键
        columns: tableColumns, //	表格列
        url: portalServiceUrl + "/api/v1/orgSettlement/check/list", //	配置表格默认查询参数
        type: 'post', //	表格默认查询参数
        query: { //	表格默认查询参数
            orgName: '',
            orgCode: '',
            startDate: '',
            endDate: '',
            auditState: '2',
            page: TableObj.page,
            pageSize: TableObj.pageSize
        }
    }); //初始化表格配置，多表格可重复调用，穿入不同的obj即可
    $("#inspection").combobox('setValue', '2'); //受理状态，默认查询未处理（值为1）的数据
    TableObj = getGridObjById('feeCheckList'); //TableObj切换当前表格为激活状态
    initDataGrid(); //初始化表格
    loadGridData(); //加载表格数据

    var backFeeSH = '<a href="#" class="" onclick="showParent()"><span class="l-btn-left-d"><span class="l-btn-text">返回</span></span></a>&nbsp;&nbsp;';
    initGridSet({
        id: 'chooseOrgList', //表格id
        title: backFeeSH + '当前位置 : 费用复核＞月结明细', //表格头
        idField: 'id', //	表格主键
        columns: tableColumn, //	表格列
        url: portalServiceUrl + "/api/v1/monSetPer/list", //	配置表格默认查询参数
        type: 'post', //	表格默认查询参数
        onBeforeEdit: function(index, row) {
            row.editing = true;
            updateActions(index);
            $(".easyui-linkbutton").linkbutton();
        },
        onAfterEdit: function(index, row) {
            row.editing = false;
            updateActions(index);
            $(".easyui-linkbutton").linkbutton();
        },
        onCancelEdit: function(index, row) {
            row.editing = false;
            updateActions(index);
            $(".easyui-linkbutton").linkbutton();
        },
        //
        onLoadSuccess: function(data) {
            $("#chooseOrgList").datagrid("clearSelections");
        },
        onClickRow: function(rowIndex, rowData) {
            rowid = rowData.id;
            gridname = 'chooseOrgList';
        }
    }); //初始化表格配置，多表格可重复调用，穿入不同的obj即可	


});

function getRowIndex(target) {
    var tr = $(target).closest('tr.datagrid-row');
    return parseInt(tr.attr('datagrid-row-index'));
}
