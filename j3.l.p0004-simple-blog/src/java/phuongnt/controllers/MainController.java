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

/**
 *
 * @author USER
 */
public class MainController extends HttpServlet {
  private static final String REGISTER_CONTROLLER = "RegisterController";
  private static final String LOGIN_CONTROLLER = "LoginController";
  private static final String LOGOUT_CONTROLLER = "LogoutController";
  private static final String VIEW_ARTICLES_CONTROLLER = "ViewArticlesController";
  private static final String SEARCH_ARTICLES_CONTROLLER = "SearchArticlesController";
  private static final String POST_ARTICLE_CONTROLLER = "PostArticleController";
  private static final String INDEX_CONTROLLER = "IndexController";
  private static final String ADMIN_VIEW_ARTICLES_CONTROLLER = "AdminViewArticlesController";
  private static final String COMMENT_CONTROLLER = "CommentController";
  private static final String CONFIRM_EMAIL_CONTROLLER = "ConfirmEmailController";
  

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
    String action = request.getParameter("action");
    String url = "";
    try {
      switch(action){
        case "RegisterController":
          url = REGISTER_CONTROLLER;
          break;
        case "LoginController":
          url = LOGIN_CONTROLLER;
          break;
        case "LogoutController":
          url = LOGOUT_CONTROLLER;
          break;
        case "ViewArticlesController":
          url = VIEW_ARTICLES_CONTROLLER;
          break;
        case "SearchArticlesController":
          url = SEARCH_ARTICLES_CONTROLLER;
          break;
        case "PostArticleController":
          url = POST_ARTICLE_CONTROLLER;
          break;
        case "IndexController":
          url = INDEX_CONTROLLER;
          break;
        case "AdminViewArticlesController":
          url = ADMIN_VIEW_ARTICLES_CONTROLLER;
          break;
        case "CommentController":
          url =COMMENT_CONTROLLER;
          break;
        case "ConfirmEmailController":
          url = CONFIRM_EMAIL_CONTROLLER;
          break;
      }
      
    } catch (Exception e) {
    } finally{
      request.getRequestDispatcher(url).forward(request, response);
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
