<%--
  Created by IntelliJ IDEA.
  User: Crown
  Date: 2019/11/5
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
<form action="shiro/login" method="post">
    user:<input type="text" name="username"><br/>
    pass:<input type="text" name="password"><br/>
    <input type="submit" value="提交">
</form>
    <h1><a href="shiro/logout">Login</a></h1>
</body>
</html>
