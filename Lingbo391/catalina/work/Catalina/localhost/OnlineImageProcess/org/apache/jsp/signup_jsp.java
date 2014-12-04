package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<TITLE>Sign-Up Page</TITLE>\n");
      out.write("<style type=\"text/css\">\n");
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
      out.write("input[type=password] {\n");
      out.write("\tpadding:5px;\n");
      out.write("\tborder:4px;\n");
      out.write("\tsolid #ccc;\n");
      out.write("-webkit-border-radius: 5px;\n");
      out.write("\tborder-radius: 5px;\n");
      out.write("}\n");
      out.write("input[type=password]:focus {border-color:#333;}\n");
      out.write("\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("function checkform(form){\n");
      out.write("\tif (form.USERID.value == \"\"){\n");
      out.write("\t\talert(\"Please input your Username\");\n");
      out.write("\t\tform.USERID.focus();\n");
      out.write("\t\treturn false;\n");
      out.write("\t}\n");
      out.write("\tif (form.PASSWD.value == \"\"){\n");
      out.write("\t\talert(\"Please input your Password\");\n");
      out.write("\t\tform.PASSWD.focus();\n");
      out.write("\t\treturn false;\n");
      out.write("\t}\n");
      out.write("\tif (form.FIRST.value == \"\"){\n");
      out.write("\t\talert(\"Please input your First Name\");\n");
      out.write("\t\tform.FIRST.focus();\n");
      out.write("\t\treturn false;\n");
      out.write("\t}\n");
      out.write("\tif (form.LASTN.value == \"\"){\n");
      out.write("\t\talert(\"Please input your Last Name\");\n");
      out.write("\t\tform.LASTN.focus();\n");
      out.write("\t\treturn false;\n");
      out.write("\t}\n");
      out.write("\tif (form.MAIL.value == \"\"){\n");
      out.write("\t\talert(\"Please input your Mail\");\n");
      out.write("\t\tform.MAIL.focus();\n");
      out.write("\t\treturn false;\n");
      out.write("\t}\n");
      out.write("\tif (form.PHONE.value == \"\"){\n");
      out.write("\t\talert(\"Please input your Phone\");\n");
      out.write("\t\tform.PHONE.focus();\n");
      out.write("\t\treturn false;\n");
      out.write("\t}\n");
      out.write("\tif (form.ADDRESS.value == \"\"){\n");
      out.write("\t\talert(\"Please input your Address\");\n");
      out.write("\t\tform.ADDRESS.focus();\n");
      out.write("\t\treturn false;\n");
      out.write("\t}\n");
      out.write("\treturn true;\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("</HEAD>\n");
      out.write("\n");
      out.write("<BODY background=\"http://bgwallpaper.net/image/designs-download-background-design-red-light-desktop-142119.jpg\">\n");
      out.write("\n");
      out.write("<Center>\n");
      out.write("<p><font size=\"7\" face=\"Verdana\" color=\"#0080ff\">Enter Your Personal Information</font></p>\n");
      out.write("<p></p>\n");
      out.write("<form name=signinform method=\"post\" action=signup.jsp onsubmit=\"return checkform(this);\">\n");
      out.write("<table border=\"0\" width=\"30%\" cellpadding=\"5\">\n");
      out.write("<tr valign=\"top\" align=\"left\"><td><b>Username</b></td>\n");
      out.write("<td><input type=text name=USERID maxlength=20></td></tr>\n");
      out.write("<tr valign=\"top\" align=\"left\"><td><b>Password</b></td>\n");
      out.write("<td><input type=password name=PASSWD maxlength=20></td></tr>\n");
      out.write("<tr valign=\"top\" align=\"left\"><td><b>First Name</b></td>\n");
      out.write("<td><input type=text name=FIRST maxlength=20></td></tr>\n");
      out.write("<tr valign=\"top\" align=\"left\"><td><b>Last Name</b></td>\n");
      out.write("<td><input type=text name=LASTN maxlength=20></td></tr>\n");
      out.write("<tr valign=\"top\" align=\"left\"><td><b>Email</b></td>\n");
      out.write("<td><input type=text name=MAIL maxlength=20></td></tr>\n");
      out.write("<tr valign=\"top\" align=\"left\"><td><b>Address</b></td>\n");
      out.write("<td><input type=text name=ADDRESS maxlength=20></td></tr>\n");
      out.write("<tr valign=\"top\" align=\"left\"><td><b>Phone Number</b></td>\n");
      out.write("<td><input type=text name=PHONE maxlength=20></td></tr>\n");
      out.write("<tr valign=\"top\" align=\"left\"><td><input type=submit name=bSubmit value=Submit></td>\n");
      out.write("</form>\n");
      out.write("<td><INPUT TYPE=\"reset\" NAME=\"Reset\" VALUE=\"Reset\"></td></tr>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("\n");
 

        if(request.getParameter("bSubmit") != null)
        {
		boolean check = true;
	        //get the user input from the login page
        	String userName = (request.getParameter("USERID")).trim();
	        String passwd = (request.getParameter("PASSWD")).trim();
        	
        	String fname = (request.getParameter("FIRST")).trim();
	        String lname = (request.getParameter("LASTN")).trim();
        	
        	String email = (request.getParameter("MAIL")).trim();
	        String pnum = (request.getParameter("PHONE")).trim();

        	String addr = (request.getParameter("ADDRESS")).trim();
        	

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
	        
		//check wheter the username is valid
		String sql = "select user_name from users";
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(sql);
		String name = "";
		while (rset.next()){
			name = (rset.getObject(1)).toString();
			if (name.equals(userName)){
				check = false;
				break;
			}
		}
			
			
			if (check){
				//select the user table from the underlying db and validate the user name and password
	        		Statement stmt1 = null;
				ResultSet rset1 = null;
				
				Statement stmt2 = null;
				ResultSet rset2 = null;
				String sql1 = "insert into persons values('"+userName+"','"+fname+"','"+lname+"','"+addr+"','"+email+"','"+pnum+"')";
				String sql2 = "insert into users values('"+userName+"','"+passwd+"',SYSDATE)";
		        
	
				stmt2 = conn.createStatement();
				rset2 = stmt2.executeQuery(sql2);
	
	     			stmt1 = conn.createStatement();
		  	 	rset1 = stmt1.executeQuery(sql1);
				
		  	 	out.println("<p><b>Sign up success!</b></p>");
		 		out.println("<p><b>Gonna go back to Login page in 5 seconds or you can press the button below</b></p>");
				response.setHeader("Refresh", "5;url=welcome.html");
				out.println("<form method=post action=welcome.html>");
				out.println("<input type=submit name=bSubmit value=Home>");
	       			out.println("</form>");
			}else{
				out.println("<p><b>The username has been used</b></p>");
			}
	       
      	    conn.close();

        }

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
