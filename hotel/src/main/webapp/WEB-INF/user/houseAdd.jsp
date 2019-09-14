<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>房间信息</title>
		<style>
			table{
				text-align: center;
			}
			select{
				width:150px;
			}
			span{
				font-size: 14px;
				color:red;
			}
			div{
				width:300px;
				margin:300px auto;
			}
		</style>
	</head>
	<body>
		<div>
			<p>当前用户：${user}</p>
			<form action="empdowmLine" method="get">
				<input type="submit" value="退出登录" title="退出登录">
			</form>
			<form action="houseAdd" method="post">
				<table border="1">
					<tr>
						<td colspan="2">添加房屋信息<span>${msg}</span></td>
					</tr>
					<tr>
						<td>房间编号：</td>
						<td><input type="text" name="houseId" id="houseId"
							onblur="str = document.getElementById('houseId').value;str = str.slice(0, 2) + '-' + str.slice(2); document.getElementById('houseLoc').value = str"></td>
					</tr>
					<tr>
						<td>房间位置：</td>
						<td><input type="text" name="houseLoc" id="houseLoc" readonly></td>
					</tr>
					<tr>
						<td>房间类型：</td>
						<td><select name="houseType" id="">
								<option value="A" selected>单人间</option>
								<option value="B">双人标准间</option>
								<option value="C">豪华双人间</option>
								<option value="D">豪华三人间</option>
								<option value="E">总统套房</option>
						</select></td>
					</tr>
					<tr>
						<td>设备状况：</td>
						<td><select name="houseArt" id="">
								<option value="Y" selected>完好</option>
								<option value="N">损坏</option>
						</select></td>
					</tr>
					<tr>
						<td>房间状态：</td>
						<td><select name="houseState" id="">
								<option value="A" selected>空房</option>
								<option value="B">已预订</option>
								<option value="C">已入住</option>
						</select></td>
					</tr>
					<tr>
						<td><input type="submit" value="添加房屋信息"></td>
						<td><a href="empMain.jsp">返回主页面</a></td>
					</tr>
				</table>
			</form>
		</div>
	</body>	
</html>