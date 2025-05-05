package billing;

import hisglobal.exceptions.HisException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.sql.rowset.WebRowSet;

public class TLDTrfMultirow extends BodyTagSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	WebRowSet wb = null;	
	HttpServletRequest noOfRows = null; 	 
	String grpId;
	String grpName;
	String utilityType = "";
	
	public String showGroupTariffData()
	{
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("<table width='90%' border='1'><tr class='HEADER'><td colspan='2'>&nbsp;</td></tr>"); 
		strBuffer.append("<tr><td colspan='2' class='tdfonthead'>AAA &nbsp;");  		    		  
		strBuffer.append("<img src='../hisglobal/images/plus.gif' width='10' height='10' onClick=\"addRows(new Array('group','tariff'),new Array('s','s'),'1','1','R');\">");
		strBuffer.append("</td></tr></table>");    
		strBuffer.append("<div id='id1'></div>");       
		strBuffer.append("<table width='90%' border='1'><tr><td colspan='2' class='blueHeader'>&nbsp;</td></tr></table>");		  		  

		return strBuffer.toString();
	}

	public String showData()
	{
		StringBuffer strBuffer = new StringBuffer();
		HLPbilling hlpbilling = new HLPbilling();
		int rowSize = 0;
		
		try{
			wb =  hlpbilling.getRows();
			rowSize = wb.size();
			this.noOfRows.setAttribute("ROW_SIZE",rowSize);
			for(int i=0,idx = 1; i<rowSize; i++,idx++){ 
				if(wb.next())
				{	
					grpId = wb.getString(1);				
					grpName = wb.getString(2);
				}				
				 strBuffer.append("<table width='90%' border='1'><tr>");
				 strBuffer.append("<td colspan='2' class='blueHeader'>&nbsp;</td></tr>");
				 strBuffer.append("<tr><td colspan='2' class='tdfonthead'>");
				 strBuffer.append("<input type='checkbox' name='checkbox" + idx + "' id ='checkbox" +idx+"' onClick=\"getQryValue('"+grpId+"','"+idx+"',this)\">");
				 strBuffer.append(grpName+" &nbsp; <img src='../hisglobal/images/plus.gif' width='10' height='10' onClick=\"insert_row('"+idx+"')\"></td></tr>");
				 strBuffer.append("<tr><td colspan='2'><div id='id"+idx+"'></div></td></tr></table>");
			}
		}
		catch(Exception e)
		{
			new HisException("billing","TLDTrfMultirow.showData()",e.getMessage());
		}		
		return strBuffer.toString();
	}				 		   	  	   	    	      	  

	public void setPageContext(PageContext p)
	{
		pageContext = p;
	}
	
	public int doStartTag()
	{
		String utlType = "";
		try
		{
			utlType = getUtilityType();
			JspWriter out = pageContext.getOut();
			if(utlType.equals("1"))
			{
				out.println(showData());
			}
			else
			{
				out.println(showGroupTariffData());
			}
		}
		catch(Exception e)
		{
			new HisException("billing","TLDTrfMultirow.doStartTag()",e.getMessage());
		}
		return EVAL_BODY_INCLUDE;
	}

//	---------- getter methods ----------------//	
	
	/**
	 * @return Returns the noOfRows.
	 */
	public HttpServletRequest getNoOfRows() {
		return noOfRows;
	}

	/**
	 * @return Returns the utilityType.
	 */
	public String getUtilityType() {
		return utilityType;
	}

//---------- setter methods ----------------//	
	
	/**
	 * @param utilityType The utilityType to set.
	 */
	public void setUtilityType(String utilityType) {
		this.utilityType = utilityType;
	}

	/**
	 * @param noOfRows The noOfRows to set.
	 */
	public void setNoOfRows(HttpServletRequest noOfRows) {
		this.noOfRows = noOfRows;
	}
}
