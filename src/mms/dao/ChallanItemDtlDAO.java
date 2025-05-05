package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Balasubramaniam M Version : 1.0 Date : 15/Jun/2009
 * 
 * This class will be used to insert the records into the Table :
 * HSTT_CHALLAN_ITEM_DTL
 */

public class ChallanItemDtlDAO {
	
	/** The str file name. */
	private final String strFileName = "mms.dao.ChallanItemDtlDAO";

	/** The str challan no. */
	private String strChallanNo = "0";
	
	/** The str po no. */
	private String strPoNo = "0";
	
	/** The str store id. */
	private String strStoreId = "0";
	
	/** The str po store id. */
	private String strPoStoreId = "0";
	
	/** The str item id. */
	private String strItemId = "0";
	
	/** The str item brand id. */
	private String strItemBrandId = "0";
	
	/** The str schedule no. */
	private String strScheduleNo = "0";
	
	/** The str schedule type. */
	private String strScheduleType = "0";
	
	/** The str group id. */
	private String strGroupId = "0";
	
	/** The str sub group id. */
	private String strSubGroupId = "0";
	
	/** The str balance qty. */
	private String strBalanceQty = "0";
	
	/** The str balance qty unit id. */
	private String strBalanceQtyUnitId = "0";
	
	/** The str recieve qty. */
	private String strRecieveQty = "0";
	
	/** The str recieve qty unit id. */
	private String strRecieveQtyUnitId = "0";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "0";
	
     private String strAcceptedQty = "0";
	 
	 private String strAcceptedQtyUnitId = "";
	 
	 private String strBreakageQty = "0";
	 
	 private String strBreakageQtyUnitId = "";
	 
	 private String strRejectedQty = "0";
	 
	 private String strRejectedQtyUnitId = "";
	 
	 private String strExcessQty = "0";
	 
	 private String strExcessQtyUnitId = "";
	 
	 private String strVerifyFlag = "0";
    
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
				strProcName = "{call PKG_MMS_DML.Dml_HSTT_CHALLAN_ITEM_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				nProcIndex = dao.setProcedure(strProcName);
			}

			dao.setProcInValue(nProcIndex, "modval", "1",1);

			dao.setProcInValue(nProcIndex, "challanNo", strChallanNo,4);
			dao.setProcInValue(nProcIndex, "po_No", strPoNo,2);
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,7);
			dao.setProcInValue(nProcIndex, "store_id", strStoreId,3);
			dao.setProcInValue(nProcIndex, "item_id", strItemId,5);
			dao.setProcInValue(nProcIndex, "item_brand_id", strItemBrandId,6);
			dao.setProcInValue(nProcIndex, "schedule_No", strScheduleNo,8);
			dao.setProcInValue(nProcIndex, "schedule_Type", strScheduleType,10);
			dao.setProcInValue(nProcIndex, "group_id", strGroupId,9);
			dao.setProcInValue(nProcIndex, "subgroup_id", strSubGroupId,11);
			dao.setProcInValue(nProcIndex, "balance_qty", strBalanceQty,12);
			dao.setProcInValue(nProcIndex, "balance_qtyUnitId",
					strBalanceQtyUnitId,13);
			dao.setProcInValue(nProcIndex, "recieve_qty", strRecieveQty,14);
			dao.setProcInValue(nProcIndex, "recieve_qtyUnitId",
					strRecieveQtyUnitId,15);
			dao.setProcInValue(nProcIndex, "remarks", strRemarks,16);
			dao.setProcInValue(nProcIndex, "po_store_id", strPoStoreId,17);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nProcIndex, "acceptedQty", "",18);
			dao.setProcInValue(nProcIndex, "acceptedQtyUnitId", "",19);
			dao.setProcInValue(nProcIndex, "breakageQty", "",20);
			dao.setProcInValue(nProcIndex, "breakageQtyUnitId", "",21);
			dao.setProcInValue(nProcIndex, "rejectedQty", "",22);
			dao.setProcInValue(nProcIndex, "rejectedQtyUnitId", "",23);
			dao.setProcInValue(nProcIndex, "excessQty", "",24);
			dao.setProcInValue(nProcIndex, "excessQtyUnitId", "",25);
			dao.setProcInValue(nProcIndex, "verifyFlag", "1",26);
			dao.setProcInValue(nProcIndex, "cancelSeatId", "",27);
			dao.setProcInValue(nProcIndex, "cancelRemarks", "",28);
			/* Setting Default Value End */
			

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
				strProcName = "{call PKG_MMS_DML.dml_hstt_lpchallan_item_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				nProcIndex = dao.setProcedure(strProcName);
			}

			dao.setProcInValue(nProcIndex, "modval", "1",1);

			dao.setProcInValue(nProcIndex, "challanNo", strChallanNo,4);
			dao.setProcInValue(nProcIndex, "po_No", strPoNo,2);
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,7);
			dao.setProcInValue(nProcIndex, "store_id", strStoreId,3);
			dao.setProcInValue(nProcIndex, "item_id", strItemId,5);
			dao.setProcInValue(nProcIndex, "item_brand_id", strItemBrandId,6);
			dao.setProcInValue(nProcIndex, "schedule_No", strScheduleNo,8);
			dao.setProcInValue(nProcIndex, "schedule_Type", strScheduleType,10);
			dao.setProcInValue(nProcIndex, "group_id", strGroupId,9);
			dao.setProcInValue(nProcIndex, "subgroup_id", strSubGroupId,11);
			dao.setProcInValue(nProcIndex, "balance_qty", strBalanceQty,12);
			dao.setProcInValue(nProcIndex, "balance_qtyUnitId",
					strBalanceQtyUnitId,13);
			dao.setProcInValue(nProcIndex, "recieve_qty", strRecieveQty,14);
			dao.setProcInValue(nProcIndex, "recieve_qtyUnitId",
					strRecieveQtyUnitId,15);
			dao.setProcInValue(nProcIndex, "remarks", strRemarks,16);
			dao.setProcInValue(nProcIndex, "po_store_id", strPoStoreId,17);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nProcIndex, "acceptedQty", "",18);
			dao.setProcInValue(nProcIndex, "acceptedQtyUnitId", "",19);
			dao.setProcInValue(nProcIndex, "breakageQty", "",20);
			dao.setProcInValue(nProcIndex, "breakageQtyUnitId", "",21);
			dao.setProcInValue(nProcIndex, "rejectedQty", "",22);
			dao.setProcInValue(nProcIndex, "rejectedQtyUnitId", "",23);
			dao.setProcInValue(nProcIndex, "excessQty", "",24);
			dao.setProcInValue(nProcIndex, "excessQtyUnitId", "",25);
			dao.setProcInValue(nProcIndex, "verifyFlag", "1",26);
			dao.setProcInValue(nProcIndex, "cancelSeatId", "",27);
			dao.setProcInValue(nProcIndex, "cancelRemarks", "",28);
			/* Setting Default Value End */
			

			dao.setProcOutValue(nProcIndex, "err", 1,29);

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
	
	public void update(HisDAO dao) throws Exception {

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}

			if (nInsertedIndex == 0) {
				strProcName = "{call PKG_MMS_DML.Dml_HSTT_CHALLAN_ITEM_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				nProcIndex = dao.setProcedure(strProcName);
			}

			dao.setProcInValue(nProcIndex, "modval", "2",1);

			dao.setProcInValue(nProcIndex, "challanNo", strChallanNo,4);
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,7);
			dao.setProcInValue(nProcIndex, "store_id", strStoreId,3);
			dao.setProcInValue(nProcIndex, "item_id", strItemId,5);
			dao.setProcInValue(nProcIndex, "item_brand_id", strItemBrandId,6);
			dao.setProcInValue(nProcIndex, "acceptedQty", strAcceptedQty,18);
			dao.setProcInValue(nProcIndex, "acceptedQtyUnitId",strAcceptedQtyUnitId,19);
			dao.setProcInValue(nProcIndex, "breakageQty", strBreakageQty,20);
			dao.setProcInValue(nProcIndex, "breakageQtyUnitId", strBreakageQtyUnitId,21);
			dao.setProcInValue(nProcIndex, "rejectedQty", strRejectedQty,22);
			dao.setProcInValue(nProcIndex, "rejectedQtyUnitId", strRejectedQtyUnitId,23);
			dao.setProcInValue(nProcIndex, "excessQty", strExcessQty,24);
			dao.setProcInValue(nProcIndex, "excessQtyUnitId", strExcessQtyUnitId,25);
			dao.setProcInValue(nProcIndex, "verifyFlag", strVerifyFlag,26);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nProcIndex, "po_No", "",2);
			dao.setProcInValue(nProcIndex, "schedule_No", "",8);
			dao.setProcInValue(nProcIndex, "group_id", "",9);
			dao.setProcInValue(nProcIndex, "schedule_Type", "",10);
			dao.setProcInValue(nProcIndex, "subgroup_id", "",11);
			dao.setProcInValue(nProcIndex, "balance_qty", "",12);
			dao.setProcInValue(nProcIndex, "balance_qtyUnitId", "",13);
			dao.setProcInValue(nProcIndex, "recieve_qty", "",14);
			dao.setProcInValue(nProcIndex, "recieve_qtyUnitId", "",15);
			dao.setProcInValue(nProcIndex, "remarks", "",16);
			dao.setProcInValue(nProcIndex, "po_store_id", "",17);
			dao.setProcInValue(nProcIndex, "cancelSeatId", "",27);
			dao.setProcInValue(nProcIndex, "cancelRemarks", "",28);
			/* Setting Default Value End */
			
			dao.setProcOutValue(nProcIndex, "err", 1,29);

			dao.execute(nProcIndex, 1);
			this.nRowUpdated++;
		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			// this.reset(); // to reset the variables
		}

	}

	// for cancellation
	public void update2(HisDAO dao) throws Exception {

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}

			if (nInsertedIndex == 0) {
				strProcName = "{call PKG_MMS_DML.Dml_HSTT_CHALLAN_ITEM_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				nProcIndex = dao.setProcedure(strProcName);
			}

			dao.setProcInValue(nProcIndex, "modval", "3",1);

			dao.setProcInValue(nProcIndex, "challanNo", strChallanNo,4);
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,7);
			dao.setProcInValue(nProcIndex, "store_id", strStoreId,3);
			dao.setProcInValue(nProcIndex, "item_id", strItemId,5);
			dao.setProcInValue(nProcIndex, "item_brand_id", strItemBrandId,6);
			dao.setProcInValue(nProcIndex, "cancelRemarks", strRemarks,28);
			dao.setProcInValue(nProcIndex, "cancelSeatId", strSeatId,27);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nProcIndex, "po_No", "",2);
			dao.setProcInValue(nProcIndex, "schedule_No", "",8);
			dao.setProcInValue(nProcIndex, "group_id", "",9);
			dao.setProcInValue(nProcIndex, "schedule_Type", "",10);
			dao.setProcInValue(nProcIndex, "subgroup_id", "",11);
			dao.setProcInValue(nProcIndex, "balance_qty", "",12);
			dao.setProcInValue(nProcIndex, "balance_qtyUnitId", "",13);
			dao.setProcInValue(nProcIndex, "recieve_qty", "",14);
			dao.setProcInValue(nProcIndex, "recieve_qtyUnitId", "",15);
			dao.setProcInValue(nProcIndex, "remarks", "",16);
			dao.setProcInValue(nProcIndex, "po_store_id", "",17);
			dao.setProcInValue(nProcIndex, "acceptedQty", "",18);
			dao.setProcInValue(nProcIndex, "acceptedQtyUnitId", "",19);
			dao.setProcInValue(nProcIndex, "breakageQty", "",20);
			dao.setProcInValue(nProcIndex, "breakageQtyUnitId", "",21);
			dao.setProcInValue(nProcIndex, "rejectedQty", "",22);
			dao.setProcInValue(nProcIndex, "rejectedQtyUnitId", "",23);
			dao.setProcInValue(nProcIndex, "excessQty", "",24);
			dao.setProcInValue(nProcIndex, "excessQtyUnitId", "",25);
			dao.setProcInValue(nProcIndex, "verifyFlag", "",26);

			/* Setting Default Value End */
			
			dao.setProcOutValue(nProcIndex, "err", 1,29);

			dao.execute(nProcIndex, 1);
			this.nRowUpdated++;
		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			// this.reset(); // to reset the variables
		}

	}
	
	
	// for cancellation Verified Challan
	public void updateCancelVerifiedChallan(HisDAO dao) throws Exception {

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}

			if (nInsertedIndex == 0) {
				strProcName = "{call PKG_MMS_DML.Dml_HSTT_CHALLAN_ITEM_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				nProcIndex = dao.setProcedure(strProcName);
			}

			dao.setProcInValue(nProcIndex, "modval", "4",1);

			dao.setProcInValue(nProcIndex, "challanNo", strChallanNo,4);
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,7);
			dao.setProcInValue(nProcIndex, "store_id", strStoreId,3);
			dao.setProcInValue(nProcIndex, "item_id", strItemId,5);
			dao.setProcInValue(nProcIndex, "item_brand_id", strItemBrandId,6);
			dao.setProcInValue(nProcIndex, "cancelRemarks", strRemarks,28);
			dao.setProcInValue(nProcIndex, "cancelSeatId", strSeatId,27);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nProcIndex, "po_No", "",2);
			dao.setProcInValue(nProcIndex, "schedule_No", "",8);
			dao.setProcInValue(nProcIndex, "group_id", "",9);
			dao.setProcInValue(nProcIndex, "schedule_Type", "",10);
			dao.setProcInValue(nProcIndex, "subgroup_id", "",11);
			dao.setProcInValue(nProcIndex, "balance_qty", "",12);
			dao.setProcInValue(nProcIndex, "balance_qtyUnitId", "",13);
			dao.setProcInValue(nProcIndex, "recieve_qty", "",14);
			dao.setProcInValue(nProcIndex, "recieve_qtyUnitId", "",15);
			dao.setProcInValue(nProcIndex, "remarks", "",16);
			dao.setProcInValue(nProcIndex, "po_store_id", "",17);
			dao.setProcInValue(nProcIndex, "acceptedQty", "",18);
			dao.setProcInValue(nProcIndex, "acceptedQtyUnitId", "",19);
			dao.setProcInValue(nProcIndex, "breakageQty", "",20);
			dao.setProcInValue(nProcIndex, "breakageQtyUnitId", "",21);
			dao.setProcInValue(nProcIndex, "rejectedQty", "",22);
			dao.setProcInValue(nProcIndex, "rejectedQtyUnitId", "",23);
			dao.setProcInValue(nProcIndex, "excessQty", "",24);
			dao.setProcInValue(nProcIndex, "excessQtyUnitId", "",25);
			dao.setProcInValue(nProcIndex, "verifyFlag", "",26);

			/* Setting Default Value End */
			
			dao.setProcOutValue(nProcIndex, "err", 1,29);

			dao.execute(nProcIndex, 1);
			this.nRowUpdated++;
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

		strChallanNo = "";
		strPoNo = "";
		strStoreId = "";
		strPoStoreId = "";
		strItemId = "";
		strItemBrandId = "";
		strScheduleNo = "";
		strScheduleType = "";
		strGroupId = "";
		strSubGroupId = "";
		strBalanceQty = "";
		strBalanceQtyUnitId = "";
		strRecieveQty = "";
		strRecieveQtyUnitId = "";
		strRemarks = "";
		strHospitalCode = "";

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
	 * Sets the str schedule type.
	 * 
	 * @param strScheduleType the new str schedule type
	 */
	public void setStrScheduleType(String strScheduleType) {
		this.strScheduleType = strScheduleType;
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
	 * Sets the str balance qty.
	 * 
	 * @param strBalanceQty the new str balance qty
	 */
	public void setStrBalanceQty(String strBalanceQty) {
		this.strBalanceQty = strBalanceQty;
	}

	/**
	 * Sets the str balance qty unit id.
	 * 
	 * @param strBalanceQtyUnitId the new str balance qty unit id
	 */
	public void setStrBalanceQtyUnitId(String strBalanceQtyUnitId) {
		this.strBalanceQtyUnitId = strBalanceQtyUnitId;
	}

	/**
	 * Sets the str recieve qty.
	 * 
	 * @param strRecieveQty the new str recieve qty
	 */
	public void setStrRecieveQty(String strRecieveQty) {
		this.strRecieveQty = strRecieveQty;
	}

	/**
	 * Sets the str recieve qty unit id.
	 * 
	 * @param strRecieveQtyUnitId the new str recieve qty unit id
	 */
	public void setStrRecieveQtyUnitId(String strRecieveQtyUnitId) {
		this.strRecieveQtyUnitId = strRecieveQtyUnitId;
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

	public void setStrExcessQty(String strExcessQty) {
		this.strExcessQty = strExcessQty;
	}

	public void setStrExcessQtyUnitId(String strExcessQtyUnitId) {
		this.strExcessQtyUnitId = strExcessQtyUnitId;
	}

	public void setStrVerifyFlag(String strVerifyFlag) {
		this.strVerifyFlag = strVerifyFlag;
	}

	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
}
