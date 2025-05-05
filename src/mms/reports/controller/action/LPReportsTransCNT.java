package mms.reports.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import hisglobal.exceptions.HisException;
import mms.reports.controller.data.LPReportsTransDATA;
import mms.reports.controller.fb.LPReportsTransFB;

public class LPReportsTransCNT extends DispatchAction {
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		return this.init(mapping, form, request, response);
		
	}
	
	/** This method is used to forward the request on first jsp page
	 * And calls the methods getInitialValues() which is define in PendingListAgendaRptDATA java file. AND LIST VALUES to display combos 
	 * on first page. 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * 
	 */
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException 
	{
		String strTarget = "purchaseorder";
		LPReportsTransFB formBean = (LPReportsTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		LPReportsTransDATA.initDetails(formBean,request);
		LPReportsTransDATA.getStoreList(formBean,request);
				
		return mapping.findForward(strTarget);
	}
	
	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		LPReportsTransFB formBean = (LPReportsTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		LPReportsTransDATA.getItemCatList(formBean,request, response);
		
		return null;
	}
	
	public ActionForward POTYPECMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		LPReportsTransFB formBean = (LPReportsTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		LPReportsTransDATA.getPOTypeList(formBean,request, response);
		
		return null;
	}
	
	public ActionForward SUPPLIERCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		LPReportsTransFB formBean = (LPReportsTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		LPReportsTransDATA.getSupplierList(formBean,request, response);
		
		return null;
	}
	/*
	public void SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		LPReportsTransFB formBean = (LPReportsTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		LPReportsTransDATA.showReport(formBean, request, response);
		
		
	}
	*/
	
	public ActionForward SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException
	{

		String strTarget="Html_Report";
		LPReportsTransFB formBean = (LPReportsTransFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		LPReportsTransDATA.showReport_NEW(formBean, request, response);
		return mapping.findForward(strTarget);

	}
	
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
	    ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}

	public ActionForward Back(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		return this.init(mapping, form, request, response);
		
	}
	
	/**
	 * INDENTPRINT - gets the issue details view used for ajax.
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
	public ActionForward INDENTPRINT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		
		
		LPReportsTransFB formBean = (LPReportsTransFB) form;
		
		String strChk 		= (String) request.getParameter("strChk")==null?formBean.getStrChk():(String) request.getParameter("strChk");
		
		System.out.println("------Chk--------"+strChk);
		
		
		
        System.out.println("-----------IndentViewTransCNT . INDENTPRINT [ Print Indent Voucher ]--------------");
        LPReportsTransDATA.indentPrint(request, response, formBean);

		return null;
	}
	
}
