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
			.showA{
				background-color: red;
			}
			.showB{
				background-color: orange;
			}
			.showC{
				background-color: yellow;
			}
			.showD{
				background-color: green;
			}
			.showE{
				background-color: blue;
			}
		</style>
		<script type="text/javascript">
			function showType(str) {
				var list = document.getElementsByClassName(str);
				for(var i = 0; i < list.length; i++){
					if(str == "A"){
						list[i].style.background = "red";
					} else if (str == "B"){
						list[i].style.background = "orange";
					} else if (str == "C"){
						list[i].style.background = "yellow";
					} else if (str == "D"){
						list[i].style.background = "green";
					} else {
						list[i].style.background = "blue";
					} 
				}
			}
		</script>
	</head>
	<body>
		<div>
			<p>当前用户：${user}</p>
			<form action="empdowmLine" method="get">
				<input type="submit" value="退出登录" title="退出登录">
			</form>
			<span onclick="showType('A')" class="showA">单人标准间</span>
			<span onclick="showType('B')" class="showB">双人标准间</span>
			<span onclick="showType('C')" class="showC">豪华双人间</span>
			<span onclick="showType('D')" class="showD">豪华三人间</span>
			<span onclick="showType('E')" class="showE">总统套房</span>
			<br><br>
			<table border="1" id="table">
				<tr>
					<th colspan="11">已经预定的房间<span>${msg}</span></th>
				</tr>
				<tr>
					<th>房间编号</th>
					<th>房间位置</th>
					<th>房间类型</th>
					<th>房间价格</th>
					<th>房间押金</th>
					<th>房间物品</th>
					<th>房间状态</th>
					<th>订房日期</th>
					<th>客户姓名</th>
					<th>取消订单</th>
					<th>转接待</th>
				</tr>
				<c:forEach items="${houseList}" var="house" varStatus="loop">
					<tr class="${house.houseType}">
						<th>${house.houseId}</th>
						<th>${house.houseLoc}</th>
						<th>${house.houseType}</th>
						<th>${house.housePrice}</th>
						<th>${house.houseDep}</th>
						<th>${house.houseArt}</th>
						<th>${house.houseState}</th>
						<th>${house.createTime}</th>
						<th>${house.updateTime}</th>
						<th>
							<form action="changeOrderA" method="post">
								<input type="text" name="houseId" value="${house.houseId}" style="display: none">
								<input type="submit" value="取消订房" title="取消订房">
							</form>
						</th>
						<th>
							<form action="changeReciver" method="post">
								<input type="text" name="userName" value="${house.updateTime}" style="display: none">
								<input type="text" name="houseId" value="${house.houseId}" style="display: none">
								<input type="text" name="houseDep" value="${house.houseDep}" style="display: none">
								<input type="submit" value="转接待" title="转接待">
							</form>
						</th>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>