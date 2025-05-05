/**
 * 
 */
package mms.reports.controller.fb;

import org.apache.struts.action.ActionForm;

/**
 * Developer:Anshul Jindal
 * Creation Date: 17-07-2009 Modifying Date:-
 * Used For:-MMS Reports
 * Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class SamplesSummaryListRptFB extends ActionForm {

	private static final long serialVersionUID = 1L;

	private String strErrMsg = "";
	private String strWarningMsg = "";
	private String strNormalMsg = "";

	private String strIsFooter = "";
	private String strUserRemarks = "";
	private String strReportFormat = "0";
	private String strReportId = "";
	
	private String strSeatId = "";
	private String strHospitalCode = "";
	private String strCurrentDate = "";
	
	private String strCategoryValues = "";
	private String strSuupplierNameValues = "";
	private String strTenderNoValues = "";
	
	private String strCategoryNo = "";
	private String strTenderNo = "";
	private String strSupplierId = "";
	private String strCase = "1";
	
	private String strFromDate = "";
	private String strToDate = "";
	
	/**
	 * @return the strErrMsg
	 */
	public String getStrErrMsg() {
		return strErrMsg;
	}
	/**
	 * @param strErrMsg the strErrMsg to set
	 */
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}
	/**
	 * @return the strWarningMsg
	 */
	public String getStrWarningMsg() {
		return strWarningMsg;
	}
	/**
	 * @param strWarningMsg the strWarningMsg to set
	 */
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}
	/**
	 * @return the strNormalMsg
	 */
	public String getStrNormalMsg() {
		return strNormalMsg;
	}
	/**
	 * @param strNormalMsg the strNormalMsg to set
	 */
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
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
	 * @return the strCurrentDate
	 */
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	/**
	 * @param strCurrentDate the strCurrentDate to set
	 */
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}
	/**
	 * @return the strCategoryValues
	 */
	public String getStrCategoryValues() {
		return strCategoryValues;
	}
	/**
	 * @param strCategoryValues the strCategoryValues to set
	 */
	public void setStrCategoryValues(String strCategoryValues) {
		this.strCategoryValues = strCategoryValues;
	}
	
	/**
	 * @return the strCategoryNo
	 */
	public String getStrCategoryNo() {
		return strCategoryNo;
	}
	/**
	 * @param strCategoryNo the strCategoryNo to set
	 */
	public void setStrCategoryNo(String strCategoryNo) {
		this.strCategoryNo = strCategoryNo;
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
	 * @return the strCase
	 */
	public String getStrCase() {
		return strCase;
	}
	/**
	 * @param strCase the strCase to set
	 */
	public void setStrCase(String strCase) {
		this.strCase = strCase;
	}
	/**
	 * @return the strSuupplierNameValues
	 */
	public String getStrSuupplierNameValues() {
		return strSuupplierNameValues;
	}
	/**
	 * @param strSuupplierNameValues the strSuupplierNameValues to set
	 */
	public void setStrSuupplierNameValues(String strSuupplierNameValues) {
		this.strSuupplierNameValues = strSuupplierNameValues;
	}
	/**
	 * @return the strTenderNoValues
	 */
	public String getStrTenderNoValues() {
		return strTenderNoValues;
	}
	/**
	 * @param strTenderNoValues the strTenderNoValues to set
	 */
	public void setStrTenderNoValues(String strTenderNoValues) {
		this.strTenderNoValues = strTenderNoValues;
	}
	/**
	 * @return the strSupplierId
	 */
	public String getStrSupplierId() {
		return strSupplierId;
	}
	/**
	 * @param strSupplierId the strSupplierId to set
	 */
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
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

}
