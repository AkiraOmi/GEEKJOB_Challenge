<%-- 
    Document   : ErrHandle8_Form
    Created on : 2017/05/26, 13:51:12
    Author     : guest1Day
--%>

<%-- これは「DB操作」の「複合検索」の課題です --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>複合検索入力ページ</title>
    </head>
    <body bgcolor="f5deb3">
        <h1>複合検索入力フォーム</h1><br>
        <br>
        データベースからデータを検索します。キーデータを入力してください。<br>
        AND検索は「全ての条件を含む」データ、OR検索は「いずれかの条件を含む」データを検索します。<br>
        名前については部分検索が可能です。<br>
        <form action="./ErrHandle12_Servlet" method="post">
        <input type="radio" name="search" value="and" checked="checked">AND検索　
        <input type="radio" name="search" value="or">OR検索<br>
        名前：<input type="text" name="name"><br>
        年齢：<select name="age">
            <%
                for(int i = 15;i <= 80;i++){
                    out.println("<option value=\"" + i + "\">" + i + "</option>");
                }
            %></select><br>
        誕生日：<select name="birthyear">
            <%
                for(int i = 1936;i <= 2002;i++){
                    out.println("<option value=\"" + i + "\">" + i + "</option>");
                }
            %></select>
        年<select name="birthmonth">
                <%
                for(int i = 1;i <= 12;i++){
                    out.println("<option value=\"" + i + "\">" + i + "</option>");
                }
            %></select>
        月<select name="birthday">
            <%
                for(int i = 1;i <= 31;i++){
                    out.println("<option value=\"" + i + "\">" + i + "</option>");
                }
            %></select>    
        <input type="submit" value="検索！">
        </form>
    </body>
</html>
