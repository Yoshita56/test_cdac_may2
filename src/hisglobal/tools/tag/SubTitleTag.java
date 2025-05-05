package hisglobal.tools.tag;

import javax.servlet.http.HttpServletRequest;

public class SubTitleTag extends SuperTitleTagSupport
{
	protected String getFrontBar(HttpServletRequest _request)
	{
		String strDivTop = "\n<!-- SubTitleBar Started -->\n"
				+ "\n<table width=\"100%\" cellpadding=\"2\" cellspacing=\"0\">"
				/*+ "\n<tr><td class=\"applicationBackgroundColor\"/></tr>"*/
				+ "\n<tr><td class=\"ShadedSubTitleTagImage\">"  
				+ "\n<span>"  
				+ "\n<table width='100%' cellspacing=\"0\" cellpadding=\"0\">\n"
				+ "<tr><td class=\"TitleTagFontStyle\"><div align=\"left\"><b>"
				+ this.getName()
				+ "</b></div></td><td class=\"TitleTagFontStyle\"><div align=\"right\"><b>\n";
		
		return strDivTop;
	}

	protected String getEndBar(HttpServletRequest _request)
	{
		String strDivBottom = "\n</b></div></td></tr></table></span>"
				+ "\n</td></tr></table>" 
				+ "\n<!-- SubTitleBar Finished -->";
		return strDivBottom;
	}
}
