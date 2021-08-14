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
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rkavi
 */
@WebServlet(name = "Dash", urlPatterns = {"/Dash"})
public class Dash extends HttpServlet {

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
            String time = null;
            Calendar c = Calendar.getInstance();
int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

if(timeOfDay >= 0 && timeOfDay < 12){
    time = "Good Morning";        
}else if(timeOfDay >= 12 && timeOfDay < 16){
    time = "Good Afternoon";
}else if(timeOfDay >= 16 && timeOfDay < 21){
    time = "Good Evening";
}else if(timeOfDay >= 21 && timeOfDay < 24){
    time = "Good Night";
}

          HttpSession session = request.getSession();
            String id = (String) session.getAttribute("user");
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>\n" +
"<html lang=\"en\" >\n" +
"<head>\n" +
"  <meta charset=\"UTF-8\">\n" +
"  <title>CodePen - How to Build a Filterable Thumbnail Layout with CSS Grid, Flexbox and JavaScript</title>\n" +
"  <link rel=\"stylesheet\" href=\"result/style.css\">\n" +
"    <link rel=\"stylesheet\" href=\"style.css\">\n" +
"\n" +
"</head>\n" +
"<body>\n" +
"              <video autoplay muted loop id=\"myVideo\">\n" +
"  <source src=\"assets/back2.mp4\" type=\"video/mp4\">\n" +
"</video>\n" +
"      <div class=\"content\"><br><br>\n" +
"     <img src=\"assets/logo.png\" style=\"padding-left: 160px;\" width=\"180\" alt=\"logo\">\n" +
"          <br><br>\n" +
"       \n" +
"<!-- partial:index.partial.html -->\n" +
"<section class=\"gallery\">\n" +
"  <div class=\"container\">\n" +
"    <div class=\"toolbar\">\n" +
"      <h2 style=\"padding-top: 60px;\">"+ time +" " + session.getAttribute("name") +"</h2> <br>\n" +
"        <button style=\"width: 20%;\" class=\"button\" type=\"submit\" value=\"Login\" name=\"but_submit\" id=\"but_submit\"> <a href=\"./New\"> <span>New Hotel</span> </a> </button>\n" +
"  \n" +
"    </div>\n" +
"    <ol class=\"image-list grid-view\">\n");
 String driver = "com.mysql.jdbc.Driver"; 
        String url = "jdbc:mysql://localhost/oop"; 
        String uid = "root"; 
        String psw = ""; 
        Connection con=null; 
        PreparedStatement ps = null; 
        ResultSet rs; 
        System.out.print(id);
         try  
         { 
           Class.forName(driver); 
           con = DriverManager.getConnection(url,uid,psw); 
           ps=con.prepareStatement("SELECT * FROM manager "
                   + "INNER JOIN hotels ON manager.mngr_id = hotels.mngr_id "
                   + "INNER JOIN h_images ON h_images.h_id = hotels.h_id"
                   + " WHERE manager.mngr_id = '" + id + "'"); 
           rs = ps.executeQuery(); 

 while(rs.next()) 
             { 
                 String hid = rs.getString("h_id"); 
               String nm = rs.getString("thumb"); 
               String ttl = rs.getString("h_name"); 
               String des = rs.getString("h_slogan");
               
               out.println("      <li>\n" +
"        <figure>\n" +
"          <img src=\""+ nm +"\" alt=\"\">\n" +
"          <figcaption>\n" +
"            <p>"+ ttl +"</p>\n" +
"            <p>"+ des +"</p>\n" +
"          </figcaption>\n" +
        "           <center>"
        + " <form method=\"post\" action=\"./Stats\">"
        + " <input type=\"hidden\" id=\"id\" name=\"id\" placeholder=\"id\" value=\""+ hid +"\"/>"
        + "     <button  style=\"width: 50%;\" class=\"button\" type=\"submit\" value=\"Login\" name=\"but_submit\" id=\"but_submit\"> <span>View Stats</span> </button></form> </center>\n" +
"        </figure>\n" +
"      </li>\n");
               
               }         
               
                 }       
                   catch(Exception e)   
                               {  
                                 e.printStackTrace();  
                               } 
out.print("     \n" +
"    </ol>\n" +
"  </div>\n" +
"</section>\n" +
"\n" +
"\n" +
"<!-- partial -->\n" +
"  <script  src=\"./script.js\"></script>\n" +
"    </div>\n" +
"</body>\n" +
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
