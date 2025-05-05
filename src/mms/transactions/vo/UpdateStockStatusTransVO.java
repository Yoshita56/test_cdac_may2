package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;


/**
 * Developer : Vivek Aggarwl
 * Version : 1.0
 * Date : 05/Jan/2012
 * Modif Date : / /2009 
*/

public class UpdateStockStatusTransVO 
{
private static final long serialVersionUID = 02L;
	
	private String strMode;
	
	private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
    private String strMsgString = "";
	private String strMsgType = "0";
	private String strErrMsg = "";

	private String strHospitalCode = "";
	private String strCtDate = "";
	private String strSeatId = "";
	private String strStoreId;

	private String strDrugWareHouseTypeId;
	private String strDrugWareHouseName;
	private String strDrugWareHouseNameCmb;
	
	private WebRowSet wrsDrugWareHouseNameCmb;
	
	private String strRemarks;
	private String strIsValid;
	private String strEntryDate;
	
	private WebRowSet strItemCatWs;
	private String strGroupId;
	private WebRowSet strGroupNameComboWS;
	private WebRowSet strDrugNameComboWS;
	private WebRowSet strStockStatusWs;
	
	private String strItemCategoryId;
	private String strItemBrandId;
	private String strUnitRateID;
	private String strRequestTypeId; 
	private String strWhetherUpdateNewStatusInAllDWH;
	
	private String strStockStatusCode;

	private String strOldStoreId;
	private String strItemId;
	private String strBatchNo;
	private String strItemSlNo;
	private String strQty;
	private String strQtyUnitId;
	private String strNewStockStatusCode;
	private String strApprovedBy;
	private String strDesc;
	
	
//	private String strGroupId;                             
	private String strSubGroupId;                          
	private String strExpiryDate;                          
	private String strManufDate;                           
	private String strAvailableQty;   
	private String strAvailableQtyUnitId;
	private String strSuppId;
	private String strRate;
	private String strRateUnitId;
	private String strSalePrice;
	private String strSalePriceUnitId;
	private String strPoNo;
	private String strPoNoDate;
	private String strInvoiceNo;
	private String strInvoiceDate;
	private String strSuppliedBy;
	private String strRecievedDate;
	private String strCurrencyCode;
	private String strFreeItemFlag;
	private String strCurrencyValue;
	private String strItemSpecification;       
	
	private String strFromDate;
	private String strToDate;
	
	private WebRowSet wrsData;
	private WebRowSet wsUnitCombo;
	private WebRowSet wrsRecievedByCombo;
	private String  strHiddenValues;
	private String strIndex;
	private String strChkValue;


	public WebRowSet getWrsRecievedByCombo() {
		return wrsRecievedByCombo;
	}



	public void setWrsRecievedByCombo(WebRowSet wrsRecievedByCombo) {
		this.wrsRecievedByCombo = wrsRecievedByCombo;
	}



	public WebRowSet getWsUnitCombo() {
		return wsUnitCombo;
	}



	public void setWsUnitCombo(WebRowSet wsUnitCombo) {
		this.wsUnitCombo = wsUnitCombo;
	}



	public String getStrMode() {
		return strMode;
	}



	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}



	public String getStrErr() {
		return strErr;
	}



	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}



	public String getStrMsg() {
		return strMsg;
	}



	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}



	public String getStrWarning() {
		return strWarning;
	}



	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}



	public String getStrMsgString() {
		return strMsgString;
	}



	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}



	public String getStrMsgType() {
		return strMsgType;
	}



	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}



	public String getStrErrMsg() {
		return strErrMsg;
	}



	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}



	public String getStrHospitalCode() {
		return strHospitalCode;
	}



	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}



	public String getStrCtDate() {
		return strCtDate;
	}



	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}



	public String getStrSeatId() {
		return strSeatId;
	}



	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}



	public String getStrDrugWareHouseTypeId() {
		return strDrugWareHouseTypeId;
	}



	public void setStrDrugWareHouseTypeId(String strDrugWareHouseTypeId) {
		this.strDrugWareHouseTypeId = strDrugWareHouseTypeId;
	}



	public String getStrDrugWareHouseName() {
		return strDrugWareHouseName;
	}



	public void setStrDrugWareHouseName(String strDrugWareHouseName) {
		this.strDrugWareHouseName = strDrugWareHouseName;
	}



	public String getStrDrugWareHouseNameCmb() {
		return strDrugWareHouseNameCmb;
	}



	public void setStrDrugWareHouseNameCmb(String strDrugWareHouseNameCmb) {
		this.strDrugWareHouseNameCmb = strDrugWareHouseNameCmb;
	}



	public WebRowSet getWrsDrugWareHouseNameCmb() {
		return wrsDrugWareHouseNameCmb;
	}



	public void setWrsDrugWareHouseNameCmb(WebRowSet wrsDrugWareHouseNameCmb) {
		this.wrsDrugWareHouseNameCmb = wrsDrugWareHouseNameCmb;
	}



	public String getStrRemarks() {
		return strRemarks;
	}



	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}



	public String getStrIsValid() {
		return strIsValid;
	}



	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}



	public String getStrEntryDate() {
		return strEntryDate;
	}



	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}



	public WebRowSet getWrsData() {
		return wrsData;
	}



	public void setWrsData(WebRowSet wrsData) {
		this.wrsData = wrsData;
	}



	public WebRowSet getStrItemCatWs() {
		return strItemCatWs;
	}



	public void setStrItemCatWs(WebRowSet strItemCatWs) {
		this.strItemCatWs = strItemCatWs;
	}



	public WebRowSet getStrGroupNameComboWS() {
		return strGroupNameComboWS;
	}



	public void setStrGroupNameComboWS(WebRowSet strGroupNameComboWS) {
		this.strGroupNameComboWS = strGroupNameComboWS;
	}



	public String getStrGroupId() {
		return strGroupId;
	}



	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}



	public WebRowSet getStrDrugNameComboWS() {
		return strDrugNameComboWS;
	}



	public void setStrDrugNameComboWS(WebRowSet strDrugNameComboWS) {
		this.strDrugNameComboWS = strDrugNameComboWS;
	}



	public String getStrItemCategoryId() {
		return strItemCategoryId;
	}



	public void setStrItemCategoryId(String strItemCategoryId) {
		this.strItemCategoryId = strItemCategoryId;
	}



	public String getStrItemBrandId() {
		return strItemBrandId;
	}



	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}



	public WebRowSet getStrStockStatusWs() {
		return strStockStatusWs;
	}



	public void setStrStockStatusWs(WebRowSet strStockStatusWs) {
		this.strStockStatusWs = strStockStatusWs;
	}



	public String getStrUnitRateID() {
		return strUnitRateID;
	}



	public void setStrUnitRateID(String strUnitRateID) {
		this.strUnitRateID = strUnitRateID;
	}



	public String getStrRequestTypeId() {
		return strRequestTypeId;
	}



	public void setStrRequestTypeId(String strRequestTypeId) {
		this.strRequestTypeId = strRequestTypeId;
	}



	public String getStrWhetherUpdateNewStatusInAllDWH() {
		return strWhetherUpdateNewStatusInAllDWH;
	}



	public void setStrWhetherUpdateNewStatusInAllDWH(
			String strWhetherUpdateNewStatusInAllDWH) {
		this.strWhetherUpdateNewStatusInAllDWH = strWhetherUpdateNewStatusInAllDWH;
	}



	public String getStrStockStatusCode() {
		return strStockStatusCode;
	}



	public void setStrStockStatusCode(String strStockStatusCode) {
		this.strStockStatusCode = strStockStatusCode;
	}



	public String getStrOldStoreId() {
		return strOldStoreId;
	}



	public void setStrOldStoreId(String strOldStoreId) {
		this.strOldStoreId = strOldStoreId;
	}



	public String getStrItemId() {
		return strItemId;
	}



	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}



	public String getStrBatchNo() {
		return strBatchNo;
	}



	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}



	public String getStrItemSlNo() {
		return strItemSlNo;
	}



	public void setStrItemSlNo(String strItemSlNo) {
		this.strItemSlNo = strItemSlNo;
	}



	public String getStrQty() {
		return strQty;
	}



	public void setStrQty(String strQty) {
		this.strQty = strQty;
	}



	public String getStrQtyUnitId() {
		return strQtyUnitId;
	}



	public void setStrQtyUnitId(String strQtyUnitId) {
		this.strQtyUnitId = strQtyUnitId;
	}



	public String getStrNewStockStatusCode() {
		return strNewStockStatusCode;
	}



	public void setStrNewStockStatusCode(String strNewStockStatusCode) {
		this.strNewStockStatusCode = strNewStockStatusCode;
	}



	public String getStrApprovedBy() {
		return strApprovedBy;
	}



	public void setStrApprovedBy(String strApprovedBy) {
		this.strApprovedBy = strApprovedBy;
	}



	public String getStrDesc() {
		return strDesc;
	}



	public void setStrDesc(String strDesc) {
		this.strDesc = strDesc;
	}



	public String getStrSubGroupId() {
		return strSubGroupId;
	}



	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}



	public String getStrExpiryDate() {
		return strExpiryDate;
	}



	public void setStrExpiryDate(String strExpiryDate) {
		this.strExpiryDate = strExpiryDate;
	}



	public String getStrManufDate() {
		return strManufDate;
	}



	public void setStrManufDate(String strManufDate) {
		this.strManufDate = strManufDate;
	}



	public String getStrAvailableQty() {
		return strAvailableQty;
	}



	public void setStrAvailableQty(String strAvailableQty) {
		this.strAvailableQty = strAvailableQty;
	}



	public String getStrAvailableQtyUnitId() {
		return strAvailableQtyUnitId;
	}



	public void setStrAvailableQtyUnitId(String strAvailableQtyUnitId) {
		this.strAvailableQtyUnitId = strAvailableQtyUnitId;
	}



	public String getStrSuppId() {
		return strSuppId;
	}



	public void setStrSuppId(String strSuppId) {
		this.strSuppId = strSuppId;
	}



	public String getStrRate() {
		return strRate;
	}



	public void setStrRate(String strRate) {
		this.strRate = strRate;
	}



	public String getStrRateUnitId() {
		return strRateUnitId;
	}



	public void setStrRateUnitId(String strRateUnitId) {
		this.strRateUnitId = strRateUnitId;
	}



	public String getStrSalePrice() {
		return strSalePrice;
	}



	public void setStrSalePrice(String strSalePrice) {
		this.strSalePrice = strSalePrice;
	}



	public String getStrSalePriceUnitId() {
		return strSalePriceUnitId;
	}



	public void setStrSalePriceUnitId(String strSalePriceUnitId) {
		this.strSalePriceUnitId = strSalePriceUnitId;
	}



	public String getStrPoNo() {
		return strPoNo;
	}



	public void setStrPoNo(String strPoNo) {
		this.strPoNo = strPoNo;
	}



	public String getStrPoNoDate() {
		return strPoNoDate;
	}



	public void setStrPoNoDate(String strPoNoDate) {
		this.strPoNoDate = strPoNoDate;
	}



	public String getStrInvoiceNo() {
		return strInvoiceNo;
	}



	public void setStrInvoiceNo(String strInvoiceNo) {
		this.strInvoiceNo = strInvoiceNo;
	}



	public String getStrInvoiceDate() {
		return strInvoiceDate;
	}



	public void setStrInvoiceDate(String strInvoiceDate) {
		this.strInvoiceDate = strInvoiceDate;
	}



	public String getStrSuppliedBy() {
		return strSuppliedBy;
	}



	public void setStrSuppliedBy(String strSuppliedBy) {
		this.strSuppliedBy = strSuppliedBy;
	}



	public String getStrRecievedDate() {
		return strRecievedDate;
	}



	public void setStrRecievedDate(String strRecievedDate) {
		this.strRecievedDate = strRecievedDate;
	}



	public String getStrCurrencyCode() {
		return strCurrencyCode;
	}



	public void setStrCurrencyCode(String strCurrencyCode) {
		this.strCurrencyCode = strCurrencyCode;
	}



	public String getStrFreeItemFlag() {
		return strFreeItemFlag;
	}



	public void setStrFreeItemFlag(String strFreeItemFlag) {
		this.strFreeItemFlag = strFreeItemFlag;
	}



	public String getStrCurrencyValue() {
		return strCurrencyValue;
	}



	public void setStrCurrencyValue(String strCurrencyValue) {
		this.strCurrencyValue = strCurrencyValue;
	}



	public String getStrItemSpecification() {
		return strItemSpecification;
	}



	public void setStrItemSpecification(String strItemSpecification) {
		this.strItemSpecification = strItemSpecification;
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



	public String getStrHiddenValues() {
		return strHiddenValues;
	}



	public void setStrHiddenValues(String strHiddenValues) {
		this.strHiddenValues = strHiddenValues;
	}



	public String getStrIndex() {
		return strIndex;
	}



	public void setStrIndex(String strIndex) {
		this.strIndex = strIndex;
	}



	public String getStrChkValue() {
		return strChkValue;
	}



	public void setStrChkValue(String strChkValue) {
		this.strChkValue = strChkValue;
	}



	public String getStrStoreId() {
		return strStoreId;
	}



	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
}
