package mms.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.controller.data.EmployeeDetailMstDATA;
import mms.masters.controller.fb.EmployeeDetailMstFB;
import mms.masters.controller.utl.EmployeeDetailMstUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Vivek Aggarwal  
 * Creation Date:- 7-June-2011 
 * Modifying Date:- 10-June-2011
 * Used For:- 
 * Team Lead By:-  
 *  Module:- DWH(HIS Project)
 * 
 */
public class EmployeeDetailMstCNT extends GenericController
{

	/** The strTarget. */
	String strTarget = "";

	 public EmployeeDetailMstCNT() 
	    {
	    	super(new EmployeeDetailMstUTL(), "/masters/EmployeeDetailMstCNT");
	    }
	 

	    /**
		 * forwards control to the ADD page.
		 * 
		 * @param mapping the mapping
		 * @param form the form
		 * @param request the request
		 * @param response the response
		 * 
		 * @return the action forward
		 * 
		 * @throws HisException the his exception
		 * @throws SQLException the SQL exception
		 */
		public ActionForward ADD(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException {

			strTarget = "add";
			EmployeeDetailMstFB fb = (EmployeeDetailMstFB) form;
			fb.reset(mapping, request);
			EmployeeDetailMstDATA.initializeAdd(fb, request);
			return mapping.findForward(strTarget);

		}
		
		
	    /**
		 * Get Salutation Combo using Ajax. 
		 * 
		 * @param mapping the mapping
		 * @param form the form
		 * @param request the request
		 * @param response the response
		 * 
		 * @return the null
		 * 
		 * @throws HisException the his exception
		 * @throws SQLException the SQL exception
		 */
		public ActionForward GETVIEWPAGE(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException {

			EmployeeDetailMstFB fb = (EmployeeDetailMstFB) form;
			EmployeeDetailMstDATA.viewRecord(fb, request);
			strTarget = "view";
			return mapping.findForward(strTarget);
			
		}
		
		/**
		 * To Save data.
		 * 
		 * @param mapping the mapping
		 * @param form the form
		 * @param request the request
		 * @param response the response
		 * 
		 * @return the action forward
		 * 
		 * @throws Exception the exception
		 * @throws SQLException the SQL exception
		 */
		public ActionForward SAVE(ActionMapping mapping, ActionForm form,	HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException 
		{

			EmployeeDetailMstFB fb = (EmployeeDetailMstFB) form;
			EmployeeDetailMstDATA.insertRecord(fb, request);

			return this.ADD(mapping, form, request, response);
		}

		/**
		 * Forwards control to the modify page.
		 * 
		 * @param mapping the mapping
		 * @param form the form
		 * @param request the request
		 * @param response the response
		 * 
		 * @return the action forward
		 * 
		 * @throws HisException the his exception
		 * @throws SQLException the SQL exception
		 */
		public ActionForward MODIFY(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException {

			EmployeeDetailMstFB fb = (EmployeeDetailMstFB) form;
			EmployeeDetailMstDATA.modifyRecord(fb, request);
			EmployeeDetailMstDATA.initializeAdd(fb, request);
			strTarget = "modify";
			return mapping.findForward(strTarget);
		}

		/**
		 * To Update data.
		 * 
		 * @param mapping the mapping
		 * @param form the form
		 * @param request the request
		 * @param response the response
		 * 
		 * @return the action forward
		 * 
		 * @throws HisException the his exception
		 * @throws SQLException the SQL exception
		 */
		public ActionForward UPDATE(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException {
			boolean bReturnValue = false;

			EmployeeDetailMstFB fb = (EmployeeDetailMstFB) form;
			bReturnValue = EmployeeDetailMstDATA.updateRecord(fb, request);

			if (bReturnValue)
				return this.LIST(mapping, form, request, response);
			else
				return this.MODIFY(mapping, form, request, response);
		}
	 
	 
}
