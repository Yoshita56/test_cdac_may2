package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugInventoryDAO.
 */
public class DrugInventoryDAO {

	/** The str file name. */
	private final String strFileName = "mms.dao.DrugInventoryTransDAO";

	/** The str store id. */
	private String strStoreId = "";
	
	/** The str group id. */
	private String strGroupId = "";
	
	/** The str item id. */
	private String strItemId = "";
	
	/** The str item brand id. */
	private String strItemBrandId = "";
	
	/** The str batch no. */
	private String strBatchNo = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str sub group id. */
	private String strSubGroupId = "";
	
	/** The str expirydate. */
	private String strExpirydate = "";
	
	/** The str manufacture date. */
	private String strManufactureDate = "";
	
	/** The str in hand quantity. */
	private String strInHandQuantity = "";
	
	/** The str in hand quantity unit id. */
	private String strInHandQuantityUnitID = "";
	
	/** The str manufacture id. */
	private String strManufactureId = "";
	
	/** The str rate. */
	private String strRate = "";
	
	/** The str unit id. */
//	private String strUnitId = "";
	
	/** The str unit rate id. */
	private String strUnitRateID = "";
	
	/** The str sale price. */
	private String strSalePrice = "";
	
	/** The str unit id sale. */
	private String strUnitIdSale = "";
	
	/** The str po no. */
	private String strPoNo = "";
	
	/** The str item status. */
	private String strItemStatus = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str is valid. */
//	private String strIsValid = "";
	
	/** The str item category no. */
//	private String strItemCategoryNo = "";
	
	/** The str item flag. */
	private String strItemFlag = "";
	
	/** The str slno. */
//	private String strSlno = "";
	
	/** The str consumable_flag. */
//	private String strConsumable_flag = "";
	
	/** The strgnum_lastmodified_seat_id. */
	private String strgnum_lastmodified_seat_id = "";
	
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
	 * Sets the str store id.
	 * 
	 * @param strStoreId the strStoreId to set
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	/**
	 * Sets the str group id.
	 * 
	 * @param strGroupId the strGroupId to set
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	/**
	 * Sets the str item id.
	 * 
	 * @param strItemId the strItemId to set
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}

	/**
	 * Sets the str item brand id.
	 * 
	 * @param strItemBrandId the strItemBrandId to set
	 */
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}

	/**
	 * Sets the str batch no.
	 * 
	 * @param strBatchNo the strBatchNo to set
	 */
	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
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
	 * Sets the str sub group id.
	 * 
	 * @param strSubGroupId the strSubGroupId to set
	 */
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}

	/**
	 * Sets the str expirydate.
	 * 
	 * @param strExpirydate the strExpirydate to set
	 */
	public void setStrExpirydate(String strExpirydate) {
		this.strExpirydate = strExpirydate;
	}

	/**
	 * Sets the str manufacture date.
	 * 
	 * @param strManufactureDate the strManufactureDate to set
	 */
	public void setStrManufactureDate(String strManufactureDate) {
		this.strManufactureDate = strManufactureDate;
	}

	/**
	 * Sets the str in hand quantity.
	 * 
	 * @param strInHandQuantity the strInHandQuantity to set
	 */
	public void setStrInHandQuantity(String strInHandQuantity) {
		this.strInHandQuantity = strInHandQuantity;
	}

	/**
	 * Sets the str in hand quantity unit id.
	 * 
	 * @param strInHandQuantityUnitID the strInHandQuantityUnitID to set
	 */
	public void setStrInHandQuantityUnitID(String strInHandQuantityUnitID) {
		this.strInHandQuantityUnitID = strInHandQuantityUnitID;
	}

	/**
	 * Sets the str manufacture id.
	 * 
	 * @param strManufactureId the strManufactureId to set
	 */
	public void setStrManufactureId(String strManufactureId) {
		this.strManufactureId = strManufactureId;
	}

	/**
	 * Sets the str rate.
	 * 
	 * @param strRate the strRate to set
	 */
	public void setStrRate(String strRate) {
		this.strRate = strRate;
	}

 

	/**
	 * Sets the str sale price.
	 * 
	 * @param strSalePrice the strSalePrice to set
	 */
	public void setStrSalePrice(String strSalePrice) {
		this.strSalePrice = strSalePrice;
	}

	/**
	 * Sets the str unit id sale.
	 * 
	 * @param strUnitIdSale the strUnitIdSale to set
	 */
	public void setStrUnitIdSale(String strUnitIdSale) {
		this.strUnitIdSale = strUnitIdSale;
	}

	/**
	 * Sets the str po no.
	 * 
	 * @param strPoNo the strPoNo to set
	 */
	public void setStrPoNo(String strPoNo) {
		this.strPoNo = strPoNo;
	}

	/**
	 * Sets the str item status.
	 * 
	 * @param strItemStatus the strItemStatus to set
	 */
	public void setStrItemStatus(String strItemStatus) {
		this.strItemStatus = strItemStatus;
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
	 * Sets the str item flag.
	 * 
	 * @param strItemFlag the strItemFlag to set
	 */
	public void setStrItemFlag(String strItemFlag) {
		this.strItemFlag = strItemFlag;
	}

	 

	/**
	 * Sets the str unit rate id.
	 * 
	 * @param strUnitRateID the strUnitRateID to set
	 */
	public void setStrUnitRateID(String strUnitRateID) {
		this.strUnitRateID = strUnitRateID;
	}

	/**
	 * Insert.
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
			strProcName = "{call proc_hstt_drug_currstock_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";// /25
			nProcIndex = dao.setProcedure(strProcName);

			/*
			 * //System.out.println( "modval"+ "1"); //System.out.println(
			 * "store_id"+ strStoreId); //System.out.println( "item_id"+
			 * strItemId); //System.out.println( "itembrand_id"+ strItemBrandId);
			 * //System.out.println( "batch_no"+ strBatchNo); //System.out.println(
			 * "hospital_code"+ strHospitalCode); ////System.out.println( "slno"+
			 * "1"); //System.out.println( "cat_no"+ "1"); //System.out.println(
			 * "group_id"+strGroupId); //System.out.println( "sub_group_id"+
			 * strSubGroupId); //System.out.println( "expiry_date"+
			 * strExpirydate); //System.out.println( "manuf_date"+
			 * strManufactureDate); //System.out.println( "item_flag"+
			 * strItemFlag); //System.out.println( "quantity_inhand"+
			 * strInHandQuantity); //System.out.println( "inhand_quantity_unitid"+
			 * strInHandQuantityUnitID); //System.out.println( "strUnitRateID"+
			 * strUnitRateID); //System.out.println( "supplier_id"+
			 * strManufactureId); //System.out.println( "rate"+ strRate);
			 * //System.out.println( "rate_unitid"+ strUnitRateID);
			 * //System.out.println( "sale_price"+ strSalePrice);
			 * //System.out.println( "sale_unnitid"+ strUnitIdSale);
			 * //System.out.println( "consumable_flag"+ "1"); //System.out.println(
			 * "po_no"+ strPoNo); //System.out.println( "item_status"+
			 * strItemStatus); //System.out.println( "gnum_seat_id"+ strSeatId);
			 * //System.out.println( "gnum_isvalid"+ "1");
			 */

			dao.setProcInValue(nProcIndex, "modval", "1");
			dao.setProcInValue(nProcIndex, "store_id", strStoreId);
			dao.setProcInValue(nProcIndex, "item_id", strItemId);
			dao.setProcInValue(nProcIndex, "itembrand_id", strItemBrandId);
			dao.setProcInValue(nProcIndex, "batch_no", strBatchNo);
			dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode);
			dao.setProcInValue(nProcIndex, "cat_no", "10");
			dao.setProcInValue(nProcIndex, "group_id", strGroupId);
			dao.setProcInValue(nProcIndex, "sub_group_id", strSubGroupId);
			dao.setProcInValue(nProcIndex, "expiry_date", strExpirydate);
			dao.setProcInValue(nProcIndex, "manuf_date", strManufactureDate);
			dao.setProcInValue(nProcIndex, "item_flag", strItemFlag);
			dao
					.setProcInValue(nProcIndex, "quantity_inhand",
							strInHandQuantity);
			dao.setProcInValue(nProcIndex, "inhand_quantity_unitid",
					strInHandQuantityUnitID);
			dao.setProcInValue(nProcIndex, "supplier_id", strManufactureId);
			dao.setProcInValue(nProcIndex, "rate", strRate);
			dao.setProcInValue(nProcIndex, "rate_unitid", strUnitRateID);
			dao.setProcInValue(nProcIndex, "sale_price", strSalePrice);
			dao.setProcInValue(nProcIndex, "sale_unnitid", strUnitIdSale);
			dao.setProcInValue(nProcIndex, "consumable_flag", "1");
			dao.setProcInValue(nProcIndex, "po_no", strPoNo);
			dao.setProcInValue(nProcIndex, "item_status", strItemStatus);
			dao.setProcInValue(nProcIndex, "gnum_seat_id", strSeatId);
			dao.setProcInValue(nProcIndex, "gnum_isvalid", "1");
			dao.setProcOutValue(nProcIndex, "err", 1);

			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {

		}
	}

	/**
	 * This method will be used to update the records.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */

	public void update(HisDAO dao) throws Exception {

		strErr = "";
		String strProcName = "";

		int nProcIndex = 0;

		try {

			strProcName = "{call proc_hstt_drug_stock_update(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			nProcIndex = dao.setProcedure(strProcName);
			dao.setProcInValue(nProcIndex, "modval", "2");
			dao.setProcInValue(nProcIndex, "store_id", strStoreId);
			dao.setProcInValue(nProcIndex, "item_id", strItemId);
			dao.setProcInValue(nProcIndex, "itembrand_id", strItemBrandId);
			dao.setProcInValue(nProcIndex, "batch_no", strBatchNo);
			dao.setProcInValue(nProcIndex, "slno", "1");
			dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode);
			dao.setProcInValue(nProcIndex, "expiry_date", strExpirydate);
			dao.setProcInValue(nProcIndex, "manuf_date", strManufactureDate);
			dao
					.setProcInValue(nProcIndex, "quantity_inhand",
							strInHandQuantity);
			dao.setProcInValue(nProcIndex, "inhand_quantity_unitid",
					strInHandQuantityUnitID);
			dao.setProcInValue(nProcIndex, "inhand_quantity_unitid",
					strUnitRateID);
			dao.setProcInValue(nProcIndex, "rate", strRate);
			dao.setProcInValue(nProcIndex, "rate_unitid", strUnitRateID);
			dao.setProcInValue(nProcIndex, "sale_price", strSalePrice);
			dao.setProcInValue(nProcIndex, "sale_unnitid", strUnitIdSale);
			dao.setProcInValue(nProcIndex, "item_status", strItemStatus);
			dao.setProcInValue(nProcIndex, "po_no", strPoNo);
			dao.setProcInValue(nProcIndex, "gnum_lastmodified_seat_id",
					strgnum_lastmodified_seat_id);
			dao.setProcOutValue(nProcIndex, "err", 1);

			dao.execute(nProcIndex, 1);
			this.nRowUpdated++;
		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {

		}

	}

	 

	/**
	 * Sets the strgnum_lastmodified_seat_id.
	 * 
	 * @param strgnum_lastmodified_seat_id the strgnum_lastmodified_seat_id to set
	 */
	public void setStrgnum_lastmodified_seat_id(
			String strgnum_lastmodified_seat_id) {
		this.strgnum_lastmodified_seat_id = strgnum_lastmodified_seat_id;
	}

}
