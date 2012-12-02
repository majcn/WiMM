package si.fri.wimm.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginBean {

	private String username;

	private String password;
	
	private boolean loginFailed=false;
	
	@Inject
	private LoggedInUserBean userBean;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoginFailed() {
		return loginFailed;
	}

	/***
	 * Action for login
	 * @return
	 */
	public String userLogin() {
		if (userBean.loginUser(username, password)) {
			return "loginSuccessful";
		} else {
			loginFailed=true;
			return "loginUnSuccessful";
		}
	}
}
