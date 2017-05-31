/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ErrHandle10;

// これは「DB操作」の「特定のレコードの削除をするフォーム作成」の課題です

import java.io.Serializable;


/**
 *
 * @author guest1Day
 */
public class ErrHandle10_Beans implements Serializable{
    private boolean isRightID; // 入力されたIDが正しかったかの判定
    private boolean isFound; // 削除対象が見つかったかの判定
    private String output; // SELECT結果用文章
    
    // コンストラクタ
    public ErrHandle10_Beans(){
        
    }
    
    // getterメソッド
    public boolean getIsRightID(){
        return isRightID;
    }
    public boolean getIsFound(){
        return isFound;
    }
    public String getOutput(){
        return output;
    }
    
    // setterメソッド
    public void setIsRightID(boolean isRightID){
        this.isRightID = isRightID;
    }
    public void setIsFound(boolean isFound){
        this.isFound = isFound;
    }
    public void setOutput(String output){
        this.output = output;
    }
}
