package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class AcknowledgeStockDAO.
 */
public class AcknowledgeStockDAO {

	/** The str file name. */
	private final String strFileName = "mms.dao.AcknowledgeStockDAO";
	
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

	/** The str store id. */
	private String strStoreId = "";
	
	/** The str old stock status code. */
	private String strOldStockStatusCode = "";
	
	/** The str old item serial no. */
	private String strOldItemSerialNo = "";
	
	/** The str old batch no. */
	private String strOldBatchNo = "";
	
	/** The str old item brand id. */
	private String strOldItemBrandId = "";
	
	/** The str old item id. */
	private String strOldItemId = "";
	
	/** The str to store id. */
	private String strToStoreId = "";
	
	/** The str item cat no. */
	private String strItemCatNo = "";
	
	/** The str in hand qty. */
	private String strInHandQty = "";
	
	/** The str in hand qty unit id. */
	private String strInHandQtyUnitId = "";
	
	/** The str ack no. */
	private String strAckNo = "";
	
	/** The str ack date. */
	private String strAckDate = "";
	
	/** The str description. */
	private String strDescription = "";

	/** The str reserved flag. */
	private String strReservedFlag = "";
	
	/** The str blocked qty flag. */
	private String strBlockedQtyFlag = "";

	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str request type id. */
	private String strReqTypeId = "";

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
	 * Gets the str old stock status code.
	 * 
	 * @return the str old stock status code
	 */
	public String getStrOldStockStatusCode() {
		return strOldStockStatusCode;
	}

	/**
	 * Sets the str old stock status code.
	 * 
	 * @param strOldStockStatusCode the new str old stock status code
	 */
	public void setStrOldStockStatusCode(String strOldStockStatusCode) {
		this.strOldStockStatusCode = strOldStockStatusCode;
	}

	/**
	 * Gets the str old item serial no.
	 * 
	 * @return the str old item serial no
	 */
	public String getStrOldItemSerialNo() {
		return strOldItemSerialNo;
	}

	/**
	 * Sets the str old item serial no.
	 * 
	 * @param strOldItemSerialNo the new str old item serial no
	 */
	public void setStrOldItemSerialNo(String strOldItemSerialNo) {
		this.strOldItemSerialNo = strOldItemSerialNo;
	}

	/**
	 * Gets the str old batch no.
	 * 
	 * @return the str old batch no
	 */
	public String getStrOldBatchNo() {
		return strOldBatchNo;
	}

	/**
	 * Sets the str old batch no.
	 * 
	 * @param strOldBatchNo the new str old batch no
	 */
	public void setStrOldBatchNo(String strOldBatchNo) {
		this.strOldBatchNo = strOldBatchNo;
	}

	/**
	 * Gets the str old item brand id.
	 * 
	 * @return the str old item brand id
	 */
	public String getStrOldItemBrandId() {
		return strOldItemBrandId;
	}

	/**
	 * Sets the str old item brand id.
	 * 
	 * @param strOldItemBrandId the new str old item brand id
	 */
	public void setStrOldItemBrandId(String strOldItemBrandId) {
		this.strOldItemBrandId = strOldItemBrandId;
	}

	/**
	 * Gets the str old item id.
	 * 
	 * @return the str old item id
	 */
	public String getStrOldItemId() {
		return strOldItemId;
	}

	/**
	 * Sets the str old item id.
	 * 
	 * @param strOldItemId the new str old item id
	 */
	public void setStrOldItemId(String strOldItemId) {
		this.strOldItemId = strOldItemId;
	}

	/**
	 * Gets the str to store id.
	 * 
	 * @return the str to store id
	 */
	public String getStrToStoreId() {
		return strToStoreId;
	}

	/**
	 * Sets the str to store id.
	 * 
	 * @param strToStoreId the new str to store id
	 */
	public void setStrToStoreId(String strToStoreId) {
		this.strToStoreId = strToStoreId;
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
	 * Gets the str in hand qty.
	 * 
	 * @return the str in hand qty
	 */
	public String getStrInHandQty() {
		return strInHandQty;
	}

	/**
	 * Sets the str in hand qty.
	 * 
	 * @param strInHandQty the new str in hand qty
	 */
	public void setStrInHandQty(String strInHandQty) {
		this.strInHandQty = strInHandQty;
	}

	/**
	 * Gets the str in hand qty unit id.
	 * 
	 * @return the str in hand qty unit id
	 */
	public String getStrInHandQtyUnitId() {
		return strInHandQtyUnitId;
	}

	/**
	 * Sets the str in hand qty unit id.
	 * 
	 * @param strInHandQtyUnitId the new str in hand qty unit id
	 */
	public void setStrInHandQtyUnitId(String strInHandQtyUnitId) {
		this.strInHandQtyUnitId = strInHandQtyUnitId;
	}

	/**
	 * Gets the str ack no.
	 * 
	 * @return the str ack no
	 */
	public String getStrAckNo() {
		return strAckNo;
	}

	/**
	 * Sets the str ack no.
	 * 
	 * @param strAckNo the new str ack no
	 */
	public void setStrAckNo(String strAckNo) {
		this.strAckNo = strAckNo;
	}

	/**
	 * Gets the str ack date.
	 * 
	 * @return the str ack date
	 */
	public String getStrAckDate() {
		return strAckDate;
	}

	/**
	 * Sets the str ack date.
	 * 
	 * @param strAckDate the new str ack date
	 */
	public void setStrAckDate(String strAckDate) {
		this.strAckDate = strAckDate;
	}

	/**
	 * Gets the str description.
	 * 
	 * @return the str description
	 */
	public String getStrDescription() {
		return strDescription;
	}

	/**
	 * Sets the str description.
	 * 
	 * @param strDescription the new str description
	 */
	public void setStrDescription(String strDescription) {
		this.strDescription = strDescription;
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
	 * Gets the str reserved flag.
	 * 
	 * @return the str reserved flag
	 */
	public String getStrReservedFlag() {
		return strReservedFlag;
	}

	/**
	 * Sets the str reserved flag.
	 * 
	 * @param strReservedFlag the new str reserved flag
	 */
	public void setStrReservedFlag(String strReservedFlag) {
		this.strReservedFlag = strReservedFlag;
	}

	/**
	 * Gets the str blocked qty flag.
	 * 
	 * @return the str blocked qty flag
	 */
	public String getStrBlockedQtyFlag() {
		return strBlockedQtyFlag;
	}

	/**
	 * Sets the str blocked qty flag.
	 * 
	 * @param strBlockedQtyFlag the new str blocked qty flag
	 */
	public void setStrBlockedQtyFlag(String strBlockedQtyFlag) {
		this.strBlockedQtyFlag = strBlockedQtyFlag;
	}

	/**
	 * Update.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */
	public void update(HisDAO dao) throws Exception {
		strErr = "";
		int nprocIndex;
		String proc_name = "";

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("Hospital Code can not be blank");
			}
			if (strStoreId.equals("0") || strStoreId.equals("")) {
				throw new Exception("Store Id can not be blank");
			}
			if (strOldItemId.equals("0") || strOldItemId.equals("")) {
				throw new Exception("ItemId can not be blank");
			}
			if (strOldItemBrandId.equals("0") || strOldItemBrandId.equals("")) {
				throw new Exception("Item BrandId can not be blank");
			}
			if (strOldStockStatusCode.equals("0")
					|| strOldStockStatusCode.equals("")) {
				throw new Exception("Stock Status Code can not be blank");
			}

			proc_name = "{call PKG_MMS_DML.dml_ack_item_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";  // 17 Variable
			
			
			System.out.println("--------strToStoreId.trim()------------"+strToStoreId.trim());
			System.out.println("--------strOldItemId.trim()------------"+strOldItemId.trim());
			System.out.println("--------strOldItemBrandId.trim()------------"+strOldItemBrandId.trim());
			System.out.println("--------strOldBatchNo.trim()------------"+strOldBatchNo.trim());
			System.out.println("--------strOldStockStatusCode.trim()------------"+strOldStockStatusCode.trim());
			System.out.println("--------strInHandQty.trim()------------"+strInHandQty.trim());
			System.out.println("--------strHospitalCode.trim()------------"+strHospitalCode.trim());
			System.out.println("--------strOldItemSerialNo.trim()------------"+strOldItemSerialNo.trim());
			System.out.println("--------strToStoreId.trim()------------"+strStoreId.trim());
			System.out.println("--------strReqTypeId.trim()------------"+strReqTypeId.trim());
			System.out.println("--------strAckNo.trim()------------"+strAckNo.trim());
			

			nprocIndex = dao.setProcedure(proc_name);
			dao.setProcInValue(nprocIndex, "modval", "1",1); //1
			// default value according to the procedure
			dao.setProcInValue(nprocIndex, "nstrid",            strToStoreId.trim(),2);//2
			dao.setProcInValue(nprocIndex, "nitemid",           strOldItemId.trim(),3);//3
			dao.setProcInValue(nprocIndex, "nitembrandid",  	strOldItemBrandId.trim(),4);//4
			dao.setProcInValue(nprocIndex, "nbatchno", 			strOldBatchNo.trim(),5);//5
			dao.setProcInValue(nprocIndex, "nitemcatno",		strItemCatNo.trim(),6);//6
			dao.setProcInValue(nprocIndex, "nstockstatuscode",  strOldStockStatusCode.trim(),7);//7
			dao.setProcInValue(nprocIndex, "ninhandqty",		strInHandQty.trim(),8);//8
			dao.setProcInValue(nprocIndex, "nseatid", 			strSeatId.trim(),9);//9
			dao.setProcInValue(nprocIndex, "nhosp_code", 		strHospitalCode.trim(),10);//10
			dao.setProcInValue(nprocIndex, "nold_itemserialno", strOldItemSerialNo.trim(),11);//11
			dao.setProcInValue(nprocIndex, "ntostrid", 			strStoreId.trim(),12);//12
			dao.setProcInValue(nprocIndex, "nreqtypeid",		strReqTypeId.trim(),13);//13
			dao.setProcInValue(nprocIndex, "nackNo",			strAckNo.trim(),14);//14		
	 //System.out.println("Ack No==>"+strAckNo.trim());
			dao.setProcInValue(nprocIndex, "ntransNo", 			strAckNo.trim(),15);//15
			dao.setProcInValue(nprocIndex, "nStockRegNo", 		"0",16);//16
		/* Setting Default Value End */			
			dao.setProcOutValue(nprocIndex, "err", 1,17); //17
			dao.execute(nprocIndex, 1);
			this.nUpdatedIndex++;

		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}
	}

	/**
	 * Reset.
	 */
	public void reset() {

		strStoreId = "";
		strOldStockStatusCode = "";
		strOldItemSerialNo = "";
		strOldBatchNo = "";
		strOldItemBrandId = "";
		strOldItemId = "";
		strToStoreId = "";
		strItemCatNo = "";
		strInHandQty = "";
		strInHandQtyUnitId = "";
		strAckNo = "";
		strAckDate = "";
		strDescription = "";
		strSeatId = "";
		strHospitalCode = "";
		strReqTypeId = "";

	}

	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}

}
