/**
 * 
 */
package mms.transactions.controller.hlp;

import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.transactions.bo.DupReturnFromTransBO;
import mms.transactions.vo.DupReturnFromTransVo;

/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * Date : 24/April/2009
 * 
 */
public class DupReturnFromTransHLP {

	public static String getItemDetails(String strItemCategoryNo,
			String strHospitalCode, WebRowSet wb, String strStoreId)
	 {
		StringBuffer sBuffer = new StringBuffer("");
		
	
		DupReturnFromTransVo vo=null;
		DupReturnFromTransBO bo= null;
		String strReturnUnitCombo = "";
		HisUtil hisutil = null;
		
		String strHiddenId = "";//total cost^unit id
		String unitId = "";
		String strBrdName = "";
		String strBtchSlNo = "";
		String strExpiryDt = "";
		String strBalQty = "";
		String strRetQty = "";
	//	String totalCost = "";
		String rateUnit = "";
		String rate = "",strRate="";
		String rateUnitId ="";
		String manufDate = "";
		String consumable = "";
		String issueUnit = "";
		String returnUnit = "";
		String baseValue = "";
		Double TotalCost=0.00;
		int i = 0;
		
		
		 try {
			 
			 bo = new DupReturnFromTransBO();
			 vo = new DupReturnFromTransVo();
			
			
			 hisutil = new HisUtil("MMS","ReturnFromTransHLP");
			 
			 if(wb.size() != 0){
			 
				 sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='#1277B5'>");       
	             sBuffer.append("<tr>");  
	             sBuffer.append("<td width='33%' class='multiRPTLabel'>Drug Name</td>");
	  	         sBuffer.append("<td width='13%' class='multiRPTLabel'>Batch</td>");
	  	         //sBuffer.append("<td width='10%' class='multiRPTLabel'>Expiry Date</td>");
	  	         //sBuffer.append("<td width='10%' class='multiRPTLabel'>Balance Qty</td>");
	             sBuffer.append("<td width='10%' class='multiRPTLabel'><font color='red'>*</font>Return Qty</td>");
	             sBuffer.append("<td width='13%' class='multiRPTLabel'><font color='red'>*</font>Return Qty Unit</td>");
	             sBuffer.append("<td width='10%' class='multiRPTLabel'>Cost(Rs.)</td>");
	             sBuffer.append("</tr>");
	             sBuffer.append("</table>");
				while(wb.next())
				{		     	
					
					
					strHiddenId = wb.getString(1); //item id^itemBrandId^groupId^subGroupId 
													//total cost^unit id^rate unit^rate^rateunitid^base value
													//^manufdate^consumable^issueUnit^returnUnit
						strBrdName = wb.getString(2);
						strBtchSlNo = wb.getString(5);
						strExpiryDt = wb.getString(9);
						strBalQty = wb.getString(5);
						strRetQty = wb.getString(6);
						strRate = wb.getString(7);
						TotalCost=TotalCost+Double.parseDouble(wb.getString(8));
						String[] temp = strHiddenId.replace("^", "#").split("#");
						
					//	totalCost = temp[4];
						unitId = wb.getString(10);//temp[5];
						rateUnit = "6301";//temp[6];
						rate = "";//temp[7];
						rateUnitId =wb.getString(10);;//temp[8];
						baseValue =  "6301";//temp[9];
						manufDate =  "6301";//temp[10];
						consumable =  "6301";//temp[11];
						issueUnit =  "6301";//temp[12];
						returnUnit = "6301";// temp[13];
						
						vo.setStrIssueQtyUnitId(unitId);
						vo.setStrHospitalCode(strHospitalCode);
	  					
						vo.setStrIssueQtyUnitId(unitId);
						vo.setStrHospitalCode(strHospitalCode);
						
										  					
	  					if (vo.getStrMsgType().equals("1")) {
							throw new Exception(vo.getStrMsgString());
						}
	  					
	  					bo.getReturnQtyUnit(vo);
	  					
	  					if (vo.getReturnQtyUnitWS() != null	&& vo.getReturnQtyUnitWS().size() > 0) 
	  					{
	  						String strReturnQtyUnit ="0";
	  						if(vo.getReturnQtyUnitWS().next())
	  						{
	  							strReturnQtyUnit = vo.getReturnQtyUnitWS().getString(1);
	  						}
	  						else
	  						{
	  							strReturnQtyUnit="0";
	  						}
	  						
	  						vo.getReturnQtyUnitWS().beforeFirst();
	  						strReturnUnitCombo = hisutil.getOptionValue(vo.getReturnQtyUnitWS(), strReturnQtyUnit, "0^Select", true);
	  					}
	  					else 
	  					{
	  						strReturnUnitCombo = "<option value='0'>Select</option>";
	  					}
	  					
	  					
	  					if(strExpiryDt == null || strExpiryDt.equals("null") || strExpiryDt.equals(""))strExpiryDt = "---";
	  					if(strBrdName == null || strBrdName.equals("null") || strBrdName.equals("") )strBrdName = "---";
	  					if(strBtchSlNo == null || strBtchSlNo.equals("null") || strBtchSlNo.equals(""))strBtchSlNo = "---";
	  					if(strBalQty == null || strBalQty.equals("null") || strBalQty.equals(""))strBalQty = "---";
	  					
	  					sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='#1277B5'>");  
	  					sBuffer.append("<tr>");
	  					sBuffer.append("<td width='33%' class='multiPOControl' style='text-align:left'>"+strBrdName+""+
	  							"<input type='hidden' name='strItem' id='strItem" + i
		  							+"' value='"+ rateUnit+ '@'+ manufDate +'@'+ consumable +"'/></td>");
	  					
//	  					sBuffer.append("<td width='33%' class='multiPOControl'><a style='cursor:pointer;cursor:pointer;color:blue;text-align:left' title='Get Brand Details' " +
//	  							"onClick='openItemName(this,"+i+");'>" 
//	  							+ strBrdName +"</a>"+
//	  							"<input type='hidden' name='strItem' id='strItem" + i
//		  							+"' value='"+ rateUnit+ '@'+ manufDate +'@'+ consumable +"'/></td>");
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
	  					
	  					sBuffer.append("<td width='15%' class='multiPOControl'>"
	  							+ strItmName +"</td>");*/
	  					sBuffer.append("<td width='13%' class='multiPOControl'>"
	  							+ strBtchSlNo +"</td>");
	  					/*sBuffer.append("<td width='10%' class='multiPOControl'>"
	  							+ strExpiryDt +"</td>");*/
	  					
	  					/*sBuffer.append("<td width='10%' class='multiPOControl' name='strBalanceQty' id='strBalanceQty"+i+"'>"+ strBalQty+"" +
	  									"<input type='hidden' name='balQty' id='balQty" + i
	  							+"' value='"+ issueUnit+ '@'+ returnUnit +"'/><input type='hidden' name='strBalQty' id='strBalQty" + i
	  							+"' value='"+ strBalQty+"'/></td>");*/
	  					
	  					
//	  					sBuffer.append("<td width='10%' class='multiPOControl' name='strBalanceQty' id='strBalanceQty"+i+"'>"
//	  							+"<a style='cursor:pointer;cursor:pointer;color:blue' onclick='openBalQty(this,"+i+");'>"+ strBalQty + "</a>" +
//	  									"<input type='hidden' name='balQty' id='balQty" + i
//	  							+"' value='"+ issueUnit+ '@'+ returnUnit +"'/><input type='hidden' name='strBalQty' id='strBalQty" + i
//	  							+"' value='"+ strBalQty+"'/></td>");	
	  					
	  					sBuffer.append("<td width='10%' class='multiPOControl'>"
	  							+ strRetQty +"</td>");
	  					
	  					/*sBuffer.append("<td WIDTH='10%' CLASS='multiPOControl' >" +
	  							"<input type='text' maxlength='8' autocomplete='off' onkeypress='return validateData(event,7);', value="+strRetQty+" onkeyup='quantityUnitValue("+i+");'"  +
	  							"name='strReturnQty' disabled='disabled' id='strReturnQty"
								+ i
								+ "' class='txtFldMin' value=''> </td>");*/
	  					sBuffer.append("<td WIDTH='13%' CLASS='multiPOControl' >" +
	  							"<Select name='strReturnQtyUnitId' disabled='disabled' class='comboMin' id='strReturnQtyUnitId"   
								+ i 
								+ "' onchange='quantityUnitValue("+i+");'>"
								+ strReturnUnitCombo + "</select></td>");
	  					sBuffer.append("<td width='10%' class='multiPOControl'> <div id='strTotalCostDivId"+i+"'>"+strRate+"</div>" +
	  							"<input type='hidden' name='strTotalCost' id='strTotalCost" + i
	  							+"' value='0'/><input type='hidden' name='strRate' id='strRate" + i
	  							+"' value='"+ rate+"@"+ rateUnitId+"@"+baseValue+"'/><input type='hidden' name='strHidParamVal' id='strHidParamVal" + i
	  							+"' value='"+wb.getString(1)+"'/></td>");	  					
	  					sBuffer.append("</tr>");
	  					sBuffer.append("</table>");
	  					i++;  						
	  				}
					sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");  
					sBuffer.append("<tr>");
					sBuffer.append("<td width='90%' class='LABEL'>Net Cost(Rs):</td>");
					sBuffer.append("<td width='10%' class='CONTROL' style='color: red; font-weight: bold'><div id='strNetCostDivId' align='center'>"+TotalCost+"</div>");
					sBuffer.append("<input type='hidden' name='strNetCost' id='strNetCost' value='0'/></td>");
					sBuffer.append("</tr>");
					sBuffer.append("</table>");
			 } 
	   
			 
			 else{
				 sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");  
			 
				sBuffer.append("<tr>");
				sBuffer.append("<td width='90%' class='LABEL' style='color: red; font-weight: bold' align='center'><div align='center'>No Item Availbe For Return</div></td>");
			    sBuffer.append("</tr>");
				sBuffer.append("</table>");
			 }
			 //System.out.println("sBuffersBuffersBuffer  "+sBuffer.toString());
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
				return "ERROR";

	     }
	    return sBuffer.toString();
	 	}
}
