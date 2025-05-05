/**
 * 
 */
package billing.dao;

import hisglobal.transactionmgnt.HisDAO;

/**
 * Developer : Anshul Jindal 
 * Version : 1.0 
 * Date : 21/Aug/2008
 * 
 * This class will be used to insert/update/delete the records 
 * Table Name : Hblt_Bill_Reciept_Dtl 
 * Procedure Name : PKG_BILL_DML.dml_Hblt_Bill_Reciept_Dtl
 */

public class BillReceiptDAO {

	private String strBillNo = "0";
	private String strReceiptNo = "1";
	private String strReceiptDate = "";
	private String strReceiptType = "1";
	private String strRequestNo = "0";
	private String strRequestDate = "";
	private String strPuk = "0";
	private String strAdmNo = "0";
	private String strPatAccNo = "0";
	private String strPatName = "";
	private String strClientPatNo = "0";
	private String strChargeTypeId = "1";
	private String strBServiceId = "1";
	private String strServiceId = "0";
	private String strDeptCode = "0";
	private String strPatientCatCode = "0";
	private String strClientBalance = "0";
	private String strPatientTAmt = "0";
	private String strClientTotAmt = "0";
	private String strActualTotAmt = "0";
	private String strTariffTotAmt = "0";
	private String strDiscountTotAmt = "0";
	private String strServTaxTotAmt = "0";
	private String strPenaltyAmt = "0";
	private String strReqNo = "0";
	private String strCancelNo = "0";
	private String strCounterId = "0";
	private String strApprovalId = "0";
	private String strApprovedBy = "0";
	private String strApprovedDate = "";
	private String strRemarks = "0";
	private String strStatus = "0";
	private String strEntryDate = "";
	private String strSeatId = "0";
	private String strIsValid = "1";
	private String strWardCode = "0";
	private String strIpdChargeTypeId = "0";
	private String strIsOnline = "1";
	private String strIsBill = "1";
	private String strHospitalCode = "0";
	private String strCreditBillFlag="0";
	private String strClNo="0";
	private String strClDate="";
	private String strClPath="";
	private String strClientNo="0";
	private String strCreditBillStatus="0";
	private String strClCardNoId="0";
	private String strClCardHolderName="";
	private String strCreditRelationWithStaff="";
	private String strClValidity="";
	private String stripadd="";
	private String strmacadd="";
	
	

	// It is mandatory parameter, do not reset the following variables
	private String strErr = "";

	private final String strProcName = "PKG_BILL_DML.dml_Hblt_Bill_Reciept_Dtl";
	private final String strFileName = "billing.dao.BillReceiptDAO";

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
	 * @param strReceiptNo
	 *            the strReceiptNo to set
	 */
	public void setStrReceiptNo(String strReceiptNo) {
		this.strReceiptNo = strReceiptNo;
	}

	/**
	 * @param strReceiptDate
	 *            the strReceiptDate to set
	 */
	public void setStrReceiptDate(String strReceiptDate) {
		this.strReceiptDate = strReceiptDate;
	}

	/**
	 * @param strReceiptType
	 *            the strReceiptType to set
	 */
	public void setStrReceiptType(String strReceiptType) {
		this.strReceiptType = strReceiptType;
	}

	/**
	 * @param strRequestNo
	 *            the strRequestNo to set
	 */
	public void setStrRequestNo(String strRequestNo) {
		this.strRequestNo = strRequestNo;
	}

	/**
	 * @param strRequestDate
	 *            the strRequestDate to set
	 */
	public void setStrRequestDate(String strRequestDate) {
		this.strRequestDate = strRequestDate;
	}

	/**
	 * @param strPuk
	 *            the strPuk to set
	 */
	public void setStrPuk(String strPuk) {
		this.strPuk = strPuk;
	}

	/**
	 * @param strAdmNo
	 *            the strAdmNo to set
	 */
	public void setStrAdmNo(String strAdmNo) {
		this.strAdmNo = strAdmNo;
	}

	/**
	 * @param strPatAccNo
	 *            the strPatAccNo to set
	 */
	public void setStrPatAccNo(String strPatAccNo) {
		this.strPatAccNo = strPatAccNo;
	}

	/**
	 * @param strPatName
	 *            the strPatName to set
	 */
	public void setStrPatName(String strPatName) {
		this.strPatName = strPatName;
	}

	/**
	 * @param strClientPatNo
	 *            the strClientPatNo to set
	 */
	public void setStrClientPatNo(String strClientPatNo) {
		this.strClientPatNo = strClientPatNo;
	}

	/**
	 * @param strChargeTypeId
	 *            the strChargeTypeId to set
	 */
	public void setStrChargeTypeId(String strChargeTypeId) {
		this.strChargeTypeId = strChargeTypeId;
	}

	/**
	 * @param strBServiceId
	 *            the strBServiceId to set
	 */
	public void setStrBServiceId(String strBServiceId) {
		this.strBServiceId = strBServiceId;
	}

	/**
	 * @param strServiceId
	 *            the strServiceId to set
	 */
	public void setStrServiceId(String strServiceId) {
		this.strServiceId = strServiceId;
	}

	/**
	 * @param strDeptCode
	 *            the strDeptCode to set
	 */
	public void setStrDeptCode(String strDeptCode) {
		this.strDeptCode = strDeptCode;
	}

	/**
	 * @param strPatientCatCode
	 *            the strPatientCatCode to set
	 */
	public void setStrPatientCatCode(String strPatientCatCode) {
		this.strPatientCatCode = strPatientCatCode;
	}

	/**
	 * @param strClientBalance
	 *            the strClientBalance to set
	 */
	public void setStrClientBalance(String strClientBalance) {
		this.strClientBalance = strClientBalance;
	}

	/**
	 * @param strPatientTAmt
	 *            the strPatientTAmt to set
	 */
	public void setStrPatientTAmt(String strPatientTAmt) {
		this.strPatientTAmt = strPatientTAmt;
	}

	/**
	 * @param strClientTotAmt
	 *            the strClientTotAmt to set
	 */
	public void setStrClientTotAmt(String strClientTotAmt) {
		this.strClientTotAmt = strClientTotAmt;
	}

	/**
	 * @param strActualTotAmt
	 *            the strActualTotAmt to set
	 */
	public void setStrActualTotAmt(String strActualTotAmt) {
		this.strActualTotAmt = strActualTotAmt;
	}

	/**
	 * @param strTariffTotAmt
	 *            the strTariffTotAmt to set
	 */
	public void setStrTariffTotAmt(String strTariffTotAmt) {
		this.strTariffTotAmt = strTariffTotAmt;
	}

	/**
	 * @param strDiscountTotAmt
	 *            the strDiscountTotAmt to set
	 */
	public void setStrDiscountTotAmt(String strDiscountTotAmt) {
		this.strDiscountTotAmt = strDiscountTotAmt;
	}

	/**
	 * @param strServTaxTotAmt
	 *            the strServTaxTotAmt to set
	 */
	public void setStrServTaxTotAmt(String strServTaxTotAmt) {
		this.strServTaxTotAmt = strServTaxTotAmt;
	}

	/**
	 * @param strpenaltyAmt
	 *            the strpenaltyAmt to set
	 */
	public void setStrPenaltyAmt(String strPenaltyAmt) {
		this.strPenaltyAmt = strPenaltyAmt;
	}

	/**
	 * @param strReqNo
	 *            the strReqNo to set
	 */
	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
	}

	/**
	 * @param strCancelNo
	 *            the strCancelNo to set
	 */
	public void setStrCancelNo(String strCancelNo) {
		this.strCancelNo = strCancelNo;
	}

	/**
	 * @param stCounterId
	 *            the stCounterId to set
	 */
	public void setStrCounterId(String strCounterId) {
		this.strCounterId = strCounterId;
	}

	/**
	 * @param strApprovalId
	 *            the strApprovalId to set
	 */
	public void setStrApprovalId(String strApprovalId) {
		this.strApprovalId = strApprovalId;
	}

	/**
	 * @param strApprovedBy
	 *            the strApprovedBy to set
	 */
	public void setStrApprovedBy(String strApprovedBy) {
		this.strApprovedBy = strApprovedBy;
	}

	/**
	 * @param strApprovedDate
	 *            the strApprovedDate to set
	 */
	public void setStrApprovedDate(String strApprovedDate) {
		this.strApprovedDate = strApprovedDate;
	}

	/**
	 * @param strRemarks
	 *            the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * @param strStatus
	 *            the strStatus to set
	 */
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}

	/**
	 * @param strEntryDate
	 *            the strEntryDate to set
	 */
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}

	/**
	 * @param strSeatId
	 *            the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * @param strIsValid
	 *            the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	/**
	 * @param strWardCode
	 *            the strWardCode to set
	 */
	public void setStrWardCode(String strWardCode) {
		this.strWardCode = strWardCode;
	}

	/**
	 * @param strIpdChargeTypeId
	 *            the strIpdChargeTypeId to set
	 */
	public void setStrIpdChargeTypeId(String strIpdChargeTypeId) {
		this.strIpdChargeTypeId = strIpdChargeTypeId;
	}

	/**
	 * @param strIsOnline
	 *            the strIsOnline to set
	 */
	public void setStrIsOnline(String strIsOnline) {
		this.strIsOnline = strIsOnline;
	}

	/**
	 * @param strIsBill
	 *            the strIsBill to set
	 */
	public void setStrIsBill(String strIsBill) {
		this.strIsBill = strIsBill;
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
	 *             when BillNo. or Receipt No. is blank
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";

		try {
			// check mandatory information
			if (strBillNo.equals("0") || strBillNo.equals("")) {
				throw new Exception("BillNo. can not be blank");
			}

			if (strReceiptNo.equals("0") || strReceiptNo.equals("")) {
				throw new Exception("ReceiptNo. can not be blank");
			}

			if (this.nRowInserted == 0) {
				nInsertedIndex = dao
						.setProcedure("{call "
								+ strProcName
								+ "(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,?)}");
			}

			// set the value
			// Input Value
			dao.setProcInValue(nInsertedIndex, "modval", "1",1);
			dao.setProcInValue(nInsertedIndex, "hblnum_bill_no", strBillNo,2);
			dao.setProcInValue(nInsertedIndex, "hblnum_reciept_no",strReceiptNo,3);
			dao.setProcInValue(nInsertedIndex, "hbldt_reciept_date",strReceiptDate,4);
			dao.setProcInValue(nInsertedIndex, "hblnum_reciept_type",strReceiptType,5);
			dao.setProcInValue(nInsertedIndex, "hblnum_req_no", strRequestNo,6);
			dao.setProcInValue(nInsertedIndex, "hbldt_req_date",strRequestDate,7);
			dao.setProcInValue(nInsertedIndex, "hrgnum_puk", strPuk,8);
			dao.setProcInValue(nInsertedIndex, "hastr_adm_no", strAdmNo,9);
			dao.setProcInValue(nInsertedIndex, "hblnum_pataccount_no",strPatAccNo,10);
			dao.setProcInValue(nInsertedIndex, "hblstr_patient_name",strPatName,11);
			dao.setProcInValue(nInsertedIndex, "hblnum_client_patient_no",strClientPatNo,12);
			dao.setProcInValue(nInsertedIndex, "sblnum_chargetype_id",strChargeTypeId,13);
			dao.setProcInValue(nInsertedIndex, "sblnum_bservice_id",strBServiceId,14);
			dao.setProcInValue(nInsertedIndex, "sblnum_service_id",strServiceId,15);
			dao.setProcInValue(nInsertedIndex, "gnum_dept_code", strDeptCode,16);
			dao.setProcInValue(nInsertedIndex, "gnum_patient_cat_code",strPatientCatCode,17);
			dao.setProcInValue(nInsertedIndex, "hblnum_client_balance",strClientBalance,18);
			dao.setProcInValue(nInsertedIndex, "hblnum_patient_tot_amt",strPatientTAmt,19);
			dao.setProcInValue(nInsertedIndex, "hblnum_client_tot_amt",strClientTotAmt,20);
			dao.setProcInValue(nInsertedIndex, "hblnum_actual_tot_amt",strActualTotAmt,21);
			dao.setProcInValue(nInsertedIndex, "hblnum_tariff_tot_amt",strTariffTotAmt,22);
			dao.setProcInValue(nInsertedIndex, "hblnum_discount_tot_amt",strDiscountTotAmt,23);
			dao.setProcInValue(nInsertedIndex, "hblnum_sertax_tot_amt",strServTaxTotAmt,24);
			dao.setProcInValue(nInsertedIndex, "hblnum_penelty_amt",strPenaltyAmt,25);
			dao.setProcInValue(nInsertedIndex, "gstr_req_no", strReqNo,26);
			dao.setProcInValue(nInsertedIndex, "hblnum_cancel_no", strCancelNo,27);
			dao.setProcInValue(nInsertedIndex, "hblnum_counter_id",strCounterId,28);
			dao.setProcInValue(nInsertedIndex, "hblnum_approval_id",strApprovalId,29);
			dao.setProcInValue(nInsertedIndex, "hblstr_approved_by",strApprovedBy,30);
			dao.setProcInValue(nInsertedIndex, "hbldt_approved_date",strApprovedDate,31);
			dao.setProcInValue(nInsertedIndex, "gstr_remarks", strRemarks,32);
			dao.setProcInValue(nInsertedIndex, "hblnum_status", strStatus,33);
			dao.setProcInValue(nInsertedIndex, "gdt_entry_date", strEntryDate,34);
			dao.setProcInValue(nInsertedIndex, "gnum_seatid", strSeatId,35);
			dao.setProcInValue(nInsertedIndex, "gnum_isvalid", strIsValid,36);
			dao.setProcInValue(nInsertedIndex, "hipnum_ward_code", strWardCode,37);
			dao.setProcInValue(nInsertedIndex, "sblnum_ipd_chargetype_id",strIpdChargeTypeId,38);
			dao.setProcInValue(nInsertedIndex, "hblnum_is_online", strIsOnline,39);
			dao.setProcInValue(nInsertedIndex, "hblnum_is_bill", strIsBill,40);
			dao.setProcInValue(nInsertedIndex,"hosp_code",strHospitalCode,41);  // New Value
			dao.setProcInValue(nInsertedIndex,"printFlag","",42);  // New Value
			// output value
			dao.setProcOutValue(nInsertedIndex, "err", 1,43);
			
			//credit values..
			dao.setProcInValue(nInsertedIndex,"creditBillFlag",strCreditBillFlag,44); //it is credit billing
			dao.setProcInValue(nInsertedIndex,"clNo",strClNo,45); 
			dao.setProcInValue(nInsertedIndex,"clDate",strClDate,46); 
			dao.setProcInValue(nInsertedIndex,"clPath",strClPath,47); 
			dao.setProcInValue(nInsertedIndex,"clientNo",strClientNo,48); 
			dao.setProcInValue(nInsertedIndex,"creditBillStatus",strCreditBillStatus,49); //credit billing approved
			dao.setProcInValue(nInsertedIndex,"staffCardNoId",strClCardNoId,50); 
			dao.setProcInValue(nInsertedIndex,"staffCardHolderName",strClCardHolderName,51); 
			dao.setProcInValue(nInsertedIndex,"relationWithStaffId",(strCreditRelationWithStaff.equals("") || strCreditRelationWithStaff == null ? "": strCreditRelationWithStaff) ,52); 
			dao.setProcInValue(nInsertedIndex,"cardValidity",strClValidity,53); 
			dao.setProcInValue(nInsertedIndex, "ip",stripadd,54);
			dao.setProcInValue(nInsertedIndex, "mac",strmacadd,55);
			
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
		strReceiptNo = "1";
		strReceiptDate = "";
		strReceiptType = "1";
		strRequestNo = "0";
		strRequestDate = "0";
		strPuk = "0";
		strAdmNo = "0";
		strPatAccNo = "0";
		strPatName = "";
		strClientPatNo = "0";
		strChargeTypeId = "1";
		strBServiceId = "1";
		strServiceId = "0";
		strDeptCode = "0";
		strPatientCatCode = "0";
		strClientBalance = "0";
		strPatientTAmt = "0";
		strClientTotAmt = "0";
		strActualTotAmt = "0";
		strTariffTotAmt = "0";
		strDiscountTotAmt = "0";
		strServTaxTotAmt = "0";
		strPenaltyAmt = "0";
		strReqNo = "0";
		strCancelNo = "0";
		strCounterId = "0";
		strApprovalId = "0";
		strApprovedBy = "0";
		strApprovedDate = "0";
		strRemarks = "0";
		strStatus = "0";
		strEntryDate = "";
		strSeatId = "0";
		strIsValid = "1";
		strWardCode = "0";
		strIpdChargeTypeId = "0";
		strIsOnline = "1";
		strIsBill = "1";
		strHospitalCode = "0";
		stripadd="";
		strmacadd="";

	}

	public String getStrCreditBillFlag() {
		return strCreditBillFlag;
	}

	public void setStrCreditBillFlag(String strCreditBillFlag) {
		this.strCreditBillFlag = strCreditBillFlag;
	}

	public String getStrClNo() {
		return strClNo;
	}

	public void setStrClNo(String strClNo) {
		this.strClNo = strClNo;
	}

	public String getStrClDate() {
		return strClDate;
	}

	public void setStrClDate(String strClDate) {
		this.strClDate = strClDate;
	}

	public String getStrClPath() {
		return strClPath;
	}

	public void setStrClPath(String strClPath) {
		this.strClPath = strClPath;
	}

	public String getStrClientNo() {
		return strClientNo;
	}

	public void setStrClientNo(String strClientNo) {
		this.strClientNo = strClientNo;
	}

	public String getStrCreditBillStatus() {
		return strCreditBillStatus;
	}

	public void setStrCreditBillStatus(String strCreditBillStatus) {
		this.strCreditBillStatus = strCreditBillStatus;
	}

	public String getStrClCardNoId() {
		return strClCardNoId;
	}

	public void setStrClCardNoId(String strClCardNoId) {
		this.strClCardNoId = strClCardNoId;
	}

	public String getStrClCardHolderName() {
		return strClCardHolderName;
	}

	public void setStrClCardHolderName(String strClCardHolderName) {
		this.strClCardHolderName = strClCardHolderName;
	}

	public String getStrCreditRelationWithStaff() {
		return strCreditRelationWithStaff;
	}

	public void setStrCreditRelationWithStaff(String strCreditRelationWithStaff) {
		this.strCreditRelationWithStaff = strCreditRelationWithStaff;
	}

	public String getStrClValidity() {
		return strClValidity;
	}

	public void setStrClValidity(String strClValidity) {
		this.strClValidity = strClValidity;
	}

}
