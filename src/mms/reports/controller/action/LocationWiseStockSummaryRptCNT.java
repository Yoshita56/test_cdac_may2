/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         LocationWiseStockSummaryRptCNT.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.controller.action;

import hisglobal.exceptions.HisException;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.LocationWiseStockSummaryRptDATA;
import mms.reports.controller.fb.LocationWiseStockSummaryRptFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

// TODO: Auto-generated Javadoc
/**
 * The Class LocationWiseStockSummaryRptCNT.
 */
public class LocationWiseStockSummaryRptCNT extends DispatchAction {

	/*
	 * (non-Javadoc)
	 * @see org.apache.struts.actions.DispatchAction#unspecified(org.apache.struts .action.ActionMapping, org.apache.struts.action.ActionForm,
	 * javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		return this.INITIALDATA(mapping, form, request, response);

	}

	/**
	 * Initialdata.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward INITIALDATA(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		String strTarget = "index";
		LocationWiseStockSummaryRptFB formBean = (LocationWiseStockSummaryRptFB) form;
		if(request.getSession().getAttribute("HOSPITAL_CODE")!=null ){
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			//formBean.setStrUserLevel(request.getSession().getAttribute("USER_LEVEL").toString());
		}
		
		else
		{
			formBean.setStrHospitalCode("998");
			formBean.setStrSeatId("10007");
			formBean.setStrUserLevel("1");
		}LocationWiseStockSummaryRptDATA.getInitialData(formBean, request, response);
		return mapping.findForward(strTarget);
	}

	/**
	 * Districtcmb.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward DISTRICTCMB(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		LocationWiseStockSummaryRptFB formBean = (LocationWiseStockSummaryRptFB) form;
		if(request.getSession().getAttribute("HOSPITAL_CODE")!=null ){
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			//formBean.setStrUserLevel(request.getSession().getAttribute("USER_LEVEL").toString());
		}
		
		else
		{
			formBean.setStrHospitalCode("998");
			formBean.setStrSeatId("10007");
			formBean.setStrUserLevel("1");
		}LocationWiseStockSummaryRptDATA.getDistrictList(formBean, request, response);
		return null;
	}

	/**
	 * Storecombo.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward STORECOMBO(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		LocationWiseStockSummaryRptFB formBean = (LocationWiseStockSummaryRptFB) form;
		if(request.getSession().getAttribute("HOSPITAL_CODE")!=null ){
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			//formBean.setStrUserLevel(request.getSession().getAttribute("USER_LEVEL").toString());
		}
		
		else
		{
			formBean.setStrHospitalCode("998");
			formBean.setStrSeatId("10007");
			formBean.setStrUserLevel("1");
		}LocationWiseStockSummaryRptDATA.getStoreCombo(formBean, request, response);
		return null;
	}

	/**
	 * Storetypecmb.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward STORETYPECMB(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		LocationWiseStockSummaryRptFB formBean = (LocationWiseStockSummaryRptFB) form;
		if(request.getSession().getAttribute("HOSPITAL_CODE")!=null ){
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			//formBean.setStrUserLevel(request.getSession().getAttribute("USER_LEVEL").toString());
		}
		
		else
		{
			formBean.setStrHospitalCode("998");
			formBean.setStrSeatId("10007");
			formBean.setStrUserLevel("1");
		}LocationWiseStockSummaryRptDATA.getStoreTypeList(formBean, request, response);
		return null;
	}

	/**
	 * Dwhtypecmb.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward DWHTYPECMB(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		LocationWiseStockSummaryRptFB formBean = (LocationWiseStockSummaryRptFB) form;
		if(request.getSession().getAttribute("HOSPITAL_CODE")!=null ){
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			//formBean.setStrUserLevel(request.getSession().getAttribute("USER_LEVEL").toString());
		}
		
		else
		{
			formBean.setStrHospitalCode("998");
			formBean.setStrSeatId("10007");
			formBean.setStrUserLevel("1");
		}LocationWiseStockSummaryRptDATA.getDWHTypeList(formBean, request, response);
		return null;
	}

	/**
	 * Dwhsubtypecmb.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward DWHSUBTYPECMB(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		LocationWiseStockSummaryRptFB formBean = (LocationWiseStockSummaryRptFB) form;
		if(request.getSession().getAttribute("HOSPITAL_CODE")!=null ){
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			//formBean.setStrUserLevel(request.getSession().getAttribute("USER_LEVEL").toString());
		}
		
		else
		{
			formBean.setStrHospitalCode("998");
			formBean.setStrSeatId("10007");
			formBean.setStrUserLevel("1");
		}LocationWiseStockSummaryRptDATA.getDWHSubTypeList(formBean, request, response);
		return null;
	}

	/**
	 * Substorecombo.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward SUBSTORECOMBO(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		LocationWiseStockSummaryRptFB formBean = (LocationWiseStockSummaryRptFB) form;
		if(request.getSession().getAttribute("HOSPITAL_CODE")!=null ){
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			//formBean.setStrUserLevel(request.getSession().getAttribute("USER_LEVEL").toString());
		}
		
		else
		{
			formBean.setStrHospitalCode("998");
			formBean.setStrSeatId("10007");
			formBean.setStrUserLevel("1");
		}LocationWiseStockSummaryRptDATA.getSubStoreCombo(formBean, request, response);
		return null;
	}

	/**
	 * Itemcatcmb.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		LocationWiseStockSummaryRptFB formBean = (LocationWiseStockSummaryRptFB) form;
		if(request.getSession().getAttribute("HOSPITAL_CODE")!=null ){
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			//formBean.setStrUserLevel(request.getSession().getAttribute("USER_LEVEL").toString());
		}
		
		else
		{
			formBean.setStrHospitalCode("998");
			formBean.setStrSeatId("10007");
			formBean.setStrUserLevel("1");
		}LocationWiseStockSummaryRptDATA.getItemCatList(formBean, request, response);
		return null;
	}

	/**
	 * Groupcmb.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward GROUPCMB(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		LocationWiseStockSummaryRptFB formBean = (LocationWiseStockSummaryRptFB) form;
		if(request.getSession().getAttribute("HOSPITAL_CODE")!=null ){
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			//formBean.setStrUserLevel(request.getSession().getAttribute("USER_LEVEL").toString());
			
			//userName,usrName
		}
		
		else
		{
			formBean.setStrHospitalCode("998");
			formBean.setStrSeatId("10007");
			formBean.setStrUserLevel("1");
		}LocationWiseStockSummaryRptDATA.getGroupList(formBean, request, response);
		return null;
	}

	/**
	 * Drugname.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward DRUGNAME(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		LocationWiseStockSummaryRptFB formBean = (LocationWiseStockSummaryRptFB) form;
		if(request.getSession().getAttribute("HOSPITAL_CODE")!=null ){
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			//formBean.setStrUserLevel(request.getSession().getAttribute("USER_LEVEL").toString());
		}
		
		else
		{
			formBean.setStrHospitalCode("998");
			formBean.setStrSeatId("10007");
			formBean.setStrUserLevel("1");
		}LocationWiseStockSummaryRptDATA.getDrugList(formBean, request, response);
		return null;
	}

	/**
	 * Showlocationstockrpt.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward SHOWLOCATIONSTOCKRPT(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, IOException, ServletException {

		String strTarget = "";
		strTarget = "PrintinLocation_HTML";
		LocationWiseStockSummaryRptFB fb = (LocationWiseStockSummaryRptFB) form;
		if(request.getSession().getAttribute("HOSPITAL_CODE")!=null ){
			fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			fb.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			//fb.setStrUserLevel(request.getSession().getAttribute("USER_LEVEL").toString());
			//fb.setStrUserName(request.getSession().getAttribute("UserFullName").toString());
		}
		
		else
		{
			fb.setStrHospitalCode("998");
			fb.setStrSeatId("10007");
			fb.setStrUserLevel("1");
			fb.setStrUserName("Admin");
		}LocationWiseStockSummaryRptDATA.showHTMLLocationStockReport(fb, request,response);
		return mapping.findForward(strTarget);

	}

	/**
	 * Cancel.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 */
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward PROGNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		LocationWiseStockSummaryRptFB formBean = (LocationWiseStockSummaryRptFB) form;
		if(request.getSession().getAttribute("HOSPITAL_CODE")!=null ){
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			//formBean.setStrUserLevel(request.getSession().getAttribute("USER_LEVEL").toString());
		}
		
		else
		{
			formBean.setStrHospitalCode("998");
			formBean.setStrSeatId("10007");
			formBean.setStrUserLevel("1");
		}LocationWiseStockSummaryRptDATA.getProgrammeCombo(formBean, request, response);
		return null;
	}

}
