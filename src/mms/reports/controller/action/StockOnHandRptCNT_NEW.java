/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         StockOnHandRptCNT.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
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
import mms.reports.controller.data.StockOnHandRptDATA_NEW;
import mms.reports.controller.fb.StockOnHandRptFB_NEW;

// TODO: Auto-generated Javadoc
/**
 * The Class StockOnHandRptCNT.
 */
public class StockOnHandRptCNT_NEW extends DispatchAction {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts.actions.DispatchAction#unspecified(org.apache.struts
	 * .action.ActionMapping, org.apache.struts.action.ActionForm,
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		return this.INITIALDATA(mapping, form, request, response);

	}

	/**
	 * Initialdata.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward INITIALDATA(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		String strTarget = "index";
		StockOnHandRptFB_NEW formBean = (StockOnHandRptFB_NEW) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		System.out.println("--------------------------HOSPITAL_CODE ::"+request.getSession().getAttribute("HOSPITAL_CODE").toString());

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		System.out.println("--------------------------SEATID ::"+request.getSession().getAttribute("SEATID").toString());

		/*
		 * formBean.setStrUserValue(request.getSession().getAttribute("USER_LEVEL").
		 * toString());
		 * System.out.println("--------------------------USERVALUE ::"+formBean.
		 * getStrUserValue());
		 */

		/*
		 * String strUserValue =
		 * request.getSession().getAttribute("USER_LEVEL").toString();
		 * System.out.println("--------------------------USERVALUE ::" +strUserValue);
		 */
		 

		try
		{			
			//System.out.println("---USERVALUE-[ If User Value 1 Means All Store Coming 0 Means Only Mapped Store Coming ]--"+request.getParameter("userValue").toString());		
			//formBean.setStrCircleId(request.getParameter("userValue").toString());
			formBean.setStrCircleId("0");
		    StockOnHandRptDATA_NEW.getStoreCombo(formBean, request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return mapping.findForward(strTarget);
	}

	/**
	 * Districtcmb.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward DISTRICTCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StockOnHandRptFB_NEW formBean = (StockOnHandRptFB_NEW) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		StockOnHandRptDATA_NEW.getDistrictList(formBean, request, response);
		return null;
	}

	/**
	 * Storecombo.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward STORECOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StockOnHandRptFB_NEW formBean = (StockOnHandRptFB_NEW) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		StockOnHandRptDATA_NEW.getStoreCombo(formBean, request, response);
		return null;
	}

	/**
	 * Storetypecmb.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward STORETYPECMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StockOnHandRptFB_NEW formBean = (StockOnHandRptFB_NEW) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		StockOnHandRptDATA_NEW.getStoreTypeList(formBean, request, response);
		return null;
	}

	/**
	 * Substorecombo.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward SUBSTORECOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StockOnHandRptFB_NEW formBean = (StockOnHandRptFB_NEW) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		StockOnHandRptDATA_NEW.getSubStoreCombo(formBean, request, response);
		return null;
	}

	/**
	 * Itemcatcmb.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StockOnHandRptFB_NEW formBean = (StockOnHandRptFB_NEW) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		StockOnHandRptDATA_NEW.getItemCatList(formBean, request, response);
		return null;
	}

	/**
	 * Groupcmb.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward GROUPCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StockOnHandRptFB_NEW formBean = (StockOnHandRptFB_NEW) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		StockOnHandRptDATA_NEW.getGroupList(formBean, request, response);
		return null;
	}

	/**
	 * Drugname.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward DRUGNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StockOnHandRptFB_NEW formBean = (StockOnHandRptFB_NEW) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		StockOnHandRptDATA_NEW.getDrugList(formBean, request, response);
		return null;
	}

	public ActionForward DRUGNAME1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StockOnHandRptFB_NEW formBean = (StockOnHandRptFB_NEW) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		StockOnHandRptDATA_NEW.getDrugList(formBean, request, response);
		return null;
	}

	/**
	 * Progname.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward PROGNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StockOnHandRptFB_NEW formBean = (StockOnHandRptFB_NEW) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		StockOnHandRptDATA_NEW.getProgrammeCombo(formBean, request, response);
		return null;
	}

	/**
	 * Showrpt.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	
	/*
	public void SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StockOnHandRptFB_NEW formBean = (StockOnHandRptFB_NEW) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		StockOnHandRptDATA_NEW.showReport(formBean, request, response);

	}
	*/
	
	public ActionForward SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException 
	{
		String strTarget="Html_Report";
		StockOnHandRptFB_NEW formBean = (StockOnHandRptFB_NEW) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		StockOnHandRptDATA_NEW.showReport_NEW(formBean, request, response);
		return mapping.findForward(strTarget);

	}

	/**
	 * Cancel.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 */
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}

}
