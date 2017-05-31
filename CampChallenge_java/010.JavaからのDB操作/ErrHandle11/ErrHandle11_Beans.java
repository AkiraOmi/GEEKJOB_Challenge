/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ErrHandle11;

import java.io.Serializable;

/**
 *
 * @author guest1Day
 */
public class ErrHandle11_Beans implements Serializable{
    private boolean isRightInput; // 入力が正しいかの判定
    private boolean isSucceeded; // 更新が成功したかの判定
    private String output; // SELECT内容文章用変数
    
    // コンストラクタ
    public ErrHandle11_Beans(){       
    }
    
    // getterメソッド
    public boolean getIsRightInput(){
        return isRightInput;
    }
    public boolean getIsSucceeded(){
        return isSucceeded;
    }
    public String getOutput(){
        return output;
    }
    
    // setterメソッド
    public void setIsRightInput(boolean isRightInput){
        this.isRightInput = isRightInput;
    }
    public void setIsSucceeded(boolean isSucceeded){
        this.isSucceeded = isSucceeded;
    }
    public void setOutput(String output){
        this.output = output;
    }
}
