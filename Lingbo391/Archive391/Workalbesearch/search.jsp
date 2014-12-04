<%@ page language="java" import="java.io.*,java.util.*,javax.servlet.*" %>
<%@ page import="java.servlet.http.*,java.sql.*,oracle.jdbc.driver.*,java.text.*,java.net.*" %>
<%@ page import="org.apache.commons.fileupload.*, org.apache.commons.fileupload.disk.*, org.apache.commons.fileupload.servlet.*" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<HTML>
<HEAD>
<TITLE>Photo List</TITLE>
<style type="text/css">

body{
  font-family: 'Helvetica', 'Arial', sans-serif;
}
input[type=text] {
  padding:5px;
  border:4px;
  solid #ccc;
-webkit-border-radius: 5px;
  border-radius: 5px;
}
input[type=text]:focus {border-color:#333;}
input[type=submit]{padding:5px 5px; background:#eee; border:0 none;
  cursor:pointer;
  -webkit-border-radius: 5px;
  border-radius: 5px; }
</style>
<META http-equiv="content-type"
content="text/html; charset=windows-1250">
<body bgcolor="#ffff00" text="#000000" >

<FORM NAME="searchpicture" ACTION="searchresults.jsp" METHOD="post" >
	Enter keywords <INPUT TYPE="text" Name="key" size="50"></input>
	
	and/or time period (Format: DD/MM/YYYY) between <TD><input
		name="dateStart" type="text" size="30"></input></TD> and <TD><input
		name="dateEnd" type="text" size="30"></input></TD>
		
	<p>Select sorting method:</p>
	<input type="radio" name="SEARCHTYPE" value="recentFirst">Most
	Recent First<br> <input type="radio" name="SEARCHTYPE" value="recentLast">Most Recent Last<br> <input
	type="radio" name="SEARCHTYPE" value="relevant">Most Relevant<br>
	<input type="submit" name="SEARCHDATA" value="Search">

</form>

<%
	String error = (String) session.getAttribute("error");
	if (error != null) {
			out.println(error);
			session.removeAttribute("error");
	}
%>

<center>


<h3> The List of Images </h3>


<%	

	//  change the following parameters to connect to the oracle database
        String username = "btrinh";
        String password = "trinh187";
        String drivername = "oracle.jdbc.driver.OracleDriver";
        String dbstring ="jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS";
       
	
	try {
            //String query = "select pic_id from pictures";
            /**/String query = "select photo_id from images";
	    Class drvClass = Class.forName(drivername); 
            DriverManager.registerDriver((Driver) drvClass.newInstance());
	    
            Connection conn = DriverManager.getConnection(dbstring,username,password);
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(query);
            String p_id = "";

            while (rset.next() ) {
                p_id = (rset.getObject(1)).toString();

               // specify the servlet for the image
               out.println("<a href=\"/OnlineImageProcess/GetOnePic?big"+p_id+"\">");
               // specify the servlet for the themernail
               out.println("<img src=\"/OnlineImageProcess/GetOnePic?"+p_id +
                           "\"></a>");
            }
            stmt.close();
            conn.close();
        } catch ( Exception ex ){ out.println( ex.toString() );}
	
%>
<P><a href="profile.jsp"> Return </a>
</BODY>
</HTML>


