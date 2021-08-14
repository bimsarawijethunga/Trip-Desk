
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rkavi
 */
@WebServlet(urlPatterns = {"/Check"})
public class Check extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String ttl = null; 
               String cin = null; 
               String sl = null; 
               String cout = null; 
               String name = null; 
               String email = null; 
               String tp = null; 
               String thumb = null; 
            
HttpSession session = request.getSession();
session.getAttribute("revid");
 System.out.print(session.getAttribute("revid")); 
 
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
           ps=con.prepareStatement("SELECT * FROM reservations"
                   + " INNER JOIN hotels ON reservations.h_id = hotels.h_id "
                   + "INNER JOIN h_images ON hotels.h_id = h_images.h_id "
                   + "WHERE reservations.r_id = '" + session.getAttribute("revid") + "'"); 
           rs = ps.executeQuery(); 

 while(rs.next()) 
             { 
                ttl = rs.getString("h_name"); 
                sl = rs.getString("h_slogan"); 
                cin = rs.getString("checkin"); 
                cout = rs.getString("checkout"); 
                name = rs.getString("name"); 
                email = rs.getString("email"); 
                tp = rs.getString("tp"); 
                thumb = rs.getString("thumb"); 
               
              
                      
             }         
               
                 }       
                   catch(Exception e)   
                               {  
                                 e.printStackTrace();  
                               } 
           
         
           
            out.println("<!DOCTYPE html>\n" +
"<html lang=\"en\" >\n" +
"<head>\n" +
"  <meta charset=\"UTF-8\">\n" +
"  <title>Reservation</title>\n" +
"  <link rel=\"stylesheet\" href=\"Check/style.css\">\n" +
"\n" +
"</head>\n" +
"<body>\n" +
"<!-- partial:index.partial.html -->\n" +
"<div class='card'>\n" +
"  <div class='card_left'>\n" +
"    <img src='"+ thumb +"'>\n" +
"  </div>\n" +
"  <div class='card_right'>\n" +
"    <h1>"+ ttl +"</h1>\n" +
        "      <div class='card_right__review'>\n" +
"        <p>"+ sl +"</p>\n" +     
        "      </div>\n <br><br>" +
        
"    <div class='card_right__details'>\n" +
"      <ul>\n" +
"        <li>Res ID " + session.getAttribute("revid") +"</li>\n" +
"        <li>IN "+ cin +"</li>\n" +
"        <li>OUT "+ cout +"</li>\n" +
"      </ul>\n" +
               "      <div class='card_right__review'>\n" +
"        <p>Save Your Reservation ID To Check This In Future</p>\n" +     
        "      </div>\n" +
"    \n" +
"      <div class='card_right__review'>\n" +
"        <p>Name : "+ name +" <br> Email : "+ email +" <br> TP : "+ tp +"</p>\n <br>" +
        "     <img src=\"assets/logo.png\" style=\"padding-left: 160px;\" width=\"120\" alt=\"logo\">\n" +
"      </div>\n" +
"    </div>\n" +
"  </div>\n" +
"</div>\n" +
"<!-- partial -->\n" +
"  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>\n" +
"<script src='https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script><script  src=\"Check/script.js\"></script>\n" +
"\n" +
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
