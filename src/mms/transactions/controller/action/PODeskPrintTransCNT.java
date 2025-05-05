package mms.transactions.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.PODeskPrintTransDATA;
import mms.transactions.controller.fb.PODeskPrintTransFB;

public class PODeskPrintTransCNT extends CSRFGardTokenAction  {
	
	
	public void PRINT_OLD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		
		System.out.println("-------- PODeskPrintTransCNT.PRINT_OLD ---------");
		
		PODeskPrintTransFB formBean = (PODeskPrintTransFB)form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		PODeskPrintTransDATA.showReport(formBean, request, response);
		
		
		
	}	
	public ActionForward PRINT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		generateToken(request);
		System.out.println("-------------PODeskPrintTransCNT.PRINT------[po_desk_print_local_hlp.jsp]-------");
		
		PODeskPrintTransFB formBean = (PODeskPrintTransFB)form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		String[] Temp = request.getParameterValues("combo");
		
		System.out.println("STORE_CODE----"+Temp[0]);
		System.out.println("CATG_CODE----"+Temp[1]);
		System.out.println("PO_TYPE----"+Temp[2]);		
		
		formBean.setStrPOStatus(Temp[3]);
		
		System.out.println("PO_STATUS--{ 1- Pending , 3- In Process ,  2 - Close  }--"+formBean.getStrPOStatus());
		
		if(Temp[3].equals("3"))
		{		
		     PODeskPrintTransDATA.PRINT_NEW(formBean, request, response);
		}
		if(Temp[3].equals("1")&& !formBean.getStrPOTypeId().equals("22"))
		{		
		     PODeskPrintTransDATA.PRINT_NEW_DRAFT(formBean, request, response);
		}
		if(Temp[3].equals("2"))
		{		
		     PODeskPrintTransDATA.PRINT_NEW(formBean, request, response);
		}
		
		
		//System.out.println("kjdhgfdfghjgfjhgfhg");
		return mapping.findForward("print");
	}	
	
	public ActionForward CANCELTODESK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/PODeskTransCNT.cnt?hmode=unspecified");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
		

}
