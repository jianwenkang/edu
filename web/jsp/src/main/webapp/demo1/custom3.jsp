<%--
  Created by IntelliJ IDEA.
  User: Crown
  Date: 2019/4/15
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String namespace = "";
%>
<html>
<head>
    <base href="<%=basePath%>">

    <title>jQuery_cxSelect</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
    <script type="text/javascript" src="js/jquery.cxselect.min.js"></script>
</head>

<body>
<!--
select 必须放在元素 id="element_id"（city） 的内部，不限层级
select 的 class 任意取值，也可以附加多个 class，如 class="province otherclass"，在调用时只需要输入其中一个即可，但是不能重复
如需设置 select 默认值，加上 data-value 属性，例：<select class="province" data-value="浙江省"></select>
-->
<fieldset id="custom" >
    <legend>设置默认值及选项标题</legend>
    <p>所在地区：
        <select class="first" data-value="1" data-first-title="选择1" disabled="disabled"></select>
        <select class="second" data-value="2" data-first-title="选择2"  disabled="disabled" ></select>
        <select class="third" data-value="3" data-first-title="选择3" disabled="disabled"></select>
    </p>
</fieldset>
</body>

<script type="text/javascript">
    /* 使用 JSON 格式
    * v : 设置 option 的值（可选项，未设置则使用 n）
    * n : 设置 option 的文本
    * s : 当前选项的子集
    */
    //$.cxSelect.defaults.url = "data/cityData.min.json";

    /*$("#custom").cxSelect({
        selects : ["first", "second", "third"],
        nodata : "none",
        url:"data/cityData.min.json"

    });*/
    $("#custom").cxSelect({
        selects : ["first", "second", "third"],
        nodata : "none",
        url:"data/cityData.min.json"

    },function (api) {
        cxSelectApi = api;
        cxSelectApi.clear();
        }

    );
</script>
</html>
