package mms.masters.vo;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.TransferObject;

/**
 * @author Niharika Srivastava
 * Date Of Creation : Aug 25, 2010
 * Team Lead : Ajay Kumar Gupta
 * Module   : MMS
 * Process  : Drug Contradiction Master
 * Description : VO for Drug Contradiction Master
 * Last Modified By :
 * Last Modification Date : 
 */

public class ShortenURLMstVO implements TransferObject{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/** The str msg string. */
	private String strMsgString = "";
	
	/** The str msg type. */
	private String strMsgType = "";
	
	/** The str module id. */
	private String strModuleId = "";
	
	private WebRowSet strGroupComboWs = null;
	
	private WebRowSet strDrugNameComboWs= null;
	
	/** The Left item list ws. */
	private WebRowSet LeftItemListWS = null;
	
	/** The Right item list ws. */
	private WebRowSet RightItemListWS = null;

	/** The str right item ids. */
	private String[] strRightItemIds = null;
	
	/** The str left item ids. */
	private String[] strLeftItemIds = null;

	/** The str hospital code. */
	private String strHospitalCode = "";
	
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

	private String strDrugId = "";
	
	private String strGroupId = "";
	
	private String strContraDrugSlNo = "";
	
	private String strDrugName="";
	
	private String strContraDrugs="";
	
	private String strContraDrugsId="";
	
	private String strProId="";
	
	private String strBaseId="";
	
	private String strOrgID="";
	
	public String getStrOrgID() {
		return strOrgID;
	}

	public void setStrOrgID(String strOrgID) {
		this.strOrgID = strOrgID;
	}

	public String getStrProId() {
		return strProId;
	}

	public void setStrProId(String strProId) {
		this.strProId = strProId;
	}

	
	
	public String getStrBaseId() {
		return strBaseId;
	}

	public void setStrBaseId(String strBaseId) {
		this.strBaseId = strBaseId;
	}

	/** The b exist status. */
	private Boolean bExistStatus = false;
	
	private WebRowSet contraDrugNameWs = null;
	
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
	 * @return the leftItemListWS
	 */
	public WebRowSet getLeftItemListWS() {
		return LeftItemListWS;
	}

	/**
	 * @param leftItemListWS the leftItemListWS to set
	 */
	public void setLeftItemListWS(WebRowSet leftItemListWS) {
		LeftItemListWS = leftItemListWS;
	}

	/**
	 * @return the rightItemListWS
	 */
	public WebRowSet getRightItemListWS() {
		return RightItemListWS;
	}

	/**
	 * @param rightItemListWS the rightItemListWS to set
	 */
	public void setRightItemListWS(WebRowSet rightItemListWS) {
		RightItemListWS = rightItemListWS;
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
	 * @return the strModuleId
	 */
	public String getStrModuleId() {
		return strModuleId;
	}

	/**
	 * @param strModuleId the strModuleId to set
	 */
	public void setStrModuleId(String strModuleId) {
		this.strModuleId = strModuleId;
	}

	/**
	 * @return the strGroupComboWs
	 */
	public WebRowSet getStrGroupComboWs() {
		return strGroupComboWs;
	}

	/**
	 * @param strGroupComboWs the strGroupComboWs to set
	 */
	public void setStrGroupComboWs(WebRowSet strGroupComboWs) {
		this.strGroupComboWs = strGroupComboWs;
	}

	/**
	 * @return the strDrugNameComboWs
	 */
	public WebRowSet getStrDrugNameComboWs() {
		return strDrugNameComboWs;
	}

	/**
	 * @param strDrugNameComboWs the strDrugNameComboWs to set
	 */
	public void setStrDrugNameComboWs(WebRowSet strDrugNameComboWs) {
		this.strDrugNameComboWs = strDrugNameComboWs;
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
	 * @return the strContraDrugSlNo
	 */
	public String getStrContraDrugSlNo() {
		return strContraDrugSlNo;
	}

	/**
	 * @param strContraDrugSlNo the strContraDrugSlNo to set
	 */
	public void setStrContraDrugSlNo(String strContraDrugSlNo) {
		this.strContraDrugSlNo = strContraDrugSlNo;
	}

	/**
	 * @return the bExistStatus
	 */
	public Boolean getBExistStatus() {
		return bExistStatus;
	}

	/**
	 * @param existStatus the bExistStatus to set
	 */
	public void setBExistStatus(Boolean existStatus) {
		bExistStatus = existStatus;
	}

	/**
	 * @return the strContraDrugsId
	 */
	public String getStrContraDrugsId() {
		return strContraDrugsId;
	}

	/**
	 * @param strContraDrugsId the strContraDrugsId to set
	 */
	public void setStrContraDrugsId(String strContraDrugsId) {
		this.strContraDrugsId = strContraDrugsId;
	}

	/**
	 * @return the contraDrugNameWs
	 */
	public WebRowSet getContraDrugNameWs() {
		return contraDrugNameWs;
	}

	/**
	 * @param contraDrugNameWs the contraDrugNameWs to set
	 */
	public void setContraDrugNameWs(WebRowSet contraDrugNameWs) {
		this.contraDrugNameWs = contraDrugNameWs;
	}

}
