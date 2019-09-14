<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>订房信息</title>
		<style>
			table form{
				display: inline-block;
			}
			table form input[type="submit"]{
				background-color: white;
				border:none;
				color:blue;
			}
			table form input[type="text"]{
				display: inline-block;
				width:70px;
			}
			table form input[type="submit"]:hover {
				color:red;
			}
			#price{
				border:1px solid black;
				display: inline-block;
				width:70px;
			}
			table span{
				font-size: 14px;
				color:red;
			}
			div{
				width:1300px;
				margin:0px auto;
			}
			div >span{
				font-size: 14px;
				display:inline-block;
				border:1px solid black;
				padding:5px 10px;
				cursor: pointer;
			}
			div >span:hover{
				color:blue;
				border-radius: 20px;
				font-weight: bolder;
			}
		</style>
	</head>
	<body>
		<div>
			<p>当前用户：${user}</p>
			<form action="empdowmLine" method="get">
				<input type="submit" value="退出登录" title="退出登录">
			</form>
			<br><br>
			<form action="selectOrderByName" method="post">
				<input type="text" name="userName">
				<input type="submit" value="用户名搜索" title="用户名搜索">
			</form>
			<table border="1" id="table">
				<tr>
					<th colspan="4">预定信息<span>${msg}</span></th>
				</tr>
				<tr>
					<th>预定编号</th>
					<th>预定日期</th>
					<th>房间编号</th>
					<th>客户姓名</th>
				</tr>
				<c:forEach items="${orderList}" var="order" varStatus="loop">
					<tr>
						<th>${order.orderId}</th>
						<th>${order.orderDate}</th>
						<th>${order.houseId}</th>
						<th>${order.userName}</th>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>