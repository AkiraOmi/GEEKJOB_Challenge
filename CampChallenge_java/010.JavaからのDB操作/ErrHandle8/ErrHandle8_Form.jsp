<%-- 
    Document   : ErrHandle8_Form
    Created on : 2017/05/26, 13:51:12
    Author     : guest1Day
--%>

<%-- これは「DB操作」の検索用フォームの用意と検索（部分一致）の課題です --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DBデータ入力ページ</title>
    </head>
    <body bgcolor="f5deb3">
        <h1>名前入力フォーム</h1><br>
        <br>
        データベースから名前を検索します。名前を入力してください<br>
        <form action="./ErrHandle8_Servlet" method="post">
        名前：<input type="text" name="searchName"><br>
        <input type="submit" value="検索！">
        </form>
    </body>
</html>
