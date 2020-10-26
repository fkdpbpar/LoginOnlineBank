 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.UserLogin;

/**
 *
 * @author mac
 */
public class Login extends HttpServlet {
    private UserLogin userLogin = new UserLogin("admin", "admin");

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
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
        
        String s = "<h1>Welcome to Online Bank!</h1>\n" +
"        <form action=\"login\" method=\"POST\">\n" +
"            <p>Username : <input type=\"text\" name=\"username\"></p>\n" +
"            <p>Password : <input type=\"password\" name=\"password\"></p>\n" +
"            <p><button type=\"submit\">Login</button>\n" +
"        </form>";
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
//            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
            out.print(s);
            out.println("</body>");
            out.println("</html>");
        }
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login Security Check</title>");            
            out.println("</head>");
            out.println("<body>");
//            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
            UserLogin ul = new UserLogin(request.getParameter("username"),request.getParameter("password"));
            if(ul.equals(userLogin)) {
                // do something
                String path = "WEB-INF/views/privatebanking.jsp";
                LocalDateTime dt = LocalDateTime.now();
                out.print("user = " + request.getAttribute("user"));
                request.setAttribute("login_datetime", dt);
                request.setAttribute("user_role", "SuperAdmin");
                request.setAttribute("ul", ul);
                out.print("ul = " + request.getAttribute("ul"));
                RequestDispatcher rd = request.getRequestDispatcher(path);
//                rd.forward(request, response);
                out.println("All good!!!");
            } else
            {
                out.println("Unauthorized access!!!");
            }
            out.println("</body>");
            out.println("</html>");
        }
        
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
