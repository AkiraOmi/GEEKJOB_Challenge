<%-- 
    Document   : Java_QStringItemInput
    Created on : 2017/05/23, 17:14:37
    Author     : guest1Day
--%>

<%-- これは「クエリストリング」の「クエリストリングの利用」の課題です --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品等入力ページ</title>
    </head>
    <body bgcolor="f5deb3">
        必要な情報を入力してください。<br>
        <br>
        <form action="./Java_QStringItemDisp.jsp" method="get">
            総額：<input type="text" name="total"><br>
            個数：<input type="text" name="count"><br>
            商品の種類：<input type="radio" name="kind" value="1">雑貨 <input type="radio" name="kind" value="2">生鮮食品 <input type="radio" name="kind" value="3">その他<br>
            <input type="submit" value="送信する">
        </form>
    </body>
</html>
