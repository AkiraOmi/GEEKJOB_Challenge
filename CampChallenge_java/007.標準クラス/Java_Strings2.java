/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guest1Day
 */
public class Java_Strings2 {
    public static void main(String[] args){
        String ad = "omi.akira.contact@gmail.com";
        System.out.println("このアドレスのドメイン名は" + ad.substring(ad.indexOf("@")) + "です\n");
    }
}
