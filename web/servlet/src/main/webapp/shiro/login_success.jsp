<%--
  Created by IntelliJ IDEA.
  User: Crown
  Date: 2019/11/8
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<!-- -->
登录认证成功
<!-- shiro标签会触发realm的受权方法，有权限才会显示 -->
<!-- 所以只有当前用户有admin角色才会显示 -->
<shiro:hasRole name="admin">
    <br> <a href="admin">admin页面</a>
</shiro:hasRole>

<br> <a href="user/logout">登出</a>

</body>
</html>
