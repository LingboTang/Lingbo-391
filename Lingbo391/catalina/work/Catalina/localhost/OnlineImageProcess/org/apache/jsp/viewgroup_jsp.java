package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class viewgroup_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>View Groups</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
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
      out.write("</style>\n");
      out.write("<center>\n");
      out.write("\n");

if (session.getAttribute("USERNAME") == null){
	response.sendRedirect("welcome.html");
}else{
	String userName = (String)session.getAttribute("USERNAME");
	out.println("<p align='right'>Welcome,"+userName+"</p><form NAME='logout' ACTION='logout.jsp' Method='get'><input style='float: right;' NAME='back' TYPE='submit' VALUE='log out'></form>");
	
	String group_id = "";
	String group_owner = "";
	String group_name = "";
	String date_created = "";
	String group_member = "";
	String date_invited = "";
	String notice = "";
	int attempts = 0;
	//admin page
	if (session.getAttribute("USERNAME") == "admin"){
		
		//get connection to oracle
		//establish the connection to the underlying database
        	Connection conn = null;
	
		//load and register the driver
	        Class drvClass = Class.forName("oracle.jdbc.driver.OracleDriver"); 
	        DriverManager.registerDriver((Driver) drvClass.newInstance());

	        //establish the connection 
		conn = DriverManager.getConnection("jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS","lingbo","TlboSci1994");
        	conn.setAutoCommit(false);
        
		//page set up
		out.println("<p><b><I>Group that can modify</I></b></p>");
		out.println("<table border='0' width='30%' cellpadding='5'>");
		out.println("<tr><td><b>Group ID</b></td>");
		out.println("<td><b>Group Owner</b></td>");
		out.println("<td><b>Group Name</b></td>");
		out.println("<td><b>Date Created</b></td>");
		out.println("<td><b>Group Member</b></td>");
		out.println("<td><b>Date Invited</b></td>");
		out.println("<td><b>Notice</b></td></tr>");
		
		String query = "select * from groups";
		
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		
		while (rset.next()){
			attempts = 0;
		 	if (rset.getObject(2) != null){
				group_id = rset.getObject(1).toString();
				out.println("<td>"+group_id+"</td>");
				group_owner = rset.getObject(2).toString();
				out.println("<td>"+group_owner+"</td>");
				group_name = rset.getObject(3).toString();
				out.println("<td>"+group_name+"</td>");
				date_created = rset.getObject(4).toString();
				out.println("<td>"+date_created+"</td>");
				String query2 = "select * from group_lists where group_id="+group_id;
				Statement stmt1 = conn.createStatement();
				ResultSet rset1 = stmt1.executeQuery(query2);
				while(rset1.next()){
					if (attempts != 0){
						out.println("<tr><td></td><td></td><td></td><td></td>");
					}
					group_member = rset1.getObject(2).toString();
					out.println("<td>"+group_member+"</td>");
					date_invited = rset1.getObject(3).toString();
					out.println("<td>"+date_invited+"</td>");
					notice = rset1.getObject(4).toString();
					out.println("<td>"+notice+"</td>");
					out.println("</tr>");
					attempts++;
				}
			} 
		}
		out.println("</table>");
		conn.close();
	}else{
		//get connection to oracle
		//establish the connection to the underlying database
        Connection conn = null;
	
	    //load and register the driver

        Class drvClass = Class.forName("oracle.jdbc.driver.OracleDriver"); 
        DriverManager.registerDriver((Driver) drvClass.newInstance());

        //establish the connection 
	conn = DriverManager.getConnection("jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS","lingbo","TlboSci1994");
        conn.setAutoCommit(false);
        
	//page set up(Group can modify)
	out.println("<p><b><I>Group that can modify</I></b></p>");
	out.println("<table border='0' width='30%' cellpadding='5'>");
	out.println("<tr><th>Group ID</th>");
	out.println("<th>Group Owner</th>");
	out.println("<th>Group Name</th>");
	out.println("<th>Date Created</th>");
	out.println("<th>Group Member</th>");
	out.println("<th>Date Invited</th>");
	out.println("<th>Notice</th></tr>");
		
	String query = "select * from groups";
		
	Statement stmt = conn.createStatement();
	ResultSet rset = stmt.executeQuery(query);
		
	while (rset.next()){
		attempts = 0;
	 	if (rset.getObject(2) != null && (rset.getObject(2)).equals(userName)){
			group_id = rset.getObject(1).toString();
			out.println("<tr><td>"+group_id+"</td>");
			group_owner = rset.getObject(2).toString();
			out.println("<td>"+group_owner+"</td>");
			group_name = rset.getObject(3).toString();
			out.println("<td>"+group_name+"</td>");
			date_created = rset.getObject(4).toString();
			out.println("<td>"+date_created+"</td>");
			String query2 = "select * from group_lists where group_id="+group_id;
			Statement stmt1 = conn.createStatement();
			ResultSet rset1 = stmt1.executeQuery(query2);
			while(rset1.next()){
				if (attempts != 0){
					out.println("<tr><td></td><td></td><td></td><td></td>");
				}
				group_member = rset1.getObject(2).toString();
				out.println("<td>"+group_member+"</td>");
				date_invited = rset1.getObject(3).toString();
				out.println("<td>"+date_invited+"</td>");
				notice = rset1.getObject(4).toString();
				out.println("<td>"+notice+"</td>");
				out.println("</tr>");
				attempts++;
			}
		} 
	}
	out.println("</table>");
		
		
	//page set up (group cannot modify)
	out.println("<p><b><I>Group that cannot modify</I></b></p>");
	out.println("<table border='0' width='30%' cellpadding='5'>");
	out.println("<tr><td><b>Group ID</b></td>");
	out.println("<td><b>Group Owner</b></td>");
	out.println("<td><b>Group Name</b></td>");
	out.println("<td><b>Date Created</b></td>");
	out.println("<td><b>Group Member</b></td>");
	out.println("<td><b>Date Invited</b></td>");
	out.println("<td><b>Notice</b></td><td></td></tr>");
	
	query = "select * from group_lists";
	Statement stmt2 = conn.createStatement();
	ResultSet rset2 = stmt2.executeQuery(query);
	while(rset2.next()){
		group_member = rset2.getObject(2).toString();
		group_id = rset2.getObject(1).toString();
		if (group_member.equals(userName)){
			Statement stmt3 = conn.createStatement();
			ResultSet rset3 = stmt3.executeQuery("select * from groups where group_id='"+group_id+"'");
			while(rset3.next()){
				attempts = 0;
				group_id = rset3.getObject(1).toString();
				out.println("<tr><td>"+group_id+"</td>");
				group_owner = rset3.getObject(2).toString();
				out.println("<td>"+group_owner+"</td>");
				group_name = rset3.getObject(3).toString();
				out.println("<td>"+group_name+"</td>");
				date_created = rset3.getObject(4).toString();
				out.println("<td>"+date_created+"</td>");
				String query2 = "select * from group_lists where group_id="+group_id;
				Statement stmt4 = conn.createStatement();
				ResultSet rset4 = stmt4.executeQuery(query2);
				while(rset4.next()){
					if (attempts != 0){
						out.println("<tr><td></td><td></td><td></td><td></td>");
					}
					group_member = rset4.getObject(2).toString();
					out.println("<td>"+group_member+"</td>");
					date_invited = rset4.getObject(3).toString();
					out.println("<td>"+date_invited+"</td>");
					notice = rset4.getObject(4).toString();
					out.println("<td>"+notice+"</td>");
					out.println("</tr>");
					attempts++;
				}
				}
			}
		}
		out.println("</table>");
		conn.close();
	}	
}

      out.write("\n");
      out.write("<table border='0' width='30%' cellpadding='5'>\n");
      out.write("<tr><td><form name=\"editgroup\" action=\"editgroup.jsp\" method=\"post\"><input type=\"submit\" name=\"editgroupbutton\" value=\"Edit Group\"></form></td>\n");
      out.write("<td><form action=\"profile.jsp\" name=\"goback\"><input type=\"submit\" name=\"gobackbutton\" value=\"Go Back\"></form></td></tr></table>\n");
      out.write("\n");
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
