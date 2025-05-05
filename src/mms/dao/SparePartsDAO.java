package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class SparePartsDAO.
 */
public class SparePartsDAO {
	// private final String strProcName = "";
	/** The str file name. */
	private final String strFileName = "mms.dao.SparePartsDAO";

	/** The str item id. */
	private String strItemId = "";
	
	/** The str spare part id. */
	private String strSparePartId = "";
	
	/** The str item cat no. */
	private String strItemCatNo = "";
	
	/** The str spare part cat no. */
	private String strSparePartCatNo = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str lst mod seat id. */
	private String strLstModSeatId = "";
	
	/** The str lst mod date. */
	private String strLstModDate = "";
	
	/** The str entry date. */
	private String strEntryDate = "";
	
	/** The str last modified date. */
	private String strLastModifiedDate = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str last modified seat id. */
	private String strLastModifiedSeatId = "";
	
	/** The str is valid. */
	private String strIsValid = "1";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str item sl no. */
	private String strItemSlNo = "";

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
	 * Gets the str effective from.
	 * 
	 * @return the str effective from
	 */
	public String getStrEffectiveFrom() {
		return strEffectiveFrom;
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
	 * Gets the str remarks.
	 * 
	 * @return the str remarks
	 */
	public String getStrRemarks() {
		return strRemarks;
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
	 * Gets the str lst mod seat id.
	 * 
	 * @return the str lst mod seat id
	 */
	public String getStrLstModSeatId() {
		return strLstModSeatId;
	}

	/**
	 * Sets the str lst mod seat id.
	 * 
	 * @param strLstModSeatId the new str lst mod seat id
	 */
	public void setStrLstModSeatId(String strLstModSeatId) {
		this.strLstModSeatId = strLstModSeatId;
	}

	/**
	 * Gets the str lst mod date.
	 * 
	 * @return the str lst mod date
	 */
	public String getStrLstModDate() {
		return strLstModDate;
	}

	/**
	 * Sets the str lst mod date.
	 * 
	 * @param strLstModDate the new str lst mod date
	 */
	public void setStrLstModDate(String strLstModDate) {
		this.strLstModDate = strLstModDate;
	}

	/**
	 * Gets the str entry date.
	 * 
	 * @return the str entry date
	 */
	public String getStrEntryDate() {
		return strEntryDate;
	}

	/**
	 * Sets the str entry date.
	 * 
	 * @param strEntryDate the new str entry date
	 */
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}

	/**
	 * Gets the str last modified date.
	 * 
	 * @return the str last modified date
	 */
	public String getStrLastModifiedDate() {
		return strLastModifiedDate;
	}

	/**
	 * Sets the str last modified date.
	 * 
	 * @param strLastModifiedDate the new str last modified date
	 */
	public void setStrLastModifiedDate(String strLastModifiedDate) {
		this.strLastModifiedDate = strLastModifiedDate;
	}

	/**
	 * Gets the str seat id.
	 * 
	 * @return the str seat id
	 */
	public String getStrSeatId() {
		return strSeatId;
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
	 * Gets the str last modified seat id.
	 * 
	 * @return the str last modified seat id
	 */
	public String getStrLastModifiedSeatId() {
		return strLastModifiedSeatId;
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
	 * Gets the str is valid.
	 * 
	 * @return the str is valid
	 */
	public String getStrIsValid() {
		return strIsValid;
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
	 * Gets the str hospital code.
	 * 
	 * @return the str hospital code
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
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

	/**
	 * Gets the n row inserted.
	 * 
	 * @return the n row inserted
	 */
	public int getNRowInserted() {
		return nRowInserted;
	}

	/**
	 * Sets the n row inserted.
	 * 
	 * @param rowInserted the new n row inserted
	 */
	public void setNRowInserted(int rowInserted) {
		nRowInserted = rowInserted;
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
	 * Sets the n row updated.
	 * 
	 * @param rowUpdated the new n row updated
	 */
	public void setNRowUpdated(int rowUpdated) {
		nRowUpdated = rowUpdated;
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
	 * Sets the n row deleted.
	 * 
	 * @param rowDeleted the new n row deleted
	 */
	public void setNRowDeleted(int rowDeleted) {
		nRowDeleted = rowDeleted;
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
	 * Sets the n inserted index.
	 * 
	 * @param insertedIndex the new n inserted index
	 */
	public void setNInsertedIndex(int insertedIndex) {
		nInsertedIndex = insertedIndex;
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
	 * Sets the n updated index.
	 * 
	 * @param updatedIndex the new n updated index
	 */
	public void setNUpdatedIndex(int updatedIndex) {
		nUpdatedIndex = updatedIndex;
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
	 * Sets the n deleted index.
	 * 
	 * @param deletedIndex the new n deleted index
	 */
	public void setNDeletedIndex(int deletedIndex) {
		nDeletedIndex = deletedIndex;
	}

	/**
	 * Gets the str file name.
	 * 
	 * @return the str file name
	 */
	public String getStrFileName() {
		return strFileName;
	}

	/**
	 * Gets the str item cat no.
	 * 
	 * @return the str item cat no
	 */
	public String getStrItemCatNo() {
		return strItemCatNo;
	}

	/**
	 * Sets the str item cat no.
	 * 
	 * @param strItemCatNo the new str item cat no
	 */
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}

	/**
	 * Gets the str item id.
	 * 
	 * @return the str item id
	 */
	public String getStrItemId() {
		return strItemId;
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
	 * Gets the str spare part id.
	 * 
	 * @return the str spare part id
	 */
	public String getStrSparePartId() {
		return strSparePartId;
	}

	/**
	 * Sets the str spare part id.
	 * 
	 * @param strSparePartId the new str spare part id
	 */
	public void setStrSparePartId(String strSparePartId) {
		this.strSparePartId = strSparePartId;
	}

	/**
	 * Gets the str spare part cat no.
	 * 
	 * @return the str spare part cat no
	 */
	public String getStrSparePartCatNo() {
		return strSparePartCatNo;
	}

	/**
	 * Sets the str spare part cat no.
	 * 
	 * @param strSparePartCatNo the new str spare part cat no
	 */
	public void setStrSparePartCatNo(String strSparePartCatNo) {
		this.strSparePartCatNo = strSparePartCatNo;
	}

	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when BillNo. or Receipt No. or Serial No. is blank
	 */
	public void insert(HisDAO dao) throws Exception {
		strErr = "";
	//	String temp[] = null;
	//	String temp1[] = null;

		try {
			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1,"select.sparePartMst.insert.0");

			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strHospitalCode);
			dao.setQryValue(nQueryIndex, 2, strItemId);
			dao.setQryValue(nQueryIndex, 3, strSparePartId);
			dao.setQryValue(nQueryIndex, 4, strItemId);
			dao.setQryValue(nQueryIndex, 5, strSparePartId);
			dao.setQryValue(nQueryIndex, 6, strHospitalCode);
			dao.setQryValue(nQueryIndex, 7, strItemCatNo);
			dao.setQryValue(nQueryIndex, 8, strRemarks);
			dao.setQryValue(nQueryIndex, 9, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 10, strSeatId);
			dao.setQryValue(nQueryIndex, 11, strIsValid);
			dao.setQryValue(nQueryIndex, 12, strSparePartCatNo);
			dao.execute(nQueryIndex, 0);

			this.nRowInserted++;

		} catch (Exception e) {

			this.strErr = e.getMessage();

			throw new Exception(strFileName + ".insert() --> " + this.strErr);

		} finally {

			this.reset();

		}
	}

	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when BillNo. or Receipt No. or Serial No. is blank
	 */
	public void update(HisDAO dao) throws Exception {
		strErr = "";

		try {
			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1,"update.sparePartMst.update.1");

			nQueryIndex = dao.setQuery(strQuery);
			
			dao.setQryValue(nQueryIndex, 1, strLastModifiedSeatId);
			dao.setQryValue(nQueryIndex, 2, strItemId);
			dao.setQryValue(nQueryIndex, 3, strSparePartId);
			dao.setQryValue(nQueryIndex, 4, strHospitalCode);
			dao.setQryValue(nQueryIndex, 5, strItemSlNo);

			dao.execute(nQueryIndex, 0);
			
			
			strQuery = mms.qryHandler_mms.getQuery(1,"insert.sparePartMst.new.record");

			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strHospitalCode);
			dao.setQryValue(nQueryIndex, 2, strItemId);
			dao.setQryValue(nQueryIndex, 3, strSparePartId);
			dao.setQryValue(nQueryIndex, 4, strItemId);
			dao.setQryValue(nQueryIndex, 5, strSparePartId);
			dao.setQryValue(nQueryIndex, 6, strHospitalCode);
			dao.setQryValue(nQueryIndex, 7, strItemCatNo);
			dao.setQryValue(nQueryIndex, 8, strRemarks);
			dao.setQryValue(nQueryIndex, 9, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 10, strLastModifiedSeatId);
			dao.setQryValue(nQueryIndex, 11, strIsValid);
			dao.setQryValue(nQueryIndex, 12, strSparePartCatNo);
			dao.execute(nQueryIndex, 0);

			this.nRowInserted++;

		} catch (Exception e) {
			this.strErr = e.getMessage();

			throw new Exception(strFileName
					+ ".update3(HSTT_COMMITTEE_DTL) --> " + this.strErr);

		} finally {

			this.reset();

		}
	}

	/**
	 * Reset.
	 */
	public void reset() {
		strItemId = "";
		strSparePartId = "";
		strItemCatNo = "";
		strSparePartCatNo = "";
		strEffectiveFrom = "";
		strRemarks = "";
		strLstModSeatId = "";
		strLstModDate = "";
		strEntryDate = "";
		strLastModifiedDate = "";
		strSeatId = "";
		strLastModifiedSeatId = "";
		strIsValid = "1";
		strHospitalCode = "";
		strItemSlNo = "";

	}

	/**
	 * Sets the str item sl no.
	 * 
	 * @param strItemSlNo the new str item sl no
	 */
	public void setStrItemSlNo(String strItemSlNo) {
		this.strItemSlNo = strItemSlNo;
	}

}
