<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
    
    
<!DOCTYPE html>
<html>
 <link rel="stylesheet" href="style.css">
<head>


<meta charset="ISO-8859-1">
<title>ATM APPLICATION</title>

</head>
<body>
<%@ include file="navadmin.jspf" %>
	<%

String uname = (String) session.getAttribute("name");
if (uname==null) {
	String url = response.encodeRedirectURL("Loadcash.jsp");
response.sendRedirect(url);
}
%>






<%
String result= (String) request.getAttribute("balance");

if(result==null)
{
result ="";
}
%>
<pre><%=result %></pre>
<% try
{session.invalidate();
}
catch(NullPointerException e)
{
	
}; %>

    
</body>
</html>