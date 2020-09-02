/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuongnt.articles;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import phuongnt.db.MyConnection;

/**
 *
 * @author USER
 */
public class ArticlesDAO {

  public ArrayList<ArticlesDTO> searchArticles(String keyword, int limit, int page) throws SQLException {
    if (keyword == null) {
      keyword = "";
    }
    ArrayList<ArticlesDTO> articles = new ArrayList<>();
    String selectQuery
            = " Select id,title,short_description,email,content,date,status"
            + " from Articles"
            + " where"
            + " content like '%'+ ? + '%'"
            + " ORDER BY Id"
            + " OFFSET ? ROWS"
            + " FETCH NEXT ? ROWS ONLY";
    try (Connection conn = MyConnection.getMyConnection();
            PreparedStatement selectStm = conn.prepareStatement(selectQuery);) {
      selectStm.setString(1, keyword);
      selectStm.setInt(2, limit * page);
      selectStm.setInt(3, limit);
      try (ResultSet rs = selectStm.executeQuery()) {
        while (rs.next()) {
          int id = rs.getInt("id");
          String title = rs.getString("title");
          String shortDescript = rs.getString("short_description");
          String email = rs.getString("email");
          String content = rs.getString("content");
          String date = rs.getString("date");
          String status = rs.getString("status");
          articles.add(new ArticlesDTO(id, title, shortDescript, email, content, date, status));
        }
      }
    }
    return articles;
  }

  public int countArticles(String keyword) throws SQLException {
    int totalOfPages = 0;
    if (keyword == null) {
      keyword = "";
    }
    String selectQuery = "Select COUNT(id) from Articles"
            + " where"
            + " content like '%'+ ? + '%'";
    try (Connection conn = MyConnection.getMyConnection();
            PreparedStatement selectStm = conn.prepareStatement(selectQuery);) {
      selectStm.setString(1, keyword);
      try (ResultSet rs = selectStm.executeQuery();) {
        if (rs.next()) {
          totalOfPages = rs.getInt(1);
        }
      }
      return totalOfPages;
    }
  }

  public ArticlesDTO viewDetailArticle(int id) throws SQLException {
    ArticlesDTO article = null;
    String selectQuery = "Select title,short_description,email,content,date,status"
            + " from Articles"
            + " where id = ?";
    try (Connection conn = MyConnection.getMyConnection();
            PreparedStatement selectStm = conn.prepareStatement(selectQuery);) {
      selectStm.setInt(1, id);
      try (ResultSet rs = selectStm.executeQuery();) {
        if (rs.next()) {
          String title = rs.getString("title");
          String shortDescript = rs.getString("short_description");
          String email = rs.getString("email");
          String content = rs.getString("content");
          String date = rs.getString("date");
          String status = rs.getString("status");
          article = new ArticlesDTO(id, title, shortDescript, email, content, date, status);
        }
      }
    }
    return article;
  }

  public boolean postArticle(String email, String title, String shortDescript, String content, Timestamp date) throws SQLException {
    boolean isSuccess = false;
    String insertQuery
            = "Insert into Articles (email,title,short_description,content,date,status)"
            + " values (?, ?, ?, ?, ?, 'New')";
    try (Connection conn = MyConnection.getMyConnection();
            PreparedStatement insertStm = conn.prepareStatement(insertQuery);) {
      insertStm.setString(1, email);
      insertStm.setString(2, title);
      insertStm.setString(3, shortDescript);
      insertStm.setString(4, content);
      insertStm.setTimestamp(5, date);
      isSuccess = insertStm.executeUpdate() > 0;

    }
    return isSuccess;
  }

  public ArrayList<ArticlesDTO> searchArticlesUsers(String keyword, int limit, int page) throws SQLException {
    if (keyword == null) {
      keyword = "";
    }
    ArrayList<ArticlesDTO> articles = new ArrayList<>();
    String selectQuery
            = " Select id,title,short_description,email,content,date,status"
            + " from Articles"
            + " where"
            + " status ='Active'"
            + " and"
            + " content like '%'+ ? + '%'"
            + " ORDER BY Id"
            + " OFFSET ? ROWS"
            + " FETCH NEXT ? ROWS ONLY";
    try (Connection conn = MyConnection.getMyConnection();
            PreparedStatement selectStm = conn.prepareStatement(selectQuery);) {
      selectStm.setString(1, keyword);
      selectStm.setInt(2, limit * page);
      selectStm.setInt(3, limit);
      try (ResultSet rs = selectStm.executeQuery()) {
        while (rs.next()) {
          int id = rs.getInt("id");
          String title = rs.getString("title");
          String shortDescript = rs.getString("short_description");
          String email = rs.getString("email");
          String content = rs.getString("content");
          String date = rs.getString("date");
          String status = rs.getString("status");
          articles.add(new ArticlesDTO(id, title, shortDescript, email, content, date, status));
        }
      }
    }
    return articles;
  }

  public int countArticlesUser(String keyword) throws SQLException {
    int totalOfPages = 0;
    if (keyword == null) {
      keyword = "";
    }
    String selectQuery = "Select COUNT(id) from Articles"
            + " where"
            + " status ='Active'"
            + " and"
            + " content like '%'+ ? + '%'";
    try (Connection conn = MyConnection.getMyConnection();
            PreparedStatement selectStm = conn.prepareStatement(selectQuery);) {
      selectStm.setString(1, keyword);
      try (ResultSet rs = selectStm.executeQuery();) {
        if (rs.next()) {
          totalOfPages = rs.getInt(1);
        }
      }
      return totalOfPages;
    }
  }
  public boolean updateActiveStatus(int id) throws SQLException{
    boolean isSuccess = false;
    String updateQuery = "Update Articles SET status = 'Active' where id = ?";
    try(Connection conn = MyConnection.getMyConnection();
            PreparedStatement updateStm = conn.prepareStatement(updateQuery);){
      updateStm.setInt(1, id);
      isSuccess = updateStm.executeUpdate()>0;
      
    }
    return isSuccess;
  }
  public boolean updateDeleteStatus(int id) throws SQLException{
    boolean isSuccess = false;
    String updateQuery = "Update Articles SET status = 'Delete' where id = ?";
    try(Connection conn = MyConnection.getMyConnection();
            PreparedStatement updateStm = conn.prepareStatement(updateQuery);){
      updateStm.setInt(1, id);
      isSuccess = updateStm.executeUpdate()>0;
      
    }
    return isSuccess;
  }
}
