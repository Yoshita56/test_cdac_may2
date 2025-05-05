package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 09/Apr/2009
 * Modif Date : / /2009 
*/
public class BudgetAllocationDetailProcessTransVO 
{
	private static final long serialVersionUID = 02L;
	
	private String strMode;
	
	private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
    private String strMsgString = "";
	private String strMsgType = "0";
	private String strErrMsg = "";

	private String strHospitalCode = "";
	private String strCtDate = "";
	private String strSeatId = "";

	private String strDrugWareHouseName;
	private String strDrugWareHouseNameCmb;
	
	private WebRowSet wrsDrugWareHouseNameCmb;
	
	
	private String strFinancialYear;
	private String strFinancialYearCmb;
	
	private String strFinancialStartDate;
	private String strFinancialEndDate;
	private String strSlNo;
	
	private String strAllocDate;
	private String strNewAllocatedBudget;
	private String strRemarks;
	private String strIsValid;
	private String strEntryDate;
	
	private String strBudgetAllot;
	private String strBudgetUsed;
	private String strPreviousYearRemainingBudget;
	private String strStoreId;
	private String strStoreSubType;
	
	private WebRowSet wrsFinancialYearCmb;
	
	private WebRowSet wrsData;
	private WebRowSet wrsDWHSubTypeCmb;
	private WebRowSet wrsDWHSubStoreCmb;
	
	private String strDWHSubTypeId;
	private String strDWHSubTypeCmb;
	private String strDWHSubStoreTypeCmb;
	private String strSubStoreId;
	
	
	public String getStrDWHSubTypeId() {
		return strDWHSubTypeId;
	}
	public void setStrDWHSubTypeId(String strDWHSubTypeId) {
		this.strDWHSubTypeId = strDWHSubTypeId;
	}
	public String getStrDWHSubTypeCmb() {
		return strDWHSubTypeCmb;
	}
	public void setStrDWHSubTypeCmb(String strDWHSubTypeCmb) {
		this.strDWHSubTypeCmb = strDWHSubTypeCmb;
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
	public String getStrErrMsg() {
		return strErrMsg;
	}
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrCtDate() {
		return strCtDate;
	}
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String getStrDrugWareHouseName() {
		return strDrugWareHouseName;
	}
	public void setStrDrugWareHouseName(String strDrugWareHouseName) {
		this.strDrugWareHouseName = strDrugWareHouseName;
	}
	public WebRowSet getWrsDrugWareHouseNameCmb() {
		return wrsDrugWareHouseNameCmb;
	}
	public void setWrsDrugWareHouseNameCmb(WebRowSet wrsDrugWareHouseNameCmb) {
		this.wrsDrugWareHouseNameCmb = wrsDrugWareHouseNameCmb;
	}
	public String getStrFinancialYear() {
		return strFinancialYear;
	}
	public void setStrFinancialYear(String strFinancialYear) {
		this.strFinancialYear = strFinancialYear;
	}
	public String getStrFinancialYearCmb() {
		return strFinancialYearCmb;
	}
	public void setStrFinancialYearCmb(String strFinancialYearCmb) {
		this.strFinancialYearCmb = strFinancialYearCmb;
	}
	public String getStrNewAllocatedBudget() {
		return strNewAllocatedBudget;
	}
	public void setStrNewAllocatedBudget(String strNewAllocatedBudget) {
		this.strNewAllocatedBudget = strNewAllocatedBudget;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrDrugWareHouseNameCmb() {
		return strDrugWareHouseNameCmb;
	}
	public void setStrDrugWareHouseNameCmb(String strDrugWareHouseNameCmb) {
		this.strDrugWareHouseNameCmb = strDrugWareHouseNameCmb;
	}
	public String getStrFinancialStartDate() {
		return strFinancialStartDate;
	}
	public void setStrFinancialStartDate(String strFinancialStartDate) {
		this.strFinancialStartDate = strFinancialStartDate;
	}
	public String getStrFinancialEndDate() {
		return strFinancialEndDate;
	}
	public void setStrFinancialEndDate(String strFinancialEndDate) {
		this.strFinancialEndDate = strFinancialEndDate;
	}
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}
	public WebRowSet getWrsData() {
		return wrsData;
	}
	public void setWrsData(WebRowSet wrsData) {
		this.wrsData = wrsData;
	}
	public String getStrSlNo() {
		return strSlNo;
	}
	public void setStrSlNo(String strSlNo) {
		this.strSlNo = strSlNo;
	}
	public String getStrIsValid() {
		return strIsValid;
	}
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}
	public String getStrAllocDate() {
		return strAllocDate;
	}
	public void setStrAllocDate(String strAllocDate) {
		this.strAllocDate = strAllocDate;
	}
	public String getStrEntryDate() {
		return strEntryDate;
	}
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}
	public String getStrBudgetAllot() {
		return strBudgetAllot;
	}
	public void setStrBudgetAllot(String strBudgetAllot) {
		this.strBudgetAllot = strBudgetAllot;
	}
	public String getStrBudgetUsed() {
		return strBudgetUsed;
	}
	public void setStrBudgetUsed(String strBudgetUsed) {
		this.strBudgetUsed = strBudgetUsed;
	}
	public WebRowSet getWrsFinancialYearCmb() {
		return wrsFinancialYearCmb;
	}
	public void setWrsFinancialYearCmb(WebRowSet wrsFinancialYearCmb) {
		this.wrsFinancialYearCmb = wrsFinancialYearCmb;
	}
	public String getStrPreviousYearRemainingBudget() {
		return strPreviousYearRemainingBudget;
	}
	public void setStrPreviousYearRemainingBudget(
			String strPreviousYearRemainingBudget) {
		this.strPreviousYearRemainingBudget = strPreviousYearRemainingBudget;
	}
	public WebRowSet getWrsDWHSubTypeCmb() {
		return wrsDWHSubTypeCmb;
	}
	public void setWrsDWHSubTypeCmb(WebRowSet wrsDWHSubTypeCmb) {
		this.wrsDWHSubTypeCmb = wrsDWHSubTypeCmb;
	}
	public String getStrDWHSubStoreTypeCmb() {
		return strDWHSubStoreTypeCmb;
	}
	public void setStrDWHSubStoreTypeCmb(String strDWHSubStoreTypeCmb) {
		this.strDWHSubStoreTypeCmb = strDWHSubStoreTypeCmb;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrStoreSubType() {
		return strStoreSubType;
	}
	public void setStrStoreSubType(String strStoreSubType) {
		this.strStoreSubType = strStoreSubType;
	}
	public WebRowSet getWrsDWHSubStoreCmb() {
		return wrsDWHSubStoreCmb;
	}
	public void setWrsDWHSubStoreCmb(WebRowSet wrsDWHSubStoreCmb) {
		this.wrsDWHSubStoreCmb = wrsDWHSubStoreCmb;
	}
	public String getStrSubStoreId() {
		return strSubStoreId;
	}
	public void setStrSubStoreId(String strSubStoreId) {
		this.strSubStoreId = strSubStoreId;
	}
	
	
	
}