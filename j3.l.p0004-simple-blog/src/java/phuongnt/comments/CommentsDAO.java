/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuongnt.comments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import phuongnt.db.MyConnection;

/**
 *
 * @author USER
 */
public class CommentsDAO {
  public boolean postComment(String email,int idArticle, String content) throws SQLException{
    boolean isSuccess = false;
    if(content==null||content.equals("")){
      return isSuccess;
    }
    String insertQuery = "Insert into Comments (email,article_id,content) values(?,?,?)";
    try(Connection conn= MyConnection.getMyConnection();
            PreparedStatement insertStm = conn.prepareStatement(insertQuery);){
      insertStm.setString(1, email);
      insertStm.setInt(2, idArticle);
      insertStm.setString(3, content);
      isSuccess = insertStm.executeUpdate()>0;
    }
    return isSuccess;
  }
  public ArrayList<CommentsDTO> getComments(int idArticle) throws SQLException{
    ArrayList<CommentsDTO> comments = new ArrayList<>();
    String selectQuery = "Select id,email,article_id,content from Comments where article_id = ?";
    try(Connection conn = MyConnection.getMyConnection();
            PreparedStatement selectStm = conn.prepareStatement(selectQuery);){
      selectStm.setInt(1, idArticle);
      try(ResultSet rs = selectStm.executeQuery()){
        while(rs.next()){
          int id = rs.getInt("id");
          String email = rs.getString("email");
          int idOfArticle = rs.getInt("article_id");
          String content = rs.getString("content");
          
          CommentsDTO comment = new CommentsDTO(id, email, idOfArticle, content);
          comments.add(comment);
        }
      }
    }
    return comments;
  }
}
