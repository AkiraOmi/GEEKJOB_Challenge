<%-- 
    Document   : Java_switch文_課題
    Created on : 2017/05/17, 17:19:17
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
            for(int i = 1;i <= 3;i++){
                switch(i){
                    case 1:
                        out.print("one<br>");
                        break;
                    case 2:
                        out.print("two<br>");
                        break;
                    default:
                        out.print("想定外<br>");
                        break;   
                }
            }
        %>
    </body>
</html>
