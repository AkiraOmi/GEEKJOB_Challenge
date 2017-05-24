<%-- 
    Document   : Java_QStringFactorDisp
    Created on : 2017/05/24, 10:23:57
    Author     : guest1Day
--%>

<%-- これは「クエリストリング」の「素因数分解」の課題です --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>素因数分解結果表示</title>
    </head>
    <body bgcolor="f5deb3">
        <h1>素因数分解結果表示！</h1>
        あなたが入力した数値：
        <%
            out.print(request.getParameter("number"));
        %>
        <br>
        素因数一覧：
        <%
            // 素因数分解メソッド
            ArrayList<Integer> factor = new ArrayList<Integer>(); // 素因数格納用配列
            int num; // 初期値及び商
            try{
                num = Integer.parseInt(request.getParameter("number"));
                // それぞれ素因数で割っていく
                while(num % 2 == 0){
                    num /= 2;
                    factor.add(2);
                }
                while(num % 3 == 0){
                    num /= 3;
                    factor.add(3);
                }
                while(num % 5 == 0){
                    num /= 5;
                    factor.add(5);
                }
                while(num % 7 == 0){
                    num /= 7;
                    factor.add(7);
                }
                for(int value : factor){
                    out.print(value + " ");
                }
                out.print("<br>");
                // もし商が2桁だったら余りを表示する
                if(num >= 11){
                    out.print("余った値：" + num);
                }
            }catch(NumberFormatException e){
                out.print(e);
            }
        %>
        <br>
        <br>
        以上で素因数分解を終了します。<br>
        <input type="button" value="もう一度やってみる！" onClick="document.location='./Java_QStringFactorInput.jsp';">
    </body>
</html>
