/******************************************************************************************
 *                                Process Name : Item Transfer                            *
 ******************************************************************************************
 * File Name       : TransferItemDtlDAO.java                                              *
 * Module Name     : MMS                                                                  *
 * Developer       : Deepak Tiwari                                                        * 
 * Version         : 1.0                                                                  * 
 * Assigned Date   : 1-May-2009                                                           *                                               
 * Completion Date : 3-May-2009                                                           *
 * Assigned By     : Ajay Kr. Gupta                                                       *
 * Changes Made on : 20-May-2009 , 27-May-2009 , 30-May-2009                              *
 * Hand over date  : 30-May-2009                                                          *
 ******************************************************************************************
 *                    Copyright 2009 CDAC Noida, Inc. All rights reserved.                *
 ******************************************************************************************/

package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class TransferItemDtlDAO.
 */
public class TransferItemDtlDAO {

	/** The str hst num item id. */
	private String strHstNumItemId = "0";
	
	/** The str hst num item brand id. */
	private String strHstNumItemBrandId = "0";
	
	/** The str hst tstr batch sl no. */
	private String strHstTstrBatchSlNo = "0";
	
	/** The str hst num store id. */
	private String strHstNumStoreId = "0";
	
	/** The str sst num item cat no. */
	private String strSstNumItemCatNo = "1";
	
	/** The str hst num item sl no. */
	private String strHstNumItemSlNo = "0";
	
	/** The str hst num stock status code. */
	private String strHstNumStockStatusCode = "1";
	
	/** The str hst num grp id. */
	private String strHstNumGrpId = "";
	
	/** The str hst num sub grp id. */
	private String strHstNumSubGrpId = "";
	
	/** The str hst num in hand qty. */
	private String strHstNumInHandQty = "";
	
	/** The str hst num in hand qty unit id. */
	private String strHstNumInHandQtyUnitId = "";
	
	/** The str hst num rate. */
	private String strHstNumRate = "";
	
	/** The str hst num rate unit id. */
	private String strHstNumRateUnitId = "";
	
	/** The str hst num trns qty. */
	private String strHstNumTrnsQty = "";
	
	/** The str hst num trns qty unit id. */
	private String strHstNumTrnsQtyUnitId = "";
	
	/** The str hs tdt expiry date. */
	private String strHsTdtExpiryDate = "";
	
	/** The str gstr remarks. */
	private String strGstrRemarks = "";
	
	/** The str hst num net cost. */
//	private String strHstNumNetCost = "";
	
	/** The str hosp code. */
	private String strHospCode = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str hst num transfer no. */
	private String strHstNumTransferNo = "";
	
	/** The str to store id. */
	private String strToStoreId = "0";
	
	/** The str hst dt transfer date. */
	private String strHstDtTransferDate = "";
	
	/** The str hst dt manuf date. */
	private String strHstDtManufDate = "";
	
	/** The str hst num consume flg. */
	private String strHstNumConsumeFlg = "";

	// It is mandatory parameter, do not reset the following variables
	/** The str err. */
	private String strErr = "";
	
	/** The str proc name. */
	private final String strProcName = "Pkg_Mms_Dml.DML_HSTT_TRANSFER_ITEM_DTL";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.TransferItemDtlDAO";

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
	 * @return Returns the strErr.
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * Gets the n deleted index.
	 * 
	 * @return Returns the nDeletedIndex.
	 */
	public int getNDeletedIndex() {
		return nDeletedIndex;
	}

	/**
	 * Gets the n inserted index.
	 * 
	 * @return Returns the nInsertedIndex.
	 */
	public int getNInsertedIndex() {
		return nInsertedIndex;
	}

	/**
	 * Gets the n row deleted.
	 * 
	 * @return Returns the nRowDeleted.
	 */
	public int getNRowDeleted() {
		return nRowDeleted;
	}

	/**
	 * Gets the n row inserted.
	 * 
	 * @return Returns the nRowInserted.
	 */
	public int getNRowInserted() {
		return nRowInserted;
	}

	/**
	 * Gets the n row updated.
	 * 
	 * @return Returns the nRowUpdated.
	 */
	public int getNRowUpdated() {
		return nRowUpdated;
	}

	/**
	 * Gets the n updated index.
	 * 
	 * @return Returns the nUpdatedIndex.
	 */
	public int getNUpdatedIndex() {
		return nUpdatedIndex;
	}

	/**
	 * Gets the str file name.
	 * 
	 * @return Returns the strFileName.
	 */
	public String getStrFileName() {
		return strFileName;
	}

	/**
	 * Gets the str proc name.
	 * 
	 * @return Returns the strProcName.
	 */
	public String getStrProcName() {
		return strProcName;
	}

	/**
	 * Sets the str hst num item id.
	 * 
	 * @param strHstNumItemId the new str hst num item id
	 */
	public void setStrHstNumItemId(String strHstNumItemId) {
		this.strHstNumItemId = strHstNumItemId;
	}

	/**
	 * Sets the str hst num item brand id.
	 * 
	 * @param strHstNumItemBrandId the new str hst num item brand id
	 */
	public void setStrHstNumItemBrandId(String strHstNumItemBrandId) {
		this.strHstNumItemBrandId = strHstNumItemBrandId;
	}

	/**
	 * Sets the str hst tstr batch sl no.
	 * 
	 * @param strHstTstrBatchSlNo the new str hst tstr batch sl no
	 */
	public void setStrHstTstrBatchSlNo(String strHstTstrBatchSlNo) {
		this.strHstTstrBatchSlNo = strHstTstrBatchSlNo;
	}

	/**
	 * Sets the str hst num grp id.
	 * 
	 * @param strHstNumGrpId the new str hst num grp id
	 */
	public void setStrHstNumGrpId(String strHstNumGrpId) {
		this.strHstNumGrpId = strHstNumGrpId;
	}

	/**
	 * Sets the str hst num sub grp id.
	 * 
	 * @param strHstNumSubGrpId the new str hst num sub grp id
	 */
	public void setStrHstNumSubGrpId(String strHstNumSubGrpId) {
		this.strHstNumSubGrpId = strHstNumSubGrpId;
	}

	/**
	 * Sets the str hst num in hand qty.
	 * 
	 * @param strHstNumInHandQty the new str hst num in hand qty
	 */
	public void setStrHstNumInHandQty(String strHstNumInHandQty) {
		this.strHstNumInHandQty = strHstNumInHandQty;
	}

	/**
	 * Sets the str hst num in hand qty unit id.
	 * 
	 * @param strHstNumInHandQtyUnitId the new str hst num in hand qty unit id
	 */
	public void setStrHstNumInHandQtyUnitId(String strHstNumInHandQtyUnitId) {
		this.strHstNumInHandQtyUnitId = strHstNumInHandQtyUnitId;
	}

	/**
	 * Sets the str hst num rate.
	 * 
	 * @param strHstNumRate the new str hst num rate
	 */
	public void setStrHstNumRate(String strHstNumRate) {
		this.strHstNumRate = strHstNumRate;
	}

	/**
	 * Sets the str hst num rate unit id.
	 * 
	 * @param strHstNumRateUnitId the new str hst num rate unit id
	 */
	public void setStrHstNumRateUnitId(String strHstNumRateUnitId) {
		this.strHstNumRateUnitId = strHstNumRateUnitId;
	}

	/**
	 * Sets the str hs tdt expiry date.
	 * 
	 * @param strHsTdtExpiryDate the new str hs tdt expiry date
	 */
	public void setStrHsTdtExpiryDate(String strHsTdtExpiryDate) {
		this.strHsTdtExpiryDate = strHsTdtExpiryDate;
	}

	/**
	 * Sets the str gstr remarks.
	 * 
	 * @param strGstrRemarks the new str gstr remarks
	 */
	public void setStrGstrRemarks(String strGstrRemarks) {
		this.strGstrRemarks = strGstrRemarks;
	}

	/**
	 * Sets the str hosp code.
	 * 
	 * @param strHospCode the new str hosp code
	 */
	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
	}

	/**
	 * <p>
	 * Method::insert is Used to insert values into
	 * Table::HSTT_TRANSFER_ITEM_DTL.
	 * <p>
	 * Invoked At the time of saving the record
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */
	public void insert(HisDAO dao) throws Exception {
		strErr = "";
		try {
			// check mandatory information
			if (strHstNumStoreId.equals("0") || strHstNumItemId.equals("0")) {
				throw new Exception("Store Id or Item Id can not be blank");
			}
			// if(this.nRowInserted == 0)
			{
				nInsertedIndex = dao
						.setProcedure("{call "
								+ strProcName
								+ "(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}");
			}
			
			//System.out.println("strProcName"+strProcName);
			// set the value
			// Input Value
			/*
			 * //System.out.println("hospital_code-"+strHospCode);
			 * //System.out.println("seatId-"+strSeatId);
			 * //System.out.println("TransferNo-"+strHstNumTransferNo);
			 * //System.out.println("store_id-"+strHstNumStoreId);
			 * //System.out.println("to_store_id-"+this.strToStoreId);
			 * //System.out.println("itemCatNo-"+this.strSstNumItemCatNo);
			 * //System.out.println("item_id-"+strHstNumItemId);
			 * //System.out.println("item_slno-"+strHstNumItemSlNo);
			 * //System.out.println("stock_status_code-"+strHstNumStockStatusCode);
			 * //System.out.println("transfer_date-"+strHstDtTransferDate);
			 * //System.out.println("itembrand_id-"+strHstNumItemBrandId);
			 * //System.out.println("batch_sl_no-"+strHstTstrBatchSlNo);
			 * //System.out.println("consume_flg-"+strHstNumConsumeFlg);
			 * //System.out.println("manuf_date-"+strHstDtManufDate);
			 * //System.out.println("group_id-"+strHstNumGrpId);
			 * //System.out.println("subgroup_id-"+strHstNumSubGrpId);
			 * //System.out.println("inhand_qty-"+strHstNumInHandQty);
			 * //System.out.println("inhand_qty_unitid-"+strHstNumInHandQtyUnitId);
			 * //System.out.println("rate-"+strHstNumRate);
			 * //System.out.println("rate_unitid-"+strHstNumRateUnitId);
			 * //System.out.println("transfer_qty-"+strHstNumTrnsQty);
			 * //System.out.println("transqty_unitid-"+strHstNumTrnsQtyUnitId);
			 * //System.out.println("expiry_date-"+strHsTdtExpiryDate);
			 * //System.out.println("remarks-"+strGstrRemarks);
			 * //System.out.println("netCost-"+strHstNumNetCost);
			 */

			/** *******************Total Value is 20************************* */
			dao.setProcInValue(nInsertedIndex, "modval", "1",1);
			dao.setProcInValue(nInsertedIndex, "transferNo",
					strHstNumTransferNo.trim(),2);// 1
			dao.setProcInValue(nInsertedIndex, "store_id", strHstNumStoreId
					.trim(),3);
			dao.setProcInValue(nInsertedIndex, "tostore_id ", strToStoreId
					.trim(),4);
			dao.setProcInValue(nInsertedIndex, "item_cat_no",
					strSstNumItemCatNo.trim(),5); // 2
			dao.setProcInValue(nInsertedIndex, "item_id", strHstNumItemId
					.trim(),6); // 3
			dao.setProcInValue(nInsertedIndex, "itembrand_id",
					strHstNumItemBrandId.trim(),7); // 4
			dao.setProcInValue(nInsertedIndex, "batch_sl_no",
					strHstTstrBatchSlNo.trim(),8); // 5
			dao.setProcInValue(nInsertedIndex, "item_sl_no", strHstNumItemSlNo
					.trim(),9);
			dao.setProcInValue(nInsertedIndex, "stock_status_code",
					strHstNumStockStatusCode.trim(),10);
			dao.setProcInValue(nInsertedIndex, "hospital_code", strHospCode
					.trim(),23);
			dao.setProcInValue(nInsertedIndex, "seat_Id", strSeatId.trim(),24); // 6
			if (strHstDtTransferDate.trim().equals("/"))
				dao.setProcInValue(nInsertedIndex, "transfer_date", "",22); // 7
			else
				dao.setProcInValue(nInsertedIndex, "transfer_date",
						strHstDtTransferDate.trim(),22);
			dao.setProcInValue(nInsertedIndex, "consume_flg",
					strHstNumConsumeFlg.trim(),21);
			if (strHstDtManufDate.trim().equals("/"))
				dao.setProcInValue(nInsertedIndex, "manuf_date", "",19); // 7
			else
				dao.setProcInValue(nInsertedIndex, "manuf_date",
						strHstDtManufDate.trim(),19);
			dao.setProcInValue(nInsertedIndex, "group_id", strHstNumGrpId
					.trim(),11); // 8
			dao.setProcInValue(nInsertedIndex, "subgroup_id", strHstNumSubGrpId
					.trim(),12); // 9
			dao.setProcInValue(nInsertedIndex, "inhand_qty", strHstNumInHandQty
					.trim(),17); // 10
			dao.setProcInValue(nInsertedIndex, "inhand_qty_unitid",
					strHstNumInHandQtyUnitId.trim(),18); // 11
			dao.setProcInValue(nInsertedIndex, "rate", strHstNumRate.trim(),15); // 12
			dao.setProcInValue(nInsertedIndex, "rate_unitid",
					strHstNumRateUnitId.trim(),16); // 13
			dao.setProcInValue(nInsertedIndex, "transfer_qty", strHstNumTrnsQty
					.trim(),13); // 14
			dao.setProcInValue(nInsertedIndex, "transqty_unitid",
					strHstNumTrnsQtyUnitId.trim(),14); // 15
			if (strHsTdtExpiryDate.trim().equals("/"))
				dao.setProcInValue(nInsertedIndex, "expiry_date", "",20); // 7
			else
				dao.setProcInValue(nInsertedIndex, "expiry_date",
						strHsTdtExpiryDate.trim(),20); // 16
			dao
					.setProcInValue(nInsertedIndex, "remarks", strGstrRemarks
							.trim(),25);

			// output value
			dao.setProcOutValue(nInsertedIndex, "retSerialNo", 1,26);
			dao.setProcOutValue(nInsertedIndex, "err", 1,27);
			dao.setProcOutValue(nInsertedIndex, "dml_count", 1,28); // 18
			// keep in batch
			dao.execute(nInsertedIndex, 1);
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
	 * This method will be used to clear all the variables.
	 */
	private void reset() {
		strHstNumItemId = "0";
		strHstNumTransferNo = "0";
		strHstNumItemBrandId = "0";
		strHstTstrBatchSlNo = "0";
		strHstNumGrpId = "";
		strHstNumSubGrpId = "";
		strHstNumInHandQty = "";
		strHstNumInHandQtyUnitId = "";
		strHstNumRate = "";
		strHstNumRateUnitId = "";
		strHstNumTrnsQty = "";
		strHstNumTrnsQtyUnitId = "";
		strHsTdtExpiryDate = "";
		strGstrRemarks = "";
		strHospCode = "";
		strHstNumStoreId = "0";
		strHstDtTransferDate = "";
		strHstDtManufDate = "";
		strHstNumConsumeFlg = "";

	}

	/**
	 * Sets the str hst num trns qty.
	 * 
	 * @param strHstNumTrnsQty the new str hst num trns qty
	 */
	public void setStrHstNumTrnsQty(String strHstNumTrnsQty) {
		this.strHstNumTrnsQty = strHstNumTrnsQty;
	}

	/**
	 * Sets the str hst num trns qty unit id.
	 * 
	 * @param strHstNumTrnsQtyUnitId the new str hst num trns qty unit id
	 */
	public void setStrHstNumTrnsQtyUnitId(String strHstNumTrnsQtyUnitId) {
		this.strHstNumTrnsQtyUnitId = strHstNumTrnsQtyUnitId;
	}

	/**
	 * Sets the str hst num store id.
	 * 
	 * @param strHstNumStoreId the new str hst num store id
	 */
	public void setStrHstNumStoreId(String strHstNumStoreId) {
		this.strHstNumStoreId = strHstNumStoreId;
	}

	/**
	 * Sets the str hst dt transfer date.
	 * 
	 * @param strHstDtTransferDate the new str hst dt transfer date
	 */
	public void setStrHstDtTransferDate(String strHstDtTransferDate) {
		this.strHstDtTransferDate = strHstDtTransferDate;
	}

	/**
	 * Sets the str hst dt manuf date.
	 * 
	 * @param strHstDtManufDate the new str hst dt manuf date
	 */
	public void setStrHstDtManufDate(String strHstDtManufDate) {
		this.strHstDtManufDate = strHstDtManufDate;
	}

	/**
	 * Sets the str hst num consume flg.
	 * 
	 * @param strHstNumConsumeFlg the new str hst num consume flg
	 */
	public void setStrHstNumConsumeFlg(String strHstNumConsumeFlg) {
		this.strHstNumConsumeFlg = strHstNumConsumeFlg;
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
	 * Sets the str hst num transfer no.
	 * 
	 * @param strHstNumTransferNo the new str hst num transfer no
	 */
	public void setStrHstNumTransferNo(String strHstNumTransferNo) {
		this.strHstNumTransferNo = strHstNumTransferNo;
	}

	/**
	 * Gets the str hst num item sl no.
	 * 
	 * @return the str hst num item sl no
	 */
	public String getStrHstNumItemSlNo() {
		return strHstNumItemSlNo;
	}

	/**
	 * Sets the str hst num item sl no.
	 * 
	 * @param strHstNumItemSlNo the new str hst num item sl no
	 */
	public void setStrHstNumItemSlNo(String strHstNumItemSlNo) {
		this.strHstNumItemSlNo = strHstNumItemSlNo;
	}

	/**
	 * Gets the str hst num stock status code.
	 * 
	 * @return the str hst num stock status code
	 */
	public String getStrHstNumStockStatusCode() {
		return strHstNumStockStatusCode;
	}

	/**
	 * Sets the str hst num stock status code.
	 * 
	 * @param strHstNumStockStatusCode the new str hst num stock status code
	 */
	public void setStrHstNumStockStatusCode(String strHstNumStockStatusCode) {
		this.strHstNumStockStatusCode = strHstNumStockStatusCode;
	}

	/**
	 * Gets the str to store id.
	 * 
	 * @return the str to store id
	 */
	public String getStrToStoreId() {
		return strToStoreId;
	}

	/**
	 * Gets the str sst num item cat no.
	 * 
	 * @return the str sst num item cat no
	 */
	public String getStrSstNumItemCatNo() {
		return strSstNumItemCatNo;
	}

	/**
	 * Sets the str to store id.
	 * 
	 * @param strToStoreId the new str to store id
	 */
	public void setStrToStoreId(String strToStoreId) {
		this.strToStoreId = strToStoreId;
	}

	/**
	 * Sets the str sst num item cat no.
	 * 
	 * @param strSstNumItemCatNo the new str sst num item cat no
	 */
	public void setStrSstNumItemCatNo(String strSstNumItemCatNo) {
		this.strSstNumItemCatNo = strSstNumItemCatNo;
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

}
