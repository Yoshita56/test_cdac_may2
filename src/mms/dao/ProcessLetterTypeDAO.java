package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcessLetterTypeDAO.
 */
public final class ProcessLetterTypeDAO {

	/** The str proc name. */
//	private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.ProcessLetterTypeDAO";

	/** The str letter type id. */
	private String strLetterTypeId = "";
	
	/** The str left letter type id. */
//	private String strLeftLetterTypeId = "";
	
	/** The str right letter type id. */
	private String strRightLetterTypeId = "";
	
	/** The str letter type name. */
//	private String strLetterTypeName = "";
	
	/** The str left letter name. */
//	private String[] strLeftLetterName = null;
	
	/** The str right letter name. */
//	private String[] strRightLetterName = null;

	/** The str process id. */
	private String strProcessId = "0";
	
	/** The str process name. */
//	private String strProcessName = "";

	/** The str store type id. */
//	private String strStoreTypeId = "0";
	
	/** The str store type name. */
//	private String strStoreTypeName = "";
	
	/** The str process sl no. */
	private String strProcessSlNo = "";

	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str entry date. */
//	private String strEntryDate = "";
	
	/** The str last modified date. */
//	private String strLastModifiedDate = "";
	
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
	 * Gets the str err.
	 * 
	 * @return the str err
	 */
	public String getStrErr() {
		return strErr;
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
	 * Sets the str letter type id.
	 * 
	 * @param strLetterTypeId the new str letter type id
	 */
	public void setStrLetterTypeId(String strLetterTypeId) {
		this.strLetterTypeId = strLetterTypeId;
	}

	 
	/**
	 * Sets the str process id.
	 * 
	 * @param strProcessId the new str process id
	 */
	public void setStrProcessId(String strProcessId) {
		this.strProcessId = strProcessId;
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
	 * Sets the str remarks.
	 * 
	 * @param strRemarks the new str remarks
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
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

			if (strRightLetterTypeId.equals("0")
					|| strRightLetterTypeId.equals("")) {
				throw new Exception("strRightLetterTypeId can not be blank");
			}
			if (strProcessId.equals("0") || strProcessId.equals("")) {
				throw new Exception("strProcessId can not be blank");
			}
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}

			// check mandatory information
			int nQueryIndex = 0;
			String strQuery = null;
			strQuery = mms.qryHandler_mms.getQuery(1,
					"insert.ProcessLetterTypeMst.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strHospitalCode);
			dao.setQryValue(nQueryIndex, 2, strRightLetterTypeId);
			dao.setQryValue(nQueryIndex, 3, strProcessId);
			dao.setQryValue(nQueryIndex, 4, strRightLetterTypeId);
			dao.setQryValue(nQueryIndex, 5, strProcessId);
			dao.setQryValue(nQueryIndex, 6, strHospitalCode);
			dao.setQryValue(nQueryIndex, 7, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 8, strRemarks);
			dao.setQryValue(nQueryIndex, 9, strSeatId);
			dao.setQryValue(nQueryIndex, 10, strIsValid);
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

			/*
			 * if(strLetterTypeId.equals("0") || strLetterTypeId.equals("")) {
			 * throw new Exception("strLetterTypeId can not be blank"); }
			 * if(strProcessId.equals("0") || strProcessId.equals("")) { throw
			 * new Exception("strProcessId can not be blank"); }
			 * if(strEffectiveFrom.equals("0") || strEffectiveFrom.equals("")) {
			 * throw new Exception("strEffectiveFrom can not be blank"); }
			 * if(strSeatId.equals("0") || strSeatId.equals("")) { throw new
			 * Exception("strSeatId can not be blank"); }
			 * if(strHospitalCode.equals("0") || strHospitalCode.equals("")) {
			 * throw new Exception("strHospitalCode can not be blank"); }
			 */
			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1,
					"update.ProcessLetterTypeMst.1");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 2, strLastModifiedSeatId);
			dao.setQryValue(nQueryIndex, 3, strRemarks);
			dao.setQryValue(nQueryIndex, 4, strIsValid);
			dao.setQryValue(nQueryIndex, 5, strLetterTypeId);
			dao.setQryValue(nQueryIndex, 6, strProcessId);
			dao.setQryValue(nQueryIndex, 7, strHospitalCode);
			dao.setQryValue(nQueryIndex, 8, strProcessSlNo);
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

		strLetterTypeId = "0";
	//	strLeftLetterTypeId = "0";
		strRightLetterTypeId = "0";
	//	strLetterTypeName = "";
		strProcessId = "0";
	//	strProcessName = "";
	//	strStoreTypeId = "0";
	//	strStoreTypeName = "";
		strProcessSlNo = "";
		strEffectiveFrom = "";
		strRemarks = "";
	//	strEntryDate = "";
	//	strLastModifiedDate = "";
		strSeatId = "";
		strLastModifiedSeatId = "";
		strIsValid = "1";
		strHospitalCode = "";

	}

	/**
	 * Sets the str process sl no.
	 * 
	 * @param strProcessSlNo the new str process sl no
	 */
	public void setStrProcessSlNo(String strProcessSlNo) {
		this.strProcessSlNo = strProcessSlNo;
	}

 
	/**
	 * Sets the str right letter type id.
	 * 
	 * @param strRightLetterTypeId the new str right letter type id
	 */
	public void setStrRightLetterTypeId(String strRightLetterTypeId) {
		this.strRightLetterTypeId = strRightLetterTypeId;
	}

	 

}
