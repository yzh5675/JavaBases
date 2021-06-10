<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<style type="text/css">
    * {
        margin: 0 auto;
        padding: 0 auto;
        text-align: center;
    }
</style>
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
</head>
<body>
<h1>登录页面</h1>
<form action="${pageContext.request.contextPath}/login" method="post">
    <label>用户</label><input type="text" name="name"/><br/>
    <label>密码</label><input type="password" name="password"/><br/>
    <label><span style="color:red;">${msg}</span></label>
    <input type="submit" value="登录"/>
    <a href="${pageContext.request.contextPath}/toreg">注册</a>
</form>
</body>
</html>