package com.shsxt.crm.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public class LoginUserUtil {
	
	/**
	 * 从cookie中获取userId
	 * @param request
	 * @return
	 */
	public static Integer loadUserIdFromCookie(HttpServletRequest request) {
		String userIdString = CookieUtil.getCookieValue(request, "userIdString");
		if (StringUtils.isBlank(userIdString)) {
			return null;
		}
		
		Integer userId = UserIDBase64.decoderUserID(userIdString);
		return userId;
	}
	
	/**
	 * cookie中获取userName
	 * @param request
	 * @return
	 */
	public static String loadUserNameFromCookie(HttpServletRequest request) {
		String userName = CookieUtil.getCookieValue(request, "userName");
		return userName;
	}
	
}
