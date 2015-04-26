/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.lab2;

import domain.SystemUser;
import domain.UserType;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repositories.impl.DummyDB;

/**
 *
 * @author lesergd
 */
@WebServlet(name = "allUsers", urlPatterns = {"/allUsers"})
public class allUsers extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void init() throws ServletException {
        super.init();
        if (getServletContext().getAttribute("db") == null) {
            DummyDB ddb = new DummyDB();

            ServletContext sc = getServletContext();
            sc.setAttribute("db", ddb);

            SystemUser admin = new SystemUser("admin", "admin", UserType.Admin, null, null, null);
            SystemUser premium = new SystemUser("premium", "premium", UserType.Premium, null, null, null);
            SystemUser regular = new SystemUser("regular", "regular", UserType.Regular, null, null, null);
            
            ddb.systemUsers.add(admin);
            ddb.systemUsers.add(premium);
            ddb.systemUsers.add(regular);

            System.out.println("Initialise DB");
        } else {
            System.out.println("DB initialised earlier. Retriving from ServletContext");
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        DummyDB ddb = (DummyDB) getServletContext().getAttribute("db");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet allUsers</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<font color=\"green\">* Green when \"Premium\" user.</font><br>"
                    + "<font color=\"red\">* Red when \"Admin\" user.</font><br><br>");
            out.println("<table border=\"1\" style=\"width:100%\">");
            out.println("<tr><td>Login</td><td>e-Mail</td><td>Type</td></tr>");

            for (SystemUser su : ddb.systemUsers) {
                if (su.getUserType().toString().equals("Admin")) {
                    out.println("<tr bgcolor=\"red\"><td><a href=userProfile?login="+ su.getLogin() +">" + su.getLogin() + "</td><td>" 
                            + su.getEmail() + "</td><td>" + su.getUserType() + "</td></tr>");
                } else if (su.getUserType().toString().equals("Premium")) {
                    out.println("<tr bgcolor=\"green\"><td><a href=userProfile?login="+ su.getLogin() +">" + su.getLogin() + "</td><td>" 
                            + su.getEmail() + "</td><td>" + su.getUserType() + "</td></tr>");
                } else {
                    out.println("<tr><td><a href=userProfile?login="+ su.getLogin() +">" + su.getLogin() + "</td><td>" 
                            + su.getEmail() + "</td><td>" + su.getUserType() + "</td></tr>");
                }
            }

            out.println("</table>");
            out.println("Number of users in DB: " + ddb.systemUsers.size());
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
