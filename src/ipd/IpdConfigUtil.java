package ipd;

//import investigation.cacheImplementation.cachevo.CacheLaboratoryTestVO;
import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;

public class IpdConfigUtil {

	private static final String pathFileName = "hisglobal.hisconfig.hisPath";
	
	public static final String SUPER_HOSPITAL_CODE = "100";
	public static final String CURRENT_HOSPITAL_CODE = "21917";
	
	public static final String MODULE_ID = "14";
	public static final String  strOpdCode="3";
	public static final String  strEmgCode="1";
    public static final  String strIsDead="1";
    public static final  String AUTO_BED_CHARGES_JOB="OFF";
    public static final  String PAT_PHOTO_MONGO="0";//Photograph from Mongo DB 1-Yes,0-No
    
    /**1 For Death Details Required and 0 For Death Details Not Required**/
    public static final String strDeathDetailsRequired="0";
	
	private String path = null;
	/*private JAXBElement<IPDConfig> jaxB = this.readXMLDataObject();
	private IPDConfig ipdConf = (IPDConfig) jaxB.getValue();
	private IPDGeneralConfigType ipdC = (IPDGeneralConfigType)ipdConf.getIpdGeneralConfig();
	private IPDPassDetails ipdPassDtls = (IPDPassDetails) ipdConf.getIpdPassDetails();
	private GenWardApprovalType gwat = (GenWardApprovalType) ipdC.getGenWardApproval();
	private PrivateWardApprovalType pwat = (PrivateWardApprovalType) ipdC.getPrivateWardApproval();
	private IPDBillDetails ipdBill=(IPDBillDetails) ipdConf.getIpdBillDetails();
	private IPDPrintConfigType ipdPrint=(IPDPrintConfigType) ipdConf.getIpdPrintDetails();
	private IPDReportDetails ipdReportDtls = (IPDReportDetails) ipdConf.getIpdReportDetails();*/
	
	
	private static JCS cacheVOIpdJCS ;	 	
	private String strHospitalCode = "";	
	private VOIpd vObj = null;
	public static final String PAT_PHOTO_PRINT_AT_ADM_CARD = "0";//1-Yes,0-No
	
	public IpdConfigUtil(String hospitalCode)  
	{
		this.strHospitalCode = hospitalCode;		
		try
		{			
			if(cacheVOIpdJCS == null)
			{				
				cacheVOIpdJCS = JCS.getInstance( "cacheVOIpd" );
			}
							
			if(cacheVOIpdJCS.get(hospitalCode) == null )
			{				
				cacheVOIpdJCS.put( hospitalCode, new VOIpd(hospitalCode) );
			}
			
			vObj = (VOIpd) cacheVOIpdJCS.get(hospitalCode);			 			
		} 
		catch (CacheException e1)
		{
			e1.printStackTrace();
		}
	}
	
	
	
	private String strGenWardAdmission = "0";
	//private String[] strGenWardApprover = new String[gwat.getAuthorityId().size()];
	private String strPrivateWardAdmission = "0";
	//private String[] strPrivateWardApprover = new String[pwat.getAuthorityId().size()];
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
	//private String strAdmissionChargeTakenAtCounter="0";
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
	private String strAdmissionCharge="";
	private String strAdvanceRequestAdmissionAdvice="";
	private String strAdvanceAmountAdmission="";
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
	private String strNormlaDischargeType="0";
	


	private String strNoOfSlipPrintedAtAdmission="";
	private String bedLimit="1";
	private String strLeaveReqType="2";
	private String strConsentTemplateId="";



	private String printModeforAdmissionTicket="0";
	private String strNewBornBabyDefaultDept="0";
	private String strDischargeSlipReq="";
	
	private String strAdvanceDepsoitAtAdmissionCounter="0";//Check Whether Advance Needs to Be Deposit At Admission Counter
	private String umidFlag="0";
    
	public void removeCacheIpdVObj(String hospitalCode)
	{
		VOIpd vObj = null;
		
		vObj = (VOIpd) cacheVOIpdJCS.get(hospitalCode);		
		if (vObj != null)
		{
			try 
			{
				cacheVOIpdJCS.remove(hospitalCode);
			} 
			catch (CacheException e) 
			{
					e.printStackTrace();
			}
		}	
	}
	public void reloadcacheIpdVObj(String hospitalCode)
	{
		VOIpd vObj = null;
		
		vObj = (VOIpd) cacheVOIpdJCS.get(hospitalCode);		
		if (vObj != null)
		{
			try 
			{
				cacheVOIpdJCS.remove(hospitalCode);//First remove from cache
				cacheVOIpdJCS.put( hospitalCode, new VOIpd(hospitalCode) );
			} 
			catch (CacheException e) 
			{
					e.printStackTrace();
			}
		}
		else
		{
			try 
			{
				cacheVOIpdJCS.put( hospitalCode, new VOIpd(hospitalCode) );
			} 
			catch (CacheException e) 
			{
					e.printStackTrace();
			}
		}
	}
	
	
	public String getStrDischargeSlipReq() {
		return vObj.getStrDischargeSlipReq();
	}
	

	
	public String getStrNormlaDischargeType() {
		return vObj.getStrNormalDischargeType();
	}

	public String getBedLimit() {
		return vObj.getBedLimit();
	}
	public String getStrLeaveReqType() {
		return vObj.getStrLeaveReqType();
	}
	public String getStrDischargeTypeLAMA() {
		return vObj.getStrDischargeTypeLAMA();
	}
	public String getStrDischargeTypeAbsconded() {
		return vObj.getStrDischargeTypeAbsconded();
	}
	public String getStrDischargeTypeReferral() {
		return vObj.getStrDischargeTypeReferral();
	}
	public String getStrDischargeTypeTransfer() {
		return vObj.getStrDischargeTypeTransfer();
	}
	public String getStrDischargeTypeDeath() {
		return vObj.getStrDischargeTypeDeath();
	}
	public String getStrBedAllotmentAtAdmission() {
		return vObj.getStrBedAllotmentAtAdmission();
	}
	public String getPath() {
		return vObj.getPath();
	}
	public String getStrGenWardAdmission() {
		return vObj.getStrGenWardAdmission();
	}
	public String getStrPrivateWardAdmission() {
		return vObj.getStrPrivateWardAdmission();
	}
	public String getStrBookBed() {
		return vObj.getStrBookBed();
	}
	public String getStrBilling() {
		return vObj.getStrBilling();
	}
	public String getStrNegativeBilling() {
		return vObj.getStrNegativeBilling();
	}
	public String getStaffCategory() {
		return vObj.getStaffCategory();
	}
	public String getGovtEmployeeBasicPayLimit() {
		return vObj.getGovtEmployeeBasicPayLimit();
	}
	public String getPrivateEmployeeMonthlyIncomeLimit() {
		return vObj.getPrivateEmployeeMonthlyIncomeLimit();
	}
	public String getStrPurgingRecordCurrentlyAdmissionDetails() {
		return vObj.getStrPurgingRecordCurrentlyAdmissionDetails();
	}
	public String getStrPurgeTimeNotReportedPatient() {
		return vObj.getStrPurgeTimeNotReportedPatient();
	}
	public String getStrNoOfLineInAdmissionSlip() {
		return vObj.getStrNoOfLineInAdmissionSlip();
	}
	public String getStrNoOfLineInVisitorPassSlip() {
		return vObj.getStrNoOfLineInVisitorPassSlip();
	}
	public String getStrNoOfFreePassAdmisssionTime() {
		return vObj.getStrNoOfFreePassAdmisssionTime();
	}
	public String getStrNoOfFreePass() {
		return vObj.getStrNoOfFreePass();
	}
	public String getStrNoOfPaidPass() {
		return vObj.getStrNoOfPaidPass();
	}
	public String getStrNewFreePassValidity() {
		return vObj.getStrNewFreePassValidity();
	}
	public String getStrNewPaidPassValidity() {
		return vObj.getStrNewPaidPassValidity();
	}
	public String getStrRenewFreePassValidity() {
		return vObj.getStrRenewFreePassValidity();
	}
	public String getStrRenewPaidPassValidity() {
		return vObj.getStrRenewPaidPassValidity();
	}
	public String getStrAdmissionOnline() {
		return vObj.getStrAdmissionOnline();
	}
	public String getStrSummerMorningFromTime() {
		return vObj.getStrSummerMorningFromTime();
	}
	public String getStrSummerMorningToTime() {
		return vObj.getStrSummerMorningToTime();
	}
	public String getStrSummerEveningFromTime() {
		return vObj.getStrSummerEveningFromTime();
	}
	public String getStrSummerEveningToTime() {
		return vObj.getStrSummerEveningToTime();
	}
	public String getStrWinterMorningFromTime() {
		return vObj.getStrWinterMorningFromTime();
	}
	public String getStrWinterMorningToTime() {
		return vObj.getStrWinterMorningToTime();
	}
	public String getStrWinterEveningFromTime() {
		return vObj.getStrWinterEveningFromTime();
	}
	public String getStrWinterEveningToTime() {
		return vObj.getStrWinterEveningToTime();
	}
	public String getStrPrintRequest() {
		return vObj.getStrPrintRequest();
	}
	/*public String getStrAdmissionChargeTakenAtCounter() {
		return vObj.getStrAdmissionChargeTakenAtCounter();
	}*/
	public String getStrAdmissionAdviceValidityTo() {
		return vObj.getStrAdmissionAdviceValidityTo();
	}
	public String getStrAdmissionAdviceValidityFrom() {
		return vObj.getStrAdmissionAdviceValidityFrom();
	}
	public String getStrNewBornBabyAdmissionCharge() {
		return vObj.getStrNewBornBabyAdmissionCharge();
	}
	public String getStrNewBornBabyRegistrationCharge() {
		return vObj.getStrNewBornBabyRegistrationCharge();
	}
	public String getStrModificationTimeValidity() {
		return vObj.getStrModificationTimeValidity();
	}
	public String getStrDischargeCancellationTime() {
		return vObj.getStrDischargeCancellationTime();
	}
	public String getStrAdvanceAmountNewBornBaby() {
		return vObj.getStrAdvanceAmountNewBornBaby();
	}
	public String getStrBlockedExpiryTime() {
		return vObj.getStrBlockedExpiryTime();
	}
	public String getStrAdmissionReprintCharge() {
		return vObj.getStrAdmissionReprintCharge();
	}
	public String getStrPaidPassCharge() {
		return vObj.getStrPaidPassCharge();
	}
	public String getStrPaidPassRenewCharge() {
		return vObj.getStrPaidPassRenewCharge();
	}
	public String getStrPassReprintCharge() {
		return vObj.getStrPassReprintCharge();
	}
	public String getStrDischargeReprintCharge() {
		return vObj.getStrDischargeReprintCharge();
	}
	public String getStrPrivateWardType() {
		return vObj.getStrPrivateWardType();
	}
	public String getStrIcuWardType() {
		return vObj.getStrIcuWardType();
	}
	public String getStrDischargeSummaryReportAdvice() {
		return vObj.getStrDischargeSummaryReportAdvice();
	}
	public String getStrIntegrationBilling() {
		return vObj.getStrIntegrationBilling();
	}
	public String getStrAdvanceRequestAdmissionAdvice() {
		return vObj.getStrAdvanceRequestAdmissionAdvice();
	}
	public String getStrAdvanceAmountAdmission() {
		return vObj.getStrAdvanceAmountAdmission();
	}
	public String getStrPatientAdjustedFinalDischargeBill() {
		return vObj.getStrPatientAdjustedFinalDischargeBill();
	}
	public String getStrBedChange() {
		return vObj.getStrBedChange();
	}
	public String getStrRefundRequestAdmissionCancellation() {
		return vObj.getStrRefundRequestAdmissionCancellation();
	}
	public String getStrNoOfLineInNewBornBabyAdmissionSlip() {
		return vObj.getStrNoOfLineInNewBornBabyAdmissionSlip();
	}
	public String getStrMsApprovalOffline() {
		return vObj.getStrMsApprovalOffline();
	}
	public String getStrAttendentPass() {
		return vObj.getStrAttendentPass();
	}
	public String getStrAttendentPassGenerateAtAdmissionTime() {
		return vObj.getStrAttendentPassGenerateAtAdmissionTime();
	}
	public String getStrDischargeProcessType() {
		return vObj.getStrDischargeProcessType();
	}
	public String getStrNewBornBabyProcessType() {
		//System.out.println("vObj.getStrNewBornBabyProcessType()"+vObj.getStrNewBornBabyProcessType());
		return vObj.getStrNewBornBabyProcessType();
	}
	public String getStrMinAgeToBeMother() {
		return vObj.getStrMinAgeToBeMother();
	}
	public String getStrMaxNoOfBabyMotherCanBorn() {
		return vObj.getStrMaxNoOfBabyMotherCanBorn();
	}
	public String getStrDiagnosisType() {
		return vObj.getStrDiagnosisType();
	}
	public String getStrAdmissionAdviceMode() {
		return vObj.getStrAdmissionAdviceMode();
	}
	public String getStrBelongingRequired() {
		return vObj.getStrBelongingRequired();
	}
	public String getStrIssueItemRequired() {
		return vObj.getStrIssueItemRequired();
	}
	public String getStrNurseChecklistMandatory() {
		return vObj.getStrNurseChecklistMandatory();
	}
	public String getStrUnitNameReq() {
		return vObj.getStrUnitNameReq();
	}
	public String getStrRoomNoReq() {
		return vObj.getStrRoomNoReq();
	}
	public String getStrNotReportedTimeLimit() {
		return vObj.getStrNotReportedTimeLimit();
	}
	public static String getPathFileName() {
		return pathFileName;
	}
	public String getStrNoOfSlipPrintedAtAdmission() {
		return vObj.getStrNoOfSlipPrintedAtAdmission();
	}
	public String getStrConsentTemplateId() {
		return vObj.getStrConsentTemplateId();
	}
	public String getStrAdmissionCharge() {
		return vObj.getStrAdmissionCharge();
	}
	public String getPrintModeforAdmissionTicket() {
		return printModeforAdmissionTicket;
	}
	public String getStrNewBornBabyDefaultDept() {
		return vObj.getStrNewBornBabyDefaultDept();
	}
	public String getStrAdvanceDepsoitAtAdmissionCounter() {
		return vObj.getStrAdvanceDepsoitAtAdmissionCounter();
	}
	public String getUmidFlag() {
		return vObj.getUmidFlag();
	}
	

}
