package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

/**
 * Developer : Pramod Kumar Mehta 
 * Version : 1.0 
 * Date : 09/April/2009
 *  Module:MMS
 * Process: Dispatch Details
 *
 */
/**
 * Developer : Baisakhi Roy
 * Version : 1.1
 * Start Date : 08/May/2009
 * End Date : 12/May/2009
 *  Module:MMS
 * Process: Dispatch Details
 *(All Changes after table Creation)
 */
public class DispatchDetailsTransVO
{
private static final long serialVersionUID = 02L;

	
	private String strMsgType="";
	private String strMsgString="";
	
	private String strCtDate = "";
	private String strHospitalCode = "";
	private String strIsValid = "";

	private String strSeatId = "";
	private String strStrId = "";
	private String strAdvanceBillRadio="1";
	private String strPONO="";
	private WebRowSet strPONODetailsWS=null;
	private String strPONONameValues="";
	private WebRowSet strPONONameValuesWS=null;
	private String strPODate="";
	private String strSupplierName="";
	private String strSupplierId="";
	private String strAdvanceReqNo="";
	private String strReqTypeId = "";
	private String strPOStoreId = "";

	private String strDefCurrId = "";
	private String strCurrValue = "";
	private String strCurrValuePo = "";
	private String strFinStartDate = "";
	private String strFinEndDate = "";
	private WebRowSet strBillNoValuesWS=null;
	private String strInstrReceivedDate="";
	private String strInstrNo="";
	private String strInstrDate="";
	private String strDraweeBank="";
	private String strInstrValidity="";
	private String strInstrValidityNameValues="";
	private WebRowSet strInstrValidityNameValuesWS=null;
	private String strInstrAmt="";
	private String strInstrType="";
	private String strInstrTypeNameValues="";
	private WebRowSet strInstrTypeNameValuesWS=null;
	private String strDispatchMode="";
	private String strDispatchModeNameValues="";
	private WebRowSet strDispatchModeNameValuesWS=null;
	private String strRemarks="";
	private String strItemCatId="";
	private String strStoreId="";
	private String strPOType="";
	private String strCurrencyCode="";
	private String strCurrencyId="";
	private WebRowSet strStoreNameValuesWS=null;
	private WebRowSet strItemCategoryValuesWS=null;
	private String modeValue="";
	private String[] strReqNo=null;
	private String[] strBillNo=null;
	
	private WebRowSet strRequestDetailsValuesWS=null;
	private WebRowSet strBillDetilsValuesWS=null;
	private WebRowSet strViewDetailsWS = null;
	/**
	 * @return the strStoreNameValuesWS
	 */
	public WebRowSet getStrStoreNameValuesWS() {
		return strStoreNameValuesWS;
	}
	/**
	 * @param strStoreNameValuesWS the strStoreNameValuesWS to set
	 */
	public void setStrStoreNameValuesWS(WebRowSet strStoreNameValuesWS) {
		this.strStoreNameValuesWS = strStoreNameValuesWS;
	}
	/**
	 * @return the strItemCategoryValuesWS
	 */
	public WebRowSet getStrItemCategoryValuesWS() {
		return strItemCategoryValuesWS;
	}
	/**
	 * @param strItemCategoryValuesWS the strItemCategoryValuesWS to set
	 */
	public void setStrItemCategoryValuesWS(WebRowSet strItemCategoryValuesWS) {
		this.strItemCategoryValuesWS = strItemCategoryValuesWS;
	}
	/**
	 * @return the strItemCatId
	 */
	public String getStrItemCatId() {
		return strItemCatId;
	}
	/**
	 * @param strItemCatId the strItemCatId to set
	 */
	public void setStrItemCatId(String strItemCatId) {
		this.strItemCatId = strItemCatId;
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
	 * @return the strPOType
	 */
	public String getStrPOType() {
		return strPOType;
	}
	/**
	 * @param strPOType the strPOType to set
	 */
	public void setStrPOType(String strPOType) {
		this.strPOType = strPOType;
	}
	/**
	 * @return the strCurrencyCode
	 */
	public String getStrCurrencyCode() {
		return strCurrencyCode;
	}
	/**
	 * @param strCurrencyCode the strCurrencyCode to set
	 */
	public void setStrCurrencyCode(String strCurrencyCode) {
		this.strCurrencyCode = strCurrencyCode;
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
	public String getStrCtDate() {
		return strCtDate;
	}
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
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
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String getStrAdvanceBillRadio() {
		return strAdvanceBillRadio;
	}
	public void setStrAdvanceBillRadio(String strAdvanceBillRadio) {
		this.strAdvanceBillRadio = strAdvanceBillRadio;
	}
	public String getStrPONO() {
		return strPONO;
	}
	public void setStrPONO(String strPONO) {
		this.strPONO = strPONO;
	}
	public String getStrPONONameValues() {
		return strPONONameValues;
	}
	public void setStrPONONameValues(String strPONONameValues) {
		this.strPONONameValues = strPONONameValues;
	}
	public String getStrPODate() {
		return strPODate;
	}
	public void setStrPODate(String strPODate) {
		this.strPODate = strPODate;
	}
	public String getStrSupplierName() {
		return strSupplierName;
	}
	public void setStrSupplierName(String strSupplierName) {
		this.strSupplierName = strSupplierName;
	}
	public String getStrAdvanceReqNo() {
		return strAdvanceReqNo;
	}
	public void setStrAdvanceReqNo(String strAdvanceReqNo) {
		this.strAdvanceReqNo = strAdvanceReqNo;
	}
	
	/**
	 * @return the strReqNo
	 */
	public String[] getStrReqNo() {
		return strReqNo;
	}
	/**
	 * @param strReqNo the strReqNo to set
	 */
	public void setStrReqNo(String[] strReqNo) {
		this.strReqNo = strReqNo;
	}
	/**
	 * @return the strBillNo
	 */
	public String[] getStrBillNo() {
		return strBillNo;
	}
	/**
	 * @param strBillNo the strBillNo to set
	 */
	public void setStrBillNo(String[] strBillNo) {
		this.strBillNo = strBillNo;
	}
	public String getStrInstrReceivedDate() {
		return strInstrReceivedDate;
	}
	public void setStrInstrReceivedDate(String strInstrReceivedDate) {
		this.strInstrReceivedDate = strInstrReceivedDate;
	}
	public String getStrInstrNo() {
		return strInstrNo;
	}
	public void setStrInstrNo(String strInstrNo) {
		this.strInstrNo = strInstrNo;
	}
	public String getStrInstrDate() {
		return strInstrDate;
	}
	public void setStrInstrDate(String strInstrDate) {
		this.strInstrDate = strInstrDate;
	}
	public String getStrDraweeBank() {
		return strDraweeBank;
	}
	public void setStrDraweeBank(String strDraweeBank) {
		this.strDraweeBank = strDraweeBank;
	}
	public String getStrInstrValidity() {
		return strInstrValidity;
	}
	public void setStrInstrValidity(String strInstrValidity) {
		this.strInstrValidity = strInstrValidity;
	}
	public String getStrInstrValidityNameValues() {
		return strInstrValidityNameValues;
	}
	public void setStrInstrValidityNameValues(String strInstrValidityNameValues) {
		this.strInstrValidityNameValues = strInstrValidityNameValues;
	}
	public String getStrInstrAmt() {
		return strInstrAmt;
	}
	public void setStrInstrAmt(String strInstrAmt) {
		this.strInstrAmt = strInstrAmt;
	}
	public String getStrInstrType() {
		return strInstrType;
	}
	public void setStrInstrType(String strInstrType) {
		this.strInstrType = strInstrType;
	}
	public String getStrInstrTypeNameValues() {
		return strInstrTypeNameValues;
	}
	public void setStrInstrTypeNameValues(String strInstrTypeNameValues) {
		this.strInstrTypeNameValues = strInstrTypeNameValues;
	}
	public String getStrDispatchMode() {
		return strDispatchMode;
	}
	public void setStrDispatchMode(String strDispatchMode) {
		this.strDispatchMode = strDispatchMode;
	}
	public String getStrDispatchModeNameValues() {
		return strDispatchModeNameValues;
	}
	public void setStrDispatchModeNameValues(String strDispatchModeNameValues) {
		this.strDispatchModeNameValues = strDispatchModeNameValues;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public WebRowSet getStrPONONameValuesWS() {
		return strPONONameValuesWS;
	}
	public void setStrPONONameValuesWS(WebRowSet strPONONameValuesWS) {
		this.strPONONameValuesWS = strPONONameValuesWS;
	}
	public WebRowSet getStrInstrValidityNameValuesWS() {
		return strInstrValidityNameValuesWS;
	}
	public void setStrInstrValidityNameValuesWS(
			WebRowSet strInstrValidityNameValuesWS) {
		this.strInstrValidityNameValuesWS = strInstrValidityNameValuesWS;
	}
	public WebRowSet getStrInstrTypeNameValuesWS() {
		return strInstrTypeNameValuesWS;
	}
	public void setStrInstrTypeNameValuesWS(WebRowSet strInstrTypeNameValuesWS) {
		this.strInstrTypeNameValuesWS = strInstrTypeNameValuesWS;
	}
	public WebRowSet getStrDispatchModeNameValuesWS() {
		return strDispatchModeNameValuesWS;
	}
	public void setStrDispatchModeNameValuesWS(WebRowSet strDispatchModeNameValuesWS) {
		this.strDispatchModeNameValuesWS = strDispatchModeNameValuesWS;
	}
	public WebRowSet getStrBillNoValuesWS() {
		return strBillNoValuesWS;
	}
	public void setStrBillNoValuesWS(WebRowSet strBillNoValuesWS) {
		this.strBillNoValuesWS = strBillNoValuesWS;
	}
	
	
	public void setStrPONODetailsWS(WebRowSet strPONODetailsWS) {
		this.strPONODetailsWS = strPONODetailsWS;
	}
	public WebRowSet getStrPONODetailsWS() {
		return strPONODetailsWS;
	}
	/**
	 * @return the modeValue
	 */
	public String getModeValue() {
		return modeValue;
	}
	/**
	 * @param modeValue the modeValue to set
	 */
	public void setModeValue(String modeValue) {
		this.modeValue = modeValue;
	}
	/**
	 * @return the strRequestDetailsValuesWS
	 */
	public WebRowSet getStrRequestDetailsValuesWS() {
		return strRequestDetailsValuesWS;
	}
	/**
	 * @param strRequestDetailsValuesWS the strRequestDetailsValuesWS to set
	 */
	public void setStrRequestDetailsValuesWS(WebRowSet strRequestDetailsValuesWS) {
		this.strRequestDetailsValuesWS = strRequestDetailsValuesWS;
	}
	/**
	 * @return the strBillDetilsValuesWS
	 */
	public WebRowSet getStrBillDetilsValuesWS() {
		return strBillDetilsValuesWS;
	}
	/**
	 * @param strBillDetilsValuesWS the strBillDetilsValuesWS to set
	 */
	public void setStrBillDetilsValuesWS(WebRowSet strBillDetilsValuesWS) {
		this.strBillDetilsValuesWS = strBillDetilsValuesWS;
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
	public String getStrReqTypeId() {
		return strReqTypeId;
	}
	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}
	public String getStrCurrencyId() {
		return strCurrencyId;
	}
	public void setStrCurrencyId(String strCurrencyId) {
		this.strCurrencyId = strCurrencyId;
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
	public String getStrCurrValue() {
		return strCurrValue;
	}
	public void setStrCurrValue(String strCurrValue) {
		this.strCurrValue = strCurrValue;
	}
	public String getStrDefCurrId() {
		return strDefCurrId;
	}
	public void setStrDefCurrId(String strDefCurrId) {
		this.strDefCurrId = strDefCurrId;
	}
	public String getStrCurrValuePo() {
		return strCurrValuePo;
	}
	public void setStrCurrValuePo(String strCurrValuePo) {
		this.strCurrValuePo = strCurrValuePo;
	}
	public WebRowSet getStrViewDetailsWS() {
		return strViewDetailsWS;
	}
	public void setStrViewDetailsWS(WebRowSet strViewDetailsWS) {
		this.strViewDetailsWS = strViewDetailsWS;
	}
	public String getStrStrId() {
		return strStrId;
	}
	public void setStrStrId(String strStrId) {
		this.strStrId = strStrId;
	}
	public String getStrPOStoreId() {
		return strPOStoreId;
	}
	public void setStrPOStoreId(String strPOStoreId) {
		this.strPOStoreId = strPOStoreId;
	}
}
