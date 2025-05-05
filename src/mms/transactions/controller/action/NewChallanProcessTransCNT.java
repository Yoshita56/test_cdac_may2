package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.NewChallanProcessTransDATA;
import mms.transactions.controller.fb.NewChallanProcessTransFB;
import mms.transactions.controller.utl.NewChallanProcessTransUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class NewChallanProcessTransCNT extends GenericController {

	/*
	 * Developer : Balasubramaniam M Version : 1.0 Date : 02/April/2009
	 * Module:MMS Unit:Challan Process
	 */

	public NewChallanProcessTransCNT() {

		super(new NewChallanProcessTransUTL(),
				"/transactions/NewChallanProcessTransCNT");
	}

	public ActionForward RECEIVECHL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		generateToken(request);
		//GenerateSecureRandomNumber(request);
		String strTarget = "challan";
		
		System.out.println("--------NewChallanProcessTransCNT . RECEIVECHL --[ newchallanprocessmmstrans.jsp ]---");

		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;

		NewChallanProcessTransDATA.receiveChallanInit(formBean, request);

		return mapping.findForward(strTarget);
	}

	/*public ActionForward VERIFYCHL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		String strTarget = "verifychallan";

		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;

		NewChallanProcessTransDATA.verifyChallanInit(formBean, request);

		return mapping.findForward(strTarget);
	}*/

	public ActionForward SCHEDULEDTL(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException 
	{
        
		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;

		NewChallanProcessTransDATA.getScheduleDtlsTwo(formBean, request, response);

		return null;
	}
	
	
	public ActionForward GETSCHEDULEDTLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;

		NewChallanProcessTransDATA.getScheduleDtls(formBean, request, response);

		return null;
	}

	/*public ActionForward COMMITEEMEMBERDTL(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;

		NewChallanProcessTransDATA.getCommitteeMemberDtls(formBean, request,
				response);

		return null;
	}*/

	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

         validateToken(request, response);
		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;
		
		System.out.println("--------NewChallanProcessTransCNT . INSERT -----");

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

		boolean fltRes = NewChallanProcessTransDATA.insert(formBean);

		if(fltRes){
			
			return LIST(mapping, form, request, response);
			
		}else{
			
			return this.RECEIVECHL(mapping, formBean, request, response);
			
		}
		
		
	}


	public ActionForward CANCELCHL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		System.out.println("--------NewChallanProcessTransCNT . CANCELCHL -----");
		
		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());

				
		NewChallanProcessTransDATA.cancelChallan(formBean);

		return LIST(mapping, form, request, response);
	}
	
	public ActionForward VIEWCHL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		String strTarget = "viewchallan";
		
		System.out.println("--------NewChallanProcessTransCNT . VIEWCHL --[ newchallanprocess_view_mmstrans.jsp ]---");

		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;

		NewChallanProcessTransDATA.viewChallan(formBean, request);

		return mapping.findForward(strTarget);
	}
	
	
	public ActionForward NEWRECCHL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		String strTarget = "NEWRECCHL";
		
		System.out.println("--------NewChallanProcessTransCNT . NEWRECCHL --[ add_newLpChallan_receive.jsp ]---");

		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;

		NewChallanProcessTransDATA.getInitNewRecChl(formBean, request);

		return mapping.findForward(strTarget);
	}
	public ActionForward NEWCHLRECITEMDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		String strTarget = "NEWRECCHL";
		
		System.out.println("--------NewChallanProcessTransCNT . NEWCHLRECITEMDTL --[ add_newLpChallan_receive.jsp ]---");

		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;

		NewChallanProcessTransDATA.getInitNewRecItemChl(formBean, request);

		return mapping.findForward(strTarget);
	}
	
	
	public ActionForward insertLP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {


		System.out.println("--------NewChallanProcessTransCNT . insertLP -----");
		
		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

		boolean fltRes = NewChallanProcessTransDATA.insertlp(formBean ,request);

		if(fltRes){
			
			return LIST(mapping, form, request, response);
			
		}else{
			
			return this.RECEIVECHL(mapping, formBean, request, response);
			
		}
		
		
	}
}
