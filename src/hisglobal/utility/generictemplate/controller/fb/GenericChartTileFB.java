package hisglobal.utility.generictemplate.controller.fb;

import hisglobal.utility.generictemplate.GenericTemplateConfig;

import org.apache.struts.action.ActionForm;

public class GenericChartTileFB extends ActionForm
{
	private String viewMode;

	private String message;
	
	public GenericChartTileFB()
	{	
		this.viewMode = GenericTemplateConfig.GENERIC_CHART_VIEW_MODE_TEMP_WISE_TABLE;
		this.message = "";
	}

	public String getViewMode()
	{
		return viewMode;
	}

	public void setViewMode(String viewMode)
	{
		this.viewMode = viewMode;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}
}
