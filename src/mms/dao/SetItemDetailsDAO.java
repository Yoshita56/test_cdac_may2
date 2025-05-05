package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class SetItemDetailsDAO.
 */

/**
 * Developer : Anshul Jindal 
 * Version : 1.0  (Corrections)
 * Date : 11/may/2009
 * Module:MMS
 * Unit:Set/Sachet Details
 * 
 *
 * This class will be used to insert the records Table Name :
 * HSTT_SET_ITEM_DTL
 */
/**
 * Developer : Pramod Kumar Mehta Version : 1.0 Date : 29/Jan/2009 Module:MMS
 * Unit:Set/Sachet Details
 * 
 */

public class SetItemDetailsDAO {

	
	
	
	
	/** The str group id. */
	private String strGroupId = "";
	
	/** The str sub group id. */
	private String strSubGroupId = "";
	
	/** The str prepared qty. */
	private String strPreparedQty = "";
	
	/** The str expiry date. */
	private String strExpiryDate = "";
	
	/** The str qty unit id. */
	private String strSetUnitId = "";

	private String strSetGenericItemId="";
	
	private String strLastItemFlag="";
	
	
	/** The str file name. */
	private final String strFileName = "mms.dao.SetSachetDetailsDAO";

	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str req qty. */
//	private String strReqQty = "";
	
	/** The str set sachet no. */
	private String strSetSachetNO = "";
	
	/** The str set id. */
	private String strSetId = "";
	
	/** The str item id. */
	private String strItemId = "";
	
	/** The str item brand id. */
	private String strItemBrandId = "";
	
	/** The str hos code. */
	private String strHosCode = "";
	
	/** The str req qty unit id. */
//	private String strReqQtyUnitId = "";
	
	/** The str req qty with prep qty. */
	private String strReqQtyWithPrepQty = "";
	
	/** The str inv unit id. */
	private String strInvUnitId = "";
	
	/** The str sale price. */
//	private String strSalePrice = "0";
	
	/** The str sale price unit id. */
//	private String strSalePriceUnitId = "";
	
	/** The str used qty unit id. */
//	private String strUsedQtyUnitId = "";
	
	/** The str store id. */
	private String strStoreId = "";
	
	/** The str used qty. */
//	private String strUsedQty = "";
	
	/** The str category no. */
	private String strCategoryNo = "";

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
	 * Gets the str file name.
	 * 
	 * @return the str file name
	 */
	public String getStrFileName() {
		return strFileName;
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
	 * Sets the str set sachet no.
	 * 
	 * @param strSetSachetNO the new str set sachet no
	 */
	public void setStrSetSachetNO(String strSetSachetNO) {
		this.strSetSachetNO = strSetSachetNO;
	}

	/**
	 * Sets the str set id.
	 * 
	 * @param strSetId the new str set id
	 */
	public void setStrSetId(String strSetId) {
		this.strSetId = strSetId;
	}

	/*
	 * public void setStrBatchSlNo(String strBatchSlNo) { this.strBatchSlNo =
	 * strBatchSlNo; }
	 */

	/**
	 * Sets the str hos code.
	 * 
	 * @param strHosCode the new str hos code
	 */
	public void setStrHosCode(String strHosCode) {
		this.strHosCode = strHosCode;
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
			if (strHosCode.equals("0") || strHosCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strSetSachetNO.equals("0") || strSetSachetNO.equals("")) {
				throw new Exception("strSetSachetNo can not be blank");
			}

			strProcName = "{call Pkg_Mms_Dml.Dml_Set_Item_Dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; // 12+8
			nProcIndex = dao.setProcedure(strProcName);
			dao.setProcInValue(nProcIndex, "modeval", "1");
			dao.setProcInValue(nProcIndex, "set_sachet_no", strSetSachetNO);
			dao.setProcInValue(nProcIndex, "store_id", strStoreId);
			dao.setProcInValue(nProcIndex, "set_id", strSetId);
			dao.setProcInValue(nProcIndex, "item_id", strItemId);
			dao.setProcInValue(nProcIndex, "item_brand_id", strItemBrandId);
			dao.setProcInValue(nProcIndex, "hospital_code", strHosCode);
			dao.setProcInValue(nProcIndex, "category_No", strCategoryNo);
			dao.setProcInValue(nProcIndex, "reqQty", strReqQtyWithPrepQty);
			dao.setProcInValue(nProcIndex, "inv_unitid", strInvUnitId);
			dao.setProcInValue(nProcIndex, "seatId", strSeatId);
			
		
			dao.setProcInValue(nProcIndex, "noOfSet", strPreparedQty);
			dao.setProcInValue(nProcIndex, "setUnitId", strSetUnitId);
			dao.setProcInValue(nProcIndex, "setGenericId", strSetGenericItemId);
			dao.setProcInValue(nProcIndex, "expiryDate", strExpiryDate);
			dao.setProcInValue(nProcIndex, "setGrpId", strGroupId);
			dao.setProcInValue(nProcIndex, "setSubGrpId", strSubGroupId);
			dao.setProcInValue(nProcIndex, "setCatNo", strCategoryNo);
			dao.setProcInValue(nProcIndex, "lstItemFlag", strLastItemFlag);

			dao.setProcOutValue(nProcIndex, "err", 1);
			/*
			 * dao.setProcOutValue(nProcIndex, "netRate", 1);
			 * dao.setProcOutValue(nProcIndex, "netSalePrice", 1);
			 * dao.setProcOutValue(nProcIndex, "netSalePriceUnit", 1);
			 */

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

		strSetSachetNO = "";
		strSetId = "";
		// strBatchSlNo = "";
		strHosCode = "";
		//strReqQtyUnitId = "";
		/*
		 * strInhandQty = ""; strInhandQtyUnitId = ""; strInhandQtyUnitId = "";
		 * strRate = "0"; strRateUnitId = "";
		 */
		//strSalePrice = "0";
		//strSalePriceUnitId = "";
		strStoreId = "";
		//strUsedQty = "";
		// strItemSlNo = "";
		strCategoryNo = "";

	}
 

	/**
	 * Sets the str item id.
	 * 
	 * @param strItemId the strItemId to set
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
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
	 * Sets the str used qty unit id.
	 * 
	 * @param strUsedQtyUnitId the str used qty unit id
	 */
	/*
	 * public void setStrInhandQty(String strInhandQty) { this.strInhandQty =
	 * strInhandQty; }
	 * 
	 *//**
		 * @param strInhandQtyUnitId
		 *            the strInhandQtyUnitId to set
		 */
	/*
	 * public void setStrInhandQtyUnitId(String strInhandQtyUnitId) {
	 * this.strInhandQtyUnitId = strInhandQtyUnitId; }
	 */

	 

	/**
	 * Sets the str sale price.
	 * 
	 * @param strSalePrice the str sale price
	 */
	/*
	 * public void setStrRate(String strRate) { this.strRate = strRate; }
	 * 
	 *//**
		 * @param strRateUnitId
		 *            the strRateUnitId to set
		 */
	/*
	 * public void setStrRateUnitId(String strRateUnitId) { this.strRateUnitId =
	 * strRateUnitId; }
	 */

	 

	/**
	 * Sets the n row inserted.
	 * 
	 * @param rowInserted the nRowInserted to set
	 */
	public void setNRowInserted(int rowInserted) {
		nRowInserted = rowInserted;
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

	/**
	 * Sets the str store id.
	 * 
	 * @param strStoreId the strStoreId to set
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	 

	/**
	 * Sets the str category no.
	 * 
	 * @param strCategoryNo the str category no
	 */
	/*
	 * public void setStrItemSlNo(String strItemSlNo) { this.strItemSlNo =
	 * strItemSlNo; }
	 */
	/**
	 * @param strCategoryNo
	 *            the strCategoryNo to set
	 */
	public void setStrCategoryNo(String strCategoryNo) {
		this.strCategoryNo = strCategoryNo;
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
	 * Sets the str req qty with prep qty.
	 * 
	 * @param strReqQtyWithPrepQty the strReqQtyWithPrepQty to set
	 */
	public void setStrReqQtyWithPrepQty(String strReqQtyWithPrepQty) {
		this.strReqQtyWithPrepQty = strReqQtyWithPrepQty;
	}

	/**
	 * Sets the str inv unit id.
	 * 
	 * @param strInvUnitId the strInvUnitId to set
	 */
	public void setStrInvUnitId(String strInvUnitId) {
		this.strInvUnitId = strInvUnitId;
	}

	/**
	 * @param strGroupId the strGroupId to set
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	/**
	 * @param strSubGroupId the strSubGroupId to set
	 */
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}

	/**
	 * @param strPreparedQty the strPreparedQty to set
	 */
	public void setStrPreparedQty(String strPreparedQty) {
		this.strPreparedQty = strPreparedQty;
	}

	/**
	 * @param strExpiryDate the strExpiryDate to set
	 */
	public void setStrExpiryDate(String strExpiryDate) {
		this.strExpiryDate = strExpiryDate;
	}

	/**
	 * @param strSetUnitId the strQtyUnitId to set
	 */
	public void setStrSetUnitId(String strSetUnitId) {
		this.strSetUnitId = strSetUnitId;
	}

	/**
	 * @param strSetGenericItemId the strSetGenericItemId to set
	 */
	public void setStrSetGenericItemId(String strSetGenericItemId) {
		this.strSetGenericItemId = strSetGenericItemId;
	}

	/**
	 * @param strLastItemFlag the strLastItemFlag to set
	 */
	public void setStrLastItemFlag(String strLastItemFlag) {
		this.strLastItemFlag = strLastItemFlag;
	}

}
