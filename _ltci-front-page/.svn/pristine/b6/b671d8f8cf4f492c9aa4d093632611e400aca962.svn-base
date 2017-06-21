var tableData={
    "total": 2,
    "rows": [{
		"departname": "",
        "shenqinjigou": "荆门市东宝区长宁居养老院",
        "jigoubianma": "JM-65428",
		"jiesuanyuefen":"3月",
        "id": "8ab3f90e5a4f527d015a4fc38bb90010",
    },
	{
		"departname": "",
        "shenqinjigou": "荆门市东宝区长宁居养老院",
        "jigoubianma": "JM-65428",
		"jiesuanyuefen":"3月",
        "id": "8ab3f90e5a4f527d015a4fc38bb90010",
    },
	{
		"departname": "",
        "shenqinjigou": "荆门市东宝区长宁居养老院",
        "jigoubianma": "JM-65428",
		"jiesuanyuefen":"3月",
        "id": "8ab3f90e5a4f527d015a4fc38bb90010",
    },
	{
		"departname": "",
        "shenqinjigou": "荆门市东宝区长宁居养老院",
        "jigoubianma": "JM-65428",
		"jiesuanyuefen":"3月",
        "id": "8ab3f90e5a4f527d015a4fc38bb90010",
    },
	{
		"departname": "",
        "shenqinjigou": "荆门市东宝区长宁居养老院",
        "jigoubianma": "JM-65428",
		"jiesuanyuefen":"3月",
        "id": "8ab3f90e5a4f527d015a4fc38bb90010",
    }
	]
};
	
	
	var tableColumns=[{
            field: 'id',
            title: 'id',			
            hidden: true
        },
        {
            field: 'shenqinjigou',
            title: '申请机构',
            sortable: true,
			align:'center',
			width:280
        },
        {
            field: 'jigoubianma',
            title: '机构编码',
			sortable: true,
			align:'center',
			width:280
        },{
            field: 'jiesuanyuefen',
            title: '结算月份',
			sortable: true,
			align:'center',
			width:270
		},
        {
            field: 'Ddui',
            title: '对账单',
            sortable: true,
			align:'center',
			width:280,
			formatter:function(value, row, index){  
				var str = '<a href="../feeBalanceManage/fee_details.html" name="opera" class="easyui-linkbutton">查看机构明细单</a>';  
				return str;  
			}
        }];
	
	
	
	$(function() {
			var dg=$('#userList');

		$('#userList').datagrid({
		idField : 'id',
		//treeField : '费用审核',
		title : '对账单',
		//url : reqUrl,
		method: 'get',
		data: tableData,
		fit : true,
		queryParams : {},
		pageNumber : 1,
		pageSize : 10,
		pagination : false,
		pageList : [ 10, 20, 30 ],
		sortName : 'createDate',
		sortOrder : 'desc',
		nowrap : true, 
		loadMsg:'',
		rownumbers : true,
		singleSelect : true,
		fitColumns : false,
		striped : true,
		showFooter : true,
		frozenColumns : [ [] ],
		columns : [ tableColumns ],
		loadFilter : function(data){
			//'{"status":200,"rows":[{"id":"410ec79138ec4a1e8e2ed1c84d2238fd","parentId":"0","resName":"菜单管理","description":"菜单管理","url":"www.baidu.com","sequence":null,"isMenu":null,"isValid":1,"createBy":"dingding","updateBy":"zhangsan"}],"message":null,"page":1,"pageSize":10,"total":1,"totalPageNum":1}';
			console.log(data.datas);
			if(data.datas===undefined)
				return data;
			var parseData=[];
			for(var i=0;i<data.datas.length;i++){
				var obj=data.datas[i];
				obj.children=obj.childMenu;
				obj.state='closed'; //open;
				parseData[i]=obj;
			}
			//console.log("loadFilter1="+JSON.stringify(retData));
			var retData={
					total : data.totalDataNum,
					rows : parseData
			};
			console.log("loadFilter2="+JSON.stringify(retData));
			return retData;
		},
		onLoadSuccess : function(data) {
			//$("#resList").datagrid("clearSelections");
			return false;
		},
		onCheck : function(row) {
			//app.vue_rowIndex = rowData.id
			//console.log("onCheck="+JSON.stringify(row));
		}
	});
});

		