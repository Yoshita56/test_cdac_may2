package hisglobal.hisconfig;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class HisLanguageProperties {

	private static ResourceBundle resObj = null;

	public static String getValue(HttpServletRequest request, final String key) 
	{

		resObj = ResourceBundle.getBundle("language.MessagesBundle");
		
		return resObj.getString(key);

	}

	public static String getValue(HttpSession session , final String key) {

		resObj = ResourceBundle.getBundle("language.MessagesBundle");
		
		return resObj.getString(key);

	}

	public static ResourceBundle getResourceBundleLocale(
			HttpServletRequest request) {

		resObj = ResourceBundle.getBundle("language.MessagesBundle");
		return resObj;

	}

}
