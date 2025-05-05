package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.AdvanceRequestTransDATA;
import mms.transactions.controller.fb.AdvanceRequestTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class AdvanceRequestTransCNT extends DispatchAction{
	
	/* (non-Javadoc)
	 * @see org.apache.struts.actions.DispatchAction#unspecified
	 * (org.apache.struts.action.ActionMapping,
	 *  org.apache.struts.action.ActionForm, 
	 *  javax.servlet.http.HttpServletRequest, 
	 *  javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		AdvanceRequestTransFB formBean = (AdvanceRequestTransFB) form;
		if(formBean.getStrChkAdvanceReq().equals("1")){
			
			return this.NEW(mapping, formBean, request, response);
		}else{
			return this.DUPLICATE(mapping, formBean, request, response);
		}
		
	}
	
	public ActionForward NEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		AdvanceRequestTransFB formBean = (AdvanceRequestTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		AdvanceRequestTransDATA.getStoreDtls(formBean);
		
 
		if(formBean.getPonovalue()!= null && !formBean.getPonovalue().equals("0") 
			&& !formBean.getPonovalue().equals("")){
	 
			AdvanceRequestTransDATA.getPODetails(formBean,request);
			
		}
		
		if(!formBean.getStrId().equals("0") && !formBean.getItemCategory().equals("0")
				&& !formBean.getPonovalue().equals("0")){
			
			AdvanceRequestTransDATA.getNewReqDetails(formBean, request);
			
		}
		String target = "newindex";
		return mapping.findForward(target);
	}
	
	public ActionForward DUPLICATE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		AdvanceRequestTransFB formBean = (AdvanceRequestTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		AdvanceRequestTransDATA.getStoreDtls(formBean);
		formBean.setStrChkAdvanceReq("2");
		
//		if(request.getParameter("strPONo")!= null){
//			
//			AdvanceRequestTransDATA.getPODetailsDup(formBean,request);
//			
//		}
//		
//		if((request.getParameter("strStoreId")!=null)&&(request.getParameter("strItemCat")!=null)
//				&&(request.getParameter("strPONo")!=null)){
//			
//			AdvanceRequestTransDATA.getReqDetails(formBean, request);
//			
//		}
			String target = "duplicateindex";
			return mapping.findForward(target);
	}
	
	
	
	public ActionForward DUPLICATEGO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		AdvanceRequestTransFB formBean = (AdvanceRequestTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
	
		
	//	if(request.getParameter("strPONo")!= null){
		if(formBean.getPonovalue()!= null && !formBean.getPonovalue().equals("0")){
			
			AdvanceRequestTransDATA.getPODetailsDup(formBean,request);
			AdvanceRequestTransDATA.getBankDetailsDup(formBean,request);
			
		}
		
		if(!formBean.getStrId().equals("0") && !formBean.getItemCategory().equals("0")
				&& !formBean.getPonovalue().equals("0")){
			
			AdvanceRequestTransDATA.getReqDetails(formBean, request);
			
		}
			String target = "duplicateindex";
			return mapping.findForward(target);
	}
	
	
	/**
	 * THIS METHOD IS USED FOR PO NO LIST ON THE BASIS OF STORE NAME
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	
/////////////////////This Method is used for Unit Combo Values/////////////////////////////
	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		AdvanceRequestTransFB formBean = (AdvanceRequestTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		AdvanceRequestTransDATA.getItemCatDtls(formBean,request, response);
		
		return null;
	}
	
	public ActionForward PONOCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		AdvanceRequestTransFB formBean = (AdvanceRequestTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		AdvanceRequestTransDATA.getPONODtls(formBean,request, response);
		
		return null;
	}
	public ActionForward INSERTNEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		boolean retValue = false;
		AdvanceRequestTransFB formBean = (AdvanceRequestTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		retValue = AdvanceRequestTransDATA.insertNew(formBean,request, response);
		if(retValue){
			
			return this.unspecified(mapping, formBean, request, response);
		}else{
			return this.NEW(mapping, formBean, request, response);
		}
	}
	
	public void SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		AdvanceRequestTransFB formBean = (AdvanceRequestTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		AdvanceRequestTransDATA.showReport(formBean, request, response);
		
		
	}
	
	/**
	 * Forwards Control to the menu Page
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	public ActionForward CANCELPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
	    ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}

}
