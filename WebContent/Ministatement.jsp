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
<pre>
   <%
try{
	 Customer customer =(Customer) request.getAttribute("customer");
	
	String intro = "MINI STATEMENT\nAccount Holder : "+customer.accountHolder+"\nAccount Number : "+customer.accountNumber+"\nAccount Balance : "+customer.balance;
	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","whoami8888");
	 String ministatementSelectStatement = " select * from ministatement where account_no=? order by transaction_id desc limit 5 ;\r\n"
				+ " ";
		PreparedStatement pe=con.prepareStatement( ministatementSelectStatement);
		pe.setInt(1,customer.accountNumber);
		ResultSet re =pe.executeQuery();
%>
<%=intro %>
<table cellspacing="3" cellpadding="3">

<tr><th>Transaction ID</th><th>Transaction Remarks</th><th>Transaction Type<th>Transaction Amount</th></tr>
<%
while(re.next())
{
%>
	<tr><td><%=re.getInt(1)%></td>
		<td><%=re.getString(3)%></td>
		<td><%=re.getString(4)%></td>
		<td><%=re.getString(5)%></td>
	</tr>
	<%}
}
catch(NullPointerException e)
{

}
 catch(SQLException e)
	{
		e.printStackTrace();
	}
	
%>
</pre>

    	
   
    





</body>

</body>
</html>