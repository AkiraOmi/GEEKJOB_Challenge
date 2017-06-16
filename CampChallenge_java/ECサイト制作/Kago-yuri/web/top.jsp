<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <%@page pageEncoding="UTF-8"%>
    
    <%
        HttpSession hs = request.getSession(true);
        
    %>
    
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>トップ - かごゆり</title>
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
                    <a class="navbar-brand" href="./top.jsp">かごゆり</a>
                </div>
                <div class="collapse navbar-collapse target">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="./top.html">ホーム画面へ</a></li>
                        <li><a href="">リンク2</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right" style="margin-right:20px">
                        <li><script type="text/javascript">login(<%=(String)hs.getAttribute("userName") %>);</script></li>
                    </ul>
                </div>
            </nav>
        </div>
        <div class="jumbotron">
            <div class="container">
                <h1>ECサイト「かごゆり」トップページ</h1>
                <p>ようこそ「かごゆり」へ！<br>ここは、購買欲をほどよく満たしてくれる(ただし現物は来ない)マネーフリーのECサイトです！</p>
            </div>
        </div>
        
        <div class="container" style="padding: 20px 0;">
            <form class="form-inline" action="Search" method="GET" onsubmit="return searchChk(this)">
                <div class="form-group">
                    <label class="control-label">商品ワード検索：</label>
                    <input type="text" id="search" name="query" class="form-control" style="width: 300px;" placeholder="検索ワードを入れてください">
                </div>
                <input type="submit" value="検索">
            </form>
        </div>
        
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <h2 class="text-info">「かごゆり」とは？</h2>
                    <p>「かごゆり」は、金銭の絡む決済は＜一切無し＞でショッピング風味の操作が楽しめる、言わばバーチャルショッピングサイトです。<br>
                     さまざまな商品を取り揃えてみましたので、あなたが買いたいと思っていた商品も見つかるかも？</p>  
                </div>
                <div class="col-md-4">
                    <h2 class="text-info">「かごゆり」のコンセプト</h2>
                    <p>『あれ買いたいけどお金がない…』<br>
                    『欲しいものがあるんだけど節約しなきゃ…』<br>
                    そんな風にして買いたいものを我慢しちゃうこと、ありますよね。でも、「かごゆり」なら大丈夫！<br>
                    商品を検索し、カートに入れて決済するだけでポンと買え(た気になっ)ちゃうお得サイトなのです。<br>
                    簡単なステップでお手軽に購買欲を満たせ(たっぽくな)るインスタント性をコンセプトにしております。</p>
                </div>
                <div class="col-md-4">
                    <h2 class="text-info">いや、このサイトなんなん？</h2>
                    <p>すみません、ここは完全なるジョークサイトです。<br>
                    わたくし、AkiraOmiがECサイト作成、及びBootstrap学習目的のために作った「模擬ECサイト」です。<br>
                    基本的な機能くらいしかありませんが、お暇であれば試してみてもらえると嬉しいです。</p>
                </div>
            </div>
        </div>
        
    </body>
</html>
