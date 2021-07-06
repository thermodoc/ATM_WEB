package atmJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Ministatement
{
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
	public static void updateMiniStatementDebit(int tempWithdraw, int tempAcc)
	{
		List<Customer> customer = new ArrayList<Customer>();
		
		customer=Customer.getCustomerDetailsFromDB();
		int i=Customer.customerIndex(tempAcc);
		try {
		 String miniInsert = "insert into ministatement(account_no,transaction_remarks,transaction_type,transaction_amt) values(?,?,?,?)";
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","whoami8888");
			PreparedStatement pe=con.prepareStatement( miniInsert);
			
			//pe3.setInt(1, ministatement_id_counter++);
			pe.setInt(1, customer.get(i).accountNumber);
			pe.setString(2, "Debit "+(tempWithdraw)+"from the ATM");
			pe.setString(3, "Debit");
			pe.setInt(4,tempWithdraw);
			pe.executeUpdate();
			//Log.updateWithdraw(tempWithdraw, customer.get(i));
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	public static void updateMiniStatementTransferDebit(int tempWithdraw, int tempAcc,int tempAccno)
	{List<Customer> customer = new ArrayList<Customer>();
	
	customer=Customer.getCustomerDetailsFromDB();
	int i=Customer.customerIndex(tempAcc);
	int flag =Customer.customerIndex(tempAccno);
		try {
		 String miniInsert = "insert into ministatement(account_no,transaction_remarks,transaction_type,transaction_amt) values(?,?,?,?)";
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","whoami8888");
			PreparedStatement pe=con.prepareStatement( miniInsert);
			
		
			pe.setInt(1, customer.get(i).accountNumber);
			pe.setString(2, "Funds transfered to "+(customer.get(flag).accountNumber));
			pe.setString(3, "Debit");
			pe.setInt(4,tempWithdraw);
			pe.executeUpdate();
			//Log.updateDebitLog(tempWithdraw, customer, i, flag);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	public static void updateMiniStatementTransferCredit(int tempWithdraw, int tempAcc,int tempAccno)
	{
		try {
			List<Customer> customer = Customer.getCustomerDetailsFromDB();
			int i=Customer.customerIndex(tempAcc);
			int flag =Customer.customerIndex(tempAccno);
		 String miniInsert = "insert into ministatement(account_no,transaction_remarks,transaction_type,transaction_amt) values(?,?,?,?)";
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","whoami8888");
			PreparedStatement pe=con.prepareStatement( miniInsert);
			
		
			pe.setInt(1, customer.get(flag).accountNumber);
			pe.setString(2, "Credited from"+(customer.get(i).accountNumber));
			pe.setString(3, "Credit");
			pe.setInt(4,tempWithdraw);
			pe.executeUpdate();
			//Log.updateCreditLog(tempWithdraw,  customer, flag, i);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	public static void printMiniStatement(int acc)
	{	List<Customer> customer = Customer.getCustomerDetailsFromDB();
	int i=Customer.customerIndex(acc);
	List<String> miniStatement = new ArrayList<>();
		try {
			
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","whoami8888");
			System.out.println("MINI STATEMENT\nAccount Holder:"+customer.get(i).accountHolder+"\nAccount Number:"+customer.get(i).accountNumber+"\nAccount Balance:"+customer.get(i).balance);
			System.out.println("Transaction ID	Transaction Remarks		Transaction Type	Transaction Amt");
			String ministatementSelectStatement = " select * from ministatement where account_no=? order by transaction_id desc limit 5 ;\r\n"
					+ " ";
			PreparedStatement pe=con.prepareStatement( ministatementSelectStatement);
			pe.setInt(1,customer.get(i).accountNumber);
			ResultSet re =pe.executeQuery();
			
			while(re.next())
			{
				System.out.println(re.getInt(1)+"		"+re.getString(3)+"		"+re.getString(4)+"			"+re.getInt(5)+"\n");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
}

