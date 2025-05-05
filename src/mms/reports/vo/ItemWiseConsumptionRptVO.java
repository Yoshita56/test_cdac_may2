package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

/**
 * Developer : Tanvi Sappal
 * Version : 1.0 Date : 17/July/2009
 * Module : MMS 
 */

public class ItemWiseConsumptionRptVO {
	
	private static final long serialVersionUID = 1L;
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String strIsFooter = "";
	private String strUserRemarks = "";
	private String strReportFormat = "0";
	private String strReportId = "";
	
	private String strMsgString = "";
	private String strMsgType = "";
	
	private String strItemCategoryNo = "";
	private String strGroupId = "";
	private String strSubGroupId = "";
	private String strItemId = "";
	private String strFromDate = "";
	private String strToDate = "";
	private String strFromYear = "";
	private String strToYear = "";
	private String strCtDate = "";
	private String strDateYear = "";
	private WebRowSet strHospitalWs=null;
	
	
	private WebRowSet itemCategoryWS = null;
	private WebRowSet groupIdWS = null;
	private WebRowSet subGroupIdWS = null;
	private WebRowSet itemIdWS = null;
	private WebRowSet reportDataWS = null;
	public WebRowSet getReportDataWS() {
		return reportDataWS;
	}
	public void setReportDataWS(WebRowSet reportDataWS) {
		this.reportDataWS = reportDataWS;
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
	 * @return the strGroupId
	 */
	public String getStrGroupId() {
		return strGroupId;
	}
	/**
	 * @param strGroupId the strGroupId to set
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}
	/**
	 * @return the strSubGroupId
	 */
	public String getStrSubGroupId() {
		return strSubGroupId;
	}
	/**
	 * @param strSubGroupId the strSubGroupId to set
	 */
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}
	/**
	 * @return the strItemId
	 */
	public String getStrItemId() {
		return strItemId;
	}
	/**
	 * @param strItemId the strItemId to set
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
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
	/**
	 * @return the groupIdWS
	 */
	public WebRowSet getGroupIdWS() {
		return groupIdWS;
	}
	/**
	 * @param groupIdWS the groupIdWS to set
	 */
	public void setGroupIdWS(WebRowSet groupIdWS) {
		this.groupIdWS = groupIdWS;
	}
	/**
	 * @return the subGroupIdWS
	 */
	public WebRowSet getSubGroupIdWS() {
		return subGroupIdWS;
	}
	/**
	 * @param subGroupIdWS the subGroupIdWS to set
	 */
	public void setSubGroupIdWS(WebRowSet subGroupIdWS) {
		this.subGroupIdWS = subGroupIdWS;
	}
	/**
	 * @return the itemIdWS
	 */
	public WebRowSet getItemIdWS() {
		return itemIdWS;
	}
	/**
	 * @param itemIdWS the itemIdWS to set
	 */
	public void setItemIdWS(WebRowSet itemIdWS) {
		this.itemIdWS = itemIdWS;
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
	 * @return the strFromYear
	 */
	public String getStrFromYear() {
		return strFromYear;
	}
	/**
	 * @param strFromYear the strFromYear to set
	 */
	public void setStrFromYear(String strFromYear) {
		this.strFromYear = strFromYear;
	}
	/**
	 * @return the strToYear
	 */
	public String getStrToYear() {
		return strToYear;
	}
	/**
	 * @param strToYear the strToYear to set
	 */
	public void setStrToYear(String strToYear) {
		this.strToYear = strToYear;
	}
	/**
	 * @return the strDateYear
	 */
	public String getStrDateYear() {
		return strDateYear;
	}
	/**
	 * @param strDateYear the strDateYear to set
	 */
	public void setStrDateYear(String strDateYear) {
		this.strDateYear = strDateYear;
	}
	public WebRowSet getStrHospitalWs() {
		return strHospitalWs;
	}
	public void setStrHospitalWs(WebRowSet strHospitalWs) {
		this.strHospitalWs = strHospitalWs;
	}

}
