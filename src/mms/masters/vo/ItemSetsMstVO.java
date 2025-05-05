package mms.masters.vo;

import hisglobal.utility.TransferObject;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemSetsMstVO.
 */
public class ItemSetsMstVO implements TransferObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The str set id. */
	private String strSetId = "0";
	
	/** The str dummy combo. */
	private String strDummyCombo = "";
	
	/** The str set name. */
	private String strSetName = "";
	
	/** The str item id. */
	private String strItemId = "";
	
	/** The str item brand id. */
	private String strItemBrandId = "";
	
	/** The str set sl no. */
	private String strSetSlNo = "";
	
	/** The str item name. */
	private String strItemName = "";
	
	/** The str item brand name. */
	private String strItemBrandName = "";
	
	/** The str item quantity. */
	private String strItemQuantity = "";
	
	/** The str unit id. */
	private String strUnitId = "0";
	
	/** The str unit name. */
	private String strUnitName = "";
	
	/** The str item category no. */
	private String strItemCategoryNo = "";
	
	/** The str item category name. */
	private String strItemCategoryName = "";
	
	/** The str set category name. */
	private String strSetCategoryName = "";
	
	/** The str group id. */
	private String strGroupId = "0";
	
	/** The str group name. */
	private String strGroupName = "";
	
	/** The str sub group id. */
	private String strSubGroupId = "0";
	
	/** The str sub group name. */
	private String strSubGroupName = "";
	
	/** The str inventory unit id. */
	private String strInventoryUnitId = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str entry date. */
	private String strEntryDate = "";
	
	/** The str last modified date. */
	private String strLastModifiedDate = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str last modified seat id. */
	private String strLastModifiedSeatId = "";
	
	/** The str is valid. */
	private String strIsValid = "1";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str chk. */
	private String strChk = "";
	
	/** The str msg type. */
	private String strMsgType = "";
	
	/** The str msg string. */
	private String strMsgString = "";
	
	/** The str module id. */
	private String strModuleId = "0";
	
	/** The b exist status. */
	private Boolean bExistStatus = null;
	
	/** The str gen item name. */
	private String strGenItemName = "";
	
	/** The str gen item id. */
	private String strGenItemId = "";

	/** The str group combo. */
	private String strGroupCombo = "";
	
	/** The str sub group combo. */
	private String strSubGroupCombo = "";
	
	/** The str item name combo. */
	private String strItemNameCombo = "";
	
	/** The str unit name combo. */
	private String strUnitNameCombo = "";
	
	/** The str item brand combo. */
	private String strItemBrandCombo = "";

	/** The str group combo ws. */
	private WebRowSet strGroupComboWS = null;
	
	/** The str sub group combo ws. */
	private WebRowSet strSubGroupComboWS = null;
	
	/** The str item name combo ws. */
	private WebRowSet strItemNameComboWS = null;
	
	/** The str unit name combo ws. */
	private WebRowSet strUnitNameComboWS = null;
	
	/** The str item brand combo ws. */
	private WebRowSet strItemBrandComboWS = null;
	
	/** The str gen item name combo ws. */
	private WebRowSet strGenItemNameComboWS = null;
	
	/** The str item details. */
	private WebRowSet strItemDetails = null;
	
	/** The str unit values. */
	private String strUnitValues = "";
	
	/** The str unit. */
	private String strUnit = "";
	
	/** The str unit combo. */
	private String strUnitCombo = "";

	/** The str item cat combo. */
	private String strItemCatCombo = "";
	
	/** The str item cat combo ws. */
	private WebRowSet strItemCatComboWS = null;
	
	/** The str item cat id. */
	private String strItemCatId = "";
	
	/** The str item cat name. */
	private String strItemCatName = "";

	/** The str set cat no. */
	private String strSetCatNo = "";
	
	
	/*
	 * Generic Table Name of the item set
	 */
	private String genericTableName="";
	
	/*
	 * Item Table Name of the this item set
	 */
	private String itemTableName="";


	/**
	 * Gets the str unit.
	 * 
	 * @return the str unit
	 */
	public String getStrUnit() {
		/*
		 * HisUtil util = null; String temp1; try { ItemSetsMstBO bo=new
		 * ItemSetsMstBO(); bo.getUnitValues(this); util = new HisUtil("Item
		 * Sets Master", "ItemSetsMstVO");
		 * 
		 * temp1 = util.getOptionValue(this.getStrUnitNameComboWS(),
		 * this.getStrUnitId(),"0^Select Value", false);
		 * 
		 * //System.out.println("temp1-->"+temp1);
		 * 
		 * strUnit = temp1 ; } catch(Exception e) {
		 *  }
		 */
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
		/*
		 * HisUtil util = null; String temp1; try { ItemSetsMstBO bo=new
		 * ItemSetsMstBO(); bo.getUnitValues(this); util = new HisUtil("Item
		 * Sets Master", "ItemSetsMstVO");
		 * 
		 * temp1 = util.getOptionValue(this.getStrUnitNameComboWS(), "0",
		 * "0^Select Value", false); strUnitValues =temp1 ; } catch(Exception e) {
		 *  }
		 */
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
	 * Gets the str set id.
	 * 
	 * @return the str set id
	 */
	public String getStrSetId() {
		return strSetId;
	}

	/**
	 * Sets the str set id.
	 * 
	 * @param strSetId the new str set id
	 */
	public void setStrSetId(String strSetId) {
		this.strSetId = strSetId;
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
	 * Gets the str set sl no.
	 * 
	 * @return the str set sl no
	 */
	public String getStrSetSlNo() {
		return strSetSlNo;
	}

	/**
	 * Sets the str set sl no.
	 * 
	 * @param strSetSlNo the new str set sl no
	 */
	public void setStrSetSlNo(String strSetSlNo) {
		this.strSetSlNo = strSetSlNo;
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
	 * Gets the str item brand name.
	 * 
	 * @return the str item brand name
	 */
	public String getStrItemBrandName() {
		return strItemBrandName;
	}

	/**
	 * Sets the str item brand name.
	 * 
	 * @param strItemBrandName the new str item brand name
	 */
	public void setStrItemBrandName(String strItemBrandName) {
		this.strItemBrandName = strItemBrandName;
	}

	/**
	 * Gets the str item quantity.
	 * 
	 * @return the str item quantity
	 */
	public String getStrItemQuantity() {
		return strItemQuantity;
	}

	/**
	 * Sets the str item quantity.
	 * 
	 * @param strItemQuantity the new str item quantity
	 */
	public void setStrItemQuantity(String strItemQuantity) {
		this.strItemQuantity = strItemQuantity;
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
	 * Gets the str unit name.
	 * 
	 * @return the str unit name
	 */
	public String getStrUnitName() {
		return strUnitName;
	}

	/**
	 * Sets the str unit name.
	 * 
	 * @param strUnitName the new str unit name
	 */
	public void setStrUnitName(String strUnitName) {
		this.strUnitName = strUnitName;
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
	 * Gets the str remarks.
	 * 
	 * @return the str remarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks the new str remarks
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * Gets the str entry date.
	 * 
	 * @return the str entry date
	 */
	public String getStrEntryDate() {
		return strEntryDate;
	}

	/**
	 * Sets the str entry date.
	 * 
	 * @param strEntryDate the new str entry date
	 */
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}

	/**
	 * Gets the str last modified date.
	 * 
	 * @return the str last modified date
	 */
	public String getStrLastModifiedDate() {
		return strLastModifiedDate;
	}

	/**
	 * Sets the str last modified date.
	 * 
	 * @param strLastModifiedDate the new str last modified date
	 */
	public void setStrLastModifiedDate(String strLastModifiedDate) {
		this.strLastModifiedDate = strLastModifiedDate;
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
	 * Gets the str last modified seat id.
	 * 
	 * @return the str last modified seat id
	 */
	public String getStrLastModifiedSeatId() {
		return strLastModifiedSeatId;
	}

	/**
	 * Sets the str last modified seat id.
	 * 
	 * @param strLastModifiedSeatId the new str last modified seat id
	 */
	public void setStrLastModifiedSeatId(String strLastModifiedSeatId) {
		this.strLastModifiedSeatId = strLastModifiedSeatId;
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
	 * Gets the str item category name.
	 * 
	 * @return the str item category name
	 */
	public String getStrItemCategoryName() {
		return strItemCategoryName;
	}

	/**
	 * Sets the str item category name.
	 * 
	 * @param strItemCategoryName the new str item category name
	 */
	public void setStrItemCategoryName(String strItemCategoryName) {
		this.strItemCategoryName = strItemCategoryName;
	}

	/**
	 * Gets the str set name.
	 * 
	 * @return the str set name
	 */
	public String getStrSetName() {
		return strSetName;
	}

	/**
	 * Sets the str set name.
	 * 
	 * @param strSetName the new str set name
	 */
	public void setStrSetName(String strSetName) {
		this.strSetName = strSetName;
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
	 * Gets the str sub group name.
	 * 
	 * @return the str sub group name
	 */
	public String getStrSubGroupName() {
		return strSubGroupName;
	}

	/**
	 * Sets the str sub group name.
	 * 
	 * @param strSubGroupName the new str sub group name
	 */
	public void setStrSubGroupName(String strSubGroupName) {
		this.strSubGroupName = strSubGroupName;
	}

	/**
	 * Gets the str group combo.
	 * 
	 * @return the str group combo
	 */
	public String getStrGroupCombo() {
		return strGroupCombo;
	}

	/**
	 * Sets the str group combo.
	 * 
	 * @param strGroupCombo the new str group combo
	 */
	public void setStrGroupCombo(String strGroupCombo) {
		this.strGroupCombo = strGroupCombo;
	}

	/**
	 * Gets the str group combo ws.
	 * 
	 * @return the str group combo ws
	 */
	public WebRowSet getStrGroupComboWS() {
		return strGroupComboWS;
	}

	/**
	 * Sets the str group combo ws.
	 * 
	 * @param strGroupComboWS the new str group combo ws
	 */
	public void setStrGroupComboWS(WebRowSet strGroupComboWS) {
		this.strGroupComboWS = strGroupComboWS;
	}

	/**
	 * Gets the str sub group combo.
	 * 
	 * @return the str sub group combo
	 */
	public String getStrSubGroupCombo() {
		return strSubGroupCombo;
	}

	/**
	 * Sets the str sub group combo.
	 * 
	 * @param strSubGroupCombo the new str sub group combo
	 */
	public void setStrSubGroupCombo(String strSubGroupCombo) {
		this.strSubGroupCombo = strSubGroupCombo;
	}

	/**
	 * Gets the str sub group combo ws.
	 * 
	 * @return the str sub group combo ws
	 */
	public WebRowSet getStrSubGroupComboWS() {
		return strSubGroupComboWS;
	}

	/**
	 * Sets the str sub group combo ws.
	 * 
	 * @param strSubGroupComboWS the new str sub group combo ws
	 */
	public void setStrSubGroupComboWS(WebRowSet strSubGroupComboWS) {
		this.strSubGroupComboWS = strSubGroupComboWS;
	}

	/**
	 * Gets the str item name combo.
	 * 
	 * @return the str item name combo
	 */
	public String getStrItemNameCombo() {
		return strItemNameCombo;
	}

	/**
	 * Sets the str item name combo.
	 * 
	 * @param strItemNameCombo the new str item name combo
	 */
	public void setStrItemNameCombo(String strItemNameCombo) {
		this.strItemNameCombo = strItemNameCombo;
	}

	/**
	 * Gets the str unit name combo.
	 * 
	 * @return the str unit name combo
	 */
	public String getStrUnitNameCombo() {
		return strUnitNameCombo;
	}

	/**
	 * Sets the str unit name combo.
	 * 
	 * @param strUnitNameCombo the new str unit name combo
	 */
	public void setStrUnitNameCombo(String strUnitNameCombo) {
		this.strUnitNameCombo = strUnitNameCombo;
	}

	/**
	 * Gets the str item name combo ws.
	 * 
	 * @return the str item name combo ws
	 */
	public WebRowSet getStrItemNameComboWS() {
		return strItemNameComboWS;
	}

	/**
	 * Sets the str item name combo ws.
	 * 
	 * @param strItemNameComboWS the new str item name combo ws
	 */
	public void setStrItemNameComboWS(WebRowSet strItemNameComboWS) {
		this.strItemNameComboWS = strItemNameComboWS;
	}

	/**
	 * Gets the str unit name combo ws.
	 * 
	 * @return the str unit name combo ws
	 */
	public WebRowSet getStrUnitNameComboWS() {
		return strUnitNameComboWS;
	}

	/**
	 * Sets the str unit name combo ws.
	 * 
	 * @param strUnitNameComboWS the new str unit name combo ws
	 */
	public void setStrUnitNameComboWS(WebRowSet strUnitNameComboWS) {
		this.strUnitNameComboWS = strUnitNameComboWS;
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
	 * Gets the str item details.
	 * 
	 * @return the str item details
	 */
	public WebRowSet getStrItemDetails() {
		return strItemDetails;
	}

	/**
	 * Sets the str item details.
	 * 
	 * @param strItemDetails the new str item details
	 */
	public void setStrItemDetails(WebRowSet strItemDetails) {
		this.strItemDetails = strItemDetails;
	}

	/**
	 * Gets the str dummy combo.
	 * 
	 * @return the str dummy combo
	 */
	public String getStrDummyCombo() {
		return strDummyCombo;
	}

	/**
	 * Sets the str dummy combo.
	 * 
	 * @param strDummyCombo the new str dummy combo
	 */
	public void setStrDummyCombo(String strDummyCombo) {
		this.strDummyCombo = strDummyCombo;
	}

	/**
	 * Gets the str unit combo.
	 * 
	 * @return the str unit combo
	 */
	public String getStrUnitCombo() {
		return strUnitCombo;
	}

	/**
	 * Sets the str unit combo.
	 * 
	 * @param strUnitCombo the new str unit combo
	 */
	public void setStrUnitCombo(String strUnitCombo) {
		this.strUnitCombo = strUnitCombo;
	}

	/**
	 * Gets the str item brand combo.
	 * 
	 * @return the str item brand combo
	 */
	public String getStrItemBrandCombo() {
		return strItemBrandCombo;
	}

	/**
	 * Sets the str item brand combo.
	 * 
	 * @param strItemBrandCombo the new str item brand combo
	 */
	public void setStrItemBrandCombo(String strItemBrandCombo) {
		this.strItemBrandCombo = strItemBrandCombo;
	}

	/**
	 * Gets the str item brand combo ws.
	 * 
	 * @return the str item brand combo ws
	 */
	public WebRowSet getStrItemBrandComboWS() {
		return strItemBrandComboWS;
	}

	/**
	 * Sets the str item brand combo ws.
	 * 
	 * @param strItemBrandComboWS the new str item brand combo ws
	 */
	public void setStrItemBrandComboWS(WebRowSet strItemBrandComboWS) {
		this.strItemBrandComboWS = strItemBrandComboWS;
	}

	/**
	 * Gets the str item cat combo.
	 * 
	 * @return the str item cat combo
	 */
	public String getStrItemCatCombo() {
		return strItemCatCombo;
	}

	/**
	 * Sets the str item cat combo.
	 * 
	 * @param strItemCatCombo the new str item cat combo
	 */
	public void setStrItemCatCombo(String strItemCatCombo) {
		this.strItemCatCombo = strItemCatCombo;
	}

	/**
	 * Gets the str item cat combo ws.
	 * 
	 * @return the str item cat combo ws
	 */
	public WebRowSet getStrItemCatComboWS() {
		return strItemCatComboWS;
	}

	/**
	 * Sets the str item cat combo ws.
	 * 
	 * @param strItemCatComboWS the new str item cat combo ws
	 */
	public void setStrItemCatComboWS(WebRowSet strItemCatComboWS) {
		this.strItemCatComboWS = strItemCatComboWS;
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
	 * Gets the str set cat no.
	 * 
	 * @return the str set cat no
	 */
	public String getStrSetCatNo() {
		return strSetCatNo;
	}

	/**
	 * Sets the str set cat no.
	 * 
	 * @param strSetCatNo the new str set cat no
	 */
	public void setStrSetCatNo(String strSetCatNo) {
		this.strSetCatNo = strSetCatNo;
	}

	/**
	 * Gets the str set category name.
	 * 
	 * @return the str set category name
	 */
	public String getStrSetCategoryName() {
		return strSetCategoryName;
	}

	/**
	 * Sets the str set category name.
	 * 
	 * @param strSetCategoryName the new str set category name
	 */
	public void setStrSetCategoryName(String strSetCategoryName) {
		this.strSetCategoryName = strSetCategoryName;
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
	 * Gets the str gen item name combo ws.
	 * 
	 * @return the strGenItemNameComboWS
	 */
	public WebRowSet getStrGenItemNameComboWS() {
		return strGenItemNameComboWS;
	}

	/**
	 * Sets the str gen item name combo ws.
	 * 
	 * @param strGenItemNameComboWS the strGenItemNameComboWS to set
	 */
	public void setStrGenItemNameComboWS(WebRowSet strGenItemNameComboWS) {
		this.strGenItemNameComboWS = strGenItemNameComboWS;
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
	 * @return the genericTableName
	 */
	public String getGenericTableName() {
		return genericTableName;
	}

	/**
	 * @param genericTableName the genericTableName to set
	 */
	public void setGenericTableName(String genericTableName) {
		this.genericTableName = genericTableName;
	}

	/**
	 * @return the itemTableName
	 */
	public String getItemTableName() {
		return itemTableName;
	}

	/**
	 * @param itemTableName the itemTableName to set
	 */
	public void setItemTableName(String itemTableName) {
		this.itemTableName = itemTableName;
	}

}
