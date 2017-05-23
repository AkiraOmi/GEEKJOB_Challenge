<%-- 
    Document   : Java_HTMLDisp
    Created on : 2017/05/23, 15:51:26
    Author     : guest1Day
--%>

<%-- これは「入力内容の取得」の「HTMLタグについて」の課題です --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>確認ページ</title>
    </head>
    <body bgcolor="f5deb3">
        入力された内容を確認します。<br>
        <br>
        <br>
        <%
            request.setCharacterEncoding("UTF-8");
            out.print("名前：" + request.getParameter("userName") + "<br><br>");
            out.print("性別：" + request.getParameter("userSex") + "<br><br>");
            out.print("年齢：" + request.getParameter("userAge") + "<br><br>");
            out.print("どこで体験学習コースを知ったか：<br>" + request.getParameter("howToKnow"));
            String str = "";
            if((str = request.getParameter("howToKnowOther")) != ""){
                out.print(str);
                out.print("<br><br>");
            }
            out.print("参加理由：<br>" + request.getParameter("reason"));
            str = "";
            if((str = request.getParameter("reasonOther")) != ""){
                out.print(str);
                out.print("<br><br>");
            }
            out.print("満足したか：" + request.getParameter("satisfaction") + "<br><br>");
            out.print("〇〇コースに入会したいか：" + request.getParameter("entry") + "<br><br>");
            out.print("ご意見やご感想：<br>");
            str = "";
            if((str = request.getParameter("opinion")) != ""){
                out.print(str);
            }else{
                out.print("特になし");
            }
            out.print("<br><br><br>");
            out.print("以上の内容でよろしいですか？<br><br>");
        %>
        <input type="button" value="はい" onClick="document.location='./Java_HTMLEnd.jsp'">
        <input type="button" value="修正する" onClick="document.location='./Java_HTMLInput.jsp'">
    </body>
</html>
