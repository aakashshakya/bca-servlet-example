<%-- 
    Document   : basic_jsp
    Created on : Feb 16, 2022, 11:21:10 AM
    Author     : Aakash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String greet = "Hello friend. ";
            for (int i = 0; i < 10; i++) {
        %>
        <h1><%=greet + (i)%></h1>
        <%
            }
        %>
    </body>
</html>
