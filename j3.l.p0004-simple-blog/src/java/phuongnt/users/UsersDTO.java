/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuongnt.users;

/**
 *
 * @author USER
 */
public class UsersDTO {
  private String email;
  private String name;
  private String password;
  private String role;
  private boolean status;

  public UsersDTO() {
  }

  public UsersDTO(String email, String name, String password, String role, boolean status) {
    setEmail(email);
    setName(name);
    setPassword(password);
    setRole(role);
    setStatus(status);
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "UsersDTO{" + "email=" + email + ", name=" + name + ", password=" + password + ", role=" + role + ", status=" + status + '}';
  }
  
  
  
}
