package mms.transactions.controller.fb;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class ChallanModificationTransFB extends ActionForm 
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
	
		
	private String strFinancialYear;
	private String strModifyFlag="0";
	
	
	
	private String strStoreId;
	private String strNewAcceptedQty;
	
	private String strBudgetDetailsTable;
	private String strDWHSubTypeId;
	private String strDWHSubTypeCmb;
	private String strSubStoreId;
	
	private String strSubStoreCmb;
	
	private String strGoDetailsFlag="0";
	
	private String strPoNo;
	private String strPoNoCmb;
	
	private String strChallanNoCmb;
	
	
	private String strItemId;
	private String strItemNameCmb;
	private String strReportDate;
	private String strReportNumber;
	
	private String strPageNo;
	private String strReportType;
	private String strToDate;
	private String strFromDate;
	private String strOrderedQty;
	private String strResetOrderedQty;
	private String strAcceptedQty;
	private String strWhetherTestReportSubmitted;
	private String strManufactureCombo;
	private String strSupplierId;
	
	private String[] strMultiRowInvoiceDate = null;
	private String[] strMultiRowChallanNo=null; 
	private String[] strMultiRowChallanReceiveDate={""};
	private String[] strMultiRowBatchNo=null;
	private String[] strMultiRowReceivedQty=null;
	private String[] strMultiRowWhetherTestReportSubmitted=null;	
	private String[] strMultiRowWhetherMedicinesInGoodCondition=null;
	private String[] strMultiRowWhetherSupplyNotForSale=null;
	private String[] strMultiRowWhetherBrandNameNotWritten=null;
	private String[] strMultiRowWhetherMRPPrint=null;
	private String[] strHiddenChallanNo=null;
	private String[] strHiddenChallanQty=null;
	
	private String[] 	strMultiRowRejectedQty=null;
	private String[] 	strMultiRowBreakageQty=null;
	private String[] 	strMultiRowExcessQty=null;
	private String[] 	strMultiRowExpireDate=null;
	private String[] 	strMultiRowManufacterDate=null;
	private String[] 	strMultiRowPerformanceDtlEntry=null;
	
	
	private String   strExpiryDate;
	private String   strManufactureDate;
	private String   strAcceptedQuantity;
	private String   strRejectedQuantity;
	private String   strBreakageQuantity;
	private String   strExcessQty;
	private String 	 strWhetherMedicinesWithTestReport;
	private String 	 strWhetherMedicinesInGoodCondition;	
	private String 	 strWhetherSupplyNotForSale;
	private String 	 strWhetherBrandNameNotWritten;
	private String 	 strWhetherMRPPrint;
	private String 	 strRemarks;
	private String   strChallanNo;
	private String   strPrevHiddenChallanValue;
	private String   strBatchNo;
	private String   strSupplierChallanNo;
	private String   strSupplierChallanDate;
	private String   strChallanReceiveDate;
	private String   strChallanValue;
	

	
	
	
	
	
	public String getStrChallanValue() {
		return strChallanValue;
	}
	public void setStrChallanValue(String strChallanValue) {
		this.strChallanValue = strChallanValue;
	}
	public String getStrBatchNo() {
		return strBatchNo;
	}
	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}
	public String getStrPrevHiddenChallanValue() {
		return strPrevHiddenChallanValue;
	}
	public void setStrPrevHiddenChallanValue(String strPrevHiddenChallanValue) {
		this.strPrevHiddenChallanValue = strPrevHiddenChallanValue;
	}
	public String[] getStrHiddenChallanNo() {
		return strHiddenChallanNo;
	}
	public void setStrHiddenChallanNo(String[] strHiddenChallanNo) {
		this.strHiddenChallanNo = strHiddenChallanNo;
	}
	public String[] getStrHiddenChallanQty() {
		return strHiddenChallanQty;
	}
	public void setStrHiddenChallanQty(String[] strHiddenChallanQty) {
		this.strHiddenChallanQty = strHiddenChallanQty;
	}
	public String getStrWhetherTestReportSubmitted() {
		return strWhetherTestReportSubmitted;
	}
	public void setStrWhetherTestReportSubmitted(
			String strWhetherTestReportSubmitted) {
		this.strWhetherTestReportSubmitted = strWhetherTestReportSubmitted;
	}
	public String getStrOrderedQty() {
		return strOrderedQty;
	}
	public void setStrOrderedQty(String strOrderedQty) {
		this.strOrderedQty = strOrderedQty;
	}
	public String getStrToDate() {
		return strToDate;
	}
	public void setStrToDate(String strToDate) {
		this.strToDate = strToDate;
	}
	public String getStrFromDate() {
		return strFromDate;
	}
	public void setStrFromDate(String strFromDate) {
		this.strFromDate = strFromDate;
	}
	public String getStrWhetherMedicinesWithTestReport() {
		return strWhetherMedicinesWithTestReport;
	}
	public void setStrWhetherMedicinesWithTestReport(
			String strWhetherMedicinesWithTestReport) {
		this.strWhetherMedicinesWithTestReport = strWhetherMedicinesWithTestReport;
	}
	public String getStrReportDate() {
		return strReportDate;
	}
	public void setStrReportDate(String strReportDate) {
		this.strReportDate = strReportDate;
	}
	public String getStrChallanNoCmb() {
		return strChallanNoCmb;
	}
	public void setStrChallanNoCmb(String strChallanNoCmb) {
		this.strChallanNoCmb = strChallanNoCmb;
	}
	public String getStrChallanNo() {
		return strChallanNo;
	}
	public void setStrChallanNo(String strChallanNo) {
		this.strChallanNo = strChallanNo;
	}
	public String getStrPoNoCmb() {
		return strPoNoCmb;
	}
	public void setStrPoNoCmb(String strPoNoCmb) {
		this.strPoNoCmb = strPoNoCmb;
	}
	public String getStrPoNo() {
		return strPoNo;
	}
	public void setStrPoNo(String strPoNo) {
		this.strPoNo = strPoNo;
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
	
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
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
	public String getStrItemId() {
		return strItemId;
	}
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}
	public String getStrItemNameCmb() {
		return strItemNameCmb;
	}
	public void setStrItemNameCmb(String strItemNameCmb) {
		this.strItemNameCmb = strItemNameCmb;
	}
	public String getStrReportNumber() {
		return strReportNumber;
	}
	public void setStrReportNumber(String strReportNumber) {
		this.strReportNumber = strReportNumber;
	}
	public String getStrWhetherMedicinesInGoodCondition() {
		return strWhetherMedicinesInGoodCondition;
	}
	public void setStrWhetherMedicinesInGoodCondition(
			String strWhetherMedicinesInGoodCondition) {
		this.strWhetherMedicinesInGoodCondition = strWhetherMedicinesInGoodCondition;
	}
	public String getStrWhetherSupplyNotForSale() {
		return strWhetherSupplyNotForSale;
	}
	public void setStrWhetherSupplyNotForSale(String strWhetherSupplyNotForSale) {
		this.strWhetherSupplyNotForSale = strWhetherSupplyNotForSale;
	}
	public String getStrWhetherBrandNameNotWritten() {
		return strWhetherBrandNameNotWritten;
	}
	public void setStrWhetherBrandNameNotWritten(
			String strWhetherBrandNameNotWritten) {
		this.strWhetherBrandNameNotWritten = strWhetherBrandNameNotWritten;
	}
	public String getStrWhetherMRPPrint() {
		return strWhetherMRPPrint;
	}
	public void setStrWhetherMRPPrint(String strWhetherMRPPrint) {
		this.strWhetherMRPPrint = strWhetherMRPPrint;
	}
	public String getStrReportType() {
		return strReportType;
	}
	public void setStrReportType(String strReportType) {
		this.strReportType = strReportType;
	}
	public String getStrPageNo() {
		return strPageNo;
	}
	public void setStrPageNo(String strPageNo) {
		this.strPageNo = strPageNo;
	}
	public String getStrAcceptedQty() {
		return strAcceptedQty;
	}
	public void setStrAcceptedQty(String strAcceptedQty) {
		this.strAcceptedQty = strAcceptedQty;
	}
	public String getStrResetOrderedQty() {
		return strResetOrderedQty;
	}
	public void setStrResetOrderedQty(String strResetOrderedQty) {
		this.strResetOrderedQty = strResetOrderedQty;
	}
	public String[] getStrMultiRowChallanNo() {
		return strMultiRowChallanNo;
	}
	public void setStrMultiRowChallanNo(String[] strMultiRowChallanNo) {
		this.strMultiRowChallanNo = strMultiRowChallanNo;
	}
	public String[] getStrMultiRowChallanReceiveDate() {
		return strMultiRowChallanReceiveDate;
	}
	public void setStrMultiRowChallanReceiveDate(
			String[] strMultiRowChallanReceiveDate) {
		this.strMultiRowChallanReceiveDate = strMultiRowChallanReceiveDate;
	}
	public String[] getStrMultiRowBatchNo() {
		return strMultiRowBatchNo;
	}
	public void setStrMultiRowBatchNo(String[] strMultiRowBatchNo) {
		this.strMultiRowBatchNo = strMultiRowBatchNo;
	}
	public String[] getStrMultiRowReceivedQty() {
		return strMultiRowReceivedQty;
	}
	public void setStrMultiRowReceivedQty(String[] strMultiRowReceivedQty) {
		this.strMultiRowReceivedQty = strMultiRowReceivedQty;
	}
	public String[] getStrMultiRowWhetherTestReportSubmitted() {
		return strMultiRowWhetherTestReportSubmitted;
	}
	public void setStrMultiRowWhetherTestReportSubmitted(
			String[] strMultiRowWhetherTestReportSubmitted) {
		this.strMultiRowWhetherTestReportSubmitted = strMultiRowWhetherTestReportSubmitted;
	}
	public String[] getStrMultiRowWhetherMedicinesInGoodCondition() {
		return strMultiRowWhetherMedicinesInGoodCondition;
	}
	public void setStrMultiRowWhetherMedicinesInGoodCondition(
			String[] strMultiRowWhetherMedicinesInGoodCondition) {
		this.strMultiRowWhetherMedicinesInGoodCondition = strMultiRowWhetherMedicinesInGoodCondition;
	}
	public String[] getStrMultiRowWhetherSupplyNotForSale() {
		return strMultiRowWhetherSupplyNotForSale;
	}
	public void setStrMultiRowWhetherSupplyNotForSale(
			String[] strMultiRowWhetherSupplyNotForSale) {
		this.strMultiRowWhetherSupplyNotForSale = strMultiRowWhetherSupplyNotForSale;
	}
	public String[] getStrMultiRowWhetherBrandNameNotWritten() {
		return strMultiRowWhetherBrandNameNotWritten;
	}
	public void setStrMultiRowWhetherBrandNameNotWritten(
			String[] strMultiRowWhetherBrandNameNotWritten) {
		this.strMultiRowWhetherBrandNameNotWritten = strMultiRowWhetherBrandNameNotWritten;
	}
	public String[] getStrMultiRowWhetherMRPPrint() {
		return strMultiRowWhetherMRPPrint;
	}
	public void setStrMultiRowWhetherMRPPrint(String[] strMultiRowWhetherMRPPrint) {
		this.strMultiRowWhetherMRPPrint = strMultiRowWhetherMRPPrint;
	}
	public String getStrManufactureCombo() {
		return strManufactureCombo;
	}
	public void setStrManufactureCombo(String strManufactureCombo) {
		this.strManufactureCombo = strManufactureCombo;
	}
	public String getStrSupplierId() {
		return strSupplierId;
	}
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}
	public String[] getStrMultiRowInvoiceDate() {
		return strMultiRowInvoiceDate;
	}
	public void setStrMultiRowInvoiceDate(String[] strMultiRowInvoiceDate) {
		this.strMultiRowInvoiceDate = strMultiRowInvoiceDate;
	}
	public String getStrModifyFlag() {
		return strModifyFlag;
	}
	public void setStrModifyFlag(String strModifyFlag) {
		this.strModifyFlag = strModifyFlag;
	}
	public String getStrNewAcceptedQty() {
		return strNewAcceptedQty;
	}
	public void setStrNewAcceptedQty(String strNewAcceptedQty) {
		this.strNewAcceptedQty = strNewAcceptedQty;
	}
	public String[] getStrMultiRowRejectedQty() {
		return strMultiRowRejectedQty;
	}
	public void setStrMultiRowRejectedQty(String[] strMultiRowRejectedQty) {
		this.strMultiRowRejectedQty = strMultiRowRejectedQty;
	}
	public String[] getStrMultiRowBreakageQty() {
		return strMultiRowBreakageQty;
	}
	public void setStrMultiRowBreakageQty(String[] strMultiRowBreakageQty) {
		this.strMultiRowBreakageQty = strMultiRowBreakageQty;
	}
	public String[] getStrMultiRowExcessQty() {
		return strMultiRowExcessQty;
	}
	public void setStrMultiRowExcessQty(String[] strMultiRowExcessQty) {
		this.strMultiRowExcessQty = strMultiRowExcessQty;
	}
	public String[] getStrMultiRowExpireDate() {
		return strMultiRowExpireDate;
	}
	public void setStrMultiRowExpireDate(String[] strMultiRowExpireDate) {
		this.strMultiRowExpireDate = strMultiRowExpireDate;
	}
	public String[] getStrMultiRowManufacterDate() {
		return strMultiRowManufacterDate;
	}
	public void setStrMultiRowManufacterDate(String[] strMultiRowManufacterDate) {
		this.strMultiRowManufacterDate = strMultiRowManufacterDate;
	}
	public String[] getStrMultiRowPerformanceDtlEntry() {
		return strMultiRowPerformanceDtlEntry;
	}
	public void setStrMultiRowPerformanceDtlEntry(
			String[] strMultiRowPerformanceDtlEntry) {
		this.strMultiRowPerformanceDtlEntry = strMultiRowPerformanceDtlEntry;
	}
	public String getStrExpiryDate() {
		return strExpiryDate;
	}
	public void setStrExpiryDate(String strExpiryDate) {
		this.strExpiryDate = strExpiryDate;
	}
	public String getStrManufactureDate() {
		return strManufactureDate;
	}
	public void setStrManufactureDate(String strManufactureDate) {
		this.strManufactureDate = strManufactureDate;
	}
	public String getStrAcceptedQuantity() {
		return strAcceptedQuantity;
	}
	public void setStrAcceptedQuantity(String strAcceptedQuantity) {
		this.strAcceptedQuantity = strAcceptedQuantity;
	}
	public String getStrRejectedQuantity() {
		return strRejectedQuantity;
	}
	public void setStrRejectedQuantity(String strRejectedQuantity) {
		this.strRejectedQuantity = strRejectedQuantity;
	}
	public String getStrBreakageQuantity() {
		return strBreakageQuantity;
	}
	public void setStrBreakageQuantity(String strBreakageQuantity) {
		this.strBreakageQuantity = strBreakageQuantity;
	}
	public String getStrExcessQty() {
		return strExcessQty;
	}
	public void setStrExcessQty(String strExcessQty) {
		this.strExcessQty = strExcessQty;
	}
	public String getStrSupplierChallanNo() {
		return strSupplierChallanNo;
	}
	public void setStrSupplierChallanNo(String strSupplierChallanNo) {
		this.strSupplierChallanNo = strSupplierChallanNo;
	}
	public String getStrSupplierChallanDate() {
		return strSupplierChallanDate;
	}
	public void setStrSupplierChallanDate(String strSupplierChallanDate) {
		this.strSupplierChallanDate = strSupplierChallanDate;
	}
	public String getStrChallanReceiveDate() {
		return strChallanReceiveDate;
	}
	public void setStrChallanReceiveDate(String strChallanReceiveDate) {
		this.strChallanReceiveDate = strChallanReceiveDate;
	}
}
