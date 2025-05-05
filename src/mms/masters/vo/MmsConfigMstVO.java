package mms.masters.vo;

import hisglobal.utility.TransferObject;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * The Class MmsConfigMstVO.
 */
public class MmsConfigMstVO implements TransferObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The str msg string. */
	private String strMsgString = "";

	/** The str msg type. */
	private String strMsgType = "0";

	private String strStoreId = "0";

	private String strItemCategoryCode = "0";
	
	/** The str financial start date. */
	private String strFinancialStartDate = "";

	/** The str financial end date. */
	private String strFinancialEndDate = "";

	private String strIsStockLedgerRequired = "0";

	// Issue Details
	/** The str issue mode. */
	private String strIssueMode = "0";
	
	private String strDemandActivePrd;
	

	/** The str last issue patient staff in days. */
	private String strLastIssuePatientStaffInDays = "0";

	/** The str last issue employee in days. */
	private String strLastIssueEmployeeInDays = "0";

	private String strOnlineIssueInDays = "0";

	private String strStaffSalePrice = "";
	private String strStaffSalePriceType = "";
	private String strNormalSalePrice = "";
	private String strNormalSalePriceType = "";
	
	private String 	strDemandActiveFlg;
	
	// Used in Item/Drug Inventory
	private String strExpAlertDays="0";
	
	// Penalty Details
	/** The str from days. */
	private String[] strFromDays = null;

	/** The str to days. */
	private String[] strToDays = null;

	/** The str penalty. */
	private String[] strPenalty = null;

	private String strAutoReturnRequest = "0";

	private String strParamName = "";

	private String strIsPeriodAvailable = "0";
	
	private String strPeriodName = "";
	
	private String strPeriodId = "0";
	private String strItemCatgId;
	private String strBudgetFlg="0";
	
	private String strCommitteeFilePath="";
	private String strIndianDeliveryTime="";
	private String strImportedDeliveryTime="";
	
	private String strCountryCode;
	
	private String strStateCode;

	private String 	strIssueRateConfigFlg;

	private String 	strConfigIssueRate;
	
	/** The ws penalty details list. */
	private String strResidualCost="";
	private WebRowSet wsPenaltyDetailsList = null;

	private WebRowSet wsStoreDetailsList = null;

	private WebRowSet wsItemCategoryList = null;
	
	private WebRowSet wsCountryList = null;
	
	private WebRowSet wsStateList = null;
	
	private WebRowSet wsPeriodList = null;
	
	private WebRowSet wsPurchaseType=null;
	
	private String strCategoryA = "0";
	private String strCategoryB1 = "0";
	private String strCategoryB2 = "0";
	private String strCategoryC = "0";
	
	private String strCategoryF = "0";
	private String strCategoryN1 = "0";
	private String strCategoryN2 = "0";
	private String strCategoryS = "0";
	private String strPurchaseType="";
	private String strPenRejBreak="";
	/** The str hospital code. */
	private String strHospitalCode = "";

	/** The str seat id. */
	private String strSeatId = "";

	private String strPreviousStockLedgerRequired = "";

	private String strIpAddress = "";
	
	
	private String strWithOutCrNoFlg="0";

	private String strCrNoDefault;

	private String strDoseFrqChk="0";

	private String strReturnDrugValidity="0";

	private String strDoseFrqFlg="0";
	private String 	strContractValue="0";
	private String strStampPaperAmt="0";
	private String strPODemandActivePeriod="0";	
	private String  strBilingIntegration="";
	
	private String strTaxRate="";
	
	private String strWhetherSingleItemMultiSupplier="";
	
	private String strPurchaseLeadTime="";
	private String strSelfLife="";
	
	private String strSCMIntegration="0";
	//private String strDefaultHospCode="0";
	private String strTinNo;
	
	private String strFMSIntegration;

	private String strIndentLimitAmt;
	
	public String getStrIndentLimitAmt() {
		return strIndentLimitAmt;
	}

	public void setStrIndentLimitAmt(String strIndentLimitAmt) {
		this.strIndentLimitAmt = strIndentLimitAmt;
	}

	public String getStrFMSIntegration() {
		return strFMSIntegration;
	}

	public void setStrFMSIntegration(String strFMSIntegration) {
		this.strFMSIntegration = strFMSIntegration;
	}

	public String getStrTinNo() {
		return strTinNo;
	}

	public void setStrTinNo(String strTinNo) {
		this.strTinNo = strTinNo;
	}

	public String getStrSCMIntegration() {
		return strSCMIntegration;
	}

	public void setStrSCMIntegration(String strSCMIntegration) {
		this.strSCMIntegration = strSCMIntegration;
	}

	public String getStrPurchaseLeadTime() {
		return strPurchaseLeadTime;
	}

	public void setStrPurchaseLeadTime(String strPurchaseLeadTime) {
		this.strPurchaseLeadTime = strPurchaseLeadTime;
	}

	public String getStrSelfLife() {
		return strSelfLife;
	}

	public void setStrSelfLife(String strSelfLife) {
		this.strSelfLife = strSelfLife;
	}

	public String getStrWhetherSingleItemMultiSupplier() {
		return strWhetherSingleItemMultiSupplier;
	}

	public void setStrWhetherSingleItemMultiSupplier(
			String strWhetherSingleItemMultiSupplier) {
		this.strWhetherSingleItemMultiSupplier = strWhetherSingleItemMultiSupplier;
	}

	public String getStrTaxRate() {
		return strTaxRate;
	}

	public void setStrTaxRate(String strTaxRate) {
		this.strTaxRate = strTaxRate;
	}

	public String getStrBilingIntegration() {
		return strBilingIntegration;
	}

	public void setStrBilingIntegration(String strBilingIntegration) {
		this.strBilingIntegration = strBilingIntegration;
	}

	public String getStrContractValue() {
		return strContractValue;
	}

	public void setStrContractValue(String strContractValue) {
		this.strContractValue = strContractValue;
	}

	public String getStrStampPaperAmt() {
		return strStampPaperAmt;
	}

	public void setStrStampPaperAmt(String strStampPaperAmt) {
		this.strStampPaperAmt = strStampPaperAmt;
	}

	public String getStrWithOutCrNoFlg() {
		return strWithOutCrNoFlg;
	}

	public void setStrWithOutCrNoFlg(String strWithOutCrNoFlg) {
		this.strWithOutCrNoFlg = strWithOutCrNoFlg;
	}

	public String getStrCrNoDefault() {
		return strCrNoDefault;
	}

	public void setStrCrNoDefault(String strCrNoDefault) {
		this.strCrNoDefault = strCrNoDefault;
	}

	public String getStrDoseFrqChk() {
		return strDoseFrqChk;
	}

	public void setStrDoseFrqChk(String strDoseFrqChk) {
		this.strDoseFrqChk = strDoseFrqChk;
	}

	public String getStrReturnDrugValidity() {
		return strReturnDrugValidity;
	}

	public void setStrReturnDrugValidity(String strReturnDrugValidity) {
		this.strReturnDrugValidity = strReturnDrugValidity;
	}

	public String getStrDoseFrqFlg() {
		return strDoseFrqFlg;
	}

	public void setStrDoseFrqFlg(String strDoseFrqFlg) {
		this.strDoseFrqFlg = strDoseFrqFlg;
	}

	public String getStrPreviousStockLedgerRequired() {
		return strPreviousStockLedgerRequired;
	}

	public void setStrPreviousStockLedgerRequired(
			String strPreviousStockLedgerRequired) {
		this.strPreviousStockLedgerRequired = strPreviousStockLedgerRequired;
	}

	public String getStrIpAddress() {
		return strIpAddress;
	}

	public void setStrIpAddress(String strIpAddress) {
		this.strIpAddress = strIpAddress;
	}

	/**
	 * Gets the str hospital code.
	 * 
	 * @return the str hospital code
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	/**
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode
	 *            the new str hospital code
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Gets the str seat id.
	 * 
	 * @return the str seat id
	 */
	public String getStrSeatId() {
		return strSeatId;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param strSeatId
	 *            the new str seat id
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * Gets the str from days.
	 * 
	 * @return the str from days
	 */
	public String[] getStrFromDays() {
		return strFromDays;
	}

	/**
	 * Sets the str from days.
	 * 
	 * @param strFromDays
	 *            the new str from days
	 */
	public void setStrFromDays(String[] strFromDays) {
		this.strFromDays = strFromDays;
	}

	/**
	 * Gets the str to days.
	 * 
	 * @return the str to days
	 */
	public String[] getStrToDays() {
		return strToDays;
	}

	/**
	 * Sets the str to days.
	 * 
	 * @param strToDays
	 *            the new str to days
	 */
	public void setStrToDays(String[] strToDays) {
		this.strToDays = strToDays;
	}

	/**
	 * Gets the str penalty.
	 * 
	 * @return the str penalty
	 */
	public String[] getStrPenalty() {
		return strPenalty;
	}

	/**
	 * Sets the str penalty.
	 * 
	 * @param strPenalty
	 *            the new str penalty
	 */
	public void setStrPenalty(String[] strPenalty) {
		this.strPenalty = strPenalty;
	}

	/**
	 * Gets the ws penalty details list.
	 * 
	 * @return the ws penalty details list
	 */
	public WebRowSet getWsPenaltyDetailsList() {
		return wsPenaltyDetailsList;
	}

	/**
	 * Sets the ws penalty details list.
	 * 
	 * @param wsPenaltyDetailsList
	 *            the new ws penalty details list
	 */
	public void setWsPenaltyDetailsList(WebRowSet wsPenaltyDetailsList) {
		this.wsPenaltyDetailsList = wsPenaltyDetailsList;
	}

	/**
	 * Gets the str issue mode.
	 * 
	 * @return the str issue mode
	 */
	public String getStrIssueMode() {
		return strIssueMode;
	}

	/**
	 * Sets the str issue mode.
	 * 
	 * @param strIssueMode
	 *            the new str issue mode
	 */
	public void setStrIssueMode(String strIssueMode) {
		this.strIssueMode = strIssueMode;
	}

	/**
	 * Gets the str last issue patient staff in days.
	 * 
	 * @return the str last issue patient staff in days
	 */
	public String getStrLastIssuePatientStaffInDays() {
		return strLastIssuePatientStaffInDays;
	}

	/**
	 * Sets the str last issue patient staff in days.
	 * 
	 * @param strLastIssuePatientStaffInDays
	 *            the new str last issue patient staff in days
	 */
	public void setStrLastIssuePatientStaffInDays(
			String strLastIssuePatientStaffInDays) {
		this.strLastIssuePatientStaffInDays = strLastIssuePatientStaffInDays;
	}

	/**
	 * Gets the str last issue employee in days.
	 * 
	 * @return the str last issue employee in days
	 */
	public String getStrLastIssueEmployeeInDays() {
		return strLastIssueEmployeeInDays;
	}

	/**
	 * Sets the str last issue employee in days.
	 * 
	 * @param strLastIssueEmployeeInDays
	 *            the new str last issue employee in days
	 */
	public void setStrLastIssueEmployeeInDays(String strLastIssueEmployeeInDays) {
		this.strLastIssueEmployeeInDays = strLastIssueEmployeeInDays;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.utility.TransferObject#getStrMsgString()
	 */
	public String getStrMsgString() {
		return strMsgString;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.utility.TransferObject#setStrMsgString(java.lang.String)
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.utility.TransferObject#getStrMsgType()
	 */
	public String getStrMsgType() {
		return strMsgType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.utility.TransferObject#setStrMsgType(java.lang.String)
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	public String getStrStoreId() {
		return strStoreId;
	}

	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
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

	public String getStrAutoReturnRequest() {
		return strAutoReturnRequest;
	}

	public void setStrAutoReturnRequest(String strAutoReturnRequest) {
		this.strAutoReturnRequest = strAutoReturnRequest;
	}

	public String getStrParamName() {
		return strParamName;
	}

	public void setStrParamName(String strParamName) {
		this.strParamName = strParamName;
	}

	public WebRowSet getWsStoreDetailsList() {
		return wsStoreDetailsList;
	}

	public void setWsStoreDetailsList(WebRowSet wsStoreDetailsList) {
		this.wsStoreDetailsList = wsStoreDetailsList;
	}

	public String getStrIsStockLedgerRequired() {
		return strIsStockLedgerRequired;
	}

	public void setStrIsStockLedgerRequired(String strIsStockLedgerRequired) {
		this.strIsStockLedgerRequired = strIsStockLedgerRequired;
	}

	public String getStrOnlineIssueInDays() {
		return strOnlineIssueInDays;
	}

	public void setStrOnlineIssueInDays(String strOnlineIssueInDays) {
		this.strOnlineIssueInDays = strOnlineIssueInDays;
	}

	public WebRowSet getWsItemCategoryList() {
		return wsItemCategoryList;
	}

	public void setWsItemCategoryList(WebRowSet wsItemCategoryList) {
		this.wsItemCategoryList = wsItemCategoryList;
	}

	public WebRowSet getWsPeriodList() {
		return wsPeriodList;
	}

	public void setWsPeriodList(WebRowSet wsPeriodList) {
		this.wsPeriodList = wsPeriodList;
	}

	public String getStrIsPeriodAvailable() {
		return strIsPeriodAvailable;
	}

	public void setStrIsPeriodAvailable(String strIsPeriodAvailable) {
		this.strIsPeriodAvailable = strIsPeriodAvailable;
	}

	public String getStrPeriodName() {
		return strPeriodName;
	}

	public void setStrPeriodName(String strPeriodName) {
		this.strPeriodName = strPeriodName;
	}

	public String getStrPeriodId() {
		return strPeriodId;
	}

	public void setStrPeriodId(String strPeriodId) {
		this.strPeriodId = strPeriodId;
	}

	public String getStrItemCategoryCode() {
		return strItemCategoryCode;
	}

	public void setStrItemCategoryCode(String strItemCategoryCode) {
		this.strItemCategoryCode = strItemCategoryCode;
	}

	public String getStrCategoryA() {
		return strCategoryA;
	}

	public void setStrCategoryA(String strCategoryA) {
		this.strCategoryA = strCategoryA;
	}

	public String getStrCategoryB1() {
		return strCategoryB1;
	}

	public void setStrCategoryB1(String strCategoryB1) {
		this.strCategoryB1 = strCategoryB1;
	}

	public String getStrCategoryB2() {
		return strCategoryB2;
	}

	public void setStrCategoryB2(String strCategoryB2) {
		this.strCategoryB2 = strCategoryB2;
	}

	public String getStrCategoryC() {
		return strCategoryC;
	}

	public void setStrCategoryC(String strCategoryC) {
		this.strCategoryC = strCategoryC;
	}

	public String getStrCategoryF() {
		return strCategoryF;
	}

	public void setStrCategoryF(String strCategoryF) {
		this.strCategoryF = strCategoryF;
	}

	public String getStrCategoryN1() {
		return strCategoryN1;
	}

	public void setStrCategoryN1(String strCategoryN1) {
		this.strCategoryN1 = strCategoryN1;
	}

	public String getStrCategoryN2() {
		return strCategoryN2;
	}

	public void setStrCategoryN2(String strCategoryN2) {
		this.strCategoryN2 = strCategoryN2;
	}

	public String getStrCategoryS() {
		return strCategoryS;
	}

	public void setStrCategoryS(String strCategoryS) {
		this.strCategoryS = strCategoryS;
	}

	public WebRowSet getWsPurchaseType() {
		return wsPurchaseType;
	}

	public void setWsPurchaseType(WebRowSet wsPurchaseType) {
		this.wsPurchaseType = wsPurchaseType;
	}

	public String getStrPurchaseType() {
		return strPurchaseType;
	}

	public void setStrPurchaseType(String strPurchaseType) {
		this.strPurchaseType = strPurchaseType;
	}

	public String getStrPenRejBreak() {
		return strPenRejBreak;
	}

	public void setStrPenRejBreak(String strPenRejBreak) {
		this.strPenRejBreak = strPenRejBreak;
	}

	public String getStrCommitteeFilePath() {
		return strCommitteeFilePath;
	}

	public void setStrCommitteeFilePath(String strCommitteeFilePath) {
		this.strCommitteeFilePath = strCommitteeFilePath;
	}

	/**
	 * @return the strIndianDeliveryTime
	 */
	public String getStrIndianDeliveryTime() {
		return strIndianDeliveryTime;
	}

	/**
	 * @param strIndianDeliveryTime the strIndianDeliveryTime to set
	 */
	public void setStrIndianDeliveryTime(String strIndianDeliveryTime) {
		this.strIndianDeliveryTime = strIndianDeliveryTime;
	}

	/**
	 * @return the strImportedDeliveryTime
	 */
	public String getStrImportedDeliveryTime() {
		return strImportedDeliveryTime;
	}

	/**
	 * @param strImportedDeliveryTime the strImportedDeliveryTime to set
	 */
	public void setStrImportedDeliveryTime(String strImportedDeliveryTime) {
		this.strImportedDeliveryTime = strImportedDeliveryTime;
	}

	/**
	 * @return the strResidualCost
	 */
	public String getStrResidualCost() {
		return strResidualCost;
	}

	/**
	 * @param strResidualCost the strResidualCost to set
	 */
	public void setStrResidualCost(String strResidualCost) {
		this.strResidualCost = strResidualCost;
	}

	/**
	 * @return the strStaffSalePrice
	 */
	public String getStrStaffSalePrice() {
		return strStaffSalePrice;
	}

	/**
	 * @param strStaffSalePrice the strStaffSalePrice to set
	 */
	public void setStrStaffSalePrice(String strStaffSalePrice) {
		this.strStaffSalePrice = strStaffSalePrice;
	}

	/**
	 * @return the strStaffSalePriceType
	 */
	public String getStrStaffSalePriceType() {
		return strStaffSalePriceType;
	}

	/**
	 * @param strStaffSalePriceType the strStaffSalePriceType to set
	 */
	public void setStrStaffSalePriceType(String strStaffSalePriceType) {
		this.strStaffSalePriceType = strStaffSalePriceType;
	}

	/**
	 * @return the strNormalSalePrice
	 */
	public String getStrNormalSalePrice() {
		return strNormalSalePrice;
	}

	/**
	 * @param strNormalSalePrice the strNormalSalePrice to set
	 */
	public void setStrNormalSalePrice(String strNormalSalePrice) {
		this.strNormalSalePrice = strNormalSalePrice;
	}

	/**
	 * @return the strNormalSalePriceType
	 */
	public String getStrNormalSalePriceType() {
		return strNormalSalePriceType;
	}

	/**
	 * @param strNormalSalePriceType the strNormalSalePriceType to set
	 */
	public void setStrNormalSalePriceType(String strNormalSalePriceType) {
		this.strNormalSalePriceType = strNormalSalePriceType;
	}

	public String getStrExpAlertDays() {
		return strExpAlertDays;
	}

	public void setStrExpAlertDays(String strExpAlertDays) {
		this.strExpAlertDays = strExpAlertDays;
	}

	public String getStrItemCatgId() {
		return strItemCatgId;
	}

	public void setStrItemCatgId(String strItemCatgId) {
		this.strItemCatgId = strItemCatgId;
	}

	public String getStrCountryCode() {
		return strCountryCode;
	}

	public void setStrCountryCode(String strCountryCode) {
		this.strCountryCode = strCountryCode;
	}

	public String getStrStateCode() {
		return strStateCode;
	}

	public void setStrStateCode(String strStateCode) {
		this.strStateCode = strStateCode;
	}

	public WebRowSet getWsCountryList() {
		return wsCountryList;
	}

	public void setWsCountryList(WebRowSet wsCountryList) {
		this.wsCountryList = wsCountryList;
	}

	public WebRowSet getWsStateList() {
		return wsStateList;
	}

	public void setWsStateList(WebRowSet wsStateList) {
		this.wsStateList = wsStateList;
	}

	public String getStrIssueRateConfigFlg() {
		return strIssueRateConfigFlg;
	}

	public void setStrIssueRateConfigFlg(String strIssueRateConfigFlg) {
		this.strIssueRateConfigFlg = strIssueRateConfigFlg;
	}

	public String getStrConfigIssueRate() {
		return strConfigIssueRate;
	}

	public void setStrConfigIssueRate(String strConfigIssueRate) {
		this.strConfigIssueRate = strConfigIssueRate;
	}

	public String getStrBudgetFlg() {
		return strBudgetFlg;
	}

	public void setStrBudgetFlg(String strBudgetFlg) {
		this.strBudgetFlg = strBudgetFlg;
	}

	public String getStrDemandActiveFlg() {
		return strDemandActiveFlg;
	}

	public void setStrDemandActiveFlg(String strDemandActiveFlg) {
		this.strDemandActiveFlg = strDemandActiveFlg;
	}

	public String getStrDemandActivePrd() {
		return strDemandActivePrd;
	}

	public void setStrDemandActivePrd(String strDemandActivePrd) {
		this.strDemandActivePrd = strDemandActivePrd;
	}

	public String getStrPODemandActivePeriod() {
		return strPODemandActivePeriod;
	}

	public void setStrPODemandActivePeriod(String strPODemandActivePeriod) {
		this.strPODemandActivePeriod = strPODemandActivePeriod;
	}


//	public String getStrDefaultHospCode() {
//		return strDefaultHospCode;
//	}
//
//	public void setStrDefaultHospCode(String strDefaultHospCode) {
//		this.strDefaultHospCode = strDefaultHospCode;
//	}
}
