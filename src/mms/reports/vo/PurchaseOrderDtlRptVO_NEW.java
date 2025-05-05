/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         PurchaseOrderDtlRptVO.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * The Class PurchaseOrderDtlRptVO.
 */
public class PurchaseOrderDtlRptVO_NEW {

	/** The str mode. */
	private String strMode;

	/** The str hospital code. */
	private String strHospitalCode = "";

	/** The str seat id. */
	private String strSeatId = "";

	/** The str store id. */
	private String strStoreId = "";

	/** The str item cat no. */
	private String strItemCatNo = "";

	/** The str req for. */
	private String strReqFor = "";

	/** The str msg type. */
	private String strMsgType = "";

	/** The str msg string. */
	private String strMsgString = "";

	/** The str store ws. */
	private WebRowSet strStoreWs = null;

	/** The str item cat ws. */
	private WebRowSet strItemCatWs = null;

	/** The str po type ws. */
	private WebRowSet strPOTypeWs = null;

	/** The str supplier ws. */
	private WebRowSet strSupplierWs = null;

	/** The str user level. */
	private String strUserLevel = "";

	/** The str circle id. */
	private String strCircleId = "";

	/** The str district id. */
	private String strDistrictId = "";

	/** The str circle ws. */
	private WebRowSet strCircleWS = null;

	/** The str district ws. */
	private WebRowSet strDistrictWS = null;

	/** The str district store ws. */
	private WebRowSet strDistrictStoreWs = null;

	/** The str store type id. */
	private String strStoreTypeId = "";

	/** The str store type ws. */
	private WebRowSet strStoreTypeWS = null;
	
	private WebRowSet financialYearWs = null;
	
	private WebRowSet strProgNameComboWS = null;

	/** The str district store id. */
	private String strDistrictStoreId;
	
	private String strSuppPOStatusName="";
	
	private String strSuppPOStatus="";

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
	 * Gets the str store ws.
	 * 
	 * @return the str store ws
	 */
	public WebRowSet getStrStoreWs() {
		return strStoreWs;
	}

	/**
	 * Sets the str store ws.
	 * 
	 * @param strStoreWs
	 *            the new str store ws
	 */
	public void setStrStoreWs(WebRowSet strStoreWs) {
		this.strStoreWs = strStoreWs;
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
	 * Gets the str item cat ws.
	 * 
	 * @return the str item cat ws
	 */
	public WebRowSet getStrItemCatWs() {
		return strItemCatWs;
	}

	/**
	 * Sets the str item cat ws.
	 * 
	 * @param strItemCatWs
	 *            the new str item cat ws
	 */
	public void setStrItemCatWs(WebRowSet strItemCatWs) {
		this.strItemCatWs = strItemCatWs;
	}

	/**
	 * Gets the str item cat no.
	 * 
	 * @return the str item cat no
	 */
	public String getStrItemCatNo() {
		return strItemCatNo;
	}

	/**
	 * Sets the str item cat no.
	 * 
	 * @param strItemCatNo
	 *            the new str item cat no
	 */
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}

	/**
	 * Gets the str po type ws.
	 * 
	 * @return the str po type ws
	 */
	public WebRowSet getStrPOTypeWs() {
		return strPOTypeWs;
	}

	/**
	 * Sets the str po type ws.
	 * 
	 * @param strPOTypeWs
	 *            the new str po type ws
	 */
	public void setStrPOTypeWs(WebRowSet strPOTypeWs) {
		this.strPOTypeWs = strPOTypeWs;
	}

	/**
	 * Gets the str supplier ws.
	 * 
	 * @return the str supplier ws
	 */
	public WebRowSet getStrSupplierWs() {
		return strSupplierWs;
	}

	/**
	 * Sets the str supplier ws.
	 * 
	 * @param strSupplierWs
	 *            the new str supplier ws
	 */
	public void setStrSupplierWs(WebRowSet strSupplierWs) {
		this.strSupplierWs = strSupplierWs;
	}

	/**
	 * Gets the str req for.
	 * 
	 * @return the str req for
	 */
	public String getStrReqFor() {
		return strReqFor;
	}

	/**
	 * Sets the str req for.
	 * 
	 * @param strReqFor
	 *            the new str req for
	 */
	public void setStrReqFor(String strReqFor) {
		this.strReqFor = strReqFor;
	}

	/**
	 * Gets the str mode.
	 * 
	 * @return the str mode
	 */
	public String getStrMode() {
		return strMode;
	}

	/**
	 * Sets the str mode.
	 * 
	 * @param strMode
	 *            the new str mode
	 */
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}

	/**
	 * Gets the str circle id.
	 * 
	 * @return the str circle id
	 */
	public String getStrCircleId() {
		return strCircleId;
	}

	/**
	 * Sets the str circle id.
	 * 
	 * @param strCircleId
	 *            the new str circle id
	 */
	public void setStrCircleId(String strCircleId) {
		this.strCircleId = strCircleId;
	}

	/**
	 * Gets the str district id.
	 * 
	 * @return the str district id
	 */
	public String getStrDistrictId() {
		return strDistrictId;
	}

	/**
	 * Sets the str district id.
	 * 
	 * @param strDistrictId
	 *            the new str district id
	 */
	public void setStrDistrictId(String strDistrictId) {
		this.strDistrictId = strDistrictId;
	}

	/**
	 * Gets the str circle ws.
	 * 
	 * @return the str circle ws
	 */
	public WebRowSet getStrCircleWS() {
		return strCircleWS;
	}

	/**
	 * Sets the str circle ws.
	 * 
	 * @param strCircleWS
	 *            the new str circle ws
	 */
	public void setStrCircleWS(WebRowSet strCircleWS) {
		this.strCircleWS = strCircleWS;
	}

	/**
	 * Gets the str district ws.
	 * 
	 * @return the str district ws
	 */
	public WebRowSet getStrDistrictWS() {
		return strDistrictWS;
	}

	/**
	 * Sets the str district ws.
	 * 
	 * @param strDistrictWS
	 *            the new str district ws
	 */
	public void setStrDistrictWS(WebRowSet strDistrictWS) {
		this.strDistrictWS = strDistrictWS;
	}

	/**
	 * Gets the str user level.
	 * 
	 * @return the str user level
	 */
	public String getStrUserLevel() {
		return strUserLevel;
	}

	/**
	 * Sets the str user level.
	 * 
	 * @param strUserLevel
	 *            the new str user level
	 */
	public void setStrUserLevel(String strUserLevel) {
		this.strUserLevel = strUserLevel;
	}

	/**
	 * Gets the str district store ws.
	 * 
	 * @return the str district store ws
	 */
	public WebRowSet getStrDistrictStoreWs() {
		return strDistrictStoreWs;
	}

	/**
	 * Sets the str district store ws.
	 * 
	 * @param strDistrictStoreWs
	 *            the new str district store ws
	 */
	public void setStrDistrictStoreWs(WebRowSet strDistrictStoreWs) {
		this.strDistrictStoreWs = strDistrictStoreWs;
	}

	/**
	 * Gets the str store type id.
	 * 
	 * @return the str store type id
	 */
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}

	/**
	 * Sets the str store type id.
	 * 
	 * @param strStoreTypeId
	 *            the new str store type id
	 */
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}

	/**
	 * Gets the str store type ws.
	 * 
	 * @return the str store type ws
	 */
	public WebRowSet getStrStoreTypeWS() {
		return strStoreTypeWS;
	}

	/**
	 * Sets the str store type ws.
	 * 
	 * @param strStoreTypeWS
	 *            the new str store type ws
	 */
	public void setStrStoreTypeWS(WebRowSet strStoreTypeWS) {
		this.strStoreTypeWS = strStoreTypeWS;
	}

	/**
	 * Gets the str district store id.
	 * 
	 * @return the str district store id
	 */
	public String getStrDistrictStoreId() {
		return strDistrictStoreId;
	}

	/**
	 * Sets the str district store id.
	 * 
	 * @param strDistrictStoreId
	 *            the new str district store id
	 */
	public void setStrDistrictStoreId(String strDistrictStoreId) {
		this.strDistrictStoreId = strDistrictStoreId;
	}

	public WebRowSet getFinancialYearWs() {
		return financialYearWs;
	}

	public void setFinancialYearWs(WebRowSet financialYearWs) {
		this.financialYearWs = financialYearWs;
	}

	public WebRowSet getStrProgNameComboWS() {
		return strProgNameComboWS;
	}

	public void setStrProgNameComboWS(WebRowSet strProgNameComboWS) {
		this.strProgNameComboWS = strProgNameComboWS;
	}

	public String getStrSuppPOStatusName() {
		return strSuppPOStatusName;
	}

	public void setStrSuppPOStatusName(String strSuppPOStatusName) {
		this.strSuppPOStatusName = strSuppPOStatusName;
	}

	public String getStrSuppPOStatus() {
		return strSuppPOStatus;
	}

	public void setStrSuppPOStatus(String strSuppPOStatus) {
		this.strSuppPOStatus = strSuppPOStatus;
	}

	
	
}
