package cn.com.lc.common.utils;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 开发工具类
 * 
 * @author Administrator
 *
 */
public class CommonUtils {

	/**
	 * 根据Cookie名称获取Cookie值
	 * @param request HttpServletRequest
	 * @param name
	 * @return CookieValue
	 */
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
	/**
	 * 将表单参数封装Map映射到实体类中
	 * @param map
	 * @param clazz
	 * @return
	 */
	public static <T> T toBean(Map map,Class<T> clazz ){
		try{
			T  bean = clazz.newInstance();
			BeanUtils.populate(bean, map);
			return bean;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
