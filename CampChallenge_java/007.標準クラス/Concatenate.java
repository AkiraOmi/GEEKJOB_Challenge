
import java.io.*;
import java.text.SimpleDateFormat;
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
public class Concatenate {
    public static void main(String[] args){
        System.out.println("ファイル結合処理を開始します\n");
        Date dStart = new Date(); // 開始時の時刻を取得
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // ログ用タイムスタンプフォーマット
        // ログに書き込み
        try{
            FileWriter fwStart = new FileWriter("log.txt",true);
            BufferedWriter bwStart = new BufferedWriter(fwStart);
            bwStart.write("開始：" + sdf.format(dStart));
            bwStart.newLine();
            bwStart.close();
            fwStart.close();
        }catch(IOException e){
            System.err.println(e);
        }
        // ファイル結合システムの開始
        System.out.println("ファイル「text1.txt」、「text2.txt」、「text3.txt」を結合します\n");
        String[] list = {"test1.txt","test2.txt","test3.txt"};
        FileList file = new FileList(list); // ファイル名をFileListに渡す
        try{
            SequenceInputStream in = new SequenceInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(in,"SHIFT-JIS"));
            File f = new File("result.txt");
            PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f),"SHIFT-JIS")));
            String str = "";
            
            // 内容を結合して書き出す
            while((str = br.readLine()) != null){
                pw.println(str);
                pw.flush();
            }
            br.close();
            in.close();
            pw.close();
        }catch(IOException e){
            System.err.println(e);
        }
        System.out.println("作業は終了しました\n");
        Date dEnd = new Date(); // 終了時の時刻を取得
        // ログファイルに終了時刻を書き込み、ログファイルを表示する
        try{
            // 書き込み部分
            FileWriter fwEnd = new FileWriter("log.txt",true);
            BufferedWriter bwEnd = new BufferedWriter(fwEnd);
            bwEnd.write("終了：" + sdf.format(dEnd));
            bwEnd.newLine();
            bwEnd.newLine();
            bwEnd.close();
            fwEnd.close();
            // 表示部分
            System.out.println("ログを表示します\n");
            FileReader frLog = new FileReader("log.txt");
            BufferedReader brLog = new BufferedReader(frLog);
            String strLog = "";
            while((strLog = brLog.readLine()) != null){
                System.out.println(strLog);
            }           
            brLog.close();
            frLog.close();
        }catch(IOException e){
            System.err.println(e);
        }
    }
}
