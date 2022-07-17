<%@ page import="com.example.evaluation3.data.dao.SpecieDao" %>
<%@ page import="com.example.evaluation3.data.model.enums.Diet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.evaluation3.data.model.enums.Movement" %>
<%@ page import="com.example.evaluation3.control.servlet.base.CrudServlet" %><%--
  Created by IntelliJ IDEA.
  User: diegosantos
  Date: 13/07/22
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Specie</title>
</head>
<body>
<form action="specie" method="post">
    Name: <input type="text" name="name">
    <br>
    Diet:
    <select name="diet">
        <%
            for (Diet diet : Diet.values()) {
        %>
        <option value="<%=diet%>"><%=diet.getDescription()%>
        </option>
        <%
            }
        %>
    </select>
    <br>
    Movements:
    <%
        for (Movement movement : Movement.values()) {
    %>
    <label>
        <input type="checkbox" name="movements" value="<%=movement%>">
        <%=movement.getDescription()%>
    </label>
    <%
        }
    %>
    <br>
    <input type="submit" value="<%=CrudServlet.register%>" name="register">
</form>
<a href="../menu.jsp">Back to main section</a>
</body>
</html>