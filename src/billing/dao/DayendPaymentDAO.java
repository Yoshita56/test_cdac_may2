package billing.dao;

import hisglobal.transactionmgnt.HisDAO;

/**
 * Developer : Kapil Khurana
 * Version : 1.0
 * Date : 20/Aug/2008
 * 
 * This class will be used to insert/update/delete the records
 * Table Name : HBLT_DAYEND_PAYMENT_DTL
 * Procedure Name : PKG_BILL_DML.DML_HBLT_DAYEND_PAYMENT_DTL
*/
public final class DayendPaymentDAO {
	
	private String strSummNo = "0";
	private String strBillNo = "0";
	private String strReceiptNo = "0";
	private String strSlNo = "1";
	private String strPuk = "0";
	private String strReceiptType = "1";
	private String strReceiptDate = "";
	private String strSummDt = "";
	private String strChargeTypeId = "0";
	private String strBServiceId = "0";
	private String strPaymentMode = "0";
	private String strPaymentModeNo = "";
	private String strPaymentModeDtl = "";
	private String strRecivedAmt = "0";
	private String strCounterId = "0";
	private String strSeatId = "0";
	private String strEntryDate = "";
	private String strIsValid = "1";
	private String strHospitalCode = "0";
		
	//It is mandatory parameter, do not reset the following variables
	private String strErr = "";
	
	private final String strProcName = "pkg_bill_dml.dml_hblt_dayend_dtl";
	private final String strFileName = "billing.dao.DayendDAO";
	
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
	 * @param strSummNo the strSummNo to set
	 */
	public void setStrSummNo(String strSummNo) {
		this.strSummNo = strSummNo;
	}

	/**
	 * @param strBillNo the strBillNo to set
	 */
	public void setStrBillNo(String strBillNo) {
		this.strBillNo = strBillNo;
	}

	/**
	 * @param strReceiptNo the strReceiptNo to set
	 */
	public void setStrReceiptNo(String strReceiptNo) {
		this.strReceiptNo = strReceiptNo;
	}

	/**
	 * @param strSlNo the strSlNo to set
	 */
	public void setStrSlNo(String strSlNo) {
		this.strSlNo = strSlNo;
	}

	/**
	 * @param strPuk the strPuk to set
	 */
	public void setStrPuk(String strPuk) {
		this.strPuk = strPuk;
	}

	/**
	 * @param strReciptType the strReciptType to set
	 */
	public void setStrReceiptType(String strReceiptType) {
		this.strReceiptType = strReceiptType;
	}

	/**
	 * @param strReciptDate the strReciptDate to set
	 */
	public void setStrReceiptDate(String strReceiptDate) {
		this.strReceiptDate = strReceiptDate;
	}

	/**
	 * @param strSummDt the strSummDt to set
	 */
	public void setStrSummDt(String strSummDt) {
		this.strSummDt = strSummDt;
	}

	/**
	 * @param strChargeTypeId the strChargeTypeId to set
	 */
	public void setStrChargeTypeId(String strChargeTypeId) {
		this.strChargeTypeId = strChargeTypeId;
	}

	/**
	 * @param strBServiceId the strBServiceId to set
	 */
	public void setStrBServiceId(String strBServiceId) {
		this.strBServiceId = strBServiceId;
	}

	/**
	 * @param strPaymentMode the strPaymentMode to set
	 */
	public void setStrPaymentMode(String strPaymentMode) {
		this.strPaymentMode = strPaymentMode;
	}

	/**
	 * @param strPaymentModeNo the strPaymentModeNo to set
	 */
	public void setStrPaymentModeNo(String strPaymentModeNo) {
		this.strPaymentModeNo = strPaymentModeNo;
	}

	/**
	 * @param strPaymentModeDtl the strPaymentModeDtl to set
	 */
	public void setStrPaymentModeDtl(String strPaymentModeDtl) {
		this.strPaymentModeDtl = strPaymentModeDtl;
	}

	/**
	 * @param strRecivedAmt the strRecivedAmt to set
	 */
	public void setStrRecivedAmt(String strRecivedAmt) {
		this.strRecivedAmt = strRecivedAmt;
	}

	/**
	 * @param strCounterId the strCounterId to set
	 */
	public void setStrCounterId(String strCounterId) {
		this.strCounterId = strCounterId;
	}

	/**
	 * @param strSeatId the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * @param strEntryDate the strEntryDate to set
	 */
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}

	/**
	 * @param strIsValid the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

//	Methods starts from here
	
	/**
	 *  This method will be used to insert the records
	 * @param dao : HisDAO Object
	 * @throws Exception - when Summary No. is blank or
	 * Bill No. is blank or
	 * Receipt No. is blank or
	 * Serial No. is blank
	 */
	public void insert(HisDAO dao) throws Exception {
		
		strErr = "";
		
		try {
			//check mandatory information
			if(strSummNo.equals("0") || strSummNo.equals("")) {
				throw new Exception("Summary No. can not be blank");
			}
			if(strBillNo.equals("0") || strBillNo.equals("")) {
				throw new Exception("Bill No. can not be blank");
			}
			if(strReceiptNo.equals("0") || strReceiptNo.equals("")) {
				throw new Exception("Receipt No. can not be blank");
			}
			if(strSlNo.equals("0") || strSlNo.equals("")) {
				throw new Exception("Serial No. can not be blank");
			}
			
			if(this.nRowInserted == 0) {
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?}");
			}
			
			//set the value
			//Input Value
			dao.setProcInValue(nInsertedIndex,"modval","1");
			
	       	dao.setProcInValue(nInsertedIndex,"hblnum_summ_no",strSummNo);
	       	dao.setProcInValue(nInsertedIndex,"hblnum_bill_no",strBillNo);
	       	dao.setProcInValue(nInsertedIndex,"hblnum_reciept_no",strReceiptNo);
	       	dao.setProcInValue(nInsertedIndex,"hblnum_slno",strSlNo);
	       	dao.setProcInValue(nInsertedIndex,"hrgnum_puk",strPuk);
	       	dao.setProcInValue(nInsertedIndex,"hblnum_reciept_type",strReceiptType);
	       	dao.setProcInValue(nInsertedIndex,"hblnum_reciept_date",strReceiptDate);
	       	dao.setProcInValue(nInsertedIndex,"hbldt_summ_date",strSummDt);
			dao.setProcInValue(nInsertedIndex,"sblnum_chargetype_id",strChargeTypeId);
			dao.setProcInValue(nInsertedIndex,"sblnum_bservice_id",strBServiceId);
			dao.setProcInValue(nInsertedIndex,"hblnum_payment_mode",strPaymentMode);
			dao.setProcInValue(nInsertedIndex,"hblstr_paymentmode_no",strPaymentModeNo);
			dao.setProcInValue(nInsertedIndex,"hblstr_payment_dtls",strPaymentModeDtl);
			dao.setProcInValue(nInsertedIndex,"hblnum_recd_amt",strRecivedAmt);
			dao.setProcInValue(nInsertedIndex,"hblnum_counter_id",strCounterId);
			dao.setProcInValue(nInsertedIndex,"gnum_seatid",strSeatId);
			dao.setProcInValue(nInsertedIndex,"gdt_entry_date",strEntryDate);
			dao.setProcInValue(nInsertedIndex,"gnum_isvalid",strIsValid);
			dao.setProcInValue(nInsertedIndex,"hosp_code",strHospitalCode);  // New Value
			
			//output value
			dao.setProcOutValue(nInsertedIndex,"err",1);
			
			//keep in batch
			dao.execute(nInsertedIndex,1);
			this.nRowInserted++;
		} 
		catch(Exception e) {
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		}
		finally {
			this.reset();	//to reset the variables
		}
	}
	
	/**
	 * This method will be used to clear all the variables
	 */
	private void reset() {
		
		strSummNo = "0";
		strBillNo = "0";
		strReceiptNo = "0";
		strSlNo = "1";
		strPuk = "0";
		strReceiptType = "1";
		strReceiptDate = "";
		strSummDt = "";
		strChargeTypeId = "0";
		strBServiceId = "0";
		strPaymentMode = "0";
		strPaymentModeNo = "";
		strPaymentModeDtl = "";
		strRecivedAmt = "0";
		strCounterId = "0";
		strSeatId = "0";
		strEntryDate = "";
		strIsValid = "1";
		strHospitalCode = "0";
		
	}
}

			