package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;

/**
 * Developer : Tanvi Sappal
 * Date : 22/Jan/2009 version : 1.0
 * Mod Date : 23/Jun/2008
 */

public class FinancialEndYearTransFB extends ActionForm {
	
	private static final long serialVersionUID = 02L;
	
	private String strStoreId="";
	private String strStoreName="";
	private String strFinStartDate="";
	private String strFinEndDate="";
	private String strNewFinStartDate="";
	private String strNewFinEndDate="";
	
	private String strNormalMsg="";
	private String strErrMsg="";
	private String strWarningMsg="";
	private String strSeatId ="";
	private String strHospitalCode ="";
	private String strCurrentDate="";
	
	private String strStoreNameCombo=null;
	
	
	
	public String getStrStoreNameCombo() {
		return strStoreNameCombo;
	}
	public void setStrStoreNameCombo(String strStoreNameCombo) {
		this.strStoreNameCombo = strStoreNameCombo;
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
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public String getStrFinStartDate() {
		return strFinStartDate;
	}
	public void setStrFinStartDate(String strFinStartDate) {
		this.strFinStartDate = strFinStartDate;
	}
	public String getStrFinEndDate() {
		return strFinEndDate;
	}
	public void setStrFinEndDate(String strFinEndDate) {
		this.strFinEndDate = strFinEndDate;
	}
	public String getStrNormalMsg() {
		return strNormalMsg;
	}
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}
	public String getStrErrMsg() {
		return strErrMsg;
	}
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}
	public String getStrWarningMsg() {
		return strWarningMsg;
	}
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	/**
	 * @return the strNewFinStartDate
	 */
	public String getStrNewFinStartDate() {
		return strNewFinStartDate;
	}
	/**
	 * @param strNewFinStartDate the strNewFinStartDate to set
	 */
	public void setStrNewFinStartDate(String strNewFinStartDate) {
		this.strNewFinStartDate = strNewFinStartDate;
	}
	/**
	 * @return the strNewFinEndDate
	 */
	public String getStrNewFinEndDate() {
		return strNewFinEndDate;
	}
	/**
	 * @param strNewFinEndDate the strNewFinEndDate to set
	 */
	public void setStrNewFinEndDate(String strNewFinEndDate) {
		this.strNewFinEndDate = strNewFinEndDate;
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

}
