/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         DrugInventoryWithProgramTransCNT.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.ItemInventoryTransWithProgramDATA;
import mms.transactions.controller.fb.DrugInventoryTransFB;
import mms.transactions.controller.fb.ItemInventoryWithProgramTransFB;
import mms.transactions.controller.utl.ItemInventoryWithProgramTransUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugInventoryWithProgramTransCNT.
 */
public class ItemInventoryWithProgramTransBSCNT extends GenericController {

	/** The strtarget. */
	String strtarget;

	/**
	 * calls super class constructor.
	 */

	public ItemInventoryWithProgramTransBSCNT() {
		super(new ItemInventoryWithProgramTransUTL(),
				"/transactions/ItemInventoryWithProgramTransBSCNT");

	}

	/**
	 * method name : ADD .
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
	public ActionForward ADD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		generateToken(request);
		ItemInventoryWithProgramTransFB fb = (ItemInventoryWithProgramTransFB) form;
		ItemInventoryTransWithProgramDATA.initialAddPHD(fb, request);
		strtarget = "add";
		return mapping.findForward(strtarget);

	}	
	

	/**
	 * Invoked by Ajax Functions and sets the required Item Name Values.
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

	public ActionForward SUBGRPAJAX(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		ItemInventoryWithProgramTransFB formBean = (ItemInventoryWithProgramTransFB) form;
		ItemInventoryTransWithProgramDATA.subGroupCombo(formBean, request,
				response);
		return null;
	}

	/**
	 * Invoked by Ajax Functions and sets the required Item Name Values.
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

	public ActionForward ITEMNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		ItemInventoryWithProgramTransFB formBean = (ItemInventoryWithProgramTransFB) form;
		ItemInventoryTransWithProgramDATA.itemName(formBean, request, response);
		return null;
	}

	/**
	 * Invoked by Ajax Functions and sets the required Item Name Values.
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

	public ActionForward GETGROUPNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		ItemInventoryWithProgramTransFB formBean = (ItemInventoryWithProgramTransFB) form;
		ItemInventoryTransWithProgramDATA.getGroupName(formBean, request,
				response);
		return null;
	}

	/**
	 * Invoked by Ajax Functions and sets the required Item Brand Name Values.
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

	public ActionForward ITEMBRANDNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		ItemInventoryWithProgramTransFB formBean = (ItemInventoryWithProgramTransFB) form;
		ItemInventoryTransWithProgramDATA.itemBrandName(formBean, request,
				response);
		return null;
	}

	/**
	 * Invoked by Ajax Functions and get Existing Batch of Selected Drug.
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

	public ActionForward EXISTINGBATCH(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		ItemInventoryWithProgramTransFB formBean = (ItemInventoryWithProgramTransFB) form;
		ItemInventoryTransWithProgramDATA.getExistingBatchList(formBean,
				request, response);
		return null;
	}
	
	
	/**
	 * Invoked by Ajax Functions and get Existing Batch of Selected Drug.
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

	public ActionForward EXISTINGBATCHMODIFY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		ItemInventoryWithProgramTransFB formBean = (ItemInventoryWithProgramTransFB) form;
		ItemInventoryTransWithProgramDATA.getExistingBatchListModify(formBean,request, response);
		return null;
	}

	/**
	 * Invoked by Ajax Functions and get Existing Batch of Selected Drug.
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

	public ActionForward RATEUNIT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		ItemInventoryWithProgramTransFB formBean = (ItemInventoryWithProgramTransFB) form;
		ItemInventoryTransWithProgramDATA.getRateUnit(formBean, request,
				response);
		return null;
	}

	/**
	 * Invoked by Ajax Functions and get Existing Batch of Selected Drug.
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

	public ActionForward EXISTINGBATCHINSTCOK(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		ItemInventoryWithProgramTransFB formBean = (ItemInventoryWithProgramTransFB) form;
		ItemInventoryTransWithProgramDATA.getExistingBatchInStock(formBean,
				request, response);
		return null;
	}

	/**
	 * Invoked by Ajax Functions and get Existing Batch of Selected Supplier.
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

	public ActionForward EXISTINGSUPPBATCHINSTCOK(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		ItemInventoryWithProgramTransFB formBean = (ItemInventoryWithProgramTransFB) form;
		ItemInventoryTransWithProgramDATA.getExistingSuppBatchInStock(formBean,
				request, response);
		return null;
	}

	/**
	 * Invoked by Ajax Functions and get Existing Batch Details of Selected
	 * Drug.
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

	public ActionForward EXISTINGBATCHDTL(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		ItemInventoryWithProgramTransFB formBean = (ItemInventoryWithProgramTransFB) form;
		ItemInventoryTransWithProgramDATA.getExistingBatchDetails(formBean,
				request, response);
		return null;
	}

	/**
	 * Invoked by Ajax Functions and sets the required Item Brand Details.
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

	public ActionForward BRANDDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		ItemInventoryWithProgramTransFB formBean = (ItemInventoryWithProgramTransFB) form;
		ItemInventoryTransWithProgramDATA.getBrandDetails(formBean, request,
				response);
		return null;
	}

	/**
	 * Invoked by Ajax Functions and sets the required Unit Name Values.
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

	public ActionForward UNITNAMECOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		ItemInventoryWithProgramTransFB formBean = (ItemInventoryWithProgramTransFB) form;
		ItemInventoryTransWithProgramDATA.unitNameCombo(formBean, request,
				response);
		return null;
	}

	/**
	 * used for manufacture name combo.
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

	public ActionForward MANUFECTURENAME(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		ItemInventoryWithProgramTransFB formBean = (ItemInventoryWithProgramTransFB) form;

		ItemInventoryTransWithProgramDATA.manufectuteName(formBean, request,
				response);

		return null;

	}

	/**
	 * To add data.
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

	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		try {
			this.validateToken(request, response);
			//saveToken(request);
			ItemInventoryWithProgramTransFB formBean = (ItemInventoryWithProgramTransFB) form;
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			ItemInventoryTransWithProgramDATA.dummyinsert(formBean);
			formBean.setPrintFlag("1");;
			
			return mapping.findForward("add");
			
			/*ActionForward acFwd = new ActionForward();
			acFwd.setPath("/mms/transactions/ItemInventoryTransCNT.cnt?hmode=LISTPAGE1");
			acFwd.setContextRelative(true);
			return acFwd;*/
			//return this.ADD(mapping, form, request, response);
		} catch (Exception e) {
			
		}

		return null;
	}

	/**
	 * To add datab For Existing Batch in Current Stock.
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

	public ActionForward INSERT2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		try {
			this.validateToken(request, response);
			//saveToken(request);
			validateToken(request, response);
			ItemInventoryWithProgramTransFB formBean = (ItemInventoryWithProgramTransFB) form;
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
					.toString());
			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString());
			ItemInventoryTransWithProgramDATA.insert2(formBean);
			return this.ADD(mapping, form, request, response);
		} catch (Exception e) {
			
		}

		return null;
	}

	/**
	 * forwards control to the modify page.
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

	public ActionForward MODIFY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		try {
			generateToken(request);
			ItemInventoryWithProgramTransFB formBean = (ItemInventoryWithProgramTransFB) form;
			formBean.setStrChk(request.getParameter("chk"));
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			ItemInventoryTransWithProgramDATA.modify(formBean,request,response);			

			strtarget = "modify";
			return mapping.findForward(strtarget);
		} catch (Exception e) {
			
		}

		return null;
	}

	/**
	 * To modify data.
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

	public ActionForward UPDATE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		try {
			validateToken(request, response);
			ItemInventoryWithProgramTransFB formBean = (ItemInventoryWithProgramTransFB) form;
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			ItemInventoryTransWithProgramDATA.updateRecord(formBean,request);			
			//return this.GOTOLISTPAGE(mapping, form, request, response,formBean.getStrSavedDrugName() +"with Batch number ("+formBean.getStrSavedBatchName()+") are modified sucessfully.");			
			//return this.MODIFY(mapping, formBean, request, response);
			ActionForward acFwd = new ActionForward();
			acFwd.setPath("/mms/transactions/ItemInventoryTransBSCNT.cnt?hmode=LISTPAGE1");
			acFwd.setContextRelative(true);
			return acFwd;
			
		} catch (Exception e) {
			
		}

		return null;
	}

	/**
	 * Popup.
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
	public ActionForward POPUP(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/DrugProfileCNT.cnt?hmode=POPUP");
		acFwd.setContextRelative(true);
		return acFwd;
	}

	/**
	 * Getismodify.
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
	public ActionForward GETISMODIFY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		ItemInventoryWithProgramTransFB formBean = (ItemInventoryWithProgramTransFB) form;
		ItemInventoryTransWithProgramDATA.getIsModify(formBean, request,response);
		return null;
	}

	/**
	 * Cancelpage.
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
		/*ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		*/
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/ItemInventoryTransBSCNT.cnt?hmode=LISTPAGE1");
		acFwd.setContextRelative(true);
		return acFwd;
		
		/*ActionForward acFwd = new ActionForward();
	
		////System.out.println("store name"+formBean.get);
		acFwd.setPath("/mms/transactions/DrugInventoryTransCNT.cnt?hmode=CANCELPAGE");
		acFwd.setContextRelative(true);
		return acFwd;*/
	}
	
	public ActionForward GOTOLISTPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response , String strMsg)
	throws HisException, SQLException {
		ActionForward acFwd = new ActionForward();
		String strPath = "";
		if (request.getParameter("strPath") != null) {
			 
			strPath = request.getParameter("strPath").concat("?hmode=CANCEL&msg="+strMsg);			 
			acFwd.setPath(strPath);
			acFwd.setContextRelative(true);

		}
		return acFwd;
	}
	
	public ActionForward PRINTVOUCHER(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ItemInventoryWithProgramTransFB formBean = (ItemInventoryWithProgramTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		ItemInventoryTransWithProgramDATA.printVoucher(request, response, formBean);
		return null;
	}
	
	

}
