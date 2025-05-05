package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugDAO.
 */
public class DrugDAO {

	/** The str proc name. */
	//private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.DrugDAO";
	
	/** The str item id. */
	private String strItemId = "";
	
	/** The str group id. */
	private String strGroupId = "";
	
	/** The str sub group id. */
	private String strSubGroupId = "";
	
	/** The str item cat no. */
	private String strItemCatNO = "";
	
	/** The str item type id. */
	private String strItemTypeId = "";
	
	/** The str item name. */
	private String strItemName = "";
	
	/** The str default rate. */
	private String strDefaultRate = "";
	
	/** The str rate unit id. */
	private String strRateUnitId = "";
	
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
	
	/** The str approved type. */
	private String strApprovedType = "";
	
	/** The str issue type. */
	private String strIssueType = "";
	
	/** The str consumable flag. */
	private String strConsumableFlag = "";
	
	/** The str set sachet flag. */
	private String strSetSachetFlag = "";
	
	/** The str is narcotic. */
	private String strIsNarcotic = "";
	
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
	
	/** The str consent req. */
	private String strConsentReq = "";
	
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
	
	/** The str stock update. */
	private String strStockUpdate = "";

	/**
	 * Sets the str stock update.
	 * 
	 * @param strStockUpdate the new str stock update
	 */
	public void setStrStockUpdate(String strStockUpdate) {
		this.strStockUpdate = strStockUpdate;
	}

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

			strQuery = mms.qryHandler_mms.getQuery(1, "insert.drug.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, this.getStrItemId());
			dao.setQryValue(nQueryIndex, 2, this.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 3, this.getStrGroupId());
			dao.setQryValue(nQueryIndex, 4, this.getStrSubGroupId());
			dao.setQryValue(nQueryIndex, 5, this.getStrItemCatNO());
			dao.setQryValue(nQueryIndex, 6, this.getStrItemTypeId());
			dao.setQryValue(nQueryIndex, 7, this.getStrItemName());
			dao.setQryValue(nQueryIndex, 8, this.getStrDefaultRate());
			dao.setQryValue(nQueryIndex, 9, this.getStrRateUnitId());
			dao.setQryValue(nQueryIndex, 10, this.getStrBatchNoReq());
			dao.setQryValue(nQueryIndex, 11, this.getStrExpiryDateReq());
			dao.setQryValue(nQueryIndex, 12, this.getStrShelfLife());
			dao.setQryValue(nQueryIndex, 13, this.getStrShelfLifeUnit());
			dao.setQryValue(nQueryIndex, 14, this.getStrInventoryUnitId());
			dao.setQryValue(nQueryIndex, 15, this.getStrPurchasedLeadTime());
			dao.setQryValue(nQueryIndex, 16, this.getStrPurLeadTimeUnit());
			dao.setQryValue(nQueryIndex, 17, this.getStrApprovedType());
			dao.setQryValue(nQueryIndex, 18, this.getStrIssueType());
			dao.setQryValue(nQueryIndex, 19, this.getStrConsumableFlag());
			dao.setQryValue(nQueryIndex, 20, this.getStrSetSachetFlag());
			dao.setQryValue(nQueryIndex, 21, this.getStrIsNarcotic());
			dao.setQryValue(nQueryIndex, 22, this.getStrRemarks());
			dao.setQryValue(nQueryIndex, 23, this.getStrEffectiveFrom());
			dao.setQryValue(nQueryIndex, 24, this.getStrSeatId());
			dao.setQryValue(nQueryIndex, 25, this.getStrIsValid());
			dao.setQryValue(nQueryIndex, 26, this.strStockUpdate);
			dao.setQryValue(nQueryIndex, 27, strConsentReq);
			dao.execute(nQueryIndex, 0);
			nRowInserted++;
			// //System.out.println(" nRowInserted++;"+ nRowInserted);

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

			strQuery = mms.qryHandler_mms.getQuery(1, "update.drug.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, this.getStrItemTypeId());
			dao.setQryValue(nQueryIndex, 2, this.getStrItemName());
			dao.setQryValue(nQueryIndex, 3, this.getStrDefaultRate());
			dao.setQryValue(nQueryIndex, 4, this.getStrRateUnitId());
			dao.setQryValue(nQueryIndex, 5, this.getStrBatchNoReq());
			dao.setQryValue(nQueryIndex, 6, this.getStrExpiryDateReq());
			dao.setQryValue(nQueryIndex, 7, this.getStrShelfLife());
			dao.setQryValue(nQueryIndex, 8, this.getStrShelfLifeUnit());
			dao.setQryValue(nQueryIndex, 9, this.getStrInventoryUnitId());
			dao.setQryValue(nQueryIndex, 10, this.getStrPurchasedLeadTime());
			dao.setQryValue(nQueryIndex, 11, this.getStrPurLeadTimeUnit());
			dao.setQryValue(nQueryIndex, 12, this.getStrApprovedType());
			dao.setQryValue(nQueryIndex, 13, this.getStrConsumableFlag());
			dao.setQryValue(nQueryIndex, 14, this.getStrSetSachetFlag());
			dao.setQryValue(nQueryIndex, 15, this.getStrIsNarcotic());
			dao.setQryValue(nQueryIndex, 16, this.getStrRemarks());
			dao.setQryValue(nQueryIndex, 17, this.getStrEffectiveFrom());
			dao.setQryValue(nQueryIndex, 18, this.getStrIsValid());
			dao.setQryValue(nQueryIndex, 19, this.getStrSeatId());
			dao.setQryValue(nQueryIndex, 20, this.getStrIssueType());
			dao.setQryValue(nQueryIndex, 21, this.strStockUpdate);
			dao.setQryValue(nQueryIndex, 22, strConsentReq);
			dao.setQryValue(nQueryIndex, 23, this.getStrItemId());
			dao.setQryValue(nQueryIndex, 24, this.getStrHospitalCode());

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
		strDefaultRate = "";
		strRateUnitId = "";
		strBatchNoReq = "";
		strExpiryDateReq = "";
		strShelfLifeUnit = "";
		strShelfLife = "";
		strInventoryUnitId = "";
		strPurchasedLeadTime = "";
		strPurLeadTimeUnit = "";
		strApprovedType = "";
		strIssueType = "";
		strConsumableFlag = "0";
		strSetSachetFlag = "";
		strIsNarcotic = "";

		strEffectiveFrom = "";
		strRemarks = "";
		strEntryDate = "";
		strLastModifiedDate = "";
		strSeatId = "";
		strLastModifiedSeatId = "";
		strIsValid = "";
		strHospitalCode = "";

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
	 * Gets the str item type id.
	 * 
	 * @return the str item type id
	 */
	public String getStrItemTypeId() {
		return strItemTypeId;
	}

	/**
	 * Sets the str item type id.
	 * 
	 * @param strItemTypeId the new str item type id
	 */
	public void setStrItemTypeId(String strItemTypeId) {
		this.strItemTypeId = strItemTypeId;
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
	 * Gets the str default rate.
	 * 
	 * @return the str default rate
	 */
	public String getStrDefaultRate() {
		return strDefaultRate;
	}

	/**
	 * Sets the str default rate.
	 * 
	 * @param strDefaultRate the new str default rate
	 */
	public void setStrDefaultRate(String strDefaultRate) {
		this.strDefaultRate = strDefaultRate;
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
	 * Gets the str approved type.
	 * 
	 * @return the str approved type
	 */
	public String getStrApprovedType() {
		return strApprovedType;
	}

	/**
	 * Sets the str approved type.
	 * 
	 * @param strApprovedType the new str approved type
	 */
	public void setStrApprovedType(String strApprovedType) {
		this.strApprovedType = strApprovedType;
	}

	/**
	 * Gets the str issue type.
	 * 
	 * @return the str issue type
	 */
	public String getStrIssueType() {
		return strIssueType;
	}

	/**
	 * Sets the str issue type.
	 * 
	 * @param strIssueType the new str issue type
	 */
	public void setStrIssueType(String strIssueType) {
		this.strIssueType = strIssueType;
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
	 * Gets the str set sachet flag.
	 * 
	 * @return the str set sachet flag
	 */
	public String getStrSetSachetFlag() {
		return strSetSachetFlag;
	}

	/**
	 * Sets the str set sachet flag.
	 * 
	 * @param strSetSachetFlag the new str set sachet flag
	 */
	public void setStrSetSachetFlag(String strSetSachetFlag) {
		this.strSetSachetFlag = strSetSachetFlag;
	}

	/**
	 * Gets the str is narcotic.
	 * 
	 * @return the str is narcotic
	 */
	public String getStrIsNarcotic() {
		return strIsNarcotic;
	}

	/**
	 * Sets the str is narcotic.
	 * 
	 * @param strIsNarcotic the new str is narcotic
	 */
	public void setStrIsNarcotic(String strIsNarcotic) {
		this.strIsNarcotic = strIsNarcotic;
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
	 * Sets the str consent req.
	 * 
	 * @param strConsentReq the strConsentReq to set
	 */
	public void setStrConsentReq(String strConsentReq) {
		this.strConsentReq = strConsentReq;
	}
}
