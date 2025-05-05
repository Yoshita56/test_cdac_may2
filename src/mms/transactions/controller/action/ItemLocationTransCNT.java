/**
 * 
 */
package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.ItemLocationTransDATA;
import mms.transactions.controller.fb.ItemLocationTransFB;

/**
 * Developer : Tanvi Sappal
 * Version : 1.0
 * Date : 18/June/2009
 */
public class ItemLocationTransCNT extends CSRFGardTokenAction {
	
	/**
	 * To display the Item Category Name on the Screen.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward object with target
	 * @throws HisException
	 */
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		generateToken(request);
		ItemLocationTransFB formBean = (ItemLocationTransFB)form;
		ItemLocationTransDATA.initialAdd(formBean,request);
		String target = "item";
		return mapping.findForward(target);
	}
	
	
	/**
	 * Invoked by Ajax Functions and sets the required group Name Values.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward ITEMCAT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		ItemLocationTransFB formBean = (ItemLocationTransFB)form;
		ItemLocationTransDATA.getItemCat(formBean, request, response);
		return null;
	}
	
	
	
	/**
	 * Invoked by Ajax Functions and sets the required group Name Values.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward GROUPNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		ItemLocationTransFB formBean = (ItemLocationTransFB)form;
		ItemLocationTransDATA.groupName(formBean, request, response);
		return null;
	}
	
	/**
	 * Invoked by Ajax Functions and sets the required subgroup Name Values.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward SUBGROUPNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		ItemLocationTransFB formBean = (ItemLocationTransFB)form;
		ItemLocationTransDATA.subGroupName(formBean, request, response);
		return null;
	}
	
	/**
	 * Invoked by Ajax Functions and sets the required Generic Item Name Values.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward GENITEMNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		ItemLocationTransFB formBean = (ItemLocationTransFB)form;
		ItemLocationTransDATA.genItemName(formBean, request, response);
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
		
		ItemLocationTransFB formBean = (ItemLocationTransFB)form;
		ItemLocationTransDATA.itemName(formBean, request, response);
		return null;
	}
	
	/**
	 * Invoked by Ajax Functions and sets the required Batch No.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward BATCHITEMNO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		ItemLocationTransFB formBean = (ItemLocationTransFB)form;
		ItemLocationTransDATA.batchSerialNo(formBean, request, response);
		return null;
	}
	
	/**
	 * To display Exist List on the Screen.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward object with target
	 * @throws HisException
	 */
	public ActionForward STOCKDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		ItemLocationTransFB formBean = (ItemLocationTransFB)form;
		ItemLocationTransDATA.searchStockDtl(formBean,request,response);
		return null;
	}
	
	
	/** This method is used to cancel the Item Location.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response)
			 {
			  ActionForward acFwd = new ActionForward();
			  acFwd.setPath("/hisglobal/initPage.jsp");
			  acFwd.setContextRelative(true);
			  return acFwd;
			 }
	
	public ActionForward STORELIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		ItemLocationTransFB formBean = (ItemLocationTransFB)form;
		ItemLocationTransDATA.getStoreList(formBean,request,response);
		//return null;
		
		String target = "item";
		return mapping.findForward(target);
	}
}
