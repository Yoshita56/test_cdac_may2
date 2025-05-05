/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         StockSummaryDateWiseRptCNT.java
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

import mms.reports.controller.data.ApplicationErrorLogDetailRptDATA;
import mms.reports.controller.data.StockSummaryDateWiseRptDATA;
import mms.reports.controller.fb.ApplicationErrorLogDetailRptFB;
import mms.reports.controller.fb.StockSummaryDateWiseRptFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

// TODO: Auto-generated Javadoc
/**
 * The Class StockSummaryDateWiseRptCNT.
 */
public class StockSummaryDateWiseRptCNT extends DispatchAction {

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
		StockSummaryDateWiseRptFB formBean = (StockSummaryDateWiseRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		StockSummaryDateWiseRptDATA.getStoreCombo(formBean, request, response);
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

		StockSummaryDateWiseRptFB formBean = (StockSummaryDateWiseRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		StockSummaryDateWiseRptDATA.getDistrictList(formBean, request, response);
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

		StockSummaryDateWiseRptFB formBean = (StockSummaryDateWiseRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		StockSummaryDateWiseRptDATA.getStoreCombo(formBean, request, response);
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

		StockSummaryDateWiseRptFB formBean = (StockSummaryDateWiseRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		StockSummaryDateWiseRptDATA.getStoreTypeList(formBean, request, response);
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

		StockSummaryDateWiseRptFB formBean = (StockSummaryDateWiseRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		StockSummaryDateWiseRptDATA.getDWHTypeList(formBean, request, response);
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

		StockSummaryDateWiseRptFB formBean = (StockSummaryDateWiseRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		StockSummaryDateWiseRptDATA.getDWHSubTypeList(formBean, request, response);
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

		StockSummaryDateWiseRptFB formBean = (StockSummaryDateWiseRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		StockSummaryDateWiseRptDATA.getSubStoreCombo(formBean, request, response);
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

		StockSummaryDateWiseRptFB formBean = (StockSummaryDateWiseRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		StockSummaryDateWiseRptDATA.getItemCatList(formBean, request, response);
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

		StockSummaryDateWiseRptFB formBean = (StockSummaryDateWiseRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		StockSummaryDateWiseRptDATA.getGroupList(formBean, request, response);
		return null;
	}
	
	public ActionForward ITEMNAME(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		StockSummaryDateWiseRptFB formBean = (StockSummaryDateWiseRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		StockSummaryDateWiseRptDATA.getItemCombo(formBean, request, response);
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

		StockSummaryDateWiseRptFB formBean = (StockSummaryDateWiseRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		StockSummaryDateWiseRptDATA.getDrugList(formBean, request, response);
		return null;
	}

	/**
	 * Showhtmlreport.
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
	public ActionForward SHOWHTMLREPORT(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, IOException, ServletException {

		String strTarget = "";
		strTarget = "printStockDateWise_HTML";
		StockSummaryDateWiseRptFB fb = (StockSummaryDateWiseRptFB) form;
		fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		StockSummaryDateWiseRptDATA.showHTMLReport(fb, request, response);	
		return mapping.findForward(strTarget);

	}
	
	public void SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StockSummaryDateWiseRptFB fb = (StockSummaryDateWiseRptFB) form;
		fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		StockSummaryDateWiseRptDATA.showReport(fb, request, response);
		
		
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

}
