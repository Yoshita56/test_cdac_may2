package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.NewIPDIssueToPatTransDATA;
import mms.transactions.controller.fb.NewIPDIssueToPatTransFB;

public class NewIPDIssueToPatTransCNT extends CSRFGardTokenAction {
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		generateToken(request);
		NewIPDIssueToPatTransFB formBean = (NewIPDIssueToPatTransFB) form;
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
		System.out.println(" ------- NewIPDIssueToPatTransCNT.INITVAL  ----[newIPD_IssuePat_Trans.jsp ]---- ");
		
		generateToken(request);
		NewIPDIssueToPatTransFB formBean = (NewIPDIssueToPatTransFB) form;
		//formBean.setStrCrNoDefault("1");
		formBean.setStrDoseFrqFlg("0");
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		
		formBean.setStrStoreId(request.getParameter("strStoreId"));
		formBean.setStrId(request.getParameter("strStoreId"));		
		NewIPDIssueToPatTransDATA.getStoreDtls(formBean, request);
		
		System.out.println(" ------- NewIPDIssueToPatTransCNT.INITVAL  ---CR_NO--- "+request.getParameter("patCrNo"));
		
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
	
	public ActionForward ISSUETOPATCOUNT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		generateToken(request);
		String target="";
		NewIPDIssueToPatTransFB formBean = (NewIPDIssueToPatTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		
		
		
        System.out.println(" ------- NewIPDIssueToPatTransCNT.ISSUETOPATCOUNT  ----[newIPD_IssuePat_Go.jsp , newIPD_Issue.js]---- ");
        
        System.out.println(" request.getParameter(strStoreId)----- "+request.getParameter("strId"));
        System.out.println(" request.getParameter(getStrCrNo)----- "+request.getParameter("crNo"));                
    	System.out.println(" formBean.getStrCrNo()           ----- "+formBean.getStrCrNo());
		System.out.println(" formBean.getStrStoreId          ----- "+formBean.getStrStoreId());
		
        
		System.out.println(" ------- NewIPDIssueToPatTransDATA.getDiirecIssueInitData -(Drug Finder Combo)----- ");
		
		NewIPDIssueToPatTransDATA.getDiirecIssueInitData(formBean,request, response);
		
		
		try
		{
		    System.out.println(" ------- NewIPDIssueToPatTransCNT.issuetopatientcount  ---- > this.INITVALGO ");
		    this.INITVALGO(mapping, formBean, request, response);
		}
		catch(Exception e)
		{
			System.out.println(" ------- NewIPDIssueToPatTransCNT.issuetopatientcount  ---- > this.INITVAL ");
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
		NewIPDIssueToPatTransFB formBean = (NewIPDIssueToPatTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		
        System.out.println(" ------- NewIPDIssueToPatTransCNT.PREV_ISSUE_LIST  -------- ");        
        System.out.println(" request.getParameter(strStoreId)----- "+request.getParameter("strId"));
        System.out.println(" request.getParameter(getStrCrNo)----- "+request.getParameter("crNo"));
        System.out.println(" request.getParameter(strItemCat)----- "+request.getParameter("itemCategory"));                
    	System.out.println(" formBean.getStrCrNo()           ----- "+formBean.getStrCrNo());
		System.out.println(" formBean.getStrStoreId          ----- "+formBean.getStrStoreId());
		System.out.println(" formBean.getStrItemCat()        ----- "+formBean.getStrItemCat());
        
		boolean fRes = NewIPDIssueToPatTransDATA.patientDetailNEW(formBean, request);
		
		System.out.println("-----fRes---------"+fRes);
		
		if(fRes)
		{					
				 System.out.println("-----List of ALL Drugs -------[ newIPD_IssuePat_Prev_Issue.jsp , issue_BarCode.js ]  ------------");				
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
		System.out.println(" ------- NewIPDIssueToPatTransCNT.INITVALGO  ----[ newIPD_IssuePat_Go.jsp ]--- ");
		
		generateToken(request);
		String target="";
		NewIPDIssueToPatTransFB formBean = (NewIPDIssueToPatTransFB) form;
		if(formBean.getNewreqflg().equalsIgnoreCase("1"))
		{
			formBean.setStrCrNo(formBean.getCrNo());
		}
		
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		try
		{				
	        NewIPDIssueToPatTransDATA.getPatientDetails(formBean, request, response);
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
			
			NewIPDIssueToPatTransDATA.getOnlineReqDtl(formBean, request, response);
			NewIPDIssueToPatTransDATA.getDeptDetails(formBean, request);
			
			NewIPDIssueToPatTransDATA.getFrequencyDetails(formBean, request);
			NewIPDIssueToPatTransDATA.getDoseDetails(formBean, request);
			if(!formBean.getStrIssueMode().equals("0")){
			
				NewIPDIssueToPatTransDATA.getGroupDetails(formBean, request);
				
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
		System.out.println(" ------- NewIPDIssueToPatTransCNT.INSERTDIRECTISSUE  ------- ");
		String strtarget = "";
		validateToken(request, response);
		NewIPDIssueToPatTransFB formBean = (NewIPDIssueToPatTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		NewIPDIssueToPatTransDATA.insertDirectIssue(formBean, request);			
        
		if(!formBean.getStrIssueNo().equals("0"))
		{
		  System.out.println("<<<--------------NewIPDIssueToPatTransCNT . afterIssueSave() -- [ newIPD_IssuePat_Voucher.jsp ]-------------->>>");		
		
		  NewIPDIssueToPatTransDATA.afterIssueSave(formBean, request);
		}
		strtarget = "voucher";
       
		return mapping.findForward(strtarget);
		
	 }
	
	public ActionForward REPEAT_ISSUE_INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
    {
		System.out.println(" ------- NewIPDIssueToPatTransCNT.REPEAT_ISSUE_INSERT  ------- ");
		
		validateToken(request, response);
		NewIPDIssueToPatTransFB formBean = (NewIPDIssueToPatTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		NewIPDIssueToPatTransDATA.REPEAT_ISSUE_INSERT(formBean, request);			
        
		System.out.println("<<<--------------NewIPDIssueToPatTransCNT . afterIssueSave() -- [ issue_BarCodeVoucher.jsp ]-------------->>>");		
		NewIPDIssueToPatTransDATA.afterIssueSave(formBean, request);
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
		System.out.println(" ------- NewIPDIssueToPatTransCNT.GETCANCELPAGE  ------- ");
		
		NewIPDIssueToPatTransFB formBean = (NewIPDIssueToPatTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		NewIPDIssueToPatTransDATA.getStoreDtls(formBean, request);		
		String target = "cancelIssue";
		return mapping.findForward(target);
	} 
	
	/*
	 * To Get the Item Category Combo
	 */
	
	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println(" ------- NewIPDIssueToPatTransCNT.ITEMCATCMB  ------- ");
		NewIPDIssueToPatTransFB formBean = (NewIPDIssueToPatTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		NewIPDIssueToPatTransDATA.getItemCatDtls(formBean,request, response);
		
		return null;
	}
	
	public ActionForward GET_PAT_ACC_STATUS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println(" ------- NewIPDIssueToPatTransCNT.GET_PAT_ACC_STATUS  --[ After Go Click Check Account Status ]----- ");
		NewIPDIssueToPatTransFB formBean = (NewIPDIssueToPatTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		NewIPDIssueToPatTransDATA.GET_PAT_ACC_STATUS(formBean,request, response);
		
		return null;
	}

	
	
	
	
	public ActionForward INITCANCELGO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		    NewIPDIssueToPatTransFB formBean = (NewIPDIssueToPatTransFB) form;
		    formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		    formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		    NewIPDIssueToPatTransDATA.getCancelPatientDetails(formBean, request, response);		
			
			String target = "cancelGo";
			return mapping.findForward(target);
		
	
	}
	
	public ActionForward PREVISSUEDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		System.out.println(" ------- NewIPDIssueToPatTransCNT.PREVISSUEDTL  ------- ");
		
		NewIPDIssueToPatTransFB formBean = (NewIPDIssueToPatTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		NewIPDIssueToPatTransDATA.getIssueDetails(formBean, request, response);
		return null;
	}
	//voucher 
	public ActionForward ISSUEDTLPOPUP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
    {
		System.out.println(" ------- NewIPDIssueToPatTransCNT.ISSUEDTLPOPUP  ------- ");
     
		NewIPDIssueToPatTransFB formBean = (NewIPDIssueToPatTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		NewIPDIssueToPatTransDATA.getIssuePopUp(formBean, request, response);
		return null;
	 }
	
	public ActionForward REQUESTDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ------- NewIPDIssueToPatTransCNT.REQUESTDTLS  ------- ");
		
		NewIPDIssueToPatTransFB formBean = (NewIPDIssueToPatTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		NewIPDIssueToPatTransDATA.getRequestDetails(formBean, request, response);
		return null;
	}
	
	public ActionForward UNITCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ------- NewIPDIssueToPatTransCNT.UNITCMB  ------- ");
		NewIPDIssueToPatTransFB formBean = (NewIPDIssueToPatTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		NewIPDIssueToPatTransDATA.getUnitDetails(formBean, request, response);
		return null;
	}
	
	public ActionForward PRESCRIPEDBY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ------- NewIPDIssueToPatTransCNT.PRESCRIPEDBY  ------- ");
		
		NewIPDIssueToPatTransFB formBean = (NewIPDIssueToPatTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		NewIPDIssueToPatTransDATA.getPrescribedBy(formBean, request, response);
		return null;
	}
	
	public ActionForward ITEMDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ------- NewIPDIssueToPatTransCNT.ITEMDETAILS  ------- ");
		
		NewIPDIssueToPatTransFB formBean = (NewIPDIssueToPatTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		NewIPDIssueToPatTransDATA.getItemDetails(formBean, request, response);
		return null;
	}
	
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, Exception 
   {
		System.out.println(" ------- NewIPDIssueToPatTransCNT.INSERT  ------- ");
		
		validateToken(request, response);
		NewIPDIssueToPatTransFB formBean = (NewIPDIssueToPatTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		NewIPDIssueToPatTransDATA.insert(formBean, request);			
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
	
	
	public ActionForward INSERTIPD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
   {
		System.out.println(" ------- NewIPDIssueToPatTransCNT.INSERTIPD  ------- ");
		
		validateToken(request, response);
		NewIPDIssueToPatTransFB formBean = (NewIPDIssueToPatTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		NewIPDIssueToPatTransDATA.insertipd(formBean, request);			
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
     
		System.out.println(" ------- NewIPDIssueToPatTransCNT.INSERTCANCEL  ------- ");
		
		NewIPDIssueToPatTransFB formBean = (NewIPDIssueToPatTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		NewIPDIssueToPatTransDATA.insertCancel(formBean, request);			
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
     
		System.out.println(" ------- NewIPDIssueToPatTransCNT.withOrWithoutCrNo  ------- ");
		NewIPDIssueToPatTransFB formBean = (NewIPDIssueToPatTransFB) form;
		//NewIPDIssueToPatTransDATA.getMmsConfigFlags(formBean, request,	response);
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
					NewIPDIssueToPatTransDATA.getStoreDtls(formBean, request);
					NewIPDIssueToPatTransDATA.getGenderCombo(formBean, request);
					
					/*
					NewIPDIssueToPatTransDATA.getDeptDetails(formBean, request);
					NewIPDIssueToPatTransDATA.getFrequencyDetails(formBean, request);					
					NewIPDIssueToPatTransDATA.getFrequencyDetails(formBean, request);
					NewIPDIssueToPatTransDATA.getDoseDetails(formBean, request);
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
     
		System.out.println(" ------- NewIPDIssueToPatTransCNT.INITVALWITHOUTCRNO  ------- ");
		NewIPDIssueToPatTransFB formBean = (NewIPDIssueToPatTransFB) form;
		NewIPDIssueToPatTransDATA.getMmsConfigFlags(formBean, request,	response);
		
		String strMode = request.getParameter("mode");
		if(strMode == null) strMode = "0";
		formBean.setStrIssueMode(strMode);		          
					
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrWithoutCrNoCheckBox("1");
		NewIPDIssueToPatTransDATA.getStoreDtls(formBean, request);
		//NewIPDIssueToPatTransDATA.getDeptDetails(formBean, request);
		//NewIPDIssueToPatTransDATA.getFrequencyDetails(formBean, request);
		//NewIPDIssueToPatTransDATA.getDoseDetails(formBean, request);
		NewIPDIssueToPatTransDATA.getGenderCombo(formBean, request);
		//NewIPDIssueToPatTransDATA.getFrequencyDetails(formBean, request);
		//NewIPDIssueToPatTransDATA.getDoseDetails(formBean, request);
		
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

		NewIPDIssueToPatTransFB formBean = (NewIPDIssueToPatTransFB) form;
		NewIPDIssueToPatTransDATA.issueDtlsInit(request, response, formBean);
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

		System.out.println(" ------- NewIPDIssueToPatTransCNT.ISSUEDTLSINITONE  ------- ");
		
		NewIPDIssueToPatTransFB formBean = (NewIPDIssueToPatTransFB) form;
		NewIPDIssueToPatTransDATA.issueDtlsInit(request, response, formBean);
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
		System.out.println(" ------- NewIPDIssueToPatTransCNT.VIEWPAGE  ------- ");
		
		String strTarget="view";
		NewIPDIssueToPatTransFB formBean = (NewIPDIssueToPatTransFB) form;
		//formBean.setStrflg("0");
		generateToken(request);
		NewIPDIssueToPatTransDATA.getMmsConfigFlags(formBean, request,	response);
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrCrNo(formBean.getStrCrNo());
				
		NewIPDIssueToPatTransDATA.getStoreDtlsView(formBean, request);
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
		System.out.println(" ------- NewIPDIssueToPatTransCNT.GOVIEWPAGE  ------- ");
			
		NewIPDIssueToPatTransFB fb = (NewIPDIssueToPatTransFB) form;
		NewIPDIssueToPatTransDATA.getViewDtl(fb, request, response);
		return null;
	}
	
	public ActionForward RETURNTOMAINDESK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println(" ------- NewIPDIssueToPatTransCNT.RETURNTOMAINDESK  ------- ");
		
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
		System.out.println(" ------- NewIPDIssueToPatTransCNT.ISSUEDTLSBILLED  ------- ");
			
		NewIPDIssueToPatTransFB fb = (NewIPDIssueToPatTransFB) form;
		NewIPDIssueToPatTransDATA.getBilledItemDtls(fb, request, response);
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
			
		System.out.println(" ------- NewIPDIssueToPatTransCNT.DELETEISSUEDETAILS  ------- ");
		NewIPDIssueToPatTransFB fb = (NewIPDIssueToPatTransFB) form;
		NewIPDIssueToPatTransDATA.deleteIssueDtls(fb, request, response);
		return null;
	}
	//issueGoNew jsp page save btn hit >> checkEpidoseData() > resp m DirectIssue() called 
	public ActionForward TARIFFCHK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- NewIPDIssueToPatTransCNT.TARIFFCHK  ------- ");
		
		NewIPDIssueToPatTransFB fb = (NewIPDIssueToPatTransFB) form;
		NewIPDIssueToPatTransDATA.getTariffDtl(fb, request, response);
		return null;
	}
	
	//issueGoNew jsp page save btn hit 
	public ActionForward ALREADYISSUEDRUG(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- NewIPDIssueToPatTransCNT.ALREADYISSUEDRUG  ------- ");
		
		NewIPDIssueToPatTransFB fb = (NewIPDIssueToPatTransFB) form;
		NewIPDIssueToPatTransDATA.getAlreadyIssueDrug(fb, request, response);
		return null;
	}
	
	public ActionForward GETREQTYPE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- NewIPDIssueToPatTransCNT.GETREQTYPE  ------- ");
		
		NewIPDIssueToPatTransFB fb = (NewIPDIssueToPatTransFB) form;
		NewIPDIssueToPatTransDATA.getReqType(fb, request, response);
		return null;
	}
	
	
	
	

	public ActionForward EPISODEDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- NewIPDIssueToPatTransCNT.EPISODEDTLS  ------- ");
		
		NewIPDIssueToPatTransFB fb = (NewIPDIssueToPatTransFB) form;
		NewIPDIssueToPatTransDATA.getEpisodeDtl(fb, request, response);
		return null;
	}

	public ActionForward PRESFORMDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- NewIPDIssueToPatTransCNT.PRESFORMDTLS  ------- ");
		NewIPDIssueToPatTransFB fb = (NewIPDIssueToPatTransFB) form;
		NewIPDIssueToPatTransDATA.getPresFormDtl(fb, request, response);
		return null;
	}
	
	public ActionForward GETPRESCDATA(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- NewIPDIssueToPatTransCNT.GETPRESCDATA  ------- ");
		
		NewIPDIssueToPatTransFB formBean = (NewIPDIssueToPatTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		NewIPDIssueToPatTransDATA.getOnlineTreatmentDtl(formBean, request, response);
		return null;
	}
	
	public ActionForward GETVIEWPAGE(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println(" ------- NewIPDIssueToPatTransCNT.GETVIEWPAGE  ---[newIPD_IssuePat_View.jsp]---- ");		
		String strTarget="view";		
		NewIPDIssueToPatTransFB fb = (NewIPDIssueToPatTransFB) form;
		NewIPDIssueToPatTransDATA.initViewPageDtl(fb,request);
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
			
		NewIPDIssueToPatTransFB fb = (NewIPDIssueToPatTransFB) form;
		NewIPDIssueToPatTransDATA.getViewDtlNEW(fb, request, response);
		return null;
	}
	

}