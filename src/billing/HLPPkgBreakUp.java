package billing;

import javax.sql.rowset.WebRowSet;

public class HLPPkgBreakUp 
{
    public static String getPkgBreakUp(WebRowSet ws ,String id1) 
	{
	 	StringBuffer sb = new StringBuffer("");
	  	String strIsRefund = null;
	  	String strIsAdvance = null;
	  	String strCost = null;
	  	String strUnitName = null;
	  //	int rowSize = 0;
	  	    	
	try
	{   
		if(!id1.equals("")) 
		{
	  	 String[] id2 = id1.split("\\^");
	  	 	  	 
	  	 
	  	 if(id2[3].equals("0"))
		  {
			strIsAdvance = "No";
		  }
		if(id2[3].equals("/"))
		 {
			strIsAdvance = "--";
		 }
		else
		 {
			strIsAdvance = "Yes";
		 }
		if(id2[4].equals("0"))
		 {
			strIsRefund = "No";
		 }
		if(id2[4].equals("/"))
		 {
			strIsRefund = "--";
		 }
		else
		 {
			strIsRefund = "Yes";
		 }
		if(id2[1].equals("0")||id2[1].equals("/"))
		 {
			strCost = "--";
		 }
		else
		 {
			strCost = id2[1];
		 }
		if(id2[2].equals("0")||id2[2].equals("/"))
		 {
			strUnitName = "--";
		 }
		else
		 {
			strUnitName = id2[2];
		 }
				
		sb.append("<table class='TABLEWIDTH' align='center'>");
	  	sb.append("<tr class='HEADER'><td colspan='6'>Charge Details</td></tr>");
	  	sb.append("<tr><td width='16.5%' class='multiLabel'>Rate/Unit</td>");
	  	sb.append("<td width='16.5%' class='multiControl'>"); 
	  	sb.append(strCost+"/"+strUnitName);
	  	sb.append("</td>");
	  	sb.append("<td width='16.5%' class='multiLabel'>Refundable</td>");
	  	sb.append("<td width='16.5%' class='multiControl'>");
	  	sb.append(strIsRefund);
	  	sb.append("</td>");
	  	sb.append("<td width='16.5%' class='multiLabel'>Advance Taken</td>");
	  	sb.append("<td width='16.5%' class='multiControl'>");
	  	sb.append(strIsAdvance);
	 	sb.append("</td></tr></table>");
	 	
 		//	  rowSize = ws.size();
 			  sb.append("<table class='TABLEWIDTH' align='center'>");
			  sb.append("<tr class='HEADER'><td colspan='8'>Package Breakup</td></tr>");
			  sb.append("<tr><td width='12.5%' class='multiLabel'>TariffName</td>");
			  sb.append("<td width='12%' class='multiLabel'>Qty</td>");
			  sb.append("<td width='12.5%' class='multiLabel'>Rate/Unit</td>");
			  sb.append("<td width='12.5%' class='multiLabel'>Is-Refundable</td></tr>");
			  sb.append("</table>");
	  if (ws != null)	  
	  {		  
 			for(int i=0;ws.next();i++)
            {
	    	        String[] id = ws.getString(6).split("\\^");
    	            String strTariffname  = ws.getString(2);
					String strQty = ws.getString(3);
					String strRateUnit   = ws.getString(4);
					String strIsRefundable     = ws.getString(5);

					if(strTariffname == null) strTariffname = "---";
					if(strQty == null) strQty = "---";
					if(strRateUnit == null) strRateUnit = "---";
					if(strIsRefundable == null) strIsRefundable = "---";
					if(id[7].equals("0"))
						strIsRefundable = "No";
					else
						strIsRefundable = "Yes";
				    
			     	  sb.append("<table class='TABLEWIDTH' align='center'>");
					  sb.append("<tr><td width='12.5%' class='multiControl'>"); 
							  sb.append(ws.getString(2));
							  sb.append("</td>");
					  sb.append("<td width='12%' class='multiControl'>");
					          sb.append(id[8]+" "+ws.getString(5));
					          sb.append("</td>");
					  sb.append("<td width='12.5%' class='multiControl'>"); 
					          sb.append(id[6]+"/"+ws.getString(3));
					          sb.append("</td>");
					  sb.append("<td width='12.5%' class='multiControl'>");  
					          sb.append(strIsRefundable);
					          sb.append("</td>");
					  sb.append("</tr></table>");
					
		     }
	      }	
 		}
		else
		 {
			   sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
			   sb.append("<tr>");
			   sb.append("<td colspan='4'  CLASS='multiControl' >"
					+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED RECORD </div>" + "</TD>");
			   sb.append("</tr>");
			   sb.append("</table></div>");	
         }  
	   }
	  catch(Exception e)
	  {
		       
	  }
	
    return sb.toString();
	}
 }
