/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ErrHandle12;

// これは「DB操作」の「複合検索」の課題です

import java.io.Serializable;


/**
 *
 * @author guest1Day
 */
public class ErrHandle12_Beans implements Serializable{
    private String output; // 検索結果文章用変数
    
    // コンストラクタ
    public ErrHandle12_Beans(){    
    }
    
    //getterメソッド
    public String getOutput(){
        return output;
    }
    
    //setterメソッド
    public void setOutput(String output){
        this.output = output;
    }
}
