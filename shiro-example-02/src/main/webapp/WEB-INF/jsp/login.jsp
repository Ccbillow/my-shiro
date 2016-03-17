<%--
  Created by IntelliJ IDEA.
  User: Cbillow
  Date: 16/3/14
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <style>.error{color: red;}</style>
</head>
<body>
<div class="error">$error</div>
<form action="${pageContext.request.contextPath}/login" method="post">
  用户名：<input type="text" name="username">
  密码：<input type="password" name="password">
  <input type="submit" value="登陆">
</form>
</body>
</html>
