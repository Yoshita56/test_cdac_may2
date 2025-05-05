/**
 * 
 */
package mms.transactions.controller.hlp;

import hisglobal.exceptions.HisException;

import javax.sql.rowset.WebRowSet;

/**
 * Developer : Anshul Jindal 
 * Version : 1.0 
 * Date : 15/Apr/2009
 * 
 */
public class InspectionReportTransHLP {
	
	public static String getItemDetails(WebRowSet wb,String strStoreId,String strReqNo)
	 {
		//System.out.println("get ItemDetails");
		StringBuffer sb = new StringBuffer("");
		int i=0;
		 try {
			if(wb.size() != 0)
			{ 
				wb.beforeFirst();
				 sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");       
	             sb.append("<tr><td width='4%' class='multiLabel'></td>" );
	             sb.append(		"<td width='15%' class='multiLabel'><div align='center'>Item Name</div></td>");  
	  	         sb.append("<td width='15%' class='multiLabel'><div align='center'>Brand Name</div></td>");
	  	         sb.append("<td width='15%' class='multiLabel'><div align='center'>Batch Sl No.</div></td>");
	  	         sb.append("<td width='15%' class='multiLabel'><div align='center'>Expiry Date</div></td>");
	             sb.append("<td width='15%' class='multiLabel'><div align='center'>Received Qty</div></td>");
	             sb.append("<td width='15%' class='multiLabel'><div align='center'>Issue Qty</div></td>");
	             sb.append("<td width='6%' class='multiLabel'><div align='center'>Status</div></td>");
	             
	             sb.append("</tr>");
				while(wb.next())
				{		     
	            
						String strItemId = wb.getString(1);
						String strBrandId = wb.getString(3);
	                	String strItemName = wb.getString(2);
	  					String strBrandName = wb.getString(4);
	  					String strBatchSlNo = wb.getString(5);
	  					String strExpiryDate = wb.getString(6);
	  					String strRecQty = wb.getString(7); 
	  					String strStatus = "";
	  					String strIssueQtyUnitId =wb.getString(10); 
	  					String strIssueQty = wb.getString(8); 
	  					if(wb.getString(9).equals("1"))
	  					{ strStatus ="Approved";
	  					}
	  					else if(wb.getString(9).equals("2"))
	  					{ strStatus ="Rejected";
	  					}
	  					else
	  						 strStatus ="Report Pending";
	  					
	  					String strHiddenId = strStoreId+"^"+strReqNo+"^"+strItemId+"^"+strBrandId+"^"+strBatchSlNo;
	  					
	  					
	  					if(strItemName == null || strItemName.equals("null") || strItemName.equals(""))strItemName = "---";
	  					if(strBrandName == null || strBrandName.equals("null") || strBrandName.equals("") )strBrandName = "---";
	  					if(strBatchSlNo == null || strBatchSlNo.equals("null") || strBatchSlNo.equals(""))strBatchSlNo = "---";
	  					if(strExpiryDate == null || strExpiryDate.equals("null") || strExpiryDate.equals(""))strExpiryDate = "---";
	  					if(strRecQty == null || strRecQty.equals("null") || strRecQty.equals(""))strRecQty = "---";
	  					if(strIssueQty == null || strIssueQty.equals("null") || strIssueQty.equals(""))strIssueQty = "---";
	  					if(strStatus == null || strStatus.equals("null") || strStatus.equals(""))strStatus = "---";
	  					
	  				
	  					sb.append("<tr>");
	  					sb
						.append(" <TD  CLASS='multiControl' WIDTH='4%' ><input type='checkbox' name='strItemDetailsChk' id='strItemDetailsChk"
								+ i
								+ "' onclick='return ClickCheckBox(this,\""
								+ i
								+ "\");' value= '"
								+ strHiddenId+"' /> ");
	  				
	  					sb
						.append(" <input type='hidden' name='strReportDtl' id='strReportDtl"
								+ i
								+ "'  value= '' /> ");
	  					sb
						.append(" <input type='hidden' name='strIssueQtyUnitId' id='strIssueQtyUnitId"
								+ i
								+ "'  value= '"+strIssueQtyUnitId+"' /> ");
	  					
	  					sb.append("</td><td width='15%' class='multiControl'>"+strItemName+"</td>");
	  					sb.append("<td width='15%' class='multiControl'>"+strBrandName+"</td>");
	  					sb.append("<td width='15%' class='multiControl'>"+strBatchSlNo+"</td>");
	  					sb.append("<td width='15%' class='multiControl'>"+strExpiryDate+"</td>");
	  					sb.append("<td width='15%' class='multiControl'>"+strRecQty+"</td>");
	  					sb.append("<td width='15%' class='multiControl'>"+strIssueQty+"</td>");
	  					sb.append("<td width='6%' class='multiControl' id='strStatus"
								+ i
								+ "'  >"+strStatus+"</td>");
	  					
	  					
	  					
	  					sb.append("</tr>");	
	  					i++;
	  				}
               sb.append("</table>");
              
               
	     }else {
			    sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
			    sb.append("<tr>");
			    sb.append("<td colspan='5'  CLASS='multiControl' >"
						+ "<div class='errMsg' align='center'> NO ITEM DETAILS FOUND FOR SELECTED REQUEST NO. </div>" + "</td>");

			    sb.append("</tr>");
			    sb.append("</table>");
		   } 
		 }
		 catch(Exception e)
		 {
			 new HisException("Inspection Report Transaction","InspectionReportTransHLP.getItemDetails()-->",e.getMessage());
	     }
	    return sb.toString();
	 	}
	

}
