<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
 <link rel="stylesheet" href="style.css">
<head>


<meta charset="ISO-8859-1">
<title>ATM APPLICATION</title>

</head>
<body>
<%@ include file="navadmin.jspf" %>
	<%
String uname = (String) session.getAttribute("name");
	System.out.print("hi"+uname);
if (uname==null) {
	String url = response.encodeRedirectURL("Loadcash.jsp");
response.sendRedirect(url);
}
%>


<div class="login-form">


<form action="LoadCash1" method="get" >
<h2 class="text-center">Load Balance</h2>   
  <div class="form-group">   
    How many Lakhs to load :        
    <input type="number" name="denomination" min="1" max="10"required class="form-control" placeholder = "INR"/>
  	   <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Log in</button>
        </div>
</div>
</div>
</form>
<%
String result= (String) request.getAttribute("balance");

if(result==null)
{
result ="";
}
%>
<pre><%=result %></pre>


    
</body>
</html>