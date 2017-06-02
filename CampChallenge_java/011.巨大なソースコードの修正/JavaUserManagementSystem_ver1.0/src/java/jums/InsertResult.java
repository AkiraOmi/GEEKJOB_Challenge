package jums;

import java.io.IOException;
import java.sql.*;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * insertresultと対応するサーブレット
 * フォームから入力された値をセッション経由で受け取り、データベースにinsertする
 * 直接アクセスした場合はerror.jspに振り分け
 * @author hayashi-s
 */
public class InsertResult extends HttpServlet {

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
        
        try{
            // セッションスタート
            HttpSession session = request.getSession();
            UserDataBeans udb = (UserDataBeans)session.getAttribute("UDB");
            // 課題2修正部分
            request.setCharacterEncoding("UTF-8");//セッションに格納する文字コードをUTF-8に変更
            String accesschk = request.getParameter("ac");
            if(accesschk == null || (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }
            // 課題2修正部分ここまで
            //ユーザー情報に対応したJavaBeansオブジェクトに格納していく
            UserDataDTO userdata = new UserDataDTO();
            userdata.setName(udb.getName());
            Calendar birthday = Calendar.getInstance();
            // 課題6の修正部分
            // 生年月日用変数の宣言
            int year = 0;
            int month = 0;
            int day = 0;
            try{
                year = Integer.parseInt(udb.getYear());
                month = Integer.parseInt(udb.getMonth());
                day = Integer.parseInt(udb.getDay());
            }catch(NumberFormatException e_nf){ // (ないと思うけど)エラーが発生した場合
                request.setAttribute("error", e_nf.getMessage());
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
            birthday.set(year,month,day);
            userdata.setBirthday(birthday.getTime());
            // 課題6修正ここまで
            userdata.setType(Integer.parseInt(udb.getType()));
            userdata.setTell(udb.getTell());
            userdata.setComment(udb.getComment());
            
            //DBへデータの挿入
            UserDataDAO.getInstance().insert(userdata);
            session.setAttribute("UDB",udb);
            
            request.getRequestDispatcher("/insertresult.jsp").forward(request, response);
        }catch(Exception e){
            //データ挿入に失敗したらエラーページにエラー文を渡して表示
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
