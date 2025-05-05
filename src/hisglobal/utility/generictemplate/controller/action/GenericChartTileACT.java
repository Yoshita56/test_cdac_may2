package hisglobal.utility.generictemplate.controller.action;

import hisglobal.presentation.WebUTIL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.utility.generictemplate.GenericTemplateConfig;
import hisglobal.utility.generictemplate.controller.fb.GenericChartTileFB;

public class GenericChartTileACT extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)
	{
		return this.NEW(mapping, form, request, response);
	}

	public ActionForward NEW(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)
	{
		GenericChartTileFB fb = (GenericChartTileFB) form;
		try
		{
			HttpSession session = WebUTIL.getSession(request);
			
			if(session.getAttribute(GenericTemplateConfig.GENERIC_CHART_VIEW_MODE)!=null)
				fb.setViewMode((String)session.getAttribute(GenericTemplateConfig.GENERIC_CHART_VIEW_MODE));
			else
				fb.setViewMode(GenericTemplateConfig.GENERIC_CHART_VIEW_MODE_PARA_WISE_LIST);
			
			if(fb.getViewMode().equals(GenericTemplateConfig.GENERIC_CHART_VIEW_MODE_TEMP_WISE_TABLE))
			{
				if(session.getAttribute(GenericTemplateConfig.GENERIC_CHART_TEMPLATE_LIST_MAP)==null)
					throw new Exception();
				if(session.getAttribute(GenericTemplateConfig.GENERIC_CHART_DATA_DATES_LIST_MAP)==null)
					throw new Exception();
				if(session.getAttribute(GenericTemplateConfig.GENERIC_CHART_TEMPLATE_PARAMETER_LIST_MAP)==null)
					throw new Exception();
				if(session.getAttribute(GenericTemplateConfig.GENERIC_CHART_DATES_PARA_VALUE_MAP)==null)
					throw new Exception();
			}			
			else if(fb.getViewMode().equals(GenericTemplateConfig.GENERIC_CHART_VIEW_MODE_PARA_WISE_LIST))
			{
				if(session.getAttribute(GenericTemplateConfig.GENERIC_CHART_DATA_DATES_LIST_MAP)==null)
					throw new Exception();
				if(session.getAttribute(GenericTemplateConfig.GENERIC_CHART_PARAMETER_LIST)==null)
					throw new Exception();
				if(session.getAttribute(GenericTemplateConfig.GENERIC_CHART_DATES_PARA_VALUE_MAP)==null)
					throw new Exception();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fb.setViewMode("ERROR");
			fb.setMessage("Insufficient or Wrong Information provided for Generic Chart Tile ...");
		}
		return mapping.findForward(fb.getViewMode());
	}
}
