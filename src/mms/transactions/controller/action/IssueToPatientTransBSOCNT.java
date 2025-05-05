package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.IssueToPatientBSODATA;
import mms.transactions.controller.fb.IssueTransOFB;

public class IssueToPatientTransBSOCNT extends CSRFGardTokenAction {
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		generateToken(request);
		IssueTransOFB formBean = (IssueTransOFB) form;
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
		System.out.println(" ------- IssueToPatientTransBSOCNT.INITVAL  ----[issue_transNewO.jsp ]---- ");
		
		generateToken(request);
		IssueTransOFB formBean = (IssueTransOFB) form;
		//formBean.setStrCrNoDefault("1");
		formBean.setStrDoseFrqFlg("0");
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		
		formBean.setStrStoreId(request.getParameter("strStoreId"));
		formBean.setStrId(request.getParameter("strStoreId"));		
		IssueToPatientBSODATA.getStoreDtls(formBean, request);
		
		System.out.println(" ------- IssueToPatientTransBSOCNT.INITVAL  ---CR_NO--- "+request.getParameter("patCrNo"));
		
		if(request.getParameter("patCrNo")!=null)
		{	
		    formBean.setStrCrNo(request.getParameter("patCrNo"));
		}
		else
		{
			formBean.setStrCrNo(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		}
		//formBean.setStrCrNo("123123123");
		if(formBean.getStrCRorLFwise()==null || formBean.getStrCRorLFwise()=="")
		formBean.setStrCRorLFwise("1");
		String target = "issueNew";
		return mapping.findForward(target);
	} 
	
	public ActionForward issuetopatientcount(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		generateToken(request);
		String target="";
		IssueTransOFB formBean = (IssueTransOFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		
		
		
        System.out.println(" ------- IssueToPatientTransBSOCNT.issuetopatientcount  ----[issue_trans_goNewO.jsp]---- ");
        
        System.out.println(" request.getParameter(strStoreId)----- "+request.getParameter("strId"));
        System.out.println(" request.getParameter(getStrCrNo)----- "+request.getParameter("crNo"));
        System.out.println(" request.getParameter(strItemCat)----- "+request.getParameter("itemCategory"));                
    	System.out.println(" formBean.getStrCrNo()           ----- "+formBean.getStrCrNo());
		System.out.println(" formBean.getStrStoreId          ----- "+formBean.getStrStoreId());
		System.out.println(" formBean.getStrItemCat()        ----- "+formBean.getStrItemCat());
        
		System.out.println(" ------- IssueToPatientBSODATA.getDiirecIssueInitData ------ ");
		
		IssueToPatientBSODATA.getDiirecIssueInitData(formBean,request, response);
		
		
		try
		{
		    System.out.println(" ------- IssueToPatientTransBSOCNT.issuetopatientcount  ---- > this.INITVALGO ");
		    this.INITVALGO(mapping, formBean, request, response);
		}
		catch(Exception e)
		{
			System.out.println(" ------- IssueToPatientTransBSOCNT.issuetopatientcount  ---- > this.INITVAL ");
			this.INITVAL(mapping, formBean, request, response);
		}		
		System.out.println(" -C--After INITVALGO ---- target = issueGo --- ");
		target = "issueGoNew";	
		return mapping.findForward(target);
	}
	
	public ActionForward PREV_ISSUE_LIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		generateToken(request);
		String target="";
		IssueTransOFB formBean = (IssueTransOFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		
        System.out.println(" ------- IssueToPatientTransBSOCNT.PREV_ISSUE_LIST  -------- ");        
        System.out.println(" request.getParameter(strStoreId)----- "+request.getParameter("strId"));
        System.out.println(" request.getParameter(getStrCrNo)----- "+request.getParameter("crNo"));
        System.out.println(" request.getParameter(strItemCat)----- "+request.getParameter("itemCategory"));                
    	System.out.println(" formBean.getStrCrNo()           ----- "+formBean.getStrCrNo());
		System.out.println(" formBean.getStrStoreId          ----- "+formBean.getStrStoreId());
		System.out.println(" formBean.getStrItemCat()        ----- "+formBean.getStrItemCat());
        
		boolean fRes = IssueToPatientBSODATA.patientDetailNEW(formBean, request);
		
		System.out.println("-----fRes---------"+fRes);
		
		if(fRes)
		{					
				 System.out.println("-----List of ALL Drugs -------[ prev_pat_ipd_issue_list.jsp , issue_transBSO.js ]  ------------");				
				 target = "prev_issue";			     				
		}
		else
		{
			this.INITVAL(mapping, formBean, request, response);
		}	
		return mapping.findForward(target);
	}
	
	public ActionForward INITVALGO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
    {
		System.out.println(" ------- IssueToPatientTransBSOCNT.INITVALGO  ----[ issue_trans_goNew.jsp ]--- ");
		
		generateToken(request);
		String target="";
		IssueTransOFB formBean = (IssueTransOFB) form;
		if(formBean.getNewreqflg().equalsIgnoreCase("1"))
		{
			formBean.setStrCrNo(formBean.getCrNo());
		}
		
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		try
		{				
	        IssueToPatientBSODATA.getPatientDetails(formBean, request, response);
		}
		catch(Exception e)
		{
			System.out.println("--B-IN OUT---Err_Msg--"+formBean.getStrErrMsg());
			return this.INITVAL(mapping,formBean,request,response);
			
			
		}
	    formBean.setCrNo(formBean.getStrCrNo());
	    formBean.setStrStoreId(formBean.getStrStoreId());
	    formBean.setItemCategory(formBean.getStrItemCat());
		if(formBean.getStrInvalidCrFlag().equals("1") || formBean.getStrInvalidLFFlag().equals("1") || formBean.getStrInvalidLFFlag().equals("2"))
		{
			
			return this.INITVAL(mapping,formBean,request,response);
			
		}
		else
		{
			
			IssueToPatientBSODATA.getOnlineReqDtl(formBean, request, response);
			IssueToPatientBSODATA.getDeptDetails(formBean, request);
			
			IssueToPatientBSODATA.getFrequencyDetails(formBean, request);
			IssueToPatientBSODATA.getDoseDetails(formBean, request);
			if(!formBean.getStrIssueMode().equals("0")){
			
				IssueToPatientBSODATA.getGroupDetails(formBean, request);
				
			}
			if(formBean.getStrCRorLFwise().equals("2"))
			{
				System.out.println(" ---A---- target = issueGoLFWise --- ");
				
				target = "issueGoLFWise";
				
			}
			else
			{
				System.out.println(" ---B---- target = issueGo --- ");
			    target = "issueGo";   
			}
			return mapping.findForward(target);
		}
	
	}
	
	public ActionForward INSERTDIRECTISSUE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
    {
		System.out.println(" ------- IssueToPatientTransBSOCNT.INSERTDIRECTISSUE  ------- ");
		String strtarget =
				
		validateToken(request, response);
		IssueTransOFB formBean = (IssueTransOFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBSODATA.insertDirectIssue(formBean, request);			
        if(!formBean.getStrIssueNo().equals("0"))
        {
		   System.out.println("<<<--------------IssueToPatientTransBSOCNT . afterIssueSave() -- [ issue_VoucherNewO.jsp ]-------------->>>");		
		   IssueToPatientBSODATA.afterIssueSave(formBean, request);
		   strtarget = "voucher";
        }
        else
        {
        	return this.INITVAL(mapping, formBean, request, response);
        }
		
		return mapping.findForward(strtarget);
		
	 }
	
	public ActionForward REPEAT_ISSUE_INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
    {
		System.out.println(" ------- IssueToPatientTransBSOCNT.REPEAT_ISSUE_INSERT  ------- ");
		
		validateToken(request, response);
		IssueTransOFB formBean = (IssueTransOFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBSODATA.REPEAT_ISSUE_INSERT(formBean, request);			
        
		System.out.println("<<<--------------IssueToPatientTransBSOCNT . afterIssueSave() -- [ issue_VoucherNewO.jsp ]-------------->>>");		
		IssueToPatientBSODATA.afterIssueSave(formBean, request);
		String strtarget = "voucher";
		return mapping.findForward(strtarget);
		
	 }
	
	/*
	 * To Get the Cancel Page
	 */
	
	public ActionForward GETCANCELPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {	
		System.out.println(" ------- IssueToPatientTransBSOCNT.GETCANCELPAGE  ------- ");
		
		IssueTransOFB formBean = (IssueTransOFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		IssueToPatientBSODATA.getStoreDtls(formBean, request);		
		String target = "cancelIssue";
		return mapping.findForward(target);
	} 
	
	/*
	 * To Get the Item Category Combo
	 */
	
	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println(" ------- IssueToPatientTransBSOCNT.ITEMCATCMB  ------- ");
		IssueTransOFB formBean = (IssueTransOFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		IssueToPatientBSODATA.getItemCatDtls(formBean,request, response);
		
		return null;
	}
	
	public ActionForward GET_PAT_ACC_STATUS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println(" ------- IssueToPatientTransBSOCNT.GET_PAT_ACC_STATUS  --[ After Go Click Check Account Status ]----- ");
		IssueTransOFB formBean = (IssueTransOFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		IssueToPatientBSODATA.GET_PAT_ACC_STATUS(formBean,request, response);
		
		return null;
	}

	
	
	
	
	public ActionForward INITCANCELGO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		    IssueTransOFB formBean = (IssueTransOFB) form;
		    formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		    formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		    IssueToPatientBSODATA.getCancelPatientDetails(formBean, request, response);		
			
			String target = "cancelGo";
			return mapping.findForward(target);
		
	
	}
	
	public ActionForward PREVISSUEDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		System.out.println(" ------- IssueToPatientTransBSOCNT.PREVISSUEDTL  ------- ");
		
		IssueTransOFB formBean = (IssueTransOFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBSODATA.getIssueDetails(formBean, request, response);
		return null;
	}
	//voucher 
	public ActionForward ISSUEDTLPOPUP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
    {
		System.out.println(" ------- IssueToPatientTransBSOCNT.ISSUEDTLPOPUP  ------- ");
     
		IssueTransOFB formBean = (IssueTransOFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBSODATA.getIssuePopUp(formBean, request, response);
		return null;
	 }
	
	public ActionForward REQUESTDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ------- IssueToPatientTransBSOCNT.REQUESTDTLS  ------- ");
		
		IssueTransOFB formBean = (IssueTransOFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBSODATA.getRequestDetails(formBean, request, response);
		return null;
	}
	
	public ActionForward UNITCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ------- IssueToPatientTransBSOCNT.UNITCMB  ------- ");
		IssueTransOFB formBean = (IssueTransOFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBSODATA.getUnitDetails(formBean, request, response);
		return null;
	}
	
	public ActionForward PRESCRIPEDBY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ------- IssueToPatientTransBSOCNT.PRESCRIPEDBY  ------- ");
		
		IssueTransOFB formBean = (IssueTransOFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBSODATA.getPrescribedBy(formBean, request, response);
		return null;
	}
	
	public ActionForward ITEMDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ------- IssueToPatientTransBSOCNT.ITEMDETAILS  ------- ");
		
		IssueTransOFB formBean = (IssueTransOFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBSODATA.getItemDetails(formBean, request, response);
		return null;
	}
	
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, Exception 
   {
		System.out.println(" ------- IssueToPatientTransBSOCNT.INSERT  ------- ");
		
		validateToken(request, response);
		IssueTransOFB formBean = (IssueTransOFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBSODATA.insert(formBean, request);			
	//	this.ISSUEDTLPOPUP(mapping,form,request,response);
		//formBean.setPrintReq("1");
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
	
	public ActionForward INSERTTEMP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
   {
		System.out.println(" ------- IssueToPatientTransBSOCNT.INSERTTEMP  ------- ");
		
		validateToken(request, response);
		IssueTransOFB formBean = (IssueTransOFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBSODATA.inserttemp(formBean, request);			
	//	this.ISSUEDTLPOPUP(mapping,form,request,response);
		formBean.setPrintReq("0");
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
	
	public ActionForward INSERTIPD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
   {
		System.out.println(" ------- IssueToPatientTransBSOCNT.INSERTIPD  ------- ");
		
		validateToken(request, response);
		IssueTransOFB formBean = (IssueTransOFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBSODATA.insertipd(formBean, request);			
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
     
		System.out.println(" ------- IssueToPatientTransBSOCNT.INSERTCANCEL  ------- ");
		
		IssueTransOFB formBean = (IssueTransOFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBSODATA.insertCancel(formBean, request);			
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
     
		System.out.println(" ------- IssueToPatientTransBSOCNT.withOrWithoutCrNo  ------- ");
		IssueTransOFB formBean = (IssueTransOFB) form;
		//IssueToPatientBSODATA.getMmsConfigFlags(formBean, request,	response);
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
					IssueToPatientBSODATA.getStoreDtls(formBean, request);
					IssueToPatientBSODATA.getGenderCombo(formBean, request);
					
					/*
					IssueToPatientBSODATA.getDeptDetails(formBean, request);
					IssueToPatientBSODATA.getFrequencyDetails(formBean, request);					
					IssueToPatientBSODATA.getFrequencyDetails(formBean, request);
					IssueToPatientBSODATA.getDoseDetails(formBean, request);
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
     
		System.out.println(" ------- IssueToPatientTransBSOCNT.INITVALWITHOUTCRNO  ------- ");
		IssueTransOFB formBean = (IssueTransOFB) form;
		IssueToPatientBSODATA.getMmsConfigFlags(formBean, request,	response);
		
		String strMode = request.getParameter("mode");
		if(strMode == null) strMode = "0";
		formBean.setStrIssueMode(strMode);		          
					
					formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					formBean.setStrWithoutCrNoCheckBox("1");
					IssueToPatientBSODATA.getStoreDtls(formBean, request);
					//IssueToPatientBSODATA.getDeptDetails(formBean, request);
					//IssueToPatientBSODATA.getFrequencyDetails(formBean, request);
					//IssueToPatientBSODATA.getDoseDetails(formBean, request);
					IssueToPatientBSODATA.getGenderCombo(formBean, request);
					//IssueToPatientBSODATA.getFrequencyDetails(formBean, request);
					//IssueToPatientBSODATA.getDoseDetails(formBean, request);
					
					String target = "issueGoWithoutCrNo";
					return mapping.findForward(target);	
					
	}
	
	public ActionForward INSERTWithoutCrNo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {    
		System.out.println(" ------- IssueToPatientTransBSOCNT.INSERTWithoutCrNo  ------- ");
		IssueTransOFB formBean = (IssueTransOFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		IssueToPatientBSODATA.insertWithoutCrNo(formBean, request);
		
		/*
		if(formBean.getStrVisitDtl().equals("0"))
		{
			return this.INITVALWITHOUTCRNO(mapping, form, request, response);
		}
		else
		{
			return this.INITVALWITHOUTCRNO(mapping, form, request, response);
		}
		*/
		
		return this.INITVALWITHOUTCRNO(mapping, form, request, response);
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

		IssueTransOFB formBean = (IssueTransOFB) form;
		IssueToPatientBSODATA.issueDtlsInit(request, response, formBean);
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

		System.out.println(" ------- IssueToPatientTransBSOCNT.ISSUEDTLSINITONE  ------- ");
		
		IssueTransOFB formBean = (IssueTransOFB) form;
		IssueToPatientBSODATA.issueDtlsInit(request, response, formBean);
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
		System.out.println(" ------- IssueToPatientTransBSOCNT.VIEWPAGE  ------- ");
		
		String strTarget="view";
		IssueTransOFB formBean = (IssueTransOFB) form;
		//formBean.setStrflg("0");
		generateToken(request);
		IssueToPatientBSODATA.getMmsConfigFlags(formBean, request,	response);
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrCrNo(formBean.getStrCrNo());
				
		IssueToPatientBSODATA.getStoreDtlsView(formBean, request);
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
		System.out.println(" ------- IssueToPatientTransBSOCNT.GOVIEWPAGE  ------- ");
			
		IssueTransOFB fb = (IssueTransOFB) form;
		IssueToPatientBSODATA.getViewDtl(fb, request, response);
		return null;
	}
	
	public ActionForward RETURNTOMAINDESK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println(" ------- IssueToPatientTransBSOCNT.RETURNTOMAINDESK  ------- ");
		
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
		System.out.println(" ------- IssueToPatientTransBSOCNT.ISSUEDTLSBILLED  ------- ");
			
		IssueTransOFB fb = (IssueTransOFB) form;
		IssueToPatientBSODATA.getBilledItemDtls(fb, request, response);
		return null;
	}
	
	public ActionForward SAVE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws HisException, SQLException
	{
		System.out.println(" ------- IssueToPatientTransBSOCNT.SAVE  ------- ");
			
		IssueTransOFB fb = (IssueTransOFB) form;
		IssueToPatientBSODATA.save(fb, request, response);
		//fb.setStrflg("0");
		/*ActionForward acFwd = new ActionForward();
		String strPath = "/mms/transactions/MmsCNT.cnt?hmode=ISSUEDTLSINIT&strMode=1&strStoreId="+fb.getStrStoreId()+"&strIssueNo="+fb.getStrHlpIssueNo()+"&strIndentNo=0&strIndentDate=0"; //VIEWPAGE
		acFwd.setPath(strPath);
	    acFwd.setContextRelative(true);
		return acFwd;*/
		fb.setStrCrNo(fb.getCrNo());
		fb.setStrflg("10");
		return this.VIEWPAGE(mapping, form, request, response);
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
			
		System.out.println(" ------- IssueToPatientTransBSOCNT.DELETEISSUEDETAILS  ------- ");
		IssueTransOFB fb = (IssueTransOFB) form;
		IssueToPatientBSODATA.deleteIssueDtls(fb, request, response);
		return null;
	}
	//issueGoNew jsp page save btn hit >> checkEpidoseData() > resp m DirectIssue() called 
	public ActionForward TARIFFCHK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- IssueToPatientTransBSOCNT.TARIFFCHK  ------- ");
		
		IssueTransOFB fb = (IssueTransOFB) form;
		IssueToPatientBSODATA.getTariffDtl(fb, request, response);
		return null;
	}
	
	//issueGoNew jsp page save btn hit 
	public ActionForward ALREADYISSUEDRUG(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- IssueToPatientTransBSOCNT.ALREADYISSUEDRUG  ------- ");
		
		IssueTransOFB fb = (IssueTransOFB) form;
		IssueToPatientBSODATA.getAlreadyIssueDrug(fb, request, response);
		return null;
	}
	
	public ActionForward GETREQTYPE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- IssueToPatientTransBSOCNT.GETREQTYPE  ------- ");
		
		IssueTransOFB fb = (IssueTransOFB) form;
		IssueToPatientBSODATA.getReqType(fb, request, response);
		return null;
	}
	
	
	
	

	public ActionForward EPISODEDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- IssueToPatientTransBSOCNT.EPISODEDTLS  ------- ");
		
		IssueTransOFB fb = (IssueTransOFB) form;
		IssueToPatientBSODATA.getEpisodeDtl(fb, request, response);
		return null;
	}

	public ActionForward PRESFORMDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- IssueToPatientTransBSOCNT.PRESFORMDTLS  ------- ");
		IssueTransOFB fb = (IssueTransOFB) form;
		IssueToPatientBSODATA.getPresFormDtl(fb, request, response);
		return null;
	}
	
	public ActionForward GETPRESCDATA(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- IssueToPatientTransBSOCNT.GETPRESCDATA  ------- ");
		
		IssueTransOFB formBean = (IssueTransOFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		IssueToPatientBSODATA.getOnlineTreatmentDtl(formBean, request, response);
		return null;
	}
	
	public ActionForward GETVIEWPAGE(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println(" ------- IssueToPatientTransBSOCNT.GETVIEWPAGE  ------- ");		
		String strTarget="view";		
		IssueTransOFB fb = (IssueTransOFB) form;
		IssueToPatientBSODATA.initViewPageDtl(fb,request);
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
	// view page go button hit
	public ActionForward GETCRDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		IssueTransOFB fb = (IssueTransOFB) form;
		IssueToPatientBSODATA.getViewDtlNEW(fb, request, response);
		return null;
	}
	

}
