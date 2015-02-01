package cn.com.lc.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 开发工具类
 * 
 * @author Administrator
 *
 */
public class CommonUtils {

	public static String getCookieValue(HttpServletRequest request, String name) {
		Cookie[] cks = request.getCookies();
		if (cks == null) {
			return null;
		}
		for (Cookie cookie : cks) {
			if (name.equals(cookie.getName())) {
				return cookie.getValue();
			}
		}
		return null;

	}
}
