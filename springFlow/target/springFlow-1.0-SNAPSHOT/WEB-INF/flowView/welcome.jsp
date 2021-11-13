<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 姚鹏鹏
  Date: 2021/9/17
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Welcome to Spizza</h2>
<form:form>
<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
<input type="text" name="phoneNumber"/><br/>
<input type="submit" name="_eventId_phoneEntered" value="Lookup Customer">
</form:form>
</body>
</html>
