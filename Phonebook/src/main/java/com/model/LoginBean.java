package com.model;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class LoginBean implements Serializable {
	public static final String DISPATCH_LOGIN = "login";
	public static final String DISPATCH_LOGOUT = "logout";

	// private static java.util.logging.Logger logger =
	// Logger.getLogger(LoginBean.class);
	private static final long serialVersionUID = -2580518981076463177L;
	private int id;
	private String name;
	private String password;

	public LoginBean() {
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String userLogin() {
		String outcome = DISPATCH_LOGIN;
		FacesContext context = FacesContext.getCurrentInstance();
		if (this.getName() != null && this.getPassword() != null)
			if (!this.getName().equals("") && !this.getPassword().equals(""))
				if (this.getName().equals("deepak") && this.getPassword().equals("deepak")) {
					outcome = "welcome";
				} else {
					this.name = "username";
					this.password = "password";
					return null;
				}
		return outcome;

	}

	public String logout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		return DISPATCH_LOGOUT;
	}

}
