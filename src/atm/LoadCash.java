package atm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import atmJava.Admin;
import atmJava.Balance;
import atmJava.Customer;

/**
 * Servlet implementation class LoadCash
 */
@WebServlet("/LoadCash")
public class LoadCash extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadCash() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		
		String pass = request.getParameter("pass");
		if(Admin.isAdmin(uname, pass))
		{
			HttpSession session = request.getSession();
			session.setAttribute("name",uname);
			String url = response.encodeRedirectURL("LoadbalanceDeno.jsp");
					
			 response.sendRedirect(url); 
//			 Cookie []  cookie = request.getCookies();
//					 for (Cookie cookies : cookie) {
//						  
//									System.out.println(cookies.getName()+" "+cookies.getValue());
//						    
//						  }
//						

		
//			 Cookie[]  cookies = null;
//			 Cookie  cookie = null;
//			 cookies = request.getCookies();
//			 if( cookies != null ) {
//		         
//
//		         for (int i = 0; i < cookies.length; i++) {
//		            cookie = cookies[i];
//
//		            if((cookie.getName( )).compareTo("first_name") == 0 ) 
//		            {
//		               cookie.setMaxAge(0);
//		               response.addCookie(cookie);
//		               System.out.print("Deleted cookie : " + cookie.getName( ) + "<br/>");
//
//		             
//		            }
//		      
//		         }
		}
		else 
		{
			 out.println("<script type=\"text/javascript\">");
			   out.println("alert('User or password incorrect');");
			   out.println("location='Loadcash.jsp';");
			   out.println("</script>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}

