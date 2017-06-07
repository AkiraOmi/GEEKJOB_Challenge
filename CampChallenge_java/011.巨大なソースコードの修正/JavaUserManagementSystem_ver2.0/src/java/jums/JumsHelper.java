package jums;

import java.util.ArrayList;
import java.util.Date;
import org.joda.time.DateTime;

/**
 * 画面系の処理や表示を簡略化するためのヘルパークラス。定数なども保存されます
 * @author hayashi-s
 */
public class JumsHelper {
    
    //トップへのリンクを定数として設定
    private final String homeURL = "index.jsp";
    
    public static JumsHelper getInstance(){
        return new JumsHelper();
    }
    
    //トップへのリンクを返却
    public String home(){
        return "<a href=\""+homeURL+"\">トップへ戻る</a>";
    }
    
    /**
     * resultdetailへページを遷移させる表示用メソッド
     * 
     * @param id 詳細表示をさせたいレコードのIDを入れる
     * @return 表示用のHTMLを返す
     */
    public String detail(int id){
        String output = ""; // 出力用文字列
        output += "<form action=\"ResultDetail\" method=\"POST\"> "
                + "<input type=\"hidden\" name=\"id\" value=" + id + "> "
                + "<input type=\"hidden\" name=\"ac\" value=<%=hs.getAttribute(\"ac\") %>> "
                + "<input type=\"submit\" name=\"updateBackBtn\" value=\"このデータの詳細へ戻る\"> </form>";
        return output;
    }
    
    /**
     * 入力されたデータのうち未入力項目がある場合、チェックリストにしたがいどの項目が
     * 未入力なのかのhtml文を返却する
     * @param chkList　UserDataBeansで生成されるリスト。未入力要素の名前が格納されている
     * @return 未入力の項目に対応する文字列
     */
    public String chkinput(ArrayList<String> chkList){
        String output = "";
        for(String val : chkList){
                if(val.equals("name")){
                    output += "名前";
                }
                if(val.equals("year")){
                    output +="年";
                }
                if(val.equals("month")){
                    output +="月";
                }
                if(val.equals("day")){
                    output +="日";
                }
                if(val.equals("type")){
                    output +="種別";
                }
                if(val.equals("tell")){
                    output +="電話番号";
                }
                if(val.equals("comment")){
                    output +="自己紹介";
                }
                output +="が未記入です<br>";
            }
        return output;
    }
    
    /**
     * 種別は数字で取り扱っているので画面に表示するときは日本語に変換
     * @param i
     * @return 
     */
    public String exTypenum(int i){
        switch(i){
            case 1:
                return "営業";
            case 2:
                return "エンジニア";
            case 3:
                return "その他";
        }
        return "";
    }
    
    /*public String convertDate(Date d){
        DateTime dt = new DateTime(d);
        String output = "";
        output += dt.getYear() + "-" + dt.getMonthOfYear() + "-" + dt.getDayOfMonth();
        return output;
    }*/
}
