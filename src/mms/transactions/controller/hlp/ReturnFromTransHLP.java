/**
 * 
 */
package mms.transactions.controller.hlp;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.HisUtil;
import mms.MmsConfigUtil;
import mms.transactions.bo.ReturnFromTransBO;
import mms.transactions.controller.fb.ReturnFromTransFB;
import mms.transactions.vo.ReturnFromTransVO;

/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * Date : 24/April/2009
 * 
 */
public class ReturnFromTransHLP {

	public static String getItemDetails(String strItemCategoryNo,
			String strHospitalCode, WebRowSet wb, String strStoreId)
	 {
		StringBuffer sBuffer = new StringBuffer("");
	
		ReturnFromTransVO vo=null;
		ReturnFromTransBO bo= null;
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
		int i = 0;
		
		
		 try {
			 
			 bo = new ReturnFromTransBO();
			 vo = new ReturnFromTransVO();
			
			
			 hisutil = new HisUtil("MMS","ReturnFromTransHLP");
			 
			 if(wb.size() != 0){
			 
				 sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='#1277B5'>");       
	             sBuffer.append("<tr>");  
	             sBuffer.append("<td width='33%' class='multiRPTLabel'>Drug Name</td>");
	  	         sBuffer.append("<td width='13%' class='multiRPTLabel'>Batch</td>");
	  	         sBuffer.append("<td width='10%' class='multiRPTLabel'>Expiry Date</td>");
	  	         sBuffer.append("<td width='10%' class='multiRPTLabel'>Balance Qty</td>");
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
						strBtchSlNo = wb.getString(3);
						strExpiryDt = wb.getString(4);
						strBalQty = wb.getString(5);
						
						String[] temp = strHiddenId.replace("^", "#").split("#");
						
					//	totalCost = temp[4];
						unitId = temp[5];
						rateUnit = temp[6];
						rate = temp[7];
						rateUnitId = temp[8];
						baseValue = temp[9];
						manufDate = temp[10];
						consumable = temp[11];
						issueUnit = temp[12];
						returnUnit = temp[13];
						
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
	  					sBuffer.append("<td width='10%' class='multiPOControl'>"
	  							+ strExpiryDt +"</td>");
	  					
	  					sBuffer.append("<td width='10%' class='multiPOControl' name='strBalanceQty' id='strBalanceQty"+i+"'>"+ strBalQty+"" +
	  									"<input type='hidden' name='balQty' id='balQty" + i
	  							+"' value='"+ issueUnit+ '@'+ returnUnit +"'/><input type='hidden' name='strBalQty' id='strBalQty" + i
	  							+"' value='"+ strBalQty+"'/></td>");
	  					
	  					
//	  					sBuffer.append("<td width='10%' class='multiPOControl' name='strBalanceQty' id='strBalanceQty"+i+"'>"
//	  							+"<a style='cursor:pointer;cursor:pointer;color:blue' onclick='openBalQty(this,"+i+");'>"+ strBalQty + "</a>" +
//	  									"<input type='hidden' name='balQty' id='balQty" + i
//	  							+"' value='"+ issueUnit+ '@'+ returnUnit +"'/><input type='hidden' name='strBalQty' id='strBalQty" + i
//	  							+"' value='"+ strBalQty+"'/></td>");	  					
	  					sBuffer.append("<td WIDTH='10%' CLASS='multiPOControl' >" +
	  							"<input type='text' maxlength='8' autocomplete='off' onkeypress='return validateData(event,7);', onkeyup='quantityUnitValue("+i+");'"  +
	  							"name='strReturnQty' id='strReturnQty"
								+ i
								+ "' class='txtFldMin' value=''> </td>");
	  					sBuffer.append("<td WIDTH='13%' CLASS='multiPOControl' >" +
	  							"<Select name='strReturnQtyUnitId' disabled='disabled' class='comboMin' id='strReturnQtyUnitId"   
								+ i 
								+ "' onchange='quantityUnitValue("+i+");'>"
								+ strReturnUnitCombo + "</select></td>");
	  					
	  					sBuffer.append("<td width='10%' class='multiPOControl'> <div id='strTotalCostDivId"+i+"'>0.00</div>" +
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
					sBuffer.append("<td width='10%' class='CONTROL' style='color: red; font-weight: bold'><div id='strNetCostDivId' align='center'>0.00</div>");
					sBuffer.append("<input type='hidden' name='strNetCost' id='strNetCost' value='0'/></td>");
					sBuffer.append("</tr>");
					sBuffer.append("</table>");
			 }else
			 {
				    sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");  
					sBuffer.append("<tr>");
					sBuffer.append("<td width='100%' class='LABEL' style='text-align: center;color: red;'>No Record Available</td>");
					//sBuffer.append("<td width='10%' class='CONTROL' style='color: red; font-weight: bold'><div id='strNetCostDivId' align='center'>0.00</div>");
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

	public static String getItemDetailsNEW(String strItemCategoryNo,
		String strHospitalCode, WebRowSet wb, String strStoreId)
 {
	StringBuffer sBuffer = new StringBuffer("");
	

	ReturnFromTransVO vo=null;
	ReturnFromTransBO bo= null;
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
	int i = 0;
	
	
	 try {
		 
		 bo = new ReturnFromTransBO();
		 vo = new ReturnFromTransVO();
		
		
		 hisutil = new HisUtil("MMS","ReturnFromTransHLP");
		 
		 if(wb.size() != 0){
		 
				sBuffer.append("<table class='table'><tr><thead class='thead-dark'>");
				sBuffer.append("<th width= '30%'>Drug Name");
				sBuffer.append("</th>");
				sBuffer.append("<th width= '15%'>Batch");
				sBuffer.append("</th>");
				sBuffer.append("<th width= '15%'>Expiry Date");
				sBuffer.append("</th>");
				sBuffer.append("<th width= '10%'>Balance Qty");
				sBuffer.append("</th>");
				sBuffer.append("<th width= '10%' ><font color='red'>*</font>Return Qty");
				sBuffer.append("</th>");
				sBuffer.append("<th width= '15%'><font color='red'>*</font>Return Qty Unit");
				sBuffer.append("</th>");
				sBuffer.append("<th width= '5%'>Cost(Rs.)");
				sBuffer.append("</th>");
				sBuffer.append("</thead></tr><tbody>");
			 
			 
				/*
				 * sBuffer.
				 * append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='#1277B5'>"
				 * ); sBuffer.append("<tr>");
				 * sBuffer.append("<td width='33%' class='multiRPTLabel'></td>");
				 * sBuffer.append("<td width='13%' class='multiRPTLabel'></td>");
				 * sBuffer.append("<td width='10%' class='multiRPTLabel'></td>");
				 * sBuffer.append("<td width='10%' class='multiRPTLabel'></td>");
				 * sBuffer.append("<td width='10%' class='multiRPTLabel'></td>");
				 * sBuffer.append("<td width='13%' class='multiRPTLabel'></td>");
				 * sBuffer.append("<td width='10%' class='multiRPTLabel'></td>");
				 * sBuffer.append("</tr>"); sBuffer.append("</table>");
				 */
			while(wb.next())
			{		     	
				
				
				strHiddenId = wb.getString(1); //item id^itemBrandId^groupId^subGroupId 
												//total cost^unit id^rate unit^rate^rateunitid^base value
												//^manufdate^consumable^issueUnit^returnUnit
					strBrdName = wb.getString(2);
					strBtchSlNo = wb.getString(3);
					strExpiryDt = wb.getString(4);
					strBalQty = wb.getString(5);
					
					String[] temp = strHiddenId.replace("^", "#").split("#");
					
				//	totalCost = temp[4];
					unitId = temp[5];
					rateUnit = temp[6];
					rate = temp[7];
					rateUnitId = temp[8];
					baseValue = temp[9];
					manufDate = temp[10];
					consumable = temp[11];
					issueUnit = temp[12];
					returnUnit = temp[13];
					
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
  					
  					sBuffer.append("<tr>");
  					sBuffer.append("<td width= '30%' align='left'>");
  					
  					sBuffer.append(strBrdName+""+
  							"<input type='hidden' name='strItem' id='strItem" + i
	  							+"' value='"+ rateUnit+ '@'+ manufDate +'@'+ consumable +"'/>");

  					
  					sBuffer.append("</td>");
  					 sBuffer.append("<td width= '15%' align='center'>");
  					 	sBuffer.append(strBtchSlNo);
  					 sBuffer.append("</td>");
  					 sBuffer.append("<td width= '15%' align='center'>");
  					 	sBuffer.append(strExpiryDt);
  					 sBuffer.append("</td>");
  					 sBuffer.append("<td width= '10%' align='center' name='strBalanceQty' id='strBalanceQty'"+i+"'>");
  					 		sBuffer.append(strBalQty+"<input type='hidden' name='balQty' id='balQty" + i
						+"' value='"+ issueUnit+ '@'+ returnUnit +"'/><input type='hidden' name='strBalQty' id='strBalQty" + i
						+"' value='"+ strBalQty+"'/></td>");
				
  					 sBuffer.append("<td width= '10%' align='center'>");
  					 	sBuffer.append(
  							"<input type='text' maxlength='8' autocomplete='off' onkeypress='return validateData(event,7);', onkeyup='quantityUnitValue("+i+");'"  +
  							"name='strReturnQty' id='strReturnQty"
							+ i
							+ "' class='form-control' value=''>");
  					 sBuffer.append("</td>");
  					 
  					 sBuffer.append("<td width= '15%'>");
  					 		sBuffer.append(
  							"<Select name='strReturnQtyUnitId' disabled='disabled' class='browser-default custom-select' id='strReturnQtyUnitId"   
							+ i 
							+ "' onchange='quantityUnitValue("+i+");'>"
							+ strReturnUnitCombo + "</select>");
  					
  					 sBuffer.append("</td>");
  					 sBuffer.append("<td width= '5%' align='center'>");
  					sBuffer.append("<div id='strTotalCostDivId"+i+"'>0.00</div>" +
  							"<input type='hidden' name='strTotalCost' id='strTotalCost" + i
  							+"' value='0'/><input type='hidden' name='strRate' id='strRate" + i
  							+"' value='"+ rate+"@"+ rateUnitId+"@"+baseValue+"'/><input type='hidden' name='strHidParamVal' id='strHidParamVal" + i
  							+"' value='"+wb.getString(1)+"'/>");	  					
  					
  					 
 					 sBuffer.append("</td></tr>");

								
  					i++;  						
  				}
				 sBuffer.append("</td></tr></tbody></table>");

			sBuffer.append("<br><div class='row rowFlex reFlex'>");
			sBuffer.append("<div class='col-md-8'>");sBuffer.append("</div>");
			sBuffer.append("<div class='col-md-2'>Net Cost(Rs):");sBuffer.append("</div>");
			
			sBuffer.append("<div class='col-md-2' style='color: red; font-weight: bold'><div id='strNetCostDivId' align='center'>0.00</div><input type='hidden' name='strNetCost' id='strNetCost' value='0'/>");sBuffer.append("</div>");
			
			sBuffer.append("</div>");
			
			
				
		 }else
		 {
			 sBuffer.append("<div class='row rowFlex reFlex'>");
			 sBuffer.append("<div class='col-md-12' style='text-align: center;color: red;'>No Record Available");sBuffer.append("</div>");
			 sBuffer.append("</div>");
				/*
				 * sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>"
				 * ); sBuffer.append("<tr>");
				 * sBuffer.append("<td width='100%' class='LABEL' ></td>"); //sBuffer.
				 * append("<td width='10%' class='CONTROL' style='color: red; font-weight: bold'><div id='strNetCostDivId' align='center'>0.00</div>"
				 * ); sBuffer.append("</tr>"); sBuffer.append("</table>");
				 */
		 }
   
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
			return "ERROR";

     }
    return sBuffer.toString();
 	}

	public static String getItem_ALL_LIST(String strItemCategoryNo,
		String strHospitalCode, WebRowSet wb, String strStoreId)
	{
	StringBuffer sBuffer = new StringBuffer("");
	

	ReturnFromTransVO vo=null;
	ReturnFromTransBO bo= null;
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
	String issueNo = "";
	String strOrgIssueStore="";
	
	int i = 0;
	
	
	 try {
		 
		 bo = new ReturnFromTransBO();
		 vo = new ReturnFromTransVO();
		
		
		 hisutil = new HisUtil("MMS","ReturnFromTransHLP");
		 
		 if(wb.size() != 0){
		 
				sBuffer.append("<table class='table' id='data-table'><tr><thead class='thead-dark'>");
				sBuffer.append("<th width= '30%'>Drug Name");
				sBuffer.append("</th>");
				sBuffer.append("<th width= '15%'>Batch");
				sBuffer.append("</th>");
				sBuffer.append("<th width= '15%'>Expiry Date");
				sBuffer.append("</th>");
				sBuffer.append("<th width= '10%'>Balance Qty");
				sBuffer.append("</th>");
				sBuffer.append("<th width= '10%' ><font color='red'>*</font>Return Qty");
				sBuffer.append("</th>");
				sBuffer.append("<th width= '15%'><font color='red'>*</font>Return Qty Unit");
				sBuffer.append("</th>");
				sBuffer.append("<th width= '5%'>Cost(Rs.)");
				sBuffer.append("</th>");
				sBuffer.append("</thead></tr>");
			 
			while(wb.next())
			{		     	
				
				
				    strHiddenId   = wb.getString(1); //item id^itemBrandId^groupId^subGroupId 
												//total cost^unit id^rate unit^rate^rateunitid^base value
												//^manufdate^consumable^issueUnit^returnUnit
					strBrdName       = wb.getString(2);
					strBtchSlNo      = wb.getString(3);
					strExpiryDt      = wb.getString(4);
					strBalQty        = wb.getString(5);
					issueNo       	 = wb.getString(6);
					strOrgIssueStore = wb.getString(7);
					
					String[] temp = strHiddenId.replace("^", "#").split("#");
					
				//	totalCost = temp[4];
					unitId       = temp[5];
					rateUnit     = temp[6];
					rate         = temp[7];
					rateUnitId   = temp[8];
					baseValue    = temp[9];
					manufDate    = temp[10];
					consumable   = temp[11];
					issueUnit    = temp[12];
					returnUnit   = temp[13];
					
					vo.setStrIssueQtyUnitId("6301");
					vo.setStrHospitalCode(strHospitalCode);
  					
					vo.setStrIssueQtyUnitId(unitId);
					vo.setStrHospitalCode(strHospitalCode);
					
									  					
  					if (vo.getStrMsgType().equals("1")) {
						throw new Exception(vo.getStrMsgString());
					}
  					
  					
  					/*
  					 * 
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
  					*/
  					strReturnUnitCombo = "<option title='No.' selected='' value='6301^1^0'>No.</option>";  	
  					
  					if(strExpiryDt == null || strExpiryDt.equals("null") || strExpiryDt.equals(""))strExpiryDt = "---";
  					if(strBrdName == null || strBrdName.equals("null") || strBrdName.equals("") )strBrdName = "---";
  					if(strBtchSlNo == null || strBtchSlNo.equals("null") || strBtchSlNo.equals(""))strBtchSlNo = "---";
  					if(strBalQty == null || strBalQty.equals("null") || strBalQty.equals(""))strBalQty = "---";
  					
  					sBuffer.append("<tr>");
  					sBuffer.append("<td width= '30%' align='left'>");
  					
  					sBuffer.append(strBrdName+""+
  							"<input type='hidden' name='strItem' id='strItem" + i
	  							+"' value='"+ rateUnit+ '@'+ manufDate +'@'+ consumable +"'/>");

  					
  					sBuffer.append("</td>");
  					 sBuffer.append("<td width= '15%' align='center'>");
  					 	sBuffer.append(strBtchSlNo);
  					 sBuffer.append("</td>");
  					 sBuffer.append("<td width= '15%' align='center'>");
  					 	sBuffer.append(strExpiryDt);
  					 sBuffer.append("</td>");
  					 sBuffer.append("<td width= '10%' align='center' name='strBalanceQty' id='strBalanceQty'"+i+"'>");
  					 		sBuffer.append(strBalQty+"<input type='hidden' name='balQty' id='balQty" + i
						+"' value='"+ issueUnit+ '@'+ returnUnit +"'/><input type='hidden' name='strBalQty' id='strBalQty" + i
						+"' value='"+ strBalQty+"'/></td>");
  					 		
  					 		sBuffer.append("<input type='hidden' name='strIssueNoList' id='strIssueNoList" + i +"' value='"+ issueNo+"'/>");
  					 		sBuffer.append("<input type='hidden' name='strOrgIssueStoreList' id='strOrgIssueStoreList" + i +"' value='"+ strOrgIssueStore+"'/>");
  					 		
				
  					 sBuffer.append("<td width= '10%' align='center'>");
  					 	sBuffer.append(
  							"<input type='text' maxlength='8' autocomplete='off' onkeypress='return validateData(event,7);', onkeyup='quantityUnitValue("+i+");'"  +
  							"name='strReturnQty' id='strReturnQty"
							+ i
							+ "' class='form-control' value='0'>");
  					 sBuffer.append("</td>");
  					 
  					 sBuffer.append("<td width= '15%'>");
  					 		sBuffer.append(
  							"<Select name='strReturnQtyUnitId' disabled='disabled' class='browser-default custom-select' id='strReturnQtyUnitId"   
							+ i 
							+ "' onchange='quantityUnitValue("+i+");'>"
							+ strReturnUnitCombo + "</select>");
  					
  					 sBuffer.append("</td>");
  					 sBuffer.append("<td width= '5%' align='center'>");
  					sBuffer.append("<div id='strTotalCostDivId"+i+"'>0.00</div>" +
  							"<input type='hidden' name='strTotalCost' id='strTotalCost" + i
  							+"' value='0'/><input type='hidden' name='strRate' id='strRate" + i
  							+"' value='"+ rate+"@"+ rateUnitId+"@"+baseValue+"'/><input type='hidden' name='strHidParamVal' id='strHidParamVal" + i
  							+"' value='"+wb.getString(1)+"'/>");	  					
  					
  					 
 					 sBuffer.append("</td></tr>");

								
  					i++;  						
  				}
				 sBuffer.append("</td></tr></table>");

			sBuffer.append("<br><div class='row rowFlex reFlex'>");
			sBuffer.append("<div class='col-md-8'>");
			sBuffer.append("</div>");
			sBuffer.append("<div class='col-md-2'>Net Cost(Rs):");
			sBuffer.append("</div>");
			
			sBuffer.append("<div class='col-md-2' style='color: red; font-weight: bold'><div id='strNetCostDivId' align='center'>0.00</div><input type='hidden' name='strNetCost' id='strNetCost' value='0'/>");sBuffer.append("</div>");
			
			sBuffer.append("</div>");
			
			
				
		 }else
		 {
			 sBuffer.append("<div class='row rowFlex reFlex'>");
			 sBuffer.append("<div class='col-md-12' style='text-align: center;color: red;'>No Record Available");
			 sBuffer.append("</div>");
			 sBuffer.append("</div>");
				/*
				 * sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>"
				 * ); sBuffer.append("<tr>");
				 * sBuffer.append("<td width='100%' class='LABEL' ></td>"); //sBuffer.
				 * append("<td width='10%' class='CONTROL' style='color: red; font-weight: bold'><div id='strNetCostDivId' align='center'>0.00</div>"
				 * ); sBuffer.append("</tr>"); sBuffer.append("</table>");
				 */
		 }
   
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
			return "ERROR";

     }
    return sBuffer.toString();
 	}
	
	public static String getIssueDtlsInitViewNEW(ReturnFromTransFB formBean) throws Exception {

		StringBuffer sb = new StringBuffer("");
		String strIssueBy = "";
		String strRecivedBy = "";
		String strPurchaseCost="";
		String strRemarks="";
		/*
		String str2 = "76.39";
		float f = Float.parseFloat(str2);
		String str = "5";
		Float f = new Float(str);
		double d = f.doubleValue();
		
		*/
		double cltamt  = 0.00;
		double totalCost = 0.00;
		
		double cltamt1  = 0.00;
		double totalCostWithoutSC = 0.00;
		
		
		String strStoreName="";
		 String returnTo="";
		int i=1;
		String strItemTotCost="0.00";
		String strItemTotCostWithOutSC ="0.00";
		String strBudgetUsed ="0.00";
		HisUtil util = new HisUtil("mms", "getIssueDtlsInitView");
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(formBean.getStrHospitalCode());	
		
		String configIssueRate = mmscofigutil.getStrConfigIssueRate();
		DecimalFormat myFormatter = new DecimalFormat("0.00");

		WebRowSet ws = formBean.getWsIssueDetails();
        
		String strIssueDate = "";

		if (formBean.getStrIssueDate().length() > 2) 
		{
			strIssueDate = formBean.getStrIssueDate();
		}
		
		String strTableWidth = "825";

		try 
		{			
			
			sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
					+ " <tr> "					
					+ " <td colspan='12'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>");
			sb.append("</tr></table>");
			

			if (formBean.getStrModeVal().equals("3")) 
			{

				sb.append(
								"<TABLE class='table table-striped' ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
						.append(strTableWidth)
						.append(
								"'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Report For&nbsp;Third Party Issue Details</b></font></td></tr></table> ");

			} 
			else 
				if 
				(formBean.getStrModeVal().equals("4")) 
				{
				sb
						.append(
								"<TABLE class='table table-striped' ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
						.append(strTableWidth)
						.append(
								"'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Report For&nbsp;Acknowledge</b></font></td></tr></table> ");
			} 
			else 
			{
				if(!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6"))
				{
				     sb.append("<TABLE class='table table-striped' ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
						.append(strTableWidth)
						.append("'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>Report For&nbsp;Issue Details</b></font></td></tr></table> ");
				}
				else
				{
					sb.append("<TABLE class='table table-striped' ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
					.append(strTableWidth)
					.append("'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Report For&nbsp;Return Details</b></font></td></tr></table> ");

					
				}	

			}

			if (formBean.getStrStoreName().length() != 0) 
			{
				if(!formBean.getStrModeVal().equals("4"))
				{
				sb.append(
								"<TABLE class='table' ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
						.append(strTableWidth).append(
								"'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>(").append(
								formBean.getStrStoreName()).append(
								")</b></font></td></tr></table>");
				}
				else
				{
					sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
				.append(strTableWidth).append(
						"'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>Acknowledging Store : ").append(
						formBean.getStrStoreName()).append(
						"</b></font></td></tr></table>");
				}

			}
			
			
			sb.append("<table border='0' width='").append(strTableWidth)
					.append("' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
            /*   Hide Save Button by Amit 24-Sep-2010
			 
			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'> <img style='cursor: pointer; ' title='Save Page'  ");
			sb.append(" src='../../hisglobal/images/save_all.png' onClick='saveData(\"").append(formBean.getStrIssueNo())
					.append("\");' /> <img style='cursor: pointer; ' title='Print Page'  ");
			*/
			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			sb.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopup(),cancelToDesk();' /> </div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			sb.append(" <br> ");
			sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");

			
			if(!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6"))
			{	

				sb.append("<tr> ");
	
				sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Issue No. :", 15,0)).append(formBean.getStrIssueNo())
						.append("</b></font></td> ");
	
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Issue Date", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strIssueDate).append(
						"</b></font></td> ");
				sb.append("</tr> ");
							
				if (!formBean.getStrIndentNo().equals("0")) 
				{
					sb.append("<tr> ");
					sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Request No. :", 15,0)).append(formBean.getStrIndentNo())
							.append("</b></font></td> ");
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Request Date", 15,0)).append(	":</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							formBean.getStrIndentDate()).append("</b></font></td> ");
					sb.append("</tr> ");
	
				}
				if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("4"))
				{
					
					
					//formBean.setUsrArg(formBean.getWsIssueDetails().getString(35));  // Pass Patient Hidden  Value
					/*
					 *  General
					 * ^Venkataappaiah Posani - 83 Yr/Male
					 * ^0
					 * ^0
					 * ^Hanumaiah
					 * ^0
					 * ^Hospital Management Information System
					 * ^12-MAR-2019 11:21:46
					 * ^-
					 * ^NO
					 * ^Dental
					 * ^Dental Unit 1
					 * ^General
					 * ^Cubicle 07
					 * ^Cub07 111
					 * ^General
					 * ^Navaneeth Y
					 * ^No
					 * ^0
					 * ^379132022000039
					 * ^03-Nov-2022 11:58:35
					 * 
					 */
					/*
					 * 0 - Dept Name                                            
				       1 - Dept Unit Name                                       
				       2 - Ward Name                                                      
				       3 - Room No                                             
				       4 - Bed No                                               
				       5 - Patient Catg                                         
				       6 - Consultant Name                                       
				       7 - IS New Born                                          
				       8 - Bill Catg 
				       9 - Addmission No
				      10 - Admission Date 						
					  11 - General                                              Patient Category
				      12 - Gabru Jawan - 25 Yr/Male[ 279162100000665 ]          Patient Dtls
				      13 - 0                                                    HRGNUM_IS_MLC            
				      14 - 0                                                    HRGNUM_ISNEWBORN  
				      15 - Sdds                                                 HRGSTR_FATHER_NAME
				      16 - 0                                                    HRGNUM_IS_DEAD
				      17 - All India Institute of Medical Sciences, Nagpur      HOSP_NAME 
				      18 - 03-MAY-2021 18:11:02                                 ADDMISSION DATE
				      19 -                                                      HRGSTR_EMG_CNTC
				      20 - NO                                                   HRGNUM_ISNEWBORN 
					 * 
					 * */
					
					sb.append("<tr> ");
					sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Issue To :", 15,0)).append(formBean.getStrIssueTo().split("@")[0])
							.append("</b></font></td> ");
					if(!formBean.getStrModeVal().equals("2") && !formBean.getStrModeVal().equals("4")){
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("CR No.:", 15,0)).append("</b></font></td> ");
					sb.append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							formBean.getStrCrno()).append("</b></font></td> ");
					}
					sb.append("</tr> ");
					
					
					
				
				    sb.append("<tr><TD COLSPAN='4'>&nbsp;</td></tr>");
				}
				else
				{
					sb.append("<tr> ");
					if(!formBean.getStrModeVal().equals("4"))
					{
						sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Issue To", 15,0)).append(":</b></font></td> ");
						sb.append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							formBean.getStrIssueTo().split("@")[0]).append("</b></font></td> ");
						
						sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("", 15,0)).append("</b></font></td> ");
						sb.append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("</b></font></td> ");
					}
					else
					{
						sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("Issuing Store :", 15,0)).append(formBean.getStrOrgName())
								.append("</b></font></td> ");	
							sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Indent Type : </b></font></td> ");
							sb.append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue to Store</b></font></td> ");
					}
	
					
					
					sb.append("</tr> ");
				
				    sb.append("<tr><TD COLSPAN='4'>&nbsp;</td></tr>");
					
				}	
			}
			else
			{
				sb.append("<tr> ");
				
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Return No.", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(formBean.getStrIssueNo())
						.append("</b></font></td> ");
	
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Return Date", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strIssueDate).append(
						"</b></font></td> ");
				sb.append("</tr> ");
							
				if(formBean.getStrModeVal().equals("5") && formBean.getStrModeVal().equals("6"))
				{
					if(formBean.getStrReturnReqNo()!=null && !formBean.getStrReturnReqNo().equals("") && !formBean.getStrReturnReqNo().equals("0"))
					{
						sb.append("<tr> ");
						sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>&nbsp;").append(
								util.appendSpace("Return Req. No.", 15,0)).append(
								":</b></font></td> ");
						sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								formBean.getStrReturnReqNo()).append("</b></font></td> ");
						sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>&nbsp;").append(
								util.appendSpace("Return Req. Date", 15,0)).append(
								":</b></font></td> ");
						sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								formBean.getStrIndentDate()).append("</b></font></td> ");
						sb.append("</tr> ");
					}
				}
					
	               
					if (ws != null && ws.size() > 0) 
					{

						while (ws.next()) 
						{
							returnTo = ws.getString(4);
							
						}
						ws.beforeFirst();
					}	
					sb.append("<tr> ");
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Return From", 15,0)).append(":</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							formBean.getStrIssueTo().split("@")[0]).append("</b></font></td> ");
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Return To", 15,0)).append(":</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							returnTo).append("</b></font></td> ");


					sb.append("</tr> ");
				
			}				
			
			sb.append("</table> ");

			sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");

			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
			sb.append("</td>");
						
			sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
			sb.append("</td>");

			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch/Serial No.</b></font> ");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font>");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit</b></font> ");
			sb.append("</td> ");
			if(!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6"))
			{
			   sb.append("<td align='center' width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty</b></font>");
			   sb.append("</td> ");
			   if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("5"))
				{

			      sb.append("<td align='center' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost</b></font>");
			      sb.append("</td> ");
				}
			}
			else
			{
				sb.append("<td align='center' width='14%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Return Qty</b></font> ");
				sb.append("</td> ");
				 sb.append("<td align='center' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost</b></font>");
			      sb.append("</td> ");
			}	
			sb.append("</tr> ");

			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{
					NumberFormat formatter = new DecimalFormat("############.##");  	

					if (formBean.getStrModeVal().equals("4")) 
					{
						
						strIssueBy              = ws.getString(28);
						strRecivedBy            = ws.getString(27);
						strItemTotCost  		= ws.getString(30);
						strPurchaseCost 		= ws.getString(32);
						strItemTotCost          = formatter.format(new BigDecimal(ws.getString(30)));						
						if(ws.getString(33) == null || ws.getString(33).equals(""))
							strItemTotCostWithOutSC = "0";
						else
							strItemTotCostWithOutSC = formatter.format(new BigDecimal(ws.getString(33)));
					} 
					else 
					{
						if (formBean.getStrModeVal().equals("2"))
						{							
							strStoreName    		= ws.getString(4);	
							strRemarks              = ws.getString(27);
							strRecivedBy    		= ws.getString(28);
							strItemTotCost          = ws.getString(29);
							
							strPurchaseCost         = ws.getString(33);  // With Unit Like e.g. 161 No.
												    
							strItemTotCost          = formatter.format(new BigDecimal(ws.getString(29)));  
							strItemTotCostWithOutSC = formatter.format(new BigDecimal(ws.getString(34)));
						//	strBudgetUsed           = formatter.format(new BigDecimal(ws.getString(35)));
						}
						else
						{
							if(formBean.getStrModeVal().equals("3"))
							{
								
							//	strRemarks   = ws.getString(25);
							//	strRecivedBy = ws.getString(26);
							}
							else
							{
								if(formBean.getStrModeVal().equals("1") || formBean.getStrModeVal().equals("6"))
								{
									
									if(formBean.getStrModeVal().equals("1"))
									{
										strRemarks   = ws.getString(26);
										strRecivedBy = ws.getString(25);
									}
								
									strItemTotCost = formatter.format(new BigDecimal(Double.parseDouble(formatter.format(new BigDecimal(ws.getString(16)))) * Double.parseDouble(ws.getString(19))));
								}
							}
						}
						
					}
					
					cltamt1  = Double.parseDouble(strItemTotCostWithOutSC);
					
					totalCostWithoutSC = totalCostWithoutSC + cltamt1;   //Calculate Total Cost Without Service Charge
					 
					cltamt  = Double.parseDouble(strItemTotCost);    
										
					totalCost = totalCost + cltamt;                      //Calculate Total Cost With Service Charge
											
					sb.append("<tr> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(i);
					sb.append("</b></font></td> ");
					
					
					sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>");
					sb.append(ws.getString(6));
					sb.append("</b></font></td> ");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(7));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(8));//debug
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:center;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(9));
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:center;\" width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(10));
					sb.append("</font></td> ");
					if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("5") )
					{

						sb.append("</font></td> ");  
						sb.append("<td style=\"text-align:right;\" width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(myFormatter.format(new BigDecimal(strItemTotCost)));
						//myFormatter.format(Double.parseDouble(ws.getString(6)))
						sb.append("</font></td> ");  
					}
					if(formBean.getStrModeVal().equals("5"))
					{
						sb.append("</font></td> ");  
						sb.append("<td style=\"text-align:right;\" width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(myFormatter.format(new Float(ws.getString(10).split(" ")[0])*new Float(ws.getString(9).split("/")[0])));
						//myFormatter.format(Double.parseDouble(ws.getString(6)))
						sb.append("</font></td> ");  
					}
					sb.append("</tr> ");
					i++;
								
				}
								
				if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("5"))
				{	
					NumberFormat formatter = new DecimalFormat("############.##");  
				    					
					String ServiceCharge ="";
					
					String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
					
					sb.append("<tr>");
					sb.append("<td colspan='6' align='left'><hr size='2'></td>");
					sb.append("<td colspan='1' align='center'><hr size='2'></td>");
					
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td colspan='6' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><div align='right'><b>TOTAL Rs.(Round)</b></div></font></td>");
					sb.append("<td colspan='1' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					//sb.append(myFormatter.format(Double.parseDouble(FinaltotalCost)));	
					sb.append(Math.round(Double.parseDouble(FinaltotalCost)));
					sb.append("</font></td>");
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td colspan='6' align='left'><hr size='2'></td>");
					sb.append("<td colspan='1' align='center'><hr size='2'></td>");
					
					sb.append("</tr>");
					
					
					if(formBean.getStrModeVal().equals("2") || formBean.getStrModeVal().equals("4"))  // To Show Issue Off-Line Voucher
					{
						
						/*
						  Total 33 Value Return In Case of ModeVal 2 (Which Call in Case of Off-Line Issue Voucher)
						  1.Issue No
						  2.Issue Date
						  3.Issue To 
						  4.Issue By
						  5.Generic Name
						  6.Brand Name
						  7.Batch No
						  8.Expiry date
						  9.Issue rate
						  10.Issue Qty
						  11.Store Id
						  12.Item Id
						  13.Item Brand ID
						  14.Batch No
						  15.Expiry Date
						  16.Issue Rate
						  17.Issue Rate Unit Id
						  18.Issue Rate Base Unit Id
						  19.Issue Qty
						  20.Issue Qty Unit Id
						  21.Issue Qty Base Value
						  22.Item Sl No
						  23.Item SL No
						  24,Category Code
						  25.Issue Qty
						  26.Remarks
						  27.Final remarks
						  28.Received By
						  29.Cost
						  30.Total Avl Budget
						  31.Indent No
						  32.Indent Date
						  33.Purchase Rate e.g 101 No.
						  34.Cost With Purchae Rate 
						  35.Budget Used
						 */
						String FinaltotalCostWithoutSc = formatter.format(new BigDecimal(totalCostWithoutSC)); 
						if(configIssueRate.equals("") || configIssueRate == null)
							configIssueRate = "0";
						double IssueRatePercentage  = Double.parseDouble(configIssueRate);
						//System.out.println("IssueRatePercentage==>"+IssueRatePercentage);
						//System.out.println("Total Cost Of Item Without SC==>"+FinaltotalCostWithoutSc);
						//System.out.println("Total Cost of Ite With SC==>"+FinaltotalCost);
						
						double PurchaseCost         =  Double.parseDouble(strItemTotCost);
						//double serviceCharge        = totalCost *((IssueRatePercentage-100)/100);
						double serviceCharge        = totalCost - totalCostWithoutSC;
						
						ServiceCharge        = formatter.format(new BigDecimal(serviceCharge));
						//System.out.println("Service Charge==>"+ServiceCharge);
						
						double costWithServiceChag = totalCostWithoutSC + serviceCharge;								
						
					}	
				
				}
				if (formBean.getStrModeVal().equals("4")) 
				{

					
					sb.append("<tr> "); 
					sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
					sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");
					sb.append(formBean.getStrFinalRemarks());
					sb.append("<br></font></td>");
			        sb.append("</tr> ");
					
					
					sb.append("<tr> ");
					if(!formBean.getStrModeVal().equals("4"))
					{
						sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Issued By<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("</tr> ");
						sb.append("<tr> ");
	//					sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>(").append(strRecivedBy).append(")<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>").append("<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>(")
								.append(strIssueBy).append(
										")<br><b> &nbsp;&nbsp;</font></td> ");
					}
					else
					{
						sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br>.</font></td> ");
						sb.append("<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Acknowledged By :").append(formBean.getStrIssueTo().split("@")[1]).append("<br><b> &nbsp;&nbsp;</font></td> ");
					}
					sb.append("</tr> ");

				} 
				
				else 
				{

					if(!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6"))
					{
						if(!formBean.getStrModeVal().equals("3"))
						{	
							
					        sb.append("<tr> "); 
							sb.append("<td colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Received By:</font></td>");
							sb.append("<td colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif'>");							
							sb.append(strRecivedBy.trim());									
							sb.append("</font></td>");
					        sb.append("</tr> ");   							
					        sb.append("<tr> "); 
							sb.append("<td colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Remarks:<b></font></td>");
							sb.append("<td colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif'>");
							System.out.println("check Params::"+formBean.getStrFinalRemarks());
							
							
							/*if(!formBean.getStrFinalRemarks().equals("")||!formBean.getStrFinalRemarks().equals(" ")||!formBean.getStrFinalRemarks().equals(null))
							{
							    sb.append(formBean.getStrFinalRemarks().trim());
							} 
							else
							{
								sb.append("--------");	
							}	*/
							sb.append(strRemarks);	
							sb.append("</font></td>");
					        sb.append("</tr> ");      
					        sb.append("<tr> ");
					        if(formBean.getStrModeVal().equals("1"))
					        {
					        	sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>[ &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;"+formBean.getStrUserName()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;]<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
					        	sb.append("</tr> ");      
							    sb.append("<tr> ");
					        	sb.append("<td colspan='8' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>* In case of not issued items , kindly contact billing desk for refund.<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
					        }
					        else{
					        	sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>Issued By : "+formBean.getStrIssueTo().split("@")[1]+"<b>&nbsp;&nbsp;</font></td> ");	
					        }
							
							sb.append("</tr> ");
							//sb.append("<tr> ");
							//sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Issued By on Behalf of RMSCL<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
							//sb.append("</tr> ");
							
						}
						else
						{
							if(formBean.getStrModeVal().equals("3"))
							{
							
								sb.append("<tr> "); 
								sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
								sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");
								sb.append(strRemarks);	
								sb.append("<br></font></td>");
						        sb.append("</tr> ");
								sb.append("<tr> ");
								sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");
								sb.append("<tr> ");
								sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>(").append(strRecivedBy).append(
												")<b> &nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");
								
							}
							else
							{
								sb.append("<tr> "); 
								sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
								sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");								
								sb.append(strRemarks);										
								sb.append("<br></font></td>");
						        sb.append("</tr> ");								
								sb.append("<tr> ");
								sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");
								sb.append("<tr> ");
								sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>(").append(strRecivedBy).append(
												")<b> &nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");
							}
						}	
						
										
					}
					else
					{
						
						sb.append("<tr> ");
						sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Received By : "+formBean.getStrIssueTo().split("@")[1]+"<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("</tr> ");
						
					}	
				}

			} 
			else 
			{

				sb.append("<tr> ");
				sb
						.append("<td colspan='8' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available/Requested Qty not available</b><br/><br/></font></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}
		finally {
			mmscofigutil = null;
		}

		return sb.toString();
	}
	
	public static String getAfterSaveVoucher(ReturnFromTransVO vo,String mode) throws Exception {
	      StringBuffer sb = new StringBuffer("");
	      int i = 1;
	      ResourceBundle res = null;
	      WebRowSet ws = null;
	      String strTableWidth = "825";

	      try {
	        
	    	  
	    	  sb.append("<table  width='850' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
						+ " <tr> "
						+ " <td colspan='12'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td></tr>");
	    	  if(mode.equals("1"))
	    	  {
	    		  sb.append("<tr><td colspan='12'><td colspan='1'><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printData_O();' /><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/stop.png' onClick='hideIssuePopup();' /></div></td></tr>");
	    	  }
	    	  else
	    	  {
	    		  sb.append("<tr><td colspan='12'><td colspan='1'><div id='printImg' align='right'></div></td></tr>");
	    	  }
	    	  sb.append("</table>");
				        
	         sb.append("<table width='850' align='center' cellpadding='1px' cellspacing='1px'> ");
	         sb.append("<tr>");
	         sb.append("<td width='850' align='center' colspan='5'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Return</b></font></td> ");
	        

	         /*
	       		0	   NVL(HIPNUM_ADMNO, '0') 
	       		1	^  NVL(HRGNUM_EPISODE_CODE, '0') 
	       	    2	^  NVL(HRGNUM_VISIT_NO,'0') 
	       		3	^  NVL(TO_CHAR(HIPDT_ADMDATETIME,'DD-Mon-YYYY HH24:MI:SS'),' ')
	       		4	^  NVL(HIPNUM_ADM_ADVNO,'0') 
	       		5	^  NVL(GNUM_DEPT_CODE,'000')
	       		6	^  NVL(HIPNUM_WARD_CODE,'0') 
	       		7	^  NVL(HIPNUM_ROOM_CODE,'0') 
	       		8	^  NVL(HIPNUM_BED_CODE,'0')
	       		9	^  NVL(HIPNUM_TREAT_CATEG_CODE,'0')  
	       	   10	^  NVL(HIPNUM_ISNEWBORN,'0') 
	       	   11	^  NVL(HIPNUM_MOTHADMNO,'0') 
	       	   12	^  NVL(HRGNUM_MLC_NO,'0')
	       	   13	^  NVL(HIPNUM_OCCUP_ID,'0') 
	       	   14	^  NVL(TO_CHAR(HIPDT_BEDALLOC_DATETIME,'DD-Mon-YYYY HH24:MI:SS'),' ') 
	       	   15	^  NVL(HIPNUM_LENGTHOFSTAY,'0'))
	       	   16	^  NVL(GNUM_DEPTUNIT_CODE,'00000')
	       	   17	^  hblnum_pataccount_status
		*/		
						
						
				/* vo.getStrPatientDtlHidVal()
	              HRGDT_DOB || ''^'' ||GNUM_GENDER_CODE ||''^''||HGNUM_PAT_STATUS_CODE || ''^''||
		          HGNUM_PATIENT_CAT_CODE || ''^'' ||HRGNUM_IS_MLC    ||''^''||HRGNUM_ISNEWBORN      || ''^''|| HRGNUM_ID_NO
				*/
				// By Vivek	
	         sb.append("</tr>");	        
	         sb.append("<tr> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>").append("CR No:</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>").append(vo.getStrCrno()).append("</font></td> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>").append("Store:</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif'  size='1'>"+vo.getStrStoreName()+"</font></td> ");
	         sb.append("</tr>");
	         
	         sb.append("<tr> ");	         
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>").append("Return No:</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif'  size='1'>").append(vo.getStrIssueNo()).append("</font></td> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>").append("Return Date:</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif'  size='1'>").append(vo.getStrIssueDate()).append("</font></td> ");
	         sb.append("</tr> ");
	         sb.append("<tr> ");
	         sb.append("<table width='850' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
	         sb.append("<tr>");
	         sb.append("<td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif'  size='1'>");
	         sb.append(vo.getStrPatientDtl());
	         sb.append("</font></td> ");
	         sb.append("</tr> ");
	         sb.append("</table>");     
	        
	         sb.append("<table class='custom-table' width='850' align='center' cellpadding='1px' cellspacing='1px' border='0px solid'> ");
	         sb.append("<tr bgcolor='#cdc9c9'> ");
	         sb.append("<td align='center' width='5%' style='border: 1px solid black;'><font  face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>S No.</b></font> ");
	         sb.append("</td>");
	         sb.append("<td align='center' width='39%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>Product</b></font> ");
	         sb.append("</td>");
	         sb.append("<td align='center' width='8%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>Batch No.</b></font> ");
	         sb.append("</td> ");
	         sb.append("<td align='center' width='8%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>Expiry</b></font>");
	         sb.append("</td> ");	       
	         sb.append("<td align='center'  width='8%' style='border: 1px solid black;'><font  face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>Qty</b></font>");
	         sb.append("</td> ");
	         sb.append("<td align='center'  width='8%' style='border: 1px solid black;'><font  face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>MRP</b></font>");
	         sb.append("</td> ");
	         sb.append("<td align='center'  width='8%' style='border: 1px solid black;'><font  face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>Rate</b></font>");
	         sb.append("</td> ");
	         sb.append("<td align='center'  width='8%' style='border: 1px solid black;'><font  face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>DIS(%)</b></font>");
	         sb.append("</td> ");
	         sb.append("<td align='center'  width='8%' style='border: 1px solid black;'><font  face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>Cost</b></font>");
	         sb.append("</td> ");
	         sb.append("</tr> ");
	        
	         float NetAmount = 0.0F;
	        /* String rem = "";
	         String user = "";*/
	         double  dis,markedprice,salePrice,per;
	         ws = vo.getWsIssueDetails();
	       
				if (ws != null && ws.size() > 0) 
				{

					while (ws.next()) 
					{	
						/*
			            1. Return No
			            2. Return Date
			            3. Patient Name ( Cr No ) @ issue By
			            4. Store Name
			            5. Generic Name
			            6. Brand Name
			            7. Batch No
			            8. Expiry Date 
			            9. Rate Wth Unit
			           10. Issue Qty wth Unit
			           11. Store Id
			           12. Item Id
			           13. Brand Id
			           14. Batch No
			           15. Exp Date
			           16. Rate Per Unit
			           17. Unit Id
			           18. Rate Base Value
			           19. NVL
			           20. Req Unit Id
			           21. Qty Base Value
			           22. SL No
			           23. Sl No
			           24. Catg Code
			           25. Rec by
			           26. Remarks
			           27.Loc @ Dl No
			           28.CR No
			           29.Mrp  
			           30.Cost of Item 
			         */
                       /*  
						    Discount = Marked Price � Selling Price
						    And Discount Percentage = (Discount/Marked price) x 100
					    */
						markedprice = Double.parseDouble(ws.getString(29));
						salePrice   = Double.parseDouble(ws.getString(16));
						
						if (markedprice == 0) {
						    dis = 0;  
						    per = 0;  
						} else {
						    dis = markedprice - salePrice;
						    per = (dis / markedprice) * 100;
						}
						
						sb.append("<tr> ");
						sb.append("<td align='center' width='5%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
						sb.append(i+".");
						sb.append("</font></td> ");					
						sb.append("<td align='left' width='39%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;' >");
						sb.append(ws.getString(6));
						sb.append("</font></td> ");
						sb.append("<td align='center' width='8%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;' >");
						sb.append(ws.getString(7));
						sb.append("</font></td> ");
						sb.append("<td align='center' width='8%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;' >");
						sb.append(ws.getString(8));
						sb.append("</font></td> ");
						sb.append("<td style='text-align:right;border: 1px solid black;' width='8%' ><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
						sb.append(ws.getString(10));
						sb.append("</font></td> ");
						sb.append("<td style='text-align:right;border: 1px solid black;' width='8%' ><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
						sb.append(ws.getString(29));
						sb.append("</font></td> ");
						sb.append("<td style='text-align:right;border: 1px solid black;' width='8%' ><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
						sb.append(ws.getString(16));
						sb.append("</font></td> ");
						sb.append("<td style='text-align:right;border: 1px solid black;' width='8%' ><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
						sb.append(Math.round(per));
						sb.append("</font></td> ");
						sb.append("<td style='text-align:right;border: 1px solid black;' width='8%' ><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
						sb.append(ws.getString(30));
						//sb.append(String.format("%.2f", Double.parseDouble(ws.getString(16).replaceAll("[^\\d.]", "")) * Double.parseDouble(ws.getString(10).replaceAll("[^\\d.]", ""))));
						sb.append("</font></td> ");  									
						sb.append("</tr> ");
						NetAmount=NetAmount+ Float.parseFloat(ws.getString(30));
						i++;
									
					}							
						sb.append("<tr>");
						sb.append("<td colspan='8' align='right' style='padding: 1%;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>GRAND TOTAL</b></font></td>");
						sb.append("<td colspan='1' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
						sb.append(Math.round(NetAmount));
						
						sb.append("</font></td>");
						sb.append("</tr>");
						
						 sb.append("<tr>");
				         sb.append("<td colspan='9' align='left'><hr size='1' style='margin-top: 0rem;border-top: 1px solid rgb(0, 0, 0);border-block-style: dashed;'></td>");			       
				         sb.append("</tr>");
						if(vo.getStrHospitalCode().equals("10811"))	
						{
							sb.append("<tr>");
							sb.append("<td colspan='4' align='left'><u><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>Terms & Conditions</font></td>");
							sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>FOR I.G.I.M.S CENTRAL PHARMACY</font></td>");					
							sb.append("</tr>");
						}
						else
						{
							sb.append("<tr>");
							sb.append("<td colspan='4' align='left'><u><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>Terms & Conditions</font></td>");
							sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'></font></td>");					
							sb.append("</tr>");

						}
						
						
						sb.append("<tr>");
						sb.append("<td colspan='5' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><b>Un-used Medicine must be returned before discharge</b></font></td>");
						sb.append("<td colspan='4' align='center'></td>");					
						sb.append("</tr>");						
						sb.append("<tr>");
						sb.append("<td colspan='3' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>User:"+vo.getStrUserName()+"</font></td>");
						sb.append("<td colspan='3' align='left'>User Sign</td>");	
						sb.append("<td colspan='3' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Authorised Signatory</font></td>");	
						sb.append("</tr>");
					        		
				} else {
	            sb.append("<tr> ");
	            sb.append("<td colspan='9' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>No Reocrd</b><br/><br/></font></td> ");
	            sb.append("</tr> ");
	         }

	         sb.append("</table> ");
	         sb.append("<table align='center' width='850' border='0' cellspacing='0' cellpadding='0' height='69'> ");
	         sb.append("<tr>");
	         sb.append("<td width='10%'></td>");
	         sb.append("<td width='80%' align='center'><b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
	         sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
	         sb.append("</tr> ");
	         sb.append("</table>");
	      } catch (Exception var16) {
	         var16.printStackTrace();
	         throw var16;
	      } finally {
	         if (ws != null) {
	            ws.close();
	            ws = null;
	         }

	      }

	      return sb.toString();
	   }
	 
	public static String getReturnDetailNEW(WebRowSet wb)throws SQLException 
	 {
			StringBuffer br = new StringBuffer();

		    String strPatName = "";
			String strCrNo = "";
			String strReturnStore = "";
			String strReturnNo = "";
			String strReturnDate = "";
			String strStoreId = "";
			

			int i = 0;

			try 
			{
				/*br.append("<div class='row'>");
				br.append("<table class='table'>"); 
				br.append("<tr>");
				br.append("<td colspan='2'>");
				br.append("<div id='' style='font-weight:350 !important ;font-size: 16px !important;'>&nbsp;Return Details </div>");
				br.append("</td></tr></table>");
				br.append("</div>");*/
				br.append("<div><hr><p class='subHeaders mb-0 text-left'><i class='fas fa-th-list iround' style='font-size: 16px; color: #28a745' title=''></i>&nbsp;Return Details</p></div>");

				br.append("<div class='row'>");
				br.append("<div class='col-md-12'>");
				br.append("<table class='table text-uppercase' align='center'>");
				br.append("<tr>");
				br.append("<thead class='thead-dark'>");
				br.append("<td  WIDTH='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Patient Name</td>");
				br.append("<td  WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>CR No</td>");
				br.append("<td  WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Return To Store</td>");
				br.append("<td  WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Return No</td>");
				br.append("<td  WIDTH='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Return Date</td>");
				br.append("<td  WIDTH='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>#</td>");
				br.append("</thead>");
				br.append("</tr>");
				
				
				if (wb.size() != 0) 
				{
				
					while (wb.next()) 
					{
						strPatName        = wb.getString(1);
						strCrNo           = wb.getString(2);
						strReturnStore    = wb.getString(3);
						strReturnNo       = wb.getString(4);
						strReturnDate     = wb.getString(5);
						strStoreId        = wb.getString(8);
						
						br.append("<input type='hidden' name='strHlpCrNo'        id='strHlpCrNo" +i+ "'     value=" + strCrNo + " />");
						br.append("<input type='hidden' name='strHlpReturnNo'    id='strHlpReturnNo" +i+ "' value=" + strReturnNo + " />");
						br.append("<input type='hidden' name='strHlpStoreId'     id='strHlpStoreId" +i+ "'  value=" + strStoreId + " />");
						
						br.append("<tr>");	
						br.append("<td WIDTH='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>"  + strPatName + "</td>");
						br.append("<td WIDTH='20%' align='center'>");
						br.append("<input type='hidden' name='flag' id='flag" +i+ "' value=" + "0" + " />");
						br.append("<div class='popup' id='IssueItempopup' style='display: none'></div>");
						br.append("<a align='center' style='cursor:pointer;color:blue;font-weight:350 !important ;font-size:16px;' title='Issue No Item Details' onClick='showPopUp(this,\""+ i + "\");'>" + strCrNo + "</a></td>");
						br.append("</td>");
						br.append("<td WIDTH='20%' align='left'   style='font-weight:350 !important ;font-size: 16px !important;' >"	+ strReturnStore + "</td>");
						br.append("<td WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' >"	+ strReturnNo + "</td>");
						br.append("<td WIDTH='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' >"	+ strReturnDate + "</td>");
						br.append("<td WIDTH='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' ><img src='../../hisglobal/images/search_icon1.gif' onclick='generateIssueReportFunc(this,\""+ i + "\");' style='cursor: pointer;' title='Print Issue Item Details'></td>");
						br.append("</tr>");
						i++;
					}

					br.append("</table> ");
					br.append("</div>");
					br.append("</div>");
				} else {
					br.append("<div class='row'>");
					br.append("<div class='col-md-12'>");
					br.append("<table class='table' style='font-weight:350 !important ;font-size: 16px !important;'>");
					br.append("<tr>");
					br.append("<td colspan='5' align='center' style='font-weight:350 !important ;font-size: 16px !important;color:red;'>"
							+ "No Record Found" + "</td>");
					br.append("</tr>");
					br.append("</table> ");
					br.append("</div>");
					br.append("</div>");
					br.append("</div>");
				}

			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				return "ERROR";

			}

			return br.toString();
		}

}
