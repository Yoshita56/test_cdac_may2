package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

/**
 * @author rishabhbelsare
 *
 */
public class BillApprovalVerificationRptVO {
	
	private String strMode;
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String strMsgType = "";
	private String strMsgString = "";
	
	private String strPatientGenderCode = "";
	private String strPatientCategory = "";
	
	private String strPatientCategoryName = "";

	
	private String strStoreName = "";
	private String strItemCategoryId = "";
	private String strItemCategoryName = "";
	private String strFinancialStartYear = "";
	private String strFinancialEndYear = "";
	private String strLogoName = "";
	private String strUserName ="";
	private String strItemCatNo ="";

	private String strStoreId = "";
	private String strSupplierId ="";                                                                                                  
	private String strItemCatId ="";                                                                                                  
	private String strPoNoId ="";                                                                                                  
	private String strBillTypeId ="";
	private String StrPODate ="";

	private WebRowSet strStoreWs = null;
	private WebRowSet strSupplierWs = null;
	private WebRowSet strBillTypeWs = null;
	private WebRowSet strPODetailsWs = null;
	
	private static final long serialVersionUID = 02L;

	private Boolean BExistStatus = false;
	public Boolean getBExistStatus() {
		return BExistStatus;
	}
	public void setBExistStatus(Boolean bExistStatus) {
		BExistStatus = bExistStatus;
	}
	public String getStrStatus() {
		return strStatus;
	}
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}
	public String getStrFileName() {
		return strFileName;
	}
	public void setStrFileName(String strFileName) {
		this.strFileName = strFileName;
	}
	public String getStrPONo() {
		return strPONo;
	}
	public void setStrPONo(String strPONo) {
		this.strPONo = strPONo;
	}
	public String getStrPONoCmb() {
		return strPONoCmb;
	}
	public void setStrPONoCmb(String strPONoCmb) {
		this.strPONoCmb = strPONoCmb;
	}
	public WebRowSet getStrPONoCmbWS() {
		return strPONoCmbWS;
	}
	public void setStrPONoCmbWS(WebRowSet strPONoCmbWS) {
		this.strPONoCmbWS = strPONoCmbWS;
	}
	public String getStrPOType() {
		return strPOType;
	}
	public void setStrPOType(String strPOType) {
		this.strPOType = strPOType;
	}
	public String getStrPONetAmount() {
		return strPONetAmount;
	}
	public void setStrPONetAmount(String strPONetAmount) {
		this.strPONetAmount = strPONetAmount;
	}
	public String getStrAgentName() {
		return strAgentName;
	}
	public void setStrAgentName(String strAgentName) {
		this.strAgentName = strAgentName;
	}
	public String getStrCAName() {
		return strCAName;
	}
	public void setStrCAName(String strCAName) {
		this.strCAName = strCAName;
	}
	public String getStrMaturityDate() {
		return strMaturityDate;
	}
	public void setStrMaturityDate(String strMaturityDate) {
		this.strMaturityDate = strMaturityDate;
	}
	public String getStrAgendaNo() {
		return strAgendaNo;
	}
	public void setStrAgendaNo(String strAgendaNo) {
		this.strAgendaNo = strAgendaNo;
	}
	public String getStrAgendaDate() {
		return strAgendaDate;
	}
	public void setStrAgendaDate(String strAgendaDate) {
		this.strAgendaDate = strAgendaDate;
	}
	public String getStrSupplierName() {
		return strSupplierName;
	}
	public void setStrSupplierName(String strSupplierName) {
		this.strSupplierName = strSupplierName;
	}
	public String getStrSelScheduleNos() {
		return strSelScheduleNos;
	}
	public void setStrSelScheduleNos(String strSelScheduleNos) {
		this.strSelScheduleNos = strSelScheduleNos;
	}
	public String getStrScheduleNo() {
		return strScheduleNo;
	}
	public void setStrScheduleNo(String strScheduleNo) {
		this.strScheduleNo = strScheduleNo;
	}
	public String getStrReceiptNo() {
		return strReceiptNo;
	}
	public void setStrReceiptNo(String strReceiptNo) {
		this.strReceiptNo = strReceiptNo;
	}
	public String getStrReceiptDate() {
		return strReceiptDate;
	}
	public void setStrReceiptDate(String strReceiptDate) {
		this.strReceiptDate = strReceiptDate;
	}
	public String getStrItemName() {
		return strItemName;
	}
	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}
	public String getStrBrandName() {
		return strBrandName;
	}
	public void setStrBrandName(String strBrandName) {
		this.strBrandName = strBrandName;
	}
	public String getStrCurrencyId() {
		return strCurrencyId;
	}
	public void setStrCurrencyId(String strCurrencyId) {
		this.strCurrencyId = strCurrencyId;
	}
	public String getStrCurrencyName() {
		return strCurrencyName;
	}
	public void setStrCurrencyName(String strCurrencyName) {
		this.strCurrencyName = strCurrencyName;
	}
	public String getStrCurrencyValue() {
		return strCurrencyValue;
	}
	public void setStrCurrencyValue(String strCurrencyValue) {
		this.strCurrencyValue = strCurrencyValue;
	}
	public String getStrRequiredQty() {
		return strRequiredQty;
	}
	public void setStrRequiredQty(String strRequiredQty) {
		this.strRequiredQty = strRequiredQty;
	}
	public String getStrSuppliedQty() {
		return strSuppliedQty;
	}
	public void setStrSuppliedQty(String strSuppliedQty) {
		this.strSuppliedQty = strSuppliedQty;
	}
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}
	public String getStrCurrentDateTime() {
		return strCurrentDateTime;
	}
	public void setStrCurrentDateTime(String strCurrentDateTime) {
		this.strCurrentDateTime = strCurrentDateTime;
	}
	public String getStrNetItemCost() {
		return strNetItemCost;
	}
	public void setStrNetItemCost(String strNetItemCost) {
		this.strNetItemCost = strNetItemCost;
	}
	public String getStrNetPenalty() {
		return strNetPenalty;
	}
	public void setStrNetPenalty(String strNetPenalty) {
		this.strNetPenalty = strNetPenalty;
	}
	public String[] getStrScheduleNoArrH() {
		return strScheduleNoArrH;
	}
	public void setStrScheduleNoArrH(String[] strScheduleNoArrH) {
		this.strScheduleNoArrH = strScheduleNoArrH;
	}
	public String[] getStrScheduleCostArrH() {
		return strScheduleCostArrH;
	}
	public void setStrScheduleCostArrH(String[] strScheduleCostArrH) {
		this.strScheduleCostArrH = strScheduleCostArrH;
	}
	public String getStrAdvanceTaken() {
		return strAdvanceTaken;
	}
	public void setStrAdvanceTaken(String strAdvanceTaken) {
		this.strAdvanceTaken = strAdvanceTaken;
	}
	public String getStrApprovedItemCost() {
		return strApprovedItemCost;
	}
	public void setStrApprovedItemCost(String strApprovedItemCost) {
		this.strApprovedItemCost = strApprovedItemCost;
	}
	public String getStrApprovedPenalty() {
		return strApprovedPenalty;
	}
	public void setStrApprovedPenalty(String strApprovedPenalty) {
		this.strApprovedPenalty = strApprovedPenalty;
	}
	public String getStrAdvanceAdjusted() {
		return strAdvanceAdjusted;
	}
	public void setStrAdvanceAdjusted(String strAdvanceAdjusted) {
		this.strAdvanceAdjusted = strAdvanceAdjusted;
	}
	public String getStrBalanceItemCost() {
		return strBalanceItemCost;
	}
	public void setStrBalanceItemCost(String strBalanceItemCost) {
		this.strBalanceItemCost = strBalanceItemCost;
	}
	public String getStrBalancePenalty() {
		return strBalancePenalty;
	}
	public void setStrBalancePenalty(String strBalancePenalty) {
		this.strBalancePenalty = strBalancePenalty;
	}
	public String getStrBalanceAdvance() {
		return strBalanceAdvance;
	}
	public void setStrBalanceAdvance(String strBalanceAdvance) {
		this.strBalanceAdvance = strBalanceAdvance;
	}
	public String getStrTax() {
		return strTax;
	}
	public void setStrTax(String strTax) {
		this.strTax = strTax;
	}
	public String getStrItemCost() {
		return strItemCost;
	}
	public void setStrItemCost(String strItemCost) {
		this.strItemCost = strItemCost;
	}
	public String getStrTotalItemCost() {
		return strTotalItemCost;
	}
	public void setStrTotalItemCost(String strTotalItemCost) {
		this.strTotalItemCost = strTotalItemCost;
	}
	public String getStrOverallPOTax() {
		return strOverallPOTax;
	}
	public void setStrOverallPOTax(String strOverallPOTax) {
		this.strOverallPOTax = strOverallPOTax;
	}
	public String getStrTotalTaxAmount() {
		return strTotalTaxAmount;
	}
	public void setStrTotalTaxAmount(String strTotalTaxAmount) {
		this.strTotalTaxAmount = strTotalTaxAmount;
	}
	public String getStrBillAmount() {
		return strBillAmount;
	}
	public void setStrBillAmount(String strBillAmount) {
		this.strBillAmount = strBillAmount;
	}
	public String getStrMisclaneousAmount() {
		return strMisclaneousAmount;
	}
	public void setStrMisclaneousAmount(String strMisclaneousAmount) {
		this.strMisclaneousAmount = strMisclaneousAmount;
	}
	public String getStrSanctionedAmount() {
		return strSanctionedAmount;
	}
	public void setStrSanctionedAmount(String strSanctionedAmount) {
		this.strSanctionedAmount = strSanctionedAmount;
	}
	public String getStrTaxUnit() {
		return strTaxUnit;
	}
	public void setStrTaxUnit(String strTaxUnit) {
		this.strTaxUnit = strTaxUnit;
	}
	public String getStrItemCategoryNoH() {
		return strItemCategoryNoH;
	}
	public void setStrItemCategoryNoH(String strItemCategoryNoH) {
		this.strItemCategoryNoH = strItemCategoryNoH;
	}
	public String getStrItemCategoryNameH() {
		return strItemCategoryNameH;
	}
	public void setStrItemCategoryNameH(String strItemCategoryNameH) {
		this.strItemCategoryNameH = strItemCategoryNameH;
	}
	public String getStrPOTypeId() {
		return strPOTypeId;
	}
	public void setStrPOTypeId(String strPOTypeId) {
		this.strPOTypeId = strPOTypeId;
	}
	public String getStrPOStoreId() {
		return strPOStoreId;
	}
	public void setStrPOStoreId(String strPOStoreId) {
		this.strPOStoreId = strPOStoreId;
	}
	public String getStrPOStoreName() {
		return strPOStoreName;
	}
	public void setStrPOStoreName(String strPOStoreName) {
		this.strPOStoreName = strPOStoreName;
	}
	public String getStrWaiveOffAmt() {
		return strWaiveOffAmt;
	}
	public void setStrWaiveOffAmt(String strWaiveOffAmt) {
		this.strWaiveOffAmt = strWaiveOffAmt;
	}
	public String getStrWaiveOffApprovedBy() {
		return strWaiveOffApprovedBy;
	}
	public void setStrWaiveOffApprovedBy(String strWaiveOffApprovedBy) {
		this.strWaiveOffApprovedBy = strWaiveOffApprovedBy;
	}
	public String getStrWaiveOffApprovedDate() {
		return strWaiveOffApprovedDate;
	}
	public void setStrWaiveOffApprovedDate(String strWaiveOffApprovedDate) {
		this.strWaiveOffApprovedDate = strWaiveOffApprovedDate;
	}
	public String getStrFileExt() {
		return strFileExt;
	}
	public void setStrFileExt(String strFileExt) {
		this.strFileExt = strFileExt;
	}
	public WebRowSet getStrWaiveOffApprovedByWS() {
		return strWaiveOffApprovedByWS;
	}
	public void setStrWaiveOffApprovedByWS(WebRowSet strWaiveOffApprovedByWS) {
		this.strWaiveOffApprovedByWS = strWaiveOffApprovedByWS;
	}
	public String getStrSearchListPODtlFromDate() {
		return strSearchListPODtlFromDate;
	}
	public void setStrSearchListPODtlFromDate(String strSearchListPODtlFromDate) {
		this.strSearchListPODtlFromDate = strSearchListPODtlFromDate;
	}
	public String getStrSearchListPODtlToDate() {
		return strSearchListPODtlToDate;
	}
	public void setStrSearchListPODtlToDate(String strSearchListPODtlToDate) {
		this.strSearchListPODtlToDate = strSearchListPODtlToDate;
	}
	public String getStrSearchListPODetails() {
		return strSearchListPODetails;
	}
	public void setStrSearchListPODetails(String strSearchListPODetails) {
		this.strSearchListPODetails = strSearchListPODetails;
	}
	public WebRowSet getWsPeneltyDtl() {
		return wsPeneltyDtl;
	}
	public void setWsPeneltyDtl(WebRowSet wsPeneltyDtl) {
		this.wsPeneltyDtl = wsPeneltyDtl;
	}
	public String getStrBillNo() {
		return strBillNo;
	}
	public void setStrBillNo(String strBillNo) {
		this.strBillNo = strBillNo;
	}
	public String getStrBillDate() {
		return strBillDate;
	}
	public void setStrBillDate(String strBillDate) {
		this.strBillDate = strBillDate;
	}
	public String getStrBillType() {
		return strBillType;
	}
	public void setStrBillType(String strBillType) {
		this.strBillType = strBillType;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrDisplayPODetails() {
		return strDisplayPODetails;
	}
	public void setStrDisplayPODetails(String strDisplayPODetails) {
		this.strDisplayPODetails = strDisplayPODetails;
	}
	public WebRowSet getDisplayPODetails() {
		return displayPODetails;
	}
	public void setDisplayPODetails(WebRowSet displayPODetails) {
		this.displayPODetails = displayPODetails;
	}
	public WebRowSet getStrScheduleDtlsWS() {
		return strScheduleDtlsWS;
	}
	public void setStrScheduleDtlsWS(WebRowSet strScheduleDtlsWS) {
		this.strScheduleDtlsWS = strScheduleDtlsWS;
	}
	public WebRowSet getStrScheduleItemDtlsWS() {
		return strScheduleItemDtlsWS;
	}
	public void setStrScheduleItemDtlsWS(WebRowSet strScheduleItemDtlsWS) {
		this.strScheduleItemDtlsWS = strScheduleItemDtlsWS;
	}
	public String getStrReceiptDetails() {
		return strReceiptDetails;
	}
	public void setStrReceiptDetails(String strReceiptDetails) {
		this.strReceiptDetails = strReceiptDetails;
	}
	public WebRowSet getReceiptDetailsWs() {
		return receiptDetailsWs;
	}
	public void setReceiptDetailsWs(WebRowSet receiptDetailsWs) {
		this.receiptDetailsWs = receiptDetailsWs;
	}
	public WebRowSet getStrOtherDetailsWs() {
		return strOtherDetailsWs;
	}
	public void setStrOtherDetailsWs(WebRowSet strOtherDetailsWs) {
		this.strOtherDetailsWs = strOtherDetailsWs;
	}
	public String getStrReceiptItemDetails() {
		return strReceiptItemDetails;
	}
	public void setStrReceiptItemDetails(String strReceiptItemDetails) {
		this.strReceiptItemDetails = strReceiptItemDetails;
	}
	public WebRowSet getReceiptItemDetailsWs() {
		return receiptItemDetailsWs;
	}
	public void setReceiptItemDetailsWs(WebRowSet receiptItemDetailsWs) {
		this.receiptItemDetailsWs = receiptItemDetailsWs;
	}
	public WebRowSet getItemCostWs() {
		return itemCostWs;
	}
	public void setItemCostWs(WebRowSet itemCostWs) {
		this.itemCostWs = itemCostWs;
	}
	public WebRowSet getWsPrintItemDtls() {
		return wsPrintItemDtls;
	}
	public void setWsPrintItemDtls(WebRowSet wsPrintItemDtls) {
		this.wsPrintItemDtls = wsPrintItemDtls;
	}
	public String getStrPaymentStatus() {
		return strPaymentStatus;
	}
	public void setStrPaymentStatus(String strPaymentStatus) {
		this.strPaymentStatus = strPaymentStatus;
	}
	public String getStrPaymentDate() {
		return strPaymentDate;
	}
	public void setStrPaymentDate(String strPaymentDate) {
		this.strPaymentDate = strPaymentDate;
	}
	public String getStrUTRNo() {
		return strUTRNo;
	}
	public void setStrUTRNo(String strUTRNo) {
		this.strUTRNo = strUTRNo;
	}
	public String getStrPONetCost() {
		return strPONetCost;
	}
	public void setStrPONetCost(String strPONetCost) {
		this.strPONetCost = strPONetCost;
	}
	public String getStrSupplyNetCost() {
		return strSupplyNetCost;
	}
	public void setStrSupplyNetCost(String strSupplyNetCost) {
		this.strSupplyNetCost = strSupplyNetCost;
	}
	public String getStrPreviousPaymentDtls() {
		return strPreviousPaymentDtls;
	}
	public void setStrPreviousPaymentDtls(String strPreviousPaymentDtls) {
		this.strPreviousPaymentDtls = strPreviousPaymentDtls;
	}
	public WebRowSet getWsPaymentDtls() {
		return wsPaymentDtls;
	}
	public void setWsPaymentDtls(WebRowSet wsPaymentDtls) {
		this.wsPaymentDtls = wsPaymentDtls;
	}
	public String getStrInvoiceNo() {
		return strInvoiceNo;
	}
	public void setStrInvoiceNo(String strInvoiceNo) {
		this.strInvoiceNo = strInvoiceNo;
	}
	public String getStrProcMode() {
		return strProcMode;
	}
	public void setStrProcMode(String strProcMode) {
		this.strProcMode = strProcMode;
	}
	public String[] getStrMultiInvoiceNo() {
		return strMultiInvoiceNo;
	}
	public void setStrMultiInvoiceNo(String[] strMultiInvoiceNo) {
		this.strMultiInvoiceNo = strMultiInvoiceNo;
	}
	public String[] getStrMultiInvoiceDate() {
		return strMultiInvoiceDate;
	}
	public void setStrMultiInvoiceDate(String[] strMultiInvoiceDate) {
		this.strMultiInvoiceDate = strMultiInvoiceDate;
	}
	public String[] getStrMultiInvoiceTax() {
		return strMultiInvoiceTax;
	}
	public void setStrMultiInvoiceTax(String[] strMultiInvoiceTax) {
		this.strMultiInvoiceTax = strMultiInvoiceTax;
	}
	public String[] getStrMultiInvoiceDisc() {
		return strMultiInvoiceDisc;
	}
	public void setStrMultiInvoiceDisc(String[] strMultiInvoiceDisc) {
		this.strMultiInvoiceDisc = strMultiInvoiceDisc;
	}
	public String[] getStrMultiInvoiceValue() {
		return strMultiInvoiceValue;
	}
	public void setStrMultiInvoiceValue(String[] strMultiInvoiceValue) {
		this.strMultiInvoiceValue = strMultiInvoiceValue;
	}
	public String[] getStrMultiInvoiceAmount() {
		return strMultiInvoiceAmount;
	}
	public void setStrMultiInvoiceAmount(String[] strMultiInvoiceAmount) {
		this.strMultiInvoiceAmount = strMultiInvoiceAmount;
	}
	public String getStrInvoiceNetValue() {
		return strInvoiceNetValue;
	}
	public void setStrInvoiceNetValue(String strInvoiceNetValue) {
		this.strInvoiceNetValue = strInvoiceNetValue;
	}
	public String getStrConcatPKey() {
		return strConcatPKey;
	}
	public void setStrConcatPKey(String strConcatPKey) {
		this.strConcatPKey = strConcatPKey;
	}
	public WebRowSet getWsInvoiceComboDtls() {
		return wsInvoiceComboDtls;
	}
	public void setWsInvoiceComboDtls(WebRowSet wsInvoiceComboDtls) {
		this.wsInvoiceComboDtls = wsInvoiceComboDtls;
	}
	public String getStrMultiInvoiceNoCombo() {
		return strMultiInvoiceNoCombo;
	}
	public void setStrMultiInvoiceNoCombo(String strMultiInvoiceNoCombo) {
		this.strMultiInvoiceNoCombo = strMultiInvoiceNoCombo;
	}
	public String[] getStrMultiPayInvoiceNo() {
		return strMultiPayInvoiceNo;
	}
	public void setStrMultiPayInvoiceNo(String[] strMultiPayInvoiceNo) {
		this.strMultiPayInvoiceNo = strMultiPayInvoiceNo;
	}
	public String[] getStrMultiPayInvoiceDate() {
		return strMultiPayInvoiceDate;
	}
	public void setStrMultiPayInvoiceDate(String[] strMultiPayInvoiceDate) {
		this.strMultiPayInvoiceDate = strMultiPayInvoiceDate;
	}
	public String[] getStrMultiPayInvoiceTax() {
		return strMultiPayInvoiceTax;
	}
	public void setStrMultiPayInvoiceTax(String[] strMultiPayInvoiceTax) {
		this.strMultiPayInvoiceTax = strMultiPayInvoiceTax;
	}
	public String[] getStrMultiPayInvoiceDisc() {
		return strMultiPayInvoiceDisc;
	}
	public void setStrMultiPayInvoiceDisc(String[] strMultiPayInvoiceDisc) {
		this.strMultiPayInvoiceDisc = strMultiPayInvoiceDisc;
	}
	public String[] getStrMultiPayInvoiceValue() {
		return strMultiPayInvoiceValue;
	}
	public void setStrMultiPayInvoiceValue(String[] strMultiPayInvoiceValue) {
		this.strMultiPayInvoiceValue = strMultiPayInvoiceValue;
	}
	public String[] getStrMultiPayInvoiceType() {
		return strMultiPayInvoiceType;
	}
	public void setStrMultiPayInvoiceType(String[] strMultiPayInvoiceType) {
		this.strMultiPayInvoiceType = strMultiPayInvoiceType;
	}
	public String[] getStrMultiPayInvoiceAmount() {
		return strMultiPayInvoiceAmount;
	}
	public void setStrMultiPayInvoiceAmount(String[] strMultiPayInvoiceAmount) {
		this.strMultiPayInvoiceAmount = strMultiPayInvoiceAmount;
	}
	public WebRowSet getWsRegisterPaymentDtls() {
		return wsRegisterPaymentDtls;
	}
	public void setWsRegisterPaymentDtls(WebRowSet wsRegisterPaymentDtls) {
		this.wsRegisterPaymentDtls = wsRegisterPaymentDtls;
	}
	public String getStrSeatUserName() {
		return strSeatUserName;
	}
	public void setStrSeatUserName(String strSeatUserName) {
		this.strSeatUserName = strSeatUserName;
	}

	private String strStatus = "";
	private String strFileName="";
	private String strPONo = "";
	private String strPONoCmb = "";
	private WebRowSet strPONoCmbWS = null;
	private String strPODate = "";
	private String strPOType = "";
	private String strPONetAmount = "";
	private String strAgentName = "";
	private String strCAName = "";
	private String strMaturityDate = "";
	private String strAgendaNo = "";
	private String strAgendaDate = "";
	private String strSupplierName = "";
	private String strSelScheduleNos = "";
	private String strScheduleNo = "";
	private String strReceiptNo = "";
	private String strReceiptDate = "";
	private String strItemName = "";
	private String strBrandName = "";
	private String strCurrencyId = "";
	private String strCurrencyName = "";
	private String strCurrencyValue = "";
	private String strRequiredQty = "0";
	private String strSuppliedQty = "0";
	private String strCurrentDate = "";
	private String strCurrentDateTime = "";
	private String strNetItemCost = "0";
	private String strNetPenalty = "0";
	private String []strScheduleNoArrH = null;
	private String []strScheduleCostArrH = {"0"};
	private String strAdvanceTaken = "0";
	private String strApprovedItemCost = "0";
	private String strApprovedPenalty = "0";
	private String strAdvanceAdjusted = "0";
	private String strBalanceItemCost = "0";
	private String strBalancePenalty = "0";
	private String strBalanceAdvance = "0";
	private String strTax = "0";
	private String strItemCost = "0";
	private String strTotalItemCost = "0";
	private String strOverallPOTax = "0";
	private String strTotalTaxAmount = "0";
	private String strBillAmount = "0";
	private String strMisclaneousAmount = "0";
	private String strSanctionedAmount = "0";
	private String strTaxUnit = "";
	private String strItemCategoryNoH = "";
	private String strItemCategoryNameH = "";
	private String strPOTypeId = "";
	private String strPOStoreId = "";
	private String strPOStoreName = "";
	private String strWaiveOffAmt = "";
	private String strWaiveOffApprovedBy = "";
	private String strWaiveOffApprovedDate = "";
	private String strFileExt="";
	private WebRowSet strWaiveOffApprovedByWS = null;
	private String strSearchListPODtlFromDate = "";
	private String strSearchListPODtlToDate = "";
	private String strSearchListPODetails = "";
	private WebRowSet wsPeneltyDtl=null;
	private String strBillNo = "";
	private String strBillDate = "";
	private String strBillType = "";
	private String strRemarks = "";
	private String strDisplayPODetails = "";
	private WebRowSet displayPODetails = null;
	private WebRowSet strScheduleDtlsWS = null;
	private WebRowSet strScheduleItemDtlsWS = null;
	private String strReceiptDetails = "";
	private WebRowSet receiptDetailsWs = null;
	private WebRowSet strOtherDetailsWs = null;
	private String strReceiptItemDetails = "";
	private WebRowSet receiptItemDetailsWs = null;
	
	private WebRowSet itemCostWs = null;
	public WebRowSet wsPrintItemDtls;
	
	
	private String strPaymentStatus="";
	private String strPaymentDate="";
	private String strUTRNo="";
	
	private String strPONetCost="";
	private String strSupplyNetCost="";
    private String strPreviousPaymentDtls="";
    public WebRowSet wsPaymentDtls;
    
    private String strInvoiceNo="";
    
    private String strProcMode="";
    
    private String strMultiInvoiceNo[];     // Consumable
	private String strMultiInvoiceDate[];      // Consumable 
	private String strMultiInvoiceTax[];   // Consumable
	private String strMultiInvoiceDisc[];// Consumable
	private String strMultiInvoiceValue[];  // Consumable
	private String strMultiInvoiceAmount[];
	
	private String strInvoiceNetValue="";
	
    private String strConcatPKey="";
    
    public WebRowSet wsInvoiceComboDtls;
	
    private String strMultiInvoiceNoCombo="";
	
    private String strMultiPayInvoiceNo[];     // Consumable
	private String strMultiPayInvoiceDate[];      // Consumable 
	private String strMultiPayInvoiceTax[];   // Consumable
	private String strMultiPayInvoiceDisc[];// Consumable
	private String strMultiPayInvoiceValue[];  // Consumable	
	private String strMultiPayInvoiceType[];     // Consumable

	
    private String strMultiPayInvoiceAmount[];  // Consumable
	
    public WebRowSet wsRegisterPaymentDtls;
	private String strSeatUserName="";
	
	
	public String getStrPODate() {
		return StrPODate;
	}
	public void setStrPODate(String strPODate) {
		StrPODate = strPODate;
	}
	public WebRowSet getStrPODetailsWs() {
		return strPODetailsWs;
	}
	public void setStrPODetailsWs(WebRowSet strPODetailsWs) {
		this.strPODetailsWs = strPODetailsWs;
	}
	public String getStrBillTypeId() {
		return strBillTypeId;
	}
	public void setStrBillTypeId(String strBillTypeId) {
		this.strBillTypeId = strBillTypeId;
	}
	public String getStrPoNoId() {
		return strPoNoId;
	}
	public void setStrPoNoId(String strPoNoId) {
		this.strPoNoId = strPoNoId;
	}

	private WebRowSet strPOSearchDetailsWs = null; 
	
	public String getStrSupplierId() {
		return strSupplierId;
	}
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}

	
	public WebRowSet getStrPOSearchDetailsWs() {
		return strPOSearchDetailsWs;
	}
	public void setStrPOSearchDetailsWs(WebRowSet strPOSearchDetailsWs) {
		this.strPOSearchDetailsWs = strPOSearchDetailsWs;
	}
	public WebRowSet getStrBillTypeWs() {
		return strBillTypeWs;
	}
	public void setStrBillTypeWs(WebRowSet strBillTypeWs) {
		this.strBillTypeWs = strBillTypeWs;
	}
	public WebRowSet getStrSupplierWs() {
		return strSupplierWs;
	}
	public void setStrSupplierWs(WebRowSet strSupplierWs) {
		this.strSupplierWs = strSupplierWs;
	}
	public String getStrPatientCategory() {
		return strPatientCategory;
	}
	public void setStrPatientCategory(String strPatientCategory) {
		this.strPatientCategory = strPatientCategory;
	}

	
	public String getStrPatientCategoryName() {
		return strPatientCategoryName;
	}
	public void setStrPatientCategoryName(String strPatientCategoryName) {
		this.strPatientCategoryName = strPatientCategoryName;
	}
	
	private String strByCurrentAndDate;

	public String getStrByCurrentAndDate() {
		return strByCurrentAndDate;
	}
	public void setStrByCurrentAndDate(String strByCurrentAndDate) {
		this.strByCurrentAndDate = strByCurrentAndDate;
	}
	public String getStrItemCatNo() {
		return strItemCatNo;
	}
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}
	public String getStrUserName() {
		return strUserName;
	}
	public void setStrUserName(String strUserName) {
		this.strUserName = strUserName;
	}
	private WebRowSet wsItemCategoryCombo = null;

	
	public WebRowSet getWsItemCategoryCombo() {
		return wsItemCategoryCombo;
	}
	public void setWsItemCategoryCombo(WebRowSet wsItemCategoryCombo) {
		this.wsItemCategoryCombo = wsItemCategoryCombo;
	}
	public String getStrLogoName() {
		return strLogoName;
	}
	public void setStrLogoName(String strLogoName) {
		this.strLogoName = strLogoName;
	}
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public String getStrItemCategoryId() {
		return strItemCategoryId;
	}
	public void setStrItemCategoryId(String strItemCategoryId) {
		this.strItemCategoryId = strItemCategoryId;
	}
	public String getStrItemCategoryName() {
		return strItemCategoryName;
	}
	public void setStrItemCategoryName(String strItemCategoryName) {
		this.strItemCategoryName = strItemCategoryName;
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
	public String getStrPatientGenderCode() {
		return strPatientGenderCode;
	}
	public void setStrPatientGenderCode(String strPatientGenderCode) {
		this.strPatientGenderCode = strPatientGenderCode;
	}
	
	private WebRowSet strItemCatWs = null;
	private WebRowSet strReqTypeWs = null;
	public WebRowSet getStrReqTypeWs() {
		return strReqTypeWs;
	}
	public void setStrReqTypeWs(WebRowSet strReqTypeWs) {
		this.strReqTypeWs = strReqTypeWs;
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
	/**
	 * @return the strStoreId
	 */
	public String getStrStoreId() {
		return strStoreId;
	}
	/**
	 * @param strStoreId the strStoreId to set
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	/**
	 * @return the strItemCatId
	 */
	public String getStrItemCatId() {
		return strItemCatId;
	}
	/**
	 * @param strItemCatId the strItemCatId to set
	 */
	public void setStrItemCatId(String strItemCatId) {
		this.strItemCatId = strItemCatId;
	}
	/**
	 * @return the strItemCatWs
	 */
	public WebRowSet getStrItemCatWs() {
		return strItemCatWs;
	}
	/**
	 * @param strItemCatWs the strItemCatWs to set
	 */
	public void setStrItemCatWs(WebRowSet strItemCatWs) {
		this.strItemCatWs = strItemCatWs;
	}
	/**
	 * @return the strStoreWs
	 */
	public WebRowSet getStrStoreWs() {
		return strStoreWs;
	}
	/**
	 * @param strStoreWs the strStoreWs to set
	 */
	public void setStrStoreWs(WebRowSet strStoreWs) {
		this.strStoreWs = strStoreWs;
	}
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}

}
