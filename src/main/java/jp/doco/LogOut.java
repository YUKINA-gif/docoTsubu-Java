package jp.doco;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/logout.jsp");
		dispatcher.forward(request, response);
	}
}
