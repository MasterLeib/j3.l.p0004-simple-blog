<%-- 
    Document   : login
    Created on : Aug 8, 2020, 12:20:04 PM
    Author     : USER
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <style>
            .error {
                color: red;
            }
            .success{
                color: green;
            }
        </style>
    </head>
    <body>
        <h1>Login Page</h1><br/>
        <form action="MainController" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                <span class="success">
                    ${successMsg}
                </span>
                        <td>Email</td>
                        <td><input type="email" name="email" value="${email}"/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password"/></td>
                    </tr>
                </tbody>
            </table>
                        <span class="error">
                        ${errorMsg}<br/>
                        </span>
            <input type="submit" value="Login"/>            
            <input type="hidden" name="action" value="LoginController"/>
            <a href="registration.jsp">Sign up</a>
            
        </form>
        
    </body>
</html>
