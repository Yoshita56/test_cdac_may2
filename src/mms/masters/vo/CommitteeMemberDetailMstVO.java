package mms.masters.vo;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class CommitteeMemberDetailMstVO.
 */
public class CommitteeMemberDetailMstVO {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The str cat no. */
	private String strCatNo = "";
	
	/** The str cat values. */
	private String strCatValues = "";
	
	private String strCatCodesFromSession = "";
	
	/** The item category ws. */
	private WebRowSet itemCategoryWS = null;
	
	/** The req type ws. */
	private WebRowSet reqTypeWS = null;
	
	/** The comm type ws. */
	private WebRowSet commTypeWS = null;
	
	/** The str req type id. */
	private String strReqTypeId = "";
	
	/** The str req type values. */
	private String strReqTypeValues = "";

	/** The str update emp inf ws. */
	private WebRowSet[] strUpdateEmpInfWs = null;
	
	/** The str update emp name ws. */
	private WebRowSet[] strUpdateEmpNameWs = null;
	
	/** The str emp inf data ws. */
	private WebRowSet strEmpInfDataWs = null;
	
	/** The str emp commt no sl no data ws. */
	private WebRowSet strEmpCommtNoSlNoDataWs = null;
	
	private WebRowSet strUserIdWs = null;
	
	/** *******************************. */
	private String strMemebrDtl = "";
	
	/** The str tmp. */
	private String strTmp = "";
	
	/** The str member dtl ws. */
	private WebRowSet strMemberDtlWs = null;
	
	/** The str committe dtl. */
	private String strCommitteDtl = "";
	
	/** The str emp number. */
	private String strEmpNumber = "";
	
	/** The str member name. */
	private String strMemberName = "";
	
	/** The str case. */
	private String strCase = "";
	
	/** The str emp number combo. */
	private String strEmpNumberCombo = "";
	
	/** The str member e mail. */
	private String strMemberEMail = "";
	
	/** The str member phone no. */
	private String strMemberPhoneNo = "";
	
	/** The str prev val. */
	private String strPrevVal = "";

	/** The str rec. */
	private String[] strRec = { "" };
	
	/** The str chk box. */
	private String[] strChkBox = { "" };
	
	/** The str comm type id. */
	private String strCommTypeId = "";

	/** *******************************. */
	private WebRowSet strUpdateEmpInfHLPWs = null;
	
	/** The str update emp name hlp ws. */
	private WebRowSet strUpdateEmpNameHLPWs = null;
	
	/** The str emp no update mr combo dummy. */
	private String[] strEmpNoUpdateMRComboDummy = { "0" };
	
	/** The str is employee update mr dummy. */
	private String[] strIsEmployeeUpdateMRDummy = { "" };

	/** The B exist status. */
	private Boolean BExistStatus = false;
	
	/** The str msg string. */
	private String strMsgString = "";
	
	/** The str msg type. */
	private String strMsgType = "";
	
	/** The Update or add. */
	private String UpdateOrAdd = "";

	/** The str user id combo. */
	private String strUserIdCombo = "";
	
	/** The str emp no data. */
	private String[] strEmpNoData = { "0" };
	
	/** The str committe no. */
	private String[] strCommitteNo = { "0" };
	
	/** The str commeitte sl no. */
	private String[] strCommeitteSlNo = { "0" };
	
	/** The str emp no combo. */
	private String[] strEmpNoCombo = { "0" };

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str group id. */
	private String strGroupId = "";

	/** The Dummy commite type. */
	private String DummyCommiteType = "";
	
	/** The str commeitte sl no1. */
	private String strCommeitteSlNo1 = "";
	
	/** The str group name. */
	private String strGroupName = "";
	
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
	
	/** The str ct date. */
	private String strCtDate = "";

	/** The str msg. */
	private String strMsg = "";
	
	/** The str warning. */
	private String strWarning = "";

	/** *************MASTER FIELD*****************. */
	private String[] strArrCommiteeNo = { "0" };
	
	/** The str commit no. */
	private String strCommitNo = "";
	
	/** The str contitute date. */
	private String strContituteDate = "";
	
	/** The str constitute by id. */
	private String strConstituteById = "";
	
	/** The str constitute by id data. */
	private String[] strConstituteByIdData = { "0" };
	
	/** The str emp no update combo. */
	private String[] strEmpNoUpdateCombo = { "0" };
	
	/** The str emp no update mr combo. */
	private String[] strEmpNoUpdateMRCombo = { "0" };
	
	/** The str mode. */
	private String strMode = "";
	
	/** The str commetie type id. */
	private String strCommetieTypeId = "";
	
	/** The str store type id. */
	private String strStoreTypeID = "";
	
	/** The str store type. */
	private String strStoreType = "";
	
	/** The str store type combo. */
	private String strStoreTypeCombo = "";
	
	/** The str committe type. */
	private String strCommitteType = "";
	
	/** The str committe type combo. */
	private String strCommitteTypeCombo = "";
	
	/** The str committee purpose. */
	private String strCommitteePurpose = "";
	
	/** The str constitute date. */
	private String strConstituteDate = "";
	
	/** The str constitute by. */
	private String strConstituteBy = "";
	
	/** The str constitute by combo. */
	private String strConstituteByCombo = "";
	
	/** The str effective to. */
	private String strEffectiveTo = "";
	
	/** The str committe status. */
	private String strCommitteStatus = "";

	/** The str update hlp. */
	private String strUpdateHLP = "";
	
	/** The str is employee. */
	private String[] strIsEmployee = { "0" };
	
	/** The str emp no. */
	private String[] strEmpNo = { "0" };
	
	/** The str emp name. */
	private String[] strEmpName = null;
	
	/** The str emp addr. */
	private String[] strEmpAddr = null;
	
	/** The str emp phone. */
	private String[] strEmpPhone = null;
	
	/** The str emp email. */
	private String[] strEmpEmail = null;
	
	/** The str emp user id. */
	private String[] strEmpUserId = null;
	
	/** The str emp level. */
	private String[] strEmpLevel = null;

	/** The str emp name hlp. */
	private String strEmpNameHLP = null;
	
	/** The str emp addr hlp. */
	private String strEmpAddrHLP = null;
	
	/** The str emp phone hlp. */
	private String strEmpPhoneHLP = null;
	
	/** The str emp email hlp. */
	private String strEmpEmailHLP = null;

	/** The str constitute date update. */
	private String strConstituteDateUpdate = "";
	
	/** The str constitute by combo update. */
	private String strConstituteByComboUpdate = "";
	
	/** The str effective from update. */
	private String strEffectiveFromUpdate = "";
	
	/** The str effective to update. */
	private String strEffectiveToUpdate = "";
	
	/** The str is employee update. */
	private String[] strIsEmployeeUpdate = { "0" };
	
	/** The str option update. */
	private String[] strOptionUpdate = null;
	
	/** The str emp no update. */
	private String[] strEmpNoUpdate = { "0" };
	
	/** The str emp name update. */
	private String[] strEmpNameUpdate = null;
	
	/** The str emp addr update. */
	private String[] strEmpAddrUpdate = null;
	
	/** The str emp phone update. */
	private String[] strEmpPhoneUpdate = null;
	
	/** The str emp email update. */
	private String[] strEmpEmailUpdate = null;
	
	/** The str emp user id update. */
	private String[] strEmpUserIdUpdate = null;
	
	/** The str emp level update. */
	private String[] strEmpLevelUpdate = null;

	/** The str is employee update mr. */
	private String[] strIsEmployeeUpdateMR = null;
	
	/** The str option update mr. */
	private String[] strOptionUpdateMR = { "0" };
	
	/** The str emp no update mr. */
	private String[] strEmpNoUpdateMR = { "0" };
	
	/** The str emp name update mr. */
	private String[] strEmpNameUpdateMR = null;
	
	/** The str emp addr update mr. */
	private String[] strEmpAddrUpdateMR = null;
	
	/** The str emp phone update mr. */
	private String[] strEmpPhoneUpdateMR = null;
	
	/** The str emp email update mr. */
	private String[] strEmpEmailUpdateMR = null;
	
	/** The str emp user id update mr. */
	private String[] strEmpUserIdUpdateMR = null;
	
	/** The str emp level update mr. */
	private String[] strEmpLevelUpdateMR = null;
	
	private String strIsChairPerson;

	public String getStrIsChairPerson() {
		return strIsChairPerson;
	}

	public void setStrIsChairPerson(String strIsChairPerson) {
		this.strIsChairPerson = strIsChairPerson;
	}

	/**
	 * Gets the str constitute date update.
	 * 
	 * @return the str constitute date update
	 */
	public String getStrConstituteDateUpdate() {
		return strConstituteDateUpdate;
	}

	/**
	 * Sets the str constitute date update.
	 * 
	 * @param strConstituteDateUpdate the new str constitute date update
	 */
	public void setStrConstituteDateUpdate(String strConstituteDateUpdate) {
		this.strConstituteDateUpdate = strConstituteDateUpdate;
	}

	/**
	 * Gets the str constitute by combo update.
	 * 
	 * @return the str constitute by combo update
	 */
	public String getStrConstituteByComboUpdate() {
		return strConstituteByComboUpdate;
	}

	/**
	 * Sets the str constitute by combo update.
	 * 
	 * @param strConstituteByComboUpdate the new str constitute by combo update
	 */
	public void setStrConstituteByComboUpdate(String strConstituteByComboUpdate) {
		this.strConstituteByComboUpdate = strConstituteByComboUpdate;
	}

	/**
	 * Gets the str effective from update.
	 * 
	 * @return the str effective from update
	 */
	public String getStrEffectiveFromUpdate() {
		return strEffectiveFromUpdate;
	}

	/**
	 * Sets the str effective from update.
	 * 
	 * @param strEffectiveFromUpdate the new str effective from update
	 */
	public void setStrEffectiveFromUpdate(String strEffectiveFromUpdate) {
		this.strEffectiveFromUpdate = strEffectiveFromUpdate;
	}

	/**
	 * Gets the str effective to update.
	 * 
	 * @return the str effective to update
	 */
	public String getStrEffectiveToUpdate() {
		return strEffectiveToUpdate;
	}

	/**
	 * Sets the str effective to update.
	 * 
	 * @param strEffectiveToUpdate the new str effective to update
	 */
	public void setStrEffectiveToUpdate(String strEffectiveToUpdate) {
		this.strEffectiveToUpdate = strEffectiveToUpdate;
	}

	/**
	 * Gets the str is employee update.
	 * 
	 * @return the str is employee update
	 */
	public String[] getStrIsEmployeeUpdate() {
		return strIsEmployeeUpdate;
	}

	/**
	 * Sets the str is employee update.
	 * 
	 * @param strIsEmployeeUpdate the new str is employee update
	 */
	public void setStrIsEmployeeUpdate(String[] strIsEmployeeUpdate) {
		this.strIsEmployeeUpdate = strIsEmployeeUpdate;
	}

	/**
	 * Gets the str option update.
	 * 
	 * @return the str option update
	 */
	public String[] getStrOptionUpdate() {
		return strOptionUpdate;
	}

	/**
	 * Sets the str option update.
	 * 
	 * @param strOptionUpdate the new str option update
	 */
	public void setStrOptionUpdate(String[] strOptionUpdate) {
		this.strOptionUpdate = strOptionUpdate;
	}

	/**
	 * Gets the str emp no update.
	 * 
	 * @return the str emp no update
	 */
	public String[] getStrEmpNoUpdate() {
		return strEmpNoUpdate;
	}

	/**
	 * Sets the str emp no update.
	 * 
	 * @param strEmpNoUpdate the new str emp no update
	 */
	public void setStrEmpNoUpdate(String[] strEmpNoUpdate) {
		this.strEmpNoUpdate = strEmpNoUpdate;
	}

	/**
	 * Gets the str emp name update.
	 * 
	 * @return the str emp name update
	 */
	public String[] getStrEmpNameUpdate() {
		return strEmpNameUpdate;
	}

	/**
	 * Sets the str emp name update.
	 * 
	 * @param strEmpNameUpdate the new str emp name update
	 */
	public void setStrEmpNameUpdate(String[] strEmpNameUpdate) {
		this.strEmpNameUpdate = strEmpNameUpdate;
	}

	/**
	 * Gets the str emp addr update.
	 * 
	 * @return the str emp addr update
	 */
	public String[] getStrEmpAddrUpdate() {
		return strEmpAddrUpdate;
	}

	/**
	 * Sets the str emp addr update.
	 * 
	 * @param strEmpAddrUpdate the new str emp addr update
	 */
	public void setStrEmpAddrUpdate(String[] strEmpAddrUpdate) {
		this.strEmpAddrUpdate = strEmpAddrUpdate;
	}

	/**
	 * Gets the str emp phone update.
	 * 
	 * @return the str emp phone update
	 */
	public String[] getStrEmpPhoneUpdate() {
		return strEmpPhoneUpdate;
	}

	/**
	 * Sets the str emp phone update.
	 * 
	 * @param strEmpPhoneUpdate the new str emp phone update
	 */
	public void setStrEmpPhoneUpdate(String[] strEmpPhoneUpdate) {
		this.strEmpPhoneUpdate = strEmpPhoneUpdate;
	}

	/**
	 * Gets the str emp email update.
	 * 
	 * @return the str emp email update
	 */
	public String[] getStrEmpEmailUpdate() {
		return strEmpEmailUpdate;
	}

	/**
	 * Sets the str emp email update.
	 * 
	 * @param strEmpEmailUpdate the new str emp email update
	 */
	public void setStrEmpEmailUpdate(String[] strEmpEmailUpdate) {
		this.strEmpEmailUpdate = strEmpEmailUpdate;
	}

	/**
	 * Gets the str emp user id update.
	 * 
	 * @return the str emp user id update
	 */
	public String[] getStrEmpUserIdUpdate() {
		return strEmpUserIdUpdate;
	}

	/**
	 * Sets the str emp user id update.
	 * 
	 * @param strEmpUserIdUpdate the new str emp user id update
	 */
	public void setStrEmpUserIdUpdate(String[] strEmpUserIdUpdate) {
		this.strEmpUserIdUpdate = strEmpUserIdUpdate;
	}

	/**
	 * Gets the str emp level update.
	 * 
	 * @return the str emp level update
	 */
	public String[] getStrEmpLevelUpdate() {
		return strEmpLevelUpdate;
	}

	/**
	 * Sets the str emp level update.
	 * 
	 * @param strEmpLevelUpdate the new str emp level update
	 */
	public void setStrEmpLevelUpdate(String[] strEmpLevelUpdate) {
		this.strEmpLevelUpdate = strEmpLevelUpdate;
	}

	/**
	 * Gets the str is employee.
	 * 
	 * @return the str is employee
	 */
	public String[] getStrIsEmployee() {
		return strIsEmployee;
	}

	/**
	 * Sets the str is employee.
	 * 
	 * @param strIsEmployee the new str is employee
	 */
	public void setStrIsEmployee(String[] strIsEmployee) {
		this.strIsEmployee = strIsEmployee;
	}

	/**
	 * Gets the str emp no.
	 * 
	 * @return the str emp no
	 */
	public String[] getStrEmpNo() {
		return strEmpNo;
	}

	/**
	 * Sets the str emp no.
	 * 
	 * @param strEmpNo the new str emp no
	 */
	public void setStrEmpNo(String[] strEmpNo) {
		this.strEmpNo = strEmpNo;
	}

	/**
	 * Gets the str emp name.
	 * 
	 * @return the str emp name
	 */
	public String[] getStrEmpName() {
		return strEmpName;
	}

	/**
	 * Sets the str emp name.
	 * 
	 * @param strEmpName the new str emp name
	 */
	public void setStrEmpName(String[] strEmpName) {
		this.strEmpName = strEmpName;
	}

	/**
	 * Gets the str emp addr.
	 * 
	 * @return the str emp addr
	 */
	public String[] getStrEmpAddr() {
		return strEmpAddr;
	}

	/**
	 * Sets the str emp addr.
	 * 
	 * @param strEmpAddr the new str emp addr
	 */
	public void setStrEmpAddr(String[] strEmpAddr) {
		this.strEmpAddr = strEmpAddr;
	}

	/**
	 * Gets the str emp phone.
	 * 
	 * @return the str emp phone
	 */
	public String[] getStrEmpPhone() {
		return strEmpPhone;
	}

	/**
	 * Sets the str emp phone.
	 * 
	 * @param strEmpPhone the new str emp phone
	 */
	public void setStrEmpPhone(String[] strEmpPhone) {
		this.strEmpPhone = strEmpPhone;
	}

	/**
	 * Gets the str emp email.
	 * 
	 * @return the str emp email
	 */
	public String[] getStrEmpEmail() {
		return strEmpEmail;
	}

	/**
	 * Sets the str emp email.
	 * 
	 * @param strEmpEmail the new str emp email
	 */
	public void setStrEmpEmail(String[] strEmpEmail) {
		this.strEmpEmail = strEmpEmail;
	}

	/**
	 * Gets the str emp user id.
	 * 
	 * @return the str emp user id
	 */
	public String[] getStrEmpUserId() {
		return strEmpUserId;
	}

	/**
	 * Sets the str emp user id.
	 * 
	 * @param strEmpUserId the new str emp user id
	 */
	public void setStrEmpUserId(String[] strEmpUserId) {
		this.strEmpUserId = strEmpUserId;
	}

	/**
	 * Gets the str emp level.
	 * 
	 * @return the str emp level
	 */
	public String[] getStrEmpLevel() {
		return strEmpLevel;
	}

	/**
	 * Sets the str emp level.
	 * 
	 * @param strEmpLevel the new str emp level
	 */
	public void setStrEmpLevel(String[] strEmpLevel) {
		this.strEmpLevel = strEmpLevel;
	}

	/**
	 * Gets the str ct date.
	 * 
	 * @return the str ct date
	 */
	public String getStrCtDate() {
		HisUtil util = new HisUtil("Drug Safty Alert Master",
				"DrugSaftyAlertMstVO");
		try {
			strCtDate = util.getASDate("dd-MMM-yyyy");
			util = null;
		} catch (Exception e) {
			new HisException("Store Module", "Drug Safty Alert Master",
					"DrugSaftyAlertMstVO.getStrCtDate()-->" + e.getMessage());
		}
		return strCtDate;

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
	 * Gets the str store type.
	 * 
	 * @return the str store type
	 */
	public String getStrStoreType() {
		return strStoreType;
	}

	/**
	 * Sets the str store type.
	 * 
	 * @param strStoreType the new str store type
	 */
	public void setStrStoreType(String strStoreType) {
		this.strStoreType = strStoreType;
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
	 * Gets the str committe type.
	 * 
	 * @return the str committe type
	 */
	public String getStrCommitteType() {
		return strCommitteType;
	}

	/**
	 * Sets the str committe type.
	 * 
	 * @param strCommitteType the new str committe type
	 */
	public void setStrCommitteType(String strCommitteType) {
		this.strCommitteType = strCommitteType;
	}

	/**
	 * Gets the str committe type combo.
	 * 
	 * @return the str committe type combo
	 */
	public String getStrCommitteTypeCombo() {
		return strCommitteTypeCombo;
	}

	/**
	 * Sets the str committe type combo.
	 * 
	 * @param strCommitteTypeCombo the new str committe type combo
	 */
	public void setStrCommitteTypeCombo(String strCommitteTypeCombo) {
		this.strCommitteTypeCombo = strCommitteTypeCombo;
	}

	/**
	 * Gets the str committee purpose.
	 * 
	 * @return the str committee purpose
	 */
	public String getStrCommitteePurpose() {
		return strCommitteePurpose;
	}

	/**
	 * Sets the str committee purpose.
	 * 
	 * @param strCommitteePurpose the new str committee purpose
	 */
	public void setStrCommitteePurpose(String strCommitteePurpose) {
		this.strCommitteePurpose = strCommitteePurpose;
	}

	/**
	 * Gets the str constitute date.
	 * 
	 * @return the str constitute date
	 */
	public String getStrConstituteDate() {
		return strConstituteDate;
	}

	/**
	 * Sets the str constitute date.
	 * 
	 * @param strConstituteDate the new str constitute date
	 */
	public void setStrConstituteDate(String strConstituteDate) {
		this.strConstituteDate = strConstituteDate;
	}

	/**
	 * Gets the str constitute by.
	 * 
	 * @return the str constitute by
	 */
	public String getStrConstituteBy() {
		return strConstituteBy;
	}

	/**
	 * Sets the str constitute by.
	 * 
	 * @param strConstituteBy the new str constitute by
	 */
	public void setStrConstituteBy(String strConstituteBy) {
		this.strConstituteBy = strConstituteBy;
	}

	/**
	 * Gets the str constitute by combo.
	 * 
	 * @return the str constitute by combo
	 */
	public String getStrConstituteByCombo() {
		return strConstituteByCombo;
	}

	/**
	 * Sets the str constitute by combo.
	 * 
	 * @param strConstituteByCombo the new str constitute by combo
	 */
	public void setStrConstituteByCombo(String strConstituteByCombo) {
		this.strConstituteByCombo = strConstituteByCombo;
	}

	/**
	 * Gets the str effective to.
	 * 
	 * @return the str effective to
	 */
	public String getStrEffectiveTo() {
		return strEffectiveTo;
	}

	/**
	 * Sets the str effective to.
	 * 
	 * @param strEffectiveTo the new str effective to
	 */
	public void setStrEffectiveTo(String strEffectiveTo) {
		this.strEffectiveTo = strEffectiveTo;
	}

	/**
	 * Gets the str committe status.
	 * 
	 * @return the str committe status
	 */
	public String getStrCommitteStatus() {
		return strCommitteStatus;
	}

	/**
	 * Sets the str committe status.
	 * 
	 * @param strCommitteStatus the new str committe status
	 */
	public void setStrCommitteStatus(String strCommitteStatus) {
		this.strCommitteStatus = strCommitteStatus;
	}

	/**
	 * Sets the str ct date.
	 * 
	 * @param strCtDate the new str ct date
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}

	/**
	 * Gets the str store type id.
	 * 
	 * @return the str store type id
	 */
	public String getStrStoreTypeID() {
		return strStoreTypeID;
	}

	/**
	 * Sets the str store type id.
	 * 
	 * @param strStoreTypeID the new str store type id
	 */
	public void setStrStoreTypeID(String strStoreTypeID) {
		this.strStoreTypeID = strStoreTypeID;
	}

	/**
	 * Gets the str commetie type id.
	 * 
	 * @return the str commetie type id
	 */
	public String getStrCommetieTypeId() {
		return strCommetieTypeId;
	}

	/**
	 * Sets the str commetie type id.
	 * 
	 * @param strCommetieTypeId the new str commetie type id
	 */
	public void setStrCommetieTypeId(String strCommetieTypeId) {
		this.strCommetieTypeId = strCommetieTypeId;
	}

	/**
	 * Gets the str mode.
	 * 
	 * @return the str mode
	 */
	public String getStrMode() {
		return strMode;
	}

	/**
	 * Sets the str mode.
	 * 
	 * @param strMode the new str mode
	 */
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}

	/**
	 * Gets the str contitute date.
	 * 
	 * @return the str contitute date
	 */
	public String getStrContituteDate() {
		return strContituteDate;
	}

	/**
	 * Sets the str contitute date.
	 * 
	 * @param strContituteDate the new str contitute date
	 */
	public void setStrContituteDate(String strContituteDate) {
		this.strContituteDate = strContituteDate;
	}

	/**
	 * Gets the str constitute by id.
	 * 
	 * @return the str constitute by id
	 */
	public String getStrConstituteById() {
		return strConstituteById;
	}

	/**
	 * Sets the str constitute by id.
	 * 
	 * @param strConstituteById the new str constitute by id
	 */
	public void setStrConstituteById(String strConstituteById) {
		this.strConstituteById = strConstituteById;
	}

	/**
	 * Gets the str arr commitee no.
	 * 
	 * @return the str arr commitee no
	 */
	public String[] getStrArrCommiteeNo() {
		return strArrCommiteeNo;
	}

	/**
	 * Sets the str arr commitee no.
	 * 
	 * @param strArrCommiteeNo the new str arr commitee no
	 */
	public void setStrArrCommiteeNo(String[] strArrCommiteeNo) {
		this.strArrCommiteeNo = strArrCommiteeNo;
	}

	/**
	 * Gets the str update hlp.
	 * 
	 * @return the str update hlp
	 */
	public String getStrUpdateHLP() {
		return strUpdateHLP;
	}

	/**
	 * Sets the str update hlp.
	 * 
	 * @param strUpdateHLP the new str update hlp
	 */
	public void setStrUpdateHLP(String strUpdateHLP) {
		this.strUpdateHLP = strUpdateHLP;
	}

	/**
	 * Gets the str emp no update combo.
	 * 
	 * @return the str emp no update combo
	 */
	public String[] getStrEmpNoUpdateCombo() {
		return strEmpNoUpdateCombo;
	}

	/**
	 * Sets the str emp no update combo.
	 * 
	 * @param strEmpNoUpdateCombo the new str emp no update combo
	 */
	public void setStrEmpNoUpdateCombo(String[] strEmpNoUpdateCombo) {
		this.strEmpNoUpdateCombo = strEmpNoUpdateCombo;
	}

	/**
	 * Gets the update or add.
	 * 
	 * @return the update or add
	 */
	public String getUpdateOrAdd() {
		return UpdateOrAdd;
	}

	/**
	 * Sets the update or add.
	 * 
	 * @param updateOrAdd the new update or add
	 */
	public void setUpdateOrAdd(String updateOrAdd) {
		UpdateOrAdd = updateOrAdd;
	}

	/**
	 * Gets the str is employee update mr.
	 * 
	 * @return the str is employee update mr
	 */
	public String[] getStrIsEmployeeUpdateMR() {
		return strIsEmployeeUpdateMR;
	}

	/**
	 * Sets the str is employee update mr.
	 * 
	 * @param strIsEmployeeUpdateMR the new str is employee update mr
	 */
	public void setStrIsEmployeeUpdateMR(String[] strIsEmployeeUpdateMR) {
		this.strIsEmployeeUpdateMR = strIsEmployeeUpdateMR;
	}

	/**
	 * Gets the str option update mr.
	 * 
	 * @return the str option update mr
	 */
	public String[] getStrOptionUpdateMR() {
		return strOptionUpdateMR;
	}

	/**
	 * Sets the str option update mr.
	 * 
	 * @param strOptionUpdateMR the new str option update mr
	 */
	public void setStrOptionUpdateMR(String[] strOptionUpdateMR) {
		this.strOptionUpdateMR = strOptionUpdateMR;
	}

	/**
	 * Gets the str emp no update mr.
	 * 
	 * @return the str emp no update mr
	 */
	public String[] getStrEmpNoUpdateMR() {
		return strEmpNoUpdateMR;
	}

	/**
	 * Sets the str emp no update mr.
	 * 
	 * @param strEmpNoUpdateMR the new str emp no update mr
	 */
	public void setStrEmpNoUpdateMR(String[] strEmpNoUpdateMR) {
		this.strEmpNoUpdateMR = strEmpNoUpdateMR;
	}

	/**
	 * Gets the str emp name update mr.
	 * 
	 * @return the str emp name update mr
	 */
	public String[] getStrEmpNameUpdateMR() {
		return strEmpNameUpdateMR;
	}

	/**
	 * Sets the str emp name update mr.
	 * 
	 * @param strEmpNameUpdateMR the new str emp name update mr
	 */
	public void setStrEmpNameUpdateMR(String[] strEmpNameUpdateMR) {
		this.strEmpNameUpdateMR = strEmpNameUpdateMR;
	}

	/**
	 * Gets the str emp addr update mr.
	 * 
	 * @return the str emp addr update mr
	 */
	public String[] getStrEmpAddrUpdateMR() {
		return strEmpAddrUpdateMR;
	}

	/**
	 * Sets the str emp addr update mr.
	 * 
	 * @param strEmpAddrUpdateMR the new str emp addr update mr
	 */
	public void setStrEmpAddrUpdateMR(String[] strEmpAddrUpdateMR) {
		this.strEmpAddrUpdateMR = strEmpAddrUpdateMR;
	}

	/**
	 * Gets the str emp phone update mr.
	 * 
	 * @return the str emp phone update mr
	 */
	public String[] getStrEmpPhoneUpdateMR() {
		return strEmpPhoneUpdateMR;
	}

	/**
	 * Sets the str emp phone update mr.
	 * 
	 * @param strEmpPhoneUpdateMR the new str emp phone update mr
	 */
	public void setStrEmpPhoneUpdateMR(String[] strEmpPhoneUpdateMR) {
		this.strEmpPhoneUpdateMR = strEmpPhoneUpdateMR;
	}

	/**
	 * Gets the str emp email update mr.
	 * 
	 * @return the str emp email update mr
	 */
	public String[] getStrEmpEmailUpdateMR() {
		return strEmpEmailUpdateMR;
	}

	/**
	 * Sets the str emp email update mr.
	 * 
	 * @param strEmpEmailUpdateMR the new str emp email update mr
	 */
	public void setStrEmpEmailUpdateMR(String[] strEmpEmailUpdateMR) {
		this.strEmpEmailUpdateMR = strEmpEmailUpdateMR;
	}

	/**
	 * Gets the str emp user id update mr.
	 * 
	 * @return the str emp user id update mr
	 */
	public String[] getStrEmpUserIdUpdateMR() {
		return strEmpUserIdUpdateMR;
	}

	/**
	 * Sets the str emp user id update mr.
	 * 
	 * @param strEmpUserIdUpdateMR the new str emp user id update mr
	 */
	public void setStrEmpUserIdUpdateMR(String[] strEmpUserIdUpdateMR) {
		this.strEmpUserIdUpdateMR = strEmpUserIdUpdateMR;
	}

	/**
	 * Gets the str emp level update mr.
	 * 
	 * @return the str emp level update mr
	 */
	public String[] getStrEmpLevelUpdateMR() {
		return strEmpLevelUpdateMR;
	}

	/**
	 * Sets the str emp level update mr.
	 * 
	 * @param strEmpLevelUpdateMR the new str emp level update mr
	 */
	public void setStrEmpLevelUpdateMR(String[] strEmpLevelUpdateMR) {
		this.strEmpLevelUpdateMR = strEmpLevelUpdateMR;
	}

	/**
	 * Gets the str commit no.
	 * 
	 * @return the str commit no
	 */
	public String getStrCommitNo() {
		return strCommitNo;
	}

	/**
	 * Sets the str commit no.
	 * 
	 * @param strCommitNo the new str commit no
	 */
	public void setStrCommitNo(String strCommitNo) {
		this.strCommitNo = strCommitNo;
	}

	/**
	 * Gets the str committe no.
	 * 
	 * @return the str committe no
	 */
	public String[] getStrCommitteNo() {
		return strCommitteNo;
	}

	/**
	 * Sets the str committe no.
	 * 
	 * @param strCommitteNo the new str committe no
	 */
	public void setStrCommitteNo(String[] strCommitteNo) {
		this.strCommitteNo = strCommitteNo;
	}

	/**
	 * Gets the str commeitte sl no.
	 * 
	 * @return the str commeitte sl no
	 */
	public String[] getStrCommeitteSlNo() {
		return strCommeitteSlNo;
	}

	/**
	 * Sets the str commeitte sl no.
	 * 
	 * @param strCommeitteSlNo the new str commeitte sl no
	 */
	public void setStrCommeitteSlNo(String[] strCommeitteSlNo) {
		this.strCommeitteSlNo = strCommeitteSlNo;
	}

	/**
	 * Gets the dummy commite type.
	 * 
	 * @return the dummy commite type
	 */
	public String getDummyCommiteType() {
		return DummyCommiteType;
	}

	/**
	 * Sets the dummy commite type.
	 * 
	 * @param dummyCommiteType the new dummy commite type
	 */
	public void setDummyCommiteType(String dummyCommiteType) {
		DummyCommiteType = dummyCommiteType;
	}

	/**
	 * Gets the str user id combo.
	 * 
	 * @return the str user id combo
	 */
	public String getStrUserIdCombo() {
		return strUserIdCombo;
	}

	/**
	 * Sets the str user id combo.
	 * 
	 * @param strUserIdCombo the new str user id combo
	 */
	public void setStrUserIdCombo(String strUserIdCombo) {
		this.strUserIdCombo = strUserIdCombo;
	}

	/**
	 * Gets the str emp no combo.
	 * 
	 * @return the str emp no combo
	 */
	public String[] getStrEmpNoCombo() {
		return strEmpNoCombo;
	}

	/**
	 * Sets the str emp no combo.
	 * 
	 * @param strEmpNoCombo the new str emp no combo
	 */
	public void setStrEmpNoCombo(String[] strEmpNoCombo) {
		this.strEmpNoCombo = strEmpNoCombo;
	}

	/**
	 * Gets the str emp inf data ws.
	 * 
	 * @return the str emp inf data ws
	 */
	public WebRowSet getStrEmpInfDataWs() {
		return strEmpInfDataWs;
	}

	/**
	 * Sets the str emp inf data ws.
	 * 
	 * @param strEmpInfDataWs the new str emp inf data ws
	 */
	public void setStrEmpInfDataWs(WebRowSet strEmpInfDataWs) {
		this.strEmpInfDataWs = strEmpInfDataWs;
	}

	/**
	 * Gets the str emp no update mr combo.
	 * 
	 * @return the str emp no update mr combo
	 */
	public String[] getStrEmpNoUpdateMRCombo() {
		return strEmpNoUpdateMRCombo;
	}

	/**
	 * Sets the str emp no update mr combo.
	 * 
	 * @param strEmpNoUpdateMRCombo the new str emp no update mr combo
	 */
	public void setStrEmpNoUpdateMRCombo(String[] strEmpNoUpdateMRCombo) {
		this.strEmpNoUpdateMRCombo = strEmpNoUpdateMRCombo;
	}

	/**
	 * Gets the str constitute by id data.
	 * 
	 * @return the str constitute by id data
	 */
	public String[] getStrConstituteByIdData() {
		return strConstituteByIdData;
	}

	/**
	 * Sets the str constitute by id data.
	 * 
	 * @param strConstituteByIdData the new str constitute by id data
	 */
	public void setStrConstituteByIdData(String[] strConstituteByIdData) {
		this.strConstituteByIdData = strConstituteByIdData;
	}

	/**
	 * Gets the str update emp inf ws.
	 * 
	 * @return the str update emp inf ws
	 */
	public WebRowSet[] getStrUpdateEmpInfWs() {
		return strUpdateEmpInfWs;
	}

	/**
	 * Sets the str update emp inf ws.
	 * 
	 * @param strUpdateEmpInfWs the new str update emp inf ws
	 */
	public void setStrUpdateEmpInfWs(WebRowSet[] strUpdateEmpInfWs) {
		this.strUpdateEmpInfWs = strUpdateEmpInfWs;
	}

	/**
	 * Gets the str emp no data.
	 * 
	 * @return the str emp no data
	 */
	public String[] getStrEmpNoData() {
		return strEmpNoData;
	}

	/**
	 * Sets the str emp no data.
	 * 
	 * @param strEmpNoData the new str emp no data
	 */
	public void setStrEmpNoData(String[] strEmpNoData) {
		this.strEmpNoData = strEmpNoData;
	}

	/**
	 * Gets the str update emp name ws.
	 * 
	 * @return the str update emp name ws
	 */
	public WebRowSet[] getStrUpdateEmpNameWs() {
		return strUpdateEmpNameWs;
	}

	/**
	 * Sets the str update emp name ws.
	 * 
	 * @param strUpdateEmpNameWs the new str update emp name ws
	 */
	public void setStrUpdateEmpNameWs(WebRowSet[] strUpdateEmpNameWs) {
		this.strUpdateEmpNameWs = strUpdateEmpNameWs;
	}

	/**
	 * Gets the str update emp inf hlp ws.
	 * 
	 * @return the str update emp inf hlp ws
	 */
	public WebRowSet getStrUpdateEmpInfHLPWs() {
		return strUpdateEmpInfHLPWs;
	}

	/**
	 * Sets the str update emp inf hlp ws.
	 * 
	 * @param strUpdateEmpInfHLPWs the new str update emp inf hlp ws
	 */
	public void setStrUpdateEmpInfHLPWs(WebRowSet strUpdateEmpInfHLPWs) {
		this.strUpdateEmpInfHLPWs = strUpdateEmpInfHLPWs;
	}

	/**
	 * Gets the str update emp name hlp ws.
	 * 
	 * @return the str update emp name hlp ws
	 */
	public WebRowSet getStrUpdateEmpNameHLPWs() {
		return strUpdateEmpNameHLPWs;
	}

	/**
	 * Sets the str update emp name hlp ws.
	 * 
	 * @param strUpdateEmpNameHLPWs the new str update emp name hlp ws
	 */
	public void setStrUpdateEmpNameHLPWs(WebRowSet strUpdateEmpNameHLPWs) {
		this.strUpdateEmpNameHLPWs = strUpdateEmpNameHLPWs;
	}

	/**
	 * Gets the str emp name hlp.
	 * 
	 * @return the str emp name hlp
	 */
	public String getStrEmpNameHLP() {
		return strEmpNameHLP;
	}

	/**
	 * Sets the str emp name hlp.
	 * 
	 * @param strEmpNameHLP the new str emp name hlp
	 */
	public void setStrEmpNameHLP(String strEmpNameHLP) {
		this.strEmpNameHLP = strEmpNameHLP;
	}

	/**
	 * Gets the str emp addr hlp.
	 * 
	 * @return the str emp addr hlp
	 */
	public String getStrEmpAddrHLP() {
		return strEmpAddrHLP;
	}

	/**
	 * Sets the str emp addr hlp.
	 * 
	 * @param strEmpAddrHLP the new str emp addr hlp
	 */
	public void setStrEmpAddrHLP(String strEmpAddrHLP) {
		this.strEmpAddrHLP = strEmpAddrHLP;
	}

	/**
	 * Gets the str emp phone hlp.
	 * 
	 * @return the str emp phone hlp
	 */
	public String getStrEmpPhoneHLP() {
		return strEmpPhoneHLP;
	}

	/**
	 * Sets the str emp phone hlp.
	 * 
	 * @param strEmpPhoneHLP the new str emp phone hlp
	 */
	public void setStrEmpPhoneHLP(String strEmpPhoneHLP) {
		this.strEmpPhoneHLP = strEmpPhoneHLP;
	}

	/**
	 * Gets the str emp email hlp.
	 * 
	 * @return the str emp email hlp
	 */
	public String getStrEmpEmailHLP() {
		return strEmpEmailHLP;
	}

	/**
	 * Sets the str emp email hlp.
	 * 
	 * @param strEmpEmailHLP the new str emp email hlp
	 */
	public void setStrEmpEmailHLP(String strEmpEmailHLP) {
		this.strEmpEmailHLP = strEmpEmailHLP;
	}

	/**
	 * Gets the str emp no update mr combo dummy.
	 * 
	 * @return the str emp no update mr combo dummy
	 */
	public String[] getStrEmpNoUpdateMRComboDummy() {
		return strEmpNoUpdateMRComboDummy;
	}

	/**
	 * Sets the str emp no update mr combo dummy.
	 * 
	 * @param strEmpNoUpdateMRComboDummy the new str emp no update mr combo dummy
	 */
	public void setStrEmpNoUpdateMRComboDummy(
			String[] strEmpNoUpdateMRComboDummy) {
		this.strEmpNoUpdateMRComboDummy = strEmpNoUpdateMRComboDummy;
	}

	/**
	 * Gets the str is employee update mr dummy.
	 * 
	 * @return the str is employee update mr dummy
	 */
	public String[] getStrIsEmployeeUpdateMRDummy() {
		return strIsEmployeeUpdateMRDummy;
	}

	/**
	 * Sets the str is employee update mr dummy.
	 * 
	 * @param strIsEmployeeUpdateMRDummy the new str is employee update mr dummy
	 */
	public void setStrIsEmployeeUpdateMRDummy(
			String[] strIsEmployeeUpdateMRDummy) {
		this.strIsEmployeeUpdateMRDummy = strIsEmployeeUpdateMRDummy;
	}

	/**
	 * Gets the str emp commt no sl no data ws.
	 * 
	 * @return the str emp commt no sl no data ws
	 */
	public WebRowSet getStrEmpCommtNoSlNoDataWs() {
		return strEmpCommtNoSlNoDataWs;
	}

	/**
	 * Sets the str emp commt no sl no data ws.
	 * 
	 * @param strEmpCommtNoSlNoDataWs the new str emp commt no sl no data ws
	 */
	public void setStrEmpCommtNoSlNoDataWs(WebRowSet strEmpCommtNoSlNoDataWs) {
		this.strEmpCommtNoSlNoDataWs = strEmpCommtNoSlNoDataWs;
	}

	/**
	 * Gets the str commeitte sl no1.
	 * 
	 * @return the str commeitte sl no1
	 */
	public String getStrCommeitteSlNo1() {
		return strCommeitteSlNo1;
	}

	/**
	 * Sets the str commeitte sl no1.
	 * 
	 * @param strCommeitteSlNo1 the new str commeitte sl no1
	 */
	public void setStrCommeitteSlNo1(String strCommeitteSlNo1) {
		this.strCommeitteSlNo1 = strCommeitteSlNo1;
	}

	/**
	 * Gets the str memebr dtl.
	 * 
	 * @return the str memebr dtl
	 */
	public String getStrMemebrDtl() {
		return strMemebrDtl;
	}

	/**
	 * Sets the str memebr dtl.
	 * 
	 * @param strMemebrDtl the new str memebr dtl
	 */
	public void setStrMemebrDtl(String strMemebrDtl) {
		this.strMemebrDtl = strMemebrDtl;
	}

	/**
	 * Gets the str member dtl ws.
	 * 
	 * @return the str member dtl ws
	 */
	public WebRowSet getStrMemberDtlWs() {
		return strMemberDtlWs;
	}

	/**
	 * Sets the str member dtl ws.
	 * 
	 * @param strMemberDtlWs the new str member dtl ws
	 */
	public void setStrMemberDtlWs(WebRowSet strMemberDtlWs) {
		this.strMemberDtlWs = strMemberDtlWs;
	}

	/**
	 * Gets the str committe dtl.
	 * 
	 * @return the str committe dtl
	 */
	public String getStrCommitteDtl() {
		return strCommitteDtl;
	}

	/**
	 * Sets the str committe dtl.
	 * 
	 * @param strCommitteDtl the new str committe dtl
	 */
	public void setStrCommitteDtl(String strCommitteDtl) {
		this.strCommitteDtl = strCommitteDtl;
	}

	/**
	 * Gets the str emp number.
	 * 
	 * @return the str emp number
	 */
	public String getStrEmpNumber() {
		return strEmpNumber;
	}

	/**
	 * Sets the str emp number.
	 * 
	 * @param strEmpNumber the new str emp number
	 */
	public void setStrEmpNumber(String strEmpNumber) {
		this.strEmpNumber = strEmpNumber;
	}

	/**
	 * Gets the str member name.
	 * 
	 * @return the str member name
	 */
	public String getStrMemberName() {
		return strMemberName;
	}

	/**
	 * Sets the str member name.
	 * 
	 * @param strMemberName the new str member name
	 */
	public void setStrMemberName(String strMemberName) {
		this.strMemberName = strMemberName;
	}

	/**
	 * Gets the str case.
	 * 
	 * @return the str case
	 */
	public String getStrCase() {
		return strCase;
	}

	/**
	 * Sets the str case.
	 * 
	 * @param strCase the new str case
	 */
	public void setStrCase(String strCase) {
		this.strCase = strCase;
	}

	/**
	 * Gets the str emp number combo.
	 * 
	 * @return the str emp number combo
	 */
	public String getStrEmpNumberCombo() {
		return strEmpNumberCombo;
	}

	/**
	 * Sets the str emp number combo.
	 * 
	 * @param strEmpNumberCombo the new str emp number combo
	 */
	public void setStrEmpNumberCombo(String strEmpNumberCombo) {
		this.strEmpNumberCombo = strEmpNumberCombo;
	}

	/**
	 * Gets the str member e mail.
	 * 
	 * @return the str member e mail
	 */
	public String getStrMemberEMail() {
		return strMemberEMail;
	}

	/**
	 * Sets the str member e mail.
	 * 
	 * @param strMemberEMail the new str member e mail
	 */
	public void setStrMemberEMail(String strMemberEMail) {
		this.strMemberEMail = strMemberEMail;
	}

	/**
	 * Gets the str member phone no.
	 * 
	 * @return the str member phone no
	 */
	public String getStrMemberPhoneNo() {
		return strMemberPhoneNo;
	}

	/**
	 * Sets the str member phone no.
	 * 
	 * @param strMemberPhoneNo the new str member phone no
	 */
	public void setStrMemberPhoneNo(String strMemberPhoneNo) {
		this.strMemberPhoneNo = strMemberPhoneNo;
	}

	/**
	 * Gets the str prev val.
	 * 
	 * @return the str prev val
	 */
	public String getStrPrevVal() {
		return strPrevVal;
	}

	/**
	 * Sets the str prev val.
	 * 
	 * @param strPrevVal the new str prev val
	 */
	public void setStrPrevVal(String strPrevVal) {
		this.strPrevVal = strPrevVal;
	}

	/**
	 * Gets the str tmp.
	 * 
	 * @return the str tmp
	 */
	public String getStrTmp() {
		return strTmp;
	}

	/**
	 * Sets the str tmp.
	 * 
	 * @param strTmp the new str tmp
	 */
	public void setStrTmp(String strTmp) {
		this.strTmp = strTmp;
	}

	/**
	 * Gets the str rec.
	 * 
	 * @return the str rec
	 */
	public String[] getStrRec() {
		return strRec;
	}

	/**
	 * Sets the str rec.
	 * 
	 * @param strRec the new str rec
	 */
	public void setStrRec(String[] strRec) {
		this.strRec = strRec;
	}

	/**
	 * Gets the str chk box.
	 * 
	 * @return the str chk box
	 */
	public String[] getStrChkBox() {
		return strChkBox;
	}

	/**
	 * Sets the str chk box.
	 * 
	 * @param strChkBox the new str chk box
	 */
	public void setStrChkBox(String[] strChkBox) {
		this.strChkBox = strChkBox;
	}

	/**
	 * Gets the str comm type id.
	 * 
	 * @return the str comm type id
	 */
	public String getStrCommTypeId() {
		return strCommTypeId;
	}

	/**
	 * Sets the str comm type id.
	 * 
	 * @param strCommTypeId the new str comm type id
	 */
	public void setStrCommTypeId(String strCommTypeId) {
		this.strCommTypeId = strCommTypeId;
	}

	/**
	 * Gets the str cat no.
	 * 
	 * @return the strCatNo
	 */
	public String getStrCatNo() {
		return strCatNo;
	}

	/**
	 * Sets the str cat no.
	 * 
	 * @param strCatNo the strCatNo to set
	 */
	public void setStrCatNo(String strCatNo) {
		this.strCatNo = strCatNo;
	}

	/**
	 * Gets the str cat values.
	 * 
	 * @return the strCatValues
	 */
	public String getStrCatValues() {
		return strCatValues;
	}

	/**
	 * Sets the str cat values.
	 * 
	 * @param strCatValues the strCatValues to set
	 */
	public void setStrCatValues(String strCatValues) {
		this.strCatValues = strCatValues;
	}

	/**
	 * Gets the item category ws.
	 * 
	 * @return the itemCategoryWS
	 */
	public WebRowSet getItemCategoryWS() {
		return itemCategoryWS;
	}

	/**
	 * Sets the item category ws.
	 * 
	 * @param itemCategoryWS the itemCategoryWS to set
	 */
	public void setItemCategoryWS(WebRowSet itemCategoryWS) {
		this.itemCategoryWS = itemCategoryWS;
	}

	/**
	 * Gets the req type ws.
	 * 
	 * @return the reqTypeWS
	 */
	public WebRowSet getReqTypeWS() {
		return reqTypeWS;
	}

	/**
	 * Sets the req type ws.
	 * 
	 * @param reqTypeWS the reqTypeWS to set
	 */
	public void setReqTypeWS(WebRowSet reqTypeWS) {
		this.reqTypeWS = reqTypeWS;
	}

	/**
	 * Gets the str req type id.
	 * 
	 * @return the strReqTypeId
	 */
	public String getStrReqTypeId() {
		return strReqTypeId;
	}

	/**
	 * Sets the str req type id.
	 * 
	 * @param strReqTypeId the strReqTypeId to set
	 */
	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}

	/**
	 * Gets the str req type values.
	 * 
	 * @return the strReqTypeValues
	 */
	public String getStrReqTypeValues() {
		return strReqTypeValues;
	}

	/**
	 * Sets the str req type values.
	 * 
	 * @param strReqTypeValues the strReqTypeValues to set
	 */
	public void setStrReqTypeValues(String strReqTypeValues) {
		this.strReqTypeValues = strReqTypeValues;
	}

	/**
	 * Gets the comm type ws.
	 * 
	 * @return the commTypeWS
	 */
	public WebRowSet getCommTypeWS() {
		return commTypeWS;
	}

	/**
	 * Sets the comm type ws.
	 * 
	 * @param commTypeWS the commTypeWS to set
	 */
	public void setCommTypeWS(WebRowSet commTypeWS) {
		this.commTypeWS = commTypeWS;
	}

	/**
	 * @return the strCatCodesFromSession
	 */
	public String getStrCatCodesFromSession() {
		return strCatCodesFromSession;
	}

	/**
	 * @param strCatCodesFromSession the strCatCodesFromSession to set
	 */
	public void setStrCatCodesFromSession(String strCatCodesFromSession) {
		this.strCatCodesFromSession = strCatCodesFromSession;
	}

	public WebRowSet getStrUserIdWs() {
		return strUserIdWs;
	}

	public void setStrUserIdWs(WebRowSet strUserIdWs) {
		this.strUserIdWs = strUserIdWs;
	}

}
