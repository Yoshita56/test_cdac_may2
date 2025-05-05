package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class GatePassDAO.
 */

/**
 * Developer : Baisakhi Roy Version : 1.0 Date : 23/Jan/2009
 * 
 * This class will be used to insert/update/delete the records Table Name :
 * HSTT_GATEPASS_DTL
 */
public class GatePassDAO {

	/** The str file name. */
	private final String strFileName = "mms.dao.GatePassDAO";

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str store id. */
	private String strStoreId = "";
	
	/** The str issue by. */
	private String strIssueBy = "";
	
	/** The str validity. */
	private String strValidity = "";
	
	/** The str validity unit. */
	private String strValidityUnit = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str issued to. */
	private String strIssuedTo = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str financial startyear. */
	private String strFinancialStartyear = "";
	
	/** The str financial end year. */
	private String strFinancialEndYear = "";
	
	/** The str gatepass type code. */
	private String strGatepassTypeCode = "";
	
	/** The str gass no. */
	private String strGassNo = "";
	
	/** The str err. */
	private String strErr = "";

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
	 * @return the strErr
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * Gets the n row inserted.
	 * 
	 * @return the nRowInserted
	 */
	public int getNRowInserted() {
		return nRowInserted;
	}

	/**
	 * Gets the n row updated.
	 * 
	 * @return the nRowUpdated
	 */
	public int getNRowUpdated() {
		return nRowUpdated;
	}

	/**
	 * Gets the n row deleted.
	 * 
	 * @return the nRowDeleted
	 */
	public int getNRowDeleted() {
		return nRowDeleted;
	}

	/**
	 * Gets the n inserted index.
	 * 
	 * @return the nInsertedIndex
	 */
	public int getNInsertedIndex() {
		return nInsertedIndex;
	}

	/**
	 * Gets the n updated index.
	 * 
	 * @return the nUpdatedIndex
	 */
	public int getNUpdatedIndex() {
		return nUpdatedIndex;
	}

	/**
	 * Gets the n deleted index.
	 * 
	 * @return the nDeletedIndex
	 */
	public int getNDeletedIndex() {
		return nDeletedIndex;
	}

	/**
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Sets the str store id.
	 * 
	 * @param strStoreId the strStoreId to set
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	/**
	 * Sets the str issue by.
	 * 
	 * @param strIssueBy the strIssueBy to set
	 */
	public void setStrIssueBy(String strIssueBy) {
		this.strIssueBy = strIssueBy;
	}

	/**
	 * Sets the str validity.
	 * 
	 * @param strValidity the strValidity to set
	 */
	public void setStrValidity(String strValidity) {
		this.strValidity = strValidity;
	}

	/**
	 * Sets the str validity unit.
	 * 
	 * @param strValidityUnit the strValidityUnit to set
	 */
	public void setStrValidityUnit(String strValidityUnit) {
		this.strValidityUnit = strValidityUnit;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param strSeatId the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * Sets the str issued to.
	 * 
	 * @param strIssuedTo the strIssuedTo to set
	 */
	public void setStrIssuedTo(String strIssuedTo) {
		this.strIssuedTo = strIssuedTo;
	}

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * Sets the str financial startyear.
	 * 
	 * @param strFinancialStartyear the strFinancialStartyear to set
	 */
	public void setStrFinancialStartyear(String strFinancialStartyear) {
		this.strFinancialStartyear = strFinancialStartyear;
	}

	/**
	 * Sets the str financial end year.
	 * 
	 * @param strFinancialEndYear the strFinancialEndYear to set
	 */
	public void setStrFinancialEndYear(String strFinancialEndYear) {
		this.strFinancialEndYear = strFinancialEndYear;
	}

	/**
	 * Sets the str gatepass type code.
	 * 
	 * @param strGatepassTypeCode the strGatepassTypeCode to set
	 */
	public void setStrGatepassTypeCode(String strGatepassTypeCode) {
		this.strGatepassTypeCode = strGatepassTypeCode;
	}

	// Methods starts from here

	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strStoreId or strHospitalCode is blank
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";
		int nprocIndex;
		String proc_name = "";
		// String strerr="";
		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strStoreId.equals("0") || strStoreId.equals("")) {
				throw new Exception("strStoreId can not be blank");
			}

			proc_name = "{call Pkg_Mms_Dml.dml_gatepass_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //13+2=15
			nprocIndex = dao.setProcedure(proc_name);

			dao.setProcInValue(nprocIndex, "modval", "1");
			dao.setProcInValue(nprocIndex, "store_id", strStoreId);
			dao.setProcInValue(nprocIndex, "hospital_code", strHospitalCode);
			dao.setProcInValue(nprocIndex, "pass_type_code",
					strGatepassTypeCode);
			dao.setProcInValue(nprocIndex, "issue_by", strIssueBy);
			dao.setProcInValue(nprocIndex, "validity", strValidity);
			dao.setProcInValue(nprocIndex, "validity_unit", strValidityUnit);
			dao.setProcInValue(nprocIndex, "issue_to", strIssuedTo);
			dao.setProcInValue(nprocIndex, "financial_start_year",
					strFinancialStartyear);
			dao.setProcInValue(nprocIndex, "financial_end_year",
					strFinancialEndYear);
			dao.setProcInValue(nprocIndex, "remarks", strRemarks);
			dao.setProcInValue(nprocIndex, "seat_id", strSeatId);

			dao.setProcOutValue(nprocIndex, "err", 1);

			/* Start Adding Default value*/
			dao.setProcInValue(nprocIndex, "gate_pass_no", "");
			dao.setProcInValue(nprocIndex, "gate_pass_date", "");
			/* End Adding Default value*/
			
			dao.execute(nprocIndex, 1);

			this.nInsertedIndex++;

		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

	}

	/**
	 * Insert sample register.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */
	public void insertSampleRegister(HisDAO dao) throws Exception {

		strErr = "";
		int nprocIndex;
		String proc_name = "";
		// String strerr="";
		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strStoreId.equals("0") || strStoreId.equals("")) {
				throw new Exception("strStoreId can not be blank");
			}

			proc_name = "{call Pkg_Mms_Dml.dml_gatepass_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //14+1=15
			nprocIndex = dao.setProcedure(proc_name);

			dao.setProcInValue(nprocIndex, "modval", "1"); // 1
			dao.setProcInValue(nprocIndex, "gate_pass_no", strGassNo); // 2
			dao.setProcInValue(nprocIndex, "store_id", strStoreId); // 3
			dao.setProcInValue(nprocIndex, "hospital_code", strHospitalCode); // 4
			dao.setProcInValue(nprocIndex, "pass_type_code",
					strGatepassTypeCode); // 5
			dao.setProcInValue(nprocIndex, "issue_by", strIssueBy); // 6
			dao.setProcInValue(nprocIndex, "validity", strValidity); // 7
			dao.setProcInValue(nprocIndex, "validity_unit", strValidityUnit); // 8
			dao.setProcInValue(nprocIndex, "issue_to", strIssuedTo); // 9
			dao.setProcInValue(nprocIndex, "financial_start_year",
					strFinancialStartyear);// 10
			dao.setProcInValue(nprocIndex, "financial_end_year",
					strFinancialEndYear);// 11
			dao.setProcInValue(nprocIndex, "remarks", strRemarks);// 12
			dao.setProcInValue(nprocIndex, "seat_id", strSeatId);// 13

			dao.setProcOutValue(nprocIndex, "err", 1);// 14

			/* Start Adding Default value*/
			dao.setProcInValue(nprocIndex, "gate_pass_date", "");
			/* End Adding Default value*/
			
			dao.execute(nprocIndex, 1);

			this.nInsertedIndex++;

		} catch (Exception e) {

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
		strStoreId = "";
		strIssueBy = "";
		strValidity = "";
		strValidityUnit = "";
		strSeatId = "";
		strIssuedTo = "";
		strRemarks = "";
		strFinancialStartyear = "";
		strFinancialEndYear = "";
		strGatepassTypeCode = "";

	}

	/**
	 * Sets the str gass no.
	 * 
	 * @param strGassNo the new str gass no
	 */
	public void setStrGassNo(String strGassNo) {
		this.strGassNo = strGassNo;
	}

}
