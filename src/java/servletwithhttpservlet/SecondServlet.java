/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servletwithhttpservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aakash
 */
public class SecondServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<String> names = new ArrayList<>();
        names.add("Aakash");
        names.add("Rashila");
        names.add("Lakpa");
        names.add("Ashesh");
        names.add("Sanam");
        names.add("Suja");
        names.add("Momik");
        
        String name = request.getParameter("name");
        PrintWriter writer = response.getWriter();
        if(name.equals("")) {
            writer.write("Invalid name");
        } else {
            for(String checker : names) {
                if(checker.equals(name)) {
                    if(name.equals("Aakash")) {
                        writer.write("He is a teacher.");
                    } else {
                        writer.write("He/she is a student.");
                    }
                }
            }
        }
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        
    }
    
}
