package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class MmsConfigPenaltyDAO.
 */
public final class MmsConfigPenaltyDAO {

	// private final String strProcName = "";
	/** The str file name. */
	private final String strFileName = "mms.dao.MmsConfigPenaltyDAO";

	/** The str from days. */
	private String strFromDays = "";
	
	/** The str to days. */
	private String strToDays = "";
	
	/** The str penalty. */
	private String strPenalty = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str Purchase Type. */
	
	private String strPurchaseType = "";

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
	 * Sets the str Purchase Type.
	 * 
	 * @param strPurchaseType the new strPurchaseType
	 */
	public void setStrPurchaseType(String strPurchaseType) {
		this.strPurchaseType = strPurchaseType;
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
	 * Sets the str seat id.
	 * 
	 * @param strSeatId the new str seat id
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode the new str hospital code
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
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

		try {

			// check mandatory information
			int nQueryIndex = 0;
			String strQuery = null;
			strQuery = mms.qryHandler_mms.getQuery(1, "insert.mmsConfigMst.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strHospitalCode);
			dao.setQryValue(nQueryIndex, 2, strFromDays);
			dao.setQryValue(nQueryIndex, 3, strToDays);
			dao.setQryValue(nQueryIndex, 4, strPenalty);
			dao.setQryValue(nQueryIndex, 5, strSeatId);
			dao.setQryValue(nQueryIndex, 6, strPurchaseType);

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
	 * Delete.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */
	public void delete(HisDAO dao) throws Exception {
		strErr = "";

		try {

			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1, "delete.mmsConfigMst.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strHospitalCode);
			dao.setQryValue(nQueryIndex, 2, strPurchaseType);
			dao.execute(nQueryIndex, 0);
			this.nRowDeleted++;

		} catch (Exception e) {
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".delete() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

	}

	/**
	 * Reset.
	 */
	public void reset() {

		strFromDays = "";
		strToDays = "";
		strPenalty = "";
		strSeatId = "";
		strHospitalCode = "";

	}

	/**
	 * Sets the str from days.
	 * 
	 * @param strFromDays the new str from days
	 */
	public void setStrFromDays(String strFromDays) {
		this.strFromDays = strFromDays;
	}

	/**
	 * Sets the str to days.
	 * 
	 * @param strToDays the new str to days
	 */
	public void setStrToDays(String strToDays) {
		this.strToDays = strToDays;
	}

	/**
	 * Sets the str penalty.
	 * 
	 * @param strPenalty the new str penalty
	 */
	public void setStrPenalty(String strPenalty) {
		this.strPenalty = strPenalty;
	}

}
