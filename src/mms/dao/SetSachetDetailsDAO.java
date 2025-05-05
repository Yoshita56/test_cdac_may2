package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Anshul Jindal Version : 1.1 Date : 29/05/2009
 * 
 * This class will be used to insert  the records Table Name :
 * HSTT_SET_SACHET_DTL
 */
/**
 * Developer : Pramod Kumar Mehta Version : 1.0 Date : 29/01/2009
 * 
 * This class will be used to insert the records Table Name :
 * HSTT_SET_SACHET_DTL
 */

public class SetSachetDetailsDAO {

	/** The str file name. */
	private final String strFileName = "mms.dao.SetSachetDetailsDAO";

	/** The str hospital code. */
	private String strHospitalCode = "";

	/** The str set sachet no. */
	private String strSetSachetNo = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str set id. */
	private String strSetId = "";
	
	/** The str category no. */
	private String strCategoryNo = "";
	
	/** The str store id. */
	private String strStoreId = "";

	/** The str financial start year. */
	private String strFinancialStartYear = "";
	
	/** The str financial end year. */
	private String strFinancialEndYear = "";
	
	/** The str group id. */
	private String strGroupId = "";
	
	/** The str sub group id. */
	private String strSubGroupId = "";
	
	/** The str prepared qty. */
	private String strPreparedQty = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str expiry date. */
	private String strExpiryDate = "";
	
	/** The str qty unit id. */
	private String strQtyUnitId = "";

	/** The str net rate. */
	private String strNetRate = "0";
	
	/** The str net rate unit id. */
	private String strNetRateUnitId = "";
	
	/** The str net sale price. */
	private String strNetSalePrice = "0";
	
	/** The str net sale price unit id. */
	private String strNetSalePriceUnitId = "";

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
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode the new str hospital code
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Sets the str set sachet no.
	 * 
	 * @param strSetSachetNo the new str set sachet no
	 */
	public void setStrSetSachetNo(String strSetSachetNo) {
		this.strSetSachetNo = strSetSachetNo;
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
	 * Sets the str set id.
	 * 
	 * @param strSetId the new str set id
	 */
	public void setStrSetId(String strSetId) {
		this.strSetId = strSetId;
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
	 * Sets the str group id.
	 * 
	 * @param strGroupId the new str group id
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	/**
	 * Sets the str sub group id.
	 * 
	 * @param strSubGroupId the new str sub group id
	 */
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}

	/**
	 * Sets the str prepared qty.
	 * 
	 * @param strPreparedQty the new str prepared qty
	 */
	public void setStrPreparedQty(String strPreparedQty) {
		this.strPreparedQty = strPreparedQty;
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
	 * Gets the str err.
	 * 
	 * @return the str err
	 */
	public String getStrErr() {
		return strErr;
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
	 * Insert.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
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
			if (strSetSachetNo.equals("0") || strSetSachetNo.equals("")) {
				throw new Exception("strSetSachetNo can not be blank");
			}
			if (strGroupId.equals("0") || strGroupId.equals("")) {
				throw new Exception("strGroupId can not be blank");
			}
			if (strStoreId.equals("0") || strStoreId.equals("")) {
				throw new Exception("strStoreId can not be blank");

			}
			if (strPreparedQty.equals("0") || strPreparedQty.equals("")) {
				throw new Exception("strPreparedQty can not be blank");

			}

			// int nQueryIndex = 0;

			// String strQuery = null;

			strProcName = "{call Pkg_Mms_Dml.dml_set_sachet_dtls (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			nProcIndex = dao.setProcedure(strProcName);
			dao.setProcInValue(nProcIndex, "modeval", "1");
			dao.setProcInValue(nProcIndex, "set_sachet_no", strSetSachetNo);
			dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode);
			dao.setProcInValue(nProcIndex, "set_id", strSetId);
			dao.setProcInValue(nProcIndex, "store_id", strStoreId);
			dao.setProcInValue(nProcIndex, "item_category_No", strCategoryNo);
			dao.setProcInValue(nProcIndex, "prepared_qty", strPreparedQty);
			dao.setProcInValue(nProcIndex, "qty_unitId", strQtyUnitId);
			dao.setProcInValue(nProcIndex, "expiry_date", strExpiryDate);
			dao.setProcInValue(nProcIndex, "financial_start_year",
					strFinancialStartYear);
			dao.setProcInValue(nProcIndex, "financial_end_year",
					strFinancialEndYear);
			dao.setProcInValue(nProcIndex, "remarks", strRemarks);
			dao.setProcInValue(nProcIndex, "net_rate", strNetRate);
			dao.setProcInValue(nProcIndex, "netRate_unitid", strNetRateUnitId);
			dao.setProcInValue(nProcIndex, "net_salePrice", strNetSalePrice);
			dao.setProcInValue(nProcIndex, "seatId", strSeatId);
			dao.setProcInValue(nProcIndex, "salePrice_unitid",
					strNetSalePriceUnitId);
			dao.setProcInValue(nProcIndex, "group_id", strGroupId);
			dao.setProcInValue(nProcIndex, "subgroup_id", strSubGroupId);

			dao.setProcOutValue(nProcIndex, "err", 1);

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
	 * Sets the str expiry date.
	 * 
	 * @param strExpiryDate the new str expiry date
	 */
	public void setStrExpiryDate(String strExpiryDate) {
		this.strExpiryDate = strExpiryDate;
	}

	/**
	 * Sets the str qty unit id.
	 * 
	 * @param strQtyUnitId the new str qty unit id
	 */
	public void setStrQtyUnitId(String strQtyUnitId) {
		this.strQtyUnitId = strQtyUnitId;
	}

	/**
	 * Reset.
	 */
	public void reset() {
		strHospitalCode = "";
		strSetSachetNo = "";
		strSeatId = "";
		strSetId = "";
		strStoreId = "";
		strFinancialStartYear = "";
		strFinancialEndYear = "";
		strGroupId = "";
		strSubGroupId = "";
		strPreparedQty = "";
		strRemarks = "";
		strExpiryDate = "";
		strQtyUnitId = "";
		strNetRate = "0";
		strNetRateUnitId = "";
		strNetSalePrice = "0";
		strNetSalePriceUnitId = "";

	}

	/**
	 * Sets the str category no.
	 * 
	 * @param strCategoryNo the strCategoryNo to set
	 */
	public void setStrCategoryNo(String strCategoryNo) {
		this.strCategoryNo = strCategoryNo;
	}

	/**
	 * Sets the str net rate.
	 * 
	 * @param strNetRate the strNetRate to set
	 */
	public void setStrNetRate(String strNetRate) {
		this.strNetRate = strNetRate;
	}

	/**
	 * Sets the str net rate unit id.
	 * 
	 * @param strNetRateUnitId the strNetRateUnitId to set
	 */
	public void setStrNetRateUnitId(String strNetRateUnitId) {
		this.strNetRateUnitId = strNetRateUnitId;
	}

	/**
	 * Sets the str net sale price.
	 * 
	 * @param strNetSalePrice the strNetSalePrice to set
	 */
	public void setStrNetSalePrice(String strNetSalePrice) {
		this.strNetSalePrice = strNetSalePrice;
	}

	/**
	 * Sets the str net sale price unit id.
	 * 
	 * @param strNetSalePriceUnitId the strNetSalePriceUnitId to set
	 */
	public void setStrNetSalePriceUnitId(String strNetSalePriceUnitId) {
		this.strNetSalePriceUnitId = strNetSalePriceUnitId;
	}

	/**
	 * Sets the n row inserted.
	 * 
	 * @param rowInserted the nRowInserted to set
	 */
	public void setNRowInserted(int rowInserted) {
		nRowInserted = rowInserted;
	}

	/**
	 * Sets the n row deleted.
	 * 
	 * @param rowDeleted the nRowDeleted to set
	 */
	public void setNRowDeleted(int rowDeleted) {
		nRowDeleted = rowDeleted;
	}

	/**
	 * Sets the n inserted index.
	 * 
	 * @param insertedIndex the nInsertedIndex to set
	 */
	public void setNInsertedIndex(int insertedIndex) {
		nInsertedIndex = insertedIndex;
	}

	/**
	 * Sets the n deleted index.
	 * 
	 * @param deletedIndex the nDeletedIndex to set
	 */
	public void setNDeletedIndex(int deletedIndex) {
		nDeletedIndex = deletedIndex;
	}

}
