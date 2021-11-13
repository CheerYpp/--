<%--
  Created by IntelliJ IDEA.
  User: 姚鹏鹏
  Date: 2021/9/27
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3>Login with Username and password </h3>

<form name="f" action="/spittr/login" method="post">
    <table>
        <tr><td>User:</td><td><input type="text" name="username" value=""></td></tr>
        <tr><td>Password:</td><td><input type="password" name="password"></td></tr>
        <tr><td colspan="2"><input type="submit" name="submit" value="Login"></td></tr>
        <input name="_csrf" type="hidden" value="6829"/>
    </table>
</form>
</body>
</html>
