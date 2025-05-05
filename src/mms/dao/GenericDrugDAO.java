package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class GenericDrugDAO.
 */
public class GenericDrugDAO {

	/** The str proc name. */
	//private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.GenericDrugDAO";
	
	/** The str item id. */
	private String strItemId = "";
	
	/** The str group id. */
	private String strGroupId = "";
	
	/** The str sub group id. */
	private String strSubGroupId = "";
	
	/** The str item cat no. */
	private String strItemCatNO = "";
	// private String strItemTypeId = ""; //change on 13 may09 after changes in
	// table
	/** The str item name. */
	private String strItemName = "";
	// private String strDefaultRate = ""; //change on 13 may09 after changes in
	// table (by Anshul)
	// private String strRateUnitId = ""; //change on 13 may09 after changes in
	// table
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
	// private String strApprovedType = ""; //change on 13 may09 after changes
	// in table
	// private String strIssueType = ""; //change on 13 may09 after changes in
	// table
	/** The str consumable flag. */
	private String strConsumableFlag = "";
	// private String strSetSachetFlag = ""; //change on 13 may09 after changes
	// in table
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
	private String strCPACode="";
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
	
	private String strPregnancySafeFlag =null;
	private String strTrimester =null;
	private String strEffectsOnFoetus =null;
	private String strSerialNo="";
	
	private String strTariffId="";

	// private String strStockUpdate = ""; //change on 13 may09 after changes in
	// table

	/*
	 * public void setStrStockUpdate(String strStockUpdate) {
	 * this.strStockUpdate = strStockUpdate; }
	 */

	public void setStrSerialNo(String strSerialNo) {
		this.strSerialNo = strSerialNo;
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

			/*//System.out.println("---->"+this.getStrItemId());
			//System.out.println("---->"+this.getStrHospitalCode());
			//System.out.println("----->"+this.getStrGroupId());
			//System.out.println("----->"+this.getStrSubGroupId());
			//System.out.println("----->"+this.getStrItemCatNO());
			*/
			
			dao.setQryValue(nQueryIndex, 1, this.getStrItemId().equalsIgnoreCase("")?"0":getStrItemId());
			dao.setQryValue(nQueryIndex, 2, this.getStrHospitalCode().equalsIgnoreCase("")?"0":getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 3, this.getStrGroupId().equalsIgnoreCase("")?"0":getStrGroupId());
			dao.setQryValue(nQueryIndex, 4, this.getStrSubGroupId().equalsIgnoreCase("")?"0":getStrSubGroupId());
			dao.setQryValue(nQueryIndex, 5, this.getStrItemCatNO().equalsIgnoreCase("")?"0":getStrItemCatNO());
			// dao.setQryValue(nQueryIndex, 6, this.getStrItemTypeId());
			dao.setQryValue(nQueryIndex, 6, this.getStrItemName());
			// dao.setQryValue(nQueryIndex, 8, this.getStrDefaultRate());
			// dao.setQryValue(nQueryIndex, 9, this.getStrRateUnitId());
			dao.setQryValue(nQueryIndex, 7, this.getStrBatchNoReq().equalsIgnoreCase("")?"0":getStrBatchNoReq());
			dao.setQryValue(nQueryIndex, 8, this.getStrExpiryDateReq().equalsIgnoreCase("")?"0":getStrExpiryDateReq());
			dao.setQryValue(nQueryIndex, 9, this.getStrShelfLife().equalsIgnoreCase("")?"0":getStrShelfLife());
			dao.setQryValue(nQueryIndex, 10, this.getStrShelfLifeUnit().equalsIgnoreCase("")?"0":getStrShelfLifeUnit());
			dao.setQryValue(nQueryIndex, 11, this.getStrInventoryUnitId().equalsIgnoreCase("")?"0":getStrInventoryUnitId());
			dao.setQryValue(nQueryIndex, 12, this.getStrPurchasedLeadTime().equalsIgnoreCase("")?"0":getStrPurchasedLeadTime());
			dao.setQryValue(nQueryIndex, 13, this.getStrPurLeadTimeUnit().equalsIgnoreCase("")?"0":getStrPurLeadTimeUnit());
			// dao.setQryValue(nQueryIndex, 14, this.getStrApprovedType());
			// dao.setQryValue(nQueryIndex, 18, this.getStrIssueType());
			dao.setQryValue(nQueryIndex, 14, this.getStrConsumableFlag().equalsIgnoreCase("")?"0":getStrConsumableFlag());
			// dao.setQryValue(nQueryIndex, 20, this.getStrSetSachetFlag());
			dao.setQryValue(nQueryIndex, 15, this.getStrIsNarcotic().equalsIgnoreCase("")?"0":getStrIsNarcotic());
			dao.setQryValue(nQueryIndex, 16, this.getStrRemarks());
			dao.setQryValue(nQueryIndex, 17, this.getStrEffectiveFrom());
			dao.setQryValue(nQueryIndex, 18, this.getStrSeatId().equalsIgnoreCase("")?"0":getStrSeatId());
			dao.setQryValue(nQueryIndex, 19, this.getStrIsValid().equalsIgnoreCase("")?"0":getStrIsValid());
			// dao.setQryValue(nQueryIndex, 26, this.strStockUpdate);
			dao.setQryValue(nQueryIndex, 20, strConsentReq.equalsIgnoreCase("")?"0":strConsentReq);
			dao.setQryValue(nQueryIndex, 21, strCPACode.equalsIgnoreCase("")?"0":strCPACode);
			
			/* Aritra */
			dao.setQryValue(nQueryIndex, 22, strPregnancySafeFlag.equalsIgnoreCase("")?"0":strPregnancySafeFlag );
			dao.setQryValue(nQueryIndex, 23, strTrimester.equalsIgnoreCase("")?"0":strTrimester);
			dao.setQryValue(nQueryIndex, 24, strEffectsOnFoetus.equalsIgnoreCase("")?"0":strEffectsOnFoetus);
			
			dao.execute(nQueryIndex, 0);
			nRowInserted++;
			// // //System.out.println(" nRowInserted++;"+ nRowInserted);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void insert2(HisDAO dao) {
		String strQuery = "";
		int nQueryIndex = 0;
		
		try {

			strQuery = mms.qryHandler_mms.getQuery(1, "insert.drug.billing");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, this.getStrTariffId().equalsIgnoreCase("")?"0":getStrTariffId());
			dao.setQryValue(nQueryIndex, 2, this.getStrTariffId().equalsIgnoreCase("")?"0":getStrTariffId());
			dao.setQryValue(nQueryIndex, 3, this.getStrItemName().equalsIgnoreCase("")?"0":getStrItemName());
			dao.setQryValue(nQueryIndex, 4, this.getStrItemId().equalsIgnoreCase("")?"0":getStrItemId());
			dao.setQryValue(nQueryIndex, 5, this.getStrSeatId().equalsIgnoreCase("")?"0":getStrSeatId());
			dao.setQryValue(nQueryIndex, 6, this.strCPACode.equalsIgnoreCase("")?"0":strCPACode);
			
			dao.execute(nQueryIndex, 0);
			nRowInserted++;
			// // //System.out.println(" nRowInserted++;"+ nRowInserted);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Insert.
	 * 
	 * @param dao the dao
	 */
	public void insert1(HisDAO dao) {
		String strQuery = "";
		int nQueryIndex = 0;
		
		try {

			strQuery = mms.qryHandler_mms.getQuery(1, "insert.drug.a");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1,  getStrItemId().equalsIgnoreCase("")?"0":getStrItemId());
			dao.setQryValue(nQueryIndex, 2,  getStrHospitalCode().equalsIgnoreCase("")?"0":getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 3,  getStrGroupId().equalsIgnoreCase("")?"0":getStrGroupId());
			dao.setQryValue(nQueryIndex, 4,  getStrSubGroupId().equalsIgnoreCase("")?"0":getStrSubGroupId());
			dao.setQryValue(nQueryIndex, 5,  getStrItemCatNO().equalsIgnoreCase("")?"0":getStrItemCatNO());
			dao.setQryValue(nQueryIndex, 6,  getStrItemName().equalsIgnoreCase("")?"0":getStrItemName());
			dao.setQryValue(nQueryIndex, 7,  getStrBatchNoReq().equalsIgnoreCase("")?"0":getStrBatchNoReq());
			dao.setQryValue(nQueryIndex, 8,  getStrExpiryDateReq().equalsIgnoreCase("")?"0":getStrExpiryDateReq());
			dao.setQryValue(nQueryIndex, 9,  getStrShelfLife().equalsIgnoreCase("")?"0":getStrShelfLife());
			dao.setQryValue(nQueryIndex, 10, getStrShelfLifeUnit().equalsIgnoreCase("")?"0":getStrShelfLifeUnit());
			dao.setQryValue(nQueryIndex, 11, getStrInventoryUnitId().equalsIgnoreCase("")?"0":getStrInventoryUnitId());
			dao.setQryValue(nQueryIndex, 12, getStrPurchasedLeadTime().equalsIgnoreCase("")?"0":getStrPurchasedLeadTime());
			dao.setQryValue(nQueryIndex, 13, getStrPurLeadTimeUnit().equalsIgnoreCase("")?"0":getStrPurLeadTimeUnit());
			dao.setQryValue(nQueryIndex, 14, getStrConsumableFlag().equalsIgnoreCase("")?"0":getStrConsumableFlag());
			dao.setQryValue(nQueryIndex, 15, getStrIsNarcotic().equalsIgnoreCase("")?"0":getStrIsNarcotic());
			dao.setQryValue(nQueryIndex, 16, getStrRemarks());
			dao.setQryValue(nQueryIndex, 17, getStrEffectiveFrom());
			dao.setQryValue(nQueryIndex, 18, getStrSeatId().equalsIgnoreCase("")?"0":getStrSeatId());
			dao.setQryValue(nQueryIndex, 19, getStrIsValid().equalsIgnoreCase("")?"0":getStrIsValid());
			dao.setQryValue(nQueryIndex, 20, strConsentReq.equalsIgnoreCase("")?"0":strConsentReq);
			dao.setQryValue(nQueryIndex, 21, strCPACode.equalsIgnoreCase("")?"0":strCPACode);
			dao.setQryValue(nQueryIndex, 22, strPregnancySafeFlag.equalsIgnoreCase("")?"0":strPregnancySafeFlag);
			dao.setQryValue(nQueryIndex, 23, strTrimester.equalsIgnoreCase("")?"0":strTrimester );
			dao.setQryValue(nQueryIndex, 24, strEffectsOnFoetus.equalsIgnoreCase("")?"0":strEffectsOnFoetus);
			dao.setQryValue(nQueryIndex, 25, getStrHospitalCode().equalsIgnoreCase("")?"0":getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 26, getStrItemId().equalsIgnoreCase("")?"0":getStrItemId());
			
			dao.execute(nQueryIndex, 0);
			nRowInserted++;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void insert3(HisDAO dao) {

		
		String strQuery1 = "";
		int nQueryIndex1 = 0;
		
		try {

			strQuery1 = mms.qryHandler_mms.getQuery(1, "modify.drug.billing");
			nQueryIndex1 = dao.setQuery(strQuery1);
			//System.out.println("Tariff id:::  "+(this.getStrItemId().equalsIgnoreCase("")?"0":getStrItemId()));
			//System.out.println("item name frm this:::  "+(this.getStrItemName().equalsIgnoreCase("")?"0":getStrItemName()));
			dao.setQryValue(nQueryIndex1, 1, this.getStrItemName().equalsIgnoreCase("")?"0":getStrItemName());
			dao.setQryValue(nQueryIndex1, 3, this.getStrTariffId().equalsIgnoreCase("")?"0":getStrTariffId());
			dao.setQryValue(nQueryIndex1, 2, this.getStrIsValid().equalsIgnoreCase("")?"0":getStrIsValid());
			dao.setQryValue(nQueryIndex1, 4, this.getStrTariffId().equalsIgnoreCase("")?"0":getStrTariffId());
			dao.execute(nQueryIndex1, 0);
			nRowInserted++;
			// // //System.out.println(" nRowInserted++;"+ nRowInserted);

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

			// //System.out.println("dao update");
			strQuery = mms.qryHandler_mms.getQuery(1, "update.drug.0");
			nQueryIndex = dao.setQuery(strQuery);
			// dao.setQryValue(nQueryIndex, 1, this.getStrItemTypeId());
			dao.setQryValue(nQueryIndex, 1, this.getStrItemName());
			// dao.setQryValue(nQueryIndex, 3, this.getStrDefaultRate());
			// //change on 13 may09 after changes in table
			// dao.setQryValue(nQueryIndex, 4, this.getStrRateUnitId());
			// //change on 13 may09 after changes in table
			dao.setQryValue(nQueryIndex, 2, this.getStrBatchNoReq().equalsIgnoreCase("")?"0":getStrBatchNoReq());
			dao.setQryValue(nQueryIndex, 3, this.getStrExpiryDateReq().equalsIgnoreCase("")?"0":getStrExpiryDateReq());
			dao.setQryValue(nQueryIndex, 4, this.getStrShelfLife().equalsIgnoreCase("")?"0":getStrShelfLife());
			dao.setQryValue(nQueryIndex, 5, this.getStrShelfLifeUnit().equalsIgnoreCase("")?"0":getStrShelfLifeUnit());
			//dao.setQryValue(nQueryIndex, 6, this.getStrInventoryUnitId());
			dao.setQryValue(nQueryIndex, 6, this.getStrPurchasedLeadTime().equalsIgnoreCase("")?"0":getStrPurchasedLeadTime());
			dao.setQryValue(nQueryIndex, 7, this.getStrPurLeadTimeUnit().equalsIgnoreCase("")?"0":getStrPurLeadTimeUnit());
			// dao.setQryValue(nQueryIndex, 12, this.getStrApprovedType());
			// //change on 13 may09 after changes in table
			dao.setQryValue(nQueryIndex, 8, this.getStrConsumableFlag().equalsIgnoreCase("")?"0":getStrConsumableFlag());
			// dao.setQryValue(nQueryIndex, 10, this.getStrSetSachetFlag());
			// //change on 13 may09 after changes in table
			dao.setQryValue(nQueryIndex, 9, this.getStrIsNarcotic().equalsIgnoreCase("")?"0":getStrIsNarcotic());
			dao.setQryValue(nQueryIndex, 10, this.getStrRemarks());
			dao.setQryValue(nQueryIndex, 11, this.getStrEffectiveFrom());
			dao.setQryValue(nQueryIndex, 12, this.getStrIsValid().equalsIgnoreCase("")?"0":getStrIsValid());
			dao.setQryValue(nQueryIndex, 13, this.getStrSeatId().equalsIgnoreCase("")?"0":getStrSeatId());
			// dao.setQryValue(nQueryIndex, 20, this.getStrIssueType());
			// //change on 13 may09 after changes in table
			// dao.setQryValue(nQueryIndex, 21, this.strStockUpdate); //change
			// on 13 may09 after changes in table
			dao.setQryValue(nQueryIndex, 14, strConsentReq.equalsIgnoreCase("")?"0":strConsentReq);
			dao.setQryValue(nQueryIndex, 15, strCPACode.equalsIgnoreCase("")?"0":strCPACode);
			
			/*Aritra*/
			dao.setQryValue(nQueryIndex, 16, strPregnancySafeFlag.equalsIgnoreCase("")?"0":strPregnancySafeFlag);
			dao.setQryValue(nQueryIndex, 17, strTrimester.equalsIgnoreCase("")?"0":strTrimester );
			dao.setQryValue(nQueryIndex, 18, strEffectsOnFoetus.equalsIgnoreCase("")?"0":strEffectsOnFoetus );
			
			dao.setQryValue(nQueryIndex, 19, this.getStrItemId().equalsIgnoreCase("")?"0":getStrItemId());
			dao.setQryValue(nQueryIndex, 20, this.getStrHospitalCode().equalsIgnoreCase("")?"0":getStrHospitalCode());
			
			

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
	public void update1(HisDAO dao) {
		String strQuery = "";
		int nQueryIndex = 0;
		try {

			// //System.out.println("dao update");
			strQuery = mms.qryHandler_mms.getQuery(1, "update.drug.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, getStrSeatId().equalsIgnoreCase("")?"0":getStrSeatId());			
			dao.setQryValue(nQueryIndex, 2, getStrItemId().equalsIgnoreCase("")?"0":getStrItemId());
			dao.setQryValue(nQueryIndex, 3, getStrHospitalCode().equalsIgnoreCase("")?"0":getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 4, strSerialNo.equalsIgnoreCase("")?"0":strSerialNo);
			dao.execute(nQueryIndex, 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public void update2(HisDAO dao) {
		String strQuery1 = "";
		int nQueryIndex1 = 0;
		try {
			strQuery1 = mms.qryHandler_mms.getQuery(1, "update.drug.billing");
			nQueryIndex1 = dao.setQuery(strQuery1);
			dao.setQryValue(nQueryIndex1, 1, getStrItemName().equalsIgnoreCase("")?"0":getStrItemName());
			dao.setQryValue(nQueryIndex1, 2, getStrIsValid().equalsIgnoreCase("")?"0":getStrIsValid());
			dao.setQryValue(nQueryIndex1, 3, getStrSeatId().equalsIgnoreCase("")?"0":getStrSeatId());		
			dao.setQryValue(nQueryIndex1, 4, getStrItemId().equalsIgnoreCase("")?"0":getStrItemId());
			dao.execute(nQueryIndex1, 0);
			
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

	/*
	 * public String getStrItemTypeId() { return strItemTypeId; }
	 * 
	 * public void setStrItemTypeId(String strItemTypeId) { this.strItemTypeId =
	 * strItemTypeId; }
	 */

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

	/*
	 * public String getStrDefaultRate() { return strDefaultRate; }
	 * 
	 * public void setStrDefaultRate(String strDefaultRate) {
	 * this.strDefaultRate = strDefaultRate; }
	 * 
	 * public String getStrRateUnitId() { return strRateUnitId; }
	 * 
	 * public void setStrRateUnitId(String strRateUnitId) { this.strRateUnitId =
	 * strRateUnitId; }
	 */

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

	/*
	 * public String getStrApprovedType() { return strApprovedType; }
	 * 
	 * public void setStrApprovedType(String strApprovedType) {
	 * this.strApprovedType = strApprovedType; }
	 * 
	 * public String getStrIssueType() { return strIssueType; }
	 * 
	 * public void setStrIssueType(String strIssueType) { this.strIssueType =
	 * strIssueType; }
	 */

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

	/*
	 * public String getStrSetSachetFlag() { return strSetSachetFlag; }
	 * 
	 * public void setStrSetSachetFlag(String strSetSachetFlag) {
	 * this.strSetSachetFlag = strSetSachetFlag; }
	 */

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

	/**
	 * @param strCPACode the strCPACode to set
	 */
	public void setStrCPACode(String strCPACode) {
		this.strCPACode = strCPACode;
	}

	public String getStrPregnancySafeFlag() {
		return strPregnancySafeFlag;
	}

	public void setStrPregnancySafeFlag(String strPregnancySafeFlag) {
		this.strPregnancySafeFlag = strPregnancySafeFlag;
	}

	public String getStrTrimester() {
		return strTrimester;
	}

	public void setStrTrimester(String strTrimester) {
		this.strTrimester = strTrimester;
	}

	public String getStrEffectsOnFoetus() {
		return strEffectsOnFoetus;
	}

	public void setStrEffectsOnFoetus(String strEffectsOnFoetus) {
		this.strEffectsOnFoetus = strEffectsOnFoetus;
	}

	public String getStrTariffId() {
		return strTariffId;
	}

	public void setStrTariffId(String strTariffId) {
		this.strTariffId = strTariffId;
	}
}
