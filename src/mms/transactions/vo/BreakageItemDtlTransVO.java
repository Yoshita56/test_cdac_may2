package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

public class BreakageItemDtlTransVO 
{
	private static final long serialVersionUID = 02L;
	private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
    private String strMsgString = "";
	private String strMsgType = "";

	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strGroupId = "";
	private String strCtDate = "";
	/************Variable Start Here******************/
	private String strItemCatNo="";
	private String strItemCatgCombo = "";
	private String strStoreId = "";
	private String strBkgEntryDate ="";
	private String strStoreName = "";
	private WebRowSet GroupWs  =null;
	private WebRowSet breakageItemWS  =null;
	private String strStoreTypeId = "";
	private String strGroupIdForItemSearch = "";
	private String[] strCostFinal=null;
	private String strApproxAmt="";
	private String[] itemParamValue = {""};
	private String[] strBkgQty ={""};
	private String[] strUnitName={""};
	private String strRemarks = ""; 
	private String strFinancialStartYear = "";
	
	private String strApprovedBy="";
	private String strAprovedRemarks="";
    private String strApprovedDate="";

    private String strFinancialEndYear = "";
	
    private String strFromDate;
    private String strToDate;
    private String strBreakageMode;
    
	public String getStrBreakageMode() {
		return strBreakageMode;
	}

	public void setStrBreakageMode(String strBreakageMode) {
		this.strBreakageMode = strBreakageMode;
	}

	private WebRowSet approvedByWS=null; 
	private String strTypeMode;
	public String getStrTypeMode() {
		return strTypeMode;
	}

	public void setStrTypeMode(String strTypeMode) {
		this.strTypeMode = strTypeMode;
	}
	
	public WebRowSet getApprovedByWS() {
		return approvedByWS;
	}

	public void setApprovedByWS(WebRowSet approvedByWS) {
		this.approvedByWS = approvedByWS;
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

	public String getStrItemCatgCombo() {
		return strItemCatgCombo;
	}

	public void setStrItemCatgCombo(String strItemCatgCombo) {
		this.strItemCatgCombo = strItemCatgCombo;
	}

	public String getStrStoreId() {
		return strStoreId;
	}

	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	public String getStrItemCatNo() {
		return strItemCatNo;
	}

	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}

	public String getStrApprovedBy() {
		return strApprovedBy;
	}

	public void setStrApprovedBy(String strApprovedBy) {
		this.strApprovedBy = strApprovedBy;
	}

	public String getStrAprovedRemarks() {
		return strAprovedRemarks;
	}

	public void setStrAprovedRemarks(String strAprovedRemarks) {
		this.strAprovedRemarks = strAprovedRemarks;
	}

	public String getStrApprovedDate() {
		return strApprovedDate;
	}

	public void setStrApprovedDate(String strApprovedDate) {
		this.strApprovedDate = strApprovedDate;
	}

	public WebRowSet getBreakageItemWS() {
		return breakageItemWS;
	}

	public void setBreakageItemWS(WebRowSet breakageItemWS) {
		this.breakageItemWS = breakageItemWS;
	}

	public String[] getStrCostFinal() {
		return strCostFinal;
	}

	public void setStrCostFinal(String[] strCostFinal) {
		this.strCostFinal = strCostFinal;
	}

	public String getStrApproxAmt() {
		return strApproxAmt;
	}

	public void setStrApproxAmt(String strApproxAmt) {
		this.strApproxAmt = strApproxAmt;
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
}



