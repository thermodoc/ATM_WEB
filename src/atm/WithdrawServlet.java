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

import atmJava.Balance;
import atmJava.Customer;

/**
 * Servlet implementation class WithdrawServlet
 */
@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithdrawServlet() {
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
		response.setContentType("text/html");
		String accountNo = request.getParameter("name");
		String pass = request.getParameter("pass");
		HttpSession session = request.getSession(true);

		try 
		{
			
		boolean isCustomer=Customer.customerValidation(Integer.parseInt(accountNo),Integer.parseInt(pass));
		
		if(isCustomer)
		{
		
			session.setAttribute("No",accountNo);
			String url = response.encodeRedirectURL("Withdraw2.jsp");
			
			 response.sendRedirect(url); 
		
		}
		else if(!isCustomer)
		{
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Check ACCOUNT NO or PIN');");
			out.println("location='Withdraw.jsp';");
			out.println("</script>");

		}
		
		
		}
		catch(NumberFormatException e)
		{
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('Enter Valid Acoount Number or PIN');");
			   out.println("location='Withdraw.jsp';");
			   out.println("</script>");
			
		}
		catch(NullPointerException e) {
			
		}
	}

}
