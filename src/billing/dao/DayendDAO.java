package billing.dao;

import hisglobal.transactionmgnt.HisDAO;

/**
 * Developer : Kapil Khurana
 * Version : 1.0
 * Date : 20/Aug/2008
 * 
 * This class will be used to insert/update/delete the records
 * Table Name : HBLT_DAYEND_DTL
 * Procedure Name : PKG_BILL_DML.DML_HBLT_DAYEND_DTL
*/
public final class DayendDAO {
	
	private String strSummNo = "0";
	private String strSummDt = "";
	private String strReceiptCash = "0";
	private String strReceiptInst = "0";
	private String strRefundCash = "0";
	private String strReconcileCash = "0";
	private String strReconcileInst = "0";
	private String strTotalInst = "0";
	private String strSession = "0";
	private String strSessionFrm = "0";
	private String strSessionTo = "0";
	private String strCounterId = "0";
	private String strRemarks = "";
	private String strSeatId = "0";
	private String strEntryDate = "";
	private String strIsValid = "1";
	private String strRrefundInstrument = "";
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
	 * @param strSummNo the strRrefundInstrument to set
	 */
	public void setStrRrefundInstrument(String strRrefundInstrument) {
		this.strRrefundInstrument = strRrefundInstrument;
	}
	
	
	

	/**
	 * @param strSummDate the strSummDate to set
	 */
	public void setStrSummDt(String strSummDt) {
		this.strSummDt = strSummDt;
	}

	/**
	 * @param strReceiptCash the strReceiptCash to set
	 */
	public void setStrReceiptCash(String strReceiptCash) {
		this.strReceiptCash = strReceiptCash;
	}

	/**
	 * @param strReceiptInst the strReceiptInst to set
	 */
	public void setStrReceiptInst(String strReceiptInst) {
		this.strReceiptInst = strReceiptInst;
	}

	/**
	 * @param strRefundCash the strRefundCash to set
	 */
	public void setStrRefundCash(String strRefundCash) {
		this.strRefundCash = strRefundCash;
	}

	/**
	 * @param strReconcileCash the strReconcileCash to set
	 */
	public void setStrReconcileCash(String strReconcileCash) {
		this.strReconcileCash = strReconcileCash;
	}

	/**
	 * @param strReconcileInst the strReconcileInst to set
	 */
	public void setStrReconcileInst(String strReconcileInst) {
		this.strReconcileInst = strReconcileInst;
	}

	/**
	 * @param strTotalInst the strTotalInst to set
	 */
	public void setStrTotalInst(String strTotalInst) {
		this.strTotalInst = strTotalInst;
	}

	/**
	 * @param strSession the strSession to set
	 */
	public void setStrSession(String strSession) {
		this.strSession = strSession;
	}

	/**
	 * @param strSessionFrm the strSessionFrm to set
	 */
	public void setStrSessionFrm(String strSessionFrm) {
		this.strSessionFrm = strSessionFrm;
	}

	/**
	 * @param strSessionTo the strSessionTo to set
	 */
	public void setStrSessionTo(String strSessionTo) {
		this.strSessionTo = strSessionTo;
	}

	/**
	 * @param strCounterId the strCounterId to set
	 */
	public void setStrCounterId(String strCounterId) {
		this.strCounterId = strCounterId;
	}

	/**
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
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
	 * @throws Exception - when Summary No. is blank
	 */
	public void insert(HisDAO dao) throws Exception {
		
		strErr = "";
		
		try {
			//check mandatory information
			if(strSummNo.equals("0") || strSummNo.equals("")) {
				throw new Exception("Summary No. can not be blank");
			}
			
			if(this.nRowInserted == 0) {
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?}");
			}
			
			//set the value
			//Input Value
			dao.setProcInValue(nInsertedIndex,"modval","1");
			
	       	dao.setProcInValue(nInsertedIndex,"hblnum_summ_no",strSummNo);
			dao.setProcInValue(nInsertedIndex,"hbldt_summ_date",strSummDt);
			dao.setProcInValue(nInsertedIndex,"hblnum_receipt_cash",strReceiptCash);
			dao.setProcInValue(nInsertedIndex,"hblnum_receipt_instrument",strReceiptInst);
			dao.setProcInValue(nInsertedIndex,"hblnum_refund_cash",strRefundCash);
			dao.setProcInValue(nInsertedIndex,"hblnum_refund_instrument",strRrefundInstrument);
			dao.setProcInValue(nInsertedIndex,"hblnum_reconcile_cash",strReconcileCash);
			dao.setProcInValue(nInsertedIndex,"hblnum_reconcile_instrument",strReconcileInst);
			dao.setProcInValue(nInsertedIndex,"hblnum_tot_instrument",strTotalInst);
			dao.setProcInValue(nInsertedIndex,"hblnum_session",strSession);
			dao.setProcInValue(nInsertedIndex,"hbldt_session_frm",strSessionFrm);
			dao.setProcInValue(nInsertedIndex,"hbldt_session_to",strSessionTo);
			dao.setProcInValue(nInsertedIndex,"hblnum_counter_id",strCounterId);
			dao.setProcInValue(nInsertedIndex,"gstr_remarks",strRemarks);
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
		strSummDt = "";
		strReceiptCash = "0";
		strReceiptInst = "0";
		strRefundCash = "0";
		strReconcileCash = "0";
		strReconcileInst = "0";
		strTotalInst = "0";
		strSession = "0";
		strSessionFrm = "0";
		strSessionTo = "0";
		strCounterId = "0";
		strRemarks = "";
		strSeatId = "0";
		strEntryDate = "";
		strIsValid = "1";
		strHospitalCode = "0";
		
	}
}
	