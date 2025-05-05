package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcessComponentDAO.
 */
public final class ProcessComponentDAO {

	/** The str proc name. */
//	private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.ProcessLetterTypeDAO";
	
	/** The str process id. */
	private String strProcessId = "";
	
	/** The str component id. */
	private String strComponentId = "";
	
	/** The str componen value1. */
	private String strComponenValue1 = "";
	
	/** The str componen value2. */
	private String strComponenValue2 = "";
	
	/** The str process component slno. */
	private String strProcessComponentSlno = "";

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
//	private String strLastModifiedSeatId = "";
	
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

			if (strProcessId.equals("0") || strProcessId.equals("")) {
				throw new Exception("strProcessId can not be blank");
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
			int nQueryIndex = 0;
			String strQuery = null;
			strQuery = mms.qryHandler_mms.getQuery(1,
					"insert.processComponentMst.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, strProcessId);
			dao.setQryValue(nQueryIndex, 2, strComponentId);
			dao.setQryValue(nQueryIndex, 3, strHospitalCode);
			dao.setQryValue(nQueryIndex, 4, strComponenValue1);
			dao.setQryValue(nQueryIndex, 5, strComponenValue2);
			dao.setQryValue(nQueryIndex, 6, strRemarks);
			dao.setQryValue(nQueryIndex, 7, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 8, strSeatId);
			dao.setQryValue(nQueryIndex, 9, strIsValid);
			dao.setQryValue(nQueryIndex, 10, strHospitalCode);
			dao.setQryValue(nQueryIndex, 11, strComponentId);
			dao.setQryValue(nQueryIndex, 12, strProcessId);
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
			/*
			 * update HSTT_PROCESS_COMPONENT_MST set HSTSTR_COMPONENT_VALUE1=?,
			 * HSTSTR_COMPONENT_VALUE2=?, GSTR_REMARKS=trim(?), \
			 * GDT_EFFECTIVE_FRM=?,GDT_LSTMOD_DATE=sysdate,
			 * GNUM_LSTMOD_SEATID=?,GNUM_ISVALID=? \ where SSTNUM_PROCESS_ID=?
			 * and HSTNUM_COMPONENT_ID=? and GNUM_HOSPITAL_CODE=? and
			 * HSTNUM_SL_NO=?
			 */
			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1,
					"update.processComponentMst.1");
			nQueryIndex = dao.setQuery(strQuery);
			/*
			 * //System.out.println("strQuery"+strQuery); //
			 * //System.out.println("strComponenValue1"+strComponenValue1); //
			 * //System.out.println("strComponenValue2"+strComponenValue2); //
			 * //System.out.println("strRemarks"+strRemarks); //
			 * //System.out.println("strEffectiveFrom"+strEffectiveFrom); //
			 * //System.out.println("strSeatId"+strSeatId); //
			 * //System.out.println("strProcessId"+strProcessId); //
			 * //System.out.println("strIsValid"+strIsValid); //
			 * //System.out.println("strComponentId"+strComponentId); //
			 * //System.out.println("strHospitalCode"+strHospitalCode); //
			 * //System.out.println("strProcessComponentSlno"+strProcessComponentSlno);
			 */
			dao.setQryValue(nQueryIndex, 1, strComponenValue1);
			dao.setQryValue(nQueryIndex, 2, strComponenValue2);
			dao.setQryValue(nQueryIndex, 3, strRemarks);
			dao.setQryValue(nQueryIndex, 4, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 5, strSeatId);
			dao.setQryValue(nQueryIndex, 6, strIsValid);
			dao.setQryValue(nQueryIndex, 7, strComponentId);
			dao.setQryValue(nQueryIndex, 8, strProcessId);
			dao.setQryValue(nQueryIndex, 9, strHospitalCode);
			dao.setQryValue(nQueryIndex, 10, strProcessComponentSlno);
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

		strProcessId = "";
		strComponentId = "";
		strComponenValue1 = "";
		strComponenValue2 = "";
		strProcessComponentSlno = "";
		strEffectiveFrom = "";
		strRemarks = "";
	//	strEntryDate = "";
	//	strLastModifiedDate = "";
		strSeatId = "";
	//	strLastModifiedSeatId = "";
		strIsValid = "1";
		strHospitalCode = "";
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
	 * Sets the str component id.
	 * 
	 * @param strComponentId the new str component id
	 */
	public void setStrComponentId(String strComponentId) {
		this.strComponentId = strComponentId;
	}

	/**
	 * Sets the str componen value1.
	 * 
	 * @param strComponenValue1 the new str componen value1
	 */
	public void setStrComponenValue1(String strComponenValue1) {
		this.strComponenValue1 = strComponenValue1;
	}

	/**
	 * Sets the str componen value2.
	 * 
	 * @param strComponenValue2 the new str componen value2
	 */
	public void setStrComponenValue2(String strComponenValue2) {
		this.strComponenValue2 = strComponenValue2;
	}

	/**
	 * Sets the str process component slno.
	 * 
	 * @param strProcessComponentSlno the new str process component slno
	 */
	public void setStrProcessComponentSlno(String strProcessComponentSlno) {
		this.strProcessComponentSlno = strProcessComponentSlno;
	}

}
