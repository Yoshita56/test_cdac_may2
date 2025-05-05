package mms.reports.controller.action;

import hisglobal.exceptions.HisException;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.IssueReceiveLedgerRptDATA;
import mms.reports.controller.fb.IssueReceiveLedgerRptFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;


public class IssueReceiveLedgerRptCNT extends DispatchAction 
{

	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		return this.INITIALDATA(mapping, form, request, response);

	}

	public ActionForward INITIALDATA(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        System.out.println("--------------IssueReceiveLedgerRptCNT.INITIALDATA---------[ issueReceiveLedger_mmsrpt.jsp ]---------");
		
		String strTarget = "index";
		IssueReceiveLedgerRptFB formBean = (IssueReceiveLedgerRptFB) form;
		
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		
		IssueReceiveLedgerRptDATA.getStoreCombo(formBean, request, response);
		return mapping.findForward(strTarget);
	}

	public ActionForward DISTRICTCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		System.out.println("--------------IssueReceiveLedgerRptCNT.DISTRICTCMB------------------");
		
		IssueReceiveLedgerRptFB formBean = (IssueReceiveLedgerRptFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		IssueReceiveLedgerRptDATA.getDistrictList(formBean, request, response);
		return null;
	}

	public ActionForward STORECOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println("--------------IssueReceiveLedgerRptCNT.STORECOMBO------------------");
		
		IssueReceiveLedgerRptFB formBean = (IssueReceiveLedgerRptFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		IssueReceiveLedgerRptDATA.getStoreCombo(formBean, request, response);
		return null;
	}

	public ActionForward STORETYPECMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println("--------------IssueReceiveLedgerRptCNT.STORETYPECMB------------------");
		IssueReceiveLedgerRptFB formBean = (IssueReceiveLedgerRptFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		IssueReceiveLedgerRptDATA.getStoreTypeList(formBean, request, response);
		return null;
	}

	public ActionForward SUBSTORECOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println("--------------IssueReceiveLedgerRptCNT.SUBSTORECOMBO------------------");
		IssueReceiveLedgerRptFB formBean = (IssueReceiveLedgerRptFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		IssueReceiveLedgerRptDATA.getSubStoreCombo(formBean, request, response);
		return null;
	}

	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println("--------------IssueReceiveLedgerRptCNT.ITEMCATCMB------------------");
		
		IssueReceiveLedgerRptFB formBean = (IssueReceiveLedgerRptFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		IssueReceiveLedgerRptDATA.getItemCatList(formBean, request, response);
		return null;
	}

	
	public ActionForward GROUPCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println("--------------IssueReceiveLedgerRptCNT.GROUPCMB------------------");
		IssueReceiveLedgerRptFB formBean = (IssueReceiveLedgerRptFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		IssueReceiveLedgerRptDATA.getGroupList(formBean, request, response);
		return null;
	}

	public ActionForward DRUGNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println("--------------IssueReceiveLedgerRptCNT.DRUGNAME------------------");
		IssueReceiveLedgerRptFB formBean = (IssueReceiveLedgerRptFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		IssueReceiveLedgerRptDATA.getDrugList(formBean, request, response);
		return null;
	}

	public ActionForward DRUGNAME1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println("--------------IssueReceiveLedgerRptCNT.DRUGNAME1------------------");
		IssueReceiveLedgerRptFB formBean = (IssueReceiveLedgerRptFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		IssueReceiveLedgerRptDATA.getDrugList(formBean, request, response);
		return null;
	}

	public ActionForward PROGNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println("--------------IssueReceiveLedgerRptCNT.PROGNAME------------------");
		IssueReceiveLedgerRptFB formBean = (IssueReceiveLedgerRptFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		IssueReceiveLedgerRptDATA.getProgrammeCombo(formBean, request, response);
		return null;
	}
	
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException 
	{
		System.out.println("--------------IssueReceiveLedgerRptCNT.SHOWRPT---------[ print_issueReceiveLedger_mmsrpt.jsp ]---------");
		
		String strTarget="Html_Report";
		IssueReceiveLedgerRptFB formBean = (IssueReceiveLedgerRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueReceiveLedgerRptDATA.showRpt(formBean, request, response);
		return mapping.findForward(strTarget);

	}

}

