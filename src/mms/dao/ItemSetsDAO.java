package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemSetsDAO.
 */
public class ItemSetsDAO {

	/** The str proc name. */
	//private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.ItemSetsDAO";

	/** The str set id. */
	private String strSetId = "0";
	
	/** The str item id. */
	private String strItemId = "0";
	
	/** The str item brand id. */
	private String strItemBrandId = "0";
	
	/** The str set sl no. */
	private String strSetSlNo = "";

	/** The str item quantity. */
	private String strItemQuantity = "";
	
	/** The str unit id. */
	private String strUnitId = "0";

	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str effective to. */
	//private String strEffectiveTo = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str entry date. */
	//private String strEntryDate = "";
	
	/** The str last modified date. */
	//private String strLastModifiedDate = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str last modified seat id. */
	private String strLastModifiedSeatId = "";
	
	/** The str is valid. */
	private String strIsValid = "1";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str set cat no. */
	private String strSetCatNo = "";
	
	/** The str item cat no. */
	private String strItemCatNo = "";

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
	 * Sets the str set id.
	 * 
	 * @param strSetId the new str set id
	 */
	public void setStrSetId(String strSetId) {
		this.strSetId = strSetId;
	}

	/**
	 * Sets the str item id.
	 * 
	 * @param strItemId the new str item id
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}

	/**
	 * Sets the str item brand id.
	 * 
	 * @param strItemBrandId the new str item brand id
	 */
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}

	/**
	 * Sets the str set sl no.
	 * 
	 * @param strSetSlNo the new str set sl no
	 */
	public void setStrSetSlNo(String strSetSlNo) {
		this.strSetSlNo = strSetSlNo;
	}

	/**
	 * Sets the str item quantity.
	 * 
	 * @param strItemQuantity the new str item quantity
	 */
	public void setStrItemQuantity(String strItemQuantity) {
		this.strItemQuantity = strItemQuantity;
	}

	/**
	 * Sets the str unit id.
	 * 
	 * @param strUnitId the new str unit id
	 */
	public void setStrUnitId(String strUnitId) {
		this.strUnitId = strUnitId;
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
	 * Sets the str err.
	 * 
	 * @param strErr the new str err
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
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
		int nQueryIndex = 0;
		String strQuery = "";
	//	String[] temp = null;

		try {
			// check mandatory information

			strQuery = mms.qryHandler_mms.getQuery(1, "insert.ItemSetsMst.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strSetId);
			dao.setQryValue(nQueryIndex, 2, strItemId);
			dao.setQryValue(nQueryIndex, 3, strHospitalCode);
			dao.setQryValue(nQueryIndex, 4, strHospitalCode);
			dao.setQryValue(nQueryIndex, 5, strItemId);
			dao.setQryValue(nQueryIndex, 6, strSetId);
			dao.setQryValue(nQueryIndex, 7, strItemQuantity);
			dao.setQryValue(nQueryIndex, 8, strUnitId);
			dao.setQryValue(nQueryIndex, 9, strRemarks);
			dao.setQryValue(nQueryIndex, 10, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 11, strSeatId);
			dao.setQryValue(nQueryIndex, 12, strIsValid);
			dao.setQryValue(nQueryIndex, 13, strItemCatNo);
			dao.setQryValue(nQueryIndex, 14, strSetCatNo);
			dao.setQryValue(nQueryIndex, 15, strItemBrandId);

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

			strQuery = mms.qryHandler_mms.getQuery(1, "update.ItemSetsMst.1");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strLastModifiedSeatId);
			dao.setQryValue(nQueryIndex, 2, strSetId);
			dao.setQryValue(nQueryIndex, 3, strItemId);
			dao.setQryValue(nQueryIndex, 4, strHospitalCode);
			dao.setQryValue(nQueryIndex, 5, strSetSlNo);
			dao.execute(nQueryIndex, 0);
			this.nRowUpdated++;
		} catch (Exception e) {
			e.printStackTrace();
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

		strSetId = "0";

		strItemId = "0";
		strItemBrandId = "0";
		strSetSlNo = "";

		strItemQuantity = "";
		strUnitId = "0";
	//	strEffectiveTo = "";
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
	 * Sets the str set cat no.
	 * 
	 * @param strSetCatNo the new str set cat no
	 */
	public void setStrSetCatNo(String strSetCatNo) {
		this.strSetCatNo = strSetCatNo;
	}

	 

	/**
	 * Sets the str item cat no.
	 * 
	 * @param strItemCatNo the strItemCatNo to set
	 */
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}

}
