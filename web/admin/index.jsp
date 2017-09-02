<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2017/8/30
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/admin/css/bootstrap.css">
    <style>
        a {
            float: left;
        }
        #frm {
            clear: both;
            width: 700px;
            height: 400px;
            margin-top: 70px;
        }
    </style>
</head>
<body>
<a class="btn btn-primary" onclick="showOp('<%=request.getContextPath() %>/admin/upload.jsp')">上传</a>
<a class="btn btn-primary" onclick="showOp('<%=request.getContextPath() %>/admin/permission.jsp')">授权</a>
<iframe src="" frameborder="1" id="frm" name="frm"></iframe>

<script>
    window.onload = function () {
        //
    }
    function showOp(link) {
        document.getElementById('frm').src = link;
    }
</script>
</body>
</html>
