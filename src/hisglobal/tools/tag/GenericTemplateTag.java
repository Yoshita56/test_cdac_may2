package hisglobal.tools.tag;

/**
 * @copyright CDAC
 * @developer Pragya Sharma
 */

import hisglobal.utility.generictemplate.GenericTemplateConfig;
import hisglobal.utility.generictemplate.GenericTemplateUtility;
import hisglobal.utility.generictemplate.TemplateDesignerUtility;
import hisglobal.utility.generictemplate.controller.utl.GenericTemplateUTL;
import hisglobal.vo.TemplateMasterVO;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class GenericTemplateTag extends TagSupport 
{
	private String templateId;
	private String mode;
	
	public GenericTemplateTag()
	{
		this.mode = null;
	}	
	
	public int doStartTag() throws JspException
	{
		try
		{
			HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
			HttpSession session=request.getSession();
			
			/*// Template Para Values
			Map<String, String> mapParaValues = null;
			Map<String, GenericTemplateUtility.TempParameter> mapParaDetail = null;
			if(session.getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_PARAMETER_VALUES_MAP_TEMPLATE_MAP) != null)
			{
				Map<String, Map<String, String>> mapAllTempParaValues = (Map<String, Map<String, String>>)session.getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_PARAMETER_VALUES_MAP_TEMPLATE_MAP);
				mapParaValues = mapAllTempParaValues.get(this.templateId);
			}
			if(session.getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_PARAMETER_VALUES_DETAIL_MAP) != null)
			{
				Map<String, Map<String, GenericTemplateUtility.TempParameter>> mpAllTempParaDtl = (Map<String, Map<String, GenericTemplateUtility.TempParameter>>)session.getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_PARAMETER_VALUES_DETAIL_MAP);
				mapParaDetail = mpAllTempParaDtl.get(this.templateId);				
			}
					
			
			if(this.mode==null)
				this.mode = GenericTemplateConfig.GENERIC_TEMPLATE_MODE_EDITABLE;
			if(!(this.mode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_EDITABLE) 
					|| this.mode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_REPORT) 
					|| this.mode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_SUMMARIZED_REPORT) 
					|| this.mode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_EDITABLE_NON_ENTERED) 
					|| this.mode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_EDITABLE_FOCUS_ENTERED)))
				this.mode = GenericTemplateConfig.GENERIC_TEMPLATE_MODE_EDITABLE;
				
			// Getting Gender Type from Session
			String genderType = GenericTemplateConfig.GENERIC_TEMPLATE_PATIENT_INITIAL_GENDER_TYPE;
			if(session.getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_PATIENT_GENDER_TYPE)!= null)
				genderType = (String)session.getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_PATIENT_GENDER_TYPE);

			// Statically from HTML File
			String tempCode = GenericTemplateUtility.readTemplateFromHTMLFile(this.templateId);

			// Dynamically From Database
			if(tempCode == null)
				tempCode = GenericTemplateUTL.generateHTMLTemplate(this.templateId, mapParaValues, request);

			TemplateMasterVO vo = GenericTemplateUTL.getTemplateDataById(this.templateId, request);
			// Setting Template Values on Mode
			tempCode = TemplateDesignerUtility.fillParameterValuesIntoHTMLCode(tempCode, mapParaValues, mapParaDetail, this.mode, vo.getTemplateType(), genderType);*/
			
			String tempCode = templateLogic(request, session);
			
			JspWriter out = this.pageContext.getOut();
			System.out.print(tempCode);
			out.println(tempCode);
		}
		catch (IOException e) 
		{ 
			e.printStackTrace();
		}
		return TagSupport.EVAL_BODY_INCLUDE;
	}

	public String templateLogic(HttpServletRequest request, HttpSession session) throws IOException 
	{
		// Template Para Values
		Map<String, String> mapParaValues = null;
		Map<String, GenericTemplateUtility.TempParameter> mapParaDetail = null;
		if(session.getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_PARAMETER_VALUES_MAP_TEMPLATE_MAP) != null)
		{
			Map<String, Map<String, String>> mapAllTempParaValues = (Map<String, Map<String, String>>)session.getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_PARAMETER_VALUES_MAP_TEMPLATE_MAP);
			mapParaValues = mapAllTempParaValues.get(this.templateId);
		}
		if(session.getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_PARAMETER_VALUES_DETAIL_MAP) != null)
		{
			Map<String, Map<String, GenericTemplateUtility.TempParameter>> mpAllTempParaDtl = (Map<String, Map<String, GenericTemplateUtility.TempParameter>>)session.getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_PARAMETER_VALUES_DETAIL_MAP);
			mapParaDetail = mpAllTempParaDtl.get(this.templateId);				
		}
				
		
		if(this.mode==null)
			this.mode = GenericTemplateConfig.GENERIC_TEMPLATE_MODE_EDITABLE;
		if(!(this.mode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_EDITABLE) 
				|| this.mode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_REPORT) 
				|| this.mode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_SUMMARIZED_REPORT) 
				|| this.mode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_EDITABLE_NON_ENTERED) 
				|| this.mode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_EDITABLE_FOCUS_ENTERED)
				|| this.mode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_SHORT_SUMMARIZED_REPORT)))
			this.mode = GenericTemplateConfig.GENERIC_TEMPLATE_MODE_EDITABLE;
			
		// Getting Gender Type from Session
		String genderType = GenericTemplateConfig.GENERIC_TEMPLATE_PATIENT_INITIAL_GENDER_TYPE;
		if(session.getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_PATIENT_GENDER_TYPE)!= null)
			genderType = (String)session.getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_PATIENT_GENDER_TYPE);

		String tempCode = null;
		// Statically from HTML File
		//tempCode = GenericTemplateUtility.readTemplateFromHTMLFile(this.templateId);// Commented By Pragya 2015.01.02 We will fetch data from database each time as we are already firing a no. of queries for template
		
		// Dynamically From Database
		if(tempCode == null)
			tempCode = GenericTemplateUTL.generateHTMLTemplate(this.templateId, mapParaValues, this.mode, request);

		if(!this.mode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_SHORT_SUMMARIZED_REPORT))
		{
			TemplateMasterVO vo = (TemplateMasterVO)request.getSession().getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_DETAIL_VO);
			if(vo == null)
			{
				vo = GenericTemplateUTL.getTemplateDataById(this.templateId, request);
			}
			// Setting Template Values on Mode
			tempCode = TemplateDesignerUtility.fillParameterValuesIntoHTMLCode(tempCode, mapParaValues, mapParaDetail, this.mode, vo.getTemplateType(), genderType);
		}

		return tempCode;
	}

	public String getTemplateId()
	{
		return templateId;
	}

	public void setTemplateId(String templateId)
	{
		this.templateId = templateId;
	}

	public String getMode()
	{
		return mode;
	}

	public void setMode(String mode)
	{
		this.mode = mode;
	}	
}
