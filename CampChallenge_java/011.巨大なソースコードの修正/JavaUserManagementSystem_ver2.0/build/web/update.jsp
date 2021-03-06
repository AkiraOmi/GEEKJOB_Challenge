<%@page import="org.joda.time.DateTime"%>
<%@page import="jums.UserDataDTO"%>
<%@page import="jums.JumsHelper" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("detailData");
    DateTime dt = new DateTime(udd.getBirthday());
%>

<%-- resultdetailからの値が保持されるように修正 --%>
<%-- 直リンク禁止用の変数acをリクエストで受け渡すように修正 --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新画面</title>
    </head>
    <body>
    <form action="UpdateResult" method="POST">
        名前:
        <input type="text" name="name" value="<%=udd.getName() %>">
        <br><br>

        生年月日:　
        <select name="year">
            <option value="">----</option>
            <% for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>" <% if(dt.getYear() == i){ out.print("selected=\"selected\""); } %>><%=i%></option>
            <% } %>
        </select>年
        <select name="month">
            <option value="">--</option>
            <% for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>" <% if(dt.getMonthOfYear() == i){ out.print("selected=\"selected\""); } %>><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <% for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>" <% if(dt.getDayOfMonth() == i){ out.print("selected=\"selected\""); } %>><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
            <% for(int i = 1; i<=3; i++){ %>
            <input type="radio" name="type" value="<%=i%>" <% if(udd.getType() == i){ out.print("checked"); } %>><%=jh.exTypenum(i)%><br>
            <% } %>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%=udd.getTell() %>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%=udd.getComment() %></textarea><br><br>
        
        <input type="hidden" name="ac" value="<%=hs.getAttribute("ac") %>">
        
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
    <br>
    <%=jh.detail(udd.getUserID())%><br>    
        <%=jh.home()%>
    </body>
</html>
