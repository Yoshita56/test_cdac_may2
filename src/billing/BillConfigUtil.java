package billing;

import hisglobal.exceptions.HisException;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.WebRowSet;

import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;

public class BillConfigUtil
{
	public static final String BILL_MODULE_ID = "17";	
	public static final String NORMAL_CATEGORY = "11";
	public static final String DEFAULT_HOSPITAL_SERVICE = "1";	
	public static final String DEFAULT_UNIT_ID  = "1701";	
	public static final String GROUP_ID_DEPOSIT = "100";	
	public static final String SUPER_HOSPITAL_CODE = "100";	
	public static final String GROUP_ID_GENERAL_CHARGES = "122";
	public static final String DIET_CHARGE_ID = "1330003";
	public static final String PRINT_MODE= "1";//Print Mode Laser=1 , Print Mode DMP=2
	public static final String CHECK_COUNTER_STATUS="0";//1-Counter to be checked in Cash Collection Offline,0-No Counter Check needed
	
	public static final String DEFAULT_UNIT_ID_EACH  = "1701";
	public static final String DEFAULT_UNIT_NAME_EACH  = "No(Each)";
	public static final String DEFAULT_UNIT_ID_DAY  = "1702";
	public static final String DEFAULT_UNIT_NAME_DAY  = "DAY";
	public static final String CREDIT_LETTER_VALIDITY_CHECK_DAYS  = "30";
	public static final String BACK_DATE_DAYEND_STOP_PROCESS  = "0";//Used In Case if Back Date Day end Not Done the user not able to collect the cash.
	public static final String AROGYASHREE_CLIENT_CODE = "2000";	
	public static final String NTR_CLIENT_CODE = "1000";
	public static final String PHARMACY_GROUP_ID = "107";
	public static final String IPD_BILL_REOPEN_VALIDITY = "10";
	public static final double DEFAULT_SURCHARGE_LIMIT  = 2000.00;
		
	private static JCS cacheBillVOJCS ;	 	
	@SuppressWarnings("unused")
	private String strHospitalCode = "";	
	private BillVO vObj = null;
	
	public BillConfigUtil(String hospitalCode)  
	{
		this.strHospitalCode = hospitalCode;		
		try
		{			
			if(cacheBillVOJCS == null)
			{				
				cacheBillVOJCS = JCS.getInstance( "cacheBillVO" );
				//System.out.println("cache inside");
			}
							
			if(cacheBillVOJCS.get(hospitalCode) == null )
			{				
				cacheBillVOJCS.put( hospitalCode, new BillVO(hospitalCode) );
				//System.out.println("cache not exists");
			}
			
			vObj = (BillVO) cacheBillVOJCS.get(hospitalCode);
			//System.out.println("cache"+vObj.getGeneralDuplicatePrint());
		} 
		catch (CacheException e1)
		{
			e1.printStackTrace();
		}
	}
 
	
	private String billFormatHeader1 = "";
	private String billFormatHeader2 = "";
	private String billFormatHeader3 = "";
	private String billFormatHeader4 = "";
	private String billFormatFooter = "";
	private String billDisclaimerWithoutCrNo = "";
	private String billDisclaimerServices = "";
	private String billDisclaimerRefund = "";
	private String billDisclaimerAdvance = "";
	private String billDisclaimerPartPayment = "";
	private String billDisclaimerFinalBill = "";
	private String billDisclaimerDuplicatePrintRequired = "0";
	private String billLineOpdServices = "";
	

	private String emergencyThirdPartyBilling = "";
	private String emergencyDiscount = "";
	private String emergencyDiscountClerk = "";
	private String emergencyRefundPenalty = "";
	private String emergencyRoundOff = "";
	private String emergencyServiceTax = "";
	private String emergencyFreeCategory = "";
	
	private String finStartYear = "0";
	private String inBound = "0";
	private String outBound = "0";
	private String generalCancellationTime = "00";
	private String generalDuplicatePrintCharge = "0";
	private String generalRecordsDisplayMaster = "0";
	private String generalLevelModifyMaster = "0";
	private String generalLevelDeleteMaster = "0";
	private String generalReceiptType = "1";
	private String generalDuplicatePrint = "1";
	private String generalRefundReceiptType = "1";
	private String generalIsWithoutCrNoRequired = "0";
	private String generalOnlineRefundRequestAllowed = "0";
	private String generalReferringPhysicianRequiredInt = "0";
	private String generalReferringPhysicianRequiredExt = "0";
	private String generalPreviousCrNoRequiredInt = "0";
	private String generalPreviousCrNoRequiredExt = "0";
	private String generalCashCollectionConfrimType = "0";
	private String generalPreviousCrNoSearchingInt = "0";
	private String generalPreviousCrNoSearchingExt = "0";
	private String generalDayEndProcessType = "0";
	private String generalDayEndDateType = "0";
	private String generalDayEndNonBillingProcessType = "0";
	private String generalDayEndNonBillingDateType = "0";
	private String generalOpdReceiptType = "0";
	private String generalIpdReceiptType = "0";
	private String generalCCOfflineRefundRequired = "0";
	private String generalPrintMessageLimit = "0";
	private String generalRefundAgainstRefundRequest = "0";
	private String generalChargeTypeExt = "0";
	private String generalChargeTypeInt = "0";
	private String generalWardTypeExt = "0";
	private String generalWardTypeInt = "0";
	private String generalInternalPatient = "0";
	private String generalExternalPatient = "0";
	private String generalIsApprovalRequired = "0";
	private String strDefaultTariffCode="";
	private String strGeneralWardType = "";
	private String strGeneralRoomType = "";
	private String strConsumableChargesGroupId="";		
	private String strConsumableChargesTariffCode=""; 	
	
	private String ipdGenServiceFreeTreatmentTime = "";
	private String ipdGenAdvanceReq="";
	private String ipdThirdPartyBilling = "";
	private String ipdDiscount = "";
	private String ipdDiscountClerk = "";
	private String ipdRefundPenalty = "";
	private String ipdCreaditBilling = "";
	private String ipdExcessCreditLimit = "";
	private String ipdPartPaymentDuration = "";
	private String ipdRoundOff = "";
	private String ipdServiceTaxOnTotalBill = "";
	private String ipdGenAdtProcessType = "";
	private String ipdServiceTax = "";
	private String ipdFreeCategory = "";
	private String ipdGenCheckOutTimeHr = "00";
	private String ipdGenCheckOutTimeMn = "00";
	private String ipdGenCheckOutTimePrivateHr = "00";
	private String ipdGenCheckOutTimePrivateMn = "00";
	private String ipdGenFlexibleTime = "0";
	private String ipdGenFlexibleTimeAdmission = "0";
	private String ipdGenReOpenValidity = "0";   
	
	private String opdThirdPartyBilling = "";
	private String opdDiscount = "";
	private String opdDiscountClerk = "";
	private String opdRefundPenalty = "";
	private String opdRoundOff = "";
	private String opdServiceTax = "";
	private String opdFreeCategory = "";
	private String strCreditCashlessAppRequired="";
	private String strPaidCategory="";
	private String strArogyaShreeCategory="";
	private String strArogyaShreeTSCategory="";
	private String strCGSHCategory="";
	private String strGenCategory="";
	private String strWSHCategory="";
	private String strDayEndTimeBoundFlag="";
	private String strDayEndTimeHour="";
	private String strDayEndTimeMin="";
	private String strDayEndTimeAMPM="";
	private String strDayEndTime="";
	private String strArogyaTSCatCreditLimit="";
	private String strUrgTrfSur="";
	private String strSurCc="";
	private String strSurDc="";
	private String strSurIc="";
	private String strSurId="";
	private String strSurCc1="";
	private String strSurDc1="";
	private String strSurIc1="";
	private String strSurId1="";
	private String logoReq="";
	private String strArogyaIpdCreditLimit = "";
	private String strOSTFCategoryvalue="";
	private String niramaya="";
	private String niramayaValue="";
	private String hindiReq="";
	private String headerReq="";
	private String strNegativeDayEndAllowed="0";
	private String strDenominationAllowed="1";
	private String reqModiCat="";

	
	public String getNiramaya() {
		return niramaya;
	}

	

	public String getNiramayaValue() {
		return niramayaValue;
	}

	

	public String getStrOSTFCategoryvalue() {
		return strOSTFCategoryvalue;
	}


	public String getStrArogyaIpdCreditLimit() {
		return vObj.getStrArogyaIpdCreditLimit();
	}

	public void setStrArogyaIpdCreditLimit(String strArogyaIpdCreditLimit) {
		this.strArogyaIpdCreditLimit = strArogyaIpdCreditLimit;
	}

	public String getBillFormatHeader1()
	{
		return vObj.getBillFormatHeader1();
	}

	public String getBillFormatHeader2()
	{
		return vObj.getBillFormatHeader2();
	}

	public String getBillFormatHeader3()
	{
		return vObj.getBillFormatHeader3();
	}

	public String getBillFormatHeader4()
	{
		return vObj.getBillFormatHeader4();
	}

	public String getBillFormatFooter()
	{
		return vObj.getBillFormatFooter();
	}

	public String getBillDisclaimerWithoutCrNo()
	{
		return vObj.getBillDisclaimerWithoutCrNo();
	}

	public String getBillDisclaimerServices()
	{
		return vObj.getBillDisclaimerServices();
	}

	public String getBillDisclaimerRefund()
	{
		return vObj.getBillDisclaimerRefund();
	}

	public String getBillDisclaimerAdvance()
	{
		return vObj.getBillDisclaimerAdvance();
	}

	public String getBillDisclaimerPartPayment()
	{
		return vObj.getBillDisclaimerPartPayment();
	}

	public String getBillDisclaimerFinalBill()
	{
		return vObj.getBillDisclaimerFinalBill();
	}

	public String getBillDisclaimerDuplicatePrintRequired()
	{
		return vObj.getBillDisclaimerDuplicatePrintRequired();
	}

	public String getBillLineOpdServices()
	{
		return vObj.getBillLineOpdServices();
	}

	public String getEmergencyThirdPartyBilling()
	{
		return vObj.getEmergencyThirdPartyBilling();
	}

	public String getEmergencyDiscount()
	{
		return vObj.getEmergencyDiscount();
	}

	public String getEmergencyDiscountClerk()
	{
		return vObj.getEmergencyDiscountClerk();
	}

	public String getEmergencyRefundPenalty()
	{
		return vObj.getEmergencyRefundPenalty();
	}

	public String getEmergencyRoundOff()
	{
		return vObj.getEmergencyRoundOff();
	}

	public String getEmergencyServiceTax()
	{
		return vObj.getEmergencyServiceTax();
	}

	public String getEmergencyFreeCategory()
	{
		return vObj.getEmergencyFreeCategory();
	}

	public String getFinStartYear()
	{
		return vObj.getFinStartYear();
	}

	public String getInBound()
	{
		return vObj.getInBound();
	}

	public String getOutBound()
	{
		return vObj.getOutBound();
	}

	public String getGeneralCancellationTime()
	{
		return vObj.getGeneralCancellationTime();
	}

	public String getGeneralDuplicatePrintCharge()
	{
		return vObj.getGeneralDuplicatePrintCharge();
	}

	public String getGeneralRecordsDisplayMaster()
	{
		return vObj.getGeneralRecordsDisplayMaster();
	}

	public String getGeneralLevelModifyMaster()
	{
		return vObj.getGeneralLevelModifyMaster();
	}

	public String getGeneralLevelDeleteMaster()
	{
		return vObj.getGeneralLevelDeleteMaster();
	}

	public String getGeneralReceiptType()
	{
		return vObj.getGeneralReceiptType();
	}

	public String getGeneralDuplicatePrint()
	{
		//System.out.println("Getter"+vObj.getGeneralDuplicatePrint());
		return vObj.getGeneralDuplicatePrint();
	}

	public String getGeneralRefundReceiptType()
	{
		return vObj.getGeneralRefundReceiptType();
	}

	public String getGeneralIsWithoutCrNoRequired()
	{
		return vObj.getGeneralIsWithoutCrNoRequired();
	}

	public String getGeneralOnlineRefundRequestAllowed()
	{
		return vObj.getGeneralOnlineRefundRequestAllowed();
	}

	public String getGeneralReferringPhysicianRequiredInt()
	{
		return vObj.getGeneralReferringPhysicianRequiredInt();
	}

	public String getGeneralReferringPhysicianRequiredExt()
	{
		return vObj.getGeneralReferringPhysicianRequiredExt();
	}

	public String getGeneralPreviousCrNoRequiredInt()
	{
		return vObj.getGeneralPreviousCrNoRequiredInt();
	}

	public String getGeneralPreviousCrNoRequiredExt()
	{
		return vObj.getGeneralPreviousCrNoRequiredExt();
	}

	public String getGeneralCashCollectionConfrimType()
	{
		return vObj.getGeneralCashCollectionConfrimType();
	}

	public String getGeneralPreviousCrNoSearchingInt()
	{
		return vObj.getGeneralPreviousCrNoSearchingInt();
	}

	public String getGeneralPreviousCrNoSearchingExt()
	{
		return vObj.getGeneralPreviousCrNoSearchingExt();
	}

	public String getGeneralDayEndProcessType()
	{
		return vObj.getGeneralDayEndProcessType();
	}

	public String getGeneralDayEndDateType()
	{
		return vObj.getGeneralDayEndDateType();
	}

	public String getGeneralDayEndNonBillingProcessType()
	{
		return vObj.getGeneralDayEndNonBillingProcessType();
	}

	public String getGeneralDayEndNonBillingDateType()
	{
		return vObj.getGeneralDayEndNonBillingDateType();
	}

	public String getGeneralOpdReceiptType()
	{
		return vObj.getGeneralOpdReceiptType();
	}

	public String getGeneralIpdReceiptType()
	{
		return vObj.getGeneralIpdReceiptType();
	}

	public String getGeneralCCOfflineRefundRequired()
	{
		return vObj.getGeneralCCOfflineRefundRequired();
	}

	public String getGeneralPrintMessageLimit()
	{
		return vObj.getGeneralPrintMessageLimit();
	}

	public String getGeneralRefundAgainstRefundRequest()
	{
		return vObj.getGeneralRefundAgainstRefundRequest();
	}

	public String getGeneralChargeTypeExt()
	{
		return vObj.getGeneralChargeTypeExt();
	}

	public String getGeneralChargeTypeInt()
	{
		return vObj.getGeneralChargeTypeInt();
	}

	public String getGeneralWardTypeExt()
	{
		return vObj.getGeneralWardTypeExt();
	}

	public String getGeneralWardTypeInt()
	{
		return vObj.getGeneralWardTypeInt();
	}

	public String getGeneralInternalPatient()
	{
		return vObj.getGeneralInternalPatient();
	}

	public String getGeneralExternalPatient()
	{
		return vObj.getGeneralExternalPatient();
	}

	public String getGeneralIsApprovalRequired()
	{
		return vObj.getGeneralIsApprovalRequired();
	}

	public String getStrDefaultTariffCode()
	{
		return vObj.getStrDefaultTariffCode();
	}

	public String getStrGeneralWardType()
	{
		return vObj.getStrGeneralWardType();
	}

	public String getStrGeneralRoomType()
	{
		return vObj.getStrGeneralRoomType();
	}

	public String getStrConsumableChargesGroupId()
	{
		return vObj.getStrConsumableChargesGroupId();
	}

	public String getStrConsumableChargesTariffCode()
	{
		return vObj.getStrConsumableChargesTariffCode();
	}

	public String getIpdGenServiceFreeTreatmentTime()
	{
		return vObj.getIpdGenServiceFreeTreatmentTime();
	}

	public String getIpdGenAdvanceReq()
	{
		return vObj.getIpdGenAdvanceReq();
	}

	public String getIpdThirdPartyBilling()
	{
		return vObj.getIpdThirdPartyBilling();
	}

	public String getIpdDiscount()
	{
		return vObj.getIpdDiscount();
	}

	public String getIpdDiscountClerk()
	{
		return vObj.getIpdDiscountClerk();
	}

	public String getIpdRefundPenalty()
	{
		return vObj.getIpdRefundPenalty();
	}

	public String getIpdCreaditBilling()
	{
		return vObj.getIpdCreaditBilling();
	}

	public String getIpdExcessCreditLimit()
	{
		return vObj.getIpdExcessCreditLimit();
	}

	public String getIpdPartPaymentDuration()
	{
		return vObj.getIpdPartPaymentDuration();
	}

	public String getIpdRoundOff()
	{
		return vObj.getIpdRoundOff();
	}

	public String getIpdServiceTaxOnTotalBill()
	{
		return vObj.getIpdServiceTaxOnTotalBill();
	}

	public String getIpdGenAdtProcessType()
	{
		return vObj.getIpdGenAdtProcessType();
	}

	public String getIpdServiceTax()
	{
		return vObj.getIpdServiceTax();
	}

	public String getIpdFreeCategory()
	{
		return vObj.getIpdFreeCategory();
	}

	public String getIpdGenCheckOutTimeHr()
	{
		return vObj.getIpdGenCheckOutTimeHr();
	}

	public String getIpdGenCheckOutTimeMn()
	{
		return vObj.getIpdGenCheckOutTimeMn();
	}

	public String getIpdGenCheckOutTimePrivateHr()
	{
		return vObj.getIpdGenCheckOutTimePrivateHr();
	}

	public String getIpdGenCheckOutTimePrivateMn()
	{
		return vObj.getIpdGenCheckOutTimePrivateMn();
	}

	public String getIpdGenFlexibleTime()
	{
		return vObj.getIpdGenFlexibleTime();
	}

	public String getIpdGenFlexibleTimeAdmission()
	{
		return vObj.getIpdGenFlexibleTimeAdmission();
	}

	public String getIpdGenReOpenValidity()
	{
		return vObj.getIpdGenReOpenValidity();
	}

	public String getOpdThirdPartyBilling()
	{
		return vObj.getOpdThirdPartyBilling();
	}

	public String getOpdDiscount()
	{
		return vObj.getOpdDiscount();
	}

	public String getOpdDiscountClerk()
	{
		return vObj.getOpdDiscountClerk();
	}

	public String getOpdRefundPenalty()
	{
		return vObj.getOpdRefundPenalty();
	}

	public String getOpdRoundOff()
	{
		return vObj.getOpdRoundOff();
	}

	public String getOpdServiceTax()
	{
		return vObj.getOpdServiceTax();
	}

	public String getOpdFreeCategory()
	{
		return vObj.getOpdFreeCategory();
	}
	
	public String getStrCreditCashlessAppRequired() {
		return vObj.getStrCreditCashlessAppRequired();
		
	}
	

	public String getStrArogyaTSCatCreditLimit() {
		return vObj.getStrArogyaTSCreditLimit();
	}

	public String getStrPaidCategory() {
		return vObj.getStrPaidCategory();
	}

	public String getStrArogyaShreeCategory() {
		return vObj.getStrArogyaShreeCategory();
	}

	public String getStrArogyaShreeTSCategory() {
		return vObj.getStrArogyaShreeTSCategory();
	}

	public String getStrCGSHCategory() {
		return vObj.getStrCGSHCategory();
	}

	public String getStrGenCategory() {
		return vObj.getStrGenCategory();
	}

	public String getStrWSHCategory() {
		return vObj.getStrWSHCategory();
	}
    
	
	public String getStrUrgTrfSur() {
		return vObj.getStrUrgTrfSur();
	}
	
	public String getLogoReq() {
		return vObj.getLogoReq();
	}

	public String getStrDayEndTimeBoundFlag() {
		return vObj.getStrDayEndTimeBoundFlag();
	}

	public String getStrDayEndTimeHour() {
		return vObj.getStrDayEndTimeHour();
	}

	public String getStrDayEndTimeMin() {
		return vObj.getStrDayEndTimeMin();
	}

	public String getStrDayEndTimeAMPM() {
		return vObj.getStrDayEndTimeAMPM();
	}

	public String getStrDayEndTime() {
		return vObj.getStrDayEndTime();
	}
	

	public String getStrSurCc() {
		return vObj.getStrSurCc();
	}
	

	public String getStrSurDc() {
		return vObj.getStrSurDc();
	}

	public String getStrSurIc() {
		return vObj.getStrSurIc();
	}
	
	public String getStrSurId() {
		return vObj.getStrSurId();
	}
	
	public String getStrSurCc1() {
		return vObj.getStrSurCc1();
	}
	

	public String getStrSurDc1() {
		return vObj.getStrSurDc1();
	}

	public String getStrSurIc1() {
		return vObj.getStrSurIc1();
	}
	
	public String getStrSurId1() {
		return vObj.getStrSurId1();
	}
	public String getHindiReq() {
		return vObj.getHindiReq();
	}
	
	public String getHeaderReq() {
		return vObj.getHeaderReq();
	}
	

	public String getReqModiCat() {
		return vObj.getReqModiCat();
	}



	public String getStrNegativeDayEndAllowed() {
		return vObj.getStrNegativeDayEndAllowed();
	}



	public String getStrDenominationAllowed() {
		return vObj.getStrDenominationAllowed();
	}



	public void removeCacheBillVObj(String hospitalCode)
	{
		BillVO vObj = null;
		
		vObj = (BillVO) cacheBillVOJCS.get(hospitalCode);		
		if (vObj != null)
		{
			try 
			{
				cacheBillVOJCS.remove(hospitalCode);
			} 
			catch (CacheException e) 
			{
					e.printStackTrace();
			}
		}	
	}
	public void reloadCacheBillVObj(String hospitalCode)
	{
		BillVO vObj = null;
		
		vObj = (BillVO) cacheBillVOJCS.get(hospitalCode);		
		if (vObj != null)
		{
			try 
			{
				cacheBillVOJCS.remove(hospitalCode);//First remove from cache
				cacheBillVOJCS.put( hospitalCode, new BillVO(hospitalCode) );
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
				cacheBillVOJCS.put( hospitalCode, new BillVO(hospitalCode) );
			} 
			catch (CacheException e) 
			{
					e.printStackTrace();
			}
		}
	}
	public static String getDefaultUnitCombo(String selectedVal)
	{
		String comboValues2 = "<option value='0'> Select Value </option>";
		HisUtil hisutil = new HisUtil("Billing", "BillConfigUTIL");
		//String strquery = "";
		//int nqryIndex = 0;
		//WebRowSet wb = null;
		List al=new ArrayList();
		
		HisDAO dao = new HisDAO("billing", "LocalTariffMstFB");
		
		try
		{
			al.add(DEFAULT_UNIT_ID_EACH);
			al.add(DEFAULT_UNIT_NAME_EACH);
			al.add(DEFAULT_UNIT_ID_DAY);
			al.add(DEFAULT_UNIT_NAME_DAY);
			/*strquery = billing.qryHandler_billing.getQuery(1, "select.tariffunitname.1").replace("?", BillConfigUtil.SUPER_HOSPITAL_CODE);
			strquery = strquery.concat(" and ").concat(billing.qryHandler_billing.getQuery(1, "select.tariffunitname.cond.1").replace("?", BillConfigUtil.BILL_MODULE_ID));

			nqryIndex = dao.setQuery(strquery);
			wb = dao.executeQry(nqryIndex);*/

			if (selectedVal == null || selectedVal == "")
			{
				comboValues2 = hisutil.getOptionValue(al, "0", "0^Select Value");
			} 
			else
			{
				comboValues2 = hisutil.getOptionValue(al, selectedVal, "0^Select Value");
			}
		} 
		catch (Exception e)
		{
			new HisException("billing", "BillConfigUTIL.getAddDefaultUnitCombo()", e.getMessage());
		}
		return comboValues2;
	}
	public static String getDefaultUnitComboForPkg(String selectedVal)
	{
		String comboValues2 = "<option value='0'> Select Value </option>";
		HisUtil hisutil = new HisUtil("Billing", "BillConfigUTIL");
		//String strquery = "";
		//int nqryIndex = 0;
		//WebRowSet wb = null;
		List al=new ArrayList();
		
		HisDAO dao = new HisDAO("billing", "LocalTariffMstFB");
		
		try
		{
			al.add(DEFAULT_UNIT_ID_EACH);
			al.add(DEFAULT_UNIT_NAME_EACH);
			
			/*strquery = billing.qryHandler_billing.getQuery(1, "select.tariffunitname.1").replace("?", BillConfigUtil.SUPER_HOSPITAL_CODE);
			strquery = strquery.concat(" and ").concat(billing.qryHandler_billing.getQuery(1, "select.tariffunitname.cond.1").replace("?", BillConfigUtil.BILL_MODULE_ID));

			nqryIndex = dao.setQuery(strquery);
			wb = dao.executeQry(nqryIndex);*/

			if (selectedVal == null || selectedVal == "")
			{
				comboValues2 = hisutil.getOptionValue(al, "0", "0^Select Value");
			} 
			else
			{
				comboValues2 = hisutil.getOptionValue(al, selectedVal, "0^Select Value");
			}
		} 
		catch (Exception e)
		{
			new HisException("billing", "BillConfigUTIL.getDefaultUnitComboForPkg()", e.getMessage());
		}
		return comboValues2;
	}
	public static String getDefaultUnitComboWithBaseValue(String selectedVal)
	{
		String comboValues2 = "<option value='0'> Select Value </option>";
		HisUtil hisutil = new HisUtil("Billing", "BillConfigUTIL");
		//String strquery = "";
		//int nqryIndex = 0;
		//WebRowSet wb = null;
		List al=new ArrayList();
		
		HisDAO dao = new HisDAO("billing", "BillConfigUtil");
		
		try
		{
			al.add(DEFAULT_UNIT_ID_EACH+"^1");
			al.add(DEFAULT_UNIT_NAME_EACH);
			al.add(DEFAULT_UNIT_ID_DAY+"^1");
			al.add(DEFAULT_UNIT_NAME_DAY);
			/*strquery = billing.qryHandler_billing.getQuery(1, "select.tariffunitname.1").replace("?", BillConfigUtil.SUPER_HOSPITAL_CODE);
			strquery = strquery.concat(" and ").concat(billing.qryHandler_billing.getQuery(1, "select.tariffunitname.cond.1").replace("?", BillConfigUtil.BILL_MODULE_ID));

			nqryIndex = dao.setQuery(strquery);
			wb = dao.executeQry(nqryIndex);*/

			if (selectedVal == null || selectedVal == "")
			{
				comboValues2 = hisutil.getOptionValue(al, "0", "0^Select Value");
			} 
			else
			{
				comboValues2 = hisutil.getOptionValue(al, selectedVal, "0^Select Value");
			}
		} 
		catch (Exception e)
		{
			new HisException("billing", "BillConfigUTIL.getAddDefaultUnitCombo()", e.getMessage());
		}
		return comboValues2;
	}
}