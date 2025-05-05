package mms.reports.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import hisglobal.exceptions.HisException;
import mms.reports.controller.data.IssueTrackRptDATA;
import mms.reports.controller.fb.IssueTrackRptFB;


public class IssueTrackRptCNT extends DispatchAction {

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
		IssueTrackRptFB formBean = (IssueTrackRptFB) form;
		
		IssueTrackRptDATA.setInitializedValues(formBean,request, response);
		return mapping.findForward(strTarget);
	}
	//report
	public void SHOWRPTNEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		HttpSession session = request.getSession();
		IssueTrackRptFB formBean = (IssueTrackRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

		IssueTrackRptDATA.showReportNew(formBean, request, response);
		session.setAttribute("form", form);
	}
	//voucher
	public ActionForward INDENTPRINT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		HttpSession session = request.getSession();
		IssueTrackRptFB formBean = (IssueTrackRptFB) session.getAttribute("form");
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());


        System.out.println("-----------IssueTrackRptCNT . INDENTPRINT [ Print Indent Voucher ]--------------");
		IssueTrackRptDATA.indentPrint(formBean, request, response);
		session.setAttribute("form", form);
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
	
	public ActionForward ISSUEDTLPRINT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		System.out.println("------------ IssueTrackRptCNT . ISSUEDTLPRINT  ------------");
		//HttpSession session = request.getSession();
		//IssueTrackRptFB formBean = (IssueTrackRptFB) session.getAttribute("form");
		IssueTrackRptFB formBean = (IssueTrackRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		System.out.println("-----------IssueTrackRptCNT . ISSUEDTLPRINT [ Print Issue Detail Voucher For Row ]--------------");
		IssueTrackRptDATA.getIssueDetail(formBean, request, response);
		//session.setAttribute("form", form);
		return null;
	}
	
	public ActionForward ISSUEDTLBYSUBSTORE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		System.out.println("------------ IssueTrackRptCNT . ISSUEDTLBYSUBSTORE  ------------");
		//HttpSession session = request.getSession();
		//IssueTrackRptFB formBean = (IssueTrackRptFB) session.getAttribute("form");
		IssueTrackRptFB formBean = (IssueTrackRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		System.out.println("-----------IssueTrackRptCNT . ISSUEDTLBYSUBSTORE [ Print Issue Detail Voucher For SUBSTORE ]--------------");
		IssueTrackRptDATA.getIssueDtlForSubStore(formBean, request, response);
		//session.setAttribute("form", form);
		return null;
	}
	
	public ActionForward UNDO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		System.out.println("------------ IssueTrackRptCNT . UNDO  ------------");
		//HttpSession session = request.getSession();
		//IssueTrackRptFB formBean = (IssueTrackRptFB) session.getAttribute("form");
		IssueTrackRptFB formBean = (IssueTrackRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		System.out.println("-----------IssueTrackRptCNT . UNDO -- "+request.getParameter("reqMode")+"--------------");
//		IssueTrackRptDATA.undo(formBean, request, response);
		int reqMode= Integer.parseInt(request.getParameter("reqMode"));
		if(reqMode == 1) {
			IssueTrackRptDATA.indentPrint(formBean, request, response);
		}
		else {
			IssueTrackRptDATA.getIssueDetail(formBean, request, response);
		}
		//session.setAttribute("form", form);
		return null;
	}
	
	public ActionForward REDO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		System.out.println("------------ IssueTrackRptCNT . REDO  ------------");

		IssueTrackRptFB formBean = (IssueTrackRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		System.out.println("-----------IssueTrackRptCNT . REDO --------------");
		IssueTrackRptDATA.undo(formBean, request, response);
		
		return null;
	}

	
}

