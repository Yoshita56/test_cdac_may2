package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

public class ChallanModificationTransVO {
	

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
	private String strSupplierId;
	
	
	private String strAllocDate;
	private String strNewAllocatedBudget;

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
	private WebRowSet wrsChallanNoCmb;
	
	private String strDWHId;
	private String strDWHSubTypeCmb;
	private String strDWHSubStoreTypeCmb;
	private String strSubStoreId;
	
	private String strPoNo;
	
	private String strToDate;
	private String strFromDate;
	
	private String strItemBrandId;
	
	private String strReportNumber;
	private String strReportDate;
	
	
	private String strPageNo;
	private String strGenericItemId;
	private String strItemId;
	
	private String strReceiptNo;
	private String strAcceptedQty;
	
	private String[] strMultiRowInvoiceDate = null;
	private String[] strMultiRowChallanNo=null; 
	private String[] strMultiRowChallanReceiveDate=null;
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
	
	private WebRowSet strManufactureComboWS=null;
	private String strModifyFlag;
	
	
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
	public String getStrModifyFlag() {
		return strModifyFlag;
	}
	public void setStrModifyFlag(String strModifyFlag) {
		this.strModifyFlag = strModifyFlag;
	}
	public WebRowSet getStrManufactureComboWS() {
		return strManufactureComboWS;
	}
	public void setStrManufactureComboWS(WebRowSet strManufactureComboWS) {
		this.strManufactureComboWS = strManufactureComboWS;
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
	public String getStrAcceptedQty() {
		return strAcceptedQty;
	}
	public void setStrAcceptedQty(String strAcceptedQty) {
		this.strAcceptedQty = strAcceptedQty;
	}
	public String getStrReceiptNo() {
		return strReceiptNo;
	}
	public void setStrReceiptNo(String strReceiptNo) {
		this.strReceiptNo = strReceiptNo;
	}
	public String getStrGenericItemId() {
		return strGenericItemId;
	}
	public void setStrGenericItemId(String strGenericItemId) {
		this.strGenericItemId = strGenericItemId;
	}
	public String getStrPageNo() {
		return strPageNo;
	}
	public void setStrPageNo(String strPageNo) {
		this.strPageNo = strPageNo;
	}
	public String getStrReportNumber() {
		return strReportNumber;
	}
	public void setStrReportNumber(String strReportNumber) {
		this.strReportNumber = strReportNumber;
	}
	public String getStrReportDate() {
		return strReportDate;
	}
	public void setStrReportDate(String strReportDate) {
		this.strReportDate = strReportDate;
	}
	public String getStrWhetherMedicinesWithTestReport() {
		return strWhetherMedicinesWithTestReport;
	}
	public void setStrWhetherMedicinesWithTestReport(
			String strWhetherMedicinesWithTestReport) {
		this.strWhetherMedicinesWithTestReport = strWhetherMedicinesWithTestReport;
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
	public String getStrItemBrandId() {
		return strItemBrandId;
	}
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
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
	public String getStrChallanNo() {
		return strChallanNo;
	}
	public void setStrChallanNo(String strChallanNo) {
		this.strChallanNo = strChallanNo;
	}
	public String getStrPoNo() {
		return strPoNo;
	}
	public void setStrPoNo(String strPoNo) {
		this.strPoNo = strPoNo;
	}
	public String getStrDWHId() {
		return strDWHId;
	}
	public void setStrDWHId(String strDWHId) {
		this.strDWHId = strDWHId;
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
	public String getStrItemId() {
		return strItemId;
	}
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
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
	public WebRowSet getWrsChallanNoCmb() {
		return wrsChallanNoCmb;
	}
	public void setWrsChallanNoCmb(WebRowSet wrsChallanNoCmb) {
		this.wrsChallanNoCmb = wrsChallanNoCmb;
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
	
	
	
}
