package mms.transactions.controller.hlp;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.sql.rowset.WebRowSet;

import mms.transactions.bo.PODeskGenerateTransNewBO;
import mms.transactions.controller.fb.PODeskGenerateTransNewFB;
import mms.transactions.vo.PODeskGenerateTransNewVO;

public class PODeskGenerateTransNewHLP {
	
	public static String getRequestDetails(
			PODeskGenerateTransNewFB _PODeskGenerateTransNewFB) {
		String strHLPString = null;
		try 
		{
			if (_PODeskGenerateTransNewFB.getStrPOTypeId().equals("21")
					|| _PODeskGenerateTransNewFB.getStrPOTypeId().equals("25")
					|| _PODeskGenerateTransNewFB.getStrPOTypeId().equals("26")
					|| _PODeskGenerateTransNewFB.getStrPOTypeId().equals("27"))
				strHLPString = getLPRequestDetails(_PODeskGenerateTransNewFB);
			else if (_PODeskGenerateTransNewFB.getStrPOTypeId().equals("23")
					|| _PODeskGenerateTransNewFB.getStrPOTypeId().equals("24"))
				strHLPString = getImpContiRequestDetails(_PODeskGenerateTransNewFB);
			else if (_PODeskGenerateTransNewFB.getStrPOTypeId().equals("22")||_PODeskGenerateTransNewFB.getStrPOTypeId().equals("28")||_PODeskGenerateTransNewFB.getStrPOTypeId().equals("86"))
				strHLPString = getAnnualRequestDetails(_PODeskGenerateTransNewFB);
		} catch (Exception _e) {
			_PODeskGenerateTransNewFB
					.setStrMsg("PODeskGenerateTransNewHLP.getRequestDetails() --> "
							+ _e.getMessage());
			_PODeskGenerateTransNewFB.setStrMsgType("1");
		}
		return strHLPString;
	}

	public static String getLPRequestDetails(
			PODeskGenerateTransNewFB _PODeskGenerateTransNewFB) {

		StringBuffer br = new StringBuffer("");
		WebRowSet wb = null;
		try {
			wb = _PODeskGenerateTransNewFB.getWbRequestDetail();
			if (wb.size() != 0) {
				br.append("<table class='TABLEWIDTH' bgcolor='black' border='0'  align='center' cellspacing='1px'>");
				br.append("<tr>");
				br.append("<td width='5%' class='multiLabel'><input type='checkbox' name='strCheckAll' onclick='checkAll();'>");
				br.append("</td><td width='15%' class='multiLabel'>Request No.");
				br.append("</td><td width='15%' class='multiLabel'>Request Date");
				br.append("</td><td width='15%' class='multiLabel'>Request Type");
				br.append("</td><td width='15%' class='multiLabel'>Raising Store");
				br.append("</td><td width='15%' class='multiLabel'>CR No.");
				br.append("</td><td width='20%' class='multiLabel'>Patient Name");
				br.append("</td></tr>");
				br.append("</table>");
				br.append("<table class='TABLEWIDTH' bgcolor='#6097BC' border='0'  align='center' cellspacing='1px'>");
				int nTmpI = 0;
				while (wb.next()) {
					br.append("<tr>");
					br.append("<td width='5%' class='multiControl'>");

					br
							.append("<input type='hidden' name='strDRequestNo' value='"
									+ wb.getString(1) + "' disabled=true>");
					br
							.append("<input type='hidden' name='strDRaisingStore' value='"
									+ wb.getString(2) + "' disabled=true>");
					br
							.append("<input type='hidden' name='strDRequestDate' value='"
									+ wb.getString(3) + "' disabled=true>");
					br.append("<input type='hidden' name='strDCRNo' value='"
							+ wb.getString(5) + "' disabled=true>");
					br
							.append("<input type='hidden' name='strDRequestType' value='"
									+ wb.getString(7) + "' disabled=true>");
					br
							.append("<input type='hidden' name='strDRequestPeriod' value='' disabled=true>");

					br
							.append("<input type='checkbox' name='strCheckBox' onclick='checkData(this);' value='");
					br.append(wb.getString(1) + "^" + wb.getString(2) + "^"
							+ wb.getString(3) + "^" + wb.getString(5) + "^"
							+ wb.getString(7) + "^/");
					br.append("'>");

					br.append("</td><td width='15%' class='multiControl'>");
					br.append(wb.getString(1));
					br.append("</td><td width='15%' class='multiControl'>");
					br.append(wb.getString(3));
					br.append("</td><td width='15%' class='multiControl'>");
					br.append(wb.getString(8));
					br.append("</td><td width='15%' class='multiControl'>");
					br.append(wb.getString(4));
					br.append("</td><td width='15%' class='multiControl'>");
					br.append(wb.getString(5));
					br.append("</td><td width='20%' class='multiControl'>");
					br.append(wb.getString(6));
					br.append("</td></tr>");
					nTmpI++;
				}
				br.append("</table>");
			} else {
				br
						.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>");
				br.append("<tr>");
				br
						.append("<td colspan='5'  CLASS='multiControl' ><DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED STORE NAME OR ITEM CATEGORY </div></TD>");

				br.append("</tr>");
				br.append("</table>");

			}
		} catch (Exception _e) {
			_PODeskGenerateTransNewFB
					.setStrMsg("PODeskGenerateTransNewHLP.getLPRequestDetails() --> "
							+ _e.getMessage());
			_PODeskGenerateTransNewFB.setStrMsgType("1");
		}
		return br.toString();
	}

	
	public static String getPOWithItemHLP(PODeskGenerateTransNewFB _PODeskGenerateTransNewFB) 
	{

		 StringBuffer br = new StringBuffer("");
		 String strJonalLocation ="";
		 WebRowSet wb = null;
		 double cltamt  = 0.00;
		 double totalCost = 0.00;
		 int    totalQty  = 0;
		 int   grandTotalQty = 0;
		 double totalGrandCost =0.00;
		 String strItemTotCost="0.00";
		 int count = 0;
		 NumberFormat formatter = new DecimalFormat("############.##"); 
		 DecimalFormat myFormatter = new DecimalFormat("0.00");
		try 
		{
						
				br.append("<table class='TABLEWIDTH' bgcolor='#1277B5' align='center' cellspacing='1px'>");
				br.append("<tr>");
				br.append("<td width='20%'  class='multiPOLabel'>Hospital</td>");
				br.append("<td width='20%' class='multiPOLabel'>Store</td>");
				//br.append("<td width='7%'  class='multiPOLabel'>Quantity Demanded by Hospitals</td>");
				//br.append("<td width='7%'  class='multiPOLabel'>Quantity Ordered by Hospital</td>");
				//br.append("<td width='7%'  class='multiPOLabel'>Total Qty Supplied at Stores</td>");
				//br.append("<td width='7%'  class='multiPOLabel'>Qty Issued to Sub Stores</td>");				
				//br.append("<td width='7%'  class='multiPOLabel'>Qty in PipeLine(transit)</td>");				
				br.append("<td width='10%'  class='multiPOLabel'>Current Stock</td>");
				//br.append("<td width='7%'  class='multiPOLabel'>Qty in Quarntine</td>");
			//	br.append("<td width='7%'  class='multiPOLabel'>Qty in  Sub-Stores</td>");			
				br.append("<td width='15%'  class='multiPOLabel'>Re-Order Level</td>");
				br.append("<td width='20%' class='multiPOLabel'>Quantity to be Ordered</td>");
				br.append("<td width='15%'  class='multiPOLabel'>Value of Qty to be Ordered(Rs.)</td>");
				
				br.append("</tr>");
				
				int i = 0;
				wb =  _PODeskGenerateTransNewFB.getWbsReqListPO();				
				if(_PODeskGenerateTransNewFB.getWbsReqListPO() != null && _PODeskGenerateTransNewFB.getWbsReqListPO().size() > 0)
				{					
					while(_PODeskGenerateTransNewFB.getWbsReqListPO().next())
					{			
							    if(i == 0)
							    {	
						          strJonalLocation = wb.getString(12);
							    }
						        if(strJonalLocation.equals(wb.getString(12)))
						        {	
						        	   
								        // Store Name (1)+ Demand Qty(2) + [PO_qty(3) # Tot_Issue_Qty(3)] +Tot_Issue Qty(4)+ [Active Qty(5) # Quarntine Qty(5)] + Re-Order Qty(6) + Order Qty(7) +  Budget Avl(8) + DDW_ID(9)+All Sub Store(Consolidated)[10] + Pipe Line Qty [11] + Location [12]
								        String strPODetailsHidValue = wb.getString(1)+"^"+wb.getString(2)+"^"+wb.getString(3)+"^"+wb.getString(4)+"^"+wb.getString(5)+"^"+wb.getString(6)+"^"+wb.getString(7)+"^"+wb.getString(8)+"^"+wb.getString(9)+"^"+wb.getString(10)+"^"+wb.getString(11)+"^"+wb.getString(12);	
								        br.append("<input type='hidden' name='strPODetailsHidValue' id='strPODetailsHidValue"+i+"' value='"+strPODetailsHidValue+"'>");
								        //br.append("<input type='hidden' name='reOrderFlag' id='reOrderFlag"+i+"' value='"+wb.getString(11)+"'>");
							            br.append("<tr>");
							            if(i == 0)
										{
							                br.append("<td  name='td10' id='td140"+i+"' style=\"text-align: right;\"   class='multiRPTLabel'  width='20%'><b>"+wb.getString(12)+"<b></td>");
										}
							            else
							            {
							            	br.append("<td  name='td10' id='td140"+i+"' style=\"text-align: right;\"   class='multiRPTLabel'  width='20%'></td>");
							            }
										br.append("<td  name='td10' id='td10"+i+"'  style=\"text-align: left;\"    class='multiPOControl'    width='20%'><b>"+wb.getString(1)+"</b></td>");
										//br.append("<td  name='td10' id='td20"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(2)+"</td>");
										//br.append("<td  name='td10' id='td30"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(3).split("\\#")[0]+"</td>");
										//br.append("<td  name='td10' id='td40"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(3).split("\\#")[1]+"</td>");
										//br.append("<td  name='td10' id='td50"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(4)+"</td>");
										//br.append("<td  name='td10' id='td60"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(11)+"</td>");
										br.append("<td  name='td10' id='td70"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='10%'>"+wb.getString(5).split("\\#")[0]+"</td>");								
										//br.append("<td  name='td10' id='td80"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(5).split("\\#")[1]+"</td>");
									//	br.append("<td  name='td10' id='td90"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(10)+"</td>");								
										br.append("<td  name='td10' id='td110"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='15%'>"+wb.getString(6)+"</td>");
										if(_PODeskGenerateTransNewFB.getStrMode().equals("2"))
									  	{
											br.append("<td  name='td10' id='td120"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='20%'><input type='text' name='strQrderQty' id='strQrderQty"+i+"' onBlur='POUtilityFunction("+i+");' value="+wb.getString(7).split("\\#")[0]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");	
										//br.append("<td  name='td10' id='td120"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='10%'><input type='text' name='strQrderQty' id='strQrderQty"+i+"' onKeyUp='getValueofOrderQty("+i+");' value="+wb.getString(7).split("\\#")[0]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");
										    br.append("<td  name='td10' id='td130"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='15%'><input type='text' name='strOrdeCost' id='strOrdeCost"+i+"' class='txtFldNormal' disabled='disabled' value="+wb.getString(7).split("\\#")[1]+"></td>");
									  	}
										else
										{
											br.append("<td  name='td10' id='td120"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='20%'><input type='text' name='strQrderQty' id='strQrderQty"+i+"' onBlur='POUtilityFunction("+i+");' class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");
											//br.append("<td  name='td10' id='td120"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='10%'><input type='text' name='strQrderQty' id='strQrderQty"+i+"' onKeyUp='getValueofOrderQty("+i+");' value='0' class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");
											br.append("<td  name='td10' id='td130"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='15%'><input type='text' name='strOrdeCost' id='strOrdeCost"+i+"' class='txtFldNormal' disabled='disabled' value='0'></td>");
								
										}							
								  	    br.append("</tr>");  
								  	    
								  	   // System.out.println(br);
								  	    
						        }
						        else
						        {
						        	strJonalLocation = wb.getString(12);
						        	// Store Name (1)+ Demand Qty(2) + [PO_qty(3) # Tot_Issue_Qty(3)] +Tot_Issue Qty(4)+ [Active Qty(5) # Quarntine Qty(5)] + Re-Order Qty(6) + Order Qty(7) +  Budget Avl(8) + DDW_ID(9)+All Sub Store(Consolidated)[10] + Pipe Line Qty [11] + Location [12]
							        String strPODetailsHidValue = wb.getString(1)+"^"+wb.getString(2)+"^"+wb.getString(3)+"^"+wb.getString(4)+"^"+wb.getString(5)+"^"+wb.getString(6)+"^"+wb.getString(7)+"^"+wb.getString(8)+"^"+wb.getString(9)+"^"+wb.getString(10)+"^"+wb.getString(11)+"^"+wb.getString(12);	
							        br.append("<input type='hidden' name='strPODetailsHidValue' id='strPODetailsHidValue"+i+"' value='"+strPODetailsHidValue+"'>");
							        //br.append("<input type='hidden' name='reOrderFlag' id='reOrderFlag"+i+"' value='"+wb.getString(11)+"'>");
						            br.append("<tr>");
						            br.append("<td  name='td10' id='td140"+i+"' style=\"text-align: right;\"   class='multiRPTLabel'  width='20%'><b>"+wb.getString(12)+"<b></td>");
									br.append("<td  name='td10' id='td10"+i+"'  style=\"text-align: left;\"    class='multiPOControl'    width='20%'><b>"+wb.getString(1)+"</b></td>");
									//br.append("<td  name='td10' id='td20"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(2)+"</td>");
									//br.append("<td  name='td10' id='td30"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(3).split("\\#")[0]+"</td>");
									//br.append("<td  name='td10' id='td40"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(3).split("\\#")[1]+"</td>");
									//br.append("<td  name='td10' id='td50"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(4)+"</td>");
									//br.append("<td  name='td10' id='td60"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(11)+"</td>");
									br.append("<td  name='td10' id='td70"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='10%'>"+wb.getString(5).split("\\#")[0]+"</td>");								
							    	//br.append("<td  name='td10' id='td80"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(5).split("\\#")[1]+"</td>");
									//br.append("<td  name='td10' id='td90"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(10)+"</td>");								
									br.append("<td  name='td10' id='td110"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='15%'>"+wb.getString(6)+"</td>");
									if(_PODeskGenerateTransNewFB.getStrMode().equals("2"))
								  	{
										br.append("<td  name='td10' id='td120"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='20%'><input type='text' name='strQrderQty' id='strQrderQty"+i+"' onBlur='POUtilityFunction("+i+");' value="+wb.getString(7).split("\\#")[0]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");	
									    br.append("<td  name='td10' id='td130"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='15%'><input type='text' name='strOrdeCost' id='strOrdeCost"+i+"' class='txtFldNormal' disabled='disabled' value="+wb.getString(7).split("\\#")[1]+"></td>");
								  	}
									else
									{
										br.append("<td  name='td10' id='td120"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='20%'><input type='text' name='strQrderQty' id='strQrderQty"+i+"' onBlur='POUtilityFunction("+i+");' class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");
									    br.append("<td  name='td10' id='td130"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='15%'><input type='text' name='strOrdeCost' id='strOrdeCost"+i+"' class='txtFldNormal' disabled='disabled' value='0'></td>");
							
									}							
							  	    br.append("</tr>");  
							  	    count++;
						        	
						        	
						        	
						        }						        
							  	if(_PODeskGenerateTransNewFB.getStrMode().equals("2"))
							  	{	
							  	  strItemTotCost = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[1]));  
						          cltamt = Double.parseDouble(strItemTotCost);							
						          totalGrandCost = totalGrandCost + cltamt;
						          
						          totalQty = Integer.parseInt(wb.getString(7).split("\\#")[0]);
						          grandTotalQty = grandTotalQty + totalQty;
						          //wb.getString(7).split("\\#")[0]
							  	}						  	    
					            i=i+1;					     
				   }
				}
				
				
				br.append("<tr>");			
//				br.append("<td colspan='1'  class='multiPOLabel'></td>");
//				br.append("<td colspan='1'  class='multiPOLabel'></td>");
//				br.append("<td colspan='1'  class='multiPOLabel'></td>");
//				br.append("<td colspan='1'  class='multiPOLabel'></td>");
//				br.append("<td colspan='1'  class='multiPOLabel'></td>");				
//				br.append("<td width='7%'  class='multiPOLabel'></td>");				
//				br.append("<td width='7%'  class='multiPOLabel'></td>");
//				br.append("<td width='7%'  class='multiPOLabel'></td>");
//				br.append("<td width='7%'  class='multiPOLabel'></td>");
				br.append("<td colspan='5' class='multiRPTLabel'><div align='right'>Total Order Qty :: </div></td>");	
				if(_PODeskGenerateTransNewFB.getStrMode().equals("2"))
			  	{
				    br.append("<td colspan='1'  class='multiRPTLabel'><input type='text' name='strTotalQrderQty' readonly  value='"+grandTotalQty+"' id='strTotalQrderQty'  class='txtFldNormal'></td>");
			  	}
				else
				{
					br.append("<td colspan='1'  class='multiRPTLabel'><input type='text' name='strTotalQrderQty' readonly  value='0' id='strTotalQrderQty'  class='txtFldNormal'></td>");
				}
				br.append("<td colspan='1'  class='multiRPTLabel'></td>");
				//br.append("<td colspan='1'  class='multiPOLabel'></td>");
				br.append("</tr>");
	
				
				br.append("</table>");
			
		} 
		catch (Exception _e) 
		{
			_e.printStackTrace();
			_PODeskGenerateTransNewFB
					.setStrMsg("PODeskGenerateTransNewHLP.getImpContiRequestDetails() --> "
							+ _e.getMessage());
			_PODeskGenerateTransNewFB.setStrMsgType("1");
		}
		if(_PODeskGenerateTransNewFB.getStrMode().equals("2"))
	  	{
			//System.out.println("In Modify 2:::"+br.toString()+"^^^2^^^"+totalGrandCost);
			String FinaltotalCost = formatter.format(new BigDecimal(totalGrandCost));  
		    return br.toString()+"^^^2^^^"+FinaltotalCost;
	  	}
		else
		{
			//System.out.println("In Generate:::"+br.toString()+"^^^1^^^0");
			return br.toString()+"^^^1^^^0";	
		}
		
		
	}
	
	public static String getPOWithItemHLPTWO(PODeskGenerateTransNewFB _PODeskGenerateTransNewFB) 
	{

		 StringBuffer br = new StringBuffer("");
		 String strJonalLocation ="";
		 WebRowSet wb = null;
		 double cltamt  = 0.00;
		 double totalCost = 0.00;
		 double    totalQty  = 0;
		 double   grandTotalQty = 0;
		 double totalGrandCost =0.00;
		 String strItemTotCost="0.00";
		 int count = 0;
		 NumberFormat formatter = new DecimalFormat("############.##"); 
		 DecimalFormat myFormatter = new DecimalFormat("0.00");
		 String strOrderQtyScheduleOne="0.00";
		 String strOrderQtyScheduleTwo="0.00";
		 String strOrderQtyScheduleThree="0.00";
		 String strOrderQtyScheduleFour="0.00";
		 
		 String strAcceptedQtyScheduleOne="0.00";
		 String strAcceptedQtyScheduleTwo="0.00";
		 String strAcceptedQtyScheduleThree="0.00";
		 String strAcceptedQtyScheduleFour="0.00";
		 
		 String strRejectedQtyScheduleOne="0.00";
		 String strRejectedQtyyScheduleTwo="0.00";
		 String strRejectedQtyScheduleThree="0.00";
		 String strRejectedQtyScheduleFour="0.00";
		 
		 String strOrderValScheduleOne="0.00";
		 String strOrderValScheduleTwo="0.00";
		 String strOrderValThree="0.00";
		 String strOrderValFour="0.00";
		 
		 int cltamtSchOne    = 0;
		 int cltamtSchTwo    = 0;
		 int cltamtSchThree  = 0;
		 int cltamtSchFour   = 0;
		 
		 
		 double valSchOne    = 0;
		 double valSchTwo    = 0;
		 double valSchThree  = 0;
		 double valSchFour   = 0;
		 
		 double totalValue =0;
		 
		 int totalGrandSchOne =0;
		 int totalGrandAcceptedQty =0;
		 int totalGrandRejectedQty =0;
		 int totalReceivedQty =0;
		 
		 String[] temp = null;
		 String[] strTemp = null;
		try 
		{
						
				br.append("<table class='TABLEWIDTH' bgcolor='#0099FF' align='center' cellspacing='1px'>");
				br.append("<tr>");
				br.append("<td width='8%'  class='multiPOLabel'>DIVISON</td>");
				br.append("<td width='12%' class='multiPOLabel'>DDW</td>");
				br.append("<td width='9%'  class='multiPOLabel'>Prev Ordered Qty</td>");
				br.append("<td width='9%'  class='multiPOLabel'>Total Rece. Qty.</td>");
				//br.append("<td width='9%'  class='multiPOLabel'>Balance Qty.</td>");
				//br.append("<td width='9%'  class='multiPOLabel'>Schedule [I]</td>");				
				/* commented by shefali on 29 oct 2014
				br.append("<td width='9%'  class='multiPOLabel'>Schedule [II]</td>");				
				br.append("<td width='9%'  class='multiPOLabel'>Schedule [III]</td>");
				br.append("<td width='9%'  class='multiPOLabel'>Schedule [IV]</td>");
				
				*/
				
				br.append("<td width='10%' class='multiPOLabel'>Total Qty to be Ordered</td>");
				br.append("<td width='9%'  class='multiPOLabel'>Value of Qty to be Ordered(Rs.)</td>");
				
				br.append("</tr>");
				
				int i = 0;
				wb =  _PODeskGenerateTransNewFB.getWbsReqListPO();				
				
					if(_PODeskGenerateTransNewFB.getWbsReqListPO() != null && _PODeskGenerateTransNewFB.getWbsReqListPO().size() > 0)
					{	
					 	while(_PODeskGenerateTransNewFB.getWbsReqListPO().next())
						{	
								    if(i == 0)
								    {	
							          strJonalLocation = wb.getString(12);
								    }
							        if(strJonalLocation.equals(wb.getString(12)))
							        {	
							        	   
							        	strOrderQtyScheduleOne   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[0]));
										strOrderQtyScheduleTwo   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[4]));  
										strOrderQtyScheduleThree = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[8]));  
										strOrderQtyScheduleFour  = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[12]));  
										//System.out.println("strOrderQtyScheduleOne==>"+strOrderQtyScheduleOne+":::strOrderQtyScheduleTwo:::"+strOrderQtyScheduleTwo +":::strOrderQtyScheduleThree:::"+strOrderQtyScheduleThree+"::strOrderQtyScheduleFour:::"+strOrderQtyScheduleFour);
										
										cltamtSchOne             = Integer.parseInt(strOrderQtyScheduleOne);
										cltamtSchTwo             = Integer.parseInt(strOrderQtyScheduleTwo);
										cltamtSchThree           = Integer.parseInt(strOrderQtyScheduleThree);
										cltamtSchFour            = Integer.parseInt(strOrderQtyScheduleFour);
										
										totalGrandSchOne         = cltamtSchOne + cltamtSchTwo + cltamtSchThree + cltamtSchFour;
										//System.out.println("totalGrandSchOne==>"+totalGrandSchOne);
										/********************************************************************************/
										strAcceptedQtyScheduleOne   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[2]));
										strAcceptedQtyScheduleTwo   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[6]));  
										strAcceptedQtyScheduleThree = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[10]));  
										strAcceptedQtyScheduleFour  = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[14]));
										
										cltamtSchOne             	= Integer.parseInt(strAcceptedQtyScheduleOne);
										cltamtSchTwo             	= Integer.parseInt(strAcceptedQtyScheduleTwo);
										cltamtSchThree           	= Integer.parseInt(strAcceptedQtyScheduleThree);
										cltamtSchFour            	= Integer.parseInt(strAcceptedQtyScheduleFour);
										
										totalGrandAcceptedQty       = cltamtSchOne + cltamtSchTwo + cltamtSchThree + cltamtSchFour;
										//System.out.println("totalGrandAcceptedQty==>"+totalGrandAcceptedQty);
										/********************************************************************************/
										
										
										strRejectedQtyScheduleOne    = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[3]));
										strRejectedQtyyScheduleTwo   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[7]));  
										strRejectedQtyScheduleThree  = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[11]));  
										strRejectedQtyScheduleFour   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[15]));
										
										cltamtSchOne                 = Integer.parseInt(strRejectedQtyScheduleOne);
										cltamtSchTwo             	 = Integer.parseInt(strRejectedQtyyScheduleTwo);
										cltamtSchThree           	 = Integer.parseInt(strRejectedQtyScheduleThree);
										cltamtSchFour            	 = Integer.parseInt(strRejectedQtyScheduleFour);
										
										totalGrandRejectedQty    	 = cltamtSchOne + cltamtSchTwo + cltamtSchThree + cltamtSchFour;
										
										totalReceivedQty             = totalGrandAcceptedQty  + totalGrandRejectedQty;
										
										/********************************************************************************/
										strOrderValScheduleOne       = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[1]));
										strOrderValScheduleTwo       = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[5]));  
										strOrderValThree             = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[9]));  
										strOrderValFour              = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[13]));
										
										valSchOne                    = Double.parseDouble(strOrderValScheduleOne);
										valSchTwo             	     = Double.parseDouble(strOrderValScheduleTwo);
										valSchThree           	     = Double.parseDouble(strOrderValThree);
										valSchFour            	     = Double.parseDouble(strOrderValFour);
										
										
										 totalValue    	 = valSchOne + valSchTwo + valSchThree + valSchFour;
										//System.out.println("totalGrandRejectedQty==>"+totalGrandRejectedQty);
										//System.out.println("totalReceivedQty==>"+totalReceivedQty);
							        	
									        // Store Name (1)+ Demand Qty(2) + [PO_qty(3) # Tot_Issue_Qty(3)] +Tot_Issue Qty(4)+ [Active Qty(5) # Quarntine Qty(5)] + Re-Order Qty(6) +[Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [I] +  Budget Avl(8) + DDW_ID(9)+All Sub Store(Consolidated)[10] + Pipe Line Qty [11] + Location [12]
							        	    //                                                                                                                                         [Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [II]
							        	 //                                                                                                                                            [Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [III]
							        	 //                                                                                                                                            [Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [IV]
									        String strPODetailsHidValue = wb.getString(1)+"^"+wb.getString(2)+"^"+wb.getString(3)+"^"+wb.getString(4)+"^"+wb.getString(5)+"^"+wb.getString(6)+"^"+wb.getString(7)+"^"+wb.getString(8)+"^"+wb.getString(9)+"^"+wb.getString(10)+"^"+wb.getString(11)+"^"+wb.getString(12);	
									       
									        		        
									        br.append("<input type='hidden' name='strSchedulePopUpHidValue' id='strSchedulePopUpHidValue"+i+"' value='"+wb.getString(7)+"'>");
									        br.append("<input type='hidden' name='strPODetailsHidValue' id='strPODetailsHidValue"+i+"' value='"+strPODetailsHidValue+"'>");
									        //br.append("<input type='hidden' name='reOrderFlag' id='reOrderFlag"+i+"' value='"+wb.getString(11)+"'>");
								            br.append("<tr>");
								            if(i == 0)
											{
								                br.append("<td  name='td10' id='td140"+i+"' style=\"text-align: right;\"   class='multiRPTLabel'  width='15%'><b>"+wb.getString(12)+"<b></td>");
											}
								            else
								            {
								            	br.append("<td  name='td10' id='td140"+i+"' style=\"text-align: right;\"   class='multiRPTLabel'  width='15%'></td>");
								            }
								            //
											br.append("<td  name='td10' id='td10"+i+"'  style=\"text-align: left;\"    class='multiPOControl'  width='15%'><b><font color='blue'>"+wb.getString(1)+"</font></a></b></td>");
											br.append("<td  name='td10' id='td20"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='15%'>"+totalGrandSchOne+"</td>");
											br.append("<td  name='td10' id='td30"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='15%'>"+totalReceivedQty+"</b></td>");
										   //br.append("<td  name='td10' id='td40"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='9%'>"+wb.getString(3).split("\\#")[1]+"</td>");
											/* commented by shefali on 29 oct 2014	
											 * br.append("<td  name='td10' id='td50"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='15%'><input  type='text' name='strScheduleOne'   id='strScheduleOne"+i+"'   onblur='POScheduleUtilityFunction("+i+",1);' value="+wb.getString(7).split("\\#")[0]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");
											br.append("<td  name='td10' id='td60"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='9%'><input  type='text' name='strScheduleTwo'   id='strScheduleTwo"+i+"'   onblur='POScheduleUtilityFunction("+i+",2);' value="+wb.getString(7).split("\\#")[4]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");
											br.append("<td  name='td10' id='td70"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='9%'><input  type='text' name='strScheduleThree' id='strScheduleThree"+i+"' onblur='POScheduleUtilityFunction("+i+",3);' value="+wb.getString(7).split("\\#")[8]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");								
											br.append("<td  name='td10' id='td80"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='9%'><input  type='text' name='strScheduleFour'  id='strScheduleFour"+i+"'  onblur='POScheduleUtilityFunction("+i+",4);' value="+wb.getString(7).split("\\#")[12]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");*/
											
											br.append("<td  name='td10' id='td120"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='20%'><input type='text' name='strQrderQty'  id='strQrderQty"+i+"'      value="+totalGrandSchOne+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);' onblur='POUtilityFunction(0);'</td>");	
											br.append("<td  name='td10' id='td130"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='20%'><input  type='text' name='strOrdeCost' id='strOrdeCost"+i+"' class='txtFldNormal' disabled='disabled' value="+totalValue+"></td>");
										  	br.append("</tr>");  
									  	    
							        }
							        else
							        {
							        	strJonalLocation = wb.getString(12);
							        	
							        	strOrderQtyScheduleOne   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[0]));
										strOrderQtyScheduleTwo   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[4]));  
										strOrderQtyScheduleThree = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[8]));  
										strOrderQtyScheduleFour  = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[12]));  
										//System.out.println("strOrderQtyScheduleOne==>"+strOrderQtyScheduleOne+":::strOrderQtyScheduleTwo:::"+strOrderQtyScheduleTwo +":::strOrderQtyScheduleThree:::"+strOrderQtyScheduleThree+"::strOrderQtyScheduleFour:::"+strOrderQtyScheduleFour);
										
										cltamtSchOne             = Integer.parseInt(strOrderQtyScheduleOne);
										cltamtSchTwo             = Integer.parseInt(strOrderQtyScheduleTwo);
										cltamtSchThree           = Integer.parseInt(strOrderQtyScheduleThree);
										cltamtSchFour            = Integer.parseInt(strOrderQtyScheduleFour);
										
										totalGrandSchOne         = cltamtSchOne + cltamtSchTwo + cltamtSchThree + cltamtSchFour;
										//System.out.println("totalGrandSchOne==>"+totalGrandSchOne);
										/********************************************************************************/
										strAcceptedQtyScheduleOne   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[2]));
										strAcceptedQtyScheduleTwo   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[6]));  
										strAcceptedQtyScheduleThree = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[10]));  
										strAcceptedQtyScheduleFour  = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[14]));
										
										cltamtSchOne             	= Integer.parseInt(strAcceptedQtyScheduleOne);
										cltamtSchTwo             	= Integer.parseInt(strAcceptedQtyScheduleTwo);
										cltamtSchThree           	= Integer.parseInt(strAcceptedQtyScheduleThree);
										cltamtSchFour            	= Integer.parseInt(strAcceptedQtyScheduleFour);
										
										totalGrandAcceptedQty       = cltamtSchOne + cltamtSchTwo + cltamtSchThree + cltamtSchFour;
										//System.out.println("totalGrandAcceptedQty==>"+totalGrandAcceptedQty);
										/********************************************************************************/
										strRejectedQtyScheduleOne    = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[3]));
										strRejectedQtyyScheduleTwo   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[7]));  
										strRejectedQtyScheduleThree  = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[11]));  
										strRejectedQtyScheduleFour   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[15]));
										
										cltamtSchOne                 = Integer.parseInt(strRejectedQtyScheduleOne);
										cltamtSchTwo             	 = Integer.parseInt(strRejectedQtyyScheduleTwo);
										cltamtSchThree           	 = Integer.parseInt(strRejectedQtyScheduleThree);
										cltamtSchFour            	 = Integer.parseInt(strRejectedQtyScheduleFour);
										
										totalGrandRejectedQty    	 = cltamtSchOne + cltamtSchTwo + cltamtSchThree + cltamtSchFour;
										
										totalReceivedQty             = totalGrandAcceptedQty  + totalGrandRejectedQty;
										
										/********************************************************************************/
										strOrderValScheduleOne       = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[1]));
										strOrderValScheduleTwo       = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[5]));  
										strOrderValThree             = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[9]));  
										strOrderValFour              = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[13]));
										
										valSchOne                    = Double.parseDouble(strOrderValScheduleOne);
										valSchTwo             	     = Double.parseDouble(strOrderValScheduleTwo);
										valSchThree           	     = Double.parseDouble(strOrderValThree);
										valSchFour            	     = Double.parseDouble(strOrderValFour);
										
										
										 totalValue    	 = valSchOne + valSchTwo + valSchThree + valSchFour;
										
										//System.out.println("totalGrandRejectedQty==>"+totalGrandRejectedQty);
										//System.out.println("totalReceivedQty==>"+totalReceivedQty);
							        	
							        	   // Store Name (1)+ Demand Qty(2) + [PO_qty(3) # Tot_Issue_Qty(3)] +Tot_Issue Qty(4)+ [Active Qty(5) # Quarntine Qty(5)] + Re-Order Qty(6) +[Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [I] +  Budget Avl(8) + DDW_ID(9)+All Sub Store(Consolidated)[10] + Pipe Line Qty [11] + Location [12]
						        	    //                                                                                                                                         [Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [II]
						        	 //                                                                                                                                            [Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [III]
						        	 //  
								        String strPODetailsHidValue = wb.getString(1)+"^"+wb.getString(2)+"^"+wb.getString(3)+"^"+wb.getString(4)+"^"+wb.getString(5)+"^"+wb.getString(6)+"^"+wb.getString(7)+"^"+wb.getString(8)+"^"+wb.getString(9)+"^"+wb.getString(10)+"^"+wb.getString(11)+"^"+wb.getString(12);	
								        br.append("<input type='hidden' name='strPODetailsHidValue' id='strPODetailsHidValue"+i+"' value='"+strPODetailsHidValue+"'>");
								        br.append("<input type='hidden' name='strSchedulePopUpHidValue' id='strSchedulePopUpHidValue"+i+"' value='"+wb.getString(7)+"'>");
							            br.append("<tr>");
							            br.append("<td  name='td10' id='td140"+i+"' style=\"text-align: right;\"   class='multiRPTLabel'   width='8%'><b>"+wb.getString(12)+"<b></td>");
							            br.append("<td  name='td10' id='td10"+i+"'  style=\"text-align: left;\"    class='multiPOControl'  width='12%'><b><a value='' style='cursor:pointer;'onClick='callingPoPUp(this,"+i+");'title='Click here to Get PO Specefication'><font color='blue'>"+wb.getString(1)+"</font></a></b></td>");
										br.append("<td  name='td10' id='td20"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='9%'>"+totalGrandSchOne+"</td>");
										br.append("<td  name='td10' id='td30"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='9%'><a value='' style='cursor:pointer;'onClick='callingPoPUpTwo(this,"+i+");'title='Click here to Get PO Schedule Detail(s)'><font color='blue'>"+totalReceivedQty+"</font></a></b></td>");
										//br.append("<td  name='td10' id='td40"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='9%'>"+wb.getString(3).split("\\#")[1]+"</td>");
										br.append("<td  name='td10' id='td50"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='9%'><input  type='text' name='strScheduleOne'   id='strScheduleOne"+i+"'  onblur='POScheduleUtilityFunction("+i+",1);' value="+wb.getString(7).split("\\#")[0]+" class='txtFldNormal' maxlength ='10' onkeypress='return validateData(event,7);'></td>");
										br.append("<td  name='td10' id='td60"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='9%'><input  type='text' name='strScheduleTwo'   id='strScheduleTwo"+i+"'  onblur='POScheduleUtilityFunction("+i+",2);' value="+wb.getString(7).split("\\#")[4]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");
										br.append("<td  name='td10' id='td70"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='9%'><input  type='text' name='strScheduleThree' id='strScheduleThree"+i+"'onblur='POScheduleUtilityFunction("+i+",3);' value="+wb.getString(7).split("\\#")[8]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");								
										br.append("<td  name='td10' id='td80"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='9%'><input  type='text' name='strScheduleFour'  id='strScheduleFour"+i+"' onblur='POScheduleUtilityFunction("+i+",4);' value="+wb.getString(7).split("\\#")[12]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");
										br.append("<td  name='td10' id='td120"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='10%'><input type='text' name='strQrderQty'      id='strQrderQty"+i+"'     value="+totalGrandSchOne+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");	
										br.append("<td  name='td10' id='td130"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='9%'><input  type='text' name='strOrdeCost'      id='strOrdeCost"+i+"' class='txtFldNormal' disabled='disabled' value="+totalValue+"></td>");
									  	br.append("</tr>");  
								  	    count++;
							        	
							        	
							        	
							        }						        
							        if(_PODeskGenerateTransNewFB.getStrMode().equals("2"))
								  	{	
							        	
							          cltamt = Double.parseDouble(formatter.format(new BigDecimal(Double.parseDouble(wb.getString(7).split("\\#")[1])+Double.parseDouble(wb.getString(7).split("\\#")[5])+Double.parseDouble(wb.getString(7).split("\\#")[9])+Double.parseDouble(wb.getString(7).split("\\#")[13]))));						
							          totalGrandCost = totalGrandCost + cltamt;
							          
							          totalQty = Double.parseDouble(wb.getString(7).split("\\#")[0])+Double.parseDouble(wb.getString(7).split("\\#")[4])+Double.parseDouble(wb.getString(7).split("\\#")[8])+Double.parseDouble(wb.getString(7).split("\\#")[12]);
							          grandTotalQty = grandTotalQty + totalQty;
							          //wb.getString(7).split("\\#")[0]
								  	}						  	    
						            i=i+1;					     
					   }
				}
				
				
				br.append("<tr>");			
//				br.append("<td colspan='1'  class='multiPOLabel'></td>");
//				br.append("<td colspan='1'  class='multiPOLabel'></td>");
//				br.append("<td colspan='1'  class='multiPOLabel'></td>");
//				br.append("<td colspan='1'  class='multiPOLabel'></td>");
//				br.append("<td colspan='1'  class='multiPOLabel'></td>");				
//				br.append("<td width='7%'  class='multiPOLabel'></td>");				
//				br.append("<td width='7%'  class='multiPOLabel'></td>");
//				br.append("<td width='7%'  class='multiPOLabel'></td>");
//				br.append("<td width='7%'  class='multiPOLabel'></td>");
				br.append("<td colspan='5' class='multiRPTLabel'><div align='right'>Total Order Qty :: </div></td>");	
				if(_PODeskGenerateTransNewFB.getStrMode().equals("2"))
			  	{
				    br.append("<td colspan='1'  class='multiRPTLabel'><input type='text' name='strTotalQrderQty' readonly  value='"+grandTotalQty+"' id='strTotalQrderQty'  class='txtFldNormal'></td>");
			  	}
				else
				{
					br.append("<td colspan='1'  class='multiRPTLabel'><input type='text' name='strTotalQrderQty' readonly  value='0' id='strTotalQrderQty'  class='txtFldNormal'></td>");
				}
				br.append("<td colspan='1'  class='multiRPTLabel'></td>");
				//br.append("<td colspan='1'  class='multiPOLabel'></td>");
				br.append("</tr>");
	
				
				br.append("</table>");
			
		} 
		catch (Exception _e) 
		{
			_e.printStackTrace();
			_PODeskGenerateTransNewFB
					.setStrMsg("PODeskGenerateTransNewHLP.getImpContiRequestDetails() --> "
							+ _e.getMessage());
			_PODeskGenerateTransNewFB.setStrMsgType("1");
		}
		if(_PODeskGenerateTransNewFB.getStrMode().equals("2"))
	  	{
			//System.out.println("In Modify 2:::"+br.toString()+"^^^2^^^"+totalGrandCost);
			String FinaltotalCost = formatter.format(new BigDecimal(totalGrandCost));  
		    return br.toString()+"^^^2^^^"+FinaltotalCost;
	  	}
		else
		{
			//System.out.println("In Generate:::"+br.toString()+"^^^1^^^0");
			return br.toString()+"^^^1^^^0";	
		}
		
		
	}
	
	
	
	public static String getPOWithItemHLPForView(PODeskGenerateTransNewFB _PODeskGenerateTransNewFB) 
	{

		 StringBuffer br = new StringBuffer("");
		 String strJonalLocation ="";
		 WebRowSet wb = null;
		 double cltamt  = 0.00;
		 double totalCost = 0.00;
		 double    totalQty  = 0;
		 double   grandTotalQty = 0;
		 double totalGrandCost =0.00;
		 String strItemTotCost="0.00";
		 int count = 0;
		 NumberFormat formatter = new DecimalFormat("############.##"); 
		 DecimalFormat myFormatter = new DecimalFormat("0.00");
		 String strOrderQtyScheduleOne="0.00";
		 String strOrderQtyScheduleTwo="0.00";
		 String strOrderQtyScheduleThree="0.00";
		 String strOrderQtyScheduleFour="0.00";
		 
		 String strAcceptedQtyScheduleOne="0.00";
		 String strAcceptedQtyScheduleTwo="0.00";
		 String strAcceptedQtyScheduleThree="0.00";
		 String strAcceptedQtyScheduleFour="0.00";
		 
		 String strRejectedQtyScheduleOne="0.00";
		 String strRejectedQtyyScheduleTwo="0.00";
		 String strRejectedQtyScheduleThree="0.00";
		 String strRejectedQtyScheduleFour="0.00";
		 
		 String strOrderValScheduleOne="0.00";
		 String strOrderValScheduleTwo="0.00";
		 String strOrderValThree="0.00";
		 String strOrderValFour="0.00";
		 
		 int cltamtSchOne    = 0;
		 int cltamtSchTwo    = 0;
		 int cltamtSchThree  = 0;
		 int cltamtSchFour   = 0;
		 
		 
		 double valSchOne    = 0;
		 double valSchTwo    = 0;
		 double valSchThree  = 0;
		 double valSchFour   = 0;
		 
		 double totalValue =0;
		 
		 int totalGrandSchOne =0;
		 int totalGrandAcceptedQty =0;
		 int totalGrandRejectedQty =0;
		 int totalReceivedQty =0;
		 
		 String[] temp = null;
		 String[] strTemp = null;
		try 
		{
						
				br.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center' cellspacing='1px'>");
				br.append("<tr>");
				br.append("<td width='8%'  class='multiPOLabel'>DIVISON</td>");
				br.append("<td width='12%' class='multiPOLabel'>Store</td>");
				br.append("<td width='9%'  class='multiPOLabel'>Prev Ordered Qty</td>");
				br.append("<td width='9%'  class='multiPOLabel'>Total Rece. Qty.</td>");
				//br.append("<td width='9%'  class='multiPOLabel'>Balance Qty.</td>");
			/* COMMENTED by shefali garg on 31 oct 2014
			 * 	br.append("<td width='9%'  class='multiPOLabel'>Schedule [I]</td>");				
				br.append("<td width='9%'  class='multiPOLabel'>Schedule [II]</td>");				
				br.append("<td width='9%'  class='multiPOLabel'>Schedule [III]</td>");
				br.append("<td width='9%'  class='multiPOLabel'>Schedule [IV]</td>");*/
				br.append("<td width='10%' class='multiPOLabel'>Total Qty to be Ordered</td>");
				br.append("<td width='9%'  class='multiPOLabel'>Value of Qty to be Ordered(Rs.)</td>");
				
				br.append("</tr>");
				
				int i = 0;
				wb =  _PODeskGenerateTransNewFB.getWbsReqListPO();				
				
					if(_PODeskGenerateTransNewFB.getWbsReqListPO() != null && _PODeskGenerateTransNewFB.getWbsReqListPO().size() > 0)
					{	
					 	while(_PODeskGenerateTransNewFB.getWbsReqListPO().next())
						{	
								    if(i == 0)
								    {	
							          strJonalLocation = wb.getString(12);
								    }
							        if(wb.getString(12)!=null && strJonalLocation.equals(wb.getString(12)))
							        {	
							        	   
							        	strOrderQtyScheduleOne   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[0]));
										strOrderQtyScheduleTwo   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[4]));  
										strOrderQtyScheduleThree = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[8]));  
										strOrderQtyScheduleFour  = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[12]));  
										//System.out.println("strOrderQtyScheduleOne==>"+strOrderQtyScheduleOne+":::strOrderQtyScheduleTwo:::"+strOrderQtyScheduleTwo +":::strOrderQtyScheduleThree:::"+strOrderQtyScheduleThree+"::strOrderQtyScheduleFour:::"+strOrderQtyScheduleFour);
										
										cltamtSchOne             = Integer.parseInt(strOrderQtyScheduleOne);
										cltamtSchTwo             = Integer.parseInt(strOrderQtyScheduleTwo);
										cltamtSchThree           = Integer.parseInt(strOrderQtyScheduleThree);
										cltamtSchFour            = Integer.parseInt(strOrderQtyScheduleFour);
										
										totalGrandSchOne         = cltamtSchOne + cltamtSchTwo + cltamtSchThree + cltamtSchFour;
										//System.out.println("totalGrandSchOne==>"+totalGrandSchOne);
										/********************************************************************************/
										strAcceptedQtyScheduleOne   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[2]));
										strAcceptedQtyScheduleTwo   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[6]));  
										strAcceptedQtyScheduleThree = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[10]));  
										strAcceptedQtyScheduleFour  = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[14]));
										
										cltamtSchOne             	= Integer.parseInt(strAcceptedQtyScheduleOne);
										cltamtSchTwo             	= Integer.parseInt(strAcceptedQtyScheduleTwo);
										cltamtSchThree           	= Integer.parseInt(strAcceptedQtyScheduleThree);
										cltamtSchFour            	= Integer.parseInt(strAcceptedQtyScheduleFour);
										
										totalGrandAcceptedQty       = cltamtSchOne + cltamtSchTwo + cltamtSchThree + cltamtSchFour;
										//System.out.println("totalGrandAcceptedQty==>"+totalGrandAcceptedQty);
										/********************************************************************************/
										
										
										strRejectedQtyScheduleOne    = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[3]));
										strRejectedQtyyScheduleTwo   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[7]));  
										strRejectedQtyScheduleThree  = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[11]));  
										strRejectedQtyScheduleFour   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[15]));
										
										cltamtSchOne                 = Integer.parseInt(strRejectedQtyScheduleOne);
										cltamtSchTwo             	 = Integer.parseInt(strRejectedQtyyScheduleTwo);
										cltamtSchThree           	 = Integer.parseInt(strRejectedQtyScheduleThree);
										cltamtSchFour            	 = Integer.parseInt(strRejectedQtyScheduleFour);
										
										totalGrandRejectedQty    	 = cltamtSchOne + cltamtSchTwo + cltamtSchThree + cltamtSchFour;
										
										totalReceivedQty             = totalGrandAcceptedQty  + totalGrandRejectedQty;
										
										/********************************************************************************/
										strOrderValScheduleOne       = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[1]));
										strOrderValScheduleTwo       = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[5]));  
										strOrderValThree             = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[9]));  
										strOrderValFour              = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[13]));
										
										valSchOne                    = Double.parseDouble(strOrderValScheduleOne);
										valSchTwo             	     = Double.parseDouble(strOrderValScheduleTwo);
										valSchThree           	     = Double.parseDouble(strOrderValThree);
										valSchFour            	     = Double.parseDouble(strOrderValFour);
										
										
										 totalValue    	 = valSchOne + valSchTwo + valSchThree + valSchFour;
										//System.out.println("totalGrandRejectedQty==>"+totalGrandRejectedQty);
										//System.out.println("totalReceivedQty==>"+totalReceivedQty);
							        	
									        // Store Name (1)+ Demand Qty(2) + [PO_qty(3) # Tot_Issue_Qty(3)] +Tot_Issue Qty(4)+ [Active Qty(5) # Quarntine Qty(5)] + Re-Order Qty(6) +[Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [I] +  Budget Avl(8) + DDW_ID(9)+All Sub Store(Consolidated)[10] + Pipe Line Qty [11] + Location [12]
							        	    //                                                                                                                                         [Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [II]
							        	 //                                                                                                                                            [Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [III]
							        	 //                                                                                                                                            [Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [IV]
									        String strPODetailsHidValue = wb.getString(1)+"^"+wb.getString(2)+"^"+wb.getString(3)+"^"+wb.getString(4)+"^"+wb.getString(5)+"^"+wb.getString(6)+"^"+wb.getString(7)+"^"+wb.getString(8)+"^"+wb.getString(9)+"^"+wb.getString(10)+"^"+wb.getString(11)+"^"+wb.getString(12);	
									       
									        		        
									        br.append("<input type='hidden' name='strSchedulePopUpHidValue' id='strSchedulePopUpHidValue"+i+"' value='"+wb.getString(7)+"'>");
									        br.append("<input type='hidden' name='strPODetailsHidValue' id='strPODetailsHidValue"+i+"' value='"+strPODetailsHidValue+"'>");
									        //br.append("<input type='hidden' name='reOrderFlag' id='reOrderFlag"+i+"' value='"+wb.getString(11)+"'>");
								            br.append("<tr>");
								            if(i == 0)
											{
								                br.append("<td  name='td10' id='td140"+i+"' style=\"text-align: right;\"   class='multiRPTLabel'  width='8%'><b>"+wb.getString(12)+"<b></td>");
											}
								            else
								            {
								            	br.append("<td  name='td10' id='td140"+i+"' style=\"text-align: right;\"   class='multiRPTLabel'  width='8%'></td>");
								            }
											br.append("<td  name='td10' id='td10"+i+"'  style=\"text-align: left;\"    class='multiPOControl'  width='12%'><b><a value='' style='cursor:pointer;'onClick='callingPoPUp(this,"+i+");'title='Click here to Get PO Specification'><font color='blue'>"+wb.getString(1)+"</font></a></b></td>");
											br.append("<td  name='td10' id='td20"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='9%'>"+totalGrandSchOne+"</td>");
											br.append("<td  name='td10' id='td30"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='9%'>"+totalReceivedQty+"</font></b></td>");
											//br.append("<td  name='td10' id='td40"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='9%'>"+wb.getString(3).split("\\#")[1]+"</td>");
										/*	br.append("<td  name='td10' id='td50"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='9%'><input  type='text' name='strScheduleOne'   id='strScheduleOne"+i+"'   onblur='POScheduleUtilityFunction("+i+",1);' value="+wb.getString(7).split("\\#")[0]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);' readonly></td>");
											br.append("<td  name='td10' id='td60"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='9%'><input  type='text' name='strScheduleTwo'   id='strScheduleTwo"+i+"'   onblur='POScheduleUtilityFunction("+i+",2);' value="+wb.getString(7).split("\\#")[4]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);' readonly></td>");
											br.append("<td  name='td10' id='td70"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='9%'><input  type='text' name='strScheduleThree' id='strScheduleThree"+i+"' onblur='POScheduleUtilityFunction("+i+",3);' value="+wb.getString(7).split("\\#")[8]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);' readonly></td>");								
											br.append("<td  name='td10' id='td80"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='9%'><input  type='text' name='strScheduleFour'  id='strScheduleFour"+i+"'  onblur='POScheduleUtilityFunction("+i+",4);' value="+wb.getString(7).split("\\#")[12]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);' readonly></td>");
										*/	br.append("<td  name='td10' id='td120"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='10%'><input type='text' name='strQrderQty'      id='strQrderQty"+i+"'      value="+totalGrandSchOne+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);' readonly></td>");	
											br.append("<td  name='td10' id='td130"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='9%'><input  type='text' name='strOrdeCost'      id='strOrdeCost"+i+"' class='txtFldNormal' disabled='disabled' value="+totalValue+"></td>");
										  	br.append("</tr>");  
									  	    
							        }
							        else
							        {
							        	strJonalLocation = wb.getString(12);
							        	
							        	strOrderQtyScheduleOne   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[0]));
										strOrderQtyScheduleTwo   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[4]));  
										strOrderQtyScheduleThree = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[8]));  
										strOrderQtyScheduleFour  = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[12]));  
										//System.out.println("strOrderQtyScheduleOne==>"+strOrderQtyScheduleOne+":::strOrderQtyScheduleTwo:::"+strOrderQtyScheduleTwo +":::strOrderQtyScheduleThree:::"+strOrderQtyScheduleThree+"::strOrderQtyScheduleFour:::"+strOrderQtyScheduleFour);
										
										cltamtSchOne             = Integer.parseInt(strOrderQtyScheduleOne);
										cltamtSchTwo             = Integer.parseInt(strOrderQtyScheduleTwo);
										cltamtSchThree           = Integer.parseInt(strOrderQtyScheduleThree);
										cltamtSchFour            = Integer.parseInt(strOrderQtyScheduleFour);
										
										totalGrandSchOne         = cltamtSchOne + cltamtSchTwo + cltamtSchThree + cltamtSchFour;
										//System.out.println("totalGrandSchOne==>"+totalGrandSchOne);
										/********************************************************************************/
										strAcceptedQtyScheduleOne   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[2]));
										strAcceptedQtyScheduleTwo   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[6]));  
										strAcceptedQtyScheduleThree = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[10]));  
										strAcceptedQtyScheduleFour  = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[14]));
										
										cltamtSchOne             	= Integer.parseInt(strAcceptedQtyScheduleOne);
										cltamtSchTwo             	= Integer.parseInt(strAcceptedQtyScheduleTwo);
										cltamtSchThree           	= Integer.parseInt(strAcceptedQtyScheduleThree);
										cltamtSchFour            	= Integer.parseInt(strAcceptedQtyScheduleFour);
										
										totalGrandAcceptedQty       = cltamtSchOne + cltamtSchTwo + cltamtSchThree + cltamtSchFour;
										//System.out.println("totalGrandAcceptedQty==>"+totalGrandAcceptedQty);
										/********************************************************************************/
										strRejectedQtyScheduleOne    = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[3]));
										strRejectedQtyyScheduleTwo   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[7]));  
										strRejectedQtyScheduleThree  = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[11]));  
										strRejectedQtyScheduleFour   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[15]));
										
										cltamtSchOne                 = Integer.parseInt(strRejectedQtyScheduleOne);
										cltamtSchTwo             	 = Integer.parseInt(strRejectedQtyyScheduleTwo);
										cltamtSchThree           	 = Integer.parseInt(strRejectedQtyScheduleThree);
										cltamtSchFour            	 = Integer.parseInt(strRejectedQtyScheduleFour);
										
										totalGrandRejectedQty    	 = cltamtSchOne + cltamtSchTwo + cltamtSchThree + cltamtSchFour;
										
										totalReceivedQty             = totalGrandAcceptedQty  + totalGrandRejectedQty;
										
										/********************************************************************************/
										strOrderValScheduleOne       = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[1]));
										strOrderValScheduleTwo       = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[5]));  
										strOrderValThree             = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[9]));  
										strOrderValFour              = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[13]));
										
										valSchOne                    = Double.parseDouble(strOrderValScheduleOne);
										valSchTwo             	     = Double.parseDouble(strOrderValScheduleTwo);
										valSchThree           	     = Double.parseDouble(strOrderValThree);
										valSchFour            	     = Double.parseDouble(strOrderValFour);
										
										
										 totalValue    	 = valSchOne + valSchTwo + valSchThree + valSchFour;
										
										//System.out.println("totalGrandRejectedQty==>"+totalGrandRejectedQty);
										//System.out.println("totalReceivedQty==>"+totalReceivedQty);
							        	
							        	   // Store Name (1)+ Demand Qty(2) + [PO_qty(3) # Tot_Issue_Qty(3)] +Tot_Issue Qty(4)+ [Active Qty(5) # Quarntine Qty(5)] + Re-Order Qty(6) +[Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [I] +  Budget Avl(8) + DDW_ID(9)+All Sub Store(Consolidated)[10] + Pipe Line Qty [11] + Location [12]
						        	    //                                                                                                                                         [Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [II]
						        	 //                                                                                                                                            [Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [III]
						        	 //  
								        String strPODetailsHidValue = wb.getString(1)+"^"+wb.getString(2)+"^"+wb.getString(3)+"^"+wb.getString(4)+"^"+wb.getString(5)+"^"+wb.getString(6)+"^"+wb.getString(7)+"^"+wb.getString(8)+"^"+wb.getString(9)+"^"+wb.getString(10)+"^"+wb.getString(11)+"^"+wb.getString(12);	
								        br.append("<input type='hidden' name='strPODetailsHidValue' id='strPODetailsHidValue"+i+"' value='"+strPODetailsHidValue+"'>");
								        br.append("<input type='hidden' name='strSchedulePopUpHidValue' id='strSchedulePopUpHidValue"+i+"' value='"+wb.getString(7)+"'>");
							            br.append("<tr>");
							            br.append("<td  name='td10' id='td140"+i+"' style=\"text-align: right;\"   class='multiRPTLabel'   width='8%'><b>"+wb.getString(12)+"<b></td>");
							            br.append("<td  name='td10' id='td10"+i+"'  style=\"text-align: left;\"    class='multiPOControl'  width='12%'><b><a value='' style='cursor:pointer;'onClick='callingPoPUp(this,"+i+");'title='Click here to Get PO Specefication'><font color='blue'>"+wb.getString(1)+"</font></a></b></td>");
										br.append("<td  name='td10' id='td20"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='9%'>"+totalGrandSchOne+"</td>");
										br.append("<td  name='td10' id='td30"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='9%'><a value='' style='cursor:pointer;'onClick='callingPoPUpTwo(this,"+i+");'title='Click here to Get PO Schedule Detail(s)'><font color='blue'>"+totalReceivedQty+"</font></a></b></td>");
										//br.append("<td  name='td10' id='td40"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='9%'>"+wb.getString(3).split("\\#")[1]+"</td>");
										/*br.append("<td  name='td10' id='td50"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='9%'><input  type='text' name='strScheduleOne'   id='strScheduleOne"+i+"'  onblur='POScheduleUtilityFunction("+i+",1);' value="+wb.getString(7).split("\\#")[0]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);' readonly></td>");
										br.append("<td  name='td10' id='td60"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='9%'><input  type='text' name='strScheduleTwo'   id='strScheduleTwo"+i+"'  onblur='POScheduleUtilityFunction("+i+",2);' value="+wb.getString(7).split("\\#")[4]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);' readonly></td>");
										br.append("<td  name='td10' id='td70"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='9%'><input  type='text' name='strScheduleThree' id='strScheduleThree"+i+"'onblur='POScheduleUtilityFunction("+i+",3);' value="+wb.getString(7).split("\\#")[8]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);' readonly></td>");								
										br.append("<td  name='td10' id='td80"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='9%'><input  type='text' name='strScheduleFour'  id='strScheduleFour"+i+"' onblur='POScheduleUtilityFunction("+i+",4);' value="+wb.getString(7).split("\\#")[12]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);' readonly></td>");
									*/	br.append("<td  name='td10' id='td120"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='10%'><input type='text' name='strQrderQty'      id='strQrderQty"+i+"'     value="+totalGrandSchOne+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);' readonly></td>");	
										br.append("<td  name='td10' id='td130"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='9%'><input  type='text' name='strOrdeCost'      id='strOrdeCost"+i+"' class='txtFldNormal' disabled='disabled' value="+totalValue+"></td>");
									  	br.append("</tr>");  
								  	    count++;
							        	
							        	
							        	
							        }						        
							        if(_PODeskGenerateTransNewFB.getStrMode().equals("2"))
								  	{	
							        	
							          cltamt = Double.parseDouble(formatter.format(new BigDecimal(Double.parseDouble(wb.getString(7).split("\\#")[1])+Double.parseDouble(wb.getString(7).split("\\#")[5])+Double.parseDouble(wb.getString(7).split("\\#")[9])+Double.parseDouble(wb.getString(7).split("\\#")[13]))));						
							          totalGrandCost = totalGrandCost + cltamt;
							          
							          totalQty = Double.parseDouble(wb.getString(7).split("\\#")[0])+Double.parseDouble(wb.getString(7).split("\\#")[4])+Double.parseDouble(wb.getString(7).split("\\#")[8])+Double.parseDouble(wb.getString(7).split("\\#")[12]);
							          grandTotalQty = grandTotalQty + totalQty;
							          //wb.getString(7).split("\\#")[0]
								  	}						  	    
						            i=i+1;					     
					   }
				}
				
				
				br.append("<tr>");			
//				br.append("<td colspan='1'  class='multiPOLabel'></td>");
//				br.append("<td colspan='1'  class='multiPOLabel'></td>");
//				br.append("<td colspan='1'  class='multiPOLabel'></td>");
//				br.append("<td colspan='1'  class='multiPOLabel'></td>");
//				br.append("<td colspan='1'  class='multiPOLabel'></td>");				
//				br.append("<td width='7%'  class='multiPOLabel'></td>");				
//				br.append("<td width='7%'  class='multiPOLabel'></td>");
//				br.append("<td width='7%'  class='multiPOLabel'></td>");
//				br.append("<td width='7%'  class='multiPOLabel'></td>");
				br.append("<td colspan='4' class='multiRPTLabel'><div align='right'>Total Order Qty :: </div></td>");	
				if(_PODeskGenerateTransNewFB.getStrMode().equals("2"))
			  	{
				    br.append("<td colspan='1'  class='multiRPTLabel'><input type='text' name='strTotalQrderQty' readonly  value='"+grandTotalQty+"' id='strTotalQrderQty'  class='txtFldNormal'></td>");
			  	}
				else
				{
					br.append("<td colspan='1'  class='multiRPTLabel'><input type='text' name='strTotalQrderQty' readonly  value='0' id='strTotalQrderQty'  class='txtFldNormal'></td>");
				}
				br.append("<td colspan='1'  class='multiRPTLabel'></td>");
				//br.append("<td colspan='1'  class='multiPOLabel'></td>");
				br.append("</tr>");
	
				
				br.append("</table>");
			
		} 
		catch (Exception _e) 
		{
			_e.printStackTrace();
			_PODeskGenerateTransNewFB
					.setStrMsg("PODeskGenerateTransNewHLP.getImpContiRequestDetails() --> "
							+ _e.getMessage());
			_PODeskGenerateTransNewFB.setStrMsgType("1");
		}
		if(_PODeskGenerateTransNewFB.getStrMode().equals("2"))
	  	{
			//System.out.println("In Modify 2:::"+br.toString()+"^^^2^^^"+totalGrandCost);
			String FinaltotalCost = formatter.format(new BigDecimal(totalGrandCost));  
		    return br.toString()+"^^^2^^^"+FinaltotalCost;
	  	}
		else
		{
			//System.out.println("In Generate:::"+br.toString()+"^^^1^^^0");
			return br.toString()+"^^^1^^^0";	
		}
		
		
	}
	
	
	public static String getImpContiRequestDetails(
			PODeskGenerateTransNewFB _PODeskGenerateTransNewFB) {

		StringBuffer br = new StringBuffer("");
		WebRowSet wb = null;
		try {
			wb = _PODeskGenerateTransNewFB.getWbRequestDetail();
			if (wb.size() != 0) {
				br.append("<table class='TABLEWIDTH' bgcolor='black' align='center' cellspacing='1px'>");
				br.append("<tr>");
				br.append("<td width='5%' class='multiLabel'><input type='checkbox' name='strCheckAll' onclick='checkAll();'>");
				br.append("</td><td width='35%' class='multiLabel'>Request No.");
				br.append("</td><td width='25%' class='multiLabel'>Request Date");
				br.append("</td><td width='15%' class='multiLabel'>Request Type");
				br.append("</td><td width='20%' class='multiLabel'>Raising Store");
				br.append("</td></tr>");
				
				br.append("</table>");
				br.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center' cellspacing='1px'>");
				int nTmpI = 0;
				while (wb.next()) {
					br.append("<tr>");
					br.append("<td width='5%' class='multiControl'>");

					br.append("<input type='hidden' name='strDRequestNo' value='"
									+ wb.getString(1) + "' disabled=true>");
					br.append("<input type='hidden' name='strDRaisingStore' value='"
									+ wb.getString(2) + "' disabled=true>");
					br.append("<input type='hidden' name='strDRequestDate' value='"
									+ wb.getString(3) + "' disabled=true>");
					br.append("<input type='hidden' name='strDCRNo' value='' disabled=true>");
					br.append("<input type='hidden' name='strDRequestType' value='"
									+ wb.getString(5) + "' disabled=true>");
					br.append("<input type='hidden' name='strDRequestPeriod' value='' disabled=true>");

					br.append("<input type='checkbox' name='strCheckBox' onclick='checkData(this);' value='");
					br.append(wb.getString(1) + "^" + wb.getString(2) + "^"
							+ wb.getString(3) + "^/^" + wb.getString(5) + "^/");
					br.append("'>");

					br.append("</td><td width='35%' class='multiControl'>");
					br.append(wb.getString(1));
					br.append("</td><td width='25%' class='multiControl'>");
					br.append(wb.getString(3));
					br.append("</td><td width='15%' class='multiControl'>");
					br.append(wb.getString(6));
					br.append("</td><td width='20%' class='multiControl'>");
					br.append(wb.getString(4));
					br.append("</td></tr>");
					nTmpI++;
				}
				br.append("</table>");
			} else {
				br.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>");
				br.append("<tr>");
				br.append("<td colspan='5'  CLASS='multiControl' ><DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED STORE NAME OR ITEM CATEGORY </div></TD>");

				br.append("</tr>");
				br.append("</table>");

			}
		} catch (Exception _e) {
			_e.printStackTrace();
			_PODeskGenerateTransNewFB
					.setStrMsg("PODeskGenerateTransNewHLP.getImpContiRequestDetails() --> "
							+ _e.getMessage());
			_PODeskGenerateTransNewFB.setStrMsgType("1");
		}
		return br.toString();
	}

	public static String getAnnualRequestDetails(
			PODeskGenerateTransNewFB _PODeskGenerateTransNewFB) {

		StringBuffer br = new StringBuffer("");
		WebRowSet wb = null;
		try {
			wb = _PODeskGenerateTransNewFB.getWbRequestDetail();
			if (wb.size() != 0) {
				br
						.append("<table class='TABLEWIDTH' bgcolor='black' align='center' cellspacing='1px'>");
				br.append("<tr>");
				br
						.append("<td width='5%' class='multiLabel'><input type='checkbox' name='strCheckAll' onclick='checkAll();'>");
				br.append("</td><td width='20%' class='multiLabel'>Agenda No.");
				br
						.append("</td><td width='17%' class='multiLabel'>Agenda Date");
				br
						.append("</td><td width='18%' class='multiLabel'>Request Type");
				br
						.append("</td><td width='13%' class='multiLabel'>Agenda Period");
				br
						.append("</td><td width='28%' class='multiLabel'>Compilation Store");
				br.append("</td></tr>");
				br.append("</table>");
				br.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center' cellspacing='1px'>");
				int nTmpI = 0;
				while (wb.next()) {
					br.append("<tr>");
					br.append("<td width='5%' class='multiControl'>");

					br
							.append("<input type='hidden' name='strDRequestNo' value='"
									+ wb.getString(1) + "' disabled=true>");
					br
							.append("<input type='hidden' name='strDRaisingStore' value='"
									+ wb.getString(2) + "' disabled=true>");
					br
							.append("<input type='hidden' name='strDRequestDate' value='"
									+ wb.getString(3) + "' disabled=true>");
					br
							.append("<input type='hidden' name='strDCRNo' value='' disabled=true>");
					br
							.append("<input type='hidden' name='strDRequestType' value='"
									+ wb.getString(6) + "' disabled=true>");
					br
							.append("<input type='hidden' name='strDRequestPeriod' value='"
									+ wb.getString(4) + "' disabled=true>");

					br
							.append("<input type='checkbox' name='strCheckBox' onclick='checkData(this);' value='");
					br.append(wb.getString(1) + "^" + wb.getString(2) + "^"
							+ wb.getString(3) + "^/^" + wb.getString(6) + "^"
							+ wb.getString(4));
					br.append("'>");

					br.append("</td><td width='20%' class='multiControl'>");
					br.append(wb.getString(1));
					br.append("</td><td width='17%' class='multiControl'>");
					br.append(wb.getString(3));
					br.append("</td><td width='18%' class='multiControl'>");
					br.append(wb.getString(7));
					br.append("</td><td width='13%' class='multiControl'>");
					br.append(wb.getString(8));
					br.append("</td><td width='28%' class='multiControl'>");
					br.append(wb.getString(5));
					br.append("</td></tr>");
					nTmpI++;
				}
				br.append("</table>");
			} else {
				br
						.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>");
				br.append("<tr>");
				br
						.append("<td colspan='5'  CLASS='multiControl' ><DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED STORE NAME OR ITEM CATEGORY </div></TD>");

				br.append("</tr>");
				br.append("</table>");

			}
		} catch (Exception _e) {
			_PODeskGenerateTransNewFB
					.setStrMsg("PODeskGenerateTransNewHLP.getAnnualRequestDetails() --> "
							+ _e.getMessage());
			_PODeskGenerateTransNewFB.setStrMsgType("1");
		}
		return br.toString();
	}

	public static String getRequestItemDetails(PODeskGenerateTransNewFB _PODeskGenerateTransNewFB) 
	{

		StringBuffer br = new StringBuffer("");
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		WebRowSet wb = null;
		String strDivId = "";
		try 
		{
			PODeskGenerateTransNewVO = new PODeskGenerateTransNewVO();
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			int nTmpI = 0;
			for (int nTmpJ = 0; nTmpJ < _PODeskGenerateTransNewFB.getStrRequestIds().replace("^", "#").split("#").length; nTmpJ++)
			{
				strDivId = _PODeskGenerateTransNewFB.getStrRequestIds().replace(
						"^", "#").split("#")[nTmpJ];
				br.append("<table class='TABLEWIDTH' align='center' cellpadding='1px'");
				br.append("cellspacing='1px'>");
				br.append("<tr>");
				br.append("<td class='TITLE' colspan='4'>");
				br.append("<div  id='" + strDivId + "PlusID' name='" + strDivId
						+ "PlusID' style='display: none;' align='left'><img");
				br.append(" src='../../hisglobal/images/plus.gif' title='To Show Detials' onclick='hideRequestItem(this);' style='cursor: pointer;'> Request No./Date ");
				br.append(_PODeskGenerateTransNewFB.getStrReqIdnDate().replace(
						"^", "#").split("#")[nTmpJ]);
				br.append("</div><div id='" + strDivId
						+ "MinusID' style='display: block;' align='left'><img");
				br.append(" src='../../hisglobal/images/minus.gif' title='To Hide Details' onclick='hideDiv(\"");
				br.append(strDivId);
				br.append("\"),hideDiv(\""
								+ strDivId
								+ "MinusID\"),showDiv(\""
								+ strDivId
								+ "PlusID\");' style='cursor: pointer;'> Request No./Date ");
				br.append(_PODeskGenerateTransNewFB.getStrReqIdnDate().replace(
						"^", "#").split("#")[nTmpJ]);
				br.append("</div></td>");
				br.append("</tr>");
				br.append("</table>");

				PODeskGenerateTransNewVO.setStrItemCat(_PODeskGenerateTransNewFB.getStrItemCat());
				PODeskGenerateTransNewVO.setStrHospitalCode(_PODeskGenerateTransNewFB.getStrHospitalCode());
				PODeskGenerateTransNewVO.setStrRequestId(_PODeskGenerateTransNewFB.getStrRequestIds().replace("^", "#").split("#")[nTmpJ]);
				PODeskGenerateTransNewVO.setStrSupplierId(_PODeskGenerateTransNewFB.getStrSupplierId().replace("^", "#").split("#")[0]);
				PODeskGenerateTransNewVO.setStrStoreId(_PODeskGenerateTransNewFB.getStrCheckData().replace("~", "#").split("#")[nTmpJ].replace("^", "#").split("#")[1]);
				PODeskGenerateTransNewVO.setStrContractType(_PODeskGenerateTransNewFB.getStrContractType());
				PODeskGenerateTransNewVO.setStrPOTypeId(_PODeskGenerateTransNewFB.getStrPOTypeId());
                // Calling BO Method   
				PODeskGenerateTransNewBO.getRequestItemDetails(PODeskGenerateTransNewVO);

				if (PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
					throw new Exception(PODeskGenerateTransNewVO.getStrMsgString());

				_PODeskGenerateTransNewFB.setWbRequestItemDetail(PODeskGenerateTransNewVO.getWbRequestItemDetail());

				wb = _PODeskGenerateTransNewFB.getWbRequestItemDetail();

				if (wb.size() != 0) 
				{
					br.append("<div id="
							+ _PODeskGenerateTransNewFB.getStrRequestIds().replace("^", "#").split("#")[nTmpJ] + ">");
					br.append("<table class='TABLEWIDTH' bgcolor='black' align='center' cellspacing='1px'>");
					br.append("<tr>");
					br.append("<td width='5%' class='multiLabel'>#");
					br.append("</td><td width='44%' class='multiLabel'>Item Name");
					br.append("</td><td width='15%' class='multiLabel'>Balance Qty");
					br.append("</td><td width='14%' class='multiLabel'><font color='red'>*</font>Order Qty");
					br.append("</td><td width='14%' class='multiLabel'><font color='red'>*</font>Order Unit");
					br.append("</td><td width='13%' class='multiLabel'><font color='red'>*</font>Enter Details");
					br.append("</td></tr>");
					
					br.append("</table>");
					br.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center' cellspacing='1px'>");
					
					while (wb.next()) 
					{
						br.append("<tr>");
						br.append("<td width='5%' class='multiControl'>");
						br.append("<input type='checkbox' onclick='checkItem(\""
										+ nTmpI
										+ "\");' name='strCheckBoxItem' value='");
						br.append(_PODeskGenerateTransNewFB.getStrRequestIds().replace("^", "#").split("#")[nTmpJ]);
						br.append("'>");
						
						br.append("<input type='hidden' name='strTmpItemCost' id='strTmpItemCost"+nTmpI+"'  value='0'>");
						br.append("<input type='hidden' name='strTmpReqNo' value='"	+ strDivId + "' disabled=true>");
						br.append("<input type='hidden' name='strTmpBaseValue' value='"	+ wb.getString(13) + "' disabled=true>");
						br.append("<input type='hidden' name='strTmpBalQty' value='"+ wb.getString(8).replace(" ", "#").split("#")[0] + "'>");
						br.append("<input type='hidden' name='strTmpRaisingStore' value='"+ _PODeskGenerateTransNewFB.getStrCheckData().replace("~", "#").split("#")[nTmpJ].replace("^", "#").split("#")[1] + "' disabled=true>");
						br.append("<input type='hidden' name='strDitemId' value='"+ wb.getString(1) + "' disabled=true>");
						br.append("<input type='hidden' name='strDitemBrandId' value='"+ wb.getString(2) + "' disabled=true>");
						br.append("<input type='hidden' name='strDGroupId' value='"	+ wb.getString(4) + "' disabled=true>");
						br.append("<input type='hidden' name='strDSubGroupId' value='"+ wb.getString(5) + "' disabled=true>");
						br.append("<input type='hidden' name='strDSanctionQty' value='"	+ wb.getString(9).replace(" ", "#").split("#")[0]+ "' disabled=true>");
						br.append("<input type='hidden' name='strDSanctionQtyUnit' value='"	+ wb.getString(7) + "' disabled=true>");

						br.append("</td><td width='44%' class='multiControl'>");
						br.append(wb.getString(6));
						br.append("</td><td width='15%' class='multiControl'>");
						br.append("<a STYLE='CURSOR:POINTER;color:blue' title='Get Details' onClick='display_popup_menu(this,\"itemBalDtlPopup");
						br.append(nTmpI);
						br.append("\",\"250\",\"\");'>");
						br.append(wb.getString(8));
						br.append("</a>");
						 /*******Start -- Pop-Up Get After Clicking On Balance Qty****Commented by Amit Kr 5-Jan-2011*****/
						br.append("<div class='popup' id='itemBalDtlPopup");
						br.append(nTmpI);
						br.append("' style='display:none'>");
                       
						br.append("<table width='400' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
						br.append("<tr class='HEADER'>");
						br.append("<th align='right' colspan=4><img  style='cursor:pointer;cursor:pointer' title='To Close PopUp Window' src='../../hisglobal/images/popUp_cancel.JPG'");
						br.append("onClick='hide_popup_menu(\"itemBalDtlPopup");
						br.append(nTmpI);
						br.append("\");'></th>");
						br.append("</tr>");
						br.append("</table>");
						br.append("<table width='400' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
						br.append("<tr>");
						br.append("<td width='25%' class='LABEL'>Sanction Qty.");
						br.append("</td><td width='25%' class='CONTROL'>");
						br.append(wb.getString(9));
						br.append("</td><td width='25%' class='LABEL'>Ordered Qty.");
						br.append("</td><td width='25%' class='CONTROL'>");
						br.append(wb.getString(10));
						br.append("</td></tr>");
						br.append("</table>");

						br.append("</div>");
						 /******* EnD -- Pop-Up Get After Clicking On Balance Qty*********/
						br.append("</td><td width='14%' class='multiControl'>");
						br.append("<input type=text class=txtFldNormal onkeypress='return validateData(event,5);' onkeyup='checkOrderQty(this)' maxlength='11' name=strDOrderQty id='strDOrderQty"+nTmpI+"' disabled=true>");
						br.append("</td><td width='14%' class='multiControl'>");

						PODeskGenerateTransNewVO.setStrInventoryUnitId(wb.getString(12));
						
						PODeskGenerateTransNewVO.setStrMatchUnitCmb(wb.getString(15));
						/********** Calling BO Method to Get Unit *************/
						PODeskGenerateTransNewBO.setUnitValues(PODeskGenerateTransNewVO);

						br.append("<select name=strDOrderQtyUnitId id='strDOrderQtyUnitId"+nTmpI+"' onchange='checkOrderQty(this)' disabled=true>"
										+ PODeskGenerateTransNewVO.getStrRateUnitValues()
										+ "</select>");
						br.append("</td><td width='13%' class='multiControl'>");
						br.append("<img src='../../hisglobal/images/add_remarks.png' title='Enter Item Details' style='cursor: pointer;' ");
						br.append("title='Enter Details of Item' onclick='display_popup_menu(this,\"itemDtlPopup");
						br.append(nTmpI);
						br.append("\",\"150\",\"\"),showComboInPopup(" + nTmpI
								+ ");'>");
						
						
						
						/*******Start -- Pop-Up Get After Clicking On Enter Details Image**** Commented by Amit Kr 5-Jan-2011*****/
						br.append("<div class='popup' id='itemDtlPopup");
						br.append(nTmpI);
						br.append("' style='display:none'>");
         
						br.append("<table width='600' border='0' bgcolor='#6097BC' cellspacing ='0' cellpGenerateing='1'>");
						br.append("<tr class='HEADER'><th align='left'>Item Details for ");
						br.append(wb.getString(6));
						br.append("</th><th align='right'><img  style='cursor:pointer;cursor:pointer' title='To Close PopUp Window' src='../../hisglobal/images/popUp_cancel.JPG'");
						br.append("onClick='hide_popup_menu(\"itemDtlPopup"	+ nTmpI + "\");'></th>");
						br.append("</tr>");
						br.append("</table>");
						
						br.append("<table width='600' border='0' cellspacing ='1' cellpGenerateing='1' bgcolor='#6097BC'>");
						br.append("<tr>");
						br.append("<td width='25%' class='LABEL'><font color='red'>*</font>Rate");
						br.append("</td><td width='25%' class='CONTROL'>");
						br.append("<input type=text name=strDRate id='strDRate"+nTmpI+"' maxlength=12 onkeypress=\"return(numericWithTwoDecimalPlaces(this,',','.',event));\"  onClick='ResetUnit(this,"+ nTmpI +");' onKeyUp='CalculateCostOfItemWithTax("+ nTmpI +");' value='"
										+ (wb.getString(11).replace("^", "#").split("#")[0].equals("-1") ? "": wb.getString(11).replace("^","#").split("#")[0])
										+ "' disabled=true>");
						br.append("</td><td width='25%' class='LABEL'><font color='red'>*</font>Rate Unit.");
						br.append("</td><td width='25%' class='CONTROL'><select name=strDRateUnitId id='strDRateUnitId"+nTmpI+"' disabled=true>");
						PODeskGenerateTransNewVO.setStrItemCat(_PODeskGenerateTransNewFB.getStrItemCat());
						if(wb.getString(11).replace("^","#").split("#").length>1)
						{
							PODeskGenerateTransNewVO.setStrRateUnitId(wb.getString(11).replace("^","#").split("#")[1]);
						}
						/*Calling BO Method*/
						PODeskGenerateTransNewBO.setUnitValues(PODeskGenerateTransNewVO);
						/*Calling BO Method*/
						PODeskGenerateTransNewBO.setManufacturerValues(PODeskGenerateTransNewVO);
						
						br.append(PODeskGenerateTransNewVO.getStrRateUnitValues());
						br.append("</select></td></tr>");
						br.append("<tr>");
						br.append("<td width='25%' class='LABEL'><font color='red'>*</font>Tax");
						br.append("</td><td width='25%' class='CONTROL'>");
						br.append("<input type=text  maxlength='5' value='0' onkeypress='return validateData(event,5);' onkeyup='notGreaterThanCent(this),CalculateCostOfItemWithTax("+ nTmpI +");'  class=txtFldMin name=strDTax id='strDTax"+nTmpI+"' disabled=true>%");
						br.append("</td><td width='25%' class='LABEL'><font color='red'>*</font>Manufacturer");
						br.append("</td><td width='25%' class='CONTROL'><select name='strDManufacturerId' id='strDManufacturerId"+nTmpI+"' disabled=true>");
						br.append(PODeskGenerateTransNewVO.getStrManufacturerValues());
						br.append("</select></td></tr>");
						br.append("<tr>");
						br.append("<td class='LABEL' width='25%'>Make</td>");
						br.append("<td class='CONTROL' width='25%'>");
						br.append("<select name='strMake'  disabled='true' >");
						br.append("<option value='1'>Indian</option>");
						br.append("<option value='2'>Imported</option>");
						br.append("</select></td>");
						br.append("<td class='LABEL' width='25%'>Total Rate</td>");
						br.append("<td class='CONTROL' width='25%'><input type=text name=itemCostDiv id='itemCostDiv"+nTmpI+"'  style='color: red; font-weight: bold' disabled=true>");
						br.append("</td>");
						br.append("</tr>");
						String[] strTmpWIDtls = wb.getString(14).replace("^", "#").split("#");
						if(strTmpWIDtls[1].equals("1") && strTmpWIDtls[2].equals("1"))
						{
							//System.out.println("==>ONE");
							br.append("<tr>");
						
							br.append("<td width='25%' class='LABEL'>Warranty Required");
							br.append("</td><td width='25%' class='CONTROL'>");
						
							br.append("<input type=hidden name=strDWarrantyRequired value=0 disabled=true>");
							br.append("<input type=checkbox name=strWarrantyRequired  onclick=\"checkWarranty('"
											+ nTmpI + "')\" disabled='true'>");
							br.append("</td><td width='25%' class='LABEL'>Instatllation Required");
							br.append("</td><td width='25%' class='CONTROL'>");
							br.append("<input type=hidden name=strDInstallationRequired value=0  disabled=true>");
							br.append("<input type=checkbox name=strInstallationRequired onclick=\"checkInstallation('"
											+ nTmpI + "')\" disabled='true'>");
							br.append("</td></tr>");
							br.append("<tr>");
							br.append("<td class='LABEL' colspan=4>");
							br.append("<div align=center><center><img	src='../../hisglobal/images/btn-sv.png'");
							br.append("style='cursor: pointer; ' title='Save Record'");
							br.append("onClick='hide_popup_menu(\"itemDtlPopup"
									+ nTmpI + "\");' /> <img");
							br.append("src='../../hisglobal/images/btn-ccl.png'");
							br.append("style='cursor: pointer; ' title='Cancel Process'");
							br.append("onClick='cancelPopup('" + nTmpI
									+ "');'></center></div>");
							br.append("</td></tr>");
							br.append("</table>");

							br.append("</div>");
							

							br.append("</td></tr>");
						}
						else 
							if(strTmpWIDtls[1].equals("1") && strTmpWIDtls[2].equals("0"))
							{
								//System.out.println("==>TWO");
							br.append("<tr>");
							
							br.append("<td width='25%' class='LABEL'>Warranty Required");
							br.append("</td><td width='75%' colspan=3 class='CONTROL'>");
						
							br.append("<input type=hidden name=strDWarrantyRequired value=0 disabled=true>");
							br.append("<input type=checkbox name=strWarrantyRequired  onclick=\"checkWarranty('"
											+ nTmpI + "')\" disabled=true>");
							br.append("<input type=hidden name=strDInstallationRequired value=0  disabled=true>");
							br.append("<input type=hidden name=strInstallationRequired onclick=\"checkInstallation('"
											+ nTmpI + "')\" disabled=true>");
							br.append("</td></tr>");
							br.append("<tr>");
							br.append("<td class='LABEL' colspan=4>");
							br.append("<div align=center><center><img	src='../../hisglobal/images/btn-sv.png'");
							br.append("style='cursor: pointer; ' title='Save Record'");
							br.append("onClick='hide_popup_menu(\"itemDtlPopup"
									+ nTmpI + "\");' /> <img");
							br.append("src='../../hisglobal/images/btn-ccl.png'");
							br.append("style='cursor: pointer; ' title='Cancel Process'");
							br.append("onClick='cancelPopup('" + nTmpI
									+ "');'></center></div>");
							br.append("</td></tr>");
							br.append("</table>");

							br.append("</div>");

							br.append("</td></tr>");
						}
							else 
								if(strTmpWIDtls[1].equals("1") && strTmpWIDtls[2].equals("0"))
								{
									//System.out.println("==>Three");
							br.append("<tr>");
							
							br.append("<td width='25%' class='LABEL'>Instatllation Required");
							br.append("</td><td width='75%' colspan=3 class='CONTROL'>");
						
							br.append("<input type=hidden name=strDWarrantyRequired value=0 disabled=true>");
							br.append("<input type=hidden name=strWarrantyRequired  onclick=\"checkWarranty('"
											+ nTmpI + "')\" disabled=true>");
							br.append("<input type=hidden name=strDInstallationRequired value=0  disabled=true>");
							br.append("<input type=checkbox name=strInstallationRequired onclick=\"checkInstallation('"
											+ nTmpI + "')\" disabled=true>");
							br.append("</td></tr>");
							br.append("<tr>");
							br.append("<td class='LABEL' colspan=4>");
							br.append("<div align=center><center><img	src='../../hisglobal/images/btn-sv.png'");
							br.append("style='cursor: pointer; ' title='Save Record'");
							br.append("onClick='hide_popup_menu(\"itemDtlPopup"
									+ nTmpI + "\");' /> <img");
							br.append("src='../../hisglobal/images/btn-ccl.png'");
							br.append("style='cursor: pointer; ' title='Cancel Process'");
							br.append("onClick='cancelPopup('" + nTmpI
									+ "');'></center></div>");
							br.append("</td></tr>");
							br.append("</table>");

							br.append("</div>");

							br.append("</td></tr>");
						}else if(strTmpWIDtls[1].equals("0") && strTmpWIDtls[2].equals("0")){
							//System.out.println("==>FOUR");
							br.append("<tr>");
							br.append("<td class='LABEL' colspan=4>");
							br.append("<input type=hidden name=strDWarrantyRequired value=0 disabled=true>");
							br.append("<input type=hidden name=strWarrantyRequired  onclick=\"checkWarranty('"
											+ nTmpI + "')\" disabled=true>");
							br.append("<input type=hidden name=strDInstallationRequired value=0  disabled=true>");
							br.append("<input type=hidden name=strInstallationRequired onclick=\"checkInstallation('"
											+ nTmpI + "')\" disabled=true>");
							br.append("<div align=center><center><img	src='../../hisglobal/images/btn-sv.png'");
							br.append("style='cursor: pointer; ' title='Save Record'");
							br.append("onClick='ClosePopUp("+nTmpI+");' /> <img");
							br.append("src='../../hisglobal/images/btn-ccl.png'");
							br.append("style='cursor: pointer; ' title='Cancel Process'");
							br.append("onClick='cancelPopup('" + nTmpI
									+ "');'></center></div>");
							br.append("</td></tr>");
							br.append("</table>");

							br.append("</div>");
							/*******  END  -- Pop-Up Get After Clicking On Enter Details Image**** Commented by Amit Kr 5-Jan-2011*****/

							br.append("</td></tr>");
						}
						nTmpI++;
					}
					br.append("</table>");
					br.append("</div>");
				} else {
					br.append("<div id="
							+ _PODeskGenerateTransNewFB.getStrRequestIds().replace("^", "#").split("#")[nTmpJ] + ">");
					br.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>");
					br.append("<tr>");
					br.append("<td colspan='5'  CLASS='multiControl' ><DIV class='errMsg' align='center'>No Record Found</div></TD>");
					br.append("</tr>");
					br.append("</table>");
					br.append("</div>");
				}
			}
		} catch (Exception _e) {
			_e.printStackTrace();
			_PODeskGenerateTransNewFB
					.setStrMsg("PODeskGenerateTransNewHLP.getIndentDetails() --> "
							+ _e.getMessage());
			_PODeskGenerateTransNewFB.setStrMsgType("1");
		}
		return br.toString();
	}

	public static String getComponentDetail(PODeskGenerateTransNewFB _PODeskGenerateTransNewFB) 
	{
		StringBuffer sBuffer = null;

		try 
		{
			sBuffer = new StringBuffer("");

			for (int nTmpI = 0; nTmpI < _PODeskGenerateTransNewFB
					.getStrComponentID().length; nTmpI++) 
			{
				sBuffer.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#6097BC' cellspacing='1px'><tr>");
				sBuffer.append("<td width='30%' class='LABEL'>"	+ _PODeskGenerateTransNewFB.getStrComponentName()[nTmpI]+ "</td>");
				sBuffer.append("<td width='70%' class='CONTROL'><input type='hidden' name='strDComponentId' value='"+ _PODeskGenerateTransNewFB.getStrComponentID()[nTmpI]+ "'>" +
				"<textarea name='strDComponentValue' style='width:700px; height:200px ' disabled>"
								+ _PODeskGenerateTransNewFB.getStrComponentValue()[nTmpI]
								+ "</textarea></td>");
				sBuffer.append("</tr></table>");
			}
			if (_PODeskGenerateTransNewFB.getStrMsgType().equals("1"))
				throw new Exception(_PODeskGenerateTransNewFB.getStrMsgString());
		} catch (Exception _e) {
			_e.printStackTrace();
			_PODeskGenerateTransNewFB
					.setStrMsgString("PODeskGenerateTransNewHLP.getComponentDetail() --> "
							+ _e.getMessage());
			_PODeskGenerateTransNewFB.setStrMsgType("1");
		}
		return sBuffer.toString();
	}

}
