<%-- 
    Document   : Java_for文3_課題
    Created on : 2017/05/17, 18:39:56
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>for文3</title>
    </head>
    <body>
        <%
            int sum = 0;
            for(int i = 1;i <= 100;i++){
                sum += i;
            }
            out.print("1から100まで全て足すと " + sum + " になります");
        %>
    </body>
</html>
