package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.servlet.http.*;
import java.sql.*;
import oracle.jdbc.driver.*;
import java.text.*;
import java.net.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n");
      out.write("\n");
      out.write("<HTML>\n");
      out.write("<HEAD>\n");
      out.write("<TITLE>Photo List</TITLE>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("\n");
      out.write("body{\n");
      out.write("  font-family: 'Helvetica', 'Arial', sans-serif;\n");
      out.write("}\n");
      out.write("input[type=text] {\n");
      out.write("  padding:5px;\n");
      out.write("  border:4px;\n");
      out.write("  solid #ccc;\n");
      out.write("-webkit-border-radius: 5px;\n");
      out.write("  border-radius: 5px;\n");
      out.write("}\n");
      out.write("input[type=text]:focus {border-color:#333;}\n");
      out.write("input[type=submit]{padding:5px 5px; background:#eee; border:0 none;\n");
      out.write("  cursor:pointer;\n");
      out.write("  -webkit-border-radius: 5px;\n");
      out.write("  border-radius: 5px; }\n");
      out.write("</style>\n");
      out.write("<META http-equiv=\"content-type\"\n");
      out.write("content=\"text/html; charset=windows-1250\">\n");
      out.write("<body bgcolor=\"#ffff00\" text=\"#000000\" >\n");

String uname = (String)session.getAttribute("USERNAME");
if (uname == null){
	response.sendRedirect("welcome.html");
}else{
	String userName = (String)session.getAttribute("USERNAME");
	out.println("Welcome,"+userName+"</p><form NAME='Logout' ACTION='logout.jsp' Method='get'><input  NAME='back' TYPE='submit' VALUE='logout' id='form_a'></form>");
}
      out.write("\n");
      out.write("<FORM NAME=\"searchpicture\" ACTION=\"searchresults.jsp\" METHOD=\"post\" >\n");
      out.write("\tEnter keywords <INPUT TYPE=\"text\" Name=\"key\" size=\"50\"></input>\n");
      out.write("\t\n");
      out.write("\tand/or time period (Format: DD/MM/YYYY) between <TD><input\n");
      out.write("\t\tname=\"dateStart\" type=\"text\" size=\"30\"></input></TD> and <TD><input\n");
      out.write("\t\tname=\"dateEnd\" type=\"text\" size=\"30\"></input></TD>\n");
      out.write("\t\t\n");
      out.write("\t<p>Select sorting method:</p>\n");
      out.write("\t<input type=\"radio\" name=\"SEARCHORDER\" value=\"recentFirst\">Most\n");
      out.write("\tRecent First<br> <input type=\"radio\" name=\"SEARCHORDER\" value=\"recentLast\">Most Recent Last<br> <input\n");
      out.write("\ttype=\"radio\" name=\"SEARCHORDER\" value=\"relevant\">Most Relevant<br>\n");
      out.write("\t<input type=\"submit\" name=\"SEARCHDATA\" value=\"Search\">\n");
      out.write("\n");
      out.write("</form>\n");
      out.write("\n");

	String error = (String) session.getAttribute("error");
	if (error != null) {
			out.println(error);
			session.removeAttribute("error");
	}

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<h3> The List of Images </h3>\n");
      out.write("\n");
      out.write("\n");
      out.write("<P><a href=\"profile.jsp\"> Return </a>\n");
      out.write("</BODY>\n");
      out.write("</HTML>\n");
      out.write("\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
