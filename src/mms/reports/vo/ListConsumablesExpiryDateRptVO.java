package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

public class ListConsumablesExpiryDateRptVO {
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String strMsgType = "";
	private String strMsgString = "";
	
	private String strStoreId = "";
	private String strItemCatId = "";
	private String strMode;
	
	private String  strItemCategoryId="";
	private String  strStoreName="";
	
	private String  strCategoryName="";
	private String  strReportFormat="";
	
	
	private WebRowSet strItemCatWs = null;
	private WebRowSet strStoreWs = null;
	private WebRowSet strDistrictStoreWs = null;
	private WebRowSet WsExpiryDtlRpt = null;
	
	private String  strExpNonExpiryFlag="";
	private String  strDateDaysFlag="";
	private String  strDueDate="";
	private String  strFrmExpiryDays="";
	
	private String strLogoName ="";
	
	public String getStrLogoName() {
		return strLogoName;
	}
	public void setStrLogoName(String strLogoName) {
		this.strLogoName = strLogoName;
	}

	
	public String getStrFrmExpiryDays() {
		return strFrmExpiryDays;
	}
	public void setStrFrmExpiryDays(String strFrmExpiryDays) {
		this.strFrmExpiryDays = strFrmExpiryDays;
	}
	public String getStrDueDate() {
		return strDueDate;
	}
	public void setStrDueDate(String strDueDate) {
		this.strDueDate = strDueDate;
	}
	public String getStrExpNonExpiryFlag() {
		return strExpNonExpiryFlag;
	}
	public void setStrExpNonExpiryFlag(String strExpNonExpiryFlag) {
		this.strExpNonExpiryFlag = strExpNonExpiryFlag;
	}
	public String getStrDateDaysFlag() {
		return strDateDaysFlag;
	}
	public void setStrDateDaysFlag(String strDateDaysFlag) {
		this.strDateDaysFlag = strDateDaysFlag;
	}
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public String getStrCategoryName() {
		return strCategoryName;
	}
	public void setStrCategoryName(String strCategoryName) {
		this.strCategoryName = strCategoryName;
	}
	public String getStrReportFormat() {
		return strReportFormat;
	}
	public void setStrReportFormat(String strReportFormat) {
		this.strReportFormat = strReportFormat;
	}
	
	public String getStrItemCategoryId() {
		return strItemCategoryId;
	}
	public void setStrItemCategoryId(String strItemCategoryId) {
		this.strItemCategoryId = strItemCategoryId;
	}
	
	public WebRowSet getStrDistrictStoreWs() {
		return strDistrictStoreWs;
	}
	public void setStrDistrictStoreWs(WebRowSet strDistrictStoreWs) {
		this.strDistrictStoreWs = strDistrictStoreWs;
	}
	
	public WebRowSet getWsExpiryDtlRpt() {
		return WsExpiryDtlRpt;
	}
	public void setWsExpiryDtlRpt(WebRowSet wsExpiryDtlRpt) {
		WsExpiryDtlRpt = wsExpiryDtlRpt;
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
	 * @return the strItemCatWs
	 */
	public WebRowSet getStrItemCatWs() {
		return strItemCatWs;
	}
	/**
	 * @param strItemCatWs the strItemCatWs to set
	 */
	public void setStrItemCatWs(WebRowSet strItemCatWs) {
		this.strItemCatWs = strItemCatWs;
	}
	/**
	 * @return the strStoreWs
	 */
	public WebRowSet getStrStoreWs() {
		return strStoreWs;
	}
	/**
	 * @param strStoreWs the strStoreWs to set
	 */
	public void setStrStoreWs(WebRowSet strStoreWs) {
		this.strStoreWs = strStoreWs;
	}
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}
	
}
