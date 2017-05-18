/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guest1Day
 */
@WebServlet(urlPatterns = {"/Java_Argument2"})
public class Java_Argument2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    int multiple(int i,int j,boolean b){
        int res;
        res = i * j;
        if(b){
            res *= res;
        }
        return res;
    }
    int multiple(int i){
        return multiple(i,5,false);
    }
    
    int multiple(int i,int j){
        return multiple(i,j,false);
    }
    
    int multiple(int i,boolean b){
        return multiple(i,5,b);
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int i = 15;
        int j = 10;
        boolean b = true;
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Java_Argument2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>");
            out.println("メソッドmultiple(int i,int j,boolean b)の、引数の有無による挙動を見ていきます。引数1はi=15、引数2はj=10、引数3はb=trueです。<br>");
            out.println("引数が全て揃っている場合、(i*j)^2を返します。iかjが欠けると5が補完され、bが欠けると二乗にならなくなります。<br>");
            out.println("全て引数が揃うと、multiple(i,j,b)の計算結果は " + multiple(i,j,b) + " となります。<br>");
            out.println("iが欠けると結果は " + multiple(j,b) + " 、jが欠けると" + multiple(i,b) + " となります。<br>");
            out.println("bが欠けた場合は " + multiple(i,j) + " となります。");
            out.println("</h1>");
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
