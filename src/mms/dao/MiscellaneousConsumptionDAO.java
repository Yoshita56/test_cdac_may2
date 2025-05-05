package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Pramod Kumar Mehta
 * Version : 1.0
 * Date : 22/April/2009
 * Module:MMS
 * Unit:Misscellaneous Consumptions
 */
/**
 * Developer : Tanvi Sappal Version : 1.0 Date : 01/June/2009 Module:MMS
 * Unit:Misscellaneous Consumptions
 * 
 */
public class MiscellaneousConsumptionDAO {
	
	/** The str file name. */
	private final String strFileName = "mms.dao.MiscellaneousConsumptionDAO";

	/** The str store val id. */
	private String strStoreValId = "";
	
	/** The str consumption no. */
	private String strConsumptionNo = "";
	
	/** The str item id. */
	private String strItemId = "";
	
	/** The str item brand id. */
	private String strItemBrandId = "";
	
	/** The str batch sl no. */
	private String strBatchSlNo = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str stock status code. */
	private String strStockStatusCode = "";
	
	/** The str consumption date. */
	private String strConsumptionDate = "";
	
	/** The str item category id. */
	private String strItemCategoryId = "";
	
	/** The str consumption qty. */
	private String strConsumptionQty = "";
	
	/** The str consumption qty unit id. */
	private String strConsumptionQtyUnitId = "";
	
	/** The str inhand qty. */
	private String strInhandQty = "";
	
	/** The str inhand qty unit id. */
	private String strInhandQtyUnitId = "";
	
	/** The str expiry date. */
	private String strExpiryDate = "";
	
	/** The str financial start date. */
	private String strFinancialStartDate = "";
	
	/** The str financial end date. */
	private String strFinancialEndDate = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str entry date. */
	private String strEntryDate = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str is valid. */
	private String strIsValid = "";
	
	/** The str reserved flag. */
	private String strReservedFlag = "";

	/** The n row inserted. */
	private int nRowInserted = 0;
	
	/** The n row updated. */
	private int nRowUpdated = 0;
	
	/** The n row deleted. */
	private int nRowDeleted = 0;

	/** The str err. */
	private String strErr = "";

	/** The n inserted index. */
	private int nInsertedIndex = 0;
	
	/** The n updated index. */
	private int nUpdatedIndex = 0;
	
	/** The n deleted index. */
	private int nDeletedIndex = 0;
	private String strMRP=null;
	private String strPur=null;

	public String getStrPur() {
		return strPur;
	}

	public void setStrPur(String strPur) {
		this.strPur = strPur;
	}

	public String getStrMRP() {
		return strMRP;
	}

	public void setStrMRP(String strMRP) {
		this.strMRP = strMRP;
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
	 * Gets the str consumption date.
	 * 
	 * @return the str consumption date
	 */
	public String getStrConsumptionDate() {
		return strConsumptionDate;
	}

	/**
	 * Sets the str consumption date.
	 * 
	 * @param strConsumptionDate the new str consumption date
	 */
	public void setStrConsumptionDate(String strConsumptionDate) {
		this.strConsumptionDate = strConsumptionDate;
	}

	/**
	 * Gets the str item category id.
	 * 
	 * @return the str item category id
	 */
	public String getStrItemCategoryId() {
		return strItemCategoryId;
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
	 * Gets the str store val id.
	 * 
	 * @return the str store val id
	 */
	public String getStrStoreValId() {
		return strStoreValId;
	}

	/**
	 * Sets the str store val id.
	 * 
	 * @param strStoreValId the new str store val id
	 */
	public void setStrStoreValId(String strStoreValId) {
		this.strStoreValId = strStoreValId;
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
	 * Gets the str financial start date.
	 * 
	 * @return the str financial start date
	 */
	public String getStrFinancialStartDate() {
		return strFinancialStartDate;
	}

	/**
	 * Sets the str financial start date.
	 * 
	 * @param strFinancialStartDate the new str financial start date
	 */
	public void setStrFinancialStartDate(String strFinancialStartDate) {
		this.strFinancialStartDate = strFinancialStartDate;
	}

	/**
	 * Gets the str financial end date.
	 * 
	 * @return the str financial end date
	 */
	public String getStrFinancialEndDate() {
		return strFinancialEndDate;
	}

	/**
	 * Sets the str financial end date.
	 * 
	 * @param strFinancialEndDate the new str financial end date
	 */
	public void setStrFinancialEndDate(String strFinancialEndDate) {
		this.strFinancialEndDate = strFinancialEndDate;
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
	 * Gets the str consumption no.
	 * 
	 * @return the str consumption no
	 */
	public String getStrConsumptionNo() {
		return strConsumptionNo;
	}

	/**
	 * Sets the str consumption no.
	 * 
	 * @param strConsumptionNo the new str consumption no
	 */
	public void setStrConsumptionNo(String strConsumptionNo) {
		this.strConsumptionNo = strConsumptionNo;
	}

	/**
	 * Gets the str expiry date.
	 * 
	 * @return the str expiry date
	 */
	public String getStrExpiryDate() {
		return strExpiryDate;
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
	 * Gets the str item brand id.
	 * 
	 * @return the str item brand id
	 */
	public String getStrItemBrandId() {
		return strItemBrandId;
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
	 * Gets the str batch sl no.
	 * 
	 * @return the str batch sl no
	 */
	public String getStrBatchSlNo() {
		return strBatchSlNo;
	}

	/**
	 * Sets the str batch sl no.
	 * 
	 * @param strBatchSlNo the new str batch sl no
	 */
	public void setStrBatchSlNo(String strBatchSlNo) {
		this.strBatchSlNo = strBatchSlNo;
	}

	/**
	 * Gets the str consumption qty.
	 * 
	 * @return the str consumption qty
	 */
	public String getStrConsumptionQty() {
		return strConsumptionQty;
	}

	/**
	 * Sets the str consumption qty.
	 * 
	 * @param strConsumptionQty the new str consumption qty
	 */
	public void setStrConsumptionQty(String strConsumptionQty) {
		this.strConsumptionQty = strConsumptionQty;
	}

	/**
	 * Gets the str inhand qty.
	 * 
	 * @return the str inhand qty
	 */
	public String getStrInhandQty() {
		return strInhandQty;
	}

	/**
	 * Sets the str inhand qty.
	 * 
	 * @param strInhandQty the new str inhand qty
	 */
	public void setStrInhandQty(String strInhandQty) {
		this.strInhandQty = strInhandQty;
	}

	/**
	 * Gets the str inhand qty unit id.
	 * 
	 * @return the str inhand qty unit id
	 */
	public String getStrInhandQtyUnitId() {
		return strInhandQtyUnitId;
	}

	/**
	 * Sets the str inhand qty unit id.
	 * 
	 * @param strInhandQtyUnitId the new str inhand qty unit id
	 */
	public void setStrInhandQtyUnitId(String strInhandQtyUnitId) {
		this.strInhandQtyUnitId = strInhandQtyUnitId;
	}

	/**
	 * Gets the str consumption qty unit id.
	 * 
	 * @return the str consumption qty unit id
	 */
	public String getStrConsumptionQtyUnitId() {
		return strConsumptionQtyUnitId;
	}

	/**
	 * Sets the str consumption qty unit id.
	 * 
	 * @param strConsumptionQtyUnitId the new str consumption qty unit id
	 */
	public void setStrConsumptionQtyUnitId(String strConsumptionQtyUnitId) {
		this.strConsumptionQtyUnitId = strConsumptionQtyUnitId;
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
	 * This method is used to insert the Miscellaneous Consumptions in database
	 * for this activity this method call the dml_miss_consumption_dtl()
	 * procedure.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
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
			if (strConsumptionNo.equals("0") || strConsumptionNo.equals("")) {
				throw new Exception("strConsumptionNo can not be blank");
			}
			if (strItemId.equals("0") || strItemId.equals("")) {
				throw new Exception("strItemId can not be blank");
			}
			if (strStoreValId.equals("0") || strStoreValId.equals("")) {
				throw new Exception("strStoreValId can not be blank");
			}
			if (strBatchSlNo.equals("0") || strBatchSlNo.equals("")) {
				throw new Exception("strBatchSlNo can not be blank");
			}
			if (strItemBrandId.equals("0") || strItemBrandId.equals("")) {
				throw new Exception("strItemBrandId can not be blank");
			}

			strProcName = "{call PKG_MMS_DML.dml_miss_consumption_dtl(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?)}";//18+4=22

			nProcIndex = dao.setProcedure(strProcName);
			dao.setProcInValue(nProcIndex, "modval", 							"1",1);
			dao.setProcInValue(nProcIndex, "hstnum_store_id", 					strStoreValId,2);
			dao.setProcInValue(nProcIndex, "hstnum_consumption_no",				strConsumptionNo,3);
			dao.setProcInValue(nProcIndex, "hstnum_item_id", 					strItemId,4);
			dao.setProcInValue(nProcIndex, "hstnum_itembrand_id",				strItemBrandId,5);
			dao.setProcInValue(nProcIndex, "hststr_batch_sl_no", 				strBatchSlNo,6);
			dao.setProcInValue(nProcIndex, "gnum_hospital_code",				strHospitalCode,7);
			dao.setProcInValue(nProcIndex, "hstnum_stock_status_code",			strStockStatusCode,8);
			dao.setProcInValue(nProcIndex, "hstdt_consumption_date", 			strConsumptionDate,9);
			dao.setProcInValue(nProcIndex, "sstnum_item_cat_no",				strItemCategoryId,10);
			dao.setProcInValue(nProcIndex, "hstnum_consume_qty",				strConsumptionQty,11);
			dao.setProcInValue(nProcIndex, "hstnum_consumeqty_unitid",			strConsumptionQtyUnitId,12);
			dao.setProcInValue(nProcIndex, "hstnum_inhand_qty", 				strInhandQty,13);
			dao.setProcInValue(nProcIndex, "hstnum_inhand_qty_unitid",			strInhandQtyUnitId,14);
			dao.setProcInValue(nProcIndex, "hstdt_expiry_date", 				"",15);
			dao.setProcInValue(nProcIndex, "hstdt_financial_start_date",		strFinancialStartDate,16);
			dao.setProcInValue(nProcIndex, "hstdt_financial_end_date",			strFinancialEndDate,17);
			dao.setProcInValue(nProcIndex, "gstr_remarks ", 					strRemarks,18);
			dao.setProcInValue(nProcIndex, "gdt_entry_date", 					"",19);
			dao.setProcInValue(nProcIndex, "gnum_seatid", 						strSeatId,20);
			
			/* Start Adding Default value*/
			dao.setProcInValue(nProcIndex, "gnum_isvalid", 						strIsValid,21);
			dao.setProcInValue(nProcIndex, "cost_to_pat", 						strMRP,22);
			dao.setProcInValue(nProcIndex, "purrate", 							strPur,23);
			dao.setProcOutValue(nProcIndex, "err",								1,24);
			/* End Adding Default value*/
			
			dao.execute(nProcIndex, 1);

			this.nRowInserted++;

		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

	}

	// Reset all values.

	/**
	 * Reset.
	 */
	public void reset() {
		strStoreValId = "";
		strConsumptionNo = "";
		strItemId = "";
		strItemBrandId = "0";
		strBatchSlNo = "";
		strHospitalCode = "";
		strStockStatusCode = "";
		strConsumptionDate = "";
		strItemCategoryId = "";
		strConsumptionQty = "";
		strConsumptionQtyUnitId = "";
		strInhandQty = "";
		strInhandQtyUnitId = "";
		strExpiryDate = "";
		strFinancialStartDate = "";
		strFinancialEndDate = "";
		strRemarks = "";
		strEntryDate = "";
		strSeatId = "";
		strIsValid = "";
	}

	/**
	 * Gets the str stock status code.
	 * 
	 * @return the strStockStatusCode
	 */
	public String getStrStockStatusCode() {
		return strStockStatusCode;
	}

	/**
	 * Sets the str stock status code.
	 * 
	 * @param strStockStatusCode the strStockStatusCode to set
	 */
	public void setStrStockStatusCode(String strStockStatusCode) {
		this.strStockStatusCode = strStockStatusCode;
	}

	/**
	 * Gets the str reserved flag.
	 * 
	 * @return the strReservedFlag
	 */
	public String getStrReservedFlag() {
		return strReservedFlag;
	}

	/**
	 * Sets the str reserved flag.
	 * 
	 * @param strReservedFlag the strReservedFlag to set
	 */
	public void setStrReservedFlag(String strReservedFlag) {
		this.strReservedFlag = strReservedFlag;
	}
}
