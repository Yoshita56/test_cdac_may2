package hisglobal;

import hisglobal.exceptions.HisException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;


/**
 * 
 * @author deps
 *
 */
public class HisMessage implements Tag {

	PageContext pageContext;

	
	private String type = null;
	private String message = null;
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}
/**
 * 
 */
	public int doStartTag() throws JspException {

	
		JspWriter jw = pageContext.getOut();
		
			
		try {
			
			if(this.getType().equals("0")){
				
				jw.write("<div class='normalMsg'>");
				jw.write(this.getMessage());
				jw.write("</div>");
			}else if(this.getType().equals("1")){
				
				jw.write("<div class='errMsg'>");
				jw.write(this.getMessage());
				jw.write("</div>");
			}else if(this.getType().equals("2")){
	
				jw.write("<div class='warningMsg'>");
				jw.write(this.getMessage());
				jw.write("</div>");
		}/*else{
			
			
			HttpServletRequest hsr = (HttpServletRequest)pageContext.getRequest();
			
			if(hsr.getSession().getAttribute("error") != null){
			String str = (String)hsr.getSession().getAttribute("error");
			
			jw.write("<div class='errMsg'>");
			jw.write(str);
			jw.write("</div>");
			}else{
				
				System.out.println(" No Error Attribute");
				
			}
			
		}*/

		} catch (Exception e) {
			
			new HisException("Global Tag Lib","Message.doStartTag()","-->"+e.getMessage());
		}
			
		return EVAL_BODY_INCLUDE;
	}

	public Tag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	public void release() {
		// TODO Auto-generated method stub

	}

	public void setPageContext(PageContext pageContext) {

		this.pageContext = pageContext;

	}

	public void setParent(Tag tag) {
		// TODO Auto-generated method stub

	}

	
	

}
