var IslayWinTop = false;
var LayWin = doLayWin(); //layer封装
var TableObj = { //table object 表格对象
    id: '', //表格id
    idField: '', //表格主键
    title: '', //表格title
    page: 1, //页码
    pageSize: 10, //每页行数
    totalDataNum: 0, //总行数
    totalPageNum: 0, //总页数
    pageList: [10, 20, 30],
    rowIndex: 0, //获取表格选中行数
    rowData: [], //获取当前点击表格数据
    columns: [], //表格列
    data: [], //表格数据
    query: {}, //查询条件
    url: '', //url
    //type:'grid',//表格或者树  tree
    pagination: true, //是否分页
    rownumbers: true, //行号
    singleSelect: true, //单选
    grid: null, //表格easyui对象
    onLoadSuccess: function() {},
    onClickRow: function() {},
    onCheck: function() {},
    onBeforeEdit: function() {},
    onAfterEdit: function() {},
    onCancelEdit: function() {}
};
if (!top.windowTop) {
   //top.window.location = '../../index.html';
}
var DataGridList = [];
var fileObj = {
    fileId: '',
    fileName: '',
    fileType: ''
};
var fileList = [];
//var transObject = {
//  _response: '',
//  data: null,
//  send: function(httpUrl, httpType, httpData, bAsync, contentType) {
//      httpUrl += getURLRandomNum();
//      if (isDebug) {
//          console.log("请求URL:", httpType + "  " + httpUrl);
//          console.log("请求参数:", httpData);
//      }
//      process.on();
//      if (bAsync === undefined) bAsync = false;
//      if (contentType === undefined) contentType = "application/x-www-form-urlencoded";
//      transObject._response = $.ajax({
//          type: httpType,
//          url: httpUrl,
//          async: bAsync,
//          contentType: contentType,
//          timeout: 3000,
//          //cache:false,
//          crossDomain: true, //同域请求
//          data: httpData,
//          success: function(msg) {
//              transObject.data = msg;
//              if (isDebug) console.log("请求返回信息:", msg);
//          },
//          error: function(event) {
//              if (isDebug) console.log(event);
//              catchError(event);
//          },
//          complete: function(XMLHTTPRequest, status) {
//              //console.log(XMLHTTPRequest);
//              //console.log(status);
//              process.off();
//              if (status == "408") {
//                  $.messager.alert('提示', 'ajax请求超时！');
//              }
//          }
//      }).responseText;
//  }
//};

$(function() {
    //$("body").on('click', bodyOnclick) //绑定页面点击事件
    loadDataPicker();
    loadDictionary(); //加载表单数据字典
    window.history.forward(0); //禁用页面后退按钮 
    // $(document).bind("contextmenu",function(e){return false;});
    // $(window).resize(function() {
        // console.log('窗口改变后大小', '高度：' + $(window).height() + '  宽度：' + $(window).width());
        // $("#app").panel("resize",{
        // 	width:$(window).width(),
        // 	height:$(window).height()
        // });
    // });
    //加载页面后检查权限
    checkMenu();

    //检查input与textarea输入合法性
    checkInputSafe();
});
