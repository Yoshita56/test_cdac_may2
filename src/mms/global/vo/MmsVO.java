package mms.global.vo;

import hisglobal.utility.TransferObject;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * The Class MmsVO.
 */
public class MmsVO implements TransferObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	// Common for All the Util
	/** The str msg type. */
	private String strMsgType = "";
	
	/** The str msg string. */
	private String strMsgString = "";

	/** The str value1. */
	private String strValue1 = "0";
	
	/** The str value2. */
	private String strValue2 = "0";
	
	/** The str value3. */
	private String strValue3 = "0";
	
	/** The str value4. */
	private String strValue4 = "";
	
	/** The str value5. */
	private String strValue5 = "";
	
	/** The str value6. */
	private String strValue6 = "";
	
	/** The str value7. */
	private String strValue7 = "";
	
	/** The str value8. */
	private String strValue8 = "";

	/** The gbl ws1. */
	private WebRowSet gblWs1 = null;
	
	/** The gbl ws2. */
	private WebRowSet gblWs2 = null;
	
	/** The gbl ws3. */
	private WebRowSet gblWs3 = null;

	/** The str seat id. */
	private String strSeatId = "";

	/** The str util mode. */
	private String strUtilMode = "0";
	
	/** The str hospital code. */
	private String strHospitalCode = "";

	/** The str item mandatory dtls. */
	private String strItemMandatoryDtls = "";

	// Item Parameter Util

	/** The str param check. */
	private String strParamCheck[] = null;
	
	/** The str param value. */
	private String strParamValue[] = null;

	/** The str param dtls. */
	private String strParamDtls[] = null;
	
	/** The str param status. */
	private String strParamStatus[] = null;

	/** The str item category no. */
	private String strItemCategoryNo = "0";
	
	/** The str parent parameter id. */
	private String strParentParameterId = "0";
	
	/** The str item id. */
	private String strItemId = "0";

	/** The str user info. */
	private String strUserInfo = "";

	/** The str item param ws. */
	private WebRowSet strItemParamWs = null;
	
	/** The str item param dtls ws. */
	private WebRowSet strItemParamDtlsWs = null;

	private String strUnitName = "";
	
	private String strUnitMode = "0";
	
	// Search Item Util

	/** The str from store id. */
	private String strFromStoreId = "0";
	
	/** The str group id. */
	private String strGroupId = "0";
	
	/** The str mode val. */
	private String strModeVal = "0";
	
	/** The str sub group id. */
	private String strSubGroupId = "0";

	/** The str request type. */
	private String strRequestType = "0";

	/** The str unit id. */
	private String strUnitId = "0";

	/** The str sub group ws. */
	private WebRowSet strSubGroupWs = null;

	/** The str item list ws. */
	private WebRowSet strItemListWs = null;
	
	/** The str brand item list ws. */
	private WebRowSet strBrandItemListWs = null;

	/** The str unit list ws. */
	private WebRowSet strUnitListWs = null;

	private WebRowSet strItemTypeWs = null;
	
	private String strRateInBaseValue = "0";
	
	private String strNewItemFlag = "";
	
	// Stock Item Details

	/** The str stock status. */
	private String strStockStatus = "";
	
	/** The str genric item id. */
	private String strGenricItemId = "";
	
	/** The str issue qty. */
	private String strIssueQty = "";
	
	/** The str issue qty in base. */
	private String strIssueQtyInBase = "";
	
	/** The str reserved flag. */
	private String strReservedFlag = "0";
	
	/** The str item name. */
	private String strItemName = "";
	
	/** The str store name. */
	private String strStoreName = "";
	
	private String strRateUnit = "";
	
	/** The ws stock details. */
	private WebRowSet wsStockDetails = null;

	
	
	

	// New Item Add Details 
	
	private String strNewItemName = "";
	private String strNewItemType = "";
	private String strNewItemMake = "";
	private String strNewItemManufacturer = "";
	private String strNewItemIsQuantifiable = "";
	private String strNewItemIsSetSachet = "";
	private String strNewItemSpecification = "";
	private String strNewItemShortName = "";
	private String strNewItemReorderLevel = "";
	private String strNewItemMaxLevel = "";
	private String strNewItemLevelUnit = "";
	
	private String strIsStoreItem = "0";
	// Use In OffLine Issue\Return Item 
	private String strSlNoflg="0";
    private String strReturnReqNo;
	private String strLogoName="";	

	
	public String getStrLogoName() {
		return strLogoName;
	}

	public void setStrLogoName(String strLogoName) {
		this.strLogoName = strLogoName;
	}

	/**
	 * @return the strReturnReqNo
	 */
	public String getStrReturnReqNo() {
		return strReturnReqNo;
	}

	/**
	 * @param strReturnReqNo the strReturnReqNo to set
	 */
	public void setStrReturnReqNo(String strReturnReqNo) {
		this.strReturnReqNo = strReturnReqNo;
	}

	public String getStrIsStoreItem() {
		return strIsStoreItem;
	}

	public void setStrIsStoreItem(String strIsStoreItem) {
		this.strIsStoreItem = strIsStoreItem;
	}

	public String getStrNewItemName() {
		return strNewItemName;
	}

	public void setStrNewItemName(String strNewItemName) {
		this.strNewItemName = strNewItemName;
	}

	public String getStrNewItemType() {
		return strNewItemType;
	}

	public void setStrNewItemType(String strNewItemType) {
		this.strNewItemType = strNewItemType;
	}

	public String getStrNewItemMake() {
		return strNewItemMake;
	}

	public void setStrNewItemMake(String strNewItemMake) {
		this.strNewItemMake = strNewItemMake;
	}

	public String getStrNewItemManufacturer() {
		return strNewItemManufacturer;
	}

	public void setStrNewItemManufacturer(String strNewItemManufacturer) {
		this.strNewItemManufacturer = strNewItemManufacturer;
	}

	public String getStrNewItemIsQuantifiable() {
		return strNewItemIsQuantifiable;
	}

	public void setStrNewItemIsQuantifiable(String strNewItemIsQuantifiable) {
		this.strNewItemIsQuantifiable = strNewItemIsQuantifiable;
	}

	public String getStrNewItemIsSetSachet() {
		return strNewItemIsSetSachet;
	}

	public void setStrNewItemIsSetSachet(String strNewItemIsSetSachet) {
		this.strNewItemIsSetSachet = strNewItemIsSetSachet;
	}

	public String getStrNewItemShortName() {
		return strNewItemShortName;
	}

	public void setStrNewItemShortName(String strNewItemShortName) {
		this.strNewItemShortName = strNewItemShortName;
	}

	public String getStrNewItemReorderLevel() {
		return strNewItemReorderLevel;
	}

	public void setStrNewItemReorderLevel(String strNewItemReorderLevel) {
		this.strNewItemReorderLevel = strNewItemReorderLevel;
	}

	public String getStrNewItemMaxLevel() {
		return strNewItemMaxLevel;
	}

	public void setStrNewItemMaxLevel(String strNewItemMaxLevel) {
		this.strNewItemMaxLevel = strNewItemMaxLevel;
	}

	public String getStrNewItemLevelUnit() {
		return strNewItemLevelUnit;
	}

	public void setStrNewItemLevelUnit(String strNewItemLevelUnit) {
		this.strNewItemLevelUnit = strNewItemLevelUnit;
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
	 * @param strStoreName the new str store name
	 */
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}

	/**
	 * Gets the str reserved flag.
	 * 
	 * @return the str reserved flag
	 */
	public String getStrReservedFlag() {
		return strReservedFlag;
	}

	/**
	 * Sets the str reserved flag.
	 * 
	 * @param strReservedFlag the new str reserved flag
	 */
	public void setStrReservedFlag(String strReservedFlag) {
		this.strReservedFlag = strReservedFlag;
	}

	// Issue Details Util

	/** The str issue no. */
	private String strIssueNo = "0";
	
	/** The str issue date. */
	private String strIssueDate = "0";
	
	/** The str issue to. */
	private String strIssueTo = "";
	
	/** The ws issue details. */
	private WebRowSet wsIssueDetails = null;

	// item Other Details

	/** The str batch sl no. */
	private String strBatchSlNo = "0";

	/** The str module id. */
	private String strModuleId = "0";
	
	/** The ws item other dtls. */
	private WebRowSet wsItemOtherDtls = null;

	/** The ws item category list. */
	private WebRowSet wsItemCategoryList = null;
	
	/** The ws group list. */
	private WebRowSet wsGroupList = null;
	
	/** The ws genric item list. */
	private WebRowSet wsGenricItemList = null;
	
	/** The ws item list. */
	private WebRowSet wsItemList = null;
	
	/** The ws unit list. */
	private WebRowSet wsUnitList = null;
	
	/** The ws manufacturer list. */
	private WebRowSet wsManufacturerList = null;

	private WebRowSet wsComponentTypeList = null;
	private WebRowSet wsItemTypeList = null;
	
	public WebRowSet getWsComponentTypeList() {
		return wsComponentTypeList;
	}

	public void setWsComponentTypeList(WebRowSet wsComponentTypeList) {
		this.wsComponentTypeList = wsComponentTypeList;
	}

	/**
	 * Gets the ws unit list.
	 * 
	 * @return the ws unit list
	 */
	public WebRowSet getWsUnitList() {
		return wsUnitList;
	}

	/**
	 * Sets the ws unit list.
	 * 
	 * @param wsUnitList the new ws unit list
	 */
	public void setWsUnitList(WebRowSet wsUnitList) {
		this.wsUnitList = wsUnitList;
	}

	/**
	 * Gets the ws genric item list.
	 * 
	 * @return the ws genric item list
	 */
	public WebRowSet getWsGenricItemList() {
		return wsGenricItemList;
	}

	/**
	 * Sets the ws genric item list.
	 * 
	 * @param wsGenricItemList the new ws genric item list
	 */
	public void setWsGenricItemList(WebRowSet wsGenricItemList) {
		this.wsGenricItemList = wsGenricItemList;
	}

	/**
	 * Gets the ws item list.
	 * 
	 * @return the ws item list
	 */
	public WebRowSet getWsItemList() {
		return wsItemList;
	}

	/**
	 * Sets the ws item list.
	 * 
	 * @param wsItemList the new ws item list
	 */
	public void setWsItemList(WebRowSet wsItemList) {
		this.wsItemList = wsItemList;
	}

	/**
	 * Gets the ws group list.
	 * 
	 * @return the ws group list
	 */
	public WebRowSet getWsGroupList() {
		return wsGroupList;
	}

	/**
	 * Sets the ws group list.
	 * 
	 * @param wsGroupList the new ws group list
	 */
	public void setWsGroupList(WebRowSet wsGroupList) {
		this.wsGroupList = wsGroupList;
	}

	/**
	 * Gets the ws item category list.
	 * 
	 * @return the ws item category list
	 */
	public WebRowSet getWsItemCategoryList() {
		return wsItemCategoryList;
	}

	/**
	 * Sets the ws item category list.
	 * 
	 * @param wsItemCategoryList the new ws item category list
	 */
	public void setWsItemCategoryList(WebRowSet wsItemCategoryList) {
		this.wsItemCategoryList = wsItemCategoryList;
	}

	/**
	 * Gets the str batch sl no.
	 * 
	 * @return the str batch sl no
	 */
	public String getStrBatchSlNo() {
		return strBatchSlNo;
	}

	/**
	 * Sets the str batch sl no.
	 * 
	 * @param strBatchSlNo the new str batch sl no
	 */
	public void setStrBatchSlNo(String strBatchSlNo) {
		this.strBatchSlNo = strBatchSlNo;
	}

	/**
	 * Gets the ws item other dtls.
	 * 
	 * @return the ws item other dtls
	 */
	public WebRowSet getWsItemOtherDtls() {
		return wsItemOtherDtls;
	}

	/**
	 * Sets the ws item other dtls.
	 * 
	 * @param wsItemOtherDtls the new ws item other dtls
	 */
	public void setWsItemOtherDtls(WebRowSet wsItemOtherDtls) {
		this.wsItemOtherDtls = wsItemOtherDtls;
	}

	/**
	 * Gets the str issue date.
	 * 
	 * @return the str issue date
	 */
	public String getStrIssueDate() {
		return strIssueDate;
	}

	/**
	 * Sets the str issue date.
	 * 
	 * @param strIssueDate the new str issue date
	 */
	public void setStrIssueDate(String strIssueDate) {
		this.strIssueDate = strIssueDate;
	}

	/**
	 * Gets the str issue to.
	 * 
	 * @return the str issue to
	 */
	public String getStrIssueTo() {
		return strIssueTo;
	}

	/**
	 * Sets the str issue to.
	 * 
	 * @param strIssueTo the new str issue to
	 */
	public void setStrIssueTo(String strIssueTo) {
		this.strIssueTo = strIssueTo;
	}

	/**
	 * Gets the str issue no.
	 * 
	 * @return the str issue no
	 */
	public String getStrIssueNo() {
		return strIssueNo;
	}

	/**
	 * Sets the str issue no.
	 * 
	 * @param strIssueNo the new str issue no
	 */
	public void setStrIssueNo(String strIssueNo) {
		this.strIssueNo = strIssueNo;
	}

	/**
	 * Gets the ws issue details.
	 * 
	 * @return the ws issue details
	 */
	public WebRowSet getWsIssueDetails() {
		return wsIssueDetails;
	}

	/**
	 * Sets the ws issue details.
	 * 
	 * @param wsIssueDetails the new ws issue details
	 */
	public void setWsIssueDetails(WebRowSet wsIssueDetails) {
		this.wsIssueDetails = wsIssueDetails;
	}

	/**
	 * Gets the str item name.
	 * 
	 * @return the str item name
	 */
	public String getStrItemName() {
		return strItemName;
	}

	/**
	 * Sets the str item name.
	 * 
	 * @param strItemName the new str item name
	 */
	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}

	/**
	 * Gets the ws stock details.
	 * 
	 * @return the ws stock details
	 */
	public WebRowSet getWsStockDetails() {
		return wsStockDetails;
	}

	/**
	 * Sets the ws stock details.
	 * 
	 * @param wsStockDetails the new ws stock details
	 */
	public void setWsStockDetails(WebRowSet wsStockDetails) {
		this.wsStockDetails = wsStockDetails;
	}

	/**
	 * Gets the str stock status.
	 * 
	 * @return the str stock status
	 */
	public String getStrStockStatus() {
		return strStockStatus;
	}

	/**
	 * Sets the str stock status.
	 * 
	 * @param strStockStatus the new str stock status
	 */
	public void setStrStockStatus(String strStockStatus) {
		this.strStockStatus = strStockStatus;
	}

	/**
	 * Gets the str genric item id.
	 * 
	 * @return the str genric item id
	 */
	public String getStrGenricItemId() {
		return strGenricItemId;
	}

	/**
	 * Sets the str genric item id.
	 * 
	 * @param strGenricItemId the new str genric item id
	 */
	public void setStrGenricItemId(String strGenricItemId) {
		this.strGenricItemId = strGenricItemId;
	}

	/**
	 * Gets the str issue qty.
	 * 
	 * @return the str issue qty
	 */
	public String getStrIssueQty() {
		return strIssueQty;
	}

	/**
	 * Sets the str issue qty.
	 * 
	 * @param strIssueQty the new str issue qty
	 */
	public void setStrIssueQty(String strIssueQty) {
		this.strIssueQty = strIssueQty;
	}

	/**
	 * Gets the str issue qty in base.
	 * 
	 * @return the str issue qty in base
	 */
	public String getStrIssueQtyInBase() {
		return strIssueQtyInBase;
	}

	/**
	 * Sets the str issue qty in base.
	 * 
	 * @param strIssueQtyInBase the new str issue qty in base
	 */
	public void setStrIssueQtyInBase(String strIssueQtyInBase) {
		this.strIssueQtyInBase = strIssueQtyInBase;
	}

	/**
	 * Gets the str unit list ws.
	 * 
	 * @return the str unit list ws
	 */
	public WebRowSet getStrUnitListWs() {
		return strUnitListWs;
	}

	/**
	 * Sets the str unit list ws.
	 * 
	 * @param strUnitListWs the new str unit list ws
	 */
	public void setStrUnitListWs(WebRowSet strUnitListWs) {
		this.strUnitListWs = strUnitListWs;
	}

	/**
	 * Gets the str sub group id.
	 * 
	 * @return the str sub group id
	 */
	public String getStrSubGroupId() {
		return strSubGroupId;
	}

	/**
	 * Sets the str sub group id.
	 * 
	 * @param strSubGroupId the new str sub group id
	 */
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}

	/**
	 * Gets the str item list ws.
	 * 
	 * @return the str item list ws
	 */
	public WebRowSet getStrItemListWs() {
		return strItemListWs;
	}

	/**
	 * Sets the str item list ws.
	 * 
	 * @param strItemListWs the new str item list ws
	 */
	public void setStrItemListWs(WebRowSet strItemListWs) {
		this.strItemListWs = strItemListWs;
	}

	/**
	 * Gets the str brand item list ws.
	 * 
	 * @return the str brand item list ws
	 */
	public WebRowSet getStrBrandItemListWs() {
		return strBrandItemListWs;
	}

	/**
	 * Sets the str brand item list ws.
	 * 
	 * @param strBrandItemListWs the new str brand item list ws
	 */
	public void setStrBrandItemListWs(WebRowSet strBrandItemListWs) {
		this.strBrandItemListWs = strBrandItemListWs;
	}

	/**
	 * Gets the str sub group ws.
	 * 
	 * @return the str sub group ws
	 */
	public WebRowSet getStrSubGroupWs() {
		return strSubGroupWs;
	}

	/**
	 * Sets the str sub group ws.
	 * 
	 * @param strSubGroupWs the new str sub group ws
	 */
	public void setStrSubGroupWs(WebRowSet strSubGroupWs) {
		this.strSubGroupWs = strSubGroupWs;
	}

	/**
	 * Gets the str group id.
	 * 
	 * @return the str group id
	 */
	public String getStrGroupId() {
		return strGroupId;
	}

	/**
	 * Sets the str group id.
	 * 
	 * @param strGroupId the new str group id
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	/**
	 * Gets the str item param ws.
	 * 
	 * @return the str item param ws
	 */
	public WebRowSet getStrItemParamWs() {
		return strItemParamWs;
	}

	/**
	 * Sets the str item param ws.
	 * 
	 * @param strItemParamWs the new str item param ws
	 */
	public void setStrItemParamWs(WebRowSet strItemParamWs) {
		this.strItemParamWs = strItemParamWs;
	}

	/**
	 * Gets the str param check.
	 * 
	 * @return the str param check
	 */
	public String[] getStrParamCheck() {
		return strParamCheck;
	}

	/**
	 * Sets the str param check.
	 * 
	 * @param strParamCheck the new str param check
	 */
	public void setStrParamCheck(String[] strParamCheck) {
		this.strParamCheck = strParamCheck;
	}

	/**
	 * Gets the str param value.
	 * 
	 * @return the str param value
	 */
	public String[] getStrParamValue() {
		return strParamValue;
	}

	/**
	 * Sets the str param value.
	 * 
	 * @param strParamValue the new str param value
	 */
	public void setStrParamValue(String[] strParamValue) {
		this.strParamValue = strParamValue;
	}

	/* (non-Javadoc)
	 * @see hisglobal.utility.TransferObject#getStrMsgType()
	 */
	public String getStrMsgType() {
		return strMsgType;
	}

	/* (non-Javadoc)
	 * @see hisglobal.utility.TransferObject#setStrMsgType(java.lang.String)
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	/* (non-Javadoc)
	 * @see hisglobal.utility.TransferObject#getStrMsgString()
	 */
	public String getStrMsgString() {
		return strMsgString;
	}

	/* (non-Javadoc)
	 * @see hisglobal.utility.TransferObject#setStrMsgString(java.lang.String)
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	/**
	 * Gets the str util mode.
	 * 
	 * @return the str util mode
	 */
	public String getStrUtilMode() {
		return strUtilMode;
	}

	/**
	 * Sets the str util mode.
	 * 
	 * @param strUtilMode the new str util mode
	 */
	public void setStrUtilMode(String strUtilMode) {
		this.strUtilMode = strUtilMode;
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
	 * Gets the str item category no.
	 * 
	 * @return the str item category no
	 */
	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}

	/**
	 * Sets the str item category no.
	 * 
	 * @param strItemCategoryNo the new str item category no
	 */
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}

	/**
	 * Gets the str parent parameter id.
	 * 
	 * @return the str parent parameter id
	 */
	public String getStrParentParameterId() {
		return strParentParameterId;
	}

	/**
	 * Sets the str parent parameter id.
	 * 
	 * @param strParentParameterId the new str parent parameter id
	 */
	public void setStrParentParameterId(String strParentParameterId) {
		this.strParentParameterId = strParentParameterId;
	}

	/**
	 * Gets the str item param dtls ws.
	 * 
	 * @return the str item param dtls ws
	 */
	public WebRowSet getStrItemParamDtlsWs() {
		return strItemParamDtlsWs;
	}

	/**
	 * Sets the str item param dtls ws.
	 * 
	 * @param strItemParamDtlsWs the new str item param dtls ws
	 */
	public void setStrItemParamDtlsWs(WebRowSet strItemParamDtlsWs) {
		this.strItemParamDtlsWs = strItemParamDtlsWs;
	}

	/**
	 * Gets the str item id.
	 * 
	 * @return the str item id
	 */
	public String getStrItemId() {
		return strItemId;
	}

	/**
	 * Sets the str item id.
	 * 
	 * @param strItemId the new str item id
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}

	/**
	 * Gets the str param dtls.
	 * 
	 * @return the str param dtls
	 */
	public String[] getStrParamDtls() {
		return strParamDtls;
	}

	/**
	 * Sets the str param dtls.
	 * 
	 * @param strParamDtls the new str param dtls
	 */
	public void setStrParamDtls(String[] strParamDtls) {
		this.strParamDtls = strParamDtls;
	}

	/**
	 * Gets the str param status.
	 * 
	 * @return the str param status
	 */
	public String[] getStrParamStatus() {
		return strParamStatus;
	}

	/**
	 * Sets the str param status.
	 * 
	 * @param strParamStatus the new str param status
	 */
	public void setStrParamStatus(String[] strParamStatus) {
		this.strParamStatus = strParamStatus;
	}

	/**
	 * Gets the str from store id.
	 * 
	 * @return the str from store id
	 */
	public String getStrFromStoreId() {
		return strFromStoreId;
	}

	/**
	 * Sets the str from store id.
	 * 
	 * @param strFromStoreId the new str from store id
	 */
	public void setStrFromStoreId(String strFromStoreId) {
		this.strFromStoreId = strFromStoreId;
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
	 * Gets the str mode val.
	 * 
	 * @return the str mode val
	 */
	public String getStrModeVal() {
		return strModeVal;
	}

	/**
	 * Sets the str mode val.
	 * 
	 * @param strModeVal the new str mode val
	 */
	public void setStrModeVal(String strModeVal) {
		this.strModeVal = strModeVal;
	}

	/**
	 * Gets the str request type.
	 * 
	 * @return the str request type
	 */
	public String getStrRequestType() {
		return strRequestType;
	}

	/**
	 * Sets the str request type.
	 * 
	 * @param strRequestType the new str request type
	 */
	public void setStrRequestType(String strRequestType) {
		this.strRequestType = strRequestType;
	}

	/**
	 * Gets the str unit id.
	 * 
	 * @return the str unit id
	 */
	public String getStrUnitId() {
		return strUnitId;
	}

	/**
	 * Sets the str unit id.
	 * 
	 * @param strUnitId the new str unit id
	 */
	public void setStrUnitId(String strUnitId) {
		this.strUnitId = strUnitId;
	}

	/**
	 * Gets the str item mandatory dtls.
	 * 
	 * @return the str item mandatory dtls
	 */
	public String getStrItemMandatoryDtls() {
		return strItemMandatoryDtls;
	}

	/**
	 * Sets the str item mandatory dtls.
	 * 
	 * @param strItemMandatoryDtls the new str item mandatory dtls
	 */
	public void setStrItemMandatoryDtls(String strItemMandatoryDtls) {
		this.strItemMandatoryDtls = strItemMandatoryDtls;
	}

	/**
	 * Gets the str value1.
	 * 
	 * @return the str value1
	 */
	public String getStrValue1() {
		return strValue1;
	}

	/**
	 * Sets the str value1.
	 * 
	 * @param strValue1 the new str value1
	 */
	public void setStrValue1(String strValue1) {
		this.strValue1 = strValue1;
	}

	/**
	 * Gets the str value2.
	 * 
	 * @return the str value2
	 */
	public String getStrValue2() {
		return strValue2;
	}

	/**
	 * Sets the str value2.
	 * 
	 * @param strValue2 the new str value2
	 */
	public void setStrValue2(String strValue2) {
		this.strValue2 = strValue2;
	}

	/**
	 * Gets the str value3.
	 * 
	 * @return the str value3
	 */
	public String getStrValue3() {
		return strValue3;
	}

	/**
	 * Sets the str value3.
	 * 
	 * @param strValue3 the new str value3
	 */
	public void setStrValue3(String strValue3) {
		this.strValue3 = strValue3;
	}

	/**
	 * Gets the str value4.
	 * 
	 * @return the str value4
	 */
	public String getStrValue4() {
		return strValue4;
	}

	/**
	 * Sets the str value4.
	 * 
	 * @param strValue4 the new str value4
	 */
	public void setStrValue4(String strValue4) {
		this.strValue4 = strValue4;
	}

	/**
	 * Gets the str value5.
	 * 
	 * @return the str value5
	 */
	public String getStrValue5() {
		return strValue5;
	}

	/**
	 * Sets the str value5.
	 * 
	 * @param strValue5 the new str value5
	 */
	public void setStrValue5(String strValue5) {
		this.strValue5 = strValue5;
	}

	/**
	 * Gets the str value6.
	 * 
	 * @return the str value6
	 */
	public String getStrValue6() {
		return strValue6;
	}

	/**
	 * Sets the str value6.
	 * 
	 * @param strValue6 the new str value6
	 */
	public void setStrValue6(String strValue6) {
		this.strValue6 = strValue6;
	}

	/**
	 * Gets the str value7.
	 * 
	 * @return the str value7
	 */
	public String getStrValue7() {
		return strValue7;
	}

	/**
	 * Sets the str value7.
	 * 
	 * @param strValue7 the new str value7
	 */
	public void setStrValue7(String strValue7) {
		this.strValue7 = strValue7;
	}

	/**
	 * Gets the str value8.
	 * 
	 * @return the str value8
	 */
	public String getStrValue8() {
		return strValue8;
	}

	/**
	 * Sets the str value8.
	 * 
	 * @param strValue8 the new str value8
	 */
	public void setStrValue8(String strValue8) {
		this.strValue8 = strValue8;
	}

	/**
	 * Gets the gbl ws1.
	 * 
	 * @return the gbl ws1
	 */
	public WebRowSet getGblWs1() {
		return gblWs1;
	}

	/**
	 * Sets the gbl ws1.
	 * 
	 * @param gblWs1 the new gbl ws1
	 */
	public void setGblWs1(WebRowSet gblWs1) {
		this.gblWs1 = gblWs1;
	}

	/**
	 * Gets the gbl ws2.
	 * 
	 * @return the gbl ws2
	 */
	public WebRowSet getGblWs2() {
		return gblWs2;
	}

	/**
	 * Sets the gbl ws2.
	 * 
	 * @param gblWs2 the new gbl ws2
	 */
	public void setGblWs2(WebRowSet gblWs2) {
		this.gblWs2 = gblWs2;
	}

	/**
	 * Gets the gbl ws3.
	 * 
	 * @return the gbl ws3
	 */
	public WebRowSet getGblWs3() {
		return gblWs3;
	}

	/**
	 * Sets the gbl ws3.
	 * 
	 * @param gblWs3 the new gbl ws3
	 */
	public void setGblWs3(WebRowSet gblWs3) {
		this.gblWs3 = gblWs3;
	}

	/**
	 * Gets the str module id.
	 * 
	 * @return the str module id
	 */
	public String getStrModuleId() {
		return strModuleId;
	}

	/**
	 * Sets the str module id.
	 * 
	 * @param strModuleId the new str module id
	 */
	public void setStrModuleId(String strModuleId) {
		this.strModuleId = strModuleId;
	}

	/**
	 * Gets the ws manufacturer list.
	 * 
	 * @return the ws manufacturer list
	 */
	public WebRowSet getWsManufacturerList() {
		return wsManufacturerList;
	}

	/**
	 * Sets the ws manufacturer list.
	 * 
	 * @param wsManufacturerList the new ws manufacturer list
	 */
	public void setWsManufacturerList(WebRowSet wsManufacturerList) {
		this.wsManufacturerList = wsManufacturerList;
	}

	/**
	 * Gets the str user info.
	 * 
	 * @return the str user info
	 */
	public String getStrUserInfo() {
		return strUserInfo;
	}

	/**
	 * Sets the str user info.
	 * 
	 * @param strUserInfo the new str user info
	 */
	public void setStrUserInfo(String strUserInfo) {
		this.strUserInfo = strUserInfo;
	}

	public String getStrUnitName() {
		return strUnitName;
	}

	public void setStrUnitName(String strUnitName) {
		this.strUnitName = strUnitName;
	}

	public String getStrRateUnit() {
		return strRateUnit;
	}

	public void setStrRateUnit(String strRateUnit) {
		this.strRateUnit = strRateUnit;
	}

	public String getStrRateInBaseValue() {
		return strRateInBaseValue;
	}

	public void setStrRateInBaseValue(String strRateInBaseValue) {
		this.strRateInBaseValue = strRateInBaseValue;
	}


	public WebRowSet getStrItemTypeWs() {
		return strItemTypeWs;
	}

	public void setStrItemTypeWs(WebRowSet strItemTypeWs) {
		this.strItemTypeWs = strItemTypeWs;
	}

	public String getStrNewItemSpecification() {
		return strNewItemSpecification;
	}

	public void setStrNewItemSpecification(String strNewItemSpecification) {
		this.strNewItemSpecification = strNewItemSpecification;
	}

	public WebRowSet getWsItemTypeList() {
		return wsItemTypeList;
	}

	public void setWsItemTypeList(WebRowSet wsItemTypeList) {
		this.wsItemTypeList = wsItemTypeList;
	}

	/**
	 * @return the strNewItemFlag
	 */
	public String getStrNewItemFlag() {
		return strNewItemFlag;
	}

	/**
	 * @param strNewItemFlag the strNewItemFlag to set
	 */
	public void setStrNewItemFlag(String strNewItemFlag) {
		this.strNewItemFlag = strNewItemFlag;
	}

	/**
	 * @return the strSlNoflg
	 */
	public String getStrSlNoflg() {
		return strSlNoflg;
	}

	/**
	 * @param strSlNoflg the strSlNoflg to set
	 */
	public void setStrSlNoflg(String strSlNoflg) {
		this.strSlNoflg = strSlNoflg;
	}

	public String getStrUnitMode() {
		return strUnitMode;
	}

	public void setStrUnitMode(String strUnitMode) {
		this.strUnitMode = strUnitMode;
	}

	

}
