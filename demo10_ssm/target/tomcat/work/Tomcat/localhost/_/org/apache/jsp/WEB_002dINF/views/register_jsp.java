/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-12-27 11:40:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>注册</title>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!--js head-->\n");
      out.write("    <!--jquery-->\n");
      out.write("    <script src=\" js/jquery/jquery-2.1.3.min.js\"></script>\n");
      out.write("\n");
      out.write("     <!--jquery插件-->\n");
      out.write("       <script src=\"js/plugins/jquery.form.min.js\"></script>\n");
      out.write("       <script src=\"js/plugins/jquery.validate.min.js\"></script>\n");
      out.write("       <script type=\"text/javascript\" src=\"js/plugins/jquery.bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("       <!--bootstrap-->\n");
      out.write("       <link href=\"../../js/plugins/bootstrap-3.3.7.min.css\" rel=\"stylesheet\">\n");
      out.write("       <script src=\"../../js/plugins/jquery.bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!--css-->\n");
      out.write("    <link href=\"../../css/register.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("\n");
      out.write("    <script type=\"text/javascript\" src=\"../../js/service/register.js\"></script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\n");
      out.write("<h1 class=\"text-center text-danger\">注册2</h1><br>\n");
      out.write("\n");
      out.write("<form id=\"register-form\" role=\"form\" class=\"form-horizontal\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("        <label class=\"col-sm-2 control-label\" for=\"username\">用户名：</label>\n");
      out.write("        <div class=\"col-sm-5\">\n");
      out.write("            <input class=\"form-control\" id=\"username\" name=\"username\" />\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("        <label class=\"col-sm-2 control-label\" for=\"password\">密码：</label>\n");
      out.write("        <div class=\"col-sm-5\">\n");
      out.write("            <input class=\"form-control\" id=\"password\" name=\"password\" />\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("        <label class=\"col-sm-2 control-label\" for=\"confirm-password\">确认密码：</label>\n");
      out.write("        <div class=\"col-sm-5\">\n");
      out.write("            <input class=\"form-control\" id=\"confirm-password\" name=\"confirm-password\" />\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("       <div class=\"form-group\">\n");
      out.write("            <button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\">登录</button>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
