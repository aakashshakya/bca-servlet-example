<%-- 
    Document   : update-product
    Created on : Feb 22, 2022, 11:48:25 AM
    Author     : Aakash
--%>

<%@page import="products.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="../includes/header.jsp" />
<%
    Product product = (Product) request.getAttribute("product");
%>
        <h2>Update <%=product.getProductName()%></h2>
        <form method="POST" action="<%=application.getContextPath()%>/update-product">
            <input type="hidden" value="<%=product.getId()%>" name="product_id"> 
            <input type="text" placeholder="Enter your product name" name="product_name" required value="<%=product.getProductName()%>"><br>
            <select name="category">
                <option <%=product.getCategory().equals("Electronics")?"selected":""%>>Electronics</option>
                <option <%=product.getCategory().equals("Automobiles")?"selected":""%>>Automobiles</option>
                <option <%=product.getCategory().equals("Food and beverages")?"selected":""%>>Food and beverages</option>
                <option <%=product.getCategory().equals("Clothing")?"selected":""%>>Clothing</option>
            </select><br>
            <input type="text" placeholder="Enter the product price" name="product_price" required value="<%=product.getProductPrice()%>"><br>
            <textarea name="product_description" cols="30" rows="10" placeholder="Enter product description"><%=product.getProductDescription()%></textarea><br>
            <input type="submit" value="Update product" /> <a href="products.jsp">Cancel</a>
        </form>

<jsp:include page="../includes/footer.jsp" />