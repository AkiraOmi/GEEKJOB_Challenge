<%-- 
    Document   : Java_QStringItemDisp
    Created on : 2017/05/23, 17:15:02
    Author     : guest1Day
--%>

<%-- これは「クエリストリング」の「クエリストリングの利用」の課題です --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
public boolean isPlusNumber(String s){
    try{
        int i = Integer.parseInt(s);
        if(i > 0){
            return true;
        }else{
            return false;
        }
    }catch(NumberFormatException e){
        return false;
    }
}
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>計算結果表示</title>
    </head>
    <body bgcolor="f5deb3">
        受け取った商品は
        <%
            switch(Integer.parseInt(request.getParameter("kind"))){
                case 1:
                    out.print("雑貨");
                    break;
                case 2:
                    out.print("生鮮食品");
                    break;
                case 3:
                    out.print("その他");
            }
        %>
        です！<br>
        1個あたりの値段は
        <%
            String total = request.getParameter("total");
            String count = request.getParameter("count");
            if(isPlusNumber(total) && isPlusNumber(count)){
                int totalInt = Integer.parseInt(total);
                out.print(totalInt/Integer.parseInt(count) + " 円です！<br>");
                if(totalInt >= 3000 && totalInt < 5000){
                    out.print("更に" + (int)(totalInt*0.04) + "ポイントがつきます！");
                }else if(totalInt >= 5000){
                    out.print("更に" + (int)(totalInt*0.05) + "ポイントがつきます！");
                }else{
                    out.print("総額が3000円未満だったので、ポイントはつきませんでした");
                }
            }else{
                out.print("値の入力が不正なので計算できませんでした");
            }
            out.print("<br>");
        %>
    </body>
</html>
