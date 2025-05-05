package mms.masters.vo;

import hisglobal.utility.TransferObject;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierMstVO.
 */
public class SupplierMstVO implements TransferObject {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The str msg string. */
	private String strMsgString = "";

	/** The str msg type. */
	private String strMsgType = "0";

	private String pack_size = "0";
	
	private String supplier_interface_required="0";
	/** The str item cat no. */
	private String strItemCatNo = "";
	
	/** The str supplier id. */
	private String strSupplierId = "";
	
	/** The str item category name. */
	private String strItemCategoryName = "";
	// private String strStoreTypeId="";
	/** The str hosp code. */
	private String strHospCode = "";
	// private String strStoreTypeName="";
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
	// private String strRateContractFromDate="";
	// private String strRateContractToDate="";
	// private String strOrderNo="";
	// private String strOrderDate="";
	// private String strIsSupplierBlackListed="";
	/** The str action date. */
	private String strActionDate = "";
	
	/** The str black listed remarks. */
	private String strBlackListedRemarks = "";
	
	/** The str commitee. */
	private String strCommitee = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str chk. */
	private String strChk = "";
	
	/** The str supplier grade code. */
	private String strSupplierGradeCode = "0";
	
	/** The str supplier status code. */
	private String strSupplierStatusCode = "0";
	
	/** The str supplier type code. */
	private String strSupplierTypeCode = "0";
	
	/** The str is valid. */
	private String strIsValid = "1";
	
	/** The str committe code. */
	private String strCommitteCode = "0";
	
	/** The str warn ms type. */
	private String strWarnMsType = "0";
	
	/** The str commitee name values. */
	private String strCommiteeNameValues = "";
	
	/** The str supplier grade values. */
	private String strSupplierGradeValues = "";
	
	/** The str is black list mod. */
	private String strIsBlackListMod = "";
	
	/** The Is flag. */
	private Boolean IsFlag = false;
	
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
	
	/** The str Country Code no. */
	private String strCountryCode = "";
	
	/** The str State Code no. */
	private String strStateCode = "";

	
	private String strSupplierTypeVals="";
	
	/*Aritra*/
	private String strContractNo = "";
	
	private String strContractDate = "";
	
	private String strExpiryDate ="";
	private String 	strSuppTurnOver;
	private String 	strSuppTurnOverUnit;
	
	private String strSupplierProvMaintenance;
	
    private String strEsclationMtxAvl;
    
    private String strLevelOneEsc;
    
    private String strLevelTwoEsc;    
    
    private String[]    strCotactPersonForEsc=null;

    private String[]    strContactPersonDesgForEsc=null;

    private String[]   strCotactEmailIdForEsc=null;

    private String[]   strCotactNoForEsc=null;

    private String[]   strCotactFaxForEsc=null;
	
	
	/** ************************************************************************* WebRow set Declaration Here ************************************************************************. */
	private WebRowSet supplierGradeWS = null;
	
	/** The commitee name ws. */
	private WebRowSet commiteeNameWS = null;
	
	/** The Country name ws. */
	private WebRowSet countryNameWS = null;

	/** The State name ws. */
	private WebRowSet stateNameWS = null;

	
	
	private WebRowSet wsSupplierType = null;

	
	private String strSlNo;
	private String strWhetherSupplierInterfacerequired="0";
 
    

	// private String[] combo =null;

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

	/**
	 * Gets the supplier grade ws.
	 * 
	 * @return the supplier grade ws
	 */
	public WebRowSet getSupplierGradeWS() {
		return supplierGradeWS;
	}

	/**
	 * Sets the supplier grade ws.
	 * 
	 * @param supplierGradeWS the new supplier grade ws
	 */
	public void setSupplierGradeWS(WebRowSet supplierGradeWS) {
		this.supplierGradeWS = supplierGradeWS;
	}

	/* (non-Javadoc)
	 * @see hisglobal.utility.TransferObject#getStrMsgString()
	 */
	public String getStrMsgString() {
		return strMsgString;
	}

	/* (non-Javadoc)
	 * @see hisglobal.utility.TransferObject#setStrMsgString(java.lang.String)
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	/* (non-Javadoc)
	 * @see hisglobal.utility.TransferObject#getStrMsgType()
	 */
	public String getStrMsgType() {
		return strMsgType;
	}

	/* (non-Javadoc)
	 * @see hisglobal.utility.TransferObject#setStrMsgType(java.lang.String)
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
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
	 * Gets the commitee name ws.
	 * 
	 * @return the commitee name ws
	 */
	public WebRowSet getCommiteeNameWS() {
		return commiteeNameWS;
	}

	/**
	 * Sets the commitee name ws.
	 * 
	 * @param commiteeNameWS the new commitee name ws
	 */
	public void setCommiteeNameWS(WebRowSet commiteeNameWS) {
		this.commiteeNameWS = commiteeNameWS;
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
	 * Gets the str supplier grade code.
	 * 
	 * @return the str supplier grade code
	 */
	public String getStrSupplierGradeCode() {
		return strSupplierGradeCode;
	}

	/**
	 * Sets the str supplier grade code.
	 * 
	 * @param strSupplierGradeCode the new str supplier grade code
	 */
	public void setStrSupplierGradeCode(String strSupplierGradeCode) {
		this.strSupplierGradeCode = strSupplierGradeCode;
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
	 * Gets the str supplier type code.
	 * 
	 * @return the str supplier type code
	 */
	public String getStrSupplierTypeCode() {
		return strSupplierTypeCode;
	}

	/**
	 * Sets the str supplier type code.
	 * 
	 * @param strSupplierTypeCode the new str supplier type code
	 */
	public void setStrSupplierTypeCode(String strSupplierTypeCode) {
		this.strSupplierTypeCode = strSupplierTypeCode;
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
	 * Gets the str committe code.
	 * 
	 * @return the str committe code
	 */
	public String getStrCommitteCode() {
		return strCommitteCode;
	}

	/**
	 * Sets the str committe code.
	 * 
	 * @param strCommitteCode the new str committe code
	 */
	public void setStrCommitteCode(String strCommitteCode) {
		this.strCommitteCode = strCommitteCode;
	}

	/**
	 * Gets the str warn ms type.
	 * 
	 * @return the str warn ms type
	 */
	public String getStrWarnMsType() {
		return strWarnMsType;
	}

	/**
	 * Sets the str warn ms type.
	 * 
	 * @param strWarnMsType the new str warn ms type
	 */
	public void setStrWarnMsType(String strWarnMsType) {
		this.strWarnMsType = strWarnMsType;
	}

	/**
	 * Gets the str commitee name values.
	 * 
	 * @return the str commitee name values
	 */
	public String getStrCommiteeNameValues() {
		/*
		 * try { HisUtil util = new HisUtil("Supplier Master",
		 * "SupplierMstDATA"); SupplierMstDAO.getCommiteeDtl(this);
		 * strCommiteeNameValues = util.getOptionValue(this.getCommiteeNameWS(),
		 * "0", "0^Select Value", false); } catch(Exception e) {
		 *  }
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
	 * Gets the str supplier grade values.
	 * 
	 * @return the str supplier grade values
	 */
	public String getStrSupplierGradeValues() {
		/*
		 * try { HisUtil util = new HisUtil("Supplier Master",
		 * "SupplierMstDATA"); SupplierMstDAO.getSupplierGrade(this);
		 * strSupplierGradeValues =
		 * util.getOptionValue(this.getSupplierGradeWS(), "0", "0^Select Value",
		 * false); } catch(Exception e) {
		 *  }
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
	 * Gets the checks if is flag.
	 * 
	 * @return the checks if is flag
	 */
	public Boolean getIsFlag() {
		return IsFlag;
	}

	/**
	 * Sets the checks if is flag.
	 * 
	 * @param isFlag the new checks if is flag
	 */
	public void setIsFlag(Boolean isFlag) {
		IsFlag = isFlag;
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
	 * Gets the str supplier id.
	 * 
	 * @return the strSupplierId
	 */
	public String getStrSupplierId() {
		return strSupplierId;
	}

	/**
	 * Sets the str supplier id.
	 * 
	 * @param strSupplierId the strSupplierId to set
	 */
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
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
	 * @return the wsSupplierType
	 */
	public WebRowSet getWsSupplierType() {
		return wsSupplierType;
	}

	/**
	 * @param wsSupplierType the wsSupplierType to set
	 */
	public void setWsSupplierType(WebRowSet wsSupplierType) {
		this.wsSupplierType = wsSupplierType;
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
	 * @return the countryNameWS
	 */
	public WebRowSet getCountryNameWS() {
		return countryNameWS;
	}

	/**
	 * @param countryNameWS the countryNameWS to set
	 */
	public void setCountryNameWS(WebRowSet countryNameWS) {
		this.countryNameWS = countryNameWS;
	}

	/**
	 * @return the stateNameWS
	 */
	public WebRowSet getStateNameWS() {
		return stateNameWS;
	}

	/**
	 * @param stateNameWS the stateNameWS to set
	 */
	public void setStateNameWS(WebRowSet stateNameWS) {
		this.stateNameWS = stateNameWS;
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


	public String getpack_size() {
		return pack_size;
	}

	/* (non-Javadoc)
	 * @see hisglobal.utility.TransferObject#setStrMsgType(java.lang.String)
	 */
	public void setpack_size(String pack_size) {
		this.pack_size = pack_size;
	}
	public String getsupplier_interface_required() {
		return supplier_interface_required;
	}

	/* (non-Javadoc)
	 * @see hisglobal.utility.TransferObject#setStrMsgType(java.lang.String)
	 */
	public void setsupplier_interface_required(String pack_size) {
		this.supplier_interface_required = supplier_interface_required;
	}
}
