<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2017/8/30
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/admin/css/bootstrap.css">
    <style>
        .dialog-wrapper {
            width: 500px;
            padding: 27px 45px 40px;
            background: #fff;
            border-radius: 4px;
            margin: 0 auto;
        }

        #loginButton {
            width: 100%;
        }

        .message {
            color: #ff3333;
        }
    </style>
</head>
<body>
<div class="dialog-wrapper" id="dialogWrapper">
    <form action="<%=request.getContextPath() %>/adminLogin" method="post">
        <div class="login-dialog">
            <div class="login-item form-group">
                <h3>登陆</h3>
            </div>
            <div class="login-item form-group">
                <input type="text" name="userId" id="userId" placeholder="用户名" tabindex="1" class="form-control">
            </div>
            <div class="login-item form-group">
                <input type="password" name="password" id="password" placeholder="密码" tabindex="2" class="form-control">
            </div>
            <div class="login-item form-group">
                <span class="message"><%=(request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()) %></span>
            </div>
            <div class="login-item">
                <button type="submit" id="loginButton" class="btn btn-primary" tabindex="4">登陆</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
