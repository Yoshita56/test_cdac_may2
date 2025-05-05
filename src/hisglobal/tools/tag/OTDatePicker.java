package hisglobal.tools.tag;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.beanutils.PropertyUtils;

public class OTDatePicker extends BodyTagSupport
{

	String beanName;
	String property;
	String readOnly="true";
	String onChange;
	String onClick;
	String dateFormate;
	String id;
	String size="14";
	String idIconPicDate;

	public String getIdIconPicDate() {
		return idIconPicDate;
	}

	public void setIdIconPicDate(String idIconPicDate) {
		this.idIconPicDate = idIconPicDate;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getDateFormate()
	{
		return dateFormate;
	}

	public void setDateFormate(String dateFormate)
	{
		this.dateFormate = dateFormate;
	}

	public String getBeanName()
	{
		return beanName;
	}

	public void setBeanName(String beanName)
	{
		this.beanName = beanName;
	}

	public String getOnChange()
	{
		return onChange;
	}

	public void setOnChange(String onchange)
	{
		this.onChange = onchange;
	}

	public String getOnClick()
	{
		return onClick;
	}

	public void setOnClick(String onClick)
	{
		this.onClick = onClick;
	}

	public String getProperty()
	{
		return property;
	}

	public void setProperty(String property)
	{
		this.property = property;
	}

	public String getReadOnly()
	{
		return readOnly;
	}

	public void setReadOnly(String readOnly)
	{
		this.readOnly = readOnly;
	}

	public int doStartTag() throws JspException
	{
		JspWriter out = pageContext.getOut();
		Object beanObj = pageContext.findAttribute(this.getBeanName());
		if (beanObj == null)
		{
			System.out.println("Could not Find the Bean In Any Scope");
		}
		else
		{
			try
			{
				String propertyValue = (String) PropertyUtils.getProperty(beanObj, this.getProperty());
				System.out.println("Date Value  =" + propertyValue);
				out.write(DateString(propertyValue));

			}
			catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
			catch (InvocationTargetException e)
			{
				e.printStackTrace();
			}
			catch (NoSuchMethodException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return EVAL_BODY_BUFFERED;
	}

	public String DateString(String propertyValue)
	{
		String dateString = "";
		String onChangeString = "";
		if (this.getOnChange() != null && !this.getOnChange().equalsIgnoreCase(""))
		{
			onChangeString = "onChange='" + this.getOnChange() + "'";
		}
		String onClickStr = "";
		if (this.getOnClick() != null && !this.getOnClick().equalsIgnoreCase(""))
		{
			onChangeString = "onClick='" + this.getOnClick() + "'";
		}

		if (dateFormate == null || dateFormate.equals("")) dateFormate = "%d-%b-%Y";

		if (id == null || id.equals("")) this.id = this.getProperty();

		String value = "";
		if (propertyValue != null && !propertyValue.equals("")) value = "value='" + propertyValue + "'";

		String size = "";
		if (this.size != null) size += "size ='" + this.size + "'";

		String readOnly = "";
		if (this.readOnly != null && this.readOnly.equals("true")) readOnly += "readOnly";

		dateString += "<input type='text' name='" + this.getProperty() + "' id='" + this.id + "'  " + value + " " + onClickStr + " " + onChangeString
				+ " " + size + " " + readOnly + "> " + "	<img src='/INVMGM/hisglobal/images/imgDatepicker.png' name='" + getProperty() + "100' id='"
				+ ( (this.getIdIconPicDate()!=null)?this.getIdIconPicDate():(getProperty()+"100")) + "'style='cursor: pointer; border: 1px solid;position: absolute;'  " + "	title='Date selector' "
				+ "	onmouseover='this.style.background=\"#FF0000\";'  " + "	 onmouseout='this.style.background=\"#FFFFFF\";'> "
				+ "	<script language='JavaScript'> " + "Calendar.setup" + "(" + " {" + " inputField     :    '" + this.id + "'," +

				" ifFormat       :   '" + getDateFormate() + "'," + " button         :   '" +( (this.getIdIconPicDate()!=null)?this.getIdIconPicDate():(getProperty()+"100"))+ "'," + " singleClick    :    true" +

				" }" + ");	</script>";
		reset();
		return dateString;
	}

	public String getSize()
	{
		return size;
	}

	public void setSize(String size)
	{
		this.size = size;
	}
	
	public void reset()
	{
		 beanName=null;
		 property=null;
		 readOnly=null;
		 onChange=null;
		 onClick=null;
		 dateFormate=null;
		 id=null;
		 size="14";
		 idIconPicDate=null;
	}

}
