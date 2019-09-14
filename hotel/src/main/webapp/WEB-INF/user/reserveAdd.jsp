<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>客户信息</title>
        <style>
			table span{
				font-size: 14px;
				color:red;
			}
		</style>
    </head>
    <body>
    	<p>当前用户：${user}</p>
		<form action="empdowmLine" method="get">
			<input type="submit" value="退出登录" title="退出登录">
		</form>
        <form action="reserveAdd" method="post">
            <table style="text-align: center" border="1">
                <tr>
                    <td colspan="7">
                        <strong>入住登记注册<span>${msg}</span></strong>
                    </td>
                </tr>
                 <tr>
                    <td>房间编号：</td>
                    <td><input type="text" name="updateId" value="${houseId}"></td>
                </tr>
                <tr>
                    <td>房间押金：</td>
                    <td><input type="text" name="houseDep" value="${houseDep}"></td>
                </tr>
                <tr>
                	<td>是否开网：</td>
                	<td>
                		 开：<input id="sex" type="radio" name="createTime" value="Y">
						 不开：<input id="sex" type="radio" name="createTime" checked value="N">
                	</td>      
                </tr>
                <tr>
                    <td>客户姓名：</td>
                    <td><input type="text" name="userName" value="${userName}"></td>
                </tr>
                <tr>
                	<td>客户姓别：</td>
                	<td>
                		 男：<input id="sex" type="radio" name="userSex" checked value="M">
						 女：<input id="sex" type="radio" name="userSex" value="F">
                	</td>      
                </tr>
                <tr>
                    <td>身份证号：</td>
                    <td><input type="text" name="userCard" value="320124199511080321"></td>
                </tr>
                <tr>
                    <td>家庭住址：</td>
                    <td><input type="text" name="userAddress" value="xx省xx市xx县"></td>
                </tr>
                 <tr>
                    <td>电话号码：</td>
                    <td><input type="text" name="userPhone" value="18888888888"></td>
                </tr>
                <tr>
                    <td colspan="1">
                        <input type="submit" value="办理入住">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>