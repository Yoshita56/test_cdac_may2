package mms.masters.controller.fb;

import hisglobal.masterutil.GenericFormBean;

// TODO: Auto-generated Javadoc
/**
 * The Class GenericDrugMstFB.
 */
public class CIMSGenericDrugMstFB extends GenericFormBean {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The str norm mssgstring. */
	private String strNormMssgstring = "";
	
	/** The str warn mssgstring. */
	private String strWarnMssgstring = "";
	
	/** The str err mssgstring. */
	private String strErrMssgstring = "";
	
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
	
	/** The str item type. */
	private String strItemType = "";
	
	/** The str drug name. */
	private String strDrugName = "";
	
	/** The str default rate. */
	private String strDefaultRate = "";
	
	/** The str batch no. */
	private String strBatchNo = "0";
	
	/** The str expiry date. */
	private String strExpiryDate = "0";
	
	/** The str purchase lead time. */
	private String strPurchaseLeadTime = "";
	
	/** The str time format. */
	private String strTimeFormat = "";
	
	/** The str stock maintain. */
	private String strStockMaintain = "0";
	
	/** The str shelf life. */
	private String strShelfLife = "";
	
	/** The str shelf time format. */
	private String strShelfTimeFormat = "0";
	
	/** The str approved by. */
	private String strApprovedBy = "";
	
	/** The str issue type. */
	private String strIssueType = "";
	
	/** The str consumable type. */
	private String strConsumableType = "";
	
	/** The str is item sachet. */
	private String strIsItemSachet = "0";
	
	/** The str is item narcotic. */
	private String strIsItemNarcotic = "0";
	
	/** The str unit values. */
	private String strUnitValues = "";
	
	/** The str stock maintained values. */
	private String strStockMaintainedValues = "";
	
	/** The str manufacturer values. */
	private String strManufacturerValues = "";
	
	/** The str item type values. */
	private String strItemTypeValues = "";
	
	/** The str module id. */
	private String strModuleId = "0";
	
	/** The combo1. */
	private String combo1[] = null;
	
	/** The str group name value. */
	private String strGroupNameValue = "";
	
	/** The str sub group name value. */
	private String strSubGroupNameValue = "";
	
	/** The combo value1. */
	private String comboValue1 = "";
	
	/** The str unit. */
	private String strUnit = "";
	
	/** The str group id. */
	private String strGroupId = "0";
	
	/** The str sub group id. */
	private String strSubGroupId = "0";
	
	/** The str unit values modi. */
	private String strUnitValuesModi = "";
	
	/** The str item type values modi. */
	private String strItemTypeValuesModi = "";
	
	/** The str stock maintained values modi. */
	private String strStockMaintainedValuesModi = "";
	
	/** The str brand item dtl values. */
	private String strBrandItemDtlValues = "";
	
	/** The str brand name. */
	private String strBrandName[] = null;
	
	/** The str branded manufacturer. */
	private String strBrandedManufacturer[] = null;
	
	/** The str branded rate. */
	private String strBrandedRate[] = null;
	
	/** The str branded unit. */
	private String strBrandedUnit[] = null;
	
	/** The str branded approved by. */
	private String strBrandedApprovedBy[] = null;
	
	/** The str branded issue type. */
	private String strBrandedIssueType[] = null;
	
	/** The str branded item maker. */
	private String strBrandedItemMaker[] = null;
	// private String strBrandedItemStatus[]=null;
	/** The str modify. */
	private String strModify[] = null;
	
	/** The primary key brand item. */
	private String primaryKeyBrandItem[] = null;
	
	/** The str count. */
	private String strCount = "";
	
	/** The check row. */
	private String[] checkRow = null;
	
	/** The str stock update. */
	private String strStockUpdate = "";
	
	/** The str consent req. */
	private String strConsentReq = "0";
	
	private String strCPACode="";

	private String strInventoryUnitName = "";
	
	private String strIsItemCodeRequired  = "0";
	
	private String strItemCatNo="";
	
	

	/*Aritra*/
	private String strPregnancySafeFlag ="";
	private String strTrimester ="";
	private String strEffectsOnFoetus ="";
	private String strStockMaintainedCode="";
	private String strMsgType="";
	
	private String strAtcClassCode="";
	
	private String strPregCatCode="";
	
	private String strContraindictioncode="";
	
	private String strDrugAdmincode="";
	
	private String strStoragecode="";
	
	private String strbatchnoreq="";
	
	private String strinvunitid="";
	
	private String strshelflifeunit="";
	
	private String strdosageadult="";
	
	private String strsprecau="";
	
	private String stradvdrug="";
	
	private String strmechact="";
	private String strlabintfrnce="";
	
	private String strExpiryDatereq = "";
	
	private String strDrugval="";
	private String strAdminRoute="";
	private String strContradictoryDrugArray[]=null;
	private String strBrand="";
	
	private String strdosagepeads="";
	private String strContradictoryDrugIdArray[]=null;
	private String strDrugIdval="";
	
	public String getStrDrugIdval() {
		return strDrugIdval;
	}

	public void setStrDrugIdval(String strDrugIdval) {
		this.strDrugIdval = strDrugIdval;
	}

	public String[] getStrContradictoryDrugIdArray() {
		return strContradictoryDrugIdArray;
	}

	public void setStrContradictoryDrugIdArray(String[] strContradictoryDrugIdArray) {
		this.strContradictoryDrugIdArray = strContradictoryDrugIdArray;
	}

	public String getStrdosagepeads() {
		return strdosagepeads;
	}

	public void setStrdosagepeads(String strdosagepeads) {
		this.strdosagepeads = strdosagepeads;
	}
	
	public String getStrBrand() {
		return strBrand;
	}

	public void setStrBrand(String strBrand) {
		this.strBrand = strBrand;
	}

	public String[] getStrContradictoryDrugArray() {
		return strContradictoryDrugArray;
	}

	public void setStrContradictoryDrugArray(String[] strContradictoryDrugArray) {
		this.strContradictoryDrugArray = strContradictoryDrugArray;
	}

	public String getStrAdminRoute() {
		return strAdminRoute;
	}

	public void setStrAdminRoute(String strAdminRoute) {
		this.strAdminRoute = strAdminRoute;
	}

	public String getStrDrugval() {
		return strDrugval;
	}

	public void setStrDrugval(String strDrugval) {
		this.strDrugval = strDrugval;
	}

	public String getStrExpiryDatereq() {
		return strExpiryDatereq;
	}

	public void setStrExpiryDatereq(String strExpiryDatereq) {
		this.strExpiryDatereq = strExpiryDatereq;
	}

	public String getStrinvunitid() {
		return strinvunitid;
	}

	public void setStrinvunitid(String strinvunitid) {
		this.strinvunitid = strinvunitid;
	}

	public String getStrshelflifeunit() {
		return strshelflifeunit;
	}

	public void setStrshelflifeunit(String strshelflifeunit) {
		this.strshelflifeunit = strshelflifeunit;
	}

	public String getStrdosageadult() {
		return strdosageadult;
	}

	public void setStrdosageadult(String strdosageadult) {
		this.strdosageadult = strdosageadult;
	}

	public String getStrsprecau() {
		return strsprecau;
	}

	public void setStrsprecau(String strsprecau) {
		this.strsprecau = strsprecau;
	}

	public String getStradvdrug() {
		return stradvdrug;
	}

	public void setStradvdrug(String stradvdrug) {
		this.stradvdrug = stradvdrug;
	}

	public String getStrmechact() {
		return strmechact;
	}

	public void setStrmechact(String strmechact) {
		this.strmechact = strmechact;
	}

	public String getStrlabintfrnce() {
		return strlabintfrnce;
	}

	public void setStrlabintfrnce(String strlabintfrnce) {
		this.strlabintfrnce = strlabintfrnce;
	}

	public String getStrbatchnoreq() {
		return strbatchnoreq;
	}

	public void setStrbatchnoreq(String strbatchnoreq) {
		this.strbatchnoreq = strbatchnoreq;
	}

	public String getStrDrugAdmincode() {
		return strDrugAdmincode;
	}

	public void setStrDrugAdmincode(String strDrugAdmincode) {
		this.strDrugAdmincode = strDrugAdmincode;
	}

	public String getStrStoragecode() {
		return strStoragecode;
	}

	public void setStrStoragecode(String strStoragecode) {
		this.strStoragecode = strStoragecode;
	}

	public String getStrContraindictioncode() {
		return strContraindictioncode;
	}

	public void setStrContraindictioncode(String strContraindictioncode) {
		this.strContraindictioncode = strContraindictioncode;
	}

	public String getStrPregCatCode() {
		return strPregCatCode;
	}

	public void setStrPregCatCode(String strPregCatCode) {
		this.strPregCatCode = strPregCatCode;
	}

	public String getStrAtcClassCode() {
		return strAtcClassCode;
	}

	public void setStrAtcClassCode(String strAtcClassCode) {
		this.strAtcClassCode = strAtcClassCode;
	}

	public String getStrItemCatNo() {
		return strItemCatNo;
	}

	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}
	
	public String getStrMsgType() {
		return strMsgType;
	}

	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	public String getStrStockMaintainedCode() {
		return strStockMaintainedCode;
	}

	public void setStrStockMaintainedCode(String strStockMaintainedCode) {
		this.strStockMaintainedCode = strStockMaintainedCode;
	}

	public String getStrPregnancySafeFlag() {
		return strPregnancySafeFlag;
	}

	public void setStrPregnancySafeFlag(String strPregnancySafeFlag) {
		this.strPregnancySafeFlag = strPregnancySafeFlag;
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
	 * Gets the str stock update.
	 * 
	 * @return the str stock update
	 */
	public String getStrStockUpdate() {
		return strStockUpdate;
	}

	/**
	 * Sets the str stock update.
	 * 
	 * @param strStockUpdate the new str stock update
	 */
	public void setStrStockUpdate(String strStockUpdate) {
		this.strStockUpdate = strStockUpdate;
	}

	/**
	 * Gets the check row.
	 * 
	 * @return the check row
	 */
	public String[] getCheckRow() {
		return checkRow;
	}

	/**
	 * Sets the check row.
	 * 
	 * @param checkRow the new check row
	 */
	public void setCheckRow(String[] checkRow) {
		this.checkRow = checkRow;
	}

	/**
	 * Gets the str modify.
	 * 
	 * @return the str modify
	 */
	public String[] getStrModify() {
		return strModify;
	}

	/**
	 * Sets the str modify.
	 * 
	 * @param strModify the new str modify
	 */
	public void setStrModify(String[] strModify) {
		this.strModify = strModify;
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
	 * Gets the combo1.
	 * 
	 * @return the combo1
	 */
	public String[] getCombo1() {
		return combo1;
	}

	/**
	 * Sets the combo1.
	 * 
	 * @param combo1 the combo1 to set
	 */
	public void setCombo1(String[] combo1) {
		this.combo1 = combo1;
	}

	/**
	 * Gets the combo value1.
	 * 
	 * @return the comboValue1
	 */
	public String getComboValue1() {
		return comboValue1;
	}

	/**
	 * Sets the combo value1.
	 * 
	 * @param comboValue1 the comboValue1 to set
	 */
	public void setComboValue1(String comboValue1) {
		this.comboValue1 = comboValue1;
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
	 * Gets the str current date.
	 * 
	 * @return the str current date
	 */
	public String getStrCurrentDate() {
		return strCurrentDate;
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
	 * Gets the str norm mssgstring.
	 * 
	 * @return the str norm mssgstring
	 */
	public String getStrNormMssgstring() {
		return strNormMssgstring;
	}

	/**
	 * Sets the str norm mssgstring.
	 * 
	 * @param strNormMssgstring the new str norm mssgstring
	 */
	public void setStrNormMssgstring(String strNormMssgstring) {
		this.strNormMssgstring = strNormMssgstring;
	}

	/**
	 * Gets the str warn mssgstring.
	 * 
	 * @return the str warn mssgstring
	 */
	public String getStrWarnMssgstring() {
		return strWarnMssgstring;
	}

	/**
	 * Sets the str warn mssgstring.
	 * 
	 * @param strWarnMssgstring the new str warn mssgstring
	 */
	public void setStrWarnMssgstring(String strWarnMssgstring) {
		this.strWarnMssgstring = strWarnMssgstring;
	}

	/**
	 * Gets the str err mssgstring.
	 * 
	 * @return the str err mssgstring
	 */
	public String getStrErrMssgstring() {
		return strErrMssgstring;
	}

	/**
	 * Sets the str err mssgstring.
	 * 
	 * @param strErrMssgstring the new str err mssgstring
	 */
	public void setStrErrMssgstring(String strErrMssgstring) {
		this.strErrMssgstring = strErrMssgstring;
	}

	/**
	 * Gets the str hosp code.
	 * 
	 * @return the str hosp code
	 */
	public String getStrHospCode() {
		return strHospCode;
	}

	/**
	 * Sets the str hosp code.
	 * 
	 * @param strHospCode the new str hosp code
	 */
	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
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
	 * Gets the str batch no.
	 * 
	 * @return the str batch no
	 */
	public String getStrBatchNo() {
		return strBatchNo;
	}

	/**
	 * Sets the str batch no.
	 * 
	 * @param strBatchNo the new str batch no
	 */
	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}

	/**
	 * Gets the str expiry date.
	 * 
	 * @return the str expiry date
	 */
	public String getStrExpiryDate() {
		return strExpiryDate;
	}

	/**
	 * Sets the str expiry date.
	 * 
	 * @param strExpiryDate the new str expiry date
	 */
	public void setStrExpiryDate(String strExpiryDate) {
		this.strExpiryDate = strExpiryDate;
	}

	/**
	 * Gets the str purchase lead time.
	 * 
	 * @return the str purchase lead time
	 */
	public String getStrPurchaseLeadTime() {
		return strPurchaseLeadTime;
	}

	/**
	 * Sets the str purchase lead time.
	 * 
	 * @param strPurchaseLeadTime the new str purchase lead time
	 */
	public void setStrPurchaseLeadTime(String strPurchaseLeadTime) {
		this.strPurchaseLeadTime = strPurchaseLeadTime;
	}

	/**
	 * Gets the str time format.
	 * 
	 * @return the str time format
	 */
	public String getStrTimeFormat() {
		return strTimeFormat;
	}

	/**
	 * Sets the str time format.
	 * 
	 * @param strTimeFormat the new str time format
	 */
	public void setStrTimeFormat(String strTimeFormat) {
		this.strTimeFormat = strTimeFormat;
	}

	/**
	 * Gets the str stock maintain.
	 * 
	 * @return the str stock maintain
	 */
	public String getStrStockMaintain() {
		return strStockMaintain;
	}

	/**
	 * Sets the str stock maintain.
	 * 
	 * @param strStockMaintain the new str stock maintain
	 */
	public void setStrStockMaintain(String strStockMaintain) {
		this.strStockMaintain = strStockMaintain;
	}

	/**
	 * Gets the str shelf life.
	 * 
	 * @return the str shelf life
	 */
	public String getStrShelfLife() {
		return strShelfLife;
	}

	/**
	 * Sets the str shelf life.
	 * 
	 * @param strShelfLife the new str shelf life
	 */
	public void setStrShelfLife(String strShelfLife) {
		this.strShelfLife = strShelfLife;
	}

	/**
	 * Gets the str shelf time format.
	 * 
	 * @return the str shelf time format
	 */
	public String getStrShelfTimeFormat() {
		return strShelfTimeFormat;
	}

	/**
	 * Sets the str shelf time format.
	 * 
	 * @param strShelfTimeFormat the new str shelf time format
	 */
	public void setStrShelfTimeFormat(String strShelfTimeFormat) {
		this.strShelfTimeFormat = strShelfTimeFormat;
	}

	/**
	 * Gets the str approved by.
	 * 
	 * @return the str approved by
	 */
	public String getStrApprovedBy() {
		return strApprovedBy;
	}

	/**
	 * Sets the str approved by.
	 * 
	 * @param strApprovedBy the new str approved by
	 */
	public void setStrApprovedBy(String strApprovedBy) {
		this.strApprovedBy = strApprovedBy;
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
	 * Gets the str consumable type.
	 * 
	 * @return the str consumable type
	 */
	public String getStrConsumableType() {
		return strConsumableType;
	}

	/**
	 * Sets the str consumable type.
	 * 
	 * @param strConsumableType the new str consumable type
	 */
	public void setStrConsumableType(String strConsumableType) {
		this.strConsumableType = strConsumableType;
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
	 * Gets the str is item narcotic.
	 * 
	 * @return the str is item narcotic
	 */
	public String getStrIsItemNarcotic() {
		return strIsItemNarcotic;
	}

	/**
	 * Sets the str is item narcotic.
	 * 
	 * @param strIsItemNarcotic the new str is item narcotic
	 */
	public void setStrIsItemNarcotic(String strIsItemNarcotic) {
		this.strIsItemNarcotic = strIsItemNarcotic;
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
	 * Gets the str unit values.
	 * 
	 * @return the str unit values
	 */
	public String getStrUnitValues() {
		return strUnitValues;
	}

	/**
	 * Gets the str stock maintained values.
	 * 
	 * @return the str stock maintained values
	 */
	public String getStrStockMaintainedValues() {
		return strStockMaintainedValues;
	}

	/**
	 * Gets the str manufacturer values.
	 * 
	 * @return the str manufacturer values
	 */
	public String getStrManufacturerValues() {
		return strManufacturerValues;
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
	 * Gets the str group name value.
	 * 
	 * @return the str group name value
	 */
	public String getStrGroupNameValue() {
		return strGroupNameValue;
	}

	/**
	 * Sets the str group name value.
	 * 
	 * @param strGroupNameValue the new str group name value
	 */
	public void setStrGroupNameValue(String strGroupNameValue) {
		this.strGroupNameValue = strGroupNameValue;
	}

	/**
	 * Gets the str sub group name value.
	 * 
	 * @return the str sub group name value
	 */
	public String getStrSubGroupNameValue() {
		return strSubGroupNameValue;
	}

	/**
	 * Sets the str sub group name value.
	 * 
	 * @param strSubGroupNameValue the new str sub group name value
	 */
	public void setStrSubGroupNameValue(String strSubGroupNameValue) {
		this.strSubGroupNameValue = strSubGroupNameValue;
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
	 * Gets the str brand name.
	 * 
	 * @return the str brand name
	 */
	public String[] getStrBrandName() {
		return strBrandName;
	}

	/**
	 * Sets the str brand name.
	 * 
	 * @param strBrandName the new str brand name
	 */
	public void setStrBrandName(String[] strBrandName) {
		this.strBrandName = strBrandName;
	}

	/**
	 * Gets the str branded manufacturer.
	 * 
	 * @return the str branded manufacturer
	 */
	public String[] getStrBrandedManufacturer() {
		return strBrandedManufacturer;
	}

	/**
	 * Sets the str branded manufacturer.
	 * 
	 * @param strBrandedManufacturer the new str branded manufacturer
	 */
	public void setStrBrandedManufacturer(String[] strBrandedManufacturer) {
		this.strBrandedManufacturer = strBrandedManufacturer;
	}

	/**
	 * Gets the str branded rate.
	 * 
	 * @return the str branded rate
	 */
	public String[] getStrBrandedRate() {
		return strBrandedRate;
	}

	/**
	 * Sets the str branded rate.
	 * 
	 * @param strBrandedRate the new str branded rate
	 */
	public void setStrBrandedRate(String[] strBrandedRate) {
		this.strBrandedRate = strBrandedRate;
	}

	/**
	 * Gets the str branded unit.
	 * 
	 * @return the str branded unit
	 */
	public String[] getStrBrandedUnit() {
		return strBrandedUnit;
	}

	/**
	 * Sets the str branded unit.
	 * 
	 * @param strBrandedUnit the new str branded unit
	 */
	public void setStrBrandedUnit(String[] strBrandedUnit) {
		this.strBrandedUnit = strBrandedUnit;
	}

	/**
	 * Gets the str branded approved by.
	 * 
	 * @return the str branded approved by
	 */
	public String[] getStrBrandedApprovedBy() {
		return strBrandedApprovedBy;
	}

	/**
	 * Sets the str branded approved by.
	 * 
	 * @param strBrandedApprovedBy the new str branded approved by
	 */
	public void setStrBrandedApprovedBy(String[] strBrandedApprovedBy) {
		this.strBrandedApprovedBy = strBrandedApprovedBy;
	}

	/**
	 * Gets the str branded issue type.
	 * 
	 * @return the str branded issue type
	 */
	public String[] getStrBrandedIssueType() {
		return strBrandedIssueType;
	}

	/**
	 * Sets the str branded issue type.
	 * 
	 * @param strBrandedIssueType the new str branded issue type
	 */
	public void setStrBrandedIssueType(String[] strBrandedIssueType) {
		this.strBrandedIssueType = strBrandedIssueType;
	}

	/**
	 * Gets the str branded item maker.
	 * 
	 * @return the str branded item maker
	 */
	public String[] getStrBrandedItemMaker() {
		return strBrandedItemMaker;
	}

	/**
	 * Sets the str branded item maker.
	 * 
	 * @param strBrandedItemMaker the new str branded item maker
	 */
	public void setStrBrandedItemMaker(String[] strBrandedItemMaker) {
		this.strBrandedItemMaker = strBrandedItemMaker;
	}

	/*
	 * public String[] getStrBrandedItemStatus() { return strBrandedItemStatus; }
	 * public void setStrBrandedItemStatus(String[] strBrandedItemStatus) {
	 * this.strBrandedItemStatus = strBrandedItemStatus; }
	 */
	/**
	 * Sets the str unit values.
	 * 
	 * @param strUnitValues the new str unit values
	 */
	public void setStrUnitValues(String strUnitValues) {
		this.strUnitValues = strUnitValues;
	}

	/**
	 * Sets the str stock maintained values.
	 * 
	 * @param strStockMaintainedValues the new str stock maintained values
	 */
	public void setStrStockMaintainedValues(String strStockMaintainedValues) {
		this.strStockMaintainedValues = strStockMaintainedValues;
	}

	/**
	 * Sets the str manufacturer values.
	 * 
	 * @param strManufacturerValues the new str manufacturer values
	 */
	public void setStrManufacturerValues(String strManufacturerValues) {
		this.strManufacturerValues = strManufacturerValues;
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
	 * Gets the str unit values modi.
	 * 
	 * @return the str unit values modi
	 */
	public String getStrUnitValuesModi() {
		return strUnitValuesModi;
	}

	/**
	 * Sets the str unit values modi.
	 * 
	 * @param strUnitValuesModi the new str unit values modi
	 */
	public void setStrUnitValuesModi(String strUnitValuesModi) {
		this.strUnitValuesModi = strUnitValuesModi;
	}

	/**
	 * Gets the str item type values modi.
	 * 
	 * @return the str item type values modi
	 */
	public String getStrItemTypeValuesModi() {
		return strItemTypeValuesModi;
	}

	/**
	 * Sets the str item type values modi.
	 * 
	 * @param strItemTypeValuesModi the new str item type values modi
	 */
	public void setStrItemTypeValuesModi(String strItemTypeValuesModi) {
		this.strItemTypeValuesModi = strItemTypeValuesModi;
	}

	/**
	 * Gets the str stock maintained values modi.
	 * 
	 * @return the str stock maintained values modi
	 */
	public String getStrStockMaintainedValuesModi() {
		return strStockMaintainedValuesModi;
	}

	/**
	 * Sets the str stock maintained values modi.
	 * 
	 * @param strStockMaintainedValuesModi the new str stock maintained values modi
	 */
	public void setStrStockMaintainedValuesModi(
			String strStockMaintainedValuesModi) {
		this.strStockMaintainedValuesModi = strStockMaintainedValuesModi;
	}

	/**
	 * Gets the str brand item dtl values.
	 * 
	 * @return the str brand item dtl values
	 */
	public String getStrBrandItemDtlValues() {
		return strBrandItemDtlValues;
	}

	/**
	 * Sets the str brand item dtl values.
	 * 
	 * @param strBrandItemDtlValues the new str brand item dtl values
	 */
	public void setStrBrandItemDtlValues(String strBrandItemDtlValues) {
		this.strBrandItemDtlValues = strBrandItemDtlValues;
	}

	/**
	 * Gets the primary key brand item.
	 * 
	 * @return the primary key brand item
	 */
	public String[] getPrimaryKeyBrandItem() {
		return primaryKeyBrandItem;
	}

	/**
	 * Sets the primary key brand item.
	 * 
	 * @param primaryKeyBrandItem the new primary key brand item
	 */
	public void setPrimaryKeyBrandItem(String[] primaryKeyBrandItem) {
		this.primaryKeyBrandItem = primaryKeyBrandItem;
	}

	/**
	 * Gets the str count.
	 * 
	 * @return the str count
	 */
	public String getStrCount() {
		return strCount;
	}

	/**
	 * Sets the str count.
	 * 
	 * @param strCount the new str count
	 */
	public void setStrCount(String strCount) {
		this.strCount = strCount;
	}

	/**
	 * Gets the str consent req.
	 * 
	 * @return the strConsentReq
	 */
	public String getStrConsentReq() {
		return strConsentReq;
	}

	/**
	 * Sets the str consent req.
	 * 
	 * @param strConsentReq the strConsentReq to set
	 */
	public void setStrConsentReq(String strConsentReq) {
		this.strConsentReq = strConsentReq;
	}

	public String getStrInventoryUnitName() {
		return strInventoryUnitName;
	}

	public void setStrInventoryUnitName(String strInventoryUnitName) {
		this.strInventoryUnitName = strInventoryUnitName;
	}

	public String getStrTrimester() {
		return strTrimester;
	}

	public void setStrTrimester(String strTrimester) {
		this.strTrimester = strTrimester;
	}

	public String getStrEffectsOnFoetus() {
		return strEffectsOnFoetus;
	}

	public void setStrEffectsOnFoetus(String strEffectsOnFoetus) {
		this.strEffectsOnFoetus = strEffectsOnFoetus;
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
}
