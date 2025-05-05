package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthorizationDAO.
 */
public class AuthorizationDAO {

	// private final String strProcName = "";
	/** The str file name. */
	private final String strFileName = "mms.dao.AuthorizationDAO";

	/** The str store id. */
	private String strStoreId = "0";
	
	/** The str user id. */
	private String strUserId = "0";
	// private String strUserName="";
	// private String strAuthorizationType = "";
	/** The str authorization type id. */
	private String strAuthorizationTypeId = "";
	
	/** The str authorization level. */
	private String strAuthorizationLevel = "";
	
	/** The str authorization no. */
	private String strAuthorizationNo = "";
	
	/** The str cost form. */
	private String strCostForm = "";
	
	/** The str cost. */
	private String strCost = "";
	// private String strStoreTypeCombo = "";

	/** The str effective from. */
	private String strEffectiveFrom = "";
	// private String strRemarks = "";
	// private String strEntryDate = "";
	// private String strLastModifiedDate = "";
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str last modified seat id. */
	private String strLastModifiedSeatId = "";
	
	/** The str is valid. */
	private String strIsValid = "1";
	
	/** The str hospital code. */
	private String strHospitalCode = "";

	/** The str err. */
	private String strErr = "";

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

	/**
	 * Sets the str store id.
	 * 
	 * @param strStoreId the new str store id
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
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
	 * Sets the str authorization level.
	 * 
	 * @param strAuthorizationLevel the new str authorization level
	 */
	public void setStrAuthorizationLevel(String strAuthorizationLevel) {
		this.strAuthorizationLevel = strAuthorizationLevel;
	}

	/**
	 * Sets the str authorization no.
	 * 
	 * @param strAuthorizationNo the new str authorization no
	 */
	public void setStrAuthorizationNo(String strAuthorizationNo) {
		this.strAuthorizationNo = strAuthorizationNo;
	}

	/**
	 * Sets the str cost form.
	 * 
	 * @param strCostForm the new str cost form
	 */
	public void setStrCostForm(String strCostForm) {
		this.strCostForm = strCostForm;
	}

	/**
	 * Sets the str cost.
	 * 
	 * @param strCost the new str cost
	 */
	public void setStrCost(String strCost) {
		this.strCost = strCost;
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
	 * Sets the str seat id.
	 * 
	 * @param strSeatId the new str seat id
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
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
	 * Sets the str is valid.
	 * 
	 * @param strIsValid the new str is valid
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
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
	 * Gets the n row inserted.
	 * 
	 * @return the n row inserted
	 */
	public int getNRowInserted() {
		return nRowInserted;
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
	 * Gets the n row deleted.
	 * 
	 * @return the n row deleted
	 */
	public int getNRowDeleted() {
		return nRowDeleted;
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
	 * Gets the n updated index.
	 * 
	 * @return the n updated index
	 */
	public int getNUpdatedIndex() {
		return nUpdatedIndex;
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

	// Methods starts from here

	/**
	 * Insert.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */
	public void insert(HisDAO dao) throws Exception {
		strErr = "";
		int nQueryIndex = 0;
		String strQuery = null;

		try {

			if (strAuthorizationTypeId.equals("0")
					|| strAuthorizationTypeId.equals("")) {
				throw new Exception("strAuthorizationTypeId can not be blank");
			}
			if (strAuthorizationLevel.equals("0")
					|| strAuthorizationLevel.equals("")) {
				throw new Exception("strAuthorizationLevel can not be blank");
			}
			if (strEffectiveFrom.equals("0") || strEffectiveFrom.equals("")) {
				throw new Exception("strEffectiveFrom can not be blank");
			}
			if (strSeatId.equals("0") || strSeatId.equals("")) {
				throw new Exception("strSeatId can not be blank");
			}
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			// check mandatory information

			strQuery = mms.qryHandler_mms.getQuery(1, "insert.authorization.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strAuthorizationTypeId);
			dao.setQryValue(nQueryIndex, 2, strHospitalCode);
			dao.setQryValue(nQueryIndex, 3, strHospitalCode);
			dao.setQryValue(nQueryIndex, 4, strStoreId);
			dao.setQryValue(nQueryIndex, 5, strUserId);
			dao.setQryValue(nQueryIndex, 6, strAuthorizationTypeId);
			dao.setQryValue(nQueryIndex, 7, strAuthorizationLevel);
			dao.setQryValue(nQueryIndex, 8, strCostForm);
			dao.setQryValue(nQueryIndex, 9, strCost);
			dao.setQryValue(nQueryIndex, 10, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 11, strSeatId);
			dao.setQryValue(nQueryIndex, 12, strIsValid);

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
	 * Update.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */
	public void update(HisDAO dao) throws Exception {
		strErr = "";

		try {

			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1, "update.authorization.1");

			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, strCostForm);
			dao.setQryValue(nQueryIndex, 2, strCost);
			dao.setQryValue(nQueryIndex, 3, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 4, strLastModifiedSeatId);
			dao.setQryValue(nQueryIndex, 5, strIsValid);
			dao.setQryValue(nQueryIndex, 6, strAuthorizationNo);
			dao.setQryValue(nQueryIndex, 7, strHospitalCode);
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

		strUserId = "0";

		strAuthorizationTypeId = "";
		strAuthorizationLevel = "";
		strAuthorizationNo = "";
		strCostForm = "";
		strCost = "";
		strStoreId = "0";
		strEffectiveFrom = "";
		strSeatId = "";
		strLastModifiedSeatId = "";
		strIsValid = "1";
		strHospitalCode = "";

	}

	/**
	 * Sets the str authorization type id.
	 * 
	 * @param strAuthorizationTypeId the new str authorization type id
	 */
	public void setStrAuthorizationTypeId(String strAuthorizationTypeId) {
		this.strAuthorizationTypeId = strAuthorizationTypeId;
	}

}
