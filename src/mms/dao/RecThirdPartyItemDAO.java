package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Tanvi Sappal Version : 1.0 Date : 04/Feb/2009
 * 
 * This class will be used to insert the records into the Table :
 * HSTT_THIRDPARTY_REC_ITEM_DTL
 */

public class RecThirdPartyItemDAO {
	
	/** The str proc name. */
	//private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.RecThirdPartyItemDAO";

	/** The str third party rec no. */
	private String strThirdPartyRecNo = "";
	
	/** The str item id. */
	private String strItemId = "";
	
	/** The str brand id. */
	private String strBrandId = "";
	
	/** The str batch no. */
	private String strBatchNo = "";
	
	/** The str serial no. */
	private String strSerialNo = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str group id. */
	private String strGroupId = "";
	
	/** The str sub group id. */
	private String strSubGroupId = "";
	
	/** The str manufacturer id. */
	private String strManufacturerId = "";
	
	/** The str received quantity. */
	private String strReceivedQuantity = "";
	
	/** The str rec quantity unit id. */
	private String strRecQuantityUnitId = "";
	
	/** The str manufacturer date. */
	private String strManufacturerDate = "";
	
	/** The str expiry date. */
	private String strExpiryDate = "";
	
	/** The str rate. */
	private String strRate = "";
	
	/** The str rate unit id. */
	private String strRateUnitId = "";
	
	/** The str item make. */
	//private String strItemMake = "";
	
	/** The str consumable flag. */
	private String strConsumableFlag = "";
	
	/** The str is parameter. */
//	private String strIsParameter = "0";
	
	/** The str remarks. */
//	private String strRemarks = "";
	
	/** The str is valid. */
	//private String strIsValid = "";

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
	 * Sets the str item id.
	 * 
	 * @param strItemId the new str item id
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}

	/**
	 * Sets the str brand id.
	 * 
	 * @param strBrandId the new str brand id
	 */
	public void setStrBrandId(String strBrandId) {
		this.strBrandId = strBrandId;
	}

	/**
	 * Sets the str batch no.
	 * 
	 * @param strBatchNo the new str batch no
	 */
	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}

	/**
	 * Sets the str serial no.
	 * 
	 * @param strSerialNo the new str serial no
	 */
	public void setStrSerialNo(String strSerialNo) {
		this.strSerialNo = strSerialNo;
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
	 * Sets the str group id.
	 * 
	 * @param strGroupId the new str group id
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	/**
	 * Sets the str sub group id.
	 * 
	 * @param strSubGroupId the new str sub group id
	 */
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}

	/**
	 * Sets the str manufacturer id.
	 * 
	 * @param strManufacturerId the new str manufacturer id
	 */
	public void setStrManufacturerId(String strManufacturerId) {
		this.strManufacturerId = strManufacturerId;
	}

	/**
	 * Sets the str received quantity.
	 * 
	 * @param strReceivedQuantity the new str received quantity
	 */
	public void setStrReceivedQuantity(String strReceivedQuantity) {
		this.strReceivedQuantity = strReceivedQuantity;
	}

	/**
	 * Sets the str rec quantity unit id.
	 * 
	 * @param strRecQuantityUnitId the new str rec quantity unit id
	 */
	public void setStrRecQuantityUnitId(String strRecQuantityUnitId) {
		this.strRecQuantityUnitId = strRecQuantityUnitId;
	}

	/**
	 * Sets the str manufacturer date.
	 * 
	 * @param strManufacturerDate the new str manufacturer date
	 */
	public void setStrManufacturerDate(String strManufacturerDate) {
		this.strManufacturerDate = strManufacturerDate;
	}

	/**
	 * Sets the str expiry date.
	 * 
	 * @param strExpiryDate the new str expiry date
	 */
	public void setStrExpiryDate(String strExpiryDate) {
		this.strExpiryDate = strExpiryDate;
	}

	/**
	 * Sets the str rate.
	 * 
	 * @param strRate the new str rate
	 */
	public void setStrRate(String strRate) {
		this.strRate = strRate;
	}

	/**
	 * Sets the str rate unit id.
	 * 
	 * @param strRateUnitId the new str rate unit id
	 */
	public void setStrRateUnitId(String strRateUnitId) {
		this.strRateUnitId = strRateUnitId;
	}

	 

	/**
	 * Sets the str consumable flag.
	 * 
	 * @param strConsumableFlag the new str consumable flag
	 */
	public void setStrConsumableFlag(String strConsumableFlag) {
		this.strConsumableFlag = strConsumableFlag;
	}

	 

	 

	/**
	 * Sets the str third party rec no.
	 * 
	 * @param strThirdPartyRecNo the new str third party rec no
	 */
	public void setStrThirdPartyRecNo(String strThirdPartyRecNo) {
		this.strThirdPartyRecNo = strThirdPartyRecNo;
	}

	// Methods starts from here

	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strHospitalCode is blank
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

			strProcName = "{call dml_third_party_rec_item_proc(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "modval", "1");
			dao.setProcInValue(nProcIndex, "trec_no", strThirdPartyRecNo);
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode);
			dao.setProcInValue(nProcIndex, "group_id", strGroupId);
			dao.setProcInValue(nProcIndex, "subgroup_id", strSubGroupId);
			dao.setProcInValue(nProcIndex, "item_id", strItemId);
			dao.setProcInValue(nProcIndex, "itembrand_id", strBrandId);
			dao
					.setProcInValue(nProcIndex, "manufacturer_id",
							strManufacturerId);
			dao.setProcInValue(nProcIndex, "batch_slno", strBatchNo);
			dao.setProcInValue(nProcIndex, "item_slno", strSerialNo);
			dao.setProcInValue(nProcIndex, "rate", strRate);
			dao.setProcInValue(nProcIndex, "rate_unitid", strRateUnitId);
			dao.setProcInValue(nProcIndex, "manufacturer_date",
					strManufacturerDate);
			dao.setProcInValue(nProcIndex, "expiry_date", strExpiryDate);
			dao
					.setProcInValue(nProcIndex, "consumable_flag",
							strConsumableFlag);
			dao.setProcInValue(nProcIndex, "rec_qty", strReceivedQuantity);
			dao.setProcInValue(nProcIndex, "rec_qty_unitid",
					strRecQuantityUnitId);
			dao.setProcOutValue(nProcIndex, "err", 1);

			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

	}

	/**
	 * Reset.
	 */
	public void reset() {

		strThirdPartyRecNo = "";
		strItemId = "";
		strBrandId = "";
		strBatchNo = "";
		strSerialNo = "";
		strHospitalCode = "";
		strGroupId = "";
		strSubGroupId = "";
		strManufacturerId = "";
		strReceivedQuantity = "";
		strRecQuantityUnitId = "";
		strManufacturerDate = "";
		strExpiryDate = "";
		strRate = "";
		strRateUnitId = "";
	//	strItemMake = "";
		strConsumableFlag = "";
	//	strIsParameter = "0";
	//	strRemarks = "";
	//	strIsValid = "";

	}

}
