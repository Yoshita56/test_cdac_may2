package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreCategoryDAO.
 */
public class StoreCategoryDAO {
	
	/** The str file name. */
	private final String strFileName = "mms.dao.StoreCategoryDAO";

	private String strStoreItemCategory;
	private String strItemBounded;
	private String strIsNewItemFlag;
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str store id. */
	private String strStoreId = "";
	
	/** The str item cat no. */
	private String strItemCatNo = "";
	
	/** The str store cat sl no. */
	private String strStoreCatSlNo = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str effective to. */
	private String strEffectiveTo = "";
	
	/** The str last mode seat id. */
	private String strLastModeSeatId = "";
	
	/** The str last mode date. */
	private String strLastModeDate = "";
	
	/** The str entry date. */
	private String strEntryDate = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str is valid. */
	private String strIsValid = "";

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
	 * Gets the str store cat sl no.
	 * 
	 * @return the strStoreCatSlNo
	 */
	public String getStrStoreCatSlNo() {
		return strStoreCatSlNo;
	}

	/**
	 * Sets the str store cat sl no.
	 * 
	 * @param strStoreCatSlNo the strStoreCatSlNo to set
	 */
	public void setStrStoreCatSlNo(String strStoreCatSlNo) {
		this.strStoreCatSlNo = strStoreCatSlNo;
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
	 * Gets the str last mode seat id.
	 * 
	 * @return the strLastModeSeatId
	 */
	public String getStrLastModeSeatId() {
		return strLastModeSeatId;
	}

	/**
	 * Sets the str last mode seat id.
	 * 
	 * @param strLastModeSeatId the strLastModeSeatId to set
	 */
	public void setStrLastModeSeatId(String strLastModeSeatId) {
		this.strLastModeSeatId = strLastModeSeatId;
	}

	/**
	 * Gets the str last mode date.
	 * 
	 * @return the strLastModeDate
	 */
	public String getStrLastModeDate() {
		return strLastModeDate;
	}

	/**
	 * Sets the str last mode date.
	 * 
	 * @param strLastModeDate the strLastModeDate to set
	 */
	public void setStrLastModeDate(String strLastModeDate) {
		this.strLastModeDate = strLastModeDate;
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
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strStoreId or strHospitalCode or strItemCatNo is blank
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strStoreId.equals("0") || strStoreId.equals("")) {
				throw new Exception("strStoreId can not be blank");
			}
			if (strStoreItemCategory.equals("0") || strStoreItemCategory.equals("")) {
				throw new Exception("strStoreItemCategory can not be blank");
			}

			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1,
					"insert.storeCategoryMst.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strStoreId);
			dao.setQryValue(nQueryIndex, 2, strStoreItemCategory);
			dao.setQryValue(nQueryIndex, 3, strHospitalCode);

			dao.setQryValue(nQueryIndex, 4, strHospitalCode);
			dao.setQryValue(nQueryIndex, 5, strStoreId);
			dao.setQryValue(nQueryIndex, 6, strStoreItemCategory);

			dao.setQryValue(nQueryIndex, 7, strRemarks);
			dao.setQryValue(nQueryIndex, 8, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 9, strSeatId);
			dao.setQryValue(nQueryIndex, 10, strIsValid);
            /*Added by Amit Kumar after Change Request Receving*/
			dao.setQryValue(nQueryIndex, 11, strItemBounded);    
			dao.setQryValue(nQueryIndex, 12, strIsNewItemFlag);
			dao.setQryValue(nQueryIndex, 13, strStoreItemCategory);
			

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
	 * when strStoreId or strHospitalCode OR strItemCatNo or
	 * strReqTypeSlNo is blank
	 */
	public void update(HisDAO dao) throws Exception {
		strErr = "";

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strStoreId.equals("0") || strStoreId.equals("")) {
				throw new Exception("strStoreId can not be blank");
			}
			if (strItemCatNo.equals("0") || strItemCatNo.equals("")) {
				throw new Exception("strItemCatNo can not be blank");
			}
			if (strStoreCatSlNo.equals("0") || strStoreCatSlNo.equals("")) {
				throw new Exception("strStoreCatSlNo can not be blank");
			}

			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1,
					"update.storeCategoryMst.1");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 2, strRemarks);
			dao.setQryValue(nQueryIndex, 3, strIsValid);
			dao.setQryValue(nQueryIndex, 4, strSeatId);
			dao.setQryValue(nQueryIndex, 5, strItemBounded);    
			dao.setQryValue(nQueryIndex, 6, strIsNewItemFlag);
			dao.setQryValue(nQueryIndex, 7, strStoreId);
			dao.setQryValue(nQueryIndex, 8, strItemCatNo);
			dao.setQryValue(nQueryIndex, 9, strHospitalCode);
			dao.setQryValue(nQueryIndex, 10, strStoreCatSlNo);
			
			

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
	 * This method is used to reset the data.
	 */
	public void reset() {

		strHospitalCode = "";
		strStoreId = "";
		strStoreItemCategory = "";
		strStoreCatSlNo = "";
		strRemarks = "";
		strEffectiveFrom = "";
		strEffectiveTo = "";
		strLastModeSeatId = "";
		strLastModeDate = "";
		strEntryDate = "";
		strSeatId = "";
		strIsValid = "";

	}

	public void setStrStoreItemCategory(String strStoreItemCategory) {
		this.strStoreItemCategory = strStoreItemCategory;
	}

	public void setStrItemBounded(String strItemBounded) {
		this.strItemBounded = strItemBounded;
	}

	public void setStrIsNewItemFlag(String strIsNewItemFlag) {
		this.strIsNewItemFlag = strIsNewItemFlag;
	}

}
