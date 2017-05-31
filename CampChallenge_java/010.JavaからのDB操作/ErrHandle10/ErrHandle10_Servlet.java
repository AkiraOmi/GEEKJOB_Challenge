package ErrHandle10;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// これは「DB操作」の「特定のレコードの削除をするフォーム作成」の課題です

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
public class ErrHandle10_Servlet extends HttpServlet {

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
        
        // 変数一覧設定
        int deleteID = 0; // ID受け取り
        Connection db_con = null; // データベース接続用変数
        PreparedStatement db_st1 = null; // DELETE文記述用変数
        PreparedStatement db_st2 = null; // SELECT文記述用変数
        ResultSet db_data = null; // SELECT結果格納用変数
        String result = "/WEB-INF/jsp/ErrHandle10_Result.jsp"; // 結果表示ページパス
        String output = ""; // 結果文章格納用String
        boolean isRightID = true; // 入力されたIDが正しいかどうかのフラグ
        boolean isFound = true; // 削除対象が見つかったかどうかのフラグ
        
        try{
            deleteID = Integer.parseInt(request.getParameter("deleteID"));
        }catch(NumberFormatException e_nf){
            System.out.println("数値エラー：" + e_nf.getMessage());
        }
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","AkiraOmi","552121");
            System.out.println("接続に成功しました！");
            
            // DELETE部分
            db_st1 = db_con.prepareStatement("DELETE FROM profiles WHERE profileID = ?");
            db_st1.setInt(1,deleteID);
            if(deleteID == 0){ // IDがデフォルトになっていた場合
                isRightID = false;
            }
            int deleted = db_st1.executeUpdate();
            if(deleted == 0){ // IDがなかった(削除されなかった)場合
                isFound = false;
            }
            
            // SELECT部分
            db_st2 = db_con.prepareStatement("SELECT * FROM profiles");
            db_data = db_st2.executeQuery();
            while(db_data.next()){
                output += "ID：" + db_data.getInt("profileID") + " ";
                output += "名前：" + db_data.getString("name") + " ";
                output += "電話番号：" + db_data.getString("tell") + " ";
                output += "年齢：" + db_data.getInt("age") + " ";
                output += "生年月日：" + db_data.getDate("birthday") + " ";
                output += "<br>";
            }
            
            // JavaBeansにデータを格納
            ErrHandle10_Beans beans = new ErrHandle10_Beans();
            beans.setIsRightID(isRightID);
            beans.setIsFound(isFound);
            beans.setOutput(output);
            request.setAttribute("BEANS",beans);
            
            // JSPに処理を渡す
            RequestDispatcher rd = request.getRequestDispatcher(result);
            rd.forward(request, response);
            
            // close部分
            if(db_data != null){
                db_data.close();
            }
            if(db_st2 != null){
                db_st2.close();
            }
            if(db_st1 != null){
                db_st1.close();
            }
            if(db_con != null){
                db_con.close();
            }
            
        }catch(SQLException e_sql){
            System.out.println("接続エラーが発生しました：" + e_sql.getMessage());
        }catch(Exception e){
            System.out.println("接続エラーが発生しました(SQL以外)：" + e.getMessage());
        }finally{
            try{
                if(db_data != null){
                    db_data.close();
                }
                if(db_st2 != null){
                    db_st2.close();
                }
                if(db_st1 != null){
                db_st1.close();
            }
                if(db_con != null){
                    db_con.close();
                }
            }catch(SQLException e_sql){
                System.out.println("closeエラー：" + e_sql.getMessage());
            }
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
