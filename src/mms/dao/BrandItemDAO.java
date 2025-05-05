package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class BrandItemDAO.
 */
public class BrandItemDAO {

	/** The str proc name. */
	//private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.BrandItemDAO";
	
	/** The str item id. */
	private String strItemId = "";
	
	/** The str item cat no. */
	private String strItemCatNO = "";

	/** The str item name. */
	private String strItemName = "";
	
	/** The str default rate. */
	private String strDefaultRate = "";
	
	/** The str rate unit id. */
	private String strRateUnitId = "";

	/** The str approved type. */
	private String strApprovedType = "";

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
	
	/** The str item brand id. */
	private String strItemBrandId = "";
	
	/** The str item brand sl no. */
	private String strItemBrandSlNo = "";
	
	/** The str manu facturer id. */
	private String strManuFacturerId = "";
	
	/** The str issuse type. */
	private String strIssuseType = "";
	
	/** The str item make. */
	private String strItemMake = "";
	// private String strItemStatus="";
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
			strQuery = mms.qryHandler_mms.getQuery(1, "insert.brandItem.1");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, this.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, this.getStrItemBrandSlNo());
			dao.setQryValue(nQueryIndex, 3, this.getStrItemId());
			dao.setQryValue(nQueryIndex, 4, this.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 5, this.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 6, this.getStrItemId());
			dao.setQryValue(nQueryIndex, 7, this.getStrItemBrandId());
			dao.setQryValue(nQueryIndex, 8, this.getStrItemCatNO());
			dao.setQryValue(nQueryIndex, 9, this.getStrItemName());
			dao.setQryValue(nQueryIndex, 10, this.getStrManuFacturerId());
			dao.setQryValue(nQueryIndex, 11, this.getStrDefaultRate());
			dao.setQryValue(nQueryIndex, 12, this.getStrRateUnitId());
			dao.setQryValue(nQueryIndex, 13, this.getStrApprovedType());
			dao.setQryValue(nQueryIndex, 14, this.getStrIssuseType());
			dao.setQryValue(nQueryIndex, 15, this.getStrItemMake());
			// dao.setQryValue(nQueryIndex, 16, this.getStrItemStatus());
			dao.setQryValue(nQueryIndex, 16, this.getStrRemarks());
			dao.setQryValue(nQueryIndex, 17, this.getStrEffectiveFrom());
			dao.setQryValue(nQueryIndex, 18, this.getStrSeatId());
			dao.setQryValue(nQueryIndex, 19, this.getStrIsValid());
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
	public void update(HisDAO dao) {
		String strQuery = "";
		int nQueryIndex = 0;
		try {

			strQuery = mms.qryHandler_mms.getQuery(1, "update.brandItem.0");
			nQueryIndex = dao.setQuery(strQuery);
			// //System.out.println("strQuery"+strQuery);
			dao.setQryValue(nQueryIndex, 1, this.getStrSeatId());
			dao.setQryValue(nQueryIndex, 2, this.getStrItemBrandId());
			dao.setQryValue(nQueryIndex, 3, this.getStrHospitalCode());
			dao.execute(nQueryIndex, 0);
			nRowUpdated++;

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Delete.
	 * 
	 * @param dao the dao
	 */
	public void delete(HisDAO dao) {
		String strQuery = "";
		int nQueryIndex = 0;
		try {
			strQuery = mms.qryHandler_mms.getQuery(1, "delete.brandItem.0");
			nQueryIndex = dao.setQuery(strQuery);
			// //System.out.println("data1"+ this.getStrSeatId());
			// //System.out.println("data2"+this.getStrItemBrandId());
			// //System.out.println("data3"+this.getStrHospitalCode());
			// //System.out.println("data4"+this.getStrItemBrandSlNo());
			dao.setQryValue(nQueryIndex, 1, this.getStrSeatId());
			dao.setQryValue(nQueryIndex, 2, this.getStrItemBrandId());
			dao.setQryValue(nQueryIndex, 3, this.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 4, this.getStrItemBrandSlNo());
			dao.execute(nQueryIndex, 0);
			nRowUpdated++;
			// //System.out.println("BrandItemDaoDelte"+nRowUpdated);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Modify.
	 * 
	 * @param dao the dao
	 */
	public void modify(HisDAO dao) {
		String strQuery = "";
		int nQueryIndex = 0;
		try {
			strQuery = mms.qryHandler_mms.getQuery(1, "update.brandItem.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, this.getStrSeatId());
			dao.setQryValue(nQueryIndex, 2, this.getStrItemBrandId());
			dao.setQryValue(nQueryIndex, 3, this.getStrHospitalCode());
			dao.execute(nQueryIndex, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Modify insert.
	 * 
	 * @param dao the dao
	 */
	public void modifyInsert(HisDAO dao) {
		String strQuery = "";
		int nQueryIndex = 0;
		try {
			strQuery = mms.qryHandler_mms.getQuery(1, "insert.brandItem.1");
			nQueryIndex = dao.setQuery(strQuery);

			// //System.out.println("HospCode---->"+this.getStrHospitalCode());
			// //System.out.println("strQuery---->"+strItemBrandSlNo);
			// //System.out.println("ItemId---->"+strItemId);
			// //System.out.println("ItemBrandId---->"+strItemBrandId);
			// //System.out.println("ItemBrandCatNo---->"+strItemCatNO);
			// //System.out.println("ItemName---->"+strItemName);
			// //System.out.println("manufactureId---->"+strManuFacturerId);
			// //System.out.println("DefaultRate---->"+strDefaultRate);
			// //System.out.println("Unit---->"+strRateUnitId);
			// //System.out.println("Approved---->"+strApprovedType);
			// //System.out.println("IssueType---->"+strIssuseType);
			// //System.out.println("ItemMaker---->"+strItemMake);
			// //System.out.println("ItemStatus---->"+strItemStatus);
			// //System.out.println("Remakrks---->"+strRemarks);
			// //System.out.println("Effective From---->"+strEffectiveFrom);
			// //System.out.println("Seat Id---->"+strSeatId);
			// //System.out.println("strIsValid---->"+strIsValid);
			// //System.out.println("strQuery---->"+);
			// //System.out.println("strQuery---->"+strQuery);
			dao.setQryValue(nQueryIndex, 1, this.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, this.getStrItemCatNO());
			dao.setQryValue(nQueryIndex, 3, this.getStrItemId());
			dao.setQryValue(nQueryIndex, 4, this.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 5, this.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 6, this.getStrItemId());
			dao.setQryValue(nQueryIndex, 7, this.getStrItemBrandId());
			dao.setQryValue(nQueryIndex, 8, this.getStrItemCatNO());
			dao.setQryValue(nQueryIndex, 9, this.getStrItemName());
			dao.setQryValue(nQueryIndex, 10, this.getStrManuFacturerId());
			dao.setQryValue(nQueryIndex, 11, this.getStrDefaultRate());
			dao.setQryValue(nQueryIndex, 12, this.getStrRateUnitId());
			dao.setQryValue(nQueryIndex, 13, this.getStrApprovedType());
			dao.setQryValue(nQueryIndex, 14, this.getStrIssuseType());
			dao.setQryValue(nQueryIndex, 15, this.getStrItemMake());
			// dao.setQryValue(nQueryIndex, 16, this.getStrItemStatus());
			dao.setQryValue(nQueryIndex, 16, this.getStrRemarks());
			dao.setQryValue(nQueryIndex, 17, this.getStrEffectiveFrom());
			dao.setQryValue(nQueryIndex, 18, this.getStrSeatId());
			dao.setQryValue(nQueryIndex, 19, this.getStrIsValid());
			dao.execute(nQueryIndex, 0);
			nRowInserted++;
			// dao.execute(nQueryIndex, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reset.
	 */
	public void reset() {

		strItemId = "0";

		strItemCatNO = "0";
		strItemName = "";
		strDefaultRate = "";
		strRateUnitId = "";

		strApprovedType = "";

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
	 * Gets the str item brand sl no.
	 * 
	 * @return the str item brand sl no
	 */
	public String getStrItemBrandSlNo() {
		return strItemBrandSlNo;
	}

	/**
	 * Sets the str item brand sl no.
	 * 
	 * @param strItemBrandSlNo the new str item brand sl no
	 */
	public void setStrItemBrandSlNo(String strItemBrandSlNo) {
		this.strItemBrandSlNo = strItemBrandSlNo;
	}

	/**
	 * Gets the str manu facturer id.
	 * 
	 * @return the str manu facturer id
	 */
	public String getStrManuFacturerId() {
		return strManuFacturerId;
	}

	/**
	 * Sets the str manu facturer id.
	 * 
	 * @param strManuFacturerId the new str manu facturer id
	 */
	public void setStrManuFacturerId(String strManuFacturerId) {
		this.strManuFacturerId = strManuFacturerId;
	}

	/**
	 * Gets the str item make.
	 * 
	 * @return the str item make
	 */
	public String getStrItemMake() {
		return strItemMake;
	}

	/**
	 * Sets the str item make.
	 * 
	 * @param strItemMake the new str item make
	 */
	public void setStrItemMake(String strItemMake) {
		this.strItemMake = strItemMake;
	}

	/*
	 * public String getStrItemStatus() { return strItemStatus; }
	 * 
	 * 
	 * public void setStrItemStatus(String strItemStatus) { this.strItemStatus =
	 * strItemStatus; }
	 * 
	 */
	/**
	 * Gets the str issuse type.
	 * 
	 * @return the str issuse type
	 */
	public String getStrIssuseType() {
		return strIssuseType;
	}

	/**
	 * Sets the str issuse type.
	 * 
	 * @param strIssuseType the new str issuse type
	 */
	public void setStrIssuseType(String strIssuseType) {
		this.strIssuseType = strIssuseType;
	}
}
