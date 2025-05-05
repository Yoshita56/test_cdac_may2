package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

public class WarrentyDetailsTransVO {
private static final long serialVersionUID = 02L;
	
	private String strMsgString = "";
	private String strMsgType = "";
	
	private String strHospitalCode = "";
	private String strSeatId="";
	private String strFinancialStartyear="";
	private String strFinancialEndYear="";
	
	private String strTenderNo="";
	private String strQuotationNo="";
	private String strPoNo="";
	private String strManufacturerID="";
	private String strItemCategoryID="";
	private String strGroupID="";
	private String strSubGroupID="";
	private String strItemID="";
	private String strBrandID="";
	private String strWarrentyStartDate="";
	private String strWarrentyUpto="";
	private String strWarrentyUnit="";
	private String strRemarks="";
	private String strBatchSlNo="";
	
	private WebRowSet strManufacturerNameComboValuesWS=null;
	private WebRowSet strItemCategoryComboValuesWS=null;
	private WebRowSet strGroupNameComboValuesWS=null;
	private WebRowSet strSubGroupNameComboValuesWS=null;
	private WebRowSet strItemnameComboValuesWS=null;
	private WebRowSet strBrandNameComboValuesWS=null;
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
	 * @return the strTenderNo
	 */
	public String getStrTenderNo() {
		return strTenderNo;
	}
	/**
	 * @param strTenderNo the strTenderNo to set
	 */
	public void setStrTenderNo(String strTenderNo) {
		this.strTenderNo = strTenderNo;
	}
	/**
	 * @return the strQuotationNo
	 */
	public String getStrQuotationNo() {
		return strQuotationNo;
	}
	/**
	 * @param strQuotationNo the strQuotationNo to set
	 */
	public void setStrQuotationNo(String strQuotationNo) {
		this.strQuotationNo = strQuotationNo;
	}
	/**
	 * @return the strPoNo
	 */
	public String getStrPoNo() {
		return strPoNo;
	}
	/**
	 * @param strPoNo the strPoNo to set
	 */
	public void setStrPoNo(String strPoNo) {
		this.strPoNo = strPoNo;
	}
	/**
	 * @return the strManufacturerID
	 */
	public String getStrManufacturerID() {
		return strManufacturerID;
	}
	/**
	 * @param strManufacturerID the strManufacturerID to set
	 */
	public void setStrManufacturerID(String strManufacturerID) {
		this.strManufacturerID = strManufacturerID;
	}
	/**
	 * @return the strItemCategoryID
	 */
	public String getStrItemCategoryID() {
		return strItemCategoryID;
	}
	/**
	 * @param strItemCategoryID the strItemCategoryID to set
	 */
	public void setStrItemCategoryID(String strItemCategoryID) {
		this.strItemCategoryID = strItemCategoryID;
	}
	/**
	 * @return the strGroupID
	 */
	public String getStrGroupID() {
		return strGroupID;
	}
	/**
	 * @param strGroupID the strGroupID to set
	 */
	public void setStrGroupID(String strGroupID) {
		this.strGroupID = strGroupID;
	}
	/**
	 * @return the strSubGroupID
	 */
	public String getStrSubGroupID() {
		return strSubGroupID;
	}
	/**
	 * @param strSubGroupID the strSubGroupID to set
	 */
	public void setStrSubGroupID(String strSubGroupID) {
		this.strSubGroupID = strSubGroupID;
	}
	/**
	 * @return the strItemID
	 */
	public String getStrItemID() {
		return strItemID;
	}
	/**
	 * @param strItemID the strItemID to set
	 */
	public void setStrItemID(String strItemID) {
		this.strItemID = strItemID;
	}
	/**
	 * @return the strBrandID
	 */
	public String getStrBrandID() {
		return strBrandID;
	}
	/**
	 * @param strBrandID the strBrandID to set
	 */
	public void setStrBrandID(String strBrandID) {
		this.strBrandID = strBrandID;
	}
	/**
	 * @return the strWarrentyStartDate
	 */
	public String getStrWarrentyStartDate() {
		return strWarrentyStartDate;
	}
	/**
	 * @param strWarrentyStartDate the strWarrentyStartDate to set
	 */
	public void setStrWarrentyStartDate(String strWarrentyStartDate) {
		this.strWarrentyStartDate = strWarrentyStartDate;
	}
	/**
	 * @return the strWarrentyUpto
	 */
	public String getStrWarrentyUpto() {
		return strWarrentyUpto;
	}
	/**
	 * @param strWarrentyUpto the strWarrentyUpto to set
	 */
	public void setStrWarrentyUpto(String strWarrentyUpto) {
		this.strWarrentyUpto = strWarrentyUpto;
	}
	/**
	 * @return the strWarrentyUnit
	 */
	public String getStrWarrentyUnit() {
		return strWarrentyUnit;
	}
	/**
	 * @param strWarrentyUnit the strWarrentyUnit to set
	 */
	public void setStrWarrentyUnit(String strWarrentyUnit) {
		this.strWarrentyUnit = strWarrentyUnit;
	}
	/**
	 * @return the strRemarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}
	/**
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	/**
	 * @return the strManufacturerNameComboValuesWS
	 */
	public WebRowSet getStrManufacturerNameComboValuesWS() {
		return strManufacturerNameComboValuesWS;
	}
	/**
	 * @param strManufacturerNameComboValuesWS the strManufacturerNameComboValuesWS to set
	 */
	public void setStrManufacturerNameComboValuesWS(
			WebRowSet strManufacturerNameComboValuesWS) {
		this.strManufacturerNameComboValuesWS = strManufacturerNameComboValuesWS;
	}
	/**
	 * @return the strItemCategoryComboValuesWS
	 */
	public WebRowSet getStrItemCategoryComboValuesWS() {
		return strItemCategoryComboValuesWS;
	}
	/**
	 * @param strItemCategoryComboValuesWS the strItemCategoryComboValuesWS to set
	 */
	public void setStrItemCategoryComboValuesWS(
			WebRowSet strItemCategoryComboValuesWS) {
		this.strItemCategoryComboValuesWS = strItemCategoryComboValuesWS;
	}
	/**
	 * @return the strGroupNameComboValuesWS
	 */
	public WebRowSet getStrGroupNameComboValuesWS() {
		return strGroupNameComboValuesWS;
	}
	/**
	 * @param strGroupNameComboValuesWS the strGroupNameComboValuesWS to set
	 */
	public void setStrGroupNameComboValuesWS(WebRowSet strGroupNameComboValuesWS) {
		this.strGroupNameComboValuesWS = strGroupNameComboValuesWS;
	}
	/**
	 * @return the strSubGroupNameComboValuesWS
	 */
	public WebRowSet getStrSubGroupNameComboValuesWS() {
		return strSubGroupNameComboValuesWS;
	}
	/**
	 * @param strSubGroupNameComboValuesWS the strSubGroupNameComboValuesWS to set
	 */
	public void setStrSubGroupNameComboValuesWS(
			WebRowSet strSubGroupNameComboValuesWS) {
		this.strSubGroupNameComboValuesWS = strSubGroupNameComboValuesWS;
	}
	/**
	 * @return the strItemnameComboValuesWS
	 */
	public WebRowSet getStrItemnameComboValuesWS() {
		return strItemnameComboValuesWS;
	}
	/**
	 * @param strItemnameComboValuesWS the strItemnameComboValuesWS to set
	 */
	public void setStrItemnameComboValuesWS(WebRowSet strItemnameComboValuesWS) {
		this.strItemnameComboValuesWS = strItemnameComboValuesWS;
	}
	/**
	 * @return the strBrandNameComboValuesWS
	 */
	public WebRowSet getStrBrandNameComboValuesWS() {
		return strBrandNameComboValuesWS;
	}
	/**
	 * @param strBrandNameComboValuesWS the strBrandNameComboValuesWS to set
	 */
	public void setStrBrandNameComboValuesWS(WebRowSet strBrandNameComboValuesWS) {
		this.strBrandNameComboValuesWS = strBrandNameComboValuesWS;
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
	 * @return the strFinancialStartyear
	 */
	public String getStrFinancialStartyear() {
		return strFinancialStartyear;
	}
	/**
	 * @param strFinancialStartyear the strFinancialStartyear to set
	 */
	public void setStrFinancialStartyear(String strFinancialStartyear) {
		this.strFinancialStartyear = strFinancialStartyear;
	}
	/**
	 * @return the strFinancialEndYear
	 */
	public String getStrFinancialEndYear() {
		return strFinancialEndYear;
	}
	/**
	 * @param strFinancialEndYear the strFinancialEndYear to set
	 */
	public void setStrFinancialEndYear(String strFinancialEndYear) {
		this.strFinancialEndYear = strFinancialEndYear;
	}
	/**
	 * @return the strBatchSlNo
	 */
	public String getStrBatchSlNo() {
		return strBatchSlNo;
	}
	/**
	 * @param strBatchSlNo the strBatchSlNo to set
	 */
	public void setStrBatchSlNo(String strBatchSlNo) {
		this.strBatchSlNo = strBatchSlNo;
	}
	
}
