package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class GenericItemDAO.
 */
public class GenericItemDAO {

	/** The str proc name. */
//	private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.GenericItemDAO";
	
	/** The str item id. */
	private String strItemId = "";
	
	private String strItemCode = "";
	
	/** The str group id. */
	private String strGroupId = "";
	
	/** The str sub group id. */
	private String strSubGroupId = "";
	
	/** The str item cat no. */
	private String strItemCatNO = "";
	// private String strItemTypeId = "";
	/** The str item name. */
	private String strItemName = "";
	// private String strDefaultRate = "";
	// private String strRateUnitId = "";
	/** The str batch no req. */
	private String strBatchNoReq = "";
	
	/** The str expiry date req. */
	private String strExpiryDateReq = "";
	
	/** The str shelf life unit. */
	private String strShelfLifeUnit = "";
	
	/** The str shelf life. */
	private String strShelfLife = "";
	
	/** The str inventory unit id. */
	private String strInventoryUnitId = "";
	
	/** The str purchased lead time. */
	private String strPurchasedLeadTime = "";
	
	/** The str pur lead time unit. */
	private String strPurLeadTimeUnit = "";
	// private String strApprovedType="";
	// private String strIssueType = "";
	/** The str consumable flag. */
	private String strConsumableFlag = "";
	// private String strSetSachetFlag = "";
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str entry date. */
	private String strEntryDate = "";
	
	/** The str last modified date. */
	private String strLastModifiedDate = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str last modified seat id. */
	private String strLastModifiedSeatId = "";
	
	/** The str is valid. */
	private String strIsValid = "1";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str err. */
	private String strErr = "";
	
	/** The str serial no. */
	private String strSerialNo = "";
	
	/** The str param. */
	private String strParam = "";
	// private String strItemComposit="";
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

	/** The str spare part. */
//	private String strSparePart = "";
	
	/** The str stock update. */
//	private String strStockUpdate = "";
	
	private String strDepreciationcost="";
	private String strAssetsReq="0";


	/**
	 * @param strDepreciationcost the strDepreciationcost to set
	 */
	public void setStrDepreciationcost(String strDepreciationcost) {
		this.strDepreciationcost = strDepreciationcost;
	}

	/**
	 * @param strAssetsReq the strAssetsReq to set
	 */
	public void setStrAssetsReq(String strAssetsReq) {
		this.strAssetsReq = strAssetsReq;
	}

	 

	/**
	 * Sets the str serial no.
	 * 
	 * @param strSerialNo the new str serial no
	 */
	public void setStrSerialNo(String strSerialNo) {
		this.strSerialNo = strSerialNo;
	}

	/**
	 * Sets the str param.
	 * 
	 * @param strParam the new str param
	 */
	public void setStrParam(String strParam) {
		this.strParam = strParam;
	}

	/*
	 * public void setStrItemComposit(String strItemComposit) {
	 * this.strItemComposit = strItemComposit; }
	 */

	/**
	 * Gets the str effective from.
	 * 
	 * @return the str effective from
	 */
	public String getStrEffectiveFrom() {
		return strEffectiveFrom;
	}

	/**
	 * Sets the str effective from.
	 * 
	 * @param strEffectiveFrom the new str effective from
	 */
	public void setStrEffectiveFrom(String strEffectiveFrom) {
		this.strEffectiveFrom = strEffectiveFrom;
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
	 * Gets the str entry date.
	 * 
	 * @return the str entry date
	 */
	public String getStrEntryDate() {
		return strEntryDate;
	}

	/**
	 * Sets the str entry date.
	 * 
	 * @param strEntryDate the new str entry date
	 */
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}

	/**
	 * Gets the str last modified date.
	 * 
	 * @return the str last modified date
	 */
	public String getStrLastModifiedDate() {
		return strLastModifiedDate;
	}

	/**
	 * Sets the str last modified date.
	 * 
	 * @param strLastModifiedDate the new str last modified date
	 */
	public void setStrLastModifiedDate(String strLastModifiedDate) {
		this.strLastModifiedDate = strLastModifiedDate;
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
	 * Gets the str last modified seat id.
	 * 
	 * @return the str last modified seat id
	 */
	public String getStrLastModifiedSeatId() {
		return strLastModifiedSeatId;
	}

	/**
	 * Sets the str last modified seat id.
	 * 
	 * @param strLastModifiedSeatId the new str last modified seat id
	 */
	public void setStrLastModifiedSeatId(String strLastModifiedSeatId) {
		this.strLastModifiedSeatId = strLastModifiedSeatId;
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
	 */
	public void insert(HisDAO dao) {
		String strQuery = "";
		int nQueryIndex = 0;
		try {

			strQuery = mms.qryHandler_mms.getQuery(1, "insert.item.0");
			nQueryIndex = dao.setQuery(strQuery);

			// //System.out.println("this.getStrSubGroupId()"+this.getStrSubGroupId());
			dao.setQryValue(nQueryIndex, 1, this.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, this.getStrItemCatNO());
			dao.setQryValue(nQueryIndex, 3, this.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 4, this.getStrGroupId());
			dao.setQryValue(nQueryIndex, 5, this.getStrSubGroupId());
			dao.setQryValue(nQueryIndex, 6, this.getStrItemCatNO());
			// dao.setQryValue(nQueryIndex, 7, this.getStrItemTypeId());
			dao.setQryValue(nQueryIndex, 7, this.getStrItemName());
			// dao.setQryValue(nQueryIndex, 9, this.getStrDefaultRate());
			// dao.setQryValue(nQueryIndex, 10, this.getStrRateUnitId());
			dao.setQryValue(nQueryIndex, 8, this.getStrBatchNoReq());
			dao.setQryValue(nQueryIndex, 9, this.getStrExpiryDateReq());
			dao.setQryValue(nQueryIndex, 10, this.getStrShelfLife());
			dao.setQryValue(nQueryIndex, 11, this.getStrShelfLifeUnit());
			dao.setQryValue(nQueryIndex, 12, this.getStrInventoryUnitId());
			dao.setQryValue(nQueryIndex, 13, this.getStrPurchasedLeadTime());
			dao.setQryValue(nQueryIndex, 14, this.getStrPurLeadTimeUnit());
			// dao.setQryValue(nQueryIndex, 18, this.getStrApprovedType());
			// dao.setQryValue(nQueryIndex, 19, this.getStrIssueType());
			dao.setQryValue(nQueryIndex, 15, this.getStrConsumableFlag());
			// dao.setQryValue(nQueryIndex, 21, this.getStrSetSachetFlag());
			dao.setQryValue(nQueryIndex, 16, this.getStrRemarks());
			dao.setQryValue(nQueryIndex, 17, this.getStrEffectiveFrom());
			dao.setQryValue(nQueryIndex, 18, this.getStrSeatId());
			dao.setQryValue(nQueryIndex, 19, this.getStrIsValid());
			dao.setQryValue(nQueryIndex, 20, this.strSerialNo == null ? "0": strSerialNo);
			dao.setQryValue(nQueryIndex, 21, this.strParam == null ? "0": strParam);
			dao.setQryValue(nQueryIndex, 22, strDepreciationcost);
			dao.setQryValue(nQueryIndex, 23, strAssetsReq);
			dao.setQryValue(nQueryIndex, 24, strItemCode);
		
			// dao.setQryValue(nQueryIndex, 28,
			// this.strItemComposit==null?"0":strItemComposit);
			/*
			 * dao.setQryValue(nQueryIndex, 28, this.strSparePart == null ||
			 * this.strSparePart.equals("") ? "0" : strSparePart);
			 */
			/*
			 * dao.setQryValue(nQueryIndex, 29, this.strStockUpdate == null ||
			 * this.strStockUpdate.equals("") ? "0" : strStockUpdate);
			 */
			dao.execute(nQueryIndex, 0);
			nRowInserted++;

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * Insert.
	 * 
	 * @param dao the dao
	 */
	public void insert1(HisDAO dao) 
	{
		String strQuery = "";
		int nQueryIndex = 0;
		try 
		{

			strQuery = mms.qryHandler_mms.getQuery(1, "insert.item.a");
			nQueryIndex = dao.setQuery(strQuery);
			
			dao.setQryValue(nQueryIndex, 1,  this.strItemId);			
			dao.setQryValue(nQueryIndex, 2,  this.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 3,  this.getStrGroupId());
			dao.setQryValue(nQueryIndex, 4,  this.getStrSubGroupId());
			dao.setQryValue(nQueryIndex, 5,  this.getStrItemCatNO());			
			dao.setQryValue(nQueryIndex, 6,  this.getStrItemName());			
			dao.setQryValue(nQueryIndex, 7,  this.getStrBatchNoReq());
			dao.setQryValue(nQueryIndex, 8,  this.getStrExpiryDateReq());
			dao.setQryValue(nQueryIndex, 9, this.getStrShelfLife());
			dao.setQryValue(nQueryIndex, 10, this.getStrShelfLifeUnit());
			dao.setQryValue(nQueryIndex, 11, this.getStrInventoryUnitId());
			dao.setQryValue(nQueryIndex, 12, this.getStrPurchasedLeadTime());
			dao.setQryValue(nQueryIndex, 13, this.getStrPurLeadTimeUnit());
			dao.setQryValue(nQueryIndex, 14, this.getStrConsumableFlag());
			dao.setQryValue(nQueryIndex, 15, this.getStrRemarks());
			dao.setQryValue(nQueryIndex, 16, this.getStrEffectiveFrom());
			dao.setQryValue(nQueryIndex, 17, this.getStrSeatId());
			dao.setQryValue(nQueryIndex, 18, this.getStrIsValid());
			dao.setQryValue(nQueryIndex, 19, this.strSerialNo == null ? "0"	: strSerialNo);
			dao.setQryValue(nQueryIndex, 20, this.strParam == null ? "0": strParam);
			dao.setQryValue(nQueryIndex, 21, strDepreciationcost);
			dao.setQryValue(nQueryIndex, 22, strAssetsReq);
			dao.setQryValue(nQueryIndex, 23, strItemCode);
			dao.setQryValue(nQueryIndex, 24, this.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 25, this.strItemId);
			dao.execute(nQueryIndex, 0);
			nRowInserted++;

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Update.
	 * 
	 * @param dao the dao
	 */
	public void update1(HisDAO dao) 
	{
		String strQuery = "";
		int nQueryIndex = 0;
		try {

			// //System.out.println("dao update");
			strQuery = mms.qryHandler_mms.getQuery(1, "update.item.a");
			nQueryIndex = dao.setQuery(strQuery);
			
			dao.setQryValue(nQueryIndex, 1, this.getStrSeatId());			
			dao.setQryValue(nQueryIndex, 2, this.getStrItemId());
			dao.setQryValue(nQueryIndex, 3, this.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 4, this.strSerialNo);
			dao.execute(nQueryIndex, 0);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Update.
	 * 
	 * @param dao the dao
	 */
	public void update(HisDAO dao) {
		String strQuery = "";
		int nQueryIndex = 0;
		try {
			strQuery = mms.qryHandler_mms.getQuery(1, "update.item.0");
			nQueryIndex = dao.setQuery(strQuery);
			// dao.setQryValue(nQueryIndex, 1, this.getStrItemTypeId());
			dao.setQryValue(nQueryIndex, 1, this.getStrItemName());
			// dao.setQryValue(nQueryIndex, 3, this.getStrDefaultRate());
			// dao.setQryValue(nQueryIndex, 4, this.getStrRateUnitId());
			dao.setQryValue(nQueryIndex, 2, this.getStrBatchNoReq());
			dao.setQryValue(nQueryIndex, 3, this.getStrExpiryDateReq());
			dao.setQryValue(nQueryIndex, 4, this.getStrShelfLife());
			dao.setQryValue(nQueryIndex, 5, this.getStrShelfLifeUnit());
			//dao.setQryValue(nQueryIndex, 6, this.getStrInventoryUnitId());
			dao.setQryValue(nQueryIndex, 6, this.getStrPurchasedLeadTime());
			dao.setQryValue(nQueryIndex, 7, this.getStrPurLeadTimeUnit());
			// dao.setQryValue(nQueryIndex, 12, this.getStrApprovedType());
			dao.setQryValue(nQueryIndex, 8, this.getStrConsumableFlag());
			// dao.setQryValue(nQueryIndex, 14, this.getStrSetSachetFlag());
			dao.setQryValue(nQueryIndex, 9, this.getStrRemarks());
			dao.setQryValue(nQueryIndex, 10, this.getStrEffectiveFrom());
			dao.setQryValue(nQueryIndex, 11, this.getStrIsValid());
			dao.setQryValue(nQueryIndex, 12, this.getStrSeatId());
			// dao.setQryValue(nQueryIndex, 19, this.getStrIssueType());
			dao.setQryValue(nQueryIndex, 13, this.strSerialNo == null ? "0"
					: strSerialNo);
			dao.setQryValue(nQueryIndex, 14, this.strParam == null ? "0"
					: strParam);
			// dao.setQryValue(nQueryIndex, 22,
			// this.strItemComposit==null?"0":strItemComposit);
			/*
			 * dao.setQryValue(nQueryIndex, 22, this.strSparePart == null ||
			 * this.strSparePart.equals("") ? "0" : strSparePart);
			 * dao.setQryValue(nQueryIndex, 23, this.strStockUpdate == null ||
			 * this.strStockUpdate.equals("") ? "0" : strStockUpdate);
			 */
			dao.setQryValue(nQueryIndex, 15, strItemCatNO);
			dao.setQryValue(nQueryIndex, 16, strAssetsReq);
			dao.setQryValue(nQueryIndex, 17, strDepreciationcost);
			dao.setQryValue(nQueryIndex, 18, strItemCode);
			dao.setQryValue(nQueryIndex, 19, this.getStrItemId());
			dao.setQryValue(nQueryIndex, 20, this.getStrHospitalCode());

			dao.execute(nQueryIndex, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Reset.
	 */
	public void reset() {
		strItemId = "0";
		strGroupId = "0";
		strSubGroupId = "0";
		strItemCatNO = "0";
		strItemName = "";
		// strDefaultRate = "";
		// strRateUnitId = "";
		strBatchNoReq = "";
		strExpiryDateReq = "";
		strShelfLifeUnit = "";
		strShelfLife = "";
		strInventoryUnitId = "";
		strPurchasedLeadTime = "";
		strPurLeadTimeUnit = "";
		// strApprovedType = "";
		// strIssueType = "";
		strConsumableFlag = "0";
		// strSetSachetFlag = "";
		strEffectiveFrom = "";
		strRemarks = "";
		strEntryDate = "";
		strLastModifiedDate = "";
		strSeatId = "";
		strLastModifiedSeatId = "";
		strIsValid = "";
		strHospitalCode = "";
		// strItemComposit="";
		strParam = "";
		strSerialNo = "";
	//	strStockUpdate = "";
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
	 * Gets the str item name.
	 * 
	 * @return the str item name
	 */
	public String getStrItemName() {
		return strItemName;
	}

	/**
	 * Sets the str item name.
	 * 
	 * @param strItemName the new str item name
	 */
	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}

	/**
	 * Gets the str batch no req.
	 * 
	 * @return the str batch no req
	 */
	public String getStrBatchNoReq() {
		return strBatchNoReq;
	}

	/**
	 * Sets the str batch no req.
	 * 
	 * @param strBatchNoReq the new str batch no req
	 */
	public void setStrBatchNoReq(String strBatchNoReq) {
		this.strBatchNoReq = strBatchNoReq;
	}

	/**
	 * Gets the str expiry date req.
	 * 
	 * @return the str expiry date req
	 */
	public String getStrExpiryDateReq() {
		return strExpiryDateReq;
	}

	/**
	 * Sets the str expiry date req.
	 * 
	 * @param strExpiryDateReq the new str expiry date req
	 */
	public void setStrExpiryDateReq(String strExpiryDateReq) {
		this.strExpiryDateReq = strExpiryDateReq;
	}

	/**
	 * Gets the str shelf life unit.
	 * 
	 * @return the str shelf life unit
	 */
	public String getStrShelfLifeUnit() {
		return strShelfLifeUnit;
	}

	/**
	 * Sets the str shelf life unit.
	 * 
	 * @param strShelfLifeUnit the new str shelf life unit
	 */
	public void setStrShelfLifeUnit(String strShelfLifeUnit) {
		this.strShelfLifeUnit = strShelfLifeUnit;
	}

	/**
	 * Gets the str shelf life.
	 * 
	 * @return the str shelf life
	 */
	public String getStrShelfLife() {
		return strShelfLife;
	}

	/**
	 * Sets the str shelf life.
	 * 
	 * @param strShelfLife the new str shelf life
	 */
	public void setStrShelfLife(String strShelfLife) {
		this.strShelfLife = strShelfLife;
	}

	/**
	 * Gets the str inventory unit id.
	 * 
	 * @return the str inventory unit id
	 */
	public String getStrInventoryUnitId() {
		return strInventoryUnitId;
	}

	/**
	 * Sets the str inventory unit id.
	 * 
	 * @param strInventoryUnitId the new str inventory unit id
	 */
	public void setStrInventoryUnitId(String strInventoryUnitId) {
		this.strInventoryUnitId = strInventoryUnitId;
	}

	/**
	 * Gets the str purchased lead time.
	 * 
	 * @return the str purchased lead time
	 */
	public String getStrPurchasedLeadTime() {
		return strPurchasedLeadTime;
	}

	/**
	 * Sets the str purchased lead time.
	 * 
	 * @param strPurchasedLeadTime the new str purchased lead time
	 */
	public void setStrPurchasedLeadTime(String strPurchasedLeadTime) {
		this.strPurchasedLeadTime = strPurchasedLeadTime;
	}

	/**
	 * Gets the str pur lead time unit.
	 * 
	 * @return the str pur lead time unit
	 */
	public String getStrPurLeadTimeUnit() {
		return strPurLeadTimeUnit;
	}

	/**
	 * Sets the str pur lead time unit.
	 * 
	 * @param strPurLeadTimeUnit the new str pur lead time unit
	 */
	public void setStrPurLeadTimeUnit(String strPurLeadTimeUnit) {
		this.strPurLeadTimeUnit = strPurLeadTimeUnit;
	}

	/**
	 * Gets the str consumable flag.
	 * 
	 * @return the str consumable flag
	 */
	public String getStrConsumableFlag() {
		return strConsumableFlag;
	}

	/**
	 * Sets the str consumable flag.
	 * 
	 * @param strConsumableFlag the new str consumable flag
	 */
	public void setStrConsumableFlag(String strConsumableFlag) {
		this.strConsumableFlag = strConsumableFlag;
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
	 * Gets the str item cat no.
	 * 
	 * @return the str item cat no
	 */
	public String getStrItemCatNO() {
		return strItemCatNO;
	}

	/**
	 * Sets the str item cat no.
	 * 
	 * @param strItemCatNO the new str item cat no
	 */
	public void setStrItemCatNO(String strItemCatNO) {
		this.strItemCatNO = strItemCatNO;
	}

	/**
	 * @param strItemCode the strItemCode to set
	 */
	public void setStrItemCode(String strItemCode) {
		this.strItemCode = strItemCode;
	}
}
