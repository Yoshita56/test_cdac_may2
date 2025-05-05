package mms.transactions.controller.fb;

import javax.sql.rowset.WebRowSet;

import org.apache.struts.upload.FormFile;

import hisglobal.transactionutil.GenericFormBean;

public class PhyStockVerificationTransFB extends GenericFormBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String strErrMsg = "";
	private String strNormalMsg = "";
	private String strWarningMsg = "";
	
	private String strHospitalCode = "";
	private String strGroupList = "";
	private String strUnitList = "";
	
	private String strStoreName = "";
	
	private String strStoreId ="";	
	private String strGroupId = "";
	private String strUnitId = "";
	private String strUnitValId = "";
	private String strItemCategoryId = "0";
	private String strPhysicalStockNo = "";
	
	private String strNewDetails = "";
	private String strPrevVal = "";
	private String strItemId = "";
	
	private String strFinancialStartDate = "";
	private String strCategoryName = "";
	private String strLastVerifiedDate = "";
	
	private String strPrevCountedFlag = "0";
	
	private String[] strCountedDtls = null;
	
	private String strGroupIdForItemSearch = "0";
	private String strGroupIdForItemSearchValues = "";
	
	private String[] strChkItemDtlTmp = null; 
	private String []strCountedItemDtls=null;
	private String[] strItemBrandId = null;
	private String[] strBatchSlNo = null;
	private String[] strCountedQty = null;
	private String[] strCountedQtyUnitId = null;
	private String[] strInHandQty = null;
	private String[] strInHandQtyUnitId = null;
	private String[] strToBeCountedItemBatchDtls=null;
	private String[] strVarianceQty=null;
	private String[] strVarianceCost=null;
	private String[] itemParamValue=null;
	private String strCommiteeTypeId="";
	private String[] strMemberRecommendation=null;
	private String[] strCommitteeMemberHidden=null;
	private String strRemarks="";
	
	private String strCountedQtyBatchWise="";
	private String strStockNo="";
	private String strItemCategNo="";
	private String strStartDate="";
	private String strPeriod="";
	private String strItemCategoryName="";
	private String strDisReport="";
	private String strCommitteeType="";
	private String strBillAproval="";
	private String strGroupComboDisp="";
	private String strCommitteeTypeId="";
	private String strFileNo="";
	private String strPageNo="";
	private FormFile strLocation=null;
	WebRowSet committeMemberWS=null;
	
	private String strUserId=null;
	
	public WebRowSet getCommitteMemberWS() {
		return committeMemberWS;
	}

	public void setCommitteMemberWS(WebRowSet committeMemberWS) {
		this.committeMemberWS = committeMemberWS;
	}

	public String getStrStockNo() {
		return strStockNo;
	}

	public void setStrStockNo(String strStockNo) {
		this.strStockNo = strStockNo;
	}

	public String getStrItemCategNo() {
		return strItemCategNo;
	}

	public void setStrItemCategNo(String strItemCategNo) {
		this.strItemCategNo = strItemCategNo;
	}

	public String getStrStartDate() {
		return strStartDate;
	}

	public void setStrStartDate(String strStartDate) {
		this.strStartDate = strStartDate;
	}

	public String getStrPeriod() {
		return strPeriod;
	}

	public void setStrPeriod(String strPeriod) {
		this.strPeriod = strPeriod;
	}

	public String getStrItemCategoryName() {
		return strItemCategoryName;
	}

	public void setStrItemCategoryName(String strItemCategoryName) {
		this.strItemCategoryName = strItemCategoryName;
	}

	public String getStrDisReport() {
		return strDisReport;
	}

	public void setStrDisReport(String strDisReport) {
		this.strDisReport = strDisReport;
	}

	public String getStrCommitteeType() {
		return strCommitteeType;
	}

	public void setStrCommitteeType(String strCommitteeType) {
		this.strCommitteeType = strCommitteeType;
	}

	public String getStrBillAproval() {
		return strBillAproval;
	}

	public void setStrBillAproval(String strBillAproval) {
		this.strBillAproval = strBillAproval;
	}

	public String getStrGroupComboDisp() {
		return strGroupComboDisp;
	}

	public void setStrGroupComboDisp(String strGroupComboDisp) {
		this.strGroupComboDisp = strGroupComboDisp;
	}

	public String getStrCountedQtyBatchWise() {
		return strCountedQtyBatchWise;
	}

	public void setStrCountedQtyBatchWise(String strCountedQtyBatchWise) {
		this.strCountedQtyBatchWise = strCountedQtyBatchWise;
	}

	public String[] getStrChkItemDtlTmp() {
		return strChkItemDtlTmp;
	}

	public void setStrChkItemDtlTmp(String[] strChkItemDtlTmp) {
		this.strChkItemDtlTmp = strChkItemDtlTmp;
	}

	public String getStrItemId() {
		return strItemId;
	}

	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}

	public String getStrPrevVal() {
		return strPrevVal;
	}

	public void setStrPrevVal(String strPrevVal) {
		this.strPrevVal = strPrevVal;
	}

	public String getStrNewDetails() {
		return strNewDetails;
	}

	public void setStrNewDetails(String strNewDetails) {
		this.strNewDetails = strNewDetails;
	}

	public String getStrGroupId() {
		return strGroupId;
	}

	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	public String getStrStoreName() {
		return strStoreName;
	}

	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}

	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

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

	public String getStrWarningMsg() {
		return strWarningMsg;
	}

	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}

	public String getStrGroupList() {
		return strGroupList;
	}

	public void setStrGroupList(String strGroupList) {
		this.strGroupList = strGroupList;
	}

	public String getStrUnitId() {
		return strUnitId;
	}

	public void setStrUnitId(String strUnitId) {
		this.strUnitId = strUnitId;
	}

	public String getStrUnitList() {
		return strUnitList;
	}

	public void setStrUnitList(String strUnitList) {
		this.strUnitList = strUnitList;
	}

	public String getStrUnitValId() {
		return strUnitValId;
	}

	public void setStrUnitValId(String strUnitValId) {
		this.strUnitValId = strUnitValId;
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

	public String getStrCategoryName() {
		return strCategoryName;
	}

	public void setStrCategoryName(String strCategoryName) {
		this.strCategoryName = strCategoryName;
	}

	public String getStrLastVerifiedDate() {
		return strLastVerifiedDate;
	}

	public void setStrLastVerifiedDate(String strLastVerifiedDate) {
		this.strLastVerifiedDate = strLastVerifiedDate;
	}

	public String[] getStrCountedDtls() {
		return strCountedDtls;
	}

	public void setStrCountedDtls(String[] strCountedDtls) {
		this.strCountedDtls = strCountedDtls;
	}

	public String getStrGroupIdForItemSearch() {
		return strGroupIdForItemSearch;
	}

	public void setStrGroupIdForItemSearch(String strGroupIdForItemSearch) {
		this.strGroupIdForItemSearch = strGroupIdForItemSearch;
	}

	public String getStrGroupIdForItemSearchValues() {
		return strGroupIdForItemSearchValues;
	}

	public void setStrGroupIdForItemSearchValues(
			String strGroupIdForItemSearchValues) {
		this.strGroupIdForItemSearchValues = strGroupIdForItemSearchValues;
	}

	public String getStrPrevCountedFlag() {
		return strPrevCountedFlag;
	}

	public void setStrPrevCountedFlag(String strPrevCountedFlag) {
		this.strPrevCountedFlag = strPrevCountedFlag;
	}

	public String getStrPhysicalStockNo() {
		return strPhysicalStockNo;
	}

	public void setStrPhysicalStockNo(String strPhysicalStockNo) {
		this.strPhysicalStockNo = strPhysicalStockNo;
	}

	public String getStrItemCategoryId() {
		return strItemCategoryId;
	}

	public void setStrItemCategoryId(String strItemCategoryId) {
		this.strItemCategoryId = strItemCategoryId;
	}

	public String[] getItemParamValue() {
		return itemParamValue;
	}

	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
	}

	public String[] getStrItemBrandId() {
		return strItemBrandId;
	}

	public void setStrItemBrandId(String[] strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}

	public String[] getStrBatchSlNo() {
		return strBatchSlNo;
	}

	public void setStrBatchSlNo(String[] strBatchSlNo) {
		this.strBatchSlNo = strBatchSlNo;
	}

	public String[] getStrCountedQty() {
		return strCountedQty;
	}

	public void setStrCountedQty(String[] strCountedQty) {
		this.strCountedQty = strCountedQty;
	}

	public String[] getStrCountedQtyUnitId() {
		return strCountedQtyUnitId;
	}

	public void setStrCountedQtyUnitId(String[] strCountedQtyUnitId) {
		this.strCountedQtyUnitId = strCountedQtyUnitId;
	}

	public String[] getStrInHandQty() {
		return strInHandQty;
	}

	public void setStrInHandQty(String[] strInHandQty) {
		this.strInHandQty = strInHandQty;
	}

	public String[] getStrInHandQtyUnitId() {
		return strInHandQtyUnitId;
	}

	public void setStrInHandQtyUnitId(String[] strInHandQtyUnitId) {
		this.strInHandQtyUnitId = strInHandQtyUnitId;
	}

	public String[] getStrToBeCountedItemBatchDtls() {
		return strToBeCountedItemBatchDtls;
	}

	public void setStrToBeCountedItemBatchDtls(String[] strToBeCountedItemBatchDtls) {
		this.strToBeCountedItemBatchDtls = strToBeCountedItemBatchDtls;
	}

	public String[] getStrVarianceQty() {
		return strVarianceQty;
	}

	public void setStrVarianceQty(String[] strVarianceQty) {
		this.strVarianceQty = strVarianceQty;
	}

	public String[] getStrVarianceCost() {
		return strVarianceCost;
	}

	public void setStrVarianceCost(String[] strVarianceCost) {
		this.strVarianceCost = strVarianceCost;
	}

	public String[] getStrCountedItemDtls() {
		return strCountedItemDtls;
	}

	public void setStrCountedItemDtls(String[] strCountedItemDtls) {
		this.strCountedItemDtls = strCountedItemDtls;
	}

	public String getStrCommiteeTypeId() {
		return strCommiteeTypeId;
	}

	public void setStrCommiteeTypeId(String strCommiteeTypeId) {
		this.strCommiteeTypeId = strCommiteeTypeId;
	}

	public String[] getStrMemberRecommendation() {
		return strMemberRecommendation;
	}

	public void setStrMemberRecommendation(String[] strMemberRecommendation) {
		this.strMemberRecommendation = strMemberRecommendation;
	}

	public String[] getStrCommitteeMemberHidden() {
		return strCommitteeMemberHidden;
	}

	public void setStrCommitteeMemberHidden(String[] strCommitteeMemberHidden) {
		this.strCommitteeMemberHidden = strCommitteeMemberHidden;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	public String getStrCommitteeTypeId() {
		return strCommitteeTypeId;
	}

	public void setStrCommitteeTypeId(String strCommitteeTypeId) {
		this.strCommitteeTypeId = strCommitteeTypeId;
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

	/**
	 * @return the strFileNo
	 */
	public String getStrFileNo() {
		return strFileNo;
	}

	/**
	 * @param strFileNo the strFileNo to set
	 */
	public void setStrFileNo(String strFileNo) {
		this.strFileNo = strFileNo;
	}

	/**
	 * @return the strPageNo
	 */
	public String getStrPageNo() {
		return strPageNo;
	}

	/**
	 * @param strPageNo the strPageNo to set
	 */
	public void setStrPageNo(String strPageNo) {
		this.strPageNo = strPageNo;
	}

	/**
	 * @param strUserId the strUserId to set
	 */
	public void setStrUserId(String strUserId) {
		this.strUserId = strUserId;
	}

	/**
	 * @return the strUserId
	 */
	public String getStrUserId() {
		return strUserId;
	}

	
	
}
