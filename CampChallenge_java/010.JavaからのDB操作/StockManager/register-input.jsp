<%-- 
    Document   : resister-input
    Created on : 2017/05/30, 13:27:14
    Author     : guest1Day
--%>

<%-- これは「DB操作」の「在庫管理システムの作成」の課題です --%>

<%@page import="StockManager.RegisterBeans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String status = (String)session.getAttribute("status"); // ログイン状態の取得
    String account = ""; // アカウント名格納用変数
    boolean isRightName = true; // 名前が正しいかの判定
    boolean isRightPrice = true; // 価格が正しいかの判定
    boolean isRightStock = true; // 在庫が正しいかの判定
    String output = ""; // 結果出力文章
    if(!status.equals("login")){ // ログイン状態じゃなかった場合
        String loginError = "login-error.jsp"; // ログインエラーページの設定
        RequestDispatcher rd = request.getRequestDispatcher(loginError);
        rd.forward(request,response);
    }else{
        account = (String)session.getAttribute("account"); // アカウント名受け取り
        RegisterBeans rb = (RegisterBeans)request.getAttribute("BEANS"); // RegisterCheckからのBeansデータ受け取り
        // それぞれの値を受け取り
        if(rb != null){
        isRightName = rb.getIsRightName();
        isRightPrice = rb.getIsRightPrice();
        isRightStock = rb.getIsRightStock();
        output = rb.getOutput();
        }
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品登録</title>
    </head>
    <body bgcolor="f5deb3">
        <h1>商品情報登録ページ</h1><br>
        <br>
        現在のアカウント；<% out.println(account); %><br>
        <br>
        <%
            if(!output.equals("")){ // outputに何か入った場合
                out.println(output);
                out.println("<br>");
            }
        %>
        登録したい商品の情報を入力してください。<br>
        <form action="./RegisterCheck" method="post">
            商品名：<input type="text" name="itemName">
            <%
                if(!isRightName){ // 名前が正しくなくて返された場合
                    out.println("<font color=\"#ff0000\">！</font>　名前の入力が不正でした。名前を正しく入力してください");
                }
            %><br>
            商品の種類：<select name="itemType">
                <option value="1">トップス</option>
                <option value="2">ボトムス</option>
                <option value="3">ハット</option>
                <option value="4">シューズ</option>
                </select><br>
            価格：<input type="text" name="itemPrice">　
            <%
                if(!isRightPrice){ // 価格が正しくなくて返された場合
                    out.println("<font color=\"#ff0000\">！</font>　価格の入力が不正でした。数値を正しく入力してください");
                }
            %><br>
            在庫：<input type="text" name="itemStock">
            <%
                if(!isRightStock){ // 価格が正しくなくて返された場合
                    out.println("<font color=\"#ff0000\">！</font>　在庫の入力が不正でした。数値を正しく入力してください");
                }
            %><br>
            <input type="submit" value="登録！">
        <br>
        <br>
        <a href="./command.jsp">機能選択ページに戻る</a><br>
        <a href="./logout-confirm.jsp">ログアウトする</a>
    </body>
</html>
