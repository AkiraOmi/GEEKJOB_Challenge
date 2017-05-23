<%-- 
    Document   : Java_input
    Created on : 2017/05/23, 14:01:39
    Author     : guest1Day
--%>

<%-- これは「入力内容の取得」の「入力フィールド」の課題です --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> コントロールテスト</title>
    </head>
    <body>
        <form action="./Java_getAndDisp.jsp" method="post">
            名前：<input type="text" name="txtName"><br>
            男性：<input type="radio" name="rdoSex" value="男性"><br>
            女性：<input type="radio" name="rdoSex" value="女性"><br>
            趣味：<textarea name="hobby" rows="10" cols="30"></textarea><br>
            <input type="submit" name="submitBtn">
        </form>
    </body>
</html>
