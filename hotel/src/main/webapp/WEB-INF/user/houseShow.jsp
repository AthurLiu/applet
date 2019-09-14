<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>添加订房信息</title>
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
				color:white;
				border-radius: 20px;
				font-weight: bolder;
			}
			.C{
				background-color: red;
			}
			.B{
				background-color: yellow;
			}
			.A{
				background-color: blue;
			}
		</style>
	</head>
	<body>
		<div>
			<p>当前用户：${user}</p>
			<form action="empdowmLine" method="get">
				<input type="submit" value="退出登录" title="退出登录">
			</form>
			<span class="A">空房</span>
			<span class="C">已入住</span>
			<span class="B">已预订</span>
			<br><br>
			<table border="1" style="text-align: center;">
				<tr>
					<td colspan="3">601</td>
					<td colspan="3">602</td>
					<td colspan="3">603</td>
				</tr>
				<tr>
					<td colspan="2">501</td>
					<td colspan="2">502</td>
					<td colspan="2">503</td>
					<td colspan="2">504</td>
					<td colspan="2">505</td>
				</tr>
				<tr>
					<td colspan="2">401</td>
					<td colspan="2">402</td>
					<td colspan="2">403</td>
					<td colspan="2">404</td>
					<td colspan="2">405</td>
				</tr>
				<tr>
					<td>301</td>
					<td>302</td>
					<td>303</td>
					<td>304</td>
					<td>305</td>
					<td>306</td>
					<td>307</td>
					<td>308</td>
					<td>309</td>
					<td>310</td>
				</tr>
				<tr>
					<td>201</td>
					<td>202</td>
					<td>203</td>
					<td>204</td>
					<td>205</td>
					<td>206</td>
					<td>207</td>
					<td>208</td>
					<td>209</td>
					<td>210</td>
				</tr>
				<tr>
					<td>101</td>
					<td>102</td>
					<td>103</td>
					<td>104</td>
					<td>105</td>
					<td>106</td>
					<td>107</td>
					<td>108</td>
					<td>109</td>
					<td>110</td>
				</tr>
			</table>
			<table border="1" id="table">
				<tr>
					<th colspan="9">房间信息表<span>${msg}</span></th>
				</tr>
				<tr>
					<th>房间编号</th>
					<th>房间位置</th>
					<th>房间类型</th>
					<th>房间物品</th>
					<th>房间状态</th>
				</tr>
				<c:forEach items="${houseList}" var="house">
					<tr class="${house.houseType}">
						<th>${house.houseId}</th>
						<th>${house.houseLoc}</th>
						<th>${house.houseType}</th>
						<th>${house.houseArt}</th>
						<th>${house.houseState}</th>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>