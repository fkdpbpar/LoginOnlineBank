<%-- 
    Document   : index
    Created on : 22-Apr-2020, 14:53:59
    Author     : mac
--%>

<%@page import="models.UserLogin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Bank</title>
    </head>
    <body>
        <h1>Welcome to Online Bank!</h1>
        <form action="index.jsp" method="POST">
            <p>Username : <input type="text" name="username"></p>
            <p>Password : <input type="password" name="password"></p>
            <p><button type="submit">Login</button>
        </form>
        <%
            String username = request.getParameter("username");
            String password = "qqq"; //request.getParameter("password");
            out.print("Method :" + request.getMethod());
            if(username != null && password != null && request.getMethod().equals("POST")) {
                UserLogin ul = new UserLogin(username, password);
                request.setAttribute("user", ul);
                RequestDispatcher rd = request.getRequestDispatcher("login");
                rd.forward(request, response);
            }
            
        %>
    </body>
</html>
