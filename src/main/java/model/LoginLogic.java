package model;

import java.io.Serializable;

public class LoginLogic implements Serializable {
	public boolean execute(User user) {
		if(user.getPass().equals("1234")) {
			return true;
		}
		return false;
	}
}
