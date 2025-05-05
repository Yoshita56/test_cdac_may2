/**
 * 
 */
package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.TransferObject;
/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * Date : 23/April/2009
 * 
 */
public class ReturnFromTransVO implements TransferObject {

	private static final long serialVersionUID = 02L;

	private Boolean BExistStatus = false;
	private String strMsgString = "";
	private String strMsgType = "";
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strIsValid = "";
	private String strRemarks = "";
	private String strStoreId = "";
	private String strStoreName = "";
	private String strItemCategoryNo = "";
	private String strCrNo = "";
	private String strMode = "";
	private String strChkTemp ="";
	private String strChkBoth = "";
	private String strReqTypeId = "";
	private String strCtDate = "";
	
	/*Patient Details*/
	
	private String strPatName = "";
	private String strPatFatherName = "";
	private String strPatSpouseName = "";
	private String strAddress = "";
	private String strAgeGender = "";
	private String strPatientCategory = "";
	
	/*Issue Details*/
	private String strIssueNo = "";
	private String strStockStatusCode = "";
	private String IssueNo = "";
	private String strIssueDate = "";
	private String strDepartmentUnitName = "";
	private String strConsultantName = "";
	private String strFinStartDate = "";
	private String strFinEndDate = "";
	private String[] strTotalCost = null;
	private String strNetCost = "";
	private String strRecommendedBy="";
	private String strEmpNo = "";
	private String strReturnDate = "";
	private String strReturnNo = "";
	private String strAdmnNo = "";
	private String strReturnNetCost = "";
	private String strRecommendDate = "";
	private String[] strItemSlNo = null;
	private String[] strGroupId = null;
	private String[] strSubGroupId = null;
	private String strReservedFlag = "";
	private String strHidParamVal = "";
	
	/*Item Details*/
	private String[] strItemId = null;
	private String strItemName = "";
	private String[] strItemBrandId = null;
	private String strItemBrandName = "";
	private String[] strBatchSlNo = null;
	
	private String[] strBalanceQty = null;
	private String[] strBalanceQtyUnitId = null;
	private String[] strReturnQty = null;
	private String[] strReturnQtyUnitId = null;
	private String[] strInhandQty = null;
	private String[] strInhandQtyUnitId = null;
	private String strIssueQty = null;
	private String strIssueQtyUnitId = null;
	private String[] strRate = null;
	private String[] strRateQtyUnitId = null;
	private String[] strExpiry = null;
	
	public String[] getStrExpiry() {
		return strExpiry;
	}
	public void setStrExpiry(String[] strExpiry) {
		this.strExpiry = strExpiry;
	}
	private WebRowSet storeNameWS = null;
	private WebRowSet itemCategoryWS = null;
	private WebRowSet issueNoWS = null;
	private WebRowSet returnQtyUnitWS = null;
	private WebRowSet itemDetailsWS = null;
	private WebRowSet recommendNameWS = null;
	private WebRowSet wrsData;
      /* Hidden Variables */
	
	private String storeName = "";
	private String itemCatName = "";
	private String crNo = "";
	private String strId = "";
	private String itemCategory = "";
	private String strConfCatCode = "";
	private String strIssueDtl = "";
	private String disFlag = "";
	private String strIssueMode = "";
	
	private String strReturnDrugValidity;
	private String strIssueNumber;
	private String strIssueNumberValidationFlag;
	private String strReqNo;
	
	private String strFromDate;
	private String strToDate;
	private String strDays;
	
	private String strPatientName;
	private String strPatientAge;
	private String strPatientAgeUnit;
    private String strPatientFatherName;
	private String strPatientGenderCode;
	private String strPatientGenderCodeCmbValues;
    private String strPatientAddress;
    private String strChargeTypeId;
    private String[] strIssueNoList=null;
    private String[] strOrgIssueStoreList=null;
    //  Global Issue Voucher
    private String strFromStoreId = "";
    private String strCrno = "";
    private String strModeVal = "";
    private String strReturnReqNo = "";
    private String strItemCategoryId = "";
    private WebRowSet wsIssueDetails = null;
    private String strFinalRemarks = "";
    
    private String strItemWiseCost = "";
    private String strIndentNo = "";
    private String strIndentDate = "";
    private String strUserName = "";
    private String strOrgName = "";
    private String strIssueTo = "";
    private String strSlNoflg ="";
    private String strPatientDtl="";
	private String strLogoName="";	
    private String strNameWthCRNo="";
	private String strItemCategoryCmb;
	
	private String strItemCagID;
	private WebRowSet issueNoDtlWs;
	private WebRowSet returnNoDtlWs;
	

	public WebRowSet getReturnNoDtlWs() {
		return returnNoDtlWs;
	}
	public void setReturnNoDtlWs(WebRowSet returnNoDtlWs) {
		this.returnNoDtlWs = returnNoDtlWs;
	}
	public WebRowSet getIssueNoDtlWs() {
		return issueNoDtlWs;
	}
	public void setIssueNoDtlWs(WebRowSet issueNoDtlWs) {
		this.issueNoDtlWs = issueNoDtlWs;
	}
	public String getStrItemCagID() {
		return strItemCagID;
	}
	public void setStrItemCagID(String strItemCagID) {
		this.strItemCagID = strItemCagID;
	}
	
	public String getStrItemCategoryCmb() {
		return strItemCategoryCmb;
	}
	public void setStrItemCategoryCmb(String strItemCategoryCmb) {
		this.strItemCategoryCmb = strItemCategoryCmb;
	}
	public String getStrNameWthCRNo() {
		return strNameWthCRNo;
	}
	public void setStrNameWthCRNo(String strNameWthCRNo) {
		this.strNameWthCRNo = strNameWthCRNo;
	}
	public String getStrLogoName() {
		return strLogoName;
	}
	public void setStrLogoName(String strLogoName) {
		this.strLogoName = strLogoName;
	}
	public String getStrPatientDtl() {
		return strPatientDtl;
	}
	public void setStrPatientDtl(String strPatientDtl) {
		this.strPatientDtl = strPatientDtl;
	}
	public String getStrSlNoflg() {
		return strSlNoflg;
	}
	public void setStrSlNoflg(String strSlNoflg) {
		this.strSlNoflg = strSlNoflg;
	}
	public String getStrIssueTo() {
		return strIssueTo;
	}
	public void setStrIssueTo(String strIssueTo) {
		this.strIssueTo = strIssueTo;
	}
	public String getStrItemWiseCost() {
		return strItemWiseCost;
	}
	public void setStrItemWiseCost(String strItemWiseCost) {
		this.strItemWiseCost = strItemWiseCost;
	}
	public String getStrIndentNo() {
		return strIndentNo;
	}
	public void setStrIndentNo(String strIndentNo) {
		this.strIndentNo = strIndentNo;
	}
	public String getStrIndentDate() {
		return strIndentDate;
	}
	public void setStrIndentDate(String strIndentDate) {
		this.strIndentDate = strIndentDate;
	}
	public String getStrUserName() {
		return strUserName;
	}
	public void setStrUserName(String strUserName) {
		this.strUserName = strUserName;
	}
	public String getStrOrgName() {
		return strOrgName;
	}
	public void setStrOrgName(String strOrgName) {
		this.strOrgName = strOrgName;
	}
	public String getStrFromStoreId() {
		return strFromStoreId;
	}
	public void setStrFromStoreId(String strFromStoreId) {
		this.strFromStoreId = strFromStoreId;
	}
	public String getStrCrno() {
		return strCrno;
	}
	public void setStrCrno(String strCrno) {
		this.strCrno = strCrno;
	}
	public String getStrModeVal() {
		return strModeVal;
	}
	public void setStrModeVal(String strModeVal) {
		this.strModeVal = strModeVal;
	}
	public String getStrReturnReqNo() {
		return strReturnReqNo;
	}
	public void setStrReturnReqNo(String strReturnReqNo) {
		this.strReturnReqNo = strReturnReqNo;
	}
	public String getStrItemCategoryId() {
		return strItemCategoryId;
	}
	public void setStrItemCategoryId(String strItemCategoryId) {
		this.strItemCategoryId = strItemCategoryId;
	}
	public WebRowSet getWsIssueDetails() {
		return wsIssueDetails;
	}
	public void setWsIssueDetails(WebRowSet wsIssueDetails) {
		this.wsIssueDetails = wsIssueDetails;
	}
	public String getStrFinalRemarks() {
		return strFinalRemarks;
	}
	public void setStrFinalRemarks(String strFinalRemarks) {
		this.strFinalRemarks = strFinalRemarks;
	}
	public String[] getStrOrgIssueStoreList() {
		return strOrgIssueStoreList;
	}
	public void setStrOrgIssueStoreList(String[] strOrgIssueStoreList) {
		this.strOrgIssueStoreList = strOrgIssueStoreList;
	}
		
    
	public String[] getStrIssueNoList() {
		return strIssueNoList;
	}
	public void setStrIssueNoList(String[] strIssueNoList) {
		this.strIssueNoList = strIssueNoList;
	}
	
	public String getStrChargeTypeId() {
		return strChargeTypeId;
	}
	public void setStrChargeTypeId(String strChargeTypeId) {
		this.strChargeTypeId = strChargeTypeId;
	}
	public String getStrPatientName() {
		return strPatientName;
	}
	public void setStrPatientName(String strPatientName) {
		this.strPatientName = strPatientName;
	}
	public String getStrPatientAge() {
		return strPatientAge;
	}
	public void setStrPatientAge(String strPatientAge) {
		this.strPatientAge = strPatientAge;
	}
	public String getStrPatientAgeUnit() {
		return strPatientAgeUnit;
	}
	public void setStrPatientAgeUnit(String strPatientAgeUnit) {
		this.strPatientAgeUnit = strPatientAgeUnit;
	}
	public String getStrPatientFatherName() {
		return strPatientFatherName;
	}
	public void setStrPatientFatherName(String strPatientFatherName) {
		this.strPatientFatherName = strPatientFatherName;
	}
	public String getStrPatientGenderCode() {
		return strPatientGenderCode;
	}
	public void setStrPatientGenderCode(String strPatientGenderCode) {
		this.strPatientGenderCode = strPatientGenderCode;
	}
	public String getStrPatientGenderCodeCmbValues() {
		return strPatientGenderCodeCmbValues;
	}
	public void setStrPatientGenderCodeCmbValues(
			String strPatientGenderCodeCmbValues) {
		this.strPatientGenderCodeCmbValues = strPatientGenderCodeCmbValues;
	}
	public String getStrPatientAddress() {
		return strPatientAddress;
	}
	public void setStrPatientAddress(String strPatientAddress) {
		this.strPatientAddress = strPatientAddress;
	}
	public String getStrDays() {
		return strDays;
	}
	public void setStrDays(String strDays) {
		this.strDays = strDays;
	}
	public String getStrFromDate() {
		return strFromDate;
	}
	public void setStrFromDate(String strFromDate) {
		this.strFromDate = strFromDate;
	}
	public String getStrToDate() {
		return strToDate;
	}
	public void setStrToDate(String strToDate) {
		this.strToDate = strToDate;
	}
	public String getStrIssueNumberValidationFlag() {
		return strIssueNumberValidationFlag;
	}
	public void setStrIssueNumberValidationFlag(String strIssueNumberValidationFlag) {
		this.strIssueNumberValidationFlag = strIssueNumberValidationFlag;
	}
	public String getStrReturnDrugValidity() {
		return strReturnDrugValidity;
	}
	public void setStrReturnDrugValidity(String strReturnDrugValidity) {
		this.strReturnDrugValidity = strReturnDrugValidity;
	}
	public WebRowSet getItemDetailsWS() {
		return itemDetailsWS;
	}
	public void setItemDetailsWS(WebRowSet itemDetailsWS) {
		this.itemDetailsWS = itemDetailsWS;
	}
	public WebRowSet getReturnQtyUnitWS() {
		return returnQtyUnitWS;
	}
	public void setReturnQtyUnitWS(WebRowSet returnQtyUnitWS) {
		this.returnQtyUnitWS = returnQtyUnitWS;
	}
	public WebRowSet getIssueNoWS() {
		return issueNoWS;
	}
	public void setIssueNoWS(WebRowSet issueNoWS) {
		this.issueNoWS = issueNoWS;
	}
	public WebRowSet getItemCategoryWS() {
		return itemCategoryWS;
	}
	public void setItemCategoryWS(WebRowSet itemCategoryWS) {
		this.itemCategoryWS = itemCategoryWS;
	}
	public WebRowSet getStoreNameWS() {
		return storeNameWS;
	}
	public void setStoreNameWS(WebRowSet storeNameWS) {
		this.storeNameWS = storeNameWS;
	}
	public Boolean getBExistStatus() {
		return BExistStatus;
	}
	public void setBExistStatus(Boolean existStatus) {
		BExistStatus = existStatus;
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
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrIsValid() {
		return strIsValid;
	}
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
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
	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}
	public String getStrCrNo() {
		return strCrNo;
	}
	public void setStrCrNo(String strCrNo) {
		this.strCrNo = strCrNo;
	}
	public String getStrPatName() {
		return strPatName;
	}
	public void setStrPatName(String strPatName) {
		this.strPatName = strPatName;
	}
	public String getStrPatFatherName() {
		return strPatFatherName;
	}
	public void setStrPatFatherName(String strPatFatherName) {
		this.strPatFatherName = strPatFatherName;
	}
	public String getStrPatSpouseName() {
		return strPatSpouseName;
	}
	public void setStrPatSpouseName(String strPatSpouseName) {
		this.strPatSpouseName = strPatSpouseName;
	}
	public String getStrAddress() {
		return strAddress;
	}
	public void setStrAddress(String strAddress) {
		this.strAddress = strAddress;
	}
	public String getStrIssueNo() {
		return strIssueNo;
	}
	public void setStrIssueNo(String strIssueNo) {
		this.strIssueNo = strIssueNo;
	}
	public String getStrIssueDate() {
		return strIssueDate;
	}
	public void setStrIssueDate(String strIssueDate) {
		this.strIssueDate = strIssueDate;
	}
	
	/**
	 * @return the strDepartmentUnitName
	 */
	public String getStrDepartmentUnitName() {
		return strDepartmentUnitName;
	}
	/**
	 * @param strDepartmentUnitName the strDepartmentUnitName to set
	 */
	public void setStrDepartmentUnitName(String strDepartmentUnitName) {
		this.strDepartmentUnitName = strDepartmentUnitName;
	}
	
	
	public String getStrItemName() {
		return strItemName;
	}
	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}
	public String getStrItemBrandName() {
		return strItemBrandName;
	}
	public void setStrItemBrandName(String strItemBrandName) {
		this.strItemBrandName = strItemBrandName;
	}	
	public String[] getStrReturnQty() {
		return strReturnQty;
	}
	public void setStrReturnQty(String[] strReturnQty) {
		this.strReturnQty = strReturnQty;
	}
	public String[] getStrReturnQtyUnitId() {
		return strReturnQtyUnitId;
	}
	public void setStrReturnQtyUnitId(String[] strReturnQtyUnitId) {
		this.strReturnQtyUnitId = strReturnQtyUnitId;
	}
	public String getStrAgeGender() {
		return strAgeGender;
	}
	public void setStrAgeGender(String strAgeGender) {
		this.strAgeGender = strAgeGender;
	}
	public String getStrPatientCategory() {
		return strPatientCategory;
	}
	public void setStrPatientCategory(String strPatientCategory) {
		this.strPatientCategory = strPatientCategory;
	}
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String getStrFinStartDate() {
		return strFinStartDate;
	}
	public void setStrFinStartDate(String strFinStartDate) {
		this.strFinStartDate = strFinStartDate;
	}
	public String getStrFinEndDate() {
		return strFinEndDate;
	}
	public void setStrFinEndDate(String strFinEndDate) {
		this.strFinEndDate = strFinEndDate;
	}
	public String getStrChkTemp() {
		return strChkTemp;
	}
	public void setStrChkTemp(String strChkTemp) {
		this.strChkTemp = strChkTemp;
	}
	/**
	 * @return the strChkBoth
	 */
	public String getStrChkBoth() {
		return strChkBoth;
	}
	/**
	 * @param strChkBoth the strChkBoth to set
	 */
	public void setStrChkBoth(String strChkBoth) {
		this.strChkBoth = strChkBoth;
	}
	/**
	 * @return the storeName
	 */
	public String getStoreName() {
		return storeName;
	}
	/**
	 * @param storeName the storeName to set
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	/**
	 * @return the itemCatName
	 */
	public String getItemCatName() {
		return itemCatName;
	}
	/**
	 * @param itemCatName the itemCatName to set
	 */
	public void setItemCatName(String itemCatName) {
		this.itemCatName = itemCatName;
	}
	/**
	 * @return the crNo
	 */
	public String getCrNo() {
		return crNo;
	}
	/**
	 * @param crNo the crNo to set
	 */
	public void setCrNo(String crNo) {
		this.crNo = crNo;
	}
	/**
	 * @return the strId
	 */
	public String getStrId() {
		return strId;
	}
	/**
	 * @param strId the strId to set
	 */
	public void setStrId(String strId) {
		this.strId = strId;
	}
	/**
	 * @return the itemCategory
	 */
	public String getItemCategory() {
		return itemCategory;
	}
	/**
	 * @param itemCategory the itemCategory to set
	 */
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	/**
	 * @return the strConfCatCode
	 */
	public String getStrConfCatCode() {
		return strConfCatCode;
	}
	/**
	 * @param strConfCatCode the strConfCatCode to set
	 */
	public void setStrConfCatCode(String strConfCatCode) {
		this.strConfCatCode = strConfCatCode;
	}
	/**
	 * @return the strIssueDtl
	 */
	public String getStrIssueDtl() {
		return strIssueDtl;
	}
	/**
	 * @param strIssueDtl the strIssueDtl to set
	 */
	public void setStrIssueDtl(String strIssueDtl) {
		this.strIssueDtl = strIssueDtl;
	}
	/**
	 * @return the disFlag
	 */
	public String getDisFlag() {
		return disFlag;
	}
	/**
	 * @param disFlag the disFlag to set
	 */
	public void setDisFlag(String disFlag) {
		this.disFlag = disFlag;
	}
	/**
	 * @return the strIssueMode
	 */
	public String getStrIssueMode() {
		return strIssueMode;
	}
	/**
	 * @param strIssueMode the strIssueMode to set
	 */
	public void setStrIssueMode(String strIssueMode) {
		this.strIssueMode = strIssueMode;
	}
	/**
	 * @return the strReqTypeId
	 */
	public String getStrReqTypeId() {
		return strReqTypeId;
	}
	/**
	 * @param strReqTypeId the strReqTypeId to set
	 */
	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}
	/**
	 * @return the strConsultantName
	 */
	public String getStrConsultantName() {
		return strConsultantName;
	}
	/**
	 * @param strConsultantName the strConsultantName to set
	 */
	public void setStrConsultantName(String strConsultantName) {
		this.strConsultantName = strConsultantName;
	}
	/**
	 * @return the issueNo
	 */
	public String getIssueNo() {
		return IssueNo;
	}
	/**
	 * @param issueNo the issueNo to set
	 */
	public void setIssueNo(String issueNo) {
		IssueNo = issueNo;
	}
	
	/**
	 * @return the strTotalCost
	 */
	public String[] getStrTotalCost() {
		return strTotalCost;
	}
	/**
	 * @param strTotalCost the strTotalCost to set
	 */
	public void setStrTotalCost(String[] strTotalCost) {
		this.strTotalCost = strTotalCost;
	}
	/**
	 * @return the strNetCost
	 */
	public String getStrNetCost() {
		return strNetCost;
	}
	/**
	 * @param strNetCost the strNetCost to set
	 */
	public void setStrNetCost(String strNetCost) {
		this.strNetCost = strNetCost;
	}
	/**
	 * @return the strRecommendedBy
	 */
	public String getStrRecommendedBy() {
		return strRecommendedBy;
	}
	/**
	 * @param strRecommendedBy the strRecommendedBy to set
	 */
	public void setStrRecommendedBy(String strRecommendedBy) {
		this.strRecommendedBy = strRecommendedBy;
	}
	/**
	 * @return the strEmpNo
	 */
	public String getStrEmpNo() {
		return strEmpNo;
	}
	/**
	 * @param strEmpNo the strEmpNo to set
	 */
	public void setStrEmpNo(String strEmpNo) {
		this.strEmpNo = strEmpNo;
	}
	/**
	 * @return the recommendNameWS
	 */
	public WebRowSet getRecommendNameWS() {
		return recommendNameWS;
	}
	/**
	 * @param recommendNameWS the recommendNameWS to set
	 */
	public void setRecommendNameWS(WebRowSet recommendNameWS) {
		this.recommendNameWS = recommendNameWS;
	}
	/**
	 * @return the strReturnDate
	 */
	public String getStrReturnDate() {
		return strReturnDate;
	}
	/**
	 * @param strReturnDate the strReturnDate to set
	 */
	public void setStrReturnDate(String strReturnDate) {
		this.strReturnDate = strReturnDate;
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
	 * @return the strStockStatusCode
	 */
	public String getStrStockStatusCode() {
		return strStockStatusCode;
	}
	/**
	 * @param strStockStatusCode the strStockStatusCode to set
	 */
	public void setStrStockStatusCode(String strStockStatusCode) {
		this.strStockStatusCode = strStockStatusCode;
	}
	/**
	 * @return the strReturnNo
	 */
	public String getStrReturnNo() {
		return strReturnNo;
	}
	/**
	 * @param strReturnNo the strReturnNo to set
	 */
	public void setStrReturnNo(String strReturnNo) {
		this.strReturnNo = strReturnNo;
	}
	/**
	 * @return the strAdmnNo
	 */
	public String getStrAdmnNo() {
		return strAdmnNo;
	}
	/**
	 * @param strAdmnNo the strAdmnNo to set
	 */
	public void setStrAdmnNo(String strAdmnNo) {
		this.strAdmnNo = strAdmnNo;
	}
	/**
	 * @return the strReturnNetCost
	 */
	public String getStrReturnNetCost() {
		return strReturnNetCost;
	}
	/**
	 * @param strReturnNetCost the strReturnNetCost to set
	 */
	public void setStrReturnNetCost(String strReturnNetCost) {
		this.strReturnNetCost = strReturnNetCost;
	}
	/**
	 * @return the strRecommendDate
	 */
	public String getStrRecommendDate() {
		return strRecommendDate;
	}
	/**
	 * @param strRecommendDate the strRecommendDate to set
	 */
	public void setStrRecommendDate(String strRecommendDate) {
		this.strRecommendDate = strRecommendDate;
	}
	
	
	public String[] getStrItemSlNo() {
		return strItemSlNo;
	}
	public void setStrItemSlNo(String[] strItemSlNo) {
		this.strItemSlNo = strItemSlNo;
	}
	/**
	 * @return the strGroupId
	 */
	public String[] getStrGroupId() {
		return strGroupId;
	}
	/**
	 * @param strGroupId the strGroupId to set
	 */
	public void setStrGroupId(String[] strGroupId) {
		this.strGroupId = strGroupId;
	}
	/**
	 * @return the strSubGroupId
	 */
	public String[] getStrSubGroupId() {
		return strSubGroupId;
	}
	/**
	 * @param strSubGroupId the strSubGroupId to set
	 */
	public void setStrSubGroupId(String[] strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}
	/**
	 * @return the strItemId
	 */
	public String[] getStrItemId() {
		return strItemId;
	}
	/**
	 * @param strItemId the strItemId to set
	 */
	public void setStrItemId(String[] strItemId) {
		this.strItemId = strItemId;
	}
	/**
	 * @return the strItemBrandId
	 */
	public String[] getStrItemBrandId() {
		return strItemBrandId;
	}
	/**
	 * @param strItemBrandId the strItemBrandId to set
	 */
	public void setStrItemBrandId(String[] strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}
	/**
	 * @return the strBatchSlNo
	 */
	public String[] getStrBatchSlNo() {
		return strBatchSlNo;
	}
	/**
	 * @param strBatchSlNo the strBatchSlNo to set
	 */
	public void setStrBatchSlNo(String[] strBatchSlNo) {
		this.strBatchSlNo = strBatchSlNo;
	}
	/**
	 * @return the strBalanceQty
	 */
	public String[] getStrBalanceQty() {
		return strBalanceQty;
	}
	/**
	 * @param strBalanceQty the strBalanceQty to set
	 */
	public void setStrBalanceQty(String[] strBalanceQty) {
		this.strBalanceQty = strBalanceQty;
	}
	/**
	 * @return the strBalanceQtyUnitId
	 */
	public String[] getStrBalanceQtyUnitId() {
		return strBalanceQtyUnitId;
	}
	/**
	 * @param strBalanceQtyUnitId the strBalanceQtyUnitId to set
	 */
	public void setStrBalanceQtyUnitId(String[] strBalanceQtyUnitId) {
		this.strBalanceQtyUnitId = strBalanceQtyUnitId;
	}
	/**
	 * @return the strInhandQty
	 */
	public String[] getStrInhandQty() {
		return strInhandQty;
	}
	/**
	 * @param strInhandQty the strInhandQty to set
	 */
	public void setStrInhandQty(String[] strInhandQty) {
		this.strInhandQty = strInhandQty;
	}
	/**
	 * @return the strInhandQtyUnitId
	 */
	public String[] getStrInhandQtyUnitId() {
		return strInhandQtyUnitId;
	}
	/**
	 * @param strInhandQtyUnitId the strInhandQtyUnitId to set
	 */
	public void setStrInhandQtyUnitId(String[] strInhandQtyUnitId) {
		this.strInhandQtyUnitId = strInhandQtyUnitId;
	}
	/**
	 * @return the strIssueQtyUnitId
	 */
	public String getStrIssueQtyUnitId() {
		return strIssueQtyUnitId;
	}
	/**
	 * @param strIssueQtyUnitId the strIssueQtyUnitId to set
	 */
	public void setStrIssueQtyUnitId(String strIssueQtyUnitId) {
		this.strIssueQtyUnitId = strIssueQtyUnitId;
	}
	/**
	 * @return the strIssueQty
	 */
	public String getStrIssueQty() {
		return strIssueQty;
	}
	/**
	 * @param strIssueQty the strIssueQty to set
	 */
	public void setStrIssueQty(String strIssueQty) {
		this.strIssueQty = strIssueQty;
	}
	/**
	 * @return the strReservedFlag
	 */
	public String getStrReservedFlag() {
		return strReservedFlag;
	}
	/**
	 * @param strReservedFlag the strReservedFlag to set
	 */
	public void setStrReservedFlag(String strReservedFlag) {
		this.strReservedFlag = strReservedFlag;
	}
	/**
	 * @return the strHidParamVal
	 */
	public String getStrHidParamVal() {
		return strHidParamVal;
	}
	/**
	 * @param strHidParamVal the strHidParamVal to set
	 */
	public void setStrHidParamVal(String strHidParamVal) {
		this.strHidParamVal = strHidParamVal;
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
	 * @return the strRateQtyUnitId
	 */
	public String[] getStrRateQtyUnitId() {
		return strRateQtyUnitId;
	}
	/**
	 * @param strRateQtyUnitId the strRateQtyUnitId to set
	 */
	public void setStrRateQtyUnitId(String[] strRateQtyUnitId) {
		this.strRateQtyUnitId = strRateQtyUnitId;
	}
	public String getStrIssueNumber() {
		return strIssueNumber;
	}
	public void setStrIssueNumber(String strIssueNumber) {
		this.strIssueNumber = strIssueNumber;
	}
	public WebRowSet getWrsData() {
		return wrsData;
	}
	public void setWrsData(WebRowSet wrsData) {
		this.wrsData = wrsData;
	}
	public String getStrReqNo() {
		return strReqNo;
	}
	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
	}
		

}
