/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// これは「DB操作」の「在庫管理システムの作成」の課題です

package StockManager;

/**
 *
 * @author guest1Day
 */
public class SearchBeans {
    private String output; // 結果出力用文字列
    
    // コンストラクタ
   public SearchBeans(){
   }
   
   // getterメソッド
   public String getOutput(){
       return output;
   }
   
   // setterメソッド
   public void setOutput(String output){
       this.output = output;
   }
}
