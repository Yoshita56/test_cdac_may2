package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import mms.transactions.controller.data.HelpDeskDATA;
import mms.transactions.controller.data.SolutionDeskDATA;


import mms.transactions.controller.fb.HelpDeskFB;
import mms.transactions.controller.fb.SolutionDeskFB;
import mms.transactions.controller.utl.SolutionDeskUTIL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SolutionDeskCNT extends GenericController {

	String strtarget;

	/**
	 * calls super class constructor
	 */

	public SolutionDeskCNT() {
		super(new SolutionDeskUTIL(),
				"/transactions/SolutionDeskCNT");

	}

	/**
	 * forwards control to the ADD page.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward SOLUTION(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		SolutionDeskFB fb = (SolutionDeskFB) form;

		
		// Type and Group Type
		// Name on next page
		// according to the selected
		
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		 String strTarget="";
		//if(res.getString("DRUG_INVENTORY").equals("1"))
		{
			SolutionDeskDATA.initialAdd(fb, request); // to display the Store
			strtarget = "SOLUTION";
		}
		/*
		else
		{
			SolutionDeskDATA.initialAddDummy(fb, request); // to display the Store
			strtarget = "dummyadd";
	 	}
		*/
		
		return mapping.findForward(strtarget);

	}

	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		saveToken(request);
		SolutionDeskFB formBean = (SolutionDeskFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		SolutionDeskDATA.SolInsert(formBean,request);
		//return this.SOLUTION(mapping, form, request, response);
		return this.LIST(mapping, form, request, response);
	}

	
	public ActionForward VIEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		String strTarget = "SOLUTION";
		SolutionDeskFB formBean = (SolutionDeskFB) form;
		SolutionDeskDATA.getViewInitialVal(formBean,request);
		
		return mapping.findForward(strTarget);
	}
	
	public ActionForward VIEWSOL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		String strTarget = "SOLUTIONVIEW";
		SolutionDeskFB formBean = (SolutionDeskFB) form;
		SolutionDeskDATA.getViewSolVal(formBean,request);
		
		return mapping.findForward(strTarget);
	}
	
	
/*	public ActionForward VIEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		String strTarget = "view";
		SolutionDeskFB formBean = (SolutionDeskFB) form;
		SolutionDeskDATA.getViewInitialVal(formBean,request);
		
		return mapping.findForward(strTarget);
	}*/
	
	public ActionForward RETURNTODESK(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		return this.LIST(_mapping, form, request, response);
		}
	

	public ActionForward CANCELPAGE(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse _response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward DOWNLOAD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		//System.out.println("Action Class Entered");
		String strTarget = "download";
		SolutionDeskFB formBean = (SolutionDeskFB) form;
		SolutionDeskDATA.DownloadFile(formBean,request,response);
		
		return mapping.findForward(strTarget);
		
		//ActionForward acFwd = new ActionForward();
		//request.setAttribute("Path","HelpDeskCNT.cnt");
		//acFwd.setPath("/mms/transactions/HelpDeskDownloadFileCNT.cnt?hmode=DOWNLOAD");
		// acFwd.setContextRelative(true);
	       // return acFwd;
	}


	
}
