/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

/**
 *
 * @author guest1Day
 */
public class Dealer extends Human{
    ArrayList<Integer> cards = new ArrayList<Integer>(); // 初期山札
    
    // コンストラクタ
    public Dealer(){
        //トランプの札を格納する
        for(int i = 1;i <= 4;i++){
            for(int j = 1;j <= 13;j++){
                cards.add(j);
            }
        }
    }
    
    // 初期手札を配るメソッド
    public ArrayList<Integer> deal(){
        // 札を2枚格納し、その2枚は山札から削除する
        int num1 = new Random().nextInt(cards.size()-1);
        int num2 = new Random().nextInt(cards.size()-1);
        while(num1 == num2){
        num2 = new Random().nextInt(cards.size()-1);
        }
        ArrayList<Integer> dealList = new ArrayList<Integer>();
        dealList.add(cards.get(num1));
        dealList.add(cards.get(num2));
        cards.remove(num1);
        if(num1 > num2){ // num1がnum2の右側であればそのまま削除
            cards.remove(num2);
        }else{ // num1がnum2の左側であればポインタを1つ左にずらす
         cards.remove(num2-1);   
        }
        
        return dealList;
    }
    
    // hitメソッド
    public ArrayList hit(){
        // 札を1枚格納し、その1枚は山札から削除する
        int num = new Random().nextInt(cards.size()-1);
        ArrayList hitList = new ArrayList();
        hitList.add(cards.get(num));
        cards.remove(num);
        
        return hitList;
    }
    
    // 手札を増やすメソッド
    @Override
    public void setCard(ArrayList<Integer> list){
        for(int value : list){
            myCards.add(value);
        }
    }
    
    // 山札を返すメソッド(デバッグ用)
    public ArrayList<Integer> getSupply(){
        return cards;
    }
    
    // ブラックジャック的な手札の合計値を出すメソッド
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
    
    // バストしたかどうかの判定
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
