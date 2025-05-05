package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;

public class WarrentyDetailsTransFB extends ActionForm {
	private static final long serialVersionUID = 02L;
	
	private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
	
	private String strCtDate = "";
	
	
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
	
	private String strManufacturerNameComboValues="";
	private String strItemCategoryComboValues="";
	private String strGroupNameComboValues="";
	private String strSubGroupNameComboValues="";
	private String strItemnameComboValues="";
	private String strBrandNameComboValues="";
	
	
	/**
	 * @return the strManufacturerNameComboValues
	 */
	public String getStrManufacturerNameComboValues() {
		return strManufacturerNameComboValues;
	}
	/**
	 * @param strManufacturerNameComboValues the strManufacturerNameComboValues to set
	 */
	public void setStrManufacturerNameComboValues(
			String strManufacturerNameComboValues) {
		this.strManufacturerNameComboValues = strManufacturerNameComboValues;
	}
	/**
	 * @return the strItemCategoryComboValues
	 */
	public String getStrItemCategoryComboValues() {
		return strItemCategoryComboValues;
	}
	/**
	 * @param strItemCategoryComboValues the strItemCategoryComboValues to set
	 */
	public void setStrItemCategoryComboValues(String strItemCategoryComboValues) {
		this.strItemCategoryComboValues = strItemCategoryComboValues;
	}
	/**
	 * @return the strGroupNameComboValues
	 */
	public String getStrGroupNameComboValues() {
		return strGroupNameComboValues;
	}
	/**
	 * @param strGroupNameComboValues the strGroupNameComboValues to set
	 */
	public void setStrGroupNameComboValues(String strGroupNameComboValues) {
		this.strGroupNameComboValues = strGroupNameComboValues;
	}
	/**
	 * @return the strSubGroupNameComboValues
	 */
	public String getStrSubGroupNameComboValues() {
		return strSubGroupNameComboValues;
	}
	/**
	 * @param strSubGroupNameComboValues the strSubGroupNameComboValues to set
	 */
	public void setStrSubGroupNameComboValues(String strSubGroupNameComboValues) {
		this.strSubGroupNameComboValues = strSubGroupNameComboValues;
	}
	/**
	 * @return the strItemnameComboValues
	 */
	public String getStrItemnameComboValues() {
		return strItemnameComboValues;
	}
	/**
	 * @param strItemnameComboValues the strItemnameComboValues to set
	 */
	public void setStrItemnameComboValues(String strItemnameComboValues) {
		this.strItemnameComboValues = strItemnameComboValues;
	}
	/**
	 * @return the strBrandNameComboValues
	 */
	public String getStrBrandNameComboValues() {
		return strBrandNameComboValues;
	}
	/**
	 * @param strBrandNameComboValues the strBrandNameComboValues to set
	 */
	public void setStrBrandNameComboValues(String strBrandNameComboValues) {
		this.strBrandNameComboValues = strBrandNameComboValues;
	}
	/**
	 * @return the strErr
	 */
	public String getStrErr() {
		return strErr;
	}
	/**
	 * @param strErr the strErr to set
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}
	/**
	 * @return the strMsg
	 */
	public String getStrMsg() {
		return strMsg;
	}
	/**
	 * @param strMsg the strMsg to set
	 */
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}
	/**
	 * @return the strWarning
	 */
	public String getStrWarning() {
		return strWarning;
	}
	/**
	 * @param strWarning the strWarning to set
	 */
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
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
	 * @return the strCtDate
	 */
	public String getStrCtDate() {
		return strCtDate;
	}
	/**
	 * @param strCtDate the strCtDate to set
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
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
