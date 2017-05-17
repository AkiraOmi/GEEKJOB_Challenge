<%-- 
    Document   : Java_配列_課題
    Created on : 2017/05/17, 17:57:58
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>配列の作成と変更</title>
    </head>
    <body>
        <%@ page import="java.util.ArrayList" %>
        <%
            // 配列の作成
            ArrayList<String> data = new ArrayList<String>();
            
            // 配列に要素を追加
            data.add("10");
            data.add("100");
            data.add("soeda");
            data.add("hayashi");
            data.add("-20");
            data.add("118");
            data.add("END");
            out.print("要素変更前<br>");
            for(String element : data){
                out.print(element + " ");
            }
            out.print("<br>");
            data.set(2,"33");
            out.print("<br>要素変更後<br>");
            for(String element : data){
                out.print(element + " ");
            }
            
        %>
    </body>
</html>
