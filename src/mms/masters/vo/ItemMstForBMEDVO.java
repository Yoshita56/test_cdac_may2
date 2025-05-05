/**
 * 
 */
package mms.masters.vo;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.TransferObject;
// TODO: Auto-generated Javadoc
/**
 * Developer : Tanvi Sappal Version : 1.0 Date : 15/May/2009
 */
public class ItemMstForBMEDVO implements TransferObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The str msg string. */
	private String strMsgString = "";
	
	/** The str msg type. */
	private String strMsgType = "";
	
	/** The str hosp code. */
	private String strHospCode = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str chk. */
	private String strChk = "";
	
	/** The str is valid. */
	private String strIsValid = "";
	
	/** The str current date. */
	private String strCurrentDate = "";

	/** The b exist status. */
	private Boolean bExistStatus = false;
	
	/** The str item brand id. */
	private String strItemBrandId = "";
	
	/** The str item id. */
	private String strItemId = "";
	
	/** The str gen item id. */
	private String strGenItemId = "";
	
	/** The str item cat no. */
	private String strItemCatNo = "";
	
	/** The str item cat name. */
	private String strItemCatName = "";
	
	/** The str item name. */
	private String strItemName = "";
	
	/** The str gen item name. */
	private String strGenItemName = "";
	
	/** The str manufacturer id. */
	private String strManufacturerId = "";
	
	/** The str manufacturer name. */
	private String strManufacturerName = "";
	
	/** The str rate unit name. */
	private String strRateUnitName = "";
	
	/** The str default rate. */
	private String strDefaultRate = "";
	
	/** The str rate unit id. */
	private String strRateUnitId = "";
	
	/** The str inventory unit id. */
	private String strInventoryUnitId = "";
	
	/** The str approved type. */
	private String strApprovedType = "";
	
	/** The str issue type. */
	private String strIssueType = "";
	
	/** The str specification. */
	private String strSpecification = "";
	
	/** The str item make. */
	private String strItemMake = "";
	
	/** The str last mod seat id. */
	private String strLastModSeatId = "";
	
	/** The str last mod date. */
	private String strLastModDate = "";
	
	/** The str set sachet flag. */
	private String strSetSachetFlag = "";
	
	/** The str spare part flag. */
	private String strSparePartFlag = "";
	
	/** The str item type id. */
	private String strItemTypeId = "";
	
	/** The str item type name. */
	private String strItemTypeName = "";
	
	/** The str is quantified. */
	private String strIsQuantified = "";
	
	/** The str group id. */
	private String strGroupId = "";
	
	/** The str group name. */
	private String strGroupName = "";

	/** The item type ws. */
	private WebRowSet itemTypeWS = null;
	
	/** The manufacturer ws. */
	private WebRowSet manufacturerWS = null;
	
	/** The rate unit ws. */
	private WebRowSet rateUnitWS = null;

	/** The str item type combo. */
	private String strItemTypeCombo = "";
	
	/** The str manufacturer combo. */
	private String strManufacturerCombo = "";
	
	/** The str rate unit combo. */
	private String strRateUnitCombo = "";

	private String strItemType = "1";
	
	
	private String strNewCPACode=""; 
	
	private String strCPACode="";
	
	private String strPrevCPACode="";
	
	private String StrGenericItem="";
	private String strHospiCode;
	private String strManufDate="";
	private String strIsMisc;
	
	
	
	private String TEMP_SENS_FLAG="";
	private String MIN_VALUE="";
	private String MAX_VALUE ="";
	
	private String MACNo ="";
	private String strloc ="";
	private String strWarrantyStartDate ="";
	private String strWarrantyUpTo ="";
	private String strUnitId ="";
	private String strLPNo;
	
	public String getStrLPNo() {
		return strLPNo;
	}

	public void setStrLPNo(String strLPNo) {
		this.strLPNo = strLPNo;
	}

	public String getMACNo() {
		return MACNo;
	}

	public void setMACNo(String mACNo) {
		MACNo = mACNo;
	}

	public String getStrloc() {
		return strloc;
	}

	public void setStrloc(String strloc) {
		this.strloc = strloc;
	}

	public String getStrWarrantyStartDate() {
		return strWarrantyStartDate;
	}

	public void setStrWarrantyStartDate(String strWarrantyStartDate) {
		this.strWarrantyStartDate = strWarrantyStartDate;
	}

	public String getStrWarrantyUpTo() {
		return strWarrantyUpTo;
	}

	public void setStrWarrantyUpTo(String strWarrantyUpTo) {
		this.strWarrantyUpTo = strWarrantyUpTo;
	}

	public String getStrUnitId() {
		return strUnitId;
	}

	public void setStrUnitId(String strUnitId) {
		this.strUnitId = strUnitId;
	}


	
	
	
	
	
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

	public String getStrManufDate() {
		return strManufDate;
	}

	public void setStrManufDate(String strManufDate) {
		this.strManufDate = strManufDate;
	}

	public String getStrHospiCode() {
		return strHospiCode;
	}

	public void setStrHospiCode(String strHospiCode) {
		this.strHospiCode = strHospiCode;
	}

	public String getStrGenericItem() {
		return StrGenericItem;
	}

	public void setStrGenericItem(String strGenericItem) {
		StrGenericItem = strGenericItem;
	}

	private String strIsItemCodeRequired = "0";
	
	public WebRowSet wsGenericItems = null;
	
	
	
	private String strSterilizationFlag="0";
	private String strSterilizationLife="0";
	private String strUploadFlag;
	
	//private FormFile strLocation=null;
	private String strFileNo = "";
	private String strPageNo = "";
	private String strFileName = "";
	private String strUploadFileId;
	private String strUploadFileName;
	private String strSerialNo;
	
	private String strBatchNo="";
	private String strExpiryDate="";
	private String strParam="";
	
	/**
	 * Defines whether this item is branded, non-branded or reserved.
	 * 1 --> Branded
	 * 2 --> Non Branded
	 * 3 --> Reserved
	 */
	private String strBrandReserveFlag ="";
	
	private String strBrandReserveStatus ="";
	
	private String StrGenericItemCode="";
	
	
	private String strApprovedTypeName;
	private WebRowSet wrsApprovedTypeOptions;
	private String strConsumableType="";
	private String strItemClass="";	
	
	private String strHSNCode="";
	
	

	public String getStrHSNCode() {
		return strHSNCode;
	}

	public void setStrHSNCode(String strHSNCode) {
		this.strHSNCode = strHSNCode;
	}

	
	public String getStrItemClass() {
		return strItemClass;
	}

	public void setStrItemClass(String strItemClass) {
		this.strItemClass = strItemClass;
	}

	public String getStrConsumableType() {
		return strConsumableType;
	}

	public void setStrConsumableType(String strConsumableType) {
		this.strConsumableType = strConsumableType;
	}
	/**
	 * @return the wsGenericItems
	 */
	public WebRowSet getWsGenericItems() {
		return wsGenericItems;
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

	public String getStrParam() {
		return strParam;
	}

	public void setStrParam(String strParam) {
		this.strParam = strParam;
	}

	/**
	 * @param wsGenericItems the wsGenericItems to set
	 */
	public void setWsGenericItems(WebRowSet wsGenericItems) {
		this.wsGenericItems = wsGenericItems;
	}

	public String getStrItemType() {
		return strItemType;
	}

	public void setStrItemType(String strItemType) {
		this.strItemType = strItemType;
	}

	/**
	 * Gets the item type ws.
	 * 
	 * @return the itemTypeWS
	 */
	public WebRowSet getItemTypeWS() {
		return itemTypeWS;
	}

	/**
	 * Sets the item type ws.
	 * 
	 * @param itemTypeWS the itemTypeWS to set
	 */
	public void setItemTypeWS(WebRowSet itemTypeWS) {
		this.itemTypeWS = itemTypeWS;
	}

	/**
	 * Gets the manufacturer ws.
	 * 
	 * @return the manufacturerWS
	 */
	public WebRowSet getManufacturerWS() {
		return manufacturerWS;
	}

	/**
	 * Sets the manufacturer ws.
	 * 
	 * @param manufacturerWS the manufacturerWS to set
	 */
	public void setManufacturerWS(WebRowSet manufacturerWS) {
		this.manufacturerWS = manufacturerWS;
	}

	/**
	 * Gets the rate unit ws.
	 * 
	 * @return the rateUnitWS
	 */
	public WebRowSet getRateUnitWS() {
		return rateUnitWS;
	}

	/**
	 * Sets the rate unit ws.
	 * 
	 * @param rateUnitWS the rateUnitWS to set
	 */
	public void setRateUnitWS(WebRowSet rateUnitWS) {
		this.rateUnitWS = rateUnitWS;
	}

	/**
	 * Gets the str item type combo.
	 * 
	 * @return the strItemTypeCombo
	 */
	public String getStrItemTypeCombo() {
		return strItemTypeCombo;
	}

	/**
	 * Sets the str item type combo.
	 * 
	 * @param strItemTypeCombo the strItemTypeCombo to set
	 */
	public void setStrItemTypeCombo(String strItemTypeCombo) {
		this.strItemTypeCombo = strItemTypeCombo;
	}

	/**
	 * Gets the str manufacturer combo.
	 * 
	 * @return the strManufacturerCombo
	 */
	public String getStrManufacturerCombo() {
		return strManufacturerCombo;
	}

	/**
	 * Sets the str manufacturer combo.
	 * 
	 * @param strManufacturerCombo the strManufacturerCombo to set
	 */
	public void setStrManufacturerCombo(String strManufacturerCombo) {
		this.strManufacturerCombo = strManufacturerCombo;
	}

	/**
	 * Gets the str rate unit combo.
	 * 
	 * @return the strRateUnitCombo
	 */
	public String getStrRateUnitCombo() {
		return strRateUnitCombo;
	}

	/**
	 * Sets the str rate unit combo.
	 * 
	 * @param strRateUnitCombo the strRateUnitCombo to set
	 */
	public void setStrRateUnitCombo(String strRateUnitCombo) {
		this.strRateUnitCombo = strRateUnitCombo;
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
	 * Gets the str hosp code.
	 * 
	 * @return the strHospCode
	 */
	public String getStrHospCode() {
		return strHospCode;
	}

	/**
	 * Sets the str hosp code.
	 * 
	 * @param strHospCode the strHospCode to set
	 */
	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
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
	 * Gets the str chk.
	 * 
	 * @return the strChk
	 */
	public String getStrChk() {
		return strChk;
	}

	/**
	 * Sets the str chk.
	 * 
	 * @param strChk the strChk to set
	 */
	public void setStrChk(String strChk) {
		this.strChk = strChk;
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
	 * Gets the str current date.
	 * 
	 * @return the strCurrentDate
	 */
	public String getStrCurrentDate() {
		return strCurrentDate;
	}

	/**
	 * Sets the str current date.
	 * 
	 * @param strCurrentDate the strCurrentDate to set
	 */
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
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
	 * Gets the str item cat no.
	 * 
	 * @return the strItemCatNo
	 */
	public String getStrItemCatNo() {
		return strItemCatNo;
	}

	/**
	 * Sets the str item cat no.
	 * 
	 * @param strItemCatNo the strItemCatNo to set
	 */
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}

	/**
	 * Gets the str item cat name.
	 * 
	 * @return the strItemCatName
	 */
	public String getStrItemCatName() {
		return strItemCatName;
	}

	/**
	 * Sets the str item cat name.
	 * 
	 * @param strItemCatName the strItemCatName to set
	 */
	public void setStrItemCatName(String strItemCatName) {
		this.strItemCatName = strItemCatName;
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
	 * Gets the str manufacturer id.
	 * 
	 * @return the strManufacturerId
	 */
	public String getStrManufacturerId() {
		return strManufacturerId;
	}

	/**
	 * Sets the str manufacturer id.
	 * 
	 * @param strManufacturerId the strManufacturerId to set
	 */
	public void setStrManufacturerId(String strManufacturerId) {
		this.strManufacturerId = strManufacturerId;
	}

	/**
	 * Gets the str manufacturer name.
	 * 
	 * @return the strManufacturerName
	 */
	public String getStrManufacturerName() {
		return strManufacturerName;
	}

	/**
	 * Sets the str manufacturer name.
	 * 
	 * @param strManufacturerName the strManufacturerName to set
	 */
	public void setStrManufacturerName(String strManufacturerName) {
		this.strManufacturerName = strManufacturerName;
	}

	/**
	 * Gets the str default rate.
	 * 
	 * @return the strDefaultRate
	 */
	public String getStrDefaultRate() {
		return strDefaultRate;
	}

	/**
	 * Sets the str default rate.
	 * 
	 * @param strDefaultRate the strDefaultRate to set
	 */
	public void setStrDefaultRate(String strDefaultRate) {
		this.strDefaultRate = strDefaultRate;
	}

	/**
	 * Gets the str rate unit id.
	 * 
	 * @return the strRateUnitId
	 */
	public String getStrRateUnitId() {
		return strRateUnitId;
	}

	/**
	 * Sets the str rate unit id.
	 * 
	 * @param strRateUnitId the strRateUnitId to set
	 */
	public void setStrRateUnitId(String strRateUnitId) {
		this.strRateUnitId = strRateUnitId;
	}

	/**
	 * Gets the str approved type.
	 * 
	 * @return the strApprovedType
	 */
	public String getStrApprovedType() {
		return strApprovedType;
	}

	/**
	 * Sets the str approved type.
	 * 
	 * @param strApprovedType the strApprovedType to set
	 */
	public void setStrApprovedType(String strApprovedType) {
		this.strApprovedType = strApprovedType;
	}

	/**
	 * Gets the str issue type.
	 * 
	 * @return the strIssueType
	 */
	public String getStrIssueType() {
		return strIssueType;
	}

	/**
	 * Sets the str issue type.
	 * 
	 * @param strIssueType the strIssueType to set
	 */
	public void setStrIssueType(String strIssueType) {
		this.strIssueType = strIssueType;
	}

	/**
	 * Gets the str specification.
	 * 
	 * @return the strSpecification
	 */
	public String getStrSpecification() {
		return strSpecification;
	}

	/**
	 * Sets the str specification.
	 * 
	 * @param strSpecification the str specification
	 */
	public void setStrSpecification(String strSpecification) {
		this.strSpecification = strSpecification;
	}

	/**
	 * Gets the str item make.
	 * 
	 * @return the strItemMake
	 */
	public String getStrItemMake() {
		return strItemMake;
	}

	/**
	 * Sets the str item make.
	 * 
	 * @param strItemMake the strItemMake to set
	 */
	public void setStrItemMake(String strItemMake) {
		this.strItemMake = strItemMake;
	}

	/**
	 * Gets the str last mod seat id.
	 * 
	 * @return the strLastModSeatId
	 */
	public String getStrLastModSeatId() {
		return strLastModSeatId;
	}

	/**
	 * Sets the str last mod seat id.
	 * 
	 * @param strLastModSeatId the strLastModSeatId to set
	 */
	public void setStrLastModSeatId(String strLastModSeatId) {
		this.strLastModSeatId = strLastModSeatId;
	}

	/**
	 * Gets the str last mod date.
	 * 
	 * @return the strLastModDate
	 */
	public String getStrLastModDate() {
		return strLastModDate;
	}

	/**
	 * Sets the str last mod date.
	 * 
	 * @param strLastModDate the strLastModDate to set
	 */
	public void setStrLastModDate(String strLastModDate) {
		this.strLastModDate = strLastModDate;
	}

	/**
	 * Gets the str set sachet flag.
	 * 
	 * @return the strSetSachetFlag
	 */
	public String getStrSetSachetFlag() {
		return strSetSachetFlag;
	}

	/**
	 * Sets the str set sachet flag.
	 * 
	 * @param strSetSachetFlag the strSetSachetFlag to set
	 */
	public void setStrSetSachetFlag(String strSetSachetFlag) {
		this.strSetSachetFlag = strSetSachetFlag;
	}

	/**
	 * Gets the str spare part flag.
	 * 
	 * @return the strSparePartFlag
	 */
	public String getStrSparePartFlag() {
		return strSparePartFlag;
	}

	/**
	 * Sets the str spare part flag.
	 * 
	 * @param strSparePartFlag the strSparePartFlag to set
	 */
	public void setStrSparePartFlag(String strSparePartFlag) {
		this.strSparePartFlag = strSparePartFlag;
	}

	/**
	 * Gets the str item type id.
	 * 
	 * @return the strItemTypeId
	 */
	public String getStrItemTypeId() {
		return strItemTypeId;
	}

	/**
	 * Sets the str item type id.
	 * 
	 * @param strItemTypeId the strItemTypeId to set
	 */
	public void setStrItemTypeId(String strItemTypeId) {
		this.strItemTypeId = strItemTypeId;
	}

	/**
	 * Gets the str item type name.
	 * 
	 * @return the strItemTypeName
	 */
	public String getStrItemTypeName() {
		return strItemTypeName;
	}

	/**
	 * Sets the str item type name.
	 * 
	 * @param strItemTypeName the strItemTypeName to set
	 */
	public void setStrItemTypeName(String strItemTypeName) {
		this.strItemTypeName = strItemTypeName;
	}

	/**
	 * Gets the str is quantified.
	 * 
	 * @return the strIsQuantified
	 */
	public String getStrIsQuantified() {
		return strIsQuantified;
	}

	/**
	 * Sets the str is quantified.
	 * 
	 * @param strIsQuantified the strIsQuantified to set
	 */
	public void setStrIsQuantified(String strIsQuantified) {
		this.strIsQuantified = strIsQuantified;
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
	 * Gets the str gen item id.
	 * 
	 * @return the strGenItemId
	 */
	public String getStrGenItemId() {
		return strGenItemId;
	}

	/**
	 * Sets the str gen item id.
	 * 
	 * @param strGenItemId the strGenItemId to set
	 */
	public void setStrGenItemId(String strGenItemId) {
		this.strGenItemId = strGenItemId;
	}

	/**
	 * Gets the str gen item name.
	 * 
	 * @return the strGenItemName
	 */
	public String getStrGenItemName() {
		return strGenItemName;
	}

	/**
	 * Sets the str gen item name.
	 * 
	 * @param strGenItemName the strGenItemName to set
	 */
	public void setStrGenItemName(String strGenItemName) {
		this.strGenItemName = strGenItemName;
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
	 * Gets the b exist status.
	 * 
	 * @return the bExistStatus
	 */
	public Boolean getBExistStatus() {
		return bExistStatus;
	}

	/**
	 * Sets the b exist status.
	 * 
	 * @param existStatus the bExistStatus to set
	 */
	public void setBExistStatus(Boolean existStatus) {
		bExistStatus = existStatus;
	}

	/**
	 * Gets the str rate unit name.
	 * 
	 * @return the strRateUnitName
	 */
	public String getStrRateUnitName() {
		return strRateUnitName;
	}

	/**
	 * Sets the str rate unit name.
	 * 
	 * @param strRateUnitName the strRateUnitName to set
	 */
	public void setStrRateUnitName(String strRateUnitName) {
		this.strRateUnitName = strRateUnitName;
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

	public String getStrBrandReserveFlag() {
		return strBrandReserveFlag;
	}

	public void setStrBrandReserveFlag(String strBrandReserveFlag) {
		this.strBrandReserveFlag = strBrandReserveFlag;
	}

	/**
	 * @param strBrandReserveStatus the strBrandReserveStatus to set
	 */
	public void setStrBrandReserveStatus(String strBrandReserveStatus) {
		this.strBrandReserveStatus = strBrandReserveStatus;
	}

	/**
	 * @return the strBrandReserveStatus
	 */
	public String getStrBrandReserveStatus() {
		return strBrandReserveStatus;
	}

	/**
	 * @param strGenericItemCode the strGenericItemCode to set
	 */
	public void setStrGenericItemCode(String strGenericItemCode) {
		StrGenericItemCode = strGenericItemCode;
	}

	/**
	 * @return the strGenericItemCode
	 */
	public String getStrGenericItemCode() {
		return StrGenericItemCode;
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

	public String getStrSterilizationFlag() {
		return strSterilizationFlag;
	}

	public void setStrSterilizationFlag(String strSterilizationFlag) {
		this.strSterilizationFlag = strSterilizationFlag;
	}

	public String getStrSterilizationLife() {
		return strSterilizationLife;
	}

	public void setStrSterilizationLife(String strSterilizationLife) {
		this.strSterilizationLife = strSterilizationLife;
	}

	public String getStrUploadFlag() {
		return strUploadFlag;
	}

	public void setStrUploadFlag(String strUploadFlag) {
		this.strUploadFlag = strUploadFlag;
	}

	/*
	 * public FormFile getStrLocation() { return strLocation; }
	 * 
	 * public void setStrLocation(FormFile strLocation) { this.strLocation =
	 * strLocation; }
	 */

	public String getStrFileNo() {
		return strFileNo;
	}

	public void setStrFileNo(String strFileNo) {
		this.strFileNo = strFileNo;
	}

	public String getStrPageNo() {
		return strPageNo;
	}

	public void setStrPageNo(String strPageNo) {
		this.strPageNo = strPageNo;
	}

	public String getStrFileName() {
		return strFileName;
	}

	public void setStrFileName(String strFileName) {
		this.strFileName = strFileName;
	}

	public String getStrUploadFileId() {
		return strUploadFileId;
	}

	public void setStrUploadFileId(String strUploadFileId) {
		this.strUploadFileId = strUploadFileId;
	}

	public String getStrUploadFileName() {
		return strUploadFileName;
	}

	public void setStrUploadFileName(String strUploadFileName) {
		this.strUploadFileName = strUploadFileName;
	}

	public String getStrSerialNo() {
		return strSerialNo;
	}

	public void setStrSerialNo(String strSerialNo) {
		this.strSerialNo = strSerialNo;
	}
	
	
	

}
