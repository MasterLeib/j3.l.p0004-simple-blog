<%-- 
    Document   : search_articles.jsp
    Created on : Aug 16, 2020, 7:42:49 PM
    Author     : USER
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="MainController" method="GET">
            Search:<input type="text" name="search" placeholder="Input content">
            <input type ="submit" value="Search"/>
            <input type="hidden" name="action" value="SearchArticlesController">      
            <h1>List Articles</h1>
            <table border="1">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Title</th>
                        <th>Short Description</th>
                        <th>Email</th>
                        <th>Content</th>
                        <th>Date</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${articles}" var="article">
                        <tr>
                            <td>${article.id}</td>
                            <td>
                                <a href="ViewDetailArticle?id=${article.id}" >${article.title}</a>                           
                            </td>
                            <td>${article.shortDescrip}</td>
                            <td>${article.email}</td>
                            <td>${article.content}</td>
                            <td>${article.date}</td>
                            <td>${article.status}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>          
            <c:forEach begin="1" end="${totalOfPages}" var="i" >
                <input type="submit" name="page" value="${i}">
            </c:forEach>
        </form>
    </body>
</html>
