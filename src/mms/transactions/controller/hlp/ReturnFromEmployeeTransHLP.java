/**
 * 
 */
package mms.transactions.controller.hlp;

import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.transactions.bo.ReturnFromEmployeeTransBO;
import mms.transactions.vo.ReturnFromEmployeeTransVO;

/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * Date : 17/June/2009
 * 
 */
public class ReturnFromEmployeeTransHLP {

	public static String getItemDetails(String strItemCategoryNo,
			String strHospitalCode, WebRowSet wb, String strStoreId)
	 {
		StringBuffer sBuffer = new StringBuffer("");
		
	
		ReturnFromEmployeeTransVO vo=null;
		ReturnFromEmployeeTransBO bo= null;
		String strReturnUnitCombo = "";
		HisUtil hisutil = null;
		
		String strHiddenId = "";//total cost^unit id
		String unitId = "";
		String strBrdName = "";
		String strBtchSlNo = "";
		String strExpiryDt = "";
		String strBalQty = "";
	//	String totalCost = "";
		String rateUnit = "";
		String rate = "";
		String rateUnitId ="";
		String manufDate = "";
		String consumable = "";
		String issueUnit = "";
		String returnUnit = "";
		String baseValue = "";
	//	String stockStatus = "";
		String strStockStatusCombo = "";
		int i = 0;
		
		
		 try {
			 
			 bo = new ReturnFromEmployeeTransBO();
			 vo = new ReturnFromEmployeeTransVO();
			
			
			 hisutil = new HisUtil("MMS","ReturnFromTransHLP");
			 
			 if(wb.size() != 0){
			 
				 sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");       
	             sBuffer.append("<tr>");  
	             sBuffer.append("<td width='15%' class='multiLabel'>Item Name</td>");
	  	         sBuffer.append("<td width='10%' class='multiLabel'>Batch/Sl No</td>");
	  	         sBuffer.append("<td width='10%' class='multiLabel'>Balance Qty</td>");
	  	         sBuffer.append("<td width='15%' class='multiLabel'><font color='red'>*</font>Return Qty</td>");
	             sBuffer.append("<td width='20%' class='multiLabel'><font color='red'>*</font>Return Qty Unit</td>");
	             sBuffer.append("<td width='20%' class='multiLabel'><font color='red'>*</font>Stock Status</td>");
	             sBuffer.append("<td width='10%' class='multiLabel'>Cost(Rs.)</td>");
	             sBuffer.append("</tr>");
	             sBuffer.append("</table>");
				while(wb.next())
				{		     	
					
					
					
					
					    strHiddenId = wb.getString(1); //item id^itemBrandId^groupId^subGroupId 
					    								//total cost^unit id^rate unit^rate^rateunitid^base value
					    								//^manufdate^consumable^issueUnit^returnUnit^balQty^balUnitId^expiryDate
					    strBrdName = wb.getString(2);
	  					strBtchSlNo = wb.getString(3);
	  					strBalQty = wb.getString(4);
	  					
	  					//System.out.println("hidden val--"+wb.getString(1));
	  					
	  					String[] temp = strHiddenId.replace("^", "#").split("#");
	  					
	  					//System.out.println("temp.length--"+temp.length);
	  			//		totalCost = temp[4];
	  					unitId = temp[5];
	  					rateUnit = temp[6];
	  					rate = temp[7];
	  					rateUnitId = temp[8];
	  					baseValue = temp[9];
	  					manufDate = temp[10];
	  					consumable = temp[11];
	  					issueUnit = temp[12];
	  					returnUnit = temp[13];
	  					//balQty = temp[14];
	  					//balQtyUnit = temp[15]
	  					//System.out.println("temp[17]-"+temp[17]);
	  					if(temp.length<18)
	  						strExpiryDt = "--";
	  					else
	  					strExpiryDt = temp[17];
	  					
						vo.setStrIssueQtyUnitId(unitId);
						vo.setStrHospitalCode(strHospitalCode);
						
						bo.getReturnQtyUnit(vo);
	  					if (vo.getStrMsgType().equals("1")) {
							throw new Exception(vo.getStrMsgString());
						}
	  					
	  					
	  					
	  					if (vo.getReturnQtyUnitWS() != null
	  							&& vo.getReturnQtyUnitWS().size() > 0) {
	  						strReturnUnitCombo = hisutil.getOptionValue(vo.getReturnQtyUnitWS(), 
	  								"0", "0^Select Value", true);
	  					} else {
	  						strReturnUnitCombo = "<option value='0'>Select Value</option>";
	  					}
	  					
	  					bo.getStockStatus(vo);
	  					if (vo.getStrMsgType().equals("1")) {
							throw new Exception(vo.getStrMsgString());
						}
	  					
	  					
	  					
	  					if (vo.getStockStatusWS() != null
	  							&& vo.getStockStatusWS().size() > 0) {
	  						strStockStatusCombo = hisutil.getOptionValue(vo.getStockStatusWS(), 
	  								"0", "0^Select Value", true);
	  					} else {
	  						strStockStatusCombo = "<option value='0'>Select Value</option>";
	  					}
	  					
	  					if(strExpiryDt == null || strExpiryDt.equals("null") || strExpiryDt.equals(""))strExpiryDt = "---";
	  					if(strBrdName == null || strBrdName.equals("null") || strBrdName.equals("") )strBrdName = "---";
	  					if(strBtchSlNo == null || strBtchSlNo.equals("null") || strBtchSlNo.equals(""))strBtchSlNo = "---";
	  					if(strBalQty == null || strBalQty.equals("null") || strBalQty.equals(""))strBalQty = "---";
	  					
	  					sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");  
	  					sBuffer.append("<tr>");
	  					sBuffer.append("<td width='15%' class='multiControl'><a style='cursor:pointer;cursor:pointer;color:blue'" +
	  							"onClick='openItemName(this,"+i+");'>" 
	  							+ strBrdName +"</a>"+
	  							"<input type='hidden' name='strItem' id='strItem" + i
		  							+"' value='"+ rateUnit+ "@"+ manufDate +"@"+ consumable + "@" +strExpiryDt+"'/></td>");
	  							/*"<input type='checkbox' name='strItemDetailsChk' id='strItemDetailsChk"+
	  							+ i
								+ "' onclick='ClickCheckBox(this,\""
								+ i
								+ "\");' value= '"
								+ strHiddenId
								+ "^"
								+ strItemCategoryNo
								+ "^"
								+ strStoreId
								+ "' /> ");
	  					sBuffer.append(" <input type='hidden' name='flag' id='flag" + i
								+ "' value=" + "0" + " >");

	  					sBuffer.append("</td>");	
	  					
	  					sBuffer.append("<td width='15%' class='multiControl'>"
	  							+ strItmName +"</td>");*/
	  					sBuffer.append("<td width='10%' class='multiControl'>"
	  							+ strBtchSlNo +"</td>");
	  					/*sBuffer.append("<td width='15%' class='multiControl'>"
	  							+ strExpiryDt +"</td>");*/
	  					sBuffer.append("<td width='10%' class='multiControl' name='strBalanceQty' id='strBalanceQty"+i+"'>"
	  							+"<a style='cursor:pointer;cursor:pointer;color:blue' title='To Get Balance Quantity Details' onclick='openBalQty(this,"+i+");'>"+ strBalQty + "</a>" +
	  									"<input type='hidden' name='balQty' id='balQty" + i
	  							+"' value='"+ issueUnit+ "@"+ returnUnit +"'/><input type='hidden' name='strBalQty' id='strBalQty" + i
	  							+"' value='"+ strBalQty+"'/></td>");
	  					
	  					sBuffer.append("<td WIDTH='15%' CLASS='multiControl' >" +
	  							"<input type='text' maxlength='8' onkeypress='return validateData(event,7);', onkeyup='quantityUnitValue("+i+");'"  +
	  							"name='strReturnQty' id='strReturnQty"
								+ i
								+ "' class='txtFldMin' value=''> </td>");
	  					sBuffer.append("<td WIDTH='20%' CLASS='multiControl' >" +
	  							"<Select name='strReturnQtyUnitId' id='strReturnQtyUnitId" 
								+ i 
								+ "' onchange='quantityUnitValue("+i+");'>"
								+ strReturnUnitCombo + "</select></td>");
	  					sBuffer.append("<td WIDTH='20%' CLASS='multiControl' >" +
	  							"<Select name='strStockStatusCode' id='strStockStatusCode" 
								+ i 
								+ "'>"
								+ strStockStatusCombo + "</select></td>");
	  					sBuffer.append("<td width='10%' class='multiControl'> <div id='strTotalCostDivId"+i+"'>0.00</div>" +
	  							"<input type='hidden' name='strTotalCost' id='strTotalCost" + i
	  							+"' value='0' /><input type='hidden' name='strRate' id='strRate" + i
	  							+"' value='"+ rate+"@"+ rateUnitId+"@"+baseValue+"'/></td>");
	  					sBuffer.append("<td><input type='hidden' name='strHidParamVal' id='strHidParamVal" + i
	  							+"' value='"+wb.getString(1)+"'/></td>");
	  					sBuffer.append("</tr>");
	  					sBuffer.append("</table>");
	  					i++;
	  					
	  						
	  				}
					sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");  
					sBuffer.append("<tr>");
					sBuffer.append("<td width='83%' class='LABEL'>Net Cost(Rs):</td>");
					sBuffer.append("<td width='17%' class='CONTROL' style='color: red; font-weight: bold'><div id='strNetCostDivId' align='center'>0.00</div>");
					sBuffer.append("<input type='hidden' name='strNetCost' id='strNetCost' value='0'/></td>");
					sBuffer.append("</tr>");
					sBuffer.append("</table>");
			 } 
	   
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
				return "ERROR";

	     }
	    return sBuffer.toString();
	 	}
	
	 public static String getEmployeeDtl(WebRowSet ws)
	    {
			
			StringBuffer sb = new StringBuffer("");
			
			try {
				
				if(ws.size() != 0 || !ws.equals(null))
				{ 
					if (ws.next()) 
					{
											
						String strDeptDesiId         = ws.getString(1);
						String strAgeSex          = ws.getString(2);
						String strEmployeeName         = ws.getString(3);
						String strDeptName  =    ws.getString(4);
						String strDesignation       = ws.getString(5);
						
						String[] temp = strDeptDesiId.replace("^", "#").split("#");
						
						String strDeptId = temp[0];
																	
												
						if (strDeptName == null)
							strDeptName = "----";
						if (strEmployeeName == null)
							strEmployeeName = "----";
						if (strAgeSex == null)
							strAgeSex = "----";
						if (strDesignation == null)
							strDesignation = "----";
						
						sb.append("<input type='hidden' name ='strDeptId'  value='"+strDeptId+"'>");
						
						sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
						sb.append("<tr><td width='25%'  class='LABEL'>Employee Name</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strEmployeeName);
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Age/Sex</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strAgeSex);
						sb.append("</td></tr>");
						sb.append("<tr><td width='25%' class='LABEL'>Department</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strDeptName);
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Designation</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strDesignation);
						sb.append("</td></tr>");
						
						sb.append("</table>");
						
					}
				}
				else {
					   
					    sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
					    sb.append("<tr>");
					    sb.append("<td colspan='5'  CLASS='multiControl' >"
								+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED DATA </div>" + "</TD>");

					    sb.append("</tr>");
					    sb.append("</table>");
					    
					    
						
				   } 
			}catch(Exception e){
				try{
					throw new Exception ("ReturnFromEmployeeTransHLP.getEmployeeDtl---->"+e.getMessage());
				}catch(Exception err){
					
				}
			}
		return sb.toString();
		}

}
