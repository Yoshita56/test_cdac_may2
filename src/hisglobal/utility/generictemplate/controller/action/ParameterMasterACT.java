package hisglobal.utility.generictemplate.controller.action;

/**
 * @copyright CDAC
 * @developer Pragya Sharma
 */

import hisglobal.presentation.WebUTIL;
import hisglobal.utility.generictemplate.controller.fb.ParameterMasterFB;
import hisglobal.utility.generictemplate.controller.utl.ParameterMasterUTL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class ParameterMasterACT extends DispatchAction
{
	public ActionForward ADD(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
	{
		ParameterMasterFB fb = (ParameterMasterFB)form;
		WebUTIL.refreshTransState(request);
		ParameterMasterUTL.setEssentials(fb, request);
		return mapping.findForward("ADD");
	}

	public ActionForward CANCEL(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
	{
		return mapping.findForward("CANCEL");
	}

	public ActionForward SAVE(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
	{
		ParameterMasterFB fb = (ParameterMasterFB)form;
		if(ParameterMasterUTL.saveParameter(fb, request))
		{
			WebUTIL.refreshTransState(request);
			fb.reset(mapping,request);
			fb.setHmode("ADD");
			return this.ADD(mapping, form, request, response);
		}
		else
		{
			fb.setHmode("ADD");
			return mapping.findForward("ADD");
		}
	}

	public ActionForward MODIFY(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
	{
		ParameterMasterFB fb = (ParameterMasterFB)form;
		ParameterMasterUTL.getParameterById(fb, request);		
		return mapping.findForward("MODIFY");
	}
	public ActionForward VIEW(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
	{
		ParameterMasterFB fb = (ParameterMasterFB)form;
		ParameterMasterUTL.getParameterById(fb, request);		
		return mapping.findForward("VIEW");
	}
	public ActionForward MODIFYSAVE(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
	{
		ParameterMasterFB fb = (ParameterMasterFB)form;
		if(ParameterMasterUTL.updateParameter(fb, request))
			return mapping.findForward("CANCEL");
		else
			return mapping.findForward("MODIFY");
	}
}
