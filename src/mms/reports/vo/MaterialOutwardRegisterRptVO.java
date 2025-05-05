package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

public class MaterialOutwardRegisterRptVO {
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String strMsgType = "";
	private String strMsgString = "";
	
	private String strCurrentDate;
	private String strFromDate;
	private String strToDate;
	
	private String strStoreId = "";
	private String strDrugWarehouseTypeId = "";
	private String StrIssueNumber;

	private WebRowSet strDrugWarehouseTypeWs = null;
	private WebRowSet strManufactureComboWS=null;
	private WebRowSet strStoreWs = null;
	private WebRowSet strIssueDtlWs = null;
	private WebRowSet strIssueItemDtlWs=null;
	private String strProcRelatedValue;
	private String strToStoreCombo;
	private String strToStoreId;
	
	private String strCategoryId;
	
	private String strMode;
	
	
	private String strStoreName;
	private String strToStoreName;
	
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}
	public String getStrProcRelatedValue() {
		return strProcRelatedValue;
	}
	public void setStrProcRelatedValue(String strProcRelatedValue) {
		this.strProcRelatedValue = strProcRelatedValue;
	}
	public WebRowSet getStrIssueItemDtlWs() {
		return strIssueItemDtlWs;
	}
	public void setStrIssueItemDtlWs(WebRowSet strIssueItemDtlWs) {
		this.strIssueItemDtlWs = strIssueItemDtlWs;
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
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public WebRowSet getStrStoreWs() {
		return strStoreWs;
	}
	public void setStrStoreWs(WebRowSet strStoreWs) {
		this.strStoreWs = strStoreWs;
	}
	public String getStrDrugWarehouseTypeId() {
		return strDrugWarehouseTypeId;
	}
	public void setStrDrugWarehouseTypeId(String strDrugWarehouseTypeId) {
		this.strDrugWarehouseTypeId = strDrugWarehouseTypeId;
	}
	public WebRowSet getStrDrugWarehouseTypeWs() {
		return strDrugWarehouseTypeWs;
	}
	public void setStrDrugWarehouseTypeWs(WebRowSet strDrugWarehouseTypeWs) {
		this.strDrugWarehouseTypeWs = strDrugWarehouseTypeWs;
	}
	public WebRowSet getStrManufactureComboWS() {
		return strManufactureComboWS;
	}
	public void setStrManufactureComboWS(WebRowSet strManufactureComboWS) {
		this.strManufactureComboWS = strManufactureComboWS;
	}
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}
	public String getStrFromDate() {
		return strFromDate;
	}
	public void setStrFromDate(String strFromDate) {
		this.strFromDate = strFromDate;
	}
	public String getStrToDate() {
		return strToDate;
	}
	public void setStrToDate(String strToDate) {
		this.strToDate = strToDate;
	}
	public WebRowSet getStrIssueDtlWs() {
		return strIssueDtlWs;
	}
	public void setStrIssueDtlWs(WebRowSet strIssueDtlWs) {
		this.strIssueDtlWs = strIssueDtlWs;
	}
	public String getStrIssueNumber() {
		return StrIssueNumber;
	}
	public void setStrIssueNumber(String strIssueNumber) {
		StrIssueNumber = strIssueNumber;
	}
	public String getStrToStoreCombo() {
		return strToStoreCombo;
	}
	public void setStrToStoreCombo(String strToStoreCombo) {
		this.strToStoreCombo = strToStoreCombo;
	}
	public String getStrToStoreId() {
		return strToStoreId;
	}
	public void setStrToStoreId(String strToStoreId) {
		this.strToStoreId = strToStoreId;
	}
	public String getStrCategoryId() {
		return strCategoryId;
	}
	public void setStrCategoryId(String strCategoryId) {
		this.strCategoryId = strCategoryId;
	}
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public String getStrToStoreName() {
		return strToStoreName;
	}
	public void setStrToStoreName(String strToStoreName) {
		this.strToStoreName = strToStoreName;
	}


}

