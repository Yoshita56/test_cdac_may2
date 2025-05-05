package mms;
import hisglobal.transactionmgnt.HisDAO;

import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;

import mms.masters.dao.MmsConfigMstDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class VOMms.
 */
public class VOMms implements java.io.Serializable{

	public VOMms(String hospitalCode) 
	{
		WebRowSet wb=null;
		String tmp_ParamName="";
		String tmp_ParamValue="";
		
		String qry = mms.qryHandler_mms.getQuery(1, "select.mmsconfig.51");
		HisDAO hisDao = new HisDAO("MMS","MmsConfigMstBO.selectQuery()");
		
		try 
		{
			int qryIndex = hisDao.setQuery(qry);
			hisDao.setQryValue(qryIndex, 1, hospitalCode);
			wb=hisDao.executeQry(qryIndex);
			
			while(wb.next())
			{
				tmp_ParamName=wb.getString(1);
				tmp_ParamValue=wb.getString(2);
				if(tmp_ParamName.equals("STORE_NAME"))
					this.setStrStoreId(tmp_ParamValue);
				else if(tmp_ParamName.equals("EXPIRY_ALERT_DAYS"))
					this.setStrExpAlertDays(tmp_ParamValue);
				else if(tmp_ParamName.equals("RESIDUAL_COST_AUCTION"))
					this.setStrResidualCost(tmp_ParamValue);
				else if(tmp_ParamName.equals("ITEM_CATEGORY")){
					//this.setStrItemCategoryCode(tmp_ParamValue);
					this.setStrItemCatgId(tmp_ParamValue);
					this.setStrStoreConfigCatg(tmp_ParamValue);
				}
				else if(tmp_ParamName.equals("DEFAULT_COUNTRY"))
					this.setStrCountryCode(tmp_ParamValue);
				else if(tmp_ParamName.equals("DEFAULT_STATE"))
					this.setStrStateCode(tmp_ParamValue);
				else if(tmp_ParamName.equals("INDIAN_DELIVERY_TIME"))
					this.setStrIndianDeliveryTime(tmp_ParamValue);
				else if(tmp_ParamName.equals("IMPORTED_DELIVERY_TIME"))
					this.setStrImportedDeliveryTime(tmp_ParamValue);
				else if(tmp_ParamName.equals("CONTRACT_VALUE"))
					this.setStrContractValue(tmp_ParamValue);
				else if(tmp_ParamName.equals("STAMP_PAPER_AMOUNT"))
					this.setStrStampPaperAmt(tmp_ParamValue);
				else if(tmp_ParamName.equals("PATH_COMMITTEE_RECOMENDATION"))
					this.setStrCommitteeFilePath(tmp_ParamValue);
				else if(tmp_ParamName.equals("BILL_INTEGRATION"))
					this.setStrBillingIntegration(tmp_ParamValue);
				
				else if(tmp_ParamName.equals("TAX_RATE"))
					this.setStrTaxRate(tmp_ParamValue);
				
				else if(tmp_ParamName.equals("SINGLE_ITEM_MULTI_SUPPLIER"))
					this.setStrWhetherSingleItemMultiSupplier(tmp_ParamValue);
				
				else if(tmp_ParamName.equals("WHETHER_KEEP_DEMAND_ACTIVE_AT_PARTIAL_ISSUE"))
					this.setStrDemandActiveFlg(tmp_ParamValue);
				else if(tmp_ParamName.equals("DEMAND_ACTIVE_PERIOD"))
					this.setStrDemandActivePrd(tmp_ParamValue);
				else if(tmp_ParamName.equals("WHETHER_WITHOUT_CRNO_OPTION_REQUIRED"))
					this.setStrWithOutCrNoFlg(tmp_ParamValue);
				else if(tmp_ParamName.equals("CR_NO_REQ_WITH_OR_WITHOUR_CR_NO"))
					this.setStrCrNoDefault(tmp_ParamValue);
				else if(tmp_ParamName.equals("WHETHER_DOSAGE_FREQ_DAYS_INFO_NEED_CAPTURE"))
					this.setStrDoseFrqFlg(tmp_ParamValue);
				else if(tmp_ParamName.equals("RETURN_ITEM_VALIDITY"))
					this.setStrReturnDrugValidity(tmp_ParamValue);
				else if(tmp_ParamName.equals("ISSUE_MODE"))
					this.setStrIssueMode(tmp_ParamValue);
				else if(tmp_ParamName.equals("ONLINE_ISSUE_IN_DAYS")){
					this.setStrOnlineIssueInDays(tmp_ParamValue);
					this.setStrOnlineIssueDetailsInDays(tmp_ParamValue);
				}
				else if(tmp_ParamName.equals("INCASE_PATIENT_STAFF_ITEM_DAYS"))
					this.setStrLastIssuePatientStaffInDays(tmp_ParamValue);
				else if(tmp_ParamName.equals("INCASE_EMPLOYEE_NONCONSUMABLE_DAYS"))
					this.setStrLastIssueEmployeeInDays(tmp_ParamValue);
				else if(tmp_ParamName.equals("AUTO_RETURN_REQUEST_INCASE_OF_LP"))
					this.setStrAutoReturnRequest(tmp_ParamValue);
				else if(tmp_ParamName.equals("ISSUE_RATE_STAFF"))
					this.setStrStaffSalePrice(tmp_ParamValue);
				else if(tmp_ParamName.equals("ISSUE_RATE_STAFF_PRICE_TYPE"))
					this.setStrStaffSalePriceType(tmp_ParamValue);
				else if(tmp_ParamName.equals("ISSUE_RATE_NORMAL"))
					this.setStrNormalSalePrice(tmp_ParamValue);
				else if(tmp_ParamName.equals("ISSUE_RATE_NORMAL_PRICE_TYPE"))
					this.setStrNormalSalePriceType(tmp_ParamValue);
				
				else if(tmp_ParamName.equals("PHY_STOCK_VERIFY_STORE"))
					this.setStrStoreId(tmp_ParamValue);
				else if(tmp_ParamName.equals("PHY_STOCK_VERIFY_ITEM_CAT")){
					this.setStrItemCategoryCode(tmp_ParamValue);
					//this.setStrItemCatgId(tmp_ParamValue);
					//this.setStrStoreConfigCatg(tmp_ParamValue);
				}
				else if(tmp_ParamName.equals("PHY_STOCK_VERIFY_PERIOD"))
					this.setStrPeriodId(tmp_ParamValue);
				else if(tmp_ParamName.equals("PHY_STOCK_VERIFY_STOCK_LEDGER_REQD"))
					this.setStrIsStockLedgerRequired(tmp_ParamValue);
				
				else if(tmp_ParamName.equals("PENALTY_INCASE_REJECTED_BREAKAGE"))
					this.setStrPenRejBreak(tmp_ParamValue);
				else if(tmp_ParamName.equals("PURCHASE_TYPE"))
					this.setStrPurchaseType(tmp_ParamValue);
				
				else if(tmp_ParamName.equals("ABC_ANALYSIS_A"))
					this.setStrCategoryA(tmp_ParamValue);
				else if(tmp_ParamName.equals("ABC_ANALYSIS_B1"))
					this.setStrCategoryB1(tmp_ParamValue);
				else if(tmp_ParamName.equals("ABC_ANALYSIS_B2"))
					this.setStrCategoryB2(tmp_ParamValue);
				else if(tmp_ParamName.equals("ABC_ANALYSIS_C"))
					this.setStrCategoryC(tmp_ParamValue);
				else if(tmp_ParamName.equals("FSN_XYZ_ANALYSIS_F_X"))
					this.setStrCategoryF(tmp_ParamValue);
				else if(tmp_ParamName.equals("FSN_XYZ_ANALYSIS_N_Y1"))
					this.setStrCategoryN1(tmp_ParamValue);
				else if(tmp_ParamName.equals("FSN_XYZ_ANALYSIS_N_Y2"))
					this.setStrCategoryN2(tmp_ParamValue);
				else if(tmp_ParamName.equals("FSN_XYZ_ANALYSIS_S_Z"))
					this.setStrCategoryS(tmp_ParamValue);
				else if(tmp_ParamName.equals("TAX_RATE"))
					this.setStrTax(tmp_ParamValue);
				
				else if(tmp_ParamName.equals("PURCHASE_LEAD_TIME"))
					this.setStrPurchaseLeadTime(tmp_ParamValue);
				
				else if(tmp_ParamName.equals("SELF_LIFE"))
					this.setStrSelfLife(tmp_ParamValue);
				else if(tmp_ParamName.equals("SCM_INTEGRATION"))
					this.setStrSCMIntegration(tmp_ParamValue);
				
				else if(tmp_ParamName.equals("TIN_NO"))
					this.setStrTinNo(tmp_ParamValue);
				else if(tmp_ParamName.equals("FMS_INTEGRATION"))
					this.setStrFMSIntegration(tmp_ParamValue);
				else if(tmp_ParamName.equals("OSTF_INDENT_LIMIT_AMT"))
					this.setStrIndentLimitAmt(tmp_ParamValue);
				
				
				
			}			
		}
		catch (Exception e) 
		{
				e.printStackTrace();				
		}
		finally
		{
			try 
			{
				if (wb != null) 
				{
						wb.close();
						wb=null;
				}
				if (hisDao != null) 
				{
						hisDao.free();
						hisDao = null;
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}				
	}
	
	//////////////////    fb   ///////////////////
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
	private String strDemandActivePrd="0";
	private String strIndentLimitAmt;
	
	private String strWithOutCrNoFlg="0";

	private String strCrNoDefault;

	private String strDoseFrqChk="0";

	private String strReturnDrugValidity="0";

	private String strDoseFrqFlg="0";
	

	private String 	strConfigIssueRate="";
	
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
	
	private String strPurchaseLeadTime="";
	private String strSelfLife="";
	
	private String strTinNo;
	private String strFMSIntegration;
	
	// Penalty Details

	public String getStrFMSIntegration() {
		return strFMSIntegration;
	}

	public void setStrFMSIntegration(String strFMSIntegration) {
		this.strFMSIntegration = strFMSIntegration;
	}

	public void setStrTinNo(String strTinNo) {
		this.strTinNo = strTinNo;
	}

	public String getStrTinNo() {
		return strTinNo;
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
	private String strTax;
	
	private String strSCMIntegration="";

	public String getStrSCMIntegration() {
		return strSCMIntegration;
	}

	public void setStrSCMIntegration(String strSCMIntegration) {
		this.strSCMIntegration = strSCMIntegration;
	}

	public String getStrTax() {
		return strTax;
	}

	public void setStrTax(String strTax) {
		this.strTax = strTax;
	}

	/** The lhm. */
	java.util.LinkedHashMap<String, String> lhm = new java.util.LinkedHashMap<String, String>();
	
	private String strCommitteeFilePath="";
	//////////////////   fb   ///////////////////
	
	
/////////////////// mmsconfigutil variable start /////////////////////
	private String strOnlineIssueDetailsInDays = "";

	/** The Constant MODULE_ID. */
	public static final String MODULE_ID = "63";

	/** The Constant UNIT_ID. */
	public static final String UNIT_ID = "6301";

	/** The Constant STAFF_CAT_CODE. */
	public static final String STAFF_CAT_CODE = "12";

	/** The Constant PHY_STOCK_ITEM_PER_PAGE. */
	public static final String PHY_STOCK_ITEM_PER_PAGE = "40";

	/** The Constant DEFAULT_CURRENCY_CODE. */
	public static final String DEFAULT_CURRENCY_CODE = "100"; // Default
	// Currency Code
	// INR.

	/** The Constant SUPPLIER_BILL. */
	public static final String SUPPLIER_BILL = "10";
	/** The Constant GLOBAL_HOSPITAL_CODE. */
	public static final String GLOBAL_HOSPITAL_CODE = "100"; //Global Hospital Code
	
	/** The str batch no. */
	public String strBatchNo = "0";

	public String strACategory = "0";
	public String strB1Category = "0";
	public String strB2Category = "0";
	public String strCCategory = "0";

	public String strFCategory = "0";
	public String strN1Category = "0";
	public String strN2Category = "0";
	public String strSCategory = "0";
	private String strCostReq = "0";
	private String strWinLocation = "";
	private String strLinLocation = "";
	/* Added by Amit Kumar */
	private String strStoreConfigCatg = "0";
	public static String strPODemnadValidity = "";
	
	////////////////////mmsconfigutil variable end  /////////////
	
	/** The str msg string. */
	private String strMsgString = "";
	
	/** The str msg type. */
	private String strMsgType = "";

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str store type id. */
	private String strStoreTypeId = "";

	/** The group ws. */
	private WebRowSet groupWs = null;
	
	/*Billing Integration.*/
	private String strBillingIntegration="";
	
	private String strTaxRate="";
	
	private String strWhetherSingleItemMultiSupplier="";

	/**
	 * Gets the group ws.
	 * 
	 * @return the group ws
	 */
	public WebRowSet getGroupWs() {
		return groupWs;
	}

	/**
	 * Sets the group ws.
	 * 
	 * @param groupWs the new group ws
	 */
	public void setGroupWs(WebRowSet groupWs) {
		this.groupWs = groupWs;
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
	 * @param strHospitalCode the new str hospital code
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Gets the str store type id.
	 * 
	 * @return the str store type id
	 */
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}

	/**
	 * Sets the str store type id.
	 * 
	 * @param strStoreTypeId the new str store type id
	 */
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}

	/**
	 * Gets the str msg string.
	 * 
	 * @return the str msg string
	 */
	public String getStrMsgString() {
		return strMsgString;
	}

	/**
	 * Sets the str msg string.
	 * 
	 * @param strMsgString the new str msg string
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	/**
	 * Gets the str msg type.
	 * 
	 * @return the str msg type
	 */
	public String getStrMsgType() {
		return strMsgType;
	}

	/**
	 * Sets the str msg type.
	 * 
	 * @param strMsgType the new str msg type
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	
	
	//////////////// New Variables getter and setter Method (fb) start  ////////////////////
	public String getStrErrMsg() {
		return strErrMsg;
	}

	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}

	public String getStrNormalMsg() {
		return strNormalMsg;
	}

	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
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

	public String getStrPeriodId(String strStoreId, String strItemCatCode,
			String strHospitalCode) throws Exception {

		try {
			strPeriodId = MmsConfigMstDAO.getPeriodId(strStoreId,
					strItemCatCode, strHospitalCode);
		} catch (Exception e) {

			throw e;
		}

		return strPeriodId;
	}

	public void setStrPeriodId(String strPeriodId) {
		this.strPeriodId = strPeriodId;
	}

	public String getStrBudgetFlg() {
		return strBudgetFlg;
	}

	public void setStrBudgetFlg(String strBudgetFlg) {
		this.strBudgetFlg = strBudgetFlg;
	}

	/**
	 * Gets the str financial start date.
	 * 
	 * @param strStoreId
	 *            the str store id
	 * @param strHospitalCode
	 *            the str hospital code
	 * 
	 * @return the str financial start date
	 */
	public String getStrFinancialStartDate(String strStoreId,
			String strHospitalCode) {

		strFinancialStartDate = MmsConfigMstDAO.getDateDetails(strStoreId,
				strHospitalCode).replace("^", "#").split("#")[0];

		return strFinancialStartDate;
	}

	public void setStrFinancialStartDate(String strFinancialStartDate) {
		this.strFinancialStartDate = strFinancialStartDate;
	}

	/**
	 * Gets the str financial end date.
	 * 
	 * @param strStoreId
	 *            the str store id
	 * @param strHospitalCode
	 *            the str hospital code
	 * 
	 * @return the str financial end date
	 */
	public String getStrFinancialEndDate(String strStoreId,
			String strHospitalCode) {

		strFinancialEndDate = MmsConfigMstDAO.getDateDetails(strStoreId,
				strHospitalCode).replace("^", "#").split("#")[1];

		return strFinancialEndDate;
	}

	public String getStrTaxRate() {
		return strTaxRate;
	}

	public void setStrTaxRate(String strTaxRate) {
		this.strTaxRate = strTaxRate;
	}

	public void setStrFinancialEndDate(String strFinancialEndDate) {
		this.strFinancialEndDate = strFinancialEndDate;
	}

	public String getStrIsStockLedgerRequired() {
		return strIsStockLedgerRequired;
	}

	public void setStrIsStockLedgerRequired(String strIsStockLedgerRequired) {
		this.strIsStockLedgerRequired = strIsStockLedgerRequired;
	}

	public String getStrPreviousStockLedgerRequired() {
		return strPreviousStockLedgerRequired;
	}

	public void setStrPreviousStockLedgerRequired(
			String strPreviousStockLedgerRequired) {
		this.strPreviousStockLedgerRequired = strPreviousStockLedgerRequired;
	}

	public String getStrIndianDeliveryTime() {
		return strIndianDeliveryTime;
	}

	public void setStrIndianDeliveryTime(String strIndianDeliveryTime) {
		this.strIndianDeliveryTime = strIndianDeliveryTime;
	}

	public String getStrImportedDeliveryTime() {
		return strImportedDeliveryTime;
	}

	public void setStrImportedDeliveryTime(String strImportedDeliveryTime) {
		this.strImportedDeliveryTime = strImportedDeliveryTime;
	}

	public String getStrStoreDetailsValues() {
		return strStoreDetailsValues;
	}

	public void setStrStoreDetailsValues(String strStoreDetailsValues) {
		this.strStoreDetailsValues = strStoreDetailsValues;
	}

	public String getStrResidualCost() {
		return strResidualCost;
	}

	public void setStrResidualCost(String strResidualCost) {
		this.strResidualCost = strResidualCost;
	}

	public String getStrExpAlertDays() {
		return strExpAlertDays;
	}

	public void setStrExpAlertDays(String strExpAlertDays) {
		this.strExpAlertDays = strExpAlertDays;
	}

	public String getStrIssueMode() {
		return strIssueMode;
	}

	public void setStrIssueMode(String strIssueMode) {
		this.strIssueMode = strIssueMode;
	}

	public String getStrLastIssuePatientStaffInDays() {
		return strLastIssuePatientStaffInDays;
	}

	public void setStrLastIssuePatientStaffInDays(
			String strLastIssuePatientStaffInDays) {
		this.strLastIssuePatientStaffInDays = strLastIssuePatientStaffInDays;
	}

	public String getStrLastIssueEmployeeInDays() {
		return strLastIssueEmployeeInDays;
	}

	public void setStrLastIssueEmployeeInDays(String strLastIssueEmployeeInDays) {
		this.strLastIssueEmployeeInDays = strLastIssueEmployeeInDays;
	}

	public String getStrOnlineIssueInDays() {
		return strOnlineIssueInDays;
	}

	public void setStrOnlineIssueInDays(String strOnlineIssueInDays) {
		this.strOnlineIssueInDays = strOnlineIssueInDays;
	}

	public String getStrAutoReturnRequest() {
		return strAutoReturnRequest;
	}

	public void setStrAutoReturnRequest(String strAutoReturnRequest) {
		this.strAutoReturnRequest = strAutoReturnRequest;
	}

	public String getStrStaffSalePrice() {
		return strStaffSalePrice;
	}

	public void setStrStaffSalePrice(String strStaffSalePrice) {
		this.strStaffSalePrice = strStaffSalePrice;
	}

	public String getStrStaffSalePriceType() {
		return strStaffSalePriceType;
	}

	public void setStrStaffSalePriceType(String strStaffSalePriceType) {
		this.strStaffSalePriceType = strStaffSalePriceType;
	}

	public String getStrNormalSalePrice() {
		return strNormalSalePrice;
	}

	public void setStrNormalSalePrice(String strNormalSalePrice) {
		this.strNormalSalePrice = strNormalSalePrice;
	}

	public String getStrNormalSalePriceType() {
		return strNormalSalePriceType;
	}

	public void setStrNormalSalePriceType(String strNormalSalePriceType) {
		this.strNormalSalePriceType = strNormalSalePriceType;
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

	public String[] getStrFromDays() {
		return strFromDays;
	}

	public void setStrFromDays(String[] strFromDays) {
		this.strFromDays = strFromDays;
	}

	public String[] getStrToDays() {
		return strToDays;
	}

	public void setStrToDays(String[] strToDays) {
		this.strToDays = strToDays;
	}

	public String[] getStrPenalty() {
		return strPenalty;
	}

	public void setStrPenalty(String[] strPenalty) {
		this.strPenalty = strPenalty;
	}

	public String getStrMultiRowIndex() {
		return strMultiRowIndex;
	}

	public void setStrMultiRowIndex(String strMultiRowIndex) {
		this.strMultiRowIndex = strMultiRowIndex;
	}

	public String getStrPenaltyDetailsList() {
		return strPenaltyDetailsList;
	}

	public void setStrPenaltyDetailsList(String strPenaltyDetailsList) {
		this.strPenaltyDetailsList = strPenaltyDetailsList;
	}

	public String getStrCommitteeFilePath() {
		return strCommitteeFilePath;
	}

	public void setStrCommitteeFilePath(String strCommitteeFilePath) {
		this.strCommitteeFilePath = strCommitteeFilePath;
	}
	///////////////  New Variables getter and setter Method (fb) end /////////////////////

	
	
	
	
	///////////////  New Variables getter and setter Method (mmsconfigutil) start  /////////////////////
	public String getStrOnlineIssueDetailsInDays() {
		return strOnlineIssueDetailsInDays;
	}

	public void setStrOnlineIssueDetailsInDays(String strOnlineIssueDetailsInDays) {
		this.strOnlineIssueDetailsInDays = strOnlineIssueDetailsInDays;
	}

	public String getStrBatchNo() {
		return strBatchNo;
	}

	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}

	public String getStrACategory() {
		return strACategory;
	}

	public void setStrACategory(String strACategory) {
		this.strACategory = strACategory;
	}

	public String getStrB1Category() {
		return strB1Category;
	}

	public void setStrB1Category(String strB1Category) {
		this.strB1Category = strB1Category;
	}

	public String getStrB2Category() {
		return strB2Category;
	}

	public void setStrB2Category(String strB2Category) {
		this.strB2Category = strB2Category;
	}

	public String getStrCCategory() {
		return strCCategory;
	}

	public void setStrCCategory(String strCCategory) {
		this.strCCategory = strCCategory;
	}

	public String getStrFCategory() {
		return strFCategory;
	}

	public void setStrFCategory(String strFCategory) {
		this.strFCategory = strFCategory;
	}

	public String getStrN1Category() {
		return strN1Category;
	}

	public void setStrN1Category(String strN1Category) {
		this.strN1Category = strN1Category;
	}

	public String getStrN2Category() {
		return strN2Category;
	}

	public void setStrN2Category(String strN2Category) {
		this.strN2Category = strN2Category;
	}

	public String getStrSCategory() {
		return strSCategory;
	}

	public void setStrSCategory(String strSCategory) {
		this.strSCategory = strSCategory;
	}

	public String getStrCostReq() {
		return strCostReq;
	}

	public void setStrCostReq(String strCostReq) {
		this.strCostReq = strCostReq;
	}

	public String getStrWinLocation() {
		return strWinLocation;
	}

	public void setStrWinLocation(String strWinLocation) {
		this.strWinLocation = strWinLocation;
	}

	public String getStrLinLocation() {
		return strLinLocation;
	}

	public String getStrIndentLimitAmt() {
		return strIndentLimitAmt;
	}

	public void setStrIndentLimitAmt(String strIndentLimitAmt) {
		this.strIndentLimitAmt = strIndentLimitAmt;
	}

	public void setStrLinLocation(String strLinLocation) {
		this.strLinLocation = strLinLocation;
	}

	public String getStrStoreConfigCatg() {
		return strStoreConfigCatg;
	}

	public void setStrStoreConfigCatg(String strStoreConfigCatg) {
		this.strStoreConfigCatg = strStoreConfigCatg;
	}
	public static String getStrPODemnadValidity(String strHospitalCode) {
		strPODemnadValidity = MmsConfigMstDAO.getPODemandValidity(strHospitalCode);

		return strPODemnadValidity;
	}

	public String getStrBillingIntegration() {
		return strBillingIntegration;
	}

	public void setStrBillingIntegration(String strBillingIntegration) {
		this.strBillingIntegration = strBillingIntegration;
	}

	public String getStrWhetherSingleItemMultiSupplier() {
		return strWhetherSingleItemMultiSupplier;
	}

	public void setStrWhetherSingleItemMultiSupplier(
			String strWhetherSingleItemMultiSupplier) {
		this.strWhetherSingleItemMultiSupplier = strWhetherSingleItemMultiSupplier;
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
	
	
	
	
	///////////////  New Variables getter and setter Method (mmsconfigutil) end    /////////////////////

}
