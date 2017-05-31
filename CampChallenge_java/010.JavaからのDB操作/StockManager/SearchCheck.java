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
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author guest1Day
 */
public class SearchCheck extends HttpServlet {

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
        PreparedStatement db_st = null; // SELECT文記述用変数
        ResultSet db_data_all = null; // 全検索用結果格納変数
        ResultSet res = null;
        ArrayList<ResultSet> db_data_cond = new ArrayList(); // SELECT文結果格納用配列
        String searchMethod = request.getParameter("searchMethod"); // 検索方式受け取り
        String methodMode = request.getParameter("methodMode"); // AND検索かOR検索かを受け取り
        String itemName = request.getParameter("itemName"); // 商品名受け取り
        ArrayList<Integer> itemType = new ArrayList(); // 商品タイプ受け取り用変数
        String[] itemStr; // 加工前データ受け取り用変数
        if(request.getParameterValues("itemType") != null){
            itemStr = request.getParameterValues("itemType");
            for (String itemStr1 : itemStr) {
                try {
                    int n = Integer.parseInt(itemStr1);
                    itemType.add(n);
                }catch(NullPointerException e){
                    System.out.println("error");
                }
            }
        }
        String output = ""; // 追加したデータの表示用変数
        String result = "./search-input.jsp"; // 商品登録ページに戻す
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","AkiraOmi","552121");
            
            if(searchMethod.equals("all")){ // 全検索の場合
                db_st = db_con.prepareStatement("SELECT * FROM itemtable");
                db_data_all = db_st.executeQuery();
                while(db_data_all.next()){
                    output += "商品ID：" + db_data_all.getInt("itemID") + " ";
                    output += "商品名：" + db_data_all.getString("itemName") + " ";
                    String genre = "";
                    switch(db_data_all.getInt("typeNumber")){
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
                    output += "価格：" + db_data_all.getInt("price") + " ";
                    output += "在庫数：" + db_data_all.getInt("stock") + " ";
                    output += "<br>";
                }
            }else if(searchMethod.equals("condition")){ // 条件検索の場合
                if(methodMode.equals("AND")){ // AND検索
                    if(!itemType.isEmpty()){ // itemTypeにデータが入っている場合
                        for(int i = 0;i < itemType.size();i++){
                            if(itemName.equals("")){
                                db_st = db_con.prepareStatement("SELECT * FROM itemtable WHERE typeNumber = ?");
                                db_st.setInt(1,itemType.get(i));
                            }else{
                                db_st = db_con.prepareStatement("SELECT * FROM itemtable WHERE itemName LIKE ? AND typeNumber = ?");
                                db_st.setString(1,"%" + itemName + "%");
                                db_st.setInt(2,itemType.get(i));
                            }
                            res = db_st.executeQuery();
                            if(res != null){
                                db_data_cond.add(res);
                            }
                        }
                    }else{ // itemTypeが入ってない場合
                        if(!itemName.equals("")){ // 名前が入っているなら
                            db_st = db_con.prepareStatement("SELECT * FROM itemtable WHERE itemName LIKE ?");
                            db_st.setString(1,"%" + itemName + "%");
                            res = db_st.executeQuery();
                            if(res != null){
                                db_data_cond.add(res);
                            }
                        }
                    }
                }else if(methodMode.equals("OR")){ // OR検索
                    if(!itemType.isEmpty()){ // itemTypeが入っている場合
                        for(int i = 0;i < itemType.size();i++){
                           if(itemName.equals("")){
                                db_st = db_con.prepareStatement("SELECT * FROM itemtable WHERE typeNumber = ?");
                                db_st.setInt(1,itemType.get(i));
                            }else{
                                db_st = db_con.prepareStatement("SELECT * FROM itemtable WHERE itemName LIKE ? OR typeNumber = ?");
                                db_st.setString(1,"%" + itemName + "%");
                                db_st.setInt(2,itemType.get(i));
                            }
                        }
                    }else{ // itemTypeが入ってない場合
                        if(!itemName.equals("")){ // 文字列が入っている場合
                            db_st = db_con.prepareStatement("SELECT * FROM itemtable WHERE itemName LIKE ?");
                            db_st.setString(1,"%" + itemName + "%");
                            res = db_st.executeQuery();
                            if(res != null){
                                db_data_cond.add(res);
                            }
                        }
                    }
                }
                for(int i=0;i < db_data_cond.size();i++){
                    while(db_data_cond.get(i).next()){
                        ResultSet rs = db_data_cond.get(i); // ResultSetデータ取り出し
                    output += "商品ID：" + rs.getInt("itemID") + " ";
                    output += "商品名：" + rs.getString("itemName") + " ";
                    String genre = "";
                    switch(rs.getInt("typeNumber")){
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
                    output += "価格：" + rs.getInt("price") + " ";
                    output += "在庫数：" + rs.getInt("stock") + " ";
                    output += "<br>";
                    }
                }
            }
            
            // JavaBeansに情報を格納
            SearchBeans sb = new SearchBeans();
            sb.setOutput(output);
            request.setAttribute("BEANS",sb);
            
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
