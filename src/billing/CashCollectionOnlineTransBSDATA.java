package billing;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.tools.hlp.PatientDtlHLPNew;
import hisglobal.utility.HisUtil;
import hisglobal.utility.SMSHttpsNICPostClient;
import hisglobal.utility.SMSSender.SMSHttpPostClient;

// TODO: Auto-generated Javadoc
/**
 * The Class CashCollectionOnlineTransBSDATA.
 */
public class CashCollectionOnlineTransBSDATA {

	/**
	 * method used to check whether the System's IP Address is Registered in
	 * Counter Master or Not.
	 * 
	 * @param request
	 * @param formBean
	 */
	public static void checkCounterStatus(HttpServletRequest request,CashCollectionOnlineTransFB formBean) 
	{
		CashCollectionOnlineTransBO bo = null;
		CashCollectionOnlineTransVO voObj = null;

		try 
		{
			formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR").toString());
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			bo = new CashCollectionOnlineTransBO();
			voObj = new CashCollectionOnlineTransVO();

			voObj.setStrIpAddress(formBean.getStrIpAddress());
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.checkCounterStatus(voObj);

			String strCounterId = voObj.getStrCounterId();

			if (strCounterId != null) 
			{
				if (strCounterId.trim().length() < 4) 
				{
					formBean.setStrErrMsg("Cash Collection is Not Applicable, System IP Address is not Registered as Counter");
					formBean.setStrCrNo("");
				}
			}

			formBean.setStrConfirmationType(new BillConfigUtil(formBean.getStrHospitalCode()).getGeneralCashCollectionConfrimType());
			
		} 
		catch (Exception e) 
		{
			String msgStr = e.getMessage();
			HisException eObj = new HisException("Billing","CashCollectionOnlineTransBSDATA->checkCounterStatus()", msgStr);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "], Contact System Administrator! ");

			formBean.setStrCrNo("");
			eObj = null;
		}
		finally 
		{
			bo = null;
			voObj = null;
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
	public static boolean init(HttpServletRequest request,CashCollectionOnlineTransFB formBean)
	{
		boolean bResultVal = true;
		String strCrNo = formBean.getStrCrNo();
		CashCollectionOnlineTransBO bo = null;
		CashCollectionOnlineTransVO voObj = null;
		BillConfigUtil configUtil = null;
		HisUtil hisUtil = null;

		try
		{
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			String strPatView = "";

			strPatView = PatientDtlHLPNew.compactPatientWithAdmissionDtlCash(strCrNo,formBean.getStrHospitalCode(), false);

			formBean.setStrPatientDetailsView(strPatView.replace("@","__").split("__")[0]);

			bo = new CashCollectionOnlineTransBO();
			voObj = new CashCollectionOnlineTransVO();
			configUtil = new BillConfigUtil(formBean.getStrHospitalCode());

			hisUtil = new HisUtil("Billing", "CashCollectionOnlineTransBSDATA");

			formBean.setStrIpdThirdPartyBenefit(configUtil.getIpdThirdPartyBilling());
			formBean.setStrOpdThirdPartyBenefit(configUtil.getOpdThirdPartyBilling());
			formBean.setStrEmergencyThirdPartyBenefit(configUtil.getEmergencyThirdPartyBilling());

			formBean.setStrConsumableChargesGroupId(configUtil.getStrConsumableChargesGroupId());
			formBean.setStrConsumableChargesTariffCode(configUtil.getStrConsumableChargesTariffCode());
			formBean.setPrintMode(BillConfigUtil.PRINT_MODE.toString());//Laser Printing or DMP Printing
			formBean.setStrCreditApprovalRequired(configUtil.getStrCreditCashlessAppRequired());//Credit Approval Reqwuired or not 0-Not Required,1-Required
			formBean.setStrCurrentDate(hisUtil.getASDate("dd-MMM-yyyy"));
			formBean.setStrUrgTrfSur(configUtil.getStrUrgTrfSur());
			formBean.setStrSurCc(configUtil.getStrSurCc());
			formBean.setStrSurDc(configUtil.getStrSurDc());
			formBean.setStrSurIc(configUtil.getStrSurIc());
			formBean.setStrSurId(configUtil.getStrSurId());
			formBean.setStrSurCc1(configUtil.getStrSurCc1());
			formBean.setStrSurDc1(configUtil.getStrSurDc1());
			formBean.setStrSurIc1(configUtil.getStrSurIc1());
			formBean.setStrSurId1(configUtil.getStrSurId1());
			formBean.setDefsurlim(BillConfigUtil.DEFAULT_SURCHARGE_LIMIT);

			CashCollectionOnlineTransBSDATA.initOnLineDetails(formBean, bo, voObj);

			formBean.setStrPrintMessageLimit(configUtil.getGeneralPrintMessageLimit());
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			bResultVal = false;
			String msgStr = e.getMessage();

			if (msgStr.contains("CR."))
			{
				formBean.setStrErrMsg("Invalid CR. No./Category Expired");
			} 
			else
			{
				HisException eObj = new HisException("Billing","CashCollectionOnlineTransBSDATA->init()", msgStr);
				formBean.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID()+ "], Contact System Administrator! ");
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
	 * Initialize all the required information like Online Details for given Cr
	 * Number.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param bo
	 *            Business Object
	 * @param voObj
	 *            Value Object
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static void initOnLineDetails(CashCollectionOnlineTransFB formBean,CashCollectionOnlineTransBO bo, CashCollectionOnlineTransVO voObj) throws Exception 
	{		
		String temp = "";
		HisUtil util = null;
		
		try 
		{						
			voObj.setStrCrNo(formBean.getStrCrNo());
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getOnLineDetails(voObj);
			
			formBean.setStrAvlWalletMoney(voObj.getStrAvlWalletMoney());
			formBean.setStrWalletNo(voObj.getStrWalletNo());
			formBean.setStrWalletNoMasked(HisUtil.maskNumber(voObj.getStrWalletNo(),"xxxxxxxxxxx####") );
			formBean.setStrMobileNo(voObj.getStrMobileNo());

			if (voObj.getStrMsgType().equals("1")) 
			{
				throw new Exception(voObj.getStrMsgString());
			}

			
			util = new HisUtil("Billing","Cash Collection");


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
			/*if (voObj.getStrRelationWS() != null && voObj.getStrRelationWS().size() != 0) 
			{
				temp = util.getOptionValue(voObj.getStrRelationWS(), "0", "0^Select Value", false);
				formBean.setStrRelatinDetails(temp);
			}*/
			
			String strOnLineView = CashCollectionOnlineTransHLP.getOnLineDetailsView_BS(voObj);
			formBean.setStrOnlineDetailsView(strOnLineView);
			//String treatCat=CashCollectionOnlineTransHLP.treatcat;
			//System.out.println("treatcat=="+treatCat);
			//formBean.setTreatmentCategory(treatCat);
			/*
			 * StringBuffer strOnLineClientView = new StringBuffer("");
			 * 
			 * if (formBean.getStrHospitalService().equals("1") &&
			 * formBean.getStrOpdThirdPartyBenefit().equals("1") ||
			 * formBean.getStrHospitalService().equals("2") &&
			 * formBean.getStrIpdThirdPartyBenefit().equals("1") ||
			 * formBean.getStrHospitalService().equals("3") &&
			 * formBean.getStrEmergencyThirdPartyBenefit().equals("1")) {
			 * 
			 * strOnLineClientView.append(CashCollectionOnlineTransHLP
			 * .getOnLineClientDetailsView(voObj)); }
			 * 
			 * strOnLineClientView.append(CashCollectionOnlineTransHLP
			 * .getOnlineOtherDetails(voObj));
			 * 
			 * if (voObj.getStrRequestType().equals("1") &&
			 * (voObj.getStrBillingService().equals("10") ||
			 * voObj.getStrBillingService().equals("11") || voObj
			 * .getStrBillingService().equals("12"))) {
			 * 
			 * strOnLineClientView.append(CashCollectionOnlineTransHLP
			 * .getOnLineTariffDetailsView(voObj)); }
			 * 
			 * if (voObj.getStrRequestType().equals("1") &&
			 * (voObj.getStrAccountNo() != null || voObj
			 * .getStrAccountNo().trim().length() != 0) &&
			 * voObj.getStrBillingService().equals("20")) {
			 * 
			 * strOnLineClientView.append(CashCollectionOnlineTransHLP
			 * .getOnLinePartPaymentDetailsView(voObj)); }
			 * 
			 * if (voObj.getStrRequestType().equals("2")) {
			 * strOnLineClientView.append(CashCollectionOnlineTransHLP
			 * .getOnLineRefundTariffDetailsView(voObj)); }
			 * 
			 * if (voObj.getStrRequestType().equals("3")) {
			 * strOnLineClientView.append(CashCollectionOnlineTransHLP
			 * .getOnLineReconcileTariffDetailsView(voObj)); }
			 * 
			 * if (voObj.getStrBillingService().equals("19") &&
			 * voObj.getStrRequestType().equals("1")) {
			 * 
			 * strOnLineClientView.append(CashCollectionOnlineTransHLP
			 * .getOnLineAdvanceDetailsViewBS(voObj)); }
			 * 
			 * formBean.setStrOnlineClientDetailsView(strOnLineClientView
			 * .toString());
			 */
		} catch (Exception e) {

			// e.printStackTrace();

			String msgStr = e.getMessage();
			HisException eObj = new HisException("Billing",
					"CashCollectionOnlineTransBSDATA->initOnlineDetails()", msgStr);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");

			formBean.setStrCrNo("");
			eObj = null;

		}finally{
			
			util = null;
			
		}

	}

	/**
	 * Initialize required information like Online Details based on the given
	 * Details.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void getOnlineDtls(HttpServletRequest request,HttpServletResponse response) 
	{
		CashCollectionOnlineTransBO bo = new CashCollectionOnlineTransBO();
		CashCollectionOnlineTransVO voObj = new CashCollectionOnlineTransVO();

		String strCrNo = request.getParameter("crNo");
		String strChargeTypeId = request.getParameter("chargeTypeId");
		String strBServiceId = request.getParameter("bServiceId");
		String strRequestNo = request.getParameter("reqNo");
		String strAdmissionNo = request.getParameter("admNo");
		String strAccountNo = request.getParameter("accNo");
		String strTreatmentCat = request.getParameter("treatCat");
		String strRequestFor = request.getParameter("reqFor");
		String strChargeTypeName = request.getParameter("chargeTypeName");
		String strRequestType = request.getParameter("reqType");
		String strBillNo = request.getParameter("billNo");
		String strGrpId = request.getParameter("grpId");
		String strCatCode = request.getParameter("catCode");

		if (strRequestNo == null) 		strRequestNo 	= "0";
		if (strAdmissionNo == null) 	strAdmissionNo 	= "";
		if (strAccountNo == null)		strAccountNo 	= "";
		if (strTreatmentCat == null)	strTreatmentCat = "";
		if (strRequestFor == null)		strRequestFor 	= "";
		if (strChargeTypeId == null)	strChargeTypeId = "0";
		if (strChargeTypeName == null)	strChargeTypeName = "";
		if (strBServiceId == null)		strBServiceId 	= "";
		if (strRequestType == null)		strRequestType 	= "";
		if (strBillNo == null)			strBillNo 		= "0";
		if (strGrpId == null)			strGrpId 		= "0";

		voObj.setStrCrNo(strCrNo);
		voObj.setStrRequestNo(strRequestNo);
		voObj.setStrAdmissionNo(strAdmissionNo);
		voObj.setStrAccountNo(strAccountNo);
		voObj.setStrTreatmentCategory(strTreatmentCat);
		voObj.setStrRequestFor(strRequestFor);
		voObj.setStrChargeTypeId(strChargeTypeId);
		voObj.setStrBillingService(strBServiceId);
		voObj.setStrChargeTypeName(strChargeTypeName);
		voObj.setStrRequestType(strRequestType);
		voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		voObj.setStrBillNo(strBillNo);
		voObj.setStrGroupId(strGrpId);
		voObj.setStrOffLineTreatmentCategory(strCatCode);
		voObj.setStrSeatId(request.getSession().getAttribute("SEATID").toString());  //added by vipul on 08.06.2021

		BillConfigUtil configUtil = new BillConfigUtil(voObj.getStrHospitalCode());

		try 
		{
			bo.getOnLineTariffDetails(voObj);

			if (voObj.getStrMsgType().equals("1")) 
			{
				throw new Exception(voObj.getStrMsgString());
			}
			
			StringBuffer clientView = null;

			/*
			 * String strAccountHeaderView = ""; String strAccountView = "";
			 * 
			 * if (!voObj.getStrAccountNo().equals("")) {
			 * 
			 * strAccountHeaderView = CashCollectionOnlineTransHLP.getAccountHeader();
			 * strAccountView = HLPAccountDtl.getAccountDetailsHLP(voObj
			 * .getStrAccountNo()); }
			 */

			if (!voObj.getStrBillingService().equals("21")) //Not Final Bill
			{
				clientView = new StringBuffer("");

				//If Third Party Billing/Credit Billing Allowed
				if (strChargeTypeId.equals("1")	&& configUtil.getOpdThirdPartyBilling().equals("1")	|| //OPD MORNING & Third Party Billing Allowed
					strChargeTypeId.equals("2")&& configUtil.getIpdThirdPartyBilling().equals("1")||   //IPD  & Third Party Billing Allowed
					strChargeTypeId.equals("3")	&& configUtil.getEmergencyThirdPartyBilling().equals("1")|| //EMG  & Third Party Billing Allowed
					strChargeTypeId.equals("4")	&& configUtil.getOpdThirdPartyBilling().equals("1"))//OPD SPL & Third Party Billing Allowed
				{

					clientView.append(CashCollectionOnlineTransHLP.getOnLineClientDetailsView(voObj));
				}
				clientView.append(CashCollectionOnlineTransHLP.getOnlineOtherDetails(voObj));
				//RequestType -1 Receipt,2-Refund && BillingService-10 Service icludes estimation certificate aswell,19-Advance,20-Part Payment,21-Final Settlement,24-Against Security,

				if (voObj.getStrRequestType().equals("1")&& (voObj.getStrBillingService().equals("10")|| // Receipt & Service OR --OR----Estimation Certificate 
					voObj.getStrBillingService().equals("11") || voObj.getStrBillingService().equals("12") || voObj.getStrBillingService().equals("25")))  //
				{
					clientView.append(CashCollectionOnlineTransHLP.getOnLineTariffDetailsView_BS(voObj));
				}
				if (voObj.getStrBillingService().equals("19")&& voObj.getStrRequestType().equals("1")) //Advance & Receipt
				{
					clientView.append(CashCollectionOnlineTransHLP.getOnLineAdvanceDetailsViewBS(voObj));
				}
				if (voObj.getStrRequestType().equals("1")&& (voObj.getStrAccountNo() != null || 
					voObj.getStrAccountNo().trim().length() != 0)&& voObj.getStrBillingService().equals("20")) 
				{
					clientView.append(CashCollectionOnlineTransHLP.getOnLinePartPaymentDetailsView(voObj));
				}
				
				if (voObj.getStrRequestType().equals("2")&& (voObj.getStrBillingService().equals("10")|| 
					voObj.getStrBillingService().equals("11") || voObj.getStrBillingService().equals("12")|| voObj.getStrBillingService().equals("25"))) 
				{
					clientView.append(CashCollectionOnlineTransHLP.getOnLineRefundTariffDetailsView_BS(voObj));
				}

				if (voObj.getStrRequestType().equals("2")&& voObj.getStrChargeTypeId().equals("2")&& voObj.getStrBillingService().equals("19")) 
				{
					clientView.append(CashCollectionOnlineTransHLP.getOnLineRefundAdvanceView_BS(voObj));
				}

				if (voObj.getStrRequestType().equals("3")) 
				{
					clientView.append(CashCollectionOnlineTransHLP.getOnLineReconcileTariffDetailsView(voObj));
				}
			} 
			else 
			{
				clientView = new StringBuffer("");
				if (!voObj.getStrRequestType().equals("3")) 
				{

					clientView.append("<div class='row'><div class='' id='onlineNetAmountDetailsDivId' style='display: none'></div>");
					clientView.append("<div class='col-sm-10' ><p class='subHeaders'><i class='fas fa-adjust text-info' data-toggle='modal' data-target='#finalADetailsModel' onclick=\"displayOnlineNetAmountDetails(this , 'finalAdjustmentNetAmountDtls');\"></i>&nbsp;Final Adjustment Details</p></div>");
					//clientView.append("<div class='col-sm-4' style=\"text-align:right\"><label style='font-weight: 501;'>Bill Type </label></div>");
					clientView.append("<div class='col-sm-2' ><select style='width:65%' name='strBillType' class='browser-default custom-select'><option value='1'>Consolidated Bill</option><option value='2' selected='selected'>Detailed Bill</option></select></div></div>");

					//System.out.println("voObj.getStrSancAmount()"+voObj.getStrSancAmount());
					//String strParticulaDtl = HLPParticularDtl.getParticularDtl(voObj.getStrAccountNo(),voObj.getStrHospitalCode(),voObj.getStrRequestNo(),
										//		voObj.getStrChargeTypeId(), voObj.getStrSancAmount(),voObj);
					
					String strParticulaDtl = HLPParticularDtl.getParticularDtl(voObj.getStrAccountNo(),voObj.getStrHospitalCode());
					String[] TestData2 = strParticulaDtl.split("\\####");
					if (TestData2[0].equals("ERROR")) 
					{
						throw new Exception(TestData2[1]);
					} 
					else 
					{
						clientView.append(TestData2[0]);
					}
				} 
				else 
				{
					clientView.append(CashCollectionOnlineTransHLP.getOnLineReconcileTariffDetailsView(voObj));
				}
			}
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(clientView.toString());
		} 
		catch (Exception e) 
		{
			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			
			try 
			{
				HisException eObj = new HisException("Billing","CashCollectionOnlineTransBSDATA->getOnlineDtls()", strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : "+ eObj.getErrorID()+ "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} 
			catch (IOException e1) 
			{
			}
		} 
		finally 
		{
			bo = null;
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
	public static void UNITVAL12(HttpServletRequest request,
			HttpServletResponse response) {
		// Declaring Variables
		String strData = request.getParameter("modName");

		String strTariffDtl = "";
		String strTariffDtl1 = "";
		// String msgStr = "";
		String[] data = strData.split("\\^");

		// Creating Object for BO & VO.
		CashCollectionOnlineTransVO vo = new CashCollectionOnlineTransVO();

		try {
			String strHospCode = request.getSession().getAttribute(
					"HOSPITAL_CODE").toString();
			// Calling TariffDtls
			strTariffDtl1 = HLPTariffDtl.getTariffDtlBS(data[0], data[1],
					strHospCode);
			strTariffDtl = strTariffDtl1 + '@' + data[2];

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strTariffDtl);

		} catch (Exception e) {

			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try {
				HisException eObj = new HisException("Billing",
						"CashCollectionOnlineTransBSDATA->UNITVAL12()", strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1) {

				new HisException("Billing",
						"IpdBillManagementTransDATA->UNITVAL12()", e1
								.getMessage());
			}
		} finally {

			if (vo != null)
				vo = null;
		}

	}

	/**
	 * gets Online Refund Tariff Pop-up as Ajax Response.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void getOnLineRefundTariffPopupDetails(
			HttpServletRequest request, HttpServletResponse response) {

		CashCollectionOnlineTransVO voObj = null;

		try {

			voObj = new CashCollectionOnlineTransVO();

			String strHidVal = request.getParameter("hidValue");

			if (strHidVal == null)
				strHidVal = "0";

			voObj.setStrRefundTariffHiddenValue(strHidVal);
			voObj.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			String temp = CashCollectionOnlineTransHLP.getRefundTariffPopUp_BS(voObj);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try {
				HisException eObj = new HisException(
						"Billing",
						"CashCollectionOnlineTransBSDATA->getOnLineRefundTariffPopupDetails()",
						strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1) {
				new HisException(
						"Billing",
						"IpdBillManagementTransDATA->getOnLineRefundTariffPopupDetails()",
						e1.getMessage());
			}
		} finally {

			voObj = null;

		}

	}
	
	/**
	 * gets Admission Cancellation Details as Ajax Response.
	 * 
	 * @param request
	 * @param response
	 */
	public static void getAdmissionCancellationDtls(HttpServletRequest request,
			HttpServletResponse response) {

		CashCollectionTransVO voObj = null;
		CashCollectionTransBO bo = null;
		String temp = "";
		String strPatAccStatus = "0";
		try {

			voObj = new CashCollectionTransVO();
			bo = new CashCollectionTransBO();

			String strCrNo = request.getParameter("crNo");
			String strHospitalService = request.getParameter("hService");

			if (strCrNo == null)
				strCrNo = "0";
			if (strHospitalService == null)
				strHospitalService = "0";
			voObj.setStrCrNo(strCrNo);
			voObj.setStrChargeTypeId(strHospitalService);
			voObj.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			bo.getAdmissionCancellationDtl(voObj);

			if (voObj.getAdmissionCancellationDetails().next())
				strPatAccStatus = voObj.getAdmissionCancellationDetails()
						.getString(21);

			if (strPatAccStatus.equals("1")) {
				voObj.getAdmissionCancellationDetails().beforeFirst();
				temp = CashCollectionTransHLP.getAdmissionCancellationDetails(
						voObj, "2");
			} else {
				temp = "@Patient Admitted in The Ward";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try {
				HisException eObj = new HisException(
						"Billing",
						"CashCollectionOnlineTransBSDATA->getAdmissionCancellationDtls()",
						strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1) {
				new HisException(
						"Billing",
						"IpdBillManagementTransDATA->getAdmissionCancellationDtls()",
						e1.getMessage());
			}
		} finally {

			voObj = null;
			bo = null;
		}

	}

	

	public static void updatePrintStatus(HttpServletRequest request,
			HttpServletResponse response) {

		try {

			String strBillNo = request.getParameter("billNo");
			String strReceiptNo = request.getParameter("recNo");

			if (strBillNo == null)
				strBillNo = "0";
			if (strReceiptNo == null)
				strReceiptNo = "0";

			PrintHLP.updatePrintStatus(strBillNo, strReceiptNo, request
							.getSession().getAttribute("HOSPITAL_CODE")
							.toString(), "0");

		} catch (Exception e) {

			HisException eObj = new HisException("Billing",
					"CashCollectionOnlineTransDATA->updatePrintStatus()", e
							.getMessage());
			String response1 = "ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator!";

			eObj = null;

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(response1);
			} catch (IOException e1) {

				new HisException("Billing",
						"CashCollectionOnlineTransDATA->updatePrintStatus()", e1
								.getMessage());
			}

		}
	}
	
	public static void rePrint(HttpServletRequest request,
			HttpServletResponse response) {

		try {

			 

			PrintHLP.reprintFile(request);

		} catch (Exception e) {

			HisException eObj = new HisException("Billing",
					"CashCollectionOnlineTransDATA->rePrint()", e
							.getMessage());
			String response1 = "ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator!";

			eObj = null;

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(response1);
			} catch (IOException e1) {

				new HisException("Billing",
						"CashCollectionOnlineTransDATA->rePrint()", e1
								.getMessage());
			}

		}
	}

	/**
	 * inserts Online Receipt Part Payment Details.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return true, if insert online receipt part payment
	 */
	public static boolean insertOnlineReceiptPartPayment(CashCollectionOnlineTransFB formBean , HttpServletRequest request) 
	{
		boolean fRes = false;
		CashCollectionOnlineTransBO bo = null;
		CashCollectionOnlineTransVO voObj = null;
		HisUtil hisUtil = null;
		try 
		{
			bo = new CashCollectionOnlineTransBO();
			hisUtil = new HisUtil("Billing", "CashCollectionOnlineTransBSDATA");

			String[] temp = formBean.getOnLineDataRadio().replace("^", "#").split("#");

			formBean.setStrRequestNo(temp[0]);
			formBean.setStrRequestDate(temp[1]);
			formBean.setStrRaisingDepartment(temp[2]);
			formBean.setStrChargeTypeId(temp[3]);
			formBean.setStrBillingService(temp[4]);
			formBean.setStrService(temp[5]);
			formBean.setStrGlobalRequestNo(temp[6]);
			formBean.setStrBillNo(temp[7]);
			formBean.setStrTreatmentCategory(temp[8]);
			formBean.setStrEpisode(temp[9]);
			formBean.setStrAdmissionNo(temp[10]);
			formBean.setStrAccountNo(temp[11]);
			formBean.setStrApprovalId(temp[12]);
			formBean.setStrRequestType(temp[13]);
			formBean.setStrRequestFor(temp[15]);

			if (temp[18].trim().length() < 1) 
			{
				formBean.setStrIpdChargeTypeId("0");
			} 
			else 
			{
				formBean.setStrIpdChargeTypeId(temp[18]);
			}
			if (temp[19].trim().equals("")) 
			{
				formBean.setStrWard("0");
			} 
			else 
			{
				formBean.setStrWard(temp[19]);
			}
			formBean.setStrReceiptNo(temp[20]);

			voObj = (CashCollectionOnlineTransVO) TransferObjectFactory.populateData("billing.transactions.CashCollectionOnlineTransVO", formBean);

			if (formBean.getStrOnlineClientDetails() != null) 
			{
				String strClientTemp[] = formBean.getStrOnlineClientDetails().replace("^", "#").split("#");
				voObj.setStrClientName(strClientTemp[0]);
				voObj.setStrClientType(strClientTemp[1]);
				voObj.setStrSancAmount(strClientTemp[2]);
				voObj.setStrClientBalance(strClientTemp[3]);
				voObj.setStrClientApprovalNo(strClientTemp[4]);
			}

			bo.insertOnlineReceiptPartPayment(voObj);

			formBean.setStrReceiptNo("1");
			formBean.setStrBillNo(voObj.getStrBillNo());

			formBean.setStrCrNo("");

			if (!voObj.getStrMsgType().equals("1")) 
			{
				//String smsMsg="You Paid Rs. "+formBean.getStrOnlineTotalRecAmount()+" for IPD Hospital Services Against Receipt No. "+formBean.getStrBillNo()+ "/1";
				String smsMsg="Dear "+formBean.getStrPatientDtlHidVal().replace("^","#").split("#")[7]  +", Payment of Rs. "+formBean.getStrOnlineTotalRecAmount()+" Received Against Bill No. "+formBean.getStrBillNo()+ "/1 on "+hisUtil.getDSDate("")+" "+hisUtil.getDSDate("hh:mi:ss:AM")+". "+formBean.getStrPatientDtlHidVal().replace("^","#").split("#")[15];
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
				//if(patMobileNo!=null && !patMobileNo.equals(""))
				//	SMSHttpPostClient.sendSMS (patMobileNo,smsmessage);//{
					 //code from sending message through CDAC MUmbai SMS Gateway
					 //SMSHttpPostClient.sendSingleSMSThroughSMSGateway(objSMSConfig.sms_username, objSMSConfig.sms_password,objSMSConfig.sms_senderId,objSMSConfig.sms_url, patientVO.getPatAddMobileNo(),message);
					/*
					 * new Thread( new Runnable() { public void run(){
					 * 
					 * SMSHttpPostClient.sendSMS (patMobileNo,smsmessage);
					 * 
					 * return; // to stop the thread } }).start(); }
					 */
				PrintHLP.PART_PAYMENT(formBean.getStrBillNo(), formBean.getStrBillingService(), formBean.getStrHospitalCode(),formBean.getStrReceiptNo() , request , 0,"");
				formBean.setStrNormalMsg("Receipt No. '"+ formBean.getStrBillNo()+ "/1"+ "' Generated Successfully for the Collected Amount <img src='/HBIMS/hisglobal/images/INR.png'> '"
						+ HisUtil.getAmountWithDecimal(formBean.getStrOnlineTotalRecAmount(), 2) + "'");
				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo("1");

				String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
				formBean.setFilePath(fileName);
				request.setAttribute("filePath", fileName);
				formBean.setIsOpenPopUp("1");

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
			HisException eObj = new HisException("Billing Transaction","CashCollectionOnlineTransBSDATA.insertOnlineReceiptPartPayment()-->",err);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} 
		finally 
		{
			bo = null;
			voObj = null;
		}
		return fRes;
	}

	public static boolean insertOnlineReceiptAdvance(CashCollectionOnlineTransFB formBean  , HttpServletRequest request) 
	{
		boolean fRes = false;
		CashCollectionOnlineTransBO bo = null;
		CashCollectionOnlineTransVO voObj = null;
		HisUtil hisUtil = null;
        try 
		{
			bo = new CashCollectionOnlineTransBO();
			hisUtil = new HisUtil("Billing", "CashCollectionOnlineTransBSDATA");
			String[] temp = formBean.getOnLineDataRadio().replace("^", "#").split("#");
			//value="331011160002076^30-AUG-2016^103^2^19^0^121600041^^68^0^0^^^1^Normal (Paid)^Receipt/Advance^General^Ward1^1^100^0^1^/^/^/^0^0"
			//value="331011160002079^30-AUG-2016^103^2^19^0^121600042^^68^0^0^^^1^Normal (Paid)^Receipt/Advance^General^Ward1^1^100^0^1^/^/^/^0^0^1300005"

			formBean.setStrRequestNo(temp[0]);
			formBean.setStrRequestDate(temp[1]);
			formBean.setStrRaisingDepartment(temp[2]);
			formBean.setStrChargeTypeId(temp[3]);
			formBean.setStrBillingService(temp[4]);
			formBean.setStrService(temp[5]);
			formBean.setStrGlobalRequestNo(temp[6]);
			formBean.setStrBillNo(temp[7]);
			formBean.setStrTreatmentCategory(temp[8]);
			formBean.setStrEpisode(temp[9]);
			formBean.setStrAdmissionNo(temp[10]);
			formBean.setStrAccountNo(temp[11]);
			formBean.setStrApprovalId(temp[12]);
			formBean.setStrRequestType(temp[13]);
			formBean.setStrRequestFor(temp[15]);
			formBean.setStrPackageId(temp[27]);			

			if (temp[18].trim().length() < 1) 
			{
				formBean.setStrIpdChargeTypeId("0");
			} 
			else 
			{
				formBean.setStrIpdChargeTypeId(temp[18]);
			}
			if (temp[19].trim().equals("")) 
			{
				formBean.setStrWard("0");
			} 
			else 
			{
				formBean.setStrWard(temp[19]);
			}
			formBean.setStrReceiptNo(temp[20]);
			
			

			voObj = (CashCollectionOnlineTransVO) TransferObjectFactory.populateData("billing.transactions.CashCollectionOnlineTransVO", formBean);

			if (formBean.getStrOnlineClientDetails() != null) 
			{
				String strClientTemp[] = formBean.getStrOnlineClientDetails().replace("^", "#").split("#");

				voObj.setStrClientName(strClientTemp[0]);
				voObj.setStrClientType(strClientTemp[1]);
				voObj.setStrSancAmount(strClientTemp[2]);
				voObj.setStrClientBalance(strClientTemp[3]);
				voObj.setStrClientApprovalNo(strClientTemp[4]);
			}

			//System.out.println("formbean values r::"+formBean.getStrEmployeeId());
			
			//voObj.setStrCreditBillFlag(formBean.getStrCreditBillFlag());
			//voObj.setStrCreditBillStatus(formBean.getStrCreditBillStatus());
			//voObj.setStrCreditClientNo(formBean.getStrCreditClientNo());
			voObj.setStrCreditFilePath(formBean.getStrCreditFilePath());
			voObj.setStrCreditLetterDate(formBean.getStrCreditLetterDate());
			voObj.setStrCreditLetterNo(formBean.getStrCreditLetterNo());
			voObj.setStrCreditPaymentType(formBean.getStrCreditPaymentType());
			/*if(formBean.getStrClientNo()!=null && formBean.getStrClientNo().equals("0"))
				  voObj.setStrClientNo(formBean.getStrPayClientName());*/

			bo.insertOnlineReceiptAdvance(voObj);

			formBean.setStrReceiptNo("1");
			formBean.setStrBillNo(voObj.getStrBillNo());
			formBean.setStrCrNo("");

			if (!voObj.getStrMsgType().equals("1")) {

				//String smsMsg="You Paid Rs. "+formBean.getStrOnlineTotalRecAmount()+" for IPD Hospital Services Against Receipt No. "+formBean.getStrBillNo()+ "/1";
				String smsMsg="Dear "+formBean.getStrPatientDtlHidVal().replace("^","#").split("#")[7]  +", Payment of Rs. "+formBean.getStrOnlineTotalRecAmount()+" Received Against Bill No. "+formBean.getStrBillNo()+ "/1 on "+hisUtil.getDSDate("")+" "+hisUtil.getDSDate("hh:mi:ss:AM")+". "+formBean.getStrPatientDtlHidVal().replace("^","#").split("#")[15];
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
				if(patMobileNo!=null && !patMobileNo.equals(""))
					SMSHttpPostClient.sendSMS (patMobileNo,smsmessage);
				/*
				 * { //code from sending message through CDAC MUmbai SMS Gateway
				 * //SMSHttpPostClient.sendSingleSMSThroughSMSGateway(objSMSConfig.sms_username,
				 * objSMSConfig.sms_password,objSMSConfig.sms_senderId,objSMSConfig.sms_url,
				 * patientVO.getPatAddMobileNo(),message); new Thread( new Runnable() { public
				 * void run(){
				 * 
				 * SMSHttpPostClient.sendSMS (patMobileNo,smsmessage);
				 * 
				 * return; // to stop the thread } }).start(); }
				 */
				PrintHLP.ADVANCE(formBean.getStrBillNo(), formBean.getStrBillingService(), formBean.getStrHospitalCode(),
						formBean.getStrReceiptNo() , request , 0,"0","");

				formBean.setStrNormalMsg("Receipt No. '"
						+ formBean.getStrBillNo()
						+ "/1"
						+ "' Generated Successfully for the Collected Amount <img src='/HBIMS/hisglobal/images/INR.png'>'"
						+ HisUtil.getAmountWithDecimal(formBean
								.getStrOnlineTotalRecAmount(), 2) + "'");

				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo("1");
				
				String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
				formBean.setFilePath(fileName);
				request.setAttribute("filePath", fileName);
				formBean.setIsOpenPopUp("1");

				fRes = true;
			} else {

				fRes = false;

				throw new Exception(voObj.getStrMsgString());

			}

		} catch (Exception e) {

			String err = e.getMessage();

			HisException eObj = new HisException(
					"Billing Transaction",
					"CashCollectionOnlineTransBSDATA.insertOnlineReceiptPartPayment()-->",
					err);

			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		} finally {

			bo = null;
			voObj = null;

		}

		return fRes;
	}

	/**
	 * Insert online receipt services details.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return true, if successful
	 */
	public static boolean insertOnlineReceiptServices(CashCollectionOnlineTransFB formBean  , HttpServletRequest request) 
	{
		boolean fRes = false;

		CashCollectionOnlineTransBO bo = null;
		CashCollectionOnlineTransVO voObj = null;
		HisUtil hisUtil = null;
		try 
		{
			bo = new CashCollectionOnlineTransBO();
			hisUtil = new HisUtil("Billing", "CashCollectionOnlineTransBSDATA");
			//1140000646^20-OCT-2014^101^2^19^0^131400352^^61^0^0^^^1^Test1 (Credit/Beneficiary)(Cvcv)^Receipt/Advance^General^General Ward^1^100^0^1^/^/^/
			String[] temp = formBean.getOnLineDataRadio().replace("^", "#").split("#");

			formBean.setStrRequestNo(temp[0]);
			formBean.setStrRequestFor(temp[1]);
			formBean.setStrRaisingDepartment(temp[2]);
			formBean.setStrChargeTypeId(temp[3]);
			formBean.setStrBillingService(temp[4]);
			formBean.setStrService(temp[5]);
			formBean.setStrGlobalRequestNo(temp[6]);
			formBean.setStrBillNo(temp[7]);
			formBean.setStrTreatmentCategory(temp[8]);
			formBean.setStrEpisode(temp[9]);
			formBean.setStrAdmissionNo(temp[10]);
			formBean.setStrAccountNo(temp[11]);
			formBean.setStrApprovalId(temp[12]);
			formBean.setStrRequestType(temp[13]);

			if (temp[18].trim().equals("")) //IPD Charge Type
			{
				formBean.setStrIpdChargeTypeId("0");
			} 
			else 
			{
				formBean.setStrIpdChargeTypeId(temp[18]);//IPD Spl Ward Type
			}
			if (temp[19].trim().equals("")) 
			{
				formBean.setStrWard("0");
			} 
			else 
			{
				formBean.setStrWard(temp[19]);
			}
			formBean.setStrReceiptNo(temp[20]);//If Refund The Receipt Will Be present

			voObj = (CashCollectionOnlineTransVO) TransferObjectFactory.populateData("billing.transactions.CashCollectionOnlineTransVO", formBean);
			
			if (formBean.getStrOnlineClientDetails() != null) 
			{
				String strClientTemp[] = formBean.getStrOnlineClientDetails().replace("^", "#").split("#");

				voObj.setStrClientName(strClientTemp[0]);
				voObj.setStrClientType(strClientTemp[1]);
				voObj.setStrSancAmount(strClientTemp[2]);
				voObj.setStrClientBalance(strClientTemp[3]);
				voObj.setStrClientApprovalNo(strClientTemp[4]);
			}
			/*if(formBean.getStrClientNo()!=null && formBean.getStrClientNo().equals("0"))
				  voObj.setStrClientNo(formBean.getStrPayClientName());*/
			
			/*
			 * for (int j = 0; j < voObj.getStrOnlinePaymentMode().length; j++) {
			 * if(voObj.getStrOnlinePaymentMode()[j].split("#")[0].equals("1"))
			 * voObj.setStrOnlinePaymentDtls("".split("#")); }
			 */
			

			bo.insertOnlineReceiptServices(voObj);

			formBean.setStrBillNo(voObj.getStrBillNo());
			formBean.setStrReceiptNo("1");
			formBean.setStrCrNo("");
			
			
			
			if(voObj.getStrMsgType().equals("0"))
			{
				//System.out.println("formBean.getStrMobileNo()"+formBean.getStrMobileNo());
				SMSHttpsNICPostClient sms=new SMSHttpsNICPostClient();
				/*
				 * if (voObj.getStrOnlinePaymentMode()[0].equals("7"))//Payment Mode=Wallet {
				 * String smsMsg="You Paid Rs. "+voObj.getStrOnlineTotalRecAmount()
				 * +" from Your Patient Wallet for Hospital Services Against Reference No. "
				 * +voObj.getStrBillNo()+". Your Current Wallet balance is Rs. "+(Double.
				 * parseDouble(voObj.getStrAvlWalletMoney())-Double.parseDouble(voObj.
				 * getStrOnlineTotalRecAmount()));
				 * sms.sendTextSMSThroughNICSMSGateway("","","","",formBean.getStrMobileNo(),
				 * smsMsg); }
				 */
			}

			if (!voObj.getStrMsgType().equals("1")) 
			{
				if (formBean.getStrChargeTypeId().equals("2"))//IPD 
				{
					//String smsMsg="You Paid Rs. "+formBean.getStrOnlineTotalRecAmount()+" for IPD Hospital Services Against Receipt No. "+formBean.getStrBillNo()+ "/1";
					String smsMsg="Dear "+formBean.getStrPatientDtlHidVal().replace("^","#").split("#")[7]  +", Payment of Rs. "+formBean.getStrOnlineTotalRecAmount()+" Received Against Bill No. "+formBean.getStrBillNo()+ "/1 on "+hisUtil.getDSDate("")+" "+hisUtil.getDSDate("hh:mi:ss:AM")+". "+formBean.getStrPatientDtlHidVal().replace("^","#").split("#")[15];
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
					if(patMobileNo!=null && !patMobileNo.equals(""))
						SMSHttpPostClient.sendSMS (patMobileNo,smsmessage);//{
						 //code from sending message through CDAC MUmbai SMS Gateway
						 //SMSHttpPostClient.sendSingleSMSThroughSMSGateway(objSMSConfig.sms_username, objSMSConfig.sms_password,objSMSConfig.sms_senderId,objSMSConfig.sms_url, patientVO.getPatAddMobileNo(),message);
						/*
						 * new Thread( new Runnable() { public void run(){
						 * 
						 * SMSHttpPostClient.sendSMS (patMobileNo,smsmessage);
						 * 
						 * return; // to stop the thread } }).start(); }
						 */
					PrintHLP.IPD_SERVICES(formBean.getStrBillNo(), formBean.getStrAccountNo(),formBean.getStrBillingService(), 
										  formBean.getStrHospitalCode(), formBean.getStrReceiptNo() , request , null , "0" , 0,"0","");
					
					String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
					formBean.setFilePath(fileName);
					request.setAttribute("filePath", fileName);
					formBean.setIsOpenPopUp("1");
				} 
				else 
				{
					//String smsMsg="You Paid Rs. "+formBean.getStrOnlineTotalRecAmount()+" for IPD Hospital Services Against Receipt No. "+formBean.getStrBillNo()+ "/1";
					String smsMsg="Dear "+formBean.getStrPatientDtlHidVal().replace("^","#").split("#")[7]  +", Payment of Rs. "+formBean.getStrOnlineTotalRecAmount()+" Received Against Bill No. "+formBean.getStrBillNo()+ "/1 on "+hisUtil.getDSDate("")+" "+hisUtil.getDSDate("hh:mi:ss:AM")+". "+formBean.getStrPatientDtlHidVal().replace("^","#").split("#")[15];
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
					if(patMobileNo!=null && !patMobileNo.equals(""))
						SMSHttpPostClient.sendSMS(patMobileNo,smsmessage);
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
					//opd normal and credit bill both are handled in functions ahead..
					PrintHLP.OPD_SERVICES(formBean.getStrBillNo(), formBean.getStrBillingService(), formBean.getStrHospitalCode(), 
										  formBean.getStrReceiptNo(), request, null, "0", 0,"0","");
					
					/*PrintHLP.OPD_SERVICES_CreditBill(formBean.getStrBillNo(), formBean.getStrBillingService(), 
										  formBean.getStrHospitalCode(), formBean.getStrReceiptNo() , request , null , "0" , 0,formBean.getStrCreditClientName()[0]);
					*/
					String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
					formBean.setFilePath(fileName);
					request.setAttribute("filePath", fileName);
					formBean.setIsOpenPopUp("1");
				}

				formBean.setStrNormalMsg("Receipt No. '"+ formBean.getStrBillNo()+ "/1"	+ "' Generated Successfully for the Collected Amount <img src='/HBIMS/hisglobal/images/INR.png'> '"+ HisUtil.getAmountWithDecimal(formBean.getStrOnlineTotalRecAmount(), 2) + "'");
				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo("1");
				fRes = true;
			} 
			else 
			{
				fRes = false;
				String err = voObj.getStrMsgString();
				throw new Exception(err);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			HisException eObj = new HisException("Billing Transaction","CashCollectionOnlineTransBSDATA.insertOnlineReceiptServices()-->",e.getMessage());
			if(e.getMessage().contains("Credit Details Already Availed "))
			formBean.setStrErrMsg("Error: Data Not Saved.Credit Details Already Availed");
			else
				formBean.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");
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
	 * Insert online refund services details.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return true, if successful
	 */
	public static boolean insertOnlineRefundServices(CashCollectionOnlineTransFB formBean  , HttpServletRequest request) 
	{
		boolean fRes = false;
		CashCollectionOnlineTransBO bo = null;
		CashCollectionOnlineTransVO voObj = null;

		try 
		{
			bo = new CashCollectionOnlineTransBO();
			String[] temp = formBean.getOnLineDataRadio().replace("^", "#").split("#");

			formBean.setStrRequestNo(temp[0]);
			formBean.setStrRequestFor(temp[1]);
			formBean.setStrRaisingDepartment(temp[2]);
			formBean.setStrChargeTypeId(temp[3]);
			formBean.setStrBillingService(temp[4]);
			formBean.setStrService(temp[5]);
			formBean.setStrGlobalRequestNo(temp[6]);
			formBean.setStrBillNo(temp[7]);
			formBean.setStrTreatmentCategory(temp[8]);
			formBean.setStrEpisode(temp[9]);
			formBean.setStrAdmissionNo(temp[10]);
			formBean.setStrAccountNo(temp[11]);
			formBean.setStrApprovalId(temp[12]);
			formBean.setStrRequestType(temp[13]);

			if (temp[18].trim().equals("")) 
			{
				formBean.setStrIpdChargeTypeId("0");
			} 
			else 
			{
				formBean.setStrIpdChargeTypeId(temp[18]);
			}
			if (temp[19].trim().equals("")) 
			{
				formBean.setStrWard("0");
			} 
			else 
			{
				formBean.setStrWard(temp[19]);
			}
			formBean.setStrReceiptNo(temp[20]);

			voObj = (CashCollectionOnlineTransVO) TransferObjectFactory.populateData("billing.transactions.CashCollectionOnlineTransVO", formBean);

			if (formBean.getStrOnlineClientDetails() != null) 
			{
				String strClientTemp[] = formBean.getStrOnlineClientDetails().replace("^", "#").split("#");

				voObj.setStrClientName(strClientTemp[0]);
				voObj.setStrClientType(strClientTemp[1]);
				voObj.setStrSancAmount(strClientTemp[2]);
				voObj.setStrClientBalance(strClientTemp[3]);
				voObj.setStrClientApprovalNo(strClientTemp[4]);
			}

			voObj.setStrCreditLetterNo(formBean.getStrCreditLetterNo());
			
			bo.insertOnlineRefundServices(voObj);

			formBean.setStrBillNo(voObj.getStrBillNo());
			formBean.setStrRefundReceiptNo(voObj.getStrRefundReceiptNo());
			formBean.setStrCrNo("");
			
			if (!voObj.getStrMsgType().equals("1")) 
			{
				//System.out.println("formBean.getStrMobileNo()"+formBean.getStrMobileNo());
				SMSHttpsNICPostClient sms=new SMSHttpsNICPostClient();
				if (voObj.getStrOnlinePaymentMode()[0].equals("7"))//Payment Mode=Wallet
				{
					String smsMsg="You Wallet Is Credited With Rs. "+voObj.getStrOnlineTotalRecAmount()+" Against Refund of Hospital Services -Reference No. "+voObj.getStrBillNo()+". Your Current Wallet balance is Rs. "+(Double.parseDouble(voObj.getStrAvlWalletMoney())+Double.parseDouble(voObj.getStrOnlineTotalRecAmount()));
					sms.sendTextSMSThroughNICSMSGateway("","","","",formBean.getStrMobileNo(), smsMsg);
				}
			}

			if (!voObj.getStrMsgType().equals("1")) 
			{

				if (formBean.getStrChargeTypeId().equals("2")) 
				{
					PrintHLP.IPD_REFUND(formBean.getStrBillNo(), formBean.getStrRefundReceiptNo(), formBean.getStrAccountNo(),
										formBean.getStrBillingService(), formBean.getStrHospitalCode() , request , 0);
					String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
					formBean.setFilePath(fileName);
					request.setAttribute("filePath", fileName);
					formBean.setIsOpenPopUp("1");
				} 
				else 
				{
					PrintHLP.OPD_REFUND(formBean.getStrBillNo(), formBean.getStrRefundReceiptNo(), formBean.getStrBillingService(), 
										formBean.getStrHospitalCode() , request , 0,"");
				}

				formBean.setStrNormalMsg("Receipt No. '"+ formBean.getStrBillNo()+ "/"+ formBean.getStrRefundReceiptNo()+ "' Generated Successfully for the Collected Amount <img src='/HBIMS/hisglobal/images/INR.png'> '"+ HisUtil.getAmountWithDecimal(formBean.getStrOnlineTotalRecAmount(), 2) + "'");
				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo(formBean.getStrRefundReceiptNo());
				String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
				formBean.setFilePath(fileName);
				request.setAttribute("filePath", fileName);
				formBean.setIsOpenPopUp("1");
				fRes = true;
			} 
			else 
			{
				String err = voObj.getStrMsgString();
				fRes = false;
				throw new Exception(err);
			}
		} 
		catch (Exception e) 
		{
			HisException eObj = new HisException("Billing Transaction","CashCollectionOnlineTransBSDATA.insertOnlineRefundServices()-->",e.getMessage());
			formBean.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");
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
	 * Insert online refund advance details.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return true, if successful
	 */
	public static boolean insertOnlineRefundAdvance(
			CashCollectionOnlineTransFB formBean  , HttpServletRequest request) {

		boolean fRes = false;

		CashCollectionOnlineTransBO bo = null;
		CashCollectionOnlineTransVO voObj = null;

		try {

			bo = new CashCollectionOnlineTransBO();

			String[] temp = formBean.getOnLineDataRadio().replace("^", "#")
					.split("#");

			formBean.setStrRequestNo(temp[0]);
			formBean.setStrRequestFor(temp[1]);
			formBean.setStrRaisingDepartment(temp[2]);
			formBean.setStrChargeTypeId(temp[3]);
			formBean.setStrBillingService(temp[4]);
			formBean.setStrService(temp[5]);
			formBean.setStrGlobalRequestNo(temp[6]);
			formBean.setStrBillNo(temp[7]);
			formBean.setStrTreatmentCategory(temp[8]);
			formBean.setStrEpisode(temp[9]);
			formBean.setStrAdmissionNo(temp[10]);
			formBean.setStrAccountNo(temp[11]);
			formBean.setStrApprovalId(temp[12]);
			formBean.setStrRequestType(temp[13]);

			if (temp[18].trim().equals("")) {
				formBean.setStrIpdChargeTypeId("0");
			} else {
				formBean.setStrIpdChargeTypeId(temp[18]);
			}
			if (temp[19].trim().equals("")) {
				formBean.setStrWard("0");
			} else {
				formBean.setStrWard(temp[19]);
			}
			formBean.setStrReceiptNo(temp[20]);

			voObj = (CashCollectionOnlineTransVO) TransferObjectFactory.populateData(
					"billing.transactions.CashCollectionOnlineTransVO", formBean);

			if (formBean.getStrOnlineClientDetails() != null) {
				String strClientTemp[] = formBean.getStrOnlineClientDetails()
						.replace("^", "#").split("#");

				voObj.setStrClientName(strClientTemp[0]);
				voObj.setStrClientType(strClientTemp[1]);
				voObj.setStrSancAmount(strClientTemp[2]);
				voObj.setStrClientBalance(strClientTemp[3]);
				voObj.setStrClientApprovalNo(strClientTemp[4]);
			}

			bo.insertOnlineRefundAdvance(voObj);
			// bo.insertOnlineRefundServices(voObj);

			formBean.setStrBillNo(voObj.getStrBillNo());
			formBean.setStrRefundReceiptNo(voObj.getStrRefundReceiptNo());
			formBean.setStrCrNo("");

			if (!voObj.getStrMsgType().equals("1")) {
				/*
				 * PrintHLP.ADVANCE_REFUND(formBean.getStrBillNo(), formBean
				 * .getStrReceiptNo(), formBean.getStrBillingService(),
				 * formBean.getStrHospitalCode());
				 */
				PrintHLP.ADVANCE_REFUND(formBean.getStrBillNo(), formBean
						.getStrRefundReceiptNo(), formBean
						.getStrBillingService(), formBean.getStrHospitalCode() , request , 0);

				formBean.setStrNormalMsg("Receipt No. '"
						+ formBean.getStrBillNo()
						+ "/"
						+ formBean.getStrRefundReceiptNo()
						+ "' Generated Successfully for the Collected Amount <img src='/HBIMS/hisglobal/images/INR.png'> '"
						+ HisUtil.getAmountWithDecimal(formBean
								.getStrOnlineTotalRecAmount(), 2) + "'");

				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo(formBean.getStrRefundReceiptNo());
				
				//added by vipul on 02.08.2021 to print advance refund reciept
				String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
				formBean.setFilePath(fileName);
				request.setAttribute("filePath", fileName);
				formBean.setIsOpenPopUp("1");
				//ended by vipul on 02.08.2021 to print advance refund reciept
				fRes = true;
			} else {

				String err = voObj.getStrMsgString();
				fRes = false;

				throw new Exception(err);

			}

		} catch (Exception e) {

			HisException eObj = new HisException("Billing Transaction",
					"CashCollectionOnlineTransBSDATA.insertOnlineRefundAdvance()-->", e
							.getMessage());

			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

		} finally {

			bo = null;
			voObj = null;
		}

		return fRes;
	}

	/**
	 * Insert online final adjustment details.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return true, if successful
	 */
	public static boolean insertOnlineFinalAdjustment(CashCollectionOnlineTransFB formBean  , HttpServletRequest request) 
	{
		boolean fRes = false;
		CashCollectionOnlineTransBO bo = null;
		CashCollectionOnlineTransVO voObj = null;
		HisUtil hisUtil = null;
		try 
		{
			bo = new CashCollectionOnlineTransBO();
			String[] temp = formBean.getOnLineDataRadio().replace("^", "#").split("#");
			hisUtil = new HisUtil("Billing", "CashCollectionOnlineTransBSDATA");
			formBean.setStrRequestNo(temp[0]);
			formBean.setStrRequestFor(temp[1]);
			formBean.setStrRaisingDepartment(temp[2]);
			formBean.setStrChargeTypeId(temp[3]);
			formBean.setStrBillingService(temp[4]);
			formBean.setStrService(temp[5]);
			formBean.setStrGlobalRequestNo(temp[6]);
			formBean.setStrBillNo(temp[7]);
			formBean.setStrTreatmentCategory(temp[8]);
			formBean.setStrEpisode(temp[9]);
			formBean.setStrAdmissionNo(temp[10]);
			formBean.setStrAccountNo(temp[11]);
			formBean.setStrApprovalId(temp[12]);
			formBean.setStrRequestType(temp[13]);

			if (temp[18].trim().equals("")) {
				formBean.setStrIpdChargeTypeId("0");
			} 
			else 
			{
				formBean.setStrIpdChargeTypeId(temp[18]);
			}
			if (temp[19].trim().equals("")) 
			{
				formBean.setStrWard("0");
			} 
			else 
			{
				formBean.setStrWard(temp[19]);
			}
			formBean.setStrReceiptNo(temp[20]);

			voObj = (CashCollectionOnlineTransVO) TransferObjectFactory.populateData("billing.transactions.CashCollectionOnlineTransVO", formBean);

			String strBillTrfDtls = formBean.getStrRequestBillTariffDetails();
			String tempTrfDtls[] = strBillTrfDtls.replace("^", "#").split("#");

			voObj.setStrApprovalId(tempTrfDtls[0]);
			voObj.setStrDiscountUnit(tempTrfDtls[1]);
			voObj.setStrDiscountType(tempTrfDtls[2]);
			voObj.setStrServiceTax(tempTrfDtls[3]);

			if (formBean.getStrOnlineClientDetails() != null) 
			{
				String strClientTemp[] = formBean.getStrOnlineClientDetails().replace("^", "#").split("#");
				voObj.setStrClientName(strClientTemp[0]);
				voObj.setStrClientType(strClientTemp[1]);
				//voObj.setStrSancAmount(strClientTemp[2]);
				//voObj.setStrClientBalance(strClientTemp[3]);
				voObj.setStrClientApprovalNo(strClientTemp[4]);
			}
			voObj.setStrPayClientName(formBean.getStrClientName());
			voObj.setWalacc(formBean.getWalacc());
			bo.insertOnlineFinalAdjustment(voObj);

			formBean.setStrBillNo(voObj.getStrBillNo());
			formBean.setStrReceiptNo("1");
			formBean.setStrCrNo("");

			if (!voObj.getStrMsgType().equals("1")) 
			{
				//String smsMsg="Collected Amount Rs. "+formBean.getStrOnlineTotalRecAmount()+" for IPD Account Final Adjustment Against Receipt No. "+formBean.getStrBillNo()+ "/1";
				String smsMsg="Dear "+formBean.getStrPatientDtlHidVal().replace("^","#").split("#")[7]  +", Payment of Rs. "+formBean.getStrOnlineTotalRecAmount()+" Received Against Bill No. "+formBean.getStrBillNo()+ "/1 on "+hisUtil.getDSDate("")+" "+hisUtil.getDSDate("hh:mi:ss:AM")+". "+formBean.getStrPatientDtlHidVal().replace("^","#").split("#")[15];
				if(formBean.getStrMobileNo()!=null && !formBean.getStrMobileNo().equals(""))
					voObj.setStrMobileNo(formBean.getStrMobileNo());
				else
					voObj.setStrMobileNo(formBean.getStrPatientDtlHidVal().replace("^","#").split("#")[13]);
				//System.out.println("formBean.getStrMobileNo()"+formBean.getStrMobileNo());
				final String   smsmessage  = smsMsg;
				final String patMobileNo=voObj.getStrMobileNo();
				/**Added by Vasu on 25.June for SMS Configuration*/
				if(patMobileNo!=null && !patMobileNo.equals(""))
					SMSHttpPostClient.sendSMS (patMobileNo,smsmessage);//{
				 //code from sending message through CDAC MUmbai SMS Gateway
				 //SMSHttpPostClient.sendSingleSMSThroughSMSGateway(objSMSConfig.sms_username, objSMSConfig.sms_password,objSMSConfig.sms_senderId,objSMSConfig.sms_url, patientVO.getPatAddMobileNo(),message);
					/*
					 * new Thread( new Runnable() { public void run(){
					 * 
					 * SMSHttpPostClient.sendSMS (patMobileNo,smsmessage);
					 * 
					 * return; // to stop the thread } }).start(); }
					 */
				
				
				//Code Commented For SMS Serv ice Service taking time so code started in new thread
				//SMSHttpPostClient.sendSMS (voObj.getStrMobileNo(), smsMsg);
							
				
				PrintHLP.FINAL_ADJUSTMENT(formBean.getStrBillNo(), formBean.getStrBillingService(), formBean.getStrAccountNo(),
						formBean.getStrHospitalCode(), formBean.getStrBillType(), formBean.getStrReceiptNo() , request , 0,"");

				formBean.setStrNormalMsg("Receipt No. '"+ formBean.getStrBillNo()+ "/1"
						+ "' Generated Successfully for the Collected Amount <img src='/HBIMS/hisglobal/images/INR.png'> '"
						+ HisUtil.getAmountWithDecimal(formBean.getStrOnlineTotalRecAmount(), 2) + "'");

				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo("1");
				
				String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
				formBean.setFilePath(fileName);
				request.setAttribute("filePath", fileName);
				formBean.setIsOpenPopUp("1");
				fRes = true;
			} 
			else 
			{
				String err = voObj.getStrMsgString();
				fRes = false;
				throw new Exception(err);
			}
		} 
		catch (Exception e) 
		{
			HisException eObj = new HisException("Billing Transaction","CashCollectionOnlineTransBSDATA.insertOnlineFinalAdjustment()-->",e.getMessage());
			formBean.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		}
		return fRes;
	}

	/**
	 * Insert online reconciliation details.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return true, if successful
	 */
	public static boolean insertOnlineReconciliation(
			CashCollectionOnlineTransFB formBean  , HttpServletRequest request) {

		boolean fRes = false;

		CashCollectionOnlineTransBO bo = null;
		CashCollectionOnlineTransVO voObj = null;

		try {

			bo = new CashCollectionOnlineTransBO();

			String[] temp = formBean.getOnLineDataRadio().replace("^", "#")
					.split("#");

			formBean.setStrRequestNo(temp[0]);
			formBean.setStrRequestDate(temp[1]);
			formBean.setStrRaisingDepartment(temp[2]);
			formBean.setStrChargeTypeId(temp[3]);
			formBean.setStrBillingService(temp[4]);
			formBean.setStrService(temp[5]);
			formBean.setStrGlobalRequestNo(temp[6]);
			formBean.setStrBillNo(temp[7]);
			formBean.setStrTreatmentCategory(temp[8]);
			formBean.setStrEpisode(temp[9]);
			formBean.setStrAdmissionNo(temp[10]);
			formBean.setStrAccountNo(temp[11]);
			formBean.setStrApprovalId(temp[12]);
			formBean.setStrRequestType(temp[13]);

			if (temp[18].trim().equals("")) {
				formBean.setStrIpdChargeTypeId("0");
			} else {
				formBean.setStrIpdChargeTypeId(temp[18]);
			}
			if (temp[19].trim().equals("")) {
				formBean.setStrWard("0");
			} else {
				formBean.setStrWard(temp[19]);
			}
			formBean.setStrReceiptNo(temp[20]);

			voObj = (CashCollectionOnlineTransVO) TransferObjectFactory.populateData(
					"billing.transactions.CashCollectionOnlineTransVO", formBean);

			if (formBean.getStrOnlineClientDetails() != null) {
				String strClientTemp[] = formBean.getStrOnlineClientDetails()
						.replace("^", "#").split("#");

				voObj.setStrClientName(strClientTemp[0]);
				voObj.setStrClientType(strClientTemp[1]);
				voObj.setStrSancAmount(strClientTemp[2]);
				voObj.setStrClientBalance(strClientTemp[3]);
				voObj.setStrClientApprovalNo(strClientTemp[4]);
			}
			bo.insertOnlineReconciliation(voObj);

			formBean.setStrBillNo(voObj.getStrBillNo());
			formBean.setStrReceiptNo(voObj.getStrRefundReceiptNo());

			formBean.setStrCrNo("");

			if (!voObj.getStrMsgType().equals("1")) {

				if (formBean.getStrChargeTypeId().equals("2")) {

					if (formBean.getStrBillingService().equals("21")) {

						PrintHLP.IPD_FINAL_SETTLE(formBean.getStrBillNo(),
								formBean.getStrReceiptNo(), formBean
										.getStrBillingService(), formBean
										.getStrHospitalCode() , request , 0);

					} else {

						PrintHLP.IPD_RECONCILIATION(formBean.getStrBillNo(),
								formBean.getStrReceiptNo(), formBean
										.getStrAccountNo(), formBean
										.getStrBillingService(), formBean
										.getStrHospitalCode() , request , 0);

					}

				} else {

					PrintHLP.OPD_RECONCILIATION(formBean.getStrBillNo(),
							formBean.getStrReceiptNo(), formBean
									.getStrBillingService(), formBean
									.getStrHospitalCode(),request , 0);

				}

				formBean.setStrNormalMsg("Receipt No. '"
						+ formBean.getStrBillNo()
						+ "/"
						+ formBean.getStrReceiptNo()
						+ "' Generated Successfully for the Collected Amount <img src='/HBIMS/hisglobal/images/INR.png'> '"
						+ HisUtil.getAmountWithDecimal(formBean
								.getStrOnlineGrandTotalAmount(), 2) + "'");

				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo(formBean.getStrReceiptNo());

				fRes = true;
			} else {

				String err = voObj.getStrMsgString();
				fRes = false;

				throw new Exception(err);

			}

		} catch (Exception e) {

			HisException eObj = new HisException("Billing Transaction",
					"CashCollectionOnlineTransBSDATA.insertOnlineFinalAdjustment()-->",
					e.getMessage());

			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		}

		return fRes;
	}

}