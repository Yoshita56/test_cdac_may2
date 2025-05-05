package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * Developer : Pramod Kumar Mehta Version : 1.0 Date : 17/April/2009 Module:MMS
 * Unit:Approving Authority Master
 */

public class ApprovingAuthorityDAO {

	/** The str file name. */
	private final String strFileName = "mms.dao.ApprovingAuthorityDAO";

	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str is valid. */
	private String strIsValid = "1";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str chk1. */
	private String strChk1 = "";

	/** The str err. */
	private String strErr = "";
	
	/** The str normal msg. */
	private String strNormalMsg = "";
	
	/** The str warning msg. */
	private String strWarningMsg = "";

	/** The str msg string. */
	private String strMsgString = "";
	
	/** The str msg type. */
	private String strMsgType = "";

	/** The str ct date. */
	private String strCtDate = null;
	
	/** The str app id. */
	private String strAppId = "";
	
	/** The str user id. */
	private String strUserId = "";
	
	/** The str user name. */
	private String[] strUserName = null;
	
	/** The str user name ws. */
	private WebRowSet strUserNameWS = null;
	
	/** The str approving type. */
	private String strApprovingType = "";
	
	/** The str approving type id. */
	private String strApprovingTypeId = "";

	/** The str effective date. */
	private String strEffectiveDate = "";
	
	/** The str remarks. */
	private String strRemarks = "";

	/** The str store id. */
	private String strStoreId = "";

	/** The str store name cmb. */
	private String strStoreNameCmb = "";
	
	/** The str app type. */
	private String strAppType = "";
	
	/** The str l user name. */
	private String strLUserName = "";

	/** The n row inserted. */
	private int nRowInserted = 0;
	
	/** The n row updated. */
	private int nRowUpdated = 0;
	
	/** The n row deleted. */
	private int nRowDeleted = 0;

	/** The n inserted index. */
	private int nInsertedIndex = 0;
	
	/** The n updated index. */
	private int nUpdatedIndex = 0;
	
	/** The n deleted index. */
	private int nDeletedIndex = 0;
	
	
	private String strCommitteeFlag = null;

	/**
	 * Gets the n row inserted.
	 * 
	 * @return the n row inserted
	 */
	public int getNRowInserted() {
		return nRowInserted;
	}

	/**
	 * Sets the n row inserted.
	 * 
	 * @param rowInserted the new n row inserted
	 */
	public void setNRowInserted(int rowInserted) {
		nRowInserted = rowInserted;
	}

	/**
	 * Gets the n row updated.
	 * 
	 * @return the n row updated
	 */
	public int getNRowUpdated() {
		return nRowUpdated;
	}

	/**
	 * Sets the n row updated.
	 * 
	 * @param rowUpdated the new n row updated
	 */
	public void setNRowUpdated(int rowUpdated) {
		nRowUpdated = rowUpdated;
	}

	/**
	 * Gets the n row deleted.
	 * 
	 * @return the n row deleted
	 */
	public int getNRowDeleted() {
		return nRowDeleted;
	}

	/**
	 * Sets the n row deleted.
	 * 
	 * @param rowDeleted the new n row deleted
	 */
	public void setNRowDeleted(int rowDeleted) {
		nRowDeleted = rowDeleted;
	}

	/**
	 * Gets the n inserted index.
	 * 
	 * @return the n inserted index
	 */
	public int getNInsertedIndex() {
		return nInsertedIndex;
	}

	/**
	 * Sets the n inserted index.
	 * 
	 * @param insertedIndex the new n inserted index
	 */
	public void setNInsertedIndex(int insertedIndex) {
		nInsertedIndex = insertedIndex;
	}

	/**
	 * Gets the n updated index.
	 * 
	 * @return the n updated index
	 */
	public int getNUpdatedIndex() {
		return nUpdatedIndex;
	}

	/**
	 * Sets the n updated index.
	 * 
	 * @param updatedIndex the new n updated index
	 */
	public void setNUpdatedIndex(int updatedIndex) {
		nUpdatedIndex = updatedIndex;
	}

	/**
	 * Gets the n deleted index.
	 * 
	 * @return the n deleted index
	 */
	public int getNDeletedIndex() {
		return nDeletedIndex;
	}

	/**
	 * Sets the n deleted index.
	 * 
	 * @param deletedIndex the new n deleted index
	 */
	public void setNDeletedIndex(int deletedIndex) {
		nDeletedIndex = deletedIndex;
	}

	/**
	 * Gets the str file name.
	 * 
	 * @return the str file name
	 */
	public String getStrFileName() {
		return strFileName;
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
	 * Gets the str err.
	 * 
	 * @return the str err
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * Sets the str err.
	 * 
	 * @param strErr the new str err
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

	/**
	 * Gets the str normal msg.
	 * 
	 * @return the str normal msg
	 */
	public String getStrNormalMsg() {
		return strNormalMsg;
	}

	/**
	 * Sets the str normal msg.
	 * 
	 * @param strNormalMsg the new str normal msg
	 */
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}

	/**
	 * Gets the str warning msg.
	 * 
	 * @return the str warning msg
	 */
	public String getStrWarningMsg() {
		return strWarningMsg;
	}

	/**
	 * Sets the str warning msg.
	 * 
	 * @param strWarningMsg the new str warning msg
	 */
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
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
	 * @param strCtDate the new str ct date
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}

	/**
	 * Gets the str app id.
	 * 
	 * @return the str app id
	 */
	public String getStrAppId() {
		return strAppId;
	}

	/**
	 * Sets the str app id.
	 * 
	 * @param strAppId the new str app id
	 */
	public void setStrAppId(String strAppId) {
		this.strAppId = strAppId;
	}

	/**
	 * Gets the str user id.
	 * 
	 * @return the str user id
	 */
	public String getStrUserId() {
		return strUserId;
	}

	/**
	 * Sets the str user id.
	 * 
	 * @param strUserId the new str user id
	 */
	public void setStrUserId(String strUserId) {
		this.strUserId = strUserId;
	}

	/**
	 * Gets the str user name.
	 * 
	 * @return the str user name
	 */
	public String[] getStrUserName() {
		return strUserName;
	}

	/**
	 * Sets the str user name.
	 * 
	 * @param strUserName the new str user name
	 */
	public void setStrUserName(String[] strUserName) {
		this.strUserName = strUserName;
	}

	/**
	 * Gets the str user name ws.
	 * 
	 * @return the str user name ws
	 */
	public WebRowSet getStrUserNameWS() {
		return strUserNameWS;
	}

	/**
	 * Sets the str user name ws.
	 * 
	 * @param strUserNameWS the new str user name ws
	 */
	public void setStrUserNameWS(WebRowSet strUserNameWS) {
		this.strUserNameWS = strUserNameWS;
	}

	/**
	 * Gets the str approving type.
	 * 
	 * @return the str approving type
	 */
	public String getStrApprovingType() {
		return strApprovingType;
	}

	/**
	 * Sets the str approving type.
	 * 
	 * @param strApprovingType the new str approving type
	 */
	public void setStrApprovingType(String strApprovingType) {
		this.strApprovingType = strApprovingType;
	}

	/**
	 * Gets the str approving type id.
	 * 
	 * @return the str approving type id
	 */
	public String getStrApprovingTypeId() {
		return strApprovingTypeId;
	}

	/**
	 * Sets the str approving type id.
	 * 
	 * @param strApprovingTypeId the new str approving type id
	 */
	public void setStrApprovingTypeId(String strApprovingTypeId) {
		this.strApprovingTypeId = strApprovingTypeId;
	}

	/**
	 * Gets the str effective date.
	 * 
	 * @return the str effective date
	 */
	public String getStrEffectiveDate() {
		return strEffectiveDate;
	}

	/**
	 * Sets the str effective date.
	 * 
	 * @param strEffectiveDate the new str effective date
	 */
	public void setStrEffectiveDate(String strEffectiveDate) {
		this.strEffectiveDate = strEffectiveDate;
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
	 * Gets the str store id.
	 * 
	 * @return the str store id
	 */
	public String getStrStoreId() {
		return strStoreId;
	}

	/**
	 * Sets the str store id.
	 * 
	 * @param strStoreId the new str store id
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	/**
	 * Gets the str store name cmb.
	 * 
	 * @return the str store name cmb
	 */
	public String getStrStoreNameCmb() {
		return strStoreNameCmb;
	}

	/**
	 * Sets the str store name cmb.
	 * 
	 * @param strStoreNameCmb the new str store name cmb
	 */
	public void setStrStoreNameCmb(String strStoreNameCmb) {
		this.strStoreNameCmb = strStoreNameCmb;
	}

	/**
	 * Gets the str app type.
	 * 
	 * @return the str app type
	 */
	public String getStrAppType() {
		return strAppType;
	}

	/**
	 * Sets the str app type.
	 * 
	 * @param strAppType the new str app type
	 */
	public void setStrAppType(String strAppType) {
		this.strAppType = strAppType;
	}

	/**
	 * Gets the str l user name.
	 * 
	 * @return the str l user name
	 */
	public String getStrLUserName() {
		return strLUserName;
	}

	/**
	 * Sets the str l user name.
	 * 
	 * @param strLUserName the new str l user name
	 */
	public void setStrLUserName(String strLUserName) {
		this.strLUserName = strLUserName;
	}

	/**
	 * This method is used to insert the record in the database in case of
	 * approval type is Store.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";

		try {

			// check mandatory information
			if (strApprovingTypeId.equals("0") || strApprovingTypeId.equals("")) {
				throw new Exception("strApprovingTypeId can not be blank");
			}
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}

			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1, "insert.app_auth.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strHospitalCode);
			dao.setQryValue(nQueryIndex, 2, strHospitalCode);
			dao.setQryValue(nQueryIndex, 3, strUserId);

			dao.setQryValue(nQueryIndex, 4, strApprovingTypeId);
			dao.setQryValue(nQueryIndex, 5, strStoreId);
			dao.setQryValue(nQueryIndex, 6, strRemarks);

			dao.setQryValue(nQueryIndex, 7, strEffectiveDate);
			dao.setQryValue(nQueryIndex, 8, strSeatId);
			dao.setQryValue(nQueryIndex, 9, strIsValid);
			dao.setQryValue(nQueryIndex, 10, strCommitteeFlag);

			dao.execute(nQueryIndex, 0);
			this.nRowInserted++;
		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

	}

	/**
	 * This method is used to update the record in database.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */
	public void update(HisDAO dao) throws Exception {
		strErr = "";

		try {

			// check mandatory information
			if (strAppId.equals("0") || strAppId.equals("")) {
				throw new Exception("strApprovingTypeId can not be blank");
			}
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}

			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1, "update.app_auth.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strEffectiveDate);
			dao.setQryValue(nQueryIndex, 2, strRemarks);
			dao.setQryValue(nQueryIndex, 3, strIsValid);
			dao.setQryValue(nQueryIndex, 4, strSeatId);
			dao.setQryValue(nQueryIndex, 5, strAppId);
			dao.setQryValue(nQueryIndex, 6, strHospitalCode);

			dao.execute(nQueryIndex, 0);
			this.nRowUpdated++;
		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

	}

	/**
	 * Reset.
	 */
	public void reset() {

		strHospitalCode = "";
		strStoreId = "";
		strRemarks = "";
		strEffectiveDate = "";
		strApprovingTypeId = "";
		strSeatId = "";
		strIsValid = "";

	}

	/**
	 * @param strCommitteeFlag the strCommitteeFlag to set
	 */
	public void setStrCommitteeFlag(String strCommitteeFlag) {
		this.strCommitteeFlag = strCommitteeFlag;
	}

	/**
	 * @return the strCommitteeFlag
	 */
	public String getStrCommitteeFlag() {
		return strCommitteeFlag;
	}

}
