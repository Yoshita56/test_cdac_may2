package billing.dao;

import hisglobal.transactionmgnt.HisDAO;

/**
 * Developer : Anshul Jindal 
 * Version : 1.0 
 * Date : 21/Aug/2008
 * 
 * This class will be used to insert/update/delete the records 
 * Table Name : Sblt_Outbound_Dtl 
 * Procedure Name : PKG_BILL_DML.dml_Sblt_Outbound_Dtl
 */

public class OutBoundDAO {

	private String strTransNo = "0";
	private String strTransDate = "";
	private String strReceiptNo = "1";
	private String strPatAccNo = "0";
	private String strRequestNo = "0";
	private String strPatName = "";
	private String strReqDate = "";
	private String strPuk = "0";
	private String strAdmNo = "0";
	private String strEpisodeCode = "0";
	private String strPatientCatCode = "0";
	private String strTransAmt = "0";
	private String strDeptCode = "0";
	private String strChargeTypeId = "0";
	private String strIpdChargeTypeId = "0";
	private String strCounterId = "0";
	private String strBServiceId = "0";
	private String strServiceId = "0";
	private String strStatus = "1";
	private String strGblRequestNo = "";
	private String strRemarks = "";
	private String strDayEndFlag = "0";
	private String strEntryDate = "";
	private String strSeatId = "0";
	private String strIsValid = "1";
	private String strTransType = "1";
	private String strWardCode = "0";
	private String strIsBill = "1";
	private String strIsOnline = "1";
	private String strHospitalCode = "0";
	// It is mandatory parameter, do not reset the following variables
	private String strErr = "";
	private String strCreditBillFlag = "0";
	private String strCreditBillStatus = "0";//0-Not Approved,1-Approved,2-Direct(No Approval Required)
	private String stripadd="";
	private String strmacadd="";

	private final String strProcName = "PKG_BILL_DML.dml_Sblt_Outbound_Dtl";
	private final String strFileName = "billing.dao.OutBoundDAO";

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

	public void setStripadd(String stripadd) {
		this.stripadd = stripadd;
	}

	public void setStrmacadd(String strmacadd) {
		this.strmacadd = strmacadd;
	}

	/**
	 * @param strTransNo the strTransNo to set
	 */
	public void setStrIsBill(String strIsBill) {
		this.strIsBill = strIsBill;
	}

	/**
	 * @param strTransDate the strTransDate to set
	 */
	public void setStrIsOnline(String strIsOnline) {
		this.strIsOnline = strIsOnline;
	}

	
	/**
	 * @param strTransNo the strTransNo to set
	 */
	public void setStrTransNo(String strTransNo) {
		this.strTransNo = strTransNo;
	}

	/**
	 * @param strTransDate the strTransDate to set
	 */
	public void setStrTransDate(String strTransDate) {
		this.strTransDate = strTransDate;
	}

	/**
	 * @param strReceiptNo the strReceiptNo to set
	 */
	public void setStrReceiptNo(String strReceiptNo) {
		this.strReceiptNo = strReceiptNo;
	}

	/**
	 * @param strPatAccNo the strPatAccNo to set
	 */
	public void setStrPatAccNo(String strPatAccNo) {
		this.strPatAccNo = strPatAccNo;
	}

	/**
	 * @param strRequestNo the strRequestNo to set
	 */
	public void setStrRequestNo(String strRequestNo) {
		this.strRequestNo = strRequestNo;
	}

	/**
	 * @param strPatName the strPatName to set
	 */
	public void setStrPatName(String strPatName) {
		this.strPatName = strPatName;
	}

	/**
	 * @param strReqDate the strReqDate to set
	 */
	public void setStrReqDate(String strReqDate) {
		this.strReqDate = strReqDate;
	}

	/**
	 * @param strPuk the strPuk to set
	 */
	public void setStrPuk(String strPuk) {
		this.strPuk = strPuk;
	}

	/**
	 * @param strAdmNo the strAdmNo to set
	 */
	public void setStrAdmNo(String strAdmNo) {
		this.strAdmNo = strAdmNo;
	}

	/**
	 * @param strEpisodeCode the strEpisodeCode to set
	 */
	public void setStrEpisodeCode(String strEpisodeCode) {
		this.strEpisodeCode = strEpisodeCode;
	}

	/**
	 * @param strPatientCatCode the strPatientCatCode to set
	 */
	public void setStrPatientCatCode(String strPatientCatCode) {
		this.strPatientCatCode = strPatientCatCode;
	}

	/**
	 * @param strTransAmt the strTransAmt to set
	 */
	public void setStrTransAmt(String strTransAmt) {
		this.strTransAmt = strTransAmt;
	}

	/**
	 * @param strDeptCode the strDeptCode to set
	 */
	public void setStrDeptCode(String strDeptCode) {
		this.strDeptCode = strDeptCode;
	}

	/**
	 * @param strChargeTypeId the strChargeTypeId to set
	 */
	public void setStrChargeTypeId(String strChargeTypeId) {
		this.strChargeTypeId = strChargeTypeId;
	}

	/**
	 * @param strIpdChargeTypeId the strIpdChargeTypeId to set
	 */
	public void setStrIpdChargeTypeId(String strIpdChargeTypeId) {
		this.strIpdChargeTypeId = strIpdChargeTypeId;
	}

	/**
	 * @param strCounterId the strCounterId to set
	 */
	public void setStrCounterId(String strCounterId) {
		this.strCounterId = strCounterId;
	}

	/**
	 * @param strBServiceId the strBServiceId to set
	 */
	public void setStrBServiceId(String strBServiceId) {
		this.strBServiceId = strBServiceId;
	}

	/**
	 * @param strServiceId the strServiceId to set
	 */
	public void setStrServiceId(String strServiceId) {
		this.strServiceId = strServiceId;
	}

	/**
	 * @param strStatus the strStatus to set
	 */
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}

	/**
	 * @param strGblRequestNo the strGblRequestNo to set
	 */
	public void setStrGblRequestNo(String strGblRequestNo) {
		this.strGblRequestNo = strGblRequestNo;
	}

	/**
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * @param strDayEndFlag the strDayEndFlag to set
	 */
	public void setStrDayEndFlag(String strDayEndFlag) {
		this.strDayEndFlag = strDayEndFlag;
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

	/**
	 * @param strTransType the strTransType to set
	 */
	public void setStrTransType(String strTransType) {
		this.strTransType = strTransType;
	}

	/**
	 * @param strWardCode the strWardCode to set
	 */
	public void setStrWardCode(String strWardCode) {
		this.strWardCode = strWardCode;
	}
	
	
	

	// Methods starts from here

	/**
	 * This method will be used to insert the records
	 * 
	 * @param dao :
	 *            HisDAO Object
	 * @throws Exception -
	 *             when Trans No. or Receipt No is blank
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";

		try {
			// check mandatory information
			if (strTransNo.equals("0") || strTransNo.equals("")) {
				throw new Exception("Trans No. can not be blank");
			}
			if (strReceiptNo.equals("0") || strReceiptNo.equals("")) {
				throw new Exception("Receipt No can not be blank");
			}


			if (this.nRowInserted == 0) {
				nInsertedIndex = dao
						.setProcedure("{call "+ strProcName+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}

			// set the value
			// Input Value
			dao.setProcInValue(nInsertedIndex, "modval", "1",1);
			dao.setProcInValue(nInsertedIndex, "hblnum_trans_no", strTransNo,2);
			dao.setProcInValue(nInsertedIndex, "hbldt_trans_date",strTransDate,3);
			dao.setProcInValue(nInsertedIndex, "hblnum_reciept_no",strReceiptNo,4);
			dao.setProcInValue(nInsertedIndex, "hblnum_pataccount_no",strPatAccNo,5);
			dao.setProcInValue(nInsertedIndex, "hblnum_req_no",strRequestNo,6);
			dao.setProcInValue(nInsertedIndex, "hblstr_patient_name", strPatName,7);
			dao.setProcInValue(nInsertedIndex, "hbldt_req_date",strReqDate,8);
			dao.setProcInValue(nInsertedIndex, "hrgnum_puk", strPuk,9);
			dao.setProcInValue(nInsertedIndex, "hastr_adm_no",strAdmNo,10);
			dao.setProcInValue(nInsertedIndex, "hrgnum_episode_code",strEpisodeCode,11);
			dao.setProcInValue(nInsertedIndex, "gnum_patient_cat_code",strPatientCatCode,12);
			dao.setProcInValue(nInsertedIndex, "hblnum_trans_amt", strTransAmt,13);
			dao.setProcInValue(nInsertedIndex, "gnum_dept_code",strDeptCode,14);
			dao.setProcInValue(nInsertedIndex, "sblnum_chargetype_id",strChargeTypeId,15);
			dao.setProcInValue(nInsertedIndex, "sblnum_ipd_chargetype_id",strIpdChargeTypeId,16);
			dao.setProcInValue(nInsertedIndex, "hblnum_counter_id", strCounterId,17);
			dao.setProcInValue(nInsertedIndex, "sblnum_bservice_id", strBServiceId,18);
			dao.setProcInValue(nInsertedIndex, "sblnum_service_id",strServiceId,19);
			dao.setProcInValue(nInsertedIndex, "hblnum_status",strStatus,20);
			dao.setProcInValue(nInsertedIndex, "gstr_req_no",strGblRequestNo,21);
			dao.setProcInValue(nInsertedIndex, "hblstr_remarks",strRemarks,22);
			dao.setProcInValue(nInsertedIndex, "sblnum_dayend_flag", strDayEndFlag,23);
			dao.setProcInValue(nInsertedIndex, "gdt_entry_date",strEntryDate,24);
			dao.setProcInValue(nInsertedIndex, "gnum_seatid", strSeatId,25);
			dao.setProcInValue(nInsertedIndex, "gnum_isvalid", strIsValid,26);
			dao.setProcInValue(nInsertedIndex, "hblnum_trans_type",strTransType,27);
			dao.setProcInValue(nInsertedIndex, "hipnum_ward_code", strWardCode,28);
			dao.setProcInValue(nInsertedIndex, "hblnum_is_bill", strIsBill,29);
			dao.setProcInValue(nInsertedIndex, "hblnum_is_online", strIsOnline,30);
			dao.setProcInValue(nInsertedIndex,"hosp_code",strHospitalCode,31);
			dao.setProcInValue(nInsertedIndex,"credit_bill_flag",strCreditBillFlag,32);
			dao.setProcInValue(nInsertedIndex,"credit_bill_status",strCreditBillStatus,33);
			dao.setProcInValue(nInsertedIndex, "ip",stripadd,34);
			dao.setProcInValue(nInsertedIndex, "mac",strmacadd,35);
			dao.setProcOutValue(nInsertedIndex, "err", 1,36);
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

		 strTransNo = "0";
		 strTransDate = "";
		 strReceiptNo = "1";
		 strPatAccNo = "0";
		 strRequestNo = "0";
		 strPatName = "";
		 strReqDate = "";
		 strPuk = "0";
		 strAdmNo = "0";
		 strEpisodeCode = "0";
		 strPatientCatCode = "0";
		 strTransAmt = "0";
		 strDeptCode = "0";
		 strChargeTypeId = "0";
		 strIpdChargeTypeId = "0";
		 strCounterId = "0";
		 strBServiceId = "0";
		 strServiceId = "0";
		 strStatus = "1";
		 strGblRequestNo = "";
		 strRemarks = "";
	     strDayEndFlag = "0";
	     strEntryDate = "";
		 strSeatId = "0";
		 strIsValid = "1";
		 strTransType = "1";
		 strWardCode = "0";
		 strIsBill = "1";
		 strIsOnline = "1";
		 strHospitalCode = "0";
		 stripadd="";
		 strmacadd="";
		
		
	}

	public void setStrCreditBillFlag(String strCreditBillFlag) {
		this.strCreditBillFlag = strCreditBillFlag;
	}

	public void setStrCreditBillStatus(String strCreditBillStatus) {
		this.strCreditBillStatus = strCreditBillStatus;
	}
}
