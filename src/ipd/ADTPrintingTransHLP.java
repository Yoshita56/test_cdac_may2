package ipd;

import javax.servlet.http.HttpServletRequest;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisPrinter;
import hisglobal.utility.HisUtil;

public class ADTPrintingTransHLP
{
	public static String DATE_FORMAT_NOWwt = "dd-MMM-yyyy/HH:mm:ss";
	public static String DATE_FORMAT_NOW = "dd-MMM-yyyy";

	public static final char ESCAPECHAR = 27;
	public static final String BOLDON = ESCAPECHAR+""+'E';
	public static final String BOLDOFF = ESCAPECHAR+""+'F';
	
	public static final char FORMFEED = 12;
	
	public static String now(String frmt) {
		HisUtil util = null;
		String a = "";
		util = new HisUtil("transaction", " ADTPrintingTransHLP");
		try {
			a = util.getASDate(frmt);
		} catch (Exception e) {
			new HisException("ADTPrintingTransHLP",
					"ADTPrintingTransHLP.now()-->", e.getMessage());
		}
		/*
		 * Calendar cal = Calendar.getInstance(); SimpleDateFormat sdf = new
		 * SimpleDateFormat(DATE_FORMAT_NOW); return sdf.format(cal.getTime());
		 */
		return a;
	}

	

	public static String printSettingVisitor(int noOLines, String contents,String strHospitalCode_p) {
		int x = 0;
		try {
			IpdConfigUtil ipdConfig = new IpdConfigUtil(strHospitalCode_p);
			int k = 1, y = 0, temp = 0;
			x = Integer.parseInt(ipdConfig.getStrNoOfLineInVisitorPassSlip());
			temp = x;
			while (true) {
				if (temp >= noOLines) {
					y = temp - noOLines;
					break;

				} else {
					++k;
					temp = x * k;
				}
			}

			for (int j = 0; j < y; j++) {
				contents += "\n";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contents;
	}
	
	public static String printSettingAdmission(int noOLines, String contents, String strHospitalCode_p) {
		int x = 0;
		try {
			IpdConfigUtil ipdConfig = new IpdConfigUtil(strHospitalCode_p);
			int k = 1, y = 0, temp = 0;
			x = Integer.parseInt(ipdConfig.getStrNoOfLineInAdmissionSlip());
			temp = x;
			while (true) {
				if (temp >= noOLines) {
					y = temp - noOLines;
					break;

				} else {
					++k;
					temp = x * k;
				}
			}

			for (int j = 0; j < y; j++) {
				contents += "\n";
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return contents;
	}
	public static String printSettingNewBorn(int noOLines, String contents, String strHospitalCode_p) {
		int x = 0;
		try {
			IpdConfigUtil ipdConfig = new IpdConfigUtil(strHospitalCode_p);
			int k = 1, y = 0, temp = 0;
			x = Integer.parseInt(ipdConfig.getStrNoOfLineInNewBornBabyAdmissionSlip());
			temp = x;
			while (true) {
				if (temp >= noOLines) {
					y = temp - noOLines;
					break;

				} else {
					++k;
					temp = x * k;
				}
			}

			for (int j = 0; j < y; j++) {
				contents += "\n";
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return contents;
	}
	/**
	 * This function is used to transfer control to Printer
	 * @param data
	 * @param moduleName
	 * @param request
	 */
	public static void printData(String data,String moduleName,HttpServletRequest request)
	{
		HisPrinter  _hisPrinter=null;
		try
		{
			_hisPrinter=new HisPrinter();
			//System.out.println("print the data here");
			_hisPrinter.printFile(data, moduleName, request);
			/*try{
			Runtime rt = Runtime.getRuntime();
			Process prs = rt.exec("chmod 777 /root/ADTPrintSlip.sh");
			prs.waitFor();
			}catch(Exception e){
				e.printStackTrace();
			}
			HisPrinterSupport.createTempFile(data, "ADTPrintSlip");
			HisPrinterSupport.printSlipADT(request.getRemoteAddr(), "ADTPrintSlip.dat");*/
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	static class PrintData
	{
		StringBuffer fileContents;
		int iCountNoOfLines;
		String slipMode = "A";
	}
}
