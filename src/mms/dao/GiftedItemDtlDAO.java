package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Tanvi Sappal Version : 1.0 Date : 03/Feb/2009
 * 
 * This class will be used to insert the records into the Table :
 * HSTT_GIFTEDITEM_DTL
 */
public class GiftedItemDtlDAO {

	/** The str file name. */
	private final String strFileName = "mms.dao.GiftedItemDtlDAO";

	/** The str store id. */
	private String strStoreId = "";
	
	/** The str item id. */
	private String strItemId = "";
	
	/** The str brand id. */
	private String strBrandId = "";
	
	/** The str batch no. */
	private String strBatchNo = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str stock status. */
	private String strStockStatus = "0";
	
	/** The str item cat code. */
	private String strItemCatCode = "";
	
	/** The str group id. */
	private String strGroupId = "";
	
	/** The str sub group id. */
	private String strSubGroupId = "";
	
	/** The str manufacturer id. */
	private String strManufacturerId = "";
	
	/** The str gifted by. */
	private String strGiftedBy = "";
	
	/** The str gifted by address. */
	private String strGiftedByAddress = "";
	
	/** The str gift quantity. */
	private String strGiftQuantity = "";
	
	/** The str gift quantity unit id. */
	private String strGiftQuantityUnitId = "";
	
	/** The str manufacturer date. */
	private String strManufacturerDate = "";
	
	/** The str expiry date. */
	private String strExpiryDate = "";
	
	/** The str rate. */
	private String strRate = "";
	
	/** The str rate unit id. */
	private String strRateUnitId = "";
	
	
	/** The str currency id. */
	private String strCurrencyID = "";
	
	/** The str currency value. */
	private String strCurrencyValue = "1";
	
	/** The str is tax certified. */
	private String strIsTaxCertified = "0";
	
	/** The str financial start year. */
	private String strFinancialStartYear = "";
	
	/** The str financial end year. */
	private String strFinancialEndYear = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str seat id. */
	private String strSeatId = "";

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

	private String receivedBy;
	
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
	 * Sets the str gift quantity.
	 * 
	 * @param strGiftQuantity the new str gift quantity
	 */
	public void setStrGiftQuantity(String strGiftQuantity) {
		this.strGiftQuantity = strGiftQuantity;
	}

	/**
	 * Sets the str gift quantity unit id.
	 * 
	 * @param strGiftQuantityUnitId the new str gift quantity unit id
	 */
	public void setStrGiftQuantityUnitId(String strGiftQuantityUnitId) {
		this.strGiftQuantityUnitId = strGiftQuantityUnitId;
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
	public void insert(HisDAO dao) throws Exception 
	{
		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		try 
		{
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) 
			{
				throw new Exception("strHospitalCode can not be blank");
			}

			strProcName = "{call pkg_mms_dml.dml_gifted_item_dtls (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //27+3=30
			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "modval", "1",1);
			dao.setProcInValue(nProcIndex, "store_id", strStoreId,2);
			dao.setProcInValue(nProcIndex, "item_id", strItemId,3);
			dao.setProcInValue(nProcIndex, "itembrand_id", strBrandId,4);
			dao.setProcInValue(nProcIndex, "batchsl_no", strBatchNo,5);
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,6);
			dao.setProcInValue(nProcIndex, "stock_status", strStockStatus,7);
			dao.setProcInValue(nProcIndex, "item_cat_code", strItemCatCode,8);
			dao.setProcInValue(nProcIndex, "group_id", strGroupId,9);
			dao.setProcInValue(nProcIndex, "subgroup_id", strSubGroupId,10);
			dao.setProcInValue(nProcIndex, "manufacturer_id",strManufacturerId,11);
			dao.setProcInValue(nProcIndex, "gifted_date", "0",12);
			dao.setProcInValue(nProcIndex, "gifted_by", strGiftedBy,13);
			dao.setProcInValue(nProcIndex, "gifted_by_address",strGiftedByAddress,14);
			dao.setProcInValue(nProcIndex, "qty", strGiftQuantity,15);
			dao.setProcInValue(nProcIndex, "qty_unitid", strGiftQuantityUnitId,16);
			dao.setProcInValue(nProcIndex, "manufacturer_date",strManufacturerDate,17);
			dao.setProcInValue(nProcIndex, "expiry_date", strExpiryDate,18);
			dao.setProcInValue(nProcIndex, "rate", strRate,19);
			dao.setProcInValue(nProcIndex, "rate_unitid", strRateUnitId,20);
			dao.setProcInValue(nProcIndex, "item_make", "1",21);
			dao.setProcInValue(nProcIndex, "consumable_flag", "1",22);
			dao.setProcInValue(nProcIndex, "currency_id", strCurrencyID,23);
			dao.setProcInValue(nProcIndex, "currency_value", strCurrencyValue,24);
			dao.setProcInValue(nProcIndex, "is_tax_certified",strIsTaxCertified,25);
			dao.setProcInValue(nProcIndex, "fin_str_date",strFinancialStartYear,26);
			dao.setProcInValue(nProcIndex, "fin_end_date", strFinancialEndYear,27);
			dao.setProcInValue(nProcIndex, "seat_id", strSeatId,28);
			dao.setProcInValue(nProcIndex, "remarks", strRemarks,29);
			dao.setProcInValue(nProcIndex, "receivedBy", receivedBy,30);
			
			dao.setProcOutValue(nProcIndex, "err", 1,31);			
			
			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} 
		catch (Exception e) 
		{
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} 
		finally 
		{
			this.reset(); // to reset the variables
		}
	}

	/**
	 * Reset.
	 */
	public void reset() {

		strStoreId = "";
		strItemId = "";
		strBrandId = "";
		strBatchNo = "";
		strHospitalCode = "";
		strStockStatus = "0";
		strItemCatCode = "";
		strGroupId = "";
		strSubGroupId = "";
		strManufacturerId = "";
		strGiftedBy = "";
		strGiftedByAddress = "";
		strGiftQuantity = "";
		strGiftQuantityUnitId = "";
		strManufacturerDate = "";
		strExpiryDate = "";
		strRate = "";
		strRateUnitId = "";
		strCurrencyID = "";
		strCurrencyValue = "1";
		strIsTaxCertified = "0";
		strFinancialStartYear = "";
		strFinancialEndYear = "";
		strRemarks = "";
		strSeatId = "";

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
	 * Sets the str stock status.
	 * 
	 * @param strStockStatus the new str stock status
	 */
	public void setStrStockStatus(String strStockStatus) {
		this.strStockStatus = strStockStatus;
	}

	/**
	 * Sets the str item cat code.
	 * 
	 * @param strItemCatCode the new str item cat code
	 */
	public void setStrItemCatCode(String strItemCatCode) {
		this.strItemCatCode = strItemCatCode;
	}

	/**
	 * Sets the str gifted by.
	 * 
	 * @param strGiftedBy the new str gifted by
	 */
	public void setStrGiftedBy(String strGiftedBy) {
		this.strGiftedBy = strGiftedBy;
	}

	/**
	 * Sets the str gifted by address.
	 * 
	 * @param strGiftedByAddress the new str gifted by address
	 */
	public void setStrGiftedByAddress(String strGiftedByAddress) {
		this.strGiftedByAddress = strGiftedByAddress;
	}

	/**
	 * Sets the str currency id.
	 * 
	 * @param strCurrencyID the new str currency id
	 */
	public void setStrCurrencyID(String strCurrencyID) {
		this.strCurrencyID = strCurrencyID;
	}

	/**
	 * Sets the str currency value.
	 * 
	 * @param strCurrencyValue the new str currency value
	 */
	public void setStrCurrencyValue(String strCurrencyValue) {
		this.strCurrencyValue = strCurrencyValue;
	}

	/**
	 * Sets the str is tax certified.
	 * 
	 * @param strIsTaxCertified the new str is tax certified
	 */
	public void setStrIsTaxCertified(String strIsTaxCertified) {
		this.strIsTaxCertified = strIsTaxCertified;
	}

	/**
	 * Sets the str financial start year.
	 * 
	 * @param strFinancialStartYear the new str financial start year
	 */
	public void setStrFinancialStartYear(String strFinancialStartYear) {
		this.strFinancialStartYear = strFinancialStartYear;
	}

	/**
	 * Sets the str financial end year.
	 * 
	 * @param strFinancialEndYear the new str financial end year
	 */
	public void setStrFinancialEndYear(String strFinancialEndYear) {
		this.strFinancialEndYear = strFinancialEndYear;
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

	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	

}
