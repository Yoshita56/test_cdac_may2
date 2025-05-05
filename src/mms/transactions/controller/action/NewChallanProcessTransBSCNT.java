package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.NewChallanProcessTransBSDATA;
import mms.transactions.controller.fb.NewChallanProcessTransFB;
import mms.transactions.controller.utl.NewChallanProcessTransUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class NewChallanProcessTransBSCNT extends GenericController {

	/*
	 * Developer : Balasubramaniam M Version : 1.0 Date : 02/April/2009
	 * Module:MMS Unit:Challan Process
	 */

	public NewChallanProcessTransBSCNT() {

		super(new NewChallanProcessTransUTL(),
				"/transactions/NewChallanProcessTransBSCNT");
	}

	public ActionForward RECEIVECHL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		generateToken(request);
		//GenerateSecureRandomNumber(request);
		String strTarget = "challan";

		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;

		NewChallanProcessTransBSDATA.receiveChallanInit(formBean, request);

		return mapping.findForward(strTarget);
	}

	/*public ActionForward VERIFYCHL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		String strTarget = "verifychallan";

		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;

		NewChallanProcessTransBSDATA.verifyChallanInit(formBean, request);

		return mapping.findForward(strTarget);
	}*/

	public ActionForward SCHEDULEDTL(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException 
	{
        
		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;

		NewChallanProcessTransBSDATA.getScheduleDtlsTwoBS(formBean, request, response);

		return null;
	}
	
	public ActionForward GETSCHEDULEDTLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;

		NewChallanProcessTransBSDATA.getScheduleDtls(formBean, request, response);

		return null;
	}

	/*public ActionForward COMMITEEMEMBERDTL(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;

		NewChallanProcessTransBSDATA.getCommitteeMemberDtls(formBean, request,
				response);

		return null;
	}*/

	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

         validateToken(request, response);
		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

		boolean fltRes = NewChallanProcessTransBSDATA.insert(formBean);

		//if(fltRes){
			
		//	return LIST(mapping, form, request, response);
			
		//}else{
			
			return this.RECEIVECHL(mapping, formBean, request, response);
			
		//}
		
		
	}

	/*public ActionForward BALQTYDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;

		NewChallanProcessTransBSDATA.getBalanceQtyDtls(formBean, request, response);

		return null;
	}

	public ActionForward INSERTVERIFY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());

		boolean fltRes =  NewChallanProcessTransBSDATA.verifyInsert(formBean);
		
		//strReceivedQuantity,strVerifiedQuantityInBaseVal
		
		String strVerifyFlag = formBean.getStrVerifyFlag();
		double recQty = Double.parseDouble(formBean.getStrReceivedQuantity());
		double verifyQty = Double.parseDouble(formBean.getStrVerifiedQuantityInBaseVal());
		
		if(strVerifyFlag.equals("1") || recQty == verifyQty)
			return LIST(mapping, form, request, response);
		else	
			return this.VERIFYCHL(mapping, formBean, request, response);
			
		
	
	}
*/
	
	public ActionForward CANCELCHL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		
		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());

				
		NewChallanProcessTransBSDATA.cancelChallan(formBean);

		return LIST(mapping, form, request, response);
	}
	
	public ActionForward VIEWCHL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		String strTarget = "viewchallan";

		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;

		NewChallanProcessTransBSDATA.viewChallan(formBean, request);

		return mapping.findForward(strTarget);
	}
	/*public ActionForward FETCHRECEIVEDITEMETAIL(ActionMapping mapping, ActionForm form,	HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException 
	{
		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;
		NewChallanProcessTransBSDATA.getReceivedItemDetails(formBean,request, response);
		return null;
	}
	
	/**
	 * FETCHVERIFIEDITEMETAIL.
	 * @author shalini
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
	/*public ActionForward FETCHVERIFIEDITEMETAIL(ActionMapping mapping, ActionForm form,	HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException 
	{
		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;
		NewChallanProcessTransBSDATA.getVerifiedItemDetails(formBean,request, response);
		return null;
	}
	
	public ActionForward PRINT(ActionMapping mapping, ActionForm form,	HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException 
	{
		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;
		NewChallanProcessTransBSDATA.print(formBean,request, response);
		return null;
	}*/
	
	public ActionForward NEWRECCHL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		String strTarget = "NEWRECCHL";

		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;

		NewChallanProcessTransBSDATA.getInitNewRecChl(formBean, request);

		return mapping.findForward(strTarget);
	}
	public ActionForward NEWCHLRECITEMDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		String strTarget = "NEWRECCHL";

		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;

		NewChallanProcessTransBSDATA.getInitNewRecItemChl(formBean, request);

		return mapping.findForward(strTarget);
	}
	
	
	public ActionForward insertLP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {


		NewChallanProcessTransFB formBean = (NewChallanProcessTransFB) form;

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

		boolean fltRes = NewChallanProcessTransBSDATA.insertlp(formBean ,request);

		if(fltRes){
			
			return LIST(mapping, form, request, response);
			
		}else{
			
			return this.RECEIVECHL(mapping, formBean, request, response);
			
		}
		
		
	}
}
