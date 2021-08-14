
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rkavi
 */
@WebServlet(urlPatterns = {"/View"})
public class View extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String id = request.getParameter("id");
            String ttl = null; 
               String des = null;
               String img1 = null;
               String img2 = null;
               String img3 = null;
               String des1 = null;
               String des2 = null;
               String des3 = null;
            
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
           ps=con.prepareStatement("SELECT * FROM hotels INNER JOIN h_images ON hotels.h_id = h_images.h_id INNER JOIN h_des ON hotels.h_id = h_des.h_id WHERE hotels.h_id = '" + id + "'"); 
           rs = ps.executeQuery(); 

 while(rs.next()) 
             { 
                 
               
                ttl = rs.getString("h_name"); 
                des = rs.getString("h_slogan");
                img1 = rs.getString("thumb");
                img2 = rs.getString("img1");
                img3 = rs.getString("img2");
                des1 = rs.getString("des1");
                des2 = rs.getString("des2");
                des3 = rs.getString("des3");
               
            
               
              
               
               }         
               
                 }       
                   catch(Exception e)   
                               {  
                                 e.printStackTrace();  
                               } 
           
            /* TODO output your page here. You may use following sample code. */
             HttpSession session = request.getSession();
            session.setAttribute("hname", ttl);
            session.setAttribute("hsl", des);
            
            out.println("<!DOCTYPE html>\n" +
"<html lang=\"en\" >\n" +
"<head>\n" +
"  <meta charset=\"UTF-8\">\n" +
"  <title>"+ ttl +"</title>\n" +
"  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js\" type=\"text/javascript\"></script>\n" +
"\n" +
"<meta name=\"viewport\" content=\"width=device-width\"><link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css\">\n" +
"<link rel=\"stylesheet\" href=\"style.css\">\n" +
"        <link rel=\"stylesheet\" href=\"View/style.css\">\n" +
"\n" +
"\n" +
"</head>\n" +
"<body>\n" +
"<!-- partial:index.partial.html -->\n" +
"<div class=\"img-holder\" data-image=\""+ img1 +"\" data-width=\"1600\" ></div>\n" +
"\n" +
"  <section>\n" +
"      <h1>"+ ttl + id + "</h1>\n" +
"    <h2>"+ des +"</h2>\n" +
"  </section>\n" +
"  \n" +
"  <div class=\"img-holder\" data-image=\""+ img2 +"\" data-width=\"1680\"></div>\n" +
"  \n" +
"  <section>\n" +
"    <h3>"+ des1 +"</h3>\n" +
"    \n" +
"  \n" +
"  </section>\n" +
"  \n" +
"  <div class=\"img-holder\" data-image=\""+ img3 +"\"></div>\n" +
"  \n" +
"  <section>\n" +
"    <h3>"+ des2 +"</h3><br>\n" +
"      <h3>"+ des3 +"</h3> <br>\n" +
"      <center> <button style=\"width: 30%;\" class=\"button\" type=\"submit\" value=\"Login\" name=\"but_submit\" id=\"but_submit\"> <span>Visit Website</span> </button>\n" +
"          <br><br>\n" +
"           <form method=\"post\" action=\"./Reserve\">\n" +
        
"          <h2>Reserve</h2> <br>\n" +
         " <input type=\"hidden\" id=\"id\" name=\"id\" placeholder=\"id\" value=\""+ id +"\"/>" +
"           <input style=\"width: 30%;\" type=\"text\" class=\"inputs\" id=\"Name\" name=\"Name\" placeholder=\"Name\" />\n" +
"          <input style=\"width: 30%;\" type=\"text\" class=\"inputs\" id=\"Email\" name=\"Email\" placeholder=\"Email\" /><br>\n" +
"               <input style=\"width: 30%;\" type=\"text\" class=\"inputs\" id=\"number\" name=\"number\" placeholder=\"number\" /><br>\n" +
"         <input id=\"in\" name=\"in\" style=\"width: 30%;\" type=\"date\" placeholder=\"CheckIn\" value=\"2018-02-15\">\n" +
"                 <input id=\"c_out\" name=\"c_out\" style=\"width: 30%;\" type=\"date\" placeholder=\"CheckIn\" value=\"2018-07-22\"><br>\n" +
"      <button style=\"width: 30%;\" class=\"button\" type=\"submit\" value=\"Login\" name=\"but_submit\" id=\"but_submit\"> <span>Reserve</span> </button>\n" +
"          </form></center>\n" +
"  </section>\n" +
"<!-- partial -->\n" +
"  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>\n" +
"<script src='https://rawgithub.com/pederan/Parallax-ImageScroll/master/jquery.imageScroll.min.js'></script><script  src=\"View/script.js\"></script>\n" +
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
