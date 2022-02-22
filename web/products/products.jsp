<%-- 
    Document   : products
    Created on : Feb 16, 2022, 11:43:09 AM
    Author     : Aakash
--%>

<%@page import="products.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp" />
<a href="products/add-product.jsp">Add product</a>
<h1>Show all products</h1>
<%
    List<Product> products = (List<Product>) request.getAttribute("products");
%>
<% if (products.size() > 0) {%>
<table>
    <tr>
        <th>Product Id</th>
        <th>Product Name</th>
        <th>Category</th>
        <th>Product Price</th>
        <th>Product Description</th>
        <th>Actions</th>
    </tr>
    <%for (Product product : products) {%>
    <tr>
        <td><%=product.getId()%></td>
        <td><%=product.getProductName()%></td>
        <td><%=product.getCategory()%></td>
        <td><%=product.getProductPrice()%></td>
        <td class="product_description"><%=product.getProductDescription()%></td>
        <td><a href="<%=application.getContextPath()%>/update-product?id=<%=product.getId()%>" class="btn btn-warning">Update</a><a href="<%=application.getContextPath()%>/delete-product?id=<%=product.getId()%>" class="btn btn-danger">Delete</a></td>
    </tr>
    <%}%>
</table>
<%} else {%>
<h1>No records.</h1>
<%}%>
<jsp:include page="../includes/footer.jsp" />