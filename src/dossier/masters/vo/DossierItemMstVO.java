package dossier.masters.vo;

import hisglobal.utility.TransferObject;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * The Class DossierItemMstVO.
 */
public class DossierItemMstVO implements TransferObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The B exist status. */
	private Boolean BExistStatus = false;
	
	/** The str msg string. */
	private String strMsgString = "";
	
	/** The str msg type. */
	private String strMsgType = "";

	/** The str module id. */
	private String strModuleId = "";

	/** The str inventory unit id. */
	private String strInventoryUnitId = "";
	
	private String strToleranceLimit = "";

	////////////////////////////////////////////////////////////////////////////////////
	private String strRemarksText[]=null;
	private String strRemarksText1[]=null;
	
	public String[] getStrRemarksText() {
		return strRemarksText;
	}

	public void setStrRemarksText(String[] strRemarksText) {
		this.strRemarksText = strRemarksText;
	}

	public String[] getStrRemarksText1() {
		return strRemarksText1;
	}

	public void setStrRemarksText1(String[] strRemarksText1) {
		this.strRemarksText1 = strRemarksText1;
	}

	private String strIsReturnableArr[] = null;
	private String strIsReturnableArr1[] = null;
	private String strIsRC[] =null;
	private String strIsRC1[] = null;
	
	public String[] getStrIsReturnableArr() {
		return strIsReturnableArr;
	}

	public void setStrIsReturnableArr(String[] strIsReturnableArr) {
		this.strIsReturnableArr = strIsReturnableArr;
	}

	public String[] getStrIsReturnableArr1() {
		return strIsReturnableArr1;
	}

	public void setStrIsReturnableArr1(String[] strIsReturnableArr1) {
		this.strIsReturnableArr1 = strIsReturnableArr1;
	}

	public String[] getStrIsRC() {
		return strIsRC;
	}

	public void setStrIsRC(String[] strIsRC) {
		this.strIsRC = strIsRC;
	}

	public String[] getStrIsRC1() {
		return strIsRC1;
	}

	public void setStrIsRC1(String[] strIsRC1) {
		this.strIsRC1 = strIsRC1;
	}

	private String strIsMisc1[]=null;
	
	public String[] getStrIsMisc1() {
		return strIsMisc1;
	}

	public void setStrIsMisc1(String[] strIsMisc1) {
		this.strIsMisc1 = strIsMisc1;
	}

	private String strIsMisc[]=null;
	
	public String[] getStrIsMisc() {
		return strIsMisc;
	}

	public void setStrIsMisc(String[] strIsMisc) {
		this.strIsMisc = strIsMisc;
	}

	private String strDossierOldTotalCost="";
	
	public String getStrDossierOldTotalCost() {
		return strDossierOldTotalCost;
	}

	public void setStrDossierOldTotalCost(String strDossierOldTotalCost) {
		this.strDossierOldTotalCost = strDossierOldTotalCost;
	}

	private String strDossierTotalCost="";
	
	public String getStrDossierTotalCost() {
		return strDossierTotalCost;
	}

	public void setStrDossierTotalCost(String strDossierTotalCost) {
		this.strDossierTotalCost = strDossierTotalCost;
	}
	
	private String strNewStoreId = "";
	
	private String strNewStoreName="";
	
	public String getStrNewStoreName() {
		return strNewStoreName;
	}

	public void setStrNewStoreName(String strNewStoreName) {
		this.strNewStoreName = strNewStoreName;
	}	
	public String getStrNewStoreId() {
		return strNewStoreId;
	}

	public void setStrNewStoreId(String strNewStoreId) {
		this.strNewStoreId = strNewStoreId;
	}
	
	private String strItemBrandIdArray[]=null;
	
	private String strItemTypeIdArray[]=null;
	
	private String strItemIdArray[]=null;
	
	public String[] getStrItemBrandIdArray() {
		return strItemBrandIdArray;
	}

	public void setStrItemBrandIdArray(String[] strItemBrandIdArray) {
		this.strItemBrandIdArray = strItemBrandIdArray;
	}

	public String[] getStrItemTypeIdArray() {
		return strItemTypeIdArray;
	}
	
	public String[] getStrItemIdArray() {
		return strItemIdArray;
	}

	public void setStrItemIdArray(String[] strItemIdArray) {
		this.strItemIdArray = strItemIdArray;
	}

	public void setStrItemTypeIdArray(String[] strItemTypeIdArray) {
		this.strItemTypeIdArray = strItemTypeIdArray;
	}

	private String strDefRateText1[]=null;
	
	private String isBroughtByPatient1[]=null;
	
	private String strQtyText1[]=null;

	public String[] getStrDefRateText1() {
		return strDefRateText1;
	}

	public void setStrDefRateText1(String[] strDefRateText1) {
		this.strDefRateText1 = strDefRateText1;
	}

	public String[] getIsBroughtByPatient1() {
		return isBroughtByPatient1;
	}

	public void setIsBroughtByPatient1(String[] isBroughtByPatient1) {
		this.isBroughtByPatient1 = isBroughtByPatient1;
	}

	public String[] getStrQtyText1() {
		return strQtyText1;
	}

	public void setStrQtyText1(String[] strQtyText1) {
		this.strQtyText1 = strQtyText1;
	}

	private String strItemTypeId = "";
	
	public String getStrItemTypeId() {
		return strItemTypeId;
	}

	public void setStrItemTypeId(String strItemTypeId) {
		this.strItemTypeId = strItemTypeId;
	}

	private WebRowSet itemDetailWS=null;
	
	public WebRowSet getItemDetailWS() {
		return itemDetailWS;
	}

	public void setItemDetailWS(WebRowSet itemDetailWS) {
		this.itemDetailWS = itemDetailWS;
	}

	private String[] itemParamValue =null;
	public String[] getItemParamValue() {
		return itemParamValue;
	}

	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
	}
	
	private String strItemDefaultRate[] = null;
	
	public String[] getStrItemDefaultRate() {
		return strItemDefaultRate;
	}

	public void setStrItemDefaultRate(String[] strItemDefaultRate) {
		this.strItemDefaultRate = strItemDefaultRate;
	}

	private String isBroughtByPatient[]=null;
	
	public String[] getIsBroughtByPatient() {
		return isBroughtByPatient;
	}


	public void setIsBroughtByPatient(String[] isBroughtByPatient) {
		this.isBroughtByPatient = isBroughtByPatient;
	}

	private String strTotalCostText[] = null;
	
	public String[] getStrTotalCostText() {
		return strTotalCostText;
	}

	public void setStrTotalCostText(String[] strTotalCostText) {
		this.strTotalCostText = strTotalCostText;
	}

	private String strQtyText[]=null;
	public String[] getStrQtyText() {
		return strQtyText;
	}

	public void setStrQtyText(String[] strQtyText) {
		this.strQtyText = strQtyText;
	}

	private String strDefRateText[]=null;
	
	public String[] getStrDefRateText() {
		return strDefRateText;
	}

	public void setStrDefRateText(String[] strDefRateText) {
		this.strDefRateText = strDefRateText;
	}
	
	private WebRowSet strStoreNameWS;
	
	public WebRowSet getStrStoreNameWS() {
		return strStoreNameWS;
	}

	public void setStrStoreNameWS(WebRowSet strStoreNameWS) {
		this.strStoreNameWS = strStoreNameWS;
	}

	private String strItemCatValues = "";
	private String stritemcat = "";
	
	private WebRowSet strItemCatWs;
	
	public WebRowSet getStrItemCatWs() {
		return strItemCatWs;
	}

	public void setStrItemCatWs(WebRowSet strItemCatWs) {
		this.strItemCatWs = strItemCatWs;
	}

	public String getStrItemCatValues() {
		return strItemCatValues;
	}

	public void setStrItemCatValues(String strItemCatValues) {
		this.strItemCatValues = strItemCatValues;
	}

	public String getStritemcat() {
		return stritemcat;
	}

	public void setStritemcat(String stritemcat) {
		this.stritemcat = stritemcat;
	}

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	private String strDossierId="";
	private String strDossierName="";
	
	private String strServiceTypeId ="";
	private String strServiceTypeName ="";
	private String strDeptCode ="";
	private String strDeptName ="";
	
	
	public String getStrServiceTypeId() {
		return strServiceTypeId;
	}


	public void setStrServiceTypeId(String strServiceTypeId) {
		this.strServiceTypeId = strServiceTypeId;
	}


	public String getStrServiceTypeName() {
		return strServiceTypeName;
	}


	public void setStrServiceTypeName(String strServiceTypeName) {
		this.strServiceTypeName = strServiceTypeName;
	}


	public String getStrDeptCode() {
		return strDeptCode;
	}


	public void setStrDeptCode(String strDeptCode) {
		this.strDeptCode = strDeptCode;
	}


	public String getStrDeptName() {
		return strDeptName;
	}


	public void setStrDeptName(String strDeptName) {
		this.strDeptName = strDeptName;
	}

	
	public WebRowSet getStrRigthCmbWs() {
		return strRigthCmbWs;
	}

	public void setStrRigthCmbWs(WebRowSet strRigthCmbWs) {
		this.strRigthCmbWs = strRigthCmbWs;
	}

	public String getStrDossierId() {
		return strDossierId;
	}

	public void setStrDossierId(String strDossierId) {
		this.strDossierId = strDossierId;
	}

	public String getStrDossierName() {
		return strDossierName;
	}

	public void setStrDossierName(String strDossierName) {
		this.strDossierName = strDossierName;
	}

	/** The str store id. */
	private String strStoreId = "";

	/** The str store name. */
	private String strStoreName = "";

	/** The str entry date. */
	private String strEntryDate = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str is valid. */
	private String strIsValid = "";
	
	/** The str item name combo. */
	private String strItemNameCombo = "";
	
	/** The str item name combo ws. */
	private WebRowSet strItemNameComboWs = null;
	
	/** The str item id. */
	private String strItemId = "";
	
	/** The str item brand id. */
	private String strItemBrandId = "";
	
	/** The str item brand name. */
	private String strItemBrandName = "";

	private String strInchargeCmb="";
	/** The str incharge cmb ws. */
	private WebRowSet strInchargeCmbWs = null;
	
	private WebRowSet strRigthCmbWs = null;
	
	/** The str right request types. */
	private String strRightRequestTypes[] = null;
	
	/** The str left request type list. */
	private String strLeftRequestTypeList = "";
	
	/** The str right request type list. */
	private String strRightRequestTypeList = "";

	/** The str left request types list ws. */
	private WebRowSet strLeftRequestTypesListWs = null;

	/** The str right request type list ws. */
	private WebRowSet strRightRequestTypeListWs = null;
	
	public String getStrLeftRequestTypeList() {
		return strLeftRequestTypeList;
	}

	public void setStrLeftRequestTypeList(String strLeftRequestTypeList) {
		this.strLeftRequestTypeList = strLeftRequestTypeList;
	}

	public String getStrRightRequestTypeList() {
		return strRightRequestTypeList;
	}

	public void setStrRightRequestTypeList(String strRightRequestTypeList) {
		this.strRightRequestTypeList = strRightRequestTypeList;
	}

	public WebRowSet getStrLeftRequestTypesListWs() {
		return strLeftRequestTypesListWs;
	}

	public void setStrLeftRequestTypesListWs(WebRowSet strLeftRequestTypesListWs) {
		this.strLeftRequestTypesListWs = strLeftRequestTypesListWs;
	}

	public WebRowSet getStrRightRequestTypeListWs() {
		return strRightRequestTypeListWs;
	}

	public void setStrRightRequestTypeListWs(WebRowSet strRightRequestTypeListWs) {
		this.strRightRequestTypeListWs = strRightRequestTypeListWs;
	}

	public String[] getStrRightRequestTypes() {
		return strRightRequestTypes;
	}

	public void setStrRightRequestTypes(String[] strRightRequestTypes) {
		this.strRightRequestTypes = strRightRequestTypes;
	}
	
	/**
	 * Gets the str hospital code.
	 * 
	 * @return the strHospitalCode
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	/**
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Gets the str store id.
	 * 
	 * @return the strStoreId
	 */
	public String getStrStoreId() {
		return strStoreId;
	}

	/**
	 * Sets the str store id.
	 * 
	 * @param strStoreId the strStoreId to set
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	/**
	 * Gets the str item id.
	 * 
	 * @return the strItemId
	 */
	public String getStrItemId() {
		return strItemId;
	}

	/**
	 * Sets the str item id.
	 * 
	 * @param strItemId the strItemId to set
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}

	/**
	 * Gets the str item brand id.
	 * 
	 * @return the strItemBrandId
	 */
	public String getStrItemBrandId() {
		return strItemBrandId;
	}

	/**
	 * Sets the str item brand id.
	 * 
	 * @param strItemBrandId the strItemBrandId to set
	 */
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}


	/**
	 * Gets the str item name combo.
	 * 
	 * @return the strItemNameCombo
	 */
	public String getStrItemNameCombo() {
		return strItemNameCombo;
	}

	/**
	 * Sets the str item name combo.
	 * 
	 * @param strItemNameCombo the strItemNameCombo to set
	 */
	public void setStrItemNameCombo(String strItemNameCombo) {
		this.strItemNameCombo = strItemNameCombo;
	}

	/**
	 * Gets the str item name combo ws.
	 * 
	 * @return the strItemNameComboWs
	 */
	public WebRowSet getStrItemNameComboWs() {
		return strItemNameComboWs;
	}

	/**
	 * Sets the str item name combo ws.
	 * 
	 * @param strItemNameComboWs the strItemNameComboWs to set
	 */
	public void setStrItemNameComboWs(WebRowSet strItemNameComboWs) {
		this.strItemNameComboWs = strItemNameComboWs;
	}

	/**
	 * Gets the str store name.
	 * 
	 * @return the strStoreName
	 */
	public String getStrStoreName() {
		return strStoreName;
	}

	/**
	 * Sets the str store name.
	 * 
	 * @param strStoreName the strStoreName to set
	 */
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}

	/**
	 * Gets the str item brand name.
	 * 
	 * @return the strItemBrandName
	 */
	public String getStrItemBrandName() {
		return strItemBrandName;
	}

	/**
	 * Sets the str item brand name.
	 * 
	 * @param strItemBrandName the strItemBrandName to set
	 */
	public void setStrItemBrandName(String strItemBrandName) {
		this.strItemBrandName = strItemBrandName;
	}

	/**
	 * Gets the str item name.
	 * 
	 * @return the strItemName
	 */
	public String getStrItemName() {
		return strItemName;
	}

	/**
	 * Sets the str item name.
	 * 
	 * @param strItemName the strItemName to set
	 */
	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}

	/**
	 * Gets the str entry date.
	 * 
	 * @return the strEntryDate
	 */
	public String getStrEntryDate() {
		return strEntryDate;
	}

	/**
	 * Sets the str entry date.
	 * 
	 * @param strEntryDate the strEntryDate to set
	 */
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}

	/**
	 * Gets the str seat id.
	 * 
	 * @return the strSeatId
	 */
	public String getStrSeatId() {
		return strSeatId;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param strSeatId the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * Gets the str is valid.
	 * 
	 * @return the strIsValid
	 */
	public String getStrIsValid() {
		return strIsValid;
	}

	/**
	 * Sets the str is valid.
	 * 
	 * @param strIsValid the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	/**
	 * Gets the str incharge cmb.
	 * 
	 * @return the strInchargeCmb
	 */
	public String getStrInchargeCmb() {
		return strInchargeCmb;
	}

	/**
	 * Sets the str incharge cmb.
	 * 
	 * @param strInchargeCmb the strInchargeCmb to set
	 */
	public void setStrInchargeCmb(String strInchargeCmb) {
		this.strInchargeCmb = strInchargeCmb;
	}

	/**
	 * Gets the str incharge cmb ws.
	 * 
	 * @return the strInchargeCmbWs
	 */
	public WebRowSet getStrInchargeCmbWs() {
		return strInchargeCmbWs;
	}

	/**
	 * Sets the str incharge cmb ws.
	 * 
	 * @param strInchargeCmbWs the strInchargeCmbWs to set
	 */
	public void setStrInchargeCmbWs(WebRowSet strInchargeCmbWs) {
		this.strInchargeCmbWs = strInchargeCmbWs;
	}




	////////////////////////////////////////////////////////////////////////////////////
	/** The str item sl no. */
	private String strItemSlNo = "";
	
	/** The str item short name. */
	private String strItemShortName = "";
	
	/** The str ved category. */
	private String strVEDCategory = "";
	
	/** The str fore cast. */
	private String strForeCast = "";
	
	/** The str reserved qty. */
	private String strReservedQty = "";
	
	/** The str max qty. */
	private String strMaxQty = "";
	
	/** The str min qty. */
	private String strMinQty = "";
	
	/** The str reorder qty. */
	private String strReorderQty = "";
	
	/** The str level unit id. */
	private String strLevelUnitId = "";
	
	private String strLevelUnitName = "";
	
	/** The str last indent qty. */
	private String strLastIndentQty = "";
	
	/** The str last indent unit id. */
	private String strLastIndentUnitId = "";
	
	/** The str last issue qty. */
	private String strLastIssueQty = "";
	
	/** The str last issue unit id. */
	private String strLastIssueUnitId = "";
	
	/** The str last receive qty. */
	private String strLastReceiveQty = "";
	
	/** The str last receive unit id. */
	private String strLastReceiveUnitId = "";
	
	/** The str issueable flag. */
	private String strIssueableFlag = "";
	
	/** The str is returnable. */
	private String strIsReturnable = "";

	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str last mode seat id. */
	private String strLastModeSeatId = "";
	
	/** The str last mode date. */
	private String strLastModeDate = "";
	
	/** The str level unit combo. */
	private String strLevelUnitCombo = "";
	
	/** The str level unit combo ws. */
	private WebRowSet strLevelUnitComboWs = null;
	
	/** The str item brand combo. */
	private String strItemBrandCombo = "";
	
	/** The str item brand combo ws. */
	private WebRowSet strItemBrandComboWs = null;

	/** The str category no. */
	private String strCategoryNo = "";
	
	/** The str store type id. */
	private String strStoreTypeId = "";
	
	/** The str store combo. */
	private String strStoreCombo = "";
	
	/** The str store combo ws. */
	private WebRowSet strStoreComboWs = null;

	/** The str from store id. */
	private String strFromStoreId = "";

	/** The str item name. */
	private String strItemName = "";

	/** The str group id. */
	private String strGroupId = "";
	
	/** The str group name combo. */
	private String strGroupNameCombo = "";
	
	/** The str group combo ws. */
	private WebRowSet strGroupComboWs = null;

	/** The str group name. */
	private String strGroupName = "";
	
	/** The str sub group name. */
	private String strSubGroupName = "";

	/** The str sub group id. */
	private String strSubGroupId = "";
	
	/** The str sub group name combo. */
	private String strSubGroupNameCombo = "";
	
	private String strMaxLevelUnitId="";
	private String strMaxIndentQty;
	
	/** The str sub group combo ws. */
	private WebRowSet strSubGroupComboWs = null;
	/**
	 * Gets the str store type id.
	 * 
	 * @return the strStoreTypeId
	 */
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}

	/**
	 * Sets the str store type id.
	 * 
	 * @param strStoreTypeId the strStoreTypeId to set
	 */
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}

	/**
	 * Gets the str store combo.
	 * 
	 * @return the strStoreCombo
	 */
	public String getStrStoreCombo() {
		return strStoreCombo;
	}

	/**
	 * Sets the str store combo.
	 * 
	 * @param strStoreCombo the strStoreCombo to set
	 */
	public void setStrStoreCombo(String strStoreCombo) {
		this.strStoreCombo = strStoreCombo;
	}

	/**
	 * Gets the str store combo ws.
	 * 
	 * @return the strStoreComboWs
	 */
	public WebRowSet getStrStoreComboWs() {
		return strStoreComboWs;
	}

	/**
	 * Sets the str store combo ws.
	 * 
	 * @param strStoreComboWs the strStoreComboWs to set
	 */
	public void setStrStoreComboWs(WebRowSet strStoreComboWs) {
		this.strStoreComboWs = strStoreComboWs;
	}

	/**
	 * Gets the str item brand combo.
	 * 
	 * @return the strItemBrandCombo
	 */
	public String getStrItemBrandCombo() {
		return strItemBrandCombo;
	}

	/**
	 * Sets the str item brand combo.
	 * 
	 * @param strItemBrandCombo the strItemBrandCombo to set
	 */
	public void setStrItemBrandCombo(String strItemBrandCombo) {
		this.strItemBrandCombo = strItemBrandCombo;
	}

	/**
	 * Gets the str item brand combo ws.
	 * 
	 * @return the strItemBrandComboWs
	 */
	public WebRowSet getStrItemBrandComboWs() {
		return strItemBrandComboWs;
	}

	/**
	 * Sets the str item brand combo ws.
	 * 
	 * @param strItemBrandComboWs the strItemBrandComboWs to set
	 */
	public void setStrItemBrandComboWs(WebRowSet strItemBrandComboWs) {
		this.strItemBrandComboWs = strItemBrandComboWs;
	}

	/**
	 * Gets the str level unit combo.
	 * 
	 * @return the strLevelUnitCombo
	 */
	public String getStrLevelUnitCombo() {
		return strLevelUnitCombo;
	}

	/**
	 * Sets the str level unit combo.
	 * 
	 * @param strLevelUnitCombo the strLevelUnitCombo to set
	 */
	public void setStrLevelUnitCombo(String strLevelUnitCombo) {
		this.strLevelUnitCombo = strLevelUnitCombo;
	}

	/**
	 * Gets the str level unit combo ws.
	 * 
	 * @return the strLevelUnitComboWs
	 */
	public WebRowSet getStrLevelUnitComboWs() {
		return strLevelUnitComboWs;
	}

	/**
	 * Sets the str level unit combo ws.
	 * 
	 * @param strLevelUnitComboWs the strLevelUnitComboWs to set
	 */
	public void setStrLevelUnitComboWs(WebRowSet strLevelUnitComboWs) {
		this.strLevelUnitComboWs = strLevelUnitComboWs;
	}
	/**
	 * Gets the b exist status.
	 * 
	 * @return the bExistStatus
	 */
	public Boolean getBExistStatus() {
		return BExistStatus;
	}

	/**
	 * Sets the b exist status.
	 * 
	 * @param existStatus the bExistStatus to set
	 */
	public void setBExistStatus(Boolean existStatus) {
		BExistStatus = existStatus;
	}

	/**
	 * Gets the str msg string.
	 * 
	 * @return the strMsgString
	 */
	public String getStrMsgString() {
		return strMsgString;
	}

	/**
	 * Sets the str msg string.
	 * 
	 * @param strMsgString the strMsgString to set
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	/**
	 * Gets the str msg type.
	 * 
	 * @return the strMsgType
	 */
	public String getStrMsgType() {
		return strMsgType;
	}

	/**
	 * Sets the str msg type.
	 * 
	 * @param strMsgType the strMsgType to set
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

		/**
	 * Gets the str item sl no.
	 * 
	 * @return the strItemSlNo
	 */
	public String getStrItemSlNo() {
		return strItemSlNo;
	}

	/**
	 * Sets the str item sl no.
	 * 
	 * @param strItemSlNo the strItemSlNo to set
	 */
	public void setStrItemSlNo(String strItemSlNo) {
		this.strItemSlNo = strItemSlNo;
	}
	
	public String getStrFromStoreId() {
		return strFromStoreId;
	}

	public void setStrFromStoreId(String strFromStoreId) {
		this.strFromStoreId = strFromStoreId;
	}

	/**
	 * Gets the str item short name.
	 * 
	 * @return the strItemShortName
	 */
	public String getStrItemShortName() {
		return strItemShortName;
	}

	/**
	 * Sets the str item short name.
	 * 
	 * @param strItemShortName the strItemShortName to set
	 */
	public void setStrItemShortName(String strItemShortName) {
		this.strItemShortName = strItemShortName;
	}

	/**
	 * Gets the str ved category.
	 * 
	 * @return the strVEDCategory
	 */
	public String getStrVEDCategory() {
		return strVEDCategory;
	}

	/**
	 * Sets the str ved category.
	 * 
	 * @param strVEDCategory the strVEDCategory to set
	 */
	public void setStrVEDCategory(String strVEDCategory) {
		this.strVEDCategory = strVEDCategory;
	}

	/**
	 * Gets the str fore cast.
	 * 
	 * @return the strForeCast
	 */
	public String getStrForeCast() {
		return strForeCast;
	}

	/**
	 * Sets the str fore cast.
	 * 
	 * @param strForeCast the strForeCast to set
	 */
	public void setStrForeCast(String strForeCast) {
		this.strForeCast = strForeCast;
	}

	/**
	 * Gets the str max qty.
	 * 
	 * @return the strMaxQty
	 */
	public String getStrMaxQty() {
		return strMaxQty;
	}

	/**
	 * Sets the str max qty.
	 * 
	 * @param strMaxQty the strMaxQty to set
	 */
	public void setStrMaxQty(String strMaxQty) {
		this.strMaxQty = strMaxQty;
	}

	/**
	 * Gets the str min qty.
	 * 
	 * @return the strMinQty
	 */
	public String getStrMinQty() {
		return strMinQty;
	}

	/**
	 * Sets the str min qty.
	 * 
	 * @param strMinQty the strMinQty to set
	 */
	public void setStrMinQty(String strMinQty) {
		this.strMinQty = strMinQty;
	}

	/**
	 * Gets the str reorder qty.
	 * 
	 * @return the strReorderQty
	 */
	public String getStrReorderQty() {
		return strReorderQty;
	}

	/**
	 * Sets the str reorder qty.
	 * 
	 * @param strReorderQty the strReorderQty to set
	 */
	public void setStrReorderQty(String strReorderQty) {
		this.strReorderQty = strReorderQty;
	}

	/**
	 * Gets the str level unit id.
	 * 
	 * @return the strLevelUnitId
	 */
	public String getStrLevelUnitId() {
		return strLevelUnitId;
	}

	/**
	 * Sets the str level unit id.
	 * 
	 * @param strLevelUnitId the strLevelUnitId to set
	 */
	public void setStrLevelUnitId(String strLevelUnitId) {
		this.strLevelUnitId = strLevelUnitId;
	}

	/**
	 * Gets the str last indent qty.
	 * 
	 * @return the strLastIndentQty
	 */
	public String getStrLastIndentQty() {
		return strLastIndentQty;
	}

	/**
	 * Sets the str last indent qty.
	 * 
	 * @param strLastIndentQty the strLastIndentQty to set
	 */
	public void setStrLastIndentQty(String strLastIndentQty) {
		this.strLastIndentQty = strLastIndentQty;
	}

	/**
	 * Gets the str last indent unit id.
	 * 
	 * @return the strLastIndentUnitId
	 */
	public String getStrLastIndentUnitId() {
		return strLastIndentUnitId;
	}

	/**
	 * Sets the str last indent unit id.
	 * 
	 * @param strLastIndentUnitId the strLastIndentUnitId to set
	 */
	public void setStrLastIndentUnitId(String strLastIndentUnitId) {
		this.strLastIndentUnitId = strLastIndentUnitId;
	}

	/**
	 * Gets the str last issue qty.
	 * 
	 * @return the strLastIssueQty
	 */
	public String getStrLastIssueQty() {
		return strLastIssueQty;
	}

	/**
	 * Sets the str last issue qty.
	 * 
	 * @param strLastIssueQty the strLastIssueQty to set
	 */
	public void setStrLastIssueQty(String strLastIssueQty) {
		this.strLastIssueQty = strLastIssueQty;
	}

	/**
	 * Gets the str last issue unit id.
	 * 
	 * @return the strLastIssueUnitId
	 */
	public String getStrLastIssueUnitId() {
		return strLastIssueUnitId;
	}

	/**
	 * Sets the str last issue unit id.
	 * 
	 * @param strLastIssueUnitId the strLastIssueUnitId to set
	 */
	public void setStrLastIssueUnitId(String strLastIssueUnitId) {
		this.strLastIssueUnitId = strLastIssueUnitId;
	}

	/**
	 * Gets the str last receive qty.
	 * 
	 * @return the strLastReceiveQty
	 */
	public String getStrLastReceiveQty() {
		return strLastReceiveQty;
	}

	/**
	 * Sets the str last receive qty.
	 * 
	 * @param strLastReceiveQty the strLastReceiveQty to set
	 */
	public void setStrLastReceiveQty(String strLastReceiveQty) {
		this.strLastReceiveQty = strLastReceiveQty;
	}

	/**
	 * Gets the str last receive unit id.
	 * 
	 * @return the strLastReceiveUnitId
	 */
	public String getStrLastReceiveUnitId() {
		return strLastReceiveUnitId;
	}

	/**
	 * Sets the str last receive unit id.
	 * 
	 * @param strLastReceiveUnitId the strLastReceiveUnitId to set
	 */
	public void setStrLastReceiveUnitId(String strLastReceiveUnitId) {
		this.strLastReceiveUnitId = strLastReceiveUnitId;
	}

	/**
	 * Gets the str issueable flag.
	 * 
	 * @return the strIssueableFlag
	 */
	public String getStrIssueableFlag() {
		return strIssueableFlag;
	}

	/**
	 * Sets the str issueable flag.
	 * 
	 * @param strIssueableFlag the strIssueableFlag to set
	 */
	public void setStrIssueableFlag(String strIssueableFlag) {
		this.strIssueableFlag = strIssueableFlag;
	}

	/**
	 * Gets the str is returnable.
	 * 
	 * @return the strIsReturnable
	 */
	public String getStrIsReturnable() {
		return strIsReturnable;
	}

	/**
	 * Sets the str is returnable.
	 * 
	 * @param strIsReturnable the strIsReturnable to set
	 */
	public void setStrIsReturnable(String strIsReturnable) {
		this.strIsReturnable = strIsReturnable;
	}

	/**
	 * Gets the str remarks.
	 * 
	 * @return the strRemarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * Gets the str effective from.
	 * 
	 * @return the strEffectiveFrom
	 */
	public String getStrEffectiveFrom() {
		return strEffectiveFrom;
	}

	/**
	 * Sets the str effective from.
	 * 
	 * @param strEffectiveFrom the strEffectiveFrom to set
	 */
	public void setStrEffectiveFrom(String strEffectiveFrom) {
		this.strEffectiveFrom = strEffectiveFrom;
	}

	/**
	 * Gets the str last mode seat id.
	 * 
	 * @return the strLastModeSeatId
	 */
	public String getStrLastModeSeatId() {
		return strLastModeSeatId;
	}

	/**
	 * Sets the str last mode seat id.
	 * 
	 * @param strLastModeSeatId the strLastModeSeatId to set
	 */
	public void setStrLastModeSeatId(String strLastModeSeatId) {
		this.strLastModeSeatId = strLastModeSeatId;
	}

	/**
	 * Gets the str last mode date.
	 * 
	 * @return the strLastModeDate
	 */
	public String getStrLastModeDate() {
		return strLastModeDate;
	}

	/**
	 * Sets the str last mode date.
	 * 
	 * @param strLastModeDate the strLastModeDate to set
	 */
	public void setStrLastModeDate(String strLastModeDate) {
		this.strLastModeDate = strLastModeDate;
	}
	/**
	 * Gets the serial version uid.
	 * 
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * Gets the str category no.
	 * 
	 * @return the strCategoryNo
	 */
	public String getStrCategoryNo() {
		return strCategoryNo;
	}

	/**
	 * Sets the str category no.
	 * 
	 * @param strCategoryNo the strCategoryNo to set
	 */
	public void setStrCategoryNo(String strCategoryNo) {
		this.strCategoryNo = strCategoryNo;
	}

	/**
	 * Gets the str group id.
	 * 
	 * @return the strGroupId
	 */
	public String getStrGroupId() {
		return strGroupId;
	}

	/**
	 * Sets the str group id.
	 * 
	 * @param strGroupId the strGroupId to set
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	/**
	 * Gets the str group name combo.
	 * 
	 * @return the strGroupNameCombo
	 */
	public String getStrGroupNameCombo() {
		return strGroupNameCombo;
	}

	/**
	 * Sets the str group name combo.
	 * 
	 * @param strGroupNameCombo the strGroupNameCombo to set
	 */
	public void setStrGroupNameCombo(String strGroupNameCombo) {
		this.strGroupNameCombo = strGroupNameCombo;
	}

	/**
	 * Gets the str group combo ws.
	 * 
	 * @return the strGroupComboWs
	 */
	public WebRowSet getStrGroupComboWs() {
		return strGroupComboWs;
	}

	/**
	 * Sets the str group combo ws.
	 * 
	 * @param strGroupComboWs the strGroupComboWs to set
	 */
	public void setStrGroupComboWs(WebRowSet strGroupComboWs) {
		this.strGroupComboWs = strGroupComboWs;
	}

	/**
	 * Gets the str sub group id.
	 * 
	 * @return the strSubGroupId
	 */
	public String getStrSubGroupId() {
		return strSubGroupId;
	}

	/**
	 * Sets the str sub group id.
	 * 
	 * @param strSubGroupId the strSubGroupId to set
	 */
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}

	/**
	 * Gets the str sub group name combo.
	 * 
	 * @return the strSubGroupNameCombo
	 */
	public String getStrSubGroupNameCombo() {
		return strSubGroupNameCombo;
	}

	/**
	 * Sets the str sub group name combo.
	 * 
	 * @param strSubGroupNameCombo the strSubGroupNameCombo to set
	 */
	public void setStrSubGroupNameCombo(String strSubGroupNameCombo) {
		this.strSubGroupNameCombo = strSubGroupNameCombo;
	}

	/**
	 * Gets the str sub group combo ws.
	 * 
	 * @return the strSubGroupComboWs
	 */
	public WebRowSet getStrSubGroupComboWs() {
		return strSubGroupComboWs;
	}

	/**
	 * Sets the str sub group combo ws.
	 * 
	 * @param strSubGroupComboWs the strSubGroupComboWs to set
	 */
	public void setStrSubGroupComboWs(WebRowSet strSubGroupComboWs) {
		this.strSubGroupComboWs = strSubGroupComboWs;
	}

	/**
	 * Gets the str group name.
	 * 
	 * @return the strGroupName
	 */
	public String getStrGroupName() {
		return strGroupName;
	}

	/**
	 * Sets the str group name.
	 * 
	 * @param strGroupName the strGroupName to set
	 */
	public void setStrGroupName(String strGroupName) {
		this.strGroupName = strGroupName;
	}

	/**
	 * Gets the str sub group name.
	 * 
	 * @return the strSubGroupName
	 */
	public String getStrSubGroupName() {
		return strSubGroupName;
	}

	/**
	 * Sets the str sub group name.
	 * 
	 * @param strSubGroupName the strSubGroupName to set
	 */
	public void setStrSubGroupName(String strSubGroupName) {
		this.strSubGroupName = strSubGroupName;
	}

	/**
	 * Gets the str module id.
	 * 
	 * @return the strModuleId
	 */
	public String getStrModuleId() {
		return strModuleId;
	}

	/**
	 * Sets the str module id.
	 * 
	 * @param strModuleId the strModuleId to set
	 */
	public void setStrModuleId(String strModuleId) {
		this.strModuleId = strModuleId;
	}

	/**
	 * Gets the str reserved qty.
	 * 
	 * @return the str reserved qty
	 */
	public String getStrReservedQty() {
		return strReservedQty;
	}

	/**
	 * Sets the str reserved qty.
	 * 
	 * @param strReservedQty the new str reserved qty
	 */
	public void setStrReservedQty(String strReservedQty) {
		this.strReservedQty = strReservedQty;
	}

	/**
	 * Gets the str inventory unit id.
	 * 
	 * @return the strInventoryUnitId
	 */
	public String getStrInventoryUnitId() {
		return strInventoryUnitId;
	}

	/**
	 * Sets the str inventory unit id.
	 * 
	 * @param strInventoryUnitId the strInventoryUnitId to set
	 */
	public void setStrInventoryUnitId(String strInventoryUnitId) {
		this.strInventoryUnitId = strInventoryUnitId;
	}

	/**
	 * @return the strToleranceLimit
	 */
	public String getStrToleranceLimit() {
		return strToleranceLimit;
	}

	/**
	 * @param strToleranceLimit the strToleranceLimit to set
	 */
	public void setStrToleranceLimit(String strToleranceLimit) {
		this.strToleranceLimit = strToleranceLimit;
	}

	public String getStrMaxLevelUnitId() {
		return strMaxLevelUnitId;
	}

	public void setStrMaxLevelUnitId(String strMaxLevelUnitId) {
		this.strMaxLevelUnitId = strMaxLevelUnitId;
	}

	public String getStrLevelUnitName() {
		return strLevelUnitName;
	}

	public void setStrLevelUnitName(String strLevelUnitName) {
		this.strLevelUnitName = strLevelUnitName;
	}

	public String getStrMaxIndentQty() {
		return strMaxIndentQty;
	}

	public void setStrMaxIndentQty(String strMaxIndentQty) {
		this.strMaxIndentQty = strMaxIndentQty;
	}

}

///////////////////////////////////////////////////////////////////////////////////////////////