package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

public class DebtorRegisterRptVO {
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String strIsFooter = "";
	private String strUserRemarks = "";
	private String strReportFormat = "0";
	private String strReportId = "";
	
	private String strMsgString = "";
	private String strMsgType = "";
	
	private String strItemCategoryNo = "";
	
	private WebRowSet itemCategoryWS = null;
	
	private String strStoreId = "";
	private String strSupplierId;
	private String strDrugWarehouseTypeId = "";

	private WebRowSet strDrugWarehouseTypeWs = null;
	private WebRowSet strManufactureComboWS=null;
	private WebRowSet strStoreWs = null;
	private WebRowSet strConsolidatedStoreWs = null;
	private WebRowSet strConsolidatedIssuedItemWs = null;
	private WebRowSet strChallanWs = null;
	private String strFromDate;
	private String strToDate;
	private String strPoNumber;
	private String strIssueNumber;
	private String strProcRelatedValue;
	
	private String strMode;
	

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

	public String getStrPoNumber() {
		return strPoNumber;
	}

	public void setStrPoNumber(String strPoNumber) {
		this.strPoNumber = strPoNumber;
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

	
	public String getStrStoreId() {
		return strStoreId;
	}

	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
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

	public WebRowSet getStrStoreWs() {
		return strStoreWs;
	}

	public void setStrStoreWs(WebRowSet strStoreWs) {
		this.strStoreWs = strStoreWs;
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
	 * @return the strIsFooter
	 */
	public String getStrIsFooter() {
		return strIsFooter;
	}

	/**
	 * @param strIsFooter the strIsFooter to set
	 */
	public void setStrIsFooter(String strIsFooter) {
		this.strIsFooter = strIsFooter;
	}

	/**
	 * @return the strUserRemarks
	 */
	public String getStrUserRemarks() {
		return strUserRemarks;
	}

	/**
	 * @param strUserRemarks the strUserRemarks to set
	 */
	public void setStrUserRemarks(String strUserRemarks) {
		this.strUserRemarks = strUserRemarks;
	}

	/**
	 * @return the strReportFormat
	 */
	public String getStrReportFormat() {
		return strReportFormat;
	}

	/**
	 * @param strReportFormat the strReportFormat to set
	 */
	public void setStrReportFormat(String strReportFormat) {
		this.strReportFormat = strReportFormat;
	}

	/**
	 * @return the strReportId
	 */
	public String getStrReportId() {
		return strReportId;
	}

	/**
	 * @param strReportId the strReportId to set
	 */
	public void setStrReportId(String strReportId) {
		this.strReportId = strReportId;
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
	 * @return the strItemCategoryNo
	 */
	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}

	/**
	 * @param strItemCategoryNo the strItemCategoryNo to set
	 */
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}

	/**
	 * @return the itemCategoryWS
	 */
	public WebRowSet getItemCategoryWS() {
		return itemCategoryWS;
	}

	/**
	 * @param itemCategoryWS the itemCategoryWS to set
	 */
	public void setItemCategoryWS(WebRowSet itemCategoryWS) {
		this.itemCategoryWS = itemCategoryWS;
	}

	public String getStrSupplierId() {
		return strSupplierId;
	}

	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}

	public WebRowSet getStrChallanWs() {
		return strChallanWs;
	}

	public void setStrChallanWs(WebRowSet strChallanWs) {
		this.strChallanWs = strChallanWs;
	}	

	public WebRowSet getStrConsolidatedIssuedItemWs() {
		return strConsolidatedIssuedItemWs;
	}

	public void setStrConsolidatedIssuedItemWs(WebRowSet strConsolidatedIssuedItemWs) {
		this.strConsolidatedIssuedItemWs = strConsolidatedIssuedItemWs;
	}

	public WebRowSet getStrConsolidatedStoreWs() {
		return strConsolidatedStoreWs;
	}

	public void setStrConsolidatedStoreWs(WebRowSet strConsolidatedStoreWs) {
		this.strConsolidatedStoreWs = strConsolidatedStoreWs;
	}

	public String getStrIssueNumber() {
		return strIssueNumber;
	}

	public void setStrIssueNumber(String strIssueNumber) {
		this.strIssueNumber = strIssueNumber;
	}

}
