<%-- 
    Document   : confirm_email
    Created on : Sep 2, 2020, 2:51:30 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Email</title>
    </head>
    <body>
        <h1>Confirm Email</h1>
        <form action="MainController" method="GET">
        <input type="text" name="randomCode"/>
        <input type="submit" value="Enter"/>
        <input type="hidden" name="action" value="ConfirmEmailController"/>
        </form>
    </body>
</html>
