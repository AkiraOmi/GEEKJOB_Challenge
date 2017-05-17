<%-- 
    Document   : Java_for文1_課題
    Created on : 2017/05/17, 18:30:12
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>for文1</title>
    </head>
    <body>
        <%
            int res = 8;
            for(int i = 0;i < 18;i++){
                res *= 8;
            }
        %>
    </body>
</html>
