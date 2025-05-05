package billing.dao;

import hisglobal.transactionmgnt.HisDAO;

/**
 * Developer : Kapil Khurana
 * Version : 1.0
 * Date : 21/Aug/2008
 * 
 * This class will be used to insert/update/delete the records
 * Table Name : HBLT_CLIENT_PATIENT_DTL
 * Procedure Name : PKG_BILL_DML.DML_HBLT_CLIENT_PATIENT_DTL
*/
public final class ClientPatientDAO {
	
	private String strClientPatNo = "0";
	private String strClientPatSlNo = "1";
	private String strPuk = "0";
	private String strClientNo = "0";
	private String strCardNo = "0";
	private String strCardExpiryDt = "";
	private String strCardHolderName = "0";
	private String strAuthNo = "0";
	private String strAuthDt = "";
	private String strSancLimit = "0";
	private String strClientExpenseAmt = "0";
	private String strExpiryDt = "";
	private String strStatus = "1";
	private String strTariffStatus = "0";
	private String strSeatId = "0";
	private String strIsValid = "1";
	private String strPaymentStatus = "0";
	private String strClientAmt = "0";
	private String strEntryDate = "";
	private String strIsOpdApproval = "0";
	private String strIsIpdApproval = "0";
	private String strIsEmgrApproval = "0";
	private String strIsOneTimeService= "1";
	private String strHospitalCode = "0";
	
	
	//It is mandatory parameter, do not reset the following variables
	private String strErr = "";
	
	private final String strProcName = "pkg_bill_dml.dml_hblt_client_patient_dtl";
	private final String strFileName = "billing.dao.ClientPatientDAO";
	
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
	 * @param strClientPatNo the strClientPatNo to set
	 */
	public void setStrClientPatNo(String strClientPatNo) {
		this.strClientPatNo = strClientPatNo;
	}

	/**
	 * @param strClientPatSlNo the strClientPatSlNo to set
	 */
	public void setStrClientPatSlNo(String strClientPatSlNo) {
		this.strClientPatSlNo = strClientPatSlNo;
	}

	/**
	 * @param strPuk the strPuk to set
	 */
	public void setStrPuk(String strPuk) {
		this.strPuk = strPuk;
	}

	/**
	 * @param strClientNo the strClientNo to set
	 */
	public void setStrClientNo(String strClientNo) {
		this.strClientNo = strClientNo;
	}

	/**
	 * @param strCardNo the strCardNo to set
	 */
	public void setStrCardNo(String strCardNo) {
		this.strCardNo = strCardNo;
	}

	/**
	 * @param strCardExpiryDt the strCardExpiryDt to set
	 */
	public void setStrCardExpiryDt(String strCardExpiryDt) {
		this.strCardExpiryDt = strCardExpiryDt;
	}

	/**
	 * @param strCardHolderName the strCardHolderName to set
	 */
	public void setStrCardHolderName(String strCardHolderName) {
		this.strCardHolderName = strCardHolderName;
	}

	/**
	 * @param strAuthNo the strAuthNo to set
	 */
	public void setStrAuthNo(String strAuthNo) {
		this.strAuthNo = strAuthNo;
	}

	/**
	 * @param strAuthDt the strAuthDt to set
	 */
	public void setStrAuthDt(String strAuthDt) {
		this.strAuthDt = strAuthDt;
	}

	/**
	 * @param strSancLimit the strSancLimit to set
	 */
	public void setStrSancLimit(String strSancLimit) {
		this.strSancLimit = strSancLimit;
	}

	/**
	 * @param strClientExpenseAmt the strClientExpenseAmt to set
	 */
	public void setStrClientExpenseAmt(String strClientExpenseAmt) {
		this.strClientExpenseAmt = strClientExpenseAmt;
	}

	/**
	 * @param strExpiryDt the strExpiryDt to set
	 */
	public void setStrExpiryDt(String strExpiryDt) {
		this.strExpiryDt = strExpiryDt;
	}

	/**
	 * @param strStatus the strStatus to set
	 */
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}

	/**
	 * @param strTariffStatus the strTariffStatus to set
	 */
	public void setStrTariffStatus(String strTariffStatus) {
		this.strTariffStatus = strTariffStatus;
	}

	/**
	 * @param strSeatId the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * @param strIsValid the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	/**
	 * @param strPaymentStatus the strPaymentStatus to set
	 */
	public void setStrPaymentStatus(String strPaymentStatus) {
		this.strPaymentStatus = strPaymentStatus;
	}

	/**
	 * @param strClientAmt the strClientAmt to set
	 */
	public void setStrClientAmt(String strClientAmt) {
		this.strClientAmt = strClientAmt;
	}

	/**
	 * @param strEntryDate the strEntryDate to set
	 */
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}

	/**
	 * @param strIsOpdApproval the strIsOpdApproval to set
	 */
	public void setStrIsOpdApproval(String strIsOpdApproval) {
		this.strIsOpdApproval = strIsOpdApproval;
	}

	/**
	 * @param strIsIpdApproval the strIsIpdApproval to set
	 */
	public void setStrIsIpdApproval(String strIsIpdApproval) {
		this.strIsIpdApproval = strIsIpdApproval;
	}

	/**
	 * @param strIsEmgrApproval the strIsEmgrApproval to set
	 */
	public void setStrIsEmgrApproval(String strIsEmgrApproval) {
		this.strIsEmgrApproval = strIsEmgrApproval;
	}

	/**
	 * @param strIsOneTimeService the strIsOneTimeService to set
	 */
	public void setStrIsOneTimeService(String strIsOneTimeService) {
		this.strIsOneTimeService = strIsOneTimeService;
	}
	
//	Methods starts from here
	
	/**
	 *  This method will be used to insert the records
	 * @param dao : HisDAO Object
	 * @throws Exception - when Client Patient No. is blank or
	 * when Client Patient SlNo. is blank
	 */
	public void insert(HisDAO dao) throws Exception {
		
		strErr = "";
		
		try 
		{
			//check mandatory information
			if(strClientPatNo.equals("0") || strClientPatNo.equals("")) 
			{
				throw new Exception("Client Patient No. can not be blank");
			}
			if(strClientPatSlNo.equals("0") || strClientPatSlNo.equals("")) 
			{
				throw new Exception("Requisition No. can not be blank");
			}
			if(this.nRowInserted == 0) 
			{
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			
			dao.setProcInValue(nInsertedIndex,"modval","1",1);
			dao.setProcInValue(nInsertedIndex,"hblnum_client_patient_no",strClientPatNo,2);
			dao.setProcInValue(nInsertedIndex,"hblnum_client_patient_slno",strClientPatSlNo,3);
			dao.setProcInValue(nInsertedIndex,"hrgnum_puk",strPuk,4);
			dao.setProcInValue(nInsertedIndex,"hblnum_client_no",strClientNo,5);
			dao.setProcInValue(nInsertedIndex,"hblstr_card_no",strCardNo,6);
			dao.setProcInValue(nInsertedIndex,"hbldt_cardexpiry_date",strCardExpiryDt,7);
			dao.setProcInValue(nInsertedIndex,"hblstr_cardholder_name",strCardHolderName,8);
			dao.setProcInValue(nInsertedIndex,"hblstr_auth_no",strAuthNo,9);
			dao.setProcInValue(nInsertedIndex,"hbldt_auth_date",strAuthDt,10);
			dao.setProcInValue(nInsertedIndex,"hblnum_sanc_limit",strSancLimit,11);
			dao.setProcInValue(nInsertedIndex,"hblnum_client_expense_amt",strClientExpenseAmt,12);
			dao.setProcInValue(nInsertedIndex,"hbldt_expiry_date",strExpiryDt,13);
			dao.setProcInValue(nInsertedIndex,"hblnum_status",strStatus,14);
			dao.setProcInValue(nInsertedIndex,"hblnum_tariff_status",strTariffStatus,15);
			dao.setProcInValue(nInsertedIndex,"gnum_seatid",strSeatId,16);
			dao.setProcInValue(nInsertedIndex,"gnum_isvalid",strIsValid,17);
			dao.setProcInValue(nInsertedIndex,"hblnum_payment_status",strPaymentStatus,18);
			dao.setProcInValue(nInsertedIndex,"hblnum_client_amt",strClientAmt,19);
			dao.setProcInValue(nInsertedIndex,"gdt_entry_date",strEntryDate,20);
			dao.setProcInValue(nInsertedIndex,"hblnum_is_opd_approval",strIsOpdApproval,21);
			dao.setProcInValue(nInsertedIndex,"hblnum_is_ipd_approval",strIsIpdApproval,22);
			dao.setProcInValue(nInsertedIndex,"hblnum_is_emgr_approval",strIsEmgrApproval,23);
			dao.setProcInValue(nInsertedIndex,"hblnum_is_onetime_service",strIsOneTimeService,24);
			dao.setProcInValue(nInsertedIndex,"hblnum_prev_sanc_limit","0",25);
			dao.setProcInValue(nInsertedIndex,"hosp_code",strHospitalCode,26);  // New Value
			
			dao.setProcOutValue(nInsertedIndex,"err",1,27);
			
			dao.execute(nInsertedIndex,1);
			this.nRowInserted++;
		} 
		catch(Exception e) 
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
	 *  This method will be used to insert the records
	 * @param dao : HisDAO Object
	 * @throws Exception - when Client Patient No. is blank or
	 * when Client Patient SlNo. is blank
	 */
	public void insert1(HisDAO dao) throws Exception 
	{
		
		strErr = "";
		
		try {
			//check mandatory information
		    if(strClientPatSlNo.equals("0") || strClientPatSlNo.equals("")) {
				throw new Exception("Requisition No. can not be blank");
			}
			if(this.nRowInserted == 0) {
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			
			//set the value
			//Input Value
			dao.setProcInValue(nInsertedIndex,"modval","3");
			
	       	dao.setProcInValue(nInsertedIndex,"hblnum_client_patient_no",strClientPatNo);
			dao.setProcInValue(nInsertedIndex,"hblnum_client_patient_slno",strClientPatSlNo);
			dao.setProcInValue(nInsertedIndex,"hrgnum_puk",strPuk);
			dao.setProcInValue(nInsertedIndex,"hblnum_client_no",strClientNo);
			dao.setProcInValue(nInsertedIndex,"hblstr_card_no",strCardNo);
			dao.setProcInValue(nInsertedIndex,"hbldt_cardexpiry_date",strCardExpiryDt);
			dao.setProcInValue(nInsertedIndex,"hblstr_cardholder_name",strCardHolderName);
			dao.setProcInValue(nInsertedIndex,"hblstr_auth_no",strAuthNo);
			dao.setProcInValue(nInsertedIndex,"hbldt_auth_date",strAuthDt);
			dao.setProcInValue(nInsertedIndex,"hblnum_sanc_limit",strSancLimit);
			dao.setProcInValue(nInsertedIndex,"hblnum_client_expense_amt",strClientExpenseAmt);
			dao.setProcInValue(nInsertedIndex,"hbldt_expiry_date",strExpiryDt);
			dao.setProcInValue(nInsertedIndex,"hblnum_status",strStatus);
			dao.setProcInValue(nInsertedIndex,"hblnum_tariff_status",strTariffStatus);
			dao.setProcInValue(nInsertedIndex,"gnum_seatid",strSeatId);
			dao.setProcInValue(nInsertedIndex,"gnum_isvalid",strIsValid);
			dao.setProcInValue(nInsertedIndex,"hblnum_payment_status",strPaymentStatus);
			dao.setProcInValue(nInsertedIndex,"hblnum_client_amt",strClientAmt);
			dao.setProcInValue(nInsertedIndex,"gdt_entry_date",strEntryDate);
			dao.setProcInValue(nInsertedIndex,"hblnum_is_opd_approval",strIsOpdApproval);
			dao.setProcInValue(nInsertedIndex,"hblnum_is_ipd_approval",strIsIpdApproval);
			dao.setProcInValue(nInsertedIndex,"hblnum_is_emgr_approval",strIsEmgrApproval);
			dao.setProcInValue(nInsertedIndex,"hblnum_is_onetime_service",strIsOneTimeService);
			
			dao.setProcInValue(nInsertedIndex,"hblnum_prev_sanc_limit","");
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
	public void insert2(HisDAO dao) throws Exception 
	{
		
		strErr = "";
		
		try {
			//check mandatory information
			if(strClientPatSlNo.equals("0") || strClientPatSlNo.equals("")) {
				throw new Exception("Requisition No. can not be blank");
			}
			if(this.nRowInserted == 0) {
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			
			//set the value
			//Input Value
			dao.setProcInValue(nInsertedIndex,"modval","4");
			
	       	dao.setProcInValue(nInsertedIndex,"hblnum_client_patient_no",strClientPatNo);
			dao.setProcInValue(nInsertedIndex,"hblnum_client_patient_slno",strClientPatSlNo);
			dao.setProcInValue(nInsertedIndex,"hrgnum_puk",strPuk);
			dao.setProcInValue(nInsertedIndex,"hblnum_client_no",strClientNo);
			dao.setProcInValue(nInsertedIndex,"hblstr_card_no",strCardNo);
			dao.setProcInValue(nInsertedIndex,"hbldt_cardexpiry_date",strCardExpiryDt);
			dao.setProcInValue(nInsertedIndex,"hblstr_cardholder_name",strCardHolderName);
			dao.setProcInValue(nInsertedIndex,"hblstr_auth_no",strAuthNo);
			dao.setProcInValue(nInsertedIndex,"hbldt_auth_date",strAuthDt);
			dao.setProcInValue(nInsertedIndex,"hblnum_sanc_limit",strSancLimit);
			dao.setProcInValue(nInsertedIndex,"hblnum_client_expense_amt",strClientExpenseAmt);
			dao.setProcInValue(nInsertedIndex,"hbldt_expiry_date",strExpiryDt);
			dao.setProcInValue(nInsertedIndex,"hblnum_status",strStatus);
			dao.setProcInValue(nInsertedIndex,"hblnum_tariff_status",strTariffStatus);
			dao.setProcInValue(nInsertedIndex,"gnum_seatid",strSeatId);
			dao.setProcInValue(nInsertedIndex,"gnum_isvalid",strIsValid);
			dao.setProcInValue(nInsertedIndex,"hblnum_payment_status",strPaymentStatus);
			dao.setProcInValue(nInsertedIndex,"hblnum_client_amt",strClientAmt);
			dao.setProcInValue(nInsertedIndex,"gdt_entry_date",strEntryDate);
			dao.setProcInValue(nInsertedIndex,"hblnum_is_opd_approval",strIsOpdApproval);
			dao.setProcInValue(nInsertedIndex,"hblnum_is_ipd_approval",strIsIpdApproval);
			dao.setProcInValue(nInsertedIndex,"hblnum_is_emgr_approval",strIsEmgrApproval);
			dao.setProcInValue(nInsertedIndex,"hblnum_is_onetime_service",strIsOneTimeService);
			
			dao.setProcInValue(nInsertedIndex,"hblnum_prev_sanc_limit","");
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
	
		 strClientPatNo = "0";
		 strClientPatSlNo = "1";
		 strPuk = "0";
		 strClientNo = "0";
		 strCardNo = "0";
		 strCardExpiryDt = "";
		 strCardHolderName = "0";
		 strAuthNo = "0";
		 strAuthDt = "";
		 strSancLimit = "0";
		 strClientExpenseAmt = "0";
		 strExpiryDt = "";
		 strStatus = "1";
		 strTariffStatus = "0";
		 strSeatId = "0";
		 strIsValid = "1";
		 strPaymentStatus = "0";
		 strClientAmt = "0";
		 strEntryDate = "";
		 strIsOpdApproval = "0";
		 strIsIpdApproval = "0";
		 strIsEmgrApproval = "0";
		 strIsOneTimeService= "1";
		 strHospitalCode = "0";
		
	}
}
			