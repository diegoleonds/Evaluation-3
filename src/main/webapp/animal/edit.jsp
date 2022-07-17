<%@ page import="com.example.evaluation3.control.servlet.base.CrudServlet" %>
<%@ page import="com.example.evaluation3.data.model.entities.SubSpecie" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.evaluation3.data.model.entities.Animal" %>
<%@ page import="com.example.evaluation3.control.servlet.AnimalServlet" %><%--
  Created by IntelliJ IDEA.
  User: diegosantos
  Date: 14/07/22
  Time: 02:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Animal</title>
</head>
<body>
<h1>Edit Animal:</h1>
<%
    Animal entity = (Animal) request.getAttribute("entity");
    List<SubSpecie> subSpecies = (ArrayList<SubSpecie>) request.getAttribute(AnimalServlet.subspecies);
%>
<form action="animal" method="post">
    <input type="text" name="id" hidden="hidden" value="<%=entity.getId()%>">
    Name: <input type="text" name="name" value="<%=entity.getName()%>">
    <br>
    Sub-specie:
    <select name="sub_specie_id">
        <%
            for (SubSpecie subSpecie : subSpecies) {
                if (subSpecie.equals(entity.getSubSpecie())) {
        %>
        <option value="<%=subSpecie.getId()%>" selected="selected"><%=subSpecie.getName()%>
        </option>
        <%
        } else {
        %>
        <option value="<%=subSpecie.getId()%>"><%=subSpecie.getName()%>
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
