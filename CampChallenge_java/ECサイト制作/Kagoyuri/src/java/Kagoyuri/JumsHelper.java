package Kagoyuri;

import java.util.ArrayList;
import java.util.Date;

/**
 * 画面系の処理や表示を簡略化するためのヘルパークラス。定数なども保存されます
 * @author hayashi-s
 */
public class JumsHelper {
    
    //トップへのリンクを定数として設定
    private final String topURL = "./top.jsp";
    
    public static JumsHelper getInstance(){
        return new JumsHelper();
    }
    
    //トップへのリンクを返却
    public String home(){
        return "<a href=\""+topURL+"\">トップへ戻る</a>";
    }
    
    //ログインページへのリンク表示
    public String login(String str){
        if(str == null){
            return "<a href=\"Login?status=logout\">ログイン</a>";
        }else{
            return "<span class=\"text-muted\">ようこそ<a href=\"./MyPage\">" + str + "</a>さん / <a href=\"Login?status=login\">ログアウト</a> /<a href=\"MyCart\">買い物かご</a></span>";
        }
    }
}