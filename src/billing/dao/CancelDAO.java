package billing.dao;

import hisglobal.transactionmgnt.HisDAO;

/**
 * Developer : Anshul Jindal 
 * Version : 1.0 
 * Date : 21/Aug/2008
 * 
 * This class will be used to insert/update/delete the records 
 * Table Name : Hblt_Cancel_Dtl 
 * Procedure Name : PKG_BILL_DML.dml_Hblt_Cancel_Dtl
 */

public class CancelDAO {

	private String strCancelNo = "0";
	private String strCancelDate = "";
	private String strTransNo = "0";
	private String strBServiceId = "0";
	private String strTransType = "1";
	private String strChargeTypeId = "0";
	private String strRemarks = "";
	private String strEntryDate = "";
	private String strEmployeeNo = "";
	private String strSeatId = "0";
	private String strIsValid = "1";
	private String strHospitalCode = "0";
	
	// It is mandatory parameter, do not reset the following variables
	private String strErr = "";

	private final String strProcName = "PKG_BILL_DML.dml_Hblt_Cancel_Dtl";
	private final String strFileName = "billing.dao.CancelDAO";

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
	 * @param strCancelNo the strCancelNo to set
	 */
	public void setStrCancelNo(String strCancelNo) {
		this.strCancelNo = strCancelNo;
	}

	/**
	 * @param strCancelDate the strCancelDate to set
	 */
	public void setStrCancelDate(String strCancelDate) {
		this.strCancelDate = strCancelDate;
	}

	/**
	 * @param strTransNo the strTransNo to set
	 */
	public void setStrTransNo(String strTransNo) {
		this.strTransNo = strTransNo;
	}

	/**
	 * @param strBServiceId the strBServiceId to set
	 */
	public void setStrBServiceId(String strBServiceId) {
		this.strBServiceId = strBServiceId;
	}

	/**
	 * @param strTransType the strTransType to set
	 */
	public void setStrTransType(String strTransType) {
		this.strTransType = strTransType;
	}

	/**
	 * @param strChargeTypeId the strChargeTypeId to set
	 */
	public void setStrChargeTypeId(String strChargeTypeId) {
		this.strChargeTypeId = strChargeTypeId;
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
	 * @param strEmployeeNo the strEmployeeNo to set
	 */
	public void setStrEmployeeNo(String strEmployeeNo) {
		this.strEmployeeNo = strEmployeeNo;
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

	

	// Methods starts from here

	/**
	 * This method will be used to insert the records
	 * 
	 * @param dao :
	 *            HisDAO Object
	 * @throws Exception -
	 *             when Cancel No is blank
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";

		try {
			// check mandatory information
			if (strCancelNo.equals("0") || strCancelNo.equals("")) {
				throw new Exception("Cancel No. can not be blank");
			}
		
			if (this.nRowInserted == 0) {
				nInsertedIndex = dao
						.setProcedure("{call "
								+ strProcName
								+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}

			// set the value
			// Input Value
			dao.setProcInValue(nInsertedIndex, "modval", "1");
			
			dao.setProcInValue(nInsertedIndex, "hblnum_cancel_no",strCancelNo );
			dao.setProcInValue(nInsertedIndex, "hbldt_cancel_date", strCancelDate);
			dao.setProcInValue(nInsertedIndex, "hblnum_trans_no", strTransNo);
			dao.setProcInValue(nInsertedIndex, "sblnum_bservice_id", strBServiceId);
			dao.setProcInValue(nInsertedIndex, "hblnum_trans_type", strTransType);
			dao.setProcInValue(nInsertedIndex, "sblnum_chargetype_id",
					strChargeTypeId);
			dao.setProcInValue(nInsertedIndex, "hblstr_remarks",
					strRemarks);
			dao.setProcInValue(nInsertedIndex, "gdt_entry_date",
					strEntryDate);
			dao.setProcInValue(nInsertedIndex, "pstr_employee_number",
					strEmployeeNo);
			dao.setProcInValue(nInsertedIndex, "gnum_seatid", strSeatId);
			dao.setProcInValue(nInsertedIndex, "gnum_isvalid", strIsValid);
		    dao.setProcInValue(nInsertedIndex, "hosp_code",strHospitalCode);  // New Value		
			
		    dao.setProcInValue(nInsertedIndex, "recNo",""); 
		    dao.setProcInValue(nInsertedIndex, "ipAddr",""); 
		    dao.setProcInValue(nInsertedIndex, "cancelAmt",""); 
		                 
			// output value
			dao.setProcOutValue(nInsertedIndex, "err", 1);

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

		 strCancelNo = "0";
		 strCancelDate = "";
		 strTransNo = "0";
		 strBServiceId = "0";
		 strTransType = "1";
		 strChargeTypeId = "0";
		 strRemarks = "";
		 strEntryDate = "";
		 strEmployeeNo = "";
		 strSeatId = "0";
		 strIsValid = "1";
		 strHospitalCode = "0";
	}
	
	
	
}
