/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ErrHandle9;

// これは「DB操作」の「フォームからデータを挿入」の課題です

import java.io.Serializable;


/**
 *
 * @author guest1Day
 */
public class ErrHandle9_Beans implements Serializable{
    private boolean isUpdated; // 入力にミスがあったかのフラグ
    private boolean isUnique; // IDかぶりがあったかのフラグ
    private String output; // SELECT結果を保持する変数
    
    // コンストラクタ
    public ErrHandle9_Beans(){
        
    }
    
    //getterメソッド
    public boolean getIsUpdated(){
        return isUpdated;
    }
    public boolean getIsUnique(){
        return isUnique;
    }
    public String getOutput(){
        return output;
    }
    
    //setterメソッド
    public void setIsUpdated(boolean isUpdated){
        this.isUpdated = isUpdated;
    }
    public void setIsUnique(boolean isUnique){
        this.isUnique = isUnique;
    }
    public void setOutput(String output){
        this.output = output;
    }
}
