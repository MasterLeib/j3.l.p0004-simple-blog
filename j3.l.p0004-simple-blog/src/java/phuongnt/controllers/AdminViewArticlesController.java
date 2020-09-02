/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuongnt.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phuongnt.articles.ArticlesDAO;
import phuongnt.articles.ArticlesDTO;
import phuongnt.ultis.Ultis;

/**
 *
 * @author USER
 */
public class AdminViewArticlesController extends HttpServlet {

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
    String url = "admin_view_articles.jsp";
     try {
        String keyword = request.getParameter("search"); 
        String pageAsString = request.getParameter("page");
        int page = 0;
        if(pageAsString != null && !pageAsString.equals("")){
          page = Integer.parseInt(pageAsString) - 1;
        }
        ArticlesDAO dao = new ArticlesDAO();
        System.out.println("page"+page);
        
        ArrayList<ArticlesDTO> articles = dao.searchArticles(keyword, 20, page);
   
        int totalOfArticles = dao.countArticles(keyword);
        int totalOfPages = Ultis.convertToPages(totalOfArticles, 20);
                System.out.println("articles.size"+articles.size());                System.out.println("totalOfPages"+totalOfPages);

        System.out.println("totalOfArticles"+totalOfArticles);

        request.setAttribute("articles", articles);
        request.setAttribute("totalOfPages", totalOfPages);
    } catch (Exception e) {
      e.printStackTrace();
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
