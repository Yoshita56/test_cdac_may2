package hisglobal;

import java.util.ResourceBundle;

import hisglobal.exceptions.HisException;
import hisglobal.hisconfig.Config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
//import java.util.Calendar;
//import java.text.SimpleDateFormat;
import hisglobal.utility.HisUtil;

public class CrNo extends TagSupport
{

	PageContext pageContext;

	private String name = "strCrNo";
	private String id = "strCrNo";
	private String value = "";
	private String js = "";
	private String className = "form-control";//txtCrNoFormat
	private String ac = "";
	/*SimpleDateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
	String formattedDate = df.format(Calendar.getInstance().getTime());*/
	//int year = Calendar.getInstance().get(Calendar.YEAR);
	
	public String getAc() {
		return ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}
	
	private static ResourceBundle hisProp = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
	private String maxLen = hisProp.getString("CR_FORMAT");
	
	
	
	
	
	
	
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}

	public int doStartTag() throws JspException 
	{	
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		
		String hosCode=(String)request.getSession().getAttribute("HOSPITAL_CODE");		
		if(hosCode.length()==5)
			maxLen= hisProp.getString("CR_FORMAT_FIFTEEN");
		else
			maxLen= hisProp.getString("CR_FORMAT_THIRTEEN");
		
        String strDefaultValue = "";
			
			try {
				this.setValue("");
				strDefaultValue = pageContext.getSession().getAttribute("HOSPITAL_CODE").toString()+"" + new HisUtil("Global", "hisglobal.CRNo.doStartTag()").getDSDate("YY");
			
				if(this.getValue() != null && this.getValue().length() == 0){
					
					this.setValue(strDefaultValue);
					
				}
				
			
			} catch (Exception e) {
				 
			}
			
			JspWriter jw = pageContext.getOut();
		
		try 
		{
			jw.write("<input type='text' align='middle' name='");
			jw.write(this.getName());
			jw.write("' ");
			jw.write("id='");
			jw.write(this.getId());
			jw.write("' ");
			jw.write("autocomplete='");
			jw.write(this.getAc());
			jw.write("' ");
			jw.write("value='");
			jw.write(this.getValue());
			jw.write("' ");
			jw.write("class='");
			if(this.getClassName().equals(""))
				jw.write("txtCrNoFormat");
			else
				jw.write(this.getClassName());
			jw.write("' ");
			jw.write("maxlength='");
			jw.write(this.getMaxLen());
			jw.write("' ");
			jw.write(this.getJs());
			jw.write(">");
			
		} 
		catch (Exception e) 
		{
			new HisException("Global Tag Lib","CrNo.doStartTag()","-->"+e.getMessage());
		}			
		return EVAL_BODY_INCLUDE;
	}
	public Tag getParent() 
	{
		return null;
	}
	public void release() 
	{
	}
	public void setPageContext(PageContext pageContext) 
	{
		this.pageContext = pageContext;
	}
	public void setParent(Tag tag) 
	{
	}
	public String getId() 
	{
		return id;
	}
	public void setId(String id) 
	{
		this.id = id;
	}
	public String getJs() 
	{
		return js;
	}
	public void setJs(String js) 
	{
		this.js = js;
	}
	public String getName() 
	{
		return name;
	}
	public String getClassName() 
	{
		return className;
	}
	public void setClassName(String className) 
	{
		this.className = className;
	}
	public String getMaxLen() 
	{
		return maxLen;
	}
	public String getValue() 
	{
		return value;
	}
	public void setValue(String value) 
	{
		this.value = value;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
}