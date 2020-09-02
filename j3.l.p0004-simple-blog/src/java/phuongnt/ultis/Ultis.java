/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuongnt.ultis;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author USER
 */
public class Ultis {

  public static int convertToPages(int totalOfArticles, int limit) {
    int totalOfPages = totalOfArticles / limit;
    if (totalOfArticles % limit > 0) {
      totalOfPages++;
    }
    return totalOfPages;
  }

  public static String getSHA256(String input) throws NoSuchAlgorithmException {
    // Static getInstance method is called with hashing SHA  
    MessageDigest md = MessageDigest.getInstance("SHA-256");

    // digest() method called  
    // to calculate message digest of an input  
    // and return array of byte 
    byte[] hash = md.digest(input.getBytes(StandardCharsets.UTF_8));

    // Convert byte array into signum representation  
    BigInteger number = new BigInteger(1, hash);

    // Convert message digest into hex value  
    StringBuilder hexString = new StringBuilder(number.toString(16));

    // Pad with leading zeros 
    while (hexString.length() < 32) {
      hexString.insert(0, '0');
    }

    return hexString.toString();
  }

  public static void sendMail(String email, String title, String content) throws AddressException, MessagingException {
    final String username = "phuongntse130063@fpt.edu.vn";
    final String password = "uyenismine1210";

    Properties props = new Properties();
    props.setProperty("mail.host", "smtp.gmail.com");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
      }
    });
    Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress(email));
    message.setRecipients(
            Message.RecipientType.TO,
            InternetAddress.parse(email)
    );
    message.setSubject(title);
    message.setText(content);

    Transport.send(message);
  }

  public static String getCode() {
    int a = 10000;
    Random random = new Random();
    do {
      a = random.nextInt(999999);
    } while (a < 10000);
    return a+"";
  }
}
