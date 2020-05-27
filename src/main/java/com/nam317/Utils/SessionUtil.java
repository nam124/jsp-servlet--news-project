package com.nam317.Utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
	private static SessionUtil sessionUtil = null;
	
	public static SessionUtil getInstance() {
		if(sessionUtil== null) {
			sessionUtil = new SessionUtil();
		}
		return sessionUtil;
	}

		public void putValue(HttpServletRequest request,String key, Object value) {  //duy trì thông tin ngư�?i dùng
			request.getSession().setAttribute(key, value);
		}
		public Object getValue(HttpServletRequest request,String key) {
		return request.getSession().getAttribute(key);
		}
		public void removeValue(HttpServletRequest request,String key) {// khi logout thì remove 
			request.getSession().removeAttribute(key);
		}
}
