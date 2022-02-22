/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servletwithhttpservlet;

import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aakash
 */
public class CookieExample extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie cookie = new Cookie("full_name", request.getParameter("name"));
        Cookie secondCookie = new Cookie("address", request.getParameter("address"));
        cookie.setMaxAge(100);
        secondCookie.setMaxAge(100);
        response.addCookie(cookie);
        response.addCookie(secondCookie);
        response.getWriter().write("Cookie added successfully.");
    }

}
