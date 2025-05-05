package hisglobal.utility.generictemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @copyright CDAC
 * @developer Pragya Sharma
 */

public class TemplateParameterConfig
{
	// Initial Prameters Details
	public static final	String TEMPLATE_PARAMETER_BLOOD_GROUP = "10001";
	public static final	String TEMPLATE_PARAMETER_HEIGHT = "10002";
	public static final	String TEMPLATE_PARAMETER_WEIGHT = "10003";
	public static final	String TEMPLATE_PARAMETER_HB = "10004";
	public static final	String TEMPLATE_PARAMETER_BP_LOW = "10005";
	public static final	String TEMPLATE_PARAMETER_BP_HIGH = "10006";
	
	public static Map<String, String> TEMPLATE_PARAMETERS_MAP = new HashMap<String, String>();
	static
	{
		TEMPLATE_PARAMETERS_MAP.put(TEMPLATE_PARAMETER_BLOOD_GROUP, "Blood Group");
		TEMPLATE_PARAMETERS_MAP.put(TEMPLATE_PARAMETER_HEIGHT, "Height");
		TEMPLATE_PARAMETERS_MAP.put(TEMPLATE_PARAMETER_WEIGHT, "Weight");
		TEMPLATE_PARAMETERS_MAP.put(TEMPLATE_PARAMETER_HB, "HB");
		TEMPLATE_PARAMETERS_MAP.put(TEMPLATE_PARAMETER_BP_LOW, "Low Blood Pressure");
		TEMPLATE_PARAMETERS_MAP.put(TEMPLATE_PARAMETER_BP_HIGH, "Hight Blood Pressure");
	}
}
