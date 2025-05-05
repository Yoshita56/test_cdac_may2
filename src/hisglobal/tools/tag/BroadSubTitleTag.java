package hisglobal.tools.tag;

import hisglobal.hisconfig.Config;
import hisglobal.presentation.WebUTIL;

import javax.servlet.http.HttpServletRequest;

public class BroadSubTitleTag extends SuperTitleTagSupport {

	protected String getFrontBar(HttpServletRequest _request)
	{
		String strSpaceFillerFile = WebUTIL.getAbsoluteImagePath(_request, IMG_SPACE_FILLER);
		String strImageTopLeft = WebUTIL.getAbsoluteImagePath(_request, IMG_TOP_LEFT_CORNER);
		String strImageTopRight = WebUTIL.getAbsoluteImagePath(_request, IMG_TOP_RIGHT_CORNER);
		String strImageShadedBackground = WebUTIL.getAbsoluteImagePath(_request, IMG_BACKGROUND);

		String strDivTop = "\n<!-- SubTitleBar Started -->\n"
				+ "\n<table width=\"100%\" cellpadding=\"2\" cellspacing=\"0\">"
				/*+ "\n<tr><td class=\"applicationBackgroundColor\"/></tr>"*/
				+ "\n<tr><td class=\"ShadedSubTitleTagImageBroad\">"
				+ "\n<span>"
				+ "\n<table width='100%' cellspacing=\"0\" cellpadding=\"0\">\n"
				+ "<tr><td class=\"TitleTagFontStyle\"><div align=\"left\"><b>"
				+ this.getName()
				+ "</b></div></td><td class=\"TitleTagFontStyle\"><div align=\"right\"><b>\n";

		return strDivTop;
	}

	protected String getEndBar(HttpServletRequest _request)
	{
		String strSpaceFillerFile = WebUTIL.getAbsoluteImagePath(_request, IMG_SPACE_FILLER);
		String strImageBottomLeft = WebUTIL.getAbsoluteImagePath(_request, IMG_BOTTOM_LEFT_CORNER);
		String strImageBottomRight = WebUTIL.getAbsoluteImagePath(_request, IMG_BOTTOM_RIGHT_CORNER);
		String strDivBottom = "\n</b></div></td></tr></table></span>"
				+ "\n</td></tr></table>" 
				+ "\n<!-- SubTitleBar Finished -->";
		/*
		 * String strDivBottom = "</b></td></tr></table></td><td style=\"background: #9090b0;\"></td></tr>"+ "<tr><td><img
		 * src='"+strImageBottomLeft+"'/></td>" + "<td style=\"background-color: #9090b0; color:#fff) left;\"></td>" + "<td><img
		 * src=\'"+strImageBottomRight+"\'/></td>" + "</tr></table>"+ "\n<!-- SubTitle Bar ends -->\n";
		 */
		return strDivBottom;
	}

	String IMG_SPACE_FILLER = "bkg-spacefiller.jpg";

	String IMG_TOP_LEFT_CORNER = "rnd-trans-9090b0-LT.jpg";
	String IMG_TOP_RIGHT_CORNER = "rnd-trans-9090b0-RT.jpg";
	String IMG_BOTTOM_LEFT_CORNER = "rnd-trans-9090b0-LB.jpg";
	String IMG_BOTTOM_RIGHT_CORNER = "rnd-trans-9090b0-RB.jpg";
	String IMG_BACKGROUND = Config.IMAGE_FOR_TITLE_TAG;


}
