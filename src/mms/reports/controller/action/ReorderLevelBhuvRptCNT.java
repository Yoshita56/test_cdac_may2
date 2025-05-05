package mms.reports.controller.action;

import hisglobal.exceptions.HisException;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.ReorderLevelBhuvRptDATA;
import mms.reports.controller.fb.ReorderLevelBhuvRptFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;


public class ReorderLevelBhuvRptCNT extends DispatchAction 
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
        System.out.println("--------------ReorderLevelBhuvRptCNT.INITIALDATA---------[ projectionorderrpt.jsp ]---------");
		
		String strTarget = "index";
		ReorderLevelBhuvRptFB formBean = (ReorderLevelBhuvRptFB) form;
		
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		
		ReorderLevelBhuvRptDATA.getStoreCombo(formBean, request, response);
		return mapping.findForward(strTarget);
	}

	public ActionForward DISTRICTCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		System.out.println("--------------ReorderLevelBhuvRptCNT.DISTRICTCMB------------------");
		
		ReorderLevelBhuvRptFB formBean = (ReorderLevelBhuvRptFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		ReorderLevelBhuvRptDATA.getDistrictList(formBean, request, response);
		return null;
	}

	public ActionForward STORECOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println("--------------ReorderLevelBhuvRptCNT.STORECOMBO------------------");
		
		ReorderLevelBhuvRptFB formBean = (ReorderLevelBhuvRptFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		ReorderLevelBhuvRptDATA.getStoreCombo(formBean, request, response);
		return null;
	}

	public ActionForward STORETYPECMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println("--------------ReorderLevelBhuvRptCNT.STORETYPECMB------------------");
		ReorderLevelBhuvRptFB formBean = (ReorderLevelBhuvRptFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		ReorderLevelBhuvRptDATA.getStoreTypeList(formBean, request, response);
		return null;
	}

	public ActionForward SUBSTORECOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println("--------------ReorderLevelBhuvRptCNT.SUBSTORECOMBO------------------");
		ReorderLevelBhuvRptFB formBean = (ReorderLevelBhuvRptFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		ReorderLevelBhuvRptDATA.getSubStoreCombo(formBean, request, response);
		return null;
	}

	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println("--------------ReorderLevelBhuvRptCNT.ITEMCATCMB------------------");
		
		ReorderLevelBhuvRptFB formBean = (ReorderLevelBhuvRptFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		ReorderLevelBhuvRptDATA.getItemCatList(formBean, request, response);
		return null;
	}

	
	public ActionForward GROUPCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println("--------------ReorderLevelBhuvRptCNT.GROUPCMB------------------");
		ReorderLevelBhuvRptFB formBean = (ReorderLevelBhuvRptFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		ReorderLevelBhuvRptDATA.getGroupList(formBean, request, response);
		return null;
	}

	public ActionForward DRUGNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println("--------------ReorderLevelBhuvRptCNT.DRUGNAME------------------");
		ReorderLevelBhuvRptFB formBean = (ReorderLevelBhuvRptFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		ReorderLevelBhuvRptDATA.getDrugList(formBean, request, response);
		return null;
	}

	public ActionForward DRUGNAME1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println("--------------ReorderLevelBhuvRptCNT.DRUGNAME1------------------");
		ReorderLevelBhuvRptFB formBean = (ReorderLevelBhuvRptFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		ReorderLevelBhuvRptDATA.getDrugList(formBean, request, response);
		return null;
	}

	public ActionForward PROGNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println("--------------ReorderLevelBhuvRptCNT.PROGNAME------------------");
		ReorderLevelBhuvRptFB formBean = (ReorderLevelBhuvRptFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		ReorderLevelBhuvRptDATA.getProgrammeCombo(formBean, request, response);
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
		System.out.println("--------------ReorderLevelBhuvRptCNT.SHOWRPT---------[ print_reorderlevelrpt.jsp ]---------");
		
		String strTarget="Html_Report";
		ReorderLevelBhuvRptFB formBean = (ReorderLevelBhuvRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		ReorderLevelBhuvRptDATA.showRpt(formBean, request, response);
		return mapping.findForward(strTarget);

	}

}
