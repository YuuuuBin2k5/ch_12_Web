<%-- 
    Document   : index
    Created on : 27 Nov 2025, 12:33:45
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/main.css"/>
        <title>The SQL Gateway</title>
    </head>
    <body>
        <div class="container">
            <header>
                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <c:if test="${sqlStatement == null}">
                    <c:set var="sqlStatement" value="select * from User" />
                </c:if>

                <h1>The SQL Gateway</h1>
                <h2>Enter an SQL statement and click the Execute button.</h2>
            </header>
            
            <main>
                <p><b>SQL statement:</b></p>
                <form action="sqlGateway" method="post">
                   <textarea name="sqlStatement" cols="60" rows="8">${sqlStatement}</textarea>
                   <input type="submit" value="Execute">
                </form>
                   
                <p><b>SQL result:</b></p>
                ${sqlResult}
            </main>
            
        </div>
    </body>
</html>
