package billing;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.tools.hlp.PatientDtlHLP;
import hisglobal.utility.HisUtil;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import billing.BillConfigUtil;
import billing.HLPParticularDtl;
import billing.HLPTariffDtl;
import billing.PrintHLP;

// TODO: Auto-generated Javadoc
/**
 * The Class CashCollectionTransDATA.
 */
public class CashCollectionTransDATA {

	/**
	 * method used to check whether the System's IP Address is Registered in
	 * Counter Master or Not.
	 * 
	 * @param request
	 * @param formBean
	 */
	public static void checkCounterStatus(HttpServletRequest request,
			CashCollectionTransFB formBean) {

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;

		try {

			formBean.setStrIpAddress(request.getSession().getAttribute(
					"IP_ADDR").toString());

			formBean.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			bo = new CashCollectionTransBO();
			voObj = new CashCollectionTransVO();

			voObj.setStrIpAddress(formBean.getStrIpAddress());
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.checkCounterStatus(voObj);

			String strCounterId = voObj.getStrCounterId();

			if (strCounterId != null) {

				if (strCounterId.trim().length() < 4) {

					formBean
							.setStrErrMsg("Cash Collection is Not Applicable, System IP Address is not Registered as Counter");
					formBean.setStrCrNo("");

				}

			}

			formBean.setStrConfirmationType(new BillConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString()).getGeneralCashCollectionConfrimType());
			
		} catch (Exception e) {

			String msgStr = e.getMessage();
			HisException eObj = new HisException("Billing",
					"CashCollectionTransDATA->checkCounterStatus()", msgStr);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");

			formBean.setStrCrNo("");
			eObj = null;
		} finally {

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
	public static boolean init(HttpServletRequest request,
			CashCollectionTransFB formBean) {

		boolean bResultVal = true;

		String strCrNo = formBean.getStrCrNo();

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;
		BillConfigUtil configUtil = null;
		HisUtil hisUtil = null;

		try {
			formBean.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
					.toString());

			String strPatView = "";

			strPatView = PatientDtlHLP.compactPatientWithAdmissionDtl(strCrNo,
					formBean.getStrHospitalCode(), false);

			formBean.setStrPatientDetailsView(strPatView);

			bo = new CashCollectionTransBO();
			voObj = new CashCollectionTransVO();
			configUtil = new BillConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			hisUtil = new HisUtil("Bill Transaction", "CashCollectionTransDATA");

			formBean.setStrIpdThirdPartyBenefit(configUtil
					.getIpdThirdPartyBilling());
			formBean.setStrOpdThirdPartyBenefit(configUtil
					.getOpdThirdPartyBilling());
			formBean.setStrEmergencyThirdPartyBenefit(configUtil
					.getEmergencyThirdPartyBilling());

			formBean.setStrCurrentDate(hisUtil.getASDate("dd-MMM-yyyy"));

			if (formBean.getStrIsOnline().equals("1")) {

				CashCollectionTransDATA.initOnLineDetails(formBean, bo, voObj);

			} else {
				CashCollectionTransDATA.initOffLineDetails(formBean, bo, voObj);
			}

		} catch (Exception e) {

			bResultVal = false;

			String msgStr = e.getMessage();

			if (msgStr.contains("CR.")) {

				formBean.setStrErrMsg("Invalid CR. No.");

			} else {

				HisException eObj = new HisException("Billing",
						"CashCollectionTransDATA->init()", msgStr);
				formBean.setStrErrMsg("Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "], Contact System Administrator! ");

				formBean.setStrCrNo("");
				eObj = null;

			}

		} finally {

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
	public static void initOnLineDetails(CashCollectionTransFB formBean,
			CashCollectionTransBO bo, CashCollectionTransVO voObj)
			throws Exception {
		
			String temp = "";
			HisUtil util = null;
		
		try {
			
						
			voObj.setStrCrNo(formBean.getStrCrNo());
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getOnLineDetails(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}

			
			util = new HisUtil("Billing Trans","Cash Collection");


			if (voObj.getStrClientNameList() != null
					&& voObj.getStrClientNameList().size() != 0) {
				temp = util.getOptionValue(voObj.getStrClientNameList(), voObj
						.getStrOffLineWard(), "0^Select Value", false);

				formBean.setStrClientNameContents(temp);
			} else {
				formBean
						.setStrClientNameContents("<option value='0'>Select Value</option>");
			}
			
			if (voObj.getStrPaymentModeList() != null
					&& voObj.getStrPaymentModeList().size() != 0) {
				temp = util.getOptionValue(voObj.getStrPaymentModeList(), "", "", false);

				formBean.setStrPaymentModeContents(temp);
			} 
			
			
			
			String strOnLineView = CashCollectionTransHLP
					.getOnLineDetailsView(voObj);

			formBean.setStrOnlineDetailsView(strOnLineView);

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
			 * strOnLineClientView.append(CashCollectionTransHLP
			 * .getOnLineClientDetailsView(voObj)); }
			 * 
			 * strOnLineClientView.append(CashCollectionTransHLP
			 * .getOnlineOtherDetails(voObj));
			 * 
			 * if (voObj.getStrRequestType().equals("1") &&
			 * (voObj.getStrBillingService().equals("10") ||
			 * voObj.getStrBillingService().equals("11") || voObj
			 * .getStrBillingService().equals("12"))) {
			 * 
			 * strOnLineClientView.append(CashCollectionTransHLP
			 * .getOnLineTariffDetailsView(voObj)); }
			 * 
			 * if (voObj.getStrRequestType().equals("1") &&
			 * (voObj.getStrAccountNo() != null || voObj
			 * .getStrAccountNo().trim().length() != 0) &&
			 * voObj.getStrBillingService().equals("20")) {
			 * 
			 * strOnLineClientView.append(CashCollectionTransHLP
			 * .getOnLinePartPaymentDetailsView(voObj)); }
			 * 
			 * if (voObj.getStrRequestType().equals("2")) {
			 * strOnLineClientView.append(CashCollectionTransHLP
			 * .getOnLineRefundTariffDetailsView(voObj)); }
			 * 
			 * if (voObj.getStrRequestType().equals("3")) {
			 * strOnLineClientView.append(CashCollectionTransHLP
			 * .getOnLineReconcileTariffDetailsView(voObj)); }
			 * 
			 * if (voObj.getStrBillingService().equals("19") &&
			 * voObj.getStrRequestType().equals("1")) {
			 * 
			 * strOnLineClientView.append(CashCollectionTransHLP
			 * .getOnLineAdvanceDetailsView(voObj)); }
			 * 
			 * formBean.setStrOnlineClientDetailsView(strOnLineClientView
			 * .toString());
			 */
		} catch (Exception e) {

			// e.printStackTrace();

			String msgStr = e.getMessage();
			HisException eObj = new HisException("Billing",
					"CashCollectionTransDATA->initOnlineDetails()", msgStr);
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
	public static void getOnlineDtls(HttpServletRequest request,
			HttpServletResponse response) {

		CashCollectionTransBO bo = new CashCollectionTransBO();
		CashCollectionTransVO voObj = new CashCollectionTransVO();
		BillConfigUtil configUtil = new BillConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		
		
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

		if (strRequestNo == null)
			strRequestNo = "0";
		if (strAdmissionNo == null)
			strAdmissionNo = "";
		if (strAccountNo == null)
			strAccountNo = "";
		if (strTreatmentCat == null)
			strTreatmentCat = "";
		if (strRequestFor == null)
			strRequestFor = "";
		if (strChargeTypeId == null)
			strChargeTypeId = "0";
		if (strChargeTypeName == null)
			strChargeTypeName = "";
		if (strBServiceId == null)
			strBServiceId = "";
		if (strRequestType == null)
			strRequestType = "";

		if (strBillNo == null)
			strBillNo = "0";

		if (strGrpId == null)
			strGrpId = "0";

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
		voObj.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());
		voObj.setStrBillNo(strBillNo);
		voObj.setStrGroupId(strGrpId);

		try {

			// System.out.println("Request No : "+strRequestNo);
			// System.out.println("Request Type : "+strRequestType);

			bo.getOnLineTariffDetails(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			
			
			StringBuffer clientView = null;

			/*
			 * String strAccountHeaderView = ""; String strAccountView = "";
			 * 
			 * if (!voObj.getStrAccountNo().equals("")) {
			 * 
			 * strAccountHeaderView = CashCollectionTransHLP.getAccountHeader();
			 * strAccountView = HLPAccountDtl.getAccountDetailsHLP(voObj
			 * .getStrAccountNo()); }
			 */

			if (!voObj.getStrBillingService().equals("21")) {

				clientView = new StringBuffer("");

				// logics to get client view in On-line Mode
				if (strChargeTypeId.equals("1")
						&& configUtil.getOpdThirdPartyBilling().equals("1")
						|| strChargeTypeId.equals("2")
						&& configUtil.getIpdThirdPartyBilling().equals("1")
						|| strChargeTypeId.equals("3")
						&& configUtil.getEmergencyThirdPartyBilling().equals(
								"1")) {

					clientView.append(CashCollectionTransHLP
							.getOnLineClientDetailsView(voObj));
				}

				clientView.append(CashCollectionTransHLP
						.getOnlineOtherDetails(voObj));

				if (voObj.getStrRequestType().equals("1")
						&& (voObj.getStrBillingService().equals("10")
								|| voObj.getStrBillingService().equals("11") || voObj
								.getStrBillingService().equals("12"))) {

					clientView.append(CashCollectionTransHLP
							.getOnLineTariffDetailsView(voObj));

				}

				if (voObj.getStrRequestType().equals("1")
						&& (voObj.getStrAccountNo() != null || voObj
								.getStrAccountNo().trim().length() != 0)
						&& voObj.getStrBillingService().equals("20")) {

					clientView.append(CashCollectionTransHLP
							.getOnLinePartPaymentDetailsView(voObj));

				}

				if (voObj.getStrRequestType().equals("2")
						&& (voObj.getStrBillingService().equals("10")
								|| voObj.getStrBillingService().equals("11") || voObj
								.getStrBillingService().equals("12"))) {
					clientView.append(CashCollectionTransHLP
							.getOnLineRefundTariffDetailsView(voObj));
				}

				if (voObj.getStrRequestType().equals("2")
						&& voObj.getStrChargeTypeId().equals("2")
						&& voObj.getStrBillingService().equals("19")) {

					clientView.append(CashCollectionTransHLP
							.getOnLineRefundAdvanceView(voObj));

				}

				if (voObj.getStrRequestType().equals("3")) {
					clientView.append(CashCollectionTransHLP
							.getOnLineReconcileTariffDetailsView(voObj));
				}

				if (voObj.getStrBillingService().equals("19")
						&& voObj.getStrRequestType().equals("1")) {

					clientView.append(CashCollectionTransHLP
							.getOnLineAdvanceDetailsView(voObj));
				}

			} else {

				clientView = new StringBuffer("");

				if (!voObj.getStrRequestType().equals("3")) {

					clientView
							.append("<table class='TABLEWIDTH' align='center'><tr class='TITLE'><td>Final Adjustment Details</td></tr></table>");

					// Calling of HLP - Particular Dtl
					String strParticulaDtl = HLPParticularDtl.getParticularDtl(voObj.getStrAccountNo(),voObj.getStrHospitalCode());
					String[] TestData2 = strParticulaDtl.split("\\####");
					if (TestData2[0].equals("ERROR")) {
						throw new Exception(TestData2[1]);
					} else {
						clientView.append(TestData2[0]);
					}

				} else {

					clientView.append(CashCollectionTransHLP
							.getOnLineReconcileTariffDetailsView(voObj));

				}
				// clientView.append(HLPParticularDtl.getParticularDtl(voObj.getStrAccountNo(),voObj.getStrHospitalCode()));
			}
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(clientView.toString());
		} catch (Exception e) {

			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try {
				HisException eObj = new HisException("Billing",
						"CashCollectionTransDATA->getOnlineDtls()", strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1) {
				// System.out.println("Inside IInd Else::::"+e1.getMessage());
			}
		} finally {

			bo = null;

			voObj = null;
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
	public static void initOffLineDetails(CashCollectionTransFB formBean,
			CashCollectionTransBO bo, CashCollectionTransVO voObj) {

		BillConfigUtil billConfigUtil = null;
		HisUtil util = null;

		try {

			billConfigUtil = new BillConfigUtil(formBean.getStrHospitalCode());

			formBean.setStrOfflineIpdPenaltyVal(billConfigUtil
					.getIpdRefundPenalty());
			formBean.setStrOfflineOpdPenaltyVal(billConfigUtil
					.getOpdRefundPenalty());
			formBean.setStrOfflineEmergencyPenaltyVal(billConfigUtil
					.getEmergencyRefundPenalty());

			formBean.setStrIsEmergencyDiscount(billConfigUtil
					.getEmergencyDiscountClerk());
			formBean.setStrIsIpdDiscount(billConfigUtil.getIpdDiscountClerk());
			formBean.setStrIsOpdDiscount(billConfigUtil.getOpdDiscountClerk());

			voObj.setStrOffLineRequestType("1");
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrCrNo(formBean.getStrCrNo());
			voObj.setStrOffLineHospitalService(formBean
					.getStrOffLineHospitalService());
			voObj.setStrSeatId(formBean.getStrSeatId());

			bo.initOffLineDetails(voObj);
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}

			util = new HisUtil("Billing Transaction", "CashCollectionTrans");
			String temp = "";

			if (voObj.getOfflineHospitalServiceList() != null
					&& voObj.getOfflineHospitalServiceList().size() != 0) {
				temp = util.getOptionValue(voObj
						.getOfflineHospitalServiceList(), voObj
						.getStrOffLineHospitalService(), "", false);

				formBean.setStrHospitalServiceDetails(temp);
			}

			if (voObj.getOfflineBillingServiceList() != null
					&& voObj.getOfflineBillingServiceList().size() != 0) {
				temp = util.getOptionValue(
						voObj.getOfflineBillingServiceList(), voObj
								.getStrOffLineBillingService(), "", false);

				formBean.setStrBillingServiceDetails(temp);
			}

			if (voObj.getOfflineRaisingDepartmentList() != null
					&& voObj.getOfflineRaisingDepartmentList().size() != 0) {
				temp = util.getOptionValue(voObj
						.getOfflineRaisingDepartmentList(), voObj
						.getStrOffLineRaisingDepartment(), "0^Select Value",
						false);

				formBean.setStrRaisingDepartmentDetails(temp);
			} else {
				formBean
						.setStrRaisingDepartmentDetails("<option value='0'>Select Value</option>");
			}

			if (voObj.getOfflineEpisodeList() != null
					&& voObj.getOfflineEpisodeList().size() != 0) {
				temp = util.getOptionValue(voObj.getOfflineEpisodeList(), voObj
						.getStrOffLineEpisode(), "0^Select Value", true);

				formBean.setStrEpisodeDetails(temp);

				String temp1[] = voObj.getStrOffLineEpisode().replace("@", "#")
						.split("#");

				if (!temp1[1].equals("") || !temp1[1].equals("0")) {

					voObj.setStrOffLineTreatmentCategory(temp1[1]);
				}

			} else {
				formBean
						.setStrEpisodeDetails("<option value='0'>Select Value</option>");
			}

			if (voObj.getOfflineTreatmentCategoryList() != null
					&& voObj.getOfflineTreatmentCategoryList().size() != 0) {
				temp = util.getOptionValue(voObj
						.getOfflineTreatmentCategoryList(), voObj
						.getStrOffLineTreatmentCategory(), "0^Select Value",
						false);

				formBean.setStrTreatmentCategoryDetails(temp);
			} else {
				formBean
						.setStrTreatmentCategoryDetails("<option value='0'>Select Value</option>");
			}

			if (voObj.getOfflineWardList() != null
					&& voObj.getOfflineWardList().size() != 0) {
				temp = util.getOptionValue(voObj.getOfflineWardList(), voObj
						.getStrOffLineWard(), "0^Select Value", false);

				formBean.setStrWardDetails(temp);
			} else {
				formBean
						.setStrWardDetails("<option value='0'>Select Value</option>");
			}

			
			if (voObj.getStrClientNameList() != null
					&& voObj.getStrClientNameList().size() != 0) {
				temp = util.getOptionValue(voObj.getStrClientNameList(), voObj
						.getStrOffLineWard(), "0^Select Value", false);

				formBean.setStrClientNameContents(temp);
			} else {
				formBean
						.setStrClientNameContents("<option value='0'>Select Value</option>");
			}
			
			if (voObj.getStrPaymentModeList() != null
					&& voObj.getStrPaymentModeList().size() != 0) {
				temp = util.getOptionValue(voObj.getStrPaymentModeList(), "", "", false);

				formBean.setStrPaymentModeContents(temp);
			} 
			
			
			if (bo.isPartPaymentorAdvanceExist(voObj)) {

				String strPartOrAdvanceDtls = "";

				if (voObj.getStrOffLineBillingService().equals("19")) {

					strPartOrAdvanceDtls = CashCollectionTransHLP
							.getOffLineAdvanceDetailsView(voObj);
				} else {

					strPartOrAdvanceDtls = CashCollectionTransHLP
							.getOffLinePartPaymentDetailsView(voObj);
				}

				formBean
						.setStrPartPayAdvanceAmountDetails(strPartOrAdvanceDtls);
			}

			String strOffLineClientDtls = "";

			// Logics to get Offline Client Details
			if (formBean.getStrOffLineHospitalService().equals("1")
					&& formBean.getStrOpdThirdPartyBenefit().equals("1")
					|| formBean.getStrOffLineHospitalService().equals("2")
					&& formBean.getStrIpdThirdPartyBenefit().equals("1")
					|| formBean.getStrOffLineHospitalService().equals("3")
					&& formBean.getStrEmergencyThirdPartyBenefit().equals("1")) {

				strOffLineClientDtls = CashCollectionTransHLP
						.getOffLineClientDetailsView(voObj);

			}

			strOffLineClientDtls = strOffLineClientDtls
					+ CashCollectionTransHLP.getOffLineOtherDetailsView(voObj);

			formBean.setStrOfflineClientDetailsView(strOffLineClientDtls);

			if (voObj.getOfflineGroupList() != null
					&& voObj.getOfflineGroupList().size() != 0) {
				temp = util.getOptionValue(voObj.getOfflineGroupList(), voObj
						.getStrOffLineWard(), "0^All Group", false);

				formBean.setStrOfflineGroupDetails(temp);
			}

			/*
			 * if (voObj.getOfflineTariffList().size() != 0) {
			 * formBean.setStrOfflineTariffDetails(HisUtil.getDropDown1(voObj
			 * .getOfflineTariffList(), 1, 5, false)); }
			 */

			if (voObj.getOfflinePackageGroup() != null
					&& voObj.getOfflinePackageGroup().size() != 0) {
				temp = util.getOptionValue(voObj.getOfflinePackageGroup(),
						voObj.getStrOffLineWard(), "0^All Group", false);

				formBean.setStrOfflinePkgsGroupDetails(temp);
			}

			if (voObj.getOfflineDiscountApprovedBy() != null
					&& voObj.getOfflineDiscountApprovedBy().size() != 0) {
				temp = util.getOptionValue(
						voObj.getOfflineDiscountApprovedBy(), "0",
						"0^Select Value", false);

				formBean.setStrOfflineDiscountApprovedByDetails(temp);
			}

			if (voObj.getOfflineDiscountRemarks() != null
					&& voObj.getOfflineDiscountRemarks().size() != 0) {
				temp = util.getOptionValue(voObj.getOfflineDiscountRemarks(),
						"", "", false);

				temp = temp + "<option value='0'>Others</option>";

				formBean.setStrOfflineDiscountRemarksDetails(temp);
			}

			if (voObj.getOfflineRemarksList() != null
					&& voObj.getOfflineRemarksList().size() != 0) {
				temp = util.getOptionValue(voObj.getOfflineRemarksList(),
						"", "", false);

				temp = temp + "<option value='0'>Others</option>";

				formBean.setStrOffLineRefundReasonDetails(temp);
			}else{
				
				temp = "<option value='0'>Others</option>";

				formBean.setStrOffLineRefundReasonDetails(temp);
				
			}
			
			
			
			
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));

		} catch (Exception e) {

			e.printStackTrace();
			
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("Billing",
					"CashCollectionTransDATA->initOffLineDetails()", strmsgText);
			formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");

			eObj = null;

		} finally {

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
	public static void getBillServiceDetails(HttpServletRequest request,
			HttpServletResponse response) {

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;
		HisUtil util = null;
		try {
			bo = new CashCollectionTransBO();
			voObj = new CashCollectionTransVO();

			String strHospitalService = request.getParameter("hService");
			String strRequestType = request.getParameter("requestType");

			if (strHospitalService == null)
				strHospitalService = "0";
			if (strRequestType == null)
				strRequestType = "0";

			voObj.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());
			voObj.setStrOffLineHospitalService(strHospitalService);
			voObj.setStrOffLineRequestType(strRequestType);

			bo.getBillServiceDetails(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}

			util = new HisUtil("Billing Transaction", "CashCollectionTrans");
			String temp = "<option value='0'>Select Value</option>";

			if (voObj.getOfflineBillingServiceList().size() != 0) {
				temp = util.getOptionValue(
						voObj.getOfflineBillingServiceList(), voObj
								.getStrOffLineBillingService(), "", false);

			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			String strmsgText = e.getMessage();
			new HisException("Billing",
					"CashCollectionTransDATA->getBillServiceDetails()",
					strmsgText);

		} finally {

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
	public static void getEpisodeDetails(HttpServletRequest request,
			HttpServletResponse response) {

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;
		HisUtil util = null;

		try {

			bo = new CashCollectionTransBO();
			voObj = new CashCollectionTransVO();

			String strCrNo = request.getParameter("crNo");
			String strDeptCode = request.getParameter("deptCode");

			if (strCrNo == null)
				strCrNo = "0";
			if (strDeptCode == null)
				strDeptCode = "0";

			voObj.setStrCrNo(strCrNo);
			voObj.setStrOffLineRaisingDepartment(strDeptCode);
			voObj.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			bo.getEpisodeDetails(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}

			util = new HisUtil("Billing Transaction", "CashCollectionTrans");
			String temp = "<option value='0'>Select Value</option>";

			if (voObj.getOfflineEpisodeList().size() != 0) {

				temp = util.getOptionValue(voObj.getOfflineEpisodeList(), voObj
						.getStrOffLineEpisode(), "", true);

				String temp1[] = voObj.getStrOffLineEpisode().replace("@", "#")
						.split("#");

				if (!temp1[1].equals("") || !temp1[1].equals("0")) {

					voObj.setStrOffLineTreatmentCategory(temp1[1]);
				}

			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(
					temp + "@" + voObj.getStrOffLineTreatmentCategory());

		} catch (Exception e) {
			String strmsgText = e.getMessage();
			new HisException("Billing",
					"CashCollectionTransDATA->getEpisodeDetails()", strmsgText);

		} finally {

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
	public static void getPartPaymentOrAccountDtls(HttpServletRequest request,
			HttpServletResponse response) {

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;

		try {
			bo = new CashCollectionTransBO();
			voObj = new CashCollectionTransVO();

			String strHService = request.getParameter("hService");
			String strRequestType = request.getParameter("requestType");
			String strBillService = request.getParameter("billService");
			String strTreatmentCat = request.getParameter("treatmentCat");
			String strWard = request.getParameter("ward");
			String strCrNo = request.getParameter("strCrNo");

			if (strHService == null)
				strHService = "0";
			if (strRequestType == null)
				strRequestType = "0";
			if (strBillService == null)
				strBillService = "0";
			if (strTreatmentCat == null)
				strTreatmentCat = "0";
			if (strWard == null)
				strWard = "0";
			if (strCrNo == null)
				strCrNo = "0";

			voObj.setStrOffLineHospitalService(strHService);
			voObj.setStrOffLineRequestType(strRequestType);
			voObj.setStrOffLineBillingService(strBillService);
			voObj.setStrOffLineTreatmentCategory(strTreatmentCat);

			String[] strWardDtls = strWard.replace("^", "#").split("#");

			voObj.setStrOffLineWard(strWardDtls[0]);
			voObj.setStrOffLineIpdChargeTypeId(strWardDtls[1]);

			voObj.setStrCrNo(strCrNo);
			voObj.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			String temp = "";

			if (bo.isPartPaymentorAdvanceExist(voObj)) {

				bo.getPartPaymentOrAdvanceDtls(voObj);

				if (voObj.getStrMsgType().equals("1")) {
					throw new Exception(voObj.getStrMsgString());

				}

				if (voObj.getStrOffLineBillingService().equals("19")) {

					temp = CashCollectionTransHLP
							.getOffLineAdvanceDetailsView(voObj);
				} else {

					temp = CashCollectionTransHLP
							.getOffLinePartPaymentDetailsView(voObj);
				}

			} else {

				// Hospital Service - 2(IPD) , Request Type - 2(Refund) and Bill
				// Service - 19(Account)

				if (voObj.getStrOffLineHospitalService().equals("2")
						&& voObj.getStrOffLineRequestType().equals("2")
						&& voObj.getStrOffLineBillingService().equals("19")) {

					bo.getAdmissionCancellationDtl(voObj);

					if (voObj.getAdmissionCancellationDetails() != null
							&& voObj.getAdmissionCancellationDetails().size() > 0) {

						temp = CashCollectionTransHLP
								.getAdmissionCancellationDetails(voObj, "2");

					} else {

						temp = "@Either Account Not Opened or patient has been accepted in ward";

					}
				}
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			String strmsgText = e.getMessage();
			new HisException("Billing",
					"CashCollectionTransDATA->getPaymentOrAccountDetails()",
					strmsgText);

		} finally {

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
	public static void getGroupDetails(HttpServletRequest request,
			HttpServletResponse response) {

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;
		HisUtil util = null;

		try {
			bo = new CashCollectionTransBO();
			voObj = new CashCollectionTransVO();

			String strHospitalService = request.getParameter("hService");
			String strIsPackWiseGroup = request.getParameter("withPack");
			if (strHospitalService == null)
				strHospitalService = "0";

			voObj.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			voObj.setStrOffLineHospitalService(strHospitalService);
			voObj.setStrOffLineIsPackageGroup(strIsPackWiseGroup);

			bo.getGroupDetails(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}

			util = new HisUtil("Billing Transaction", "CashCollectionTrans");
			String temp = "<option value='0'>All Group</option>";

			if (strIsPackWiseGroup.equals("0")) {
				if (voObj.getOfflineGroupList().size() != 0) {

					temp = util.getOptionValue(voObj.getOfflineGroupList(),
							"0", "0^All Group", false);

				}
			} else {

				if (voObj.getOfflinePackageGroup().size() != 0) {

					temp = util.getOptionValue(voObj.getOfflinePackageGroup(),
							"0", "0^All Group", false);

				}

			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try {
				HisException eObj = new HisException("Billing",
						"IpdBillManagementTransDATA->UNITVAL12()", strmsgText);
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
	public static void getClientDetails(HttpServletRequest request,
			HttpServletResponse response) {

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;

		try {
			bo = new CashCollectionTransBO();
			voObj = new CashCollectionTransVO();

			String strCrNo = request.getParameter("crNo");
			String strHospitalService = request.getParameter("hService");

			if (strHospitalService == null)
				strHospitalService = "0";

			voObj.setStrCrNo(strCrNo);
			voObj.setStrOffLineHospitalService(strHospitalService);
			voObj.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			bo.getOffLineClientDetails(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}

			String temp = CashCollectionTransHLP
					.getOffLineClientDetailsView(voObj);

			temp = temp
					+ CashCollectionTransHLP.getOffLineOtherDetailsView(voObj);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try {
				HisException eObj = new HisException("Billing",
						"CashCollectionTransDATA->getClientDetails()",
						strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1) {
				new HisException("Billing",
						"IpdBillManagementTransDATA->getClientDetails()", e1
								.getMessage());
			}
		} finally {

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
	 * CashCollectionTransHLP .getOnLineThirdPartyAmountDtlView(strBServiceId ,
	 * "1");
	 * 
	 * }else if((strRequestTypeId.equals("1") || strRequestTypeId.equals("2")) &&
	 * strBServiceId .equals("21")){
	 * 
	 * temp = CashCollectionTransHLP
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
	 * strBServiceId.equals("10")) temp = CashCollectionTransHLP
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
	public static void getTariffDetails(HttpServletRequest request,
			HttpServletResponse response) {

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;
		HisUtil util = null;
		try {
			bo = new CashCollectionTransBO();
			voObj = new CashCollectionTransVO();

			util = new HisUtil("Billing",
					"CashCollectionTransDATA.getTariffDetails()");

			String strGroupCode = request.getParameter("groupId");
			String strHospitalService = request.getParameter("hService");
			String strTreatmentCategory = request.getParameter("treatmentCat");
			String strWardCode = request.getParameter("ward");

			if (strGroupCode == null)
				strGroupCode = "0";
			if (strHospitalService == null)
				strHospitalService = "0";
			if (strTreatmentCategory == null)
				strTreatmentCategory = "0";
			if (strWardCode == null || !strHospitalService.equals("2"))
				strWardCode = "0";

			voObj.setStrHospitalCode(request.getSession().getAttribute(
			"HOSPITAL_CODE").toString());
			voObj.setStrOffLineGroup(strGroupCode);
			voObj.setStrOffLineHospitalService(strHospitalService);
			voObj.setStrOffLineTreatmentCategory(strTreatmentCategory);
			voObj.setStrOffLineWard(strWardCode);

			voObj.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			bo.getTariffDetails(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}

			String temp = "";

			if (voObj.getOfflineTariffList().size() != 0) {

				// temp = HisUtil.getDropDown(voObj.getOfflineTariffList(), 1,
				// 5, false);
				temp = util.getDropDown(voObj.getOfflineTariffList(), 1, 5,
						false);

			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try {
				HisException eObj = new HisException("Billing",
						"CashCollectionTransDATA->getTariffDetails()",
						strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1) {
				new HisException("Billing",
						"IpdBillManagementTransDATA->getTariffDetails()", e1
								.getMessage());
			}
		} finally {

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
	public static void getTariffCodeDetails(HttpServletRequest request,
			HttpServletResponse response) {

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;
		
		try {
			bo = new CashCollectionTransBO();
			voObj = new CashCollectionTransVO();

			String strGroupCode = request.getParameter("groupId");
			String strHospitalService = request.getParameter("hService");
			String strTreatmentCategory = request.getParameter("treatmentCat");
			String strWardCode = request.getParameter("ward");
			String strTariffCode = request.getParameter("tariffCode");

			if (strGroupCode == null)
				strGroupCode = "0";
			if (strHospitalService == null)
				strHospitalService = "0";
			if (strTreatmentCategory == null)
				strTreatmentCategory = "0";
			if (strWardCode == null || !strHospitalService.equals("2"))
				strWardCode = "0";

			voObj.setStrHospitalCode(request.getSession().getAttribute(
			"HOSPITAL_CODE").toString());
			voObj.setStrOffLineGroup(strGroupCode);
			voObj.setStrOffLineHospitalService(strHospitalService);
			voObj.setStrOffLineTreatmentCategory(strTreatmentCategory);
			voObj.setStrOffLineWard(strWardCode);
			voObj.setStrTariffCode(strTariffCode);
			
			voObj.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			bo.getTariffCodeDetails(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}

			String temp = "";

			if (voObj.getOfflineTariffList().size() != 0) {
				
				if(voObj.getOfflineTariffList().next()){
					
					temp =  "1@@"+voObj.getOfflineTariffList().getString(2)+"@@"+voObj.getOfflineTariffList().getString(1);
				}
							
			}else{
				
					temp = "0@@_@@0";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try {
				HisException eObj = new HisException("Billing",
						"CashCollectionTransDATA->getTariffCodeDetails()",
						strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1) {
				new HisException("Billing",
						"IpdBillManagementTransDATA->getTariffCodeDetails()", e1
								.getMessage());
			}
		} finally {

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
	public static void getPackageDetails(HttpServletRequest request,
			HttpServletResponse response) {

		CashCollectionTransVO voObj = null;

		try {

			voObj = new CashCollectionTransVO();

			String strRowIndex = request.getParameter("rowIndex");

			if (strRowIndex == null)
				strRowIndex = "0";

			voObj.setStrOffLinePackageIndex(strRowIndex);

			voObj.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			String temp = CashCollectionTransHLP
					.getOffLinePackageDetailsView(voObj);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strRowIndex + "@" + temp);

		} catch (Exception e) {
			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try {
				HisException eObj = new HisException("Billing",
						"CashCollectionTransDATA->getPackageDetails()",
						strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1) {
				new HisException("Billing",
						"IpdBillManagementTransDATA->getPackageDetails()", e1
								.getMessage());
			}
		} finally {

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
	public static void getOffLineTariffUnitDetails(HttpServletRequest request,
			HttpServletResponse response) {

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;
		HisUtil util = null;

		try {

			bo = new CashCollectionTransBO();
			voObj = new CashCollectionTransVO();

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
			voObj.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			bo.getOffLineTariffUnitDetails(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}

			util = new HisUtil("Billing Transaction", "CashCollectionTrans");

			String temp = "<option value='0'>Select Value</option>";

			if (voObj.getOfflineTariffUnit().size() != 0) {

				temp = util.getOptionValue(voObj.getOfflineTariffUnit(),
						strUnitId + "^" + strUnitBaseVal, "", false);

			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strRowIndex + "@" + temp);

		} catch (Exception e) {
			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try {
				HisException eObj = new HisException(
						"Billing",
						"CashCollectionTransDATA->getOffLineTariffUnitDetails()",
						strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1) {
				new HisException(
						"Billing",
						"IpdBillManagementTransDATA->getOffLineTariffUnitDetails()",
						e1.getMessage());
			}
		} finally {

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
	public static void getOffLineRefundBillDetails(HttpServletRequest request,
			HttpServletResponse response) {
		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;
		try {
			bo = new CashCollectionTransBO();
			voObj = new CashCollectionTransVO();

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
			voObj.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			bo.getOffLineBillDetails(voObj);

			if (voObj.getStrMsgType().equals("1")) {

				throw new Exception(voObj.getStrMsgString());
			}

			String temp = CashCollectionTransHLP.getBillDetails(voObj);

			voObj.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			if (!voObj.getStrOffLineBillNumber().equals("0")) {
				
				bo.getOffLineBillTariffDetails(voObj);

				if (voObj.getStrMsgType().equals("1")) {

					throw new Exception(voObj.getStrMsgString());

				}

				temp = temp + "@"
						+ CashCollectionTransHLP.getTariffDetails(voObj);

			}
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {

			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try {
				HisException eObj = new HisException(
						"Billing",
						"CashCollectionTransDATA->getOffLineRefundBillDetails()",
						strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1) {
				new HisException(
						"Billing",
						"IpdBillManagementTransDATA->getOffLineRefundBillDetails()",
						e1.getMessage());
			}
		} finally {

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
	public static void getOffLineRefundBillTariffDetails(
			HttpServletRequest request, HttpServletResponse response) {

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;

		try {

			bo = new CashCollectionTransBO();
			voObj = new CashCollectionTransVO();

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
			voObj.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			bo.getOffLineBillTariffDetails(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}

			voObj.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			// String temp = CashCollectionTransHLP.getTariffDetails(voObj);
			// Calling TariffDtls
			String temp = CashCollectionTransHLP.getTariffDetails(voObj);
			String[] TestData = temp.split("\\####");
			// System.out.println("TestData[0]--->"+TestData[0]);
			// System.out.println("TestData[1]--->"+TestData[1]);
			response.setHeader("Cache-Control", "no-cache");
			if (TestData[0].equals("ERROR")) {
				throw new Exception(TestData[1]);
			} else {
				response.getWriter().print(temp);
			}
		} catch (Exception e) {

			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try {
				HisException eObj = new HisException(
						"Billing",
						"CashCollectionTransDATA->getOffLineRefundBillTariffDetails()",
						strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1) {
				new HisException(
						"Billing",
						"IpdBillManagementTransDATA->getOffLineRefundBillTariffDetails()",
						e1.getMessage());
			}
		} finally {

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
	public static void getOffLineRefundBillTariffPopupDetails(
			HttpServletRequest request, HttpServletResponse response) {

		CashCollectionTransVO voObj = null;

		try {

			voObj = new CashCollectionTransVO();

			String strHidVal = request.getParameter("hidValue");

			if (strHidVal == null)
				strHidVal = "0";

			voObj.setStrOffLineTariffDetailsHiddenValue(strHidVal);
			voObj.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			String temp = CashCollectionTransHLP.getPopUp(voObj);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try {
				HisException eObj = new HisException(
						"Billing",
						"CashCollectionTransDATA->getOfflineTariffUnitBillDetails()",
						strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1) {
				new HisException(
						"Billing",
						"IpdBillManagementTransDATA->getOfflineTariffUnitBillDetails()",
						e1.getMessage());
			}
		} finally {

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
		CashCollectionTransVO vo = new CashCollectionTransVO();

		try {
			String strHospCode = request.getSession().getAttribute(
					"HOSPITAL_CODE").toString();
			// Calling TariffDtls
			strTariffDtl1 = HLPTariffDtl.getTariffDtl(data[0], data[1],
					strHospCode);
			strTariffDtl = strTariffDtl1 + '@' + data[2];

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strTariffDtl);

		} catch (Exception e) {

			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try {
				HisException eObj = new HisException("Billing",
						"CashCollectionTransDATA->UNITVAL12()", strmsgText);
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

		CashCollectionTransVO voObj = null;

		try {

			voObj = new CashCollectionTransVO();

			String strHidVal = request.getParameter("hidValue");

			if (strHidVal == null)
				strHidVal = "0";

			voObj.setStrRefundTariffHiddenValue(strHidVal);
			voObj.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			String temp = CashCollectionTransHLP.getRefundTariffPopUp(voObj);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try {
				HisException eObj = new HisException(
						"Billing",
						"CashCollectionTransDATA->getOnLineRefundTariffPopupDetails()",
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
	 * Initialize Without Cr. No. Page.
	 * 
	 * @param request
	 *            the request
	 * @param formBean
	 *            the form bean
	 */
	public static void initWithoutCrNo(HttpServletRequest request,
			CashCollectionTransFB formBean) {

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;

		HisUtil util = null;
		BillConfigUtil billConfigUtil = null;

		String strHospitalService = BillConfigUtil.DEFAULT_HOSPITAL_SERVICE;
		String strCategoryCode = BillConfigUtil.NORMAL_CATEGORY;

		formBean.setStrOffLineHospitalService(strHospitalService);
		formBean.setStrOffLineTreatmentCategory(strCategoryCode);

		try {

			billConfigUtil = new BillConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			formBean.setStrIsOpdDiscount(billConfigUtil.getOpdDiscountClerk());

			bo = new CashCollectionTransBO();
			voObj = new CashCollectionTransVO();

			voObj.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());
			
			voObj.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
			
			voObj.setStrOffLineIsPackageGroup("0");

			voObj.setStrOffLinePackageIndex("0");

			voObj.setStrOffLineHospitalService(strHospitalService);
			voObj.setStrOffLineTreatmentCategory(strCategoryCode);
			bo.initwithoutCrNoDetails(voObj);

			if (voObj.getStrMsgType().equals("1")) {

				throw new Exception(voObj.getStrMsgString());

			}

			util = new HisUtil("Billing Transaction", "CashCollectionTrans");
			String temp = "";


			if (voObj.getStrClientNameList() != null
					&& voObj.getStrClientNameList().size() != 0) {
				temp = util.getOptionValue(voObj.getStrClientNameList(), voObj
						.getStrOffLineWard(), "0^Select Value", false);

				formBean.setStrClientNameContents(temp);
			} else {
				formBean
						.setStrClientNameContents("<option value='0'>Select Value</option>");
			}
			
			if (voObj.getStrPaymentModeList() != null
					&& voObj.getStrPaymentModeList().size() != 0) {
				temp = util.getOptionValue(voObj.getStrPaymentModeList(), "", "", false);

				formBean.setStrPaymentModeContents(temp);
			} 
			
			
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));

			if (voObj.getOfflineBillingServiceList().size() > 0) {
				temp = util.getOptionValue(
						voObj.getOfflineBillingServiceList(), voObj
								.getStrOffLineBillingService(), "", false);

				formBean.setStrBillingServiceDetails(temp);
			}

			if (voObj.getOfflineRaisingDepartmentList().size() > 0) {
				temp = util.getOptionValue(voObj
						.getOfflineRaisingDepartmentList(), voObj
						.getStrOffLineRaisingDepartment(), "0^Select Value",
						false);

				formBean.setStrRaisingDepartmentDetails(temp);
			} else {
				formBean
						.setStrRaisingDepartmentDetails("<option value='0'>Select Value</option>");
			}

			if (voObj.getOfflineGroupList().size() > 0) {
				temp = util.getOptionValue(voObj.getOfflineGroupList(), voObj
						.getStrOffLineWard(), "0^All Group", false);

				formBean.setStrOfflineGroupDetails(temp);
			}

			if (voObj.getOfflineTariffList().size() > 0) {

				// temp = HisUtil.getDropDown(voObj.getOfflineTariffList(), 1,
				// 5, false);
				temp = util.getDropDown(voObj.getOfflineTariffList(), 1, 5,
						false);

				formBean.setStrOfflineTariffDetails(temp);

			}

			if (voObj.getOfflineApprovedByList().size() > 0) {
				temp = util.getOptionValue(voObj.getOfflineApprovedByList(),
						"0", "0^Select Value", false);

				formBean.setStrOfflineDiscountApprovedByDetails(temp);
			} else {

				temp = "<option value='0'>Select Value</option>";

				formBean.setStrOfflineDiscountApprovedByDetails(temp);

			}

			if (voObj.getOfflineRemarksList().size() > 0) {
				temp = util.getOptionValue(voObj.getOfflineRemarksList(), "",
						"", false);

				temp = temp + "<option value='0'>Others</option>";

				formBean.setStrOfflineDiscountRemarksDetails(temp);
			} else {

				temp = "<option value='0'>Others</option>";

				formBean.setStrOfflineDiscountRemarksDetails(temp);

			}

			if (voObj.getStrRequestNoList().size() > 0) {
				temp = util.getOptionValue(voObj.getStrRequestNoList(), "0",
						"0^Select Value", true);

				formBean.setStrRequestNoValues(temp);
			} else {

				temp = "<option value='0'>Select Value</option>";

				formBean.setStrRequestNoValues(temp);

			}
			
			
			if (voObj.getWsGenderList().size() > 0) {
				temp = util.getOptionValue(voObj.getWsGenderList(), "0",
						"0^Select Value", true);

				formBean.setStrGenderList(temp);
			} else {

				temp = "<option value='0'>Select Value</option>";

				formBean.setStrGenderList(temp);

			}
			
			
			formBean.setStrIsPreviousCrNoReq(billConfigUtil.getGeneralPreviousCrNoRequiredInt());
			formBean.setStrIsPreviousCrNoReq(billConfigUtil.getGeneralPreviousCrNoRequiredExt());
			formBean.setStrIsRefPhysicanReq(billConfigUtil.getGeneralReferringPhysicianRequiredInt());
			formBean.setStrIsRefPhysicanReq(billConfigUtil.getGeneralReferringPhysicianRequiredExt());
			

		} catch (Exception e) {

			String strmsgText = e.getMessage();
			HisException eObj = new HisException("Billing",
					"CashCollectionTransDATA->initWithoutCrNo()", strmsgText);
			formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");

			eObj = null;

		} finally {

			bo = null;
			voObj = null;
			util = null;
			billConfigUtil = null;
		}
	}

	/**
	 * Initialize without Cr. No. Bill Page Details.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void initWithoutCrNoBillDetails(HttpServletRequest request,
			HttpServletResponse response) {

		CashCollectionTransVO voObj = null;
		CashCollectionTransBO bo = null;

		BillConfigUtil billConfigUtil = null;
		HisUtil util = null;
		
		String temp = "";
		try {

			voObj = new CashCollectionTransVO();
			bo = new CashCollectionTransBO();

			billConfigUtil = new BillConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			voObj.setStrOffLineRefundPenalty(billConfigUtil
					.getOpdRefundPenalty());

			String strBillNo = request.getParameter("billNo");

			voObj.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());
			voObj.setStrOffLineBillNumber(strBillNo);

			bo.initWithoutCrNoBillDetails(voObj);

			
			String strGaurantorVals = voObj.getStrGuarantorHiddenVal().trim();
			
			String[] strGaurantorVal = strGaurantorVals.replace("^", "#")
					.split("#");
			
			
			util = new HisUtil("Billing Transaction", "CashCollectionTrans");
						
			if (voObj.getWsGenderList().size() > 0) {
				temp = util.getOptionValue(voObj.getWsGenderList(), strGaurantorVal[6],
						"0^Select Value", true);
				
				voObj.setStrGenderList(temp);
				
			} else {

				temp = "<option value='0'>Select Value</option>";
				
				voObj.setStrGenderList(temp);
				
			}
			
			
			
			
			if (voObj.getOfflineBillTariffList().size() > 0) {

				temp = CashCollectionTransHLP.getGuarantorDetails(voObj);
				temp = temp + " "
						+ CashCollectionTransHLP.getTariffDetails(voObj);

			} else {

				temp = temp + "@" + "Invalid Bill No.";

			}

			if (voObj.getStrMsgType().equals("1")) {

				temp = temp + "@" + "Invalid Bill No.";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			
					
			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try {
				HisException eObj = new HisException(
						"Billing",
						"CashCollectionTransDATA->initWithoutCrNoBillDetails()",
						strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1) {
				new HisException(
						"Billing",
						"IpdBillManagementTransDATA->initWithoutCrNoBillDetails()",
						e1.getMessage());
			}
		} finally {

			bo = null;
			voObj = null;
			billConfigUtil = null;
			util = null;

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
	public static void getBillListingDtls(HttpServletRequest request,
			HttpServletResponse response, CashCollectionTransFB formBean) {

		CashCollectionTransVO voObj = null;
		CashCollectionTransBO bo = null;

		try {

			voObj = new CashCollectionTransVO();
			bo = new CashCollectionTransBO();

			String strSearchString = request.getParameter("searchString");
			String strFromRow = request.getParameter("fromRow");
			String strRowPerPage = request.getParameter("rowPerPage");
			String strCtBlockSet = request.getParameter("ctBlockSet");
			voObj.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			if (strSearchString.contains("^")) {
				strSearchString = strSearchString.replace('^', '%');
			}

			voObj.setStrBillSearchString(strSearchString);

			voObj.setStrBillFromRow(strFromRow);

			int nToRow = Integer.parseInt(strFromRow)
					+ Integer.parseInt(strRowPerPage) * 10;

			voObj.setStrBillToRow(String.valueOf(nToRow));
			voObj.setStrBillRowPerPage(strRowPerPage);
			voObj.setStrBillCtBlockSet(strCtBlockSet);

			bo.getBillListingDtl(voObj);

			if (voObj.getStrMsgType().equals("0")) {

				String val = CashCollectionTransHLP.getBillListingView(voObj);

				response.setHeader("Cache-Control", "no-cache");

				response.getWriter().print(val);

			} else {

				throw new Exception(voObj.getStrMsgString());

			}

		} catch (Exception e) {

			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try {
				HisException eObj = new HisException("Billing",
						"CashCollectionTransDATA->getBillListingDtls()",
						strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1) {
				new HisException("Billing",
						"IpdBillManagementTransDATA->getBillListingDtls()", e1
								.getMessage());
			}
		} finally {

			bo = null;

			voObj = null;
		}
	}

	
	
	/**
	 * gets Previous Cr No. Details as Ajax Response.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 */
	public static void getPreviousCrNoDtls(HttpServletRequest request,
			HttpServletResponse response, CashCollectionTransFB formBean) {

		CashCollectionTransVO voObj = null;
		CashCollectionTransBO bo = null;

		try {

			voObj = new CashCollectionTransVO();
			bo = new CashCollectionTransBO();

			String strPreviousCrNo = formBean.getStrPreviousCrNo();
			 
			voObj.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

		 
			voObj.setStrPreviousCrNo(strPreviousCrNo);
 
			bo.getPreviousCrNoDtls(voObj);

			if (voObj.getStrMsgType().equals("0")) {

				 

				response.setHeader("Cache-Control", "no-cache");

				response.getWriter().print(voObj.getStrPreviousCrNoPatientDtls());

			} else {

				throw new Exception(voObj.getStrMsgString());

			}

		} catch (Exception e) {

			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try {
				HisException eObj = new HisException("Billing",
						"CashCollectionTransDATA->getPreviousCrNoDtls()",
						strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1) {
				new HisException("Billing",
						"IpdBillManagementTransDATA->getPreviousCrNoDtls()", e1
								.getMessage());
			}
		} finally {

			bo = null;

			voObj = null;
		}
	}

	/**
	 * gets Online Reconcile Tariff Pop-up as Ajax Response.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	/*
	 * public static void getOnlineReconcilTariffPopupDetails(
	 * HttpServletRequest request, HttpServletResponse response) {
	 * 
	 * CashCollectionTransVO voObj = null;
	 * 
	 * try {
	 * 
	 * voObj = new CashCollectionTransVO();
	 * 
	 * String strHidVal = request.getParameter("hidVal");
	 * 
	 * if (strHidVal == null) strHidVal = "0";
	 * 
	 * voObj.setStrOnLineReconcileTariffHiddenValue(strHidVal);
	 * voObj.setStrHospitalCode(request.getSession().getAttribute(
	 * "HOSPITAL_CODE").toString());
	 * 
	 * String temp = CashCollectionTransHLP
	 * .getOnLineReconcileTariffDetailsPopUp(voObj);
	 * 
	 * response.setHeader("Cache-Control", "no-cache");
	 * response.getWriter().print(temp); } catch (Exception e) { String
	 * strmsgText = e.getMessage(); response.setHeader("Cache-Control",
	 * "no-cache"); try { HisException eObj = new HisException( "Billing",
	 * "CashCollectionTransDATA->getOnlineReconcilTariffPopupDetails()",
	 * strmsgText); String response1 = "ERROR####Application Error [ERROR ID : " +
	 * eObj.getErrorID() + "], Contact System Administrator!";
	 * response.getWriter().print(response1); eObj = null; } catch (IOException
	 * e1) { new HisException( "Billing",
	 * "IpdBillManagementTransDATA->getOnlineReconcilTariffPopupDetails()",
	 * e1.getMessage()); } } finally { if (voObj != null) voObj = null; } }
	 */
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
						"CashCollectionTransDATA->getAdmissionCancellationDtls()",
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

	public static void getOfflineRaisingDetapartmentDtls(
			HttpServletRequest request, HttpServletResponse response) {

		CashCollectionTransVO voObj = null;
		CashCollectionTransBO bo = null;
		HisUtil util = null;

		String temp = "";

		try {

			voObj = new CashCollectionTransVO();
			bo = new CashCollectionTransBO();
			util = new HisUtil("Cash Collection Trans",
					"CashCollectionTransDATA.getOfflineRaisingDetapartmentDtls()");

			String strCrNo = request.getParameter("strCrNo");
			String strHospitalService = request.getParameter("strChargeTypeId");

			if (strCrNo == null)
				strCrNo = "0";
			if (strHospitalService == null)
				strHospitalService = "0";

			voObj.setStrCrNo(strCrNo);

			voObj.setStrOffLineHospitalService(strHospitalService);

			voObj.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			bo.getOfflineRaisingDepartmentDtl(voObj);

			if (voObj.getOfflineRaisingDepartmentList() != null
					&& voObj.getOfflineRaisingDepartmentList().size() > 0) {

				temp = util.getOptionValue(voObj
						.getOfflineRaisingDepartmentList(), "", "", false);

			} else {

				temp = "<option value='0'>Select Value</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try {
				HisException eObj = new HisException(
						"Billing",
						"CashCollectionTransDATA->getOfflineRaisingDetapartmentDtls()",
						strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1) {
				new HisException(
						"Billing",
						"IpdBillManagementTransDATA->getOfflineRaisingDetapartmentDtls()",
						e1.getMessage());
			}
		} finally {

			voObj = null;
			bo = null;
			util = null;

		}

	}

	public static void getOfflineTreatmentCategoryDtls(
			HttpServletRequest request, HttpServletResponse response) {

		CashCollectionTransVO voObj = null;
		CashCollectionTransBO bo = null;
		HisUtil util = null;

		String temp = "";

		try {

			voObj = new CashCollectionTransVO();
			bo = new CashCollectionTransBO();
			util = new HisUtil("Cash Collection Trans",
					"CashCollectionTransDATA.getOfflineTreatmentCategoryDtls()");

			String strCrNo = request.getParameter("strCrNo");
			String strHospitalService = request.getParameter("strChargeTypeId");

			if (strCrNo == null)
				strCrNo = "0";
			if (strHospitalService == null)
				strHospitalService = "0";

			voObj.setStrCrNo(strCrNo);

			voObj.setStrOffLineHospitalService(strHospitalService);

			voObj.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			bo.getOfflineTreatmentCategoryDtl(voObj);

			if (voObj.getOfflineTreatmentCategoryList() != null
					&& voObj.getOfflineTreatmentCategoryList().size() > 0) {

				temp = util.getOptionValue(voObj
						.getOfflineTreatmentCategoryList(), "", "", false);

			} else {

				temp = "<option value='0'>Select Value</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try {
				HisException eObj = new HisException(
						"Billing",
						"CashCollectionTransDATA->getOfflineTreatmentCategoryDtls()",
						strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1) {
				new HisException(
						"Billing",
						"IpdBillManagementTransDATA->getOfflineTreatmentCategoryDtls()",
						e1.getMessage());
			}
		} finally {

			voObj = null;
			bo = null;
			util = null;

		}

	}

	public static void getOfflineWardDtls(HttpServletRequest request,
			HttpServletResponse response) {

		CashCollectionTransVO voObj = null;
		CashCollectionTransBO bo = null;
		HisUtil util = null;

		String temp = "";

		try {

			voObj = new CashCollectionTransVO();
			bo = new CashCollectionTransBO();
			util = new HisUtil("Cash Collection Trans",
					"CashCollectionTransDATA.getOfflineWardDtls()");

			String strCrNo = request.getParameter("strCrNo");
			String strHospitalService = request.getParameter("strChargeTypeId");

			if (strCrNo == null)
				strCrNo = "0";
			if (strHospitalService == null)
				strHospitalService = "0";

			voObj.setStrCrNo(strCrNo);

			voObj.setStrOffLineHospitalService(strHospitalService);

			voObj.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			bo.getOfflineWardDtl(voObj);

			if (voObj.getOfflineWardList() != null
					&& voObj.getOfflineWardList().size() > 0) {

				temp = util.getOptionValue(voObj.getOfflineWardList(), "", "",
						false);

			} else {

				temp = "<option value='0'>Select Value</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			
			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try {
				HisException eObj = new HisException("Billing",
						"CashCollectionTransDATA->getOfflineWardDtls()",
						strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1) {
				new HisException("Billing",
						"IpdBillManagementTransDATA->getOfflineWardDtls()", e1
								.getMessage());
			}
		} finally {

			voObj = null;
			bo = null;
			util = null;

		}

	}

	public static void getWithoutCrNoOnlineReqTariffDtls(
			HttpServletRequest request, HttpServletResponse response) {

		CashCollectionTransVO voObj = null;
		CashCollectionTransBO bo = null;

		String temp = "";

		try {

			voObj = new CashCollectionTransVO();
			bo = new CashCollectionTransBO();

			String strReqNo = request.getParameter("strReqNo");
			String strChargeTypeId = request.getParameter("strChargeTypeId");

			if (strReqNo == null)
				strReqNo = "0";
			if (strChargeTypeId == null)
				strChargeTypeId = "0";

			voObj.setStrRequestNo(strReqNo);

			voObj.setStrChargeTypeId(strChargeTypeId);

			voObj.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			bo.getWithoutCrNoOnlineReqTariffDtls(voObj);

			temp = CashCollectionTransHLP
					.getWithoutCrNoOnLineTariffDetailsView(voObj);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try {
				HisException eObj = new HisException(
						"Billing",
						"CashCollectionTransDATA->getWithoutCrNoOnlineReqTariffDtls()",
						strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1) {
				new HisException(
						"Billing",
						"IpdBillManagementTransDATA->getWithoutCrNoOnlineReqTariffDtls()",
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

			PrintHLP
					.updatePrintStatus(strBillNo, strReceiptNo, request
							.getSession().getAttribute("HOSPITAL_CODE")
							.toString(), "0");

		} catch (Exception e) {

			HisException eObj = new HisException("Billing",
					"CashCollectionTransDATA->updatePrintStatus()", e
							.getMessage());
			String response1 = "ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator!";

			eObj = null;

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(response1);
			} catch (IOException e1) {

				new HisException("Billing",
						"IpdBillManagementTransDATA->updatePrintStatus()", e1
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
	public static boolean insertOnlineReceiptPartPayment(
			CashCollectionTransFB formBean , HttpServletRequest request) {

		boolean fRes = false;

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;

		try {

			bo = new CashCollectionTransBO();

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
			formBean.setStrRequestFor(temp[15]);

			if (temp[18].trim().length() < 1) {
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

			voObj = (CashCollectionTransVO) TransferObjectFactory.populateData(
					"billing.transactions.CashCollectionTransVO", formBean);

			if (formBean.getStrOnlineClientDetails() != null) {
				String strClientTemp[] = formBean.getStrOnlineClientDetails()
						.replace("^", "#").split("#");

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

			if (!voObj.getStrMsgType().equals("1")) {

				PrintHLP.PART_PAYMENT(formBean.getStrBillNo(), formBean
						.getStrBillingService(), formBean.getStrHospitalCode(),
						formBean.getStrReceiptNo() , request , 0, null);

				formBean.setStrNormalMsg("Receipt No. '"
						+ formBean.getStrBillNo()
						+ "/1"
						+ "' Generated Successfully for the Amount <img src='/AHIMS/hisglobal/images/INR.png'> '"
						+ HisUtil.getAmountWithDecimal(formBean
								.getStrOnlineTotalRecAmount(), 2) + "'");

				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo("1");

				fRes = true;
			} else {

				fRes = false;

				throw new Exception(voObj.getStrMsgString());

			}

		} catch (Exception e) {

			String err = e.getMessage();

			HisException eObj = new HisException(
					"Billing Transaction",
					"CashCollectionTransDATA.insertOnlineReceiptPartPayment()-->",
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

	public static boolean insertOnlineReceiptAdvance(
			CashCollectionTransFB formBean  , HttpServletRequest request) {

		boolean fRes = false;

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;

		try {

			bo = new CashCollectionTransBO();

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
			formBean.setStrRequestFor(temp[15]);

			if (temp[18].trim().length() < 1) {
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

			voObj = (CashCollectionTransVO) TransferObjectFactory.populateData(
					"billing.transactions.CashCollectionTransVO", formBean);

			if (formBean.getStrOnlineClientDetails() != null) {
				String strClientTemp[] = formBean.getStrOnlineClientDetails()
						.replace("^", "#").split("#");

				voObj.setStrClientName(strClientTemp[0]);
				voObj.setStrClientType(strClientTemp[1]);
				voObj.setStrSancAmount(strClientTemp[2]);
				voObj.setStrClientBalance(strClientTemp[3]);
				voObj.setStrClientApprovalNo(strClientTemp[4]);
			}

			bo.insertOnlineReceiptAdvance(voObj);

			formBean.setStrReceiptNo("1");
			formBean.setStrBillNo(voObj.getStrBillNo());
			formBean.setStrCrNo("");

			if (!voObj.getStrMsgType().equals("1")) {

				PrintHLP.ADVANCE(formBean.getStrBillNo(), formBean
						.getStrBillingService(), formBean.getStrHospitalCode(),
						formBean.getStrReceiptNo() , request , 0, null, null);

				formBean.setStrNormalMsg("Receipt No. '"
						+ formBean.getStrBillNo()
						+ "/1"
						+ "' Generated Successfully for the Amount <img src='/AHIMS/hisglobal/images/INR.png'>'"
						+ HisUtil.getAmountWithDecimal(formBean
								.getStrOnlineTotalRecAmount(), 2) + "'");

				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo("1");

				fRes = true;
			} else {

				fRes = false;

				throw new Exception(voObj.getStrMsgString());

			}

		} catch (Exception e) {

			String err = e.getMessage();

			HisException eObj = new HisException(
					"Billing Transaction",
					"CashCollectionTransDATA.insertOnlineReceiptPartPayment()-->",
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
	public static boolean insertOnlineReceiptServices(
			CashCollectionTransFB formBean  , HttpServletRequest request) {

		boolean fRes = false;

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;

		try {

			bo = new CashCollectionTransBO();

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

			voObj = (CashCollectionTransVO) TransferObjectFactory.populateData(
					"billing.transactions.CashCollectionTransVO", formBean);

			if (formBean.getStrOnlineClientDetails() != null) {
				String strClientTemp[] = formBean.getStrOnlineClientDetails()
						.replace("^", "#").split("#");

				voObj.setStrClientName(strClientTemp[0]);
				voObj.setStrClientType(strClientTemp[1]);
				voObj.setStrSancAmount(strClientTemp[2]);
				voObj.setStrClientBalance(strClientTemp[3]);
				voObj.setStrClientApprovalNo(strClientTemp[4]);
			}

			bo.insertOnlineReceiptServices(voObj);

			formBean.setStrBillNo(voObj.getStrBillNo());
			formBean.setStrReceiptNo("1");
			formBean.setStrCrNo("");

			if (!voObj.getStrMsgType().equals("1")) {

				if (formBean.getStrChargeTypeId().equals("2")) {

					PrintHLP.IPD_SERVICES(formBean.getStrBillNo(), formBean
							.getStrAccountNo(),
							formBean.getStrBillingService(), formBean
									.getStrHospitalCode(), formBean
									.getStrReceiptNo() , request, null , "0" , 0, null, null);

				} else {

					PrintHLP.OPD_SERVICES(formBean.getStrBillNo(), formBean
							.getStrBillingService(), formBean
							.getStrHospitalCode(), formBean.getStrReceiptNo() , request , null , "0" , 0, null, null);

				}

				formBean.setStrNormalMsg("Receipt No. '"
						+ formBean.getStrBillNo()
						+ "/1"
						+ "' Generated Successfully for the Amount <img src='/AHIMS/hisglobal/images/INR.png'> '"
						+ HisUtil.getAmountWithDecimal(formBean
								.getStrOnlineTotalRecAmount(), 2) + "'");

				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo("1");

				fRes = true;
			} else {

				fRes = false;

				String err = voObj.getStrMsgString();

				throw new Exception(err);

			}

		} catch (Exception e) {

			HisException eObj = new HisException("Billing Transaction",
					"CashCollectionTransDATA.insertOnlineReceiptServices()-->",
					e.getMessage());

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
	 * Insert online refund services details.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return true, if successful
	 */
	public static boolean insertOnlineRefundServices(
			CashCollectionTransFB formBean  , HttpServletRequest request) {

		boolean fRes = false;

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;

		try {

			bo = new CashCollectionTransBO();

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

			voObj = (CashCollectionTransVO) TransferObjectFactory.populateData(
					"billing.transactions.CashCollectionTransVO", formBean);

			if (formBean.getStrOnlineClientDetails() != null) {
				String strClientTemp[] = formBean.getStrOnlineClientDetails()
						.replace("^", "#").split("#");

				voObj.setStrClientName(strClientTemp[0]);
				voObj.setStrClientType(strClientTemp[1]);
				voObj.setStrSancAmount(strClientTemp[2]);
				voObj.setStrClientBalance(strClientTemp[3]);
				voObj.setStrClientApprovalNo(strClientTemp[4]);
			}

			bo.insertOnlineRefundServices(voObj);

			formBean.setStrBillNo(voObj.getStrBillNo());
			formBean.setStrRefundReceiptNo(voObj.getStrRefundReceiptNo());
			formBean.setStrCrNo("");

			if (!voObj.getStrMsgType().equals("1")) {

				if (formBean.getStrChargeTypeId().equals("2")) {

					PrintHLP.IPD_REFUND(formBean.getStrBillNo(), formBean
							.getStrRefundReceiptNo(), formBean
							.getStrAccountNo(),
							formBean.getStrBillingService(), formBean
									.getStrHospitalCode() , request , 0);

				} else {

					PrintHLP.OPD_REFUND(formBean.getStrBillNo(), formBean
							.getStrRefundReceiptNo(), formBean
							.getStrBillingService(), formBean
							.getStrHospitalCode() , request , 0, null);

				}

				formBean.setStrNormalMsg("Receipt No. '"
						+ formBean.getStrBillNo()
						+ "/"
						+ formBean.getStrRefundReceiptNo()
						+ "' Generated Successfully for the Amount <img src='/AHIMS/hisglobal/images/INR.png'> '"
						+ HisUtil.getAmountWithDecimal(formBean
								.getStrOnlineTotalRecAmount(), 2) + "'");

				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo(formBean.getStrRefundReceiptNo());

				fRes = true;
			} else {

				String err = voObj.getStrMsgString();
				fRes = false;

				throw new Exception(err);

			}

		} catch (Exception e) {

			HisException eObj = new HisException("Billing Transaction",
					"CashCollectionTransDATA.insertOnlineRefundServices()-->",
					e.getMessage());

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
	 * Insert online refund advance details.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return true, if successful
	 */
	public static boolean insertOnlineRefundAdvance(
			CashCollectionTransFB formBean  , HttpServletRequest request) {

		boolean fRes = false;

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;

		try {

			bo = new CashCollectionTransBO();

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

			voObj = (CashCollectionTransVO) TransferObjectFactory.populateData(
					"billing.transactions.CashCollectionTransVO", formBean);

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
						+ "' Generated Successfully for the Amount <img src='/AHIMS/hisglobal/images/INR.png'> '"
						+ HisUtil.getAmountWithDecimal(formBean
								.getStrOnlineTotalRecAmount(), 2) + "'");

				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo(formBean.getStrRefundReceiptNo());

				fRes = true;
			} else {

				String err = voObj.getStrMsgString();
				fRes = false;

				throw new Exception(err);

			}

		} catch (Exception e) {

			HisException eObj = new HisException("Billing Transaction",
					"CashCollectionTransDATA.insertOnlineRefundAdvance()-->", e
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
	public static boolean insertOnlineFinalAdjustment(
			CashCollectionTransFB formBean  , HttpServletRequest request) {

		boolean fRes = false;

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;

		try {

			bo = new CashCollectionTransBO();

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

			voObj = (CashCollectionTransVO) TransferObjectFactory.populateData(
					"billing.transactions.CashCollectionTransVO", formBean);

			String strBillTrfDtls = formBean.getStrRequestBillTariffDetails();

			String tempTrfDtls[] = strBillTrfDtls.replace("^", "#").split("#");

			voObj.setStrApprovalId(tempTrfDtls[0]);
			voObj.setStrDiscountUnit(tempTrfDtls[1]);
			voObj.setStrDiscountType(tempTrfDtls[2]);
			voObj.setStrServiceTax(tempTrfDtls[3]);

			if (formBean.getStrOnlineClientDetails() != null) {
				String strClientTemp[] = formBean.getStrOnlineClientDetails()
						.replace("^", "#").split("#");

				voObj.setStrClientName(strClientTemp[0]);
				voObj.setStrClientType(strClientTemp[1]);
				voObj.setStrSancAmount(strClientTemp[2]);
				voObj.setStrClientBalance(strClientTemp[3]);
				voObj.setStrClientApprovalNo(strClientTemp[4]);
			}

			bo.insertOnlineFinalAdjustment(voObj);

			formBean.setStrBillNo(voObj.getStrBillNo());
			formBean.setStrReceiptNo("1");
			formBean.setStrCrNo("");

			if (!voObj.getStrMsgType().equals("1")) {

				PrintHLP.FINAL_ADJUSTMENT(formBean.getStrBillNo(), formBean
						.getStrBillingService(), formBean.getStrAccountNo(),
						formBean.getStrHospitalCode(), formBean
								.getStrBillType(), formBean.getStrReceiptNo() , request , 0, strBillTrfDtls);

				formBean.setStrNormalMsg("Receipt No. '"
						+ formBean.getStrBillNo()
						+ "/1"
						+ "' Generated Successfully for the Amount <img src='/AHIMS/hisglobal/images/INR.png'> '"
						+ HisUtil.getAmountWithDecimal(formBean
								.getStrOnlineTotalRecAmount(), 2) + "'");

				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo("1");

				fRes = true;
			} else {

				String err = voObj.getStrMsgString();
				fRes = false;

				throw new Exception(err);

			}

		} catch (Exception e) {

			HisException eObj = new HisException("Billing Transaction",
					"CashCollectionTransDATA.insertOnlineFinalAdjustment()-->",
					e.getMessage());

			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

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
			CashCollectionTransFB formBean  , HttpServletRequest request) {

		boolean fRes = false;

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;

		try {

			bo = new CashCollectionTransBO();

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

			voObj = (CashCollectionTransVO) TransferObjectFactory.populateData(
					"billing.transactions.CashCollectionTransVO", formBean);

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
						+ "' Generated Successfully for the Amount <img src='/AHIMS/hisglobal/images/INR.png'> '"
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
					"CashCollectionTransDATA.insertOnlineFinalAdjustment()-->",
					e.getMessage());

			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		}

		return fRes;
	}

	/**
	 * Inserts Off-line Receipt Part Payment Details.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return true, if insert off-line receipt part payment
	 */
	public static boolean insertOfflineReceiptPartPayment(
			CashCollectionTransFB formBean  , HttpServletRequest request){

		boolean fRes = false;

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;

		try {

			bo = new CashCollectionTransBO();

			formBean.setStrOffLineClientPatientNo(formBean
					.getStrOffLineClientDetailsHidden().replace("^", "#")
					.split("#")[0]);
			formBean
					.setStrOffLineAdmissionNo(formBean
							.getStrAdmissionDtlHidVal().replace("^", "#")
							.split("#")[0]);

			String[] strWardDtls = formBean.getStrOffLineWard().replace("^",
					"#").split("#");

			formBean.setStrOffLineWard(strWardDtls[0]);
			formBean.setStrOffLineIpdChargeTypeId(strWardDtls[1]);

			formBean.setStrOffLineEpisode(formBean.getStrOffLineEpisode()
					.replace("^", "#").split("#")[0]);

			formBean.setStrOffLinePartPaymentAmount(formBean
					.getStrPartpayment());

			formBean.setStrOffLineApprovedBy(formBean.getStrApprovedByCombo());
			formBean.setStrOffLineRemarks(formBean.getStrRemarksCombo2());

			voObj = (CashCollectionTransVO) TransferObjectFactory.populateData(
					"billing.transactions.CashCollectionTransVO", formBean);

			bo.insertOfflineReceiptPartPayment(voObj);

			formBean.setStrBillNo(voObj.getStrBillNo());
			formBean.setStrReceiptNo("1");
			formBean.setStrCrNo("");

			if (!voObj.getStrMsgType().equals("1")) {

				PrintHLP.PART_PAYMENT(formBean.getStrBillNo(), formBean
						.getStrOffLineBillingService(), formBean
						.getStrHospitalCode(), formBean.getStrReceiptNo() , request , 0, null);

				formBean.setStrNormalMsg("Receipt No. '"
						+ formBean.getStrBillNo()
						+ "/1"
						+ "' Generated Successfully for the Amount <img src='/AHIMS/hisglobal/images/INR.png'> '"
						+ HisUtil.getAmountWithDecimal(formBean
								.getStrOfflineTotalRecAmount(), 2) + "'");

				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo("1");

				fRes = true;
			} else {

				String err = voObj.getStrMsgString();
				fRes = false;

				throw new Exception(err);

			}

		} catch (Exception e) {

			HisException eObj = new HisException(
					"Billing Transaction",
					"CashCollectionTransDATA.insertOfflineReceiptPartPayment()-->",
					e.getMessage());

			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

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
	public static boolean insertOfflineReceiptAdvance(
			CashCollectionTransFB formBean  , HttpServletRequest request) {

		boolean fRes = false;

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;

		try {

			bo = new CashCollectionTransBO();

			formBean.setStrOffLineClientPatientNo(formBean
					.getStrOffLineClientDetailsHidden().replace("^", "#")
					.split("#")[0]);
			formBean
					.setStrOffLineAdmissionNo(formBean
							.getStrAdmissionDtlHidVal().replace("^", "#")
							.split("#")[0]);

			String[] strWardDtls = formBean.getStrOffLineWard().replace("^",
					"#").split("#");

			formBean.setStrOffLineWard(strWardDtls[0]);
			formBean.setStrOffLineIpdChargeTypeId(strWardDtls[1]);

			formBean.setStrOffLineEpisode(formBean.getStrOffLineEpisode()
					.replace("^", "#").split("#")[0]);

			formBean.setStrOffLineAdvanceAmount(formBean.getStrPartpayment());

			formBean.setStrOffLineApprovedBy(formBean.getStrApprovedByCombo());
			formBean.setStrOffLineRemarks(formBean.getStrRemarksCombo2());

			voObj = (CashCollectionTransVO) TransferObjectFactory.populateData(
					"billing.transactions.CashCollectionTransVO", formBean);

			bo.insertOfflineReceiptAdvance(voObj);

			formBean.setStrBillNo(voObj.getStrBillNo());
			formBean.setStrReceiptNo("1");
			formBean.setStrCrNo("");

			if (!voObj.getStrMsgType().equals("1")) {

				PrintHLP.ADVANCE(formBean.getStrBillNo(), formBean
						.getStrOffLineBillingService(), formBean
						.getStrHospitalCode(), formBean.getStrReceiptNo() , request , 0, null, null);

				formBean.setStrNormalMsg("Receipt No. '"
						+ formBean.getStrBillNo()
						+ "/1"
						+ "' Generated Successfully for the Amount <img src='/AHIMS/hisglobal/images/INR.png'> '"
						+ HisUtil.getAmountWithDecimal(formBean
								.getStrOfflineTotalRecAmount(), 2) + "'");

				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo("1");

				fRes = true;

			} else {

				String err = voObj.getStrMsgString();

				fRes = false;

				throw new Exception(err);

			}

		} catch (Exception e) {

			String err = e.getMessage();

			HisException eObj = new HisException("Billing Transaction",
					"CashCollectionTransDATA.insertOfflineReceiptAdvance()-->",
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
	 * Inserts Off-line Receipt Services Details.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return true, if insert off-line receipt service
	 */
	public static boolean insertOfflineReceiptService(
			CashCollectionTransFB formBean  , HttpServletRequest request) {

		boolean fRes = false;

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;

		String[] strDirectTariffList = null;
		
		try {
			bo = new CashCollectionTransBO();

			formBean.setStrOffLineClientPatientNo(formBean
					.getStrOffLineClientDetailsHidden().replace("^", "#")
					.split("#")[0]);
			formBean
					.setStrOffLineAdmissionNo(formBean
							.getStrAdmissionDtlHidVal().replace("^", "#")
							.split("#")[0]);

			String[] strWardDtls = formBean.getStrOffLineWard().replace("^",
					"#").split("#");

			formBean.setStrOffLineWard(strWardDtls[0]);
			formBean.setStrOffLineIpdChargeTypeId(strWardDtls[1]);

			formBean.setStrOffLineEpisode(formBean.getStrOffLineEpisode()
					.replace("^", "#").split("#")[0]);

			voObj = (CashCollectionTransVO) TransferObjectFactory.populateData(
					"billing.transactions.CashCollectionTransVO", formBean);

			bo.insertOfflineReceiptService(voObj);

		
		
		 if(formBean.getStrOfflineTariffDetailsHidden() != null){
		
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
			 
			 
		 }
		 
		 
			formBean.setStrBillNo(voObj.getStrBillNo());
			formBean.setStrReceiptNo("1");
			formBean.setStrCrNo("");

			if (!voObj.getStrMsgType().equals("1")) {

				if (formBean.getStrOffLineHospitalService().equals("2")) {

				 					
					/*PrintHLP.IPD_SERVICES(formBean.getStrBillNo(), formBean
							.getStrOffLineAccountNo(), formBean
							.getStrOffLineBillingService(), formBean
							.getStrHospitalCode(), formBean.getStrReceiptNo() , request , strDirectTariffList , "1" , 0);*/
					
					PrintHLP.IPD_SERVICES(formBean.getStrBillNo(), formBean
							.getStrOffLineAccountNo(), formBean
							.getStrOffLineBillingService(), formBean
							.getStrHospitalCode(), formBean.getStrReceiptNo() , request , null , "1" , 0, null, null);

				} else {
					
					 
					/*PrintHLP.OPD_SERVICES(formBean.getStrBillNo(), formBean
							.getStrOffLineBillingService(), formBean
							.getStrHospitalCode(), formBean.getStrReceiptNo() , request , strDirectTariffList , "1" , 0);*/
					
					PrintHLP.OPD_SERVICES(formBean.getStrBillNo(), formBean
							.getStrOffLineBillingService(), formBean
							.getStrHospitalCode(), formBean.getStrReceiptNo() , request , null , "1" , 0, null, null);

				}

				formBean.setStrNormalMsg("Receipt No. '"
						+ formBean.getStrBillNo()
						+ "/1"
						+ "' Generated Successfully for the Amount <img src='/AHIMS/hisglobal/images/INR.png'> '"
						+ HisUtil.getAmountWithDecimal(formBean
								.getStrOfflineTotalRecAmount(), 2) + "'");

				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo("1");

				fRes = true;
			} else {

				fRes = false;

				throw new Exception(voObj.getStrMsgString());

			}
		} catch (Exception e) {

			String err = e.getMessage();

			HisException eObj = new HisException("Billing Transaction",
					"CashCollectionTransDATA.insertOfflineReceiptService()-->",
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
	 * Inserts Off-line Refund Services Details.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return true, if insert off-line refund service
	 */
	public static boolean insertOfflineRefundService(
			CashCollectionTransFB formBean  , HttpServletRequest request){

		boolean fRes = false;

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;

		try {
			bo = new CashCollectionTransBO();

			formBean.setStrOffLineClientPatientNo(formBean
					.getStrOffLineClientDetailsHidden().replace("^", "#")
					.split("#")[0]);
			formBean
					.setStrOffLineAdmissionNo(formBean
							.getStrAdmissionDtlHidVal().replace("^", "#")
							.split("#")[0]);

			String[] strWardDtls = formBean.getStrOffLineWard().replace("^",
					"#").split("#");

			formBean.setStrOffLineWard(strWardDtls[0]);
			formBean.setStrOffLineIpdChargeTypeId(strWardDtls[1]);

			formBean.setStrOffLineEpisode(formBean.getStrOffLineEpisode()
					.replace("^", "#").split("#")[0]);

			voObj = (CashCollectionTransVO) TransferObjectFactory.populateData(
					"billing.transactions.CashCollectionTransVO", formBean);

			bo.insertOfflineRefundService(voObj);

			formBean.setStrBillNo(voObj.getStrBillNo());
			formBean.setStrRefundReceiptNo(voObj.getStrRefundReceiptNo());

			formBean.setStrCrNo("");

			if (!voObj.getStrMsgType().equals("1")) {

				if (formBean.getStrOffLineHospitalService().equals("2")) {

					PrintHLP.IPD_REFUND(formBean.getStrBillNo(), formBean
							.getStrRefundReceiptNo(), formBean
							.getStrOffLineAccountNo(), formBean
							.getStrOffLineBillingService(), formBean
							.getStrHospitalCode() , request , 0);

				} else {

					PrintHLP.OPD_REFUND(formBean.getStrBillNo(), formBean
							.getStrRefundReceiptNo(), formBean
							.getStrOffLineBillingService(), formBean
							.getStrHospitalCode() , request , 0, null);

				}

				formBean.setStrNormalMsg("Receipt No. '"
						+ formBean.getStrBillNo()
						+ "/"
						+ formBean.getStrRefundReceiptNo()
						+ "' Generated Successfully for the Amount <img src='/AHIMS/hisglobal/images/INR.png'> '"
						+ HisUtil.getAmountWithDecimal(formBean
								.getStrOfflineTotalRecAmount(), 2) + "'");

				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo(formBean.getStrRefundReceiptNo());

				fRes = true;
			} else {

				fRes = false;

				throw new Exception(voObj.getStrMsgString());

			}
		} catch (Exception e) {

			String err = e.getMessage();

			HisException eObj = new HisException("Billing Transaction",
					"CashCollectionTransDATA.insertOfflineRefundService()-->",
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
	 * Inserts Off-line Refund Admission Cancellation Details.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return true, if insert off-line refund admission cancellation
	 */
	public static boolean insertOfflineRefundAdmissionCancellation(
			CashCollectionTransFB formBean  , HttpServletRequest request){

		boolean fRes = false;

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;

		try {
			bo = new CashCollectionTransBO();

			formBean.setStrOffLineClientPatientNo(formBean
					.getStrOffLineClientDetailsHidden().replace("^", "#")
					.split("#")[0]);
			formBean
					.setStrOffLineAdmissionNo(formBean
							.getStrAdmissionDtlHidVal().replace("^", "#")
							.split("#")[0]);

			String[] strWardDtls = formBean.getStrOffLineWard().replace("^",
					"#").split("#");

			formBean.setStrOffLineWard(strWardDtls[0]);
			formBean.setStrOffLineIpdChargeTypeId(strWardDtls[1]);

			formBean.setStrOffLineEpisode(formBean.getStrOffLineEpisode()
					.replace("^", "#").split("#")[0]);

			voObj = (CashCollectionTransVO) TransferObjectFactory.populateData(
					"billing.transactions.CashCollectionTransVO", formBean);

			bo.insertOfflineRefundAdmissionCancellation(voObj);

			formBean.setStrBillNo(voObj.getStrBillNo());
			formBean.setStrRefundReceiptNo(voObj.getStrRefundReceiptNo());

			formBean.setStrCrNo("");

			if (!voObj.getStrMsgType().equals("1")) {

				PrintHLP.ADVANCE_REFUND(formBean.getStrBillNo(), formBean
						.getStrRefundReceiptNo(), formBean
						.getStrOffLineBillingService(), formBean
						.getStrHospitalCode() , request , 0);

				formBean.setStrNormalMsg("Receipt No. '"
						+ formBean.getStrBillNo()
						+ "/"
						+ formBean.getStrRefundReceiptNo()
						+ "' Generated Successfully for the Amount <img src='/AHIMS/hisglobal/images/INR.png'> '"
						+ HisUtil.getAmountWithDecimal(formBean
								.getStrOfflineTotalRecAmount(), 2) + "'");

				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo(formBean.getStrRefundReceiptNo());

				fRes = true;
			} else {

				fRes = false;

				throw new Exception(voObj.getStrMsgString());

			}
		} catch (Exception e) {

			String err = e.getMessage();

			HisException eObj = new HisException(
					"Billing Transaction",
					"CashCollectionTransDATA.insertOfflineRefundAdmissionCancellation()-->",
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
	 * Insert's Without CR. No. Receipt Services.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return true, if insert without CR No. receipt services
	 */
	public static boolean insertWithoutCrNoReceiptServices(
			CashCollectionTransFB formBean  , HttpServletRequest request) {

		boolean fRes = false;

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;
		String[] strDirectTariffList = null;
		
		try {
			bo = new CashCollectionTransBO();
			voObj = (CashCollectionTransVO) TransferObjectFactory.populateData(
					"billing.transactions.CashCollectionTransVO", formBean);

			if(voObj.getStrPreviousCrNo().length() <= 0)
				voObj.setStrPreviousCrNo("0");
			
			bo.insertWithoutCrNoReceiptServices(voObj);

			formBean.setStrBillNo(voObj.getStrBillNo());
			formBean.setStrReceiptNo("1");
			formBean.setStrCrNo("");

			
			 if(formBean.getStrOfflineTariffDetailsHidden() != null){
					
				  strDirectTariffList = new String[formBean.getStrOfflineTariffDetailsHidden().length];
				 
				 
				 for (int i = 0 , stopI = formBean.getStrOfflineTariffDetailsHidden().length ; i < stopI; i++) {
					
					 String strTemp[] = formBean.getStrOfflineTariffDetailsHidden()[i].replace("^", "#").split("#");
					 
					 strDirectTariffList[i] = formBean.getStrOfflineTariffName()[i]+"@"+
					 						  strTemp[4]+"/"+strTemp[14]+"^"+
					 						  formBean.getStrOfflineTariffQty()[i]+" "+strTemp[14]+"^"+
					 						  formBean.getStrOfflineTariffDiscount()[i]+"^"+
					 						  formBean.getStrOfflineTariffServiceTax()[i]+"^"+
					 						  formBean.getStrOfflineTariffNetAmount()[i];
					 
				}
				 
				 
			 }
			 
			
			if (!voObj.getStrMsgType().equals("1")) {

				 				
				/* PrintHLP.OPD_SERVICES(formBean.getStrBillNo(), formBean
						.getStrOffLineBillingService(), formBean
						.getStrHospitalCode(), formBean.getStrReceiptNo() , request , strDirectTariffList , "1" , 0);*/
				
				PrintHLP.OPD_SERVICES(formBean.getStrBillNo(), formBean
						.getStrOffLineBillingService(), formBean
						.getStrHospitalCode(), formBean.getStrReceiptNo() , request , null , "1" , 0, null, null);

				formBean.setStrNormalMsg("Receipt No. '"
						+ formBean.getStrBillNo()
						+ "/1"
						+ "' Generated Successfully for the Amount <img src='/AHIMS/hisglobal/images/INR.png'> '"
						+ HisUtil.getAmountWithDecimal(formBean
								.getStrOfflineTotalRecAmount(), 2) + "'");

				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo("1");

				fRes = true;
			} else {
				
				fRes = false;

				throw new Exception(voObj.getStrMsgString());

			}
		} catch (Exception e) {

			String err = e.getMessage();

			HisException eObj = new HisException(
					"Billing Transaction",
					"CashCollectionTransDATA.insertWithoutCrNoReceiptServices()-->",
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
	 * Insert's Without CR. No. Refund Services.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return true, if insert without CR No. refund services
	 */
	public static boolean insertWithoutCrNoRefundServices(
			CashCollectionTransFB formBean  , HttpServletRequest request) {

		boolean fRes = false;

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;

		try {
			bo = new CashCollectionTransBO();
			voObj = (CashCollectionTransVO) TransferObjectFactory.populateData(
					"billing.transactions.CashCollectionTransVO", formBean);

			bo.insertWithoutCrNoRefundServices(voObj);

			formBean.setStrCrNo("");
			formBean.setStrBillNo(voObj.getStrBillNo());
			formBean.setStrRefundReceiptNo(voObj.getStrRefundReceiptNo());

			if (!voObj.getStrMsgType().equals("1")) {

				PrintHLP.OPD_REFUND(formBean.getStrBillNo(), formBean
						.getStrRefundReceiptNo(), formBean
						.getStrOffLineBillingService(), formBean
						.getStrHospitalCode() , request , 0, null);

				formBean.setStrNormalMsg("Bill '"
						+ formBean.getStrBillNo()
						+ "/"
						+ formBean.getStrRefundReceiptNo()
						+ "' Generated Successfully for the Amount '"
						+ HisUtil.getAmountWithDecimal(formBean
								.getStrOfflineTotalRecAmount(), 2) + "'");

				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo(formBean.getStrRefundReceiptNo());

				fRes = true;
			} else {

				fRes = false;

				throw new Exception(voObj.getStrMsgString());

			}
		} catch (Exception e) {

			String err = e.getMessage();

			HisException eObj = new HisException(
					"Billing Transaction",
					"CashCollectionTransDATA.insertWithoutCrNoRefundServices()-->",
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

	public static boolean insertOnlineWithoutCrNoReceiptServices(
			CashCollectionTransFB formBean  , HttpServletRequest request){

		boolean fRes = false;

		CashCollectionTransBO bo = null;
		CashCollectionTransVO voObj = null;

		try {

			String strReqDtls[] = formBean.getStrWithoutCrNoOnlineRequestNo()
					.replace("^", "#").split("#");

			formBean.setStrRequestNo(strReqDtls[0]);

			formBean.setStrGuarantorName(strReqDtls[4]);
			formBean.setStrGuartorAddress(strReqDtls[5]);
			formBean.setStrGuarantorContactNo(strReqDtls[6]);

			formBean.setStrOffLineBillingService(strReqDtls[8]);
			formBean.setStrOffLineRaisingDepartment(strReqDtls[9]);
			formBean.setStrService(strReqDtls[10]);
			formBean.setStrGlobalRequestNo(strReqDtls[11]);
			formBean.setStrRequestDate(strReqDtls[13]);
			formBean.setStrAge(strReqDtls[14]);
			formBean.setStrAgeUnit(strReqDtls[15]);
			formBean.setStrReferringPhysician(strReqDtls[16]);
			formBean.setStrGender(strReqDtls[17]);
			formBean.setStrReferringPhysicianContactNo(strReqDtls[18]);
			
			formBean.setStrOfflineTariffDiscountConfigDetails(formBean
					.getStrTariffDiscountConfigDetails());

			bo = new CashCollectionTransBO();
			voObj = (CashCollectionTransVO) TransferObjectFactory.populateData(
					"billing.transactions.CashCollectionTransVO", formBean);

			bo.insertOnlineWithoutCrNoReceiptServices(voObj);

			formBean.setStrBillNo(voObj.getStrBillNo());
			formBean.setStrReceiptNo("1");

			formBean.setStrCrNo("");

			if (!voObj.getStrMsgType().equals("1")) {

				PrintHLP.OPD_SERVICES(formBean.getStrBillNo(), formBean
						.getStrOffLineBillingService(), formBean
						.getStrHospitalCode(), formBean.getStrReceiptNo() , request ,null, "0" , 0, null, null);

				formBean.setStrNormalMsg("Receipt No. '"
						+ formBean.getStrBillNo()
						+ "/1"
						+ "' Generated Successfully for the Amount <img src='/AHIMS/hisglobal/images/INR.png'> '"
						+ HisUtil.getAmountWithDecimal(formBean
								.getStrOfflineTotalRecAmount(), 2) + "'");

				formBean.setStrTempBillNo(formBean.getStrBillNo());
				formBean.setStrTempReceiptNo("1");

				fRes = true;
			} else {

				fRes = false;

				throw new Exception(voObj.getStrMsgString());

			}
		} catch (Exception e) {

			String err = e.getMessage();

			HisException eObj = new HisException(
					"Billing Transaction",
					"CashCollectionTransDATA.insertWithoutCrNoReceiptServices()-->",
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

}
