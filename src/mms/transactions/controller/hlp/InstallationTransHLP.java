package mms.transactions.controller.hlp;

import hisglobal.exceptions.HisException;

import javax.sql.rowset.WebRowSet;

public class InstallationTransHLP {
	
	public static String getInstallationDetails(WebRowSet ws, String strStartDate , String strEndDate) 
	 {
		StringBuffer sb = new StringBuffer("");
		int start = 1;
		final int REC_PER_PAGE = 10;
		final int PAGE_PER_BLOCK = 10;
		
	
		
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		
	    try
	    {
	 
	    	
	    	String[] strStartYr = strStartDate.replace('-','@').split("@");
	    	String[] strEndYr = strEndDate.replace('-','@').split("@");
	    	
		if (ws != null) 
		{
			if(ws.size() != 0)
			{
			 int actualFetchRecord = ws.size();
		
	         if(totalFetchRecord != actualFetchRecord)
			 {
				totalFetchRecord = actualFetchRecord;
				totalRecordsToManipulate = actualFetchRecord;
			 }
			 int totalLayer = totalRecordsToManipulate / REC_PER_PAGE;
			 int reminder = totalRecordsToManipulate % REC_PER_PAGE;
			 if (reminder > 0)
				totalLayer = totalLayer + 1;
			 
			 sb.append("<input type='hidden' name='TotalLayer'  value='"+totalLayer+"'>");
			 sb.append("<input type='hidden' name='RecordShowOnPage'  value='"+REC_PER_PAGE+"'>");
			 sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			 sb.append("<tr>");
			 sb.append("<td class='TITLE' >Quality Details For Financial Year : "+strStartYr[2]+"-"+strEndYr[2]);
			 sb.append("</td></tr>");
			 sb.append("<tr>");
			 sb.append("<td class='LABEL' >");

			 for (int i = 1; i <= totalLayer; i++)
			 {
				sb.append("<a STYLE='cursor:pointer;cursor:pointer;' color:'blue' onClick='GetIndex(\""+i+"\",\""+totalLayer+"\")'>" + (i+start-1)
						+ "</a> &nbsp;");
			 }
			sb.append("</td>");
			sb.append("</tr>");
			sb.append("</table>");
			sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
	        sb.append("<tr>");
	        sb.append("<td width='18%'class='multiLabel'>Item Name");
	        sb.append("</td>");
	        sb.append("<td width='18%'class='multiLabel'>Batch/Sl No");
	        sb.append("</td>");
	        sb.append("<td width='10%'class='multiLabel'>Date");
		    sb.append("</td>");
	        sb.append("<td width='18%'class='multiLabel'>InHand Qty wth Unit");
	        sb.append("</td>");
	        sb.append("<td width='18%'class='multiLabel'>Item Status");
		    sb.append("</td>");
		    sb.append("<td width='18%'class='multiLabel'>Remarks");
		    sb.append("</td>");
	        sb.append("</tr>");
	        sb.append("</table>");
	        
		    for (int i = 1; i <= totalLayer; i++) 
		    {
			 if (i <= totalLayer) 
			 {
				 
				if (i == 1) 
				{
					sb.append("<div id='DivId" +i+ "' style='display:block'>");
				} 
				else
				{
					sb.append("<div id='DivId" +i+ "' style='display:none'>");
				}
				
				sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				for (int j = 0; j < REC_PER_PAGE; j++) 
				{
					if(ws.next()){
					sb.append("<tr>");
					sb.append("<td class='multiControl' width='18%'>");
					sb.append(ws.getString(2));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='18%'>");
					sb.append(ws.getString(3));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='10%'>");
					sb.append(ws.getString(1));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='18%'>");
					sb.append(ws.getString(4));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='18%'>");
					sb.append(ws.getString(5));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='18%'>");
					sb.append(ws.getString(6));
					sb.append("</td>");
					sb.append("</tr>");
					}else{
						break;
					}
				}
				sb.append("</table>");
				sb.append("</div>");

			} 
			else 
			{
				sb.append("<div id='DivId" + i+ "' style='display:none'>");
				
				sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				for (int k = 0; k < reminder; k++) 
				{
					ws.next();
					sb.append("<tr>");
					sb.append("<td class='multiControl' width='18%'>");
					sb.append(ws.getString(2));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='18%'>");
					sb.append(ws.getString(3));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='10%'>");
					sb.append(ws.getString(1));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='18%'>");
					sb.append(ws.getString(4));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='18%'>");
					sb.append(ws.getString(5));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='18%'>");
					sb.append(ws.getString(6));
					sb.append("</td>");
					sb.append("</tr>");
				}
				sb.append("</table>");
				sb.append("</div>");
				}
		   	}
		sb.append("</td>");
		sb.append("</tr>");
		sb.append("</table>");
		}else{
			sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='black' cellpadding='1px'");
			 sb.append("<tr>");
			 sb.append("<td class='TITLE' >Quality Details For Financial Year : "+strStartYr[2]+"-"+strEndYr[2]);
			 sb.append("</td></tr>");
			sb.append("<tr");
			sb.append("<td class='multiControl'<font color='red'>No Record Found</font></td>");
			sb.append("</tr>");
			sb.append("</table>");
		    }
	   }
	   

	 }
	 catch(Exception e)
	 {
		    e.printStackTrace();
		    new HisException("Quality Check Control Transaction","QualityCheckControlTransHLP.getQualityDetails()--",e.getMessage());
	    }
	     
	    return sb.toString();
	 	}



}
