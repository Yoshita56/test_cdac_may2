package mms.reports.controller.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import hisglobal.exceptions.HisException;
import mms.reports.controller.data.StockOnHandIgimsRptDATA;
import mms.reports.controller.fb.StockOnHandIgimsRptFB;

public class StockOnHandIgimsRptCNT extends DispatchAction {

	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception, SQLException {
		return this.INITIALDATA(mapping, form, request, response);
	}

	public ActionForward INITIALDATA(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		String strTarget = "index";
		StockOnHandIgimsRptFB formBean = (StockOnHandIgimsRptFB) form;
		
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		System.out.println("--------------------------HOSPITAL_CODE ::"+ request.getSession().getAttribute("HOSPITAL_CODE").toString());

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		System.out.println("--------------------------SEATID ::" + request.getSession().getAttribute("SEATID").toString());
		/*
		   String strUserValue = request.getSession().getAttribute("USER_LEVEL").toString();
		   System.out.println("--------------------------USERVALUE ::" +strUserValue);
		 */
		try {
			formBean.setStrCircleId("0");
			StockOnHandIgimsRptDATA.getStoreCombo(formBean, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward(strTarget);
	}

	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		StockOnHandIgimsRptFB formBean = (StockOnHandIgimsRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		StockOnHandIgimsRptDATA.getItemCatList(formBean, request, response);
		return null;
	}
	
	public ActionForward DRUGNAME(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		StockOnHandIgimsRptFB formBean = (StockOnHandIgimsRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		StockOnHandIgimsRptDATA.getDrugList(formBean, request, response);
		return null;
	}
	
	public ActionForward DISTRICTCMB(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		StockOnHandIgimsRptFB formBean = (StockOnHandIgimsRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		StockOnHandIgimsRptDATA.getDistrictList(formBean, request, response);
		return null;
	}

	public ActionForward STORECOMBO(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		StockOnHandIgimsRptFB formBean = (StockOnHandIgimsRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		StockOnHandIgimsRptDATA.getStoreCombo(formBean, request, response);
		return null;
	}

	public ActionForward STORETYPECMB(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		StockOnHandIgimsRptFB formBean = (StockOnHandIgimsRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		StockOnHandIgimsRptDATA.getStoreTypeList(formBean, request, response);
		return null;
	}

	public ActionForward SUBSTORECOMBO(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		StockOnHandIgimsRptFB formBean = (StockOnHandIgimsRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		StockOnHandIgimsRptDATA.getSubStoreCombo(formBean, request, response);
		return null;
	}

	public ActionForward GROUPCMB(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		StockOnHandIgimsRptFB formBean = (StockOnHandIgimsRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		StockOnHandIgimsRptDATA.getGroupList(formBean, request, response);
		return null;
	}

	public ActionForward DRUGNAME1(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		StockOnHandIgimsRptFB formBean = (StockOnHandIgimsRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		StockOnHandIgimsRptDATA.getDrugList(formBean, request, response);
		return null;
	}

	public ActionForward PROGNAME(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		StockOnHandIgimsRptFB formBean = (StockOnHandIgimsRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		StockOnHandIgimsRptDATA.getProgrammeCombo(formBean, request, response);
		return null;
	}
	
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
//	this will generate final report 
	public ActionForward SHOWRPT(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException, IOException, ServletException {
		
		String strTarget = "Html_Report";
		
		StockOnHandIgimsRptFB formBean = (StockOnHandIgimsRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		StockOnHandIgimsRptDATA.showReport_NEW(formBean, request, response);
		
		return mapping.findForward(strTarget);

	}

	

}
