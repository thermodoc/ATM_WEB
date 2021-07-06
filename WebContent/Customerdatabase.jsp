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
<div class="login-form">

  <form action="Customerdatabase" method="post" >
  <h2 class="text-center">Customer Database</h2> 
  <div class="form-group"> 
   UserName:        
    <input type="text" name="name" required class="form-control" placeholder="User Name"/>
    </div>
     <div class="form-group">
   Password:
    <input type="password" name="pass" required class="form-control" placeholder="Password"/>
    </div>
      <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Submit</button>
        </div>

</form>
</div>

</table>


</body>

</body>
</html>