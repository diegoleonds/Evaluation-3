<%@ page import="com.example.evaluation3.data.model.enums.Diet" %>
<%@ page import="com.example.evaluation3.data.model.enums.Movement" %>
<%@ page import="com.example.evaluation3.data.model.entities.Specie" %>
<%@ page import="com.example.evaluation3.control.servlet.base.CrudServlet" %>
<%@ page import="com.example.evaluation3.data.model.entities.SubSpecie" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: diegosantos
  Date: 14/07/22
  Time: 02:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Subspecie</title>
</head>
<body>
<h1>Edit Subspecie:</h1>
<%
    SubSpecie entity = (SubSpecie) request.getAttribute("entity");
    List<Specie> species = (ArrayList<Specie>) request.getAttribute("species");
%>
<form action="subspecies" method="post">
    <input type="text" name="id" hidden="hidden" value="<%=entity.getId()%>">
    Name: <input type="text" name="name" value="<%=entity.getName()%>">
    <br>
    Specie:
    <select name="specie_id">
        <%
            for (Specie specie : species) {
                if (specie.equals(entity.getSpecie())) {
        %>
        <option value="<%=specie.getId()%>" selected="selected"><%=specie.getName()%>
        </option>
        <%
        } else {
        %>
        <option value="<%=specie.getId()%>"><%=specie.getName()%>
                <%
                }
                }
            %>
    </select>
    <br>
    <input type="submit" value="<%=CrudServlet.edit%>" name="edit">
</form>
</body>
</html>
