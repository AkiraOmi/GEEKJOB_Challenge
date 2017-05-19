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
import java.util.*;

/**
 *
 * @author guest1Day
 */
@WebServlet(urlPatterns = {"/Java_ArgRet1"})
public class Java_ArgRet1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    LinkedHashMap<String,String> getProfile(int id){
        int profNum = 3; //プロフィールの数
        boolean found = false; //IDが見つかったかの判定
        // プロフィール用とエラー用のHashMap
        LinkedHashMap<String,String> prof = new LinkedHashMap<String,String>();
        LinkedHashMap<String,String> prof1 = new LinkedHashMap<String,String>();
        LinkedHashMap<String,String> prof2 = new LinkedHashMap<String,String>();
        LinkedHashMap<String,String> prof3 = new LinkedHashMap<String,String>();
        LinkedHashMap<String,String> error = new LinkedHashMap<String,String>();
        // IDが見つからない用のHashMapの用意
        error.put("error","お探しのIDを持つプロフィールは見つかりませんでした");
        // プロフィールの用意
        prof1.put("ID","1");
        prof1.put("name", "田中太郎");
        prof1.put("birthday","1990/04/01");
        prof1.put("address","A県A市A区何某12-34");
        prof2.put("ID","2");
        prof2.put("name", "佐藤次郎");
        prof2.put("birthday","1991/04/01");
        prof2.put("address","B県B市B区何某12-34");
        prof3.put("ID","3");
        prof3.put("name", "伊藤三郎");
        prof3.put("birthday","1992/04/01");
        prof3.put("address","C県C市C区何某12-34");
        // HashMapのArrayList管理
        ArrayList<LinkedHashMap> profList = new ArrayList<LinkedHashMap>();
        profList.add(prof1);
        profList.add(prof2);
        profList.add(prof3);
        // ID照合し、見つかれば返り値用HashMapに格納
        for(int j = 0;j < profNum;j++){
            if(Integer.parseInt((String)profList.get(j).get("ID")) == id){
                prof = profList.get(j);
                found = true;
            }
        }
        // 見つからなければerrorを格納
        if(found == false){
            prof = error;
        }
       return prof; 
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Java_Return2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>");
            out.println("プロフィール表示をします<br>");
            for(int i = 0; i < 4;i++){
                int j = i+1;
                out.println(j + "人目のプロフィールです<br>");
                LinkedHashMap<String,String> map = getProfile(j);
                for(Map.Entry<String,String> val : map.entrySet()){
                   //エラーであればエラー内容を表示
                   if(val.getKey() == "error"){
                       out.println(val.getValue() + "<br>");
                   }else if(val.getKey() != "ID"){
                       out.println(val.getKey() + "は" + val.getValue() + "です<br>");
                   }
                }
            }
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
