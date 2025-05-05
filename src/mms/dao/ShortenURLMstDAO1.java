package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreHierarchyDAO.
 */

/**
 * Developer : Anshul Jindal Version : 1.0 Date : 31/Dec/2008
 * 
 * This class will be used to insert/update/delete the records Table Name :
 * HSTT_STOREHIERARCHY_MST
 */
public class ShortenURLMstDAO1 {

	/** The str proc name. */
//	private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.StoreHierarchyDAO";

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str from store id. */
	private String strFromStoreId = "";
	
	/** The str indent type id. */
	private String strIndentTypeId = "";
	
	/** The str to store id. */
	private String strToStoreId = "";
	
	/** The str from store name. */
//	private String strFromStoreName = "";
	
	/** The str to store name. */
//	private String strToStoreName = "";
	
	/** The str sl no. */
	private String strSLNo = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str effective to. */
//	private String strEffectiveTo = "";
	
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
	
	/** The str item cat id. */
	private String strItemCatId = "";

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
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Sets the str from store id.
	 * 
	 * @param strFromStoreId the strFromStoreId to set
	 */
	public void setStrFromStoreId(String strFromStoreId) {
		this.strFromStoreId = strFromStoreId;
	}

	/**
	 * Sets the str to store id.
	 * 
	 * @param strToStoreId the strToStoreId to set
	 */
	public void setStrToStoreId(String strToStoreId) {
		this.strToStoreId = strToStoreId;
	}

	 

	/**
	 * Sets the str sl no.
	 * 
	 * @param strSLNo the strSLNo to set
	 */
	public void setStrSLNo(String strSLNo) {
		this.strSLNo = strSLNo;
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
	 * when strFromStoreId or strHospitalCode or strToStoreId is
	 * blank
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strItemCatId.equals("0") || strItemCatId.equals("")) {
				throw new Exception("strItemCatId can not be blank");
			}
			if (strFromStoreId.equals("0") || strFromStoreId.equals("")) {
				throw new Exception("strFromStoreId can not be blank");
			}
			if (strToStoreId.equals("0") || strToStoreId.equals("")) {
				throw new Exception("strToStoreId can not be blank");
			}
			if (strIndentTypeId.equals("0") || strIndentTypeId.equals("")) {
				throw new Exception("strIndentTypeId can not be blank");
			}

			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms
					.getQuery(1, "insert.StoreHierarchy.0");
			nQueryIndex = dao.setQuery(strQuery);

			// // //System.out.println("DAO strToStoreId-"+strToStoreId);
			dao.setQryValue(nQueryIndex, 1, strFromStoreId);
			dao.setQryValue(nQueryIndex, 2, strIndentTypeId);
			dao.setQryValue(nQueryIndex, 3, strToStoreId);
			dao.setQryValue(nQueryIndex, 4, strHospitalCode);

			dao.setQryValue(nQueryIndex, 5, strHospitalCode);
			dao.setQryValue(nQueryIndex, 6, strFromStoreId);
			dao.setQryValue(nQueryIndex, 7, strToStoreId);

			dao.setQryValue(nQueryIndex, 8, strRemarks);
			dao.setQryValue(nQueryIndex, 9, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 10, strSeatId);
			dao.setQryValue(nQueryIndex, 11, strIsValid);
			dao.setQryValue(nQueryIndex, 12, strItemCatId);

			dao.execute(nQueryIndex, 0);
			this.nRowInserted++;
		} catch (Exception e) {

			e.printStackTrace();
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
	 * when strFromStoreId or strHospitalCode OR strToStoreId or
	 * strSLNo is blank
	 */
	public void update(HisDAO dao) throws Exception {
		strErr = "";

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strItemCatId.equals("0") || strItemCatId.equals("")) {
				throw new Exception("strItemCatId can not be blank");
			}
			if (strFromStoreId.equals("0") || strFromStoreId.equals("")) {
				throw new Exception("strFromStoreId can not be blank");
			}
			if (strToStoreId.equals("0") || strToStoreId.equals("")) {
				throw new Exception("strToStoreId can not be blank");
			}
			if (strSLNo.equals("0") || strSLNo.equals("")) {
				throw new Exception("strSLNo can not be blank");
			}

			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms
					.getQuery(1, "update.StoreHierarchy.1");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 2, strRemarks);
			dao.setQryValue(nQueryIndex, 3, strIsValid);
			dao.setQryValue(nQueryIndex, 4, strSeatId);
			dao.setQryValue(nQueryIndex, 5, strFromStoreId);
			dao.setQryValue(nQueryIndex, 6, strIndentTypeId);
			dao.setQryValue(nQueryIndex, 7, strToStoreId);
			dao.setQryValue(nQueryIndex, 8, strHospitalCode);
			dao.setQryValue(nQueryIndex, 9, strSLNo);
			dao.setQryValue(nQueryIndex, 10, strItemCatId);

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

		strHospitalCode = "";
		strFromStoreId = "";
		strToStoreId = "";
	//	strFromStoreName = "";
	//	strToStoreName = "";
		strSLNo = "";
	//	strEffectiveTo = "";
		strRemarks = "";
		strEffectiveFrom = "";
	//	strLastModeSeatId = "";
	//	strLastModeDate = "";
		strItemCatId = "";
	//	strEntryDate = "";
		strSeatId = "";
		strIsValid = "1";
		strIndentTypeId = "";

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
	 * Sets the str item cat id.
	 * 
	 * @param strItemCatId the new str item cat id
	 */
	public void setStrItemCatId(String strItemCatId) {
		this.strItemCatId = strItemCatId;
	}

}
