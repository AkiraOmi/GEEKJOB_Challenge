<%-- 
    Document   : logout
    Created on : 2017/05/31, 11:08:11
    Author     : guest1Day
--%>

<%-- これは「DB操作」の「在庫管理システムの作成」の課題です --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String status = (String)session.getAttribute("status"); // ログイン状態の取得
     String account = ""; // アカウント名格納用変数
    String output = null; // 結果出力文章
    if(!status.equals("login")){ // ログイン状態じゃなかった場合
        String loginError = "./login-error.jsp"; // ログインエラーページの設定
        RequestDispatcher rd = request.getRequestDispatcher(loginError);
        rd.forward(request,response);
    }else{
        account = (String)session.getAttribute("account"); // アカウント名受け取り
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログアウト確認</title>
    </head>
    <body bgcolor="f5deb3">
        <h1>ログアウト確認ページ</h1><br>
        <br>
        現在のアカウント：<% out.println(account); %><br>
        <br>
        現在のアカウントからログアウトします。よろしいですか？(「いいえ」の場合は機能選択ページへ戻ります)<br>
        <input type="button" onclick="location.href='./logout.jsp'" value="はい">　
        <input type="button" onclick="location.href='./command.jsp'" value="いいえ">
    </body>
</html>
