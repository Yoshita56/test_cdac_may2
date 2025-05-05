/**
 * 
 */
package mms.masters.vo;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.TransferObject;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreHierarchyMstVO.
 * 
 * @author Anshul Jindal
 */
public class ShortenURLMstVO1 implements TransferObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The B exist status. */
	private Boolean BExistStatus = false;
	
	/** The str msg string. */
	private String strMsgString = "";
	
	/** The str msg type. */
	private String strMsgType = "";

	/** The str request type id. */
	private String strRequestTypeId = "";
	
	/** The str item cat id. */
	private String strItemCatId = "";

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str from store id. */
	private String strFromStoreId = "";
	
	/** The str to store id. */
	private String strToStoreId = "";
	
	/** The str from store name. */
	private String strFromStoreName = "";
	
	/** The str to store name. */
	private String strToStoreName = "";
	
	/** The str sl no. */
	private String strSLNo = "";
	
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
	
	/** The str chk1. */
	private String strChk1 = "";

	/** The str left store names list ws. */
	private WebRowSet strLeftStoreNamesListWs = null;
	
	/** The str left store names list. */
	private String strLeftStoreNamesList = "";
	
	/** The str right store names list ws. */
	private WebRowSet strRightStoreNamesListWs = null;
	
	/** The str right store names list. */
	private String strRightStoreNamesList = "";

	/** The str from store type id. */
	private String strFromStoreTypeId = "";
	
	/** The str from store level. */
	private String strFromStoreLevel = "";
	
	private String strAll;
	private String strAssociated;
	

	public String getStrAll() {
		return strAll;
	}

	public void setStrAll(String strAll) {
		this.strAll = strAll;
	}

	public String getStrAssociated() {
		return strAssociated;
	}

	public void setStrAssociated(String strAssociated) {
		this.strAssociated = strAssociated;
	}

	/**
	 * Gets the str left store names list ws.
	 * 
	 * @return the strLeftStoreNamesListWs
	 */
	public WebRowSet getStrLeftStoreNamesListWs() {
		return strLeftStoreNamesListWs;
	}

	/**
	 * Sets the str left store names list ws.
	 * 
	 * @param strLeftStoreNamesListWs the strLeftStoreNamesListWs to set
	 */
	public void setStrLeftStoreNamesListWs(WebRowSet strLeftStoreNamesListWs) {
		this.strLeftStoreNamesListWs = strLeftStoreNamesListWs;
	}

	/**
	 * Gets the str left store names list.
	 * 
	 * @return the strLeftStoreNamesList
	 */
	public String getStrLeftStoreNamesList() {
		return strLeftStoreNamesList;
	}

	/**
	 * Sets the str left store names list.
	 * 
	 * @param strLeftStoreNamesList the strLeftStoreNamesList to set
	 */
	public void setStrLeftStoreNamesList(String strLeftStoreNamesList) {
		this.strLeftStoreNamesList = strLeftStoreNamesList;
	}

	/**
	 * Gets the b exist status.
	 * 
	 * @return the bExistStatus
	 */
	public Boolean getBExistStatus() {
		return BExistStatus;
	}

	/**
	 * Sets the b exist status.
	 * 
	 * @param existStatus the bExistStatus to set
	 */
	public void setBExistStatus(Boolean existStatus) {
		BExistStatus = existStatus;
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
	 * Gets the str from store id.
	 * 
	 * @return the strFromStoreId
	 */
	public String getStrFromStoreId() {
		return strFromStoreId;
	}

	/**
	 * Sets the str from store id.
	 * 
	 * @param strFromStoreId the strFromStoreId to set
	 */
	public void setStrFromStoreId(String strFromStoreId) {
		this.strFromStoreId = strFromStoreId;
	}

	/**
	 * Gets the str to store id.
	 * 
	 * @return the strToStoreId
	 */
	public String getStrToStoreId() {
		return strToStoreId;
	}

	/**
	 * Sets the str to store id.
	 * 
	 * @param strToStoreId the strToStoreId to set
	 */
	public void setStrToStoreId(String strToStoreId) {
		this.strToStoreId = strToStoreId;
	}

	/**
	 * Gets the str from store name.
	 * 
	 * @return the strFromStoreName
	 */
	public String getStrFromStoreName() {
		return strFromStoreName;
	}

	/**
	 * Sets the str from store name.
	 * 
	 * @param strFromStoreName the strFromStoreName to set
	 */
	public void setStrFromStoreName(String strFromStoreName) {
		this.strFromStoreName = strFromStoreName;
	}

	/**
	 * Gets the str to store name.
	 * 
	 * @return the strToStoreName
	 */
	public String getStrToStoreName() {
		return strToStoreName;
	}

	/**
	 * Sets the str to store name.
	 * 
	 * @param strToStoreName the strToStoreName to set
	 */
	public void setStrToStoreName(String strToStoreName) {
		this.strToStoreName = strToStoreName;
	}

	/**
	 * Gets the str sl no.
	 * 
	 * @return the strSLNo
	 */
	public String getStrSLNo() {
		return strSLNo;
	}

	/**
	 * Sets the str sl no.
	 * 
	 * @param strSLNo the strSLNo to set
	 */
	public void setStrSLNo(String strSLNo) {
		this.strSLNo = strSLNo;
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
	 * Gets the serial version uid.
	 * 
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * Gets the str from store type id.
	 * 
	 * @return the strFromStoreTypeId
	 */
	public String getStrFromStoreTypeId() {
		return strFromStoreTypeId;
	}

	/**
	 * Sets the str from store type id.
	 * 
	 * @param strFromStoreTypeId the strFromStoreTypeId to set
	 */
	public void setStrFromStoreTypeId(String strFromStoreTypeId) {
		this.strFromStoreTypeId = strFromStoreTypeId;
	}

	/**
	 * Gets the str from store level.
	 * 
	 * @return the strFromStoreLevel
	 */
	public String getStrFromStoreLevel() {
		return strFromStoreLevel;
	}

	/**
	 * Sets the str from store level.
	 * 
	 * @param strFromStoreLevel the strFromStoreLevel to set
	 */
	public void setStrFromStoreLevel(String strFromStoreLevel) {
		this.strFromStoreLevel = strFromStoreLevel;
	}

	/**
	 * Gets the str right store names list ws.
	 * 
	 * @return the strRightStoreNamesListWs
	 */
	public WebRowSet getStrRightStoreNamesListWs() {
		return strRightStoreNamesListWs;
	}

	/**
	 * Sets the str right store names list ws.
	 * 
	 * @param strRightStoreNamesListWs the strRightStoreNamesListWs to set
	 */
	public void setStrRightStoreNamesListWs(WebRowSet strRightStoreNamesListWs) {
		this.strRightStoreNamesListWs = strRightStoreNamesListWs;
	}

	/**
	 * Gets the str right store names list.
	 * 
	 * @return the strRightStoreNamesList
	 */
	public String getStrRightStoreNamesList() {
		return strRightStoreNamesList;
	}

	/**
	 * Sets the str right store names list.
	 * 
	 * @param strRightStoreNamesList the strRightStoreNamesList to set
	 */
	public void setStrRightStoreNamesList(String strRightStoreNamesList) {
		this.strRightStoreNamesList = strRightStoreNamesList;
	}

	/**
	 * Gets the str request type id.
	 * 
	 * @return the strRequestTypeId
	 */
	public String getStrRequestTypeId() {
		return strRequestTypeId;
	}

	/**
	 * Sets the str request type id.
	 * 
	 * @param strRequestTypeId the strRequestTypeId to set
	 */
	public void setStrRequestTypeId(String strRequestTypeId) {
		this.strRequestTypeId = strRequestTypeId;
	}

	/**
	 * Gets the str item cat id.
	 * 
	 * @return the str item cat id
	 */
	public String getStrItemCatId() {
		return strItemCatId;
	}

	/**
	 * Sets the str item cat id.
	 * 
	 * @param strItemCatId the new str item cat id
	 */
	public void setStrItemCatId(String strItemCatId) {
		this.strItemCatId = strItemCatId;
	}

}
