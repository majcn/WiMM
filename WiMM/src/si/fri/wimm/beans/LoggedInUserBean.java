package si.fri.wimm.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import si.fri.wimm.entity.User;

@Named
@SessionScoped
public class LoggedInUserBean implements Serializable{
	
	private static final long serialVersionUID = -1346922683103334907L;
	
	private User loggedInUser;

	public User getLoggedInUser() {
		return loggedInUser;
	}

	public boolean loginUser(String username, String password) {
		
		if (username.compareTo("test") == 0 && password.compareTo("test") == 0) {
			
			loggedInUser = new User();
			loggedInUser.setId(1);
			loggedInUser.setName("Gregor");
			loggedInUser.setSurname("Majcen");
			
			return true;
		} else {
			return false;
		}
	}
}
