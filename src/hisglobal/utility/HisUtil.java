/*
 Name		Ajay Kumar Gupta
 */
package hisglobal.utility;

import hisglobal.exceptions.HisRecordNotFoundException;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.vo.HospitalMstVO;
import mms.reports.vo.ApplicationErrorLogDetailRptVO;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.WebRowSet;

import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileItem;
//import org.apache.struts.upload.FormFile;
import org.apache.tika.Tika;

import billing.BillConfigUtil;

//import mms.MmsConfigUtil;

/**
 * 
 * Global Class for all kind of His Utilities. The Class contains Various
 * utility methods which are used in various part of HIS Project.
 * 
 * @author Ajay Kumar Gupta <br>
 *         Copyright ©C-DAC Noida
 * 
 */
public final class HisUtil {

	private boolean retValue = false;
	private String moduleName = "";
	private String fileName = "";
	// used for error messages
	private String errMsg = "";

	// used in getDatePicker() function
	// private static final String jsPath = "../../hisglobal/js/calendar.js";
	// private static final String cssPath =
	// "../../hisglobal/css/calendar-tas.css";
	private static final String imgPath = "../../hisglobal/images/imgDatepicker.png";

	// used in auditLog() function
	// private static Context auditLogCtx = null;
	// private static QueueConnectionFactory auditLogConnFactory = null;
	// private static Queue auditLogQueue = null;

	// private static final String AUDITLOG_QUEUE_NAME = "AUDIT_LOG_QUEUE";
	// private static final String AUDITLOG_FACTORY_NAME =
	// "AUDIT_LOG_QUEUE_CONNECTION_FACTORY";
	// private static final String AUDITLOG_PATH = "C:/logs/";
	
	private static final String PROCESS_LOG_TRANS_LOAD_THRESHOLD_SECONDS = "2";
	private static final String PROCESS_LOG_TRANS_SAVE_THRESHOLD_SECONDS = "5";
	private static final String PROCESS_LOG_TRANS_RESPONSE_THRESHOLD_SECONDS = "5";
	
	private static final String PROCESS_LOG_MASTERS_LOAD_THRESHOLD_SECONDS = "2";
	private static final String PROCESS_LOG_MASTERS_SAVE_THRESHOLD_SECONDS = "3";
	private static final String PROCESS_LOG_MASTERS_RESPONSE_THRESHOLD_SECONDS = "3";
	
	private static final String PROCESS_LOG_REPORTS_LOAD_THRESHOLD_SECONDS = "2";	
	private static final String PROCESS_LOG_REPORTS_DAILY_LISTING_GENERATE_THRESHOLD_SECONDS = "5";
	private static final String PROCESS_LOG_REPORTS_DAILY_STATS_GENERATE_THRESHOLD_SECONDS = "5";
	private static final String PROCESS_LOG_REPORTS_MONTHLY_LISTING_GENERATE_THRESHOLD_SECONDS = "10";
	private static final String PROCESS_LOG_REPORTS_MNTHLY_DSS_GENERATE_THRESHOLD_SECONDS = "10";
	private static final String PROCESS_LOG_REPORTS_YEARLY_LISTING_GENERATE_THRESHOLD_SECONDS = "20";
	private static final String PROCESS_LOG_REPORTS_YEARLY_DSS_GENERATE_THRESHOLD_SECONDS = "20";

	/**
	 * Constructor
	 * 
	 * @param moduleName
	 *            -The Current Working Module.
	 * @param fileName -
	 *            The Current Working Java File.
	 */
	public HisUtil(String moduleName, String fileName) {
		this.moduleName = moduleName;
		this.fileName = fileName;
	}

	/**
	 * Returns retValue
	 * 
	 * @return retValue
	 */
	public boolean getReturnValue() {
		return retValue;
	}

	/**
	 * returns option value for combo/list. qry will be non-parameterized query
	 * and will have only more than two fields, one for option name but could be
	 * more than one for option id. In this case the system will concatenate
	 * fields with ^
	 * 
	 * e.g. if ws has the value dept id, unit id, dept name
	 * 
	 * now we want to select dept name on basis of dept id then set selValueId
	 * is false, If it is true it will compare entire string i.e. dept id ^ unit
	 * id with dept id that will never match
	 * 
	 * @param ws
	 *            WebRowSet which contains the Values.
	 * @param selValue
	 *            If it is <b><code>true</code></b> then it will compare the
	 *            complete string with selValue and if it is <b><code>false</code></b>
	 *            it will compare first one string with selValue.
	 * @param defOption
	 *            If you want to add more than one option then concatenate with #
	 *            e.g. For More than one 0^Select Value#1^All Value [0/1
	 *            represent option value & Select Value/ All Value represent
	 *            option name]. If developer does not define option value then
	 *            the system will start with 0 and then increment by 1
	 * @param concateId
	 *            If it is <b><code>true</code></b> then this function will
	 *            concatenate all the column except the last name which will be
	 *            used for display name. If it is <b><code>false</code></b>
	 *            then this function will assume the first column as ID and the
	 *            last one as display name.
	 * @param selValueId
	 *            If it is <b><code>true</code></b> it will compare entire
	 *            string and if it is <b><code>false</code></b>it will
	 *            compare first column values.
	 * @return Option List in String.
	 * @throws Exception
	 *             if WebRowSet is blank.
	 * 
	 * @see #getOptionValue(WebRowSet, String, String, boolean)
	 */
	public String getOptionValue(WebRowSet ws, String selValue,
			String defOption, boolean concateId, boolean selValueId)
			throws Exception {
		if(selValue==null || selValue.equals("null"))
			selValue="0";
		String optStr = new String("");
		String optVal = "";
		String optName = "";
		String compStr = "";

		StringBuffer strBuffer = new StringBuffer(1000);
		String[] defOptionStr = null;
		String[] optValueStr = null;

		int i = 0, j = 0;
		int index = 0;
		int colCount = 0;

		this.retValue = false;
		this.errMsg = "";

		try {
			if (ws != null) {
				if (!defOption.equals("")) {
					defOptionStr = defOption.split("#");
					for (j = 0; j < defOptionStr.length; j++) {
						optValueStr = defOptionStr[j].replace('^', '#').split(
								"#");
						if (optValueStr.length == 1) {
							optVal = String.valueOf(index++);
							optName = optValueStr[0];
						} else {
							optVal = optValueStr[0];
							optName = optValueStr[1];
						}

						if (j == 0)
							strBuffer.append("<option #^# title=\""+optName+"\" value = \"" + optVal
									+ "\">" + optName + "</option>\n");
						else
							strBuffer.append("<option title=\""+optName+"\" value = \"" + optVal
									+ "\">" + optName + "</option>\n");
					}
				}

				// count the column provided
				colCount = ws.getMetaData().getColumnCount();
				boolean fFlag = false;
				while (ws.next()) {
					optVal = "";
					optName = "";

					// concatenate the id
					if (concateId) {
						for (j = 0; j < (colCount - 1); j++) {
							if (j == 0) {
								optVal = ws.getString(j + 1);
								if (!selValueId)
									compStr = optVal.replace("^", "#").split(
											"#")[0];
							} else
								optVal += "^" + ws.getString(j + 1);
						}
					} else {
						optVal = ws.getString(1);
						if (!selValueId)
							compStr = optVal.replace("^", "#").split("#")[0];

						j = colCount - 1;
					}

					if (selValueId)
						compStr = optVal;

					// option value
					optName = ws.getString(j + 1);
					if ((!selValue.equals("") && selValue.equals(compStr))) {
						strBuffer.append("<option selected title=\""+optName+"\" value = \"" + optVal
								+ "\">" + optName + "</option>\n");
						fFlag = true;
					} else if ((selValue.equals("") && (i++ == 0) && defOption
							.equals("")))
						strBuffer.append("<option #^# title=\""+optName+"\" value = \"" + optVal
								+ "\">" + optName + "</option>\n");
					else
						strBuffer.append("<option title=\""+optName+"\" value = \"" + optVal + "\">"
								+ optName + "</option>\n");
				} // end while block

				optStr = strBuffer.toString();
				if (fFlag) {
					optStr = optStr.replace("#^#", " ");
				} else {
					optStr = optStr.replace("#^#", "selected");
				}
				this.retValue = true;
			} // end if block
			else {
				this.errMsg = "HisUtil.getOptionValue(4 parameters) -->WebRowSet is blank !!";
				throw new Exception(this.errMsg);
			}
		} catch (Exception e) {
			this.errMsg = "HisUtil.getOptionValue(4 parameters) -->"
					+ e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			if (strBuffer != null)
				strBuffer = null;
			try {
				if (ws != null) {
					ws.close();
					ws = null;
				}
			} catch (Exception e) {
			}

			defOptionStr = null;
			optValueStr = null;
		}

		return optStr;
	}

	/**
	 * 
	 * returns the given amount in Decimal Format
	 * 
	 * @param amount
	 *            amount value in int, float, double.
	 * 
	 * @param decimalSize
	 *            Size of the decimal in integer, 3 will convert the amount in
	 *            0.000 Format. Negative integer or zero will return the amount
	 *            without Decimals.
	 * 
	 * 
	 * 
	 * @return amount by converting the value in decimal Format by considering
	 *         the decimalSize.
	 * 
	 * 
	 * 
	 * @throws Exception
	 * 
	 * @see #getAmountWithDecimal(String, int)
	 */

	public static String getAmountWithDecimal(double amount, int decimalSize)
			throws Exception {

		String strAmt = "";

		StringBuffer strPattern = new StringBuffer();

		DecimalFormat df = new DecimalFormat();

		if (decimalSize > 0) {

			strPattern.append(".");

			for (int i = 1; i <= decimalSize; i++) {

				strPattern = strPattern.append("0");

			}

		} else {

			strPattern.append("0");

		}

		df.applyPattern(strPattern.toString());

		if (amount == 0) {

			strAmt = "0" + strPattern.toString();

		} else {

			strAmt = df.format(amount);
		}

		if (df != null)

			df = null;

		if (strPattern != null)

			strPattern = null;

		return strAmt;

	}

	/**
	 * 
	 * returns the given amount in Decimal Format
	 * 
	 * @param amount
	 *            amount value in String
	 * 
	 * @param decimalSize
	 *            Size of the decimal in integer, 3 will convert the amount in
	 *            0.000 Format. Negative integer or zero will return the amount
	 *            without Decimals.
	 * 
	 * @return amount by converting the value in decimal Format by considering
	 *         the decimalSize.
	 * 
	 * @throws Exception
	 *             when amount value other than Digits.
	 * 
	 * @see #getAmountWithDecimal(double, int)
	 */

	public static String getAmountWithDecimal(String amount, int decimalSize)
			throws Exception {

		String strAmt = "";

		StringBuffer strPattern = new StringBuffer();

		DecimalFormat df = new DecimalFormat();

		if (decimalSize > 0) {

			strPattern.append(".");

			for (int i = 1; i <= decimalSize; i++) {

				strPattern = strPattern.append("0");

			}

		} else {

			strPattern.append("0");

		}

		df.applyPattern(strPattern.toString());

		if (!(Double.parseDouble(amount)==0.0)) {

			strAmt = df.format(Double.parseDouble(amount));

		} else {

			strAmt = "0" + strPattern.toString();
		}

		if (df != null)

			df = null;

		if (strPattern != null)

			strPattern = null;

		return strAmt;

	}

	/**
	 * returns option value for combo/list. qry will be non-parameterized query
	 * and will have only two fields, one for option value and other for option
	 * name.
	 * 
	 * 
	 * @param qry
	 *            SQL Query.
	 * @param selValue
	 *            If it is <b><code>true</code></b> then it will compare the
	 *            complete string with selValue and if it is <b><code>false</code></b>
	 *            it will compare first one string with selValue.
	 * @param defOption
	 *            If you want to add more than one option then concatenate with #
	 *            e.g. For More than one 0^Select Value#1^All Value [0/1
	 *            represent option value & Select Value/ All Value represent
	 *            option name]. If developer does not define option value then
	 *            the system will start with 0 and then increment by 1
	 * @return Option List in String.
	 * @throws Exception
	 *             if Query is Blank.
	 * 
	 * @see #getOptionValue(List, String, String) #getOptionValue(WebRowSet,
	 *      String, String, boolean)
	 * 
	 */
	public String getOptionValue(String qry, String selValue, String defOption)
			throws Exception {
		if(selValue==null || selValue.equals("null"))
			selValue="0";
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String optStr = new String("");
		String optVal = "";
		String optName = "";
		StringBuffer strBuffer = new StringBuffer(1000);
		String[] defOptionStr = null;
		String[] optValueStr = null;

		int i = 0;
		int index = 0;

		this.retValue = false;
		this.errMsg = "";

		try {
			if (!qry.equals("")) {
				// initilize HisDAO object
				daoObj = new HisDAO(this.moduleName, "HisUtil." + this.fileName);
				ws = daoObj.getQryResult(qry);
				if (ws != null && ws.size()>0) {
					if (!defOption.equals("")) {
						defOptionStr = defOption.split("#");
						for (int j = 0; j < defOptionStr.length; j++) {
							optValueStr = defOptionStr[j].replace('^', '#')
									.split("#");
							if (optValueStr.length == 1) {
								optVal = String.valueOf(index++);
								optName = optValueStr[0];
							} else {
								optVal = optValueStr[0];
								optName = optValueStr[1];
							}

							if (j == 0)
								strBuffer.append("<option title=\""+optName+"\" selected value = \""
										+ optVal + "\">" + optName
										+ "</option>\n");
							else
								strBuffer.append("<option title=\""+optName+"\" value = \"" + optVal
										+ "\">" + optName + "</option>\n");
						}
					}

					while (ws.next()) {
						if ((selValue.equals("") && (i++ == 0) && defOption
								.equals(""))
								|| (selValue != "" && selValue.compareTo(ws
										.getString(1)) == 0))
							strBuffer.append("<option title=\""+ws.getString(2)+"\" selected value = \""
									+ ws.getString(1) + "\">" + ws.getString(2)
									+ "</option>\n");
						else
							strBuffer.append("<option title=\""+ws.getString(2)+"\" value = \""
									+ ws.getString(1) + "\">" + ws.getString(2)
									+ "</option>\n");
					} // end while block

					optStr = strBuffer.toString();
					this.retValue = true;
				} // end if block
				if(ws.size()<=0)
				{
					//if(defOption.equals(""))
					strBuffer.append("<option title=\"Select Value\" selected value = \"0\">Select Value</option>\n");
					optStr = strBuffer.toString();
					this.retValue = true;
				}
			} else {
				this.errMsg = "HisUtil.getOptionValue(qry) -->Query is blank!!";
				throw new Exception(this.errMsg);
			}
		} catch (Exception e) {
			this.errMsg = "HisUtil.getOptionValue(qry) -->" + e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			if (strBuffer != null)
				strBuffer = null;
			try {
				if (ws != null) {
					ws.close();
					ws = null;
				}
			} catch (Exception e) {
			}

			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}

			defOptionStr = null;
			optValueStr = null;
		}

		return optStr;
	}
	/**
	 * returns option value for combo/list. qry will be non-parameterized query
	 * and will have only two fields, one for option value and other for option
	 * name.
	 * 
	 * 
	 * @param qry
	 *            SQL Query.
	 * @param selValue
	 *            If it is <b><code>true</code></b> then it will compare the
	 *            complete string with selValue and if it is <b><code>false</code></b>
	 *            it will compare first one string with selValue.
	 * @param defOption
	 *            If you want to add more than one option then concatenate with #
	 *            e.g. For More than one 0^Select Value#1^All Value [0/1
	 *            represent option value & Select Value/ All Value represent
	 *            option name]. If developer does not define option value then
	 *            the system will start with 0 and then increment by 1
	 * @return Option List in String.
	 * @throws Exception
	 *             if Query is Blank.
	 * 
	 * @see #getOptionValue(List, String, String) #getOptionValue(WebRowSet,
	 *      String, String, boolean)
	 * 
	 */
	public String getOptionValue_DefaultSelected(String qry, String selValue, String defOption,String defValue)
			throws Exception {
		if(selValue==null || selValue.equals("null"))
			selValue="0";
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String lastComboVal="0";
		String lastComboVal1="0";
		String optStr = new String("");
		String optVal = "";
		String optName = "";
		StringBuffer strBuffer = new StringBuffer(1000);
		String[] defOptionStr = null;
		String[] optValueStr = null;

		int i = 0;
		int index = 0;

		this.retValue = false;
		this.errMsg = "";

		try {
			if (!qry.equals("")) {
				// initilize HisDAO object
				daoObj = new HisDAO(this.moduleName, "HisUtil." + this.fileName);
				ws = daoObj.getQryResult(qry);

				if (ws != null && ws.size()>0) 
				{
					if (!defOption.equals("")) 
					{
						defOptionStr = defOption.split("#");
						for (int j = 0; j < defOptionStr.length; j++) 
						{
							optValueStr = defOptionStr[j].replace('^', '#')	.split("#");
							if (optValueStr.length == 1) {
								optVal = String.valueOf(index++);
								optName = optValueStr[0];
							} else {
								optVal = optValueStr[0];
								optName = optValueStr[1];
							}

							if (j == 0)
							{
								strBuffer.append("<option title=\""+optName+"\" selected value = \""
										+ optVal + "\">" + optName
										+ "</option>\n");
								lastComboVal1=optVal;
							}
							else
								strBuffer.append("<option title=\""+optName+"\" value = \"" + optVal
										+ "\">" + optName + "</option>\n");
						}
					}

					while (ws.next()) {
						if ((selValue.equals("") && (i++ == 0) && defOption.equals(""))
								|| (selValue != "" && selValue.compareTo(ws
										.getString(1)) == 0) || defValue.equals("2"))
						{
							
							if(selValue.compareTo(ws.getString(1)) == 0)
							{
								lastComboVal=selValue;
								strBuffer.append("<option title=\""+ws.getString(2)+"\" selected value = \""
										+ ws.getString(1) + "\">" + ws.getString(2)
										+ "</option>\n");
								//lastComboVal1=ws.getString(1) ;
								}
							else if(ws.isFirst() && defValue.equals("2"))
							{
							lastComboVal=ws.getString(1) ;
							strBuffer.append("<option title=\""+ws.getString(2)+"\" selected value = \""
									+ ws.getString(1) + "\">" + ws.getString(2)
									+ "</option>\n");
							//lastComboVal1=ws.getString(1) ;
							}							
							else
							{
								strBuffer.append("<option title=\""+ws.getString(2)+"\" value = \""
										+ ws.getString(1) + "\">" + ws.getString(2)
										+ "</option>\n");
							}
						}
						else
						{
							strBuffer.append("<option title=\""+ws.getString(2)+"\" value = \""
									+ ws.getString(1) + "\">" + ws.getString(2)
									+ "</option>\n");
							if(ws.isFirst() && defValue.equals("2"))
							{
								lastComboVal=ws.getString(1) ;
								/*if(lastComboVal1.equals("0") && selValue.equals("0"))
									lastComboVal1=ws.getString(1) ;
								else
									lastComboVal1=selValue ;*/
							}
						}
						
					} // end while block
					

					optStr = strBuffer.toString();
					this.retValue = true;
				} // end if block
				if(ws.size()<=0)
				{
					//if(defOption.equals(""))
					strBuffer.append("<option title=\"Select Value\" selected value = \"0\">Select Value</option>\n");
					optStr = strBuffer.toString();
					this.retValue = true;
				}
			} else {
				this.errMsg = "HisUtil.getOptionValue(qry) -->Query is blank !!";
				throw new Exception(this.errMsg);
			}
		} catch (Exception e) {
			this.errMsg = "HisUtil.getOptionValue(qry) -->" + e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			if (strBuffer != null)
				strBuffer = null;
			try {
				if (ws != null) {
					ws.close();
					ws = null;
				}
			} catch (Exception e) {
			}

			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}

			defOptionStr = null;
			optValueStr = null;
		}

		//return optStr+"$"+lastComboVal+"$"+lastComboVal1;
		return optStr+"$"+lastComboVal;
	}

	/**
	 * returns option value for combo/list. WebRowSet will have only two fields,
	 * one for option value and other for option name
	 * 
	 * 
	 * 
	 * @param data
	 *            List Object.
	 * @param selValue
	 *            If it is <b><code>true</code></b> then it will compare the
	 *            complete string with selValue and if it is <b><code>false</code></b>
	 *            it will compare first one string with selValue.
	 * @param defOption
	 *            If you want to add more than one option then concatenate with #
	 *            e.g. For More than one 0^Select Value#1^All Value [0/1
	 *            represent option value & Select Value/ All Value represent
	 *            option name]. If developer does not define option value then
	 *            the system will start with 0 and then increment by 1
	 * @return Option List in String.
	 * @throws Exception
	 *             if List is blank.
	 * 
	 * @see #getOptionValue(String, String, String) <br>
	 *      #getOptionValue(WebRowSet, String, String, boolean, boolean)
	 * 
	 */
	public String getOptionValue(List<?> data, String selValue, String defOption)
			throws Exception {
		if(selValue==null || selValue.equals("null"))
			selValue="0";
		String optStr = new String("");
		String optVal = "";
		String optName = "";
		StringBuffer strBuffer = new StringBuffer(1000);

		String[] defOptionStr = null;
		String[] optValueStr = null;

		int i = 0;
		int index = 0;

		this.retValue = false;
		this.errMsg = "";

		try {
			if (data != null) {
				if (!defOption.equals("")) {
					defOptionStr = defOption.split("#");
					for (i = 0; i < defOptionStr.length; i++) {
						optValueStr = defOptionStr[i].replace('^', '#').split(
								"#");
						if (optValueStr.length == 1) {
							optVal = String.valueOf(index++);
							optName = optValueStr[0];
						} else {
							optVal = optValueStr[0];
							optName = optValueStr[1];
						}

						if (i == 0)
							strBuffer.append("<option title=\""+optName+"\" selected value = \""
									+ optVal + "\">" + optName + "</option>\n");
						else
							strBuffer.append("<option title=\""+optName+"\" value = \"" + optVal
									+ "\">" + optName + "</option>\n");
					}
				}

				for (i = 0; i < data.size(); i = i + 2) {
					if ((selValue.equals("") && (i == 0) && defOption
							.equals(""))
							|| (selValue != "" && selValue
									.compareTo((String) data.get(i)) == 0))
						strBuffer.append("<option title=\""+(String) data.get(i + 1)+"\" selected value = \""
								+ (String) data.get(i) + "\">"
								+ (String) data.get(i + 1) + "</option>\n");
					else
						strBuffer.append("<option title=\""+(String) data.get(i + 1)+"\" value = \""
								+ (String) data.get(i) + "\">"
								+ (String) data.get(i + 1) + "</option>\n");
				} // end while block

				optStr = strBuffer.toString();
				this.retValue = true;
			} // end if block
			else {
				this.errMsg = "HisUtil.getOptionValue(ws) -->List is blank !!";
				throw new Exception(this.errMsg);
			}
		} catch (Exception e) {
			this.errMsg = "HisUtil.getOptionValue(ws) -->" + e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			if (strBuffer != null)
				strBuffer = null;
			defOptionStr = null;
			optValueStr = null;
		}

		return optStr;
	}

	/**
	 * returns option value for combo/list. qry will be non-parameterized query
	 * and will have only more than two fields, one for option name but could be
	 * more than one for option id. In this case the system will concatenate
	 * fields with ^
	 * 
	 * e.g. if ws has the value dept id, unit id, dept name
	 * 
	 * now we want to select dept name on basis of dept id then set selValueId
	 * is false, If it is true it will compare entire string i.e. dept id ^ unit
	 * id with dept id that will never match
	 * 
	 * @param ws
	 *            WebRowSet which contains the Values.
	 * @param selValue
	 *            If it is <b><code>true</code></b> then it will compare the
	 *            complete string with selValue and if it is <b><code>false</code></b>
	 *            it will compare first one string with selValue.
	 * @param defOption
	 *            If you want to add more than one option then concatenate with #
	 *            e.g. For More than one 0^Select Value#1^All Value [0/1
	 *            represent option value & Select Value/ All Value represent
	 *            option name]. If developer does not define option value then
	 *            the system will start with 0 and then increment by 1
	 * @param concateId
	 *            If it is <b><code>true</code></b> then this function will
	 *            concatenate all the column except the last name which will be
	 *            used for display name. If it is <b><code>false</code></b>
	 *            then this function will assume the first column as ID and the
	 *            last one as display name.
	 * @return Option List in String.
	 * @throws Exception
	 *             if WebRowSet is blank.
	 * 
	 * @see #getOptionValue(WebRowSet, String, String, boolean, boolean)
	 *      #getOptionValue(List, String, String)
	 * 
	 */
	public String getOptionValue(WebRowSet ws, String selValue,
			String defOption, boolean concateId) throws Exception {
		if(selValue==null || selValue.equals("null"))
			selValue="0";
		String optStr = new String("");
		String optVal = "";
		String optName = "";
		StringBuffer strBuffer = new StringBuffer(1000);
		String[] defOptionStr = null;
		String[] optValueStr = null;

		int i = 0, j = 0;
		int index = 0;
		int colCount = 0;

		this.retValue = false;
		this.errMsg = "";

		try {
			if (ws != null && ws.size()>0) {
				if (!defOption.equals("")) {
					defOptionStr = defOption.split("#");
					for (j = 0; j < defOptionStr.length; j++) {
						optValueStr = defOptionStr[j].replace('^', '#').split(
								"#");
						if (optValueStr.length == 1) {
							optVal = String.valueOf(index++);
							optName = optValueStr[0];
						} else {
							optVal = optValueStr[0];
							optName = optValueStr[1];
						}

						if (j == 0)
							strBuffer.append("<option title=\""+optName+"\" selected value = \""
									+ optVal + "\">" + optName + "</option>\n");
						else
							strBuffer.append("<option title=\""+optName+"\" value = \"" + optVal
									+ "\">" + optName + "</option>\n");
					}
				}

				// count the column provided
				colCount = ws.getMetaData().getColumnCount();

				while (ws.next()) {
					optVal = "";
					optName = "";

					// concatenate the id
					if (concateId) {
						for (j = 0; j < (colCount - 1); j++) {
							if (j == 0)
								optVal = ws.getString(j + 1);
							else
								optVal += "^" + ws.getString(j + 1);
						}
					} else {
						optVal = ws.getString(1);
						j = colCount - 1;
					}

					// option value
					optName = ws.getString(j + 1);

					if ((selValue.equals("") && (i++ == 0) && defOption
							.equals(""))
							|| (selValue != "" && selValue.compareTo(optVal) == 0))
						strBuffer.append("<option title=\""+optName+"\" selected value = \"" + optVal
								+ "\">" + optName + "</option>\n");
					else
						strBuffer.append("<option title=\""+optName+"\" value = \"" + optVal + "\">"
								+ optName + "</option>\n");
				} // end while block

				optStr = strBuffer.toString();
				this.retValue = true;
			} // end if block
			else 
			{
				//Commented By Amit Ateria-If Webrow set is blank -Page WasBecome Blank
				//this.errMsg = "HisUtil.getOptionValue(4 parameters) -->WebRowSet is blank !!";
				//throw new Exception(this.errMsg);
				optStr="<option value='0' title='Select Value'>Select Value</option>";
			}
		} catch (Exception e) {
			this.errMsg = "HisUtil.getOptionValue(4 parameters) -->"
					+ e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			if (strBuffer != null)
				strBuffer = null;
			/*
			 * try { if(ws != null) { ws.close(); ws = null; } } catch(Exception
			 * e) {}
			 */

			defOptionStr = null;
			optValueStr = null;
		}

		return optStr;
	}

	/**
	 * Returns amount in words
	 * 
	 * @param amt
	 *            amount value
	 * @return amount in words.
	 * @throws Exception
	 *             if Amount is Invalid.
	 */
	public String getAmountStr(String amt) throws Exception {

		WebRowSet ws = null;
		HisDAO daoObj = null;
		String amtStr = "";
		String sql = "";
		String rupees = "";
		String paisa = "";
		int pos = -1;

		this.retValue = false;
		this.errMsg = "";

		if (Double.parseDouble(amt) == 0)
			return "Zero Rupee Only";
		if (Double.parseDouble(amt) < 0)
			amt = amt.substring(1);

		rupees = amt;
		pos = amt.indexOf(".");

		if (pos != -1) {
			rupees = amt.substring(0, pos);
			paisa = amt.substring(pos + 1);
			if (!paisa.equals(""))
				if (Integer.parseInt(paisa) == 0)
					paisa = "";
		}

		if (!rupees.equals(""))
			if (Integer.parseInt(rupees) == 0)
				rupees = "";

		// execte function that converts amount in word
		if (paisa.equals(""))
			sql = "SELECT  bill_mst.DIGITWORD('" + rupees
					+ "')||' '||'' FROM DUAL";
		else {
			if (rupees.equals(""))
				sql = "SELECT  bill_mst.DIGITWORD('" + paisa
						+ "')||' '||'' FROM DUAL";
			else {
				sql = "SELECT  bill_mst.DIGITWORD('" + rupees
						+ "')||' '||'AND '||bill_mst.DIGITWORD('" + paisa
						+ "')||' '||'' FROM DUAL";
			}
		}

		try {
			if (!sql.equals("")) {
				// initilize HisDao object
				daoObj = new HisDAO(moduleName, "HisUtil." + fileName);
				ws = daoObj.getQryResult(sql);
				if (ws != null) {
					if (ws.next()) {
						amtStr = ws.getString(1);
						this.retValue = true;
					}
				}
			}
		} catch (Exception e) {
			this.errMsg = "HisUtil.getAmountStr() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			try {
				if (ws != null) {
					ws.close();
					ws = null;
				}
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			} catch (Exception e) {
			}
		}

		return amtStr;
	}

	/**
	 * returns string in initcap [e.g. Ajay Kumar Gupta]
	 * 
	 * @param myString
	 *            String.
	 * @return InitCap String.
	 * @throws Exception
	 */
	public String toInitCap(String myString) throws Exception {

		StringTokenizer st = new StringTokenizer(myString, " ");

		String initCapStr = "";
		String temp1 = "";
		String temp = "";

		this.retValue = false;
		this.errMsg = "";

		try {
			while (st.hasMoreTokens()) {
				temp = st.nextToken();
				temp1 = temp.substring(0, 1).toUpperCase();
				temp1 = temp1 + temp.substring(1).toLowerCase();
				initCapStr = initCapStr + temp1 + " ";
			}

			this.retValue = true;
		} catch (Exception e) {
			this.errMsg = "HisUtil.toInitCap() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			st = null;
		}

		return initCapStr;
	}

	/**
	 * Returns key value based on key name [keyName should be integer] lstData
	 * should have two fields first for key Value and last for Key Name The Data
	 * in lstData should be either in ascending order or descending order
	 * 
	 * This method uses Binary Search Algorithm
	 * 
	 * @param lstData
	 *            List
	 * @param keyName
	 *            keyName in Int.
	 * @param dataOrder
	 *            <b>0</b> Ascending order and <b>1</b> Descending order.
	 * @return String keyValue based on keyName
	 * @throws Exception
	 * 
	 * @see #search(List, String, int)
	 */
	public String search(List<?> lstData, int keyName, int dataOrder)
			throws Exception {

		String keyValue = "No Data Found !!";

		int recSize = 0;
		int lowValue = 0;
		int midValue = 0;
		int highValue = 0;
		int index = 0;
		int tempKeyName = 0;

		this.retValue = false;
		this.errMsg = "";

		try {
			if (lstData != null) {

				recSize = lstData.size() / 2; // record count
				lowValue = 0;
				highValue = recSize;

				if (recSize > 0) {
					while (lowValue <= highValue) {
						midValue = (int) ((lowValue + highValue) / 2);
						index = (midValue * 2 - 1);

						if (index < 0)
							index = 1;
						tempKeyName = Integer.parseInt((String) lstData
								.get(index));
						if (keyName == tempKeyName) {
							keyValue = (String) lstData.get(index - 1);
							break;
						} else {
							if (dataOrder == 0) { // data is in ascending
								// order
								if (keyName > tempKeyName)
									lowValue = midValue + 1;
								else
									highValue = midValue - 1;
							} else { // data is in descending order
								if (keyName > tempKeyName)
									highValue = midValue - 1;
								else
									lowValue = midValue + 1;
							}
						}
					} // end while loop
				} // end if block (recSize > 0)
			} // end if block
			this.retValue = true;
		} catch (Exception e) {
			this.errMsg = "HisUtil.search(int)-->" + e.getMessage();
			throw new Exception(this.errMsg);
		}

		return keyValue;
	}

	/**
	 * Returns key value based on key name [keyName should be integer] lstData
	 * should have two fields first for key Value and last for Key Name The Data
	 * in lstData should be either in ascending order or descending order
	 * 
	 * This method uses Binary Search Algorithm
	 * 
	 * @param lstData
	 *            List
	 * @param keyName
	 *            String keyName
	 * @param dataOrder
	 *            <b>0</b> Ascending order and <b>1</b> Descending order.
	 * @return String keyValue based on keyName
	 * @throws Exception
	 * 
	 * @see #search(List, int, int)
	 */
	public String search(List<?> lstData, String keyName, int dataOrder)
			throws Exception {

		String keyValue = "No Data Found !!";
		String tempKeyName = "";

		int recSize = 0;
		int lowValue = 0;
		int midValue = 0;
		int highValue = 0;
		int index = 0;

		this.retValue = false;
		this.errMsg = "";

		try {
			if (lstData != null) {

				recSize = lstData.size() / 2; // record count
				lowValue = 0;
				highValue = recSize;

				if (recSize > 0) {
					while (lowValue <= highValue) {
						midValue = (int) ((lowValue + highValue) / 2);
						index = (midValue * 2 - 1);

						if (index < 0)
							index = 1;
						tempKeyName = (String) lstData.get(index);
						if (keyName.equals(tempKeyName)) {
							keyValue = (String) lstData.get(index - 1);
							break;
						} else {
							if (dataOrder == 0) { // data is in ascending
								// order
								if (keyName.compareTo(tempKeyName) > 0)
									lowValue = midValue + 1;
								else
									highValue = midValue - 1;
							} else { // data is in descending order
								if (keyName.compareTo(tempKeyName) > 0)
									highValue = midValue - 1;
								else
									lowValue = midValue + 1;
							}
						}
					} // end while loop
				} // end if block (recSize > 0)
			} // end if block
			this.retValue = true;
		} catch (Exception e) {
			this.errMsg = "HisUtil.search(String) -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}

		return keyValue;
	}

	/**
	 * Returns Application Server Date dtFormat --> date format[dd/MM/yyyy,
	 * dd/MMM/yyyy etc]
	 * 
	 * if dtFormat is blank then default format is dd/MM/yyyy
	 * 
	 * @param dtFormat
	 *            Date Format in String.
	 * @return Application Server Date in required Format.
	 * @throws Exception
	 * @see #getDSDate(String)
	 */
	public String getASDate(String dtFormat) throws Exception {

		String dtStr = "";
		String defFormat = "";
		Calendar c = null;
		SimpleDateFormat dateFormat = null;

		this.retValue = false;
		this.errMsg = "";

		defFormat = dtFormat;
		if (defFormat.equals(""))
			defFormat = "dd/MM/yyyy";

		try {
			c = Calendar.getInstance();
			dateFormat = new SimpleDateFormat(defFormat);
			dtStr = dateFormat.format(c.getTime());
			this.retValue = true;
		} catch (Exception e) {
			this.errMsg = "HisUtil.getASDate() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			if (c != null) {
				c.clear();
				c = null;
			}
			if (dateFormat != null)
				dateFormat = null;
		}

		return dtStr;
	}

	/**
	 * Returns Database Server Date dtFormat --> date format[dd/mm/yyyy,
	 * dd/mon/yyyy etc]
	 * 
	 * if dtFormat is blank then default format is dd/mm/yyyy
	 * 
	 * @param dtFormat
	 *            Date Format in String.
	 * @return Database Server Date in required Format.
	 * @throws Exception
	 * 
	 * @see #getASDate(String)
	 */
	public String getDSDate(String dtFormat) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String dtStr = "";
		String qry = "";
		String defFormat = "";

		this.retValue = false;
		this.errMsg = "";

		defFormat = dtFormat;
		if (defFormat.equals(""))
			defFormat = "dd/mm/yyyy";
		qry = "SELECT TO_CHAR(SYSDATE,'" + defFormat + "') FROM DUAL";

		try {
			// initilize HisDAO object
			daoObj = new HisDAO(this.moduleName, "HisUtil." + this.fileName);
			ws = daoObj.getQryResult(qry);
			if (ws != null) {
				if (ws.next()) {
					dtStr = ws.getString(1);
					this.retValue = true;
				}
			}
		} catch (Exception e) {
			this.errMsg = "HisUtil.getDSDate()-->" + e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			try {
				if (ws != null) {
					ws.close();
					ws = null;
				}
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			} catch (Exception e) {
			}
		}

		return dtStr;
	}

	/**
	 * Returns date picker string.
	 * 
	 * @param fieldName
	 *            Field Name of The Date Picker
	 * @param dateValue
	 *            Value of the Date Picker.
	 * @param readOnly
	 *            true or false.
	 * @return String Date Picker.
	 * 
	 * @see #getDatePicker(String, String, String, boolean)
	 */
	
	public static String getDatePicker(String fieldName, String dateValue, boolean readOnly)
    {
        String dateString = "";
        StringBuilder strBuffer = new StringBuilder(500);
        strBuffer.append((new StringBuilder(" <input class='txtFldDate' size='9%' type=\"text\" name=\"")).append(fieldName).append("\" id=\"").append(fieldName).append("\" ").toString());
        if(readOnly)
            strBuffer.append(" readonly = \"false\" ");
        strBuffer.append((new StringBuilder(" value='")).append(dateValue).append("'>").toString());
        strBuffer.append((new StringBuilder(" <img name=\""+fieldName+"DateImage\" src=\"../../hisglobal/images/imgDatepicker.png\" id=\"")).append(fieldName).append("1\" style=\"cursor: pointer; border: 1px solid red;width:12px;\" title=\"Date selector\" ").toString());
        strBuffer.append(" onmouseover=\"Calendar.datePickerAjax(event,document.forms[0]."+fieldName+"),this.style.background='red';\" onmouseout=\"this.style.background=''\"> \n");
      /*  strBuffer.append("<script event=\"Click()\" language=\"JavaScript\"> \"+Calendar.setup({ ");
        strBuffer.append((new StringBuilder(" inputField : \"")).append(fieldName).append("\",ifFormat : \"%d-%b-%Y\",button : \"").append(fieldName).append("1\",singleClick : true\n").toString());
        strBuffer.append("})\";</script>\n");*/
        dateString = strBuffer.toString();
        strBuffer = null;
        return dateString;
    }
	/*
	public static String getDatePicker(String fieldName, String dateValue,
			boolean readOnly) {

		String dateString = "";

		StringBuilder strBuffer = new StringBuilder(500);

		strBuffer.append((new StringBuilder(
				" <input size='9%' type=\"text\" name=\"")).append(fieldName)
				.append("\" id=\"").append(fieldName).append("\" ").toString());

		if (readOnly)

			strBuffer.append(" readonly = \"false\" ");

		strBuffer.append((new StringBuilder(" value='")).append(dateValue)
				.append("'>").toString());

		strBuffer
				.append((new StringBuilder(
						" <img src=\"../../hisglobal/images/imgDatepicker.png\" id=\""))
						.append(fieldName)
						.append(
								"1\" style=\"cursor: pointer; border: 1px solid red;\" title=\"Date selector\" ")
						.toString());

		strBuffer
				.append(" onmouseover=\"Calendar.datePickerAjax(event,document.forms[0]."
						+ fieldName
						+ "),this.style.background='red';\" onmouseout=\"this.style.background=''\"> \n");

		dateString = strBuffer.toString();

		strBuffer = null;

		return dateString;
	}
*/
	/**
	 * Returns date picker string.
	 * 
	 * @param fieldName
	 *            Field Name of The Date Picker
	 * @param dateValue
	 *            Value of the Date Picker.
	 * @param idValue
	 *            Id value of Date Picker.
	 * @param readOnly
	 *            true or false.
	 * 
	 * @return String Date Picker.
	 * 
	 * @see #getDatePicker(String, String, boolean)
	 */
	public static String getDatePicker(String fieldName, String dateValue,
			String idValue, boolean readOnly) {

		String dateString = "";
		StringBuilder strBuffer = new StringBuilder(500);

		// strBuffer.append("<script language=\"JavaScript\" src=\"" + jsPath +
		// "\"></script>\n");
		// strBuffer.append("<link href=\"" + cssPath + "\" rel=\"stylesheet\"
		// type=\"text/css\">\n");

		strBuffer.append("<input size='9%' type=\"text\" name=\"" + fieldName
				+ "\" id=\"" + (fieldName + idValue) + "\" class='txtFldDate' ");
		if (readOnly)
			strBuffer.append(" readonly ");
		strBuffer.append("value='" + dateValue + "'>");
		strBuffer
				.append("<img src=\""
						+ imgPath
						+ "\" id=\""
						+ (fieldName + idValue)
						+ "1\" align=\"absmiddle\" style=\"cursor: pointer; border: 1px solid red;width:12px;\" title=\"Date selector\" ");

		strBuffer
		.append("onmouseover=\"datePickerAjaxMultiRow(event,'"+
		fieldName+"',this),this.style.background='red';\" onmouseout=\"this.style.background=''\"> \n");
		
		/*strBuffer
				.append(" onmouseover=\"Calendar.datePickerAjax(event,document.forms[0]."
						+ fieldName
						+ "),this.style.background='red';\" onmouseout=\"this.style.background=''\"> \n");*/

		/*
		 * strBuffer .append("<script language=\"JavaScript\">\n
		 * Calendar.setup\n(\n{ \n"); strBuffer.append("inputField : \"" +
		 * (fieldName + idValue) + "\",ifFormat : \"%d-%b-%Y\",button : \"" +
		 * (fieldName + idValue) + "1\",singleClick : true\n");
		 * strBuffer.append("}\n);\n</script>\n");
		 */
		dateString = strBuffer.toString();
		strBuffer = null;

		return dateString;
	}

	/**
	 * function that appends space up to given length
	 * 
	 * @param strValue
	 *            String
	 * @param len
	 *            length
	 *            
	 * @param mode  0 - Left Align 1 - Right Align          
	 * @return space Appended String.
	 * 
	 */
	public String appendSpace(String strValue, int len , int mode) {

		String retStrValue = "" ;
		
		if(mode == 0){
			
			retStrValue = appendSpaceAtEnd(strValue, len);
			
		}else{
			
			retStrValue = appendSpaceAtBegining(strValue, len);
			
		} 
		

		return retStrValue;
	} // end function

	public String appendSpaceAtBegining(String strValue, int len) {

		String retStrValue = "";
		int diffLen = 0;
		int i = 0;

		diffLen = len - strValue.length();
	
		if (diffLen > 0) {
			for (i = 0; i < diffLen; i++)
				retStrValue += " ";
		}
		
		retStrValue = retStrValue+""+strValue;

		return retStrValue;
	} // end function
	
	public String appendSpaceAtEnd(String strValue, int len) {

		String retStrValue = "";
		int diffLen = 0;
		int i = 0;

		diffLen = len - strValue.length();
		retStrValue = strValue;

		if (diffLen > 0) {
			for (i = 0; i < diffLen; i++)
				retStrValue += " ";
		}

		return retStrValue;
	} // end function
	
	
	/*
	 * function that breaks up the string based on given length [len --> total
	 * length, symbol --> used if string breaks up to identify the string] len
	 * should be greater than 2
	 */
	/**
	 * function that breaks up the string based on given length
	 * 
	 * @param strValue
	 *            source String.
	 * @param len
	 *            total length and should be greater than 2.
	 * @param symbol
	 * @return list of String
	 */
	public List<String> breakString(String strValue, int len, String symbol) {

		List<String> retStrValue = new ArrayList<String>();
		String tempStr = "";
		int diffLen = 0;

		tempStr = strValue;

		while (true) {
			diffLen = tempStr.length() - len;
			if (diffLen > 0) { // break up
				retStrValue.add(tempStr.substring(0, len - 2) + " " + symbol);
				tempStr = tempStr.substring(len - 2);
			} else {
				retStrValue.add(appendSpace(tempStr, len , 0));
				break;
			}
		}

		return retStrValue;
	} // end function

	/**
	 * used to read the entire contents from the file
	 * 
	 * @param filePath
	 *            Complete Path of the File.
	 * @return file content in String.
	 * @throws Exception
	 *             If File Does't Exist.
	 * 
	 * @see #writeFile(String, String)
	 */
	public String readFile(String filePath) throws Exception {

		FileInputStream fis = null;
		BufferedInputStream bis = null;
		File f = null;
		int j = 0;
		boolean eof = false;
		StringBuffer strBuff = null;

		this.errMsg = "";

		try {
			if (!filePath.trim().equals("")) {
				fis = new FileInputStream(filePath);
				bis = new BufferedInputStream(fis);
				f = new File(filePath);
				strBuff = new StringBuffer((int) f.length());

				while (!eof) {
					j = bis.read();
					if (j == -1)
						eof = true;
					else
						strBuff.append((new Character((char) j)).toString());
				}
			}
		} catch (Exception e) {
			this.errMsg = "HisUtil.readFile()-->" + e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			try {
				if (bis != null)
					bis.close();
				if (fis != null)
					fis.close();
				f = null;
				fis = null;
				bis = null;
			} catch (Exception e) {
			}
		}

		return strBuff.toString();
	} // end

	/**
	 * This function is used to write the contents into file. It will always
	 * overwrite into file
	 * 
	 * @param contents
	 *            String Contents.
	 * @param filePath
	 *            Complete File Path.
	 * @return true if File Write Successfully otherwise false.
	 * @throws Exception
	 * 
	 * @see #readFile(String)
	 */
	public boolean writeFile(String contents, String filePath) throws Exception {

		FileWriter FR = null;
		BufferedWriter OS = null;
		boolean retValue = false;
		this.errMsg = "";

		try {
			FR = new FileWriter(filePath, false);
			OS = new BufferedWriter(FR);
			OS.write(contents);
			retValue = true;
		} catch (Exception e) {
			this.errMsg = "HisUtil.writeFile()-->" + e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			try {
				if (OS != null)
					OS.close();
				if (FR != null)
					FR.close();

				OS = null;
				FR = null;
			} catch (Exception e) {
			}
		}

		return retValue;
	}

	/**
	 * This method is used to send the message to JMS server. It accepts the
	 * following parameter
	 * 
	 * 
	 * Currently the method is commented b'coz Tomcat is not application server
	 * String
	 * 
	 * 
	 * @param session
	 *            this is session object which is created at the time of login.
	 *            So you don't worry about its attributes.
	 * @param modName
	 *            Name of Module.
	 * @param task
	 *            Name of process.
	 * @param tabFieldInfo
	 *            This field will have the table.field details with unique index
	 *            that will be used with linking with oldValue/newValue
	 *            1^tableName^fieldName#2^tableName^fieldName
	 * 
	 * @param oldValue
	 *            This field will have the old value in the following format if
	 *            there is more than one row then each & every row will be
	 *            concatenated with # symbol
	 *            1^value1^value2^value3...#2^value1^value2....
	 * @param newValue
	 *            This field will have the new value in the following format if
	 *            there is more than one row then each & every row will be
	 *            concatenated with # symbol
	 *            1^value1^value2^value3...#2^value1^value2....
	 * @param remarks
	 *            There is not necessary that index order should be same with
	 *            tabFieldInfo/oldVale/newValue
	 * @param fileName
	 *            Audit Log File Name (do n't specify the path) remarks : Any
	 *            other info that you want to display [you can pass primary key]
	 * @return true if successfully Logged, false otherwise.
	 * @throws Exception
	 */
	public static boolean auditLog(HttpSession session, String modName,
			String task, String tabFieldInfo, String oldValue, String newValue,
			String remarks, String fileName) throws Exception {

		boolean retVal = false;
		// String errorStr = "";

		/*
		 * commented b'coz Tomacat is not application server String userName =
		 * ""; String ipAddr = ""; String auditMsg = "";
		 * 
		 * QueueConnection auditLogConn = null; QueueSession auditLogSession =
		 * null; QueueSender audiLogSender = null; MapMessage audiLogInfo =
		 * null;
		 * 
		 * try { //extract module/process name from session userName =
		 * (String)session.getAttribute("userName"); ipAddr =
		 * (String)session.getAttribute("IP_ADDR");
		 * 
		 * if(userName == null) userName = ""; if(ipAddr == null) ipAddr = "";
		 * 
		 * if(fileName.equals("") || userName.equals("") || modName.equals("")) {
		 * errorStr = "HisUtil.auditLog()-->FileName/user/module is blank";
		 * throw new Exception(errorStr); }
		 * 
		 * //java.util.Hashtable props = new java.util.Hashtable();
		 * //props.put("java.naming.factory.initial",
		 * "com.pramati.naming.client.PramatiClientContextFactory");
		 * //props.put("java.naming.provider.url", "rmi://10.103.0.18:9191");
		 * //props.put("java.naming.provider.url", "rmi://localhost:9191");
		 * //props.put(Context.SECURITY_PRINCIPAL,"root");
		 * //props.put(Context.SECURITY_CREDENTIALS,"pramati");
		 * //props.put("com.pramati.naming.realm","system");
		 * 
		 * 
		 * //getting connection factory & queue reference //if(auditLogCtx ==
		 * null) auditLogCtx = new InitialContext(props); if(auditLogCtx ==
		 * null) auditLogCtx = new InitialContext(); if(auditLogConnFactory ==
		 * null) auditLogConnFactory = (QueueConnectionFactory)
		 * auditLogCtx.lookup(AUDITLOG_FACTORY_NAME); if(auditLogQueue == null)
		 * auditLogQueue = (Queue) auditLogCtx.lookup(AUDITLOG_QUEUE_NAME);
		 * 
		 * //getting queue connection auditLogConn =
		 * auditLogConnFactory.createQueueConnection(); auditLogSession =
		 * auditLogConn.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
		 * audiLogSender = auditLogSession.createSender(auditLogQueue);
		 * audiLogInfo = auditLogSession.createMapMessage();
		 * 
		 * //create message that is to be sent to JMS server
		 * audiLogInfo.setString("1",modName); audiLogInfo.setString("2",task);
		 * audiLogInfo.setString("3",userName);
		 * audiLogInfo.setString("4",ipAddr);
		 * audiLogInfo.setString("5",tabFieldInfo);
		 * audiLogInfo.setString("6",oldValue);
		 * audiLogInfo.setString("7",newValue);
		 * audiLogInfo.setString("8",remarks);
		 * audiLogInfo.setString("9",AUDITLOG_PATH + fileName);
		 * 
		 * audiLogSender.send(audiLogInfo); retVal = true; }
		 * catch(NamingException ne) { errorStr = "HisUtil.auditLog()-->" +
		 * ne.getMessage(); throw new Exception(errorStr); } catch(JMSException
		 * je) { errorStr = "HisUtil.auditLog() -->" + je.getMessage(); throw
		 * new Exception(errorStr); } finally { try { if(auditLogConn != null)
		 * auditLogConn.close(); if(auditLogSession != null)
		 * auditLogSession.close(); if(audiLogSender != null)
		 * audiLogSender.close();
		 * 
		 * auditLogConn = null; auditLogSession = null; audiLogSender = null;
		 * audiLogInfo = null; } catch(Exception e) { errorStr =
		 * "HisUtil.auditLog()-->" + e.getMessage(); throw new
		 * Exception(errorStr); } }
		 */

		return retVal;
	}

	/**
	 * used to create a dropdown component.
	 * 
	 * @param ws
	 *            WebRowSet which contains values.
	 * @param index
	 *            unique index start with 1.
	 * @param listSize
	 *            size of the list box to display at a time.
	 * @param concateId
	 *            If it is <b><code>true</code></b> then this function will
	 *            concatenate all the column except the last name which will be
	 *            used for display name. If it is <b><code>false</code></b>
	 *            then this function will assume the first column as ID and the
	 *            last one as display name.
	 * @return dropdown component in String.
	 */
	public String getDropDown(WebRowSet ws, int index, int listSize,
			boolean concateId) {
		StringBuffer sb = new StringBuffer("");
		try {
			
			if (ws != null) {
				ws.beforeFirst();
				List listIndex = getIndexList();
				int counterOrder = 0;
				char targetChar = '.';

				while (ws.next()) {
					String sourceString = ws.getString(2);
					char sourceChar = ' ';
					int sourceindex = 0;
					if (!sourceString.trim().equals("")) {
						sourceChar = sourceString.trim().charAt(0);
					} else {
						sourceChar = ' ';
					}

					if (sourceChar != targetChar) {
						sourceindex = sourceChar - 48;
						if (sourceindex < 0) {
							listIndex.set(0, Integer.valueOf(counterOrder));
						} else {
							listIndex.set(sourceindex, Integer
									.valueOf(counterOrder));
						}

						targetChar = sourceChar;
					}
					counterOrder++;
				}
				sb.append("<div id='script' style='display:none'>");
				sb.append((new StringBuilder("<SELECT id='listArray")).append(
						index).append("' >").toString());
				for (int i = 0; i < listIndex.size(); i++)
					sb.append((new StringBuilder("<option value='")).append(
							listIndex.get(i)).append("'>").append(i).append(
							"</option>").toString());

				sb.append("</select></div>");
				ws.beforeFirst();
				// HisUtil util = new HisUtil("Global Tag Lib",
				// "AutoComplete.doStartTag()");
				String strOptions = getOptionValue(ws, "0", "", concateId);
				sb.append((new StringBuilder("<SELECT class='bsCombo' id='realitems")).append(
						index).append("'").toString());
				sb
						.append((new StringBuilder(" size='"))
								.append(listSize)
								.append(
										"' onchange='realitemsOnChangeEventHandler(this)' onkeypress= 'return setSelectValue(this,event,\"dropdown")
								.append(index)
								.append(
										"\");' onclick= 'return setSelectValue(this,event,\"dropdown")
								.append(index).append("\");'>").toString());
				sb.append(strOptions);
				sb.append("</SELECT> ");
			} else {
				throw new Exception("webrowset is null");
			}
		} catch (Exception e) {
			new Exception("HisUtil-->HisUtil.getDropDown()--> "
					+ e.getMessage());
		}
		return sb.toString();
	}

	/**
	 * used by {@link #getDropDown(WebRowSet, int, int, boolean)}
	 * 
	 * @return
	 */
	private List getIndexList() {
		List indexList = new ArrayList();
		for (int i = 0; i < 46; i++)
			indexList.add(i, new Integer(-1));

		return indexList;
	}

	
	public static String getParameterFromHisPathXML(String _Param){
		
		//System.out.println("HISUTIL::getParameterFromHisPathXML");
		String osType = null;
		String paramValue=null;
		try{
			osType = System.getProperties().getProperty("os.name");
			if(osType.startsWith("Win")){
				_Param += "_WIN";
				//paramValue = getParameterFromXML("c:/RAOL/AHIMS/hisPath.xml", _Param);
				paramValue = getParameterFromXML("c:/AIIMSBBW/AHIMSG5/hisPath.xml", _Param);
			}else{
				_Param += "_LIN";
		    	paramValue = getParameterFromXML("/opt/AIIMSBBW/AHIMSG5/hisPath.xml", _Param);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return paramValue;
	}
	/*
	public static String getParameterFromXML1(String _XMLpath,String _Param){
		String parameterValue = null;
		DocumentBuilderFactory dbf = null;
		DocumentBuilder db = null;
		Document document = null;
		File file = null;
		NodeList nodeList = null;
		Node node = null;
		try{
			dbf = DocumentBuilderFactory.newInstance();
		    db = dbf.newDocumentBuilder();
		    file = new File(_XMLpath);
		    document = db.parse(file);
		    nodeList = document.getElementsByTagName(_Param);
		    node=nodeList.item(0);
		    parameterValue = node.getFirstChild().getNodeValue();
		}catch(Exception e){
			dbf = null;
			db = null;
			document = null;
			file = null;
			nodeList = null;
			node = null;
		}
		return parameterValue;
	}
	*/
	public static String getParameterFromXML(String _XMLpath,String _Param){
		String strResult="";
		try{
			SaxHandler sax = new SaxHandler();
			strResult= sax.getParameter(_XMLpath, _Param);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return strResult;
	}
	
	
	public HospitalMstVO getHospitalDetail(String hospCode) throws Exception 
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;
		HospitalMstVO hospitalMstVo=new HospitalMstVO();
		String strProcName = "{call PKG_RPT_FUNC.PROC_GBLT_HOSPITAL_MST(?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		this.retValue = false;
		this.errMsg = "";

		try 
		{
			daoObj = new HisDAO("HisGlobal","HisUtil");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "p_modeVal", "1",1);
			daoObj.setProcInValue(nProcIndex, "p_hospCode", hospCode,2);
			daoObj.setProcOutValue(nProcIndex, "err", 1,3);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,4);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			ws.beforeFirst();
			//System.out.println("ws size"+ws.size());
			HelperMethods.populateVOfrmRS(hospitalMstVo, ws);
			//System.out.println("hosp name"+hospitalMstVo.getHospitalName());
		} 
		catch (Exception e) 
		{
			if (e.getClass() == HisRecordNotFoundException.class) 
			{
				throw new HisRecordNotFoundException(e.getMessage());
			} 
			else
				throw new HisRecordNotFoundException("GlobalDAO:getHospitalDetail:HelperMethods :: " + e);
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}		
		return hospitalMstVo;
	}
	
	
	/**
	 * This method will set all the null fields (String Type) of a VO object to
	 * empty String.
	 * 
	 * @param complaintRequestDtlVO_p
	 */
	public static void replaceNullValueWithEmptyString(Object currentObject_p) {

		Class<? extends Object> currentClass = currentObject_p.getClass();

		Method[] methods = currentClass.getMethods();
		Method setterMethod = null;
		String getterName;
		String setterName;
		try {
			for (Method method : methods) {
				Class<?> returnType = method.getReturnType();
				if (returnType.equals(String.class)) {

					getterName = method.getName();
					setterName = getterName.replaceFirst("get", "set");

					String objVal = (String) method.invoke(currentObject_p);
					if (objVal == null) {
						setterMethod = currentClass.getMethod(setterName,
								String.class);
						setterMethod.invoke(currentObject_p, "");
					}
				}
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 *  Developer : Deepak Tiwari
	 *  Created Date : 11/Nov/2009
	 *  Process Name : Global Purchase
	 *  This Method creates Date Picker HTML Content for MultiRowTLD.
	 *  It uses its own Java-Script function to initialize Date-Picker for MultiRow
	 */
	
	public static String getDatePickerMultiRowTLD(String fieldName, String dateValue, boolean readOnly,int i)
    {
		StringBuffer sBuffer = new StringBuffer("");
		String redColor="red";
		
		sBuffer.append("<input class='txtFldDate' size='9%' type='text' name='"+fieldName+"' id='"+fieldName+"#"+ i + "'");
		 if(readOnly)
		 sBuffer.append(" readonly  ");
		sBuffer.append("value='"+dateValue+"'>");
		sBuffer.append("<img src='../../hisglobal/images/imgDatepicker.png' id='"+fieldName+"1#"+i+"'  name='"+fieldName+"1' style='cursor: pointer; border: 1px solid red;width:12px;' title='Date selector'");
		sBuffer.append(" onmouseover=\"datePickerAjaxMultiRow(event,'").append(fieldName).append("',this),this.style.background='red';\" onmouseout=\"this.style.background=''\"> \n");
		
		////////////////////////////////////////////////
		/*StringBuilder strBuffer = new StringBuilder(500);
        strBuffer.append((new StringBuilder(" <input size='9%' type=\"text\" name=\"")).append(fieldName).append("\" id=\"").append(fieldName).append("#0\" ").toString());
        //strBuffer.append((new StringBuilder(" <input size='9%' type=\"text\" name=\"")).append(fieldName).append("\" id=\"").append(fieldName).append("#\" ").append(i).toString());
        
        if(readOnly)
            strBuffer.append(" readonly  ");
        strBuffer.append((new StringBuilder(" value='")).append(dateValue).append("'>").toString());
        strBuffer.append((new StringBuilder(" <img src=\"../../hisglobal/images/imgDatepicker.png\" id=\"")).append(fieldName).append("1#0\" name=\"").append(fieldName).append("1\" style=\"cursor: pointer; border: 1px solid red;\" title=\"Date selector\" ").toString());
       // strBuffer.append((new StringBuilder(" <img src=\"../../hisglobal/images/imgDatepicker.png\" id=\"")).append(fieldName).append("1#\" ").append(i).append(" name=\"").append(fieldName).append(i).append(" style=\"cursor: pointer; border: 1px solid red;\" title=\"Date selector\" ").toString());
        strBuffer.append(" onmouseover=\"datePickerAjaxMultiRow(event,'").append(fieldName).append("',this),this.style.background='red';\" onmouseout=\"this.style.background=''\"> \n");
       */
        return sBuffer.toString();
    }
public boolean fileupload(FileItem myFile2) throws FileNotFoundException, IOException {
		
	FileItem myfile=myFile2;
		byte[] fileDataAsByte=null;
		long count=0;
		Tika tika=null;
		if(myfile!=null && !myfile.getName().equals("") && !myfile.getName().equals(" "))
		{	System.out.println("=============>1");
			if(myfile.getName().toUpperCase().contains(".JPG") || myfile.getName().toUpperCase().contains(".JPEG") || myfile.getName().toUpperCase().contains(".PDF"))
			{
				System.out.println("=============>2");
				if (myfile.getName().toUpperCase().contains(".JPEG")) 
				 {
					System.out.println("=============>3");
						 tika = new Tika();		                 
		                 //detecting the file type using detect method
		                 String filetype = tika.detect(myfile.getInputStream());
		                 //System.out.println("Tika File Type-->>>"+filetype);
						 if(filetype.equals("image/jpeg") && filesize(myfile.getSize()))
							return true;
						 else
							 return false;
				}
				if (myfile.getName().toUpperCase().contains(".JPG")) 
				{
					
						 tika = new Tika();		                 
		                 //detecting the file type using detect method
		                 String filetype = tika.detect(myfile.getInputStream());
		                 //System.out.println("Tika File Type-->>>"+filetype);
						 if(filetype.equals("image/jpeg") && filesize(myfile.getSize()) )
						 
							 return true;
							 else
								 return false;
				}				
				if (myfile.getName().toUpperCase().contains(".PDF")) 
				{
					
						 tika = new Tika();		                 
		                 //detecting the file type using detect method
		                 String filetype = tika.detect(myfile.getInputStream());
		                 //System.out.println("Tika File Type-->>>"+filetype);
						 if(filetype.equals("application/pdf") && filesize(myfile.getSize()) )
						 
							 return true;
							 else
								 return false;
							 	
						 
	
				}				
				else
				{
					System.out.println("=============>4");
					return false;
				}
			}			
			else
			{
				System.out.println("=============>5");
				return false;
			}
			
		}
		else
		{
			System.out.println("=============>6");
			return true;
		}
	}

	
	public boolean filesize(long filesize) {
		
	
			
		long fileSize=filesize;
			 if(fileSize>4194304){
				 return false;
				// throw new Exception("File Is Larger Than 4 MB");
				
			 }
			 else
				 return true;
			 //fileDataAsByte =myfile.getFileData();
			
			
			
		}
	
	
	
	public  String getHospitalHeader(String hospCode,int logoflag,String strReportFormat)
	{
		StringBuffer sBuffer = new StringBuffer("");		
		String hospitalName="";
		String hospitalAdd="";
		String hospitalPlace="";
		String hospitalContact="";
		HospitalMstVO hospitalVO;
		try 
		{
			hospitalVO=this.getHospitalDetail(hospCode);
			if(hospitalVO!=null)
			{
				hospitalName=hospitalVO.getHospitalName();
				hospitalAdd=hospitalVO.getAddress1();
				if(hospitalAdd!=null && !hospitalAdd.equals("") && !hospitalAdd.equals(" "))
				{
					if(hospitalVO.getAddress2()!=null && !hospitalVO.getAddress2().equals("") && !hospitalVO.getAddress2().equals(" "))
					hospitalPlace=hospitalVO.getAddress1()+", "+hospitalVO.getAddress2()+(hospitalVO.getCity()!=null && !hospitalVO.getCity().equals("") && !hospitalVO.getCity().equals(" ")?", "+ hospitalVO.getCity():"")+(hospitalVO.getPinCode()!=null && !hospitalVO.getPinCode().equals("") && !hospitalVO.getPinCode().equals(" ") && !hospitalVO.getPinCode().equals("0")? "-"+hospitalVO.getPinCode():"")+(hospitalVO.getState()!=null && !hospitalVO.getState().equals("") && !hospitalVO.getState().equals(" ")?", "+ hospitalVO.getState():"")+", India";
					else
					hospitalPlace=hospitalVO.getAddress1()+", "+(hospitalVO.getCity()!=null && !hospitalVO.getCity().equals("") && !hospitalVO.getCity().equals(" ")? hospitalVO.getCity():"")+(hospitalVO.getPinCode()!=null && !hospitalVO.getPinCode().equals("") && !hospitalVO.getPinCode().equals(" ") && !hospitalVO.getPinCode().equals("0")? "-"+hospitalVO.getPinCode():"")+(hospitalVO.getState()!=null && !hospitalVO.getState().equals("") && !hospitalVO.getState().equals(" ")?", "+ hospitalVO.getState():"")+", India";
					}
				else
				{
					if(hospitalVO.getAddress2()!=null && !hospitalVO.getAddress2().equals("") && !hospitalVO.getAddress2().equals(" "))
					hospitalPlace=hospitalVO.getAddress2()+(hospitalVO.getCity()!=null && !hospitalVO.getCity().equals("") && !hospitalVO.getCity().equals(" ")?", "+ hospitalVO.getCity():"")+(hospitalVO.getPinCode()!=null && !hospitalVO.getPinCode().equals("") && !hospitalVO.getPinCode().equals(" ") && !hospitalVO.getPinCode().equals("0")? "-"+hospitalVO.getPinCode():"")+(hospitalVO.getState()!=null && !hospitalVO.getState().equals("") && !hospitalVO.getState().equals(" ")?", "+ hospitalVO.getState():"")+", India";
					else
					hospitalPlace=(hospitalVO.getCity()!=null && !hospitalVO.getCity().equals("") && !hospitalVO.getCity().equals(" ")? hospitalVO.getCity():"")+(hospitalVO.getPinCode()!=null && !hospitalVO.getPinCode().equals("") && !hospitalVO.getPinCode().equals(" ") && !hospitalVO.getPinCode().equals("0")? "-"+hospitalVO.getPinCode():"")+(hospitalVO.getState()!=null && !hospitalVO.getState().equals("") && !hospitalVO.getState().equals(" ")?", "+ hospitalVO.getState():"")+", India";
				}	
				hospitalContact="Phone :"+(hospitalVO.getPhone()!=null && !hospitalVO.getPhone().equals("") && !hospitalVO.getPhone().equals(" ")? hospitalVO.getPhone():" -")+", "+"Email :"+(hospitalVO.getEmail()!=null && !hospitalVO.getEmail().equals("") && !hospitalVO.getEmail().equals(" ")?hospitalVO.getEmail():" -");
				//sBuffer.append("<table border='0'  cellspacing='0' cellpadding='0' align='center'>");
				sBuffer.append("<table border='0'  cellspacing='0' cellpadding='0' align='center'>");
				if(logoflag==1)
				{   
					/*Buffer.append("<tr>");
					sBuffer.append("<td><table align='center'>");
					sBuffer.append("<tr>");
					sBuffer.append("<th rowspan='4'><div align='right'><img src='/HIS/hisglobal/images/logo.png'></div></th>");
					sBuffer.append("<td class='SLIPCONTROL'><div align='center'><b>"+hospitalName+"</b></div></td>");
					sBuffer.append("</tr>");
					if(hospitalAdd!=null && !hospitalAdd.equals("") && !hospitalAdd.equals(" "))
					{
						sBuffer.append("<tr>");
						sBuffer.append("<td class='SLIPCONTROL'><div align='center'><b>"+hospitalAdd+"</b></div></td>");
						sBuffer.append("</tr>");
					} 
					sBuffer.append("<tr>");
					sBuffer.append("<td class='SLIPCONTROL'><div align='center'><b>"+hospitalPlace+"</b></div></td>");
					sBuffer.append("</tr>");
					sBuffer.append("<tr>");
					sBuffer.append("<td class='SLIPCONTROL'><div align='center'><b>"+hospitalContact+"</b></div></td>");
					sBuffer.append("</table></td>");
					sBuffer.append("</tr>");*/
					/*sBuffer.append("<tr>");
					sBuffer.append("<td width='auto'><div align='right'><img  src='/HIS/hisglobal/images/logo.png' width='auto'></div></td>");
					sBuffer.append("<td width='auto'><table>");
					sBuffer.append("<tr>");
					sBuffer.append("<td class='SLIPCONTROL'><div align='center'><b>"+hospitalName+"</b></div></td>");
					sBuffer.append("</tr>");
					if(hospitalAdd!=null && !hospitalAdd.equals("") && !hospitalAdd.equals(" "))
					{
						sBuffer.append("<tr>");
						sBuffer.append("<td class='SLIPCONTROL'><div align='center'><b>"+hospitalAdd+"</b></div></td>");
						sBuffer.append("</tr>");
					} 
					sBuffer.append("<tr>");
					sBuffer.append("<td class='SLIPCONTROL'><div align='center'><b>"+hospitalPlace+"</b></div></td>");
					sBuffer.append("</tr>");
					sBuffer.append("<tr>");
					sBuffer.append("<td class='SLIPCONTROL'><div align='center'><b>"+hospitalContact+"</b></div></td>");
					sBuffer.append("</tr>");
					sBuffer.append("</td></table>");
					sBuffer.append("</tr>");*/
					sBuffer.append("<tr>");
					sBuffer.append("<td colspan='3'><table>");
					sBuffer.append("<tr>");
					
					//style='width: 85%; background-color: green; float:right;'
							
					if(!strReportFormat.equalsIgnoreCase("pdf"))
					{
						sBuffer.append("<td width='5%'><div align='left'><img src='/INVMGM/hisglobal/images/logo.png' width='100'></div></td>");
						sBuffer.append("<td width='95%' colspan='3'><div align='center'><b><font style='font-size: 18px;'>"+hospitalName+"</font></b></div>");
						sBuffer.append("<div align='center'><img src='/INVMGM/hisglobal/images/AIIMSP_HindiHeader.png' height='24' width='322'/></div>");  
						sBuffer.append("<div align='center'><b><font style='font-size: 17px;' >"+hospitalPlace+"</font></b></div>");
						sBuffer.append("<div align='left'><b><font style='font-size: 17px;margin-left:10px;'>"+hospitalContact+"</font></b></div></td>");
					}
					else
					{
						String logoPath=this.getParameterFromHisPathXML("LOGO_IMAGE");
						System.out.println("logoPath"+logoPath);
						sBuffer.append("<td width='100%' colspan='3'><div align='center'><img width='100' height='100'  src='"+logoPath+"'></div>");
						sBuffer.append("<div align='center'><b><font style='font-size: 14px;'>"+hospitalName+"</font></b></div>");
						String hindilogoPath=this.getParameterFromHisPathXML("HINDIHEADER_IMAGE");
						sBuffer.append("<div align='center'><img src='"+hindilogoPath+"' height='18' width='322'/></div>");   //hindi font image added by : manisha dt:16.10.18  /INVMGM/hisglobal/images/AIIMSP_HindiHeader.png
						sBuffer.append("<div align='center'><b>"+hospitalPlace+"</b></div>");
						sBuffer.append("<div align='center'><b>"+hospitalContact+"</b></div></td>");
				
					}
						//	sBuffer.append("<div align='center'><b><font size='4'>&#2309;&#2326;&#2367;&#2354; &#2349;&#2366;&#2352;&#2340;&#2368;&#2351; &#2310;&#2351;&#2369;&#2352;&#2381;&#2357;&#2367;&#2332;&#2381;&#2334;&#2366;&#2344; &#2360;&#2306;&#2360;&#2381;&#2341;&#2366;&#2344; &#2346;&#2335;&#2344;&#2366;</font></b></div>");   //commented by : manisha dt:16.10.18
					/*if(hospitalAdd!=null && !hospitalAdd.equals("") && !hospitalAdd.equals(" "))
					{
						sBuffer.append("<div align='center'><b>"+hospitalAdd+"</b></div>");
					} */

					//sBuffer.append("<td></td>");
					sBuffer.append("</tr>");
					//sBuffer.append("</table>");
					sBuffer.append("</table></td>");
					sBuffer.append("</tr>");
				}
				else
				{
					sBuffer.append("<tr>");
					sBuffer.append("<td width='100%' class='SLIPCONTROL'><div align='center'><b>"+hospitalName+"</b></div></td>");
					sBuffer.append("</tr>");
					if(hospitalAdd!=null && !hospitalAdd.equals("") && !hospitalAdd.equals(" "))
					{
						sBuffer.append("<tr>");
						sBuffer.append("<td width='100%' class='SLIPCONTROL'><div align='center'><b>"+hospitalAdd+"</b></div></td>");
						sBuffer.append("</tr>");
					} 
					sBuffer.append("<tr>");
					sBuffer.append("<td width='100%' class='SLIPCONTROL'><div align='center'><b>"+hospitalPlace+"</b></div></td>");
					sBuffer.append("</tr>");
					sBuffer.append("<tr>");
					sBuffer.append("<td width='100%' class='SLIPCONTROL'><div align='center'><b>"+hospitalContact+"</b></div></td>");
					sBuffer.append("</tr>");
				}
		        sBuffer.append("</table>");
			}
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		}
		return sBuffer.toString();
	}
	
	public  String getHospitalHeader1(String hospCode,int logoflag,String strReportFormat)
	{
		StringBuffer sBuffer = new StringBuffer("");		
		String hospitalName="";
		String hospitalAdd="";
		String hospitalPlace="";
		String hospitalContact="";
		HospitalMstVO hospitalVO;
		try 
		{
			hospitalVO=this.getHospitalDetail(hospCode);
			if(hospitalVO!=null)
			{
				hospitalName=hospitalVO.getHospitalName();
				hospitalAdd=hospitalVO.getAddress1();
				if(hospitalAdd!=null && !hospitalAdd.equals("") && !hospitalAdd.equals(" "))
				{
					if(hospitalVO.getAddress2()!=null && !hospitalVO.getAddress2().equals("") && !hospitalVO.getAddress2().equals(" "))
					hospitalPlace=hospitalVO.getAddress1()+", "+hospitalVO.getAddress2()+(hospitalVO.getCity()!=null && !hospitalVO.getCity().equals("") && !hospitalVO.getCity().equals(" ")?", "+ hospitalVO.getCity():"")+(hospitalVO.getPinCode()!=null && !hospitalVO.getPinCode().equals("") && !hospitalVO.getPinCode().equals(" ") && !hospitalVO.getPinCode().equals("0")? "-"+hospitalVO.getPinCode():"")+(hospitalVO.getState()!=null && !hospitalVO.getState().equals("") && !hospitalVO.getState().equals(" ")?", "+ hospitalVO.getState():"")+", India";
					else
					hospitalPlace=hospitalVO.getAddress1()+", "+(hospitalVO.getCity()!=null && !hospitalVO.getCity().equals("") && !hospitalVO.getCity().equals(" ")? hospitalVO.getCity():"")+(hospitalVO.getPinCode()!=null && !hospitalVO.getPinCode().equals("") && !hospitalVO.getPinCode().equals(" ") && !hospitalVO.getPinCode().equals("0")? "-"+hospitalVO.getPinCode():"")+(hospitalVO.getState()!=null && !hospitalVO.getState().equals("") && !hospitalVO.getState().equals(" ")?", "+ hospitalVO.getState():"")+", India";
					}
				else
				{
					if(hospitalVO.getAddress2()!=null && !hospitalVO.getAddress2().equals("") && !hospitalVO.getAddress2().equals(" "))
					hospitalPlace=hospitalVO.getAddress2()+(hospitalVO.getCity()!=null && !hospitalVO.getCity().equals("") && !hospitalVO.getCity().equals(" ")?", "+ hospitalVO.getCity():"")+(hospitalVO.getPinCode()!=null && !hospitalVO.getPinCode().equals("") && !hospitalVO.getPinCode().equals(" ") && !hospitalVO.getPinCode().equals("0")? "-"+hospitalVO.getPinCode():"")+(hospitalVO.getState()!=null && !hospitalVO.getState().equals("") && !hospitalVO.getState().equals(" ")?", "+ hospitalVO.getState():"")+", India";
					else
					hospitalPlace=(hospitalVO.getCity()!=null && !hospitalVO.getCity().equals("") && !hospitalVO.getCity().equals(" ")? hospitalVO.getCity():"")+(hospitalVO.getPinCode()!=null && !hospitalVO.getPinCode().equals("") && !hospitalVO.getPinCode().equals(" ") && !hospitalVO.getPinCode().equals("0")? "-"+hospitalVO.getPinCode():"")+(hospitalVO.getState()!=null && !hospitalVO.getState().equals("") && !hospitalVO.getState().equals(" ")?", "+ hospitalVO.getState():"")+", India";
				}	
				hospitalContact="Phone :"+(hospitalVO.getPhone()!=null && !hospitalVO.getPhone().equals("") && !hospitalVO.getPhone().equals(" ")? hospitalVO.getPhone():" -")+", "+"Email :"+(hospitalVO.getEmail()!=null && !hospitalVO.getEmail().equals("") && !hospitalVO.getEmail().equals(" ")?hospitalVO.getEmail():" -");
				//sBuffer.append("<table border='0'  cellspacing='0' cellpadding='0' align='center'>");
				if(logoflag==1)
				{   
					/*sBuffer.append("<tr>");
					sBuffer.append("<td><table align='center'>");
					sBuffer.append("<tr>");
					sBuffer.append("<th rowspan='4'><div align='right'><img src='/HIS/hisglobal/images/logo.png'></div></th>");
					sBuffer.append("<td class='SLIPCONTROLHH'><div align='center'><b>"+hospitalName+"</b></div></td>");
					sBuffer.append("</tr>");
					if(hospitalAdd!=null && !hospitalAdd.equals("") && !hospitalAdd.equals(" "))
					{
						sBuffer.append("<tr>");
						sBuffer.append("<td class='SLIPCONTROLHH'><div align='center'><b>"+hospitalAdd+"</b></div></td>");
						sBuffer.append("</tr>");
					} 
					sBuffer.append("<tr>");
					sBuffer.append("<td class='SLIPCONTROLHH'><div align='center'><b>"+hospitalPlace+"</b></div></td>");
					sBuffer.append("</tr>");
					sBuffer.append("<tr>");
					sBuffer.append("<td class='SLIPCONTROLHH'><div align='center'><b>"+hospitalContact+"</b></div></td>");
					sBuffer.append("</table></td>");
					sBuffer.append("</tr>");*/
					/*sBuffer.append("<tr>");
					sBuffer.append("<td width='auto'><div align='right'><img  src='/HIS/hisglobal/images/logo.png' width='auto'></div></td>");
					sBuffer.append("<td width='auto'><table>");
					sBuffer.append("<tr>");
					sBuffer.append("<td class='SLIPCONTROLHH'><div align='center'><b>"+hospitalName+"</b></div></td>");
					sBuffer.append("</tr>");
					if(hospitalAdd!=null && !hospitalAdd.equals("") && !hospitalAdd.equals(" "))
					{
						sBuffer.append("<tr>");
						sBuffer.append("<td class='SLIPCONTROLHH'><div align='center'><b>"+hospitalAdd+"</b></div></td>");
						sBuffer.append("</tr>");
					} 
					sBuffer.append("<tr>");
					sBuffer.append("<td class='SLIPCONTROLHH'><div align='center'><b>"+hospitalPlace+"</b></div></td>");
					sBuffer.append("</tr>");
					sBuffer.append("<tr>");
					sBuffer.append("<td class='SLIPCONTROLHH'><div align='center'><b>"+hospitalContact+"</b></div></td>");
					sBuffer.append("</tr>");
					sBuffer.append("</td></table>");
					sBuffer.append("</tr>");*/
					sBuffer.append("<tr>");
					sBuffer.append("<td colspan='6' class='SLIPCONTROLHH'><table>");
					sBuffer.append("<tr>");
					
					//style='width: 85%; background-color: green; float:right;'
							
					if(!strReportFormat.equalsIgnoreCase("pdf"))
					{
						sBuffer.append("<td width='5%'><div align='right'><img src='/INVMGM/hisglobal/images/logo.png' width='100'></div></td>");
						sBuffer.append("<td width='95%' class='SLIPCONTROLHH'><div align='center'><b><font size='4'>"+hospitalName+"</font></b></div>");
					}
					else
					{
						String logoPath=this.getParameterFromHisPathXML("LOGO_IMAGE");
						System.out.println("logoPath"+logoPath);
						sBuffer.append("<td width='100%'><div align='center'><img src='"+logoPath+"'></div>");
						sBuffer.append("<div align='center'><b><font size='4'>"+hospitalName+"</font></b></div>");
					}
					sBuffer.append("<div align='center'><b><font size='4'>&#2309;&#2326;&#2367;&#2354; &#2349;&#2366;&#2352;&#2340;&#2368;&#2351; &#2310;&#2351;&#2369;&#2352;&#2381;&#2357;&#2367;&#2332;&#2381;&#2334;&#2366;&#2344; &#2360;&#2306;&#2360;&#2381;&#2341;&#2366;&#2344; &#2346;&#2335;&#2344;&#2366;</font></b></div>");
					/*if(hospitalAdd!=null && !hospitalAdd.equals("") && !hospitalAdd.equals(" "))
					{
						sBuffer.append("<div align='center'>"+hospitalAdd+"</div>");
					}*/
					sBuffer.append("<div align='center'>"+hospitalPlace+"</div>");
					sBuffer.append("<div align='center'>"+hospitalContact+"</div></td>");
					//sBuffer.append("<td></td>");
					sBuffer.append("</tr>");
					//sBuffer.append("</table>");
					sBuffer.append("</table></td>");
					sBuffer.append("</tr>");
				}
				else
				{
					sBuffer.append("<tr>");
					sBuffer.append("<td width='100%' class='SLIPCONTROLHH'><div align='center'><b>"+hospitalName+"</b></div></td>");
					sBuffer.append("</tr>");
					sBuffer.append("<tr>");
					sBuffer.append("<td width='100%' class='SLIPCONTROLHH'><div align='center'><b>&#2309;&#2326;&#2367;&#2354; &#2349;&#2366;&#2352;&#2340;&#2368;&#2351; &#2310;&#2351;&#2369;&#2352;&#2381;&#2357;&#2367;&#2332;&#2381;&#2334;&#2366;&#2344; &#2360;&#2306;&#2360;&#2381;&#2341;&#2366;&#2344; &#2346;&#2335;&#2344;&#2366;</b></div></td>");
					sBuffer.append("</tr>");
					/*if(hospitalAdd!=null && !hospitalAdd.equals("") && !hospitalAdd.equals(" "))
					{
						sBuffer.append("<tr>");
						sBuffer.append("<td width='100%' class='SLIPCONTROLHH'><div align='center'><b>"+hospitalAdd+"</b></div></td>");
						sBuffer.append("</tr>");
					} */
					sBuffer.append("<tr>");
					sBuffer.append("<td width='100%' class='SLIPCONTROLHH'><div align='center'><b>"+hospitalPlace+"</b></div></td>");
					sBuffer.append("</tr>");
					sBuffer.append("<tr>");
					sBuffer.append("<td width='100%' class='SLIPCONTROLHH'><div align='center'><b>"+hospitalContact+"</b></div></td>");
					sBuffer.append("</tr>");
				}
		        //sBuffer.append("</table>");
			}
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		}
		return sBuffer.toString();
	}
	
	   /**
	   * @param number The number in plain format
	   * @param mask The  mask pattern. 
	   *    Use # to include the digit from the position. 
	   *    Use x to mask the digit at that position.
	   *    Any other char will be inserted.
	   *    Mask Format 1: "xxxxxxxxxxxx####")); Mask All But Last Four Digit
	   *    Mask Format 2: "####-####-####-####")); insert dashes
	   *    Mask Format 3: "xxxx-xxxx-xxxx-####")); insert dashes and mask all but last 4 numbers
	   * @return The masked card number
	   */
	   public static String maskNumber(String number, String mask) 
	   {	 
	      int index = 0;
	      StringBuilder masked = new StringBuilder();
	      if(number!=null && !number.equals(""))
	      for (int i = 0; i < mask.length(); i++) 
	      {
	         char c = mask.charAt(i);
	         if (c == '#') 
	         {
	            masked.append(number.charAt(index));
	            index++;
	         } 
	         else if (c == 'x') 
	         {
	            masked.append(c);
	            index++;
	         } 
	         else 
	         {
	            masked.append(c);
	         }
	      }
	      return masked.toString();
	   }
	   // used in Admission Slip Patient Gate Pass
	   public  String getHospitalHeader2(String hospCode,int logoflag,String strReportFormat)
		{
			StringBuffer sBuffer = new StringBuffer("");		
			String hospitalName="";
			/*String hospitalAdd="";
			String hospitalPlace="";
			String hospitalContact="";*/
			HospitalMstVO hospitalVO;
			try 
			{
				hospitalVO=this.getHospitalDetail(hospCode);
				if(hospitalVO!=null)
				{
					hospitalName=hospitalVO.getHospitalName();
					/*hospitalAdd=hospitalVO.getAddress1();
					if(hospitalVO.getAddress2()!=null && !hospitalVO.getAddress2().equals("") && !hospitalVO.getAddress2().equals(" "))
					hospitalPlace=hospitalVO.getAddress2()+(hospitalVO.getCity()!=null && !hospitalVO.getCity().equals("") && !hospitalVO.getCity().equals(" ")?", "+ hospitalVO.getCity():"")+"-"+(hospitalVO.getPinCode()!=null && !hospitalVO.getPinCode().equals("") && !hospitalVO.getPinCode().equals(" ") && !hospitalVO.getPinCode().equals("0")? hospitalVO.getPinCode():"***")+(hospitalVO.getState()!=null && !hospitalVO.getState().equals("") && !hospitalVO.getState().equals(" ")?", "+ hospitalVO.getState():"")+"(INDIA)";
					else
					hospitalPlace=(hospitalVO.getCity()!=null && !hospitalVO.getCity().equals("") && !hospitalVO.getCity().equals(" ")? hospitalVO.getCity()+"-":"")+(hospitalVO.getPinCode()!=null && !hospitalVO.getPinCode().equals("") && !hospitalVO.getPinCode().equals(" ") && !hospitalVO.getPinCode().equals("0")? hospitalVO.getPinCode():"***")+(hospitalVO.getState()!=null && !hospitalVO.getState().equals("") && !hospitalVO.getState().equals(" ")?", "+ hospitalVO.getState():"")+"(INDIA)";
					hospitalContact="Phone :"+(hospitalVO.getPhone()!=null && !hospitalVO.getPhone().equals("") && !hospitalVO.getPhone().equals(" ")? hospitalVO.getPhone():" -")+", "+"Fax :"+(hospitalVO.getFax()!=null && !hospitalVO.getFax().equals("") && !hospitalVO.getFax().equals(" ")?hospitalVO.getFax():" -")+", "+"Email :"+(hospitalVO.getEmail()!=null && !hospitalVO.getEmail().equals("") && !hospitalVO.getEmail().equals(" ")?hospitalVO.getEmail():" -");*/
					//sBuffer.append("<table border='0'  cellspacing='0' cellpadding='0' align='center'>");
					if(logoflag==1)
					{   
						/*sBuffer.append("<tr>");
						sBuffer.append("<td><table align='center'>");
						sBuffer.append("<tr>");
						sBuffer.append("<th rowspan='4'><div align='right'><img src='/HIS/hisglobal/images/logo.png'></div></th>");
						sBuffer.append("<td class='SLIPCONTROLHH'><div align='center'><b>"+hospitalName+"</b></div></td>");
						sBuffer.append("</tr>");
						if(hospitalAdd!=null && !hospitalAdd.equals("") && !hospitalAdd.equals(" "))
						{
							sBuffer.append("<tr>");
							sBuffer.append("<td class='SLIPCONTROLHH'><div align='center'><b>"+hospitalAdd+"</b></div></td>");
							sBuffer.append("</tr>");
						} 
						sBuffer.append("<tr>");
						sBuffer.append("<td class='SLIPCONTROLHH'><div align='center'><b>"+hospitalPlace+"</b></div></td>");
						sBuffer.append("</tr>");
						sBuffer.append("<tr>");
						sBuffer.append("<td class='SLIPCONTROLHH'><div align='center'><b>"+hospitalContact+"</b></div></td>");
						sBuffer.append("</table></td>");
						sBuffer.append("</tr>");*/
						/*sBuffer.append("<tr>");
						sBuffer.append("<td width='auto'><div align='right'><img  src='/HIS/hisglobal/images/logo.png' width='auto'></div></td>");
						sBuffer.append("<td width='auto'><table>");
						sBuffer.append("<tr>");
						sBuffer.append("<td class='SLIPCONTROLHH'><div align='center'><b>"+hospitalName+"</b></div></td>");
						sBuffer.append("</tr>");
						if(hospitalAdd!=null && !hospitalAdd.equals("") && !hospitalAdd.equals(" "))
						{
							sBuffer.append("<tr>");
							sBuffer.append("<td class='SLIPCONTROLHH'><div align='center'><b>"+hospitalAdd+"</b></div></td>");
							sBuffer.append("</tr>");
						} 
						sBuffer.append("<tr>");
						sBuffer.append("<td class='SLIPCONTROLHH'><div align='center'><b>"+hospitalPlace+"</b></div></td>");
						sBuffer.append("</tr>");
						sBuffer.append("<tr>");
						sBuffer.append("<td class='SLIPCONTROLHH'><div align='center'><b>"+hospitalContact+"</b></div></td>");
						sBuffer.append("</tr>");
						sBuffer.append("</td></table>");
						sBuffer.append("</tr>");*/
						sBuffer.append("<tr>");
						sBuffer.append("<td colspan='6' class='SLIPCONTROLHH'><table>");
						sBuffer.append("<tr>");
						
						//style='width: 85%; background-color: green; float:right;'
								
						if(!strReportFormat.equalsIgnoreCase("pdf"))
						{
							sBuffer.append("<td width='5%'><div align='right'><img src='/INVMGM/hisglobal/images/logo.png' width='100'></div></td>");
							sBuffer.append("<td width='95%' class='SLIPCONTROLHH'><div align='left'><b><font size='4'>"+hospitalName+"</font></b></div>");
						}
						else
						{
							String logoPath=this.getParameterFromHisPathXML("LOGO_IMAGE");
							System.out.println("logoPath"+logoPath);
							sBuffer.append("<td width='100%'><div align='center'><img src='"+logoPath+"'></div>");
							sBuffer.append("<div align='left'><b><font size='4'>"+hospitalName+"</font></b></div>");
						}
						sBuffer.append("<div align='left'><b><font size='4'>&#2309;&#2326;&#2367;&#2354; &#2349;&#2366;&#2352;&#2340;&#2368;&#2351; &#2310;&#2351;&#2369;&#2352;&#2381;&#2357;&#2367;&#2332;&#2381;&#2334;&#2366;&#2344; &#2360;&#2306;&#2360;&#2381;&#2341;&#2366;&#2344; &#2346;&#2335;&#2344;&#2366;</font></b></div>");
						/*if(hospitalAdd!=null && !hospitalAdd.equals("") && !hospitalAdd.equals(" "))
						{
							sBuffer.append("<div align='center'>"+hospitalAdd+"</div>");
						} 
						sBuffer.append("<div align='center'>"+hospitalPlace+"</div>");*/
						sBuffer.append("<div align='left'><b><font size='3'>PATIENT GATE PASS</font></b></div></td>");
						//sBuffer.append("<td></td>");
						sBuffer.append("</tr>");
						//sBuffer.append("</table>");
						sBuffer.append("</table></td>");
						sBuffer.append("</tr>");
					}
					else
					{
						sBuffer.append("<tr>");
						sBuffer.append("<td width='100%' class='SLIPCONTROLHH'><div align='left'><b>"+hospitalName+"</b></div></td>");
						sBuffer.append("</tr>");
						sBuffer.append("<tr>");
						sBuffer.append("<td width='100%' class='SLIPCONTROLHH'><div align='left'><b>&#2309;&#2326;&#2367;&#2354; &#2349;&#2366;&#2352;&#2340;&#2368;&#2351; &#2310;&#2351;&#2369;&#2352;&#2381;&#2357;&#2367;&#2332;&#2381;&#2334;&#2366;&#2344; &#2360;&#2306;&#2360;&#2381;&#2341;&#2366;&#2344; &#2346;&#2335;&#2344;&#2366;</b></div></td>");
						sBuffer.append("</tr>");
						/*if(hospitalAdd!=null && !hospitalAdd.equals("") && !hospitalAdd.equals(" "))
						{
							sBuffer.append("<tr>");
							sBuffer.append("<td width='100%' class='SLIPCONTROLHH'><div align='center'><b>"+hospitalAdd+"</b></div></td>");
							sBuffer.append("</tr>");
						} 
						sBuffer.append("<tr>");
						sBuffer.append("<td width='100%' class='SLIPCONTROLHH'><div align='center'><b>"+hospitalPlace+"</b></div></td>");
						sBuffer.append("</tr>");*/
						sBuffer.append("<tr>");
						sBuffer.append("<td width='100%' class='SLIPCONTROLHH'><div align='left'><b>PATIENT GATE PASS</b></div></td>");
						sBuffer.append("</tr>");
					}
			        //sBuffer.append("</table>");
				}
			} 
	        catch (Exception e) 
	        {
				e.printStackTrace();
			}
			return sBuffer.toString();
		}
	   
		public  String getHospitalHeaderForApp(String hospCode,int logoflag,String strReportFormat)
		{
			StringBuffer sBuffer = new StringBuffer("");		
			String hospitalName="";
			String hospitalAdd="";
			String hospitalPlace="";
			String hospitalContact="";
			HospitalMstVO hospitalVO;
			try 
			{
				hospitalVO=this.getHospitalDetail(hospCode);
				if(hospitalVO!=null)
				{
					hospitalName=hospitalVO.getHospitalName();
					hospitalAdd=hospitalVO.getAddress1();
					if(hospitalVO.getAddress2()!=null && !hospitalVO.getAddress2().equals("") && !hospitalVO.getAddress2().equals(" "))
					hospitalPlace=hospitalVO.getAddress2()+(hospitalVO.getCity()!=null && !hospitalVO.getCity().equals("") && !hospitalVO.getCity().equals(" ")?", "+ hospitalVO.getCity():"")+(hospitalVO.getPinCode()!=null && !hospitalVO.getPinCode().equals("") && !hospitalVO.getPinCode().equals(" ") && !hospitalVO.getPinCode().equals("0")? "-"+hospitalVO.getPinCode():"")+(hospitalVO.getState()!=null && !hospitalVO.getState().equals("") && !hospitalVO.getState().equals(" ")?", "+ hospitalVO.getState():"")+"(INDIA)";
					else
					hospitalPlace=(hospitalVO.getCity()!=null && !hospitalVO.getCity().equals("") && !hospitalVO.getCity().equals(" ")? hospitalVO.getCity():"")+(hospitalVO.getPinCode()!=null && !hospitalVO.getPinCode().equals("") && !hospitalVO.getPinCode().equals(" ") && !hospitalVO.getPinCode().equals("0")? "-"+hospitalVO.getPinCode():"")+(hospitalVO.getState()!=null && !hospitalVO.getState().equals("") && !hospitalVO.getState().equals(" ")?", "+ hospitalVO.getState():"")+"(INDIA)";
					hospitalContact="Phone :"+(hospitalVO.getPhone()!=null && !hospitalVO.getPhone().equals("") && !hospitalVO.getPhone().equals(" ")? hospitalVO.getPhone():" -")+", "+"Fax :"+(hospitalVO.getFax()!=null && !hospitalVO.getFax().equals("") && !hospitalVO.getFax().equals(" ")?hospitalVO.getFax():" -")+", "+"Email :"+(hospitalVO.getEmail()!=null && !hospitalVO.getEmail().equals("") && !hospitalVO.getEmail().equals(" ")?hospitalVO.getEmail():" -");
					sBuffer.append("<table border='0'  cellspacing='0' cellpadding='0' align='center'>");
					if(logoflag==1)
					{   
						/*sBuffer.append("<tr>");
						sBuffer.append("<td><table align='center'>");
						sBuffer.append("<tr>");
						sBuffer.append("<th rowspan='4'><div align='right'><img src='/HIS/hisglobal/images/logo.png'></div></th>");
						sBuffer.append("<td class='SLIPCONTROL'><div align='center'><b>"+hospitalName+"</b></div></td>");
						sBuffer.append("</tr>");
						if(hospitalAdd!=null && !hospitalAdd.equals("") && !hospitalAdd.equals(" "))
						{
							sBuffer.append("<tr>");
							sBuffer.append("<td class='SLIPCONTROL'><div align='center'><b>"+hospitalAdd+"</b></div></td>");
							sBuffer.append("</tr>");
						} 
						sBuffer.append("<tr>");
						sBuffer.append("<td class='SLIPCONTROL'><div align='center'><b>"+hospitalPlace+"</b></div></td>");
						sBuffer.append("</tr>");
						sBuffer.append("<tr>");
						sBuffer.append("<td class='SLIPCONTROL'><div align='center'><b>"+hospitalContact+"</b></div></td>");
						sBuffer.append("</table></td>");
						sBuffer.append("</tr>");*/
						/*sBuffer.append("<tr>");
						sBuffer.append("<td width='auto'><div align='right'><img  src='/HIS/hisglobal/images/logo.png' width='auto'></div></td>");
						sBuffer.append("<td width='auto'><table>");
						sBuffer.append("<tr>");
						sBuffer.append("<td class='SLIPCONTROL'><div align='center'><b>"+hospitalName+"</b></div></td>");
						sBuffer.append("</tr>");
						if(hospitalAdd!=null && !hospitalAdd.equals("") && !hospitalAdd.equals(" "))
						{
							sBuffer.append("<tr>");
							sBuffer.append("<td class='SLIPCONTROL'><div align='center'><b>"+hospitalAdd+"</b></div></td>");
							sBuffer.append("</tr>");
						} 
						sBuffer.append("<tr>");
						sBuffer.append("<td class='SLIPCONTROL'><div align='center'><b>"+hospitalPlace+"</b></div></td>");
						sBuffer.append("</tr>");
						sBuffer.append("<tr>");
						sBuffer.append("<td class='SLIPCONTROL'><div align='center'><b>"+hospitalContact+"</b></div></td>");
						sBuffer.append("</tr>");
						sBuffer.append("</td></table>");
						sBuffer.append("</tr>");*/
						sBuffer.append("<tr>");
						sBuffer.append("<td colspan='3'><table>");
						sBuffer.append("<tr>");
						
						//style='width: 85%; background-color: green; float:right;'
								
						if(!strReportFormat.equalsIgnoreCase("pdf"))
						{
							sBuffer.append("<td width='10%'><div align='right'><img src='/INVMGM/hisglobal/images/logo.png' width='100'></div></td>");
							sBuffer.append("<td width='90%' colspan='2'><div align='center'><b>"+hospitalName+"</b></div>");
						}
						else
						{
							String logoPath=this.getParameterFromHisPathXML("LOGO_IMAGE");
							System.out.println("logoPath"+logoPath);
							sBuffer.append("<td width='100%' colspan='3'><div align='center'><img src='"+logoPath+"'></div>");
							sBuffer.append("<div align='center'><b>"+hospitalName+"</b></div>");
						}
						
						if(hospitalAdd!=null && !hospitalAdd.equals("") && !hospitalAdd.equals(" "))
						{
							sBuffer.append("<div align='center'><b>"+hospitalAdd+"</b></div>");
						} 
						sBuffer.append("<div align='center'><b>"+hospitalPlace+"</b></div>");
						sBuffer.append("<div align='center'><b>"+hospitalContact+"</b></div></td>");
						//sBuffer.append("<td></td>");
						sBuffer.append("</tr>");
						//sBuffer.append("</table>");
						sBuffer.append("</table></td>");
						sBuffer.append("</tr>");
					}
					else
					{
						sBuffer.append("<tr>");
						sBuffer.append("<td width='100%' class='SLIPCONTROL'><div align='center'><b>"+hospitalName+"</b></div></td>");
						sBuffer.append("</tr>");
						if(hospitalAdd!=null && !hospitalAdd.equals("") && !hospitalAdd.equals(" "))
						{
							sBuffer.append("<tr>");
							sBuffer.append("<td width='100%' class='SLIPCONTROL'><div align='center'><b>"+hospitalAdd+"</b></div></td>");
							sBuffer.append("</tr>");
						} 
						sBuffer.append("<tr>");
						sBuffer.append("<td width='100%' class='SLIPCONTROL'><div align='center'><b>"+hospitalPlace+"</b></div></td>");
						sBuffer.append("</tr>");
						sBuffer.append("<tr>");
						sBuffer.append("<td width='100%' class='SLIPCONTROL'><div align='center'><b>"+hospitalContact+"</b></div></td>");
						sBuffer.append("</tr>");
					}
			        sBuffer.append("</table>");
				}
			} 
	        catch (Exception e) 
	        {
				e.printStackTrace();
			}
			return hospitalName+"\n"+hospitalAdd+"\n"+hospitalPlace;
		}
		/**
		 * function that appends given Symbol up to given length
		 * 
		 * @param strValue
		 *            String
		 * @param len
		 *            length
		 *            
		 * @param mode  0 - Left Align 1 - Right Align          
		 * @return space Appended String.
		 * 
		 */
		public String appendSymbol(String strValue, int len , int mode,String symbol) 
		{

			String retStrValue = "" ;
			
			if(mode == 0)
			{			
				retStrValue = appendSymbolAtEnd(strValue, len,symbol);			
			}
			else
			{			
				retStrValue = appendSymbolAtBegining(strValue, len,symbol);			
			} 
			

			return retStrValue;
		} // end function
		public String appendSymbolAtEnd(String strValue, int len,String symbol) 
		{
			String retStrValue = "";
			int diffLen = 0;
			int i = 0;

			diffLen = len - strValue.length();
			retStrValue = strValue;

			if (diffLen > 0) 
			{
				for (i = 0; i < diffLen; i++)
					retStrValue +=symbol;
			}

			return retStrValue;
		} // end function
		public String appendSymbolAtBegining(String strValue, int len,String symbol) 
		{
			String retStrValue = "";
			int diffLen = 0;
			int i = 0;

			diffLen = len - strValue.length();	
			if (diffLen > 0) 
			{
				for (i = 0; i < diffLen; i++)
					retStrValue +=symbol;
			}
			
			retStrValue = retStrValue+""+strValue;

			return retStrValue;
		} // end function
		
		public  String getHospitalHeader(String hospCode,int logoflag,String strReportFormat,String hospLogoPath)
		{
			StringBuffer sBuffer = new StringBuffer("");		
			String hospitalName="";
			String hospitalAdd="";
			String hospitalPlace="";
			String hospitalContact="";
			HospitalMstVO hospitalVO;
			try 
			{
				hospitalVO=this.getHospitalDetail(hospCode);
				if(hospitalVO!=null)
				{
					hospitalName=hospitalVO.getHospitalName();
					hospitalAdd=hospitalVO.getAddress1();
					if(hospitalAdd!=null && !hospitalAdd.equals("") && !hospitalAdd.equals(" "))
					{
						if(hospitalVO.getAddress2()!=null && !hospitalVO.getAddress2().equals("") && !hospitalVO.getAddress2().equals(" "))
						hospitalPlace=hospitalVO.getAddress1()+", "+hospitalVO.getAddress2()+(hospitalVO.getCity()!=null && !hospitalVO.getCity().equals("") && !hospitalVO.getCity().equals(" ")?", "+ hospitalVO.getCity():"")+(hospitalVO.getPinCode()!=null && !hospitalVO.getPinCode().equals("") && !hospitalVO.getPinCode().equals(" ") && !hospitalVO.getPinCode().equals("0")? "-"+hospitalVO.getPinCode():"")+(hospitalVO.getState()!=null && !hospitalVO.getState().equals("") && !hospitalVO.getState().equals(" ")?", "+ hospitalVO.getState():"")+", India";
						else
						hospitalPlace=hospitalVO.getAddress1()+", "+(hospitalVO.getCity()!=null && !hospitalVO.getCity().equals("") && !hospitalVO.getCity().equals(" ")? hospitalVO.getCity():"")+(hospitalVO.getPinCode()!=null && !hospitalVO.getPinCode().equals("") && !hospitalVO.getPinCode().equals(" ") && !hospitalVO.getPinCode().equals("0")? "-"+hospitalVO.getPinCode():"")+(hospitalVO.getState()!=null && !hospitalVO.getState().equals("") && !hospitalVO.getState().equals(" ")?", "+ hospitalVO.getState():"")+", India";
						}
					else
					{
						if(hospitalVO.getAddress2()!=null && !hospitalVO.getAddress2().equals("") && !hospitalVO.getAddress2().equals(" "))
						hospitalPlace=hospitalVO.getAddress2()+(hospitalVO.getCity()!=null && !hospitalVO.getCity().equals("") && !hospitalVO.getCity().equals(" ")?", "+ hospitalVO.getCity():"")+(hospitalVO.getPinCode()!=null && !hospitalVO.getPinCode().equals("") && !hospitalVO.getPinCode().equals(" ") && !hospitalVO.getPinCode().equals("0")? "-"+hospitalVO.getPinCode():"")+(hospitalVO.getState()!=null && !hospitalVO.getState().equals("") && !hospitalVO.getState().equals(" ")?", "+ hospitalVO.getState():"")+", India";
						else
						hospitalPlace=(hospitalVO.getCity()!=null && !hospitalVO.getCity().equals("") && !hospitalVO.getCity().equals(" ")? hospitalVO.getCity():"")+(hospitalVO.getPinCode()!=null && !hospitalVO.getPinCode().equals("") && !hospitalVO.getPinCode().equals(" ") && !hospitalVO.getPinCode().equals("0")? "-"+hospitalVO.getPinCode():"")+(hospitalVO.getState()!=null && !hospitalVO.getState().equals("") && !hospitalVO.getState().equals(" ")?", "+ hospitalVO.getState():"")+", India";
					}	
					hospitalContact="Phone :"+(hospitalVO.getPhone()!=null && !hospitalVO.getPhone().equals("") && !hospitalVO.getPhone().equals(" ")? hospitalVO.getPhone():" -")+", "+"Email :"+(hospitalVO.getEmail()!=null && !hospitalVO.getEmail().equals("") && !hospitalVO.getEmail().equals(" ")?hospitalVO.getEmail():" -");
					sBuffer.append("<table border='0'  cellspacing='0' cellpadding='0' align='center'>");
					if(logoflag==1)
					{   
						
						sBuffer.append("<tr>");
						sBuffer.append("<td colspan='3'><table>");
						sBuffer.append("<tr>");								
						if(!strReportFormat.equalsIgnoreCase("pdf"))
						{
							sBuffer.append("<td width='10%'><div align='right'><img src='/INVMGM/hisglobal/images/logo.png' width='100'></div></td>");
							sBuffer.append("<td width='90%' colspan='2'><div align='center'><b>"+hospitalName+"</b></div>");
						}
						else
						{
							String logoPath=this.getParameterFromHisPathXML("LOGO_IMAGE");
							sBuffer.append("<td width='100%' colspan='3'><div align='center'><img src='"+hospLogoPath+"' height='120px' width='120px'></div>");
							sBuffer.append("<div align='center'><b>"+hospitalName+"</b></div>");
						}
						sBuffer.append("<div align='center'><b><font size='4'>&#2309;&#2326;&#2367;&#2354; &#2349;&#2366;&#2352;&#2340;&#2368;&#2351; &#2310;&#2351;&#2369;&#2352;&#2381;&#2357;&#2367;&#2332;&#2381;&#2334;&#2366;&#2344; &#2360;&#2306;&#2360;&#2381;&#2341;&#2366;&#2344; &#2346;&#2335;&#2344;&#2366;</font></b></div>");
					
						sBuffer.append("<div align='center'><b>"+hospitalPlace+"</b></div>");
						sBuffer.append("<div align='center'><b>"+hospitalContact+"</b></div></td>");
						sBuffer.append("</tr>");
						sBuffer.append("</table></td>");
						sBuffer.append("</tr>");
					}
					else
					{
						sBuffer.append("<tr>");
						sBuffer.append("<td width='100%' class='SLIPCONTROL'><div align='center'><b>"+hospitalName+"</b></div></td>");
						sBuffer.append("</tr>");
						if(hospitalAdd!=null && !hospitalAdd.equals("") && !hospitalAdd.equals(" "))
						{
							sBuffer.append("<tr>");
							sBuffer.append("<td width='100%' class='SLIPCONTROL'><div align='center'><b>"+hospitalAdd+"</b></div></td>");
							sBuffer.append("</tr>");
						} 
						sBuffer.append("<tr>");
						sBuffer.append("<td width='100%' class='SLIPCONTROL'><div align='center'><b>"+hospitalPlace+"</b></div></td>");
						sBuffer.append("</tr>");
						sBuffer.append("<tr>");
						sBuffer.append("<td width='100%' class='SLIPCONTROL'><div align='center'><b>"+hospitalContact+"</b></div></td>");
						sBuffer.append("</tr>");
					}
			        sBuffer.append("</table>");
				}
			} 
	        catch (Exception e) 
	        {
				e.printStackTrace();
			}
			return sBuffer.toString();
		}
		
		
		
		public  String getHospitalHeaderNew(String hospCode,int logoflag,String strReportFormat,HttpServletRequest request)
		{
			StringBuffer sBuffer = new StringBuffer("");		
			String hospitalName="";
			String hospitalAdd="";
			String hospitalPlace="";
			String hospitalContact="";
			HospitalMstVO hospitalVO;
			try 
			{
				hospitalVO=this.getHospitalDetail(hospCode);
				if(hospitalVO!=null)
				{
					hospitalName=hospitalVO.getHospitalName();
					hospitalAdd=hospitalVO.getAddress1();
					if(hospitalAdd!=null && !hospitalAdd.equals("") && !hospitalAdd.equals(" "))
					{
						if(hospitalVO.getAddress2()!=null && !hospitalVO.getAddress2().equals("") && !hospitalVO.getAddress2().equals(" "))
						hospitalPlace=hospitalVO.getAddress1()+", "+hospitalVO.getAddress2()+(hospitalVO.getCity()!=null && !hospitalVO.getCity().equals("") && !hospitalVO.getCity().equals(" ")?", "+ hospitalVO.getCity():"")+(hospitalVO.getPinCode()!=null && !hospitalVO.getPinCode().equals("") && !hospitalVO.getPinCode().equals(" ") && !hospitalVO.getPinCode().equals("0")? "-"+hospitalVO.getPinCode():"")+(hospitalVO.getState()!=null && !hospitalVO.getState().equals("") && !hospitalVO.getState().equals(" ")?", "+ hospitalVO.getState():"")+", India";
						else
						hospitalPlace=hospitalVO.getAddress1()+", "+(hospitalVO.getCity()!=null && !hospitalVO.getCity().equals("") && !hospitalVO.getCity().equals(" ")? hospitalVO.getCity():"")+(hospitalVO.getPinCode()!=null && !hospitalVO.getPinCode().equals("") && !hospitalVO.getPinCode().equals(" ") && !hospitalVO.getPinCode().equals("0")? "-"+hospitalVO.getPinCode():"")+(hospitalVO.getState()!=null && !hospitalVO.getState().equals("") && !hospitalVO.getState().equals(" ")?", "+ hospitalVO.getState():"")+", India";
						}
					else
					{
						if(hospitalVO.getAddress2()!=null && !hospitalVO.getAddress2().equals("") && !hospitalVO.getAddress2().equals(" "))
						hospitalPlace=hospitalVO.getAddress2()+(hospitalVO.getCity()!=null && !hospitalVO.getCity().equals("") && !hospitalVO.getCity().equals(" ")?", "+ hospitalVO.getCity():"")+(hospitalVO.getPinCode()!=null && !hospitalVO.getPinCode().equals("") && !hospitalVO.getPinCode().equals(" ") && !hospitalVO.getPinCode().equals("0")? "-"+hospitalVO.getPinCode():"")+(hospitalVO.getState()!=null && !hospitalVO.getState().equals("") && !hospitalVO.getState().equals(" ")?", "+ hospitalVO.getState():"")+", India";
						else
						hospitalPlace=(hospitalVO.getCity()!=null && !hospitalVO.getCity().equals("") && !hospitalVO.getCity().equals(" ")? hospitalVO.getCity():"")+(hospitalVO.getPinCode()!=null && !hospitalVO.getPinCode().equals("") && !hospitalVO.getPinCode().equals(" ") && !hospitalVO.getPinCode().equals("0")? "-"+hospitalVO.getPinCode():"")+(hospitalVO.getState()!=null && !hospitalVO.getState().equals("") && !hospitalVO.getState().equals(" ")?", "+ hospitalVO.getState():"")+", India";
					}	
					hospitalContact="Phone :"+(hospitalVO.getPhone()!=null && !hospitalVO.getPhone().equals("") && !hospitalVO.getPhone().equals(" ")? hospitalVO.getPhone():" -")+", "+"Email :"+(hospitalVO.getEmail()!=null && !hospitalVO.getEmail().equals("") && !hospitalVO.getEmail().equals(" ")?hospitalVO.getEmail():" -");
					sBuffer.append("<table border='0'  cellspacing='0' cellpadding='0' align='center'>");
					if(logoflag==1)
					{   
						
						sBuffer.append("<tr>");
						sBuffer.append("<td colspan='3'><table>");
						sBuffer.append("<tr>");								
						if(!strReportFormat.equalsIgnoreCase("pdf"))
						{
							sBuffer.append("<td width='10%'><div align='right'><img src='/INVMGM/hisglobal/images/logo.png' width='100'></div></td>");
							sBuffer.append("<td width='90%' colspan='2'><div align='center'><b>"+hospitalName+"</b></div>");
							sBuffer.append("<div align='center'><b><font size='4'>&#2309;&#2326;&#2367;&#2354; &#2349;&#2366;&#2352;&#2340;&#2368;&#2351; &#2310;&#2351;&#2369;&#2352;&#2381;&#2357;&#2367;&#2332;&#2381;&#2334;&#2366;&#2344; &#2360;&#2306;&#2360;&#2381;&#2341;&#2366;&#2344; &#2346;&#2335;&#2344;&#2366;</font></b></div>");	
						}
						else
						{
							String hospLogoPath = request.getSession().getServletContext().getRealPath("hisglobal/images/logo.png");
							String hindiHeader =  request.getSession().getServletContext().getRealPath("hisglobal/images/AIIMSP_HindiHeader.png");
							String logoPath=this.getParameterFromHisPathXML("LOGO_IMAGE");
							sBuffer.append("<td width='100%' colspan='3'><div align='center'><img src='"+hospLogoPath+"' height='100px' width='110px'></div>");
							sBuffer.append("<div align='center'><b>"+hospitalName+"</b></div>");
							sBuffer.append("<div align='center'><img src='"+hindiHeader+"' width='260px'></div>");
						}
					//	sBuffer.append("<div align='center'><b><font size='4'>&#2309;&#2326;&#2367;&#2354; &#2349;&#2366;&#2352;&#2340;&#2368;&#2351; &#2310;&#2351;&#2369;&#2352;&#2381;&#2357;&#2367;&#2332;&#2381;&#2334;&#2366;&#2344; &#2360;&#2306;&#2360;&#2381;&#2341;&#2366;&#2344; &#2346;&#2335;&#2344;&#2366;</font></b></div>");		
						sBuffer.append("<div align='center'><b>"+hospitalPlace+"</b></div>");
						sBuffer.append("<div align='center'><b>"+hospitalContact+"</b></div></td>");
						sBuffer.append("</tr>");
						sBuffer.append("</table></td>");
						sBuffer.append("</tr>");
					}
					else
					{ 
						sBuffer.append("<tr>");
						sBuffer.append("<td width='100%' class='SLIPCONTROL'><div align='center'><b>"+hospitalName+"</b></div></td>");
						sBuffer.append("</tr>");
						if(hospitalAdd!=null && !hospitalAdd.equals("") && !hospitalAdd.equals(" "))
						{
							sBuffer.append("<tr>");
							sBuffer.append("<td width='100%' class='SLIPCONTROL'><div align='center'><b>"+hospitalAdd+"</b></div></td>");
							sBuffer.append("</tr>");
						} 
						sBuffer.append("<tr>");
						sBuffer.append("<td width='100%' class='SLIPCONTROL'><div align='center'><b>"+hospitalPlace+"</b></div></td>");
						sBuffer.append("</tr>");
						sBuffer.append("<tr>");
						sBuffer.append("<td width='100%' class='SLIPCONTROL'><div align='center'><b>"+hospitalContact+"</b></div></td>");
						sBuffer.append("</tr>");
					}
			        sBuffer.append("</table>");
				}
			} 
	        catch (Exception e) 
	        {
				e.printStackTrace();
			}
			return sBuffer.toString();
		}
		public  String getHospitalHeaderMain(Map requirement)
		{
			StringBuffer sBuffer = new StringBuffer("");		
			String hospitalName="";
			String hospitalAdd="";
			String hospitalPlace="";
			String hospitalContact="";
			String logoflag="1"; String hindiflag="1"; String hospCode=""; String strReportFormat="html"; HttpServletRequest request=null;  String HeaderReq="1"; //Map Variables with default values
			//    HOSPCODE FORMAT    REQUEST  
			String isReqObj="NO";
			String hospLogoPath="";
			String hindiHeader ="";
			BillConfigUtil bconfig=null;
			
			HospitalMstVO hospitalVO;
			try 
			{	
				 
				
				if(requirement.containsKey("REQUEST"))
					request=(HttpServletRequest) requirement.get("REQUEST");
				if(requirement.containsKey("HOSPCODE"))
					hospCode=(String) requirement.get("HOSPCODE");   //mandatory
				if(requirement.containsKey("FORMAT"))
					strReportFormat= (String) requirement.get("FORMAT");
				if(requirement.containsKey("ISREQOBJ"))              //NOT TO BE SET ONLY FOR THE FILES WHERE REQUEST OBJECT IS NOT AVAILABLE,THEN IMAGE WILL BE FETCH BY XML FILE PATH VARIABLE,SET "NO" IF NOT AVAIL
					isReqObj= (String) requirement.get("ISREQOBJ"); 
				
				
				bconfig= new BillConfigUtil(hospCode);
				HeaderReq=bconfig.getHeaderReq();
				hindiflag=bconfig.getHindiReq();
				logoflag=bconfig.getLogoReq();
				
				hospitalVO=this.getHospitalDetail(hospCode);
				
				if(hospitalVO!=null)
				{
					hospitalName=hospitalVO.getHospitalName();
					hospitalAdd=hospitalVO.getAddress1();
					if(hospitalAdd!=null && !hospitalAdd.equals("") && !hospitalAdd.equals(" "))
					{
						if(hospitalVO.getAddress2()!=null && !hospitalVO.getAddress2().equals("") && !hospitalVO.getAddress2().equals(" "))
						hospitalPlace=hospitalVO.getAddress1()+", "+hospitalVO.getAddress2()+(hospitalVO.getCity()!=null && !hospitalVO.getCity().equals("") && !hospitalVO.getCity().equals(" ")?", "+ hospitalVO.getCity():"")+(hospitalVO.getPinCode()!=null && !hospitalVO.getPinCode().equals("") && !hospitalVO.getPinCode().equals(" ") && !hospitalVO.getPinCode().equals("0")? "-"+hospitalVO.getPinCode():"")+(hospitalVO.getState()!=null && !hospitalVO.getState().equals("") && !hospitalVO.getState().equals(" ")?", "+ hospitalVO.getState():"")+", India";
						else
						hospitalPlace=hospitalVO.getAddress1()+", "+(hospitalVO.getCity()!=null && !hospitalVO.getCity().equals("") && !hospitalVO.getCity().equals(" ")? hospitalVO.getCity():"")+(hospitalVO.getPinCode()!=null && !hospitalVO.getPinCode().equals("") && !hospitalVO.getPinCode().equals(" ") && !hospitalVO.getPinCode().equals("0")? "-"+hospitalVO.getPinCode():"")+(hospitalVO.getState()!=null && !hospitalVO.getState().equals("") && !hospitalVO.getState().equals(" ")?", "+ hospitalVO.getState():"")+", India";
					}
					else
					{
						if(hospitalVO.getAddress2()!=null && !hospitalVO.getAddress2().equals("") && !hospitalVO.getAddress2().equals(" "))
						hospitalPlace=hospitalVO.getAddress2()+(hospitalVO.getCity()!=null && !hospitalVO.getCity().equals("") && !hospitalVO.getCity().equals(" ")?", "+ hospitalVO.getCity():"")+(hospitalVO.getPinCode()!=null && !hospitalVO.getPinCode().equals("") && !hospitalVO.getPinCode().equals(" ") && !hospitalVO.getPinCode().equals("0")? "-"+hospitalVO.getPinCode():"")+(hospitalVO.getState()!=null && !hospitalVO.getState().equals("") && !hospitalVO.getState().equals(" ")?", "+ hospitalVO.getState():"")+", India";
						else
						hospitalPlace=(hospitalVO.getCity()!=null && !hospitalVO.getCity().equals("") && !hospitalVO.getCity().equals(" ")? hospitalVO.getCity():"")+(hospitalVO.getPinCode()!=null && !hospitalVO.getPinCode().equals("") && !hospitalVO.getPinCode().equals(" ") && !hospitalVO.getPinCode().equals("0")? "-"+hospitalVO.getPinCode():"")+(hospitalVO.getState()!=null && !hospitalVO.getState().equals("") && !hospitalVO.getState().equals(" ")?", "+ hospitalVO.getState():"")+", India";
					}	
					//hospitalContact="Phone :"+(hospitalVO.getPhone()!=null && !hospitalVO.getPhone().equals("") && !hospitalVO.getPhone().equals(" ")? hospitalVO.getPhone():" -")+", "+"Email :"+(hospitalVO.getEmail()!=null && !hospitalVO.getEmail().equals("") && !hospitalVO.getEmail().equals(" ")?hospitalVO.getEmail():" -");
					hospitalContact="Phone :"+(hospitalVO.getPhone()!=null && !hospitalVO.getPhone().equals("") && !hospitalVO.getPhone().equals(" ")? hospitalVO.getPhone():" -");
					sBuffer.append("<table border='0'  cellspacing='0' cellpadding='0' align='center'>");
					
					if(isReqObj.equals("YES"))
					{
						 hospLogoPath = request.getSession().getServletContext().getRealPath("hisglobal/images/logo.png");
//						 hindiHeader =  request.getSession().getServletContext().getRealPath("hisglobal/images/AIIMSP_HindiHeader.png");
					}else{
						 hospLogoPath=this.getParameterFromHisPathXML("LOGO_IMAGE");
//						 hindiHeader=this.getParameterFromHisPathXML("HINDIHEADER_IMAGE");
					}
	
						sBuffer.append("<tr>");
					if(HeaderReq.equals("1"))
					{
						sBuffer.append("<td colspan='3'><table>");
						sBuffer.append("<tr>");								
						if(!strReportFormat.equalsIgnoreCase("pdf"))
						{
							if(logoflag.equals("1"))
								sBuffer.append("<td width='10%'><div align='right'><img src='/INVMGM/hisglobal/images/logo.png' width='100'></div></td>");
							sBuffer.append("<td width='90%' colspan='2'><div align='center'><strong>"+hospitalName+"</strong></div>");
						  //sBuffer.append("<div align='center'><b><font size='4'>&#2309;&#2326;&#2367;&#2354; &#2349;&#2366;&#2352;&#2340;&#2368;&#2351; &#2310;&#2351;&#2369;&#2352;&#2381;&#2357;&#2367;&#2332;&#2381;&#2334;&#2366;&#2344; &#2360;&#2306;&#2360;&#2381;&#2341;&#2366;&#2344; &#2346;&#2335;&#2344;&#2366;</font></b></div>");	
//							if(hindiflag.equals("1"))	
//							sBuffer.append("<div align='center'><img src='/INVMGM/hisglobal/images/AIIMSP_HindiHeader.png' height='18' width='322'/></div>");   	
						}
						else
						{
							if(logoflag.equals("1"))
								sBuffer.append("<td width='100%' colspan='3'><div align='center'><img src='"+hospLogoPath+"' height='100px' width='110px'></div>");
								sBuffer.append("<div align='center'><strong>"+hospitalName+"</strong></div>");
//								if(hindiflag.equals("1"))
//								sBuffer.append("<div align='center'><img src='"+hindiHeader+"' width='260px'></div>");
						}
						sBuffer.append("<div align='center'><strong>"+hospitalPlace+"</strong></div>");
						sBuffer.append("<div align='center'><strong>"+hospitalContact+"</strong></div></td>");
						sBuffer.append("</tr>");
						sBuffer.append("</table></td>");
					}
					else
					{
						sBuffer.append("");
					}
						sBuffer.append("</tr>");
				
			        sBuffer.append("</table>");
				}
			} 
	        catch (Exception e) 
	        {
				e.printStackTrace();
			}
			return sBuffer.toString();
		}
		
		public static String startTransation(String menuId,String processName,String shortName,String tokenStatus,HttpServletRequest request,String puk)
		{
			HisDAO daoObj = null;
			
			String strProcName = "{call pkg_trans_log_util.dml_log_trans(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			int nProcIndex = 0;
			String transid = "";
			String strErr ;
			String cr="0";
			String deviceType="1";//1-Desktop,2-Mobile
			String ipaddress="0.0.0.0";
			ipaddress=GetNetworkAddress.GetAddress("ip");
			if(ipaddress!=null)
				ipaddress=ipaddress;
			else
				ipaddress="0.0.0.0";
			if(request.getHeader("User-Agent").contains("Mobi")) 
			{
				deviceType="2";
			} 
			if(puk!=null && !puk.equals("") )
				cr=puk;
				
			
			String hospCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId=request.getSession().getAttribute("SEATID").toString();
			
			try 
			{
				daoObj = new HisDAO("HisGlobal","HisUtil");
				nProcIndex = daoObj.setProcedure(strProcName);
				
				daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
				daoObj.setProcInValue(nProcIndex, "hosp_code", hospCode,2);
				daoObj.setProcInValue(nProcIndex, "process_id", menuId,3);
				daoObj.setProcInValue(nProcIndex, "processname", processName,4);
				daoObj.setProcInValue(nProcIndex, "transid", "0",5);
				daoObj.setProcInValue(nProcIndex, "seatid", seatId,6);
				daoObj.setProcInValue(nProcIndex, "tokenstatus", tokenStatus,7);
				daoObj.setProcInValue(nProcIndex, "puk", cr,8);
				daoObj.setProcInValue(nProcIndex, "trans_type", "4",9);
				daoObj.setProcInValue(nProcIndex, "devicetype", deviceType,10);
				daoObj.setProcInValue(nProcIndex, "ipaddress", ipaddress,11);
				daoObj.setProcInValue(nProcIndex, "shortname", shortName,12);
				daoObj.setProcOutValue(nProcIndex, "generatedtransid", 1,13);
				daoObj.setProcOutValue(nProcIndex, "err", 1,14);

				daoObj.executeProcedureByPosition(nProcIndex);

				transid = daoObj.getString(nProcIndex, "generatedtransid");
				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr==null)
					strErr = "";
				
				if (strErr.equals(""))
				{
					request.getSession().setAttribute("TRANS_ID", transid);
					request.getSession().setAttribute("PUK_CR", puk);
				}				
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			} 
			finally 
			{
				if (daoObj != null) 
				{
					daoObj.free();
					daoObj = null;
				}
			}
			return transid;
		}
		public static void completeTransation(String menuId,String tokenStatus,HttpServletRequest request,String puk)
		{
			HisDAO daoObj = null;
			
			String strProcName = "{call pkg_trans_log_util.dml_log_trans(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			int nProcIndex = 0;
			String strErr = "";
			
			String hospCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId=request.getSession().getAttribute("SEATID").toString();
			
			try 
			{
				String transIdReq=request.getSession().getAttribute("TRANS_ID").toString();

				daoObj = new HisDAO("HisGlobal","HisUtil");
				nProcIndex = daoObj.setProcedure(strProcName);
				
				daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
				daoObj.setProcInValue(nProcIndex, "hosp_code", hospCode,2);
				daoObj.setProcInValue(nProcIndex, "process_id", menuId,3);
				daoObj.setProcInValue(nProcIndex, "processname", "",4);
				daoObj.setProcInValue(nProcIndex, "transid", transIdReq,5);
				daoObj.setProcInValue(nProcIndex, "seatid", seatId,6);
				daoObj.setProcInValue(nProcIndex, "tokenstatus", tokenStatus,7);
				daoObj.setProcInValue(nProcIndex, "puk", puk,8);
				daoObj.setProcInValue(nProcIndex, "trans_type", "4",9);
				daoObj.setProcInValue(nProcIndex, "devicetype", "",10);
				daoObj.setProcInValue(nProcIndex, "ipaddress", "",11);	
				daoObj.setProcInValue(nProcIndex, "shortname", "",12);	
				daoObj.setProcOutValue(nProcIndex, "generatedtransid", 1,13);
				daoObj.setProcOutValue(nProcIndex, "err", 1,14);
				
				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";				
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			} 
			finally 
			{
				if (daoObj != null) 
				{
					daoObj.free();
					daoObj = null;
				}
			}
		}
		
		public String  getModuleList(String seatId,String hospCode) 
		{
			HisDAO daoObj = null;
			WebRowSet ws = null;

			String strProcName = "{call Pkg_Mms_Rpt.rptm_module_list(?,?,?,?,?)}";
			int nProcIndex = 0;
		
			String strErr = "";
			String temp="";

			try 
			{
				daoObj = new HisDAO("HisGlobal","HisUtil");
				nProcIndex = daoObj.setProcedure(strProcName);

				daoObj.setProcInValue(nProcIndex, "modeval", "1");
				daoObj.setProcInValue(nProcIndex, "seatId", seatId);
				daoObj.setProcInValue(nProcIndex, "hosp_code", hospCode);
				daoObj.setProcOutValue(nProcIndex, "err", 1);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2);

				daoObj.executeProcedure(nProcIndex);
		
				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				if (strErr.equals("")) 
				{
					ws = daoObj.getWebRowSet(nProcIndex, "resultset");		
					temp = getOptionValue(ws, "0", "0^Select Value ",false);
				} 
				else 
				{
					throw new Exception(strErr);
				}

			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			} 
			finally 
			{
				if (daoObj != null) 
				{
					daoObj.free();
					daoObj = null;
				}
				
			}
			return temp;
		}
		
		public static void beforeSave(String menuId,String tokenStatus,HttpServletRequest request,String puk)
		{
			HisDAO daoObj = null;
			
			String strProcName = "{call pkg_trans_log_util.dml_log_trans(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			int nProcIndex = 0;
			String strErr = "";
			
			String hospCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId=request.getSession().getAttribute("SEATID").toString();
			
			try 
			{
				String transIdReq=request.getSession().getAttribute("TRANS_ID").toString();

				daoObj = new HisDAO("HisGlobal","HisUtil");
				nProcIndex = daoObj.setProcedure(strProcName);
				
				daoObj.setProcInValue(nProcIndex, "modeval", "3",1);
				daoObj.setProcInValue(nProcIndex, "hosp_code", hospCode,2);
				daoObj.setProcInValue(nProcIndex, "process_id", menuId,3);
				daoObj.setProcInValue(nProcIndex, "processname", "",4);
				daoObj.setProcInValue(nProcIndex, "transid", transIdReq,5);
				daoObj.setProcInValue(nProcIndex, "seatid", seatId,6);
				daoObj.setProcInValue(nProcIndex, "tokenstatus", tokenStatus,7);
				daoObj.setProcInValue(nProcIndex, "puk", puk,8);
				daoObj.setProcInValue(nProcIndex, "trans_type", "4",9);
				daoObj.setProcInValue(nProcIndex, "devicetype", "",10);
				daoObj.setProcInValue(nProcIndex, "ipaddress", "",11);	
				daoObj.setProcInValue(nProcIndex, "shortname", "",12);	
				daoObj.setProcOutValue(nProcIndex, "generatedtransid", 1,13);
				daoObj.setProcOutValue(nProcIndex, "err", 1,14);
				
				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";				
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			} 
			finally 
			{
				if (daoObj != null) 
				{
					daoObj.free();
					daoObj = null;
				}
			}
		}
		public static void afterSave(String menuId,String tokenStatus,HttpServletRequest request,String puk)
		{
			HisDAO daoObj = null;
			
			String strProcName = "{call pkg_trans_log_util.dml_log_trans(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			int nProcIndex = 0;
			String strErr = "";
			
			String hospCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId=request.getSession().getAttribute("SEATID").toString();
			
			try 
			{
				String transIdReq=request.getSession().getAttribute("TRANS_ID").toString();

				daoObj = new HisDAO("HisGlobal","HisUtil");
				nProcIndex = daoObj.setProcedure(strProcName);
				
				daoObj.setProcInValue(nProcIndex, "modeval", "4",1);
				daoObj.setProcInValue(nProcIndex, "hosp_code", hospCode,2);
				daoObj.setProcInValue(nProcIndex, "process_id", menuId,3);
				daoObj.setProcInValue(nProcIndex, "processname", "",4);
				daoObj.setProcInValue(nProcIndex, "transid", transIdReq,5);
				daoObj.setProcInValue(nProcIndex, "seatid", seatId,6);
				daoObj.setProcInValue(nProcIndex, "tokenstatus", tokenStatus,7);
				daoObj.setProcInValue(nProcIndex, "puk", puk,8);
				daoObj.setProcInValue(nProcIndex, "trans_type", "4",9);
				daoObj.setProcInValue(nProcIndex, "devicetype", "",10);
				daoObj.setProcInValue(nProcIndex, "ipaddress", "",11);	
				daoObj.setProcInValue(nProcIndex, "shortname", "",12);	
				daoObj.setProcOutValue(nProcIndex, "generatedtransid", 1,13);
				daoObj.setProcOutValue(nProcIndex, "err", 1,14);
				
				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";				
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			} 
			finally 
			{
				if (daoObj != null) 
				{
					daoObj.free();
					daoObj = null;
				}
			}
		}
}