package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Balasubramaniam M Version : 1.0 Date : 15/Jun/2009
 * 
 * This class will be used to insert the records into the Table :
 * HSTT_CHALLAN_ITEM_DTL
 */

public class ChallanVerifiedItemDtlDAO {
	
	/** The str file name. */
	private final String strFileName = "mms.dao.ChallanVerifiedItemDtlDAO";


	private String strChallanNo = "0";
	private String strPoNo = "0";
	private String strStoreId = "0";
	private String strPoStoreId = "0";
	private String strItemId = "0";
	private String strItemBrandId = "0";
	private String strBatchSlNo = "";
	private String strScheduleNo = "0";
	private String strGroupId = "0";
	private String strSubGroupId = "0";
	private String strAcceptedQty = "0";
	private String strAcceptedQtyUnitId = "0";
	private String strBreakageQty = "0";
	private String strBreakageQtyUnitId = "0";
	private String strRejectedQty = "0";
	private String strRejectedQtyUnitId = "0";
	private String strInHandQty = "0";
	private String strInHandQtyUnitId = "0";
	private String strExcessQty = "0";
	private String strExcessQtyUnitId = "0";
	private String strRate = "0";
	private String strRateUnitId = "0";
	private String strManufactureDate = "0";
	private String strExpiryDate = "0";
	private String strRemarks = "";
	private String strHospitalCode = "0";
	private String strSeatId = "";
	private String strErr = "";
	private String strMode;
	private String strItemHasShortLifeFlag;				//This field is added by Adil for CR-743
	private String strItemHasAttachedTestReportFlag;	//This field is added by Adil for CR-743
	private String strSalePrice ="0";

	private String strPurRate;
	private String strGST;
	private String strPurRateWithGST;
	private String strHandlingCharges;
	private String strHandlingChargesVal;
	
	public String getStrPurRate() {
		return strPurRate;
	}

	public void setStrPurRate(String strPurRate) {
		this.strPurRate = strPurRate;
	}

	public String getStrGST() {
		return strGST;
	}

	public void setStrGST(String strGST) {
		this.strGST = strGST;
	}

	public String getStrPurRateWithGST() {
		return strPurRateWithGST;
	}

	public void setStrPurRateWithGST(String strPurRateWithGST) {
		this.strPurRateWithGST = strPurRateWithGST;
	}

	public String getStrHandlingCharges() {
		return strHandlingCharges;
	}

	public void setStrHandlingCharges(String strHandlingCharges) {
		this.strHandlingCharges = strHandlingCharges;
	}

	public String getStrHandlingChargesVal() {
		return strHandlingChargesVal;
	}

	public void setStrHandlingChargesVal(String strHandlingChargesVal) {
		this.strHandlingChargesVal = strHandlingChargesVal;
	}

	public void setStrSalePrice(String strSalePrice) {
		this.strSalePrice = strSalePrice;
	}

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
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode the new str hospital code
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
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
	 * Sets the str store id.
	 * 
	 * @param strStoreId the str store id
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	// Methods starts from here

	public String getStrItemHasShortLifeFlag() {
		return strItemHasShortLifeFlag;
	}

	public void setStrItemHasShortLifeFlag(String strItemHasShortLifeFlag) {
		this.strItemHasShortLifeFlag = strItemHasShortLifeFlag;
	}

	public String getStrItemHasAttachedTestReportFlag() {
		return strItemHasAttachedTestReportFlag;
	}

	public void setStrItemHasAttachedTestReportFlag(
			String strItemHasAttachedTestReportFlag) {
		this.strItemHasAttachedTestReportFlag = strItemHasAttachedTestReportFlag;
	}

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

			if (nInsertedIndex == 0) {
				strProcName = "{call PKG_MMS_DML.Dml_CHALLAN_VERIFIEDITEM_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?)}";
				nProcIndex = dao.setProcedure(strProcName);
			}
		
			dao.setProcInValue(nProcIndex, "modval", "1",1);
			dao.setProcInValue(nProcIndex, "challanNo", strChallanNo,2);
			dao.setProcInValue(nProcIndex, "po_No", strPoNo,3);
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,4);
			dao.setProcInValue(nProcIndex, "store_id", strStoreId,5);
			dao.setProcInValue(nProcIndex, "item_id", strItemId,6);
			dao.setProcInValue(nProcIndex, "itembrand_id", strItemBrandId,7);
			dao.setProcInValue(nProcIndex, "batch_slno", strBatchSlNo,8);
			dao.setProcInValue(nProcIndex, "group_id", strGroupId,9);
			dao.setProcInValue(nProcIndex, "subgroup_id", strSubGroupId,10);
			dao.setProcInValue(nProcIndex, "sceduleNo", strScheduleNo,11);
			dao.setProcInValue(nProcIndex, "acceptedQty", strAcceptedQty,12);
			dao.setProcInValue(nProcIndex, "acceptedQty_UnitId", strAcceptedQtyUnitId,13);
			dao.setProcInValue(nProcIndex, "breakageQty", strBreakageQty,14);
			dao.setProcInValue(nProcIndex, "breakageQty_UnitId", strBreakageQtyUnitId,15);
			dao.setProcInValue(nProcIndex, "rejectedQty", strRejectedQty,16);
			dao.setProcInValue(nProcIndex, "rejectedQty_UnitId", strRejectedQtyUnitId,17);
			dao.setProcInValue(nProcIndex, "inhandQty", strInHandQty,18);
			dao.setProcInValue(nProcIndex, "inhandQty_UnitId", strInHandQtyUnitId,19);
			dao.setProcInValue(nProcIndex, "excessQty", strExcessQty,20);
			dao.setProcInValue(nProcIndex, "excessQty_UnitId", strExcessQtyUnitId,21);
			dao.setProcInValue(nProcIndex, "manfDate", strManufactureDate,22);
			dao.setProcInValue(nProcIndex, "expiryDate", strExpiryDate,23);
			//dao.setProcInValue(nProcIndex, "rate", strRate,24);
			dao.setProcInValue(nProcIndex, "rate", strSalePrice,24);
			dao.setProcInValue(nProcIndex, "rate_UnitId", strRateUnitId,25);
			dao.setProcInValue(nProcIndex, "remarks", strRemarks,26);
			dao.setProcInValue(nProcIndex, "seat_id", strSeatId,27);
			dao.setProcInValue(nProcIndex, "po_store_id", strPoStoreId,28);
			dao.setProcInValue(nProcIndex, "purRate", strPurRate,29);
			dao.setProcInValue(nProcIndex, "purRateGST", strPurRateWithGST,30);
			dao.setProcInValue(nProcIndex, "GST", strGST,31);
			dao.setProcInValue(nProcIndex, "HandlingCharges", strHandlingCharges,32);
			dao.setProcInValue(nProcIndex, "HandlingChargesVal", strHandlingChargesVal,33);
			//dao.setProcInValue(nProcIndex, "isShortShlefLife", strItemHasShortLifeFlag);
			//dao.setProcInValue(nProcIndex, "isTestReportAttached", strItemHasAttachedTestReportFlag);
			dao.setProcOutValue(nProcIndex, "err", 1,34);

			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			// this.reset(); // to reset the variables
		}

	}
	public void insertlp(HisDAO dao) throws Exception {

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}

			if (nInsertedIndex == 0) {
				strProcName = "{call PKG_MMS_DML.dml_lpchallan_verifieditem_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				nProcIndex = dao.setProcedure(strProcName);
			}
		
			dao.setProcInValue(nProcIndex, "modval", "1",1);
			dao.setProcInValue(nProcIndex, "challanNo", strChallanNo,2);
			dao.setProcInValue(nProcIndex, "po_No", strPoNo,3);
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,4);
			dao.setProcInValue(nProcIndex, "store_id", strStoreId,5);
			dao.setProcInValue(nProcIndex, "item_id", strItemId,6);
			dao.setProcInValue(nProcIndex, "itembrand_id", strItemBrandId,7);
			dao.setProcInValue(nProcIndex, "batch_slno", strBatchSlNo,8);
			dao.setProcInValue(nProcIndex, "group_id", strGroupId,9);
			dao.setProcInValue(nProcIndex, "subgroup_id", strSubGroupId,10);
			dao.setProcInValue(nProcIndex, "sceduleNo", strScheduleNo,11);
			dao.setProcInValue(nProcIndex, "acceptedQty", strAcceptedQty,12);
			dao.setProcInValue(nProcIndex, "acceptedQty_UnitId", strAcceptedQtyUnitId,13);
			dao.setProcInValue(nProcIndex, "breakageQty", strBreakageQty,14);
			dao.setProcInValue(nProcIndex, "breakageQty_UnitId", strBreakageQtyUnitId,15);
			dao.setProcInValue(nProcIndex, "rejectedQty", strRejectedQty,16);
			dao.setProcInValue(nProcIndex, "rejectedQty_UnitId", strRejectedQtyUnitId,17);
			dao.setProcInValue(nProcIndex, "inhandQty", strInHandQty,18);
			dao.setProcInValue(nProcIndex, "inhandQty_UnitId", strInHandQtyUnitId,19);
			dao.setProcInValue(nProcIndex, "excessQty", strExcessQty,20);
			dao.setProcInValue(nProcIndex, "excessQty_UnitId", strExcessQtyUnitId,21);
			dao.setProcInValue(nProcIndex, "manfDate", strManufactureDate,22);
			dao.setProcInValue(nProcIndex, "expiryDate", strExpiryDate,23);
			//dao.setProcInValue(nProcIndex, "rate", strRate,24);
			//System.out.println("strSalePrice   ===>> "+strSalePrice);
			dao.setProcInValue(nProcIndex, "rate", strSalePrice,24);
			dao.setProcInValue(nProcIndex, "rate_UnitId", strRateUnitId,25);
			dao.setProcInValue(nProcIndex, "remarks", strRemarks,26);
			dao.setProcInValue(nProcIndex, "seat_id", strSeatId,27);
			dao.setProcInValue(nProcIndex, "po_store_id", strPoStoreId,28);
			//dao.setProcInValue(nProcIndex, "isShortShlefLife", strItemHasShortLifeFlag);
			//dao.setProcInValue(nProcIndex, "isTestReportAttached", strItemHasAttachedTestReportFlag);
			dao.setProcOutValue(nProcIndex, "err", 1,29);

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

		 strChallanNo = "0";
		 strPoNo = "0";
		 strStoreId = "0";
		 strPoStoreId = "0";
		 strItemId = "0";
		 strItemBrandId = "0";
		 strBatchSlNo = "";
		 strScheduleNo = "0";
		 strGroupId = "0";
		 strSubGroupId = "0";
		 strAcceptedQty = "0";
		 strAcceptedQtyUnitId = "0";
		 strBreakageQty = "0";
		 strBreakageQtyUnitId = "0";
		 strRejectedQty = "0";
		 strRejectedQtyUnitId = "0";
		 strInHandQty = "0";
		 strInHandQtyUnitId = "0";
		 strExcessQty = "0";
		 strExcessQtyUnitId = "0";
		 strRate = "0";
		 strRateUnitId = "0";
		 strManufactureDate = "0";
		 strExpiryDate = "0";
		 strRemarks = "";
		 strHospitalCode = "0";
		 strSeatId = "";
		 strErr = "";

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
	 * Sets the str challan no.
	 * 
	 * @param strChallanNo the new str challan no
	 */
	public void setStrChallanNo(String strChallanNo) {
		this.strChallanNo = strChallanNo;
	}

	/**
	 * Sets the str po no.
	 * 
	 * @param strPoNo the new str po no
	 */
	public void setStrPoNo(String strPoNo) {
		this.strPoNo = strPoNo;
	}

	/**
	 * Sets the str po store id.
	 * 
	 * @param strPoStoreId the new str po store id
	 */
	public void setStrPoStoreId(String strPoStoreId) {
		this.strPoStoreId = strPoStoreId;
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
	 * Sets the str item brand id.
	 * 
	 * @param strItemBrandId the new str item brand id
	 */
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}

	/**
	 * Sets the str schedule no.
	 * 
	 * @param strScheduleNo the new str schedule no
	 */
	public void setStrScheduleNo(String strScheduleNo) {
		this.strScheduleNo = strScheduleNo;
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

	public void setStrBatchSlNo(String strBatchSlNo) {
		this.strBatchSlNo = strBatchSlNo;
	}

	public void setStrAcceptedQty(String strAcceptedQty) {
		this.strAcceptedQty = strAcceptedQty;
	}

	public void setStrAcceptedQtyUnitId(String strAcceptedQtyUnitId) {
		this.strAcceptedQtyUnitId = strAcceptedQtyUnitId;
	}

	public void setStrBreakageQty(String strBreakageQty) {
		this.strBreakageQty = strBreakageQty;
	}

	public void setStrBreakageQtyUnitId(String strBreakageQtyUnitId) {
		this.strBreakageQtyUnitId = strBreakageQtyUnitId;
	}

	public void setStrRejectedQty(String strRejectedQty) {
		this.strRejectedQty = strRejectedQty;
	}

	public void setStrRejectedQtyUnitId(String strRejectedQtyUnitId) {
		this.strRejectedQtyUnitId = strRejectedQtyUnitId;
	}

	public void setStrInHandQty(String strInHandQty) {
		this.strInHandQty = strInHandQty;
	}

	public void setStrInHandQtyUnitId(String strInHandQtyUnitId) {
		this.strInHandQtyUnitId = strInHandQtyUnitId;
	}

	public void setStrExcessQty(String strExcessQty) {
		this.strExcessQty = strExcessQty;
	}

	public void setStrExcessQtyUnitId(String strExcessQtyUnitId) {
		this.strExcessQtyUnitId = strExcessQtyUnitId;
	}

	public void setStrRate(String strRate) {
		this.strRate = strRate;
	}

	public void setStrRateUnitId(String strRateUnitId) {
		this.strRateUnitId = strRateUnitId;
	}

	public void setManufactureDate(String strManufactureDate) {
		this.strManufactureDate = strManufactureDate;
	}

	public void setExpiryDate(String strExpiryDate) {
		this.strExpiryDate = strExpiryDate;
	}

	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	public String getStrMode() {
		return strMode;
	}

	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}

	
}
