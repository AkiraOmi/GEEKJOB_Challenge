<%-- 
    Document   : Java_if文_課題
    Created on : 2017/05/17, 17:10:04
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
            for(int i = 1;i <= 5;i++){
                if(i == 1){
                    out.print("1です！<br>");
                }else if(i == 2){
                    out.print("プログラミングキャンプ！<br>");
                }else{
                    out.print("その他です！<br>");
                }
            }
        %>
    </body>
</html>
