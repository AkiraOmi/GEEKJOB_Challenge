<%-- 
    Document   : search-input
    Created on : 2017/05/30, 19:21:58
    Author     : guest1Day
--%>

<%-- これは「DB操作」の「在庫管理システムの作成」の課題です --%>

<%@page import="StockManager.SearchBeans"%>
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
        SearchBeans sb = (SearchBeans)request.getAttribute("BEANS"); // SearchCheckからのBeansデータ受け取り
        // それぞれの値を受け取り
        if(sb != null){
        output = sb.getOutput();
        }
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品検索</title>
    </head>
    <body bgcolor="f5deb3">
        <h1>商品情報検索ページ</h1><br>
        <br>
        現在のアカウント：<% out.println(account); %><br>
        <br>
        <%
            if(output != null){
                if(output.equals("")){ // 検索がヒットしていない場合
                    out.println("お探しのデータは見つかりませんでした。続けて検索を行う場合は、以下から操作を行ってください。<br>");
                }else{ // ヒットしていた場合
                    out.println("検索結果は以下のようになりました。<br><br>");
                    out.println(output); // 結果の出力
                }
                out.println("<br>");
            }
        %>
        商品の情報を検索します。<br>
        全ての商品の情報を見たい場合は「全検索」ボタンを、検索条件がある場合はそれを入力して検索を行ってください。<br>
        <br>
        <form action="./SearchCheck" method="post">
            <input type="radio" name="searchMethod" value="all" checked>全検索<br>
            <input type="radio" name="searchMethod" value="condition">条件検索(こちらの場合はAND検索かOR検索かが選択可能です　
            <input type="radio" name="methodMode" value="AND" checked>AND検索　<input type="radio" name="methodMode" value="OR">OR検索<br>
            商品名(部分検索可)：<input type="text" name="itemName"><br>
            商品の種類(複数選択可)：<input type="checkbox" name="itemType" value="1">トップス 
            <input type="checkbox" name="itemType" value="2">ボトムス 
            <input type="checkbox" name="itemType" value="3">ハット 
            <input type="checkbox" name="itemType" value="4">シューズ<br>
            <input type="submit" value="条件を送信">
        </form><br>
        <br>
        <a href="./command.jsp">機能選択ページに戻る</a><br>
        <a href="./logout-confirm.jsp">ログアウトする</a>
    </body>
</html>
