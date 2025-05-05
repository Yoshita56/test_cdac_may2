package billing.dao;

import hisglobal.transactionmgnt.HisDAO;

/**
 * Developer : Anshul Jindal 
 * Version : 1.0 
 * Date : 21/Aug/2008
 * 
 * This class will be used to insert/update/delete the records 
 * Table Name : Hblt_Bill_Detail 
 * Procedure Name : PKG_BILL_DML.dml_Hblt_Bill_Detail
 */

public class BillDAO {
	
	private String strBillNo = "0";
	private String strBillDate = "";
	private String strRequestNo = "";
	private String strPatAccNo = "0";
	private String strClientPatNo = "0";
	private String strAdmNo = "0";
	private String strBServiceId = "0";
	private String strDeptCode = "0";
	private String strPatientCatCode = "0";
	private String strServiceId = "0";
	private String strChargeTypeId = "0";
	private String strEpisodeCode = "0";
	private String strPatName = "";
	private String strPatAddress = "";
	private String strContactNo = "";
	private String strPuk = "0";
	private String strSancAmt = "0";
	private String strClientBalance = "0";
	private String strTariffNetAmt = "0";
	private String strClientNetAmt = "0";
	private String strActualNetAmt = "0";
	private String strRemarks = "";
	private String strPatientNetAmt = "0";
	private String strStatus = "1";
	private String strDiscountNetAmt = "0";
	private String strReconcileNetAmt = "0";
	private String strSeatId = "0";
	private String strServTaxNetAmt = "0";
	private String strPenaltyNetAmt = "0";
	private String strEntryDate = "";
	private String strIsValid = "1";
	private String strRefundNetAmt = "0";
	private String strWardCode = "0";
	private String strIpdChargeTypeId = "0";
	private String strHospitalCode = "0";
	private String stripadd="";
	private String strmacadd="";
	
	

	// It is mandatory parameter, do not reset the following variables
	private String strErr = "";

	private final String strProcName = "PKG_BILL_DML.dml_Hblt_Bill_Detail";
	private final String strFileName = "billing.dao.BillDAO";

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
	 * @param strBillNo the strBillNo to set
	 */
	public void setStrBillNo(String strBillNo) {
		this.strBillNo = strBillNo;
	}

	/**
	 * @param strBillDate the strBillDate to set
	 */
	public void setStrBillDate(String strBillDate) {
		this.strBillDate = strBillDate;
	}

	/**
	 * @param strRequestNo the strRequestNo to set
	 */
	public void setStrRequestNo(String strRequestNo) {
		this.strRequestNo = strRequestNo;
	}

	/**
	 * @param strPatAccNo the strPatAccNo to set
	 */
	public void setStrPatAccNo(String strPatAccNo) {
		this.strPatAccNo = strPatAccNo;
	}

	/**
	 * @param strClientPatNo the strClientPatNo to set
	 */
	public void setStrClientPatNo(String strClientPatNo) {
		this.strClientPatNo = strClientPatNo;
	}

	/**
	 * @param strAdmNo the strAdmNo to set
	 */
	public void setStrAdmNo(String strAdmNo) {
		this.strAdmNo = strAdmNo;
	}

	/**
	 * @param strBServiceId the strBServiceId to set
	 */
	public void setStrBServiceId(String strBServiceId) {
		this.strBServiceId = strBServiceId;
	}

	/**
	 * @param strDeptCode the strDeptCode to set
	 */
	public void setStrDeptCode(String strDeptCode) {
		this.strDeptCode = strDeptCode;
	}

	/**
	 * @param strPatientCatCode the strPatientCatCode to set
	 */
	public void setStrPatientCatCode(String strPatientCatCode) {
		this.strPatientCatCode = strPatientCatCode;
	}

	/**
	 * @param strServiceId the strServiceId to set
	 */
	public void setStrServiceId(String strServiceId) {
		this.strServiceId = strServiceId;
	}

	/**
	 * @param strChargeTypeId the strChargeTypeId to set
	 */
	public void setStrChargeTypeId(String strChargeTypeId) {
		this.strChargeTypeId = strChargeTypeId;
	}

	/**
	 * @param strEpisodeCode the strEpisodeCode to set
	 */
	public void setStrEpisodeCode(String strEpisodeCode) {
		this.strEpisodeCode = strEpisodeCode;
	}

	/**
	 * @param strPatName the strPatName to set
	 */
	public void setStrPatName(String strPatName) {
		this.strPatName = strPatName;
	}

	/**
	 * @param strPatAddress the strPatAddress to set
	 */
	public void setStrPatAddress(String strPatAddress) {
		this.strPatAddress = strPatAddress;
	}

	/**
	 * @param strContactNo the strContactNo to set
	 */
	public void setStrContactNo(String strContactNo) {
		this.strContactNo = strContactNo;
	}

	/**
	 * @param strPuk the strPuk to set
	 */
	public void setStrPuk(String strPuk) {
		this.strPuk = strPuk;
	}

	/**
	 * @param strSancAmt the strSancAmt to set
	 */
	public void setStrSancAmt(String strSancAmt) {
		this.strSancAmt = strSancAmt;
	}

	/**
	 * @param strClientBalance the strClientBalance to set
	 */
	public void setStrClientBalance(String strClientBalance) {
		this.strClientBalance = strClientBalance;
	}

	/**
	 * @param strTariffNetAmt the strTariffNetAmt to set
	 */
	public void setStrTariffNetAmt(String strTariffNetAmt) {
		this.strTariffNetAmt = strTariffNetAmt;
	}

	/**
	 * @param strClientNetAmt the strClientNetAmt to set
	 */
	public void setStrClientNetAmt(String strClientNetAmt) {
		this.strClientNetAmt = strClientNetAmt;
	}

	/**
	 * @param strActualNetAmt the strActualNetAmt to set
	 */
	public void setStrActualNetAmt(String strActualNetAmt) {
		this.strActualNetAmt = strActualNetAmt;
	}

	/**
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * @param strPatientNetAmt the strPatientNetAmt to set
	 */
	public void setStrPatientNetAmt(String strPatientNetAmt) {
		this.strPatientNetAmt = strPatientNetAmt;
	}

	/**
	 * @param strStatus the strStatus to set
	 */
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}

	/**
	 * @param strDiscountNetAmt the strDiscountNetAmt to set
	 */
	public void setStrDiscountNetAmt(String strDiscountNetAmt) {
		this.strDiscountNetAmt = strDiscountNetAmt;
	}

	/**
	 * @param strReconcileNetAmt the strReconcileNetAmt to set
	 */
	public void setStrReconcileNetAmt(String strReconcileNetAmt) {
		this.strReconcileNetAmt = strReconcileNetAmt;
	}

	/**
	 * @param strSeatId the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * @param strServTaxNetAmt the strServTaxNetAmt to set
	 */
	public void setStrServTaxNetAmt(String strServTaxNetAmt) {
		this.strServTaxNetAmt = strServTaxNetAmt;
	}

	/**
	 * @param strPenaltyNetAmt the strPenaltyNetAmt to set
	 */
	public void setStrPenaltyNetAmt(String strPenaltyNetAmt) {
		this.strPenaltyNetAmt = strPenaltyNetAmt;
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

	/**
	 * @param strRefundNetAmt the strRefundNetAmt to set
	 */
	public void setStrRefundNetAmt(String strRefundNetAmt) {
		this.strRefundNetAmt = strRefundNetAmt;
	}

	/**
	 * @param strWardCode the strWardCode to set
	 */
	public void setStrWardCode(String strWardCode) {
		this.strWardCode = strWardCode;
	}

	/**
	 * @param strIpdChargeTypeId the strIpdChargeTypeId to set
	 */
	public void setStrIpdChargeTypeId(String strIpdChargeTypeId) {
		this.strIpdChargeTypeId = strIpdChargeTypeId;
	}

	public void setStripadd(String stripadd) {
		this.stripadd = stripadd;
	}

	public void setStrmacadd(String strmacadd) {
		this.strmacadd = strmacadd;
	}
	
	// Methods starts from here

	

	/**
	 * This method will be used to insert the records
	 * 
	 * @param dao :
	 *            HisDAO Object
	 * @throws Exception -
	 *             when BillNo. is blank
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";

		try {
			
			// check mandatory information
			if (strBillNo.equals("0") || strBillNo.equals("")) {
				throw new Exception("BillNo. can not be blank");
			}

			if (this.nRowInserted == 0) {
				nInsertedIndex = dao.setProcedure("{call "+ strProcName+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			// set the value
			// Input Value
			dao.setProcInValue(nInsertedIndex, "modval", "1",1);
			dao.setProcInValue(nInsertedIndex, "hblnum_bill_no", strBillNo,2);
			dao.setProcInValue(nInsertedIndex, "hbldt_bill_date",strBillDate,3);
			dao.setProcInValue(nInsertedIndex, "gstr_req_no",strRequestNo,4);
			dao.setProcInValue(nInsertedIndex, "hblnum_pataccount_no",strPatAccNo,5);
			dao.setProcInValue(nInsertedIndex, "hblnum_client_patient_no",strClientPatNo,6);
			dao.setProcInValue(nInsertedIndex, "hastr_adm_no", strAdmNo,7);
			dao.setProcInValue(nInsertedIndex, "sblnum_bservice_id",strBServiceId,8);
			dao.setProcInValue(nInsertedIndex, "gnum_dept_code", strDeptCode,9);
			dao.setProcInValue(nInsertedIndex, "gnum_patient_cat_code",strPatientCatCode,10);
			dao.setProcInValue(nInsertedIndex, "sblnum_service_id",strServiceId,11);
			dao.setProcInValue(nInsertedIndex, "sblnum_chargetype_id",strChargeTypeId,12);
			dao.setProcInValue(nInsertedIndex, "hrgnum_episode_code", strEpisodeCode,13);
			dao.setProcInValue(nInsertedIndex, "hblstr_patient_name",strPatName,14);
			dao.setProcInValue(nInsertedIndex, "hblstr_patient_address",strPatAddress,15);
			dao.setProcInValue(nInsertedIndex, "hblstr_contact_no",strContactNo,16);
			dao.setProcInValue(nInsertedIndex, "hrgnum_puk", strPuk,17);
			dao.setProcInValue(nInsertedIndex, "hblnum_sanc_amt", strSancAmt,18);
			dao.setProcInValue(nInsertedIndex, "hblnum_client_balance",strClientBalance,19);
			dao.setProcInValue(nInsertedIndex, "hblnum_tariff_net_amt",strTariffNetAmt,20);
			dao.setProcInValue(nInsertedIndex, "hblnum_client_net_amt",strClientNetAmt,21);
			dao.setProcInValue(nInsertedIndex, "hblnum_actual_net_amt",strActualNetAmt,22);
			dao.setProcInValue(nInsertedIndex, "hblstr_remarks", strRemarks,23);
			dao.setProcInValue(nInsertedIndex, "hblnum_patient_net_amt",strPatientNetAmt,24);
			dao.setProcInValue(nInsertedIndex, "hblnum_status", strStatus,25);
			dao.setProcInValue(nInsertedIndex, "hblnum_discount_net_amt",strDiscountNetAmt,26);
			dao.setProcInValue(nInsertedIndex, "hblnum_reconcile_net_amt",strReconcileNetAmt,27);
			dao.setProcInValue(nInsertedIndex, "gnum_seatid", strSeatId,28);
			dao.setProcInValue(nInsertedIndex, "hblnum_sertax_net_amt",strServTaxNetAmt,29);
			dao.setProcInValue(nInsertedIndex, "hblnum_penelty_net_amt",strPenaltyNetAmt,30);
			dao.setProcInValue(nInsertedIndex, "gdt_entry_date", strEntryDate,31);
			dao.setProcInValue(nInsertedIndex, "gnum_isvalid", strIsValid,32);
			dao.setProcInValue(nInsertedIndex, "hblnum_refund_net_amt",strRefundNetAmt,33);
			dao.setProcInValue(nInsertedIndex, "hipnum_ward_code", strWardCode,34);
			dao.setProcInValue(nInsertedIndex, "sblnum_ipd_chargetype_id",strIpdChargeTypeId,35);
			dao.setProcInValue(nInsertedIndex,"hosp_code",strHospitalCode,36);  // New Value
			dao.setProcInValue(nInsertedIndex, "ip",stripadd,37);
			dao.setProcInValue(nInsertedIndex, "mac",strmacadd,38);
			// output value
			dao.setProcOutValue(nInsertedIndex, "err", 1,39);
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
		 strBillDate = "";
		 strRequestNo = "";
		 strPatAccNo = "0";
		 strClientPatNo = "0";
		 strAdmNo = "0";
		 strBServiceId = "0";
		 strDeptCode = "0";
		 strPatientCatCode = "0";
		 strServiceId = "0";
		 strChargeTypeId = "0";
		 strEpisodeCode = "0";
		 strPatName = "";
		 strPatAddress = "";
		 strContactNo = "";
		 strPuk = "0";
		 strSancAmt = "0";
		 strClientBalance = "0";
		 strTariffNetAmt = "0";
		 strClientNetAmt = "0";
		 strActualNetAmt = "0";
		 strRemarks = "";
		 strPatientNetAmt = "0";
		 strStatus = "1";
		 strDiscountNetAmt = "0";
		 strReconcileNetAmt = "0";
		 strSeatId = "0";
		 strServTaxNetAmt = "0";
		 strPenaltyNetAmt = "0";
	     strEntryDate = "";
		 strIsValid = "1";
		 strRefundNetAmt = "0";
		 strWardCode = "0";
		 strIpdChargeTypeId = "0";
		 strHospitalCode = "0";
		 stripadd="";
		 strmacadd="";
	}

}
