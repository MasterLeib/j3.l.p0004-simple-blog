
import java.sql.SQLException;
import phuongnt.ultis.Ultis;
import phuongnt.users.UsersDAO;
import phuongnt.users.UsersDTO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class TestUsersDAO {
  public static void main(String[] args) throws SQLException {
    UsersDAO dao = new UsersDAO();
    System.out.println(dao.setStatus("nguyenthanhphuong5799@gmail.com"));
  }
}
