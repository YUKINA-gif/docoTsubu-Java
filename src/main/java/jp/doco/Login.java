package jp.doco;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.LoginLogic;
import model.User;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException,IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		User user = new User(name,pass);
		
		LoginLogic loginLogic = new LoginLogic();
		boolean isLogin = loginLogic.execute(user);
		
		if(isLogin) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/tweet.jsp");
		dispatcher.forward(request, response);
	}
}
