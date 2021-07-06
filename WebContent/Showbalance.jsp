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
<%@ include file="navadmin.jspf" %>
<div class="login-form">
Show ATM balance
  <form action="ShowBalanceServlet" method="post" >
    <h2 class="text-center">ATM BALANCE</h2>
    <div class="form-group">  
   UserName:        
    <input type="text" name="uname" required class="form-control" placeholder="User Name"/>
   Password:
    <input type="password" name="pass" required class="form-control" placeholder="Password"/>
          <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Submit</button>
        </div>

</div>
</form>

<pre>
<%


String result= (String) request.getAttribute("result");
if(result==null)
{
	result="";
}
%>
<%=result %>
</pre>








</body>

</body>
</html>