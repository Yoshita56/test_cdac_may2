/**
 * 
 */
package mms.transactions.controller.fb;

import hisglobal.transactionutil.GenericFormBean;

import javax.sql.rowset.WebRowSet;

/**
 * @author Administrator
 *
 */
public class RateContractDtlTransFB extends GenericFormBean{
	private static final long serialVersionUID = 02L;

	private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";

	private String strPreviousRenewDtls = "";
	private String strPrevRenewDate = "";
	private String strPrevRenewContractFromDate = "";
	private String strPrevRenewContractToDate = "";
	private String strPrevRenewTenderNo = "";
	private String strPrevRenewQuotationNo = "";
	private String strPrevRenewDlvryLeadTime = "";
	private String strPrevRenewDlvryLeadTimeUnitName = "";
	private String strPrevRenewItemName = "";
	private String strPrevRenewRate = "";
	private String strPrevRenewFlag = "";
	private String strPrevRenewRateUnit = "";
	private String strPrevRenewRemarks = "";
	private String strReOrderFlgColor="";
	private String strSlNo = "";
	private String strContractTypeID = "";
	private String strHospitalCode = "";
	private String strTenderNo = "";
	private String strQuotationNo = "";
	private String strSupplierId = "";
	private String strContractDate = "";
	private String strContractFromDate = "";
	private String strContractToDate = "";
	private String strRateContractStatus = "";
	private String strFinancialStartYr = "";
	private String strFinancialEndYr = "";
	private String strRemarks = "";
	private String strRejectedRemarks = "";
	private String strItemCategoryNo = "";
	private String strGroupCmbValues = "";
	private String strSeatId = "";
	private String strContractType = ""; 
	private String strRenewRate = "";
	private String strRenewRateUnitId = "";
	private String strTaxWithType="";

	private String strDeiveryLeadTime = "";
	private String strDeiveryLeadTimeUnit = "";
	
	
	private String strItemID = "";
	private String strItemBrandID = "";

	private String strGroupIdForItemSearch = "";
	private String strRate[] = null;
	private String itemParamValue[] = null;
	private String strUnitName[] = null;
	
	private String strCancelDtlsFlag = "";
	private String strCancelDate = "";
	private String strCancelRemarks = "";
	private String strCancelSeatId = "";
	
	private String strChk1 = "";
	
	private String strSupplierName = "";
	
	private String strCtDate = "";
	
	private String strNtDate = "";

	

	private String strItemBrandName = "";
	private String strGroupName = "";
	private String strItemName = "";
	private String strRateUnitName = "";
	private String strItemDetails = "";
	private String strRateView = "";
	private String strItemCategoryName = "";
	private String strLastPurchaseRate = "";
	private String strLastPurchaseRateUnit = "";
	private String strRateUnitId = "";
	private String strUnitCmbValues = "";
	private WebRowSet rateUnitWS = null; 
	private String strNextContractFromDate = ""; 
	private String strDeiveryLeadTimeUnitName = "";  
	private String strTenderDate= "";

	private String strQuotationDate= "";

	private String strTaxType= "";

	private String strTax= "";
	private String strNextCurrentDate="";
	private String strPrevTax= "";
	private String strPrevTaxType= "";
	private String strContractValidity="";
	private String strPrevTenderDate= "";
	private String strPrevQuotationDate= "";
	private String strPrevTaxWithType="";
	
	private String strSecurityAmt[] = null;
	private String strRateContQty[] = null;
	private String strSecurityAmtPercent[] = null;
	
	private String strRenewSecurityAmount="";
	private String strLastSecurityAmount="";
	private String strPrevSecurityAmt="";
	private String strPrevContractQty="";
	private String strRenewRateContQty="";
	private String strRenewSecurityAmtPercent="";
    private String strLastContractQty="";
    private String strDeliveryDays="";
    private String strPreviousContractFromDate = "";
    
   
    private String strImportedType[] = null;
	private String strShelfLife[] = null;
    private String strLevel[] = null;
    
    
    private String strRenewShelfLife="";
    
    private String strRenewLevel="";
    private String strRenewPackSize="";
    
    //for view page
    private String strImportTypeViewFlag="";
    
    private String strLettrNo="";
    private String strLetterDate="";
    private String strNewContractToDate="";
    
    private String[] strItemTax=null;
    private String[] strRCChk=null;
    private String[] strTenderItemNo=null;
    private String[] strPackSize=null;
    
    
    public String getStrRenewPackSize() {
		return strRenewPackSize;
	}

	public void setStrRenewPackSize(String strRenewPackSize) {
		this.strRenewPackSize = strRenewPackSize;
	}

	public String[] getStrPackSize() {
		return strPackSize;
	}

	public void setStrPackSize(String[] strPackSize) {
		this.strPackSize = strPackSize;
	}

	private String strRcTenderSno="";
    
    
   
    
    
    
	
	public String[] getStrTenderItemNo() {
		return strTenderItemNo;
	}

	public void setStrTenderItemNo(String[] strTenderItemNo) {
		this.strTenderItemNo = strTenderItemNo;
	}

	public String[] getStrRCChk() {
		return strRCChk;
	}

	public void setStrRCChk(String[] strRCChk) {
		this.strRCChk = strRCChk;
	}

	public String[] getStrItemTax() {
		return strItemTax;
	}

	public void setStrItemTax(String[] strItemTax) {
		this.strItemTax = strItemTax;
	}

	public String getStrLettrNo() {
		return strLettrNo;
	}

	public void setStrLettrNo(String strLettrNo) {
		this.strLettrNo = strLettrNo;
	}

	public String getStrLetterDate() {
		return strLetterDate;
	}

	public void setStrLetterDate(String strLetterDate) {
		this.strLetterDate = strLetterDate;
	}

	public String getStrNewContractToDate() {
		return strNewContractToDate;
	}

	public void setStrNewContractToDate(String strNewContractToDate) {
		this.strNewContractToDate = strNewContractToDate;
	}

	public String getStrImportTypeViewFlag() {
		return strImportTypeViewFlag;
	}

	public void setStrImportTypeViewFlag(String strImportTypeViewFlag) {
		this.strImportTypeViewFlag = strImportTypeViewFlag;
	}

	public String getStrRenewLevel() {
		return strRenewLevel;
	}

	public void setStrRenewLevel(String strRenewLevel) {
		this.strRenewLevel = strRenewLevel;
	}
    
    
    
	
	public String getStrRenewShelfLife() {
		return strRenewShelfLife;
	}

	public void setStrRenewShelfLife(String strRenewShelfLife) {
		this.strRenewShelfLife = strRenewShelfLife;
	}
    
    
    
    
    
    public String[] getStrImportedType() {
		return strImportedType;
	}

	public void setStrImportedType(String[] strImportedType) {
		this.strImportedType = strImportedType;
	}

	public String[] getStrShelfLife() {
		return strShelfLife;
	}

	public void setStrShelfLife(String[] strShelfLife) {
		this.strShelfLife = strShelfLife;
	}

	public String[] getStrLevel() {
		return strLevel;
	}

	public void setStrLevel(String[] strLevel) {
		this.strLevel = strLevel;
	}

	public String getStrNtDate() {
		return strNtDate;
	}

	public void setStrNtDate(String strNtDate) {
		this.strNtDate = strNtDate;
	}
	
	public String getStrPreviousContractFromDate() {
		return strPreviousContractFromDate;
	}

	public void setStrPreviousContractFromDate(String strPreviousContractFromDate) {
		this.strPreviousContractFromDate = strPreviousContractFromDate;
	}

	public String getStrDeliveryDays() {
		return strDeliveryDays;
	}

	public void setStrDeliveryDays(String strDeliveryDays) {
		this.strDeliveryDays = strDeliveryDays;
	}

	public String getStrLastContractQty() {
		return strLastContractQty;
	}

	public void setStrLastContractQty(String strLastContractQty) {
		this.strLastContractQty = strLastContractQty;
	}
	
	
	public String getStrPrevSecurityAmt() {
		return strPrevSecurityAmt;
	}

	public void setStrPrevSecurityAmt(String strPrevSecurityAmt) {
		this.strPrevSecurityAmt = strPrevSecurityAmt;
	}

	public String getStrLastSecurityAmount() {
		return strLastSecurityAmount;
	}

	public void setStrLastSecurityAmount(String strLastSecurityAmount) {
		this.strLastSecurityAmount = strLastSecurityAmount;
	}

	public String getStrRenewSecurityAmount() {
		return strRenewSecurityAmount;
	}

	public void setStrRenewSecurityAmount(String strRenewSecurityAmount) {
		this.strRenewSecurityAmount = strRenewSecurityAmount;
	}

	public String getStrPrevTenderDate() {
		return strPrevTenderDate;
	}

	public void setStrPrevTenderDate(String strPrevTenderDate) {
		this.strPrevTenderDate = strPrevTenderDate;
	}

	public String getStrPrevQuotationDate() {
		return strPrevQuotationDate;
	}

	public void setStrPrevQuotationDate(String strPrevQuotationDate) {
		this.strPrevQuotationDate = strPrevQuotationDate;
	}

	public String getStrContractValidity() {
		return strContractValidity;
	}

	public void setStrContractValidity(String strContractValidity) {
		this.strContractValidity = strContractValidity;
	}

	
	
	
	//private String comboValue = "";  
	

	public String getStrNextCurrentDate() {
		return strNextCurrentDate;
	}

	public void setStrNextCurrentDate(String strNextCurrentDate) {
		this.strNextCurrentDate = strNextCurrentDate;
	}

	public String getStrTenderDate() {
		return strTenderDate;
	}

	public void setStrTenderDate(String strTenderDate) {
		this.strTenderDate = strTenderDate;
	}

	public String getStrQuotationDate() {
		return strQuotationDate;
	}

	public void setStrQuotationDate(String strQuotationDate) {
		this.strQuotationDate = strQuotationDate;
	}

	public String getStrTaxType() {
		return strTaxType;
	}

	public void setStrTaxType(String strTaxType) {
		this.strTaxType = strTaxType;
	}

	public String getStrTax() {
		return strTax;
	}

	public void setStrTax(String strTax) {
		this.strTax = strTax;
	}

	/**
	 * @return the strItemCategoryName
	 */
	public String getStrItemCategoryName() {
		return strItemCategoryName;
	}

	/**
	 * @param strItemCategoryName the strItemCategoryName to set
	 */
	public void setStrItemCategoryName(String strItemCategoryName) {
		this.strItemCategoryName = strItemCategoryName;
	}

	/**
	 * @return the strItemDetails
	 */
	public String getStrItemDetails() {
		return strItemDetails;
	}

	/**
	 * @param strItemDetails the strItemDetails to set
	 */
	public void setStrItemDetails(String strItemDetails) {
		this.strItemDetails = strItemDetails;
	}

	/**
	 * @return the strGroupName
	 */
	public String getStrGroupName() {
		return strGroupName;
	}

	/**
	 * @param strGroupName the strGroupName to set
	 */
	public void setStrGroupName(String strGroupName) {
		this.strGroupName = strGroupName;
	}

	/**
	 * @return the strItemName
	 */
	public String getStrItemName() {
		return strItemName;
	}

	/**
	 * @param strItemName the strItemName to set
	 */
	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}

	

	/**
	 * @return the strRateUnitName
	 */
	public String getStrRateUnitName() {
		return strRateUnitName;
	}

	/**
	 * @param strRateUnitName the strRateUnitName to set
	 */
	public void setStrRateUnitName(String strRateUnitName) {
		this.strRateUnitName = strRateUnitName;
	}

	/**
	 * @return the strErr
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * @param strErr the strErr to set
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

	/**
	 * @return the strMsg
	 */
	public String getStrMsg() {
		return strMsg;
	}

	/**
	 * @param strMsg the strMsg to set
	 */
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}

	/**
	 * @return the strWarning
	 */
	public String getStrWarning() {
		return strWarning;
	}

	/**
	 * @param strWarning the strWarning to set
	 */
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
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
	 * @return the strTenderNo
	 */
	public String getStrTenderNo() {
		return strTenderNo;
	}

	/**
	 * @param strTenderNo the strTenderNo to set
	 */
	public void setStrTenderNo(String strTenderNo) {
		this.strTenderNo = strTenderNo;
	}

	/**
	 * @return the strQuotationNo
	 */
	public String getStrQuotationNo() {
		return strQuotationNo;
	}

	/**
	 * @param strQuotationNo the strQuotationNo to set
	 */
	public void setStrQuotationNo(String strQuotationNo) {
		this.strQuotationNo = strQuotationNo;
	}

	/**
	 * @return the strSupplierId
	 */
	public String getStrSupplierId() {
		return strSupplierId;
	}

	/**
	 * @param strSupplierId the strSupplierId to set
	 */
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}

	/**
	 * @return the strContractDate
	 */
	public String getStrContractDate() {
		return strContractDate;
	}

	/**
	 * @param strContractDate the strContractDate to set
	 */
	public void setStrContractDate(String strContractDate) {
		this.strContractDate = strContractDate;
	}

	/**
	 * @return the strContractFromDate
	 */
	public String getStrContractFromDate() {
		return strContractFromDate;
	}

	/**
	 * @param strContractFromDate the strContractFromDate to set
	 */
	public void setStrContractFromDate(String strContractFromDate) {
		this.strContractFromDate = strContractFromDate;
	}

	/**
	 * @return the strContractToDate
	 */
	public String getStrContractToDate() {
		return strContractToDate;
	}

	/**
	 * @param strContractToDate the strContractToDate to set
	 */
	public void setStrContractToDate(String strContractToDate) {
		this.strContractToDate = strContractToDate;
	}

	/**
	 * @return the strRateContractStatus
	 */
	public String getStrRateContractStatus() {
		return strRateContractStatus;
	}

	/**
	 * @param strRateContractStatus the strRateContractStatus to set
	 */
	public void setStrRateContractStatus(String strRateContractStatus) {
		this.strRateContractStatus = strRateContractStatus;
	}

	/**
	 * @return the strFinancialEndYr
	 */
	public String getStrFinancialEndYr() {
		return strFinancialEndYr;
	}

	/**
	 * @param strFinancialEndYr the strFinancialEndYr to set
	 */
	public void setStrFinancialEndYr(String strFinancialEndYr) {
		this.strFinancialEndYr = strFinancialEndYr;
	}

	/**
	 * @return the strRemarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}

	/**
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * @return the strRejectedRemarks
	 */
	public String getStrRejectedRemarks() {
		return strRejectedRemarks;
	}

	/**
	 * @param strRejectedRemarks the strRejectedRemarks to set
	 */
	public void setStrRejectedRemarks(String strRejectedRemarks) {
		this.strRejectedRemarks = strRejectedRemarks;
	}

	/**
	 * @return the strItemCategoryNo
	 */
	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}

	/**
	 * @param strItemCategoryNo the strItemCategoryNo to set
	 */
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}

	

	

	/**
	 * @return the strItemID
	 */
	public String getStrItemID() {
		return strItemID;
	}

	/**
	 * @param strItemID the strItemID to set
	 */
	public void setStrItemID(String strItemID) {
		this.strItemID = strItemID;
	}

	/**
	 * @return the strItemBrandID
	 */
	public String getStrItemBrandID() {
		return strItemBrandID;
	}

	/**
	 * @param strItemBrandID the strItemBrandID to set
	 */
	public void setStrItemBrandID(String strItemBrandID) {
		this.strItemBrandID = strItemBrandID;
	}

	

	
	/**
	 * @return the strRate
	 */
	public String[] getStrRate() {
		return strRate;
	}

	/**
	 * @param strRate the strRate to set
	 */
	public void setStrRate(String[] strRate) {
		this.strRate = strRate;
	}

	/**
	 * @return the itemParamValue
	 */
	public String[] getItemParamValue() {
		return itemParamValue;
	}

	/**
	 * @param itemParamValue the itemParamValue to set
	 */
	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
	}

	/**
	 * @return the strUnitName
	 */
	public String[] getStrUnitName() {
		return strUnitName;
	}

	/**
	 * @param strUnitName the strUnitName to set
	 */
	public void setStrUnitName(String[] strUnitName) {
		this.strUnitName = strUnitName;
	}

	/**
	 * @return the strChk1
	 */
	public String getStrChk1() {
		return strChk1;
	}

	/**
	 * @param strChk1 the strChk1 to set
	 */
	public void setStrChk1(String strChk1) {
		this.strChk1 = strChk1;
	}

	/**
	 * @return the strSupplierName
	 */
	public String getStrSupplierName() {
		return strSupplierName;
	}

	/**
	 * @param strSupplierName the strSupplierName to set
	 */
	public void setStrSupplierName(String strSupplierName) {
		this.strSupplierName = strSupplierName;
	}

	/**
	 * @return the strCtDate
	 */
	public String getStrCtDate() {
		return strCtDate;
	}

	/**
	 * @param strCtDate the strCtDate to set
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}

	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	

	/**
	 * @return the strGroupIdForItemSearch
	 */
	public String getStrGroupIdForItemSearch() {
		return strGroupIdForItemSearch;
	}

	/**
	 * @param strGroupIdForItemSearch the strGroupIdForItemSearch to set
	 */
	public void setStrGroupIdForItemSearch(String strGroupIdForItemSearch) {
		this.strGroupIdForItemSearch = strGroupIdForItemSearch;
	}

	/**
	 * @return the strRateView
	 */
	public String getStrRateView() {
		return strRateView;
	}

	/**
	 * @param strRateView the strRateView to set
	 */
	public void setStrRateView(String strRateView) {
		this.strRateView = strRateView;
	}

	/**
	 * @return the strContractType
	 */
	public String getStrContractType() {
		return strContractType;
	}

	/**
	 * @param strContractType the strContractType to set
	 */
	public void setStrContractType(String strContractType) {
		this.strContractType = strContractType;
	}

	/**
	 * @return the strContractTypeID
	 */
	public String getStrContractTypeID() {
		return strContractTypeID;
	}

	/**
	 * @param strContractTypeID the strContractTypeID to set
	 */
	public void setStrContractTypeID(String strContractTypeID) {
		this.strContractTypeID = strContractTypeID;
	}

	/**
	 * @return the strGroupCmbValues
	 */
	public String getStrGroupCmbValues() {
		return strGroupCmbValues;
	}

	/**
	 * @param strGroupCmbValues the strGroupCmbValues to set
	 */
	public void setStrGroupCmbValues(String strGroupCmbValues) {
		this.strGroupCmbValues = strGroupCmbValues;
	}

	/**
	 * @return the strFinancialStartYr
	 */
	public String getStrFinancialStartYr() {
		return strFinancialStartYr;
	}

	/**
	 * @param strFinancialStartYr the strFinancialStartYr to set
	 */
	public void setStrFinancialStartYr(String strFinancialStartYr) {
		this.strFinancialStartYr = strFinancialStartYr;
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
	 * @return the strCancelDate
	 */
	public String getStrCancelDate() {
		return strCancelDate;
	}

	/**
	 * @param strCancelDate the strCancelDate to set
	 */
	public void setStrCancelDate(String strCancelDate) {
		this.strCancelDate = strCancelDate;
	}

	/**
	 * @return the strCancelRemarks
	 */
	public String getStrCancelRemarks() {
		return strCancelRemarks;
	}

	/**
	 * @param strCancelRemarks the strCancelRemarks to set
	 */
	public void setStrCancelRemarks(String strCancelRemarks) {
		this.strCancelRemarks = strCancelRemarks;
	}

	/**
	 * @return the strDeiveryLeadTime
	 */
	public String getStrDeiveryLeadTime() {
		return strDeiveryLeadTime;
	}

	/**
	 * @param strDeiveryLeadTime the strDeiveryLeadTime to set
	 */
	public void setStrDeiveryLeadTime(String strDeiveryLeadTime) {
		this.strDeiveryLeadTime = strDeiveryLeadTime;
	}

	/**
	 * @return the strDeiveryLeadTimeUnit
	 */
	public String getStrDeiveryLeadTimeUnit() {
		return strDeiveryLeadTimeUnit;
	}

	/**
	 * @param strDeiveryLeadTimeUnit the strDeiveryLeadTimeUnit to set
	 */
	public void setStrDeiveryLeadTimeUnit(String strDeiveryLeadTimeUnit) {
		this.strDeiveryLeadTimeUnit = strDeiveryLeadTimeUnit;
	}
	/**
	 * @return the strRateUnitId
	 */
	public String getStrRateUnitId() {
		return strRateUnitId;
	}

	/**
	 * @param strRateUnitId the strRateUnitId to set
	 */
	public void setStrRateUnitId(String strRateUnitId) {
		this.strRateUnitId = strRateUnitId;
	}

	/**
	 * @return the strUnitCmbValues
	 */
	public String getStrUnitCmbValues() {
		return strUnitCmbValues;
	}

	/**
	 * @param strUnitCmbValues the strUnitCmbValues to set
	 */
	public void setStrUnitCmbValues(String strUnitCmbValues) {
		this.strUnitCmbValues = strUnitCmbValues;
	}

	/**
	 * @return the rateUnitWS
	 */
	public WebRowSet getRateUnitWS() {
		return rateUnitWS;
	}

	/**
	 * @param rateUnitWS the rateUnitWS to set
	 */
	public void setRateUnitWS(WebRowSet rateUnitWS) {
		this.rateUnitWS = rateUnitWS;
	}

	/**
	 * @return the strLastPurchaseRate
	 */
	public String getStrLastPurchaseRate() {
		return strLastPurchaseRate;
	}

	/**
	 * @param strLastPurchaseRate the strLastPurchaseRate to set
	 */
	public void setStrLastPurchaseRate(String strLastPurchaseRate) {
		this.strLastPurchaseRate = strLastPurchaseRate;
	}

	/**
	 * @return the strLastPurchaseRateUnit
	 */
	public String getStrLastPurchaseRateUnit() {
		return strLastPurchaseRateUnit;
	}

	/**
	 * @param strLastPurchaseRateUnit the strLastPurchaseRateUnit to set
	 */
	public void setStrLastPurchaseRateUnit(String strLastPurchaseRateUnit) {
		this.strLastPurchaseRateUnit = strLastPurchaseRateUnit;
	}

	/**
	 * @return the strNextContractFromDate
	 */
	public String getStrNextContractFromDate() {
		return strNextContractFromDate;
	}

	/**
	 * @param strNextContractFromDate the strNextContractFromDate to set
	 */
	public void setStrNextContractFromDate(String strNextContractFromDate) {
		this.strNextContractFromDate = strNextContractFromDate;
	}

	/**
	 * @return the strSlNo
	 */
	public String getStrSlNo() {
		return strSlNo;
	}

	/**
	 * @param strSlNo the strSlNo to set
	 */
	public void setStrSlNo(String strSlNo) {
		this.strSlNo = strSlNo;
	}

	/**
	 * @return the strRenewRate
	 */
	public String getStrRenewRate() {
		return strRenewRate;
	}

	/**
	 * @param strRenewRate the strRenewRate to set
	 */
	public void setStrRenewRate(String strRenewRate) {
		this.strRenewRate = strRenewRate;
	}

	/**
	 * @return the strRenewRateUnitId
	 */
	public String getStrRenewRateUnitId() {
		return strRenewRateUnitId;
	}

	/**
	 * @param strRenewRateUnitId the strRenewRateUnitId to set
	 */
	public void setStrRenewRateUnitId(String strRenewRateUnitId) {
		this.strRenewRateUnitId = strRenewRateUnitId;
	}

	/**
	 * @return the strDeiveryLeadTimeUnitName
	 */
	public String getStrDeiveryLeadTimeUnitName() {
		return strDeiveryLeadTimeUnitName;
	}

	/**
	 * @param strDeiveryLeadTimeUnitName the strDeiveryLeadTimeUnitName to set
	 */
	public void setStrDeiveryLeadTimeUnitName(String strDeiveryLeadTimeUnitName) {
		this.strDeiveryLeadTimeUnitName = strDeiveryLeadTimeUnitName;
	}

	/**
	 * @return the strPreviousRenewDtls
	 */
	public String getStrPreviousRenewDtls() {
		return strPreviousRenewDtls;
	}

	/**
	 * @param strPreviousRenewDtls the strPreviousRenewDtls to set
	 */
	public void setStrPreviousRenewDtls(String strPreviousRenewDtls) {
		this.strPreviousRenewDtls = strPreviousRenewDtls;
	}

	/**
	 * @return the strPrevRenewDate
	 */
	public String getStrPrevRenewDate() {
		return strPrevRenewDate;
	}

	/**
	 * @param strPrevRenewDate the strPrevRenewDate to set
	 */
	public void setStrPrevRenewDate(String strPrevRenewDate) {
		this.strPrevRenewDate = strPrevRenewDate;
	}

	/**
	 * @return the strPrevRenewContractFromDate
	 */
	public String getStrPrevRenewContractFromDate() {
		return strPrevRenewContractFromDate;
	}

	/**
	 * @param strPrevRenewContractFromDate the strPrevRenewContractFromDate to set
	 */
	public void setStrPrevRenewContractFromDate(String strPrevRenewContractFromDate) {
		this.strPrevRenewContractFromDate = strPrevRenewContractFromDate;
	}

	/**
	 * @return the strPrevRenewContractToDate
	 */
	public String getStrPrevRenewContractToDate() {
		return strPrevRenewContractToDate;
	}

	/**
	 * @param strPrevRenewContractToDate the strPrevRenewContractToDate to set
	 */
	public void setStrPrevRenewContractToDate(String strPrevRenewContractToDate) {
		this.strPrevRenewContractToDate = strPrevRenewContractToDate;
	}

	/**
	 * @return the strPrevRenewTenderNo
	 */
	public String getStrPrevRenewTenderNo() {
		return strPrevRenewTenderNo;
	}

	/**
	 * @param strPrevRenewTenderNo the strPrevRenewTenderNo to set
	 */
	public void setStrPrevRenewTenderNo(String strPrevRenewTenderNo) {
		this.strPrevRenewTenderNo = strPrevRenewTenderNo;
	}

	/**
	 * @return the strPrevRenewQuotationNo
	 */
	public String getStrPrevRenewQuotationNo() {
		return strPrevRenewQuotationNo;
	}

	/**
	 * @param strPrevRenewQuotationNo the strPrevRenewQuotationNo to set
	 */
	public void setStrPrevRenewQuotationNo(String strPrevRenewQuotationNo) {
		this.strPrevRenewQuotationNo = strPrevRenewQuotationNo;
	}

	/**
	 * @return the strPrevRenewDlvryLeadTime
	 */
	public String getStrPrevRenewDlvryLeadTime() {
		return strPrevRenewDlvryLeadTime;
	}

	/**
	 * @param strPrevRenewDlvryLeadTime the strPrevRenewDlvryLeadTime to set
	 */
	public void setStrPrevRenewDlvryLeadTime(String strPrevRenewDlvryLeadTime) {
		this.strPrevRenewDlvryLeadTime = strPrevRenewDlvryLeadTime;
	}

	/**
	 * @return the strPrevRenewDlvryLeadTimeUnitName
	 */
	public String getStrPrevRenewDlvryLeadTimeUnitName() {
		return strPrevRenewDlvryLeadTimeUnitName;
	}

	/**
	 * @param strPrevRenewDlvryLeadTimeUnitName the strPrevRenewDlvryLeadTimeUnitName to set
	 */
	public void setStrPrevRenewDlvryLeadTimeUnitName(
			String strPrevRenewDlvryLeadTimeUnitName) {
		this.strPrevRenewDlvryLeadTimeUnitName = strPrevRenewDlvryLeadTimeUnitName;
	}

	/**
	 * @return the strPrevRenewItemName
	 */
	public String getStrPrevRenewItemName() {
		return strPrevRenewItemName;
	}

	/**
	 * @param strPrevRenewItemName the strPrevRenewItemName to set
	 */
	public void setStrPrevRenewItemName(String strPrevRenewItemName) {
		this.strPrevRenewItemName = strPrevRenewItemName;
	}

	/**
	 * @return the strPrevRenewRate
	 */
	public String getStrPrevRenewRate() {
		return strPrevRenewRate;
	}

	/**
	 * @param strPrevRenewRate the strPrevRenewRate to set
	 */
	public void setStrPrevRenewRate(String strPrevRenewRate) {
		this.strPrevRenewRate = strPrevRenewRate;
	}

	/**
	 * @return the strPrevRenewFlag
	 */
	public String getStrPrevRenewFlag() {
		return strPrevRenewFlag;
	}

	/**
	 * @param strPrevRenewFlag the strPrevRenewFlag to set
	 */
	public void setStrPrevRenewFlag(String strPrevRenewFlag) {
		this.strPrevRenewFlag = strPrevRenewFlag;
	}

	/**
	 * @return the strPrevRenewRateUnit
	 */
	public String getStrPrevRenewRateUnit() {
		return strPrevRenewRateUnit;
	}

	/**
	 * @param strPrevRenewRateUnit the strPrevRenewRateUnit to set
	 */
	public void setStrPrevRenewRateUnit(String strPrevRenewRateUnit) {
		this.strPrevRenewRateUnit = strPrevRenewRateUnit;
	}

	/**
	 * @return the strPrevRenewRemarks
	 */
	public String getStrPrevRenewRemarks() {
		return strPrevRenewRemarks;
	}

	/**
	 * @param strPrevRenewRemarks the strPrevRenewRemarks to set
	 */
	public void setStrPrevRenewRemarks(String strPrevRenewRemarks) {
		this.strPrevRenewRemarks = strPrevRenewRemarks;
	}

	/**
	 * @return the strItemBrandName
	 */
	public String getStrItemBrandName() {
		return strItemBrandName;
	}

	/**
	 * @param strItemBrandName the strItemBrandName to set
	 */
	public void setStrItemBrandName(String strItemBrandName) {
		this.strItemBrandName = strItemBrandName;
	}

	/**
	 * @return the strCancelDtlsFlag
	 */
	public String getStrCancelDtlsFlag() {
		return strCancelDtlsFlag;
	}

	/**
	 * @param strCancelDtlsFlag the strCancelDtlsFlag to set
	 */
	public void setStrCancelDtlsFlag(String strCancelDtlsFlag) {
		this.strCancelDtlsFlag = strCancelDtlsFlag;
	}

	/**
	 * @return the strCancelSeatId
	 */
	public String getStrCancelSeatId() {
		return strCancelSeatId;
	}

	/**
	 * @param strCancelSeatId the strCancelSeatId to set
	 */
	public void setStrCancelSeatId(String strCancelSeatId) {
		this.strCancelSeatId = strCancelSeatId;
	}

	public String getStrTaxWithType() {
		return strTaxWithType;
	}

	public void setStrTaxWithType(String strTaxWithType) {
		this.strTaxWithType = strTaxWithType;
	}

	public String getStrPrevTax() {
		return strPrevTax;
	}

	public void setStrPrevTax(String strPrevTax) {
		this.strPrevTax = strPrevTax;
	}

	public String getStrPrevTaxType() {
		return strPrevTaxType;
	}

	public void setStrPrevTaxType(String strPrevTaxType) {
		this.strPrevTaxType = strPrevTaxType;
	}

	public String getStrPrevTaxWithType() {
		return strPrevTaxWithType;
	}

	public void setStrPrevTaxWithType(String strPrevTaxWithType) {
		this.strPrevTaxWithType = strPrevTaxWithType;
	}

	public String[] getStrSecurityAmt() {
		return strSecurityAmt;
	}

	public void setStrSecurityAmt(String[] strSecurityAmt) {
		this.strSecurityAmt = strSecurityAmt;
	}

	public String[] getStrRateContQty() {
		return strRateContQty;
	}

	public void setStrRateContQty(String[] strRateContQty) {
		this.strRateContQty = strRateContQty;
	}

	public String[] getStrSecurityAmtPercent() {
		return strSecurityAmtPercent;
	}

	public void setStrSecurityAmtPercent(String[] strSecurityAmtPercent) {
		this.strSecurityAmtPercent = strSecurityAmtPercent;
	}

	public String getStrRenewRateContQty() {
		return strRenewRateContQty;
	}

	public void setStrRenewRateContQty(String strRenewRateContQty) {
		this.strRenewRateContQty = strRenewRateContQty;
	}

	public String getStrRenewSecurityAmtPercent() {
		return strRenewSecurityAmtPercent;
	}

	public void setStrRenewSecurityAmtPercent(String strRenewSecurityAmtPercent) {
		this.strRenewSecurityAmtPercent = strRenewSecurityAmtPercent;
	}

	public String getStrPrevContractQty() {
		return strPrevContractQty;
	}

	public void setStrPrevContractQty(String strPrevContractQty) {
		this.strPrevContractQty = strPrevContractQty;
	}

	public String getStrReOrderFlgColor() {
		return strReOrderFlgColor;
	}

	public void setStrReOrderFlgColor(String strReOrderFlgColor) {
		this.strReOrderFlgColor = strReOrderFlgColor;
	}

	public String getStrRcTenderSno() {
		return strRcTenderSno;
	}

	public void setStrRcTenderSno(String strRcTenderSno) {
		this.strRcTenderSno = strRcTenderSno;
	}




}
