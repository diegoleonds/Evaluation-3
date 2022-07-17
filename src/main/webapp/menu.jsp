<%--
  Created by IntelliJ IDEA.
  User: diegosantos
  Date: 17/07/22
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<h1>Main menu</h1>
<h2>Animals:</h2>
<form action="animal" method="get">
    <button type="submit" name="register">Register</button>
    <br>
    <button type="submit" name="list">List</button>
    <br>
</form>
<br>
<h2>Species:</h2>
<form action="specie" method="get">
    <button type="submit" name="register">Register</button>
    <br>
    <button type="submit" name="list">List</button>
    <br>
</form>
<br>
<h2>Sub-species:</h2>
<form action="subspecies" method="get">
    <button type="submit" name="register">Register</button>
    <br>
    <button type="submit" name="list">List</button>
    <br>
</form>
</body>
</html>
