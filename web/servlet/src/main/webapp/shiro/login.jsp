<%--
  Created by IntelliJ IDEA.
  User: Crown
  Date: 2019/11/8
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
</head>
<body>
<!-- 用户登录认证 -->
<form action="user/login" method="post" >
    用户名称：<input type="text" name="myusername" /><br>
    用户密码：<input type="text" name="mypassword" /><br>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
