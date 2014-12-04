package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class uploadimage_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html PUBLIC \"-//w3c//dtd html 4.0 transitional//en\">\n");
      out.write("<html><head>\n");
      out.write("<meta http-equiv=\"content-type\" content=\"text/html; charset=windows-1252\">\n");
      out.write("<title>Upload Image</title>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("body{\n");
      out.write("\tfont-family: 'Helvetica', 'Arial', sans-serif;\n");
      out.write("}\n");
      out.write("#desc{\n");
      out.write("\tpadding:5px;\n");
      out.write("\tborder:2px;\n");
      out.write("\tsolid #ccc;\n");
      out.write("-webkit-border-radius: 5px;\n");
      out.write("\tborder-radius: 5px;\n");
      out.write("\toutline: $00FF00 dotted thick;\n");
      out.write("}\n");
      out.write("input[type=text] {\n");
      out.write("\toutline: $00FF00 dotted thick;\n");
      out.write("\tpadding:5px;\n");
      out.write("\tborder:4px;\n");
      out.write("\tsolid #e0e0e0;\n");
      out.write("-webkit-border-radius: 5px;\n");
      out.write("\tborder-radius: 5px;\n");
      out.write("}\n");
      out.write("input[type=text]:focus {border-color:#afa;}\n");
      out.write("input[type=submit]{padding:5px 5px; background:#eee; border:0 none;\n");
      out.write("\tcursor:pointer;\n");
      out.write("\t-webkit-border-radius: 5px;\n");
      out.write("\tborder-radius: 5px; }\n");
      out.write("input[type=reset]{padding:5px 5px; background:#eee; border:0 none;\n");
      out.write("\tcursor:pointer;\n");
      out.write("\t-webkit-border-radius: 5px;\n");
      out.write("\tborder-radius: 5px; }\n");
      out.write("input[type=button]{padding:5px 5px; background:#eee; border:0 none;\n");
      out.write("\tcursor:pointer;\n");
      out.write("\t-webkit-border-radius: 5px;\n");
      out.write("\tborder-radius: 5px; }\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body background=\"http://bgwallpaper.net/image/designs-download-background-design-red-light-desktop-142119.jpg\">\n");
      out.write("\n");

if (session.getAttribute("USERNAME") == null){
	response.sendRedirect("welcome.html");
}else{
	String userName = (String)session.getAttribute("USERNAME");
	out.println("<p align='right'>Welcome,"+userName+"</p><form NAME='logout' ACTION='logout.jsp' Method='get'><input style='float: right;' NAME='back' TYPE='submit' VALUE='log out'></form>");
	//establish the connection to the underlying database
	Connection conn = null;

	//load and register the driver
	Class drvClass = Class.forName("oracle.jdbc.driver.OracleDriver"); 
	DriverManager.registerDriver((Driver) drvClass.newInstance());

	//establish the connection 
	conn = DriverManager.getConnection("jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS","lingbo","TlboSci1994");
	conn.setAutoCommit(false);

	Statement stmt = conn.createStatement();
	ResultSet rset = stmt.executeQuery("SELECT pic_id_sequence.nextval from dual");
	rset.next();
	int pic_id = rset.getInt(1);
	session.setAttribute("getid", pic_id);
	session.setAttribute("currentid", pic_id);
	conn.close();
}			

      out.write("\n");
      out.write("<p>\n");
      out.write("<font size=\"8\" face=\"Verdana\" color=\"#0080ff\">\n");
      out.write("Upload Your Image.\n");
      out.write("</font>\n");
      out.write("</p>\n");
      out.write("\n");
      out.write("<p>\n");
      out.write("</p>\n");
      out.write("\n");
      out.write("Please input or select the path of the image!\n");
      out.write("<form name=\"upload-image\" method=\"POST\" enctype=\"multipart/form-data\" action=\"UploadImage\">\n");
      out.write("<table border=\"0\" width=\"30%\" cellpadding=\"5\">\n");
      out.write("<tr>\n");
      out.write("<td><B>File path: </B></td>\n");
      out.write("<td>\n");
      out.write("<input name=\"file-path\"\" type=\"file\" class=\"upload\" multiple=\"\">\n");
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td><input name=\".submit\" value=\"Upload\" type=\"submit\"></td>\n");
      out.write("<td><input name=\".reset\" value=\"Reset\" type=\"reset\"></td>\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("</form>\n");
      out.write("<P><a href=\"profile.jsp\"> Return </a></P>\n");
      out.write("</body></html>\n");
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
