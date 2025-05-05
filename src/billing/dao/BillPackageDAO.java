package billing.dao;

import hisglobal.transactionmgnt.HisDAO;

/**
 * Developer : Anshul Jindal
 * Version : 1.0 
 * Date : 20/Aug/2008
 * 
 * This class will be used to insert/update/delete the records 
 * Table Name : Hblt_Bill_Package_Dtl
 * Procedure Name : PKG_BILL_DML.dml_Hblt_Bill_Package_Dtl
 */

public class BillPackageDAO {
	
	private String strBillNo = "0";
	private String strPackageId = "0";
	private String strPatientCatCode = "0";
	private String strRateUnitId = "0";
	private String strPuk = "0";
	private String strGroupId = "0";
	private String strRemainedQty = "0";
	private String strBillQty = "0";
	private String strTariffRate = "0";
	private String strTariffActualRate = "0";
	private String strStatus = "1";
	private String strEntryDate = "";
	private String strSeatId = "0";
	private String strRemarks = "0";
	private String strIsRefundable = "0";
	private String strIsValid = "0";
	private String strQtyUnitId = "0";
	private String strProcessedQty = "0";
	private String strReceiptNo = "1";
	private String strReceiptType = "1";
	private String strTariffId = "0";
	private String strPackageQty = "1";
	private String strDiscountAmount = "0";
	private String strServTaxAmt = "0";
	private String strpenaltyAmt = "0";
	private String strRefBillNo = "0";
	private String strRefReciptNo = "0";
	private String strHospitalCode = "0";
	
	// It is mandatory parameter, do not reset the following variables
	private String strErr = "";

	private final String strProcName = "PKG_BILL_DML.dml_Hblt_Bill_Package_Dtl";
	private final String strFileName = "billing.dao.BillPackageDAO";

	private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;

	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;

	/**
	 * @return Returns the strErr.
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * @return Returns the nDeletedIndex.
	 */
	public int getNDeletedIndex() {
		return nDeletedIndex;
	}

	/**
	 * @return Returns the nInsertedIndex.
	 */
	public int getNInsertedIndex() {
		return nInsertedIndex;
	}

	/**
	 * @return Returns the nRowDeleted.
	 */
	public int getNRowDeleted() {
		return nRowDeleted;
	}

	/**
	 * @return Returns the nRowInserted.
	 */
	public int getNRowInserted() {
		return nRowInserted;
	}

	/**
	 * @return Returns the nRowUpdated.
	 */
	public int getNRowUpdated() {
		return nRowUpdated;
	}

	/**
	 * @return Returns the nUpdatedIndex.
	 */
	public int getNUpdatedIndex() {
		return nUpdatedIndex;
	}

	/**
	 * @return Returns the strFileName.
	 */
	public String getStrFileName() {
		return strFileName;
	}

	/**
	 * @return Returns the strProcName.
	 */
	public String getStrProcName() {
		return strProcName;
	}
	/**
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * @param strRefBillNo
	 *            the strRefBillNo to set
	 */
	public void setStrRefBillNo(String strRefBillNo) {
		this.strRefBillNo = strRefBillNo;
	}

	/**
	 * @param strRefReciptNo
	 *            the strRefReciptNo to set
	 */
	public void setStrRefReciptNo(String strRefReciptNo) {
		this.strRefReciptNo = strRefReciptNo;
	}
	
	/**
	 * @param strBillNo the strBillNo to set
	 */
	public void setStrBillNo(String strBillNo) {
		this.strBillNo = strBillNo;
	}

	/**
	 * @param strPackageId the strPackageId to set
	 */
	public void setStrPackageId(String strPackageId) {
		this.strPackageId = strPackageId;
	}

	/**
	 * @param strPatientCatCode the strPatientCatCode to set
	 */
	public void setStrPatientCatCode(String strPatientCatCode) {
		this.strPatientCatCode = strPatientCatCode;
	}

	/**
	 * @param strRateUnitId the strRateUnitId to set
	 */
	public void setStrRateUnitId(String strRateUnitId) {
		this.strRateUnitId = strRateUnitId;
	}

	/**
	 * @param strPuk the strPuk to set
	 */
	public void setStrPuk(String strPuk) {
		this.strPuk = strPuk;
	}

	/**
	 * @param strGroupId the strGroupId to set
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	/**
	 * @param strRemainedQty the strRemainedQty to set
	 */
	public void setStrRemainedQty(String strRemainedQty) {
		this.strRemainedQty = strRemainedQty;
	}

	/**
	 * @param strBillQty the strBillQty to set
	 */
	public void setStrBillQty(String strBillQty) {
		this.strBillQty = strBillQty;
	}

	/**
	 * @param strTariffRate the strTariffRate to set
	 */
	public void setStrTariffRate(String strTariffRate) {
		this.strTariffRate = strTariffRate;
	}

	/**
	 * @param strTariffActualRate the strTariffActualRate to set
	 */
	public void setStrTariffActualRate(String strTariffActualRate) {
		this.strTariffActualRate = strTariffActualRate;
	}

	/**
	 * @param strStatus the strStatus to set
	 */
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}

	/**
	 * @param strEntryDate the strEntryDate to set
	 */
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}

	/**
	 * @param strSeatId the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * @param strIsRefundable the strIsRefundable to set
	 */
	public void setStrIsRefundable(String strIsRefundable) {
		this.strIsRefundable = strIsRefundable;
	}

	/**
	 * @param strIsValid the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	/**
	 * @param strQtyUnitId the strQtyUnitId to set
	 */
	public void setStrQtyUnitId(String strQtyUnitId) {
		this.strQtyUnitId = strQtyUnitId;
	}

	/**
	 * @param strProcessedQty the strProcessedQty to set
	 */
	public void setStrProcessedQty(String strProcessedQty) {
		this.strProcessedQty = strProcessedQty;
	}

	/**
	 * @param strRecieptNo the strRecieptNo to set
	 */
	public void setStrReceiptNo(String strReceiptNo) {
		this.strReceiptNo = strReceiptNo;
	}

	/**
	 * @param strReceiptType the strReceiptType to set
	 */
	public void setStrReceiptType(String strReceiptType) {
		this.strReceiptType = strReceiptType;
	}

	/**
	 * @param strTariffId the strTariffId to set
	 */
	public void setStrTariffId(String strTariffId) {
		this.strTariffId = strTariffId;
	}

	/**
	 * @param strPackageQty the strPackageQty to set
	 */
	public void setStrPackageQty(String strPackageQty) {
		this.strPackageQty = strPackageQty;
	}

	/**
	 * @param strDiscountAmount the strDiscountAmount to set
	 */
	public void setStrDiscountAmount(String strDiscountAmount) {
		this.strDiscountAmount = strDiscountAmount;
	}

	/**
	 * @param strServTaxAmt the strServTaxAmt to set
	 */
	public void setStrServTaxAmt(String strServTaxAmt) {
		this.strServTaxAmt = strServTaxAmt;
	}

	/**
	 * @param strPeneltyAmt the strPeneltyAmt to set
	 */
	public void setStrPeneltyAmt(String strpenaltyAmt) {
		this.strpenaltyAmt = strpenaltyAmt;
	}

	
	
	// Methods starts from here

	/**
	 * This method will be used to insert the records 
	 * 
	 * @param dao :
	 *            HisDAO Object
	 * @throws Exception -
	 *             when BillNo. or Package Id or Tariff Id or Receipt No. is blank
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";

		try {
			// check mandatory information
			if (strBillNo.equals("0") || strBillNo.equals("")) {
				throw new Exception("BillNo. can not be blank");
			}
			
			if (strPackageId.equals("0") || strPackageId.equals("")) {
				throw new Exception("Package Id can not be blank");
			}
			
			if (strTariffId.equals("0") || strTariffId.equals("")) {
				throw new Exception("SerialNo. can not be blank");
			}

			if (strReceiptNo.equals("0") || strReceiptNo.equals("")) {
				throw new Exception("ReceiptNo. can not be blank");
			}

			if (this.nRowInserted == 0) {
				nInsertedIndex = dao.setProcedure("{call " + strProcName
						+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}

			// set the value
			// Input Value
			dao.setProcInValue(nInsertedIndex, "modval", "1");

			dao.setProcInValue(nInsertedIndex, "hblnum_bill_no", strBillNo);
			dao.setProcInValue(nInsertedIndex, "hblnum_package_id", strTariffId);
			dao.setProcInValue(nInsertedIndex, "gnum_patient_cat_code",
					strPatientCatCode);
			dao.setProcInValue(nInsertedIndex, "gnum_rate_unit_id", strRateUnitId);
			dao.setProcInValue(nInsertedIndex, "hrgnum_puk", strPuk);
			dao.setProcInValue(nInsertedIndex, "hblnum_group_id", strGroupId);
			dao.setProcInValue(nInsertedIndex, "hblnum_remained_qty",
					strRemainedQty);
			dao.setProcInValue(nInsertedIndex, "hblnum_bill_qty	", strBillQty);
			dao.setProcInValue(nInsertedIndex, "hblnum_tariff_rate",
					strTariffRate);
			dao.setProcInValue(nInsertedIndex, "hblnum_tariff_actual_rate",
					strTariffActualRate);
			dao.setProcInValue(nInsertedIndex, "hblnum_status", strStatus);
			dao.setProcInValue(nInsertedIndex, "gdt_entry_date", strEntryDate);
			dao.setProcInValue(nInsertedIndex, "gnum_seatid", strSeatId);
			dao.setProcInValue(nInsertedIndex, "hblstr_remarks", strRemarks);
			dao.setProcInValue(nInsertedIndex, "hblnum_is_refundable",
					strIsRefundable);
			dao.setProcInValue(nInsertedIndex, "gnum_isvalid", strIsValid);
			dao
			.setProcInValue(nInsertedIndex, "gnum_qty_unit_id",
					strQtyUnitId);
			dao.setProcInValue(nInsertedIndex, "hblnum_processed_qty",
					strProcessedQty);
			dao.setProcInValue(nInsertedIndex, "hblnum_reciept_no",
					strReceiptNo);
			dao.setProcInValue(nInsertedIndex, "hblnum_reciept_type",
					strReceiptType);
			dao.setProcInValue(nInsertedIndex, "hblnum_tariff_id",
					strTariffId);
			dao.setProcInValue(nInsertedIndex, "hblnum_package_qty",
					strPackageQty);
			dao.setProcInValue(nInsertedIndex, "hblnum_discount_amt",
					strDiscountAmount);
			dao.setProcInValue(nInsertedIndex, "hblnum_sertax_amt",
					strServTaxAmt);
			dao.setProcInValue(nInsertedIndex, "hblnum_penelty_amt",
					strpenaltyAmt);
			dao.setProcInValue(nInsertedIndex, "hblnum_ref_bill_no",
					strRefBillNo);
			
			dao.setProcInValue(nInsertedIndex, "hblnum_ref_reciept_no",
					strRefReciptNo);
			dao.setProcInValue(nInsertedIndex,"hosp_code",strHospitalCode);  // New Value

			// output value
			dao.setProcOutValue(nInsertedIndex, "err", 1);

			// keep in batch
			dao.execute(nInsertedIndex, 1);
			this.nRowInserted++;
		} catch (Exception e) {
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}
	}

	/**
	 * This method will be used to insert the records 
	 * 
	 * @param dao :
	 *            HisDAO Object
	 * @throws Exception -
	 *             when BillNo. or Package Id or Tariff Id or Receipt No. is blank
	 */
	public void update(HisDAO dao) throws Exception {

		strErr = "";

		try {
			// check mandatory information
			if (strBillNo.equals("0") || strBillNo.equals("")) {
				throw new Exception("BillNo. can not be blank");
			}
			
			if (strPackageId.equals("0") || strPackageId.equals("")) {
				throw new Exception("Package Id can not be blank");
			}
			
			if (strTariffId.equals("0") || strTariffId.equals("")) {
				throw new Exception("Tariff Id can not be blank");
			}

			if (strReceiptNo.equals("0") || strReceiptNo.equals("")) {
				throw new Exception("ReceiptNo. can not be blank");
			}

			if (this.nRowUpdated == 0) 
			{
				nUpdatedIndex = dao.setProcedure("{call " + strProcName
						+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				
					
			}

			// set the value
			// Input Value
			dao.setProcInValue(nUpdatedIndex, "modval", "2");
    		dao.setProcInValue(nUpdatedIndex, "hblnum_bill_no", strBillNo);
			dao.setProcInValue(nUpdatedIndex, "hblnum_package_id", strTariffId);
			dao.setProcInValue(nUpdatedIndex, "hblnum_remained_qty",strRemainedQty);
			dao.setProcInValue(nUpdatedIndex, "hblnum_reciept_no",strReceiptNo);
			dao.setProcInValue(nUpdatedIndex, "hblnum_tariff_id",strTariffId);
			dao.setProcInValue(nUpdatedIndex, "gnum_qty_unit_id",strQtyUnitId);
			dao.setProcInValue(nUpdatedIndex, "gnum_patient_cat_code",strPatientCatCode);
			dao.setProcInValue(nUpdatedIndex, "gnum_rate_unit_id", strRateUnitId);
			dao.setProcInValue(nUpdatedIndex, "hrgnum_puk", strPuk);
			dao.setProcInValue(nUpdatedIndex, "hblnum_group_id", strGroupId);
			dao.setProcInValue(nUpdatedIndex, "hblnum_bill_qty	", strBillQty);
			dao.setProcInValue(nUpdatedIndex, "hblnum_tariff_rate",	strTariffRate);
			dao.setProcInValue(nUpdatedIndex, "hblnum_tariff_actual_rate",strTariffActualRate);
			dao.setProcInValue(nUpdatedIndex, "hblnum_status", strStatus);
			dao.setProcInValue(nUpdatedIndex, "gdt_entry_date", strEntryDate);
			dao.setProcInValue(nUpdatedIndex, "gnum_seatid", strSeatId);
			dao.setProcInValue(nUpdatedIndex, "hblstr_remarks", strRemarks);
			dao.setProcInValue(nUpdatedIndex, "hblnum_is_refundable",strIsRefundable);
			dao.setProcInValue(nUpdatedIndex, "gnum_isvalid", strIsValid);
			dao.setProcInValue(nUpdatedIndex, "hblnum_processed_qty",strProcessedQty);
			dao.setProcInValue(nUpdatedIndex, "hblnum_reciept_type",strReceiptType);
			dao.setProcInValue(nUpdatedIndex, "hblnum_package_qty",	strPackageQty);
			dao.setProcInValue(nUpdatedIndex, "hblnum_discount_amt",strDiscountAmount);
			dao.setProcInValue(nUpdatedIndex, "hblnum_sertax_amt",strServTaxAmt);
			dao.setProcInValue(nUpdatedIndex, "hblnum_penelty_amt",	strpenaltyAmt);
			dao.setProcInValue(nUpdatedIndex, "hblnum_ref_bill_no",	strRefBillNo);
			dao.setProcInValue(nUpdatedIndex, "hblnum_ref_reciept_no",strRefReciptNo);
			
			dao.setProcInValue(nUpdatedIndex, "hosp_code",strHospitalCode);  // New Value
			// output value
			dao.setProcOutValue(nUpdatedIndex, "err", 1);
			

			// keep in batch
			dao.execute(nUpdatedIndex, 1);
			this.nRowUpdated++;
		} catch (Exception e) {
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}
	}
	
	
	
	/**
	 * This method will be used to insert the records 
	 * 
	 * @param dao :
	 *            HisDAO Object
	 * @throws Exception -
	 *             when BillNo. or Package Id or Tariff Id or Receipt No. is blank
	 */
	public void update1(HisDAO dao) throws Exception {

		strErr = "";

		try {
			// check mandatory information
			if (strBillNo.equals("0") || strBillNo.equals("")) {
				throw new Exception("BillNo. can not be blank");
			}
			
			if (strPackageId.equals("0") || strPackageId.equals("")) {
				throw new Exception("Package Id can not be blank");
			}
			
			if (strTariffId.equals("0") || strTariffId.equals("")) {
				throw new Exception("Tariff Id can not be blank");
			}

			if (strReceiptNo.equals("0") || strReceiptNo.equals("")) {
				throw new Exception("ReceiptNo. can not be blank");
			}

			if (this.nRowUpdated == 0) 
			{
//				nUpdatedIndex = dao.setProcedure("{call " + strProcName
//						+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				
				nUpdatedIndex = dao.setProcedure("{call " + strProcName
						+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				
			}

			// set the value
			// Input Value
			dao.setProcInValue(nUpdatedIndex, "modval", "2");
						
			dao.setProcInValue(nUpdatedIndex, "gnum_patient_cat_code","");
			dao.setProcInValue(nUpdatedIndex, "gnum_rate_unit_id", "");
			dao.setProcInValue(nUpdatedIndex, "hrgnum_puk", "");
			dao.setProcInValue(nUpdatedIndex, "hblnum_group_id", "");
			dao.setProcInValue(nUpdatedIndex, "hblnum_bill_qty	", "");
			dao.setProcInValue(nUpdatedIndex, "hblnum_tariff_rate",	"");
			dao.setProcInValue(nUpdatedIndex, "hblnum_tariff_actual_rate", "");
			dao.setProcInValue(nUpdatedIndex, "hblnum_status", "");
			dao.setProcInValue(nUpdatedIndex, "gdt_entry_date", "");
			dao.setProcInValue(nUpdatedIndex, "gnum_seatid", "");
			dao.setProcInValue(nUpdatedIndex, "hblstr_remarks", "");
			dao.setProcInValue(nUpdatedIndex, "hblnum_is_refundable","");
			dao.setProcInValue(nUpdatedIndex, "gnum_isvalid", "");
			dao.setProcInValue(nUpdatedIndex, "hblnum_processed_qty","");
			dao.setProcInValue(nUpdatedIndex, "hblnum_reciept_type","");
			dao.setProcInValue(nUpdatedIndex, "hblnum_package_qty",	"");
			dao.setProcInValue(nUpdatedIndex, "hblnum_discount_amt","");
			dao.setProcInValue(nUpdatedIndex, "hblnum_sertax_amt","");
			dao.setProcInValue(nUpdatedIndex, "hblnum_penelty_amt",	"");
			dao.setProcInValue(nUpdatedIndex, "hblnum_ref_bill_no",	"");
			dao.setProcInValue(nUpdatedIndex, "hblnum_ref_reciept_no","");
			
					
			
    		dao.setProcInValue(nUpdatedIndex, "hblnum_bill_no", strBillNo);
			dao.setProcInValue(nUpdatedIndex, "hblnum_package_id", strTariffId);
			dao.setProcInValue(nUpdatedIndex, "hblnum_remained_qty",strRemainedQty);
			dao.setProcInValue(nUpdatedIndex, "hblnum_reciept_no",strReceiptNo);
			dao.setProcInValue(nUpdatedIndex, "hblnum_tariff_id",strTariffId);
			dao.setProcInValue(nUpdatedIndex, "gnum_qty_unit_id",strQtyUnitId);
			dao.setProcInValue(nUpdatedIndex, "hosp_code",strHospitalCode);  // New Value
			// output value
			dao.setProcOutValue(nUpdatedIndex, "err", 1);
			
	
			// keep in batch
			dao.execute(nUpdatedIndex, 1);
			this.nRowUpdated++;
		} catch (Exception e) {
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update1() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}
	}

	
	
	/**
	 * This method will be used to clear all the variables
	 */
	private void reset() {

		 strBillNo = "0";
		 strPackageId = "0";
		 strPatientCatCode = "0";
		 strRateUnitId = "0";
		 strPuk = "0";
		 strGroupId = "0";
		 strRemainedQty = "0";
		 strBillQty = "0";
		 strTariffRate = "0";
		 strTariffActualRate = "0";
		 strStatus = "1";
		 strEntryDate = "";
		 strSeatId = "0";
		 strRemarks = "0";
		 strIsRefundable = "0";
		 strIsValid = "0";
		 strQtyUnitId = "0";
		 strProcessedQty = "0";
		 strReceiptNo = "1";
		 strReceiptType = "1";
		 strTariffId = "0";
		 strPackageQty = "1";
		 strDiscountAmount = "0";
		 strServTaxAmt = "0";
		 strpenaltyAmt = "0";
		 strRefBillNo = "0";
		 strRefReciptNo = "0";
		 strHospitalCode = "0";
	}

	

}
