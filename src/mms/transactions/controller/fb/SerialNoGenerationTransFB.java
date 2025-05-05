/**
 * 
 */
package mms.transactions.controller.fb;

import hisglobal.masterutil.GenericFormBean;

/**
 * @author Niharika Srivastava 
 * Date Of Creation : 15-Sep-2010 
 * Team Lead : Mr. Ajay Kumar Gupta 
 * Module : MMS 
 * Process : Serial No Generation Transaction
 * Description : Form Bean for Serial No Generation Transaction
 * Version : 1.0
 * Last Modified By :-- 
 * Last Modification Date :--
 */

public class SerialNoGenerationTransFB extends GenericFormBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String strNormalMsg="";
	private String strErrMsg="";
	private String strWarningMsg="";
	private String strSeatId ="";
	private String strHospitalCode ="";
	private String strStoreId = "0";
	private String strStoreNameCombo = "";
	private String strItemCategoryId = "";
	private String strItemCategoryCombo = "";
	private String strReprintChk = "0";
	private String strItemName = "";
	private String strQtyForSerial ="";
	private String strPrefix ="";
	private String strReportName ="";
	private String strCurrentDate = "";
	private String strAvlQty= "";
	private String strFromDate ="";
	private String strToDate ="";
	
	/**
	 * @return the strAvlQty
	 */
	public String getStrAvlQty() {
		return strAvlQty;
	}
	/**
	 * @param strAvlQty the strAvlQty to set
	 */
	public void setStrAvlQty(String strAvlQty) {
		this.strAvlQty = strAvlQty;
	}
	/**
	 * @return the strCurrentDate
	 */
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	/**
	 * @param strCurrentDate the strCurrentDate to set
	 */
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}
	/**
	 * @return the strItemName
	 */
	public String getStrItemName() {
		return strItemName;
	}
	/**
	 * @param strItemName the strItemName to set
	 */
	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}
	/**
	 * @return the strNormalMsg
	 */
	public String getStrNormalMsg() {
		return strNormalMsg;
	}
	/**
	 * @param strNormalMsg the strNormalMsg to set
	 */
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}
	/**
	 * @return the strErrMsg
	 */
	public String getStrErrMsg() {
		return strErrMsg;
	}
	/**
	 * @param strErrMsg the strErrMsg to set
	 */
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}
	/**
	 * @return the strWarningMsg
	 */
	public String getStrWarningMsg() {
		return strWarningMsg;
	}
	/**
	 * @param strWarningMsg the strWarningMsg to set
	 */
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}
	/**
	 * @return the strSeatId
	 */
	public String getStrSeatId() {
		return strSeatId;
	}
	/**
	 * @param strSeatId the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	/**
	 * @return the strHospitalCode
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	/**
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	/**
	 * @return the strStoreId
	 */
	public String getStrStoreId() {
		return strStoreId;
	}
	/**
	 * @param strStoreId the strStoreId to set
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	/**
	 * @return the strStoreNameCombo
	 */
	public String getStrStoreNameCombo() {
		return strStoreNameCombo;
	}
	/**
	 * @param strStoreNameCombo the strStoreNameCombo to set
	 */
	public void setStrStoreNameCombo(String strStoreNameCombo) {
		this.strStoreNameCombo = strStoreNameCombo;
	}
	/**
	 * @return the strItemCategoryId
	 */
	public String getStrItemCategoryId() {
		return strItemCategoryId;
	}
	/**
	 * @param strItemCategoryId the strItemCategoryId to set
	 */
	public void setStrItemCategoryId(String strItemCategoryId) {
		this.strItemCategoryId = strItemCategoryId;
	}
	/**
	 * @return the strItemCategoryCombo
	 */
	public String getStrItemCategoryCombo() {
		return strItemCategoryCombo;
	}
	/**
	 * @param strItemCategoryCombo the strItemCategoryCombo to set
	 */
	public void setStrItemCategoryCombo(String strItemCategoryCombo) {
		this.strItemCategoryCombo = strItemCategoryCombo;
	}
	/**
	 * @return the strReprintChk
	 */
	public String getStrReprintChk() {
		return strReprintChk;
	}
	/**
	 * @param strReprintChk the strReprintChk to set
	 */
	public void setStrReprintChk(String strReprintChk) {
		this.strReprintChk = strReprintChk;
	}
	/**
	 * @return the strQtyForSerial
	 */
	public String getStrQtyForSerial() {
		return strQtyForSerial;
	}
	/**
	 * @param strQtyForSerial the strQtyForSerial to set
	 */
	public void setStrQtyForSerial(String strQtyForSerial) {
		this.strQtyForSerial = strQtyForSerial;
	}
	/**
	 * @return the strPrefix
	 */
	public String getStrPrefix() {
		return strPrefix;
	}
	/**
	 * @param strPrefix the strPrefix to set
	 */
	public void setStrPrefix(String strPrefix) {
		this.strPrefix = strPrefix;
	}
	/**
	 * @return the strReportName
	 */
	public String getStrReportName() {
		return strReportName;
	}
	/**
	 * @param strReportName the strReportName to set
	 */
	public void setStrReportName(String strReportName) {
		this.strReportName = strReportName;
	}
	/**
	 * @return the strFromDate
	 */
	public String getStrFromDate() {
		return strFromDate;
	}
	/**
	 * @param strFromDate the strFromDate to set
	 */
	public void setStrFromDate(String strFromDate) {
		this.strFromDate = strFromDate;
	}
	/**
	 * @return the strToDate
	 */
	public String getStrToDate() {
		return strToDate;
	}
	/**
	 * @param strToDate the strToDate to set
	 */
	public void setStrToDate(String strToDate) {
		this.strToDate = strToDate;
	}
	
}
