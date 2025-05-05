package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc 
/**
 * The Class DrugBrandDAO.
 */
public class DrugBrandDAO {

	/** The str proc name. */
	private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.DrugBrandDAO";

	/** The str item brand id. */
	private String strItemBrandId = "";
	
	/** The str item id. */
	private String strItemId = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str item cat no. */
	private String strItemCatNo = "1";
	
	/** The str item name. */
	private String strItemName = "";
	
	/** The str manufacturer id. */
	private String strManufacturerId = "";
	
	/** The str default rate. */
	private String strDefaultRate = "";
	
	/** The str rate unit id. */
	private String strRateUnitId = "";
	
	/** The str approved type. */
	private String strApprovedType = "";
	
	/** The str issue type. */
	private String strIssueType = "";
	
	/** The str specification. */
	private String strSpecification = "";
	
	/** The str item make. */
	private String strItemMake = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str last modified seat id. */
	private String strLastModifiedSeatId = "";
	
	/** The str last modified date. */
	private String strLastModifiedDate = "";
	
	/** The str curr po no. */
	private String strCurrPONo = "";
	
	/** The str entry date. */
	private String strEntryDate = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str curr po date. */
	private String strCurrPODate = "";
	
	/** The str curr pur rate. */
	private String strCurrPurRate = "";
	
	/** The str is valid. */
	private String strIsValid = "1";
	
	/** The str curr pur rate unit id. */
	private String strCurrPurRateUnitId = "";
	
	/** The str curr supp id. */
	private String strCurrSuppId = "";
	
	/** The str last po no. */
	private String strLastPONo = "";
	
	/** The str last po date. */
	private String strLastPODate = "";
	
	/** The str last pur rate. */
	private String strLastPurRate = "";
	
	/** The str last pur rate unit id. */
	private String strLastPurRateUnitId = "";
	
	/** The str last rec qty. */
	private String strLastRecQty = "";
	
	/** The str last rec qty unit id. */
	private String strLastRecQtyUnitId = "";
	
	/** The str last supp id. */
	private String strLastSuppId = "";
	
	/** The str set sachet flag. */
	private String strSetSachetFlag = "";
	
	private String strConfigIssueRate;
	
	/** The str item type id. */
	private String strItemTypeId = "";
	
	/** The str is quantifiable. */
	private String strIsQuantifiable = "";
	
	
	private String strQCType;
	
	/** The str err. */
	private String strErr = "";
	
	private String strCPACode="";

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

	private String strItemReservedFlag = "";
	
	private String strMktRate="0";
	private String strMktRateUnitId;
	private String strSerialNo;
	private String strTariffId;
	
	private String strBatchnoReq="";
	private String strExpiryDateReq="";
	
	private String strDrugClass="";
	private String strGroupid="";
	private String strHSNCode="";
	private String strEdlCat="";
	private String strIsMisc;
	
	public String getStrIsMisc() {
		return strIsMisc;
	}

	public void setStrIsMisc(String strIsMisc) {
		this.strIsMisc = strIsMisc;
	}

	public String getStrEdlCat() {
		return strEdlCat;
	}

	public void setStrEdlCat(String strEdlCat) {
		this.strEdlCat = strEdlCat;
	}

	public String getStrGroupid() {
		return strGroupid;
	}

	public void setStrGroupid(String strGroupid) {
		this.strGroupid = strGroupid;
	}

	public String getStrDrugClass() {
		return strDrugClass;
	}

	public String getStrHSNCode() {
		return strHSNCode;
	}

	public void setStrHSNCode(String strHSNCode) {
		this.strHSNCode = strHSNCode;
	}

	public void setStrDrugClass(String strDrugClass) {
		this.strDrugClass = strDrugClass;
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

	public String getStrTariffId() {
		return strTariffId;
	}

	public void setStrTariffId(String strTariffId) {
		this.strTariffId = strTariffId;
	}

	public String getStrSerialNo() {
		return strSerialNo;
	}

	public void setStrSerialNo(String strSerialNo) {
		this.strSerialNo = strSerialNo;
	}

	public String getStrMktRate() {
		return strMktRate;
	}

	public void setStrMktRate(String strMktRate) {
		this.strMktRate = strMktRate;
	}

	public String getStrMktRateUnitId() {
		return strMktRateUnitId;
	}

	public void setStrMktRateUnitId(String strMktRateUnitId) {
		this.strMktRateUnitId = strMktRateUnitId;
	}

	public String getStrItemReservedFlag() {
		return strItemReservedFlag;
	}

	public void setStrItemReservedFlag(String strItemReservedFlag) {
		this.strItemReservedFlag = strItemReservedFlag;
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
	 * Gets the str specification.
	 * 
	 * @return the str specification
	 */
	public String getStrSpecification() {
		return strSpecification;
	}

	/**
	 * Sets the str specification.
	 * 
	 * @param strSpecification the new str specification
	 */
	public void setStrSpecification(String strSpecification) {
		this.strSpecification = strSpecification;
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
	 * Gets the str curr po no.
	 * 
	 * @return the str curr po no
	 */
	public String getStrCurrPONo() {
		return strCurrPONo;
	}

	/**
	 * Sets the str curr po no.
	 * 
	 * @param strCurrPONo the new str curr po no
	 */
	public void setStrCurrPONo(String strCurrPONo) {
		this.strCurrPONo = strCurrPONo;
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
	 * Gets the str curr po date.
	 * 
	 * @return the str curr po date
	 */
	public String getStrCurrPODate() {
		return strCurrPODate;
	}

	/**
	 * Sets the str curr po date.
	 * 
	 * @param strCurrPODate the new str curr po date
	 */
	public void setStrCurrPODate(String strCurrPODate) {
		this.strCurrPODate = strCurrPODate;
	}

	/**
	 * Gets the str curr pur rate.
	 * 
	 * @return the str curr pur rate
	 */
	public String getStrCurrPurRate() {
		return strCurrPurRate;
	}

	/**
	 * Sets the str curr pur rate.
	 * 
	 * @param strCurrPurRate the new str curr pur rate
	 */
	public void setStrCurrPurRate(String strCurrPurRate) {
		this.strCurrPurRate = strCurrPurRate;
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
	 * Gets the str curr pur rate unit id.
	 * 
	 * @return the str curr pur rate unit id
	 */
	public String getStrCurrPurRateUnitId() {
		return strCurrPurRateUnitId;
	}

	/**
	 * Sets the str curr pur rate unit id.
	 * 
	 * @param strCurrPurRateUnitId the new str curr pur rate unit id
	 */
	public void setStrCurrPurRateUnitId(String strCurrPurRateUnitId) {
		this.strCurrPurRateUnitId = strCurrPurRateUnitId;
	}

	/**
	 * Gets the str curr supp id.
	 * 
	 * @return the str curr supp id
	 */
	public String getStrCurrSuppId() {
		return strCurrSuppId;
	}

	/**
	 * Sets the str curr supp id.
	 * 
	 * @param strCurrSuppId the new str curr supp id
	 */
	public void setStrCurrSuppId(String strCurrSuppId) {
		this.strCurrSuppId = strCurrSuppId;
	}

	/**
	 * Gets the str last po no.
	 * 
	 * @return the str last po no
	 */
	public String getStrLastPONo() {
		return strLastPONo;
	}

	/**
	 * Sets the str last po no.
	 * 
	 * @param strLastPONo the new str last po no
	 */
	public void setStrLastPONo(String strLastPONo) {
		this.strLastPONo = strLastPONo;
	}

	/**
	 * Gets the str last po date.
	 * 
	 * @return the str last po date
	 */
	public String getStrLastPODate() {
		return strLastPODate;
	}

	/**
	 * Sets the str last po date.
	 * 
	 * @param strLastPODate the new str last po date
	 */
	public void setStrLastPODate(String strLastPODate) {
		this.strLastPODate = strLastPODate;
	}

	/**
	 * Gets the str last pur rate.
	 * 
	 * @return the str last pur rate
	 */
	public String getStrLastPurRate() {
		return strLastPurRate;
	}

	/**
	 * Sets the str last pur rate.
	 * 
	 * @param strLastPurRate the new str last pur rate
	 */
	public void setStrLastPurRate(String strLastPurRate) {
		this.strLastPurRate = strLastPurRate;
	}

	/**
	 * Gets the str last pur rate unit id.
	 * 
	 * @return the str last pur rate unit id
	 */
	public String getStrLastPurRateUnitId() {
		return strLastPurRateUnitId;
	}

	/**
	 * Sets the str last pur rate unit id.
	 * 
	 * @param strLastPurRateUnitId the new str last pur rate unit id
	 */
	public void setStrLastPurRateUnitId(String strLastPurRateUnitId) {
		this.strLastPurRateUnitId = strLastPurRateUnitId;
	}

	/**
	 * Gets the str last rec qty.
	 * 
	 * @return the str last rec qty
	 */
	public String getStrLastRecQty() {
		return strLastRecQty;
	}

	/**
	 * Sets the str last rec qty.
	 * 
	 * @param strLastRecQty the new str last rec qty
	 */
	public void setStrLastRecQty(String strLastRecQty) {
		this.strLastRecQty = strLastRecQty;
	}

	/**
	 * Gets the str last rec qty unit id.
	 * 
	 * @return the str last rec qty unit id
	 */
	public String getStrLastRecQtyUnitId() {
		return strLastRecQtyUnitId;
	}

	/**
	 * Sets the str last rec qty unit id.
	 * 
	 * @param strLastRecQtyUnitId the new str last rec qty unit id
	 */
	public void setStrLastRecQtyUnitId(String strLastRecQtyUnitId) {
		this.strLastRecQtyUnitId = strLastRecQtyUnitId;
	}

	/**
	 * Gets the str last supp id.
	 * 
	 * @return the str last supp id
	 */
	public String getStrLastSuppId() {
		return strLastSuppId;
	}

	/**
	 * Sets the str last supp id.
	 * 
	 * @param strLastSuppId the new str last supp id
	 */
	public void setStrLastSuppId(String strLastSuppId) {
		this.strLastSuppId = strLastSuppId;
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
	 * Gets the str is quantifiable.
	 * 
	 * @return the str is quantifiable
	 */
	public String getStrIsQuantifiable() {
		return strIsQuantifiable;
	}

	/**
	 * Sets the str is quantifiable.
	 * 
	 * @param strIsQuantifiable the new str is quantifiable
	 */
	public void setStrIsQuantifiable(String strIsQuantifiable) {
		this.strIsQuantifiable = strIsQuantifiable;
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
	 * Insert.
	 * 
	 * @param dao the dao
	 */
	public void insert(HisDAO dao) {
		String strQuery = "";
		int nQueryIndex = 0;
		try {

			strQuery = mms.qryHandler_mms.getQuery(1,"select.drugbrand.insert.0");

			nQueryIndex = dao.setQuery(strQuery);
			
			//System.out.println("here is the insert values....");
			//System.out.println(this.getStrHospitalCode()+" "+this.getStrItemCatNo()+" "+this.getStrItemId()+" "+this.getStrHospitalCode());
			//System.out.println(this.getStrItemCatNo()+" "+this.getStrItemName()+" "+this.getStrManufacturerId()+" "+this.getStrDefaultRate());
			//System.out.println(this.getStrRateUnitId()+" "+this.getStrApprovedType()+" "+this.getStrIssueType()+" "+this.getStrSpecification());
			//System.out.println(this.getStrItemMake()+" "+this.getStrEffectiveFrom()+" "+this.getStrSeatId()+" "+this.getStrIsValid());
			//System.out.println(this.getStrSetSachetFlag()+" "+this.getStrItemTypeId()+" "+this.getStrIsQuantifiable()+" "+strCPACode);
			//System.out.println(this.getStrItemReservedFlag()+" "+this.getStrConfigIssueRate()+" "+this.getStrQCType());
			//System.out.println(this.getStrMktRate().equals("") ? "0":this.getStrMktRate());
			//System.out.println(this.getStrMktRateUnitId()+" "+this.getStrHospitalCode()+" "+this.getStrItemCatNo()+" "+this.getStrItemId());
			//System.out.println(this.getStrGroupid());

			dao.setQryValue(nQueryIndex, 1, this.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, this.getStrItemCatNo());
			dao.setQryValue(nQueryIndex, 3, this.getStrItemId());
			dao.setQryValue(nQueryIndex, 4, this.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 5, this.getStrItemCatNo());
			dao.setQryValue(nQueryIndex, 6, this.getStrItemName());
			
			dao.setQryValue(nQueryIndex, 7, this.getStrManufacturerId());
			dao.setQryValue(nQueryIndex, 8, this.getStrDefaultRate());
			dao.setQryValue(nQueryIndex, 9, this.getStrRateUnitId());
			dao.setQryValue(nQueryIndex, 10, this.getStrApprovedType());
			dao.setQryValue(nQueryIndex, 11, "0");
			dao.setQryValue(nQueryIndex, 12, this.getStrSpecification());
			
			dao.setQryValue(nQueryIndex, 13, "0");
			dao.setQryValue(nQueryIndex, 14, this.getStrEffectiveFrom());
			dao.setQryValue(nQueryIndex, 15, this.getStrSeatId());
			dao.setQryValue(nQueryIndex, 16, this.getStrIsValid());
			dao.setQryValue(nQueryIndex, 17, this.getStrSetSachetFlag());
			dao.setQryValue(nQueryIndex, 18, this.getStrItemTypeId());
			dao.setQryValue(nQueryIndex, 19, this.getStrIsQuantifiable());
			dao.setQryValue(nQueryIndex, 20, strCPACode);
			dao.setQryValue(nQueryIndex, 21, this.getStrItemReservedFlag());
			
			dao.setQryValue(nQueryIndex, 22, (this.getStrConfigIssueRate().equals("") || this.getStrConfigIssueRate() == null ? "0" : this.getStrConfigIssueRate() ));  // value Added by Amit Kr Date 22 July 2011
			dao.setQryValue(nQueryIndex, 23, "0");			
			dao.setQryValue(nQueryIndex, 24, this.getStrMktRate().equals("")?"0":this.getStrMktRate());
			dao.setQryValue(nQueryIndex, 25, this.getStrMktRateUnitId());
			
			dao.setQryValue(nQueryIndex, 26, this.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 27, this.getStrItemCatNo());
			dao.setQryValue(nQueryIndex, 28, this.getStrItemId());
			
			dao.setQryValue(nQueryIndex, 29, this.getStrDrugClass());
			dao.setQryValue(nQueryIndex, 30, this.getStrBatchnoReq());
			dao.setQryValue(nQueryIndex, 31, this.getStrExpiryDateReq());
			dao.setQryValue(nQueryIndex, 32, this.getStrGroupid());
			dao.setQryValue(nQueryIndex, 33, this.getStrHSNCode());
			dao.setQryValue(nQueryIndex, 34, this.getStrEdlCat().equals("")?"0":this.getStrEdlCat());
			dao.setQryValue(nQueryIndex, 35, this.getStrIsMisc().equals("")?"0":this.getStrIsMisc());
			//System.out.println("this.getStrEdlCat()"+this.getStrEdlCat());
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
			strQuery = mms.qryHandler_mms.getQuery(1,"select.drugbrand.insert.a");
			nQueryIndex = dao.setQuery(strQuery);
			
			
			//System.out.println("this.getStrIsValid()"+this.getStrIsValid());
            /*Some Index Commented For Review Points of Drug Master*/
			
			dao.setQryValue(nQueryIndex, 1, this.getStrItemBrandId());			
			dao.setQryValue(nQueryIndex, 2, this.getStrItemId());
			dao.setQryValue(nQueryIndex, 3, this.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 4, this.getStrItemCatNo());
			dao.setQryValue(nQueryIndex, 5, this.getStrItemName());
			dao.setQryValue(nQueryIndex, 6, this.getStrManufacturerId());
			dao.setQryValue(nQueryIndex, 7, this.getStrDefaultRate());
			dao.setQryValue(nQueryIndex, 8, this.getStrRateUnitId());
			dao.setQryValue(nQueryIndex, 9, this.getStrApprovedType());
			//dao.setQryValue(nQueryIndex, 10, this.getStrIssueType());
			dao.setQryValue(nQueryIndex, 10, "0");
			dao.setQryValue(nQueryIndex, 11, this.getStrSpecification());
			dao.setQryValue(nQueryIndex, 12, this.getStrItemMake());
			dao.setQryValue(nQueryIndex, 13, this.getStrEffectiveFrom());
			dao.setQryValue(nQueryIndex, 14, this.getStrSeatId());
			dao.setQryValue(nQueryIndex, 15, this.getStrIsValid());
			//dao.setQryValue(nQueryIndex, 16, this.getStrSetSachetFlag());
			dao.setQryValue(nQueryIndex, 16, this.getStrSetSachetFlag().equals("")?"0":this.getStrSetSachetFlag());
			dao.setQryValue(nQueryIndex, 17, this.getStrItemTypeId());
			//dao.setQryValue(nQueryIndex, 18, this.getStrIsQuantifiable());
			dao.setQryValue(nQueryIndex, 18, this.getStrIsQuantifiable().equals("")?"0":this.getStrIsQuantifiable());
			dao.setQryValue(nQueryIndex, 19, strCPACode);
			dao.setQryValue(nQueryIndex, 20, this.getStrItemReservedFlag().equals("")?"0":this.getStrItemReservedFlag());
			dao.setQryValue(nQueryIndex, 21, this.getStrConfigIssueRate().equals("")?"0":this.getStrConfigIssueRate());  // value Added by Amit Kr Date 22 July 2011
			//dao.setQryValue(nQueryIndex, 22, this.getStrQCType());
			dao.setQryValue(nQueryIndex, 22, "0");
			dao.setQryValue(nQueryIndex, 23, this.getStrMktRate().equals("")?"0":this.getStrMktRate());
			dao.setQryValue(nQueryIndex, 24, this.getStrMktRateUnitId().equals("")?"0":this.getStrMktRateUnitId());			
			dao.setQryValue(nQueryIndex, 25, this.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 26, this.getStrItemCatNo());
			dao.setQryValue(nQueryIndex, 27, this.getStrItemId());
			
			dao.setQryValue(nQueryIndex, 28, this.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 29, this.getStrItemBrandId());	
			
			dao.setQryValue(nQueryIndex, 30, this.getStrDrugClass().equals("")?"0":this.getStrDrugClass());
			dao.setQryValue(nQueryIndex, 31, this.getStrBatchnoReq().equals("")?"0":this.getStrBatchnoReq());
			dao.setQryValue(nQueryIndex, 32, this.getStrExpiryDateReq().equals("")?"0":this.getStrExpiryDateReq());	
			dao.setQryValue(nQueryIndex, 33, this.getStrHSNCode().equals("")?"0":this.getStrHSNCode());
			dao.setQryValue(nQueryIndex, 34, this.getStrEdlCat().equals("") ? "0":this.getStrEdlCat());
			dao.setQryValue(nQueryIndex, 35, this.getStrGroupid().equals("") ? "0":this.getStrGroupid());
			dao.setQryValue(nQueryIndex, 36, this.getStrIsMisc().equals("")?"0":this.getStrIsMisc());
			//System.out.println("this.getStrEdlCat()"+this.getStrEdlCat());
			dao.execute(nQueryIndex, 0);
			nRowInserted++;

		} catch (Exception e) {
			e.printStackTrace();
		}

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
			//System.out.println(" this.getStrItemBrandId()****"+ this.getStrItemBrandId());
			dao.setQryValue(nQueryIndex, 4, this.getStrItemBrandId().equalsIgnoreCase("")?"0":getStrItemBrandId());
			dao.setQryValue(nQueryIndex, 5, this.getStrSeatId().equalsIgnoreCase("")?"0":getStrSeatId());
			dao.setQryValue(nQueryIndex, 6, this.strCPACode.equalsIgnoreCase("")?"0":strCPACode);
			
			dao.execute(nQueryIndex, 0);
			nRowInserted++;
			// // //System.out.println(" nRowInserted++;"+ nRowInserted);

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
	/**
	 * Update.
	 * 
	 * @param dao the dao
	 */
	public void update(HisDAO dao) {
		String strQuery = "";
		int nQueryIndex = 0;
		try {

			strQuery = mms.qryHandler_mms.getQuery(1,
					"select.drugbrand.update.0");

			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, this.getStrItemName());
			dao.setQryValue(nQueryIndex, 2, this.getStrDefaultRate());
			dao.setQryValue(nQueryIndex, 3, this.getStrRateUnitId());
			dao.setQryValue(nQueryIndex, 4, this.getStrManufacturerId());
			dao.setQryValue(nQueryIndex, 5, this.getStrApprovedType());
			dao.setQryValue(nQueryIndex, 6, this.getStrIssueType());
			dao.setQryValue(nQueryIndex, 7, this.getStrSpecification());
			dao.setQryValue(nQueryIndex, 8, this.getStrItemMake());
			dao.setQryValue(nQueryIndex, 9, this.getStrEffectiveFrom());
			dao.setQryValue(nQueryIndex, 10, this.getStrLastModifiedSeatId());
			dao.setQryValue(nQueryIndex, 11, this.getStrIsValid());
			dao.setQryValue(nQueryIndex, 12, this.getStrSetSachetFlag());
			dao.setQryValue(nQueryIndex, 13, this.getStrItemTypeId());
			dao.setQryValue(nQueryIndex, 14, this.getStrIsQuantifiable());
			dao.setQryValue(nQueryIndex, 15, strCPACode);
			dao.setQryValue(nQueryIndex, 16, this.getStrConfigIssueRate());
			dao.setQryValue(nQueryIndex, 17, this.getStrQCType());			
			dao.setQryValue(nQueryIndex, 18, this.getStrMktRate());
			dao.setQryValue(nQueryIndex, 19, this.getStrMktRateUnitId());
			
			dao.setQryValue(nQueryIndex, 20, this.getStrItemBrandId());
			dao.setQryValue(nQueryIndex, 21, this.getStrHospitalCode());
			
			

			dao.execute(nQueryIndex, 0);
			nRowUpdated++;

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

			// //System.out.println("dao update");
			strQuery = mms.qryHandler_mms.getQuery(1, "update.drugbrand.0");
			nQueryIndex = dao.setQuery(strQuery);
				
			dao.setQryValue(nQueryIndex, 1, getStrSeatId());			
			dao.setQryValue(nQueryIndex, 2, getStrItemBrandId());
			dao.setQryValue(nQueryIndex, 3, getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 4, getStrSerialNo());		
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


	/**
	 * Reset.
	 */
	public void reset() {

		strItemBrandId = "";
		strItemId = "";
		strHospitalCode = "";
		strItemCatNo = "1";
		strItemName = "";
		strManufacturerId = "";
		strDefaultRate = "";
		strRateUnitId = "";
		strApprovedType = "";
		strIssueType = "";
		strSpecification = "";
		strItemMake = "";
		strRemarks = "";
		strEffectiveFrom = "";
		strLastModifiedSeatId = "";
		strLastModifiedDate = "";
		strCurrPONo = "";
		strEntryDate = "";
		strSeatId = "";
		strCurrPODate = "";
		strCurrPurRate = "";
		strIsValid = "1";
		strCurrPurRateUnitId = "";
		strCurrSuppId = "";
		strLastPONo = "";
		strLastPODate = "";
		strLastPurRate = "";
		strLastPurRateUnitId = "";
		strLastRecQty = "";
		strLastRecQtyUnitId = "";
		strLastSuppId = "";
		strSetSachetFlag = "";
		strItemTypeId = "";
		strIsQuantifiable = "";
		strQCType = "";
		strErr = "";
		strBatchnoReq="";
		strExpiryDateReq="";
		strDrugClass="";
	}

	/**
	 * @param strCPACode the strCPACode to set
	 */
	public void setStrCPACode(String strCPACode) {
		this.strCPACode = strCPACode;
	}

	public String getStrConfigIssueRate() {
		return strConfigIssueRate;
	}

	public void setStrConfigIssueRate(String strConfigIssueRate) {
		this.strConfigIssueRate = strConfigIssueRate;
	}

	public String getStrQCType() {
		return strQCType;
	}

	public void setStrQCType(String strQCType) {
		this.strQCType = strQCType;
	}
}
