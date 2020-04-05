function change(img){
	img.src="getCode?"+new Date().getTime();
}



function FocusItem(obj){
	if($(obj).attr('name')=='veryCode'){
		$(obj).next().next().html('').removeClass('error');
	}else{
		$(obj).next('span').html('').removeClass('error');
	}
}




function CheckItem(obj){
	var msgBox=$(obj).next('span');
	switch($(obj).attr('name')){
		case "username":
			if(obj.value==""){
				msgBox.html('用户名不能为空');
				msgBox.addClass('error');
			}else{
				//使用ajax判断数据库中是否有该名字
				var url="usernamecheck?name="+encodeURI($(obj).val())+"&"+new Date().getTime();
				
				$.get(url,function(data){
					if(data=="false"){
						msgBox.html('用户名不能使用');
						msgBox.addClass('error');
					}else{
						msgBox.html().removeClass('error');
					} 
				});
			}
			break;
		
		case "name":
			if(obj.value==""){
				msgBox.html('姓名不能为空');
				msgBox.addClass('error');
			}
			break;
			
		case "passWord":
			if(obj.value==""){
				msgBox.html('用户密码不能为空');
				msgBox.addClass('error');
			}
			break;
		
		case "rePassWord":
			if(obj.value==""){
				msgBox.html('用户确认密码不能为空');
				msgBox.addClass('error');
			}else if($(obj).val()!=$('input[name="passWord"]').val() ){
				msgBox.html('两次输入的密码不一致');
				msgBox.addClass('error');
			}
			break;
		
		case "veryCode":
			var numshow=$(obj).next().next();
			
			if(obj.value==""){
				numshow.html('验证码不能为空');
				numshow.addClass('error');
			}else{
				var url="checkusernum?num="+encodeURI($(obj).val())+"&"+new Date().getTime();
				$.get(url,function(numdata){
					if(numdata=='false'){
						numshow.html('验证码输入有误');
						numshow.addClass('error');
					}else{
						numshow.html().removeClass('error');
					}
				});
			
			}
			
			break;
	}
	
}






