<%--
  Created by IntelliJ IDEA.
  User: Cbillow
  Date: 16/3/14
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
  欢迎${subject.principal}登陆成功！
  <a href="${pageContext.request.contextPath}/logout">退出</a>
</body>
</html>
