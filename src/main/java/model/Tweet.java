package model;

import java.io.Serializable;

public class Tweet implements Serializable {
	private int id;
	private String userName;
	private String text;

    public Tweet(String userName,String text) {
    	this.userName = userName;
    	this.text = text;
    }
    public Tweet(int id,String userName,String text) {
    	this.id = id;
    	this.userName = userName;
    	this.text = text;
    }
    public int getId() {
    	return id;
    }
    public String getUserName() {
    	return userName;
    }
    public String getText() {
    	return text;
    }
}
