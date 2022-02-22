/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servletwithhttpservlet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aakash
 */
public class StudentController extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fullName = request.getParameter("full_name");
        String address = request.getParameter("address");
        String contactNumber = request.getParameter("contact_number");
        String collegeName = request.getParameter("college_name");
        String percentage = request.getParameter("percentage");
        String dob = request.getParameter("dob");

        if (fullName.equals("") || address.equals("")
                || contactNumber.equals("") || collegeName.equals("")
                || percentage.equals("") || dob.equals("")) {
            throw new IOException("The required fields cannot be empty!!");
        }

        String message = "The student name is " + fullName + ", address is "
                + address + ", contact number is " + contactNumber + ", college name is "
                + collegeName + ", +2 percentage is " + percentage + " and date of birth is "
                + dob + ".\n";

        PrintWriter printWriter = response.getWriter();
        File file = new File("C:\\Users\\hp\\OneDrive\\Documents\\NetBeansProjects\\JAVA_SERVLET_BCA_2075\\students-info.txt");
        if (!file.exists()) {
            FileWriter writer = new FileWriter(file, true);
            writer.append(message);
            writer.close();
            printWriter.write("New file created and content added successfully.");
        } else {
            file.createNewFile();
            FileWriter writer = new FileWriter(file, true);
            writer.append(message);
            writer.close();
            printWriter.write("Content appended to the existing file successfully.");
        }
    }
}
