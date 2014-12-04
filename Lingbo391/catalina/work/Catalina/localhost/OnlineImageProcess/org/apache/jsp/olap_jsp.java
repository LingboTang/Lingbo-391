package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class olap_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<HTML>\n");
      out.write("<HEAD>\n");
      out.write("<TITLE>OLAP</TITLE>\n");
      out.write("<!--Adapted from http://javarevisited.blogspot.ca/2013/10/how-to-use-multiple-jquery-ui-date.html-->\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<title>jQuery UI Datepicker - Default functionality</title>\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("\thref=\"//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css\">\n");
      out.write("<script src=\"//code.jquery.com/jquery-1.10.2.js\"></script>\n");
      out.write("<script src=\"//code.jquery.com/ui/1.11.2/jquery-ui.js\"></script>\n");
      out.write("<link rel=\"stylesheet\" href=\"/resources/demos/style.css\">\n");
      out.write("<script>\n");
      out.write("$(function() {\n");
      out.write("$( \"#datepicker\" ).datepicker();\n");
      out.write("});\n");
      out.write("</script>\n");
      out.write("<script>\n");
      out.write("$(function() {\n");
      out.write("$( \"#2datepicker\" ).datepicker();\n");
      out.write("});\n");
      out.write("</script>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("body {\n");
      out.write("\tfont-family: 'Helvetica', 'Arial', sans-serif;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#desc {\n");
      out.write("\tpadding: 5px;\n");
      out.write("\tborder: 2px; solid #ccc;\n");
      out.write("\t-webkit-border-radius: 5px;\n");
      out.write("\tborder-radius: 5px;\n");
      out.write("\toutline: $00FF00 dotted thick;\n");
      out.write("}\n");
      out.write("\n");
      out.write("input[type=text] {\n");
      out.write("\toutline: $00FF00 dotted thick;\n");
      out.write("\tpadding: 5px;\n");
      out.write("\tborder: 4px; solid #e0e0e0;\n");
      out.write("\t-webkit-border-radius: 5px;\n");
      out.write("\tborder-radius: 5px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("input[type=text]:focus {\n");
      out.write("\tborder-color: #afa;\n");
      out.write("}\n");
      out.write("\n");
      out.write("input[type=submit] {\n");
      out.write("\tpadding: 5px 5px;\n");
      out.write("\tbackground: #eee;\n");
      out.write("\tborder: 0 none;\n");
      out.write("\tcursor: pointer;\n");
      out.write("\t-webkit-border-radius: 5px;\n");
      out.write("\tborder-radius: 5px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("input[type=reset] {\n");
      out.write("\tpadding: 5px 5px;\n");
      out.write("\tbackground: #eee;\n");
      out.write("\tborder: 0 none;\n");
      out.write("\tcursor: pointer;\n");
      out.write("\t-webkit-border-radius: 5px;\n");
      out.write("\tborder-radius: 5px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("input[type=button] {\n");
      out.write("\tpadding: 5px 5px;\n");
      out.write("\tbackground: #eee;\n");
      out.write("\tborder: 0 none;\n");
      out.write("\tcursor: pointer;\n");
      out.write("\t-webkit-border-radius: 5px;\n");
      out.write("\tborder-radius: 5px;\n");
      out.write("}\n");
      out.write("form {\n");
      out.write("    display: inline;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("</HEAD>\n");
      out.write("<BODY\n");
      out.write("\tbackground=\"http://mycolorscreen.com/wp-content/uploads/wallpapers_2012/163987/lightgrey.png\">\n");
      out.write("\t\n");
      out.write("\t");

	if (session.getAttribute("USERNAME") == null){
		response.sendRedirect("welcome.html");
	}else{
		String userName = (String)session.getAttribute("USERNAME");
		out.println("<p align='right'>Welcome,"+userName+"</p><form NAME='logout' ACTION='logout.jsp' Method='get'><input style='float: right;' NAME='back' TYPE='submit' VALUE='log out'></form>");
	}
	// Checks if user is admin; if not then redirect to profile.jsp
	if (!session.getAttribute("USERNAME").equals("admin")){
		 response.sendRedirect("profile.jsp");
	}

      out.write("\n");
      out.write("\t<H1>\n");
      out.write("\t\t<CENTER>\n");
      out.write("\t\t\t<font color=Teal>Please Enter the information to search the\n");
      out.write("\t\t\t\tdatabase for analysis: </font>\n");
      out.write("\t\t</CENTER>\n");
      out.write("\t</H1>\n");
      out.write("\t<FORM NAME=\"RunAnalysis\" ACTION=\"analysis.jsp\" METHOD=\"post\">\n");
      out.write("\t\t<TABLE style=\"margin: 0px auto\">\n");
      out.write("\t\t\t<TR>\n");
      out.write("\t\t\t\t<TD><B>Select a user:</B></TD>\n");
      out.write("\t\t\t\t<TD><SELECT NAME='owner'>\n");
      out.write("\t\t\t\t\t\t");

	//establish the connection to the underlying database
	Connection conn = null;
	//load and register the driver
	Class drvClass = Class.forName("oracle.jdbc.driver.OracleDriver");
	DriverManager.registerDriver((Driver) drvClass.newInstance());
	//establish the connection
	conn = DriverManager.getConnection("jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS","lingbo","TlboSci1994");
	conn.setAutoCommit(false);
	Statement s=conn.createStatement();
	// selects for all existing users that have uploaded a photo
	String sql = "SELECT * FROM users u WHERE u.user_name=ANY(SELECT i.owner_name FROM images i)";
	ResultSet resSet=s.executeQuery(sql);
	while(resSet.next()){
		String owner = resSet.getString("user_name");
		out.println("<OPTION VALUE='"+owner+"' SELECTED> User:"+owner+" </OPTION>");
	}
	conn.close();

      out.write("\n");
      out.write("\t\t\t\t\t\t<OPTION VALUE=\"\" SELECTED></OPTION>\n");
      out.write("\t\t\t\t</SELECT></TD>\n");
      out.write("\t\t\t</TR>\n");
      out.write("\t\t\t<TR>\n");
      out.write("\t\t\t\t<TD></TD>\n");
      out.write("\t\t\t\t<TD><input type=\"checkbox\" name=\"SortByUser\" value=\"True\"><B><I><font\n");
      out.write("\t\t\t\t\t\t\tcolor=Teal>Search by User.</font></I></B></TD>\n");
      out.write("\t\t\t</TR>\n");
      out.write("\t\t\t<TR>\n");
      out.write("\t\t\t\t<TD><B>Subject:</B></TD>\n");
      out.write("\t\t\t\t<TD><INPUT TYPE=\"text\" NAME=\"Subject\" VALUE=\"\"></TD>\n");
      out.write("\t\t\t</TR>\n");
      out.write("\t\t\t<TR>\n");
      out.write("\t\t\t\t<TD></TD>\n");
      out.write("\t\t\t\t<TD><input type=\"checkbox\" name=\"SortBySubject\" value=\"True\"><B><I><font\n");
      out.write("\t\t\t\t\t\t\tcolor=Teal>Search by Subject.</font></I></B></TD>\n");
      out.write("\t\t\t</TR>\n");
      out.write("\t\t\t<TR>\n");
      out.write("\t\t\t\t<TD><B>From (MM-DD-YYYY): </B></TD>\n");
      out.write("\t\t\t\t<TD><INPUT TYPE=\"text\" id=\"datepicker\" NAME=\"fDate\" VALUE=\"\"></TD>\n");
      out.write("\t\t\t</TR>\n");
      out.write("\t\t\t<TR>\n");
      out.write("\t\t\t\t<TD><B>To (MM-DD-YYYY): </B></TD>\n");
      out.write("\t\t\t\t<TD><INPUT TYPE=\"text\" id=\"2datepicker\" NAME=\"tDate\" VALUE=\"\"></TD>\n");
      out.write("\t\t\t</TR>\n");
      out.write("\t\t\t<TR>\n");
      out.write("\t\t\t\t<TD><B>Group by range:</B></TD>\n");
      out.write("\t\t\t\t<TD><SELECT NAME='sortByRange'>\n");
      out.write("\t\t\t\t\t\t<OPTION VALUE='week' SELECTED>Week</OPTION>\n");
      out.write("\t\t\t\t\t\t<OPTION VALUE='month' SELECTED>Month</OPTION>\n");
      out.write("\t\t\t\t\t\t<OPTION VALUE='year' SELECTED>Year</OPTION>\n");
      out.write("\t\t\t\t\t\t<OPTION VALUE=\"\" SELECTED></OPTION>\n");
      out.write("\t\t\t\t</SELECT></TD>\n");
      out.write("\t\t\t</TR>\n");
      out.write("\t\n");
      out.write("\t\t\t<TR>\n");
      out.write("\t\t\t\t<TD>\n");
      out.write("\t\t\t\t<center>\n");
      out.write("\t\t\t\t\t\t<INPUT TYPE='submit' NAME='StartAnalysis' VALUE='Run' theme=\"simple\">\n");
      out.write("\t\t\t\t</center>\n");
      out.write("\t\t\t\t</TD>\n");
      out.write("\t\t\t</TR>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\n");
      out.write("\t</FORM>\n");
      out.write("\t\n");
      out.write("\t\t\t<TR>\n");
      out.write("\t\t\t\t<TD>\n");
      out.write("\t\t<center>\n");
      out.write("\t\t<form method=post action=profile.jsp>\n");
      out.write("\t\t\t<input type=submit name=bSubmit value=Return  theme=\"simple\" align='right'>\n");
      out.write("\t\t</form>\n");
      out.write("\t\t\t</center>\n");
      out.write("\t\t\t</TD>\n");
      out.write("\t\t\t</TR>\n");
      out.write("\t\t\t\n");
      out.write("\t</TABLE>\n");
      out.write("\t\n");
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
