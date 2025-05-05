package billing.dao;

import hisglobal.transactionmgnt.HisDAO;

/**
 * Developer : Ajay Kumar Gupta
 * Version : 1.0
 * Date : 20/Aug/2008
 * 
 * This class will be used to insert/update/delete the records
 * Table Name : HBLT_BILLREQ_DTL
 * Procedure Name : PKG_BILL_DML.DML_HBLT_BILLREQ_DTL
*/
public final class BillRequisitionDAO {
	
	private String strReqNo = "0";
	private String strReqDate = "";
	private String strDeptCode = "0";
	private String strChargeTypeId = "0";
	private String strBServiceId = "0";
	private String strServiceId = "0";
	private String strGblReqNo = "";
	private String strCatCode = "0";
	private String strEpisodeCode = "0";
	private String strPuk = "0";
	private String strAdmNo = "0";
	private String strPatAccNo = "0";
	private String strAppId = "0";
	private String strBillNo = "0";
	private String strRemarks = "";
	private String strStatus = "1";
	private String strEntryDate = "";
	private String strSeatId = "0";
	private String strIsValid = "1";
	private String strCancelNo = "0";
	private String strCancelDate = "";
	private String strAppBy = "";
	private String strAppDate = "";
	private String strReqType = "1";
	private String strIpdChargeTypeId = "0";
	private String strWardCode = "0";
	private String strReceiptNo = "1";
	private String strHospitalCode = "0";
	
	//It is mandatory parameter, do not reset the following variables
	private String strErr = "";
	
	private final String strProcName = "pkg_bill_dml.dml_hblt_billreq_dtl";
	private final String strFileName = "billing.dao.BillRequisitionDAO";
	
	private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;
	
	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;
	private String strProcessFeePenalty = "";
	
	public String getStrProcessFeePenalty() {
		return strProcessFeePenalty;
	}

	public void setStrProcessFeePenalty(String strProcessFeePenalty) {
		this.strProcessFeePenalty = strProcessFeePenalty;
	}

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
	 * @param strAdmNo The strAdmNo to set.
	 */
	public void setStrAdmNo(String strAdmNo) {
		this.strAdmNo = strAdmNo;
	}

	/**
	 * @param strAppBy The strAppBy to set.
	 */
	public void setStrAppBy(String strAppBy) {
		this.strAppBy = strAppBy;
	}

	/**
	 * @param strAppDate The strAppDate to set.
	 */
	public void setStrAppDate(String strAppDate) {
		this.strAppDate = strAppDate;
	}

	/**
	 * @param strAppId The strAppId to set.
	 */
	public void setStrAppId(String strAppId) {
		this.strAppId = strAppId;
	}

	/**
	 * @param strBillNo The strBillNo to set.
	 */
	public void setStrBillNo(String strBillNo) {
		this.strBillNo = strBillNo;
	}

	/**
	 * @param strBServiceId The strBServiceId to set.
	 */
	public void setStrBServiceId(String strBServiceId) {
		this.strBServiceId = strBServiceId;
	}

	/**
	 * @param strCancelDate The strCancelDate to set.
	 */
	public void setStrCancelDate(String strCancelDate) {
		this.strCancelDate = strCancelDate;
	}

	/**
	 * @param strCancelNo The strCancelNo to set.
	 */
	public void setStrCancelNo(String strCancelNo) {
		this.strCancelNo = strCancelNo;
	}

	/**
	 * @param strCatCode The strCatCode to set.
	 */
	public void setStrCatCode(String strCatCode) {
		this.strCatCode = strCatCode;
	}

	/**
	 * @param strChargeTypeId The strChargeTypeId to set.
	 */
	public void setStrChargeTypeId(String strChargeTypeId) {
		this.strChargeTypeId = strChargeTypeId;
	}

	/**
	 * @param strDeptCode The strDeptCode to set.
	 */
	public void setStrDeptCode(String strDeptCode) {
		this.strDeptCode = strDeptCode;
	}

	/**
	 * @param strEntryDate The strEntryDate to set.
	 */
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}

	/**
	 * @param strEpisodeCode The strEpisodeCode to set.
	 */
	public void setStrEpisodeCode(String strEpisodeCode) {
		this.strEpisodeCode = strEpisodeCode;
	}

	/**
	 * @param strGblReqNo The strGblReqNo to set.
	 */
	public void setStrGblReqNo(String strGblReqNo) {
		this.strGblReqNo = strGblReqNo;
	}

	/**
	 * @param strIpdChargeTypeId The strIpdChargeTypeId to set.
	 */
	public void setStrIpdChargeTypeId(String strIpdChargeTypeId) {
		this.strIpdChargeTypeId = strIpdChargeTypeId;
	}

	/**
	 * @param strIsValid The strIsValid to set.
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	/**
	 * @param strPatAccNo The strPatAccNo to set.
	 */
	public void setStrPatAccNo(String strPatAccNo) {
		this.strPatAccNo = strPatAccNo;
	}

	/**
	 * @param strPuk The strPuk to set.
	 */
	public void setStrPuk(String strPuk) {
		this.strPuk = strPuk;
	}

	/**
	 * @param strReceiptNo The strReceiptNo to set.
	 */
	public void setStrReceiptNo(String strReceiptNo) {
		this.strReceiptNo = strReceiptNo;
	}

	/**
	 * @param strRemarks The strRemarks to set.
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * @param strReqDate The strReqDate to set.
	 */
	public void setStrReqDate(String strReqDate) {
		this.strReqDate = strReqDate;
	}

	/**
	 * @param strReqNo The strReqNo to set.
	 */
	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
	}

	/**
	 * @param strReqType The strReqType to set.
	 */
	public void setStrReqType(String strReqType) {
		this.strReqType = strReqType;
	}

	/**
	 * @param strSeatId The strSeatId to set.
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * @param strServiceId The strServiceId to set.
	 */
	public void setStrServiceId(String strServiceId) {
		this.strServiceId = strServiceId;
	}

	/**
	 * @param strStatus The strStatus to set.
	 */
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}

	/**
	 * @param strWardCode The strWardCode to set.
	 */
	public void setStrWardCode(String strWardCode) {
		this.strWardCode = strWardCode;
	}
	
//	Methods starts from here
		
	/**
	 *  This method will be used to insert the records
	 * @param dao : HisDAO Object
	 * @throws Exception - when Requisition No. is blank
	 */
	public void insert(HisDAO dao) throws Exception {
		
		strErr = "";
		
		try {
			//check mandatory information
			if(strReqNo.equals("0") || strReqNo.equals("")) {
				throw new Exception("Requisition No. can not be blank");
			}
			
			if(this.nRowInserted == 0) {
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			
			//set the value
			//Input Value
			dao.setProcInValue(nInsertedIndex,"modval","1",1);
			dao.setProcInValue(nInsertedIndex,"hblnum_req_no",strReqNo,2);
			dao.setProcInValue(nInsertedIndex,"hbldt_req_date","",3);
			dao.setProcInValue(nInsertedIndex,"gnum_dept_code",strDeptCode,4);
			dao.setProcInValue(nInsertedIndex,"sblnum_chargetype_id",strChargeTypeId,5);
			dao.setProcInValue(nInsertedIndex,"sblnum_bservice_id",strBServiceId,6);
			dao.setProcInValue(nInsertedIndex,"sblnum_service_id",strServiceId,7);
			dao.setProcInValue(nInsertedIndex,"gstr_req_no",strGblReqNo,8);
			dao.setProcInValue(nInsertedIndex,"gnum_patient_cat_code",strCatCode,9);
			dao.setProcInValue(nInsertedIndex,"hrgnum_episode_code",strEpisodeCode,10);
			dao.setProcInValue(nInsertedIndex,"hrgnum_puk",strPuk,11);
			dao.setProcInValue(nInsertedIndex,"hastr_adm_no",strAdmNo,12);
			dao.setProcInValue(nInsertedIndex,"hblnum_pataccount_no",strPatAccNo,13);
			dao.setProcInValue(nInsertedIndex,"hblnum_approval_id",strAppId,14);
			dao.setProcInValue(nInsertedIndex,"hblnum_bill_no",strBillNo,15);
			dao.setProcInValue(nInsertedIndex,"hblstr_remarks",strRemarks,16);
			dao.setProcInValue(nInsertedIndex,"hblnum_status",strStatus,17);
			dao.setProcInValue(nInsertedIndex,"gdt_entry_date","",18);
			dao.setProcInValue(nInsertedIndex,"gnum_seatid",strSeatId,19);
			dao.setProcInValue(nInsertedIndex,"gnum_isvalid",strIsValid,20);
			dao.setProcInValue(nInsertedIndex,"hblnum_cancel_no",strCancelNo,21);
			dao.setProcInValue(nInsertedIndex,"hbldt_cancel_date","sysdate",22);
			dao.setProcInValue(nInsertedIndex,"hblstr_approved_by",strAppBy,23);
			dao.setProcInValue(nInsertedIndex,"hbldt_approved_date","",24);
			dao.setProcInValue(nInsertedIndex,"hblnum_req_type",strReqType,25);
			dao.setProcInValue(nInsertedIndex,"sblnum_ipd_chargetype_id",strIpdChargeTypeId,26);
			dao.setProcInValue(nInsertedIndex,"hipnum_ward_code",strWardCode,27);
			dao.setProcInValue(nInsertedIndex,"hblnum_reciept_no",strReceiptNo,28);
			dao.setProcInValue(nInsertedIndex,"hosp_code",strHospitalCode,29);  // New Value
			dao.setProcInValue(nInsertedIndex,"processing_penalty",strProcessFeePenalty,30);  // Processing Penalty
			
			//output value
			dao.setProcOutValue(nInsertedIndex,"err",1,31);
			
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
	 * Used to update the record
	 * @param dao :: HisDAO object
	 * @throws Exception : 
	 */
	public void update1(HisDAO dao) throws Exception {
		
		this.strErr = "";
		try {
			
			this.nRowUpdated++;
		}
		catch(Exception e) {
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update1() --> " + this.strErr);
		}
		finally {
			this.reset();
		}
	}
	
	/*
	 * This method will be used to delete the records based on the conditions
	 */
	public void delete1(HisDAO dao) throws Exception {
		
		this.strErr = "";
		try {
			this.nRowDeleted++;
		}
		catch(Exception e) {
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".delete1() --> " + this.strErr);
		}
		finally {
			this.reset();
		}
	}
	
	/**
	 * This method will be used to clear all the variables
	 */
	private void reset() {
		
		strReqNo = "0";
		strReqDate = "";
		strDeptCode = "0";
		strChargeTypeId = "0";
		strBServiceId = "0";
		strServiceId = "0";
		strGblReqNo = "";
		strCatCode = "0";
		strEpisodeCode = "0";
		strPuk = "0";
		strAdmNo = "0";
		strPatAccNo = "0";
		strAppId = "0";
		strBillNo = "0";
		strRemarks = "";
		strStatus = "1";
		strEntryDate = "";
		strSeatId = "0";
		strIsValid = "1";
		strCancelNo = "0";
		strCancelDate = "";
		strAppBy = "";
		strAppDate = "";
		strReqType = "1";
		strIpdChargeTypeId = "0";
		strWardCode = "0";
		strReceiptNo = "1";
		strHospitalCode = "0";
	}

}
