/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kagoyuri;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.arnx.jsonic.JSON;

/**
 *
 * @author guest1Day
 */
public class Search extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8"); // リクエストパラメータの文字コードをUTF-8に変更
        response.setContentType("text/html; charset=UTF-8"); // レスポンスパラメータのhtml文字コードをUTF-8に変更
        response.setContentType("application/json; charset=UTF-8"); // レスポンスパラメータのjson文字コードをUTF-8に変更
        try{
            HttpSession session = request.getSession();
            
            // クエリを受け取ってURLエンコードをかける(必須入力項目)
            String query = MethodUtil.strSet(request.getParameter("query"));
            // クエリ未入力はtop.htmlのアラートで弾くが、一応空だった時の条件を実装
            if(query.equals("")){
                request.getRequestDispatcher("./top.jsp").forward(request,response);
            }
            String queryURL = URLEncoder.encode(query,"UTF-8");
            
            // ソート方式を受け取ってURLエンコードをかける(未入力でも動作)
            String sort = "-score"; // MethodUtil.strSet(request.getParameter("sort"));
            String sortURL = URLEncoder.encode(sort,"UTF-8");
            
            // 商品カテゴリを受け取ってURLエンコードをかける(未入力でも動作)
            String category=  "1"; // MethodUtil.strSet(request.getParameter("category"));
            String categoryURL = URLEncoder.encode(category,"UTF-8");
            
            // jsonファイル受け取り用URLを設定
            String jsonURL = "http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch?appid=" + DefUtil.appID + "&query=" + queryURL + "&category_id=" + categoryURL + "&sort=" + sortURL;
            
            URL url = new URL(jsonURL);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
            StringBuffer sb = new StringBuffer();
            
            while(true){
                String line = br.readLine();
                if(line == null){
                    break;
                }
                sb.append(line);
            }
            br.close();
            
            // jsonテキストをパースして要素取り出し(ResultSetの中身)
            String jsonText = sb.toString();
            Map<String, Map<String, Object>> json = JSON.decode(jsonText);
            int resultNum = 0;
            try{
                resultNum = Integer.parseInt(json.get("ResultSet").get("totalResultsReturned").toString());
            }catch(NumberFormatException e){
                System.out.println(e);
            }
            
            // Result以下の情報をMapに格納
            Map<String,Object> result = ((Map<String,Object>)((Map<String,Object>)json.get("ResultSet").get("0")).get("Result"));
            
            // セッションに検索情報を格納
            session.setAttribute("query",query);
            session.setAttribute("sort",sort);
            session.setAttribute("category",category);
            session.setAttribute("resultNum",resultNum);
            session.setAttribute("result",result);
            session.setAttribute("resultURL",jsonURL);
            
            // request.setAttribute("resultURL",jsonURL); // リクエストに結果のURLを格納(JSONデータ読み込みはsearch.htmlでやる)
            request.getRequestDispatcher("./search.jsp").forward(request,response);
            
        }catch(Exception e){
                System.out.println(e);
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
