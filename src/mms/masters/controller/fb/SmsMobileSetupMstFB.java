package mms.masters.controller.fb;

import hisglobal.masterutil.GenericFormBean;



/**
 * @author:-	  
 * Creation Date:- 07-Jan-2012 
 * Modifying Date:- 
 * Used For:-	
 * Team Lead By:-	
 *  Module:- DWH(HIS Project)
 * 
 */


/**
 * The Class LabMstFB.
 */

public class SmsMobileSetupMstFB extends GenericFormBean 
{
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** *******************************. */
	/** The str Lab No. */
	private String strProcessId="";
	
	
	/** The str User Lab No. */
	private String strReqTypeId="";
	
	/** The str Lab name. */
	private String strProcessName="";
	
	/** The str Lab Type. */
	private String strLabType="";
	
	/** The str  Phone No . */
	private String strPhoneNo;
	
	
	

	
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
	
	
	
	/** The str Last Modified seat Id. */
	private String strLastModifiedSeatId="";
	
	/** The str Last Modified date. */
	private String strLastModifiedDate="";
	
	/** The boolean Exit Status. */
	Boolean bExistStatus;

	public String getStrProcessName() {
		return strProcessName;
	}

	public void setStrProcessName(String strProcessName) {
		this.strProcessName = strProcessName;
	}

	/**
	 * Gets the strLabType.
	 * 
	 * @return the str Lab Type
	 */
	public String getStrLabType() {
		return strLabType;
	}

	/**
	 * Sets the str str Lab Type.
	 * 
	 * @param strLabType the new str Lab Type
	 */
	public void setStrLabType(String strLabType) {
		this.strLabType = strLabType;
	}

	/**
	 * Gets the strPhoneNo.
	 * 
	 * @return the str Phone No 
	 */
	public String getStrPhoneNo() {
		return strPhoneNo;
	}

	/**
	 * Sets the str Phone No.
	 * 
	 * @param strPhoneNo the new str Phone No
	 */
	public void setStrPhoneNo(String strPhoneNo) {
		this.strPhoneNo = strPhoneNo;
	}

	/**
	 * Gets the bExistStatus.
	 * 
	 * @return the bExistStatus
	 */
	public Boolean getbExistStatus() {
		return bExistStatus;
	}

	/**
	 * Sets the bExistStatus.
	 * 
	 * @param bExistStatus the new bExistStatus
	 */
	public void setbExistStatus(Boolean bExistStatus) {
		this.bExistStatus = bExistStatus;
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

	public String getStrProcessId() {
		return strProcessId;
	}

	public void setStrProcessId(String strProcessId) {
		this.strProcessId = strProcessId;
	}

	public String getStrReqTypeId() {
		return strReqTypeId;
	}

	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}


	
}
