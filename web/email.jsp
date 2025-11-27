<%-- 
    Document   : email
    Created on : 27 Nov 2025, 14:52:56
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/main.css"/>
        <title>Mail Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Join our email list</h1>
        <p>To join our email list, enter your name and
           email address below.</p>
        <div class="title">TODO write content</div>
            <p>${message}</p>
            <form action="emailList" method="post">
                <input type="hidden" name="action" value="add">
                

                <label>Email:</label>
                <input type="email" name="email" required><br>

                <label>First Name:</label>
                <input type="text" name="firstName" required><br>

                <label>Last Name:</label>
                <input type="text" name="lastName" required><br>

                <label>&nbsp;</label>
                <input type="submit" value="Join Now" id="submit">
            </form>
        </div>
    </body>
</html>
