package mms.transactions.controller.fb;
/**
 * Developer : Vivek Aggarwal
 * Version : 1.0
 * Date : 05-Jan-2012
 * Modify Date : 
*/
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class UpdateStockStatusTransFB extends ActionForm 
{
	private static final long serialVersionUID = 02L;
	private String strNormalMsg = "";
	private String strWarningMsg = "";
    private String strMsgString = "";
	private String strMsgType = "";
	private String strErrMsg = "";

	private String strHospitalCode = "";
	
	
	private String strSeatId = "";
	private String hmode;
	/************Variable Start Here******************/
	private String strViewCheckBox;
	
	private String strDrugWareHouseName;
	private String strDrugWareHouseNameCmb;
	private String strDrugWareHouseTypeId;
	
	private WebRowSet wrsDrugWareHouseNameCmb;
		
	private String strRemarks;
	
	private String strStoreId;
	private String strViewMode;
	private String strStoreNameCombo;
	private String 	strItemCategoryCombo;
	
	private String 	strGroupCombo;
	private String 	strDrugCombo;
	private String 	strCurrentDate;
	private String 	strGroupId;
	
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
	
	
	private String strNewStockStatus;
	private String strStockStatusValues;
	private String strWhetherUpdateNewStatusInAllDWH;
	private String strStockStatusCode;
	
	
	private String strQty;
	private String strUnitId;
	
	private String strDrugId;
	private String strItemCategoryId;
	private String strApprovedBy;
	private String strApprovedByOther;
	private String strHiddenValues;
	private String strIndex;
	private String strChkValue;
	private String strItemCatgCmb;
	
	public String getStrItemCatgCmb() {
		return strItemCatgCmb;
	}



	public void setStrItemCatgCmb(String strItemCatgCmb) {
		this.strItemCatgCmb = strItemCatgCmb;
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



	public String getStrApprovedByOther() {
		return strApprovedByOther;
	}



	public void setStrApprovedByOther(String strApprovedByOther) {
		this.strApprovedByOther = strApprovedByOther;
	}



	public String getStrApprovedBy() {
		return strApprovedBy;
	}



	public void setStrApprovedBy(String strApprovedBy) {
		this.strApprovedBy = strApprovedBy;
	}



	public String getStrItemCategoryId() {
		return strItemCategoryId;
	}



	public void setStrItemCategoryId(String strItemCategoryId) {
		this.strItemCategoryId = strItemCategoryId;
	}



	public String getStrGroupId() {
		return strGroupId;
	}



	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}



	public String getStrViewMode() {
		return strViewMode;
	}



	public void setStrViewMode(String strViewMode) {
		this.strViewMode = strViewMode;
	}



	public String getStrStoreNameCombo() {
		return strStoreNameCombo;
	}



	public void setStrStoreNameCombo(String strStoreNameCombo) {
		this.strStoreNameCombo = strStoreNameCombo;
	}



	public String getStrItemCategoryCombo() {
		return strItemCategoryCombo;
	}



	public void setStrItemCategoryCombo(String strItemCategoryCombo) {
		this.strItemCategoryCombo = strItemCategoryCombo;
	}



	public String getStrGroupCombo() {
		return strGroupCombo;
	}



	public void setStrGroupCombo(String strGroupCombo) {
		this.strGroupCombo = strGroupCombo;
	}



	public String getStrDrugCombo() {
		return strDrugCombo;
	}



	public void setStrDrugCombo(String strDrugCombo) {
		this.strDrugCombo = strDrugCombo;
	}



	public String getStrCurrentDate() {
		return strCurrentDate;
	}



	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}



	/*
	 * 	To reset the values on the Add Page
	 */
	public void reset(ActionMapping mapping,HttpServletRequest request)
	{		
		this.setStrDrugWareHouseName("0");
		
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


	public String getStrSeatId() {
		return strSeatId;
	}



	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}



	public String getHmode() {
		return hmode;
	}



	public void setHmode(String hmode) {
		this.hmode = hmode;
	}



	public String getStrViewCheckBox() {
		return strViewCheckBox;
	}



	public void setStrViewCheckBox(String strViewCheckBox) {
		this.strViewCheckBox = strViewCheckBox;
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



	public String getStrStoreId() {
		return strStoreId;
	}



	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}



	public String getStrDrugWareHouseTypeId() {
		return strDrugWareHouseTypeId;
	}



	public void setStrDrugWareHouseTypeId(String strDrugWareHouseTypeId) {
		this.strDrugWareHouseTypeId = strDrugWareHouseTypeId;
	}



	public String getStrNewStockStatus() {
		return strNewStockStatus;
	}



	public void setStrNewStockStatus(String strNewStockStatus) {
		this.strNewStockStatus = strNewStockStatus;
	}



	public String getStrStockStatusValues() {
		return strStockStatusValues;
	}



	public void setStrStockStatusValues(String strStockStatusValues) {
		this.strStockStatusValues = strStockStatusValues;
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



	public String getStrHiddenValues() {
		return strHiddenValues;
	}



	public void setStrHiddenValues(String strHiddenValues) {
		this.strHiddenValues = strHiddenValues;
	}



	public String getStrDrugId() {
		return strDrugId;
	}



	public void setStrDrugId(String strDrugId) {
		this.strDrugId = strDrugId;
	}



	public String getStrQty() {
		return strQty;
	}



	public void setStrQty(String strQty) {
		this.strQty = strQty;
	}



	public String getStrUnitId() {
		return strUnitId;
	}



	public void setStrUnitId(String strUnitId) {
		this.strUnitId = strUnitId;
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
}
