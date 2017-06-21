var param = {
    page: 1,
    pageSize: 10,
    parentid: 0
};

var dg = $('#orgList');
var tableData = [];
var tableColumns = [{
    field: 'id',
    title: 'id',
    hidden: true
}, {
    field: 'parentid',
    title: '父级ID',
    hidden: true
}, {
    field: 'code',
    title: '编码'
        //width: 180,
}, {
    field: 'name',
    title: '名称'
        //width: 180,
}, {
    field: 'provinceName',
    title: '省'
}, {
    field: 'cityName',
    title: '市'
}, {
    field: 'countyName',
    title: '区'
}, {
    field: 'description',
    title: '描述'
}, {
    field: 'isOrg',
    title: '组织类型',
    /*formatter: function(value, rec, index) {
    	console.log(value);
    	if(value === undefined) return '';
    	if(value == '1') {
    		return '机构';
    	}
    	if(value == '2') {
    		return '部门';
    	}
    }*/
    formatter: function(value) {
        return getTableDictionary(this.field, value); }
}, {
    field: 'createdTime',
    title: '创建时间',
    formatter: function(value) {
        var date = value.split(' ');
        //console.log(date[0]);
        return date[0];
    }
}, {
    field: 'cz',
    title: '操作',
    align: 'center',
    formatter: function(value, row, index) {
        var id = row.id;
        var str = '<a href=\"#\" name=\"opera\" class=\"easyui-linkbutton\" onclick=\"zx(\'' + id + '\')\">用户信息</a>';
        return str;
    }
}];
$(function() {
    dg.treegrid({
        idField: 'id',
        treeField: 'code',
        title: '组织机构',
        data: tableData,
        pageSize: 10,
        pagination: true,
        pageList: [10, 20, 30],
        rownumbers: true,
        loadMsg: '',
        singleSelect: true,
        fit: true,
        resizeHandle: 'right',
        striped: true,
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
    getTreeGridPager('orgList', doLoading); //设置表格分页数据
    doLoading();

    //初始化省市区下拉框
    clearAreaInfo("#province", "#city", "#area");
    //初始化省市区数据
    getAreaData("#province", "#city", "#area");
    //getAreaData("#edit_proName", "#edit_cityName", "#edit_areaName");
});

$('#editWindow').window({
    title: '编辑机构',
    width: 600,
    height: 400,
    closed: true,
    modal: true,
    collapsible: false,
    minimizable: false,
    maximizable: false
});
$('#addWindow').window({
    title: '新增机构',
    width: 600,
    height: 400,
    closed: true,
    modal: true,
    collapsible: false,
    minimizable: false,
    maximizable: false
});

$('#fee_detailsWindow').window({
    title: '用户信息',
    width: 990,
    height: 440,
    closed: true,
    modal: true,
    collapsible: false,
    minimizable: false

});

function doOpenAdd() {
    //$("#addForm")[0].reset()
    //获取选中行的id  
    $('#addForm input').val('');
    var rows = $('#orgList').treegrid('getSelections');
    if (rows.length == 1 && rows.parentid != "0") {

        $("#aa").show();
        $("#add_parentId").val(rows[0].id);
        $('#editName1').val(rows[0].name);
        $('#addWindow').window('open');
    } else {
        $("#add_parentId").val("0"); //机构根节点为零
        $("#aa").hide();
        $('#addWindow').window('open');
    }

}

function doOpenEdit() {
    if (isCheck()) {
        var row = $('#orgList').datagrid('getSelected');
        console.log(row);
        if (row.length < 1) {
            $('#editWindow').window('close');
        } else {
            //赋值
            $("#edit_parentId").val(row.parentid);
            $('#editOperatedBy').val(row.operatedBy);
            $('#editId').val(row.id);
            $('#editName').val(row.name);
            $('#editCode').val(row.code);
            $('#editSequence').val(row.sequence);
            $('#editDescription').val(row.description);
            console.log("__row.provinceid=" + row.provinceid);
            $('#edit_isOrg').combobox({ value: row.isOrg });
            $('#editWindow').window('open');
            $("#edit_proName").combobox({
                valueField: 'id',
                textField: 'areaName',
                data: getNextarea(0),
                onSelect: function(selectedValue) {
                    clearAreaInfo($("#edit_cityName"));
                    clearAreaInfo($("#edit_areaName"));
                    //console.log(selectedValue);
                    $("#edit_cityName").combobox({
                        valueField: 'id',
                        textField: 'areaName',
                        data: getNextarea(selectedValue.id),
                        onSelect: function(selectedValue) {
                            clearAreaInfo($("#edit_areaName"));
                            //console.log(selectedValue);
                            $("#edit_areaName").combobox({
                                valueField: 'id',
                                textField: 'areaName',
                                data: getNextarea(selectedValue.id)
                            });
                        }
                    });
                }
            });
            $("#edit_cityName").combobox({
                valueField: 'id',
                textField: 'areaName',
                data: getNextarea(row.provinceid)
            });
            $("#edit_areaName").combobox({
                valueField: 'id',
                textField: 'areaName',
                data: getNextarea(row.cityid)
            });

            $('#edit_proName').combobox("select", row.provinceid);
            $('#edit_cityName').combobox("select", row.cityid);
            $('#edit_areaName').combobox("select", row.countyid);

            if (row.isOrg == 2) {
                $('#editid').hide();
                $('#edit_isOrg').combobox({ disabled: true });
                $('#edit_proName').combobox({ required: false });
                $('#edit_cityName').combobox({ required: false });
                $('#edit_areaName').combobox({ required: false });
            } else {
                $('#editid').show();
                $('#edit_isOrg').combobox({ disabled: false, value: row.isOrg });
                $('#edit_pro').combobox({ required: true, value: row.provinceName });

            }
        }
    }

}

function doAdd() {
    console.log($("#addForm input[name=isOrg]").val());
    var row = $('#orgList').datagrid('getSelected');
    if (!$("#addForm").form("validate")) {
        $.messager.alert('警告', '请检查必填项');
        return false;
    }
    //判断是否是部门
    if (row && row.isOrg == "2" && $("#addForm input[name=isOrg]").val() == '1') {
        $.messager.alert('警告', '只能添加部门');
        return false;
    }

    if ($("#addForm input[name=isOrg]").val() == "1" && !$("#addForm input[name=countyid]").val()) { //机构
        // if() {//所在地校验
        showMsg("请完善所在地！");
        return false;
        // }
    }
    var url = portalServiceUrl + "/api/v1/organization";
    var obj = $("#addForm").serialize();
    sendAjax(url, "post", obj, function(data) {
        if (data.status != "200") {
            $.messager.alert('添加状态', data.message);
            return false;
        } else {
            $('#addWindow').window('close');
            showMsg("新建机构成功！");
            doLoading();
        }
    }, false);
}

function doEdit() {
    //获取选中行的id
    if (!$("#editWindow input[name=countyid]").val()) {
        $.messager.alert("提示", "请完善所在地！");
        return false;
    }
    if (!$("#editWindow input[name=cityid]").val()) {
        $.messager.alert("提示", "请完善所在地！");
        return false;
    }
    if (!$("#editWindow input[name=provinceid]").val()) {
        $.messager.alert("提示", "请完善所在地！");
        return false;
    }
    if ($("#editForm").form("validate")) {
        var row = getSelectionRow();
        if (!row) return false;

        var httpData = $("#editForm").serialize();
        console.log(httpData);
        $.ajax({
            type: 'put',
            url: portalServiceUrl + "/api/v1/organization/" + row.id,
            async: false,
            data: httpData,
            success: function(msg) {
                console.log("_doEdit_success:", msg);
                if (msg.status == "200") {
                    $('#editWindow').window('close');
                    showMsg(msg.message);
                    doSearch();
                } else {
                    $.messager.alert('提示', msg.message);
                }
            }
        });
    }
}

function doDel() {
    //获取选中行的id		
    if (isCheck()) {
        $.messager.confirm('确认', '您确认想要删除记录吗？', function(r) {
            if (r) {
                var row = getSelectionRow();
                //if(!row) return false;
                var url = portalServiceUrl + "/api/v1/organization/" + row.id;
                sendAjax(url, 'delete', '', function(tableData) {
                    if (tableData.status != "200") {
                        $.messager.alert('提示', tableData.message);
                    } else {
                        showMsg("信息删除成功！");
                        doLoading();
                    }
                }, false);
            }
        });
    }
}

function doLoading() {
    var obj = {
        page: param.page,
        pageSize: param.pageSize,
        parentid: 0,
        code: $("#code").val(),
        name: $("#name").val()
    };
    var url = portalServiceUrl + "/api/v1/organization/list";
    sendAjax(url, "post", obj, function(data) {
        treeGridLoadData('orgList', data);
    });
}

function doSearch(currentPage, currentSize) {
    TableObj.page = 1;
    TableObj.pageSize = 10;
    doLoading();
}

function doClose(objId) {
    $('#editForm input').val('');
    $('#' + objId).window('close');
}


$('#add_isOrg').combobox({
    onSelect: function(record) {
        if ($("#addForm input[name=isOrg]").val() == "1") {
            $('#trArea').show();
            $('#province').combobox({ required: true });
            $('#city').combobox({ required: true });
            $('#area').combobox({ required: true });
        } else {
            $('#trArea').hide();
            $('#province').combobox({ required: false });
            $('#city').combobox({ required: false });
            $('#area').combobox({ required: false });
        }
    }
});

function getSelectionRow() {
    var rows = $('#orgList').treegrid('getSelections');
    if (rows.length <= 0) {
        alert("请先选中一行");
        return false;
    }
    if (rows.length > 1) {
        alert("只能选中一行操作");
        return false;
    }
    return rows[0];
}

function isCheck() {
    var arr = $('#orgList').datagrid('getChecked');
    if (arr.length < 1) {
        $.messager.alert('提示', '请选择一行数据再进行操作');
        return false;
    }
    return true;
}

function zx(index) {
    //var orgid = $('#orgList').treegrid('getSelected', index);
    var departmentid = index;
    var url = "../userMangerment/fee_user_org_role.html?";
    url += "&departmentid=" + departmentid;
    $("#fee_detailsIframe").attr('src', url);
    $('#fee_detailsWindow').window('open');
}
