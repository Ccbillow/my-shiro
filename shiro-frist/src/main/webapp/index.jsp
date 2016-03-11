<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<body>
<h2>Hello <shiro:principal></shiro:principal></h2>
<shiro:guest>
    <a href="/shiro/login">用户登录 </a>
</shiro:guest>
<shiro:user>
    <a href="/shiro/user/list.jsp">用户列表 </a>
    <shiro:hasPermission name="user:add">
        <a href="/shiro/user/add.jsp">用户添加  </a>
    </shiro:hasPermission>
    <shiro:hasRole name="admin">
        <a href="/shiro/admin">管理界面  </a>
    </shiro:hasRole>
        <a href="/shiro/logout">退出  </a>
</shiro:user>
</body>
</html>
