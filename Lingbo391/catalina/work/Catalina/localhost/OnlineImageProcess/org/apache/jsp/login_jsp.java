package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<HTML>\n");
      out.write("<HEAD>\n");
      out.write("\n");
      out.write("<BODY>\n");
      out.write("\n");
 


	        //get the user input from the login page
	        // New location to be redirected
  		    String site = new String("profile.jsp");
        	String userName = (request.getParameter("USERID")).trim();
	        String passwd = (request.getParameter("PASSWD")).trim();
			if (userName.equals("admin") && passwd.equals("admin")){
				session.setAttribute("USERNAME","admin");
				response.setHeader("Refresh", "0;url=profile.jsp");
			}else{

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
	        
	

	        //select the user table from the underlying db and validate the user name and password
        	Statement stmt = null;
	        ResultSet rset = null;
	        String sql = "select password from users where user_name = '"+userName+"'";

	        	stmt = conn.createStatement();
		        rset = stmt.executeQuery(sql);

	        String truepwd = "";
	
        	while(rset != null && rset.next())
	        	truepwd = (rset.getString(1)).trim();
	
        	//display the result
	        if(passwd.equals(truepwd)){
		        out.println("<p><b>Your Login is Successful!</b></p>");
		        session.setAttribute("USERNAME",userName);
		        response.setStatus(response.SC_MOVED_TEMPORARILY);
		        response.setHeader("Location", site);
	        }else{
	        	out.println("<p><b>Either your userName or Your password is inValid!</b></p>");
				out.println("<p><b>Gonna go back to Login page in 5 seconds or you can press the button below</b></p>");
				response.setHeader("Refresh", "5;url=welcome.html");
				out.println("<form method=post action=welcome.html>");
				out.println("<input type=submit name=bSubmit value=Home>");
		       	out.println("</form>");
                conn.close();
		}}



      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
