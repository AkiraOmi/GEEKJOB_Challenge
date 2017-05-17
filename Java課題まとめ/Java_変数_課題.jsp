<%-- 
    Document   : Java_変数_課題
    Created on : 2017/05/17, 16:52:33
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String name = "近江亮";
            int age = 28;
            int height = 190;
            int weight = 83;
            String address = "神奈川県";
            out.print("初めまして。僕は " + name + "　と言います。<br>" + age + " 歳で " + height + " cm に "+ weight + " kg、住んでいるのは " + address + "です。");
        %>
    </body>
</html>
