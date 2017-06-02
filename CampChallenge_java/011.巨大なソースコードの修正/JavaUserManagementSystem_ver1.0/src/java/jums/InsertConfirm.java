package jums;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * insertconfirm.jspと対応するサーブレット
 * フォーム入力された情報はここでセッションに格納し、以降持ちまわることになる
 * 直接アクセスした場合はerror.jspに振り分け
 * @author hayashi-s
 */
public class InsertConfirm extends HttpServlet {

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
            HttpSession session = request.getSession();
            request.setCharacterEncoding("UTF-8");//セッションに格納する文字コードをUTF-8に変更
            String accesschk = request.getParameter("ac");
            if(accesschk == null || (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }
            
            //フォームからの入力を取得(未入力の場合は初期値("")に変更)
            String name = "";
            String year = "";
            String month = "";
            String day = "";
            String type = "";
            String tell = "";
            String comment = "";
            
            name = checkText(request.getParameter("name"));
            year = (request.getParameter("year"));
            month = checkText(request.getParameter("month"));
            day = checkText(request.getParameter("day"));
            type = checkText(request.getParameter("type"));
            tell = checkText(request.getParameter("tell"));
            comment = checkText(request.getParameter("comment"));                   

            /*//セッションに格納
            session.setAttribute("name", name);
            session.setAttribute("year", year);
            session.setAttribute("month",month);
            session.setAttribute("day", day);
            session.setAttribute("type", type);
            session.setAttribute("tell", tell);
            session.setAttribute("comment", comment);*/
            // 課題3の修正部分
            UserDataBeans udb = (UserDataBeans)session.getAttribute("UDB"); // UserDataBeans受け取り
            //UserDataBeansに各値を格納する
            udb.setName(name);
            udb.setYear(year);
            udb.setMonth(month);
            udb.setDay(day);
            udb.setType(type);
            udb.setTell(tell);
            udb.setComment(comment);
            String teststr = udb.getComment();
            session.setAttribute("UDB",udb);
        //課題3の修正部分ここまで
            System.out.println("Session updated!!");
            
            request.getRequestDispatcher("/insertconfirm.jsp").forward(request, response);
        }catch(Exception e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
            
    }
    
    // strの値がnullでなければそのままを、nullなら""を返すメソッド(値の格納条件上必要なメソッド)
    private String checkText(String str){
        if(str == null){
            str = "";
        }
        return str;
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
