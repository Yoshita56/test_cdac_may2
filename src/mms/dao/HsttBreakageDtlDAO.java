package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Amit Kr Version : 1.0 Date : 31/Jan/2009
 * 
 * This class will be used to insert/update/delete the records Table Name :
 * HSTT_BREAKAGE_DTL Procedure Name : DML_HSTT_BREAKAGE_DTL
 */

public class HsttBreakageDtlDAO {

	/** The str hstnum bkg no. */
	private String strHstnumBkgNo = "0";
	
	private String strType = "0";
	
	/** The str hosp code. */
	private String strHospCode = "0";
	
	/** The str hstdt bkg date. */
	private String strHstdtBkgDate = "";
	
	/** The str hst num store id. */
	private String strHstNumStoreId = "0";
	
	/** The str sst num item cat no. */
	private String strSstNumItemCatNo = "0";
	
	/** The str hst num status. */
	private String strHstNumStatus = "";
	
	/** The str hst num f start year. */
	private String strHstNumFStartYear = "";
	
	/** The str hst num f end year. */
	private String strHstNumFEndYear = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str approved by. */
	private String strApprovedBy = "";
	
	/** The str approved remarks. */
	private String strApprovedRemarks = "";
	
	/** The str approved date. */
	private String strApprovedDate = "";
	
	/** The str net cost. */
	private String strNetCost = "";
	// It is mandatory parameter, do not reset the following variables
	/** The str err. */
	private String strErr = "";

	/** The str proc name. */
	private final String strProcName = "pkg_mms_dml.DML_HSTT_BREAKAGE_DTL";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.HsttBreakageDtlDAO";

	/** The n row inserted. */
	private int nRowInserted = 0;
	
	/** The n row updated. */
	private int nRowUpdated = 0;
	
	/** The n row deleted. */
	private int nRowDeleted = 0;

	/** The n inserted index. */
	private int nInsertedIndex = 0;
	
	/** The n updated index. */
	private int nUpdatedIndex = 0;
	
	/** The n deleted index. */
	private int nDeletedIndex = 0;

	/**
	 * Gets the str err.
	 * 
	 * @return Returns the strErr.
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * Gets the n deleted index.
	 * 
	 * @return Returns the nDeletedIndex.
	 */
	public int getNDeletedIndex() {
		return nDeletedIndex;
	}

	/**
	 * Gets the n inserted index.
	 * 
	 * @return Returns the nInsertedIndex.
	 */
	public int getNInsertedIndex() {
		return nInsertedIndex;
	}

	/**
	 * Gets the n row deleted.
	 * 
	 * @return Returns the nRowDeleted.
	 */
	public int getNRowDeleted() {
		return nRowDeleted;
	}

	/**
	 * Gets the n row inserted.
	 * 
	 * @return Returns the nRowInserted.
	 */
	public int getNRowInserted() {
		return nRowInserted;
	}

	/**
	 * Gets the n row updated.
	 * 
	 * @return Returns the nRowUpdated.
	 */
	public int getNRowUpdated() {
		return nRowUpdated;
	}

	/**
	 * Gets the n updated index.
	 * 
	 * @return Returns the nUpdatedIndex.
	 */
	public int getNUpdatedIndex() {
		return nUpdatedIndex;
	}

	/**
	 * Gets the str file name.
	 * 
	 * @return Returns the strFileName.
	 */
	public String getStrFileName() {
		return strFileName;
	}

	/**
	 * Gets the str proc name.
	 * 
	 * @return Returns the strProcName.
	 */
	public String getStrProcName() {
		return strProcName;
	}

	/**
	 * Sets the str hstnum bkg no.
	 * 
	 * @param strHstnumBkgNo the new str hstnum bkg no
	 */
	public void setStrHstnumBkgNo(String strHstnumBkgNo) {
		this.strHstnumBkgNo = strHstnumBkgNo;
	}

	/**
	 * Sets the str hosp code.
	 * 
	 * @param strHospCode the new str hosp code
	 */
	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
	}

	/**
	 * Sets the str hstdt bkg date.
	 * 
	 * @param strHstdtBkgDate the new str hstdt bkg date
	 */
	public void setStrHstdtBkgDate(String strHstdtBkgDate) {
		this.strHstdtBkgDate = strHstdtBkgDate;
	}

	/**
	 * Sets the str hst num store id.
	 * 
	 * @param strHstNumStoreId the new str hst num store id
	 */
	public void setStrHstNumStoreId(String strHstNumStoreId) {
		this.strHstNumStoreId = strHstNumStoreId;
	}

	/**
	 * Sets the str sst num item cat no.
	 * 
	 * @param strSstNumItemCatNo the new str sst num item cat no
	 */
	public void setStrSstNumItemCatNo(String strSstNumItemCatNo) {
		this.strSstNumItemCatNo = strSstNumItemCatNo;
	}

	/**
	 * Sets the str hst num status.
	 * 
	 * @param strHstNumStatus the new str hst num status
	 */
	public void setStrHstNumStatus(String strHstNumStatus) {
		this.strHstNumStatus = strHstNumStatus;
	}

	/**
	 * Sets the str hst num f start year.
	 * 
	 * @param strHstNumFStartYear the new str hst num f start year
	 */
	public void setStrHstNumFStartYear(String strHstNumFStartYear) {
		this.strHstNumFStartYear = strHstNumFStartYear;
	}

	/**
	 * Sets the str hst num f end year.
	 * 
	 * @param strHstNumFEndYear the new str hst num f end year
	 */
	public void setStrHstNumFEndYear(String strHstNumFEndYear) {
		this.strHstNumFEndYear = strHstNumFEndYear;
	}

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks the new str remarks
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param strSeatId the new str seat id
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	// Methods starts from here

	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when Approval Id is blank or Approval SlNo. is blank
	 */
	public void insert(HisDAO dao) throws Exception 
	{
		strErr = "";

		try 
		{
			if (strHstnumBkgNo.equals("0") || strHstnumBkgNo.equals("")) 
			{
				throw new Exception("Bkg No can not be blank");
			}
			if (strHstNumStoreId.equals("0") || strHstNumStoreId.equals("")) 
			{
				throw new Exception("Store Type can not be blank");
			}
			if (this.nRowInserted == 0) 
			{
				nInsertedIndex = dao.setProcedure("{call " + strProcName+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"); //18
			}

			dao.setProcInValue(nInsertedIndex, "modval", "1",1); // 1
			dao.setProcInValue(nInsertedIndex, "hstnum_breakage_no",strHstnumBkgNo.trim(),2); // 2
			dao.setProcInValue(nInsertedIndex, "gnum_hospital_code",strHospCode.trim(),3); // 3
			dao.setProcInValue(nInsertedIndex, "hstdt_breakage_date",strHstdtBkgDate.trim(),4); // 4
			dao.setProcInValue(nInsertedIndex, "hstnum_store_id",strHstNumStoreId.trim(),5); // 5
			dao.setProcInValue(nInsertedIndex, "sstnum_item_cat_no",strSstNumItemCatNo.trim(),6);// 6
			dao.setProcInValue(nInsertedIndex, "hstnum_status", strHstNumStatus.trim(),7); // 7
			dao.setProcInValue(nInsertedIndex, "hstnum_financial_start_year",strHstNumFStartYear.trim(),8); // 8
			dao.setProcInValue(nInsertedIndex, "hstnum_financial_end_year",strHstNumFEndYear.trim(),9); // 9
			dao.setProcInValue(nInsertedIndex, "gstr_remarks", strRemarks.trim(),10); // 10
			dao.setProcInValue(nInsertedIndex, "gnum_seatid", strSeatId.trim(),11); // 11
			dao.setProcInValue(nInsertedIndex, "GNUM_ISVALID", "1",12);
			dao.setProcInValue(nInsertedIndex, "strApprovedBy", strApprovedBy,13); // 12
			dao.setProcInValue(nInsertedIndex, "strApprovedDate",strApprovedDate,14);
			dao.setProcInValue(nInsertedIndex, "strApprovedRemarks",strApprovedRemarks,15);
			dao.setProcInValue(nInsertedIndex, "strNetCost", strNetCost,16);
			dao.setProcInValue(nInsertedIndex, "strType", strType,17);
			
			dao.setProcOutValue(nInsertedIndex, "err", 1,18); // 13

			dao.execute(nInsertedIndex, 1);
			this.nRowInserted++;
		} 
		catch (Exception e) 
		{
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} 
		finally 
		{
			this.reset(); // to reset the variables
		}
	}

	/**
	 * This method will be used to clear all the variables.
	 */
	private void reset() {

		strHstnumBkgNo = "0";
		strHospCode = "0";
		strHstdtBkgDate = "";
		strHstNumStoreId = "0";
		strSstNumItemCatNo = "0";
		strHstNumStatus = "";
		strHstNumFStartYear = "";
		strHstNumFEndYear = "";
		strRemarks = "";
		strApprovedBy = "";
		strApprovedRemarks = "";
		strApprovedDate = "";
		strSeatId = "0";

	}

	/**
	 * Sets the str approved by.
	 * 
	 * @param strApprovedBy the new str approved by
	 */
	public void setStrApprovedBy(String strApprovedBy) {
		this.strApprovedBy = strApprovedBy;
	}

	/**
	 * Sets the str approved remarks.
	 * 
	 * @param strApprovedRemarks the new str approved remarks
	 */
	public void setStrApprovedRemarks(String strApprovedRemarks) {
		this.strApprovedRemarks = strApprovedRemarks;
	}

	/**
	 * Sets the str approved date.
	 * 
	 * @param strApprovedDate the new str approved date
	 */
	public void setStrApprovedDate(String strApprovedDate) {
		this.strApprovedDate = strApprovedDate;
	}

	/**
	 * Sets the str net cost.
	 * 
	 * @param strNetCost the new str net cost
	 */
	public void setStrNetCost(String strNetCost) {
		this.strNetCost = strNetCost;
	}

	public String getStrType() {
		return strType;
	}

	public void setStrType(String strType) {
		this.strType = strType;
	}

}
