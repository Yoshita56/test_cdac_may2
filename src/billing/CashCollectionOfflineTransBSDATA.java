package billing;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.tools.hlp.PatientDtlHLPNew;
import hisglobal.utility.HisUtil;
import hisglobal.utility.SMSSender.SMSHttpPostClient;

// TODO: Auto-generated Javadoc
/**
 * The Class CashCollectionOfflineTransBSDATA.
 */
public class CashCollectionOfflineTransBSDATA
{

	/**
	 * method used to check whether the System's IP Address is Registered in
	 * Counter Master or Not.
	 * 
	 * @param request
	 * @param formBean
	 */
	public static String checkCounterStatus(HttpServletRequest request, CashCollectionOfflineTransFB formBean)
	{

		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;
		String strCounterId ="";
		try
		{
			formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR").toString());
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			bo = new CashCollectionOfflineTransBO();
			voObj = new CashCollectionOfflineTransVO();

			voObj.setStrIpAddress(formBean.getStrIpAddress());
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.checkCounterStatus(voObj);

			strCounterId = voObj.getStrCounterId();

			if (strCounterId != null)
			{
				if (strCounterId.trim().length() < 4)
				{
					formBean.setStrErrMsg("Cash Collection is Not Applicable, System IP Address is not Registered as Counter");
					formBean.setStrCrNo("");
				}
			}
			else
			{
				formBean.setStrErrMsg("Cash Collection is Not Applicable, System IP Address is not Registered as Counter");
				formBean.setStrCrNo("");
			}
		} 
		catch (Exception e)
		{
			String msgStr = e.getMessage();
			HisException eObj = new HisException("Billing", "CashCollectionOfflineTransBSDATA->checkCounterStatus()", msgStr);
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrCrNo("");
			eObj = null;
		} 
		finally
		{
			bo = null;
			voObj = null;
			return strCounterId;
		}

	}

	/**
	 * Initialize all the required information like Online & Off-line Details
	 * for given Cr Number.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * 
	 * @return true - all the required information has been initialized<br>
	 *         false - all the required information has not been initialized.
	 */
	public static boolean init(HttpServletRequest request, CashCollectionOfflineTransFB formBean)
	{
		boolean bResultVal = true;
		String strCrNo = formBean.getStrCrNo();

		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;
		BillConfigUtil configUtil = null;
		HisUtil hisUtil = null;

		try
		{
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			String strPatView = "";

			strPatView = PatientDtlHLPNew.compactPatientWithAdmissionDtlCash(strCrNo, formBean.getStrHospitalCode(), false);
			//formBean.setStrMobileNo(PatientDtlHLP.strMobileNo);
			String[] str=strPatView.replace("~","#").split("#");
			formBean.setStrPatientDetailsView(str[0]);
			//formBean.setStrPatientDetailsView(strPatView);
			String strOffLineBillingService=formBean.getStrOffLineBillingService();
			
			/*if(str[1].equals("1"))//AdmittedDetailsFound
			{
				if(PatientDtlHLP.strAdmittedTreamentCatCode!=null && !PatientDtlHLP.strAdmittedTreamentCatCode.equals(""))
				{
					formBean.setStrTreatmentCategory(PatientDtlHLP.strAdmittedTreamentCatCode);
					formBean.setStrIsAdmittedTreatmentCategoryPresent("1");//1-Yes,0-No
					formBean.setStrTreatmentCategoryGroup(PatientDtlHLP.strAdmittedTreamentCatCodeGroup);
					
				}
			}
			else if(PatientDtlHLP.strTreamentCatCode!=null && !PatientDtlHLP.strTreamentCatCode.equals(""))
				{
					formBean.setStrTreatmentCategory(PatientDtlHLP.strTreamentCatCode);///Primary Category
					formBean.setStrTreatmentCategoryGroup(PatientDtlHLP.strTreamentCatCodeGroup);
				}*/
			
			bo = new CashCollectionOfflineTransBO();
			voObj = new CashCollectionOfflineTransVO();
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			configUtil = new BillConfigUtil(voObj.getStrHospitalCode());

			hisUtil = new HisUtil("Billing", "CashCollectionOfflineTransBSDATA");

			formBean.setStrIpdThirdPartyBenefit(configUtil.getIpdThirdPartyBilling());
			formBean.setStrOpdThirdPartyBenefit(configUtil.getOpdThirdPartyBilling());
			formBean.setStrEmergencyThirdPartyBenefit(configUtil.getEmergencyThirdPartyBilling());

			formBean.setStrConsumableChargesGroupId(configUtil.getStrConsumableChargesGroupId());
			formBean.setStrConsumableChargesTariffCode(configUtil.getStrConsumableChargesTariffCode());
			formBean.setPrintMode(BillConfigUtil.PRINT_MODE.toString());//Laser Printing or DMP Printing
			formBean.setStrArogyaCatId(configUtil.getStrArogyaShreeCategory());
			formBean.setStrArogyaTSCatId(configUtil.getStrArogyaShreeTSCategory());
			formBean.setStrWchCatId(configUtil.getStrWSHCategory());
			formBean.setStrUrgSur(configUtil.getStrUrgTrfSur());
			//System.out.println("formBean.setStrUrgTrfSur"+formBean.getStrUrgSur());
			formBean.setStrSurCc(configUtil.getStrSurCc());
			formBean.setStrSurDc(configUtil.getStrSurDc());
			formBean.setStrSurIc(configUtil.getStrSurIc());
			formBean.setStrSurId(configUtil.getStrSurId());
			formBean.setStrSurCc1(configUtil.getStrSurCc1());
			formBean.setStrSurDc1(configUtil.getStrSurDc1());
			formBean.setStrSurIc1(configUtil.getStrSurIc1());
			formBean.setStrSurId1(configUtil.getStrSurId1());
			formBean.setDefsurlim(BillConfigUtil.DEFAULT_SURCHARGE_LIMIT);

			formBean.setStrArogyaTSCatCreditLimit(configUtil.getStrArogyaTSCatCreditLimit());

			if (formBean.getStrOffLineHospitalService().equals("2"))
			{
				formBean.setStrFreeCategory(configUtil.getIpdFreeCategory());
			} 
			else if (formBean.getStrOffLineHospitalService().equals("1"))
			{
				formBean.setStrFreeCategory(configUtil.getOpdFreeCategory());
			} 
			else
			{
				formBean.setStrFreeCategory(configUtil.getEmergencyFreeCategory());
			}

			formBean.setStrCurrentDate(hisUtil.getASDate("dd-MMM-yyyy"));

			CashCollectionOfflineTransBSDATA.initOffLineDetails(formBean, bo, voObj);

			formBean.setStrIsRefundReq(configUtil.getGeneralCCOfflineRefundRequired());
			formBean.setStrPrintMessageLimit(configUtil.getGeneralPrintMessageLimit());
			formBean.setCurrentBserviceId(strOffLineBillingService);

		} 
		catch (Exception e)
		{
			bResultVal = false;
			String msgStr = e.getMessage();

			if (msgStr.contains("CR."))
			{
				formBean.setStrErrMsg("Invalid CR. No./Category Expired");
			} 
			else
			{
				HisException eObj = new HisException("Billing", "CashCollectionOfflineTransDATA->init()", msgStr);
				formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				formBean.setStrCrNo("");
				eObj = null;
			}
		} 
		finally
		{
			bo = null;
			voObj = null;
			configUtil = null;
			hisUtil = null;
		}

		return bResultVal;
	}
	/**
	 * Initialize all the required information like Online & Off-line Details
	 * for given Cr Number.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * 
	 * @return true - all the required information has been initialized<br>
	 *         false - all the required information has not been initialized.
	 */
	public static boolean initAdvancedCash(HttpServletRequest request, CashCollectionOfflineTransFB formBean)
	{
		boolean bResultVal = true;
		String strCrNo = formBean.getStrCrNo();

		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;
		BillConfigUtil configUtil = null;
		HisUtil hisUtil = null;

		try
		{
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			String strPatView = "";

			strPatView = PatientDtlHLPNew.compactPatientWithAdmissionDtlCash(strCrNo, formBean.getStrHospitalCode(), false);
		    //formBean.setStrMobileNo(PatientDtlHLP.strMobileNo);
			/*String[] str=strPatView.replace("~","#").split("#");
			formBean.setStrPatientDetailsView(str[0]);*/
			formBean.setStrPatientDetailsView(strPatView);
			
			/*if(str[1].equals("1"))//AdmittedDetailsFound
			{
				if(PatientDtlHLP.strAdmittedTreamentCatCode!=null && !PatientDtlHLP.strAdmittedTreamentCatCode.equals(""))
				{
					formBean.setStrTreatmentCategory(PatientDtlHLP.strAdmittedTreamentCatCode);
					formBean.setStrIsAdmittedTreatmentCategoryPresent("1");//1-Yes,0-No
					formBean.setStrTreatmentCategoryGroup(PatientDtlHLP.strAdmittedTreamentCatCodeGroup);
					
				}
			}
			else if(PatientDtlHLP.strTreamentCatCode!=null && !PatientDtlHLP.strTreamentCatCode.equals(""))
				{
					formBean.setStrTreatmentCategory(PatientDtlHLP.strTreamentCatCode);///Primary Category
					formBean.setStrTreatmentCategoryGroup(PatientDtlHLP.strTreamentCatCodeGroup);
				}*/
			
			bo = new CashCollectionOfflineTransBO();
			voObj = new CashCollectionOfflineTransVO();
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			configUtil = new BillConfigUtil(voObj.getStrHospitalCode());

			hisUtil = new HisUtil("Billing", "CashCollectionOfflineTransBSDATA");

			formBean.setStrIpdThirdPartyBenefit(configUtil.getIpdThirdPartyBilling());
			formBean.setStrOpdThirdPartyBenefit(configUtil.getOpdThirdPartyBilling());
			formBean.setStrEmergencyThirdPartyBenefit(configUtil.getEmergencyThirdPartyBilling());

			formBean.setStrConsumableChargesGroupId(configUtil.getStrConsumableChargesGroupId());
			formBean.setStrConsumableChargesTariffCode(configUtil.getStrConsumableChargesTariffCode());
			formBean.setPrintMode(BillConfigUtil.PRINT_MODE.toString());//Laser Printing or DMP Printing
			formBean.setStrArogyaCatId(configUtil.getStrArogyaShreeCategory());
			formBean.setStrArogyaTSCatId(configUtil.getStrArogyaShreeTSCategory());
			formBean.setStrWchCatId(configUtil.getStrWSHCategory());
			formBean.setStrUrgSur(configUtil.getStrUrgTrfSur());
			formBean.setStrSurCc(configUtil.getStrSurCc());
			formBean.setStrSurDc(configUtil.getStrSurDc());
			formBean.setStrSurIc(configUtil.getStrSurIc());
			formBean.setStrSurId(configUtil.getStrSurId());
			formBean.setStrSurCc1(configUtil.getStrSurCc1());
			formBean.setStrSurDc1(configUtil.getStrSurDc1());
			formBean.setStrSurIc1(configUtil.getStrSurIc1());
			formBean.setStrSurId1(configUtil.getStrSurId1());
			formBean.setStrArogyaTSCatCreditLimit(configUtil.getStrArogyaTSCatCreditLimit());
			formBean.setDefsurlim(BillConfigUtil.DEFAULT_SURCHARGE_LIMIT);


			if (formBean.getStrOffLineHospitalService().equals("2"))
			{
				formBean.setStrFreeCategory(configUtil.getIpdFreeCategory());
			} 
			else if (formBean.getStrOffLineHospitalService().equals("1"))
			{
				formBean.setStrFreeCategory(configUtil.getOpdFreeCategory());
			} 
			else
			{
				formBean.setStrFreeCategory(configUtil.getEmergencyFreeCategory());
			}

			formBean.setStrCurrentDate(hisUtil.getASDate("dd-MMM-yyyy"));

			CashCollectionOfflineTransBSDATA.initAdvancedOffLineDetails(formBean, bo, voObj);
			
			
			formBean.setStrIsRefundReq(configUtil.getGeneralCCOfflineRefundRequired());
			formBean.setStrPrintMessageLimit(configUtil.getGeneralPrintMessageLimit());

		} 
		catch (Exception e)
		{
			bResultVal = false;
			String msgStr = e.getMessage();

			if (msgStr.contains("CR."))
			{
				formBean.setStrErrMsg("Invalid CR. No./Category Expired");
			} 
			else
			{
				HisException eObj = new HisException("Billing", "CashCollectionOfflineTransDATA->init()", msgStr);
				formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				formBean.setStrCrNo("");
				eObj = null;
			}
		} 
		finally
		{
			bo = null;
			voObj = null;
			configUtil = null;
			hisUtil = null;
		}

		return bResultVal;
	}

	public static void preInitOffLineDetails(CashCollectionOfflineTransFB formBean)
	{
		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;

		HisUtil util = null;
		BillConfigUtil bcu = null;

		try
		{
			bo = new CashCollectionOfflineTransBO();
			voObj = new CashCollectionOfflineTransVO();
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			bcu = new BillConfigUtil(voObj.getStrHospitalCode());

			voObj.setStrOffLineHospitalService("1");//1-OPD,2-IPD,3-Emg
			voObj.setStrOffLineRequestType("1");//1-OPD Services
			voObj.setStrSeatId(formBean.getStrSeatId());

			bo.preInitOffLineDetails(voObj);
			if (voObj.getStrMsgType().equals("1"))
			{
				throw new Exception(voObj.getStrMsgString());
			}

			util = new HisUtil("Billing Transaction", "CashCollectionTrans");
			String temp = "";

			if (voObj.getOfflineHospitalServiceList() != null && voObj.getOfflineHospitalServiceList().size() != 0)
			{
				temp = util.getOptionValue(voObj.getOfflineHospitalServiceList(), voObj.getStrOffLineHospitalService(), "",false);
				formBean.setStrHospitalServiceDetails(temp);
			}
			if (voObj.getOfflineBillingServiceList() != null && voObj.getOfflineBillingServiceList().size() != 0)
			{
				temp = util.getOptionValue(voObj.getOfflineBillingServiceList(), voObj.getStrOffLineBillingService(), "",false);
				formBean.setStrBillingServiceDetails(temp);
			}
			formBean.setStrIsOnline("0");
			formBean.setCurrentState("2");//?

			formBean.setStrIsWithoutCrNoRequired(bcu.getGeneralIsWithoutCrNoRequired());
			formBean.setStrConfirmationType(bcu.getGeneralCashCollectionConfrimType());//OK-Cancel
			formBean.setStrIsRefundReq(bcu.getGeneralCCOfflineRefundRequired());//Refund Without Approval Required or Not
			formBean.setStrPrintMessageLimit(bcu.getGeneralPrintMessageLimit());//Print Alert
		} 
		catch (Exception e)
		{
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("Billing", "CashCollectionOfflineTransBSDATA->preInitOffLineDetails()", strmsgText);
			formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} 
		finally
		{
			bo = null;
			voObj = null;
			util = null;
			bcu = null;
		}
	}

	/**
	 * Initialize all the required information like Off-line Details for given
	 * Cr Number.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param bo -
	 *            Business Object
	 * @param voObj -
	 *            Value Object
	 */
	public static void initOffLineDetails(CashCollectionOfflineTransFB formBean, CashCollectionOfflineTransBO bo,CashCollectionOfflineTransVO voObj)
	{
		BillConfigUtil billConfigUtil = null;
		HisUtil util = null;
		String selectedTreatmentCat="11^0";//Default General

		try
		{
			billConfigUtil = new BillConfigUtil(voObj.getStrHospitalCode());

			formBean.setStrOfflineIpdPenaltyVal(billConfigUtil.getIpdRefundPenalty());
			formBean.setStrOfflineOpdPenaltyVal(billConfigUtil.getOpdRefundPenalty());
			formBean.setStrOfflineEmergencyPenaltyVal(billConfigUtil.getEmergencyRefundPenalty());

			formBean.setStrIsEmergencyDiscount(billConfigUtil.getEmergencyDiscountClerk());
			formBean.setStrIsIpdDiscount(billConfigUtil.getIpdDiscountClerk());
			formBean.setStrIsOpdDiscount(billConfigUtil.getOpdDiscountClerk());
			formBean.setStrIsApprovalRequired(billConfigUtil.getGeneralIsApprovalRequired());
			formBean.setStrIsAdvanceRequired(billConfigUtil.getIpdGenAdvanceReq());
			

			/*System.out.println("billConfigUtil.getIpdDiscountClerk()="+billConfigUtil.getIpdDiscountClerk());
			System.out.println("billConfigUtil.getOpdDiscountClerk()="+billConfigUtil.getOpdDiscountClerk());
			System.out.println("billConfigUtil.getEmergencyDiscountClerk()="+billConfigUtil.getEmergencyDiscountClerk());*/

			if (formBean.getStrOffLineHospitalService().equals("1"))
			{
				voObj.setStrClerkDiscount(formBean.getStrIsOpdDiscount());
			} 
			else if (formBean.getStrOffLineHospitalService().equals("2"))
			{
				voObj.setStrClerkDiscount(formBean.getStrIsIpdDiscount());
			} 
			else
			{
				voObj.setStrClerkDiscount(formBean.getStrIsEmergencyDiscount());
			}

			voObj.setStrOffLineRequestType(formBean.getStrOffLineRequestType());
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrCrNo(formBean.getStrCrNo());
			voObj.setStrOffLineHospitalService(formBean.getStrOffLineHospitalService());
			voObj.setStrOffLineBillingService(formBean.getStrOffLineBillingService());
			voObj.setStrSeatId(formBean.getStrSeatId());
			voObj.setStrIsApprovalRequired(formBean.getStrIsApprovalRequired());
			voObj.setStrIsAdvanceRequired(formBean.getStrIsAdvanceRequired());
			voObj.setStrTreatmentCategory(formBean.getStrTreatmentCategory());

			bo.initOffLineDetails(voObj);
			
			formBean.setStrAvlWalletMoney(voObj.getStrAvlWalletMoney());
			formBean.setStrWalletNo(voObj.getStrWalletNo());
			formBean.setStrWalletNoMasked(HisUtil.maskNumber(voObj.getStrWalletNo(),"xxxxxxxxxxx####") );
			formBean.setStrMobileNo(voObj.getStrMobileNo());
			
			if (voObj.getStrMsgType().equals("1"))
			{
				throw new Exception(voObj.getStrMsgString());
			}

			util = new HisUtil("Billing Transaction", "CashCollectionTrans");
			String temp = "";

			if (voObj.getAdmEpisodeTreatCatDeptDtls() != null && voObj.getAdmEpisodeTreatCatDeptDtls().size() != 0)
			{
				WebRowSet ws=voObj.getAdmEpisodeTreatCatDeptDtls();
				if(voObj.getAdmEpisodeTreatCatDeptDtls().next())
				{
					voObj.setStrOffLineRaisingDepartment(ws.getString(1));
					voObj.setStrOffLineEpisode(ws.getString(2));
					selectedTreatmentCat=ws.getString(4)+"^"+ws.getString(5);
					voObj.setStrVisitType(ws.getString(6));
					formBean.setStrVisitType(ws.getString(6));
				}				
			}

			if (voObj.getOfflineHospitalServiceList() != null && voObj.getOfflineHospitalServiceList().size() != 0)
			{
				temp = util.getOptionValue(voObj.getOfflineHospitalServiceList(), voObj.getStrOffLineHospitalService(), "",false);
				formBean.setStrHospitalServiceDetails(temp);
			}
			if (voObj.getOfflineBillingServiceList() != null && voObj.getOfflineBillingServiceList().size() != 0)
			{
				temp = util.getOptionValue(voObj.getOfflineBillingServiceList(), voObj.getStrOffLineBillingService(), "",false);
				formBean.setStrBillingServiceDetails(temp);
			}
			if (voObj.getOfflineRaisingDepartmentList() != null && voObj.getOfflineRaisingDepartmentList().size() != 0)
			{//Last Visited Department Selected
				
				if(voObj.getStrOffLineBillingService().equals("19")) 
					temp = util.getOptionValue(voObj.getOfflineRaisingDepartmentList(), "0",	"0^Select Value", false);
				else
					temp = util.getOptionValue(voObj.getOfflineRaisingDepartmentList(), voObj.getStrOffLineRaisingDepartment(),	"0^Select Value", false);
					
				
				
				formBean.setStrRaisingDepartmentDetails(temp);
			} 
			else
			{
				formBean.setStrRaisingDepartmentDetails("<option value='0'>Select Value</option>");
			}

			if (voObj.getOfflineEpisodeList() != null && voObj.getOfflineEpisodeList().size() != 0)
			{//Last Visited Department Episode
				
				if(voObj.getStrOffLineBillingService().equals("19")) 
					temp = util.getOptionValue(voObj.getOfflineEpisodeList(), "0", "0^Select Value", true);
				else
					temp = util.getOptionValue(voObj.getOfflineEpisodeList(), voObj.getStrOffLineEpisode(), "", true);
				
				
				
				formBean.setStrEpisodeDetails(temp);
				formBean.setStrEpisodeFound("1");
				/*String temp1[] = voObj.getStrOffLineEpisode().replace("@", "#").split("#");
				if (!temp1[1].equals("") || !temp1[1].equals("0"))
				{
					voObj.setStrOffLineTreatmentCategory(temp1[1]);
					voObj.setStrOffLineTreatmentCategoryGroup(temp1[2]);
				}*/
			} 
			else
			{
				formBean.setStrEpisodeFound("0");
				formBean.setStrEpisodeDetails("<option value='0'>Select Value</option>");
			}

			System.out.println("selectedTreatmentCat"+selectedTreatmentCat);
			if (voObj.getOfflineTreatmentCategoryList() != null && voObj.getOfflineTreatmentCategoryList().size() != 0)
			{
				temp = util.getOptionValue(voObj.getOfflineTreatmentCategoryList(),selectedTreatmentCat ,	"", false);
				formBean.setStrTreatmentCategoryDetails(temp);
			} 
			else
			{
				formBean.setStrTreatmentCategoryDetails("<option value='0'>Select Value</option>");
			}
			if (voObj.getOfflineWardList() != null && voObj.getOfflineWardList().size() != 0)
			{
				
					temp = util.getOptionValue(voObj.getOfflineWardList(), voObj.getStrChargeTypeId(), "0^Select Value", false, false);
					formBean.setStrWardDetails(temp);
			} 
			else
			{
				formBean.setStrWardDetails("<option value='0'>Select Value</option>");
			}

			if (voObj.getStrClientNameList() != null && voObj.getStrClientNameList().size() != 0)
			{
				temp = util.getOptionValue(voObj.getStrClientNameList(),  voObj.getStrOffLineWard(), "0^Select Value", false);
				formBean.setStrClientNameContents(temp);
			} 
			else
			{
				formBean.setStrClientNameContents("<option value='0'>Select Value</option>");
			}

			if (voObj.getStrPaymentModeList() != null && voObj.getStrPaymentModeList().size() != 0)
			{
				temp = util.getOptionValue(voObj.getStrPaymentModeList(),"", "", false);
				formBean.setStrPaymentModeContents(temp);
			}
			if (voObj.getStrQRCodeModeList() != null && voObj.getStrQRCodeModeList().size() != 0)
			{
				
				temp = util.getOptionValue(voObj.getStrQRCodeModeList(), "", "", false);
				formBean.setStrQRCodeModeContents(temp);
			}
			if(formBean.getStrOffLineBillingService().equals("13"))
			{
				String strPackageDtls = "";
				
				strPackageDtls = CashCollectionOfflineTransHLP.getOffLinePackageAppDetailsViewBS(voObj,selectedTreatmentCat);
			
			    formBean.setStrPackageDetails(strPackageDtls);
				
				bo.getBillingPackageNames(voObj);
	            if(voObj.getPackageComboValuesWs()!=null && voObj.getPackageComboValuesWs().size()>0)
		            temp = util.getOptionValue(voObj.getPackageComboValuesWs(), "0","0^Select Value", false);
	            else
		            temp = util.getOptionValue(voObj.getPackageComboValuesWs(), "0","0^Select Value", false);

	            formBean.setStrPackageComboValues(temp);
			}
			if (bo.isPartPaymentorAdvanceExist(voObj))
			{
				String strPartOrAdvanceDtls = "";

				if (voObj.getStrOffLineBillingService().equals("19"))
				{
					strPartOrAdvanceDtls = CashCollectionOfflineTransHLP.getOffLineAdvanceDetailsView_BS(voObj);
				} 
				else
				{
					strPartOrAdvanceDtls = CashCollectionOfflineTransHLP.getOffLinePartPaymentDetailsView_BS(voObj);
				}
				formBean.setStrPartPayAdvanceAmountDetails(strPartOrAdvanceDtls);
			}
			if (voObj.getStrOffLineBillingService().equals("20") && voObj.getStrOffLineRequestType().equals("2"))
			{
				String strPartOrAdvanceDtls = "";
				strPartOrAdvanceDtls = CashCollectionOfflineTransHLP.getOffLinePartPaymentDetailsView_BS(voObj);

			}
			if (voObj.getStrOffLineBillingService().equals("19") && voObj.getStrOffLineRequestType().equals("2"))
			{
				String strAdvanceDtls = "";
				strAdvanceDtls = CashCollectionOfflineTransHLP.getAdvanceDtlView(voObj);
				formBean.setAdvPayDtl(strAdvanceDtls);
  
			}
			/*	String strOffLineClientDtls = "";

				// Logics to get Offline Client Details
				if (formBean.getStrOffLineHospitalService().equals("1")
						&& formBean.getStrOpdThirdPartyBenefit().equals("1")
						|| formBean.getStrOffLineHospitalService().equals("2")
						&& formBean.getStrIpdThirdPartyBenefit().equals("1")
						|| formBean.getStrOffLineHospitalService().equals("3")
						&& formBean.getStrEmergencyThirdPartyBenefit().equals("1")) {

					strOffLineClientDtls = CashCollectionOfflineTransHLP
							.getOffLineClientDetailsView(voObj);

				}

				strOffLineClientDtls = strOffLineClientDtls
						+ CashCollectionOfflineTransHLP.getOffLineOtherDetailsView(voObj);

				formBean.setStrOfflineClientDetailsView(strOffLineClientDtls);
			 */
			if (voObj.getOfflineGroupList() != null && voObj.getOfflineGroupList().size() != 0)
			{
				temp = util.getOptionValue(voObj.getOfflineGroupList(), voObj.getStrOffLineWard(), "0^All Group", false);
				formBean.setStrOfflineGroupDetails(temp);
			}

			/*
			 * if (voObj.getOfflineTariffList().size() != 0) {
			 * formBean.setStrOfflineTariffDetails(HisUtil.getDropDown1(voObj
			 * .getOfflineTariffList(), 1, 5, false)); }
			 */

			/*if (voObj.getOfflinePackageGroup() != null
					&& voObj.getOfflinePackageGroup().size() != 0) {
				temp = util.getOptionValue(voObj.getOfflinePackageGroup(),
						voObj.getStrOffLineWard(), "0^All Group", false);

				formBean.setStrOfflinePkgsGroupDetails(temp);
			}
			 */
			//if (voObj.getStrClerkDiscount().equals("1"))
			//{
				if (voObj.getOfflineDiscountApprovedBy() != null && voObj.getOfflineDiscountApprovedBy().size() != 0)
				{
					temp = util.getOptionValue(voObj.getOfflineDiscountApprovedBy(), "0", "0^Select Value", false);
					formBean.setStrOfflineDiscountApprovedByDetails(temp);
				}
				if (voObj.getOfflineDiscountRemarks() != null && voObj.getOfflineDiscountRemarks().size() != 0)
				{
					temp = util.getOptionValue(voObj.getOfflineDiscountRemarks(), "", "", false);
					temp = temp + "<option value='0'>Others</option>";
					formBean.setStrOfflineDiscountRemarksDetails(temp);
				}
			//}

			if (voObj.getStrOffLineRequestType().equals("2"))
			{

				if (voObj.getOfflineApprovedByList() != null && voObj.getOfflineApprovedByList().size() != 0)
				{
					voObj.getOfflineApprovedByList().beforeFirst();
					temp = util.getOptionValue(voObj.getOfflineApprovedByList(), "0", "0^Select Value", false);
					formBean.setStrOffLineRefundByList(temp);
				}
				if (voObj.getOfflineRemarksList() != null && voObj.getOfflineRemarksList().size() != 0)
				{
					voObj.getOfflineRemarksList().beforeFirst();
					temp = util.getOptionValue(voObj.getOfflineRemarksList(), "", "", false);
					temp = temp + "<option value='0'>Others</option>";
					formBean.setStrOffLineRefundReasonDetails(temp);
				} 
				else
				{
					temp = "<option value='0'>Others</option>";
					formBean.setStrOffLineRefundReasonDetails(temp);
				}
			}
            
			if (voObj.getOfflineSplWardList() != null && voObj.getOfflineSplWardList().size() > 0)
			{
				temp = util.getOptionValue(voObj.getOfflineSplWardList(), voObj.getStrOffLineSpecialWard(),"0^Select Value", false);
			} 
			else
			{
				temp = "<option value='0'>Select Value</option>";
			}

			
			/******Added By vikrant For Cash Collection Offline(Patient Details)**********/
			formBean.setStrRmk(voObj.getStrRmk());
			//formBean.setStrRelatinDetails(voObj.getStrRelationWs());
			
			formBean.setStrSpecialWardDetails(temp);

			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));
			//formBean.setStrRelatinDetails(voObj.getStrRelationWs());
			formBean.setStrRmk(voObj.getStrRmk());
			
			/*if (voObj.getCreditLettersWS()!= null && voObj.getCreditLettersWS().size() > 0)
			{
				temp = util.getOptionValue(voObj.getCreditLettersWS(), "","0^Select Value", false);
			} 
			else
			{
				temp = "<option value='0'>Select Value</option>";
			}
			formBean.setStrCreditLetterNoList(temp);*/
			
			//Useful Only When Redirected From Cash Online Page. Otherwise Being called from Individual HLP functions. 
			
			if(voObj.getStrOffLineTreatmentCategory().replace("^","#").split("#").length>=2  && (voObj.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1].equals("3") || voObj.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1].equals("4") ))
			{
				boolean flagEnableDisable=true;
				//If WCH then By Default Combo Disabled because WCH is Paid
				if(voObj.getStrOffLineTreatmentCategory().replace("^","#").split("#")[0].equals(billConfigUtil.getStrWSHCategory()))
				{
					flagEnableDisable=false;
				}
				
				BillingVO voBilling=new BillingVO();
				voBilling.setStrValue1(voObj.getStrCrNo());
				voBilling.setStrHospitalCode(voObj.getStrHospitalCode());
				voBilling.setStrCatCode(voObj.getStrOffLineTreatmentCategory());
				voBilling.setStrServiceType("1");//1-OP CONSULATION ONLY,OP & INV ,2-IP ONLY & IP & INV
				String creditListCombo=HLPbilling.getCreditLetterListComboOffline_BS(voBilling,"1",flagEnableDisable,false,voObj.getStrOffLineHospitalService(),voObj.getStrOffLineBillingService()); 
				formBean.setStrCreditLetterNoList(creditListCombo);
			}
			else if(voObj.getStrOffLineHospitalService().equals("2") && voObj.getStrOffLineBillingService().equals("11"))
			{
				boolean flagEnableDisable=true;
				//If WCH then By Default Combo Disabled because WCH is Paid
				if(selectedTreatmentCat.replace("^","#").split("#")[0].equals(billConfigUtil.getStrWSHCategory()))
				{
					flagEnableDisable=false;
				}
				
				BillingVO voBilling=new BillingVO();
				voBilling.setStrValue1(voObj.getStrCrNo());
				voBilling.setStrHospitalCode(voObj.getStrHospitalCode());
				voBilling.setStrCatCode(selectedTreatmentCat);
				voBilling.setStrServiceType("1");//1-OP CONSULATION ONLY,OP & INV ,2-IP ONLY & IP & INV
				String creditListCombo=HLPbilling.getCreditLetterListComboOffline_BS(voBilling,"1",flagEnableDisable,false,voObj.getStrOffLineHospitalService(),voObj.getStrOffLineBillingService()); 
				formBean.setStrCreditLetterNoList(creditListCombo);
			}
			else
			{
				temp = "<option value='0'>Select Value</option>";
				formBean.setStrCreditLetterNoList(temp);
			}			
		} 
		catch (Exception e)
		{
			//e.printStackTrace();
			if(voObj.getStrMsgType().equals("2"))
			{
				formBean.setStrErrMsg("No Open Episode Found for This Patient!!!");
			}
			if(voObj.getStrMsgType().equals("3"))
			{
				formBean.setStrErrMsg("Payment Mode Not Bound for This Patient Category. Map Data from Payment Mode and Category Mapping Master!!!");
			}
			else
			{
				String strmsgText = e.getMessage();
				HisException eObj = new HisException("Billing", "CashCollectionOfflineTransBSDATA->initOffLineDetails()", strmsgText);
				formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				eObj = null;
			}
		} 
		finally
		{
			billConfigUtil = null;
			util = null;
		}
	}
	
	/**
	 * Initialize all the required information like Off-line Details for given
	 * Cr Number.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param bo -
	 *            Business Object
	 * @param voObj -
	 *            Value Object
	 */
	public static void initAdvancedOffLineDetails(CashCollectionOfflineTransFB formBean, CashCollectionOfflineTransBO bo,CashCollectionOfflineTransVO voObj)
	{
		BillConfigUtil billConfigUtil = null;
		HisUtil util = null;
		String selectedTreatmentCat="11^0";//Default General

		try
		{
			billConfigUtil = new BillConfigUtil(voObj.getStrHospitalCode());

			formBean.setStrOfflineIpdPenaltyVal(billConfigUtil.getIpdRefundPenalty());
			formBean.setStrOfflineOpdPenaltyVal(billConfigUtil.getOpdRefundPenalty());
			formBean.setStrOfflineEmergencyPenaltyVal(billConfigUtil.getEmergencyRefundPenalty());

			formBean.setStrIsEmergencyDiscount(billConfigUtil.getEmergencyDiscountClerk());
			formBean.setStrIsIpdDiscount(billConfigUtil.getIpdDiscountClerk());
			formBean.setStrIsOpdDiscount(billConfigUtil.getOpdDiscountClerk());
			formBean.setStrIsApprovalRequired(billConfigUtil.getGeneralIsApprovalRequired());
			formBean.setStrIsAdvanceRequired(billConfigUtil.getIpdGenAdvanceReq());

			//System.out.println("billConfigUtil.getIpdGenAdvanceReq()="+billConfigUtil.getIpdGenAdvanceReq());
			//System.out.println("billConfigUtil.strIsAdvanceRequired()="+billConfigUtil.ipdGenAdvanceReq);

			if (formBean.getStrOffLineHospitalService().equals("1"))
			{
				voObj.setStrClerkDiscount(formBean.getStrIsOpdDiscount());
			} 
			else if (formBean.getStrOffLineHospitalService().equals("2"))
			{
				voObj.setStrClerkDiscount(formBean.getStrIsIpdDiscount());
			} 
			else
			{
				voObj.setStrClerkDiscount(formBean.getStrIsEmergencyDiscount());
			}
			
			voObj.setStrOffLineRequestType(formBean.getStrOffLineRequestType());
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrCrNo(formBean.getStrCrNo());
			voObj.setStrOffLineHospitalService(formBean.getStrOffLineHospitalService());
			voObj.setStrOffLineBillingService(formBean.getStrOffLineBillingService());
			voObj.setStrSeatId(formBean.getStrSeatId());
			voObj.setStrIsApprovalRequired(formBean.getStrIsApprovalRequired());
			voObj.setStrIsAdvanceRequired(formBean.getStrIsAdvanceRequired());
			voObj.setStrTreatmentCategory(formBean.getStrTreatmentCategory());

			bo.initAdvanceOffLineDetails(voObj);
			
			if (voObj.getStrMsgType().equals("1"))
			{
				throw new Exception(voObj.getStrMsgString());
			}

			util = new HisUtil("Billing", "CashCollectionOffline");
			String temp = "";

			if (voObj.getAdmEpisodeTreatCatDeptDtls() != null && voObj.getAdmEpisodeTreatCatDeptDtls().size() != 0)
			{
				WebRowSet ws=voObj.getAdmEpisodeTreatCatDeptDtls();
				if(voObj.getAdmEpisodeTreatCatDeptDtls().next())
				{
					voObj.setStrOffLineRaisingDepartment(ws.getString(1));
					voObj.setStrOffLineEpisode(ws.getString(2));
					selectedTreatmentCat=ws.getString(4)+"^"+ws.getString(5);	
					voObj.setStrVisitType(ws.getString(6));
					formBean.setStrVisitType(ws.getString(6));
				}
				
			}
			if (voObj.getOfflineHospitalServiceList() != null && voObj.getOfflineHospitalServiceList().size() != 0)
			{
				temp = util.getOptionValue(voObj.getOfflineHospitalServiceList(), voObj.getStrOffLineHospitalService(), "",false);
				formBean.setStrHospitalServiceDetails(temp);
			}
			if (voObj.getOfflineBillingServiceList() != null && voObj.getOfflineBillingServiceList().size() != 0)
			{
				temp = util.getOptionValue(voObj.getOfflineBillingServiceList(), voObj.getStrOffLineBillingService(), "",false);
				formBean.setStrBillingServiceDetails(temp);
			}
			if (voObj.getOfflineRaisingDepartmentList() != null && voObj.getOfflineRaisingDepartmentList().size() != 0)
			{//Last Visited Department Selected
				temp = util.getOptionValue(voObj.getOfflineRaisingDepartmentList(), voObj.getStrOffLineRaisingDepartment(),	"0^Select Value", false);
				formBean.setStrRaisingDepartmentDetails(temp);
			} 
			else
			{
				formBean.setStrRaisingDepartmentDetails("<option value='0'>Select Value</option>");
			}

			if (voObj.getOfflineEpisodeList() != null && voObj.getOfflineEpisodeList().size() != 0)
			{//Last Visited Department Episode
				temp = util.getOptionValue(voObj.getOfflineEpisodeList(), voObj.getStrOffLineEpisode(), "", true);
				formBean.setStrEpisodeDetails(temp);
				formBean.setStrEpisodeFound("1");
			/*	String temp1[] = voObj.getStrOffLineEpisode().replace("@", "#").split("#");
				if (!temp1[1].equals("") || !temp1[1].equals("0"))
				{
					voObj.setStrOffLineTreatmentCategory(temp1[1]);
					voObj.setStrOffLineTreatmentCategoryGroup(temp1[2]);
				}*/
			} 
			else
			{
				formBean.setStrEpisodeFound("0");
				formBean.setStrEpisodeDetails("<option value='0'>Select Value</option>");
			}

			if (voObj.getOfflineTreatmentCategoryList() != null && voObj.getOfflineTreatmentCategoryList().size() != 0)
			{
				temp = util.getOptionValue(voObj.getOfflineTreatmentCategoryList(),selectedTreatmentCat ,	"", false);
				formBean.setStrTreatmentCategoryDetails(temp);
			} 
			else
			{
				formBean.setStrTreatmentCategoryDetails("<option value='0'>Select Value</option>");
			}
			if (voObj.getOfflineWardList() != null && voObj.getOfflineWardList().size() != 0)
			{
				temp = util.getOptionValue(voObj.getOfflineWardList(), voObj.getStrOffLineWard(), "", false, false);
				formBean.setStrWardDetails(temp);
			} 
			else
			{
				formBean.setStrWardDetails("<option value='0'>Select Value</option>");
			}

			if (voObj.getStrClientNameList() != null && voObj.getStrClientNameList().size() != 0)
			{
				temp = util.getOptionValue(voObj.getStrClientNameList(), voObj.getStrOffLineWard(), "0^Select Value", false);
				formBean.setStrClientNameContents(temp);
			} 
			else
			{
				formBean.setStrClientNameContents("<option value='0'>Select Value</option>");
			}

			if (voObj.getStrPaymentModeList() != null && voObj.getStrPaymentModeList().size() != 0)
			{
				temp = util.getOptionValue(voObj.getStrPaymentModeList(), "", "", false);
				formBean.setStrPaymentModeContents(temp);
			}
			if (voObj.getStrQRCodeModeList() != null && voObj.getStrQRCodeModeList().size() != 0)
			{
				
				temp = util.getOptionValue(voObj.getStrQRCodeModeList(), "", "", false);
				formBean.setStrQRCodeModeContents(temp);
			}
			if (bo.isPartPaymentorAdvanceExist(voObj))
			{
				String strPartOrAdvanceDtls = "";

				if (voObj.getStrOffLineBillingService().equals("19"))
				{
					strPartOrAdvanceDtls = CashCollectionOfflineTransHLP.getOffLineAdvanceDetailsView_BS(voObj);
				} 
				else
				{
					strPartOrAdvanceDtls = CashCollectionOfflineTransHLP.getOffLinePartPaymentDetailsView_BS(voObj);
				}
				formBean.setStrPartPayAdvanceAmountDetails(strPartOrAdvanceDtls);
			}
			if (voObj.getStrOffLineBillingService().equals("20") && voObj.getStrOffLineRequestType().equals("2"))
			{
				String strPartOrAdvanceDtls = "";
				strPartOrAdvanceDtls = CashCollectionOfflineTransHLP.getOffLinePartPaymentDetailsView_BS(voObj);

			}
			/*	String strOffLineClientDtls = "";

				// Logics to get Offline Client Details
				if (formBean.getStrOffLineHospitalService().equals("1")
						&& formBean.getStrOpdThirdPartyBenefit().equals("1")
						|| formBean.getStrOffLineHospitalService().equals("2")
						&& formBean.getStrIpdThirdPartyBenefit().equals("1")
						|| formBean.getStrOffLineHospitalService().equals("3")
						&& formBean.getStrEmergencyThirdPartyBenefit().equals("1")) {

					strOffLineClientDtls = CashCollectionOfflineTransHLP
							.getOffLineClientDetailsView(voObj);

				}

				strOffLineClientDtls = strOffLineClientDtls
						+ CashCollectionOfflineTransHLP.getOffLineOtherDetailsView(voObj);

				formBean.setStrOfflineClientDetailsView(strOffLineClientDtls);
			 */
			if (voObj.getOfflineGroupList() != null && voObj.getOfflineGroupList().size() != 0)
			{
				temp = util.getOptionValue(voObj.getOfflineGroupList(), voObj.getStrOffLineWard(), "0^All Group", false);
				formBean.setStrOfflineGroupDetails(temp);
			}

			/*
			 * if (voObj.getOfflineTariffList().size() != 0) {
			 * formBean.setStrOfflineTariffDetails(HisUtil.getDropDown1(voObj
			 * .getOfflineTariffList(), 1, 5, false)); }
			 */

			/*if (voObj.getOfflinePackageGroup() != null
					&& voObj.getOfflinePackageGroup().size() != 0) {
				temp = util.getOptionValue(voObj.getOfflinePackageGroup(),
						voObj.getStrOffLineWard(), "0^All Group", false);

				formBean.setStrOfflinePkgsGroupDetails(temp);
			}
			 */
			//if (voObj.getStrClerkDiscount().equals("1"))
			//{
			System.out.println("A");
				if (voObj.getOfflineDiscountApprovedBy() != null && voObj.getOfflineDiscountApprovedBy().size() != 0)
				{
					System.out.println("B");
					temp = util.getOptionValue(voObj.getOfflineDiscountApprovedBy(), "0", "0^Select Value", false);
					formBean.setStrOfflineDiscountApprovedByDetails(temp);
				}
				if (voObj.getOfflineDiscountRemarks() != null && voObj.getOfflineDiscountRemarks().size() != 0)
				{
					System.out.println("C");
					temp = util.getOptionValue(voObj.getOfflineDiscountRemarks(), "", "", false);
					temp = temp + "<option value='0'>Others</option>";
					formBean.setStrOfflineDiscountRemarksDetails(temp);
				}
			//}

			if (voObj.getStrOffLineRequestType().equals("2"))
			{

				if (voObj.getOfflineApprovedByList() != null && voObj.getOfflineApprovedByList().size() != 0)
				{
					voObj.getOfflineApprovedByList().beforeFirst();
					temp = util.getOptionValue(voObj.getOfflineApprovedByList(), "0", "0^Select Value", false);
					formBean.setStrOffLineRefundByList(temp);
				}
				if (voObj.getOfflineRemarksList() != null && voObj.getOfflineRemarksList().size() != 0)
				{
					voObj.getOfflineRemarksList().beforeFirst();
					temp = util.getOptionValue(voObj.getOfflineRemarksList(), "", "", false);
					temp = temp + "<option value='0'>Others</option>";
					formBean.setStrOffLineRefundReasonDetails(temp);
				} 
				else
				{
					temp = "<option value='0'>Others</option>";
					formBean.setStrOffLineRefundReasonDetails(temp);
				}
			}

			if (voObj.getOfflineSplWardList() != null && voObj.getOfflineSplWardList().size() > 0)
			{
				temp = util.getOptionValue(voObj.getOfflineSplWardList(), voObj.getStrOffLineSpecialWard(),"0^Select Value", false);
			} 
			else
			{
				temp = "<option value='0'>Select Value</option>";
			}
			
			formBean.setStrSpecialWardDetails(temp);

			
			/******Added By vikrant For Cash Collection Offline(Patient Details)**********/
			formBean.setStrRmk(voObj.getStrRmk());
			//formBean.setStrRelatinDetails(voObj.getStrRelationWs());
			
			

			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));
			//formBean.setStrRelatinDetails(voObj.getStrRelationWs());
			formBean.setStrRmk(voObj.getStrRmk());
			
			/*if (voObj.getCreditLettersWS()!= null && voObj.getCreditLettersWS().size() > 0)
			{
				temp = util.getOptionValue(voObj.getCreditLettersWS(), "","0^Select Value", false);
			} 
			else
			{
				temp = "<option value='0'>Select Value</option>";
			}
			formBean.setStrCreditLetterNoList(temp);*/
			
			
			//adding Credit Client Details ....
			
			BillingVO voBilling=new BillingVO();
			voBilling.setStrValue1(voObj.getStrCrNo());
			voBilling.setStrHospitalCode(voObj.getStrHospitalCode());
			voBilling.setStrCatCode(voObj.getStrOffLineTreatmentCategory());
			voBilling.setStrServiceType("1");//1-OP CONSULATION ONLY,OP & INV ,2-IP ONLY & IP & INV
			String creditListCombo=HLPbilling.getCreditLetterListComboOffline_BS(voBilling,"1",true,false,voObj.getStrOffLineHospitalService(),voObj.getStrOffLineBillingService()); 
			formBean.setStrCreditLetterNoList(creditListCombo);
			
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("Billing", "CashCollectionOfflineTransBSDATA->initOffLineDetails()", strmsgText);
			formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} 
		finally
		{
			billConfigUtil = null;
			util = null;
		}
	}

	/**
	 * writes populated Bill Service Combo box (Option List) based on Hospital
	 * Service and Request Type as Ajax Response.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void getBillServiceDetails(HttpServletRequest request, HttpServletResponse response)
	{

		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;
		HisUtil util = null;
		try
		{
			bo = new CashCollectionOfflineTransBO();
			voObj = new CashCollectionOfflineTransVO();

			String strHospitalService = request.getParameter("hService");
			String strRequestType = request.getParameter("requestType");

			if (strHospitalService == null)
				strHospitalService = "0";
			if (strRequestType == null)
				strRequestType = "0";

			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			voObj.setStrOffLineHospitalService(strHospitalService);
			voObj.setStrOffLineRequestType(strRequestType);

			bo.getBillServiceDetails(voObj);

			if (voObj.getStrMsgType().equals("1"))
			{
				throw new Exception(voObj.getStrMsgString());

			}

			util = new HisUtil("Billing Transaction", "CashCollectionTrans");
			String temp = "<option value='0'>Select Value</option>";

			if (voObj.getOfflineBillingServiceList().size() != 0)
			{
				temp = util.getOptionValue(voObj.getOfflineBillingServiceList(), voObj.getStrOffLineBillingService(), "",
						false);

			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e)
		{
			String strmsgText = e.getMessage();
			new HisException("Billing", "CashCollectionOfflineTransBSDATA->getBillServiceDetails()", strmsgText);

		} finally
		{

			bo = null;

			voObj = null;

			util = null;
		}

	}

	/**
	 * writes populated Episode Combo box (Option List) based on Cr Number and
	 * Department Code as Ajax response.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void getEpisodeDetails(HttpServletRequest request, HttpServletResponse response)
	{

		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;
		HisUtil util = null;

		try
		{

			bo = new CashCollectionOfflineTransBO();
			voObj = new CashCollectionOfflineTransVO();

			String strCrNo = request.getParameter("crNo");
			String strDeptCode = request.getParameter("deptCode");

			if (strCrNo == null)
				strCrNo = "0";
			if (strDeptCode == null)
				strDeptCode = "0";

			voObj.setStrCrNo(strCrNo);
			voObj.setStrOffLineRaisingDepartment(strDeptCode);
			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			bo.getEpisodeDetails(voObj);

			if (voObj.getStrMsgType().equals("1"))
			{
				throw new Exception(voObj.getStrMsgString());

			}

			util = new HisUtil("Billing Transaction", "CashCollectionTrans");
			String temp = "<option value='0'>Select Value</option>";
			
			System.out.println("voObj.getOfflineEpisodeList().size()"+voObj.getOfflineEpisodeList().size());

			if (voObj.getOfflineEpisodeList().size() != 0)
			{

				temp = util.getOptionValue(voObj.getOfflineEpisodeList(), voObj.getStrOffLineEpisode(), "", true);

				/*String temp1[] = voObj.getStrOffLineEpisode().replace("@", "#").split("#");

				if (!temp1[1].equals("") || !temp1[1].equals("0"))
				{

					voObj.setStrOffLineTreatmentCategory(temp1[1]);
				}*/  

			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp + "@" + voObj.getStrOffLineTreatmentCategory());

		} catch (Exception e)
		{
			String strmsgText = e.getMessage();
			new HisException("Billing", "CashCollectionOfflineTransBSDATA->getEpisodeDetails()", strmsgText);

		} finally
		{

			bo = null;

			voObj = null;

			util = null;
		}

	}

	/**
	 * writes populated Part Payment or Account Details based on Hospital
	 * Service, Request Type, Bill Service, Treatment Category and Ward Code as
	 * Ajax response.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void getPartPaymentOrAccountDtls(HttpServletRequest request, HttpServletResponse response)
	{

		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;

		try
		{
			bo = new CashCollectionOfflineTransBO();
			voObj = new CashCollectionOfflineTransVO();

			String strHService = request.getParameter("hService");
			String strRequestType = request.getParameter("requestType");
			String strBillService = request.getParameter("billService");
			String strTreatmentCat = request.getParameter("treatmentCat");
			String strWard = request.getParameter("ward");
			String strCrNo = request.getParameter("strCrNo");
			String strSplWard = request.getParameter("strSplWard");

			if (strHService == null)
				strHService = "0";
			if (strRequestType == null)
				strRequestType = "0";
			if (strBillService == null)
				strBillService = "0";
			if (strTreatmentCat == null)
				strTreatmentCat = "0";
			if (strWard == null)
				strWard = "0^0";
			if (strCrNo == null)
				strCrNo = "0";
			if(strWard.equals("0"))
				strWard="0^0";

			if (strSplWard == null)
				strSplWard = "0";

			voObj.setStrOffLineHospitalService(strHService);
			voObj.setStrOffLineRequestType(strRequestType);
			voObj.setStrOffLineBillingService(strBillService);
			voObj.setStrOffLineTreatmentCategory(strTreatmentCat);
			voObj.setStrOffLineSpecialWard(strSplWard);

			String[] strWardDtls = strWard.replace("^", "#").split("#");

			voObj.setStrOffLineWard(strWardDtls[0]);
			voObj.setStrOffLineIpdChargeTypeId(strWardDtls[1]);

			voObj.setStrIsApprovalRequired(new BillConfigUtil(voObj.getStrHospitalCode()).getGeneralIsApprovalRequired());

			voObj.setStrCrNo(strCrNo);
			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			String temp = "";

			if (bo.isPartPaymentorAdvanceExist(voObj))
			{

				bo.getPartPaymentOrAdvanceDtls(voObj);

				if (voObj.getStrMsgType().equals("1"))
				{
					throw new Exception(voObj.getStrMsgString());

				}

				if (voObj.getStrOffLineBillingService().equals("19"))
				{

					temp = CashCollectionOfflineTransHLP.getOffLineAdvanceDetailsView_BS(voObj);
				} else
				{

					temp = CashCollectionOfflineTransHLP.getOffLinePartPaymentDetailsView_BS(voObj);
				}

			} else
			{

				// Hospital Service - 2(IPD) , Request Type - 2(Refund) and Bill
				// Service - 19(Account)

				if (voObj.getStrOffLineHospitalService().equals("2") && voObj.getStrOffLineRequestType().equals("2") && voObj.getStrOffLineBillingService().equals("19"))
				{
					bo.getAdmissionCancellationDtl(voObj);

					if (voObj.getAdmissionCancellationDetails() != null && voObj.getAdmissionCancellationDetails().size() > 0)
					{
						temp = CashCollectionOfflineTransHLP.getAdmissionCancellationDetails(voObj, "2");
					} 
					else
					{
						temp = "@Either Account Not Opened or Patient has been accepted in ward";
					}
				}

				if (voObj.getStrOffLineHospitalService().equals("2") && voObj.getStrOffLineRequestType().equals("2") && voObj.getStrOffLineBillingService().equals("20"))
				{

					bo.getPartPaymentOrAdvanceDtls(voObj);

					if (voObj.getStrMsgType().equals("1"))
					{
						throw new Exception(voObj.getStrMsgString());
					}

					if (voObj.getStrOffLineBillingService().equals("19"))
					{
						temp = CashCollectionOfflineTransHLP.getOffLineAdvanceDetailsView_BS(voObj);
					} 
					else
					{
						temp = CashCollectionOfflineTransHLP.getOffLinePartPaymentDetailsView(voObj);
					}
				}
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e)
		{
			e.printStackTrace();
			String strmsgText = e.getMessage();
			new HisException("Billing", "CashCollectionOfflineTransBSDATA->getPaymentOrAccountDetails()", strmsgText);

		} finally
		{

			bo = null;

			voObj = null;

		}

	}

	/**
	 * returns populated Group Combo box (Option List) based on Hospital Service
	 * and Package Flag as Ajax response.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void getGroupDetails(HttpServletRequest request, HttpServletResponse response)
	{

		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;
		HisUtil util = null;
		String creditListCombo="";

		try
		{
			bo = new CashCollectionOfflineTransBO();
			voObj = new CashCollectionOfflineTransVO();

			String strHospitalService = request.getParameter("hService");
			String strIsPackWiseGroup = request.getParameter("withPack");
			String catCode = request.getParameter("catCode");
			String strCrNo = request.getParameter("strCrNo");
			if (strHospitalService == null)
				strHospitalService = "0";

			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			voObj.setStrOffLineHospitalService(strHospitalService);
			voObj.setStrOffLineIsPackageGroup(strIsPackWiseGroup);

			bo.getGroupDetails(voObj);

			if (voObj.getStrMsgType().equals("1"))
			{
				throw new Exception(voObj.getStrMsgString());

			}

			util = new HisUtil("Billing Transaction", "CashCollectionTrans");
			String temp = "<option value='0'>All Group</option>";

			if (strIsPackWiseGroup.equals("0"))
			{
				if (voObj.getOfflineGroupList().size() != 0)
				{
					temp = util.getOptionValue(voObj.getOfflineGroupList(), "0", "0^All Group", false);
				}
			} 
			else
			{
				if (voObj.getOfflinePackageGroup().size() != 0)
				{
					temp = util.getOptionValue(voObj.getOfflinePackageGroup(), "0", "0^All Group", false);
				}
			}
			
			if(catCode.replace("^","#").split("#").length>=2  && (catCode.replace("^","#").split("#")[1].equals("3") || catCode.replace("^","#").split("#")[1].equals("4")))
			{
				BillingVO voBilling=new BillingVO();
				voBilling.setStrValue1(strCrNo);
				voBilling.setStrHospitalCode(voObj.getStrHospitalCode());
				voBilling.setStrCatCode(catCode);
				voBilling.setStrServiceType("1");//1-OP CONSULATION ONLY,OP & INV ,2-IP ONLY & IP & INV
				creditListCombo=HLPbilling.getCreditLetterListComboOffline_BS(voBilling,"1",true,false,voObj.getStrOffLineHospitalService(),voObj.getStrOffLineBillingService());
			}
			else
				creditListCombo="<option value='0'>Select Value</option>";;
			
			response.setHeader("Cache-Control", "no-cache");
			//System.out.println("temp####creditListCombo::"+temp+"####"+creditListCombo);
			response.getWriter().print(temp+"####"+creditListCombo);
		} 
		catch (Exception e)
		{
			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try
			{
				HisException eObj = new HisException("Billing", "CashCollectionOfflineTransBSDATA->getGroupDetails()", strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1)
			{
				new HisException("Billing", "CashCollectionOfflineTransBSDATA->getGroupDetails()", e1.getMessage());
			}
		} finally
		{

			bo = null;

			voObj = null;

			util = null;
		}

	}

	/**
	 * writes populated Client Details View (HTML) based on Cr Number and
	 * Hospital Service as Ajax Response.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void getClientDetails(HttpServletRequest request, HttpServletResponse response)
	{

		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;

		try
		{
			bo = new CashCollectionOfflineTransBO();
			voObj = new CashCollectionOfflineTransVO();

			String strCrNo = request.getParameter("crNo");
			String strHospitalService = request.getParameter("hService");

			if (strHospitalService == null)
				strHospitalService = "0";

			voObj.setStrCrNo(strCrNo);
			voObj.setStrOffLineHospitalService(strHospitalService);
			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			bo.getOffLineClientDetails(voObj);

			if (voObj.getStrMsgType().equals("1"))
			{
				throw new Exception(voObj.getStrMsgString());

			}

			String temp = CashCollectionOfflineTransHLP.getOffLineClientDetailsView(voObj);

			temp = temp + CashCollectionOfflineTransHLP.getOffLineOtherDetailsView_BS(voObj);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e)
		{
			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try
			{
				HisException eObj = new HisException("Billing", "CashCollectionOfflineTransBSDATA->getClientDetails()", strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1)
			{
				new HisException("Billing", "IpdBillManagementTransDATA->getClientDetails()", e1.getMessage());
			}
		} finally
		{

			bo = null;

			voObj = null;

		}

	}

	/**
	 * gets Online Third Party Amount View as Ajax response.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	/*
	 * public static void getOnlineThirdPartyAmtView(HttpServletRequest request,
	 * HttpServletResponse response) {
	 * 
	 * String strChargeTypeId = (String) request
	 * .getParameter("strChargeTypeId"); String strRequestTypeId = (String)
	 * request .getParameter("strRequestTypeId"); String strBServiceId =
	 * (String) request.getParameter("strBServiceId");
	 * 
	 * String strClientDtlsStauts = (String)
	 * request.getParameter("clientStatus");
	 * 
	 * BillConfigUtil billConfigUtil = new BillConfigUtil();
	 * 
	 * String temp = ""; // condition to check whether charge type id 1 - OPD ,
	 * 2 - IPD , 3 - // Emergency // and whether third party billing in on or
	 * off in the respective cases
	 * 
	 * if (((strChargeTypeId.equals("1") &&
	 * billConfigUtil.getOpdThirdPartyBilling().equals("1")) ||
	 * (strChargeTypeId.equals("2") &&
	 * billConfigUtil.getIpdThirdPartyBilling().equals("1")) ||
	 * (strChargeTypeId.equals("3") &&
	 * billConfigUtil.getEmergencyThirdPartyBilling().equals("1"))) &&
	 * strClientDtlsStauts.equals("1")) { // whether request type : 1 - Receipt &
	 * bill service : 10 - Service if (strRequestTypeId.equals("1") &&
	 * (strBServiceId.equals("10") || strBServiceId .equals("21"))) temp =
	 * CashCollectionOfflineTransHLP .getOnLineThirdPartyAmountDtlView(strBServiceId ,
	 * "1");
	 * 
	 * }else if((strRequestTypeId.equals("1") || strRequestTypeId.equals("2")) &&
	 * strBServiceId .equals("21")){
	 * 
	 * temp = CashCollectionOfflineTransHLP
	 * .getOnLineThirdPartyAmountDtlView(strBServiceId , "2"); }
	 * 
	 * response.setHeader("Cache-Control", "no-cache"); try {
	 * 
	 * response.getWriter().print(temp); } catch (IOException e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * new HisException("Billing",
	 * "IpdBillManagementTransDATA->getOnlineThirdPartyAmtView()",
	 * e.getMessage()); } }
	 */

	/**
	 * gets Off-line Third Party Amount Details as Ajax Response.
	 * 
	 * @param request
	 * @param response
	 */
	/*
	 * public static void getOfflineThirdPartyAmtView(HttpServletRequest
	 * request, HttpServletResponse response) {
	 * 
	 * String strChargeTypeId = (String) request
	 * .getParameter("strChargeTypeId"); String strRequestTypeId = (String)
	 * request .getParameter("strRequestTypeId"); String strBServiceId =
	 * (String) request.getParameter("strBServiceId");
	 * 
	 * String strClientDtlsStauts = (String)
	 * request.getParameter("clientStatus");
	 * 
	 * BillConfigUtil billConfigUtil = new BillConfigUtil();
	 * 
	 * String temp = ""; // condition to check whether charge type id 1 - OPD ,
	 * 3 - Emergency // and whether third party billing in on or off in the
	 * respective cases if (((strChargeTypeId.equals("1") &&
	 * billConfigUtil.getOpdThirdPartyBilling().equals("1")) ||
	 * (strChargeTypeId.equals("3") &&
	 * billConfigUtil.getEmergencyThirdPartyBilling().equals("1"))) &&
	 * strClientDtlsStauts.equals("1")) { // whether request type : 1 - Receipt &
	 * bill service : 10 - Service if (strRequestTypeId.equals("1") &&
	 * strBServiceId.equals("10")) temp = CashCollectionOfflineTransHLP
	 * .getOffLineThirdPartyAmountDtlView(); }
	 * 
	 * response.setHeader("Cache-Control", "no-cache"); try {
	 * 
	 * response.getWriter().print(temp); } catch (IOException e) {
	 * 
	 * new HisException( "Billing",
	 * "IpdBillManagementTransDATA->getOfflineThirdPartyAmtView()",
	 * e.getMessage()); } }
	 */

	/**
	 * writes Populated Tariff Drop Down Combo box (Option List) based on
	 * Selected Group as Ajax Response.
	 * 
	 * @param request
	 * @param response
	 */
	public static void getTariffDetails(HttpServletRequest request, HttpServletResponse response)
	{
		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;
		HisUtil util = null;
		try
		{
			bo = new CashCollectionOfflineTransBO();
			voObj = new CashCollectionOfflineTransVO();

			util = new HisUtil("Billing", "CashCollectionOfflineTransBSDATA.getTariffDetails()");

			String strGroupCode = request.getParameter("groupId");
			String strHospitalService = request.getParameter("hService");
			String strTreatmentCategory = request.getParameter("treatmentCat");
			String strWardCode = request.getParameter("ward");
			String strSearchLetter = request.getParameter("searchLetter");
			String strBillingService= request.getParameter("bService");

			if (strGroupCode == null)
				strGroupCode = "0";
			if (strHospitalService == null)
				strHospitalService = "0";
			if (strTreatmentCategory == null)
				strTreatmentCategory = "0";
			if (strWardCode == null || !strHospitalService.equals("2"))
				strWardCode = "0";

			if (strSearchLetter == null)
				strSearchLetter = "";

			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			voObj.setStrOffLineGroup(strGroupCode);
			voObj.setStrOffLineHospitalService(strHospitalService);
			voObj.setStrOffLineTreatmentCategory(strTreatmentCategory);
			voObj.setStrOffLineWard(strWardCode);
			voObj.setStrSearchLetter(strSearchLetter);
			voObj.setStrOffLineBillingService(strBillingService);

			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			bo.getTariffDetails(voObj);

			if (voObj.getStrMsgType().equals("1"))
			{
				throw new Exception(voObj.getStrMsgString());

			}

			String temp = "";

			if (voObj.getOfflineTariffList().size() != 0)
			{

				// temp = HisUtil.getDropDown(voObj.getOfflineTariffList(), 1,
				// 5, false);
				temp = util.getDropDown(voObj.getOfflineTariffList(), 1, 5, false);
				//System.out.println("temp="+temp);

			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e)
		{
			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try
			{
				HisException eObj = new HisException("Billing", "CashCollectionOfflineTransBSDATA->getTariffDetails()", strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1)
			{
				new HisException("Billing", "IpdBillManagementTransDATA->getTariffDetails()", e1.getMessage());
			}
		} finally
		{

			bo = null;

			voObj = null;
		}

	}
	
	public static void getTariffCodeDetailsDrug(HttpServletRequest request, HttpServletResponse response)
	{

		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;

		try
		{
			bo = new CashCollectionOfflineTransBO();
			voObj = new CashCollectionOfflineTransVO();

			String strGroupCode = request.getParameter("groupId");
			String strHospitalService = request.getParameter("hService");
			String strTreatmentCategory = request.getParameter("treatmentCat");
			String strWardCode = request.getParameter("ward");
			String strTariffCode = request.getParameter("tariffCode");
			String strBillingService= request.getParameter("bService");

			if (strGroupCode == null)
				strGroupCode = "0";
			if (strHospitalService == null)
				strHospitalService = "0";
			if (strTreatmentCategory == null)
				strTreatmentCategory = "0";
			if (strWardCode == null || !strHospitalService.equals("2"))
				strWardCode = "0";

			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			voObj.setStrOffLineGroup(strGroupCode);
			voObj.setStrOffLineHospitalService(strHospitalService);
			voObj.setStrOffLineTreatmentCategory(strTreatmentCategory);
			voObj.setStrOffLineWard(strWardCode);
			voObj.setStrTariffCode(strTariffCode);
			voObj.setStrOffLineBillingService(strBillingService);

			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			bo.getTariffCodeDetailsDrug(voObj);

			if (voObj.getStrMsgType().equals("1"))
			{
				throw new Exception(voObj.getStrMsgString());

			}

			String temp = "";

			if (voObj.getOfflineTariffList().size() != 0)
			{

				if (voObj.getOfflineTariffList().next())
				{

					temp = "1@@" + voObj.getOfflineTariffList().getString(2) + "@@" + voObj.getOfflineTariffList()
							.getString(1);
				}

			} else
			{

				temp = "0@@_@@0";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e)
		{
			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try
			{
				HisException eObj = new HisException("Billing", "CashCollectionOfflineTransBSDATA->getTariffCodeDetails()",
						strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1)
			{
				new HisException("Billing", "IpdBillManagementTransDATA->getTariffCodeDetails()", e1.getMessage());
			}
		} finally
		{

			bo = null;

			voObj = null;
		}

	}

	/**
	 * writes tariff Details based on
	 * Tariff Code as Ajax Response.
	 * 
	 * @param request
	 * @param response
	 */
	public static void getTariffCodeDetails(HttpServletRequest request, HttpServletResponse response)
	{

		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;

		try
		{
			bo = new CashCollectionOfflineTransBO();
			voObj = new CashCollectionOfflineTransVO();

			String strGroupCode = request.getParameter("groupId");
			String strHospitalService = request.getParameter("hService");
			String strTreatmentCategory = request.getParameter("treatmentCat");
			String strWardCode = request.getParameter("ward");
			String strTariffCode = request.getParameter("tariffCode");
			String strBillingService= request.getParameter("bService");

			if (strGroupCode == null)
				strGroupCode = "0";
			if (strHospitalService == null)
				strHospitalService = "0";
			if (strTreatmentCategory == null)
				strTreatmentCategory = "0";
			if (strWardCode == null || !strHospitalService.equals("2"))
				strWardCode = "0";

			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			voObj.setStrOffLineGroup(strGroupCode);
			voObj.setStrOffLineHospitalService(strHospitalService);
			voObj.setStrOffLineTreatmentCategory(strTreatmentCategory);
			voObj.setStrOffLineWard(strWardCode);
			voObj.setStrTariffCode(strTariffCode);
			voObj.setStrOffLineBillingService(strBillingService);

			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			bo.getTariffCodeDetails(voObj);

			if (voObj.getStrMsgType().equals("1"))
			{
				throw new Exception(voObj.getStrMsgString());

			}

			String temp = "";

			if (voObj.getOfflineTariffList().size() != 0)
			{

				if (voObj.getOfflineTariffList().next())
				{

					temp = "1@@" + voObj.getOfflineTariffList().getString(2) + "@@" + voObj.getOfflineTariffList()
							.getString(1);
				}

			} else
			{

				temp = "0@@_@@0";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e)
		{
			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try
			{
				HisException eObj = new HisException("Billing", "CashCollectionOfflineTransBSDATA->getTariffCodeDetails()",
						strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1)
			{
				new HisException("Billing", "IpdBillManagementTransDATA->getTariffCodeDetails()", e1.getMessage());
			}
		} finally
		{

			bo = null;

			voObj = null;
		}

	}

	/**
	 * writes Package Details based on rowIndex as Ajax Response.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void getPackageDetails(HttpServletRequest request, HttpServletResponse response)
	{

		CashCollectionOfflineTransVO voObj = null;

		try
		{

			voObj = new CashCollectionOfflineTransVO();

			String strRowIndex = request.getParameter("rowIndex");

			if (strRowIndex == null)
				strRowIndex = "0";

			voObj.setStrOffLinePackageIndex(strRowIndex);

			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			String temp = CashCollectionOfflineTransHLP.getOffLinePackageDetailsView(voObj);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strRowIndex + "@" + temp);

		} catch (Exception e)
		{
			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try
			{
				HisException eObj = new HisException("Billing", "CashCollectionOfflineTransBSDATA->getPackageDetails()", strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1)
			{
				new HisException("Billing", "IpdBillManagementTransDATA->getPackageDetails()", e1.getMessage());
			}
		} finally
		{

			voObj = null;
		}

	}

	/**
	 * writes Tariff Unit Combo (Option list) based on RowIndex, Unit Id and
	 * Base Value as Ajax Response.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void getOffLineTariffUnitDetails(HttpServletRequest request, HttpServletResponse response)
	{

		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;
		HisUtil util = null;

		try
		{

			bo = new CashCollectionOfflineTransBO();
			voObj = new CashCollectionOfflineTransVO();

			String strRowIndex = request.getParameter("rowIndex");
			String strUnitId = request.getParameter("unitId");
			String strUnitBaseVal = request.getParameter("baseValue");

			if (strRowIndex == null)
				strRowIndex = "0";
			if (strUnitId == null)
				strUnitId = "0";
			if (strUnitBaseVal == null)
				strUnitBaseVal = "0";

			voObj.setStrOffLineTariffUnitTempId(strUnitId);
			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			String temp = "<option value='0'>Select Value</option>";

			/*bo.getOffLineTariffUnitDetails(voObj);

			if (voObj.getStrMsgType().equals("1"))
			{
				throw new Exception(voObj.getStrMsgString());

			}

			util = new HisUtil("Billing Transaction", "CashCollectionTrans");

			

			if (voObj.getOfflineTariffUnit().size() != 0)
			{

				temp = util.getOptionValue(voObj.getOfflineTariffUnit(), strUnitId + "^" + strUnitBaseVal, "", false);

			}*/
			temp = BillConfigUtil.getDefaultUnitComboWithBaseValue(strUnitId + "^" + strUnitBaseVal);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strRowIndex + "@" + temp);

		} catch (Exception e)
		{
			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try
			{
				HisException eObj = new HisException("Billing", "CashCollectionOfflineTransBSDATA->getOffLineTariffUnitDetails()",
						strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1)
			{
				new HisException("Billing", "IpdBillManagementTransDATA->getOffLineTariffUnitDetails()", e1.getMessage());
			}
		} finally
		{

			bo = null;

			voObj = null;

			util = null;
		}

	}

	/**
	 * writes Refund Bill Details (HTML) in String Format by Retrieving Cr No.
	 * and Charge Type Id as Ajax Response.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void getOffLineRefundBillDetails(HttpServletRequest request, HttpServletResponse response)
	{
		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;
		try
		{
			bo = new CashCollectionOfflineTransBO();
			voObj = new CashCollectionOfflineTransVO();

			String strCrNo = request.getParameter("crNo");
			String strChargeType = request.getParameter("chargeType");
			String strAccNo = request.getParameter("accNo");

			if (strCrNo == null)
				strCrNo = "0";
			if (strChargeType == null)
				strChargeType = "0";

			voObj.setStrCrNo(strCrNo);
			voObj.setStrOffLineHospitalService(strChargeType);
			voObj.setStrOffLineAccountNo(strAccNo);
			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			bo.getOffLineBillDetails(voObj);

			if (voObj.getStrMsgType().equals("1"))
			{

				throw new Exception(voObj.getStrMsgString());
			}

			String temp = CashCollectionOfflineTransHLP.getBillDetails(voObj);

			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			if (!voObj.getStrOffLineBillNumber().equals("0"))
			{

				bo.getOffLineBillTariffDetails(voObj);

				if (voObj.getStrMsgType().equals("1"))
				{

					throw new Exception(voObj.getStrMsgString());

				}

				temp = temp + "@" + CashCollectionOfflineTransHLP.getTariffDetails(voObj);

			}
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e)
		{

			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try
			{
				HisException eObj = new HisException("Billing", "CashCollectionOfflineTransBSDATA->getOffLineRefundBillDetails()",
						strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1)
			{
				new HisException("Billing", "IpdBillManagementTransDATA->getOffLineRefundBillDetails()", e1.getMessage());
			}
		} finally
		{

			bo = null;

			voObj = null;

		}

	}
	public static void getOffLineRefundBillDetails_BS(HttpServletRequest request, HttpServletResponse response)
	{
		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;
		try
		{
			bo = new CashCollectionOfflineTransBO();
			voObj = new CashCollectionOfflineTransVO();

			String strCrNo = request.getParameter("crNo");
			String strChargeType = request.getParameter("chargeType");
			String strAccNo = request.getParameter("accNo");

			if (strCrNo == null)
				strCrNo = "0";
			if (strChargeType == null)
				strChargeType = "0";

			voObj.setStrCrNo(strCrNo);
			voObj.setStrOffLineHospitalService(strChargeType);
			voObj.setStrOffLineAccountNo(strAccNo);
			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			bo.getOffLineBillDetails(voObj);

			if (voObj.getStrMsgType().equals("1"))
			{

				throw new Exception(voObj.getStrMsgString());
			}

			String temp = CashCollectionOfflineTransHLP.getBillDetails_BS(voObj);

			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			if (!voObj.getStrOffLineBillNumber().equals("0"))
			{

				bo.getOffLineBillTariffDetails(voObj);

				if (voObj.getStrMsgType().equals("1"))
				{

					throw new Exception(voObj.getStrMsgString());

				}

				temp = temp + "@" + CashCollectionOfflineTransHLP.getTariffDetailsBS(voObj);

			}
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e)
		{

			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try
			{
				HisException eObj = new HisException("Billing", "CashCollectionOfflineTransBSDATA->getOffLineRefundBillDetails()",
						strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1)
			{
				new HisException("Billing", "IpdBillManagementTransDATA->getOffLineRefundBillDetails()", e1.getMessage());
			}
		} finally
		{

			bo = null;

			voObj = null;

		}

	}
	public static void getOffLinePartPayRefundBillDetails(HttpServletRequest request, HttpServletResponse response)
	{
		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;
		try
		{
			bo = new CashCollectionOfflineTransBO();
			voObj = new CashCollectionOfflineTransVO();

			String strCrNo = request.getParameter("crNo");
			String strChargeType = request.getParameter("chargeType");
			String strAccNo = request.getParameter("accNo");

			if (strCrNo == null)
				strCrNo = "0";
			if (strChargeType == null)
				strChargeType = "0";

			voObj.setStrCrNo(strCrNo);
			voObj.setStrOffLineHospitalService(strChargeType);
			voObj.setStrOffLineAccountNo(strAccNo);
			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			//bo.getOffLineBillDetails(voObj);
			bo.getOffLinePartPayBillDetails(voObj);
			if (voObj.getStrMsgType().equals("1"))
			{

				throw new Exception(voObj.getStrMsgString());
			}

			String temp = CashCollectionOfflineTransHLP.getOffLinePartPayRefundBillDetails(voObj);

			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			/*if (!voObj.getStrOffLineBillNumber().equals("0")) {
				
				bo.getOffLineBillTariffDetails(voObj);

				if (voObj.getStrMsgType().equals("1")) {

					throw new Exception(voObj.getStrMsgString());

				}

				temp = temp + "@"
						+ CashCollectionOfflineTransHLP.getTariffDetails(voObj);

			}*/
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e)
		{

			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try
			{
				HisException eObj = new HisException("Billing", "CashCollectionOfflineTransBSDATA->getOffLineRefundBillDetails()",
						strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1)
			{
				new HisException("Billing", "IpdBillManagementTransDATA->getOffLineRefundBillDetails()", e1.getMessage());
			}
		} finally
		{

			bo = null;

			voObj = null;

		}

	}

	/**
	 * writes Refund Bill Tariff Details (HTML) in String Format by Retrieving
	 * Bill Number and Account Number as Ajax Response.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void getOffLineRefundBillTariffDetails(HttpServletRequest request, HttpServletResponse response)
	{
		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;

		try
		{
			bo = new CashCollectionOfflineTransBO();
			voObj = new CashCollectionOfflineTransVO();

			String strBillNo = request.getParameter("billNo");
			String strAccNo = request.getParameter("accNo");
			String strHospService = request.getParameter("hospService");

			if (strBillNo == null)
				strBillNo = "0";
			if (strAccNo == null)
				strAccNo = "0";

			voObj.setStrOffLineBillNumber(strBillNo);
			voObj.setStrOffLineAccountNo(strAccNo);
			voObj.setStrOffLineHospitalService(strHospService);
			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			bo.getOffLineBillTariffDetails(voObj);

			if (voObj.getStrMsgType().equals("1"))
			{
				throw new Exception(voObj.getStrMsgString());
			}

			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());


			// Calling TariffDtls
			String temp = CashCollectionOfflineTransHLP.getTariffDetailsBS(voObj);
			String[] TestData = temp.split("\\####");
			response.setHeader("Cache-Control", "no-cache");
			if (TestData[0].equals("ERROR"))
			{
				throw new Exception(TestData[1]);
			} else
			{
				response.getWriter().print(temp);
			}
		} catch (Exception e)
		{

			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try
			{
				HisException eObj = new HisException("Billing",
						"CashCollectionOfflineTransBSDATA->getOffLineRefundBillTariffDetails()", strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1)
			{
				new HisException("Billing", "IpdBillManagementTransDATA->getOffLineRefundBillTariffDetails()", e1
						.getMessage());
			}
		} finally
		{

			bo = null;

			voObj = null;

		}

	}

	/**
	 * writes Refund Bill Tariff Details (HTML) in String Format by Retrieving
	 * Bill Number and Account Number as Ajax Response.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void getOffLineRefundPartPayBillTariffDetails(HttpServletRequest request, HttpServletResponse response)
	{

		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;

		try
		{

			bo = new CashCollectionOfflineTransBO();
			voObj = new CashCollectionOfflineTransVO();

			String strBillNo = request.getParameter("billNo");
			String strAccNo = request.getParameter("accNo");
			String strHospService = request.getParameter("hospService");

			if (strBillNo == null)
				strBillNo = "0";
			if (strAccNo == null)
				strAccNo = "0";

			voObj.setStrOffLineBillNumber(strBillNo);
			voObj.setStrOffLineAccountNo(strAccNo);
			voObj.setStrOffLineHospitalService(strHospService);
			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			bo.getOffLineBillTariffDetails(voObj);

			if (voObj.getStrMsgType().equals("1"))
			{
				throw new Exception(voObj.getStrMsgString());

			}

			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			// String temp = CashCollectionOfflineTransHLP.getTariffDetails(voObj);
			// Calling TariffDtls
			String temp = CashCollectionOfflineTransHLP.getPartPaymentCancellationDetails(voObj, "2");
			String[] TestData = temp.split("\\####");
			// System.out.println("TestData[0]--->"+TestData[0]);
			// System.out.println("TestData[1]--->"+TestData[1]);
			response.setHeader("Cache-Control", "no-cache");
			if (TestData[0].equals("ERROR"))
			{
				throw new Exception(TestData[1]);
			} else
			{
				response.getWriter().print(temp);
			}
		} catch (Exception e)
		{

			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try
			{
				HisException eObj = new HisException("Billing",
						"CashCollectionOfflineTransBSDATA->getOffLineRefundBillTariffDetails()", strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1)
			{
				new HisException("Billing", "IpdBillManagementTransDATA->getOffLineRefundBillTariffDetails()", e1
						.getMessage());
			}
		} finally
		{

			bo = null;

			voObj = null;

		}

	}

	/**
	 * writes Refund Bill Tariff Pop-up Details (HTML) in String Format by
	 * Retrieving hidden Value as Ajax Response.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void getOffLineRefundBillTariffPopupDetails(HttpServletRequest request, HttpServletResponse response)
	{

		CashCollectionOfflineTransVO voObj = null;

		try
		{

			voObj = new CashCollectionOfflineTransVO();

			String strHidVal = request.getParameter("hidValue");

			if (strHidVal == null)
				strHidVal = "0";

			voObj.setStrOffLineTariffDetailsHiddenValue(strHidVal);
			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			String temp = CashCollectionOfflineTransHLP.getPopUp(voObj);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e)
		{
			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try
			{
				HisException eObj = new HisException("Billing",
						"CashCollectionOfflineTransBSDATA->getOfflineTariffUnitBillDetails()", strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1)
			{
				new HisException("Billing", "IpdBillManagementTransDATA->getOfflineTariffUnitBillDetails()", e1
						.getMessage());
			}
		} finally
		{

			voObj = null;

		}

	}

	/**
	 * gets Unit Values as Ajax Response.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void UNITVAL12(HttpServletRequest request, HttpServletResponse response)
	{
		// Declaring Variables
		String strData = request.getParameter("modName");

		String strTariffDtl = "";
		String strTariffDtl1 = "";
		// String msgStr = "";
		String[] data = strData.split("\\^");

		// Creating Object for BO & VO.
		CashCollectionOfflineTransVO vo = new CashCollectionOfflineTransVO();

		try
		{
			String strHospCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			// Calling TariffDtls
			strTariffDtl1 = HLPTariffDtl.getTariffDtl(data[0], data[1], strHospCode);
			strTariffDtl = strTariffDtl1 + '@' + data[2];

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strTariffDtl);

		} catch (Exception e)
		{

			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try
			{
				HisException eObj = new HisException("Billing", "CashCollectionOfflineTransBSDATA->UNITVAL12()", strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1)
			{

				new HisException("Billing", "IpdBillManagementTransDATA->UNITVAL12()", e1.getMessage());
			}
		} finally
		{

			if (vo != null)
				vo = null;
		}

	}

	/**
	 * gets Bills list as Ajax Response.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 */
	public static void getBillListingDtls(HttpServletRequest request, HttpServletResponse response,
			CashCollectionOfflineTransFB formBean)
	{

		CashCollectionOfflineTransVO voObj = null;
		CashCollectionOfflineTransBO bo = null;

		try
		{

			voObj = new CashCollectionOfflineTransVO();
			bo = new CashCollectionOfflineTransBO();

			String strSearchString = request.getParameter("searchString");
			String strFromRow = request.getParameter("fromRow");
			String strRowPerPage = request.getParameter("rowPerPage");
			String strCtBlockSet = request.getParameter("ctBlockSet");
			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			if (strSearchString.contains("^"))
			{
				strSearchString = strSearchString.replace('^', '%');
			}

			voObj.setStrBillSearchString(strSearchString);

			voObj.setStrBillFromRow(strFromRow);

			int nToRow = Integer.parseInt(strFromRow) + Integer.parseInt(strRowPerPage) * 10;

			voObj.setStrBillToRow(String.valueOf(nToRow));
			voObj.setStrBillRowPerPage(strRowPerPage);
			voObj.setStrBillCtBlockSet(strCtBlockSet);

			bo.getBillListingDtl(voObj);

			if (voObj.getStrMsgType().equals("0"))
			{

				String val = CashCollectionOfflineTransHLP.getBillListingView(voObj);

				response.setHeader("Cache-Control", "no-cache");

				response.getWriter().print(val);

			} else
			{

				throw new Exception(voObj.getStrMsgString());

			}

		} catch (Exception e)
		{

			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try
			{
				HisException eObj = new HisException("Billing", "CashCollectionOfflineTransBSDATA->getBillListingDtls()", strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1)
			{
				new HisException("Billing", "IpdBillManagementTransDATA->getBillListingDtls()", e1.getMessage());
			}
		} finally
		{

			bo = null;

			voObj = null;
		}
	}

	public static void getOfflineRaisingDetapartmentDtls(HttpServletRequest request, HttpServletResponse response)
	{

		CashCollectionOfflineTransVO voObj = null;
		CashCollectionOfflineTransBO bo = null;
		HisUtil util = null;

		String temp = "";

		try
		{

			voObj = new CashCollectionOfflineTransVO();
			bo = new CashCollectionOfflineTransBO();
			util = new HisUtil("Cash Collection Trans", "CashCollectionOfflineTransBSDATA.getOfflineRaisingDetapartmentDtls()");

			String strCrNo = request.getParameter("strCrNo");
			String strHospitalService = request.getParameter("strChargeTypeId");
			String strDept = request.getParameter("strDept");

			if (strCrNo == null)
				strCrNo = "0";
			if (strHospitalService == null)
				strHospitalService = "0";

			voObj.setStrCrNo(strCrNo);

			voObj.setStrOffLineHospitalService(strHospitalService);
			voObj.setStrOffLineRaisingDepartment(strDept);

			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			bo.getOfflineRaisingDepartmentDtl(voObj);

			if (voObj.getOfflineRaisingDepartmentList() != null && voObj.getOfflineRaisingDepartmentList().size() > 0)
			{

				temp = util.getOptionValue(voObj.getOfflineRaisingDepartmentList(), voObj.getStrOffLineRaisingDepartment(),
						"", false);

			} else
			{

				temp = "<option value='0'>Select Value</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e)
		{
			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try
			{
				HisException eObj = new HisException("Billing",
						"CashCollectionOfflineTransBSDATA->getOfflineRaisingDetapartmentDtls()", strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1)
			{
				new HisException("Billing", "IpdBillManagementTransDATA->getOfflineRaisingDetapartmentDtls()", e1
						.getMessage());
			}
		} finally
		{

			voObj = null;
			bo = null;
			util = null;

		}

	}

	public static void getOfflineTreatmentCategoryDtls(HttpServletRequest request, HttpServletResponse response)
	{

		CashCollectionOfflineTransVO voObj = null;
		CashCollectionOfflineTransBO bo = null;
		HisUtil util = null;

		String temp = "";

		try
		{

			voObj = new CashCollectionOfflineTransVO();
			bo = new CashCollectionOfflineTransBO();
			util = new HisUtil("Cash Collection Trans", "CashCollectionOfflineTransBSDATA.getOfflineTreatmentCategoryDtls()");

			String strCrNo = request.getParameter("strCrNo");
			String strHospitalService = request.getParameter("strChargeTypeId");
			String strTreatCat = request.getParameter("strTreatCat");

			if (strCrNo == null)
				strCrNo = "0";
			if (strHospitalService == null)
				strHospitalService = "0";

			voObj.setStrCrNo(strCrNo);

			voObj.setStrOffLineHospitalService(strHospitalService);
			voObj.setStrOffLineTreatmentCategory(strTreatCat);

			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			bo.getOfflineTreatmentCategoryDtl(voObj);

			if (voObj.getOfflineTreatmentCategoryList() != null && voObj.getOfflineTreatmentCategoryList().size() > 0)
			{

				temp = util.getOptionValue(voObj.getOfflineTreatmentCategoryList(), voObj.getStrOffLineTreatmentCategory(),
						"", false);

			} else
			{

				temp = "<option value='0'>Select Value</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e)
		{
			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try
			{
				HisException eObj = new HisException("Billing",
						"CashCollectionOfflineTransBSDATA->getOfflineTreatmentCategoryDtls()", strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1)
			{
				new HisException("Billing", "IpdBillManagementTransDATA->getOfflineTreatmentCategoryDtls()", e1
						.getMessage());
			}
		} finally
		{

			voObj = null;
			bo = null;
			util = null;

		}

	}

	public static void getOfflineWardDtls(HttpServletRequest request, HttpServletResponse response)
	{

		CashCollectionOfflineTransVO voObj = null;
		CashCollectionOfflineTransBO bo = null;
		HisUtil util = null;

		String temp = "";

		try
		{

			voObj = new CashCollectionOfflineTransVO();
			bo = new CashCollectionOfflineTransBO();
			util = new HisUtil("Cash Collection Trans", "CashCollectionOfflineTransBSDATA.getOfflineWardDtls()");

			String strCrNo = request.getParameter("strCrNo");
			String strHospitalService = request.getParameter("strChargeTypeId");
			String strWard = request.getParameter("strWard");

			if (strCrNo == null)
				strCrNo = "0";
			if (strHospitalService == null)
				strHospitalService = "0";

			voObj.setStrCrNo(strCrNo);

			voObj.setStrOffLineHospitalService(strHospitalService);
			voObj.setStrOffLineWard(strWard);

			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			bo.getOfflineWardDtl(voObj);

			if (voObj.getOfflineWardList() != null && voObj.getOfflineWardList().size() > 0)
			{

				temp = "<option value='0'>Select Value</option>"+ util.getOptionValue(voObj.getOfflineWardList(), voObj.getStrOffLineWard(), "", false, false);

			} else
			{

				temp = "<option value='0'>Select Value</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e)
		{
			//e.printStackTrace();

			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try
			{
				HisException eObj = new HisException("Billing", "CashCollectionOfflineTransBSDATA->getOfflineWardDtls()", strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1)
			{
				new HisException("Billing", "IpdBillManagementTransDATA->getOfflineWardDtls()", e1.getMessage());
			}
		} finally
		{

			voObj = null;
			bo = null;
			util = null;

		}

	}

	public static void getOfflineSpecialWardDtls(HttpServletRequest request, HttpServletResponse response)
	{

		CashCollectionOfflineTransVO voObj = null;
		CashCollectionOfflineTransBO bo = null;
		HisUtil util = null;

		String temp = "";

		try
		{

			voObj = new CashCollectionOfflineTransVO();
			bo = new CashCollectionOfflineTransBO();
			util = new HisUtil("Cash Collection Trans", "CashCollectionOfflineTransBSDATA.getOfflineSpecialWardDtls()");

			String strDept = request.getParameter("strDept");

			voObj.setStrOffLineRaisingDepartment(strDept);

			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			bo.getOfflineSpecialWardDtl(voObj);

			if (voObj.getOfflineSplWardList() != null && voObj.getOfflineSplWardList().size() > 0)
			{

				temp = "<option value='0'>Select Value</option>"+ util.getOptionValue(voObj.getOfflineSplWardList(), voObj.getStrOffLineSpecialWard(), "", false,false);

			} else
			{

				temp = "<option value='0'>Select Value</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e)
		{
			e.printStackTrace();

			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try
			{
				HisException eObj = new HisException("Billing", "CashCollectionOfflineTransBSDATA->getOfflineSpecialWardDtls()",
						strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1)
			{
				new HisException("Billing", "IpdBillManagementTransDATA->getOfflineSpecialWardDtls()", e1.getMessage());
			}
		} finally
		{

			voObj = null;
			bo = null;
			util = null;

		}

	}

	public static void updatePrintStatus(HttpServletRequest request, HttpServletResponse response)
	{

		try
		{

			String strBillNo = request.getParameter("billNo");
			String strReceiptNo = request.getParameter("recNo");

			if (strBillNo == null)
				strBillNo = "0";
			if (strReceiptNo == null)
				strReceiptNo = "0";

			PrintHLP.updatePrintStatus(strBillNo, strReceiptNo, request.getSession().getAttribute("HOSPITAL_CODE")
					.toString(), "0");

		} catch (Exception e)
		{

			HisException eObj = new HisException("Billing", "CashCollectionOfflineTransDATA->updatePrintStatus()", e
					.getMessage());
			String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";

			eObj = null;

			try
			{
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(response1);
			} catch (IOException e1)
			{

				new HisException("Billing", "CashCollectionOfflineTransDATA->updatePrintStatus()", e1.getMessage());
			}

		}
	}

	/**
	 * Re-Print's the bill.
	 * @param request
	 * @param response
	 */
	public static void rePrint(HttpServletRequest request, HttpServletResponse response)
	{

		try
		{

			PrintHLP.reprintFile(request);

		} catch (Exception e)
		{

			HisException eObj = new HisException("Billing", "CashCollectionOfflineTransDATA->rePrint()", e.getMessage());
			String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";

			eObj = null;

			try
			{
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(response1);
			} catch (IOException e1)
			{

				new HisException("Billing", "CashCollectionOfflineTransDATA->rePrint()", e1.getMessage());
			}

		}
	}

	/**
	 * Inserts Off-line Receipt Part Payment Details.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return true, if insert off-line receipt part payment
	 */
	public static boolean insertOfflineReceiptPartPayment(CashCollectionOfflineTransFB formBean,HttpServletRequest request)
	{

		boolean fRes = false;
		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;
		HisUtil hisUtil = null;
		try
		{
			bo = new CashCollectionOfflineTransBO();
			hisUtil = new HisUtil("Billing", "CashCollectionOfflineTransBSDATA");
			formBean.setStrOffLineClientPatientNo(formBean.getStrOffLineClientDetailsHidden().replace("^", "#").split("#")[0]);
			formBean.setStrOffLineAdmissionNo(formBean.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[0]);
			String[] strWardDtls = formBean.getStrOffLineWard().replace("^", "#").split("#");
			formBean.setStrOffLineWard(strWardDtls[0]);
			formBean.setStrOffLineIpdChargeTypeId(strWardDtls[1]);
			formBean.setStrOffLineEpisode(formBean.getStrOffLineEpisode().replace("^", "#").split("#")[0]);
			formBean.setStrOffLinePartPaymentAmount(formBean.getStrPartpayment());

			//formBean.setadvSecFlag(formBean.getadvSecFlag());

			formBean.setStrOffLineApprovedBy(formBean.getStrApprovedByCombo());
			formBean.setStrOffLineRemarks(formBean.getStrRemarksCombo2());

			voObj = (CashCollectionOfflineTransVO) TransferObjectFactory.populateData("billing.transactions.CashCollectionOfflineTransVO", formBean);

			voObj.setStrOffLineTreatmentCategory(formBean.getStrOffLineTreatmentCategory().replace("^", "#").split("#")[0]);
			bo.insertOfflineReceiptPartPayment(voObj);

			formBean.setStrBillNo(voObj.getStrBillNo());
			formBean.setStrReceiptNo("1");
			//formBean.setStrCrNo("");

			if (!voObj.getStrMsgType().equals("1"))
			{
				//String smsMsg="You Paid Rs. "+formBean.getStrOfflineTotalRecAmount()+" for IPD Account Recharge Against Receipt No. "+formBean.getStrBillNo()+ "/1";
				String smsMsg="Dear "+formBean.getStrPatientDtlHidVal().replace("^","#").split("#")[7]  +", Payment of Rs. "+formBean.getStrOfflineTotalRecAmount()+" Received Against Bill No. "+formBean.getStrBillNo()+ "/1 on "+hisUtil.getDSDate("")+" "+hisUtil.getDSDate("hh:mi:ss:AM")+". "+formBean.getStrPatientDtlHidVal().replace("^","#").split("#")[15];
				if(formBean.getStrMobileNo()!=null && !formBean.getStrMobileNo().equals(""))
					voObj.setStrMobileNo(formBean.getStrMobileNo());
				else
					voObj.setStrMobileNo(formBean.getStrPatientDtlHidVal().replace("^","#").split("#")[13]);
				//System.out.println("formBean.getStrMobileNo()"+formBean.getStrMobileNo());
				final String   smsmessage  = smsMsg;
				final String patMobileNo=voObj.getStrMobileNo();
				/**Added by Vasu on 25.June for SMS Configuration*/
				/*
				 * if(patMobileNo!=null && !patMobileNo.equals("")){ //code from sending message
				 * through CDAC MUmbai SMS Gateway
				 * //SMSHttpPostClient.sendSingleSMSThroughSMSGateway(objSMSConfig.sms_username,
				 * objSMSConfig.sms_password,objSMSConfig.sms_senderId,objSMSConfig.sms_url,
				 * patientVO.getPatAddMobileNo(),message); new Thread( new Runnable() { public
				 * void run(){
				 * 
				 * SMSHttpPostClient.sendSMS (patMobileNo,smsmessage);
				 * 
				 * return; // to stop the thread } }).start(); }
				 */
				
				
				//Code Commented For SMS Serv ice Service taking time so code started in new thread
				//SMSHttpPostClient.sendSMS (voObj.getStrMobileNo(), smsMsg);
				if(patMobileNo!=null && !patMobileNo.equals(""))
					SMSHttpPostClient.sendSMS (patMobileNo,smsmessage);
				//{
					 //code from sending message through CDAC MUmbai SMS Gateway
					 //SMSHttpPostClient.sendSingleSMSThroughSMSGateway(objSMSConfig.sms_username, objSMSConfig.sms_password,objSMSConfig.sms_senderId,objSMSConfig.sms_url, patientVO.getPatAddMobileNo(),message);
					/*
					 * new Thread( new Runnable() { public void run(){
					 * 
					 * SMSHttpPostClient.sendSMS (patMobileNo,smsmessage);
					 * 
					 * return; // to stop the thread } }).start(); }
					 */
				
				PrintHLP.PART_PAYMENT(formBean.getStrBillNo(), formBean.getStrOffLineBillingService(), formBean
						.getStrHospitalCode(), formBean.getStrReceiptNo(), request, 0,"");

				String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
				formBean.setFilePath(fileName);
				request.setAttribute("filePath", fileName);
				formBean.setIsOpenPopUp("1");
				
				formBean.setStrNormalMsg("Receipt No. '" + formBean.getStrBillNo() + "/1" + "' Generated Successfully for the Collected Amount <i class='fas fa-rupee-sign'></i> '" + HisUtil
								.getAmountWithDecimal(formBean.getStrOfflineTotalRecAmount(), 2) + "'");

				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo("1");
				fRes = true;
			} 
			else
			{
				String err = voObj.getStrMsgString();
				fRes = false;
				throw new Exception(err);
			}

		} catch (Exception e)
		{

			HisException eObj = new HisException("Billing Transaction",
					"CashCollectionOfflineTransBSDATA.insertOfflineReceiptPartPayment()-->", e.getMessage());

			formBean
					.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		}

		return fRes;

	}

	/**
	 * Inserts Off-line Receipt Advance Details.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return true, if insert off-line receipt advance
	 */
	public static boolean insertOfflineReceiptAdvance(CashCollectionOfflineTransFB formBean, HttpServletRequest request)
	{

		boolean fRes = false;
		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;
		HisUtil hisUtil = null;
		try
		{
			bo = new CashCollectionOfflineTransBO();
			hisUtil = new HisUtil("Billing", "CashCollectionOfflineTransBSDATA");
			formBean.setStrOffLineClientPatientNo(formBean.getStrOffLineClientDetailsHidden().replace("^", "#").split("#")[0]);
			//System.out.println("getStrAdmissionDtlHidVal--->"+formBean.getStrAdmissionDtlHidVal());
			/*System.out.println("111>>>"+formBean.getStrAdmissionDtlHidVal().equals('0'));
			System.out.println("111>>>"+formBean.getStrAdmissionDtlHidVal().equals("0"));
			System.out.println("111>>>"+formBean.getStrAdmissionDtlHidVal().equals(""));
			System.out.println("111>>>"+!formBean.getStrAdmissionDtlHidVal().equals(""));
			System.out.println("111>>>"+(formBean.getStrAdmissionDtlHidVal()!=""));
			System.out.println("111>>>"+!formBean.getStrAdmissionDtlHidVal().equals("0"));
			System.out.println("111>>>"+formBean.getStrAdmissionDtlHidVal()!="0");*/
			voObj = (CashCollectionOfflineTransVO) TransferObjectFactory.populateData("billing.transactions.CashCollectionOfflineTransVO", formBean);

			if(formBean.getStrAdmissionDtlHidVal()!=null &&  formBean.getStrAdmissionDtlHidVal()!=""&& !formBean.getStrAdmissionDtlHidVal().equals("0"))
			{
				
				formBean.setStrOffLineAdmissionNo(formBean.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[0]);
				voObj.setStrOffLineAdmissionNo(formBean.getStrOffLineAdmissionNo());
				voObj.setStrAdmissionDate(formBean.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[3]);
			}

			String[] strWardDtls = formBean.getStrOffLineWard().replace("^", "#").split("#");

			formBean.setStrOffLineWard(strWardDtls[0]);
			formBean.setStrOffLineIpdChargeTypeId(strWardDtls[1]);
			formBean.setStrOffLineEpisode(formBean.getStrOffLineEpisode().replace("^", "#").split("#")[0]);
			formBean.setStrOffLineAdvanceAmount(formBean.getStrPartpayment());
			formBean.setStrOffLineApprovedBy(formBean.getStrApprovedByCombo());
			formBean.setStrOffLineRemarks(formBean.getStrRemarksCombo2());

			voObj.setStrOffLineSpecialWard(formBean.getStrOffLineSpecialWard());
			
			voObj.setStrMobileNo(formBean.getStrMobileNo());
			bo.insertOfflineReceiptAdvance(voObj);

			formBean.setStrBillNo(voObj.getStrBillNo());
			formBean.setStrReceiptNo("1");
			//formBean.setStrCrNo("");

			if (!voObj.getStrMsgType().equals("1"))
			{
				//String smsMsg="You Paid Rs. "+formBean.getStrOfflineTotalRecAmount()+" for IPD Account Opening/Advance Against Receipt No. "+formBean.getStrBillNo()+ "/1";
				String smsMsg="Dear "+formBean.getStrPatientDtlHidVal().replace("^","#").split("#")[7]  +", Payment of Rs. "+formBean.getStrOfflineTotalRecAmount()+" Received Against Bill No. "+formBean.getStrBillNo()+ "/1 on "+hisUtil.getDSDate("")+" "+hisUtil.getDSDate("hh:mi:ss:AM")+". "+formBean.getStrPatientDtlHidVal().replace("^","#").split("#")[15];
				if(formBean.getStrMobileNo()!=null && !formBean.getStrMobileNo().equals(""))
					voObj.setStrMobileNo(formBean.getStrMobileNo());
				else
					voObj.setStrMobileNo(formBean.getStrPatientDtlHidVal().replace("^","#").split("#")[13]);
				//System.out.println("formBean.getStrMobileNo()"+formBean.getStrMobileNo());
				final String   smsmessage  = smsMsg;
				final String patMobileNo=voObj.getStrMobileNo();
				/**Added by Vasu on 25.June for SMS Configuration*/
				/*
				 * if(patMobileNo!=null && !patMobileNo.equals("")){ //code from sending message
				 * through CDAC MUmbai SMS Gateway
				 * //SMSHttpPostClient.sendSingleSMSThroughSMSGateway(objSMSConfig.sms_username,
				 * objSMSConfig.sms_password,objSMSConfig.sms_senderId,objSMSConfig.sms_url,
				 * patientVO.getPatAddMobileNo(),message); new Thread( new Runnable() { public
				 * void run(){
				 * 
				 * SMSHttpPostClient.sendSMS (patMobileNo,smsmessage);
				 * 
				 * return; // to stop the thread } }).start(); }
				 */
				//Code Commented For SMS Serv ice Service taking time so code started in new thread
				//SMSHttpPostClient.sendSMS (voObj.getStrMobileNo(), smsMsg);
				if(patMobileNo!=null && !patMobileNo.equals(""))//{
					SMSHttpPostClient.sendSMS (patMobileNo,smsmessage);
					 //code from sending message through CDAC MUmbai SMS Gateway
					 //SMSHttpPostClient.sendSingleSMSThroughSMSGateway(objSMSConfig.sms_username, objSMSConfig.sms_password,objSMSConfig.sms_senderId,objSMSConfig.sms_url, patientVO.getPatAddMobileNo(),message);
					/*
					 * new Thread( new Runnable() { public void run(){
					 * 
					 * SMSHttpPostClient.sendSMS (patMobileNo,smsmessage);
					 * 
					 * return; // to stop the thread } }).start(); }
					 */

				PrintHLP.ADVANCE(formBean.getStrBillNo(), formBean.getStrOffLineBillingService(), formBean.getStrHospitalCode(), 
								 formBean.getStrReceiptNo(), request, 0,"0","");

				formBean.setStrNormalMsg("Receipt No. '" + formBean.getStrBillNo() + "/1" + "' Generated Successfully for the Collected Amount <i class='fas fa-rupee-sign'></i> '" + HisUtil
								.getAmountWithDecimal(formBean.getStrOfflineTotalRecAmount(), 2) + "'");

				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo("1");
				
				String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
				formBean.setFilePath(fileName);
				request.setAttribute("filePath", fileName);
				formBean.setIsOpenPopUp("1");
				fRes = true;

			} else
			{

				String err = voObj.getStrMsgString();

				fRes = false;

				throw new Exception(err);

			}

		} catch (Exception e)
		{
			e.printStackTrace();
			String err = e.getMessage();

			HisException eObj = new HisException("Billing Transaction",
					"CashCollectionOfflineTransBSDATA.insertOfflineReceiptAdvance()-->", err);

			if(err.contains("Account Already Opened/Advance Collected. Multiple Accounts cannot be opened"))
				formBean.setStrErrMsg("Account Already Opened/Advance Collected. Multiple Accounts cannot be opened");
			else
				formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		} finally
		{

			bo = null;
			voObj = null;

		}

		return fRes;

	}

	/**
	 * Inserts Off-line Receipt Services Details.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return true, if insert off-line receipt service
	 */
	public static boolean insertOfflineReceiptService(CashCollectionOfflineTransFB formBean, HttpServletRequest request)
	{
		boolean fRes = false;
		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;
		String strmsg="";

		String[] strDirectTariffList = null;
		String strDirectTariffList1="";
		String strAmountPaidByPatient="0";
		String strAmountPaidByClient="0";
		String clientName="NA";
		Map tariffPrintMap = new LinkedHashMap();
		String directMode="1";
		HisUtil hisUtil = null;

		try
		{
			/*int lengthOfFilesToBe=0;
			lengthOfFilesToBe=formBean.getStrOfflineTariffDetailsHidden().length;
			
			for(int k=0;k<lengthOfFilesToBe;k++){
				//System.out.println("form file length::"+formBean.getUploadedFile(k).);
				System.out.println("form file length::"+formBean.getUploadedFile2(k).getFileName());
				
				
			}*/
			bo = new CashCollectionOfflineTransBO();
			hisUtil = new HisUtil("Billing", "CashCollectionOfflineTransBSDATA");
			formBean.setStrOffLineClientPatientNo(formBean.getStrOffLineClientDetailsHidden().replace("^", "#").split("#")[0]);
			formBean.setStrOffLineAdmissionNo(formBean.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[0]);

			if (formBean.getStrOffLineWard() != null && formBean.getStrOffLineWard().length() > 1)
			{
				String[] strWardDtls = formBean.getStrOffLineWard().replace("^", "#").split("#");
				formBean.setStrOffLineWard(strWardDtls[0]);
				formBean.setStrOffLineIpdChargeTypeId(strWardDtls[1]);
			} 
			else
			{
				formBean.setStrOffLineWard("0");
				formBean.setStrOffLineIpdChargeTypeId("0");
			}

			formBean.setStrOffLineEpisode(formBean.getStrOffLineEpisode().replace("^", "#").split("#")[0]);
			voObj = (CashCollectionOfflineTransVO) TransferObjectFactory.populateData("billing.transactions.CashCollectionOfflineTransVO", formBean);
			
			int lengthOfFilesToBeUploaded=0;
			lengthOfFilesToBeUploaded=formBean.getStrOfflineTariffDetailsHidden().length;
			
			
			bo.insertOfflineReceiptService(voObj);

			/*if(formBean.getStrOfflineTariffDetailsHidden() != null)
			{
				strDirectTariffList = new String[formBean.getStrOfflineTariffDetailsHidden().length];
				for (int i = 0 , stopI = formBean.getStrOfflineTariffDetailsHidden().length ; i < stopI; i++) 
				{
				
				 String strTemp[] = formBean.getStrOfflineTariffDetailsHidden()[i].replace("^", "#").split("#");
				 strDirectTariffList[i] = formBean.getStrOfflineTariffName()[i].substring(0, formBean.getStrOfflineTariffName()[i].lastIndexOf("- (")-1)+"@"+
				 						  strTemp[4]+"/"+strTemp[14]+"^"+
				 						  formBean.getStrOfflineTariffQty()[i]+" "+strTemp[14]+"^"+
				 						  formBean.getStrOfflineTariffDiscount()[i]+"^"+
				 						  formBean.getStrOfflineTariffServiceTax()[i]+"^"+
				 						  formBean.getStrOfflineTariffNetAmount()[i];
				 
				}			 
			}*/
			
			/*if(!voObj.getStrMsgType().equals("1"))//Saved Successful
			{
			    	//File Upload Logic
				
					//Upload Only When Credit Category Selected
					if(voObj.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1].equals("3") || voObj.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1].equals("4"))
			    	{
						//try writing file..will work only when single file is uploaded for each row..
						OutputStream out=null;
						String strHiddenVal = null;
						String fileSavePath=HisUtil.getParameterFromHisPathXML("CREDIT_BILL_PATH");
						strHiddenVal = voObj.getStrBillNo();
						String strHbReqNo = strHiddenVal;//used for naming a file(file name will be requisition no wise)..
						String ext=".jpeg";
						String []tempArr=null;
						int lengthOfFilesToBe=0;
						lengthOfFilesToBe=formBean.getStrOfflineTariffDetailsHidden().length;
						System.out.println("rows to be iterated data::"+formBean.getStrOfflineTariffDetailsHidden().length);
						for(int k=0;k<lengthOfFilesToBe;k++)
						{
							FormFile myfile=formBean.getUploadedFile2(k);							
							System.out.println("uploaded file name is:::"+myfile.getFileName());
						}
						
						java.util.Date date= new java.util.Date();
						
						for(int k=0;k<lengthOfFilesToBeUploaded;k++)
						{
							FormFile myfile=formBean.getUploadedFile2(k);						
							try
							{
								tempArr=myfile.getFileName().replace('.', '#').split("#");
								ext=tempArr[tempArr.length-1];
								//System.out.println("extension is::"+ext);
								System.out.println("uploaded file name is:::"+myfile.getFileName()+"::k::"+k);
								
								//out = new FileOutputStream( new File(fileSavePath+"/"+strHbReqNo+"_"+date.getTime()+"_"+k+"."+ext));
								out = new FileOutputStream( new File(fileSavePath+"/"+strHbReqNo+"."+ext));
								out.write(myfile.getFileData());
								out.close();
							}
							catch (Exception e)
							{
								e.printStackTrace();
							}
							
						}
			    }
				
			}*/
			
			
			
			
			if(formBean.getStrOfflineTariffDetailsHidden() != null){
				
				  strDirectTariffList = new String[formBean.getStrOfflineTariffDetailsHidden().length];
				 
				 
				 for (int i = 0 , stopI = formBean.getStrOfflineTariffDetailsHidden().length ; i < stopI; i++) {
					
					 String strTemp[] = formBean.getStrOfflineTariffDetailsHidden()[i].replace("^", "#").split("#");
					 String x;
					 if(formBean.getStrOfflineTariffName()[i].contains("- ("))
					 {
						 x=formBean.getStrOfflineTariffName()[i].substring(0, formBean.getStrOfflineTariffName()[i].lastIndexOf("- (")-1);
					 }
					 else
						 x=formBean.getStrOfflineTariffName()[i];
					 
					 
					 if((voObj.getStrCreditPaymentType()[i].equals("12") || voObj.getStrCreditPaymentType()[i].equals("13")))//Paid Urgent or Credit Urgent
				     {
							 strDirectTariffList[i] = x+"(U)"+"@"+
									 formBean.getStrOfflineTariffRateUnit()[i].replace('/','#').split("#")[0]+"/"+strTemp[14]+"^"+
			 						  formBean.getStrOfflineTariffQty()[i]+" "+strTemp[14]+"^"+
			 						  formBean.getStrOfflineTariffDiscount()[i]+"^"+
			 						  formBean.getStrOfflineTariffServiceTax()[i]+"^"+
			 						  formBean.getStrOfflineTariffNetAmount()[i];
					 }
					 else
					 {
						     strDirectTariffList[i] = x+"@"+
								 formBean.getStrOfflineTariffRateUnit()[i].replace('/','#').split("#")[0]+"/"+strTemp[14]+"^"+
		 						  formBean.getStrOfflineTariffQty()[i]+" "+strTemp[14]+"^"+
		 						  formBean.getStrOfflineTariffDiscount()[i]+"^"+
		 						  formBean.getStrOfflineTariffServiceTax()[i]+"^"+
		 						  formBean.getStrOfflineTariffNetAmount()[i];
					 }
					 
					 
				}
				 
				 
			 }
			
			
			if (formBean.getStrOfflineTariffDetailsHidden() != null)
			{
				//strDirectTariffList = new String[formBean.getStrOfflineTariffDetailsHidden().length];
				String[] strArrayTariffList = new String[formBean.getStrOfflineTariffDetailsHidden().length];
				for (int i = 0, stopI = formBean.getStrOfflineTariffDetailsHidden().length; i < stopI; i++)
				{
					
					String strTemp[] = formBean.getStrOfflineTariffDetailsHidden()[i].replace("^", "#").split("#");
					String x;
					 if(formBean.getStrOfflineTariffName()[i].contains("- ("))
					 {
						 x=formBean.getStrOfflineTariffName()[i].substring(0, formBean.getStrOfflineTariffName()[i].lastIndexOf("- (")-1);
					 }
					 else
						 x=formBean.getStrOfflineTariffName()[i];
					//strDirectTariffList1 Format--TrfName^Qty,DiscountAmt^ServiceTaxAmt^NetAmt^AmtPaidByPatient^AmtPaidByCLient^isEstimation^isPackage
					if(formBean.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1].equals("3") || formBean.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1].equals("4"))
					{
							if((voObj.getStrCreditPaymentType()[i].equals("11") || voObj.getStrCreditPaymentType()[i].equals("13")))//Credit or Credit Urgent
							{
								strAmountPaidByPatient="0";
								strAmountPaidByClient=String.valueOf(Double.parseDouble(formBean.getStrOfflineTariffRateUnit()[i].replace('/','#').split("#")[0])*Double.parseDouble(formBean.getStrOfflineTariffQty()[i]));
							}
							else
							{
								strAmountPaidByPatient=String.valueOf(Double.parseDouble(formBean.getStrOfflineTariffRateUnit()[i].replace('/','#').split("#")[0])*Double.parseDouble(formBean.getStrOfflineTariffQty()[i]));
								strAmountPaidByClient="0";
							}
						    if((voObj.getStrCreditPaymentType()[i].equals("12") || voObj.getStrCreditPaymentType()[i].equals("13")))//Paid Urgent or Credit Urgent
							{
							    strDirectTariffList1 = x+"(U)"+ "@" + formBean.getStrOfflineTariffRateUnit()[i].replace('/','#').split("#")[0] + "/" + strTemp[14] + "^" + formBean
									.getStrOfflineTariffQty()[i] + " " + strTemp[14] + "^" + formBean.getStrOfflineTariffDiscount()[i] + "^" + formBean
									.getStrOfflineTariffServiceTax()[i] + "^" + formBean.getStrOfflineTariffNetAmount()[i]+"^"+strAmountPaidByPatient+"^"+strAmountPaidByClient+"^0"+"^"+strTemp[7];
							}
							else
							{
								strDirectTariffList1 = x+ "@" + formBean.getStrOfflineTariffRateUnit()[i].replace('/','#').split("#")[0] + "/" + strTemp[14] + "^" + formBean
										.getStrOfflineTariffQty()[i] + " " + strTemp[14] + "^" + formBean.getStrOfflineTariffDiscount()[i] + "^" + formBean
										.getStrOfflineTariffServiceTax()[i] + "^" + formBean.getStrOfflineTariffNetAmount()[i]+"^"+strAmountPaidByPatient+"^"+strAmountPaidByClient+"^0"+"^"+strTemp[7];
							}
					}
					else
					{	
						if((voObj.getStrCreditPaymentType()[i].equals("12") || voObj.getStrCreditPaymentType()[i].equals("13")))//Paid Urgent or Credit Urgent
						{
						
							    strDirectTariffList1 = x+"(U)"+ "@" + formBean.getStrOfflineTariffRateUnit()[i].replace('/','#').split("#")[0] + "/" + strTemp[14] + "^" + formBean
									.getStrOfflineTariffQty()[i] + " " + strTemp[14] + "^" + formBean.getStrOfflineTariffDiscount()[i] + "^" + formBean
									.getStrOfflineTariffServiceTax()[i] + "^" + formBean.getStrOfflineTariffNetAmount()[i]+"^0^0^0"+"^"+strTemp[7];
						}
						else
						{
								strDirectTariffList1 = x+ "@" + formBean.getStrOfflineTariffRateUnit()[i].replace('/','#').split("#")[0] + "/" + strTemp[14] + "^" + formBean
										.getStrOfflineTariffQty()[i] + " " + strTemp[14] + "^" + formBean.getStrOfflineTariffDiscount()[i] + "^" + formBean
										.getStrOfflineTariffServiceTax()[i] + "^" + formBean.getStrOfflineTariffNetAmount()[i]+"^0^0^0"+"^"+strTemp[7];
						}
					}
					
					
					
					
					//strArrayTariffList Format--strDirectTariffList1(TrfName^Qty,DiscountAmt^ServiceTaxAmt^NetAmt^AmtPaidByPatient^AmtPaidByCLient^isEstimation^isPackage)
												//#GroupId#GroupName#ClientNo#CerditLetterNo
					if(formBean.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1].equals("3") || formBean.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1].equals("4"))
					{
						if((voObj.getStrCreditPaymentType()[i].equals("11") || voObj.getStrCreditPaymentType()[i].equals("13")))//Credit or Credit Urgent
						{
							
							//strArrayTariffList[i] = strDirectTariffList1 + "#" + strTemp[1] + "#" + strTemp[19] +"#" +clientName +"#"+formBean.getStrCreditLetterNo()[i]+"-"+formBean.getStrCreditRefDate1()[i];
							strArrayTariffList[i] = strDirectTariffList1 + "#" + strTemp[1] + "#" + strTemp[19] +"#" +clientName +"#"+formBean.getStrCreditLetterNo()[i].replace("^","#").split("#")[0]+"-"+formBean.getStrCreditLetterNo()[i].replace("^","#").split("#")[1];
						}
						else
						{
							strArrayTariffList[i] = strDirectTariffList1 + "#" + strTemp[1] + "#" + strTemp[19] +"#NA#NA";
						}						
					}
					else
					{	
						strArrayTariffList[i] = strDirectTariffList1 + "#" + strTemp[1] + "#" + strTemp[19] + "#NA#NA#";///Amit Ateria
					}
				}
				
				if(formBean.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1].equals("3") || formBean.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1].equals("4"))
				{
					tariffPrintMap = PrintHLP.populateCreditLetterMapForPrinting(strArrayTariffList, tariffPrintMap,new BillConfigUtil(formBean.getStrHospitalCode()));
				}
				else
				{	
					tariffPrintMap = PrintHLP.populateGroupMapForPrinting(strArrayTariffList, tariffPrintMap,new BillConfigUtil(formBean.getStrHospitalCode()));
				}
			}
			//System.out.println("tariffPrintMap         "+tariffPrintMap);
			formBean.setStrBillNo(voObj.getStrBillNo());
			formBean.setStrReceiptNo("1");
			//formBean.setStrCrNo("");
			/*
			 * if(voObj.getStrMsgType().equals("0")) {
			 * //System.out.println("formBean.getStrMobileNo()"+formBean.getStrMobileNo());
			 * SMSHttpsNICPostClient sms=new SMSHttpsNICPostClient(); if
			 * (voObj.getStrOfflinePaymentMode()[0].equals("7"))//Payment Mode=Wallet {
			 * String smsMsg="You Paid Rs. "+voObj.getStrOfflineTotalRecAmount()
			 * +" from Your Patient Wallet for Hospital Services Against Reference No. "
			 * +voObj.getStrBillNo()+". Your Current Wallet balance is Rs. "+(Double.
			 * parseDouble(voObj.getStrAvlWalletMoney())-Double.parseDouble(voObj.
			 * getStrOfflineTotalRecAmount()));
			 * sms.sendTextSMSThroughNICSMSGateway("","","","",formBean.getStrMobileNo(),
			 * smsMsg); } }
			 */

			if (!voObj.getStrMsgType().equals("1"))
			{
				if (formBean.getStrOffLineHospitalService().equals("2"))//IPD
				{
					String smsMsg="Dear "+formBean.getStrPatientDtlHidVal().replace("^","#").split("#")[7]  +", Payment of Rs. "+formBean.getStrOfflineTotalRecAmount()+" Received Against Bill No. "+formBean.getStrBillNo()+ "/1 on "+hisUtil.getDSDate("")+" "+hisUtil.getDSDate("hh:mi:ss:AM")+". "+formBean.getStrPatientDtlHidVal().replace("^","#").split("#")[15];
					if(formBean.getStrMobileNo()!=null && !formBean.getStrMobileNo().equals(""))
						voObj.setStrMobileNo(formBean.getStrMobileNo());
					else
						voObj.setStrMobileNo(formBean.getStrPatientDtlHidVal().replace("^","#").split("#")[13]);
                    //System.out.println("voObj.getStrMobileNo()"+voObj.getStrMobileNo());
					final String   smsmessage  = smsMsg;
					final String patMobileNo=voObj.getStrMobileNo();
					/**Added by Vasu on 25.June for SMS Configuration*/
					/*
					 * if(patMobileNo!=null && !patMobileNo.equals("")){ //code from sending message
					 * through CDAC MUmbai SMS Gateway
					 * //SMSHttpPostClient.sendSingleSMSThroughSMSGateway(objSMSConfig.sms_username,
					 * objSMSConfig.sms_password,objSMSConfig.sms_senderId,objSMSConfig.sms_url,
					 * patientVO.getPatAddMobileNo(),message); new Thread( new Runnable() { public
					 * void run(){
					 * 
					 * SMSHttpPostClient.sendSMS (patMobileNo,smsmessage);
					 * 
					 * return; // to stop the thread } }).start(); }
					 */
					//Code Commented For SMS Serv ice Service taking time so code started in new thread
					//SMSHttpPostClient.sendSMS (voObj.getStrMobileNo(), smsMsg);
					//SMSHttpsNICPostClient sms=new SMSHttpsNICPostClient();
					
						//String smsMsg="You Paid Rs. "+voObj.getStrOfflineTotalRecAmount()+" from Your Patient Wallet for Hospital Services Against Reference No. "+voObj.getStrBillNo()+". Your Current Wallet balance is Rs. "+(Double.parseDouble(voObj.getStrAvlWalletMoney())-Double.parseDouble(voObj.getStrOfflineTotalRecAmount()));
					//SMSHttpPostClient.sendSMS (patMobileNo,smsmessage);
					//}
					if(patMobileNo!=null && !patMobileNo.equals(""))//{
						 SMSHttpPostClient.sendSMS (patMobileNo,smsmessage);
						 //code from sending message through CDAC MUmbai SMS Gateway
						 //SMSHttpPostClient.sendSingleSMSThroughSMSGateway(objSMSConfig.sms_username, objSMSConfig.sms_password,objSMSConfig.sms_senderId,objSMSConfig.sms_url, patientVO.getPatAddMobileNo(),message);
							/*new Thread( new Runnable() {
						           public void run(){

						        	 SMSHttpPostClient.sendSMS (patMobileNo,smsmessage);

						          return; // to stop the thread
						                          }
						         }).start();
						}*/
					
					PrintHLP.IPD_SERVICES(formBean.getStrBillNo(), formBean.getStrOffLineAccountNo(), formBean.getStrOffLineBillingService(), formBean.getStrHospitalCode(), 
											formBean.getStrReceiptNo(),request, tariffPrintMap, "1", 0,"0","");
					
					String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
					formBean.setFilePath(fileName);
					request.setAttribute("filePath", fileName);
					formBean.setIsOpenPopUp("1");
				} 
				else
				{					
					/*if(formBean.getStrOffLineTreatmentCategory().replace("^", "#").split("#")[1].equals("3") || formBean.getStrOffLineTreatmentCategory().replace("^", "#").split("#")[1].equals("4"))
					{
						PrintHLP.OPD_SERVICES_CreditBill(formBean.getStrBillNo(), formBean.getStrOffLineBillingService(), 
														formBean.getStrHospitalCode(), formBean.getStrReceiptNo(), request, tariffPrintMap, "1", 0,formBean.getStrEmployeeName());
						String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
						formBean.setFilePath(fileName);
						request.setAttribute("filePath", fileName);
						formBean.setIsOpenPopUp("1");						
					}
					else
					{*/
					if(formBean.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1].equals("1"))//IF STAFF CAT THEN FETCH DATA FROM DB 
					{
						directMode="0";
						tariffPrintMap=null;
					}
					//System.out.println("formBean.getStrPatientDtlHidVal()"+formBean.getStrPatientDtlHidVal());
					//String smsMsg="You Paid Rs. "+formBean.getStrOfflineTotalRecAmount()+" for OPD Hospital Services Against Receipt No. "+formBean.getStrBillNo()+ "/1";
					String smsMsg="Dear "+formBean.getStrPatientDtlHidVal().replace("^","#").split("#")[7]  +", Payment of Rs. "+formBean.getStrOfflineTotalRecAmount()+" Received Against Bill No. "+formBean.getStrBillNo()+ "/1 on "+hisUtil.getDSDate("")+" "+hisUtil.getDSDate("hh:mi:ss:AM")+". "+formBean.getStrPatientDtlHidVal().replace("^","#").split("#")[15];
					if(formBean.getStrMobileNo()!=null && !formBean.getStrMobileNo().equals(""))
						voObj.setStrMobileNo(formBean.getStrMobileNo());
					else
						voObj.setStrMobileNo(formBean.getStrPatientDtlHidVal().replace("^","#").split("#")[13]);
					//System.out.println("formBean.getStrMobileNo()"+formBean.getStrMobileNo());
					final String   smsmessage  = smsMsg;
					final String patMobileNo=voObj.getStrMobileNo();
					/**Added by Vasu on 25.June for SMS Configuration*/
					/*
					 * if(patMobileNo!=null && !patMobileNo.equals("")){ //code from sending message
					 * through CDAC MUmbai SMS Gateway
					 * //SMSHttpPostClient.sendSingleSMSThroughSMSGateway(objSMSConfig.sms_username,
					 * objSMSConfig.sms_password,objSMSConfig.sms_senderId,objSMSConfig.sms_url,
					 * patientVO.getPatAddMobileNo(),message); new Thread( new Runnable() { public
					 * void run(){
					 * 
					 * SMSHttpPostClient.sendSMS (patMobileNo,smsmessage);
					 * 
					 * return; // to stop the thread } }).start(); }
					 */
					//Code Commented For SMS Serv ice Service taking time so code started in new thread
					//SMSHttpPostClient.sendSMS (voObj.getStrMobileNo(), smsMsg);
					//SMSHttpPostClient.sendSMS (patMobileNo,smsmessage);
					//if(patMobileNo!=null && !patMobileNo.equals(""))
					//	SMSHttpPostClient.sendSMS(patMobileNo,smsmessage);
					/*
											 * { //code from sending message through CDAC MUmbai SMS Gateway
											 * //SMSHttpPostClient.sendSingleSMSThroughSMSGateway(objSMSConfig.
											 * sms_username,
											 * objSMSConfig.sms_password,objSMSConfig.sms_senderId,objSMSConfig.sms_url,
											 * patientVO.getPatAddMobileNo(),message); new Thread( new Runnable() {
											 * public void run(){
											 * 
											 * SMSHttpPostClient.sendSMS (patMobileNo,smsmessage);
											 * 
											 * return; // to stop the thread } }).start(); }
											 */

					
						PrintHLP.OPD_SERVICES(formBean.getStrBillNo(), formBean.getStrOffLineBillingService(), formBean
								.getStrHospitalCode(), formBean.getStrReceiptNo(), request, tariffPrintMap, directMode, 0,"0","");
						String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
						formBean.setFilePath(fileName);
						request.setAttribute("filePath", fileName);
						formBean.setIsOpenPopUp("1");
					//}

				}

				formBean.setStrNormalMsg("Receipt No. '" + formBean.getStrBillNo() + "/1" + "' Generated Successfully for the Collected Amount <i class='fas fa-rupee-sign'></i> '" + HisUtil.getAmountWithDecimal(formBean.getStrOfflineTotalRecAmount(), 2) + "'");
				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo("1");
				fRes = true;
			} 
			else
			{
				fRes = false;
				throw new Exception(voObj.getStrMsgString());
			}
		} 
		catch (Exception e)
		{
			String err = e.getMessage();
			HisException eObj = new HisException("Billing Transaction","CashCollectionOfflineTransBSDATA.insertOfflineReceiptService()-->", err);
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} 
		finally
		{
			bo = null;
			voObj = null;
		}

		return fRes;

	}

	/**
	 * Inserts Off-line Refund Services Details.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return true, if insert off-line refund service
	 */
	public static boolean insertOfflineRefundService(CashCollectionOfflineTransFB formBean, HttpServletRequest request)
	{
		boolean fRes = false;
		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;

		try
		{
			bo = new CashCollectionOfflineTransBO();
			formBean.setStrOffLineClientPatientNo(formBean.getStrOffLineClientDetailsHidden().replace("^", "#").split("#")[0]);
			formBean.setStrOffLineAdmissionNo(formBean.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[0]);

			if (formBean.getStrOffLineWard() != null && formBean.getStrOffLineWard().length() > 1)
			{
				String[] strWardDtls = formBean.getStrOffLineWard().replace("^", "#").split("#");
				formBean.setStrOffLineWard(strWardDtls[0]);
				formBean.setStrOffLineIpdChargeTypeId(strWardDtls[1]);
			} 
			else
			{
				formBean.setStrOffLineWard("0");
				formBean.setStrOffLineIpdChargeTypeId("0");
			}

			formBean.setStrOffLineEpisode(formBean.getStrOffLineEpisode().replace("^", "#").split("#")[0]);

			voObj = (CashCollectionOfflineTransVO) TransferObjectFactory.populateData("billing.transactions.CashCollectionOfflineTransVO", formBean);
			bo.insertOfflineRefundService(voObj);

			formBean.setStrBillNo(voObj.getStrBillNo());
			formBean.setStrRefundReceiptNo(voObj.getStrRefundReceiptNo());

			//formBean.setStrCrNo("");
			/*
			 * if (!voObj.getStrMsgType().equals("1")) {
			 * //System.out.println("formBean.getStrMobileNo()"+formBean.getStrMobileNo());
			 * SMSHttpsNICPostClient sms=new SMSHttpsNICPostClient(); if
			 * (voObj.getStrOfflinePaymentMode()[0].equals("7"))//Payment Mode=Wallet {
			 * String
			 * smsMsg="You Wallet Is Credited With Rs. "+voObj.getStrOfflineTotalRecAmount()
			 * +" Against Refund of Hospital Services -Reference No. "+voObj.getStrBillNo()
			 * +". Your Current Wallet balance is Rs. "+(Double.parseDouble(voObj.
			 * getStrAvlWalletMoney())+Double.parseDouble(voObj.getStrOfflineTotalRecAmount(
			 * )));
			 * sms.sendTextSMSThroughNICSMSGateway("","","","",formBean.getStrMobileNo(),
			 * smsMsg); } }
			 */

			if (!voObj.getStrMsgType().equals("1"))
			{
				if (formBean.getStrOffLineHospitalService().equals("2"))
				{
					PrintHLP.IPD_REFUND(formBean.getStrBillNo(), formBean.getStrRefundReceiptNo(), formBean
							.getStrOffLineAccountNo(), formBean.getStrOffLineBillingService(), formBean.getStrHospitalCode(),
							request, 0);
					String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
					formBean.setFilePath(fileName);
					request.setAttribute("filePath", fileName);
					formBean.setIsOpenPopUp("1");
				} 
				else
				{
					PrintHLP.OPD_REFUND(formBean.getStrBillNo(), formBean.getStrRefundReceiptNo(), formBean.getStrOffLineBillingService(), formBean.getStrHospitalCode(), request, 0,"");
					String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
					formBean.setFilePath(fileName);
					request.setAttribute("filePath", fileName);
					formBean.setIsOpenPopUp("1");

				}

				formBean.setStrNormalMsg("Receipt No. '" + formBean.getStrBillNo() + "/" + formBean.getStrRefundReceiptNo() + 
										 "' Generated Successfully for the Collected Amount <i class='fas fa-rupee-sign'></i> '" + 
										 HisUtil.getAmountWithDecimal(formBean.getStrOfflineTotalRecAmount(), 2) + "'");

				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo(formBean.getStrRefundReceiptNo());

				fRes = true;
			} 
			else
			{

				fRes = false;
				throw new Exception(voObj.getStrMsgString());
			}
		} 
		catch (Exception e)
		{
			String err = e.getMessage();
			HisException eObj = new HisException("Billing Transaction","CashCollectionOfflineTransBSDATA.insertOfflineRefundService()-->", err);
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} 
		finally
		{
			bo = null;
			voObj = null;
		}

		return fRes;

	}

	/**
	 * Inserts Off-line Refund Admission Cancellation Details.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return true, if insert off-line refund admission cancellation
	 */
	public static boolean insertOfflineRefundAdmissionCancellation(CashCollectionOfflineTransFB formBean,
			HttpServletRequest request)
	{

		boolean fRes = false;

		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;

		try
		{
			bo = new CashCollectionOfflineTransBO();

			formBean
					.setStrOffLineClientPatientNo(formBean.getStrOffLineClientDetailsHidden().replace("^", "#").split("#")[0]);
			formBean.setStrOffLineAdmissionNo(formBean.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[0]);

			String[] strWardDtls = formBean.getStrOffLineWard().replace("^", "#").split("#");

			formBean.setStrOffLineWard(strWardDtls[0]);
			//formBean.setStrOffLineIpdChargeTypeId(strWardDtls[1]);

			formBean.setStrOffLineEpisode(formBean.getStrOffLineEpisode().replace("^", "#").split("#")[0]);

			voObj = (CashCollectionOfflineTransVO) TransferObjectFactory.populateData(
					"billing.transactions.CashCollectionOfflineTransVO", formBean);
			voObj.setStrOffLineSpecialWard(formBean.getStrOffLineSpecialWard());

			voObj.setStrAdvCancelRefund(formBean.getStrAdvCancelRefund());
			voObj.setStrAdmissionNo(formBean.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[0]);
			
			
			if(formBean.getAccountCatDivCheked().equals("1")){
				voObj.setAccountCategory(formBean.getAccountCategory());
			}else{
				voObj.setAccountCatDivCheked("2");    //in case null
			}
			if(formBean.getOnlyCatCahnge().equals("1"))
			{
				bo.insertOnlyCatChange(voObj);
				
				
				
				String temp="";
				if(voObj.getStrMsgType().equals("1"))
					formBean.setStrErrMsg("<font color='green'>ACCOUNT CATEGORY UPDATED</font>");
				else
					formBean.setStrErrMsg("<font color='red'>ACCOUNT CATEGORY NOT UPDATED</font>");
				
			}else
			{
				bo.insertOfflineRefundAdmissionCancellation(voObj);

				formBean.setStrBillNo(voObj.getStrBillNo());
				formBean.setStrRefundReceiptNo(voObj.getStrRefundReceiptNo());
				
				
				

				//formBean.setStrCrNo("");

				if (!voObj.getStrMsgType().equals("1"))
				{

					PrintHLP.ADVANCE_REFUND(formBean.getStrBillNo(), formBean.getStrRefundReceiptNo(), formBean
							.getStrOffLineBillingService(), formBean.getStrHospitalCode(), request, 0);

					formBean
							.setStrNormalMsg("Receipt No. '" + formBean.getStrBillNo() + "/" + formBean.getStrRefundReceiptNo() + "' Generated Successfully for the Collected Amount <i class='fas fa-rupee-sign'></i> '" + HisUtil
									.getAmountWithDecimal(formBean.getStrOfflineTotalRecAmount(), 2) + "'");

					formBean.setStrTempBillNo(formBean.getStrBillNo());
					formBean.setStrTempReceiptNo(formBean.getStrRefundReceiptNo());
					
					String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
					formBean.setFilePath(fileName);
					request.setAttribute("filePath", fileName);
					formBean.setIsOpenPopUp("1");
					fRes = true;
				} else
				{

					fRes = false;

					throw new Exception(voObj.getStrMsgString());

				}
			}
		} catch (Exception e)
		{

			String err = e.getMessage();

			HisException eObj = new HisException("Billing Transaction",
					"CashCollectionOfflineTransBSDATA.insertOfflineRefundAdmissionCancellation()-->", err);

			formBean
					.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		} finally
		{

			bo = null;
			voObj = null;
		}

		return fRes;

	}

	/**
	 * Inserts Off-line Refund Admission Cancellation Details.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return true, if insert off-line refund admission cancellation
	 */
	public static boolean insertOfflineRefundPartPayment(CashCollectionOfflineTransFB formBean,
			HttpServletRequest request)
	{

		boolean fRes = false;

		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;

		try
		{
			bo = new CashCollectionOfflineTransBO();

			formBean
					.setStrOffLineClientPatientNo(formBean.getStrOffLineClientDetailsHidden().replace("^", "#").split("#")[0]);
			formBean.setStrOffLineAdmissionNo(formBean.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[0]);

			String[] strWardDtls = formBean.getStrOffLineWard().replace("^", "#").split("#");

			formBean.setStrOffLineWard(strWardDtls[0]);
			formBean.setStrOffLineIpdChargeTypeId(strWardDtls[1]);

			formBean.setStrOffLineEpisode(formBean.getStrOffLineEpisode().replace("^", "#").split("#")[0]);

			voObj = (CashCollectionOfflineTransVO) TransferObjectFactory.populateData(
					"billing.transactions.CashCollectionOfflineTransVO", formBean);

			bo.insertOfflineRefundPartPayment(voObj);

			formBean.setStrBillNo(voObj.getStrBillNo());
			formBean.setStrRefundReceiptNo(voObj.getStrRefundReceiptNo());

			//formBean.setStrCrNo("");

			if (!voObj.getStrMsgType().equals("1"))
			{

				PrintHLP.PARTPAY_REFUND(formBean.getStrBillNo(), formBean.getStrRefundReceiptNo(), formBean
						.getStrOffLineBillingService(), formBean.getStrHospitalCode(), request, 0);

				formBean
						.setStrNormalMsg("Receipt No. '" + formBean.getStrBillNo() + "/" + formBean.getStrRefundReceiptNo() + "' Generated Successfully for the Collected Amount <i class='fas fa-rupee-sign'></i> '" + HisUtil
								.getAmountWithDecimal(formBean.getStrOfflineTotalRecAmount(), 2) + "'");

				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo(formBean.getStrRefundReceiptNo());
				
				String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
				formBean.setFilePath(fileName);
				request.setAttribute("filePath", fileName);
				formBean.setIsOpenPopUp("1");

				fRes = true;
			} else
			{

				fRes = false;

				throw new Exception(voObj.getStrMsgString());

			}
		} catch (Exception e)
		{

			String err = e.getMessage();

			HisException eObj = new HisException("Billing Transaction",
					"CashCollectionOfflineTransBSDATA.insertOfflineRefundAdmissionCancellation()-->", err);

			formBean
					.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		} finally
		{

			bo = null;
			voObj = null;
		}

		return fRes;

	}
	
	/**
	 * Inserts Off-line Receipt Services Details.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return true, if insert off-line receipt service
	 */
	public static boolean insertOfflineEstimation(CashCollectionOfflineTransFB formBean, HttpServletRequest request)
	{
		boolean fRes = false;
		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;
		String strmsg="";

		String[] strDirectTariffList = null;
		String strDirectTariffList1="";
		String strAmountPaidByPatient="0";
		String strAmountPaidByClient="0";
		String clientName="NA";
		Map tariffPrintMap = new LinkedHashMap();

		try
		{
			/*int lengthOfFilesToBe=0;
			lengthOfFilesToBe=formBean.getStrOfflineTariffDetailsHidden().length;
			
			for(int k=0;k<lengthOfFilesToBe;k++){
				//System.out.println("form file length::"+formBean.getUploadedFile(k).);
				System.out.println("form file length::"+formBean.getUploadedFile2(k).getFileName());
				
				
			}*/
			bo = new CashCollectionOfflineTransBO();

			formBean.setStrOffLineClientPatientNo(formBean.getStrOffLineClientDetailsHidden().replace("^", "#").split("#")[0]);
			formBean.setStrOffLineAdmissionNo(formBean.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[0]);

			if (formBean.getStrOffLineWard() != null && formBean.getStrOffLineWard().length() > 1)
			{
				String[] strWardDtls = formBean.getStrOffLineWard().replace("^", "#").split("#");
				formBean.setStrOffLineWard(strWardDtls[0]);
				formBean.setStrOffLineIpdChargeTypeId(strWardDtls[1]);
			} 
			else
			{
				formBean.setStrOffLineWard("0");
				formBean.setStrOffLineIpdChargeTypeId("0");
			}

			formBean.setStrOffLineEpisode(formBean.getStrOffLineEpisode().replace("^", "#").split("#")[0]);
			voObj = (CashCollectionOfflineTransVO) TransferObjectFactory.populateData("billing.transactions.CashCollectionOfflineTransVO", formBean);
			
			int lengthOfFilesToBeUploaded=0;
			lengthOfFilesToBeUploaded=formBean.getStrOfflineTariffDetailsHidden().length;
			
			bo.insertOfflineEstimation(voObj);

			/*if(formBean.getStrOfflineTariffDetailsHidden() != null)
			{
				strDirectTariffList = new String[formBean.getStrOfflineTariffDetailsHidden().length];
				for (int i = 0 , stopI = formBean.getStrOfflineTariffDetailsHidden().length ; i < stopI; i++) 
				{
				
				 String strTemp[] = formBean.getStrOfflineTariffDetailsHidden()[i].replace("^", "#").split("#");
				 strDirectTariffList[i] = formBean.getStrOfflineTariffName()[i].substring(0, formBean.getStrOfflineTariffName()[i].lastIndexOf("- (")-1)+"@"+
				 						  strTemp[4]+"/"+strTemp[14]+"^"+
				 						  formBean.getStrOfflineTariffQty()[i]+" "+strTemp[14]+"^"+
				 						  formBean.getStrOfflineTariffDiscount()[i]+"^"+
				 						  formBean.getStrOfflineTariffServiceTax()[i]+"^"+
				 						  formBean.getStrOfflineTariffNetAmount()[i];
				 
				}			 
			}*/
			
			/*if(!voObj.getStrMsgType().equals("1"))//Saved Successful
			{
			    	//File Upload Logic
				
					//Upload Only When Credit Category Selected
					if(voObj.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1].equals("3") || voObj.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1].equals("4"))
			    	{
						//try writing file..will work only when single file is uploaded for each row..
						OutputStream out=null;
						String strHiddenVal = null;
						String fileSavePath=HisUtil.getParameterFromHisPathXML("CREDIT_BILL_PATH");
						strHiddenVal = voObj.getStrBillNo();
						String strHbReqNo = strHiddenVal;//used for naming a file(file name will be requisition no wise)..
						String ext=".jpeg";
						String []tempArr=null;
						int lengthOfFilesToBe=0;
						lengthOfFilesToBe=formBean.getStrOfflineTariffDetailsHidden().length;
						System.out.println("rows to be iterated data::"+formBean.getStrOfflineTariffDetailsHidden().length);
						for(int k=0;k<lengthOfFilesToBe;k++)
						{
							FormFile myfile=formBean.getUploadedFile2(k);							
							System.out.println("uploaded file name is:::"+myfile.getFileName());
						}
						
						java.util.Date date= new java.util.Date();
						
						for(int k=0;k<lengthOfFilesToBeUploaded;k++)
						{
							FormFile myfile=formBean.getUploadedFile2(k);						
							try
							{
								tempArr=myfile.getFileName().replace('.', '#').split("#");
								ext=tempArr[tempArr.length-1];
								//System.out.println("extension is::"+ext);
								System.out.println("uploaded file name is:::"+myfile.getFileName()+"::k::"+k);
								
								//out = new FileOutputStream( new File(fileSavePath+"/"+strHbReqNo+"_"+date.getTime()+"_"+k+"."+ext));
								out = new FileOutputStream( new File(fileSavePath+"/"+strHbReqNo+"."+ext));
								out.write(myfile.getFileData());
								out.close();
							}
							catch (Exception e)
							{
								e.printStackTrace();
							}
							
						}
			    }
				
			}*/
			
			
			
			
			/*if(formBean.getStrOfflineTariffDetailsHidden() != null){
				
				  strDirectTariffList = new String[formBean.getStrOfflineTariffDetailsHidden().length];
				 
				 
				 for (int i = 0 , stopI = formBean.getStrOfflineTariffDetailsHidden().length ; i < stopI; i++) {
					
					 String strTemp[] = formBean.getStrOfflineTariffDetailsHidden()[i].replace("^", "#").split("#");
					 
					 strDirectTariffList[i] = formBean.getStrOfflineTariffName()[i].substring(0, formBean.getStrOfflineTariffName()[i].lastIndexOf("- (")-1)+"@"+
					 						  strTemp[4]+"/"+strTemp[14]+"^"+
					 						  formBean.getStrOfflineTariffQty()[i]+" "+strTemp[14]+"^"+
					 						  formBean.getStrOfflineTariffDiscount()[i]+"^"+
					 						  formBean.getStrOfflineTariffServiceTax()[i]+"^"+
					 						  formBean.getStrOfflineTariffNetAmount()[i];
					 
				}
				 
				 
			 }*/
			
			
			if (formBean.getStrOfflineTariffDetailsHidden() != null)
			{
				//strDirectTariffList = new String[formBean.getStrOfflineTariffDetailsHidden().length];
				String[] strArrayTariffList = new String[formBean.getStrOfflineTariffDetailsHidden().length];
				for (int i = 0, stopI = formBean.getStrOfflineTariffDetailsHidden().length; i < stopI; i++)
				{
					
					String strTemp[] = formBean.getStrOfflineTariffDetailsHidden()[i].replace("^", "#").split("#");
					//strDirectTariffList1 Format--TrfName^Qty,DiscountAmt^ServiceTaxAmt^NetAmt^AmtPaidByPatient^AmtPaidByCLient^isEstimation^isPackage
					if(formBean.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1].equals("3") || formBean.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1].equals("4"))
					{
							if((voObj.getStrCreditPaymentType()[i].equals("11") || voObj.getStrCreditPaymentType()[i].equals("13")))//Credit or Credit Urgent
							{
								strAmountPaidByPatient="0";
								strAmountPaidByClient=strTemp[11];
							}
							else
							{
								strAmountPaidByPatient=strTemp[11];
								strAmountPaidByClient="0";
							}
							if(formBean.getStrOfflineTariffName()[i].contains("- ("))
							{
						strDirectTariffList1 = formBean.getStrOfflineTariffName()[i].substring(0, formBean
								.getStrOfflineTariffName()[i].lastIndexOf("- (") - 1) + "@" + strTemp[4] + "/" + strTemp[14] + "^" + formBean
								.getStrOfflineTariffQty()[i] + " " + strTemp[14] + "^" + formBean.getStrOfflineTariffDiscount()[i] + "^" + formBean
								.getStrOfflineTariffServiceTax()[i] + "^" + formBean.getStrOfflineTariffNetAmount()[i]+"^"+strAmountPaidByPatient+"^"+strAmountPaidByClient+"^0"+"^"+strTemp[7];
							}
							else
							{
								strDirectTariffList1 = formBean.getStrOfflineTariffName()[i] + "@" + strTemp[4] + "/" + strTemp[14] + "^" + formBean
										.getStrOfflineTariffQty()[i] + " " + strTemp[14] + "^" + formBean.getStrOfflineTariffDiscount()[i] + "^" + formBean
										.getStrOfflineTariffServiceTax()[i] + "^" + formBean.getStrOfflineTariffNetAmount()[i]+"^"+strAmountPaidByPatient+"^"+strAmountPaidByClient+"^0"+"^"+strTemp[7];
							}
					}
					else
					{
						if(formBean.getStrOfflineTariffName()[i].contains("- ("))
						{
						strDirectTariffList1 = formBean.getStrOfflineTariffName()[i].substring(0, formBean
								.getStrOfflineTariffName()[i].lastIndexOf("- (") - 1) + "@" + strTemp[4] + "/" + strTemp[14] + "^" + formBean
								.getStrOfflineTariffQty()[i] + " " + strTemp[14] + "^" + formBean.getStrOfflineTariffDiscount()[i] + "^" + formBean
								.getStrOfflineTariffServiceTax()[i] + "^" + formBean.getStrOfflineTariffNetAmount()[i]+"^0^0^0"+"^"+strTemp[7];
						}
						else
						{
							strDirectTariffList1 = formBean.getStrOfflineTariffName()[i]+ "@" + strTemp[4] + "/" + strTemp[14] + "^" + formBean
									.getStrOfflineTariffQty()[i] + " " + strTemp[14] + "^" + formBean.getStrOfflineTariffDiscount()[i] + "^" + formBean
									.getStrOfflineTariffServiceTax()[i] + "^" + formBean.getStrOfflineTariffNetAmount()[i]+"^0^0^0"+"^"+strTemp[7];
						}
					}
					
					
					
					
					//strArrayTariffList Format--strDirectTariffList1(TrfName^Qty,DiscountAmt^ServiceTaxAmt^NetAmt^AmtPaidByPatient^AmtPaidByCLient^isEstimation^isPackage)
												//#GroupId#GroupName#ClientNo#CerditLetterNo
					if(formBean.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1].equals("3") || formBean.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1].equals("4"))
					{
						if((voObj.getStrCreditPaymentType()[i].equals("11") || voObj.getStrCreditPaymentType()[i].equals("13")))//Credit or Credit Urgent
						{
							
							//strArrayTariffList[i] = strDirectTariffList1 + "#" + strTemp[1] + "#" + strTemp[19] +"#" +clientName +"#"+formBean.getStrCreditLetterNo()[i]+"-"+formBean.getStrCreditRefDate1()[i];
							strArrayTariffList[i] = strDirectTariffList1 + "#" + strTemp[1] + "#" + strTemp[19] +"#" +clientName +"#"+formBean.getStrCreditLetterNo()[i].replace("^","#").split("#")[0]+"-"+formBean.getStrCreditLetterNo()[i].replace("^","#").split("#")[1];
						}
						else
						{
							strArrayTariffList[i] = strDirectTariffList1 + "#" + strTemp[1] + "#" + strTemp[19] +"#NA#NA";
						}						
					}
					else
					{	
						strArrayTariffList[i] = strDirectTariffList1 + "#" + strTemp[1] + "#" + strTemp[19] + "#NA#NA#";///Amit Ateria
					}
				}
				
				if(formBean.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1].equals("3") || formBean.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1].equals("4"))
				{
					tariffPrintMap = PrintHLP.populateCreditLetterMapForPrinting(strArrayTariffList, tariffPrintMap,new BillConfigUtil(formBean.getStrHospitalCode()));
				}
				else
				{	
					tariffPrintMap = PrintHLP.populateGroupMapForPrinting(strArrayTariffList, tariffPrintMap,new BillConfigUtil(formBean.getStrHospitalCode()));
				}
			}

			formBean.setStrBillNo(voObj.getStrBillNo());
			formBean.setStrReceiptNo("1");
			//formBean.setStrCrNo("");

			if (!voObj.getStrMsgType().equals("1"))
			{
				if (formBean.getStrOffLineHospitalService().equals("2"))//IPD
				{
					PrintHLP.IPD_ESTIMATION(formBean.getStrBillNo(), formBean.getStrOffLineAccountNo(), formBean.getStrOffLineBillingService(), formBean.getStrHospitalCode(), 
											formBean.getStrReceiptNo(),request, tariffPrintMap, "1", 0,"0","");
					
					String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
					formBean.setFilePath(fileName);
					request.setAttribute("filePath", fileName);
					formBean.setIsOpenPopUp("1");
				} 
				else
				{					
					/*if(formBean.getStrOffLineTreatmentCategory().replace("^", "#").split("#")[1].equals("3") || formBean.getStrOffLineTreatmentCategory().replace("^", "#").split("#")[1].equals("4"))
					{
						PrintHLP.OPD_SERVICES_CreditBill(formBean.getStrBillNo(), formBean.getStrOffLineBillingService(), 
														formBean.getStrHospitalCode(), formBean.getStrReceiptNo(), request, tariffPrintMap, "1", 0,formBean.getStrEmployeeName());
						String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
						formBean.setFilePath(fileName);
						request.setAttribute("filePath", fileName);
						formBean.setIsOpenPopUp("1");						
					}
					else
					{*/
						PrintHLP.OPD_ESTIMATION(formBean.getStrBillNo(), formBean.getStrOffLineBillingService(), formBean
								.getStrHospitalCode(), formBean.getStrReceiptNo(), request, tariffPrintMap, "1", 0,"0","");
						String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
						formBean.setFilePath(fileName);
						request.setAttribute("filePath", fileName);
						formBean.setIsOpenPopUp("1");
					//}

				}

				formBean.setStrNormalMsg("Estimation No. '" + formBean.getStrBillNo() + "/1" + "' Generated Successfully ");
				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo("1");
				fRes = true;
			} 
			else
			{
				fRes = false;
				throw new Exception(voObj.getStrMsgString());
			}
		} 
		catch (Exception e)
		{
			String err = e.getMessage();
			HisException eObj = new HisException("Billing Transaction","CashCollectionOfflineTransBSDATA.insertOfflineReceiptService()-->", err);
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} 
		finally
		{
			bo = null;
			voObj = null;
		}

		return fRes;

	}
	public static boolean insertOfflineReceiptPackage(CashCollectionOfflineTransFB formBean,HttpServletRequest request)
	{

		boolean fRes = false;
		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;

		try
		{
			bo = new CashCollectionOfflineTransBO();
			formBean.setStrOffLineClientPatientNo(formBean.getStrOffLineClientDetailsHidden().replace("^", "#").split("#")[0]);
			formBean.setStrOffLineAdmissionNo(formBean.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[0]);
			String[] strWardDtls = formBean.getStrOffLineWard().replace("^", "#").split("#");
			formBean.setStrOffLineWard(strWardDtls[0]);
			formBean.setStrOffLineIpdChargeTypeId(strWardDtls[1]);
			formBean.setStrOffLineEpisode(formBean.getStrOffLineEpisode().replace("^", "#").split("#")[0]);
			formBean.setStrOffLinePartPaymentAmount(formBean.getStrPartpayment());

			//formBean.setadvSecFlag(formBean.getadvSecFlag());

			formBean.setStrOffLineApprovedBy(formBean.getStrApprovedByCombo());
			formBean.setStrOffLineRemarks(formBean.getStrRemarksCombo2());

			voObj = (CashCollectionOfflineTransVO) TransferObjectFactory.populateData("billing.transactions.CashCollectionOfflineTransVO", formBean);

			voObj.setStrOffLineTreatmentCategory(formBean.getStrOffLineTreatmentCategory().replace("^", "#").split("#")[0]);
			voObj.setStrOffLineTreatmentCategoryGroup(formBean.getStrOffLineTreatmentCategory().replace("^", "#").split("#")[1]);
			bo.insertOfflineReceiptPackage(voObj);

			formBean.setStrBillNo(voObj.getStrBillNo());
			formBean.setStrReceiptNo("1");
			//formBean.setStrCrNo("");

			if (!voObj.getStrMsgType().equals("1"))
			{
				PrintHLP.PART_PAYMENT(formBean.getStrBillNo(), formBean.getStrOffLineBillingService(), formBean
						.getStrHospitalCode(), formBean.getStrReceiptNo(), request, 0,"");

				String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
				formBean.setFilePath(fileName);
				request.setAttribute("filePath", fileName);
				formBean.setIsOpenPopUp("1");
				
				formBean.setStrNormalMsg("Receipt No. '" + formBean.getStrBillNo() + "/1" + "' Generated Successfully for the Collected Amount <i class='fas fa-rupee-sign'></i> '" + HisUtil
								.getAmountWithDecimal(formBean.getStrOfflineTotalRecAmount(), 2) + "'");

				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo("1");
				fRes = true;
			} 
			else
			{
				String err = voObj.getStrMsgString();
				fRes = false;
				throw new Exception(err);
			}

		} catch (Exception e)
		{

			HisException eObj = new HisException("Billing Transaction",
					"CashCollectionOfflineTransBSDATA.insertOfflineReceiptPackage()-->", e.getMessage());

			formBean
					.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		}

		return fRes;

	}
	public static void setPackageAmountValues( CashCollectionOfflineTransFB formBean, HttpServletRequest request,
			HttpServletResponse response) {
		
		
		try {
			String temp = "";
			WebRowSet ws=null;
			HisUtil util = new HisUtil("ADT","AdmissionAdviceTransDATA");
			CashCollectionOfflineTransVO vo = new CashCollectionOfflineTransVO();
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrOffLineWard(request.getParameter("ward").replace("^", "#").split("#")[0]);
			vo.setStrOffLineTreatmentCategory(request.getParameter("treatmentCat").replace("^", "#").split("#")[0]);
			
			CashCollectionOfflineTransBO bo = new CashCollectionOfflineTransBO();
			bo.getBillingPackageNames(vo);
			if(vo.getPackageComboValuesWs()!=null && vo.getPackageComboValuesWs().size()>0)
				temp = util.getOptionValue(vo.getPackageComboValuesWs(), "0","0^Select Value", false);
			else
				temp = util.getOptionValue(vo.getPackageComboValuesWs(), "0","0^Select Value", false);
			
			formBean.setStrPackageComboValues(temp);
			response.getWriter().print(formBean.getStrPackageComboValues());
			
		} catch (Exception e) {
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("Billing Transaction",
					"CashCollectionOfflineTransBSDATA->setPackageAmountValues()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
	}
	
	public static void getAdvanceDtls(CashCollectionOfflineTransFB formBean,		
			HttpServletRequest request) {		
		// TODO Auto-generated method stub		
				
		try{		
			CashCollectionOfflineTransVO vo= new CashCollectionOfflineTransVO();		
			CashCollectionOfflineTransBO bo = new CashCollectionOfflineTransBO();		
			bo.getAdvanceDtls(vo);		
					
					
					
					
					
					
		}catch(Exception e){		
			e.printStackTrace();		
			HisException eObj = new HisException("Billing Transaction","CashCollectionOfflineTransBSDATA.insertOfflineReceiptPackage()-->", e.getMessage());		
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");		
			eObj = null;		
		}		
				
	}		
		
	public static void getAccountCategory(		
			CashCollectionOfflineTransFB formBean, HttpServletRequest request,HttpServletResponse response) {		
		// TODO Auto-generated method stub		
				
		HisUtil util=null;		
				
		try{		
			util = new HisUtil("Billing Transaction", "CashCollectionTrans");		
			CashCollectionOfflineTransVO vo= new CashCollectionOfflineTransVO();		
			CashCollectionOfflineTransBO bo = new CashCollectionOfflineTransBO();		
			vo.setStrHospitalCode(formBean.getStrHospitalCode());		
			String accCat=(request.getParameter("catCode"));		
			bo.getAccountCategory(vo);		
					
			String temp = util.getOptionValue(vo.getAccCatWs(), accCat, "",false);		
			formBean.setAccountCategoryList(temp);		
			response.getWriter().print(formBean.getAccountCategoryList());		
					
					
					
		}catch(Exception e){		
			e.printStackTrace();		
			HisException eObj = new HisException("Billing Transaction","CashCollectionOfflineTransBSDATA.insertOfflineReceiptPackage()-->", e.getMessage());		
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");		
			eObj = null;		
		}		
				
				
	}

	

	/**
	 * writes populated Bill Service Combo box (Option List) based on Hospital
	 * Service and Request Type as Ajax Response.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void getPaymentModeListByPatCategory(CashCollectionOfflineTransFB formBean,HttpServletRequest request, HttpServletResponse response)
	{

		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;
		HisUtil util = null;

		try
		{
			bo = new CashCollectionOfflineTransBO();
			voObj = new CashCollectionOfflineTransVO();

			String strHospitalService = request.getParameter("hService");
			String strRequestType = request.getParameter("requestType");
			
			String strPatCategory ="", tempReceiptPayMode="";
			String[] strPatReceiptPayMode= new String[1] ;
			
			if (strHospitalService == null)
				strHospitalService = "0";
			if (strRequestType == null)
				strRequestType = "0";
			
			if(strRequestType.equalsIgnoreCase("1"))
			{
				strPatCategory = request.getParameter("patCategory");
			}
			
			if(strRequestType.equalsIgnoreCase("2"))  //refund
			{
				strPatCategory = request.getParameter("recieptPatCategory"); 
				tempReceiptPayMode = request.getParameter("patReceiptPayMode"); 
			}
			
			
			if(strPatCategory==null)
				strPatCategory="0";
			
			if(tempReceiptPayMode==null)
				tempReceiptPayMode="0";
			
			strPatReceiptPayMode[0]=tempReceiptPayMode;

			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			voObj.setStrOffLineHospitalService(strHospitalService);
			voObj.setStrOffLineRequestType(strRequestType);
			voObj.setStrOffLineTreatmentCategory(strPatCategory);
			voObj.setStrOfflinePaymentMode(strPatReceiptPayMode);

			bo.getPaymentModeListByPatCategory(voObj);

			if (voObj.getStrMsgType().equals("1"))
			{
				throw new Exception(voObj.getStrMsgString());

			}
			

			util = new HisUtil("Billing Transaction", "CashCollectionTrans");
			String temp = "<option value='0'>Select Value</option>";

			if (voObj.getStrPaymentModeList().size() != 0)
			{
				temp = util.getOptionValue(voObj.getStrPaymentModeList(),"","",
						false);

			}
			formBean.setStrPaymentModeContents(temp);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} 
		catch (Exception e)
		{
			if(voObj.getStrMsgType().equals("2"))
			{
				formBean.setStrErrMsg("Payment Mode For Selected Category Not Found!!!");
			}
			else
			{
				String strmsgText = e.getMessage();
				new HisException("Billing", "CashCollectionOfflineTransBSDATA->getPaymentModeListByPatCategory()", strmsgText);
			}
		} 
		finally
		{

			bo = null;

			voObj = null;

			util = null;
		}

	}
	
	public static boolean initBS(HttpServletRequest request, CashCollectionOfflineTransFB formBean)
	{
		boolean bResultVal = true;
		String strCrNo = formBean.getStrCrNo();

		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;
		BillConfigUtil configUtil = null;
		HisUtil hisUtil = null;

		try
		{
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			String strPatView = "";

			strPatView = PatientDtlHLPNew.compactPatientWithAdmissionDtlCash(strCrNo, formBean.getStrHospitalCode(), false);
			//formBean.setStrMobileNo(PatientDtlHLP.strMobileNo);
			String[] str=strPatView.replace("~","___").split("___");
			formBean.setStrPatientDetailsView(str[0]);
			//formBean.setStrPatientDetailsView(strPatView);
			String strOffLineBillingService=formBean.getStrOffLineBillingService();
			
			/*if(str[1].equals("1"))//AdmittedDetailsFound
			{
				if(PatientDtlHLP.strAdmittedTreamentCatCode!=null && !PatientDtlHLP.strAdmittedTreamentCatCode.equals(""))
				{
					formBean.setStrTreatmentCategory(PatientDtlHLP.strAdmittedTreamentCatCode);
					formBean.setStrIsAdmittedTreatmentCategoryPresent("1");//1-Yes,0-No
					formBean.setStrTreatmentCategoryGroup(PatientDtlHLP.strAdmittedTreamentCatCodeGroup);
					
				}
			}
			else if(PatientDtlHLP.strTreamentCatCode!=null && !PatientDtlHLP.strTreamentCatCode.equals(""))
				{
					formBean.setStrTreatmentCategory(PatientDtlHLP.strTreamentCatCode);///Primary Category
					formBean.setStrTreatmentCategoryGroup(PatientDtlHLP.strTreamentCatCodeGroup);
				}*/
			
			bo = new CashCollectionOfflineTransBO();
			voObj = new CashCollectionOfflineTransVO();
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			configUtil = new BillConfigUtil(voObj.getStrHospitalCode());

			hisUtil = new HisUtil("Billing", "CashCollectionOfflineTransBSDATA");

			formBean.setStrIpdThirdPartyBenefit(configUtil.getIpdThirdPartyBilling());
			formBean.setStrOpdThirdPartyBenefit(configUtil.getOpdThirdPartyBilling());
			formBean.setStrEmergencyThirdPartyBenefit(configUtil.getEmergencyThirdPartyBilling());

			formBean.setStrConsumableChargesGroupId(configUtil.getStrConsumableChargesGroupId());
			formBean.setStrConsumableChargesTariffCode(configUtil.getStrConsumableChargesTariffCode());
			formBean.setPrintMode(BillConfigUtil.PRINT_MODE.toString());//Laser Printing or DMP Printing
			formBean.setStrArogyaCatId(configUtil.getStrArogyaShreeCategory());
			formBean.setStrArogyaTSCatId(configUtil.getStrArogyaShreeTSCategory());
			formBean.setStrWchCatId(configUtil.getStrWSHCategory());
			formBean.setStrUrgSur(configUtil.getStrUrgTrfSur());
			//System.out.println("formBean.setStrUrgTrfSur"+formBean.getStrUrgSur());
			formBean.setStrSurCc(configUtil.getStrSurCc());
			formBean.setStrSurDc(configUtil.getStrSurDc());
			formBean.setStrSurIc(configUtil.getStrSurIc());
			formBean.setStrSurId(configUtil.getStrSurId());
			formBean.setStrSurCc1(configUtil.getStrSurCc1());
			formBean.setStrSurDc1(configUtil.getStrSurDc1());
			formBean.setStrSurIc1(configUtil.getStrSurIc1());
			formBean.setStrSurId1(configUtil.getStrSurId1());
			formBean.setDefsurlim(BillConfigUtil.DEFAULT_SURCHARGE_LIMIT);

			formBean.setStrArogyaTSCatCreditLimit(configUtil.getStrArogyaTSCatCreditLimit());

			if (formBean.getStrOffLineHospitalService().equals("2"))
			{
				formBean.setStrFreeCategory(configUtil.getIpdFreeCategory());
			} 
			else if (formBean.getStrOffLineHospitalService().equals("1"))
			{
				formBean.setStrFreeCategory(configUtil.getOpdFreeCategory());
			} 
			else
			{
				formBean.setStrFreeCategory(configUtil.getEmergencyFreeCategory());
			}

			formBean.setStrCurrentDate(hisUtil.getASDate("dd-MMM-yyyy"));

			CashCollectionOfflineTransBSDATA.initOffLineDetails(formBean, bo, voObj);

			formBean.setStrIsRefundReq(configUtil.getGeneralCCOfflineRefundRequired());
			formBean.setStrPrintMessageLimit(configUtil.getGeneralPrintMessageLimit());
			formBean.setCurrentBserviceId(strOffLineBillingService);

		} 
		catch (Exception e)
		{
			bResultVal = false;
			String msgStr = e.getMessage();

			if (msgStr.contains("CR."))
			{
				formBean.setStrErrMsg("Invalid CR. No./Category Expired");
			} 
			else
			{
				HisException eObj = new HisException("Billing", "CashCollectionOfflineTransDATA->init()", msgStr);
				formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				formBean.setStrCrNo("");
				eObj = null;
			}
		} 
		finally
		{
			bo = null;
			voObj = null;
			configUtil = null;
			hisUtil = null;
		}

		return bResultVal;
	}
	
	public static boolean initAdvancedCashBS(HttpServletRequest request, CashCollectionOfflineTransFB formBean)
	{
		boolean bResultVal = true;
		String strCrNo = formBean.getStrCrNo();

		CashCollectionOfflineTransBO bo = null;
		CashCollectionOfflineTransVO voObj = null;
		BillConfigUtil configUtil = null;
		HisUtil hisUtil = null;

		try
		{
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			String strPatView = "";

			strPatView = PatientDtlHLPNew.compactPatientWithAdmissionDtlCash(strCrNo, formBean.getStrHospitalCode(), false);
		    //formBean.setStrMobileNo(PatientDtlHLP.strMobileNo);
			/*String[] str=strPatView.replace("~","#").split("#");
			formBean.setStrPatientDetailsView(str[0]);*/
			formBean.setStrPatientDetailsView(strPatView);
			
			/*if(str[1].equals("1"))//AdmittedDetailsFound
			{
				if(PatientDtlHLP.strAdmittedTreamentCatCode!=null && !PatientDtlHLP.strAdmittedTreamentCatCode.equals(""))
				{
					formBean.setStrTreatmentCategory(PatientDtlHLP.strAdmittedTreamentCatCode);
					formBean.setStrIsAdmittedTreatmentCategoryPresent("1");//1-Yes,0-No
					formBean.setStrTreatmentCategoryGroup(PatientDtlHLP.strAdmittedTreamentCatCodeGroup);
					
				}
			}
			else if(PatientDtlHLP.strTreamentCatCode!=null && !PatientDtlHLP.strTreamentCatCode.equals(""))
				{
					formBean.setStrTreatmentCategory(PatientDtlHLP.strTreamentCatCode);///Primary Category
					formBean.setStrTreatmentCategoryGroup(PatientDtlHLP.strTreamentCatCodeGroup);
				}*/
			
			bo = new CashCollectionOfflineTransBO();
			voObj = new CashCollectionOfflineTransVO();
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			configUtil = new BillConfigUtil(voObj.getStrHospitalCode());

			hisUtil = new HisUtil("Billing", "CashCollectionOfflineTransBSDATA");

			formBean.setStrIpdThirdPartyBenefit(configUtil.getIpdThirdPartyBilling());
			formBean.setStrOpdThirdPartyBenefit(configUtil.getOpdThirdPartyBilling());
			formBean.setStrEmergencyThirdPartyBenefit(configUtil.getEmergencyThirdPartyBilling());

			formBean.setStrConsumableChargesGroupId(configUtil.getStrConsumableChargesGroupId());
			formBean.setStrConsumableChargesTariffCode(configUtil.getStrConsumableChargesTariffCode());
			formBean.setPrintMode(BillConfigUtil.PRINT_MODE.toString());//Laser Printing or DMP Printing
			formBean.setStrArogyaCatId(configUtil.getStrArogyaShreeCategory());
			formBean.setStrArogyaTSCatId(configUtil.getStrArogyaShreeTSCategory());
			formBean.setStrWchCatId(configUtil.getStrWSHCategory());
			formBean.setStrUrgSur(configUtil.getStrUrgTrfSur());
			formBean.setStrSurCc(configUtil.getStrSurCc());
			formBean.setStrSurDc(configUtil.getStrSurDc());
			formBean.setStrSurIc(configUtil.getStrSurIc());
			formBean.setStrSurId(configUtil.getStrSurId());
			formBean.setStrSurCc1(configUtil.getStrSurCc1());
			formBean.setStrSurDc1(configUtil.getStrSurDc1());
			formBean.setStrSurIc1(configUtil.getStrSurIc1());
			formBean.setStrSurId1(configUtil.getStrSurId1());
			formBean.setStrArogyaTSCatCreditLimit(configUtil.getStrArogyaTSCatCreditLimit());
			formBean.setDefsurlim(BillConfigUtil.DEFAULT_SURCHARGE_LIMIT);


			if (formBean.getStrOffLineHospitalService().equals("2"))
			{
				formBean.setStrFreeCategory(configUtil.getIpdFreeCategory());
			} 
			else if (formBean.getStrOffLineHospitalService().equals("1"))
			{
				formBean.setStrFreeCategory(configUtil.getOpdFreeCategory());
			} 
			else
			{
				formBean.setStrFreeCategory(configUtil.getEmergencyFreeCategory());
			}

			formBean.setStrCurrentDate(hisUtil.getASDate("dd-MMM-yyyy"));

			CashCollectionOfflineTransBSDATA.initAdvancedOffLineDetails(formBean, bo, voObj);
			
			
			formBean.setStrIsRefundReq(configUtil.getGeneralCCOfflineRefundRequired());
			formBean.setStrPrintMessageLimit(configUtil.getGeneralPrintMessageLimit());

		} 
		catch (Exception e)
		{
			bResultVal = false;
			String msgStr = e.getMessage();

			if (msgStr.contains("CR."))
			{
				formBean.setStrErrMsg("Invalid CR. No./Category Expired");
			} 
			else
			{
				HisException eObj = new HisException("Billing", "CashCollectionOfflineTransDATA->init()", msgStr);
				formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				formBean.setStrCrNo("");
				eObj = null;
			}
		} 
		finally
		{
			bo = null;
			voObj = null;
			configUtil = null;
			hisUtil = null;
		}

		return bResultVal;
	}
}
