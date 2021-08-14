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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rkavi
 */
@WebServlet(name = "Stats", urlPatterns = {"/Stats"})
public class Stats extends HttpServlet {

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
"table{\n" +
"  width:100%;\n" +
"  table-layout: fixed;\n" +
"     font-family: 'Open Sans';\n" +
"   font-style: normal;\n" +
"   font-weight: 200;\n" +
"    font-size: 20px;\n" +
"}\n" +
".tbl-header{\n" +
"  background-color: rgba(255,255,255,0.3);\n" +
" }\n" +
".tbl-content{\n" +
"  height:300px;\n" +
"  overflow-x:auto;\n" +
"  margin-top: 0px;\n" +
"  border: 1px solid rgba(255,255,255,0.3);\n" +
"}\n" +
"th{\n" +
"  padding: 20px 15px;\n" +
"  text-align: left;\n" +
"  font-weight: 500;\n" +
"  font-size: 12px;\n" +
"  color: #fff;\n" +
"  text-transform: uppercase;\n" +
"    text-align: center;\n" +
"}\n" +
"td{\n" +
"  padding: 15px;\n" +
"  text-align: left;\n" +
"  vertical-align:middle;\n" +
"  font-weight: 300;\n" +
"  font-size: 12px;\n" +
"  color: #fff;\n" +
"  border-bottom: solid 1px rgba(255,255,255,0.1);\n" +
"    text-align: center;\n" +
"}\n" +
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
"  <source src=\"assets/back4.mp4\" type=\"video/mp4\">\n" +
"</video>\n" +
"                \n" +
"        <div class=\"content\">\n" +
"            <center>\n" +
"                <br><br><br>\n" +
"                <h2 style=\"\n" +
"    font-family: 'Open Sans Light';\n" +
"   font-style: normal;\n" +
"   font-weight: 300;\n" +
"    font-size: 25px;\n" +
"    color: aliceblue;\">Marino</h2><br><br><br><br>\n" +
"            <table style=\"width:80%\">\n" +
"  <tr>\n" +
"    <th>Reservation ID</th>\n" +
"    <th>Name</th>\n" +
"    <th>Email</th>\n" +
"      <th>Telephone</th>\n" +
"    <th>Check In</th>\n" +
"    <th>Check Out</th>\n" +
"  </tr>\n");
             String hid = request.getParameter("id");
               HttpSession session = request.getSession();
               session.setAttribute("hotid", hid);
    String driver = "com.mysql.jdbc.Driver"; 
        String url = "jdbc:mysql://localhost/oop"; 
        String uid = "root"; 
        String psw = ""; 
        Connection con=null; 
        PreparedStatement ps = null; 
        ResultSet rs; 
         try  
         { 
           Class.forName(driver); 
           con = DriverManager.getConnection(url,uid,psw); 
           ps=con.prepareStatement("SELECT * FROM reservations WHERE h_id = '" + session.getAttribute("hotid") + "'"); 
           rs = ps.executeQuery(); 

 while(rs.next()) 
             { 
               String rid = rs.getString("r_id"); 
               String name = rs.getString("name"); 
               String email = rs.getString("email"); 
               String tp = rs.getString("tp"); 
               String cin = rs.getString("checkin"); 
               String cout = rs.getString("checkout"); 
               
               out.println( " <tr>\n" +
"    <td>"+ rid +"</td>\n" +
"    <td>"+ name +"</td>\n" +
"    <td>"+ email +"</td>\n" +
"      <td>"+ tp +"</td>\n" +
"    <td>"+ cin +"</td>\n" +
"    <td>"+ cout +"</td>\n" +
          " <form method=\"post\" action=\"./delete\">"+
         " <input type=\"hidden\" id=\"id\" name=\"id\" placeholder=\"id\" value=\""+ rid +"\"/>" +
        "    <td><button  style=\"width: 100%;\" class=\"button\" type=\"submit\" value=\"Login\" name=\"but_submit\" id=\"but_submit\"> <span>Delete</span> </button> </form></td>\n" +
"  </tr>\n");
               
                    }         
               
                 }       
                   catch(Exception e)   
                               {  
                                 e.printStackTrace();  
                               } 


out.println( "</table>\n" +
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
