package hisglobal.tools.tag;

import javax.servlet.http.HttpServletRequest;

public class TitleTag extends SuperTitleTagSupport
{
	protected String getFrontBar(HttpServletRequest _request)
	{
		String strDivTop = "\n<!-- TitleBar Started -->\n"
				+ "\n<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">"
				+ "\n<tr><td style=\"background-color: #FFFFFF;\"/></tr>"
				+ "\n<tr><td class=\"ShadedTitleTagImage\">"
				+ "\n<span>"
				+ "\n<table width='100%' cellspacing=0 cellpadding=5>\n"
				+ "\n<tr><td class=\"TitleTagFontStyle\"><div align=\"left\"><b>"
				+ this.getName() + "</b></div></td><td class=\"TitleTagFontStyle\"><div align=\"right\"><b>\n";

		return strDivTop;
	}

	protected String getEndBar(HttpServletRequest _request)
	{
		String strDivBottom = "\n</b></div></td></tr></table>"
				+ "\n</span>" 
				+ "\n</td></tr>"
				+ "</table>" 
				+ "\n<!-- TitleBar Finished -->";
		
		return strDivBottom;
	}
}
