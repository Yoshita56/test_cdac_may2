package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;
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

public class DispatchDetailsTransFB extends ActionForm
{
	private static final long serialVersionUID = 02L;

	private String strErrMsg = "";
	private String strNormalMsg = "";
	private String strWarningMsg = "";
	
	private String poPrefix = "";
	
	private String strCtDate = "";
	private String strHospitalCode = "";
	private String strIsValid = "";
	private String strSeatId = "";
	
	private String strDefCurrId = "";
	private String strCurrValuePO = "";
	private String strCurrValue = "";
	private String strExchangeVar = "";
	private String strCurrencyId = "";
	private String strAdvanceBillRadio="1";
	private String strPONO="";
	private String strPONOCmbValues="";
	private String strPODate="";
	private String strSupplierName="";
	private String strSupplierId="";
	private String strAdvanceReqNo="";
	private String strBillNoValues="";
	private String strReqNoValues="";
	private String strInstrReceivedDate="";
	private String strInstrNo="";
	private String strInstrDate="";
	private String strDraweeBank="";
	private String strInstrValidity="";
	private String strInstrValidityNameValues="";
	private String strInstrAmt="";
	private String strInstrType="0";
	private String strInstrTypeNameValues="";
	private String strDispatchMode="";
	private String strDispatchModeNameValues="";
	private String strRemarks="";
	private String strStoreId="";
	private String strStoreNameCmbValues="";
	private String strItemCatId="";
	private String strItemCategoryCmbValues="";
	private String strPOType="";
	private String strCurrencyCode="";
	private String strStoreName="";
	private String strItemCategory="";
	private String PONOName="";
	private String displayFlag="0";
	private String strRequestDetails="";
	private String strBillDetails="";
	private String[] strCheckBoxValue=null;
	private String[] strReqNo=null;
	private String[] strBillNo=null;
	private String chkSelected="";
	
	private String hideStoreId="";
	private String hideItemCatId="";
	private String hidePONO="";
	
	private String strDispatchNo="";
	private String strDispatchDate="";
	private String strInstFor="";
	private String strPONoView="";
	private String strSuppNameView="";
	private String strInstAmtView="";
	
	private String strDispatchDetails = "";
	private String strDispatchViewRadio  = "";
	
	public String getStrDispatchViewRadio() {
		return strDispatchViewRadio;
	}
	public void setStrDispatchViewRadio(String strDispatchViewRadio) {
		this.strDispatchViewRadio = strDispatchViewRadio;
	}
	/**
	 * @return the strCheckBoxValue
	 */
	public String[] getStrCheckBoxValue() {
		return strCheckBoxValue;
	}
	/**
	 * @param strCheckBoxValue the strCheckBoxValue to set
	 */
	public void setStrCheckBoxValue(String[] strCheckBoxValue) {
		this.strCheckBoxValue = strCheckBoxValue;
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
	public String getStrDispatchMode() {
		return strDispatchMode;
	}
	public void setStrDispatchMode(String strDispatchMode) {
		this.strDispatchMode = strDispatchMode;
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
	
	public String getStrInstrValidityNameValues() {
		return strInstrValidityNameValues;
	}
	public void setStrInstrValidityNameValues(String strInstrValidityNameValues) {
		this.strInstrValidityNameValues = strInstrValidityNameValues;
	}
	public String getStrInstrTypeNameValues() {
		return strInstrTypeNameValues;
	}
	public void setStrInstrTypeNameValues(String strInstrTypeNameValues) {
		this.strInstrTypeNameValues = strInstrTypeNameValues;
	}
	public String getStrDispatchModeNameValues() {
		return strDispatchModeNameValues;
	}
	public void setStrDispatchModeNameValues(String strDispatchModeNameValues) {
		this.strDispatchModeNameValues = strDispatchModeNameValues;
	}
	public String getStrBillNoValues() {
		return strBillNoValues;
	}
	public void setStrBillNoValues(String strBillNoValues) {
		this.strBillNoValues = strBillNoValues;
	}
	public String getStrReqNoValues() {
		return strReqNoValues;
	}
	public void setStrReqNoValues(String strReqNoValues) {
		this.strReqNoValues = strReqNoValues;
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
	 * @return the strStoreNameCmbValues
	 */
	public String getStrStoreNameCmbValues() {
		return strStoreNameCmbValues;
	}
	/**
	 * @param strStoreNameCmbValues the strStoreNameCmbValues to set
	 */
	public void setStrStoreNameCmbValues(String strStoreNameCmbValues) {
		this.strStoreNameCmbValues = strStoreNameCmbValues;
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
	 * @return the strItemCategoryCmbValues
	 */
	public String getStrItemCategoryCmbValues() {
		return strItemCategoryCmbValues;
	}
	/**
	 * @param strItemCategoryCmbValues the strItemCategoryCmbValues to set
	 */
	public void setStrItemCategoryCmbValues(String strItemCategoryCmbValues) {
		this.strItemCategoryCmbValues = strItemCategoryCmbValues;
	}
	/**
	 * @return the strPONOCmbValues
	 */
	public String getStrPONOCmbValues() {
		return strPONOCmbValues;
	}
	/**
	 * @param strPONOCmbValues the strPONOCmbValues to set
	 */
	public void setStrPONOCmbValues(String strPONOCmbValues) {
		this.strPONOCmbValues = strPONOCmbValues;
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
	 * @return the strItemCategory
	 */
	public String getStrItemCategory() {
		return strItemCategory;
	}
	/**
	 * @param strItemCategory the strItemCategory to set
	 */
	public void setStrItemCategory(String strItemCategory) {
		this.strItemCategory = strItemCategory;
	}
	/**
	 * @return the pONOName
	 */
	public String getPONOName() {
		return PONOName;
	}
	/**
	 * @param name the pONOName to set
	 */
	public void setPONOName(String name) {
		PONOName = name;
	}
	/**
	 * @return the displayFlag
	 */
	public String getDisplayFlag() {
		return displayFlag;
	}
	/**
	 * @param displayFlag the displayFlag to set
	 */
	public void setDisplayFlag(String displayFlag) {
		this.displayFlag = displayFlag;
	}
	/**
	 * @return the strRequestDetails
	 */
	public String getStrRequestDetails() {
		return strRequestDetails;
	}
	/**
	 * @param strRequestDetails the strRequestDetails to set
	 */
	public void setStrRequestDetails(String strRequestDetails) {
		this.strRequestDetails = strRequestDetails;
	}
	/**
	 * @return the strBillDetails
	 */
	public String getStrBillDetails() {
		return strBillDetails;
	}
	/**
	 * @param strBillDetails the strBillDetails to set
	 */
	public void setStrBillDetails(String strBillDetails) {
		this.strBillDetails = strBillDetails;
	}
	/**
	 * @return the chkSelected
	 */
	public String getChkSelected() {
		return chkSelected;
	}
	/**
	 * @param chkSelected the chkSelected to set
	 */
	public void setChkSelected(String chkSelected) {
		this.chkSelected = chkSelected;
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
	 * @param strBillNo the strBillNo to set
	 */
	public void setStrBillNo(String[] strBillNo) {
		this.strBillNo = strBillNo;
	}
	/**
	 * @return the hideStoreId
	 */
	public String getHideStoreId() {
		return hideStoreId;
	}
	/**
	 * @param hideStoreId the hideStoreId to set
	 */
	public void setHideStoreId(String hideStoreId) {
		this.hideStoreId = hideStoreId;
	}
	/**
	 * @return the hideItemCatId
	 */
	public String getHideItemCatId() {
		return hideItemCatId;
	}
	/**
	 * @param hideItemCatId the hideItemCatId to set
	 */
	public void setHideItemCatId(String hideItemCatId) {
		this.hideItemCatId = hideItemCatId;
	}
	/**
	 * @return the hidePONO
	 */
	public String getHidePONO() {
		return hidePONO;
	}
	/**
	 * @param hidePONO the hidePONO to set
	 */
	public void setHidePONO(String hidePONO) {
		this.hidePONO = hidePONO;
	}
	/**
	 * @return the strBillNo
	 */
	public String[] getStrBillNo() {
		return strBillNo;
	}
	public String getStrCurrencyId() {
		return strCurrencyId;
	}
	public void setStrCurrencyId(String strCurrencyId) {
		this.strCurrencyId = strCurrencyId;
	}
	public String getStrCurrValuePO() {
		return strCurrValuePO;
	}
	public void setStrCurrValuePO(String strCurrValuePO) {
		this.strCurrValuePO = strCurrValuePO;
	}
	public String getStrCurrValue() {
		return strCurrValue;
	}
	public void setStrCurrValue(String strCurrValue) {
		this.strCurrValue = strCurrValue;
	}
	public String getStrExchangeVar() {
		return strExchangeVar;
	}
	public void setStrExchangeVar(String strExchangeVar) {
		this.strExchangeVar = strExchangeVar;
	}
	public String getStrDefCurrId() {
		return strDefCurrId;
	}
	public void setStrDefCurrId(String strDefCurrId) {
		this.strDefCurrId = strDefCurrId;
	}
	public String getStrDispatchNo() {
		return strDispatchNo;
	}
	public void setStrDispatchNo(String strDispatchNo) {
		this.strDispatchNo = strDispatchNo;
	}
	public String getStrDispatchDate() {
		return strDispatchDate;
	}
	public void setStrDispatchDate(String strDispatchDate) {
		this.strDispatchDate = strDispatchDate;
	}
	public String getStrInstFor() {
		return strInstFor;
	}
	public void setStrInstFor(String strInstFor) {
		this.strInstFor = strInstFor;
	}
	public String getStrPONoView() {
		return strPONoView;
	}
	public void setStrPONoView(String strPONoView) {
		this.strPONoView = strPONoView;
	}
	public String getStrSuppNameView() {
		return strSuppNameView;
	}
	public void setStrSuppNameView(String strSuppNameView) {
		this.strSuppNameView = strSuppNameView;
	}
	public String getStrInstAmtView() {
		return strInstAmtView;
	}
	public void setStrInstAmtView(String strInstAmtView) {
		this.strInstAmtView = strInstAmtView;
	}
	public String getStrDispatchDetails() {
		return strDispatchDetails;
	}
	public void setStrDispatchDetails(String strDispatchDetails) {
		this.strDispatchDetails = strDispatchDetails;
	}
	public String getPoPrefix() {
		return poPrefix;
	}
	public void setPoPrefix(String poPrefix) {
		this.poPrefix = poPrefix;
	}
	
	
	
	
	

}
