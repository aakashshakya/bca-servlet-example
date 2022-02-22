/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servletwithhttpservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aakash
 */
public class StudentAddInfo extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fullName = request.getParameter("full_name");
        String address = request.getParameter("address");
        String contactNumber = request.getParameter("contact_number");
        String collegeName = request.getParameter("college_name");
        String faculty = request.getParameter("faculty");

        if (fullName.equals("") || address.equals("")
                || contactNumber.equals("") || collegeName.equals("")
                || faculty.equals("")) {
            throw new IOException("The required fields cannot be empty!!");
        }
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            PreparedStatement statement = null;

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "");

            String sql = "Insert into users (full_name, address, mobile_number, college, faculty) "
                    + "VALUES (?, ?, ?, ?, ?)";

            statement = conn.prepareStatement(sql);
            statement.setString(1, fullName);
            statement.setString(2, address);
            statement.setString(3, contactNumber);
            statement.setString(4, collegeName);
            statement.setString(5, faculty);

            int isUploaded = statement.executeUpdate();
            PrintWriter writer = response.getWriter();
            if (isUploaded == 1) {
                writer.write("Record added successfully.");
            } else {
                writer.write("Sorry couldn't add the record.");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

}
