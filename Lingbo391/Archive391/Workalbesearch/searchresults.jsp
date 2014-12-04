<%@ page language="java" import="java.io.*,java.util.*,javax.servlet.*" %>
<%@ page import="java.servlet.http.*,java.query.*,oracle.jdbc.driver.*,java.text.*,java.net.*" %>
<%@ page import="java.sql.*"%>
<%@ page import="org.apache.commons.fileupload.*, org.apache.commons.fileupload.disk.*, org.apache.commons.fileupload.servlet.*" %>
<%@ page import="db.Database.*" %>


<%
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
	if (request.getParameter("SEARCHTYPE") != null) {
		if (request.getParameter("SEARCHTYPE").equals("recentFirst")) {
			queryOrder = "images.timing DESC";
		} else if (request.getParameter("SEARCHTYPE").equals("recentLast")) {
			queryOrder = "images.timing ASC";
		} else if (request.getParameter("SEARCHTYPE").equals("relevant")) {
			queryOrder = "rank desc";
		}
		//if there is no order option selected, display an error
	} else {
			String error = "<p><b><font color=ff0000>You have not entered any search order specifications!</font></b></p>";
			session.setAttribute("error", error);
			response.sendRedirect("search.jsp");
	}
%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title> Photo List </title>
</head>
<body bgcolor="#FFFFFF" text="#cccccc" >
	
	
<%
	//obtain the class and the ID of the current logged in user
	String userID = (String) session.getAttribute("USERID");
	out.println("<H1>Search Results</H1>");
		
		
	String query = "select images.photo_id, images.subject,images.place,images.description";
	//When both keyword and date are entered
	if (keywords != "" && dateStart != "" && dateEnd != "") {
		query = query + ", ";
		String[] wordList = keywords.split(" "); //split the keyword value by space into an array for multiple keywords
		int matchNum = 0;
		for (int i = 0; i < wordList.length; i++) { //for every keyword create a query statement for it
			query = query + "6*score(" + Integer.toString(matchNum + 1)+ ")+3*score(" + Integer.toString(matchNum + 2)
						+ ")+score(" + Integer.toString(matchNum + 3)+ ") ";
			//if there are still more keywords, keep going (adds "+")
			if (i != wordList.length - 1)
				query = query + "+ ";
			matchNum = matchNum + 3;
		}
		query = query + "as rank ";
		query = query + " FROM images where ";
		out.println("Results of matching keywords: " + keywords+ " between dates " + dateStart + " and " + dateEnd);
		//query statement to search for a certain time period
		query = query + "images.timing between to_date('" + dateStart+ "', 'DD/MM/YYYY') AND to_date('" + dateEnd+ "', 'DD/MM/YYYY') AND ";
		//creates query statement for every key word to match with the score function
		int countNum = 0;
		for (int i = 0; i < wordList.length; i++) {
			query = query + "(contains(images.subject, '"+ wordList[i] + "', "+ Integer.toString(countNum + 1)+ ") > 0 OR contains(images.place, '"
			+ wordList[i] + "', "+ Integer.toString(countNum + 2)+ ") > 0 OR contains(images.description, '" + wordList[i]
			+ "', " + Integer.toString(countNum + 3)+ ") > 0)";
			if (i != wordList.length - 1)
				query = query + "OR ";
			countNum = countNum + 3;
		}
		query = query + "ORDER BY " + queryOrder; //order by the order query string made above
		
	}
	
	
	//No keywords entered
	else if (keywords.equals("") && (!dateStart.equals("") && !dateEnd.equals(""))) {
		out.println("Records of time period between " + dateStart+ " and " + dateEnd);
		query = query+ " FROM images where";
		query = query +" images.timing between to_date('" + dateStart
				+ "', 'DD/MM/YYYY') AND to_date('" + dateEnd
				+ "', 'DD/MM/YYYY') ORDER BY " + queryOrder;
		
	}
	
	//No Timeperiod entered
	else if (!keywords.equals("") && (dateStart.equals("") || dateEnd.equals(""))) {
		out.println("Resutls of matching keywords: " + keywords);
		query = query + ", ";
		String[] wordList = keywords.split(" ");
		int matchCount = 0;
		for (int i = 0; i<wordList.length; i++) {
			query = query + "6*score(" + Integer.toString(matchCount + 1)+ ")+3*score("+Integer.toString(matchCount+2)
					+")+score("+Integer.toString(matchCount+3)+")";
			if (i != wordList.length -1)
				query = query + "+ ";
			matchCount = matchCount+3;
		}
		
		query = query + "as rank ";
		
		query = query + "From images where ";
		
		int countNum = 0;
		for (int i = 0; i< wordList.length;i++) {
			query =query + "(contains(images.subject, '"+ wordList[i] + "', "+ Integer.toString(countNum + 1)+ ") > 0 OR contains(images.place, '"
					+ wordList[i] + "', "+ Integer.toString(countNum + 2)+ ") > 0 OR contains(images.description, '" + wordList[i]
					+ "', " + Integer.toString(countNum + 3)+ ") > 0)";
			if (i != wordList.length-1)
				query=query+"OR ";
			countNum = countNum+3;
		}
		query = query + "ORDER BY "+queryOrder;
		
	}
	
	
%>

<center>
<h3>The List of Images </h3>




<%
	//String keywords = (request.getParameter("key")).trim();
	//Database db = null;
	try{
		//db = new Database();
		//db.connect();
		
		Connection conn = null;
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String dbstring="jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS";
		//load and register the driver
		Class drvClass = Class.forName(driverName);
		DriverManager.registerDriver((Driver) drvClass.newInstance());
		//establish the connection
		conn = DriverManager.getConnection(dbstring,"btrinh","trinh187");
		conn.setAutoCommit(false);
		Statement stmt = conn.createStatement();
		//ResultSet rset = stmt.executeQuery("SELECT photo_id FROM images WHERE subject like "+"'%"+keywords+"%'");
		ResultSet rset = stmt.executeQuery(query);
		String p_id = "";
		while (rset.next() && rset != null) {
			p_id = (rset.getObject(1)).toString();
			// specify the servlet for the image
			out.println("<a href=\"/OnlineImageProcess/GetOnePic?big"+p_id+"\">");
			// specify the servlet for the themernail
			out.println("<img src=\"/OnlineImageProcess/GetOnePic?"+p_id +
			"\"></a>");
		}
		stmt.close();
		conn.close();
	} catch ( Exception e){ out.println( e.toString() );}
	
%>	



<P><a href="profile.jsp"> Return </a></P>
</body>
</center>
</html>
