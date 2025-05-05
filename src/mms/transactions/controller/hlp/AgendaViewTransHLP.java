package mms.transactions.controller.hlp;

import hisglobal.exceptions.HisException;

import javax.sql.rowset.WebRowSet;

public class AgendaViewTransHLP {
	
	
	public static String getIndentDetails(WebRowSet wb)
	 {
		StringBuffer sBuffer = new StringBuffer("");
		 try {
			if(wb != null && wb.size() > 0)
			{ 
				int i=0;
				while(wb.next())
				{
		                  
	                	String strIndentName = wb.getString(1);
	  					String strIndentDate = wb.getString(2);
	  					String strRaisingStore = wb.getString(3);
	  					
	  					
	  					if(strIndentName == null || strIndentName.equals("null") || strIndentName.equals(""))strIndentName = "---";
	  					if(strIndentDate == null || strIndentDate.equals("null") || strIndentDate.equals("") )strIndentDate = "---";
	  					if(strRaisingStore == null || strRaisingStore.equals("null") || strRaisingStore.equals(""))strRaisingStore = "---";
	  					
	  					//sBuffer.append("<table class='TABLEWIDTH' align='center'  border='0' cellspacing ='1px' bgcolor='#6097BC'>"); 
	  					sBuffer.append("<tr>");
	  					sBuffer.append("<input type='hidden' name='strIndentDtl' id='strIndentDtl"+i+"' >");
						
	  					sBuffer.append("<td width='21%' class='multiControl'>"+strIndentName+"</td>");
	  					sBuffer.append("<td width='21%' class='multiControl'>"+strIndentDate+"</td>");
	  					sBuffer.append("<td width='21%' class='multiControl'>"+strRaisingStore+"</td>");
	  					
	  					
	  					sBuffer.append("</tr>");	
	  				}
                 //sBuffer.append("</table>");

                 i = i+1;
                 
	     }else {
			   // sBuffer.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
			    sBuffer.append("<tr>");
			    sBuffer.append("<td colspan='5'  CLASS='multiControl' >"
						+ "<div class='errMsg' align='center'> NO INDENT DETAILS FOUND FOR SELECTED STORE NAME </div>" + "</td>");

			    sBuffer.append("</tr>");
			  //  sBuffer.append("</table>");
		   } 
		 }
		 catch(Exception e){
			 
			throw new HisException("Agenda View Transaction","AgendaViewTransHLP.getIndentDetails()-->",e.getMessage());
	     }
	    return sBuffer.toString();
	 	}
	
	
	public static String getCompiledItemDetails(WebRowSet wb)
	 {
		StringBuffer sBuffer = new StringBuffer("");
		 try {
			int nTmpI=0;
			if(wb != null && wb.size() > 0)
			{ 
				while(wb.next()){
				//	sBuffer.append("<table class='TABLEWIDTH' align='center'  border='0' cellspacing ='1px' bgcolor='#6097BC'>");
					sBuffer.append("<tr>");
  					sBuffer.append("<td width='32%' class='multiControl'><a name='strItemName' id='strItemName' STYLE='CURSOR:POINTER;color:blue' onClick='display_popup_menu(this,\"itemDtlPopup"+nTmpI+"\",\"250\",\"\");'>" +wb.getString(1)+"</a>");
  					
  					sBuffer.append("<div class='popup' id='itemDtlPopup");
  					sBuffer.append(nTmpI);
  					sBuffer.append("' style='display:none'>");
  					sBuffer.append("<table width='400' border='0' cellspacing ='1' cellpadding='1'>");
  					sBuffer.append("<tr class='HEADER'>");
  					sBuffer.append("<th align='left'>"+wb.getString(1)+"::::Details</th>");
  					sBuffer.append("<th align='right'><img  style='cursor:pointer;cursor:pointer' title='To Close PopUp' src='../../hisglobal/images/popUp_cancel.JPG'");
  					sBuffer.append("onClick='hide_popup_menu(\"");
  					sBuffer.append("itemDtlPopup"+nTmpI);
  					sBuffer.append("\");'></th>");
  					sBuffer.append("</tr>");
  					sBuffer.append("</table>");
  					sBuffer.append("<table width='400' border='0' cellspacing ='1' cellpadding='1' bgcolor='#6097BC'>");
  					sBuffer.append("<tr>");
  					sBuffer.append("<td width='25%' class='LABEL'>Last Order No.");
  					sBuffer.append("</td><td width='25%' class='CONTROL'>");
  					sBuffer.append(wb.getString(6));
  					sBuffer.append("</td><td width='25%' class='LABEL'>Last Order Date");
  					sBuffer.append("</td><td width='25%' class='CONTROL'>");
  					sBuffer.append(wb.getString(7));
  					sBuffer.append("</td></tr>");
  					sBuffer.append("<tr>");
  					sBuffer.append("<td width='25%' class='LABEL'>Last Received Qty");
  					sBuffer.append("</td><td width='25%' class='CONTROL'>");
  					sBuffer.append(wb.getString(8));
  					sBuffer.append("</td><td width='25%' class='LABEL'>Last Received Date");
  					sBuffer.append("</td><td width='25%' class='CONTROL'>");
  					sBuffer.append(wb.getString(9));
  					sBuffer.append("</td></tr>");
  					sBuffer.append("<tr>");
  					sBuffer.append("<td width='25%' class='LABEL'>Last Purchase Rate/Unit");
  					sBuffer.append("</td><td width='25%' class='CONTROL'>");
  					sBuffer.append(wb.getString(10));
  					sBuffer.append("</td><td width='25%' class='LABEL'>Last Supplied By");
  					sBuffer.append("</td><td width='25%' class='CONTROL'>");
  					sBuffer.append(wb.getString(11));
  					sBuffer.append("</td></tr>");
  					sBuffer.append("</table>");			
  					sBuffer.append("</div>");
   					
  					
					sBuffer.append("</td>");
  					
  					sBuffer.append("<td width='13%' class='multiControl'>"+wb.getString(2)+"</td>");
  					sBuffer.append("<td width='13%' class='multiControl'>"+wb.getString(3)+"</td>");
  					sBuffer.append("<td width='13%' class='multiControl'>"+wb.getString(4)+"</td>");
  					sBuffer.append("<td width='13%' class='multiControl'>"+wb.getString(5)+"</td>");
  					sBuffer.append("</tr>");	
  					nTmpI++;
  				}
				sBuffer.append("<tr>");
				sBuffer.append("<td colspan='6' class='TITLE'></td>");
				sBuffer.append("</tr>");
              //  sBuffer.append("</table>");
			 
				}
			 
		   
		 else {
			   // sBuffer.append("<table class='TABLEWIDTH' align='center'  border='0' cellspacing ='1px'>"); 
			    sBuffer.append("<tr>");
			    sBuffer.append("<td colspan='5'  CLASS='multiControl' >"
						+ "<div class='errMsg' align='center'> NO COMPILED ITEM DETAILS FOUND FOR SELECTED STORE NAME </div>" + "</td>");

			    sBuffer.append("</tr>");
			  //  sBuffer.append("</table>");
		   } 
		 }
		
		 catch(Exception e)
		 {
			throw new HisException("Agenda  View Transaction","AgendaViewTransHLP.getCompiledItemDetails()-->",e.getMessage());
	     }
	    return sBuffer.toString();
	 	}
}
