<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0);
//prevents caching at the proxy server
%>
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

<form action="CheckBalanceServlet" method="post" >
<h2 class="text-center">Check Balance</h2>   
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
</html>