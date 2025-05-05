/**
 * 
 */
package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Tanvi Sappal Version : 1.0 Date : 13/April/2009
 * 
 * This class will be used to insert the records into the Table :
 * HSTT_INSPECTION_DTL
 */
public class InspectionDtlDAO {
	
	/** The str proc name. */
	private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.InspectionDtlDAO";

	/** The str store id. */
	private String strStoreId = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str request no. */
	private String strRequestNo = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str fin end date. */
	private String strFinEndDate = "";
	
	/** The str fin start date. */
	private String strFinStartDate = "";
	
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
	 * Gets the str proc name.
	 * 
	 * @return the strProcName
	 */
	public String getStrProcName() {
		return strProcName;
	}

	/**
	 * Gets the str file name.
	 * 
	 * @return the strFileName
	 */
	public String getStrFileName() {
		return strFileName;
	}

	// Methods starts from here

	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strHospitalCode or strGiftedNo is blank
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		try {

			// check mandatory information
			/*
			 * if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
			 * throw new Exception("strHospitalCode can not be blank"); } if
			 * (strRequestNo.equals("0") || strRequestNo.equals("")) { throw new
			 * Exception("strRequestNo can not be blank"); } if
			 * (strStoreId.equals("0") || strStoreId.equals("")) { throw new
			 * Exception("strStoreId can not be blank"); }
			 */

			strProcName = "{call dml_inspection_dtls(?,?,?,?,?,?,?,?,?,?)}";  //10
			nProcIndex = dao.setProcedure(strProcName);

			/*
			 * //System.out.println("strStoreId in Dao-->"+strStoreId);
			 * //System.out.println("strRequestNo in Dao-->"+strRequestNo);
			 * //System.out.println("strHospitalCode in Dao-->"+strHospitalCode);
			 * //System.out.println("strSeatId in Dao-->"+strSeatId);
			 * //System.out.println("strFinStartDate in Dao-->"+strFinStartDate);
			 * //System.out.println("strFinEndDate in dao-->"+strFinEndDate);
			 * //System.out.println("strRemarks in Dao-->"+strRemarks);
			 */
			/*
			 * modval VARCHAR2 DEFAULT 1, storeid VARCHAR2 DEFAULT NULL,
			 * hospcode VARCHAR2 DEFAULT NULL, req_no VARCHAR2 DEFAULT NULL,
			 * fin_start_yr VARCHAR2 DEFAULT NULL, fin_end_yr VARCHAR2 DEFAULT
			 * NULL, remarks VARCHAR2 DEFAULT NULL, is_valid VARCHAR2 DEFAULT
			 * '1', err
			 */

			dao.setProcInValue(nProcIndex, "modval", "1");
			dao.setProcInValue(nProcIndex, "storeid", strStoreId.trim());
			dao.setProcInValue(nProcIndex, "hospcode", strHospitalCode.trim());
			dao.setProcInValue(nProcIndex, "req_no", strRequestNo.trim());
			dao.setProcInValue(nProcIndex, "seatid", strSeatId.trim());
			dao.setProcInValue(nProcIndex, "fin_start_yr", strFinStartDate
					.trim());
			dao.setProcInValue(nProcIndex, "fin_end_yr", strFinEndDate.trim());
			dao.setProcInValue(nProcIndex, "remarks", strRemarks.trim());
			dao.setProcInValue(nProcIndex, "is_valid", strIsValid.trim());
			dao.setProcOutValue(nProcIndex, "err", 1);

			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} catch (Exception e) {
			e.printStackTrace();
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			// this.reset(); // to reset the variables
		}

	}

	/**
	 * Reset.
	 */
	public void reset() {

		strHospitalCode = "";
		strRequestNo = "";
		strStoreId = "";
		strRemarks = "";
		strFinStartDate = "";
		strFinEndDate = "";
		strIsValid = "";
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
	 * Gets the str request no.
	 * 
	 * @return the strRequestNo
	 */
	public String getStrRequestNo() {
		return strRequestNo;
	}

	/**
	 * Sets the str request no.
	 * 
	 * @param strRequestNo the strRequestNo to set
	 */
	public void setStrRequestNo(String strRequestNo) {
		this.strRequestNo = strRequestNo;
	}

	/**
	 * Gets the str fin end date.
	 * 
	 * @return the strFinEndDate
	 */
	public String getStrFinEndDate() {
		return strFinEndDate;
	}

	/**
	 * Sets the str fin end date.
	 * 
	 * @param strFinEndDate the strFinEndDate to set
	 */
	public void setStrFinEndDate(String strFinEndDate) {
		this.strFinEndDate = strFinEndDate;
	}

	/**
	 * Gets the str fin start date.
	 * 
	 * @return the strFinStartDate
	 */
	public String getStrFinStartDate() {
		return strFinStartDate;
	}

	/**
	 * Sets the str fin start date.
	 * 
	 * @param strFinStartDate the strFinStartDate to set
	 */
	public void setStrFinStartDate(String strFinStartDate) {
		this.strFinStartDate = strFinStartDate;
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

}
