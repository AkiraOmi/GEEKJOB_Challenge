/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kagoyuri;

import java.io.IOException;
import java.sql.Connection;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guest1Day
 */
public class LoginConfirm extends HttpServlet {

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
        Connection db_con = null; // データベース接続用変数
        PreparedStatement db_st = null; // SELECT文用変数
        ResultSet db_data = null; // SELECT結果格納用変数
        HttpSession hs = request.getSession(true); // セッションを生成
        String userName = request.getParameter("uesrName"); // アカウント名格納
        String password = request.getParameter("password"); // パスワード格納
        String successURL = (String)request.getAttribute("previousAddress"); // ログイン成功時に表示するページ
        String errorURL = "./login.jsp"; // ログイン失敗時に表示するページ
        try{
            // 接続確立部分
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con =DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","AkiraOmi","552121");
            
            //アカウント・パスワード照合部分
            db_st = db_con.prepareStatement("SELECT * FROM users WHERE name = ? AND password = ?");
            db_st.setString(1,userName);
            db_st.setString(2,password);
            db_data = db_st.executeQuery();
            if(db_data.next()){ // データがあった場合
                hs.setAttribute("status","login"); // 状態をログインに設定
                hs.setAttribute("userName",userName); // アカウント名を設定
                
                request.getRequestDispatcher(successURL).forward(request,response);
            }else{ // データがなかった場合
                hs.setAttribute("error","true"); // ログインエラー発生に設定
                request.getRequestDispatcher(errorURL).forward(request,response);
            }
            
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
            System.out.print("エラー発生：" + e_sql.getMessage());
        }catch(Exception e){
            System.out.println("エラー発生(SQL以外)：" + e.getMessage());
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
                System.out.println("クローズ時エラー：" + e_sql.getMessage());
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
