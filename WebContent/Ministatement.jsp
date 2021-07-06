<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="atmJava.Customer"%>
    <%@page import="java.util.ArrayList"%>
        <%@page import="java.util.List"%>
        <%@page import="java.sql.*"%>
    
<!DOCTYPE html>
<html>

<head>


<meta charset="ISO-8859-1">
<title>ATM APPLICATION</title>

</head>
<body>
 <link rel="stylesheet" href="style.css">
<%@ include file="navcustomer.jspf" %>
<div class="login-form">

<form action="MinistatementServlet" method="post" >
<h2 class="text-center">MiniStatement</h2>   
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