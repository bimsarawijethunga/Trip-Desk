/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package owner;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author rkavi
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
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
        try (PrintWriter out = response.getWriter()) {
            String inv = "";
             String usr_id = request.getParameter("uname");
            String pass = request.getParameter("pass");
            
              try {  	 
			 Class.forName("com.mysql.jdbc.Driver");
     			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost/oop", "root", "");
     			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery("SELECT mngr_id,pass,name FROM manager");
          		 while (rs.next()) 

	         {       String unam = rs.getString("mngr_id");
                  	 String paw = rs.getString("pass");
                         String nm = rs.getString("name");
			
                       String  una = usr_id;
                       String  pwa = pass;
                         
                           if( una.equals(unam) && pwa.equals(paw)){
    
                        
                        HttpSession session = request.getSession();
                        session.setAttribute("user", String.valueOf(una));
                        session.setAttribute("name", String.valueOf(nm));
                        
                        
                       response.sendRedirect("http://localhost:8080/oop/Dash");  
                          
    }                          
                        
			else{
                         inv = "Invalid Username/Password";
			  }
                    
                         }

                         stmt.close();
     			 con.close();
    } catch (Exception event) {
      System.out.println(event);
    }	
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>\n" +
"\n" +
"    <head>\n" +
"          <link rel=\"stylesheet\" href=\"style.css\">\n" +
"        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
"         <title>Dashboard</title>\n" +
"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css\">\n" +
"<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Playfair+Display:700|Raleway:500.700'>\n" +
"        <script type=\"text/javascript\" src=\"../js/script.js\"></script>\n" +
"       \n" +
"\n" +
"  <style>\n" +
"\n" +
"/*the container must be positioned relative:*/\n" +
".autocomplete {\n" +
"  position: relative;\n" +
"  display: inline-block;\n" +
"   \n" +
"    width: 100%;\n" +
"}\n" +
"\n" +
"\n" +
".autocomplete-items {\n" +
"  position: absolute;\n" +
" \n" +
"  background: rgba(00, 00, 00, 0.00);\n" +
"\n" +
"  z-index: 99;\n" +
"  /*position the autocomplete items to be the same width as the container:*/\n" +
"  top: 100%;\n" +
"  left: 0;\n" +
"  right: 0;\n" +
"}\n" +
"\n" +
".autocomplete-items div {\n" +
"  padding: 10px;\n" +
"  cursor: pointer;\n" +
"  background: rgba(00, 00, 00, 0.8);\n" +
"  border: 1px solid #F7AF02; \n" +
"    font-family: 'Open Sans';\n" +
"   font-style: normal;\n" +
"   font-weight: 200;\n" +
"    font-size: 20px;\n" +
"     border-radius: 50px;\n" +
"}\n" +
"\n" +
"/*when hovering an item:*/\n" +
".autocomplete-items div:hover {\n" +
"  background-color: #F7AF02; \n" +
"}\n" +
"\n" +
"/*when navigating through the items using the arrow keys:*/\n" +
".autocomplete-active {\n" +
"  background-color: #F7AF02 !important; \n" +
"  color: #ffffff; \n" +
"}\n" +
"</style>\n" +
"    </head>\n" +
"    <body>\n" +
"        \n" +
"             <video autoplay muted loop id=\"myVideo\">\n" +
"  <source src=\"assets/back2.mp4\" type=\"video/mp4\">\n" +
"</video>\n" +
"        \n" +
"                \n" +
"        <div class=\"content\">\n" +
"            <center>\n" +
"                <br>\n" +
"              <img src=\"assets/logo.png\" width=\"180\" alt=\"logo\">\n" +
"            <form method=\"post\" action=\"./Login\"> <br><br><br><br><br><br><br><br><br>\n" +
"                <h1 style=\"\n" +
"    font-family: 'Open Sans Light';\n" +
"   font-style: normal;\n" +
"   font-weight: 300;\n" +
"    font-size: 25px;\n" +
"    color: aliceblue;\">Owner's Login</h1><br><br>\n" +
"                <input style=\"width: 30%;\" type=\"text\" class=\"inputs\" id=\"uname\" name=\"uname\" placeholder=\"User ID\" /> <br>\n" +
"                <input style=\"width: 30%;\" type=\"password\" class=\"inputs\" id=\"pass\" name=\"pass\" placeholder=\"Password\" />\n" +
"                <br>\n" +
"                <p id=\"inv\">"+ inv +"</p>\n" +
"                <br>\n" +
"                 <button style=\"width: 20%;\" class=\"button\" type=\"submit\" value=\"Login\" name=\"but_submit\" id=\"but_submit\"> <span>Login</span> </button>\n" +
"            \n" +
"            </form>\n" +
"                </center>\n" +
"        </div>\n" +
"        \n" +
"    </body>\n" +
"</html>");
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
