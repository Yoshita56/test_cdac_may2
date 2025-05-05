package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class LetterTypeDAO.
 */
public final class LetterTypeDAO {

	/** The str proc name. */
	//private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.LetterTypeDAO";

	/** The str letter type id. */
	private String strLetterTypeId = "0";
	
	/** The str letter type name. */
	private String strLetterTypeName = "";

	/** The str store type id. */
	private String strStoreTypeId = "0";
	
	/** The str store type name. */
	//private String strStoreTypeName = "";

	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str entry date. */
	//private String strEntryDate = "";
	
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
	 * Sets the str letter type id.
	 * 
	 * @param strLetterTypeId the new str letter type id
	 */
	public void setStrLetterTypeId(String strLetterTypeId) {
		this.strLetterTypeId = strLetterTypeId;
	}

	/**
	 * Sets the str letter type name.
	 * 
	 * @param strLetterTypeName the new str letter type name
	 */
	public void setStrLetterTypeName(String strLetterTypeName) {
		this.strLetterTypeName = strLetterTypeName;
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
	
	public void setStrSlNo(String strSlNo) {
		this.strSlNo = strSlNo;
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
			/*if (strStoreTypeId.equals("0") || strStoreTypeId.equals("")) {
				throw new Exception("strStoreTypeId can not be blank");
			}
			if (strLetterTypeName.equals("0") || strLetterTypeName.equals("")) {
				throw new Exception("strLetterTypeName can not be blank");
			}
			if (strEffectiveFrom.equals("0") || strEffectiveFrom.equals("")) {
				throw new Exception("strEffectiveFrom can not be blank");
			}
			if (strSeatId.equals("0") || strSeatId.equals("")) {
				throw new Exception("strSeatId can not be blank");
			}
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}*/

			// check mandatory information
			int nQueryIndex = 0;
			String strQuery = null;
			strQuery = mms.qryHandler_mms.getQuery(1, "insert.LetterTypeMst.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strHospitalCode);
			dao.setQryValue(nQueryIndex, 2, strStoreTypeId);
			dao.setQryValue(nQueryIndex, 3, strLetterTypeName);
			dao.setQryValue(nQueryIndex, 4, strRemarks);
			dao.setQryValue(nQueryIndex, 5, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 6, strSeatId);
			dao.setQryValue(nQueryIndex, 7, strIsValid);
			dao.setQryValue(nQueryIndex, 8, strStoreTypeId);
			dao.setQryValue(nQueryIndex, 9, strHospitalCode);
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
			 * if(strStoreTypeId.equals("0") || strStoreTypeId.equals("")) {
			 * throw new Exception("strStoreTypeId can not be blank"); }
			 * if(strLetterTypeName.equals("0") || strLetterTypeName.equals("")) {
			 * throw new Exception("strLetterTypeName can not be blank"); }
			 * if(strEffectiveFrom.equals("0") || strEffectiveFrom.equals("")) {
			 * throw new Exception("strEffectiveFrom can not be blank"); }
			 * if(strSeatId.equals("0") || strSeatId.equals("")) { throw new
			 * Exception("strSeatId can not be blank"); }
			 * if(strHospitalCode.equals("0") || strHospitalCode.equals("")) {
			 * throw new Exception("strHospitalCode can not be blank"); }
			 */

			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1, "update.LetterTypeMst.1");
			nQueryIndex = dao.setQuery(strQuery);
			//dao.setQryValue(nQueryIndex, 1, strLetterTypeName);
			//dao.setQryValue(nQueryIndex, 2, strRemarks);
			//dao.setQryValue(nQueryIndex, 3, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 1, strLastModifiedSeatId);
			//dao.setQryValue(nQueryIndex, 5, strIsValid);
			dao.setQryValue(nQueryIndex, 2, strLetterTypeId);
			dao.setQryValue(nQueryIndex, 3, strHospitalCode);
			dao.setQryValue(nQueryIndex, 4, strSlNo);
			dao.execute(nQueryIndex, 0);
			
			strQuery = mms.qryHandler_mms.getQuery(1, "update.LetterTypeMst.2");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strLetterTypeId);
			dao.setQryValue(nQueryIndex, 2, strLetterTypeName);
			dao.setQryValue(nQueryIndex, 3, strRemarks);
			dao.setQryValue(nQueryIndex, 4, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 5, strSeatId);
			dao.setQryValue(nQueryIndex, 6, strIsValid);
			dao.setQryValue(nQueryIndex, 7, strStoreTypeId);
			dao.setQryValue(nQueryIndex, 8, strHospitalCode);
			dao.setQryValue(nQueryIndex, 9, strHospitalCode);
			dao.setQryValue(nQueryIndex, 10, strLetterTypeId);
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
		strLetterTypeName = "";
		strStoreTypeId = "0";
	//	strStoreTypeName = "";
		strEffectiveFrom = "";
		strRemarks = "";
	//	strEntryDate = "";
		//strLastModifiedDate = "";
		strSeatId = "";
		strLastModifiedSeatId = "";
		strIsValid = "1";
		strHospitalCode = "";

	}

	
}
