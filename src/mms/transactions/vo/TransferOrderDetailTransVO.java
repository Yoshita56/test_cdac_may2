/**********************************************************
 Project:	   DWH_PHD_OPEN	
 File:         TransferApprovalTransVO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * The Class TransferApprovalTransVO.
 */
public class TransferOrderDetailTransVO {

	/** The str msg string. */
	private String strMsgString = "";

	/** The str msg type. */
	private String strMsgType = "";

	/** The str hospital code. */
	private String strHospitalCode = "";

	/** The str seat id. */
	private String strSeatId = "";

	/** The str request no. */
	private String strRequestNo = "0";

	/** The str store id. */
	private String strStoreId = "0";

	/** The str item brand id. */
	private String strItemBrandId = "0";

	/** The str remarks. */
	private String strRemarks = "";

	/** The ws dwh list. */
	private WebRowSet wsDwhList = null;

	/** The ws demand request details. */
	private WebRowSet wsDemandRequestDetails = null;

	/** The ws transfering details. */
	private WebRowSet wsTransferingDetails = null;

	/** The str order no. */
	private String strOrderNo = "";

	/** The str order date. */
	private String strOrderDate = "";

	/** The str order qty. */
	private String strOrderQty = "";

	/** The str demand no. */
	private String strDemandNo = "";

	/** The str demand date. */
	private String strDemandDate = "";

	/** The str demanding ddw. */
	private String strDemandingDDW = "";

	/** The str demanding ddw id. */
	private String strDemandingDDWId = "";

	/** The str drug name. */
	private String strDrugName = "";

	/** The str trans store id. */
	private String strTransStoreId = "";

	/** The str trans request no. */
	private String strTransRequestNo = "";

	/** The str demand qty. */
	private String strDemandQty = "";

	/** The str ordered qty. */
	private String strOrderedQty = "";

	/** The str balance qty. */
	private String strBalanceQty = "";

	/** The str balance qty base value. */
	private String strBalanceQtyBaseValue = "";

	/** The str store name. */
	private String strStoreName = "";

	/** The str transfer store ids. */
	private String[] strTransferStoreIds = null;

	/** The str transfer request nos. */
	private String[] strTransferRequestNos = null;

	/** The str transfer order qtys. */
	private String[] strTransferOrderQtys = null;

	/** The str transfering dtls. */
	private String[] strTransferingDtls = null;

	/** The str tmp store id. */
	private String strTmpStoreId = "";

	/** The str request no. */
	private String strDemandSlNo = "";

	/** The str request no. */
	private String strRequestSlNo = "";

	/** The str transfer request serial no ids. */
	private String[] strTransferReqSlNo = null;

	/** The str order sl no. */
	private String strOrderSlNo = "";

	/** The str primary key. */
	private String[] strPrimaryKey = null;

	/** The str primary key. */
	private String[] strPrimaryKey1 = null;

	/** The ws transfering details. */
	private WebRowSet wsOrderDetails = null;

	private WebRowSet wbsStoreDetails = null;

	private String strRequestingStoreId;

	private String strTransferingStoreId;

	private String strGroupId="0";

	private String strGroupNameCombo;

	private String strSubGroupId="0";

	private String strSubGroupCombo;

	private String strItemCategoryNo;

	private String strItemNameCombo;

	private String strItemId;

	private WebRowSet strBatchDtlWs;

	
	private String[] strHiddenValue = null;
	private String[] strPKey = null;
	private String strReqStatus;
	private String strReqDate;
	
	
	
	public String[] getStrPKey() {
		return strPKey;
	}

	public void setStrPKey(String[] strPKey) {
		this.strPKey = strPKey;
	}

	public String getStrReqStatus() {
		return strReqStatus;
	}

	public void setStrReqStatus(String strReqStatus) {
		this.strReqStatus = strReqStatus;
	}

	public String getStrReqDate() {
		return strReqDate;
	}

	public void setStrReqDate(String strReqDate) {
		this.strReqDate = strReqDate;
	}

	public String[] getStrHiddenValue() {
		return strHiddenValue;
	}

	public void setStrHiddenValue(String[] strHiddenValue) {
		this.strHiddenValue = strHiddenValue;
	}

	public String getStrGroupId() {
		return strGroupId;
	}

	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	public String getStrGroupNameCombo() {
		return strGroupNameCombo;
	}

	public void setStrGroupNameCombo(String strGroupNameCombo) {
		this.strGroupNameCombo = strGroupNameCombo;
	}

	public String getStrSubGroupId() {
		return strSubGroupId;
	}

	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}

	public String getStrSubGroupCombo() {
		return strSubGroupCombo;
	}

	public void setStrSubGroupCombo(String strSubGroupCombo) {
		this.strSubGroupCombo = strSubGroupCombo;
	}

	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}

	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}

	public String getStrItemNameCombo() {
		return strItemNameCombo;
	}

	public void setStrItemNameCombo(String strItemNameCombo) {
		this.strItemNameCombo = strItemNameCombo;
	}

	public String getStrItemId() {
		return strItemId;
	}

	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}

	public WebRowSet getStrBatchDtlWs() {
		return strBatchDtlWs;
	}

	public void setStrBatchDtlWs(WebRowSet strBatchDtlWs) {
		this.strBatchDtlWs = strBatchDtlWs;
	}

	public WebRowSet getWbsStoreDetails() {
		return wbsStoreDetails;
	}

	public void setWbsStoreDetails(WebRowSet wbsStoreDetails) {
		this.wbsStoreDetails = wbsStoreDetails;
	}

	public String getStrRequestingStoreId() {
		return strRequestingStoreId;
	}

	public void setStrRequestingStoreId(String strRequestingStoreId) {
		this.strRequestingStoreId = strRequestingStoreId;
	}

	public String getStrTransferingStoreId() {
		return strTransferingStoreId;
	}

	public void setStrTransferingStoreId(String strTransferingStoreId) {
		this.strTransferingStoreId = strTransferingStoreId;
	}

	/**
	 * Gets the str tmp store id.
	 * 
	 * @return the str tmp store id
	 */
	public String getStrTmpStoreId() {
		return strTmpStoreId;
	}

	/**
	 * Sets the str tmp store id.
	 * 
	 * @param strTmpStoreId
	 *            the new str tmp store id
	 */
	public void setStrTmpStoreId(String strTmpStoreId) {
		this.strTmpStoreId = strTmpStoreId;
	}

	/**
	 * Gets the str transfering dtls.
	 * 
	 * @return the str transfering dtls
	 */
	public String[] getStrTransferingDtls() {
		return strTransferingDtls;
	}

	/**
	 * Sets the str transfering dtls.
	 * 
	 * @param strTransferingDtls
	 *            the new str transfering dtls
	 */
	public void setStrTransferingDtls(String[] strTransferingDtls) {
		this.strTransferingDtls = strTransferingDtls;
	}

	/**
	 * Gets the str demand qty.
	 * 
	 * @return the str demand qty
	 */
	public String getStrDemandQty() {
		return strDemandQty;
	}

	/**
	 * Sets the str demand qty.
	 * 
	 * @param strDemandQty
	 *            the new str demand qty
	 */
	public void setStrDemandQty(String strDemandQty) {
		this.strDemandQty = strDemandQty;
	}

	/**
	 * Gets the str ordered qty.
	 * 
	 * @return the str ordered qty
	 */
	public String getStrOrderedQty() {
		return strOrderedQty;
	}

	/**
	 * Sets the str ordered qty.
	 * 
	 * @param strOrderedQty
	 *            the new str ordered qty
	 */
	public void setStrOrderedQty(String strOrderedQty) {
		this.strOrderedQty = strOrderedQty;
	}

	/**
	 * Gets the str balance qty.
	 * 
	 * @return the str balance qty
	 */
	public String getStrBalanceQty() {
		return strBalanceQty;
	}

	/**
	 * Sets the str balance qty.
	 * 
	 * @param strBalanceQty
	 *            the new str balance qty
	 */
	public void setStrBalanceQty(String strBalanceQty) {
		this.strBalanceQty = strBalanceQty;
	}

	/**
	 * Gets the str balance qty base value.
	 * 
	 * @return the str balance qty base value
	 */
	public String getStrBalanceQtyBaseValue() {
		return strBalanceQtyBaseValue;
	}

	/**
	 * Sets the str balance qty base value.
	 * 
	 * @param strBalanceQtyBaseValue
	 *            the new str balance qty base value
	 */
	public void setStrBalanceQtyBaseValue(String strBalanceQtyBaseValue) {
		this.strBalanceQtyBaseValue = strBalanceQtyBaseValue;
	}

	/**
	 * Gets the str transfer store ids.
	 * 
	 * @return the str transfer store ids
	 */
	public String[] getStrTransferStoreIds() {
		return strTransferStoreIds;
	}

	/**
	 * Sets the str transfer store ids.
	 * 
	 * @param strTransferStoreIds
	 *            the new str transfer store ids
	 */
	public void setStrTransferStoreIds(String[] strTransferStoreIds) {
		this.strTransferStoreIds = strTransferStoreIds;
	}

	/**
	 * Gets the str transfer request nos.
	 * 
	 * @return the str transfer request nos
	 */
	public String[] getStrTransferRequestNos() {
		return strTransferRequestNos;
	}

	/**
	 * Sets the str transfer request nos.
	 * 
	 * @param strTransferRequestNos
	 *            the new str transfer request nos
	 */
	public void setStrTransferRequestNos(String[] strTransferRequestNos) {
		this.strTransferRequestNos = strTransferRequestNos;
	}

	/**
	 * Gets the str transfer order qtys.
	 * 
	 * @return the str transfer order qtys
	 */
	public String[] getStrTransferOrderQtys() {
		return strTransferOrderQtys;
	}

	/**
	 * Sets the str transfer order qtys.
	 * 
	 * @param strTransferOrderQtys
	 *            the new str transfer order qtys
	 */
	public void setStrTransferOrderQtys(String[] strTransferOrderQtys) {
		this.strTransferOrderQtys = strTransferOrderQtys;
	}

	/**
	 * Gets the str order no.
	 * 
	 * @return the str order no
	 */
	public String getStrOrderNo() {
		return strOrderNo;
	}

	/**
	 * Sets the str order no.
	 * 
	 * @param strOrderNo
	 *            the new str order no
	 */
	public void setStrOrderNo(String strOrderNo) {
		this.strOrderNo = strOrderNo;
	}

	/**
	 * Gets the str order date.
	 * 
	 * @return the str order date
	 */
	public String getStrOrderDate() {
		return strOrderDate;
	}

	/**
	 * Sets the str order date.
	 * 
	 * @param strOrderDate
	 *            the new str order date
	 */
	public void setStrOrderDate(String strOrderDate) {
		this.strOrderDate = strOrderDate;
	}

	/**
	 * Gets the str order qty.
	 * 
	 * @return the str order qty
	 */
	public String getStrOrderQty() {
		return strOrderQty;
	}

	/**
	 * Sets the str order qty.
	 * 
	 * @param strOrderQty
	 *            the new str order qty
	 */
	public void setStrOrderQty(String strOrderQty) {
		this.strOrderQty = strOrderQty;
	}

	/**
	 * Gets the str demand no.
	 * 
	 * @return the str demand no
	 */
	public String getStrDemandNo() {
		return strDemandNo;
	}

	/**
	 * Sets the str demand no.
	 * 
	 * @param strDemandNo
	 *            the new str demand no
	 */
	public void setStrDemandNo(String strDemandNo) {
		this.strDemandNo = strDemandNo;
	}

	/**
	 * Gets the str demand date.
	 * 
	 * @return the str demand date
	 */
	public String getStrDemandDate() {
		return strDemandDate;
	}

	/**
	 * Sets the str demand date.
	 * 
	 * @param strDemandDate
	 *            the new str demand date
	 */
	public void setStrDemandDate(String strDemandDate) {
		this.strDemandDate = strDemandDate;
	}

	/**
	 * Gets the str demanding ddw.
	 * 
	 * @return the str demanding ddw
	 */
	public String getStrDemandingDDW() {
		return strDemandingDDW;
	}

	/**
	 * Sets the str demanding ddw.
	 * 
	 * @param strDemandingDDW
	 *            the new str demanding ddw
	 */
	public void setStrDemandingDDW(String strDemandingDDW) {
		this.strDemandingDDW = strDemandingDDW;
	}

	/**
	 * Gets the str demanding ddw id.
	 * 
	 * @return the str demanding ddw id
	 */
	public String getStrDemandingDDWId() {
		return strDemandingDDWId;
	}

	/**
	 * Sets the str demanding ddw id.
	 * 
	 * @param strDemandingDDWId
	 *            the new str demanding ddw id
	 */
	public void setStrDemandingDDWId(String strDemandingDDWId) {
		this.strDemandingDDWId = strDemandingDDWId;
	}

	/**
	 * Gets the str drug name.
	 * 
	 * @return the str drug name
	 */
	public String getStrDrugName() {
		return strDrugName;
	}

	/**
	 * Sets the str drug name.
	 * 
	 * @param strDrugName
	 *            the new str drug name
	 */
	public void setStrDrugName(String strDrugName) {
		this.strDrugName = strDrugName;
	}

	/**
	 * Gets the str trans store id.
	 * 
	 * @return the str trans store id
	 */
	public String getStrTransStoreId() {
		return strTransStoreId;
	}

	/**
	 * Sets the str trans store id.
	 * 
	 * @param strTransStoreId
	 *            the new str trans store id
	 */
	public void setStrTransStoreId(String strTransStoreId) {
		this.strTransStoreId = strTransStoreId;
	}

	/**
	 * Gets the str trans request no.
	 * 
	 * @return the str trans request no
	 */
	public String getStrTransRequestNo() {
		return strTransRequestNo;
	}

	/**
	 * Sets the str trans request no.
	 * 
	 * @param strTransRequestNo
	 *            the new str trans request no
	 */
	public void setStrTransRequestNo(String strTransRequestNo) {
		this.strTransRequestNo = strTransRequestNo;
	}

	/**
	 * Gets the str item brand id.
	 * 
	 * @return the str item brand id
	 */
	public String getStrItemBrandId() {
		return strItemBrandId;
	}

	/**
	 * Sets the str item brand id.
	 * 
	 * @param strItemBrandId
	 *            the new str item brand id
	 */
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}

	/**
	 * Gets the ws demand request details.
	 * 
	 * @return the ws demand request details
	 */
	public WebRowSet getWsDemandRequestDetails() {
		return wsDemandRequestDetails;
	}

	/**
	 * Sets the ws demand request details.
	 * 
	 * @param wsDemandRequestDetails
	 *            the new ws demand request details
	 */
	public void setWsDemandRequestDetails(WebRowSet wsDemandRequestDetails) {
		this.wsDemandRequestDetails = wsDemandRequestDetails;
	}

	/**
	 * Gets the ws transfering details.
	 * 
	 * @return the ws transfering details
	 */
	public WebRowSet getWsTransferingDetails() {
		return wsTransferingDetails;
	}

	/**
	 * Sets the ws transfering details.
	 * 
	 * @param wsTransferingDetails
	 *            the new ws transfering details
	 */
	public void setWsTransferingDetails(WebRowSet wsTransferingDetails) {
		this.wsTransferingDetails = wsTransferingDetails;
	}

	/**
	 * Gets the ws dwh list.
	 * 
	 * @return the ws dwh list
	 */
	public WebRowSet getWsDwhList() {
		return wsDwhList;
	}

	/**
	 * Sets the ws dwh list.
	 * 
	 * @param wsDwhList
	 *            the new ws dwh list
	 */
	public void setWsDwhList(WebRowSet wsDwhList) {
		this.wsDwhList = wsDwhList;
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
	 * @param strHospitalCode
	 *            the new str hospital code
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Gets the str seat id.
	 * 
	 * @return the str seat id
	 */
	public String getStrSeatId() {
		return strSeatId;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param strSeatId
	 *            the new str seat id
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * Gets the str request no.
	 * 
	 * @return the str request no
	 */
	public String getStrRequestNo() {
		return strRequestNo;
	}

	/**
	 * Sets the str request no.
	 * 
	 * @param strRequestNo
	 *            the new str request no
	 */
	public void setStrRequestNo(String strRequestNo) {
		this.strRequestNo = strRequestNo;
	}

	/**
	 * Gets the str store id.
	 * 
	 * @return the str store id
	 */
	public String getStrStoreId() {
		return strStoreId;
	}

	/**
	 * Sets the str store id.
	 * 
	 * @param strStoreId
	 *            the new str store id
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	/**
	 * Gets the str remarks.
	 * 
	 * @return the str remarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks
	 *            the new str remarks
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
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
	 * @param strMsgString
	 *            the new str msg string
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
	 * @param strMsgType
	 *            the new str msg type
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	/**
	 * Gets the str store name.
	 * 
	 * @return the str store name
	 */
	public String getStrStoreName() {
		return strStoreName;
	}

	/**
	 * Sets the str store name.
	 * 
	 * @param strStoreName
	 *            the new str store name
	 */
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}

	public String getStrDemandSlNo() {
		return strDemandSlNo;
	}

	public void setStrDemandSlNo(String strDemandSlNo) {
		this.strDemandSlNo = strDemandSlNo;
	}

	public String getStrRequestSlNo() {
		return strRequestSlNo;
	}

	public void setStrRequestSlNo(String strRequestSlNo) {
		this.strRequestSlNo = strRequestSlNo;
	}

	public String[] getStrTransferReqSlNo() {
		return strTransferReqSlNo;
	}

	public void setStrTransferReqSlNo(String[] strTransferReqSlNo) {
		this.strTransferReqSlNo = strTransferReqSlNo;
	}

	public String getStrOrderSlNo() {
		return strOrderSlNo;
	}

	public void setStrOrderSlNo(String strOrderSlNo) {
		this.strOrderSlNo = strOrderSlNo;
	}

	public String[] getStrPrimaryKey() {
		return strPrimaryKey;
	}

	public void setStrPrimaryKey(String[] strPrimaryKey) {
		this.strPrimaryKey = strPrimaryKey;
	}

	public WebRowSet getWsOrderDetails() {
		return wsOrderDetails;
	}

	public void setWsOrderDetails(WebRowSet wsOrderDetails) {
		this.wsOrderDetails = wsOrderDetails;
	}

	/**
	 * @return the strPrimaryKey1
	 */
	public String[] getStrPrimaryKey1() {
		return strPrimaryKey1;
	}

	/**
	 * @param strPrimaryKey1
	 *            the strPrimaryKey1 to set
	 */
	public void setStrPrimaryKey1(String[] strPrimaryKey1) {
		this.strPrimaryKey1 = strPrimaryKey1;
	}

}
