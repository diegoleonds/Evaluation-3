<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.evaluation3.control.servlet.base.CrudServlet" %>
<%@ page import="com.example.evaluation3.data.model.entities.SubSpecie" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.evaluation3.control.servlet.AnimalServlet" %><%--
  Created by IntelliJ IDEA.
  User: diegosantos
  Date: 13/07/22
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Animal</title>
</head>
<body>
<form action="animal" method="post">
    <h1>Register Animal</h1>
    Name: <input type="text" name="name">
    <br>
    Sub-specie:
    <select name="sub_specie_id">
        <%
            List<SubSpecie> subSpecies = (ArrayList< SubSpecie>) request.getAttribute(AnimalServlet.subspecies);
            System.out.println("Subspecies: " + subSpecies);
            for(SubSpecie subSpecie : subSpecies) {
        %>
        <option value="<%=subSpecie.getId()%>"><%=subSpecie.getName()%></option>
        <%
            }
        %>
    </select>
    <input type="submit" value="<%=CrudServlet.register%>" name="register">
</form>
<a href="../index.jsp">Back to main section</a>
</body>
</html>