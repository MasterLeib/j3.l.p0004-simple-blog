<%-- 
    Document   : post_article
    Created on : Aug 22, 2020, 10:51:36 AM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Post Article</title>
    </head>
    <body>
        <h1>Post Article</h1>
        <form action="MainController" method="GET">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Title</td>
                        <td><input type="text" name="title"></td>
                    </tr>
                    <tr>
                        <td>Short Description</td>
                        <td><input type="text" name="shortDes"></td>
                    </tr>
                    <tr>
                        <td>Content</td>
                        <td><input type="text" name="content"></td>
                    </tr>
                </tbody>            
            </table>
            <br/>
            <input type="submit" value="Post">
            <input type="hidden" name="action" value="PostArticleController"/>
        </form>
    </body>
</html>
