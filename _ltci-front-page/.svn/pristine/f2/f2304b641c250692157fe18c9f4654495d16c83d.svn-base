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
    title: '经办机构'
}, {
    field: 'feeStarttime',
    title: '开始日期',
    sortable: false,
    align: 'center',
    formatter: function(value) {
        return formatDate(value);
    }

}, {
    field: 'feeEndtime',
    title: '终止日期',
    sortable: false,
    align: 'center',
    formatter: function(value) {
        return formatDate(value);
    }

}, {
    field: 'nurseTotalAmount',
    title: '总费用合计',
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
    field: 'siPay',
    title: '统筹支出合计',
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
    field: 'paySelf',
    title: '自付合计',
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
    field: 'expenseSelf',
    title: '自费合计',
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
    field: 'unrFee',
    title: '不合理费用合计',
    sortable: false,
    align: 'center',
    formatter: function(value, row, index) {
        if (value === null) {
            return '0.00';
        } else {
            var str = '<a href="#" name="opera" style="color:#FF0000" onclick="doAccept(\'' + index + '\',\'' + value + '\')">' + (row.unrFee).toFixed(2) + '</a>';
            return str;
        }

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
    title: '审核状态', //审核状态（只有'1':待处理'或'4':复核不通过 空：未处理）
    sortable: false,
    align: 'center',
    //width:80,
    formatter: function(value, row, index) {
        var str = '';
        if (value === '' || value === undefined || value === null || value == '1') {
            str = "未处理";
        } else if (value == '4') {
            str = '<a href="#" name="opera" onclick="cause(\'' + index + '\',0)" style="color:#FF0000">复核未通过</a> ';
        }
        return str;
    }
}, {
    field: 'caozuo',
    title: '操作',
    sortable: false,
    //width:140,
    align: 'center',
    formatter: function(value, row, index) {
        var str = '<a href="#" name="opera" class="easyui-linkbutton" onclick="doAccept(\'' + index + '\',0)">明细</a> ';
        str += '&nbsp;<a href="#" name="opera" class="easyui-linkbutton" onclick="bc(\'' + index + '\',0)">保存</a>';
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
        //width:80
}, {
    field: 'beCarePersonCardNum',
    title: '身份证号码',
    sortable: false,
    align: 'center'
        //width:160
}, {
    field: 'socSecNum',
    title: '社会保障卡号码',
    sortable: false,
    align: 'center'
        //width:160
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
}, {
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
        var str = parseFloat(value).toFixed(2);
        return str;
    },
    editor: {
        type: 'numberbox',
        options: { precision: 2 }
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
        }
        var str = value.toFixed(2);
        return str;
    }
}, {
    field: 'xiangqing',
    title: '操作',
    sortable: false,
    width: 200,
    align: 'center',
    formatter: function(value, row, index) {
        var btns = "";
        if (row.editing) { //<span class="l-btn-left"><span class="l-btn-text"></span></span>
            btns = '<a href="#" class="easyui-linkbutton l-btn l-btn-plain" onclick="saveRow(this)">保存</a>';
            btns += '&nbsp;<a href="#" class="easyui-linkbutton l-btn l-btn-plain" onclick="cancelRow(this)">关闭</a>';
        } else {
            btns = '&nbsp;<a href="#" class="easyui-linkbutton l-btn l-btn-plain" onclick="editRow(this)">编辑</a>  ';
        }
        var str = '&nbsp;<a href="#" class="easyui-linkbutton l-btn l-btn-plain" onclick="feeDetail(this)">详情</a>';
        return btns + str;
    }
}];
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
    //maxDate = date.getFullYear() + "-" + (date.getMonth() * 1 + 1) + "-"
    //+ date.getDate();
    //console.log(maxDate)
    $("#search_feeStarttime").bind("focus", function() {
        WdatePicker({
            drrDealMode: 1,
            maxDate: minDate,
            opposite: true,
            disabledDates: ['....-..-01'], //['5$','2$','3$','4$','6$','7$','8$','9$','0$','11','21','31'],
            dateFmt: 'yyyy-MM-dd',
            readOnly: true,
            //startDate:
            //alwaysUseStartDate: true,
            //autoPickDate: false

        });
    });
    $("#search_feeEndtime").bind("focus", function() {
        WdatePicker({
            drrDealMode: 1,
            opposite: true,
            maxDate: '%y-{%M-1}-%ld',
            minDate: $("#search_feeStarttime").val(),
            disabledDates: getMonthLastDays(),
            //disabledDates: getMonthDays('%y','{%M-1}'),		
            dateFmt: 'yyyy-MM-dd',
            readOnly: true,
            //alwaysUseStartDate: true
        });
    });
    maxDate = date.getFullYear() + "-" + (date.getMonth() * 1 + 1) + "-" + date.getDate();
    $("#search_startDate").bind("focus", function() {
        WdatePicker({ //minDate:$("#search_feeStarttime").val()+"-01",
            ///maxDate: $("#search_feeEndtime").val() ,
            drrDealMode: 1,
            dateFmt: 'yyyy-MM-dd',
            readOnly: false,
            //alwaysUseStartDate: true
        });
    });
    $("#search_endDate").bind("focus", function() {
        WdatePicker({
            minDate: $("#search_startDate").val(),
            maxDate: $("#search_feeEndtime").val(),
            drrDealMode: 1,
            dateFmt: 'yyyy-MM-dd',
            readOnly: false,
            //alwaysUseStartDate: true
        });
    });


    initGridSet({
        id: 'userList', //表格id
        title: '费用审核', //表格头
        idField: 'id', //	表格主键
        columns: tableColumns, //	表格列
        url: portalServiceUrl + "/api/v1/orgSettlement/countData", //	配置表格默认查询参数
        type: 'post', //	表格默认查询参数
        query: { //	表格默认查询参数
            orgCode: '',
            orgName: '',
            auditState: '',
            feeStarttime: '',
            feeEndtime: '',
            page: TableObj.page,
            pageSize: TableObj.pageSize
        }
    }); //初始化表格配置，多表格可重复调用，穿入不同的obj即可
    TableObj = getGridObjById('userList'); //TableObj切换当前表格为激活状态
    initDataGrid(); //初始化表格
    loadGridData(); //加载表格数据

    var backFeeSH = '<a href="#" class="" onclick="showParent()"><span class="l-btn-left-d"><span class="l-btn-text">返回</span></span></a>&nbsp;&nbsp;';
    initGridSet({
        id: 'List', //表格id
        title: backFeeSH + '当前位置 : 费用审核＞月结明细', //表格头
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
        }
    }); //初始化表格配置，多表格可重复调用，穿入不同的obj即可




});
//var isLoaded=false;
//function loadTable2(fee) {
//if(!isLoaded){

//var dgg=$('#List')
//var tableDataa = []

//	$('#List').datagrid({
//		idField: 'id',
//		title: backFeeSH + '当前位置 : 费用审核＞日结明细',
//		//url : reqUrl,		
//		data: tableDataa,
//		queryParams: {},
//		loadMsg: '',
//		pageSize: 10,
//		pagination: true,
//		pageList: [10, 20, 30],
//		sortName: 'createDate',
//		sortOrder: 'desc',
//		nowrap: true,
//		rownumbers: true,
//		fit: true,
//		singleSelect: true,
//		showFooter: true,
//		frozenColumns: [
//			[]
//		],
//		columns: [tableColumn],
//		onLoadSuccess: function(data) {
////			$("#List").datagrid("clearSelections");
//		},
//		onClickRow: function(rowIndex, rowData) {
//			TableObj.rowIndex = rowIndex		
//			TableObj.rowData = rowData
//			rowid = rowData.id;
//			gridname = 'List';
//		},
//		onCheck: function(rowIndex, rowData) {
//			TableObj.rowIndex = rowIndex
//			TableObj.rowData = rowData
//		},
//		onBeforeEdit: function(index, row) {
//			row.editing = true;
//			updateActions(index);
//		},
//		onAfterEdit: function(index, row) {
//			row.editing = false;
//			updateActions(index);
//		},
//		onCancelEdit: function(index, row) {
//			row.editing = false;
//			updateActions(index);
//		}
//	});
//	getGridPager('List', function() { doLoading1(fee) }) //设置表格分页数据
//}
//doLoading2(fee);
//isLoaded=true;
//}

function updateActions(index) {
    $('#List').datagrid('updateRow', {
        index: index,
        row: {}
    });
}

function getRowIndex(target) {
    var tr = $(target).closest('tr.datagrid-row');
    return parseInt(tr.attr('datagrid-row-index'));
}

function editRow(target) {

    $('#List').datagrid('beginEdit', getRowIndex(target));
    //$('#List').datagrid('selectRow', getRowIndex(target));
}

function saveRow(target) {
    var index = getRowIndex(target);
    $('#List').datagrid('endEdit', index);
    //$('#List').datagrid('selectRow', index);
    var rows = $('#List').datagrid('getRows');
    console.log(rows);
    var id = rows[index].id;
    var siPay = rows[index].siPay;
    var unrFee = rows[index].unrFee;
    var version = rows[index].version;
    console.log(unrFee);
    if (unrFee < 0) {
        $.messager.alert('提示', '不合理费用不能是负数');
        doLoading2();
        return false;
    }
    var sUrl = portalServiceUrl + "/api/v1/monSetPer";
    var obj = {
        unrFee: unrFee,
        id: id,
        siPay: siPay,
        version: version
    };
    sendAjax(sUrl, "put", obj, function(tableData) {
        if (tableData.status == "200") {
            showMsg("不合理费用录入成功！");
            //	$('#List').datagrid('refreshRow', index);
            loadGridData();
        } else {
            //showMsg(tableData.message);
            $.messager.alert('提示', tableData.message);
            doLoading2();
        }
    });

}

function cancelRow(target) {

    $('#List').datagrid('cancelEdit', getRowIndex(target));
    //$('#List').datagrid('refreshRow', getRowIndex(target));
}
