<%@ page import="com.example.evaluation3.data.model.enums.Diet" %>
<%@ page import="com.example.evaluation3.data.model.enums.Movement" %>
<%@ page import="com.example.evaluation3.data.model.entities.Specie" %>
<%@ page import="com.example.evaluation3.control.servlet.base.CrudServlet" %><%--
  Created by IntelliJ IDEA.
  User: diegosantos
  Date: 14/07/22
  Time: 02:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Specie</title>
</head>
<body>
<h1>Edit Specie:</h1>
<%
    Specie specie = (Specie) request.getAttribute("entity");
%>
<form action="specie" method="post">
    <input type="text" name="id" hidden="hidden" value="<%=specie.getId()%>">
    Name: <input type="text" name="name" value="<%=specie.getName()%>">
    <br>
    Diet:
    <select name="diet">
        <%
            for (Diet diet : Diet.values()) {
                if (diet.equals(specie.getDiet())) {
        %>
        <option value="<%=diet%>" selected="selected"><%=diet.getDescription()%>
        </option>
        <%
        } else {
        %>
        <option value="<%=diet%>"><%=diet.getDescription()%>
                <%
                }
                }
            %>
    </select>
    <br>
    Movements:
    <%
        for (Movement movement : Movement.values()) {
            if (specie.getMovements().contains(movement)) {
    %>
    <label>
        <input type="checkbox" name="movements" value="<%=movement%>" checked="checked">
        <%=movement.getDescription()%>
    </label>
    <%
    } else {
    %>
    <label>
        <input type="checkbox" name="movements" value="<%=movement%>">
        <%=movement.getDescription()%>
    </label>
    <%
            }
        }
    %>
    <br>
    <input type="submit" value="<%=CrudServlet.edit%>" name="edit">
</form>
</body>
</html>
