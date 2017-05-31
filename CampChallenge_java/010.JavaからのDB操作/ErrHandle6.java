/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// これは「DB操作」の「特定のレコードを削除」の課題です

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author guest1Day
 */
@WebServlet(urlPatterns = {"/ErrHandle6"})
public class ErrHandle6 extends HttpServlet {

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
        
        Connection db_con = null; // 接続用変数
        PreparedStatement db_st1 = null; // INSERT用statement
        PreparedStatement db_st2 = null; // SELECT用statement 
        ResultSet db_data = null; // SELECT用ResultSet
        boolean found = false; // ID6番が見つかったかの判定
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ErrHandle6</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>データベース接続実験画面</h1><br><br>");
            
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","AkiraOmi","552121");
                out.println("接続に成功しました！<br>");
                
                // insert部分
                db_st1 = db_con.prepareStatement("DELETE FROM profiles WHERE profileID = ?");
                db_st1.setInt(1,6);
                int num = db_st1.executeUpdate();
                
                if(num == 0){
                    out.println("削除対象データがありませんでした。現在のテーブルを表示します<br>");
                }else{
                    out.println("userID6番のデータを削除しました。以下に削除後のテーブルを表示します<br>");
                }
                
                //select部分
                db_st2 = db_con.prepareStatement("SELECT * FROM profiles");
                db_data = db_st2.executeQuery();
                while(db_data.next()){
                    out.print("ID：" + db_data.getString("profileID") + " ");
                    out.print("名前：" + db_data.getString("name") + " ");
                    out.print("電話番号：" + db_data.getString("tell") + " ");
                    out.print("年齢：" + db_data.getString("age") + " ");
                    out.print("誕生日：" + db_data.getString("birthday") + " ");
                    out.print("<br>");
                    found = true;
                }
                if(!found){
                    out.print("データが見つかりませんでした");
                }
                
                db_data.close();
                db_st1.close();
                db_st2.close();
                db_con.close();
            }catch(SQLException e_sql){
                out.println("接続時エラー：" + e_sql.toString() + "<br>");
            }catch(Exception e){
                out.println("接続時エラー：" + e.toString() + "<br>");
            }finally{
                if(db_con != null){
                    try{
                        db_data.close();
                        db_st1.close();
                        db_st2.close();
                        db_con.close();
                    }catch(Exception e_con){
                        System.out.println(e_con.getMessage());
                    }
                }
            }
            out.println("</body>");
            out.println("</html>");
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
