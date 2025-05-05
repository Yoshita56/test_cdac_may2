/**
 * 
 */
package mms.transactions.vo;

import hisglobal.utility.TransferObject;

import javax.sql.rowset.WebRowSet;

/**
 * @author Administrator
 *
 */
public class RateContractDtlTransVO  implements TransferObject{
	
	private static final long serialVersionUID = 02L;

	private Boolean BExistStatus = false;
	private Boolean BLevelExistStatus = false;
	public Boolean getBLevelExistStatus() {
		return BLevelExistStatus;
	}

	public void setBLevelExistStatus(Boolean bLevelExistStatus) {
		BLevelExistStatus = bLevelExistStatus;
	}

	private String strMsgString = "";
	private String strMsgType = "";
	
	private String strPrevRenewRemarks = "";
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
	
	private String strRateContractSLNo = "";
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
	private String strCancelRemarks = "";
	private String strItemCategoryNo = "";
	private String strSeatId = "";
	private String strIsValid = "";
	private String strDeiveryLeadTime = "";
	private String strDeiveryLeadTimeUnit = "";
	private String strPreviousContractFromDate = "";
	
	
	private String strItemIDArray[] = null;
	private String strItemBrandIDArray[] = null;
	private String strRateArray[] = null;
	private String strRateUnitIDArray[] = null; 
	private String strLastRateArray[] = null;
	private String strLastRateUnitIDArray[] = null; 
	private String strGroupIDArray[] =null; 
	
	private String strRenewRate = "";
	private String strRenewRateUnitId = "";

	
	private String strSupplierName = "";
	private String strItemCategoryName = "";
	
	private WebRowSet ItemCategoryCmbWS = null;
	private WebRowSet GroupCmbWS = null;
	private WebRowSet DetailsWS = null;
	private WebRowSet PreviosRenewDtlsWS = null;
	private WebRowSet PreviosRenewItemDtlsWS = null;
	
	private String strCancelDtlsFlag = "";
	private String strCancelDate = "";
	
	private String strCancelSeatId = "";
	
	private String strGroupIdForItemSearch = "";
	
	private String itemParamValueArray[] = null;
	private String strUnitNameArray[] = null;
	
	private String strGroupName = "";
	private String strItemDetails = "";
	private String strItemName = "";
	private String strItemBrandName = "";
	private String strRateUnitName = "";
	private String strRateView = "";
	
	private String strItemID = "";
	private String strItemBrandID = "";
	private String strSlNo = "";
	private String strRateUnitID = "";
	private String strTaxTypeValue;
	

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
	
	private String strPrevTax= "";
	private String strPrevTaxType= "";
	private String strContractValidity="";
	
	private String strPrevTenderDate= "";
	private String strPrevQuotationDate= "";
	private String strPrevTaxTypeValue= "";
	
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

    private String strNtDate="";
    
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
    
    private String strContractId="";
    private String[] strItemTax=null;
    
    private String[] strRCChk=null;
    private String[] strTenderItemNo;
    private String strRcTenderSno;
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

	public String getStrContractId() {
		return strContractId;
	}

	public void setStrContractId(String strContractId) {
		this.strContractId = strContractId;
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


	public String[] getStrSecurityAmt() {
		return strSecurityAmt;
	}

	public void setStrSecurityAmt(String[] strSecurityAmt) {
		this.strSecurityAmt = strSecurityAmt;
	}

	public String getStrContractValidity() {
		return strContractValidity;
	}

	public void setStrContractValidity(String strContractValidity) {
		this.strContractValidity = strContractValidity;
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

	/**
	 * @return the bExistStatus
	 */
	public Boolean getBExistStatus() {
		return BExistStatus;
	}

	/**
	 * @param existStatus the bExistStatus to set
	 */
	public void setBExistStatus(Boolean existStatus) {
		BExistStatus = existStatus;
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
	 * @return the strRateContractSLNo
	 */
	public String getStrRateContractSLNo() {
		return strRateContractSLNo;
	}

	/**
	 * @param strRateContractSLNo the strRateContractSLNo to set
	 */
	public void setStrRateContractSLNo(String strRateContractSLNo) {
		this.strRateContractSLNo = strRateContractSLNo;
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
	 * @return the strIsValid
	 */
	public String getStrIsValid() {
		return strIsValid;
	}

	/**
	 * @param strIsValid the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	
	
	/**
	 * @return the strItemIDArray
	 */
	public String[] getStrItemIDArray() {
		return strItemIDArray;
	}

	/**
	 * @param strItemIDArray the strItemIDArray to set
	 */
	public void setStrItemIDArray(String[] strItemIDArray) {
		this.strItemIDArray = strItemIDArray;
	}

	
	/**
	 * @return the strRateUnitIDArray
	 */
	public String[] getStrRateUnitIDArray() {
		return strRateUnitIDArray;
	}

	/**
	 * @param strRateUnitIDArray the strRateUnitIDArray to set
	 */
	public void setStrRateUnitIDArray(String[] strRateUnitIDArray) {
		this.strRateUnitIDArray = strRateUnitIDArray;
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
	 * @return the strRateUnitID
	 */
	public String getStrRateUnitID() {
		return strRateUnitID;
	}

	/**
	 * @param strRateUnitID the strRateUnitID to set
	 */
	public void setStrRateUnitID(String strRateUnitID) {
		this.strRateUnitID = strRateUnitID;
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
	 * @return the itemCategoryCmbWS
	 */
	public WebRowSet getItemCategoryCmbWS() {
		return ItemCategoryCmbWS;
	}

	/**
	 * @param itemCategoryCmbWS the itemCategoryCmbWS to set
	 */
	public void setItemCategoryCmbWS(WebRowSet itemCategoryCmbWS) {
		ItemCategoryCmbWS = itemCategoryCmbWS;
	}

	/**
	 * @return the groupCmbWS
	 */
	public WebRowSet getGroupCmbWS() {
		return GroupCmbWS;
	}

	/**
	 * @param groupCmbWS the groupCmbWS to set
	 */
	public void setGroupCmbWS(WebRowSet groupCmbWS) {
		GroupCmbWS = groupCmbWS;
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
	 * @return the strRateArray
	 */
	public String[] getStrRateArray() {
		return strRateArray;
	}

	/**
	 * @param strRateArray the strRateArray to set
	 */
	public void setStrRateArray(String[] strRateArray) {
		this.strRateArray = strRateArray;
	}

	/**
	 * @return the strLastRateArray
	 */
	public String[] getStrLastRateArray() {
		return strLastRateArray;
	}

	/**
	 * @param strLastRateArray the strLastRateArray to set
	 */
	public void setStrLastRateArray(String[] strLastRateArray) {
		this.strLastRateArray = strLastRateArray;
	}

	/**
	 * @return the strLastRateUnitIDArray
	 */
	public String[] getStrLastRateUnitIDArray() {
		return strLastRateUnitIDArray;
	}

	/**
	 * @param strLastRateUnitIDArray the strLastRateUnitIDArray to set
	 */
	public void setStrLastRateUnitIDArray(String[] strLastRateUnitIDArray) {
		this.strLastRateUnitIDArray = strLastRateUnitIDArray;
	}

	/**
	 * @return the strGroupIDArray
	 */
	public String[] getStrGroupIDArray() {
		return strGroupIDArray;
	}

	/**
	 * @param strGroupIDArray the strGroupIDArray to set
	 */
	public void setStrGroupIDArray(String[] strGroupIDArray) {
		this.strGroupIDArray = strGroupIDArray;
	}

	/**
	 * @return the itemParamValueArray
	 */
	public String[] getItemParamValueArray() {
		return itemParamValueArray;
	}

	/**
	 * @param itemParamValueArray the itemParamValueArray to set
	 */
	public void setItemParamValueArray(String[] itemParamValueArray) {
		this.itemParamValueArray = itemParamValueArray;
	}

	/**
	 * @return the strUnitNameArray
	 */
	public String[] getStrUnitNameArray() {
		return strUnitNameArray;
	}

	/**
	 * @param strUnitNameArray the strUnitNameArray to set
	 */
	public void setStrUnitNameArray(String[] strUnitNameArray) {
		this.strUnitNameArray = strUnitNameArray;
	}

	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * @return the detailsWS
	 */
	public WebRowSet getDetailsWS() {
		return DetailsWS;
	}

	/**
	 * @param detailsWS the detailsWS to set
	 */
	public void setDetailsWS(WebRowSet detailsWS) {
		DetailsWS = detailsWS;
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
	 * @return the strItemBrandIDArray
	 */
	public String[] getStrItemBrandIDArray() {
		return strItemBrandIDArray;
	}

	/**
	 * @param strItemBrandIDArray the strItemBrandIDArray to set
	 */
	public void setStrItemBrandIDArray(String[] strItemBrandIDArray) {
		this.strItemBrandIDArray = strItemBrandIDArray;
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
	 * @return the previosRenewDtlsWS
	 */
	public WebRowSet getPreviosRenewDtlsWS() {
		return PreviosRenewDtlsWS;
	}

	/**
	 * @param previosRenewDtlsWS the previosRenewDtlsWS to set
	 */
	public void setPreviosRenewDtlsWS(WebRowSet previosRenewDtlsWS) {
		PreviosRenewDtlsWS = previosRenewDtlsWS;
	}

	/**
	 * @return the previosRenewItemDtlsWS
	 */
	public WebRowSet getPreviosRenewItemDtlsWS() {
		return PreviosRenewItemDtlsWS;
	}

	/**
	 * @param previosRenewItemDtlsWS the previosRenewItemDtlsWS to set
	 */
	public void setPreviosRenewItemDtlsWS(WebRowSet previosRenewItemDtlsWS) {
		PreviosRenewItemDtlsWS = previosRenewItemDtlsWS;
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

	public String getStrTaxTypeValue() {
		return strTaxTypeValue;
	}

	public void setStrTaxTypeValue(String strTaxTypeValue) {
		this.strTaxTypeValue = strTaxTypeValue;
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

	public String getStrPrevTaxTypeValue() {
		return strPrevTaxTypeValue;
	}

	public void setStrPrevTaxTypeValue(String strPrevTaxTypeValue) {
		this.strPrevTaxTypeValue = strPrevTaxTypeValue;
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

	public String getStrPrevContractQty() {
		return strPrevContractQty;
	}

	public void setStrPrevContractQty(String strPrevContractQty) {
		this.strPrevContractQty = strPrevContractQty;
	}

	public String getStrPreviousContractFromDate() {
		return strPreviousContractFromDate;
	}

	public void setStrPreviousContractFromDate(String strPreviousContractFromDate) {
		this.strPreviousContractFromDate = strPreviousContractFromDate;
	}

	public String getStrRcTenderSno() {
		return strRcTenderSno;
	}

	public void setStrRcTenderSno(String strRcTenderSno) {
		this.strRcTenderSno = strRcTenderSno;
	}



}
