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



<%
String result= (String) request.getAttribute("balance");
if(result==null)
{
result="";
}
%>
<pre><%=result %></pre>





    
</body>
</html>