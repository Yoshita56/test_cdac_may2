/**
 * 
 */
package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class QualityCheckControlDAO.
 * 
 * @author user
 */
public class QualityCheckControlDAO {

	/** The str proc name. */
	private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.QualityCheckControlDao";

	/** The str generic item id. */
	private String strGenericItemId = "";
	
	/** The str item brand id. */
	private String strItemBrandId = "";
	
	/** The str batch no. */
	private String strBatchNo = "";
	
	/** The str item serail no. */
	private String strItemSerailNo = "";
	
	/** The str stock status code. */
	private String strStockStatusCode = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str item category no. */
	private String strItemCategoryNo = "";
	
	/** The str group id. */
	private String strGroupId = "";
	
	/** The str sub group id. */
	private String strSubGroupId = "";
	
	/** The str inhand qty. */
	private String strInhandQty = "";
	
	/** The str inhand qty unit id. */
	private String strInhandQtyUnitId = "";
	
	/** The str consumed qty. */
	private String strConsumedQty = "";
	
	/** The str consumed qty unit id. */
	private String strConsumedQtyUnitId = "";
	
	/** The str po no. */
	private String strPONo = "";
	
	/** The str po date. */
	private String strPODate = "";
	
	/** The str supplier id. */
	private String strSupplierId = "";
	
	/** The str manufacturer id. */
	private String strManufacturerId = "";
	
	/** The str final result. */
	private String strFinalResult = "";
	
	/** The str item status. */
	private String strItemStatus = "1";
	
	/** The str distribution flag. */
	private String strDistributionFlag = "";
	
	/** The str committee no. */
	private String strCommitteeNo = "";
	
	/** The str committee type id. */
	private String strCommitteeTypeId = "";
	
	/** The str comm remarks sl no. */
	private String strCommRemarksSlNo = "";
	
	/** The str fin start date. */
	private String strFinStartDate = "";
	
	/** The str fin end date. */
	private String strFinEndDate = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str is valid. */
	private String strIsValid = "";
	
	/** The str store id. */
	private String strStoreId = "";
	
	/** The str remarks. */
	private String strRemarks = "";

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
	
	
	private String strFileQualityName  = "";         
	private String   strFileNo = "";                     
	private String strPageNo = "";                       

	public void setStrFileQualityName(String strFileQualityName) {
		this.strFileQualityName = strFileQualityName;
	}

	public void setStrFileNo(String strFileNo) {
		this.strFileNo = strFileNo;
	}

	public void setStrPageNo(String strPageNo) {
		this.strPageNo = strPageNo;
	}

	/**
	 * Gets the str generic item id.
	 * 
	 * @return the strGenericItemId
	 */
	public String getStrGenericItemId() {
		return strGenericItemId;
	}

	/**
	 * Sets the str generic item id.
	 * 
	 * @param strGenericItemId the strGenericItemId to set
	 */
	public void setStrGenericItemId(String strGenericItemId) {
		this.strGenericItemId = strGenericItemId;
	}

	/**
	 * Gets the str item brand id.
	 * 
	 * @return the strItemBrandId
	 */
	public String getStrItemBrandId() {
		return strItemBrandId;
	}

	/**
	 * Sets the str item brand id.
	 * 
	 * @param strItemBrandId the strItemBrandId to set
	 */
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}

	/**
	 * Gets the str batch no.
	 * 
	 * @return the strBatchNo
	 */
	public String getStrBatchNo() {
		return strBatchNo;
	}

	/**
	 * Sets the str batch no.
	 * 
	 * @param strBatchNo the strBatchNo to set
	 */
	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}

	/**
	 * Gets the str item serail no.
	 * 
	 * @return the strItemSerailNo
	 */
	public String getStrItemSerailNo() {
		return strItemSerailNo;
	}

	/**
	 * Sets the str item serail no.
	 * 
	 * @param strItemSerailNo the strItemSerailNo to set
	 */
	public void setStrItemSerailNo(String strItemSerailNo) {
		this.strItemSerailNo = strItemSerailNo;
	}

	/**
	 * Gets the str stock status code.
	 * 
	 * @return the strStockStatusCode
	 */
	public String getStrStockStatusCode() {
		return strStockStatusCode;
	}

	/**
	 * Sets the str stock status code.
	 * 
	 * @param strStockStatusCode the strStockStatusCode to set
	 */
	public void setStrStockStatusCode(String strStockStatusCode) {
		this.strStockStatusCode = strStockStatusCode;
	}

	/**
	 * Gets the str hospital code.
	 * 
	 * @return the strHospitalCode
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
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
	 * Gets the str item category no.
	 * 
	 * @return the strItemCategoryNo
	 */
	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
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
	 * Gets the str group id.
	 * 
	 * @return the strGroupId
	 */
	public String getStrGroupId() {
		return strGroupId;
	}

	/**
	 * Sets the str group id.
	 * 
	 * @param strGroupId the strGroupId to set
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	/**
	 * Gets the str sub group id.
	 * 
	 * @return the strSubGroupId
	 */
	public String getStrSubGroupId() {
		return strSubGroupId;
	}

	/**
	 * Sets the str sub group id.
	 * 
	 * @param strSubGroupId the strSubGroupId to set
	 */
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}

	/**
	 * Gets the str inhand qty.
	 * 
	 * @return the strInhandQty
	 */
	public String getStrInhandQty() {
		return strInhandQty;
	}

	/**
	 * Sets the str inhand qty.
	 * 
	 * @param strInhandQty the strInhandQty to set
	 */
	public void setStrInhandQty(String strInhandQty) {
		this.strInhandQty = strInhandQty;
	}

	/**
	 * Gets the str inhand qty unit id.
	 * 
	 * @return the strInhandQtyUnitId
	 */
	public String getStrInhandQtyUnitId() {
		return strInhandQtyUnitId;
	}

	/**
	 * Sets the str inhand qty unit id.
	 * 
	 * @param strInhandQtyUnitId the strInhandQtyUnitId to set
	 */
	public void setStrInhandQtyUnitId(String strInhandQtyUnitId) {
		this.strInhandQtyUnitId = strInhandQtyUnitId;
	}

	/**
	 * Gets the str consumed qty.
	 * 
	 * @return the strConsumedQty
	 */
	public String getStrConsumedQty() {
		return strConsumedQty;
	}

	/**
	 * Sets the str consumed qty.
	 * 
	 * @param strConsumedQty the strConsumedQty to set
	 */
	public void setStrConsumedQty(String strConsumedQty) {
		this.strConsumedQty = strConsumedQty;
	}

	/**
	 * Gets the str consumed qty unit id.
	 * 
	 * @return the strConsumedQtyUnitId
	 */
	public String getStrConsumedQtyUnitId() {
		return strConsumedQtyUnitId;
	}

	/**
	 * Sets the str consumed qty unit id.
	 * 
	 * @param strConsumedQtyUnitId the strConsumedQtyUnitId to set
	 */
	public void setStrConsumedQtyUnitId(String strConsumedQtyUnitId) {
		this.strConsumedQtyUnitId = strConsumedQtyUnitId;
	}

	/**
	 * Gets the str po no.
	 * 
	 * @return the strPONo
	 */
	public String getStrPONo() {
		return strPONo;
	}

	/**
	 * Sets the str po no.
	 * 
	 * @param strPONo the strPONo to set
	 */
	public void setStrPONo(String strPONo) {
		this.strPONo = strPONo;
	}

	/**
	 * Gets the str po date.
	 * 
	 * @return the strPODate
	 */
	public String getStrPODate() {
		return strPODate;
	}

	/**
	 * Sets the str po date.
	 * 
	 * @param strPODate the strPODate to set
	 */
	public void setStrPODate(String strPODate) {
		this.strPODate = strPODate;
	}

	/**
	 * Gets the str supplier id.
	 * 
	 * @return the strSupplierId
	 */
	public String getStrSupplierId() {
		return strSupplierId;
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
	 * Gets the str manufacturer id.
	 * 
	 * @return the strManufacturerId
	 */
	public String getStrManufacturerId() {
		return strManufacturerId;
	}

	/**
	 * Sets the str manufacturer id.
	 * 
	 * @param strManufacturerId the strManufacturerId to set
	 */
	public void setStrManufacturerId(String strManufacturerId) {
		this.strManufacturerId = strManufacturerId;
	}

	/**
	 * Gets the str final result.
	 * 
	 * @return the strFinalResult
	 */
	public String getStrFinalResult() {
		return strFinalResult;
	}

	/**
	 * Sets the str final result.
	 * 
	 * @param strFinalResult the strFinalResult to set
	 */
	public void setStrFinalResult(String strFinalResult) {
		this.strFinalResult = strFinalResult;
	}

	/**
	 * Gets the str item status.
	 * 
	 * @return the strItemStatus
	 */
	public String getStrItemStatus() {
		return strItemStatus;
	}

	/**
	 * Sets the str item status.
	 * 
	 * @param strItemStatus the strItemStatus to set
	 */
	public void setStrItemStatus(String strItemStatus) {
		this.strItemStatus = strItemStatus;
	}

	/**
	 * Gets the str distribution flag.
	 * 
	 * @return the strDistributionFlag
	 */
	public String getStrDistributionFlag() {
		return strDistributionFlag;
	}

	/**
	 * Sets the str distribution flag.
	 * 
	 * @param strDistributionFlag the strDistributionFlag to set
	 */
	public void setStrDistributionFlag(String strDistributionFlag) {
		this.strDistributionFlag = strDistributionFlag;
	}

	/**
	 * Gets the str committee no.
	 * 
	 * @return the strCommitteeNo
	 */
	public String getStrCommitteeNo() {
		return strCommitteeNo;
	}

	/**
	 * Sets the str committee no.
	 * 
	 * @param strCommitteeNo the strCommitteeNo to set
	 */
	public void setStrCommitteeNo(String strCommitteeNo) {
		this.strCommitteeNo = strCommitteeNo;
	}

	/**
	 * Gets the str committee type id.
	 * 
	 * @return the strCommitteeTypeId
	 */
	public String getStrCommitteeTypeId() {
		return strCommitteeTypeId;
	}

	/**
	 * Sets the str committee type id.
	 * 
	 * @param strCommitteeTypeId the strCommitteeTypeId to set
	 */
	public void setStrCommitteeTypeId(String strCommitteeTypeId) {
		this.strCommitteeTypeId = strCommitteeTypeId;
	}

	/**
	 * Gets the str comm remarks sl no.
	 * 
	 * @return the strCommRemarksSlNo
	 */
	public String getStrCommRemarksSlNo() {
		return strCommRemarksSlNo;
	}

	/**
	 * Sets the str comm remarks sl no.
	 * 
	 * @param strCommRemarksSlNo the strCommRemarksSlNo to set
	 */
	public void setStrCommRemarksSlNo(String strCommRemarksSlNo) {
		this.strCommRemarksSlNo = strCommRemarksSlNo;
	}

	/**
	 * Gets the str fin start date.
	 * 
	 * @return the strFinStartDate
	 */
	public String getStrFinStartDate() {
		return strFinStartDate;
	}

	/**
	 * Sets the str fin start date.
	 * 
	 * @param strFinStartDate the strFinStartDate to set
	 */
	public void setStrFinStartDate(String strFinStartDate) {
		this.strFinStartDate = strFinStartDate;
	}

	/**
	 * Gets the str fin end date.
	 * 
	 * @return the strFinEndDate
	 */
	public String getStrFinEndDate() {
		return strFinEndDate;
	}

	/**
	 * Sets the str fin end date.
	 * 
	 * @param strFinEndDate the strFinEndDate to set
	 */
	public void setStrFinEndDate(String strFinEndDate) {
		this.strFinEndDate = strFinEndDate;
	}

	/**
	 * Gets the str seat id.
	 * 
	 * @return the strSeatId
	 */
	public String getStrSeatId() {
		return strSeatId;
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
	 * Gets the str is valid.
	 * 
	 * @return the strIsValid
	 */
	public String getStrIsValid() {
		return strIsValid;
	}

	/**
	 * Sets the str is valid.
	 * 
	 * @param strIsValid the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	/**
	 * Gets the str store id.
	 * 
	 * @return the strStoreId
	 */
	public String getStrStoreId() {
		return strStoreId;
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
	 * Gets the str err.
	 * 
	 * @return the strErr
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * Sets the str err.
	 * 
	 * @param strErr the strErr to set
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
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
	 * Sets the n row inserted.
	 * 
	 * @param rowInserted the nRowInserted to set
	 */
	public void setNRowInserted(int rowInserted) {
		nRowInserted = rowInserted;
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
	 * Sets the n row updated.
	 * 
	 * @param rowUpdated the nRowUpdated to set
	 */
	public void setNRowUpdated(int rowUpdated) {
		nRowUpdated = rowUpdated;
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
	 * Sets the n row deleted.
	 * 
	 * @param rowDeleted the nRowDeleted to set
	 */
	public void setNRowDeleted(int rowDeleted) {
		nRowDeleted = rowDeleted;
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
	 * Sets the n inserted index.
	 * 
	 * @param insertedIndex the nInsertedIndex to set
	 */
	public void setNInsertedIndex(int insertedIndex) {
		nInsertedIndex = insertedIndex;
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
	 * Sets the n updated index.
	 * 
	 * @param updatedIndex the nUpdatedIndex to set
	 */
	public void setNUpdatedIndex(int updatedIndex) {
		nUpdatedIndex = updatedIndex;
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
	 * Sets the n deleted index.
	 * 
	 * @param deletedIndex the nDeletedIndex to set
	 */
	public void setNDeletedIndex(int deletedIndex) {
		nDeletedIndex = deletedIndex;
	}

	/**
	 * Gets the str proc name.
	 * 
	 * @return the strProcName
	 */
	public String getStrProcName() {
		return strProcName;
	}

	/**
	 * Gets the str file name.
	 * 
	 * @return the strFileName
	 */
	public String getStrFileName() {
		return strFileName;
	}

	// Methods starts from here

	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strHospitalCode or strGiftedNo is blank
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

			if (strGenericItemId.equals("0") || strGenericItemId.equals("")) {
				throw new Exception("strGenericItemId can not be blank");
			}
			if (strItemBrandId.equals("0") || strItemBrandId.equals("")) {
				throw new Exception("strItemBrandId can not be blank");
			}
			if (strStockStatusCode.equals("0") || strStockStatusCode.equals("")) {
				throw new Exception("strStockStatusCode can not be blank");
			}
			if (strStoreId.equals("0") || strStoreId.equals("")) {
				throw new Exception("strStoreId can not be blank");
			}

			strProcName = "{call Pkg_Mms_Dml.DML_QUALITYCHECK_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			nProcIndex = dao.setProcedure(strProcName);

			
			dao.setProcInValue(nProcIndex, "modval", "1");
			dao.setProcInValue(nProcIndex, "store_id", strStoreId);
			dao.setProcInValue(nProcIndex, "item_id", strGenericItemId);
			dao.setProcInValue(nProcIndex, "itembrand_id", strItemBrandId);
			dao.setProcInValue(nProcIndex, "batch_sl_no", strBatchNo);
			dao.setProcInValue(nProcIndex, "item_sl_no", strItemSerailNo);
			dao.setProcInValue(nProcIndex, "stock_status_code",	strStockStatusCode);

			dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode);
			dao.setProcInValue(nProcIndex, "item_cat_no", strItemCategoryNo);
			dao.setProcInValue(nProcIndex, "group_id", strGroupId);
			dao.setProcInValue(nProcIndex, "subgroup_id", strSubGroupId);
			dao.setProcInValue(nProcIndex, "inhand_qty", strInhandQty);
			dao.setProcInValue(nProcIndex, "inhand_qty_unitid",
					strInhandQtyUnitId);
			dao.setProcInValue(nProcIndex, "consumed_qty", strConsumedQty);
			dao.setProcInValue(nProcIndex, "consumed_qty_unitid",
					strConsumedQtyUnitId);
			dao.setProcInValue(nProcIndex, "po_no", strPONo);
			dao.setProcInValue(nProcIndex, "po_date", strPODate);
			dao.setProcInValue(nProcIndex, "supplier_id", strSupplierId);
			dao.setProcInValue(nProcIndex, "final_result", strFinalResult);
			dao.setProcInValue(nProcIndex, "item_status", strItemStatus);
			dao.setProcInValue(nProcIndex, "distribution_flag",
					strDistributionFlag);
			dao.setProcInValue(nProcIndex, "committee_no", strCommitteeNo);
			dao.setProcInValue(nProcIndex, "committee_type_id",
					strCommitteeTypeId);
			dao
					.setProcInValue(nProcIndex, "comm_rmks_slno",
							strCommRemarksSlNo);
			dao.setProcInValue(nProcIndex, "financial_start_date",
					strFinStartDate);
			dao.setProcInValue(nProcIndex, "financial_end_date", strFinEndDate);
			dao.setProcInValue(nProcIndex, "seatid", strSeatId);
			dao.setProcInValue(nProcIndex, "isvalid", strIsValid);
			dao.setProcInValue(nProcIndex, "remarks", strRemarks);
			dao.setProcInValue(nProcIndex, "strFileQualityName", strFileQualityName);
			dao.setProcInValue(nProcIndex, "strFileNo", strFileNo);
			dao.setProcInValue(nProcIndex, "strPageNo", strPageNo);
			dao.setProcInValue(nProcIndex, "manufacturer_id", "");
			
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
	 * Reset.
	 */
	public void reset() {

		strGenericItemId = "0";
		strItemBrandId = "0";
		strBatchNo = "0";
		strItemSerailNo = "";
		strStockStatusCode = "11";
		strHospitalCode = "1";
		strItemCategoryNo = "";
		strGroupId = "";
		strSubGroupId = "";
		strInhandQty = "";
		strInhandQtyUnitId = "";
		strConsumedQty = "";
		strConsumedQtyUnitId = "";
		strPONo = "";
		strPODate = "";
		strSupplierId = "";
		strManufacturerId = "0";
		strFinalResult = "";
		strItemStatus = "1";
		strDistributionFlag = "";
		strCommitteeNo = "";
		strCommitteeTypeId = "";
		strCommRemarksSlNo = "";
		strFinStartDate = "";
		strFinEndDate = "";
		strSeatId = "";
		strIsValid = "1";
		strStoreId = "";
	}

	/**
	 * Gets the str remarks.
	 * 
	 * @return the strRemarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

}
