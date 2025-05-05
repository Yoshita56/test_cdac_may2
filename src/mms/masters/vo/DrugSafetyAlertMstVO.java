package mms.masters.vo;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugSafetyAlertMstVO.
 */
public class DrugSafetyAlertMstVO {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** **********Comman Variable***************. */
	private Boolean BExistStatus = false;
	
	/** The str msg string. */
	private String strMsgString = "";
	
	/** The str msg type. */
	private String strMsgType = "";
	
	/** The str ct date. */
	private String strCtDate = "";

	/** The str msg. */
	private String strMsg = "";
	
	/** The str warning. */
	private String strWarning = "";
	
	/** The str error msg. */
	private String strErrorMsg = "";

	/** **********Master Variable**************. */
	private String strDrugName = "";
	
	/** The str drug name combo. */
	private String strDrugNameCombo = "";
	
	/** The str group name combo. */
	private String strGroupNameCombo = "";
	
	/** The str group name. */
	private String strGroupName = "";
	
	/** The str sub group name. */
	private String strSubGroupName = "";
	
	/** The str sub group name combo. */
	private String strSubGroupNameCombo = "";
	
	/** The str sub grp id. */
	private String strSubGrpId = "";
	
	/** The str grp id. */
	private String strGrpId = "";
	
	/** The str item id. */
	private String strItemId = "";
	
	/** The str added data. */
	private String[] strAddedData = { "0" };

	/** The str hstnum item id. */
	private String strHstnumItemId = "";
	
	/** The str hstr cl. */
	private String strHstrCl = "";
	
	/** The str hstr sp. */
	private String strHstrSp = "";
	
	/** The str hstr int. */
	private String strHstrInt = "";
	
	/** The str hstr adr. */
	private String strHstrAdr = "";
	
	/** The str hstr int pot haz. */
	private String strHstrIntPotHaz = "";
	
	/** The str hstr adr pot lt. */
	private String strHstrAdrPotLt = "";
	
	/** The str hstr lab int. */
	private String strHstrLabInt = "";
	
	/** The str hstrint food. */
	private String strHstrintFood = "";
	
	/** The str lst mod seat id. */
	private String strLstModSeatId = "";
	
	/** The str lst mod date. */
	private String strLstModDate = "";

	/** The str last modified date. */
	private String strLastModifiedDate = "";

	/** The str last modified seat id. */
	private String strLastModifiedSeatId = "";

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str group id. */
	private String strGroupId = "";

	/** The str store type id. */
	private String strStoreTypeId = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
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
	
	/** The str chk1. */
	private String strChk1 = "";
	
	/** The str data ws. */
	private WebRowSet strDataWs = null;
	
	/** The str added data ws. */
	private WebRowSet strAddedDataWs = null;

	/** The str group name combo values ws. */
	private WebRowSet strGroupNameComboValuesWS = null;
	
	/** The str sub group name combo values ws. */
	private WebRowSet strSubGroupNameComboValuesWS = null;
	
	/** The str drug name combo values ws. */
	private WebRowSet strDrugNameComboValuesWS = null;

	/**
	 * Gets the str group name combo values ws.
	 * 
	 * @return the strGroupNameComboValuesWS
	 */
	public WebRowSet getStrGroupNameComboValuesWS() {
		return strGroupNameComboValuesWS;
	}

	/**
	 * Sets the str group name combo values ws.
	 * 
	 * @param strGroupNameComboValuesWS the strGroupNameComboValuesWS to set
	 */
	public void setStrGroupNameComboValuesWS(WebRowSet strGroupNameComboValuesWS) {
		this.strGroupNameComboValuesWS = strGroupNameComboValuesWS;
	}

	/**
	 * Gets the str sub group name combo values ws.
	 * 
	 * @return the strSubGroupNameComboValuesWS
	 */
	public WebRowSet getStrSubGroupNameComboValuesWS() {
		return strSubGroupNameComboValuesWS;
	}

	/**
	 * Sets the str sub group name combo values ws.
	 * 
	 * @param strSubGroupNameComboValuesWS the strSubGroupNameComboValuesWS to set
	 */
	public void setStrSubGroupNameComboValuesWS(
			WebRowSet strSubGroupNameComboValuesWS) {
		this.strSubGroupNameComboValuesWS = strSubGroupNameComboValuesWS;
	}

	/**
	 * Gets the str drug name combo values ws.
	 * 
	 * @return the strDrugNameComboValuesWS
	 */
	public WebRowSet getStrDrugNameComboValuesWS() {
		return strDrugNameComboValuesWS;
	}

	/**
	 * Sets the str drug name combo values ws.
	 * 
	 * @param strDrugNameComboValuesWS the strDrugNameComboValuesWS to set
	 */
	public void setStrDrugNameComboValuesWS(WebRowSet strDrugNameComboValuesWS) {
		this.strDrugNameComboValuesWS = strDrugNameComboValuesWS;
	}

	/**
	 * Sets the str ct date.
	 * 
	 * @param strCtDate the strCtDate to set
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
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
	 * Gets the str drug name combo.
	 * 
	 * @return the str drug name combo
	 */
	public String getStrDrugNameCombo() {
		return strDrugNameCombo;
	}

	/**
	 * Sets the str drug name combo.
	 * 
	 * @param strDrugNameCombo the new str drug name combo
	 */
	public void setStrDrugNameCombo(String strDrugNameCombo) {
		this.strDrugNameCombo = strDrugNameCombo;
	}

	/**
	 * Gets the b exist status.
	 * 
	 * @return the b exist status
	 */
	public Boolean getBExistStatus() {
		return BExistStatus;
	}

	/**
	 * Sets the b exist status.
	 * 
	 * @param existStatus the new b exist status
	 */
	public void setBExistStatus(Boolean existStatus) {
		BExistStatus = existStatus;
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
	 * Gets the str store type id.
	 * 
	 * @return the str store type id
	 */
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}

	/**
	 * Sets the str store type id.
	 * 
	 * @param strStoreTypeId the new str store type id
	 */
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
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
	 * Gets the str last mode seat id.
	 * 
	 * @return the str last mode seat id
	 */
	public String getStrLastModeSeatId() {
		return strLastModeSeatId;
	}

	/**
	 * Sets the str last mode seat id.
	 * 
	 * @param strLastModeSeatId the new str last mode seat id
	 */
	public void setStrLastModeSeatId(String strLastModeSeatId) {
		this.strLastModeSeatId = strLastModeSeatId;
	}

	/**
	 * Gets the str last mode date.
	 * 
	 * @return the str last mode date
	 */
	public String getStrLastModeDate() {
		return strLastModeDate;
	}

	/**
	 * Sets the str last mode date.
	 * 
	 * @param strLastModeDate the new str last mode date
	 */
	public void setStrLastModeDate(String strLastModeDate) {
		this.strLastModeDate = strLastModeDate;
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
	 * Gets the str error msg.
	 * 
	 * @return the str error msg
	 */
	public String getStrErrorMsg() {
		return strErrorMsg;
	}

	/**
	 * Sets the str error msg.
	 * 
	 * @param strErrorMsg the new str error msg
	 */
	public void setStrErrorMsg(String strErrorMsg) {
		this.strErrorMsg = strErrorMsg;
	}

	/**
	 * Gets the str data ws.
	 * 
	 * @return the str data ws
	 */
	public WebRowSet getStrDataWs() {
		return strDataWs;
	}

	/**
	 * Sets the str data ws.
	 * 
	 * @param strDataWs the new str data ws
	 */
	public void setStrDataWs(WebRowSet strDataWs) {
		this.strDataWs = strDataWs;
	}

	/**
	 * Gets the str group name combo.
	 * 
	 * @return the str group name combo
	 */
	public String getStrGroupNameCombo() {
		return strGroupNameCombo;
	}

	/**
	 * Sets the str group name combo.
	 * 
	 * @param strGroupNameCombo the new str group name combo
	 */
	public void setStrGroupNameCombo(String strGroupNameCombo) {
		this.strGroupNameCombo = strGroupNameCombo;
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
	 * Gets the str sub group name combo.
	 * 
	 * @return the str sub group name combo
	 */
	public String getStrSubGroupNameCombo() {
		return strSubGroupNameCombo;
	}

	/**
	 * Sets the str sub group name combo.
	 * 
	 * @param strSubGroupNameCombo the new str sub group name combo
	 */
	public void setStrSubGroupNameCombo(String strSubGroupNameCombo) {
		this.strSubGroupNameCombo = strSubGroupNameCombo;
	}

	/**
	 * Gets the str sub grp id.
	 * 
	 * @return the str sub grp id
	 */
	public String getStrSubGrpId() {
		return strSubGrpId;
	}

	/**
	 * Sets the str sub grp id.
	 * 
	 * @param strSubGrpId the new str sub grp id
	 */
	public void setStrSubGrpId(String strSubGrpId) {
		this.strSubGrpId = strSubGrpId;
	}

	/**
	 * Gets the str grp id.
	 * 
	 * @return the str grp id
	 */
	public String getStrGrpId() {
		return strGrpId;
	}

	/**
	 * Sets the str grp id.
	 * 
	 * @param strGrpId the new str grp id
	 */
	public void setStrGrpId(String strGrpId) {
		this.strGrpId = strGrpId;
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
	 * Gets the str added data.
	 * 
	 * @return the str added data
	 */
	public String[] getStrAddedData() {
		return strAddedData;
	}

	/**
	 * Sets the str added data.
	 * 
	 * @param strAddedData the new str added data
	 */
	public void setStrAddedData(String[] strAddedData) {
		this.strAddedData = strAddedData;
	}

	/**
	 * Gets the str hstnum item id.
	 * 
	 * @return the str hstnum item id
	 */
	public String getStrHstnumItemId() {
		return strHstnumItemId;
	}

	/**
	 * Sets the str hstnum item id.
	 * 
	 * @param strHstnumItemId the new str hstnum item id
	 */
	public void setStrHstnumItemId(String strHstnumItemId) {
		this.strHstnumItemId = strHstnumItemId;
	}

	/**
	 * Gets the str hstr cl.
	 * 
	 * @return the str hstr cl
	 */
	public String getStrHstrCl() {
		return strHstrCl;
	}

	/**
	 * Sets the str hstr cl.
	 * 
	 * @param strHstrCl the new str hstr cl
	 */
	public void setStrHstrCl(String strHstrCl) {
		this.strHstrCl = strHstrCl;
	}

	/**
	 * Gets the str hstr sp.
	 * 
	 * @return the str hstr sp
	 */
	public String getStrHstrSp() {
		return strHstrSp;
	}

	/**
	 * Sets the str hstr sp.
	 * 
	 * @param strHstrSp the new str hstr sp
	 */
	public void setStrHstrSp(String strHstrSp) {
		this.strHstrSp = strHstrSp;
	}

	/**
	 * Gets the str hstr int.
	 * 
	 * @return the str hstr int
	 */
	public String getStrHstrInt() {
		return strHstrInt;
	}

	/**
	 * Sets the str hstr int.
	 * 
	 * @param strHstrInt the new str hstr int
	 */
	public void setStrHstrInt(String strHstrInt) {
		this.strHstrInt = strHstrInt;
	}

	/**
	 * Gets the str hstr adr.
	 * 
	 * @return the str hstr adr
	 */
	public String getStrHstrAdr() {
		return strHstrAdr;
	}

	/**
	 * Sets the str hstr adr.
	 * 
	 * @param strHstrAdr the new str hstr adr
	 */
	public void setStrHstrAdr(String strHstrAdr) {
		this.strHstrAdr = strHstrAdr;
	}

	/**
	 * Gets the str hstr int pot haz.
	 * 
	 * @return the str hstr int pot haz
	 */
	public String getStrHstrIntPotHaz() {
		return strHstrIntPotHaz;
	}

	/**
	 * Sets the str hstr int pot haz.
	 * 
	 * @param strHstrIntPotHaz the new str hstr int pot haz
	 */
	public void setStrHstrIntPotHaz(String strHstrIntPotHaz) {
		this.strHstrIntPotHaz = strHstrIntPotHaz;
	}

	/**
	 * Gets the str hstr adr pot lt.
	 * 
	 * @return the str hstr adr pot lt
	 */
	public String getStrHstrAdrPotLt() {
		return strHstrAdrPotLt;
	}

	/**
	 * Sets the str hstr adr pot lt.
	 * 
	 * @param strHstrAdrPotLt the new str hstr adr pot lt
	 */
	public void setStrHstrAdrPotLt(String strHstrAdrPotLt) {
		this.strHstrAdrPotLt = strHstrAdrPotLt;
	}

	/**
	 * Gets the str hstr lab int.
	 * 
	 * @return the str hstr lab int
	 */
	public String getStrHstrLabInt() {
		return strHstrLabInt;
	}

	/**
	 * Sets the str hstr lab int.
	 * 
	 * @param strHstrLabInt the new str hstr lab int
	 */
	public void setStrHstrLabInt(String strHstrLabInt) {
		this.strHstrLabInt = strHstrLabInt;
	}

	/**
	 * Gets the str hstrint food.
	 * 
	 * @return the str hstrint food
	 */
	public String getStrHstrintFood() {
		return strHstrintFood;
	}

	/**
	 * Sets the str hstrint food.
	 * 
	 * @param strHstrintFood the new str hstrint food
	 */
	public void setStrHstrintFood(String strHstrintFood) {
		this.strHstrintFood = strHstrintFood;
	}

	/**
	 * Gets the str lst mod seat id.
	 * 
	 * @return the str lst mod seat id
	 */
	public String getStrLstModSeatId() {
		return strLstModSeatId;
	}

	/**
	 * Sets the str lst mod seat id.
	 * 
	 * @param strLstModSeatId the new str lst mod seat id
	 */
	public void setStrLstModSeatId(String strLstModSeatId) {
		this.strLstModSeatId = strLstModSeatId;
	}

	/**
	 * Gets the str lst mod date.
	 * 
	 * @return the str lst mod date
	 */
	public String getStrLstModDate() {
		return strLstModDate;
	}

	/**
	 * Sets the str lst mod date.
	 * 
	 * @param strLstModDate the new str lst mod date
	 */
	public void setStrLstModDate(String strLstModDate) {
		this.strLstModDate = strLstModDate;
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
	 * Gets the str added data ws.
	 * 
	 * @return the str added data ws
	 */
	public WebRowSet getStrAddedDataWs() {
		return strAddedDataWs;
	}

	/**
	 * Sets the str added data ws.
	 * 
	 * @param strAddedDataWs the new str added data ws
	 */
	public void setStrAddedDataWs(WebRowSet strAddedDataWs) {
		this.strAddedDataWs = strAddedDataWs;
	}

	/**
	 * Gets the str ct date.
	 * 
	 * @return the strCtDate
	 */
	public String getStrCtDate() {
		return strCtDate;
	}

}
