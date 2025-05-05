package hisglobal.tools.tag;

import hisglobal.presentation.WebUTIL;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class ButtonToolBarTag extends TagSupport
{
	public int doStartTag() throws JspTagException
	{
		try
		{
			JspWriter out = this.pageContext.getOut();
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			out.println(getButtonToolBar(request));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return TagSupport.EVAL_BODY_INCLUDE;
	}

	public int doAfterBody()
	{
		try
		{
			JspWriter out = this.pageContext.getOut();
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			out.println(getButtonToolBarBottom(request));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return TagSupport.EVAL_PAGE;
	}

	protected String getButtonToolBar(HttpServletRequest _request)
	{
		String strImageTop = WebUTIL.getAbsoluteImagePath(_request, IMG_TOP);
		String strImageLeft = WebUTIL.getAbsoluteImagePath(_request, IMG_LEFT);
		String strImageButtonTabLT = WebUTIL.getAbsoluteImagePath(_request, IMG_LEFT_TOP_BUTTON_TOOL_BAR);
		String strImageButtonTabRT = WebUTIL.getAbsoluteImagePath(_request, IMG_RIGHT_TOP_BUTTON_TOOL_BAR);

		String strDivTop = "<!-- Button toolbar Started -->"
				+ "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n"
				+ "<tr><td width=\"5px\"><img src='" + strImageButtonTabLT + "'/></td>\n"
				+ "<td style=\"background-color:#FFFFFF; background: url('" + strImageTop + "') top;  background-repeat:repeat-x;\"></td>\n"
				+ "<td width=\"5px\"><img src=\'" + strImageButtonTabRT + "\'/></td>" + "</tr>\n"
				+ "<tr><td style=\"background-color:#FFFFFF; background: url('" + strImageLeft + "') left; background-repeat:repeat-y;\" />\n"
				+ "<td style=\"background-color:#FFFFFF;\" width=\"100%\">\n"
				+ "<div align=\"center\">\n";

		return strDivTop;
	}

	protected String getButtonToolBarBottom(HttpServletRequest _request)
	{
		String strImageRight = WebUTIL.getAbsoluteImagePath(_request, IMG_RIGHT);
		String strImageBottom = WebUTIL.getAbsoluteImagePath(_request, IMG_BOTTOM);
		String strImageButtonTabLB = WebUTIL.getAbsoluteImagePath(_request, IMG_LEFT_BOTTOM_BUTTON_TOOL_BAR);
		String strImageButtonTabRB = WebUTIL.getAbsoluteImagePath(_request, IMG_RIGHT_BOTTOM_BUTTON_TOOL_BAR);

		String strDivBottom = "</div></td>\n"
				+ "<td style=\"background-color:#FFFFFF; background: url('" + strImageRight + "') right;  background-repeat:repeat-y;\" /></tr>\n" 
				+ "<tr><td width=\"5px\" ><img src=\'" + strImageButtonTabLB + "\'/></td>\n"
				+ "<td style=\"background: url('" + strImageBottom + "') bottom;  background-repeat:repeat-x;\"></td>\n"
				+ "<td width=\"5px\" ><img src=\'" + strImageButtonTabRB + "\'/></td></tr></table>\n"
				+ "<!-- Button toolbar Finished -->\n";

		return strDivBottom;
	}

	private String width;
	private String name;

	public String getWidth()
	{
		return width;
	}

	public void setWidth(String width)
	{
		this.width = width;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getRequiredWidth()
	{
		if (this.width == null) return DEFAULT_WIDTH;
		return this.width;
	}

	String IMG_SPACE_FILLER = "bkg-spacefiller.jpg";
	String DEFAULT_WIDTH = "800";
	String IMG_TOP = "border-top.gif";
	String IMG_RIGHT = "border-right.gif";
	String IMG_BOTTOM = "border-bottom.gif";
	String IMG_LEFT = "border-left.gif";
	String IMG_LEFT_BOTTOM_BUTTON_TOOL_BAR = "rnd-trans-ffffff-bdr-LB.gif";
	String IMG_RIGHT_BOTTOM_BUTTON_TOOL_BAR = "rnd-trans-ffffff-bdr-RB.gif";
	String IMG_LEFT_TOP_BUTTON_TOOL_BAR = "rnd-trans-ffffff-bdr.gif";
	String IMG_RIGHT_TOP_BUTTON_TOOL_BAR = "rnd-trans-ffffff-bdr-RT.gif";

}
