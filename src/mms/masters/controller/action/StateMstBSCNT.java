package mms.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.controller.data.StateMstDATA;
import mms.masters.controller.fb.StateMstFB;
import mms.masters.controller.utl.StateMstUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Vivek Aggarwal  
 * Creation Date:- 1-June-2011 
 * Modifying Date:- 3-June-2011
 * Used For:- 
 * Team Lead By:-  
 *  Module:- DWH(HIS Project)
 * 
 */
public class StateMstBSCNT extends GenericController
{

	/** The strTarget. */
	String strTarget = "";

	 public StateMstBSCNT() 
	    {
	    	super(new StateMstUTL(), "/masters/StateMstCNT");
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
			StateMstFB fb = (StateMstFB) form;
			fb.reset(mapping, request);
			StateMstDATA.initializeAdd(fb, request);
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

			StateMstFB fb = (StateMstFB) form;
			StateMstDATA.insertRecord(fb, request);

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

			StateMstFB fb = (StateMstFB) form;
			StateMstDATA.modifyRecord(fb, request);
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

			StateMstFB fb = (StateMstFB) form;
			bReturnValue = StateMstDATA.updateRecord(fb, request);

			if (bReturnValue)
				return this.LIST(mapping, form, request, response);
			else
				return this.MODIFY(mapping, form, request, response);
		}
	 
	 
}
