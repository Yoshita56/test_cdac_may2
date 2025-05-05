package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.LocalPurchaseTransDATA;
import mms.transactions.controller.fb.LocalPurchaseTransFB;
import mms.transactions.controller.utl.LocalPurchaseTransUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LocalPurchaseTransCNT extends GenericController {

	String strtarget;

	/**
	 * calls super class constructor
	 */

	public LocalPurchaseTransCNT()
	{
		super(new LocalPurchaseTransUTL(),"/transactions/LocalPurchaseTransCNT");

	}

	/**
	 * forwards control to the ADD page.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward ADD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		LocalPurchaseTransFB fb = (LocalPurchaseTransFB) form;
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		 String strTarget="";
		
			LocalPurchaseTransDATA.initialAdd(fb, request); // to display the Store
			strtarget = "add";		
		
		return mapping.findForward(strtarget);

	}

	
	/**
	 * Invoked by Ajax Functions and sets the required Item Name Values.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward SUBGRPAJAX(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		LocalPurchaseTransFB formBean = (LocalPurchaseTransFB) form;
		LocalPurchaseTransDATA.subGroupCombo(formBean, request, response);
		return null;
	}
	
	/**
	 * Invoked by Ajax Functions and sets the required Item Name Values.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward ITEMNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		LocalPurchaseTransFB formBean = (LocalPurchaseTransFB) form;
		LocalPurchaseTransDATA.itemName(formBean, request, response);
		return null;
	}
	/**
	 * Invoked by Ajax Functions and sets the required Item Name Values.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward GETGROUPNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		LocalPurchaseTransFB formBean = (LocalPurchaseTransFB) form;
		LocalPurchaseTransDATA.getGroupName(formBean, request, response);
		return null;
	}

	/**
	 * Invoked by Ajax Functions and sets the required Item Brand Name Values.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward ITEMBRANDNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		LocalPurchaseTransFB formBean = (LocalPurchaseTransFB) form;
		LocalPurchaseTransDATA.itemBrandName(formBean, request, response);
		return null;
	}

	/**
	 * Invoked by Ajax Functions and get Existing Batch of Selected 
	 * Drug 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward EXISTINGBATCH(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		LocalPurchaseTransFB formBean = (LocalPurchaseTransFB) form;
		LocalPurchaseTransDATA.getExistingBatchList(formBean, request, response);
		return null;
	}
	
	
	/**
	 * Invoked by Ajax Functions and get Existing Batch of Selected 
	 * Drug 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward EXISTINGBATCHINSTCOK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		LocalPurchaseTransFB formBean = (LocalPurchaseTransFB) form;
		LocalPurchaseTransDATA.getExistingBatchInStock(formBean, request, response);
		return null;
	}
	
	
	/**
	 * Invoked by Ajax Functions and get Existing Batch Details of Selected 
	 * Drug 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward EXISTINGBATCHDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		LocalPurchaseTransFB formBean = (LocalPurchaseTransFB) form;
		LocalPurchaseTransDATA.getExistingBatchDetails(formBean, request, response);
		return null;
	}
	
	
	
	
	
	
	
	/**
	 * Invoked by Ajax Functions and sets the required Item Brand Details.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward BRANDDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		LocalPurchaseTransFB formBean = (LocalPurchaseTransFB) form;
		LocalPurchaseTransDATA.getBrandDetails(formBean, request, response);
		return null;
	}
	
	
	/**
	 * Invoked by Ajax Functions and sets the required Unit Name Values.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward UNITNAMECOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		LocalPurchaseTransFB formBean = (LocalPurchaseTransFB) form;
		LocalPurchaseTransDATA.unitNameCombo(formBean, request, response);
		return null;
	}

	/**
	 * used for manufacture name combo
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward MANUFECTURENAME(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		LocalPurchaseTransFB formBean = (LocalPurchaseTransFB) form;

		LocalPurchaseTransDATA.manufectuteName(formBean, request, response);

		return null;

	}

	/**
	 * To add data.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 * @throws SQLException
	 */

	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		saveToken(request);
		LocalPurchaseTransFB formBean = (LocalPurchaseTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		LocalPurchaseTransDATA.insert(formBean);
		return this.ADD(mapping, form, request, response);
	}
	

	/**
	 * To add data.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 * @throws SQLException
	 */

	public ActionForward DUMMYINSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		saveToken(request);
		LocalPurchaseTransFB formBean = (LocalPurchaseTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		LocalPurchaseTransDATA.dummyinsert(formBean);
		return this.ADD(mapping, form, request, response);
	}
	
	
	/**
	 * To add datab For Existing Batch in Current Stock.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 * @throws SQLException
	 */

	public ActionForward INSERT2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		saveToken(request);

		LocalPurchaseTransFB formBean = (LocalPurchaseTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());
		LocalPurchaseTransDATA.insert2(formBean);
		return this.ADD(mapping, form, request, response);
	}
	

	/**
	 * forwards control to the modify page.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward MODIFY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		LocalPurchaseTransFB formBean = (LocalPurchaseTransFB) form;

		formBean.setStrChk(request.getParameter("chk"));

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

		LocalPurchaseTransDATA.modify(formBean);

		strtarget = "modify";
		return mapping.findForward(strtarget);
	}

	/**
	 * To modify data.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward UPDATE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		saveToken(request);
		boolean retValue = false;
		LocalPurchaseTransFB formBean = (LocalPurchaseTransFB) form;

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());

		retValue = LocalPurchaseTransDATA.update(formBean);

		if (retValue)
			return this.LIST(mapping, form, request, response);
		else
			return this.MODIFY(mapping, form, request, response);
	}

	public ActionForward POPUP(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/DrugProfileCNT.cnt?hmode=POPUP");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	
	public ActionForward GETISMODIFY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		LocalPurchaseTransFB formBean = (LocalPurchaseTransFB) form;
		LocalPurchaseTransDATA.getIsModify(formBean, request, response);
		return null;
	}

	public ActionForward CANCELPAGE(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse _response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}

}
