package mms.reports.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import hisglobal.exceptions.HisException;
import mms.reports.controller.data.StoreSaleReturnDATA;
import mms.reports.controller.fb.StoreSaleReturnFB;


public class StoreSaleReturnCNT extends DispatchAction {

	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		return this.INITVAL(mapping, form, request, response);
		
	}
	
	public ActionForward INITVAL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		System.out.println("---------IssueTrackRptCNT . INITVAL----- [ issueTrack_mmsrpt.jsp ]----");
		
		String strTarget = "reportPage";
		StoreSaleReturnFB formBean = (StoreSaleReturnFB) form;
		
		StoreSaleReturnDATA.setInitializedValues(formBean,request, response);
		return mapping.findForward(strTarget);
	}
	//report
	public void SHOWRPTNEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StoreSaleReturnFB formBean = (StoreSaleReturnFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

		StoreSaleReturnDATA.showReportNew(formBean, request, response);
	}
	//voucher
	public ActionForward INDENTPRINT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		StoreSaleReturnFB formBean = (StoreSaleReturnFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());


        System.out.println("-----------IssueTrackRptCNT . INDENTPRINT [ Print Indent Voucher ]--------------");
		StoreSaleReturnDATA.indentPrint(formBean, request, response);

		return null;
	}
	
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
	    ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward HEADERIMAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		System.out.println("------------ IssueTrackRptCNT . HEADERIMAGE  ------------");

		StoreSaleReturnFB formBean = (StoreSaleReturnFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
	//	StoreSaleReturnFB.getLogoHeader(formBean, request,response);
		
		return null;
	}
	
}

