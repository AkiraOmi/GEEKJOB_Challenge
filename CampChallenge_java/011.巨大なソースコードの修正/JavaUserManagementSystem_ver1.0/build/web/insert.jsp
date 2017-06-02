<%@page import="jums.UserDataBeans"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%
    HttpSession hs = request.getSession();
    // 課題5の修正部分1
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("UDB");
    String udbname = udb.getName();
    System.out.print("デバッグ用ダミー");
    // 課題5の修正部分1ここまで
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insertconfirm" method="POST">
        <h1>登録情報入力フォーム</h1>
        <%-- 課題5の修正部分2 --%>
        名前:
        <input type="text" name="name" value="<%=udb.getName()%>">
        <br><br>

        生年月日:　
        <select name="year">
            <% if(!udb.getYear().equals("")){ %><option value="<%=udb.getYear() %>"><%=udb.getYear() %></option><% } %>
            <option value="">----</option>
            <%
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"> <%=i%> </option>
            <% } %>
        </select>年
        <select name="month">
            <% if(!udb.getMonth().equals("")){ %><option value="<%=udb.getMonth() %>"><%=udb.getMonth() %></option><% } %>
            <option value="">--</option>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <% if(!udb.getDay().equals("")){ %><option value="<%=udb.getDay() %>"><%=udb.getDay() %></option><% } %>
            <option value="">--</option>
            <%
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
        <input type="radio" name="type" value="1" <% if(udb.getType().equals("1") || udb.getType().equals("")) { %> checked <% } %>>エンジニア<br>
        <input type="radio" name="type" value="2" <% if(udb.getType().equals("2")){ %> checked <% } %>>営業<br>
        <input type="radio" name="type" value="3" <% if(udb.getType().equals("3")){ %> checked <% } %>>その他<br>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%=udb.getTell() %>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%=udb.getComment() %></textarea><br><br>
        <%-- 課題5の修正部分2ここまで --%>
        
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <%-- 課題1の修正部分 --%>
        <input type="submit" name="btnSubmit" value="確認画面へ">
        <%-- 課題1の修正部分ここまで --%>
    </form>
    <% request.setAttribute("UDB",udb); %>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
