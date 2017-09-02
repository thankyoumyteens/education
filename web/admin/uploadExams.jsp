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
    <title>上传录音</title>
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
    <form onsubmit="check" action="<%=request.getContextPath() %>/adminUploadExams" method="post" enctype="multipart/form-data">
        <div class="login-dialog">
            <div class="login-item form-group">
                <h3>上传试题</h3>
            </div>
            <div class="login-item form-group">
                <input type="text" name="title" id="title" placeholder="标题" tabindex="1" class="form-control">
            </div>
            <%--<div class="login-item form-group">--%>
                <%--<label>封面(只支持jpg和png格式)</label>--%>
                <%--<input type="file" name="imgUpload" accept="image/*" />--%>
            <%--</div>--%>
            <div class="login-item form-group">
                <label>文件</label>
                <input type="file" name="examsUpload" />
            </div>
            <div class="login-item form-group">
                <label>类型</label>
                <select name="type" id="type">
                    <option value="exams">真题</option>
                    <option value="simulation">模拟题</option>
                </select>
            </div>
            <div class="login-item form-group">
                <span class="message"><%=(request.getAttribute("message") == null ? "" : request.getAttribute("message").toString()) %></span>
            </div>
            <div class="login-item">
                <button type="submit" id="loginButton" class="btn btn-primary" tabindex="4">上传</button>
            </div>
        </div>
    </form>
    <script>
        function check() {
            document.getElementById('loginButton').innerHTML = "上传中...";
        }
    </script>
</div>
</body>
</html>
