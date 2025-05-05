package mms.transactions.controller.fb;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import org.apache.struts.action.ActionForm;

public class CostEstimationFB extends ActionForm 
{
	private static final long serialVersionUID = 02L;
	private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
    private String strMsgString = "";
	private String strMsgType = "";
	private String strErrMsg = "";
	private String strItemCatCmb="";
	private String strItemCategoryName="";
	private String strItemCategoryCombo=null;
	private String strHospitalCode = "";
	private String strGroupId = "";
	private String strCtDate = "";
	private String strSeatId = "";
	private String strMultiRowHeader = "";
	private String strMultiRowFormat = "";
	/************Variable Start Here******************/
	private String strBkgEntryDate ="";
	private String strStoreName = "";
	private String strFrmStoreId = "";
	private String strToStoreId = "";
	private String strToStoreName = "";
	private String strCostRequired="";
	private WebRowSet GroupWs  =null;
	private String strStoreTypeId = "";
	private String strGroupIdForItemSearch = "";
	private String[] itemParamValue = {""};
	private String[] itemUserValue = {""};
	private String[] itemCalcValue = {""};
	private String[] strBkgQty ={""};
	private String[] strUnitName={""};
	private String strTransferDate = ""; 
	private String[] strTransferQty = {""};
	private String[] strTransferCost = {""};
	private String strReceiveBy = ""; 
	private String strNetCost = "0"; 
	private String strRemarks = "";
	private String strFinancialStartYear = "";
	private String strReceivedByOptionVal="";

     private String strFinancialEndYear = "";
     private String strReOrderFlgColor;
     private String strViewChk;
     private String strTransferNo;
     private String strTmpStoreId;
     
    
     private String strTmpTransferNo="0";
     private String strTmpStoreName;
     private String strTmpTransferDate;
     private String strTmpStoreNo;
     private String strDwhName;
        
	
	public String getStrDwhName() {
		return strDwhName;
	}

	public void setStrDwhName(String strDwhName) {
		this.strDwhName = strDwhName;
	}

	public String getStrTmpStoreNo() {
		return strTmpStoreNo;
	}

	public void setStrTmpStoreNo(String strTmpStoreNo) {
		this.strTmpStoreNo = strTmpStoreNo;
	}

	public String getStrTmpStoreId() {
		return strTmpStoreId;
	}

	public void setStrTmpStoreId(String strTmpStoreId) {
		this.strTmpStoreId = strTmpStoreId;
	}

	public String getStrTransferNo() {
		return strTransferNo;
	}

	public void setStrTransferNo(String strTransferNo) {
		this.strTransferNo = strTransferNo;
	}

	public String getStrViewChk() {
		return strViewChk;
	}

	public void setStrViewChk(String strViewChk) {
		this.strViewChk = strViewChk;
	}

	public String getStrReOrderFlgColor() {
		return strReOrderFlgColor;
	}

	public void setStrReOrderFlgColor(String strReOrderFlgColor) {
		this.strReOrderFlgColor = strReOrderFlgColor;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
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

	public WebRowSet getGroupWs() {
		return GroupWs;
	}

	public void setGroupWs(WebRowSet groupWs) {
		GroupWs = groupWs;
	}

	public String getStrStoreName() {
		return strStoreName;
	}

	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
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
		HisUtil util = new HisUtil("Cost Estimation", "CostEstimationFB");
		try {
			strCtDate = util.getASDate("dd-MMM-yyyy H:mm:ss");
			util = null;
		} catch (Exception e) {
			new HisException("MMS Module", "Cost Estimation",
					"CostEstimationFB.getStrCtDate()-->" + e.getMessage());
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

	public String[] getItemParamValue() {
		return itemParamValue;
	}

	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
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

	public String getStrItemCategoryCombo() {
		return strItemCategoryCombo;
	}

	public void setStrItemCategoryCombo(String strItemCategoryCombo) {
		this.strItemCategoryCombo = strItemCategoryCombo;
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

	public String getStrMultiRowHeader() {
		return strMultiRowHeader;
	}

	public void setStrMultiRowHeader(String strMultiRowHeader) {
		this.strMultiRowHeader = strMultiRowHeader;
	}

	public String getStrMultiRowFormat() {
		return strMultiRowFormat;
	}

	public void setStrMultiRowFormat(String strMultiRowFormat) {
		this.strMultiRowFormat = strMultiRowFormat;
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

	public String getStrReceivedByOptionVal() {
		return strReceivedByOptionVal;
	}

	public void setStrReceivedByOptionVal(String strReceivedByOptionVal) {
		this.strReceivedByOptionVal = strReceivedByOptionVal;
	}

	/**
	 * @return the strCostRequired
	 */
	public String getStrCostRequired() {
		return strCostRequired;
	}

	/**
	 * @param strCostRequired the strCostRequired to set
	 */
	public void setStrCostRequired(String strCostRequired) {
		this.strCostRequired = strCostRequired;
	}

	public String getStrTmpTransferNo() {
		return strTmpTransferNo;
	}

	public void setStrTmpTransferNo(String strTmpTransferNo) {
		this.strTmpTransferNo = strTmpTransferNo;
	}

	public String getStrTmpStoreName() {
		return strTmpStoreName;
	}

	public void setStrTmpStoreName(String strTmpStoreName) {
		this.strTmpStoreName = strTmpStoreName;
	}

	public String getStrTmpTransferDate() {
		return strTmpTransferDate;
	}

	public void setStrTmpTransferDate(String strTmpTransferDate) {
		this.strTmpTransferDate = strTmpTransferDate;
	}

	
}
