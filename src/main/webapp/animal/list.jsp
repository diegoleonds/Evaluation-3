<%@ page import="com.example.evaluation3.data.model.entities.Specie" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.evaluation3.data.model.enums.Movement" %>
<%@ page import="com.example.evaluation3.control.servlet.base.CrudServlet" %>
<%@ page import="com.example.evaluation3.data.model.entities.SubSpecie" %>
<%@ page import="com.example.evaluation3.data.model.entities.Animal" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: diegosantos
  Date: 14/07/22
  Time: 00:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Animals</title>
</head>
<body>
<%
    List<Animal> entities = (ArrayList<Animal>) request.getAttribute("entities");
%>
<table>
    <thead>
    <tr>
        <th colspan="1">id</th>
        <th colspan="1">name</th>
        <th colspan="1">sub_specie</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (Animal entity : entities) {
    %>
    <tr>
        <form action="animal" method="post">
            <td>
                <div><%=entity.getId()%>
                </div>
                <input type="text" name="id" hidden="hidden" value="<%=entity.getId()%>">
            </td>
            <td>
                <%=entity.getName()%>
            </td>
            <td>
                <%=entity.getSubSpecie().getName()%>
            </td>
            <td>
                <button type="submit" name="goToEdit" value="<%=CrudServlet.goToEdit%>"><img src="ic_edit.svg"></button>
            </td>
            <td>
                <button type="submit" name="delete" value="<%=CrudServlet.delete%>"><img src="ic_delete.svg"></button>
            </td>
        </form>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<a href="../menu.jsp">Back to main section</a>
</body>
</html>