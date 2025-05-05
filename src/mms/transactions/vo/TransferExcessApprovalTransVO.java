/**
 * 
 */
package mms.transactions.vo;

/**
 * @author santoshsinghchauhan
 * @date Jul 23, 2014
 * @file TransferExcessApprovalTransVO.java
 */

import javax.sql.rowset.WebRowSet;

/**
 * The Class TransferRequestTransVO.
 */
public class TransferExcessApprovalTransVO {

	/** The str msg string. */
	private String strMsgString = "";

	/** The str msg type. */
	private String strMsgType = "";

	/** The str ct date. */
	private String strCtDate = "";

	/** The str effective from. */
	private String strEffectiveFrom = "";

	/** The str hospital code. */
	private String strHospitalCode = "";

	/** The str seat id. */
	private String strSeatId = "";

	/** The str remarks. */
	private String strRemarks = "";

	/** The str manufacture id. */
	private String strManufactureId = "";

	/** The str manufacture name. */
	private String strManufactureName = "";

	/** The Wb transfer order detail. */
	private WebRowSet wbTransferRequestDtl = null;

	/** The str supplied by. */
	private String strSuppliedBy = "0";

	/** The str demanded qty. */
	private String strDemandedQty = "";

	/** The str approved by id. */
	private String strApprovedById = "";

	/** The str approved by. */
	private String strApprovedBy = "";

	/** The str req status. */
	private String strReqStatus = "";

	/** The str request no. */
	private String strRequestNo = "";

	/** The str chk. */
	private String strChk = "";

	/** The str item brand name. */
	private String strItemBrandName = "";

	/** The str item brand id. */
	private String strItemBrandId = "";

	/** The str item name combo. */
	private String strItemNameCombo = "";

	/** The approved by combo ws. */
	private WebRowSet approvedByComboWS = null;

	/** The str item name. */
	private String strItemName = "";

	/** The str item id. */
	private String strItemId = "";

	/** The str approved by combo. */
	private String strApprovedByCombo = "";

	/** The str approved date. */
	private String strApprovedDate = "";

	/** The str batch no. */
	private String strBatchNo;

	/** The str batch hidden value. */
	private String[] strBatchHiddenValue = { "" };

	/** The str store id. */
	private String strStoreId = "";

	/** The str store name. */
	private String strStoreName = "";

	/** The str batch dtl ws. */
	private WebRowSet strBatchDtlWs = null;

	/** The str item category no. */
	private String strItemCategoryNo = "10";

	/** The str approved by ws. */
	private WebRowSet strApprovedByWs = null;

	/** The str mode. */
	private String strMode;

	/** The str excess qty. */
	private String[] strSancQty = { "" };

	/** The str batch no detail. */
	private String strBatchNoDetail = "";

	/** The str avl qty. */
	private String strAvlQty = "";

	/** The str mfg date. */
	private String strMfgDate = "";

	/** The str exp date. */
	private String strExpDate = "";
	
	/** The str req type id. */
	private String strReqTypeId = "";
	
	/** The str req no. */
	private String strReqNo = "";
	
	/** The str indent details ws. */
	private WebRowSet strIndentDetailsWs = null;
	
	/** The str indent name. */
	private String strIndentName = "";
	
	/** The str ins sanc qty. */
	private String[] strInsSancQty = null;
	
	/** The str reapproval flag. */
	private String strReApprovalFlag = "";

	/** The str approval flag */
	private String strApprovalNo = "";
	
	/** The str insert hidden value. */
	private String[] strInsertHiddenValue = null;
	
	/** The str item catg no. */
	private String strItemCatgNo = "";
	
	/** The str approval type. */
	private String strApprovalType = "";
	
	/** The primary key */
	private String[] strPrimaryKey = null;
	
	/** The str item remarks. */
	private String[] strItemRemarks = null;
	
	/** The user id */
	private String strUserId = "";
	
	/**  */
	private String strUserLevel = "";
	
	/** The str level type. */
	private String strLevelType = "";
	
	/** The str ip addr. */
	private String strIpAddr = "";
	
	/** The str to store id. */
	private String strToStoreId = "";
	
	private String strApprovalFlag="1";
	
	private String strRequestDate="";

	public String getStrRequestDate() {
		return strRequestDate;
	}

	public void setStrRequestDate(String strRequestDate) {
		this.strRequestDate = strRequestDate;
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
	 * @return the strEffectiveFrom
	 */
	public String getStrEffectiveFrom() {
		return strEffectiveFrom;
	}

	/**
	 * @param strEffectiveFrom the strEffectiveFrom to set
	 */
	public void setStrEffectiveFrom(String strEffectiveFrom) {
		this.strEffectiveFrom = strEffectiveFrom;
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
	 * @return the strManufactureId
	 */
	public String getStrManufactureId() {
		return strManufactureId;
	}

	/**
	 * @param strManufactureId the strManufactureId to set
	 */
	public void setStrManufactureId(String strManufactureId) {
		this.strManufactureId = strManufactureId;
	}

	/**
	 * @return the strManufactureName
	 */
	public String getStrManufactureName() {
		return strManufactureName;
	}

	/**
	 * @param strManufactureName the strManufactureName to set
	 */
	public void setStrManufactureName(String strManufactureName) {
		this.strManufactureName = strManufactureName;
	}

	/**
	 * @return the strSuppliedBy
	 */
	public String getStrSuppliedBy() {
		return strSuppliedBy;
	}

	/**
	 * @param strSuppliedBy the strSuppliedBy to set
	 */
	public void setStrSuppliedBy(String strSuppliedBy) {
		this.strSuppliedBy = strSuppliedBy;
	}

	/**
	 * @return the strDemandedQty
	 */
	public String getStrDemandedQty() {
		return strDemandedQty;
	}

	/**
	 * @param strDemandedQty the strDemandedQty to set
	 */
	public void setStrDemandedQty(String strDemandedQty) {
		this.strDemandedQty = strDemandedQty;
	}

	/**
	 * @return the strApprovedById
	 */
	public String getStrApprovedById() {
		return strApprovedById;
	}

	/**
	 * @param strApprovedById the strApprovedById to set
	 */
	public void setStrApprovedById(String strApprovedById) {
		this.strApprovedById = strApprovedById;
	}

	/**
	 * @return the strApprovedBy
	 */
	public String getStrApprovedBy() {
		return strApprovedBy;
	}

	/**
	 * @param strApprovedBy the strApprovedBy to set
	 */
	public void setStrApprovedBy(String strApprovedBy) {
		this.strApprovedBy = strApprovedBy;
	}

	/**
	 * @return the strReqStatus
	 */
	public String getStrReqStatus() {
		return strReqStatus;
	}

	/**
	 * @param strReqStatus the strReqStatus to set
	 */
	public void setStrReqStatus(String strReqStatus) {
		this.strReqStatus = strReqStatus;
	}

	/**
	 * @return the strRequestNo
	 */
	public String getStrRequestNo() {
		return strRequestNo;
	}

	/**
	 * @param strRequestNo the strRequestNo to set
	 */
	public void setStrRequestNo(String strRequestNo) {
		this.strRequestNo = strRequestNo;
	}

	/**
	 * @return the strChk
	 */
	public String getStrChk() {
		return strChk;
	}

	/**
	 * @param strChk the strChk to set
	 */
	public void setStrChk(String strChk) {
		this.strChk = strChk;
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
	 * @return the strItemNameCombo
	 */
	public String getStrItemNameCombo() {
		return strItemNameCombo;
	}

	/**
	 * @param strItemNameCombo the strItemNameCombo to set
	 */
	public void setStrItemNameCombo(String strItemNameCombo) {
		this.strItemNameCombo = strItemNameCombo;
	}

	/**
	 * @return the approvedByComboWS
	 */
	public WebRowSet getApprovedByComboWS() {
		return approvedByComboWS;
	}

	/**
	 * @param approvedByComboWS the approvedByComboWS to set
	 */
	public void setApprovedByComboWS(WebRowSet approvedByComboWS) {
		this.approvedByComboWS = approvedByComboWS;
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
	 * @return the strItemId
	 */
	public String getStrItemId() {
		return strItemId;
	}

	/**
	 * @param strItemId the strItemId to set
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}

	/**
	 * @return the strApprovedByCombo
	 */
	public String getStrApprovedByCombo() {
		return strApprovedByCombo;
	}

	/**
	 * @param strApprovedByCombo the strApprovedByCombo to set
	 */
	public void setStrApprovedByCombo(String strApprovedByCombo) {
		this.strApprovedByCombo = strApprovedByCombo;
	}

	/**
	 * @return the strApprovedDate
	 */
	public String getStrApprovedDate() {
		return strApprovedDate;
	}

	/**
	 * @param strApprovedDate the strApprovedDate to set
	 */
	public void setStrApprovedDate(String strApprovedDate) {
		this.strApprovedDate = strApprovedDate;
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
	 * @return the strBatchHiddenValue
	 */
	public String[] getStrBatchHiddenValue() {
		return strBatchHiddenValue;
	}

	/**
	 * @param strBatchHiddenValue the strBatchHiddenValue to set
	 */
	public void setStrBatchHiddenValue(String[] strBatchHiddenValue) {
		this.strBatchHiddenValue = strBatchHiddenValue;
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
	 * @return the strBatchDtlWs
	 */
	public WebRowSet getStrBatchDtlWs() {
		return strBatchDtlWs;
	}

	/**
	 * @param strBatchDtlWs the strBatchDtlWs to set
	 */
	public void setStrBatchDtlWs(WebRowSet strBatchDtlWs) {
		this.strBatchDtlWs = strBatchDtlWs;
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
	 * @return the strApprovedByWs
	 */
	public WebRowSet getStrApprovedByWs() {
		return strApprovedByWs;
	}

	/**
	 * @param strApprovedByWs the strApprovedByWs to set
	 */
	public void setStrApprovedByWs(WebRowSet strApprovedByWs) {
		this.strApprovedByWs = strApprovedByWs;
	}

	/**
	 * @return the strMode
	 */
	public String getStrMode() {
		return strMode;
	}

	/**
	 * @param strMode the strMode to set
	 */
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}

	/**
	 * @return the strSancQty
	 */
	public String[] getStrSancQty() {
		return strSancQty;
	}

	/**
	 * @param strSancQty the strSancQty to set
	 */
	public void setStrSancQty(String[] strSancQty) {
		this.strSancQty = strSancQty;
	}

	/**
	 * @return the strBatchNoDetail
	 */
	public String getStrBatchNoDetail() {
		return strBatchNoDetail;
	}

	/**
	 * @param strBatchNoDetail the strBatchNoDetail to set
	 */
	public void setStrBatchNoDetail(String strBatchNoDetail) {
		this.strBatchNoDetail = strBatchNoDetail;
	}

	/**
	 * @return the strAvlQty
	 */
	public String getStrAvlQty() {
		return strAvlQty;
	}

	/**
	 * @param strAvlQty the strAvlQty to set
	 */
	public void setStrAvlQty(String strAvlQty) {
		this.strAvlQty = strAvlQty;
	}

	/**
	 * @return the strMfgDate
	 */
	public String getStrMfgDate() {
		return strMfgDate;
	}

	/**
	 * @param strMfgDate the strMfgDate to set
	 */
	public void setStrMfgDate(String strMfgDate) {
		this.strMfgDate = strMfgDate;
	}

	/**
	 * @return the strExpDate
	 */
	public String getStrExpDate() {
		return strExpDate;
	}

	/**
	 * @param strExpDate the strExpDate to set
	 */
	public void setStrExpDate(String strExpDate) {
		this.strExpDate = strExpDate;
	}

	/**
	 * @return the wbTransferRequestDtl
	 */
	public WebRowSet getWbTransferRequestDtl() {
		return wbTransferRequestDtl;
	}

	/**
	 * @param wbTransferRequestDtl the wbTransferRequestDtl to set
	 */
	public void setWbTransferRequestDtl(WebRowSet wbTransferRequestDtl) {
		this.wbTransferRequestDtl = wbTransferRequestDtl;
	}

	public String getStrReqTypeId() {
		return strReqTypeId;
	}

	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}

	public String getStrReqNo() {
		return strReqNo;
	}

	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
	}

	public WebRowSet getStrIndentDetailsWs() {
		return strIndentDetailsWs;
	}

	public void setStrIndentDetailsWs(WebRowSet strIndentDetailsWs) {
		this.strIndentDetailsWs = strIndentDetailsWs;
	}

	public String getStrIndentName() {
		return strIndentName;
	}

	public void setStrIndentName(String strIndentName) {
		this.strIndentName = strIndentName;
	}

	public String[] getStrInsSancQty() {
		return strInsSancQty;
	}

	public void setStrInsSancQty(String[] strInsSancQty) {
		this.strInsSancQty = strInsSancQty;
	}

	public String getStrReApprovalFlag() {
		return strReApprovalFlag;
	}

	public void setStrReApprovalFlag(String strReApprovalFlag) {
		this.strReApprovalFlag = strReApprovalFlag;
	}

	public String getStrApprovalNo() {
		return strApprovalNo;
	}

	public void setStrApprovalNo(String strApprovalNo) {
		this.strApprovalNo = strApprovalNo;
	}

	public String[] getStrInsertHiddenValue() {
		return strInsertHiddenValue;
	}

	public void setStrInsertHiddenValue(String[] strInsertHiddenValue) {
		this.strInsertHiddenValue = strInsertHiddenValue;
	}

	public String getStrItemCatgNo() {
		return strItemCatgNo;
	}

	public void setStrItemCatgNo(String strItemCatgNo) {
		this.strItemCatgNo = strItemCatgNo;
	}

	public String getStrApprovalType() {
		return strApprovalType;
	}

	public void setStrApprovalType(String strApprovalType) {
		this.strApprovalType = strApprovalType;
	}

	public String[] getStrPrimaryKey() {
		return strPrimaryKey;
	}

	public void setStrPrimaryKey(String[] strPrimaryKey) {
		this.strPrimaryKey = strPrimaryKey;
	}

	public String[] getStrItemRemarks() {
		return strItemRemarks;
	}

	public void setStrItemRemarks(String[] strItemRemarks) {
		this.strItemRemarks = strItemRemarks;
	}

	public String getStrUserId() {
		return strUserId;
	}

	public void setStrUserId(String strUserId) {
		this.strUserId = strUserId;
	}

	public String getStrUserLevel() {
		return strUserLevel;
	}

	public void setStrUserLevel(String strUserLevel) {
		this.strUserLevel = strUserLevel;
	}

	public String getStrLevelType() {
		return strLevelType;
	}

	public void setStrLevelType(String strLevelType) {
		this.strLevelType = strLevelType;
	}

	public String getStrIpAddr() {
		return strIpAddr;
	}

	public void setStrIpAddr(String strIpAddr) {
		this.strIpAddr = strIpAddr;
	}

	public String getStrToStoreId() {
		return strToStoreId;
	}

	public void setStrToStoreId(String strToStoreId) {
		this.strToStoreId = strToStoreId;
	}

	public String getStrApprovalFlag() {
		return strApprovalFlag;
	}

	public void setStrApprovalFlag(String strApprovalFlag) {
		this.strApprovalFlag = strApprovalFlag;
	}
	
	

}