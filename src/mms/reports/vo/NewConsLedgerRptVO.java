package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

public class NewConsLedgerRptVO {

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
	
	private String strItemBrandId;
	private String strMode;
	
private String strStoreName="";
	
	private String strItemName="";
	private String strItemBrandName="";

//	private String strFromDate = "";
//	private String strToDate = "";
	private String strBatchNo="";
	private WebRowSet reportDataWS=null;
	private WebRowSet fYearWS=null;
	private String strYear="";
	private String strMonth="";
	
	public WebRowSet getReportDataWS() {
		return reportDataWS;
	}
	public void setReportDataWS(WebRowSet reportDataWS) {
		this.reportDataWS = reportDataWS;
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
//	public String getStrFromDate() {
//		return strFromDate;
//	}
//	public void setStrFromDate(String strFromDate) {
//		this.strFromDate = strFromDate;
//	}
//	public String getStrToDate() {
//		return strToDate;
//	}
//	public void setStrToDate(String strToDate) {
//		this.strToDate = strToDate;
//	}
	public String getStrBatchNo() {
		return strBatchNo;
	}
	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
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
	
	public WebRowSet getStrFYCmbWS() {
		// TODO Auto-generated method stub
		return fYearWS;
	}
	
	public void setStrFYCmbWS(WebRowSet fYearWS) {
		// TODO Auto-generated method stub
		this.fYearWS=fYearWS;
	}
	public String getStrMonth() {
		return strMonth;
	}
	public void setStrMonth(String strMonth) {
		this.strMonth = strMonth;
	}
	public String getStrYear() {
		return strYear;
	}
	public void setStrYear(String strYear) {
		this.strYear = strYear;
	}
	
}
