package model;

import java.util.List;
import dao.TweetDAO;

public class GetTweetLogic {
	public List<Tweet> execute() {
		TweetDAO dao = new TweetDAO();
		List<Tweet>tweetList = dao.findAll();
		return tweetList;
	}
}
