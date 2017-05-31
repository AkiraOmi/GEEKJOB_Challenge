<%-- 
    Document   : command
    Created on : 2017/05/30, 11:34:38
    Author     : guest1Day
--%>

<%-- これは「DB操作」の「在庫管理システムの作成」の課題です --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String status = (String)session.getAttribute("status"); // ログイン状態の取得
    String account = ""; // アカウント名格納用変数
    if(!status.equals("login")){ // ログイン状態じゃなかった場合
        String loginError = "/login-error.jsp"; // ログインエラーページの設定
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
        <title>コマンド選択</title>
    </head>
    <body bgcolor="f5deb3">
        <h1>コマンド選択画面</h1><br>
        <br>
        現在のアカウント：<% out.println(account); %><br>
        <br>
        ご希望の操作を選択してください。<br>
        <a href="./register-input.jsp">商品の情報を登録する</a><br>
        <a href="./search-input.jsp">商品の情報を検索・閲覧する</a><br>
        <a href="./logout-confirm.jsp">ログアウトする</a>
    </body>
</html>
