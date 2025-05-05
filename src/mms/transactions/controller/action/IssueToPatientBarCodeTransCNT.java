package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.IssueToPatientBarCodeTransDATA;
import mms.transactions.controller.fb.IssueToPatientBarCodeTransFB;

public class IssueToPatientBarCodeTransCNT extends CSRFGardTokenAction {
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		generateToken(request);
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
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
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.INITVAL  ----[issue_BarCodeTrans.jsp ]---- ");
		
		generateToken(request);
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		//formBean.setStrCrNoDefault("1");
		formBean.setStrDoseFrqFlg("0");
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		
		formBean.setStrStoreId(request.getParameter("strStoreId"));
		formBean.setStrId(request.getParameter("strStoreId"));		
		IssueToPatientBarCodeTransDATA.getStoreDtls(formBean, request);
		
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.INITVAL  ---CR_NO--- "+request.getParameter("patCrNo"));
		
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
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		
		
		
        System.out.println(" ------- IssueToPatientBarCodeTransCNT.ISSUETOPATCOUNT  ----[issue_BarCodeTrans_Go.jsp]---- ");
        
        System.out.println(" request.getParameter(strStoreId)----- "+request.getParameter("strId"));
        System.out.println(" request.getParameter(getStrCrNo)----- "+request.getParameter("crNo"));                
    	System.out.println(" formBean.getStrCrNo()           ----- "+formBean.getStrCrNo());
		System.out.println(" formBean.getStrStoreId          ----- "+formBean.getStrStoreId());
		
        
		System.out.println(" ------- IssueToPatientBarCodeTransDATA.getDiirecIssueInitData -(Drug Finder Combo)----- ");
		
		IssueToPatientBarCodeTransDATA.getDiirecIssueInitData(formBean,request, response);
		
		
		try
		{
		    System.out.println(" ------- IssueToPatientBarCodeTransCNT.issuetopatientcount  ---- > this.INITVALGO ");
		    this.INITVALGO(mapping, formBean, request, response);
		}
		catch(Exception e)
		{
			System.out.println(" ------- IssueToPatientBarCodeTransCNT.issuetopatientcount  ---- > this.INITVAL ");
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
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		
        System.out.println(" ------- IssueToPatientBarCodeTransCNT.PREV_ISSUE_LIST  -------- ");        
        System.out.println(" request.getParameter(strStoreId)----- "+request.getParameter("strId"));
        System.out.println(" request.getParameter(getStrCrNo)----- "+request.getParameter("crNo"));
        System.out.println(" request.getParameter(strItemCat)----- "+request.getParameter("itemCategory"));                
    	System.out.println(" formBean.getStrCrNo()           ----- "+formBean.getStrCrNo());
		System.out.println(" formBean.getStrStoreId          ----- "+formBean.getStrStoreId());
		System.out.println(" formBean.getStrItemCat()        ----- "+formBean.getStrItemCat());
        
		boolean fRes = IssueToPatientBarCodeTransDATA.patientDetailNEW(formBean, request);
		
		System.out.println("-----fRes---------"+fRes);
		
		if(fRes)
		{					
				 System.out.println("-----List of ALL Drugs -------[ issue_BarCodeTrans_Prev_Issue.jsp , issue_BarCode.js ]  ------------");				
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
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.INITVALGO  ----[ issue_BarCodeTrans_Go.jsp ]--- ");
		
		generateToken(request);
		String target="";
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		if(formBean.getNewreqflg().equalsIgnoreCase("1"))
		{
			formBean.setStrCrNo(formBean.getCrNo());
		}
		
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		try
		{				
	        IssueToPatientBarCodeTransDATA.getPatientDetails(formBean, request, response);
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
			
			IssueToPatientBarCodeTransDATA.getOnlineReqDtl(formBean, request, response);
			IssueToPatientBarCodeTransDATA.getDeptDetails(formBean, request);
			
			IssueToPatientBarCodeTransDATA.getFrequencyDetails(formBean, request);
			IssueToPatientBarCodeTransDATA.getDoseDetails(formBean, request);
			if(!formBean.getStrIssueMode().equals("0")){
			
				IssueToPatientBarCodeTransDATA.getGroupDetails(formBean, request);
				
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
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.INSERTDIRECTISSUE  ------- ");
		
		validateToken(request, response);
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBarCodeTransDATA.insertDirectIssue(formBean, request);			
        
		System.out.println("<<<--------------IssueToPatientBarCodeTransCNT . afterIssueSave() -- [ issue_BarCodeVoucher.jsp ]-------------->>>");		
		IssueToPatientBarCodeTransDATA.afterIssueSave(formBean, request);
		String strtarget = "voucher";
		return mapping.findForward(strtarget);
		
	 }
	
	public ActionForward REPEAT_ISSUE_INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
    {
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.REPEAT_ISSUE_INSERT  ------- ");
		
		validateToken(request, response);
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBarCodeTransDATA.REPEAT_ISSUE_INSERT(formBean, request);			
        
		System.out.println("<<<--------------IssueToPatientBarCodeTransCNT . afterIssueSave() -- [ issue_BarCodeVoucher.jsp ]-------------->>>");		
		IssueToPatientBarCodeTransDATA.afterIssueSave(formBean, request);
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
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.GETCANCELPAGE  ------- ");
		
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		IssueToPatientBarCodeTransDATA.getStoreDtls(formBean, request);		
		String target = "cancelIssue";
		return mapping.findForward(target);
	} 
	
	/*
	 * To Get the Item Category Combo
	 */
	
	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println(" ------- IssueToPatientBarCodeTransCNT.ITEMCATCMB  ------- ");
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		IssueToPatientBarCodeTransDATA.getItemCatDtls(formBean,request, response);
		
		return null;
	}
	
	public ActionForward GET_PAT_ACC_STATUS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println(" ------- IssueToPatientBarCodeTransCNT.GET_PAT_ACC_STATUS  --[ After Go Click Check Account Status ]----- ");
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		IssueToPatientBarCodeTransDATA.GET_PAT_ACC_STATUS(formBean,request, response);
		
		return null;
	}
	
	public ActionForward GET_BAR_CODE_DTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println(" ------- IssueToPatientBarCodeTransCNT.GET_BAR_CODE_DTL  ------- ");
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		IssueToPatientBarCodeTransDATA.getBarCodeDetails(formBean,request, response);
		
		return null;
	}
	

	
	
	
	
	public ActionForward INITCANCELGO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		    IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		    formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		    formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		    IssueToPatientBarCodeTransDATA.getCancelPatientDetails(formBean, request, response);		
			
			String target = "cancelGo";
			return mapping.findForward(target);
		
	
	}
	
	public ActionForward PREVISSUEDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.PREVISSUEDTL  ------- ");
		
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBarCodeTransDATA.getIssueDetails(formBean, request, response);
		return null;
	}
	//voucher 
	public ActionForward ISSUEDTLPOPUP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
    {
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.ISSUEDTLPOPUP  ------- ");
     
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBarCodeTransDATA.getIssuePopUp(formBean, request, response);
		return null;
	 }
	
	public ActionForward REQUESTDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.REQUESTDTLS  ------- ");
		
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBarCodeTransDATA.getRequestDetails(formBean, request, response);
		return null;
	}
	
	public ActionForward UNITCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.UNITCMB  ------- ");
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBarCodeTransDATA.getUnitDetails(formBean, request, response);
		return null;
	}
	
	public ActionForward PRESCRIPEDBY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.PRESCRIPEDBY  ------- ");
		
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBarCodeTransDATA.getPrescribedBy(formBean, request, response);
		return null;
	}
	
	public ActionForward ITEMDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.ITEMDETAILS  ------- ");
		
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBarCodeTransDATA.getItemDetails(formBean, request, response);
		return null;
	}
	
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, Exception 
   {
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.INSERT  ------- ");
		
		validateToken(request, response);
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBarCodeTransDATA.insert(formBean, request);			
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
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.INSERTTEMP  ------- ");
		
		validateToken(request, response);
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBarCodeTransDATA.inserttemp(formBean, request);			
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
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.INSERTIPD  ------- ");
		
		validateToken(request, response);
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBarCodeTransDATA.insertipd(formBean, request);			
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
     
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.INSERTCANCEL  ------- ");
		
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBarCodeTransDATA.insertCancel(formBean, request);			
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
     
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.withOrWithoutCrNo  ------- ");
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		//IssueToPatientBarCodeTransDATA.getMmsConfigFlags(formBean, request,	response);
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
					IssueToPatientBarCodeTransDATA.getStoreDtls(formBean, request);
					IssueToPatientBarCodeTransDATA.getGenderCombo(formBean, request);
					
					/*
					IssueToPatientBarCodeTransDATA.getDeptDetails(formBean, request);
					IssueToPatientBarCodeTransDATA.getFrequencyDetails(formBean, request);					
					IssueToPatientBarCodeTransDATA.getFrequencyDetails(formBean, request);
					IssueToPatientBarCodeTransDATA.getDoseDetails(formBean, request);
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
     
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.INITVALWITHOUTCRNO  ------- ");
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		IssueToPatientBarCodeTransDATA.getMmsConfigFlags(formBean, request,	response);
		
		String strMode = request.getParameter("mode");
		if(strMode == null) strMode = "0";
		formBean.setStrIssueMode(strMode);		          
					
					formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					formBean.setStrWithoutCrNoCheckBox("1");
					IssueToPatientBarCodeTransDATA.getStoreDtls(formBean, request);
					//IssueToPatientBarCodeTransDATA.getDeptDetails(formBean, request);
					//IssueToPatientBarCodeTransDATA.getFrequencyDetails(formBean, request);
					//IssueToPatientBarCodeTransDATA.getDoseDetails(formBean, request);
					IssueToPatientBarCodeTransDATA.getGenderCombo(formBean, request);
					//IssueToPatientBarCodeTransDATA.getFrequencyDetails(formBean, request);
					//IssueToPatientBarCodeTransDATA.getDoseDetails(formBean, request);
					
					String target = "issueGoWithoutCrNo";
					return mapping.findForward(target);	
					
	}
	
	public ActionForward INSERTWithoutCrNo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {    
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.INSERTWithoutCrNo  ------- ");
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		IssueToPatientBarCodeTransDATA.insertWithoutCrNo(formBean, request);
		
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

		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		IssueToPatientBarCodeTransDATA.issueDtlsInit(request, response, formBean);
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

		System.out.println(" ------- IssueToPatientBarCodeTransCNT.ISSUEDTLSINITONE  ------- ");
		
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		IssueToPatientBarCodeTransDATA.issueDtlsInit(request, response, formBean);
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
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.VIEWPAGE  ------- ");
		
		String strTarget="view";
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		//formBean.setStrflg("0");
		generateToken(request);
		IssueToPatientBarCodeTransDATA.getMmsConfigFlags(formBean, request,	response);
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrCrNo(formBean.getStrCrNo());
				
		IssueToPatientBarCodeTransDATA.getStoreDtlsView(formBean, request);
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
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.GOVIEWPAGE  ------- ");
			
		IssueToPatientBarCodeTransFB fb = (IssueToPatientBarCodeTransFB) form;
		IssueToPatientBarCodeTransDATA.getViewDtl(fb, request, response);
		return null;
	}
	
	public ActionForward RETURNTOMAINDESK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.RETURNTOMAINDESK  ------- ");
		
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
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.ISSUEDTLSBILLED  ------- ");
			
		IssueToPatientBarCodeTransFB fb = (IssueToPatientBarCodeTransFB) form;
		IssueToPatientBarCodeTransDATA.getBilledItemDtls(fb, request, response);
		return null;
	}
	
	public ActionForward SAVE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws HisException, SQLException
	{
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.SAVE  ------- ");
			
		IssueToPatientBarCodeTransFB fb = (IssueToPatientBarCodeTransFB) form;
		IssueToPatientBarCodeTransDATA.save(fb, request, response);
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
			
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.DELETEISSUEDETAILS  ------- ");
		IssueToPatientBarCodeTransFB fb = (IssueToPatientBarCodeTransFB) form;
		IssueToPatientBarCodeTransDATA.deleteIssueDtls(fb, request, response);
		return null;
	}
	//issueGoNew jsp page save btn hit >> checkEpidoseData() > resp m DirectIssue() called 
	public ActionForward TARIFFCHK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.TARIFFCHK  ------- ");
		
		IssueToPatientBarCodeTransFB fb = (IssueToPatientBarCodeTransFB) form;
		IssueToPatientBarCodeTransDATA.getTariffDtl(fb, request, response);
		return null;
	}
	
	//issueGoNew jsp page save btn hit 
	public ActionForward ALREADYISSUEDRUG(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.ALREADYISSUEDRUG  ------- ");
		
		IssueToPatientBarCodeTransFB fb = (IssueToPatientBarCodeTransFB) form;
		IssueToPatientBarCodeTransDATA.getAlreadyIssueDrug(fb, request, response);
		return null;
	}
	
	public ActionForward GETREQTYPE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.GETREQTYPE  ------- ");
		
		IssueToPatientBarCodeTransFB fb = (IssueToPatientBarCodeTransFB) form;
		IssueToPatientBarCodeTransDATA.getReqType(fb, request, response);
		return null;
	}
	
	
	
	

	public ActionForward EPISODEDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.EPISODEDTLS  ------- ");
		
		IssueToPatientBarCodeTransFB fb = (IssueToPatientBarCodeTransFB) form;
		IssueToPatientBarCodeTransDATA.getEpisodeDtl(fb, request, response);
		return null;
	}

	public ActionForward PRESFORMDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.PRESFORMDTLS  ------- ");
		IssueToPatientBarCodeTransFB fb = (IssueToPatientBarCodeTransFB) form;
		IssueToPatientBarCodeTransDATA.getPresFormDtl(fb, request, response);
		return null;
	}
	
	public ActionForward GETPRESCDATA(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.GETPRESCDATA  ------- ");
		
		IssueToPatientBarCodeTransFB formBean = (IssueToPatientBarCodeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		IssueToPatientBarCodeTransDATA.getOnlineTreatmentDtl(formBean, request, response);
		return null;
	}
	
	public ActionForward GETVIEWPAGE(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println(" ------- IssueToPatientBarCodeTransCNT.GETVIEWPAGE  ------- ");		
		String strTarget="view";		
		IssueToPatientBarCodeTransFB fb = (IssueToPatientBarCodeTransFB) form;
		IssueToPatientBarCodeTransDATA.initViewPageDtl(fb,request);
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
			
		IssueToPatientBarCodeTransFB fb = (IssueToPatientBarCodeTransFB) form;
		IssueToPatientBarCodeTransDATA.getViewDtlNEW(fb, request, response);
		return null;
	}
	

}
