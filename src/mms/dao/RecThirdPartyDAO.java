package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Tanvi Sappal Version : 1.0 Date : 04/Feb/2009
 * 
 * This class will be used to insert the records into the Table :
 * HSTT_THIRDPARTY_RECEIVE_DTL
 */

public class RecThirdPartyDAO {

	/** The str proc name. */
//	private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.RecThirdPartyDAO";

	/** The str third party rec no. */
	private String strThirdPartyRecNo = "";
	
	/** The str store id. */
	private String strStoreId = "";
	
	/** The str item category id. */
	private String strItemCategoryId = "";
	
	/** The str received date. */
//	private String strReceivedDate = "";
	
	/** The str third party id. */
	private String strThirdPartyId = "";
	
	/** The str fin end date. */
	private String strFinEndDate = "";
	
	/** The str fin start date. */
	private String strFinStartDate = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str is valid. */
//	private String strIsValid = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str entry date. */
//	private String strEntryDate = "";

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
	 * Sets the str third party rec no.
	 * 
	 * @param strThirdPartyRecNo the new str third party rec no
	 */
	public void setStrThirdPartyRecNo(String strThirdPartyRecNo) {
		this.strThirdPartyRecNo = strThirdPartyRecNo;
	}

	/**
	 * Sets the str store id.
	 * 
	 * @param strStoreId the new str store id
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	/**
	 * Sets the str item category id.
	 * 
	 * @param strItemCategoryId the new str item category id
	 */
	public void setStrItemCategoryId(String strItemCategoryId) {
		this.strItemCategoryId = strItemCategoryId;
	}

 

	/**
	 * Sets the str third party id.
	 * 
	 * @param strThirdPartyId the new str third party id
	 */
	public void setStrThirdPartyId(String strThirdPartyId) {
		this.strThirdPartyId = strThirdPartyId;
	}

	/**
	 * Sets the str fin end date.
	 * 
	 * @param strFinEndDate the new str fin end date
	 */
	public void setStrFinEndDate(String strFinEndDate) {
		this.strFinEndDate = strFinEndDate;
	}

	/**
	 * Sets the str fin start date.
	 * 
	 * @param strFinStartDate the new str fin start date
	 */
	public void setStrFinStartDate(String strFinStartDate) {
		this.strFinStartDate = strFinStartDate;
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
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode the new str hospital code
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
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
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strThirdPartyRecNo.equals("0") || strThirdPartyRecNo.equals("")) {
				throw new Exception("strGiftedNo can not be blank");
			}

			strProcName = "{call dml_third_party_receive_proc(?,?,?,?,?,?,?,?,?,?,?)}";
			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "modval", "1");
			dao.setProcInValue(nProcIndex, "trec_no", strThirdPartyRecNo);
			dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode);
			dao.setProcInValue(nProcIndex, "itemcat_no", strItemCategoryId);
			dao.setProcInValue(nProcIndex, "store_id", strStoreId);
			dao.setProcInValue(nProcIndex, "institute_code", strThirdPartyId);
			dao.setProcInValue(nProcIndex, "fin_start_yr", strFinStartDate);
			dao.setProcInValue(nProcIndex, "fin_end_yr", strFinEndDate);
			dao.setProcInValue(nProcIndex, "remarks", strRemarks);
			dao.setProcInValue(nProcIndex, "seat_id", strSeatId);
			// dao.setProcInValue(nProcIndex, "is_valid", strIsValid);
			dao.setProcOutValue(nProcIndex, "err", 1);

			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} catch (Exception e) {

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

		strThirdPartyRecNo = "";
		strHospitalCode = "";
		strStoreId = "";
		strItemCategoryId = "";
		strThirdPartyId = "";
		strFinEndDate = "";
		strFinStartDate = "";
		strRemarks = "";
	//	strIsValid = "";
		strSeatId = "";
	//	strEntryDate = "";
	}

}
