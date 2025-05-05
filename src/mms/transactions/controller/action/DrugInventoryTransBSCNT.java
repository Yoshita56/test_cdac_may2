package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.DrugInventoryTransDATA;
import mms.transactions.controller.fb.DrugInventoryTransFB;
import mms.transactions.controller.utl.DrugInventoryTransUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * 
 * Developer : Amit Kr
 * Version : 1.0 
 * Date : 12-Jun-2009
 * 
 */
public class DrugInventoryTransBSCNT extends GenericController {

	String strtarget;

	/**
	 * calls super class constructor
	 */

	public DrugInventoryTransBSCNT() {
		super(new DrugInventoryTransUTL(),
				"/transactions/DrugInventoryTransBSCNT");

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

		DrugInventoryTransFB fb = (DrugInventoryTransFB) form;

		
		// Type and Group Type
		// Name on next page
		// according to the selected
		
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		 String strTarget="";
		if(res.getString("DRUG_INVENTORY").equals("1"))
		{
			System.out.println("----DrugInventoryTransBSCNT.ADD---[drugInventory_add_mmstransNew.jsp]-------");
			DrugInventoryTransDATA.initialAdd(fb, request); // to display the Store
			strtarget = "add";
		}
		else
		{
			System.out.println("----DrugInventoryTransBSCNT.ADD---[drugInventory_dummy_add_mmstransNew.jsp]-------");
			DrugInventoryTransDATA.initialAddDummy(fb, request); // to display the Store
			strtarget = "dummyadd";
	 	}
		
		
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
		DrugInventoryTransFB formBean = (DrugInventoryTransFB) form;
		DrugInventoryTransDATA.subGroupCombo(formBean, request, response);
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
		DrugInventoryTransFB formBean = (DrugInventoryTransFB) form;
		DrugInventoryTransDATA.itemName(formBean, request, response);
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
		DrugInventoryTransFB formBean = (DrugInventoryTransFB) form;
		DrugInventoryTransDATA.getGroupName(formBean, request, response);
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
		DrugInventoryTransFB formBean = (DrugInventoryTransFB) form;
		DrugInventoryTransDATA.itemBrandName(formBean, request, response);
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
		DrugInventoryTransFB formBean = (DrugInventoryTransFB) form;
		DrugInventoryTransDATA.getExistingBatchList(formBean, request, response);
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
		DrugInventoryTransFB formBean = (DrugInventoryTransFB) form;
		DrugInventoryTransDATA.getExistingBatchInStock(formBean, request, response);
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
		DrugInventoryTransFB formBean = (DrugInventoryTransFB) form;
		DrugInventoryTransDATA.getExistingBatchDetails(formBean, request, response);
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
		DrugInventoryTransFB formBean = (DrugInventoryTransFB) form;
		DrugInventoryTransDATA.getBrandDetails(formBean, request, response);
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
		DrugInventoryTransFB formBean = (DrugInventoryTransFB) form;
		DrugInventoryTransDATA.unitNameCombo(formBean, request, response);
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
		DrugInventoryTransFB formBean = (DrugInventoryTransFB) form;

		DrugInventoryTransDATA.manufectuteName(formBean, request, response);

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
		DrugInventoryTransFB formBean = (DrugInventoryTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		DrugInventoryTransDATA.insert(formBean);
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
		DrugInventoryTransFB formBean = (DrugInventoryTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		DrugInventoryTransDATA.dummyinsert(formBean);
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

		DrugInventoryTransFB formBean = (DrugInventoryTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());
		DrugInventoryTransDATA.insert2(formBean);
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

		DrugInventoryTransFB formBean = (DrugInventoryTransFB) form;

		formBean.setStrChk(request.getParameter("chk"));

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());

		DrugInventoryTransDATA.modify(formBean);

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
		DrugInventoryTransFB formBean = (DrugInventoryTransFB) form;

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());

		retValue = DrugInventoryTransDATA.update(formBean);

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
	public ActionForward addNew(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		DrugInventoryTransFB formBean = (DrugInventoryTransFB) _form;
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/DrugInventoryWithProgramTransBSCNT.cnt?hmode=ADD&storeId="+formBean.getCombo()[0]+"&groupId="+formBean.getCombo()[1]+"&storeName="+formBean.getComboValue());
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward NEWMODIFY(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		DrugInventoryTransFB formBean = (DrugInventoryTransFB) _form;
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/DrugInventoryWithProgramTransBSCNT.cnt?hmode=MODIFY&storeId="+formBean.getCombo()[0]+"&groupId="+formBean.getCombo()[1]+"&concatVal="+formBean.getComboValue()+"^"+formBean.getCombo()[0]);
		acFwd.setContextRelative(true);
		return acFwd;
	}
	public ActionForward GETISMODIFY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		DrugInventoryTransFB formBean = (DrugInventoryTransFB) form;
		DrugInventoryTransDATA.getIsModify(formBean, request, response);
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
	
	public ActionForward LISTPAGE1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
				DrugInventoryTransFB formBean = (DrugInventoryTransFB) form;
			return this.LIST(mapping, form, request, response);
				
	}
	

}
