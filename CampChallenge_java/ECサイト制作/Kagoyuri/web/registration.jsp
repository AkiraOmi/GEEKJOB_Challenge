<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <%@page pageEncoding="UTF-8"%>
    <%!
        public boolean isLogin(String status){
            if(status.equals("login")){
                return true;
            }else{
                return false;
            }
        }
    %>
    <%
        HttpSession hs = request.getSession();
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
                        <li><a href="./top.jsp">ホーム画面へ</a></li>
                        <li><a href="">リンク2</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right" style="margin-right:20px">
                        <li><script type="text/javascript">login("近江");</script></li>
                    </ul>
                </div>
            </nav>
        </div>
        <div class="container">
            <h2 class="text text-primary">新規登録フォーム</h2>
            <p>以下の情報を入力し、新規登録を行ってください。<br>
            入力項目が不足していると登録が行えませんので、すべての項目を埋めてください。</p>
            <form class="form-horizontal" action="LoginConfirm" method="POST">
                <div class="form-group">
                    <label class="control-label" >ユーザー名</label>
                    <input type="text" id="name" name="userName" class="form-control" style="width: 300px;" placeholder="ユーザー名">
                </div>
                <div class="form-group">
                    <label class="control-label" >パスワード</label>
                    <input type="text" id="pass" name="password" class="form-control" style="width: 300px;" placeholder="パスワード">
                </div>
                <div class="form-group">
                    <label class="control-label" >メールアドレス</label>
                    <input type="text" id="pass" name="mailAddress" class="form-control" style="width: 300px;" placeholder="メールアドレス">
                </div>
                <div class="form-group">
                    <label class="control-label" >住所</label>
                    <input type="text" id="pass" name="address" class="form-control" style="width: 300px;" placeholder="住所">
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary" value="新規登録">
                </div>
             </form><br>
        </div>
    </body>
</html>
