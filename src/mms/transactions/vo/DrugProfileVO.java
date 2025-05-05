/**
 * 
 */
package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.TransferObject;

/**
 * @author pankaj Date-- 22-Jan-2009 Value Object Class for Drug Profile
 *         Transaction
 * 
 */
public class DrugProfileVO implements TransferObject {
	private static final long serialVersionUID = 02L;

	private String strMsgType = "";
	private String strMsgString = "";

	private String strGroupComboValues = "";
	private String strSubGroupComboValues = "";
	private String strDrugComboValues = "";

	private String strHospitalCode = "";
	private String strGroupID = "1";
	private String strSubGroupID = "";
	private String strSeatID = "";
	private String strItemID = "";

	private String[] strDosAndIndLable = null;
	private String[] strDosAndIndData = null;
	private String[] strSaftyAlertLable = null;
	private String[] strSaftyAlertData = null;
	
	private WebRowSet wsDosageAndIndicationData = null;
	private WebRowSet wsSaftyAlertData = null;
	private WebRowSet wsBrandedItemData = null;
	private WebRowSet strItemNameComboWS=null;
	private WebRowSet strItemWS=null;
	public WebRowSet getStrItemWS() {
		return strItemWS;
	}

	public void setStrItemWS(WebRowSet strItemWS) {
		this.strItemWS = strItemWS;
	}
	
	public WebRowSet getStrItemNameComboWS() {
		return strItemNameComboWS;
	}

	public void setStrItemNameComboWS(WebRowSet strItemNameComboWS) {
		this.strItemNameComboWS = strItemNameComboWS;
	}

	/**
	 * @return the wsBrandedItemData
	 */
	public WebRowSet getWsBrandedItemData() {
		return wsBrandedItemData;
	}

	/**
	 * @param wsBrandedItemData the wsBrandedItemData to set
	 */
	public void setWsBrandedItemData(WebRowSet wsBrandedItemData) {
		this.wsBrandedItemData = wsBrandedItemData;
	}

	/**
	 * @return the strSaftyAlertLable
	 */
	public String[] getStrSaftyAlertLable() {
		return strSaftyAlertLable;
	}

	/**
	 * @param strSaftyAlertLable the strSaftyAlertLable to set
	 */
	public void setStrSaftyAlertLable(String[] strSaftyAlertLable) {
		this.strSaftyAlertLable = strSaftyAlertLable;
	}

	/**
	 * @return the strSaftyAlertData
	 */
	public String[] getStrSaftyAlertData() {
		return strSaftyAlertData;
	}

	/**
	 * @param strSaftyAlertData the strSaftyAlertData to set
	 */
	public void setStrSaftyAlertData(String[] strSaftyAlertData) {
		this.strSaftyAlertData = strSaftyAlertData;
	}

	/**
	 * @return the strDosAndIndLable
	 */
	public String[] getStrDosAndIndLable() {
		return strDosAndIndLable;
	}

	/**
	 * @param strDosAndIndLable the strDosAndIndLable to set
	 */
	public void setStrDosAndIndLable(String[] strDosAndIndLable) {
		this.strDosAndIndLable = strDosAndIndLable;
	}

	/**
	 * @return the strDosAndIndData
	 */
	public String[] getStrDosAndIndData() {
		return strDosAndIndData;
	}

	/**
	 * @param strDosAndIndData the strDosAndIndData to set
	 */
	public void setStrDosAndIndData(String[] strDosAndIndData) {
		this.strDosAndIndData = strDosAndIndData;
	}

	/**
	 * @return the wsSaftyAlertData
	 */
	public WebRowSet getWsSaftyAlertData() {
		return wsSaftyAlertData;
	}

	/**
	 * @param wsSaftyAlertData
	 *            the wsSaftyAlertData to set
	 */
	public void setWsSaftyAlertData(WebRowSet wsSaftyAlertData) {
		this.wsSaftyAlertData = wsSaftyAlertData;
	}

	/**
	 * @return the wsDosageAndIndicationData
	 */
	public WebRowSet getWsDosageAndIndicationData() {
		return wsDosageAndIndicationData;
	}

	/**
	 * @param wsDosageAndIndicationData
	 *            the wsDosageAndIndicationData to set
	 */
	public void setWsDosageAndIndicationData(WebRowSet wsDosageAndIndicationData) {
		this.wsDosageAndIndicationData = wsDosageAndIndicationData;
	}

	/**
	 * @return the strSeatID
	 */
	public String getStrSeatID() {
		return strSeatID;
	}

	/**
	 * @param strSeatID
	 *            the strSeatID to set
	 */
	public void setStrSeatID(String strSeatID) {
		this.strSeatID = strSeatID;
	}

	/**
	 * @return the strItemID
	 */
	public String getStrItemID() {
		return strItemID;
	}

	/**
	 * @param strItemID
	 *            the strItemID to set
	 */
	public void setStrItemID(String strItemID) {
		this.strItemID = strItemID;
	}

	/**
	 * @return the strSubGroupID
	 */
	public String getStrSubGroupID() {
		return strSubGroupID;
	}

	/**
	 * @param strSubGroupID
	 *            the strSubGroupID to set
	 */
	public void setStrSubGroupID(String strSubGroupID) {
		this.strSubGroupID = strSubGroupID;
	}

	/**
	 * @return the strGroupID
	 */
	public String getStrGroupID() {
		return strGroupID;
	}

	/**
	 * @param strGroupID
	 *            the strGroupID to set
	 */
	public void setStrGroupID(String strGroupID) {
		this.strGroupID = strGroupID;
	}

	/**
	 * @return the strHospitalCode
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	/**
	 * @param strHospitalCode
	 *            the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * @return the strGroupComboValues
	 */
	public String getStrGroupComboValues() {
		return strGroupComboValues;
	}

	/**
	 * @param strGroupComboValues
	 *            the strGroupComboValues to set
	 */
	public void setStrGroupComboValues(String strGroupComboValues) {
		this.strGroupComboValues = strGroupComboValues;
	}

	/**
	 * @return the strSubGroupComboValues
	 */
	public String getStrSubGroupComboValues() {
		return strSubGroupComboValues;
	}

	/**
	 * @param strSubGroupComboValues
	 *            the strSubGroupComboValues to set
	 */
	public void setStrSubGroupComboValues(String strSubGroupComboValues) {
		this.strSubGroupComboValues = strSubGroupComboValues;
	}

	/**
	 * @return the strDrugComboValues
	 */
	public String getStrDrugComboValues() {
		return strDrugComboValues;
	}

	/**
	 * @param strDrugComboValues
	 *            the strDrugComboValues to set
	 */
	public void setStrDrugComboValues(String strDrugComboValues) {
		this.strDrugComboValues = strDrugComboValues;
	}

	/**
	 * @return the strMsgType
	 */
	public String getStrMsgType() {
		return strMsgType;
	}

	/**
	 * @param strMsgType
	 *            the strMsgType to set
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	/**
	 * @return the strMsgString
	 */
	public String getStrMsgString() {
		return strMsgString;
	}

	/**
	 * @param strMsgString
	 *            the strMsgString to set
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

}
