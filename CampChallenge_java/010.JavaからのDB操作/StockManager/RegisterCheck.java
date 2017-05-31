package StockManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// これは「DB操作」の「在庫管理システムの作成」の課題です

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author guest1Day
 */
public class RegisterCheck extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        Connection db_con = null; // DB接続用変数
        PreparedStatement db_st1 = null; // 空きID検索用変数
        PreparedStatement db_st2 = null; // INSERT文記述用変数
        PreparedStatement db_st3 = null; // 追加したデータのSELECT文記述用変数
        ResultSet db_data1 = null; // ブランクID結果格納用変数
        ResultSet db_data2 = null; // 追加結果データ格納用変数
        String itemName = request.getParameter("itemName"); // 商品名受け取り
        int itemType = Integer.parseInt(request.getParameter("itemType")); // 商品タイプ受け取り
        int price = 0; // 価格受け取り用変数
        int stock = 0; // 在庫数受け取り用変数
        int blankID = 0; // 空きID格納用変数
        boolean isRightName = true;
        boolean isRightPrice = true; // 価格が正しいかどうかの判定
        boolean isRightStock = true; // 在庫が正しいかどうかの判定
        String output = ""; // 追加したデータの表示用変数
        String result = "./register-input.jsp"; // 商品登録ページに戻す
        
        if(itemName.equals("")){ // 商品名が入力されてない時
            isRightName = false;
        }
        
        try{
            price = Integer.parseInt(request.getParameter("itemPrice"));
        }catch(NumberFormatException e_nf){
            System.out.println("価格が正しくないエラー：" + e_nf.getMessage());
            isRightPrice = false;
        }
        try{
            stock = Integer.parseInt(request.getParameter("itemStock"));
        }catch(NumberFormatException e_nf){
            System.out.println("在庫が正しくないエラー：" + e_nf.getMessage());
            isRightStock = false;
        }
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","AkiraOmi","552121");
            
            if(isRightName && isRightPrice && isRightStock){
                // 最小のブランクIDを見つける
                db_st1 = db_con.prepareStatement("SELECT MIN(itemID) FROM itemtable AS v1 WHERE NOT EXISTS(SELECT * FROM itemtable AS v2 WHERE v1.itemID + 1 = v2.itemID)");
                db_data1 = db_st1.executeQuery();
                // 見つかったらそのIDで商品を登録する。ただし商品名が同じデータがある場合は追加しない
                if(db_data1.next()){
                    blankID = db_data1.getInt("MIN(itemID)") + 1;
                    // データかぶりがあった場合は無視、かぶってない場合のみデータ登録
                    db_st2 = db_con.prepareStatement("INSERT IGNORE INTO itemtable(itemID,itemName,typeNumber,price,stock) "
                            + "SELECT ?,?,?,?,? FROM dual "
                            + "WHERE NOT EXISTS(SELECT * FROM itemtable WHERE itemName = ?)");
                    db_st2.setInt(1,blankID);
                    db_st2.setString(2,itemName);
                    db_st2.setInt(3,itemType);
                    db_st2.setInt(4,price);
                    db_st2.setInt(5,stock);
                    db_st2.setString(6,itemName);
                    int num = db_st2.executeUpdate();
                    if(num != 0){ // データが追加された場合
                        output += "データは無事に追加されました。以下に追加されたデータの内容を表示します。<br><br>";
                        db_st3 = db_con.prepareStatement("SELECT * FROM itemtable WHERE itemID = ?");
                        db_st3.setInt(1,blankID);
                        db_data2 = db_st3.executeQuery();
                        while(db_data2.next()){
                            output += "商品ID：" + db_data2.getInt("itemID") + " ";
                            output += "商品名：" + db_data2.getString("itemName") + " ";
                            String genre = "";
                            switch(db_data2.getInt("typeNumber")){
                                case 1:
                                    genre = "トップス";
                                    break;
                                case 2:
                                    genre = "ボトムス";
                                    break;
                                case 3:
                                    genre = "ハット";
                                    break;
                                case 4:
                                    genre = "シューズ";
                                    break;
                            }
                            output += "商品の種類：" + genre + " ";
                            output += "価格：" + db_data2.getInt("price") + " ";
                            output += "在庫数：" + db_data2.getInt("stock") + " ";
                            output += "<br>";
                        }
                        output += "<br>以上です。続けて追加する場合は、改めてデータを入力してください<br>";
                    }
                }else{
                    output = "同じデータが存在しており、重複を避けるためデータが追加できませんでした。<br>"
                            + "お手数ですが、データをご確認の上、もう一度入力しなおしてください。<br>";
                }
            }else{ // いずれかの入力が不正だった場合
                output += "いずれかの入力が正しくなかった、もしくは入力されていませんでした。<br>もう一度、確認をしながら入力をお願いします。<br>";
            }
            
            // JavaBeansに情報を格納
            RegisterBeans rb = new RegisterBeans();
            rb.setIsRightName(isRightName);
            rb.setIsRightPrice(isRightPrice);
            rb.setIsRightStock(isRightStock);
            rb.setOutput(output);
            request.setAttribute("BEANS",rb);
            
            RequestDispatcher rd = request.getRequestDispatcher(result);
            rd.forward(request,response);
            
            
            
        }catch(SQLException e_sql){
            System.out.println("SQL例外：" + e_sql.getMessage());
        }catch(Exception e){
            System.out.println("その他の例外：" + e.getMessage());
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
