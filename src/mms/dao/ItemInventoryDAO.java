/**
 * 
 */
package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemInventoryDAO.
 */

/**
 * Developer : Anshul Jindal Version : 1.0 Date : 5/Feb/2009
 * 
 * This class will be used to insert/update/delete the records Table Name :
 * HSTT_ITEM_CURRSTOCK_DTL
 */
public class ItemInventoryDAO {

	/** The str proc name. */
	//private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.ItemInventoryDAO";

	/** The str item id. */
	private String strItemID = "";
	
	/** The str item brand id. */
	private String strItemBrandID = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str store id. */
	private String strStoreID = "";
	
	/** The str batch no. */
	private String strBatchNo = "";
	
	/** The str item sl no. */
	private String strItemSlNo = "";
	
	/** The str item catagory no. */
	private String strItemCatagoryNo = "";
	
	/** The str group id. */
	private String strGroupID = "";
	
	/** The str sub group id. */
	private String strSubGroupID = "";
	
	/** The str expirydate. */
	private String strExpirydate = "";
	
	/** The str manufacture date. */
	private String strManufactureDate = "";
	
	/** The str item status. */
	private String strItemStatus = "1";
	
	/** The str item flag. */
	private String strItemFlag = "1";
	
	/** The str in hand qty. */
	private String strInHandQty = "0";
	
	/** The str in hand qty unit id. */
	private String strInHandQtyUnitID = "";
	
	/** The str rate. */
	private String strRate = "0";
	
	/** The str rate unit id. */
	private String strRateUnitID = "";
	
	/** The str sale price. */
	private String strSalePrice = "0";
	
	/** The str sale price unit id. */
	private String strSalePriceUnitID = "";
	
	/** The str supplier id. */
	private String strSupplierID = "";
	
	/** The str composite item id. */
//	private String strCompositeItemID = "";
	
	/** The str consumable flag. */
	private String strConsumableFlag = "0";
	
	/** The str item has param. */
	private String strItemHasParam = "0";
	
	/** The str po no. */
	private String strPoNo = "";

	/** The str last mod seat id. */
//	private String strLastModSeatID = "";
	
	/** The str last mod seat date. */
	//private String strLastModSeatDate = "";
	
	/** The str seat id. */
	private String strSeatID = "";
	
	/** The str is valid. */
//	private String strIsValid = "";
	
	/** The str sl no. */
	private String strSlNo = "";

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
	 * Sets the str item id.
	 * 
	 * @param strItemID the strItemID to set
	 */
	public void setStrItemID(String strItemID) {
		this.strItemID = strItemID;
	}

	/**
	 * Sets the str item brand id.
	 * 
	 * @param strItemBrandID the strItemBrandID to set
	 */
	public void setStrItemBrandID(String strItemBrandID) {
		this.strItemBrandID = strItemBrandID;
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
	 * Sets the str store id.
	 * 
	 * @param strStoreID the strStoreID to set
	 */
	public void setStrStoreID(String strStoreID) {
		this.strStoreID = strStoreID;
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
	 * Sets the str item sl no.
	 * 
	 * @param strItemSlNo the strItemSlNo to set
	 */
	public void setStrItemSlNo(String strItemSlNo) {
		this.strItemSlNo = strItemSlNo;
	}

	/**
	 * Sets the str item catagory no.
	 * 
	 * @param strItemCatagoryNo the strItemCatagoryNo to set
	 */
	public void setStrItemCatagoryNo(String strItemCatagoryNo) {
		this.strItemCatagoryNo = strItemCatagoryNo;
	}

	/**
	 * Sets the str group id.
	 * 
	 * @param strGroupID the strGroupID to set
	 */
	public void setStrGroupID(String strGroupID) {
		this.strGroupID = strGroupID;
	}

	/**
	 * Sets the str sub group id.
	 * 
	 * @param strSubGroupID the strSubGroupID to set
	 */
	public void setStrSubGroupID(String strSubGroupID) {
		this.strSubGroupID = strSubGroupID;
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
	 * Sets the str item status.
	 * 
	 * @param strItemStatus the strItemStatus to set
	 */
	public void setStrItemStatus(String strItemStatus) {
		this.strItemStatus = strItemStatus;
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
	 * Sets the str in hand qty.
	 * 
	 * @param strInHandQty the strInHandQty to set
	 */
	public void setStrInHandQty(String strInHandQty) {
		this.strInHandQty = strInHandQty;
	}

	/**
	 * Sets the str in hand qty unit id.
	 * 
	 * @param strInHandQtyUnitID the strInHandQtyUnitID to set
	 */
	public void setStrInHandQtyUnitID(String strInHandQtyUnitID) {
		this.strInHandQtyUnitID = strInHandQtyUnitID;
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
	 * Sets the str rate unit id.
	 * 
	 * @param strRateUnitID the strRateUnitID to set
	 */
	public void setStrRateUnitID(String strRateUnitID) {
		this.strRateUnitID = strRateUnitID;
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
	 * Sets the str sale price unit id.
	 * 
	 * @param strSalePriceUnitID the strSalePriceUnitID to set
	 */
	public void setStrSalePriceUnitID(String strSalePriceUnitID) {
		this.strSalePriceUnitID = strSalePriceUnitID;
	}

	/**
	 * Sets the str supplier id.
	 * 
	 * @param strSupplierID the strSupplierID to set
	 */
	public void setStrSupplierID(String strSupplierID) {
		this.strSupplierID = strSupplierID;
	}

	 
	/**
	 * Sets the str consumable flag.
	 * 
	 * @param strConsumableFlag the strConsumableFlag to set
	 */
	public void setStrConsumableFlag(String strConsumableFlag) {
		this.strConsumableFlag = strConsumableFlag;
	}

	/**
	 * Sets the str item has param.
	 * 
	 * @param strItemHasParam the strItemHasParam to set
	 */
	public void setStrItemHasParam(String strItemHasParam) {
		this.strItemHasParam = strItemHasParam;
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
	 * Sets the str seat id.
	 * 
	 * @param strSeatID the strSeatID to set
	 */
	public void setStrSeatID(String strSeatID) {
		this.strSeatID = strSeatID;
	}

	 

	/**
	 * Sets the str sl no.
	 * 
	 * @param strSlNo the strSlNo to set
	 */
	public void setStrSlNo(String strSlNo) {
		this.strSlNo = strSlNo;
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

			strProcName = "{call PROC_HSTT_ITEM_CURRSTOCK_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			nProcIndex = dao.setProcedure(strProcName);
			dao.setProcInValue(nProcIndex, "modeval", "1");
			dao.setProcInValue(nProcIndex, "store_id", strStoreID);
			dao.setProcInValue(nProcIndex, "item_id", strItemID);
			dao.setProcInValue(nProcIndex, "itembrand_id", strItemBrandID);
			dao.setProcInValue(nProcIndex, "batch_no", strBatchNo);
			dao.setProcInValue(nProcIndex, "itemslno", strItemSlNo);
			dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode);
			dao.setProcInValue(nProcIndex, "group_id", strGroupID);
			dao.setProcInValue(nProcIndex, "sub_group_id", strSubGroupID);
			dao.setProcInValue(nProcIndex, "cat_no", strItemCatagoryNo);
			dao.setProcInValue(nProcIndex, "manuf_date", strManufactureDate);
			dao.setProcInValue(nProcIndex, "expiry_date", strExpirydate);
			dao.setProcInValue(nProcIndex, "item_status", strItemStatus);
			dao.setProcInValue(nProcIndex, "item_flag", strItemFlag);
			dao.setProcInValue(nProcIndex, "quantity_inhand", strInHandQty);
			dao.setProcInValue(nProcIndex, "inhand_quantity_unitid",
					strInHandQtyUnitID);
			dao.setProcInValue(nProcIndex, "supplier_id", strSupplierID);
			dao.setProcInValue(nProcIndex, "rate", strRate);
			dao.setProcInValue(nProcIndex, "rate_unitid", strRateUnitID);
			dao.setProcInValue(nProcIndex, "sale_price", strSalePrice);
			dao.setProcInValue(nProcIndex, "sale_unnitid", strSalePriceUnitID);
			dao.setProcInValue(nProcIndex, "po_no", strPoNo);
			dao
					.setProcInValue(nProcIndex, "consumable_flag",
							strConsumableFlag);
			dao.setProcInValue(nProcIndex, "seat_id", strSeatID);
			dao.setProcInValue(nProcIndex, "slno", strSlNo);
			dao.setProcInValue(nProcIndex, "param_flag", strItemHasParam);
			dao.setProcOutValue(nProcIndex, "err", 1);

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
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strHospitalCode or strStoreID or
	 * strItemID,strItemBrandID,strItemSlNo,strSlNo is blank
	 */
	public void update(HisDAO dao) throws Exception {

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		try {

			// check mandatory information
			if (strStoreID.equals("0") || strStoreID.equals("")) {
				throw new Exception("strStoreID can not be blank");
			}
			if (strItemID.equals("0") || strItemID.equals("")) {
				throw new Exception("strItemID can not be blank");
			}
			/*
			 * if (strItemBrandID.equals("0") || strItemBrandID.equals("")) {
			 * throw new Exception("strItemBrandID can not be blank"); }
			 */
			if (strBatchNo.equals("0") || strBatchNo.equals("")) {
				throw new Exception("strBatchNo can not be blank");
			}
			if (strItemSlNo.equals("0") || strItemSlNo.equals("")) {
				throw new Exception("strItemSlNo can not be blank");
			}
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strSlNo.equals("0") || strSlNo.equals("")) {
				throw new Exception("strSlNo can not be blank");
			}

			strProcName = "{call PROC_HSTT_ITEM_CURRSTOCK_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";// 17
			nProcIndex = dao.setProcedure(strProcName);

			/*
			 * //System.out.println( "dao store_id"+ strStoreID);
			 * //System.out.println( "item_id"+ strItemID); //System.out.println(
			 * "itembrand_id"+strItemBrandID); //System.out.println( "batch_no"+
			 * strBatchNo); //System.out.println( "itemslno"+ strItemSlNo);
			 * //System.out.println( "hospital_code"+strHospitalCode);
			 * //System.out.println( "slno"+ strSlNo);
			 * 
			 * //System.out.println( "manuf_date"+strManufactureDate);
			 * //System.out.println( "expiry_date"+strExpirydate);
			 * //System.out.println( "item_status"+ strItemStatus);
			 * //System.out.println( "quantity_inhand"+strInHandQty);
			 * //System.out.println( "rate"+ strRate); //System.out.println(
			 * "sale_price"+ strSalePrice); //System.out.println(
			 * "po_no"+strPoNo);
			 * 
			 * //System.out.println( "last_modif_seat_id"+ strSeatID);
			 */
			dao.setProcInValue(nProcIndex, "modeval", "2");

			dao.setProcInValue(nProcIndex, "store_id", strStoreID);
			dao.setProcInValue(nProcIndex, "item_id", strItemID);
			dao.setProcInValue(nProcIndex, "itembrand_id", strItemBrandID);
			dao.setProcInValue(nProcIndex, "batch_no", strBatchNo);
			dao.setProcInValue(nProcIndex, "itemslno", strItemSlNo);
			dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode);
			dao.setProcInValue(nProcIndex, "slno", strSlNo);
			dao.setProcInValue(nProcIndex, "manuf_date", strManufactureDate);
			dao.setProcInValue(nProcIndex, "expiry_date", strExpirydate);
			dao.setProcInValue(nProcIndex, "item_status", strItemStatus);
			dao.setProcInValue(nProcIndex, "quantity_inhand", strInHandQty);
			dao.setProcInValue(nProcIndex, "rate", strRate);
			dao.setProcInValue(nProcIndex, "sale_price", strSalePrice);
			dao.setProcInValue(nProcIndex, "po_no", strPoNo);

			dao.setProcInValue(nProcIndex, "last_modif_seat_id", strSeatID);

			dao.setProcOutValue(nProcIndex, "err", 1);

			dao.execute(nProcIndex, 1);
			this.nRowUpdated++;
		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".UPDATE() --> " + this.strErr);
		} finally {
			// this.reset(); // to reset the variables
		}

	}

	/**
	 * Reset.
	 */
	public void reset() {

		strItemID = "";
		strItemBrandID = "";
		strHospitalCode = "";
		strStoreID = "";
		strBatchNo = "";
		strItemSlNo = "";
		strItemCatagoryNo = "";
		strGroupID = "";
		strSubGroupID = "";
		strExpirydate = "";
		strManufactureDate = "";
		strItemStatus = "1";
		strItemFlag = "1";
		strInHandQty = "0";
		strInHandQtyUnitID = "";
		strRate = "0";
		strRateUnitID = "";
		strSalePrice = "0";
		strSalePriceUnitID = "";
		strSupplierID = "";
		//strCompositeItemID = "";
		strConsumableFlag = "0";
		strItemHasParam = "0";
		strPoNo = "";

		//strLastModSeatID = "";
		//strLastModSeatDate = "";
		strSeatID = "";
		//strIsValid = "1";
		strSlNo = "1";

	}

}
