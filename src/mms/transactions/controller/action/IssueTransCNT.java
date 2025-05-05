package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.IssueTransDATA;
import mms.transactions.controller.fb.IssueTransFB;

public class IssueTransCNT extends CSRFGardTokenAction{
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		generateToken(request);
		IssueTransFB formBean = (IssueTransFB) form;
		return this.INITVAL(mapping, formBean, request, response);

   }
	
	public ActionForward CANCELPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
	    ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	/*
	 * To Get the Store Combo
	 */
	
	public ActionForward INITVAL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {		
		System.out.println("<------------- IssueTransCNT.INITVAL() ----[ issue_trans.jsp , issue_trans.js]--------->");
		generateToken(request);
		IssueTransFB formBean = (IssueTransFB) form;
		//formBean.setStrCrNoDefault("1");
		formBean.setStrDoseFrqFlg("0");
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());	
		
		
		
		formBean.setStrStoreId(request.getParameter("strStoreId").split("\\#")[0]);
		formBean.setStrId(request.getParameter("strStoreId").split("\\#")[0]);
		formBean.setStoreName(request.getParameter("strStoreId").split("\\#")[1]);
		
		
		IssueTransDATA.getStoreDtls(formBean, request);		
		if(formBean.getStrCRorLFwise()==null || formBean.getStrCRorLFwise()=="")
		formBean.setStrCRorLFwise("1");
		System.out.println("<---Stored_Id----->"+request.getParameter("strStoreId"));
		formBean.setStrStoreId(request.getParameter("strStoreId").split("\\#")[0]);
		formBean.setStrId(request.getParameter("strStoreId").split("\\#")[0]);
		formBean.setStoreName(request.getParameter("strStoreId").split("\\#")[1]);
		
		System.out.println("<---Stored_Name----->"+formBean.getStoreName());
		System.out.println("<---Stored_Id----->"+formBean.getStrId());
		String target = "issue";
		return mapping.findForward(target);
		
	} 
	
	/*
	 * To Get the Cancel Page
	 */
	
	public ActionForward GETCANCELPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {		 		 
		IssueTransFB formBean = (IssueTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		IssueTransDATA.getStoreDtls(formBean, request);		
		String target = "cancelIssue";
		return mapping.findForward(target);
	} 
	
	/*
	 * To Get the Item Category Combo
	 */
	
	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		IssueTransFB formBean = (IssueTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		IssueTransDATA.getItemCatDtls(formBean,request, response);
		
		return null;
	}
	public ActionForward issuetopatientcount(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		generateToken(request);
		String target="";
		IssueTransFB formBean = (IssueTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		//System.out.println("formBean.getStrCrNo()>>>"+formBean.getStrCrNo());
		//System.out.println("formBean.getStrstoreid>>>"+formBean.getStrId());
		//System.out.println("formBean.getStrCrNo()>>>"+formBean.getItemCategory());
		
		int chkcount=IssueTransDATA.getissuetopatientcount(formBean,request, response);
		//System.out.println("countttttttttttttt"+chkcount);
		if(chkcount>0)
		{
			System.out.println("<------------- IssueTransCNT.issuetopatientcount() . view_PatientIssue_trans.jsp ------------->");
			
			formBean.setStrflg("1");
			this.VIEWPAGE(mapping, formBean, request, response);
			target = "view";
		}
		else
		{
			System.out.println("<------------- IssueTransCNT.issuetopatientcount() . issue_trans_go.jsp ------------->");
			this.INITVALGO(mapping, formBean, request, response);
			target = "issueGo";
		}
		
		return mapping.findForward(target);
	}
	
	
	public ActionForward INITVALGO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		System.out.println("<------------- IssueTransCNT.INITVALGO() ------------->");
		
		generateToken(request);
		String target="";
		IssueTransFB formBean = (IssueTransFB) form;
		if(formBean.getNewreqflg().equalsIgnoreCase("1"))
		{
			formBean.setStrCrNo(formBean.getCrNo());
		}
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		   
	    IssueTransDATA.getPatientDetails(formBean, request, response);		
	    formBean.setCrNo(formBean.getStrCrNo());
		if(formBean.getStrInvalidCrFlag().equals("1") || formBean.getStrInvalidLFFlag().equals("1") )
		{
			
			return this.INITVAL(mapping,formBean,request,response);
			
		}
		else
		{
			IssueTransDATA.getOnlineReqDtl(formBean, request, response);
			IssueTransDATA.getDeptDetails(formBean, request);
			
			IssueTransDATA.getFrequencyDetails(formBean, request);
			IssueTransDATA.getDoseDetails(formBean, request);
			
			if(!formBean.getStrIssueMode().equals("0")){
			
				IssueTransDATA.getGroupDetails(formBean, request);
				
			}
			if(formBean.getStrCRorLFwise().equals("2"))
				{
				System.out.println("<------------- IssueTransCNT.issuetopatientcount() . issue_trans_LFwise_go.jsp ------------->");
				target = "issueGoLFWise";
				
				}
			else
			System.out.println("<------------- IssueTransCNT.issuetopatientcount() . issue_trans_go.jsp ------------->");
			target = "issueGo";
			return mapping.findForward(target);
		}
	
	}
	
	public ActionForward INITCANCELGO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		    IssueTransFB formBean = (IssueTransFB) form;
		    formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		    formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		    IssueTransDATA.getCancelPatientDetails(formBean, request, response);		
			
			String target = "cancelGo";
			return mapping.findForward(target);
		
	
	}
	
	
	public ActionForward PREVISSUEDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		IssueTransFB formBean = (IssueTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueTransDATA.getIssueDetails(formBean, request, response);
		return null;
	}
	
	public ActionForward ISSUEDTLPOPUP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		IssueTransFB formBean = (IssueTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueTransDATA.getIssuePopUp(formBean, request, response);
		return null;
	}
	
	public ActionForward REQUESTDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		IssueTransFB formBean = (IssueTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueTransDATA.getRequestDetails(formBean, request, response);
		return null;
	}
	
	public ActionForward UNITCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		IssueTransFB formBean = (IssueTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueTransDATA.getUnitDetails(formBean, request, response);
		return null;
	}
	
	public ActionForward PRESCRIPEDBY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		IssueTransFB formBean = (IssueTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueTransDATA.getPrescribedBy(formBean, request, response);
		return null;
	}
	
	public ActionForward ITEMDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		IssueTransFB formBean = (IssueTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueTransDATA.getItemDetails(formBean, request, response);
		return null;
	}
	
	
	
	
	
	public ActionForward INSERTIPD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
   {
		validateToken(request, response);
		IssueTransFB formBean = (IssueTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueTransDATA.insertipd(formBean, request);			
	//	this.ISSUEDTLPOPUP(mapping,form,request,response);
		formBean.setPrintReq("1");
		if(formBean.getStrVisitDtl().equals("0"))
		{
			//ActionMapping mapping, ActionForm form,
			//HttpServletRequest request, HttpServletResponse response
			return this.INITVALGO(mapping, form, request, response);
		}
		else
		{
			return this.INITVAL(mapping, form, request, response);
		}
		
	}
	
	public ActionForward INSERTCANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		IssueTransFB formBean = (IssueTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueTransDATA.insertCancel(formBean, request);			
		if(formBean.getStrVisitDtl().equals("0"))
		{
			return this.INITCANCELGO(mapping, form, request, response);
		}
		else
		{
			return this.GETCANCELPAGE(mapping, form, request, response);
		}
		
	}
	
	
	/**
	 * To go on the page with Or Without Cr No.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward withOrWithoutCrNo(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)	throws HisException, SQLException 
   {
     
		IssueTransFB formBean = (IssueTransFB) form;
		//IssueTransDATA.getMmsConfigFlags(formBean, request,	response);
		formBean.setStrWithOutCrNoFlg("1");
		formBean.setStrCrNoDefault("1");
		formBean.setStrDoseFrqFlg("0");
		
		if(formBean.getStrWithOutCrNoFlg()!=null){
			
			if(formBean.getStrWithOutCrNoFlg().equals("1"))
			{
				if(formBean.getStrCrNoDefault().equals("0"))
				{
					return this.INITVAL(mapping, formBean, request, response);
				}
				else
				{
					String strMode = request.getParameter("mode");
					if(strMode == null) strMode = "0";
					
					formBean.setStrIssueMode(strMode);
					formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					formBean.setStrWithoutCrNoCheckBox("1");
					IssueTransDATA.getStoreDtls(formBean, request);
					IssueTransDATA.getGenderCombo(formBean, request);
					
					/*
					IssueTransDATA.getDeptDetails(formBean, request);
					IssueTransDATA.getFrequencyDetails(formBean, request);					
					IssueTransDATA.getFrequencyDetails(formBean, request);
					IssueTransDATA.getDoseDetails(formBean, request);
					*/
					
					String target = "issueGoWithoutCrNo";
					return mapping.findForward(target);	
				}
			}
			else 
			{
				return this.INITVAL(mapping, formBean, request, response);
			}
						
		}
		else 
		{
			return this.INITVAL(mapping, formBean, request, response);
		}		
	}
	
	
	/**
	 * To go on the page Without Cr No.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward INITVALWITHOUTCRNO(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)	throws HisException, SQLException 
   {
     
		IssueTransFB formBean = (IssueTransFB) form;
		IssueTransDATA.getMmsConfigFlags(formBean, request,	response);
		
		String strMode = request.getParameter("mode");
		if(strMode == null) strMode = "0";
		formBean.setStrIssueMode(strMode);		          
					
					formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					formBean.setStrWithoutCrNoCheckBox("1");
					IssueTransDATA.getStoreDtls(formBean, request);
					//IssueTransDATA.getDeptDetails(formBean, request);
					//IssueTransDATA.getFrequencyDetails(formBean, request);
					//IssueTransDATA.getDoseDetails(formBean, request);
					IssueTransDATA.getGenderCombo(formBean, request);
					//IssueTransDATA.getFrequencyDetails(formBean, request);
					//IssueTransDATA.getDoseDetails(formBean, request);
					
					String target = "issueGoWithoutCrNo";
					return mapping.findForward(target);	
					
	}
	
	
	/**
	 * ISSUEDTLSINIT - gets the issue details view used for ajax.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward ISSUEDTLSINIT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		IssueTransFB formBean = (IssueTransFB) form;
		IssueTransDATA.issueDtlsInit(request, response, formBean);
		return null;
	}
	
	/**
	 * ISSUEDTLSINIT - gets the issue details view used for ajax.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward ISSUEDTLSINITONE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		IssueTransFB formBean = (IssueTransFB) form;
		IssueTransDATA.issueDtlsInit(request, response, formBean);
		return null;
	}
	
	/**
	 * 
	 * forwards control to the View page of this  Transaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	
	public ActionForward VIEWPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		String strTarget="view";
		IssueTransFB formBean = (IssueTransFB) form;
		//formBean.setStrflg("0");
		generateToken(request);
		IssueTransDATA.getMmsConfigFlags(formBean, request,	response);
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrCrNo(formBean.getStrCrNo());
				
		IssueTransDATA.getStoreDtlsView(formBean, request);
		//formBean.setStrflg("1");
		return mapping.findForward(strTarget);
	}
	
	
	/**
	 * 
	 * Method is used to get View details after pressing GO button
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	
	public ActionForward GOVIEWPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		IssueTransFB fb = (IssueTransFB) form;
		IssueTransDATA.getViewDtl(fb, request, response);
		return null;
	}
	
	public ActionForward RETURNTOMAINDESK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		ActionForward acFwd = new ActionForward();
		String strPath = "";
		if(request.getParameter("strPath")!= null)
		{
			strPath = request.getParameter("strPath");
			acFwd.setPath(strPath);
	        acFwd.setContextRelative(true);
	        
		}
		return acFwd;
	}
	
	
	/**
	 * 
	 * Method is used to get issue item details after billing 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	
	public ActionForward ISSUEDTLSBILLED(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		IssueTransFB fb = (IssueTransFB) form;
		IssueTransDATA.getBilledItemDtls(fb, request, response);
		return null;
	}
	
	
	/**
	 * 
	 * Method is used to delete issue item details after billing 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	
	public ActionForward DELETEISSUEDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		IssueTransFB fb = (IssueTransFB) form;
		IssueTransDATA.deleteIssueDtls(fb, request, response);
		return null;
	}
	
	public ActionForward TARIFFCHK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		IssueTransFB fb = (IssueTransFB) form;
		IssueTransDATA.getTariffDtl(fb, request, response);
		return null;
	}
}
