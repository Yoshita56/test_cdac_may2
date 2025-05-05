package mms.reports.controller.fb;

import org.apache.struts.action.ActionForm;

public class FinancialEndYearRptFB extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String strErrMsg = "";
	private String strNormalMsg = "";
	private String strWarningMsg = "";
	
	private String strReportId = "";
	private String strUserRemarks = "";
	private String strReportFormat = "";
	private String strIsFooter = "";
	
	private String strItemCatNo = "";
	private String strStoreId = "";
	private String strStoreName = "";
	private String strStoreValues = "";
	private String strCurrentDate = "";
	private String strFromFinYear = "";
	private String strToFinYear = "";
	private String strBatchNo = "0";
	private String strCurrentFinancialYear="";
	private String strNextFinancialYear="";
	private String strIndentPeriodValue="";
	
	public String getStrIndentPeriodValue() {
		return strIndentPeriodValue;
	}
	public void setStrIndentPeriodValue(String strIndentPeriodValue) {
		this.strIndentPeriodValue = strIndentPeriodValue;
	}
	public String getStrCurrentFinancialYear() {
		return strCurrentFinancialYear;
	}
	public void setStrCurrentFinancialYear(String strCurrentFinancialYear) {
		this.strCurrentFinancialYear = strCurrentFinancialYear;
	}
	public String getStrNextFinancialYear() {
		return strNextFinancialYear;
	}
	public void setStrNextFinancialYear(String strNextFinancialYear) {
		this.strNextFinancialYear = strNextFinancialYear;
	}
	public String getStrBatchNo() {
		return strBatchNo;
	}
	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}
	public String getStrStoreValues() {
		return strStoreValues;
	}
	public void setStrStoreValues(String strStoreValues) {
		this.strStoreValues = strStoreValues;
	}
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String getStrErrMsg() {
		return strErrMsg;
	}
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}
	public String getStrNormalMsg() {
		return strNormalMsg;
	}
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}
	public String getStrWarningMsg() {
		return strWarningMsg;
	}
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}
	public String getStrReportId() {
		return strReportId;
	}
	public void setStrReportId(String strReportId) {
		this.strReportId = strReportId;
	}
	public String getStrUserRemarks() {
		return strUserRemarks;
	}
	public void setStrUserRemarks(String strUserRemarks) {
		this.strUserRemarks = strUserRemarks;
	}
	public String getStrReportFormat() {
		return strReportFormat;
	}
	public void setStrReportFormat(String strReportFormat) {
		this.strReportFormat = strReportFormat;
	}
	public String getStrIsFooter() {
		return strIsFooter;
	}
	public void setStrIsFooter(String strIsFooter) {
		this.strIsFooter = strIsFooter;
	}
	public String getStrItemCatNo() {
		return strItemCatNo;
	}
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public String getStrFromFinYear() {
		return strFromFinYear;
	}
	public void setStrFromFinYear(String strFromFinYear) {
		this.strFromFinYear = strFromFinYear;
	}
	public String getStrToFinYear() {
		return strToFinYear;
	}
	public void setStrToFinYear(String strToFinYear) {
		this.strToFinYear = strToFinYear;
	}

}
