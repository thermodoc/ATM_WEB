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

<%  String accNo =(String) session.getAttribute("No");
if (accNo==null) {
	
	String url = response.encodeRedirectURL("Withdraw.jsp");
	response.sendRedirect(url);
	}%>
<div class="login-form">

<form action="WithdrawServlet2" method="post" >
<h2 class="text-center">Withdraw</h2>   
  <div class="form-group">   
   Enter Amount to Withdraw        
    <input type="number" name="amount" required = "required" class="form-control" placeholder="INR"/>
   </div>


   <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block" name="submit" value="submit">Enter</button>
        </div>

</form>
</div>
</body>

</body>
</html>