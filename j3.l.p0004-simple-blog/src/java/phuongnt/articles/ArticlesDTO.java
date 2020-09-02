/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuongnt.articles;

/**
 *
 * @author USER
 */
public class ArticlesDTO {
  private int id;
  private String title;
  private String shortDescrip;
  private String email;
  private String content;
  private String date;
  private String status;

  public ArticlesDTO(int id, String title, String shortDescrip, String email, String content, String date, String status) {
    setId(id);
    setTitle(title);
    setShortDescrip(shortDescrip);
    setEmail(email);
    setContent(content);
    setDate(date);
    setStatus(status);
  }
  

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getShortDescrip() {
    return shortDescrip;
  }

  public void setShortDescrip(String shortDescrip) {
    this.shortDescrip = shortDescrip;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "ArticlesDTO{" + "id=" + id + ", title=" + title + ", shortDescrip=" + shortDescrip + ", email=" + email + ", content=" + content + ", date=" + date + ", status=" + status + '}';
  }

 
  
  
}
