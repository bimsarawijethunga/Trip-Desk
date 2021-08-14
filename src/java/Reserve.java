
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
import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;   

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rkavi
 */

   

@WebServlet(urlPatterns = {"/Reserve"})
public class Reserve extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String h_id = request.getParameter("id");
            int r_idd;
            int r_id = 0;
            
            try {
                        com.mysql.jdbc.Connection con;
                        ResultSet rs;
                        
                        Class.forName("com.mysql.jdbc.Driver");
                        con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/oop", "root", "");

                PreparedStatement ps = con.prepareStatement("SELECT MAX(r_id) AS r_id FROM reservations"); 
           rs = ps.executeQuery(); 
            while(rs.next()) 
             { 
                r_idd = rs.getInt("r_id"); 
                r_id = r_idd + 1;
               
              
                      
             } 
            
                        String query = "insert into reservations (r_id, h_id, name, email, tp, checkin, checkout)" + " values ( ?, ?, ?, ?, ?, ?, ?)";

                        PreparedStatement preparedStmt = con.prepareStatement(query);
                       
                        
                        preparedStmt.setInt(1, r_id);
                        
                        preparedStmt.setString(2, request.getParameter("id"));
                        preparedStmt.setString(3, request.getParameter("Name"));
                        preparedStmt.setString(4, request.getParameter("Email"));
                        preparedStmt.setString(5, request.getParameter("number"));
                        preparedStmt.setString(6, request.getParameter("in"));
                        preparedStmt.setString(7, request.getParameter("c_out"));
                        
            session.setAttribute("revid", r_id);
                       response.sendRedirect("http://localhost:8080/oop/Check");  

                        preparedStmt.execute();
                        con.close();
                       
                    } catch (ClassNotFoundException | SQLException en) {
                        System.err.println("Got an exception!");
                        System.err.println(en.getMessage());
                    }
         
            
                 String body = "<!DOCTYPE html>\n" +
"<html lang=\"en\" >\n" +
"<head>\n" +
"  <meta charset=\"UTF-8\">\n" +
"  <title>Reservation</title>\n"
                    + "<style>\n" +
"    \n" +
"    @charset \"UTF-8\";\n" +
"@import url(https://fonts.googleapis.com/css?family=Montserrat:400,700);\n" +
"@import url(//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css);\n" +
"body {\n" +
"  background: #e2e2e2;\n" +
"  width: 98%;\n" +
"  height: 100vh;\n" +
"}\n" +
"body .card {\n" +
"  width: 800px;\n" +
"  height: 400px;\n" +
"  background: transparent;\n" +
"  position: absolute;\n" +
"  left: 0;\n" +
"  right: 0;\n" +
"  margin: auto;\n" +
"  top: 0;\n" +
"  bottom: 0;\n" +
"  border-radius: 10px;\n" +
"  -webkit-border-radius: 10px;\n" +
"  -moz-border-radius: 10px;\n" +
"  box-shadow: 0px 20px 30px 3px rgba(0, 0, 0, 0.55);\n" +
"}\n" +
"body .card_left {\n" +
"  width: 40%;\n" +
"  height: 400px;\n" +
"  float: left;\n" +
"  overflow: hidden;\n" +
"  background: transparent;\n" +
"}\n" +
"body .card_left img {\n" +
"  width: 100%;\n" +
"  height: auto;\n" +
"  border-radius: 10px 0 0 10px;\n" +
"  -webkit-border-radius: 10px 0 0 10px;\n" +
"  -moz-border-radius: 10px 0 0 10px;\n" +
"  position: relative;\n" +
"}\n" +
"body .card_right {\n" +
"  width: 60%;\n" +
"  float: left;\n" +
"  background: #000000;\n" +
"  height: 400px;\n" +
"  border-radius: 0 10px 10px 0;\n" +
"  -webkit-border-radius: 0 10px 10px 0;\n" +
"  -moz-border-radius: 0 10px 10px 0;\n" +
"}\n" +
"body .card_right h1 {\n" +
"  color: white;\n" +
"  font-family: \"Montserrat\", sans-serif;\n" +
"  font-weight: 400;\n" +
"  text-align: left;\n" +
"  font-size: 40px;\n" +
"  margin: 30px 0 0 0;\n" +
"  padding: 0 0 0 40px;\n" +
"  letter-spacing: 1px;\n" +
"}\n" +
"body .card_right__details ul {\n" +
"  list-style-type: none;\n" +
"  padding: 0 0 0 40px;\n" +
"  margin: 10px 0 0 0;\n" +
"}\n" +
"body .card_right__details ul li {\n" +
"  display: inline;\n" +
"  color: #e3e3e3;\n" +
"  font-family: \"Montserrat\", sans-serif;\n" +
"  font-weight: 400;\n" +
"  font-size: 14px;\n" +
"  padding: 0 40px 0 0;\n" +
"}\n" +
"body .card_right__rating__stars {\n" +
"  position: relative;\n" +
"  right: 160px;\n" +
"  margin: 10px 0 10px 0;\n" +
"  /***** CSS Magic to Highlight Stars on Hover *****/\n" +
"  /* hover previous stars in list */\n" +
"}\n" +
"body .card_right__rating__stars fieldset, body .card_right__rating__stars label {\n" +
"  margin: 0;\n" +
"  padding: 0;\n" +
"}\n" +
"body .card_right__rating__stars .rating {\n" +
"  border: none;\n" +
"}\n" +
"body .card_right__rating__stars .rating > input {\n" +
"  display: none;\n" +
"}\n" +
"body .card_right__rating__stars .rating > label:before {\n" +
"  margin: 5px;\n" +
"  font-size: 1.25em;\n" +
"  display: inline-block;\n" +
"  content: \"\";\n" +
"  font-family: FontAwesome;\n" +
"}\n" +
"body .card_right__rating__stars .rating > .half:before {\n" +
"  content: \"\";\n" +
"  position: absolute;\n" +
"}\n" +
"body .card_right__rating__stars .rating > label {\n" +
"  color: #ddd;\n" +
"  float: right;\n" +
"}\n" +
"body .card_right__rating__stars .rating > input:checked ~ label,\n" +
"body .card_right__rating__stars .rating:not(:checked) > label:hover,\n" +
"body .card_right__rating__stars .rating:not(:checked) > label:hover ~ label {\n" +
"  color: #FFD700;\n" +
"}\n" +
"body .card_right__rating__stars .rating > input:checked + label:hover,\n" +
"body .card_right__rating__stars .rating > input:checked ~ label:hover,\n" +
"body .card_right__rating__stars .rating > label:hover ~ input:checked ~ label,\n" +
"body .card_right__rating__stars .rating > input:checked ~ label:hover ~ label {\n" +
"  color: #FFED85;\n" +
"}\n" +
"body .card_right__review p {\n" +
"  color: white;\n" +
"  font-family: \"Montserrat\", sans-serif;\n" +
"  font-size: 12px;\n" +
"  padding: 0 40px 0 40px;\n" +
"  letter-spacing: 1px;\n" +
"  margin: 10px 0 10px 0;\n" +
"  line-height: 20px;\n" +
"}\n" +
"body .card_right__review a {\n" +
"  text-decoration: none;\n" +
"  font-family: \"Montserrat\", sans-serif;\n" +
"  font-size: 14px;\n" +
"  padding: 0 0 0 40px;\n" +
"  color: #ffda00;\n" +
"  margin: 0;\n" +
"}\n" +
"body .card_right__button {\n" +
"  padding: 0 0 0 40px;\n" +
"  margin: 30px 0 0 0;\n" +
"}\n" +
"body .card_right__button a {\n" +
"  color: #ffda00;\n" +
"  text-decoration: none;\n" +
"  font-family: \"Montserrat\", sans-serif;\n" +
"  border: 2px solid #ffda00;\n" +
"  padding: 10px 10px 10px 40px;\n" +
"  font-size: 12px;\n" +
"  background: url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/343086/COMdoWZ.png);\n" +
"  background-size: 12px 12px;\n" +
"  background-repeat: no-repeat;\n" +
"  background-position: 7% 50%;\n" +
"  border-radius: 5px;\n" +
"  transition-property: all;\n" +
"  transition-duration: 0.5s;\n" +
"}\n" +
"body .card_right__button a:hover {\n" +
"  color: #000000;\n" +
"  background-color: #ffda00;\n" +
"  background-image: url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/343086/rFQ5dHA.png);\n" +
"  background-size: 12px 12px;\n" +
"  background-repeat: no-repeat;\n" +
"  background-position: 10% 50%;\n" +
"  cursor: pointer;\n" +
"  transition-property: all;\n" +
"  transition-duration: 0.5s;\n" +
"}\n" +
"    </style>" +

"\n" +
"</head>\n" +
"<body>\n" +
"<!-- partial:index.partial.html -->\n" +
"<div class='card'>\n" +
"  <div class='card_left'>\n" +
"    <img src='https://i.ibb.co/cTB5h15/jaffna.jpg'>\n" +
"  </div>\n" +
"  <div class='card_right'>\n" +
"    <h1>"+ session.getAttribute("hname") +"</h1>\n" +
        "      <div class='card_right__review'>\n" +
"        <p>"+ session.getAttribute("hsl") +"</p>\n" +     
        "      </div>\n <br><br>" +
        
"    <div class='card_right__details'>\n" +
"      <ul>\n" +
"        <li>Res ID -" + r_id +"</li>\n" +
"        <li>IN -"+ request.getParameter("in") +"</li>\n" +
"        <li>OUT -"+ request.getParameter("c_out") +"</li>\n" +
"      </ul>\n" +
               "      <div class='card_right__review'>\n" +
"        <p>Save Your Reservation ID To Check This In Future</p>\n" +     
        "      </div>\n" +
"    \n" +
"      <div class='card_right__review'>\n" +
"        <p>Name : "+ request.getParameter("Name") +" <br> Email : "+ request.getParameter("Email") +" <br> TP : "+ request.getParameter("number") +"</p>\n <br>" +
        "     <img src=\"https://i.ibb.co/NTwT6J8/logo2.png\" width=\"200\" alt=\"logo\">\n" +
"      </div>\n" +
"    </div>\n" +
"  </div>\n" +
"</div>\n" +
"<!-- partial -->\n" +
"  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>\n" +
"<script src='https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script><script  src=\"Check/script.js\"></script>\n" +
"\n" +
"</body>\n" +
"</html>";
            
            SendMail.send(request.getParameter("Email"),"Reservation From TripDesk", body , "ravindu.official00@gmail.com", "isharamodaya123#");
        out.println("Mail send successfully");

   
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
