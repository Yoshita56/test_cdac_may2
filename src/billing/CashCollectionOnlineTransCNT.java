package billing;

import hisglobal.config.HISConfig;
import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import hisglobal.presentation.CSRFGardTokenAction;


import hisglobal.vo.UserVO;
import billing.BillConfigUtil;

public class CashCollectionOnlineTransCNT extends CSRFGardTokenAction {

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
		generateToken(request);
		CashCollectionOnlineTransFB formBean = (CashCollectionOnlineTransFB) form;
		formBean.setFilePath("");
		formBean.setIsOpenPopUp("0");
		String target = "cashcollection";
		
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
		else
		{
			CashCollectionOnlineTransDATA.checkCounterStatus(request, formBean);
			return this.ONLINEMODE(mapping, form, request, response);
		}
		return this.ONLINEMODE(mapping, form, request, response);
	}
 
	public ActionForward CHANGEMODE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		CashCollectionOnlineTransFB formBean = (CashCollectionOnlineTransFB) form;
		
		ActionForward acFwd = new ActionForward();
		acFwd
				.setPath("/billing/transactions/CashCollectionOfflineTransCNT.cnt?hmode=OFFLINEMODE&counterMode="+formBean.getStrCounterMode());
		acFwd.setContextRelative(true);
		return acFwd;
	
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
		generateToken(request);
		CashCollectionOnlineTransFB formBean = (CashCollectionOnlineTransFB) form;		
		String target = "cashcollection";
		
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
		
		formBean.setStrIsOnline("1");
		formBean.setCurrentState("1");
		
		formBean.setStrIsWithoutCrNoRequired(new BillConfigUtil(formBean.getStrHospitalCode()).getGeneralIsWithoutCrNoRequired());
		formBean.setStrConfirmationType(new BillConfigUtil(formBean.getStrHospitalCode()).getGeneralCashCollectionConfrimType());
		
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
		String strTarget = "cashcollection";
		CashCollectionOnlineTransFB formBean = (CashCollectionOnlineTransFB) form;
		
		// added by ashu -- call cash collection desk from investigation module.
				if(request.getParameter("CRNO")!=null)
				{
				String crno=request.getParameter("CRNO");
				formBean.setStrCrNo(crno);
				
				}
		boolean bResult = CashCollectionOnlineTransDATA.init(request, formBean);
		if (bResult) 
		{
			if(formBean.getStrOnlineDetailsView()==null || formBean.getStrOnlineDetailsView().equals(""))
			{
				ActionForward acFwd = new ActionForward();
				acFwd.setPath("/billing/transactions/CashCollectionOfflineTransCNT.cnt?hmode=GOFROMCASHONLINE&strCrNo="+formBean.getStrCrNo());
				acFwd.setContextRelative(true);
				return acFwd;
			}			 
			else 
			{
				return mapping.findForward(strTarget);
			}
		} 
		else 
		{			
			//if(formBean.getCurrentState().equals("1")){
			if(formBean.getStrOnlineDetailsView()==null || formBean.getStrOnlineDetailsView().equals(""))
			{
				ActionForward acFwd = new ActionForward();
				acFwd.setPath("/billing/transactions/CashCollectionOfflineTransCNT.cnt?hmode=GOFROMCASHONLINE&strCrNo="+formBean.getStrCrNo());
				acFwd.setContextRelative(true);
				return acFwd;
			}
			else
				return this.ONLINEMODE(mapping, formBean, request, response);
			//}else{
			//	return this.OFFLINEMODE(mapping, formBean, request, response);
			//}
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

		return this.ONLINEMODE(mapping, form, request, response);
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
	public ActionForward ONLINEDTLS(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws HisException, SQLException 
	{
		CashCollectionOnlineTransDATA.getOnlineDtls(request, response);
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
		CashCollectionOnlineTransDATA.UNITVAL12(request, response);

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

		CashCollectionOnlineTransDATA.getOnLineRefundTariffPopupDetails(request,
				response);

		return null;

	}
     
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

		CashCollectionOnlineTransDATA.getAdmissionCancellationDtls(request, response);

		return null;

	}

	
	    
		
	public ActionForward UPDATEPRINTSTATUS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		CashCollectionOnlineTransDATA.updatePrintStatus(request, response);

		return null;

	}
	

	public ActionForward REPRINT(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		CashCollectionOnlineTransDATA.rePrint(request, response);

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
			throws Exception {
		validateToken(request, response);
		//String target = "cashcollection";

		CashCollectionOnlineTransFB formBean = (CashCollectionOnlineTransFB) form;

		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());

		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR")
				.toString());
		
		 CashCollectionOnlineTransDATA
				.insertOnlineReceiptPartPayment(formBean , request);

		
			return this.ONLINEMODE(mapping, formBean, request, response);
		
	}

	
	public ActionForward ONRECADV(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		validateToken(request, response);
		//String target = "cashcollection";

		CashCollectionOnlineTransFB formBean = (CashCollectionOnlineTransFB) form;

		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());

		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR")
				.toString());
		
		 CashCollectionOnlineTransDATA.insertOnlineReceiptAdvance(formBean , request);
		
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
	public ActionForward ONRECSERVICE(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		validateToken(request, response);
		CashCollectionOnlineTransFB formBean = (CashCollectionOnlineTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR").toString());
		
		CashCollectionOnlineTransDATA.insertOnlineReceiptServices(formBean , request);

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
			throws Exception {

		//String target = "cashcollection";
		validateToken(request, response);
		CashCollectionOnlineTransFB formBean = (CashCollectionOnlineTransFB) form;

		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());

		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR")
				.toString());
		
		 CashCollectionOnlineTransDATA.insertOnlineRefundServices(formBean , request);

		
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
			throws Exception {

		//String target = "cashcollection";
		validateToken(request, response);
		CashCollectionOnlineTransFB formBean = (CashCollectionOnlineTransFB) form;

		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());

		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR")
				.toString());
		
	 CashCollectionOnlineTransDATA.insertOnlineRefundAdvance(formBean , request);

		
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
	public ActionForward ONFINALADJUST(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		validateToken(request, response);
		CashCollectionOnlineTransFB formBean = (CashCollectionOnlineTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR").toString());
		
		CashCollectionOnlineTransDATA.insertOnlineFinalAdjustment(formBean , request);
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
			throws Exception {

		//String target = "cashcollection";
		validateToken(request, response);
		CashCollectionOnlineTransFB formBean = (CashCollectionOnlineTransFB) form;

		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());

		formBean.setStrIpAddress(request.getSession().getAttribute("IP_ADDR")
				.toString());
		
		 CashCollectionOnlineTransDATA.insertOnlineReconciliation(formBean , request);

		
			return this.ONLINEMODE(mapping, formBean, request, response);
		
	}
	
	public ActionForward OFFLINE(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws HisException 
	{
		CashCollectionOnlineTransFB formBean = (CashCollectionOnlineTransFB) form;		
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/billing/transactions/CashCollectionOfflineTransCNT.cnt?hmode=OFFLINEMODE&counterMode="+formBean.getStrCounterMode());
		acFwd.setContextRelative(true);
		return acFwd;	
	}	
	public ActionForward ONLINE(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws HisException 
	{/*
		CashCollectionOnlineTransFB formBean = (CashCollectionOnlineTransFB) form;		
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/billing/transactions/CashCollectionOnlineTransCNT.cnt?hmode=ONLINEMODE&counterMode="+formBean.getStrCounterMode());
		acFwd.setContextRelative(true);
		acFwd.setRedirect(true);
		return acFwd;	*/
		return this.unspecified(mapping, form, request, response);
	}	
	public ActionForward WITHOUTCRNO(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws HisException 
	{
		CashCollectionOnlineTransFB formBean = (CashCollectionOnlineTransFB) form;				
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/billing/transactions/CashCollectionWithoutCrTransCNT.cnt?hmode=WITHOUTCRNO&isOnline=1&counterMode="+formBean.getStrCounterMode());
		acFwd.setContextRelative(true);
		return acFwd;	
	}
	public ActionForward LF(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws HisException 
	{
		CashCollectionOnlineTransFB formBean = (CashCollectionOnlineTransFB) form;				
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/billing/transactions/LFNoTransCNT.cnt?hmode=OFFLINEMODE&counterMode="+formBean.getStrCounterMode());
		acFwd.setContextRelative(true);
		return acFwd;	
	}
	public ActionForward PATWALLET(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws HisException 
	{
		CashCollectionOnlineTransFB formBean = (CashCollectionOnlineTransFB) form;				
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/billing/transactions/PatWalletTransCNT.cnt?hmode=OFFLINEMODE&counterMode="+formBean.getStrCounterMode());
		acFwd.setContextRelative(true);
		return acFwd;	
	}
	public ActionForward ADVANCED(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws HisException 
	{
		CashCollectionOnlineTransFB formBean = (CashCollectionOnlineTransFB) form;				
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
	/*public ActionForward GO(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws HisException, SQLException 
	{
		String strTarget = "cashcollection";
		CashCollectionOnlineTransFB formBean = (CashCollectionOnlineTransFB) form;
		
		boolean bResult = CashCollectionOnlineTransDATA.init(request, formBean);
		if (bResult) 
		{
			if(formBean.getStrOnlineDetailsView()==null || formBean.getStrOnlineDetailsView().equals(""))
			{
				ActionForward acFwd = new ActionForward();
				acFwd.setPath("/billing/transactions/CashCollectionOfflineTransCNT.cnt?hmode=GOFROMADVANCECASHONLINE&strCrNo="+formBean.getStrCrNo());
				acFwd.setContextRelative(true);
				return acFwd;
			}			 
			else 
			{
				return mapping.findForward(strTarget);
			}
		} 
		else 
		{			
			//if(formBean.getCurrentState().equals("1")){
			if(formBean.getStrOnlineDetailsView()==null || formBean.getStrOnlineDetailsView().equals(""))
			{
				ActionForward acFwd = new ActionForward();
				acFwd.setPath("/billing/transactions/CashCollectionOfflineTransCNT.cnt?hmode=GOFROMADVANCECASHONLINE&strCrNo="+formBean.getStrCrNo());
				acFwd.setContextRelative(true);
				return acFwd;
			}
			else
				return this.ONLINEMODE(mapping, formBean, request, response);
			//}else{
			//	return this.OFFLINEMODE(mapping, formBean, request, response);
			//}
		}		
	}*/
}
