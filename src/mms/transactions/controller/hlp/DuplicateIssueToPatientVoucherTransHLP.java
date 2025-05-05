/**
 * 
 */
package mms.transactions.controller.hlp;

import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;

import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import mms.transactions.bo.DuplicateIssueToPatientVoucherTransBO;
import mms.transactions.controller.fb.IssueTransFB;
import mms.transactions.vo.DuplicateIssueToPatientVoucherTransVO;

/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * Date : 24/April/2009
 * 
 */
public class DuplicateIssueToPatientVoucherTransHLP {

	public static String getItemDetails(String strItemCategoryNo,
			String strHospitalCode, WebRowSet wb, String strStoreId)
	 {
		StringBuffer sBuffer = new StringBuffer("");
		
	
		DuplicateIssueToPatientVoucherTransVO vo=null;
		DuplicateIssueToPatientVoucherTransBO bo= null;
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
			 
			 bo = new DuplicateIssueToPatientVoucherTransBO();
			 vo = new DuplicateIssueToPatientVoucherTransVO();
			
			
			 hisutil = new HisUtil("MMS","DuplicateIssueToPatientVoucherTransHLP");
			 
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
	

	DuplicateIssueToPatientVoucherTransVO vo=null;
	DuplicateIssueToPatientVoucherTransBO bo= null;
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
		 
		 bo = new DuplicateIssueToPatientVoucherTransBO();
		 vo = new DuplicateIssueToPatientVoucherTransVO();
		
		
		 hisutil = new HisUtil("MMS","DuplicateIssueToPatientVoucherTransHLP");
		 
		 if(wb.size() != 0){
		 
			 sBuffer.append("<div class='row rowFlex reFlex'>");
			 sBuffer.append("<div class='col-md-2 px-4'>Drug Name");sBuffer.append("</div>");
			 sBuffer.append("<div class='col-md-2'>Batch");sBuffer.append("</div>");
			 sBuffer.append("<div class='col-md-1'>Expiry Date");sBuffer.append("</div>");
			 sBuffer.append("<div class='col-md-2'>Balance Qty");sBuffer.append("</div>");
			 sBuffer.append("<div class='col-md-1'><font color='red'>*</font>Return Qty");sBuffer.append("</div>");
			 sBuffer.append("<div class='col-md-1'><font color='red'>*</font>Return Qty Unit");sBuffer.append("</div>");
			 sBuffer.append("<div class='col-md-1'>Cost(Rs.)");sBuffer.append("</div>");
			 sBuffer.append("</div>");
			 
			 
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
  					
  					sBuffer.append("<div class='row rowFlex reFlex'>");
  					sBuffer.append("<div class='col-md-2 px-4'>");
  					
  					sBuffer.append(strBrdName+""+
  							"<input type='hidden' name='strItem' id='strItem" + i
	  							+"' value='"+ rateUnit+ '@'+ manufDate +'@'+ consumable +"'/>");

  					
  					sBuffer.append("</div>");
  					 sBuffer.append("<div class='col-md-2'>");
  					 	sBuffer.append(strBtchSlNo);
  					 sBuffer.append("</div>");
  					 sBuffer.append("<div class='col-md-1'>");
  					 	sBuffer.append(strExpiryDt);
  					 sBuffer.append("</div>");
  					 sBuffer.append("<div class='col-md-2' name='strBalanceQty' id='strBalanceQty'"+i+"'>'");
  					 		sBuffer.append(strBalQty+"<input type='hidden' name='balQty' id='balQty" + i
						+"' value='"+ issueUnit+ '@'+ returnUnit +"'/><input type='hidden' name='strBalQty' id='strBalQty" + i
						+"' value='"+ strBalQty+"'/></td>");
				
  					 sBuffer.append("</div>");
  					 sBuffer.append("<div class='col-md-1'>");
  					 	sBuffer.append(
  							"<input type='text' maxlength='8' autocomplete='off' onkeypress='return validateData(event,7);', onkeyup='quantityUnitValue("+i+");'"  +
  							"name='strReturnQty' id='strReturnQty"
							+ i
							+ "' class='form-control' value=''>");
  					
  					 sBuffer.append("</div>");
  					 sBuffer.append("<div class='col-md-1'>");
  					 		sBuffer.append(
  							"<Select name='strReturnQtyUnitId' disabled='disabled' class='browser-default custom-select' id='strReturnQtyUnitId"   
							+ i 
							+ "' onchange='quantityUnitValue("+i+");'>"
							+ strReturnUnitCombo + "</select>");
  					
  					 sBuffer.append("</div>");
  					 sBuffer.append("<div class='col-md-1'>Cost(Rs.)");
  					sBuffer.append("<div id='strTotalCostDivId"+i+"'>0.00</div>" +
  							"<input type='hidden' name='strTotalCost' id='strTotalCost" + i
  							+"' value='0'/><input type='hidden' name='strRate' id='strRate" + i
  							+"' value='"+ rate+"@"+ rateUnitId+"@"+baseValue+"'/><input type='hidden' name='strHidParamVal' id='strHidParamVal" + i
  							+"' value='"+wb.getString(1)+"'/>");	  					
  					
  					 sBuffer.append("</div>");
  					 
  					 
								
  					i++;  						
  				}
			
			sBuffer.append("<div class='row rowFlex reFlex'>");
			
			sBuffer.append("<div class='col-md-10'>Net Cost(Rs):");sBuffer.append("</div>");
			
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



public static String getIssueDtlsInitView(IssueTransFB formBean) throws Exception {

	StringBuffer sb = new StringBuffer("");
	int i=1;
	
	ResourceBundle res = null;
	WebRowSet ws = null;
	
	String strTableWidth = "825";
	
	try 
	{
		res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}

		ws = formBean.getWsIssueDetails();
		
		HisUtil hisUtil=new HisUtil("Global","ReportUtil");
		HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(formBean.getStrHospitalCode());
		//System.out.println("hospitalVO.getAddress1()"+hospitalVO.getHospitalName());
		//System.out.println("the ws length isa  "+ws.getKeyColumns());
		sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
		sb.append("<tr><td width='8%'>&nbsp;</td> ");
		sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
		//sb.append(res.getString("REPORT_TITLE"));
		sb.append(hospitalVO.getHospitalName());
		sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
		sb.append("</tr> ");
		sb.append("<tr> ");
		sb.append("<td width='8%'>&nbsp;</td> ");
		sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
		sb.append(((hospitalVO.getAddress1()==""||hospitalVO.getAddress1()==null)?" ":(hospitalVO.getAddress1()+","))+((hospitalVO.getAddress2()==""||hospitalVO.getAddress2()==null)?" ":(hospitalVO.getAddress2()+","))+ ((hospitalVO.getCity()==""||hospitalVO.getCity()==null)?" ":(hospitalVO.getCity()+","))+((hospitalVO.getPinCode()==""||hospitalVO.getPinCode()==null)?" ":(hospitalVO.getPinCode()))+"");
		//sb.append(res.getString("FULL_TITLE"));
		sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
		sb.append("</tr> ");
		sb.append("<tr> ");
		sb.append("<td width='8%'>&nbsp;</td> ");
		sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
		//sb.append(hospitalVO.getCity());
		//sb.append(res.getString("CITY"));
		sb.append("</font></b></td><td width='10%'>&nbsp; ");
		sb.append("</td> ");
		sb.append("</tr> ");
		sb.append("</table> ");
		
		
		/*
		
		sb.append("<table align='center' width='").append(strTableWidth + "' border='0' cellspacing='0' cellpadding='0' height='69'> ");
		sb.append("<tr>");
		sb.append("<td width='10%'></td>");			
		sb.append("<td width='80%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
//		sb.append("This is Testing Slip");
		sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
		sb.append("</tr> ");
		
		sb.append("<tr>");
		sb.append("<td width='10%'></td>");			
		sb.append("<td width='80%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
		sb.append(res.getString("PAT_ISSUE_TITLE1"));
		sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
		sb.append("</tr> ");
		sb.append("<tr>");
		sb.append("<td width='10%'></td>");					
		sb.append("<td width='90%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
		sb.append(res.getString("PAT_ISSUE_TITLE2"));
		sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
		sb.append("</tr> ");		
		sb.append("<tr>");
		sb.append("<td width='10%'></td>");					
		sb.append("<td width='90%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
		//System.out.println("formBean.getStrHospitalName()"+formBean.getStrHospitalName());
		sb.append(formBean.getStrHospitalName());
		sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
		sb.append("</tr> ");
		sb.append("</table>"); 	
		*/
		sb.append("<table border='0' width='" + strTableWidth + "' align='center'> ");
		sb.append("<tr> ");
		sb.append("<td align='right'>");
			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
		sb.append("<img style='cursor: pointer; '  name='PrintPage' tabindex='1' title='Print Page'");
		sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne(1);'/> <img style='cursor: pointer; ' title='Cancel Process'  ");
		sb.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopupOne();' /></div>");
		sb.append(" </td> ");
		sb.append(" </tr> ");
		sb.append(" </table> ");
		sb.append(" <br> ");
		
		sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");	
		
		sb.append("<tr>");
		sb.append("<td width='100%' align='center' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue to Patient</b></font></td> ");
		sb.append("</tr>");
		
		/*sb.append("<tr> ");
		
		sb.append("<td width='50%' colspan='2'  align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrLocDL().split("@")[1])
				.append("</font></td> ");	*/		

		//sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("D.L. No.: </b></font></td> ");
		//sb.append("<td width='25%'  align='LEFT' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrLocDL().split("@")[0]).append(
				//"</font></td> ");
		//sb.append("</tr> ");
		/*************************************************1*******************************************************************/
		sb.append("<tr> ");	
		sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Patient:</b></font></td> ");
//		sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(formBean.getStrIssueNo())
//					.append("</b></font></td> ");
		sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >"+formBean.getStrPatientName()+"</font></td> ");			

		sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Store Name:</b></font></td> ");
		sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrStoreName()).append(
					"</font></td> ");
		sb.append("</tr> ");
		/**************************************************2*****************************************************************/
		
		sb.append("<tr> ");	
		sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Doctor:</b></font></td> ");
		sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrPrescribedBy())
					.append("</font></td> ");

		sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Issue No:</b></font></td> ");
		sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrIssueNo()).append(
					"</font></td> ");
		sb.append("</tr> ");
		/**************************************************3******************************************************************/
		sb.append("<tr> ");	
		sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Reg.No:</b></font></td> ");
//		sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(formBean.getStrIssueNo())
//					.append("</b></font></td> ");
		sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >"+formBean.getStrRegNo()+"</font></td> ");

		sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Issue Date:</b></font></td> ");
		sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrIssueDate()).append(
					"</font></td> ");
		sb.append("</tr> ");
		/***************************************************4*****************************************************************/
		sb.append("<tr> ");	
		

		sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("CR No:</b></font></td> ");
	     sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrCrNo())
				.append("</font></td> ");
	     if(formBean.getStrLFAccountNo() != null && !formBean.getStrLFAccountNo().equals("0"))
	     {
	    	 sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("LF No:</b></font></td> ");
	    	 sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrLFAccountNo())
				.append("</font></td> ");
	     }
	     else
	     {
	    	 sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td> ");
	    	 sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td> ");
	     }
	
		sb.append("</tr> ");
		/********************************************************************************************************************/
		sb.append("</table> ");
		
		sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
		sb.append("<tr>");
		sb.append("<td colspan='4' align='left'><hr size='2'></td>");
		sb.append("<td colspan='3' align='center'><hr size='2'></td>");					
		sb.append("</tr>");
		sb.append("<tr bgcolor='#cdc9c9'> ");
		sb.append("<td align='center' width='5%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
		sb.append("</td>");						
		sb.append("<td align='center' width='35%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font> ");
		sb.append("</td>");
		sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b></font> ");
		sb.append("</td> ");
		sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font>");
		sb.append("</td> ");
		sb.append("<td align='right' width='10%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty</b></font>");
		sb.append("</td> ");
		sb.append("<td align='right'  width='10%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate(Rs.)</b></font>");
	sb.append("</td> ");
	sb.append("<td align='right'  width='10%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost(Rs.)</b></font>");
	sb.append("</td> ");
		sb.append("</tr> ");
		sb.append("<tr>");
		sb.append("<td colspan='4' align='left'><hr size='2'></td>");
		sb.append("<td colspan='3' align='center'><hr size='2'></td>");					
		sb.append("</tr>");
		////System.out.println("In HLP Size is::::::"+ws.size());
		float NetAmount=0;
		if (ws != null && ws.size() > 0) 
		{

			while (ws.next()) 
			{
					
				/*
				  (Which Call in Case of Off-Line Issue Voucher)
				  1.Hospital Name ^ DDC Name ^ Prescribe For ^ Issue No ^ Issued By Doctor ^ Date ^ Cr No ^ Hindi Text ^ Registration No 
				  2.Drug Name
				  3.Batch No 
				  4.Exp Date
				  5.Issue Qty
				 */	
				sb.append("<tr> ");
				sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				sb.append(i+".");
				sb.append("</font></td> ");					
				sb.append("<td align='left' width='35%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
				sb.append(ws.getString(2));
				sb.append("</font></td> ");
				sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				sb.append(ws.getString(3));
				sb.append("</font></td> ");
				sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				sb.append(ws.getString(4));
				sb.append("</font></td> ");
				sb.append("<td style=\"text-align:right;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				sb.append(ws.getString(5));
				sb.append("</font></td> ");
				sb.append("<td style=\"text-align:right;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				sb.append(ws.getString(6));
				sb.append("</font></td> ");
				sb.append("<td style=\"text-align:right;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				sb.append(ws.getString(7));
				sb.append("</font></td> ");  									
				sb.append("</tr> ");
				NetAmount=NetAmount+ Float.parseFloat(ws.getString(7));
				i++;
							
			}								
				
//				NumberFormat formatter = new DecimalFormat("############.##");  				    					
//				String ServiceCharge ="";					
//				String FinaltotalCost = formatter.format(new BigDecimal(totalCost)); 					
				sb.append("<tr>");
				sb.append("<td colspan='4' align='left'><hr size='2'></td>");
				sb.append("<td colspan='3' align='center'><hr size='2'></td>");					
				sb.append("</tr>");
				
				sb.append("<tr>");
				sb.append("<td colspan='6' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>TOTAL Rs.(Round )</b></font></td>");
				sb.append("<td colspan='1' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				sb.append(Math.round(NetAmount));//
			//s	myFormatter.format(Double.parseDouble(FinaltotalCost)));				
				sb.append("</font></td>");
				sb.append("</tr>");					
					
//					double IssueRatePercentage  = Double.parseDouble(configIssueRate);
//					
//					double PurchaseCost         =  Double.parseDouble(strItemTotCost);
//			        
//			        totAmtStr = "(" + util.getAmountStr(FinaltotalCost)+ ")";
//					sb.append("<tr>");
//					sb.append("<td  colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'></font></td>");
//					sb.append("<td  colspan='6' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>(Rs.) In Words :-" + totAmtStr + "</strong></font></td>");
//					sb.append("</tr>");
//					
//					sb.append("<tr> ");
//					sb.append("<td colspan='7' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>[ "+formBean.getStrIssueBy()+"]<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
//					sb.append("</tr> ");
					
					sb.append("<tr>");
					sb.append("<td colspan='4' align='left'></td>");
					sb.append("<td colspan='1' align='center'></td>");					
					sb.append("</tr>");	
					sb.append("<tr>");
					sb.append("<td colspan='4' align='left'></td>");
					sb.append("<td colspan='1' align='center'></td>");					
					sb.append("</tr>");
					
//					sb.append("<tr> ");
//					sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Signature<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
//					sb.append("</tr> ");						
			        		
		} 
		else 
		{

			sb.append("<tr> ");
			sb.append("<td colspan='5' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
			sb.append("</tr> ");

		}
		sb.append("</table> ");			
		sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
		sb.append("<tr>");
		sb.append("<td width='10%'></td>");			
		sb.append("<td width='80%' align='center'><b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
		//sb.append(formBean.getStrHindiText());
		sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
		sb.append("</tr> ");				
		sb.append("</table>"); 	

	} 
	catch (Exception e) 
	{

		e.printStackTrace();

		throw e;
	}
	finally
	{
		if(ws != null)
		{
			ws.close();
			ws = null;
		}
				
	}

	return sb.toString();
}


}
