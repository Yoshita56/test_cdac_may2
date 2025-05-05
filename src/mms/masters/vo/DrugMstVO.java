package mms.masters.vo;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugMstVO.
 */
/**
 * @author deps
 *
 */
public class DrugMstVO {

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str msg type. */
	private String strMsgType = "";
	
	/** The str msg string. */
	private String strMsgString = "";

	private String strGroupId = "";
	
	/** The str item cat id. */
	private String strItemCatId = "";
	
	/** The str generic item id. */
	private String strGenericItemId = "";
	
	private String strGenericItemName = "";
	
	/** The str drug name. */
	private String strDrugName = "";
	
	/** The str manufacturer id. */
	private String strManufacturerId = "";
	
	/** The str manufacturer. */
	private String strManufacturer = "";
	
	/** The str default rate. */
	private String strDefaultRate = "";
	
	/** The str unit id. */
	private String strUnitId = "";
	
	/** The str unit. */
	private String strUnit = "";
	
	/** The str unit values. */
	private String strUnitValues = "";
	
	/** The str approval type. */
	private String strApprovalType = "";

	/** The str issue type. */
	private String strIssueType = "";
	
	/** The str specification. */
	private String strSpecification = "";
	
	/** The str item make. */
	private String strItemMake = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str is sachet. */
	private String strIsSachet = "";
	
	/** The str item type. */
	private String strItemType = "";
	
	/** The str is quantified. */
	private String strIsQuantified = "";
	
	/** The str is valid. */
	private String strIsValid = "";
	
	/** The str inventory unit id. */
	private String strInventoryUnitId = "";
	
	/** The str item brand id. */
	private String strItemBrandId = "";
	
	/** The str rate unit id. */
	private String strRateUnitId = "";
	
	/** The str combo val. */
	private String strComboVal = "";
	
	/** The item type ws. */
	private WebRowSet itemTypeWs = null;
	
	/** The unit val ws. */
	private WebRowSet unitValWs = null;
	
	/** The manufacturer ws. */
	private WebRowSet manufacturerWs = null;

	private WebRowSet wsGenericItemValues = null;
	
	/** The b exist status. */
	private Boolean bExistStatus = false;
	
	private String strCPACode="";
	
	private String strPrevCPACode="";

	private String strNewCPACode="";

	private String strRateUnitName = "";
	
	
	private String strDrugType = "1";
	
	private String strIsItemCodeRequired = "0";
	
	private String strQCType;
	
	private String strMktRate;
	private String strMktRateUnitId;
	
	/**
	 * Group Name of drug.
	 */
	private String strGroupName = "";
	private String strConfigIssueRate;

	private WebRowSet WsUnitList; 
	
	private String strRateBaseUnitId;
	/*
	 * drug code have two part: (a) genecic part and (b)drug part.
	 * This variable holds the genecic part.
	 */
	private String strGenericDrugCode; 
	
	
	
	private String strApprovedTypeName;
	private WebRowSet wrsApprovedTypeOptions;
	private String strBreakageFlg;
	
	private WebRowSet issueTypeWs;
	private String strSerialNo;
	

	private String hospCode="";
	
	private String strBatchNo="";
	private String strExpiryDate="";
	
	private String strSubCategoryType="";
	private String strModuleId="";
	private WebRowSet stockMaintainedWS=null;
	private String strDrugClass="";
	private WebRowSet drugClassWs;
	private String strHSNCode="";
	private String strEdlCat="";
	
	private String strIsMisc;
	
	
	private String TEMP_SENS_FLAG="";
	private String MIN_VALUE="";
	private String MAX_VALUE ="";
	private String StrCheckDrugNameExistFlag ="";
	private String strModeVal;

	public String getStrModeVal() {
		return strModeVal;
	}

	public void setStrModeVal(String strModeVal) {
		this.strModeVal = strModeVal;
	}

	public String getStrCheckDrugNameExistFlag() {
		return StrCheckDrugNameExistFlag;
	}

	public void setStrCheckDrugNameExistFlag(String strCheckDrugNameExistFlag) {
		StrCheckDrugNameExistFlag = strCheckDrugNameExistFlag;
	}

	public String getMAX_VALUE() {
		return MAX_VALUE;
	}

	public void setMAX_VALUE(String mAX_VALUE) {
		MAX_VALUE = mAX_VALUE;
	}

	public String getMIN_VALUE() {
		return MIN_VALUE;
	}

	public void setMIN_VALUE(String mIN_VALUE) {
		MIN_VALUE = mIN_VALUE;
	}

	public String getTEMP_SENS_FLAG() {
		return TEMP_SENS_FLAG;
	}

	public void setTEMP_SENS_FLAG(String tEMP_SENS_FLAG) {
		TEMP_SENS_FLAG = tEMP_SENS_FLAG;
	}

	
	
		
	
	
	public String getStrIsMisc() {
		return strIsMisc;
	}

	public void setStrIsMisc(String strIsMisc) {
		this.strIsMisc = strIsMisc;
	}

	public String getStrEdlCat() {
		return strEdlCat;
	}

	public void setStrEdlCat(String strEdlCat) {
		this.strEdlCat = strEdlCat;
	}

	public String getStrHSNCode() {
		return strHSNCode;
	}

	public void setStrHSNCode(String strHSNCode) {
		this.strHSNCode = strHSNCode;
	}

	public WebRowSet getDrugClassWs() {
		return drugClassWs;
	}

	public void setDrugClassWs(WebRowSet drugClassWs) {
		this.drugClassWs = drugClassWs;
	}

	public String getStrDrugClass() {
		return strDrugClass;
	}

	public void setStrDrugClass(String strDrugClass) {
		this.strDrugClass = strDrugClass;
	}
	
		
	
	
	public WebRowSet getStockMaintainedWS() {
		return stockMaintainedWS;
	}

	public void setStockMaintainedWS(WebRowSet stockMaintainedWS) {
		this.stockMaintainedWS = stockMaintainedWS;
	}

	public String getStrModuleId() {
		return strModuleId;
	}

	public void setStrModuleId(String strModuleId) {
		this.strModuleId = strModuleId;
	}

	public String getStrSubCategoryType() {
		return strSubCategoryType;
	}

	public void setStrSubCategoryType(String strSubCategoryType) {
		this.strSubCategoryType = strSubCategoryType;
	}
	
	
	public String getStrBatchNo() {
		return strBatchNo;
	}

	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}

	

	public String getStrExpiryDate() {
		return strExpiryDate;
	}

	public void setStrExpiryDate(String strExpiryDate) {
		this.strExpiryDate = strExpiryDate;
	}

	public String getHospCode() {
		return hospCode;
	}

	public void setHospCode(String hospCode) {
		this.hospCode = hospCode;
	}
	
	public String getStrSerialNo() {
		return strSerialNo;
	}

	public void setStrSerialNo(String strSerialNo) {
		this.strSerialNo = strSerialNo;
	}

	public WebRowSet getIssueTypeWs() {
		return issueTypeWs;
	}

	public void setIssueTypeWs(WebRowSet issueTypeWs) {
		this.issueTypeWs = issueTypeWs;
	}

	public String getStrBreakageFlg() {
		return strBreakageFlg;
	}

	public void setStrBreakageFlg(String strBreakageFlg) {
		this.strBreakageFlg = strBreakageFlg;
	}

	/**
	 * @return Group Name of Corresponding drug.
	 */
	public String getStrGroupName() {
		return strGroupName;
	}

	/**
	 * @param strGroupName Group Name.
	 */
	public void setStrGroupName(String strGroupName) {
		this.strGroupName = strGroupName;
	}

	/**
	 * @return the strIsItemCodeRequired
	 */
	public String getStrIsItemCodeRequired() {
		return strIsItemCodeRequired;
	}

	/**
	 * @param strIsItemCodeRequired the strIsItemCodeRequired to set
	 */
	public void setStrIsItemCodeRequired(String strIsItemCodeRequired) {
		this.strIsItemCodeRequired = strIsItemCodeRequired;
	}

	public String getStrRateUnitName() {
		return strRateUnitName;
	}

	public void setStrRateUnitName(String strRateUnitName) {
		this.strRateUnitName = strRateUnitName;
	}

	/**
	 * @return the strPrevCPACode
	 */
	public String getStrPrevCPACode() {
		return strPrevCPACode;
	}

	/**
	 * @param strPrevCPACode the strPrevCPACode to set
	 */
	public void setStrPrevCPACode(String strPrevCPACode) {
		this.strPrevCPACode = strPrevCPACode;
	}

	/**
	 * @return the strNewCPACode
	 */
	public String getStrNewCPACode() {
		return strNewCPACode;
	}

	/**
	 * @param strNewCPACode the strNewCPACode to set
	 */
	public void setStrNewCPACode(String strNewCPACode) {
		this.strNewCPACode = strNewCPACode;
	}

	/**
	 * @return the strCPACode
	 */
	public String getStrCPACode() {
		return strCPACode;
	}

	/**
	 * @param strCPACode the strCPACode to set
	 */
	public void setStrCPACode(String strCPACode) {
		this.strCPACode = strCPACode;
	}

	/**
	 * Gets the b exist status.
	 * 
	 * @return the b exist status
	 */
	public Boolean getBExistStatus() {
		return bExistStatus;
	}

	/**
	 * Sets the b exist status.
	 * 
	 * @param existStatus the new b exist status
	 */
	public void setBExistStatus(Boolean existStatus) {
		bExistStatus = existStatus;
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
	 * @param strMsgType the new str msg type
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
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
	 * @param strMsgString the new str msg string
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	/**
	 * Gets the item type ws.
	 * 
	 * @return the item type ws
	 */
	public WebRowSet getItemTypeWs() {
		return itemTypeWs;
	}

	/**
	 * Sets the item type ws.
	 * 
	 * @param itemTypeWs the new item type ws
	 */
	public void setItemTypeWs(WebRowSet itemTypeWs) {
		this.itemTypeWs = itemTypeWs;
	}

	/**
	 * Gets the str inventory unit id.
	 * 
	 * @return the str inventory unit id
	 */
	public String getStrInventoryUnitId() {
		return strInventoryUnitId;
	}

	/**
	 * Sets the str inventory unit id.
	 * 
	 * @param strInventoryUnitId the new str inventory unit id
	 */
	public void setStrInventoryUnitId(String strInventoryUnitId) {
		this.strInventoryUnitId = strInventoryUnitId;
	}

	/**
	 * Gets the unit val ws.
	 * 
	 * @return the unit val ws
	 */
	public WebRowSet getUnitValWs() {
		return unitValWs;
	}

	/**
	 * Sets the unit val ws.
	 * 
	 * @param unitValWs the new unit val ws
	 */
	public void setUnitValWs(WebRowSet unitValWs) {
		this.unitValWs = unitValWs;
	}

	/**
	 * Gets the manufacturer ws.
	 * 
	 * @return the manufacturer ws
	 */
	public WebRowSet getManufacturerWs() {
		return manufacturerWs;
	}

	/**
	 * Sets the manufacturer ws.
	 * 
	 * @param manufacturerWs the new manufacturer ws
	 */
	public void setManufacturerWs(WebRowSet manufacturerWs) {
		this.manufacturerWs = manufacturerWs;
	}

	/**
	 * Gets the str item cat id.
	 * 
	 * @return the str item cat id
	 */
	public String getStrItemCatId() {
		return strItemCatId;
	}

	/**
	 * Sets the str item cat id.
	 * 
	 * @param strItemCatId the new str item cat id
	 */
	public void setStrItemCatId(String strItemCatId) {
		this.strItemCatId = strItemCatId;
	}

	/**
	 * Gets the str generic item id.
	 * 
	 * @return the str generic item id
	 */
	public String getStrGenericItemId() {
		return strGenericItemId;
	}

	/**
	 * Sets the str generic item id.
	 * 
	 * @param strGenericItemId the new str generic item id
	 */
	public void setStrGenericItemId(String strGenericItemId) {
		this.strGenericItemId = strGenericItemId;
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
	 * Gets the str manufacturer id.
	 * 
	 * @return the str manufacturer id
	 */
	public String getStrManufacturerId() {
		return strManufacturerId;
	}

	/**
	 * Sets the str manufacturer id.
	 * 
	 * @param strManufacturerId the new str manufacturer id
	 */
	public void setStrManufacturerId(String strManufacturerId) {
		this.strManufacturerId = strManufacturerId;
	}

	/**
	 * Gets the str default rate.
	 * 
	 * @return the str default rate
	 */
	public String getStrDefaultRate() {
		return strDefaultRate;
	}

	/**
	 * Sets the str default rate.
	 * 
	 * @param strDefaultRate the new str default rate
	 */
	public void setStrDefaultRate(String strDefaultRate) {
		this.strDefaultRate = strDefaultRate;
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
	 * Gets the str approval type.
	 * 
	 * @return the str approval type
	 */
	public String getStrApprovalType() {
		return strApprovalType;
	}

	/**
	 * Sets the str approval type.
	 * 
	 * @param strApprovalType the new str approval type
	 */
	public void setStrApprovalType(String strApprovalType) {
		this.strApprovalType = strApprovalType;
	}

	/**
	 * Gets the str issue type.
	 * 
	 * @return the str issue type
	 */
	public String getStrIssueType() {
		return strIssueType;
	}

	/**
	 * Sets the str issue type.
	 * 
	 * @param strIssueType the new str issue type
	 */
	public void setStrIssueType(String strIssueType) {
		this.strIssueType = strIssueType;
	}

	/**
	 * Gets the str specification.
	 * 
	 * @return the str specification
	 */
	public String getStrSpecification() {
		return strSpecification;
	}

	/**
	 * Sets the str specification.
	 * 
	 * @param strSpecification the new str specification
	 */
	public void setStrSpecification(String strSpecification) {
		this.strSpecification = strSpecification;
	}

	/**
	 * Gets the str item make.
	 * 
	 * @return the str item make
	 */
	public String getStrItemMake() {
		return strItemMake;
	}

	/**
	 * Sets the str item make.
	 * 
	 * @param strItemMake the new str item make
	 */
	public void setStrItemMake(String strItemMake) {
		this.strItemMake = strItemMake;
	}

	/**
	 * Gets the str effective from.
	 * 
	 * @return the str effective from
	 */
	public String getStrEffectiveFrom() {
		return strEffectiveFrom;
	}

	/**
	 * Sets the str effective from.
	 * 
	 * @param strEffectiveFrom the new str effective from
	 */
	public void setStrEffectiveFrom(String strEffectiveFrom) {
		this.strEffectiveFrom = strEffectiveFrom;
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
	 * Gets the str is sachet.
	 * 
	 * @return the str is sachet
	 */
	public String getStrIsSachet() {
		return strIsSachet;
	}

	/**
	 * Sets the str is sachet.
	 * 
	 * @param strIsSachet the new str is sachet
	 */
	public void setStrIsSachet(String strIsSachet) {
		this.strIsSachet = strIsSachet;
	}

	/**
	 * Gets the str item type.
	 * 
	 * @return the str item type
	 */
	public String getStrItemType() {
		return strItemType;
	}

	/**
	 * Sets the str item type.
	 * 
	 * @param strItemType the new str item type
	 */
	public void setStrItemType(String strItemType) {
		this.strItemType = strItemType;
	}

	/**
	 * Gets the str is quantified.
	 * 
	 * @return the str is quantified
	 */
	public String getStrIsQuantified() {
		return strIsQuantified;
	}

	/**
	 * Sets the str is quantified.
	 * 
	 * @param strIsQuantified the new str is quantified
	 */
	public void setStrIsQuantified(String strIsQuantified) {
		this.strIsQuantified = strIsQuantified;
	}

	/**
	 * Gets the str is valid.
	 * 
	 * @return the str is valid
	 */
	public String getStrIsValid() {
		return strIsValid;
	}

	/**
	 * Sets the str is valid.
	 * 
	 * @param strIsValid the new str is valid
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
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
	 * Gets the str rate unit id.
	 * 
	 * @return the str rate unit id
	 */
	public String getStrRateUnitId() {
		return strRateUnitId;
	}

	/**
	 * Sets the str rate unit id.
	 * 
	 * @param strRateUnitId the new str rate unit id
	 */
	public void setStrRateUnitId(String strRateUnitId) {
		this.strRateUnitId = strRateUnitId;
	}

	/**
	 * Gets the str combo val.
	 * 
	 * @return the str combo val
	 */
	public String getStrComboVal() {
		return strComboVal;
	}

	/**
	 * Sets the str combo val.
	 * 
	 * @param strComboVal the new str combo val
	 */
	public void setStrComboVal(String strComboVal) {
		this.strComboVal = strComboVal;
	}

	/**
	 * Gets the str unit.
	 * 
	 * @return the strUnit
	 */
	public String getStrUnit() {
		return strUnit;
	}

	/**
	 * Sets the str unit.
	 * 
	 * @param strUnit the strUnit to set
	 */
	public void setStrUnit(String strUnit) {
		this.strUnit = strUnit;
	}

	/**
	 * Gets the str unit values.
	 * 
	 * @return the strUnitValues
	 */
	public String getStrUnitValues() {
		return strUnitValues;
	}

	/**
	 * Sets the str unit values.
	 * 
	 * @param strUnitValues the strUnitValues to set
	 */
	public void setStrUnitValues(String strUnitValues) {
		this.strUnitValues = strUnitValues;
	}

	/**
	 * Gets the str manufacturer.
	 * 
	 * @return the strManufacturer
	 */
	public String getStrManufacturer() {
		return strManufacturer;
	}

	/**
	 * Sets the str manufacturer.
	 * 
	 * @param strManufacturer the strManufacturer to set
	 */
	public void setStrManufacturer(String strManufacturer) {
		this.strManufacturer = strManufacturer;
	}

	public String getStrDrugType() {
		return strDrugType;
	}

	public void setStrDrugType(String strDrugType) {
		this.strDrugType = strDrugType;
	}

	/**
	 * @return the wsGenericItemValues
	 */
	public WebRowSet getWsGenericItemValues() {
		return wsGenericItemValues;
	}

	/**
	 * @param wsGenericItemValues the wsGenericItemValues to set
	 */
	public void setWsGenericItemValues(WebRowSet wsGenericItemValues) {
		this.wsGenericItemValues = wsGenericItemValues;
	}

	/**
	 * @return the strGroupId
	 */
	public String getStrGroupId() {
		return strGroupId;
	}

	/**
	 * @param strGroupId the strGroupId to set
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	/**
	 * @return the strGenericItemName
	 */
	public String getStrGenericItemName() {
		return strGenericItemName;
	}

	/**
	 * @param strGenericItemName the strGenericItemName to set
	 */
	public void setStrGenericItemName(String strGenericItemName) {
		this.strGenericItemName = strGenericItemName;
	}

	/**
	 * @param strGenericDrugCode the strGenericDrugCode to set
	 */
	public void setStrGenericDrugCode(String strGenericDrugCode) {
		this.strGenericDrugCode = strGenericDrugCode;
	}

	/**
	 * @return the strGenericDrugCode
	 */
	public String getStrGenericDrugCode() {
		return strGenericDrugCode;
	}

	
	/**
	 * @return the strApprovedTypeName
	 */
	public String getStrApprovedTypeName() {
		return strApprovedTypeName;
	}

	/**
	 * @param strApprovedTypeName the strApprovedTypeName to set
	 */
	public void setStrApprovedTypeName(String strApprovedTypeName) {
		this.strApprovedTypeName = strApprovedTypeName;
	}

	/**
	 * @return the wrsApprovedTypeOptions
	 */
	public WebRowSet getWrsApprovedTypeOptions() {
		return wrsApprovedTypeOptions;
	}

	/**
	 * @param wrsApprovedTypeOptions the wrsApprovedTypeOptions to set
	 */
	public void setWrsApprovedTypeOptions(WebRowSet wrsApprovedTypeOptions) {
		this.wrsApprovedTypeOptions = wrsApprovedTypeOptions;
	}

	public String getStrConfigIssueRate() {
		return strConfigIssueRate;
	}

	public void setStrConfigIssueRate(String strConfigIssueRate) {
		this.strConfigIssueRate = strConfigIssueRate;
	}

	public String getStrQCType() {
		return strQCType;
	}

	public void setStrQCType(String strQCType) {
		this.strQCType = strQCType;
	}

	public WebRowSet getWsUnitList() {
		return WsUnitList;
	}

	public void setWsUnitList(WebRowSet wsUnitList) {
		WsUnitList = wsUnitList;
	}

	public String getStrMktRateUnitId() {
		return strMktRateUnitId;
	}

	public void setStrMktRateUnitId(String strMktRateUnitId) {
		this.strMktRateUnitId = strMktRateUnitId;
	}

	public String getStrMktRate() {
		return strMktRate;
	}

	public void setStrMktRate(String strMktRate) {
		this.strMktRate = strMktRate;
	}

	public String getStrRateBaseUnitId() {
		return strRateBaseUnitId;
	}

	public void setStrRateBaseUnitId(String strRateBaseUnitId) {
		this.strRateBaseUnitId = strRateBaseUnitId;
	}


}
