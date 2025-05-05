package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class EMDReceivingDtlDAO.
 */
public class EMDReceivingDtlDAO {

	/** The str proc name. */
	private final String strProcName = "pkg_mms_dml.dml_emd_dtl";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.EMDReceivingDtlDAO";

	/** The str err. */
	private String strErr = "";

	/** The str supplier id. */
	private String strSupplierId = "";
	
	/** The str tender no. */
	private String strTenderNo = "";
	
	/** The str quotation no. */
	private String strQuotationNo = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str receipt date. */
	private String strReceiptDate = "";
	
	/** The str payment mode. */
	private String strPaymentMode = "";
	
	/** The str cheque dd no. */
	private String strChequeDDNo = "";
	
	/** The str cheque dd date. */
	private String strChequeDDDate = "";
	
	/** The str bank name. */
	private String strBankName = "";
	
	/** The str payable at. */
	private String strPayableAt = "";
	
	/** The str emd amount. */
	private String strEmdAmount = "";
	
	/** The str currency id. */
	private String strCurrencyId = "";
	
	/** The str emd validity. */
	private String strEmdValidity = "";
	
	/** The str financial start year. */
	private String strFinancialStartYear = "";
	
	/** The str financial end year. */
	private String strFinancialEndYear = "";
	
	/** The str release date. */
	private String strReleaseDate = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str release seat id. */
	private String strReleaseSeatId = null;
	
	/** The str is valid. */
	private String strIsValid = "";
	
	/** The str release remarks. */
	private String strReleaseRemarks = null;

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
	 * Gets the str supplier id.
	 * 
	 * @return the str supplier id
	 */
	public String getStrSupplierId() {
		return strSupplierId;
	}

	/**
	 * Sets the str supplier id.
	 * 
	 * @param strSupplierId the new str supplier id
	 */
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}

	/**
	 * Gets the str tender no.
	 * 
	 * @return the str tender no
	 */
	public String getStrTenderNo() {
		return strTenderNo;
	}

	/**
	 * Sets the str tender no.
	 * 
	 * @param strTenderNo the new str tender no
	 */
	public void setStrTenderNo(String strTenderNo) {
		this.strTenderNo = strTenderNo;
	}

	/**
	 * Gets the str quotation no.
	 * 
	 * @return the str quotation no
	 */
	public String getStrQuotationNo() {
		return strQuotationNo;
	}

	/**
	 * Sets the str quotation no.
	 * 
	 * @param strQuotationNo the new str quotation no
	 */
	public void setStrQuotationNo(String strQuotationNo) {
		this.strQuotationNo = strQuotationNo;
	}

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
	 * Gets the str receipt date.
	 * 
	 * @return the str receipt date
	 */
	public String getStrReceiptDate() {
		return strReceiptDate;
	}

	/**
	 * Sets the str receipt date.
	 * 
	 * @param strReceiptDate the new str receipt date
	 */
	public void setStrReceiptDate(String strReceiptDate) {
		this.strReceiptDate = strReceiptDate;
	}

	/**
	 * Gets the str payment mode.
	 * 
	 * @return the str payment mode
	 */
	public String getStrPaymentMode() {
		return strPaymentMode;
	}

	/**
	 * Sets the str payment mode.
	 * 
	 * @param strPaymentMode the new str payment mode
	 */
	public void setStrPaymentMode(String strPaymentMode) {
		this.strPaymentMode = strPaymentMode;
	}

	/**
	 * Gets the str cheque dd no.
	 * 
	 * @return the str cheque dd no
	 */
	public String getStrChequeDDNo() {
		return strChequeDDNo;
	}

	/**
	 * Sets the str cheque dd no.
	 * 
	 * @param strChequeDDNo the new str cheque dd no
	 */
	public void setStrChequeDDNo(String strChequeDDNo) {
		this.strChequeDDNo = strChequeDDNo;
	}

	/**
	 * Gets the str cheque dd date.
	 * 
	 * @return the str cheque dd date
	 */
	public String getStrChequeDDDate() {
		return strChequeDDDate;
	}

	/**
	 * Sets the str cheque dd date.
	 * 
	 * @param strChequeDDDate the new str cheque dd date
	 */
	public void setStrChequeDDDate(String strChequeDDDate) {
		this.strChequeDDDate = strChequeDDDate;
	}

	/**
	 * Gets the str bank name.
	 * 
	 * @return the str bank name
	 */
	public String getStrBankName() {
		return strBankName;
	}

	/**
	 * Sets the str bank name.
	 * 
	 * @param strBankName the new str bank name
	 */
	public void setStrBankName(String strBankName) {
		this.strBankName = strBankName;
	}

	/**
	 * Gets the str payable at.
	 * 
	 * @return the str payable at
	 */
	public String getStrPayableAt() {
		return strPayableAt;
	}

	/**
	 * Sets the str payable at.
	 * 
	 * @param strPayableAt the new str payable at
	 */
	public void setStrPayableAt(String strPayableAt) {
		this.strPayableAt = strPayableAt;
	}

	/**
	 * Gets the str emd amount.
	 * 
	 * @return the str emd amount
	 */
	public String getStrEmdAmount() {
		return strEmdAmount;
	}

	/**
	 * Sets the str emd amount.
	 * 
	 * @param strEmdAmount the new str emd amount
	 */
	public void setStrEmdAmount(String strEmdAmount) {
		this.strEmdAmount = strEmdAmount;
	}

	/**
	 * Gets the str currency id.
	 * 
	 * @return the str currency id
	 */
	public String getStrCurrencyId() {
		return strCurrencyId;
	}

	/**
	 * Sets the str currency id.
	 * 
	 * @param strCurrencyId the new str currency id
	 */
	public void setStrCurrencyId(String strCurrencyId) {
		this.strCurrencyId = strCurrencyId;
	}

	/**
	 * Gets the str emd validity.
	 * 
	 * @return the str emd validity
	 */
	public String getStrEmdValidity() {
		return strEmdValidity;
	}

	/**
	 * Sets the str emd validity.
	 * 
	 * @param strEmdValidity the new str emd validity
	 */
	public void setStrEmdValidity(String strEmdValidity) {
		this.strEmdValidity = strEmdValidity;
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
	 * Gets the str release date.
	 * 
	 * @return the str release date
	 */
	public String getStrReleaseDate() {
		return strReleaseDate;
	}

	/**
	 * Sets the str release date.
	 * 
	 * @param strReleaseDate the new str release date
	 */
	public void setStrReleaseDate(String strReleaseDate) {
		this.strReleaseDate = strReleaseDate;
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
	 * Gets the str release seat id.
	 * 
	 * @return the str release seat id
	 */
	public String getStrReleaseSeatId() {
		return strReleaseSeatId;
	}

	/**
	 * Sets the str release seat id.
	 * 
	 * @param strReleaseSeatId the new str release seat id
	 */
	public void setStrReleaseSeatId(String strReleaseSeatId) {
		this.strReleaseSeatId = strReleaseSeatId;
	}

	/**
	 * Gets the str is valid.
	 * 
	 * @return the str is valid
	 */
	public String getStrIsValid() {
		return strIsValid;
	}

	/**
	 * Sets the str is valid.
	 * 
	 * @param strIsValid the new str is valid
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	/**
	 * Gets the str release remarks.
	 * 
	 * @return the str release remarks
	 */
	public String getStrReleaseRemarks() {
		return strReleaseRemarks;
	}

	/**
	 * Sets the str release remarks.
	 * 
	 * @param strReleaseRemarks the new str release remarks
	 */
	public void setStrReleaseRemarks(String strReleaseRemarks) {
		this.strReleaseRemarks = strReleaseRemarks;
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
	 * Gets the str file name.
	 * 
	 * @return the str file name
	 */
	public String getStrFileName() {
		return strFileName;
	}

	/**
	 * Insert.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";
		int nProcIndex = 0;

		try {

			if (strSupplierId.equals("0") || strSupplierId.equals("")) {
				throw new Exception("strSupplierId can not be blank");
			}
			if (strTenderNo.equals("0") || strTenderNo.equals("")) {
				throw new Exception("strTenderNo can not be blank");
			}
			if (strQuotationNo.equals("0") || strQuotationNo.equals("")) {
				throw new Exception("strQuotationNo can not be blank");
			}
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}

			// check mandatory information

			nProcIndex = dao.setProcedure("{call " + strProcName
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			dao.setProcInValue(nProcIndex, "modval", "1");
			dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode);
			dao.setProcInValue(nProcIndex, "supplier_id", strSupplierId);
			dao.setProcInValue(nProcIndex, "tender_no", strTenderNo);
			dao.setProcInValue(nProcIndex, "quotation_no", strQuotationNo);
			dao.setProcInValue(nProcIndex, "receipt_date", strReceiptDate);
			dao.setProcInValue(nProcIndex, "payment_mode", strPaymentMode);
			dao.setProcInValue(nProcIndex, "cheque_dd_no", strChequeDDNo);
			dao.setProcInValue(nProcIndex, "cheque_dd_date", strChequeDDDate);
			dao.setProcInValue(nProcIndex, "bank_name", strBankName);
			dao.setProcInValue(nProcIndex, "payable_at", strPayableAt);
			dao.setProcInValue(nProcIndex, "emd_amt", strEmdAmount);
			dao.setProcInValue(nProcIndex, "currency_id", strCurrencyId);
			dao.setProcInValue(nProcIndex, "emd_validity", strEmdValidity);
			dao.setProcInValue(nProcIndex, "financial_start_year",
					strFinancialStartYear);
			dao.setProcInValue(nProcIndex, "financial_end_year",
					strFinancialEndYear);
			// dao.setProcInValue(nProcIndex, "release_date", strReleaseDate);
			dao.setProcInValue(nProcIndex, "remarks", strRemarks);
			dao.setProcInValue(nProcIndex, "seat_id", strSeatId);
			// dao.setProcInValue(nProcIndex, "release_seat_id",
			// strReleaseSeatId);
			dao.setProcInValue(nProcIndex, "is_valid", strIsValid);
			// dao.setProcInValue(nProcIndex, "release_remarks",
			// strReleaseRemarks);

			dao.setProcOutValue(nProcIndex, "err", 1);

			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
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

		strSupplierId = "";
		strTenderNo = "";
		strQuotationNo = "";
		strHospitalCode = "";
		strReceiptDate = "";
		strPaymentMode = "";
		strChequeDDNo = "";
		strChequeDDDate = "";
		strBankName = "";
		strPayableAt = "";
		strEmdAmount = "";
		strCurrencyId = "";
		strEmdValidity = "";
		strFinancialStartYear = "";
		strFinancialEndYear = "";
		strReleaseDate = "";
		strRemarks = "";
		strSeatId = "";
		strReleaseSeatId = "";
		strIsValid = "";
		strReleaseRemarks = "";

	}

}
