package hisglobal.tools.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class DynamicDeskButtonTag extends TagSupport
{
	private String color;
	private String userDeskMenuName;
	private String deskMenuId;
	private String deskUrl;
	private String isLoginBound;
	private String dutyRoleId;

	/*private String deskId;
	private String location;
	private String displayOrder;
	private String isDefaultProfile;
	private String profileOrder;
		// Desk Menu Detail
	private String deskMenuName;
	private String deskType;
	private String isTemplateBased;
	private String templateCategory;
	private String usabilityFlag;*/


	public int doStartTag() throws JspException
	{
		try
		{
			this.color = ((String) TagUtil.invokeGetterFor(this.getBean(), "Color"));
			this.userDeskMenuName = ((String) TagUtil.invokeGetterFor(this.getBean(), "UserDeskMenuName"));
			this.deskMenuId = ((String) TagUtil.invokeGetterFor(this.getBean(), "DeskMenuId"));
			this.deskUrl = ((String) TagUtil.invokeGetterFor(this.getBean(), "DeskUrl"));
			this.isLoginBound = ((String) TagUtil.invokeGetterFor(this.getBean(), "IsLoginBound"));
			this.dutyRoleId = ((String) TagUtil.invokeGetterFor(this.getBean(), "DutyRoleId"));
			JspWriter out = this.pageContext.getOut();
			out.println(this.getTab());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return TagSupport.EVAL_BODY_INCLUDE;
	}

	public String getTab()
	{
		String strReturn = "";
		String strStyle="background-color:"+this.color+";border-color:"+this.color+";";
		strReturn = "<td width='100%'><button id='" + this.deskUrl + "' class='button' style='width:100%;" + strStyle 
				+ "' onClick=submitFormOnValidateButton(event,'"+this.deskUrl+"','"+this.deskMenuId+"','"+this.isLoginBound+"','"+this.dutyRoleId
				+ "')><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'><b>"
				+ this.userDeskMenuName + "</b></font></button> " + "" + "</td>";
		String strOnClick="DynamicDeskButtonOnMouseClicked(this);submitFormOnValidateButton(event,'"+this.deskUrl+"','"+this.deskMenuId+"','"+this.isLoginBound+"','"+this.dutyRoleId+"');";
		strReturn = "<td id='" + this.deskUrl + "' headers='" + this.deskMenuId + "' class='tdDynamicDeskButtonNormal' style='" + strStyle
				+ "' onmouseover='DynamicDeskButtonOnMouseOver(this)' onmouseout='DynamicDeskButtonOnMouseOut(this)' "
				+ "onmousedown='DynamicDeskButtonOnMouseDown(this)' onmouseup='DynamicDeskButtonOnMouseUp(this)' "
				+ "onclick=" + strOnClick +">"+ this.userDeskMenuName + "<input type='hidden' name='deskMenuID#"+this.deskMenuId+"'/></td>";

		return strReturn;
	}

	String name;
	Object bean;

	public Object getBean()
	{
		return bean;
	}

	public void setBean() throws JspException
	{
		this.bean = TagUtil.getAttribute(this.pageContext, this.getName());
		if (this.bean == null) throw new RuntimeException("No bean with name: " + this.getName());
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name) throws JspException
	{
		this.name = name;
		this.setBean();
	}

}
