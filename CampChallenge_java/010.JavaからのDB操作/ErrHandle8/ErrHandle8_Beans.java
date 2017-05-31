/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ErrHandle;

// これは「DB操作」の検索用フォームの用意と検索（部分一致）の課題です

import java.io.Serializable;


/**
 *
 * @author guest1Day
 */
public class ErrHandle8_Beans implements Serializable{
    private String output; // SELECT結果の文章データ
    private boolean found; // 見つかったかどうかのフラグ
    
    public ErrHandle8_Beans(){       
    }
    
    // name部分
    public String getOutput(){
        return output;
    }
    public void setOutput(String output){
        this.output = output;
    }
    
    // found部分
    
    public boolean getFound(){
        return found;
    }
    public void setFound(boolean found){
        this.found = found;
    }
}
