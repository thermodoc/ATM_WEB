package atm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import atmJava.Customer;

/**
 * Servlet implementation class TransferServlet
 */
@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferServlet() {
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
		String accountNo = request.getParameter("name");
		String pass = request.getParameter("pass");
		PrintWriter out = response.getWriter();
		try 
		{
			
		boolean isCustomer=Customer.customerValidation(Integer.parseInt(accountNo),Integer.parseInt(pass));
	
		if(isCustomer)
		{
			HttpSession session = request.getSession(true);
			session.setAttribute("No",accountNo);
			String url = response.encodeRedirectURL("Transfer2.jsp");
			
			 response.sendRedirect(url); 
		
		}
		else 
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Check ACCOUNT NO or PIN');");
			out.println("location='Transfer.jsp';");
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
