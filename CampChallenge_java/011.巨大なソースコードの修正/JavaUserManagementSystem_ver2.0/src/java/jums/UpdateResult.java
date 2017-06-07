package jums;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class UpdateResult extends HttpServlet {

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
        /**
         * 直リンク禁止機構を作成。
         * ID回収用に詳細データが入っているdetailDataを受け取り、残りのデータはリクエストから受け取ってUserDataBeansへ格納
         * その後UserDataDTOにマッピングし、更新をさせる
        */
        
        response.setContentType("text/html;charset=UTF-8");
        //セッションスタート
        HttpSession session = request.getSession();
        
        try{
            request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更
            
            //アクセスルートチェック
            String accesschk = request.getParameter("ac");
            if((session.getAttribute("ac") == null || accesschk == null) || (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }
            
            UserDataDTO userdata = (UserDataDTO)session.getAttribute("detailData");
            UserDataBeans userbeans = new UserDataBeans();
            userbeans.setName(request.getParameter("name"));
            userbeans.setYear(request.getParameter("year"));
            userbeans.setMonth(request.getParameter("month"));
            userbeans.setDay(request.getParameter("day"));
            userbeans.setType(request.getParameter("type"));
            userbeans.setTell(request.getParameter("tell"));
            userbeans.setComment(request.getParameter("comment"));
            UserDataDTO alterdata = new UserDataDTO();
            alterdata.setUserID(userdata.getUserID());
            userbeans.UD2DTOMapping(alterdata); // UserDataDTOにマッピング          
            
            //DBへデータの更新要請
            UserDataDAO.getInstance().update(alterdata);
            
            //結果画面での表示用に入力パラメータ―をリクエストパラメータとして保持
            request.setAttribute("updateData", alterdata);
            
            request.getRequestDispatcher("/updateresult.jsp").forward(request, response);
        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー、予期せぬ更新エラー
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
