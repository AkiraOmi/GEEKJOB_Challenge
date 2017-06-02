<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("UDB");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <h1>登録結果</h1><br>
        <% if(!udb.getName().equals("")){ %>
        名前:<%= udb.getName()%><br>
        生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
        種別:<%= udb.getType()%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        以上の内容で登録しました。<br>
        <br>
        <% hs.invalidate(); %>
        <% }else{ %>
        何らかの原因でデータが登録されませんでした。<br>
        お手数ですが、もう一度入力をお願いします。<br>
        <form action="insert" method="post">
            <input type="submit" value="入力フォームへ戻る">
            </form>
        <br>
        <% } %>
        <%-- 課題7の修正部分 --%>
        <%-- 課題7の修正部分ここまで --%>
        <%-- 課題1の修正部分 --%>
        <%=JumsHelper.getInstance().home()%>
        <%-- 課題1の修正部分ここまで --%>
    </body>
</html>
