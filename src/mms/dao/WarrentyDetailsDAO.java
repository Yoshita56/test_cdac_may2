package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class WarrentyDetailsDAO.
 */

/**
 * Developer : Baisakhi Roy Version : 1.0 Date : 30/Jan/2009
 * 
 * This class will be used to insert/update/delete the records Table Name :
 * HSTT_WARRENTY_DTL
 */

public class WarrentyDetailsDAO {
	
	/** The str file name. */
	private final String strFileName = "mms.dao.WarrentyDetailsDAO";

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str financial startyear. */
	private String strFinancialStartyear = "";
	
	/** The str financial end year. */
	private String strFinancialEndYear = "";

	/** The str tender no. */
	private String strTenderNo = "";
	
	/** The str quotation no. */
	private String strQuotationNo = "";
	
	/** The str po no. */
	private String strPoNo = "";
	
	/** The str manufacturer id. */
	private String strManufacturerID = "";
	
	/** The str item category id. */
	private String strItemCategoryID = "";
	
	/** The str group id. */
	private String strGroupID = "";
	
	/** The str sub group id. */
	private String strSubGroupID = "";
	
	/** The str item id. */
	private String strItemID = "";
	
	/** The str brand id. */
	private String strBrandID = "";
	
	/** The str warrenty start date. */
	private String strWarrentyStartDate = "";
	
	/** The str warrenty upto. */
	private String strWarrentyUpto = "";
	
	/** The str warrenty unit. */
	private String strWarrentyUnit = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str batch sl no. */
	private String strBatchSlNo = "";

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
	 * Sets the str seat id.
	 * 
	 * @param strSeatId the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
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
	 * Sets the str po no.
	 * 
	 * @param strPoNo the strPoNo to set
	 */
	public void setStrPoNo(String strPoNo) {
		this.strPoNo = strPoNo;
	}

	/**
	 * Sets the str manufacturer id.
	 * 
	 * @param strManufacturerID the strManufacturerID to set
	 */
	public void setStrManufacturerID(String strManufacturerID) {
		this.strManufacturerID = strManufacturerID;
	}

	/**
	 * Sets the str item category id.
	 * 
	 * @param strItemCategoryID the strItemCategoryID to set
	 */
	public void setStrItemCategoryID(String strItemCategoryID) {
		this.strItemCategoryID = strItemCategoryID;
	}

	/**
	 * Sets the str group id.
	 * 
	 * @param strGroupID the strGroupID to set
	 */
	public void setStrGroupID(String strGroupID) {
		this.strGroupID = strGroupID;
	}

	/**
	 * Sets the str sub group id.
	 * 
	 * @param strSubGroupID the strSubGroupID to set
	 */
	public void setStrSubGroupID(String strSubGroupID) {
		this.strSubGroupID = strSubGroupID;
	}

	/**
	 * Sets the str item id.
	 * 
	 * @param strItemID the strItemID to set
	 */
	public void setStrItemID(String strItemID) {
		this.strItemID = strItemID;
	}

	/**
	 * Sets the str brand id.
	 * 
	 * @param strBrandID the strBrandID to set
	 */
	public void setStrBrandID(String strBrandID) {
		this.strBrandID = strBrandID;
	}

	/**
	 * Sets the str warrenty start date.
	 * 
	 * @param strWarrentyStartDate the strWarrentyStartDate to set
	 */
	public void setStrWarrentyStartDate(String strWarrentyStartDate) {
		this.strWarrentyStartDate = strWarrentyStartDate;
	}

	/**
	 * Sets the str warrenty upto.
	 * 
	 * @param strWarrentyUpto the strWarrentyUpto to set
	 */
	public void setStrWarrentyUpto(String strWarrentyUpto) {
		this.strWarrentyUpto = strWarrentyUpto;
	}

	/**
	 * Sets the str warrenty unit.
	 * 
	 * @param strWarrentyUnit the strWarrentyUnit to set
	 */
	public void setStrWarrentyUnit(String strWarrentyUnit) {
		this.strWarrentyUnit = strWarrentyUnit;
	}

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	// Methods starts from here

	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strItemID or strHospitalCode or strBrandID or
	 * strBatchSlNo is blank
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";
		int nprocIndex;
		String proc_name = "";

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strItemID.equals("0") || strItemID.equals("")) {
				throw new Exception("strItemID can not be blank");
			}
			if (strBrandID.equals("0") || strBrandID.equals("")) {
				throw new Exception("strBrandID can not be blank");
			}
			if (strBatchSlNo.equals("0") || strBatchSlNo.equals("")) {
				throw new Exception("strBalchSlNo can not be blank");
			}

			proc_name = "{call pkg_mms_dml.dml_warrenty_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(proc_name);

			dao.setProcInValue(nprocIndex, "modval", "1");
			dao.setProcInValue(nprocIndex, "item_id", strItemID);
			dao.setProcInValue(nprocIndex, "item_brand_id", strBrandID);
			dao.setProcInValue(nprocIndex, "hospital_code", strHospitalCode);
			dao.setProcInValue(nprocIndex, "item_cat_no", strItemCategoryID);
			dao.setProcInValue(nprocIndex, "warrenty_date",
					strWarrentyStartDate);
			dao.setProcInValue(nprocIndex, "supplier_id", strManufacturerID);
			dao.setProcInValue(nprocIndex, "group_id", strGroupID);
			dao.setProcInValue(nprocIndex, "subgroup_id", strSubGroupID);
			dao.setProcInValue(nprocIndex, "quotaion_no", strQuotationNo);
			dao.setProcInValue(nprocIndex, "tender_no", strTenderNo);
			dao.setProcInValue(nprocIndex, "po_no", strPoNo);
			dao.setProcInValue(nprocIndex, "warrenty_upto", strWarrentyUpto);
			dao.setProcInValue(nprocIndex, "warrenty_unitid", strWarrentyUnit);
			dao.setProcInValue(nprocIndex, "fin_start_yr",
					strFinancialStartyear);
			dao.setProcInValue(nprocIndex, "fin_end_yr", strFinancialEndYear);
			dao.setProcInValue(nprocIndex, "remarks", strRemarks);
			dao.setProcInValue(nprocIndex, "seat_id", strSeatId);
			dao.setProcInValue(nprocIndex, "batch_sl_no", strBatchSlNo);

			dao.setProcOutValue(nprocIndex, "err", 1);

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
		strItemID = "";
		strBrandID = "";
		strItemCategoryID = "";
		strWarrentyStartDate = "";
		strSeatId = "";
		strManufacturerID = "";
		strRemarks = "";
		strFinancialStartyear = "";
		strFinancialEndYear = "";
		strGroupID = "";
		strSubGroupID = "";
		strQuotationNo = "";
		strTenderNo = "";
		strPoNo = "";
		strWarrentyUpto = "";
		strWarrentyUnit = "";
		strBatchSlNo = "";

	}

	/**
	 * Sets the str batch sl no.
	 * 
	 * @param strBatchSlNo the strBatchSlNo to set
	 */
	public void setStrBatchSlNo(String strBatchSlNo) {
		this.strBatchSlNo = strBatchSlNo;
	}

}
