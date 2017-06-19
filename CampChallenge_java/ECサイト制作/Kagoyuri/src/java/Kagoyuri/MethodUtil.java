/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kagoyuri;

/**
 * @brief サーブレット周りで使うメソッドの定義
 * 基本的には単純な関数にしてあります
 * @auther AkiraOmi
 */
public class MethodUtil {
    /**
     * @brief 主にリクエストクエリから受け取った文字列を判断するメソッド
     * 文字列が入っていたらそのまま、そうでなければ空文字を入れる
     * @param String nullなら空文字にしたい場合の文字列
     */
    public static String strSet(String str){
        if(str == null){
            str = "";
        }
        return str;
    }
}
