package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html PUBLIC \"-//w3c//dtd html 4.0 trnsitional//en\">\n");
      out.write("<HTMl>\n");
      out.write("<Head>\n");
      out.write("<META http-equiv=\"content-type\" content=\"text/html; charset=windows-1252\">\n");
      out.write("<title>Profile Page</title>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("body{\n");
      out.write("\tfont-family: 'Helvetica', 'Arial', sans-serif;\n");
      out.write("\tfont-size: 12pt;\n");
      out.write("}\n");
      out.write("input[type=text] {\n");
      out.write("\tpadding:5px;\n");
      out.write("\tborder:2px;\n");
      out.write("\tsolid #ccc;\n");
      out.write("-webkit-border-radius: 5px;\n");
      out.write("\tborder-radius: 5px;\n");
      out.write("}\n");
      out.write("input[type=text]:focus {border-color:#333;}\n");
      out.write("input[type=submit]{padding:5px 5px; background:#eee; border:0 none;\n");
      out.write("\tcursor:pointer;\n");
      out.write("\t-webkit-border-radius: 5px;\n");
      out.write("\tborder-radius: 5px; }\n");
      out.write("\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("</HEAD>\n");
      out.write("<div id=\"Layer1\" style=\"position:absolute; width:100%; height:100%; z-index:-1\"> \n");
      out.write("<BODY background=\"http://jmw-custombuilder.com/wp-content/uploads/2013/04/jmw_background3.jpg\">\n");
      out.write("</div>\n");
 
if (session.getAttribute("USERNAME") == null){
	response.sendRedirect("welcome.html");
}else{
	String userName = (String)session.getAttribute("USERNAME");
	out.println("<p align='right'>Welcome,"+userName+"</p><form NAME='logout' ACTION='logout.jsp' Method='get'><input style='float: right;' NAME='back' TYPE='submit' VALUE='log out'></form>");
}

      out.write("\n");
      out.write("<center>\n");
      out.write("<p>\n");
      out.write("<font size=\"8\" face=\"Verdana\" >\n");
      out.write("Home Page\n");
      out.write("</font>\n");
      out.write("</p>\n");
      out.write("\n");
      out.write("<p>\n");
      out.write("</p>\n");
      out.write("\n");
      out.write("<table border=\"0\" width=\"30%\" size=\"30\" cellpadding=\"5\">\n");
      out.write("<tr><td>\n");
      out.write("Create groups:\n");
      out.write("<form name=\"create-a-group\" method=\"POST\" enctype=\"multipart/form-data\" action=\"creategroups.jsp\"></td>\n");
      out.write("<td><input name=\"submit\" value=\"create groups\" type=\"submit\"></td>\n");
      out.write("</tr>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<tr><td>\n");
      out.write("View Groups:\n");
      out.write("<form name=\"view-group\" method=\"POST\" enctype=\"multipart/form-data\" action=\"viewgroup.jsp\"></td>\n");
      out.write("<td><input name=\"viewgroupbutton\" value=\"View groups\" type=\"submit\"></td>\n");
      out.write("</tr>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<tr><td>\n");
      out.write("Upload images:\n");
      out.write("<form name=\"upload_image\" method=\"POST\" entype=\"multipart/form-data\" action=\"uploadimage.jsp\"></td>\n");
      out.write("<td><input name=\"submit\" value=\"upload image\" type=\"submit\"></td>\n");
      out.write("</tr>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("\n");
      out.write("<TD></TD>\n");
      out.write("<TR></TR>\n");
      out.write("<tr><td>\n");
      out.write("Browse pictures:\n");
      out.write("<form name=\"picture_browse\" method=\"POST\" entype=\"multipart/form-data\" action=\"picturebrowse.jsp\"></td>\n");
      out.write("<td><input name=\"submit\" value=\"browse image\" type=\"submit\"></td>\n");
      out.write("</tr>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<TD></TD>\n");
      out.write("<TR></TR>\n");
      out.write("<tr><td>\n");
      out.write("Search pictures:\n");
      out.write("<form name=\"picture_search\" method=\"POST\" entype=\"multipart/form-data\" action=\"search.jsp\"></td>\n");
      out.write("<td><input name=\"submit\" value=\"search picture\" type=\"submit\"></td>\n");
      out.write("</tr>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<TD></TD>\n");
      out.write("<TR></TR>\n");
      out.write("<tr><td>\n");
      out.write("Change User Info:\n");
      out.write("<form name=\"changuserinfo\" method=\"POST\" entype=\"multipart/form-data\" action=\"userinfopage.jsp\"></td>\n");
      out.write("<td><input name=\"submit\" value=\"Change\" type=\"submit\"></td>\n");
      out.write("</tr>\n");
      out.write("</form>\n");
 
if (session.getAttribute("USERNAME") == "admin"){
	out.println("<TD></TD><TR></TR>");
	out.println("<tr><td>Online Analysis Program:");
	out.println("<form name='date_analysis' method='POST' entype='multipart/form-data' action='olap.jsp'></td>");
	out.println("<td><input name='submit' value='Analysis' type='submit'></td></tr></form>");
}

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</center>\n");
      out.write("</BODY>\n");
      out.write("</HTML>\n");
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
