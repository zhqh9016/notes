	var tableColumns = [{
	    field: 'serialNum',
	    title: 'serialNum',
	    hidden: true
	}, {
	    field: 'agencyName',
	    title: '申请机构名称',
	    align: 'center'
	}, {
	    field: 'agencyLevel',
	    title: '定点机构类别',
	    formatter: function(value) {
	        return getTableDictionary('agencyLevel', value); },
	    align: 'center'
	}, {
	    field: 'agencyServiceType',
	    title: '定点服务机构类型',
	    formatter: function(value) {
	        return transDictionary(value); },
	    align: 'center'
	}, {
	    field: 'agencyType',
	    title: '机构类型',
	    formatter: function(value) {
	        return Dictionary(value); },
	    align: 'center'
	}, {
	    field: 'practiceLicense',
	    title: '机构许可证编号',
	    align: 'center'
	}, {
	    field: 'agencyApplicat',
	    title: '申请人'
	}, {
	    field: 'agencyApplyDate',
	    title: '申请日期',
	    //formatter: function(value) { return getTableDictionary(this.field, value) },
	    align: 'center'
	}, {
	    field: 'agencyState',
	    title: '受理状态',
	    formatter: function(value, row, index) {
	        if (value == '3') {
	            str = '<a style="color:#FF0000;cursor:pointer;" onclick="cause(\'' + index + '\')">' + getTableDictionary('acceptState', value) + '</a>';
	        } else {
	            str = getTableDictionary('acceptState', value);
	        }
	        return str;
	    },
	    align: 'center'
	}, {
	    field: 'cz',
	    title: '操作',
	    align: 'center',
	    formatter: function(value, row, index) {
	        var str = '<a href=\"#\" name=\"opera\" class=\"easyui-linkbutton\" onclick=\"accept(\'' + index + '\')\">操作</a>';
	        return str;
	    }
	}];
	$(function() {
	    initGridSet({
	        //var dg = $('#userList')
	        //var tableData = []	
	        id: 'userList', //表格id
	        title: '机构在线受理', //表格头
	        idField: 'patrolTaskId', //	表格主键
	        columns: tableColumns, //	表格列
	        url: portalServiceUrl + "/api/v1/agencyHistory/list", //	配置表格默认查询参数
	        type: 'get', //	表格默认查询参数	
	        query: { //	表格默认查询参数
	            agencyName: '', //机构名称
	            dsignatedAgencyLevel: '', //定点机构类别
	            dsignatedAgencyType: '', //定点服务机构类型
	            agencyType: '', //机构类型
	            acceptState: '1', //受理状态
	            applyBeginDate: '', //申请开始日期
	            applyEndDate: '', //申请结束时间
	            page: TableObj.page,
	            pageSize: TableObj.pageSize
	        }
	    }); //初始化表格配置，多表格可重复调用，穿入不同的obj即可
	    $("#acceptState").combobox('setValue', '1'); //受理状态，默认查询未处理（值为1）的数据
	    TableObj = getGridObjById('userList'); //TableObj切换当前表格为激活状态
	    initDataGrid(); //初始化表格
	    loadGridData(); //加载表格数据
	});




	function transDictionary(s) { //定义方法，传入字符串值，返回对应数据字典
	    if (!s) return '';
	    var arr = s.split(','); //[1,2]
	    var str = "";
	    for (var i = 0; i < arr.length; i++) {
	        if (i !== 0) str += ",";
	        str += getTableDictionary('agencyServiceType', arr[i]);
	    }
	    return str;
	}

	function Dictionary(s) { //定义方法，传入字符串值，返回对应数据字典
	    if (!s) return '';
	    var arr = s.split(','); //[1,2]
	    var str = "";
	    for (var i = 0; i < arr.length; i++) {
	        if (i !== 0) str += ",";
	        str += getTableDictionary('agencyType', arr[i]);
	    }
	    return str;
	}
