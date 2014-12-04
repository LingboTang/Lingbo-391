<%@ page language="java" import="java.io.*,java.util.*,javax.servlet.*" %>
<%@ page import="java.servlet.http.*,java.sql.*,oracle.jdbc.driver.*,java.text.*,java.net.*" %>
<%@ page import="org.apache.commons.fileupload.*, org.apache.commons.fileupload.disk.*, org.apache.commons.fileupload.servlet.*" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title> Photo List </title>
</head>
<body bgcolor="#FFFFFF" text="#cccccc" >
<center>
<h3>The List of Top 5 Images </h3>

<%
try {
    //String query = "select pic_id from pictures";
    String userName = (String)session.getAttribute("USERNAME");
    String query = "select * from images";
    //establish the connection to the underlying database
	Connection conn = null;
    String driverName = "oracle.jdbc.driver.OracleDriver";
   	String dbstring="jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS";
	Class drvClass = Class.forName(driverName); 
	DriverManager.registerDriver((Driver) drvClass.newInstance());
	//establish the connection 
    conn = DriverManager.getConnection(dbstring,"lingbo","TlboSci1994");
	conn.setAutoCommit(false);
	String p_id = "";
	int iterator = 0;
	if (userName.equals("admin")){
		query = "SELECT image_id,max(counter) from imagescount group by image_id order by max(counter) desc";
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		while (rset.next() && iterator < 5 ){
			p_id = (rset.getObject(1)).toString();
	    	 // specify the servlet for the image
            out.println("<a href=\"/OnlineImageProcess/GetOnePic?big"+p_id+"\">");
            // specify the servlet for the themernail
            out.println("<img src=\"/OnlineImageProcess/GetOnePic?"+p_id +
                       "\"></a>");
			iterator++;
		}
	}
}catch ( Exception ex ){ out.println( ex.toString() );}
%>
