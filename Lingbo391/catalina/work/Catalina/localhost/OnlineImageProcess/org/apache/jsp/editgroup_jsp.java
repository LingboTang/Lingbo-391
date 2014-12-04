package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class editgroup_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Edit Group</title>\n");
      out.write("</head>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("#desc{\n");
      out.write("\tpadding:5px;\n");
      out.write("\tborder:2px;\n");
      out.write("\tsolid #ccc;\n");
      out.write("-webkit-border-radius: 5px;\n");
      out.write("\tborder-radius: 5px;\n");
      out.write("}\n");
      out.write("body{\n");
      out.write("\tfont-family: 'Helvetica', 'Arial', sans-serif;\n");
      out.write("}\n");
      out.write("input[type=text] {\n");
      out.write("\tpadding:5px;\n");
      out.write("\tborder:4px;\n");
      out.write("\tsolid #ccc;\n");
      out.write("-webkit-border-radius: 5px;\n");
      out.write("\tborder-radius: 5px;\n");
      out.write("}\n");
      out.write("input[type=text]:focus {border-color:#333;}\n");
      out.write("input[type=submit]{padding:5px 5px; background:#eee; border:0 none;\n");
      out.write("\tcursor:pointer;\n");
      out.write("\t-webkit-border-radius: 5px;\n");
      out.write("\tborder-radius: 5px; }\n");
      out.write("input[type=reset]{padding:5px 5px; background:#eee; border:0 none;\n");
      out.write("\tcursor:pointer;\n");
      out.write("\t-webkit-border-radius: 5px;\n");
      out.write("\tborder-radius: 5px; }\n");
      out.write("input[type=checkbox]{padding:5px 5px; background:#eee; border:0 none;\n");
      out.write("\tcursor:pointer;\n");
      out.write("\t-webkit-border-radius: 5px;\n");
      out.write("\tborder-radius: 5px; }\n");
      out.write("</style>\n");
      out.write("<body>\n");
      out.write("<center>\n");
      out.write("\n");

if (session.getAttribute("USERNAME") == null){
	response.sendRedirect("welcome.html");
}else{
	String userName = (String)session.getAttribute("USERNAME");
	out.println("<p align='right'>Welcome,"+userName+"</p><form NAME='logout' ACTION='logout.jsp' Method='get'><input style='float: right;' NAME='back' TYPE='submit' VALUE='log out'></form>");
	
	//establish the connection to the underlying database
	Connection conn = null;
	String driverName = "oracle.jdbc.driver.OracleDriver";
	String dbstring="jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS";
	//load and register the driver
	Class drvClass = Class.forName(driverName); 
	DriverManager.registerDriver((Driver) drvClass.newInstance());
	//establish the connection 
	conn = DriverManager.getConnection(dbstring,"lingbo","TlboSci1994");
	conn.setAutoCommit(false);
	
	String group_id = "";
	String group_name = "";
	String name = "";
	String notice = "";
	Statement stmt = conn.createStatement();
	ResultSet rset = stmt.executeQuery("select * from groups where user_name='"+userName+"'");
	
	out.println("<p><b><I>Select Group</I></b></p>");
	out.println("<form name='choosegroup' action='editgroup.jsp' method='post'>");
	out.println("<table border='0' width='30%' cellpadding='5'>");
	out.println("<tr><td><select name='groups'>");
	
	while(rset.next()){
		group_id = rset.getObject(1).toString();
		group_name = rset.getObject(3).toString();
		out.println("<option value='"+group_id+"'>"+group_name+"</option>");
	}
	out.println("</select></td>");
	out.println("<td><input name='choosegroupbutton' value='Choose Group' type='submit'></td></tr></table>");
	
	if (request.getParameter("deletememberbutton") != null){
		String[] friends = request.getParameterValues("deletefriends");
		Statement stmt1 = conn.createStatement();
		for (String friend : friends){
			stmt1.execute("delete from group_lists where friend_id='"+friend+"'");
		}
		stmt1.execute("commit");
		response.setHeader("Refresh", "0;url=profile.jsp");
	}
	if (request.getParameter("addmemberbutton") != null){
		String[] friends = request.getParameterValues("addfriends");
		notice = request.getParameter("notice");
		group_id = request.getParameter("group_id");
		Statement stmt1 = conn.createStatement();
		for (String friend : friends){
			stmt1.execute("insert into group_lists values('"+group_id+"','"+friend+"',SYSDATE,'"+notice+"')");
		}
		stmt1.execute("commit");
		response.setHeader("Refresh", "0;url=profile.jsp");
	}
	if (request.getParameter("choosegroupbutton") != null){
		group_id = request.getParameter("groups");
		//out.println("<p><b><I>Current group choosen: "+currentgroup+"</I></b></p>");
		
		//Delete member
		out.println("<form name='deletemember' action='editgroup.jsp' method='post'>");
		out.println("<table border='0' width='30%' cellpadding='5'>");
		out.println("<tr><th colspan='2'>Delete members</th></tr>");
		Statement stmt1 = conn.createStatement();
		ResultSet rset1 = stmt1.executeQuery("select * from group_lists where group_id='"+group_id+"'");
		while(rset1.next()){
			name = rset1.getObject(2).toString();
			out.println("<tr><td>");
			out.println(name+"</td><td><input type='checkbox' name='deletefriends' value="+name+"></td></tr>");
		}
		out.println("<tr><td colspan='2'><input name='deletememberbutton' value='Delete Member' type='submit'></td></tr></form></table>");
		stmt1.close();
		
		//Add new member
		out.println("<form name='addmember' action='editgroup.jsp' method='post'>");
		out.println("<table border='0' width='30%' cellpadding='5'>");
		out.println("<tr><th colspan='2'>Add new members</th></tr>");
		Statement stmt2 = conn.createStatement();
		Statement stmt3 = conn.createStatement();
		ResultSet rset2 = stmt2.executeQuery("select u.user_name from users u where u.user_name not in (select g.friend_id from group_lists g where group_id='"+group_id+"' group by g.friend_id) AND u.user_name<>'"+userName+"' AND u.user_name<>'admin'");
		while(rset2.next()){
			name = rset2.getObject(1).toString();
			out.println("<tr><td>");
			out.println(name+"</td><td><input type='checkbox' name='addfriends' value="+name+"></td></tr>");
		}
		out.println("<tr><td>Enter Notice:</td><td><textarea name='notice' cols='30' rows='3' maxlength='1024' id='desc'>Enter Notice.</textarea></td></tr>");
		out.println("<input type='hidden' name='group_id' value='"+group_id+"'>");
		out.println("<tr><td colspan='2'><input name='addmemberbutton' value='Add Member' type='submit'></td></tr></form></table>");
		stmt2.close();
		stmt3.close();
	}
	conn.close();
}
	

      out.write("\n");
      out.write("<P><a href=\"profile.jsp\"> Return </a></P>\n");
      out.write("</center>\n");
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
