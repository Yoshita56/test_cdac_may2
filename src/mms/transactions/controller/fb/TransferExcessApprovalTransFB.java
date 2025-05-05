/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         TransferApprovalTransFB.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.controller.fb;

import hisglobal.transactionutil.GenericFormBean;

import javax.sql.rowset.WebRowSet;

/**
 * The Class TransferRequestTransFB.
 */
public class TransferExcessApprovalTransFB extends GenericFormBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	// private String chk = "";

	/** The str err msg. */
	private String strErrMsg = "";

	/** The str warning msg. */
	private String strWarningMsg = "";

	/** The str normal msg. */
	private String strNormalMsg = "";

	/** The str combo val. */
	private String strComboVal = "";

	/** The str hospital code. */
	private String strHospitalCode = "";

	/** The str seat id. */
	private String strSeatId = "";

	/** The str req date. */
	private String strReqDate = "";

	/** The str remarks. */
	private String strRemarks = "";

	/** The str path. */
	private String strPath = "";

	/** The str approved by id. */
	private String strApprovedById = "";

	/** The str approved by. */
	private String strApprovedBy = "";

	/** The str req status. */
	private String strReqStatus = "";

	/** The str chk. */
	private String strChk = "";

	/** The str item details. */
	private String strItemDetails = "";

	/** The str trans no. */
	private String strTransNo = "0";

	/** The str store id. */
	private String strStoreId = "";

	/** The str ct date. */
	private String strCtDate = "";

	/** The str request no. */
	private String strRequestNo = "";

	/** The str manufacture id. */
	private String strManufactureId = "";

	/** The str manufacture name. */
	private String strManufactureName = "";

	/** The str manufacture combo. */
	private String strManufactureCombo = "";

	/** The str batch dtl ws. */
	private WebRowSet strBatchDtlWs = null;

	/** The str approved by combo. */
	private String strApprovedByCombo = "";

	/** The str approved date. */
	private String strApprovedDate = "";

	/** The str store name. */
	private String strStoreName = "";

	/** The str item name combo. */
	private String strItemNameCombo = "";

	/** The str item name. */
	private String strItemName = "";

	/** The str item id. */
	private String strItemId = "";

	/** The str batch no. */
	private String strBatchNo;

	/** The str item brand name. */
	private String strItemBrandName = "";

	/** The str item brand id. */
	private String strItemBrandId = "";

	/** The str item category no. */
	private String strItemCategoryNo = "";

	/** The Wb transfer order detail. */
	private WebRowSet wbTransferOrderDetail = null;

	/** The str excess qty. */
	private String[] strSancQty = { "" };

	/** The str batch hidden value. */
	private String[] strBatchHiddenValue = { "" };

	/** The str transfer order details. */
	private String strTransferOrderDetails = "";

	/** The str batch no detail. */
	private String strBatchNoDetail = "";

	/** The str avl qty. */
	private String strAvlQty = "";

	/** The str mfg date. */
	private String strMfgDate = "";

	/** The str exp date. */
	private String strExpDate = "";

	// Hidden Fields

	/** The str hidden value. */
	private String[] strHiddenValue = null;

	/** The str hid val. */
	private String strHidVal = "";
	
	/** The str req type id. */
	private String strReqTypeId = "";
	
	/** The str indent details. */
	private String strIndentDetails = "";
	
	/** The str set approved details. */
	private String strSetApprovedDetails = "";
	
	/** The str approval flaf. */
	private String strApprovalFlag = "";
	
	/** The str reapproval flaf. */
	private String strReApprovalFlag = "";
	
	/** The str approved. */
	private String strApproved = "";
	
	/** The str insert hidden value. */
	private String[] strInsertHiddenValue = null;
	
	/** The str ins sanc qty. */
	private String[] strInsSancQty = null;
	
	/** The str item remarks. */
	private String[] strItemRemarks = null;
	
	/** The str primary key. */
	private String[] strPrimaryKey = null;

	/**
	 * @return the strErrMsg
	 */
	public String getStrErrMsg() {
		return strErrMsg;
	}

	/**
	 * @param strErrMsg the strErrMsg to set
	 */
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}

	/**
	 * @return the strWarningMsg
	 */
	public String getStrWarningMsg() {
		return strWarningMsg;
	}

	/**
	 * @param strWarningMsg the strWarningMsg to set
	 */
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}

	/**
	 * @return the strNormalMsg
	 */
	public String getStrNormalMsg() {
		return strNormalMsg;
	}

	/**
	 * @param strNormalMsg the strNormalMsg to set
	 */
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}

	/**
	 * @return the strComboVal
	 */
	public String getStrComboVal() {
		return strComboVal;
	}

	/**
	 * @param strComboVal the strComboVal to set
	 */
	public void setStrComboVal(String strComboVal) {
		this.strComboVal = strComboVal;
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
	 * @return the strReqDate
	 */
	public String getStrReqDate() {
		return strReqDate;
	}

	/**
	 * @param strReqDate the strReqDate to set
	 */
	public void setStrReqDate(String strReqDate) {
		this.strReqDate = strReqDate;
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
	 * @return the strPath
	 */
	public String getStrPath() {
		return strPath;
	}

	/**
	 * @param strPath the strPath to set
	 */
	public void setStrPath(String strPath) {
		this.strPath = strPath;
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
	 * @return the strTransNo
	 */
	public String getStrTransNo() {
		return strTransNo;
	}

	/**
	 * @param strTransNo the strTransNo to set
	 */
	public void setStrTransNo(String strTransNo) {
		this.strTransNo = strTransNo;
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
	 * @return the strManufactureCombo
	 */
	public String getStrManufactureCombo() {
		return strManufactureCombo;
	}

	/**
	 * @param strManufactureCombo the strManufactureCombo to set
	 */
	public void setStrManufactureCombo(String strManufactureCombo) {
		this.strManufactureCombo = strManufactureCombo;
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
	 * @return the wbTransferOrderDetail
	 */
	public WebRowSet getWbTransferOrderDetail() {
		return wbTransferOrderDetail;
	}

	/**
	 * @param wbTransferOrderDetail the wbTransferOrderDetail to set
	 */
	public void setWbTransferOrderDetail(WebRowSet wbTransferOrderDetail) {
		this.wbTransferOrderDetail = wbTransferOrderDetail;
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
	 * @return the strTransferOrderDetails
	 */
	public String getStrTransferOrderDetails() {
		return strTransferOrderDetails;
	}

	/**
	 * @param strTransferOrderDetails the strTransferOrderDetails to set
	 */
	public void setStrTransferOrderDetails(String strTransferOrderDetails) {
		this.strTransferOrderDetails = strTransferOrderDetails;
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
	 * @return the strHiddenValue
	 */
	public String[] getStrHiddenValue() {
		return strHiddenValue;
	}

	/**
	 * @param strHiddenValue the strHiddenValue to set
	 */
	public void setStrHiddenValue(String[] strHiddenValue) {
		this.strHiddenValue = strHiddenValue;
	}

	/**
	 * @return the strHidVal
	 */
	public String getStrHidVal() {
		return strHidVal;
	}

	/**
	 * @param strHidVal the strHidVal to set
	 */
	public void setStrHidVal(String strHidVal) {
		this.strHidVal = strHidVal;
	}

	public String getStrReqTypeId() {
		return strReqTypeId;
	}

	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}

	public String getStrIndentDetails() {
		return strIndentDetails;
	}

	public void setStrIndentDetails(String strIndentDetails) {
		this.strIndentDetails = strIndentDetails;
	}

	public String getStrSetApprovedDetails() {
		return strSetApprovedDetails;
	}

	public void setStrSetApprovedDetails(String strSetApprovedDetails) {
		this.strSetApprovedDetails = strSetApprovedDetails;
	}

	public String getStrApprovalFlag() {
		return strApprovalFlag;
	}

	public void setStrApprovalFlag(String strApprovalFlag) {
		this.strApprovalFlag = strApprovalFlag;
	}

	public String getStrReApprovalFlag() {
		return strReApprovalFlag;
	}

	public void setStrReApprovalFlag(String strReApprovalFlag) {
		this.strReApprovalFlag = strReApprovalFlag;
	}

	public String getStrApproved() {
		return strApproved;
	}

	public void setStrApproved(String strApproved) {
		this.strApproved = strApproved;
	}

	public String[] getStrInsertHiddenValue() {
		return strInsertHiddenValue;
	}

	public void setStrInsertHiddenValue(String[] strInsertHiddenValue) {
		this.strInsertHiddenValue = strInsertHiddenValue;
	}

	public String[] getStrInsSancQty() {
		return strInsSancQty;
	}

	public void setStrInsSancQty(String[] strInsSancQty) {
		this.strInsSancQty = strInsSancQty;
	}

	public String[] getStrItemRemarks() {
		return strItemRemarks;
	}

	public void setStrItemRemarks(String[] strItemRemarks) {
		this.strItemRemarks = strItemRemarks;
	}

	public String[] getStrPrimaryKey() {
		return strPrimaryKey;
	}

	public void setStrPrimaryKey(String[] strPrimaryKey) {
		this.strPrimaryKey = strPrimaryKey;
	}
	
	

}
