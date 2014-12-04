package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class uploaddata_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<html>\n");
      out.write("<head>\n");
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
      out.write("</script></head>\n");
      out.write("<body>\n");
      out.write("\n");
if (request.getParameter(".submit") != null){
	int pic_id;
	int current_pic_id;
	//establish the connection to the underlying database
	Connection conn = null;

	//load and register the driver
	Class drvClass = Class.forName("oracle.jdbc.driver.OracleDriver"); 
	DriverManager.registerDriver((Driver) drvClass.newInstance());

	//establish the connection 
	conn = DriverManager.getConnection("jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS","lingbo","TlboSci1994");
	conn.setAutoCommit(false);
	
	Statement stmt = conn.createStatement();
	
	String name = request.getParameter("OWNER");
	String subject = request.getParameter("SUBJ").trim();
	String place = request.getParameter("PLACE").trim();
	String permitted = request.getParameter("PERMITTED").trim();
	String desc = request.getParameter("DESC").trim();
	String date = request.getParameter("Date");
	pic_id = (Integer)session.getAttribute("getid") + 1;
	current_pic_id = (Integer)session.getAttribute("currentid");
	while (pic_id <= current_pic_id){
		stmt.execute("INSERT INTO imagesviewer VALUES('"+pic_id+"','"+name+"')");
		stmt.execute("commit");
		stmt.execute("update images set timing=TO_DATE('"+date+"','mm/dd/yyyy hh24:mi:ss'),owner_name='"+name+"',permitted='"+permitted+"',subject='"+subject+"',place='"+place+"',description='"+desc+"'where photo_id='"+pic_id+"'");
		pic_id++;
	}
	session.removeAttribute("getid");
	session.removeAttribute("currentid");
    stmt.execute("commit");
    conn.close();
    
    response.sendRedirect("profile.jsp");
}

      out.write("\n");
      out.write("<table border=\"0\" width=\"30%\" cellpadding=\"5\">\n");
      out.write("<form name=\"upload-data\" method=\"POST\" action=\"uploaddata.jsp\">\n");
      out.write("<tr valign=\"top\" align=\"left\"><td><b>Subject</b></td>\n");
      out.write("<td><input type=text name=SUBJ maxlength=128>\n");
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("<tr valign=\"top\" align=\"left\"><td><b>Place</b></td>\n");
      out.write("<td><input type=text name=PLACE maxlength=128>\n");
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("<tr valign=\"top\" align=\"left\"><td><b>Permitted</b></td>\n");


	//establish the connection to the underlying database
	Connection conn = null;

	//load and register the driver
	Class drvClass = Class.forName("oracle.jdbc.driver.OracleDriver"); 
	DriverManager.registerDriver((Driver) drvClass.newInstance());

	//establish the connection 
	conn = DriverManager.getConnection("jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS","lingbo","TlboSci1994");
	conn.setAutoCommit(false);

	String userName = (String)session.getAttribute("USERNAME");
	
	out.println("<input type=hidden name=OWNER value="+userName+">");
	out.println("<td><select name='PERMITTED'><option value='1' selected>public</option><option value='2'>private</option>");
	
	String group_name = "";
	String group_id = "";

	Statement stmt1 = conn.createStatement();
	Statement stmt2 = conn.createStatement();
	Statement stmt3 = conn.createStatement();
	ResultSet rset1 = stmt1.executeQuery("select * from groups where user_name='"+userName+"'");
	while (rset1.next()){
		group_name = (rset1.getObject(3)).toString();
		group_id = (rset1.getObject(1)).toString();
		out.println("<option value='"+group_id+"'>"+group_name+"</option>");
	}
	ResultSet rset2 = stmt2.executeQuery("select group_id from group_lists where friend_id='"+userName+"'");
	while (rset2.next()){
		group_id = (rset2.getObject(1)).toString();
		ResultSet rset3 = stmt3.executeQuery("select group_name from groups where group_id='"+group_id+"'");
		while (rset3.next()){
			group_name = (rset3.getObject(1)).toString();
			out.println("<option value='"+group_id+"'>"+group_name+"</option>");
		}
	}
	out.println("</select></td>");
	
	conn.close();

      out.write("\n");
      out.write("</tr>\n");
      out.write("<tr valign=\"top\" align=\"left\"><td><b>Date</b></td>\n");
      out.write("<td><input type=\"text\" id=\"datepicker\" name=\"Date\"></td></tr>\n");
      out.write("<tr valign=\"top\" align=\"left\"><td><b>Description</b></td>\n");
      out.write("<td><textarea name=\"DESC\" cols=\"30\" rows=\"3\" maxlength=\"2048\" id=\"desc\">\n");
      out.write("Enter Description.\n");
      out.write("</textarea>\n");
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td><input name=\".submit\" value=\"Upload\" type=\"submit\"></td>\n");
      out.write("<td><input name=\".reset\" value=\"Reset\" type=\"reset\"></td>\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("</form>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
