package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class userinfopage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"content-type\"\n");
      out.write("\tcontent=\"text/html; charset=windows-1252\">\n");
      out.write("<title>UserinfoPage</title>\n");
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
      out.write("</style>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("function checkform(form){\n");
      out.write("\tif (form.passWord.value == \"\"){\n");
      out.write("\t\talert(\"Please input the password\");\n");
      out.write("\t\tform.passWord.focus();\n");
      out.write("\t\treturn false;\n");
      out.write("\treturn true;\n");
      out.write("}\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<center>\n");
      out.write("\t\n");
      out.write("\t");
 
if (session.getAttribute("USERNAME") == null){
	response.sendRedirect("welcome.html");
}else{
	String userName = (String)session.getAttribute("USERNAME");
	out.println("<p align='right'>Welcome,"+userName+"</p><form NAME='logout' ACTION='logout.jsp' Method='get'><input style='float: right;' NAME='back' TYPE='submit' VALUE='log out'></form>");		
	
    	//create string to save info
	String passWord = "";
	String firstName = "";
	String lastName = "";
    	String address = "";
    	String email = "";
    	String phone = "";
    
	if (request.getParameter("ChangeInfo") == null){
		out.println("<h1>User Info Page</h1>");
		
		//establish the connection to the underlying database
	    	Connection conn = null;
		
		//load and register the driver
	    	Class drvClass = Class.forName("oracle.jdbc.driver.OracleDriver"); 
		DriverManager.registerDriver((Driver) drvClass.newInstance());
	
		//establish the connection 
		conn = DriverManager.getConnection("jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS","lingbo","TlboSci1994");
	    	conn.setAutoCommit(false);
	    
	    	//Sql statement
		String query1 = "select * from users where user_name='"+userName+"'";
		String query2 = "select * from persons where user_name='"+userName+"'";
	    
		//get info
	    	Statement stmt1 = conn.createStatement();
	    	ResultSet rset1 = stmt1.executeQuery(query1);
	    	while (rset1.next()){
	    		passWord = rset1.getObject(2).toString();
	    	}
	    
	    	Statement stmt2 = conn.createStatement();
	    	ResultSet rset2 = stmt2.executeQuery(query2);
	    	while (rset2.next()){
		    firstName = rset2.getObject(2).toString();
		    lastName = rset2.getObject(3).toString();
		    address = rset2.getObject(4).toString();
		    email = rset2.getObject(5).toString();
		    phone = rset2.getObject(6).toString();
	    	}
	    
	    	//layout 
	    	out.println("<form action='userinfopage.jsp' method='post' name='Changeuserinfo' onsubmit='return checkform(this);'>");
	    	out.println("<table border='0' width='30%' cellpadding='5'>");
	    	out.println("<tr valign='top' align='left'><td><b>UserName:</b></td><td>");
	    	out.println("<td><input type=text name=userName disabled='disabled' value='"+userName+"'></td></tr>");
	    	out.println("<tr valign='top' align='left'><td><b>PassWord:</b></td><td>");
	    	out.println("<td><input type=password name=passWord value='"+passWord+"'></td></tr>");
	    	out.println("<tr valign='top' align='left'><td><b>FirstName:</b></td><td>");
	    	out.println("<td><input type=text name=firstName value='"+firstName+"'></td></tr>");
	    	out.println("<tr valign='top' align='left'><td><b>LastName:</b></td><td>");
	    	out.println("<td><input type=text name=lastName value='"+lastName+"'></td></tr>");
	    	out.println("<tr valign='top' align='left'><td><b>Address:</b></td><td>");
	    	out.println("<td><input type=text name=address value='"+address+"'></td></tr>");
	    	out.println("<tr valign='top' align='left'><td><b>Email:</b></td><td>");
	    	out.println("<td><input type=text name=email value='"+email+"'></td></tr>");
	    	out.println("<tr valign='top' align='left'><td><b>Phone:</b></td><td>");
	    	out.println("<td><input type=text name=phone value='"+phone+"'></td></tr>");
	    	out.println("<tr><td><input name='ChangeInfo' value='Submit' type='submit'></td></tr></form></table>");
	
	    	conn.close();
		}else if (request.getParameter("ChangeInfo") != null){
			//establish the connection to the underlying database
			Connection conn = null;
		
			//load and register the driver
			Class drvClass = Class.forName("oracle.jdbc.driver.OracleDriver"); 
			DriverManager.registerDriver((Driver) drvClass.newInstance());
	
			 //establish the connection 
			conn = DriverManager.getConnection("jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS","lingbo","TlboSci1994");
	    		conn.setAutoCommit(false);
	    
			//get parameter
			passWord = request.getParameter("passWord");
	    		firstName = request.getParameter("firstName");
	    		lastName = request.getParameter("lastName");
	    		address = request.getParameter("address");
	    		email = request.getParameter("email");
	    		phone = request.getParameter("phone");
	    
			 String query1 = "update users set password='"+passWord+"' where user_name='"+userName+"'";
			 String query2 = "update persons set first_name='"+firstName+"', last_name='"+lastName+"',address='"+address+"',email='"+email+"',phone='"+phone+"' where user_name='"+userName+"'";
	    
			Statement stmt = conn.createStatement();
			stmt.execute(query1);
			stmt.execute(query2);
			stmt.executeUpdate("commit");
			stmt.close();
		
			conn.close();
		
			response.setHeader("Refresh", "0;url=profile.jsp");
		}
	}

      out.write("\n");
      out.write("<p><a href=\"profile.jsp\">back</a></p>\n");
      out.write("</center>\n");
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
