package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

public class PendingIndentStatusRecordRptVO {
	
	private String strMode;
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String strMsgType = "";
	private String strMsgString = "";
	

	private String strItemCatId = "";	
	/* ==Added== */
	private String strUserRemarks = "";	
	/* ==Added== */
	private String strCategoryName ="";
	
	private WebRowSet strItemCatWs = null;
	private WebRowSet strReqTypeWs = null;
	
	private WebRowSet strPartialIssueWs = null;
	private WebRowSet strIssueWs = null;
	private WebRowSet strNotIssueWs = null;


	
	/* ==Added== */
	private WebRowSet WsIssueDtlRpt = null;
	
	private String strItemCatNo = "";
	private String strStoreId = "";
	private String strStoreName = "";
	private String strCurrentDate = "";
	private String strFromDate = "";
	private String strToDate = "";
	private String strReqTypeId = "";
	private String strStoreValues = "";
	private String strReqTypeNo="";
	private String strRptType="";

	public WebRowSet getWsIssueDtlRpt() {
		return WsIssueDtlRpt;
	}
	public void setWsIssueDtlRpt(WebRowSet wsIssueDtlRpt) {
		WsIssueDtlRpt = wsIssueDtlRpt;
	}
	
	public String getStrCategoryName() {
		return strCategoryName;
	}
	public void setStrCategoryName(String strCategoryName) {
		this.strCategoryName = strCategoryName;
	}
	public WebRowSet getStrPartialIssueWs() {
		return strPartialIssueWs;
	}
	
	public String getStrUserRemarks() {
		return strUserRemarks;
	}
	public void setStrUserRemarks(String strUserRemarks) {
		this.strUserRemarks = strUserRemarks;
	}
	
	public void setStrPartialIssueWs(WebRowSet strPartialIssueWs) {
		this.strPartialIssueWs = strPartialIssueWs;
	}
	public String getStrItemCatNo() {
		return strItemCatNo;
	}
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
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
	public String getStrReqTypeId() {
		return strReqTypeId;
	}
	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}
	public String getStrStoreValues() {
		return strStoreValues;
	}
	public void setStrStoreValues(String strStoreValues) {
		this.strStoreValues = strStoreValues;
	}
	public String getStrReqTypeNo() {
		return strReqTypeNo;
	}
	public void setStrReqTypeNo(String strReqTypeNo) {
		this.strReqTypeNo = strReqTypeNo;
	}
	public String getStrRptType() {
		return strRptType;
	}
	public WebRowSet getStrIssueWs() {
		return strIssueWs;
	}
	public void setStrIssueWs(WebRowSet strIssueWs) {
		this.strIssueWs = strIssueWs;
	}
	public WebRowSet getStrNotIssueWs() {
		return strNotIssueWs;
	}
	public void setStrNotIssueWs(WebRowSet strNotIssueWs) {
		this.strNotIssueWs = strNotIssueWs;
	}
	public void setStrRptType(String strRptType) {
		this.strRptType = strRptType;
	}
	public WebRowSet getStrReqTypeWs() {
		return strReqTypeWs;
	}
	public void setStrReqTypeWs(WebRowSet strReqTypeWs) {
		this.strReqTypeWs = strReqTypeWs;
	}
	private WebRowSet strStoreWs = null;
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
	 * @return the strStoreId
	 */
	public String getStrStoreId() {
		return strStoreId;
	}
	/**
	 * @param strStoreId the strStoreId to set
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	/**
	 * @return the strItemCatId
	 */
	public String getStrItemCatId() {
		return strItemCatId;
	}
	/**
	 * @param strItemCatId the strItemCatId to set
	 */
	public void setStrItemCatId(String strItemCatId) {
		this.strItemCatId = strItemCatId;
	}
	/**
	 * @return the strItemCatWs
	 */
	public WebRowSet getStrItemCatWs() {
		return strItemCatWs;
	}
	/**
	 * @param strItemCatWs the strItemCatWs to set
	 */
	public void setStrItemCatWs(WebRowSet strItemCatWs) {
		this.strItemCatWs = strItemCatWs;
	}
	/**
	 * @return the strStoreWs
	 */
	public WebRowSet getStrStoreWs() {
		return strStoreWs;
	}
	/**
	 * @param strStoreWs the strStoreWs to set
	 */
	public void setStrStoreWs(WebRowSet strStoreWs) {
		this.strStoreWs = strStoreWs;
	}
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}

}
