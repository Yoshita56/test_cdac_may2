package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Balasubramaniam M Version : 1.0 Date : 15/Jun/2009
 * 
 * This class will be used to insert the records into the Table :
 * HSTT_CHALLAN_DTL
 */

public class ChallanDtlDAO {
	
	/** The str file name. */
	private final String strFileName = "mms.dao.ChallanDtlDAO";

	/** The str challan no. */
	private String strChallanNo = "0";
	
	/** The str po no. */
	private String strPoNo = "0";
	
	/** The str store id. */
	private String strStoreId = "0";
	
	/** The str supplier id. */
	private String strSupplierId = "0";
	
	/** The str awb no. */
	private String strAwbNo = "0";
	
	/** The str po date. */
	private String strPoDate = "";
	
	/** The str po store id. */
	private String strPoStoreId = "0";
	
	/** The str be no. */
	private String strBeNo = "0";
	
	/** The str be date. */
	private String strBeDate = "";
	
	/** The str packets. */
	private String strPackets = "0";
	
	/** The str packet weight. */
	private String strPacketWeight = "0";
	
	/** The str delivery date. */
	private String strDeliveryDate = "";
	
	/** The str deliver mode. */
	private String strDeliverMode = "0";
	
	/** The str committee type. */
	private String strCommitteeType = "0";
	
	/** The str committee remarks sl no. */
	private String strCommitteeRemarksSlNo = "0";
	
	/** The str committee no. */
	private String strCommitteeNo = "0";
	
	/** The str challan status. */
	private String strChallanStatus = "0";
	
	/** The str item category id. */
	private String strItemCategoryId = "0";
	
	/** The str fin end date. */
	private String strFinEndDate = "";
	
	/** The str fin start date. */
	private String strFinStartDate = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str seat id. */
	private String strSeatId = "0";
	
	/** The str hospital code. */
	private String strHospitalCode = "0";
	
	/** The str received by. */
	private String strReceivedBy = "";
	
	/** The str schedule no. */
	private String strScheduleNo = "0";
	
	/** The str schedule type. */
	private String strScheduleType = "0";
	
	private String strSupplierReceiptNo = "0";
	private String strSupplierReceiptDate = "";
	private String strChallanReceivedDate = "";
	private String strFileNo = "";
	private String strPageNo = "";
	private String strFileChallanName = "";
	
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

	private String strSupplierBillNo="0";
	
	private String strSupplierBillDate = "";
	
	private String strSupplyPeriod = "";
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
	 * Sets the str seat id.
	 * 
	 * @param strSeatId the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
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

	/**
	 * Sets the str item category id.
	 * 
	 * @param strItemCategoryId the str item category id
	 */
	public void setStrItemCategoryId(String strItemCategoryId) {
		this.strItemCategoryId = strItemCategoryId;
	}

	/**
	 * Sets the str fin end date.
	 * 
	 * @param strFinEndDate the str fin end date
	 */
	public void setStrFinEndDate(String strFinEndDate) {
		this.strFinEndDate = strFinEndDate;
	}

	/**
	 * Sets the str fin start date.
	 * 
	 * @param strFinStartDate the str fin start date
	 */
	public void setStrFinStartDate(String strFinStartDate) {
		this.strFinStartDate = strFinStartDate;
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

			strProcName = "{call PKG_MMS_DML.Dml_HSTT_CHALLAN_DTL(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}";  // 34 Variable + 3 added by Shalini in ref to CR 901
			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "modval", "1",1);
			dao.setProcInValue(nProcIndex, "challanNo", strChallanNo,2);
			dao.setProcInValue(nProcIndex, "po_No", strPoNo,3);
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,4);
			dao.setProcInValue(nProcIndex, "cat_Code", strItemCategoryId,5);
			
			dao.setProcInValue(nProcIndex, "store_id", strStoreId,6);
			dao.setProcInValue(nProcIndex, "supplier_id", strSupplierId,7);
			dao.setProcInValue(nProcIndex, "awb_No", strAwbNo,8);
			dao.setProcInValue(nProcIndex, "po_Date", strPoDate,9);
			dao.setProcInValue(nProcIndex, "be_No", strBeNo,10);

			dao.setProcInValue(nProcIndex, "be_Date", strBeDate,11);
			dao.setProcInValue(nProcIndex, "packets", strPackets,12);
			dao.setProcInValue(nProcIndex, "pkg_weight", strPacketWeight,13);
			dao.setProcInValue(nProcIndex, "delivery_Date", strDeliveryDate,14);
			dao.setProcInValue(nProcIndex, "delivery_Mode", strDeliverMode,15);

			dao.setProcInValue(nProcIndex, "committee_type", strCommitteeType,16);
			dao.setProcInValue(nProcIndex, "committee_Rmks_SlNo",strCommitteeRemarksSlNo,17);
			dao.setProcInValue(nProcIndex, "committee_No", strCommitteeNo,18);
			dao.setProcInValue(nProcIndex, "challan_Status", strChallanStatus,19);
			dao.setProcInValue(nProcIndex, "fin_start_year", strFinStartDate,20);

			dao.setProcInValue(nProcIndex, "fin_end_year", strFinEndDate,21);
			dao.setProcInValue(nProcIndex, "remarks", strRemarks,22);
			dao.setProcInValue(nProcIndex, "seat_id", strSeatId,23);
			dao.setProcInValue(nProcIndex, "po_store_id", strPoStoreId,24);
			dao.setProcInValue(nProcIndex, "received_By", strReceivedBy,25);

			dao.setProcInValue(nProcIndex, "scheduleNo", strScheduleNo,26);
			dao.setProcInValue(nProcIndex, "scheduleType", strScheduleType,27);
			dao.setProcInValue(nProcIndex, "sup_rec_no", strSupplierReceiptNo,28);
			dao.setProcInValue(nProcIndex, "sup_rec_date", strSupplierReceiptDate,29);
		//	dao.setProcInValue(nProcIndex, "challan_recv_date", strSupplierReceiptDate);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nProcIndex, "strFileNo", strFileNo,30);
			dao.setProcInValue(nProcIndex, "strPageNo", strPageNo,31);
			dao.setProcInValue(nProcIndex, "strFileChallanName", "",32);
			
			
			/* Setting Default Value End */
			
//			dao.setProcInValue(nProcIndex, "billno", strSupplierBillNo);
//			dao.setProcInValue(nProcIndex, "billdt", strSupplierBillDate);
//			dao.setProcInValue(nProcIndex, "suppperiod",strSupplyPeriod);
			dao.setProcOutValue(nProcIndex, "err", 1,33);

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

			strProcName = "{call PKG_MMS_DML.dml_hstt_lpchallan_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}";  // 34 Variable + 3 added by Shalini in ref to CR 901
			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "modval", "1",1);
			dao.setProcInValue(nProcIndex, "challanNo", strChallanNo,2);
			dao.setProcInValue(nProcIndex, "po_No", strPoNo,3);
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,4);
			dao.setProcInValue(nProcIndex, "cat_Code", strItemCategoryId,5);
			
			dao.setProcInValue(nProcIndex, "store_id", strStoreId,6);
			dao.setProcInValue(nProcIndex, "supplier_id", strSupplierId,7);
			dao.setProcInValue(nProcIndex, "awb_No", strAwbNo,8);
			dao.setProcInValue(nProcIndex, "po_Date", strPoDate,9);
			dao.setProcInValue(nProcIndex, "be_No", strBeNo,10);

			dao.setProcInValue(nProcIndex, "be_Date", strBeDate,11);
			dao.setProcInValue(nProcIndex, "packets", strPackets,12);
			dao.setProcInValue(nProcIndex, "pkg_weight", strPacketWeight,13);
			dao.setProcInValue(nProcIndex, "delivery_Date", strDeliveryDate,14);
			dao.setProcInValue(nProcIndex, "delivery_Mode", strDeliverMode,15);

			dao.setProcInValue(nProcIndex, "committee_type", strCommitteeType,16);
			dao.setProcInValue(nProcIndex, "committee_Rmks_SlNo",strCommitteeRemarksSlNo,17);
			dao.setProcInValue(nProcIndex, "committee_No", strCommitteeNo,18);
			dao.setProcInValue(nProcIndex, "challan_Status", strChallanStatus,19);
			dao.setProcInValue(nProcIndex, "fin_start_year", strFinStartDate,20);

			dao.setProcInValue(nProcIndex, "fin_end_year", strFinEndDate,21);
			dao.setProcInValue(nProcIndex, "remarks", strRemarks,22);
			dao.setProcInValue(nProcIndex, "seat_id", strSeatId,23);
			dao.setProcInValue(nProcIndex, "po_store_id", strPoStoreId,24);
			dao.setProcInValue(nProcIndex, "received_By", strReceivedBy,25);

			dao.setProcInValue(nProcIndex, "scheduleNo", strScheduleNo,26);
			dao.setProcInValue(nProcIndex, "scheduleType", strScheduleType,27);
			dao.setProcInValue(nProcIndex, "sup_rec_no", strSupplierReceiptNo,28);
			dao.setProcInValue(nProcIndex, "sup_rec_date", strSupplierReceiptDate,29);
		//	dao.setProcInValue(nProcIndex, "challan_recv_date", strSupplierReceiptDate);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nProcIndex, "strFileNo", "",30);
			dao.setProcInValue(nProcIndex, "strPageNo", "",31);
			dao.setProcInValue(nProcIndex, "strFileChallanName", "",32);
			/* Setting Default Value End */
			
//			dao.setProcInValue(nProcIndex, "billno", strSupplierBillNo);
//			dao.setProcInValue(nProcIndex, "billdt", strSupplierBillDate);
//			dao.setProcInValue(nProcIndex, "suppperiod",strSupplyPeriod);
			dao.setProcOutValue(nProcIndex, "err", 1,33);

			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			// this.reset(); // to reset the variables
		}

	}
	
	
	// for cancellation
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
				strProcName = "{call PKG_MMS_DML.Dml_HSTT_CHALLAN_DTL(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}";	//34 Variable--33
				nProcIndex = dao.setProcedure(strProcName);
			}

			dao.setProcInValue(nProcIndex, "modval", "3",1);
			dao.setProcInValue(nProcIndex, "challanNo", strChallanNo,2);
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,4);
			dao.setProcInValue(nProcIndex, "store_id", strStoreId,6);

			/* Setting Default Value Start*/
			dao.setProcInValue(nProcIndex, "po_No", "",3);
			
			
			
			dao.setProcInValue(nProcIndex, "cat_Code", "0",5);
			dao.setProcInValue(nProcIndex, "supplier_id", "",7);
			dao.setProcInValue(nProcIndex, "awb_No", "",8);
			dao.setProcInValue(nProcIndex, "po_Date", "",9);
			dao.setProcInValue(nProcIndex, "be_No", "",10);
			
			dao.setProcInValue(nProcIndex, "be_Date", "",11);
			dao.setProcInValue(nProcIndex, "packets", "",12);
			dao.setProcInValue(nProcIndex, "pkg_weight", "",13);
			dao.setProcInValue(nProcIndex, "delivery_Date", "",14);
			dao.setProcInValue(nProcIndex, "delivery_Mode", "",15);
			
			dao.setProcInValue(nProcIndex, "committee_type", "",16);
			dao.setProcInValue(nProcIndex, "committee_Rmks_SlNo", "",17);
			dao.setProcInValue(nProcIndex, "committee_No", "",18);
			dao.setProcInValue(nProcIndex, "challan_Status", "",19);
			dao.setProcInValue(nProcIndex, "fin_start_year", "",20);
			
			dao.setProcInValue(nProcIndex, "fin_end_year", "",21);
			dao.setProcInValue(nProcIndex, "remarks", "",22);
			dao.setProcInValue(nProcIndex, "seat_id", "",23);
			dao.setProcInValue(nProcIndex, "po_store_id", "",24);
			dao.setProcInValue(nProcIndex, "received_By", "",25);
			
			dao.setProcInValue(nProcIndex, "scheduleNo", "0",26);
			dao.setProcInValue(nProcIndex, "scheduleType", "0",27);
			dao.setProcInValue(nProcIndex, "sup_rec_no", "0",28);
			dao.setProcInValue(nProcIndex, "sup_rec_date", "",29);
			//dao.setProcInValue(nProcIndex, "challan_recv_date", "");
			
			dao.setProcInValue(nProcIndex, "strFileNo", "",30);
			dao.setProcInValue(nProcIndex, "strPageNo", "",31);
			dao.setProcInValue(nProcIndex, "strFileChallanName", "",32);
			/* Setting Default Value End */
			
			dao.setProcOutValue(nProcIndex, "err", 1,33);

			dao.execute(nProcIndex, 1);
			this.nRowUpdated++;
		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update() --> " + this.strErr);
		} finally {
			// this.reset(); // to reset the variables
		}

	}
	
	// for cancellation
	public void updateCancelVerifiedChallanDetails(HisDAO dao) throws Exception {

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}

			if (nInsertedIndex == 0) {
				strProcName = "{call PKG_MMS_DML.Dml_HSTT_CHALLAN_DTL(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}";	// 34 variable--33
				nProcIndex = dao.setProcedure(strProcName);
			}

			dao.setProcInValue(nProcIndex, "modval", "5",1);
			dao.setProcInValue(nProcIndex, "challanNo", strChallanNo,2);
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,4);
			dao.setProcInValue(nProcIndex, "store_id", strStoreId,6);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nProcIndex, "po_No", "",3);
			
			
			
			dao.setProcInValue(nProcIndex, "cat_Code", "0",5);
			dao.setProcInValue(nProcIndex, "supplier_id", "",7);
			dao.setProcInValue(nProcIndex, "awb_No", "",8);
			dao.setProcInValue(nProcIndex, "po_Date", "",9);
			dao.setProcInValue(nProcIndex, "be_No", "",10);
			
			dao.setProcInValue(nProcIndex, "be_Date", "",11);
			dao.setProcInValue(nProcIndex, "packets", "",12);
			dao.setProcInValue(nProcIndex, "pkg_weight", "",13);
			dao.setProcInValue(nProcIndex, "delivery_Date", "",14);
			dao.setProcInValue(nProcIndex, "delivery_Mode", "",15);
			
			dao.setProcInValue(nProcIndex, "committee_type", "",16);
			dao.setProcInValue(nProcIndex, "committee_Rmks_SlNo", "",17);
			dao.setProcInValue(nProcIndex, "committee_No", "",18);
			dao.setProcInValue(nProcIndex, "challan_Status", "",19);
			dao.setProcInValue(nProcIndex, "fin_start_year", "",20);
			
			dao.setProcInValue(nProcIndex, "fin_end_year", "",21);
			dao.setProcInValue(nProcIndex, "remarks", "",22);
			dao.setProcInValue(nProcIndex, "seat_id", "",23);
			dao.setProcInValue(nProcIndex, "po_store_id", "",24);
			dao.setProcInValue(nProcIndex, "received_By", "",25);
			
			dao.setProcInValue(nProcIndex, "scheduleNo", "0",26);
			dao.setProcInValue(nProcIndex, "scheduleType", "0",27);
			dao.setProcInValue(nProcIndex, "sup_rec_no", "0",28);
			dao.setProcInValue(nProcIndex, "sup_rec_date", "",29);
			//dao.setProcInValue(nProcIndex, "challan_recv_date", "");
			
			dao.setProcInValue(nProcIndex, "strFileNo", "",30);
			dao.setProcInValue(nProcIndex, "strPageNo", "",31);
			dao.setProcInValue(nProcIndex, "strFileChallanName", "",32);
			/* Setting Default Value End */
			
			dao.setProcOutValue(nProcIndex, "err", 1,33);

			dao.execute(nProcIndex, 1);
			this.nRowUpdated++;
		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update() --> " + this.strErr);
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
				strProcName = "{call PKG_MMS_DML.Dml_HSTT_CHALLAN_DTL(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}";	//34 variable--33
				nProcIndex = dao.setProcedure(strProcName);
			}
			//System.out.println("strFileNo:::"+strFileNo);
			//System.out.println("strPageNo:::"+strPageNo);
			//System.out.println("strFileChallanName:::"+strFileChallanName);
			dao.setProcInValue(nProcIndex, "modval", "4",1);
			dao.setProcInValue(nProcIndex, "committee_type", strCommitteeType,16);
			dao.setProcInValue(nProcIndex, "committee_Rmks_SlNo", strCommitteeRemarksSlNo,17);
			dao.setProcInValue(nProcIndex, "committee_No", strCommitteeNo,18);
			dao.setProcInValue(nProcIndex, "challanNo", strChallanNo,2);
			
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,4);
			dao.setProcInValue(nProcIndex, "store_id", strStoreId,6);
			dao.setProcInValue(nProcIndex, "strFileNo",strFileNo,30);                                   
			dao.setProcInValue(nProcIndex, "strPageNo",strPageNo,31);                      
			dao.setProcInValue(nProcIndex, "strFileChallanName",strFileChallanName,32);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nProcIndex, "po_No", "",3);
			
			
			
			dao.setProcInValue(nProcIndex, "cat_Code", "0",5);
			dao.setProcInValue(nProcIndex, "supplier_id", "",7);
			dao.setProcInValue(nProcIndex, "awb_No", "",8);
			dao.setProcInValue(nProcIndex, "po_Date", "",9);
			dao.setProcInValue(nProcIndex, "be_No", "",10);
			
			dao.setProcInValue(nProcIndex, "be_Date", "",11);
			dao.setProcInValue(nProcIndex, "packets", "",12);
			dao.setProcInValue(nProcIndex, "pkg_weight", "",13);
			dao.setProcInValue(nProcIndex, "delivery_Date", "",14);
			dao.setProcInValue(nProcIndex, "delivery_Mode", "",15);
			
			dao.setProcInValue(nProcIndex, "challan_Status", "",19);
			dao.setProcInValue(nProcIndex, "fin_start_year", "",20);
			
			dao.setProcInValue(nProcIndex, "fin_end_year", "",21);
			dao.setProcInValue(nProcIndex, "remarks", "",22);
			dao.setProcInValue(nProcIndex, "seat_id", "",23);
			dao.setProcInValue(nProcIndex, "po_store_id", "",24);
			dao.setProcInValue(nProcIndex, "received_By", "",25);
			
			dao.setProcInValue(nProcIndex, "scheduleNo", "0",26);
			dao.setProcInValue(nProcIndex, "scheduleType", "0",27);
			dao.setProcInValue(nProcIndex, "sup_rec_no", "0",28);
			dao.setProcInValue(nProcIndex, "sup_rec_date", "",29);
			//dao.setProcInValue(nProcIndex, "challan_recv_date", "");
			
		
			/* Setting Default Value End */
			
			dao.setProcOutValue(nProcIndex, "err", 1,33);

			dao.execute(nProcIndex, 1);
			this.nRowUpdated++;
		} catch (Exception e) {
			e.printStackTrace();
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update2() --> " + this.strErr);
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
		strSupplierId = "";
		strAwbNo = "";
		strPoDate = "";
		strPoStoreId = "";
		strBeNo = "";
		strBeDate = "";
		strPackets = "";
		strPacketWeight = "";
		strDeliveryDate = "";
		strDeliverMode = "";
		strCommitteeType = "";
		strCommitteeRemarksSlNo = "";
		strCommitteeNo = "";
		strChallanStatus = "";
		strItemCategoryId = "";
		strFinEndDate = "";
		strFinStartDate = "";
		strRemarks = "";
		strSeatId = "";
		strHospitalCode = "";
		strSupplierReceiptNo = "";
		strSupplierReceiptDate = "";

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
	 * Sets the str supplier id.
	 * 
	 * @param strSupplierId the new str supplier id
	 */
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}

	/**
	 * Sets the str awb no.
	 * 
	 * @param strAwbNo the new str awb no
	 */
	public void setStrAwbNo(String strAwbNo) {
		this.strAwbNo = strAwbNo;
	}

	/**
	 * Sets the str po date.
	 * 
	 * @param strPoDate the new str po date
	 */
	public void setStrPoDate(String strPoDate) {
		this.strPoDate = strPoDate;
	}

	/**
	 * Sets the str be no.
	 * 
	 * @param strBeNo the new str be no
	 */
	public void setStrBeNo(String strBeNo) {
		this.strBeNo = strBeNo;
	}

	/**
	 * Sets the str be date.
	 * 
	 * @param strBeDate the new str be date
	 */
	public void setStrBeDate(String strBeDate) {
		this.strBeDate = strBeDate;
	}

	/**
	 * Sets the str packets.
	 * 
	 * @param strPackets the new str packets
	 */
	public void setStrPackets(String strPackets) {
		this.strPackets = strPackets;
	}

	/**
	 * Sets the str packet weight.
	 * 
	 * @param strPacketWeight the new str packet weight
	 */
	public void setStrPacketWeight(String strPacketWeight) {
		this.strPacketWeight = strPacketWeight;
	}

	/**
	 * Sets the str delivery date.
	 * 
	 * @param strDeliveryDate the new str delivery date
	 */
	public void setStrDeliveryDate(String strDeliveryDate) {
		this.strDeliveryDate = strDeliveryDate;
	}

	/**
	 * Sets the str deliver mode.
	 * 
	 * @param strDeliverMode the new str deliver mode
	 */
	public void setStrDeliverMode(String strDeliverMode) {
		this.strDeliverMode = strDeliverMode;
	}

	/**
	 * Sets the str committee type.
	 * 
	 * @param strCommitteeType the new str committee type
	 */
	public void setStrCommitteeType(String strCommitteeType) {
		this.strCommitteeType = strCommitteeType;
	}

	/**
	 * Sets the str committee remarks sl no.
	 * 
	 * @param strCommitteeRemarksSlNo the new str committee remarks sl no
	 */
	public void setStrCommitteeRemarksSlNo(String strCommitteeRemarksSlNo) {
		this.strCommitteeRemarksSlNo = strCommitteeRemarksSlNo;
	}

	/**
	 * Sets the str committee no.
	 * 
	 * @param strCommitteeNo the new str committee no
	 */
	public void setStrCommitteeNo(String strCommitteeNo) {
		this.strCommitteeNo = strCommitteeNo;
	}

	/**
	 * Sets the str challan status.
	 * 
	 * @param strChallanStatus the new str challan status
	 */
	public void setStrChallanStatus(String strChallanStatus) {
		this.strChallanStatus = strChallanStatus;
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
	 * Sets the str received by.
	 * 
	 * @param strReceivedBy the new str received by
	 */
	public void setStrReceivedBy(String strReceivedBy) {
		this.strReceivedBy = strReceivedBy;
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

	public void setStrSupplierReceiptNo(String strSupplierReceiptNo) {
		this.strSupplierReceiptNo = strSupplierReceiptNo;
	}

	public void setStrSupplierReceiptDate(String strSupplierReceiptDate) {
		this.strSupplierReceiptDate = strSupplierReceiptDate;
	}
	
	public void setStrChallanReceivedDate(String strChallanReceivedDate) {
		this.strChallanReceivedDate = strChallanReceivedDate;
	}

	public void setStrFileNo(String strFileNo) {
		this.strFileNo = strFileNo;
	}

	public void setStrPageNo(String strPageNo) {
		this.strPageNo = strPageNo;
	}

	public void setStrFileChallanName(String strFileChallanName) {
		this.strFileChallanName = strFileChallanName;
	}

	public String getStrSupplierBillNo() {
		return strSupplierBillNo;
	}

	public void setStrSupplierBillNo(String strSupplierBillNo) {
		this.strSupplierBillNo = strSupplierBillNo;
	}

	public String getStrSupplierBillDate() {
		return strSupplierBillDate;
	}

	public void setStrSupplierBillDate(String strSupplierBillDate) {
		this.strSupplierBillDate = strSupplierBillDate;
	}

	public String getStrSupplyPeriod() {
		return strSupplyPeriod;
	}

	public void setStrSupplyPeriod(String strSupplyPeriod) {
		this.strSupplyPeriod = strSupplyPeriod;
	}
}
