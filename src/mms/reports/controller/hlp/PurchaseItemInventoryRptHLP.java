package mms.reports.controller.hlp;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;

import javax.sql.rowset.WebRowSet;

import mms.reports.controller.fb.PurchaseItemInventoryRptFB;
import mms.reports.vo.PurchaseItemInventoryRptVO;

public class PurchaseItemInventoryRptHLP 
{
	
	public static String getReportDetails(PurchaseItemInventoryRptFB formBean,PurchaseItemInventoryRptVO vo) 
	 {
		StringBuffer sb = new StringBuffer("");
		WebRowSet ws = vo.getReportDtlWs();
		int i=0,j=1;
		double totamt = 0.00;
		
		int poQty = 0;
		int accpQty = 0;
		int balanceQty = 0;
		
	    try
	    {
	    
		if (ws != null) 
		{
			if(ws.size() != 0)
			{
				
				String strHospitalCode = formBean.getStrHospitalCode();

				String strFromDate = formBean.getStrFromDate();
				String strToDate = formBean.getStrToDate();
				
				
				String strItemName = formBean.getStrItemName();			
				String strSupplierName = formBean.getStrSupplierName();
				String strPoStatusName = formBean.getStrPoStatusName();
				String strPoTypeName = formBean.getStrPoTypeName();
				
				HisUtil hisUtil=new HisUtil("Global","ReportUtil");
				HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(formBean.getStrHospitalCode());
				
				//System.out.println("hospitalVO.getAddress1()"+hospitalVO.getHospitalName());
				//System.out.println("the ws length isa  "+ws.getKeyColumns());
				
				sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");
				sb.append(" <tr> "
						+ " <td colspan='12'><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' /></div></td>");
				sb.append("</tr>");
				sb.append(" <tr> "
						+ " <td colspan='12'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>"
						//+ " <td colspan='12'><div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></td>"
						);
						sb.append("</tr>");
				
				sb.append(" <tr> "
						+ " <td colspan='12' align='center' style='font-size:16px;'><b></b></td>");
				sb.append("</tr>");
				
				
				sb.append("</table>");
						
				sb.append("<table align='center' cellspacing='1px' cellpadding='1px' border='0' WIDTH='TABLEWIDTH'>"
						+ " <tr> <td width='8%' colspan='3'></td>"	
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"
						+ "<b>"+"Purchase Item Inventory Report"+"</b>"
						+ "<br>For Supplier Name :: <b>"+strSupplierName+"</b></font></td><td align='center' colspan='2'></td></tr>" 
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Item Name ::<b>"+strItemName+"</b></font></td><td align='center' colspan='2'></td></tr>" 
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For PO Type ::<b>"+strPoTypeName+"</b></font></td><td align='center' colspan='2'></td></tr>" 
						
						+ " <tr> <td align='center' colspan='3'></td>"
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "From Date ::<b>"+strFromDate+"</b> To Date ::<b>"+strToDate+"</b></font></td>"
								+ "<td align='center' colspan='2'>"
								+ "<div id='printid1' class='hidecontrol' style='float:right'>"
								+"</div></td></tr>" +
											
						 "</table> ");
				
				

				sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
		        sb.append("<tr>");
		        sb.append("<td width='5%' align='center'>S.No");
			    sb.append("</td>");
		        sb.append("<td width='21%' align='center'>Item Name");
			    sb.append("</td>");
			    sb.append("<td width='19%' align='center'>Supplier");
			    sb.append("</td>");
			    sb.append("<td width='15%' align='center'>PO No/Date");
		        sb.append("</td>");		              
		        sb.append("<td width='8%' align='center'>Rate Wth Tax");
		        sb.append("</td>");   	       
		        sb.append("<td width='8%' align='center'>Cost ");
			    sb.append("</td>");
			    sb.append("<td width='8%' align='center'>PO Qty");
		        sb.append("</td>");
			    sb.append("<td width='8%' align='center'>Accp Qty");
			    sb.append("</td>");
			    sb.append("<td width='8%' align='center'>Balance Qty");
			    sb.append("</td>");
			    
		        sb.append("</tr>");
		      
		        
				while(ws.next())
				{		
					
							if(i==0)
							{
								totamt = Double.parseDouble(ws.getString(5));
								
								    poQty  = Integer.parseInt(ws.getString(7));
								  accpQty  = Integer.parseInt(ws.getString(9));
								balanceQty = Integer.parseInt(ws.getString(10));
							}
							else
							{
								totamt = totamt + Double.parseDouble(ws.getString(5));
								
								 poQty  = poQty +Integer.parseInt(ws.getString(7));
								  accpQty  = accpQty +Integer.parseInt(ws.getString(9));
								balanceQty = balanceQty +Integer.parseInt(ws.getString(10));
							}
							
							/*
							DataBase Indexing
							
							1. -------->		Item Name
							2. -------->		Supplier Name
							3. -------->		Po No
							4. -------->		PO Date
							5. -------->		Cost Wth Tax
							6. -------->		Rate Wth Tax
							7. -------->		Order Qty
							8. -------->		Challan Dtl [  COUNT(DISTINCT HSTNUM_STORE_ID) || ''#'' || NVL(TO_CHAR(MAX(HSTDT_CHALLAN_DATE),''DD-Mon-YYYY''),''-'')
			                    || ''#'' || NVL(date_part(''day'',MAX(HSTDT_CHALLAN_DATE) - MAX(HSTDT_PO_DATE))::int,0)]
							9. -------->		ACCp Qty
							10. -------->		Balance Qty				
							
							*/
					
							sb.append("<tr>");
							sb.append("<td  width='5%' align='center'>");							
							sb.append(j);									//	S.No				
							sb.append("</td>");
							sb.append("<td  width='21%' align=''>");
							sb.append(ws.getString(1));				//	Item
							sb.append("</td>");
							sb.append("<td  width='19%'>");
							sb.append(ws.getString(2));								//	Supplier
							sb.append("</td>");
							sb.append("<td  width='15%'>");								
							sb.append(ws.getString(3)+"/"+ws.getString(4));									//	PO No Date					
							sb.append("</td>");
							sb.append("<td  width='8%' >");
							sb.append(ws.getString(6));									//	Rate Wth Tax
							sb.append("</td>");
							
							sb.append("<td  width='8%' align='right'>");								// Cost
							sb.append(ws.getString(5));									
							sb.append("</td>");
							
							sb.append("<td  width='8%' align='right'>");
							sb.append(ws.getString(7));									//	PO Qty
							sb.append("</td>");
							sb.append("<td  width='8%' align='right'>");
							sb.append(ws.getString(9));									//	Accp Qty
							sb.append("</td>");
							sb.append("<td  width='8%' align='right'>");
							sb.append(ws.getString(10));									//	Balance Qty
							sb.append("</td>");
							
							sb.append("</tr>");
							i++;
							j++;
							
				}
				
							sb.append("<tr background-color='red'>");
							sb.append("<td  colspan='5' align='right'>");
							sb.append("<b>");
							sb.append("Total ::");
							sb.append("</b>");
							sb.append("</td>");
							sb.append("<td align='right'>");
							sb.append("<b>"+Math.round(totamt)+"</b>");											
							sb.append("</td>");
							sb.append("<td align='right'>");
							sb.append("<b>"+Math.round(poQty)+"</b>");											
							sb.append("</td>");
							sb.append("<td align='right'>");
							sb.append("<b>"+Math.round(accpQty)+"</b>");											
							sb.append("</td>");
							sb.append("<td align='right'>");
							sb.append("<b>"+Math.round(balanceQty)+"</b>");											
							sb.append("</td>");
							sb.append("</tr>");
							
						
				
				sb.append("</table>");
			}
		else
		{
		 	sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='white' cellpadding='1px' border='1px solid black' style='border-collapse:collapse;'>");		
			sb.append("<td ><font color='red'>No Record Found</font></td>");
			sb.append("</tr>");
			sb.append("</table>");
		}
	   } 
		
	 }
	 catch(Exception e)
	 {
		    e.printStackTrace();
		    new HisException("Local Purchase Report","BreakageItemDtlTransHLP.getBreakageDetails()-->",e.getMessage());
	  }
	     //System.out.println("sb"+sb);
	    return sb.toString();
	}


}
