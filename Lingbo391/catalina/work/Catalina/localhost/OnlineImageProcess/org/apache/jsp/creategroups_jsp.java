package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class creategroups_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Sample program -- Profile page</title>\n");
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
      out.write("<script type=\"text/javascript\">\n");
      out.write("function checkform(form){\n");
      out.write("\tif (form.GPNM.value == \"\"){\n");
      out.write("\t\talert(\"Please input the GroupName\");\n");
      out.write("\t\tform.GPNM.focus();\n");
      out.write("\t\treturn false;\n");
      out.write("\t}\n");
      out.write("\treturn true;\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("</HEAD>\n");
      out.write("<center>\n");
      out.write("\n");
      out.write("<BODY background=\"http://jmw-custombuilder.com/wp-content/uploads/2013/04/jmw_background3.jpg\">\n");
      out.write("\n");

if (session.getAttribute("USERNAME") == null){
	response.sendRedirect("welcome.html");
}else{
	String userName = (String)session.getAttribute("USERNAME");
	out.println("<p align='right'>Welcome,"+userName+"</p><form NAME='logout' ACTION='logout.jsp' Method='get'><input style='float: right;' NAME='back' TYPE='submit' VALUE='log out'></form>");	
	int group_id;
	if (request.getParameter("submit") == null){
	     try{
	    	 String query = "select user_name from users";
	    	 
	    	 //establish the connection to the underlying database
	         Connection conn = null;
		
		     //load and register the driver

	         Class drvClass = Class.forName("oracle.jdbc.driver.OracleDriver"); 
	         DriverManager.registerDriver((Driver) drvClass.newInstance());

	         //establish the connection 
		     conn = DriverManager.getConnection("jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS","lingbo","TlboSci1994");
	         conn.setAutoCommit(false);
	         
	         Statement stmt = conn.createStatement();
	         ResultSet rset = stmt.executeQuery(query);
	         String uName = "";
	         out.println("<form name='create-groups' method='POST' action='creategroups.jsp' onSubmit='return checkform(this);'>");
	         out.println("<table border='0' width='30%' cellpadding='5'>");
	         out.println("<tr valign='top' align='left'><td><b>Group Name</b></td>");
	         out.println("<td><input type=text name=GPNM maxlength=24></td></tr>");
	         out.println("<tr valign='top' align='left'><td><b>Notice</b></td>");
	         out.println("<td><textarea name='DESC' cols='30' rows='3' maxlength='1024' id='desc'>");
	         out.println("Enter Notice.</textarea></td></tr>");
	         out.println("<tr><td clospan=2><b>The List of Friends </b></td></tr>CREATE GROUPS</font></p><p></p>");
	         while(rset.next()){
	        	 uName = (rset.getObject(1)).toString();
	        	 if (uName.equals(userName) == false && uName.equals("admin") == false){
	        	 	 out.println("<tr><td>");
	        		 out.println(uName+"</td><td><input type='checkbox' name='selectfriends' value="+uName+"></td></tr>");
	        	 }
	         }
	         stmt.close();
	         conn.close();
	     } catch ( Exception ex ){ out.println( ex.toString() );}
	     out.println("<tr><td><input name='submit' value='Create' type='submit'></td></form>");
	     out.println("<td><input name='reset' value='Reset' type='reset'></td></tr></table>");
	   
	}else{
		String groupName = (request.getParameter("GPNM")).trim();
		String notice = (request.getParameter("DESC")).trim();
		String[] items = (request.getParameterValues("selectfriends"));
		
		
		//establish the connection to the underlying database
        Connection conn = null;
	
	    //load and register the driver

        Class drvClass = Class.forName("oracle.jdbc.driver.OracleDriver"); 
        DriverManager.registerDriver((Driver) drvClass.newInstance());

        //establish the connection 
	    conn = DriverManager.getConnection("jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS","lingbo","TlboSci1994");
        conn.setAutoCommit(false);
        
        
		Statement stmt = conn.createStatement();
		
		//Generate a unique id for group
		
		ResultSet rset = stmt.executeQuery("SELECT group_id_sequence.nextval from dual");
	    rset.next();
	    group_id = rset.getInt(1);
		
	    // isert value to table group
	    
	    stmt.execute("insert into groups values('"+group_id+"','"+userName+"','"+groupName+"',SYSDATE)");
	    for (String friendName : items){
	    	stmt.execute("insert into group_lists values('"+group_id+"','"+friendName+"',SYSDATE,'"+notice+"')");
	    }
	    
	    out.println("<center>");
	    out.println("<p><b>Create group sucess!</b></p>");
	    out.println("<p><b>Gonna go back to Profile page in 5 seconds or you can press the button below</b></p>");
	    response.setHeader("Refresh", "5;url=profile.jsp");
	    out.println("<form method=post action=profile.jsp>");
		out.println("<input type=submit name=bSubmit value=Home>");
   	    out.println("</form>");
   	    out.println("</center>");
   	    
   	    stmt.close();
   	    conn.close();
		
	}
}

      out.write("\n");
      out.write("<P><a href=\"profile.jsp\"> Return </a></P>\n");
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
