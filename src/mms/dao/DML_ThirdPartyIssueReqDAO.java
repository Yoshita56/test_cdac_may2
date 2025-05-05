package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class DML_ThirdPartyIssueReqDAO.
 */
public class DML_ThirdPartyIssueReqDAO {

	/** The str proc name. */
	private final String strProcName = "Pkg_Mms_Dml.Dml_Third_Party_Issue";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.DML_ThirdPartyIssueReqDAO";
	
	private String issueDate = "";
	private String approvalFlag = "";


	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str req date. */
	private String strReqDate = "";
	
	/** The str item cat no. */
	private String strItemCatNo = "";
	
	/** The str issue date. */
	private String strIssueDate = "";
	
	/** The str store id. */
	private String strStoreId = "";
	
	/** The str institute code. */
	private String strInstituteCode = "";
	
	/** The str institute sl no. */
	private String strInstituteSlNo = "";
	
	/** The str req status. */
	private String strReqStatus = "1";
	
	/** The str financial start year. */
	private String strFinancialStartYear = "";
	
	private String strReceiveBy="";
	/** The str financial end year. */
	private String strFinancialEndYear = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str entry date. */
	private String strEntryDate = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str gnum is valid. */
	private String strGnumIsValid = "";
	
	/** The str t req no. */
	private String strTReqNo = "";
	
	/** The str err. */
	private String strErr = "";
	
	/** The str approval_level. */
	private String strApproval_level = "0";
	
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
	 * Gets the str hospital code.
	 * 
	 * @return the str hospital code
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	/**
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode the new str hospital code
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Gets the str req date.
	 * 
	 * @return the str req date
	 */
	public String getStrReqDate() {
		return strReqDate;
	}

	/**
	 * Sets the str req date.
	 * 
	 * @param strReqDate the new str req date
	 */
	public void setStrReqDate(String strReqDate) {
		this.strReqDate = strReqDate;
	}

	/**
	 * Gets the str item cat no.
	 * 
	 * @return the str item cat no
	 */
	public String getStrItemCatNo() {
		return strItemCatNo;
	}

	/**
	 * Sets the str item cat no.
	 * 
	 * @param strItemCatNo the new str item cat no
	 */
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}

	/**
	 * Gets the str issue date.
	 * 
	 * @return the str issue date
	 */
	public String getStrIssueDate() {
		return strIssueDate;
	}

	/**
	 * Sets the str issue date.
	 * 
	 * @param strIssueDate the new str issue date
	 */
	public void setStrIssueDate(String strIssueDate) {
		this.strIssueDate = strIssueDate;
	}

	/**
	 * Gets the str store id.
	 * 
	 * @return the str store id
	 */
	public String getStrStoreId() {
		return strStoreId;
	}

	/**
	 * Sets the str store id.
	 * 
	 * @param strStoreId the new str store id
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	/**
	 * Gets the str institute code.
	 * 
	 * @return the str institute code
	 */
	public String getStrInstituteCode() {
		return strInstituteCode;
	}

	/**
	 * Sets the str institute code.
	 * 
	 * @param strInstituteCode the new str institute code
	 */
	public void setStrInstituteCode(String strInstituteCode) {
		this.strInstituteCode = strInstituteCode;
	}

	/**
	 * Gets the str req status.
	 * 
	 * @return the str req status
	 */
	public String getStrReqStatus() {
		return strReqStatus;
	}

	/**
	 * Sets the str req status.
	 * 
	 * @param strReqStatus the new str req status
	 */
	public void setStrReqStatus(String strReqStatus) {
		this.strReqStatus = strReqStatus;
	}

	/**
	 * Gets the str financial start year.
	 * 
	 * @return the str financial start year
	 */
	public String getStrFinancialStartYear() {
		return strFinancialStartYear;
	}

	/**
	 * Sets the str financial start year.
	 * 
	 * @param strFinancialStartYear the new str financial start year
	 */
	public void setStrFinancialStartYear(String strFinancialStartYear) {
		this.strFinancialStartYear = strFinancialStartYear;
	}

	/**
	 * Gets the str financial end year.
	 * 
	 * @return the str financial end year
	 */
	public String getStrFinancialEndYear() {
		return strFinancialEndYear;
	}

	/**
	 * Sets the str financial end year.
	 * 
	 * @param strFinancialEndYear the new str financial end year
	 */
	public void setStrFinancialEndYear(String strFinancialEndYear) {
		this.strFinancialEndYear = strFinancialEndYear;
	}

	/**
	 * Gets the str remarks.
	 * 
	 * @return the str remarks
	 */
	public String getStrRemarks() {
		return strRemarks;
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
	 * Gets the str entry date.
	 * 
	 * @return the str entry date
	 */
	public String getStrEntryDate() {
		return strEntryDate;
	}

	/**
	 * Sets the str entry date.
	 * 
	 * @param strEntryDate the new str entry date
	 */
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}

	/**
	 * Gets the str seat id.
	 * 
	 * @return the str seat id
	 */
	public String getStrSeatId() {
		return strSeatId;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param strSeatId the new str seat id
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * Gets the str t req no.
	 * 
	 * @return the str t req no
	 */
	public String getStrTReqNo() {
		return strTReqNo;
	}

	/**
	 * Sets the str t req no.
	 * 
	 * @param strTReqNo the new str t req no
	 */
	public void setStrTReqNo(String strTReqNo) {
		this.strTReqNo = strTReqNo;
	}

	/**
	 * Gets the str proc name.
	 * 
	 * @return the str proc name
	 */
	public String getStrProcName() {
		return strProcName;
	}

	/**
	 * Gets the str file name.
	 * 
	 * @return the str file name
	 */
	public String getStrFileName() {
		return strFileName;
	}

	/**
	 * Gets the str err.
	 * 
	 * @return the str err
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * Sets the str err.
	 * 
	 * @param strErr the new str err
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

	/**
	 * Gets the n row inserted.
	 * 
	 * @return the n row inserted
	 */
	public int getNRowInserted() {
		return nRowInserted;
	}

	/**
	 * Sets the n row inserted.
	 * 
	 * @param rowInserted the new n row inserted
	 */
	public void setNRowInserted(int rowInserted) {
		nRowInserted = rowInserted;
	}

	/**
	 * Gets the n row updated.
	 * 
	 * @return the n row updated
	 */
	public int getNRowUpdated() {
		return nRowUpdated;
	}

	/**
	 * Sets the n row updated.
	 * 
	 * @param rowUpdated the new n row updated
	 */
	public void setNRowUpdated(int rowUpdated) {
		nRowUpdated = rowUpdated;
	}

	/**
	 * Gets the n row deleted.
	 * 
	 * @return the n row deleted
	 */
	public int getNRowDeleted() {
		return nRowDeleted;
	}

	/**
	 * Sets the n row deleted.
	 * 
	 * @param rowDeleted the new n row deleted
	 */
	public void setNRowDeleted(int rowDeleted) {
		nRowDeleted = rowDeleted;
	}

	/**
	 * Gets the n inserted index.
	 * 
	 * @return the n inserted index
	 */
	public int getNInsertedIndex() {
		return nInsertedIndex;
	}

	/**
	 * Sets the n inserted index.
	 * 
	 * @param insertedIndex the new n inserted index
	 */
	public void setNInsertedIndex(int insertedIndex) {
		nInsertedIndex = insertedIndex;
	}

	/**
	 * Gets the n updated index.
	 * 
	 * @return the n updated index
	 */
	public int getNUpdatedIndex() {
		return nUpdatedIndex;
	}

	/**
	 * Sets the n updated index.
	 * 
	 * @param updatedIndex the new n updated index
	 */
	public void setNUpdatedIndex(int updatedIndex) {
		nUpdatedIndex = updatedIndex;
	}

	/**
	 * Gets the n deleted index.
	 * 
	 * @return the n deleted index
	 */
	public int getNDeletedIndex() {
		return nDeletedIndex;
	}

	/**
	 * Sets the n deleted index.
	 * 
	 * @param deletedIndex the new n deleted index
	 */
	public void setNDeletedIndex(int deletedIndex) {
		nDeletedIndex = deletedIndex;
	}

	/**
	 * Insert.
	 * 
	 * @param dao the dao
	 * 
	 * @return the int
	 * 
	 * @throws Exception the exception
	 */
	public int insert(HisDAO dao) throws Exception {

		strErr = "";
		int nProcIndex = 0;

		try {

			if (strTReqNo.equals("0") || strTReqNo.equals("")) {
				throw new Exception("strTReqNo can not be blank");
			}
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}

			// check mandatory information

			nProcIndex = dao.setProcedure("{call " + strProcName
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			dao.setProcInValue(nProcIndex, "modval", "1",1);
			dao.setProcInValue(nProcIndex, "req_no", strTReqNo,2);
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,3);
			dao.setProcInValue(nProcIndex, "req_date", this.strReqDate,4);
			dao.setProcInValue(nProcIndex, "itemcat_no", strItemCatNo,5);
			dao.setProcInValue(nProcIndex, "issue_date", "",6);
			dao.setProcInValue(nProcIndex, "store_id", strStoreId,7);
			dao.setProcInValue(nProcIndex, "institute_code", strInstituteCode,8);
			dao.setProcInValue(nProcIndex, "institute_slno",this.strInstituteSlNo,9);
			dao.setProcInValue(nProcIndex, "req_status", this.strReqStatus,10);
			dao.setProcInValue(nProcIndex, "financial_start_date",strFinancialStartYear,11);
			dao.setProcInValue(nProcIndex, "financial_end_date",strFinancialEndYear,12);
			dao.setProcInValue(nProcIndex, "remarks", strRemarks,14);
			dao.setProcInValue(nProcIndex, "entry_date", this.strEntryDate,15);
			dao.setProcInValue(nProcIndex, "seat_id", strSeatId,16);
			dao.setProcInValue(nProcIndex, "isvalid", this.strGnumIsValid,17);			
			dao.setProcInValue(nProcIndex, "recieve_by", this.strReceiveBy,13);// Default Value. 
			dao.setProcInValue(nProcIndex, "issueDate", this.issueDate,18);// Default Value.
			dao.setProcInValue(nProcIndex, "approvalFlag",this.approvalFlag,19);// Default Value.
		
			dao.setProcOutValue(nProcIndex, "retSerialNo", 1,20);
			dao.setProcOutValue(nProcIndex, "err", 1,21);
			dao.setProcOutValue(nProcIndex, "dml_count", 1,22);
			dao.setProcOutValue(nProcIndex, "approval_level", 1,23);
			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
			return nProcIndex;
			// this.setStrApproval_level(dao.getString(nProcIndex,
			// "approval_level"));
		} catch (Exception e) {
			// e.printStackTrace();
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

	}

	/**
	 * Reset.
	 */
	public void reset() {
		strHospitalCode = "";
		strReqDate = "";
		strItemCatNo = "";
		strInstituteCode = "";
		strReqStatus = "1";
		strFinancialStartYear = "";
		strFinancialEndYear = "";
		strRemarks = "";
		strSeatId = "";
		strStoreId = "";
		strIssueDate = "";
		strEntryDate = "";
		strSeatId = "";
		strTReqNo = "";
	}

	/**
	 * Gets the str gnum is valid.
	 * 
	 * @return the str gnum is valid
	 */
	public String getStrGnumIsValid() {
		return strGnumIsValid;
	}

	/**
	 * Sets the str gnum is valid.
	 * 
	 * @param strGnumIsValid the new str gnum is valid
	 */
	public void setStrGnumIsValid(String strGnumIsValid) {
		this.strGnumIsValid = strGnumIsValid;
	}

	/**
	 * Gets the str institute sl no.
	 * 
	 * @return the str institute sl no
	 */
	public String getStrInstituteSlNo() {
		return strInstituteSlNo;
	}

	/**
	 * Sets the str institute sl no.
	 * 
	 * @param strInstituteSlNo the new str institute sl no
	 */
	public void setStrInstituteSlNo(String strInstituteSlNo) {
		this.strInstituteSlNo = strInstituteSlNo;
	}

	/**
	 * Gets the str approval_level.
	 * 
	 * @return the str approval_level
	 */
	public String getStrApproval_level() {
		return strApproval_level;
	}

	/**
	 * Sets the str approval_level.
	 * 
	 * @param strApproval_level the new str approval_level
	 */
	public void setStrApproval_level(String strApproval_level) {
		this.strApproval_level = strApproval_level;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getApprovalFlag() {
		return approvalFlag;
	}

	public void setApprovalFlag(String approvalFlag) {
		this.approvalFlag = approvalFlag;
	}

	public String getStrReceiveBy() {
		return strReceiveBy;
	}

	public void setStrReceiveBy(String strReceiveBy) {
		this.strReceiveBy = strReceiveBy;
	}
}
