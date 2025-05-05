package hisglobal.hisconfig;

import java.util.ResourceBundle;

public class HisConfigProperties {

	public static final String CR_FORMAT = "CR_FORMAT";
	public static final String RE_ORDER_COLOR = "RE_ORDER_COLOR";
	public static final String DRUG_INVENTORY = "DRUG_INVENTORY";
	public static final String THIRD_PARTY = "THIRD_PARTY";
	public static final String FULL_TITLE = "FULL_TITLE";
	public static final String REPORT_TITLE = "REPORT_TITLE";
	public static final String IN_ACTIVE_COLOR = "IN_ACTIVE_COLOR";
	public static final String BREAKAGE_COLOR = "BREAKAGE_COLOR";
	public static final String QC_COLOR = "QC_COLOR";
	public static final String CITY = "CITY";
	public static final String REPORT_ADDRESS = "REPORT_ADDRESS";
	public static final String REPORT_HEADER_A = "REPORT_HEADER_A";
	public static final String PO_GENRATION_TYPE = "PO_GENRATION_TYPE";
	public static final String DRAGDROPINMASTERREQUIRED="DRAGDROPINMASTERREQUIRED";
	
	
	private static ResourceBundle resObj = null;

	public static String getValue(final String key) {

		if (resObj == null)
			resObj = ResourceBundle
					.getBundle("hisglobal.hisconfig.hisProperties");

		return resObj.getString(key);

	}

}
