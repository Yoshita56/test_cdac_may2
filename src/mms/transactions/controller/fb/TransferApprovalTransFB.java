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

// TODO: Auto-generated Javadoc
/**
 * The Class TransferApprovalTransFB.
 */
public class TransferApprovalTransFB extends GenericFormBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The str err. */
	private String strErr = "";

	/** The str warning. */
	private String strWarning = "";

	/** The str msg. */
	private String strMsg = "";

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	private String strChk = "";

	/** The str seat id. */
	private String strSeatId = "";

	/** The str ct date. */
	private String strCtDate = "";

	/** The str request no. */
	private String strRequestNo = "";

	/** The str store id. */
	private String strStoreId = "";

	/** The str item brand id. */
	private String strItemBrandId = "";

	/** The str remarks. */
	private String strRemarks = "";

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

	/** The str dwh names. */
	private String strDwhNames = "";

	/** The str demand request details. */
	private String strDemandRequestDetails = "";

	/** The str transfering details. */
	private String strTransferingDetails = "";

	/** The str demand request. */
	private String strDemandRequest = "";

	/** The str transfering dtls. */
	private String[] strTransferingDtls = null;

	/** The str transfer order qty. */
	private String[] strTransferOrderQty = null;

	/** The str store name. */
	private String strStoreName = "";

	/** The str tmp store id. */
	private String strTmpStoreId = "";

	private String strOrderSlNo = "";

	/** The str primary key. */
	private String[] strPrimaryKey = null;

	/** The str primary key. */
	private String[] strPrimaryKey1 = null;

	private String StrTransferingOrderDetails = "";

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
	 * @param strStoreName the new str store name
	 */
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
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
	 * @param strDemandQty the new str demand qty
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
	 * @param strOrderedQty the new str ordered qty
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
	 * @param strBalanceQty the new str balance qty
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
	 * @param strBalanceQtyBaseValue the new str balance qty base value
	 */
	public void setStrBalanceQtyBaseValue(String strBalanceQtyBaseValue) {
		this.strBalanceQtyBaseValue = strBalanceQtyBaseValue;
	}

	/**
	 * Gets the str demand request.
	 * 
	 * @return the str demand request
	 */
	public String getStrDemandRequest() {
		return strDemandRequest;
	}

	/**
	 * Sets the str demand request.
	 * 
	 * @param strDemandRequest the new str demand request
	 */
	public void setStrDemandRequest(String strDemandRequest) {
		this.strDemandRequest = strDemandRequest;
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
	 * @param strTransferingDtls the new str transfering dtls
	 */
	public void setStrTransferingDtls(String[] strTransferingDtls) {
		this.strTransferingDtls = strTransferingDtls;
	}

	/**
	 * Gets the str transfer order qty.
	 * 
	 * @return the str transfer order qty
	 */
	public String[] getStrTransferOrderQty() {
		return strTransferOrderQty;
	}

	/**
	 * Sets the str transfer order qty.
	 * 
	 * @param strTransferOrderQty the new str transfer order qty
	 */
	public void setStrTransferOrderQty(String[] strTransferOrderQty) {
		this.strTransferOrderQty = strTransferOrderQty;
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
	 * @param strOrderNo the new str order no
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
	 * @param strOrderDate the new str order date
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
	 * @param strOrderQty the new str order qty
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
	 * @param strDemandNo the new str demand no
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
	 * @param strDemandDate the new str demand date
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
	 * @param strDemandingDDW the new str demanding ddw
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
	 * @param strDemandingDDWId the new str demanding ddw id
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
	 * @param strDrugName the new str drug name
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
	 * @param strTransStoreId the new str trans store id
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
	 * @param strTransRequestNo the new str trans request no
	 */
	public void setStrTransRequestNo(String strTransRequestNo) {
		this.strTransRequestNo = strTransRequestNo;
	}

	/**
	 * Gets the str transfering details.
	 * 
	 * @return the str transfering details
	 */
	public String getStrTransferingDetails() {
		return strTransferingDetails;
	}

	/**
	 * Sets the str transfering details.
	 * 
	 * @param strTransferingDetails the new str transfering details
	 */
	public void setStrTransferingDetails(String strTransferingDetails) {
		this.strTransferingDetails = strTransferingDetails;
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
	 * @param strItemBrandId the new str item brand id
	 */
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}

	/**
	 * Gets the str dwh names.
	 * 
	 * @return the str dwh names
	 */
	public String getStrDwhNames() {
		return strDwhNames;
	}

	/**
	 * Sets the str dwh names.
	 * 
	 * @param strDwhNames the new str dwh names
	 */
	public void setStrDwhNames(String strDwhNames) {
		this.strDwhNames = strDwhNames;
	}

	/**
	 * Gets the str ct date.
	 * 
	 * @return the str ct date
	 */
	public String getStrCtDate() {
		return strCtDate;
	}

	/**
	 * Sets the str ct date.
	 * 
	 * @param strCtDate the new str ct date
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}

	/**
	 * Gets the str demand request details.
	 * 
	 * @return the str demand request details
	 */
	public String getStrDemandRequestDetails() {
		return strDemandRequestDetails;
	}

	/**
	 * Sets the str demand request details.
	 * 
	 * @param strDemandRequestDetails the new str demand request details
	 */
	public void setStrDemandRequestDetails(String strDemandRequestDetails) {
		this.strDemandRequestDetails = strDemandRequestDetails;
	}

	/**
	 * Gets the str err.
	 * 
	 * @return the str err
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * Sets the str err.
	 * 
	 * @param strErr the new str err
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

	/**
	 * Gets the str warning.
	 * 
	 * @return the str warning
	 */
	public String getStrWarning() {
		return strWarning;
	}

	/**
	 * Sets the str warning.
	 * 
	 * @param strWarning the new str warning
	 */
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}

	/**
	 * Gets the str msg.
	 * 
	 * @return the str msg
	 */
	public String getStrMsg() {
		return strMsg;
	}

	/**
	 * Sets the str msg.
	 * 
	 * @param strMsg the new str msg
	 */
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
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
	 * @param strHospitalCode the new str hospital code
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
	 * @param strSeatId the new str seat id
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
	 * @param strRequestNo the new str request no
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
	 * @param strStoreId the new str store id
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
	 * @param strRemarks the new str remarks
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
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
	 * @param strTmpStoreId the new str tmp store id
	 */
	public void setStrTmpStoreId(String strTmpStoreId) {
		this.strTmpStoreId = strTmpStoreId;
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

	public String getStrTransferingOrderDetails() {
		return StrTransferingOrderDetails;
	}

	public void setStrTransferingOrderDetails(String strTransferingOrderDetails) {
		StrTransferingOrderDetails = strTransferingOrderDetails;
	}

	/**
	 * @return the strPrimaryKey1
	 */
	public String[] getStrPrimaryKey1() {
		return strPrimaryKey1;
	}

	/**
	 * @param strPrimaryKey1 the strPrimaryKey1 to set
	 */
	public void setStrPrimaryKey1(String[] strPrimaryKey1) {
		this.strPrimaryKey1 = strPrimaryKey1;
	}

	public String getStrChk() {
		return strChk;
	}

	public void setStrChk(String strChk) {
		this.strChk = strChk;
	}

}
