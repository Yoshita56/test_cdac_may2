package mms.global.controller;
 
// TODO: Auto-generated Javadoc
/**
 * The Class MmsFB.
 */
public class MmsFB_new {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	// Common Fields

	/** The str util mode. */
	private String strUtilMode = "0";
	
	/** The str hospital code. */
	private String strHospitalCode = "";

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

	/** The str item param view. */
	private String strItemParamView = "";

	// Search Item Util

	/** The str from store id. */
	private String strFromStoreId = "0";

	/** The str group id. */
	private String strGroupId = "0";
	
	/** The str mode val. */
	private String strModeVal = "0";
	
	/** The str item category id. */
	private String strItemCategoryId = "0";
	
	/** The str sub group id. */
	private String strSubGroupId = "0";
	
	/** The str request type. */
	private String strRequestType = "0";

	/** The str sub group values. */
	private String strSubGroupValues = "";

	/** The str user info. */
	private String strUserInfo = "";

	private String strUnitName = "";
	
	private String strRateUnit = "";
	
	private String strRateInBaseValue = "0";
	
	private String strIndentNo="0";
	private String strIndentDate="";
	
	private String strNewItemFlag = "";
	
	// unit combo

	/** The str unit id. */
	private String strUnitId = "0";

 
	/** The usr func name. */
	private String usrFuncName = "";
	
	/** The usr arg. */
	private String usrArg = "";

	/** The str result values. */
	private String strResultValues = "";

	// stock details util

	private String strUnitList = "";
	
	private String strManufacturerList = "";
	
	private String strItemTypeList = "";
	
	/** The str stock status. */
	private String strStockStatus = "";

	/** The str genric item id. */
	private String strGenricItemId = "";
	
	/** The str issue qty. */
	private String strIssueQty = "";
	
	/** The str issue qty in base. */
	private String strIssueQtyInBase = "";
	
	/** The str item name. */
	private String strItemName = "";
	
	/** The str store name. */
	private String strStoreName = "";
	
	/** The str reserved flag. */
	private String strReservedFlag = "0";
	
	private String strHiddenVal = "";
	private String strReturnReqNo;
	private String strFinalRemarks;
	private String strIndex;
	private String strBudget;
	private String strItemWiseCost;
	private String strRackNo;
	private String strLPRequestNo="0";
	private String strLocDL="";
	private String strBillNo="0";
	private String strCIMSData="";
	private String strPatCat="";
	private String strOrgName="";
	private String strWardName="";
	private String strRcvByName="";
	
	
	public String getStrBillNo() {
		return strBillNo;
	}

	public void setStrBillNo(String strBillNo) {
		this.strBillNo = strBillNo;
	}

	public String getStrLocDL() {
		return strLocDL;
	}

	public void setStrLocDL(String strLocDL) {
		this.strLocDL = strLocDL;
	}

	public String getStrLPRequestNo() {
		return strLPRequestNo;
	}

	public void setStrLPRequestNo(String strLPRequestNo) {
		this.strLPRequestNo = strLPRequestNo;
	}

	/**
	 * The type of other item.
	 * 1 -> for free item
	 * 2 -> for part item
	 * Added by Aritra on 08/07/2010
	 */
	private String strOtherItemMode = null;
	
	/**
	 * this method returns other item type.
	 * 1 -> for free item
	 * 2 -> for part item
	 * @return other item type
	 */
	public String getStrOtherItemMode() {
		return strOtherItemMode;
	}

	/**
	 * Sets other item type
	 * @param strOtherItemMode
	 */
	public void setStrOtherItemMode(String strOtherItemMode) {
		this.strOtherItemMode = strOtherItemMode;
	}

	public String getStrHiddenVal() {
		return strHiddenVal;
	}

	public void setStrHiddenVal(String strHiddenVal) {
		this.strHiddenVal = strHiddenVal;
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

	// issue details util

	/** The str issue no. */
	private String strIssueNo = "0";
	
	/** The str issue date. */
	private String strIssueDate = "0";
	
	/** The str issue to. */
	private String strIssueTo = "";
	
	// item Other Details

	/** The str batch sl no. */
	private String strBatchSlNo = "0";

	// item Other Details for Free Items

	/** The str item category list. */
	private String strItemCategoryList = "";
	
	/** The str group list. */
	private String strGroupList = "";
	
	/** The str sub group list. */
	private String strSubGroupList = "";
	
	/** The str gen item list. */
	private String strGenItemList = "";
	
	/** The str item list. */
	private String strItemList = "";

	/** The str is batch req. */
	private String strIsBatchReq = "0";
	
	/** The str is exp dt req. */
	private String strIsExpDtReq = "0";

	/** The str layer index. */
	private String strLayerIndex = "0";
	
	private String strComponentTypeList = "";
	
	
	
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
	
	// Use In Issue Item 
	private String strSlNoflg="0";
	
	private String strCrno="0";
	public String getStrCrno() {
		return strCrno;
	}

	public void setStrCrno(String strCrno) {
		this.strCrno = strCrno;
	}

	public String getStrUserName() {
		return strUserName;
	}

	public void setStrUserName(String strUserName) {
		this.strUserName = strUserName;
	}

	private String strUserName="0";
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

	public String getStrComponentTypeList() {
		return strComponentTypeList;
	}

	public void setStrComponentTypeList(String strComponentTypeList) {
		this.strComponentTypeList = strComponentTypeList;
	}

	/**
	 * Gets the str layer index.
	 * 
	 * @return the str layer index
	 */
	public String getStrLayerIndex() {
		return strLayerIndex;
	}

	/**
	 * Sets the str layer index.
	 * 
	 * @param strLayerIndex the new str layer index
	 */
	public void setStrLayerIndex(String strLayerIndex) {
		this.strLayerIndex = strLayerIndex;
	}

	/**
	 * Gets the str is batch req.
	 * 
	 * @return the str is batch req
	 */
	public String getStrIsBatchReq() {
		return strIsBatchReq;
	}

	/**
	 * Sets the str is batch req.
	 * 
	 * @param strIsBatchReq the new str is batch req
	 */
	public void setStrIsBatchReq(String strIsBatchReq) {
		this.strIsBatchReq = strIsBatchReq;
	}

	/**
	 * Gets the str is exp dt req.
	 * 
	 * @return the str is exp dt req
	 */
	public String getStrIsExpDtReq() {
		return strIsExpDtReq;
	}

	/**
	 * Sets the str is exp dt req.
	 * 
	 * @param strIsExpDtReq the new str is exp dt req
	 */
	public void setStrIsExpDtReq(String strIsExpDtReq) {
		this.strIsExpDtReq = strIsExpDtReq;
	}

	/**
	 * Gets the str item category list.
	 * 
	 * @return the str item category list
	 */
	public String getStrItemCategoryList() {
		return strItemCategoryList;
	}

	/**
	 * Sets the str item category list.
	 * 
	 * @param strItemCategoryList the new str item category list
	 */
	public void setStrItemCategoryList(String strItemCategoryList) {
		this.strItemCategoryList = strItemCategoryList;
	}

	/**
	 * Gets the str group list.
	 * 
	 * @return the str group list
	 */
	public String getStrGroupList() {
		return strGroupList;
	}

	/**
	 * Sets the str group list.
	 * 
	 * @param strGroupList the new str group list
	 */
	public void setStrGroupList(String strGroupList) {
		this.strGroupList = strGroupList;
	}

	/**
	 * Gets the str sub group list.
	 * 
	 * @return the str sub group list
	 */
	public String getStrSubGroupList() {
		return strSubGroupList;
	}

	/**
	 * Sets the str sub group list.
	 * 
	 * @param strSubGroupList the new str sub group list
	 */
	public void setStrSubGroupList(String strSubGroupList) {
		this.strSubGroupList = strSubGroupList;
	}

	/**
	 * Gets the str gen item list.
	 * 
	 * @return the str gen item list
	 */
	public String getStrGenItemList() {
		return strGenItemList;
	}

	/**
	 * Sets the str gen item list.
	 * 
	 * @param strGenItemList the new str gen item list
	 */
	public void setStrGenItemList(String strGenItemList) {
		this.strGenItemList = strGenItemList;
	}

	/**
	 * Gets the str item list.
	 * 
	 * @return the str item list
	 */
	public String getStrItemList() {
		return strItemList;
	}

	/**
	 * Sets the str item list.
	 * 
	 * @param strItemList the new str item list
	 */
	public void setStrItemList(String strItemList) {
		this.strItemList = strItemList;
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
	 * Gets the usr func name.
	 * 
	 * @return the usr func name
	 */
	public String getUsrFuncName() {
		return usrFuncName;
	}

	/**
	 * Sets the usr func name.
	 * 
	 * @param usrFuncName the new usr func name
	 */
	public void setUsrFuncName(String usrFuncName) {
		this.usrFuncName = usrFuncName;
	}

	/**
	 * Gets the usr arg.
	 * 
	 * @return the usr arg
	 */
	public String getUsrArg() {
		return usrArg;
	}

	/**
	 * Sets the usr arg.
	 * 
	 * @param usrArg the new usr arg
	 */
	public void setUsrArg(String usrArg) {
		this.usrArg = usrArg;
	}



	/**
	 * Gets the str result values.
	 * 
	 * @return the str result values
	 */
	public String getStrResultValues() {
		return strResultValues;
	}

	/**
	 * Sets the str result values.
	 * 
	 * @param strResultValues the new str result values
	 */
	public void setStrResultValues(String strResultValues) {
		this.strResultValues = strResultValues;
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
	 * Gets the str item category id.
	 * 
	 * @return the str item category id
	 */
	public String getStrItemCategoryId() {
		return strItemCategoryId;
	}

	/**
	 * Sets the str item category id.
	 * 
	 * @param strItemCategoryId the new str item category id
	 */
	public void setStrItemCategoryId(String strItemCategoryId) {
		this.strItemCategoryId = strItemCategoryId;
	}

	/**
	 * Gets the str sub group values.
	 * 
	 * @return the str sub group values
	 */
	public String getStrSubGroupValues() {
		return strSubGroupValues;
	}

	/**
	 * Sets the str sub group values.
	 * 
	 * @param strSubGroupValues the new str sub group values
	 */
	public void setStrSubGroupValues(String strSubGroupValues) {
		this.strSubGroupValues = strSubGroupValues;
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
	 * Gets the str item param view.
	 * 
	 * @return the str item param view
	 */
	public String getStrItemParamView() {
		return strItemParamView;
	}

	/**
	 * Sets the str item param view.
	 * 
	 * @param strItemParamView the new str item param view
	 */
	public void setStrItemParamView(String strItemParamView) {
		this.strItemParamView = strItemParamView;
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

	public String getStrUnitList() {
		return strUnitList;
	}

	public void setStrUnitList(String strUnitList) {
		this.strUnitList = strUnitList;
	}

	public String getStrManufacturerList() {
		return strManufacturerList;
	}

	public void setStrManufacturerList(String strManufacturerList) {
		this.strManufacturerList = strManufacturerList;
	}

	public String getStrItemTypeList() {
		return strItemTypeList;
	}

	public void setStrItemTypeList(String strItemTypeList) {
		this.strItemTypeList = strItemTypeList;
	}

	public String getStrNewItemSpecification() {
		return strNewItemSpecification;
	}

	public void setStrNewItemSpecification(String strNewItemSpecification) {
		this.strNewItemSpecification = strNewItemSpecification;
	}

	/**
	 * @return the strIndentNo
	 */
	public String getStrIndentNo() {
		return strIndentNo;
	}

	/**
	 * @param strIndentNo the strIndentNo to set
	 */
	public void setStrIndentNo(String strIndentNo) {
		this.strIndentNo = strIndentNo;
	}

	/**
	 * @return the strIndentDate
	 */
	public String getStrIndentDate() {
		return strIndentDate;
	}

	/**
	 * @param strIndentDate the strIndentDate to set
	 */
	public void setStrIndentDate(String strIndentDate) {
		this.strIndentDate = strIndentDate;
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

	public String getStrFinalRemarks() {
		return strFinalRemarks;
	}

	public void setStrFinalRemarks(String strFinalRemarks) {
		this.strFinalRemarks = strFinalRemarks;
	}

	public String getStrIndex() {
		return strIndex;
	}

	public void setStrIndex(String strIndex) {
		this.strIndex = strIndex;
	}

	public String getStrBudget() {
		return strBudget;
	}

	public void setStrBudget(String strBudget) {
		this.strBudget = strBudget;
	}

	public String getStrItemWiseCost() {
		return strItemWiseCost;
	}

	public void setStrItemWiseCost(String strItemWiseCost) {
		this.strItemWiseCost = strItemWiseCost;
	}

	public String getStrRackNo() {
		return strRackNo;
	}

	public void setStrRackNo(String strRackNo) {
		this.strRackNo = strRackNo;
	}

	public String getStrCIMSData() {
		return strCIMSData;
	}

	public void setStrCIMSData(String strCIMSData) {
		this.strCIMSData = strCIMSData;
	}

	public String getStrPatCat() {
		return strPatCat;
	}

	public void setStrPatCat(String strPatCat) {
		this.strPatCat = strPatCat;
	}

	public String getStrOrgName() {
		return strOrgName;
	}

	public void setStrOrgName(String strOrgName) {
		this.strOrgName = strOrgName;
	}

	public String getStrWardName() {
		return strWardName;
	}

	public void setStrWardName(String strWardName) {
		this.strWardName = strWardName;
	}

	public String getStrRcvByName() {
		return strRcvByName;
	}

	public void setStrRcvByName(String strRcvByName) {
		this.strRcvByName = strRcvByName;
	}

}
