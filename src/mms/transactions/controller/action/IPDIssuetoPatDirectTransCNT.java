package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.IPDIssuetoPatDirectTransDATA;
import mms.transactions.controller.fb.IPDIssuetoPatDirectTransFB;

public class IPDIssuetoPatDirectTransCNT extends CSRFGardTokenAction {
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		generateToken(request);
		IPDIssuetoPatDirectTransFB formBean = (IPDIssuetoPatDirectTransFB) form;
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

	public ActionForward INITVAL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {		
		System.out.println(" ------- NewIPDIssueToPatTransCNT.INITVAL  ----[newIPD_IssuePat_Trans.jsp ]---- ");
		
		generateToken(request);
		IPDIssuetoPatDirectTransFB formBean = (IPDIssuetoPatDirectTransFB) form;
		//formBean.setStrCrNoDefault("1");
		formBean.setStrDoseFrqFlg("0");
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		
		formBean.setStrStoreId(request.getParameter("strStoreId"));
		formBean.setStrId(request.getParameter("strStoreId"));		
		IPDIssuetoPatDirectTransDATA.getStoreDtls(formBean, request);
		
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
		IPDIssuetoPatDirectTransFB formBean = (IPDIssuetoPatDirectTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		
		
		
        System.out.println(" ------- NewIPDIssueToPatTransCNT.ISSUETOPATCOUNT  ----[newIPD_IssuePat_Go.jsp , newIPD_Issue.js]---- ");
        
        System.out.println(" request.getParameter(strStoreId)----- "+request.getParameter("strId"));
        System.out.println(" request.getParameter(getStrCrNo)----- "+request.getParameter("crNo"));                
    	System.out.println(" formBean.getStrCrNo()           ----- "+formBean.getStrCrNo());
		System.out.println(" formBean.getStrStoreId          ----- "+formBean.getStrStoreId());
		
        
		System.out.println(" ------- IPDIssuetoPatDirectTransDATA.getDiirecIssueInitData -(Drug Finder Combo)----- ");
		
		IPDIssuetoPatDirectTransDATA.getDiirecIssueInitData(formBean,request, response);
		
		
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
		IPDIssuetoPatDirectTransFB formBean = (IPDIssuetoPatDirectTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		
        System.out.println(" ------- NewIPDIssueToPatTransCNT.PREV_ISSUE_LIST  -------- ");        
        System.out.println(" request.getParameter(strStoreId)----- "+request.getParameter("strId"));
        System.out.println(" request.getParameter(getStrCrNo)----- "+request.getParameter("crNo"));
        System.out.println(" request.getParameter(strItemCat)----- "+request.getParameter("itemCategory"));                
    	System.out.println(" formBean.getStrCrNo()           ----- "+formBean.getStrCrNo());
		System.out.println(" formBean.getStrStoreId          ----- "+formBean.getStrStoreId());
		System.out.println(" formBean.getStrItemCat()        ----- "+formBean.getStrItemCat());
        
		boolean fRes = IPDIssuetoPatDirectTransDATA.patientDetailNEW(formBean, request);
		
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
		IPDIssuetoPatDirectTransFB formBean = (IPDIssuetoPatDirectTransFB) form;
		if(formBean.getNewreqflg().equalsIgnoreCase("1"))
		{
			formBean.setStrCrNo(formBean.getCrNo());
		}
		
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		try
		{				
	        IPDIssuetoPatDirectTransDATA.getPatientDetails(formBean, request, response);
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
			
			IPDIssuetoPatDirectTransDATA.getOnlineReqDtl(formBean, request, response);
			IPDIssuetoPatDirectTransDATA.getDeptDetails(formBean, request);
			
			IPDIssuetoPatDirectTransDATA.getFrequencyDetails(formBean, request);
			IPDIssuetoPatDirectTransDATA.getDoseDetails(formBean, request);
			if(!formBean.getStrIssueMode().equals("0")){
			
				IPDIssuetoPatDirectTransDATA.getGroupDetails(formBean, request);
				
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
		IPDIssuetoPatDirectTransFB formBean = (IPDIssuetoPatDirectTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IPDIssuetoPatDirectTransDATA.insertDirectIssue(formBean, request);			
        
		if(!formBean.getStrIssueNo().equals("0"))
		{
		  System.out.println("<<<--------------NewIPDIssueToPatTransCNT . afterIssueSave() -- [ newIPD_IssuePat_Voucher.jsp ]-------------->>>");		
		
		  IPDIssuetoPatDirectTransDATA.afterIssueSave(formBean, request);
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
		IPDIssuetoPatDirectTransFB formBean = (IPDIssuetoPatDirectTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IPDIssuetoPatDirectTransDATA.REPEAT_ISSUE_INSERT(formBean, request);			
        
		System.out.println("<<<--------------NewIPDIssueToPatTransCNT . afterIssueSave() -- [ issue_BarCodeVoucher.jsp ]-------------->>>");		
		IPDIssuetoPatDirectTransDATA.afterIssueSave(formBean, request);
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
		
		IPDIssuetoPatDirectTransFB formBean = (IPDIssuetoPatDirectTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		IPDIssuetoPatDirectTransDATA.getStoreDtls(formBean, request);		
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
		IPDIssuetoPatDirectTransFB formBean = (IPDIssuetoPatDirectTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		IPDIssuetoPatDirectTransDATA.getItemCatDtls(formBean,request, response);
		
		return null;
	}
	
	public ActionForward GET_PAT_ACC_STATUS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println(" ------- NewIPDIssueToPatTransCNT.GET_PAT_ACC_STATUS  --[ After Go Click Check Account Status ]----- ");
		IPDIssuetoPatDirectTransFB formBean = (IPDIssuetoPatDirectTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		IPDIssuetoPatDirectTransDATA.GET_PAT_ACC_STATUS(formBean,request, response);
		
		return null;
	}

	
	
	
	
	public ActionForward INITCANCELGO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		    IPDIssuetoPatDirectTransFB formBean = (IPDIssuetoPatDirectTransFB) form;
		    formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		    formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		    IPDIssuetoPatDirectTransDATA.getCancelPatientDetails(formBean, request, response);		
			
			String target = "cancelGo";
			return mapping.findForward(target);
		
	
	}
	
	public ActionForward PREVISSUEDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		System.out.println(" ------- NewIPDIssueToPatTransCNT.PREVISSUEDTL  ------- ");
		
		IPDIssuetoPatDirectTransFB formBean = (IPDIssuetoPatDirectTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IPDIssuetoPatDirectTransDATA.getIssueDetails(formBean, request, response);
		return null;
	}
	//voucher 
	public ActionForward ISSUEDTLPOPUP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
    {
		System.out.println(" ------- NewIPDIssueToPatTransCNT.ISSUEDTLPOPUP  ------- ");
     
		IPDIssuetoPatDirectTransFB formBean = (IPDIssuetoPatDirectTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IPDIssuetoPatDirectTransDATA.getIssuePopUp(formBean, request, response);
		return null;
	 }
	
	public ActionForward REQUESTDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ------- NewIPDIssueToPatTransCNT.REQUESTDTLS  ------- ");
		
		IPDIssuetoPatDirectTransFB formBean = (IPDIssuetoPatDirectTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IPDIssuetoPatDirectTransDATA.getRequestDetails(formBean, request, response);
		return null;
	}
	
	public ActionForward UNITCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ------- NewIPDIssueToPatTransCNT.UNITCMB  ------- ");
		IPDIssuetoPatDirectTransFB formBean = (IPDIssuetoPatDirectTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IPDIssuetoPatDirectTransDATA.getUnitDetails(formBean, request, response);
		return null;
	}
	
	public ActionForward PRESCRIPEDBY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ------- NewIPDIssueToPatTransCNT.PRESCRIPEDBY  ------- ");
		
		IPDIssuetoPatDirectTransFB formBean = (IPDIssuetoPatDirectTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IPDIssuetoPatDirectTransDATA.getPrescribedBy(formBean, request, response);
		return null;
	}
	
	public ActionForward ITEMDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ------- NewIPDIssueToPatTransCNT.ITEMDETAILS  ------- ");
		
		IPDIssuetoPatDirectTransFB formBean = (IPDIssuetoPatDirectTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IPDIssuetoPatDirectTransDATA.getItemDetails(formBean, request, response);
		return null;
	}
	
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, Exception 
   {
		System.out.println(" ------- NewIPDIssueToPatTransCNT.INSERT  ------- ");
		
		validateToken(request, response);
		IPDIssuetoPatDirectTransFB formBean = (IPDIssuetoPatDirectTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IPDIssuetoPatDirectTransDATA.insert(formBean, request);			
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
		IPDIssuetoPatDirectTransFB formBean = (IPDIssuetoPatDirectTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IPDIssuetoPatDirectTransDATA.insertipd(formBean, request);			
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
		
		IPDIssuetoPatDirectTransFB formBean = (IPDIssuetoPatDirectTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IPDIssuetoPatDirectTransDATA.insertCancel(formBean, request);			
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
		IPDIssuetoPatDirectTransFB formBean = (IPDIssuetoPatDirectTransFB) form;
		//IPDIssuetoPatDirectTransDATA.getMmsConfigFlags(formBean, request,	response);
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
					IPDIssuetoPatDirectTransDATA.getStoreDtls(formBean, request);
					IPDIssuetoPatDirectTransDATA.getGenderCombo(formBean, request);
					
					/*
					IPDIssuetoPatDirectTransDATA.getDeptDetails(formBean, request);
					IPDIssuetoPatDirectTransDATA.getFrequencyDetails(formBean, request);					
					IPDIssuetoPatDirectTransDATA.getFrequencyDetails(formBean, request);
					IPDIssuetoPatDirectTransDATA.getDoseDetails(formBean, request);
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
		IPDIssuetoPatDirectTransFB formBean = (IPDIssuetoPatDirectTransFB) form;
		IPDIssuetoPatDirectTransDATA.getMmsConfigFlags(formBean, request,	response);
		
		String strMode = request.getParameter("mode");
		if(strMode == null) strMode = "0";
		formBean.setStrIssueMode(strMode);		          
					
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrWithoutCrNoCheckBox("1");
		IPDIssuetoPatDirectTransDATA.getStoreDtls(formBean, request);
		//IPDIssuetoPatDirectTransDATA.getDeptDetails(formBean, request);
		//IPDIssuetoPatDirectTransDATA.getFrequencyDetails(formBean, request);
		//IPDIssuetoPatDirectTransDATA.getDoseDetails(formBean, request);
		IPDIssuetoPatDirectTransDATA.getGenderCombo(formBean, request);
		//IPDIssuetoPatDirectTransDATA.getFrequencyDetails(formBean, request);
		//IPDIssuetoPatDirectTransDATA.getDoseDetails(formBean, request);
		
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

		IPDIssuetoPatDirectTransFB formBean = (IPDIssuetoPatDirectTransFB) form;
		IPDIssuetoPatDirectTransDATA.issueDtlsInit(request, response, formBean);
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
		
		IPDIssuetoPatDirectTransFB formBean = (IPDIssuetoPatDirectTransFB) form;
		IPDIssuetoPatDirectTransDATA.issueDtlsInit(request, response, formBean);
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
		IPDIssuetoPatDirectTransFB formBean = (IPDIssuetoPatDirectTransFB) form;
		//formBean.setStrflg("0");
		generateToken(request);
		IPDIssuetoPatDirectTransDATA.getMmsConfigFlags(formBean, request,	response);
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrCrNo(formBean.getStrCrNo());
				
		IPDIssuetoPatDirectTransDATA.getStoreDtlsView(formBean, request);
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
			
		IPDIssuetoPatDirectTransFB fb = (IPDIssuetoPatDirectTransFB) form;
		IPDIssuetoPatDirectTransDATA.getViewDtl(fb, request, response);
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
			
		IPDIssuetoPatDirectTransFB fb = (IPDIssuetoPatDirectTransFB) form;
		IPDIssuetoPatDirectTransDATA.getBilledItemDtls(fb, request, response);
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
		IPDIssuetoPatDirectTransFB fb = (IPDIssuetoPatDirectTransFB) form;
		IPDIssuetoPatDirectTransDATA.deleteIssueDtls(fb, request, response);
		return null;
	}
	//issueGoNew jsp page save btn hit >> checkEpidoseData() > resp m DirectIssue() called 
	public ActionForward TARIFFCHK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- NewIPDIssueToPatTransCNT.TARIFFCHK  ------- ");
		
		IPDIssuetoPatDirectTransFB fb = (IPDIssuetoPatDirectTransFB) form;
		IPDIssuetoPatDirectTransDATA.getTariffDtl(fb, request, response);
		return null;
	}
	
	//issueGoNew jsp page save btn hit 
	public ActionForward ALREADYISSUEDRUG(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- NewIPDIssueToPatTransCNT.ALREADYISSUEDRUG  ------- ");
		
		IPDIssuetoPatDirectTransFB fb = (IPDIssuetoPatDirectTransFB) form;
		IPDIssuetoPatDirectTransDATA.getAlreadyIssueDrug(fb, request, response);
		return null;
	}
	
	public ActionForward GETREQTYPE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- NewIPDIssueToPatTransCNT.GETREQTYPE  ------- ");
		
		IPDIssuetoPatDirectTransFB fb = (IPDIssuetoPatDirectTransFB) form;
		IPDIssuetoPatDirectTransDATA.getReqType(fb, request, response);
		return null;
	}
	
	
	
	

	public ActionForward EPISODEDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- NewIPDIssueToPatTransCNT.EPISODEDTLS  ------- ");
		
		IPDIssuetoPatDirectTransFB fb = (IPDIssuetoPatDirectTransFB) form;
		IPDIssuetoPatDirectTransDATA.getEpisodeDtl(fb, request, response);
		return null;
	}

	public ActionForward PRESFORMDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- NewIPDIssueToPatTransCNT.PRESFORMDTLS  ------- ");
		IPDIssuetoPatDirectTransFB fb = (IPDIssuetoPatDirectTransFB) form;
		IPDIssuetoPatDirectTransDATA.getPresFormDtl(fb, request, response);
		return null;
	}
	
	public ActionForward GETPRESCDATA(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- NewIPDIssueToPatTransCNT.GETPRESCDATA  ------- ");
		
		IPDIssuetoPatDirectTransFB formBean = (IPDIssuetoPatDirectTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		IPDIssuetoPatDirectTransDATA.getOnlineTreatmentDtl(formBean, request, response);
		return null;
	}
	
	public ActionForward GETVIEWPAGE(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println(" ------- NewIPDIssueToPatTransCNT.GETVIEWPAGE  ---[newIPD_IssuePat_View.jsp]---- ");		
		String strTarget="view";		
		IPDIssuetoPatDirectTransFB fb = (IPDIssuetoPatDirectTransFB) form;
		IPDIssuetoPatDirectTransDATA.initViewPageDtl(fb,request);
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
			
		IPDIssuetoPatDirectTransFB fb = (IPDIssuetoPatDirectTransFB) form;
		IPDIssuetoPatDirectTransDATA.getViewDtlNEW(fb, request, response);
		return null;
	}
	

}