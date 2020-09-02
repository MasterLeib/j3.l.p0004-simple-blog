/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuongnt.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import phuongnt.db.MyConnection;

/**
 *
 * @author USER
 */
public class UsersDAO {

  public boolean registerUser(String email, String name, String password) throws SQLException {
    boolean isSuccess = false;
    UsersDTO user = getUser(email);
    if (user != null) return isSuccess;
    String insertQuery = "Insert into Users (email,name,password,role,status) "
            + "values(?,?,?,'Member',0)";
    try (Connection conn = MyConnection.getMyConnection();
            PreparedStatement insertStm = conn.prepareStatement(insertQuery);) {
      insertStm.setString(1, email);
      insertStm.setString(2, name);
      insertStm.setString(3, password);    
      isSuccess = insertStm.executeUpdate() > 0;
    }
    return isSuccess;
  }

  public boolean checkLogin(String email, String password) throws SQLException {
    if (email == null || password == null) {
      return false;
    }
    String selectQuery
            = "Select email,password "
            + "from Users "
            + "where email = ? and password = ?";
    try (Connection conn = MyConnection.getMyConnection();
            PreparedStatement selectStm = conn.prepareStatement(selectQuery);) {
      selectStm.setString(1, email);
      selectStm.setString(2, password);
      try (ResultSet rs = selectStm.executeQuery();) {
        if (rs.next()) {
          return true;
        }
      }
    }

    return false;
  }
  
  public UsersDTO getUser(String email) throws SQLException{
    UsersDTO user = null;
    if(email == null){
      return user;
    }
    String selectQuery = "Select email,name,password,role,status from Users where email = ?";
    try(Connection conn = MyConnection.getMyConnection();
            PreparedStatement selectStm = conn.prepareStatement(selectQuery);){
      selectStm.setString(1, email);
      try(ResultSet rs = selectStm.executeQuery();){
        if(rs.next()){
          email = rs.getString("email");
          String name = rs.getString("name");
          String password = rs.getString("password");
          String roleId = rs.getString("role");
          boolean status = rs.getBoolean("status");
          user = new UsersDTO(email, name, password, roleId, status);
        }
      }
    }
    return user;
  }
  public boolean setStatus(String email) throws SQLException{
    boolean isSuccess = false;
    String updateQuery = "Update Users set status = 1 where email = ?";
    try (Connection conn = MyConnection.getMyConnection();
            PreparedStatement updateStm = conn.prepareStatement(updateQuery);){
      updateStm.setString(1, email);
      isSuccess = updateStm.executeUpdate()>0;
    }
    return isSuccess;
  }
}
