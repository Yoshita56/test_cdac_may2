package mms.masters.vo;

/**
 * @author:-	Adil Wasi   
 * Creation Date:- 1-Jun-2011 
 * Modifying Date:- 
 * Used For:-	
 * Team Lead By:-	
 *  Module:- DWH(HIS Project)
 * 
 */



/**
 * The Class SchemeMstVO.
 */
public class SchemeMstVO {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** *******************************. */
	
	/** The str Scheme name. */
	private String strSchemeName="";
	
	/** The str Effective name. */
	private String strEffectiveFrom="";
	
	/** The str Remarks. */
	private String strRemarks="";
	

	
	/** *********************************. */
	
	
	private String strIsValid = "";
	
	/** The str ct date. */
	private String strCtDate = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str Msg type. */
	private String strMsgType = "";
	
	/** The str msg. */
	private String strMsgString = "";
	
	/** The str Error msg. */
	private String strErrMsg = "";
	
	/** The str warning msg. */
	private String strWarningMsg = "";
	
	/** The str Normal msg. */
	private String strNormalMsg = "";
	
	/** The str Seat Id. */
	private String strSeatId="";
	
	/** The str scheme Id. */
	private String strSchemeId="";
	
	/** The str Last Modified seat Id. */
	private String strLastModifiedSeatId="";
	
	/** The str Last Modified date. */
	private String strLastModifiedDate="";
	
	/** The boolean Exit Status. */
	Boolean bExistStatus;
	
	/** *********************************. */
	
	/**
	 * Gets the str Scheme Name.
	 * 
	 * @return the str Scheme Name
	 */
	public String getStrSchemeName() {
		return strSchemeName;
	}
	
	/**
	 * Sets the str Scheme Name.
	 * 
	 * @param setStrSchemeName the str Scheme Name
	 */
	public void setStrSchemeName(String strSchemeName) {
		this.strSchemeName = strSchemeName;
	}
	
	/**
	 * Gets the str Effective From.
	 * 
	 * @return the str Effective From
	 */
	public String getStrEffectiveFrom() {
		return strEffectiveFrom;
	}
	
	/**
	 * Sets the str Effective From.
	 * 
	 * @param strEffectiveFrom the new str Effective From
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
	 * Gets the str isValid.
	 * 
	 * @return the str isValid
	 */
	public String getStrIsValid() {
		return strIsValid;
	}
	
	/**
	 * Sets the str isValid.
	 * 
	 * @param strIsValid the new str remarks
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
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
	 * Sets the str ct date.
	 * 
	 * @param strCtDate the str ct date
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}
	
	
	public String getStrMsgType() {
		return strMsgType;
	}
	
	/**
	 * Sets the str Msg Tpye.
	 * 
	 * @param strCtDate the str msg type
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}
	/**
	 * Gets the str msg String.
	 * 
	 * @return the str msg String
	 */
	public String getStrMsgString() {
		return strMsgString;
	}
	
	/**
	 * Sets the str msg String.
	 * 
	 * @param strMsgString the new str msg String.
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}
	
	/**
	 * Gets the str err Msg.
	 * 
	 * @return the str err Msg.
	 */
	public String getStrErrMsg() {
		return strErrMsg;
	}
	
	/**
	 * Sets the str err Msg.
	 * 
	 * @param strErrMsg the new str err Msg.
	 */
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}
	
	/**
	 * Gets the str warning Msg.
	 * 
	 * @return the str warning Msg
	 */
	public String getStrWarningMsg() {
		return strWarningMsg;
	}
	
	/**
	 * Sets the str warning Msg.
	 * 
	 * @param strWarningMsg the new str warning Msg
	 */
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}
	
	/**
	 * Gets the str Normal Msg.
	 * 
	 * @return the str Normal Msg
	 */
	public String getStrNormalMsg() {
		return strNormalMsg;
	}
	
	/**
	 * Sets the str Normal Msg.
	 * 
	 * @param strNormalMsg the str Normal Msg
	 */
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
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
	 * Gets the boolean bExit status.
	 * 
	 * @return the boolean bExit status
	 */
	public Boolean getBExistStatus() {
		return bExistStatus;
	}

	/**
	 * Sets the boolean bExit status.
	 * 
	 * @param getBExistStatus the boolean bExit status
	 */
	public void setBExistStatus(Boolean existStatus) {
		bExistStatus = existStatus;
	}

	/**
	 * Gets the str seat id.
	 * 
	 * @return the boolean bExit status
	 */
	public String getStrSeatId() {
		return strSeatId;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param getStrSeatId the boolean bExit status
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * Gets the str Scheme id.
	 * 
	 * @return the boolean bExit status
	 */
	public String getStrSchemeId() {
		return strSchemeId;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param strSchemeId the str Scheme Id
	 */
	public void setStrSchemeId(String strSchemeId) {
		this.strSchemeId = strSchemeId;
	}

	/**
	 * Gets the str Last Modified SeatId.
	 * 
	 * @return the str Last Modified SeatId
	 */
	public String getStrLastModifiedSeatId() {
		return strLastModifiedSeatId;
	}

	/**
	 * Sets the Str Last Modified Seat Id.
	 * 
	 * @param strLastModifiedSeatId the Str Last Modified Seat Id
	 */
	public void setStrLastModifiedSeatId(String strLastModifiedSeatId) {
		this.strLastModifiedSeatId = strLastModifiedSeatId;
	}

	/**
	 * Gets the str Last Modified Date.
	 * 
	 * @return the str Last Modified Date
	 */
	public String getStrLastModifiedDate() {
		return strLastModifiedDate;
	}
	/**
	 * Sets the str Last Modified Date.
	 * 
	 * @param strLastModifiedDate the str Last Modified Date
	 */
	public void setStrLastModifiedDate(String strLastModifiedDate) {
		this.strLastModifiedDate = strLastModifiedDate;
	}

}
