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
<div class="login-form">
 <link rel="stylesheet" href="style.css">
<form action="TransferServlet2" method="post" >
<h2 class="text-center">Transfer money</h2>   
  <div class="form-group">   
    Account number to transfer to  :        
    <input type="number" name="AccNo" required = "required" class="form-control" placeholder="Account Number"/>
   </div>
    Enter Amount to Transfer
 <div class="form-group">
    <input type="number" name="amount" required class="form-control" placeholder="INR"/>
    </div>
   <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Log in</button>
        </div>
        

</form>
</div>

<%
   String accNo =(String) session.getAttribute("No");%>
<% if (accNo==null) {
	String url = response.encodeRedirectURL("Transfer.jsp");
	response.sendRedirect(url);
	}

	   String withDraw =(String) request.getAttribute("debit");
%>

	
<div style="text-align: center;">
    <pre><%=withDraw %></pre>
</div>
</form>



</body>

</body>
</html>