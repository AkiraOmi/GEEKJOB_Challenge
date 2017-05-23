<%-- 
    Document   : Java_HTMLInput
    Created on : 2017/05/23, 15:01:18
    Author     : guest1Day


<%-- これは「入力内容の取得」の「HTMLタグについて」の課題です --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>アンケート入力フォーム</title>
    </head>
    <body bgcolor="f5deb3">
        <font size="7" color="800000" face="fantasy">〇〇コース学習体験感想入力フォーム</font><br>
        本日は学習体験にお越しいただきましてありがとうございました！<br>
        もしよろしければ以下のアンケートにお答えください。<br>
        <br>
        <br>
        <form action="./Java_HTMLDisp.jsp" method="post">
        名前：<input type="text" name="userName"><br>
        性別：<input type="radio" name="userSex" value="男性">男性 <input type="radio" name="userSex" value="女性">女性<br>
        年齢：<select name="userAge">
            <option value="15歳以下">15歳以下</option>
            <option value="16～19歳">16～19歳</option>
            <option value="20～24歳">20～24歳</option>
            <option value="25～29歳">25～29歳</option>
            <option value="30～34歳">30～34歳</option>
            <option value="35～39歳">35～39歳</option>
            <option value="40～44歳">40～44歳</option>
            <option value="45～49歳">45～49歳</option>
            <option value="50～54歳">50～54歳</option>
            <option value="55～59歳">55～59歳</option>
            <option value="60歳以上">60歳以上</option>
        </select>
        <br>
        <br>
        どちらでこの体験学習を知りましたか？<br>
        <input type="radio" name="howToKnow" value="外で広告を見た">外で広告を見た <input type="radio" name="howToKnow" value="HPを見た">HPを見た<br>
        <input type="radio" name="howToKnow" value="紙面の広告を見た">紙面の広告を見た <input type="radio" name="howToKnow" value="ブログやSNSで情報を見た">ブログやSNSで情報を見た<br>
        <input type="radio" name="howToKnow" value="人から勧められた">人から勧められた<input type="radio" name="howToKnow" value="その他">その他<input type="text" name="howToKnowOther"><br>
        <br>
        この体験学習にご参加いただいた理由は何ですか？(複数回答可)<br>
        <input type="checkbox" name="reason" value="以前から参加してみたかったから">以前から内容が気になっていたから<br>
        <input type="checkbox" name="reason" value="無料で体験学習ができるから">無料で体験学習ができるから<br>
        <input type="checkbox" name="reason" value="人から勧められたから">人から勧められたから<br>
        <input type="checkbox" name="reason" value="広告を見て興味を持ったから">広告を見て興味を持ったから<br>
        <input type="checkbox" name="reason" value="他のスクールと比較をしたかったから">他のスクールと比較をしたかったから<br>
        <input type="checkbox" name="reason" value="その他">その他<input type="text" name="reasonOther"><br>
        <br>
        実際に体験してみて、内容に満足しましたか？<br>
        <input type="radio" name="satisfaction" value="非常に満足">非常に満足<br>
        <input type="radio" name="satisfaction" value="やや満足">やや満足<br>
        <input type="radio" name="satisfaction" value="どちらでもない">どちらでもない<br>
        <input type="radio" name="satisfaction" value="やや不満">やや不満<br>
        <input type="radio" name="satisfaction" value="非常に不満">非常に不満<br>
        <br>
        〇〇コースへ、実際に入会してみたいと思いましたか？<br>
        <input type="radio" name="entry" value="是非入会したい">是非入会したい<br>
        <input type="radio" name="entry" value="やや入会したい">やや入会したい<br>
        <input type="radio" name="entry" value="どちらでもない">どちらでもない<br>
        <input type="radio" name="entry" value="あまり入会したくない">あまり入会したくない<br>
        <input type="radio" name="entry" value="入会したくない">入会したくない<br>
        <br>
        その他、「これが良かった！」「これがちょっと…」など、ご意見やご感想がありましたら是非教えてください。<br>
        <textarea name="opinion" cols="30" rows="10"></textarea><br>
        <br>
        <input type="submit" name="submitBtn" value="送信する">
        </form>
    </body>
</html>
