

import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;    
class Mailer{  
    public static void send(){  
        
        String from = "ravindu.official00@gmail.com";
                String password = "isharamodaya123#";
                String to = "rkavishwara@gmail.com";
                        String sub = "hello javatpoint";
                        String msg = "How r u?";
                        
                        
          //Get properties object    
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);    
           message.setText(msg);    
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {throw new RuntimeException(e);}    
             
    }  
}  
public class SendMailSSL{    
 public static void main(String[] args) {    
     //from,password,to,subject,message  
    //   Mailer.send("ravindu.official00@gmail.com","isharamodaya123#","rkavishwara@gmail.com","hello javatpoint","How r u?");  
     //change from, password and to  
       Mailer.send();
 }    
}   