
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guest1Day
 */
public class Java_Files1 {
    public static void main(String[] args){
        // ファイルオープン
        File fp = new File("C:\\Users\\guest1Day\\Documents\\NetBeansProjects\\Challenge001\\src\\java\\testtext.txt");
        //文章の書き込みとクローズ
        try {
            FileWriter fw = new FileWriter(fp);
            fw.write("僕の名前は近江亮です！　よろしくお願いします！");
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Java_Files1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
