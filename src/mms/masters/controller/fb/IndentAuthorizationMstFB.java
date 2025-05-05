package mms.masters.controller.fb;

import javax.sql.rowset.WebRowSet;

import hisglobal.masterutil.GenericFormBean;

// TODO: Auto-generated Javadoc
/**
 * The Class IndentAuthorizationMstFB.
 */
public class IndentAuthorizationMstFB extends GenericFormBean {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The str err. */
	private String strErr = "";
	
	/** The str msg. */
	private String strMsg = "";
	
	/** The str warning. */
	private String strWarning = "";
	
	/** The str ct date. */
	private String strCtDate = "";

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str store id. */
	private String strStoreId = "";
	
	/** The str item cat no. */
	private String strItemCatNo = "";
	
	/** The str authorization no. */
	private String strAuthorizationNo = "";
	
	/** The str authtype for id. */
	private String strAuthtypeForId = "";
	
	/** The str type id. */
	private String strTypeId = "";
	
	/** The str emp id. */
	private String strEmpId[] = null;
	
	/** The str level. */
	private String strLevel[] = null;
	
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
	
	/** The str store name. */
	private String strStoreName = "";
	
	/** The str item category name. */
	private String strItemCategoryName = "";
	
	/** The str authorization for name. */
	private String strAuthorizationForName = "";
	
	/** The str type. */
	private String strType = "";

	/** The str chk1. */
	private String strChk1 = "";
	
	/** The str combo value. */
	private String strComboValue = "";
	
	/** The str added data. */
	private String strAddedData = null;

	/** The str employee name values. */
	private String strEmployeeNameValues = "";
	
	/** The str employee name ws. */
	private WebRowSet strEmployeeNameWS = null;

	/** The str employee id. */
	private String strEmployeeId = "";
	
	/** The str level1. */
	private String strLevel1 = "";

	/**
	 * Gets the str level1.
	 * 
	 * @return the strLevel1
	 */
	public String getStrLevel1() {
		return strLevel1;
	}

	/**
	 * Sets the str level1.
	 * 
	 * @param strLevel1 the strLevel1 to set
	 */
	public void setStrLevel1(String strLevel1) {
		this.strLevel1 = strLevel1;
	}

	/**
	 * Gets the str employee id.
	 * 
	 * @return the strEmployeeId
	 */
	public String getStrEmployeeId() {
		return strEmployeeId;
	}

	/**
	 * Sets the str employee id.
	 * 
	 * @param strEmployeeId the strEmployeeId to set
	 */
	public void setStrEmployeeId(String strEmployeeId) {
		this.strEmployeeId = strEmployeeId;
	}

	/**
	 * Gets the str err.
	 * 
	 * @return the strErr
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * Sets the str err.
	 * 
	 * @param strErr the strErr to set
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

	/**
	 * Gets the str msg.
	 * 
	 * @return the strMsg
	 */
	public String getStrMsg() {
		return strMsg;
	}

	/**
	 * Sets the str msg.
	 * 
	 * @param strMsg the strMsg to set
	 */
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}

	/**
	 * Gets the str warning.
	 * 
	 * @return the strWarning
	 */
	public String getStrWarning() {
		return strWarning;
	}

	/**
	 * Sets the str warning.
	 * 
	 * @param strWarning the strWarning to set
	 */
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
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
	 * Gets the str authorization no.
	 * 
	 * @return the strAuthorizationNo
	 */
	public String getStrAuthorizationNo() {
		return strAuthorizationNo;
	}

	/**
	 * Sets the str authorization no.
	 * 
	 * @param strAuthorizationNo the strAuthorizationNo to set
	 */
	public void setStrAuthorizationNo(String strAuthorizationNo) {
		this.strAuthorizationNo = strAuthorizationNo;
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
	 * Gets the str effective to.
	 * 
	 * @return the strEffectiveTo
	 */
	public String getStrEffectiveTo() {
		return strEffectiveTo;
	}

	/**
	 * Sets the str effective to.
	 * 
	 * @param strEffectiveTo the strEffectiveTo to set
	 */
	public void setStrEffectiveTo(String strEffectiveTo) {
		this.strEffectiveTo = strEffectiveTo;
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
	 * Gets the str chk1.
	 * 
	 * @return the strChk1
	 */
	public String getStrChk1() {
		return strChk1;
	}

	/**
	 * Sets the str chk1.
	 * 
	 * @param strChk1 the strChk1 to set
	 */
	public void setStrChk1(String strChk1) {
		this.strChk1 = strChk1;
	}

	/**
	 * Gets the str combo value.
	 * 
	 * @return the strComboValue
	 */
	public String getStrComboValue() {
		return strComboValue;
	}

	/**
	 * Sets the str combo value.
	 * 
	 * @param strComboValue the strComboValue to set
	 */
	public void setStrComboValue(String strComboValue) {
		this.strComboValue = strComboValue;
	}

	/**
	 * Gets the str ct date.
	 * 
	 * @return the strCtDate
	 */
	public String getStrCtDate() {
		return strCtDate;
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
	 * Gets the str item category name.
	 * 
	 * @return the strItemCategoryName
	 */
	public String getStrItemCategoryName() {
		return strItemCategoryName;
	}

	/**
	 * Sets the str item category name.
	 * 
	 * @param strItemCategoryName the strItemCategoryName to set
	 */
	public void setStrItemCategoryName(String strItemCategoryName) {
		this.strItemCategoryName = strItemCategoryName;
	}

	/**
	 * Gets the str authorization for name.
	 * 
	 * @return the strAuthorizationForName
	 */
	public String getStrAuthorizationForName() {
		return strAuthorizationForName;
	}

	/**
	 * Sets the str authorization for name.
	 * 
	 * @param strAuthorizationForName the strAuthorizationForName to set
	 */
	public void setStrAuthorizationForName(String strAuthorizationForName) {
		this.strAuthorizationForName = strAuthorizationForName;
	}

	/**
	 * Gets the str type.
	 * 
	 * @return the strType
	 */
	public String getStrType() {
		return strType;
	}

	/**
	 * Sets the str type.
	 * 
	 * @param strType the strType to set
	 */
	public void setStrType(String strType) {
		this.strType = strType;
	}

	/**
	 * Gets the str authtype for id.
	 * 
	 * @return the strAuthtypeForId
	 */
	public String getStrAuthtypeForId() {
		return strAuthtypeForId;
	}

	/**
	 * Sets the str authtype for id.
	 * 
	 * @param strAuthtypeForId the strAuthtypeForId to set
	 */
	public void setStrAuthtypeForId(String strAuthtypeForId) {
		this.strAuthtypeForId = strAuthtypeForId;
	}

	/**
	 * Gets the str type id.
	 * 
	 * @return the strTypeId
	 */
	public String getStrTypeId() {
		return strTypeId;
	}

	/**
	 * Sets the str type id.
	 * 
	 * @param strTypeId the strTypeId to set
	 */
	public void setStrTypeId(String strTypeId) {
		this.strTypeId = strTypeId;
	}

	/**
	 * Gets the str emp id.
	 * 
	 * @return the strEmpId
	 */
	public String[] getStrEmpId() {
		return strEmpId;
	}

	/**
	 * Sets the str emp id.
	 * 
	 * @param strEmpId the strEmpId to set
	 */
	public void setStrEmpId(String[] strEmpId) {
		this.strEmpId = strEmpId;
	}

	/**
	 * Gets the str level.
	 * 
	 * @return the strLevel
	 */
	public String[] getStrLevel() {
		return strLevel;
	}

	/**
	 * Sets the str level.
	 * 
	 * @param strLevel the strLevel to set
	 */
	public void setStrLevel(String[] strLevel) {
		this.strLevel = strLevel;
	}

	/**
	 * Gets the str employee name values.
	 * 
	 * @return the strEmployeeNameValues
	 */
	public String getStrEmployeeNameValues() {
		return strEmployeeNameValues;
	}

	/**
	 * Sets the str employee name values.
	 * 
	 * @param strEmployeeNameValues the strEmployeeNameValues to set
	 */
	public void setStrEmployeeNameValues(String strEmployeeNameValues) {
		this.strEmployeeNameValues = strEmployeeNameValues;
	}

	/**
	 * Gets the str employee name ws.
	 * 
	 * @return the strEmployeeNameWS
	 */
	public WebRowSet getStrEmployeeNameWS() {
		return strEmployeeNameWS;
	}

	/**
	 * Sets the str employee name ws.
	 * 
	 * @param strEmployeeNameWS the strEmployeeNameWS to set
	 */
	public void setStrEmployeeNameWS(WebRowSet strEmployeeNameWS) {
		this.strEmployeeNameWS = strEmployeeNameWS;
	}

	/**
	 * Gets the str added data.
	 * 
	 * @return the strAddedData
	 */
	public String getStrAddedData() {
		return strAddedData;
	}

	/**
	 * Sets the str added data.
	 * 
	 * @param strAddedData the strAddedData to set
	 */
	public void setStrAddedData(String strAddedData) {
		this.strAddedData = strAddedData;
	}

}
