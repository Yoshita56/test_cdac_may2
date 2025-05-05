package billing;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import billing.BillConfigUtil;

public class CashCollectionTransCNT extends DispatchAction {

	/**
	 * forwards control to the Page cashcollection_billtrans.jsp
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward object with target
	 * @throws HisException
	 */
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		CashCollectionTransFB formBean = (CashCollectionTransFB) form;
		
		CashCollectionTransDATA.checkCounterStatus(request, formBean);
		
		return this.WITHCRNO(mapping, form, request, response);
	
	}

	/**
	 * invokes ONLINEMODE method, forwards to Cash Collection Without Cr. No. Online Mode
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	public ActionForward WITHCRNO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		String strCounterMode = "0";
		
		if(request.getParameter("counterMode") != null){
			
			 strCounterMode = request.getParameter("counterMode");
			 			 
			
		}else{
			
			CashCollectionTransFB formBean = (CashCollectionTransFB) form;
			
			 strCounterMode = formBean.getStrCounterMode();
						 
		}
		
		
		
		if(strCounterMode.equals("0") ){
			
			return ONLINEMODE(mapping, form, request, response);
			
		}else if(strCounterMode.equals("1")){
			
			
			
			return this.OFFLINEMODE(mapping, form, request, response);
			
		}
		
		return ONLINEMODE(mapping, form, request, response);
	}
	
	
	/**
	 * forwards Cash Collection page in Online Mode.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	public ActionForward ONLINEMODE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		String target = "cashcollection";

		String strCounterMode = "0";
		
		if(request.getParameter("counterMode") != null){
			
			 strCounterMode = request.getParameter("counterMode");
			 			 
			
		}else{
			
			CashCollectionTransFB formBean = (CashCollectionTransFB) form;
			
			 strCounterMode = formBean.getStrCounterMode();
						 
		}
		
		CashCollectionTransFB formBean = (CashCollectionTransFB) form;
		formBean.setStrIsOnline("1");
		formBean.setCurrentState("1");
		
		formBean.setStrIsWithoutCrNoRequired(new BillConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString()).getGeneralIsWithoutCrNoRequired());
		formBean.setStrConfirmationType(new BillConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString()).getGeneralCashCollectionConfrimType());
		
		formBean.setStrCounterMode(strCounterMode);
		
		return mapping.findForward(target);
	}
	
	/**
	 * forwards Cash Collection in Off line Mode
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	public ActionForward OFFLINEMODE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		String target = "cashcollection";

		String strCounterMode = "0";
		
		if(request.getParameter("counterMode") != null){
			
			 strCounterMode = request.getParameter("counterMode");
			 			 
			
		}else{
			
			CashCollectionTransFB formBean = (CashCollectionTransFB) form;
			
			 strCounterMode = formBean.getStrCounterMode();
						 
		}
		
		CashCollectionTransFB formBean = (CashCollectionTransFB) form;
		formBean.setStrIsOnline("0");
		formBean.setCurrentState("2");
		
		formBean.setStrIsWithoutCrNoRequired(new BillConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString()).getGeneralIsWithoutCrNoRequired());
		formBean.setStrConfirmationType(new BillConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString()).getGeneralCashCollectionConfrimType());
		
		formBean.setStrCounterMode(strCounterMode);
		
		return mapping.findForward(target);
	}

	/**
	 * forwards Cash Collection to Without Cr. No. Mode
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	public ActionForward WITHOUTCRNO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		String target = "cashcollectionwithoutcrno";

		CashCollectionTransFB formBean = (CashCollectionTransFB) form;
		 
		CashCollectionTransDATA.initWithoutCrNo(request, formBean);


		formBean.setStrIsWithoutCrNoRequired(new BillConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString()).getGeneralIsWithoutCrNoRequired());
		
		if(formBean.getStrIsWithoutCrNoRequired().equals("0")){
			formBean.setStrPreviousCrNoSearch("0");
		}else{
			formBean.setStrPreviousCrNoSearch(new BillConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString()).getGeneralPreviousCrNoSearchingInt());
			formBean.setStrPreviousCrNoSearch(new BillConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString()).getGeneralPreviousCrNoSearchingExt());
		}
		
		return mapping.findForward(target);
	}

	/**
	 * forwards control to the Cash Collection Page by initializing all the
	 * required information for given Cr. Number.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward object with target
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward GO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		String strTarget = "cashcollection";

		CashCollectionTransFB formBean = (CashCollectionTransFB) form;

		boolean bResult = CashCollectionTransDATA.init(request, formBean);

		if (bResult) {
			return mapping.findForward(strTarget);
		} else {
			
			if(formBean.getCurrentState().equals("1")){
				return this.ONLINEMODE(mapping, formBean, request, response);
			}else{
				return this.OFFLINEMODE(mapping, formBean, request, response);
			}
			
		}
	}

	/**
	 * forwards control to the Cash Collection Page with Cancel Mode
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward object with target
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		return this.WITHCRNO(mapping, form, request, response);
	}

	/**
	 * function invoked by Ajax, gives the required Previous Cr No.Details when Cr number is entered.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward PREVIOUSCRNODTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		CashCollectionTransFB formBean = (CashCollectionTransFB) form;
		
		CashCollectionTransDATA.getPreviousCrNoDtls(request, response, formBean);

		return null;

	}
	
	/**
	 * function invoked by Ajax, gives the required online information when a
	 * request number is selected.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward ONLINEDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		CashCollectionTransDATA.getOnlineDtls(request, response);

		return null;

	}

	
	
	/**
	 * function invoked by Ajax, gives the required online thirdpary amount details information when a
	 * request number is selected.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	/*public ActionForward ONLINETHIRDPARTYAMTDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		CashCollectionTransDATA.getOnlineThirdPartyAmtView(request, response);

		return null;

	}*/
	
	/**
	 * function invoked by Ajax, gives the required online third party amount details information 
	 * when cr No entered in Without Cr. No. Mode.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	/*public ActionForward OFFLINETHIRDPARTYAMTDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		CashCollectionTransDATA.getOfflineThirdPartyAmtView(request, response);

		return null;

	}*/
	
	/**
	 * function invoked by Ajax, populates the billing Service Combo box based
	 * on Request Type & Hospital Service.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward BILLDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		CashCollectionTransDATA.getBillServiceDetails(request, response);

		return null;

	}

	/**
	 * function invoked by Ajax, populates the Episode Combo box based on
	 * Raising Department and Cr Number.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward EPISODEDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		CashCollectionTransDATA.getEpisodeDetails(request, response);

		return null;

	}

	/**
	 * function invoked by Ajax, gives the Part Payment or Advance amount
	 * Details based on Hospital Service, Request Type, Bill Service, Treatment
	 * Category and Ward Code.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward PARTACCAMT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		CashCollectionTransDATA.getPartPaymentOrAccountDtls(request, response);

		return null;

	}

	/**
	 * function invoked by Ajax, gives the required off-line client information
	 * based on Hospital Service and Cr Number.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward OFFLINECLTDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		CashCollectionTransDATA.getClientDetails(request, response);

		return null;

	}

	/**
	 * function invoked by Ajax, populates the Group Combo box based on Hospital
	 * Service and with or without Pack Flag.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward GROUPDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		CashCollectionTransDATA.getGroupDetails(request, response);

		return null;

	}

	/**
	 * function invoked by Ajax, populates the Tariff List based on Selected
	 * Group Code.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward TARIFFDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		CashCollectionTransDATA.getTariffDetails(request, response);

		return null;

	}
	
	/**
	 * function invoked by Ajax, populates the Tariff Details based on Tariff Code.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward TARIFFCODEDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		CashCollectionTransDATA.getTariffCodeDetails(request, response);

		return null;

	}
	

	/**
	 * function invoked by Ajax, populates the Group Details based on Hospital
	 * Service and with or without Package Flag.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward PKGGROUPDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		CashCollectionTransDATA.getGroupDetails(request, response);

		return null;

	}

	/**
	 * function invoked by Ajax, populates the Package Details based on row
	 * Index.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward PKGDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		CashCollectionTransDATA.getPackageDetails(request, response);

		return null;

	}

	/**
	 * function invoked by Ajax, gets Tariff Unit Details for Off line Mode
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward TRFUNIT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		CashCollectionTransDATA.getOffLineTariffUnitDetails(request, response);

		return null;

	}
/**
 * function invoked by Ajax, gets Refund bill details for Off line Mode
 * @param mapping
 * @param form
 * @param request
 * @param response
 * @return
 * @throws HisException
 * @throws SQLException
 */
	public ActionForward REFUNDBILLDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		CashCollectionTransDATA.getOffLineRefundBillDetails(request, response);

		return null;

	}

	/**
	 * function invoked by Ajax, gets Refund Bill Tariff Details for Off line Refund details
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward REFUNDBILLTARIFFDTLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		CashCollectionTransDATA.getOffLineRefundBillTariffDetails(request,
				response);

		return null;

	}

	/**
	 * function invoked by Ajax, gets Refund Bill Tariff Pop-up details for Off line Mode
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward REFUNDBILLTARIFFPOPUPDTLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		CashCollectionTransDATA.getOffLineRefundBillTariffPopupDetails(request,
				response);

		return null;

	}

	/**
	 * function invoked by Ajax, gets Unit details for Off line Mode
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward UNITVAL12(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CashCollectionTransDATA.UNITVAL12(request, response);

		return null;
	}

	/**
	 * function invoked by Ajax, gets Refund Bill Tariff Pop-up details for On line Mode
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward REFUNDTARIFFPOPUPDTLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		CashCollectionTransDATA.getOnLineRefundTariffPopupDetails(request,
				response);

		return null;

	}

	/**
	 * function invoked by Ajax, gets Without Cr. No. Bill Details 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward GOBILL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		CashCollectionTransDATA.initWithoutCrNoBillDetails(request, response);

		return null;

	}

	/**
	 * opens a pop-up with bill list, used for search bills in Without Cr. No. Mode
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward BILLLISTING(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		String target = "billlist";

		CashCollectionTransFB formBean = (CashCollectionTransFB) form;

		formBean.setStrBillUsrFuncName(request.getParameter("usrFuncName"));

		return mapping.findForward(target);
	}

	/**
	 * function invoked by Ajax, gets Without Cr. No. Bill List 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward FETCHBILLLISTING(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		CashCollectionTransFB formBean = (CashCollectionTransFB) form;
		CashCollectionTransDATA.getBillListingDtls(request, response, formBean);

		return null;
	}

	/**
	 * Invokes when Bill has been Canceled  
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward BILLCANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		return this.WITHOUTCRNO(mapping, form, request, response);
	}

	/**
	 * function invoked by Ajax, Reconcile Tariff Pop-up details for Online Mode
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	/*public ActionForward RECONCILPOPUP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		CashCollectionTransDATA.getOnlineReconcilTariffPopupDetails(request,
				response);

		return null;

	}*/
/**
 * function invoked by Ajax, Admission Cancellation Details details.
 * @param mapping
 * @param form
 * @param request
 * @param response
 * @return
 * @throws HisException
 * @throws SQLException
 */
	public ActionForward ADMISSIONCANCELATION(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		CashCollectionTransDATA.getAdmissionCancellationDtls(request, response);

		return null;

	}

	
	
	public ActionForward OFFLINEDEPTDTL(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		CashCollectionTransDATA.getOfflineRaisingDetapartmentDtls(request, response);

		return null;

	}
	
	
	
	public ActionForward OFFLINETREATCATDTL(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		CashCollectionTransDATA.getOfflineTreatmentCategoryDtls(request, response);

		return null;

	}
	
	
	public ActionForward OFFLINEWARDDTL(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		CashCollectionTransDATA.getOfflineWardDtls(request, response);

		return null;

	}
	
	public ActionForward WITHOUTCRNOREQTARIFF(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		CashCollectionTransDATA.getWithoutCrNoOnlineReqTariffDtls(request, response);

		return null;

	}
	
		
	public ActionForward UPDATEPRINTSTATUS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		CashCollectionTransDATA.updatePrintStatus(request, response);

		return null;

	}
	
	
	
	
	/**
	 * method to insert the "Online Receipt Part Payment" Details  
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	public ActionForward ONRECPARTPAY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		//String target = "cashcollection";

		CashCollectionTransFB formBean = (CashCollectionTransFB) form;

		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());

		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR")
				.toString());
		
		 CashCollectionTransDATA
				.insertOnlineReceiptPartPayment(formBean , request);

		
			return this.ONLINEMODE(mapping, formBean, request, response);
		
	}

	
	public ActionForward ONRECADV(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		//String target = "cashcollection";

		CashCollectionTransFB formBean = (CashCollectionTransFB) form;

		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());

		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR")
				.toString());
		
		 CashCollectionTransDATA.insertOnlineReceiptAdvance(formBean , request);
		
			return this.ONLINEMODE(mapping, formBean, request, response);
		//}
	}
	
	/**
	 * method to insert the "Online Receipt Services" Details
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	public ActionForward ONRECSERVICE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		//String target = "cashcollection";

		CashCollectionTransFB formBean = (CashCollectionTransFB) form;

		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());

		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR")
				.toString());
		
		 CashCollectionTransDATA.insertOnlineReceiptServices(formBean , request);

			return this.ONLINEMODE(mapping, formBean, request, response);
		
	}
	
	/**
	 * method to insert the "Online Refund Services" Details
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	public ActionForward ONREFUNDSERVICE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		//String target = "cashcollection";

		CashCollectionTransFB formBean = (CashCollectionTransFB) form;

		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());

		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR")
				.toString());
		
		 CashCollectionTransDATA.insertOnlineRefundServices(formBean , request);

		
			return this.ONLINEMODE(mapping, formBean, request, response);
		
	}
	
	/**
	 * method to insert the "Online Refund Advance" Details
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	public ActionForward ONREFUNDADVANCE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		//String target = "cashcollection";

		CashCollectionTransFB formBean = (CashCollectionTransFB) form;

		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());

		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR")
				.toString());
		
	 CashCollectionTransDATA.insertOnlineRefundAdvance(formBean , request);

		
			return this.ONLINEMODE(mapping, formBean, request, response);
		
	}
	

	/**
	 * method to insert the "Online Final Adjustment" Details
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	public ActionForward ONFINALADJUST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		//String target = "cashcollection";

		CashCollectionTransFB formBean = (CashCollectionTransFB) form;

		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());

		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR")
				.toString());
		
		 CashCollectionTransDATA.insertOnlineFinalAdjustment(formBean , request);

		
			return this.ONLINEMODE(mapping, formBean, request, response);
		
	}
	
	
	/**
	 * method to insert the "Online Reconcile" Details
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	public ActionForward ONRECONCILE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		//String target = "cashcollection";

		CashCollectionTransFB formBean = (CashCollectionTransFB) form;

		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());

		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR")
				.toString());
		
		 CashCollectionTransDATA.insertOnlineReconciliation(formBean , request);

		
			return this.ONLINEMODE(mapping, formBean, request, response);
		
	}
	
	
	
	/**
	 * inserts "Off-line Receipt Part Payment" Details
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	public ActionForward OFFRECPARTPAY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		//String target = "cashcollection";

		CashCollectionTransFB formBean = (CashCollectionTransFB) form;

		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());

		
		
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		
		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR")
				.toString());

		if(request.getSession().getAttribute("USER_LEVEL") != null){
			
			formBean.setStrUserLevel(request.getSession().getAttribute("USER_LEVEL")
					.toString());
			
		}else{
			formBean.setStrUserLevel("1");
		}
		
		
		
		 CashCollectionTransDATA
				.insertOfflineReceiptPartPayment(formBean , request);

		
			return this.OFFLINEMODE(mapping, formBean, request, response);
		
	}
	
	
	/**
	 * inserts "Off-line Receipt Advance Amount" Details
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	public ActionForward OFFRECADV(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		//String target = "cashcollection";

		CashCollectionTransFB formBean = (CashCollectionTransFB) form;

		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());
		
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		
		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR")
				.toString());

	
		

		if(request.getSession().getAttribute("USER_LEVEL") != null){
			
			formBean.setStrUserLevel(request.getSession().getAttribute("USER_LEVEL")
					.toString());
			
		}else{
			formBean.setStrUserLevel("1");
		}
		
	 CashCollectionTransDATA
				.insertOfflineReceiptAdvance(formBean , request);

		
			return this.OFFLINEMODE(mapping, formBean, request, response);
		
	}
	
	/**
	 * inserts "Off-line Receipt Services" Details
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	public ActionForward OFFRECSER(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		//String target = "cashcollection";

		CashCollectionTransFB formBean = (CashCollectionTransFB) form;
		
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());
		
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		
		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR")
				.toString());


		if(request.getSession().getAttribute("USER_LEVEL") != null){
			
			formBean.setStrUserLevel(request.getSession().getAttribute("USER_LEVEL")
					.toString());
			
		}else{
			formBean.setStrUserLevel("1");
		}
		
	 CashCollectionTransDATA.insertOfflineReceiptService(formBean , request);

		
			return this.OFFLINEMODE(mapping, formBean, request, response);
		
	}
	
	/**
	 * inserts "Off-line Refund Services" Details
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	public ActionForward OFFREFUNDSER(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		//String target = "cashcollection";

		CashCollectionTransFB formBean = (CashCollectionTransFB) form;
		
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());
		
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		
		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR")
				.toString());


		if(request.getSession().getAttribute("USER_LEVEL") != null){
			
			formBean.setStrUserLevel(request.getSession().getAttribute("USER_LEVEL")
					.toString());
			
		}else{
			formBean.setStrUserLevel("1");
		}
		
	 CashCollectionTransDATA.insertOfflineRefundService(formBean , request);

		
			return this.OFFLINEMODE(mapping, formBean, request, response);
		
	}
	
	
	/**
	 * inserts "Off-line Refund Advance" Details
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	public ActionForward OFFREFUNDADMCANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		//String target = "cashcollection";

		CashCollectionTransFB formBean = (CashCollectionTransFB) form;
		
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());
		
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		
		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR")
				.toString());


		if(request.getSession().getAttribute("USER_LEVEL") != null){
			
			formBean.setStrUserLevel(request.getSession().getAttribute("USER_LEVEL")
					.toString());
			
		}else{
			formBean.setStrUserLevel("1");
		}
		
		CashCollectionTransDATA.insertOfflineRefundAdmissionCancellation(formBean , request);

		
			return this.OFFLINEMODE(mapping, formBean, request, response);
	
	}
	
	
	/**
	 * Insert's Without Cr. No. Receipt Services.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	public ActionForward WITHOUTCRNORECEIPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

	//	String target = "cashcollectionwithoutcrno";

		CashCollectionTransFB formBean = (CashCollectionTransFB) form;
		
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());
		
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		
		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR")
				.toString());


		if(request.getSession().getAttribute("USER_LEVEL") != null){
			
			formBean.setStrUserLevel(request.getSession().getAttribute("USER_LEVEL")
					.toString());
			
		}else{
			formBean.setStrUserLevel("1");
		}
		
		
		
		CashCollectionTransDATA.insertWithoutCrNoReceiptServices(formBean , request);

			return this.WITHOUTCRNO(mapping, formBean, request, response);

	}
	
	
	/**
	 * Insert's Without Cr. No. Refund Services.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	public ActionForward WITHOUTCRNOREFUND(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		CashCollectionTransFB formBean = (CashCollectionTransFB) form;
		
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());
		
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		
		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR")
				.toString());


		if(request.getSession().getAttribute("USER_LEVEL") != null){
			
			formBean.setStrUserLevel(request.getSession().getAttribute("USER_LEVEL")
					.toString());
			
		}else{
			formBean.setStrUserLevel("1");
		}
		
		
		
		CashCollectionTransDATA.insertWithoutCrNoRefundServices(formBean , request);

			return this.WITHOUTCRNO(mapping, formBean, request, response);

	}
	
	public ActionForward ONLINEWITHOUTCRNORECEIPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		CashCollectionTransFB formBean = (CashCollectionTransFB) form;
		
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());
		
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		
		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR")
				.toString());


		if(request.getSession().getAttribute("USER_LEVEL") != null){
			
			formBean.setStrUserLevel(request.getSession().getAttribute("USER_LEVEL")
					.toString());
			
		}else{
			formBean.setStrUserLevel("1");
		}
		
		CashCollectionTransDATA.insertOnlineWithoutCrNoReceiptServices(formBean , request);

			return this.WITHOUTCRNO(mapping, formBean, request, response);

	}
	

	/**This method is used to Transfer Control Over Inti Page   
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward CANCELPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

        ActionForward acFwd = new ActionForward();

          acFwd.setPath("/hisglobal/initPage.jsp");

          acFwd.setContextRelative(true);

          return acFwd;

    }

	
	
}
