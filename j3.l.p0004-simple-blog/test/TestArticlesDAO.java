
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import phuongnt.articles.ArticlesDAO;
import phuongnt.articles.ArticlesDTO;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class TestArticlesDAO {
  public static void main(String[] args) throws SQLException {
    
        final String username = "phuongntse130063@fpt.edu.vn";
        final String password = "uyenismine1210";

        Properties props = new Properties();   
    props.setProperty("mail.host", "smtp.gmail.com");  
    props.put("mail.smtp.auth", "true");  
    props.put("mail.smtp.socketFactory.port", "465");  
    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("hoantse130135@fpt.edu.vn"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("hoantse130135@fpt.edu.vn")
            );
            message.setSubject("Testing Gmail TLS");
            message.setText("Dear Mail Crawler 2,"
                    + "\n\n Please do not spam my email!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
  }
}
