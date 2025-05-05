package hisglobal.utility;

import java.util.*;

public class StatusMessage
{
	StatusMessage()
	{
		Locale myLocale = Locale.getDefault();

		System.out.println("...................????" + myLocale.getDisplayLanguage());
		System.out.println("...................????" + myLocale.getDisplayCountry());
		System.out.println("...................????" + myLocale.getDisplayLanguage(Locale.FRENCH));
		System.out.println("...................????" + myLocale.getDisplayCountry(Locale.FRENCH));

	}

	public static ResourceBundle labels = ResourceBundle.getBundle("hisResourceBundle");

	public static String strExc = labels.getString("exc");
	public static String strExcApplicationExec = labels.getString("excHisApplicationExecution");
	public static String strExcRecordNotFound = labels.getString("excRecordNotFound");
	public static String strExcNotAnOPDcase = labels.getString("excNotAnOPDcase");
	public static String strExcUnitTransRecordNotFound = labels.getString("excRecordNotFound");
	public static String strExcUnitTransDataAccess = labels.getString("excRecordNotFound");
	public static String strSaveDuplicateCard = labels.getString("saveDuplicateCardST");
	//public static String strExcRecordNotFound = labels.getString("excRecordNotFound");
	//public static String strExcRecordNotFound = labels.getString("excRecordNotFound");
	//public static String strExcRecordNotFound = labels.getString("excRecordNotFound");
}
