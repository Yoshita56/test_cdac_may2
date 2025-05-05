package hisglobal.tools.tag;

import hisglobal.presentation.WebUTIL;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class AddressTag extends TagSupport
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

		String strDivTop = "<table width=\"100%\"  border=\"1\"  bordercolor=\"#333333\" cellspacing=\"1\" cellpadding=\"0\">"
				+ "<tr> <td valign=\"top\">"
				+ "Address Detail"
				+ "&nbsp;"
				+ "Delhi"
				+ "<html:radio name=\"NewRegistrationFB\" property=\"isAddressDelhi\" value=\"1\" tabindex=\"3\" onclick=\"showdelhidiv();submitForm('DELHI')\" />"
				+ "Other\"+\"<html:radio name=\"NewRegistrationFB\" property=\"isAddressDelhi\" value=\"0\" tabindex=\"3\" onclick=\"shownondelhidiv();submitForm('NONDELHI')\"/>"
				+ "</his:SubTitleTag></td><td valign=\"top\"> <table width=\"100%\" cellpadding=\"0\" cellspacing=\"1\" border=\"0\">"
				+ "<logic:equal name=\"NewRegistrationFB\" property=\"isAddressDelhi\" value=\"0\">"
				+ " <%  divdisplay=\"none\";"
				+ "divnddisplay=\"\";"
				+ "%>"
				+ "</logic:equal>"
				+ "<logic:equal name=\"NewRegistrationFB\" property=\"isAddressDelhi\" value=\"1\">"
				+ "<%"
				+ "divdisplay=\"\";"
				+ "divnddisplay=\"none\";"
				+ "%>"
				+ "</logic:equal>"
				+ "<tr>"
				+ "<td  class=\"tdfonthead\">"
				+ "<div align=\"right\">+"
				+ "<font color=\"#000000\" size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">"
				+ "<bean:message key=\"hno\"/>"
				+ "</font></div></td>"
				+ "<td  class=\"tdfont\" ><html:text  name=\"NewRegistrationFB\" onkeypress=\"return validateAlphaNumericOnly(event);\" property=\"patAddHNo\" tabindex=\"3\" maxlength=\"15\" styleClass=\"textbox\"/>"
				+ "</td></tr><tr>"
				+ "<td  class=\"tdfonthead\" >"
				+ "<div align=\"right\">"
				+ "<font color=\"#000000\" size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\"><bean:message key=\"street\"/>"
				+ "</font></div></td><td  class=\"tdfont\">"
				+ "<html:text  name=\"NewRegistrationFB\" property=\"patAddStreet\" onkeypress=\"return validateAlphaNumericOnly(event);\" tabindex=\"3\" maxlength=\"30\" styleClass =\"textbox\"/>"
				+ "</td></tr><tr>"
				+ "<td  class=\"tdfonthead\" >"
				+ "<div align=\"right\">"
				+ "<font color=\"#000000\" size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">"
				+ "<bean:message key=\"location\"/></font><font color=\"#FF0000\" size=\"1\" face=\"Verdana, Arial, Helvetica, sans-serif\">*</font></div></td>"
				+ "<td  class=\"tdfont\"><div id=\"divpatAddCityLocCode\" style='display:<%=divdisplay%>'>"
				+ "<html:select name=\"NewRegistrationFB\" tabindex=\"3\" styleClass=\"regcbo\" property=\"patAddCityLocCode\"> <html:option value=\"-1\">Select Value</html:option>"
				+ "<html:options collection =\"<%=RegistrationConfig.ESSENTIALBO_OPTION_LOCATION%>\" property = \"value\" labelProperty = \"label\"/>"
				+ "</html:select></div><div id=\"divpatAddCityLocation\" style=\'display:<%=divnddisplay%>\'>"
				+ "<html:text  name=\"NewRegistrationFB\" tabindex=\"3\"  maxlength=\"30\" onkeypress=\"return validateAlphaNumericOnly(event);\" styleClass=\"textbox\" property=\"patAddCityLoc\"/>"
				+ "</div></td></tr><tr>"
				+ "<td  class=\"tdfonthead\" ><div align=\"right\">"
				+ "<font color=\"#000000\" size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">"
				+ "<bean:message key=\"district\"/>"
				+ "</font></div></td><td  class=\"tdfont\">"
				+ "<html:text  name=\"NewRegistrationFB\" tabindex=\"3\" property=\"patAddDistrict\" onblur=\"IsAlphaNumeric(this,'District');\" onkeypress=\"return validateAlphaNumericOnly(event);\" maxlength=\"30\" styleClass=\"textbox\"/>"
				+ "</td>"
				+ "</tr><tr>"
				+ "<td  class=\"tdfonthead\" ><div align=\"right\">"
				+ "<font color=\"#000000\" size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">"
				+ "<bean:message key=\"city\"/>"
				+ "</font> </div></td>"
				+ "<td  class=\"tdfont\">"
				+ "<html:text  name=\"NewRegistrationFB\" tabindex=\"3\" property=\"patAddCity\" onblur=\"IsAlpha(this,'City');\" onkeypress=\"return validateAlphabetsOnly(event);\" maxlength=\"30\" styleClass=\"textbox\"/>"
				+ "</td></tr><tr>"
				+ "<td  class=\"tdfonthead\" >"
				+ "<div align=\"right\"><font color=\"#000000\" size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">"
				+ "<bean:message key=\"state\"/></font>"
				+ "<font color=\"#FF0000\" size=\"1\" face=\"Verdana, Arial, Helvetica, sans-serif\">*</font>"
				+ "</div></td><td  class=\"tdfont\">"
				+ "<div id=\"divnondelhistate\">"
				+ "<html:select name=\"NewRegistrationFB\" tabindex=\"3\" property=\"patAddStateCode\" styleClass=\"regcbo\" >"
				+ "<html:option value=\"-1\">Select Value</html:option>"
				+ "<html:options collection = \"<%=RegistrationConfig.ESSENTIALBO_OPTION_STATE %>\" property = \"value\" labelProperty = \"label\"/>"
				+ "</html:select>"
				+ "</div></td></tr>"
				+ "<tr>"
				+ "<td  class=\"tdfonthead\" >"
				+ "<div align=\"right\">"
				+ "<font color=\"#000000\" size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">"
				+ "<bean:message key=\"pin\"/>"
				+ "</font></div></td>"
				+ "<td  class=\"tdfont\">"
				+ "<html:text  name=\"NewRegistrationFB\" tabindex=\"3\" property=\"patAddPIN\"  maxlength =\"6\" styleClass=\"textbox\" onkeypress=\"return validateNumeric(event)\"/>"
				+ "</td></tr>"
				+ "<tr>"
				+ "<td  class=\"tdfonthead\" ><div align=\"right\"><font color=\"#000000\" size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">"
				+ "<bean:message key=\"country\"/></font><font color=\"#FF0000\" size=\"1\" face=\"Verdana, Arial, Helvetica, sans-serif\">*</font></div></td>"
				+ "<td  class=\"tdfont\">"
				+ "<div id=patCountryCombo>"
				+ "<html:select name=\"NewRegistrationFB\" tabindex=\"3\" property=\"patAddCountryCode\" styleClass=\"regcbo\">"
				+ "<html:option value=\"-1\">Select Value</html:option>"
				+ "<html:options collection =\"<%=RegistrationConfig.ESSENTIALBO_OPTION_COUNTRY %>\"property = \"value\" labelProperty = \"label\"/>"
				+ "</html:select>"
				+ "</div>"
				+ "</td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td  class=\"tdfonthead\" ><div align=\"right\"><font color=\"#000000\" size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">"
				+ "<bean:message key=\"contactNo\"/><font color=\"#FF0000\" size=\"1\" face=\"Verdana, Arial, Helvetica, sans-serif\">*</font></font></div></td>"
				+ "<td  class=\"tdfont\">"
				+ "<div id=patCountryCombo>"
				+ "<html:text  name=\"NewRegistrationFB\" tabindex=\"3\" property=\"patAddContactNo\"  maxlength =\"30\" styleClass=\"textbox\" onkeypress=\"return validateNumeric(event)\"/>"
				+ "</div></td>" + "</tr>" + "</table>";

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
