<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>主界面</title>
		<style>
			form input{
				background-color: white;
				border:none;
				color:blue;
			}
			form input:hover {
				color:red;
			}
			#B,#C,#D,#A1,#C1,#D1,#A2,#B2,#C2,form input[type="text"]{
				display: none;
			}
		</style>
	</head>
	<body>
		<p>当前用户：${user}</p>		
		<form action="empGoUpdate" method="get" id="${emp1.empType}">
			<input type="submit" value="员工信息管理" title="员工信息修改">
		</form>
		<form action="empGoAddHouse" method="get" id="${emp1.empType}1">
			<input type="submit" value="添加房屋信息" title="添加房屋信息">
		</form>
		<form action="empGoshowHouse" method="get" id="${emp1.empType}1">
			<input type="submit" value="显示房屋信息" title="显示房屋信息">
		</form>
		<form action="empGoAddOrder" method="get" id="${emp1.empType}2">
			<input type="submit" value="添加订房信息" title="添加订房信息">
		</form>
		<form action="empGoChangeOrder" method="get" id="${emp1.empType}2">
			<input type="submit" value="修改订房信息" title="修改订房信息">
		</form>
		<form action="empGoShowOrder" method="get" id="${emp1.empType}2">
			<input type="submit" value="显示订房信息" title="显示订房信息">
		</form>
		<form action="empGoshowHouseState" method="get" id="${emp1.empType}2">
			<input type="submit" value="显示房间状态" title="显示房间状态">
		</form>
		<form action="empGoUpdateOwn" method="post">
			<input type="text" value="${emp1.empName}" name="empName">
			<input type="submit" value="个人信息管理" title="个人信息修改">
		</form>
		<form action="empdowmLine" method="get">
			<input type="submit" value="退出登录" title="退出登录">
		</form>
	</body>
</html>