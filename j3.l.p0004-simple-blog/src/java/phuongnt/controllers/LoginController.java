/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuongnt.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phuongnt.ultis.Ultis;
import phuongnt.users.UsersDAO;
import phuongnt.users.UsersDTO;

/**
 *
 * @author USER
 */
public class LoginController extends HttpServlet {

  private static final String FAIL = "login.jsp";
  private static final String SUCCESS = "index.jsp";

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    String url = FAIL;
    HttpSession session = request.getSession();
    try {
      String email = request.getParameter("email");
      String password = request.getParameter("password");
      String encryptedPassword = Ultis.getSHA256(password);

      UsersDAO dao = new UsersDAO();
      boolean isTrue = dao.checkLogin(email, encryptedPassword);
      UsersDTO user = dao.getUser(email);
      String name = user.getName();
      if (isTrue) {
        url = SUCCESS;
        session.setAttribute("name", name);
        session.setAttribute("email", email);
      } else {
        request.setAttribute("email", email);        
        request.setAttribute("errorMsg", "Email or password is wrong!!");
      }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
      if (url.equals(SUCCESS)) {
        response.sendRedirect(url);
      } else {
        request.getRequestDispatcher(url).forward(request, response);
      }
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
