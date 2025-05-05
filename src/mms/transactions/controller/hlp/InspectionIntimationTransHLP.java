/**
 * 
 */
package mms.transactions.controller.hlp;

import hisglobal.exceptions.HisException;

import javax.sql.rowset.WebRowSet;

/**
 * Developer : Anshul Jindal 
 * Version : 1.0 Date : 10/Apr/2009
 * 
 */
public class InspectionIntimationTransHLP {
	
	public static String getReceiptDetails(WebRowSet wb) 
	 {
		StringBuffer sb = null;
		 try 
		 {
			 sb = new StringBuffer("");
			if(wb!=null)
			{	
				wb.beforeFirst();
			//	for(int i=0;wb.next();i++)
				
				sb.append("<table class='TABLEWIDTH' align='center'>");
				sb.append("<tr><td class='TITLE' colspan='4'> Receipt No./Receipt Date</td></tr>");  
				sb.append("</table>");
				for(int i=0;i<4;i++)
               {
					
					//String strReceiptNo = wb.getString(1);
					//String strReceiptDate = wb.getString(2);
					String strReceiptNo = "111111111";
					String strReceiptDate = "13-Apr-2009";
					
					sb.append("<table class='TABLEWIDTH' align='center'>");
					sb.append("<tr>");  
					sb.append("<td width='5%' class='LABEL' align='center'><input type='hidden' name='button1' value='1'>");
					sb.append("<img src='../../hisglobal/images/plus.gif'  title='To Show Details' id='plus1"+i+"' style='display:block;' onClick='showPlusMinus(this,"+i+"),getItemDetails(this,"+i+");'>");
					sb.append("<img src='../../hisglobal/images/minus.gif' title='To Close Details' id='minus1"+i+"' style='display:none;' onClick='showPlusMinus(this,"+i+");'></td>");
					sb.append("<td colspan='3' class='CONTROL' align='left'>");
					sb.append("<b>"+strReceiptNo+"/"+strReceiptDate+"</b></td>");   
					sb.append("</tr>");
					sb.append("</table>");
					sb.append("<div id='itemDetailsdivid"+i+"' style='display:none'></div>");
				}	
				
			}
			
		 }
		 catch(Exception e)
		 {
			 new HisException("Inspection Intimation Transaction","InspectionIntimationTransHLP.getReceiptDetails()-->",e.getMessage());
	     }
	    return sb.toString();
	 	}
	
	public static String getReceiptItemDetails(WebRowSet wb, String strIndex)
	 {
		StringBuffer sb = new StringBuffer("");
		int i=0;
		 try {
			if(wb.size() != 0)
			{ 
				wb.beforeFirst();
				 sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");       
	             sb.append("<tr><td width='4%' class='multiLabel'></td>" );
	             sb.append(		"<td width='20%' class='multiLabel'><div align='center'>Item Name</div></td>");  
	  	         sb.append("<td width='20%' class='multiLabel'><div align='center'>Brand Name</div></td>");
	  	         sb.append("<td width='20%' class='multiLabel'><div align='center'>Batch Sl No.</div></td>");
	  	         sb.append("<td width='20%' class='multiLabel'><div align='center'>Expiry Date</div></td>");
	             sb.append("<td width='16%' class='multiLabel'><div align='center'>Received Qty</div></td>");
	             
	             sb.append("</tr>");
				while(wb.next())
				{		     
	            
	                   
	                	String strItemName = wb.getString(2);
	  					String strBrandName = wb.getString(4);
	  					String strBatchSlNo = wb.getString(5);
	  					String strExpiryDate = wb.getString(6);
	  					String strReqQty = wb.getString(7); 
	  					String strHiddenId = wb.getString(1);
	  					
	  					
	  					if(strItemName == null || strItemName.equals("null") || strItemName.equals(""))strItemName = "---";
	  					if(strBrandName == null || strBrandName.equals("null") || strBrandName.equals("") )strBrandName = "---";
	  					if(strBatchSlNo == null || strBatchSlNo.equals("null") || strBatchSlNo.equals(""))strBatchSlNo = "---";
	  					if(strExpiryDate == null || strExpiryDate.equals("null") || strExpiryDate.equals(""))strExpiryDate = "---";
	  					if(strReqQty == null || strReqQty.equals("null") || strReqQty.equals(""))strReqQty = "---";
	  					
	  				
	  					sb.append("<tr>");
	  					sb
						.append(" <TD  CLASS='multiControl' WIDTH='4%' ><input type='checkbox' name='strItemDetailsChk' id='strItemDetailsChk"
								+strIndex+ i
								+ "' onclick='ClickCheckBox(this,\""
								+ i
								+ "\");' value= '"
								+ strHiddenId+"' /> ");
	  					sb.append("<td width='20%' class='multiControl'>"+strItemName+"</td>");
	  					sb.append("<td width='20%' class='multiControl'>"+strBrandName+"</td>");
	  					sb.append("<td width='20%' class='multiControl'>"+strBatchSlNo+"</td>");
	  					sb.append("<td width='20%' class='multiControl'>"+strExpiryDate+"</td>");
	  					sb.append("<td width='16%' class='multiControl'>"+strReqQty+"</td>");
	  					
	  					
	  					sb.append("</tr>");	
	  					i++;
	  				}
                sb.append("</table>");
               
                
	     }else {
			    sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
			    sb.append("<tr>");
			    sb.append("<td colspan='5'  CLASS='multiControl' >"
						+ "<div class='errMsg' align='center'> NO ITEM DETAILS FOUND FOR SELECTED RECEIPT no. </div>" + "</td>");

			    sb.append("</tr>");
			    sb.append("</table>");
		   } 
		 }
		 catch(Exception e)
		 {
			 new HisException("Inspection Intimation Transaction","InspectionIntimationTransHLP.getReceiptDetails()-->",e.getMessage());
	     }
	    return sb.toString();
	 	}
	

}
