package mms.transactions.vo;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

public class CostEstimationVO 
{
	private static final long serialVersionUID = 02L;
	private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
    private String strMsgString = "";
	private String strMsgType = "";
	private String strItemCatCmb="";
	private String strItemCategoryName="";
	private WebRowSet strItemCategoryComboWS=null;
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strGroupId = "";
	private String strCtDate = "";
	/************Variable Start Here******************/
	private String strBkgEntryDate ="";
	private String strStoreName = "";
	private String strFrmStoreId = "";
	private String strToStoreId = "";
	private String strToStoreName = "";
	private WebRowSet GroupWs  =null;
	private String strStoreTypeId = "";
	private String strGroupIdForItemSearch = "";
	private String[] itemParamValue = {""};
	private String[] itemUserValue = {""};
	private String[] itemCalcValue = {""};
	private String[] strBkgQty ={""};
	private String[] strUnitName={""};
	private String strRemarks = "";   
	private String strTransferDate = ""; 
	private String[] strTransferQty = {""};
	private String[] strTransferCost = {""};
	private String strReceiveBy = ""; 
	private String strNetCost = "0"; 
	private String strFinancialStartYear = "";
    private String strFinancialEndYear = "";
    private String strTransferNo;
    private String strDwhName;
    private WebRowSet transferDtlWs  =null;

    
    private WebRowSet recievedByWS=null;
	
	
	
	public WebRowSet getRecievedByWS() {
		return recievedByWS;
	}

	public void setRecievedByWS(WebRowSet recievedByWS) {
		this.recievedByWS = recievedByWS;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	public String[] getStrBkgQty() {
		return strBkgQty;
	}

	public void setStrBkgQty(String[] strBkgQty) {
		this.strBkgQty = strBkgQty;
	}

	public String[] getStrUnitName() {
		return strUnitName;
	}

	public void setStrUnitName(String[] strUnitName) {
		this.strUnitName = strUnitName;
	}

	public String[] getItemParamValue() {
		return itemParamValue;
	}

	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
	}

	public String getStrGroupIdForItemSearch() {
		return strGroupIdForItemSearch;
	}

	public void setStrGroupIdForItemSearch(String strGroupIdForItemSearch) {
		this.strGroupIdForItemSearch = strGroupIdForItemSearch;
	}

	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}

	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}

	public String getStrBkgEntryDate() {
		return strBkgEntryDate;
	}

	public void setStrBkgEntryDate(String strBkgEntryDate) {
		this.strBkgEntryDate = strBkgEntryDate;
	}

	/**********Current Date*************/
	public String getStrCtDate() 
	{
		HisUtil util = new HisUtil("Breakge Item Detail Transaction", "BreakgeItemDtlTransVO");
		try {
			strCtDate = util.getASDate("dd-MMM-yyyy");
			util = null;
		} catch (Exception e) {
			new HisException("MMS Module", "Breakge Item Detail Transaction",
					"BreakgeItemDtlTransVO.getStrCtDate()-->" + e.getMessage());
		}
		return strCtDate;

	}
	
	public String getStrErr() {
		return strErr;
	}
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}
	public String getStrMsg() {
		return strMsg;
	}
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}
	public String getStrWarning() {
		return strWarning;
	}
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
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
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrGroupId() {
		return strGroupId;
	}
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	public String getStrStoreName() {
		return strStoreName;
	}

	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}

	public String getStrSeatId() {
		return strSeatId;
	}

	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	public WebRowSet getGroupWs() {
		return GroupWs;
	}

	public void setGroupWs(WebRowSet groupWs) {
		GroupWs = groupWs;
	}

	public String getStrFinancialStartYear() {
		return strFinancialStartYear;
	}

	public void setStrFinancialStartYear(String strFinancialStartYear) {
		this.strFinancialStartYear = strFinancialStartYear;
	}

	public String getStrFinancialEndYear() {
		return strFinancialEndYear;
	}

	public void setStrFinancialEndYear(String strFinancialEndYear) {
		this.strFinancialEndYear = strFinancialEndYear;
	}

	

	public String getStrItemCategoryName() {
		return strItemCategoryName;
	}

	public void setStrItemCategoryName(String strItemCategoryName) {
		this.strItemCategoryName = strItemCategoryName;
	}

	public WebRowSet getStrItemCategoryComboWS() {
		return strItemCategoryComboWS;
	}

	public void setStrItemCategoryComboWS(WebRowSet strItemCategoryComboWS) {
		this.strItemCategoryComboWS = strItemCategoryComboWS;
	}

	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}

	public String getStrToStoreName() {
		return strToStoreName;
	}

	public void setStrToStoreName(String strToStoreName) {
		this.strToStoreName = strToStoreName;
	}

	public String getStrFrmStoreId() {
		return strFrmStoreId;
	}

	public void setStrFrmStoreId(String strFrmStoreId) {
		this.strFrmStoreId = strFrmStoreId;
	}

	public String getStrToStoreId() {
		return strToStoreId;
	}

	public void setStrToStoreId(String strToStoreId) {
		this.strToStoreId = strToStoreId;
	}

	public String getStrTransferDate() {
		return strTransferDate;
	}

	public void setStrTransferDate(String strTransferDate) {
		this.strTransferDate = strTransferDate;
	}

	public String getStrReceiveBy() {
		return strReceiveBy;
	}

	public void setStrReceiveBy(String strReceiveBy) {
		this.strReceiveBy = strReceiveBy;
	}

	public String getStrNetCost() {
		return strNetCost;
	}

	public void setStrNetCost(String strNetCost) {
		this.strNetCost = strNetCost;
	}

	public String[] getStrTransferQty() {
		return strTransferQty;
	}

	public void setStrTransferQty(String[] strTransferQty) {
		this.strTransferQty = strTransferQty;
	}

	public String getStrItemCatCmb() {
		return strItemCatCmb;
	}

	public void setStrItemCatCmb(String strItemCatCmb) {
		this.strItemCatCmb = strItemCatCmb;
	}

	public String[] getItemUserValue() {
		return itemUserValue;
	}

	public String[] getItemCalcValue() {
		return itemCalcValue;
	}

	public void setItemUserValue(String[] itemUserValue) {
		this.itemUserValue = itemUserValue;
	}

	public void setItemCalcValue(String[] itemCalcValue) {
		this.itemCalcValue = itemCalcValue;
	}

	public String[] getStrTransferCost() {
		return strTransferCost;
	}

	public void setStrTransferCost(String[] strTransferCost) {
		this.strTransferCost = strTransferCost;
	}

	public String getStrTransferNo() {
		return strTransferNo;
	}

	public void setStrTransferNo(String strTransferNo) {
		this.strTransferNo = strTransferNo;
	}

	public WebRowSet getTransferDtlWs() {
		return transferDtlWs;
	}

	public void setTransferDtlWs(WebRowSet transferDtlWs) {
		this.transferDtlWs = transferDtlWs;
	}

	public String getStrDwhName() {
		return strDwhName;
	}

	public void setStrDwhName(String strDwhName) {
		this.strDwhName = strDwhName;
	}

	
}



