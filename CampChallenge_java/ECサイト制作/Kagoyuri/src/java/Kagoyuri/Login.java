/*
 * ログイン状態を受け取って引き渡すサーブレット
 * ログインしていなければlogout、していればloginが引き渡される
 * セッションによる直リン禁止機構を入れるかは不明。というかこのサーブレットがそもそも必要なのか怪しい…
 */
package Kagoyuri;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guest1Day
 */
public class Login extends HttpServlet {

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
            // 文字コード指定
            request.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            
            HttpSession hs = request.getSession();
            hs.setAttribute("status",request.getParameter("status"));
            // ログインしていない時は直前のアドレスをリクエストに格納する
            if(request.getParameter("status").equals("logout")){
                request.setAttribute("previousAddress",request.getRequestURI());
            }
            request.getRequestDispatcher("./login.jsp").forward(request,response);
        }catch(Exception e){ // (いらないと思うけど)一応エラーページへのガイド
            request.setAttribute("error",e.getMessage());
            request.getRequestDispatcher("./error.jsp").forward(request,response);
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
