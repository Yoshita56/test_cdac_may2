package hisglobal.utility.generictemplate.controller.action;

import hisglobal.presentation.WebUTIL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.utility.HisHTMLParserUtil;
import hisglobal.utility.generictemplate.controller.fb.PDFPrintingUtilityFB;
import hisglobal.utility.servlets.ServletsUtilityConfig;

public class PDFPrintingUtilityACT extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)
	{
		return this.NEW(mapping, form, request, response);
	}

	public ActionForward NEW(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)
	{
		PDFPrintingUtilityFB fb = (PDFPrintingUtilityFB) form;
		HttpSession session = WebUTIL.getSession(request);			
		try
		{
			if(fb.getErrorMode().equals("NONE"))
			{
				String htmlCode = (String)session.getAttribute(ServletsUtilityConfig.HTML_TO_PDF_UTIL_HTML_CODE);
				if(htmlCode!=null && !htmlCode.equals(""))
				{
					fb.setErrorMode("OK");
					fb.setHtmlCode(HisHTMLParserUtil.freezeHTMLCodeElements(htmlCode));
				}
				else
					fb.setErrorMode("TRY"); // now fetch data from opener's id Value 'pdfPrintingHTMLData'
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fb.setErrorMode("ERROR");
			fb.setErrorMessage("Error: No Data Available for Printing");
		}
		if(fb.getErrorMode().equals("OK"))
		{
			fb.setHtmlCode(HisHTMLParserUtil.freezeHTMLCodeElements(fb.getHtmlCode()));
			WebUTIL.setAttributeInSession(request,ServletsUtilityConfig.HTML_TO_PDF_UTIL_HTML_CODE, fb.getHtmlCode());
			// Water Marking
			if(fb.getWaterMarkText()!=null && !fb.getWaterMarkText().equals(""))
				WebUTIL.setAttributeInSession(request, ServletsUtilityConfig.WATERMARK_PDF_TEXT, fb.getWaterMarkText());
			if(fb.getModePrint().equals("PDF"))	fb.setModePrint("PDFGO");
		}
		return mapping.findForward("HTML");
	}
}
