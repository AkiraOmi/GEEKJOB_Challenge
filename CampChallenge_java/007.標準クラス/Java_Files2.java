
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
public class Java_Files2 {
    public static void main(String[] args){
        // ファイルオープン
        File fp = new File("C:\\Users\\guest1Day\\Documents\\NetBeansProjects\\Challenge001\\src\\java\\testtext.txt");
        //文章の書き込みとクローズ
        try {
            FileReader fr = new FileReader(fp);
            BufferedReader br = new BufferedReader(fr);
            System.out.println(br.readLine());
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(Java_Files1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
