package billing;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.config.HISConfig;
import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import hisglobal.vo.UserVO;

public class CashCollectionOfflineTransCNT extends CSRFGardTokenAction {

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
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws HisException {
		generateToken(request);
		CashCollectionOfflineTransFB formBean = (CashCollectionOfflineTransFB) form;
		formBean.setFilePath("");
		String strCounterId ="";
		String target = "cashcollection";
		
		//UserVO userVO=ControllerUTIL.getUserVO(request);
		
		UserVO userVO = (UserVO) request.getSession().getAttribute(HISConfig.USER_VO);
		
		System.out.println("Back Date Day End Check Flag :::value :::"+userVO.getCheckBackDateDayEndFlag());			
		
			
		if(BillConfigUtil.BACK_DATE_DAYEND_STOP_PROCESS.equals("1"))
		{		
			if(userVO.getCheckBackDateDayEndFlag().toString().equals("1"))
			{
				formBean.setStrErrMsg("Cash Collection Not Applicable, Please Perform Day End First.\n If Day End Already Performed , Please Relogin");
				return mapping.findForward(target);
			}
			else if(userVO.getCheckBackDateDayEndFlag().toString().equals("2"))
			{
				formBean.setStrErrMsg("Cash Collection Not Applicable, Please Deposit Day End Amount.\n If Already Deposited , Please Relogin");
				return mapping.findForward(target);
			}
		}
		
		BillConfigUtil bcu = new BillConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrConfirmationType(bcu.getGeneralCashCollectionConfrimType());
		//System.out.println("IP Address"+request.getSession().getAttribute("IP_ADDR").toString());
		
		String counterCheck=BillConfigUtil.CHECK_COUNTER_STATUS;
		if(counterCheck.equals("1"))//Counter Check Needed=1, Counter Check Not Needed=0
		{
			strCounterId =CashCollectionOfflineTransDATA.checkCounterStatus(request, formBean);
			if(strCounterId!=null)
			{
				if(strCounterId.equals(""))
				{
					return mapping.findForward(target);
				}
				else
				{
					if (strCounterId.trim().length() < 4)
					{
						return mapping.findForward(target);
					}
					else
					{
						return this.OFFLINEMODE(mapping, form, request, response);
					}
				}				
			}
			else
			{
				return mapping.findForward(target);
			}
		}
		else
		{
			return this.OFFLINEMODE(mapping, form, request, response);
		}
	}

	public ActionForward CHANGEMODE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		CashCollectionOfflineTransFB formBean = (CashCollectionOfflineTransFB) form;
		
		ActionForward acFwd = new ActionForward();
		acFwd
				.setPath("/billing/transactions/CashCollectionOnlineTransCNT.cnt?hmode=ONLINEMODE&counterMode="+formBean.getStrCounterMode());
		acFwd.setContextRelative(true);
		return acFwd;
	
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
	public ActionForward OFFLINEMODE(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws HisException 
	{
		generateToken(request);
		String target = "cashcollection";
		CashCollectionOfflineTransFB formBean = (CashCollectionOfflineTransFB) form;
		
		UserVO userVO = (UserVO) request.getSession().getAttribute(HISConfig.USER_VO);
		
		System.out.println("Back Date Day End Check Flag :::value :::"+userVO.getCheckBackDateDayEndFlag());			
		
			
		if(BillConfigUtil.BACK_DATE_DAYEND_STOP_PROCESS.equals("1"))
		{		
			if(userVO.getCheckBackDateDayEndFlag().toString().equals("1"))
			{
				formBean.setStrErrMsg("Cash Collection Not Applicable, Please Perform Day End First.\n If Day End Already Performed , Please Relogin");
				return mapping.findForward(target);
			}
			else if(userVO.getCheckBackDateDayEndFlag().toString().equals("2"))
			{
				formBean.setStrErrMsg("Cash Collection Not Applicable, Please Deposit Day End Amount.\n If Already Deposited , Please Relogin");
				return mapping.findForward(target);
			}
		}
		
		String strCounterMode = "0";
		if(request.getParameter("counterMode") != null)
		{
			 strCounterMode = request.getParameter("counterMode");
		}
		else
		{
			strCounterMode = formBean.getStrCounterMode();
		}		
		
		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		CashCollectionOfflineTransDATA.preInitOffLineDetails(formBean );//Populates Hospital Service Combo and Request Type Combo Only
		
		formBean.setStrCounterMode(strCounterMode);
		
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
	public ActionForward GO(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws HisException, SQLException 
	{
		generateToken(request);
		//Gets Patient Details,Combos Like Client,Payment Mode,Relation,Groups,Tariffs,Department,Episode,Category,Configuration Parameters  
		String strTarget = "cashcollection";
		CashCollectionOfflineTransFB formBean = (CashCollectionOfflineTransFB) form;

		boolean bResult = CashCollectionOfflineTransDATA.init(request, formBean);
		if (bResult) 
		{
			return mapping.findForward(strTarget);
		} 
		else 
		{
			return this.OFFLINEMODE(mapping, formBean, request, response);
		}
	}
  
	  
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

		CashCollectionOfflineTransDATA.getBillServiceDetails(request, response);

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

		CashCollectionOfflineTransDATA.getEpisodeDetails(request, response);

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

		CashCollectionOfflineTransDATA.getClientDetails(request, response);

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

		CashCollectionOfflineTransDATA.getGroupDetails(request, response);

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
	public ActionForward TARIFFDTLS(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws HisException, SQLException 
	{
		CashCollectionOfflineTransDATA.getTariffDetails(request, response);
		return null;
	}
	
	public ActionForward TARIFFCODEDTLSDRUG(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws HisException, SQLException 
	{
		CashCollectionOfflineTransDATA.getTariffCodeDetailsDrug(request, response);
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
	public ActionForward TARIFFCODEDTLS(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws HisException, SQLException 
	{
		CashCollectionOfflineTransDATA.getTariffCodeDetails(request, response);
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

		CashCollectionOfflineTransDATA.getGroupDetails(request, response);

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
		
		CashCollectionOfflineTransDATA.getPartPaymentOrAccountDtls(request, response);

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

		CashCollectionOfflineTransDATA.getOffLineTariffUnitDetails(request, response);

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

		CashCollectionOfflineTransDATA.getOffLineRefundBillDetails(request, response);

		return null;

	}
	
	
	public ActionForward REFUNDPARTPAYBILLDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		CashCollectionOfflineTransDATA.getOffLinePartPayRefundBillDetails(request, response);

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
	public ActionForward REFUNDBILLTARIFFDTLS(ActionMapping mapping,ActionForm form, HttpServletRequest request,HttpServletResponse response) throws HisException, SQLException 
	{
		CashCollectionOfflineTransDATA.getOffLineRefundBillTariffDetails(request,response);
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
	public ActionForward REFUNDPARTPAYBILLTARIFFDTLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		CashCollectionOfflineTransDATA.getOffLineRefundBillTariffDetails(request,
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

		CashCollectionOfflineTransDATA.getOffLineRefundBillTariffPopupDetails(request,
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
		CashCollectionOfflineTransDATA.UNITVAL12(request, response);

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

		CashCollectionOfflineTransFB formBean = (CashCollectionOfflineTransFB) form;

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

		CashCollectionOfflineTransFB formBean = (CashCollectionOfflineTransFB) form;
		CashCollectionOfflineTransDATA.getBillListingDtls(request, response, formBean);

		return null;
	}
 
	
	
	public ActionForward OFFLINETREATCATDTL(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		CashCollectionOfflineTransDATA.getOfflineTreatmentCategoryDtls(request, response);

		return null;

	}
	

	public ActionForward OFFLINEDEPTDTL(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		CashCollectionOfflineTransDATA.getOfflineRaisingDetapartmentDtls(request, response);

		return null;

	}
	
	
	
	public ActionForward OFFLINEWARDDTL(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		CashCollectionOfflineTransDATA.getOfflineWardDtls(request, response);

		return null;

	}
	 
	
	public ActionForward OFFLINESPLWARDDTL(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		CashCollectionOfflineTransDATA.getOfflineSpecialWardDtls(request, response);

		return null;

	}
	
	 
		
	public ActionForward UPDATEPRINTSTATUS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		CashCollectionOfflineTransDATA.updatePrintStatus(request, response);

		return null;

	}
	
	

	public ActionForward REPRINT(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		CashCollectionOfflineTransDATA.rePrint(request, response);

		return null;

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
	public ActionForward OFFRECPARTPAY(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		validateToken(request, response);
		//String target = "cashcollection";
		CashCollectionOfflineTransFB formBean = (CashCollectionOfflineTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR").toString());

		if(request.getSession().getAttribute("USER_LEVEL") != null)
		{
			formBean.setStrUserLevel(request.getSession().getAttribute("USER_LEVEL").toString());
		}
		else
		{
			formBean.setStrUserLevel("1");
		}		
		
		CashCollectionOfflineTransDATA.insertOfflineReceiptPartPayment(formBean , request);
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
			throws Exception {
		validateToken(request, response);
		//String target = "cashcollection";

		CashCollectionOfflineTransFB formBean = (CashCollectionOfflineTransFB) form;

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
		
	 CashCollectionOfflineTransDATA
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
	public ActionForward OFFRECSER(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception 
	{
		validateToken(request, response);
		CashCollectionOfflineTransFB formBean = (CashCollectionOfflineTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR").toString());

		if(request.getSession().getAttribute("USER_LEVEL") != null)
		{
			formBean.setStrUserLevel(request.getSession().getAttribute("USER_LEVEL").toString());
		}
		else
		{
			formBean.setStrUserLevel("1");
		}
		
		CashCollectionOfflineTransDATA.insertOfflineReceiptService(formBean , request);
		
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
	public ActionForward OFFREFUNDSER(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		//String target = "cashcollection";
		validateToken(request, response);
		CashCollectionOfflineTransFB formBean = (CashCollectionOfflineTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR").toString());
		if(request.getSession().getAttribute("USER_LEVEL") != null)
		{
			formBean.setStrUserLevel(request.getSession().getAttribute("USER_LEVEL").toString());
		}
		else
		{
			formBean.setStrUserLevel("1");
		}
		
		CashCollectionOfflineTransDATA.insertOfflineRefundService(formBean , request);
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
			throws Exception {
		validateToken(request, response);
		//String target = "cashcollection";

		CashCollectionOfflineTransFB formBean = (CashCollectionOfflineTransFB) form;
		
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
		
		CashCollectionOfflineTransDATA.insertOfflineRefundAdmissionCancellation(formBean , request);

		
			return this.OFFLINEMODE(mapping, formBean, request, response);
	
	}
	public ActionForward OFFREFUNDPARTPAYCANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		validateToken(request, response);
		//String target = "cashcollection";

		CashCollectionOfflineTransFB formBean = (CashCollectionOfflineTransFB) form;
		
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
		
		CashCollectionOfflineTransDATA.insertOfflineRefundPartPayment(formBean , request);

		
			return this.OFFLINEMODE(mapping, formBean, request, response);
	
	}
	public ActionForward PRINTSLIP(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws HisException 
	{
		CashCollectionOfflineTransFB formBean = (CashCollectionOfflineTransFB) form;
		if(request.getParameter("filePath")!=null)
		{
			formBean.setFilePath(request.getParameter("filePath"));
			request.setAttribute("filePath", request.getParameter("filePath"));
		}
		return mapping.findForward("printPopUp");
	}
	
	public ActionForward ONLINE(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws HisException 
	{
		CashCollectionOfflineTransFB formBean = (CashCollectionOfflineTransFB) form;		
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/billing/transactions/CashCollectionOnlineTransCNT.cnt?hmode=ONLINEMODE&counterMode="+formBean.getStrCounterMode());
		acFwd.setContextRelative(true);
		//acFwd.setRedirect(true);
		return acFwd;	
	}	
	public ActionForward OFFLINE(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws HisException 
	{
		/*CashCollectionOfflineTransFB formBean = (CashCollectionOfflineTransFB) form;		
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/billing/transactions/CashCollectionOfflineTransCNT.cnt?hmode=OFFLINEMODE&counterMode="+formBean.getStrCounterMode());
		acFwd.setContextRelative(true);
		return acFwd;	*/
		
		return this.unspecified(mapping, form, request, response);
	}	
	public ActionForward LF(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws HisException 
	{
		CashCollectionOfflineTransFB formBean = (CashCollectionOfflineTransFB) form;				
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/billing/transactions/LFNoTransCNT.cnt?hmode=OFFLINEMODE&counterMode="+formBean.getStrCounterMode());
		acFwd.setContextRelative(true);
		return acFwd;	
	}
	public ActionForward PATWALLET(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws HisException 
	{
		CashCollectionOfflineTransFB formBean = (CashCollectionOfflineTransFB) form;				
		ActionForward acFwd = new ActionForward();
		//acFwd.setPath("/billing/transactions/PatWalletTransCNT.cnt?hmode=OFFLINEMODE&counterMode="+formBean.getStrCounterMode());
		acFwd.setPath("/billing/transactions/PatWalletTransCNT.cnt?hmode=OFFLINEMODE");
		acFwd.setContextRelative(true);
		return acFwd;	
	}
	public ActionForward WITHOUTCRNO(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws HisException 
	{
		CashCollectionOfflineTransFB formBean = (CashCollectionOfflineTransFB) form;				
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/billing/transactions/CashCollectionWithoutCrTransCNT.cnt?hmode=WITHOUTCRNO&isOnline=0&counterMode="+formBean.getStrCounterMode());
		acFwd.setContextRelative(true);
		return acFwd;	
	}
	public ActionForward ADVANCED(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws HisException 
	{
		CashCollectionOfflineTransFB formBean = (CashCollectionOfflineTransFB) form;				
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/billing/transactions/AdvanceCashCollectionOnlineTransCNT.cnt?hmode=ONLINEMODE&counterMode="+formBean.getStrCounterMode());
		acFwd.setContextRelative(true);
		return acFwd;	
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
	public ActionForward CANCELPAGE(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) 
	{
        ActionForward acFwd = new ActionForward();
        acFwd.setPath("/hisglobal/initPage.jsp");
        acFwd.setContextRelative(true);
        return acFwd;
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
	public ActionForward GOFROMADVANCECASHONLINE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		generateToken(request);
		String strTarget = "cashcollection";

		CashCollectionOfflineTransFB formBean = (CashCollectionOfflineTransFB) form;

		//return this.OFFLINEMODE(mapping, formBean, request, response);
		
		
		formBean.setStrOffLineHospitalService("1");//DEFAULT OPD MORNING SELECTED
		formBean.setStrOffLineRequestType("1");//DEFAULT RECEIPT SELECTED
		
		boolean bResult = CashCollectionOfflineTransDATA.init(request, formBean);

		if (bResult) 
		{
			return mapping.findForward(strTarget);
		} 
		else 
		{		 
			return this.OFFLINEMODE(mapping, formBean, request, response);			
		}
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
	public ActionForward GOFROMCASHONLINE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		generateToken(request);
		String strTarget = "advancecashcollection";

		CashCollectionOfflineTransFB formBean = (CashCollectionOfflineTransFB) form;

		//return this.OFFLINEMODE(mapping, formBean, request, response);
		
		
		//formBean.setStrOffLineHospitalService("1");//DEFAULT OPD MORNING SELECTED
		formBean.setStrOffLineRequestType("1");//DEFAULT RECEIPT SELECTED
		
		boolean bResult = CashCollectionOfflineTransDATA.initAdvancedCash(request, formBean);

		if (bResult) 
		{
			return mapping.findForward(strTarget);
		} 
		else 
		{		 
			return this.OFFLINEMODE(mapping, formBean, request, response);			
		}
	}
	
	/**
	 * inserts "Off-line Estimation" Details
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	public ActionForward OFFESTIMATION(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception 
	{
		validateToken(request, response);
		CashCollectionOfflineTransFB formBean = (CashCollectionOfflineTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR").toString());

		if(request.getSession().getAttribute("USER_LEVEL") != null)
		{
			formBean.setStrUserLevel(request.getSession().getAttribute("USER_LEVEL").toString());
		}
		else
		{
			formBean.setStrUserLevel("1");
		}
		
		CashCollectionOfflineTransDATA.insertOfflineEstimation(formBean , request);
		
		return this.OFFLINEMODE(mapping, formBean, request, response);		
	}
	public ActionForward OFFRECPACK(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		validateToken(request, response);
		//String target = "cashcollection";
		CashCollectionOfflineTransFB formBean = (CashCollectionOfflineTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR").toString());

		if(request.getSession().getAttribute("USER_LEVEL") != null)
		{
			formBean.setStrUserLevel(request.getSession().getAttribute("USER_LEVEL").toString());
		}
		else
		{
			formBean.setStrUserLevel("1");
		}		
		
		CashCollectionOfflineTransDATA.insertOfflineReceiptPackage(formBean , request);
		return this.OFFLINEMODE(mapping, formBean, request, response);
		
	}
	public ActionForward PACKAGEAMOUNT(ActionMapping _Mapping, ActionForm _Form,
			HttpServletRequest _Request, HttpServletResponse _Response)
			throws HisException {
		CashCollectionOfflineTransFB formBean = (CashCollectionOfflineTransFB) _Form;
		CashCollectionOfflineTransDATA.setPackageAmountValues(formBean, _Request, _Response);
		return null;
	}
	
	public ActionForm advanceDtls(ActionMapping _Mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws HisException
	{
		CashCollectionOfflineTransFB  formBean= (CashCollectionOfflineTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		
		
		CashCollectionOfflineTransDATA.getAdvanceDtls(formBean,request);
		return null;
	}

	
	public ActionForm accountCategory(ActionMapping _Mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws HisException
	{
		CashCollectionOfflineTransFB  formBean= (CashCollectionOfflineTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		
		
		CashCollectionOfflineTransDATA.getAccountCategory(formBean,request,response);
		return null;
	}
	
	
	
	public ActionForward AJX_PAYMENTMODEBYPATCAT(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws HisException, SQLException 
	{
		   CashCollectionOfflineTransFB formBean = (CashCollectionOfflineTransFB) form;
			CashCollectionOfflineTransDATA.getPaymentModeListByPatCategory(formBean,request, response);

			return null;

	}
	
  
	
}
