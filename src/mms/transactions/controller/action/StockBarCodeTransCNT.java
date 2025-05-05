package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.StockBarCodeTransDATA;
import mms.transactions.controller.fb.StockBarCodeTransFB;

public class StockBarCodeTransCNT extends CSRFGardTokenAction {
	
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
	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		generateToken(request);
		StockBarCodeTransFB formBean = (StockBarCodeTransFB)form;
		StockBarCodeTransDATA.initialGenAdd(formBean,request);	
		System.out.println("------------- StockBarCodeTransCNT.unspecified ----[ bar_code_gene.jsp , BarCodeGene.js ]----------------");
		String target = "barCodeGene";
		return mapping.findForward(target);
	}
	
	/**
	 * This function is used to insert details into database
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public ActionForward INSERT_BARCODE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("------------ StockBarCodeTransCNTNEW .INSERT_BARCODE  ------------");
		
		validateToken(request, response);
		StockBarCodeTransFB formBean = (StockBarCodeTransFB)form;
		StockBarCodeTransDATA.insert(formBean,request);		
		return this.unspecified(mapping, form, request, response);
	}
	
	public ActionForward LPITEMNAME(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
			StockBarCodeTransFB formBean = (StockBarCodeTransFB)form;
			StockBarCodeTransDATA.lpitemName(formBean, request, response);
			return null;
	}
	
	public ActionForward ITEMBATCH(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
			StockBarCodeTransFB formBean = (StockBarCodeTransFB)form;
			StockBarCodeTransDATA.getItemBatch(formBean, request, response);
			return null;
	}
	
	public ActionForward GOVIEWPAGE(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
			
		StockBarCodeTransFB fb = (StockBarCodeTransFB) form;
		StockBarCodeTransDATA.getViewDtl(fb, request, response);
		//String target = "barCodePrint";
		//return mapping.findForward(target);
		return null;
	}	
	
	public ActionForward Print(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{	
		String target = "barCodePrint";
		return mapping.findForward(target);
		
			
	}
}

