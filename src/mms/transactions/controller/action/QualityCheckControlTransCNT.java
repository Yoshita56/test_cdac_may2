/**
 * 
 */
package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.QualityCheckControlTransDATA;
import mms.transactions.controller.fb.QualityCheckControlTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * Developer : Tanvi Sappal
 * Date : 04/Jun/2009
 * Version : 1.0
 *
 */
public class QualityCheckControlTransCNT extends DispatchAction{
	
	/**
	 * To display the Store Name on the Screen.
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

		QualityCheckControlTransFB formBean = (QualityCheckControlTransFB)form;
		QualityCheckControlTransDATA.initialAdd(formBean,request);
		//QualityCheckControlTransDATA.unitName(formBean, request);
		String target = "add";
		return mapping.findForward(target);
	}
	
	/**
	 * Invoked by Ajax Functions and sets the required Item Category Values.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward ITEMCATEGORY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		QualityCheckControlTransFB formBean = (QualityCheckControlTransFB)form;
		QualityCheckControlTransDATA.itemCatNo(formBean, request, response);
		return null;
	}
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	public ActionForward GETQCDRUGLIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{

		QualityCheckControlTransFB formBean = (QualityCheckControlTransFB)form;
		QualityCheckControlTransDATA.getDrugNameCmb(formBean, request, response);
		
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
		
		QualityCheckControlTransFB formBean = (QualityCheckControlTransFB)form;
		QualityCheckControlTransDATA.groupName(formBean, request, response);
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
		
		QualityCheckControlTransFB formBean = (QualityCheckControlTransFB)form;
		QualityCheckControlTransDATA.subGroupName(formBean, request, response);
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
		
		QualityCheckControlTransFB formBean = (QualityCheckControlTransFB)form;
		QualityCheckControlTransDATA.genItemName(formBean, request, response);
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
		
		QualityCheckControlTransFB formBean = (QualityCheckControlTransFB)form;
		QualityCheckControlTransDATA.itemName(formBean, request, response);
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
	public ActionForward BATCHNO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		QualityCheckControlTransFB formBean = (QualityCheckControlTransFB)form;
		QualityCheckControlTransDATA.batchNo(formBean, request, response);
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
	public ActionForward BATCHNOTWO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		QualityCheckControlTransFB formBean = (QualityCheckControlTransFB)form;
		QualityCheckControlTransDATA.getDrugBatchCmb(formBean, request, response);
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
	public ActionForward UNITNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		QualityCheckControlTransFB formBean = (QualityCheckControlTransFB)form;
		QualityCheckControlTransDATA.unitName(formBean, request, response);
		return null;
	}
	
	/**
	 * Invoked by Ajax Functions and sets the required Committee Name Values.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward COMMITTEENAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		QualityCheckControlTransFB formBean = (QualityCheckControlTransFB)form;
		QualityCheckControlTransDATA.committeeName(formBean, request);
		return null;
	}
	
	/**
	 * Invoked by Ajax Functions and sets the required Committee Member Detail.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward COMMITEEMEMBERDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException ,SQLException{
		QualityCheckControlTransFB formBean = (QualityCheckControlTransFB)form;
		QualityCheckControlTransDATA.getMemberDtl(formBean, request,response);
		return null;
	}
	
	
	/**
	 * This function is used to insert details into database
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		
		QualityCheckControlTransFB formBean = (QualityCheckControlTransFB)form;
		QualityCheckControlTransDATA.insert(formBean,request);
	
		return this.unspecified(mapping, form, request, response);
	}
	
	/**
	 * To display Item Category Values on the View Page Screen.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward VIEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
				
		QualityCheckControlTransFB formBean = (QualityCheckControlTransFB)form;
		QualityCheckControlTransDATA.getStoreName(formBean, request);
		String target = "view";
		return mapping.findForward(target);
	}
	
	public ActionForward VIEWITEM(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
				
		QualityCheckControlTransFB formBean = (QualityCheckControlTransFB)form;
		QualityCheckControlTransDATA.getitemCategory(formBean, request,response);
		return null;
	}
	
	public ActionForward VIEWITEMGO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
				
		QualityCheckControlTransFB formBean = (QualityCheckControlTransFB)form;
		QualityCheckControlTransDATA.goView(formBean, request);
		String target = "view";
		return mapping.findForward(target);
	}

	/** This method is used to cancel the Main Page.
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
			 
	
	
}
