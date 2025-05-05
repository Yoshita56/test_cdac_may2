/**
 * 
 */
package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

/**
 * Developer:Anshul Jindal
 * Creation Date: 17-07-2009 Modifying Date:-
 * Used For:-MMS Reports
 * Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class SamplesSummaryListRptVO {
	

	private String strIsFooter = "";
	private String strUserRemarks = "";
	private String strReportFormat = "0";
	private String strReportId = "";
	
	private String strMsgString = "";
	private String strMsgType = "";
	
	private String strSeatId = "";
	private String strHospitalCode = "";
	private String strCurrentDate = "";
	
	private String strCategoryNo = "";
	private String strTenderNo = "";
	
	private WebRowSet TenderNoComboWS = null;
	private WebRowSet CategoryComboWS = null;
	private WebRowSet SupplierComboWS = null;
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
	 * @return the tenderNoComboWS
	 */
	public WebRowSet getTenderNoComboWS() {
		return TenderNoComboWS;
	}
	/**
	 * @param tenderNoComboWS the tenderNoComboWS to set
	 */
	public void setTenderNoComboWS(WebRowSet tenderNoComboWS) {
		TenderNoComboWS = tenderNoComboWS;
	}
	/**
	 * @return the categoryComboWS
	 */
	public WebRowSet getCategoryComboWS() {
		return CategoryComboWS;
	}
	/**
	 * @param categoryComboWS the categoryComboWS to set
	 */
	public void setCategoryComboWS(WebRowSet categoryComboWS) {
		CategoryComboWS = categoryComboWS;
	}
	/**
	 * @return the supplierComboWS
	 */
	public WebRowSet getSupplierComboWS() {
		return SupplierComboWS;
	}
	/**
	 * @param supplierComboWS the supplierComboWS to set
	 */
	public void setSupplierComboWS(WebRowSet supplierComboWS) {
		SupplierComboWS = supplierComboWS;
	}

}
