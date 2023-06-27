package com.newsweb.utilities;

import javax.servlet.http.HttpServletRequest;

public class SessionUtility {

	private static SessionUtility instance = null;

	public static SessionUtility getInstance() {
		if (instance == null) {
			instance = new SessionUtility();
		}
		return instance;
	}

	public void putValue(HttpServletRequest request, String key, Object value) {
		request.getSession().setAttribute(key, value);
	}

	public Object getValue(HttpServletRequest request, String key) {
		return request.getSession().getAttribute(key);
	}
	
	public void removeValue(HttpServletRequest request, String key) {
		request.getSession().removeAttribute(key);
	}
}
