package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class IndentAuthorizationDAO.
 */
public class IndentAuthorizationDAO {
	
	/** The str file name. */
	private final String strFileName = "mms.dao.IndentAuthorizationDAO";

	/** The str authorization no. */
	private String strAuthorizationNo = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str store id. */
	private String strStoreId = "";
	
	/** The str item cat no. */
	private String strItemCatNo = "";
	
	/** The str auth type id. */
	private String strAuthTypeId = "";
	
	/** The str indent type id. */
	private String strIndentTypeId = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str effective to. */
	private String strEffectiveTo = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str emp id. */
	private String strEmpId = "";
	
	/** The str is valid. */
	private String strIsValid = "1";
	
	/** The str entry date. */
	private String strEntryDate = "";
	
	/** The str last mod date. */
	private String strLastModDate = "";
	
	/** The str last mod seat id. */
	private String strLastModSeatId = "";
	
	/** The str level. */
	private String strLevel = "";
	
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
	 * Gets the str authorization no.
	 * 
	 * @return the strAuthorizationNo
	 */
	public String getStrAuthorizationNo() {
		return strAuthorizationNo;
	}

	/**
	 * Sets the str authorization no.
	 * 
	 * @param strAuthorizationNo the strAuthorizationNo to set
	 */
	public void setStrAuthorizationNo(String strAuthorizationNo) {
		this.strAuthorizationNo = strAuthorizationNo;
	}

	/**
	 * Gets the str hospital code.
	 * 
	 * @return the strHospitalCode
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	/**
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Gets the str store id.
	 * 
	 * @return the strStoreId
	 */
	public String getStrStoreId() {
		return strStoreId;
	}

	/**
	 * Sets the str store id.
	 * 
	 * @param strStoreId the strStoreId to set
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	/**
	 * Gets the str item cat no.
	 * 
	 * @return the strItemCatNo
	 */
	public String getStrItemCatNo() {
		return strItemCatNo;
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
	 * Gets the str auth type id.
	 * 
	 * @return the strAuthTypeId
	 */
	public String getStrAuthTypeId() {
		return strAuthTypeId;
	}

	/**
	 * Sets the str auth type id.
	 * 
	 * @param strAuthTypeId the strAuthTypeId to set
	 */
	public void setStrAuthTypeId(String strAuthTypeId) {
		this.strAuthTypeId = strAuthTypeId;
	}

	/**
	 * Gets the str indent type id.
	 * 
	 * @return the strIndentTypeId
	 */
	public String getStrIndentTypeId() {
		return strIndentTypeId;
	}

	/**
	 * Sets the str indent type id.
	 * 
	 * @param strIndentTypeId the strIndentTypeId to set
	 */
	public void setStrIndentTypeId(String strIndentTypeId) {
		this.strIndentTypeId = strIndentTypeId;
	}

	/**
	 * Gets the str effective from.
	 * 
	 * @return the strEffectiveFrom
	 */
	public String getStrEffectiveFrom() {
		return strEffectiveFrom;
	}

	/**
	 * Sets the str effective from.
	 * 
	 * @param strEffectiveFrom the strEffectiveFrom to set
	 */
	public void setStrEffectiveFrom(String strEffectiveFrom) {
		this.strEffectiveFrom = strEffectiveFrom;
	}

	/**
	 * Gets the str effective to.
	 * 
	 * @return the strEffectiveTo
	 */
	public String getStrEffectiveTo() {
		return strEffectiveTo;
	}

	/**
	 * Sets the str effective to.
	 * 
	 * @param strEffectiveTo the strEffectiveTo to set
	 */
	public void setStrEffectiveTo(String strEffectiveTo) {
		this.strEffectiveTo = strEffectiveTo;
	}

	/**
	 * Gets the str remarks.
	 * 
	 * @return the strRemarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * Gets the str seat id.
	 * 
	 * @return the strSeatId
	 */
	public String getStrSeatId() {
		return strSeatId;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param strSeatId the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * Gets the str emp id.
	 * 
	 * @return the strEmpId
	 */
	public String getStrEmpId() {
		return strEmpId;
	}

	/**
	 * Sets the str emp id.
	 * 
	 * @param strEmpId the strEmpId to set
	 */
	public void setStrEmpId(String strEmpId) {
		this.strEmpId = strEmpId;
	}

	/**
	 * Gets the str is valid.
	 * 
	 * @return the strIsValid
	 */
	public String getStrIsValid() {
		return strIsValid;
	}

	/**
	 * Sets the str is valid.
	 * 
	 * @param strIsValid the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	/**
	 * Gets the str entry date.
	 * 
	 * @return the strEntryDate
	 */
	public String getStrEntryDate() {
		return strEntryDate;
	}

	/**
	 * Sets the str entry date.
	 * 
	 * @param strEntryDate the strEntryDate to set
	 */
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}

	/**
	 * Gets the str last mod date.
	 * 
	 * @return the strLastModDate
	 */
	public String getStrLastModDate() {
		return strLastModDate;
	}

	/**
	 * Sets the str last mod date.
	 * 
	 * @param strLastModDate the strLastModDate to set
	 */
	public void setStrLastModDate(String strLastModDate) {
		this.strLastModDate = strLastModDate;
	}

	/**
	 * Gets the str last mod seat id.
	 * 
	 * @return the strLastModSeatId
	 */
	public String getStrLastModSeatId() {
		return strLastModSeatId;
	}

	/**
	 * Sets the str last mod seat id.
	 * 
	 * @param strLastModSeatId the strLastModSeatId to set
	 */
	public void setStrLastModSeatId(String strLastModSeatId) {
		this.strLastModSeatId = strLastModSeatId;
	}

	/**
	 * Gets the str level.
	 * 
	 * @return the strLevel
	 */
	public String getStrLevel() {
		return strLevel;
	}

	/**
	 * Sets the str level.
	 * 
	 * @param strLevel the strLevel to set
	 */
	public void setStrLevel(String strLevel) {
		this.strLevel = strLevel;
	}

	/**
	 * Gets the n row inserted.
	 * 
	 * @return the nRowInserted
	 */
	public int getNRowInserted() {
		return nRowInserted;
	}

	/**
	 * Sets the n row inserted.
	 * 
	 * @param rowInserted the nRowInserted to set
	 */
	public void setNRowInserted(int rowInserted) {
		nRowInserted = rowInserted;
	}

	/**
	 * Gets the n row updated.
	 * 
	 * @return the nRowUpdated
	 */
	public int getNRowUpdated() {
		return nRowUpdated;
	}

	/**
	 * Sets the n row updated.
	 * 
	 * @param rowUpdated the nRowUpdated to set
	 */
	public void setNRowUpdated(int rowUpdated) {
		nRowUpdated = rowUpdated;
	}

	/**
	 * Gets the n row deleted.
	 * 
	 * @return the nRowDeleted
	 */
	public int getNRowDeleted() {
		return nRowDeleted;
	}

	/**
	 * Sets the n row deleted.
	 * 
	 * @param rowDeleted the nRowDeleted to set
	 */
	public void setNRowDeleted(int rowDeleted) {
		nRowDeleted = rowDeleted;
	}

	/**
	 * Gets the n inserted index.
	 * 
	 * @return the nInsertedIndex
	 */
	public int getNInsertedIndex() {
		return nInsertedIndex;
	}

	/**
	 * Sets the n inserted index.
	 * 
	 * @param insertedIndex the nInsertedIndex to set
	 */
	public void setNInsertedIndex(int insertedIndex) {
		nInsertedIndex = insertedIndex;
	}

	/**
	 * Gets the n updated index.
	 * 
	 * @return the nUpdatedIndex
	 */
	public int getNUpdatedIndex() {
		return nUpdatedIndex;
	}

	/**
	 * Sets the n updated index.
	 * 
	 * @param updatedIndex the nUpdatedIndex to set
	 */
	public void setNUpdatedIndex(int updatedIndex) {
		nUpdatedIndex = updatedIndex;
	}

	/**
	 * Gets the n deleted index.
	 * 
	 * @return the nDeletedIndex
	 */
	public int getNDeletedIndex() {
		return nDeletedIndex;
	}

	/**
	 * Sets the n deleted index.
	 * 
	 * @param deletedIndex the nDeletedIndex to set
	 */
	public void setNDeletedIndex(int deletedIndex) {
		nDeletedIndex = deletedIndex;
	}

	/**
	 * Gets the str err.
	 * 
	 * @return the strErr
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * Sets the str err.
	 * 
	 * @param strErr the strErr to set
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

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

			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			// check mandatory information

			strQuery = mms.qryHandler_mms.getQuery(1,
					"insert.indentauthorization.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strHospitalCode);
			dao.setQryValue(nQueryIndex, 2, strHospitalCode);
			dao.setQryValue(nQueryIndex, 3, strStoreId);
			dao.setQryValue(nQueryIndex, 4, strItemCatNo);
			dao.setQryValue(nQueryIndex, 5, strAuthTypeId);
			dao.setQryValue(nQueryIndex, 6, strIndentTypeId);
			dao.setQryValue(nQueryIndex, 7, strEmpId);
			dao.setQryValue(nQueryIndex, 8, strLevel);
			dao.setQryValue(nQueryIndex, 9, strRemarks);
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

			strQuery = mms.qryHandler_mms.getQuery(1,
					"update.indentauthorization.1");

			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, strEmpId);
			dao.setQryValue(nQueryIndex, 2, strLevel);
			dao.setQryValue(nQueryIndex, 3, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 4, strSeatId);
			dao.setQryValue(nQueryIndex, 5, strIsValid);
			dao.setQryValue(nQueryIndex, 6, strRemarks);
			dao.setQryValue(nQueryIndex, 7, strAuthorizationNo);
			dao.setQryValue(nQueryIndex, 8, strHospitalCode);
			/*
			 * //System.out.println("strEmpId"+strEmpId);
			 * //System.out.println("strLevel"+strLevel);
			 * //System.out.println("strEffectiveFrom"+strEffectiveFrom);
			 * //System.out.println("strSeatId"+strSeatId);
			 * //System.out.println("strIsValid"+strIsValid);
			 * //System.out.println("strRemarks"+strEmpId);
			 * //System.out.println("strAuthorizationNo"+strAuthorizationNo);
			 * //System.out.println("strHospitalCode"+strHospitalCode);
			 */
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

		strAuthorizationNo = "";
		strHospitalCode = "";
		strStoreId = "";
		strItemCatNo = "";
		strAuthTypeId = "";
		strIndentTypeId = "";
		strEffectiveFrom = "";
		strEffectiveTo = "";
		strRemarks = "";
		strSeatId = "";
		strEmpId = "";
		strIsValid = "1";
		strEntryDate = "";
		strLastModDate = "";
		strLastModSeatId = "";
		strLevel = "";
		strErr = "";

	}

}
