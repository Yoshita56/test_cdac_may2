/**
 * 
 */
package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;

/**
 * Developer : Tanvi Sappal
 * Version : 1.0
 * Date : 17/June/2009
 *
 */
public class ReturnFromEmployeeTransFB extends ActionForm {
	
	private static final long serialVersionUID = 02L;

	private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";

	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strIsValid = "";
	private String strRemarks = "";
	private String strStoreId = "";
	private String strStoreName = "";
	private String strItemCategoryNo = "";
	private String strCrNo = "";
	private String strMode = "";
	private String strChkBoth ="";
	private String strReqTypeId = "";
	
	/*Patient Details*/
	private String strPatientDetail = "";
	private String strPatName = "";
	private String strPatFatherName = "";
	private String strPatSpouseName = "";
	private String strAddress = "";
	private String strAgeGender = "";
	private String strPatientCategory = "";
	
	/*Issue Details*/
	private String strIssueNo = "";
	private String[] strStockStatusCode = null;
	private String strIssueDate = "";
	private String strDepartmentUnitName = "";
	private String strConsultantName = "";
	private String strFinStartDate = "";
	private String strFinEndDate = "";
	private String[] strTotalCost = null;
	private String strNetCost = "";
	private String strRecommendedBy="";
	private String strCtDate = "";
	private String strEmpNo = "";
	private String strReturnDate = "";
	private String StrReturnNo = "";
	private String strAdmnNo = "";
	private String strReturnNetCost = "";
	private String strRecommendDate = "";
	private String[] strItemSlNo = null;
	private String[] strGroupId = null;
	private String[] strSubGroupId = null;
	private String strReservedFlag = "";
	private String strPatientDtlHidVal = "";
	private String strAdmissionDtlHidVal = "";
	private String[] strHidParamVal = null;
	private String[] strRate = null;
	private String[] strRateQtyUnitId = null;
	private String strChkEmpExist="";
		
	/*Item Details*/
	private String[] strItemId = null;
	private String strItemName = "";
	private String[] strItemBrandId = null;
	private String strItemBrandName = null;
	private String[] strBatchSlNo = null;
	private String strIssueQty = "";
	private String strIssueQtyUnitId = "";
	private String[] strBalanceQty = null;
	private String[] strBalanceQtyUnitId =null;
	private String[] strInhandQty = null;
	private String[] strInhandQtyUnitId = null;
	private String[] strReturnQty = null;
	private String[] strReturnQtyUnitId = null;
	
	private String strStoreNameCombo = "";
	private String strItemCategoryCombo = "";
	private String strIssueNoCombo = "";
	private String strReturnQtyUnit = "";
	private String strItemDetails = "";
	private String strEmployeeDtl = "";
	
	/* Hidden Variables */
	
	private String storeName = "";
	private String itemCatName = "";
	private String crNo = "";
	private String strId = "";
	private String itemCategory = "";
	private String strConfCatCode = "";
	private String IssueNo = "";
	private String mode = "";
	private String strIssueMode = "";
	private String empNo = "";
	
	private String strRecommendNameCombo = "";
		
	/**
	 * @return the strRecommendNameCombo
	 */
	public String getStrRecommendNameCombo() {
		return strRecommendNameCombo;
	}
	/**
	 * @param strRecommendNameCombo the strRecommendNameCombo to set
	 */
	public void setStrRecommendNameCombo(String strRecommendNameCombo) {
		this.strRecommendNameCombo = strRecommendNameCombo;
	}
	public String getStrItemDetails() {
		return strItemDetails;
	}
	public void setStrItemDetails(String strItemDetails) {
		this.strItemDetails = strItemDetails;
	}
	public String getStrReturnQtyUnit() {
		return strReturnQtyUnit;
	}
	public void setStrReturnQtyUnit(String strReturnQtyUnit) {
		this.strReturnQtyUnit = strReturnQtyUnit;
	}
	public String getStrItemCategoryCombo() {
		return strItemCategoryCombo;
	}
	public void setStrItemCategoryCombo(String strItemCategoryCombo) {
		this.strItemCategoryCombo = strItemCategoryCombo;
	}
	public String getStrStoreNameCombo() {
		return strStoreNameCombo;
	}
	public void setStrStoreNameCombo(String strStoreNameCombo) {
		this.strStoreNameCombo = strStoreNameCombo;
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
	public String getStrPatientDetail() {
		return strPatientDetail;
	}
	public void setStrPatientDetail(String strPatientDetail) {
		this.strPatientDetail = strPatientDetail;
	}
	public String getStrIssueNoCombo() {
		return strIssueNoCombo;
	}
	public void setStrIssueNoCombo(String strIssueNoCombo) {
		this.strIssueNoCombo = strIssueNoCombo;
	}
	/*public String getStrTempCrNo() {
		return strTempCrNo;
	}
	public void setStrTempCrNo(String strTempCrNo) {
		this.strTempCrNo = strTempCrNo;
	}
	public String getStrTmpMode() {
		return strTmpMode;
	}
	public void setStrTmpMode(String strTmpMode) {
		this.strTmpMode = strTmpMode;
	}
	public String getStrStoreNameTmpCombo() {
		return strStoreNameTmpCombo;
	}
	public void setStrStoreNameTmpCombo(String strStoreNameTmpCombo) {
		this.strStoreNameTmpCombo = strStoreNameTmpCombo;
	}
	public String getStrItemTmpCategoryNo() {
		return strItemTmpCategoryNo;
	}
	public void setStrItemTmpCategoryNo(String strItemTmpCategoryNo) {
		this.strItemTmpCategoryNo = strItemTmpCategoryNo;
	}*/
	public String getStrIssueQty() {
		return strIssueQty;
	}
	public void setStrIssueQty(String strIssueQty) {
		this.strIssueQty = strIssueQty;
	}
	public String getStrIssueQtyUnitId() {
		return strIssueQtyUnitId;
	}
	public void setStrIssueQtyUnitId(String strIssueQtyUnitId) {
		this.strIssueQtyUnitId = strIssueQtyUnitId;
	}
	/*public String getStrChkTemp() {
		return strChkTemp;
	}
	public void setStrChkTemp(String strChkTemp) {
		this.strChkTemp = strChkTemp;
	}
	*//**
	 * @return the strCatgName
	 *//*
	public String getStrCatgName() {
		return strCatgName;
	}
	*//**
	 * @param strCatgName the strCatgName to set
	 *//*
	public void setStrCatgName(String strCatgName) {
		this.strCatgName = strCatgName;
	}*/
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
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}
	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
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
	 * @return the strStockStatusCode
	 */
	public String[] getStrStockStatusCode() {
		return strStockStatusCode;
	}
	/**
	 * @param strStockStatusCode the strStockStatusCode to set
	 */
	public void setStrStockStatusCode(String[] strStockStatusCode) {
		this.strStockStatusCode = strStockStatusCode;
	}
	/**
	 * @return the strReturnNo
	 */
	public String getStrReturnNo() {
		return StrReturnNo;
	}
	/**
	 * @param strReturnNo the strReturnNo to set
	 */
	public void setStrReturnNo(String strReturnNo) {
		StrReturnNo = strReturnNo;
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
	 * @return the strPatientDtlHidVal
	 */
	public String getStrPatientDtlHidVal() {
		return strPatientDtlHidVal;
	}
	/**
	 * @param strPatientDtlHidVal the strPatientDtlHidVal to set
	 */
	public void setStrPatientDtlHidVal(String strPatientDtlHidVal) {
		this.strPatientDtlHidVal = strPatientDtlHidVal;
	}
	/**
	 * @return the strAdmissionDtlHidVal
	 */
	public String getStrAdmissionDtlHidVal() {
		return strAdmissionDtlHidVal;
	}
	/**
	 * @param strAdmissionDtlHidVal the strAdmissionDtlHidVal to set
	 */
	public void setStrAdmissionDtlHidVal(String strAdmissionDtlHidVal) {
		this.strAdmissionDtlHidVal = strAdmissionDtlHidVal;
	}
		/**
	 * @param strGroupId the strGroupId to set
	 */
	public void setStrGroupId(String[] strGroupId) {
		this.strGroupId = strGroupId;
	}
	/**
	 * @param strSubGroupId the strSubGroupId to set
	 */
	public void setStrSubGroupId(String[] strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
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
	/**
	 * @return the strGroupId
	 */
	public String[] getStrGroupId() {
		return strGroupId;
	}
	/**
	 * @return the strSubGroupId
	 */
	public String[] getStrSubGroupId() {
		return strSubGroupId;
	}
	/**
	 * @return the strHidParamVal
	 */
	public String[] getStrHidParamVal() {
		return strHidParamVal;
	}
	/**
	 * @param strHidParamVal the strHidParamVal to set
	 */
	public void setStrHidParamVal(String[] strHidParamVal) {
		this.strHidParamVal = strHidParamVal;
	}
	/**
	 * @return the empNo
	 */
	public String getEmpNo() {
		return empNo;
	}
	/**
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	/**
	 * @return the strEmployeeDtl
	 */
	public String getStrEmployeeDtl() {
		return strEmployeeDtl;
	}
	/**
	 * @param strEmployeeDtl the strEmployeeDtl to set
	 */
	public void setStrEmployeeDtl(String strEmployeeDtl) {
		this.strEmployeeDtl = strEmployeeDtl;
	}
	/**
	 * @return the strChkEmpExist
	 */
	public String getStrChkEmpExist() {
		return strChkEmpExist;
	}
	/**
	 * @param strChkEmpExist the strChkEmpExist to set
	 */
	public void setStrChkEmpExist(String strChkEmpExist) {
		this.strChkEmpExist = strChkEmpExist;
	}
	
	
	

}
