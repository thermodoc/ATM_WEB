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

import atmJava.Admin;
import atmJava.Customer;

/**
 * Servlet implementation class Customerdatabase
 */
@WebServlet("/Customerdatabase")
public class Customerdatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customerdatabase() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		
		
		String uname = request.getParameter("name");
		String pass = request.getParameter("pass");
		List<Customer> customer = new ArrayList<Customer>();
		customer=Customer.getCustomerDetailsFromDB();
		
		if(Admin.isAdmin(uname, pass))
		{
			request.setAttribute("customer",customer);
			RequestDispatcher rd = request.getRequestDispatcher("Customerdatabase.jsp");
			rd.forward(request, response);
		}
		else 
		{
			 out.println("<script type=\"text/javascript\">");
			   out.println("alert('User or password incorrect');");
			   out.println("location='Customerdatabase.jsp';");
			   out.println("</script>");
		}
		
	}

}
