// This file was added by Deepak on 12-May-08
package hisglobal;
import hisglobal.exceptions.HisException;

import javax.sql.rowset.WebRowSet;
public class PopUp{
public static String getPopupHeader(String title,String divName){
		StringBuffer header = new StringBuffer("");
		header.append("<table width='450'  border='solid 1px black' cellpadding='0' cellspacing='0' bgcolor='white'>");
		header.append("<tr class='TITLE' >");
		header.append("<td align='left'  width='97%'>");
		header.append(title);
		header.append("</th>");
		header.append("<td align='center' width='3%'><div id='popCls'><a href='javascript:styledPopupClose();'><img height='18' width='19' src='../../hisglobal/images/popUp_cancel.JPG' border='0'></a></div></td></TR>");
		header.append("<tr>");
		header.append("<td colspan='2' style='width: 380px;'>");
		return header.toString();
	}
	
	public static String getPopupBody(int row,int col,String Caption,String IndexWebRS,WebRowSet ws)
	{
	    StringBuffer body = new StringBuffer("");
		String strTemp[]=Caption.replace('^','#').split("#");
		String Index[]=IndexWebRS.replace('^','#').split("#");
		try{
		    body.append("<table width='450'>");
		    // <CAPTION>
			     body.append("<tr>");
			     for(int c=0;c<=col-1;c++)
			     {
			      body.append("<td class='multiLabel'>"+strTemp[c]+"</td>");
			     }
			     body.append("</tr>");
			//</CAPTION>
			
			//<RECORDS>
			    if(ws != null && ws.size()!= 0)
			    {
			     while(ws.next())
			     {
		    	  body.append("<tr>");
			       for(int c=0;c<=col-1;c++)
			       {	   
			        body.append("<td class='multiControl'>");
			        body.append(ws.getString(Integer.parseInt(Index[c])));
		   	        body.append("</td>");
			        }
			       body.append("</tr>");	
			     }
		       }
		       else
		       {
			       body.append("<tr>");
			       body.append("<td colspan='7' class='multiControl'>");
			       body.append("<font color='red'>No Details For the Current Record</font>");
			       body.append("</td>");
			       body.append("</tr>");	
		       }
		    //</RECORDS>
		    body.append("</table>");
		    
		 }catch(Exception e)
		  {
			new HisException("Discount Approval Trans","PopUp.getPopupBody()-->",e.getMessage());
		  }
		return body.toString();
	}
	
	public static String getPopupFooter(){
		String footer = new String("</td></tr></table>");
		return footer;
	}
	
	/////////////////////////
public static String getPopupBody_Simple(int row,int col,String Caption,String ws){
		
		StringBuffer body = new StringBuffer("");
		String strTemp[]=Caption.replace('^','#').split("#");
		String val[]=ws.replace('^', '#').split("#");
		try{
		    body.append("<table width='450'>");
		    // <CAPTION>
			     body.append("<tr>");
			     for(int c=0;c<=col-1;c++)
			     {
			      body.append("<td class='multiLabel'>"+strTemp[c]+"</td>");
			     }
			     body.append("</tr>");
			//</CAPTION>
			
			//<RECORDS>
			    if(ws != null)
			    {
			     
			       body.append("<tr>");
			       for(int c=0;c<=col-1;c++)
			       {	   
			        body.append("<td class='multiControl'>");
			        
			        body.append(val[c]);
		   	        body.append("</td>");
			        }
			       body.append("</tr>");	
			     }
		       
		       else
		       {
			       body.append("<tr>");
			       body.append("<td colspan='7' class='multiControl'>");
			       body.append("<font color='red'>No Details For the Current Record</font>");
			       body.append("</td>");
			       body.append("</tr>");	
		       }
		    //</RECORDS>
		    body.append("</table>");
		    
		 }catch(Exception e)
		  {
			
			new HisException("Discount Approval Trans","PopUp.getPopupBody()-->",e.getMessage());
		  }
		
		return body.toString();
		
	}
	////////////////////
}	