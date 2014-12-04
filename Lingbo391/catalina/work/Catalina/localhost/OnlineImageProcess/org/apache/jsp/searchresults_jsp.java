package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.servlet.http.*;
import java.query.*;
import oracle.jdbc.driver.*;
import java.text.*;
import java.net.*;
import java.sql.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import db.Database.*;

public final class searchresults_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");

	//retrieves the text field paramters from searchStart.jsp
	String keywords = request.getParameter("key");
	String dateStart = request.getParameter("dateStart");
	String dateEnd = request.getParameter("dateEnd");
	//error checks to make sure required text fields have values
	if (keywords == "" && dateStart == "" || keywords == "" && dateEnd == "") {
		String error = "<p><b><font color=000000>You have not entered in all required search parameters!</font></b></p>";
		session.setAttribute("error", error);
		response.sendRedirect("search.jsp");
		return;
	}
	//depending on which order radio button is selected, create a relevant query string for it
	String queryOrder = "";
	if (request.getParameter("SEARCHORDER") != null) {
		if (request.getParameter("SEARCHORDER").equals("recentFirst")) {
			queryOrder = "images.timing DESC";
		} else if (request.getParameter("SEARCHORDER").equals("recentLast")) {
			queryOrder = "images.timing ASC";
		} else if (request.getParameter("SEARCHORDER").equals("relevant")) {
			queryOrder = "rank desc";
		}
		//if there is no order option selected, display an error
	} else {
			String error = "<p><b><font color=ff0000>You have not entered any search order specifications!</font></b></p>";
			session.setAttribute("error", error);
			response.sendRedirect("search.jsp");
	}

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title> Photo List </title>\n");
      out.write("</head>\n");
      out.write("<body bgcolor=\"#FFFFFF\" text=\"#cccccc\" >\n");
      out.write("\t\n");
      out.write("\t\n");

	//obtain the class and the ID of the current logged in user
	String userID = (String) session.getAttribute("USERID");
	out.println("<H1>Search Results</H1>");
		
		
	String query = "select images.photo_id, images.subject,images.place,images.description";
	//When both keyword and date are entered
	if (keywords != "" && dateStart != "" && dateEnd != "") {
		query = query + ", ";
		query = query + "6*score(" + Integer.toString(1)+ ")+3*score(" + Integer.toString(2)
				+ ")+score(" + Integer.toString(3)+ ") ";
		
			
		query = query + "as rank ";
		query = query + " FROM images where ";
		out.println("Results of matching keywords: " + keywords+ " between dates " + dateStart + " and " + dateEnd);
		//query statement to search for a certain time period
		query = query + "images.timing between to_date('" + dateStart+ "', 'DD/MM/YYYY') AND to_date('" + dateEnd+ "', 'DD/MM/YYYY') AND ";
		//creates query statement for every key word to match with the score function
		
		
		query = query + "(contains(images.subject, '"+ keywords + "', "+ Integer.toString(1)+ ") > 0 OR contains(images.place, '"
			+ keywords + "', "+ Integer.toString(2)+ ") > 0 OR contains(images.description, '" + keywords
			+ "', " + Integer.toString(3)+ ") > 0)";
			
		query = query + "ORDER BY " + queryOrder; //order by the order query string made above
		
	}
	
	
	//No keywords entered
	else if (keywords.equals("") && (!dateStart.equals("") && !dateEnd.equals(""))) {
		out.println("Records of time period between " + dateStart+ " and " + dateEnd);
		query = query+ " FROM images where";
		query = query +" images.timing between to_date('" + dateStart+ "', 'DD/MM/YYYY') AND to_date('" + dateEnd
				+ "', 'DD/MM/YYYY')";
		query = query+" ORDER BY " + queryOrder;
		
	}
	
	//No Timeperiod entered
	else if (!keywords.equals("") && (dateStart.equals("") || dateEnd.equals(""))) {
		out.println("Resutls of matching keywords: " + keywords);
		query = query + ", ";
		query = query + "6*score(" + Integer.toString(1)+ ")+3*score("+Integer.toString(2)
				+")+score("+Integer.toString(3)+")";
		query = query + "as rank ";
		query = query + "From images where ";
		query =query + "(contains(images.subject, '"+keywords + "', "+ Integer.toString(1)+ ") > 0 OR contains(images.place, '"
				+ keywords + "', "+ Integer.toString(2)+ ") > 0 OR contains(images.description, '" + keywords
				+ "', " + Integer.toString(3)+ ") > 0)";
		query = query + "ORDER BY "+queryOrder;
		
	}
	
	

      out.write("\n");
      out.write("\n");
      out.write("<center>\n");
      out.write("<h3>The List of Images </h3>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

	
	try{
		Connection conn = null;
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String dbstring="jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS";
		//load and register the driver
		Class drvClass = Class.forName(driverName);
		DriverManager.registerDriver((Driver) drvClass.newInstance());
		//establish the connection
		conn = DriverManager.getConnection(dbstring,"lingbo","TlboSci1994");
		conn.setAutoCommit(false);
		Statement stmt = conn.createStatement();
		
		ResultSet rset = stmt.executeQuery(query);
		String p_id = "";
		List<String> pic_id_searched_list = new ArrayList<String>();
		
		while (rset.next()) {
			p_id = (rset.getObject(1)).toString();
			pic_id_searched_list.add(p_id);
			
		}
		stmt.close();
		
		String userName = (String)session.getAttribute("USERNAME");
    	String allquery = "SELECT * from images";
		String p_id_tofil = "";
    	String permi = "";
    	String owner_name = "";
    	String name = "";
	
    	if (userName == "admin") {
    		Statement stmtall = conn.createStatement(); 
    		ResultSet rsetall = stmtall.executeQuery(query);
    		while (rsetall.next() && rsetall != null){
    			p_id_tofil = (rsetall.getObject(1)).toString();
    			
    			// specify the servlet for the image
    			out.println("<a href=\"/OnlineImageProcess/GetOnePic?big"+p_id_tofil+"\">");
    			// specify the servlet for the themernail
    			out.println("<img src=\"/OnlineImageProcess/GetOnePic?"+p_id_tofil +
    			"\"></a>");
    		}
    		stmtall.close();
    	} else {
    		Statement stmtall = conn.createStatement();
    		ResultSet rsetall = stmtall.executeQuery(allquery);
    		while (rsetall.next() && rsetall != null) {
    			p_id_tofil = (rsetall.getObject(1)).toString();
    			permi =(rsetall.getObject(3)).toString();
    			owner_name =(rsetall.getObject(2)).toString();
    			if(permi.equals("2")) {
    				if (owner_name.equals(userName) && pic_id_searched_list.contains(p_id_tofil)) {
    					// specify the servlet for the image
    	    			out.println("<a href=\"/OnlineImageProcess/GetOnePic?big"+p_id_tofil+"\">");
    	    			// specify the servlet for the themernail
    	    			out.println("<img src=\"/OnlineImageProcess/GetOnePic?"+p_id_tofil +
    	    			"\"></a>");
    				} else {
    					continue;
    				}
    			} else if (permi.equals("1") && pic_id_searched_list.contains(p_id_tofil)) {
    				// specify the servlet for the image
	    			out.println("<a href=\"/OnlineImageProcess/GetOnePic?big"+p_id_tofil+"\">");
	    			// specify the servlet for the themernail
	    			out.println("<img src=\"/OnlineImageProcess/GetOnePic?"+p_id_tofil +
	    			"\"></a>");
    			} else if (!permi.equals("2") && !permi.equals("1")) {
    				Statement stmt1 = conn.createStatement();
    	        	ResultSet rset1 = stmt1.executeQuery("select user_name from groups where group_id='"+permi+"'");
    	        	rset1.next();
    	        	name = (rset1.getObject(1)).toString();
    	        	if (name.equals(userName) && pic_id_searched_list.contains(p_id_tofil)){
    	        		
    	        		// specify the servlet for the image
    	    			out.println("<a href=\"/OnlineImageProcess/GetOnePic?big"+p_id_tofil+"\">");
    	    			// specify the servlet for the themernail
    	    			out.println("<img src=\"/OnlineImageProcess/GetOnePic?"+p_id_tofil +
    	    			"\"></a>");
    	                		
    	        	}else{
    	        		Statement stmt2 = conn.createStatement();
    	        		ResultSet rset2 = stmt2.executeQuery("select friend_id from group_lists where group_id='"+permi+"'");
    	        		while (rset2.next() && pic_id_searched_list.contains(p_id_tofil)){
    	        			name = (rset2.getObject(1)).toString();
    	        			if (name.equals(userName)){
    	        				// specify the servlet for the image
    	    	    			out.println("<a href=\"/OnlineImageProcess/GetOnePic?big"+p_id_tofil+"\">");
    	    	    			// specify the servlet for the themernail
    	    	    			out.println("<img src=\"/OnlineImageProcess/GetOnePic?"+p_id_tofil +
    	    	    			"\"></a>");
    	        			}
    	        		}
    	        		stmt2.close();
    	        	}
    	        	stmt1.close();
    			}
    		}
    		
    	}
    	
		conn.close();
	}catch ( Exception e){ out.println( e.toString() );}
	

      out.write("\t\n");
      out.write("\n");
      out.write("\n");
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
