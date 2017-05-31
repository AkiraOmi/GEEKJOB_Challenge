/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// これは「DB操作」の「在庫管理システムの作成」の課題です

package StockManager;

import java.io.Serializable;

/**
 *
 * @author guest1Day
 */
public class RegisterBeans implements Serializable{
    private boolean isRightName; // 名前が正しいかどうかの判定
    private boolean isRightPrice; // 価格が正しいかどうかの判定
    private boolean isRightStock; // 在庫が正しいかどうかの判定
    private String output; // 挿入データ確認用文字列
    
    // コンストラクタ
    public RegisterBeans(){
    }
    
    // getterメソッド
    public boolean getIsRightName(){
        return isRightName;
    }
    public boolean getIsRightPrice(){
        return isRightPrice;
    }
    public boolean getIsRightStock(){
        return isRightStock;
    }
    public String getOutput(){
        return output;
    }
    
    // setterメソッド
    public void setIsRightName(boolean isRightName){
        this.isRightName = isRightName;
    }
    public void setIsRightPrice(boolean isRightPrice){
        this.isRightPrice = isRightPrice;
    }
    public void setIsRightStock(boolean isRightStock){
        this.isRightStock = isRightStock;
    }
    public void setOutput(String output){
        this.output = output;
    }
}
