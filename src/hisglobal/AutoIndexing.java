/**
 * 
 */
package hisglobal;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author Pankaj Kumar
 *
 */
public class AutoIndexing extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspTagException
	{
	
		return EVAL_BODY_INCLUDE;
	}
	
	public int doEndTag() throws JspTagException
	{
		try{
				pageContext.getOut().write("<script>\n" +
						"autoTabIndexing(); \n" +
						"</script><form><img src=\"/INVMGM/hisglobal/images/white_button.gif\" tabIndex=1 onfocus=\"autoTabIndexing()\"/></form>");
				
				this.setId("");
				
			}catch(Exception ex)
			{
				throw new JspTagException("Fatal error:helloTag could not write to JspOut");
			}
			
	return EVAL_PAGE;
	}
}
