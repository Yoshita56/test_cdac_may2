package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.GiftedItemDetailsTransDATA;
import mms.transactions.controller.fb.GiftedItemDetailsTransFB;


/**
 * Developer : Tanvi Sappal
 * Version : 1.0
 * Date : 28/Jan/2009
 *  
*/
public class GiftedItemDetailsTransCNTNEW extends CSRFGardTokenAction {
	
	String strtarget = "";
	
	/**
	 * forwards control to the Page giftedItemDetailsTrans_mms.jsp
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
			throws HisException 
	{
		System.out.println("-----------GiftedItemDetailsTransCNTNEW.unspecified-----[ giftedItemDetailsTrans_mmsNEW.jsp ]-------");
		
		generateToken(request);
		GiftedItemDetailsTransFB formBean = (GiftedItemDetailsTransFB)form;
		GiftedItemDetailsTransDATA.initialGenAdd(formBean,request);
		String target = "add";
		return mapping.findForward(target);
	}
	
	
	public ActionForward INITPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		System.out.println("-----------GiftedItemDetailsTransCNTNEW.INITPAGE-----[ giftedItemDetailsTrans_mmsNEW.jsp ]-------");
		
		generateToken(request);
		GiftedItemDetailsTransFB formBean = (GiftedItemDetailsTransFB)form;
		GiftedItemDetailsTransDATA.initialGenAdd(formBean,request);
		formBean.setStrGiftedItemViewMode("0");
		String target = "add";
		return mapping.findForward(target);
	}
	

	public ActionForward GETITEMCATLIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		System.out.println("-----------GiftedItemDetailsTransCNTNEW.GETITEMCATLIST------------");

		GiftedItemDetailsTransFB formBean = (GiftedItemDetailsTransFB)form;
		GiftedItemDetailsTransDATA.getCategoryList(formBean, request, response);
		
		return null;
	}
	
	public ActionForward GETFINYR(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		System.out.println("-----------GiftedItemDetailsTransCNTNEW.GETFINYR------------");

		GiftedItemDetailsTransFB formBean = (GiftedItemDetailsTransFB)form;
		GiftedItemDetailsTransDATA.getFinancialYear(formBean, request, response);
		
		return null;
	}
	
	
	
	
	public ActionForward GETGIFTITEMVIEWDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		
		System.out.println("----------- GiftedItemDetailsTransCNTNEW . GETGIFTITEMVIEWDTLS ------------");

		GiftedItemDetailsTransFB formBean = (GiftedItemDetailsTransFB)form;
		GiftedItemDetailsTransDATA.getGiftedItemListNEW(formBean, request, response);
		
		return null;
	}
	
	
	public ActionForward DRUGINVENTORY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException
	{

		generateToken(request);
		
		System.out.println("-----------GiftedItemDetailsTransCNTNEW.INITPAGE-----[ gifted_drugInventory_mmstransNEW.jsp ]-------");
		
		GiftedItemDetailsTransFB fb = (GiftedItemDetailsTransFB) form;

		GiftedItemDetailsTransDATA.initialAdd(fb, request); // to display the Store
		strtarget = "druginventory";
		return mapping.findForward(strtarget);

	}
	
	public ActionForward ITEMINVENTORY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		System.out.println("-----------GiftedItemDetailsTransCNTNEW.INITPAGE-----[ gifted_itemInventory_mmstransNEW.jsp ]-------");
		generateToken(request);
		GiftedItemDetailsTransFB fb = (GiftedItemDetailsTransFB) form;

		GiftedItemDetailsTransDATA.initialAdd(fb, request); // to display the Store
		strtarget = "itemInventory";
		return mapping.findForward(strtarget);

	}

	
	public ActionForward SUBGRPLIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		GiftedItemDetailsTransFB formBean = (GiftedItemDetailsTransFB) form;
		GiftedItemDetailsTransDATA.getSubGroupList(formBean, request, response);
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
			throws HisException, SQLException 
	{
		System.out.println("-----------GiftedItemDetailsTransCNTNEW.ITEMNAME------------");
		
		GiftedItemDetailsTransFB formBean = (GiftedItemDetailsTransFB) form;
		GiftedItemDetailsTransDATA.itemName(formBean, request, response);
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
			throws HisException, SQLException 
	{
		System.out.println("-----------GiftedItemDetailsTransCNTNEW.ITEMBRANDNAME------------");
		GiftedItemDetailsTransFB formBean = (GiftedItemDetailsTransFB) form;
		GiftedItemDetailsTransDATA.itemBrandName(formBean, request, response);
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
			throws HisException, SQLException 
	{
		System.out.println("-----------GiftedItemDetailsTransCNTNEW.BRANDDETAILS------------");
		GiftedItemDetailsTransFB formBean = (GiftedItemDetailsTransFB) form;
		GiftedItemDetailsTransDATA.getBrandDetails(formBean, request, response);
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
			throws HisException, SQLException 
	{
		System.out.println("-----------GiftedItemDetailsTransCNTNEW.UNITNAMECOMBO------------");
		GiftedItemDetailsTransFB formBean = (GiftedItemDetailsTransFB) form;
		GiftedItemDetailsTransDATA.unitNameCombo(formBean, request, response);
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
			HttpServletResponse response) throws HisException, SQLException 
	{
		System.out.println("-----------GiftedItemDetailsTransCNTNEW.MANUFECTURENAME------------");
		GiftedItemDetailsTransFB formBean = (GiftedItemDetailsTransFB) form;

		GiftedItemDetailsTransDATA.manufectuteName(formBean, request, response);

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
	 * @throws Exception
	 * @throws SQLException
	 */

	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{

		//saveToken(request);
		System.out.println("-----------GiftedItemDetailsTransCNTNEW.INSERT------------");
		
		validateToken(request, response);

		GiftedItemDetailsTransFB formBean = (GiftedItemDetailsTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());
		GiftedItemDetailsTransDATA.insert(formBean,request,response);
		return this.INITPAGE(mapping, form, request, response);
	}


	
	  public ActionForward VOUCHERPRINT(ActionMapping mapping, ActionForm form,
	  HttpServletRequest request, HttpServletResponse response) throws HisException
	  { 
		  System.out.println("-----------GiftedItemDetailsTransCNTNEW.VOUCHERPRINT------------");
		  
		  GiftedItemDetailsTransFB formBean = ( GiftedItemDetailsTransFB)form;
	  GiftedItemDetailsTransDATA.voucherPrint(formBean, request,response);
	  
	  return null;
	  
	  }
	 

}
