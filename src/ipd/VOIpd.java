package ipd;

import hisglobal.transactionmgnt.HisDAO;

import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;

public class VOIpd implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	private static final String pathFileName = "hisglobal.hisconfig.hisPath";
	public static final String SUPER_HOSPITAL_CODE = "100";
	public static final String MODULE_ID = "14";
	
	private String path = null;

	public VOIpd(String hospitalCode)  
	{
		WebRowSet wb=null;
		String tmp_ParamName="";
		String tmp_ParamValue="";
		
		String qry = ipd.qryHandler_ipd.getQuery(1, "select.ipdconfig.51");
		HisDAO hisDao = new HisDAO("ADT","InPatientConfigMstBO.selectQuery()");
		
		try 
		{
			int qryIndex = hisDao.setQuery(qry);
			hisDao.setQryValue(qryIndex, 1, hospitalCode);
			wb=hisDao.executeQry(qryIndex);
			
			
			while(wb.next())
			{
				tmp_ParamName=wb.getString(1);
				tmp_ParamValue=wb.getString(2);
				if(tmp_ParamName.equals("BELONGING_REQUIRED"))
					this.setStrBelongingRequired(tmp_ParamValue);
				else if(tmp_ParamName.equals("BLOCKED_BED_EXPIRY_TIME"))
					this.setStrBlockedExpiryTime(tmp_ParamValue);
				else if(tmp_ParamName.equals("DAYS_PURGE_ADM_DTL"))
					this.setStrPurgingRecordCurrentlyAdmissionDetails(tmp_ParamValue);
				else if(tmp_ParamName.equals("DIAGNOSIS_TYPE"))
					this.setStrDiagnosisType(tmp_ParamValue);
				else if(tmp_ParamName.equals("GOV_EMP_BASIC_PAY_LIMIT"))
					this.setGovtEmployeeBasicPayLimit(tmp_ParamValue);
				else if(tmp_ParamName.equals("ICU_WARD_TYPE"))
					this.setStrIcuWardType(tmp_ParamValue);
				else if(tmp_ParamName.equals("ISSUE_ITEM_REQUIRED"))
					this.setStrIssueItemRequired(tmp_ParamValue);
				else if(tmp_ParamName.equals("MAX_BABIES_MOTHER_CAN_GIVE_BORN"))
					this.setStrMaxNoOfBabyMotherCanBorn(tmp_ParamValue);
				else if(tmp_ParamName.equals("MIN_AGE_TO_BE_A_MOTHER"))
					this.setStrMinAgeToBeMother(tmp_ParamValue);
				else if(tmp_ParamName.equals("MS_APPROVAL_FORM_NO"))
					this.setStrMsApprovalOffline(tmp_ParamValue);
				else if(tmp_ParamName.equals("NEW_BORN_BABY_PROCESS"))
					this.setStrNewBornBabyProcessType(tmp_ParamValue);
				else if(tmp_ParamName.equals("NURSE_CHECK_LIST_MANDATORY"))
					this.setStrNurseChecklistMandatory(tmp_ParamValue);
				else if(tmp_ParamName.equals("PATIENT_CATEGORY_STAFF"))
					this.setStaffCategory(tmp_ParamValue);
				else if(tmp_ParamName.equals("PRIV_EMPL_MONTHLY_INCOME_LIMIT"))
					this.setPrivateEmployeeMonthlyIncomeLimit(tmp_ParamValue);
				else if(tmp_ParamName.equals("PURGE_TIME_NOT_REPORTED_PAT"))
					this.setStrPurgeTimeNotReportedPatient(tmp_ParamValue);
				else if(tmp_ParamName.equals("PRIVATE_WARD_TYPE"))
					this.setStrPrivateWardType(tmp_ParamValue);
				else if(tmp_ParamName.equals("ADMISSION_PROCESS"))
					this.setStrAdmissionOnline(tmp_ParamValue);
				else if(tmp_ParamName.equals("ADMISSION_ADVICE_VALIDITY_POST"))
					this.setStrAdmissionAdviceValidityFrom(tmp_ParamValue);
				else if(tmp_ParamName.equals("ADMISSION_ADVICE_VALIDITY_PRE"))
					this.setStrAdmissionAdviceValidityTo(tmp_ParamValue);
				else if(tmp_ParamName.equals("ADMISSION_ADVICE_MODE"))
					this.setStrAdmissionAdviceMode(tmp_ParamValue);
				else if(tmp_ParamName.equals("ADMISSION_MODIFICATION_VALIDITY"))
					this.setStrModificationTimeValidity(tmp_ParamValue);
				else if(tmp_ParamName.equals("WHETHER_UNIT_NAME_REQ"))
					this.setStrUnitNameReq(tmp_ParamValue);
				else if(tmp_ParamName.equals("WHETHER_ROOM_NO_REQ"))
					this.setStrRoomNoReq(tmp_ParamValue);
				//else if(tmp_ParamName.equals("ADM_CHARGE_TAKEN_AT_COUNTER"))//Old Admission Detail Tab-Not In Use
					//this.setStrAdmissionChargeTakenAtCounter(tmp_ParamValue);
				else if(tmp_ParamName.equals("NEW_BORN_BABY_REG_CHARGE"))
					this.setStrNewBornBabyRegistrationCharge(tmp_ParamValue);
				else if(tmp_ParamName.equals("NEW_BORN_BABY_ADM_CHARGE"))
					this.setStrNewBornBabyAdmissionCharge(tmp_ParamValue);
				else if(tmp_ParamName.equals("ADV_AMOUNT_TAKEN_DURING_NEW_BABY"))
					this.setStrAdvanceAmountNewBornBaby(tmp_ParamValue);
				else if(tmp_ParamName.equals("ADM_REPRINT_CHARGE"))
					this.setStrAdmissionReprintCharge(tmp_ParamValue);
				else if(tmp_ParamName.equals("BED_ALLOTMENT_AT_TIME_OF_ADM"))
					this.setStrBedAllotmentAtAdmission(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCHARGE_CANCELLATION_TIME"))
					this.setStrDischargeCancellationTime(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCHARGE_PROCESS"))
					this.setStrDischargeProcessType(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCHARGE_REPRINT_CHARGE"))
					this.setStrDischargeReprintCharge(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCHARGE_TYPE_ABSCONDED"))
					this.setStrDischargeTypeAbsconded(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCHARGE_TYPE_DEATH"))
					this.setStrDischargeTypeDeath(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCHARGE_TYPE_LAMA"))
					this.setStrDischargeTypeLAMA(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCHARGE_TYPE_REFERRAL"))
					this.setStrDischargeTypeReferral(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCHARGE_TYPE_TRANSFER"))
					this.setStrDischargeTypeTransfer(tmp_ParamValue);
				
				else if(tmp_ParamName.equals("DISCHARGE_TYPE_NORMAL"))
					this.setStrNormalDischargeType(tmp_ParamValue);
				
				else if(tmp_ParamName.equals("PERMISSIBLE_DISCHARGE_TIME_NOT_REPORTED_PAT"))
					this.setStrPurgeTimeNotReportedPatient(tmp_ParamValue);
				else if(tmp_ParamName.equals("ATTENDANT_PASS_GEN_AT_ADM_TIME"))
					this.setStrAttendentPassGenerateAtAdmissionTime(tmp_ParamValue);
				else if(tmp_ParamName.equals("ATTENDANT_PASS_REQUIRED"))
					this.setStrAttendentPass(tmp_ParamValue);
				else if(tmp_ParamName.equals("NEW_PASS_PAID_PASS_CHARGE"))
					this.setStrPaidPassCharge(tmp_ParamValue);
				else if(tmp_ParamName.equals("NEW_PASS_VALIDITY_FOR_FREE_PASS"))
					this.setStrNewFreePassValidity(tmp_ParamValue);
				else if(tmp_ParamName.equals("NEW_PASS_VALIDITY_FOR_PAID_PASS"))
					this.setStrNewPaidPassValidity(tmp_ParamValue);
				else if(tmp_ParamName.equals("NO_OF_PAID_PASS"))
					this.setStrNoOfPaidPass(tmp_ParamValue);
				else if(tmp_ParamName.equals("NO_OF_SLIP_PRINTED_AT_ADMISSION"))
					this.setStrNoOfSlipPrintedAtAdmission(tmp_ParamValue);
				else if(tmp_ParamName.equals("PASS_REPRINT_CHARGE"))
					this.setStrPassReprintCharge(tmp_ParamValue);
				else if(tmp_ParamName.equals("PRINT_REQUEST"))
					this.setStrPrintRequest(tmp_ParamValue);
				else if(tmp_ParamName.equals("RENEW_PASS_PAID_PASS_RENEW_CHARGE"))
					this.setStrPaidPassRenewCharge(tmp_ParamValue);
				else if(tmp_ParamName.equals("RENEW_PASS_VALIDITY_FOR_FREE_PASS"))
					this.setStrRenewFreePassValidity(tmp_ParamValue);
				else if(tmp_ParamName.equals("RENEW_PASS_VALIDITY_FOR_PAID_PASS"))
					this.setStrRenewPaidPassValidity(tmp_ParamValue);
				else if(tmp_ParamName.equals("TIMINGS_SUMMER_MORNING")){
					strSummerMorningFromTime="00:00";
					this.setStrSummerMorningToTime(tmp_ParamValue.split("-")[1]);
				}
				else if(tmp_ParamName.equals("TIMINGS_SUMMER_EVENING")){
					this.setStrSummerEveningFromTime(tmp_ParamValue.split("-")[0]);
					this.setStrSummerEveningToTime(tmp_ParamValue.split("-")[1]);
					
				}
				else if(tmp_ParamName.equals("TIMINGS_WINTER_MORNING")){
					this.setStrWinterMorningFromTime(tmp_ParamValue.split("-")[0]);
					this.setStrWinterMorningToTime(tmp_ParamValue.split("-")[1]);
				}
				else if(tmp_ParamName.equals("TIMINGS_WINTER_EVENING")){
					this.setStrWinterEveningFromTime(tmp_ParamValue.split("-")[0]);
					this.setStrWinterEveningToTime(tmp_ParamValue.split("-")[1]);
				}
				else if(tmp_ParamName.equals("TOTAL_NO_OF_FREE_PASS"))
					this.setStrNoOfFreePass(tmp_ParamValue);
				else if(tmp_ParamName.equals("TOTAL_NO_OF_FREE_PASS_AT_ADMISSION"))
					this.setStrNoOfFreePassAdmisssionTime(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCHARGE_SUMMARY_REPORT_ADVICE"))
					this.setStrDischargeSummaryReportAdvice(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCHARGE_SUMMARY_REPORT_FOOTER"))
					this.setStrDischargeSummaryReportFooter(tmp_ParamValue);	
				else if(tmp_ParamName.equals("ADVANCE_REQUEST_AT_ADM_ADVICE"))
					this.setStrAdvanceRequestAdmissionAdvice(tmp_ParamValue);
				else if(tmp_ParamName.equals("ADV_REFUND_REQ_ADM_CANCEL"))
					this.setStrRefundRequestAdmissionCancellation(tmp_ParamValue);	
				else if(tmp_ParamName.equals("Integration_With_Billing"))
					this.setStrIntegrationBilling(tmp_ParamValue);	
				else if(tmp_ParamName.equals("ADM_CHARGE_AT_ADM_COUNTER"))//Billing Tab
					this.setStrAdmissionCharge(tmp_ParamValue);
				else if(tmp_ParamName.equals("ADV_DEPOSIT_AT_ADM_COUNTER"))
					this.setStrAdvanceDepsoitAtAdmissionCounter(tmp_ParamValue);
				else if(tmp_ParamName.equals("WHETHER_CHECK_ADV_AMOUNT_AT_ADM"))
					this.setStrAdvanceAmountAdmission(tmp_ParamValue);	
				else if(tmp_ParamName.equals("NO_OF_LINES_IN_ADM_SLIP"))
					this.setStrNoOfLineInAdmissionSlip(tmp_ParamValue);
				else if(tmp_ParamName.equals("NO_OF_LINES_IN_NEW_BABY_ADM_SLIP"))
					this.setStrNoOfLineInNewBornBabyAdmissionSlip(tmp_ParamValue);	
				else if(tmp_ParamName.equals("NO_OF_LINES_IN_VISITOR_PASS_SLIP"))
					this.setStrNoOfLineInVisitorPassSlip(tmp_ParamValue);	
				else if(tmp_ParamName.equals("BED_LIMIT"))
					this.setBedLimit(tmp_ParamValue);	
				else if(tmp_ParamName.equals("LEAVE_REQ_TYPE"))
					this.setStrLeaveReqType(tmp_ParamValue);
				else if(tmp_ParamName.equals("CONSENT_TEMPLATE_ID"))
					this.setStrConsentTemplateId(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCHARGE SLIP REQUIRED"))
					this.setStrDischargeSlipReq(tmp_ParamValue);
				else if(tmp_ParamName.equals("NEWBORN BABY DEFAULT DEPT"))
					this.setStrNewBornBabyDefaultDept(tmp_ParamValue);
				else if(tmp_ParamName.equals("UMID_FLAG"))
					this.setUmidFlag(tmp_ParamValue);
			}			
		}
		catch (Exception e) 
		{
			e.printStackTrace();				
		}
		finally
		{
			try 
			{
				if (wb != null) 
				{
					wb.close();
					wb=null;
				}
				if (hisDao != null) 
				{
					hisDao.free();
					hisDao = null;
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}				
	}
	private String strGenWardAdmission = "0";
	private String strPrivateWardAdmission = "0";
	private String strBookBed = "0";
	private String strBilling = "0";
	private String strNegativeBilling = "0";
	private String staffCategory = "0";
	private String govtEmployeeBasicPayLimit = "0";
	private String privateEmployeeMonthlyIncomeLimit = "0";
	private String strPurgingRecordCurrentlyAdmissionDetails="";
	private String strPurgeTimeNotReportedPatient="";
	private String strNoOfLineInAdmissionSlip="0";
	private String strNoOfLineInVisitorPassSlip="0";
	private String strNoOfFreePassAdmisssionTime="0";
	private String strNoOfFreePass ="0";
	private String strNoOfPaidPass ="0";
	private String strNewFreePassValidity="0";
	private String strNewPaidPassValidity="0";
	private String strRenewFreePassValidity="0";
	private String strRenewPaidPassValidity="0";
	private String strAdmissionOnline="0";
	private String strSummerMorningFromTime="00:00";
	private String strSummerMorningToTime="00:00";
	private String strSummerEveningFromTime="00:00";
	private String strSummerEveningToTime="00:00";
	private String strWinterMorningFromTime="00:00";
	private String strWinterMorningToTime="00:00";
	private String strWinterEveningFromTime="00:00";
	private String strWinterEveningToTime="00:00";
	private String strPrintRequest="0";
	//private String strAdmissionChargeTakenAtCounter="0";//Old Admission Tab-Not In Use
	private String strAdmissionAdviceValidityTo="0";
	private String strAdmissionAdviceValidityFrom="0";
	private String strNewBornBabyAdmissionCharge="0";
	private String strNewBornBabyRegistrationCharge="0";
	private String strModificationTimeValidity="0";
	private String strDischargeCancellationTime="0";
	private String strAdvanceAmountNewBornBaby="0";
	private String strBlockedExpiryTime="00";
	private String strAdmissionReprintCharge = "0.00";
	private String strPaidPassCharge = "0.00";
	private String strPaidPassRenewCharge = "0.00";
	private String strPassReprintCharge = "0.00";
	private String strDischargeReprintCharge = "0.00";	
	private String strPrivateWardType = "";	
	private String strIcuWardType = "";	
	private String strDischargeSummaryReportAdvice = "";
	private String strDischargeSummaryReportFooter = "";	
	private String strIntegrationBilling="";
	private String strAdmissionCharge="";//Billing-Admission CHarge Taken At Counter
	private String strAdvanceDepsoitAtAdmissionCounter="";//Check Whether Advance Needs to Be Deposit At Admission Counter
	private String strAdvanceRequestAdmissionAdvice="";
	private String strAdvanceAmountAdmission="";//Check Whether Advance Deposited or Not
	private String strPatientAdjustedFinalDischargeBill="";
	private String strBedChange="";
	private String strRefundRequestAdmissionCancellation="";
	private String strNoOfLineInNewBornBabyAdmissionSlip="";
	private String strMsApprovalOffline="0";
	private String strAttendentPass="0";
	private String strAttendentPassGenerateAtAdmissionTime="0";
	private String strDischargeProcessType="";
	private String strNewBornBabyProcessType="";
	private String strMinAgeToBeMother="";
	private String strMaxNoOfBabyMotherCanBorn="";
	private String strDiagnosisType="";
	private String strAdmissionAdviceMode="1";
	private String strBelongingRequired="0";
	private String strIssueItemRequired="0";
	private String strNurseChecklistMandatory="0";
	private String strUnitNameReq="0";
	private String strRoomNoReq="0";
	private String strNotReportedTimeLimit="10";
	private String strBedAllotmentAtAdmission="0";
	private String strDischargeTypeLAMA="0";
	private String strDischargeTypeAbsconded="0";
	private String strDischargeTypeReferral="0";
	private String strDischargeTypeTransfer="0";
	private String strDischargeTypeDeath="0";
	private String strNoOfSlipPrintedAtAdmission="";
	private String bedLimit="1";
	private String strLeaveReqType="2";
	private String strConsentTemplateId="1610012";
	private String strNormalDischargeType="0";
    private String strDischargeSlipReq="";
    private String strNewBornBabyDefaultDept="";
    private String umidFlag="";


	public String getStrDischargeSlipReq() {
		return strDischargeSlipReq;
	}
	public void setStrDischargeSlipReq(String strDischargeSlipReq) {
		this.strDischargeSlipReq = strDischargeSlipReq;
	}
	public String getStrNormalDischargeType() {
		return strNormalDischargeType;
	}
	public void setStrNormalDischargeType(String strNormalDischargeType) {
		this.strNormalDischargeType = strNormalDischargeType;
	}
	public String getStrGenWardAdmission() {
		return strGenWardAdmission;
	}
	public void setStrGenWardAdmission(String strGenWardAdmission) {
		this.strGenWardAdmission = strGenWardAdmission;
	}
	public String getStrPrivateWardAdmission() {
		return strPrivateWardAdmission;
	}
	public void setStrPrivateWardAdmission(String strPrivateWardAdmission) {
		this.strPrivateWardAdmission = strPrivateWardAdmission;
	}
	public String getStrBookBed() {
		return strBookBed;
	}
	public void setStrBookBed(String strBookBed) {
		this.strBookBed = strBookBed;
	}
	public String getStrBilling() {
		return strBilling;
	}
	public void setStrBilling(String strBilling) {
		this.strBilling = strBilling;
	}
	public String getStrNegativeBilling() {
		return strNegativeBilling;
	}
	public void setStrNegativeBilling(String strNegativeBilling) {
		this.strNegativeBilling = strNegativeBilling;
	}
	public String getStaffCategory() {
		return staffCategory;
	}
	public void setStaffCategory(String staffCategory) {
		this.staffCategory = staffCategory;
	}
	public String getGovtEmployeeBasicPayLimit() {
		return govtEmployeeBasicPayLimit;
	}
	public void setGovtEmployeeBasicPayLimit(String govtEmployeeBasicPayLimit) {
		this.govtEmployeeBasicPayLimit = govtEmployeeBasicPayLimit;
	}
	public String getPrivateEmployeeMonthlyIncomeLimit() {
		return privateEmployeeMonthlyIncomeLimit;
	}
	public void setPrivateEmployeeMonthlyIncomeLimit(
			String privateEmployeeMonthlyIncomeLimit) {
		this.privateEmployeeMonthlyIncomeLimit = privateEmployeeMonthlyIncomeLimit;
	}
	public String getStrPurgingRecordCurrentlyAdmissionDetails() {
		return strPurgingRecordCurrentlyAdmissionDetails;
	}
	public void setStrPurgingRecordCurrentlyAdmissionDetails(
			String strPurgingRecordCurrentlyAdmissionDetails) {
		this.strPurgingRecordCurrentlyAdmissionDetails = strPurgingRecordCurrentlyAdmissionDetails;
	}
	public String getStrPurgeTimeNotReportedPatient() {
		return strPurgeTimeNotReportedPatient;
	}
	public void setStrPurgeTimeNotReportedPatient(
			String strPurgeTimeNotReportedPatient) {
		this.strPurgeTimeNotReportedPatient = strPurgeTimeNotReportedPatient;
	}
	public String getStrNoOfLineInAdmissionSlip() {
		return strNoOfLineInAdmissionSlip;
	}
	public void setStrNoOfLineInAdmissionSlip(String strNoOfLineInAdmissionSlip) {
		this.strNoOfLineInAdmissionSlip = strNoOfLineInAdmissionSlip;
	}
	public String getStrNoOfLineInVisitorPassSlip() {
		return strNoOfLineInVisitorPassSlip;
	}
	public void setStrNoOfLineInVisitorPassSlip(String strNoOfLineInVisitorPassSlip) {
		this.strNoOfLineInVisitorPassSlip = strNoOfLineInVisitorPassSlip;
	}
	public String getStrNoOfFreePassAdmisssionTime() {
		return strNoOfFreePassAdmisssionTime;
	}
	public void setStrNoOfFreePassAdmisssionTime(
			String strNoOfFreePassAdmisssionTime) {
		this.strNoOfFreePassAdmisssionTime = strNoOfFreePassAdmisssionTime;
	}
	public String getStrNoOfFreePass() {
		return strNoOfFreePass;
	}
	public void setStrNoOfFreePass(String strNoOfFreePass) {
		this.strNoOfFreePass = strNoOfFreePass;
	}
	public String getStrNoOfPaidPass() {
		return strNoOfPaidPass;
	}
	public void setStrNoOfPaidPass(String strNoOfPaidPass) {
		this.strNoOfPaidPass = strNoOfPaidPass;
	}
	public String getStrNewFreePassValidity() {
		return strNewFreePassValidity;
	}
	public void setStrNewFreePassValidity(String strNewFreePassValidity) {
		this.strNewFreePassValidity = strNewFreePassValidity;
	}
	public String getStrNewPaidPassValidity() {
		return strNewPaidPassValidity;
	}
	public void setStrNewPaidPassValidity(String strNewPaidPassValidity) {
		this.strNewPaidPassValidity = strNewPaidPassValidity;
	}
	public String getStrRenewFreePassValidity() {
		return strRenewFreePassValidity;
	}
	public void setStrRenewFreePassValidity(String strRenewFreePassValidity) {
		this.strRenewFreePassValidity = strRenewFreePassValidity;
	}
	public String getStrRenewPaidPassValidity() {
		return strRenewPaidPassValidity;
	}
	public void setStrRenewPaidPassValidity(String strRenewPaidPassValidity) {
		this.strRenewPaidPassValidity = strRenewPaidPassValidity;
	}
	public String getStrAdmissionOnline() {
		return strAdmissionOnline;
	}
	public void setStrAdmissionOnline(String strAdmissionOnline) {
		this.strAdmissionOnline = strAdmissionOnline;
	}
	public String getStrSummerMorningFromTime() {
		return strSummerMorningFromTime;
	}
	public void setStrSummerMorningFromTime(String strSummerMorningFromTime) {
		this.strSummerMorningFromTime = strSummerMorningFromTime;
	}
	public String getStrSummerMorningToTime() {
		return strSummerMorningToTime;
	}
	public void setStrSummerMorningToTime(String strSummerMorningToTime) {
		this.strSummerMorningToTime = strSummerMorningToTime;
	}
	public String getStrSummerEveningFromTime() {
		return strSummerEveningFromTime;
	}
	public void setStrSummerEveningFromTime(String strSummerEveningFromTime) {
		this.strSummerEveningFromTime = strSummerEveningFromTime;
	}
	public String getStrSummerEveningToTime() {
		return strSummerEveningToTime;
	}
	public void setStrSummerEveningToTime(String strSummerEveningToTime) {
		this.strSummerEveningToTime = strSummerEveningToTime;
	}
	public String getStrWinterMorningFromTime() {
		return strWinterMorningFromTime;
	}
	public void setStrWinterMorningFromTime(String strWinterMorningFromTime) {
		this.strWinterMorningFromTime = strWinterMorningFromTime;
	}
	public String getStrWinterMorningToTime() {
		return strWinterMorningToTime;
	}
	public void setStrWinterMorningToTime(String strWinterMorningToTime) {
		this.strWinterMorningToTime = strWinterMorningToTime;
	}
	public String getStrWinterEveningFromTime() {
		return strWinterEveningFromTime;
	}
	public void setStrWinterEveningFromTime(String strWinterEveningFromTime) {
		this.strWinterEveningFromTime = strWinterEveningFromTime;
	}
	public String getStrWinterEveningToTime() {
		return strWinterEveningToTime;
	}
	public void setStrWinterEveningToTime(String strWinterEveningToTime) {
		this.strWinterEveningToTime = strWinterEveningToTime;
	}
	public String getStrPrintRequest() {
		return strPrintRequest;
	}
	public void setStrPrintRequest(String strPrintRequest) {
		this.strPrintRequest = strPrintRequest;
	}
	/*public String getStrAdmissionChargeTakenAtCounter() {
		return strAdmissionChargeTakenAtCounter;
	}
	public void setStrAdmissionChargeTakenAtCounter(
			String strAdmissionChargeTakenAtCounter) {
		this.strAdmissionChargeTakenAtCounter = strAdmissionChargeTakenAtCounter;
	}*/
	public String getStrAdmissionAdviceValidityTo() {
		return strAdmissionAdviceValidityTo;
	}
	public void setStrAdmissionAdviceValidityTo(String strAdmissionAdviceValidityTo) {
		this.strAdmissionAdviceValidityTo = strAdmissionAdviceValidityTo;
	}
	public String getStrAdmissionAdviceValidityFrom() {
		return strAdmissionAdviceValidityFrom;
	}
	public void setStrAdmissionAdviceValidityFrom(
			String strAdmissionAdviceValidityFrom) {
		this.strAdmissionAdviceValidityFrom = strAdmissionAdviceValidityFrom;
	}
	public String getStrNewBornBabyAdmissionCharge() {
		return strNewBornBabyAdmissionCharge;
	}
	public void setStrNewBornBabyAdmissionCharge(
			String strNewBornBabyAdmissionCharge) {
		this.strNewBornBabyAdmissionCharge = strNewBornBabyAdmissionCharge;
	}
	public String getStrNewBornBabyRegistrationCharge() {
		return strNewBornBabyRegistrationCharge;
	}
	public void setStrNewBornBabyRegistrationCharge(
			String strNewBornBabyRegistrationCharge) {
		this.strNewBornBabyRegistrationCharge = strNewBornBabyRegistrationCharge;
	}
	public String getStrModificationTimeValidity() {
		return strModificationTimeValidity;
	}
	public void setStrModificationTimeValidity(String strModificationTimeValidity) {
		this.strModificationTimeValidity = strModificationTimeValidity;
	}
	public String getStrDischargeCancellationTime() {
		return strDischargeCancellationTime;
	}
	public void setStrDischargeCancellationTime(String strDischargeCancellationTime) {
		this.strDischargeCancellationTime = strDischargeCancellationTime;
	}
	public String getStrAdvanceAmountNewBornBaby() {
		return strAdvanceAmountNewBornBaby;
	}
	public void setStrAdvanceAmountNewBornBaby(String strAdvanceAmountNewBornBaby) {
		this.strAdvanceAmountNewBornBaby = strAdvanceAmountNewBornBaby;
	}
	public String getStrBlockedExpiryTime() {
		return strBlockedExpiryTime;
	}
	public void setStrBlockedExpiryTime(String strBlockedExpiryTime) {
		this.strBlockedExpiryTime = strBlockedExpiryTime;
	}
	public String getStrAdmissionReprintCharge() {
		return strAdmissionReprintCharge;
	}
	public void setStrAdmissionReprintCharge(String strAdmissionReprintCharge) {
		this.strAdmissionReprintCharge = strAdmissionReprintCharge;
	}
	public String getStrPaidPassCharge() {
		return strPaidPassCharge;
	}
	public void setStrPaidPassCharge(String strPaidPassCharge) {
		this.strPaidPassCharge = strPaidPassCharge;
	}
	public String getStrPaidPassRenewCharge() {
		return strPaidPassRenewCharge;
	}
	public void setStrPaidPassRenewCharge(String strPaidPassRenewCharge) {
		this.strPaidPassRenewCharge = strPaidPassRenewCharge;
	}
	public String getStrPassReprintCharge() {
		return strPassReprintCharge;
	}
	public void setStrPassReprintCharge(String strPassReprintCharge) {
		this.strPassReprintCharge = strPassReprintCharge;
	}
	public String getStrDischargeReprintCharge() {
		return strDischargeReprintCharge;
	}
	public void setStrDischargeReprintCharge(String strDischargeReprintCharge) {
		this.strDischargeReprintCharge = strDischargeReprintCharge;
	}
	public String getStrPrivateWardType() {
		return strPrivateWardType;
	}
	public void setStrPrivateWardType(String strPrivateWardType) {
		this.strPrivateWardType = strPrivateWardType;
	}
	public String getStrIcuWardType() {
		return strIcuWardType;
	}
	public void setStrIcuWardType(String strIcuWardType) {
		this.strIcuWardType = strIcuWardType;
	}
	public String getStrDischargeSummaryReportAdvice() {
		return strDischargeSummaryReportAdvice;
	}
	public void setStrDischargeSummaryReportAdvice(
			String strDischargeSummaryReportAdvice) {
		this.strDischargeSummaryReportAdvice = strDischargeSummaryReportAdvice;
	}
	public String getStrDischargeSummaryReportFooter() {
		return strDischargeSummaryReportFooter;
	}
	public void setStrDischargeSummaryReportFooter(
			String strDischargeSummaryReportFooter) {
		this.strDischargeSummaryReportFooter = strDischargeSummaryReportFooter;
	}
	public String getStrIntegrationBilling() {
		return strIntegrationBilling;
	}
	public void setStrIntegrationBilling(String strIntegrationBilling) {
		this.strIntegrationBilling = strIntegrationBilling;
	}
	public String getStrAdvanceRequestAdmissionAdvice() {
		return strAdvanceRequestAdmissionAdvice;
	}
	public void setStrAdvanceRequestAdmissionAdvice(
			String strAdvanceRequestAdmissionAdvice) {
		this.strAdvanceRequestAdmissionAdvice = strAdvanceRequestAdmissionAdvice;
	}
	public String getStrAdvanceAmountAdmission() {
		return strAdvanceAmountAdmission;
	}
	public void setStrAdvanceAmountAdmission(String strAdvanceAmountAdmission) {
		this.strAdvanceAmountAdmission = strAdvanceAmountAdmission;
	}
	public String getStrPatientAdjustedFinalDischargeBill() {
		return strPatientAdjustedFinalDischargeBill;
	}
	public void setStrPatientAdjustedFinalDischargeBill(
			String strPatientAdjustedFinalDischargeBill) {
		this.strPatientAdjustedFinalDischargeBill = strPatientAdjustedFinalDischargeBill;
	}
	public String getStrBedChange() {
		return strBedChange;
	}
	public void setStrBedChange(String strBedChange) {
		this.strBedChange = strBedChange;
	}
	public String getStrRefundRequestAdmissionCancellation() {
		return strRefundRequestAdmissionCancellation;
	}
	public void setStrRefundRequestAdmissionCancellation(
			String strRefundRequestAdmissionCancellation) {
		this.strRefundRequestAdmissionCancellation = strRefundRequestAdmissionCancellation;
	}
	public String getStrNoOfLineInNewBornBabyAdmissionSlip() {
		return strNoOfLineInNewBornBabyAdmissionSlip;
	}
	public void setStrNoOfLineInNewBornBabyAdmissionSlip(
			String strNoOfLineInNewBornBabyAdmissionSlip) {
		this.strNoOfLineInNewBornBabyAdmissionSlip = strNoOfLineInNewBornBabyAdmissionSlip;
	}
	public String getStrMsApprovalOffline() {
		return strMsApprovalOffline;
	}
	public void setStrMsApprovalOffline(String strMsApprovalOffline) {
		this.strMsApprovalOffline = strMsApprovalOffline;
	}
	public String getStrAttendentPass() {
		return strAttendentPass;
	}
	public void setStrAttendentPass(String strAttendentPass) {
		this.strAttendentPass = strAttendentPass;
	}
	public String getStrAttendentPassGenerateAtAdmissionTime() {
		return strAttendentPassGenerateAtAdmissionTime;
	}
	public void setStrAttendentPassGenerateAtAdmissionTime(
			String strAttendentPassGenerateAtAdmissionTime) {
		this.strAttendentPassGenerateAtAdmissionTime = strAttendentPassGenerateAtAdmissionTime;
	}
	public String getStrDischargeProcessType() {
		return strDischargeProcessType;
	}
	public void setStrDischargeProcessType(String strDischargeProcessType) {
		this.strDischargeProcessType = strDischargeProcessType;
	}
	public String getStrNewBornBabyProcessType() {
		return strNewBornBabyProcessType;
	}
	public void setStrNewBornBabyProcessType(String strNewBornBabyProcessType) {
		this.strNewBornBabyProcessType = strNewBornBabyProcessType;
	}
	public String getStrMinAgeToBeMother() {
		return strMinAgeToBeMother;
	}
	public void setStrMinAgeToBeMother(String strMinAgeToBeMother) {
		this.strMinAgeToBeMother = strMinAgeToBeMother;
	}
	public String getStrMaxNoOfBabyMotherCanBorn() {
		return strMaxNoOfBabyMotherCanBorn;
	}
	public void setStrMaxNoOfBabyMotherCanBorn(String strMaxNoOfBabyMotherCanBorn) {
		this.strMaxNoOfBabyMotherCanBorn = strMaxNoOfBabyMotherCanBorn;
	}
	public String getStrDiagnosisType() {
		return strDiagnosisType;
	}
	public void setStrDiagnosisType(String strDiagnosisType) {
		this.strDiagnosisType = strDiagnosisType;
	}
	public String getStrAdmissionAdviceMode() {
		return strAdmissionAdviceMode;
	}
	public void setStrAdmissionAdviceMode(String strAdmissionAdviceMode) {
		this.strAdmissionAdviceMode = strAdmissionAdviceMode;
	}
	public String getStrBelongingRequired() {
		return strBelongingRequired;
	}
	public void setStrBelongingRequired(String strBelongingRequired) {
		this.strBelongingRequired = strBelongingRequired;
	}
	public String getStrIssueItemRequired() {
		return strIssueItemRequired;
	}
	public void setStrIssueItemRequired(String strIssueItemRequired) {
		this.strIssueItemRequired = strIssueItemRequired;
	}
	public String getStrNurseChecklistMandatory() {
		return strNurseChecklistMandatory;
	}
	public void setStrNurseChecklistMandatory(String strNurseChecklistMandatory) {
		this.strNurseChecklistMandatory = strNurseChecklistMandatory;
	}
	public String getStrUnitNameReq() {
		return strUnitNameReq;
	}
	public void setStrUnitNameReq(String strUnitNameReq) {
		this.strUnitNameReq = strUnitNameReq;
	}
	public String getStrRoomNoReq() {
		return strRoomNoReq;
	}
	public void setStrRoomNoReq(String strRoomNoReq) {
		this.strRoomNoReq = strRoomNoReq;
	}
	public String getStrNotReportedTimeLimit() {
		return strNotReportedTimeLimit;
	}
	public void setStrNotReportedTimeLimit(String strNotReportedTimeLimit) {
		this.strNotReportedTimeLimit = strNotReportedTimeLimit;
	}
	public String getStrBedAllotmentAtAdmission() {
		return strBedAllotmentAtAdmission;
	}
	public void setStrBedAllotmentAtAdmission(String strBedAllotmentAtAdmission) {
		this.strBedAllotmentAtAdmission = strBedAllotmentAtAdmission;
	}
	public String getStrDischargeTypeLAMA() {
		return strDischargeTypeLAMA;
	}
	public void setStrDischargeTypeLAMA(String strDischargeTypeLAMA) {
		this.strDischargeTypeLAMA = strDischargeTypeLAMA;
	}
	public String getStrDischargeTypeAbsconded() {
		return strDischargeTypeAbsconded;
	}
	public void setStrDischargeTypeAbsconded(String strDischargeTypeAbsconded) {
		this.strDischargeTypeAbsconded = strDischargeTypeAbsconded;
	}
	public String getStrDischargeTypeReferral() {
		return strDischargeTypeReferral;
	}
	public void setStrDischargeTypeReferral(String strDischargeTypeReferral) {
		this.strDischargeTypeReferral = strDischargeTypeReferral;
	}
	public String getStrDischargeTypeTransfer() {
		return strDischargeTypeTransfer;
	}
	public void setStrDischargeTypeTransfer(String strDischargeTypeTransfer) {
		this.strDischargeTypeTransfer = strDischargeTypeTransfer;
	}
	public String getStrDischargeTypeDeath() {
		return strDischargeTypeDeath;
	}
	public void setStrDischargeTypeDeath(String strDischargeTypeDeath) {
		this.strDischargeTypeDeath = strDischargeTypeDeath;
	}
	public String getStrNoOfSlipPrintedAtAdmission() {
		return strNoOfSlipPrintedAtAdmission;
	}
	public void setStrNoOfSlipPrintedAtAdmission(
			String strNoOfSlipPrintedAtAdmission) {
		this.strNoOfSlipPrintedAtAdmission = strNoOfSlipPrintedAtAdmission;
	}
	public String getBedLimit() {
		return bedLimit;
	}
	public void setBedLimit(String bedLimit) {
		this.bedLimit = bedLimit;
	}
	public String getPath() {
		return path;
	}
	public String getStrLeaveReqType()
	{
		return strLeaveReqType;
	}
	public void setStrLeaveReqType(String strLeaveReqType)
	{
		this.strLeaveReqType = strLeaveReqType;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public static String getPathFileName() {
		return pathFileName;
	}
	public String getStrConsentTemplateId() {
		return strConsentTemplateId;
	}
	public void setStrConsentTemplateId(String strConsentTemplateId) {
		this.strConsentTemplateId = strConsentTemplateId;
	}
	public String getStrAdmissionCharge() {
		return strAdmissionCharge;
	}
	public void setStrAdmissionCharge(String strAdmissionCharge) {
		this.strAdmissionCharge = strAdmissionCharge;
	}
	public String getStrNewBornBabyDefaultDept() {
		return strNewBornBabyDefaultDept;
	}
	public void setStrNewBornBabyDefaultDept(String strNewBornBabyDefaultDept) {
		this.strNewBornBabyDefaultDept = strNewBornBabyDefaultDept;
	}
	public String getStrAdvanceDepsoitAtAdmissionCounter() {
		return strAdvanceDepsoitAtAdmissionCounter;
	}
	public void setStrAdvanceDepsoitAtAdmissionCounter(
			String strAdvanceDepsoitAtAdmissionCounter) {
		this.strAdvanceDepsoitAtAdmissionCounter = strAdvanceDepsoitAtAdmissionCounter;
	}
	public String getUmidFlag() {
		return umidFlag;
	}
	public void setUmidFlag(String umidFlag) {
		this.umidFlag = umidFlag;
	}
	
}
