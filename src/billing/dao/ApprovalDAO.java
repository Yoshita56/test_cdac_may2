package billing.dao;

import hisglobal.transactionmgnt.HisDAO;

/**
 * Developer : Kapil Khurana
 * Version : 1.0
 * Date : 21/Aug/2008
 * 
 * This class will be used to insert/update/delete the records
 * Table Name : HBLT_APPROVAL_DTL
 * Procedure Name : PKG_BILL_DML.DML_HBLT_APPROVAL_DTL
*/
public final class ApprovalDAO {
	
	private String strApprovalId = "0";
	private String strApprovalDt = "";
	private String strApprovalSlNo = "1";
	private String strReceiptType = "1";
	private String strBServiceId = "0";
	private String strChargeTypeId = "0";
	private String strEmpNo = "";
	private String strUserLevel = "1";
	private String strDiscountUnit = "0";
	private String strRemarks = "";
	private String strDiscountType = "0";
	private String strPrevDiscountUnit = "0";
	private String strApprovalType = "1";
	private String strStatus = "1";
	private String strPrevDiscountType = "0";
	private String strSeatId = "0";
	private String strEntryDate = "";
	private String strIsValid = "1";
	private String strHospitalCode = "0";
	
		
	//It is mandatory parameter, do not reset the following variables
	private String strErr = "";
	
	private final String strProcName = "pkg_bill_dml.dml_hblt_approval_dtl";
	private final String strFileName = "billing.dao.ApprovalDAO";
	
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
	 * @param strApprovalId the strApprovalId to set
	 */
	public void setStrApprovalId(String strApprovalId) {
		this.strApprovalId = strApprovalId;
	}

	/**
	 * @param strApprovalDt the strApprovalDt to set
	 */
	public void setStrApprovalDt(String strApprovalDt) {
		this.strApprovalDt = strApprovalDt;
	}

	/**
	 * @param strApprovalSlNo the strApprovalSlNo to set
	 */
	public void setStrApprovalSlNo(String strApprovalSlNo) {
		this.strApprovalSlNo = strApprovalSlNo;
	}

	/**
	 * @param strReceiptType the strReceiptType to set
	 */
	public void setStrReceiptType(String strReceiptType) {
		this.strReceiptType = strReceiptType;
	}

	/**
	 * @param strBServiceId the strBServiceId to set
	 */
	public void setStrBServiceId(String strBServiceId) {
		this.strBServiceId = strBServiceId;
	}

	/**
	 * @param strChargeTypeId the strChargeTypeId to set
	 */
	public void setStrChargeTypeId(String strChargeTypeId) {
		this.strChargeTypeId = strChargeTypeId;
	}

	/**
	 * @param strEmpNo the strEmpNo to set
	 */
	public void setStrEmpNo(String strEmpNo) {
		this.strEmpNo = strEmpNo;
	}

	/**
	 * @param strUserLevel the strUserLevel to set
	 */
	public void setStrUserLevel(String strUserLevel) {
		this.strUserLevel = strUserLevel;
	}

	/**
	 * @param strDiscountUnit the strDiscountUnit to set
	 */
	public void setStrDiscountUnit(String strDiscountUnit) {
		this.strDiscountUnit = strDiscountUnit;
	}

	/**
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * @param strDiscountType the strDiscountType to set
	 */
	public void setStrDiscountType(String strDiscountType) {
		this.strDiscountType = strDiscountType;
	}

	/**
	 * @param strPrevDiscountUnit the strPrevDiscountUnit to set
	 */
	public void setStrPrevDiscountUnit(String strPrevDiscountUnit) {
		this.strPrevDiscountUnit = strPrevDiscountUnit;
	}

	/**
	 * @param strApprovalType the strApprovalType to set
	 */
	public void setStrApprovalType(String strApprovalType) {
		this.strApprovalType = strApprovalType;
	}

	/**
	 * @param strStatus the strStatus to set
	 */
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}

	/**
	 * @param strPrevDiscountType the strPrevDiscountType to set
	 */
	public void setStrPrevDiscountType(String strPrevDiscountType) {
		this.strPrevDiscountType = strPrevDiscountType;
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
	 * @throws Exception - when Approval Id is blank or
	 * Approval SlNo. is blank
	 */
	public void insert(HisDAO dao) throws Exception 
	{
		strErr = "";
		
		try 
		{
			if(strApprovalId.equals("0") || strApprovalId.equals("")) 
			{
				throw new Exception("Approval Id can not be blank");
			}
			if(strApprovalSlNo.equals("0") || strApprovalSlNo.equals("")) 
			{
				throw new Exception("Approval SlNo. can not be blank");
			}
			if(this.nRowInserted == 0) 
			{
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			
			dao.setProcInValue(nInsertedIndex,"modval","1",1);
			dao.setProcInValue(nInsertedIndex,"hblnum_approval_id",strApprovalId,2);
			dao.setProcInValue(nInsertedIndex,"hbldt_approval_date","",3);
			dao.setProcInValue(nInsertedIndex,"hblnum_approval_slno",strApprovalSlNo,4);
			dao.setProcInValue(nInsertedIndex,"hblnum_reciept_type",strReceiptType,5);
			dao.setProcInValue(nInsertedIndex,"sblnum_bservice_id",strBServiceId,6);
			dao.setProcInValue(nInsertedIndex,"sblnum_chargetype_id",strChargeTypeId,7);
			dao.setProcInValue(nInsertedIndex,"pstr_employee_number",strEmpNo,8);
			dao.setProcInValue(nInsertedIndex,"hblnum_user_level",strUserLevel,9);
			dao.setProcInValue(nInsertedIndex,"hblnum_discount_unit",strDiscountUnit,10);
			dao.setProcInValue(nInsertedIndex,"hblstr_remarks",strRemarks,11);
			dao.setProcInValue(nInsertedIndex,"hblnum_discount_type",strDiscountType,12);
			dao.setProcInValue(nInsertedIndex,"hblnum_prev_discount_unit",strPrevDiscountUnit,13);
			dao.setProcInValue(nInsertedIndex,"hblnum_approval_type",strApprovalType,14);
			dao.setProcInValue(nInsertedIndex,"hblnum_status",strStatus,15);
			dao.setProcInValue(nInsertedIndex,"hblnum_prev_discount_type",strPrevDiscountType,16);
			dao.setProcInValue(nInsertedIndex,"gnum_seatid",strSeatId,17);
			dao.setProcInValue(nInsertedIndex,"gdt_entry_date","",18);
			dao.setProcInValue(nInsertedIndex,"gnum_isvalid",strIsValid,19);
			dao.setProcInValue(nInsertedIndex,"hosp_code",strHospitalCode,20); 
			dao.setProcOutValue(nInsertedIndex,"err",1,21);
			
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
	 * This method will be used to clear all the variables
	 */
	private void reset() 
	{
		 strApprovalId = "0";
		 strApprovalDt = "";
		 strApprovalSlNo = "1";
		 strReceiptType = "1";
		 strBServiceId = "0";
		 strChargeTypeId = "0";
		 strEmpNo = "";
		 strUserLevel = "1";
		 strDiscountUnit = "0";
		 strRemarks = "";
		 strDiscountType = "0";
		 strPrevDiscountUnit = "0";
		 strApprovalType = "1";
		 strStatus = "1";
		 strPrevDiscountType = "0";
		 strSeatId = "0";
		 strEntryDate = "";
		 strIsValid = "1";
		 strHospitalCode = "0";
	}
	
	public void insertForCreditBillApproval(HisDAO dao) throws Exception 
	{
		strErr = "";
		
		try 
		{
			if(strApprovalId.equals("0") || strApprovalId.equals("")) 
			{
				throw new Exception("Approval Id can not be blank");
			}
			if(strApprovalSlNo.equals("0") || strApprovalSlNo.equals("")) 
			{
				throw new Exception("Approval SlNo. can not be blank");
			}
			if(this.nRowInserted == 0) 
			{
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			
			dao.setProcInValue(nInsertedIndex,"modval","2",1);
			dao.setProcInValue(nInsertedIndex,"hblnum_approval_id",strApprovalId,2);
			dao.setProcInValue(nInsertedIndex,"hbldt_approval_date","",3);
			dao.setProcInValue(nInsertedIndex,"hblnum_approval_slno",strApprovalSlNo,4);
			dao.setProcInValue(nInsertedIndex,"hblnum_reciept_type",strReceiptType,5);
			dao.setProcInValue(nInsertedIndex,"sblnum_bservice_id",strBServiceId,6);
			dao.setProcInValue(nInsertedIndex,"sblnum_chargetype_id",strChargeTypeId,7);
			dao.setProcInValue(nInsertedIndex,"pstr_employee_number",strEmpNo,8);
			dao.setProcInValue(nInsertedIndex,"hblnum_user_level",strUserLevel,9);
			dao.setProcInValue(nInsertedIndex,"hblnum_discount_unit",strDiscountUnit,10);
			dao.setProcInValue(nInsertedIndex,"hblstr_remarks",strRemarks,11);
			dao.setProcInValue(nInsertedIndex,"hblnum_discount_type",strDiscountType,12);
			dao.setProcInValue(nInsertedIndex,"hblnum_prev_discount_unit",strPrevDiscountUnit,13);
			dao.setProcInValue(nInsertedIndex,"hblnum_approval_type",strApprovalType,14);
			dao.setProcInValue(nInsertedIndex,"hblnum_status",strStatus,15);
			dao.setProcInValue(nInsertedIndex,"hblnum_prev_discount_type",strPrevDiscountType,16);
			dao.setProcInValue(nInsertedIndex,"gnum_seatid",strSeatId,17);
			dao.setProcInValue(nInsertedIndex,"gdt_entry_date","",18);
			dao.setProcInValue(nInsertedIndex,"gnum_isvalid",strIsValid,19);
			dao.setProcInValue(nInsertedIndex,"hosp_code",strHospitalCode,20); 
			dao.setProcOutValue(nInsertedIndex,"err",1,21);
			
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
}