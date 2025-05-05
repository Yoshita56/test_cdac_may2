/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         StockLedgerForSubStoresRptFB.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.controller.fb;

import org.apache.struts.action.ActionForm;

// TODO: Auto-generated Javadoc
/**
 * The Class StockLedgerForSubStoresRptFB.
 */
public class StockLedgerForSubStoresRptFB extends ActionForm {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The str hospital code. */
	private String strHospitalCode = "";

	/** The str seat id. */
	private String strSeatId = "";

	/** The str err msg. */
	private String strErrMsg = "";

	/** The str normal msg. */
	private String strNormalMsg = "";

	/** The str warning msg. */
	private String strWarningMsg = "";

	/** The str report id. */
	private String strReportId = "";

	/** The str user remarks. */
	private String strUserRemarks = "";

	/** The str report format. */
	private String strReportFormat = "";

	/** The str is footer. */
	private String strIsFooter = "";

	/** The str item cat no. */
	private String strItemCatNo = "";

	/** The str store id. */
	private String strStoreId = "";

	/** The str item id. */
	private String strItemId = "";

	/** The str group id. */
	private String strGroupId = "";

	/** The str store name. */
	private String strStoreName = "";

	/** The str drug name. */
	private String strDrugName = "";

	/** The str current date. */
	private String strCurrentDate = "";

	/** The str from date. */
	private String strFromDate = "";

	/** The str to date. */
	private String strToDate = "";

	/** The str item values. */
	private String strItemValues = "";

	/** The str store values. */
	private String strStoreValues = "";

	/** The str whether batch wise. */
	private String strWhetherBatchWise;

	/** The str stock ledger pop up. */
	private String strStockLedgerPopUp;

	/** The str stock ledger details. */
	private String strStockLedgerDetails;

	/** The str item type values. */
	private String strItemTypeValues;

	/** The str left item ids. */
	private String[] strLeftItemIds = null;

	/** The str left item list. */
	private String strLeftItemList = "";

	/** The str right item ids. */
	private String[] strRightItemIds = null;

	/** The str right item list. */
	private String strRightItemList = "";

	/** The str item type. */
	private String strItemType;

	/** The str item brand id. */
	private String strItemBrandId = "0";

	/** The str group combo. */
	private String strGroupCombo;
	private String strSectionName="",strSectionId="";

	public String getStrSectionName() {
		return strSectionName;
	}

	public void setStrSectionName(String strSectionName) {
		this.strSectionName = strSectionName;
	}

	public String getStrSectionId() {
		return strSectionId;
	}

	public void setStrSectionId(String strSectionId) {
		this.strSectionId = strSectionId;
	}

	/** The str html code. */
	private String strHtmlCode = "";

	/**
	 * Gets the str html code.
	 * 
	 * @return the str html code
	 */
	public String getStrHtmlCode() {
		return strHtmlCode;
	}

	/**
	 * Sets the str html code.
	 * 
	 * @param strHtmlCode
	 *            the new str html code
	 */
	public void setStrHtmlCode(String strHtmlCode) {
		this.strHtmlCode = strHtmlCode;
	}

	/**
	 * Gets the str group combo.
	 * 
	 * @return the str group combo
	 */
	public String getStrGroupCombo() {
		return strGroupCombo;
	}

	/**
	 * Sets the str group combo.
	 * 
	 * @param strGroupCombo
	 *            the new str group combo
	 */
	public void setStrGroupCombo(String strGroupCombo) {
		this.strGroupCombo = strGroupCombo;
	}

	/**
	 * Gets the str stock ledger details.
	 * 
	 * @return the str stock ledger details
	 */
	public String getStrStockLedgerDetails() {
		return strStockLedgerDetails;
	}

	/**
	 * Sets the str stock ledger details.
	 * 
	 * @param strStockLedgerDetails
	 *            the new str stock ledger details
	 */
	public void setStrStockLedgerDetails(String strStockLedgerDetails) {
		this.strStockLedgerDetails = strStockLedgerDetails;
	}

	/**
	 * Gets the str stock ledger pop up.
	 * 
	 * @return the str stock ledger pop up
	 */
	public String getStrStockLedgerPopUp() {
		return strStockLedgerPopUp;
	}

	/**
	 * Sets the str stock ledger pop up.
	 * 
	 * @param strStockLedgerPopUp
	 *            the new str stock ledger pop up
	 */
	public void setStrStockLedgerPopUp(String strStockLedgerPopUp) {
		this.strStockLedgerPopUp = strStockLedgerPopUp;
	}

	/**
	 * Gets the str store values.
	 * 
	 * @return the strStoreValues
	 */
	public String getStrStoreValues() {
		return strStoreValues;
	}

	/**
	 * Sets the str store values.
	 * 
	 * @param strStoreValues
	 *            the strStoreValues to set
	 */
	public void setStrStoreValues(String strStoreValues) {
		this.strStoreValues = strStoreValues;
	}

	/**
	 * Gets the str hospital code.
	 * 
	 * @return the strHospitalCode
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	/**
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode
	 *            the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Gets the str seat id.
	 * 
	 * @return the strSeatId
	 */
	public String getStrSeatId() {
		return strSeatId;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param strSeatId
	 *            the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * Gets the str err msg.
	 * 
	 * @return the strErrMsg
	 */
	public String getStrErrMsg() {
		return strErrMsg;
	}

	/**
	 * Sets the str err msg.
	 * 
	 * @param strErrMsg
	 *            the strErrMsg to set
	 */
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}

	/**
	 * Gets the str normal msg.
	 * 
	 * @return the strNormalMsg
	 */
	public String getStrNormalMsg() {
		return strNormalMsg;
	}

	/**
	 * Sets the str normal msg.
	 * 
	 * @param strNormalMsg
	 *            the strNormalMsg to set
	 */
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}

	/**
	 * Gets the str warning msg.
	 * 
	 * @return the strWarningMsg
	 */
	public String getStrWarningMsg() {
		return strWarningMsg;
	}

	/**
	 * Sets the str warning msg.
	 * 
	 * @param strWarningMsg
	 *            the strWarningMsg to set
	 */
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}

	/**
	 * Gets the str report id.
	 * 
	 * @return the strReportId
	 */
	public String getStrReportId() {
		return strReportId;
	}

	/**
	 * Sets the str report id.
	 * 
	 * @param strReportId
	 *            the strReportId to set
	 */
	public void setStrReportId(String strReportId) {
		this.strReportId = strReportId;
	}

	/**
	 * Gets the str user remarks.
	 * 
	 * @return the strUserRemarks
	 */
	public String getStrUserRemarks() {
		return strUserRemarks;
	}

	/**
	 * Sets the str user remarks.
	 * 
	 * @param strUserRemarks
	 *            the strUserRemarks to set
	 */
	public void setStrUserRemarks(String strUserRemarks) {
		this.strUserRemarks = strUserRemarks;
	}

	/**
	 * Gets the str report format.
	 * 
	 * @return the strReportFormat
	 */
	public String getStrReportFormat() {
		return strReportFormat;
	}

	/**
	 * Sets the str report format.
	 * 
	 * @param strReportFormat
	 *            the strReportFormat to set
	 */
	public void setStrReportFormat(String strReportFormat) {
		this.strReportFormat = strReportFormat;
	}

	/**
	 * Gets the str is footer.
	 * 
	 * @return the strIsFooter
	 */
	public String getStrIsFooter() {
		return strIsFooter;
	}

	/**
	 * Sets the str is footer.
	 * 
	 * @param strIsFooter
	 *            the strIsFooter to set
	 */
	public void setStrIsFooter(String strIsFooter) {
		this.strIsFooter = strIsFooter;
	}

	/**
	 * Gets the str item cat no.
	 * 
	 * @return the strItemCatNo
	 */
	public String getStrItemCatNo() {
		return strItemCatNo;
	}

	/**
	 * Sets the str item cat no.
	 * 
	 * @param strItemCatNo
	 *            the strItemCatNo to set
	 */
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}

	/**
	 * Gets the str store id.
	 * 
	 * @return the strStoreId
	 */
	public String getStrStoreId() {
		return strStoreId;
	}

	/**
	 * Sets the str store id.
	 * 
	 * @param strStoreId
	 *            the strStoreId to set
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	/**
	 * Gets the str store name.
	 * 
	 * @return the strStoreName
	 */
	public String getStrStoreName() {
		return strStoreName;
	}

	/**
	 * Sets the str store name.
	 * 
	 * @param strStoreName
	 *            the strStoreName to set
	 */
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}

	/**
	 * Gets the str current date.
	 * 
	 * @return the strCurrentDate
	 */
	public String getStrCurrentDate() {
		return strCurrentDate;
	}

	/**
	 * Sets the str current date.
	 * 
	 * @param strCurrentDate
	 *            the strCurrentDate to set
	 */
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}

	/**
	 * Gets the str from date.
	 * 
	 * @return the strFromDate
	 */
	public String getStrFromDate() {
		return strFromDate;
	}

	/**
	 * Sets the str from date.
	 * 
	 * @param strFromDate
	 *            the strFromDate to set
	 */
	public void setStrFromDate(String strFromDate) {
		this.strFromDate = strFromDate;
	}

	/**
	 * Gets the str to date.
	 * 
	 * @return the strToDate
	 */
	public String getStrToDate() {
		return strToDate;
	}

	/**
	 * Sets the str to date.
	 * 
	 * @param strToDate
	 *            the strToDate to set
	 */
	public void setStrToDate(String strToDate) {
		this.strToDate = strToDate;
	}

	/**
	 * Gets the str item id.
	 * 
	 * @return the str item id
	 */
	public String getStrItemId() {
		return strItemId;
	}

	/**
	 * Sets the str item id.
	 * 
	 * @param strItemId
	 *            the new str item id
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}

	/**
	 * Gets the str group id.
	 * 
	 * @return the str group id
	 */
	public String getStrGroupId() {
		return strGroupId;
	}

	/**
	 * Sets the str group id.
	 * 
	 * @param strGroupId
	 *            the new str group id
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	/**
	 * Gets the str item values.
	 * 
	 * @return the str item values
	 */
	public String getStrItemValues() {
		return strItemValues;
	}

	/**
	 * Sets the str item values.
	 * 
	 * @param strItemValues
	 *            the new str item values
	 */
	public void setStrItemValues(String strItemValues) {
		this.strItemValues = strItemValues;
	}

	/**
	 * Gets the str whether batch wise.
	 * 
	 * @return the str whether batch wise
	 */
	public String getStrWhetherBatchWise() {
		return strWhetherBatchWise;
	}

	/**
	 * Sets the str whether batch wise.
	 * 
	 * @param strWhetherBatchWise
	 *            the new str whether batch wise
	 */
	public void setStrWhetherBatchWise(String strWhetherBatchWise) {
		this.strWhetherBatchWise = strWhetherBatchWise;
	}

	/**
	 * Gets the str drug name.
	 * 
	 * @return the str drug name
	 */
	public String getStrDrugName() {
		return strDrugName;
	}

	/**
	 * Sets the str drug name.
	 * 
	 * @param strDrugName
	 *            the new str drug name
	 */
	public void setStrDrugName(String strDrugName) {
		this.strDrugName = strDrugName;
	}

	/**
	 * Gets the str item type values.
	 * 
	 * @return the str item type values
	 */
	public String getStrItemTypeValues() {
		return strItemTypeValues;
	}

	/**
	 * Sets the str item type values.
	 * 
	 * @param strItemTypeValues
	 *            the new str item type values
	 */
	public void setStrItemTypeValues(String strItemTypeValues) {
		this.strItemTypeValues = strItemTypeValues;
	}

	/**
	 * Gets the str left item ids.
	 * 
	 * @return the str left item ids
	 */
	public String[] getStrLeftItemIds() {
		return strLeftItemIds;
	}

	/**
	 * Sets the str left item ids.
	 * 
	 * @param strLeftItemIds
	 *            the new str left item ids
	 */
	public void setStrLeftItemIds(String[] strLeftItemIds) {
		this.strLeftItemIds = strLeftItemIds;
	}

	/**
	 * Gets the str left item list.
	 * 
	 * @return the str left item list
	 */
	public String getStrLeftItemList() {
		return strLeftItemList;
	}

	/**
	 * Sets the str left item list.
	 * 
	 * @param strLeftItemList
	 *            the new str left item list
	 */
	public void setStrLeftItemList(String strLeftItemList) {
		this.strLeftItemList = strLeftItemList;
	}

	/**
	 * Gets the str right item ids.
	 * 
	 * @return the str right item ids
	 */
	public String[] getStrRightItemIds() {
		return strRightItemIds;
	}

	/**
	 * Sets the str right item ids.
	 * 
	 * @param strRightItemIds
	 *            the new str right item ids
	 */
	public void setStrRightItemIds(String[] strRightItemIds) {
		this.strRightItemIds = strRightItemIds;
	}

	/**
	 * Gets the str right item list.
	 * 
	 * @return the str right item list
	 */
	public String getStrRightItemList() {
		return strRightItemList;
	}

	/**
	 * Sets the str right item list.
	 * 
	 * @param strRightItemList
	 *            the new str right item list
	 */
	public void setStrRightItemList(String strRightItemList) {
		this.strRightItemList = strRightItemList;
	}

	/**
	 * Gets the str item type.
	 * 
	 * @return the str item type
	 */
	public String getStrItemType() {
		return strItemType;
	}

	/**
	 * Sets the str item type.
	 * 
	 * @param strItemType
	 *            the new str item type
	 */
	public void setStrItemType(String strItemType) {
		this.strItemType = strItemType;
	}

	/**
	 * Gets the str item brand id.
	 * 
	 * @return the str item brand id
	 */
	public String getStrItemBrandId() {
		return strItemBrandId;
	}

	/**
	 * Sets the str item brand id.
	 * 
	 * @param strItemBrandId
	 *            the new str item brand id
	 */
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}

}
