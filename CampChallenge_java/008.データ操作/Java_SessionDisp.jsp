<%-- 
    Document   : Java_SessionDisp
    Created on : 2017/05/24, 14:16:27
    Author     : guest1Day
--%>

<%@page import="org.session.SessionData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>セッション保持確認ページ</title>
    </head>
    <body>
        <h1>セッション保持を確認するためのページ！</h1><br>
        <br>
        セッションの保持を見るためのページです。<br>
        <br>
        <%
            request.setCharacterEncoding("UTF-8"); // 文字コード指定
            // セッションの取得
            HttpSession hs = request.getSession();
            hs.setAttribute("name",request.getParameter("name"));
            hs.setAttribute("sex",request.getParameter("sex"));
            hs.setAttribute("hobby",request.getParameter("hobby"));
            if(hs.getAttribute("name") == null){
                out.println("初回アクセスのようです。次回から入力が反映されます！<br>");
            }else{
                out.println("名前：" + hs.getAttribute("name") + "<br>");
                out.println("性別：" + hs.getAttribute("sex") + "<br>");
                out.println("趣味：" + hs.getAttribute("hobby") + "<br>");
            }
        %>
        <br>
        <br>
        情報入力用のフォームです。こちらで入力された情報が次回アクセス時に反映されます<br>
        <form action="Java_SessionDisp.jsp" method="post">
            名前：<input type="text" name="name"><br>
            性別：<input type="radio" name="sex" value="男性">男性 <input type="radio" name="sex" value="女性">女性<br>
            趣味：<textarea rows="10" cols="30" name="hobby"></textarea><br>
            <input type="submit" value="送信する">
        </form>
    </body>
</html>
