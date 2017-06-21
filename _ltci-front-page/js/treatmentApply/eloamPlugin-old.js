// var VideoMain; //视频句柄
// var DeviceMain; //驱动句柄
// var eloam={
// 	loadEloam:function(id){//弹出窗口
// 		// var s='<div><object id="eloamObj" type="application/x-eloamplugin" width="600" height="300" name="view"></object></div>';
// 		// s+='<div><span><a type="button" id="eloamSave" class="easyui-linkbutton" onclick="eloam.save()">保存</a></span>';
// 		// s+='<span><a type="button" id="eloamCancel" class="easyui-linkbutton" onclick="eloam.cancel(\\"'+id+'\\")">取消</a></span></div>';
// 		// $("#"+id).html(s);
// 		eloam.init("eloamObj");//初始化页面

// 	},
// 	openVideo:function(){//打开视频
// 		eloam.closeVideo();
//         DeviceMain = eloam.object().Global_CreateDevice(1, 0);//获取驱动句柄
//         VideoMain = eloam.object().Device_CreateVideo(DeviceMain, 0, 0);//获取视频句柄
//         if (VideoMain) {
// 		    eloam.object().View_SelectVideo(VideoMain);
// 		    eloam.object().View_SetText("打开视频中，请等待...", 0);	
//         }
// 	},
// 	closeVideo:function(){//关闭视频
// 		if (VideoMain){
// 			eloam.object().Video_Release(VideoMain);
// 			VideoMain = null;
// 			eloam.object().View_SetText("", 0);
// 		}
// 	},
// 	getImageBase64:function(){//拍照，返回base64图片
// 		return eloam.object().Image_GetBase64(eloam.object().Video_CreateImage(VideoMain, 0, eloam.object().View_GetObject()),-1,0);
// 	},
// 	save:function(){//弹出框保存按钮
// 		var url = portalServiceUrl + "/api/v1/treatmentApplicationAttachement";
// 		var obj={
// 			imgBase64:eloam.getImageBase64()
// 		};
// 		sendAjax(url, "post", "", function(data){
// 			console.log('高拍仪上传成功返回',data);
// 			alert("成功");
// 			obj=null;
// 		}, func tion (err or) {
// 			console.log(er ror);
// 			$.messager.alert('警告', "查询失败");
// 			obj=null;
// 		});
// 	},
// 	cancel:function(id){//弹出框取消按钮
// 		$('#eloamWindow').window('close');
// 		eloam.closeVideo();
// 		eloam.destroy();
// 		$("#"+id).html('');
// 	},
// 	init:function(id){
// 		if(eloam.object().Global_InitDevs()){
// 			console.log("eloam:","初始化成功");
// 			eloam.openVideo();
// 		}else{
// 			console.log("eloam:","初始化失败");
// 			alert("加载失败");
// 			eloam.destroy();
// 		}
// 	},
// 	destroy:function(){
// 		if(eloam.object().Global_DeinitDevs()){
// 			console.log("eloam:","销毁成功");
// 		}else{
// 			console.log("eloam:","销毁成功");
// 		}
// 	},
// 	object:function(id){
// 		return document.getElementById("eloamObj");
// 	}
// };
// // if(eloamObj.Image_Save(img,"e:\\idcard.jpg",0)){
// // 	alert('保存成功');
// // }else{
// // 	alert('保存失败');
// // }
