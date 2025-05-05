package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.ChallanProcessApprovalTransDATA;
import mms.transactions.controller.fb.ChallanProcessApprovalTransFB;
import mms.transactions.controller.utl.ChallanProcessApprovalTransUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ChallanProcessApprovalTransCNT extends GenericController {

	/*
	 * Developer : Balasubramaniam M Version : 1.0 Date : 02/April/2009
	 * Module:MMS Unit:Challan Process
	 */

	public ChallanProcessApprovalTransCNT() {

		super(new ChallanProcessApprovalTransUTL(),
				"/transactions/ChallanProcessApprovalTransCNT");
	}

	public ActionForward RECEIVECHL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		generateToken(request);
		String strTarget = "receivechallan";
		
		System.out.println("-------- ChallanProcessApprovalTransCNT. RECEIVECHL---------");

		ChallanProcessApprovalTransFB formBean = (ChallanProcessApprovalTransFB) form;

		ChallanProcessApprovalTransDATA.receiveChallanInit(formBean, request);

		return mapping.findForward(strTarget);
	}

	public ActionForward VERIFYCHL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		generateToken(request);
		String strTarget = "verifychallan";
		
		System.out.println("-------- ChallanProcessApprovalTransCNT. VERIFYCHL---------");

		ChallanProcessApprovalTransFB formBean = (ChallanProcessApprovalTransFB) form;

		ChallanProcessApprovalTransDATA.verifyChallanInit(formBean, request);

		return mapping.findForward(strTarget);
	}

	public ActionForward GETSCHEDULEDTLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		ChallanProcessApprovalTransFB formBean = (ChallanProcessApprovalTransFB) form;

		ChallanProcessApprovalTransDATA.getScheduleDtls(formBean, request, response);

		return null;
	}

	public ActionForward COMMITEEMEMBERDTL(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		ChallanProcessApprovalTransFB formBean = (ChallanProcessApprovalTransFB) form;

		ChallanProcessApprovalTransDATA.getCommitteeMemberDtls(formBean, request,
				response);

		return null;
	}

	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
      
        validateToken(request, response);
		ChallanProcessApprovalTransFB formBean = (ChallanProcessApprovalTransFB) form;

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());
		
		System.out.println("-------- ChallanProcessApprovalTransCNT. INSERT---------");

		boolean fltRes = ChallanProcessApprovalTransDATA.insert(formBean);

		if(fltRes){
			
			return LIST(mapping, form, request, response);
			
		}else{
			
			return this.RECEIVECHL(mapping, formBean, request, response);
			
		}
		
		
	}

	public ActionForward BALQTYDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ChallanProcessApprovalTransFB formBean = (ChallanProcessApprovalTransFB) form;

		ChallanProcessApprovalTransDATA.getBalanceQtyDtls(formBean, request, response);

		return null;
	}

	public ActionForward INSERTVERIFY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
        validateToken(request, response);
		ChallanProcessApprovalTransFB formBean = (ChallanProcessApprovalTransFB) form;

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());
		
		System.out.println("-------- ChallanProcessApprovalTransCNT. INSERTVERIFY---------");

		boolean fltRes =  ChallanProcessApprovalTransDATA.verifyInsert(formBean);

		if(fltRes){
			
			return LIST(mapping, form, request, response);
			
		}else{
			
			return this.VERIFYCHL(mapping, formBean, request, response);
			
		}
	
	}

	
	public ActionForward CANCELCHL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		
		ChallanProcessApprovalTransFB formBean = (ChallanProcessApprovalTransFB) form;

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		
		ChallanProcessApprovalTransDATA.cancelChallan(formBean);

		return LIST(mapping, form, request, response);
	}
	
	
	
	
	
	public ActionForward CANCELVERIFIEDCHL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		
		ChallanProcessApprovalTransFB formBean = (ChallanProcessApprovalTransFB) form;

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());		
		
		ChallanProcessApprovalTransDATA.cancelVerifiedChallan(formBean);

		return LIST(mapping, form, request, response);
	}
	
		/**
	 * VIEWCHL.
	 * @author santoshsinghchauhan
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward VIEWCHL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		String strTarget = "viewchallan";
		
		System.out.println("-------- ChallanProcessApprovalTransCNT. VIEWCHL-----[challanprocessapproval_view_mmstrans.jsp]----");

		ChallanProcessApprovalTransFB formBean = (ChallanProcessApprovalTransFB) form;

		ChallanProcessApprovalTransDATA.viewChallan(formBean, request);

		return mapping.findForward(strTarget);
	}
	
	/**
	 * FETCHRECEIVEDITEMETAIL.
	 * @author santoshsinghchauhan
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws Exception the exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward FETCHRECEIVEDITEMETAIL(ActionMapping mapping, ActionForm form,	HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException 
	{
		System.out.println("-------- ChallanProcessApprovalTransCNT. FETCHRECEIVEDITEMETAIL---------");
		
		ChallanProcessApprovalTransFB formBean = (ChallanProcessApprovalTransFB) form;
		ChallanProcessApprovalTransDATA.getReceivedItemDetails(formBean,request, response);
		return null;
	}
	
	/**
	 * FETCHVERIFIEDITEMETAIL.
	 * @author santoshsinghchauhan
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws Exception the exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward FETCHVERIFIEDITEMETAIL(ActionMapping mapping, ActionForm form,	HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException 
	{
		System.out.println("-------- ChallanProcessApprovalTransCNT. FETCHVERIFIEDITEMETAIL---------");
		ChallanProcessApprovalTransFB formBean = (ChallanProcessApprovalTransFB) form;
		ChallanProcessApprovalTransDATA.getVerifiedItemDetails(formBean,request, response);
		return null;
	}
	
	
	/**
	 * FREEZE.
	 * @author vivek
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward FREEZE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		String strTarget = "freezeChallan";
		  generateToken(request);
		  
		  System.out.println("-------- ChallanProcessApprovalTransCNT. FREEZE-----[ challanprocessapproval_mmstrans.jsp ]----");
		  
		ChallanProcessApprovalTransFB formBean = (ChallanProcessApprovalTransFB) form;

		ChallanProcessApprovalTransDATA.freezeChallanInit(formBean, request);

		return mapping.findForward(strTarget);
	}
	
	
	/**
	 * INSERTFREEZECHALLAN.
	 * @author santoshsinghchauhan
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward INSERTFREEZECHALLAN(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, Exception {
		validateToken(request, response);
		System.out.println("-------- ChallanProcessApprovalTransCNT. INSERTFREEZECHALLAN---------");
		 
		ChallanProcessApprovalTransFB formBean = (ChallanProcessApprovalTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());
		ChallanProcessApprovalTransDATA.insertFreezeChallan(formBean, request);

		return LIST(mapping, form, request, response);
	}
	
	public ActionForward PRINTCHL(ActionMapping mapping, ActionForm form,	HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException 
	{
		String strTarget = "printChallan";
		
		System.out.println("-------- ChallanProcessApprovalTransCNT. PRINTCHL-----[challanprocessapproval_print_mmstrans.jsp]----");
		
		ChallanProcessApprovalTransFB formBean = (ChallanProcessApprovalTransFB) form;
		ChallanProcessApprovalTransDATA.print(formBean,request, response);
		return mapping.findForward(strTarget);
	}
}
