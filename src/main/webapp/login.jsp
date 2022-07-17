<%@ page import="com.example.evaluation3.control.servlet.LoginServlet" %><%--
  Created by IntelliJ IDEA.
  User: diegosantos
  Date: 17/07/22
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="<%=LoginServlet.login%>" method="post">
    Username: <input type="text" name="<%=LoginServlet.username%>"> <br>
    Password: <input type="password" name="<%=LoginServlet.password%>"> <br>
    <input type="submit" name="<%=LoginServlet.login%>" value="<%=LoginServlet.login%>"/>
</form>
</body>
</html>
