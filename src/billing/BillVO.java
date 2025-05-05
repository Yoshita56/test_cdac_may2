package billing;

import hisglobal.transactionmgnt.HisDAO;

import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;

public class BillVO implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;




	public BillVO(String hospitalCode)  
	{
		//System.out.println("check if quey executed");
		WebRowSet wb=null;
		String tmp_ParamName="";
		String tmp_ParamValue="";
	//	String wardTypeVal="";
		String qry = billing.qryHandler_billing.getQuery(1,"select.billsetup.66");
		HisDAO hisDao = new HisDAO("Bill Config","BillSetupMstBO.selectQuery()");
		
		try 
		{
			int qryIndex = hisDao.setQuery(qry);
			hisDao.setQryValue(qryIndex, 1, hospitalCode);
			wb=hisDao.executeQry(qryIndex);
			//ValueObject[] arrVOs = {};
			//List<Entry> lstData = HelperMethodsDAO.getAlOfEntryObjects(wb);
			//for(Entry ent : lstData)
			//{
			//	if(ent.equals(obj))
			//}
			
			while(wb.next())
			{
				tmp_ParamName=wb.getString(1);
				tmp_ParamValue=wb.getString(2);
				if(tmp_ParamName.equals("FINANCIAL_START_YEAR"))
					this.setFinStartYear(tmp_ParamValue);
				else if(tmp_ParamName.equals("INBOUND_PURGED_DAY"))
					this.setInBound(tmp_ParamValue);
				else if(tmp_ParamName.equals("OUTBOUND_PURGED_DAY"))
					this.setOutBound(tmp_ParamValue);
				else if(tmp_ParamName.equals("CANCELLATION_TIME"))
					this.setGeneralCancellationTime(tmp_ParamValue);
				else if(tmp_ParamName.equals("DUPLICATE_PRINT_CHARGE"))
					this.setGeneralDuplicatePrintCharge(tmp_ParamValue);
				else if(tmp_ParamName.equals("RECORDS_DISPLAY_MASTER"))
					this.setGeneralRecordsDisplayMaster(tmp_ParamValue);
				else if(tmp_ParamName.equals("LEVEL_MODIFY_MASTER"))
					this.setGeneralLevelModifyMaster(tmp_ParamValue);
				else if(tmp_ParamName.equals("LEVEL_DELETE_MASTER"))
					this.setGeneralLevelDeleteMaster(tmp_ParamValue);
				else if(tmp_ParamName.equals("RECEIPT_TYPE"))
					this.setGeneralReceiptType(tmp_ParamValue);
				else if(tmp_ParamName.equals("DUPLICATE_PRINT"))
				{
					this.setGeneralDuplicatePrint(tmp_ParamValue);
					//System.out.println("tmp_ParamValue"+tmp_ParamValue);
				}
				else if(tmp_ParamName.equals("IS_WITHOUT_CRNO_REQUIRED"))
					this.setGeneralIsWithoutCrNoRequired(tmp_ParamValue);
				else if(tmp_ParamName.equals("ONLINE_REFUND_REQUEST_ALLOWED"))
					this.setGeneralOnlineRefundRequestAllowed(tmp_ParamValue);
				else if(tmp_ParamName.equals("IS_REFERRING_PHYSICIAN_REQUIRED_INT"))
					this.setGeneralReferringPhysicianRequiredInt(tmp_ParamValue);
				else if(tmp_ParamName.equals("IS_REFERRING_PHYSICIAN_REQUIRED_EXT"))
					this.setGeneralReferringPhysicianRequiredExt(tmp_ParamValue);
				else if(tmp_ParamName.equals("IS_PREVIOUS_CRNO_REQUIRED_INT"))
					this.setGeneralPreviousCrNoRequiredInt(tmp_ParamValue);
				else if(tmp_ParamName.equals("IS_PREVIOUS_CRNO_REQUIRED_EXT"))
					this.setGeneralPreviousCrNoRequiredExt(tmp_ParamValue);
				else if(tmp_ParamName.equals("CC_CONFERMATION_TYPE"))
					this.setGeneralCashCollectionConfrimType(tmp_ParamValue);
				else if(tmp_ParamName.equals("IS_PREV_CRNO_SEARCHING_REQ_INT"))
					this.setGeneralPreviousCrNoSearchingInt(tmp_ParamValue);
				else if(tmp_ParamName.equals("IS_PREV_CRNO_SEARCHING_REQ_EXT"))
					this.setGeneralPreviousCrNoSearchingExt(tmp_ParamValue);
				else if(tmp_ParamName.equals("CHARGE_TYPE_EXT"))
					this.setGeneralChargeTypeExt(tmp_ParamValue);
				else if(tmp_ParamName.equals("WARD_TYPE_EXT"))
					this.setGeneralWardTypeExt(tmp_ParamValue);
				else if(tmp_ParamName.equals("CHARGE_TYPE_INT"))
					this.setGeneralChargeTypeInt(tmp_ParamValue);
				else if(tmp_ParamName.equals("WARD_TYPE_INT"))
					this.setGeneralWardTypeInt(tmp_ParamValue);
				else if(tmp_ParamName.equals("DAY_END_BILLING_PROCESS_TYPE"))
					this.setGeneralDayEndProcessType(tmp_ParamValue);
				else if(tmp_ParamName.equals("DAY_END_BILLING_DATE_TYPE"))
					this.setGeneralDayEndDateType(tmp_ParamValue);
				else if(tmp_ParamName.equals("DAY_END_NON_BILLING_PROCESS_TYPE"))
					this.setGeneralDayEndNonBillingProcessType(tmp_ParamValue);
				else if(tmp_ParamName.equals("DAY_END_NON_BILLING_DATE_TYPE"))
					this.setGeneralDayEndNonBillingDateType(tmp_ParamValue);
				else if(tmp_ParamName.equals("OPD_RECEIPT_TYPE"))
					this.setGeneralOpdReceiptType(tmp_ParamValue);
				else if(tmp_ParamName.equals("IPD_RECEIPT_TYPE"))
					this.setGeneralIpdReceiptType(tmp_ParamValue);
				else if(tmp_ParamName.equals("CC_REFUND_REQUIRED"))
					this.setGeneralCCOfflineRefundRequired(tmp_ParamValue);
				else if(tmp_ParamName.equals("PRINT_MESSAGE_LIMIT"))
					this.setGeneralPrintMessageLimit(tmp_ParamValue);
				else if(tmp_ParamName.equals("REFUND_RECEIPT_TYPE"))
					this.setGeneralRefundReceiptType(tmp_ParamValue);
				else if(tmp_ParamName.equals("REFUND_AGAINST_REFUND_REQUEST"))
					this.setGeneralRefundAgainstRefundRequest(tmp_ParamValue);
				else if(tmp_ParamName.equals("INTERNAL_PATIENT"))
					this.setGeneralInternalPatient(tmp_ParamValue);
				else if(tmp_ParamName.equals("EXTERNAL_PATIENT"))
					this.setGeneralExternalPatient(tmp_ParamValue);
				else if(tmp_ParamName.equals("IS_APPROVAL_BY_REQUIRED"))
					this.setGeneralIsApprovalRequired(tmp_ParamValue);
				else if(tmp_ParamName.equals("DEFAULT_TARIFF_CODE"))
					this.setStrDefaultTariffCode(tmp_ParamValue);
				else if(tmp_ParamName.equals("CONSUMABLE_CHARGES_GROUP"))
					this.setStrConsumableChargesGroupId(tmp_ParamValue);
				else if(tmp_ParamName.equals("CONSUMABLE_CHARGES_TARIFF"))
					this.setStrConsumableChargesTariffCode(tmp_ParamValue);
				else if(tmp_ParamName.equals("OPD_THIRD_PARY_BILLING"))
					this.setOpdThirdPartyBilling(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCOUNT"))
					this.setOpdDiscount(tmp_ParamValue);
				else if(tmp_ParamName.equals("OPD_DISCOUNT_CLERK"))
					this.setOpdDiscountClerk(tmp_ParamValue);
				else if(tmp_ParamName.equals("REFUND_PENALTY"))
					this.setOpdRefundPenalty(tmp_ParamValue);
				else if(tmp_ParamName.equals("OPD_ROUND_OFF"))
					this.setOpdRoundOff(tmp_ParamValue);
				else if(tmp_ParamName.equals("OPD_SERVICE_TAX"))
					this.setOpdServiceTax(tmp_ParamValue);
				else if(tmp_ParamName.equals("OPD_FREE_CATEGORY"))
					this.setOpdFreeCategory(tmp_ParamValue);
				else if(tmp_ParamName.equals("HEADER1"))
					this.setBillFormatHeader1(tmp_ParamValue);
				else if(tmp_ParamName.equals("HEADER2"))
					this.setBillFormatHeader2(tmp_ParamValue);
				else if(tmp_ParamName.equals("HEADER3"))
					this.setBillFormatHeader3(tmp_ParamValue);
				else if(tmp_ParamName.equals("HEADER4"))
					this.setBillFormatHeader4(tmp_ParamValue);
				else if(tmp_ParamName.equals("FOOTER"))
					this.setBillFormatFooter(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCLAIMER_WITHOUT_CRNO"))
					this.setBillDisclaimerWithoutCrNo(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCLAIMER_SERVICES"))
					this.setBillDisclaimerServices(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCLAIMER_REFUND"))
					this.setBillDisclaimerRefund(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCLAIMER_ADVANCE"))
					this.setBillDisclaimerAdvance(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCLAIMER_PART_PAYMENT"))
					this.setBillDisclaimerPartPayment(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCLAIMER_FINAL_BILL"))
					this.setBillDisclaimerFinalBill(tmp_ParamValue);
				else if(tmp_ParamName.equals("DUPLICATE_PRINT_REQ"))
					this.setBillDisclaimerDuplicatePrintRequired(tmp_ParamValue);
				else if(tmp_ParamName.equals("BILL_LINE_OPD_SERVICES"))
					this.setBillLineOpdServices(tmp_ParamValue);
				else if(tmp_ParamName.equals("IPD_THIRD_PARY_BILLING"))
				{
					//System.out.println(""+tmp_ParamName);
					this.setIpdThirdPartyBilling(tmp_ParamValue);
				}
				else if(tmp_ParamName.equals("DISCOUNT"))
					this.setIpdDiscount(tmp_ParamValue);
				else if(tmp_ParamName.equals("IPD_DISCOUNT_CLERK"))
					this.setIpdDiscountClerk(tmp_ParamValue);
				else if(tmp_ParamName.equals("REFUND_PENALTY"))
					this.setIpdRefundPenalty(tmp_ParamValue);
				else if(tmp_ParamName.equals("CREDIT_BILLING"))
					this.setIpdCreaditBilling(tmp_ParamValue);
				else if(tmp_ParamName.equals("PART_PAYMENT_DURATION"))
					this.setIpdPartPaymentDuration(tmp_ParamValue);
				else if(tmp_ParamName.equals("IPD_ROUND_OFF"))
					this.setIpdRoundOff(tmp_ParamValue);
				else if(tmp_ParamName.equals("SERVICE_TAX_ON_TOTAL_BILL"))
					this.setIpdServiceTaxOnTotalBill(tmp_ParamValue);
				else if(tmp_ParamName.equals("EXCESS_CREDIT_LIMIT"))
					this.setIpdExcessCreditLimit(tmp_ParamValue);
				else if(tmp_ParamName.equals("IPD_GEN_ADT_PROCESS_TYPE"))
					this.setIpdGenAdtProcessType(tmp_ParamValue);
				else if(tmp_ParamName.equals("IPD_RE_OPEN_VALIDITY_DAYS"))
					this.setIpdGenReOpenValidity(tmp_ParamValue);
				else if(tmp_ParamName.equals("IPD_SERVICE_TAX"))
					this.setIpdServiceTax(tmp_ParamValue);
				else if(tmp_ParamName.equals("CHECK_OUT_TIME_GENERAL"))
				{
					String[] strTmp=tmp_ParamValue.replace(':', '#').split("#");
					this.setIpdGenCheckOutTimeHr(strTmp[0]);
					this.setIpdGenCheckOutTimeMn(strTmp[1]);					
				}
				else if(tmp_ParamName.equals("CHECK_OUT_TIME_PRIVATE"))
				{
					String[] strTmp=tmp_ParamValue.replace(':', '#').split("#");
					this.setIpdGenCheckOutTimePrivateHr(strTmp[0]);
					this.setIpdGenCheckOutTimePrivateMn(strTmp[1]);					
				}
				else if(tmp_ParamName.equals("FLEXIBLE_TIME"))
					this.setIpdGenFlexibleTime(tmp_ParamValue);
				else if(tmp_ParamName.equals("CHECK_IN_FLEXIBILITY"))
					this.setIpdGenFlexibleTimeAdmission(tmp_ParamValue);
				else if(tmp_ParamName.equals("GENERAL_ROOM_TYPE_ID"))
					this.setStrGeneralRoomType(tmp_ParamValue);
				else if(tmp_ParamName.equals("GENERAL_WARD_TYPE_ID"))
					this.setStrGeneralWardType(tmp_ParamValue);
				else if(tmp_ParamName.equals("EMG_FREECHARGE_HOUR"))
					this.setIpdGenServiceFreeTreatmentTime(tmp_ParamValue);
				else if(tmp_ParamName.equals("IPD_FREE_CATEGORY"))
					this.setIpdFreeCategory(tmp_ParamValue);
				else if(tmp_ParamName.equals("IS_ADVANCE_REQUIRED"))
					this.setIpdGenAdvanceReq(tmp_ParamValue);
				else if(tmp_ParamName.equals("EMG_THIRD_PARY_BILLING"))
					this.setEmergencyThirdPartyBilling(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCOUNT"))
					this.setEmergencyDiscount(tmp_ParamValue);
				else if(tmp_ParamName.equals("EMG_DISCOUNT_CLERK"))
					this.setEmergencyDiscountClerk(tmp_ParamValue);
				else if(tmp_ParamName.equals("REFUND_PENALTY"))
					this.setEmergencyRefundPenalty(tmp_ParamValue);
				else if(tmp_ParamName.equals("EMG_ROUND_OFF"))
					this.setEmergencyRoundOff(tmp_ParamValue);
				else if(tmp_ParamName.equals("EMG_SERVICE_TAX"))
					this.setEmergencyServiceTax(tmp_ParamValue);
				else if(tmp_ParamName.equals("EMG_FREE_CATEGORY"))
					this.setEmergencyFreeCategory(tmp_ParamValue);
				else if(tmp_ParamName.equals("CREDIT_BILL_APP_REQUIRED"))
					this.setStrCreditCashlessAppRequired(tmp_ParamValue);
				else if(tmp_ParamName.equals("PAID_CAT"))
					this.setStrPaidCategory(tmp_ParamValue);	
				else if(tmp_ParamName.equals("AROGYASHREE_CAT"))
					this.setStrArogyaShreeCategory(tmp_ParamValue);	
				else if(tmp_ParamName.equals("GEN_CREDIT_CAT"))
					this.setStrGenCategory(tmp_ParamValue);
				else if(tmp_ParamName.equals("CGSH_CAT"))
					this.setStrCGSHCategory(tmp_ParamValue);	
				else if(tmp_ParamName.equals("WSH_CAT"))
					this.setStrWSHCategory(tmp_ParamValue);
				else if(tmp_ParamName.equals("DAY_END_TIME_BOUND_FLAG"))
					this.setStrDayEndTimeBoundFlag(tmp_ParamValue);
				else if(tmp_ParamName.equals("DAY_END_TIME"))
					this.setStrDayEndTime(tmp_ParamValue);
				else if(tmp_ParamName.equals("AROGYASHREE_TS_CAT"))
					this.setStrArogyaShreeTSCategory(tmp_ParamValue);
				else if(tmp_ParamName.equals("AROGYASHREE_TS_OPD_CREDIT_LIMIT"))
					this.setStrArogyaTSCreditLimit(tmp_ParamValue);	
				else if(tmp_ParamName.equals("URGENT_TARIFF_SURCHARGE"))
					this.setStrUrgTrfSur(tmp_ParamValue);
				else if(tmp_ParamName.equals("LOGO_REQ"))
					this.setLogoReq(tmp_ParamValue);
				else if(tmp_ParamName.equals("HINDI_HEAD_REQ"))
					this.setHindiReq(tmp_ParamValue);
				else if(tmp_ParamName.equals("HEAD_REQ"))
					this.setHeaderReq(tmp_ParamValue);
				else if(tmp_ParamName.equals("SURCHARGE_Ccu%"))
					this.setStrSurCc(tmp_ParamValue);
				else if(tmp_ParamName.equals("SURCHARGE_Dcu%"))
					this.setStrSurDc(tmp_ParamValue);
				else if(tmp_ParamName.equals("SURCHARGE_Icu%"))
					this.setStrSurIc(tmp_ParamValue);
				else if(tmp_ParamName.equals("SURCHARGE_Idu%"))
					this.setStrSurId(tmp_ParamValue);
				else if(tmp_ParamName.equals("SURCHARGE_Cca%"))
					this.setStrSurCc1(tmp_ParamValue);
				else if(tmp_ParamName.equals("SURCHARGE_Dca%"))
					this.setStrSurDc1(tmp_ParamValue);
				else if(tmp_ParamName.equals("SURCHARGE_Ica%"))
					this.setStrSurIc1(tmp_ParamValue);
				else if(tmp_ParamName.equals("SURCHARGE_Ida%"))
					this.setStrSurId1(tmp_ParamValue);
				else if(tmp_ParamName.equals("DAY_END_NEGATIVE_ALLOWED"))
					this.setStrNegativeDayEndAllowed(tmp_ParamValue);
				else if(tmp_ParamName.equals("DAY_END_DENOMINATION_ALLOWED"))
					this.setStrDenominationAllowed(tmp_ParamValue);
			}
			wb.beforeFirst();
			while(wb.next())
			{
				tmp_ParamName=wb.getString(1);
				tmp_ParamValue=wb.getString(2);
				if(tmp_ParamName.equals("FINANCIAL_START_YEAR"))
					this.finStartYear=(tmp_ParamValue);
				else if(tmp_ParamName.equals("INBOUND_PURGED_DAY"))
					this.inBound=(tmp_ParamValue);
				else if(tmp_ParamName.equals("OUTBOUND_PURGED_DAY"))
					this.outBound=(tmp_ParamValue);
				else if(tmp_ParamName.equals("CANCELLATION_TIME"))
					this.generalCancellationTime=(tmp_ParamValue);
				else if(tmp_ParamName.equals("DUPLICATE_PRINT_CHARGE"))
					this.generalDuplicatePrintCharge=(tmp_ParamValue);
				else if(tmp_ParamName.equals("RECORDS_DISPLAY_MASTER"))
					this.generalRecordsDisplayMaster=(tmp_ParamValue);
				else if(tmp_ParamName.equals("LEVEL_MODIFY_MASTER"))
					this.generalLevelModifyMaster=(tmp_ParamValue);
				else if(tmp_ParamName.equals("LEVEL_DELETE_MASTER"))
					this.generalLevelDeleteMaster=(tmp_ParamValue);
				else if(tmp_ParamName.equals("RECEIPT_TYPE"))
					this.generalReceiptType=(tmp_ParamValue);
				else if(tmp_ParamName.equals("DUPLICATE_PRINT"))
					this.generalDuplicatePrint=(tmp_ParamValue);
				else if(tmp_ParamName.equals("IS_WITHOUT_CRNO_REQUIRED"))
					this.generalIsWithoutCrNoRequired=(tmp_ParamValue);
				else if(tmp_ParamName.equals("ONLINE_REFUND_REQUEST_ALLOWED"))
					this.generalOnlineRefundRequestAllowed=(tmp_ParamValue);
				else if(tmp_ParamName.equals("IS_REFERRING_PHYSICIAN_REQUIRED_INT"))
					this.generalReferringPhysicianRequiredInt=(tmp_ParamValue);
				else if(tmp_ParamName.equals("IS_REFERRING_PHYSICIAN_REQUIRED_EXT"))
					this.generalReferringPhysicianRequiredExt=(tmp_ParamValue);
				else if(tmp_ParamName.equals("IS_PREVIOUS_CRNO_REQUIRED_INT"))
					this.generalPreviousCrNoRequiredInt=(tmp_ParamValue);
				else if(tmp_ParamName.equals("IS_PREVIOUS_CRNO_REQUIRED_EXT"))
					this.generalPreviousCrNoRequiredExt=(tmp_ParamValue);
				else if(tmp_ParamName.equals("CC_CONFERMATION_TYPE"))
					this.generalCashCollectionConfrimType=(tmp_ParamValue);
				else if(tmp_ParamName.equals("IS_PREV_CRNO_SEARCHING_REQ_INT"))
					this.generalPreviousCrNoSearchingInt=(tmp_ParamValue);
				else if(tmp_ParamName.equals("IS_PREV_CRNO_SEARCHING_REQ_EXT"))
					this.generalPreviousCrNoSearchingExt=(tmp_ParamValue);
				else if(tmp_ParamName.equals("CHARGE_TYPE_EXT"))
					this.generalChargeTypeExt=(tmp_ParamValue);
				else if(tmp_ParamName.equals("WARD_TYPE_EXT"))
					this.generalWardTypeExt=(tmp_ParamValue);
				else if(tmp_ParamName.equals("CHARGE_TYPE_INT"))
					this.generalChargeTypeInt=(tmp_ParamValue);
				else if(tmp_ParamName.equals("WARD_TYPE_INT"))
					this.generalWardTypeInt=(tmp_ParamValue);
				else if(tmp_ParamName.equals("DAY_END_BILLING_PROCESS_TYPE"))
					this.generalDayEndProcessType=(tmp_ParamValue);
				else if(tmp_ParamName.equals("DAY_END_BILLING_DATE_TYPE"))
					this.generalDayEndDateType=(tmp_ParamValue);
				else if(tmp_ParamName.equals("DAY_END_NON_BILLING_PROCESS_TYPE"))
					this.generalDayEndNonBillingProcessType=(tmp_ParamValue);
				else if(tmp_ParamName.equals("DAY_END_NON_BILLING_DATE_TYPE"))
					this.generalDayEndNonBillingDateType=(tmp_ParamValue);
				else if(tmp_ParamName.equals("OPD_RECEIPT_TYPE"))
					this.generalOpdReceiptType=(tmp_ParamValue);
				else if(tmp_ParamName.equals("IPD_RECEIPT_TYPE"))
					this.generalIpdReceiptType=(tmp_ParamValue);
				else if(tmp_ParamName.equals("CC_REFUND_REQUIRED"))
					this.generalCCOfflineRefundRequired=(tmp_ParamValue);
				else if(tmp_ParamName.equals("PRINT_MESSAGE_LIMIT"))
					this.generalPrintMessageLimit=(tmp_ParamValue);
				else if(tmp_ParamName.equals("REFUND_RECEIPT_TYPE"))
					this.generalRefundReceiptType=(tmp_ParamValue);
				else if(tmp_ParamName.equals("REFUND_AGAINST_REFUND_REQUEST"))
					this.generalRefundAgainstRefundRequest=(tmp_ParamValue);
				else if(tmp_ParamName.equals("INTERNAL_PATIENT"))
					this.generalInternalPatient=(tmp_ParamValue);
				else if(tmp_ParamName.equals("EXTERNAL_PATIENT"))
					this.generalExternalPatient=(tmp_ParamValue);
				else if(tmp_ParamName.equals("IS_APPROVAL_BY_REQUIRED"))
					this.generalIsApprovalRequired=(tmp_ParamValue);
				else if(tmp_ParamName.equals("DEFAULT_TARIFF_CODE"))
					this.strDefaultTariffCode=(tmp_ParamValue);
				else if(tmp_ParamName.equals("OPD_THIRD_PARY_BILLING"))
					this.opdThirdPartyBilling=(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCOUNT"))
					this.opdDiscount=(tmp_ParamValue);
				else if(tmp_ParamName.equals("OPD_DISCOUNT_CLERK"))
					this.opdDiscountClerk=(tmp_ParamValue);
				else if(tmp_ParamName.equals("REFUND_PENALTY"))
					this.opdRefundPenalty=(tmp_ParamValue);
				else if(tmp_ParamName.equals("OPD_ROUND_OFF"))
					this.opdRoundOff=(tmp_ParamValue);
				else if(tmp_ParamName.equals("OPD_SERVICE_TAX"))
					this.opdServiceTax=(tmp_ParamValue);
				else if(tmp_ParamName.equals("OPD_FREE_CATEGORY"))
					this.opdFreeCategory=(tmp_ParamValue);
				else if(tmp_ParamName.equals("HEADER1"))
					this.billFormatHeader1=(tmp_ParamValue);
				else if(tmp_ParamName.equals("HEADER2"))
					this.billFormatHeader2=(tmp_ParamValue);
				else if(tmp_ParamName.equals("HEADER3"))
					this.billFormatHeader3=(tmp_ParamValue);
				else if(tmp_ParamName.equals("HEADER4"))
					this.billFormatHeader4=(tmp_ParamValue);
				else if(tmp_ParamName.equals("FOOTER"))
					this.billFormatFooter=(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCLAIMER_WITHOUT_CRNO"))
					this.billDisclaimerWithoutCrNo=(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCLAIMER_SERVICES"))
					this.billDisclaimerServices=(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCLAIMER_REFUND"))
					this.billDisclaimerRefund=(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCLAIMER_ADVANCE"))
					this.billDisclaimerAdvance=(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCLAIMER_PART_PAYMENT"))
					this.billDisclaimerPartPayment=(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCLAIMER_FINAL_BILL"))
					this.billDisclaimerFinalBill=(tmp_ParamValue);
				else if(tmp_ParamName.equals("DUPLICATE_PRINT_REQ"))
					this.billDisclaimerDuplicatePrintRequired=(tmp_ParamValue);
				else if(tmp_ParamName.equals("BILL_LINE_OPD_SERVICES"))
					this.billLineOpdServices=(tmp_ParamValue);
				else if(tmp_ParamName.equals("IPD_THIRD_PARY_BILLING"))
				{
					//System.out.println("2"+tmp_ParamName);
					this.ipdThirdPartyBilling=(tmp_ParamValue);
				}
				else if(tmp_ParamName.equals("DISCOUNT"))
					this.ipdDiscount=(tmp_ParamValue);
				else if(tmp_ParamName.equals("IPD_DISCOUNT_CLERK"))
					this.ipdDiscountClerk=(tmp_ParamValue);
				else if(tmp_ParamName.equals("REFUND_PENALTY"))
					this.ipdRefundPenalty=(tmp_ParamValue);
				else if(tmp_ParamName.equals("CREDIT_BILLING"))
					this.ipdCreaditBilling=(tmp_ParamValue);
				else if(tmp_ParamName.equals("PART_PAYMENT_DURATION"))
					this.ipdPartPaymentDuration=(tmp_ParamValue);
				else if(tmp_ParamName.equals("IPD_ROUND_OFF"))
					this.ipdRoundOff=(tmp_ParamValue);
				else if(tmp_ParamName.equals("SERVICE_TAX_ON_TOTAL_BILL"))
					this.ipdServiceTaxOnTotalBill=(tmp_ParamValue);
				else if(tmp_ParamName.equals("EXCESS_CREDIT_LIMIT"))
					this.ipdExcessCreditLimit=(tmp_ParamValue);
				else if(tmp_ParamName.equals("IPD_GEN_ADT_PROCESS_TYPE"))
					this.ipdGenAdtProcessType=(tmp_ParamValue);
				else if(tmp_ParamName.equals("IPD_SERVICE_TAX"))
					this.ipdServiceTax=(tmp_ParamValue);
				else if(tmp_ParamName.equals("IPD_RE_OPEN_VALIDITY_DAYS"))
					this.ipdGenReOpenValidity=(tmp_ParamValue);
				else if(tmp_ParamName.equals("CHECK_OUT_TIME_GENERAL"))
				{
					String[] strTmp=tmp_ParamValue.replace(':', '#').split("#");
					this.ipdGenCheckOutTimeHr=(strTmp[0]);
					this.ipdGenCheckOutTimeMn=(strTmp[1]);					
				}
				else if(tmp_ParamName.equals("CHECK_OUT_TIME_PRIVATE"))
				{
					String[] strTmp=tmp_ParamValue.replace(':', '#').split("#");
					this.ipdGenCheckOutTimePrivateHr=(strTmp[0]);
					this.ipdGenCheckOutTimePrivateMn=(strTmp[1]);					
				}
				else if(tmp_ParamName.equals("FLEXIBLE_TIME"))
					this.ipdGenFlexibleTime=(tmp_ParamValue);
				else if(tmp_ParamName.equals("CHECK_IN_FLEXIBILITY"))
					this.ipdGenFlexibleTimeAdmission=(tmp_ParamValue);
				else if(tmp_ParamName.equals("GENERAL_ROOM_TYPE_ID"))
					this.strGeneralRoomType=(tmp_ParamValue);
				else if(tmp_ParamName.equals("GENERAL_WARD_TYPE_ID"))
					this.strGeneralWardType=(tmp_ParamValue);
				else if(tmp_ParamName.equals("EMG_FREECHARGE_HOUR"))
					this.ipdGenServiceFreeTreatmentTime=(tmp_ParamValue);
				else if(tmp_ParamName.equals("IPD_FREE_CATEGORY"))
					this.ipdFreeCategory=(tmp_ParamValue);
				else if(tmp_ParamName.equals("IS_ADVANCE_REQUIRED"))
					this.ipdGenAdvanceReq=(tmp_ParamValue);
				else if(tmp_ParamName.equals("EMG_THIRD_PARY_BILLING"))
					this.emergencyThirdPartyBilling=(tmp_ParamValue);
				else if(tmp_ParamName.equals("DISCOUNT"))
					this.emergencyDiscount=(tmp_ParamValue);
				else if(tmp_ParamName.equals("EMG_DISCOUNT_CLERK"))
					this.emergencyDiscountClerk=(tmp_ParamValue);
				else if(tmp_ParamName.equals("REFUND_PENALTY"))
					this.emergencyRefundPenalty=(tmp_ParamValue);
				else if(tmp_ParamName.equals("EMG_ROUND_OFF"))
					this.emergencyRoundOff=(tmp_ParamValue);
				else if(tmp_ParamName.equals("EMG_SERVICE_TAX"))
					this.emergencyServiceTax=(tmp_ParamValue);
				else if(tmp_ParamName.equals("EMG_FREE_CATEGORY"))
					this.emergencyFreeCategory=(tmp_ParamValue);
				else if(tmp_ParamName.equals("CREDIT_BILL_APP_REQUIRED"))
					this.setStrCreditCashlessAppRequired(tmp_ParamValue);
				else if(tmp_ParamName.equals("PAID_CAT"))
					this.setStrPaidCategory(tmp_ParamValue);	
				else if(tmp_ParamName.equals("AROGYASHREE_CAT"))
					this.setStrArogyaShreeCategory(tmp_ParamValue);	
				else if(tmp_ParamName.equals("GEN_CREDIT_CAT"))
					this.setStrGenCategory(tmp_ParamValue);
				else if(tmp_ParamName.equals("CGSH_CAT"))
					this.setStrCGSHCategory(tmp_ParamValue);	
				else if(tmp_ParamName.equals("WSH_CAT"))
					this.setStrWSHCategory(tmp_ParamValue);
				else if(tmp_ParamName.equals("DAY_END_TIME_BOUND_FLAG"))
					this.setStrDayEndTimeBoundFlag(tmp_ParamValue);
				else if(tmp_ParamName.equals("DAY_END_TIME"))
					this.setStrDayEndTime(tmp_ParamValue);	
				else if(tmp_ParamName.equals("AROGYASHREE_TS_CAT"))
					this.setStrArogyaShreeTSCategory(tmp_ParamValue);	
				else if(tmp_ParamName.equals("URGENT_TARIFF_SURCHARGE"))
					this.setStrUrgTrfSur(tmp_ParamValue);
				else if(tmp_ParamName.equals("LOGO_REQ"))
					this.setLogoReq(tmp_ParamValue);
				else if(tmp_ParamName.equals("HINDI_HEAD_REQ"))
					this.setHindiReq(tmp_ParamValue);
				else if(tmp_ParamName.equals("HEAD_REQ"))
					this.setHeaderReq(tmp_ParamValue);
				else if(tmp_ParamName.equals("AROGYASHREE_TS_IPD_CREDIT_LIMIT"))
					this.setStrArogyaIpdCreditLimit(tmp_ParamValue);
				else if(tmp_ParamName.equals("SURCHARGE_Ccu%"))
					this.setStrSurCc(tmp_ParamValue);
				else if(tmp_ParamName.equals("SURCHARGE_Dcu%"))
					this.setStrSurDc(tmp_ParamValue);
				else if(tmp_ParamName.equals("SURCHARGE_Icu%"))
					this.setStrSurIc(tmp_ParamValue);
				else if(tmp_ParamName.equals("SURCHARGE_Idu%"))
					this.setStrSurId(tmp_ParamValue);
				else if(tmp_ParamName.equals("SURCHARGE_Cca%"))
					this.setStrSurCc1(tmp_ParamValue);
				else if(tmp_ParamName.equals("SURCHARGE_Dca%"))
					this.setStrSurDc1(tmp_ParamValue);
				else if(tmp_ParamName.equals("SURCHARGE_Ica%"))
					this.setStrSurIc1(tmp_ParamValue);
				else if(tmp_ParamName.equals("SURCHARGE_Ida%"))
					this.setStrSurId1(tmp_ParamValue);
				else if(tmp_ParamName.equals("DAY_END_NEGATIVE_ALLOWED"))
					this.setStrNegativeDayEndAllowed(tmp_ParamValue);
				else if(tmp_ParamName.equals("DAY_END_DENOMINATION_ALLOWED"))
					this.setStrDenominationAllowed(tmp_ParamValue);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();		
		}
		finally
		{
			try {
				if (wb != null) {
					wb.close();
					wb=null;
				}
				if (hisDao != null) {
					hisDao.free();
					hisDao = null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
				
	}
// change from bala
	public static final String BILL_MODULE_ID = "17";	
	public static final String NORMAL_CATEGORY = "11";
	public static final String DEFAULT_HOSPITAL_SERVICE = "1";	
	public static final String DEFAULT_UNIT_ID  = "1701";	
	public static final String GROUP_ID_DEPOSIT = "100";	
	public static final String SUPER_HOSPITAL_CODE = "100";	
	public static final String GROUP_ID_GENERAL_CHARGES = "122";	//133 replaced by 123 by Adil Wasi to bring data in Tariff combo of bill setup
	public static final String DIET_CHARGE_ID = "1330003";
	
	//public static final String BILLING_RPT_NAME = "PGI CHANDIGARH";
	
	/*      Final Variable For Billing Report     */
	
	/*public static final String NOOFLINE_OPD_SERVICES     = "70";
	
	public static final String NOOFLINE_IPD_SERVICES     = "70";
	
	public static final String NOOFLINE_ADVANCE          = "70";
	
	public static final String NOOFLINE_PART_PAYMENT     = "70";
	
	public static final String NOOFLINE_FINAL_ADJUSTMENT = "70";
	
	public static final String NOOFLINE_ADVANCE_REFUND     = "70";
	
	public static final String NOOFLINE_OPD_REFUND     = "70";
	
	public static final String NOOFLINE_IPD_REFUND     = "70";
	
	public static final String NOOFLINE_OPD_RECONCILIATION    = "70";
	
	public static final String NOOFLINE_IPD_RECONCILIATION     = "70";
	
	public static final String NOOFLINE_IPD_FINAL_SETTLEMENT = "70";*/
	
	/*                     END                   */
//	private static final String pathFileName = "hisglobal.hisconfig.hisPath";
	
	/*private String path = null;

	private JAXBElement<SetupType> jaxB = this.readXMLDataObject();

	private SetupType sType = (SetupType) jaxB.getValue();
	
	private GeneralType general = (GeneralType) sType.getGeneral();
	
	private IpdType ipd = (IpdType) sType.getIpd();
	
	private OpdType opd = (OpdType) sType.getOpd();
	
	private EmergencyType emergency = (EmergencyType) sType.getEmergency();
	
	private BillFormatType billFormat = (BillFormatType) sType.getBillformat(); */
	
	
	
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
	private String strConsumableChargesGroupId="";		// added by Adil Wasi
	private String strConsumableChargesTariffCode=""; 	// added by Adil Wasi
	
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
	private String ipdGenReOpenValidity = "0";   // Added By Pawan Kumar B N on 7-03-2012
	
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
	private String strArogyaTSCreditLimit="";
	private String strUrgTrfSur="";
	private String logoReq="";
	private String hindiReq="";
	private String headerReq="";
	private String strSurCc="";
	private String strSurDc="";
	private String strSurIc="";
	private String strSurId="";
	private String strSurCc1="";
	private String strSurDc1="";
	private String strSurIc1="";
	private String strArogyaIpdCreditLimit = "";
	private String strSurId1="";
	private String strNegativeDayEndAllowed="0";
	private String strDenominationAllowed="1";
	private String reqModiCat="";

	
	

/*	public String getBillLineOpdServices() {
		
		billLineOpdServices = billFormat.getBillLineOpdServices();
		
		return billLineOpdServices;
	}

 

	public String getBillFormatHeader1() {
		
		billFormatHeader1 = billFormat.getHeader1();
		
		return billFormatHeader1;
	}

   public String getBillDisclaimerWithoutCrNo() {
	   
	   billDisclaimerWithoutCrNo = billFormat.getDisclaimerWithoutCrNo();
	   
		return billDisclaimerWithoutCrNo;
	}

	public String getBillDisclaimerServices() {
		
		billDisclaimerServices = billFormat.getDisclaimerServices();
		
		return billDisclaimerServices;
	}

	public String getBillDisclaimerRefund() {
		
		billDisclaimerRefund = billFormat.getDisclaimerRefund();
		
		return billDisclaimerRefund;
	}

	public String getBillDisclaimerAdvance() {
		
		billDisclaimerAdvance = billFormat.getDisclaimerAdvance();
		
		return billDisclaimerAdvance;
	}

	public String getBillDisclaimerPartPayment() {
		
		billDisclaimerPartPayment = billFormat.getDisclaimerPartPayment();
		
		return billDisclaimerPartPayment;
	}

	public String getBillDisclaimerFinalBill() {
		
		billDisclaimerFinalBill = billFormat.getDisclaimerFinalBill();
		
		return billDisclaimerFinalBill;
	}

	public String getBillDisclaimerDuplicatePrintRequired() {
		
		billDisclaimerDuplicatePrintRequired = billFormat.getDuplicatePrintReq();
		
		return billDisclaimerDuplicatePrintRequired;
	}

	

	public String getGeneralDayEndProcessType() {
		
		generalDayEndProcessType = general.getDayEndBillingProcessType();
		
		return generalDayEndProcessType;
	}

	public String getGeneralDayEndDateType() {
		
		generalDayEndDateType = general.getDayEndBillingDateType();
		
		return generalDayEndDateType;
	}

	public String getGeneralDayEndNonBillingProcessType() {
		
		generalDayEndNonBillingProcessType = general.getDayEndNonBillingProcessType();
		
		return generalDayEndNonBillingProcessType;
	}

	public String getGeneralDayEndNonBillingDateType() {
		
		generalDayEndNonBillingDateType = general.getDayEndNonBillingDateType();
		
		return generalDayEndNonBillingDateType;
	}

	public String getGeneralOpdReceiptType() {
		
		generalOpdReceiptType = general.getOpdReceiptType();
		
		return generalOpdReceiptType;
	}

	public String getGeneralIpdReceiptType() {
		
		generalIpdReceiptType = general.getIpdReceiptType();
		
		return generalIpdReceiptType;
	}

public String getBillFormatHeader2() {
		
		billFormatHeader2 = billFormat.getHeader2();
		
		return billFormatHeader2;
	}
   public String getBillFormatHeader3() {
	
	billFormatHeader3 = billFormat.getHeader3();
	
	return billFormatHeader3;
   }
   public String getBillFormatHeader4() {
	
	billFormatHeader4 = billFormat.getHeader4();
	
	return billFormatHeader4;
   }

	public String getBillFormatFooter() {
		
		billFormatFooter = billFormat.getFooter();
		
		return billFormatFooter;
	}
*/
	
	
	
 	
	/*  
	public String getEmergencyFreeCategory() {

		emergencyFreeCategory = emergency.getEmgFreeCategory();
		
		return emergencyFreeCategory;
	}
	
	public String getEmergencyThirdPartyBilling() {
		
		emergencyThirdPartyBilling = emergency.getThirdPartyBilling();
			
		return emergencyThirdPartyBilling;
	}

	public String getEmergencyDiscount() {
		
		emergencyDiscount = emergency.getDiscount();
		
		return emergencyDiscount;
	}

	public String getEmergencyDiscountClerk() {
		
		emergencyDiscountClerk = emergency.getDiscountClerk();
		
		return emergencyDiscountClerk;
	}

	public String getEmergencyRefundPenalty() {
		
		emergencyRefundPenalty = emergency.getRefundPenalty();
		
		return emergencyRefundPenalty;
	}

	public String getEmergencyRoundOff() {
		
		emergencyRoundOff = emergency.getRoundOff();
		
		return emergencyRoundOff;
	}

	*/
	
/*	
	public String getGeneralIsApprovalRequired() {
		
		generalIsApprovalRequired = general.getIsApprovalByRequired();
		
		return generalIsApprovalRequired;
	}



	public String getGeneralRefundAgainstRefundRequest() {
		
		generalRefundAgainstRefundRequest = general.getRefundAgainstRefundRequest();
		
		return generalRefundAgainstRefundRequest;
	}

	public String getGeneralPrintMessageLimit() {
		
		generalPrintMessageLimit = general.getPrintMessageLimit();
		
		return generalPrintMessageLimit;
	}

	public String getGeneralCCOfflineRefundRequired() {
		
		generalCCOfflineRefundRequired = general.getCcRefundRequired();
		
		return generalCCOfflineRefundRequired;
	}

	public String getGeneralCashCollectionConfrimType() {
		
		generalCashCollectionConfrimType = general.getCcConfermationType();
		
		return generalCashCollectionConfrimType;
	}



	


	public String getGeneralOnlineRefundRequestAllowed() {
		
		generalOnlineRefundRequestAllowed = general.getOnlineRefundRequestAllowed();
		
		return generalOnlineRefundRequestAllowed;
	}



	public String getGeneralIsWithoutCrNoRequired() {
		
		generalIsWithoutCrNoRequired = general.getIsWithoutCrNoRequired();
		
		return generalIsWithoutCrNoRequired;
	}

	public String getGeneralReceiptType() {
		
		generalReceiptType = general.getReceiptType();
		
		return generalReceiptType;
	}

	public String getGeneralDuplicatePrint() {
		
		generalDuplicatePrint = general.getDuplicatePrint();
		
		return generalDuplicatePrint;
	}

	public String getGeneralCancellationTime() {
		
		generalCancellationTime = general.getCancellationTime();
			
		return generalCancellationTime;
	}

	public String getGeneralDuplicatePrintCharge() {
		
		generalDuplicatePrintCharge = general.getDuplicatePrintCharge();
		
		return generalDuplicatePrintCharge;
	}

 

	public String getGeneralRecordsDisplayMaster() {
		
		generalRecordsDisplayMaster = general.getRecordsDisplayMaster();
		
		return generalRecordsDisplayMaster;
	}

	public String getGeneralLevelModifyMaster() {
		
		generalLevelModifyMaster = general.getLevelModifyMaster();
		
		return generalLevelModifyMaster;
	}

	public String getGeneralLevelDeleteMaster() {
		
		generalLevelDeleteMaster = general.getLevelDeleteMaster();
		
		return generalLevelDeleteMaster;
	}

	 */
	
	
	 	
	/*  
	public String getIpdFreeCategory() {

		ipdFreeCategory = ipd.getIpdFreeCategory();
		
		return ipdFreeCategory;
	}



	public String getIpdGenAdtProcessType() {
		
		ipdGenAdtProcessType = ipd.getIpdGenAdtProcessType();
		
		return ipdGenAdtProcessType;
	}



	public String getIpdThirdPartyBilling() {
		
		ipdThirdPartyBilling = ipd.getThirdParyBilling();
		
		return ipdThirdPartyBilling;
	}

	public String getIpdDiscount() {
		
		ipdDiscount = ipd.getDiscount();
		
		return ipdDiscount;
	}

	public String getIpdDiscountClerk() {
		
		ipdDiscountClerk = ipd.getDiscountClerk();
			
		return ipdDiscountClerk;
	}

	public String getIpdRefundPenalty() {
		
		ipdRefundPenalty = ipd.getRefundPenalty();
		
		return ipdRefundPenalty;
	}

	public String getIpdCreaditBilling() {
		
		ipdCreaditBilling = ipd.getCreditBilling();
		
		return ipdCreaditBilling;
	}

	public String getIpdPartPaymentDuration() {
		
		ipdPartPaymentDuration = ipd.getPartPaymentDuration();
		
		return ipdPartPaymentDuration;
	}

	public String getIpdRoundOff() {
		
		ipdRoundOff = ipd.getRoundOff();
		
		return ipdRoundOff;
	}

	
	public String getIpdServiceTaxOnTotalBill() {
		
		ipdServiceTaxOnTotalBill = ipd.getServiceTaxOnTotalBill();
		
		return ipdServiceTaxOnTotalBill;
	}
	*/
	
	
	/*
	public String getOpdFreeCategory() {

		opdFreeCategory = opd.getOpdFreeCategory();
		
		return opdFreeCategory;
	}
	
	public String getEmergencyServiceTax() {
		
		emergencyServiceTax = emergency.getEmgServiceTax();
			
		return emergencyServiceTax;
	}



	public String getIpdServiceTax() {
			
		ipdServiceTax = ipd.getIpdServiceTax();
		
		return ipdServiceTax;
	}



	public String getOpdServiceTax() {
		
		opdServiceTax = opd.getOpdServiceTax();
		
		return opdServiceTax;
	}



	public String getOpdThirdPartyBilling() {
		
		opdThirdPartyBilling = opd.getThirdParyBilling();
		
		return opdThirdPartyBilling;
	}

	public String getOpdDiscount() {
		
		opdDiscount = opd.getDiscount();
		
		return opdDiscount;
	}

	public String getOpdDiscountClerk() {
		
		opdDiscountClerk = opd.getDiscountClerk();
		
		return opdDiscountClerk;
	}

	public String getOpdRefundPenalty() {
		
		opdRefundPenalty = opd.getRefundPenalty();
		
		return opdRefundPenalty;
	}

	public String getOpdRoundOff() {
		
		opdRoundOff = opd.getRoundOff();
		
		return opdRoundOff;
	}
	
	
	
	
	
	public String getPath() {

		path = HisUtil.getParameterFromHisPathXML("BILLING_CONFIG");

		return path;
	}
	
	
	@SuppressWarnings("unchecked")
	public JAXBElement<SetupType> readXMLDataObject() {

		JAXBElement<SetupType> jaxB = null;

		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance("billing.setup");

			Unmarshaller u = jc.createUnmarshaller();

			jaxB = (JAXBElement<SetupType>) u.unmarshal(new FileInputStream(this.getPath()));

		} catch (JAXBException e) {
			new HisException("Bill Setup", "BOBillSetup.readXMLDataObject()", e
					.getMessage());
		} catch (FileNotFoundException e) {
			new HisException("Bill Setup", "BOBillSetup.readXMLDataObject()", e
					.getMessage());
		}

		return jaxB;

	}

	public String getIpdExcessCreditLimit() {
		
		ipdExcessCreditLimit = ipd.getExcessCreditLimit();
		
		return ipdExcessCreditLimit;
	}

	public String getGeneralRefundReceiptType() {
		
		generalRefundReceiptType = general.getRefundReceiptType();
		
		return generalRefundReceiptType;
	}



	public String getGeneralReferringPhysicianRequiredInt() {
		
			
		generalReferringPhysicianRequiredInt= general.getIsReferringPhysicianRequiredInt();
		
		return generalReferringPhysicianRequiredInt;
	}



	public String getGeneralReferringPhysicianRequiredExt() {
		
		generalReferringPhysicianRequiredExt= general.getIsReferringPhysicianRequiredExt();
		
		return generalReferringPhysicianRequiredExt;
	}



	public String getGeneralPreviousCrNoRequiredInt() {
		
		generalPreviousCrNoRequiredInt= general.getIsPreviousCrNoRequiredInt();
		
		return generalPreviousCrNoRequiredInt;
	}



	public String getGeneralPreviousCrNoRequiredExt() {
		
		generalPreviousCrNoRequiredExt= general.getIsPreviousCrNoRequiredExt();
		
		return generalPreviousCrNoRequiredExt;
	}



	public String getGeneralPreviousCrNoSearchingInt() {
		
		generalPreviousCrNoSearchingInt = general.getIsPrevCrNoSearchingReqInt();
			
		return generalPreviousCrNoSearchingInt;
	}



	public String getGeneralPreviousCrNoSearchingExt() {
		
		generalPreviousCrNoSearchingExt = general.getIsPrevCrNoSearchingReqExt();
		
		return generalPreviousCrNoSearchingExt;
	}



	public String getGeneralChargeTypeExt() {
		
		generalChargeTypeExt = general.getChargeTypeExt();
		
		return generalChargeTypeExt;
	}



	public String getGeneralChargeTypeInt() {
		
		generalChargeTypeInt = general.getChargeTypeInt();
		
		return generalChargeTypeInt;
	}



	public String getGeneralWardTypeExt() {
		
		generalWardTypeExt = general.getWardTypeExt();
		
		return generalWardTypeExt;
	}



	public String getGeneralWardTypeInt() {
		
		generalWardTypeInt = general.getWardTypeInt();
		
		return generalWardTypeInt;
	}



	public String getGeneralInternalPatient() {
		
		generalInternalPatient=general.getInternalPatient();
		
		return generalInternalPatient;
	}



	public String getGeneralExternalPatient() {
		
		generalExternalPatient=general.getExternalPatient();
		
		return generalExternalPatient;
	}


*/
 	




	public String getStrArogyaIpdCreditLimit() {
		return strArogyaIpdCreditLimit;
	}




	public void setStrArogyaIpdCreditLimit(String strArogyaIpdCreditLimit) {
		this.strArogyaIpdCreditLimit = strArogyaIpdCreditLimit;
	}




	public String getBillFormatHeader1() {
		return billFormatHeader1;
	}




	public void setBillFormatHeader1(String billFormatHeader1) {
		this.billFormatHeader1 = billFormatHeader1;
	}




	public String getBillFormatHeader2() {
		return billFormatHeader2;
	}




	public void setBillFormatHeader2(String billFormatHeader2) {
		this.billFormatHeader2 = billFormatHeader2;
	}




	public String getBillFormatHeader3() {
		return billFormatHeader3;
	}




	public void setBillFormatHeader3(String billFormatHeader3) {
		this.billFormatHeader3 = billFormatHeader3;
	}




	public String getBillFormatHeader4() {
		return billFormatHeader4;
	}




	public void setBillFormatHeader4(String billFormatHeader4) {
		this.billFormatHeader4 = billFormatHeader4;
	}




	public String getBillFormatFooter() {
		return billFormatFooter;
	}




	public void setBillFormatFooter(String billFormatFooter) {
		this.billFormatFooter = billFormatFooter;
	}




	public String getBillDisclaimerWithoutCrNo() {
		return billDisclaimerWithoutCrNo;
	}




	public void setBillDisclaimerWithoutCrNo(String billDisclaimerWithoutCrNo) {
		this.billDisclaimerWithoutCrNo = billDisclaimerWithoutCrNo;
	}




	public String getBillDisclaimerServices() {
		return billDisclaimerServices;
	}




	public void setBillDisclaimerServices(String billDisclaimerServices) {
		this.billDisclaimerServices = billDisclaimerServices;
	}




	public String getBillDisclaimerRefund() {
		return billDisclaimerRefund;
	}




	public void setBillDisclaimerRefund(String billDisclaimerRefund) {
		this.billDisclaimerRefund = billDisclaimerRefund;
	}




	public String getBillDisclaimerAdvance() {
		return billDisclaimerAdvance;
	}




	public void setBillDisclaimerAdvance(String billDisclaimerAdvance) {
		this.billDisclaimerAdvance = billDisclaimerAdvance;
	}




	public String getBillDisclaimerPartPayment() {
		return billDisclaimerPartPayment;
	}




	public void setBillDisclaimerPartPayment(String billDisclaimerPartPayment) {
		this.billDisclaimerPartPayment = billDisclaimerPartPayment;
	}




	public String getBillDisclaimerFinalBill() {
		return billDisclaimerFinalBill;
	}




	public void setBillDisclaimerFinalBill(String billDisclaimerFinalBill) {
		this.billDisclaimerFinalBill = billDisclaimerFinalBill;
	}




	public String getBillDisclaimerDuplicatePrintRequired() {
		return billDisclaimerDuplicatePrintRequired;
	}




	public void setBillDisclaimerDuplicatePrintRequired(
			String billDisclaimerDuplicatePrintRequired) {
		this.billDisclaimerDuplicatePrintRequired = billDisclaimerDuplicatePrintRequired;
	}




	public String getBillLineOpdServices() {
		return billLineOpdServices;
	}




	public void setBillLineOpdServices(String billLineOpdServices) {
		this.billLineOpdServices = billLineOpdServices;
	}




	public String getEmergencyThirdPartyBilling() {
		return emergencyThirdPartyBilling;
	}




	public void setEmergencyThirdPartyBilling(String emergencyThirdPartyBilling) {
		this.emergencyThirdPartyBilling = emergencyThirdPartyBilling;
	}




	public String getEmergencyDiscount() {
		return emergencyDiscount;
	}




	public void setEmergencyDiscount(String emergencyDiscount) {
		this.emergencyDiscount = emergencyDiscount;
	}




	public String getEmergencyDiscountClerk() {
		return emergencyDiscountClerk;
	}




	public void setEmergencyDiscountClerk(String emergencyDiscountClerk) {
		this.emergencyDiscountClerk = emergencyDiscountClerk;
	}




	public String getEmergencyRefundPenalty() {
		return emergencyRefundPenalty;
	}




	public void setEmergencyRefundPenalty(String emergencyRefundPenalty) {
		this.emergencyRefundPenalty = emergencyRefundPenalty;
	}




	public String getEmergencyRoundOff() {
		return emergencyRoundOff;
	}




	public void setEmergencyRoundOff(String emergencyRoundOff) {
		this.emergencyRoundOff = emergencyRoundOff;
	}




	public String getEmergencyServiceTax() {
		return emergencyServiceTax;
	}




	public void setEmergencyServiceTax(String emergencyServiceTax) {
		this.emergencyServiceTax = emergencyServiceTax;
	}




	public String getEmergencyFreeCategory() {
		return emergencyFreeCategory;
	}




	public void setEmergencyFreeCategory(String emergencyFreeCategory) {
		this.emergencyFreeCategory = emergencyFreeCategory;
	}




	public String getGeneralCancellationTime() {
		return generalCancellationTime;
	}




	public void setGeneralCancellationTime(String generalCancellationTime) {
		this.generalCancellationTime = generalCancellationTime;
	}




	public String getGeneralDuplicatePrintCharge() {
		return generalDuplicatePrintCharge;
	}




	public void setGeneralDuplicatePrintCharge(String generalDuplicatePrintCharge) {
		this.generalDuplicatePrintCharge = generalDuplicatePrintCharge;
	}




	public String getGeneralRecordsDisplayMaster() {
		return generalRecordsDisplayMaster;
	}




	public void setGeneralRecordsDisplayMaster(String generalRecordsDisplayMaster) {
		this.generalRecordsDisplayMaster = generalRecordsDisplayMaster;
	}




	public String getGeneralLevelModifyMaster() {
		return generalLevelModifyMaster;
	}




	public void setGeneralLevelModifyMaster(String generalLevelModifyMaster) {
		this.generalLevelModifyMaster = generalLevelModifyMaster;
	}




	public String getGeneralLevelDeleteMaster() {
		return generalLevelDeleteMaster;
	}




	public void setGeneralLevelDeleteMaster(String generalLevelDeleteMaster) {
		this.generalLevelDeleteMaster = generalLevelDeleteMaster;
	}




	public String getGeneralReceiptType() {
		return generalReceiptType;
	}




	public void setGeneralReceiptType(String generalReceiptType) {
		this.generalReceiptType = generalReceiptType;
	}




	public String getGeneralDuplicatePrint() {
		return generalDuplicatePrint;
	}




	public void setGeneralDuplicatePrint(String generalDuplicatePrint) {
		this.generalDuplicatePrint = generalDuplicatePrint;
	}




	public String getGeneralRefundReceiptType() {
		return generalRefundReceiptType;
	}




	public void setGeneralRefundReceiptType(String generalRefundReceiptType) {
		this.generalRefundReceiptType = generalRefundReceiptType;
	}




	public String getGeneralIsWithoutCrNoRequired() {
		return generalIsWithoutCrNoRequired;
	}




	public void setGeneralIsWithoutCrNoRequired(String generalIsWithoutCrNoRequired) {
		this.generalIsWithoutCrNoRequired = generalIsWithoutCrNoRequired;
	}




	public String getGeneralOnlineRefundRequestAllowed() {
		return generalOnlineRefundRequestAllowed;
	}




	public void setGeneralOnlineRefundRequestAllowed(
			String generalOnlineRefundRequestAllowed) {
		this.generalOnlineRefundRequestAllowed = generalOnlineRefundRequestAllowed;
	}




	public String getGeneralReferringPhysicianRequiredInt() {
		return generalReferringPhysicianRequiredInt;
	}




	public void setGeneralReferringPhysicianRequiredInt(
			String generalReferringPhysicianRequiredInt) {
		this.generalReferringPhysicianRequiredInt = generalReferringPhysicianRequiredInt;
	}




	public String getGeneralReferringPhysicianRequiredExt() {
		return generalReferringPhysicianRequiredExt;
	}




	public void setGeneralReferringPhysicianRequiredExt(
			String generalReferringPhysicianRequiredExt) {
		this.generalReferringPhysicianRequiredExt = generalReferringPhysicianRequiredExt;
	}




	public String getGeneralPreviousCrNoRequiredInt() {
		return generalPreviousCrNoRequiredInt;
	}




	public void setGeneralPreviousCrNoRequiredInt(
			String generalPreviousCrNoRequiredInt) {
		this.generalPreviousCrNoRequiredInt = generalPreviousCrNoRequiredInt;
	}




	public String getGeneralPreviousCrNoRequiredExt() {
		return generalPreviousCrNoRequiredExt;
	}




	public void setGeneralPreviousCrNoRequiredExt(
			String generalPreviousCrNoRequiredExt) {
		this.generalPreviousCrNoRequiredExt = generalPreviousCrNoRequiredExt;
	}




	public String getGeneralCashCollectionConfrimType() {
		return generalCashCollectionConfrimType;
	}




	public void setGeneralCashCollectionConfrimType(
			String generalCashCollectionConfrimType) {
		this.generalCashCollectionConfrimType = generalCashCollectionConfrimType;
	}




	public String getGeneralPreviousCrNoSearchingInt() {
		return generalPreviousCrNoSearchingInt;
	}




	public void setGeneralPreviousCrNoSearchingInt(
			String generalPreviousCrNoSearchingInt) {
		this.generalPreviousCrNoSearchingInt = generalPreviousCrNoSearchingInt;
	}




	public String getGeneralPreviousCrNoSearchingExt() {
		return generalPreviousCrNoSearchingExt;
	}




	public void setGeneralPreviousCrNoSearchingExt(
			String generalPreviousCrNoSearchingExt) {
		this.generalPreviousCrNoSearchingExt = generalPreviousCrNoSearchingExt;
	}




	public String getGeneralDayEndProcessType() {
		return generalDayEndProcessType;
	}




	public void setGeneralDayEndProcessType(String generalDayEndProcessType) {
		this.generalDayEndProcessType = generalDayEndProcessType;
	}




	public String getGeneralDayEndDateType() {
		return generalDayEndDateType;
	}




	public void setGeneralDayEndDateType(String generalDayEndDateType) {
		this.generalDayEndDateType = generalDayEndDateType;
	}




	public String getGeneralDayEndNonBillingProcessType() {
		return generalDayEndNonBillingProcessType;
	}




	public void setGeneralDayEndNonBillingProcessType(
			String generalDayEndNonBillingProcessType) {
		this.generalDayEndNonBillingProcessType = generalDayEndNonBillingProcessType;
	}




	public String getGeneralDayEndNonBillingDateType() {
		return generalDayEndNonBillingDateType;
	}




	public void setGeneralDayEndNonBillingDateType(
			String generalDayEndNonBillingDateType) {
		this.generalDayEndNonBillingDateType = generalDayEndNonBillingDateType;
	}




	public String getGeneralOpdReceiptType() {
		return generalOpdReceiptType;
	}




	public void setGeneralOpdReceiptType(String generalOpdReceiptType) {
		this.generalOpdReceiptType = generalOpdReceiptType;
	}




	public String getGeneralIpdReceiptType() {
		return generalIpdReceiptType;
	}




	public void setGeneralIpdReceiptType(String generalIpdReceiptType) {
		this.generalIpdReceiptType = generalIpdReceiptType;
	}




	public String getGeneralCCOfflineRefundRequired() {
		return generalCCOfflineRefundRequired;
	}




	public void setGeneralCCOfflineRefundRequired(
			String generalCCOfflineRefundRequired) {
		this.generalCCOfflineRefundRequired = generalCCOfflineRefundRequired;
	}




	public String getGeneralPrintMessageLimit() {
		return generalPrintMessageLimit;
	}




	public void setGeneralPrintMessageLimit(String generalPrintMessageLimit) {
		this.generalPrintMessageLimit = generalPrintMessageLimit;
	}




	public String getGeneralRefundAgainstRefundRequest() {
		return generalRefundAgainstRefundRequest;
	}




	public void setGeneralRefundAgainstRefundRequest(
			String generalRefundAgainstRefundRequest) {
		this.generalRefundAgainstRefundRequest = generalRefundAgainstRefundRequest;
	}




	public String getGeneralChargeTypeExt() {
		return generalChargeTypeExt;
	}




	public void setGeneralChargeTypeExt(String generalChargeTypeExt) {
		this.generalChargeTypeExt = generalChargeTypeExt;
	}




	public String getGeneralChargeTypeInt() {
		return generalChargeTypeInt;
	}




	public void setGeneralChargeTypeInt(String generalChargeTypeInt) {
		this.generalChargeTypeInt = generalChargeTypeInt;
	}




	public String getGeneralWardTypeExt() {
		return generalWardTypeExt;
	}




	public void setGeneralWardTypeExt(String generalWardTypeExt) {
		this.generalWardTypeExt = generalWardTypeExt;
	}




	public String getGeneralWardTypeInt() {
		return generalWardTypeInt;
	}




	public void setGeneralWardTypeInt(String generalWardTypeInt) {
		this.generalWardTypeInt = generalWardTypeInt;
	}




	public String getGeneralInternalPatient() {
		return generalInternalPatient;
	}




	public void setGeneralInternalPatient(String generalInternalPatient) {
		this.generalInternalPatient = generalInternalPatient;
	}




	public String getGeneralExternalPatient() {
		return generalExternalPatient;
	}




	public void setGeneralExternalPatient(String generalExternalPatient) {
		this.generalExternalPatient = generalExternalPatient;
	}




	public String getGeneralIsApprovalRequired() {
		return generalIsApprovalRequired;
	}




	public void setGeneralIsApprovalRequired(String generalIsApprovalRequired) {
		this.generalIsApprovalRequired = generalIsApprovalRequired;
	}




	public String getIpdThirdPartyBilling() {
		return ipdThirdPartyBilling;
	}




	public void setIpdThirdPartyBilling(String ipdThirdPartyBilling) {
		this.ipdThirdPartyBilling = ipdThirdPartyBilling;
	}




	public String getIpdDiscount() {
		return ipdDiscount;
	}




	public void setIpdDiscount(String ipdDiscount) {
		this.ipdDiscount = ipdDiscount;
	}




	public String getIpdDiscountClerk() {
		return ipdDiscountClerk;
	}




	public void setIpdDiscountClerk(String ipdDiscountClerk) {
		this.ipdDiscountClerk = ipdDiscountClerk;
	}




	public String getIpdRefundPenalty() {
		return ipdRefundPenalty;
	}




	public void setIpdRefundPenalty(String ipdRefundPenalty) {
		this.ipdRefundPenalty = ipdRefundPenalty;
	}




	public String getIpdCreaditBilling() {
		return ipdCreaditBilling;
	}




	public void setIpdCreaditBilling(String ipdCreaditBilling) {
		this.ipdCreaditBilling = ipdCreaditBilling;
	}




	public String getIpdExcessCreditLimit() {
		return ipdExcessCreditLimit;
	}




	public void setIpdExcessCreditLimit(String ipdExcessCreditLimit) {
		this.ipdExcessCreditLimit = ipdExcessCreditLimit;
	}




	public String getIpdPartPaymentDuration() {
		return ipdPartPaymentDuration;
	}




	public void setIpdPartPaymentDuration(String ipdPartPaymentDuration) {
		this.ipdPartPaymentDuration = ipdPartPaymentDuration;
	}




	public String getIpdRoundOff() {
		return ipdRoundOff;
	}




	public void setIpdRoundOff(String ipdRoundOff) {
		this.ipdRoundOff = ipdRoundOff;
	}




	public String getIpdServiceTaxOnTotalBill() {
		return ipdServiceTaxOnTotalBill;
	}




	public void setIpdServiceTaxOnTotalBill(String ipdServiceTaxOnTotalBill) {
		this.ipdServiceTaxOnTotalBill = ipdServiceTaxOnTotalBill;
	}




	public String getIpdGenAdtProcessType() {
		return ipdGenAdtProcessType;
	}




	public void setIpdGenAdtProcessType(String ipdGenAdtProcessType) {
		this.ipdGenAdtProcessType = ipdGenAdtProcessType;
	}




	public String getIpdServiceTax() {
		return ipdServiceTax;
	}




	public void setIpdServiceTax(String ipdServiceTax) {
		this.ipdServiceTax = ipdServiceTax;
	}




	public String getIpdFreeCategory() {
		return ipdFreeCategory;
	}




	public void setIpdFreeCategory(String ipdFreeCategory) {
		this.ipdFreeCategory = ipdFreeCategory;
	}




	public String getOpdThirdPartyBilling() {
		return opdThirdPartyBilling;
	}




	public void setOpdThirdPartyBilling(String opdThirdPartyBilling) {
		this.opdThirdPartyBilling = opdThirdPartyBilling;
	}




	public String getOpdDiscount() {
		return opdDiscount;
	}




	public void setOpdDiscount(String opdDiscount) {
		this.opdDiscount = opdDiscount;
	}




	public String getOpdDiscountClerk() {
		return opdDiscountClerk;
	}




	public void setOpdDiscountClerk(String opdDiscountClerk) {
		this.opdDiscountClerk = opdDiscountClerk;
	}




	public String getOpdRefundPenalty() {
		return opdRefundPenalty;
	}




	public void setOpdRefundPenalty(String opdRefundPenalty) {
		this.opdRefundPenalty = opdRefundPenalty;
	}




	public String getOpdRoundOff() {
		return opdRoundOff;
	}




	public void setOpdRoundOff(String opdRoundOff) {
		this.opdRoundOff = opdRoundOff;
	}




	public String getOpdServiceTax() {
		return opdServiceTax;
	}




	public void setOpdServiceTax(String opdServiceTax) {
		this.opdServiceTax = opdServiceTax;
	}




	public String getOpdFreeCategory() {
		return opdFreeCategory;
	}




	public void setOpdFreeCategory(String opdFreeCategory) {
		this.opdFreeCategory = opdFreeCategory;
	}




	
	public static String getDIET_CHARGE_ID() {
		return DIET_CHARGE_ID;
	}




	public String getFinStartYear() {
		return finStartYear;
	}




	public void setFinStartYear(String finStartYear) {
		this.finStartYear = finStartYear;
	}




	public String getInBound() {
		return inBound;
	}




	public void setInBound(String inBound) {
		this.inBound = inBound;
	}




	public String getOutBound() {
		return outBound;
	}




	public void setOutBound(String outBound) {
		this.outBound = outBound;
	}




	public String getStrDefaultTariffCode() {
		return strDefaultTariffCode;
	}




	public void setStrDefaultTariffCode(String strDefaultTariffCode) {
		this.strDefaultTariffCode = strDefaultTariffCode;
	}




	public String getIpdGenCheckOutTimeHr() {
		return ipdGenCheckOutTimeHr;
	}




	public void setIpdGenCheckOutTimeHr(String ipdGenCheckOutTimeHr) {
		this.ipdGenCheckOutTimeHr = ipdGenCheckOutTimeHr;
	}




	public String getIpdGenCheckOutTimeMn() {
		return ipdGenCheckOutTimeMn;
	}




	public void setIpdGenCheckOutTimeMn(String ipdGenCheckOutTimeMn) {
		this.ipdGenCheckOutTimeMn = ipdGenCheckOutTimeMn;
	}




	public String getIpdGenCheckOutTimePrivateHr() {
		return ipdGenCheckOutTimePrivateHr;
	}




	public void setIpdGenCheckOutTimePrivateHr(String ipdGenCheckOutTimePrivateHr) {
		this.ipdGenCheckOutTimePrivateHr = ipdGenCheckOutTimePrivateHr;
	}




	public String getIpdGenCheckOutTimePrivateMn() {
		return ipdGenCheckOutTimePrivateMn;
	}




	public void setIpdGenCheckOutTimePrivateMn(String ipdGenCheckOutTimePrivateMn) {
		this.ipdGenCheckOutTimePrivateMn = ipdGenCheckOutTimePrivateMn;
	}




	public String getIpdGenFlexibleTime() {
		return ipdGenFlexibleTime;
	}




	public void setIpdGenFlexibleTime(String ipdGenFlexibleTime) {
		this.ipdGenFlexibleTime = ipdGenFlexibleTime;
	}




	public String getIpdGenFlexibleTimeAdmission() {
		return ipdGenFlexibleTimeAdmission;
	}




	public void setIpdGenFlexibleTimeAdmission(String ipdGenFlexibleTimeAdmission) {
		this.ipdGenFlexibleTimeAdmission = ipdGenFlexibleTimeAdmission;
	}




	public String getStrGeneralWardType() {
		return strGeneralWardType;
	}




	public void setStrGeneralWardType(String strGeneralWardType) {
		this.strGeneralWardType = strGeneralWardType;
	}




	public String getStrGeneralRoomType() {
		return strGeneralRoomType;
	}




	public void setStrGeneralRoomType(String strGeneralRoomType) {
		this.strGeneralRoomType = strGeneralRoomType;
	}




	public String getIpdGenServiceFreeTreatmentTime() {
		return ipdGenServiceFreeTreatmentTime;
	}




	public void setIpdGenServiceFreeTreatmentTime(
			String ipdGenServiceFreeTreatmentTime) {
		this.ipdGenServiceFreeTreatmentTime = ipdGenServiceFreeTreatmentTime;
	}




	public String getIpdGenAdvanceReq() {
		return ipdGenAdvanceReq;
	}




	public void setIpdGenAdvanceReq(String ipdGenAdvanceReq) {
		this.ipdGenAdvanceReq = ipdGenAdvanceReq;
	}




	public String getIpdGenReOpenValidity() {
		return ipdGenReOpenValidity;
	}




	public void setIpdGenReOpenValidity(String ipdGenReOpenValidity) {
		this.ipdGenReOpenValidity = ipdGenReOpenValidity;
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




	public String getStrCreditCashlessAppRequired() {
		return strCreditCashlessAppRequired;
	}




	public void setStrCreditCashlessAppRequired(String strCreditCashlessAppRequired) {
		this.strCreditCashlessAppRequired = strCreditCashlessAppRequired;
	}




	public String getStrPaidCategory() {
		return strPaidCategory;
	}




	public void setStrPaidCategory(String strPaidCategory) {
		this.strPaidCategory = strPaidCategory;
	}




	public String getStrArogyaShreeCategory() {
		return strArogyaShreeCategory;
	}




	public void setStrArogyaShreeCategory(String strArogyaShreeCategory) {
		this.strArogyaShreeCategory = strArogyaShreeCategory;
	}




	public String getStrCGSHCategory() {
		return strCGSHCategory;
	}




	public void setStrCGSHCategory(String strCGSHCategory) {
		this.strCGSHCategory = strCGSHCategory;
	}




	public String getStrGenCategory() {
		return strGenCategory;
	}




	public void setStrGenCategory(String strGenCategory) {
		this.strGenCategory = strGenCategory;
	}




	public String getStrWSHCategory() {
		return strWSHCategory;
	}




	public void setStrWSHCategory(String strWSHCategory) {
		this.strWSHCategory = strWSHCategory;
	}




	public String getStrDayEndTimeBoundFlag() {
		return strDayEndTimeBoundFlag;
	}




	public void setStrDayEndTimeBoundFlag(String strDayEndTimeBoundFlag) {
		this.strDayEndTimeBoundFlag = strDayEndTimeBoundFlag;
	}




	public String getStrDayEndTimeHour() {
		return strDayEndTimeHour;
	}




	public void setStrDayEndTimeHour(String strDayEndTimeHour) {
		this.strDayEndTimeHour = strDayEndTimeHour;
	}




	public String getStrDayEndTimeMin() {
		return strDayEndTimeMin;
	}




	public void setStrDayEndTimeMin(String strDayEndTimeMin) {
		this.strDayEndTimeMin = strDayEndTimeMin;
	}




	public String getStrDayEndTimeAMPM() {
		return strDayEndTimeAMPM;
	}




	public void setStrDayEndTimeAMPM(String strDayEndTimeAMPM) {
		this.strDayEndTimeAMPM = strDayEndTimeAMPM;
	}




	public String getStrDayEndTime() {
		return strDayEndTime;
	}




	public void setStrDayEndTime(String strDayEndTime) {
		this.strDayEndTime = strDayEndTime;
	}




	public String getStrArogyaShreeTSCategory() {
		return strArogyaShreeTSCategory;
	}




	public void setStrArogyaShreeTSCategory(String strArogyaShreeTSCategory) {
		this.strArogyaShreeTSCategory = strArogyaShreeTSCategory;
	}




	public String getStrArogyaTSCreditLimit() {
		return strArogyaTSCreditLimit;
	}




	public void setStrArogyaTSCreditLimit(String strArogyaTSCreditLimit) {
		this.strArogyaTSCreditLimit = strArogyaTSCreditLimit;
	}




	public String getStrUrgTrfSur() {
		return strUrgTrfSur;
	}




	public void setStrUrgTrfSur(String strUrgTrfSur) {
		this.strUrgTrfSur = strUrgTrfSur;
	}

	public String getLogoReq() {
		return logoReq;
	}




	public void setLogoReq(String logoReq) {
		this.logoReq = logoReq;
	}


	public String getHindiReq() {
		return hindiReq;
	}


	public void setHindiReq(String hindiReq) {
		this.hindiReq = hindiReq;
	}

	
	public String getHeaderReq() {
		return headerReq;
	}


	public void setHeaderReq(String headerReq) {
		this.headerReq = headerReq;
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




	public String getStrNegativeDayEndAllowed() {
		return strNegativeDayEndAllowed;
	}




	public void setStrNegativeDayEndAllowed(String strNegativeDayEndAllowed) {
		this.strNegativeDayEndAllowed = strNegativeDayEndAllowed;
	}




	public String getStrDenominationAllowed() {
		return strDenominationAllowed;
	}




	public void setStrDenominationAllowed(String strDenominationAllowed) {
		this.strDenominationAllowed = strDenominationAllowed;
	}




	public String getReqModiCat() {
		return reqModiCat;
	}




	public void setReqModiCat(String reqModiCat) {
		this.reqModiCat = reqModiCat;
	}
	

}
