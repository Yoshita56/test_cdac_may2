package mms.transactions.controller.fb;

import hisglobal.masterutil.GenericFormBean;

import javax.sql.rowset.WebRowSet;

import org.apache.struts.upload.FormFile;

public class BillApprovalTransFB extends GenericFormBean {
	private static final long serialVersionUID = 02L;
	
	private String strErr = "";
	private String strMsg = "";
	private String strWarningMsg = "";
    private String strMsgString = "";
	private String strMsgType = "";
	private String strErrMsg = "";
	private String strNormalMsg="";
	private String strGroupId = "";
	private String strSeatId = "";
	private String strHospitalCode = "";
	private String strChk1 = "";
	private String strCtDate = "";
	private String strStoreId = "";
	private String strStoreName = "";
	private String strStatus = "";
	private String strPONo = "";
	private String strPOPrefix = "";
	private String strPONoCmb = "";
	private WebRowSet PONoCmbWS = null;
	private String strPODate = "";
	private String strPOType = "";
	private String strMaturityDate = "";
	private String strAgendaNo = "";
	private String strAgendaDate = "";
	private String strSupplierName = "";
	private String strPath = "";
	private String strItemName = "";
	private String strCurrencyId = "";
	private String strCurrencyName = "";
	private String strCurrencyValue = "";
	private String strPONetAmount = "";
	private String strAgentName = "";
	private String strAgentNameShow = "";
	private String strCAName = "";
	private String strWaiveOffApprovedDate = "";
	private String []strScheduleNoArrH = null;
	private String []strScheduleCostArrH = {"0"};
	private String strRequiredQty = "0";
	private String strSuppliedQty = "0";
	private String strCurrentDate = "";
	private String strNetItemCost = "0";
	private String strNetPenalty = "0";
	private String strAdvanceTaken = "0";
	private String strApprovedItemCost = "0";
	private String strApprovedPenalty = "0";
	private String strAdvanceAdjusted = "0";
	private String strBalanceItemCost = "0";
	private String strBalanceAdvance = "0";
	private String strTax = "0";
	private String strTotalItemCost = "0";
	private String strOverallPOTax = "0";
	private String strTotalTaxAmount = "0";
	private String strBillAmount = "0";
	private String strMisclaneousAmount = "0";
	private String strSanctionedAmount = "0";
	private String strBalancePenalty = "0";
	private String strBillNo = "";
	private String strBillDate = "";
	private String strBillType = "";
	private String strBillTypeName = "";
	private String strFreightChange = "";
	private String strTaxUnit = "";
	private String strItemCategoryNoH = "";
	private String strItemCategoryNameH = "";
	private String strPOTypeId = "";
	private String strSupplierId = "";
	private String strPOStoreId = "";
	private String strPOStoreName = "";
	private String strWaiveOffAmt = "";
	private String strWaiveOffApprovedBy = "";
	private String strSearchListPODtlFromDate = "";
	private String strSearchListPODtlToDate = "";
	private String strSearchListPODetails = "";
	private String strScheduleDetails = "";
	private String strOtherDetails = "";
	private WebRowSet strPODetailsWs = null;
	private String strRemarks = "";
	private String strDisplayPODetails = "";
	private WebRowSet displayPODetails = null;
	private String strReceiptDetails = "";
	private WebRowSet receiptDetailsWs = null;
	private String strReceiptItemDetails = "";
	private WebRowSet receiptItemDetailsWs = null;
	private String strItemCost = "";
	private WebRowSet itemCostWs = null;
	private FormFile strLocation=null;
	private String strPaymentStatus="";
	private String strPaymentDate="";
	private String strUTRNo="";
	private String strPONetCost="";
	private String strSupplyNetCost="";
	
	private String strPreviousPaymentDtls="";
	private String strInvoiceNetValue="";
	
	private String strMultiInvoiceNo[];     // Consumable
	private String strMultiInvoiceDate[];      // Consumable 
	private String strMultiInvoiceTax[];   // Consumable
	private String strMultiInvoiceDisc[];// Consumable
	private String strMultiInvoiceValue[];  // Consumable
	private String strMultiInvoiceAmount[];
	
	private String strConcatPKey="";
	private String strMultiInvoiceNoCombo="";
	
	private String strMultiPayInvoiceNo[];     // Consumable
	private String strMultiPayInvoiceDate[];      // Consumable 
	private String strMultiPayInvoiceTax[];   // Consumable
	private String strMultiPayInvoiceDisc[];// Consumable
	private String strMultiPayInvoiceValue[];  // Consumable
	private String strMultiPayInvoiceAmount[];  // Consumable
	private String strMultiPayInvoiceType[];     // Consumable
	
	
	private String strConsumableName[];     // Consumable
	private String strConsumableQty[];      // Consumable 
	private String strConsumableUnitId[];   // Consumable
	private String strConsumableArrangeBy[];// Consumable
	private String strConsumableQtyCost[];  // Consumable
	
	private String strPreviousInvoicePaymentDtls="";
	
	
	public String getStrPreviousInvoicePaymentDtls() {
		return strPreviousInvoicePaymentDtls;
	}
	public void setStrPreviousInvoicePaymentDtls(String strPreviousInvoicePaymentDtls) {
		this.strPreviousInvoicePaymentDtls = strPreviousInvoicePaymentDtls;
	}
	public String[] getStrMultiPayInvoiceType() {
		return strMultiPayInvoiceType;
	}
	public void setStrMultiPayInvoiceType(String[] strMultiPayInvoiceType) {
		this.strMultiPayInvoiceType = strMultiPayInvoiceType;
	}
	public String[] getStrConsumableName() {
		return strConsumableName;
	}
	public void setStrConsumableName(String[] strConsumableName) {
		this.strConsumableName = strConsumableName;
	}
	public String[] getStrConsumableQty() {
		return strConsumableQty;
	}
	public void setStrConsumableQty(String[] strConsumableQty) {
		this.strConsumableQty = strConsumableQty;
	}
	public String[] getStrConsumableUnitId() {
		return strConsumableUnitId;
	}
	public void setStrConsumableUnitId(String[] strConsumableUnitId) {
		this.strConsumableUnitId = strConsumableUnitId;
	}
	public String[] getStrConsumableArrangeBy() {
		return strConsumableArrangeBy;
	}
	public void setStrConsumableArrangeBy(String[] strConsumableArrangeBy) {
		this.strConsumableArrangeBy = strConsumableArrangeBy;
	}
	public String[] getStrConsumableQtyCost() {
		return strConsumableQtyCost;
	}
	public void setStrConsumableQtyCost(String[] strConsumableQtyCost) {
		this.strConsumableQtyCost = strConsumableQtyCost;
	}
	public String[] getStrMultiPayInvoiceAmount() {
		return strMultiPayInvoiceAmount;
	}
	public void setStrMultiPayInvoiceAmount(String[] strMultiPayInvoiceAmount) {
		this.strMultiPayInvoiceAmount = strMultiPayInvoiceAmount;
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
	public String getStrMultiInvoiceNoCombo() {
		return strMultiInvoiceNoCombo;
	}
	public void setStrMultiInvoiceNoCombo(String strMultiInvoiceNoCombo) {
		this.strMultiInvoiceNoCombo = strMultiInvoiceNoCombo;
	}
	public String getStrConcatPKey() {
		return strConcatPKey;
	}
	public void setStrConcatPKey(String strConcatPKey) {
		this.strConcatPKey = strConcatPKey;
	}
	public String getStrInvoiceNetValue() {
		return strInvoiceNetValue;
	}
	public void setStrInvoiceNetValue(String strInvoiceNetValue) {
		this.strInvoiceNetValue = strInvoiceNetValue;
	}
	public String[] getStrMultiInvoiceAmount() {
		return strMultiInvoiceAmount;
	}
	public void setStrMultiInvoiceAmount(String[] strMultiInvoiceAmount) {
		this.strMultiInvoiceAmount = strMultiInvoiceAmount;
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
	public String getStrPreviousPaymentDtls() {
		return strPreviousPaymentDtls;
	}
	public void setStrPreviousPaymentDtls(String strPreviousPaymentDtls) {
		this.strPreviousPaymentDtls = strPreviousPaymentDtls;
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
	/**
	 * @return the strLocation
	 */
	public FormFile getStrLocation() {
		return strLocation;
	}
	/**
	 * @param strLocation the strLocation to set
	 */
	public void setStrLocation(FormFile strLocation) {
		this.strLocation = strLocation;
	}
	public String getStrMsg() {
		return strMsg;
	}
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}
	public String getStrWarningMsg() {
		return strWarningMsg;
	}
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrChk1() {
		return strChk1;
	}
	public void setStrChk1(String strChk1) {
		this.strChk1 = strChk1;
	}
	public String getStrCtDate() {
		return strCtDate;
	}
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public String getStrStatus() {
		return strStatus;
	}
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}
	public String getStrPONo() {
		return strPONo;
	}
	public void setStrPONo(String strPONo) {
		this.strPONo = strPONo;
	}
	public String getStrPODate() {
		return strPODate;
	}
	public void setStrPODate(String strPODate) {
		this.strPODate = strPODate;
	}
	public String getStrPOType() {
		return strPOType;
	}
	public void setStrPOType(String strPOType) {
		this.strPOType = strPOType;
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

	public String getStrItemName() {
		return strItemName;
	}
	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
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
	public String getStrTotalItemCost() {
		return strTotalItemCost;
	}
	public void setStrTotalItemCost(String strTotalItemCost) {
		this.strTotalItemCost = strTotalItemCost;
	}
	public String getStrFreightChange() {
		return strFreightChange;
	}
	public void setStrFreightChange(String strFreightChange) {
		this.strFreightChange = strFreightChange;
	}
	public String getStrTax() {
		return strTax;
	}
	public void setStrTax(String strTax) {
		this.strTax = strTax;
	}
	public String getStrTaxUnit() {
		return strTaxUnit;
	}
	public void setStrTaxUnit(String strTaxUnit) {
		this.strTaxUnit = strTaxUnit;
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
	
	public WebRowSet getPONoCmbWS() {
		return PONoCmbWS;
	}
	public void setPONoCmbWS(WebRowSet noCmbWS) {
		PONoCmbWS = noCmbWS;
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
	public String getStrItemCost() {
		return strItemCost;
	}
	public void setStrItemCost(String strItemCost) {
		this.strItemCost = strItemCost;
	}
	public WebRowSet getItemCostWs() {
		return itemCostWs;
	}
	public void setItemCostWs(WebRowSet itemCostWs) {
		this.itemCostWs = itemCostWs;
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
	public String getStrErr() {
		return strErr;
	}
	public void setStrErr(String strErr) {
		this.strErr = strErr;
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
	public String getStrNormalMsg() {
		return strNormalMsg;
	}
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}
	public String getStrPath() {
		return strPath;
	}
	public void setStrPath(String strPath) {
		this.strPath = strPath;
	}
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	public String getStrItemCategoryNoH() {
		return strItemCategoryNoH;
	}
	public String getStrItemCategoryNameH() {
		return strItemCategoryNameH;
	}
	public String getStrPOTypeId() {
		return strPOTypeId;
	}
	public String getStrSupplierId() {
		return strSupplierId;
	}
	public String getStrPOStoreId() {
		return strPOStoreId;
	}
	public String getStrPOStoreName() {
		return strPOStoreName;
	}
	public String getStrSearchListPODtlFromDate() {
		return strSearchListPODtlFromDate;
	}
	public String getStrSearchListPODtlToDate() {
		return strSearchListPODtlToDate;
	}
	public String getStrSearchListPODetails() {
		return strSearchListPODetails;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}
	public void setStrItemCategoryNoH(String strItemCategoryNoH) {
		this.strItemCategoryNoH = strItemCategoryNoH;
	}
	public void setStrItemCategoryNameH(String strItemCategoryNameH) {
		this.strItemCategoryNameH = strItemCategoryNameH;
	}
	public void setStrPOTypeId(String strPOTypeId) {
		this.strPOTypeId = strPOTypeId;
	}
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}
	public void setStrPOStoreId(String strPOStoreId) {
		this.strPOStoreId = strPOStoreId;
	}
	public void setStrPOStoreName(String strPOStoreName) {
		this.strPOStoreName = strPOStoreName;
	}
	public void setStrSearchListPODtlFromDate(String strSearchListPODtlFromDate) {
		this.strSearchListPODtlFromDate = strSearchListPODtlFromDate;
	}
	public void setStrSearchListPODtlToDate(String strSearchListPODtlToDate) {
		this.strSearchListPODtlToDate = strSearchListPODtlToDate;
	}
	public void setStrSearchListPODetails(String strSearchListPODetails) {
		this.strSearchListPODetails = strSearchListPODetails;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public WebRowSet getStrPODetailsWs() {
		return strPODetailsWs;
	}
	public void setStrPODetailsWs(WebRowSet strPODetailsWs) {
		this.strPODetailsWs = strPODetailsWs;
	}
	public String getStrBillTypeName() {
		return strBillTypeName;
	}
	public void setStrBillTypeName(String strBillTypeName) {
		this.strBillTypeName = strBillTypeName;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getStrRequiredQty() {
		return strRequiredQty;
	}
	public String getStrSuppliedQty() {
		return strSuppliedQty;
	}
	public String getStrOverallPOTax() {
		return strOverallPOTax;
	}
	public void setStrRequiredQty(String strRequiredQty) {
		this.strRequiredQty = strRequiredQty;
	}
	public void setStrSuppliedQty(String strSuppliedQty) {
		this.strSuppliedQty = strSuppliedQty;
	}
	public void setStrOverallPOTax(String strOverallPOTax) {
		this.strOverallPOTax = strOverallPOTax;
	}
	public String getStrScheduleDetails() {
		return strScheduleDetails;
	}
	public String getStrOtherDetails() {
		return strOtherDetails;
	}
	public void setStrScheduleDetails(String strScheduleDetails) {
		this.strScheduleDetails = strScheduleDetails;
	}
	public void setStrOtherDetails(String strOtherDetails) {
		this.strOtherDetails = strOtherDetails;
	}
	public String getStrCurrencyId() {
		return strCurrencyId;
	}
	public String getStrCurrencyName() {
		return strCurrencyName;
	}
	public String getStrCurrencyValue() {
		return strCurrencyValue;
	}
	public void setStrCurrencyId(String strCurrencyId) {
		this.strCurrencyId = strCurrencyId;
	}
	public void setStrCurrencyName(String strCurrencyName) {
		this.strCurrencyName = strCurrencyName;
	}
	public void setStrCurrencyValue(String strCurrencyValue) {
		this.strCurrencyValue = strCurrencyValue;
	}
	public String[] getStrScheduleNoArrH() {
		return strScheduleNoArrH;
	}
	public String[] getStrScheduleCostArrH() {
		return strScheduleCostArrH;
	}
	public void setStrScheduleNoArrH(String[] strScheduleNoArrH) {
		this.strScheduleNoArrH = strScheduleNoArrH;
	}
	public void setStrScheduleCostArrH(String[] strScheduleCostArrH) {
		this.strScheduleCostArrH = strScheduleCostArrH;
	}
	public String getStrWaiveOffAmt() {
		return strWaiveOffAmt;
	}
	public String getStrWaiveOffApprovedBy() {
		return strWaiveOffApprovedBy;
	}
	public void setStrWaiveOffAmt(String strWaiveOffAmt) {
		this.strWaiveOffAmt = strWaiveOffAmt;
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
	public String getStrPONoCmb() {
		return strPONoCmb;
	}
	public void setStrPONoCmb(String strPONoCmb) {
		this.strPONoCmb = strPONoCmb;
	}
	public String getStrPOPrefix() {
		return strPOPrefix;
	}
	public void setStrPOPrefix(String strPOPrefix) {
		this.strPOPrefix = strPOPrefix;
	}
	public String getStrPONetAmount() {
		return strPONetAmount;
	}
	public String getStrAgentName() {
		return strAgentName;
	}
	public String getStrCAName() {
		return strCAName;
	}
	public void setStrPONetAmount(String strPONetAmount) {
		this.strPONetAmount = strPONetAmount;
	}
	public void setStrAgentName(String strAgentName) {
		this.strAgentName = strAgentName;
	}
	public void setStrCAName(String strCAName) {
		this.strCAName = strCAName;
	}
	public String getStrAgentNameShow() {
		return strAgentNameShow;
	}
	public void setStrAgentNameShow(String strAgentNameShow) {
		this.strAgentNameShow = strAgentNameShow;
	}
	


}
