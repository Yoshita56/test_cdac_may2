package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import mms.transactions.controller.data.HelpDeskDATA;


import mms.transactions.controller.fb.HelpDeskFB;
import mms.transactions.controller.utl.HelpDeskUTIL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
//import hisglobal.DownloadFile;


/* @author 

* Developer : Brahmam Veluguri( TO CONTINUE AND CORRECTIONS)
* Version : 1.0 Date : 02/Jul/2012
* 
*/



public class HelpDeskCNT extends GenericController{
	
	String strtarget;

	/**
	 * calls super class constructor
	 */

	public HelpDeskCNT() {
		super(new HelpDeskUTIL(),
				"/transactions/HelpDeskCNT");

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

	public ActionForward ADD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		
		HelpDeskFB fb = (HelpDeskFB) form;
		
		
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
			HelpDeskDATA.initialAdd(fb, request); // to display the Store
			strtarget = "add";
		}
		/*
		else
		{
			HelpDeskDATA.initialAddDummy(fb, request); // to display the Store
			strtarget = "dummyadd";
	 	}
		*/
		
		return mapping.findForward(strtarget);

	}

	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		////System.out.println("Insert Method Entered");
		saveToken(request);
		HelpDeskFB formBean = (HelpDeskFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		HelpDeskDATA.insert(formBean);
		//return this.LIST(mapping, form, request, response);
		return this.ADD(mapping, form, request, response);
	}

	
	public ActionForward VIEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		String strTarget = "view";
		HelpDeskFB formBean = (HelpDeskFB) form;
		HelpDeskDATA.getViewInitialVal(formBean,request);
		
		return mapping.findForward(strTarget);
	}
	
	
/*	public ActionForward VIEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		String strTarget = "view";
		HelpDeskFB formBean = (HelpDeskFB) form;
		HelpDeskDATA.getViewInitialVal(formBean,request);
		
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
		////System.out.println("Action Class Entered");
		String strTarget = "download";
		HelpDeskFB formBean = (HelpDeskFB) form;
		HelpDeskDATA.DownloadFile(formBean,request,response);
		
		return mapping.findForward(strTarget);
		
		//ActionForward acFwd = new ActionForward();
		//request.setAttribute("Path","HelpDeskCNT.cnt");
		//acFwd.setPath("/mms/transactions/HelpDeskDownloadFileCNT.cnt?hmode=DOWNLOAD");
		// acFwd.setContextRelative(true);
	       // return acFwd;
	}
	
}
