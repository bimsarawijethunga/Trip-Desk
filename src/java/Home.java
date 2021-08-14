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
@WebServlet(urlPatterns = {"/Home"})
public class Home extends HttpServlet {
    
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             System.out.print("dfs");
            out.println("<!DOCTYPE html>");
            out.println("\n" +
"<html>\n" +
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
"  \n  <style>\n" +
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
"</style>" +
"    </head>\n" +
"    <body>\n" +
"        \n" +
"             <video autoplay muted loop id=\"myVideo\">\n" +
"  <source src=\"assets/back4.mp4\" type=\"video/mp4\">\n" +
"</video>\n" +
"                \n" +
"        <div class=\"content\">\n" +
"            <ul style=\"\n" +
"    font-family: 'Open Sans Light';\n" +
"   font-style: normal;\n" +
"   font-weight: 300;\n" +
"    font-size: 15px;\n" +
"    color: aliceblue;\">\n" +
"  <li><a href=\"default.asp\">Home</a></li>\n" +
"  <li><a href=\"news.asp\">News</a></li>\n" +
"  <li><a href=\"contact.asp\">Contact</a></li>\n" +
"  <li><a href=\"about.asp\">About</a></li>\n" +
                    "  <li><a href=\"http://localhost:8080/oop/Reservations\">Check Reservations</a></li>\n" +
"</ul>\n" +
"\n" +
"<center>\n" +
"                    <div style=\"padding: 260px 30px;\">\n" +
"                    \n" +
"                        <h2 style=\"\n" +
"    font-family: 'Open Sans Light';\n" +
"   font-style: normal;\n" +
"   font-weight: 300;\n" +
"    font-size: 36px;\n" +
"    color: aliceblue;\">Welcome To</h2>\n" +
"                        <img src=\"assets/logo.png\" alt=\"logo\">\n" +
"                        <p class=\"txtt\">Big savings on hotels in 2000+ destinations island wide. <br>\n" +
"Browse hotel reviews and find the guaranteed best price on hotels for all budgets.</p>\n" +
"                    \n" +
"                    </div>\n" +
"    <div style=\"background-color: white\">\n" +
"        \n" +
"        \n" +
"    <br>    <br>\n" +
"    <br>\n" +
"    <br>\n" +
"\n" +
"        <h2 style=\"font-family: 'Open Sans Light';\n" +
"   font-style: normal;\n" +
"   font-weight: 300;\n" +
"    font-size: 36px;\n" +
"    color: black;\">Best Reviewed Hotels <br> In Sri Lanka</h2>\n" +
"            <br>    <br>\n" +
"    <br>\n" +
"    <br>\n" + 
"        <div id=\"app\" class=\"cont\">\n");
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
           ps=con.prepareStatement("SELECT * FROM hotels INNER JOIN h_images ON hotels.h_id = h_images.h_id LIMIT 4"); 
           rs = ps.executeQuery(); 

 while(rs.next()) 
             { 
               String nm = rs.getString("thumb"); 
               String ttl = rs.getString("h_name"); 
               String des = rs.getString("h_slogan"); 
              
                      out.println("  <card data-image=\""+nm+"\">\n" +
"    <h1 slot=\"header\">"+ttl+"</h1>\n" +
"    <p slot=\"content\">"+des+"</p>\n" +
"  </card>\n");
                      
             }         
               
                 }       
                   catch(Exception e)   
                               {  
                                 e.printStackTrace();  
                               } 
out.println("</div>\n" +
"         <script src='https://cdnjs.cloudflare.com/ajax/libs/vue/2.0.1/vue.min.js'></script><script  src=\"./script.js\"></script>\n" +
"     <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>\n" +
"        <br><br><br><br>\n" +
"        \n" +
"        </div>\n" +
"    \n" +
"    \n" +
"        <div style=\"padding: 160px 30px;\">\n" +
"                    <h2 style=\"\n" +
"    font-family: 'Open Sans Light';\n" +
"   font-style: normal;\n" +
"   font-weight: 300;\n" +
"    font-size: 25px;\n" +
"    color: aliceblue;\">Find Your Place <br> With</h2>\n" +
"                       \n" +
"                        <img src=\"assets/logo.png\" alt=\"logo\"> <br><br><br>\n" +
"                        \n" +
"                          <form method=\"post\" action=\"./Result\">\n" +
"        <div id=\"div_login\">\n" +
"           \n" +
"            <div>\n" +
"  <div class=\"autocomplete\" style=\"width:300px;\">\n" +
"                <input style=\"width: 100%;\" type=\"text\" class=\"inputs\" id=\"txt_uname\" name=\"txt_uname\" placeholder=\"Destination\" autocomplete=\"off\" />\n" +
"                </div>" +
"            </div><br><br>\n" +
"            <div>\n" +
"                <p class=\"txtt\">Check In &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Check Out</p>\n" +
"            <input name=\"checkin\" id=\"checkin\" style=\"width: 20%;\" type=\"date\" placeholder=\"CheckIn\" value=\"2018-02-15\">" +
"                 <input name=\"checkout\" id=\"checkout\" style=\"width: 20%;\" type=\"date\" placeholder=\"CheckOut\" value=\"2018-02-15\">\n" +
"           </div><br><br>\n" +
"            <div>\n" +
"                <button class=\"button\" type=\"submit\" value=\"Login\" name=\"but_submit\" id=\"but_submit\"> <span>Find A Place</span> </button>\n" +
"            </div>\n" +
"        </div>\n" +
"    </form>\n" +
"            \n" +
"                    </div>\n" +
"    \n" +
"    </center>\n        <script>\n" +
"function autocomplete(inp, arr) {\n" +
"  /*the autocomplete function takes two arguments,\n" +
"  the text field element and an array of possible autocompleted values:*/\n" +
"  var currentFocus;\n" +
"  /*execute a function when someone writes in the text field:*/\n" +
"  inp.addEventListener(\"input\", function(e) {\n" +
"      var a, b, i, val = this.value;\n" +
"      /*close any already open lists of autocompleted values*/\n" +
"      closeAllLists();\n" +
"      if (!val) { return false;}\n" +
"      currentFocus = -1;\n" +
"      /*create a DIV element that will contain the items (values):*/\n" +
"      a = document.createElement(\"DIV\");\n" +
"      a.setAttribute(\"id\", this.id + \"autocomplete-list\");\n" +
"      a.setAttribute(\"class\", \"autocomplete-items\");\n" +
"      /*append the DIV element as a child of the autocomplete container:*/\n" +
"      this.parentNode.appendChild(a);\n" +
"      /*for each item in the array...*/\n" +
"      for (i = 0; i < arr.length; i++) {\n" +
"        /*check if the item starts with the same letters as the text field value:*/\n" +
"        if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {\n" +
"          /*create a DIV element for each matching element:*/\n" +
"          b = document.createElement(\"DIV\");\n" +
"          /*make the matching letters bold:*/\n" +
"          b.innerHTML = \"<strong>\" + arr[i].substr(0, val.length) + \"</strong>\";\n" +
"          b.innerHTML += arr[i].substr(val.length);\n" +
"          /*insert a input field that will hold the current array item's value:*/\n" +
"          b.innerHTML += \"<input type='hidden' value='\" + arr[i] + \"'>\";\n" +
"          /*execute a function when someone clicks on the item value (DIV element):*/\n" +
"          b.addEventListener(\"click\", function(e) {\n" +
"              /*insert the value for the autocomplete text field:*/\n" +
"              inp.value = this.getElementsByTagName(\"input\")[0].value;\n" +
"              /*close the list of autocompleted values,\n" +
"              (or any other open lists of autocompleted values:*/\n" +
"              closeAllLists();\n" +
"          });\n" +
"          a.appendChild(b);\n" +
"        }\n" +
"      }\n" +
"  });\n" +
"  /*execute a function presses a key on the keyboard:*/\n" +
"  inp.addEventListener(\"keydown\", function(e) {\n" +
"      var x = document.getElementById(this.id + \"autocomplete-list\");\n" +
"      if (x) x = x.getElementsByTagName(\"div\");\n" +
"      if (e.keyCode == 40) {\n" +
"        /*If the arrow DOWN key is pressed,\n" +
"        increase the currentFocus variable:*/\n" +
"        currentFocus++;\n" +
"        /*and and make the current item more visible:*/\n" +
"        addActive(x);\n" +
"      } else if (e.keyCode == 38) { //up\n" +
"        /*If the arrow UP key is pressed,\n" +
"        decrease the currentFocus variable:*/\n" +
"        currentFocus--;\n" +
"        /*and and make the current item more visible:*/\n" +
"        addActive(x);\n" +
"      } else if (e.keyCode == 13) {\n" +
"        /*If the ENTER key is pressed, prevent the form from being submitted,*/\n" +
"        e.preventDefault();\n" +
"        if (currentFocus > -1) {\n" +
"          /*and simulate a click on the \"active\" item:*/\n" +
"          if (x) x[currentFocus].click();\n" +
"        }\n" +
"      }\n" +
"  });\n" +
"  function addActive(x) {\n" +
"    /*a function to classify an item as \"active\":*/\n" +
"    if (!x) return false;\n" +
"    /*start by removing the \"active\" class on all items:*/\n" +
"    removeActive(x);\n" +
"    if (currentFocus >= x.length) currentFocus = 0;\n" +
"    if (currentFocus < 0) currentFocus = (x.length - 1);\n" +
"    /*add class \"autocomplete-active\":*/\n" +
"    x[currentFocus].classList.add(\"autocomplete-active\");\n" +
"  }\n" +
"  function removeActive(x) {\n" +
"    /*a function to remove the \"active\" class from all autocomplete items:*/\n" +
"    for (var i = 0; i < x.length; i++) {\n" +
"      x[i].classList.remove(\"autocomplete-active\");\n" +
"    }\n" +
"  }\n" +
"  function closeAllLists(elmnt) {\n" +
"    /*close all autocomplete lists in the document,\n" +
"    except the one passed as an argument:*/\n" +
"    var x = document.getElementsByClassName(\"autocomplete-items\");\n" +
"    for (var i = 0; i < x.length; i++) {\n" +
"      if (elmnt != x[i] && elmnt != inp) {\n" +
"        x[i].parentNode.removeChild(x[i]);\n" +
"      }\n" +
"    }\n" +
"  }\n" +
"  /*execute a function when someone clicks in the document:*/\n" +
"  document.addEventListener(\"click\", function (e) {\n" +
"      closeAllLists(e.target);\n" +
"  });\n" +
"}\n" +
"\n" +
"/*An array containing all the country names in the world:*/\n" +
"var countries = [\"Jaffna\",\n" +
"\"Kilinochchi\",\n" +
"\"Mannar\",\n" +
"\"Mullaitivu\",\n" +
"\"Vavuniya\",\n" +
"\"Puttalam\",\n" +
"\"Kurunegala\",\n" +
"\"Gampaha\",\n" +
"\"Colombo\",\n" +
"\"Kalutara\",\n" +
"\"Anuradhapura\",\n" +
"\"Polonnaruwa\",\n" +
"\"Matale\",\n" +
"\"Kandy\",\n" +
"\"Nuwara Eliya\",\n" +
"\"Kegalle\",\n" +
"\"Ratnapura\",\n" +
"\"Trincomalee\",\n" +
"\"Batticaloa\",\n" +
"\"Ampara\",\n" +
"\"Badulla\",\n" +
"\"Monaragala\",\n" +
"\"Hambantota\",\n" +
"\"Matara\",\n" +
"\"Galle\"];\n" +
"\n" +
"/*initiate the autocomplete function on the \"myInput\" element, and pass along the countries array as possible autocomplete values:*/\n" +
"autocomplete(document.getElementById(\"txt_uname\"), countries);\n" +
"</script>" +
"</div>\n" +
"        \n" +
"        \n" +
"        </div>\n" +
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

