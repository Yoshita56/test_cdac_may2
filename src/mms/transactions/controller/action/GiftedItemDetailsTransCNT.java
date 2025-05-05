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
public class GiftedItemDetailsTransCNT extends CSRFGardTokenAction {
	
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
		System.out.println("-----------GiftedItemDetailsTransCNT.unspecified-----[ giftedItemDetailsTrans_mms.jsp ]-------");
		generateToken(request);
		GiftedItemDetailsTransFB formBean = (GiftedItemDetailsTransFB)form;
		GiftedItemDetailsTransDATA.initialGenAdd(formBean,request);
		String target = "add";
		return mapping.findForward(target);
	}
	
	
	public ActionForward INITPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		
		System.out.println("-----------GiftedItemDetailsTransCNT.INITPAGE-----[ giftedItemDetailsTrans_mms.jsp ]-------");
		
		generateToken(request);
		GiftedItemDetailsTransFB formBean = (GiftedItemDetailsTransFB)form;
		GiftedItemDetailsTransDATA.initialGenAdd(formBean,request);
		formBean.setStrGiftedItemViewMode("0");
		String target = "add";
		return mapping.findForward(target);
	}
	

	public ActionForward GETITEMCATLIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		GiftedItemDetailsTransFB formBean = (GiftedItemDetailsTransFB)form;
		GiftedItemDetailsTransDATA.getCategoryList(formBean, request, response);
		
		return null;
	}
	
	public ActionForward GETFINYR(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		GiftedItemDetailsTransFB formBean = (GiftedItemDetailsTransFB)form;
		GiftedItemDetailsTransDATA.getFinancialYear(formBean, request, response);
		
		return null;
	}
	
	
	
	
	public ActionForward GETGIFTITEMVIEWDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		GiftedItemDetailsTransFB formBean = (GiftedItemDetailsTransFB)form;
		GiftedItemDetailsTransDATA.getGiftedItemList(formBean, request, response);
		
		return null;
	}
	
	
	public ActionForward DRUGINVENTORY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		System.out.println("-----------GiftedItemDetailsTransCNT.ITEMINVENTORY-----[ gifted_drugInventory_mmstrans.jsp]-------");
		

		GiftedItemDetailsTransFB fb = (GiftedItemDetailsTransFB) form;

		GiftedItemDetailsTransDATA.initialAdd(fb, request); // to display the Store
		strtarget = "druginventory";
		return mapping.findForward(strtarget);

	}
	
	public ActionForward ITEMINVENTORY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		
		System.out.println("-----------GiftedItemDetailsTransCNT.DRUGINVENTORY-----[ gifted_itemInventory_mmstrans.jsp ]-------");
		generateToken(request);
		GiftedItemDetailsTransFB fb = (GiftedItemDetailsTransFB) form;

		GiftedItemDetailsTransDATA.initialAdd(fb, request); // to display the Store
		strtarget = "itemInventory";
		return mapping.findForward(strtarget);

	}

	
	public ActionForward SUBGRPLIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		System.out.println("-----------GiftedItemDetailsTransCNT.SUBGRPLIST------------");
		
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
		System.out.println("-----------GiftedItemDetailsTransCNT.ITEMNAME------------");
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
		System.out.println("-----------GiftedItemDetailsTransCNT.ITEMBRANDNAME------------");
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
		System.out.println("----------- GiftedItemDetailsTransCNT.BRANDDETAILS ------------");
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
		System.out.println("----------- GiftedItemDetailsTransCNT.UNITNAMECOMBO ------------");
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
		System.out.println("----------- GiftedItemDetailsTransCNT.MANUFECTURENAME ------------");
		
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
		
		System.out.println("----------- GiftedItemDetailsTransCNT.INSERT ------------");

		//saveToken(request);
		validateToken(request, response);

		GiftedItemDetailsTransFB formBean = (GiftedItemDetailsTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());
		//GiftedItemDetailsTransDATA.insert(formBean);
		GiftedItemDetailsTransDATA.insert(formBean, request, response);
		return this.INITPAGE(mapping, form, request, response);
		
	}

	
}
