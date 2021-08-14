/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rkavi
 */
@WebServlet(urlPatterns = {"/Reservations"})
public class Reservations extends HttpServlet {

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
"    font-size: 35px;\n" +
"    color: aliceblue;\">Enter Your Reservation Number</h2><br><br> <br> <br>\n" +
"    <form method=\"post\" action=\"./Reservations_a\">\n" +
"        \n" +
"           \n" +
"          \n" +
"          \n" +
"            <input name=\"in\" id=\"in\" style=\"width: 40%;\" type=\"text\" placeholder=\"Reservation ID\">\n" +
"                 <br> <br> <br> <br>\n" +
"                <button class=\"button\" type=\"submit\" value=\"Login\" name=\"but_submit\" id=\"but_submit\"> <span>Show my Reservation</span> </button>\n" +
"    </form>\n" +
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
