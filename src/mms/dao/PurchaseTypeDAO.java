package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class PurchaseTypeDAO.
 */

/**
 * Developer : Anshul Jindal Version : 1.0 Date : 05/Jan/2009
 * 
 * This class will be used to insert/update/delete the records Table Name :
 * HSTT_PURCHASE_TYPE_MST
 */
public class PurchaseTypeDAO {

	/** The str proc name. */
	//private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.PurchaseTypeDAO";

	/** The str store type id. */
	private String strStoreTypeId = "";

	/** The str purchase type id. */
	private String strPurchaseTypeId = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str purchase type name. */
	private String strPurchaseTypeName = "";
	
	/** The str purchase type limit. */
	private String strPurchaseTypeLimit = "0";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str lstmod seat id. */
//	private String strLstmodSeatId = "";
	
	/** The str lstmod date. */
	//private String strLstmodDate = "";
	
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
	 * Sets the str store type id.
	 * 
	 * @param strStoreTypeId the strStoreTypeId to set
	 */
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}

	/**
	 * Sets the str purchase type id.
	 * 
	 * @param strPurchaseTypeId the strPurchaseTypeId to set
	 */
	public void setStrPurchaseTypeId(String strPurchaseTypeId) {
		this.strPurchaseTypeId = strPurchaseTypeId;
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
	 * Sets the str purchase type name.
	 * 
	 * @param strPurchaseTypeName the strPurchaseTypeName to set
	 */
	public void setStrPurchaseTypeName(String strPurchaseTypeName) {
		this.strPurchaseTypeName = strPurchaseTypeName;
	}

	/**
	 * Sets the str purchase type limit.
	 * 
	 * @param strPurchaseTypeLimit the strPurchaseTypeLimit to set
	 */
	public void setStrPurchaseTypeLimit(String strPurchaseTypeLimit) {
		this.strPurchaseTypeLimit = strPurchaseTypeLimit;
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

	// Methods starts from here

	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strPurchaseTypeName or strHospitalCode or strStoreTypeId
	 * is blank
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strPurchaseTypeName.equals("0")
					|| strPurchaseTypeName.equals("")) {
				throw new Exception("strPurchaseTypeName can not be blank");
			}
			if (strStoreTypeId.equals("0") || strStoreTypeId.equals("")) {
				throw new Exception("strStoreTypeId can not be blank");
			}

			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1, "insert.PurchaseType.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strStoreTypeId);
			dao.setQryValue(nQueryIndex, 2, strHospitalCode);
			dao.setQryValue(nQueryIndex, 3, strHospitalCode);
			dao.setQryValue(nQueryIndex, 4, strStoreTypeId);
			dao.setQryValue(nQueryIndex, 5, strPurchaseTypeName);
			dao.setQryValue(nQueryIndex, 6, strPurchaseTypeLimit);
			dao.setQryValue(nQueryIndex, 7, strRemarks);
			dao.setQryValue(nQueryIndex, 8, strEffectiveFrom);
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
	 * This method will be used to update the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strPurchaseTypeName or strHospitalCode OR
	 * strPurchaseTypeId is blank
	 */
	public void update(HisDAO dao) throws Exception {
		strErr = "";

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strPurchaseTypeName.equals("0")
					|| strPurchaseTypeName.equals("")) {
				throw new Exception("strPurchaseTypeName can not be blank");
			}
			if (strPurchaseTypeId.equals("0") || strPurchaseTypeId.equals("")) {
				throw new Exception("strPurchaseTypeId can not be blank");
			}

			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1, "update.PurchaseType.1");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strPurchaseTypeName);
			dao.setQryValue(nQueryIndex, 2, strPurchaseTypeLimit);
			dao.setQryValue(nQueryIndex, 3, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 4, strSeatId);
			dao.setQryValue(nQueryIndex, 5, strRemarks);
			dao.setQryValue(nQueryIndex, 6, strIsValid);
			dao.setQryValue(nQueryIndex, 7, strHospitalCode);
			dao.setQryValue(nQueryIndex, 8, strPurchaseTypeId);

			dao.execute(nQueryIndex, 0);
			this.nRowInserted++;
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

		strStoreTypeId = "";
		strPurchaseTypeId = "";
		strHospitalCode = "";
		strPurchaseTypeName = "";
		strPurchaseTypeLimit = "0";
		strRemarks = "";
		strEffectiveFrom = "";
	//	strLstmodSeatId = "";
	//	strLstmodDate = "";
	//	strEntryDate = "";
		strSeatId = "";
		strIsValid = "1";

	}

}
