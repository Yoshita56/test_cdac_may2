/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         DrugInventoryWithProgramTransCNT.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.controller.action;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;
import mms.transactions.controller.data.DrugInventoryTransWithProgramDATA;
import mms.transactions.controller.fb.DrugInventoryWithProgramTransFB;
import mms.transactions.controller.utl.DrugInventoryWithProgramTransUTL;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugInventoryWithProgramTransCNT.
 */
public class DrugInventoryWithProgramTransBSCNT extends GenericController {

	/** The strtarget. */
	String strtarget;

	/**
	 * calls super class constructor.
	 */

	public DrugInventoryWithProgramTransBSCNT() {
		super(new DrugInventoryWithProgramTransUTL(),
				"/transactions/DrugInventoryWithProgramTransBSCNT");

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
		DrugInventoryWithProgramTransFB fb = (DrugInventoryWithProgramTransFB) form;
		DrugInventoryTransWithProgramDATA.initialAddPHD(fb, request);
		strtarget = "add";
		return mapping.findForward(strtarget);

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
		DrugInventoryWithProgramTransFB formBean = (DrugInventoryWithProgramTransFB) form;
		DrugInventoryTransWithProgramDATA.itemBrandName(formBean, request,
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

	public ActionForward SUBGRPAJAX(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		DrugInventoryWithProgramTransFB formBean = (DrugInventoryWithProgramTransFB) form;
		DrugInventoryTransWithProgramDATA.subGroupCombo(formBean, request,
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
		DrugInventoryWithProgramTransFB formBean = (DrugInventoryWithProgramTransFB) form;
		DrugInventoryTransWithProgramDATA.itemName(formBean, request, response);
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
		DrugInventoryWithProgramTransFB formBean = (DrugInventoryWithProgramTransFB) form;
		DrugInventoryTransWithProgramDATA.getGroupName(formBean, request,
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
		DrugInventoryWithProgramTransFB formBean = (DrugInventoryWithProgramTransFB) form;
		DrugInventoryTransWithProgramDATA.getExistingBatchList(formBean,
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
		DrugInventoryWithProgramTransFB formBean = (DrugInventoryWithProgramTransFB) form;
		DrugInventoryTransWithProgramDATA.getExistingBatchListModify(formBean,request, response);
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
		DrugInventoryWithProgramTransFB formBean = (DrugInventoryWithProgramTransFB) form;
		DrugInventoryTransWithProgramDATA.getRateUnit(formBean, request,
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
		DrugInventoryWithProgramTransFB formBean = (DrugInventoryWithProgramTransFB) form;
		DrugInventoryTransWithProgramDATA.getExistingBatchInStock(formBean,
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
		DrugInventoryWithProgramTransFB formBean = (DrugInventoryWithProgramTransFB) form;
		DrugInventoryTransWithProgramDATA.getExistingSuppBatchInStock(formBean,
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
		DrugInventoryWithProgramTransFB formBean = (DrugInventoryWithProgramTransFB) form;
		DrugInventoryTransWithProgramDATA.getExistingBatchDetails(formBean,
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
		DrugInventoryWithProgramTransFB formBean = (DrugInventoryWithProgramTransFB) form;
		DrugInventoryTransWithProgramDATA.getBrandDetails(formBean, request,
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
		DrugInventoryWithProgramTransFB formBean = (DrugInventoryWithProgramTransFB) form;
		DrugInventoryTransWithProgramDATA.unitNameCombo(formBean, request,
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
		DrugInventoryWithProgramTransFB formBean = (DrugInventoryWithProgramTransFB) form;

		DrugInventoryTransWithProgramDATA.manufectuteName(formBean, request,
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
			DrugInventoryWithProgramTransFB formBean = (DrugInventoryWithProgramTransFB) form;
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			DrugInventoryTransWithProgramDATA.dummyinsert(formBean);
			
			formBean.setPrintFlag("1");;
			
			return mapping.findForward("add");
			
			/*ActionForward acFwd = new ActionForward();
			acFwd.setPath("/mms/transactions/DrugInventoryTransBSCNT.cnt?hmode=LISTPAGE1");
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

			DrugInventoryWithProgramTransFB formBean = (DrugInventoryWithProgramTransFB) form;
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
					.toString());
			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString());
			DrugInventoryTransWithProgramDATA.insert2(formBean);
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
			//this.validateToken(request, response);
			generateToken(request);
			DrugInventoryWithProgramTransFB formBean = (DrugInventoryWithProgramTransFB) form;
			formBean.setStrChk(request.getParameter("chk"));
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			DrugInventoryTransWithProgramDATA.modify(formBean,request,response);			

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
			DrugInventoryWithProgramTransFB formBean = (DrugInventoryWithProgramTransFB) form;
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			DrugInventoryTransWithProgramDATA.updateRecord(formBean,request);			
			//return this.GOTOLISTPAGE(mapping, form, request, response,formBean.getStrSavedDrugName() +"with Batch number ("+formBean.getStrSavedBatchName()+") are modified sucessfully.");			
			//return this.MODIFY(mapping, formBean, request, response);
			ActionForward acFwd = new ActionForward();
			acFwd.setPath("/mms/transactions/DrugInventoryTransBSCNT.cnt?hmode=LISTPAGE1");
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
		DrugInventoryWithProgramTransFB formBean = (DrugInventoryWithProgramTransFB) form;
		DrugInventoryTransWithProgramDATA.getIsModify(formBean, request,response);
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
		acFwd.setPath("/mms/transactions/DrugInventoryTransBSCNT.cnt?hmode=LISTPAGE1");
		acFwd.setContextRelative(true);
		return acFwd;
		
		/*ActionForward acFwd = new ActionForward();
	
		////System.out.println("store name"+formBean.get);
		acFwd.setPath("/mms/transactions/DrugInventoryTransBSCNT.cnt?hmode=CANCELPAGE");
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

		DrugInventoryWithProgramTransFB formBean = (DrugInventoryWithProgramTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		DrugInventoryTransWithProgramDATA.printVoucher(request, response, formBean);
		return null;
	}

}
