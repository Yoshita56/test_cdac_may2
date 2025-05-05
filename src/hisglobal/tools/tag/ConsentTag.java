package hisglobal.tools.tag;

import hisglobal.presentation.WebUTIL;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class ConsentTag extends TagSupport
{
	public int doStartTag() throws JspTagException
	{
		//get page context
		try
		{
			JspWriter out = this.pageContext.getOut();
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			out.println(getSubTitle(request));
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

	protected String getSubTitle(HttpServletRequest _request)
	{
		String strSpaceFillerFile = WebUTIL.getAbsoluteImagePath(_request, IMG_SPACE_FILLER);
		String strImageTopLeft = WebUTIL.getAbsoluteImagePath(_request, IMG_TOP_LEFT_CORNER);
		String strImageTopRight = WebUTIL.getAbsoluteImagePath(_request, IMG_TOP_RIGHT_CORNER);
		String strImageShadedBackground = WebUTIL.getAbsoluteImagePath(_request, IMG_SHADED_BACKGROUND);

		String strDivTop = "<table  width='100%' border='0' cellspacing='1' cellpadding='0'>"
						  + "<tr>"
						  + "<td width='5%'  class='tdfonthead'>"
						  + "<div align='center'>"	           
						  + " <font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>"
						  + "<b><bean:message key='select'/></b> " 
						  + "</font> "
						  + "</div>"
						  + "</td>"
						  + "</tr>"
						  + "</table>";
			

		return strDivTop;
	}

	protected String getTransactionBottom(HttpServletRequest _request)
	{
		String strSpaceFillerFile = WebUTIL.getAbsoluteImagePath(_request, IMG_SPACE_FILLER);
		String strImageBottomLeft = WebUTIL.getAbsoluteImagePath(_request, IMG_BOTTOM_LEFT_CORNER);
		String strImageBottomRight = WebUTIL.getAbsoluteImagePath(_request, IMG_BOTTOM_RIGHT_CORNER);
		String strDivBottom = "</b></td></tr></table>" + "\n<div style=\"background: url(" + strImageBottomRight + ") no-repeat top right;\">\n"
				+ "<img src=\"" + strImageBottomLeft + "\" alt='' style=\'border: none; display: block !important;'/>\n" + "</div></div></td></tr>\n";

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
		System.out.println("name.........................getter......................." + name);
		if (this.name == null) return "";
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
		System.out.println("name...............................setter................." + name);
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
