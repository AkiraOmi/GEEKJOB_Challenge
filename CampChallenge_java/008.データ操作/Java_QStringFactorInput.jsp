<%-- 
    Document   : Java_QStringFactorInput
    Created on : 2017/05/24, 9:59:16
    Author     : guest1Day
--%>

<%-- これは「クエリストリング」の「素因数分解」の課題です --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>素因数分解数値入力</title>
    </head>
    <body bgcolor="f5deb3">
        <h1>素因数分解</h1><br>
        素因数分解を行います。数値を入力してください。<br>
        入力された数値は1桁の素因数でのみ分解されます。2桁の素因数では分解されないので注意してください。<br>
        <form action="./Java_QStringFactorDisp.jsp" method="get">
            数値：<input type="text" name="number"><br>
            <input type="submit" value="送信する！">
        </form>
    </body>
</html>
