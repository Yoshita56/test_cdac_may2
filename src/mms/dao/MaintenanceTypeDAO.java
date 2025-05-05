package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class MaintenanceTypeDAO.
 */
public class MaintenanceTypeDAO {

	// private final String strProcName = "";
	/** The str file name. */
	private final String strFileName = "mms.dao.MaintenanceTypeDAO";

	/** The str maintenance type code. */
	private String strMaintenanceTypeCode = "";

	/** The str maintenance type name. */
	private String strMaintenanceTypeName = "";

	/** The str effective from. */
	private String strEffectiveFrom = "";

	/** The str remarks. */
	private String strRemarks = "";

	/** The str entry date. */
	// private String strEntryDate = "";
	/** The str last modified date. */
	// private String strLastModifiedDate = "";
	/** The str seat id. */
	private String strSeatId = "";

	/** The str last modified seat id. */
	private String strLastModifiedSeatId = "";

	/** The str is valid. */
	private String strIsValid = "1";

	/** The str hospital code. */
	private String strHospitalCode = "";

	private String strSlNo;

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
	 * @param strErr
	 *            the new str err
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
	 * Sets the str maintenance type code.
	 * 
	 * @param strMaintenanceTypeCode
	 *            the new str maintenance type code
	 */
	public void setStrMaintenanceTypeCode(String strMaintenanceTypeCode) {
		this.strMaintenanceTypeCode = strMaintenanceTypeCode;
	}

	/**
	 * Sets the str maintenance type name.
	 * 
	 * @param strMaintenanceTypeName
	 *            the new str maintenance type name
	 */
	public void setStrMaintenanceTypeName(String strMaintenanceTypeName) {
		this.strMaintenanceTypeName = strMaintenanceTypeName;
	}

	/**
	 * Sets the str effective from.
	 * 
	 * @param strEffectiveFrom
	 *            the new str effective from
	 */
	public void setStrEffectiveFrom(String strEffectiveFrom) {
		this.strEffectiveFrom = strEffectiveFrom;
	}

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks
	 *            the new str remarks
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param strSeatId
	 *            the new str seat id
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * Sets the str last modified seat id.
	 * 
	 * @param strLastModifiedSeatId
	 *            the new str last modified seat id
	 */
	public void setStrLastModifiedSeatId(String strLastModifiedSeatId) {
		this.strLastModifiedSeatId = strLastModifiedSeatId;
	}

	/**
	 * Sets the str is valid.
	 * 
	 * @param strIsValid
	 *            the new str is valid
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	/**
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode
	 *            the new str hospital code
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	public void setStrSlNo(String strSlNo) {
		this.strSlNo = strSlNo;
	}

	// Methods starts from here

	/**
	 * Insert.
	 * 
	 * @param dao
	 *            the dao
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void insert(HisDAO dao) throws Exception {
		strErr = "";

		try {
			/*
			 * if (strMaintenanceTypeName.equals("0") ||
			 * strMaintenanceTypeName.equals("")) { throw new
			 * Exception("strGradeCriteria can not be blank"); } if
			 * (strEffectiveFrom.equals("0") || strEffectiveFrom.equals("")) {
			 * throw new Exception("strEffectiveFrom can not be blank"); } if
			 * (strSeatId.equals("0") || strSeatId.equals("")) { throw new
			 * Exception("strSeatId can not be blank"); } if
			 * (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
			 * throw new Exception("strHospitalCode can not be blank"); }
			 */

			// check mandatory information
			int nQueryIndex = 0;
			String strQuery = null;
			strQuery = mms.qryHandler_mms.getQuery(1,
					"insert.MaintenanceTypeMst.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strHospitalCode);
			dao.setQryValue(nQueryIndex, 2, strHospitalCode);
			dao.setQryValue(nQueryIndex, 3, strMaintenanceTypeName);
			dao.setQryValue(nQueryIndex, 4, strRemarks);
			dao.setQryValue(nQueryIndex, 5, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 6, strSeatId);
			dao.setQryValue(nQueryIndex, 7, strIsValid);
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
	 * @param dao
	 *            the dao
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void update(HisDAO dao) throws Exception {
		strErr = "";

		try {

			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1,
					"update.MaintenanceTypeMst.1");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, strSeatId);
			dao.setQryValue(nQueryIndex, 2, strMaintenanceTypeCode);
			dao.setQryValue(nQueryIndex, 3, strHospitalCode);
			dao.setQryValue(nQueryIndex, 4, strSlNo);
			dao.execute(nQueryIndex, 0);

			strQuery = mms.qryHandler_mms.getQuery(1,
					"update.MaintenanceTypeMst.2");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, strMaintenanceTypeCode);
			dao.setQryValue(nQueryIndex, 2, strHospitalCode);
			dao.setQryValue(nQueryIndex, 3, strMaintenanceTypeName);
			dao.setQryValue(nQueryIndex, 4, strRemarks);
			dao.setQryValue(nQueryIndex, 5, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 6, strSeatId);
			dao.setQryValue(nQueryIndex, 7, strIsValid);
			dao.setQryValue(nQueryIndex, 8, strHospitalCode);
			dao.setQryValue(nQueryIndex, 9, strMaintenanceTypeCode);
			
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

		strMaintenanceTypeCode = "";
		strMaintenanceTypeName = "";

		strEffectiveFrom = "";
		strRemarks = "";
		// strEntryDate = "";
		// strLastModifiedDate = "";
		strSeatId = "";
		strLastModifiedSeatId = "";
		strIsValid = "";
		strHospitalCode = "";

	}

}
