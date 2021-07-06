package atm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import atmJava.Admin;
import atmJava.Balance;

/**
 * Servlet implementation class ShowBalanceServlet
 */
@WebServlet("/ShowBalanceServlet")
public class ShowBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBalanceServlet() {
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
		String uname = request.getParameter("uname");
	
		String pass = request.getParameter("pass");
		List<Integer> arr = (Balance.showBalance());
		if(Admin.isAdmin(uname, pass))
		{
		String result = ("Total : "+arr.get(0)+"\n1000s : "+arr.get(1)+"\n500s : "+arr.get(2)+"\n100s : "+arr.get(3));
		request.setAttribute("result",result);
		RequestDispatcher rd = request.getRequestDispatcher("Showbalance.jsp");
		rd.forward(request, response);
		
 
		}
		else 
		{
			 out.println("<script type=\"text/javascript\">");
			   out.println("alert('User or password incorrect');");
			   out.println("location='Loadcash.jsp';");
			   out.println("</script>");
		}
		
	}

}
