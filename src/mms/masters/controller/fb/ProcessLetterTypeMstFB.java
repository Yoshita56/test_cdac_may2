package mms.masters.controller.fb;

import hisglobal.masterutil.GenericFormBean;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcessLetterTypeMstFB.
 */
public class ProcessLetterTypeMstFB extends GenericFormBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The str letter type id. */
	private String strLetterTypeId = "0";
	
	/** The str left letter type id. */
	private String strLeftLetterTypeId = "0";
	
	/** The str right letter type id. */
	private String strRightLetterTypeId = "0";
	
	/** The str letter type name. */
	private String strLetterTypeName = "";

	/** The str store type id. */
	private String strStoreTypeId = "0";
	
	/** The str store type name. */
	private String strStoreTypeName = "";

	/** The str process id. */
	private String strProcessId = "0";
	
	/** The str process name. */
	private String strProcessName = "";
	
	/** The str process sl no. */
	private String strProcessSlNo = "";

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
	
	/** The str warning. */
	private String strWarning = "";
	
	/** The str msg. */
	private String strMsg = "";
	
	/** The str error msg. */
	private String strErrorMsg = "";
	
	/** The str ct date. */
	private String strCtDate = null;
	
	/** The b exist status. */
	private Boolean bExistStatus = null;

	/** The str store type combo. */
	private String strStoreTypeCombo = "";

	/** The str left letter list name. */
	private String strLeftLetterListName = null;
	
	/** The str right letter list name. */
	private String strRightLetterListName = null;

	/** The str left letter name. */
	private String[] strLeftLetterName = null;
	
	/** The str right letter name. */
	private String[] strRightLetterName = null;

	/**
	 * Gets the str left letter name.
	 * 
	 * @return the str left letter name
	 */
	public String[] getStrLeftLetterName() {
		return strLeftLetterName;
	}

	/**
	 * Sets the str left letter name.
	 * 
	 * @param strLeftLetterName the new str left letter name
	 */
	public void setStrLeftLetterName(String[] strLeftLetterName) {
		this.strLeftLetterName = strLeftLetterName;
	}

	/**
	 * Gets the str right letter name.
	 * 
	 * @return the str right letter name
	 */
	public String[] getStrRightLetterName() {
		return strRightLetterName;
	}

	/**
	 * Sets the str right letter name.
	 * 
	 * @param strRightLetterName the new str right letter name
	 */
	public void setStrRightLetterName(String[] strRightLetterName) {
		this.strRightLetterName = strRightLetterName;
	}

	/**
	 * Gets the str store type combo.
	 * 
	 * @return the str store type combo
	 */
	public String getStrStoreTypeCombo() {
		return strStoreTypeCombo;
	}

	/**
	 * Sets the str store type combo.
	 * 
	 * @param strStoreTypeCombo the new str store type combo
	 */
	public void setStrStoreTypeCombo(String strStoreTypeCombo) {
		this.strStoreTypeCombo = strStoreTypeCombo;
	}

	/**
	 * Gets the str letter type id.
	 * 
	 * @return the str letter type id
	 */
	public String getStrLetterTypeId() {
		return strLetterTypeId;
	}

	/**
	 * Sets the str letter type id.
	 * 
	 * @param strLetterTypeId the new str letter type id
	 */
	public void setStrLetterTypeId(String strLetterTypeId) {
		this.strLetterTypeId = strLetterTypeId;
	}

	/**
	 * Gets the str letter type name.
	 * 
	 * @return the str letter type name
	 */
	public String getStrLetterTypeName() {
		return strLetterTypeName;
	}

	/**
	 * Sets the str letter type name.
	 * 
	 * @param strLetterTypeName the new str letter type name
	 */
	public void setStrLetterTypeName(String strLetterTypeName) {
		this.strLetterTypeName = strLetterTypeName;
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
	 * Gets the str store type name.
	 * 
	 * @return the str store type name
	 */
	public String getStrStoreTypeName() {
		return strStoreTypeName;
	}

	/**
	 * Sets the str store type name.
	 * 
	 * @param strStoreTypeName the new str store type name
	 */
	public void setStrStoreTypeName(String strStoreTypeName) {
		this.strStoreTypeName = strStoreTypeName;
	}

	/**
	 * Gets the str process id.
	 * 
	 * @return the str process id
	 */
	public String getStrProcessId() {
		return strProcessId;
	}

	/**
	 * Sets the str process id.
	 * 
	 * @param strProcessId the new str process id
	 */
	public void setStrProcessId(String strProcessId) {
		this.strProcessId = strProcessId;
	}

	/**
	 * Gets the str process name.
	 * 
	 * @return the str process name
	 */
	public String getStrProcessName() {
		return strProcessName;
	}

	/**
	 * Sets the str process name.
	 * 
	 * @param strProcessName the new str process name
	 */
	public void setStrProcessName(String strProcessName) {
		this.strProcessName = strProcessName;
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
	 * Gets the str ct date.
	 * 
	 * @return the str ct date
	 */
	public String getStrCtDate() {
		return strCtDate;
	}

	/**
	 * Gets the str left letter list name.
	 * 
	 * @return the str left letter list name
	 */
	public String getStrLeftLetterListName() {
		return strLeftLetterListName;
	}

	/**
	 * Sets the str left letter list name.
	 * 
	 * @param strLeftLetterListName the new str left letter list name
	 */
	public void setStrLeftLetterListName(String strLeftLetterListName) {
		this.strLeftLetterListName = strLeftLetterListName;
	}

	/**
	 * Gets the str right letter list name.
	 * 
	 * @return the str right letter list name
	 */
	public String getStrRightLetterListName() {
		return strRightLetterListName;
	}

	/**
	 * Sets the str right letter list name.
	 * 
	 * @param strRightLetterListName the new str right letter list name
	 */
	public void setStrRightLetterListName(String strRightLetterListName) {
		this.strRightLetterListName = strRightLetterListName;
	}

	/**
	 * Gets the str left letter type id.
	 * 
	 * @return the str left letter type id
	 */
	public String getStrLeftLetterTypeId() {
		return strLeftLetterTypeId;
	}

	/**
	 * Sets the str left letter type id.
	 * 
	 * @param strLeftLetterTypeId the new str left letter type id
	 */
	public void setStrLeftLetterTypeId(String strLeftLetterTypeId) {
		this.strLeftLetterTypeId = strLeftLetterTypeId;
	}

	/**
	 * Gets the str right letter type id.
	 * 
	 * @return the str right letter type id
	 */
	public String getStrRightLetterTypeId() {
		return strRightLetterTypeId;
	}

	/**
	 * Sets the str right letter type id.
	 * 
	 * @param strRightLetterTypeId the new str right letter type id
	 */
	public void setStrRightLetterTypeId(String strRightLetterTypeId) {
		this.strRightLetterTypeId = strRightLetterTypeId;
	}

	/**
	 * Gets the str process sl no.
	 * 
	 * @return the str process sl no
	 */
	public String getStrProcessSlNo() {
		return strProcessSlNo;
	}

	/**
	 * Sets the str process sl no.
	 * 
	 * @param strProcessSlNo the new str process sl no
	 */
	public void setStrProcessSlNo(String strProcessSlNo) {
		this.strProcessSlNo = strProcessSlNo;
	}

	/**
	 * Sets the str ct date.
	 * 
	 * @param strCtDate the new str ct date
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}

}
