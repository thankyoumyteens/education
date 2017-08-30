<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2017/8/30
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传</title>
    <link rel="stylesheet" href="./css/bootstrap.css">
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
    </style>
</head>
<body>
<div class="dialog-wrapper" id="dialogWrapper">
    <form action="<%=request.getContextPath() %>/adminUpload" method="post" enctype="multipart/form-data">
        <div class="login-dialog">
            <div class="login-item form-group">
                <h3>上传录像</h3>
            </div>
            <div class="login-item form-group">
                <input type="text" name="title" id="title" placeholder="标题" tabindex="1" class="form-control">
            </div>
            <div class="login-item form-group">
                <label>封面</label>
                <input type="file" name="imgUpload" accept="image/*" />
            </div>
            <div class="login-item form-group">
                <label>录像</label>
                <input type="file" name="courseUpload" accept="video/*" />
            </div>
            <div class="login-item form-group">
                <label>类型</label>
                <select name="type" id="type">
                    <option value="100">体验课</option>
                    <option value="0">工商管理</option>
                    <option value="1">工商管理</option>
                    <option value="2">工商管理</option>
                </select>
            </div>
            <div class="login-item form-group">
                <span><%=(request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()) %></span>
            </div>
            <div class="login-item">
                <button type="submit" id="loginButton" class="btn btn-primary" tabindex="4">上传</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
