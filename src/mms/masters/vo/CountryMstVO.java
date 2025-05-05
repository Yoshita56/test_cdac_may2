package mms.masters.vo;

public class CountryMstVO {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** *******************************. */
	
	/** The str Country name. */
	private String strCountryName="";
	
	/** The str Effective name. */
	private String strCountryShortName="";
	
	/** The str nationality. */
	private String strNationality="";
	
	/** The str current date. */
	private String strCtDate="";
	
	/** The str hl7Code. */
	private String strhl7Code="";
	

	
	/** *********************************. */
	
	
	private String strIsValid = "";
	
	
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
	
	/** The str source Id. */
	private String strCountryCode="";
	
	
	/** The boolean Exit Status. */
	Boolean bExistStatus;
	
	
	
	/** *********************************. */
	
	/**
	 * Gets the str Country Name.
	 * 
	 * @return the str Country Name
	 */
	public String getStrCountryName() {
		return strCountryName;
	}
	
	/**
	 * Sets the str Country Name.
	 * 
	 * @param setStrCountryName the str Country Name
	 */
	public void setStrCountryName(String strCountryName) {
		this.strCountryName = strCountryName;
	}
	
	
	
	
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
	 * Gets the str Country id.
	 * 
	 * @return the str Country Code
	 */
	public String getStrCountryCode() {
		return strCountryCode;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param strCountryId the str Country Code
	 */
	public void setStrCountryCode(String strCountryCode) {
		this.strCountryCode = strCountryCode;
	}

	public String getStrCountryShortName() {
		return strCountryShortName;
	}

	public void setStrCountryShortName(String strCountryShortName) {
		this.strCountryShortName = strCountryShortName;
	}

	public String getStrNationality() {
		return strNationality;
	}

	public void setStrNationality(String strNationality) {
		this.strNationality = strNationality;
	}

	public String getStrCtDate() {
		return strCtDate;
	}

	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}

	public String getStrhl7Code() {
		return strhl7Code;
	}

	public void setStrhl7Code(String strhl7Code) {
		this.strhl7Code = strhl7Code;
	}



}
