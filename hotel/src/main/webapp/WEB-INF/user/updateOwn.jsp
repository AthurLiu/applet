<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>个人信息修改</title>
		<style>
			form input[type="submit"]{
				background-color: white;
				border:none;
				color:blue;
			}
			form input[type="submit"]:hover {
				color:red;
			}
		</style>
	</head>
	<body>
		<p>当前用户：${user}</p>
		<form action="empdowmLine" method="get">
			<input type="submit" value="退出登录" title="退出登录">
		</form>
		<h2>修改前</h2>
		<table border="1">
			<tr>
				<td>用户编号</td>
				<td>用户姓名</td>
				<td>用户密码</td>
				<td>用户工作</td>
				<td>创建ID</td>
				<td>创建时间</td>
				<td>修改ID</td>
				<td>修改时间</td>
			</tr>
			<tr>
				<td>${emp1.empId}</td>
				<td>${emp1.empName}</td>
				<td>${emp1.empPass}</td>
				<td>${emp1.empType}</td>
				<td>${emp1.createId}</td>
				<td>${emp1.createTime}</td>
				<td>${emp1.updateId}</td>
				<td>${emp1.updateTime}</td>
			</tr>
		</table>
		<h2>修改后</h2>
		<form action="empUpdateOwn" method="post">
			<table border="1">
				<tr>
					<td>用户编号：</td>
					<td>用户姓名：</td>
					<td>用户密码：</td>
					<td>用户操作：</td>
				</tr>
				<tr>
					<td><input type="text" name="empId" value="${emp1.empId}" readonly="readonly"></td>
					<td><input type="text" name="empName" value="${emp1.empName}"></td>
					<td><input type="text" name="empPass" value="${emp1.empPass}"></td>
					<td><input type="submit" value="修改信息" title="员工个人信息修改"></td>
				</tr>
			</table>
		</form>
		${msg}
	</body>
</html>