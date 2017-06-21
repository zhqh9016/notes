var tableColumns = [{
        field: 'applicationid',
        title: 'applicationid',
        hidden: true
            //checkbox: true
    }, {
        field: 'applicationCode',
        title: 'applicationCode',
        hidden: true
    }, {
        field: 'insuredPersonCode',
        title: 'insuredPersonCode',
        hidden: true
    }, {
        field: 'insuredPersonName',
        title: '申请人姓名',
        align: 'center'
    }, {
        field: 'insuredPersonGender',
        title: '性别',
        align: 'center',
        formatter: function(value) {
            return getTableDictionary('sex', value);
        }
    }, {
        field: 'nation',
        align: 'center',
        title: '民族',
        formatter: function(value) {
            return getTableDictionary(this.field, value);
        }
    }, {
        field: 'securityNumber',
        title: '社保卡',
        align: 'center'
    }, {
        field: 'idCard',
        align: 'center',
        title: '身份证号码'
    }, {
        field: 'age',
        align: 'center',
        title: '年龄'
    }, {
        field: 'bidType',
        title: '申办类型',
        align: 'center',
        formatter: function(value) {
            return getTableDictionary(this.field, value);
        }
    },
    // {
    // 	field: 'disease',
    // 	title: '病种',
    // 	formatter: function(value) { return getTableDictionary(this.field, value); },
    // 	sortable: true
    // },
    {
        field: 'mobile',
        title: '电话',
        align: 'center'
    }, {
        field: 'address',
        title: '地址',
        align: 'center'
    }, {
        field: 'deputyIdCard',
        title: '代理人身份证',
        align: 'center'
    }, {
        field: 'deputyAddress',
        align: 'center',
        title: '代理人地址'
    }, {
        field: 'deputyMobile',
        align: 'center',
        title: '代理人电话'
    }, {
        field: 'applicationStatus',
        align: 'center',
        formatter: function(value, rowData, index) {
            if (value == 02) { //04  待遇申请状态  applicationStatus  暂停受理  点击查看暂停受理原因
                var applicationReason = rowData.applicationReason;
                return '<a href="javascript:;" style="color:red" onclick = "showReason(\'' + applicationReason + '\')">' + getTableDictionary(this.field, value) + '</a>';
            }
            return getTableDictionary(this.field, value);
        },
        title: '受理状态'
    }, {
        field: 'applicationReason',
        align: 'center',
        hidden: true,
        title: '原因'
    }, {
        field: 'operatedBy',
        align: 'center',
        title: '操作员'
    }, {
        field: 'operatedTime',
        align: 'center',
        formatter: function(value) {
            return formatDate(value);
        },
        // formatter: function(value) {
        // 	var date = new Date(value);
        // 	return date.dataformat("yyyy-M-d h:m:s");
        // },
        title: '操作时间'
    }, {
        field: 'securityNumberScan',
        hidden: true,
        title: '社保卡附件'
    }, {
        field: 'idCardScan',
        hidden: true,
        title: '身份证附件'
    }, {
        field: 'caseHistoryScan',
        hidden: true,
        title: '病历附件'
    }, {
        field: 'applicationFormScan',
        hidden: true,
        title: '申请表附件'
    }, {
        field: 'opera',
        title: '操作',
        align: 'center',
        formatter: function(value, rowData, index) {
            var str = '';
            if (rowData.applicationStatus == "00") { //待遇申请状态为未受理时可以查看详情，进行受理不受理操作
                str = '<a href="#" name="opera" class="easyui-linkbutton" onclick="doSearchDetail(\'' + rowData.applicationCode + '\');stopBubble();">详情</a>' +
                    '&nbsp&nbsp' +
                    '<a href="#" name="opera" class="easyui-linkbutton" onclick="doAccept(\'' + index + '\',true);stopBubble();">受理</a>' +
                    '&nbsp&nbsp' +
                    '<a href="#" name="opera" class="easyui-linkbutton" onclick="doAccept(\'' + index + '\',false);stopBubble();">暂停受理</a>';
                return str;
            } else if (rowData.applicationStatus == "02") { //待遇申请状态为暂停受理时可以查看详情，进行受理操作,但不能不受理操作
                str = '<a href="#" name="opera" class="easyui-linkbutton" onclick="doSearchDetail(\'' + rowData.applicationCode + '\');stopBubble();">详情</a>' +
                    '&nbsp&nbsp' +
                    '<a href="#" name="opera" class="easyui-linkbutton" onclick="doAccept(\'' + index + '\',true);stopBubble();">受理</a>' +
                    '&nbsp&nbsp' +
                    '<span onclick="stopBubble()"><a href="#" name="opera" class="easyui-linkbutton"  disabled="true">暂停受理</a></span>';
                return str;
            }
            //  else {								//其他状态的只能查看详情
            // 	str = '<a href="#" name="opera" class="easyui-linkbutton" onclick="doSearchDetail(\'' + rowData.applicationCode + '\')">详情</a>' +
            // 		'&nbsp&nbsp' +
            // 		'<a href="#" name="opera" class="easyui-linkbutton"  disabled="true">受理</a>' +
            // 		'&nbsp&nbsp' +
            // 		'<a href="#" name="opera" class="easyui-linkbutton"  disabled="true">暂停受理</a>';
            // 	return str;
            // }

        }
    }
];
var dg = $('#userList');
var tableData = [];
$(function() {
    dg.datagrid({
        idField: 'id',
        title: '移动端待遇申请',
        data: tableData,
        pageSize: 10,
        pagination: true,
        fit: true,
        loadMsg: '',
        pageList: [10, 20, 30],
        rownumbers: true,
        striped: true,
        singleSelect: true,
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
