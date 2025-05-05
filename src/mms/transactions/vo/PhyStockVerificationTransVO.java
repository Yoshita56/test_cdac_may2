package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

public class PhyStockVerificationTransVO {
	
	private String strMsgType = "";
	private String strMsgString = "";
	
	private String strGrpMode = "0";
	
	private String strUnitValId = "";
	private String strItemValId = "";
	
	private String strStoreTypeId = "";
	private String strItemId = "";
	private String strGroupId = "";
	private String strStoreId ="";
	private String strItemCategoryId = "0";
	private String strPhysicalStockNo = "";
	private String strSeatId="";
	private String strStockNo="";
	private String strItemCategNo="";
	private String strFinancialStartDate = "";
	private String strCategoryName = "";
	private String strLastVerifiedDate = "";
	private String strCommitteeTypeId="";
	private String strPrevCountedFlag= "";
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
	private String strPhysicalCount = "0";
	private String strHospitalCode = "";
	private String []strCountedItemDtls=null;
	private String strFromRow = "0";
	private String strToRow = "0";
	private String[] strCountedDtls = null;
	private String strCountedQtyBatchWise="";
	private String strCommiteeTypeId="";
	private String[] strMemberRecommendation=null;
	private String[] strCommitteeMemberHidden=null;
	private String strFileExt="";
	private String strFileName="";
	private String strFileNo="";
	private String strPageNo="";
	
	private String strRemarks="";
	private String strTemp = "";
	private String  strCommitteeType="";
	private String  strPeriodId="";
	private WebRowSet strGroupWs = null;
	
	private WebRowSet strItemDtlWs = null;
	private WebRowSet strUnitWs = null;
	private WebRowSet strBrandWs = null;
	private WebRowSet committeTypeWS=null;
	private WebRowSet wsItemSearchGroupList = null;
	private WebRowSet wsCountedItemsList = null;
	WebRowSet committeMemberWS=null;
	private WebRowSet strNewItemDtlWs = null;
	
	public WebRowSet getStrItemDtlWs() {
		return strItemDtlWs;
	}
	public void setStrItemDtlWs(WebRowSet strItemDtlWs) {
		this.strItemDtlWs = strItemDtlWs;
	}
	public WebRowSet getStrGroupWs() {
		return strGroupWs;
	}
	public void setStrGroupWs(WebRowSet strGroupWs) {
		this.strGroupWs = strGroupWs;
	}
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrMsgType() {
		return strMsgType;
	}
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}
	public String getStrMsgString() {
		return strMsgString;
	}
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}
	public String getStrGroupId() {
		return strGroupId;
	}
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}
	
	public WebRowSet getStrNewItemDtlWs() {
		return strNewItemDtlWs;
	}
	public void setStrNewItemDtlWs(WebRowSet strNewItemDtlWs) {
		this.strNewItemDtlWs = strNewItemDtlWs;
	}
	public WebRowSet getStrUnitWs() {
		return strUnitWs;
	}
	public void setStrUnitWs(WebRowSet strUnitWs) {
		this.strUnitWs = strUnitWs;
	}
	public String getStrTemp() {
		return strTemp;
	}
	public void setStrTemp(String strTemp) {
		this.strTemp = strTemp;
	}
	
	public WebRowSet getStrBrandWs() {
		return strBrandWs;
	}
	public void setStrBrandWs(WebRowSet strBrandWs) {
		this.strBrandWs = strBrandWs;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrFromRow() {
		return strFromRow;
	}
	public void setStrFromRow(String strFromRow) {
		this.strFromRow = strFromRow;
	}
	public String getStrToRow() {
		return strToRow;
	}
	public void setStrToRow(String strToRow) {
		this.strToRow = strToRow;
	}
	public String getStrItemId() {
		return strItemId;
	}
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}
	public String[] getStrItemBrandId() {
		return strItemBrandId;
	}
	public void setStrItemBrandId(String[] strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}
	
	public String getStrPhysicalStockNo() {
		return strPhysicalStockNo;
	}
	public void setStrPhysicalStockNo(String strPhysicalStockNo) {
		this.strPhysicalStockNo = strPhysicalStockNo;
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
	public String getStrUnitValId() {
		return strUnitValId;
	}
	public void setStrUnitValId(String strUnitValId) {
		this.strUnitValId = strUnitValId;
	}
	public String getStrItemValId() {
		return strItemValId;
	}
	public void setStrItemValId(String strItemValId) {
		this.strItemValId = strItemValId;
	}
	public String getStrPhysicalCount() {
		return strPhysicalCount;
	}
	public void setStrPhysicalCount(String strPhysicalCount) {
		this.strPhysicalCount = strPhysicalCount;
	}
	public String getStrItemCategoryId() {
		return strItemCategoryId;
	}
	public void setStrItemCategoryId(String strItemCategoryId) {
		this.strItemCategoryId = strItemCategoryId;
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
	public String getStrGrpMode() {
		return strGrpMode;
	}
	public void setStrGrpMode(String strGrpMode) {
		this.strGrpMode = strGrpMode;
	}
	public WebRowSet getWsCountedItemsList() {
		return wsCountedItemsList;
	}
	public void setWsCountedItemsList(WebRowSet wsCountedItemsList) {
		this.wsCountedItemsList = wsCountedItemsList;
	}
	public WebRowSet getWsItemSearchGroupList() {
		return wsItemSearchGroupList;
	}
	public void setWsItemSearchGroupList(WebRowSet wsItemSearchGroupList) {
		this.wsItemSearchGroupList = wsItemSearchGroupList;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String[] getItemParamValue() {
		return itemParamValue;
	}
	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
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
	public String[] getStrToBeCountedItemBatchDtls() {
		return strToBeCountedItemBatchDtls;
	}
	public void setStrToBeCountedItemBatchDtls(String[] strToBeCountedItemBatchDtls) {
		this.strToBeCountedItemBatchDtls = strToBeCountedItemBatchDtls;
	}
	public String[] getStrCountedDtls() {
		return strCountedDtls;
	}
	public void setStrCountedDtls(String[] strCountedDtls) {
		this.strCountedDtls = strCountedDtls;
	}
	public String[] getStrCountedItemDtls() {
		return strCountedItemDtls;
	}
	public void setStrCountedItemDtls(String[] strCountedItemDtls) {
		this.strCountedItemDtls = strCountedItemDtls;
	}
	public String getStrPrevCountedFlag() {
		return strPrevCountedFlag;
	}
	public void setStrPrevCountedFlag(String strPrevCountedFlag) {
		this.strPrevCountedFlag = strPrevCountedFlag;
	}
	public String getStrCountedQtyBatchWise() {
		return strCountedQtyBatchWise;
	}
	public void setStrCountedQtyBatchWise(String strCountedQtyBatchWise) {
		this.strCountedQtyBatchWise = strCountedQtyBatchWise;
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
	public WebRowSet getCommitteTypeWS() {
		return committeTypeWS;
	}
	public void setCommitteTypeWS(WebRowSet committeTypeWS) {
		this.committeTypeWS = committeTypeWS;
	}
	public String getStrCommiteeTypeId() {
		return strCommiteeTypeId;
	}
	public void setStrCommiteeTypeId(String strCommiteeTypeId) {
		this.strCommiteeTypeId = strCommiteeTypeId;
	}
	public WebRowSet getCommitteMemberWS() {
		return committeMemberWS;
	}
	public void setCommitteMemberWS(WebRowSet committeMemberWS) {
		this.committeMemberWS = committeMemberWS;
	}
	public String getStrCommitteeType() {
		return strCommitteeType;
	}
	public void setStrCommitteeType(String strCommitteeType) {
		this.strCommitteeType = strCommitteeType;
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
	public String getStrPeriodId() {
		return strPeriodId;
	}
	public void setStrPeriodId(String strPeriodId) {
		this.strPeriodId = strPeriodId;
	}
	/**
	 * @return the strFileExt
	 */
	public String getStrFileExt() {
		return strFileExt;
	}
	/**
	 * @param strFileExt the strFileExt to set
	 */
	public void setStrFileExt(String strFileExt) {
		this.strFileExt = strFileExt;
	}
	/**
	 * @return the strFileName
	 */
	public String getStrFileName() {
		return strFileName;
	}
	/**
	 * @param strFileName the strFileName to set
	 */
	public void setStrFileName(String strFileName) {
		this.strFileName = strFileName;
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
	
}
