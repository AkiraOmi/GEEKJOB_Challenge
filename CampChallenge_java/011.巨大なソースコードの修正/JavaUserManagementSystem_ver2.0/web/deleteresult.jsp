
<%@page import="jums.JumsHelper"%>
<%@page import="jums.UserDataDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- 何も中身がないので全て作成 --%>
<%-- DeleteResultから削除したデータを受け取り、それを表示する --%>

<%
    HttpSession hs = request.getSession();
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO udd = (UserDataDTO)request.getAttribute("deleteData");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除結果画面</title>
    </head>
    <body>
    <h1>削除完了</h1>
    <%--以下のデータを--%>削除しました。<br>
    <%-- 名前：<%=udd.getName() %><br>
    生年月日：<%=udd.getBirthday() %><br>
    種別：<%=jh.exTypenum(udd.getType()) %><br>
    自己紹介文：<%=udd.getComment() %><br>
    更新日時：<%=udd.getName() %><br>
    名前：<%=udd.getNewDate() %><br>--%>
    <br>
    <form action="SearchResult" method="POST">
            <input type="hidden" name="ac" value="<%=hs.getAttribute("ac") %>">
            <input type="submit" name="SrBackBtn" value="検索結果一覧に戻る" style="width:150px">
        </form><br>
    <%=jh.home() %>
    </body>
</html>
