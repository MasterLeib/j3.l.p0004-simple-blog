<%-- 
    Document   : _navbar
    Created on : Aug 19, 2020, 8:52:46 PM
    Author     : USER
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .between {
                display: flex; justify-content: space-between
            }
        </style>
    </head>
    <body>
        <div class="between">
            <div>
                <b>Hello ${sessionScope.name}</b>
            </div>     
            <div>
                <form action="MainController" method="GET">
                    <input type="submit" value="Logout"/>
                    <input type="hidden" name="action" value="LogoutController"/>           
                </form>
            </div>
        </div>
    </body>
</html>
