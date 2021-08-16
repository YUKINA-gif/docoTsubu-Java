package model;

import dao.TweetDAO;

public class PostTweetLogic {
	public void execute(Tweet tweet) {
		TweetDAO dao = new TweetDAO();
		dao.create(tweet);
	}
}