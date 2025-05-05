package mms.masters.controller.fb;

import hisglobal.masterutil.GenericFormBean;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreMstFB.
 */
public class StoreMstFB extends GenericFormBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The str err. */
	private String strErr = "";
	
	/** The str msg. */
	private String strMsg = "";
	
	/** The str warning. */
	private String strWarning = "";

	/** The str msg string. */
	private String strMsgString = "";
	
	/** The str msg type. */
	private String strMsgType = "";

	/** The str store type name. */
	private String strStoreTypeName = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str store id. */
	private String strStoreId = "";
	
	/** The str store type id. */
	private String strStoreTypeId = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str is valid. */
	private String strIsValid = "1";
	
	/** The str store name. */
	private String strStoreName = "";
	
	/** The str store level. */
	private String strStoreLevel = "";

	/** The str building code. */
	private String strBuildingCode = "";
	
	private String strDistrictName;
	
	/** The str emp code. */
	private String strEmpCode = "";

	/** The str block id. */
	private String strBlockId = "";
	
	/** The str floor id. */
	private String strFloorId = "";

	/** The str owner name. */
	private String strOwnerName = "";
	
	/** The str phone no. */
	private String strPhoneNo = "";
	
	/** The str owner address. */
	private String strOwnerAddress = "";
	
	/** The str dept code. */
	private String strDeptCode = "";
	
	/** The str ward code. */
	private String strWardCode = "";
	
	/** The str contact no. */
	private String strContactNo = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str owner. */
	private String strOwner = "";

	/** The str last mode seat id. */
	private String strLastModeSeatId = "";
	
	/** The str last mode date. */
	private String strLastModeDate = "";
	
	/** The str entry date. */
	private String strEntryDate = "";
	
	/** The str seat id. */
	private String strSeatId = "";

	/** The str chk1. */
	private String strChk1 = "";
	
	/** The str ct date. */
	private String strCtDate = "";

	/** The str department combo. */
	private String strDepartmentCombo = "";

	/** The str ward combo. */
	private String strWardCombo = "";

	/** The str building cmb. */
	private String strBuildingCmb = "";
	
	/** The str block cmb. */
	private String strBlockCmb = "";
	
	/** The str floor cmb. */
	private String strFloorCmb = "";

	/** The str incharge cmb. */
	private String strInchargeCmb = "";  
	
	private String strFinStartDate = "";
	private String strFinEndDate = "";
	
	private String strItemBounded="0";
	
	private String strIsNewItemFlag="1";
	private String strSection="1";
	private String strPurchasingMode="1";
	
	private String strStartDateMonth;
	private String strStartDateYear;
	private String strEndDateMonth;
	private String strEndDateYear;
	
	private boolean fTimeBoundFlag;
	private String strFromTime;
	private String strToTime;
	private String strLocation;
	private String strConfigStoreCatg;
	private String strDistrictId;
	private String strDistrictCmb;
	private String strViewFlg="0";
	
	private String strDrugWarehouseTypeId;
	private String strDrugWarehouseTypeCmb; 
	
	private String strCode="0";
	private String strNoOfBeds;
	private String strStateShortCode;
	private String strDrugWarehouseType;
	
	private String strDistrictDrugWarehouseType;
	private String strDistrictDrugWarehouseTypeCmb;
	
	/** The str left request type list. */
	private String strLeftRequestTypeList = "";
	
	/** The str right request type list. */
	private String strRightRequestTypeList = "";
	private String strRightDeptReqTypeList = "";
	
	private String strHospitalTypeCombo="";
	private String strHospitalTypeId="";
	
	
	
	public String getStrHospitalTypeCombo() {
		return strHospitalTypeCombo;
	}

	public void setStrHospitalTypeCombo(String strHospitalTypeCombo) {
		this.strHospitalTypeCombo = strHospitalTypeCombo;
	}

	public String getStrHospitalTypeId() {
		return strHospitalTypeId;
	}

	public void setStrHospitalTypeId(String strHospitalTypeId) {
		this.strHospitalTypeId = strHospitalTypeId;
	}

	public String getStrRightDeptReqTypeList() {
		return strRightDeptReqTypeList;
	}

	public void setStrRightDeptReqTypeList(String strRightDeptReqTypeList) {
		this.strRightDeptReqTypeList = strRightDeptReqTypeList;
	}

	/** The str right request types. */
	private String strRightRequestTypes[] = null;
	
	private String strRightDeptReqTypes[] = null; 
	


	public String[] getStrRightDeptReqTypes() {
		return strRightDeptReqTypes;
	}

	public void setStrRightDeptReqTypes(String[] strRightDeptReqTypes) {
		this.strRightDeptReqTypes = strRightDeptReqTypes;
	}

	private String strMappedHospCmb;
	
	private String strHeader1;
	private String strHeader2;
	private String strHeader3;
	
	private String strMapHospId;
	private String strTimeBoundFlag;
	// private String[] combo =null;
	
	private String strDLNo;
	private String strEmdType;
	private String stremdtypehidden;
	
	public String getStremdtypehidden() {
		return stremdtypehidden;
	}

	public void setStremdtypehidden(String stremdtypehidden) {
		this.stremdtypehidden = stremdtypehidden;
	}

	public String getStrEmdType() {
		return strEmdType;
	}

	public void setStrEmdType(String strEmdType) {
		this.strEmdType = strEmdType;
	}

	public String getStrDLNo() {
		return strDLNo;
	}

	public void setStrDLNo(String strDLNo) {
		this.strDLNo = strDLNo;
	}

	public String getStrTimeBoundFlag() {
		return strTimeBoundFlag;
	}

	public void setStrTimeBoundFlag(String strTimeBoundFlag) {
		this.strTimeBoundFlag = strTimeBoundFlag;
	}

	public String getStrMapHospId() {
		return strMapHospId;
	}

	public void setStrMapHospId(String strMapHospId) {
		this.strMapHospId = strMapHospId;
	}

	public String getStrHeader1() {
		return strHeader1;
	}

	public void setStrHeader1(String strHeader1) {
		this.strHeader1 = strHeader1;
	}

	public String getStrHeader2() {
		return strHeader2;
	}

	public void setStrHeader2(String strHeader2) {
		this.strHeader2 = strHeader2;
	}

	public String getStrHeader3() {
		return strHeader3;
	}

	public void setStrHeader3(String strHeader3) {
		this.strHeader3 = strHeader3;
	}

	public String getStrLeftRequestTypeList() {
		return strLeftRequestTypeList;
	}

	public void setStrLeftRequestTypeList(String strLeftRequestTypeList) {
		this.strLeftRequestTypeList = strLeftRequestTypeList;
	}

	public String getStrRightRequestTypeList() {
		return strRightRequestTypeList;
	}

	public void setStrRightRequestTypeList(String strRightRequestTypeList) {
		this.strRightRequestTypeList = strRightRequestTypeList;
	}

	public String[] getStrRightRequestTypes() {
		return strRightRequestTypes;
	}

	public void setStrRightRequestTypes(String[] strRightRequestTypes) {
		this.strRightRequestTypes = strRightRequestTypes;
	}

	/**
	 * @return the strSection
	 */
	public String getStrSection() {
		return strSection;
	}

	/**
	 * @param strSection the strSection to set
	 */
	public void setStrSection(String strSection) {
		this.strSection = strSection;
	}

	/**
	 * @return the strItemBounded
	 */
	public String getStrItemBounded() {
		return strItemBounded;
	}

	/**
	 * @param strItemBounded the strItemBounded to set
	 */
	public void setStrItemBounded(String strItemBounded) {
		this.strItemBounded = strItemBounded;
	}

	/**
	 * Gets the str err.
	 * 
	 * @return the strErr
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * Sets the str err.
	 * 
	 * @param strErr the strErr to set
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

	/**
	 * Gets the str msg.
	 * 
	 * @return the strMsg
	 */
	public String getStrMsg() {
		return strMsg;
	}

	/**
	 * Sets the str msg.
	 * 
	 * @param strMsg the strMsg to set
	 */
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}

	/**
	 * Gets the str warning.
	 * 
	 * @return the strWarning
	 */
	public String getStrWarning() {
		return strWarning;
	}

	/**
	 * Sets the str warning.
	 * 
	 * @param strWarning the strWarning to set
	 */
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}

	/**
	 * Gets the str msg string.
	 * 
	 * @return the strMsgString
	 */
	public String getStrMsgString() {
		return strMsgString;
	}

	/**
	 * Sets the str msg string.
	 * 
	 * @param strMsgString the strMsgString to set
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	/**
	 * Gets the str msg type.
	 * 
	 * @return the strMsgType
	 */
	public String getStrMsgType() {
		return strMsgType;
	}

	/**
	 * Sets the str msg type.
	 * 
	 * @param strMsgType the strMsgType to set
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	/**
	 * Gets the str store type name.
	 * 
	 * @return the strStoreTypeName
	 */
	public String getStrStoreTypeName() {
		return strStoreTypeName;
	}

	/**
	 * Sets the str store type name.
	 * 
	 * @param strStoreTypeName the strStoreTypeName to set
	 */
	public void setStrStoreTypeName(String strStoreTypeName) {
		this.strStoreTypeName = strStoreTypeName;
	}

	/**
	 * Gets the str hospital code.
	 * 
	 * @return the strHospitalCode
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	/**
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Gets the str store id.
	 * 
	 * @return the strStoreId
	 */
	public String getStrStoreId() {
		return strStoreId;
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
	 * Gets the str store type id.
	 * 
	 * @return the strStoreTypeId
	 */
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}

	/**
	 * Sets the str store type id.
	 * 
	 * @param strStoreTypeId the strStoreTypeId to set
	 */
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}

	/**
	 * Gets the str effective from.
	 * 
	 * @return the strEffectiveFrom
	 */
	public String getStrEffectiveFrom() {
		return strEffectiveFrom;
	}

	/**
	 * Sets the str effective from.
	 * 
	 * @param strEffectiveFrom the strEffectiveFrom to set
	 */
	public void setStrEffectiveFrom(String strEffectiveFrom) {
		this.strEffectiveFrom = strEffectiveFrom;
	}

	/**
	 * Gets the str is valid.
	 * 
	 * @return the strIsValid
	 */
	public String getStrIsValid() {
		return strIsValid;
	}

	/**
	 * Sets the str is valid.
	 * 
	 * @param strIsValid the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	/**
	 * Gets the str store name.
	 * 
	 * @return the strStoreName
	 */
	public String getStrStoreName() {
		return strStoreName;
	}

	/**
	 * Sets the str store name.
	 * 
	 * @param strStoreName the strStoreName to set
	 */
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}

	/**
	 * Gets the str store level.
	 * 
	 * @return the strStoreLevel
	 */
	public String getStrStoreLevel() {
		return strStoreLevel;
	}

	/**
	 * Sets the str store level.
	 * 
	 * @param strStoreLevel the strStoreLevel to set
	 */
	public void setStrStoreLevel(String strStoreLevel) {
		this.strStoreLevel = strStoreLevel;
	}

	/**
	 * Gets the str building code.
	 * 
	 * @return the strBuildingCode
	 */
	public String getStrBuildingCode() {
		return strBuildingCode;
	}

	/**
	 * Sets the str building code.
	 * 
	 * @param strBuildingCode the strBuildingCode to set
	 */
	public void setStrBuildingCode(String strBuildingCode) {
		this.strBuildingCode = strBuildingCode;
	}

	/**
	 * Gets the str emp code.
	 * 
	 * @return the strEmpCode
	 */
	public String getStrEmpCode() {
		return strEmpCode;
	}

	/**
	 * Sets the str emp code.
	 * 
	 * @param strEmpCode the strEmpCode to set
	 */
	public void setStrEmpCode(String strEmpCode) {
		this.strEmpCode = strEmpCode;
	}

	/**
	 * Gets the str block id.
	 * 
	 * @return the strBlockId
	 */
	public String getStrBlockId() {
		return strBlockId;
	}

	/**
	 * Sets the str block id.
	 * 
	 * @param strBlockId the strBlockId to set
	 */
	public void setStrBlockId(String strBlockId) {
		this.strBlockId = strBlockId;
	}

	/**
	 * Gets the str floor id.
	 * 
	 * @return the strFloorId
	 */
	public String getStrFloorId() {
		return strFloorId;
	}

	/**
	 * Sets the str floor id.
	 * 
	 * @param strFloorId the strFloorId to set
	 */
	public void setStrFloorId(String strFloorId) {
		this.strFloorId = strFloorId;
	}

	/**
	 * Gets the str owner name.
	 * 
	 * @return the strOwnerName
	 */
	public String getStrOwnerName() {
		return strOwnerName;
	}

	/**
	 * Sets the str owner name.
	 * 
	 * @param strOwnerName the strOwnerName to set
	 */
	public void setStrOwnerName(String strOwnerName) {
		this.strOwnerName = strOwnerName;
	}

	/**
	 * Gets the str phone no.
	 * 
	 * @return the strPhoneNo
	 */
	public String getStrPhoneNo() {
		return strPhoneNo;
	}

	/**
	 * Sets the str phone no.
	 * 
	 * @param strPhoneNo the strPhoneNo to set
	 */
	public void setStrPhoneNo(String strPhoneNo) {
		this.strPhoneNo = strPhoneNo;
	}

	/**
	 * Gets the str owner address.
	 * 
	 * @return the strOwnerAddress
	 */
	public String getStrOwnerAddress() {
		return strOwnerAddress;
	}

	/**
	 * Sets the str owner address.
	 * 
	 * @param strOwnerAddress the strOwnerAddress to set
	 */
	public void setStrOwnerAddress(String strOwnerAddress) {
		this.strOwnerAddress = strOwnerAddress;
	}

	/**
	 * Gets the str dept code.
	 * 
	 * @return the strDeptCode
	 */
	public String getStrDeptCode() {
		return strDeptCode;
	}

	/**
	 * Sets the str dept code.
	 * 
	 * @param strDeptCode the strDeptCode to set
	 */
	public void setStrDeptCode(String strDeptCode) {
		this.strDeptCode = strDeptCode;
	}

	/**
	 * Gets the str contact no.
	 * 
	 * @return the strContactNo
	 */
	public String getStrContactNo() {
		return strContactNo;
	}

	/**
	 * Sets the str contact no.
	 * 
	 * @param strContactNo the strContactNo to set
	 */
	public void setStrContactNo(String strContactNo) {
		this.strContactNo = strContactNo;
	}

	/**
	 * Gets the str remarks.
	 * 
	 * @return the strRemarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * Gets the str owner.
	 * 
	 * @return the strOwner
	 */
	public String getStrOwner() {
		return strOwner;
	}

	/**
	 * Sets the str owner.
	 * 
	 * @param strOwner the strOwner to set
	 */
	public void setStrOwner(String strOwner) {
		this.strOwner = strOwner;
	}

	/**
	 * Gets the str last mode seat id.
	 * 
	 * @return the strLastModeSeatId
	 */
	public String getStrLastModeSeatId() {
		return strLastModeSeatId;
	}

	/**
	 * Sets the str last mode seat id.
	 * 
	 * @param strLastModeSeatId the strLastModeSeatId to set
	 */
	public void setStrLastModeSeatId(String strLastModeSeatId) {
		this.strLastModeSeatId = strLastModeSeatId;
	}

	/**
	 * Gets the str last mode date.
	 * 
	 * @return the strLastModeDate
	 */
	public String getStrLastModeDate() {
		return strLastModeDate;
	}

	/**
	 * Sets the str last mode date.
	 * 
	 * @param strLastModeDate the strLastModeDate to set
	 */
	public void setStrLastModeDate(String strLastModeDate) {
		this.strLastModeDate = strLastModeDate;
	}

	/**
	 * Gets the str entry date.
	 * 
	 * @return the strEntryDate
	 */
	public String getStrEntryDate() {
		return strEntryDate;
	}

	/**
	 * Sets the str entry date.
	 * 
	 * @param strEntryDate the strEntryDate to set
	 */
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}

	/**
	 * Gets the str seat id.
	 * 
	 * @return the strSeatId
	 */
	public String getStrSeatId() {
		return strSeatId;
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
	 * Gets the str chk1.
	 * 
	 * @return the strChk1
	 */
	public String getStrChk1() {
		return strChk1;
	}

	/**
	 * Sets the str chk1.
	 * 
	 * @param strChk1 the strChk1 to set
	 */
	public void setStrChk1(String strChk1) {
		this.strChk1 = strChk1;
	}

	/**
	 * Gets the str department combo.
	 * 
	 * @return the strDepartmentCombo
	 */
	public String getStrDepartmentCombo() {
		return strDepartmentCombo;
	}

	/**
	 * Sets the str department combo.
	 * 
	 * @param strDepartmentCombo the strDepartmentCombo to set
	 */
	public void setStrDepartmentCombo(String strDepartmentCombo) {
		this.strDepartmentCombo = strDepartmentCombo;
	}

	/**
	 * Gets the str building cmb.
	 * 
	 * @return the strBuildingCmb
	 */
	public String getStrBuildingCmb() {
		return strBuildingCmb;
	}

	/**
	 * Sets the str building cmb.
	 * 
	 * @param strBuildingCmb the strBuildingCmb to set
	 */
	public void setStrBuildingCmb(String strBuildingCmb) {
		this.strBuildingCmb = strBuildingCmb;
	}

	/**
	 * Gets the str block cmb.
	 * 
	 * @return the strBlockCmb
	 */
	public String getStrBlockCmb() {
		return strBlockCmb;
	}

	/**
	 * Sets the str block cmb.
	 * 
	 * @param strBlockCmb the strBlockCmb to set
	 */
	public void setStrBlockCmb(String strBlockCmb) {
		this.strBlockCmb = strBlockCmb;
	}

	/**
	 * Gets the str floor cmb.
	 * 
	 * @return the strFloorCmb
	 */
	public String getStrFloorCmb() {
		return strFloorCmb;
	}

	/**
	 * Sets the str floor cmb.
	 * 
	 * @param strFloorCmb the strFloorCmb to set
	 */
	public void setStrFloorCmb(String strFloorCmb) {
		this.strFloorCmb = strFloorCmb;
	}

	/**
	 * Gets the str incharge cmb.
	 * 
	 * @return the strInchargeCmb
	 */
	public String getStrInchargeCmb() {
		return strInchargeCmb;
	}

	/**
	 * Sets the str incharge cmb.
	 * 
	 * @param strInchargeCmb the strInchargeCmb to set
	 */
	public void setStrInchargeCmb(String strInchargeCmb) {
		this.strInchargeCmb = strInchargeCmb;
	}

	/**
	 * Gets the serial version uid.
	 * 
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * Gets the str ct date.
	 * 
	 * @return the strCtDate
	 */
	public String getStrCtDate() {
		return strCtDate;
	}

	/**
	 * Sets the str ct date.
	 * 
	 * @param strCtDate the strCtDate to set
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}

	/**
	 * Gets the str ward code.
	 * 
	 * @return the strWardCode
	 */
	public String getStrWardCode() {
		return strWardCode;
	}

	/**
	 * Sets the str ward code.
	 * 
	 * @param strWardCode the strWardCode to set
	 */
	public void setStrWardCode(String strWardCode) {
		this.strWardCode = strWardCode;
	}

	/**
	 * Gets the str ward combo.
	 * 
	 * @return the strWardCombo
	 */
	public String getStrWardCombo() {
		return strWardCombo;
	}

	/**
	 * Sets the str ward combo.
	 * 
	 * @param strWardCombo the strWardCombo to set
	 */
	public void setStrWardCombo(String strWardCombo) {
		this.strWardCombo = strWardCombo;
	}

	/**
	 * @return the strFinStartDate
	 */
	public String getStrFinStartDate() {
		return strFinStartDate;
	}

	/**
	 * @param strFinStartDate the strFinStartDate to set
	 */
	public void setStrFinStartDate(String strFinStartDate) {
		this.strFinStartDate = strFinStartDate;
	}

	/**
	 * @return the strFinEndDate
	 */
	public String getStrFinEndDate() {
		return strFinEndDate;
	}

	/**
	 * @param strFinEndDate the strFinEndDate to set
	 */
	public void setStrFinEndDate(String strFinEndDate) {
		this.strFinEndDate = strFinEndDate;
	}

	/**
	 * @return the strIsNewItemFlag
	 */
	public String getStrIsNewItemFlag() {
		return strIsNewItemFlag;
	}

	/**
	 * @param strIsNewItemFlag the strIsNewItemFlag to set
	 */
	public void setStrIsNewItemFlag(String strIsNewItemFlag) {
		this.strIsNewItemFlag = strIsNewItemFlag;
	}

	/**
	 * @return the strPurchasingMode
	 */
	public String getStrPurchasingMode() {
		return strPurchasingMode;
	}

	/**
	 * @param strPurchasingMode the strPurchasingMode to set
	 */
	public void setStrPurchasingMode(String strPurchasingMode) {
		this.strPurchasingMode = strPurchasingMode;
	}

	/**
	 * @return the strStartDateMonth
	 */
	public String getStrStartDateMonth() {
		return strStartDateMonth;
	}

	/**
	 * @param strStartDateMonth the strStartDateMonth to set
	 */
	public void setStrStartDateMonth(String strStartDateMonth) {
		this.strStartDateMonth = strStartDateMonth;
	}

	/**
	 * @return the strStartDateYear
	 */
	public String getStrStartDateYear() {
		return strStartDateYear;
	}

	/**
	 * @param strStartDateYear the strStartDateYear to set
	 */
	public void setStrStartDateYear(String strStartDateYear) {
		this.strStartDateYear = strStartDateYear;
	}

	/**
	 * @return the strEndDateMonth
	 */
	public String getStrEndDateMonth() {
		return strEndDateMonth;
	}

	/**
	 * @param strEndDateMonth the strEndDateMonth to set
	 */
	public void setStrEndDateMonth(String strEndDateMonth) {
		this.strEndDateMonth = strEndDateMonth;
	}

	/**
	 * @return the strEndDateYear
	 */
	public String getStrEndDateYear() {
		return strEndDateYear;
	}

	/**
	 * @param strEndDateYear the strEndDateYear to set
	 */
	public void setStrEndDateYear(String strEndDateYear) {
		this.strEndDateYear = strEndDateYear;
	}

	/**
	 * @return the fTimeBoundFlag
	 */
	public boolean isfTimeBoundFlag() {
		return fTimeBoundFlag;
	}

	/**
	 * @param fTimeBoundFlag the fTimeBoundFlag to set
	 */
	public void setfTimeBoundFlag(boolean fTimeBoundFlag) {
		this.fTimeBoundFlag = fTimeBoundFlag;
	}

	/**
	 * @return the strFromTime
	 */
	public String getStrFromTime() {
		return strFromTime;
	}

	/**
	 * @param strFromTime the strFromTime to set
	 */
	public void setStrFromTime(String strFromTime) {
		this.strFromTime = strFromTime;
	}

	/**
	 * @return the strToTime
	 */
	public String getStrToTime() {
		return strToTime;
	}

	/**
	 * @param strToTime the strToTime to set
	 */
	public void setStrToTime(String strToTime) {
		this.strToTime = strToTime;
	}

	public String getStrLocation() {
		return strLocation;
	}

	public void setStrLocation(String strLocation) {
		this.strLocation = strLocation;
	}

	public String getStrConfigStoreCatg() {
		return strConfigStoreCatg;
	}

	public void setStrConfigStoreCatg(String strConfigStoreCatg) {
		this.strConfigStoreCatg = strConfigStoreCatg;
	}

	public String getStrDistrictId() {
		return strDistrictId;
	}

	public void setStrDistrictId(String strDistrictId) {
		this.strDistrictId = strDistrictId;
	}

	public String getStrDistrictCmb() {
		return strDistrictCmb;
	}

	public void setStrDistrictCmb(String strDistrictCmb) {
		this.strDistrictCmb = strDistrictCmb;
	}

	public String getStrViewFlg() {
		return strViewFlg;
	}

	public void setStrViewFlg(String strViewFlg) {
		this.strViewFlg = strViewFlg;
	}

	public String getStrDistrictName() {
		return strDistrictName;
	}

	public void setStrDistrictName(String strDistrictName) {
		this.strDistrictName = strDistrictName;
	}

	public String getStrDrugWarehouseTypeId() {
		return strDrugWarehouseTypeId;
	}

	public void setStrDrugWarehouseTypeId(String strDrugWarehouseTypeId) {
		this.strDrugWarehouseTypeId = strDrugWarehouseTypeId;
	}

	public String getStrDrugWarehouseTypeCmb() {
		return strDrugWarehouseTypeCmb;
	}

	public void setStrDrugWarehouseTypeCmb(String strDrugWarehouseTypeCmb) {
		this.strDrugWarehouseTypeCmb = strDrugWarehouseTypeCmb;
	}

	public String getStrCode() {
		return strCode;
	}

	public void setStrCode(String strCode) {
		this.strCode = strCode;
	}

	public String getStrNoOfBeds() {
		return strNoOfBeds;
	}

	public void setStrNoOfBeds(String strNoOfBeds) {
		this.strNoOfBeds = strNoOfBeds;
	}

	public String getStrStateShortCode() {
		return strStateShortCode;
	}

	public void setStrStateShortCode(String strStateShortCode) {
		this.strStateShortCode = strStateShortCode;
	}

	public String getStrDrugWarehouseType() {
		return strDrugWarehouseType;
	}

	public void setStrDrugWarehouseType(String strDrugWarehouseType) {
		this.strDrugWarehouseType = strDrugWarehouseType;
	}

	public String getStrDistrictDrugWarehouseType() {
		return strDistrictDrugWarehouseType;
	}

	public void setStrDistrictDrugWarehouseType(String strDistrictDrugWarehouseType) {
		this.strDistrictDrugWarehouseType = strDistrictDrugWarehouseType;
	}

	public String getStrDistrictDrugWarehouseTypeCmb() {
		return strDistrictDrugWarehouseTypeCmb;
	}

	public void setStrDistrictDrugWarehouseTypeCmb(
			String strDistrictDrugWarehouseTypeCmb) {
		this.strDistrictDrugWarehouseTypeCmb = strDistrictDrugWarehouseTypeCmb;
	}

	public String getStrMappedHospCmb() {
		return strMappedHospCmb;
	}

	public void setStrMappedHospCmb(String strMappedHospCmb) {
		this.strMappedHospCmb = strMappedHospCmb;
	}

}
