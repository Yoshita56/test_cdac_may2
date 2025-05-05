package billing;

import hisglobal.utility.TransferObject;

import javax.sql.rowset.WebRowSet;

import org.apache.struts.upload.FormFile;

public class CashCollectionOfflineTransVO implements TransferObject {

	private static final long serialVersionUID = 02L;

	private String strMsgString = "";
	private String strMsgType = "0";
    private String strErrMsg = "";
	private String strCurrentDate = "";
	
	private String strHospitalCode = "0";

	private String strPreviousCrNo = "";
	
	private String strVisitType;
		
	public String getStrVisitType() {
		return strVisitType;
	}

	public void setStrVisitType(String strVisitType) {
		this.strVisitType = strVisitType;
	}
	private String strModuleId = "0";
	private String strIpAddress = "0";
	private String strGroupId = "0";
	private String strQtyUnitId = "0";
	private String strUserLevel = "0";
	private String strCounterId = "0";
	private WebRowSet strQRCodeModeList = null;
	
	private String strBillNo = "0";
	private String strReceiptNo = "0";
	private String strRefundReceiptNo = "0";
	
	private String strOffLineRefundAdvanceAccountNo = "0";
	
	private String strPreviousCrNoDtlFlag = "0";
	
	private String strPreviousCrNoPatientDtls = "";
	
	private String strClerkDiscount = "0";
	
	private String strIsApprovalRequired = "0";
	
	private String strIsAdvanceRequired = "0";
	
	
	private String strCrNo = "";
	private String strAdmissionNo = "";
	private String strAccountNo = "";
	private String strTreatmentCategory = "";
	private String strRequestFor = "";
	private String strRequestNo = "";
	private String strRequestDate = "";
	private String strGlobalRequestNo = "";
	private String strClientPatientNo = "";
	private String strChargeTypeId = "";
	private String strBillingService = "";
	private String strService = "0";
	private String strChargeTypeName = "";
	private String strRequestType = "";
	private String strEpisode = "";
	private String strRaisingDepartment = "0";
	private String strWard = "0";
	private String strSearchLetter = "";
	private String strIpdChargeTypeId = "0";
	private String strSancAmount = "0";
	private String strPatientReceivedAmount = "0";
	private String strClientName = "";
	private String strClientType = "0";
	private String strClientApprovalNo = "0";
	private String strClientPayiedBy = "0";
	private String strClientBalance = "0";
	private String strClientAmount = "0";
	private String strAdvanceAmount = "0";
	private String strPartPaymentAmount = "0";
	private String strRemarks = "";
	private String strApprovalId = "0";
	private String strApprovedBy = "";
	private String strApprovedDate = "";
	
 
	
	private String strTotalTariffServiceTaxAmount = "0";
	private String strTotalTariffDiscountAmount = "0";
	private String strTotalTariffActualAmount = "0";
	private String strTotalTariffPenaltyAmount = "0";
	
	private String strRefundAdvancePenelty = "0";
	
	
	private String strExpenseAmount = "0";
	private String strNetClientAmount = "0";
	private String strNetDiscountAmount = "0";
	private String strNetServiceTaxAmount = "0";
	private String strNetPaybleAmount = "0";
	private String strDiscountType = "0";
	private String strDiscountUnit = "0";
	private String strServiceTax = "0";
	
	// used for direct tariff list print 
	
	private String[] strTariffDetailsId = null;
	private String[] strBillTariffName = null;
	private String[] strTariffServiceTaxAmt = null;
	private String[] strTariffRate = null;
	private String[] strTariffActualAmt = null;
	private String[] strTariffReqQty = null;
	private String[] strTariffBilledQty = null; // important
	//private String[] strBillTariffUnit = null;
	private String[] strTariffDiscountAmt = null;
	private String[] strTariffNetAmt = null;
	private String[] strTariffPenaltyAmt = null;
	
	private String[] strTariffRefundDetailsId = null;
//	private String[] strRefundTariffDetails = null;
	private String[] strTariffToBeRefundQty = null;
	private String[] strTariffRefundQty = null;
	private String[] strTariffRefundUnit = null;
	private String[] strTariffRefundCost = null;
		
	private String[] strOnlinePaymentMode = null;
	private String[] strOnlinePaymentDtls = null;
	private String[] strOnlineAmount = null;

	private String strTariffCode = "0";
	
	private String strOffLineHospitalService = "";
	private String strOffLineBillingService = "";
	private String strOffLineRequestType = "1";
	private String strOffLineRaisingDepartment = "";
	private String strOffLineEpisode = "";
	private String strOffLineTreatmentCategory = "";
	private String strOffLineTreatmentCategoryGroup = "0";
	private String strOffLineWard = "";
	private String strOffLineSpecialWard = "0";
	private String strOffLineApprovedBy = "";
	private String strOffLineRemarks = "";
	private String strOffLinePartPaymentAmount = "";
	private String strOffLineAdvanceAmount = "";
	private String strOffLineClientPatientNo = "";
	private String strOffLineAccountNo = "";
	private String strOffLineTreatmentCat = "";
	private String strOffLineClientPatientHidden = "";
	
	private String strOffLineAdmissionNo = "0";
	
	private String strOffLineClientType = "0";
	private String strOffLineSancAmount = "0";
	private String strOffLineApprovalNo = "0";
	private String strOffLineBalanceAmount = "0";
	
	private String strOfflineClientName = "";
	private String strOfflineClientPayiedBy = "0";
	
	private String strOfflineClientDetails = "";
	
	private String strOffLineIpdChargeTypeId = "0";
	
	private String strChk_value = "0";
	//Adavnce Security Flag added by garima for HIS_PGI_BILL_CR_1on 17 Aug 2011
	private String advSecFlag = "0";
	
	private String strApprovedByCombo = "0";
	private String strRemarksCombo2 = "";
	
	private String strOffLineTariffUnitTempId = "0";
	private String strOffLineBillNumber = "0";
	private String strOffLineTariffDetailsHiddenValue = "0";

	private String strOffLineRefundPenalty = "0";

	private String strOffLineIsPackageGroup = "0";

	private String strOffLinePackageIndex = "0";

	private String strOffLineGroup = "0";
	private String strOffLinePakageGroup = "0";
	private String strOfflineTariffName[] = null;
	private String strOfflineTariffDiscountApprovedBy = "";
	private String strOfflineTariffDiscountRemarks = "";

	private String[] strOfflineTariffDetailsHidden = null;
	private String[] strOfflineTariffQty = null;
	private String[] strOfflineTariffUnit = null;
	private String[] strOfflineTariffServiceTax = null;
	private String[] strOfflineTariffDiscount = null;
	private String[] strOfflineTariffDiscountConfigDetails = null;
	private String[] strOfflineTariffNetAmount = null;
	private String[] strOfflineAmtPaidByClient = null;
	private String[] strOfflineTariffServiceTaxAmtVal = null;
	private String[] strOfflineTariffDiscountAmtVal = null;
	private String[] strOfflineTotalActualTariffAmtVal = null;
	
	
	private String strOfflineRefundTotalServiceTaxAmount = "0";
	private String strOfflineRefundTotalDiscountAmount = "0";
	private String strOfflineRefundTotalPenaltyAmount = "0";
	private String strOfflineRefundTotalActualTariffAmount = "0";
	
	
	private String strOfflineRefundBillDetails = "";
	
	private String strOffLineRefundBy = "0";
	
	private String strOffLineRefundReason = "0";
	private String strOffLineRefundReasonText = "";
	private String strOfflineRefundDate = "";
	
	private String strAdmissionCancellationPenalty = "0";
	private String strRefundAdvancePaneltyAmt = "0";
	
	
	
	private String[] strBillTariffVal = null;
	private String[] strBillTariffPenaltyType = null;
	private String[] strBillTariffPenalty = null;
	private String[] strBillTariffRefund = null;
	private String[] strBillTariffUnit = null;
	
	private String[] strOfflineRefundServiceTaxAmount = null;
	private String[] strOfflineRefundDiscountAmount = null;
	private String[] strOfflineRefundPenaltyAmount = null;
	private String[] strOfflineRefundActualTariffAmount = null;
	private String[] strBillTariffRefundAmount = null;
	
	private String[] strOfflinePaymentMode = null;
	private String[] strOfflinePaymentDtls = null;
	private String[] strOfflineAmount = null;

	private WebRowSet onlineDetails = null;
	private WebRowSet onlineClientDetails = null;
	private WebRowSet onlineTariffDetails = null;

	private WebRowSet strPaymentModeList = null;
	private WebRowSet strClientNameList = null;
	
	private WebRowSet admissionCancellationDetails = null;

	private WebRowSet offlineHospitalServiceList = null;
	private WebRowSet offlineBillingServiceList = null;
	private WebRowSet offlineRaisingDepartmentList = null;
	private WebRowSet offlineEpisodeList = null;
	private WebRowSet offlineTreatmentCategoryList = null;
	private WebRowSet offlineWardList = null;
	private WebRowSet offlineSplWardList = null;
	private WebRowSet offlineApprovedByList = null;
	private WebRowSet offlineRemarksList = null;
	private WebRowSet offlineClientDetails = null;
	private WebRowSet offlineGroupList = null;
	private WebRowSet offlineTariffList = null;
	private WebRowSet offlinePackageGroup = null;
	private WebRowSet offlineTariffUnit = null;

	private WebRowSet offlineBillList = null;
	private WebRowSet offlineBillTariffList = null;

	private WebRowSet offlineDiscountApprovedBy = null;
	private WebRowSet offlineDiscountRemarks = null;

	private String strOfflineTotalRecAmount = "0";
	private String strOfflineTotalPayAmount = "0";
	private String strOfflineRefundAmount = "0";
	private String strOfflineMaxClientBenefitAmount = "0";
	private String strOfflinePatNetPayAmount = "0";
	private String strOfflineTotalActualTariffAmount = "0";
	
	private String strOfflineTotalServiceTaxAmount = "0";
	private String strOfflineTotalDiscountAmount = "0";
	
	private String strBillSearchString = "";
	private String strBillFromRow = "";
	private String strBillToRow = "";
	private String strBillRowPerPage = "";
	private String strBillCtBlockSet = "";

	 
	
	private WebRowSet strRequestNoList = null;
	
	private WebRowSet billSearchList = null;

	private String strSeatId = "0";

	private String strErrPrimKeyLog = "";
	
	

	private String strRmk="";//waiver by
	private String  strRelationWs="";
	//private String strEmployeeId="";
	//private String strEmployeeName="";
	//private String strRelationId="";
	//private String strPayClientName;
	
	private String[] strCreditLetterNo;
    //private String[] strCreditRefDate1;
    private String[] strCreditPaymentType;
	//for storing path of file
    private FormFile[] uploadedFile =new FormFile[100]; 
    private String scanDocID;//with what name file is saved..
    private WebRowSet creditLettersWS = null;
    private String strNewCreditLetterAddedFlag="0";
    
    private String[] strCreditFilePath;	
    private String strCreditBillApprovalDone="0";//0-Not Required,1-Done,2-Not Required Direct (Without Approval)
    
    
    private WebRowSet admEpisodeTreatCatDeptDtls = null;
    private String strWalletNo="";
	private String strAvlWalletMoney="0";
	private String strMobileNo="";
	private String strRoomLimit="0";
	private WebRowSet packageComboValuesWs=null;
	private String strPackageApply = "";
	private String strPackAppDate= "";
	private String[] strOfflineTariffRateUnit = null;
	private String strAdmissionDate= "";
	private String strAdvCancelRefund="";
	private String accountCatDivCheked = "";
	private String accountCategory = "";
	private String accountCategoryList = "";
	private WebRowSet accCatWs = null;
	private String isAdvanceZero="";
	private double MoreThanAdv=0;
	private WebRowSet advanceDtls=null;
    
    /*public String getStrPayClientName() {
  		return strPayClientName;
  	}

  	public void setStrPayClientName(String strPayClientName) {
  		this.strPayClientName = strPayClientName;
  	}
  

	
	public String getStrRelationId() {
		return strRelationId;
	}

	public void setStrRelationId(String strRelationId) {
		this.strRelationId = strRelationId;
	}*/

	public WebRowSet getPackageComboValuesWs() {
		return packageComboValuesWs;
	}

	public void setPackageComboValuesWs(WebRowSet packageComboValuesWs) {
		this.packageComboValuesWs = packageComboValuesWs;
	}

	public String getStrPackageApply() {
		return strPackageApply;
	}

	public void setStrPackageApply(String strPackageApply) {
		this.strPackageApply = strPackageApply;
	}

	public String getStrPackAppDate() {
		return strPackAppDate;
	}

	public void setStrPackAppDate(String strPackAppDate) {
		this.strPackAppDate = strPackAppDate;
	}

	public String getStrWalletNo() {
		return strWalletNo;
	}

	public void setStrWalletNo(String strWalletNo) {
		this.strWalletNo = strWalletNo;
	}

	public String getStrAvlWalletMoney() {
		return strAvlWalletMoney;
	}

	public void setStrAvlWalletMoney(String strAvlWalletMoney) {
		this.strAvlWalletMoney = strAvlWalletMoney;
	}

	public String getStrMobileNo() {
		return strMobileNo;
	}

	public void setStrMobileNo(String strMobileNo) {
		this.strMobileNo = strMobileNo;
	}

	public String[] getStrCreditLetterNo() {
		return strCreditLetterNo;
	}

	public void setStrCreditLetterNo(String[] strCreditLetterNo) {
		this.strCreditLetterNo = strCreditLetterNo;
	}

	/*public String[] getStrCreditRefDate1() {
		return strCreditRefDate1;
	}

	public void setStrCreditRefDate1(String[] strCreditRefDate1) {
		this.strCreditRefDate1 = strCreditRefDate1;
	}*/

	public void setUploadedFile(int index, FormFile file) {  
		uploadedFile[index] = file;  
		}  
		   
		public FormFile getUploadedFile(int index) {  
		  return uploadedFile[index];  
		}

	public String getScanDocID() {
		return scanDocID;
	}

	public void setScanDocID(String scanDocID) {
		this.scanDocID = scanDocID;
	}

	/**
	 * @return the offlineDiscountApprovedBy
	 */
	
	/*public String getStrEmployeeId() {
		return strEmployeeId;
	}

	public void setStrEmployeeId(String strEmployeeId) {
		this.strEmployeeId = strEmployeeId;
	}

	public String getStrEmployeeName() {
		return strEmployeeName;
	}

	public void setStrEmployeeName(String strEmployeeName) {
		this.strEmployeeName = strEmployeeName;
	}*/
	
	public String getStrRelationWs() {
		return strRelationWs;
	}

	public void setStrRelationWs(String strRelationWs) {
		this.strRelationWs = strRelationWs;
	}
	public String getStrRmk() {
		return strRmk;
	}

	public void setStrRmk(String strRmk) {
		this.strRmk = strRmk;
	}


	
	public WebRowSet getOfflineDiscountApprovedBy() {
		return offlineDiscountApprovedBy;
	}

	/**
	 * @param offlineDiscountApprovedBy
	 *            the offlineDiscountApprovedBy to set
	 */
	public void setOfflineDiscountApprovedBy(WebRowSet offlineDiscountApprovedBy) {
		this.offlineDiscountApprovedBy = offlineDiscountApprovedBy;
	}

	/**
	 * @return the offlineDiscountRemarks
	 */
	public WebRowSet getOfflineDiscountRemarks() {
		return offlineDiscountRemarks;
	}

	/**
	 * @param offlineDiscountRemarks
	 *            the offlineDiscountRemarks to set
	 */
	public void setOfflineDiscountRemarks(WebRowSet offlineDiscountRemarks) {
		this.offlineDiscountRemarks = offlineDiscountRemarks;
	}

	/**
	 * @return the strMsgString
	 */
	public String getStrMsgString() {
		return strMsgString;
	}

	/**
	 * @param strMsgString
	 *            the strMsgString to set
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	/**
	 * @return the strMsgType
	 */
	public String getStrMsgType() {
		return strMsgType;
	}

	/**
	 * @param strMsgType
	 *            the strMsgType to set
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	/**
	 * @return the strHospitalCode
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	/**
	 * @param strHospitalCode
	 *            the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * @return the strCrNo
	 */
	public String getStrCrNo() {
		return strCrNo;
	}

	/**
	 * @param strCrNo
	 *            the strCrNo to set
	 */
	public void setStrCrNo(String strCrNo) {
		this.strCrNo = strCrNo;
	}

	/**
	 * @return the strAdmissionNo
	 */
	public String getStrAdmissionNo() {
		return strAdmissionNo;
	}

	/**
	 * @param strAdmissionNo
	 *            the strAdmissionNo to set
	 */
	public void setStrAdmissionNo(String strAdmissionNo) {
		this.strAdmissionNo = strAdmissionNo;
	}

	/**
	 * @return the strAccountNo
	 */
	public String getStrAccountNo() {
		return strAccountNo;
	}

	/**
	 * @param strAccountNo
	 *            the strAccountNo to set
	 */
	public void setStrAccountNo(String strAccountNo) {
		this.strAccountNo = strAccountNo;
	}
	
	/**
	 * @return the strRequestFor
	 */
	public String getStrRequestFor() {
		return strRequestFor;
	}

	/**
	 * @param strRequestFor
	 *            the strRequestFor to set
	 */
	public void setStrRequestFor(String strRequestFor) {
		this.strRequestFor = strRequestFor;
	}

	/**
	 * @return the strRequestNo
	 */
	public String getStrRequestNo() {
		return strRequestNo;
	}

	/**
	 * @param strRequestNo
	 *            the strRequestNo to set
	 */
	public void setStrRequestNo(String strRequestNo) {
		this.strRequestNo = strRequestNo;
	}

	/**
	 * @return the strClientPatientNo
	 */
	public String getStrClientPatientNo() {
		return strClientPatientNo;
	}

	/**
	 * @param strClientPatientNo
	 *            the strClientPatientNo to set
	 */
	public void setStrClientPatientNo(String strClientPatientNo) {
		this.strClientPatientNo = strClientPatientNo;
	}

	/**
	 * @return the strChargeTypeId
	 */
	public String getStrChargeTypeId() {
		return strChargeTypeId;
	}

	/**
	 * @param strChargeTypeId
	 *            the strChargeTypeId to set
	 */
	public void setStrChargeTypeId(String strChargeTypeId) {
		this.strChargeTypeId = strChargeTypeId;
	}

	
	/**
	 * @return the strChargeTypeName
	 */
	public String getStrChargeTypeName() {
		return strChargeTypeName;
	}

	/**
	 * @param strChargeTypeName
	 *            the strChargeTypeName to set
	 */
	public void setStrChargeTypeName(String strChargeTypeName) {
		this.strChargeTypeName = strChargeTypeName;
	}

	/**
	 * @return the strRequestType
	 */
	public String getStrRequestType() {
		return strRequestType;
	}

	/**
	 * @param strRequestType
	 *            the strRequestType to set
	 */
	public void setStrRequestType(String strRequestType) {
		this.strRequestType = strRequestType;
	}

	/**
	 * @return the strOffLineHospitalService
	 */
	public String getStrOffLineHospitalService() {
		return strOffLineHospitalService;
	}

	/**
	 * @param strOffLineHospitalService
	 *            the strOffLineHospitalService to set
	 */
	public void setStrOffLineHospitalService(String strOffLineHospitalService) {
		this.strOffLineHospitalService = strOffLineHospitalService;
	}

	/**
	 * @return the strOffLineBillingService
	 */
	public String getStrOffLineBillingService() {
		return strOffLineBillingService;
	}

	/**
	 * @param strOffLineBillingService
	 *            the strOffLineBillingService to set
	 */
	public void setStrOffLineBillingService(String strOffLineBillingService) {
		this.strOffLineBillingService = strOffLineBillingService;
	}

	/**
	 * @return the strOffLineRequestType
	 */
	public String getStrOffLineRequestType() {
		return strOffLineRequestType;
	}

	/**
	 * @param strOffLineRequestType
	 *            the strOffLineRequestType to set
	 */
	public void setStrOffLineRequestType(String strOffLineRequestType) {
		this.strOffLineRequestType = strOffLineRequestType;
	}

	/**
	 * @return the strOffLineRaisingDepartment
	 */
	public String getStrOffLineRaisingDepartment() {
		return strOffLineRaisingDepartment;
	}

	/**
	 * @param strOffLineRaisingDepartment
	 *            the strOffLineRaisingDepartment to set
	 */
	public void setStrOffLineRaisingDepartment(
			String strOffLineRaisingDepartment) {
		this.strOffLineRaisingDepartment = strOffLineRaisingDepartment;
	}

	/**
	 * @return the strOffLineEpisode
	 */
	public String getStrOffLineEpisode() {
		return strOffLineEpisode;
	}

	/**
	 * @param strOffLineEpisode
	 *            the strOffLineEpisode to set
	 */
	public void setStrOffLineEpisode(String strOffLineEpisode) {
		this.strOffLineEpisode = strOffLineEpisode;
	}

	/**
	 * @return the strOffLineTreatmentCategory
	 */
	public String getStrOffLineTreatmentCategory() {
		return strOffLineTreatmentCategory;
	}

	/**
	 * @param strOffLineTreatmentCategory
	 *            the strOffLineTreatmentCategory to set
	 */
	public void setStrOffLineTreatmentCategory(
			String strOffLineTreatmentCategory) {
		this.strOffLineTreatmentCategory = strOffLineTreatmentCategory;
	}

	/**
	 * @return the strOffLineWard
	 */
	public String getStrOffLineWard() {
		return strOffLineWard;
	}

	/**
	 * @param strOffLineWard
	 *            the strOffLineWard to set
	 */
	public void setStrOffLineWard(String strOffLineWard) {
		this.strOffLineWard = strOffLineWard;
	}

	/**
	 * @return the strOffLineApprovedBy
	 */
	public String getStrOffLineApprovedBy() {
		return strOffLineApprovedBy;
	}

	/**
	 * @param strOffLineApprovedBy
	 *            the strOffLineApprovedBy to set
	 */
	public void setStrOffLineApprovedBy(String strOffLineApprovedBy) {
		this.strOffLineApprovedBy = strOffLineApprovedBy;
	}

	/**
	 * @return the strOffLineRemarks
	 */
	public String getStrOffLineRemarks() {
		return strOffLineRemarks;
	}

	/**
	 * @param strOffLineRemarks
	 *            the strOffLineRemarks to set
	 */
	public void setStrOffLineRemarks(String strOffLineRemarks) {
		this.strOffLineRemarks = strOffLineRemarks;
	}

	/**
	 * @return the strOffLinePartPaymentAmount
	 */
	public String getStrOffLinePartPaymentAmount() {
		return strOffLinePartPaymentAmount;
	}

	/**
	 * @param strOffLinePartPaymentAmount
	 *            the strOffLinePartPaymentAmount to set
	 */
	public void setStrOffLinePartPaymentAmount(
			String strOffLinePartPaymentAmount) {
		this.strOffLinePartPaymentAmount = strOffLinePartPaymentAmount;
	}

	/**
	 * @return the strOffLineAdvanceAmount
	 */
	public String getStrOffLineAdvanceAmount() {
		return strOffLineAdvanceAmount;
	}

	/**
	 * @param strOffLineAdvanceAmount
	 *            the strOffLineAdvanceAmount to set
	 */
	public void setStrOffLineAdvanceAmount(String strOffLineAdvanceAmount) {
		this.strOffLineAdvanceAmount = strOffLineAdvanceAmount;
	}

	/**
	 * @return the strOffLineClientPatientNo
	 */
	public String getStrOffLineClientPatientNo() {
		return strOffLineClientPatientNo;
	}

	/**
	 * @param strOffLineClientPatientNo
	 *            the strOffLineClientPatientNo to set
	 */
	public void setStrOffLineClientPatientNo(String strOffLineClientPatientNo) {
		this.strOffLineClientPatientNo = strOffLineClientPatientNo;
	}

	/**
	 * @return the strOffLineAccountNo
	 */
	public String getStrOffLineAccountNo() {
		return strOffLineAccountNo;
	}

	/**
	 * @param strOffLineAccountNo
	 *            the strOffLineAccountNo to set
	 */
	public void setStrOffLineAccountNo(String strOffLineAccountNo) {
		this.strOffLineAccountNo = strOffLineAccountNo;
	}

	/**
	 * @return the strOffLineTreatmentCat
	 */
	public String getStrOffLineTreatmentCat() {
		return strOffLineTreatmentCat;
	}

	/**
	 * @param strOffLineTreatmentCat
	 *            the strOffLineTreatmentCat to set
	 */
	public void setStrOffLineTreatmentCat(String strOffLineTreatmentCat) {
		this.strOffLineTreatmentCat = strOffLineTreatmentCat;
	}

	/**
	 * @return the strOffLineClientPatientHidden
	 */
	public String getStrOffLineClientPatientHidden() {
		return strOffLineClientPatientHidden;
	}

	/**
	 * @param strOffLineClientPatientHidden
	 *            the strOffLineClientPatientHidden to set
	 */
	public void setStrOffLineClientPatientHidden(
			String strOffLineClientPatientHidden) {
		this.strOffLineClientPatientHidden = strOffLineClientPatientHidden;
	}

	/**
	 * @return the strOffLineIsPackageGroup
	 */
	public String getStrOffLineIsPackageGroup() {
		return strOffLineIsPackageGroup;
	}

	/**
	 * @param strOffLineIsPackageGroup
	 *            the strOffLineIsPackageGroup to set
	 */
	public void setStrOffLineIsPackageGroup(String strOffLineIsPackageGroup) {
		this.strOffLineIsPackageGroup = strOffLineIsPackageGroup;
	}

	/**
	 * @return the strOffLinePackageIndex
	 */
	public String getStrOffLinePackageIndex() {
		return strOffLinePackageIndex;
	}

	/**
	 * @param strOffLinePackageIndex
	 *            the strOffLinePackageIndex to set
	 */
	public void setStrOffLinePackageIndex(String strOffLinePackageIndex) {
		this.strOffLinePackageIndex = strOffLinePackageIndex;
	}

	/**
	 * @return the strOffLineGroup
	 */
	public String getStrOffLineGroup() {
		return strOffLineGroup;
	}

	/**
	 * @param strOffLineGroup
	 *            the strOffLineGroup to set
	 */
	public void setStrOffLineGroup(String strOffLineGroup) {
		this.strOffLineGroup = strOffLineGroup;
	}

	/**
	 * @return the strOffLinePakageGroup
	 */
	public String getStrOffLinePakageGroup() {
		return strOffLinePakageGroup;
	}

	/**
	 * @param strOffLinePakageGroup
	 *            the strOffLinePakageGroup to set
	 */
	public void setStrOffLinePakageGroup(String strOffLinePakageGroup) {
		this.strOffLinePakageGroup = strOffLinePakageGroup;
	}

	/**
	 * @return the strOfflineTariffName
	 */
	public String[] getStrOfflineTariffName() {
		return strOfflineTariffName;
	}

	/**
	 * @param strOfflineTariffName
	 *            the strOfflineTariffName to set
	 */
	public void setStrOfflineTariffName(String[] strOfflineTariffName) {
		this.strOfflineTariffName = strOfflineTariffName;
	}

	/**
	 * @return the onlineDetails
	 */
	public WebRowSet getOnlineDetails() {
		return onlineDetails;
	}

	/**
	 * @param onlineDetails
	 *            the onlineDetails to set
	 */
	public void setOnlineDetails(WebRowSet onlineDetails) {
		this.onlineDetails = onlineDetails;
	}

	/**
	 * @return the onlineClientDetails
	 */
	public WebRowSet getOnlineClientDetails() {
		return onlineClientDetails;
	}

	/**
	 * @param onlineClientDetails
	 *            the onlineClientDetails to set
	 */
	public void setOnlineClientDetails(WebRowSet onlineClientDetails) {
		this.onlineClientDetails = onlineClientDetails;
	}

	/**
	 * @return the onlineTariffDetails
	 */
	public WebRowSet getOnlineTariffDetails() {
		return onlineTariffDetails;
	}

	/**
	 * @param onlineTariffDetails
	 *            the onlineTariffDetails to set
	 */
	public void setOnlineTariffDetails(WebRowSet onlineTariffDetails) {
		this.onlineTariffDetails = onlineTariffDetails;
	}

	/**
	 * @return the offlineHospitalServiceList
	 */
	public WebRowSet getOfflineHospitalServiceList() {
		return offlineHospitalServiceList;
	}

	/**
	 * @param offlineHospitalServiceList
	 *            the offlineHospitalServiceList to set
	 */
	public void setOfflineHospitalServiceList(
			WebRowSet offlineHospitalServiceList) {
		this.offlineHospitalServiceList = offlineHospitalServiceList;
	}

	/**
	 * @return the offlineBillingServiceList
	 */
	public WebRowSet getOfflineBillingServiceList() {
		return offlineBillingServiceList;
	}

	/**
	 * @param offlineBillingServiceList
	 *            the offlineBillingServiceList to set
	 */
	public void setOfflineBillingServiceList(WebRowSet offlineBillingServiceList) {
		this.offlineBillingServiceList = offlineBillingServiceList;
	}

	/**
	 * @return the offlineRaisingDepartmentList
	 */
	public WebRowSet getOfflineRaisingDepartmentList() {
		return offlineRaisingDepartmentList;
	}

	/**
	 * @param offlineRaisingDepartmentList
	 *            the offlineRaisingDepartmentList to set
	 */
	public void setOfflineRaisingDepartmentList(
			WebRowSet offlineRaisingDepartmentList) {
		this.offlineRaisingDepartmentList = offlineRaisingDepartmentList;
	}

	/**
	 * @return the offlineEpisodeList
	 */
	public WebRowSet getOfflineEpisodeList() {
		return offlineEpisodeList;
	}

	/**
	 * @param offlineEpisodeList
	 *            the offlineEpisodeList to set
	 */
	public void setOfflineEpisodeList(WebRowSet offlineEpisodeList) {
		this.offlineEpisodeList = offlineEpisodeList;
	}

	/**
	 * @return the offlineTreatmentCategoryList
	 */
	public WebRowSet getOfflineTreatmentCategoryList() {
		return offlineTreatmentCategoryList;
	}

	/**
	 * @param offlineTreatmentCategoryList
	 *            the offlineTreatmentCategoryList to set
	 */
	public void setOfflineTreatmentCategoryList(
			WebRowSet offlineTreatmentCategoryList) {
		this.offlineTreatmentCategoryList = offlineTreatmentCategoryList;
	}

	/**
	 * @return the offlineWardList
	 */
	public WebRowSet getOfflineWardList() {
		return offlineWardList;
	}

	/**
	 * @param offlineWardList
	 *            the offlineWardList to set
	 */
	public void setOfflineWardList(WebRowSet offlineWardList) {
		this.offlineWardList = offlineWardList;
	}

	/**
	 * @return the offlineApprovedByList
	 */
	public WebRowSet getOfflineApprovedByList() {
		return offlineApprovedByList;
	}

	/**
	 * @param offlineApprovedByList
	 *            the offlineApprovedByList to set
	 */
	public void setOfflineApprovedByList(WebRowSet offlineApprovedByList) {
		this.offlineApprovedByList = offlineApprovedByList;
	}

	/**
	 * @return the offlineRemarksList
	 */
	public WebRowSet getOfflineRemarksList() {
		return offlineRemarksList;
	}

	/**
	 * @param offlineRemarksList
	 *            the offlineRemarksList to set
	 */
	public void setOfflineRemarksList(WebRowSet offlineRemarksList) {
		this.offlineRemarksList = offlineRemarksList;
	}

	/**
	 * @return the offlineClientDetails
	 */
	public WebRowSet getOfflineClientDetails() {
		return offlineClientDetails;
	}

	/**
	 * @param offlineClientDetails
	 *            the offlineClientDetails to set
	 */
	public void setOfflineClientDetails(WebRowSet offlineClientDetails) {
		this.offlineClientDetails = offlineClientDetails;
	}

	/**
	 * @return the offlineGroupList
	 */
	public WebRowSet getOfflineGroupList() {
		return offlineGroupList;
	}

	/**
	 * @param offlineGroupList
	 *            the offlineGroupList to set
	 */
	public void setOfflineGroupList(WebRowSet offlineGroupList) {
		this.offlineGroupList = offlineGroupList;
	}

	/**
	 * @return the offlineTariffList
	 */
	public WebRowSet getOfflineTariffList() {
		return offlineTariffList;
	}

	/**
	 * @param offlineTariffList
	 *            the offlineTariffList to set
	 */
	public void setOfflineTariffList(WebRowSet offlineTariffList) {
		this.offlineTariffList = offlineTariffList;
	}

	/**
	 * @return the offlinePackageGroup
	 */
	public WebRowSet getOfflinePackageGroup() {
		return offlinePackageGroup;
	}

	/**
	 * @param offlinePackageGroup
	 *            the offlinePackageGroup to set
	 */
	public void setOfflinePackageGroup(WebRowSet offlinePackageGroup) {
		this.offlinePackageGroup = offlinePackageGroup;
	}

	/**
	 * @return the strOfflineTariffDiscountApprovedBy
	 */
	public String getStrOfflineTariffDiscountApprovedBy() {
		return strOfflineTariffDiscountApprovedBy;
	}

	/**
	 * @param strOfflineTariffDiscountApprovedBy
	 *            the strOfflineTariffDiscountApprovedBy to set
	 */
	public void setStrOfflineTariffDiscountApprovedBy(
			String strOfflineTariffDiscountApprovedBy) {
		this.strOfflineTariffDiscountApprovedBy = strOfflineTariffDiscountApprovedBy;
	}

	/**
	 * @return the strOfflineTariffDiscountRemarks
	 */
	public String getStrOfflineTariffDiscountRemarks() {
		return strOfflineTariffDiscountRemarks;
	}

	/**
	 * @param strOfflineTariffDiscountRemarks
	 *            the strOfflineTariffDiscountRemarks to set
	 */
	public void setStrOfflineTariffDiscountRemarks(
			String strOfflineTariffDiscountRemarks) {
		this.strOfflineTariffDiscountRemarks = strOfflineTariffDiscountRemarks;
	}

	/**
	 * @return the offlineTariffUnit
	 */
	public WebRowSet getOfflineTariffUnit() {
		return offlineTariffUnit;
	}

	/**
	 * @param offlineTariffUnit
	 *            the offlineTariffUnit to set
	 */
	public void setOfflineTariffUnit(WebRowSet offlineTariffUnit) {
		this.offlineTariffUnit = offlineTariffUnit;
	}

	/**
	 * @return the strOffLineTariffUnitTempId
	 */
	public String getStrOffLineTariffUnitTempId() {
		return strOffLineTariffUnitTempId;
	}

	/**
	 * @param strOffLineTariffUnitTempId
	 *            the strOffLineTariffUnitTempId to set
	 */
	public void setStrOffLineTariffUnitTempId(String strOffLineTariffUnitTempId) {
		this.strOffLineTariffUnitTempId = strOffLineTariffUnitTempId;
	}

	/**
	 * @return the strOffLineBillNumber
	 */
	public String getStrOffLineBillNumber() {
		return strOffLineBillNumber;
	}

	/**
	 * @param strOffLineBillNumber
	 *            the strOffLineBillNumber to set
	 */
	public void setStrOffLineBillNumber(String strOffLineBillNumber) {
		this.strOffLineBillNumber = strOffLineBillNumber;
	}

	/**
	 * @return the offlineBillList
	 */
	public WebRowSet getOfflineBillList() {
		return offlineBillList;
	}

	/**
	 * @param offlineBillList
	 *            the offlineBillList to set
	 */
	public void setOfflineBillList(WebRowSet offlineBillList) {
		this.offlineBillList = offlineBillList;
	}

	/**
	 * @return the offlineBillTariffList
	 */
	public WebRowSet getOfflineBillTariffList() {
		return offlineBillTariffList;
	}

	/**
	 * @param offlineBillTariffList
	 *            the offlineBillTariffList to set
	 */
	public void setOfflineBillTariffList(WebRowSet offlineBillTariffList) {
		this.offlineBillTariffList = offlineBillTariffList;
	}

	/**
	 * @return the strOffLineRefundPenalty
	 */
	public String getStrOffLineRefundPenalty() {
		return strOffLineRefundPenalty;
	}

	/**
	 * @param strOffLineRefundPenalty
	 *            the strOffLineRefundPenalty to set
	 */
	public void setStrOffLineRefundPenalty(String strOffLineRefundPenalty) {
		this.strOffLineRefundPenalty = strOffLineRefundPenalty;
	}

	/**
	 * @return the strOffLineTariffDetailsHiddenValue
	 */
	public String getStrOffLineTariffDetailsHiddenValue() {
		return strOffLineTariffDetailsHiddenValue;
	}

	/**
	 * @param strOffLineTariffDetailsHiddenValue
	 *            the strOffLineTariffDetailsHiddenValue to set
	 */
	public void setStrOffLineTariffDetailsHiddenValue(
			String strOffLineTariffDetailsHiddenValue) {
		this.strOffLineTariffDetailsHiddenValue = strOffLineTariffDetailsHiddenValue;
	}
 

	/**
	 * @return the strBillSearchString
	 */
	public String getStrBillSearchString() {
		return strBillSearchString;
	}

	/**
	 * @param strBillSearchString
	 *            the strBillSearchString to set
	 */
	public void setStrBillSearchString(String strBillSearchString) {
		this.strBillSearchString = strBillSearchString;
	}

	/**
	 * @return the strBillFromRow
	 */
	public String getStrBillFromRow() {
		return strBillFromRow;
	}

	/**
	 * @param strBillFromRow
	 *            the strBillFromRow to set
	 */
	public void setStrBillFromRow(String strBillFromRow) {
		this.strBillFromRow = strBillFromRow;
	}

	/**
	 * @return the strBillRowPerPage
	 */
	public String getStrBillRowPerPage() {
		return strBillRowPerPage;
	}

	/**
	 * @param strBillRowPerPage
	 *            the strBillRowPerPage to set
	 */
	public void setStrBillRowPerPage(String strBillRowPerPage) {
		this.strBillRowPerPage = strBillRowPerPage;
	}

	/**
	 * @return the strBillCtBlockSet
	 */
	public String getStrBillCtBlockSet() {
		return strBillCtBlockSet;
	}

	/**
	 * @param strBillCtBlockSet
	 *            the strBillCtBlockSet to set
	 */
	public void setStrBillCtBlockSet(String strBillCtBlockSet) {
		this.strBillCtBlockSet = strBillCtBlockSet;
	}

	/**
	 * @return the strBillToRow
	 */
	public String getStrBillToRow() {
		return strBillToRow;
	}

	/**
	 * @param strBillToRow
	 *            the strBillToRow to set
	 */
	public void setStrBillToRow(String strBillToRow) {
		this.strBillToRow = strBillToRow;
	}

	/**
	 * @return the billSearchList
	 */
	public WebRowSet getBillSearchList() {
		return billSearchList;
	}

	/**
	 * @param billSearchList
	 *            the billSearchList to set
	 */
	public void setBillSearchList(WebRowSet billSearchList) {
		this.billSearchList = billSearchList;
	}
 
	/**
	 * @return the admissionCancellationDetails
	 */
	public WebRowSet getAdmissionCancellationDetails() {
		return admissionCancellationDetails;
	}

	/**
	 * @param admissionCancellationDetails
	 *            the admissionCancellationDetails to set
	 */
	public void setAdmissionCancellationDetails(
			WebRowSet admissionCancellationDetails) {
		this.admissionCancellationDetails = admissionCancellationDetails;
	}

	public String getStrModuleId() {
		return strModuleId;
	}

	public void setStrModuleId(String strModuleId) {
		this.strModuleId = strModuleId;
	}

	public String getStrIpAddress() {
		return strIpAddress;
	}

	public void setStrIpAddress(String strIpAddress) {
		this.strIpAddress = strIpAddress;
	}

	public String getStrCounterId() {
		return strCounterId;
	}

	public void setStrCounterId(String strCounterId) {
		this.strCounterId = strCounterId;
	}

	public String[] getStrOnlinePaymentMode() {
		return strOnlinePaymentMode;
	}

	public void setStrOnlinePaymentMode(String[] strOnlinePaymentMode) {
		this.strOnlinePaymentMode = strOnlinePaymentMode;
	}

	public String[] getStrOnlinePaymentDtls() {
		return strOnlinePaymentDtls;
	}

	public void setStrOnlinePaymentDtls(String[] strOnlinePaymentDtls) {
		this.strOnlinePaymentDtls = strOnlinePaymentDtls;
	}

	public String[] getStrOnlineAmount() {
		return strOnlineAmount;
	}

	public void setStrOnlineAmount(String[] strOnlineAmount) {
		this.strOnlineAmount = strOnlineAmount;
	}

	public String[] getStrOfflinePaymentMode() {
		return strOfflinePaymentMode;
	}

	public void setStrOfflinePaymentMode(String[] strOfflinePaymentMode) {
		this.strOfflinePaymentMode = strOfflinePaymentMode;
	}

	public String[] getStrOfflinePaymentDtls() {
		return strOfflinePaymentDtls;
	}

	public void setStrOfflinePaymentDtls(String[] strOfflinePaymentDtls) {
		this.strOfflinePaymentDtls = strOfflinePaymentDtls;
	}

	public String[] getStrOfflineAmount() {
		return strOfflineAmount;
	}

	public void setStrOfflineAmount(String[] strOfflineAmount) {
		this.strOfflineAmount = strOfflineAmount;
	}

	public String getStrSeatId() {
		return strSeatId;
	}

	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	public String getStrErrPrimKeyLog() {
		return strErrPrimKeyLog;
	}

	public void setStrErrPrimKeyLog(String strErrPrimKeyLog) {
		this.strErrPrimKeyLog = strErrPrimKeyLog;
	}

	public String getStrWard() {
		return strWard;
	}

	public void setStrWard(String strWard) {
		this.strWard = strWard;
	}

	public String getStrEpisode() {
		return strEpisode;
	}

	public void setStrEpisode(String strEpisode) {
		this.strEpisode = strEpisode;
	}

	public String getStrSancAmount() {
		return strSancAmount;
	}

	public void setStrSancAmount(String strSancAmount) {
		this.strSancAmount = strSancAmount;
	}

	public String getStrPatientReceivedAmount() {
		return strPatientReceivedAmount;
	}

	public void setStrPatientReceivedAmount(String strPatientReceivedAmount) {
		this.strPatientReceivedAmount = strPatientReceivedAmount;
	}

	public String getStrClientBalance() {
		return strClientBalance;
	}

	public void setStrClientBalance(String strClientBalance) {
		this.strClientBalance = strClientBalance;
	}

	public String getStrCurrentDate() {
		return strCurrentDate;
	}

	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	public String getStrAdvanceAmount() {
		return strAdvanceAmount;
	}

	public void setStrAdvanceAmount(String strAdvanceAmount) {
		this.strAdvanceAmount = strAdvanceAmount;
	}

	public String getStrIpdChargeTypeId() {
		return strIpdChargeTypeId;
	}

	public void setStrIpdChargeTypeId(String strIpdChargeTypeId) {
		this.strIpdChargeTypeId = strIpdChargeTypeId;
	}

	public String getStrApprovalId() {
		return strApprovalId;
	}

	public void setStrApprovalId(String strApprovalId) {
		this.strApprovalId = strApprovalId;
	}

	public String getStrApprovedBy() {
		return strApprovedBy;
	}

	public void setStrApprovedBy(String strApprovedBy) {
		this.strApprovedBy = strApprovedBy;
	}

	public String getStrApprovedDate() {
		return strApprovedDate;
	}

	public void setStrApprovedDate(String strApprovedDate) {
		this.strApprovedDate = strApprovedDate;
	}

	public String getStrGroupId() {
		return strGroupId;
	}

	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	public String getStrQtyUnitId() {
		return strQtyUnitId;
	}

	public void setStrQtyUnitId(String strQtyUnitId) {
		this.strQtyUnitId = strQtyUnitId;
	}

	public String getStrClientAmount() {
		return strClientAmount;
	}

	public void setStrClientAmount(String strClientAmount) {
		this.strClientAmount = strClientAmount;
	}

	public String getStrPartPaymentAmount() {
		return strPartPaymentAmount;
	}

	public void setStrPartPaymentAmount(String strPartPaymentAmount) {
		this.strPartPaymentAmount = strPartPaymentAmount;
	}

	public String getStrRaisingDepartment() {
		return strRaisingDepartment;
	}

	public void setStrRaisingDepartment(String strRaisingDepartment) {
		this.strRaisingDepartment = strRaisingDepartment;
	}

	public String getStrTreatmentCategory() {
		return strTreatmentCategory;
	}

	public void setStrTreatmentCategory(String strTreatmentCategory) {
		this.strTreatmentCategory = strTreatmentCategory;
	}

	public String getStrBillingService() {
		return strBillingService;
	}

	public void setStrBillingService(String strBillingService) {
		this.strBillingService = strBillingService;
	}

	public String getStrOffLineClientType() {
		return strOffLineClientType;
	}

	public void setStrOffLineClientType(String strOffLineClientType) {
		this.strOffLineClientType = strOffLineClientType;
	}

	public String getStrOffLineSancAmount() {
		return strOffLineSancAmount;
	}

	public void setStrOffLineSancAmount(String strOffLineSancAmount) {
		this.strOffLineSancAmount = strOffLineSancAmount;
	}

	public String getStrOffLineApprovalNo() {
		return strOffLineApprovalNo;
	}

	public void setStrOffLineApprovalNo(String strOffLineApprovalNo) {
		this.strOffLineApprovalNo = strOffLineApprovalNo;
	}

	public String getStrOffLineBalanceAmount() {
		return strOffLineBalanceAmount;
	}

	public void setStrOffLineBalanceAmount(String strOffLineBalanceAmount) {
		this.strOffLineBalanceAmount = strOffLineBalanceAmount;
	}

	/**
	 * @return the strOfflineTotalRecAmount
	 */
	public String getStrOfflineTotalRecAmount() {
		return strOfflineTotalRecAmount;
	}

	/**
	 * @param strOfflineTotalRecAmount the strOfflineTotalRecAmount to set
	 */
	public void setStrOfflineTotalRecAmount(String strOfflineTotalRecAmount) {
		this.strOfflineTotalRecAmount = strOfflineTotalRecAmount;
	}

	/**
	 * @return the strOffLineIpdChargeTypeId
	 */
	public String getStrOffLineIpdChargeTypeId() {
		return strOffLineIpdChargeTypeId;
	}

	/**
	 * @param strOffLineIpdChargeTypeId the strOffLineIpdChargeTypeId to set
	 */
	public void setStrOffLineIpdChargeTypeId(String strOffLineIpdChargeTypeId) {
		this.strOffLineIpdChargeTypeId = strOffLineIpdChargeTypeId;
	}

	/**
	 * @return the strChk_value
	 */
	public String getStrChk_value() {
		return strChk_value;
	}

	/**
	 * @param strChk_value the strChk_value to set
	 */
	public void setStrChk_value(String strChk_value) {
		this.strChk_value = strChk_value;
	}

	/**
	 * @return the strApprovedByCombo
	 */
	public String getStrApprovedByCombo() {
		return strApprovedByCombo;
	}

	/**
	 * @param strApprovedByCombo the strApprovedByCombo to set
	 */
	public void setStrApprovedByCombo(String strApprovedByCombo) {
		this.strApprovedByCombo = strApprovedByCombo;
	}

	/**
	 * @return the strRemarksCombo2
	 */
	public String getStrRemarksCombo2() {
		return strRemarksCombo2;
	}

	/**
	 * @param strRemarksCombo2 the strRemarksCombo2 to set
	 */
	public void setStrRemarksCombo2(String strRemarksCombo2) {
		this.strRemarksCombo2 = strRemarksCombo2;
	}

	/**
	 * @return the strUserLevel
	 */
	public String getStrUserLevel() {
		return strUserLevel;
	}

	/**
	 * @param strUserLevel the strUserLevel to set
	 */
	public void setStrUserLevel(String strUserLevel) {
		this.strUserLevel = strUserLevel;
	}

	/**
	 * @return the strOffLineAdmissionNo
	 */
	public String getStrOffLineAdmissionNo() {
		return strOffLineAdmissionNo;
	}

	/**
	 * @param strOffLineAdmissionNo the strOffLineAdmissionNo to set
	 */
	public void setStrOffLineAdmissionNo(String strOffLineAdmissionNo) {
		this.strOffLineAdmissionNo = strOffLineAdmissionNo;
	}

	public String getStrErrMsg() {
		return strErrMsg;
	}

	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}

	public String[] getStrOfflineTariffDetailsHidden() {
		return strOfflineTariffDetailsHidden;
	}

	public void setStrOfflineTariffDetailsHidden(
			String[] strOfflineTariffDetailsHidden) {
		this.strOfflineTariffDetailsHidden = strOfflineTariffDetailsHidden;
	}

	public String[] getStrOfflineTariffQty() {
		return strOfflineTariffQty;
	}

	public void setStrOfflineTariffQty(String[] strOfflineTariffQty) {
		this.strOfflineTariffQty = strOfflineTariffQty;
	}

	public String[] getStrOfflineTariffUnit() {
		return strOfflineTariffUnit;
	}

	public void setStrOfflineTariffUnit(String[] strOfflineTariffUnit) {
		this.strOfflineTariffUnit = strOfflineTariffUnit;
	}

	public String[] getStrOfflineTariffServiceTax() {
		return strOfflineTariffServiceTax;
	}

	public void setStrOfflineTariffServiceTax(String[] strOfflineTariffServiceTax) {
		this.strOfflineTariffServiceTax = strOfflineTariffServiceTax;
	}

	public String[] getStrOfflineTariffDiscount() {
		return strOfflineTariffDiscount;
	}

	public void setStrOfflineTariffDiscount(String[] strOfflineTariffDiscount) {
		this.strOfflineTariffDiscount = strOfflineTariffDiscount;
	}

	public String[] getStrOfflineTariffDiscountConfigDetails() {
		return strOfflineTariffDiscountConfigDetails;
	}

	public void setStrOfflineTariffDiscountConfigDetails(
			String[] strOfflineTariffDiscountConfigDetails) {
		this.strOfflineTariffDiscountConfigDetails = strOfflineTariffDiscountConfigDetails;
	}

	public String[] getStrOfflineTariffNetAmount() {
		return strOfflineTariffNetAmount;
	}

	public void setStrOfflineTariffNetAmount(String[] strOfflineTariffNetAmount) {
		this.strOfflineTariffNetAmount = strOfflineTariffNetAmount;
	}

	public String getStrOfflineTotalPayAmount() {
		return strOfflineTotalPayAmount;
	}

	public void setStrOfflineTotalPayAmount(String strOfflineTotalPayAmount) {
		this.strOfflineTotalPayAmount = strOfflineTotalPayAmount;
	}

	public String getStrOfflineRefundAmount() {
		return strOfflineRefundAmount;
	}

	public void setStrOfflineRefundAmount(String strOfflineRefundAmount) {
		this.strOfflineRefundAmount = strOfflineRefundAmount;
	}

	public String getStrOfflineMaxClientBenefitAmount() {
		return strOfflineMaxClientBenefitAmount;
	}

	public void setStrOfflineMaxClientBenefitAmount(
			String strOfflineMaxClientBenefitAmount) {
		this.strOfflineMaxClientBenefitAmount = strOfflineMaxClientBenefitAmount;
	}

	public String getStrOfflinePatNetPayAmount() {
		return strOfflinePatNetPayAmount;
	}

	public void setStrOfflinePatNetPayAmount(String strOfflinePatNetPayAmount) {
		this.strOfflinePatNetPayAmount = strOfflinePatNetPayAmount;
	}

	public String getStrOfflineTotalServiceTaxAmount() {
		return strOfflineTotalServiceTaxAmount;
	}

	public void setStrOfflineTotalServiceTaxAmount(
			String strOfflineTotalServiceTaxAmount) {
		this.strOfflineTotalServiceTaxAmount = strOfflineTotalServiceTaxAmount;
	}

	public String getStrOfflineTotalDiscountAmount() {
		return strOfflineTotalDiscountAmount;
	}

	public void setStrOfflineTotalDiscountAmount(
			String strOfflineTotalDiscountAmount) {
		this.strOfflineTotalDiscountAmount = strOfflineTotalDiscountAmount;
	}

	public String getStrOfflineTotalActualTariffAmount() {
		return strOfflineTotalActualTariffAmount;
	}

	public void setStrOfflineTotalActualTariffAmount(
			String strOfflineTotalActualTariffAmount) {
		this.strOfflineTotalActualTariffAmount = strOfflineTotalActualTariffAmount;
	}

	public String getStrBillNo() {
		return strBillNo;
	}

	public void setStrBillNo(String strBillNo) {
		this.strBillNo = strBillNo;
	}

	public String getStrRefundReceiptNo() {
		return strRefundReceiptNo;
	}

	public void setStrRefundReceiptNo(String strRefundReceiptNo) {
		this.strRefundReceiptNo = strRefundReceiptNo;
	}

	public String getStrOfflineRefundBillDetails() {
		return strOfflineRefundBillDetails;
	}

	public void setStrOfflineRefundBillDetails(String strOfflineRefundBillDetails) {
		this.strOfflineRefundBillDetails = strOfflineRefundBillDetails;
	}

	public String getStrOffLineRefundBy() {
		return strOffLineRefundBy;
	}

	public void setStrOffLineRefundBy(String strOffLineRefundBy) {
		this.strOffLineRefundBy = strOffLineRefundBy;
	}

	public String getStrOffLineRefundReason() {
		return strOffLineRefundReason;
	}

	public void setStrOffLineRefundReason(String strOffLineRefundReason) {
		this.strOffLineRefundReason = strOffLineRefundReason;
	}

	public String getStrOffLineRefundReasonText() {
		return strOffLineRefundReasonText;
	}

	public void setStrOffLineRefundReasonText(String strOffLineRefundReasonText) {
		this.strOffLineRefundReasonText = strOffLineRefundReasonText;
	}

	public String[] getStrBillTariffVal() {
		return strBillTariffVal;
	}

	public void setStrBillTariffVal(String[] strBillTariffVal) {
		this.strBillTariffVal = strBillTariffVal;
	}

	public String[] getStrBillTariffPenaltyType() {
		return strBillTariffPenaltyType;
	}

	public void setStrBillTariffPenaltyType(String[] strBillTariffPenaltyType) {
		this.strBillTariffPenaltyType = strBillTariffPenaltyType;
	}

	public String[] getStrBillTariffPenalty() {
		return strBillTariffPenalty;
	}

	public void setStrBillTariffPenalty(String[] strBillTariffPenalty) {
		this.strBillTariffPenalty = strBillTariffPenalty;
	}

	public String[] getStrBillTariffRefund() {
		return strBillTariffRefund;
	}

	public void setStrBillTariffRefund(String[] strBillTariffRefund) {
		this.strBillTariffRefund = strBillTariffRefund;
	}

	public String[] getStrBillTariffUnit() {
		return strBillTariffUnit;
	}

	public void setStrBillTariffUnit(String[] strBillTariffUnit) {
		this.strBillTariffUnit = strBillTariffUnit;
	}

	public String[] getStrBillTariffRefundAmount() {
		return strBillTariffRefundAmount;
	}

	public void setStrBillTariffRefundAmount(String[] strBillTariffRefundAmount) {
		this.strBillTariffRefundAmount = strBillTariffRefundAmount;
	}

	public String getStrOfflineRefundTotalServiceTaxAmount() {
		return strOfflineRefundTotalServiceTaxAmount;
	}

	public void setStrOfflineRefundTotalServiceTaxAmount(
			String strOfflineRefundTotalServiceTaxAmount) {
		this.strOfflineRefundTotalServiceTaxAmount = strOfflineRefundTotalServiceTaxAmount;
	}

	public String getStrOfflineRefundTotalDiscountAmount() {
		return strOfflineRefundTotalDiscountAmount;
	}

	public void setStrOfflineRefundTotalDiscountAmount(
			String strOfflineRefundTotalDiscountAmount) {
		this.strOfflineRefundTotalDiscountAmount = strOfflineRefundTotalDiscountAmount;
	}

	public String getStrOfflineRefundTotalPenaltyAmount() {
		return strOfflineRefundTotalPenaltyAmount;
	}

	public void setStrOfflineRefundTotalPenaltyAmount(
			String strOfflineRefundTotalPenaltyAmount) {
		this.strOfflineRefundTotalPenaltyAmount = strOfflineRefundTotalPenaltyAmount;
	}

	public String getStrOfflineRefundTotalActualTariffAmount() {
		return strOfflineRefundTotalActualTariffAmount;
	}

	public void setStrOfflineRefundTotalActualTariffAmount(
			String strOfflineRefundTotalActualTariffAmount) {
		this.strOfflineRefundTotalActualTariffAmount = strOfflineRefundTotalActualTariffAmount;
	}

	public String getStrOfflineRefundDate() {
		return strOfflineRefundDate;
	}

	public void setStrOfflineRefundDate(String strOfflineRefundDate) {
		this.strOfflineRefundDate = strOfflineRefundDate;
	}

	public String getStrAdmissionCancellationPenalty() {
		return strAdmissionCancellationPenalty;
	}

	public void setStrAdmissionCancellationPenalty(
			String strAdmissionCancellationPenalty) {
		this.strAdmissionCancellationPenalty = strAdmissionCancellationPenalty;
	}

	public String getStrRefundAdvancePaneltyAmt() {
		return strRefundAdvancePaneltyAmt;
	}

	public void setStrRefundAdvancePaneltyAmt(String strRefundAdvancePaneltyAmt) {
		this.strRefundAdvancePaneltyAmt = strRefundAdvancePaneltyAmt;
	}

	public String getStrOffLineRefundAdvanceAccountNo() {
		return strOffLineRefundAdvanceAccountNo;
	}

	public void setStrOffLineRefundAdvanceAccountNo(
			String strOffLineRefundAdvanceAccountNo) {
		this.strOffLineRefundAdvanceAccountNo = strOffLineRefundAdvanceAccountNo;
	}
 
	public String getStrTotalTariffServiceTaxAmount() {
		return strTotalTariffServiceTaxAmount;
	}

	public void setStrTotalTariffServiceTaxAmount(
			String strTotalTariffServiceTaxAmount) {
		this.strTotalTariffServiceTaxAmount = strTotalTariffServiceTaxAmount;
	}

	public String getStrTotalTariffDiscountAmount() {
		return strTotalTariffDiscountAmount;
	}

	public void setStrTotalTariffDiscountAmount(String strTotalTariffDiscountAmount) {
		this.strTotalTariffDiscountAmount = strTotalTariffDiscountAmount;
	}

	public String getStrTotalTariffActualAmount() {
		return strTotalTariffActualAmount;
	}

	public void setStrTotalTariffActualAmount(String strTotalTariffActualAmount) {
		this.strTotalTariffActualAmount = strTotalTariffActualAmount;
	}

	public String[] getStrTariffDetailsId() {
		return strTariffDetailsId;
	}

	public void setStrTariffDetailsId(String[] strTariffDetailsId) {
		this.strTariffDetailsId = strTariffDetailsId;
	}

	public String[] getStrBillTariffName() {
		return strBillTariffName;
	}

	public void setStrBillTariffName(String[] strBillTariffName) {
		this.strBillTariffName = strBillTariffName;
	}

	public String[] getStrTariffServiceTaxAmt() {
		return strTariffServiceTaxAmt;
	}

	public void setStrTariffServiceTaxAmt(String[] strTariffServiceTaxAmt) {
		this.strTariffServiceTaxAmt = strTariffServiceTaxAmt;
	}

	public String[] getStrTariffRate() {
		return strTariffRate;
	}

	public void setStrTariffRate(String[] strTariffRate) {
		this.strTariffRate = strTariffRate;
	}

	public String[] getStrTariffActualAmt() {
		return strTariffActualAmt;
	}

	public void setStrTariffActualAmt(String[] strTariffActualAmt) {
		this.strTariffActualAmt = strTariffActualAmt;
	}

	public String[] getStrTariffReqQty() {
		return strTariffReqQty;
	}

	public void setStrTariffReqQty(String[] strTariffReqQty) {
		this.strTariffReqQty = strTariffReqQty;
	}

	public String[] getStrTariffBilledQty() {
		return strTariffBilledQty;
	}

	public void setStrTariffBilledQty(String[] strTariffBilledQty) {
		this.strTariffBilledQty = strTariffBilledQty;
	}

	public String[] getStrTariffDiscountAmt() {
		return strTariffDiscountAmt;
	}

	public void setStrTariffDiscountAmt(String[] strTariffDiscountAmt) {
		this.strTariffDiscountAmt = strTariffDiscountAmt;
	}

	public String[] getStrTariffNetAmt() {
		return strTariffNetAmt;
	}

	public void setStrTariffNetAmt(String[] strTariffNetAmt) {
		this.strTariffNetAmt = strTariffNetAmt;
	}

	public String getStrGlobalRequestNo() {
		return strGlobalRequestNo;
	}

	public void setStrGlobalRequestNo(String strGlobalRequestNo) {
		this.strGlobalRequestNo = strGlobalRequestNo;
	}

	public String getStrRequestDate() {
		return strRequestDate;
	}

	public void setStrRequestDate(String strRequestDate) {
		this.strRequestDate = strRequestDate;
	}

	public String getStrService() {
		return strService;
	}

	public void setStrService(String strService) {
		this.strService = strService;
	}
  
	public String[] getStrTariffToBeRefundQty() {
		return strTariffToBeRefundQty;
	}

	public void setStrTariffToBeRefundQty(String[] strTariffToBeRefundQty) {
		this.strTariffToBeRefundQty = strTariffToBeRefundQty;
	}

	public String[] getStrTariffRefundQty() {
		return strTariffRefundQty;
	}

	public void setStrTariffRefundQty(String[] strTariffRefundQty) {
		this.strTariffRefundQty = strTariffRefundQty;
	}

	public String[] getStrTariffRefundUnit() {
		return strTariffRefundUnit;
	}

	public void setStrTariffRefundUnit(String[] strTariffRefundUnit) {
		this.strTariffRefundUnit = strTariffRefundUnit;
	}

	public String[] getStrTariffRefundCost() {
		return strTariffRefundCost;
	}

	public void setStrTariffRefundCost(String[] strTariffRefundCost) {
		this.strTariffRefundCost = strTariffRefundCost;
	}

	public String getStrTotalTariffPenaltyAmount() {
		return strTotalTariffPenaltyAmount;
	}

	public void setStrTotalTariffPenaltyAmount(String strTotalTariffPenaltyAmount) {
		this.strTotalTariffPenaltyAmount = strTotalTariffPenaltyAmount;
	}

	public String[] getStrTariffPenaltyAmt() {
		return strTariffPenaltyAmt;
	}

	public void setStrTariffPenaltyAmt(String[] strTariffPenaltyAmt) {
		this.strTariffPenaltyAmt = strTariffPenaltyAmt;
	}

	public String getStrRefundAdvancePenelty() {
		return strRefundAdvancePenelty;
	}

	public void setStrRefundAdvancePenelty(String strRefundAdvancePenelty) {
		this.strRefundAdvancePenelty = strRefundAdvancePenelty;
	}

	public String getStrClientName() {
		return strClientName;
	}

	public void setStrClientName(String strClientName) {
		this.strClientName = strClientName;
	}

	public String getStrClientType() {
		return strClientType;
	}

	public void setStrClientType(String strClientType) {
		this.strClientType = strClientType;
	}

	public String getStrClientApprovalNo() {
		return strClientApprovalNo;
	}

	public void setStrClientApprovalNo(String strClientApprovalNo) {
		this.strClientApprovalNo = strClientApprovalNo;
	}

	public String getStrClientPayiedBy() {
		return strClientPayiedBy;
	}

	public void setStrClientPayiedBy(String strClientPayiedBy) {
		this.strClientPayiedBy = strClientPayiedBy;
	}

	public String getStrOfflineClientName() {
		return strOfflineClientName;
	}

	public void setStrOfflineClientName(String strOfflineClientName) {
		this.strOfflineClientName = strOfflineClientName;
	}

	public String getStrOfflineClientPayiedBy() {
		return strOfflineClientPayiedBy;
	}

	public void setStrOfflineClientPayiedBy(String strOfflineClientPayiedBy) {
		this.strOfflineClientPayiedBy = strOfflineClientPayiedBy;
	}
 

	public String getStrOfflineClientDetails() {
		return strOfflineClientDetails;
	}

	public void setStrOfflineClientDetails(String strOfflineClientDetails) {
		this.strOfflineClientDetails = strOfflineClientDetails;
	}

	public String getStrExpenseAmount() {
		return strExpenseAmount;
	}

	public void setStrExpenseAmount(String strExpenseAmount) {
		this.strExpenseAmount = strExpenseAmount;
	}

	public String getStrNetClientAmount() {
		return strNetClientAmount;
	}

	public void setStrNetClientAmount(String strNetClientAmount) {
		this.strNetClientAmount = strNetClientAmount;
	}

	public String getStrNetDiscountAmount() {
		return strNetDiscountAmount;
	}

	public void setStrNetDiscountAmount(String strNetDiscountAmount) {
		this.strNetDiscountAmount = strNetDiscountAmount;
	}

	public String getStrNetServiceTaxAmount() {
		return strNetServiceTaxAmount;
	}

	public void setStrNetServiceTaxAmount(String strNetServiceTaxAmount) {
		this.strNetServiceTaxAmount = strNetServiceTaxAmount;
	}

	public String getStrNetPaybleAmount() {
		return strNetPaybleAmount;
	}

	public void setStrNetPaybleAmount(String strNetPaybleAmount) {
		this.strNetPaybleAmount = strNetPaybleAmount;
	}

	public String getStrDiscountType() {
		return strDiscountType;
	}

	public void setStrDiscountType(String strDiscountType) {
		this.strDiscountType = strDiscountType;
	}

	public String getStrDiscountUnit() {
		return strDiscountUnit;
	}

	public void setStrDiscountUnit(String strDiscountUnit) {
		this.strDiscountUnit = strDiscountUnit;
	}

	public String getStrServiceTax() {
		return strServiceTax;
	}

	public void setStrServiceTax(String strServiceTax) {
		this.strServiceTax = strServiceTax;
	}
 

	public String[] getStrOfflineTariffServiceTaxAmtVal() {
		return strOfflineTariffServiceTaxAmtVal;
	}

	public void setStrOfflineTariffServiceTaxAmtVal(
			String[] strOfflineTariffServiceTaxAmtVal) {
		this.strOfflineTariffServiceTaxAmtVal = strOfflineTariffServiceTaxAmtVal;
	}

	public String[] getStrOfflineTariffDiscountAmtVal() {
		return strOfflineTariffDiscountAmtVal;
	}

	public void setStrOfflineTariffDiscountAmtVal(
			String[] strOfflineTariffDiscountAmtVal) {
		this.strOfflineTariffDiscountAmtVal = strOfflineTariffDiscountAmtVal;
	}

	public String[] getStrOfflineTotalActualTariffAmtVal() {
		return strOfflineTotalActualTariffAmtVal;
	}

	public void setStrOfflineTotalActualTariffAmtVal(
			String[] strOfflineTotalActualTariffAmtVal) {
		this.strOfflineTotalActualTariffAmtVal = strOfflineTotalActualTariffAmtVal;
	}

	public String getStrReceiptNo() {
		return strReceiptNo;
	}

	public void setStrReceiptNo(String strReceiptNo) {
		this.strReceiptNo = strReceiptNo;
	}
 
	public WebRowSet getStrRequestNoList() {
		return strRequestNoList;
	}

	public void setStrRequestNoList(WebRowSet strRequestNoList) {
		this.strRequestNoList = strRequestNoList;
	}

	public String[] getStrTariffRefundDetailsId() {
		return strTariffRefundDetailsId;
	}

	public void setStrTariffRefundDetailsId(String[] strTariffRefundDetailsId) {
		this.strTariffRefundDetailsId = strTariffRefundDetailsId;
	}

	public String[] getStrOfflineRefundServiceTaxAmount() {
		return strOfflineRefundServiceTaxAmount;
	}

	public void setStrOfflineRefundServiceTaxAmount(
			String[] strOfflineRefundServiceTaxAmount) {
		this.strOfflineRefundServiceTaxAmount = strOfflineRefundServiceTaxAmount;
	}

	public String[] getStrOfflineRefundDiscountAmount() {
		return strOfflineRefundDiscountAmount;
	}

	public void setStrOfflineRefundDiscountAmount(
			String[] strOfflineRefundDiscountAmount) {
		this.strOfflineRefundDiscountAmount = strOfflineRefundDiscountAmount;
	}

	public String[] getStrOfflineRefundPenaltyAmount() {
		return strOfflineRefundPenaltyAmount;
	}

	public void setStrOfflineRefundPenaltyAmount(
			String[] strOfflineRefundPenaltyAmount) {
		this.strOfflineRefundPenaltyAmount = strOfflineRefundPenaltyAmount;
	}

	public String[] getStrOfflineRefundActualTariffAmount() {
		return strOfflineRefundActualTariffAmount;
	}

	public void setStrOfflineRefundActualTariffAmount(
			String[] strOfflineRefundActualTariffAmount) {
		this.strOfflineRefundActualTariffAmount = strOfflineRefundActualTariffAmount;
	}

	public WebRowSet getStrPaymentModeList() {
		return strPaymentModeList;
	}

	public void setStrPaymentModeList(WebRowSet strPaymentModeList) {
		this.strPaymentModeList = strPaymentModeList;
	}

	public WebRowSet getStrClientNameList() {
		return strClientNameList;
	}

	public void setStrClientNameList(WebRowSet strClientNameList) {
		this.strClientNameList = strClientNameList;
	}
 
	public String getStrTariffCode() {
		return strTariffCode;
	}

	public void setStrTariffCode(String strTariffCode) {
		this.strTariffCode = strTariffCode;
	}

	public String getStrPreviousCrNo() {
		return strPreviousCrNo;
	}

	public void setStrPreviousCrNo(String strPreviousCrNo) {
		this.strPreviousCrNo = strPreviousCrNo;
	}

	public String getStrPreviousCrNoDtlFlag() {
		return strPreviousCrNoDtlFlag;
	}

	public void setStrPreviousCrNoDtlFlag(String strPreviousCrNoDtlFlag) {
		this.strPreviousCrNoDtlFlag = strPreviousCrNoDtlFlag;
	}

	public String getStrPreviousCrNoPatientDtls() {
		return strPreviousCrNoPatientDtls;
	}

	public void setStrPreviousCrNoPatientDtls(String strPreviousCrNoPatientDtls) {
		this.strPreviousCrNoPatientDtls = strPreviousCrNoPatientDtls;
	}

	public String getStrSearchLetter() {
		return strSearchLetter;
	}

	public void setStrSearchLetter(String strSearchLetter) {
		this.strSearchLetter = strSearchLetter;
	}

	public String getStrClerkDiscount() {
		return strClerkDiscount;
	}

	public void setStrClerkDiscount(String strClerkDiscount) {
		this.strClerkDiscount = strClerkDiscount;
	}

	public String getStrIsApprovalRequired() {
		return strIsApprovalRequired;
	}

	public void setStrIsApprovalRequired(String strIsApprovalRequired) {
		this.strIsApprovalRequired = strIsApprovalRequired;
	}

	public String getStrOffLineSpecialWard() {
		return strOffLineSpecialWard;
	}

	public void setStrOffLineSpecialWard(String strOffLineSpecialWard) {
		this.strOffLineSpecialWard = strOffLineSpecialWard;
	}

	public WebRowSet getOfflineSplWardList() {
		return offlineSplWardList;
	}

	public void setOfflineSplWardList(WebRowSet offlineSplWardList) {
		this.offlineSplWardList = offlineSplWardList;
	}

	//Added setter/getter method for Adavnce Security Flag by garima gotra for HIS_PGI_BILL_CR_1on 17 Aug 2011
	public String getadvSecFlag() {
		return advSecFlag;
	}

	public void setadvSecFlag(String advSecFlag) {
		this.advSecFlag = advSecFlag;
	}

	public String getStrIsAdvanceRequired() {
		return strIsAdvanceRequired;
	}

	public void setStrIsAdvanceRequired(String strIsAdvanceRequired) {
		this.strIsAdvanceRequired = strIsAdvanceRequired;
	}

	public String getStrOffLineTreatmentCategoryGroup() {
		return strOffLineTreatmentCategoryGroup;
	}

	public void setStrOffLineTreatmentCategoryGroup(
			String strOffLineTreatmentCategoryGroup) {
		this.strOffLineTreatmentCategoryGroup = strOffLineTreatmentCategoryGroup;
	}

	public WebRowSet getAdmEpisodeTreatCatDeptDtls() {
		return admEpisodeTreatCatDeptDtls;
	}

	public void setAdmEpisodeTreatCatDeptDtls(WebRowSet admEpisodeTreatCatDeptDtls) {
		this.admEpisodeTreatCatDeptDtls = admEpisodeTreatCatDeptDtls;
	}
	public String[] getStrCreditPaymentType() {
		return strCreditPaymentType;
	}
	public void setStrCreditPaymentType(String[] strCreditPaymentType) {
		this.strCreditPaymentType = strCreditPaymentType;
	}

	public String[] getStrOfflineAmtPaidByClient() {
		return strOfflineAmtPaidByClient;
	}

	public void setStrOfflineAmtPaidByClient(String[] strOfflineAmtPaidByClient) {
		this.strOfflineAmtPaidByClient = strOfflineAmtPaidByClient;
	}

	public WebRowSet getCreditLettersWS() {
		return creditLettersWS;
	}

	public void setCreditLettersWS(WebRowSet creditLettersWS) {
		this.creditLettersWS = creditLettersWS;
	}

	public String getStrNewCreditLetterAddedFlag() {
		return strNewCreditLetterAddedFlag;
	}

	public void setStrNewCreditLetterAddedFlag(String strNewCreditLetterAddedFlag) {
		this.strNewCreditLetterAddedFlag = strNewCreditLetterAddedFlag;
	}

	public FormFile[] getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(FormFile[] uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public String[] getStrCreditFilePath() {
		return strCreditFilePath;
	}

	public void setStrCreditFilePath(String[] strCreditFilePath) {
		this.strCreditFilePath = strCreditFilePath;
	}

	public String getStrCreditBillApprovalDone() {
		return strCreditBillApprovalDone;
	}

	public void setStrCreditBillApprovalDone(String strCreditBillApprovalDone) {
		this.strCreditBillApprovalDone = strCreditBillApprovalDone;
	}

	public String getStrRoomLimit() {
		return strRoomLimit;
	}

	public void setStrRoomLimit(String strRoomLimit) {
		this.strRoomLimit = strRoomLimit;
	}

	public String[] getStrOfflineTariffRateUnit() {
		return strOfflineTariffRateUnit;
	}

	public void setStrOfflineTariffRateUnit(String[] strOfflineTariffRateUnit) {
		this.strOfflineTariffRateUnit = strOfflineTariffRateUnit;
	}

	public String getStrAdmissionDate() {
		return strAdmissionDate;
	}

	public void setStrAdmissionDate(String strAdmissionDate) {
		this.strAdmissionDate = strAdmissionDate;
	}

	public String getStrAdvCancelRefund() {
		return strAdvCancelRefund;
	}

	public void setStrAdvCancelRefund(String strAdvCancelRefund) {
		this.strAdvCancelRefund = strAdvCancelRefund;
	}

	public String getAdvSecFlag() {
		return advSecFlag;
	}

	public void setAdvSecFlag(String advSecFlag) {
		this.advSecFlag = advSecFlag;
	}

	public String getAccountCatDivCheked() {
		return accountCatDivCheked;
	}

	public void setAccountCatDivCheked(String accountCatDivCheked) {
		this.accountCatDivCheked = accountCatDivCheked;
	}

	public String getAccountCategory() {
		return accountCategory;
	}

	public void setAccountCategory(String accountCategory) {
		this.accountCategory = accountCategory;
	}

	public String getAccountCategoryList() {
		return accountCategoryList;
	}

	public void setAccountCategoryList(String accountCategoryList) {
		this.accountCategoryList = accountCategoryList;
	}

	public WebRowSet getAccCatWs() {
		return accCatWs;
	}

	public void setAccCatWs(WebRowSet accCatWs) {
		this.accCatWs = accCatWs;
	}

	public String getIsAdvanceZero() {
		return isAdvanceZero;
	}

	public void setIsAdvanceZero(String isAdvanceZero) {
		this.isAdvanceZero = isAdvanceZero;
	}

	public double getMoreThanAdv() {
		return MoreThanAdv;
	}

	public void setMoreThanAdv(double moreThanAdv) {
		MoreThanAdv = moreThanAdv;
	}

	public WebRowSet getAdvanceDtls() {
		return advanceDtls;
	}

	public void setAdvanceDtls(WebRowSet advanceDtls) {
		this.advanceDtls = advanceDtls;
	}

	public WebRowSet getStrQRCodeModeList() {
		return strQRCodeModeList;
	}

	public void setStrQRCodeModeList(WebRowSet strQRCodeModeList) {
		this.strQRCodeModeList = strQRCodeModeList;
	} 
	
	
}
