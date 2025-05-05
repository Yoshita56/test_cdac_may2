package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class SampleReturnDtlDAO.
 */
public class SampleReturnDtlDAO {
	
	/** The str proc name. */
	private final String strProcName = "pkg_mms_dml.Dml_Set_Sample_Return_Dtls";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.SampleReturnDtlDAO";

	/** The str sample rec no. */
	private String strSampleRecNo = "";
	
	/** The str sample retno. */
	private String strSampleRetno = "";
	
	/** The str item cat no. */
	private String strItemCatNo = "";
	
	/** The str sample_retdate. */
	private String strSample_retdate = "";
	
	/** The str store id. */
	private String strStoreId = "";
	
	/** The str supplier_no. */
	private String strSupplier_no = "";
	
	/** The str gate passno. */
	private String strGatePassno = "";
	
	/** The str financial start year. */
	private String strFinancialStartYear = "";
	
	/** The str financial end year. */
	private String strFinancialEndYear = "";

	/** The str remarks. */
	private String strRemarks = "";

	/** The str seat id. */
	private String strSeatId = "";

	/** The str hospital code. */
	private String strHospitalCode = "";

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
	 * Sets the str seat id.
	 * 
	 * @param strSeatId the new str seat id
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
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
	 * Gets the n row inserted.
	 * 
	 * @return the n row inserted
	 */
	public int getNRowInserted() {
		return nRowInserted;
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
	 * Gets the n row deleted.
	 * 
	 * @return the n row deleted
	 */
	public int getNRowDeleted() {
		return nRowDeleted;
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
	 * Gets the n updated index.
	 * 
	 * @return the n updated index
	 */
	public int getNUpdatedIndex() {
		return nUpdatedIndex;
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
	 * This method is used insert data into Sample Return Dtl table.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */

	public void insert(HisDAO dao) throws Exception {
		strErr = "";
		int nProcIndex = 0;

		try {
			/*
			 * if(strSampleRecNo.equals("")||strSampleRecNo==null) { throw new
			 * Exception("Sample Recieve Number can not be blank"); }
			 * if(strSampleRetno.equals("")||strSampleRetno==null) { throw new
			 * Exception("Sample Return Number can not be blank"); }
			 * if(strStoreId.equals("")||strStoreId==null) { throw new
			 * Exception("Store Id can not be blank"); }
			 */

			// check mandatory information

			/*
			 * //System.out.println("strSampleRecNo"+strSampleRecNo);
			 * //System.out.println("strSampleRetno"+strSampleRetno);
			 * //System.out.println("strHospitalCode"+strHospitalCode);
			 * //System.out.println("strItemCatNo"+strItemCatNo);
			 * //System.out.println("strStoreId"+strStoreId);
			 * //System.out.println("supplier_no"+strSupplier_no);
			 * //System.out.println("strGatePassno"+strGatePassno);
			 * //System.out.println("strFinancialStartYear"+strFinancialStartYear);
			 * //System.out.println("strFinancialEndYear"+strFinancialEndYear);
			 * //System.out.println("strRemarks"+strRemarks);
			 * //System.out.println("strSeatId"+strSeatId);
			 */
			nProcIndex = dao.setProcedure("{call " + strProcName
					+ "(?,?,?,?,?,?,?,?,?,?,?,?)}");

			dao.setProcInValue(nProcIndex, "sample_recno", strSampleRecNo
					.trim()); // 1
			dao.setProcInValue(nProcIndex, "sample_retno", strSampleRetno
					.trim()); // 2
			dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode
					.trim()); // 3
			dao.setProcInValue(nProcIndex, "item_cat_no", strItemCatNo.trim()); // 4
			dao.setProcInValue(nProcIndex, "store_id", strStoreId.trim()); // 5
			dao
					.setProcInValue(nProcIndex, "supplier_no", strSupplier_no
							.trim()); // 6
			dao.setProcInValue(nProcIndex, "gate_passno", strGatePassno.trim()); // 7
			dao.setProcInValue(nProcIndex, "financial_start_year",
					strFinancialStartYear.trim()); // 8
			dao.setProcInValue(nProcIndex, "financial_end_year",
					strFinancialEndYear.trim()); // 9
			dao.setProcInValue(nProcIndex, "remarks", strRemarks.trim()); // 10
			dao.setProcInValue(nProcIndex, "seatid", strSeatId); // 11
			dao.setProcOutValue(nProcIndex, "err", 1); // 12
			dao.execute(nProcIndex, 1);

			this.nRowInserted++;
		} catch (Exception e) {
			e.printStackTrace();
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

	}

	/**
	 * This function is us ed to reset the all values.
	 */

	public void reset() {

		strSampleRecNo = "";
		strSampleRetno = "";
		strItemCatNo = "";
		strSample_retdate = "";
		strStoreId = "";
		strSupplier_no = "";
		strGatePassno = "";
		strFinancialStartYear = "";
		strFinancialEndYear = "";
		strRemarks = "";
		strSeatId = "";
		strHospitalCode = "";

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
	 * Sets the str store id.
	 * 
	 * @param strStoreId the new str store id
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
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
	 * Sets the str financial end year.
	 * 
	 * @param strFinancialEndYear the new str financial end year
	 */
	public void setStrFinancialEndYear(String strFinancialEndYear) {
		this.strFinancialEndYear = strFinancialEndYear;
	}

	/**
	 * Gets the str sample_retdate.
	 * 
	 * @return the str sample_retdate
	 */
	public String getStrSample_retdate() {
		return strSample_retdate;
	}

	/**
	 * Sets the str sample_retdate.
	 * 
	 * @param strSample_retdate the new str sample_retdate
	 */
	public void setStrSample_retdate(String strSample_retdate) {
		this.strSample_retdate = strSample_retdate;
	}

	/**
	 * Sets the str sample rec no.
	 * 
	 * @param strSampleRecNo the new str sample rec no
	 */
	public void setStrSampleRecNo(String strSampleRecNo) {
		this.strSampleRecNo = strSampleRecNo;
	}

	/**
	 * Sets the str sample retno.
	 * 
	 * @param strSampleRetno the new str sample retno
	 */
	public void setStrSampleRetno(String strSampleRetno) {
		this.strSampleRetno = strSampleRetno;
	}

	/**
	 * Sets the str supplier_no.
	 * 
	 * @param strSupplier_no the new str supplier_no
	 */
	public void setStrSupplier_no(String strSupplier_no) {
		this.strSupplier_no = strSupplier_no;
	}

	/**
	 * Sets the str gate passno.
	 * 
	 * @param strGatePassno the new str gate passno
	 */
	public void setStrGatePassno(String strGatePassno) {
		this.strGatePassno = strGatePassno;
	}

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks the new str remarks
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

}
