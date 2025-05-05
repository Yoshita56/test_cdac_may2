package mms.masters.vo;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * The Class IndentAuthorizationMstVO.
 */
public class IndentAuthorizationMstVO {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

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

	/** The str msg string. */
	private String strMsgString = "";
	
	/** The str msg type. */
	private String strMsgType = "";
	
	/** The str indent authorization details. */
	private WebRowSet strIndentAuthorizationDetails = null;
	
	/** The str employee name combo ws. */
	private WebRowSet strEmployeeNameComboWs = null;
	
	/** The str employee namecombo values. */
	private String strEmployeeNamecomboValues = "";

	/** The str employee id. */
	private String strEmployeeId = "";
	
	/** The str level1. */
	private String strLevel1 = "";

	/** The b exist status. */
	private boolean bExistStatus = false;

	/**
	 * Checks if is b exist status.
	 * 
	 * @return the bExistStatus
	 */
	public boolean isBExistStatus() {
		return bExistStatus;
	}

	/**
	 * Sets the b exist status.
	 * 
	 * @param existStatus the bExistStatus to set
	 */
	public void setBExistStatus(boolean existStatus) {
		bExistStatus = existStatus;
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
	 * Gets the str indent authorization details.
	 * 
	 * @return the strIndentAuthorizationDetails
	 */
	public WebRowSet getStrIndentAuthorizationDetails() {
		return strIndentAuthorizationDetails;
	}

	/**
	 * Sets the str indent authorization details.
	 * 
	 * @param strIndentAuthorizationDetails the strIndentAuthorizationDetails to set
	 */
	public void setStrIndentAuthorizationDetails(
			WebRowSet strIndentAuthorizationDetails) {
		this.strIndentAuthorizationDetails = strIndentAuthorizationDetails;
	}

	/**
	 * Gets the str employee name combo ws.
	 * 
	 * @return the strEmployeeNameComboWs
	 */
	public WebRowSet getStrEmployeeNameComboWs() {
		return strEmployeeNameComboWs;
	}

	/**
	 * Sets the str employee name combo ws.
	 * 
	 * @param strEmployeeNameComboWs the strEmployeeNameComboWs to set
	 */
	public void setStrEmployeeNameComboWs(WebRowSet strEmployeeNameComboWs) {
		this.strEmployeeNameComboWs = strEmployeeNameComboWs;
	}

	/**
	 * Gets the str employee namecombo values.
	 * 
	 * @return the strEmployeeNamecomboValues
	 */
	public String getStrEmployeeNamecomboValues() {
		return strEmployeeNamecomboValues;
	}

	/**
	 * Sets the str employee namecombo values.
	 * 
	 * @param strEmployeeNamecomboValues the strEmployeeNamecomboValues to set
	 */
	public void setStrEmployeeNamecomboValues(String strEmployeeNamecomboValues) {
		this.strEmployeeNamecomboValues = strEmployeeNamecomboValues;
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

}
