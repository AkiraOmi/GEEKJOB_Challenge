/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guest1Day
 */
public class Java_Strings1 {
    public static void main(String[] args){
        String name = "近江亮";
        try {
            System.out.println(name + " の文字数は" + name.length() + "文字で、バイト数は" + name.getBytes("UTF-8").length + "です\n");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Java_Strings1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
