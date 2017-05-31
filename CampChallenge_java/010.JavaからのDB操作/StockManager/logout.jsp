<%-- 
    Document   : logout
    Created on : 2017/05/31, 11:22:06
    Author     : guest1Day
--%>

<%-- これは「DB操作」の「在庫管理システムの作成」の課題です --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String status = (String)session.getAttribute("status"); // ログイン状態の取得
    if(!status.equals("login")){ // ログイン状態じゃなかった場合
        String loginError = "./login-error.jsp"; // ログインエラーページの設定
        RequestDispatcher rd = request.getRequestDispatcher(loginError);
        rd.forward(request,response);
    }else{
        session.invalidate(); // セッションを破棄する
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログアウト</title>
    </head>
    <body bgcolor="f5deb3">
        <h1>ログアウト完了</h1><br>
        <br>
        ログアウトが完了しました。<br>
        別アカウントでログインしたい場合はログインページへ、検索を終了する場合はこのページを閉じてください。<br>
        <br>
        <a href="./loginpage.jsp">ログインページへ戻る</a>
    </body>
</html>
