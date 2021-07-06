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
 * Servlet implementation class WithdrawServlet2
 */
@WebServlet("/WithdrawServlet2")
public class WithdrawServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithdrawServlet2() {
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
		HttpSession session = request.getSession(true);
		String debitNo= request.getParameter("amount");
		String accNo = (String) session.getAttribute("No");

		String Withdraw =Balance.withDraw(Integer.parseInt(debitNo),Integer.parseInt(accNo));
	
		request.setAttribute("debit",Withdraw);
		
		RequestDispatcher rd = request.getRequestDispatcher("Withdraw2.jsp");
		rd.forward(request, response);
	}

}
