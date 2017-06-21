function fileUpLoad(node, name) { //上传图片到 服务器，并返回图片id，并放到form隐藏域内			
    var sUrl = portalServiceUrl + "/api/v1/treatmentApplicationAttachement" + '?time=' + getURLRandomNum();
    console.log('上传URL= ', sUrl);
    $.ajaxFileUpload({
        url: sUrl,
        type: 'post',
        secureuri: false, //一般设置为false
        complete: null,
        async: true,
        //cache:false,	
        fileSize: 1024, //单位KB
        fileFilter: '.jpg,.bmp,.gif,.png',
        fileElementId: node.id, // 上传文件的id、name属性名
        dataType: 'text', //返回值类型，一般设置为json、application/json
        //data: { Id: '123123', name: 'attachment' },
        success: function(data, status) {
            //jsondata = getJSONStr(data);
            var response = JSON.parse(data).datas;
            //JSON.parse(data).datas
            //alert(jsondata.msg);
            console.log(response);
            console.log('上传success文件名为:attachmentid=', response.attachmentid);
            console.log('上传success状态为:status=', status);
            var s = $("input[name='" + name + "']").val();
            if (s.length < 1) s = response.attachmentid;
            else s += "," + response.attachmentid;
            $("input[name='" + name + "']").val(s);
            var sUrl = getImgUrl(node); //  //$('#'+node.id).val()

            $('#' + name + '_images').append('<div data-singleImg = "' + response.attachmentid + '" class="singleImg"><img style="width:200px;height:auto;" src= "' + sUrl + '"><span data-inputName =  "' + name + '" data-imgId = "' + response.attachmentid + '" class="removeImg">删除图片</span></div>');
            var sButton = "<input type=\"file\" id=\"" + node.id + "\"  name=\"attachment\" onchange=\"doUploadFile(this,'" + name + "')\" />" +
                "<a href='javascript:;'>点击选择图片</a>";
            $('#' + name + '_button').html('');
            $('#' + name + '_button').html(sButton);

        },
        error: function(data, status, e) {
            console.log('error:data=', data);
            console.log('error:status=', status);
            console.log('error:msg=', e);
        }
    });

}

function getDetailHtml(data, b, readonly, evaluate) { //b为true则为专家录入，为false为初评
    var s2 = "",
        ach = null,
        m = 0,
        j = 0,
        rows;
    var expert = eval(evaluate);
    if (typeof(expert) == 'object') {

    } else {
        expert = [];
    }
    detailJson = JSON.parse(data.detailJson);
    // var detailJson = data.detailJson; //获取量表json

    if (readonly) s2 = "disabled=disabled";
    var s = "<span>日常生活活动能力评定量表</span>";
    s += "<table border=1>";
    var nState = 0;
    var s0 = "<tr>";
    s0 += "<td rowspan='2' align='center'>项目</td>";
    s0 += "<td rowspan='2' colspan='3' align='center'>评定标准</td>";
    s0 += "<td colspan='3' align='center'>评分</td>";
    s0 += "</tr>";
    s0 += "<tr>";
    s0 += "<td>分值标准</td>";
    s0 += "<td>护理机构评分</td>";
    s0 += "<td>专家组评分</td>";
    s0 += "</tr>";
    s += "<tr><td>申请人姓名</td><td>" + data.insuredPersonName + "</td><td>身份证号码</td><td colspan='4'>" + data.idCard + "</td></tr>";
    s += "<tr><td>社会保障卡号</td><td>" + data.securityNumber + "</td><td>人员身份</td><td colspan='4'>" + data.personnelIdentityName + "</td></tr>";
    var question = detailJson.pages[0].questions;
    for (var i = 0; i < question.length; i++) {
        var obj = getDetailHtmlobj(detailJson, i);
        // if(nState < 5 || nState > 14) {
        // if(nState == 1) {
        // 	s += "<td><span>" + obj.name + "</span></td><td colspan='4'><span>" + obj.value + "</span></td></tr>";
        // } else if(nState === 3) {
        // 	rows = obj.standard.length;
        // 	var s1 = "";
        // 	for(j = 0; j < rows; j++) {
        // 		s1 += "<span>" + obj.standard[j] + "</span>"; //标准
        // 		s1 += "<span>(" + obj.values[j] + ")</span>"; //评分
        // 	}
        // 	s += "<td><span>" + obj.name + "</span></td><td colspan='4'><span>" + s1 + "</span></td></tr>";
        // } else if(nState === 0 || nState === 2) {
        // 	s += "<tr><td><span>" + obj.name + "</span></td><td><span>" + obj.value + "</span></td>";
        // } else if(nState === 4) {
        // 	s += "<tr><td><span>" + obj.name + "</span></td><td colspan='6'><span>" + obj.value + "</span></td></tr>";
        // } else if(nState === 15) {
        // 	s += "<tr><td colspan='4'><span>合计</span></td><td><span>100</span></td><td><span>" + detailJson.totalScore + "</span></td><td><span id='expertScore'></span></td></tr>";
        // 	s += "<tr><td colspan='3'><span>" + obj.name + "</span><br><span>" + obj.value + "</span></td>";
        // } else if(nState === 16) {
        // 	s += "<td colspan='4'><span>" + obj.name + "</span><br><span>" + obj.value + "</span></td></tr>";
        // }
        // nState++;
        // } else if(nState >= 5 && nState <= 14) {
        // if(nState == 5) {
        // 	s += s0;
        // }
        rows = obj.standard.length;
        for (j = 0; j < rows; j++) {
            s += "<tr>";
            if (j === 0) {
                s += "<td rowspan='" + rows + "' ><span class='expert-radio' data-value='" + obj.id + "' >" + obj.name + "</span></td>";
                s += "<td colspan='3'><span>" + obj.standard[j] + "</span></td>"; //标准
                s += "<td><span>" + obj.score[j] + "</span></td>"; //分值
                s += "<td><span>" + obj.values[j] + "</span></td>"; //评分
                if (b) {
                    if (expert && expert.length > 0) {
                        for (m = 0; m < expert.length; m++) {
                            ach = expert[m];
                            if (ach.name === obj.id) break;
                        }
                        if (ach.name === obj.id && ach.score === obj.score[j]) {
                            s += "<td><span><input type='radio' " + s2 + " checked=checked  class='expert-assess' value='" + obj.score[j] + "'  name='" + obj.id + "' /></span></td>"; //专家评分								
                        } else {
                            s += "<td><span><input type='radio' " + s2 + "  class='expert-assess' value='" + obj.score[j] + "'  name='" + obj.id + "' /></span></td>"; //专家评分									
                        }
                    } else {
                        s += "<td><span><input type='radio' " + s2 + "  class='expert-assess' value='" + obj.score[j] + "'  name='" + obj.id + "' /></span></td>"; //专家评分									
                    }
                } else {
                    s += "<td><span></span></td>"; //不显示专家评分						
                }
            } else {
                s += "<td colspan='3'><span>" + obj.standard[j] + "</span></td>"; //标准
                s += "<td><span>" + obj.score[j] + "</span></td>"; //分值
                s += "<td><span>" + obj.values[j] + "</span></td>"; //评分
                if (b) {
                    if (expert && expert.length > 0) {
                        for (m = 0; m < expert.length; m++) {
                            ach = expert[m];
                            if (ach.name === obj.id) break;
                        }
                        if (ach.name === obj.id && ach.score === obj.score[j]) {
                            s += "<td><span><input type='radio' " + s2 + " checked=checked  class='expert-assess' value='" + obj.score[j] + "'  name='" + obj.id + "' /></span></td>"; //专家评分								
                        } else {
                            s += "<td><span><input type='radio' " + s2 + "  class='expert-assess' value='" + obj.score[j] + "'  name='" + obj.id + "' /></span></td>"; //专家评分									
                        }
                    } else {
                        s += "<td><span><input type='radio' " + s2 + "  class='expert-assess' value='" + obj.score[j] + "'  name='" + obj.id + "' /></span></td>"; //专家评分									
                    }
                } else {
                    s += "<td><span></span></td>"; //不显示专家评分						
                }
            }
            s += "</tr>";
        }
        nState++;
        // }
    }
    return s += "</table>";
}
// function getDetailHtml(data, b, readonly, evaluate) { //b为true则为专家录入，为false为初评
// 	var s2 = "",
// 		ach = null,
// 		m = 0,
// 		j = 0,
// 		rows;
// 	var expert = eval(evaluate);
// 	if(typeof(expert) == 'object') {

// 	} else {
// 		expert = [];
// 	}
// 	detailJson = JSON.parse(data.detailJson);
// 	// var detailJson = data.detailJson; //获取量表json

// 	if(readonly) s2 = "disabled=disabled";
// 	var s = "<span>日常生活活动能力评定量表</span>";
// 	s += "<table border=1>";
// 	var nState = 0;
// 	var s0 = "<tr>";
// 	s0 += "<td rowspan='2' align='center'>项目</td>";
// 	s0 += "<td rowspan='2' colspan='3' align='center'>评定标准</td>";
// 	s0 += "<td colspan='3' align='center'>评分</td>";
// 	s0 += "</tr>";
// 	s0 += "<tr>";
// 	s0 += "<td>分值标准</td>";
// 	s0 += "<td>护理机构评分</td>";
// 	s0 += "<td>专家组评分</td>";
// 	s0 += "</tr>";
// 	var question = detailJson.pages[0].questions;
// 	for(var i = 0; i < question.length; i++) {
// 		var obj = getDetailHtmlobj(detailJson, i);
// 		if(nState < 5 || nState > 14) {
// 			if(nState == 1) {
// 				s += "<td><span>" + obj.name + "</span></td><td colspan='4'><span>" + obj.value + "</span></td></tr>";
// 			} else if(nState === 3) {
// 				rows = obj.standard.length;
// 				var s1 = "";
// 				for(j = 0; j < rows; j++) {
// 					s1 += "<span>" + obj.standard[j] + "</span>"; //标准
// 					s1 += "<span>(" + obj.values[j] + ")</span>"; //评分
// 				}
// 				s += "<td><span>" + obj.name + "</span></td><td colspan='4'><span>" + s1 + "</span></td></tr>";
// 			} else if(nState === 0 || nState === 2) {
// 				s += "<tr><td><span>" + obj.name + "</span></td><td><span>" + obj.value + "</span></td>";
// 			} else if(nState === 4) {
// 				s += "<tr><td><span>" + obj.name + "</span></td><td colspan='6'><span>" + obj.value + "</span></td></tr>";
// 			} else if(nState === 15) {
// 				s += "<tr><td colspan='4'><span>合计</span></td><td><span>100</span></td><td><span>" + detailJson.totalScore + "</span></td><td><span id='expertScore'></span></td></tr>";
// 				s += "<tr><td colspan='3'><span>" + obj.name + "</span><br><span>" + obj.value + "</span></td>";
// 			} else if(nState === 16) {
// 				s += "<td colspan='4'><span>" + obj.name + "</span><br><span>" + obj.value + "</span></td></tr>";
// 			}
// 			nState++;
// 		} else if(nState >= 5 && nState <= 14) {
// 			if(nState == 5) {
// 				s += s0;
// 			}
// 			rows = obj.standard.length;
// 			for(j = 0; j < rows; j++) {
// 				s += "<tr>";
// 				if(j === 0) {
// 					s += "<td rowspan='" + rows + "' ><span class='expert-radio' data-value='" + obj.id + "' >" + obj.name + "</span></td>";
// 					s += "<td colspan='3'><span>" + obj.standard[j] + "</span></td>"; //标准
// 					s += "<td><span>" + obj.score[j] + "</span></td>"; //分值
// 					s += "<td><span>" + obj.values[j] + "</span></td>"; //评分
// 					if(b) {
// 						if(expert && expert.length > 0) {
// 							for(m = 0; m < expert.length; m++) {
// 								ach = expert[m];
// 								if(ach.name === obj.id) break;
// 							}
// 							if(ach.name === obj.id && ach.score === obj.score[j]) {
// 								s += "<td><span><input type='radio' " + s2 + " checked=checked  class='expert-assess' value='" + obj.score[j] + "'  name='" + obj.id + "' /></span></td>"; //专家评分								
// 							} else {
// 								s += "<td><span><input type='radio' " + s2 + "  class='expert-assess' value='" + obj.score[j] + "'  name='" + obj.id + "' /></span></td>"; //专家评分									
// 							}
// 						} else {
// 							s += "<td><span><input type='radio' " + s2 + "  class='expert-assess' value='" + obj.score[j] + "'  name='" + obj.id + "' /></span></td>"; //专家评分									
// 						}
// 					} else {
// 						s += "<td><span></span></td>"; //不显示专家评分						
// 					}
// 				} else {
// 					s += "<td colspan='3'><span>" + obj.standard[j] + "</span></td>"; //标准
// 					s += "<td><span>" + obj.score[j] + "</span></td>"; //分值
// 					s += "<td><span>" + obj.values[j] + "</span></td>"; //评分
// 					if(b) {
// 						if(expert && expert.length > 0) {
// 							for(m = 0; m < expert.length; m++) {
// 								ach = expert[m];
// 								if(ach.name === obj.id) break;
// 							}
// 							if(ach.name === obj.id && ach.score === obj.score[j]) {
// 								s += "<td><span><input type='radio' " + s2 + " checked=checked  class='expert-assess' value='" + obj.score[j] + "'  name='" + obj.id + "' /></span></td>"; //专家评分								
// 							} else {
// 								s += "<td><span><input type='radio' " + s2 + "  class='expert-assess' value='" + obj.score[j] + "'  name='" + obj.id + "' /></span></td>"; //专家评分									
// 							}
// 						} else {
// 							s += "<td><span><input type='radio' " + s2 + "  class='expert-assess' value='" + obj.score[j] + "'  name='" + obj.id + "' /></span></td>"; //专家评分									
// 						}
// 					} else {
// 						s += "<td><span></span></td>"; //不显示专家评分						
// 					}
// 				}
// 				s += "</tr>";
// 			}
// 			nState++;
// 		}
// 	}
// 	return s += "</table>";
// }

function doCheckRadio() {
    var n = 0,
        s = '';
    $('.expert-radio').each(function(index, element) {
        var id = $(this).attr('data-questionId');
        var obj = $("input[name=" + id + "]:checked");
        if (obj.length < 1) {
            if (n !== 0) s += ",";
            n++;
            s += $(this).html();
        }
    });
    if (n > 0) { $.messager.alert("以下项目未填写答案，请填写后再提交：", s);
        return false; } else return true;
}

function getDetailHtmlobj(data, index) {
    var question = data.pages[0].questions[index];
    var answer = data.answers[0].answer;
    var name = question.name;
    var id = question.questionId;
    var type = question.type;
    var value = "";
    var o = [];
    for (var i = 0; i < answer.length; i++) {
        o = answer[i];
        for (var k in o) {
            if (k == id) value = answer[i][k];
        }
    }
    if (type == "text") {
        return {
            name: name,
            id: id,
            value: value,
            type: type
        };
    } else if (type == "radiogroup") {
        var standard = [],
            score = [],
            values = [],
            expert = [];
        var detail = question.choices;
        for (var j = 0; j < detail.length; j++) {
            score.push(detail[j].score);
            standard.push(detail[j].text);
            expert.push('<br>');
            if (detail[j].value == value) {
                //values.push("<input type='radio' checked=true disabled=disabled/>")
                values.push('<span>√</span>');
            } else {
                //values.push("<input type='radio' disabled=disabled/>")
                values.push('<span></span>');
            }
        }
        return {
            name: name,
            id: id,
            values: values,
            type: type,
            standard: standard,
            score: score,
            expert: expert
        };
    }

}


// dataJson=null;
var evaluateJson;

function doLoadEvaluateDetail(index, b, readonly) { //查询量表
    var row = $('#userList').datagrid('getRows')[index];
    var code = row.firstEvaluateCode;
    evaluateJson = row.evaluateContent;
    var expertCode = row.expertEvaluateCode; //row.firstEvaluateCode;

    console.log('量表code：', code);
    // code="f435a1292739461babc2fc0d2eb29355";
    // var url = portalServiceUrl + "/api/v1/firstEvaluate/"+code;
    // sendAjax(url, "get", '', function(successdata) {
    // 	if(successdata.status == 200) {
    // 		var data = successdata.datas;
    // 		dataJson=data;
    $('#showTableInfo_iframe').attr('src', 'resultTemplate.html?firstCode=' + code + '&expertCode=' + expertCode + '&operate=false&expert=false');
    $('#showTableInfo').window('open');
    // var data = JSON.parse(row.detailJson); //获取量表json
    // var evaluate = row.evaluateContent;
    // var html = getDetailHtml(data, true, true, evaluate); //获取量表html
    // $('#showInfo').html(html);
    // doSumScore();
    // $('#showInfo').window('open');
    // 	}else{
    // 		$.messager.alert('警告', '未查询到相关信息！');
    // 	}
    // }, fun ction(err or) {
    // 	$.messager.alert('警告', '网络异常，加载失败！');
    // });

    // if(row.detailJson.length < 1) {
    // 	$.messager.alert('警告', '该记录没有量表信息');
    // 	return true;
    // }
}

function doLoadPicture(str) {
    var id, ach = str.split(',');
    $('#showInfo').html("<div class=\"mainTitle\">附件</div><div class=\"mainWapper\"><div id=\"imageInfo\"></div></div>");
    for (var i = 0; i < ach.length; i++) {
        id = ach[i];
        doLoadImage(id, 'imageInfo');
    }
    $('#showInfo').window('open');
}

function aaa() {

    var obj = {
        questions1: 'name',
        questions2: '11',
        questions3: '1212',
        questions4: {
            aa1: 'false',
            aa2: 'false',
            aa3: 'true'
        },
        questions5: '123123123',
        questions6: {
            choose1: true
        }

    };

}

function templateHtml() {

}
