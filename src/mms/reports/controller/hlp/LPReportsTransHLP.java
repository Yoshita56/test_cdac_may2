package mms.reports.controller.hlp;

import hisglobal.utility.HisUtil;

import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import mms.reports.controller.fb.LPReportsTransFB;
import mms.reports.vo.LPReportsTransVO;

public class LPReportsTransHLP 
{
	
	public static String reportHLP(LPReportsTransVO vo,String reportHeader, HttpServletRequest request,LPReportsTransFB formBean) throws Exception {
		//WebRowSet wsItem = null;
		StringBuffer br = new StringBuffer(2000);
		
		WebRowSet ws1=null;
		
		int i=0;
		String curSubStoreName="";
		String preSubStoreName="";
		
		String curSupplierName="";
		String preSupplierName="";
		int count=0;
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		

		double totalCost = 0;
		double subGrpTotalInHandQty = 0;
		double subGroupTotalCost = 0;
			
		
		HisUtil util = new HisUtil("MMS Transactions", "IssueDetailRptHLP");
		try 
		{
				ws1 = vo.getLpDtlsWs(); 
				//make header
				br.append("<div id='wrapper' align='center'>");
				
				br.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
						+ " <tr> "
						+ " <td colspan='3'></td>"
						+ " <td colspan='3'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>"						
						+ " <td colspan='2'><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' /></div></td>");
				br.append("</tr>");
				
				br.append("</table>");
				
				
				br.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");						
					
				br.append(" <tr> "
				        + " <td align='center' colspan='3'></td>"
						+ " <td align='center' colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><b>Stock In-Hand Report</b></font></td>"
						+ " <td align='center' colspan='2'></td>");
				br.append("</tr>");
				
				br.append(" <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Supplier Name ::<b>"+formBean.getStrSupplierName()+"</b></font></td><td align='center' colspan='2'></td></tr>");
		
						
				br.append("<tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "From Date ::<b>"+vo.getStrFromDate()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
						
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "To Date ::<b>"+vo.getStrToDate()+"</b></font></td><td align='center' colspan='2'></td></tr>"
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "Report Date & Time  ::<b>"+formBean.getStrCurrentDate()+"</b></font></td><td align='center' colspan='2'></td></tr>"
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "By User  ::<b>"+formBean.getStrUserName()+"</b></font></td><td align='center' colspan='2'></td></tr>"+
						
					
											
						 "</table> <br>");
				
				br.append("<table  width='100%'  align='center' cellspacing='0px' cellpadding='1px' border='1px'>");
			
				br.append("<tr id='tableHeaderId' style='background-color:#D3D3D3;'>");
				
				br.append("<th colspan='1' height='30' style='width: 5%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> S.No. </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:25%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Req No / Date </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:15%; color:black;'	align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Gen By Store</strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:20%; color:black;'	align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> PO No(Date)</strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:10%; color:black;'	align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Category</strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:15%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Po Type </strong></font></th>");
				br.append("</tr>");
				
				
					if (ws1.size() > 0) 
					{				
		
						while (ws1.next()) 
						{
							
							
								//groupTotalCose+=Double.parseDouble(ws1.getString("12"));
							     curSupplierName = ws1.getString(8);
								
								/*
							    1.Indent No
							    2.Indent Date - gene By
							    3.Indent Chk value D.HSTNUM_REQ_NO 
									|| ''@'' || D.HSTNUM_STORE_ID  
									|| ''@'' || D.SSTNUM_REQTYPE_ID 
									|| ''@'' || D.SSTNUM_ITEM_CAT_NO 
									|| ''@'' || D.HSTNUM_URGENT_FLAG 
									|| ''@'' || D.HSTSTR_INDENT_PERIOD
									|| ''@'' ||D.HSTNUM_TOSTORE_ID
								  4.Raising Store Name
								  5.PO Dtls ( Supp_Name $ PO No (Date) $ Catg Name $ Po Type $ RC Dtls)
								  6.PO Net Amount
								  7.Report Generated By 
							  */
							
								
								if(!curSupplierName.equals(preSupplierName))
								{
									br.append("<tr>");
									br.append("<td colspan='6' style=\"text-align:left; width:5%;\"><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><b> "+curSupplierName+ "</b></font></td>");
									br.append("</tr>");
								}
								//preGroupName=curGroupName;
								
								/*
							    1.Indent No
							    2.Indent Date - gene By
							    3.Indent Chk value D.HSTNUM_REQ_NO 
									|| ''@'' || D.HSTNUM_STORE_ID  
									|| ''@'' || D.SSTNUM_REQTYPE_ID 
									|| ''@'' || D.SSTNUM_ITEM_CAT_NO 
									|| ''@'' || D.HSTNUM_URGENT_FLAG 
									|| ''@'' || D.HSTSTR_INDENT_PERIOD
									|| ''@'' ||D.HSTNUM_TOSTORE_ID
								  4.Raising Store Name
								  5.PO Dtls ( Supp_Name $ PO No (Date) $ Catg Name $ Po Type $ RC Dtls)
								  6.PO Net Amount
								  7.Report Generated By 
							  */
								
							br.append("<tr>");
							br.append("<input type='hidden' name ='strHiddenValue' id ='strHiddenValue"+i+"' value='"+ws1.getString(3)+"'>");
						    br.append("<td colspan='1' height='20' style=\"text-align:center;   width: 5%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ (i+1) + "</font></td>");
						    br.append("<td colspan='1' height='20' style=\"text-align:left;     width:25%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><a style='color:blue;cursor: pointer;' onclick='getVoucher("+i+");'>"+ ws1.getString(1) +"/"+ ws1.getString(2)+ "</font></td>");
						    br.append("<td colspan='1' height='20' style=\"text-align:center;   width:15%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(4) + "</font></td>");
						    br.append("<td colspan='1' height='20' style=\"text-align:center;   width:20%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(5).split("\\$")[1] + "</font></td>");
						    br.append("<td colspan='1' height='20' style=\"text-align:center;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(5).split("\\$")[2] + "</font></td>");
						    br.append("<td colspan='1' height='20' style=\"text-align:left;     width:15%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(5).split("\\$")[3] + "</font></td>");					    

						    
						    br.append("</tr>");
							
				
							count++;
							i++;
							
							preSupplierName=curSupplierName;
							
					  }
					 
					}
					else 
					{
					br.append("<tr>");
					br.append("<td colspan='6'   height='30' style=\"color: black; font-weight: bold;\" width='100%' align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong>No Data Found</strong></font></td>");
					br.append("</tr>");
				
					}					
					i=i++;					
					br.append("</table><br><br>");
			} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ws1 != null) {
				ws1.close();
				ws1 = null;
			}

		}
		vo.setStrTableWidth(String.valueOf("100"));
		return (br.toString()+"</div>");
	}

}
