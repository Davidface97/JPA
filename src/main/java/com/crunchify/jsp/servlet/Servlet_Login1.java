package com.crunchify.jsp.servlet;

import edu.co.sergio.mundo.dao.Conexion;
import edu.co.sergio.mundo.dao.Fecha;

import edu.co.sergio.mundo.dao.ServiciosDAO;
import edu.co.sergio.mundo.dao.tx;
import edu.co.sergio.mundo.vo.User;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet_Login", urlPatterns = {"/Servlet_Login"})
public class Servlet_Login1 extends HttpServlet {

    Fecha date = new Fecha();

    ServiciosDAO service = new ServiciosDAO();
    tx generic = new tx();
    Conexion conexion = new Conexion(); 
    Connection connection = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, URISyntaxException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            //int UserId = Integer.parseInt(request.getParameter("IdLogin"));
            //String UserPass = request.getParameter("PassLogin");

            //connection = service.GenerarConexion();
            connection = conexion.getConnection();
            User usuario = new User();
            String nombre= request.getParameter("nombre");
            String apellido= request.getParameter("apellido");
            String telefono= request.getParameter("telefono");
            String celular= request.getParameter("celular");
             
             
            
            
           /* if (a == true) {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Servlet_Proyecto</title>");
                out.println("<meta http-equiv=" + "Refresh" + " content=" + "3;url=" + "indexMainMenu.html" + ">");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>Verificando Informacion, Serás dirigido automáticamente en cinco segundos al Login. En caso contrario, puedes acceder haciendo click <a href=" + "indexMainMenu.html" + ">aquí</a></p>");
                out.println("<p>" + date.getDate() + "</p>");
                out.println("<p>" + UserId + "</p>");
                out.println("<p>" + UserPass + "</p>");
                out.println("<p>" + a + "</p>");
                out.println("</body>");
                out.println("</html>");
            } else {

                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Servlet_Proyecto</title>");
                out.println("<meta http-equiv=" + "Refresh" + " content=" + "3;url=" + "index.html" + ">");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>Verificando Informacion, Serás dirigido automáticamente en cinco segundos al Login. En caso contrario, puedes acceder haciendo click <a href=" + "index.html" + ">aquí</a></p>");
                out.println("<p>" + date.getDate() + "</p>");
                out.println("<p>" + UserId + "</p>");
                out.println("<p>" + UserPass + "</p>");
                out.println("<p>" + a + "</p>");
                out.println("</body>");
                out.println("</html>");
            }
*/
        }catch(URISyntaxException ex){}
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                processRequest(request, response);
            } catch (URISyntaxException ex) {
                Logger.getLogger(Servlet_Login1.class.getName()).log(Level.SEVERE, null, ex);
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                processRequest(request, response);
            } catch (URISyntaxException ex) {
                Logger.getLogger(Servlet_Login1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
        
            () {
        return "Short description";
        }// </editor-fold>

    }
