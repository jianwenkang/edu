<%@page pageEncoding="UTF-8" contentType="text/html; utf-8" language="java" %>
<html>
<head>
    <script src="../js/jquery-1.10.1.min.js">
    </script>
    <script>
        $(document).ready(function(){
            $("#btn1").click(function(){
                $('#test').load('table.jsp');
            })
        })
    </script>
</head>

<body>

<h3 id="test">请点击下面的按钮，通过 jQuery AJAX 改变这段文本。</h3>
<button id="btn1" type="button">获得外部的内容</button>

</body>
</html>