package mms.transactions.controller.fb;
/**
 * Developer : Vivek Aggarwal
 * Version : 1.0
 * Date : 08-Aug-2011
 * Modify Date : 
*/
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class BudgetAllocationDetailProcessTransFB extends ActionForm 
{
	private static final long serialVersionUID = 02L;
	private String strNormalMsg = "";
	private String strWarningMsg = "";
    private String strMsgString = "";
	private String strMsgType = "";
	private String strErrMsg = "";

	private String strHospitalCode = "";
	private String strCtDate = "";
	private String strSeatId = "";
	private String hmode;
	/************Variable Start Here******************/
	private String strViewCheckBox;
	
	private String strDrugWareHouseName;
	private String strDrugWareHouseNameCmb;
	
	private String strPreviousYearRemainingBudget;
	private String strLastAllocatedBudget;
	
	private WebRowSet wrsDrugWareHouseNameCmb;
	
	private String strFinancialYearCombo;
	
	private String strFinancialYear;
	private WebRowSet strFinancialYearCmb;
	
	private String strCurrentFinancialYear;
	private String strNextFinancialYear;
	
	private String strBudgetUsed;
	
	private String strNewAllocatedBudget;
	private String strModifiedAllocatedBudget;
	
	private String strRemarks;
	
	private String strStoreId;
	
	private String strBudgetDetailsTable;
	private String strDWHSubTypeId;
	private String strDWHSubTypeCmb;
	private String strSubStoreId;
	
	private String strSubStoreCmb;
	
	private String strGoDetailsFlag="0";
	
	private String strPageFlag;
	private String strCurrentYearTotalBudget;
	private String strCurrentYearUtilizedBudget;
	
	private String strCurrentYrTotalUnutilizedBudgetAvailable;
	
	public String getStrCurrentYearUtilizedBudget() {
		return strCurrentYearUtilizedBudget;
	}
	public void setStrCurrentYearUtilizedBudget(String strCurrentYearUtilizedBudget) {
		this.strCurrentYearUtilizedBudget = strCurrentYearUtilizedBudget;
	}
	public String getStrCurrentYearTotalBudget() {
		return strCurrentYearTotalBudget;
	}
	public void setStrCurrentYearTotalBudget(String strCurrentYearTotalBudget) {
		this.strCurrentYearTotalBudget = strCurrentYearTotalBudget;
	}
	public String getStrGoDetailsFlag() {
		return strGoDetailsFlag;
	}
	public void setStrGoDetailsFlag(String strGoDetailsFlag) {
		this.strGoDetailsFlag = strGoDetailsFlag;
	}
	public String getStrSubStoreCmb() {
		return strSubStoreCmb;
	}
	public void setStrSubStoreCmb(String strSubStoreCmb) {
		this.strSubStoreCmb = strSubStoreCmb;
	}
	public String getStrSubStoreId() {
		return strSubStoreId;
	}
	public void setStrSubStoreId(String strSubStoreId) {
		this.strSubStoreId = strSubStoreId;
	}
	public String getStrBudgetDetailsTable() {
		return strBudgetDetailsTable;
	}
	public void setStrBudgetDetailsTable(String strBudgetDetailsTable) {
		this.strBudgetDetailsTable = strBudgetDetailsTable;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	/*
	 * Getters And Setters
	 */
	public String getStrNormalMsg() {
		return strNormalMsg;
	}
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}
	public String getStrWarningMsg() {
		return strWarningMsg;
	}
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
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
	public String getHmode() {
		return hmode;
	}
	public void setHmode(String hmode) {
		this.hmode = hmode;
	}
	public String getStrViewCheckBox() {
		return strViewCheckBox;
	}
	public void setStrViewCheckBox(String strViewCheckBox) {
		this.strViewCheckBox = strViewCheckBox;
	}
	public String getStrDrugWareHouseName() {
		return strDrugWareHouseName;
	}
	public void setStrDrugWareHouseName(String strDrugWareHouseName) {
		this.strDrugWareHouseName = strDrugWareHouseName;
	}
	public String getStrDrugWareHouseNameCmb() {
		return strDrugWareHouseNameCmb;
	}
	public void setStrDrugWareHouseNameCmb(String strDrugWareHouseNameCmb) {
		this.strDrugWareHouseNameCmb = strDrugWareHouseNameCmb;
	}
	public String getStrPreviousYearRemainingBudget() {
		return strPreviousYearRemainingBudget;
	}
	public void setStrPreviousYearRemainingBudget(
			String strPreviousYearRemainingBudget) {
		this.strPreviousYearRemainingBudget = strPreviousYearRemainingBudget;
	}
	public String getStrLastAllocatedBudget() {
		return strLastAllocatedBudget;
	}
	public void setStrLastAllocatedBudget(String strLastAllocatedBudget) {
		this.strLastAllocatedBudget = strLastAllocatedBudget;
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
	public WebRowSet getStrFinancialYearCmb() {
		return strFinancialYearCmb;
	}
	public void setStrFinancialYearCmb(WebRowSet strFinancialYearCmb) {
		this.strFinancialYearCmb = strFinancialYearCmb;
	}
	public String getStrCurrentFinancialYear() {
		return strCurrentFinancialYear;
	}
	public void setStrCurrentFinancialYear(String strCurrentFinancialYear) {
		this.strCurrentFinancialYear = strCurrentFinancialYear;
	}
	public String getStrNextFinancialYear() {
		return strNextFinancialYear;
	}
	public void setStrNextFinancialYear(String strNextFinancialYear) {
		this.strNextFinancialYear = strNextFinancialYear;
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
	public String getStrBudgetUsed() {
		return strBudgetUsed;
	}
	public void setStrBudgetUsed(String strBudgetUsed) {
		this.strBudgetUsed = strBudgetUsed;
	}
	public String getStrFinancialYearCombo() {
		return strFinancialYearCombo;
	}
	public void setStrFinancialYearCombo(String strFinancialYearCombo) {
		this.strFinancialYearCombo = strFinancialYearCombo;
	}
	
	
	
	/*
	 * 	To reset the values on the Add Page
	 */
	public void reset(ActionMapping mapping,HttpServletRequest request)
	{		
		this.setStrDrugWareHouseName("0");
		
	}
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
	public String getStrPageFlag() {
		return strPageFlag;
	}
	public void setStrPageFlag(String strPageFlag) {
		this.strPageFlag = strPageFlag;
	}
	public String getStrModifiedAllocatedBudget() {
		return strModifiedAllocatedBudget;
	}
	public void setStrModifiedAllocatedBudget(String strModifiedAllocatedBudget) {
		this.strModifiedAllocatedBudget = strModifiedAllocatedBudget;
	}
	public String getStrCurrentYrTotalUnutilizedBudgetAvailable() {
		return strCurrentYrTotalUnutilizedBudgetAvailable;
	}
	public void setStrCurrentYrTotalUnutilizedBudgetAvailable(
			String strCurrentYrTotalUnutilizedBudgetAvailable) {
		this.strCurrentYrTotalUnutilizedBudgetAvailable = strCurrentYrTotalUnutilizedBudgetAvailable;
	}
}
