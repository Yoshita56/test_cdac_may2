package billing.dao;

import hisglobal.transactionmgnt.HisDAO;

/**
 * Developer : Kapil Khurana
 * Version : 1.0
 * Date : 21/Aug/2008
 * 
 * This class will be used to insert/update/delete the records
 * Table Name : HBLT_PATACCOUNT_STATUS_LOG_DTL
 * Procedure Name : PKG_BILL_DML.DML_HBLT_PATACCOUNT_STATUS_LOG_DTL
*/
public final class PatientAccountStatusDAO {
	
	private String strPatAccountNo = "0";
	private String strStatusSlNo = "0";
	private String strOldStatus = "0";
	private String strNewStatus = "0";
	private String strAppBy = "";
	private String strAppDate = "";
	private String strRemarks = "";
	private String strEntryDate = "";
	private String strSeatId = "0";
	private String strIsValid = "1";
	private String strHospitalCode = "0";
	
	
	//It is mandatory parameter, do not reset the following variables
	private String strErr = "";
	
	private final String strProcName = "pkg_bill_dml.dml_hblt_pataccount_stat_log";
	private final String strFileName = "billing.dao.PatientAccountStatusDAO";
	
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
	 * @param strPatAccountNo the strPatAccountNo to set
	 */
	public void setStrPatAccountNo(String strPatAccountNo) {
		this.strPatAccountNo = strPatAccountNo;
	}

	/**
	 * @param strStatusSlNo the strStatusSlNo to set
	 */
	public void setStrStatusSlNo(String strStatusSlNo) {
		this.strStatusSlNo = strStatusSlNo;
	}

	/**
	 * @param strOldStatus the strOldStatus to set
	 */
	public void setStrOldStatus(String strOldStatus) {
		this.strOldStatus = strOldStatus;
	}

	/**
	 * @param strNewStatus the strNewStatus to set
	 */
	public void setStrNewStatus(String strNewStatus) {
		this.strNewStatus = strNewStatus;
	}

	/**
	 * @param strAppBy the strAppBy to set
	 */
	public void setStrAppBy(String strAppBy) {
		this.strAppBy = strAppBy;
	}

	/**
	 * @param strAppDate the strAppDate to set
	 */
	public void setStrAppDate(String strAppDate) {
		this.strAppDate = strAppDate;
	}

	/**
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
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
	 * @param strIsValid the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}
	
//	Methods starts from here
	
	/**
	 *  This method will be used to insert the records
	 * @param dao : HisDAO Object
	 * @throws Exception - when Requisition No. is blank or
	 * Status SlNo. is blank
	 */
	public void insert(HisDAO dao) throws Exception {
		
		strErr = "";
		
		try {
			//check mandatory information
			if(strPatAccountNo.equals("0") || strPatAccountNo.equals("")) {
				throw new Exception("Patient Account No. can not be blank");
			}
			/*if(strStatusSlNo.equals("0") || strStatusSlNo.equals("")) {
				throw new Exception("Status SlNo. can not be blank");
			}*/
			
			if(this.nRowInserted == 0) {
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			
			//set the value
			//Input Value
			dao.setProcInValue(nInsertedIndex,"modval","1",1);
			dao.setProcInValue(nInsertedIndex,"hblnum_pataccount_no",strPatAccountNo,2);
			dao.setProcInValue(nInsertedIndex,"hblnum_status_slno",strStatusSlNo,3);
			dao.setProcInValue(nInsertedIndex,"hblnum_old_status",strOldStatus,4);
			dao.setProcInValue(nInsertedIndex,"hblnum_new_status",strNewStatus,5);
			dao.setProcInValue(nInsertedIndex,"hblstr_approved_by",strAppBy,6);
			dao.setProcInValue(nInsertedIndex,"hbldt_approved_date",strAppDate,7);
			dao.setProcInValue(nInsertedIndex,"gstr_remarks",strRemarks,8);
			dao.setProcInValue(nInsertedIndex,"gdt_entry_date",strEntryDate,9);
			dao.setProcInValue(nInsertedIndex,"gnum_seatid",strSeatId,10);
			dao.setProcInValue(nInsertedIndex,"gnum_isvalid",strIsValid,11);
			dao.setProcInValue(nInsertedIndex,"hosp_code",strHospitalCode,12);  // New Value
			
		
			//output value
			dao.setProcOutValue(nInsertedIndex,"err",1,13);
			
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
		
		 strPatAccountNo = "0";
		 strStatusSlNo = "0";
		 strOldStatus = "0";
		 strNewStatus = "0";
		 strAppBy = "";
		 strAppDate = "";
		 strRemarks = "";
		 strEntryDate = "";
		 strSeatId = "0";
		 strIsValid = "1";
		 strHospitalCode = "0";
		
	}
}
			