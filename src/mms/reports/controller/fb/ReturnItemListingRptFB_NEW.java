/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         IssueDetailRptFB.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.controller.fb;

import org.apache.struts.action.ActionForm;

// TODO: Auto-generated Javadoc
/**
 * The Class IssueDetailRptFB.
 */
public class ReturnItemListingRptFB_NEW extends ActionForm {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The str normal msg. */
	private String strNormalMsg = "";

	/** The str err msg. */
	private String strErrMsg = "";

	/** The str warning msg. */
	private String strWarningMsg = "";

	/** The str hosp code. */
	private String strHospCode = "";

	/** The str store id. */
	private String strStoreId = "";

	/** The str batchh no. */
	private String strBatchhNo = "1";

	/** The str current date. */
	private String strCurrentDate = "";

	/** The str store val. */
	private String strStoreVal = "";

	/** The str item categ no. */
	private String strItemCategNo = "";

	/** The str report format. */
	private String strReportFormat = "0";

	/** The str report id. */
	private String strReportId = "";

	/** The str is footer. */
	private String strIsFooter = "";

	/** The str user remarks. */
	private String strUserRemarks = "";

	/** The str from date. */
	private String strFromDate = "";

	/** The str to date. */
	private String strToDate = "";

	/** The str case. */
	private String strCase = "1";

	/** The str item categ cmb. */
	private String strItemCategCmb = "";

	/** The str item brand id. */
	private String strItemBrandId;

	/** The str batch no. */
	private String strBatchNo;

	/** The str prog id. */
	private String strProgId;

	/**
	 * Gets the str prog id.
	 * 
	 * @return the str prog id
	 */
	private String strItemCatId;
	
	private String strIsMisc;
	
	private String strIsQuant;
	
	private String strStoreCmb = "";
	
	public String getStrStoreCmb() {
		return strStoreCmb;
	}

	public void setStrStoreCmb(String strStoreCmb) {
		this.strStoreCmb = strStoreCmb;
	}

	public String getStrIsMisc() {
		return strIsMisc;
	}

	public void setStrIsMisc(String strIsMisc) {
		this.strIsMisc = strIsMisc;
	}

	public String getStrIsQuant() {
		return strIsQuant;
	}

	public void setStrIsQuant(String strIsQuant) {
		this.strIsQuant = strIsQuant;
	}

	public String getStrItemCatId() {
		return strItemCatId;
	}

	public void setStrItemCatId(String strItemCatId) {
		this.strItemCatId = strItemCatId;
	}

	public String getStrProgId() {
		return strProgId;
	}

	/**
	 * Sets the str prog id.
	 * 
	 * @param strProgId
	 *            the new str prog id
	 */
	public void setStrProgId(String strProgId) {
		this.strProgId = strProgId;
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

	/**
	 * Gets the str batch no.
	 * 
	 * @return the str batch no
	 */
	public String getStrBatchNo() {
		return strBatchNo;
	}

	/**
	 * Sets the str batch no.
	 * 
	 * @param strBatchNo
	 *            the new str batch no
	 */
	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}

	/**
	 * Gets the str case.
	 * 
	 * @return the strCase
	 */
	public String getStrCase() {
		return strCase;
	}

	/**
	 * Sets the str case.
	 * 
	 * @param strCase
	 *            the strCase to set
	 */
	public void setStrCase(String strCase) {
		this.strCase = strCase;
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
	 * Gets the str store val.
	 * 
	 * @return the str store val
	 */
	public String getStrStoreVal() {
		return strStoreVal;
	}

	/**
	 * Sets the str store val.
	 * 
	 * @param strStoreVal
	 *            the new str store val
	 */
	public void setStrStoreVal(String strStoreVal) {
		this.strStoreVal = strStoreVal;
	}

	/**
	 * Gets the str current date.
	 * 
	 * @return the str current date
	 */
	public String getStrCurrentDate() {
		return strCurrentDate;
	}

	/**
	 * Sets the str current date.
	 * 
	 * @param strCurrentDate
	 *            the new str current date
	 */
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}

	/**
	 * Gets the str normal msg.
	 * 
	 * @return the str normal msg
	 */
	public String getStrNormalMsg() {
		return strNormalMsg;
	}

	/**
	 * Sets the str normal msg.
	 * 
	 * @param strNormalMsg
	 *            the new str normal msg
	 */
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}

	/**
	 * Gets the str err msg.
	 * 
	 * @return the str err msg
	 */
	public String getStrErrMsg() {
		return strErrMsg;
	}

	/**
	 * Sets the str err msg.
	 * 
	 * @param strErrMsg
	 *            the new str err msg
	 */
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}

	/**
	 * Gets the str hosp code.
	 * 
	 * @return the str hosp code
	 */
	public String getStrHospCode() {
		return strHospCode;
	}

	/**
	 * Sets the str hosp code.
	 * 
	 * @param strHospCode
	 *            the new str hosp code
	 */
	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
	}

	/**
	 * Gets the str store id.
	 * 
	 * @return the str store id
	 */
	public String getStrStoreId() {
		return strStoreId;
	}

	/**
	 * Sets the str store id.
	 * 
	 * @param strStoreId
	 *            the new str store id
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	/**
	 * Gets the str batchh no.
	 * 
	 * @return the str batchh no
	 */
	public String getStrBatchhNo() {
		return strBatchhNo;
	}

	/**
	 * Sets the str batchh no.
	 * 
	 * @param strBatchhNo
	 *            the new str batchh no
	 */
	public void setStrBatchhNo(String strBatchhNo) {
		this.strBatchhNo = strBatchhNo;
	}

	/**
	 * Gets the str warning msg.
	 * 
	 * @return the str warning msg
	 */
	public String getStrWarningMsg() {
		return strWarningMsg;
	}

	/**
	 * Sets the str warning msg.
	 * 
	 * @param strWarningMsg
	 *            the new str warning msg
	 */
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
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
	 * Gets the str item categ no.
	 * 
	 * @return the strItemCategNo
	 */
	public String getStrItemCategNo() {
		return strItemCategNo;
	}

	/**
	 * Sets the str item categ no.
	 * 
	 * @param strItemCategNo
	 *            the strItemCategNo to set
	 */
	public void setStrItemCategNo(String strItemCategNo) {
		this.strItemCategNo = strItemCategNo;
	}

	/**
	 * Gets the str item categ cmb.
	 * 
	 * @return the str item categ cmb
	 */
	public String getStrItemCategCmb() {
		return strItemCategCmb;
	}

	/**
	 * Sets the str item categ cmb.
	 * 
	 * @param strItemCategCmb
	 *            the new str item categ cmb
	 */
	public void setStrItemCategCmb(String strItemCategCmb) {
		this.strItemCategCmb = strItemCategCmb;
	}

}
