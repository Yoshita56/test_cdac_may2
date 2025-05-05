package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class DML_ThirdPartyIssueItemSancDAO.
 */
public class DML_ThirdPartyIssueItemSancDAO {

	/** The str proc name. */
	private final String strProcName = "Pkg_Mms_Dml.dml_third_party_issue_item";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.DML_ThirdPartyIssueItemSancDAO";
	
	/** The str item id. */
	private String strItemId = "";
	
	/** The str item brand id. */
	private String strItemBrandId = "0";
	
	/** The str batch sl no. */
	private String strBatchSlNo = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str group id. */
	private String strGroupId = "";
	
	/** The str sub group id. */
	private String strSubGroupId = "0";
	
	/** The str req qty. */
	private String strReqQty = "0";
	
	/** The str req qty unit id. */
	private String strReqQtyUnitId = "0";
	
	/** The str sanction qty. */
	private String strSanctionQty = "0";
	
	/** The str sanction qty unit id. */
	private String strSanctionQtyUnitId = "0";
	
	/** The str issue qty. */
	private String strIssueQty = "0";
	
	/** The str issue qty unit id. */
	private String strIssueQtyUnitId = "0";
	
	/** The str inhand qty. */
	private String strInhandQty = "0";
	
	/** The str inhand qty unit id. */
	private String strInhandQtyUnitId = "";
	
	/** The str rate. */
	private String strRate = "0";
	
	/** The str rate unit id. */
	private String strRateUnitId = "";
	
	/** The str expiry date. */
	private String strExpiryDate = "";
	
	/** The str manufacturer id. */
	private String strManufacturerId = "";
	
	/** The str consumables flag. */
	private String strConsumablesFlag = "1";
	
	/** The str req no. */
	private String strReqNo = "";
	
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
	 * Gets the str item id.
	 * 
	 * @return the str item id
	 */
	public String getStrItemId() {
		return strItemId;
	}

	/**
	 * Sets the str item id.
	 * 
	 * @param strItemId the new str item id
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}

	/**
	 * Gets the str item brand id.
	 * 
	 * @return the str item brand id
	 */
	public String getStrItemBrandId() {
		return strItemBrandId;
	}

	/**
	 * Sets the str item brand id.
	 * 
	 * @param strItemBrandId the new str item brand id
	 */
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}

	/**
	 * Gets the str batch sl no.
	 * 
	 * @return the str batch sl no
	 */
	public String getStrBatchSlNo() {
		return strBatchSlNo;
	}

	/**
	 * Sets the str batch sl no.
	 * 
	 * @param strBatchSlNo the new str batch sl no
	 */
	public void setStrBatchSlNo(String strBatchSlNo) {
		this.strBatchSlNo = strBatchSlNo;
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
	 * Gets the str group id.
	 * 
	 * @return the str group id
	 */
	public String getStrGroupId() {
		return strGroupId;
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
	 * Gets the str sub group id.
	 * 
	 * @return the str sub group id
	 */
	public String getStrSubGroupId() {
		return strSubGroupId;
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
	 * Gets the str req qty.
	 * 
	 * @return the str req qty
	 */
	public String getStrReqQty() {
		return strReqQty;
	}

	/**
	 * Sets the str req qty.
	 * 
	 * @param strReqQty the new str req qty
	 */
	public void setStrReqQty(String strReqQty) {
		this.strReqQty = strReqQty;
	}

	/**
	 * Gets the str req qty unit id.
	 * 
	 * @return the str req qty unit id
	 */
	public String getStrReqQtyUnitId() {
		return strReqQtyUnitId;
	}

	/**
	 * Sets the str req qty unit id.
	 * 
	 * @param strReqQtyUnitId the new str req qty unit id
	 */
	public void setStrReqQtyUnitId(String strReqQtyUnitId) {
		this.strReqQtyUnitId = strReqQtyUnitId;
	}

	/**
	 * Gets the str sanction qty.
	 * 
	 * @return the str sanction qty
	 */
	public String getStrSanctionQty() {
		return strSanctionQty;
	}

	/**
	 * Sets the str sanction qty.
	 * 
	 * @param strSanctionQty the new str sanction qty
	 */
	public void setStrSanctionQty(String strSanctionQty) {
		this.strSanctionQty = strSanctionQty;
	}

	/**
	 * Gets the str sanction qty unit id.
	 * 
	 * @return the str sanction qty unit id
	 */
	public String getStrSanctionQtyUnitId() {
		return strSanctionQtyUnitId;
	}

	/**
	 * Sets the str sanction qty unit id.
	 * 
	 * @param strSanctionQtyUnitId the new str sanction qty unit id
	 */
	public void setStrSanctionQtyUnitId(String strSanctionQtyUnitId) {
		this.strSanctionQtyUnitId = strSanctionQtyUnitId;
	}

	/**
	 * Gets the str issue qty.
	 * 
	 * @return the str issue qty
	 */
	public String getStrIssueQty() {
		return strIssueQty;
	}

	/**
	 * Sets the str issue qty.
	 * 
	 * @param strIssueQty the new str issue qty
	 */
	public void setStrIssueQty(String strIssueQty) {
		this.strIssueQty = strIssueQty;
	}

	/**
	 * Gets the str issue qty unit id.
	 * 
	 * @return the str issue qty unit id
	 */
	public String getStrIssueQtyUnitId() {
		return strIssueQtyUnitId;
	}

	/**
	 * Sets the str issue qty unit id.
	 * 
	 * @param strIssueQtyUnitId the new str issue qty unit id
	 */
	public void setStrIssueQtyUnitId(String strIssueQtyUnitId) {
		this.strIssueQtyUnitId = strIssueQtyUnitId;
	}

	/**
	 * Gets the str inhand qty.
	 * 
	 * @return the str inhand qty
	 */
	public String getStrInhandQty() {
		return strInhandQty;
	}

	/**
	 * Sets the str inhand qty.
	 * 
	 * @param strInhandQty the new str inhand qty
	 */
	public void setStrInhandQty(String strInhandQty) {
		this.strInhandQty = strInhandQty;
	}

	/**
	 * Gets the str inhand qty unit id.
	 * 
	 * @return the str inhand qty unit id
	 */
	public String getStrInhandQtyUnitId() {
		return strInhandQtyUnitId;
	}

	/**
	 * Sets the str inhand qty unit id.
	 * 
	 * @param strInhandQtyUnitId the new str inhand qty unit id
	 */
	public void setStrInhandQtyUnitId(String strInhandQtyUnitId) {
		this.strInhandQtyUnitId = strInhandQtyUnitId;
	}

	/**
	 * Gets the str rate.
	 * 
	 * @return the str rate
	 */
	public String getStrRate() {
		return strRate;
	}

	/**
	 * Sets the str rate.
	 * 
	 * @param strRate the new str rate
	 */
	public void setStrRate(String strRate) {
		this.strRate = strRate;
	}

	/**
	 * Gets the str rate unit id.
	 * 
	 * @return the str rate unit id
	 */
	public String getStrRateUnitId() {
		return strRateUnitId;
	}

	/**
	 * Sets the str rate unit id.
	 * 
	 * @param strRateUnitId the new str rate unit id
	 */
	public void setStrRateUnitId(String strRateUnitId) {
		this.strRateUnitId = strRateUnitId;
	}

	/**
	 * Gets the str expiry date.
	 * 
	 * @return the str expiry date
	 */
	public String getStrExpiryDate() {
		return strExpiryDate;
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
	 * Gets the str manufacturer id.
	 * 
	 * @return the str manufacturer id
	 */
	public String getStrManufacturerId() {
		return strManufacturerId;
	}

	/**
	 * Sets the str manufacturer id.
	 * 
	 * @param strManufacturerId the new str manufacturer id
	 */
	public void setStrManufacturerId(String strManufacturerId) {
		this.strManufacturerId = strManufacturerId;
	}

	/**
	 * Gets the str consumables flag.
	 * 
	 * @return the str consumables flag
	 */
	public String getStrConsumablesFlag() {
		return strConsumablesFlag;
	}

	/**
	 * Sets the str consumables flag.
	 * 
	 * @param strConsumablesFlag the new str consumables flag
	 */
	public void setStrConsumablesFlag(String strConsumablesFlag) {
		this.strConsumablesFlag = strConsumablesFlag;
	}

	/**
	 * Gets the str req no.
	 * 
	 * @return the str req no
	 */
	public String getStrReqNo() {
		return strReqNo;
	}

	/**
	 * Sets the str req no.
	 * 
	 * @param strReqNo the new str req no
	 */
	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
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
	 * Insert.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";
		int nInsertedIndex = 0;
		try {

			if (strReqNo.equals("0") || strReqNo.equals("")) {
				throw new Exception("strReqNo can not be blank");
			}
			if (strItemId.equals("0") || strItemId.equals("")) {
				throw new Exception("strItemId can not be blank");
			}

			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}

			// check mandatory information
			// if(this.nRowInserted == 0)
			{
				nInsertedIndex = dao.setProcedure("{call " + strProcName
						+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			dao.setProcInValue(nInsertedIndex, "modval", "2");
			dao.setProcInValue(nInsertedIndex, "item_id", strItemId);
			dao.setProcInValue(nInsertedIndex, "hosp_code", strHospitalCode);
			dao.setProcInValue(nInsertedIndex, "issue_qty", strIssueQty);
			dao.setProcInValue(nInsertedIndex, "issue_qty_unitid",
					strIssueQtyUnitId);
			dao.setProcInValue(nInsertedIndex, "req_no", strReqNo);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nInsertedIndex, "approval_level", "0");
			dao.setProcInValue(nInsertedIndex, "store_id", "0");
			dao.setProcInValue(nInsertedIndex, "stock_status_code", "0");
			dao.setProcInValue(nInsertedIndex, "itemSlNo", "0");
			dao.setProcInValue(nInsertedIndex, "itemcat_no", "0");
			dao.setProcInValue(nInsertedIndex, "itembrand_id", "0");
			dao.setProcInValue(nInsertedIndex, "batch_slno", "");
			dao.setProcInValue(nInsertedIndex, "group_id", "");
			dao.setProcInValue(nInsertedIndex, "subgroup_id", "0");
			dao.setProcInValue(nInsertedIndex, "req_qty", "0");
			dao.setProcInValue(nInsertedIndex, "req_qty_unitid", "");
			dao.setProcInValue(nInsertedIndex, "sanc_qty", "0");
			dao.setProcInValue(nInsertedIndex, "sanc_qty_unitid", "");
			dao.setProcInValue(nInsertedIndex, "inhand_qty", "0");
			dao.setProcInValue(nInsertedIndex, "inhand_qty_unitid", "");
			dao.setProcInValue(nInsertedIndex, "rate", "0");
			dao.setProcInValue(nInsertedIndex, "rate_unitid", "");
			dao.setProcInValue(nInsertedIndex, "expiry_date", "");
			dao.setProcInValue(nInsertedIndex, "consumables_flag", "1");
			dao.setProcInValue(nInsertedIndex, "institute_code", "");
			dao.setProcInValue(nInsertedIndex, "institute_slno", "0");
			dao.setProcInValue(nInsertedIndex, "seat_id", "");
			dao.setProcInValue(nInsertedIndex, "isvalid", "1");
			/* Setting Default Value End */
			
			
			dao.setProcOutValue(nInsertedIndex, "err", 1);
			dao.setProcOutValue(nInsertedIndex, "retSerialNo", 1);
			dao.setProcOutValue(nInsertedIndex, "dml_count", 1);
			// this.strErr=dao.getString(nInsertedIndex, "err");
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
	 * Reset.
	 */
	public void reset() {
		strItemId = "";
		strItemBrandId = "0";
		strBatchSlNo = "";
		strHospitalCode = "";
		strGroupId = "";
		strSubGroupId = "0";
		strReqQty = "0";
		strReqQtyUnitId = "";
		strSanctionQty = "0";
		strSanctionQtyUnitId = "";
		strIssueQty = "0";
		strIssueQtyUnitId = "";
		strInhandQty = "0";
		strInhandQtyUnitId = "";
		strRate = "0";
		strRateUnitId = "";
		strExpiryDate = "";
		strManufacturerId = "";
		strConsumablesFlag = "1";
		strReqNo = "";
	}
}
