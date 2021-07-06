package atm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import atmJava.Customer;

/**
 * Servlet implementation class MinistatementServlet
 */
@WebServlet("/MinistatementServlet")
public class MinistatementServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MinistatementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		List<Customer> customer = new ArrayList<Customer>();
		customer=Customer.getCustomerDetailsFromDB();
		response.setContentType("text/html");
		String accountNo = request.getParameter("name");
		String pass = request.getParameter("pass");
		HttpSession session = request.getSession(true);
		boolean isCustomer=Customer.customerValidation(Integer.parseInt(accountNo),Integer.parseInt(pass)); 
		int i = Customer.customerIndex(Integer.parseInt(accountNo));
	
		if(isCustomer)
		{	int index =Customer.customerIndex( Integer.parseInt(accountNo));
		request.setAttribute("customer", customer.get(i));
		RequestDispatcher rd = request.getRequestDispatcher("Ministatement.jsp");
		rd.forward(request, response);
		
//			
		}
		else 
		{
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('AccountNumber or PIN Incorrect');");
			   out.println("location='Ministatement.jsp';");
			   out.println("</script>");
		}
		}

}
