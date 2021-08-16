package jp.doco;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;
import model.User;
import model.Tweet;
import model.PostTweetLogic;
import model.GetTweetLogic;


public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Main() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//アプリケーションスコープを取得		
//		ServletContext application = this.getServletContext();
//		List<Tweet> tweetList = (List<Tweet>) application.getAttribute("tweetList");
//		
//		if(tweetList == null) {
//			tweetList = new ArrayList<>();
//			//アプリケーションスコープにインスタンスを格納			
//			application.setAttribute("tweetList",tweetList);
//		}
		
		GetTweetLogic getTweetLogic = new GetTweetLogic();
		List<Tweet> tweetList = getTweetLogic.execute();
		request.setAttribute("tweetList", tweetList);
		
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			response.sendRedirect("/docoTsubu/");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/tweet.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		
		if(text != null && text.length() != 0) {
			ServletContext application = this.getServletContext();
			List<Tweet> tweetList = (List<Tweet>)application.getAttribute("tweetList");
			
			HttpSession session = request.getSession();
			User loginUser = (User)session.getAttribute("loginUser");
			
			Tweet tweet = new Tweet(loginUser.getName(),text);
			
			PostTweetLogic postTweetLogic = new PostTweetLogic();
			postTweetLogic.execute(tweet);
			
			application.setAttribute("tweetList", tweetList);
		} else {
			request.setAttribute("errorMsg", "つぶやきが入力されていません");
		}
			GetTweetLogic getTweetLogic = new GetTweetLogic();
			List<Tweet> tweetList = getTweetLogic.execute();
			request.setAttribute("tweetList",tweetList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/tweet.jsp");
			dispatcher.forward(request, response);
		
	}

}
