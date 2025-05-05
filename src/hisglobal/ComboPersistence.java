package hisglobal;

import hisglobal.exceptions.HisException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class ComboPersistence implements Tag {

	PageContext pageContext;

	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}

	public int doStartTag() throws JspException {

		JspWriter jw = pageContext.getOut();

		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();

		try {

			String p[] = request.getParameterValues("combo");
			if (p != null) {
				for (int i = 0; i < p.length; i++) {
					jw.write("<input type='hidden' name='combo' value='" + p[i]
							+ "'>	");
				}
			}

		} catch (Exception e) {

			new HisException("Global Tag Lib", "ComboPersistence.doStartTag()",
					"-->" + e.getMessage());
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
