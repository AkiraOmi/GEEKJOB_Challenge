<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <%@page pageEncoding="UTF-8"%>
    <%
        HttpSession hs = request.getSession();
        String status = (String)hs.getAttribute("status"); // 状態の受け取り
        in num = 1;
        
        public boolean isLogin(String status){
            if(status.equals("login")){
                return true;
            }else{
                return false;
            }
        }
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
        <% !if(isLogin(status)){ %>
        <div class="container">
            <h2 class="text text-primary">ログインページ</h2>
            <p>ユーザー名とパスワードを入力し、ログインをしてください。</p>
            <form class="form-horizontal" action="LoginConfirm" method="POST" onsubmit="loginChk(this)">
                <label class="control-label" >ユーザー名</label>
                <input type="text" id="name" name="userName" class="form-control" style="width: 300px;" placeholder="ユーザー名">
                <input type="text" id="pass" name="password" class="form-control" style="width: 300px;" placeholder="パスワード">
                <input type="submit" value="ログイン">
                </form>
        </div>
        <% } %>
        <div class="container">
            <h2 class="text text-primary">ログアウトページ</h2>
            <p>現在のアカウント情報です。ログアウトしてよろしいですか？</p>
            <form class="form-horizontal" action="./logout.html" method="POST">
                <label class="control-label" >ユーザー名</label>
                <input type="text" id="name" name="userName" class="form-control" style="width: 300px;" placeholder="ユーザー名">
                <input type="text" id="pass" name="password" class="form-control" style="width: 300px;" placeholder="パスワード">
                <input type="submit" value="はい">
            </form><br>
            <form action="" method="POST">
                <input type="submit" value="直前のページに戻る">
            </form>
        </div>
        
    </body>
</html>
