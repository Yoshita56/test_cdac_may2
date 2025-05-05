package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.SampleSentTransDATA;
import mms.transactions.controller.fb.SampleSentTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class SampleSentTransCNT extends DispatchAction
{
	String strtarget;

	/**
	 * Constructor of Class.
	 */
	public SampleSentTransCNT()
	{
		//super(new CommitteeMemberDetailMstUTL(),"/masters/CommitteeMemberDetailMstCNT");
	}
	
	 /***********************UNSPECIFIED**************************/
	 
	/**
	 * Unspecified Method Use to Transfer the Control Over Action FIRSTDATA.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */ 
	public ActionForward unspecified(ActionMapping mapping
			                        ,ActionForm form
			                        ,HttpServletRequest request
			                        ,HttpServletResponse response)throws HisException, SQLException
    {
		return this.INITNEWSAMPLESENT(mapping, form, request, response);
	}
	/**
	 * forwards control to the ADD page of Trasaction.& get
	 * all data which required to show over add page
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward INITSAMPLESENT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		SampleSentTransFB fb = (SampleSentTransFB) form;
	    SampleSentTransDATA.initSampleSent(fb, request); 
		strtarget = "SampleSentTransJsp";
		return mapping.findForward(strtarget);

	}
	
	
	/**
	 * forwards control to the ADD page of Trasaction.& get
	 * all data which required to show over add page
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward INITNEWSAMPLESENT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		SampleSentTransFB fb = (SampleSentTransFB) form;
	    SampleSentTransDATA.initSampleSent(fb, request); 
		strtarget = "NewSampleSentTransJsp";
		return mapping.findForward(strtarget);

	}
	
	
	public ActionForward GETITEMCATLIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{

		SampleSentTransFB formBean = (SampleSentTransFB)form;
		SampleSentTransDATA.getCategoryCmb(formBean, request, response);
		
		return null;
	}
	
	public ActionForward GETQCDRUGBATCHLIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{

		SampleSentTransFB formBean = (SampleSentTransFB)form;
		SampleSentTransDATA.getDrugBatchCmb(formBean, request, response);
		
		return null;
	}
	
	
	public ActionForward GETUNITCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{

		SampleSentTransFB formBean = (SampleSentTransFB)form;
		SampleSentTransDATA.unitNameCombo(formBean, request, response);
		
		return null;
	}
	
	
	
	
	public ActionForward GETQCDRUGLIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{

		SampleSentTransFB formBean = (SampleSentTransFB)form;
		//SampleSentTransDATA.getDrugNameCmb(formBean, request, response);
		SampleSentTransDATA.getDrugNameCmbForNewProcess(formBean, request, response);
		
		
		return null;
	}
	
	
	public ActionForward GETQCDRUGBATCHDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{

		SampleSentTransFB formBean = (SampleSentTransFB)form;
		SampleSentTransDATA.getDrugBatchDtl(formBean, request, response);
		
		return null;
	}
	
	
	public ActionForward PRINTSAMPLESENTLABEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{

		SampleSentTransFB formBean = (SampleSentTransFB)form;
		SampleSentTransDATA.printSampleLabel(formBean, request, response);
		
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
		SampleSentTransFB formBean = (SampleSentTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		SampleSentTransDATA.insert1(formBean);
		
		return this.INITNEWSAMPLESENT(mapping, form, request, response);
	}
	
	
	/**
	 * To CANCEL Records.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 * @throws SQLException
	 */

	public ActionForward CANCELRECORDS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		saveToken(request);
		SampleSentTransFB formBean = (SampleSentTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		SampleSentTransDATA.cancelRecords(formBean);
		
		return this.VIEWPAGE(mapping, form, request, response);
	}
	
	
	public ActionForward CANCELPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
	    ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	
	/**
	 * 
	 * forwards control to the View page of this  Transaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	
	public ActionForward VIEWPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		String strTarget="SampleSentTransViewJsp";
		
		SampleSentTransFB fb = (SampleSentTransFB) form;
		SampleSentTransDATA.initSampleSent(fb,request);
		return mapping.findForward(strTarget);
	}
	
	
	public ActionForward VIEWSAMPLESENT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{

		SampleSentTransFB formBean = (SampleSentTransFB)form;
		SampleSentTransDATA.viewSampleSent(formBean, request, response);
		
		return null;
	}
	
	public ActionForward PRINTSAMPLESENTLABELVIEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{

		SampleSentTransFB formBean = (SampleSentTransFB)form;
		SampleSentTransDATA.printSampleLabelView(formBean, request, response);
		
		return null;
	}
	
	
}
