<%@ page import="com.example.evaluation3.data.model.entities.Specie" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.evaluation3.data.model.enums.Movement" %>
<%@ page import="com.example.evaluation3.control.servlet.base.CrudServlet" %><%--
  Created by IntelliJ IDEA.
  User: diegosantos
  Date: 14/07/22
  Time: 00:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Species</title>
</head>
<body>
<%
    ArrayList<Specie> species = (ArrayList<Specie>) request.getAttribute("entities");
%>
<table>
    <thead>
    <tr>
        <th colspan="1">id</th>
        <th colspan="1">name</th>
        <th colspan="1">diet</th>
        <th colspan="1">movements</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (Specie specie : species) {
    %>
    <tr>
        <form action="specie" method="post">
            <td>
                <div><%=specie.getId()%>
                </div>
                <input type="text" name="id" hidden="hidden" value="<%=specie.getId()%>">
            </td>
            <td>
                <%=specie.getName()%>
            </td>
            <td>
                <%=specie.getDiet().getDescription()%>
            </td>
            <td>
                <ul>
                    <%
                        for (Movement movement : specie.getMovements()) {
                    %>
                    <li><%=movement.getDescription()%>
                    </li>
                    <%
                        }
                    %>
                </ul>
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