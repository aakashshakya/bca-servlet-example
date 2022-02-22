/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import products.Product;

/**
 *
 * @author Aakash
 */
public class Database {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private String url = "jdbc:mysql://localhost:3306/ecommerce";
    private String username = "root";
    private String password = "";
    private String tableName;
    private String sql;

    public Database(String tableName) throws SQLException, ClassNotFoundException {
        this.tableName = tableName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean insertRecord(Object object) throws SQLException {
        if (tableName.equals("tbl_products")) {
            Product product = (Product) object;
            sql = "Insert into " + tableName + " (product_name, category, product_price, product_description) "
                    + "values (?,?,?,?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getCategory());
            preparedStatement.setDouble(3, product.getProductPrice());
            preparedStatement.setString(4, product.getProductDescription());
            return preparedStatement.execute();
        }
        return false;
    }

    public ResultSet getRecords() throws SQLException {
        sql = "Select * from " + this.tableName;
        System.out.println(sql);
        preparedStatement = connection.prepareStatement(sql);
        return preparedStatement.executeQuery();
    }

    public ResultSet getRecordById(int id) throws SQLException {
        sql = "Select * from " + this.tableName + " where id = ?";
        System.out.println(sql);
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeQuery();
    }

    public void updateRecord(int id, Object data) throws SQLException {
        if (tableName.equals("tbl_products")) {
            Product product = (Product) data;
            sql = "Update " + tableName + " SET product_name = ?, category=?,"
                    + " product_price=?, product_description = ? WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getCategory());
            preparedStatement.setDouble(3, product.getProductPrice());
            preparedStatement.setString(4, product.getProductDescription());
            preparedStatement.setInt(5, id);
            preparedStatement.execute();
        }
    }
    
    public void deleteRecord(int id) throws SQLException {
        sql = "Delete from " + tableName + " where id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

}
