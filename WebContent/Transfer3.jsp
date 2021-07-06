<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>ATM APPLICATION</title>

</head>
<body>

<%@ include file="navcustomer.jspf" %>


<%
   String accNo =(String) session.getAttribute("No");%>
<% if (accNo==null) {
	String url = response.encodeRedirectURL("Transfer.jsp");
	response.sendRedirect(url);
	}

	   String withDraw =(String) request.getAttribute("debit");
	   if(withDraw==null)
	   {
		   withDraw="";
	   }
%>

	
<div style="text-align: center;">
    <pre><%=withDraw %></pre>
    <% try
{session.invalidate();
}
catch(NullPointerException e)
{
	
}; %>
</div>
</form>



</body>

</body>
</html>