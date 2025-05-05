package mms.transactions.controller.hlp;

import hisglobal.utility.HisUtil;

import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;


/**
 * Developer : Pramod Kumar Mehta 
 * Version : 1.0 
 * Date : 24/Jan/2009
 *  Module:MMS
 * Unit:Set/Sachet Details
 *
 */

/**
 * Developer : Anshul Jindal Version : 2.0 Date : 30/May/2009 Module:MMS
 * Unit:Set/Sachet Details
 * 
 */

public class SetSachetDetailsTransHLP {

	public static String getItemDetails(String strPreparedQty,String HosCode, WebRowSet wb)
			throws SQLException {
		StringBuffer br = new StringBuffer();
	
		String strHiddenIds = "";
	
		String strAvlQtyInInvUnit = "";
		String strAvlQtyWithUnit = "";
	//	String strReqQtyInInvUnit  = "";
		String strReqQtyPerItem= "";
		String strTotalReqQty= "";
		String strReqQtyUnit= "";
		String strItemName = "";
		String strCategoryName = "";
		String strRateInInvUnit = "";
		String strSalePriceInInvUnit = "";
		String strCost = "";
		String strSalePrice = "";
		String[] temp = null;
		int i = 0;
		String strRedRowFlag = "0";

		try {
		
			br
			.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");

			br
			.append("<tr> <td colspan='5' class='TITLE'>Item Details</td> </tr>   <tr>");
			br
			.append(" <td class='multiLabel' width='25%' >Item Name</td>");
			   
			br
			.append(" <td class='multiLabel' width='25%'>Item Category</td>");
			   
			br
			.append("  <td class='multiLabel' width='25%'>Req Qty</td>");
			   
			br
			.append(" <td class='multiLabel' width='25%'>Avl Qty</td>");
		/*	   
			br
			.append("<td class='multiLabel' width='20%'>Cost (Rs.)</td>  </tr> </table>");
		*/	   
			
			  

			if (wb!=null && wb.size() != 0) {
				br
						.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");

				while (wb.next()) {
					
					strHiddenIds =  wb.getString(1);
					strItemName =  wb.getString(2);
					strCategoryName =  wb.getString(3);
					strAvlQtyWithUnit = wb.getString(4);
					strRateInInvUnit =  wb.getString(5);
					//System.out.println("hlp strRateInInvUnit"+strRateInInvUnit);
					if(wb.getString(6)==null || wb.getString(6).equals("") )
					{
						strSalePriceInInvUnit ="0";
					}
					else{
						strSalePriceInInvUnit  =  wb.getString(6);
					}
					
					
					temp = strHiddenIds.replace("^", "#").split("#");
					
			//		strReqQtyInInvUnit = temp[3];
					strReqQtyPerItem = temp[4];
					strReqQtyUnit = temp[5];
					strAvlQtyInInvUnit =  temp[8];
					
					Integer reqQty =  (Integer.parseInt(strPreparedQty) * Integer.parseInt( strReqQtyPerItem));
					strTotalReqQty = Integer.toString(reqQty);
					
					
					strCost = Float.toString(reqQty  * Float.parseFloat(strRateInInvUnit));
					//System.out.println("hlp strCost"+strCost);
					strCost =  HisUtil.getAmountWithDecimal(strCost, 2);
					//System.out.println("hlp strCost"+strCost);
					strSalePrice = Float.toString(reqQty  * Float.parseFloat(strSalePriceInInvUnit));
					//System.out.println("hlp strSalePrice-"+strSalePrice);
			
					if(reqQty > Float.parseFloat(strAvlQtyInInvUnit)) // red row 
					{
						strRedRowFlag = "1";
						br.append("<TR > ");
					

						br.append("<TD WIDTH='25%' class='redMultiControl' >"
								+strItemName+ "<input type='hidden' name ='strItemDetailsChk' id='strItemDetailsChk"
										+ i
										+ "' value= '"
										+ strHiddenIds+"' /></TD>");
						br.append("<TD WIDTH='25%' class='redMultiControl' >"
								+ strCategoryName + "</TD>");
						br.append("<TD WIDTH='25%'  class='redMultiControl'>"
								+ strTotalReqQty +" "+strReqQtyUnit + "</TD>");
						br.append("<TD WIDTH='25%' class='redMultiControl'  >"
								+ strAvlQtyWithUnit + "<input type='hidden' name='strSalePrice' value='"+strSalePrice+"' />"+
										" <input type='hidden' name='isAnyRedRow' value='1' /></TD>");
					
						br.append("</TR>");
						
					}
					else{
						br.append("<TR > ");
						

						br.append("<TD WIDTH='25%' CLASS='multiControl' >"
								+strItemName+ "<input type='hidden' name ='strItemDetailsChk' id='strItemDetailsChk"
										+ i
										+ "' value= '"
										+ strHiddenIds+"' /></TD>");
						br.append("<TD WIDTH='25%' CLASS='multiControl' >"
								+ strCategoryName + "</TD>");
						br.append("<TD WIDTH='25%' CLASS='multiControl' >"
								+  strTotalReqQty +" "+strReqQtyUnit  + "</TD>");
						br.append("<TD WIDTH='25%' CLASS='multiControl' >"
								+ strAvlQtyWithUnit + "<input type='hidden' name='strSalePrice' value='"+strSalePrice+"' />"+
								"<input type='hidden' name='isAnyRedRow' value='0' /></TD>");
					
						
						br.append("</TR>");
						
					}
					
					
					i++;
				}

				/*br.append("<tr class='TITLE'");
				
				br.append("<td colspan='5'> <input type='button' style='background-color:#E8506D;' disabled='disabled' />  Required Quantity is greater than Available Quantity  </td>");
				br.append("</tr>");*/
				br.append("</table> "+"@@"+strRedRowFlag);
			} else {
				br
						.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
				br.append("<TR>");
				br.append("<TD  CLASS='multiControl' colspan='5'>"
						+ "No Record Found" + "<input type='hidden' name='isAnyRedRow' value='0' /> <input type='hidden' name='noRecordFlag' value='1' /></TD>");
				br.append("</TR>");
				
				br.append("</table> "+"@@"+strRedRowFlag);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		//System.out.println("br.toString()-"+br.toString());
		return br.toString();
	//	return strItemName;
	}

}

