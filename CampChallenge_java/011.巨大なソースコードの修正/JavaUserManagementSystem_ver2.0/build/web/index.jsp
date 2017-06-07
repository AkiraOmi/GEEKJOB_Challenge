<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JUMSトップ</title>
</head>
<%-- 修正部分 --%>
<%-- セッションリフレッシュ部分をindexに変更。update等操作結果表示後もsessionを利用する場合があるため --%>

<%
    HttpSession hs = request.getSession();
    if(hs != null){
        hs.invalidate();
    }
%>
<body>
    <h1>ユーザー情報管理トップ</h1><br>
    <h3>ここでは、ユーザー情報管理システムとしてユーザー情報の登録や検索、
        付随して修正や削除を行うことができます</h3><br>
    <a href="insert">新規登録</a><br>
    <a href="Search" >検索(修正・削除)</a><br>
</body>
</html>
