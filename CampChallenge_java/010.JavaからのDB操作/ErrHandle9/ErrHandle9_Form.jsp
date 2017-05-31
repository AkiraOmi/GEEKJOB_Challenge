<%-- 
    Document   : ErrHandle8_Form
    Created on : 2017/05/26, 13:51:12
    Author     : guest1Day
--%>

<%-- これは「DB操作」の「フォームからデータを挿入」の課題です --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DBデータ入力ページ</title>
    </head>
    <body bgcolor="f5deb3">
        <h1>情報入力フォーム</h1><br>
        <br>
        追加したいデータの情報を入力してください<br>
        <form action="./ErrHandle9_Servlet" method="post">
            ＩＤ：<input type="text" name="id"><br>
            名前：<input type="text" name="name"><br>
            電話番号(11桁の数字でお願いします。ハイフンを入れてください)：<input type="text" name="tel"><br>
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
            <input type="submit" value="送信！">
        </form>
    </body>
</html>
