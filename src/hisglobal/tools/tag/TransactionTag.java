package hisglobal.tools.tag;

import hisglobal.presentation.WebUTIL;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TransactionTag extends TagSupport
{

	//	 convention for this is that the name of the image is rnd-bgcolor-frgcolor-LT.ext

	public int doStartTag() throws JspTagException
	{
		//get page context
		try
		{
			JspWriter out = this.pageContext.getOut();
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			out.println(getTransactionTop(request));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return TagSupport.EVAL_BODY_INCLUDE;
		//String strDivBottom = getDivBottom();
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

	protected String getTransactionTop(HttpServletRequest _request)
	{
		String strSpaceFillerFile = WebUTIL.getAbsoluteImagePath(_request, IMG_SPACE_FILLER);
		String strDivTop = "<!-- Transaction Started -->" + "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" >"
				+ "<tr><td style =\"background: url('" + strSpaceFillerFile + "'); background-repeat:repeat-x;\">&nbsp;</td>" + "<td width='"
				+ this.getRequiredWidth() + "' valign='top'>" + "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"1\">" + "<tr><td>";

		return strDivTop;
	}

	protected String getTransactionBottom(HttpServletRequest _request)
	{
		String strSpaceFillerFile = WebUTIL.getAbsoluteImagePath(_request, IMG_SPACE_FILLER);
		String strDivBottom = "</td></tr></table></td><td style =\"background: url('" + strSpaceFillerFile
				+ "'); background-repeat:repeat-x;\">&nbsp;</td>" + "</tr><div id=\"shortCutKey\"></div> </table>" + "<!-- Transaction Finished -->";

		return strDivBottom;
	}

	private String width;

	public String getWidth()
	{
		return width;
	}

	public void setWidth(String width)
	{
		this.width = width;
	}

	public String getRequiredWidth()
	{
		if (this.width == null) return DEFAULT_WIDTH;
		return this.width;
	}

	String IMG_SPACE_FILLER = "bkg-spacefiller.jpg";
	String DEFAULT_WIDTH = "800";

}
