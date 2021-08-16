package dao;

import java.sql.*;
import java.util.*;
import model.Tweet;

public class TweetDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/example";
	private final String DB_USER = "sa";
	private final String DB_PASS = "secret";

    public List<Tweet> findAll() {
    	List<Tweet>tweetList = new ArrayList<>();
    	
    	try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)) {
    		String sql = "SELECT ID,NAME,TEXT FROM MUTTER ORDER BY ID DESC";
    		PreparedStatement pStmt = conn.prepareStatement(sql);
    		
    		ResultSet rs = pStmt.executeQuery();
    		
    		while(rs.next()) {
    			int id = rs.getInt("ID");
    			String userName = rs.getString("NAME");
    			String text = rs.getString("TEXT");
    			Tweet tweet = new Tweet(id,userName,text);
    			tweetList.add(tweet);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    		return null;
    	}
    	return tweetList;
    }
    
    public boolean create(Tweet tweet) {
    	try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)) {
    		String sql = "INSERT INTO MUTTER(NAME,TEXT) VALUES (?,?)";
    		PreparedStatement pStmt = conn.prepareStatement(sql);
    		
    		pStmt.setString(1,tweet.getUserName());
    		pStmt.setString(2,tweet.getText());
    		
    		int result = pStmt.executeUpdate();
    		if(result != 1) {
    			return false;
    		}
    	} catch (SQLException e){
    		e.printStackTrace();
    		return false;
    	}
    	return true;
    }
}
