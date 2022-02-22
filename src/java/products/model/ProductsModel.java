/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package products.model;

import configuration.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import products.Product;
import shared.DatabaseMethods;

/**
 *
 * @author Aakash
 */
public class ProductsModel {

    private final String tableName = "tbl_products";

    Database database;

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {
            database = new Database(tableName);
            ResultSet results = database.getRecords();
            while (results.next()) {
                Product product = new Product();
                product.setId(results.getInt("id"));
                product.setProductName(results.getString("product_name"));
                product.setCategory(results.getString("category"));
                product.setProductPrice(results.getDouble("product_price"));
                product.setProductDescription(results.getString("product_description"));
                product.setImagePath(results.getString("image_path"));
                product.setStatus(results.getBoolean("status"));
                products.add(product);
            }
            return products;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error occurred: " + ex.getMessage());
        } finally {
            try {
                database.closeConnection();
            } catch (SQLException ex) {
                
            }
        }
        return products;
    }

    public Product getById(int id) {
        try {
            database = new Database(tableName);
            ResultSet result = database.getRecordById(id);
            while (result.next()) {
                Product product = new Product();
                product.setId(result.getInt("id"));
                product.setProductName(result.getString("product_name"));
                product.setCategory(result.getString("category"));
                product.setProductPrice(result.getDouble("product_price"));
                product.setProductDescription(result.getString("product_description"));
                product.setImagePath(result.getString("image_path"));
                product.setStatus(result.getBoolean("status"));
                return product;
            }

        } catch (SQLException ex) {
            
        } catch (ClassNotFoundException ex) {
            
        } finally {
            try {
                database.closeConnection();
            } catch (SQLException ex) {
                
            }
        }
        return null;
    }

    public void insert(Product product) throws SQLException {
        try {
            database = new Database(tableName);
            boolean isInserted = database.insertRecord(product);
            if (isInserted) {
                System.out.println("Record inserted");
            } else {
                System.out.println("Error occured.");
            }
        } catch (SQLException ex) {
            
        } catch (ClassNotFoundException ex) {
            
        } finally {
            database.closeConnection();
        }
    }

    public void update(int id, Product product) {
        try {
            database = new Database(tableName);
            database.updateRecord(id, product);
        } catch (SQLException ex) {
            
        } catch (ClassNotFoundException ex) {
            
        }
        
    }

    public void delete(int id) throws SQLException {
        try {
            database = new Database(tableName);
            database.deleteRecord(id);
        } catch (SQLException ex) {
            
        } catch (ClassNotFoundException ex) {
            
        } finally {
            database.closeConnection();
        }
    }

}
