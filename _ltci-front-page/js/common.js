// var portalServiceUrl = 'http://10.130.206.184:8081/portal';
// var systemServiceUrl = 'http://10.130.206.184:8081/system';
var portalServiceUrl = 'http://10.130.206.189:8081/portal';
var systemServiceUrl = 'http://10.130.206.189:8081/system';
//var portalServiceUrl = 'http://localhost:8080';
//var systemServiceUrl = 'http://localhost:8082';
var isDebug = true; //是否调试模式，发布前需要修改为false
var isStorage = true; //是否开启本地缓存，默认开启

//var localStorage = window.localStorage;//localStorage
var process = { //进度条对象
	isOpened: false, //进度条开启状态
	on: function() { //打开进度条
		if(top.windowTop) {
			this.isOpened = true;
			setTimeout(function() {
				if(process.isOpened) {
					top.processOn();
				}
			}, 500); //延迟显示
		} else {
			console.log("加载进度条失败");
			return true;
		}
	},
	off: function() { //关闭进度条
		this.isOpened = false;
		if(top.windowTop) {
			top.processOff();
		} else {
			console.log("加载进度条失败");
			processOff();
			return true;
		}
	}
};

// console.time = blankFunc;
// console.timeEnd = blankFunc;
// console.group = blankFunc;
// console.groupEnd = blankFunc;
if(!isDebug) { //生产模式，禁用console
	console.log = blankFunc;
	console.time = blankFunc;
	console.timeEnd = blankFunc;
	console.group = blankFunc;
	console.groupEnd = blankFunc;
}

function blankFunc(title, s) {}

if(top.windowTop) {
	alert = function(msg) {
		$.messager.alert('提示', msg);
	};
}

var myLoggerObj = null; //日志对象
var myLogger = { //日志对象
	init: function(s, b) {
		if(!s) s = 'defaultLogger'; //默认日志名称
		if(!b) b = true; //默认开启日志
		myLoggerObj = log4javascript.getLogger(s);
		log4javascript.setEnabled(b);
		var popUpApperder = new log4javascript.PopUpAppender();
		myLoggerObj.addAppender(popUpApperder);
		myLoggerObj.info('log4javascript init ok');
	},
	info: function(s) {
		if(!s) return true;
		myLoggerObj.info(s);
	}
};

function doLayWin() {
	if(IslayWinTop) {
		return top.Layer;
	}
	var obj = {
		template: {},
		alert: function(msg, option) {
			if(option.title) { $.messager.alert(option.title, msg); } else { alert(msg); }
		}
	};
	return obj;
	// var layerWin={
	//  alert:function(str,callOk,icon){
	//      if(icon===undefined)icon=-1;
	//      if(callOk===undefined)callOk=function(){};
	//      top.layer.alert(str,{
	//          icon:icon
	//      },function(index){
	//          callOk();
	//          alert(index);
	//          layer.close(index);
	//      });
	//  },
	//  open:function(){

	//  },
	//  confirm:function(){

	//  },
	//  msg:function(){

	//  }
	// };
}
var windowObj = { //弹窗组件
	type: 'easyui',
	alert: function(title, text) {
		if(!title) title = '警告';
		var s = '<div id="win_alert_div">';
		s += '<textarea id="win_alert_textarea" readonly=readonly style="height:150;width:380;">' + text + '</textarea>';
		s += '<div align="center"><a id="win_alert_ok" class="easyui-linkbutton" style="margin-top:3;">确定</a></div>';
		s += '</div>';
		$("body").append(s);
		//判断插件类型适应不同的窗口(待完成)
		$("#win_alert_ok").on('click', function() {
			//var r = $.trim($("#win_alert_text").val());
			// if(callOk && callOk()) {
			$("#win_alert_div").window('close');
			// }
		});
		$("#win_alert_div").window({
			title: title,
			width: 387,
			height: 220,
			modal: true,
			resizable: false,
			collapsible: false,
			minimizable: false,
			maximizable: false,
			onClose: function() {
				$(this).window('destroy');
				$(this).remove();
			}
		});
		$(".easyui-linkbutton").linkbutton();
	},
	confirm: function() {

	},
	prompt: function(title, callOk, callClose) {
		if(!title) title = '录入不通过原因';
		var s = '<div id="win_prompt_div">';
		s += '<textarea id="win_prompt_textarea" style="height:150;width:380; resize: none;"></textarea>';
		s += '<div align="center"><a id="win_prompt_ok" class="easyui-linkbutton" style="margin-top:3;margin-left:250">确定</a>';
		s += '&nbsp;&nbsp;&nbsp;&nbsp;';
		s += '<a id="win_prompt_cancel" class="easyui-linkbutton" style="margin-top:3;margin-left:10">取消</a></div>';
		s += '</div>';
		$("body").append(s);
		//判断插件类型适应不同的窗口(待完成)
		$("#win_prompt_ok").on('click', function() {
			var r = $.trim($("#win_prompt_textarea").val());
			if(callOk && callOk(r)) {
				$("#win_prompt_div").window('close');
			}
		});
		$("#win_prompt_cancel").on('click', function() {
			if(callClose) callClose();
			$("#win_prompt_div").window('close');
		});
		$("#win_prompt_div").window({
			title: title,
			width: 387,
			height: 220,
			modal: true,
			resizable: false,
			collapsible: false,
			minimizable: false,
			maximizable: false,
			onClose: function() {
				$(this).window('destroy');
				$(this).remove();
			}
		});
		$(".easyui-linkbutton").linkbutton();
	}
};
//校验合法输入及路径
function checkSafe(str) {
	var reg = /[<|>|'|"]+/;
	if(str.match(reg)) {
		return false;
	} else {
		return true;
	}
}

function sendAjax(httpUrl, httpType, httpData, callSuccess, bAsync, contentType) {
	if(bAsync === undefined) bAsync = true;
	var ajaxNum = getURLRandomNum();
	httpUrl += '?time=' + ajaxNum;
	if(contentType === undefined) contentType = "application/x-www-form-urlencoded";
	process.on();
	console.time('ajax ' + ajaxNum + ' 的请求时间：');
	console.group('ajax请求：' + httpType + "   " + httpUrl);
	console.log("请求参数:", httpData);
	httpData = sendFilter(httpData);
	$.ajax({
		type: httpType,
		url: httpUrl,
		timeout: 30000,
		//cache:false,
		contentType: contentType,
		async: bAsync, //默认异步
		data: httpData, //数据
		crossDomain: true, //同域请求
		success: function(data, textStatus, jqXHR) {
			data = respFilter(data);
			console.log("请求返回success信息data：", data);
			if(callSuccess) callSuccess(data);
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			console.log("请求textStatus：", textStatus);
			console.log("请求errorThrown：", errorThrown);
			console.log("请求返回erroe信息：", XMLHttpRequest);
			catchError(XMLHttpRequest);
		},
		complete: function(XMLHTTPRequest, textStatus) {
			console.timeEnd('ajax ' + ajaxNum + ' 的请求时间：');
			process.off();
			console.groupEnd();
		}
	});
}

function sendFilter(data) { //请求过滤

	return data;
}

function respFilter(data) { //返回过滤

	return data;
}

function catchError(event) {
	if(event.status == 'undefined') {
		return;
	}
	switch(event.status) {
		case 0:
			var statusText = event.statusText;
			if(statusText == 'error') {
				showMsg("网络异常");
			} else if(statusText == 'timeout') {
				showMsg("请求超时");
			} else if(statusText == 'notmodified') {
				showMsg("notmodified");
			} else if(statusText == 'parsererror') {
				showMsg("ajax请求参数不能为空");
			} else {
				showMsg(statusText);
			}
			break;
		case 401:
			// 未授权异常
			console.log("系统拒绝：您没有访问权限。");
			showMsg("系统拒绝：您没有访问权限。");
			break;
		case 404:
			console.log("您访问的资源不存在");
			showMsg("您访问的资源不存在。");
			//alert("您访问的资源不存在。");
			break;
		case 403: //没有登录
			console.log("没有登录");
			redirectIndex('登录已过期，请重新登录');
			break;
	}
}

function redirectIndex(msg) { //跳转主页方法
	top.layer.confirm(msg, {
		btn: ['确定'], //按钮
		shade: [0.1] //遮罩
	}, function() {
		top.window.location = '../../index.html';
	}, function() {
		top.window.location = '../../index.html';
	});
}

function getURLRandomNum() { //获取随机数，url请求缓存问题
	var timeTamp = new Date().getTime();
	var s = Math.random() + '';
	s = s.substring(2, s.length);
	return timeTamp + s;
}

function stopBubble() { //阻止冒泡
	window.event.cancelBubble = true;
}

function loadDictionaryForAll(jq) { //传入jq选择器，加载数据字典	
	$(jq).each(function(index, element) {
		var this_ = this;
		var n = 0;
		var name = this.attributes.getNamedItem('comboname').value;
		doc = $(this); //下拉框属性
		docText = doc.next().find('.combo-text'); //下拉框显示文本document
		var dictionary = doc.attr('data-dictionary');
		if(dictionary.length < 1) return true;
		var data = getSingleSelectDictionary(dictionary);
		var filter = doc.attr('data-value');
		docText.css('cursor', 'pointer'); //
		docText.off("click");
		docText.click(function() {
			$(this).parent().find(".combo-arrow").trigger("click");
		});
		var value = '';
		var className = this.className;
		if(filter) value = filter;

		if(filter) data = filterFunc(data, filter);

		if(doc.hasClass('query-condition')) {
			data.unshift({ label: '全部', value: value });
			n = 1;
		}

		if(doc.hasClass('multiple')) {
			$(this).combobox({
				valueField: 'value',
				textField: 'label',
				editable: false,
				panelHeight: 'auto',
				multiple: true,
				value: '请选择',
				data: data
			});
			$("input[name=" + name + "]").remove();
		} else if(doc.hasClass('easyui-combobox')) {
			$(this).combobox({
				valueField: 'value',
				textField: 'label',
				editable: false,
				panelHeight: 'auto',
				value: '请选择',
				data: data
			});
			$("input[name=" + name + "]").val('');
		}
		if(n === 1) {
			$(this).combobox('select', value);
			n = 0;
		}
		data = [];
	});
}

function loadDictionary() { //加载表单数据字典
	loadDictionaryForAll('.dictionary');
}

function filterFunc(data, filter) { //数据字典过滤
	if(filter.length < 1) return data;
	var s0 = '',
		o, arr = [],
		ach = filter.split(","); //01,02
	for(var j = 0; j < ach.length; j++) {
		s0 = ach[j];
		for(var i = 0; i < data.length; i++) {
			o = data[i];
			if(o.value === s0) {
				arr.push(o);
			}
		}
	}
	return arr;
}

function doPrint(str) {
	var openWin = window.open('', '123', 'left=300,top=100,height=500,width=600');
	openWin.document.write(str);
	//  openWin.printsetup();
	//  openWin.printpreview();
	openWin.print();
	openWin.close();
}

function getUrlParam(name) { //获取url拼接参数
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r !== null) return unescape(r[2]);
	return '';
}

function loadDataPicker() { //加载日期控件
	$('.WdatePicker').on('click', function() {
		WdatePicker({ maxDate: '%y-%M-%d' });
	});
}

function bodyOnclick() { //页面点击事件
	//alert(1)
	//comboboxSelected() //同步下拉框和value
}

//消息提示框
function showMsg(msg) {
	if(msg === undefined || msg === null || msg === '') {
		return;
	}
	if($.messager) {

		$.messager.show({
			title: '我的消息',
			msg: msg,
			timeout: 3000,
			showType: 'slide'
		});

	} else {
		redirectIndex(msg);
	}
}

//根据图片ID加载图片，传入参数：1.逗号拼接的图片id字符串；2.要放入的jqselector
function loadImg(imgId, Jq) {
	if(!imgId) {
		return;
	}
	var imgArray = imgId.split(",");
	$.each(imgArray, function(index, value) {
		var obj = {
			id: value
		};
		var url = portalServiceUrl + "/api/v1/evaluateTask/mongoDBMessage";
		$.ajax({
			type: "post",
			url: url,
			data: obj,
			async: true,
			timeout: 60000,
			success: function(data) {
				console.log("请求返回success信息data：", data);
				if(data.status == 200) {
					var sData = data.datas;
					var sUrl = 'data:image/gif;base64,' + sData;
					Jq.append('<img src= "' + sUrl + '">');
				} else if(data.status == 404) {
					Jq.append('<div> <span>找不到ID为' + value + '的图片</span> </div>');
				}
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				console.log("请求返回erroe信息：", XMLHttpRequest);
			}
		});
	});
}

function doLoadImage(imgId, divId, percent) { //穿入id，可以逗号分隔 123,1233,123123  img1
	var arr, id;
	if(!imgId) return;
	if(imgId.indexOf(',') > -1) {
		arr = imgId.split(',');
		for(var i = 0; i < arr.length; i++) {
			id = arr[i];
			doLoadSingleImage(id, divId, percent);
		}
	} else {
		doLoadSingleImage(imgId, divId, percent);
	}
}

function doLoadSingleImage(imgId, divId, percent) {
	var obj = {
		id: imgId
	};
	if(!percent) percent = '100';
	var url = portalServiceUrl + "/api/v1/evaluateTask/mongoDBMessage";
	sendAjax(url, "post", obj, function(data) {
		//gridLoadData('userList',data);
		//      data:image/gif;base64," + sData + "\"
		if(data.status == 404) {
			$('#' + divId).append('<br><span>找不到ID为' + imgId + '的图片</span><br>');
		} else if(data.status == 200) {
			sData = data.datas;
			var sUrl = 'data:image/gif;base64,' + sData;
			//$('#' + divId).append('<img width="' + percent + '" height="' + percent + '" src= "' + sUrl + '">');
			$('#' + divId).append('<img  src= "' + sUrl + '">');
		}
	});
	//  /evaluateTask/mongoDBMessage
}

function doLoadPrintImage(imgId, divId, percent) { //穿入id，可以逗号分隔 123,1233,123123  img1
	var arr, id;
	if(!imgId) return;
	if(imgId.indexOf(',') > -1) {
		arr = imgId.split(',');
		for(var i = 0; i < arr.length; i++) {
			id = arr[i];
			doLoadPrintSingleImage(id, divId, percent);
		}
	} else {
		doLoadPrintSingleImage(imgId, divId, percent);
	}
}

function doLoadPrintSingleImage(imgId, divId, percent) {
	var obj = {
		id: imgId
	};
	if(!percent) percent = '100';
	var url = portalServiceUrl + "/api/v1/evaluateTask/mongoDBMessage";
	sendAjax(url, "post", obj, function(data) {
		//gridLoadData('userList',data);
		//      data:image/gif;base64," + sData + "\"
		if(data.status == 404) {
			$('#' + divId).append('<br><span>找不到ID为' + imgId + '的图片</span><br>');
		} else if(data.status == 200) {
			sData = data.datas;
			var sUrl = 'data:image/gif;base64,' + sData;
			//$('#' + divId).append('<img width="' + percent + '" height="' + percent + '" src= "' + sUrl + '">');
			$('#' + divId).append('<img  src= "' + sUrl + '">');
		}
	}, false);
	//  /evaluateTask/mongoDBMessage
}

function doLocalDictionary() { //查询本地数据字典缓存状态是否最新
	var time, url = systemServiceUrl + "/api/v1/dictionary/maxOperateTime"; //获取最后更新字典的时间
	sendAjax(url, "get", '', function(data) {
		//getLocalDictionaryData();
		if(isStorage && localStorage) {
			time = localStorage.getItem('dictionary/OperateTime');
			if(time && (data == time)) {
				return;
			} else {
				clearLocalStorageDir('dictionary');
				//localStorage.clear();
				localStorage.setItem("dictionary/OperateTime", data); //第一次获取时间
			}
		}
	}, false);
}

function clearLocalStorageDir(dir) { //dictionary
	var i, n = localStorage.length - 1,
		sKey;
	for(i = n; i >= 0; i--) {
		sKey = localStorage.key(i); //获取localstorage的key
		str = sKey.substring(0, sKey.indexOf('/'));
		if(dir == str) {
			localStorage.removeItem(sKey);
		}
	}
}
//表格数据字典
function getTableDictionary(name, value) { //数据字典缓存
	var sValue;
	value = $.trim(value);
	if(isStorage && localStorage) {
		sValue = localStorage.getItem("dictionary/" + name + "/" + value);
		if(sValue) {
			//console.log('从缓存加载数据字典' + name + ' ' + value, sValue);
			return sValue;
		} else {
			sValue = getDictionaryValue(name, value);
			if(value === undefined || value.length < 1) return sValue;
			//console.log('设置缓存数据字典' + name + ' ' + value, sValue);
			localStorage.setItem("dictionary/" + name + "/" + value, sValue);
			return sValue;
		}
	} else {
		//console.log('从数据库加载数据字典' + name + ' ' + value, sValue);
		return getDictionaryValue(name, value);
	}
}

function strToDictionary(str, dictionaryValue) { //定义方法，传入逗号分隔的字符串值，返回对应数据字典
	if(!str || !dictionaryValue) {
		return '';
	}
	var arr = str.split(','); //[1,2]
	var returnStr = "";
	for(var i = 0; i < arr.length; i++) {
		if(i !== 0) {
			returnStr += ",";
		}
		returnStr += getTableDictionary(dictionaryValue, arr[i]);
	}
	return returnStr;
}

function getDictionaryValue(name, value) { //表格列数据字典
	if(value === undefined || value.length < 1) {
		return value;
	}
	var obj = {
		type: name,
		value: value,
		queryFlag: 'all' //查询全部字典包括失效的
	};
	var sV = "";
	var url = systemServiceUrl + "/api/v1/dictionary";
	sendAjax(url, 'post', obj, function(data) {
		if(data.status == 200) {
			if(data.datas[0]) {
				sV = data.datas[0].valueName;
			} else {
				sV = value;
			}
		} else {
			sV = value;
		}
	}, false);
	return sV;
}

//查询数据字典数据
function getSingleSelectDictionary(name) {
	var arr, sValue;
	if(isStorage && localStorage) {
		sValue = localStorage.getItem("dictionary/" + name);
		if(sValue) {
			arr = JSON.parse(sValue);
			//console.log('从缓存加载数据字典' + name, arr);
			return arr;
		} else {
			arr = getDictionary(name);
			if(arr.length > 0) sValue = JSON.stringify(arr);
			else return [];
			//console.log('设置缓存数据字典' + name, arr);
			localStorage.setItem("dictionary/" + name, sValue);
			return arr;
		}
	} else {
		//console.log('1从数据库加载数据字典' + name);
		return getDictionary(name);
	}
}

function getDictionary(name) { //单独加载需要一个name属性即可
	var o, obj, arr = [];
	obj = {
		type: name,
		queryFlag: 'one' //查询有效的数据字典
	};
	var url = systemServiceUrl + "/api/v1/dictionary";
	sendAjax(url, "post", obj, function(data) {
		if(data.status == 200) {
			$.each(data.datas, function(index, item) {
				o = {};
				o.value = item.value;
				o.label = item.valueName;
				arr.push(o);
			});
			// return arr;
		} else {
			arr = [];
		}
	}, false);
	return arr;
}

function gridLoadData(id, tableData) { //表格加载数据
	if(tableData.status != 200) return true;
	TableObj.grid = $('#' + id);
	if(TableObj.pagination) {
		//加载数据前先执行改变参数的方法
		TableObj.page = tableData.page; //当前页码
		TableObj.pageSize = tableData.pageSize; //页面行数
		TableObj.totalDataNum = tableData.totalDataNum; //总数量
		TableObj.totalPageNum = tableData.totalPageNum; //总页数
		TableObj.grid.datagrid('options').pageNumber = TableObj.page;
		TableObj.grid.datagrid('options').pageSize = TableObj.pageSize;
	}
	TableObj.grid.datagrid('loadData', tableData.datas);
	TableObj.grid.datagrid("clearSelections");
	TableObj.grid.datagrid("clearChecked");
	TableObj.grid.datagrid("fitColumns");
	if(TableObj.pagination) {
		TableObj.grid.datagrid('getPager').pagination({
			total: TableObj.totalDataNum,
			pageSize: TableObj.pageSize,
			pageNumber: TableObj.page
		});
	}
}

function treeGridLoadData(id, tableData) { //表格加载数据
	if(tableData.status != 200) return true;
	var treegrid = $('#' + id);
	treegrid.treegrid('loadData', tableData.datas);
	treegrid.treegrid("clearSelections");
	treegrid.treegrid("clearChecked");
	treegrid.treegrid("fitColumns");
	treegrid.treegrid("collapseAll");
	if(TableObj.pagination) {
		TableObj.page = tableData.page; //当前页码
		TableObj.pageSize = tableData.pageSize; //页面行数
		TableObj.totalDataNum = tableData.totalDataNum; //总数量
		TableObj.totalPageNum = tableData.totalPageNum; //总页数
		treegrid.treegrid('options').pageNumber = TableObj.page;
		treegrid.treegrid('options').pageSize = TableObj.pageSize;
		treegrid.treegrid('getPager').pagination({
			total: TableObj.totalDataNum,
			pageSize: TableObj.pageSize,
			pageNumber: TableObj.page
		});
	}
}

function getGridPager(id, loadFunc) {
	TableObj.grid = $('#' + id);
	//dateGrid.datagrid("fitColumns",true);
	TableObj.grid.datagrid('getPager').pagination({
		total: TableObj.totalDataNum,
		pageSize: TableObj.pageSize,
		pageNumber: TableObj.page,
		beforePageText: '页码',
		afterPageText: '/共{pages}页 ',
		displayMsg: '本页{from}-{to}条，总数 {total}条 ',
		showPageList: true,
		showRefresh: true,
		pagination: true,
		onChangePageSize: function(pageSize) { //选择每页行数触发
			TableObj.pageSize = pageSize;
			TableObj.grid.datagrid('options').pageSize = pageSize;
			TableObj.grid.datagrid("clearSelections");
			TableObj.grid.datagrid("clearChecked");
			if(loadFunc) loadFunc();
		},
		onSelectPage: function(pageNumber, pageSize) {
			TableObj.page = pageNumber;
			TableObj.pageSize = pageSize;
			TableObj.grid.datagrid('options').pageNumber = pageNumber;
			TableObj.grid.datagrid('options').pageSize = pageSize;
			TableObj.grid.datagrid("clearSelections");
			TableObj.grid.datagrid("clearChecked");
			if(loadFunc) loadFunc();
		},
		onBeforeRefresh: function(pageNumber, pageSize) {
			TableObj.grid.datagrid('options').pageNumber = pageNumber;
			TableObj.grid.datagrid('options').pageSize = pageSize;
		},
		onRefresh: function(pageNumber, pageSize) {
			TableObj.page = pageNumber;
			TableObj.pageSize = pageSize;
			TableObj.grid.datagrid('options').pageNumber = pageNumber;
			TableObj.grid.datagrid('options').pageSize = pageSize;
			TableObj.grid.datagrid("clearSelections");
			TableObj.grid.datagrid("clearChecked");
			TableObj.grid.datagrid("fitColumns");
			$.messager.show({
				title: '提示',
				msg: "表格数据刷新成功！",
				timeout: 2500
			});
			// if(loadFunc) loadFunc();
		}
	});
}

function getTreeGridPager(id, loadFunc) {
	var treegrid = $('#' + id);
	treegrid.treegrid('getPager').pagination({
		total: TableObj.totalDataNum,
		pageSize: TableObj.pageSize,
		pageNumber: TableObj.page,
		beforePageText: '页码',
		afterPageText: '/共{pages}页 ',
		displayMsg: '本页{from}-{to}条，总数 {total}条 ',
		showPageList: true,
		showRefresh: true,
		pagination: true,
		onChangePageSize: function(pageSize) { //选择每页行数触发
			TableObj.pageSize = pageSize;
			treegrid.treegrid('options').pageSize = pageSize;
			treegrid.treegrid("clearSelections");
			treegrid.treegrid("clearChecked");
			if(loadFunc) loadFunc();
		},
		onSelectPage: function(pageNumber, pageSize) {
			TableObj.page = pageNumber;
			TableObj.pageSize = pageSize;
			treegrid.treegrid('options').pageNumber = pageNumber;
			treegrid.treegrid('options').pageSize = pageSize;
			treegrid.treegrid("clearSelections");
			treegrid.treegrid("clearChecked");
			if(loadFunc) loadFunc();
		},
		onBeforeRefresh: function(pageNumber, pageSize) {
			treegrid.treegrid('options').pageNumber = pageNumber;
			treegrid.treegrid('options').pageSize = pageSize;
			//treegrid.treegrid("fitColumns");
		},
		onRefresh: function(pageNumber, pageSize) {
			TableObj.page = pageNumber;
			TableObj.pageSize = pageSize;
			treegrid.treegrid('options').pageNumber = pageNumber;
			treegrid.treegrid('options').pageSize = pageSize;
			treegrid.treegrid("clearSelections");
			treegrid.treegrid("clearChecked");
			treegrid.treegrid("fitColumns");
			$.messager.show({
				title: '提示',
				msg: "表格数据刷新成功！",
				timeout: 2500
			});
			if(loadFunc) loadFunc();
		}
	});
}

function getImgUrl(node) { //获取图片前端地址
	var imgURL = "";
	try {
		var file = null;
		if(node.files && node.files[0]) {
			file = node.files[0];
		} else if(node.files && node.files.item(0)) {
			file = node.files.item(0);
		}
		//Firefox 因安全性问题已无法直接通过input[file].value 获取完整的文件路径
		try {
			imgURL = file.getAsDataURL();
		} catch(e) {
			imgRUL = window.URL.createObjectURL(file);
		}
	} catch(e) {
		if(node.files && node.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				imgURL = e.target.result;
			};
			reader.readAsDataURL(node.files[0]);
		}
	}
	return imgRUL;
}

function comboboxSelected() { //通过数据加载下拉框选择项(查询时候选中数据项)
	$('.dictionary').each(function(index, element) {
		if(this.attributes.getNamedItem('comboname').value) {
			var name = this.attributes.getNamedItem('comboname').value; //获取name
			var value = $("input[name='" + name + "']").val(); //获取value
			if(value !== undefined) $(this).combobox('select', value);
		}
	});
}

//初始化省市区下拉框(清除数据)
function clearAreaInfo() {
	//console.log(arguments);
	$.each(arguments, function(index, value) {
		$(value).combobox({
			valueField: 'id',
			textField: 'areaName',
			data: [{
				id: "",
				areaName: "请选择",
				selected: true
			}]
		});
	});
}
//根据父级省市区ID获取本级省市区信息
function getNextarea(parentid) {
	var areaGetUrl = portalServiceUrl + "/api/v1/area/getByParentid";
	var returndata = [];
	$.ajax({
		type: "get",
		url: areaGetUrl,
		data: {
			parentid: parentid,
			page: 1,
			pageSize: 100
		},
		async: false,
		success: function(data) {
			//console.log(data.datas);
			returndata = data.datas;
			if(returndata.length < 1) {
				$.messager.alert("提示", "所选区域无下级区域，请重新选择！");
			}
		}
	});

	returndata.unshift({
		id: "",
		areaName: "请选择",
		selected: true
	});

	//console.log(returndata)
	return returndata;
}

//初始化省市区数据
function getAreaData(provinceJQ, cityJQ, areaJQ) {
	$(provinceJQ).combobox({
		valueField: 'id',
		textField: 'areaName',
		data: getNextarea(0),
		onSelect: function(selectedValue) {
			clearAreaInfo($(cityJQ));
			clearAreaInfo($(areaJQ));
			//console.log(selectedValue);
			$(cityJQ).combobox({
				valueField: 'id',
				textField: 'areaName',
				data: getNextarea(selectedValue.id),
				onSelect: function(selectedValue) {
					clearAreaInfo($(areaJQ));
					//console.log(selectedValue);
					$(areaJQ).combobox({
						valueField: 'id',
						textField: 'areaName',
						data: getNextarea(selectedValue.id)
						//                      onSelect: function(selectedValue) {
						//                          //console.log(selectedValue);
						//                      }
					});
				}
			});
		}
	});
	loadPanelStyle(provinceJQ); //加载样式，增加pointer
	loadPanelStyle(cityJQ); //加载样式，增加pointer
	loadPanelStyle(areaJQ); //加载样式，增加pointer
}

function loadPanelStyle(selecter) {
	var docText;
	docText = $(selecter).next().find('.combo-text');
	docText.css('cursor', 'pointer'); //
	docText.toggle(function() {
		$(selecter).combobox('showPanel');
	}, function() {
		$(selecter).combobox('hidePanel');
	});
}

function getMonthDays(year, month) { //获取指定年份和月份的月天数
	return new Date(year, month, 0).getDate();
}
//时间格式化
function formatDate(value, format) {
	if(!format) {
		// format = "yyyy-MM-dd hh:mm:ss";
		format = "yyyy-MM-dd";
	}
	if(value === '' || value === null || value === undefined) {
		return '';
	}
	var strdata = value.replace(/-/g, "/"); //.replace(/-/g, "/");
	var index = strdata.indexOf(".");
	if(index > 0) {
		strdata = strdata.substr(0, index);
	}
	var date = new Date(Date.parse(strdata));
	var o = {
		"M+": date.getMonth() + 1, // month
		"d+": date.getDate(), // day
		"h+": date.getHours(), // hour
		"m+": date.getMinutes(), // minute
		"s+": date.getSeconds(), // second
		"q+": Math.floor((date.getMonth() + 3) / 3), // quarter
		"S": date.getMilliseconds()
		// millisecond
	};

	if(/(y+)/.test(format)) {
		format = format.replace(RegExp.$1, strdata.substr(4 - RegExp.$1.length, RegExp.$1.length));
	}

	for(var k in o) {
		if(new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format;
}

//根据分隔符分割数组，拼接为字符串
function arrayToStringBySymbol(arr, symbol) {
	if(!symbol) {
		symbol = ",";
	}
	var str = "";
	$.each(arr, function(index, value) {
		str += value;
		if(index < arr.length - 1) {
			str += symbol;
		}
	});
	return str;
}

function initGridSet(obj) {
	var o = $.extend(true, {}, TableObj);
	o = $.extend(o, obj);
	DataGridList.push(o);
	o = null;
}

function initDataGrid(id, loadFunc) {
	TableObj.grid = $('#' + TableObj.id);
	TableObj.grid.datagrid({
		idField: TableObj.idField,
		title: TableObj.title,
		data: TableObj.data,
		pageSize: TableObj.pageSize,
		pagination: TableObj.pagination,
		pageList: TableObj.pageList,
		rownumbers: TableObj.rownumbers,
		loadMsg: '',
		singleSelect: TableObj.singleSelect,
		fit: true,
		resizeHandle: 'right',
		striped: true,
		showFooter: true,
		columns: [TableObj.columns],
		onLoadSuccess: function(data) {
			TableObj.grid.datagrid("clearSelections");
			$(".easyui-linkbutton").linkbutton();
			TableObj.data = data;
			TableObj.onLoadSuccess(data);
		},
		onClickRow: function(rowIndex, rowData) {
			TableObj.rowIndex = rowIndex;
			TableObj.rowData = rowData;
			TableObj.onClickRow(rowIndex, rowData);
		},
		onCheck: function(rowIndex, rowData) {
			TableObj.rowIndex = rowIndex;
			TableObj.rowData = rowData;
			TableObj.onCheck(rowIndex, rowData);
		},
		onBeforeEdit: function(rowIndex, rowData) {
			TableObj.rowIndex = rowIndex;
			TableObj.rowData = rowData;
			TableObj.onBeforeEdit(rowIndex, rowData);
		},
		onAfterEdit: function(rowIndex, rowData) {
			TableObj.rowIndex = rowIndex;
			TableObj.rowData = rowData;
			TableObj.onAfterEdit(rowIndex, rowData);
		},
		onCancelEdit: function(rowIndex, rowData) {
			TableObj.rowIndex = rowIndex;
			TableObj.rowData = rowData;
			TableObj.onCancelEdit(rowIndex, rowData);
		}
	});
	if(TableObj.pagination) {
		TableObj.grid.datagrid('getPager').pagination({
			total: TableObj.totalDataNum,
			pageSize: TableObj.pageSize,
			pageNumber: TableObj.page,
			beforePageText: '页码',
			afterPageText: '/共{pages}页 ',
			displayMsg: '本页{from}-{to}条，总数 {total}条 ',
			showPageList: true,
			showRefresh: true,
			pagination: true,
			onChangePageSize: function(pageSize) { //选择每页行数触发
				process.on();
				TableObj.pageSize = pageSize;
				TableObj.grid.datagrid('options').pageSize = pageSize;
				TableObj.grid.datagrid("clearSelections");
				TableObj.grid.datagrid("clearChecked");
				// if(loadFunc) loadFunc();
				loadGridData();
			},
			onSelectPage: function(pageNumber, pageSize) {
				process.on();
				TableObj.page = pageNumber;
				TableObj.pageSize = pageSize;
				TableObj.grid.datagrid('options').pageNumber = pageNumber;
				TableObj.grid.datagrid('options').pageSize = pageSize;
				TableObj.grid.datagrid("clearSelections");
				TableObj.grid.datagrid("clearChecked");
				// if(loadFunc) loadGridData();
				loadGridData();
			},
			onBeforeRefresh: function(pageNumber, pageSize) {
				TableObj.grid.datagrid('options').pageNumber = pageNumber;
				TableObj.grid.datagrid('options').pageSize = pageSize;
				//TableObj.grid.datagrid("fitColumns");
			},
			onRefresh: function(pageNumber, pageSize) {
				TableObj.page = pageNumber;
				TableObj.pageSize = pageSize;
				TableObj.grid.datagrid('options').pageNumber = pageNumber;
				TableObj.grid.datagrid('options').pageSize = pageSize;
				TableObj.grid.datagrid("clearSelections");
				TableObj.grid.datagrid("clearChecked");
				TableObj.grid.datagrid("fitColumns");
				$.messager.show({
					title: '提示',
					msg: "表格数据刷新成功！",
					timeout: 2500
				});
				// if(loadFunc) loadFunc();
			}
		});
	}
}

function getGridObjById(id) {
	for(var i = 0; i < DataGridList.length; i++) {
		if(DataGridList[i].id == id) {
			return DataGridList[i];
		}
	}
}

function loadGridData() {
	var obj = {
		page: TableObj.page,
		pageSize: TableObj.pageSize
	};
	TableObj.query = $.extend(TableObj.query, obj); //更新分页
	sendAjax(TableObj.url, TableObj.type, TableObj.query, function(data) {
		gridLoadData(TableObj.id, data);
		process.off();
	});
}

function processOn() {
	try {
		$('#process').spin({
			lines: 13, // 花瓣数目
			length: 15, // 花瓣长度
			width: 6, // 花瓣宽度
			radius: 20, // 花瓣距中心半径
			corners: 1, // 花瓣圆滑度 (0-1)
			rotate: 0, // 花瓣旋转角度
			direction: 1, // 花瓣旋转方向 1: 顺时针, -1: 逆时针
			color: 'black', // 花瓣颜色
			speed: 1, // 花瓣旋转速度
			trail: 60, // 花瓣旋转时的拖影(百分比)
			shadow: false, // 花瓣是否显示阴影
			hwaccel: false, //spinner 是否启用硬件加速及高速旋转            
			className: 'spinnerShow', // spinner css 样式名称
			zIndex: 2e9 // spinner的z轴 (默认是2000000000)
			// top: 'auto', // spinner 相对父容器Top定位 单位 px
			// left: 'auto'// spinner 相对父容器Left定位 单位 px
		});
	} catch(e) {}
	$('#mask').show();
}

function processOff() {
	try {
		$('#process').spin(false);
	} catch(e) {

	}
	$('#mask').hide();
}

function evalFunction(str){//动态调用方法
	var Fn = Function;
	return new Fn('return '+str)();
}
//加法函数  
function accAdd(arg1, arg2) {
	var r1, r2, m;
	try {
		r1 = arg1.toString().split(".")[1].length;
	} catch(e) {
		r1 = 0;
	}
	try {
		r2 = arg2.toString().split(".")[1].length;
	} catch(e) {
		r2 = 0;
	}
	m = Math.pow(10, Math.max(r1, r2));
	return(arg1 * m + arg2 * m) / m;
}

//减法函数  
function Subtr(arg1, arg2) {
	var r1, r2, m, n;
	try {
		r1 = arg1.toString().split(".")[1].length;
	} catch(e) {
		r1 = 0;
	}
	try {
		r2 = arg2.toString().split(".")[1].length;
	} catch(e) {
		r2 = 0;
	}
	m = Math.pow(10, Math.max(r1, r2));
	//last modify by deeka  
	//动态控制精度长度  
	n = (r1 >= r2) ? r1 : r2;
	return((arg1 * m - arg2 * m) / m).toFixed(n);
}

//乘法函数  
function accMul(arg1, arg2) {
	var m = 0,
		s1 = arg1.toString(),
		s2 = arg2.toString();
	try {
		m += s1.split(".")[1].length;
	} catch(e) {}
	try {
		m += s2.split(".")[1].length;
	} catch(e) {}
	return Number(s1.replace(".", "")) * Number(s2.replace(".", "")) / Math.pow(10, m);
}

//除法函数  
function accDiv(arg1, arg2) {
	var t1 = 0,
		t2 = 0,
		r1, r2;
	try {
		t1 = arg1.toString().split(".")[1].length;
	} catch(e) {}
	try {
		t2 = arg2.toString().split(".")[1].length;
	} catch(e) {}
	with(Math) {
		r1 = Number(arg1.toString().replace(".", ""));
		r2 = Number(arg2.toString().replace(".", ""));
		return(r1 / r2) * pow(10, t2 - t1);
	}
}

//加载页面后检查权限
function checkMenu() {
	var localUrl = location.href;
	var reg = /\w+\.html/g;
	var html = localUrl.match(reg); //获取xxx.html 名称
	var safeHtml = [
		"index.html",
		"main.html",
		"indexList.html",
		"passModify.html",
		"userInfo.html"
	];
	var isSafe = false;
	$.each(safeHtml, function(index, value) {
		if(html == value) {
			isSafe = true;
		}
	});
	if(isSafe) {
		return;
	}
	//  if ( html == "index.html" || html == "main.html" || html == "indexList.html" || html == "passModify.html" || html == "userInfo.html") {
	//      return;
	//  }
	var menus = "";
	if(isStorage && localStorage) {
		menus = localStorage.getItem("pageMenu"); //本地缓存菜单        
	} else {
		var menuUrl = portalServiceUrl + "/api/v1/menu/list/portal";
		sendAjax(menuUrl, "get", '', function(successdata) {
			if(successdata.status == 200) {
				var s0 = '';
				var data = successdata.datas;
				for(var k = 0; k < data.length; k++) {
					if(k !== 0) s0 += ',';
					s0 += data[k].url;
				}		
				menus = s0;
			}
		},false);
	}
	if(  (menus.indexOf(html) > -1) ) {

	} else {
		$.messager.alert('警告', '您账户的权限不足以访问此页面的内容');
	}
	//  if (localStorage.getItem("pageMenu")) {
	//     
	//      if (menus.indexOf(html) == -1) {
	//          console.log('权限不够');
	//          $.messager.alert('警告', '您账户的权限不足以访问此页面的内容');
	//          //window.location='../../index.html';
	//      } else {}
	//  } else {
	//      $.messager.alert('警告', '您账户的权限不足以访问此页面的内容');
	//      //window.location='../../index.html';
	//  }
}

//  if( localStorage.getItem("menus") ){
//      var menus = localStorage.getItem("menus");  //本地缓存菜单
//      var localUrl = location.href;
//      var reg = /\w+\.html/g ;
//      var html = localUrl.match(reg);  //获取.html文件
//      if( html == "main.html" || html == "indexList.html" || html == "index.html" ){
//          return;
//      }
//      if(menus.indexOf(html) == -1){
//          console.log('权限不够');                
//          $.messager.alert('警告', '您账户的权限不足以访问此页面的内容');
//          //window.location='../../index.html';
//      }else{
//          
//      }
//  }else{
//      var localUrl = location.href;
//      var reg = /\w+\.html/g ;
//      var html = localUrl.match(reg);  //获取.html文件
//      if( html == "index.html" ){
//          return;
//      }
//      $.messager.alert('警告', '您账户的权限不足以访问此页面的内容');
//      //window.location='../../index.html';
//  }

//检查input与textarea输入合法性
function checkInputSafe() {
	$("input[type=text],textarea").on("input", function() {
		//alert( $(this).val() )
		var val = $(this).val();
		//console.log(val);
		var reg = /(<|>|'|")+/g;
		if(val.match(reg)) {
			var trueVal = val.replace(reg, '');
			$(this).val(trueVal);
			$.messager.alert('警告', '请不要输入非法字符');
		}
	});
}

//获取浏览器版本
function getBrowserVersion() {
	var brow = $.browser;
	var bInfo = "";
	if($.browser.msie) {
		console.log("IE浏览器" + $.browser.version);
		//      if($.browser.version<8){  
		//          console.log("IE7及其以下" + $.browser.version);  
		//      }  
		//      else{  
		//          console.log("IE8及其以上" + $.browser.version);  
		//      }  
	} else if($.browser.webkit) {
		console.log("苹果的Safari、谷歌的Chrome浏览器" + $.browser.version);
	} else if($.browser.mozilla) {
		console.log("野狐禅FireFox浏览器" + $.browser.version);
	} else if($.browser.opera) {
		console.log("Opera浏览器" + $.browser.version);
	}
}