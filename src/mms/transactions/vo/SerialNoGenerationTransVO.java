package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.TransferObject;

/**
 * @author Niharika Srivastava 
 * Date Of Creation : 15-Sep-2010 
 * Team Lead : Mr. Ajay Kumar Gupta 
 * Module : MMS 
 * Process : Serial No Generation Transaction
 * Description : Value Object (VO) for Serial No Generation Transaction
 * Version : 1.0
 * Last Modified By :-- 
 * Last Modification Date :--
 */

public class SerialNoGenerationTransVO implements TransferObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String strMsgString ="";
	private String strMsgType ="";
	private String strSeatId ="";
	private String strHospitalCode ="";
	private WebRowSet wsStoreNameCombo = null;
	private WebRowSet wsItemCategoryCombo = null;
	private WebRowSet wsItemNameCombo = null;
	private WebRowSet wsReportNameCombo = null;
	private String strStoreId = "0";
	private String strItemCatId = "0";
	private String strFromDate ="";
	private String strToDate ="";
	
	/**
	 * @return the wsStoreNameCombo
	 */
	public WebRowSet getWsStoreNameCombo() {
		return wsStoreNameCombo;
	}
	/**
	 * @param wsStoreNameCombo the wsStoreNameCombo to set
	 */
	public void setWsStoreNameCombo(WebRowSet wsStoreNameCombo) {
		this.wsStoreNameCombo = wsStoreNameCombo;
	}
	/**
	 * @return the strMsgString
	 */
	public String getStrMsgString() {
		return strMsgString;
	}
	/**
	 * @param strMsgString the strMsgString to set
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}
	/**
	 * @return the strMsgType
	 */
	public String getStrMsgType() {
		return strMsgType;
	}
	/**
	 * @param strMsgType the strMsgType to set
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
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
	 * @return the wsItemCategoryCombo
	 */
	public WebRowSet getWsItemCategoryCombo() {
		return wsItemCategoryCombo;
	}
	/**
	 * @param wsItemCategoryCombo the wsItemCategoryCombo to set
	 */
	public void setWsItemCategoryCombo(WebRowSet wsItemCategoryCombo) {
		this.wsItemCategoryCombo = wsItemCategoryCombo;
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
	 * @return the strItemCatId
	 */
	public String getStrItemCatId() {
		return strItemCatId;
	}
	/**
	 * @param strItemCatId the strItemCatId to set
	 */
	public void setStrItemCatId(String strItemCatId) {
		this.strItemCatId = strItemCatId;
	}
	/**
	 * @return the wsItemNameCombo
	 */
	public WebRowSet getWsItemNameCombo() {
		return wsItemNameCombo;
	}
	/**
	 * @param wsItemNameCombo the wsItemNameCombo to set
	 */
	public void setWsItemNameCombo(WebRowSet wsItemNameCombo) {
		this.wsItemNameCombo = wsItemNameCombo;
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
	/**
	 * @return the wsReportNameCombo
	 */
	public WebRowSet getWsReportNameCombo() {
		return wsReportNameCombo;
	}
	/**
	 * @param wsReportNameCombo the wsReportNameCombo to set
	 */
	public void setWsReportNameCombo(WebRowSet wsReportNameCombo) {
		this.wsReportNameCombo = wsReportNameCombo;
	}
}
