<%@ page import="com.example.evaluation3.data.model.entities.Specie" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.evaluation3.data.model.enums.Movement" %><%--
  Created by IntelliJ IDEA.
  User: diegosantos
  Date: 14/07/22
  Time: 00:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Species:</title>
</head>
<body>
<%
    ArrayList<Specie> species = (ArrayList<Specie>) request.getAttribute("species");
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
        <td><%=specie.getId()%>
        </td>
        <td><%=specie.getName()%>
        </td>
        <td><%=specie.getDiet().getDescription()%>
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
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<a href="index.jsp">Back to main section</a>
</body>
</html>