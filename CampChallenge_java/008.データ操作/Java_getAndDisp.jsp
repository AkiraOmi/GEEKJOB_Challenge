<%-- 
    Document   : Java_getAndDisp
    Created on : 2017/05/23, 14:41:35
    Author     : guest1Day
--%>

<%-- これは「入力内容の取得」の「HTMLの入力データの取得と表示」の課題です--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>送信結果を表示</title>
    </head>
    <body>
        画面に送信結果を表示します<br><br>
        <%
            request.setCharacterEncoding("UTF-8");
            out.print("名前：" + request.getParameter("txtName") + "<br>");
            out.print("性別：" + request.getParameter("rdoSex") + "<br>");
            out.print("趣味：" + request.getParameter("hobby") + "<br>");
        %>
    </body>
</html>
