package mms.reports.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import hisglobal.exceptions.HisException;
import mms.reports.controller.data.IssueToPatientDetailRptData;
import mms.reports.controller.fb.IssueToPatientDetailRptFB;
/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
*/
public class IssueToPatientDetailRptCNT extends DispatchAction {
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		return this.INITDETAIL(mapping, form, request, response);

	}
		
	public ActionForward INITDETAIL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		String target="index";
		IssueToPatientDetailRptFB formBean = (IssueToPatientDetailRptFB) form;
		IssueToPatientDetailRptData.setInitDtl(formBean, request);
		return mapping.findForward(target);
	}

	public ActionForward SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		System.out.println("--------------------- IssueToPatientDetailRptCNT ------[ SHOWRPT ]----[issueToPatientDetail_printHlp.jsp]-----------------");
		
		String strTarget = "printlp";
		IssueToPatientDetailRptFB formBean = (IssueToPatientDetailRptFB)form;
		formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		IssueToPatientDetailRptData.showReport(formBean, request, response);
		
		System.out.println("------ formBean.getStrCrNo() ------"+formBean.getStrCrNo());
		
		return mapping.findForward(strTarget);
	}
	
	public ActionForward ITEMCATEGORYCOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

	
		IssueToPatientDetailRptFB formBean = (IssueToPatientDetailRptFB) form;
		IssueToPatientDetailRptData.setItemCategComboDtl(formBean, request, response);
		return null;

	}
	
	public ActionForward DRUGNAMECOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		IssueToPatientDetailRptFB formBean = (IssueToPatientDetailRptFB) form;
		IssueToPatientDetailRptData.setDrugNameCombo(formBean, request, response);
		return null;

	}
	
	public void SHOWRPT_OLD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		IssueToPatientDetailRptFB formBean = (IssueToPatientDetailRptFB) form;
		formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		IssueToPatientDetailRptData.showReport_old(formBean, request, response);
		
		
	}
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response)
	 {
			  ActionForward acFwd = new ActionForward();
			  acFwd.setPath("/hisglobal/initPage.jsp");
			  acFwd.setContextRelative(true);
			  return acFwd;
	 }
	public ActionForward Back(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		return this.INITDETAIL(mapping, form, request, response);

	}
		
}
