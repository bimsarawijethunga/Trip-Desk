/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package owner;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rkavi
 */
@WebServlet(name = "New", urlPatterns = {"/New"})
public class New extends HttpServlet {

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
            int h_idd;
            int h_id = 0;
            
            try {
                        com.mysql.jdbc.Connection con;
                        ResultSet rs;
                        
                        Class.forName("com.mysql.jdbc.Driver");
                        con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/oop", "root", "");

                PreparedStatement ps = con.prepareStatement("SELECT MAX(h_id) AS h_id FROM hotels"); 
           rs = ps.executeQuery(); 
            while(rs.next()) 
             { 
                h_idd = rs.getInt("h_id"); 
                h_id = h_idd + 1;
               
              
                      
             }
             } catch (ClassNotFoundException | SQLException en) {
                        System.err.println("Got an exception!");
                        System.err.println(en.getMessage());
                    }
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
"  <style>\n"
                      + "textarea {\n" +
"     font-family: 'Open Sans';\n" +
"   font-style: normal;\n" +
"   font-weight: 200;\n" +
"    font-size: 20px;\n" +
" \n" +
"  padding: 12px 20px;\n" +
"  margin: 8px 0;\n" +
"  box-sizing: border-box;\n" +
"  border: 2px solid #fff;\n" +
"  -webkit-transition: 0.5s;\n" +
"  transition: 0.5s;\n" +
"  outline: none;\n" +
"    color: #fff;\n" +
"    background-color: rgba(00, 00, 00, 0.3);\n" +
"    border-radius: 50px;\n" +
"}\n" +
"\n" +
"textarea:focus {\n" +
"  border: 3px solid #F7AF02;\n" +
"}" +
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
"            <form method=\"post\" action=\"./UploadServlet\" enctype=\"multipart/form-data\"> <br><br><br><br><br>\n" +
"                <h1 style=\"\n" +
"    font-family: 'Open Sans Light';\n" +
"   font-style: normal;\n" +
"   font-weight: 300;\n" +
"    font-size: 35px;\n" +
"    color: aliceblue;\">New Hotel</h1><br><br>\n" +
"                <input style=\"width: 10%;\" type=\"text\" class=\"inputs\" id=\"hid\" name=\"hid\" placeholder=\"Hotel ID\" value=\""+ h_id +"\"/> <br>\n" +
"                <input style=\"width: 30%;\" type=\"text\" class=\"inputs\" id=\"name\" name=\"name\" placeholder=\"Name\" /><br>\n" +
"                <input style=\"width: 40%;\" type=\"text\" class=\"inputs\" id=\"slogan\" name=\"slogan\" placeholder=\"Slogan\" /><br>\n" +
"                <input style=\"width: 20%;\" type=\"text\" class=\"inputs\" id=\"location\" name=\"location\" placeholder=\"Location\" />\n" +
"                <input style=\"width: 20%;\" type=\"text\" class=\"inputs\" id=\"tp\" name=\"tp\" placeholder=\"Phone\" /> <br>\n"
                      + "<textarea id=\"des1\" name=\"des1\" rows=\"4\" placeholder=\"Description 1\" cols=\"50\"></textarea> <br>" +  
                      "<textarea id=\"des2\" name=\"des2\" rows=\"4\" placeholder=\"Description 2\" cols=\"50\"></textarea> <br>" +
                      "<textarea id=\"des3\" name=\"des3\" rows=\"4\" placeholder=\"Description 2\" cols=\"50\"></textarea> <br><br><br><br><br>" +
                      "                <h1 style=\"\n" +
"    font-family: 'Open Sans Light';\n" +
"   font-style: normal;\n" +
"   font-weight: 300;\n" +
"    font-size: 25px;\n" +
"    color: aliceblue;\">Thumbnail</h1><br><br>\n" +
                      "                <input style=\"width: 40%;\" type=\"file\" class=\"inputs\" id=\"img1\" name=\"img1\" placeholder=\"Thumbnail\" /> <br>\n" +
                      "                <h1 style=\"\n" +
"    font-family: 'Open Sans Light';\n" +
"   font-style: normal;\n" +
"   font-weight: 300;\n" +
"    font-size: 25px;\n" +
"    color: aliceblue;\">Image 01</h1><br><br>\n" +
                      "                <input style=\"width: 40%;\" type=\"file\" class=\"inputs\" id=\"img2\" name=\"img2\" placeholder=\"Thumbnail\" /> <br>\n" +
                      "                <h1 style=\"\n" +
"    font-family: 'Open Sans Light';\n" +
"   font-style: normal;\n" +
"   font-weight: 300;\n" +
"    font-size: 25px;\n" +
"    color: aliceblue;\">Image 02</h1><br><br>\n" +
                      "                <input style=\"width: 40%;\" type=\"file\" class=\"inputs\" id=\"img3\" name=\"img3\" placeholder=\"Thumbnail\" /> <br>\n" +
"                <br>\n" +
"                <p id=\"inv\"></p>\n" +
"                <br>\n" +
"                 <button style=\"width: 20%;\" class=\"button\" type=\"submit\" value=\"Submit\" name=\"but_submit\" id=\"but_submit\"> <span>Submit</span> </button>\n" +
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
