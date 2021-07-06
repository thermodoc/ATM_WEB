<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
 <link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>ATM APPLICATION</title>

</head>
<body>

<%@ include file="navcustomer.jspf" %>

<div class="login-form">

<form action="WithdrawServlet" method="post" >
<h2 class="text-center">Withdraw money</h2>   
  <div class="form-group">   
    Account number :        
    <input type="number" name="name" required = "required" class="form-control" placeholder="Account Number"/>
   </div>
    PIN:
 <div class="form-group">
    <input type="password" name="pass" required class="form-control" placeholder="PIN"/>
    </div>
   <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Log in</button>
        </div>
        

</form>
</div>



</body>

</body>
</html>