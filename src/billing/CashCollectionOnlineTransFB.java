package billing;

import java.util.LinkedHashMap;

import org.apache.struts.action.ActionForm;

import billing.BillConfigUtil;

public class CashCollectionOnlineTransFB extends ActionForm {

	private static final long serialVersionUID = 02L;
	
	java.util.LinkedHashMap<String, String> lhm = new java.util.LinkedHashMap<String, String>();

	private String strWarningMsg = "";
	private String strNormalMsg = "";
	private String strErrMsg = null;
	
	private String strCounterMode = "0";  // 0 - Online, 1 - Offline, 2 - Both 
	
	private String strIsWithoutCrNoRequired = "0"; // 0 - Not Required, 1 - Required
	
	private String strConfirmationType = "0"; // 0 - Cancel, 1 - Ok
	
	private String strHospitalCode = "0";
	private String strSeatId ="0";
	private String strPatientMode = "1";
	private String strUserLevel = "0";
	private String strAdmissionDtlHidVal = "0";
	private String strQRCodeModeContents = "";
	private String strPrintMessageLimit = "0";
	
	private String strTempBillNo = "0";
	private String strTempReceiptNo = "0";
		
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
	
	private String strOnlineDetailsView = "";
	private String strOnlineClientDetailsView = "";

	private String onLineDataRadio = "";
	
	private String strHospitalService = "";
	private String strBillingService = "";
	private String strRaisingDepartment = "";
	private String strChargeTypeId = "";
	private String strAdmissionNo = "";
	private String strAccountNo = "";
	private String strEpisode = "";
	private String strTreatmentCategory = "";
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
	private String strPartPayAdvanceAmountDetails = "";
	private String strApprovalId = "";
	private String strReceiptNo = "";
	private String strRequestBillTariffDetails = "0";
	private String strExpenseAmount = "0";
	private String strNetClientAmount = "0";
	private String strSancAmount = "0";
	private String strClientBalance = "0";
	private String strNetDiscountAmount = "0";
	private String strNetServiceTaxAmount = "0";
	private String strNetPaybleAmount = "0";
	
	private String strClientPayiedBy = "0";
	
	private String strClientNameContents = "";
	private String strOnlineClientDetails = null;
	
	private String strOnlineGrandTotalAmount = "0";
	private String strOnlineTotalRecAmount = "0";
	private String strOnlineMaxClientBenefitAmount = "0";
	private String strOnlinePatNetPayAmount = "0";
	
	private String strRemarks = ""; 
	
	private String[] strOnlinePaymentMode = null;
	private String[] strOnlinePaymentDtls = null;
	private String[] strOnlineAmount = null;
	
	
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
	private String[] strBillTariffUnit = null;
	private String[] strTariffDiscountAmt = null;
	private String[] strTariffNetAmt = null;
	private String[] strTariffPenaltyAmt = null;
	
	private String[] strTariffRefundDetailsId = null;
	//private String[] strRefundTariffDetails = null;
	private String[] strTariffToBeRefundQty = null;
	private String[] strTariffRefundQty = null;
	private String[] strTariffRefundUnit = null;
	private String[] strTariffRefundCost = null;
	
	 
	
	private String strRefundReceiptNo = "0";
	 
	private String strPartpayment = "0";

	
	private String strChk_value = "0";
	
	private String strApprovedByCombo = "0";
	private String strRemarksCombo2 = "";
	 
	
	
	private String strAdmissionCancellationPenalty = "0";
	private String strRefundAdvancePaneltyAmt = "0";
	
	 
	
	private String strPaymentModeContents = "";
	 
	
	private String strCurrentDate = "";
		  
	
	
	private String strRequestNoValues = "";
	
	private String strConsumableCharge="0";
	private String strGroupIdForConsumableConcatenated="";
	private String strOfflineTotalPayAmountWithoutConsumable="0";
	
	private String strConsumableChargesGroupId="";
	private String strConsumableChargesTariffCode="";
	private String filePath="";
	private String isOpenPopUp="";
	private String printMode="0";
	
	//credit bill details
	private String[] strCreditLetterNo;
	private String[] strCreditLetterDate;
	private String[] strPaidByPat;
	private String[] strPaidByClient;
	//private String[] strCreditBillFlag;
	private String[] strCreditFilePath;
	//private String[] strCreditClientNo;
	//private String[] strCreditBillStatus;
	//private String[] strCreditClientName;
	private String[] strCreditPaymentType;
		
	//credit billing common details..
	//private String strEmployeeId;
	//private String strEmployeeName;
	//private String strRalationId;
	//private String strCardValidity;
    //private String strRelatinDetails;
    
    String strCreditApprovalRequired="0";
    //private String strCreditBillApprovalDone="0";//0-Not Required,1-Done,2-Not Required Direct (Without Approval)
    private String strCreditLetterValidity=BillConfigUtil.CREDIT_LETTER_VALIDITY_CHECK_DAYS;
    
	 private String strClientPatientNo = "";
	 
	 private String strPayClientName;
	 
	 private String strClientName;
	 
	//private String strRelationId;
	 private String strNewCreditLetterAddedFlag="0";
	
	 private String strClientNo;
	 private String strPackageId="";
	 private String strWalletNo="";
	 private String strWalletNoMasked="";
	 private String strAvlWalletMoney="0";
	 private String strMobileNo="";
	 private String strRoomLimit="0";
	 private String strUrgTrfSur="";
	 private String walacc="0";
	 private String strSurCc="";
	 private String strSurDc="";
	 private String strSurIc="";
	 private String strSurId="";
	 private String strSurCc1="";
	 private String strSurDc1="";
	 private String strSurIc1="";
	 private String strSurId1="";
	 private Double defsurlim=0.00;
	 private String currentBserviceId="";
	 private String strPatientDtlHidVal="";
	 
	   	public String getStrClientNo() {
			return strClientNo;
		}

		public void setStrClientNo(String strClientNo) {
			this.strClientNo = strClientNo;
		}
		
	/*public String getStrRelationId() {
		return strRelationId;
	}

	public void setStrRelationId(String strRelationId) {
		this.strRelationId = strRelationId;
	}*/

	public String getStrPayClientName() {
		return strPayClientName;
	}

	public void setStrPayClientName(String strPayClientName) {
		this.strPayClientName = strPayClientName;
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

	public String getStrRequestNoValues() {
		return strRequestNoValues;
	}

	public void setStrRequestNoValues(String strRequestNoValues) {
		this.strRequestNoValues = strRequestNoValues;
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
	 * @return the strOnlineDetailsView
	 */
	public String getStrOnlineDetailsView() {
		return strOnlineDetailsView;
	}

	/**
	 * @param strOnlineDetailsView the strOnlineDetailsView to set
	 */
	public void setStrOnlineDetailsView(String strOnlineDetailsView) {
		this.strOnlineDetailsView = strOnlineDetailsView;
	}

	/**
	 * @return the strOnlineClientDetailsView
	 */
	public String getStrOnlineClientDetailsView() {
		return strOnlineClientDetailsView;
	}

	/**
	 * @param strOnlineClientDetailsView the strOnlineClientDetailsView to set
	 */
	public void setStrOnlineClientDetailsView(String strOnlineClientDetailsView) {
		this.strOnlineClientDetailsView = strOnlineClientDetailsView;
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
	 * @param strCurrentDate the strCurrentDate to set
	 */
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
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
 

	public String getStrPartPaymentAmount() {
		return strPartPaymentAmount;
	}

	public void setStrPartPaymentAmount(String strPartPaymentAmount) {
		this.strPartPaymentAmount = strPartPaymentAmount;
	}

	public String getOnLineDataRadio() {
		return onLineDataRadio;
	}

	public void setOnLineDataRadio(String onLineDataRadio) {
		this.onLineDataRadio = onLineDataRadio;
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

	public String getStrOnlineTotalRecAmount() {
		return strOnlineTotalRecAmount;
	}

	public void setStrOnlineTotalRecAmount(String strOnlineTotalRecAmount) {
		this.strOnlineTotalRecAmount = strOnlineTotalRecAmount;
	}

	public String getStrOnlineMaxClientBenefitAmount() {
		return strOnlineMaxClientBenefitAmount;
	}

	public void setStrOnlineMaxClientBenefitAmount(
			String strOnlineMaxClientBenefitAmount) {
		this.strOnlineMaxClientBenefitAmount = strOnlineMaxClientBenefitAmount;
	}

	public String getStrOnlinePatNetPayAmount() {
		return strOnlinePatNetPayAmount;
	}

	public void setStrOnlinePatNetPayAmount(String strOnlinePatNetPayAmount) {
		this.strOnlinePatNetPayAmount = strOnlinePatNetPayAmount;
	}
/*
	public String[] getStrRefundTariffDetails() {
		return strRefundTariffDetails;
	}

	public void setStrRefundTariffDetails(String[] strRefundTariffDetails) {
		this.strRefundTariffDetails = strRefundTariffDetails;
	}*/

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

	public String getStrOnlineClientDetails() {
		return strOnlineClientDetails;
	}

	public void setStrOnlineClientDetails(String strOnlineClientDetails) {
		this.strOnlineClientDetails = strOnlineClientDetails;
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

	public String getStrOnlineGrandTotalAmount() {
		return strOnlineGrandTotalAmount;
	}

	public void setStrOnlineGrandTotalAmount(String strOnlineGrandTotalAmount) {
		this.strOnlineGrandTotalAmount = strOnlineGrandTotalAmount;
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
 
	public String getStrPaymentModeContents() {
		return strPaymentModeContents;
	}

	public void setStrPaymentModeContents(String strPaymentModeContents) {
		this.strPaymentModeContents = strPaymentModeContents;
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
 
	public String getStrConfirmationType() {
		return strConfirmationType;
	}

	public void setStrConfirmationType(String strConfirmationType) {
		this.strConfirmationType = strConfirmationType;
	}

	public String getStrClientNameContents() {
		return strClientNameContents;
	}

	public void setStrClientNameContents(String strClientNameContents) {
		this.strClientNameContents = strClientNameContents;
	}

	public String getStrPrintMessageLimit() {
		return strPrintMessageLimit;
	}

	public void setStrPrintMessageLimit(String strPrintMessageLimit) {
		this.strPrintMessageLimit = strPrintMessageLimit;
	}

	public String[] getStrBillTariffUnit() {
		return strBillTariffUnit;
	}

	public void setStrBillTariffUnit(String[] strBillTariffUnit) {
		this.strBillTariffUnit = strBillTariffUnit;
	}

	public String getFilePath()
	{
		return filePath;
	}

	public void setFilePath(String filePath)
	{
		this.filePath = filePath;
	}

	public String getIsOpenPopUp()
	{
		return isOpenPopUp;
	}

	public void setIsOpenPopUp(String isOpenPopUp)
	{
		this.isOpenPopUp = isOpenPopUp;
	}

	public String getPrintMode()
	{
		return printMode;
	}

	public void setPrintMode(String printMode)
	{
		this.printMode = printMode;
	}

	public String[] getStrCreditLetterNo() {
		return strCreditLetterNo;
	}

	public void setStrCreditLetterNo(String[] strCreditLetterNo) {
		this.strCreditLetterNo = strCreditLetterNo;
	}

	public String[] getStrCreditLetterDate() {
		return strCreditLetterDate;
	}

	public void setStrCreditLetterDate(String[] strCreditLetterDate) {
		this.strCreditLetterDate = strCreditLetterDate;
	}

	public String[] getStrPaidByPat() {
		return strPaidByPat;
	}

	public void setStrPaidByPat(String[] strPaidByPat) {
		this.strPaidByPat = strPaidByPat;
	}

	public String[] getStrPaidByClient() {
		return strPaidByClient;
	}

	public void setStrPaidByClient(String[] strPaidByClient) {
		this.strPaidByClient = strPaidByClient;
	}

	/*public String[] getStrCreditBillFlag() {
		return strCreditBillFlag;
	}

	public void setStrCreditBillFlag(String[] strCreditBillFlag) {
		this.strCreditBillFlag = strCreditBillFlag;
	}*/

	public String[] getStrCreditFilePath() {
		return strCreditFilePath;
	}

	public void setStrCreditFilePath(String[] strCreditFilePath) {
		this.strCreditFilePath = strCreditFilePath;
	}

	/*public String[] getStrCreditClientNo() {
		return strCreditClientNo;
	}

	public void setStrCreditClientNo(String[] strCreditClientNo) {
		this.strCreditClientNo = strCreditClientNo;
	}

	public String[] getStrCreditBillStatus() {
		return strCreditBillStatus;
	}

	public void setStrCreditBillStatus(String[] strCreditBillStatus) {
		this.strCreditBillStatus = strCreditBillStatus;
	}

	public String[] getStrCreditClientName() {
		return strCreditClientName;
	}

	public void setStrCreditClientName(String[] strCreditClientName) {
		this.strCreditClientName = strCreditClientName;
	}*/

	public String getStrClientPatientNo() {
		return strClientPatientNo;
	}

	public void setStrClientPatientNo(String strClientPatientNo) {
		this.strClientPatientNo = strClientPatientNo;
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
	}

	public String getStrRalationId() {
		return strRalationId;
	}

	public void setStrRalationId(String strRalationId) {
		this.strRalationId = strRalationId;
	}

	public String getStrCardValidity() {
		return strCardValidity;
	}

	public void setStrCardValidity(String strCardValidity) {
		this.strCardValidity = strCardValidity;
	}
	 */
	public String getStrCreditApprovalRequired() {
		return strCreditApprovalRequired;
	}

	public void setStrCreditApprovalRequired(String strCreditApprovalRequired) {
		this.strCreditApprovalRequired = strCreditApprovalRequired;
	}
/*
	public String getStrRelatinDetails() {
		return strRelatinDetails;
	}

	public void setStrRelatinDetails(String strRelatinDetails) {
		this.strRelatinDetails = strRelatinDetails;
	}

	public String getStrCreditBillApprovalDone() {
		return strCreditBillApprovalDone;
	}

	public void setStrCreditBillApprovalDone(String strCreditBillApprovalDone) {
		this.strCreditBillApprovalDone = strCreditBillApprovalDone;
	}*/
	public String getStrCreditLetterValidity() 
	{
		return BillConfigUtil.CREDIT_LETTER_VALIDITY_CHECK_DAYS;
	}
	public void setStrCreditLetterValidity(String strCreditLetterValidity) 
	{
		this.strCreditLetterValidity = BillConfigUtil.CREDIT_LETTER_VALIDITY_CHECK_DAYS;
	}
	public void setLhm(java.util.LinkedHashMap<String, String> lhm) 
	{
		this.lhm = lhm;
	}
	public String getStrNewCreditLetterAddedFlag() {
		return strNewCreditLetterAddedFlag;
	}

	public void setStrNewCreditLetterAddedFlag(String strNewCreditLetterAddedFlag) {
		this.strNewCreditLetterAddedFlag = strNewCreditLetterAddedFlag;
	}

	public String[] getStrCreditPaymentType() {
		return strCreditPaymentType;
	}

	public void setStrCreditPaymentType(String[] strCreditPaymentType) {
		this.strCreditPaymentType = strCreditPaymentType;
	}	
	public String getStrPackageId() {
		return strPackageId;
	}
	public void setStrPackageId(String strPackageId) {
		this.strPackageId = strPackageId;
	}
	public String getStrClientName() {
		return strClientName;
	}

	public void setStrClientName(String strClientName) {
		this.strClientName = strClientName;
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

	public String getStrWalletNoMasked() {
		return strWalletNoMasked;
	}

	public void setStrWalletNoMasked(String strWalletNoMasked) {
		this.strWalletNoMasked = strWalletNoMasked;
	}
	public String getStrSancAmount() {
		return strSancAmount;
	}

	public void setStrSancAmount(String strSancAmount) {
		this.strSancAmount = strSancAmount;
	}

	public String getStrClientBalance() {
		return strClientBalance;
	}

	public void setStrClientBalance(String strClientBalance) {
		this.strClientBalance = strClientBalance;
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

	public String getStrUrgTrfSur() {
		return strUrgTrfSur;
	}

	public void setStrUrgTrfSur(String strUrgTrfSur) {
		this.strUrgTrfSur = strUrgTrfSur;
	}

	public String getWalacc() {
		return walacc;
	}

	public void setWalacc(String walacc) {
		this.walacc = walacc;
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

	public String getCurrentBserviceId() {
		return currentBserviceId;
	}

	public void setCurrentBserviceId(String currentBserviceId) {
		this.currentBserviceId = currentBserviceId;
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
