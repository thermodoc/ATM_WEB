package atm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import atmJava.Customer;


/**
 * Servlet implementation class ATM_TRY
 */
@WebServlet("/CheckBalanceServlet")
public class CheckBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckBalanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("Checkbalance.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out = response.getWriter();
	
	
		String accountNo = request.getParameter("name");
		String pass = request.getParameter("pass");
	
		
	
	
		List<Customer> customer = new ArrayList<Customer>();
		customer=Customer.getCustomerDetailsFromDB();
		try {
		boolean isCustomer=Customer.customerValidation(Integer.parseInt(accountNo),Integer.parseInt(pass));
		
		
		
		//response.getWriter().append("The Balance of "+accountNo+"is"+customer.get(index).balance);
		 
	
		
		HttpSession session=request.getSession(); 
		
	
		
		if(isCustomer)
		{	int index =Customer.customerIndex( Integer.parseInt(accountNo));
			request.setAttribute("balance", "The Balance in "+customer.get(index).accountNumber+" is "+customer.get(index).balance);
			RequestDispatcher rd = request.getRequestDispatcher("Checkbalance1.jsp");
			rd.forward(request, response);
			
		

			
		}
		else
		{	

			out.println("<script type=\"text/javascript\">");
			   out.println("alert('AccountNumber or PIN Incorrect');");
			   out.println("location='Checkbalance.jsp';");
			   out.println("</script>");
		}
		}
		catch(NumberFormatException e)
		{
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('Enter Valid Acoount Number or PIN');");
			   out.println("location='Checkbalance.jsp';");
			   out.println("</script>");
			
		}
	}

}
