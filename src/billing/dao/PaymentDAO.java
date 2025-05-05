package billing.dao;

import hisglobal.transactionmgnt.HisDAO;

/**
 * Developer : Anshul Jindal
 *  Version : 1.0 
 *  Date : 20/Aug/2008
 * 
 * This class will be used to insert/update/delete the records
 * Table Name : Hblt_Payment_Detail
 * Procedure Name : PKG_BILL_DML.dml_Hblt_Payment_Detail
 */

public class PaymentDAO {

	private String strBillNo = "0";
	private String strPaymentMode = "0";
	private String strReceiptNo = "1";
	private String strSerialNo = "1";
	private String strChargeTypeId = "0";
	private String strRecieptDate = "";
	private String strBServiceId = "0";
	private String strPaymentModeNo = "";
	private String strRecieptType = "1";
	private String strRecieptAmount = "0";
	private String strPaymentDetails = "";
	private String strPuk = "0";
	private String strPreviousPuk = "0";
	private String strPaymentStatus = "0";
	private String strProcessedBy = "0";
	private String strEntryDate = "";
	private String strCounterId = "0";
	private String strSeatId = "0";
	private String strIsValid = "1";
	private String strHospitalCode = "0";
	private String strNetAmount = "0";
	private String stripadd="";
	private String strmacadd="";
	
	// It is mandatory parameter, do not reset the following variables
	private String strErr = "";

	private final String strProcName = "pkg_bill_dml.dml_Hblt_Payment_Detail";
	private final String strFileName = "billing.dao.PaymentDAO";

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
	 *            The strBillNo to set.
	 */
	public void setStrBillNo(String strBillNo) {
		this.strBillNo = strBillNo;
	}

	/**
	 * @param strPaymentMode
	 *            The strPaymentMode to set.
	 */
	public void setStrPaymentMode(String strPaymentMode) {
		this.strPaymentMode = strPaymentMode;
	}

	/**
	 * @param strReceiptNo
	 *            The strReceiptNo to set.
	 */
	public void setStrRecieptNo(String strReceiptNo) {
		this.strReceiptNo = strReceiptNo;
	}

	/**
	 * @param strSerialNo
	 *            The strSerialNo to set.
	 */
	public void setStrSerialNo(String strSerialNo) {
		this.strSerialNo = strSerialNo;
	}

	/**
	 * @param strChargeTypeId
	 *            The strChargeTypeId to set.
	 */
	public void setStrChargeTypeId(String strChargeTypeId) {
		this.strChargeTypeId = strChargeTypeId;
	}

	/**
	 * @param strRecieptDate
	 *            The strRecieptDate to set.
	 */
	public void setStrRecieptDate(String strRecieptDate) {
		this.strRecieptDate = strRecieptDate;
	}

	/**
	 * @param strBServiceId
	 *            The strBServiceId to set.
	 */
	public void setStrBServiceId(String strBServiceId) {
		this.strBServiceId = strBServiceId;
	}

	/**
	 * @param strPaymentModeNo
	 *            The strPaymentModeNo to set.
	 */
	public void setStrPaymentModeNo(String strPaymentModeNo) {
		this.strPaymentModeNo = strPaymentModeNo;
	}

	/**
	 * @param strRecieptType
	 *            The strRecieptType to set.
	 */
	public void setStrRecieptType(String strRecieptType) {
		this.strRecieptType = strRecieptType;
	}

	/**
	 * @param strRecieptAmount
	 *            The strRecieptAmount to set.
	 */
	public void setStrRecieptAmount(String strRecieptAmount) {
		this.strRecieptAmount = strRecieptAmount;
	}

	/**
	 * @param strPaymentDetails
	 *            The strPaymentDetails to set.
	 */
	public void setStrPaymentDetails(String strPaymentDetails) {
		this.strPaymentDetails = strPaymentDetails;
	}

	/**
	 * @param strPuk
	 *            The strPuk to set.
	 */
	public void setStrPuk(String strPuk) {
		this.strPuk = strPuk;
	}

	/**
	 * @param strPaymentStatus
	 *            The strPaymentStatus to set.
	 */
	public void setStrPaymentStatus(String strPaymentStatus) {
		this.strPaymentStatus = strPaymentStatus;
	}

	/**
	 * @param strProcessedBy
	 *            The strProcessedBy to set.
	 */
	public void setStrProcessedBy(String strProcessedBy) {
		this.strProcessedBy = strProcessedBy;
	}

	/**
	 * @param strEntryDate
	 *            The strEntryDate to set.
	 */
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}

	/**
	 * @param strCounterId
	 *            The strCounterId to set.
	 */
	public void setStrCounterId(String strCounterId) {
		this.strCounterId = strCounterId;
	}

	/**
	 * @param strSeatId
	 *            The strSeatId to set.
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * @param strIsValid
	 *            The strIsValid to set.
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}
	
	

	// Methods starts from here

	public void setStripadd(String stripadd) {
		this.stripadd = stripadd;
	}

	public void setStrmacadd(String strmacadd) {
		this.strmacadd = strmacadd;
	}

	/**
	 * This method will be used to insert the records
	 * 
	 * @param dao :
	 *            HisDAO Object
	 * @throws Exception -
	 *             when BillNo. or Receipt No. or Serial No. is blank
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";

		try {
			// check mandatory information
			if (strBillNo.equals("0") || strBillNo.equals("")) {
				throw new Exception("Bill No. can not be blank");
			}
			
			if (strReceiptNo.equals("0") || strReceiptNo.equals("")) {
				throw new Exception("Receipt No. can not be blank");
			}
			
			if (strSerialNo.equals("0") || strSerialNo.equals("")) {
				throw new Exception("Serial No. can not be blank");
			}

			if (this.nRowInserted == 0) {
				nInsertedIndex = dao
						.setProcedure("{call "
								+ strProcName
								+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}

			// set the value
			// Input Value
			dao.setProcInValue(nInsertedIndex, "modval", "1",1);
			dao.setProcInValue(nInsertedIndex, "hblnum_bill_no", strBillNo,2);
			dao.setProcInValue(nInsertedIndex, "hblnum_payment_mode", strPaymentMode,3);
			dao.setProcInValue(nInsertedIndex, "hblnum_reciept_no", strReceiptNo,4);
			dao.setProcInValue(nInsertedIndex, "hblnum_slno",strSerialNo,5);
			dao.setProcInValue(nInsertedIndex, "sblnum_chargetype_id",strChargeTypeId,6);
			dao.setProcInValue(nInsertedIndex, "hbldt_reciept_date",strRecieptDate,7);
			dao.setProcInValue(nInsertedIndex, "sblnum_bservice_id",strBServiceId,8);
			dao.setProcInValue(nInsertedIndex, "hblstr_paymentmode_no",strPaymentModeNo,9);
			dao.setProcInValue(nInsertedIndex, "hblnum_reciept_type", strRecieptType,10);
			dao.setProcInValue(nInsertedIndex, "hblnum_reciept_amt",strRecieptAmount,11);
			dao.setProcInValue(nInsertedIndex, "hblstr_payment_dtls",strPaymentDetails,12);
			dao.setProcInValue(nInsertedIndex, "hrgnum_prev_puk", strPreviousPuk,13);
			dao.setProcInValue(nInsertedIndex, "hrgnum_puk", strPuk,14);
			dao.setProcInValue(nInsertedIndex, "hblnum_payment_status", strPaymentStatus,15);
			dao.setProcInValue(nInsertedIndex, "hblnum_processed_by",strProcessedBy,16);
			dao.setProcInValue(nInsertedIndex, "gdt_entry_date", strEntryDate,17);
			dao.setProcInValue(nInsertedIndex, "hblnum_counter_id", strCounterId,18);
			dao.setProcInValue(nInsertedIndex, "gnum_seatid", strSeatId,19);
			dao.setProcInValue(nInsertedIndex, "gnum_isvalid", strIsValid,20);
			dao.setProcInValue(nInsertedIndex, "hosp_code",strHospitalCode,21);  // New Value
			dao.setProcInValue(nInsertedIndex, "netAmt",strNetAmount,22);
			dao.setProcInValue(nInsertedIndex, "ip",stripadd,23);
			dao.setProcInValue(nInsertedIndex, "mac",strmacadd,24);
			// output value
			dao.setProcOutValue(nInsertedIndex, "err", 1,25);

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
	 * This method will be used to clear all the variables
	 */
	private void reset() {

		strBillNo = "0";
		strPaymentMode = "0";
		strReceiptNo = "1";
		strSerialNo = "1";
		strChargeTypeId = "0";
		strRecieptDate = "";
		strBServiceId = "0";
		strPaymentModeNo = "";
		strRecieptType = "1";
		strRecieptAmount = "0";
		strPaymentDetails = "";
		strPuk = "0";
		strPaymentStatus = "0";
		strProcessedBy = "0";
		strEntryDate = "";
		strCounterId = "0";
		strSeatId = "0";
		strIsValid = "1";
		strHospitalCode = "0";
		stripadd="";
		strmacadd="";
	}

	public void setStrReceiptNo(String strReceiptNo) {
		this.strReceiptNo = strReceiptNo;
	}

	public void setStrNetAmount(String strNetAmount) {
		this.strNetAmount = strNetAmount;
	}

	public void setStrPreviousPuk(String strPreviousPuk) {
		this.strPreviousPuk = strPreviousPuk;
	}

}
