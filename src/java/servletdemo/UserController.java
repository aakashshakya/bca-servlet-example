/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servletdemo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Aakash
 */
public class UserController implements Servlet {
    
    @Override
    public void init(ServletConfig arg0) throws ServletException {
        System.out.println("User Controller:: Inside init method");
    }
    
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("User Controller:: Inside service method");
        String name = request.getParameter("name");
        PrintWriter writer = response.getWriter();
        writer.write("<h1>Welcome " + name + "</h1>");
    }
    
    @Override
    public String getServletInfo() {
        return null;
    }
    
    @Override
    public void destroy() {
        System.out.println("User Controller:: Inside destroy method");
    }
    
}
