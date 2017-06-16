<%@page import="java.util.Map"%>
<%@page import="Kagoyume.DefUtil"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <%@page pageEncoding="UTF-8"%>
    
    <%
        HttpSession hs = request.getSession();
        int resultNum = (Integer)hs.getAttribute("resultNum");
        Map<String,Object> result = (Map<String,Object>)hs.getAttribute("result"); // 検索結果データ一覧
        Map<String,Object> hitData = (Map<String,Object>)(result.get((String)hs.getAttribute("hitNum"))); // 対象商品データ
        String hitName = hitData.get("Name").toString(); // 商品名
    %>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title><%=hitName %> - かごゆり</title>
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
        <!--tooltipとpopover用の記述-->
        <script>
            $(function(){
                $("[data-toggle=tooltip]").tooltip({
                    placement : 'bottom'
                });
            });
            $(function(){
                $("[data-toggle=popover]").popover();
            });
        </script>
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
        
        <div class="container">
            <h3 class="text-primary"><%=hitName %></h3>
        </div>
        <div class="container">
            <div class="row row-eq-height">
                <img class="col-sm-3" src="<%=((Map<String,Object>)(hitData.get("Image"))).get("Medium").toString() %>"/>
                <p class="text col-sm-offset-2 col-sm-7"><%=hitData.get("Description") %></p>
            </div>
        </div>
        <div class="container">    
            <p class="text-danger" style="padding : 10px 0;"><strong>￥ <%=((Map<String,Object>)(hitData.get("Price"))).get("_value").toString() %></strong></p>
        </div>
        
        <div class="container">
            <form action="Add" method="POST">
                <input type="submit" name="submitBtn" value="カートに入れる">
            </form>
        </div>
        
       
    </body>
</html>