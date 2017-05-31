<%-- 
    Document   : ErrHandle8_Form
    Created on : 2017/05/26, 13:51:12
    Author     : guest1Day
--%>

<%-- これは「DB操作」の「特定のレコードの削除をするフォーム作成」の課題です --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除ID入力ページ</title>
    </head>
    <body bgcolor="f5deb3">
        <h1>削除ID入力フォーム</h1><br>
        <br>
        データベースから消したいデータのIDを入力してください<br>
        <form action="./ErrHandle10_Servlet" method="post">
        ID：<input type="text" name="deleteID"><br>
        <input type="submit" value="削除！">
        </form>
    </body>
</html>
