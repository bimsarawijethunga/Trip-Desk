import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
/* The Java file upload Servlet example */

@WebServlet(name = "UploadServlet", urlPatterns = { "/UploadServlet" })
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100,   // 100 MB
  location="/"
)

public class UploadServlet extends HttpServlet {
String fileName;
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    /* Receive file uploaded to the Servlet from the HTML5 form */
    //db variebles
    int hid = 1005;
    String h_name = request.getParameter("name");
    String slogan = request.getParameter("slogan");
    String location = request.getParameter("location");
    String phone = request.getParameter("tp");
    Cookie name[]=request.getCookies();  
            String mngr_id = name[0].getValue();
            
    String des1 = request.getParameter("des1");
    String des2 = request.getParameter("des2");
    String des3 = request.getParameter("des3");
    
    String loc = "assets/";
    String thumb = null;
    String image2 = null;
    String image3 = null;
    
    int i;
    for(i=1; i <= 3;){
       
          Part filePart = request.getPart("img" + i);
           
     fileName = filePart.getSubmittedFileName();
     System.out.print(fileName);
        switch (i) {
            case 1:
                thumb = fileName;
                break;
            case 2:
                image2 = fileName;
                break;
            case 3:
                image3 = fileName;
                break;
            default:
                break;
        }
    for (Part part : request.getParts()) {
      part.write(fileName);
      
      Path src = Paths.get("D:\\stuff\\glassfish5\\glassfish\\domains\\domain1\\generated\\jsp\\oop\\" + fileName);
      Path dst = Paths.get("C:\\Users\\rkavi\\Documents\\NetBeansProjects\\oop\\web\\assets\\" + fileName);
      Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING);
    }
    response.getWriter().print("The file uploaded sucessfully.");
         i++;
    }
    
     try {
                        com.mysql.jdbc.Connection con;
                        ResultSet rs;
                        
                        Class.forName("com.mysql.jdbc.Driver");
                        con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/oop", "root", "");

              
            
                        String query = "insert into hotels (h_id, h_name, h_slogan, location, contact, mngr_id)" + " values ( ?, ?, ?, ?, ?, ?)";

                        PreparedStatement preparedStmt = con.prepareStatement(query);
                       
                        
                        preparedStmt.setInt(1, hid);
                        
                        preparedStmt.setString(2, h_name);
                        preparedStmt.setString(3, slogan);
                        preparedStmt.setString(4, location);
                        preparedStmt.setString(5, phone);
                        preparedStmt.setString(6, mngr_id);
             
                        

                        preparedStmt.execute();
                        
                        /////////////////////////////////
                         String query1 = "insert into h_des (h_id, des1, des2, des3)" + " values ( ?, ?, ?, ?)";

                        PreparedStatement preparedStmt1 = con.prepareStatement(query1);
                       
                        
                        preparedStmt1.setString(1, String.valueOf(hid));
                        
                        preparedStmt1.setString(2, des1);
                        preparedStmt1.setString(3, des2);
                        preparedStmt1.setString(4, des3);
             
                        

                        preparedStmt1.execute();

                        
                        //////////////////////////////////////
                         String query2 = "insert into h_images (h_id, thumb, img1, img2)" + " values ( ?, ?, ?, ?)";

                        PreparedStatement preparedStmt2 = con.prepareStatement(query2);
                       
                        
                        preparedStmt2.setInt(1, hid);
                        
                        preparedStmt2.setString(2, loc + thumb);
                        preparedStmt2.setString(3, loc + image2);
                        preparedStmt2.setString(4, loc + image3);
             
                        

                        preparedStmt2.execute();
                        
                        con.close();
                       
                    } catch (ClassNotFoundException | SQLException en) {
                        System.err.println("Got an exception!");
                        System.err.println(en.getMessage());
                    }
  
  }

}