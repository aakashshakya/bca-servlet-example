/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package products;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import products.model.ProductsModel;

/**
 *
 * @author Aakash
 */
public class ProductUpdate extends HttpServlet {
    private ProductsModel productModel = new ProductsModel();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productModel.getById(id);
        request.setAttribute("product", product);
        request.getRequestDispatcher("/products/update-product.jsp")
                .forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int productId = Integer.parseInt(request.getParameter("product_id"));
        String productName = request.getParameter("product_name");
        String productPrice = request.getParameter("product_price");
        String category = request.getParameter("category");
        String productDescription = request.getParameter("product_description");
        
        Product product = new Product();
        
        product.setProductName(productName);
        product.setProductPrice(Double.parseDouble(productPrice));
        product.setCategory(category);
        product.setProductDescription(productDescription);
        productModel.update(productId, product);
        
        response.sendRedirect(request.getContextPath() + "/products");
    }
}
