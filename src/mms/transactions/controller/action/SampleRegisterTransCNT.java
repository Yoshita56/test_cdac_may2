package mms.transactions.controller.action;



import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;


import mms.transactions.controller.data.SampleRegisterTransDATA;

import mms.transactions.controller.fb.SampleRegisterTransFB;
import mms.transactions.controller.utl.SampleRegisterTransUTL;

/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 29/Jan/2009
 *  
*/


public class  SampleRegisterTransCNT extends GenericController {
	
	String strtarget;
	
	public SampleRegisterTransCNT() {
		
		super(new SampleRegisterTransUTL(),
				"/transactions/SampleRegisterTransCNT");

	}
	/**
	 * This function is used to forward control to Recieve Mode
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward RECIEVE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		SampleRegisterTransFB formBean=(SampleRegisterTransFB) form;
		
		
		strtarget = "recieve";
	
		SampleRegisterTransDATA.initialAdd(formBean, request);
		return mapping.findForward(strtarget);

	}
	/**
	 * This function is used to forward control to Return mode 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward RETURN(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		SampleRegisterTransFB formBean=(SampleRegisterTransFB) form;
		formBean.setStrStoreName(request.getParameter("comboValue"));
		SampleRegisterTransDATA.returnAdd(formBean, request);
		strtarget = "return";
		return mapping.findForward(strtarget);

	}
	
	/**
	 * This function is used to forward control to Verify mode 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward VERIFY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		SampleRegisterTransFB formBean=(SampleRegisterTransFB) form;
		formBean.setStrStoreName(request.getParameter("comboValue"));
		
		SampleRegisterTransDATA.verifyAdd(formBean, request);
			strtarget = "verify";
		return mapping.findForward(strtarget);

	}
	/**
	 * This function is used to forward control to Condemn mode 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward CONDEMN(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		SampleRegisterTransFB formBean=(SampleRegisterTransFB) form;
		formBean.setStrStoreName(request.getParameter("comboValue"));
		SampleRegisterTransDATA.condemnPage(formBean, request);
		strtarget = "condemn";
		return mapping.findForward(strtarget);

	}

	/**
	 * This function is used to insert data during recieve mode
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException,SQLException  {
		
		saveToken(request);
		SampleRegisterTransFB formBean=(SampleRegisterTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		SampleRegisterTransDATA.insert(formBean);
		return this.RECIEVE(mapping, form, request, response);
	}
	/**
	 * this function is used to update data during return mode 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward INSERTRETURN(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException,SQLException  {
		
		saveToken(request);
		SampleRegisterTransFB formBean=(SampleRegisterTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		SampleRegisterTransDATA.updateReturn(formBean,request);
		return this.LIST(mapping, form, request, response); 
	}
	/**
	 * This function is used to bring back control to main menu.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	public ActionForward INITIALPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		
		return this.LIST(mapping, form, request, response); 
	}
	/**
	 * This function is used to reset the all values
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward CLEAR(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException ,SQLException{
		SampleRegisterTransFB formBean=(SampleRegisterTransFB) form;
		
		formBean.setStrMsgString("");
		formBean.setStrMsg("");
		
		strtarget =request.getParameter("mode").toString();
		if(strtarget.equals("recieve"))
		return this.RECIEVE(mapping, form, request, response);
		return null;
	}
	
	public ActionForward SUPPLIER(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException ,SQLException{
		SampleRegisterTransFB formBean=(SampleRegisterTransFB) form;
		SampleRegisterTransDATA.getSupplierCombo(formBean, request,response);
		formBean.setStrMsgString("");
		formBean.setStrMsg("");
			
		return null;
	}
	
	public ActionForward COMMITEEMEMBERDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException ,SQLException{
		SampleRegisterTransFB formBean=(SampleRegisterTransFB) form;
		SampleRegisterTransDATA.getMemberDtl(formBean, request,response);
		formBean.setStrMsgString("");
		formBean.setStrMsg("");
			
		return null;
	}
	
	public ActionForward VERIFYUPDATE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException ,SQLException{
		SampleRegisterTransFB formBean=(SampleRegisterTransFB) form;
		SampleRegisterTransDATA.verifyUpdate(formBean, request);
		return this.LIST(mapping, form, request, response); 
	}
	
	
	public ActionForward CONDEMNSAMPLE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException ,SQLException{
		SampleRegisterTransFB formBean=(SampleRegisterTransFB) form;
		SampleRegisterTransDATA.condemnSample(formBean, request);
		return this.LIST(mapping, form, request, response); 
	}
	public ActionForward CANCELPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException ,SQLException{
			ActionForward acFwd = new ActionForward();
			acFwd.setPath("/hisglobal/initPage.jsp");
			acFwd.setContextRelative(true);
			return acFwd;
	}
}
