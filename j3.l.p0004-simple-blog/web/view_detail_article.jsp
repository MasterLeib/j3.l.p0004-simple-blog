<%-- 
    Document   : view_detail_article
    Created on : Aug 22, 2020, 10:13:21 AM
    Author     : USER
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Detail Article</title>
    </head>
    <body>
        <h1>View Detail Article</h1>
        <table border="1">          
            <tbody>
                <tr>
                    <td>Title</td>
                    <td>${article.title}</td>
                </tr>
                <tr>
                    <td>Short Description</td>
                    <td>${article.shortDescrip}</td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td>${article.email}</td>
                </tr>
                <tr>
                    <td>Content</td>
                    <td>${article.content}</td>
                </tr>
                <tr>
                    <td>Date</td>
                    <td>${article.date}</td>

                </tr>
            </tbody>
        </table>
        <br/>
        <form action="CommentController" method="GET">
            <table border="1">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Comment</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${comments}" var="comment">
                        <tr>
                        <td>${comment.email}</td>                        
                        <td>${comment.content}</td>
                    </tr>
                    </c:forEach>
                    
                </tbody>
            </table>
            <br/>
            <label>Comment:</label>
            <textarea name="content"></textarea><br/>
            <input type="hidden" name="articleId" value="${article.id}">
            <input type="submit" value="Post">
        </form>

    </body>
</html>
