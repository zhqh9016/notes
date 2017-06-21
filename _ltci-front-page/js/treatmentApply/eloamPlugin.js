var eloamObj = null;
var VideoMain; //视频句柄
var DeviceMain; //驱动句柄
var eloam = {

    init: function(id) {
        var s = '<object id="eloamObj" type="application/x-eloamplugin" width="600" height="300" name="view"></object>';
        $("#" + id).html(s);
        eloamObj = document.getElementById("eloamObj");
        if (eloamObj.Global_InitDevs()) {
            console.log("eloam:", "初始化成功");
        } else {
            console.log("eloam:", "初始化失败");
            eloam.destroy();
        }
    },
    openVideo: function() {
        eloam.closeVideo();
        // if (!DeviceMain)return;
        DeviceMain = eloamObj.Global_CreateDevice(1, 0);

        VideoMain = eloamObj.Device_CreateVideo(DeviceMain, 0, 0); //返回视频句柄
        if (VideoMain) {
            eloamObj.View_SelectVideo(VideoMain);
            eloamObj.View_SetText("打开视频中，请等待...", 0);
        }
    },
    closeVideo: function() {
        if (VideoMain) {
            eloamObj.Video_Release(VideoMain);
            VideoMain = null;
            eloamObj.View_SetText("", 0);
        }
    },

    createImage: function() {
        var img = eloamObj.Video_CreateImage(VideoMain, 0x08, eloamObj.View_GetObject()); //拍照，返回图像句柄
        console.log("eloam:img ", img);
        var url = portalServiceUrl + "/api/v1/treatmentApplicationAttachement";
        var http = eloamObj.Global_CreateHttp(url);
        var uploadImg = eloamObj.Http_UploadImage(http, img, -1, 0, "123.jpg");
        if (uploadImg) {
            var s = eloamObj.Http_GetServerInfo(http);
            console.log("http", s);
            alert("ok");
        } else {
            alert("failed");
        }
        //    var base64=eloamObj.Image_GetBase64(img,-1,0x0800);
        //  	alert(base64);
        // 		var url = portalServiceUrl + "/api/v1/treatmentApplicationImgBase64";
        // var obj={
        // 	imgBase64:base64
        // };
        // sendAjax(url, "post", obj, function(data){
        // 	console.log('高拍仪上传成功返回',data);
        // 	alert("成功");
        // 	obj=null;
        // }, func tion(err or) {
        // 	console.log(er ror);
        // 	$.messager.alert('警告', "查询失败");
        // 	obj=null;
        // });



        // if(eloamObj.Image_Save(img,"e:\\idcard.jpg",0)){
        // 	alert('保存成功');
        // }else{
        // 	alert('保存失败');
        // }
    },
    destroy: function() {
        eloamObj = document.getElementById("eloamObj");
        if (eloamObj.Global_DeinitDevs()) {
            console.log("eloam:", "销毁成功");
        } else {
            console.log("eloam:", "销毁成功");
        }
    }
};

function openEloamWindow() {
    $('#eloamWindow').window('open');
    eloam.openVideo();
}

function eloamSave() {
    eloam.createImage();
}

function eloamCancel() {
    $('#eloamWindow').window('close');
}
//eloam.destroy();
function loadEloamPlugin(id) {
    var s = '<div id="eloamDiv"></div>';
    s += '<span><a type="button" id="eloamSave" class="easyui-linkbutton" onclick="eloamSave(2)">保存</a></span>';
    s += '<span><a type="button" id="eloamCancel" class="easyui-linkbutton" onclick="eloamCancel()">取消</a></span>';
    $("#" + id).html(s);
    eloam.init("eloamDiv");
}
loadEloamPlugin("eloamWindow");
$('#eloamWindow').window({
    title: '查看详情',
    width: 800,
    minimizable: false,
    collapsible: false,
    height: 500,
    closed: true,
    modal: true
});
// <a type="button" id="go_next_3" class="easyui-linkbutton" onclick="openEloamWindow()">11111</a></span>
