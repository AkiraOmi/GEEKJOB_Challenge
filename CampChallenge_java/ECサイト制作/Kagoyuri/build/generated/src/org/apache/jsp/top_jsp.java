package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Kagoyuri.JumsHelper;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<!--[if lt IE 7]>      <html class=\"no-js lt-ie9 lt-ie8 lt-ie7\" lang=\"\"> <![endif]-->\n");
      out.write("<!--[if IE 7]>         <html class=\"no-js lt-ie9 lt-ie8\" lang=\"\"> <![endif]-->\n");
      out.write("<!--[if IE 8]>         <html class=\"no-js lt-ie9\" lang=\"\"> <![endif]-->\n");
      out.write("<!--[if gt IE 8]><!--> <html class=\"no-js\" lang=\"\"> <!--<![endif]-->\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    ");

        HttpSession hs = request.getSession(true);
        JumsHelper jh = JumsHelper.getInstance();
    
      out.write("\n");
      out.write("    \n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("        <title>トップ - かごゆり</title>\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"apple-touch-icon\" href=\"apple-touch-icon.png\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                padding-top: 50px;\n");
      out.write("                padding-bottom: 20px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap-theme.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/main.css\">\n");
      out.write("        \n");
      out.write("        <script src=\"js/vendor/jquery-1.11.2.min.js\"></script>\n");
      out.write("        <script src=\"js/vendor/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/vendor/modernizr-2.8.3-respond-1.4.2.min.js\"></script>\n");
      out.write("        <script src=\"js/vendor/functions.js\"></script>\n");
      out.write("        <!--tooltipとpopover用の記述-->\n");
      out.write("        <script>\n");
      out.write("            $(function(){\n");
      out.write("                $(\"[data-toggle=tooltip]\").tooltip({\n");
      out.write("                    placement : 'bottom'\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("            $(function(){\n");
      out.write("                $(\"[data-toggle=popover]\").popover();\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <nav class=\"navbar navbar-inverse navbar-fixed-top\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <button class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".target\">\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                    </button>\n");
      out.write("                    <a class=\"navbar-brand\" href=\"./top.jsp\">かごゆり</a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"collapse navbar-collapse target\">\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                        <li class=\"active\"><a href=\"./top.html\">ホーム画面へ</a></li>\n");
      out.write("                        <li><a href=\"\">リンク2</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\" style=\"margin-right:20px\">\n");
      out.write("                        <li>");
      out.print(jh.login((String)hs.getAttribute("userName")) );
      out.write("</li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"jumbotron\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <h1>ECサイト「かごゆり」トップページ</h1>\n");
      out.write("                <p>ようこそ「かごゆり」へ！<br>ここは、購買欲をほどよく満たしてくれる(ただし現物は来ない)マネーフリーのECサイトです！</p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"container\" style=\"padding: 20px 0;\">\n");
      out.write("            <form class=\"form-inline\" action=\"Search\" method=\"GET\" onsubmit=\"return searchChk(this)\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label\">商品ワード検索：</label>\n");
      out.write("                    <input type=\"text\" id=\"search\" name=\"query\" class=\"form-control\" style=\"width: 300px;\" placeholder=\"検索ワードを入れてください\">\n");
      out.write("                </div>\n");
      out.write("                <input type=\"submit\" value=\"検索\">\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-4\">\n");
      out.write("                    <h2 class=\"text-info\">「かごゆり」とは？</h2>\n");
      out.write("                    <p>「かごゆり」は、金銭の絡む決済は＜一切無し＞でショッピング風味の操作が楽しめる、言わばバーチャルショッピングサイトです。<br>\n");
      out.write("                     さまざまな商品を取り揃えてみましたので、あなたが買いたいと思っていた商品も見つかるかも？</p>  \n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-4\">\n");
      out.write("                    <h2 class=\"text-info\">「かごゆり」のコンセプト</h2>\n");
      out.write("                    <p>『あれ買いたいけどお金がない…』<br>\n");
      out.write("                    『欲しいものがあるんだけど節約しなきゃ…』<br>\n");
      out.write("                    そんな風にして買いたいものを我慢しちゃうこと、ありますよね。でも、「かごゆり」なら大丈夫！<br>\n");
      out.write("                    商品を検索し、カートに入れて決済するだけでポンと買え(た気になっ)ちゃうお得サイトなのです。<br>\n");
      out.write("                    簡単なステップでお手軽に購買欲を満たせ(たっぽくな)るインスタント性をコンセプトにしております。</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-4\">\n");
      out.write("                    <h2 class=\"text-info\">いや、このサイトなんなん？</h2>\n");
      out.write("                    <p>すみません、ここは完全なるジョークサイトです。<br>\n");
      out.write("                    わたくし、AkiraOmiがECサイト作成、及びBootstrap学習目的のために作った「模擬ECサイト」です。<br>\n");
      out.write("                    基本的な機能くらいしかありませんが、お暇であれば試してみてもらえると嬉しいです。</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
