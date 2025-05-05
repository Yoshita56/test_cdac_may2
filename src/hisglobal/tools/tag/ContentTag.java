package hisglobal.tools.tag;

import hisglobal.presentation.WebUTIL;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class ContentTag extends TagSupport
{
	public int doStartTag() throws JspTagException
	{
		// get page context
		try
		{
			JspWriter out = this.pageContext.getOut();
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			out.println(getContent(request));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return TagSupport.EVAL_BODY_INCLUDE;
		// String strDivBottom = getDivBottom();
	}

	public int doAfterBody()
	{
		try
		{
			JspWriter out = this.pageContext.getOut();
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			out.println(getTransactionBottom(request));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return TagSupport.EVAL_PAGE;
	}

	protected String getContent(HttpServletRequest _request)
	{
		String strSpaceFillerFile = WebUTIL.getAbsoluteImagePath(_request, IMG_SPACE_FILLER);
		String strImageTopLeft = WebUTIL.getAbsoluteImagePath(_request, IMG_TOP_LEFT_CORNER);
		String strImageTopRight = WebUTIL.getAbsoluteImagePath(_request, IMG_TOP_RIGHT_CORNER);
		String strImageBottomRight = WebUTIL.getAbsoluteImagePath(_request, IMG_BOTTOM_RIGHT_CORNER);
		String strImageShadedBackground = WebUTIL.getAbsoluteImagePath(_request, IMG_SHADED_BACKGROUND);

		String strDivTop = "\n<!-- Content Started -->\n" 
				+ "\n<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">"
				+ "<tr><td height=\"1\" style=\"background-color: #000;\" /></tr>\n"
				+ "<tr><td height=\"2\"><div align=\"center\">\n"
				+ "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"1\" class=\"ContentTagSideLine\" >"
				+ "<tr><td style=\"background-color: #FFFFFF\" width=\"100%\">";

		return strDivTop;
	}

	protected String getTransactionBottom(HttpServletRequest _request)
	{
		String strSpaceFillerFile = WebUTIL.getAbsoluteImagePath(_request, IMG_SPACE_FILLER);
		String strImageShadedBackground = WebUTIL.getAbsoluteImagePath(_request, IMG_SHADED_BACKGROUND);
		String strImageBottomRight = WebUTIL.getAbsoluteImagePath(_request, IMG_BOTTOM_RIGHT_CORNER);
		String strImageBottomLeft = WebUTIL.getAbsoluteImagePath(_request, IMG_BOTTOM_LEFT_CORNER);
		String strDivBottom = "\n</td></tr></table></div></td></tr>\n"
			+ "<tr><td height=\"1\" style=\"background-color: #000;\" /></tr>\n"
				+ "</table>\n"
				+ "<!--Content of the Page ends -->";
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
	String IMG_TOP_LEFT_CORNER = "rnd-trans-9090b0-LT.jpg";
	String IMG_TOP_RIGHT_CORNER = "rnd-trans-9090b0-RT.jpg";
	String IMG_BOTTOM_LEFT_CORNER = "rnd-trans-9090b0-LB.jpg";
	String IMG_BOTTOM_RIGHT_CORNER = "rnd-trans-9090b0-RB.jpg";
	String IMG_SHADED_BACKGROUND = "shd-trans-9090b0.png";

}
