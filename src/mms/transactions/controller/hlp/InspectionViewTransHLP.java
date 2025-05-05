/**
 * 
 */
package mms.transactions.controller.hlp;

import hisglobal.exceptions.HisException;

import javax.sql.rowset.WebRowSet;

/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * Date : 15/April/2009
 * 
 */
public class InspectionViewTransHLP {
	
	public static String getItemDetails(WebRowSet wb)
	 {
		StringBuffer sBuffer = new StringBuffer("");
			
		int i = 0;
		
		 try {
			 	 
			 //System.out.println("Size in HLP--->"+wb.size());
			 
			if(wb.size() != 0)
			{ 
				
				 sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");       
	             sBuffer.append("<tr><td width='14%' class='multiLabel'>Item Name</td>");  
	  	         sBuffer.append("<td width='14%' class='multiLabel'>Brand Name</td>");
	  	         sBuffer.append("<td width='14%' class='multiLabel'>Batch No/Sl No</td>");
	  	         sBuffer.append("<td width='14%' class='multiLabel'>Reciept Qty</td>");
	             sBuffer.append("<td width='14%' class='multiLabel'>Issue Qty</td>");
	             sBuffer.append("<td width='15%' class='multiLabel'>Return Qty</td>");
	             sBuffer.append("<td width='15%' class='multiLabel'>Status</td>");
	             sBuffer.append("</tr>");
				while(wb.next())
				{		     		
					String strHiddenId = wb.getString(1);//Item Id^Brand Id
					String itemName = wb.getString(2);
					String brandName = wb.getString(3);
					String batchSlNo = wb.getString(4);
					String receiptQty = wb.getString(5);
					String issuedQty = wb.getString(6);
					String ReturnQty = wb.getString(7);
					String status = wb.getString(8);
					
	                   				
	  					sBuffer.append("<tr>");
	  					sBuffer.append("<td width='18%' class='multiControl'>"+itemName+"</td>");
	  					sBuffer.append("<td width='18%' class='multiControl'>"+brandName+"</td>");
	  					sBuffer.append("<td width='17%' class='multiControl'>"+batchSlNo+"</td>");
	  					sBuffer.append("<td width='17%' class='multiControl'>"+receiptQty+"</td>");
	  					sBuffer.append("<td width='15%' class='multiControl'>"+issuedQty+"</td>");
	  					sBuffer.append("<td width='15%' class='multiControl'>"+ReturnQty+"</td>");
	  					sBuffer.append("<td width='15%' class='multiControl'>");
	  					sBuffer.append("<a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='showPopUp(this,"+ i +" );'>"+status+"</a></td>");
	  					sBuffer.append("<input type='hidden' name='strItemHidden' id='strItemHiddenID" +i+ "' " +
	  							"value="+strHiddenId+">");
	  					sBuffer.append("</tr>");	
	  				}
               sBuffer.append("</table>");
              
               
	     }
		 }
		 catch(Exception e)
		 {
			 new HisException("Inspection Desk Issue Transaction","InspectionDeskIssueTransHLP.getItemDetails()-->",e.getMessage());
	     }
	    return sBuffer.toString();
	 	}
	
	
	public static String getPopUpReport(WebRowSet wb)
	 {
		StringBuffer sBuffer = new StringBuffer("");
		int i = 0;
		
		 try {
			 	 
			// System.out.println("Size in HLP--->"+wb.size());
			 
			if(wb.size() != 0)
			{ 
				while(wb.next())
				{
					sBuffer.append("<table width='500' cellpadding='0' cellspacing='0'>");		
	  				sBuffer.append("<tr>");
	  				sBuffer.append("<td class='TITLE' align='left' colspan='2'>Inspection Report Details");
	  				sBuffer.append("<img src='../../hisglobal/images/popUp_cancel.JPG' title='To Cancel PopUp' align='right' onclick='hide_popup_menu(\"popup\");'/></td>");
	  				sBuffer.append("</tr></table>");
	  				sBuffer.append("<table width='500' align='left'>");

	  				sBuffer.append("<tr>");
	  				sBuffer.append("<td class='multiLabel' width='50%'>Inspection Report</td>");
	  				sBuffer.append("<td width='50%' class ='multiControl' id='strReportid1'"+i+">"+wb.getString(1)+
	  						"<input type='hidden' name='strReport' value='"+wb.getString(1)+"' /></td>");
	  				//sBuffer.append("<tr></tr>");
	  				sBuffer.append("</tr>");
	  				sBuffer.append("</table>");
	  				i++;
	  			}	
			}
		 }
		 catch(Exception e)
		 {
			 new HisException("Inspection View Transaction","InspectionViewTransHLP.getPopUpReport()-->",e.getMessage());
	     }
	    return sBuffer.toString();
	 	}

}
