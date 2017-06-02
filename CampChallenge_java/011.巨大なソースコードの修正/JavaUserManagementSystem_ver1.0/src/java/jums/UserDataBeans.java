package jums;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guest1Day
 */
public class UserDataBeans implements Serializable{
    private String name; // 名前の変数
    private String year; // 誕生年の変数
    private String month; // 誕生月の変数
    private String day; // 誕生日の変数
    private String type; // 業種の変数
    private String tell; // 電話番号の変数
    private String comment; // コメントの変数
    private int ac; // 直リン防止用変数
    
    // コンストラクタ
    public UserDataBeans(){
        // 初回利用のためにすべてデフォルトを設定しておく
        name = "";
        year = "";
        month = "";
        day = "";
        type = "";
        tell = "";
        comment = "";
    }
    
    // getterメソッド
    public String getName(){
        return name;
    }
    public String getYear(){
        return year;
    }
    public String getMonth(){
        return month;
    }
    public String getDay(){
        return day;
    }
    public String getType(){
        return type;
    }
    public String getTell(){
        return tell;
    }
    public String getComment(){
        return comment;
    }
    
    // setterメソッド
    public void setName(String name){
        this.name = name;
    }
    public void setYear(String year){
        this.year = year;
    }
    public void setMonth(String month){
        this.month = month;
    }
    public void setDay(String day){
        this.day = day;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setTell(String tell){
        this.tell = tell;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
}
