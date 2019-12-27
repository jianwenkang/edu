<%--
  Created by IntelliJ IDEA.
  User: Crown
  Date: 2019/11/5
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>list</title>
</head>
<body>
    <h1>List</h1>
    Welcome:<shiro:principal></shiro:principal>
    <shiro:hasRole name="admin"><h1>Admin</h1></shiro:hasRole>
    <shiro:hasRole name="user"><h1>User</h1></shiro:hasRole>

</body>
</html>
