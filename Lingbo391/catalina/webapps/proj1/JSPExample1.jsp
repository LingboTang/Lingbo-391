<TABLE BORDER = 2>
	<%	for (int i = 0;i< 10;i++) {	%>
	<TR>
	<TD> Number</TD>
		<TD><%=i+1%> </TD>
	</TR>
	<%	}	%>
</TABLE>

<%@ page import="java.util.*" %>
<HTML> 
    <BODY> 
	<%
	java.util.Date date = new java.util.Date();
	%>
	Hello! The time is now
	<%= date %>	
    </BODY> 
</HTML> 
