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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rkavi
 */
@WebServlet(urlPatterns = {"/Result"})
public class Result extends HttpServlet {
    
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String dest = request.getParameter("txt_uname");
            String inn = request.getParameter("checkin");
            
            String outt = request.getParameter("checkout");
            System.out.print(dest);
            System.out.print(inn);
            System.out.print(outt);
            /* TODO output your page here. You may use following sample code. */
           
            out.println("<!DOCTYPE html>\n" +
"<html lang=\"en\" >\n" +
"<head>\n" +
"  <meta charset=\"UTF-8\">\n" +
"  <title>Best Hotels in "+ dest +"</title>\n" +
"  <link rel=\"stylesheet\" href=\"style.css\">\n" +
"    <link rel=\"stylesheet\" href=\"result/style.css\">\n" +
"\n" +
"</head>\n" +
"<body>\n" +
"              <video autoplay muted loop id=\"myVideo\">\n" +
"  <source src=\"assets/back2.mp4\" type=\"video/mp4\">\n" +
"</video>\n" +
"      <div class=\"content\"><br><br>\n" +
"     <img src=\"assets/logo.png\" style=\"padding-left: 160px;\" width=\"180\" alt=\"logo\">\n" +
"          <br><br>\n" +
"            <div style=\"padding-left: 160px;\">\n" +
"                <p class=\"txtt\">Check In &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Check Out</p>\n" +
"            <input style=\"width: 20%;\" type=\"date\" placeholder=\"CheckIn\" value=\""+ inn +"\">\n" +
"                 <input style=\"width: 20%;\" type=\"date\" placeholder=\"CheckIn\" value=\""+ outt +"\">\n" +
"           </div>\n" +
"<!-- partial:index.partial.html -->\n" +
"<section class=\"gallery\">\n" +
"  <div class=\"container\">\n" +
"    <div class=\"toolbar\">\n" +
"      <h2 style=\"padding-top: 60px;\">Best Hotels in "+ dest +"</h2>\n" +
"      <ul class=\"view-options\">\n" +
"        <li class=\"zoom\">\n" +
"          <input type=\"range\" min=\"180\" max=\"380\" value=\"280\">\n" +
"        </li>\n" +
"        <li class=\"show-grid active\">\n" +
"          <button disabled>\n" +
"            <img src=\"https://s3-us-west-2.amazonaws.com/s.cdpn.io/162656/grid-view.svg\" alt=\"grid view\">  \n" +
"          </button>\n" +
"        </li>\n" +
"        <li class=\"show-list\">\n" +
"          <button>\n" +
"            <img src=\"https://s3-us-west-2.amazonaws.com/s.cdpn.io/162656/list-view.svg\" alt=\"list view\">  \n" +
"          </button>\n" +
"        </li>\n" +
"      </ul>\n" +
"    </div>\n" +
"    <ol class=\"image-list grid-view\">\n");
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
           ps=con.prepareStatement("SELECT * FROM hotels INNER JOIN h_images ON hotels.h_id = h_images.h_id WHERE hotels.location = '" + dest + "'"); 
           rs = ps.executeQuery(); 

 while(rs.next()) 
             { 
                 String id = rs.getString("h_id"); 
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
        + " <form method=\"post\" action=\"./View\">"
        + " <input type=\"hidden\" id=\"id\" name=\"id\" placeholder=\"id\" value=\""+ id +"\"/>"
        + "     <button  style=\"width: 50%;\" class=\"button\" type=\"submit\" value=\"Login\" name=\"but_submit\" id=\"but_submit\"> <span>View</span> </button></form> </center>\n" +
"        </figure>\n" +
"      </li>\n");
               
               }         
               
                 }       
                   catch(Exception e)   
                               {  
                                 e.printStackTrace();  
                               } 


out.println("     \n" +
"    </ol>\n" +
"  </div>\n" +
"</section>\n" +
"\n" +
"\n" +
"<!-- partial -->\n" +
"  <script  src=\"./script.js\"></script>\n" +
"    </div>\n" +
"</body>\n" +
"</html>\n" +
"");
 
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

