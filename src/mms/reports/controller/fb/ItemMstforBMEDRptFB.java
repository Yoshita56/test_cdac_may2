package mms.reports.controller.fb;

import org.apache.struts.action.ActionForm;

public class ItemMstforBMEDRptFB extends ActionForm {
	private static final long serialVersionUID = 02L;
	
	private String strNormalMsg="";
	private String strErrMsg="";
	private String strWarningMsg="";
	private String strHospCode="";
	private String strStoreId="";
	private String strBatchhNo="1";
	private String strCurrentDate="";
	private String strStoreVal="";
	private String strItemCategNo = "";
	private String strReportFormat = "0";
	private String strReportId = "";
	private String strIsFooter = "";
	private String strUserRemarks = "";
	private String strFromDate = "";
	private String strToDate = "";
	private String strCase = "1";
	private String strReportType;
	private String isdossier="0";
	
	private String strByCurrentAndDate;
	
	private String strConsolidatedOrDetailed;
	private String strStoreName;

	
	private String strItemVal;
	
	private String strWhetherBatchRequiredCheckBox;
	private String strOnlyIssueDetailRequiredCheckBox;
	private String strReportName;
	private String strPrintDtls;
	private String strItemBrandId;
	
	
	

	public String getStrItemBrandId() {
		return strItemBrandId;
	}

	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}

	public String getStrPrintDtls() {
		return strPrintDtls;
	}

	public void setStrPrintDtls(String strPrintDtls) {
		this.strPrintDtls = strPrintDtls;
	}

	public String getStrReportName() {
		return strReportName;
	}

	public void setStrReportName(String strReportName) {
		this.strReportName = strReportName;
	}

	public String getStrWhetherBatchRequiredCheckBox() {
		return strWhetherBatchRequiredCheckBox;
	}

	public void setStrWhetherBatchRequiredCheckBox(
			String strWhetherBatchRequiredCheckBox) {
		this.strWhetherBatchRequiredCheckBox = strWhetherBatchRequiredCheckBox;
	}

	public String getStrOnlyIssueDetailRequiredCheckBox() {
		return strOnlyIssueDetailRequiredCheckBox;
	}

	public void setStrOnlyIssueDetailRequiredCheckBox(
			String strOnlyIssueDetailRequiredCheckBox) {
		this.strOnlyIssueDetailRequiredCheckBox = strOnlyIssueDetailRequiredCheckBox;
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

	public String getStrStoreVal() {
		return strStoreVal;
	}

	public void setStrStoreVal(String strStoreVal) {
		this.strStoreVal = strStoreVal;
	}

	public String getStrCurrentDate() {
		return strCurrentDate;
	}

	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}

	public String getStrNormalMsg() {
		return strNormalMsg;
	}

	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}

	public String getStrErrMsg() {
		return strErrMsg;
	}

	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}

	public String getStrHospCode() {
		return strHospCode;
	}

	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
	}

	public String getStrStoreId() {
		return strStoreId;
	}

	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}


	public String getStrBatchhNo() {
		return strBatchhNo;
	}

	public void setStrBatchhNo(String strBatchhNo) {
		this.strBatchhNo = strBatchhNo;
	}

	public String getStrWarningMsg() {
		return strWarningMsg;
	}

	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
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
	 * @return the strItemCategNo
	 */
	public String getStrItemCategNo() {
		return strItemCategNo;
	}

	/**
	 * @param strItemCategNo the strItemCategNo to set
	 */
	public void setStrItemCategNo(String strItemCategNo) {
		this.strItemCategNo = strItemCategNo;
	}

	public String getStrConsolidatedOrDetailed() {
		return strConsolidatedOrDetailed;
	}

	public void setStrConsolidatedOrDetailed(String strConsolidatedOrDetailed) {
		this.strConsolidatedOrDetailed = strConsolidatedOrDetailed;
	}

	public String getStrItemVal() {
		return strItemVal;
	}

	public void setStrItemVal(String strItemVal) {
		this.strItemVal = strItemVal;
	}

	public String getStrReportType() {
		return strReportType;
	}

	public void setStrReportType(String strReportType) {
		this.strReportType = strReportType;
	}

	public String getStrStoreName() {
		return strStoreName;
	}

	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}

	public String getStrByCurrentAndDate() {
		return strByCurrentAndDate;
	}

	public void setStrByCurrentAndDate(String strByCurrentAndDate) {
		this.strByCurrentAndDate = strByCurrentAndDate;
	}

	public String getIsdossier() {
		return isdossier;
	}

	public void setIsdossier(String isdossier) {
		this.isdossier = isdossier;
	}

}
