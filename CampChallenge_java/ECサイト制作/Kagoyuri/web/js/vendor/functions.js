/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function login(str){
    if(hs === null){
        document.write('<a href="Login?status=logout">ログイン</a>');
    }else{
        document.write('<span class="text-muted">ようこそ<a href="./MyPage">' + str + '</a>さん / <a href="Login?status=login">ログアウト</a> /<a href="MyCart">買い物かご</a></span>');
    }
}

function searchChk(form){
    if(form.elements["searchWord"].value === ""){
        alert("検索ワードを入力してください！");
        return false;
    }else{
        return true;
    }
}

function loginChk(form){
    if(form.elements["userName"].value === ""){
        alert("ユーザー名が入力されていません！");
        return false;
    }else if(form.elements["password"].value === ""){
        alert("パスワードが入力されていません！");
        return false;
    }else{
        return true;
    }
}

function getJson(urlStr){
    if(urlStr !== null){
        document.write(urlStr);
        $.getJSON(urlStr,function(data){
            document.write("入ってるよ");
            document.write(data.ResultSet.totalResultsAvailable);
        });
    }
}