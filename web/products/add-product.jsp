<%-- 
    Document   : add-product
    Created on : Feb 16, 2022, 11:48:25 AM
    Author     : Aakash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="../includes/header.jsp" />
        <h2>Please add information about the product</h2>
        <form method="POST" action="http://localhost:8080/JAVA_SERVLET_BCA_2075/products">
            <input type="text" placeholder="Enter your product name" name="product_name" required><br>
            <select name="category">
                <option>Electronics</option>
                <option>Automobiles</option>
                <option>Food and beverages</option>
                <option>Clothing</option>
            </select><br>
            <input type="text" placeholder="Enter the product price" name="product_price" required><br>
            <textarea name="product_description" cols="30" rows="10" placeholder="Enter product description"></textarea><br>
            <input type="submit" value="Save product" /> <a href="products.jsp">Cancel</a>
        </form>

<jsp:include page="../includes/footer.jsp" />