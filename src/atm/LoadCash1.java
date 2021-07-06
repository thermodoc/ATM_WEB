package atm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import atmJava.Balance;

/**
 * Servlet implementation class LoadCash1
 */
@WebServlet("/LoadCash1")
public class LoadCash1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadCash1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Balance.checkifBalalanceIsNull();
		int denomination = Integer.parseInt(request.getParameter("denomination"));
		Balance.loadBalance(denomination);
		out.println("Succesfully Loaded cash in the ATM");
		request.setAttribute("balance","Succesfully Loaded cash in the ATM"); 
		
		RequestDispatcher rd = request.getRequestDispatcher("LoadbalanceDeno.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}
