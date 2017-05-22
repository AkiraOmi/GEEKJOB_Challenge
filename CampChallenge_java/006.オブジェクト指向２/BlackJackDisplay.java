/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 *
 * @author guest1Day
 */
@WebServlet(urlPatterns = {"/BlackJackDisplay"})
public class BlackJackDisplay extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // ディーラーとユーザーを作っておく
        Dealer dealer = new Dealer();
        User user = new User();
        final boolean OPEN = true; // 手札を公開する場合
        final boolean CLOSE = false; // 手札を公開しない場合
        int victory = 0; // 勝利フラグ。0:ユーザーの勝利、1:ディーラーの勝利、2:引き分け
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BlackJackDisplay</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>");
            out.println("ブラックジャックを開始します");
            out.println("</h1>");
            out.println("<br><br>");
            ArrayList<Integer> comp = dealer.getSupply();
            out.print("山札を表示します<br>");
            for(int value : comp){
                out.print(value + " | ");
            }
            out.print("<br><br>");
            // 初期手札を配る
            ArrayList<Integer> dlist = dealer.deal();
            dealer.setCard(dlist);
            user.setCard(dealer.deal());
            printDealerHand(dealer,CLOSE,out);
            printUserHand(user,out);
            // 18になるまではhitさせる
                // プレイヤーの行動。手札合計が17以下ならhitするようにしている
                while(user.open() <= 17){
                    user.setCard(dealer.hit());
                    out.println("あなたがhitしました！<br>");
                    printUserHand(user,out);
                }
                if(user.open() > 21){
                    out.println("手札がバストしました…<br><br>");
                    printUserHand(user,out);
                }else{
                    out.println("あなたはstandしました。ディーラーの行動に移ります<br><br>");
                }
                // ディーラーの行動。手札合計が16以下ならhitするようにしている
                while(dealer.open() <= 16){
                    dealer.setCard(dealer.hit());
                    out.println("ディーラーがhitしました！<br>");
                    printDealerHand(dealer,CLOSE,out);
                }
                // 結果を表示する
                out.println("<br><h2>結果発表！</h2><br>");
                // 各条件に合わせて表示を分岐させる
                // 両方バストしてないなら値で比較。両方21の場合は手札で比較
                if (user.checkSum() && dealer.checkSum()){
                    if(user.open() > dealer.open()){
                        victory = 0;
                    }else if(user.open() < dealer.open()){
                        victory = 1;
                    }else{ // 値が同じ場合、21以外なら引き分け
                        if(user.open() != 21){
                            victory = 2;
                        }else{ // 21なら手札を比較する
                            if(user.getHand().size() == 2 && dealer.getHand().size() != 2){ // ユーザーのみブラックジャックならユーザー勝利
                                victory = 0;
                            }else if (user.getHand().size() != 2 && dealer.getHand().size() == 2){ // 逆ならディーラー勝利
                                victory = 1;
                            }else{ // それ以外なら引き分け
                                victory = 2;
                            }
                        }
                    }
                }else if(user.checkSum() && !dealer.checkSum()){// ディーラーがバストならユーザーの勝ち
                    victory = 0;
                }else if(!user.checkSum() && dealer.checkSum()){// 逆ならディーラーの勝ち
                    victory = 1;
                }else{ // 両方バストなら引き分け
                    victory = 2;
                }
                switch(victory){
                    case 0: // ユーザー勝利
                        out.println("<h1>あなたの勝利です！</h1><br>");
                        break;
                    
                    case 1: // ディーラー勝利
                        out.println("<h1>ディーラーの勝利です！</h1><br>");
                        break;
                        
                    case 2:
                        out.println("<h1>勝負は引き分けです！！</h1><br>");
                        break;                    
                }
                printUserHand(user,out);
                printDealerHand(dealer,OPEN,out);
            
            ArrayList<Integer> comp2 = dealer.getSupply();
            out.print("山札を表示します<br>");
            for(int value : comp2){
                out.print(value + " | ");
            }
            out.print("<br><br>");
            out.println("<br><br>ブラックジャックを終了します！");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public void printUserHand(User u,PrintWriter out){
        out.println("あなたの手札：<h3>");
        for(int value : u.getHand()){
            out.println(value + " | ");
        }
        out.println("合計：" + u.open());
        out.println("<br></h3>");
    }

    public void printDealerHand(Dealer d,boolean b,PrintWriter out){
        out.println("ディーラーの手札：");
        // オープンモードなら手札の中身を公開、クローズモードなら枚数のみ
        if(b){
            out.println("<h3>");
            for(int value : d.getHand()){
                out.println(value + " | ");
            }
            out.println("合計：" + d.open());
            out.println("</h3><br>");
        }else{
            out.println("<h3>");
            for(int i = 0;i < d.getHand().size();i++){
                out.println("■ ");
            }
            out.println("</h3><br>");
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
