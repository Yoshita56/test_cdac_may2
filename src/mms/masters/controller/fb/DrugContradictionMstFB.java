/**
 * 
 */
package mms.masters.controller.fb;

import hisglobal.masterutil.GenericFormBean;

/**
 * @author Niharika Srivastava
 * Date : 20-08-10
 * Process : Drug Contradiction Master
 * Module: MMS
 * TL: Ajay Kumar Gupta
 * Description : FormBean For Drug Contradiction Master
 */
public class DrugContradictionMstFB extends GenericFormBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The str err. */
	private String strErr = "";
	
	/** The str msg. */
	private String strMsg = "";
	
	/** The str warning. */
	private String strWarning = "";

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str supplier id. */
	private String strSupplierId = "";
	
	/** The str item id. */
	private String strItemId = "";
	
	/** The str item brand id. */
	private String strItemBrandId = "";
	
	/** The str supplier item sl no. */
	private String strSupplierItemSlNo = "";
	
	/** The str item rate. */
	private String strItemRate = "";
	
	/** The str rate unit id. */
	private String strRateUnitId = "";

	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str effective to. */
	private String strEffectiveTo = "";
	
	/** The str last mode seat id. */
	private String strLastModeSeatId = "";
	
	/** The str last mode date. */
	private String strLastModeDate = "";
	
	/** The str entry date. */
	private String strEntryDate = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str is valid. */
	private String strIsValid = "";

	/** The str left item list. */
	private String strLeftItemList = "";
	
	/** The str right item list. */
	private String strRightItemList = "";
	
	/** The str right item ids. */
	private String[] strRightItemIds = null;
	
	/** The str left item ids. */
	private String[] strLeftItemIds = null;

	/** The str chk1. */
	private String strChk1 = "";

	// private String[] combo =null;

	/** The str combo value. */
	private String strComboValue = "";

	/** The str supplier name. */
	private String strDrugName = "";
	
	/** The str group id. */
	private String strGroupId = "";
	
	/** The str group name combo. */
	private String strGroupNameCombo = "";
	
	/** The str group id. */
	private String strDrugId = "";
	
	/** The str Drug name combo. */
	private String strDrugNameCombo = "";
	
	/** The str sub group id. */
	private String strSubGroupId = "";
	
	/** The str group name. */
	private String strGroupName = "";
	
	/** The str sub group name. */
	private String strSubGroupName = "";
	
	/** The str store type id. */
	private String strContraDrugs = "";

	/** The str ct date. */
	private String strCtDate = "";

	/**
	 * @return the strErr
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * @param strErr the strErr to set
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

	/**
	 * @return the strMsg
	 */
	public String getStrMsg() {
		return strMsg;
	}

	/**
	 * @param strMsg the strMsg to set
	 */
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}

	/**
	 * @return the strWarning
	 */
	public String getStrWarning() {
		return strWarning;
	}

	/**
	 * @param strWarning the strWarning to set
	 */
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}

	/**
	 * @return the strHospitalCode
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	/**
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * @return the strSupplierId
	 */
	public String getStrSupplierId() {
		return strSupplierId;
	}

	/**
	 * @param strSupplierId the strSupplierId to set
	 */
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}

	/**
	 * @return the strItemId
	 */
	public String getStrItemId() {
		return strItemId;
	}

	/**
	 * @param strItemId the strItemId to set
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}

	/**
	 * @return the strItemBrandId
	 */
	public String getStrItemBrandId() {
		return strItemBrandId;
	}

	/**
	 * @param strItemBrandId the strItemBrandId to set
	 */
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}

	/**
	 * @return the strSupplierItemSlNo
	 */
	public String getStrSupplierItemSlNo() {
		return strSupplierItemSlNo;
	}

	/**
	 * @param strSupplierItemSlNo the strSupplierItemSlNo to set
	 */
	public void setStrSupplierItemSlNo(String strSupplierItemSlNo) {
		this.strSupplierItemSlNo = strSupplierItemSlNo;
	}

	/**
	 * @return the strItemRate
	 */
	public String getStrItemRate() {
		return strItemRate;
	}

	/**
	 * @param strItemRate the strItemRate to set
	 */
	public void setStrItemRate(String strItemRate) {
		this.strItemRate = strItemRate;
	}

	/**
	 * @return the strRateUnitId
	 */
	public String getStrRateUnitId() {
		return strRateUnitId;
	}

	/**
	 * @param strRateUnitId the strRateUnitId to set
	 */
	public void setStrRateUnitId(String strRateUnitId) {
		this.strRateUnitId = strRateUnitId;
	}

	/**
	 * @return the strRemarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}

	/**
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * @return the strEffectiveFrom
	 */
	public String getStrEffectiveFrom() {
		return strEffectiveFrom;
	}

	/**
	 * @param strEffectiveFrom the strEffectiveFrom to set
	 */
	public void setStrEffectiveFrom(String strEffectiveFrom) {
		this.strEffectiveFrom = strEffectiveFrom;
	}

	/**
	 * @return the strEffectiveTo
	 */
	public String getStrEffectiveTo() {
		return strEffectiveTo;
	}

	/**
	 * @param strEffectiveTo the strEffectiveTo to set
	 */
	public void setStrEffectiveTo(String strEffectiveTo) {
		this.strEffectiveTo = strEffectiveTo;
	}

	/**
	 * @return the strLastModeSeatId
	 */
	public String getStrLastModeSeatId() {
		return strLastModeSeatId;
	}

	/**
	 * @param strLastModeSeatId the strLastModeSeatId to set
	 */
	public void setStrLastModeSeatId(String strLastModeSeatId) {
		this.strLastModeSeatId = strLastModeSeatId;
	}

	/**
	 * @return the strLastModeDate
	 */
	public String getStrLastModeDate() {
		return strLastModeDate;
	}

	/**
	 * @param strLastModeDate the strLastModeDate to set
	 */
	public void setStrLastModeDate(String strLastModeDate) {
		this.strLastModeDate = strLastModeDate;
	}

	/**
	 * @return the strEntryDate
	 */
	public String getStrEntryDate() {
		return strEntryDate;
	}

	/**
	 * @param strEntryDate the strEntryDate to set
	 */
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}

	/**
	 * @return the strSeatId
	 */
	public String getStrSeatId() {
		return strSeatId;
	}

	/**
	 * @param strSeatId the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * @return the strIsValid
	 */
	public String getStrIsValid() {
		return strIsValid;
	}

	/**
	 * @param strIsValid the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	/**
	 * @return the strLeftItemList
	 */
	public String getStrLeftItemList() {
		return strLeftItemList;
	}

	/**
	 * @param strLeftItemList the strLeftItemList to set
	 */
	public void setStrLeftItemList(String strLeftItemList) {
		this.strLeftItemList = strLeftItemList;
	}

	/**
	 * @return the strRightItemList
	 */
	public String getStrRightItemList() {
		return strRightItemList;
	}

	/**
	 * @param strRightItemList the strRightItemList to set
	 */
	public void setStrRightItemList(String strRightItemList) {
		this.strRightItemList = strRightItemList;
	}

	/**
	 * @return the strRightItemIds
	 */
	public String[] getStrRightItemIds() {
		return strRightItemIds;
	}

	/**
	 * @param strRightItemIds the strRightItemIds to set
	 */
	public void setStrRightItemIds(String[] strRightItemIds) {
		this.strRightItemIds = strRightItemIds;
	}

	/**
	 * @return the strLeftItemIds
	 */
	public String[] getStrLeftItemIds() {
		return strLeftItemIds;
	}

	/**
	 * @param strLeftItemIds the strLeftItemIds to set
	 */
	public void setStrLeftItemIds(String[] strLeftItemIds) {
		this.strLeftItemIds = strLeftItemIds;
	}

	
	/**
	 * @return the strChk1
	 */
	public String getStrChk1() {
		return strChk1;
	}

	/**
	 * @param strChk1 the strChk1 to set
	 */
	public void setStrChk1(String strChk1) {
		this.strChk1 = strChk1;
	}

	/**
	 * @return the strComboValue
	 */
	public String getStrComboValue() {
		return strComboValue;
	}

	/**
	 * @param strComboValue the strComboValue to set
	 */
	public void setStrComboValue(String strComboValue) {
		this.strComboValue = strComboValue;
	}

	
	/**
	 * @return the strDrugName
	 */
	public String getStrDrugName() {
		return strDrugName;
	}

	/**
	 * @param strDrugName the strDrugName to set
	 */
	public void setStrDrugName(String strDrugName) {
		this.strDrugName = strDrugName;
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
	 * @return the strGroupNameCombo
	 */
	public String getStrGroupNameCombo() {
		return strGroupNameCombo;
	}

	/**
	 * @param strGroupNameCombo the strGroupNameCombo to set
	 */
	public void setStrGroupNameCombo(String strGroupNameCombo) {
		this.strGroupNameCombo = strGroupNameCombo;
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
	 * @return the strGroupName
	 */
	public String getStrGroupName() {
		return strGroupName;
	}

	/**
	 * @param strGroupName the strGroupName to set
	 */
	public void setStrGroupName(String strGroupName) {
		this.strGroupName = strGroupName;
	}

	/**
	 * @return the strSubGroupName
	 */
	public String getStrSubGroupName() {
		return strSubGroupName;
	}

	/**
	 * @param strSubGroupName the strSubGroupName to set
	 */
	public void setStrSubGroupName(String strSubGroupName) {
		this.strSubGroupName = strSubGroupName;
	}

	/**
	 * @return the strCtDate
	 */
	public String getStrCtDate() {
		return strCtDate;
	}

	/**
	 * @param strCtDate the strCtDate to set
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}

	/**
	 * @return the strDrugId
	 */
	public String getStrDrugId() {
		return strDrugId;
	}

	/**
	 * @param strDrugId the strDrugId to set
	 */
	public void setStrDrugId(String strDrugId) {
		this.strDrugId = strDrugId;
	}

	/**
	 * @return the strDrugNameCombo
	 */
	public String getStrDrugNameCombo() {
		return strDrugNameCombo;
	}

	/**
	 * @param strDrugNameCombo the strDrugNameCombo to set
	 */
	public void setStrDrugNameCombo(String strDrugNameCombo) {
		this.strDrugNameCombo = strDrugNameCombo;
	}

	/**
	 * @return the strContraDrugs
	 */
	public String getStrContraDrugs() {
		return strContraDrugs;
	}

	/**
	 * @param strContraDrugs the strContraDrugs to set
	 */
	public void setStrContraDrugs(String strContraDrugs) {
		this.strContraDrugs = strContraDrugs;
	}

}
