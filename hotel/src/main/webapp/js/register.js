register = function(){	
 	$.ajax({
 		url:"/hotel/empRegister",
 		type:"post",
 		data: $("#register").serialize(),
 		success:function(data){
 			if(data == "success"){
 				window.location.href="login.html";
 			} else {
 				$("#tips").html("注册失败");
 			}
 		},error:function(error){
 			$("#tips").html("注册失败");
 		}
 	})
}
isExit = function(){	
 	$.ajax({
 		url:"/hotel/isExit",
 		type:"post",
 		data: $("#register").serialize(),
 		success:function(data){
 			if(data == "fail"){
 				$("#tips").html("用户名已存在");
 			} else {
 				$("#tips").html("用户名未存在");
 			}
 		},error:function(error){
 			$("#tips").html("用户名查询操作失败");
 		}
 	})
}