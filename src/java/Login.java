/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author WaAd_
 */
public class Login extends HttpServlet {

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

        try {
            PrintWriter out = response.getWriter();
            String name = request.getParameter("user");
            String password = request.getParameter("password");
            String dbUName = null;
            String dbPassword = null;
            String dbName = "portal";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String sql = "select * from registration where name=? and password=?";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dbUName = rs.getString(2);
                dbPassword = rs.getString("password");
            }
            if (name.equals(dbUName) && password.equals(dbPassword)) {
                out.println("<nav class=\"navbar navbar-expand-lg navbar-dark bg-primary\">\n"
                        + "  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarColor01\" aria-controls=\"navbarColor01\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
                        + "    <span class=\"navbar-toggler-icon\"></span>\n"
                        + "  </button>\n"
                        + "\n"
                        + "  <div class=\"collapse navbar-collapse\" id=\"navbarColor01\">\n"
                        + "    <ul class=\"navbar-nav mr-auto\">\n"
                        + "      <li class=\"nav-item active\">\n"
                        + "        <a class=\"nav-link\" href=\"Profile\">Profile <span class=\"sr-only\">(current)</span></a>\n"
                        + "      </li>\n"
                       
                        + "    </ul>\n"
                        + "    <form action=\"Logout\" class=\"form-inline my-2 my-lg-0\">\n"
                        + "      <button class=\"btn btn-secondary my-2 my-sm-0\" type=\"submit\">Logout</button>\n"
                        + "    </form>\n"
                        + "  </div>\n"
                        + "</nav>");
                out.println("<h1 class=\"display-4\">Welcome " + dbUName + "</h1>");
                HttpSession session = request.getSession();
                session.setAttribute("name", name);
            } else {
                //response.sendRedirect("login.jsp"); or can use request dispatcher
                out.println("<p class=\"lead\">Wrong username or password</p>");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.include(request, response);
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>"
                    + "<link href=\"https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sketchy/bootstrap.min.css\" rel=\"stylesheet\">\n"
                    + "        <link rel=\"stylesheet\" href=\"maincss.css\">"
                    + "");
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>incorrect username or password</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
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
