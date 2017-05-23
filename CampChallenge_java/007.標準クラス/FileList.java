
import java.io.*;
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
public class FileList implements Enumeration{
    private String[] files;
    private int counter = 0;
    
    // コンストラクタ
    FileList(String[] args){
        files = args;
    }
    
    // まだファイルがあるかどうかを判定するメソッド
    @Override
    public boolean hasMoreElements(){
        if(counter < files.length){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public Object nextElement(){
        InputStream in = null;
        if(!hasMoreElements()){
            throw new NoSuchElementException("ファイルがありません！");
        }else{
            String fileName = files[counter];
            counter++;
            try{
                in = new FileInputStream(fileName);
            }catch(IOException e){
                System.err.println(files[counter] + " は処理できません！\n");
            }
        }
        
        return in;
    }
    
    
}
