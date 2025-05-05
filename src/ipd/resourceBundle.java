package ipd;

import java.util.ResourceBundle;


public class resourceBundle {
	 public static String getValueFromKey(String p_strKey) {
		 
	        ResourceBundle bundle1 = ResourceBundle.getBundle("ipd.hisIpdProperties");    
	        String strPathValue = bundle1.getString(p_strKey);
	        return strPathValue;
	    }
}
