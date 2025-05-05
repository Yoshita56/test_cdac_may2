package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierDAO.
 */
public class SupplierDAO {

	/** The str proc name. */
//	private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.SupplierDAO";

	/** The str supplier id. */
	private String strSupplierId = "0";
	
	/** The str store type id. */
	private String strStoreTypeId = "0";
	
	/** The str supplier grade id. */
	private String strSupplierGradeId = "0";
	
	/** The str supplier name. */
	private String strSupplierName = "";
	
	/** The str contact person. */
	private String strContactPerson = "";
	
	/** The str address. */
	private String strAddress = "";
	
	/** The str city name. */
	private String strCityName = "";
	
	/** The str pin code. */
	private String strPinCode = "";
	
	/** The str phone1. */
	private String strPhone1 = "";
	
	/** The str phone2. */
	private String strPhone2 = "";
	
	/** The str email1. */
	private String strEmail1 = "";
	
	/** The str email2. */
	private String strEmail2 = "";
	
	/** The str fax no1. */
	private String strFaxNo1 = "";
	
	/** The str fax no2. */
	private String strFaxNo2 = "";
	
	/** The str web site. */
	private String strWebSite = "";
	// private String strBlackListFlag = "";
	/** The str supplier type. */
	private String strSupplierType = "";
	
	/** The str supplier status. */
	private String strSupplierStatus = "";
	// private String strRateContFromDate = "";
	// private String strRateContToDate = "";
	// private String strOrderNo = "";
	// private String strOrderDate = "";
	/** The str local purchase supp flag. */
	//private String strLocalPurchaseSuppFlag = "";
	
	/** The str foreigner supp flag. */
	private String strForeignerSuppFlag = "";
	
	/** The str is supplier. */
	private String strIsSupplier = "1";
	
	/** The str is manufacturer. */
	private String strIsManufacturer = "0";
	
	/** The str is agent. */
	private String strIsAgent = "0";
	
	/** The str is buyer. */
	private String strIsBuyer = "0";
	
	/** The str lst no. */
	private String strLstNo = "";
	
	/** The str cst no. */
	private String strCstNo = "";
	
	/** The str pan no. */
	private String strPANNo = "";

	/** The str effective from. */
	private String strEffectiveFrom = "";

	/** The str remarks. */
	private String strRemarks = "";

	/** The str entry date. */
//	private String strEntryDate = "";

	/** The str last modified date. */
//	private String strLastModifiedDate = "";

	/** The str seat id. */
	private String strSeatId = "";

	/** The str last modified seat id. */
	//private String strLastModifiedSeatId = "";
	
	private String 	strSuppTurnOverUnit;
	/** The str Country Code no. */
	private String strCountryCode = "";
	
	/** The str State Code no. */
	private String strStateCode = "";
	
	
	/** The str is valid. */
	private String strIsValid = "1";

	/** The str hospital code. */
	private String strHospitalCode = "";

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
	
	
    private String strContractNo = "";
	
	private String strContractDate = "";
	
	private String strExpiryDate ="";
	
	private String strSuppTurnOver;
	
    private String strSupplierProvMaintenance;
	
    private String strEsclationMtxAvl;
    
    private String strSlNo;
    private String strWhetherSupplierInterfacerequired;
	
	public String getStrWhetherSupplierInterfacerequired() {
		return strWhetherSupplierInterfacerequired;
	}

	public void setStrWhetherSupplierInterfacerequired(String strWhetherSupplierInterfacerequired) {
		this.strWhetherSupplierInterfacerequired = strWhetherSupplierInterfacerequired;
	}

	public String getStrSlNo() {
		return strSlNo;
	}

	public void setStrSlNo(String strSlNo) {
		this.strSlNo = strSlNo;
	}

	public void setStrCountryCode(String strCountryCode) {
		this.strCountryCode = strCountryCode;
	}
	
	public void setStrSuppTurnOver(String strSuppTurnOver) {
		this.strSuppTurnOver = strSuppTurnOver;
	}
	public void setStrStateCode(String strStateCode) {
		this.strStateCode = strStateCode;
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
	 * Sets the str remarks.
	 * 
	 * @param strRemarks the new str remarks
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
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
	 * Sets the str is valid.
	 * 
	 * @param strIsValid the new str is valid
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
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
	 * Sets the str supplier grade id.
	 * 
	 * @param strSupplierGradeId the new str supplier grade id
	 */
	public void setStrSupplierGradeId(String strSupplierGradeId) {
		this.strSupplierGradeId = strSupplierGradeId;
	}

	/**
	 * Sets the str supplier id.
	 * 
	 * @param strSupplierId the new str supplier id
	 */
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}

	/**
	 * Sets the str store type id.
	 * 
	 * @param strStoreTypeId the new str store type id
	 */
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}

	/**
	 * Sets the str supplier name.
	 * 
	 * @param strSupplierName the new str supplier name
	 */
	public void setStrSupplierName(String strSupplierName) {
		this.strSupplierName = strSupplierName;
	}

	/**
	 * Sets the str contact person.
	 * 
	 * @param strContactPerson the new str contact person
	 */
	public void setStrContactPerson(String strContactPerson) {
		this.strContactPerson = strContactPerson;
	}

	/**
	 * Sets the str address.
	 * 
	 * @param strAddress the new str address
	 */
	public void setStrAddress(String strAddress) {
		this.strAddress = strAddress;
	}

	/**
	 * Sets the str city name.
	 * 
	 * @param strCityName the new str city name
	 */
	public void setStrCityName(String strCityName) {
		this.strCityName = strCityName;
	}

	/**
	 * Sets the str pin code.
	 * 
	 * @param strPinCode the new str pin code
	 */
	public void setStrPinCode(String strPinCode) {
		this.strPinCode = strPinCode;
	}

	/**
	 * Sets the str phone1.
	 * 
	 * @param strPhone1 the new str phone1
	 */
	public void setStrPhone1(String strPhone1) {
		this.strPhone1 = strPhone1;
	}

	/**
	 * Sets the str phone2.
	 * 
	 * @param strPhone2 the new str phone2
	 */
	public void setStrPhone2(String strPhone2) {
		this.strPhone2 = strPhone2;
	}

	/**
	 * Sets the str email1.
	 * 
	 * @param strEmail1 the new str email1
	 */
	public void setStrEmail1(String strEmail1) {
		this.strEmail1 = strEmail1;
	}

	/**
	 * Sets the str email2.
	 * 
	 * @param strEmail2 the new str email2
	 */
	public void setStrEmail2(String strEmail2) {
		this.strEmail2 = strEmail2;
	}

	/**
	 * Sets the str fax no1.
	 * 
	 * @param strFaxNo1 the new str fax no1
	 */
	public void setStrFaxNo1(String strFaxNo1) {
		this.strFaxNo1 = strFaxNo1;
	}

	/**
	 * Sets the str fax no2.
	 * 
	 * @param strFaxNo2 the new str fax no2
	 */
	public void setStrFaxNo2(String strFaxNo2) {
		this.strFaxNo2 = strFaxNo2;
	}

	/**
	 * Sets the str web site.
	 * 
	 * @param strWebSite the new str web site
	 */
	public void setStrWebSite(String strWebSite) {
		this.strWebSite = strWebSite;
	}

	/**
	 * Sets the str supplier type.
	 * 
	 * @param strSupplierType the new str supplier type
	 */
	public void setStrSupplierType(String strSupplierType) {
		this.strSupplierType = strSupplierType;
	}

	/**
	 * Sets the str supplier status.
	 * 
	 * @param strSupplierStatus the new str supplier status
	 */
	public void setStrSupplierStatus(String strSupplierStatus) {
		this.strSupplierStatus = strSupplierStatus;
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
	 * Sets the str is supplier.
	 * 
	 * @param strIsSupplier the strIsSupplier to set
	 */
	public void setStrIsSupplier(String strIsSupplier) {
		this.strIsSupplier = strIsSupplier;
	}

	/**
	 * Sets the str is manufacturer.
	 * 
	 * @param strIsManufacturer the strIsManufacturer to set
	 */
	public void setStrIsManufacturer(String strIsManufacturer) {
		this.strIsManufacturer = strIsManufacturer;
	}

	/**
	 * Sets the str is agent.
	 * 
	 * @param strIsAgent the strIsAgent to set
	 */
	public void setStrIsAgent(String strIsAgent) {
		this.strIsAgent = strIsAgent;
	}

	/**
	 * Sets the str is buyer.
	 * 
	 * @param strIsBuyer the strIsBuyer to set
	 */
	public void setStrIsBuyer(String strIsBuyer) {
		this.strIsBuyer = strIsBuyer;
	}

	/**
	 * Sets the str lst no.
	 * 
	 * @param strLstNo the strLstNo to set
	 */
	public void setStrLstNo(String strLstNo) {
		this.strLstNo = strLstNo;
	}

	/**
	 * Sets the str cst no.
	 * 
	 * @param strCstNo the strCstNo to set
	 */
	public void setStrCstNo(String strCstNo) {
		this.strCstNo = strCstNo;
	}

	/**
	 * Sets the str pan no.
	 * 
	 * @param strPANNo the strPANNo to set
	 */
	public void setStrPANNo(String strPANNo) {
		this.strPANNo = strPANNo;
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
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strSupplierName or strHospitalCode or strSupplierId is
	 * blank
	 */
	public void insert(HisDAO dao) throws Exception {
		String strQuery = "";
		int nQueryIndex = 0;
		strErr = "";
		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strSupplierName.equals("0") || strSupplierName.equals("")) {
				throw new Exception("strSupplierName can not be blank");
			}
			if (strSupplierId.equals("0") || strSupplierId.equals("")) {
				throw new Exception("strSupplierId can not be blank");
			}
			
			//added by anshul on 21 jan 2013 for postgres comopatibility
			if (strSupplierGradeId.equals("") || strSupplierGradeId.equals(null)) {
				strSupplierGradeId="0";
			}
			
			if (strPinCode.equals("") || strPinCode.equals(null)) {
				strPinCode="0";
			}
			
			if (strLstNo.equals("") || strLstNo.equals(null)) {
				strLstNo="0";
			}
			if (strCstNo.equals("") || strCstNo.equals(null)) {
				strCstNo="0";
			}
			if (strPANNo.equals("") || strPANNo.equals(null)) {
				strPANNo="0";
			}
			if (strIsSupplier.equals("") || strIsSupplier.equals(null)) {
				strIsSupplier="0";
			}
			if (strIsManufacturer.equals("") || strIsManufacturer.equals(null)) {
				strIsManufacturer="0";
			}
			if (strIsAgent.equals("") || strIsAgent.equals(null)) {
				strIsAgent="0";
			}
			if (strIsBuyer.equals("") || strIsBuyer.equals(null)) {
				strIsBuyer="0";
			}
			if (strForeignerSuppFlag.equals("") || strForeignerSuppFlag.equals(null)) {
				strForeignerSuppFlag="0";
			}
			if (strSuppTurnOver.equals("") || strSuppTurnOver.equals(null)) {
				strSuppTurnOver="0";
			}
			if (strContractDate.equals("") || strContractDate.equals(null)) {
				strContractDate=null;
			}
			if (strExpiryDate.equals("") || strExpiryDate.equals(null)) {
				strExpiryDate=null;
			}
			if (strContactPerson.equals("0") || strContactPerson.equals("")) {
				strContactPerson="0";
			}
			
			
			if (strPhone1.equals("0") || strPhone1.equals("")) {
				strPhone1="0";
			}
			
		
			
			if (strPhone2.equals("0") || strPhone2.equals("")) {
				strPhone2="0";
			}
			
			
		
			if (strEmail1.equals("0") || strEmail1.equals("")) {
				strEmail1="0";
			}
			
		
			if (strPhone1.equals("0") || strPhone1.equals("")) {
				strPhone1="0";
			}
			
			
		
			if (strFaxNo1.equals("0") || strFaxNo1.equals("")) {
				strFaxNo1="0";
			}
			
			
			if (strFaxNo2.equals("0") || strFaxNo2.equals("")) {
				strFaxNo2="0";
			}
			
		
			if (strWebSite.equals("0") || strWebSite.equals("")) {
				strWebSite="0";
			}
			
			
			if (strRemarks.equals("0") || strRemarks.equals("")) {
				strRemarks="0";
			}
			
			
			
			if (strStateCode.equals("0") || strStateCode.equals("")) {
				strStateCode="0";
			}
			
			
			if (strContractNo.equals("0") || strContractNo.equals("")) {
				strContractNo="0";
			}
			
			if (strWhetherSupplierInterfacerequired.equals("0") || strWhetherSupplierInterfacerequired.equals("")) {
				strWhetherSupplierInterfacerequired="0";
			}
			
			
		    		

			strQuery = mms.qryHandler_mms.getQuery(1, "insert.supplier.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, strSupplierId);
			dao.setQryValue(nQueryIndex, 2, strHospitalCode);
			dao.setQryValue(nQueryIndex, 3, strStoreTypeId);
			dao.setQryValue(nQueryIndex, 4, strSupplierGradeId);
			dao.setQryValue(nQueryIndex, 5, strSupplierName);
			dao.setQryValue(nQueryIndex, 6, strContactPerson);
			dao.setQryValue(nQueryIndex, 7, strAddress);
			dao.setQryValue(nQueryIndex, 8, strCityName);			
			 
			dao.setQryValue(nQueryIndex, 9, strPinCode);
			dao.setQryValue(nQueryIndex, 10, strPhone1);
			dao.setQryValue(nQueryIndex, 11, strPhone2);
			dao.setQryValue(nQueryIndex, 12, strEmail1);
			dao.setQryValue(nQueryIndex, 13, strEmail2);
			dao.setQryValue(nQueryIndex, 14, strFaxNo1);
			dao.setQryValue(nQueryIndex, 15, strFaxNo2);
			dao.setQryValue(nQueryIndex, 16, strWebSite);
			dao.setQryValue(nQueryIndex, 17, strSupplierStatus);
			dao.setQryValue(nQueryIndex, 18, strRemarks);
			dao.setQryValue(nQueryIndex, 19, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 20, strSeatId);
			dao.setQryValue(nQueryIndex, 21, "1");			
			dao.setQryValue(nQueryIndex, 22, strLstNo);
			dao.setQryValue(nQueryIndex, 23, strCstNo);
			dao.setQryValue(nQueryIndex, 24, strPANNo);
			dao.setQryValue(nQueryIndex, 25, strIsSupplier);
			dao.setQryValue(nQueryIndex, 26, strIsManufacturer);
			//dao.setQryValue(nQueryIndex, 27, "1"); commented by shalini as agent was coming with every supplier name
			dao.setQryValue(nQueryIndex, 27, strIsAgent);
			dao.setQryValue(nQueryIndex, 28, strIsBuyer);
			dao.setQryValue(nQueryIndex, 29, strForeignerSuppFlag);
			dao.setQryValue(nQueryIndex, 30, strSupplierType);
			dao.setQryValue(nQueryIndex, 31, strCountryCode);
			dao.setQryValue(nQueryIndex, 32, strStateCode);
			dao.setQryValue(nQueryIndex, 33, strContractNo);			 
			dao.setQryValue(nQueryIndex, 34, strContractDate);
			dao.setQryValue(nQueryIndex, 35, strExpiryDate);
			dao.setQryValue(nQueryIndex, 36, strSuppTurnOver);
			dao.setQryValue(nQueryIndex, 37, strSuppTurnOverUnit);
			dao.setQryValue(nQueryIndex, 38, strSupplierProvMaintenance);
			dao.setQryValue(nQueryIndex, 39, strEsclationMtxAvl);
			dao.setQryValue(nQueryIndex, 40, strWhetherSupplierInterfacerequired);
		
			dao.execute(nQueryIndex, 0);
			this.nRowInserted++;
			
			
			

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} 
		finally 
		{
			this.reset(); 
		}

	}
	
	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strSupplierName or strHospitalCode or strSupplierId is
	 * blank
	 */
	public void insertIntoSuppEsclation(HisDAO dao) throws Exception {
		String strQuery = "";
		int nQueryIndex = 0;
		strErr = "";
		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}			
			if (strSupplierId.equals("0") || strSupplierId.equals("")) {
				throw new Exception("strSupplierId can not be blank");
			}

			//added by anshul on 21 jan 2013 for postgres comopatibility
			if (strSupplierGradeId.equals("") || strSupplierGradeId.equals(null)) {
				strSupplierGradeId="0";
			}
			
			if (strPinCode.equals("") || strPinCode.equals(null)) {
				strPinCode="0";
			}
			
			if (strLstNo.equals("") || strLstNo.equals(null)) {
				strLstNo="0";
			}
			if (strCstNo.equals("") || strCstNo.equals(null)) {
				strCstNo="0";
			}
			if (strPANNo.equals("") || strPANNo.equals(null)) {
				strPANNo="0";
			}
			if (strIsSupplier.equals("") || strIsSupplier.equals(null)) {
				strIsSupplier="0";
			}
			if (strIsManufacturer.equals("") || strIsManufacturer.equals(null)) {
				strIsManufacturer="0";
			}
			if (strIsAgent.equals("") || strIsAgent.equals(null)) {
				strIsAgent="0";
			}
			if (strIsBuyer.equals("") || strIsBuyer.equals(null)) {
				strIsBuyer="0";
			}
			if (strForeignerSuppFlag.equals("") || strForeignerSuppFlag.equals(null)) {
				strForeignerSuppFlag="0";
			}
			if (strSuppTurnOver.equals("") || strSuppTurnOver.equals(null)) {
				strSuppTurnOver="0";
			}
			
			
			strQuery = mms.qryHandler_mms.getQuery(1, "insert.supplier.11");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, strSupplierId);
			dao.setQryValue(nQueryIndex, 2, strHospitalCode);
			dao.setQryValue(nQueryIndex, 3, strStoreTypeId);
			
			dao.setQryValue(nQueryIndex, 4, strSupplierGradeId);
			dao.setQryValue(nQueryIndex, 5, strSupplierName);
			dao.setQryValue(nQueryIndex, 6, strContactPerson);
			dao.setQryValue(nQueryIndex, 7, strAddress);
			dao.setQryValue(nQueryIndex, 8, strCityName);
			dao.setQryValue(nQueryIndex, 9, strPinCode);
			dao.setQryValue(nQueryIndex, 10, strPhone1);
			dao.setQryValue(nQueryIndex, 11, strPhone2);
			dao.setQryValue(nQueryIndex, 12, strEmail1);
			dao.setQryValue(nQueryIndex, 13, strEmail2);
			dao.setQryValue(nQueryIndex, 14, strFaxNo1);
			dao.setQryValue(nQueryIndex, 15, strFaxNo2);
			dao.setQryValue(nQueryIndex, 16, strWebSite);
			dao.setQryValue(nQueryIndex, 17, strSupplierStatus);
			dao.setQryValue(nQueryIndex, 18, strRemarks);
			dao.setQryValue(nQueryIndex, 19, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 20, strSeatId);
			dao.setQryValue(nQueryIndex, 21, "1");
			dao.setQryValue(nQueryIndex, 22, strLstNo);
			dao.setQryValue(nQueryIndex, 23, strCstNo);
			dao.setQryValue(nQueryIndex, 24, strPANNo);
			dao.setQryValue(nQueryIndex, 25, strIsSupplier);
			dao.setQryValue(nQueryIndex, 26, strIsManufacturer);
			dao.setQryValue(nQueryIndex, 27, strIsAgent);
			dao.setQryValue(nQueryIndex, 28, strIsBuyer);
			dao.setQryValue(nQueryIndex, 29, strForeignerSuppFlag);
			dao.setQryValue(nQueryIndex, 30, strSupplierType);
			dao.setQryValue(nQueryIndex, 31, strCountryCode);
			dao.setQryValue(nQueryIndex, 32, strStateCode);			
			dao.setQryValue(nQueryIndex, 33, strContractNo);
			dao.setQryValue(nQueryIndex, 34, strContractDate);
			dao.setQryValue(nQueryIndex, 35, strExpiryDate);
			dao.setQryValue(nQueryIndex, 36, strSuppTurnOver);
			dao.setQryValue(nQueryIndex, 37, strSuppTurnOverUnit);
		

			dao.execute(nQueryIndex, 0);
			this.nRowInserted++;

		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

	}
	

	/**
	 * This method will be used to update the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strSupplierName or strHospitalCode or strSupplierId is
	 * blank
	 */
	public void update(HisDAO dao) throws Exception {
		String strQuery = "";
		int nQueryIndex = 0;
		strErr = "";
		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strSupplierName.equals("0") || strSupplierName.equals("")) {
				throw new Exception("strSupplierName can not be blank");
			}
			if (strSupplierId.equals("0") || strSupplierId.equals("")) {
				throw new Exception("strSupplierId can not be blank");
			}
			
			//added by anshul on 21 jan 2013 for postgres comopatibility
			if (strSupplierGradeId.equals("") || strSupplierGradeId.equals(null)) {
				strSupplierGradeId="0";
			}
			
			if (strPinCode.equals("") || strPinCode.equals(null)) {
				strPinCode="0";
			}
			
			if (strLstNo.equals("") || strLstNo.equals(null)) {
				strLstNo="0";
			}
			if (strCstNo.equals("") || strCstNo.equals(null)) {
				strCstNo="0";
			}
			if (strPANNo.equals("") || strPANNo.equals(null)) {
				strPANNo="0";
			}
			if (strIsSupplier.equals("") || strIsSupplier.equals(null)) {
				strIsSupplier="0";
			}
			if (strIsManufacturer.equals("") || strIsManufacturer.equals(null)) {
				strIsManufacturer="0";
			}
			if (strIsAgent.equals("") || strIsAgent.equals(null)) {
				strIsAgent="0";
			}
			if (strIsBuyer.equals("") || strIsBuyer.equals(null)) {
				strIsBuyer="0";
			}
			if (strForeignerSuppFlag.equals("") || strForeignerSuppFlag.equals(null)) {
				strForeignerSuppFlag="0";
			}
			if (strSuppTurnOver.equals("") || strSuppTurnOver.equals(null)) {
				strSuppTurnOver="0";
			}
			
			if (strContractNo.equals("") || strContractNo.equals(null)) {
				strContractNo="0";
			}
			strQuery = mms.qryHandler_mms.getQuery(1, "update.supplier.1");
			nQueryIndex = dao.setQuery(strQuery);

			// ////System.out.println("strQuery"+strQuery);
			/*
			 * ////System.out.println("/**--------->"+this.getStrSupplierGradeId());
			 * ////System.out.println("--------->"+this.getStrSupplierName());
			 * ////System.out.println("--------->"+this.getStrContactPerson());
			 * ////System.out.println("--------->"+this.getStrAddress());
			 * ////System.out.println("--------->"+this.getStrCityName());
			 * ////System.out.println("--------->"+this.getStrPinCode());
			 * ////System.out.println("--------->"+this.getStrPhone1());
			 * ////System.out.println("--------->"+this.getStrPhone2());
			 * ////System.out.println("--------->"+this.getStrEmail1());
			 * ////System.out.println("--------->"+this.getStrEmail2());
			 * ////System.out.println("--------->"+this.getStrFaxNo1());
			 * ////System.out.println("--------->"+this.getStrFaxNo2());
			 * ////System.out.println("--------->"+this.getStrWebSite());
			 * ////System.out.println("--------->"+this.getStrBlackListFlag());
			 * ////System.out.println("--------->"+this.getStrSupplierType());
			 * ////System.out.println("--------->"+this.getStrSupplierStatus());
			 * ////System.out.println("--------->"+this.getStrRateContFromDate());
			 * ////System.out.println("--------->"+this.getStrRateContToDate());
			 * ////System.out.println("--------->"+this.getStrOrderNo());
			 * ////System.out.println("--------->"+this.getStrOrderDate());
			 * ////System.out.println("--------->"+this.getStrRemarks());
			 * ////System.out.println("--------->"+this.getStrSeatId());
			 * ////System.out.println("--------->"+this.getStrSupplierId());
			 * ////System.out.println("--------->"+this.getStrHospitalCode());
			 */
			////System.out.println("1:"+ strSeatId);			
			////System.out.println("2:"+ strSupplierId);
			////System.out.println("3:"+ strHospitalCode);
			////System.out.println("4:"+ strSlNo);
			
			
			dao.setQryValue(nQueryIndex, 1, strSeatId);			
			dao.setQryValue(nQueryIndex, 2, strSupplierId);
			dao.setQryValue(nQueryIndex, 3, strHospitalCode);
			dao.setQryValue(nQueryIndex, 4, strSlNo);
			
			dao.execute(nQueryIndex, 0);
			
			
			strQuery = mms.qryHandler_mms.getQuery(1, "insert.supplier.new.record");
			nQueryIndex = dao.setQuery(strQuery);
			
			/*////System.out.println(" 1::"+ strSupplierId);
			////System.out.println(" 2::"+ strHospitalCode);
			////System.out.println(" 3::"+ strStoreTypeId);
			////System.out.println(" 4::"+ strSupplierGradeId);
			////System.out.println(" 5::"+ strSupplierName);
			////System.out.println(" 6::"+ strContactPerson);
			////System.out.println(" 7::"+ strAddress);
			////System.out.println(" 8::"+ strCityName);
			////System.out.println(" 9::"+ strPinCode);
			////System.out.println(" 10::"+ strPhone1);
			////System.out.println(" 11::"+ strPhone2);
			////System.out.println(" 12::"+ strEmail1);
			////System.out.println(" 13::"+ strEmail2);
			////System.out.println(" 14::"+ strFaxNo1);
			////System.out.println(" 15::"+ strFaxNo2);
			////System.out.println(" 16::"+ strWebSite);
			////System.out.println(" 17::"+ strSupplierStatus);
			////System.out.println(" 18::"+ strRemarks);
			////System.out.println(" 19::"+ strEffectiveFrom);
			////System.out.println(" 20::"+ strSeatId);
			////System.out.println(" 21::"+ "1");
			////System.out.println(" 22::"+ strLstNo);
			////System.out.println(" 23::"+ strCstNo);
			////System.out.println(" 24::"+ strPANNo);
			////System.out.println(" 25::"+ strIsSupplier);
			////System.out.println(" 26::"+ strIsManufacturer);
			////System.out.println(" 27::"+ strIsAgent);
			////System.out.println(" 28::"+ strIsBuyer);
			////System.out.println(" 29::"+ strForeignerSuppFlag);
			////System.out.println(" 30::"+ strSupplierType);
			////System.out.println(" 31::"+ strCountryCode);
			////System.out.println(" 32::"+ strStateCode);
			
			 Aritra 
			////System.out.println(" 33::"+ strContractNo);
			
			////System.out.println(" 34::"+ strContractDate);

		
			
			////System.out.println(" 35::"+ strExpiryDate);
		

			
			////System.out.println(" 36::"+ strSuppTurnOver);
			////System.out.println(" 37::"+ strSuppTurnOverUnit);
			////System.out.println(" 38::"+ strSupplierProvMaintenance);
			////System.out.println(" 39::"+ strEsclationMtxAvl);*/
			
			if (strContractDate.equals("") || strContractDate.equals(null)) {
				strContractDate=null;
			}
			if (strExpiryDate.equals("") || strExpiryDate.equals(null)) {
				strExpiryDate=null;
			}
			
			
			dao.setQryValue(nQueryIndex, 1, strSupplierId);
			dao.setQryValue(nQueryIndex, 2, strHospitalCode);
			dao.setQryValue(nQueryIndex, 3, strStoreTypeId);
			dao.setQryValue(nQueryIndex, 4, strSupplierGradeId);
			dao.setQryValue(nQueryIndex, 5, strSupplierName);
			dao.setQryValue(nQueryIndex, 6, strContactPerson);
			dao.setQryValue(nQueryIndex, 7, strAddress);
			dao.setQryValue(nQueryIndex, 8, strCityName);
			dao.setQryValue(nQueryIndex, 9, strPinCode);
			dao.setQryValue(nQueryIndex, 10, strPhone1);
			dao.setQryValue(nQueryIndex, 11, strPhone2);
			dao.setQryValue(nQueryIndex, 12, strEmail1);
			dao.setQryValue(nQueryIndex, 13, strEmail2);
			dao.setQryValue(nQueryIndex, 14, strFaxNo1);
			dao.setQryValue(nQueryIndex, 15, strFaxNo2);
			dao.setQryValue(nQueryIndex, 16, strWebSite);
			dao.setQryValue(nQueryIndex, 17, strSupplierStatus);
			dao.setQryValue(nQueryIndex, 18, strRemarks);
			dao.setQryValue(nQueryIndex, 19, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 20, strSeatId);
			dao.setQryValue(nQueryIndex, 21, "1");
			dao.setQryValue(nQueryIndex, 22, strLstNo);
			dao.setQryValue(nQueryIndex, 23, strCstNo);
			dao.setQryValue(nQueryIndex, 24, strPANNo);
			dao.setQryValue(nQueryIndex, 25, strIsSupplier);
			dao.setQryValue(nQueryIndex, 26, strIsManufacturer);
			dao.setQryValue(nQueryIndex, 27, strIsAgent);
			dao.setQryValue(nQueryIndex, 28, strIsBuyer);
			dao.setQryValue(nQueryIndex, 29, strForeignerSuppFlag);
			dao.setQryValue(nQueryIndex, 30, strSupplierType);
			dao.setQryValue(nQueryIndex, 31, strCountryCode);
			dao.setQryValue(nQueryIndex, 32, strStateCode);
			
			/* Aritra */
			dao.setQryValue(nQueryIndex, 33, strContractNo);
			dao.setQryValue(nQueryIndex, 34, strContractDate);
			dao.setQryValue(nQueryIndex, 35, strExpiryDate);
			dao.setQryValue(nQueryIndex, 36, strSuppTurnOver);
			dao.setQryValue(nQueryIndex, 37, strSuppTurnOverUnit);
			dao.setQryValue(nQueryIndex, 38, strSupplierProvMaintenance);
			dao.setQryValue(nQueryIndex, 39, strEsclationMtxAvl);
			dao.setQryValue(nQueryIndex, 40, strHospitalCode);
			dao.setQryValue(nQueryIndex, 41, strSupplierId);
			dao.setQryValue(nQueryIndex, 42, strWhetherSupplierInterfacerequired);
			//dao.setQryValue(nQueryIndex, 42, strStoreTypeId);
			

			dao.execute(nQueryIndex, 0);
			this.nRowUpdated++;
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

		strSupplierId = "0";
		strStoreTypeId = "0";
		strSupplierName = "";
		strContactPerson = "";
		strAddress = "";
		strCityName = "";
		strPinCode = "";
		strPhone1 = "";
		strPhone2 = "";
		strEmail1 = "";
		strEmail2 = "";
		strFaxNo1 = "";
		strFaxNo2 = "";
		strWebSite = "";

		strSupplierType = "";
		strSupplierStatus = "";

		strSupplierGradeId = "0";
		strEffectiveFrom = "";
		strRemarks = "";
	//	strEntryDate = "";
	//	strLastModifiedDate = "";
		strSeatId = "";
	//	strLastModifiedSeatId = "";
		strIsValid = "";
		strHospitalCode = "";
		strIsSupplier = "1";
		strIsManufacturer = "0";
		strIsAgent = "0";
		strIsBuyer = "0";
		strLstNo = "";
		strCstNo = "";
		strPANNo = "";

	}

	/**
	 * Sets the str foreigner supp flag.
	 * 
	 * @param strForeignerSuppFlag the strForeignerSuppFlag to set
	 */
	public void setStrForeignerSuppFlag(String strForeignerSuppFlag) {
		this.strForeignerSuppFlag = strForeignerSuppFlag;
	}

	

	public void setStrContractNo(String strContractNo) {
		this.strContractNo = strContractNo;
	}

	public void setStrContractDate(String strContractDate) {
		this.strContractDate = strContractDate;
	}

	public void setStrExpiryDate(String strExpiryDate) {
		this.strExpiryDate = strExpiryDate;
	}

	public void setStrSuppTurnOverUnit(String strSuppTurnOverUnit) {
		this.strSuppTurnOverUnit = strSuppTurnOverUnit;
	}

	public String getStrSupplierProvMaintenance() {
		return strSupplierProvMaintenance;
	}

	public void setStrSupplierProvMaintenance(String strSupplierProvMaintenance) {
		this.strSupplierProvMaintenance = strSupplierProvMaintenance;
	}

	public String getStrEsclationMtxAvl() {
		return strEsclationMtxAvl;
	}

	public void setStrEsclationMtxAvl(String strEsclationMtxAvl) {
		this.strEsclationMtxAvl = strEsclationMtxAvl;
	}

}