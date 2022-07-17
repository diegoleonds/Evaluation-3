<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
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