<%-- 
    Document   : Java_for文2_課題
    Created on : 2017/05/17, 18:36:03
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>for文2</title>
    </head>
    <body>
        <%
            String str = "";
            for(int i = 0;i < 30;i++){
                str += "A";
            }
            out.print(str + "<br>長さは " + str.length() + " です");
        %>
    </body>
</html>
