package mms.masters.controller.fb;

import org.apache.struts.action.ActionForm;

// TODO: Auto-generated Javadoc
/**
 * The Class MmsConfigMstFB.
 */
public class MmsConfigMstFB extends ActionForm {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The str err msg. */
	private String strErrMsg = "";
	
	/** The str normal msg. */
	private String strNormalMsg = "";

	private String strCtDate = "";
	
	private String strStoreId = "0";
	
	private String strCountryCode;

	private String strCountryCmb;

	private String strStateCode;

	private String strStateCmb;
	private String 	strIssueRateConfigFlg;
	private String 	strDemandActiveFlg;
	private String strDemandActivePrd;
	
	
	private String strWithOutCrNoFlg="0";

	private String strCrNoDefault;

	private String strDoseFrqChk="0";

	private String strReturnDrugValidity="0";

	private String strDoseFrqFlg="0";
	

	private String 	strConfigIssueRate="0";
	
	private String strChkFlg;
	
	private String strItemCatgCmb;
	private String strItemCatgId;
	private String strItemCategoryCode = "0";
	
	private String strIsPeriodAvailable = "0";
	
	private String strPeriodName = "";
	
	private String strPeriodId = "0";
	private String strBudgetFlg="0";
	
	/** The str financial start date. */
	private String strFinancialStartDate = "";
	
	/** The str financial end date. */
	private String strFinancialEndDate = "";

	private String strIsStockLedgerRequired = "0";
	
	private String strPreviousStockLedgerRequired = "0";
	private String strIndianDeliveryTime="";
	private String strImportedDeliveryTime="";
	private String strStoreDetailsValues = "";
	private String strResidualCost="";
	// Used in Item/Drug Inventory
	private String strExpAlertDays="0";
	// Issue Details
	/** The str issue mode. */
	private String strIssueMode = "0";
	
	/** The str last issue patient staff in days. */
	private String strLastIssuePatientStaffInDays = "0";
	
	/** The str last issue employee in days. */
	private String strLastIssueEmployeeInDays = "0";

	private String strOnlineIssueInDays = "0";
	
	private String strAutoReturnRequest = "0";
	
	private String strStaffSalePrice = "";
	private String strStaffSalePriceType = "";
	private String strNormalSalePrice = "";
	private String strNormalSalePriceType = "";
	
	
	private String strCategoryA = "0";
	private String strCategoryB1 = "0";
	private String strCategoryB2 = "0";
	private String strCategoryC = "0";
	
	private String strCategoryF = "0";
	private String strCategoryN1 = "0";
	private String strCategoryN2 = "0";
	private String strCategoryS = "0";
	
	private String strPurchaseTypeComboVals="";
	
	private String strPurchaseType="";
	
	private String strPenRejBreak="";
	
	private String 	strContractValue="0";
	private String strStampPaperAmt="0";
	
	private String strTaxRate="";
	
	private String strTinNo;
	
	private String strFMSIntegration = "0";
//	private String strDefaultHospCode="0";
	
	// Penalty Details

//	public String getStrDefaultHospCode() {
//		return strDefaultHospCode;
//	}
//
//	public void setStrDefaultHospCode(String strDefaultHospCode) {
//		this.strDefaultHospCode = strDefaultHospCode;
//	}

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

	/** The str from days. */
	private String[] strFromDays = null;
	
	/** The str to days. */
	private String[] strToDays = null;
	
	/** The str penalty. */
	private String[] strPenalty = null;

	/** The str multi row index. */
	private String strMultiRowIndex = "0";

	/** The str penalty details list. */
	private String strPenaltyDetailsList = "";

	/** The lhm. */
	java.util.LinkedHashMap<String, String> lhm = new java.util.LinkedHashMap<String, String>();
	
	private String strCommitteeFilePath="";
	private String strIndentLimitAmt="";
	
	
	private String strSeatId="";
	
	
	private String strBillingIntegration="";
	
	private String strWhetherSingleItemMultiSupplier="";
	
	private String strPurchaseLeadTime="";
	private String strSelfLife="";
	
	private String strSCMIntegration="";

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

	public String getStrBillingIntegration() {
		return strBillingIntegration;
	}

	public void setStrBillingIntegration(String strBillingIntegration) {
		this.strBillingIntegration = strBillingIntegration;
	}

	public String getStrSeatId() {
		return strSeatId;
	}

	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	public String getStrIndentLimitAmt() {
		return strIndentLimitAmt;
	}

	public void setStrIndentLimitAmt(String strIndentLimitAmt) {
		this.strIndentLimitAmt = strIndentLimitAmt;
	}

	public String getStrCommitteeFilePath() {
		return strCommitteeFilePath;
	}

	public void setStrCommitteeFilePath(String strCommitteeFilePath) {
		this.strCommitteeFilePath = strCommitteeFilePath;
	}

	/**
	 * Gets the lhm.
	 * 
	 * @return the lhm
	 */
	public java.util.LinkedHashMap<String, String> getLhm() {

		lhm.put("General", "mmsgeneraldtls");
		lhm.put("Issue Details", "mmsissuedtls");
		lhm.put("Penalty", "mmspenaltydtls");
		//lhm.put("Physical Stock Verification", "mmsphysicalstockverifydtls");
		//lhm.put("Report Parameters", "mmsreportParamdtls");
		return lhm;
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
	 * @param strIssueMode the new str issue mode
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
	 * @param strLastIssuePatientStaffInDays the new str last issue patient staff in days
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
	 * @param strLastIssueEmployeeInDays the new str last issue employee in days
	 */
	public void setStrLastIssueEmployeeInDays(String strLastIssueEmployeeInDays) {
		this.strLastIssueEmployeeInDays = strLastIssueEmployeeInDays;
	}

	/**
	 * Gets the str err msg.
	 * 
	 * @return the str err msg
	 */
	public String getStrErrMsg() {
		return strErrMsg;
	}

	/**
	 * Sets the str err msg.
	 * 
	 * @param strErrMsg the new str err msg
	 */
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}

	/**
	 * Gets the str normal msg.
	 * 
	 * @return the str normal msg
	 */
	public String getStrNormalMsg() {
		return strNormalMsg;
	}

	/**
	 * Sets the str normal msg.
	 * 
	 * @param strNormalMsg the new str normal msg
	 */
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}

	/**
	 * Gets the str financial start date.
	 * 
	 * @return the str financial start date
	 */
	public String getStrFinancialStartDate() {
		return strFinancialStartDate;
	}

	/**
	 * Sets the str financial start date.
	 * 
	 * @param strFinancialStartDate the new str financial start date
	 */
	public void setStrFinancialStartDate(String strFinancialStartDate) {
		this.strFinancialStartDate = strFinancialStartDate;
	}

	/**
	 * Gets the str financial end date.
	 * 
	 * @return the str financial end date
	 */
	public String getStrFinancialEndDate() {
		return strFinancialEndDate;
	}

	/**
	 * Sets the str financial end date.
	 * 
	 * @param strFinancialEndDate the new str financial end date
	 */
	public void setStrFinancialEndDate(String strFinancialEndDate) {
		this.strFinancialEndDate = strFinancialEndDate;
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
	 * @param strFromDays the new str from days
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
	 * @param strToDays the new str to days
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
	 * @param strPenalty the new str penalty
	 */
	public void setStrPenalty(String[] strPenalty) {
		this.strPenalty = strPenalty;
	}

	/**
	 * Gets the str penalty details list.
	 * 
	 * @return the str penalty details list
	 */
	public String getStrPenaltyDetailsList() {
		return strPenaltyDetailsList;
	}

	/**
	 * Sets the str penalty details list.
	 * 
	 * @param strPenaltyDetailsList the new str penalty details list
	 */
	public void setStrPenaltyDetailsList(String strPenaltyDetailsList) {
		this.strPenaltyDetailsList = strPenaltyDetailsList;
	}

	/**
	 * Gets the str multi row index.
	 * 
	 * @return the str multi row index
	 */
	public String getStrMultiRowIndex() {
		return strMultiRowIndex;
	}

	/**
	 * Sets the str multi row index.
	 * 
	 * @param strMultiRowIndex the new str multi row index
	 */
	public void setStrMultiRowIndex(String strMultiRowIndex) {
		this.strMultiRowIndex = strMultiRowIndex;
	}

	public String getStrAutoReturnRequest() {
		return strAutoReturnRequest;
	}

	public void setStrAutoReturnRequest(String strAutoReturnRequest) {
		this.strAutoReturnRequest = strAutoReturnRequest;
	}

	public String getStrIsStockLedgerRequired() {
		return strIsStockLedgerRequired;
	}

	public void setStrIsStockLedgerRequired(String strIsStockLedgerRequired) {
		this.strIsStockLedgerRequired = strIsStockLedgerRequired;
	}

	public String getStrStoreDetailsValues() {
		return strStoreDetailsValues;
	}

	public void setStrStoreDetailsValues(String strStoreDetailsValues) {
		this.strStoreDetailsValues = strStoreDetailsValues;
	}

	public String getStrPreviousStockLedgerRequired() {
		return strPreviousStockLedgerRequired;
	}

	public void setStrPreviousStockLedgerRequired(
			String strPreviousStockLedgerRequired) {
		this.strPreviousStockLedgerRequired = strPreviousStockLedgerRequired;
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

	public String getStrOnlineIssueInDays() {
		return strOnlineIssueInDays;
	}

	public void setStrOnlineIssueInDays(String strOnlineIssueInDays) {
		this.strOnlineIssueInDays = strOnlineIssueInDays;
	}

	public String getStrItemCategoryCode() {
		return strItemCategoryCode;
	}

	public void setStrItemCategoryCode(String strItemCategoryCode) {
		this.strItemCategoryCode = strItemCategoryCode;
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

	public String getStrPurchaseTypeComboVals() {
		return strPurchaseTypeComboVals;
	}

	public void setStrPurchaseTypeComboVals(String strPurchaseTypeComboVals) {
		this.strPurchaseTypeComboVals = strPurchaseTypeComboVals;
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

	public String getStrItemCatgCmb() {
		return strItemCatgCmb;
	}

	public void setStrItemCatgCmb(String strItemCatgCmb) {
		this.strItemCatgCmb = strItemCatgCmb;
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

	public String getStrCountryCmb() {
		return strCountryCmb;
	}

	public void setStrCountryCmb(String strCountryCmb) {
		this.strCountryCmb = strCountryCmb;
	}

	public String getStrStateCode() {
		return strStateCode;
	}

	public void setStrStateCode(String strStateCode) {
		this.strStateCode = strStateCode;
	}

	public String getStrStateCmb() {
		return strStateCmb;
	}

	public void setStrStateCmb(String strStateCmb) {
		this.strStateCmb = strStateCmb;
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

	public String getStrChkFlg() {
		return strChkFlg;
	}

	public void setStrChkFlg(String strChkFlg) {
		this.strChkFlg = strChkFlg;
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

	

}
