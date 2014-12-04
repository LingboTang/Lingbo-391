<!DOCTYPE html PUBLIC "-//w3c//dtd html 4.0 trnsitional//en">
<HTMl>
<Head>
<META http-equiv="content-type" content="text/html; charset=windows-1252">
<title>Sample program -- Profile page</title>
</HEAD>

<BODY background="http://jmw-custombuilder.com/wp-content/uploads/2013/04/jmw_background3.jpg">
<%
if (session.getAttribute("USERNAME") == null){
	response.sendRedirect("welcome.html");
}else{
	String userName = (String)session.getAttribute("USERNAME");
	out.println("<p align='right'>Welcome,"+userName+"</p><form NAME='logout' ACTION='logout.jsp' Method='get'><input style='float: right;' NAME='back' TYPE='submit' VALUE='log out'></form>");
}
%>
<p>
<font size="8" face="Verdana" color="#ffffff">
CREATE GROUPS
</font>
</p>
<p>
</p><hr>
<form name="create-groups" method="POST" enctype="multipart/form-data" action="CreateGroups">
<table border="0" width="30%" cellpadding="5">

<tr valign="top" align="left"><td><b><i>Group Name</i></b></td>
<td><input type=text name=GPNM maxlength=24>
</td>
</tr>
<tr valign="top" align="left"><td><b><i>Notice</i></b></td>
<td><textarea name="DESC" cols="30" rows="3" maxlength="1024">
Enter Notice.
</textarea>
</td>
</tr>
<tr>
<td><input name=".submit" value="Create" type="submit"></td>
<td><input name="reset" value="reset" type="reset"></td>
</tr>
</form>

<form name="friend_list" method="POST" enctype="multipart/form-data" action="SelectFriends">
<tr>
<td><input name=".submit" value="Browse Friends" type="submit"></td>
</tr>
</table>
</form>


</BODY>
</HTML>
