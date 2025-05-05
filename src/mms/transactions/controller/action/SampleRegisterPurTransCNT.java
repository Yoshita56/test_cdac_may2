package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.SampleRegisterPurTransDATA;
import mms.transactions.controller.fb.SampleRegisterPurTransFB;
import mms.transactions.controller.utl.SampleRegisterPurTransUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SampleRegisterPurTransCNT extends GenericController{
	
String strtarget;
	
	public SampleRegisterPurTransCNT() {
		super(new SampleRegisterPurTransUTL(),
				"/transactions/SampleRegisterPurTransCNT");

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

		SampleRegisterPurTransFB formBean=(SampleRegisterPurTransFB) form;
		
		
		strtarget = "recieve";
	
		SampleRegisterPurTransDATA.initialAdd(formBean, request);
		return mapping.findForward(strtarget);

	}
	
	public ActionForward GETPROPOSALNO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		SampleRegisterPurTransFB formBean = (SampleRegisterPurTransFB) form;
		SampleRegisterPurTransDATA.getProposalNo(formBean, request, response);
		return null;
	}
	
	public ActionForward GETPROPOSALDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		SampleRegisterPurTransFB formBean = (SampleRegisterPurTransFB) form;
		SampleRegisterPurTransDATA.getProposalDtl(formBean, request, response);
		return null;
	}
		
	public ActionForward GETSUPPCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		SampleRegisterPurTransFB formBean=(SampleRegisterPurTransFB) form;
		
		SampleRegisterPurTransDATA.getSupplierCombo(formBean, request, response);
		return null;

	}
	
	public ActionForward GETITEMCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		SampleRegisterPurTransFB formBean=(SampleRegisterPurTransFB) form;
		
		SampleRegisterPurTransDATA.getItemCombo(formBean, request, response);
		return null;

	}
	
	public ActionForward GETUNITCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		SampleRegisterPurTransFB formBean=(SampleRegisterPurTransFB) form;
		
		SampleRegisterPurTransDATA.getUnitCombo(formBean, request, response);
		return null;

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
		SampleRegisterPurTransFB formBean=(SampleRegisterPurTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		
		SampleRegisterPurTransDATA.insert(formBean, request);
		return this.LIST(mapping, form, request, response);
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

		SampleRegisterPurTransFB formBean=(SampleRegisterPurTransFB) form;
		formBean.setStrStoreName(request.getParameter("comboValue"));
		SampleRegisterPurTransDATA.returnAdd(formBean, request);
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

		SampleRegisterPurTransFB formBean=(SampleRegisterPurTransFB) form;
		formBean.setStrStoreName(request.getParameter("comboValue"));
		
		SampleRegisterPurTransDATA.verifyAdd(formBean, request);
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

		SampleRegisterPurTransFB formBean=(SampleRegisterPurTransFB) form;
		//formBean.setStrStoreName(request.getParameter("comboValue"));
		SampleRegisterPurTransDATA.condemnPage(formBean, request);
		strtarget = "condemn";
		return mapping.findForward(strtarget);

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
		SampleRegisterPurTransFB formBean=(SampleRegisterPurTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		SampleRegisterPurTransDATA.updateReturn(formBean,request);
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
		SampleRegisterPurTransFB formBean=(SampleRegisterPurTransFB) form;
		
		formBean.setStrMsgString("");
		formBean.setStrMsg("");
		
		strtarget =request.getParameter("mode").toString();
		if(strtarget.equals("recieve"))
		return this.RECIEVE(mapping, form, request, response);
		return null;
	}
	
//	public ActionForward SUPPLIER(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response)
//			throws HisException ,SQLException{
//		SampleRegisterPurTransFB formBean=(SampleRegisterPurTransFB) form;
//		SampleRegisterPurTransDATA.getSupplierCombo(formBean, request,response);
//		formBean.setStrMsgString("");
//		formBean.setStrMsg("");
//			
//		return null;
//	}
	
	public ActionForward COMMITEEMEMBERDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException ,SQLException{
		SampleRegisterPurTransFB formBean=(SampleRegisterPurTransFB) form;
		SampleRegisterPurTransDATA.getMemberDtl(formBean, request,response);
		formBean.setStrMsgString("");
		formBean.setStrMsg("");
			
		return null;
	}
	
	public ActionForward VERIFYUPDATE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException ,SQLException{
		SampleRegisterPurTransFB formBean=(SampleRegisterPurTransFB) form;
		SampleRegisterPurTransDATA.verifyUpdate(formBean, request);
		return this.LIST(mapping, form, request, response); 
	}
	
	
	public ActionForward CONDEMNSAMPLE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException ,SQLException{
		SampleRegisterPurTransFB formBean=(SampleRegisterPurTransFB) form;
		SampleRegisterPurTransDATA.condemnSample(formBean, request);
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
