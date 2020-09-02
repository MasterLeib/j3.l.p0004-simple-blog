
import java.sql.SQLException;
import javax.mail.MessagingException;
import phuongnt.comments.CommentsDAO;
import phuongnt.ultis.Ultis;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class TestCommentDAO {
  public static void main(String[] args) throws SQLException, MessagingException {
    CommentsDAO dao = new CommentsDAO();
    Ultis.sendMail("hoantse1301x", "hhi", "shjvdmcjvhdncm");
  }
}
