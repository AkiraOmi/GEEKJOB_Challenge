<%-- 
    Document   : Java_四則演算_課題
    Created on : 2017/05/17, 17:00:47
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            final int STATIC = 50;
            int variable = 30;
            out.print(STATIC + " と " + variable + "を足すと " + (STATIC + variable) + " になります。<br>");
            out.print(STATIC + " から " + variable + "を引くと " + (STATIC - variable) + " になります。<br>");
            out.print(STATIC + " に " + variable + "を掛けると " + (STATIC * variable) + " になります。<br>");
            out.print(STATIC + " を " + variable + "で割ると " + ((double)STATIC / (double)variable) + " になります。<br>");
        %>
    </body>
</html>
