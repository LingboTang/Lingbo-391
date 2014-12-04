package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.servlet.http.*;
import java.sql.*;
import oracle.jdbc.driver.*;
import java.text.*;
import java.net.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import java.util.List;

public final class picturebrowse5_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title> Photo List </title>\n");
      out.write("</head>\n");
      out.write("<body bgcolor=\"#FFFFFF\" text=\"#cccccc\" >\n");
      out.write("<center>\n");
      out.write("<h3>The List of Images </h3>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

try {
    
    String userName = (String)session.getAttribute("USERNAME");
    String query = "SELECT * from images";
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
	
    String p_id = "";
    String permi = "";
    String owner_name = "";
    String name = "";
    
    List<String> pic_id_display_list = new ArrayList<String>();
    
	if (userName.equals("admin")){
		
		Statement stmt = conn.createStatement();
	    	ResultSet rset = stmt.executeQuery(query);
		while (rset.next() ) {
			
	        p_id = (rset.getObject(1)).toString();
	        pic_id_display_list.add(p_id);
	    	
		}
	}else{
		
		Statement stmt = conn.createStatement();
	    ResultSet rset = stmt.executeQuery(query);
	    while (rset.next() ) {
	        p_id = (rset.getObject(1)).toString();
	        permi = (rset.getObject(3)).toString();
	        owner_name = (rset.getObject(2)).toString();
	        if (permi.equals("2")){
	        	if (owner_name.equals(userName)){
	        		
	        		pic_id_display_list.add(p_id);
	        	}else{
	        		continue;
	        	}
	        }else if (permi.equals("1")){
	        	
	        	pic_id_display_list.add(p_id);
	        }else{
	        	
	        	Statement stmt1 = conn.createStatement();
	        	ResultSet rset1 = stmt1.executeQuery("select user_name from groups where group_id='"+permi+"'");
	        	rset1.next();
	        	name = (rset1.getObject(1)).toString();
	        	if (name.equals(userName)){
	        		
	        		pic_id_display_list.add(p_id);
	                		
	        	}else{
	        		Statement stmt2 = conn.createStatement();
	        		ResultSet rset2 = stmt2.executeQuery("select friend_id from group_lists where group_id='"+permi+"'");
	        		while (rset2.next()){
	        			name = (rset2.getObject(1)).toString();
	        			if (name.equals(userName)){
	        				pic_id_display_list.add(p_id);
	        			}
	        		}
	        		stmt2.close();
	        	}
	        	stmt1.close();
	        }
	    }
	}
	
	String sortquery = "select image_id,max(counter) from imagescount group by image_id order by max(counter) desc";
	Statement stmtlast = conn.createStatement();
	ResultSet rsetlast = stmtlast.executeQuery(sortquery);
	
	int iterator = 0;
	while (rsetlast.next() && rsetlast != null) {
		p_id = (rsetlast.getObject(1)).toString();
		if (pic_id_display_list.contains(p_id)) {
			// specify the servlet for the image
			out.println("<a href=\"/OnlineImageProcess/GetOnePic?big"+p_id+"\">");
			// specify the servlet for the themernail
			out.println("<img src=\"/OnlineImageProcess/GetOnePic?"+p_id +
			"\"></a>");
			iterator++;
			if (iterator == 5) {
				break;
			}
		}
		else {
			continue;
		}
	}
	
    conn.close();
} catch ( Exception ex ){ out.println( ex.toString() );}

      out.write("\n");
      out.write("<P><a href=\"profile.jsp\"> Return </a></P>\n");
      out.write("</body>\n");
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
