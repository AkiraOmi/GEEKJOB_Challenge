/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kagoyuri;

import java.util.LinkedHashMap;

/**
 * 定数を定義するクラス
 * 表示上必要となる商品カテゴリ対応表、アドレスなど
 * @author AkiraOmi
 */
public class DefUtil {
    // トップページURL
    public static final String topURL = "./top.html";
    
    // yahooAPI用アプリケーションID
    public static final String appID = "dj0zaiZpPWNGdW93Rm52QXpTbiZzPWNvbnN1bWVyc2VjcmV0Jng9MTY-";
    
    /**
     * @brief カテゴリID対応表
     * カテゴリIDはあくまで数字なので、これをカテゴリ表示できるように置き換える定数
     * LinkedHashMapでキーがカテゴリID、値にはカテゴリ名の文字列を格納
     */
    public static final LinkedHashMap<String,String> categories;
    static{
        categories = new LinkedHashMap<String,String>();
        categories.put("1","すべてのカテゴリ");
        categories.put("2497","ベビー、キッズ、マタニティ");
        categories.put("2498","食品");
        categories.put("2500","ダイエット、健康");
        categories.put("2501","コスメ、美容、ヘアケア");
        categories.put("2502","スマホ、タブレット、パソコン");
        categories.put("2503","DIY、工具");
        categories.put("2504","テレビ、オーディオ、カメラ");
        categories.put("2505","家電");
        categories.put("2506","家具、インテリア");
        categories.put("2507","花、ガーデニング");
        categories.put("2508","キッチン、日用品、文具");
        categories.put("2509","ペット用品、生き物");
        categories.put("2510","楽器、手芸、コレクション");
        categories.put("2511","ゲーム、おもちゃ");
        categories.put("2512","スポーツ");
        categories.put("2514","車、バイク、自転車");
        categories.put("2516","CD、音楽ソフト、チケット");
        categories.put("2517","DVD、映像ソフト");
        categories.put("10002","本、雑誌、コミック");  
    }
    
    /**
     * @brief ソート方法対応表
     * ソート方法もクエリ用文字列となっているので、それを一般表示と対応させる定数
     * LinkeHashMapでキーがクエリパーツ、値が表示用文字列
     */
    public static final LinkedHashMap<String,String> sortOrder;
    static{
        sortOrder = new LinkedHashMap<String,String>();
        sortOrder.put("-score","おすすめ順");
        sortOrder.put("+price","商品価格が安い順");
        sortOrder.put("-price","商品価格が高い順");
        sortOrder.put("+name","ストア名昇順");
        sortOrder.put("-name","ストア名降順");
        sortOrder.put("-sold","売れ筋順");
        
        
    }
}
