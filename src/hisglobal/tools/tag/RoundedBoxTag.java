package hisglobal.tools.tag;

import hisglobal.presentation.WebUTIL;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class RoundedBoxTag extends TagSupport
{
	// convention for this is that the name of the image is rnd-bgcolor-frgcolor-LT.ext
	public int doStartTag() throws JspTagException
	{
		// get page context
		try
		{
			JspWriter out = this.pageContext.getOut();
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			out.println(getDivTop(request));
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
			out.println(getDivBottom(request));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return TagSupport.EVAL_PAGE;
	}

	protected String getDivTop(HttpServletRequest _request)
	{
		String strImage = "rnd-" + background + "-" + foreground;

		String strImageExt = this.getImageExtension();

		String strLTImage = strImage + "-LT" + strImageExt;
		String strRTImage = strImage + "-RT" + strImageExt;

		String strDivTop = "<div style='background-color:#" + foreground + "; color:#" + textColor() + "'> " + " <div style=\"background: url('"
				+ WebUTIL.getAbsoluteImagePath(_request, strRTImage) + "') no-repeat top right; \"> " + " <img src='"
				+ WebUTIL.getAbsoluteImagePath(_request, strLTImage) + "' alt='' "
				+ " width='15' height='15' style='width: 15px;  height: 15px; border: none; display: block !important;'/> " + " </div> "
				+ " <p style = 'margin: 0 10px;'> ";

		return strDivTop;
	}

	protected String getDivBottom(HttpServletRequest _request)
	{
		String strImage = "rnd-" + background + "-" + foreground;

		String strImageExt = this.getImageExtension();

		String strLBImage = strImage + "-LB" + strImageExt;
		String strRBImage = strImage + "-RB" + strImageExt;

		String strDivBottom = "</p> <div style=\"background: url('" + WebUTIL.getAbsoluteImagePath(_request, strRBImage)
				+ "') no-repeat top right;\"> " + " <img src='" + WebUTIL.getAbsoluteImagePath(_request, strLBImage) + "' alt=\"\" "
				+ "width=\"15\" height=\"15\" style=\"width: 15px;  height: 15px; border: none; display: block !important;\"/>" + " </div> </div>";

		return strDivBottom;
	}

	protected String getImageExtension()
	{
		if (this.png != null) return ".png";
		if (this.gif != null) return ".gif";
		if (this.jpg != null) return ".jpg";
		if (this.bmp != null) return ".bmp";

		// default extention is .png;
		return ".png";
	}

	protected String textColor()
	{
		if (this.textColor != null) return this.textColor;

		return "000000";
	}

	private String textColor;
	private String foreground;
	private String background;
	private String png;
	private String gif;
	private String jpg;
	private String bmp;

	public String getBmp()
	{
		return bmp;
	}

	public void setBmp(String bmp)
	{
		this.bmp = bmp;
	}

	public String getGif()
	{
		return gif;
	}

	public void setGif(String gif)
	{
		this.gif = gif;
	}

	public String getJpg()
	{
		return jpg;
	}

	public void setJpg(String jpg)
	{
		this.jpg = jpg;
	}

	public String getPng()
	{
		return png;
	}

	public void setPng(String png)
	{
		this.png = png;
	}

	public String getBackground()
	{
		return background;
	}

	public void setBackground(String background)
	{
		this.background = background;
	}

	public String getForeground()
	{
		return foreground;
	}

	public void setForeground(String foreground)
	{
		this.foreground = foreground;
	}

	public String getTextColor()
	{
		return textColor;
	}

	public void setTextColor(String textColor)
	{
		this.textColor = textColor;
	}

}
