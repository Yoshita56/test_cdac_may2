package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class CommitteeTypeDAO.
 * 
 * @author Tanvi Sappal
 * 
 * The Class CommitteeTypeDAO.
 */
public final class CommitteeTypeDAO {

	/** The str proc name. */
	//private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.CommitteeTypeDAO";

	/** The str committee type id. */
	private String strCommitteeTypeId = "0";
	
	/** The str committee type name. */
	private String strCommitteeTypeName = "";
	
	/** The str committee purpose. */
	private String strCommitteePurpose = "";

	/** The str item cat no. */
	private String strItemCatNo = "";
	
	/** The str process id. */
	//private String strProcessId = "";

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
	
	private String strSlNo;
	
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
	 * Sets the str committee type id.
	 * 
	 * @param strCommitteeTypeId the new str committee type id
	 */
	public void setStrCommitteeTypeId(String strCommitteeTypeId) {
		this.strCommitteeTypeId = strCommitteeTypeId;
	}

	/**
	 * Sets the str committee type name.
	 * 
	 * @param strCommitteeTypeName the new str committee type name
	 */
	public void setStrCommitteeTypeName(String strCommitteeTypeName) {
		this.strCommitteeTypeName = strCommitteeTypeName;
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
	 * Sets the str item cat no.
	 * 
	 * @param strItemCatNo the strItemCatNo to set
	 */
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
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

	/**
	 * Sets the str err.
	 * 
	 * @param strErr the new str err
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
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
		
			/*if (strCommitteeTypeName.equals("0")
					|| strCommitteeTypeName.equals("")) {
				throw new Exception("strCommitteeTypeName can not be blank");
			}
			if (strCommitteePurpose.equals("0")
					|| strCommitteePurpose.equals("")) {
				throw new Exception("strCommitteePurpose can not be blank");
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
			
			if (strItemCatNo.equals("")||strItemCatNo.equals(null)) {
				strItemCatNo="0";
			}
			int nQueryIndex = 0;
			String strQuery = null;
			strQuery = mms.qryHandler_mms.getQuery(1,
					"insert.CommitteeTypeMst.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strHospitalCode);
			dao.setQryValue(nQueryIndex, 2, strItemCatNo);
			dao.setQryValue(nQueryIndex, 3, strCommitteeTypeName);
			dao.setQryValue(nQueryIndex, 4, strCommitteePurpose);
			dao.setQryValue(nQueryIndex, 5, strRemarks);
			dao.setQryValue(nQueryIndex, 6, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 7, strSeatId);
			dao.setQryValue(nQueryIndex, 8, strIsValid);
			//dao.setQryValue(nQueryIndex, 9, strItemCatNo);
			//dao.setQryValue(nQueryIndex, 9, strProcessId);
			dao.setQryValue(nQueryIndex,9, strHospitalCode);
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
			 * if(strCommitteeTypeName.equals("0") ||
			 * strCommitteeTypeName.equals("")) { throw new
			 * Exception("strCommitteeTypeName can not be blank"); }
			 * if(strCommitteePurpose.equals("0") ||
			 * strCommitteePurpose.equals("")) { throw new
			 * Exception("strCommitteePurpose can not be blank"); }
			 * if(strEffectiveFrom.equals("0") || strEffectiveFrom.equals("")) {
			 * throw new Exception("strEffectiveFrom can not be blank"); }
			 * if(strSeatId.equals("0") || strSeatId.equals("")) { throw new
			 * Exception("strSeatId can not be blank"); }
			 * if(strHospitalCode.equals("0") || strHospitalCode.equals("")) {
			 * throw new Exception("strHospitalCode can not be blank"); }
			 */

			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1,"update.CommitteeTypeMst.1");
			nQueryIndex = dao.setQuery(strQuery);
			//dao.setQryValue(nQueryIndex, 1, strCommitteeTypeName);
			//dao.setQryValue(nQueryIndex, 2, strCommitteePurpose);
			//dao.setQryValue(nQueryIndex, 3, strRemarks);
			//dao.setQryValue(nQueryIndex, 4, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 1, strLastModifiedSeatId);
//			dao.setQryValue(nQueryIndex, 2, strIsValid);
			dao.setQryValue(nQueryIndex, 2, strCommitteeTypeId);
			dao.setQryValue(nQueryIndex, 3, strHospitalCode);
			dao.setQryValue(nQueryIndex, 4, strSlNo);
		
			dao.execute(nQueryIndex, 0);
			
			strQuery = mms.qryHandler_mms.getQuery(1,"update.CommitteeTypeMst.2");
			
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, strCommitteeTypeId);
			dao.setQryValue(nQueryIndex, 2, strCommitteeTypeName);
			dao.setQryValue(nQueryIndex, 3, strCommitteePurpose);
			dao.setQryValue(nQueryIndex, 4, strRemarks);
			dao.setQryValue(nQueryIndex, 5, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 6, strSeatId);
			dao.setQryValue(nQueryIndex, 7, strIsValid);
			dao.setQryValue(nQueryIndex, 8, strHospitalCode);
			dao.setQryValue(nQueryIndex, 9, strHospitalCode);
			dao.setQryValue(nQueryIndex, 10, strCommitteeTypeId);			
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

		strCommitteeTypeId = "0";
		strCommitteeTypeName = "";
		strCommitteePurpose = "";
	//	strProcessId = "0";
		strItemCatNo = "";
		strEffectiveFrom = "";
		strRemarks = "";
	//	strEntryDate = "";
	//	strLastModifiedDate = "";
		strSeatId = "";
		strLastModifiedSeatId = "";
		strIsValid = "1";
		strHospitalCode = "";

	}

	

}
