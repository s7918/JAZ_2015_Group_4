/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jaz.jazlab1.User;

/**
 *
 * @author Leszek Karwacki<s7918@pjwstk.edu.pl>
 */
@WebServlet(name = "registerUser", urlPatterns = {"/registerUser"})
public class registerUser extends HttpServlet {

    ArrayList<User> users = new ArrayList<User>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter toPage = response.getWriter();
        toPage.println("<h3>Z metody doGet.</h3>");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {       
               
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String mail = request.getParameter("mail");
        String employer = request.getParameter("employer");
        String knowledge = request.getParameter("konowledge");
        String professoin = request.getParameter("profession");
        
        response.setContentType("text/html");
        PrintWriter toPage = response.getWriter();

        User u = new User(firstName, lastName, mail, employer, knowledge, professoin);

        HttpSession session = request.getSession();
            
        if (users.size()>=5) {
            response.sendRedirect("limitReached.html");
        } else {
            if (session.getAttribute("mail") ==null || session.getAttribute("mail").equals("")) {
                session.setAttribute("mail", mail);
                users.add(u);
                toPage.println("Użytkownik " + firstName + " " + lastName + " został zarejestrowany.");
                System.out.println("pusty sesyjny mail. Ile zarejestrowanych:" + users.size()+ session.getAttribute("mail"));
        
            } else if (session.getAttribute("mail").toString() != mail) {
                users.add(u);
                toPage.println("Użytkownik " + firstName + " " + lastName + " został zarejestrowany.");
                System.out.println("różny sesyjny mailIle zarejestrowanych:" + users.size()+ session.getAttribute("mail")+mail);
        
            } else {
                response.sendRedirect("sessionLimit.html");
            }
        }

    }
}
