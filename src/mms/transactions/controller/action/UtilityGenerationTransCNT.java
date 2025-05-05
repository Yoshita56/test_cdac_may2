/**
 * 
 */
package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.IndentPrintTransDATA;
import mms.transactions.controller.data.UtilityGenerationTransDATA;
import mms.transactions.controller.fb.IndentPrintTransFB;
import mms.transactions.controller.fb.UtilityGenerationTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * Developer : Tanvi Sappal
 * Version : 1.0
 * Date : 18/June/2009
 */
public class UtilityGenerationTransCNT extends DispatchAction {
	
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

		UtilityGenerationTransFB formBean = (UtilityGenerationTransFB)form;
		formBean.setStrIpNo("");
		formBean.setStrPatDetails("");
		UtilityGenerationTransDATA.initialAdd(formBean,request);
		String target = "item";
		return mapping.findForward(target);
	}
	
	public ActionForward GETPATDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		UtilityGenerationTransFB formBean = (UtilityGenerationTransFB)form;
		UtilityGenerationTransDATA.getPatDtl(formBean,request,response);
		String target = "item";
		return mapping.findForward(target);
	}
	
	public ActionForward SAVE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		UtilityGenerationTransFB formBean = (UtilityGenerationTransFB)form;
		UtilityGenerationTransDATA.save(formBean,request,response);
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/UtilityGenerationDeskCNT.cnt?hmode=unspecified");
		acFwd.setContextRelative(true);
		return acFwd;
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
		
		UtilityGenerationTransFB formBean = (UtilityGenerationTransFB)form;
		UtilityGenerationTransDATA.getItemCat(formBean, request, response);
		return null;
	}
	
	public ActionForward GETUTILITYNO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		UtilityGenerationTransFB formBean = (UtilityGenerationTransFB)form;
		UtilityGenerationTransDATA.getUtilityNo(formBean,request,response);
		String target = "item";
		return mapping.findForward(target);
	}
	
	public ActionForward GETINDENTNO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		UtilityGenerationTransFB formBean = (UtilityGenerationTransFB)form;
		UtilityGenerationTransDATA.getIndentNo(formBean,request,response);
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
	public ActionForward GROUPNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		UtilityGenerationTransFB formBean = (UtilityGenerationTransFB)form;
		UtilityGenerationTransDATA.groupName(formBean, request, response);
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
		
		UtilityGenerationTransFB formBean = (UtilityGenerationTransFB)form;
		UtilityGenerationTransDATA.subGroupName(formBean, request, response);
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
		
		UtilityGenerationTransFB formBean = (UtilityGenerationTransFB)form;
		UtilityGenerationTransDATA.genItemName(formBean, request, response);
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
		
		UtilityGenerationTransFB formBean = (UtilityGenerationTransFB)form;
		UtilityGenerationTransDATA.itemName(formBean, request, response);
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
		
		UtilityGenerationTransFB formBean = (UtilityGenerationTransFB)form;
		UtilityGenerationTransDATA.batchSerialNo(formBean, request, response);
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

		UtilityGenerationTransFB formBean = (UtilityGenerationTransFB)form;
		UtilityGenerationTransDATA.searchStockDtl(formBean,request,response);
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

		UtilityGenerationTransFB formBean = (UtilityGenerationTransFB)form;
		UtilityGenerationTransDATA.getStoreList(formBean,request,response);
		//return null;
		
		String target = "item";
		return mapping.findForward(target);
	}
	
	public void PRINT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		
		UtilityGenerationTransFB formBean = (UtilityGenerationTransFB)form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		UtilityGenerationTransDATA.showReport(formBean, request, response);
		
	}
	
	//String strPrintHLP=UtilityGenerationTransHLP.getPrintDtl(vo);
	////formBean.setStrPrintDtls(strPrintHLP);
	//formBean.setStrPrintFlag("1");
}
