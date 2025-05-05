package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.ItemConfigurationTransDATA;
import mms.transactions.controller.data.ItemConfigurationTransDATA;
import mms.transactions.controller.fb.ItemConfigurationTransFB;
import mms.transactions.controller.fb.ItemConfigurationTransFB;

public class ItemConfigurationTransCNT extends CSRFGardTokenAction {
	
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
		ItemConfigurationTransFB formBean = (ItemConfigurationTransFB)form;
		ItemConfigurationTransDATA.initialAdd(formBean,request);
		String target = "item";
		return mapping.findForward(target);
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
		
		ItemConfigurationTransFB formBean = (ItemConfigurationTransFB)form;
		ItemConfigurationTransDATA.genItemName(formBean, request, response);
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
		
		ItemConfigurationTransFB formBean = (ItemConfigurationTransFB)form;
		ItemConfigurationTransDATA.itemName(formBean, request, response);
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
			throws HisException 
	{
		System.out.println("-------------- ItemConfigurationTransCNT.STOCKDTL -----------------");
		ItemConfigurationTransFB formBean = (ItemConfigurationTransFB)form;
		ItemConfigurationTransDATA.searchStockDtl(formBean,request,response);
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

		ItemConfigurationTransFB formBean = (ItemConfigurationTransFB)form;
		ItemConfigurationTransDATA.getStoreList(formBean,request,response);
		//return null;
		
		String target = "item";
		return mapping.findForward(target);
	}
	
	
	/** This method is used to save the miscellaneous Consumption and item details in database .
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward SAVE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
		throws Exception, SQLException 
	{
		validateToken(request, response);
		ItemConfigurationTransFB formBean = (ItemConfigurationTransFB) form;
		ItemConfigurationTransDATA.SAVE(formBean,request,response);
		return this.unspecified( mapping,  form,request,  response);
	}
}
