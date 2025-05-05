package mms.reports.vo;

import java.util.Stack;

import javax.sql.rowset.WebRowSet;

public class IssueTrackRptVO {
	
	private String strMode;
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String strMsgType = "";
	private String strMsgString = "";
	
	private String strStoreId = "";
	private String strDrugWarehouseTypeId = "";

	private WebRowSet strDrugWarehouseTypeWs = null;
	private WebRowSet strStoreWs = null;
	
	private WebRowSet strItemCatWs = null;
	private WebRowSet strDistrictStoreWs = null;
	private WebRowSet WsBreakageDtlRpt = null;

	private WebRowSet strIndentDetailsWs = null;
	
	private String strStartDate = "";
	private String strEndDate = "";

	private String strStoreName = "";
	private String strCategoryName = "";
	
	private String strItemCategoryName = "";

	private String strItemCategoryId="";
	private String strReqStoreId="0";
	
	private String strIndentNo="";
	private String strIndentDate="";
	private String strRaisingStoreName="";
	private String strIssueNo="";
	
	private String strIndentStoreName="";
	private String strReceivedBy="";
	private String strIssuedBy="";
	private String strItemBrandId="";
	private String strCategoryCode="";
	private String strBatchNo="";
	private String strItemId="";
	
	private String strIssueStatus = "";
	private String strItemName = ""; 
	
	private WebRowSet ItemCurrStockWS = null;
	
	public WebRowSet getItemCurrStockWS() {
		return ItemCurrStockWS;
	}

	public void setItemCurrStockWS(WebRowSet itemCurrStockWS) {
		ItemCurrStockWS = itemCurrStockWS;
	}

	public String getStrItemName() {
		return strItemName;
	}

	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}

	public String getStrIssueStatus() {
		return strIssueStatus;
	}

	public void setStrIssueStatus(String strIssueStatus) {
		this.strIssueStatus = strIssueStatus;
	}

	public String getStrItemId() {
		return strItemId;
	}

	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}

	public String getStrItemBrandId() {
		return strItemBrandId;
	}

	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}

	public String getStrCategoryCode() {
		return strCategoryCode;
	}

	public void setStrCategoryCode(String strCategoryCode) {
		this.strCategoryCode = strCategoryCode;
	}

	public String getStrBatchNo() {
		return strBatchNo;
	}

	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}

	private Stack<String> backPages = new Stack<>();
	
	public void pushBackPages(String backPage) {
		this.backPages.push(backPage);
	}
	
	public String popBackPages() {
		if(this.backPages.empty()) {
			return null;
		}
		else {
			return this.backPages.pop();			
		}
	}
	
	public String peekBackPages() {
		if(this.backPages.empty()) {
			return null;
		}
		else {
			return this.backPages.peek();			
		}
	}
	
	public String getStrReceivedBy() {
		return strReceivedBy;
	}
	public void setStrReceivedBy(String strReceivedBy) {
		this.strReceivedBy = strReceivedBy;
	}
	public String getStrIssuedBy() {
		return strIssuedBy;
	}
	public void setStrIssuedBy(String strIssuedBy) {
		this.strIssuedBy = strIssuedBy;
	}
	public String getStrIndentStoreName() {
		return strIndentStoreName;
	}
	public void setStrIndentStoreName(String strIndentStoreName) {
		this.strIndentStoreName = strIndentStoreName;
	}
	public Stack<String> getBackPages() {
		return backPages;
	}
	public void setBackPages(Stack<String> backPages) {
		this.backPages = backPages;
	}

	private WebRowSet ItemDetailsWS = null;
	
	
	public WebRowSet getItemDetailsWS() {
		return ItemDetailsWS;
	}

	public void setItemDetailsWS(WebRowSet itemDetailsWS) {
		ItemDetailsWS = itemDetailsWS;
	}

	//	public WebRowSet getItemDetailsWS() {
//		return ItemDetailsWS;
//	}
//	public void setItemDetailsWS(WebRowSet itemDetailsWS) {
//		ItemDetailsWS = itemDetailsWS;
//	}
	public String getStrIssueNo() {
		return strIssueNo;
	}
	public void setStrIssueNo(String strIssueNo) {
		this.strIssueNo = strIssueNo;
	}
	public String getStrIndentNo() {
		return strIndentNo;
	}
	public void setStrIndentNo(String strIndentNo) {
		this.strIndentNo = strIndentNo;
	}
	public String getStrIndentDate() {
		return strIndentDate;
	}
	public void setStrIndentDate(String strIndentDate) {
		this.strIndentDate = strIndentDate;
	}
	public String getStrRaisingStoreName() {
		return strRaisingStoreName;
	}
	public void setStrRaisingStoreName(String strRaisingStoreName) {
		this.strRaisingStoreName = strRaisingStoreName;
	}
	public String getStrReqStoreId() {
		return strReqStoreId;
	}
	public void setStrReqStoreId(String strReqStoreId) {
		this.strReqStoreId = strReqStoreId;
	}
	
	private String strCmodeId="0";

	
	public String getStrCmodeId() {
		return strCmodeId;
	}
	public void setStrCmodeId(String strCmodeId) {
		this.strCmodeId = strCmodeId;
	}

	private WebRowSet wsItemCategoryCombo = null;

	private String strLogoName ="";

	public WebRowSet getStrIndentDetailsWs() {
		return strIndentDetailsWs;
	}
	public void setStrIndentDetailsWs(WebRowSet strIndentDetailsWs) {
		this.strIndentDetailsWs = strIndentDetailsWs;
	}
	
	public String getStrLogoName() {
		return strLogoName;
	}
	public void setStrLogoName(String strLogoName) {
		this.strLogoName = strLogoName;
	}

	
	public String getStrItemCategoryName() {
		return strItemCategoryName;
	}
	public void setStrItemCategoryName(String strItemCategoryName) {
		this.strItemCategoryName = strItemCategoryName;
	}
	
	public WebRowSet getWsItemCategoryCombo() {
		return wsItemCategoryCombo;
	}
	public void setWsItemCategoryCombo(WebRowSet wsItemCategoryCombo) {
		this.wsItemCategoryCombo = wsItemCategoryCombo;
	}

	public String getStrItemCategoryId() {
		return strItemCategoryId;
	}
	public void setStrItemCategoryId(String strItemCategoryId) {
		this.strItemCategoryId = strItemCategoryId;
	}
	public String getStrStartDate() {
		return strStartDate;
	}
	
	public void setStrStartDate(String strStartDate) {
		this.strStartDate = strStartDate;
	}
	
	public String getStrEndDate() {
		return strEndDate;
	}
	
	public void setStrEndDate(String strEndDate) {
		this.strEndDate = strEndDate;
	}

	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}


	public void setStrCategoryName(String strCategoryName) {
		this.strCategoryName = strCategoryName;
	}
	public String getStrCategoryName() {
		return strCategoryName;
	}
	/*<--*/
	
	public WebRowSet getWsBreakageDtlRpt() {
		return WsBreakageDtlRpt;
	}
	public void setWsBreakageDtlRpt(WebRowSet wsBreakageDtlRpt) {
		WsBreakageDtlRpt = wsBreakageDtlRpt;
	}
	public WebRowSet getStrItemCatWs() {
		return strItemCatWs;
	}
	public void setStrItemCatWs(WebRowSet strItemCatWs) {
		this.strItemCatWs = strItemCatWs;
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
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public WebRowSet getStrStoreWs() {
		return strStoreWs;
	}
	public void setStrStoreWs(WebRowSet strStoreWs) {
		this.strStoreWs = strStoreWs;
	}
	public String getStrDrugWarehouseTypeId() {
		return strDrugWarehouseTypeId;
	}
	public void setStrDrugWarehouseTypeId(String strDrugWarehouseTypeId) {
		this.strDrugWarehouseTypeId = strDrugWarehouseTypeId;
	}
	public WebRowSet getStrDrugWarehouseTypeWs() {
		return strDrugWarehouseTypeWs;
	}
	public void setStrDrugWarehouseTypeWs(WebRowSet strDrugWarehouseTypeWs) {
		this.strDrugWarehouseTypeWs = strDrugWarehouseTypeWs;
	}
	public WebRowSet getStrDistrictStoreWs() {
		return strDistrictStoreWs;
	}
	public void setStrDistrictStoreWs(WebRowSet strDistrictStoreWs) {
		this.strDistrictStoreWs = strDistrictStoreWs;
	}
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}
	

}

