$(function() {
//  storage = $.localS torage;
//  if (!storage) storage = $.coo kieStorage;
    $('#functionList').treegrid({
        idField: 'id',
        treeField: 'text',
        title: '(1) 社保卡信息',
        url: '../json/menuManager.json,',
        fit: true,
        loadMsg: '',
        pageSize: 10,
        pagination: false,
        pageList: [10, 20, 30],
        sortOrder: 'asc',
        rownumbers: false,
        singleSelect: false,
        fitColumns: true,
        striped: true,
        showFooter: true,
        
        onLoadSuccess: function(data) {
            $("#functionList").treegrid("clearSelections");
        },
        onClickRow: function(rowData) {
            rowid = rowData.id;
            gridname = 'functionList';
        }
    });
    $('#functionList').treegrid('getPager').pagination({
        beforePageText: '',
        afterPageText: '/{pages}',
        displayMsg: '{from}-{to}共 {total}条',
        showPageList: true,
        showRefresh: true
    });
    $('#functionList').treegrid('getPager').pagination({
        onBeforeRefresh: function(pageNumber, pageSize) {
            $(this).pagination('loading');
            $(this).pagination('loaded');
        }
    });
    try {
        restoreheader();
    } catch(ex) {}
});
$(function() {
//  storage = $.localSt orage;
//  if (!storage) storage = $.cookie Storage;
    $('#functionLists').treegrid({
        idField: 'id',
        treeField: 'text',
        title: '(2) 其它个人信息',
        url: '../json/menuManager.json,',
        fit: true,
        loadMsg: '',
        pageSize: 10,
        pagination: false,
        pageList: [10, 20, 30],
        sortOrder: 'asc',
        rownumbers: false,
        singleSelect: false,
        fitColumns: true,
        striped: true,
        showFooter: true,
        
        onLoadSuccess: function(data) {
            $("#functionLists").treegrid("clearSelections");
        },
        onClickRow: function(rowData) {
            rowid = rowData.id;
            gridname = 'functionLists';
        }
    });
    $('#functionLists').treegrid('getPager').pagination({
        beforePageText: '',
        afterPageText: '/{pages}',
        displayMsg: '{from}-{to}共 {total}条',
        showPageList: true,
        showRefresh: true
    });
    $('#functionLists').treegrid('getPager').pagination({
        onBeforeRefresh: function(pageNumber, pageSize) {
            $(this).pagination('loading');
            $(this).pagination('loaded');
        }
    });
    try {
        restoreheader();
    } catch(ex) {}
});

function reloadTable() {
    try {
        $('#' + gridname).datagrid('reload');
        $('#' + gridname).treegrid('reload');
    } catch(ex) {}
}
function reloadfunctionList() {
    $('#functionList').treegrid('reload');
}
function getfunctionListSelected(field) {
    return getSelected(field);
}
function getSelected(field) {
    var row = $('#' + gridname).treegrid('getSelected');
    if (row != null) {
        value = row[field];
    } else {
        value = '';
    }
    return value;
}
function getfunctionListSelections(field) {
    var ids = [];
    var rows = $('#functionList').treegrid('getSelections');
    for (var i = 0; i < rows.length; i++) {
        ids.push(rows[i][field]);
    }
    ids.join(',');
    return ids
};
function getSelectRows() {
    return $('#functionList').datagrid('getChecked');
}
function saveHeader() {
    var columnsFields = null;
    var easyextends = false;
    try {
        columnsFields = $('#functionList').datagrid('getColumns');
        easyextends = true;
    } catch(e) {
        columnsFields = $('#functionList').datagrid('getColumnFields');
    }
    var cols = storage.get('functionListhiddenColumns');
    var init = true;
    if (cols) {
        init = false;
    }
    var hiddencolumns = [];
    for (var i = 0; i < columnsFields.length; i++) {
        if (easyextends) {
            hiddencolumns.push({
                field: columnsFields[i].field,
                hidden: columnsFields[i].hidden
            });
        } else {
            var columsDetail = $('#functionList').datagrid("getColumnOption", columnsFields[i]);
            if (init) {
                hiddencolumns.push({
                    field: columsDetail.field,
                    hidden: columsDetail.hidden,
                    visible: (columsDetail.hidden == true ? false: true)
                });
            } else {
                for (var j = 0; j < cols.length; j++) {
                    if (cols[j].field == columsDetail.field) {
                        hiddencolumns.push({
                            field: columsDetail.field,
                            hidden: columsDetail.hidden,
                            visible: cols[j].visible
                        });
                    }
                }
            }
        }
    }
    storage.set('functionListhiddenColumns', JSON.stringify(hiddencolumns));
}
function isShowBut() {
    var isShowSearchId = $('#isShowSearchId').val();
    if (isShowSearchId == "true") {
        $("#searchColums").hide();
        $('#isShowSearchId').val("false");
        $('#columsShow').remove("src");
        $('#columsShow').attr("src", "plug-in/easyui/themes/default/images/accordion_expand.png");
    } else {
        $("#searchColums").show();
        $('#isShowSearchId').val("true");
        $('#columsShow').remove("src");
        $('#columsShow').attr("src", "plug-in/easyui/themes/default/images/accordion_collapse.png");
    }
}
function restoreheader() {
    var cols = storage.get('functionListhiddenColumns');
    if (!cols) return;
    for (var i = 0; i < cols.length; i++) {
        try {
            if (cols.visible != false) $('#functionList').datagrid((cols[i].hidden == true ? 'hideColumn': 'showColumn'), cols[i].field);
        } catch(e) {}
    }
}
function resetheader() {
    var cols = storage.get('functionListhiddenColumns');
    if (!cols) return;
    for (var i = 0; i < cols.length; i++) {
        try {
            $('#functionList').datagrid((cols.visible == false ? 'hideColumn': 'showColumn'), cols[i].field);
        } catch(e) {}
    }
}
function functionListsearch() {
    try {
        if (!$("#functionListForm").Validform({
            tiptype: 3
        }).check()) {
            return false;
        }
    } catch(e) {}
    if (true) {
        var queryParams = $('#functionList').datagrid('options').queryParams;
        $('#functionListtb').find('*').each(function() {
            queryParams[$(this).attr('name')] = $(this).val();
        });
        $('#functionList').treegrid({
            url: '../json/menuManager.json,',
            pageNumber: 1
        });
    }
}
function dosearch(params) {
    var jsonparams = $.parseJSON(params);
    $('#functionList').treegrid({
        url: '../json/menuManager.json,',
        queryParams: jsonparams
    });
}
function functionListsearchbox(value, name) {
    var queryParams = $('#functionList').datagrid('options').queryParams;
    queryParams[name] = value;
    queryParams.searchfield = name;
    $('#functionList').treegrid('reload');
}
$('#functionListsearchbox').searchbox({
    searcher: function(value, name) {
        functionListsearchbox(value, name);
    },
    menu: '#functionListmm',
    prompt: '请输入查询关键字'
});
function EnterPress(e) {
    var e = e || window.event;
    if (e.keyCode == 13) {
        functionListsearch();
    }
}
function searchReset(name) {
    $("#" + name + "tb").find(":input").val("");
    var queryParams = $('#functionList').datagrid('options').queryParams;
    $('#functionListtb').find('*').each(function() {
        queryParams[$(this).attr('name')] = $(this).val();
    });
    $('#functionList').treegrid({
        url: '../json/menuManager.json,',
        pageNumber: 1
    });
}