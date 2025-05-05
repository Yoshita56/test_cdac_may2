package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.TransferObject;

/**
 * Developer : Tanvi Sappal
 * Date : 22/Jan/2009 version : 1.0
 * Mod Date : 23/Jun/2008
 */

public class FinancialEndYearTransVO implements TransferObject {
	
    private static final long serialVersionUID = 02L;
	
	private String strStoreId="";
	private String strStoreName="";
	private String strFinStartDate="";
	private String strFinEndDate="";
	private String strNewFinStartDate="";
	private String strNewFinEndDate="";
	
	private String strMsgString="";
	private String strMsgType="";
	private String strSeatId ="";
	private String strHospitalCode ="";
	
	private WebRowSet strStoreNameComboWS=null;

	
	public String getStrMsgString() {
		return strMsgString;
	}

	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	public String getStrMsgType() {
		return strMsgType;
	}

	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
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

	public WebRowSet getStrStoreNameComboWS() {
		return strStoreNameComboWS;
	}

	public void setStrStoreNameComboWS(WebRowSet strStoreNameComboWS) {
		this.strStoreNameComboWS = strStoreNameComboWS;
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

}
