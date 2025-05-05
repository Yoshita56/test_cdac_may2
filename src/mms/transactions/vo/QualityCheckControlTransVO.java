/**
 * 
 */
package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.TransferObject;

/**
 * Developer : Tanvi sappal
 * Version : 1.0
 * Date : 04/Jun/09
 *
 */

public class QualityCheckControlTransVO implements TransferObject {
	
	private static final long serialVersionUID = 02L;
	
	
	private String strGenericItemId = "";
	private String strItemBrandId = "";
	private String strBatchNo = "";
	private String strItemSerailNo = "";
	private String strItemSlNo = "";
	private String strStockStatusCode = "";
	private String strSerialNo = "";
	private String strHospitalCode = "";
	private String strItemCategoryNo = "";
	private String strGroupId = "";
	private String strSubGroupId = "";
	private String strInhandQty = "";
	private String strInhandQtyUnitId = "";
	private String strConsumedQty = "0";
	private String strConsumedQtyUnitId = "";
	private String strPONo = "";
	private String strPODate = "";
	private String strSupplierId = "";
	private String strManufacturerId = "";
	private String strFinalResult = "";
	private String strItemStatus = "";
	private String strDistributionFlag = "";
	private String strCommitteeNo = "";
	private String strCommitteeTypeId = "";
	private String strCommRemarksSlNo = "";
	private String strFinStartDate = "";
	private String strFinEndDate = "";
	private String strSeatId = "";
	private String strIsValid = "";
	private String strFileNo="";
	private String strPageNo="";
	private String strFileName="";
	private String strStoreId = "";
	private String strStoreName = "";
	private String strRequestType = "";
	private String strIsConsumableFlag = "0";
	private String[] strMemberRecommendation = null;
	private String strReservedFlag="";
	private String strRemarks = "";
	private String strIsBatchNo = "";
	private String strIsSlNo ="";
	private String strReSendFlg;
	
	private String[] strCommitteeMemberHidden = null;
	private String strHidDistributionFlag = "";
	
	private String strView = "";
	private String strItemId;
	private String strLabNameCombo;
	private String strMsgString = "";
	private String strMsgType = "";
	private String strUnitRateID;
	private WebRowSet storeNameComboWS = null;
	private WebRowSet itemCategoryComboWS = null;
	private WebRowSet groupComboWS = null;
	private WebRowSet subGroupCmboWS = null;
	private WebRowSet genericItemNameComboWS = null;
	private WebRowSet itemBrandNameComboWS = null;
	private WebRowSet batchNoSerialNoComboWS = null;
	private WebRowSet committeTypeWS = null;
	private WebRowSet committeMemberWS = null;
	private WebRowSet unitNameWS = null;
	private WebRowSet itemCategoryWS = null;
	private WebRowSet qualityViewWS = null;
	private WebRowSet storeNameWS = null;
	private WebRowSet itemSlNoWS = null;
	private WebRowSet wsDrugNameCombo=null;
	
	private String strStoreNameCmb = "";
	private String strItemCatNoCmb = "";
	private String strGroupNameCmb = "";
	private String strSubGroupCmb = "";
	private String strGenItemCmb = "";
	private String strItemNameCmb = "";
	private String strBatchNoSlNoCmb = "";
	private String strCommitteeTypeCmb = "";
	private String strCommitteeMember = "";
	private String  strUnitNameCmb = "";
	private String  itemCategoryCmb = "";
	private String strQualityViewDetails = null;
	private String strModuleId;

	private String strLabId;
	private String strLabName;
	private String strFromDate;
	private String strToDate;
	private String strCurrentDate;
	private String strLabSendNo;
	private String strBatchDtl;
	
	private String strCTRNumber;
	private String strSampleCodeNumber;
	private String strLabInchargeName;
	private String strFinancialStartYear;
	private String strFinancialEndYear;
	private String strDescription;
	private String strResendFlag;
	private String strReportNumber;
	private String strReportDate;
private String strLabSendDate;
private String strReceiveDate;
	
	public String getStrLabSendDate() {
		return strLabSendDate;
	}

	public void setStrLabSendDate(String strLabSendDate) {
		this.strLabSendDate = strLabSendDate;
	}
	
	
	
	public String getStrReportNumber() {
		return strReportNumber;
	}
	public void setStrReportNumber(String strReportNumber) {
		this.strReportNumber = strReportNumber;
	}
	public String getStrReportDate() {
		return strReportDate;
	}
	public void setStrReportDate(String strReportDate) {
		this.strReportDate = strReportDate;
	}
	public String getStrResendFlag() {
		return strResendFlag;
	}
	public void setStrResendFlag(String strResendFlag) {
		this.strResendFlag = strResendFlag;
	}
	public String getStrDescription() {
		return strDescription;
	}
	public void setStrDescription(String strDescription) {
		this.strDescription = strDescription;
	}
	public String getStrFinancialStartYear() {
		return strFinancialStartYear;
	}
	public void setStrFinancialStartYear(String strFinancialStartYear) {
		this.strFinancialStartYear = strFinancialStartYear;
	}
	public String getStrFinancialEndYear() {
		return strFinancialEndYear;
	}
	public void setStrFinancialEndYear(String strFinancialEndYear) {
		this.strFinancialEndYear = strFinancialEndYear;
	}
	public String getStrCTRNumber() {
		return strCTRNumber;
	}
	public void setStrCTRNumber(String strCTRNumber) {
		this.strCTRNumber = strCTRNumber;
	}
	public String getStrSampleCodeNumber() {
		return strSampleCodeNumber;
	}
	public void setStrSampleCodeNumber(String strSampleCodeNumber) {
		this.strSampleCodeNumber = strSampleCodeNumber;
	}
	public String getStrLabInchargeName() {
		return strLabInchargeName;
	}
	public void setStrLabInchargeName(String strLabInchargeName) {
		this.strLabInchargeName = strLabInchargeName;
	}
	public String getStrBatchDtl() {
		return strBatchDtl;
	}
	public void setStrBatchDtl(String strBatchDtl) {
		this.strBatchDtl = strBatchDtl;
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
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}
	public String getStrLabId() {
		return strLabId;
	}
	public void setStrLabId(String strLabId) {
		this.strLabId = strLabId;
	}
	public String getStrLabName() {
		return strLabName;
	}
	public void setStrLabName(String strLabName) {
		this.strLabName = strLabName;
	}
	/**
	 * @return the qualityViewWS
	 */
	public WebRowSet getQualityViewWS() {
		return qualityViewWS;
	}
	/**
	 * @param qualityViewWS the qualityViewWS to set
	 */
	public void setQualityViewWS(WebRowSet qualityViewWS) {
		this.qualityViewWS = qualityViewWS;
	}
	/**
	 * @return the strQualityViewDetails
	 */
	public String getStrQualityViewDetails() {
		return strQualityViewDetails;
	}
	/**
	 * @param strQualityViewDetails the strQualityViewDetails to set
	 */
	public void setStrQualityViewDetails(String strQualityViewDetails) {
		this.strQualityViewDetails = strQualityViewDetails;
	}
	/**
	 * @return the unitNameWS
	 */
	public WebRowSet getUnitNameWS() {
		return unitNameWS;
	}
	/**
	 * @param unitNameWS the unitNameWS to set
	 */
	public void setUnitNameWS(WebRowSet unitNameWS) {
		this.unitNameWS = unitNameWS;
	}
	/**
	 * @return the strUnitNameCmb
	 */
	public String getStrUnitNameCmb() {
		return strUnitNameCmb;
	}
	/**
	 * @param strUnitNameCmb the strUnitNameCmb to set
	 */
	public void setStrUnitNameCmb(String strUnitNameCmb) {
		this.strUnitNameCmb = strUnitNameCmb;
	}
	/**
	 * @return the committeTypeWS
	 */
	public WebRowSet getCommitteTypeWS() {
		return committeTypeWS;
	}
	/**
	 * @param committeTypeWS the committeTypeWS to set
	 */
	public void setCommitteTypeWS(WebRowSet committeTypeWS) {
		this.committeTypeWS = committeTypeWS;
	}
	/**
	 * @return the strCommitteeTypeCmb
	 */
	public String getStrCommitteeTypeCmb() {
		return strCommitteeTypeCmb;
	}
	/**
	 * @param strCommitteeTypeCmb the strCommitteeTypeCmb to set
	 */
	public void setStrCommitteeTypeCmb(String strCommitteeTypeCmb) {
		this.strCommitteeTypeCmb = strCommitteeTypeCmb;
	}
	/**
	 * @return the strStoreNameCmb
	 */
	public String getStrStoreNameCmb() {
		return strStoreNameCmb;
	}
	/**
	 * @param strStoreNameCmb the strStoreNameCmb to set
	 */
	public void setStrStoreNameCmb(String strStoreNameCmb) {
		this.strStoreNameCmb = strStoreNameCmb;
	}
	/**
	 * @return the strItemCatNoCmb
	 */
	public String getStrItemCatNoCmb() {
		return strItemCatNoCmb;
	}
	/**
	 * @param strItemCatNoCmb the strItemCatNoCmb to set
	 */
	public void setStrItemCatNoCmb(String strItemCatNoCmb) {
		this.strItemCatNoCmb = strItemCatNoCmb;
	}
	/**
	 * @return the strGroupNameCmb
	 */
	public String getStrGroupNameCmb() {
		return strGroupNameCmb;
	}
	/**
	 * @param strGroupNameCmb the strGroupNameCmb to set
	 */
	public void setStrGroupNameCmb(String strGroupNameCmb) {
		this.strGroupNameCmb = strGroupNameCmb;
	}
	/**
	 * @return the strSubGroupCmb
	 */
	public String getStrSubGroupCmb() {
		return strSubGroupCmb;
	}
	/**
	 * @param strSubGroupCmb the strSubGroupCmb to set
	 */
	public void setStrSubGroupCmb(String strSubGroupCmb) {
		this.strSubGroupCmb = strSubGroupCmb;
	}
	/**
	 * @return the strGenItemCmb
	 */
	public String getStrGenItemCmb() {
		return strGenItemCmb;
	}
	/**
	 * @param strGenItemCmb the strGenItemCmb to set
	 */
	public void setStrGenItemCmb(String strGenItemCmb) {
		this.strGenItemCmb = strGenItemCmb;
	}
	/**
	 * @return the strItemNameCmb
	 */
	public String getStrItemNameCmb() {
		return strItemNameCmb;
	}
	/**
	 * @param strItemNameCmb the strItemNameCmb to set
	 */
	public void setStrItemNameCmb(String strItemNameCmb) {
		this.strItemNameCmb = strItemNameCmb;
	}
	/**
	 * @return the strBatchNoSlNoCmb
	 */
	public String getStrBatchNoSlNoCmb() {
		return strBatchNoSlNoCmb;
	}
	/**
	 * @param strBatchNoSlNoCmb the strBatchNoSlNoCmb to set
	 */
	public void setStrBatchNoSlNoCmb(String strBatchNoSlNoCmb) {
		this.strBatchNoSlNoCmb = strBatchNoSlNoCmb;
	}
	/**
	 * @return the storeNameComboWS
	 */
	public WebRowSet getStoreNameComboWS() {
		return storeNameComboWS;
	}
	/**
	 * @param storeNameComboWS the storeNameComboWS to set
	 */
	public void setStoreNameComboWS(WebRowSet storeNameComboWS) {
		this.storeNameComboWS = storeNameComboWS;
	}
	/**
	 * @return the itemCategoryComboWS
	 */
	public WebRowSet getItemCategoryComboWS() {
		return itemCategoryComboWS;
	}
	/**
	 * @param itemCategoryComboWS the itemCategoryComboWS to set
	 */
	public void setItemCategoryComboWS(WebRowSet itemCategoryComboWS) {
		this.itemCategoryComboWS = itemCategoryComboWS;
	}
	/**
	 * @return the groupComboWS
	 */
	public WebRowSet getGroupComboWS() {
		return groupComboWS;
	}
	/**
	 * @param groupComboWS the groupComboWS to set
	 */
	public void setGroupComboWS(WebRowSet groupComboWS) {
		this.groupComboWS = groupComboWS;
	}
	/**
	 * @return the subGroupCmboWS
	 */
	public WebRowSet getSubGroupCmboWS() {
		return subGroupCmboWS;
	}
	/**
	 * @param subGroupCmboWS the subGroupCmboWS to set
	 */
	public void setSubGroupCmboWS(WebRowSet subGroupCmboWS) {
		this.subGroupCmboWS = subGroupCmboWS;
	}
	/**
	 * @return the genericItemNameComboWS
	 */
	public WebRowSet getGenericItemNameComboWS() {
		return genericItemNameComboWS;
	}
	/**
	 * @param genericItemNameComboWS the genericItemNameComboWS to set
	 */
	public void setGenericItemNameComboWS(WebRowSet genericItemNameComboWS) {
		this.genericItemNameComboWS = genericItemNameComboWS;
	}
	/**
	 * @return the itemBrandNameComboWS
	 */
	public WebRowSet getItemBrandNameComboWS() {
		return itemBrandNameComboWS;
	}
	/**
	 * @param itemBrandNameComboWS the itemBrandNameComboWS to set
	 */
	public void setItemBrandNameComboWS(WebRowSet itemBrandNameComboWS) {
		this.itemBrandNameComboWS = itemBrandNameComboWS;
	}
	/**
	 * @return the batchNoSerialNoComboWS
	 */
	public WebRowSet getBatchNoSerialNoComboWS() {
		return batchNoSerialNoComboWS;
	}
	/**
	 * @param batchNoSerialNoComboWS the batchNoSerialNoComboWS to set
	 */
	public void setBatchNoSerialNoComboWS(WebRowSet batchNoSerialNoComboWS) {
		this.batchNoSerialNoComboWS = batchNoSerialNoComboWS;
	}
	/**
	 * @return the strGenericItemId
	 */
	public String getStrGenericItemId() {
		return strGenericItemId;
	}
	/**
	 * @param strGenericItemId the strGenericItemId to set
	 */
	public void setStrGenericItemId(String strGenericItemId) {
		this.strGenericItemId = strGenericItemId;
	}
	/**
	 * @return the strItemBrandId
	 */
	public String getStrItemBrandId() {
		return strItemBrandId;
	}
	/**
	 * @param strItemBrandId the strItemBrandId to set
	 */
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}
	/**
	 * @return the strBatchNo
	 */
	public String getStrBatchNo() {
		return strBatchNo;
	}
	/**
	 * @param strBatchNo the strBatchNo to set
	 */
	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}
	/**
	 * @return the strItemSerailNo
	 */
	public String getStrItemSerailNo() {
		return strItemSerailNo;
	}
	/**
	 * @param strItemSerailNo the strItemSerailNo to set
	 */
	public void setStrItemSerailNo(String strItemSerailNo) {
		this.strItemSerailNo = strItemSerailNo;
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
	 * @return the strSerialNo
	 */
	public String getStrSerialNo() {
		return strSerialNo;
	}
	/**
	 * @param strSerialNo the strSerialNo to set
	 */
	public void setStrSerialNo(String strSerialNo) {
		this.strSerialNo = strSerialNo;
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
	 * @return the strGroupId
	 */
	public String getStrGroupId() {
		return strGroupId;
	}
	/**
	 * @param strGroupId the strGroupId to set
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}
	/**
	 * @return the strSubGroupId
	 */
	public String getStrSubGroupId() {
		return strSubGroupId;
	}
	/**
	 * @param strSubGroupId the strSubGroupId to set
	 */
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}
	/**
	 * @return the strInhandQty
	 */
	public String getStrInhandQty() {
		return strInhandQty;
	}
	/**
	 * @param strInhandQty the strInhandQty to set
	 */
	public void setStrInhandQty(String strInhandQty) {
		this.strInhandQty = strInhandQty;
	}
	/**
	 * @return the strInhandQtyUnitId
	 */
	public String getStrInhandQtyUnitId() {
		return strInhandQtyUnitId;
	}
	/**
	 * @param strInhandQtyUnitId the strInhandQtyUnitId to set
	 */
	public void setStrInhandQtyUnitId(String strInhandQtyUnitId) {
		this.strInhandQtyUnitId = strInhandQtyUnitId;
	}
	/**
	 * @return the strConsumedQty
	 */
	public String getStrConsumedQty() {
		return strConsumedQty;
	}
	/**
	 * @param strConsumedQty the strConsumedQty to set
	 */
	public void setStrConsumedQty(String strConsumedQty) {
		this.strConsumedQty = strConsumedQty;
	}
	/**
	 * @return the strConsumedQtyUnitId
	 */
	public String getStrConsumedQtyUnitId() {
		return strConsumedQtyUnitId;
	}
	/**
	 * @param strConsumedQtyUnitId the strConsumedQtyUnitId to set
	 */
	public void setStrConsumedQtyUnitId(String strConsumedQtyUnitId) {
		this.strConsumedQtyUnitId = strConsumedQtyUnitId;
	}
	/**
	 * @return the strPONo
	 */
	public String getStrPONo() {
		return strPONo;
	}
	/**
	 * @param strPONo the strPONo to set
	 */
	public void setStrPONo(String strPONo) {
		this.strPONo = strPONo;
	}
	/**
	 * @return the strPODate
	 */
	public String getStrPODate() {
		return strPODate;
	}
	/**
	 * @param strPODate the strPODate to set
	 */
	public void setStrPODate(String strPODate) {
		this.strPODate = strPODate;
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
	 * @return the strManufacturerId
	 */
	public String getStrManufacturerId() {
		return strManufacturerId;
	}
	/**
	 * @param strManufacturerId the strManufacturerId to set
	 */
	public void setStrManufacturerId(String strManufacturerId) {
		this.strManufacturerId = strManufacturerId;
	}
	/**
	 * @return the strFinalResult
	 */
	public String getStrFinalResult() {
		return strFinalResult;
	}
	/**
	 * @param strFinalResult the strFinalResult to set
	 */
	public void setStrFinalResult(String strFinalResult) {
		this.strFinalResult = strFinalResult;
	}
	/**
	 * @return the strItemStatus
	 */
	public String getStrItemStatus() {
		return strItemStatus;
	}
	/**
	 * @param strItemStatus the strItemStatus to set
	 */
	public void setStrItemStatus(String strItemStatus) {
		this.strItemStatus = strItemStatus;
	}
	/**
	 * @return the strDistributionFlag
	 */
	public String getStrDistributionFlag() {
		return strDistributionFlag;
	}
	/**
	 * @param strDistributionFlag the strDistributionFlag to set
	 */
	public void setStrDistributionFlag(String strDistributionFlag) {
		this.strDistributionFlag = strDistributionFlag;
	}
	/**
	 * @return the strCommitteeNo
	 */
	public String getStrCommitteeNo() {
		return strCommitteeNo;
	}
	/**
	 * @param strCommitteeNo the strCommitteeNo to set
	 */
	public void setStrCommitteeNo(String strCommitteeNo) {
		this.strCommitteeNo = strCommitteeNo;
	}
	/**
	 * @return the strCommitteeTypeId
	 */
	public String getStrCommitteeTypeId() {
		return strCommitteeTypeId;
	}
	/**
	 * @param strCommitteeTypeId the strCommitteeTypeId to set
	 */
	public void setStrCommitteeTypeId(String strCommitteeTypeId) {
		this.strCommitteeTypeId = strCommitteeTypeId;
	}
	/**
	 * @return the strCommRemarksSlNo
	 */
	public String getStrCommRemarksSlNo() {
		return strCommRemarksSlNo;
	}
	/**
	 * @param strCommRemarksSlNo the strCommRemarksSlNo to set
	 */
	public void setStrCommRemarksSlNo(String strCommRemarksSlNo) {
		this.strCommRemarksSlNo = strCommRemarksSlNo;
	}
	/**
	 * @return the strFinStartDate
	 */
	public String getStrFinStartDate() {
		return strFinStartDate;
	}
	/**
	 * @param strFinStartDate the strFinStartDate to set
	 */
	public void setStrFinStartDate(String strFinStartDate) {
		this.strFinStartDate = strFinStartDate;
	}
	/**
	 * @return the strFinEndDate
	 */
	public String getStrFinEndDate() {
		return strFinEndDate;
	}
	/**
	 * @param strFinEndDate the strFinEndDate to set
	 */
	public void setStrFinEndDate(String strFinEndDate) {
		this.strFinEndDate = strFinEndDate;
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
	 * @return the strStoreId
	 */
	public String getStrStoreId() {
		return strStoreId;
	}
	/**
	 * @param strStoreId the strStoreId to set
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
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
	 * @return the strRequestType
	 */
	public String getStrRequestType() {
		return strRequestType;
	}
	/**
	 * @param strRequestType the strRequestType to set
	 */
	public void setStrRequestType(String strRequestType) {
		this.strRequestType = strRequestType;
	}
	/**
	 * @return the committeMemberWS
	 */
	public WebRowSet getCommitteMemberWS() {
		return committeMemberWS;
	}
	/**
	 * @param committeMemberWS the committeMemberWS to set
	 */
	public void setCommitteMemberWS(WebRowSet committeMemberWS) {
		this.committeMemberWS = committeMemberWS;
	}
	/**
	 * @return the strCommitteeMember
	 */
	public String getStrCommitteeMember() {
		return strCommitteeMember;
	}
	/**
	 * @param strCommitteeMember the strCommitteeMember to set
	 */
	public void setStrCommitteeMember(String strCommitteeMember) {
		this.strCommitteeMember = strCommitteeMember;
	}
	/**
	 * @return the strIsConsumableFlag
	 */
	public String getStrIsConsumableFlag() {
		return strIsConsumableFlag;
	}
	/**
	 * @param strIsConsumableFlag the strIsConsumableFlag to set
	 */
	public void setStrIsConsumableFlag(String strIsConsumableFlag) {
		this.strIsConsumableFlag = strIsConsumableFlag;
	}
	/**
	 * @return the strMemberRecommendation
	 */
	public String[] getStrMemberRecommendation() {
		return strMemberRecommendation;
	}
	/**
	 * @param strMemberRecommendation the strMemberRecommendation to set
	 */
	public void setStrMemberRecommendation(String[] strMemberRecommendation) {
		this.strMemberRecommendation = strMemberRecommendation;
	}
	/**
	 * @return the strCommitteeMemberHidden
	 */
	public String[] getStrCommitteeMemberHidden() {
		return strCommitteeMemberHidden;
	}
	/**
	 * @param strCommitteeMemberHidden the strCommitteeMemberHidden to set
	 */
	public void setStrCommitteeMemberHidden(String[] strCommitteeMemberHidden) {
		this.strCommitteeMemberHidden = strCommitteeMemberHidden;
	}
	/**
	 * @return the strView
	 */
	public String getStrView() {
		return strView;
	}
	/**
	 * @param strView the strView to set
	 */
	public void setStrView(String strView) {
		this.strView = strView;
	}
	/**
	 * @return the itemCategoryWS
	 */
	public WebRowSet getItemCategoryWS() {
		return itemCategoryWS;
	}
	/**
	 * @param itemCategoryWS the itemCategoryWS to set
	 */
	public void setItemCategoryWS(WebRowSet itemCategoryWS) {
		this.itemCategoryWS = itemCategoryWS;
	}
	/**
	 * @return the itemCategoryCmb
	 */
	public String getItemCategoryCmb() {
		return itemCategoryCmb;
	}
	/**
	 * @param itemCategoryCmb the itemCategoryCmb to set
	 */
	public void setItemCategoryCmb(String itemCategoryCmb) {
		this.itemCategoryCmb = itemCategoryCmb;
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
	 * @return the strHidDistributionFlag
	 */
	public String getStrHidDistributionFlag() {
		return strHidDistributionFlag;
	}
	/**
	 * @param strHidDistributionFlag the strHidDistributionFlag to set
	 */
	public void setStrHidDistributionFlag(String strHidDistributionFlag) {
		this.strHidDistributionFlag = strHidDistributionFlag;
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
	 * @return the storeNameWS
	 */
	public WebRowSet getStoreNameWS() {
		return storeNameWS;
	}
	/**
	 * @param storeNameWS the storeNameWS to set
	 */
	public void setStoreNameWS(WebRowSet storeNameWS) {
		this.storeNameWS = storeNameWS;
	}
	/**
	 * @return the strIsBatchNo
	 */
	public String getStrIsBatchNo() {
		return strIsBatchNo;
	}
	/**
	 * @param strIsBatchNo the strIsBatchNo to set
	 */
	public void setStrIsBatchNo(String strIsBatchNo) {
		this.strIsBatchNo = strIsBatchNo;
	}
	/**
	 * @return the strIsSlNo
	 */
	public String getStrIsSlNo() {
		return strIsSlNo;
	}
	/**
	 * @param strIsSlNo the strIsSlNo to set
	 */
	public void setStrIsSlNo(String strIsSlNo) {
		this.strIsSlNo = strIsSlNo;
	}
	/**
	 * @return the itemSlNoWS
	 */
	public WebRowSet getItemSlNoWS() {
		return itemSlNoWS;
	}
	/**
	 * @param itemSlNoWS the itemSlNoWS to set
	 */
	public void setItemSlNoWS(WebRowSet itemSlNoWS) {
		this.itemSlNoWS = itemSlNoWS;
	}
	/**
	 * @return the strStoreName
	 */
	public String getStrStoreName() {
		return strStoreName;
	}
	/**
	 * @param strStoreName the strStoreName to set
	 */
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	/**
	 * @return the strItemSlNo
	 */
	public String getStrItemSlNo() {
		return strItemSlNo;
	}
	/**
	 * @param strItemSlNo the strItemSlNo to set
	 */
	public void setStrItemSlNo(String strItemSlNo) {
		this.strItemSlNo = strItemSlNo;
	}
	public String getStrFileNo() {
		return strFileNo;
	}
	public void setStrFileNo(String strFileNo) {
		this.strFileNo = strFileNo;
	}
	public String getStrPageNo() {
		return strPageNo;
	}
	public void setStrPageNo(String strPageNo) {
		this.strPageNo = strPageNo;
	}
	public String getStrFileName() {
		return strFileName;
	}
	public void setStrFileName(String strFileName) {
		this.strFileName = strFileName;
	}
	public String getStrModuleId() {
		return strModuleId;
	}
	public void setStrModuleId(String strModuleId) {
		this.strModuleId = strModuleId;
	}
	public String getStrUnitRateID() {
		return strUnitRateID;
	}
	public void setStrUnitRateID(String strUnitRateID) {
		this.strUnitRateID = strUnitRateID;
	}
	public String getStrItemId() {
		return strItemId;
	}
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}
	public String getStrLabNameCombo() {
		return strLabNameCombo;
	}
	public void setStrLabNameCombo(String strLabNameCombo) {
		this.strLabNameCombo = strLabNameCombo;
	}
	public String getStrReSendFlg() {
		return strReSendFlg;
	}
	public void setStrReSendFlg(String strReSendFlg) {
		this.strReSendFlg = strReSendFlg;
	}
	public WebRowSet getWsDrugNameCombo() {
		return wsDrugNameCombo;
	}
	public void setWsDrugNameCombo(WebRowSet wsDrugNameCombo) {
		this.wsDrugNameCombo = wsDrugNameCombo;
	}
	public String getStrLabSendNo() {
		return strLabSendNo;
	}
	public void setStrLabSendNo(String strLabSendNo) {
		this.strLabSendNo = strLabSendNo;
	}

	public String getStrReceiveDate() {
		return strReceiveDate;
	}

	public void setStrReceiveDate(String strReceiveDate) {
		this.strReceiveDate = strReceiveDate;
	}
		

	
}
