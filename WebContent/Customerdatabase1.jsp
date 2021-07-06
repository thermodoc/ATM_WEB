<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
    <%@page import="atmJava.Customer"%>
    <%@page import="java.util.ArrayList"%>
    
<!DOCTYPE html>
<html>
 <link rel="stylesheet" href="style.css">
<head>
<meta charset="ISO-8859-1">
<title>ATM APPLICATION</title>

</head>
<body>
<%@ include file="navadmin.jspf" %>

<pre>
<%
try{
List<Customer> customer= (ArrayList) request.getAttribute("customer");

%>
<table cellspacing="3" cellpadding="3">

<tr><th>Account Number</th><th>Account Holder</th><th>PIN</th><th>Balance</th></tr>
<%
for(Customer cu : customer)
{
%>
	<tr><td><%=cu.accountNumber%></td>
		<td><%=cu.accountHolder%></td>
		<td><%=cu.PIN%></td>
		<td><%=cu.balance%></td>
	</tr>
	<%}
}
catch(NullPointerException e)
{
	RequestDispatcher rd = request.getRequestDispatcher("Customerdatabase.jsp");
	rd.forward(request, response);
}
%>
</pre>
</table>


</body>

</body>
</html>