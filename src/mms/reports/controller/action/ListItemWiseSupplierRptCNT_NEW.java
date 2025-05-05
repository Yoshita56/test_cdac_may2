/**
 * 
 */
package mms.reports.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.ListItemWiseSupplierRptDATA_NEW;
import mms.reports.controller.fb.ListItemWiseSupplierRptFB_NEW;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

// TODO: Auto-generated Javadoc
/**
 * The Class ListItemWiseSupplierRptCNT.
 * 
 * @author user
 */
public class ListItemWiseSupplierRptCNT_NEW extends DispatchAction {

	/**
	 * To display the Item Category Name on the Screen.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return ActionForward object with target
	 * @throws HisException
	 *             the his exception
	 */
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		String target = "reportPage";
		ListItemWiseSupplierRptFB_NEW formBean = (ListItemWiseSupplierRptFB_NEW) form;
		ListItemWiseSupplierRptDATA_NEW.initialAdd(formBean, request);

		return mapping.findForward(target);
	}

	/**
	 * Invoked by Ajax Functions and sets the required group Name Values.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward GROUPNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ListItemWiseSupplierRptFB_NEW formBean = (ListItemWiseSupplierRptFB_NEW) form;
		ListItemWiseSupplierRptDATA_NEW.groupName(formBean, request, response);
		return null;
	}

	/**
	 * Invoked by Ajax Functions and sets the required subgroup Name Values.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward SUBGROUPNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ListItemWiseSupplierRptFB_NEW formBean = (ListItemWiseSupplierRptFB_NEW) form;
		ListItemWiseSupplierRptDATA_NEW.subGroupName(formBean, request, response);
		return null;
	}

	/**
	 * Invoked by Ajax Functions and sets the required Generic Item Name Values.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward ITEMCODE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ListItemWiseSupplierRptFB_NEW formBean = (ListItemWiseSupplierRptFB_NEW) form;
		ListItemWiseSupplierRptDATA_NEW.itemCode(formBean, request, response);
		return null;
	}

	/**
	 * Invoked by Ajax Functions and sets the required Generic Item Name Values.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward ITEMNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ListItemWiseSupplierRptFB_NEW formBean = (ListItemWiseSupplierRptFB_NEW) form;
		ListItemWiseSupplierRptDATA_NEW.itemName(formBean, request, response);
		return null;
	}

	/**
	 * This method is used to cancel the Item Location.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 */
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}

	/**
	 * Showrpt.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public void SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ListItemWiseSupplierRptFB_NEW formBean = (ListItemWiseSupplierRptFB_NEW) form;
		if(request.getSession().getAttribute("HOSPITAL_CODE")!=null ){
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			formBean.setStrFullName("Admin");
		}
		
		else
		{
			formBean.setStrHospitalCode("33101");
			formBean.setStrSeatId("10047");
			formBean.setStrFullName("Admin");
			
		}
		ListItemWiseSupplierRptDATA_NEW.showReport(formBean, request, response);

	}

}
