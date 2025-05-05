package mms.transactions.controller.hlp;

import hisglobal.exceptions.HisException;

import javax.sql.rowset.WebRowSet;

public class ReminderDetailsTransHLP {
	
	
	public static String getPODetails(WebRowSet wb)
	 {
		StringBuffer sBuffer = new StringBuffer("");
		 try {
			if(wb != null && wb.size() > 0)
			{ 
				while(wb.next())
				{
						String strPODate = wb.getString(1);
	  					String strSuppName = wb.getString(2);
	  					String strPOType = wb.getString(3);
	  					
	  					String strItemCatName = wb.getString(12);
	  						  					
	  					if(strPODate == null || strPODate.equals("null") || strPODate.equals(""))strPODate = "---";
	  					if(strSuppName == null || strSuppName.equals("null") || strSuppName.equals("") )strSuppName = "---";
	  					if(strPOType == null || strPOType.equals("null") || strPOType.equals(""))strPOType = "---";
	  					
	  					sBuffer.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px'>");
	  					sBuffer.append("<tr><td colspan='4' class='TITLE'><div id='' style='color:blue;'>PO Details</div></td></tr>"); 
	  					sBuffer.append("<tr>");
	  					sBuffer.append("<td width='25%' class='LABEL'>PO Date</td>");  
	  					sBuffer.append("<input type='hidden' name='strPODate' value='"+strPODate+"'>");
	  					sBuffer.append("<td width='25%' class='CONTROL'>"+strPODate+"</td>");
	  					sBuffer.append("<td width='25%' class='LABEL'>Supplier Name</td>");
	  					sBuffer.append("<td width='25%' class='CONTROL'>"+strSuppName+"</td></tr>");
	  					
	  					sBuffer.append("<tr>");
	  					sBuffer.append("<td width='25%' class='LABEL'>PO Type</td>");
	  					sBuffer.append("<td width='25%' class='CONTROL'>"+strPOType+"</td>");
	  					sBuffer.append("<td width='25%' class='LABEL'>Category Name</td>");
	  					sBuffer.append("<td width='25%' class='CONTROL'>"+strItemCatName+"</td></tr>");
	  					
	  					
	  					sBuffer.append("<input type='hidden' name='strSuppId' value='"+wb.getString(7)+"'>");
	  					sBuffer.append("<input type='hidden' name='strItemCatId' value='"+wb.getString(11)+"'>");
	  					//sBuffer.append("<tr><td colspan='4' bgcolor='black'></td></tr>");
				}
                sBuffer.append("</table>");
             
                
	     }else {
			    sBuffer.append("<table class='TABLEWIDTH' align='center'  border='0' cellspacing ='1px'>"); 
			    sBuffer.append("<tr>");
			    sBuffer.append("<td CLASS='CONTROL' >"
						+ "<div class='errMsg' align='center'> NO RECEIPT DETAILS FOUND FOR SELECTED PO NO. </div>" + "</td>");

			    sBuffer.append("</tr>");
			    sBuffer.append("</table>");
		   } 
		 }
		 catch(Exception e)
		 {
			throw new HisException("Reminder Details Transaction","AdvanceRequestTransHLP.getPODetails()-->",e.getMessage());
	     }
	    return sBuffer.toString();
	 	}
	
	
	public static String getPrevReminderDtl(WebRowSet wb)
	 {
		StringBuffer sBuffer = new StringBuffer("");
		 try {
			 
			 
			 if(wb != null && wb.size() > 0)
				{
					sBuffer.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center' cellspacing='1px'>");
					sBuffer.append("<tr><td width='34%' class='multiLabel'>Reminder No</td>"); 
					sBuffer.append("<td width='33%' class='multiLabel'>Reminder Date</td>"); 
					sBuffer.append("<td width='33%' class='multiLabel'>Reminder Type</td></tr>"); 
					
					
					while (wb.next())
					{
						
						String strReminderNo = wb.getString(1);
						String strReminderDate = wb.getString(3);
						String strReminderType = wb.getString(2);
						
						if(strReminderNo == null || strReminderNo.equals("null"))strReminderNo = "";
						if(strReminderDate == null || strReminderDate.equals("null"))strReminderDate = "";
						if(strReminderType == null || strReminderType.equals("null"))strReminderType = "";
						 
						sBuffer.append("<tr>");
						sBuffer.append("<td width='34%' class='multiControl'>"+strReminderNo+"</td>");
						sBuffer.append("<td width='33%' class='multiControl'>"+strReminderDate+"</td>");
						sBuffer.append("<td width='33%' class='multiControl'>"+strReminderType+"</td>");
						sBuffer.append("</tr>");	
						
					}
					sBuffer.append("</table>");
					
				}else {
			    sBuffer.append("<table class='TABLEWIDTH' align='center'  border='0' cellspacing ='1px'>"); 
			    sBuffer.append("<tr>");
			    sBuffer.append("<td CLASS='multiControl' >"
						+ "<div class='errMsg' align='center'> NO PREVIOUS REMINDER DETAILS FOUND FOR SELECTED PO NO. </div>" + "</td>");

			    sBuffer.append("</tr>");
			    sBuffer.append("</table>");
		   } 
		 }
		 catch(Exception e)
		 {
			throw new HisException("Reminder Details Transaction","AdvanceRequestTransHLP.getPrevReminderDtl()-->",e.getMessage());
	     }
	    return sBuffer.toString();
	 	}

}
