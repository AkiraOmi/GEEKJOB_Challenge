<%-- 
    Document   : loginpage
    Created on : 2017/05/30, 10:27:42
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- これは「DB操作」の「在庫管理システムの作成」の課題です --%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログインページ</title>
    </head>
    <body bgcolor="f5deb3">
        <h1>在庫管理システムログインページ</h1><br>
        <br>
        <%
            Object loginError = session.getAttribute("loginError");
            if(loginError != null){ // ログインエラーでフォワードされていた場合
                 out.println("ログインに失敗しました。アカウント名もしくはパスワードが間違っている可能性があります。<br>");
                 out.println("<br>");
            }
        %>
        
        システムにログインします。<br>
        アカウント名とパスワードを入力してください。<br>
        <form action="./LoginCheck" method="post">
            アカウント名：<input type="text" name="accountName"><br>
            パスワード：<input type="text" name="password"><br>
            <input type="submit" value="送信！">
        </form><br>
    </body>
</html>
