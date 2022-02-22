<%-- 
    Document   : list_with_jsp
    Created on : Feb 16, 2022, 11:26:32 AM
    Author     : Aakash
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List with JSP</title>
    </head>
    <body>
        <%
            List<String> names = new ArrayList<>();
            names.add("Momeik Shristha");
            names.add("Shreeju Pradhan");
            names.add("Ashesh Shakya");
            names.add("Suja Maharjan");
            names.add("Sanam Maharjan");
        %>

        <%
            for (String name : names) {
        %>
        <h2><%=name%></h2>
        <%
            }
        %>
    </body>
</html>
