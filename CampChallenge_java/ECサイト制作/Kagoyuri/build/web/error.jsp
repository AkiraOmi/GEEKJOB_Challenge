<%-- 
    Document   : error
    Created on : 2017/06/14, 16:05:23
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
%>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>エラー - かごゆり</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <style>
            body {
                padding-top: 50px;
                padding-bottom: 20px;
            }
        </style>
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/main.css">
        
        <script src="js/vendor/jquery-1.11.2.min.js"></script>
        <script src="js/vendor/bootstrap.min.js"></script>
        <script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
        <script src="js/vendor/functions.js"></script>
    </head>
    
    <body>
        <div class="container">
            <nav class="navbar navbar-inverse navbar-fixed-top">
                <div class="navbar-header">
                    <button class="navbar-toggle" data-toggle="collapse" data-target=".target">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="./top.html">かごゆり</a>
                </div>
                <div class="collapse navbar-collapse target">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="./top.html">ホーム画面へ</a></li>
                        <li><a href="">リンク2</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right" style="margin-right:20px">
                        <li><script type="text/javascript">login("近江");</script></li>
                    </ul>
                </div>
            </nav>
        </div>
        
        <h2>エラー</h2><br>
        エラーが発生しました。内容は以下をご覧ください。<br>
        <br>
        エラー：<%=request.getAttribute("error") %>
        
    </body>
</html>
