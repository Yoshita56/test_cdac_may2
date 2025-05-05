package mms.masters.controller.fb;

import hisglobal.masterutil.GenericFormBean;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * The Class SparePartsMstFB.
 */
public class SparePartsMstFB extends GenericFormBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** *******************************. */
	private String strItemCategory = "";
	
	/** The str item category combo. */
	private String strItemCategoryCombo = "";
	
	/** The str item name. */
	private String strItemName = "";
	
	/** The str item sl no. */
	private String strItemSlNo = "";
	
	/** The str item quantity. */
	private String strItemQuantity = "";
	
	/** The str unit id. */
	private String strUnitId = "0";
	
	/** The str unit name. */
	private String strUnitName = "";
	
	/** The str is valid. */
	private String strIsValid = "";

	/** The str item id. */
	private String strItemId = "";
	
	/** The str spare part item id. */
	private String strSparePartItemId = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str spare parts mst hlp. */
	private String strSparePartsMstHLP = "";
	
	/** The str item catg no. */
	private String strItemCatgNo = "";
	
	/** The str item catg name. */
	private String strItemCatgName = "";
	
	/** The str spare parts name. */
	private String[] strSparePartsName = { "0" };
	
	/** The str spare part category name. */
	private String strSparePartCategoryName = "";
	
	/** The str spare part item name. */
	private String strSparePartItemName = "";
	
	/** The str spare pat category no. */
	private String strSparePatCategoryNo = "";
	
	/** The str spare part id. */
	private String strSparePartId = "";

	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str s part name. */
	private String strSPartName = "";
	
	/** The str combo values. */
	private String strComboValues = "";
	
	/** The str group id. */
	private String strGroupId = "0";
	
	/** The str group name. */
	private String strGroupName = "";
	
	/** The str sub group id. */
	private String strSubGroupId = "0";
	
	/** The str sub group name. */
	private String strSubGroupName = "";
	
	/** The str module id. */
	private String strModuleId = "";
	
	/** *********************************. */

	private String strErr = "";
	
	/** The str msg. */
	private String strMsg = "";
	
	/** The str warning. */
	private String strWarning = "";

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str ct date. */
	private String strCtDate = "";
	
	/** The str chk1. */
	private String strChk1 = "";

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
	
	/** The str previous spare part dtl. */
	private String strPreviousSparePartDtl = "";
	
	/** The str spare part catg combo. */
	private String strSparePartCatgCombo = "";

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
	
	/** The str spare part dtl ws. */
	private WebRowSet strSparePartDtlWs = null;
	
	/** The str spare part catg combo ws. */
	private WebRowSet strSparePartCatgComboWS = null;

	/**
	 * Gets the str ct date.
	 * 
	 * @return the str ct date
	 */
	public String getStrCtDate() {
		return strCtDate;
	}

	/**
	 * Gets the str err.
	 * 
	 * @return the str err
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * Sets the str err.
	 * 
	 * @param strErr the new str err
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

	/**
	 * Gets the str msg.
	 * 
	 * @return the str msg
	 */
	public String getStrMsg() {
		return strMsg;
	}

	/**
	 * Sets the str msg.
	 * 
	 * @param strMsg the new str msg
	 */
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}

	/**
	 * Gets the str warning.
	 * 
	 * @return the str warning
	 */
	public String getStrWarning() {
		return strWarning;
	}

	/**
	 * Sets the str warning.
	 * 
	 * @param strWarning the new str warning
	 */
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
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
	 * Gets the str chk1.
	 * 
	 * @return the str chk1
	 */
	public String getStrChk1() {
		return strChk1;
	}

	/**
	 * Sets the str chk1.
	 * 
	 * @param strChk1 the new str chk1
	 */
	public void setStrChk1(String strChk1) {
		this.strChk1 = strChk1;
	}

	/**
	 * Gets the str item category.
	 * 
	 * @return the str item category
	 */
	public String getStrItemCategory() {
		return strItemCategory;
	}

	/**
	 * Sets the str item category.
	 * 
	 * @param strItemCategory the new str item category
	 */
	public void setStrItemCategory(String strItemCategory) {
		this.strItemCategory = strItemCategory;
	}

	/**
	 * Gets the str item category combo.
	 * 
	 * @return the str item category combo
	 */
	public String getStrItemCategoryCombo() {
		return strItemCategoryCombo;
	}

	/**
	 * Sets the str item category combo.
	 * 
	 * @param strItemCategoryCombo the new str item category combo
	 */
	public void setStrItemCategoryCombo(String strItemCategoryCombo) {
		this.strItemCategoryCombo = strItemCategoryCombo;
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
	 * Gets the str previous spare part dtl.
	 * 
	 * @return the str previous spare part dtl
	 */
	public String getStrPreviousSparePartDtl() {
		return strPreviousSparePartDtl;
	}

	/**
	 * Sets the str previous spare part dtl.
	 * 
	 * @param strPreviousSparePartDtl the new str previous spare part dtl
	 */
	public void setStrPreviousSparePartDtl(String strPreviousSparePartDtl) {
		this.strPreviousSparePartDtl = strPreviousSparePartDtl;
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
	 * Gets the str spare part dtl ws.
	 * 
	 * @return the str spare part dtl ws
	 */
	public WebRowSet getStrSparePartDtlWs() {
		return strSparePartDtlWs;
	}

	/**
	 * Sets the str spare part dtl ws.
	 * 
	 * @param strSparePartDtlWs the new str spare part dtl ws
	 */
	public void setStrSparePartDtlWs(WebRowSet strSparePartDtlWs) {
		this.strSparePartDtlWs = strSparePartDtlWs;
	}

	/**
	 * Gets the str spare parts mst hlp.
	 * 
	 * @return the str spare parts mst hlp
	 */
	public String getStrSparePartsMstHLP() {
		return strSparePartsMstHLP;
	}

	/**
	 * Sets the str spare parts mst hlp.
	 * 
	 * @param strSparePartsMstHLP the new str spare parts mst hlp
	 */
	public void setStrSparePartsMstHLP(String strSparePartsMstHLP) {
		this.strSparePartsMstHLP = strSparePartsMstHLP;
	}

	/**
	 * Gets the str spare parts name.
	 * 
	 * @return the str spare parts name
	 */
	public String[] getStrSparePartsName() {
		return strSparePartsName;
	}

	/**
	 * Sets the str spare parts name.
	 * 
	 * @param strSparePartsName the new str spare parts name
	 */
	public void setStrSparePartsName(String[] strSparePartsName) {
		this.strSparePartsName = strSparePartsName;
	}

	/**
	 * Gets the str item catg no.
	 * 
	 * @return the str item catg no
	 */
	public String getStrItemCatgNo() {
		return strItemCatgNo;
	}

	/**
	 * Sets the str item catg no.
	 * 
	 * @param strItemCatgNo the new str item catg no
	 */
	public void setStrItemCatgNo(String strItemCatgNo) {
		this.strItemCatgNo = strItemCatgNo;
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
	 * Gets the str s part name.
	 * 
	 * @return the str s part name
	 */
	public String getStrSPartName() {
		return strSPartName;
	}

	/**
	 * Sets the str s part name.
	 * 
	 * @param strSPartName the new str s part name
	 */
	public void setStrSPartName(String strSPartName) {
		this.strSPartName = strSPartName;
	}

	/**
	 * Sets the str ct date.
	 * 
	 * @param strCtDate the new str ct date
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}

	/**
	 * Gets the str combo values.
	 * 
	 * @return the str combo values
	 */
	public String getStrComboValues() {
		return strComboValues;
	}

	/**
	 * Sets the str combo values.
	 * 
	 * @param strComboValues the new str combo values
	 */
	public void setStrComboValues(String strComboValues) {
		this.strComboValues = strComboValues;
	}

	/**
	 * Gets the str item catg name.
	 * 
	 * @return the str item catg name
	 */
	public String getStrItemCatgName() {
		return strItemCatgName;
	}

	/**
	 * Sets the str item catg name.
	 * 
	 * @param strItemCatgName the new str item catg name
	 */
	public void setStrItemCatgName(String strItemCatgName) {
		this.strItemCatgName = strItemCatgName;
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
	 * Gets the str item sl no.
	 * 
	 * @return the str item sl no
	 */
	public String getStrItemSlNo() {
		return strItemSlNo;
	}

	/**
	 * Sets the str item sl no.
	 * 
	 * @param strItemSlNo the new str item sl no
	 */
	public void setStrItemSlNo(String strItemSlNo) {
		this.strItemSlNo = strItemSlNo;
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
	 * Gets the str spare pat category no.
	 * 
	 * @return the str spare pat category no
	 */
	public String getStrSparePatCategoryNo() {
		return strSparePatCategoryNo;
	}

	/**
	 * Sets the str spare pat category no.
	 * 
	 * @param strSparePatCategoryNo the new str spare pat category no
	 */
	public void setStrSparePatCategoryNo(String strSparePatCategoryNo) {
		this.strSparePatCategoryNo = strSparePatCategoryNo;
	}

	/**
	 * Gets the str spare part catg combo.
	 * 
	 * @return the str spare part catg combo
	 */
	public String getStrSparePartCatgCombo() {
		return strSparePartCatgCombo;
	}

	/**
	 * Sets the str spare part catg combo.
	 * 
	 * @param strSparePartCatgCombo the new str spare part catg combo
	 */
	public void setStrSparePartCatgCombo(String strSparePartCatgCombo) {
		this.strSparePartCatgCombo = strSparePartCatgCombo;
	}

	/**
	 * Gets the str spare part catg combo ws.
	 * 
	 * @return the str spare part catg combo ws
	 */
	public WebRowSet getStrSparePartCatgComboWS() {
		return strSparePartCatgComboWS;
	}

	/**
	 * Sets the str spare part catg combo ws.
	 * 
	 * @param strSparePartCatgComboWS the new str spare part catg combo ws
	 */
	public void setStrSparePartCatgComboWS(WebRowSet strSparePartCatgComboWS) {
		this.strSparePartCatgComboWS = strSparePartCatgComboWS;
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
	 * Gets the str spare part id.
	 * 
	 * @return the str spare part id
	 */
	public String getStrSparePartId() {
		return strSparePartId;
	}

	/**
	 * Sets the str spare part id.
	 * 
	 * @param strSparePartId the new str spare part id
	 */
	public void setStrSparePartId(String strSparePartId) {
		this.strSparePartId = strSparePartId;
	}

	/**
	 * Gets the str spare part item id.
	 * 
	 * @return the str spare part item id
	 */
	public String getStrSparePartItemId() {
		return strSparePartItemId;
	}

	/**
	 * Sets the str spare part item id.
	 * 
	 * @param strSparePartItemId the new str spare part item id
	 */
	public void setStrSparePartItemId(String strSparePartItemId) {
		this.strSparePartItemId = strSparePartItemId;
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
	 * Gets the str spare part category name.
	 * 
	 * @return the str spare part category name
	 */
	public String getStrSparePartCategoryName() {
		return strSparePartCategoryName;
	}

	/**
	 * Sets the str spare part category name.
	 * 
	 * @param strSparePartCategoryName the new str spare part category name
	 */
	public void setStrSparePartCategoryName(String strSparePartCategoryName) {
		this.strSparePartCategoryName = strSparePartCategoryName;
	}

	/**
	 * Gets the str spare part item name.
	 * 
	 * @return the str spare part item name
	 */
	public String getStrSparePartItemName() {
		return strSparePartItemName;
	}

	/**
	 * Sets the str spare part item name.
	 * 
	 * @param strSparePartItemName the new str spare part item name
	 */
	public void setStrSparePartItemName(String strSparePartItemName) {
		this.strSparePartItemName = strSparePartItemName;
	}
}
