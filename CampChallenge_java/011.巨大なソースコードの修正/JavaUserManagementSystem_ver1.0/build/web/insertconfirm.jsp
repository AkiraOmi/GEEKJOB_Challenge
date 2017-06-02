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
        <title>JUMS登録確認画面</title>
    </head>
    <body>
    <%-- 課題4修正部分 --%>
    <% if(!udb.getName().equals("") && !udb.getYear().equals("") && !udb.getMonth().equals("") && !udb.getDay().equals("") 
            && !udb.getType().equals("") && !udb.getTell().equals("") && !udb.getComment().equals("")){ %>
        <h1>登録確認</h1>
        名前:<%= udb.getName()%><br>
        生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
        種別:<% if(udb.getType().equals("1")){ %>エンジニア<% } %>
             <% if(udb.getType().equals("2")){ %>営業<% } %>
             <% if(udb.getType().equals("3")){ %>その他<% } %><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">
        </form>
    <% }else{ %>
        <h1>入力が不完全です</h1><br>
        <% if(udb.getName().equals("")){ %><font color="#FF0000">！</font>名前が入力されていません<br><% } %>
        <% if(udb.getYear().equals("")){ %><font color="#FF0000">！</font>生年月日の年が入力されていません<br><% } %>
        <% if(udb.getMonth().equals("")){ %><font color="#FF0000">！</font>生年月日の月が入力されていません<br><% } %>
        <% if(udb.getDay().equals("")){ %><font color="#FF0000">！</font>生年月日の日が入力されていません<br><% } %>
        <% if(udb.getType().equals("")){ %><font color="#FF0000">！</font>職業の種類が入力されていません<br><% } %>
        <% if(udb.getTell().equals("")){ %><font color="#FF0000">！</font>電話番号が入力されていません<br><% } %>
        <% if(udb.getComment().equals("")){ %><font color="#FF0000">！</font>自己紹介文が入力されていません<br><% } %>
        以上の部分が入力されていませんでした。入力をご確認の上、もう一度入力をし直してください。<br>
    <% } %>
    <%-- 課題4の修正部分ここまで --%>
        <form action="insert" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <br>
        <%-- 課題1の修正部分 --%>
        <%=JumsHelper.getInstance().home()%>
        <%-- 課題1の修正部分ここまで --%>
    </body>
</html>
