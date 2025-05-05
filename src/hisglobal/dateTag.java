
package hisglobal;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;



public class dateTag extends TagSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name="";
	private String jsFunc="";
	private String value="";
	private String dateFormate="";
	private String id ="";	// attribute added by rahul on 15th oct,07 to make datepicker compatible with multirow.
	private String readOnly = "false";
	private String keyMapping="32";

	

	/**
	 * @return the keyMapping
	 */
	public String getKeyMapping() {
		return keyMapping;
	}

	/**
	 * @param keyMapping the keyMapping to set
	 */
	public void setKeyMapping(String keyMapping) {
		this.keyMapping = keyMapping;
	}

	/**
	 * @return Returns the readOnly.
	 */
	public String getReadOnly() {
		return readOnly;
	}	

	/**
	 * @return Returns the id.
	 */
	public String getId() {
		return id;
	}	

	public java.lang.String getDateFormate()
	{
		return dateFormate;
	}

	public void setDateFormate( java.lang.String dateFormate )
	{
		this.dateFormate = dateFormate;
	}


	public java.lang.String getValue()
	{
		return value;
	}

	/**
	 * @param id The id to set.
	 */
	public void setId(String id) {
		
		this.id = id;
	}
	
	public void setValue( java.lang.String value )
	{
		this.value = value;
	}
	
	public java.lang.String getName( )
	{
		return name;
	}

	public void setName( java.lang.String name )
	{
		
		this.name = name;
	}
	public java.lang.String getJsFunc( )
  {
    return jsFunc;
  }

  public void setJsFunc( java.lang.String jsFunc )
  {
    
    this.jsFunc = jsFunc;
  }


	/**
	 * @param readOnly The readOnly to set.
	 */
	public void setReadOnly(String readOnly) {
		this.readOnly = readOnly;
	}
	
	public int doStartTag() throws JspTagException
		{
		
			return EVAL_BODY_INCLUDE;
		}

	public int doEndTag() throws JspTagException
		{
			//String dateString=new Date().toString();
			if(dateFormate.equals("")||dateFormate==null)
				dateFormate= "%d-%b-%Y";
			if(value.equals("")||value==null)
				value="";
			if(this.getId().equals("")){
				this.setId(this.getName());
			}
			try{					
					//pageContext.getOut().write("Hello World<br>"+getName()+"<br>");
					pageContext.getOut().write("<input size='9%' class='txtFldDate' type=\"text\" name=\""+getName()+"\" id=\""+getId()+"\" readonly=\""+getReadOnly()+"\" value='"+getValue()+"' onChange='"+getJsFunc()+"'> "+
					"	<img tabindex=1 src=\"../../hisglobal/images/imgDatepicker.png\" id=\""+getId()+"1\" style=\"cursor: pointer; border: 1px solid red;\"  "+
					"	title=\"Date selector\"  "+
					"	onmouseover=\"this.style.background='red';\"  "+
					"	onmouseout=\"this.style.background=''\"> " + 
					"	<script language=\"JavaScript\" > "+
					"Calendar.setup"+
					"("+
					" {"+
					" inputField     :    \""+getId()+"\","+
					"eventName : \"click\","+
					" ifFormat       :    \""+getDateFormate()+"\","+
					" button         :    \""+getId()+"1\","+
					" singleClick    :    true"+
					" }"+
					");"+
					"Calendar.setup"+
					"("+
					" {"+
					" inputField     :    \""+getId()+"\","+
					"eventName : \"keypress\",mapKey : \""+getKeyMapping()+"\","+
					" ifFormat       :    \""+getDateFormate()+"\","+
					" button         :    \""+getId()+"1\","+
					" singleClick    :    true"+
					" }"+
					");</script>");
					
					this.setId("");
					
				}catch(Exception ex)
				{
					throw new JspTagException("Fatal error:helloTag could not write to JspOut");
				}
				
		return EVAL_PAGE;
		}

}
