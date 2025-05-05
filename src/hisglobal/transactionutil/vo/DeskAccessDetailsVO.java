package hisglobal.transactionutil.vo;

import hisglobal.utility.TransferObject;

import javax.sql.rowset.WebRowSet;

public class DeskAccessDetailsVO implements TransferObject{
	
	private static final long serialVersionUID = 02L;

	
	private String strMsgString = "";
	private String strMsgType = "";
	
	private String strHospitalCode = "";
	private String strIsValid = "";
	
	private String strUserId = "";
	private String strDeskId = "";
	private String strMenuId = "";
	private String strEffectiveFrom = "";
	private String strSeatId = "";
	private String strMenuPosition = "";
	
	
	private String strUserNameCombo = "";
	private String strDeskNameCombo = "";
	private String strLeftMenuList = "";
	private String strRightMenuList = "";
	
	private WebRowSet userNameComboWS =null;
	private WebRowSet deskNameComboWS =null;
	private WebRowSet leftMenuListWS =null;
	private WebRowSet rightMenuListWS =null;
	
	private String strLeftMenuNames = "";
	private String strRightMenuNames = "";
	
	/**
	 * @return the strLeftMenuNames
	 */
	public String getStrLeftMenuNames() {
		return strLeftMenuNames;
	}
	/**
	 * @param strLeftMenuNames the strLeftMenuNames to set
	 */
	public void setStrLeftMenuNames(String strLeftMenuNames) {
		this.strLeftMenuNames = strLeftMenuNames;
	}
	/**
	 * @return the strRightMenuNames
	 */
	public String getStrRightMenuNames() {
		return strRightMenuNames;
	}
	/**
	 * @param strRightMenuNames the strRightMenuNames to set
	 */
	public void setStrRightMenuNames(String strRightMenuNames) {
		this.strRightMenuNames = strRightMenuNames;
	}
	/**
	 * @return the strMsgString
	 */
	public String getStrMsgString() {
		return strMsgString;
	}
	/**
	 * @param strMsgString the strMsgString to set
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}
	/**
	 * @return the strMsgType
	 */
	public String getStrMsgType() {
		return strMsgType;
	}
	/**
	 * @param strMsgType the strMsgType to set
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
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
	 * @return the strDeskId
	 */
	public String getStrDeskId() {
		return strDeskId;
	}
	/**
	 * @param strDeskId the strDeskId to set
	 */
	public void setStrDeskId(String strDeskId) {
		this.strDeskId = strDeskId;
	}
	/**
	 * @return the strMenuId
	 */
	public String getStrMenuId() {
		return strMenuId;
	}
	/**
	 * @param strMenuId the strMenuId to set
	 */
	public void setStrMenuId(String strMenuId) {
		this.strMenuId = strMenuId;
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
	 * @return the strMenuPosition
	 */
	public String getStrMenuPosition() {
		return strMenuPosition;
	}
	/**
	 * @param strMenuPosition the strMenuPosition to set
	 */
	public void setStrMenuPosition(String strMenuPosition) {
		this.strMenuPosition = strMenuPosition;
	}
	/**
	 * @return the strUserNameCombo
	 */
	public String getStrUserNameCombo() {
		return strUserNameCombo;
	}
	/**
	 * @param strUserNameCombo the strUserNameCombo to set
	 */
	public void setStrUserNameCombo(String strUserNameCombo) {
		this.strUserNameCombo = strUserNameCombo;
	}
	/**
	 * @return the strDeskNameCombo
	 */
	public String getStrDeskNameCombo() {
		return strDeskNameCombo;
	}
	/**
	 * @param strDeskNameCombo the strDeskNameCombo to set
	 */
	public void setStrDeskNameCombo(String strDeskNameCombo) {
		this.strDeskNameCombo = strDeskNameCombo;
	}
	/**
	 * @return the strLeftMenuList
	 */
	public String getStrLeftMenuList() {
		return strLeftMenuList;
	}
	/**
	 * @param strLeftMenuList the strLeftMenuList to set
	 */
	public void setStrLeftMenuList(String strLeftMenuList) {
		this.strLeftMenuList = strLeftMenuList;
	}
	/**
	 * @return the strRightMenuList
	 */
	public String getStrRightMenuList() {
		return strRightMenuList;
	}
	/**
	 * @param strRightMenuList the strRightMenuList to set
	 */
	public void setStrRightMenuList(String strRightMenuList) {
		this.strRightMenuList = strRightMenuList;
	}
	/**
	 * @return the userNameComboWS
	 */
	public WebRowSet getUserNameComboWS() {
		return userNameComboWS;
	}
	/**
	 * @param userNameComboWS the userNameComboWS to set
	 */
	public void setUserNameComboWS(WebRowSet userNameComboWS) {
		this.userNameComboWS = userNameComboWS;
	}
	/**
	 * @return the deskNameComboWS
	 */
	public WebRowSet getDeskNameComboWS() {
		return deskNameComboWS;
	}
	/**
	 * @param deskNameComboWS the deskNameComboWS to set
	 */
	public void setDeskNameComboWS(WebRowSet deskNameComboWS) {
		this.deskNameComboWS = deskNameComboWS;
	}
	/**
	 * @return the leftMenuListWS
	 */
	public WebRowSet getLeftMenuListWS() {
		return leftMenuListWS;
	}
	/**
	 * @param leftMenuListWS the leftMenuListWS to set
	 */
	public void setLeftMenuListWS(WebRowSet leftMenuListWS) {
		this.leftMenuListWS = leftMenuListWS;
	}
	/**
	 * @return the rightMenuListWS
	 */
	public WebRowSet getRightMenuListWS() {
		return rightMenuListWS;
	}
	/**
	 * @param rightMenuListWS the rightMenuListWS to set
	 */
	public void setRightMenuListWS(WebRowSet rightMenuListWS) {
		this.rightMenuListWS = rightMenuListWS;
	}
	/**
	 * @return the strUserId
	 */
	public String getStrUserId() {
		return strUserId;
	}
	/**
	 * @param strUserId the strUserId to set
	 */
	public void setStrUserId(String strUserId) {
		this.strUserId = strUserId;
	}

}
