/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuongnt.comments;

/**
 *
 * @author USER
 */
public class CommentsDTO {
  private int id;
  private String email;
  private int idOfArticle;
  private String content;

  public CommentsDTO(int id, String email, int idOfArticle, String content) {
    this.id = id;
    this.email = email;
    this.idOfArticle = idOfArticle;
    this.content = content;
  }

  public CommentsDTO() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getIdOfArticle() {
    return idOfArticle;
  }

  public void setIdOfArticle(int idOfArticle) {
    this.idOfArticle = idOfArticle;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return "CommentsDTO{" + "id=" + id + ", email=" + email + ", idOfArticle=" + idOfArticle + ", content=" + content + '}';
  }

 
  
  
}
