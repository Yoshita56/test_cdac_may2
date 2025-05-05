package mms.masters.controller.fb;

//import hisglobal.utility.HisUtil;

//import mms.masters.vo.SupplierMstVO;

import hisglobal.masterutil.GenericFormBean;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierMstFB.
 */
public class SupplierMstFB extends GenericFormBean {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The str norm mssgstring. */
	private String strNormMssgstring = "";
	
	/** The str warn mssgstring. */
	private String strWarnMssgstring = "";
	
	/** The str err mssgstring. */
	private String strErrMssgstring = "";
	
	/** The str hosp code. */
	private String strHospCode = "";
	
	/** The str supplier grade values. */
	private String strSupplierGradeValues = "";
	
	/** The str commitee name values. */
	private String strCommiteeNameValues = "";
	// private String strStoreTypeId="";
	// private String strStoreTypeName="";
	/** The str item cat no. */
	private String strItemCatNo = "";
	
	private String strSuppTurnOverUnitVal;
	/** The str item category name. */
	private String strItemCategoryName = "";
	
	private String strSupplierTypeVals="";

	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str supplier name. */
	private String strSupplierName = "";
	
	/** The str supplier grade. */
	private String strSupplierGrade = "";
	
	/** The str contact person. */
	private String strContactPerson = "";
	
	/** The str address. */
	private String strAddress = "";
	
	/** The str city. */
	private String strCity = "";
	
	/** The str pincode. */
	private String strPincode = "";
	
	/** The str phone no1. */
	private String strPhoneNo1 = "";
	
	/** The str phone no2. */
	private String strPhoneNo2 = "";
	
	/** The str email id1. */
	private String strEmailId1 = "";
	
	/** The str email id2. */
	private String strEmailId2 = "";
	
	/** The str fax no1. */
	private String strFaxNo1 = "";
	
	/** The str fax no2. */
	private String strFaxNo2 = "";
	
	/** The str website. */
	private String strWebsite = "";
	
	/** The str supplier type. */
	private String strSupplierType = "";
	
	/** The str supplier status. */
	private String strSupplierStatus = "";
	// private String strRateContractFromDate=""; remove from table
	// private String strRateContractToDate="";
	// private String strOrderNo="";
	// private String strOrderDate="";
	// private String strIsSupplierBlackListed="0";
	/** The str action date. */
	private String strActionDate = "";
	
	/** The str black listed remarks. */
	private String strBlackListedRemarks = "";
	
	/** The str Country Code no. */
	private String strCountryCode = "";
	
	/** The str State Code no. */
	private String strStateCode = "";

	/** The str Country name Combo no. */
	private String strCountryNameCombo ="";
	
	/** The str commitee. */
	private String strCommitee = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str chk. */
	private String strChk = "";
	
	/** The str is valid. */
	private String strIsValid = "";
	
	/** The str current date. */
	private String strCurrentDate = "";
	
	/** The str supplier values modi. */
	private String strSupplierValuesModi = "";
	
	/** The str committe values modi. */
	private String strCommitteValuesModi = "";
	
	/** The str supplier status code. */
	private String strSupplierStatusCode = "";
	
	/** The str is black list mod. */
	private String strIsBlackListMod = "0";
	
	/** The str local purchase supp flag. */
	private String strLocalPurchaseSuppFlag = "";
	
	/** The str foreigner supp flag. */
	private String strForeignerSuppFlag = "";

	/** The str is supplier. */
	private String strIsSupplier = "";
	
	/** The str is manufacturer. */
	private String strIsManufacturer = "";
	
	/** The str is agent. */
	private String strIsAgent = "";
	
	/** The str is buyer. */
	private String strIsBuyer = "";
	
	/** The str lst no. */
	private String strLstNo = "";
	
	/** The str cst no. */
	private String strCstNo = "";
	
	/** The str pan no. */
	private String strPANNo = "";
	
	private String strSuppTurnOver;
	private String strSuppTurnOverUnit;
	private String 	strTurnOverWithUnit;
	
	private String 	strEsclationAvlStatus;

	private String 	strSupplierProvMaintenanceStatus;

	private String 	strLevelOneStatus;

	private String 	strLevelTwoStatus;
	
	/*Aritra*/
	private String strContractNo = "";
	
	private String strContractDate = "";
	
	private String strExpiryDate ="";
	
	private String strSupplierProvMaintenance="0";
	
    private String strEsclationMtxAvl="0";
    
    private String strLevelOneEsc="0";
    
    private String strLevelTwoEsc="0";
    
    private String[]    strCotactPersonForEsc=null;

    private String[]    strContactPersonDesgForEsc=null;

    private String[]   strCotactEmailIdForEsc=null;

    private String[]   strCotactNoForEsc=null;

    private String[]   strCotactFaxForEsc=null;
    
    
    private String    strCotactPersonForEscLevelOne=null;

    private String    strContactPersonDesgForEscLevelOne=null;

    private String   strCotactEmailIdForEscLevelOne=null;

    private String   strCotactNoForEscLevelOne=null;

    private String  strCotactFaxForEscLevelOne=null;
    
    private String    strCotactPersonForEscLevelTwo=null;

    private String    strContactPersonDesgForEscLevelTwo=null;

    private String   strCotactEmailIdForEscLevelTwo=null;

    private String   strCotactNoForEscLevelTwo=null;

    private String  strCotactFaxForEscLevelTwo=null;
    
    
    private String  strLevelOneOpen;
    private String  strLevelTwoOpen;
    
    private String strWhetherSupplierInterfacerequired="0";
    
    private String strStateNameCombo;
 
    

	// private String[] combo =null;

	public String getStrStateNameCombo() {
		return strStateNameCombo;
	}

	public void setStrStateNameCombo(String strStateNameCombo) {
		this.strStateNameCombo = strStateNameCombo;
	}

	public String getStrWhetherSupplierInterfacerequired() {
		return strWhetherSupplierInterfacerequired;
	}

	public void setStrWhetherSupplierInterfacerequired(String strWhetherSupplierInterfacerequired) {
		this.strWhetherSupplierInterfacerequired = strWhetherSupplierInterfacerequired;
	}

	public String getStrLevelOneOpen() {
		return strLevelOneOpen;
	}

	public void setStrLevelOneOpen(String strLevelOneOpen) {
		this.strLevelOneOpen = strLevelOneOpen;
	}

	public String getStrLevelTwoOpen() {
		return strLevelTwoOpen;
	}

	public void setStrLevelTwoOpen(String strLevelTwoOpen) {
		this.strLevelTwoOpen = strLevelTwoOpen;
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

	public String[] getStrCotactPersonForEsc() {
		return strCotactPersonForEsc;
	}

	public void setStrCotactPersonForEsc(String[] strCotactPersonForEsc) {
		this.strCotactPersonForEsc = strCotactPersonForEsc;
	}

	public String[] getStrContactPersonDesgForEsc() {
		return strContactPersonDesgForEsc;
	}

	public void setStrContactPersonDesgForEsc(String[] strContactPersonDesgForEsc) {
		this.strContactPersonDesgForEsc = strContactPersonDesgForEsc;
	}

	public String[] getStrCotactEmailIdForEsc() {
		return strCotactEmailIdForEsc;
	}

	public void setStrCotactEmailIdForEsc(String[] strCotactEmailIdForEsc) {
		this.strCotactEmailIdForEsc = strCotactEmailIdForEsc;
	}

	public String[] getStrCotactNoForEsc() {
		return strCotactNoForEsc;
	}

	public void setStrCotactNoForEsc(String[] strCotactNoForEsc) {
		this.strCotactNoForEsc = strCotactNoForEsc;
	}

	public String[] getStrCotactFaxForEsc() {
		return strCotactFaxForEsc;
	}

	public void setStrCotactFaxForEsc(String[] strCotactFaxForEsc) {
		this.strCotactFaxForEsc = strCotactFaxForEsc;
	}

	public String getStrContractNo() {
		return strContractNo;
	}

	public void setStrContractNo(String strContractNo) {
		this.strContractNo = strContractNo;
	}

	public String getStrContractDate() {
		return strContractDate;
	}

	public void setStrContractDate(String strContractDate) {
		this.strContractDate = strContractDate;
	}

	public String getStrExpiryDate() {
		return strExpiryDate;
	}

	public void setStrExpiryDate(String strExpiryDate) {
		this.strExpiryDate = strExpiryDate;
	}

	/**
	 * Gets the str supplier status code.
	 * 
	 * @return the str supplier status code
	 */
	public String getStrSupplierStatusCode() {
		return strSupplierStatusCode;
	}

	/**
	 * Sets the str supplier status code.
	 * 
	 * @param strSupplierStatusCode the new str supplier status code
	 */
	public void setStrSupplierStatusCode(String strSupplierStatusCode) {
		this.strSupplierStatusCode = strSupplierStatusCode;
	}

	/**
	 * Gets the str current date.
	 * 
	 * @return the str current date
	 */
	public String getStrCurrentDate() {

		return strCurrentDate;
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
	 * Gets the str norm mssgstring.
	 * 
	 * @return the str norm mssgstring
	 */
	public String getStrNormMssgstring() {
		return strNormMssgstring;
	}

	/**
	 * Sets the str norm mssgstring.
	 * 
	 * @param strNormMssgstring the new str norm mssgstring
	 */
	public void setStrNormMssgstring(String strNormMssgstring) {
		this.strNormMssgstring = strNormMssgstring;
	}

	/**
	 * Gets the str warn mssgstring.
	 * 
	 * @return the str warn mssgstring
	 */
	public String getStrWarnMssgstring() {
		return strWarnMssgstring;
	}

	/**
	 * Sets the str warn mssgstring.
	 * 
	 * @param strWarnMssgstring the new str warn mssgstring
	 */
	public void setStrWarnMssgstring(String strWarnMssgstring) {
		this.strWarnMssgstring = strWarnMssgstring;
	}

	/**
	 * Gets the str err mssgstring.
	 * 
	 * @return the str err mssgstring
	 */
	public String getStrErrMssgstring() {
		return strErrMssgstring;
	}

	/**
	 * Sets the str err mssgstring.
	 * 
	 * @param strErrMssgstring the new str err mssgstring
	 */
	public void setStrErrMssgstring(String strErrMssgstring) {
		this.strErrMssgstring = strErrMssgstring;
	}

	/**
	 * Gets the str hosp code.
	 * 
	 * @return the str hosp code
	 */
	public String getStrHospCode() {
		return strHospCode;
	}

	/**
	 * Sets the str hosp code.
	 * 
	 * @param strHospCode the new str hosp code
	 */
	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
	}

	/**
	 * Gets the str supplier grade values.
	 * 
	 * @return the str supplier grade values
	 */
	public String getStrSupplierGradeValues() {
		/*
		 * try { SupplierMstVO vo=new SupplierMstVO();
		 * //vo.setStrStoreTypeId(this.getStrStoreTypeId());
		 * vo.setStrHospCode(this.getStrHospCode());
		 * strSupplierGradeValues=vo.getStrSupplierGradeValues(); //
		 * System.out.println("strSupplierGradeValues"+strSupplierGradeValues); }
		 * catch(Exception e) { //e.printStackTrace(); }
		 */
		return strSupplierGradeValues;
	}

	/**
	 * Sets the str supplier grade values.
	 * 
	 * @param strSupplierGradeValues the new str supplier grade values
	 */
	public void setStrSupplierGradeValues(String strSupplierGradeValues) {
		this.strSupplierGradeValues = strSupplierGradeValues;
	}

	/**
	 * Gets the str commitee name values.
	 * 
	 * @return the str commitee name values
	 */
	public String getStrCommiteeNameValues() {
		/*
		 * try { SupplierMstVO vo=new SupplierMstVO();
		 * vo.setStrStoreTypeId(this.getStrStoreTypeId());
		 * vo.setStrHospCode(this.getStrHospCode());
		 * strCommiteeNameValues=vo.getStrCommiteeNameValues();
		 *  } catch(Exception e) { e.printStackTrace(); }
		 */
		return strCommiteeNameValues;
	}

	/**
	 * Sets the str commitee name values.
	 * 
	 * @param strCommiteeNameValues the new str commitee name values
	 */
	public void setStrCommiteeNameValues(String strCommiteeNameValues) {
		this.strCommiteeNameValues = strCommiteeNameValues;
	}

	/**
	 * Gets the str supplier name.
	 * 
	 * @return the str supplier name
	 */
	public String getStrSupplierName() {
		return strSupplierName;
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
	 * Gets the str supplier grade.
	 * 
	 * @return the str supplier grade
	 */
	public String getStrSupplierGrade() {
		return strSupplierGrade;
	}

	/**
	 * Sets the str supplier grade.
	 * 
	 * @param strSupplierGrade the new str supplier grade
	 */
	public void setStrSupplierGrade(String strSupplierGrade) {
		this.strSupplierGrade = strSupplierGrade;
	}

	/**
	 * Gets the str contact person.
	 * 
	 * @return the str contact person
	 */
	public String getStrContactPerson() {
		return strContactPerson;
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
	 * Gets the str address.
	 * 
	 * @return the str address
	 */
	public String getStrAddress() {
		return strAddress;
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
	 * Gets the str city.
	 * 
	 * @return the str city
	 */
	public String getStrCity() {
		return strCity;
	}

	/**
	 * Sets the str city.
	 * 
	 * @param strCity the new str city
	 */
	public void setStrCity(String strCity) {
		this.strCity = strCity;
	}

	/**
	 * Gets the str pincode.
	 * 
	 * @return the str pincode
	 */
	public String getStrPincode() {
		return strPincode;
	}

	/**
	 * Sets the str pincode.
	 * 
	 * @param strPincode the new str pincode
	 */
	public void setStrPincode(String strPincode) {
		this.strPincode = strPincode;
	}

	/**
	 * Gets the str phone no1.
	 * 
	 * @return the str phone no1
	 */
	public String getStrPhoneNo1() {
		return strPhoneNo1;
	}

	/**
	 * Sets the str phone no1.
	 * 
	 * @param strPhoneNo1 the new str phone no1
	 */
	public void setStrPhoneNo1(String strPhoneNo1) {
		this.strPhoneNo1 = strPhoneNo1;
	}

	/**
	 * Gets the str phone no2.
	 * 
	 * @return the str phone no2
	 */
	public String getStrPhoneNo2() {
		return strPhoneNo2;
	}

	/**
	 * Sets the str phone no2.
	 * 
	 * @param strPhoneNo2 the new str phone no2
	 */
	public void setStrPhoneNo2(String strPhoneNo2) {
		this.strPhoneNo2 = strPhoneNo2;
	}

	/**
	 * Gets the str email id1.
	 * 
	 * @return the str email id1
	 */
	public String getStrEmailId1() {
		return strEmailId1;
	}

	/**
	 * Sets the str email id1.
	 * 
	 * @param strEmailId1 the new str email id1
	 */
	public void setStrEmailId1(String strEmailId1) {
		this.strEmailId1 = strEmailId1;
	}

	/**
	 * Gets the str email id2.
	 * 
	 * @return the str email id2
	 */
	public String getStrEmailId2() {
		return strEmailId2;
	}

	/**
	 * Sets the str email id2.
	 * 
	 * @param strEmailId2 the new str email id2
	 */
	public void setStrEmailId2(String strEmailId2) {
		this.strEmailId2 = strEmailId2;
	}

	/**
	 * Gets the str fax no1.
	 * 
	 * @return the str fax no1
	 */
	public String getStrFaxNo1() {
		return strFaxNo1;
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
	 * Gets the str fax no2.
	 * 
	 * @return the str fax no2
	 */
	public String getStrFaxNo2() {
		return strFaxNo2;
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
	 * Gets the str website.
	 * 
	 * @return the str website
	 */
	public String getStrWebsite() {
		return strWebsite;
	}

	/**
	 * Sets the str website.
	 * 
	 * @param strWebsite the new str website
	 */
	public void setStrWebsite(String strWebsite) {
		this.strWebsite = strWebsite;
	}

	/**
	 * Gets the str supplier type.
	 * 
	 * @return the str supplier type
	 */
	public String getStrSupplierType() {
		return strSupplierType;
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
	 * Gets the str supplier status.
	 * 
	 * @return the str supplier status
	 */
	public String getStrSupplierStatus() {
		return strSupplierStatus;
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
	 * Gets the str action date.
	 * 
	 * @return the str action date
	 */
	public String getStrActionDate() {
		return strActionDate;
	}

	/**
	 * Sets the str action date.
	 * 
	 * @param strActionDate the new str action date
	 */
	public void setStrActionDate(String strActionDate) {
		this.strActionDate = strActionDate;
	}

	/**
	 * Gets the str black listed remarks.
	 * 
	 * @return the str black listed remarks
	 */
	public String getStrBlackListedRemarks() {
		return strBlackListedRemarks;
	}

	/**
	 * Sets the str black listed remarks.
	 * 
	 * @param strBlackListedRemarks the new str black listed remarks
	 */
	public void setStrBlackListedRemarks(String strBlackListedRemarks) {
		this.strBlackListedRemarks = strBlackListedRemarks;
	}

	/**
	 * Gets the str commitee.
	 * 
	 * @return the str commitee
	 */
	public String getStrCommitee() {
		return strCommitee;
	}

	/**
	 * Sets the str commitee.
	 * 
	 * @param strCommitee the new str commitee
	 */
	public void setStrCommitee(String strCommitee) {
		this.strCommitee = strCommitee;
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
	 * Gets the str chk.
	 * 
	 * @return the str chk
	 */
	public String getStrChk() {
		return strChk;
	}

	/**
	 * Sets the str chk.
	 * 
	 * @param strChk the new str chk
	 */
	public void setStrChk(String strChk) {
		this.strChk = strChk;
	}

	/**
	 * Gets the str supplier values modi.
	 * 
	 * @return the str supplier values modi
	 */
	public String getStrSupplierValuesModi() {
		return strSupplierValuesModi;
	}

	/**
	 * Sets the str supplier values modi.
	 * 
	 * @param strSupplierValuesModi the new str supplier values modi
	 */
	public void setStrSupplierValuesModi(String strSupplierValuesModi) {
		this.strSupplierValuesModi = strSupplierValuesModi;
	}

	/**
	 * Gets the str committe values modi.
	 * 
	 * @return the str committe values modi
	 */
	public String getStrCommitteValuesModi() {
		return strCommitteValuesModi;
	}

	/**
	 * Sets the str committe values modi.
	 * 
	 * @param strCommitteValuesModi the new str committe values modi
	 */
	public void setStrCommitteValuesModi(String strCommitteValuesModi) {
		this.strCommitteValuesModi = strCommitteValuesModi;
	}

	/**
	 * Gets the str local purchase supp flag.
	 * 
	 * @return the strLocalPurchaseSuppFlag
	 */
	public String getStrLocalPurchaseSuppFlag() {
		return strLocalPurchaseSuppFlag;
	}

	/**
	 * Sets the str local purchase supp flag.
	 * 
	 * @param strLocalPurchaseSuppFlag the strLocalPurchaseSuppFlag to set
	 */
	public void setStrLocalPurchaseSuppFlag(String strLocalPurchaseSuppFlag) {
		this.strLocalPurchaseSuppFlag = strLocalPurchaseSuppFlag;
	}

	/**
	 * Sets the str current date.
	 * 
	 * @param strCurrentDate the strCurrentDate to set
	 */
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}

	/**
	 * Gets the str is supplier.
	 * 
	 * @return the strIsSupplier
	 */
	public String getStrIsSupplier() {
		return strIsSupplier;
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
	 * Gets the str is manufacturer.
	 * 
	 * @return the strIsManufacturer
	 */
	public String getStrIsManufacturer() {
		return strIsManufacturer;
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
	 * Gets the str is agent.
	 * 
	 * @return the strIsAgent
	 */
	public String getStrIsAgent() {
		return strIsAgent;
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
	 * Gets the str is buyer.
	 * 
	 * @return the strIsBuyer
	 */
	public String getStrIsBuyer() {
		return strIsBuyer;
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
	 * Gets the str lst no.
	 * 
	 * @return the strLstNo
	 */
	public String getStrLstNo() {
		return strLstNo;
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
	 * Gets the str cst no.
	 * 
	 * @return the strCstNo
	 */
	public String getStrCstNo() {
		return strCstNo;
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
	 * Gets the str pan no.
	 * 
	 * @return the strPANNo
	 */
	public String getStrPANNo() {
		return strPANNo;
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
	 * Gets the str item cat no.
	 * 
	 * @return the strItemCatNo
	 */
	public String getStrItemCatNo() {
		return strItemCatNo;
	}

	/**
	 * Sets the str item cat no.
	 * 
	 * @param strItemCatNo the strItemCatNo to set
	 */
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}

	/**
	 * Gets the str item category name.
	 * 
	 * @return the strItemCategoryName
	 */
	public String getStrItemCategoryName() {
		return strItemCategoryName;
	}

	/**
	 * Sets the str item category name.
	 * 
	 * @param strItemCategoryName the strItemCategoryName to set
	 */
	public void setStrItemCategoryName(String strItemCategoryName) {
		this.strItemCategoryName = strItemCategoryName;
	}

	/**
	 * Gets the str foreigner supp flag.
	 * 
	 * @return the strForeignerSuppFlag
	 */
	public String getStrForeignerSuppFlag() {
		return strForeignerSuppFlag;
	}

	/**
	 * Sets the str foreigner supp flag.
	 * 
	 * @param strForeignerSuppFlag the strForeignerSuppFlag to set
	 */
	public void setStrForeignerSuppFlag(String strForeignerSuppFlag) {
		this.strForeignerSuppFlag = strForeignerSuppFlag;
	}

	/**
	 * Gets the str is black list mod.
	 * 
	 * @return the strIsBlackListMod
	 */
	public String getStrIsBlackListMod() {
		return strIsBlackListMod;
	}

	/**
	 * Sets the str is black list mod.
	 * 
	 * @param strIsBlackListMod the strIsBlackListMod to set
	 */
	public void setStrIsBlackListMod(String strIsBlackListMod) {
		this.strIsBlackListMod = strIsBlackListMod;
	}

	/**
	 * @return the strSupplierTypeVals
	 */
	public String getStrSupplierTypeVals() {
		return strSupplierTypeVals;
	}

	/**
	 * @param strSupplierTypeVals the strSupplierTypeVals to set
	 */
	public void setStrSupplierTypeVals(String strSupplierTypeVals) {
		this.strSupplierTypeVals = strSupplierTypeVals;
	}

	/**
	 * @return the strCountryCode
	 */
	public String getStrCountryCode() {
		return strCountryCode;
	}

	/**
	 * @param strCountryCode the strCountryCode to set
	 */
	public void setStrCountryCode(String strCountryCode) {
		this.strCountryCode = strCountryCode;
	}

	/**
	 * @return the strStateCode
	 */
	public String getStrStateCode() {
		return strStateCode;
	}

	/**
	 * @param strStateCode the strStateCode to set
	 */
	public void setStrStateCode(String strStateCode) {
		this.strStateCode = strStateCode;
	}

	/**
	 * @return the strCountryNameCombo
	 */
	public String getStrCountryNameCombo() {
		return strCountryNameCombo;
	}

	/**
	 * @param strCountryNameCombo the strCountryNameCombo to set
	 */
	public void setStrCountryNameCombo(String strCountryNameCombo) {
		this.strCountryNameCombo = strCountryNameCombo;
	}

	public String getStrSuppTurnOver() {
		return strSuppTurnOver;
	}

	public void setStrSuppTurnOver(String strSuppTurnOver) {
		this.strSuppTurnOver = strSuppTurnOver;
	}

	public String getStrSuppTurnOverUnit() {
		return strSuppTurnOverUnit;
	}

	public void setStrSuppTurnOverUnit(String strSuppTurnOverUnit) {
		this.strSuppTurnOverUnit = strSuppTurnOverUnit;
	}

	public String getStrTurnOverWithUnit() {
		return strTurnOverWithUnit;
	}

	public void setStrTurnOverWithUnit(String strTurnOverWithUnit) {
		this.strTurnOverWithUnit = strTurnOverWithUnit;
	}

	public String getStrSuppTurnOverUnitVal() {
		return strSuppTurnOverUnitVal;
	}

	public void setStrSuppTurnOverUnitVal(String strSuppTurnOverUnitVal) {
		this.strSuppTurnOverUnitVal = strSuppTurnOverUnitVal;
	}

	public String getStrLevelOneEsc() {
		return strLevelOneEsc;
	}

	public void setStrLevelOneEsc(String strLevelOneEsc) {
		this.strLevelOneEsc = strLevelOneEsc;
	}

	public String getStrLevelTwoEsc() {
		return strLevelTwoEsc;
	}

	public void setStrLevelTwoEsc(String strLevelTwoEsc) {
		this.strLevelTwoEsc = strLevelTwoEsc;
	}

	public String getStrCotactPersonForEscLevelOne() {
		return strCotactPersonForEscLevelOne;
	}

	public void setStrCotactPersonForEscLevelOne(
			String strCotactPersonForEscLevelOne) {
		this.strCotactPersonForEscLevelOne = strCotactPersonForEscLevelOne;
	}

	public String getStrContactPersonDesgForEscLevelOne() {
		return strContactPersonDesgForEscLevelOne;
	}

	public void setStrContactPersonDesgForEscLevelOne(
			String strContactPersonDesgForEscLevelOne) {
		this.strContactPersonDesgForEscLevelOne = strContactPersonDesgForEscLevelOne;
	}

	public String getStrCotactEmailIdForEscLevelOne() {
		return strCotactEmailIdForEscLevelOne;
	}

	public void setStrCotactEmailIdForEscLevelOne(
			String strCotactEmailIdForEscLevelOne) {
		this.strCotactEmailIdForEscLevelOne = strCotactEmailIdForEscLevelOne;
	}

	public String getStrCotactNoForEscLevelOne() {
		return strCotactNoForEscLevelOne;
	}

	public void setStrCotactNoForEscLevelOne(String strCotactNoForEscLevelOne) {
		this.strCotactNoForEscLevelOne = strCotactNoForEscLevelOne;
	}

	public String getStrCotactFaxForEscLevelOne() {
		return strCotactFaxForEscLevelOne;
	}

	public void setStrCotactFaxForEscLevelOne(String strCotactFaxForEscLevelOne) {
		this.strCotactFaxForEscLevelOne = strCotactFaxForEscLevelOne;
	}

	public String getStrCotactPersonForEscLevelTwo() {
		return strCotactPersonForEscLevelTwo;
	}

	public void setStrCotactPersonForEscLevelTwo(
			String strCotactPersonForEscLevelTwo) {
		this.strCotactPersonForEscLevelTwo = strCotactPersonForEscLevelTwo;
	}

	public String getStrContactPersonDesgForEscLevelTwo() {
		return strContactPersonDesgForEscLevelTwo;
	}

	public void setStrContactPersonDesgForEscLevelTwo(
			String strContactPersonDesgForEscLevelTwo) {
		this.strContactPersonDesgForEscLevelTwo = strContactPersonDesgForEscLevelTwo;
	}

	public String getStrCotactEmailIdForEscLevelTwo() {
		return strCotactEmailIdForEscLevelTwo;
	}

	public void setStrCotactEmailIdForEscLevelTwo(
			String strCotactEmailIdForEscLevelTwo) {
		this.strCotactEmailIdForEscLevelTwo = strCotactEmailIdForEscLevelTwo;
	}

	public String getStrCotactNoForEscLevelTwo() {
		return strCotactNoForEscLevelTwo;
	}

	public void setStrCotactNoForEscLevelTwo(String strCotactNoForEscLevelTwo) {
		this.strCotactNoForEscLevelTwo = strCotactNoForEscLevelTwo;
	}

	public String getStrCotactFaxForEscLevelTwo() {
		return strCotactFaxForEscLevelTwo;
	}

	public void setStrCotactFaxForEscLevelTwo(String strCotactFaxForEscLevelTwo) {
		this.strCotactFaxForEscLevelTwo = strCotactFaxForEscLevelTwo;
	}

	public String getStrEsclationAvlStatus() {
		return strEsclationAvlStatus;
	}

	public void setStrEsclationAvlStatus(String strEsclationAvlStatus) {
		this.strEsclationAvlStatus = strEsclationAvlStatus;
	}

	public String getStrSupplierProvMaintenanceStatus() {
		return strSupplierProvMaintenanceStatus;
	}

	public void setStrSupplierProvMaintenanceStatus(
			String strSupplierProvMaintenanceStatus) {
		this.strSupplierProvMaintenanceStatus = strSupplierProvMaintenanceStatus;
	}

	public String getStrLevelOneStatus() {
		return strLevelOneStatus;
	}

	public void setStrLevelOneStatus(String strLevelOneStatus) {
		this.strLevelOneStatus = strLevelOneStatus;
	}

	public String getStrLevelTwoStatus() {
		return strLevelTwoStatus;
	}

	public void setStrLevelTwoStatus(String strLevelTwoStatus) {
		this.strLevelTwoStatus = strLevelTwoStatus;
	}

}
