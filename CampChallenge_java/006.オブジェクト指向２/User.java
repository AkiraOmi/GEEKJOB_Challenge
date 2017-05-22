
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guest1Day
 */
public class User extends Human{
    //コンストラクタ
    public void User(){
    }
    
    // 手札を追加するメソッド
    @Override
    public void setCard(ArrayList<Integer> list){
        for(int value : list){
            myCards.add(value);
        }
    }
    
    // 手札の合計値を返すメソッド
    @Override
    public int open(){
        int sum = 0; //合計値
        int aNum = 0; //Aが出た数
        for(int value : myCards){
            // 絵札は10扱い
            if(value > 10){
                value = 10;
            }
            //Aが出た数を記憶し、一旦Aを11扱いにする
            if(value == 1){
                value = 11;
                aNum++;
            }
            sum += value;
            //合計が21を超え、Aが出ていた場合はAを1扱いにする
            if(sum > 21 && aNum > 0){
                sum -= 10;
                aNum--;
            }
        }
        return sum;
    }
    
    // 手札がバストしてないか判定するメソッド
    @Override
    public boolean checkSum(){
        if(open() <= 21){
            return true;
        }else{
            return false;
        }
    }
    
    // 手札の状態を返すメソッド
    public ArrayList<Integer> getHand(){
        return myCards;
    }
    
}
