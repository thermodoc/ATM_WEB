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
<%@ include file="navadmin.jspf" %>
<div class="login-form">

  <form action="LoadCash" method="get" >
  <h2 class="text-center">Load Cash</h2> 
  <div class="form-group"> 
   UserName:        
    <input type="text" name="uname" required class="form-control" placeholder="User Name"/>
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



</body>

</body>
</html>