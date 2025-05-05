 package billing;



import java.util.LinkedHashMap;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import billing.BillConfigUtil;


public class CashCollectionOfflineTransFB extends ActionForm {

	private static final long serialVersionUID = 02L;
	
	java.util.LinkedHashMap<String, String> lhm = new java.util.LinkedHashMap<String, String>();

	private String strWarningMsg = "";
	private String strNormalMsg = "";
	private String strErrMsg = null;
	private String strQRCodeModeContents = "";
	
	private String strCounterMode = "0";  // 0 - Online, 1 - Offline, 2 - Both 
	
	private String strVisitType;
	public String getStrVisitType() {
		return strVisitType;
	}

	public void setStrVisitType(String strVisitType) {
		this.strVisitType = strVisitType;
	}
	private String strIsWithoutCrNoRequired = "0"; // 0 - Not Required, 1 - Required
	
	private String strIsRefPhysicanReq = "0"; // 0 - Not Required, 1 - Required
	private String strIsPreviousCrNoReq = "0"; // 0 - Not Required, 1 - Required
	private String strIsRefundReq = "0";  // 0 - Not Required , 1 - Required
	
	private String strConfirmationType = "0"; // 0 - Cancel, 1 - Ok
	
	private String strPreviousCrNo = "0";
	
	private String strPreviousCrNoSearch = "0";
	
	private String strPreviousCrNoDtlFlag = "0";
	
	private String strPrintMessageLimit = "0";
	
	private String strFreeCategory = "0";
	
	private String strIsApprovalRequired = "0";
	
	private String strIsAdvanceRequired = "0";
	
	private String strHospitalCode = "0";
	private String strSeatId ="0";
	private String strPatientMode = "1";
	private String strUserLevel = "0";
	private String strAdmissionDtlHidVal = "0";
	private String strOffLineRefundAdvanceAccountNo = "0";
	
	private String strTempBillNo = "0";
	private String strTempReceiptNo = "0";
	
	private String strOfflineIpdPenaltyVal = "0";
	private String strOfflineOpdPenaltyVal = "0";
	private String strOfflineEmergencyPenaltyVal = "0";
	
	private String strIsIpdDiscount = "0";
	private String strIsOpdDiscount = "0";
	private String strIsEmergencyDiscount = "0";
	
	private String strIpdThirdPartyBenefit = "0";
	private String strOpdThirdPartyBenefit = "0";
	private String strEmergencyThirdPartyBenefit = "0";
	
	private String strIpAddress = "0";
	
	private String strIsOnline = "0";
	
	private String currentState = "1";
	
	private String strCrNo = "";
	
	private String strPatientDetailsView = "";
	private String strAccountDetailsView = "";
	private String strAccountHeaderView = "";
	
 
	
	private String strHospitalService = "";
	private String strBillingService = "";
	private String strRaisingDepartment = "";
	private String strChargeTypeId = "";
	private String strAdmissionNo = "";
	private String strAccountNo = "";
	private String strEpisode = "";
	private String strTreatmentCategory = "";
	private String strIsAdmittedTreatmentCategoryPresent = "";
	private String strTreatmentCategoryGroup = "";
	private String strWard = "";
	private String strIpdChargeTypeId = "0";

	private String strRequestType = "0";
	private String strRequestNo = "0";
	private String strRequestDate = "";
	private String strService = "0";
	private String strRequestFor = "0";
	private String strGlobalRequestNo = "0";	
	
	private String strPartPaymentAmount = "0";
	private String strHospitalServiceDetails = "";
	private String strBillingServiceDetails = "";
	private String strBillNo = "0";
	private String strBillType = "1";
	private String strRaisingDepartmentDetails = "";
	private String strEpisodeDetails = "";
	private String strTreatmentCategoryDetails = "";
	private String strWardDetails = "";
	private String strSpecialWardDetails = "";
	private String strPartPayAdvanceAmountDetails = "";
	private String strApprovalId = "";
	private String strReceiptNo = "";
	
	private String strRequestBillTariffDetails = "0";
	private String strExpenseAmount = "0";
	private String strNetClientAmount = "0";
	private String strNetDiscountAmount = "0";
	private String strNetServiceTaxAmount = "0";
	private String strNetPaybleAmount = "0";
	
	private String strClientPayiedBy = "0";
	 
	
	private String strRemarks = ""; 
	
 
	
	private String strTotalTariffServiceTaxAmount = "0";
	private String strTotalTariffDiscountAmount = "0";
	private String strTotalTariffActualAmount = "0";
	private String strTotalTariffPenaltyAmount = "0";
	
	private String strRefundAdvancePenelty = "0";
	
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
	//private String[] strRefundTariffDetails = null;
	private String[] strTariffToBeRefundQty = null;
	private String[] strTariffRefundQty = null;
	private String[] strTariffRefundUnit = null;
	private String[] strTariffRefundCost = null;
	
	
	private String strOffLineGroup = "";
	private String strOffLinePakageGroup = "";
	private String strOfflineTariffName[] = null;
	private String strOfflineTempTariffName[] = null;
	private String strOfflineDiscountApprovedBy = "";
	private String strOfflineDiscountRemarks = "";
	
	private String strOffLineHospitalService = "";
	private String strOffLineBillingService = "";
	private String strOffLineRequestType = "1";
	private String strOffLineRaisingDepartment = "";
	private String strOffLineEpisode = "";
	private String strOffLineTreatmentCategory = "";
	private String strOffLineWard = "";
	private String strOffLineSpecialWard = "";
	private String strOffLineApprovedBy = "";
	private String strOffLineRemarks = "";
	private String strOffLinePartPaymentAmount = "";
	private String strOffLineAdvanceAmount = "";
	private String strOffLineClientPatientNo = "";
	private String strOffLineTreatmentCat = "";
	
	private String strOfflineClientDetails = null;
	
	private String strOffLineAdmissionNo = "0";
	
	private String strRefundReceiptNo = "0";
	
	private String strOfflineGroupDetails = "";
	private String strOfflineTariffDetails = "";
	private String strOfflinePkgsGroupDetails = "";
	private String strOfflineTariffUnitDetails = "";
	
	private String strOffLineClientDetailsHidden = "";
	private String strPartpayment = "0";
	private String strOffLineIpdChargeTypeId = "0";
	
	private String strChk_value = "0";
	//Adavnce Security Flag added by garima for HIS_PGI_BILL_CR_1on 17 Aug 2011
	private String advSecFlag = "0";
	
	private String strApprovedByCombo = "0";
	private String strRemarksCombo2 = "";
	
	private String strOffLineAccountNo = "0";
	private String strOffLineClientType = "0";
	private String strOffLineSancAmount = "0";
	private String strOffLineApprovalNo = "0";
	private String strOffLineBalanceAmount = "0";
	
	private String strOfflineDiscountApprovedByDetails = "";
	private String strOfflineDiscountRemarksDetails = "";
	
	
	private String strOfflineClientDetailsView = "";
	
	private String strOfflineBillDetails = "";
	private String strOfflineBillTariffDetails = "";
	
	
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
	private String[] strOfflineTariffRateUnit = null;
	
	private String strOfflineRefundBillDetails = "";
	
	private String strOffLineRefundBy = "0";
	private String strOffLineRefundByList = "";
	private String strOffLineRefundReason = "0";
	private String strOffLineRefundReasonDetails = "";
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
	
	private String strOfflineRefundTotalServiceTaxAmount = "0";
	private String strOfflineRefundTotalDiscountAmount = "0";
	private String strOfflineRefundTotalPenaltyAmount = "0";
	private String strOfflineRefundTotalActualTariffAmount = "0";
	
	
	private String strPaymentModeContents = "";
	private String strClientNameContents = "";
	
	private String[] strOfflinePaymentMode = null;
	private String[] strOfflinePaymentDtls = null;
	private String[] strOfflineAmount = null;
	
	private String strOfflineTotalRecAmount = "0";
	private String strOfflineTotalPayAmount = "0";
	private String strOfflineRefundAmount = "0";
	private String strOfflineMaxClientBenefitAmount = "0";
	private String strOfflinePatNetPayAmount = "0";
	private String strOfflineTotalActualTariffAmount = "0";
	
	private String strOfflineTotalServiceTaxAmount = "0";
	private String strOfflineTotalDiscountAmount = "0";
	
	private String strCurrentDate = "";
		
	private String strBillSearchString = "";
	private String strBillFromRow = "";
	private String strBillRowPerPage = "";
	private String strBillCtBlockSet = "";
	private String strBillUsrFuncName = "";

	 
	
	
	private String strRequestNoValues = "";
	
	private String strConsumableCharge="0";
	private String strGroupIdForConsumableConcatenated="";
	
	private String strOfflineTotalPayAmountWithoutConsumable="0";
	
	private String strConsumableChargesGroupId="";
	private String strConsumableChargesTariffCode="";
	private String isOpenPopUp;
	private String filePath="";
	private String printMode="0";
	
	
	private String strTreatmentCategoryCode="";
	private String strRmk="";
	/*private String strRelatinDetails;
	private String strEmployeeId="";
	private String strEmployeeName="";
	private String strRelationId="";
	private String strCardValidity="";
	private String strPayClientName;*/
	
	
	private String[] strCreditLetterNo;
    //private String[] strCreditRefDate1;
 
	//for storing path of file
    private FormFile[] uploadedFile =new FormFile[100];
    private FormFile[] uploadedFile2=new FormFile[100];
    
    private String[] strCreditPaymentType;
    
    private String scanDocID;//with what name file is saved..
    private String strCreditLetterValidity=BillConfigUtil.CREDIT_LETTER_VALIDITY_CHECK_DAYS;
    private String strCreditLetterNoList="";
    private String strNewCreditLetterAddedFlag="0";
    private String strArogyaCatId="";
    private String strArogyaTSCatId="";
    private String strArogyaTSCatCreditLimit="";
    private String[] strCreditFilePath;	
    private String strCreditBillApprovalDone="0";//0-Not Required,1-Done,2-Not Required Direct (Without Approval)
    private String strWalletNo="";
	private String strWalletNoMasked="";
	private String strAvlWalletMoney="0";
	private String strMobileNo="";
	private String strWchCatId="";
	private String strEpisodeFound = "";
	private String strRoomLimit="0";
	private String currentBserviceId = "1";
	private String strPackageComboValues = "";
    private String strPackageApply = "";
    private String strPackAppDate= "";
    private String strPackageDetails= "";
    private String strUrgSur="";
    private String grpid="";
    private String strSurCc="";
	private String strSurDc="";
	private String strSurIc="";
	private String strSurId="";
	private String strSurCc1="";
	private String strSurDc1="";
	private String strSurIc1="";
	private String strSurId1="";
	private Double defsurlim=0.00;
	private String strAdvCancelRefund="";
	private String accountCatDivCheked="2";
	private String accountCategory="";
	private String accountCategoryList="";
	private String advPayDtl="";
	private String onlyCatCahnge="";
	private String strPatientDtlHidVal="";
	
   /*public String getStrPayClientName() {
		return strPayClientName;
	}

	public void setStrPayClientName(String strPayClientName) {
		this.strPayClientName = strPayClientName;
	}*/


	

	public String getStrPackageDetails() {
		return strPackageDetails;
	}

	public void setStrPackageDetails(String strPackageDetails) {
		this.strPackageDetails = strPackageDetails;
	}

	public String getStrPackageComboValues() {
		return strPackageComboValues;
	}

	public void setStrPackageComboValues(String strPackageComboValues) {
		this.strPackageComboValues = strPackageComboValues;
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

	public String getCurrentBserviceId() {
		return currentBserviceId;
	}

	public void setCurrentBserviceId(String currentBserviceId) {
		this.currentBserviceId = currentBserviceId;
	}

	public String getStrEpisodeFound() {
		return strEpisodeFound;
	}

	public void setStrEpisodeFound(String strEpisodeFound) {
		this.strEpisodeFound = strEpisodeFound;
	}

	public String getStrWchCatId() {
		return strWchCatId;
	}

	public void setStrWchCatId(String strWchCatId) {
		this.strWchCatId = strWchCatId;
	}

	public String getStrWalletNo() {
		return strWalletNo;
	}

	public void setStrWalletNo(String strWalletNo) {
		this.strWalletNo = strWalletNo;
	}

	public String getStrWalletNoMasked() {
		return strWalletNoMasked;
	}

	public void setStrWalletNoMasked(String strWalletNoMasked) {
		this.strWalletNoMasked = strWalletNoMasked;
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

	public void setUploadedFile2(int index, FormFile file) {  
		uploadedFile2[index] = file;  
	}  
		   
	public FormFile getUploadedFile2(int index) {  
		  return uploadedFile2[index];  
	}
	
	

	

/*
	public FormFile[] getUploadedFile2() {
		return uploadedFile2;
	}

	public void setUploadedFile2(FormFile[] uploadedFile2) {
		this.uploadedFile2 = uploadedFile2;
	}*/

	/*public String getStrRelationId() {
		return strRelationId;
	}

	public void setStrRelationId(String strRelationId) {
		this.strRelationId = strRelationId;
	}*/

	public void setUploadedFile(int index, FormFile file) {  
		uploadedFile[index] = file;  
	}  
		   
	public FormFile getUploadedFile(int index) {  
		  return uploadedFile[index];  
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

	
	public String getScanDocID() {
		return scanDocID;
	}

	public void setScanDocID(String scanDocID) {
		this.scanDocID = scanDocID;
	}

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

	public String getStrRmk() {
		return strRmk;
	}

	public void setStrRmk(String strRmk) {
		this.strRmk = strRmk;
	}

	/*public String getStrRelatinDetails() {
		return strRelatinDetails;
	}

	public void setStrRelatinDetails(String strRelatinDetails) {
		this.strRelatinDetails = strRelatinDetails;
	}*/

	public String getStrTreatmentCategoryCode() {
		return strTreatmentCategoryCode;
	}

	public void setStrTreatmentCategoryCode(String strTreatmentCategoryCode) {
		this.strTreatmentCategoryCode = strTreatmentCategoryCode;
	}

	public String getStrIsAdvanceRequired() {
		return strIsAdvanceRequired;
	}

	public void setStrIsAdvanceRequired(String strIsAdvanceRequired) {
		this.strIsAdvanceRequired = strIsAdvanceRequired;
	}

	public String getStrRequestNoValues() {
		return strRequestNoValues;
	}

	public void setStrRequestNoValues(String strRequestNoValues) {
		this.strRequestNoValues = strRequestNoValues;
	}
 
	/**
	 * @return the strBillUsrFuncName
	 */
	public String getStrBillUsrFuncName() {
		return strBillUsrFuncName;
	}

	/**
	 * @param strBillUsrFuncName the strBillUsrFuncName to set
	 */
	public void setStrBillUsrFuncName(String strBillUsrFuncName) {
		this.strBillUsrFuncName = strBillUsrFuncName;
	}

	/**
	 * @return the strBillSearchString
	 */
	public String getStrBillSearchString() {
		return strBillSearchString;
	}

	/**
	 * @param strBillSearchString the strBillSearchString to set
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
	 * @param strBillFromRow the strBillFromRow to set
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
	 * @param strBillRowPerPage the strBillRowPerPage to set
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
	 * @param strBillCtBlockSet the strBillCtBlockSet to set
	 */
	public void setStrBillCtBlockSet(String strBillCtBlockSet) {
		this.strBillCtBlockSet = strBillCtBlockSet;
	}

	/**
	 * @return the strCurrentDate
	 */
	public String getStrCurrentDate() {
		return strCurrentDate;
	}

	/**
	 * @return the strMsgString
	 */
	

	/**
	 * @return the strHospitalCode
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	/**
	 * @param strHospitalCode the strHospitalCode to set
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
	 * @param strCrNo the strCrNo to set
	 */
	public void setStrCrNo(String strCrNo) {
		this.strCrNo = strCrNo;
	}

	/**
	 * @return the strPatientDetailsView
	 */
	public String getStrPatientDetailsView() {
		return strPatientDetailsView;
	}

	/**
	 * @param strPatientDetailsView the strPatientDetailsView to set
	 */
	public void setStrPatientDetailsView(String strPatientDetailsView) {
		this.strPatientDetailsView = strPatientDetailsView;
	}

	/**
	 * @return the strAccountDetailsView
	 */
	public String getStrAccountDetailsView() {
		return strAccountDetailsView;
	}

	/**
	 * @param strAccountDetailsView the strAccountDetailsView to set
	 */
	public void setStrAccountDetailsView(String strAccountDetailsView) {
		this.strAccountDetailsView = strAccountDetailsView;
	}

	/**
	 * @return the strAccountHeaderView
	 */
	public String getStrAccountHeaderView() {
		return strAccountHeaderView;
	}

	/**
	 * @param strAccountHeaderView the strAccountHeaderView to set
	 */
	public void setStrAccountHeaderView(String strAccountHeaderView) {
		this.strAccountHeaderView = strAccountHeaderView;
	}
 
	/**
	 * @return the strHospitalService
	 */
	public String getStrHospitalService() {
		return strHospitalService;
	}

	/**
	 * @param strHospitalService the strHospitalService to set
	 */
	public void setStrHospitalService(String strHospitalService) {
		this.strHospitalService = strHospitalService;
	}

	/**
	 * @return the strBillingService
	 */
	public String getStrBillingService() {
		return strBillingService;
	}

	/**
	 * @param strBillingService the strBillingService to set
	 */
	public void setStrBillingService(String strBillingService) {
		this.strBillingService = strBillingService;
	}

	/**
	 * @return the strRaisingDepartment
	 */
	public String getStrRaisingDepartment() {
		return strRaisingDepartment;
	}

	/**
	 * @param strRaisingDepartment the strRaisingDepartment to set
	 */
	public void setStrRaisingDepartment(String strRaisingDepartment) {
		this.strRaisingDepartment = strRaisingDepartment;
	}

	/**
	 * @return the strEpisode
	 */
	public String getStrEpisode() {
		return strEpisode;
	}

	/**
	 * @param strEpisode the strEpisode to set
	 */
	public void setStrEpisode(String strEpisode) {
		this.strEpisode = strEpisode;
	}

	/**
	 * @return the strTreatmentCategory
	 */
	public String getStrTreatmentCategory() {
		return strTreatmentCategory;
	}

	/**
	 * @param strTreatmentCategory the strTreatmentCategory to set
	 */
	public void setStrTreatmentCategory(String strTreatmentCategory) {
		this.strTreatmentCategory = strTreatmentCategory;
	}

	/**
	 * @return the strWard
	 */
	public String getStrWard() {
		return strWard;
	}

	/**
	 * @param strWard the strWard to set
	 */
	public void setStrWard(String strWard) {
		this.strWard = strWard;
	}

	/**
	 * @return the strHospitalServiceDetails
	 */
	public String getStrHospitalServiceDetails() {
		return strHospitalServiceDetails;
	}

	/**
	 * @param strHospitalServiceDetails the strHospitalServiceDetails to set
	 */
	public void setStrHospitalServiceDetails(String strHospitalServiceDetails) {
		this.strHospitalServiceDetails = strHospitalServiceDetails;
	}

	/**
	 * @return the strBillingServiceDetails
	 */
	public String getStrBillingServiceDetails() {
		return strBillingServiceDetails;
	}

	/**
	 * @param strBillingServiceDetails the strBillingServiceDetails to set
	 */
	public void setStrBillingServiceDetails(String strBillingServiceDetails) {
		this.strBillingServiceDetails = strBillingServiceDetails;
	}

	/**
	 * @return the strRaisingDepartmentDetails
	 */
	public String getStrRaisingDepartmentDetails() {
		return strRaisingDepartmentDetails;
	}

	/**
	 * @param strRaisingDepartmentDetails the strRaisingDepartmentDetails to set
	 */
	public void setStrRaisingDepartmentDetails(String strRaisingDepartmentDetails) {
		this.strRaisingDepartmentDetails = strRaisingDepartmentDetails;
	}

	/**
	 * @return the strEpisodeDetails
	 */
	public String getStrEpisodeDetails() {
		return strEpisodeDetails;
	}

	/**
	 * @param strEpisodeDetails the strEpisodeDetails to set
	 */
	public void setStrEpisodeDetails(String strEpisodeDetails) {
		this.strEpisodeDetails = strEpisodeDetails;
	}

	/**
	 * @return the strTreatmentCategoryDetails
	 */
	public String getStrTreatmentCategoryDetails() {
		return strTreatmentCategoryDetails;
	}

	/**
	 * @param strTreatmentCategoryDetails the strTreatmentCategoryDetails to set
	 */
	public void setStrTreatmentCategoryDetails(String strTreatmentCategoryDetails) {
		this.strTreatmentCategoryDetails = strTreatmentCategoryDetails;
	}

	/**
	 * @return the strWardDetails
	 */
	public String getStrWardDetails() {
		return strWardDetails;
	}

	/**
	 * @param strWardDetails the strWardDetails to set
	 */
	public void setStrWardDetails(String strWardDetails) {
		this.strWardDetails = strWardDetails;
	}

	/**
	 * @return the strPartPayAdvanceAmountDetails
	 */
	public String getStrPartPayAdvanceAmountDetails() {
		return strPartPayAdvanceAmountDetails;
	}

	/**
	 * @param strPartPayAdvanceAmountDetails the strPartPayAdvanceAmountDetails to set
	 */
	public void setStrPartPayAdvanceAmountDetails(
			String strPartPayAdvanceAmountDetails) {
		this.strPartPayAdvanceAmountDetails = strPartPayAdvanceAmountDetails;
	}

	/**
	 * @return the strOffLineGroup
	 */
	public String getStrOffLineGroup() {
		return strOffLineGroup;
	}

	/**
	 * @param strOffLineGroup the strOffLineGroup to set
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
	 * @param strOffLinePakageGroup the strOffLinePakageGroup to set
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
	 * @param strOfflineTariffName the strOfflineTariffName to set
	 */
	public void setStrOfflineTariffName(String[] strOfflineTariffName) {
		this.strOfflineTariffName = strOfflineTariffName;
	}

	/**
	 * @return the strOfflineGroupDetails
	 */
	public String getStrOfflineGroupDetails() {
		return strOfflineGroupDetails;
	}

	/**
	 * @param strOfflineGroupDetails the strOfflineGroupDetails to set
	 */
	public void setStrOfflineGroupDetails(String strOfflineGroupDetails) {
		this.strOfflineGroupDetails = strOfflineGroupDetails;
	}

	/**
	 * @return the strOfflineTariffDetails
	 */
	public String getStrOfflineTariffDetails() {
		return strOfflineTariffDetails;
	}

	/**
	 * @param strOfflineTariffDetails the strOfflineTariffDetails to set
	 */
	public void setStrOfflineTariffDetails(String strOfflineTariffDetails) {
		this.strOfflineTariffDetails = strOfflineTariffDetails;
	}

	/**
	 * @return the strOfflinePkgsGroupDetails
	 */
	public String getStrOfflinePkgsGroupDetails() {
		return strOfflinePkgsGroupDetails;
	}

	/**
	 * @param strOfflinePkgsGroupDetails the strOfflinePkgsGroupDetails to set
	 */
	public void setStrOfflinePkgsGroupDetails(String strOfflinePkgsGroupDetails) {
		this.strOfflinePkgsGroupDetails = strOfflinePkgsGroupDetails;
	}

	/**
	 * @return the strOfflineClientDetailsView
	 */
	public String getStrOfflineClientDetailsView() {
		return strOfflineClientDetailsView;
	}

	/**
	 * @param strOfflineClientDetailsView the strOfflineClientDetailsView to set
	 */
	public void setStrOfflineClientDetailsView(String strOfflineClientDetailsView) {
		this.strOfflineClientDetailsView = strOfflineClientDetailsView;
	}

	/**
	 * @return the strOfflineDiscountApprovedBy
	 */
	public String getStrOfflineDiscountApprovedBy() {
		return strOfflineDiscountApprovedBy;
	}

	/**
	 * @param strOfflineDiscountApprovedBy the strOfflineDiscountApprovedBy to set
	 */
	public void setStrOfflineDiscountApprovedBy(String strOfflineDiscountApprovedBy) {
		this.strOfflineDiscountApprovedBy = strOfflineDiscountApprovedBy;
	}

	
	/**
	 * @return the strOfflineDiscountRemarksDetails
	 */
	public String getStrOfflineDiscountRemarksDetails() {
		return strOfflineDiscountRemarksDetails;
	}

	/**
	 * @param strOfflineDiscountRemarksDetails the strOfflineDiscountRemarksDetails to set
	 */
	public void setStrOfflineDiscountRemarksDetails(
			String strOfflineDiscountRemarksDetails) {
		this.strOfflineDiscountRemarksDetails = strOfflineDiscountRemarksDetails;
	}

	/**
	 * @return the strOfflineDiscountApprovedByDetails
	 */
	public String getStrOfflineDiscountApprovedByDetails() {
		return strOfflineDiscountApprovedByDetails;
	}

	/**
	 * @param strOfflineDiscountApprovedByDetails the strOfflineDiscountApprovedByDetails to set
	 */
	public void setStrOfflineDiscountApprovedByDetails(
			String strOfflineDiscountApprovedByDetails) {
		this.strOfflineDiscountApprovedByDetails = strOfflineDiscountApprovedByDetails;
	}

	/**
	 * @return the strOfflineDiscountRemarks
	 */
	public String getStrOfflineDiscountRemarks() {
		return strOfflineDiscountRemarks;
	}

	/**
	 * @param strOfflineDiscountRemarks the strOfflineDiscountRemarks to set
	 */
	public void setStrOfflineDiscountRemarks(String strOfflineDiscountRemarks) {
		this.strOfflineDiscountRemarks = strOfflineDiscountRemarks;
	}

	/**
	 * @return the strOfflineTariffUnitDetails
	 */
	public String getStrOfflineTariffUnitDetails() {
		return strOfflineTariffUnitDetails;
	}

	/**
	 * @param strOfflineTariffUnitDetails the strOfflineTariffUnitDetails to set
	 */
	public void setStrOfflineTariffUnitDetails(String strOfflineTariffUnitDetails) {
		this.strOfflineTariffUnitDetails = strOfflineTariffUnitDetails;
	}

	/**
	 * @param strCurrentDate the strCurrentDate to set
	 */
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}

	/**
	 * @return the strOfflineBillDetails
	 */
	public String getStrOfflineBillDetails() {
		return strOfflineBillDetails;
	}

	/**
	 * @param strOfflineBillDetails the strOfflineBillDetails to set
	 */
	public void setStrOfflineBillDetails(String strOfflineBillDetails) {
		this.strOfflineBillDetails = strOfflineBillDetails;
	}

	/**
	 * @return the strOfflineBillTariffDetails
	 */
	public String getStrOfflineBillTariffDetails() {
		return strOfflineBillTariffDetails;
	}

	/**
	 * @param strOfflineBillTariffDetails the strOfflineBillTariffDetails to set
	 */
	public void setStrOfflineBillTariffDetails(String strOfflineBillTariffDetails) {
		this.strOfflineBillTariffDetails = strOfflineBillTariffDetails;
	}

	/**
	 * @return the strPatientMode
	 */
	public String getStrPatientMode() {
		return strPatientMode;
	}

	/**
	 * @param strPatientMode the strPatientMode to set
	 */
	public void setStrPatientMode(String strPatientMode) {
		this.strPatientMode = strPatientMode;
	}

	/**
	 * @return the strOffLineHospitalService
	 */
	public String getStrOffLineHospitalService() {
		return strOffLineHospitalService;
	}

	/**
	 * @param strOffLineHospitalService the strOffLineHospitalService to set
	 */
	public void setStrOffLineHospitalService(String strOffLineHospitalService) {
		this.strOffLineHospitalService = strOffLineHospitalService;
	}

	/**
	 * @return the strOffLineTreatmentCategory
	 */
	public String getStrOffLineTreatmentCategory() {
		return strOffLineTreatmentCategory;
	}

	/**
	 * @param strOffLineTreatmentCategory the strOffLineTreatmentCategory to set
	 */
	public void setStrOffLineTreatmentCategory(String strOffLineTreatmentCategory) {
		this.strOffLineTreatmentCategory = strOffLineTreatmentCategory;
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

	public String getStrPartPaymentAmount() {
		return strPartPaymentAmount;
	}

	public void setStrPartPaymentAmount(String strPartPaymentAmount) {
		this.strPartPaymentAmount = strPartPaymentAmount;
	}
 
	public String getStrChargeTypeId() {
		return strChargeTypeId;
	}

	public void setStrChargeTypeId(String strChargeTypeId) {
		this.strChargeTypeId = strChargeTypeId;
	}

	public String getStrAdmissionNo() {
		return strAdmissionNo;
	}

	public void setStrAdmissionNo(String strAdmissionNo) {
		this.strAdmissionNo = strAdmissionNo;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	public String getStrIpdChargeTypeId() {
		return strIpdChargeTypeId;
	}

	public void setStrIpdChargeTypeId(String strIpdChargeTypeId) {
		this.strIpdChargeTypeId = strIpdChargeTypeId;
	}

	public String getStrRequestType() {
		return strRequestType;
	}

	public void setStrRequestType(String strRequestType) {
		this.strRequestType = strRequestType;
	}

	public String getStrRequestNo() {
		return strRequestNo;
	}

	public void setStrRequestNo(String strRequestNo) {
		this.strRequestNo = strRequestNo;
	}

	public String getStrRequestFor() {
		return strRequestFor;
	}

	public void setStrRequestFor(String strRequestFor) {
		this.strRequestFor = strRequestFor;
	}

	public String getStrAccountNo() {
		return strAccountNo;
	}

	public void setStrAccountNo(String strAccountNo) {
		this.strAccountNo = strAccountNo;
	}

	public String getStrBillNo() {
		return strBillNo;
	}

	public void setStrBillNo(String strBillNo) {
		this.strBillNo = strBillNo;
	}

	public String getStrApprovalId() {
		return strApprovalId;
	}

	public void setStrApprovalId(String strApprovalId) {
		this.strApprovalId = strApprovalId;
	}

	public String getStrReceiptNo() {
		return strReceiptNo;
	}

	public void setStrReceiptNo(String strReceiptNo) {
		this.strReceiptNo = strReceiptNo;
	}

	public String getStrSeatId() {
		return strSeatId;
	}

	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	public String getStrOffLineClientDetailsHidden() {
		return strOffLineClientDetailsHidden;
	}

	public void setStrOffLineClientDetailsHidden(
			String strOffLineClientDetailsHidden) {
		this.strOffLineClientDetailsHidden = strOffLineClientDetailsHidden;
	}

	public String getStrOffLineAccountNo() {
		return strOffLineAccountNo;
	}

	public void setStrOffLineAccountNo(String strOffLineAccountNo) {
		this.strOffLineAccountNo = strOffLineAccountNo;
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
	 * @return the strOffLineBillingService
	 */
	public String getStrOffLineBillingService() {
		return strOffLineBillingService;
	}

	/**
	 * @param strOffLineBillingService the strOffLineBillingService to set
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
	 * @param strOffLineRequestType the strOffLineRequestType to set
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
	 * @param strOffLineRaisingDepartment the strOffLineRaisingDepartment to set
	 */
	public void setStrOffLineRaisingDepartment(String strOffLineRaisingDepartment) {
		this.strOffLineRaisingDepartment = strOffLineRaisingDepartment;
	}

	/**
	 * @return the strOffLineEpisode
	 */
	public String getStrOffLineEpisode() {
		return strOffLineEpisode;
	}

	/**
	 * @param strOffLineEpisode the strOffLineEpisode to set
	 */
	public void setStrOffLineEpisode(String strOffLineEpisode) {
		this.strOffLineEpisode = strOffLineEpisode;
	}

	/**
	 * @return the strOffLineWard
	 */
	public String getStrOffLineWard() {
		return strOffLineWard;
	}

	/**
	 * @param strOffLineWard the strOffLineWard to set
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
	 * @param strOffLineApprovedBy the strOffLineApprovedBy to set
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
	 * @param strOffLineRemarks the strOffLineRemarks to set
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
	 * @param strOffLinePartPaymentAmount the strOffLinePartPaymentAmount to set
	 */
	public void setStrOffLinePartPaymentAmount(String strOffLinePartPaymentAmount) {
		this.strOffLinePartPaymentAmount = strOffLinePartPaymentAmount;
	}

	/**
	 * @return the strOffLineAdvanceAmount
	 */
	public String getStrOffLineAdvanceAmount() {
		return strOffLineAdvanceAmount;
	}

	/**
	 * @param strOffLineAdvanceAmount the strOffLineAdvanceAmount to set
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
	 * @param strOffLineClientPatientNo the strOffLineClientPatientNo to set
	 */
	public void setStrOffLineClientPatientNo(String strOffLineClientPatientNo) {
		this.strOffLineClientPatientNo = strOffLineClientPatientNo;
	}

	/**
	 * @return the strOffLineTreatmentCat
	 */
	public String getStrOffLineTreatmentCat() {
		return strOffLineTreatmentCat;
	}

	/**
	 * @param strOffLineTreatmentCat the strOffLineTreatmentCat to set
	 */
	public void setStrOffLineTreatmentCat(String strOffLineTreatmentCat) {
		this.strOffLineTreatmentCat = strOffLineTreatmentCat;
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
	 * @return the strPartpayment
	 */
	public String getStrPartpayment() {
		return strPartpayment;
	}

	/**
	 * @param strPartpayment the strPartpayment to set
	 */
	public void setStrPartpayment(String strPartpayment) {
		this.strPartpayment = strPartpayment;
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
	 * @return the strAdmissionDtlHidVal
	 */
	public String getStrAdmissionDtlHidVal() {
		return strAdmissionDtlHidVal;
	}

	/**
	 * @param strAdmissionDtlHidVal the strAdmissionDtlHidVal to set
	 */
	public void setStrAdmissionDtlHidVal(String strAdmissionDtlHidVal) {
		this.strAdmissionDtlHidVal = strAdmissionDtlHidVal;
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

	/**
	 * @return the strIpAddress
	 */
	public String getStrIpAddress() {
		return strIpAddress;
	}

	/**
	 * @param strIpAddress the strIpAddress to set
	 */
	public void setStrIpAddress(String strIpAddress) {
		this.strIpAddress = strIpAddress;
	}

	public String getStrErrMsg() {
		return strErrMsg;
	}

	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}

	public String getStrWarningMsg() {
		return strWarningMsg;
	}

	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}

	public String getStrNormalMsg() {
		return strNormalMsg;
	}

	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}

	public String getStrIsOnline() {
		return strIsOnline;
	}

	public void setStrIsOnline(String strIsOnline) {
		this.strIsOnline = strIsOnline;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public String getStrIpdThirdPartyBenefit() {
		return strIpdThirdPartyBenefit;
	}

	public void setStrIpdThirdPartyBenefit(String strIpdThirdPartyBenefit) {
		this.strIpdThirdPartyBenefit = strIpdThirdPartyBenefit;
	}

	public String getStrOpdThirdPartyBenefit() {
		return strOpdThirdPartyBenefit;
	}

	public void setStrOpdThirdPartyBenefit(String strOpdThirdPartyBenefit) {
		this.strOpdThirdPartyBenefit = strOpdThirdPartyBenefit;
	}

	public String getStrEmergencyThirdPartyBenefit() {
		return strEmergencyThirdPartyBenefit;
	}

	public void setStrEmergencyThirdPartyBenefit(
			String strEmergencyThirdPartyBenefit) {
		this.strEmergencyThirdPartyBenefit = strEmergencyThirdPartyBenefit;
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

	public String getStrOfflineIpdPenaltyVal() {
		return strOfflineIpdPenaltyVal;
	}

	public void setStrOfflineIpdPenaltyVal(String strOfflineIpdPenaltyVal) {
		this.strOfflineIpdPenaltyVal = strOfflineIpdPenaltyVal;
	}

	public String getStrOfflineOpdPenaltyVal() {
		return strOfflineOpdPenaltyVal;
	}

	public void setStrOfflineOpdPenaltyVal(String strOfflineOpdPenaltyVal) {
		this.strOfflineOpdPenaltyVal = strOfflineOpdPenaltyVal;
	}

	public String getStrOfflineEmergencyPenaltyVal() {
		return strOfflineEmergencyPenaltyVal;
	}

	public void setStrOfflineEmergencyPenaltyVal(
			String strOfflineEmergencyPenaltyVal) {
		this.strOfflineEmergencyPenaltyVal = strOfflineEmergencyPenaltyVal;
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

	public String getStrClientPayiedBy() {
		return strClientPayiedBy;
	}

	public void setStrClientPayiedBy(String strClientPayiedBy) {
		this.strClientPayiedBy = strClientPayiedBy;
	}
 
	public String getStrOfflineClientDetails() {
		return strOfflineClientDetails;
	}

	public void setStrOfflineClientDetails(String strOfflineClientDetails) {
		this.strOfflineClientDetails = strOfflineClientDetails;
	}

	public String getStrRequestBillTariffDetails() {
		return strRequestBillTariffDetails;
	}

	public void setStrRequestBillTariffDetails(String strRequestBillTariffDetails) {
		this.strRequestBillTariffDetails = strRequestBillTariffDetails;
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

	public String getStrBillType() {
		return strBillType;
	}

	public void setStrBillType(String strBillType) {
		this.strBillType = strBillType;
	}

	public String getStrRefundReceiptNo() {
		return strRefundReceiptNo;
	}

	public void setStrRefundReceiptNo(String strRefundReceiptNo) {
		this.strRefundReceiptNo = strRefundReceiptNo;
	}

	public String getStrTempBillNo() {
		return strTempBillNo;
	}

	public void setStrTempBillNo(String strTempBillNo) {
		this.strTempBillNo = strTempBillNo;
	}

	public String getStrTempReceiptNo() {
		return strTempReceiptNo;
	}

	public void setStrTempReceiptNo(String strTempReceiptNo) {
		this.strTempReceiptNo = strTempReceiptNo;
	}

	public String getStrIsIpdDiscount() {
		return strIsIpdDiscount;
	}

	public void setStrIsIpdDiscount(String strIsIpdDiscount) {
		this.strIsIpdDiscount = strIsIpdDiscount;
	}

	public String getStrIsOpdDiscount() {
		return strIsOpdDiscount;
	}

	public void setStrIsOpdDiscount(String strIsOpdDiscount) {
		this.strIsOpdDiscount = strIsOpdDiscount;
	}

	public String getStrIsEmergencyDiscount() {
		return strIsEmergencyDiscount;
	}

	public void setStrIsEmergencyDiscount(String strIsEmergencyDiscount) {
		this.strIsEmergencyDiscount = strIsEmergencyDiscount;
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

	public String getStrPaymentModeContents() {
		return strPaymentModeContents;
	}

	public void setStrPaymentModeContents(String strPaymentModeContents) {
		this.strPaymentModeContents = strPaymentModeContents;
	}

	public String getStrClientNameContents() {
		return strClientNameContents;
	}

	public void setStrClientNameContents(String strClientNameContents) {
		this.strClientNameContents = strClientNameContents;
	}

	public String getStrCounterMode() {
		return strCounterMode;
	}

	public void setStrCounterMode(String strCounterMode) {
		this.strCounterMode = strCounterMode;
	}

	public String getStrIsWithoutCrNoRequired() {
		return strIsWithoutCrNoRequired;
	}

	public void setStrIsWithoutCrNoRequired(String strIsWithoutCrNoRequired) {
		this.strIsWithoutCrNoRequired = strIsWithoutCrNoRequired;
	}
 

	public String getStrIsRefPhysicanReq() {
		return strIsRefPhysicanReq;
	}

	public void setStrIsRefPhysicanReq(String strIsRefPhysicanReq) {
		this.strIsRefPhysicanReq = strIsRefPhysicanReq;
	}

	public String getStrIsPreviousCrNoReq() {
		return strIsPreviousCrNoReq;
	}

	public void setStrIsPreviousCrNoReq(String strIsPreviousCrNoReq) {
		this.strIsPreviousCrNoReq = strIsPreviousCrNoReq;
	}

	public String getStrPreviousCrNo() {
		return strPreviousCrNo;
	}

	public void setStrPreviousCrNo(String strPreviousCrNo) {
		this.strPreviousCrNo = strPreviousCrNo;
	}

	public String getStrConfirmationType() {
		return strConfirmationType;
	}

	public void setStrConfirmationType(String strConfirmationType) {
		this.strConfirmationType = strConfirmationType;
	}

	public String getStrPreviousCrNoSearch() {
		return strPreviousCrNoSearch;
	}

	public void setStrPreviousCrNoSearch(String strPreviousCrNoSearch) {
		this.strPreviousCrNoSearch = strPreviousCrNoSearch;
	}

	public String getStrPreviousCrNoDtlFlag() {
		return strPreviousCrNoDtlFlag;
	}

	public void setStrPreviousCrNoDtlFlag(String strPreviousCrNoDtlFlag) {
		this.strPreviousCrNoDtlFlag = strPreviousCrNoDtlFlag;
	}

	public String getStrOffLineRefundReasonDetails() {
		return strOffLineRefundReasonDetails;
	}

	public void setStrOffLineRefundReasonDetails(
			String strOffLineRefundReasonDetails) {
		this.strOffLineRefundReasonDetails = strOffLineRefundReasonDetails;
	}

	public String getStrOffLineRefundByList() {
		return strOffLineRefundByList;
	}

	public void setStrOffLineRefundByList(String strOffLineRefundByList) {
		this.strOffLineRefundByList = strOffLineRefundByList;
	}

	public String getStrIsRefundReq() {
		return strIsRefundReq;
	}

	public void setStrIsRefundReq(String strIsRefundReq) {
		this.strIsRefundReq = strIsRefundReq;
	}

	public String getStrPrintMessageLimit() {
		return strPrintMessageLimit;
	}

	public void setStrPrintMessageLimit(String strPrintMessageLimit) {
		this.strPrintMessageLimit = strPrintMessageLimit;
	}

	public String getStrFreeCategory() {
		return strFreeCategory;
	}

	public void setStrFreeCategory(String strFreeCategory) {
		this.strFreeCategory = strFreeCategory;
	}

	public String getStrIsApprovalRequired() {
		return strIsApprovalRequired;
	}

	public void setStrIsApprovalRequired(String strIsApprovalRequired) {
		this.strIsApprovalRequired = strIsApprovalRequired;
	}

	public String getStrSpecialWardDetails() {
		return strSpecialWardDetails;
	}

	public void setStrSpecialWardDetails(String strSpecialWardDetails) {
		this.strSpecialWardDetails = strSpecialWardDetails;
	}

	public String getStrOffLineSpecialWard() {
		return strOffLineSpecialWard;
	}

	public void setStrOffLineSpecialWard(String strOffLineSpecialWard) {
		this.strOffLineSpecialWard = strOffLineSpecialWard;
	}

	//Added setter/getter method for Adavnce Security Flag by garima gotra for HIS_PGI_BILL_CR_1on 17 Aug 2011
	public String getadvSecFlag() {
		return advSecFlag;
	}

	public void setadvSecFlag(String advSecFlag) {
		this.advSecFlag = advSecFlag;
	}

	public String getStrConsumableCharge() {
		return strConsumableCharge;
	}

	public void setStrConsumableCharge(String strConsumableCharge) {
		this.strConsumableCharge = strConsumableCharge;
	}

	public String getStrGroupIdForConsumableConcatenated() {
		return strGroupIdForConsumableConcatenated;
	}

	public void setStrGroupIdForConsumableConcatenated(
			String strGroupIdForConsumableConcatenated) {
		this.strGroupIdForConsumableConcatenated = strGroupIdForConsumableConcatenated;
	}

	public String getStrOfflineTotalPayAmountWithoutConsumable() {
		return strOfflineTotalPayAmountWithoutConsumable;
	}

	public void setStrOfflineTotalPayAmountWithoutConsumable(
			String strOfflineTotalPayAmountWithoutConsumable) {
		this.strOfflineTotalPayAmountWithoutConsumable = strOfflineTotalPayAmountWithoutConsumable;
	}

	public String getStrConsumableChargesGroupId() {
		return strConsumableChargesGroupId;
	}

	public void setStrConsumableChargesGroupId(String strConsumableChargesGroupId) {
		this.strConsumableChargesGroupId = strConsumableChargesGroupId;
	}

	public String getStrConsumableChargesTariffCode() {
		return strConsumableChargesTariffCode;
	}

	public void setStrConsumableChargesTariffCode(
			String strConsumableChargesTariffCode) {
		this.strConsumableChargesTariffCode = strConsumableChargesTariffCode;
	}

	public String getAdvSecFlag()
	{
		return advSecFlag;
	}

	public void setAdvSecFlag(String advSecFlag)
	{
		this.advSecFlag = advSecFlag;
	}

	public String getIsOpenPopUp()
	{
		return isOpenPopUp;
	}

	public void setIsOpenPopUp(String isOpenPopUp)
	{
		this.isOpenPopUp = isOpenPopUp;
	}

	public String getFilePath()
	{
		return filePath;
	}

	public void setFilePath(String filePath)
	{
		this.filePath = filePath;
	}

	public String getPrintMode()
	{
		return printMode;
	}

	public void setPrintMode(String printMode)
	{
		this.printMode = printMode;
	}

	public String getStrIsAdmittedTreatmentCategoryPresent() {
		return strIsAdmittedTreatmentCategoryPresent;
	}

	public void setStrIsAdmittedTreatmentCategoryPresent(
			String strIsAdmittedTreatmentCategoryPresent) {
		this.strIsAdmittedTreatmentCategoryPresent = strIsAdmittedTreatmentCategoryPresent;
	}

	public String getStrTreatmentCategoryGroup() {
		return strTreatmentCategoryGroup;
	}

	public void setStrTreatmentCategoryGroup(String strTreatmentCategoryGroup) {
		this.strTreatmentCategoryGroup = strTreatmentCategoryGroup;
	}
	/*public String getStrCardValidity() {
		return strCardValidity;
	}
	public void setStrCardValidity(String strCardValidity) {
		this.strCardValidity = strCardValidity;
	}*/
	public String[] getStrCreditPaymentType() {
		return strCreditPaymentType;
	}
	public void setStrCreditPaymentType(String[] strCreditPaymentType) {
		this.strCreditPaymentType = strCreditPaymentType;
	}

	public String getStrCreditLetterValidity() 
	{
		return BillConfigUtil.CREDIT_LETTER_VALIDITY_CHECK_DAYS;
	}
	public void setStrCreditLetterValidity(String strCreditLetterValidity) 
	{
		this.strCreditLetterValidity = BillConfigUtil.CREDIT_LETTER_VALIDITY_CHECK_DAYS;
	}
	public String[] getStrOfflineAmtPaidByClient() {
		return strOfflineAmtPaidByClient;
	}

	public void setStrOfflineAmtPaidByClient(String[] strOfflineAmtPaidByClient) {
		this.strOfflineAmtPaidByClient = strOfflineAmtPaidByClient;
	} 
	public String getStrCreditLetterNoList() {
		return strCreditLetterNoList;
	}

	public void setStrCreditLetterNoList(String strCreditLetterNoList) {
		this.strCreditLetterNoList = strCreditLetterNoList;
	}

	public String getStrNewCreditLetterAddedFlag() {
		return strNewCreditLetterAddedFlag;
	}

	public void setStrNewCreditLetterAddedFlag(String strNewCreditLetterAddedFlag) {
		this.strNewCreditLetterAddedFlag = strNewCreditLetterAddedFlag;
	}

	public String getStrArogyaCatId() {
		return strArogyaCatId;
	}

	public void setStrArogyaCatId(String strArogyaCatId) {
		this.strArogyaCatId = strArogyaCatId;
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

	public String getStrArogyaTSCatId() {
		return strArogyaTSCatId;
	}

	public void setStrArogyaTSCatId(String strArogyaTSCatId) {
		this.strArogyaTSCatId = strArogyaTSCatId;
	}

	public String getStrArogyaTSCatCreditLimit() {
		return strArogyaTSCatCreditLimit;
	}

	public void setStrArogyaTSCatCreditLimit(String strArogyaTSCatCreditLimit) {
		this.strArogyaTSCatCreditLimit = strArogyaTSCatCreditLimit;
	}
	

	public String[] getStrOfflineTariffRateUnit() {
		return strOfflineTariffRateUnit;
	}

	public void setStrOfflineTariffRateUnit(String[] strOfflineTariffRateUnit) {
		this.strOfflineTariffRateUnit = strOfflineTariffRateUnit;
	}

	public String getStrRoomLimit() {
		return strRoomLimit;
	}

	public void setStrRoomLimit(String strRoomLimit) {
		this.strRoomLimit = strRoomLimit;
	}

	public LinkedHashMap<String, String> getLhm() 
	{
		lhm.put("Cash Collection Request Based", "ONLINE");
		lhm.put("Cash Collection Direct(Without Request)", "OFFLINE");
		//lhm.put("Cash Collection Without CR", "WITHOUTCRNO");
		//lhm.put("Cash Collection Advanced", "ADVANCED");
		//lhm.put("Cash Collection LF Account", "LF");
		lhm.put("Patient Wallet", "PATWALLET");
		return lhm;
	}
	public void setLhm(java.util.LinkedHashMap<String, String> lhm) 
	{
		this.lhm = lhm;
	}

	public String getStrUrgSur() {
		return strUrgSur;
	}

	public void setStrUrgSur(String strUrgSur) {
		this.strUrgSur = strUrgSur;
	}

	public String getGrpid() {
		return grpid;
	}

	public void setGrpid(String grpid) {
		this.grpid = grpid;
	}

	public String getStrSurCc() {
		return strSurCc;
	}

	public void setStrSurCc(String strSurCc) {
		this.strSurCc = strSurCc;
	}

	public String getStrSurDc() {
		return strSurDc;
	}

	public void setStrSurDc(String strSurDc) {
		this.strSurDc = strSurDc;
	}

	public String getStrSurIc() {
		return strSurIc;
	}

	public void setStrSurIc(String strSurIc) {
		this.strSurIc = strSurIc;
	}

	public String getStrSurId() {
		return strSurId;
	}

	public void setStrSurId(String strSurId) {
		this.strSurId = strSurId;
	}

	public String getStrSurCc1() {
		return strSurCc1;
	}

	public void setStrSurCc1(String strSurCc1) {
		this.strSurCc1 = strSurCc1;
	}

	public String getStrSurDc1() {
		return strSurDc1;
	}

	public void setStrSurDc1(String strSurDc1) {
		this.strSurDc1 = strSurDc1;
	}

	public String getStrSurIc1() {
		return strSurIc1;
	}

	public void setStrSurIc1(String strSurIc1) {
		this.strSurIc1 = strSurIc1;
	}

	public String getStrSurId1() {
		return strSurId1;
	}

	public void setStrSurId1(String strSurId1) {
		this.strSurId1 = strSurId1;
	}

	public Double getDefsurlim() {
		return defsurlim;
	}

	public void setDefsurlim(Double defsurlim) {
		this.defsurlim = defsurlim;
	}

	public String getStrAdvCancelRefund() {
		return strAdvCancelRefund;
	}

	public void setStrAdvCancelRefund(String strAdvCancelRefund) {
		this.strAdvCancelRefund = strAdvCancelRefund;
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

	public String getAdvPayDtl() {
		return advPayDtl;
	}

	public void setAdvPayDtl(String advPayDtl) {
		this.advPayDtl = advPayDtl;
	}

	public String getOnlyCatCahnge() {
		return onlyCatCahnge;
	}

	public void setOnlyCatCahnge(String onlyCatCahnge) {
		this.onlyCatCahnge = onlyCatCahnge;
	}

	public String getStrPatientDtlHidVal() {
		return strPatientDtlHidVal;
	}

	public void setStrPatientDtlHidVal(String strPatientDtlHidVal) {
		this.strPatientDtlHidVal = strPatientDtlHidVal;
	}

	public String getStrQRCodeModeContents() {
		return strQRCodeModeContents;
	}

	public void setStrQRCodeModeContents(String strQRCodeModeContents) {
		this.strQRCodeModeContents = strQRCodeModeContents;
	}

	
	
}
