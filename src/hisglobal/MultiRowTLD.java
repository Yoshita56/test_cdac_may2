/*
 * MultiRow TLD made by Deepak Tiwari
 */

package hisglobal;

import hisglobal.exceptions.HisException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class MultiRowTLD implements Tag 
{
	PageContext pageContext;
	private String rowVisible = "0";
	private String header = "";
	private String row = "";
	private String multiRowId = "1";
	private String mode = "";
	private String addRowEventHandler = "0";
		
	public String getAddRowEventHandler() {
		return addRowEventHandler;
	}

	public void setAddRowEventHandler(String addRowEventHandler) {
		this.addRowEventHandler = addRowEventHandler;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getRowVisible() {
		return rowVisible;
	}


	public void setRowVisible(String rowVisible) {
		this.rowVisible = rowVisible;
	}

	
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}
	
	public int doStartTag() throws JspException {
		JspWriter jw = null;
		String _temp[]=null;
		try {
				jw = pageContext.getOut();
				jw.print(this.header);
				//init MultiRow
				jw.print("<div id='multiRowUtilityTLDDivId#"+this.multiRowId+"'>"+this.row+"</div>");
				jw.print("<script language='Javascript' type='text/javascript'>");
				jw.print("initMultiRow('multiRowUtilityTLDDivId#"+this.multiRowId+"','"+this.mode+"','"+this.rowVisible+"','"+this.multiRowId+"','"+this.addRowEventHandler+"')");
				jw.print("</script>");
				for(int i=0;i<Integer.parseInt(this.rowVisible);i++)
				{
					jw.print("<script language='Javascript' type='text/javascript'>");
					jw.print("add(0,'"+this.multiRowId+"');");
					jw.print("</script>");
					
				}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			new HisException("IPD Transaction","Multi Row Tag.doStartTag() -->",e.getMessage());
		}
		finally {
			
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


	public String getHeader() {
		return header;
	}


	public void setHeader(String header) {
		this.header = header;
	}

	
	public String getMultiRowId() {
		return multiRowId;
	}

	public void setMultiRowId(String multiRowId) {
		this.multiRowId = multiRowId;
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

   
 }
