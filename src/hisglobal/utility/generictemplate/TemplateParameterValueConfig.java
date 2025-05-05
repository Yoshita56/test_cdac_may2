package hisglobal.utility.generictemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @copyright CDAC
 * @developer Pragya Sharma
 */

public class TemplateParameterValueConfig
{
	// Parameter Value Mapping List
	public static final	String PARAMETER_VALUE_PATIENT_NAME = "11";
	public static final	String PARAMETER_VALUE_AGE = "12";
	public static final	String PARAMETER_VALUE_GENDER = "13";
	public static final	String PARAMETER_VALUE_DOB = "14";
	public static final	String PARAMETER_VALUE_CASTE = "15";
	public static final	String PARAMETER_VALUE_FATHER_NAME = "16";
	public static final	String PARAMETER_VALUE_MOTHER_NAME = "17";
	public static final	String PARAMETER_VALUE_SPOUSE_NAME = "18";
	public static final	String PARAMETER_VALUE_FATHER_OCCUPATION = "19";
	public static final	String PARAMETER_VALUE_MOTHER_OCCUPATION = "20";
	public static final	String PARAMETER_VALUE_MOTHER_EDUCATION = "21";
	public static final	String PARAMETER_VALUE_FATHER_EDUCATION = "22";
	
	public static Map<String, String> PARAMETERS_VALUE_MAP = new HashMap<String, String>();
	static
	{
		PARAMETERS_VALUE_MAP.put(PARAMETER_VALUE_PATIENT_NAME, "Patient Name");
	}	
}
