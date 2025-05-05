package mms.transactions.controller.hlp;

import hisglobal.exceptions.HisException;

import javax.sql.rowset.WebRowSet;

/**
 * @author Amit Kumar
 * Date of Creation : 07/4/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
public class PODeskTransADDHLP 
{
	
	public static String getReceiptItemDetails(WebRowSet wb)
	 {
		StringBuffer sBuffer = new StringBuffer("");
		 try {
			if(wb.size() != 0)
			{ 
				 sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");       
				 sBuffer.append("<tr class='TITLE'><td colspan='8'>Item Details</td></tr>");
				 
				 sBuffer.append("<tr><td width='15%' class='multiLabel'><div align='center'>Item Name</div></td>");  
	  	         sBuffer.append("<td width='15%' class='multiLabel'><div align='center'>Manufactrer Name</div></td>");
	  	         sBuffer.append("<td width='12%' class='multiLabel'><div align='center'>Unit / PkgId</div></td>");
	  	         sBuffer.append("<td width='12%' class='multiLabel'><div align='center'>Order Qty</div></td>");
	             sBuffer.append("<td width='11%' class='multiLabel'><div align='center'>Rate </div></td>");
	             sBuffer.append("<td width='10%' class='multiLabel'><div align='center'>Rate Unit / Pkg Id</div></td>");
	             sBuffer.append("<td width='10%' class='multiLabel'><div align='center'>Cost</div></td>");
	             sBuffer.append("</tr>");
				while(wb.next())
				{		     
	                            
	                	String strItemName = wb.getString(1);
	  					String strBrandName = wb.getString(2);
	  					String strRateUnit = wb.getString(3);
	  					String strTax = wb.getString(1);
	  					String strReqQty = wb.getString(2);
	  					String strSuppliedQty = wb.getString(3);
	  					
	  					if(strItemName == null || strItemName.equals("null") || strItemName.equals(""))strItemName = "---";
	  					if(strBrandName == null || strBrandName.equals("null") || strBrandName.equals("") )strBrandName = "---";
	  					if(strRateUnit == null || strRateUnit.equals("null") || strRateUnit.equals(""))strRateUnit = "---";
	  					if(strTax == null || strTax.equals("null") || strTax.equals(""))strTax = "---";
	  					if(strReqQty == null || strReqQty.equals("null") || strReqQty.equals(""))strReqQty = "---";
	  					if(strSuppliedQty == null || strSuppliedQty.equals("null") || strSuppliedQty.equals(""))strSuppliedQty = "---";
	  				
	  					sBuffer.append("<tr>");
	  					
	  					sBuffer.append("<td width='15%' class='multiControl'><a STYLE='cursor:pointer;cursor:pointer;color:blue' name='tarriff' value='' title='To Get Item Details' onClick='ItemDtlPopUp(this,"+strRateUnit+",\""+strBrandName+"\");'>" + strItemName + "</a></td>");
     					sBuffer.append("<td width='15%' class='multiControl'><select name='strBillType' class='comboMin'><option value='1'>Consolidated</option><option value='2'>Detailed</option></select></td>");
    					sBuffer.append("<td width='12%' class='multiControl'><select name='strBillType' class='comboMin'><option value='1'>Consolidated</option><option value='2'>Detailed</option></select></td>");
	  					sBuffer.append("<td width='12%' class='multiControl'><input type='text' class='txtFldMin' name='flagConfig'  value='"+0+"'></td>");
	  					sBuffer.append("<td width='11%' class='multiControl'><input type='text' class='txtFldMin' name='flagConfig'  value='"+0+"'></td>");
	  					sBuffer.append("<td width='10%' class='multiControl'><select name='strBillType' class='comboMin'><option value='1'>Consolidated</option><option value='2'>Detailed</option></select></td>");
	  					sBuffer.append("<td width='10%' class='multiControl'>"+strSuppliedQty+"</td>");
	  					sBuffer.append("</tr>");
	  					 					
	  				}
				    sBuffer.append("</table>");
				    sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");    
				    sBuffer.append("<tr><td width='89%' class='LABEL'>Total Cost(Rs.):</td>");
					sBuffer.append("<td width='11%' class='multiControl' style='font-weight:bold'>");
					sBuffer.append("<input name='strMaxBenifitAmt' id='strMaxBenifitAmt' type='hidden' class='txtFldNormal' value='0' disabled='disabled'>");
					sBuffer.append("</td></tr>");
					sBuffer.append("<tr class='TITLE'><td colspan='8'></td></tr>");

                    sBuffer.append("</table>");
               
                
	     }else {
			    sBuffer.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
			    sBuffer.append("<tr>");
			    sBuffer.append("<td colspan='7'  CLASS='multiControl' >"
						+ "<div class='errMsg' align='center'> NO RECEIPT DETAILS FOUND FOR SELECTED PO NO. </div>" + "</td>");

			    sBuffer.append("</tr>");
			    sBuffer.append("</table>");
		   } 
		 }
		 catch(Exception e)
		 {
			 new HisException("Bill Approval Transaction","BillApprovalViewTransHLP.getReceiptDetails()-->",e.getMessage());
	     }
	    return sBuffer.toString();
	 	}

}
