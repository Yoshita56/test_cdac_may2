package hisglobal.utility.generictemplate.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import hisglobal.presentation.Status;
import hisglobal.presentation.WebUTIL;
import hisglobal.utility.CharacterEncoding;
import hisglobal.utility.generictemplate.GenericTemplateConfig;
import hisglobal.utility.generictemplate.controller.fb.TemplateParameterMasterFB;
import hisglobal.utility.generictemplate.controller.utl.TemplateParameterMasterUTL;

public class TemplateParameterMasterACT extends DispatchAction
{
	public ActionForward ADD(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
	{
		TemplateParameterMasterFB fb = (TemplateParameterMasterFB)form;
		WebUTIL.refreshTransState(request);
		//ControllerUTIL_D.setSysdate(request);
		TemplateParameterMasterUTL.setEssentials(fb, request);
		return mapping.findForward("ADDMOD");
	}

	public ActionForward LIST(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
	{
		return mapping.findForward("LIST");
	}

	public ActionForward CANCEL(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
	{
		return mapping.findForward("LIST");
	}

	public ActionForward NEXT(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
	{
		TemplateParameterMasterFB fb = (TemplateParameterMasterFB)form;
		TemplateParameterMasterUTL.checkTemplateType(fb,request);
		if(fb.getHmode().equals("ADD"))
			return mapping.findForward("ADDMOD");
		else
		{
			fb.setHmode("ADD");
			return mapping.findForward("TEMPDESIGN");
		}
	}

	public ActionForward SAVE(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
	{
		TemplateParameterMasterFB fb = (TemplateParameterMasterFB)form;

		boolean saveFlag=TemplateParameterMasterUTL.saveParametersToTemplate(fb,request);		
		if(saveFlag)
		{
			Status status=new Status();
			status.add(Status.NEW,"","Template and its Parameter Detail Successfully Saved");
			WebUTIL.refreshTransState(request);
			//ControllerUTIL_D.setSysdate(request);
			TemplateParameterMasterUTL.setEssentials(fb, request);
			WebUTIL.setStatus(request, status);
			fb.reset(mapping,request);
			fb.setHmode("ADD");
		}
		return mapping.findForward("ADDMOD");
	}

	public ActionForward MODIFY(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
	{
		TemplateParameterMasterFB fb = (TemplateParameterMasterFB)form;

		WebUTIL.refreshTransState(request);
		fb.reset(mapping,request);
		//ControllerUTIL_D.setSysdate(request);

		TemplateParameterMasterUTL.fetchTemplateForModification(fb,request);
		
		fb.setModeTempModify(GenericTemplateConfig.NO);
		
		return mapping.findForward("ADDMOD");
	}

	public ActionForward MODIFYTEMPLATE(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
	{
		TemplateParameterMasterFB fb = (TemplateParameterMasterFB)form;
		TemplateParameterMasterUTL.updateTemplate(fb,request);
		// Setting  to Template Modify
		String forward="";
		if(fb.getHmode().equals("NOTFOUND"))
		{
			fb.setHmode("MODIFY");
			forward="ADDMOD";
		}
		else if(fb.getModeTempModify().equals(GenericTemplateConfig.YES))
		{			
			TemplateParameterMasterUTL.fetchTemplateParaForModification(fb,request);
			fb.setHmode("MODIFY");
			forward="TEMPDESIGN";
		}
		else
		{
			fb.setHmode("CANCEL");
			forward="ADDMOD";
		}
		return mapping.findForward(forward);
	}

	public ActionForward MODIFYSAVE(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
	{
		CharacterEncoding.setCharacterEncoding(request);
		TemplateParameterMasterFB fb = (TemplateParameterMasterFB)form;
		TemplateParameterMasterUTL.updateParameterToTemplateMaster(fb,request);
		return LIST(mapping, form, request, response);
	}

	public ActionForward VIEW(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
	{
		TemplateParameterMasterFB fb = (TemplateParameterMasterFB)form;

		WebUTIL.refreshTransState(request);
		fb.reset(mapping,request);
		//ControllerUTIL_D.setSysdate(request);
		
		TemplateParameterMasterUTL.getTemplateParameterDetailForView(fb,request);
		
		return mapping.findForward("VIEW");
	}
}
