<%--
  Created by IntelliJ IDEA.
  User: gx
  Date: 17/5/28
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登陆页面</title>
</head>
<body>
    <form id='userLogin' name='userLogin' action='/user/login.json' method="post">
        <label>用户名：<input id='name' name='name'></label>
        <label>密码：<input id='password' name='password' type="password"></label>
        <label><input type="submit" value="登陆"></label>
    </form>
</body>
</html>
