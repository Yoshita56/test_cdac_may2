package mms.masters.controller.fb;



import javax.sql.rowset.WebRowSet;

import hisglobal.masterutil.GenericFormBean;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugMstFB.
 */
public class DrugMstFB extends GenericFormBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The str normal msg. */
	private String strNormalMsg = "";
	
	/** The str warning msg. */
	private String strWarningMsg = "";
	
	/** The str err msg. */
	private String strErrMsg = "";
	
	/** The str combo value. */
	private String strComboValue = "";
	
	/** The str temp cmb value. */
	private String strTempCmbValue = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str chk. */
	private String strChk = "";
	
	/** The str is valid. */
	private String strIsValid = "";
	
	/** The str current date. */
	private String strCurrentDate = "";
	
	/** The str item cat id. */
	private String strItemCatId = "";
	
	/** The str request type. */
	private String strRequestType = "";
	
	/** The str item type. */
	private String strItemType = "";
	
	/** The str item type values. */
	private String strItemTypeValues = "";
	
	/** The str drug name. */
	private String strDrugName = "";
	
	/** The str manufacturer id. */
	private String strManufacturerId = "";
	
	/** The str manufacturer. */
	private String strManufacturer = "";
	
	/** The str manufacturer val. */
	private String strManufacturerVal = "";
	
	/** The str default rate. */
	private String strDefaultRate = "";
	
	/** The str unit. */
	private String strUnit = "";
	
	private String strNewCPACode="";
	
	/** The str unit values. */
	private String strUnitValues = "";
	
	/** The str approved type. */
	private String strApprovedType = "";
	
	/** The str issue type. */
	private String strIssueType = "";
	
	/** The str item make. */
	private String strItemMake = "";
	
	/** The str is item sachet. */
	private String strIsItemSachet = "0";
	private String strSerialNo;
	
	
	
	
	/** The str is quantifiable. */
	/*
	 * This line is deactivated by Aritra on 31st May, 2010.
	 * Reason: if setter method not invoked, its value will be "1". There is a
	 * requirement to set its value through checkbox. So it checkbox is unchecked,
	 * its setter method will not be invoked and its value will be 1 by default,
	 * which is the same value if it is checked!! That means it is impossible to
	 * set its value to "0" through checkbox if we initialize it with "1".
	private String strIsQuantifiable = "1";
	*/
	
	/*
	 * This code is added by Aritra on 31st May, 2010
	 * Reason: To declare a variable 'strIsQuantifiable' and initialize it with
	 * the value "0".
	 */
	/** The str is quantifiable. */
	private String strIsQuantifiable = "0";
	
	/** The str specification. */
	private String strSpecification = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str group id. */
	private String strGroupId = "";
	
	private String strSubGroupId = "";
	
	/** The str generic item id. */
	private String strGenericItemId = "";

	/** The str item cat name. */
	private String strItemCatName = "";
	
	/** The str group name. */
	private String strGroupName = "";
	
	/** The str generic item name. */
	private String strGenericItemName = "";
	
	private String strCPACode="";
	private String strPrevCPACode="";

	private String strRateUnitId = "";
	
	private String strRateUnitName = ""; 
	
	private String strDrugType = "1";
	 
	private String strGenericItemValues = "";
	
	
	private String strIsItemCodeRequired = "0";
	private String strConfigIssueRate="0";
	
	
	/* Approved */
	private String strApprovedTypeName;
	private String strApprovedTypeOptions;
	
	
	private String strChkFlg;
	private String strIssueRateConfigFlg;
	private String strBreakageFlg;
	private String strDrugWarehouseType;
	private String strQCType;
	
	private String strIssueTypeComboOptions;
	
	private String strMktRate="0";
	private String strMktRateUnitId="0";
	
	private String strMktRateUnitIdValues;
	
	private String strMsgType="";
	
	private String strBatchNo="1";
	private String strExpiryDate="1";
	private String strSubCategoryType="";
	private String strModuleId="";
	
	private String  stockMaintainedWS="";
	private String strDrugClass="";
	private String strHSNCode="";
	private String strEdlCat="";
	private String strIsMisc="0";
	
	
	private String TEMP_SENS_FLAG="";
	private String MIN_VALUE="";
	private String MAX_VALUE ="";
	
	public String getMAX_VALUE() {
		return MAX_VALUE;
	}

	public void setMAX_VALUE(String mAX_VALUE) {
		this.MAX_VALUE = mAX_VALUE;
	}

	public String getMIN_VALUE() {
		return MIN_VALUE;
	}

	public void setMIN_VALUE(String mIN_VALUE) {
		this.MIN_VALUE = mIN_VALUE;
	}

	public String getTEMP_SENS_FLAG() {
		return TEMP_SENS_FLAG;
	}

	public void setTEMP_SENS_FLAG(String tEMP_SENS_FLAG) {
		this.TEMP_SENS_FLAG = tEMP_SENS_FLAG;
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

	public String getStrDrugClass() {
		return strDrugClass;
	}

	public void setStrDrugClass(String strDrugClass) {
		this.strDrugClass = strDrugClass;
	}

	public String getStockMaintainedWS() {
		return stockMaintainedWS;
	}

	public void setStockMaintainedWS(String stockMaintainedWS) {
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

	public String getStrMsgType() {
		return strMsgType;
	}

	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	public String getStrMktRateUnitIdValues() {
		return strMktRateUnitIdValues;
	}

	public void setStrMktRateUnitIdValues(String strMktRateUnitIdValues) {
		this.strMktRateUnitIdValues = strMktRateUnitIdValues;
	}

	public String getStrMktRate() {
		return strMktRate;
	}

	public void setStrMktRate(String strMktRate) {
		this.strMktRate = strMktRate;
	}

	public String getStrMktRateUnitId() {
		return strMktRateUnitId;
	}

	public void setStrMktRateUnitId(String strMktRateUnitId) {
		this.strMktRateUnitId = strMktRateUnitId;
	}

	public String getStrIssueTypeComboOptions() {
		return strIssueTypeComboOptions;
	}

	public void setStrIssueTypeComboOptions(String strIssueTypeComboOptions) {
		this.strIssueTypeComboOptions = strIssueTypeComboOptions;
	}

	public String getStrQCType() {
		return strQCType;
	}

	public void setStrQCType(String strQCType) {
		this.strQCType = strQCType;
	}

	public String getStrDrugWarehouseType() {
		return strDrugWarehouseType;
	}

	public void setStrDrugWarehouseType(String strDrugWarehouseType) {
		this.strDrugWarehouseType = strDrugWarehouseType;
	}

	/**
	 * @return the strGenericItemValues
	 */
	public String getStrGenericItemValues() {
		return strGenericItemValues;
	}

	/**
	 * @param strGenericItemValues the strGenericItemValues to set
	 */
	public void setStrGenericItemValues(String strGenericItemValues) {
		this.strGenericItemValues = strGenericItemValues;
	}

	public String getStrDrugType() {
		return strDrugType;
	}

	public void setStrDrugType(String strDrugType) {
		this.strDrugType = strDrugType;
	}

	public String getStrRateUnitName() {
		return strRateUnitName;
	}

	public void setStrRateUnitName(String strRateUnitName) {
		this.strRateUnitName = strRateUnitName;
	}

	public String getStrRateUnitId() {
		return strRateUnitId;
	}

	public void setStrRateUnitId(String strRateUnitId) {
		this.strRateUnitId = strRateUnitId;
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
	 * Gets the str normal msg.
	 * 
	 * @return the str normal msg
	 */
	public String getStrNormalMsg() {
		return strNormalMsg;
	}

	/**
	 * Sets the str normal msg.
	 * 
	 * @param strNormalMsg the new str normal msg
	 */
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}

	/**
	 * Gets the str warning msg.
	 * 
	 * @return the str warning msg
	 */
	public String getStrWarningMsg() {
		return strWarningMsg;
	}

	/**
	 * Sets the str warning msg.
	 * 
	 * @param strWarningMsg the new str warning msg
	 */
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}

	/**
	 * Gets the str err msg.
	 * 
	 * @return the str err msg
	 */
	public String getStrErrMsg() {
		return strErrMsg;
	}

	/**
	 * Sets the str err msg.
	 * 
	 * @param strErrMsg the new str err msg
	 */
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
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
	 * Gets the str chk.
	 * 
	 * @return the str chk
	 */
	public String getStrChk() {
		return strChk;
	}

	/**
	 * Sets the str chk.
	 * 
	 * @param strChk the new str chk
	 */
	public void setStrChk(String strChk) {
		this.strChk = strChk;
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
	 * Gets the str current date.
	 * 
	 * @return the str current date
	 */
	public String getStrCurrentDate() {
		return strCurrentDate;
	}

	/**
	 * Sets the str current date.
	 * 
	 * @param strCurrentDate the new str current date
	 */
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
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
	 * Gets the str item type values.
	 * 
	 * @return the str item type values
	 */
	public String getStrItemTypeValues() {
		return strItemTypeValues;
	}

	/**
	 * Sets the str item type values.
	 * 
	 * @param strItemTypeValues the new str item type values
	 */
	public void setStrItemTypeValues(String strItemTypeValues) {
		this.strItemTypeValues = strItemTypeValues;
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
	 * Gets the str manufacturer val.
	 * 
	 * @return the str manufacturer val
	 */
	public String getStrManufacturerVal() {
		return strManufacturerVal;
	}

	/**
	 * Sets the str manufacturer val.
	 * 
	 * @param strManufacturerVal the new str manufacturer val
	 */
	public void setStrManufacturerVal(String strManufacturerVal) {
		this.strManufacturerVal = strManufacturerVal;
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
	 * Gets the str unit.
	 * 
	 * @return the str unit
	 */
	public String getStrUnit() {
		return strUnit;
	}

	/**
	 * Sets the str unit.
	 * 
	 * @param strUnit the new str unit
	 */
	public void setStrUnit(String strUnit) {
		this.strUnit = strUnit;
	}

	/**
	 * Gets the str unit values.
	 * 
	 * @return the str unit values
	 */
	public String getStrUnitValues() {
		return strUnitValues;
	}

	/**
	 * Sets the str unit values.
	 * 
	 * @param strUnitValues the new str unit values
	 */
	public void setStrUnitValues(String strUnitValues) {
		this.strUnitValues = strUnitValues;
	}

	/**
	 * Gets the str approved type.
	 * 
	 * @return the str approved type
	 */
	public String getStrApprovedType() {
		return strApprovedType;
	}

	/**
	 * Sets the str approved type.
	 * 
	 * @param strApprovedType the new str approved type
	 */
	public void setStrApprovedType(String strApprovedType) {
		this.strApprovedType = strApprovedType;
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
	 * Gets the str is item sachet.
	 * 
	 * @return the str is item sachet
	 */
	public String getStrIsItemSachet() {
		return strIsItemSachet;
	}

	/**
	 * Sets the str is item sachet.
	 * 
	 * @param strIsItemSachet the new str is item sachet
	 */
	public void setStrIsItemSachet(String strIsItemSachet) {
		this.strIsItemSachet = strIsItemSachet;
	}

	/**
	 * Gets the str is quantifiable.
	 * 
	 * @return the str is quantifiable
	 */
	public String getStrIsQuantifiable() {
		return strIsQuantifiable;
	}

	/**
	 * Sets the str is quantifiable.
	 * 
	 * @param strIsQuantifiable the new str is quantifiable
	 */
	public void setStrIsQuantifiable(String strIsQuantifiable) {
		this.strIsQuantifiable = strIsQuantifiable;
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
	 * Gets the str item cat name.
	 * 
	 * @return the str item cat name
	 */
	public String getStrItemCatName() {
		return strItemCatName;
	}

	/**
	 * Sets the str item cat name.
	 * 
	 * @param strItemCatName the new str item cat name
	 */
	public void setStrItemCatName(String strItemCatName) {
		this.strItemCatName = strItemCatName;
	}

	/**
	 * Gets the str group name.
	 * 
	 * @return the str group name
	 */
	public String getStrGroupName() {
		return strGroupName;
	}

	/**
	 * Sets the str group name.
	 * 
	 * @param strGroupName the new str group name
	 */
	public void setStrGroupName(String strGroupName) {
		this.strGroupName = strGroupName;
	}

	/**
	 * Gets the str generic item name.
	 * 
	 * @return the str generic item name
	 */
	public String getStrGenericItemName() {
		return strGenericItemName;
	}

	/**
	 * Sets the str generic item name.
	 * 
	 * @param strGenericItemName the new str generic item name
	 */
	public void setStrGenericItemName(String strGenericItemName) {
		this.strGenericItemName = strGenericItemName;
	}

	/**
	 * Gets the str combo value.
	 * 
	 * @return the str combo value
	 */
	public String getStrComboValue() {
		return strComboValue;
	}

	/**
	 * Sets the str combo value.
	 * 
	 * @param strComboValue the new str combo value
	 */
	public void setStrComboValue(String strComboValue) {
		this.strComboValue = strComboValue;
	}

	/**
	 * Gets the str temp cmb value.
	 * 
	 * @return the str temp cmb value
	 */
	public String getStrTempCmbValue() {
		return strTempCmbValue;
	}

	/**
	 * Sets the str temp cmb value.
	 * 
	 * @param strTempCmbValue the new str temp cmb value
	 */
	public void setStrTempCmbValue(String strTempCmbValue) {
		this.strTempCmbValue = strTempCmbValue;
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

	/**
	 * @return the strSubGroupId
	 */
	public String getStrSubGroupId() {
		return strSubGroupId;
	}

	/**
	 * @param strSubGroupId the strSubGroupId to set
	 */
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
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
	 * @return the strApprovedTypeOptions
	 */
	public String getStrApprovedTypeOptions() {
		return strApprovedTypeOptions;
	}

	/**
	 * @param strApprovedTypeOptions the strApprovedTypeOptions to set
	 */
	public void setStrApprovedTypeOptions(String strApprovedTypeOptions) {
		this.strApprovedTypeOptions = strApprovedTypeOptions;
	}

	public String getStrConfigIssueRate() {
		return strConfigIssueRate;
	}

	public void setStrConfigIssueRate(String strConfigIssueRate) {
		this.strConfigIssueRate = strConfigIssueRate;
	}

	public String getStrChkFlg() {
		return strChkFlg;
	}

	public void setStrChkFlg(String strChkFlg) {
		this.strChkFlg = strChkFlg;
	}

	public String getStrIssueRateConfigFlg() {
		return strIssueRateConfigFlg;
	}

	public void setStrIssueRateConfigFlg(String strIssueRateConfigFlg) {
		this.strIssueRateConfigFlg = strIssueRateConfigFlg;
	}

	public String getStrBreakageFlg() {
		return strBreakageFlg;
	}

	public void setStrBreakageFlg(String strBreakageFlg) {
		this.strBreakageFlg = strBreakageFlg;
	}

	public String getStrSerialNo() {
		return strSerialNo;
	}

	public void setStrSerialNo(String strSerialNo) {
		this.strSerialNo = strSerialNo;
	}

	 
}
