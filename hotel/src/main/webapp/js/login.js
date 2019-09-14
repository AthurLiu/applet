login = function(){	
 	$.ajax({
 		url:"/hotel/empLogin",
 		type:"post",
 		data: $("#login").serialize(),
 		success:function(data){
 			if(data == "fail"){
 				$("#tips").html("登录失败,密码错误");
 			} else {
 				window.location.href="main.html";
 			}
 		},error:function(error){
 			$("#tips").html("登录失败");
 		}
 	})
}
isExit = function(){	
 	$.ajax({
 		url:"/hotel/isExit",
 		type:"post",
 		data: $("#login").serialize(),
 		success:function(data){
 			if(data == "fail"){
 				$("#tips").html("用户名已存在");
 			} else {
 				$("#tips").html("用户名不存在");
 			}
 		},error:function(error){
 			$("#tips").html("用户名查询操作失败");
 		}
 	})
}