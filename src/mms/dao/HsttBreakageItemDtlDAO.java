package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Amit Kr Version : 1.0 Date : 31/Jan/2009
 * 
 * This class will be used to insert/update/delete the records Table Name :
 * HSTT_BREAKAGE_ITEM_DTL Procedure Name : DML_HSTT_BREAKAGE_ITEM_DTL
 */

public class HsttBreakageItemDtlDAO {

	/** The str hstnum bkg no. */
	private String strHstnumBkgNo = "0";
	
	/** The str hst num item id. */
	private String strHstNumItemId = "0";
	
	/** The str hst num item brand id. */
	private String strHstNumItemBrandId = "0";
	
	/** The str hst tstr batch sl no. */
	private String strHstTstrBatchSlNo = "0";
	
	/** The str hstdt bkg date. */
	private String strHstdtBkgDate = "";
	
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
	
	/** The str hst num bkg qty. */
	private String strHstNumBkgQty = "";
	
	/** The str hst num bkg qty unit id. */
	private String strHstNumBkgQtyUnitId = "";
	
	/** The str hs tdt expiry date. */
	private String strHsTdtExpiryDate = "";
	
	/** The str str id. */
	private String strStrId = "";
	
	/** The str gstr remarks. */
	private String strGstrRemarks = "";
	
	/** The str hosp code. */
	private String strHospCode = "";
	
	/** The item sl no. */
	private String itemSlNo = "";
	
	/** The str consumable flag. */
	private String strConsumableFlag = "";
	
	/** The str item cat no. */
	private String strItemCatNo = "";
	
	/** The str stock status. */
	private String strStockStatus = "";
	
	/** The str item cost. */
	private String strItemCost = "";

	/** The str seat id. */
	private String strSeatId = "";

	// It is mandatory parameter, do not reset the following variables
	/** The str err. */
	private String strErr = "";

	/** The str proc name. */
	private final String strProcName = "pkg_mms_dml.DML_HSTT_BREAKAGE_ITEM_DTL";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.HsttBreakageDtlDAO";

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
	 * Sets the str hstnum bkg no.
	 * 
	 * @param strHstnumBkgNo the new str hstnum bkg no
	 */
	public void setStrHstnumBkgNo(String strHstnumBkgNo) {
		this.strHstnumBkgNo = strHstnumBkgNo;
	}

	/**
	 * Sets the str hstdt bkg date.
	 * 
	 * @param strHstdtBkgDate the new str hstdt bkg date
	 */
	public void setStrHstdtBkgDate(String strHstdtBkgDate) {
		this.strHstdtBkgDate = strHstdtBkgDate;
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
	 * Sets the str hst num bkg qty.
	 * 
	 * @param strHstNumBkgQty the new str hst num bkg qty
	 */
	public void setStrHstNumBkgQty(String strHstNumBkgQty) {
		this.strHstNumBkgQty = strHstNumBkgQty;
	}

	/**
	 * Sets the str hst num bkg qty unit id.
	 * 
	 * @param strHstNumBkgQtyUnitId the new str hst num bkg qty unit id
	 */
	public void setStrHstNumBkgQtyUnitId(String strHstNumBkgQtyUnitId) {
		this.strHstNumBkgQtyUnitId = strHstNumBkgQtyUnitId;
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
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when Approval Id is blank or Approval SlNo. is blank
	 */
	public void insert(HisDAO dao) throws Exception 
	{
		strErr = "";
	
		try 
		{
			if (strHstnumBkgNo.equals("0") || strHstnumBkgNo.equals("")) 
			{
				throw new Exception("Bkg No can not be blank");
			}
			if (this.nRowInserted == 0) 
			{
				nInsertedIndex = dao.setProcedure("{call "+ strProcName+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"); //25
			}

			
			dao.setProcInValue(nInsertedIndex, "modval", "1",1); // 1
			dao.setProcInValue(nInsertedIndex, "hstnum_breakage_no",strHstnumBkgNo.trim(),2); // 2
			dao.setProcInValue(nInsertedIndex, "hstnum_item_id",strHstNumItemId.trim(),3); // 3
			dao.setProcInValue(nInsertedIndex, "hstnum_itembrand_id",strHstNumItemBrandId.trim(),4); // 4
			dao.setProcInValue(nInsertedIndex, "hststr_batch_sl_no",strHstTstrBatchSlNo.trim(),5); // 5
			dao.setProcInValue(nInsertedIndex, "gnum_hospital_code",strHospCode.trim(),6); // 6
			dao.setProcInValue(nInsertedIndex, "hstdt_breakage_date",strHstdtBkgDate.trim(),7); // 7
			dao.setProcInValue(nInsertedIndex, "hstnum_group_id",strHstNumGrpId.trim(),8); // 8
			dao.setProcInValue(nInsertedIndex, "hstnum_subgroup_id",strHstNumSubGrpId.trim(),9); // 9
			dao.setProcInValue(nInsertedIndex, "hstnum_inhand_qty",strHstNumInHandQty.trim(),10); // 10
			dao.setProcInValue(nInsertedIndex, "hstnum_inhand_qty_unitid",strHstNumInHandQtyUnitId.trim(),11); // 11
			dao.setProcInValue(nInsertedIndex, "hstnum_rate", strHstNumRate.trim(),12); // 12
			dao.setProcInValue(nInsertedIndex, "hstnum_rate_unitid",strHstNumRateUnitId.trim(),13); // 13
			dao.setProcInValue(nInsertedIndex, "hstnum_breakage_qty",strHstNumBkgQty.trim(),14); // 14
			dao.setProcInValue(nInsertedIndex, "hstnum_breakage_qty_unitid",strHstNumBkgQtyUnitId.trim(),15); // 15
			dao.setProcInValue(nInsertedIndex, "hstdt_expiry_date",strHsTdtExpiryDate.trim(),16); // 16
			dao.setProcInValue(nInsertedIndex, "gstr_remarks", strGstrRemarks.trim(),17); // 17
			
			dao.setProcInValue(nInsertedIndex, "store_id", strStrId.trim(),18);
			dao.setProcInValue(nInsertedIndex, "itemSlNo", itemSlNo.trim(),19);
			dao.setProcInValue(nInsertedIndex, "strItemCatNo", strItemCatNo.trim(),20);
			dao.setProcInValue(nInsertedIndex, "strConsumableFlag",strConsumableFlag.trim(),21);
			dao.setProcInValue(nInsertedIndex, "strItemCost", strItemCost.trim(),22);
			dao.setProcInValue(nInsertedIndex, "strStockStatus", strStockStatus.trim(),23);
			dao.setProcInValue(nInsertedIndex, "strSeatId", strSeatId.trim(),24);
			dao.setProcOutValue(nInsertedIndex, "err", 1,25); // 18
			
			dao.execute(nInsertedIndex, 1);
			this.nRowInserted++;
		} 
		catch (Exception e) 
		{
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} 
		finally 
		{
			this.reset(); 
		}
	}

	/**
	 * This method will be used to clear all the variables.
	 */
	private void reset() {
		strHstnumBkgNo = "0";
		strHstNumItemId = "0";
		strHstNumItemBrandId = "0";
		strHstTstrBatchSlNo = "0";
		strHstdtBkgDate = "";
		strHstNumGrpId = "";
		strHstNumSubGrpId = "";
		strHstNumInHandQty = "";
		strHstNumInHandQtyUnitId = "";
		strHstNumRate = "";
		strHstNumRateUnitId = "";
		strHstNumBkgQty = "";
		strHstNumBkgQtyUnitId = "";
		strHsTdtExpiryDate = "";
		strGstrRemarks = "";

	}

	/**
	 * Sets the str str id.
	 * 
	 * @param strStrId the new str str id
	 */
	public void setStrStrId(String strStrId) {
		this.strStrId = strStrId;
	}

	/**
	 * Sets the item sl no.
	 * 
	 * @param itemSlNo the new item sl no
	 */
	public void setItemSlNo(String itemSlNo) {
		this.itemSlNo = itemSlNo;
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
	 * Sets the str item cost.
	 * 
	 * @param strItemCost the new str item cost
	 */
	public void setStrItemCost(String strItemCost) {
		this.strItemCost = strItemCost;
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
	 * Sets the str item cat no.
	 * 
	 * @param strItemCatNo the new str item cat no
	 */
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}

	/**
	 * Sets the str stock status.
	 * 
	 * @param strStockStatus the new str stock status
	 */
	public void setStrStockStatus(String strStockStatus) {
		this.strStockStatus = strStockStatus;
	}

}
