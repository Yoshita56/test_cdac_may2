package mms.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.controller.data.DistrictMstDATA;
import mms.masters.controller.fb.DistrictMstFB;
import mms.masters.controller.utl.DistrictMstUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Adil Wasi  
 * Creation Date:- 27-July-2011 
 * Modifying Date:- 
 * Used For:- 
 * Team Lead By:-  
 *  Module:- DWH(HIS Project)
 * 
 */
public class DistrictMstCNT extends GenericController
{

	/** The strTarget. */
	String strTarget = "";

	 public DistrictMstCNT() 
	    {
	    	super(new DistrictMstUTL(), "/masters/DistrictMstCNT");
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
			DistrictMstFB fb = (DistrictMstFB) form;
			fb.reset(mapping, request);
			DistrictMstDATA.initializeAdd(fb, request);
			return mapping.findForward(strTarget);

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
		public ActionForward GETSTATECMB(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException {

			DistrictMstFB fb = (DistrictMstFB) form;
			DistrictMstDATA.getStateCombo(fb, request,response);
			return null;

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
		public ActionForward SAVE(ActionMapping mapping, ActionForm form,	
				HttpServletRequest request, HttpServletResponse response) 
				throws Exception, SQLException 
		{

			DistrictMstFB fb = (DistrictMstFB) form;
			DistrictMstDATA.insertRecord(fb, request);

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

			DistrictMstFB fb = (DistrictMstFB) form;
			DistrictMstDATA.modifyRecord(fb, request);
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

			DistrictMstFB fb = (DistrictMstFB) form;
			bReturnValue = DistrictMstDATA.updateRecord(fb, request);

			if (bReturnValue)
				return this.LIST(mapping, form, request, response);
			else
				return this.MODIFY(mapping, form, request, response);
		}
	 
	 
}
