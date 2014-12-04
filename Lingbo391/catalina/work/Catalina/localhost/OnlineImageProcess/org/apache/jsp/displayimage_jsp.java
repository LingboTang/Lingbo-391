package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class displayimage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html><head>\n");
      out.write("<script type=\"text/javascript\"></script>\n");
      out.write("<meta http-equiv=\"content-type\" content=\"text/html; charset=windows-1252\">\n");
      out.write("<title>Upload Image</title>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("body{\n");
      out.write("\tfont-family: 'Helvetica', 'Arial', sans-serif;\n");
      out.write("}\n");
      out.write("#form_a{\n");
      out.write("\tmargin: 0 auto;\n");
      out.write("\tposition:absolute;\n");
      out.write("\tright: 0px;\n");
      out.write("\twidth: 60px;\n");
      out.write("}\n");
      out.write("#update{\n");
      out.write("\tmargin: 0 auto;\n");
      out.write("\twidth: 280px;\n");
      out.write("}\n");
      out.write("#desc{\n");
      out.write("\tpadding:5px;\n");
      out.write("\tborder:2px;\n");
      out.write("\tsolid #ccc;\n");
      out.write("-webkit-border-radius: 5px;\n");
      out.write("\tborder-radius: 5px;\n");
      out.write("}\n");
      out.write("input[type=text] {\n");
      out.write("\tpadding:5px;\n");
      out.write("\tborder:2px;\n");
      out.write("\tsolid #ccc;\n");
      out.write("-webkit-border-radius: 5px;\n");
      out.write("\tborder-radius: 5px;\n");
      out.write("}\n");
      out.write("input[type=text]:focus {border-color:#333;}\n");
      out.write("input[type=submit]{padding:5px 5px; background:#fff; border:0 none;\n");
      out.write("\tcursor:pointer;\n");
      out.write("\t-webkit-border-radius: 5px;\n");
      out.write("\tborder-radius: 5px; }\n");
      out.write(".h1{\n");
      out.write("\tfont-family:Helvetica\n");
      out.write("\ttext-align:center}\n");
      out.write(".img{\n");
      out.write("\ttext-align:center;\n");
      out.write("\tmargin-top:10px;\n");
      out.write("\tmargin-bottom:10px;\n");
      out.write("\tpadding:50px;\n");
      out.write(".table{\n");
      out.write("\tborder: 1px solid black;\n");
      out.write("\ttext-align:center;\n");
      out.write("}\n");
      out.write(".log{\n");
      out.write("\ttext-align:right;\n");
      out.write("}\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<center>\n");
      out.write("<body background=\"http://wallpaperscraft.com/image/66199/1920x1200.jpg\">\n");
      out.write("\n");
String owner = (String)request.getAttribute("owner"); 
      out.write('\n');
      out.write('\n');

String uname = (String)session.getAttribute("USERNAME");
if (uname == null){
	response.sendRedirect("welcome.html");
}else{
	String userName = (String)session.getAttribute("USERNAME");
	out.println("<p align='right'>Welcome,"+userName+"</p><form NAME='Logout' ACTION='logout.jsp' Method='get'><input  NAME='back' TYPE='submit' VALUE='logout' id='form_a'></form>");
}
int flag =0;
if(uname.equals(owner) || uname == "admin"){
	flag = 1;
}
//get information
String id = (String)request.getAttribute("pic_id");
String permitted = (String)request.getAttribute("permitted");
String subject = (String)request.getAttribute("subject");
String place = (String)request.getAttribute("place");
String timing = (String)request.getAttribute("timing");
//timing = timing.substring(0, 10);
String description = (String)request.getAttribute("description");

//establish the connection to the underlying database
Connection conn = null;

//load and register the driver
Class drvClass = Class.forName("oracle.jdbc.driver.OracleDriver"); 
DriverManager.registerDriver((Driver) drvClass.newInstance());

//establish the connection 
conn = DriverManager.getConnection("jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS","lingbo","TlboSci1994");
conn.setAutoCommit(false);
	
//set up rank count.
Boolean viewed = false;
String userName = (String)session.getAttribute("USERNAME");
Statement stmt5 = conn.createStatement();
ResultSet rset5 = stmt5.executeQuery("select people_viewed from imagesviewer where image_id='"+id+"'");
Statement stmt4 = conn.createStatement();
ResultSet rset4 = stmt4.executeQuery("select counter from imagescount where image_id='"+id+"'");
rset4.next();
int count = Integer.parseInt(rset4.getObject(1).toString());
while (rset5.next()){
	if (userName.equals(rset5.getObject(1).toString())){
		viewed = true;
	}
}
if (!viewed){
	count++;
	stmt4.execute("UPDATE imagescount set counter='"+count+"' where image_id='"+id+"'");
	stmt4.execute("commit");
	stmt4.execute("INSERT INTO imagesviewer VALUES('"+id+"','"+userName+"')");
}

//if username is owner then flag = 1 and editing is allowed; else dont allow
if (flag == 1){
	out.println("<form action='deletepicture.jsp' method='post' name='delete'><input type= 'hidden' name='pic_id' value='"+id+"'><input type='submit' name='deletebuton' value='Delete'></form>");
	out.println("<p class='img'><img src='/OnlineImageProcess/GetOnePic?disp"+id+"'></p>");
	out.println("<form name='update-image' method='POST' action='UpdateImage' id='update'>");
	out.println("<table class>");
	out.println("<input type= 'hidden' name='picid' value='"+id+"'>");
	out.println("<tr valign='top' align='middle'><td width='52%'><b>Subject</b></td>");
	out.println("<td width='48%'><input type=text name=SUBJ value='"+subject+"'maxlength=128></td></tr>");
	out.println("<tr valign='top' align='middle'><td><b>Place</b></td>");
	out.println("<td><input type=text name=PLACE value='"+place+"' maxlength=128></td></tr>");
	out.println("<tr valign='top' align='middle'><td><b>Date</b></td>");
	out.println("<td><input type=text name=DATE value='"+timing+"'maxlength=38></td></tr>");
	out.println("<tr valign='top' align='middle'><td><b>Permitted</b></td>");

		
	out.println("<input type=hidden name=OWNER value="+userName+">");
	if(permitted.equals("1")){
		out.println("<td><select name='PERMITTED'><option value='1' selected='selected'>public</option><option value='2'>private</option>");
	}else if(permitted.equals("2")){
		out.println("<td><select name='PERMITTED'><option value='1'>public</option><option value='2' selected='selected'>private</option>");
	}else{
		out.println("<td><select name='PERMITTED'><option value='1'>public</option><option value='2'>private</option>");
	}
	String group_name = "";
	String group_id = "";

	Statement stmt1 = conn.createStatement();
	Statement stmt2 = conn.createStatement();
	Statement stmt3 = conn.createStatement();
	ResultSet rset1 = stmt1.executeQuery("select * from groups where user_name='"+userName+"'");
	while (rset1.next()){
		group_name = (rset1.getObject(3)).toString();
		group_id = (rset1.getObject(1)).toString();
		if(permitted.equals(group_id)){
			out.println("<option value='"+group_id+"' selected='selected'>"+group_name+"</option>");
		}else{
			out.println("<option value='"+group_id+"'>"+group_name+"</option>");
		}
	}
	ResultSet rset2 = stmt2.executeQuery("select group_id from group_lists where friend_id='"+userName+"'");
	while (rset2.next()){
		group_id = (rset2.getObject(1)).toString();
		ResultSet rset3 = stmt3.executeQuery("select group_name from groups where group_id='"+group_id+"'");
		while (rset3.next()){
			group_name = (rset3.getObject(1)).toString();
			if(permitted.equals(group_id)){
				out.println("<option value='"+group_id+"' selected='selected'>"+group_name+"</option>");
			}else{
				out.println("<option value='"+group_id+"'>"+group_name+"</option>");
			}
		}
	}
	out.println("</select></td></tr>");
	out.println("<tr valign='top' align='middle'><td><b> Description</b></td>");
	out.println("<td><textarea type=text name='DESC' cols='23' rows='3' maxlength='2048'>"+description+"</textarea>");
	out.println("</td></tr><tr valign='top' align='middle'><td><input name='submit' value='Update Image' type='submit' id='form_b'></td></form>");
	out.println("<form action='picturebrowse.jsp' method='get' name='back'>");
	out.println("<td><input name='gobackbutton' value='Go Back' type='submit'></td><form>");
	out.println("</tr></table>");
	
}else{
	//Display information only Not Editable
	out.println("<p class='img'><img src='/OnlineImageProcess/GetOnePic?disp"+id+"'></p>");
	out.println("<table class>");
	out.println("<input type= 'hidden' name='picid' value='"+id+"'>");
	out.println("<tr valign='top' align='middle'><td width='52%'><b>Subject</b></td>");
	out.println("<td width='48%'><input type=text name=SUBJ readonly='readonly' value='"+subject+"'maxlength=128></td></tr>");
	out.println("<tr valign='top' align='middle'><td><b>Place</b></td>");
	out.println("<td><input type=text name=PLACE readonly='readonly' value='"+place+"' maxlength=128></td></tr>");
	out.println("<tr valign='top' align='middle'><td><b>Date</b></td>");
	out.println("<td><input type=text name=DATE readonly='readonly' value='"+timing+"'maxlength=38></td></tr>");
	out.println("<tr valign='top' align='middle'><td><b>Permitted</b></td>");
	Statement stmt6 = conn.createStatement();
	ResultSet rset6 = stmt6.executeQuery("Select group_name from groups where group_id="+permitted);
	rset6.next();
	String permi = rset6.getObject(1).toString();
	out.println("<td><input type=text name=PERMITTED readonly='readonly' value='"+permi+"' maxlength=38></td></tr>");
	out.println("<tr valign='top' align='middle'><td><b> Description</b></td>");
	out.println("<td><textarea type=text name='DESC' cols='23' rows='3' maxlength='2048' readonly='readonly'>"+description+"</textarea>");
	out.println("</td></tr><tr valign='top' align='middle'>");
	out.println("<form action='picturebrowse.jsp' method='get' name='back'>");
	out.println("<td><input name='gobackbutton' value='Go Back' type='submit'></td><form>");
	out.println("</tr></table>");
}
conn.close();
 
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</center>\n");
      out.write("</body></html>\n");
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
