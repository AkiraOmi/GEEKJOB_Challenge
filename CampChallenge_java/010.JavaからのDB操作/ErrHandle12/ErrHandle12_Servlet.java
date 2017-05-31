package ErrHandle12;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// これは「DB操作」の「複合検索」の課題です

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
public class ErrHandle12_Servlet extends HttpServlet {

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
        String name = request.getParameter("name"); // 名前受け取り
        int age = Integer.parseInt(request.getParameter("age")); // 年齢受け取り
        Date d = null; // 生年月日用変数
        try{
            d = Date.valueOf(request.getParameter("birthyear") + "-" + request.getParameter("birthmonth") + "-" + request.getParameter("birthday"));
        }catch(IllegalArgumentException e_ia){
            System.out.println("生年月日のデータが不正です：" + e_ia.getMessage());
        }
        Connection db_con = null; // データベース接続用変数
        PreparedStatement db_st = null; // 検索用記述用変数
        ResultSet db_data = null; // SELECT結果格納用変数
        String result = "/WEB-INF/jsp/ErrHandle12_Result.jsp"; // 結果表示ページパス
        String output = ""; // 結果文章格納用String
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","AkiraOmi","552121");
            System.out.println("接続に成功しました！");
            
            // 検索部分
            if(request.getParameter("search").equals("and")){ // AND検索の場合
                db_st = db_con.prepareStatement("SELECT * FROM profiles WHERE name LIKE ? AND age = ? AND birthday = ?");
                db_st.setString(1,"%" + request.getParameter("name") + "%");
                db_st.setInt(2,age);
                db_st.setDate(3,d);
                db_data = db_st.executeQuery();
                while(db_data.next()){
                output += "ID：" + db_data.getInt("profileID") + " ";
                output += "名前：" + db_data.getString("name") + " ";
                output += "電話番号：" + db_data.getString("tell") + " ";
                output += "年齢：" + db_data.getInt("age") + " ";
                output += "生年月日：" + db_data.getDate("birthday") + " ";
                output += "<br>";
                }
            }
            if(request.getParameter("search").equals("or")){ // OR検索の場合
                db_st = db_con.prepareStatement("SELECT * FROM profiles WHERE name LIKE ? OR age = ? OR birthday = ?");
                db_st.setString(1,"%" + request.getParameter("name") + "%");
                db_st.setInt(2,age);
                db_st.setDate(3,d);
                db_data = db_st.executeQuery();
                while(db_data.next()){
                output += "ID：" + db_data.getInt("profileID") + " ";
                output += "名前：" + db_data.getString("name") + " ";
                output += "電話番号：" + db_data.getString("tell") + " ";
                output += "年齢：" + db_data.getInt("age") + " ";
                output += "生年月日：" + db_data.getDate("birthday") + " ";
                output += "<br>";
                }
            }
            
            // JavaBeansにデータを格納
            ErrHandle12_Beans beans = new ErrHandle12_Beans();
            beans.setOutput(output);
            request.setAttribute("BEANS",beans);
            
            // JSPに処理を渡す
            RequestDispatcher rd = request.getRequestDispatcher(result);
            rd.forward(request, response);
            
            // close部分
            if(db_data != null){
                db_data.close();
            }
            if(db_st != null){
                db_st.close();
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
                if(db_st != null){
                db_st.close();
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
