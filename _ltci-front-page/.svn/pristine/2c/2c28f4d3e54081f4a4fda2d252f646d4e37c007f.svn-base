var tableColumns = [{
        field: 'applicationid',
        title: 'applicationid',
        checkbox: true
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
        title: '申请人',
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
        title: '民族',
        align: 'center',
        formatter: function(value) {
            return getTableDictionary(this.field, value);
        }
    }, {
        field: 'idCard',
        title: '身份证号码',
        align: 'center'
    }, {
        field: 'securityNumber',
        title: '社保卡',
        align: 'center'
    }, {
        field: 'age',
        title: '年龄',
        align: 'center'
    }, {
        field: 'bidType',
        align: 'center',
        title: '申办类别',
        formatter: function(value) {
            return getTableDictionary(this.field, value);
        }
    }, {
        field: 'disease',
        title: '病种',
        align: 'center'
    }, {
        field: 'address',
        align: 'center',
        title: '现住址'
    }, {
        field: 'mobile',
        title: '联系电话',
        align: 'center'
    },

    {
        field: 'deputyIdCard',
        hidden: true,
        title: '代理人身份证号码'
    }, {
        field: 'deputyAddress',
        align: 'center',
        title: '代理人现地址'
    }, {
        field: 'deputyMobile',
        align: 'center',
        title: '代理人电话'
    }, {
        field: 'applicationStatus',
        align: 'center',
        formatter: function(value, rowData, index) {
            if (value == 04) { //04  待遇申请状态  applicationStatus  审核不通过  点击查看不通过原因
                var applicationReason = rowData.applicationReason;
                return '<a href="javascript:;" style="color:red" onclick = "windowObj.alert(\'不通过原因\',\'' + applicationReason + '\')">' + getTableDictionary(this.field, value) + '</a>';
                // return '<a href="javascript:;" style="color:red" onclick = "showReason(\''+ applicationReason +'\')">' + getTableDictionary(this.field, value) + '</a>'
            }
            return getTableDictionary(this.field, value);
        },
        title: '受理状态'
    }, {
        field: 'applicationReason',
        align: 'center',
        title: '原因',
        hidden: true
    },

    {
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
        field: 'operatedBy',
        align: 'center',
        title: '经办人'
    }, {
        field: 'operatedTime',
        align: 'center',
        formatter: function(value) {
            return formatDate(value);
        },
        title: '经办时间'
    }, {
        field: 'opera',
        title: '操作',
        align: 'center',
        formatter: function(value, rowData, index) { //待遇申请页面状态有01已受理,03审核通过,04审核不通过
            var str = '';
            if (rowData.applicationStatus == '01') { //待遇申请状态判断 01为已受理
                str = '<a href="#" name="opera" class="easyui-linkbutton" onclick="doSearchDetail(\'' + index + '\');stopBubble();">详情</a>' +
                    '&nbsp&nbsp' +
                    '<a href="#" name="opera" class="easyui-linkbutton" onclick="doAccept(\'' + index + '\',true);stopBubble();">通过</a>' +
                    '&nbsp&nbsp' +
                    '<a href="#" name="opera" class="easyui-linkbutton" onclick="doAccept(\'' + index + '\',false);stopBubble();">不通过</a>';
                return str;
            } else {
                str = '<a href="#" name="opera" class="easyui-linkbutton" onclick="doSearchDetail(\'' + index + '\');stopBubble();">详情</a>' +
                    '&nbsp&nbsp' +
                    '<span onclick="stopBubble()"><a href="#" name="opera" class="easyui-linkbutton" disabled="true">通过</a></span>' +
                    '&nbsp&nbsp' +
                    '<span onclick="stopBubble()"><a href="#" name="opera" class="easyui-linkbutton" disabled="true">不通过</a></span>';
                return str;
                //return '<a href="#" name="opera" class="easyui-linkbutton" onclick="doSearchDetail(\'' + index + '\')">查看详情</a>';
            }

        }
    }
];
$(function() {
    initGridSet({
        id: 'userList', //表格id
        title: '申请受理', //表格头
        idField: 'applicationid', //    表格主键
        columns: tableColumns, //   表格列
        url: portalServiceUrl + "/api/v1/mobileTreatmentApplications", //   配置表格默认查询参数
        type: 'post', //    表格默认查询参数
        singleSelect: false,
        query: { // 表格默认查询参数
            insuredPersonName: '',
            idCard: '',
            applicationStatus: '01,03,04', //默认查询参数
            operatedTime: '',
            securityNumber: '',
            page: TableObj.page,
            pageSize: TableObj.pageSize
        }
    }); //初始化表格配置，多表格可重复调用，穿入不同的obj即可

    TableObj = getGridObjById('userList'); //TableObj切换当前表格为激活状态
    initDataGrid(); //初始化表格
    loadGridData(); //加载表格数据
});
