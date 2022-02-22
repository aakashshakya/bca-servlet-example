/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servletwithhttpservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aakash
 */
public class GeneralFormProcessController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        validateName(name);
        PrintWriter writer = response.getWriter();
        writer.write("Welcome to the website " + name);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        double percentage = Double.parseDouble(request.getParameter("percentage"));
            
        validateName(name);
        
        PrintWriter writer = response.getWriter();       

        if (percentage < 40) {
            writer.write("Sorry " + name + ", you have failed.");
        } else if (percentage >= 40 && percentage <= 79.99) {
            writer.write("Congratulations " + name + ", you have passed with first division.");
        } else if (percentage >= 80 && percentage <= 100) {
            writer.write("Congratulations " + name + ", you have passed with distinction.");
        } else {
            throw new IOException("Invalid Percentage.");
        }
    }
    
    private void validateName(String name) throws IOException {
        if (name.equals("")) {
            throw new IOException("Name cannot be empty.");
        }
    }
}
