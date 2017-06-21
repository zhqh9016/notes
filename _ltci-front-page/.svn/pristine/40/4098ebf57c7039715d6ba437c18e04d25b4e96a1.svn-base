var transPara = [];
windowTop = true; //默认为iframe 1，top页面为0
// $('#preview1').spin('tiny', 'teal');
// $('#preview2').spin({color: '#fff'});
// $('.preview').click(function() {
// $(this).spin(false);
// });
$(function() {
    window.history.forward(0); //禁用页面后退按钮 
    doLocalDictionary(); //计算本地缓存是否过期
});

function logout() {
    layer.confirm('您确定要注销吗？', {
        btn: ['确定', '取消'] //按钮
        // shade: false //不显示遮罩
    }, function() {
        $.post(portalServiceUrl + "/api/v1/logout", null, function(data) {
            console.log(data);
            var resData = JSON.parse(data);
            if (resData.success) {
                window.location = '../../index.html';
            } else {
                layer.alert(resData.message);
            }
        });
    }, function() {
        return;
    });
}

function passModify() {
    layer.open({
        type: 2,
        title: '密码修改',
        //shadeClose : true,
        maxmin: true,
        area: ['500px', '240px'],
        content: 'passModify.html'
    });
}

function userInfo() {
    layer.open({
        type: 2,
        title: '个人信息',
        //shadeClose : true,
        maxmin: true,
        area: ['400px', '400px'],
        content: 'userInfo.html'
    });
}

//function clearLocal storage() {
//  var storage = $.localS torage;
//  if (!storage)
//      storage = $.cookieSt orage;
//  storage.removeAll();
//  alert("浏览器缓存清除成功!");
//}
/*
    function tabReturn(id){
    	var url = "borrowController.do?returnList&id="+id;
    	console.log(url);
    	$('.J_menuTab').removeClass('active');
    	var str1 = '<iframe class="J_iframe" name="iframe37" width="100%" height="100%" src="'+url+'" frameborder="0" data-id="borrowController.do?returnList" seamless></iframe>';
        $('.J_mainContent').find('iframe.J_iframe').hide().parents('.J_mainContent').append(str1);
    	//<a class="J_menuItem" href="trackController.do?list" data-index="8">轨迹记录</a>
		$("#content").append("<a href=\"javascript:;\" class=\"active J_menuTab\" data-id=\"borrowController.do?returnList\">物品归还管理<i class=\"fa fa-times-circle\"></i></a>");
    	//scrollToTab($('.J_menuTab.active'));
    }
    
    function tabDonate(id){
    	var url = "matterController.do?donatelist&id="+id;
    	console.log(url);
    	$('.J_menuTab').removeClass('active');
    	var str1 = '<iframe class="J_iframe" name="iframe36" width="100%" height="100%" src="'+url+'" frameborder="0" data-id="matterController.do?donatelist" seamless></iframe>';
        $('.J_mainContent').find('iframe.J_iframe').hide().parents('.J_mainContent').append(str1);
    	//<a class="J_menuItem" href="trackController.do?list" data-index="8">轨迹记录</a>
		$("#content").append("<a href=\"javascript:;\" class=\"active J_menuTab\" data-id=\"matterController.do?donatelist\">物品捐赠管理<i class=\"fa fa-times-circle\"></i></a>");
    	scrollToTab($('.J_menuTab.active'));
    }
    
    function tabCustomer(customerId){
    	var url="customerController.do?list&customerId="+customerId;
    	console.log(url);
    	$('.J_menuTab').removeClass('active');
    	var str1 = '<iframe class="J_iframe" name="iframe35" width="100%" height="100%" src="'+url+'" frameborder="0" data-id="'+url+'" seamless></iframe>';
        $('.J_mainContent').find('iframe.J_iframe').hide().parents('.J_mainContent').append(str1);
    	//<a class="J_menuItem" href="trackController.do?list" data-index="8">轨迹记录</a>
		$("#content").append("<a href=\"javascript:;\" class=\"active J_menuTab\" data-id=\"customerController.do?list&customerId=\""+customerId+">会员管理<i class=\"fa fa-times-circle\"></i></a>");
    	scrollToTab($('.J_menuTab.active'));
    }
    var list = "";
    */
