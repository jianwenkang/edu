<%--
  Created by IntelliJ IDEA.
  User: Crown
  Date: 2019/4/9
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    Boolean sts = true;
    request.setAttribute("sts", sts);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Current Time:<%= new java.util.Date()%></h1>
    <h1>Method:<%= method()%></h1>
    <% String str = "ss";
        System.out.println(str);

    %>
    <li style="border: none;"><a href="#" <c:if test="${sts}">style="pointer-events: none;text-decoration: line-through"</c:if> >1111111111</a></li>
    <c:set var="salary" scope="request" value="${2000*2}"/>
    <c:if test="${salary > 2000}">
        <p>我的工资为: <c:out value="${sts}"/><p>
    </c:if>
    <%!
        public String method(){
            System.out.println("====");
            return "qqqq";
        }
    %>
</body>
</html>
