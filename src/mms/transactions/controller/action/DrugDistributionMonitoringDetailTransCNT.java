package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.DrugDistributionMonitoringDetailTransDATA;
import mms.transactions.controller.fb.DrugDistributionMonitoringDetailTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class DrugDistributionMonitoringDetailTransCNT extends CSRFGardTokenAction{
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
	     generateToken(request);
		DrugDistributionMonitoringDetailTransFB formBean = (DrugDistributionMonitoringDetailTransFB) form;

		return this.INITVAL(mapping, formBean, request, response);
		
		
	}
	
	public ActionForward CANCELPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
	    ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	/*
	 * To Get the Store Combo
	 */
	
	public ActionForward INITVAL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		generateToken(request);
		DrugDistributionMonitoringDetailTransFB formBean = (DrugDistributionMonitoringDetailTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		/**
		 * This Flag used to Show Scaned Document
		 * Flag = 0 Means No Scaned Document Button Shown
		 * Flag = 1 Means Scaned Document Button Shown
		 */
		formBean.setStrScanFlg("0"); 
		
		DrugDistributionMonitoringDetailTransDATA.getInitialValues(formBean, request);
		
		String target = "initialPage";
		return mapping.findForward(target);
	} 
	
	/*
	 * To Get the Item Category Combo
	 */
	
	public ActionForward UNITCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		DrugDistributionMonitoringDetailTransFB formBean = (DrugDistributionMonitoringDetailTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		DrugDistributionMonitoringDetailTransDATA.getUnitValues(formBean,request, response);
		
		return null;
	}
	
	
	
	/*
	 * To Get the Patient Dtls
	 */
	
	public ActionForward searchPatientDtls(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		DrugDistributionMonitoringDetailTransFB formBean = (DrugDistributionMonitoringDetailTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		DrugDistributionMonitoringDetailTransDATA.searchPatientDtls(formBean,request, response);
		
		return null;
	}
	
	
	/*
	 * To Get the Patient Dtls
	 */
	
	public ActionForward getIssuedDtls(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		DrugDistributionMonitoringDetailTransFB formBean = (DrugDistributionMonitoringDetailTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		DrugDistributionMonitoringDetailTransDATA.getIssuedDtls(formBean,request, response);
		
		return null;
	}
	
	
	
	/*
	 * To Get the Patient Dtls
	 */
	
	/*public ActionForward getPrescribedDtls(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		DrugDistributionMonitoringDetailTransFB formBean = (DrugDistributionMonitoringDetailTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		DrugDistributionMonitoringDetailTransDATA.getPrescribedDtls(formBean,request, response);
		
		return null;
	}*/
	
	
	/*
	 * To Get the Patient Dtls
	 */
	
	public ActionForward getIssuedDrugDtls(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		DrugDistributionMonitoringDetailTransFB formBean = (DrugDistributionMonitoringDetailTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		DrugDistributionMonitoringDetailTransDATA.getIssuedDrugDtls(formBean,request, response);
		
		return null;
	}
	
	
	/*
	 * To Get the Item Category Combo
	 */
	
	public ActionForward GETSCANEDDOC(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		DrugDistributionMonitoringDetailTransFB formBean = (DrugDistributionMonitoringDetailTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		DrugDistributionMonitoringDetailTransDATA.getScanFlag(formBean,request, response);
		
		return null;
	}
	
	/*
	 * To Get the Episode Visit Combo
	 */
	
	public ActionForward GETEPISODEVISITPOPUP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		DrugDistributionMonitoringDetailTransFB formBean = (DrugDistributionMonitoringDetailTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		String strTarget = "episodeVisitPopup";

		DrugDistributionMonitoringDetailTransDATA.getEpisodeVisitPopup(formBean,request, response);
		
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
	
	
	
}
