<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2017/8/30
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>授权</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/admin/css/bootstrap.css">
</head>
<body>
<form onsubmit="check" action="<%=request.getContextPath() %>/adminPermission" method="get">
    <div class="login-dialog">
        <div class="login-item form-group">
            <input type="text" name="uid" id="uid" placeholder="手机号" tabindex="1" class="form-control">
        </div>
        <div class="login-item form-group">
            <span class="message"><%=(request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()) %></span>
        </div>
        <div class="login-item">
            <button type="submit" id="loginButton" class="btn btn-primary" tabindex="4">授权</button>
        </div>
    </div>
</form>
</body>
</html>
