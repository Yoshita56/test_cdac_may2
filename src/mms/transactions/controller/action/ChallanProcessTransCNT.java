package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.ChallanProcessTransDATA;
import mms.transactions.controller.fb.ChallanProcessTransFB;
import mms.transactions.controller.utl.ChallanProcessTransUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ChallanProcessTransCNT extends GenericController {

	/*
	 * Developer : Balasubramaniam M Version : 1.0 Date : 02/April/2009
	 * Module:MMS Unit:Challan Process
	 */

	public ChallanProcessTransCNT() {

		super(new ChallanProcessTransUTL(),
				"/transactions/ChallanProcessTransCNT");
	}

	public ActionForward RECEIVECHL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		String strTarget = "receivechallan";

		ChallanProcessTransFB formBean = (ChallanProcessTransFB) form;

		ChallanProcessTransDATA.receiveChallanInit(formBean, request);

		return mapping.findForward(strTarget);
	}

	public ActionForward VERIFYCHL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		String strTarget = "verifychallan";

		ChallanProcessTransFB formBean = (ChallanProcessTransFB) form;

		ChallanProcessTransDATA.verifyChallanInit(formBean, request);

		return mapping.findForward(strTarget);
	}

	public ActionForward SCHEDULEDTL(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException 
	{
        
		ChallanProcessTransFB formBean = (ChallanProcessTransFB) form;

		ChallanProcessTransDATA.getScheduleDtlsTwo(formBean, request, response);

		return null;
	}
	
	
	public ActionForward GETSCHEDULEDTLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		ChallanProcessTransFB formBean = (ChallanProcessTransFB) form;

		ChallanProcessTransDATA.getScheduleDtls(formBean, request, response);

		return null;
	}

	public ActionForward COMMITEEMEMBERDTL(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		ChallanProcessTransFB formBean = (ChallanProcessTransFB) form;

		ChallanProcessTransDATA.getCommitteeMemberDtls(formBean, request,
				response);

		return null;
	}

	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {


		ChallanProcessTransFB formBean = (ChallanProcessTransFB) form;

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

		boolean fltRes = ChallanProcessTransDATA.insert(formBean);

		if(fltRes){
			
			return LIST(mapping, form, request, response);
			
		}else{
			
			return this.RECEIVECHL(mapping, formBean, request, response);
			
		}
		
		
	}

	public ActionForward BALQTYDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ChallanProcessTransFB formBean = (ChallanProcessTransFB) form;

		ChallanProcessTransDATA.getBalanceQtyDtls(formBean, request, response);

		return null;
	}

	public ActionForward INSERTVERIFY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ChallanProcessTransFB formBean = (ChallanProcessTransFB) form;

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());

		boolean fltRes =  ChallanProcessTransDATA.verifyInsert(formBean);
		
		//strReceivedQuantity,strVerifiedQuantityInBaseVal
		
		String strVerifyFlag = formBean.getStrVerifyFlag();
		double recQty = Double.parseDouble(formBean.getStrReceivedQuantity());
		double verifyQty = Double.parseDouble(formBean.getStrVerifiedQuantityInBaseVal());
		
		if(strVerifyFlag.equals("1") || recQty == verifyQty)
			return LIST(mapping, form, request, response);
		else	
			return this.VERIFYCHL(mapping, formBean, request, response);
			
		
	
	}

	
	public ActionForward CANCELCHL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		
		ChallanProcessTransFB formBean = (ChallanProcessTransFB) form;

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());

				
		ChallanProcessTransDATA.cancelChallan(formBean);

		return LIST(mapping, form, request, response);
	}
	
	public ActionForward VIEWCHL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		String strTarget = "viewchallan";
		
		System.out.println("--------ChallanProcessTransCNT . VIEWCHL --[ challanprocess_view_mmstrans.jsp ]---");
		

		ChallanProcessTransFB formBean = (ChallanProcessTransFB) form;

		ChallanProcessTransDATA.viewChallan(formBean, request);

		return mapping.findForward(strTarget);
	}
	public ActionForward FETCHRECEIVEDITEMETAIL(ActionMapping mapping, ActionForm form,	HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException 
	{
		ChallanProcessTransFB formBean = (ChallanProcessTransFB) form;
		ChallanProcessTransDATA.getReceivedItemDetails(formBean,request, response);
		return null;
	}
	
	/**
	 * FETCHVERIFIEDITEMETAIL.
	 * @author shalini
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
		ChallanProcessTransFB formBean = (ChallanProcessTransFB) form;
		ChallanProcessTransDATA.getVerifiedItemDetails(formBean,request, response);
		return null;
	}
	
	public ActionForward PRINT(ActionMapping mapping, ActionForm form,	HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException 
	{
		ChallanProcessTransFB formBean = (ChallanProcessTransFB) form;
		ChallanProcessTransDATA.print(formBean,request, response);
		return null;
	}
}
