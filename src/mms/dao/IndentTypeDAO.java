package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class IndentTypeDAO.
 */

/**
 * Developer : Anshul Jindal Version : 1.0 Date : 31/Dec/2008
 * 
 * This class will be used to insert/update/delete the records Table Name :
 * HSTT_INDENTYPE_MST
 */
public class IndentTypeDAO {

	/** The str proc name. */
	//private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.IndentTypeDAO";

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str indent type id. */
	private String strIndentTypeId = "";
	
	/** The str indent type name. */
	private String strIndentTypeName = "";
	
	/** The str store type id. */
	private String strStoreTypeId = "";
	
	/** The str indent type time. */
	private String strIndentTypeTime = "0";
	
	/** The str indent type time unit. */
	private String strIndentTypeTimeUnit = "0";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str last mode seat id. */
//	private String strLastModeSeatId = "";
	
	/** The str last mode date. */
//	private String strLastModeDate = "";
	
	/** The str entry date. */
//	private String strEntryDate = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str is valid. */
	private String strIsValid = "1";

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
	 * @return the strErr
	 */
	public String getStrErr() {
		return strErr;
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
	 * Gets the n row updated.
	 * 
	 * @return the nRowUpdated
	 */
	public int getNRowUpdated() {
		return nRowUpdated;
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
	 * Gets the n inserted index.
	 * 
	 * @return the nInsertedIndex
	 */
	public int getNInsertedIndex() {
		return nInsertedIndex;
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
	 * Gets the n deleted index.
	 * 
	 * @return the nDeletedIndex
	 */
	public int getNDeletedIndex() {
		return nDeletedIndex;
	}

	/**
	 * Sets the str indent type name.
	 * 
	 * @param strIndentTypeName the strIndentTypeName to set
	 */
	public void setStrIndentTypeName(String strIndentTypeName) {
		this.strIndentTypeName = strIndentTypeName;
	}

	/**
	 * Sets the str store type id.
	 * 
	 * @param strStoreTypeId the strStoreTypeId to set
	 */
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}

	/**
	 * Sets the str indent type time.
	 * 
	 * @param strIndentTypeTime the strIndentTypeTime to set
	 */
	public void setStrIndentTypeTime(String strIndentTypeTime) {
		this.strIndentTypeTime = strIndentTypeTime;
	}

	/**
	 * Sets the str indent type time unit.
	 * 
	 * @param strIndentTypeTimeUnit the strIndentTypeTimeUnit to set
	 */
	public void setStrIndentTypeTimeUnit(String strIndentTypeTimeUnit) {
		this.strIndentTypeTimeUnit = strIndentTypeTimeUnit;
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
	 * Sets the str effective from.
	 * 
	 * @param strEffectiveFrom the strEffectiveFrom to set
	 */
	public void setStrEffectiveFrom(String strEffectiveFrom) {
		this.strEffectiveFrom = strEffectiveFrom;
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
	 * Sets the str is valid.
	 * 
	 * @param strIsValid the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
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
	 * Sets the str indent type id.
	 * 
	 * @param strIndentTypeId the strIndentTypeId to set
	 */
	public void setStrIndentTypeId(String strIndentTypeId) {
		this.strIndentTypeId = strIndentTypeId;
	}

	// Methods starts from here

	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strIndentTypeName or strHospitalCode or strStoreTypeId
	 * is blank
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strIndentTypeName.equals("0") || strIndentTypeName.equals("")) {
				throw new Exception("strIndentTypeName can not be blank");
			}
			if (strStoreTypeId.equals("0") || strStoreTypeId.equals("")) {
				throw new Exception("strStoreTypeId can not be blank");
			}

			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1, "insert.IndentType.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strHospitalCode);
			dao.setQryValue(nQueryIndex, 2, strHospitalCode);
			dao.setQryValue(nQueryIndex, 3, strStoreTypeId);
			dao.setQryValue(nQueryIndex, 4, strIndentTypeName);
			dao.setQryValue(nQueryIndex, 5, strStoreTypeId);
			dao.setQryValue(nQueryIndex, 6, strIndentTypeTime);
			dao.setQryValue(nQueryIndex, 7, strIndentTypeTimeUnit);
			dao.setQryValue(nQueryIndex, 8, strRemarks);
			dao.setQryValue(nQueryIndex, 9, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 10, strSeatId);
			dao.setQryValue(nQueryIndex, 11, strIsValid);

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
	 * This method will be used to update the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strIndentTypeName or strHospitalCode OR strIndentTypeId
	 * is blank
	 */
	public void update(HisDAO dao) throws Exception {
		strErr = "";

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strIndentTypeName.equals("0") || strIndentTypeName.equals("")) {
				throw new Exception("strIndentTypeName can not be blank");
			}
			if (strIndentTypeId.equals("0") || strIndentTypeId.equals("")) {
				throw new Exception("strIndentTypeId can not be blank");
			}

			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1, "update.IndentType.1");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strIndentTypeName);
			dao.setQryValue(nQueryIndex, 2, strIndentTypeTime);
			dao.setQryValue(nQueryIndex, 3, strIndentTypeTimeUnit);
			dao.setQryValue(nQueryIndex, 4, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 5, strSeatId);
			dao.setQryValue(nQueryIndex, 6, strRemarks);
			dao.setQryValue(nQueryIndex, 7, strIsValid);
			dao.setQryValue(nQueryIndex, 8, strHospitalCode);
			dao.setQryValue(nQueryIndex, 9, strIndentTypeId);

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

		strIndentTypeName = "";
		strStoreTypeId = "";
		strIndentTypeTime = "0";
		strIndentTypeTimeUnit = "0";
		strRemarks = "";
		strEffectiveFrom = "";
	//	strLastModeSeatId = "";
	//	strLastModeDate = "";
	//	strEntryDate = "";
		strSeatId = "";
		strIsValid = "1";

	}

}
