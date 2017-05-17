<%-- 
    Document   : Java_連想配列_課題
    Created on : 2017/05/17, 18:14:08
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>連想配列</title>
    </head>
    <body>
        <%@ page import="java.util.*"%>
        
        <%
            // 連想配列の作成
            HashMap<String,String> data = new HashMap<String,String>();
            
            //要素を入れる
            data.put("1","AAA");
            data.put("hello","world");
            data.put("soeda","33");
            data.put("20","20");
            
            //要素の表示
            out.print("要素を表示します<br>");
            for(Map.Entry<String,String> con : data.entrySet()){
                out.print(con.getKey() + " に " + con.getValue() + "<br>");
            }
        %>
    </body>
</html>
