<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>员工信息</title>
		<style>
			table form{
				display: inline-block;
			}
			table form input{
				background-color: white;
				border:none;
				color:blue;
			}
			table form input:hover {
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
			.showH{
				background-color: white;
			}
			.showF{
				background-color: blueviolet;
			}
			.showG{
				background-color: purple;
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
					} else if (str == "E"){
						list[i].style.background = "blue";
					} else if (str == "A1"){
						list[i].style.background = "white";
					} else if (str == "B1"){
						list[i].style.background = "blueviolet";
					} else {
						list[i].style.background = "purple";
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
			<span onclick="showType('A1')" class="showH">空房</span>
			<span onclick="showType('B1')" class="showF">已预订</span>
			<span onclick="showType('C1')" class="showG">已入住</span>
			<br><br>
			<table border="1" id="table">
				<tr>
					<th colspan="12">房间信息表<span>${msg}</span></th>
				</tr>
				<tr>
					<th>房间编号</th>
					<th>房间位置</th>
					<th>房间类型</th>
					<th>房间价格</th>
					<th>房间物品</th>
					<th>房间状态</th>
					<td>创建ID</td>
					<td>创建时间</td>
					<td>修改ID</td>
					<td>修改时间</td>
					<th>删除房间</th>
					<th>修改价格</th>
				</tr>
				<c:forEach items="${houseList}" var="house" varStatus="loop">
					<tr class="${house.getHouseType()}" class="tr">
						<th class="${house.houseState}1">${house.houseId}</th>
						<th>${house.houseLoc}</th>
						<th>${house.houseType}</th>
						<th>${house.housePrice}</th>
						<th>${house.houseArt}</th>
						<th>${house.houseState}</th>
						<td>${house.createId}</td>
						<td>${house.createTime}</td>
						<td>${house.updateId}</td>
						<td>${house.updateTime}</td>
						<th>
							<form action="houseDelete" method="post">
								<input type="text" name="houseId" value="${house.houseId}" style="display: none">
								<input type="submit" value="删除" title="删除该房间">
							</form>
						</th>
						<th>
							<form action="houseUpdate" method="post">
								房间价格：<input type="text" name="housePrice" id="price" value="${house.housePrice}">
								<input type="text" name="houseType" value="${house.houseType}" style="display: none">
								<input type="submit" value="修改价格" title="修改该种类房间价格">
							</form>
						</th>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>