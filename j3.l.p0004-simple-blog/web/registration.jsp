
<%-- 
    Document   : registration
    Created on : Aug 7, 2020, 8:57:29 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <h1>Registration</h1>
        <form action="MainController" method="POST" >
            <table border="0">
                <tbody>
                    <tr>
                        <td>Email:</td>
                        <td><input type="email" name="email" value="${email}"></td>
                        <td>${errorMsg}</td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password" id="password"></td>
                    </tr>
                    <tr>
                        <td>Confirm Password:</td>
                        <td><input type="password" id="confirmedPassword"></td>
                    </tr>
                </tbody>
            </table>
            <br/>
            <input type="submit" value="Sign up" onclick="comparedPassword(event)">
            <input type="hidden" name="action" value="RegisterController"/>
        </form>
    </body>
    <script>
        const password = document.getElementById("password")
        const confirmedPassword = document.getElementById("confirmedPassword")
        function comparedPassword(event) {
            if (password.value != confirmedPassword.value) {
                alert("Not Match")
                event.preventDefault()
            }
        }

    </script>
</html>
