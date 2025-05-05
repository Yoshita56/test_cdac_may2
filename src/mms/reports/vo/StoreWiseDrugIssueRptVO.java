package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

public class StoreWiseDrugIssueRptVO {
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
	private String strItemCategCmb = "";
	private String strHospNameValues="";
	
	private String strItemBrandId;
	private String strBatchNo;
	private String userComboString;
	private String userId;
	private String strHospCode="";
	private String strStoreId="";
	private String strItemId="";
	private String IssueChkDetail="1";
	private String strBatchhNo="1";
	private String strMsgType="0";
	private String strMsgString="";
	private String strSeatId="";
	private String strCategoryNo;
	private WebRowSet strHospitalWs=null;
	private WebRowSet strWS=null;
	private WebRowSet itemCategWS=null;
	private WebRowSet strItemNameComboWS=null;
	private WebRowSet strExistingBatchComboWS=null;
	private String strHospitalCode="";
	private String strStoreName="";
	
	private String strItemName="";
	private String strItemBrandName="";
	private String strMode;
	private String strSearchType="1";
	
	private WebRowSet reportDataWS=null;
	
	public String getStrSearchType() {
		return strSearchType;
	}
	public void setStrSearchType(String strSearchType) {
		this.strSearchType = strSearchType;
	}
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public String getStrItemName() {
		return strItemName;
	}
	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}
	public String getStrItemBrandName() {
		return strItemBrandName;
	}
	public void setStrItemBrandName(String strItemBrandName) {
		this.strItemBrandName = strItemBrandName;
	}
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}
	public String getStrStoreVal() {
		return strStoreVal;
	}
	public void setStrStoreVal(String strStoreVal) {
		this.strStoreVal = strStoreVal;
	}
	public String getStrItemCategNo() {
		return strItemCategNo;
	}
	public void setStrItemCategNo(String strItemCategNo) {
		this.strItemCategNo = strItemCategNo;
	}
	public String getStrReportFormat() {
		return strReportFormat;
	}
	public void setStrReportFormat(String strReportFormat) {
		this.strReportFormat = strReportFormat;
	}
	public String getStrReportId() {
		return strReportId;
	}
	public void setStrReportId(String strReportId) {
		this.strReportId = strReportId;
	}
	public String getStrIsFooter() {
		return strIsFooter;
	}
	public void setStrIsFooter(String strIsFooter) {
		this.strIsFooter = strIsFooter;
	}
	public String getStrUserRemarks() {
		return strUserRemarks;
	}
	public void setStrUserRemarks(String strUserRemarks) {
		this.strUserRemarks = strUserRemarks;
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
	public String getStrCase() {
		return strCase;
	}
	public void setStrCase(String strCase) {
		this.strCase = strCase;
	}
	public String getStrItemCategCmb() {
		return strItemCategCmb;
	}
	public void setStrItemCategCmb(String strItemCategCmb) {
		this.strItemCategCmb = strItemCategCmb;
	}
	public String getStrHospNameValues() {
		return strHospNameValues;
	}
	public void setStrHospNameValues(String strHospNameValues) {
		this.strHospNameValues = strHospNameValues;
	}
	public String getStrBatchNo() {
		return strBatchNo;
	}
	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}
	public String getUserComboString() {
		return userComboString;
	}
	public void setUserComboString(String userComboString) {
		this.userComboString = userComboString;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public WebRowSet getReportDataWS() {
		return reportDataWS;
	}
	public void setReportDataWS(WebRowSet reportDataWS) {
		this.reportDataWS = reportDataWS;
	}
	public String getStrItemBrandId() {
		return strItemBrandId;
	}
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}
	public WebRowSet getStrWS() {
		return strWS;
	}
	public void setStrWS(WebRowSet strWS) {
		this.strWS = strWS;
	}
	public String getStrMsgString() {
		return strMsgString;
	}
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}
	public String getStrMsgType() {
		return strMsgType;
	}
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
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
	public String getStrItemId() {
		return strItemId;
	}
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}
	public String getStrBatchhNo() {
		return strBatchhNo;
	}
	public void setStrBatchhNo(String strBatchhNo) {
		this.strBatchhNo = strBatchhNo;
	}
	public String getIssueChkDetail() {
		return IssueChkDetail;
	}
	public void setIssueChkDetail(String issueChkDetail) {
		IssueChkDetail = issueChkDetail;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public WebRowSet getItemCategWS() {
		return itemCategWS;
	}
	public void setItemCategWS(WebRowSet itemCategWS) {
		this.itemCategWS = itemCategWS;
	}
	public String getStrCategoryNo() {
		return strCategoryNo;
	}
	public void setStrCategoryNo(String strCategoryNo) {
		this.strCategoryNo = strCategoryNo;
	}
	public WebRowSet getStrItemNameComboWS() {
		return strItemNameComboWS;
	}
	public void setStrItemNameComboWS(WebRowSet strItemNameComboWS) {
		this.strItemNameComboWS = strItemNameComboWS;
	}
	public WebRowSet getStrExistingBatchComboWS() {
		return strExistingBatchComboWS;
	}
	public void setStrExistingBatchComboWS(WebRowSet strExistingBatchComboWS) {
		this.strExistingBatchComboWS = strExistingBatchComboWS;
	}
	public WebRowSet getStrHospitalWs() {
		return strHospitalWs;
	}
	public void setStrHospitalWs(WebRowSet strHospitalWs) {
		this.strHospitalWs = strHospitalWs;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
}
