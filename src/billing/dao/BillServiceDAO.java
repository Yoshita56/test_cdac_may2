package billing.dao;

import hisglobal.transactionmgnt.HisDAO;

/**
 * Developer : Anshul Jindal Version : 1.0 Date : 20/Aug/2008
 * 
 * This class will be used to insert/update/delete the records 
 * Table Name :hblt_bill_service_dtl 
 * Procedure Name : PKG_BILL_DML.dml_hblt_bill_service_dtl
 * 
 */

public class BillServiceDAO {

	private String strBillNo = "0";
	private String strTariffId = "0";
	private String strReceiptNo = "1";
	private String strRateUnitCode = "0";
	private String strServiceTax = "0";
	private String strRecieptDate = "";
	private String strGroupId = "0";
	private String strReceiptType = "1";
	private String strBillQty = "0";
	private String strProcessedQty = "0";
	private String strPatientCatCode = "0";
	private String strStatus = "1";
	private String strBServiceId = "0";
	private String strTariffRate = "0";
	private String strDiscountBy = "";
	private String strRemainedQty = "0";
	private String strTariffActualRate = "0";
	private String strDiscountDate = "0";
	private String strDiscountReason = "";
	private String strDiscountAmount = "0";
	private String strServTaxAmt = "0";
	private String strDiscountUnit = "0";
	private String strRemarks = "";
	private String strDiscountType = "0";
	private String strPuk = "0";
	private String strServiceId = "0";
	private String strGblTariffId = "";
	private String strApprovalId = "0";
	private String strIsValid = "1";
	private String strIsRefundable = "0";
	private String strSeatId = "0";
	private String strEntryDate = "";
	private String strQtyUnitId = "0";
	private String strIsPackage = "0";
	private String strNetAmount = "0";
	private String strPenelty = "0";
	private String strPenaltyAmt = "0";
	private String strRefBillNo = "0";
	private String strRefReciptNo = "0";
	private String strHospitalCode = "0";

	// It is mandatory parameter, do not reset the following variables
	private String strErr = "";

	private final String strProcName = "PKG_BILL_DML.dml_hblt_bill_service_dtl";
	private final String strFileName = "billing.dao.BillServiceDAO";

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
	 * @param strBillNo
	 *            the strBillNo to set
	 */
	public void setStrBillNo(String strBillNo) {
		this.strBillNo = strBillNo;
	}

	/**
	 * @param strTariffId
	 *            the strTariffId to set
	 */
	public void setStrTariffId(String strTariffId) {
		this.strTariffId = strTariffId;
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
	 * @param strRecieptNo
	 *            the strRecieptNo to set
	 */
	public void setStrReceiptNo(String strReceiptNo) {
		this.strReceiptNo = strReceiptNo;
	}

	/**
	 * @param strRateUnitCode
	 *            the strRateUnitCode to set
	 */
	public void setStrRateUnitCode(String strRateUnitCode) {
		this.strRateUnitCode = strRateUnitCode;
	}

	/**
	 * @param strServiceTax
	 *            the strServiceTax to set
	 */
	public void setStrServiceTax(String strServiceTax) {
		this.strServiceTax = strServiceTax;
	}

	/**
	 * @param strRecieptDate
	 *            the strRecieptDate to set
	 */
	public void setStrRecieptDate(String strRecieptDate) {
		this.strRecieptDate = strRecieptDate;
	}

	/**
	 * @param strGroupId
	 *            the strGroupId to set
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	/**
	 * @param strRecieptType
	 *            the strRecieptType to set
	 */
	public void setStrReceiptType(String strReceiptType) {
		this.strReceiptType = strReceiptType;
	}

	/**
	 * @param strBillQty
	 *            the strBillQty to set
	 */
	public void setStrBillQty(String strBillQty) {
		this.strBillQty = strBillQty;
	}

	/**
	 * @param strProcessedQty
	 *            the strProcessedQty to set
	 */
	public void setStrProcessedQty(String strProcessedQty) {
		this.strProcessedQty = strProcessedQty;
	}

	/**
	 * @param strPatientCatCode
	 *            the strPatientCatCode to set
	 */
	public void setStrPatientCatCode(String strPatientCatCode) {
		this.strPatientCatCode = strPatientCatCode;
	}

	/**
	 * @param strStatus
	 *            the strStatus to set
	 */
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}

	/**
	 * @param strBServiceId
	 *            the strBServiceId to set
	 */
	public void setStrBServiceId(String strBServiceId) {
		this.strBServiceId = strBServiceId;
	}

	/**
	 * @param strTariffRate
	 *            the strTariffRate to set
	 */
	public void setStrTariffRate(String strTariffRate) {
		this.strTariffRate = strTariffRate;
	}

	/**
	 * @param strDiscountBy
	 *            the strDiscountBy to set
	 */
	public void setStrDiscountBy(String strDiscountBy) {
		this.strDiscountBy = strDiscountBy;
	}

	/**
	 * @param strRemainedQty
	 *            the strRemainedQty to set
	 */
	public void setStrRemainedQty(String strRemainedQty) {
		this.strRemainedQty = strRemainedQty;
	}

	/**
	 * @param strTariffActualRate
	 *            the strTariffActualRate to set
	 */
	public void setStrTariffActualRate(String strTariffActualRate) {
		this.strTariffActualRate = strTariffActualRate;
	}

	/**
	 * @param strDiscountDate
	 *            the strDiscountDate to set
	 */
	public void setStrDiscountDate(String strDiscountDate) {
		this.strDiscountDate = strDiscountDate;
	}

	/**
	 * @param strDiscountReason
	 *            the strDiscountReason to set
	 */
	public void setStrDiscountReason(String strDiscountReason) {
		this.strDiscountReason = strDiscountReason;
	}

	/**
	 * @param strDiscountAmount
	 *            the strDiscountAmount to set
	 */
	public void setStrDiscountAmount(String strDiscountAmount) {
		this.strDiscountAmount = strDiscountAmount;
	}

	/**
	 * @param strServTaxAmt
	 *            the strServTaxAmt to set
	 */
	public void setStrServTaxAmt(String strServTaxAmt) {
		this.strServTaxAmt = strServTaxAmt;
	}

	/**
	 * @param strDiscountUnit
	 *            the strDiscountUnit to set
	 */
	public void setStrDiscountUnit(String strDiscountUnit) {
		this.strDiscountUnit = strDiscountUnit;
	}

	/**
	 * @param strRemarks
	 *            the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * @param strDiscountType
	 *            the strDiscountType to set
	 */
	public void setStrDiscountType(String strDiscountType) {
		this.strDiscountType = strDiscountType;
	}

	/**
	 * @param strPuk
	 *            the strPuk to set
	 */
	public void setStrPuk(String strPuk) {
		this.strPuk = strPuk;
	}

	/**
	 * @param strServiceId
	 *            the strServiceId to set
	 */
	public void setStrServiceId(String strServiceId) {
		this.strServiceId = strServiceId;
	}

	/**
	 * @param strGblTariffId
	 *            the strGblTariffId to set
	 */
	public void setStrGblTariffId(String strGblTariffId) {
		this.strGblTariffId = strGblTariffId;
	}

	/**
	 * @param strApprovalId
	 *            the strApprovalId to set
	 */
	public void setStrApprovalId(String strApprovalId) {
		this.strApprovalId = strApprovalId;
	}

	/**
	 * @param strIsValid
	 *            the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	/**
	 * @param strIsRefundable
	 *            the strIsRefundable to set
	 */
	public void setStrIsRefundable(String strIsRefundable) {
		this.strIsRefundable = strIsRefundable;
	}

	/**
	 * @param strSeatId
	 *            the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * @param strEntryDate
	 *            the strEntryDate to set
	 */
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}

	/**
	 * @param strQtyUnitId
	 *            the strQtyUnitId to set
	 */
	public void setStrQtyUnitId(String strQtyUnitId) {
		this.strQtyUnitId = strQtyUnitId;
	}

	/**
	 * @param strIsPackage
	 *            the strIsPackage to set
	 */
	public void setStrIsPackage(String strIsPackage) {
		this.strIsPackage = strIsPackage;
	}

	/**
	 * @param strNetAmount
	 *            the strNetAmount to set
	 */
	public void setStrNetAmount(String strNetAmount) {
		this.strNetAmount = strNetAmount;
	}

	/**
	 * @param strPenelty
	 *            the strPenelty to set
	 */
	public void setStrPenelty(String strPenelty) {
		this.strPenelty = strPenelty;
	}

	/**
	 * @param strPeneltyAmt
	 *            the strPeneltyAmt to set
	 */
	public void setStrPenaltyAmt(String strPenaltyAmt) {
		this.strPenaltyAmt = strPenaltyAmt;
	}

	/**
	 * @param strErr
	 *            the strErr to set
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

	// Methods starts from here

	/**
	 * This method will be used to insert the records
	 * 
	 * @param dao :
	 *            HisDAO Object
	 * @throws Exception -
	 *             when BillNo. or Tariff Id or Receipt No. is blank
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";

		try {
			// check mandatory information
			if (strBillNo.equals("0") || strBillNo.equals("")) {
				throw new Exception("BillNo. can not be blank");
			}

			if (strTariffId.equals("0") || strTariffId.equals("")) {
				throw new Exception("SerialNo. can not be blank");
			}

			if (strReceiptNo.equals("0") || strReceiptNo.equals("")) {
				throw new Exception("ReceiptNo. can not be blank");
			}

			if (this.nRowInserted == 0) {
				nInsertedIndex = dao
						.setProcedure("{call "
								+ strProcName
								+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}

			// set the value
			// Input Value
			dao.setProcInValue(nInsertedIndex, "modval", "1");

			dao.setProcInValue(nInsertedIndex, "hblnum_bill_no", strBillNo);
			dao.setProcInValue(nInsertedIndex, "hblnum_tariff_id", strTariffId);
			dao.setProcInValue(nInsertedIndex, "hblnum_reciept_no",
					strReceiptNo);
			dao.setProcInValue(nInsertedIndex, "gnum_rate_unit_code",
					strRateUnitCode);
			dao.setProcInValue(nInsertedIndex, "hblnum_service_tax",
					strServiceTax);
			dao.setProcInValue(nInsertedIndex, "hbldt_reciept_date",
					strRecieptDate);
			dao.setProcInValue(nInsertedIndex, "hblnum_group_id", strGroupId);
			dao.setProcInValue(nInsertedIndex, "hblnum_reciept_type",
					strReceiptType);
			dao.setProcInValue(nInsertedIndex, "hblnum_bill_qty	", strBillQty);
			dao.setProcInValue(nInsertedIndex, "hblnum_processed_qty",
					strProcessedQty);
			dao.setProcInValue(nInsertedIndex, "gnum_patient_cat_code",
					strPatientCatCode);
			dao.setProcInValue(nInsertedIndex, "hblnum_status", strStatus);
			dao.setProcInValue(nInsertedIndex, "sblnum_bservice_id",
					strBServiceId);
			dao.setProcInValue(nInsertedIndex, "hblnum_tariff_rate",
					strTariffRate);
			dao.setProcInValue(nInsertedIndex, "hblstr_discount_by",
					strDiscountBy);
			dao.setProcInValue(nInsertedIndex, "hblnum_remained_qty",
					strRemainedQty);
			dao.setProcInValue(nInsertedIndex, "hblnum_tariff_actual_rate",
					strTariffActualRate);
			dao.setProcInValue(nInsertedIndex, "hbldt_discount_date",
					strDiscountDate);
			dao.setProcInValue(nInsertedIndex, "hblstr_discount_reason",
					strDiscountReason);
			dao.setProcInValue(nInsertedIndex, "hblnum_discount_amt",
					strDiscountAmount);
			dao.setProcInValue(nInsertedIndex, "hblnum_sertax_amt",
					strServTaxAmt);
			dao.setProcInValue(nInsertedIndex, "hblnum_discount_unit",
					strDiscountUnit);
			dao.setProcInValue(nInsertedIndex, "hblstr_remarks", strRemarks);
			dao.setProcInValue(nInsertedIndex, "hblnum_discount_type",
					strDiscountType);
			dao.setProcInValue(nInsertedIndex, "hrgnum_puk", strPuk);
			dao.setProcInValue(nInsertedIndex, "sblnum_service_id",
					strServiceId);
			dao
					.setProcInValue(nInsertedIndex, "gstr_tariff_id",
							strGblTariffId);
			dao.setProcInValue(nInsertedIndex, "hblnum_approval_id",
					strApprovalId);
			dao.setProcInValue(nInsertedIndex, "gnum_isvalid", strIsValid);
			dao.setProcInValue(nInsertedIndex, "hblnum_is_refundable",
					strIsRefundable);
			dao.setProcInValue(nInsertedIndex, "gnum_seatid", strSeatId);
			dao.setProcInValue(nInsertedIndex, "gdt_entry_date", strEntryDate);
			dao
					.setProcInValue(nInsertedIndex, "gnum_qty_unit_id",
							strQtyUnitId);
			dao.setProcInValue(nInsertedIndex, "hblnum_is_package",
					strIsPackage);
			dao.setProcInValue(nInsertedIndex, "hblnum_net_amount",
					strNetAmount);
			dao.setProcInValue(nInsertedIndex, "hblnum_penelty", strPenelty);
			dao.setProcInValue(nInsertedIndex, "hblnum_penelty_amt",
					strPenaltyAmt);
			
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
	 *             when BillNo. or Tariff Id or Receipt No. is blank
	 */
	public void update(HisDAO dao) throws Exception {

		strErr = "";

		try {
			// check mandatory information
			if (strBillNo.equals("0") || strBillNo.equals("")) {
				throw new Exception("BillNo. can not be blank");
			}

			if (strTariffId.equals("0") || strTariffId.equals("")) {
				throw new Exception("SerialNo. can not be blank");
			}

			if (strReceiptNo.equals("0") || strReceiptNo.equals("")) {
				throw new Exception("ReceiptNo. can not be blank");
			}

			if (this.nRowUpdated == 0) 
			{
				nUpdatedIndex = dao
						.setProcedure("{call "
								+ strProcName
								+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			
			// set the value
			// Input Value
			dao.setProcInValue(nUpdatedIndex, "modval", "2");
    		dao.setProcInValue(nUpdatedIndex, "hblnum_remained_qty",strRemainedQty);
			dao.setProcInValue(nUpdatedIndex, "hblnum_reciept_no", strReceiptNo);
			dao.setProcInValue(nUpdatedIndex, "hblnum_tariff_id", strTariffId);
			dao.setProcInValue(nUpdatedIndex, "hblnum_bill_no", strBillNo);
    		
			dao.setProcInValue(nUpdatedIndex, "gnum_rate_unit_code",strRateUnitCode);
			dao.setProcInValue(nUpdatedIndex, "hblnum_service_tax",strServiceTax);
			dao.setProcInValue(nUpdatedIndex, "hblnum_reciept_date",	strRecieptDate);
			dao.setProcInValue(nUpdatedIndex, "hblnum_group_id", strGroupId);
			dao.setProcInValue(nUpdatedIndex, "hblnum_reciept_type",strReceiptType);
			dao.setProcInValue(nUpdatedIndex, "hblnum_bill_qty", strBillQty);
			dao.setProcInValue(nUpdatedIndex, "hblnum_processed_qty",strProcessedQty);
			dao.setProcInValue(nUpdatedIndex, "gnum_patient_cat_code",	strPatientCatCode);
			
			dao.setProcInValue(nUpdatedIndex, "sblnum_bservice_id",strBServiceId);
			dao.setProcInValue(nUpdatedIndex, "hblnum_tariff_rate",strTariffRate);
			dao.setProcInValue(nUpdatedIndex, "hblstr_discount_by",strDiscountBy);
			dao.setProcInValue(nUpdatedIndex, "hblnum_status",strStatus);
			dao.setProcInValue(nUpdatedIndex, "hblnum_tariff_actual_rate",strTariffActualRate);
			dao.setProcInValue(nUpdatedIndex, "hbldt_discount_date",strDiscountDate);
			dao.setProcInValue(nUpdatedIndex, "hblstr_discount_reason",	strDiscountReason);
			dao.setProcInValue(nUpdatedIndex, "hblnum_discount_amt",strDiscountAmount);
			dao.setProcInValue(nUpdatedIndex, "hblnum_sertax_amt",strServTaxAmt);
			dao.setProcInValue(nUpdatedIndex, "hblnum_discount_unit",strDiscountUnit);
			dao.setProcInValue(nUpdatedIndex, "hblstr_remarks", strRemarks);
			dao.setProcInValue(nUpdatedIndex, "hblnum_discount_type",strDiscountType);
			dao.setProcInValue(nUpdatedIndex, "hrgnum_puk", strPuk);
			dao.setProcInValue(nUpdatedIndex, "sblnum_service_id",strServiceId);
			dao.setProcInValue(nUpdatedIndex, "gstr_tariff_id",strGblTariffId);
			dao.setProcInValue(nUpdatedIndex, "hblnum_approval_id",strApprovalId);
			dao.setProcInValue(nUpdatedIndex, "gnum_isvalid", strIsValid);
			dao.setProcInValue(nUpdatedIndex, "hblnum_is_refundable",strIsRefundable);
			dao.setProcInValue(nUpdatedIndex, "gnum_seatid", strSeatId);
			dao.setProcInValue(nUpdatedIndex, "gdt_entry_date", strEntryDate);
			dao.setProcInValue(nUpdatedIndex, "gnum_qty_unit_id",strQtyUnitId);
			dao.setProcInValue(nUpdatedIndex, "hblnum_is_package",strIsPackage);
			dao.setProcInValue(nUpdatedIndex, "hblnum_net_amount",strNetAmount);
			dao.setProcInValue(nUpdatedIndex, "hblnum_penelty", strPenelty);
			dao.setProcInValue(nUpdatedIndex, "hblnum_penelty_amt",strPenaltyAmt);
			dao.setProcInValue(nUpdatedIndex, "hblnum_ref_bill_no",strRefBillNo);
			dao.setProcInValue(nUpdatedIndex, "hblnum_ref_reciept_no",strRefReciptNo);

    		dao.setProcInValue(nUpdatedIndex, "hosp_code",strHospitalCode);  
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
	 *             when BillNo. or Tariff Id or Receipt No. is blank
	 */
	public void update1(HisDAO dao) throws Exception {

		strErr = "";

		try {
			// check mandatory information
			if (strBillNo.equals("0") || strBillNo.equals("")) {
				throw new Exception("BillNo. can not be blank");
			}

			if (strTariffId.equals("0") || strTariffId.equals("")) {
				throw new Exception("SerialNo. can not be blank");
			}

			if (strReceiptNo.equals("0") || strReceiptNo.equals("")) {
				throw new Exception("ReceiptNo. can not be blank");
			}

			 
			
			if (this.nRowUpdated == 0) 
			{
				nUpdatedIndex = dao
						.setProcedure("{call "
								+ strProcName
								+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			
			// set the value
			// Input Value
			dao.setProcInValue(nUpdatedIndex, "modval", "2");
    		
			dao.setProcInValue(nUpdatedIndex, "hblnum_remained_qty",strRemainedQty);
			dao.setProcInValue(nUpdatedIndex, "hblnum_reciept_no", strReceiptNo);
			dao.setProcInValue(nUpdatedIndex, "hblnum_tariff_id", strTariffId);
			dao.setProcInValue(nUpdatedIndex, "hblnum_bill_no", strBillNo);
			dao.setProcInValue(nUpdatedIndex, "gnum_qty_unit_id",strQtyUnitId);
    		dao.setProcInValue(nUpdatedIndex, "hosp_code",strHospitalCode);  
			
			
			dao.setProcInValue(nUpdatedIndex, "gnum_rate_unit_code","");
			dao.setProcInValue(nUpdatedIndex, "hblnum_service_tax","");
			dao.setProcInValue(nUpdatedIndex, "hblnum_reciept_date","");
			dao.setProcInValue(nUpdatedIndex, "hblnum_group_id", "");
			dao.setProcInValue(nUpdatedIndex, "hblnum_reciept_type","");
			dao.setProcInValue(nUpdatedIndex, "hblnum_bill_qty", "");
			dao.setProcInValue(nUpdatedIndex, "hblnum_processed_qty","");
			dao.setProcInValue(nUpdatedIndex, "gnum_patient_cat_code",	"");
			
			dao.setProcInValue(nUpdatedIndex, "sblnum_bservice_id","");
			dao.setProcInValue(nUpdatedIndex, "hblnum_tariff_rate","");
			dao.setProcInValue(nUpdatedIndex, "hblstr_discount_by","");
			dao.setProcInValue(nUpdatedIndex, "hblnum_status","");
			dao.setProcInValue(nUpdatedIndex, "hblnum_tariff_actual_rate","");
			dao.setProcInValue(nUpdatedIndex, "hbldt_discount_date","");
			dao.setProcInValue(nUpdatedIndex, "hblstr_discount_reason",	"");
			dao.setProcInValue(nUpdatedIndex, "hblnum_discount_amt","");
			dao.setProcInValue(nUpdatedIndex, "hblnum_sertax_amt","");
			dao.setProcInValue(nUpdatedIndex, "hblnum_discount_unit","");
			dao.setProcInValue(nUpdatedIndex, "hblstr_remarks", "");
			dao.setProcInValue(nUpdatedIndex, "hblnum_discount_type","");
			dao.setProcInValue(nUpdatedIndex, "hrgnum_puk", "");
			dao.setProcInValue(nUpdatedIndex, "sblnum_service_id","");
			dao.setProcInValue(nUpdatedIndex, "gstr_tariff_id","");
			dao.setProcInValue(nUpdatedIndex, "hblnum_approval_id","");
			dao.setProcInValue(nUpdatedIndex, "gnum_isvalid", "");
			dao.setProcInValue(nUpdatedIndex, "hblnum_is_refundable","");
			dao.setProcInValue(nUpdatedIndex, "gnum_seatid", "");
			dao.setProcInValue(nUpdatedIndex, "gdt_entry_date", "");
			
			dao.setProcInValue(nUpdatedIndex, "hblnum_is_package","");
			dao.setProcInValue(nUpdatedIndex, "hblnum_net_amount","");
			dao.setProcInValue(nUpdatedIndex, "hblnum_penelty", "");
			dao.setProcInValue(nUpdatedIndex, "hblnum_penelty_amt","");
			dao.setProcInValue(nUpdatedIndex, "hblnum_ref_bill_no","");
			dao.setProcInValue(nUpdatedIndex, "hblnum_ref_reciept_no","");

    		// output value
			dao.setProcOutValue(nUpdatedIndex, "err", 1);
    		
		// keep in batch
			dao.execute(nUpdatedIndex, 1);
		
			this.nRowUpdated++;
		}
		catch (Exception e) 
		{
		//	e.printStackTrace(); 
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}
	}

	

	/**
	 * This method will be used to clear all the variables
	 */
	private void reset() {

		strBillNo = "0";
		strTariffId = "0";
		strReceiptNo = "1";
		strRateUnitCode = "0";
		strServiceTax = "0";
		strRecieptDate = "";
		strGroupId = "0";
		strReceiptType = "1";
		strBillQty = "0";
		strProcessedQty = "0";
		strPatientCatCode = "0";
		strStatus = "1";
		strBServiceId = "0";
		strTariffRate = "0";
		strDiscountBy = "";
		strRemainedQty = "0";
		strTariffActualRate = "0";
		strDiscountDate = "0";
		strDiscountReason = "";
		strDiscountAmount = "0";
		strServTaxAmt = "0";
		strDiscountUnit = "0";
		strRemarks = "";
		strDiscountType = "0";
		strPuk = "0";
		strServiceId = "0";
		strGblTariffId = "";
		strApprovalId = "0";
		strIsValid = "1";
		strIsRefundable = "0";
		strSeatId = "0";
		strEntryDate = "";
		strQtyUnitId = "0";
		strIsPackage = "0";
		strNetAmount = "0";
		strPenelty = "0";
		strPenaltyAmt = "0";
		strRefBillNo = "0";
		strRefReciptNo = "0";
        strHospitalCode = "0";
		
	}

}