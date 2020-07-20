
function change(img) {
	img.src="getcode?"+new Date().getTime();
}
var flag=true;  //标记位,中间有失败的就返回假，否则为真
function FocusItem(obj) {//直接用jquery
	if($(obj).attr('name') == 'veryCode') {
		$(obj).next().next().html('').removeClass('error');//jquery标签
		
	}else {
		$(obj).next('span').html('').removeClass('error');
	}
}
//AJAX
function CheckItem(obj) {
	var msgBox = $(obj).next('span');
	switch($(obj).attr('name')) {
		case "number":
			if(obj.value == "") {
				msgBox.html('员工工号不能为空');
				msgBox.addClass('error');
				flag=false;
			}else {
				var url="numbercheck?number="+encodeURI($(obj).val())+"&"+new Date().getTime();
				$.get(url, function(data){	
					if(data == "false") {
						msgBox.html('员工工号已存在!');
						msgBox.addClass('error');
						flag=false;
					}else{
						msgBox.html().removeClass('error');
						flag=true;
					} 
				});
			}
			break;
		case "password":
			if(obj.value == "") {
				msgBox.html('用户名密码不能为空');
				msgBox.addClass('error');
				flag=false;
			}else{
				flag=true;
			}
			break;
		case "repassword":
			if(obj.value == "") {
				msgBox.html('用户名确认密码不能为空');
				msgBox.addClass('error');
				flag=false;
			}else if($(obj).val() !=$('input[name="password"]').val()){
				msgBox.html('两次输入的密码不一致!');
				msgBox.addClass('error');
				flag=false;
			}else{
				flag=true;
			}
			break;
		case "desk":
			if(obj.value == "") {
				msgBox.html('负责餐桌号不能为空');
				msgBox.addClass('error');
				flag=false;
			}else{
				flag=true;
			}
			break;
		case "mobile":
			if(obj.value == "") {
				msgBox.html('电话号码不能为空');
				msgBox.addClass('error');
				flag=false;
			}else{
				flag=true;
			}
			break;
		case "veryCode":
	 		var  numshow = $(obj).next().next();
			if(obj.value == "") {
				numshow.html('验证码不能为空');
				numshow.addClass('error');
				flag=false;
			}else {
				var url="checkusernum?num="+encodeURI($(obj).val())+"&"+new Date().getTime();//加上随机数
				$.get(url, function(data){
					if(data=="false") {
						numshow.html('验证码输入错误');
						numshow.addClass('error');
						flag=false;
					}else{
						numshow.html().removeClass('error');
						flag=true;
					}
				});
			}
			break;
	}
}

function checkForm(frm) {//检查表单的每一项
	
	var els = frm.getElementsByTagName('input');//获取表单所有输入
	
	for(var i=0; i<els.length; i++) {
		
		if(els[i] !=null ){
			if(els[i].getAttribute("onblur")) {//带有onblur的属性需要进行验证
				CheckItem(els[i]);
			}
		}
	}
	return flag;
}