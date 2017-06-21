$(function() {
	$.extend($.fn.validatebox.defaults.rules, {
			idCard: { // 验证身份证
				validator: function(value) {
					return /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/i.test(value);
				},
				message: '身份证号码格式不正确'
			},
			inputNotEmpty: {
				validator: function(value) {
					return value.length > 0;
				},
				message: '输入参数不能为空'
			},
			minLength: {
				validator: function(value, param) {
					return value.length >= param[0];
				},
				message: '请输入至少（2）个字符'
			},
			length: {
				validator: function(value, param) {
					var len = $.trim(value).length;
					return len >= param[0] && len <= param[1];
				},
				message: "输入内容长度必须介于{0}和{1}之间"
			},
			phone: { // 验证电话号码
				validator: function(value) {
					return /^((\d2,3)|(\d{3}\-))?(0\d2,3|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value);
				},
				message: '格式不正确,请使用下面格式:020-88888888'
			},
			mobile: { // 验证手机号码
				validator: function(value) {
					return /^(13|15|18)\d{9}$/i.test(value);
				},
				message: '手机号码格式不正确'
			},
			intOrFloat: { // 验证整数或小数
				validator: function(value) {
					return /^\d+(\.\d+)?$/i.test(value);
				},
				message: '不能输入中文'
			},
			intOrFloatPrice:{
				validator: function(value) {
					return /^[1-9]{1}[0-9]{0,10}(\.[0-9]{2}){0,1}$/i.test(value);
				},
				message: '输入的价格过高！'
			},
			currency: { // 验证货币
				validator: function(value) {
					return /^\d+(\.\d+)?$/i.test(value);
				},
				message: '货币格式不正确'
			},
			qq: { // 验证QQ,从10000开始
				validator: function(value) {
					return /^[1-9]\d{4,9}$/i.test(value);
				},
				message: 'QQ号码格式不正确'
			},
			integer: { // 验证整数 可正负数
				validator: function(value) {
					//return /^[+]?[1-9]+\d*$/i.test(value);

					return /^([+]?[0-9])|([-]?[0-9])+\d*$/i.test(value);
				},
				message: '请输入整数'
			},
			age: { // 验证年龄
				validator: function(value) {
					return /^(?:[1-9][0-9]?|1[01][0-9]|120)$/i.test(value);
				},
				message: '年龄必须是0到120之间的整数'
			},
			chinese: { // 验证中文
				validator: function(value) {
					return /^[\Α-\￥]+$/i.test(value);
				},
				message: '请输入中文'
			},
			english: { // 验证英语
				validator: function(value) {
					return /^[A-Za-z]+$/i.test(value);
				},
				message: '请输入英文'
			},
			unnormal: { // 验证是否包含空格和非法字符
				validator: function(value) {
					var reg = /^[a-zA-Z0-9_\u4e00-\u9fa5]+$/;
					return reg.test(value);
				},
				message: '只能输入中英文、数字及下划线'
			},
			date: { // 
				validator: function(value) {
					//格式yyyy-MM-dd或yyyy-M-d
					return /^(?:(?!0000)[0-9]{4}([-]?)(?:(?:0?[1-9]|1[0-2])\1(?:0?[1-9]|1[0-9]|2[0-8])|(?:0?[13-9]|1[0-2])\1(?:29|30)|(?:0?[13578]|1[02])\1(?:31))|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)([-]?)0?2\2(?:29))$/i.test(value);
				},
				message: '清输入合适的日期格式'
			},
			fax: { // 验证传真
				validator: function(value) {
					//            return /^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/i.test(value);
					return /^((\d2,3)|(\d{3}\-))?(0\d2,3|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value);
				},
				message: '传真号码不正确'
			},
			msn: {
				validator: function(value) {
					return /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(value);
				},
				message: '请输入有效的msn账号(例：abc@hotnail(msn/live).com)'
			},
			email: {
				validator: function(value) {
					return /(^(?:\w+\.?)*\w+@(?:\w+\.)+\w+$)|(^$)/.test(value);
				},
				message: '请输入有效的邮箱账号(例：abc@hotnail(msn/live).com)'
			},
			zip: { // 验证邮政编码
				validator: function(value) {
					return /^[1-9]\d{5}$/i.test(value);
				},
				message: '邮政编码格式不正确'
			},
			ip: { // 验证IP地址
				validator: function(value) {
					return /d+.d+.d+.d+/i.test(value);
				},
				message: 'IP地址格式不正确'
			},
			same: {
				validator: function(value, param) {
					if($("#" + param[0]).val() !== "" && value !== "") {
						return $("#" + param[0]).val() == value;
					} else {
						return true;
					}
				},
				message: '两次输入的密码不一致'
			},
			name: { // 验证姓名，可以是中文或英文
				validator: function(value) {
					return /^[\Α-\￥]+$/i.test(value) | /^\w+[\w\s]+\w+$/i.test(value);
				},
				message: '请输入姓名'
			},
			userName: { // 验证用户名是否合法
				validator: function(value) {
					return /^[a-zA-Z][a-zA-Z0-9_]{5,15}$/i.test(value);
				},
				message: '用户名不合法（字母开头，允许6-16字节，允许字母数字下划线）'
			},
//////////////////////////////////////////////////////////////////////////////////////////////
			// VerifyUserName: {
			// 	validator: function(value, param) {
			// 		return /^[a-zA-Z][a-zA-Z0-9_]{5,15}$/i.test(value);
			// 	},
			// 	message: '用户名不合法（字母开头，允许6-16字节，允许字母数字下划线）'
			// },
			// VerifyRoleName: {
			// 	validator: function(value, param) {
			// 		return /^[a-zA-Z][a-zA-Z0-9_]{5,15}$/i.test(value);
			// 	},
			// 	message: '角色名称不合法（字母开头，允许6-16字节，允许字母数字下划线）'
			// },
			VerifyRoleNameExist: {//xuchuang
				validator: function(value, param) {
					return false;
				},
				message: '角色名称不能重复'
			},
			VerifyUserNameExist: {//xuchuang
				validator: function(value, param) {
					return false;
				},
				message: '用户名不能重复'
			}
		
		});
});