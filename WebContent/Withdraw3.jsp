<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>ATM APPLICATION</title>
 <link rel="stylesheet" href="style.css">
</head>
<body>

<%@ include file="navcustomer.jspf" %>



<%
   String accNo =(String) session.getAttribute("No");%>
<% if (accNo==null) {
	String url = response.encodeRedirectURL("Withdraw.jsp");
	response.sendRedirect(url);
	}

	   String withDraw =(String) request.getAttribute("debit");
	   if (withDraw==null)
	   {
		   withDraw="";
	   }
	   %>
<% try
{session.invalidate();
}
catch(NullPointerException e)
{
	
}; %>
	
	<div style="text-align: center;">
   <pre style : ><%=withDraw %></pre>
   </div>





</body>

</body>
</html>