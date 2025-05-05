/**********************************************************
 Project:	   DWH_CMSS	
 File:         SupplierDeskInterfaceTransCNT.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.controller.action;


import hisglobal.TokenConfig;
import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;
import hisglobal.transactionutil.GenericFormBean;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mms.transactions.controller.data.SupplierDeskInterfaceTransDATA;
import mms.transactions.controller.fb.SupplierDeskInterfaceTransFB;
import mms.transactions.controller.fb.SupplierDeskInterfaceTransJqgridListFB;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierDeskInterfaceTransCNT.
 */
//public class SupplierDeskInterfaceTransCNT extends GenericController {
//public class SupplierDeskInterfaceTransCNT extends DispatchAction {
public class SupplierDeskInterfaceTransCNT extends DispatchAction {
	/**
	 * Instantiates a new supplier desk interface trans cnt.
	 */
/*	public SupplierDeskInterfaceTransCNT() {
		super(new SupplierDeskInterfaceTransUTL(),
				"/transactions/SupplierDeskInterfaceTransCNT");
	}*/


	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {
		return this.LISTDATA(mapping, form, request, response);
	}
	
	public ActionForward LISTDATA(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		//generateToken(request);
		
		//System.out.println("in cnt");
		
		String strtarget = "list";
		SupplierDeskInterfaceTransFB formBean = (SupplierDeskInterfaceTransFB) form;
		//System.out.println();
			
		return mapping.findForward(strtarget);

	}
	
	public ActionForward SupplierInterfaceDATA(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException 
			{
				
				ArrayList<SupplierDeskInterfaceTransJqgridListFB> messagesData = null;		
				try
				{
					//System.out.println("<--SECOUND METHOD-->");			
					SupplierDeskInterfaceTransFB formBean = (SupplierDeskInterfaceTransFB) form;

					messagesData = SupplierDeskInterfaceTransDATA.SupplierInterfaceDATAList(formBean, request, response);						
					Gson gson = new GsonBuilder().setPrettyPrinting().create();
					String jsonArray = gson.toJson(messagesData);
					jsonArray = "{\"page\":1,\"total\":\"2\",\"records\":" + messagesData.size() + ",\"rows\":" + jsonArray + "}";
		            //System.out.println("jsonArray--->"+jsonArray); 
					
					response.getWriter().print(jsonArray);
					//System.out.println(">>>>>>>>>>"+formBean.getStrStoreId());
				
				}
				catch (Exception ex)
				{
				  ex.printStackTrace();
				}
				finally
				{
				
				}
				
				
				return null;
			}
			
	/**
	 * ACCEPTANCE.
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
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward ACCEPTANCE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, IOException, ServletException 
	{
		String strTarget = "";
		SupplierDeskInterfaceTransFB formBean = (SupplierDeskInterfaceTransFB) form;
		strTarget = "supplierAcceptanceJsp";		
		SupplierDeskInterfaceTransDATA.setSupplierInterfaceViewValues(formBean, request,response);
		return mapping.findForward(strTarget);
	}
	
	public ActionForward generatePdf(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception, SQLException {
		SupplierDeskInterfaceTransFB formBean = (SupplierDeskInterfaceTransFB) form;
		SupplierDeskInterfaceTransDATA.generatePdf(request, response, formBean);
		return null;
	}
	
	/**
	 * DELIVERYDETAIL.
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
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward DELIVERYDETAIL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		String strTarget = "";
		SupplierDeskInterfaceTransFB formBean = (SupplierDeskInterfaceTransFB) form;
		strTarget = "supplierDeliveryJsp";
		
		SupplierDeskInterfaceTransDATA.setDeliveryDetails(formBean, request,response);

		return mapping.findForward(strTarget);
	}
	
	/**
	 * VIEW.
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
	 */
	public ActionForward VIEW(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		String strTarget = "";
		SupplierDeskInterfaceTransFB formBean = (SupplierDeskInterfaceTransFB) form;
		//formBean.setStrViewMode("1");
		strTarget = "supplierAcceptanceViewJsp";		
		SupplierDeskInterfaceTransDATA.setSupplierInterfaceViewValues(formBean, request,response);
		return mapping.findForward(strTarget);
	}


	/**
	 * CANCELPAGE.
	 * 
	 * @param _mapping
	 *            the _mapping
	 * @param _form
	 *            the _form
	 * @param request
	 *            the request
	 * @param _response
	 *            the _response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 */
	public ActionForward CANCELPAGE(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse _response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}



	/**
	 * PAYMENT.
	 * 
	 * @param _mapping
	 *            the _mapping
	 * @param _form
	 *            the _form
	 * @param request
	 *            the request
	 * @param _response
	 *            the _response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 */
	public ActionForward PAYMENT(ActionMapping _mapping,
			ActionForm _form, HttpServletRequest request,
			HttpServletResponse _response) throws HisException {

		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/reports/SupplierPaymentDtailRptCNT.cnt?hmode=GETSUPPPERPAYMENTDTL");		
		acFwd.setContextRelative(true);
		return acFwd;
	}

	/**
	 * SUPPLIERPERFORMANCE.
	 * 
	 * @param _mapping
	 *            the _mapping
	 * @param _form
	 *            the _form
	 * @param request
	 *            the request
	 * @param _response
	 *            the _response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 */
	public ActionForward SUPPLIERPERFORMANCE(ActionMapping _mapping,
			ActionForm _form, HttpServletRequest request,
			HttpServletResponse _response) throws HisException {

		ActionForward acFwd = new ActionForward();
		((GenericFormBean) _form).getComboValue();

		request.getParameter("chk");
		new StringBuffer("");
		acFwd.setPath("/mms/reports/SupplierPerformanceDtailRptCNT.cnt?hmode=unspecified&supplierInterfaceFlag=1");
		acFwd.setContextRelative(true);
		return acFwd;
	}

	
	
	/**
	 * CANCELTOSUPPLIERDESK.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 */
	public ActionForward CANCELTOSUPPLIERDESK(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/SupplierDeskInterfaceTransCNT.cnt?hmode=unspecified");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	/**
	 * PRINT the.
	 * 
	 * @param _mapping
	 *            the _mapping
	 * @param _form
	 *            the _form
	 * @param _request
	 *            the _request
	 * @param _response
	 *            the _response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 */
	public ActionForward PRINT(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/PODeskPrintTransCNT.cnt?hmode=SUPPLIERPRINT");
		acFwd.setContextRelative(true);
		return acFwd;
	}

	/**
	 * INSERTACCEPTANCE.
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
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward INSERTACCEPTANCE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		SupplierDeskInterfaceTransFB formBean = (SupplierDeskInterfaceTransFB) form;

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		
		boolean fltRes = SupplierDeskInterfaceTransDATA.insertAcceptance(formBean,request,response);

		if (fltRes)
		{

			//return LIST(mapping, form, request, response);
			return LISTDATA(mapping, form, request, response);

		} else {

			return this.ACCEPTANCE(mapping, formBean, request, response);

		}

	}
	
	/**
	 * INSERTDELIVERY.
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
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward INSERTDELIVERY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		SupplierDeskInterfaceTransFB formBean = (SupplierDeskInterfaceTransFB) form;

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		
		boolean fltRes = SupplierDeskInterfaceTransDATA.insertDelivery(formBean,request,response);

		if (fltRes)
		{

			return this.DELIVERYDETAIL(mapping, formBean, request, response);

		} 
		else 
		{

			return this.DELIVERYDETAIL(mapping, formBean, request, response);

		}

	}


	/**
	 * deletePreviousDeliveryDtls
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
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward deletePreviousDeliveryDtls(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException, IOException, ServletException {

		SupplierDeskInterfaceTransFB formBean = (SupplierDeskInterfaceTransFB) form;

		//SupplierDeskInterfaceTransDATA.deletePreviousDeliveryDtls(formBean,	request, response);

		return DELIVERYDETAIL(mapping, form, request, response);
	}

	/**
	 *SCHEDULECOMBO
	 * @param mapping            the mapping
	 * @param form            the form
	 * @param request            the request
	 * @param response            the response
	 * @return the pop on supp challan no
	 * @throws HisException             the his esxception
	 * @throws SQLException             the SQL exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public ActionForward SCHEDULECOMBO(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException, IOException, ServletException {

		SupplierDeskInterfaceTransFB formBean = (SupplierDeskInterfaceTransFB) form;
		SupplierDeskInterfaceTransDATA.getScheduleCombo(formBean, request,	response);
		return null;
	}
	
	public ActionForward BATCHDTL(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException, IOException, ServletException {

		SupplierDeskInterfaceTransFB formBean = (SupplierDeskInterfaceTransFB) form;
		SupplierDeskInterfaceTransDATA.getBatchCombo(formBean, request,	response);
		return null;
	}
	
	
	
	/**
	 *PREVDELIVERYDETAILS
	 * @param mapping            the mapping
	 * @param form            the form
	 * @param request            the request
	 * @param response            the response
	 * @return the pop on supp challan no
	 * @throws HisException             the his esxception
	 * @throws SQLException             the SQL exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public ActionForward PREVDELIVERYDETAILS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException, IOException, ServletException 
	{

		SupplierDeskInterfaceTransFB formBean = (SupplierDeskInterfaceTransFB) form;
		SupplierDeskInterfaceTransDATA.getPreviousDeliveryDtls(formBean, request,	response);
		return null;
	}
	
	
	
	
	/**
	 *DRUGCOMBO
	 * @param mapping            the mapping
	 * @param form            the form
	 * @param request            the request
	 * @param response            the response
	 * @return the pop on supp challan no
	 * @throws HisException             the his exception
	 * @throws SQLException             the SQL exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public ActionForward DRUGCOMBO(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException, IOException, ServletException {

		SupplierDeskInterfaceTransFB formBean = (SupplierDeskInterfaceTransFB) form;
		SupplierDeskInterfaceTransDATA.getStrDrugNameCombo(formBean, request,	response);
		return null;
	}
	
	/**
	 * GETITEMDTLHLP.
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
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward GETITEMDTLHLP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		SupplierDeskInterfaceTransFB formBean = (SupplierDeskInterfaceTransFB) form;

		SupplierDeskInterfaceTransDATA.getItemDtlHlp(formBean, request, response);

		return null;
	}
	/**
	 * VIEWDELIVERYDTLS.
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
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward VIEWDELIVERYDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		SupplierDeskInterfaceTransFB formBean = (SupplierDeskInterfaceTransFB) form;

		SupplierDeskInterfaceTransDATA.viewDetails(formBean, request, response);

		return null;
	}
	
	/**
	 * DELETEDETAILS.
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
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward DELETEDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		SupplierDeskInterfaceTransFB formBean = (SupplierDeskInterfaceTransFB) form;

		SupplierDeskInterfaceTransDATA.deleteDetails(formBean, request, response);

		return null;
	}
	/**
	 *SCHEDULECOMBO
	 * @param mapping            the mapping
	 * @param form            the form
	 * @param request            the request
	 * @param response            the response
	 * @return the pop on supp challan no
	 * @throws HisException             the his esxception
	 * @throws SQLException             the SQL exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public ActionForward LocationWiseProgrammeDtls(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException, IOException, ServletException 
	{

		SupplierDeskInterfaceTransFB formBean = (SupplierDeskInterfaceTransFB) form;
		SupplierDeskInterfaceTransDATA.LocationWiseProgrammeDtls(formBean, request,	response);
		return null;
	}
	
	/**
	 * Getuploadedfile.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws Exception 
	 */
	public ActionForward GETUPLOADEDFILE(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SupplierDeskInterfaceTransFB formBean = (SupplierDeskInterfaceTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		SupplierDeskInterfaceTransDATA.downloadFile(formBean, request, response);
		return null;

	}
	
	
	public ActionForward GETBARCODEDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException 
			{

		SupplierDeskInterfaceTransFB fb = (SupplierDeskInterfaceTransFB) form;
		SupplierDeskInterfaceTransDATA.getBarcodeDtls(fb, request, response);

		return null;
	}
	
	public ActionForward GETREPORT(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException, IOException, ServletException 
	{
		String strtarget;
		//System.out.println("<--GET REPORT METHOD tp-->");	
		SupplierDeskInterfaceTransFB fb = (SupplierDeskInterfaceTransFB) form;	
		SupplierDeskInterfaceTransDATA.getReport(fb, request, response);
		//System.out.println("<--GET REPORT METHOD-2 tp->");
		strtarget = "Report";
		return mapping.findForward(strtarget);
	}

	public void generatePdf1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		SupplierDeskInterfaceTransFB fb = (SupplierDeskInterfaceTransFB) form;
		SupplierDeskInterfaceTransDATA.generatePdf1(fb, request, response);
	}
	

}
