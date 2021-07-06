package atmJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class Customer {
	public int accountNumber,balance,PIN;
	public String accountHolder=new String();
	Customer(int accNo,String accHolder,int accPIN , int accBalance)
	{
		accountNumber=accNo;
		accountHolder=accHolder;
		PIN=accPIN;
		balance=accBalance;
		
	}
	Customer()
	{
		
	}
	{
	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

	
	}
	public static List<Customer> getCustomerDetailsFromDB()
	{
		List<Customer> customer = new ArrayList<Customer>();
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
			{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","whoami8888");
			Statement Stmnt=con.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, 
			        ResultSet.CONCUR_UPDATABLE);
			String customerSelectStatement = " select * from customer";
			ResultSet re =Stmnt.executeQuery(customerSelectStatement );
			
			
			while(re.next())
			{
				
//			customer.get(index).accountNumber=re.getInt(1);	
//			customer.get(index).accountHolder=re.getNString(2);
//			customer.get(index).PIN=re.getInt(3);
//			customer.get(index).balance=re.getInt(4);
		customer.add(new Customer(re.getInt(1),re.getNString(2),re.getInt(3),re.getInt(4)));
	
		
			}
			
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
		
	}
	private void Customer() {
		// TODO Auto-generated method stub
		
	}
	public void showCustomerDetails()
	{
	
	
		System.out.println(this.accountNumber+"			"+this.accountHolder+"			"+this.PIN+"		"+this.balance);
		
	}
	public String showCustomerBalance()
	{
		return "The balance in your account is "+this.balance;
	}

	public void updateCustomerBalance(int i)
	{
		try {
			
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","whoami8888");
				
				 String CustomerUpdate = "update customer set balance = ? where account_no = ? ";
				 PreparedStatement pe=con.prepareStatement(CustomerUpdate);
					
					pe.setInt(1, this.balance);
					pe.setInt(2, (this.accountNumber));
					pe.executeUpdate();
					
				
				
				
				
				;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
	}
	public boolean isAccount( int accNumber)
	{List<Customer> customer = new ArrayList<Customer>();
	
	customer=Customer.getCustomerDetailsFromDB();
	int i=Customer.customerIndex(accNumber);
		int flag = 0;
		for( i = 0 ; i < customer.size() ; i++)
		{
			if(customer.get(i).accountNumber == accNumber)
			{
				flag=1;
			}
		}
			
			if(flag==1)
			{
				return true;
			}
			return false;
		
			
	
	}
	public static boolean customerValidation(int accNumber , int PIN)
	{
		List<Customer> customer = new ArrayList<Customer>();
		customer=Customer.getCustomerDetailsFromDB();
		int flag =0;
		for(int i = 0 ; i < customer.size() ; i++)
		{
			if(customer.get(i).accountNumber == accNumber)
			{
				if(customer.get(i).PIN==PIN)
				{
					flag=1;
					
						
				}	

			}
		}
		if(flag==1)
		{
			return true;
		}
		return false;
		
	}
	

public static int customerIndex( int accNumber )
{
	List<Customer> customer = new ArrayList<Customer>();
	customer=Customer.getCustomerDetailsFromDB();
	
	int i;
	for( i = 0 ; i < customer.size() ; i++)
	{
		if(customer.get(i).accountNumber == accNumber)
		{
			
			
				return i;
				
					
				

		}
	}

	return -1;
	
}
public static boolean isNumeric(String s) {  
    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
} 
public static String transfer(int tempTransfer, int tempAccno,int tempAccno2 )
{	try
	{
	List<Customer> customer = new ArrayList<Customer>();
	customer=Customer.getCustomerDetailsFromDB();
	int i= customerIndex(tempAccno2);

	if(tempAccno==customer.get(i).accountNumber)
		{
		return "Cant transfer to the same account";
			
		}
	if(!customer.get(i).isAccount( tempAccno))
	{
		return "Enter Correct Account number";
	
	}
	else 
	{
		int j = customerIndex(tempAccno);
		if(tempTransfer > customer.get(j).balance)
		{
		return "insuffient bal";
		
		}
		if(tempTransfer >= 1000 && tempTransfer <= 10000)
		{
			customer.get(i).balance=customer.get(i).balance+tempTransfer;
			customer.get(j).balance=customer.get(j).balance-tempTransfer;
			customer.get(i).updateCustomerBalance(i);
			customer.get(j).updateCustomerBalance(j);
		
			
			
			Ministatement.updateMiniStatementTransferDebit(tempTransfer,  tempAccno, tempAccno2);
			Ministatement.updateMiniStatementTransferCredit(tempTransfer, tempAccno, tempAccno2);
		}
			else 
			{
				return ("Beyond limits ");
				
			}
										
		
			
//							 
			return ("Transfer Completed\n");
		
	}
	}
	catch (IndexOutOfBoundsException  e)
		{
		return "Enter Valid Account Number";	
		}
}
}




