/**
 * 
 */
package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Anshul Jindal Version : 1.0 Date : 30/Jan/2009
 * 
 * This class will be used to insert/update/delete the records Table Name :
 * HSTT_RATECONTRACT_DTL
 */
public class RateContractDtlDAO {
	
	/** The str proc name. */
	//private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.RateContractDtlDAO";

	/** The str rate contract no. */
	private String strRateContractNo = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str rate contract sl no. */
	private String strRateContractSLNo = "1";
	
	/** The str tender no. */
	private String strTenderNo = "";
	
	/** The str quotation no. */
	private String strQuotationNo = "";
	
	/** The str supplier id. */
	private String strSupplierId = "";
	
	/** The str contract date. */
	private String strContractDate = "";
	
	/** The str contract from date. */
	private String strContractFromDate = "";
	
	/** The str contract to date. */
	private String strContractToDate = "";
	
	/** The str rate contract status. */
	private String strRateContractStatus = "1";
	
	/** The str financial start yr. */
	private String strFinancialStartYr = "";
	
	/** The str financial end yr. */
	private String strFinancialEndYr = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str rejected remarks. */
	private String strRejectedRemarks = "";
	
	/** The str terminate date. */
	private String strTerminateDate = "";
	
	/** The str entry date. */
	//private String strEntryDate = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str is valid. */
//	private String strIsValid = "1";
	
	/** The str item category no. */
	private String strItemCategoryNo = "1";

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
	 * Sets the str rate contract no.
	 * 
	 * @param strRateContractNo the strRateContractNo to set
	 */
	public void setStrRateContractNo(String strRateContractNo) {
		this.strRateContractNo = strRateContractNo;
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
	 * Sets the str rate contract sl no.
	 * 
	 * @param strRateContractSLNo the strRateContractSLNo to set
	 */
	public void setStrRateContractSLNo(String strRateContractSLNo) {
		this.strRateContractSLNo = strRateContractSLNo;
	}

	/**
	 * Sets the str tender no.
	 * 
	 * @param strTenderNo the strTenderNo to set
	 */
	public void setStrTenderNo(String strTenderNo) {
		this.strTenderNo = strTenderNo;
	}

	/**
	 * Sets the str quotation no.
	 * 
	 * @param strQuotationNo the strQuotationNo to set
	 */
	public void setStrQuotationNo(String strQuotationNo) {
		this.strQuotationNo = strQuotationNo;
	}

	/**
	 * Sets the str supplier id.
	 * 
	 * @param strSupplierId the strSupplierId to set
	 */
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}

	/**
	 * Sets the str contract date.
	 * 
	 * @param strContractDate the strContractDate to set
	 */
	public void setStrContractDate(String strContractDate) {
		this.strContractDate = strContractDate;
	}

	/**
	 * Sets the str contract from date.
	 * 
	 * @param strContractFromDate the strContractFromDate to set
	 */
	public void setStrContractFromDate(String strContractFromDate) {
		this.strContractFromDate = strContractFromDate;
	}

	/**
	 * Sets the str contract to date.
	 * 
	 * @param strContractToDate the strContractToDate to set
	 */
	public void setStrContractToDate(String strContractToDate) {
		this.strContractToDate = strContractToDate;
	}

	/**
	 * Sets the str rate contract status.
	 * 
	 * @param strRateContractStatus the strRateContractStatus to set
	 */
	public void setStrRateContractStatus(String strRateContractStatus) {
		this.strRateContractStatus = strRateContractStatus;
	}

	/**
	 * Sets the str financial start yr.
	 * 
	 * @param strFinancialStartYr the strFinancialStartYr to set
	 */
	public void setStrFinancialStartYr(String strFinancialStartYr) {
		this.strFinancialStartYr = strFinancialStartYr;
	}

	/**
	 * Sets the str financial end yr.
	 * 
	 * @param strFinancialEndYr the strFinancialEndYr to set
	 */
	public void setStrFinancialEndYr(String strFinancialEndYr) {
		this.strFinancialEndYr = strFinancialEndYr;
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
	 * Sets the str rejected remarks.
	 * 
	 * @param strRejectedRemarks the strRejectedRemarks to set
	 */
	public void setStrRejectedRemarks(String strRejectedRemarks) {
		this.strRejectedRemarks = strRejectedRemarks;
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
	 * Sets the str item category no.
	 * 
	 * @param strItemCategoryNo the strItemCategoryNo to set
	 */
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}

	/**
	 * Sets the str err.
	 * 
	 * @param strErr the strErr to set
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

	// Methods starts from here

	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strHospitalCode or strSupplierId or strRateContractNo is
	 * blank
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strSupplierId.equals("0") || strSupplierId.equals("")) {
				throw new Exception("strSupplierId can not be blank");
			}
			if (strRateContractNo.equals("0") || strRateContractNo.equals("")) {
				throw new Exception("strRateContractNo can not be blank");
			}

			strProcName = "{call dml_rate_contract_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			nProcIndex = dao.setProcedure(strProcName);
			// //System.out.println("strSupplierId-"+strSupplierId);
			dao.setProcInValue(nProcIndex, "modval", "1");
			dao.setProcInValue(nProcIndex, "rate_contract_no",
					strRateContractNo);
			dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode);
			dao.setProcInValue(nProcIndex, "item_cat_no", strItemCategoryNo);
			dao.setProcInValue(nProcIndex, "quotaion_no", strQuotationNo);
			dao.setProcInValue(nProcIndex, "tender_no", strTenderNo);
			dao.setProcInValue(nProcIndex, "supplier_id", strSupplierId);
			dao.setProcInValue(nProcIndex, "contract_date", strContractDate);
			dao.setProcInValue(nProcIndex, "contract_from_date",
					strContractFromDate);
			dao.setProcInValue(nProcIndex, "contract_to_date",
					strContractToDate);
			dao.setProcInValue(nProcIndex, "fin_start_yr", strFinancialStartYr);
			dao.setProcInValue(nProcIndex, "fin_end_yr", strFinancialEndYr);
			dao.setProcInValue(nProcIndex, "remarks", strRemarks);
			dao.setProcInValue(nProcIndex, "rejected_remarks",
					strRejectedRemarks);
			dao.setProcInValue(nProcIndex, "seat_id", strSeatId);

			dao.setProcOutValue(nProcIndex, "err", 1);

			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			// this.reset(); // to reset the variables
		}

	}

	/**
	 * This method will be used to update the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strHospitalCode or strRateContractNo or
	 * strRateContractSLNo or strTerminateDate is blank
	 */
	public void update(HisDAO dao) throws Exception {

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strRateContractNo.equals("0") || strRateContractNo.equals("")) {
				throw new Exception("strRateContractNo can not be blank");
			}
			if (strRateContractSLNo.equals("0")
					|| strRateContractSLNo.equals("")) {
				throw new Exception("strRateContractSLNo can not be blank");
			}
			if (strTerminateDate.equals("0") || strTerminateDate.equals("")) {
				throw new Exception("strTerminateDate can not be blank");
			}

			strProcName = "{call dml_rate_contract_dtls(?,?,?,?,?,?,?,?)}";
			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "modval", "2");
			dao.setProcInValue(nProcIndex, "rate_contract_no",
					strRateContractNo);
			dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode);
			dao.setProcInValue(nProcIndex, "rate_contract_slno",
					strRateContractSLNo);
			dao.setProcInValue(nProcIndex, "terminate_date", strTerminateDate);
			dao.setProcInValue(nProcIndex, "rejected_remarks",
					strRejectedRemarks);
			dao.setProcInValue(nProcIndex, "rate_contract_status",
					strRateContractStatus);

			dao.setProcOutValue(nProcIndex, "err", 1);

			dao.execute(nProcIndex, 1);
			this.nRowUpdated++;
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

		strRateContractNo = "";
		strHospitalCode = "";
		strRateContractSLNo = "1";
		strTenderNo = "";
		strQuotationNo = "";
		strSupplierId = "";
		strContractDate = "";
		strContractFromDate = "";
		strContractToDate = "";
		strRateContractStatus = "1";
		strFinancialStartYr = "";
		strFinancialEndYr = "";
		strRemarks = "";
		strRejectedRemarks = "";
	//	strEntryDate = "";
		strSeatId = "";
	//	strIsValid = "1";
		strItemCategoryNo = "1";

	}

	/**
	 * Sets the str terminate date.
	 * 
	 * @param strTerminateDate the strTerminateDate to set
	 */
	public void setStrTerminateDate(String strTerminateDate) {
		this.strTerminateDate = strTerminateDate;
	}

}
