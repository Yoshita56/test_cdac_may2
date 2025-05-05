package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class PhysicalStockCountedItemDAO.
 */
public class PhysicalStockCountedItemDAO {

	/** The str file name. */
	private final String strFileName = "mms.dao.PhysicalStockCountedItemDAO";
	
	/** The str err. */
	private String strErr = "";

	/** The str store id. */
	private String strStoreId = "0";
	
	/** The str physical stock no. */
	private String strPhysicalStockNo = "0";
	
	/** The str item id. */
	private String strItemId = "0";
	
	/** The str item brand id. */
	private String strItemBrandId = "0";
	
	/** The str hospital code. */
	private String strHospitalCode = "0";
	
	/** The str group id. */
	private String strGroupId = "0";
	
	/** The str sub group id. */
	private String strSubGroupId = "0";
	
	/** The str batch sl no. */
	private String strBatchSlNo = "0";
	
	/** The str counted qty. */
	private String strCountedQty = "0";
	
	/** The str counted qty unit id. */
	private String strCountedQtyUnitId = "0";

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
	 * Gets the str physical stock no.
	 * 
	 * @return the str physical stock no
	 */
	public String getStrPhysicalStockNo() {
		return strPhysicalStockNo;
	}

	/**
	 * Sets the str physical stock no.
	 * 
	 * @param strPhysicalStockNo the new str physical stock no
	 */
	public void setStrPhysicalStockNo(String strPhysicalStockNo) {
		this.strPhysicalStockNo = strPhysicalStockNo;
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
	 * Gets the str counted qty.
	 * 
	 * @return the str counted qty
	 */
	public String getStrCountedQty() {
		return strCountedQty;
	}

	/**
	 * Sets the str counted qty.
	 * 
	 * @param strCountedQty the new str counted qty
	 */
	public void setStrCountedQty(String strCountedQty) {
		this.strCountedQty = strCountedQty;
	}

	/**
	 * Gets the str counted qty unit id.
	 * 
	 * @return the str counted qty unit id
	 */
	public String getStrCountedQtyUnitId() {
		return strCountedQtyUnitId;
	}

	/**
	 * Sets the str counted qty unit id.
	 * 
	 * @param strCountedQtyUnitId the new str counted qty unit id
	 */
	public void setStrCountedQtyUnitId(String strCountedQtyUnitId) {
		this.strCountedQtyUnitId = strCountedQtyUnitId;
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
		int nprocIndex;

		try {

			// check mandatory information
			if (strStoreId.equals("0") || strStoreId.equals("")) {
				throw new Exception("strStoreId can not be blank");
			}

			if (strPhysicalStockNo.equals("0") || strPhysicalStockNo.equals("")) {
				throw new Exception("strPhysicalStockNo can not be blank");
			}
			if (strItemId.equals("0") || strItemId.equals("")) {
				throw new Exception("strItemId can not be blank");
			}
			if (strItemBrandId.equals("0") || strItemBrandId.equals("")) {
				throw new Exception("strItemBrandId can not be blank");
			}

			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}

			String strProcName = "{call pkg_mms_dml.Dml_Hstt_Phystock_Item_Dtl(?,?,?,?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nprocIndex, "modval", "1");
			dao.setProcInValue(nprocIndex, "strId", strStoreId);
			dao.setProcInValue(nprocIndex, "phystockNo", strPhysicalStockNo);
			dao.setProcInValue(nprocIndex, "itemId", strItemId);
			dao.setProcInValue(nprocIndex, "itembrandId", strItemBrandId);
			dao.setProcInValue(nprocIndex, "hosp_code", strHospitalCode);
			dao.setProcInValue(nprocIndex, "groupId", strGroupId);
			dao.setProcInValue(nprocIndex, "subGroupId", strSubGroupId);
			dao.setProcInValue(nprocIndex, "batchSlNo", strBatchSlNo);
			dao.setProcInValue(nprocIndex, "countedQty", strCountedQty);
			dao.setProcInValue(nprocIndex, "countedQtyUnitId",
					strCountedQtyUnitId);

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
	 * Reset.
	 */
	public void reset() {

		strStoreId = "0";
		strPhysicalStockNo = "0";
		strItemId = "0";
		strItemBrandId = "0";
		strHospitalCode = "0";
		strGroupId = "0";
		strSubGroupId = "0";
		strBatchSlNo = "0";
		strCountedQty = "0";
		strCountedQtyUnitId = "0";

	}

}
