package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemDAO.
 */
public class ItemDAO {

	/** The str proc name. */
	//private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.ItemDAO";

	/** The str item brand id. */
	private String strItemBrandId = "";
	
	/** The str item id. */
	private String strItemId = "";
	
	private String strItemCode = "";
	
	/** The str gen item id. */
	private String strGenItemId = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str item cat no. */
	private String strItemCatNO = "";
	
	/** The str group id. */
	private String strGroupId = "";
	
	private String strTariffId="";
	
	public String getStrTariffId() {
		return strTariffId;
	}

	public void setStrTariffId(String strTariffId) {
		this.strTariffId = strTariffId;
	}

	/** The str item name. */
	private String strItemName = "";
	
	/** The str default rate. */
	private String strDefaultRate = "";
	
	/** The str rate unit id. */
	private String strRateUnitId = "";
	
	/** The str manufacturer id. */
	private String strManufacturerId = "";
	
	/** The str approved type. */
	private String strApprovedType = "";
	
	/** The str issue type. */
	private String strIssueType = "";
	
	/** The str specification. */
	private String strSpecification = "";
	
	/** The str item make. */
	private String strItemMake = "";
	
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
	
	/** The str set sachet flag. */
	private String strSetSachetFlag = "";
	
	/** The str spare part flag. */
	private String strSparePartFlag = "";
	
	/** The str is quantified. */
	private String strIsQuantified = "";
	
	/** The str item type id. */
	private String strItemTypeId = "";
	
	private String strItemReservedFlag = "";
	
	private String strUploadFileId;
	
	private String strUploadFileName;
	
	private String strSterilizationFlag;
	private String strSterilizationLife;
	private String strSerialNo;
	
	private String strItemClass="";
	private String strBatchnoReq="";
	private String strExpiryDateReq="";
	private String strManufDate="";
	private String strIsMisc;
	
	
	private String TEMP_SENS_FLAG="";
	private String MIN_VALUE="";
	private String MAX_VALUE ="";
	
	public String getMAX_VALUE() {
		return MAX_VALUE;
	}

	public void setMAX_VALUE(String mAX_VALUE) {
		this.MAX_VALUE = mAX_VALUE;
	}

	public String getMIN_VALUE() {
		return MIN_VALUE;
	}

	public void setMIN_VALUE(String mIN_VALUE) {
		this.MIN_VALUE = mIN_VALUE;
	}

	public String getTEMP_SENS_FLAG() {
		return TEMP_SENS_FLAG;
	}

	public void setTEMP_SENS_FLAG(String tEMP_SENS_FLAG) {
		this.TEMP_SENS_FLAG = tEMP_SENS_FLAG;
	}
	

	public String getStrIsMisc() {
		return strIsMisc;
	}

	public void setStrIsMisc(String strIsMisc) {
		this.strIsMisc = strIsMisc;
	}
	public String getStrManufDate() {
		return strManufDate;
	}

	public void setStrManufDate(String strManufDate) {
		this.strManufDate = strManufDate;
	}

	private String strConsumableType="";
	
	
	
	

	

	public String getStrConsumableType() {
		return strConsumableType;
	}

	public void setStrConsumableType(String strConsumableType) {
		this.strConsumableType = strConsumableType;
	}

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
	
	private String strHSNCode = ""; 
	public String getStrHSNCode() {
		return strHSNCode;
	}

	public void setStrHSNCode(String strHSNCode) {
		this.strHSNCode = strHSNCode;
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
	
	
	

	public String getStrItemClass() {
		return strItemClass;
	}

	public void setStrItemClass(String strItemClass) {
		this.strItemClass = strItemClass;
	}

	public String getStrBatchnoReq() {
		return strBatchnoReq;
	}

	public void setStrBatchnoReq(String strBatchnoReq) {
		this.strBatchnoReq = strBatchnoReq;
	}

	public String getStrExpiryDateReq() {
		return strExpiryDateReq;
	}

	public void setStrExpiryDateReq(String strExpiryDateReq) {
		this.strExpiryDateReq = strExpiryDateReq;
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

			strQuery = mms.qryHandler_mms.getQuery(1, "insert.itemBrandMst.0");
			nQueryIndex = dao.setQuery(strQuery);

			
			System.out.println(" getStrItemBrandId -->>"+this.getStrItemBrandId());
			System.out.println(" getStrGenItemId -->>"+this.getStrGenItemId());
			System.out.println(" getStrHospitalCode -->>"+this.getStrHospitalCode());
			System.out.println(" getStrItemCatNO -->>"+this.getStrItemCatNO());
		System.out.println(" getStrItemTypeId-->>"+this.getStrItemTypeId());
		System.out.println(" getStrItemName -->>"+this.getStrItemName());
			System.out.println(" getStrManufacturerId -->>"+this.getStrManufacturerId());	
			System.out.println(" getStrDefaultRate -->>"+this.getStrDefaultRate());
			System.out.println(" getStrRateUnitId -->>"+this.getStrRateUnitId());
			System.out.println(" getStrApprovedType -->>"+this.getStrApprovedType());
			System.out.println(" getStrIssueType -->>"+this.getStrIssueType());
		System.out.println(" getStrItemMake -->>"+this.getStrItemMake());
			System.out.println(" getStrSparePartFlag -->>"+this.getStrSparePartFlag());
		System.out.println(" getStrSetSachetFlag -->>"+this.getStrSetSachetFlag());
			System.out.println(" getStrIsQuantified -->>"+this.getStrIsQuantified());
			System.out.println(" getStrSeatId -->>"+this.getStrSeatId());
			System.out.println(" getStrIsValid -->>"+this.getStrIsValid());
			System.out.println(" getStrSpecification -->>"+this.getStrSpecification());
			System.out.println(" getStrEffectiveFrom -->>"+this.getStrEffectiveFrom());
			System.out.println(" getStrItemReservedFlag -->>"+this.getStrItemReservedFlag());
			System.out.println(" getStrItemCode -->>"+this.getStrItemCode());			
			System.out.println(" getStrUploadFileId -->>"+this.getStrUploadFileId());
			System.out.println(" getStrUploadFileName -->>"+this.getStrUploadFileName());		
			System.out.println(" getStrSterilizationFlag -->>"+this.getStrSterilizationFlag());
			System.out.println(" getStrSterilizationLife -->>"+this.getStrSterilizationLife());
			System.out.println(" getStrManufDate -->>"+this.getStrManufDate());
			
			
			System.out.println(" getMAX_VALUE -->>"+this.getMAX_VALUE());
			System.out.println(" getMIN_VALUE -->>"+this.getMIN_VALUE());
			System.out.println(" getTEMP_SENS_FLAG -->>"+this.getTEMP_SENS_FLAG());
			
			
			dao.setQryValue(nQueryIndex, 1, this.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, this.getStrItemCatNO());
			dao.setQryValue(nQueryIndex, 3, this.getStrGenItemId());
			dao.setQryValue(nQueryIndex, 4, this.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 5, this.getStrItemCatNO());
			dao.setQryValue(nQueryIndex, 6, this.getStrItemTypeId());
			dao.setQryValue(nQueryIndex, 7, this.getStrItemName());
			dao.setQryValue(nQueryIndex, 8, this.getStrManufacturerId());
			dao.setQryValue(nQueryIndex, 9, this.getStrDefaultRate());
			dao.setQryValue(nQueryIndex, 10, this.getStrRateUnitId());
			dao.setQryValue(nQueryIndex, 11, this.getStrApprovedType());
			dao.setQryValue(nQueryIndex, 12, this.getStrIssueType());
			dao.setQryValue(nQueryIndex, 13, this.getStrItemMake());
			dao.setQryValue(nQueryIndex, 14, this.getStrSparePartFlag());
			dao.setQryValue(nQueryIndex, 15, this.getStrSetSachetFlag());
			dao.setQryValue(nQueryIndex, 16, this.getStrIsQuantified());

			dao.setQryValue(nQueryIndex, 17, this.getStrSeatId());
			dao.setQryValue(nQueryIndex, 18, this.getStrIsValid());
			dao.setQryValue(nQueryIndex, 19, this.getStrSpecification());
			dao.setQryValue(nQueryIndex, 20, this.getStrEffectiveFrom());
			dao.setQryValue(nQueryIndex, 21, this.getStrItemReservedFlag());
			dao.setQryValue(nQueryIndex, 22, this.getStrItemCode());
			
			dao.setQryValue(nQueryIndex, 23, this.getStrUploadFileId());
			dao.setQryValue(nQueryIndex, 24, this.getStrUploadFileName());
		
			dao.setQryValue(nQueryIndex, 25, this.getStrSterilizationFlag());
			dao.setQryValue(nQueryIndex, 26, this.getStrSterilizationLife().equalsIgnoreCase("")?"0":getStrSterilizationLife());
			
			dao.setQryValue(nQueryIndex, 27, this.getStrItemClass());
			dao.setQryValue(nQueryIndex, 28, this.getStrBatchnoReq().equalsIgnoreCase("")?"0":this.getStrBatchnoReq());
			dao.setQryValue(nQueryIndex, 29, this.getStrExpiryDateReq().equalsIgnoreCase("")?"0":this.getStrExpiryDateReq());
			dao.setQryValue(nQueryIndex, 30, this.getStrConsumableType());
			dao.setQryValue(nQueryIndex, 31, this.getStrHSNCode());		
			dao.setQryValue(nQueryIndex, 32, this.getStrManufDate().equalsIgnoreCase("")?"0":this.getStrManufDate());
			dao.setQryValue(nQueryIndex, 33, this.getStrIsMisc().equalsIgnoreCase("")?"0":this.getStrIsMisc());
			
			dao.setQryValue(nQueryIndex, 34, this.getMAX_VALUE());		
			dao.setQryValue(nQueryIndex, 35, this.getMIN_VALUE());
			dao.setQryValue(nQueryIndex, 36, this.getTEMP_SENS_FLAG());
			
			
			dao.execute(nQueryIndex, 0);
			nRowInserted++;
			System.out.println("strQuery");
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
		try {

			strQuery = mms.qryHandler_mms.getQuery(1, "insert.itemBrandMst.a");
			nQueryIndex = dao.setQuery(strQuery);

//			System.out.println(" getStrItemBrandId -->>"+this.getStrItemBrandId());
//			System.out.println(" getStrGenItemId -->>"+this.getStrGenItemId());
//			System.out.println(" getStrHospitalCode -->>"+this.getStrHospitalCode());
//			System.out.println(" getStrItemCatNO -->>"+this.getStrItemCatNO());
//			System.out.println(" getStrItemTypeId-->>"+this.getStrItemTypeId());
//			System.out.println(" getStrItemName -->>"+this.getStrItemName());
//			System.out.println(" getStrManufacturerId -->>"+this.getStrManufacturerId());
//			System.out.println(" getStrDefaultRate -->>"+this.getStrDefaultRate());
//			System.out.println(" getStrRateUnitId -->>"+this.getStrRateUnitId());
//			System.out.println(" getStrApprovedType -->>"+this.getStrApprovedType());
//			System.out.println(" getStrIssueType -->>"+this.getStrIssueType());
//			System.out.println(" getStrItemMake -->>"+this.getStrItemMake());
//			System.out.println(" getStrSparePartFlag -->>"+this.getStrSparePartFlag());
//			System.out.println(" getStrSetSachetFlag -->>"+this.getStrSetSachetFlag());
//			System.out.println(" getStrIsQuantified -->>"+this.getStrIsQuantified());
//			System.out.println(" getStrSeatId -->>"+this.getStrSeatId());
//			System.out.println(" getStrIsValid -->>"+this.getStrIsValid());
//			System.out.println(" getStrSpecification -->>"+this.getStrSpecification());
//			System.out.println(" getStrEffectiveFrom -->>"+this.getStrEffectiveFrom());
//			System.out.println(" getStrItemReservedFlag -->>"+this.getStrItemReservedFlag());
//			System.out.println(" getStrItemCode -->>"+this.getStrItemCode());			
//			System.out.println(" getStrUploadFileId -->>"+this.getStrUploadFileId());
//			System.out.println(" getStrUploadFileName -->>"+this.getStrUploadFileName());		
//			System.out.println(" getStrSterilizationFlag -->>"+this.getStrSterilizationFlag());
//			System.out.println(" getStrSterilizationLife -->>"+this.getStrSterilizationLife());

			
			System.out.println(" getMAX_VALUE() -->>"+this.getMAX_VALUE());		
		System.out.println(" getgetMIN_VALUE() -->>"+this.getMIN_VALUE());
			System.out.println(" getgetTEMP_SENS_FLAG() -->>"+this.getTEMP_SENS_FLAG());
			
			
			dao.setQryValue(nQueryIndex, 1, this.getStrItemBrandId().equalsIgnoreCase("")?"0":this.getStrItemBrandId());
			dao.setQryValue(nQueryIndex, 2, this.getStrGenItemId());
			dao.setQryValue(nQueryIndex, 3, this.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 4, this.getStrItemCatNO());
			dao.setQryValue(nQueryIndex, 5, this.getStrItemTypeId());
			dao.setQryValue(nQueryIndex, 6, this.getStrItemName());
			dao.setQryValue(nQueryIndex, 7, this.getStrManufacturerId());
			dao.setQryValue(nQueryIndex, 8, this.getStrDefaultRate());
			dao.setQryValue(nQueryIndex, 9, this.getStrRateUnitId());
			dao.setQryValue(nQueryIndex, 10, this.getStrApprovedType());
			dao.setQryValue(nQueryIndex, 11, this.getStrIssueType());
			dao.setQryValue(nQueryIndex, 12, this.getStrItemMake());
			dao.setQryValue(nQueryIndex, 13, this.getStrSparePartFlag());
			dao.setQryValue(nQueryIndex, 14, this.getStrSetSachetFlag());
			dao.setQryValue(nQueryIndex, 15, this.getStrIsQuantified());
			dao.setQryValue(nQueryIndex, 16, this.getStrSeatId());
			dao.setQryValue(nQueryIndex, 17, this.getStrIsValid());
			dao.setQryValue(nQueryIndex, 18, this.getStrSpecification());
			//dao.setQryValue(nQueryIndex, 19, this.getStrEffectiveFrom());
			dao.setQryValue(nQueryIndex, 19, this.getStrItemReservedFlag());
			dao.setQryValue(nQueryIndex, 20, this.getStrItemCode().equalsIgnoreCase("")?"0":this.getStrItemCode());			
			dao.setQryValue(nQueryIndex, 21, this.getStrUploadFileId().equalsIgnoreCase("")?"0":this.getStrUploadFileId());
			dao.setQryValue(nQueryIndex, 22, this.getStrUploadFileName());		
			dao.setQryValue(nQueryIndex, 23, this.getStrSterilizationFlag());
			dao.setQryValue(nQueryIndex, 24, this.getStrSterilizationLife());
			
			dao.setQryValue(nQueryIndex, 25, this.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 26, this.getStrItemBrandId());
			
			dao.setQryValue(nQueryIndex, 27, this.getStrConsumableType());
			dao.setQryValue(nQueryIndex, 28, this.getStrBatchnoReq());
			dao.setQryValue(nQueryIndex, 29, this.getStrExpiryDateReq());
			dao.setQryValue(nQueryIndex, 30, this.getStrItemClass());
			dao.setQryValue(nQueryIndex, 31, this.getStrHSNCode());		
			dao.setQryValue(nQueryIndex, 32, this.getStrManufDate().equalsIgnoreCase("")?"0":this.getStrManufDate());
			
			dao.setQryValue(nQueryIndex, 33, this.getStrIsMisc());
			
			dao.setQryValue(nQueryIndex, 34, this.getMAX_VALUE());
			dao.setQryValue(nQueryIndex, 35, this.getMIN_VALUE());
			dao.setQryValue(nQueryIndex, 36, this.getTEMP_SENS_FLAG());
			
		
			
			dao.execute(nQueryIndex, 0);
			nRowInserted++;

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public void NewUpdate(HisDAO dao)
	{
		String strQuery = "";
		int nQueryIndex = 0;
		try {

			strQuery = mms.qryHandler_mms.getQuery(1, "insert.itemBrandMst.a");
			nQueryIndex = dao.setQuery(strQuery);

			System.out.println(" getStrItemBrandId -->>"+this.getStrItemBrandId());
			System.out.println(" getStrGenItemId -->>"+this.getStrGenItemId());
			System.out.println(" getStrHospitalCode -->>"+this.getStrHospitalCode());
			System.out.println(" getStrItemCatNO -->>"+this.getStrItemCatNO());
			System.out.println(" getStrItemTypeId-->>"+this.getStrItemTypeId());
			System.out.println(" getStrItemName -->>"+this.getStrItemName());
			System.out.println(" getStrManufacturerId -->>"+this.getStrManufacturerId());
			System.out.println(" getStrDefaultRate -->>"+this.getStrDefaultRate());
			System.out.println(" getStrRateUnitId -->>"+this.getStrRateUnitId());
			System.out.println(" getStrApprovedType -->>"+this.getStrApprovedType());
			System.out.println(" getStrIssueType -->>"+this.getStrIssueType());
			System.out.println(" getStrItemMake -->>"+this.getStrItemMake());
			System.out.println(" getStrSparePartFlag -->>"+this.getStrSparePartFlag());
			System.out.println(" getStrSetSachetFlag -->>"+this.getStrSetSachetFlag());
			System.out.println(" getStrIsQuantified -->>"+this.getStrIsQuantified());
			System.out.println(" getStrSeatId -->>"+this.getStrSeatId());
			System.out.println(" getStrIsValid -->>"+this.getStrIsValid());
			System.out.println(" getStrSpecification -->>"+this.getStrSpecification());
			System.out.println(" getStrEffectiveFrom -->>"+this.getStrEffectiveFrom());
			System.out.println(" getStrItemReservedFlag -->>"+this.getStrItemReservedFlag());
			System.out.println(" getStrItemCode -->>"+this.getStrItemCode());			
			System.out.println(" getStrUploadFileId -->>"+this.getStrUploadFileId());
			System.out.println(" getStrUploadFileName -->>"+this.getStrUploadFileName());		
			System.out.println(" getStrSterilizationFlag -->>"+this.getStrSterilizationFlag());
			System.out.println(" getStrSterilizationLife -->>"+this.getStrSterilizationLife());

			
			System.out.println(" getMAX_VALUE() -->>"+this.getMAX_VALUE());		
		    System.out.println(" getgetMIN_VALUE() -->>"+this.getMIN_VALUE());
			System.out.println(" getgetTEMP_SENS_FLAG() -->>"+this.getTEMP_SENS_FLAG());
			
			
			dao.setQryValue(nQueryIndex, 1, this.getStrItemBrandId().equalsIgnoreCase("")?"0":this.getStrItemBrandId());
			dao.setQryValue(nQueryIndex, 2, this.getStrGenItemId());
			dao.setQryValue(nQueryIndex, 3, this.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 4, this.getStrItemCatNO());
			dao.setQryValue(nQueryIndex, 5, this.getStrItemTypeId());
			dao.setQryValue(nQueryIndex, 6, this.getStrItemName());
			dao.setQryValue(nQueryIndex, 7, this.getStrManufacturerId());
			dao.setQryValue(nQueryIndex, 8, this.getStrDefaultRate());
			dao.setQryValue(nQueryIndex, 9, this.getStrRateUnitId());
			dao.setQryValue(nQueryIndex, 10, this.getStrApprovedType());
			dao.setQryValue(nQueryIndex, 11, this.getStrIssueType());
			dao.setQryValue(nQueryIndex, 12, this.getStrItemMake());
			dao.setQryValue(nQueryIndex, 13, this.getStrSparePartFlag());
			dao.setQryValue(nQueryIndex, 14, this.getStrSetSachetFlag());
			dao.setQryValue(nQueryIndex, 15, this.getStrIsQuantified());
			dao.setQryValue(nQueryIndex, 16, this.getStrSeatId());
			dao.setQryValue(nQueryIndex, 17, this.getStrIsValid());
			dao.setQryValue(nQueryIndex, 18, this.getStrSpecification());
			//dao.setQryValue(nQueryIndex, 19, this.getStrEffectiveFrom());
			dao.setQryValue(nQueryIndex, 19, this.getStrItemReservedFlag());
			dao.setQryValue(nQueryIndex, 20, this.getStrItemCode().equalsIgnoreCase("")?"0":this.getStrItemCode());			
			dao.setQryValue(nQueryIndex, 21, this.getStrUploadFileId().equalsIgnoreCase("")?"0":this.getStrUploadFileId());
			dao.setQryValue(nQueryIndex, 22, this.getStrUploadFileName());		
			dao.setQryValue(nQueryIndex, 23, this.getStrSterilizationFlag());
			dao.setQryValue(nQueryIndex, 24, this.getStrSterilizationLife());
			
			dao.setQryValue(nQueryIndex, 25, this.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 26, this.getStrItemBrandId());
			
			dao.setQryValue(nQueryIndex, 27, this.getStrConsumableType());
			dao.setQryValue(nQueryIndex, 28, this.getStrBatchnoReq());
			dao.setQryValue(nQueryIndex, 29, this.getStrExpiryDateReq());
			dao.setQryValue(nQueryIndex, 30, this.getStrItemClass());
			dao.setQryValue(nQueryIndex, 31, this.getStrHSNCode());		
			dao.setQryValue(nQueryIndex, 32, this.getStrManufDate().equalsIgnoreCase("")?"0":this.getStrManufDate());
			
			dao.setQryValue(nQueryIndex, 33, this.getStrIsMisc());
			
			dao.setQryValue(nQueryIndex, 34, this.getMAX_VALUE());
			dao.setQryValue(nQueryIndex, 35, this.getMIN_VALUE());
			dao.setQryValue(nQueryIndex, 36, this.getTEMP_SENS_FLAG());
			
		
			
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
		try 
		{

			// System.out.println("dao update");
			strQuery = mms.qryHandler_mms.getQuery(1, "update.itemBrandMst.a");
			nQueryIndex = dao.setQuery(strQuery);
//				System.out.println(" Serial No -->>"+getStrSerialNo());
//				System.out.println("  getStrItemBrandId-->>"+getStrItemBrandId());
			//dao.setQryValue(nQueryIndex, 1, getStrSeatId());			
			dao.setQryValue(nQueryIndex, 1, getStrItemBrandId());
			dao.setQryValue(nQueryIndex, 2, getStrHospitalCode());
			dao.setQryValue(nQueryIndex,3, getStrSerialNo());		
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
			strQuery = mms.qryHandler_mms.getQuery(1, "update.itemBrandMst.0");
			nQueryIndex = dao.setQuery(strQuery);

			/*
			 * System.out.println("vo.getStrItemTypeId"+
			 * this.getStrItemTypeId());
			 * 
			 * System.out.println("vo.getStrItemName"+ this.getStrItemName());
			 * System.out.println("vo.get"+ this.getStrManufacturerId());
			 * System.out.println("vo.get"+ this.getStrDefaultRate());
			 * System.out.println("vo.get"+ this.getStrRateUnitId());
			 * System.out.println("vo.get"+ this.getStrApprovedType());
			 * System.out.println("vo.get"+ this.getStrIssueType());
			 * System.out.println("vo.get"+ this.getStrItemMake());
			 * System.out.println("vo.get"+ this.getStrSparePartFlag());
			 * System.out.println("vo.get"+ this.getStrSetSachetFlag());
			 * System.out.println("vo.get"+ this.getStrIsQuantified());
			 * 
			 * System.out.println("vo.get"+ this.getStrLastModifiedSeatId());
			 * 
			 * System.out.println("vo.get"+ this.getStrSpecification());
			 * System.out.println("vo.get"+ this.getStrEffectiveFrom());
			 * System.out.println("vo.get"+ this.getStrIsValid());
			 * System.out.println("vo.getStrItemBrandId"+
			 * this.getStrItemBrandId());
			 * System.out.println("vo.getStrHospitalCode"+
			 * this.getStrHospitalCode());
			 */
			dao.setQryValue(nQueryIndex, 1, this.getStrItemTypeId());
			dao.setQryValue(nQueryIndex, 2, this.getStrItemName());
			dao.setQryValue(nQueryIndex, 3, this.getStrManufacturerId());
			dao.setQryValue(nQueryIndex, 4, this.getStrDefaultRate());
			dao.setQryValue(nQueryIndex, 5, this.getStrRateUnitId());
			dao.setQryValue(nQueryIndex, 6, this.getStrApprovedType());
			dao.setQryValue(nQueryIndex, 7, this.getStrIssueType());
			dao.setQryValue(nQueryIndex, 8, this.getStrItemMake());
			dao.setQryValue(nQueryIndex, 9, this.getStrSparePartFlag());
			dao.setQryValue(nQueryIndex, 10, this.getStrSetSachetFlag());
			dao.setQryValue(nQueryIndex, 11, this.getStrIsQuantified());

			dao.setQryValue(nQueryIndex, 12, this.getStrLastModifiedSeatId());

			dao.setQryValue(nQueryIndex, 13, this.getStrSpecification());
			dao.setQryValue(nQueryIndex, 14, this.getStrEffectiveFrom());
			dao.setQryValue(nQueryIndex, 15, this.getStrIsValid());
			dao.setQryValue(nQueryIndex, 16, this.getStrItemCode());
			
			
			dao.setQryValue(nQueryIndex, 17, this.getStrSterilizationFlag());
			dao.setQryValue(nQueryIndex, 18, this.getStrSterilizationLife());
			
			dao.setQryValue(nQueryIndex, 19, this.getStrUploadFileId());
			dao.setQryValue(nQueryIndex, 20, this.getStrUploadFileName());
			/*  Primary Key  */
			
			dao.setQryValue(nQueryIndex, 21, this.getStrItemBrandId());
			dao.setQryValue(nQueryIndex, 22, this.getStrHospitalCode());

			

			
			

			dao.execute(nQueryIndex, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Reset.
	 */
	public void reset() {
		strItemBrandId = "0";
		strItemId = "0";
		strHospitalCode = "";
		strItemCatNO = "";
		strGroupId = "0";
		strItemName = "";
		strDefaultRate = "";
		strRateUnitId = "";
		strManufacturerId = "";
		strApprovedType = "";
		strIssueType = "";
		strSpecification = "";
		strItemMake = "";
		strEffectiveFrom = "";
		strRemarks = "";
		strEntryDate = "";
		strLastModifiedDate = "";
		strSeatId = "";
		strLastModifiedSeatId = "";
		strIsValid = "1";
		strSetSachetFlag = "";
		strSparePartFlag = "";
		strIsQuantified = "";
		strItemTypeId = "";
		strItemClass="";
		strBatchnoReq="";
		strExpiryDateReq="";
		strConsumableType="";
		
		

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
	 * Gets the str specification.
	 * 
	 * @return the strSpecification
	 */
	public String getStrSpecification() {
		return strSpecification;
	}

	/**
	 * Sets the str specification.
	 * 
	 * @param strSpecification the strSpecification to set
	 */
	public void setStrSpecification(String strSpecification) {
		this.strSpecification = strSpecification;
	}

	/**
	 * Gets the str item make.
	 * 
	 * @return the strItemMake
	 */
	public String getStrItemMake() {
		return strItemMake;
	}

	/**
	 * Sets the str item make.
	 * 
	 * @param strItemMake the strItemMake to set
	 */
	public void setStrItemMake(String strItemMake) {
		this.strItemMake = strItemMake;
	}

	/**
	 * Gets the str spare part flag.
	 * 
	 * @return the strSparePartFlag
	 */
	public String getStrSparePartFlag() {
		return strSparePartFlag;
	}

	/**
	 * Sets the str spare part flag.
	 * 
	 * @param strSparePartFlag the strSparePartFlag to set
	 */
	public void setStrSparePartFlag(String strSparePartFlag) {
		this.strSparePartFlag = strSparePartFlag;
	}

	/**
	 * Gets the str is quantified.
	 * 
	 * @return the strIsQuantified
	 */
	public String getStrIsQuantified() {
		return strIsQuantified;
	}

	/**
	 * Sets the str is quantified.
	 * 
	 * @param strIsQuantified the strIsQuantified to set
	 */
	public void setStrIsQuantified(String strIsQuantified) {
		this.strIsQuantified = strIsQuantified;
	}

	/**
	 * Gets the str gen item id.
	 * 
	 * @return the strGenItemId
	 */
	public String getStrGenItemId() {
		return strGenItemId;
	}

	/**
	 * Sets the str gen item id.
	 * 
	 * @param strGenItemId the strGenItemId to set
	 */
	public void setStrGenItemId(String strGenItemId) {
		this.strGenItemId = strGenItemId;
	}

	public void setStrItemReservedFlag(String strItemReservedFlag) {
		this.strItemReservedFlag = strItemReservedFlag;
	}

	public String getStrItemReservedFlag() {
		return strItemReservedFlag;
	}

	/**
	 * @param strItemCode the strItemCode to set
	 */
	public void setStrItemCode(String strItemCode) {
		this.strItemCode = strItemCode;
	}

	/**
	 * @return the strItemCode
	 */
	public String getStrItemCode() {
		return strItemCode;
	}

	public String getStrUploadFileId() {
		return strUploadFileId;
	}

	public void setStrUploadFileId(String strUploadFileId) {
		this.strUploadFileId = strUploadFileId;
	}

	public String getStrUploadFileName() {
		return strUploadFileName;
	}

	public void setStrUploadFileName(String strUploadFileName) {
		this.strUploadFileName = strUploadFileName;
	}

	public String getStrSterilizationFlag() {
		return strSterilizationFlag;
	}

	public void setStrSterilizationFlag(String strSterilizationFlag) {
		this.strSterilizationFlag = strSterilizationFlag;
	}

	public String getStrSterilizationLife() {
		return strSterilizationLife;
	}

	public void setStrSterilizationLife(String strSterilizationLife) {
		this.strSterilizationLife = strSterilizationLife;
	}

	public String getStrSerialNo() {
		return strSerialNo;
	}

	public void setStrSerialNo(String strSerialNo) {
		this.strSerialNo = strSerialNo;
	}
	
	//FOr Billing 
		public void insert2(HisDAO dao) {
			String strQuery = "";
			int nQueryIndex = 0;
			
			try {

				strQuery = mms.qryHandler_mms.getQuery(1, "insert.drug.billing");
				nQueryIndex = dao.setQuery(strQuery);
				dao.setQryValue(nQueryIndex, 1, this.getStrTariffId().equalsIgnoreCase("")?"0":getStrTariffId());
				dao.setQryValue(nQueryIndex, 2, this.getStrTariffId().equalsIgnoreCase("")?"0":getStrTariffId());
				dao.setQryValue(nQueryIndex, 3, this.getStrItemName().equalsIgnoreCase("")?"0":getStrItemName());
				System.out.println(" this.getStrItemBrandId()****"+ this.getStrItemBrandId());
				dao.setQryValue(nQueryIndex, 4, this.getStrItemBrandId().equalsIgnoreCase("")?"0":getStrItemBrandId());
				dao.setQryValue(nQueryIndex, 5, this.getStrSeatId().equalsIgnoreCase("")?"0":getStrSeatId());
				dao.setQryValue(nQueryIndex, 6, "0");
				
				dao.execute(nQueryIndex, 0);
				nRowInserted++;
				// // System.out.println(" nRowInserted++;"+ nRowInserted);

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
					
				//System.out.println("getStrItemName()::::::::)"+getStrItemName());
				//System.out.println("getStrItemBrandId()::::::::)"+getStrItemBrandId());
				//dao.setQryValue(nQueryIndex1, 3, getStrHospitalCode().equalsIgnoreCase("")?"0":getStrHospitalCode());
				dao.setQryValue(nQueryIndex1, 1, getStrItemName().equalsIgnoreCase("")?"0":getStrItemName());
				dao.setQryValue(nQueryIndex1, 2, getStrIsValid().equalsIgnoreCase("")?"0":getStrIsValid());
				dao.setQryValue(nQueryIndex1, 3, getStrSeatId().equalsIgnoreCase("")?"0":getStrSeatId());		
				dao.setQryValue(nQueryIndex1, 4, getStrItemBrandId().equalsIgnoreCase("")?"0":getStrItemBrandId());
				//System.out.println("getStrSeatId()::::::::)"+getStrSeatId());
				
				//System.out.println("getStrIsValid()::::::::)"+getStrIsValid());
				
				
				dao.execute(nQueryIndex1, 0);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		public void insert3(HisDAO dao) {

			
			String strQuery1 = "";
			int nQueryIndex1 = 0;
			
			try {

				strQuery1 = mms.qryHandler_mms.getQuery(1, "update.drug.billing1");
				nQueryIndex1 = dao.setQuery(strQuery1);
				
				////System.out.println("Tariff id:::  "+(this.getStrTariffId().equalsIgnoreCase("")?"0":getStrTariffId()));
				////System.out.println("item name frm this:::  "+(this.getStrItemName().equalsIgnoreCase("")?"0":getStrItemName()));
				dao.setQryValue(nQueryIndex1, 1, this.getStrItemName().equalsIgnoreCase("")?"0":getStrItemName());
				//dao.setQryValue(nQueryIndex1, 3, this.getStrTariffId().equalsIgnoreCase("")?"0":getStrTariffId());
				dao.setQryValue(nQueryIndex1, 2, this.getStrIsValid().equalsIgnoreCase("")?"0":getStrIsValid());
				dao.setQryValue(nQueryIndex1, 3, this.getStrTariffId().equalsIgnoreCase("")?"0":getStrTariffId());
				dao.execute(nQueryIndex1, 0);
				nRowInserted++;
	            //System.out.println(" nRowInserted++;"+ this.getNRowInserted());

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

}
