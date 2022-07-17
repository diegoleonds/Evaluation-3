<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.evaluation3.control.servlet.base.CrudServlet" %>
<%@ page import="com.example.evaluation3.data.model.entities.Specie" %><%--
  Created by IntelliJ IDEA.
  User: diegosantos
  Date: 13/07/22
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Subspecie</title>
</head>
<body>
<form action="subspecies" method="post">
    <h1>Register Subspecie</h1>
    Name: <input type="text" name="name">
    <br>
    Specie:
    <select name="specie_id">
        <%
            ArrayList<Specie> species = (ArrayList<Specie>) request.getAttribute("species");
            for(Specie specie : species) {
        %>
        <option value="<%=specie.getId()%>"><%=specie.getName()%></option>
        <%
            }
        %>
    </select>
    <input type="submit" value="<%=CrudServlet.register%>" name="register">
</form>
<a href="../menu.jsp">Back to main section</a>
</body>
</html>